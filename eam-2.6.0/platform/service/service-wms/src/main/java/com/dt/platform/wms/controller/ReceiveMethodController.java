package com.dt.platform.wms.controller;

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


import com.dt.platform.proxy.wms.ReceiveMethodServiceProxy;
import com.dt.platform.domain.wms.meta.ReceiveMethodVOMeta;
import com.dt.platform.domain.wms.ReceiveMethod;
import com.dt.platform.domain.wms.ReceiveMethodVO;
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
import com.dt.platform.domain.wms.meta.ReceiveMethodMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IReceiveMethodService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 接货方式接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:30:14
*/

@InDoc
@Api(tags = "接货方式")
@RestController("WmsReceiveMethodController")
public class ReceiveMethodController extends SuperController {

	@Autowired
	private IReceiveMethodService receiveMethodService;

	/**
	 * 添加接货方式
	*/
	@ApiOperation(value = "添加接货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReceiveMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ReceiveMethodServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReceiveMethodServiceProxy.INSERT)
	public Result insert(ReceiveMethodVO receiveMethodVO) {
		
		Result result=receiveMethodService.insert(receiveMethodVO,false);
		return result;
	}



	/**
	 * 删除接货方式
	*/
	@ApiOperation(value = "删除接货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReceiveMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ReceiveMethodServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReceiveMethodServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  receiveMethodService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=receiveMethodService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除接货方式 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除接货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReceiveMethodVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ReceiveMethodServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReceiveMethodServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = receiveMethodService.hasRefers(ids);
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
			Result result=receiveMethodService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=receiveMethodService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新接货方式
	*/
	@ApiOperation(value = "更新接货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReceiveMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ReceiveMethodVOMeta.PAGE_INDEX , ReceiveMethodVOMeta.PAGE_SIZE , ReceiveMethodVOMeta.SEARCH_FIELD , ReceiveMethodVOMeta.FUZZY_FIELD , ReceiveMethodVOMeta.SEARCH_VALUE , ReceiveMethodVOMeta.DIRTY_FIELDS , ReceiveMethodVOMeta.SORT_FIELD , ReceiveMethodVOMeta.SORT_TYPE , ReceiveMethodVOMeta.DATA_ORIGIN , ReceiveMethodVOMeta.QUERY_LOGIC , ReceiveMethodVOMeta.REQUEST_ACTION , ReceiveMethodVOMeta.IDS } )
	@SentinelResource(value = ReceiveMethodServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReceiveMethodServiceProxy.UPDATE)
	public Result update(ReceiveMethodVO receiveMethodVO) {
		
		Result result=receiveMethodService.update(receiveMethodVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存接货方式
	*/
	@ApiOperation(value = "保存接货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReceiveMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ReceiveMethodVOMeta.PAGE_INDEX , ReceiveMethodVOMeta.PAGE_SIZE , ReceiveMethodVOMeta.SEARCH_FIELD , ReceiveMethodVOMeta.FUZZY_FIELD , ReceiveMethodVOMeta.SEARCH_VALUE , ReceiveMethodVOMeta.DIRTY_FIELDS , ReceiveMethodVOMeta.SORT_FIELD , ReceiveMethodVOMeta.SORT_TYPE , ReceiveMethodVOMeta.DATA_ORIGIN , ReceiveMethodVOMeta.QUERY_LOGIC , ReceiveMethodVOMeta.REQUEST_ACTION , ReceiveMethodVOMeta.IDS } )
	@SentinelResource(value = ReceiveMethodServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReceiveMethodServiceProxy.SAVE)
	public Result save(ReceiveMethodVO receiveMethodVO) {
		
		Result result=receiveMethodService.save(receiveMethodVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取接货方式
	*/
	@ApiOperation(value = "获取接货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReceiveMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ReceiveMethodServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReceiveMethodServiceProxy.GET_BY_ID)
	public Result<ReceiveMethod> getById(String id) {
		
		Result<ReceiveMethod> result=new Result<>();
		ReceiveMethod receiveMethod=receiveMethodService.getById(id);
		result.success(true).data(receiveMethod);
		return result;
	}


	/**
	 * 批量获取接货方式 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取接货方式")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ReceiveMethodVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ReceiveMethodServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReceiveMethodServiceProxy.GET_BY_IDS)
	public Result<List<ReceiveMethod>> getByIds(List<String> ids) {
		
		Result<List<ReceiveMethod>> result=new Result<>();
		List<ReceiveMethod> list=receiveMethodService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询接货方式
	*/
	@ApiOperation(value = "查询接货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReceiveMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ReceiveMethodVOMeta.PAGE_INDEX , ReceiveMethodVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ReceiveMethodServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReceiveMethodServiceProxy.QUERY_LIST)
	public Result<List<ReceiveMethod>> queryList(ReceiveMethodVO sample) {
		
		Result<List<ReceiveMethod>> result=new Result<>();
		List<ReceiveMethod> list=receiveMethodService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询接货方式
	*/
	@ApiOperation(value = "分页查询接货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ReceiveMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ReceiveMethodVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ReceiveMethodServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ReceiveMethodServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ReceiveMethod>> queryPagedList(ReceiveMethodVO sample) {
		
		Result<PagedList<ReceiveMethod>> result=new Result<>();
		PagedList<ReceiveMethod> list=receiveMethodService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}