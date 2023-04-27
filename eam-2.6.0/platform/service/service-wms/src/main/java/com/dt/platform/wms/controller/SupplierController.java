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


import com.dt.platform.proxy.wms.SupplierServiceProxy;
import com.dt.platform.domain.wms.meta.SupplierVOMeta;
import com.dt.platform.domain.wms.Supplier;
import com.dt.platform.domain.wms.SupplierVO;
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
import com.dt.platform.domain.wms.meta.SupplierMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.ISupplierService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 供应商接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:31:08
*/

@InDoc
@Api(tags = "供应商")
@RestController("WmsSupplierController")
public class SupplierController extends SuperController {

	@Autowired
	private ISupplierService supplierService;

	/**
	 * 添加供应商
	*/
	@ApiOperation(value = "添加供应商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SupplierVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684323862413836288"),
		@ApiImplicitParam(name = SupplierVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.SUPPLIER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.COMPANY_TYPE , value = "企业属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.BUSINESS_CONTACTS , value = "商务联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.GRADE , value = "评级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.BUSINESS_CONTACTS_INFO , value = "商务联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.AFTER_SALES_CONTACTS , value = "售后联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.AFTER_SALES_CONTACTS_INFO , value = "售后联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.UNIT_CODE , value = "统一社会信用代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.SUPPLIER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SupplierServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SupplierServiceProxy.INSERT)
	public Result insert(SupplierVO supplierVO) {
		
		Result result=supplierService.insert(supplierVO,false);
		return result;
	}



	/**
	 * 删除供应商
	*/
	@ApiOperation(value = "删除供应商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SupplierVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684323862413836288")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SupplierServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SupplierServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  supplierService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=supplierService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除供应商 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除供应商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SupplierVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = SupplierServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SupplierServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = supplierService.hasRefers(ids);
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
			Result result=supplierService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=supplierService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新供应商
	*/
	@ApiOperation(value = "更新供应商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SupplierVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684323862413836288"),
		@ApiImplicitParam(name = SupplierVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.SUPPLIER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.COMPANY_TYPE , value = "企业属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.BUSINESS_CONTACTS , value = "商务联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.GRADE , value = "评级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.BUSINESS_CONTACTS_INFO , value = "商务联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.AFTER_SALES_CONTACTS , value = "售后联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.AFTER_SALES_CONTACTS_INFO , value = "售后联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.UNIT_CODE , value = "统一社会信用代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.SUPPLIER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SupplierVOMeta.PAGE_INDEX , SupplierVOMeta.PAGE_SIZE , SupplierVOMeta.SEARCH_FIELD , SupplierVOMeta.FUZZY_FIELD , SupplierVOMeta.SEARCH_VALUE , SupplierVOMeta.DIRTY_FIELDS , SupplierVOMeta.SORT_FIELD , SupplierVOMeta.SORT_TYPE , SupplierVOMeta.DATA_ORIGIN , SupplierVOMeta.QUERY_LOGIC , SupplierVOMeta.REQUEST_ACTION , SupplierVOMeta.IDS } )
	@SentinelResource(value = SupplierServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SupplierServiceProxy.UPDATE)
	public Result update(SupplierVO supplierVO) {
		
		Result result=supplierService.update(supplierVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存供应商
	*/
	@ApiOperation(value = "保存供应商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SupplierVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684323862413836288"),
		@ApiImplicitParam(name = SupplierVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.SUPPLIER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.COMPANY_TYPE , value = "企业属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.BUSINESS_CONTACTS , value = "商务联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.GRADE , value = "评级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.BUSINESS_CONTACTS_INFO , value = "商务联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.AFTER_SALES_CONTACTS , value = "售后联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.AFTER_SALES_CONTACTS_INFO , value = "售后联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.UNIT_CODE , value = "统一社会信用代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.SUPPLIER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { SupplierVOMeta.PAGE_INDEX , SupplierVOMeta.PAGE_SIZE , SupplierVOMeta.SEARCH_FIELD , SupplierVOMeta.FUZZY_FIELD , SupplierVOMeta.SEARCH_VALUE , SupplierVOMeta.DIRTY_FIELDS , SupplierVOMeta.SORT_FIELD , SupplierVOMeta.SORT_TYPE , SupplierVOMeta.DATA_ORIGIN , SupplierVOMeta.QUERY_LOGIC , SupplierVOMeta.REQUEST_ACTION , SupplierVOMeta.IDS } )
	@SentinelResource(value = SupplierServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SupplierServiceProxy.SAVE)
	public Result save(SupplierVO supplierVO) {
		
		Result result=supplierService.save(supplierVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取供应商
	*/
	@ApiOperation(value = "获取供应商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SupplierVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SupplierServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SupplierServiceProxy.GET_BY_ID)
	public Result<Supplier> getById(String id) {
		
		Result<Supplier> result=new Result<>();
		Supplier supplier=supplierService.getById(id);
		// join 关联的对象
		supplierService.dao().fill(supplier)
			.with(SupplierMeta.GRADE_DICT)
			.execute();
		result.success(true).data(supplier);
		return result;
	}


	/**
	 * 批量获取供应商 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取供应商")
		@ApiImplicitParams({
				@ApiImplicitParam(name = SupplierVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = SupplierServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SupplierServiceProxy.GET_BY_IDS)
	public Result<List<Supplier>> getByIds(List<String> ids) {
		
		Result<List<Supplier>> result=new Result<>();
		List<Supplier> list=supplierService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询供应商
	*/
	@ApiOperation(value = "查询供应商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SupplierVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684323862413836288"),
		@ApiImplicitParam(name = SupplierVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.SUPPLIER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.COMPANY_TYPE , value = "企业属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.BUSINESS_CONTACTS , value = "商务联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.GRADE , value = "评级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.BUSINESS_CONTACTS_INFO , value = "商务联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.AFTER_SALES_CONTACTS , value = "售后联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.AFTER_SALES_CONTACTS_INFO , value = "售后联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.UNIT_CODE , value = "统一社会信用代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.SUPPLIER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { SupplierVOMeta.PAGE_INDEX , SupplierVOMeta.PAGE_SIZE } )
	@SentinelResource(value = SupplierServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SupplierServiceProxy.QUERY_LIST)
	public Result<List<Supplier>> queryList(SupplierVO sample) {
		
		Result<List<Supplier>> result=new Result<>();
		List<Supplier> list=supplierService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询供应商
	*/
	@ApiOperation(value = "分页查询供应商")
	@ApiImplicitParams({
		@ApiImplicitParam(name = SupplierVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684323862413836288"),
		@ApiImplicitParam(name = SupplierVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.SUPPLIER_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.COMPANY_TYPE , value = "企业属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.BUSINESS_CONTACTS , value = "商务联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.GRADE , value = "评级" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.BUSINESS_CONTACTS_INFO , value = "商务联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.AFTER_SALES_CONTACTS , value = "售后联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.AFTER_SALES_CONTACTS_INFO , value = "售后联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.UNIT_CODE , value = "统一社会信用代码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = SupplierVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class , example = "供应商1"),
		@ApiImplicitParam(name = SupplierVOMeta.SUPPLIER_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = SupplierServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(SupplierServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Supplier>> queryPagedList(SupplierVO sample) {
		
		Result<PagedList<Supplier>> result=new Result<>();
		PagedList<Supplier> list=supplierService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		supplierService.dao().fill(list)
			.with(SupplierMeta.GRADE_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}





}