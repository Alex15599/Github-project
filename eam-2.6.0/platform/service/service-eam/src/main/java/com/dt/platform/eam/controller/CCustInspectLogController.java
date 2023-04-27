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


import com.dt.platform.proxy.eam.CCustInspectLogServiceProxy;
import com.dt.platform.domain.eam.meta.CCustInspectLogVOMeta;
import com.dt.platform.domain.eam.CCustInspectLog;
import com.dt.platform.domain.eam.CCustInspectLogVO;
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
import com.dt.platform.domain.eam.meta.CCustInspectLogMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICCustInspectLogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 执行日志接口控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-04-10 10:17:17
*/

@InDoc
@Api(tags = "执行日志")
@RestController("EamCCustInspectLogController")
public class CCustInspectLogController extends SuperController {

	@Autowired
	private ICCustInspectLogService cCustInspectLogService;

	/**
	 * 添加执行日志
	*/
	@ApiOperation(value = "添加执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.PLAN_ID , value = "计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.EXECUTE_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.EXECUTED , value = "是否已经执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.ERRORS , value = "执行错误" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = CCustInspectLogServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectLogServiceProxy.INSERT)
	public Result insert(CCustInspectLogVO cCustInspectLogVO) {
		
		Result result=cCustInspectLogService.insert(cCustInspectLogVO,false);
		return result;
	}



	/**
	 * 删除执行日志
	*/
	@ApiOperation(value = "删除执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = CCustInspectLogServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectLogServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  cCustInspectLogService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=cCustInspectLogService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除执行日志 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
	@SentinelResource(value = CCustInspectLogServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectLogServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = cCustInspectLogService.hasRefers(ids);
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
			Result result=cCustInspectLogService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=cCustInspectLogService.deleteByIdsLogical(canDeleteIds);
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
		@ApiImplicitParam(name = CCustInspectLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.PLAN_ID , value = "计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.EXECUTE_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.EXECUTED , value = "是否已经执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.ERRORS , value = "执行错误" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { CCustInspectLogVOMeta.PAGE_INDEX , CCustInspectLogVOMeta.PAGE_SIZE , CCustInspectLogVOMeta.SEARCH_FIELD , CCustInspectLogVOMeta.FUZZY_FIELD , CCustInspectLogVOMeta.SEARCH_VALUE , CCustInspectLogVOMeta.DIRTY_FIELDS , CCustInspectLogVOMeta.SORT_FIELD , CCustInspectLogVOMeta.SORT_TYPE , CCustInspectLogVOMeta.DATA_ORIGIN , CCustInspectLogVOMeta.QUERY_LOGIC , CCustInspectLogVOMeta.REQUEST_ACTION , CCustInspectLogVOMeta.IDS } )
	@SentinelResource(value = CCustInspectLogServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectLogServiceProxy.UPDATE)
	public Result update(CCustInspectLogVO cCustInspectLogVO) {
		
		Result result=cCustInspectLogService.update(cCustInspectLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存执行日志
	*/
	@ApiOperation(value = "保存执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.PLAN_ID , value = "计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.EXECUTE_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.EXECUTED , value = "是否已经执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.ERRORS , value = "执行错误" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CCustInspectLogVOMeta.PAGE_INDEX , CCustInspectLogVOMeta.PAGE_SIZE , CCustInspectLogVOMeta.SEARCH_FIELD , CCustInspectLogVOMeta.FUZZY_FIELD , CCustInspectLogVOMeta.SEARCH_VALUE , CCustInspectLogVOMeta.DIRTY_FIELDS , CCustInspectLogVOMeta.SORT_FIELD , CCustInspectLogVOMeta.SORT_TYPE , CCustInspectLogVOMeta.DATA_ORIGIN , CCustInspectLogVOMeta.QUERY_LOGIC , CCustInspectLogVOMeta.REQUEST_ACTION , CCustInspectLogVOMeta.IDS } )
	@SentinelResource(value = CCustInspectLogServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectLogServiceProxy.SAVE)
	public Result save(CCustInspectLogVO cCustInspectLogVO) {
		
		Result result=cCustInspectLogService.save(cCustInspectLogVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取执行日志
	*/
	@ApiOperation(value = "获取执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = CCustInspectLogServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectLogServiceProxy.GET_BY_ID)
	public Result<CCustInspectLog> getById(String id) {
		
		Result<CCustInspectLog> result=new Result<>();
		CCustInspectLog cCustInspectLog=cCustInspectLogService.getById(id);
		result.success(true).data(cCustInspectLog);
		return result;
	}


	/**
	 * 批量获取执行日志 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取执行日志")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CCustInspectLogVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="李方捷 , leefangjie@qq.com") 
		@SentinelResource(value = CCustInspectLogServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectLogServiceProxy.GET_BY_IDS)
	public Result<List<CCustInspectLog>> getByIds(List<String> ids) {
		
		Result<List<CCustInspectLog>> result=new Result<>();
		List<CCustInspectLog> list=cCustInspectLogService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询执行日志
	*/
	@ApiOperation(value = "查询执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.PLAN_ID , value = "计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.EXECUTE_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.EXECUTED , value = "是否已经执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.ERRORS , value = "执行错误" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="李方捷 , leefangjie@qq.com" ,  ignoreParameters = { CCustInspectLogVOMeta.PAGE_INDEX , CCustInspectLogVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CCustInspectLogServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectLogServiceProxy.QUERY_LIST)
	public Result<List<CCustInspectLog>> queryList(CCustInspectLogVO sample) {
		
		Result<List<CCustInspectLog>> result=new Result<>();
		List<CCustInspectLog> list=cCustInspectLogService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询执行日志
	*/
	@ApiOperation(value = "分页查询执行日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectLogVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.PLAN_ID , value = "计划" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.EXECUTE_TIME , value = "执行时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.EXECUTED , value = "是否已经执行" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = CCustInspectLogVOMeta.ERRORS , value = "执行错误" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="李方捷 , leefangjie@qq.com")
	@SentinelResource(value = CCustInspectLogServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectLogServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CCustInspectLog>> queryPagedList(CCustInspectLogVO sample) {
		
		Result<PagedList<CCustInspectLog>> result=new Result<>();
		PagedList<CCustInspectLog> list=cCustInspectLogService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}