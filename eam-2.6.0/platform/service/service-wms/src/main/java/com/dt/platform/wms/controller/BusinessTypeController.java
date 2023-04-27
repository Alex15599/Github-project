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


import com.dt.platform.proxy.wms.BusinessTypeServiceProxy;
import com.dt.platform.domain.wms.meta.BusinessTypeVOMeta;
import com.dt.platform.domain.wms.BusinessType;
import com.dt.platform.domain.wms.BusinessTypeVO;
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
import com.dt.platform.domain.wms.meta.BusinessTypeMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IBusinessTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 业务类型接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:28:12
*/

@InDoc
@Api(tags = "业务类型")
@RestController("WmsBusinessTypeController")
public class BusinessTypeController extends SuperController {

	@Autowired
	private IBusinessTypeService businessTypeService;

	/**
	 * 添加业务类型
	*/
	@ApiOperation(value = "添加业务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusinessTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BusinessTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusinessTypeServiceProxy.INSERT)
	public Result insert(BusinessTypeVO businessTypeVO) {
		
		Result result=businessTypeService.insert(businessTypeVO,false);
		return result;
	}



	/**
	 * 删除业务类型
	*/
	@ApiOperation(value = "删除业务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusinessTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BusinessTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusinessTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  businessTypeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=businessTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除业务类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除业务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusinessTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = BusinessTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusinessTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = businessTypeService.hasRefers(ids);
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
			Result result=businessTypeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=businessTypeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新业务类型
	*/
	@ApiOperation(value = "更新业务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusinessTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { BusinessTypeVOMeta.PAGE_INDEX , BusinessTypeVOMeta.PAGE_SIZE , BusinessTypeVOMeta.SEARCH_FIELD , BusinessTypeVOMeta.FUZZY_FIELD , BusinessTypeVOMeta.SEARCH_VALUE , BusinessTypeVOMeta.DIRTY_FIELDS , BusinessTypeVOMeta.SORT_FIELD , BusinessTypeVOMeta.SORT_TYPE , BusinessTypeVOMeta.DATA_ORIGIN , BusinessTypeVOMeta.QUERY_LOGIC , BusinessTypeVOMeta.REQUEST_ACTION , BusinessTypeVOMeta.IDS } )
	@SentinelResource(value = BusinessTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusinessTypeServiceProxy.UPDATE)
	public Result update(BusinessTypeVO businessTypeVO) {
		
		Result result=businessTypeService.update(businessTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存业务类型
	*/
	@ApiOperation(value = "保存业务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusinessTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BusinessTypeVOMeta.PAGE_INDEX , BusinessTypeVOMeta.PAGE_SIZE , BusinessTypeVOMeta.SEARCH_FIELD , BusinessTypeVOMeta.FUZZY_FIELD , BusinessTypeVOMeta.SEARCH_VALUE , BusinessTypeVOMeta.DIRTY_FIELDS , BusinessTypeVOMeta.SORT_FIELD , BusinessTypeVOMeta.SORT_TYPE , BusinessTypeVOMeta.DATA_ORIGIN , BusinessTypeVOMeta.QUERY_LOGIC , BusinessTypeVOMeta.REQUEST_ACTION , BusinessTypeVOMeta.IDS } )
	@SentinelResource(value = BusinessTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusinessTypeServiceProxy.SAVE)
	public Result save(BusinessTypeVO businessTypeVO) {
		
		Result result=businessTypeService.save(businessTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取业务类型
	*/
	@ApiOperation(value = "获取业务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusinessTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BusinessTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusinessTypeServiceProxy.GET_BY_ID)
	public Result<BusinessType> getById(String id) {
		
		Result<BusinessType> result=new Result<>();
		BusinessType businessType=businessTypeService.getById(id);
		result.success(true).data(businessType);
		return result;
	}


	/**
	 * 批量获取业务类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取业务类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = BusinessTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = BusinessTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusinessTypeServiceProxy.GET_BY_IDS)
	public Result<List<BusinessType>> getByIds(List<String> ids) {
		
		Result<List<BusinessType>> result=new Result<>();
		List<BusinessType> list=businessTypeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询业务类型
	*/
	@ApiOperation(value = "查询业务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusinessTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { BusinessTypeVOMeta.PAGE_INDEX , BusinessTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = BusinessTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusinessTypeServiceProxy.QUERY_LIST)
	public Result<List<BusinessType>> queryList(BusinessTypeVO sample) {
		
		Result<List<BusinessType>> result=new Result<>();
		List<BusinessType> list=businessTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询业务类型
	*/
	@ApiOperation(value = "分页查询业务类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BusinessTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BusinessTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BusinessTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BusinessTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<BusinessType>> queryPagedList(BusinessTypeVO sample) {
		
		Result<PagedList<BusinessType>> result=new Result<>();
		PagedList<BusinessType> list=businessTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}