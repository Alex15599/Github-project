package com.dt.platform.common.controller;

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


import com.dt.platform.proxy.common.AutoUserPredefinedServiceProxy;
import com.dt.platform.domain.common.meta.AutoUserPredefinedVOMeta;
import com.dt.platform.domain.common.AutoUserPredefined;
import com.dt.platform.domain.common.AutoUserPredefinedVO;
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
import com.dt.platform.domain.common.meta.AutoUserPredefinedMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IAutoUserPredefinedService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 预定用户接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:15:43
*/

@InDoc
@Api(tags = "预定用户")
@RestController("SysAutoUserPredefinedController")
public class AutoUserPredefinedController extends SuperController {

	@Autowired
	private IAutoUserPredefinedService autoUserPredefinedService;


	/**
	 * 添加预定用户
	*/
	@ApiOperation(value = "添加预定用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoUserPredefinedVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AutoUserPredefinedVOMeta.ACCOUNT , value = "用户" , required = false , dataTypeClass=String.class , example = "admin"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoUserPredefinedServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoUserPredefinedServiceProxy.INSERT)
	public Result insert(AutoUserPredefinedVO autoUserPredefinedVO) {
		Result result=autoUserPredefinedService.insert(autoUserPredefinedVO,false);
		return result;
	}



	/**
	 * 删除预定用户
	*/
	@ApiOperation(value = "删除预定用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoUserPredefinedVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoUserPredefinedServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoUserPredefinedServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  autoUserPredefinedService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=autoUserPredefinedService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除预定用户 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除预定用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoUserPredefinedVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AutoUserPredefinedServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoUserPredefinedServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = autoUserPredefinedService.hasRefers(ids);
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
			Result result=autoUserPredefinedService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=autoUserPredefinedService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新预定用户
	*/
	@ApiOperation(value = "更新预定用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoUserPredefinedVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AutoUserPredefinedVOMeta.ACCOUNT , value = "用户" , required = false , dataTypeClass=String.class , example = "admin"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AutoUserPredefinedVOMeta.PAGE_INDEX , AutoUserPredefinedVOMeta.PAGE_SIZE , AutoUserPredefinedVOMeta.SEARCH_FIELD , AutoUserPredefinedVOMeta.FUZZY_FIELD , AutoUserPredefinedVOMeta.SEARCH_VALUE , AutoUserPredefinedVOMeta.DIRTY_FIELDS , AutoUserPredefinedVOMeta.SORT_FIELD , AutoUserPredefinedVOMeta.SORT_TYPE , AutoUserPredefinedVOMeta.DATA_ORIGIN , AutoUserPredefinedVOMeta.QUERY_LOGIC , AutoUserPredefinedVOMeta.IDS } )
	@SentinelResource(value = AutoUserPredefinedServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoUserPredefinedServiceProxy.UPDATE)
	public Result update(AutoUserPredefinedVO autoUserPredefinedVO) {
		Result result=autoUserPredefinedService.update(autoUserPredefinedVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存预定用户
	*/
	@ApiOperation(value = "保存预定用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoUserPredefinedVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AutoUserPredefinedVOMeta.ACCOUNT , value = "用户" , required = false , dataTypeClass=String.class , example = "admin"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AutoUserPredefinedVOMeta.PAGE_INDEX , AutoUserPredefinedVOMeta.PAGE_SIZE , AutoUserPredefinedVOMeta.SEARCH_FIELD , AutoUserPredefinedVOMeta.FUZZY_FIELD , AutoUserPredefinedVOMeta.SEARCH_VALUE , AutoUserPredefinedVOMeta.DIRTY_FIELDS , AutoUserPredefinedVOMeta.SORT_FIELD , AutoUserPredefinedVOMeta.SORT_TYPE , AutoUserPredefinedVOMeta.DATA_ORIGIN , AutoUserPredefinedVOMeta.QUERY_LOGIC , AutoUserPredefinedVOMeta.IDS } )
	@SentinelResource(value = AutoUserPredefinedServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoUserPredefinedServiceProxy.SAVE)
	public Result save(AutoUserPredefinedVO autoUserPredefinedVO) {
		Result result=autoUserPredefinedService.save(autoUserPredefinedVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取预定用户
	*/
	@ApiOperation(value = "获取预定用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoUserPredefinedVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoUserPredefinedServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoUserPredefinedServiceProxy.GET_BY_ID)
	public Result<AutoUserPredefined> getById(String id) {
		Result<AutoUserPredefined> result=new Result<>();
		AutoUserPredefined autoUserPredefined=autoUserPredefinedService.getById(id);
		result.success(true).data(autoUserPredefined);
		return result;
	}


	/**
	 * 批量获取预定用户 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取预定用户")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AutoUserPredefinedVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AutoUserPredefinedServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoUserPredefinedServiceProxy.GET_BY_IDS)
	public Result<List<AutoUserPredefined>> getByIds(List<String> ids) {
		Result<List<AutoUserPredefined>> result=new Result<>();
		List<AutoUserPredefined> list=autoUserPredefinedService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询预定用户
	*/
	@ApiOperation(value = "查询预定用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoUserPredefinedVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AutoUserPredefinedVOMeta.ACCOUNT , value = "用户" , required = false , dataTypeClass=String.class , example = "admin"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AutoUserPredefinedVOMeta.PAGE_INDEX , AutoUserPredefinedVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AutoUserPredefinedServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoUserPredefinedServiceProxy.QUERY_LIST)
	public Result<List<AutoUserPredefined>> queryList(AutoUserPredefinedVO sample) {
		Result<List<AutoUserPredefined>> result=new Result<>();
		List<AutoUserPredefined> list=autoUserPredefinedService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询预定用户
	*/
	@ApiOperation(value = "分页查询预定用户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoUserPredefinedVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AutoUserPredefinedVOMeta.ACCOUNT , value = "用户" , required = false , dataTypeClass=String.class , example = "admin"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoUserPredefinedServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoUserPredefinedServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AutoUserPredefined>> queryPagedList(AutoUserPredefinedVO sample) {
		Result<PagedList<AutoUserPredefined>> result=new Result<>();
		PagedList<AutoUserPredefined> list=autoUserPredefinedService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}