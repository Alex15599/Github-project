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


import com.dt.platform.proxy.wms.DeliveryMethodServiceProxy;
import com.dt.platform.domain.wms.meta.DeliveryMethodVOMeta;
import com.dt.platform.domain.wms.DeliveryMethod;
import com.dt.platform.domain.wms.DeliveryMethodVO;
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
import com.dt.platform.domain.wms.meta.DeliveryMethodMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IDeliveryMethodService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 提货方式接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:29:28
*/

@InDoc
@Api(tags = "提货方式")
@RestController("WmsDeliveryMethodController")
public class DeliveryMethodController extends SuperController {

	@Autowired
	private IDeliveryMethodService deliveryMethodService;

	/**
	 * 添加提货方式
	*/
	@ApiOperation(value = "添加提货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeliveryMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeliveryMethodServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeliveryMethodServiceProxy.INSERT)
	public Result insert(DeliveryMethodVO deliveryMethodVO) {
		
		Result result=deliveryMethodService.insert(deliveryMethodVO,false);
		return result;
	}



	/**
	 * 删除提货方式
	*/
	@ApiOperation(value = "删除提货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeliveryMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeliveryMethodServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeliveryMethodServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  deliveryMethodService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=deliveryMethodService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除提货方式 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除提货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeliveryMethodVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DeliveryMethodServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeliveryMethodServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = deliveryMethodService.hasRefers(ids);
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
			Result result=deliveryMethodService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=deliveryMethodService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新提货方式
	*/
	@ApiOperation(value = "更新提货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeliveryMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DeliveryMethodVOMeta.PAGE_INDEX , DeliveryMethodVOMeta.PAGE_SIZE , DeliveryMethodVOMeta.SEARCH_FIELD , DeliveryMethodVOMeta.FUZZY_FIELD , DeliveryMethodVOMeta.SEARCH_VALUE , DeliveryMethodVOMeta.DIRTY_FIELDS , DeliveryMethodVOMeta.SORT_FIELD , DeliveryMethodVOMeta.SORT_TYPE , DeliveryMethodVOMeta.DATA_ORIGIN , DeliveryMethodVOMeta.QUERY_LOGIC , DeliveryMethodVOMeta.REQUEST_ACTION , DeliveryMethodVOMeta.IDS } )
	@SentinelResource(value = DeliveryMethodServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeliveryMethodServiceProxy.UPDATE)
	public Result update(DeliveryMethodVO deliveryMethodVO) {
		
		Result result=deliveryMethodService.update(deliveryMethodVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存提货方式
	*/
	@ApiOperation(value = "保存提货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeliveryMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DeliveryMethodVOMeta.PAGE_INDEX , DeliveryMethodVOMeta.PAGE_SIZE , DeliveryMethodVOMeta.SEARCH_FIELD , DeliveryMethodVOMeta.FUZZY_FIELD , DeliveryMethodVOMeta.SEARCH_VALUE , DeliveryMethodVOMeta.DIRTY_FIELDS , DeliveryMethodVOMeta.SORT_FIELD , DeliveryMethodVOMeta.SORT_TYPE , DeliveryMethodVOMeta.DATA_ORIGIN , DeliveryMethodVOMeta.QUERY_LOGIC , DeliveryMethodVOMeta.REQUEST_ACTION , DeliveryMethodVOMeta.IDS } )
	@SentinelResource(value = DeliveryMethodServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeliveryMethodServiceProxy.SAVE)
	public Result save(DeliveryMethodVO deliveryMethodVO) {
		
		Result result=deliveryMethodService.save(deliveryMethodVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取提货方式
	*/
	@ApiOperation(value = "获取提货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeliveryMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeliveryMethodServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeliveryMethodServiceProxy.GET_BY_ID)
	public Result<DeliveryMethod> getById(String id) {
		
		Result<DeliveryMethod> result=new Result<>();
		DeliveryMethod deliveryMethod=deliveryMethodService.getById(id);
		result.success(true).data(deliveryMethod);
		return result;
	}


	/**
	 * 批量获取提货方式 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取提货方式")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DeliveryMethodVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DeliveryMethodServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeliveryMethodServiceProxy.GET_BY_IDS)
	public Result<List<DeliveryMethod>> getByIds(List<String> ids) {
		
		Result<List<DeliveryMethod>> result=new Result<>();
		List<DeliveryMethod> list=deliveryMethodService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询提货方式
	*/
	@ApiOperation(value = "查询提货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeliveryMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DeliveryMethodVOMeta.PAGE_INDEX , DeliveryMethodVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DeliveryMethodServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeliveryMethodServiceProxy.QUERY_LIST)
	public Result<List<DeliveryMethod>> queryList(DeliveryMethodVO sample) {
		
		Result<List<DeliveryMethod>> result=new Result<>();
		List<DeliveryMethod> list=deliveryMethodService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询提货方式
	*/
	@ApiOperation(value = "分页查询提货方式")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DeliveryMethodVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DeliveryMethodVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DeliveryMethodServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DeliveryMethodServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DeliveryMethod>> queryPagedList(DeliveryMethodVO sample) {
		
		Result<PagedList<DeliveryMethod>> result=new Result<>();
		PagedList<DeliveryMethod> list=deliveryMethodService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}