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


import com.dt.platform.proxy.wms.CustomerServiceProxy;
import com.dt.platform.domain.wms.meta.CustomerVOMeta;
import com.dt.platform.domain.wms.Customer;
import com.dt.platform.domain.wms.CustomerVO;
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
import com.dt.platform.domain.wms.meta.CustomerMeta;
import com.dt.platform.domain.wms.CompanyAttr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.ICustomerService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 客户接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 12:16:10
*/

@InDoc
@Api(tags = "客户")
@RestController("WmsCustomerController")
public class CustomerController extends SuperController {

	@Autowired
	private ICustomerService customerService;

	/**
	 * 添加客户
	*/
	@ApiOperation(value = "添加客户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CustomerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.COMPANY_ATTR , value = "企业属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ATTR , value = "属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.BILLING_METHOD , value = "出库计费" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CONTRACT_NUMBER , value = "合同号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.BUSINESS_CONTACTS , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CONTACT_INFORMATION , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CustomerServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CustomerServiceProxy.INSERT)
	public Result insert(CustomerVO customerVO) {
		
		Result result=customerService.insert(customerVO,false);
		return result;
	}



	/**
	 * 删除客户
	*/
	@ApiOperation(value = "删除客户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CustomerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CustomerServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CustomerServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  customerService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=customerService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除客户 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除客户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CustomerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CustomerServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CustomerServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = customerService.hasRefers(ids);
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
			Result result=customerService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=customerService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新客户
	*/
	@ApiOperation(value = "更新客户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CustomerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.COMPANY_ATTR , value = "企业属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ATTR , value = "属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.BILLING_METHOD , value = "出库计费" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CONTRACT_NUMBER , value = "合同号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.BUSINESS_CONTACTS , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CONTACT_INFORMATION , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CustomerVOMeta.PAGE_INDEX , CustomerVOMeta.PAGE_SIZE , CustomerVOMeta.SEARCH_FIELD , CustomerVOMeta.FUZZY_FIELD , CustomerVOMeta.SEARCH_VALUE , CustomerVOMeta.DIRTY_FIELDS , CustomerVOMeta.SORT_FIELD , CustomerVOMeta.SORT_TYPE , CustomerVOMeta.DATA_ORIGIN , CustomerVOMeta.QUERY_LOGIC , CustomerVOMeta.REQUEST_ACTION , CustomerVOMeta.IDS } )
	@SentinelResource(value = CustomerServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CustomerServiceProxy.UPDATE)
	public Result update(CustomerVO customerVO) {
		
		Result result=customerService.update(customerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存客户
	*/
	@ApiOperation(value = "保存客户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CustomerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.COMPANY_ATTR , value = "企业属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ATTR , value = "属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.BILLING_METHOD , value = "出库计费" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CONTRACT_NUMBER , value = "合同号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.BUSINESS_CONTACTS , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CONTACT_INFORMATION , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CustomerVOMeta.PAGE_INDEX , CustomerVOMeta.PAGE_SIZE , CustomerVOMeta.SEARCH_FIELD , CustomerVOMeta.FUZZY_FIELD , CustomerVOMeta.SEARCH_VALUE , CustomerVOMeta.DIRTY_FIELDS , CustomerVOMeta.SORT_FIELD , CustomerVOMeta.SORT_TYPE , CustomerVOMeta.DATA_ORIGIN , CustomerVOMeta.QUERY_LOGIC , CustomerVOMeta.REQUEST_ACTION , CustomerVOMeta.IDS } )
	@SentinelResource(value = CustomerServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CustomerServiceProxy.SAVE)
	public Result save(CustomerVO customerVO) {
		
		Result result=customerService.save(customerVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取客户
	*/
	@ApiOperation(value = "获取客户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CustomerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CustomerServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CustomerServiceProxy.GET_BY_ID)
	public Result<Customer> getById(String id) {
		
		Result<Customer> result=new Result<>();
		Customer customer=customerService.getById(id);
		// join 关联的对象
		customerService.dao().fill(customer)
			.with(CustomerMeta.COMPANY_ATTR_DATA)
			.execute();
		result.success(true).data(customer);
		return result;
	}


	/**
	 * 批量获取客户 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取客户")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CustomerVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CustomerServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CustomerServiceProxy.GET_BY_IDS)
	public Result<List<Customer>> getByIds(List<String> ids) {
		
		Result<List<Customer>> result=new Result<>();
		List<Customer> list=customerService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询客户
	*/
	@ApiOperation(value = "查询客户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CustomerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.COMPANY_ATTR , value = "企业属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ATTR , value = "属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.BILLING_METHOD , value = "出库计费" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CONTRACT_NUMBER , value = "合同号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.BUSINESS_CONTACTS , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CONTACT_INFORMATION , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CustomerVOMeta.PAGE_INDEX , CustomerVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CustomerServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CustomerServiceProxy.QUERY_LIST)
	public Result<List<Customer>> queryList(CustomerVO sample) {
		
		Result<List<Customer>> result=new Result<>();
		List<Customer> list=customerService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询客户
	*/
	@ApiOperation(value = "分页查询客户")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CustomerVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.COMPANY_ATTR , value = "企业属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ATTR , value = "属性" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.BILLING_METHOD , value = "出库计费" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CONTRACT_NUMBER , value = "合同号" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.BUSINESS_CONTACTS , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.CONTACT_INFORMATION , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ADDRESS , value = "地址" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.ATTACH , value = "附件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CustomerVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CustomerServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CustomerServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Customer>> queryPagedList(CustomerVO sample) {
		
		Result<PagedList<Customer>> result=new Result<>();
		PagedList<Customer> list=customerService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		customerService.dao().fill(list)
			.with(CustomerMeta.COMPANY_ATTR_DATA)
			.execute();
		result.success(true).data(list);
		return result;
	}





}