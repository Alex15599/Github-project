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


import com.dt.platform.proxy.wms.CompanyAttrServiceProxy;
import com.dt.platform.domain.wms.meta.CompanyAttrVOMeta;
import com.dt.platform.domain.wms.CompanyAttr;
import com.dt.platform.domain.wms.CompanyAttrVO;
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
import com.dt.platform.domain.wms.meta.CompanyAttrMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.ICompanyAttrService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 企业属性接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:27:01
*/

@InDoc
@Api(tags = "企业属性")
@RestController("WmsCompanyAttrController")
public class CompanyAttrController extends SuperController {

	@Autowired
	private ICompanyAttrService companyAttrService;

	/**
	 * 添加企业属性
	*/
	@ApiOperation(value = "添加企业属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684330713889112064"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "外企"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "外企"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CompanyAttrServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyAttrServiceProxy.INSERT)
	public Result insert(CompanyAttrVO companyAttrVO) {
		
		Result result=companyAttrService.insert(companyAttrVO,false);
		return result;
	}



	/**
	 * 删除企业属性
	*/
	@ApiOperation(value = "删除企业属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684330713889112064")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CompanyAttrServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyAttrServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  companyAttrService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=companyAttrService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除企业属性 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除企业属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyAttrVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CompanyAttrServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyAttrServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = companyAttrService.hasRefers(ids);
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
			Result result=companyAttrService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=companyAttrService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新企业属性
	*/
	@ApiOperation(value = "更新企业属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684330713889112064"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "外企"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "外企"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CompanyAttrVOMeta.PAGE_INDEX , CompanyAttrVOMeta.PAGE_SIZE , CompanyAttrVOMeta.SEARCH_FIELD , CompanyAttrVOMeta.FUZZY_FIELD , CompanyAttrVOMeta.SEARCH_VALUE , CompanyAttrVOMeta.DIRTY_FIELDS , CompanyAttrVOMeta.SORT_FIELD , CompanyAttrVOMeta.SORT_TYPE , CompanyAttrVOMeta.DATA_ORIGIN , CompanyAttrVOMeta.QUERY_LOGIC , CompanyAttrVOMeta.REQUEST_ACTION , CompanyAttrVOMeta.IDS } )
	@SentinelResource(value = CompanyAttrServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyAttrServiceProxy.UPDATE)
	public Result update(CompanyAttrVO companyAttrVO) {
		
		Result result=companyAttrService.update(companyAttrVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存企业属性
	*/
	@ApiOperation(value = "保存企业属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684330713889112064"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "外企"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "外企"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CompanyAttrVOMeta.PAGE_INDEX , CompanyAttrVOMeta.PAGE_SIZE , CompanyAttrVOMeta.SEARCH_FIELD , CompanyAttrVOMeta.FUZZY_FIELD , CompanyAttrVOMeta.SEARCH_VALUE , CompanyAttrVOMeta.DIRTY_FIELDS , CompanyAttrVOMeta.SORT_FIELD , CompanyAttrVOMeta.SORT_TYPE , CompanyAttrVOMeta.DATA_ORIGIN , CompanyAttrVOMeta.QUERY_LOGIC , CompanyAttrVOMeta.REQUEST_ACTION , CompanyAttrVOMeta.IDS } )
	@SentinelResource(value = CompanyAttrServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyAttrServiceProxy.SAVE)
	public Result save(CompanyAttrVO companyAttrVO) {
		
		Result result=companyAttrService.save(companyAttrVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取企业属性
	*/
	@ApiOperation(value = "获取企业属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CompanyAttrServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyAttrServiceProxy.GET_BY_ID)
	public Result<CompanyAttr> getById(String id) {
		
		Result<CompanyAttr> result=new Result<>();
		CompanyAttr companyAttr=companyAttrService.getById(id);
		result.success(true).data(companyAttr);
		return result;
	}


	/**
	 * 批量获取企业属性 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取企业属性")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CompanyAttrVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CompanyAttrServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyAttrServiceProxy.GET_BY_IDS)
	public Result<List<CompanyAttr>> getByIds(List<String> ids) {
		
		Result<List<CompanyAttr>> result=new Result<>();
		List<CompanyAttr> list=companyAttrService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询企业属性
	*/
	@ApiOperation(value = "查询企业属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684330713889112064"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "外企"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "外企"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CompanyAttrVOMeta.PAGE_INDEX , CompanyAttrVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CompanyAttrServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyAttrServiceProxy.QUERY_LIST)
	public Result<List<CompanyAttr>> queryList(CompanyAttrVO sample) {
		
		Result<List<CompanyAttr>> result=new Result<>();
		List<CompanyAttr> list=companyAttrService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询企业属性
	*/
	@ApiOperation(value = "分页查询企业属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CompanyAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684330713889112064"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "外企"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "外企"),
		@ApiImplicitParam(name = CompanyAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CompanyAttrServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CompanyAttrServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CompanyAttr>> queryPagedList(CompanyAttrVO sample) {
		
		Result<PagedList<CompanyAttr>> result=new Result<>();
		PagedList<CompanyAttr> list=companyAttrService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}