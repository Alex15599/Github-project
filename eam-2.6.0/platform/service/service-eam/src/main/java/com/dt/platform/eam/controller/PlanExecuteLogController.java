package com.dt.platform.eam.controller;

import java.util.*;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.eam.PlanExecuteLogServiceProxy;
import com.dt.platform.domain.eam.meta.PlanExecuteLogVOMeta;
import com.dt.platform.domain.eam.PlanExecuteLog;
import com.dt.platform.domain.eam.PlanExecuteLogVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.excel.ExcelWriter;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;
import java.util.Date;
import java.sql.Timestamp;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.commons.io.StreamUtil;
import java.util.Map;
import com.github.foxnic.dao.excel.ValidateResult;
import java.io.InputStream;
import com.dt.platform.domain.eam.meta.PlanExecuteLogMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IPlanExecuteLogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 执行日志接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-11 13:35:39
*/

@InDoc
@Api(tags = "执行日志")
@RestController("EamPlanExecuteLogController")
public class PlanExecuteLogController extends SuperController {

	@Autowired
	private IPlanExecuteLogService planExecuteLogService;

	/**
	 * 添加执行日志
	*/
	@ApiOperation(value = "添加执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.PLAN_ID , value = "计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.EXECUTE_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.EXECUTED , value = "是否已经执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.ERRORS , value = "执行错误" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PlanExecuteLogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PlanExecuteLogServiceProxy.INSERT)
	public Result insert(PlanExecuteLogVO planExecuteLogVO) {
		
		Result result=planExecuteLogService.insert(planExecuteLogVO,false);
		return result;
	}



	/**
	 * 删除执行日志
	*/
	@ApiOperation(value = "删除执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PlanExecuteLogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PlanExecuteLogServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  planExecuteLogService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=planExecuteLogService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除执行日志 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = PlanExecuteLogServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PlanExecuteLogServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = planExecuteLogService.hasRefers(ids);
		// 收集可以删除的ID值
		List<String> canDeleteIds = new ArrayList<>();
		for (Map.Entry<String, ReferCause> e : causeMap.entrySet()) {
			if (!e.getValue().hasRefer()) {
				canDeleteIds.add(e.getKey());
			}
		}

		// 执行删除
		if (canDeleteIds.isEmpty()) {
			// 如果没有一行可以被删除
			return ErrorDesc.failure().message("无法删除您选中的数据行：").data(0)
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
		} else if (canDeleteIds.size() == ids.size()) {
			// 如果全部可以删除
			Result result=planExecuteLogService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=planExecuteLogService.deleteByIdsLogical(canDeleteIds);
			if (result.failure()) {
				return result;
			} else {
				return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").data(canDeleteIds.size())
				.addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(),(e)->{return e.hasRefer();}),ReferCause::message,String.class))
				.messageLevel4Confirm();
			}
		} else {
			// 理论上，这个分支不存在
			return ErrorDesc.success().message("数据删除未处理");
		}
	}

	/**
	 * 更新执行日志
	*/
	@ApiOperation(value = "更新执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.PLAN_ID , value = "计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.EXECUTE_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.EXECUTED , value = "是否已经执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.ERRORS , value = "执行错误" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PlanExecuteLogVOMeta.PAGE_INDEX , PlanExecuteLogVOMeta.PAGE_SIZE , PlanExecuteLogVOMeta.SEARCH_FIELD , PlanExecuteLogVOMeta.FUZZY_FIELD , PlanExecuteLogVOMeta.SEARCH_VALUE , PlanExecuteLogVOMeta.DIRTY_FIELDS , PlanExecuteLogVOMeta.SORT_FIELD , PlanExecuteLogVOMeta.SORT_TYPE , PlanExecuteLogVOMeta.DATA_ORIGIN , PlanExecuteLogVOMeta.QUERY_LOGIC , PlanExecuteLogVOMeta.REQUEST_ACTION , PlanExecuteLogVOMeta.IDS } )
	@SentinelResource(value = PlanExecuteLogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PlanExecuteLogServiceProxy.UPDATE)
	public Result update(PlanExecuteLogVO planExecuteLogVO) {
		
		Result result=planExecuteLogService.update(planExecuteLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存执行日志
	*/
	@ApiOperation(value = "保存执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.PLAN_ID , value = "计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.EXECUTE_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.EXECUTED , value = "是否已经执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.ERRORS , value = "执行错误" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { PlanExecuteLogVOMeta.PAGE_INDEX , PlanExecuteLogVOMeta.PAGE_SIZE , PlanExecuteLogVOMeta.SEARCH_FIELD , PlanExecuteLogVOMeta.FUZZY_FIELD , PlanExecuteLogVOMeta.SEARCH_VALUE , PlanExecuteLogVOMeta.DIRTY_FIELDS , PlanExecuteLogVOMeta.SORT_FIELD , PlanExecuteLogVOMeta.SORT_TYPE , PlanExecuteLogVOMeta.DATA_ORIGIN , PlanExecuteLogVOMeta.QUERY_LOGIC , PlanExecuteLogVOMeta.REQUEST_ACTION , PlanExecuteLogVOMeta.IDS } )
	@SentinelResource(value = PlanExecuteLogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PlanExecuteLogServiceProxy.SAVE)
	public Result save(PlanExecuteLogVO planExecuteLogVO) {
		
		Result result=planExecuteLogService.save(planExecuteLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取执行日志
	*/
	@ApiOperation(value = "获取执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PlanExecuteLogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PlanExecuteLogServiceProxy.GET_BY_ID)
	public Result<PlanExecuteLog> getById(String id) {
		
		Result<PlanExecuteLog> result=new Result<>();
		PlanExecuteLog planExecuteLog=planExecuteLogService.getById(id);
		result.success(true).data(planExecuteLog);
		return result;
	}


	/**
	 * 批量获取执行日志 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取执行日志")
		@ApiImplicitParams({
				@ApiImplicitParam(name = PlanExecuteLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = PlanExecuteLogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PlanExecuteLogServiceProxy.GET_BY_IDS)
	public Result<List<PlanExecuteLog>> getByIds(List<String> ids) {
		
		Result<List<PlanExecuteLog>> result=new Result<>();
		List<PlanExecuteLog> list=planExecuteLogService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询执行日志
	*/
	@ApiOperation(value = "查询执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.PLAN_ID , value = "计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.EXECUTE_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.EXECUTED , value = "是否已经执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.ERRORS , value = "执行错误" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { PlanExecuteLogVOMeta.PAGE_INDEX , PlanExecuteLogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = PlanExecuteLogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PlanExecuteLogServiceProxy.QUERY_LIST)
	public Result<List<PlanExecuteLog>> queryList(PlanExecuteLogVO sample) {
		
		Result<List<PlanExecuteLog>> result=new Result<>();
		List<PlanExecuteLog> list=planExecuteLogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询执行日志
	*/
	@ApiOperation(value = "分页查询执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.PLAN_ID , value = "计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.EXECUTE_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.EXECUTED , value = "是否已经执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = PlanExecuteLogVOMeta.ERRORS , value = "执行错误" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = PlanExecuteLogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(PlanExecuteLogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<PlanExecuteLog>> queryPagedList(PlanExecuteLogVO sample) {
		
		Result<PagedList<PlanExecuteLog>> result=new Result<>();
		PagedList<PlanExecuteLog> list=planExecuteLogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}