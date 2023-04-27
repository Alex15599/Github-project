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


import com.dt.platform.proxy.wms.ProductAttrServiceProxy;
import com.dt.platform.domain.wms.meta.ProductAttrVOMeta;
import com.dt.platform.domain.wms.ProductAttr;
import com.dt.platform.domain.wms.ProductAttrVO;
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
import com.dt.platform.domain.wms.meta.ProductAttrMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IProductAttrService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 产品属性接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:29:56
*/

@InDoc
@Api(tags = "产品属性")
@RestController("WmsProductAttrController")
public class ProductAttrController extends SuperController {

	@Autowired
	private IProductAttrService productAttrService;

	/**
	 * 添加产品属性
	*/
	@ApiOperation(value = "添加产品属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684022092424806400"),
		@ApiImplicitParam(name = ProductAttrVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "铝制材料"),
		@ApiImplicitParam(name = ProductAttrVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "铝制材料"),
		@ApiImplicitParam(name = ProductAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "铝制材料"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductAttrServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductAttrServiceProxy.INSERT)
	public Result insert(ProductAttrVO productAttrVO) {
		
		Result result=productAttrService.insert(productAttrVO,false);
		return result;
	}



	/**
	 * 删除产品属性
	*/
	@ApiOperation(value = "删除产品属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684022092424806400")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductAttrServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductAttrServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  productAttrService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=productAttrService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除产品属性 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除产品属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductAttrVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ProductAttrServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductAttrServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = productAttrService.hasRefers(ids);
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
			Result result=productAttrService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=productAttrService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新产品属性
	*/
	@ApiOperation(value = "更新产品属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684022092424806400"),
		@ApiImplicitParam(name = ProductAttrVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "铝制材料"),
		@ApiImplicitParam(name = ProductAttrVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "铝制材料"),
		@ApiImplicitParam(name = ProductAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "铝制材料"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ProductAttrVOMeta.PAGE_INDEX , ProductAttrVOMeta.PAGE_SIZE , ProductAttrVOMeta.SEARCH_FIELD , ProductAttrVOMeta.FUZZY_FIELD , ProductAttrVOMeta.SEARCH_VALUE , ProductAttrVOMeta.DIRTY_FIELDS , ProductAttrVOMeta.SORT_FIELD , ProductAttrVOMeta.SORT_TYPE , ProductAttrVOMeta.DATA_ORIGIN , ProductAttrVOMeta.QUERY_LOGIC , ProductAttrVOMeta.REQUEST_ACTION , ProductAttrVOMeta.IDS } )
	@SentinelResource(value = ProductAttrServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductAttrServiceProxy.UPDATE)
	public Result update(ProductAttrVO productAttrVO) {
		
		Result result=productAttrService.update(productAttrVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存产品属性
	*/
	@ApiOperation(value = "保存产品属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684022092424806400"),
		@ApiImplicitParam(name = ProductAttrVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "铝制材料"),
		@ApiImplicitParam(name = ProductAttrVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "铝制材料"),
		@ApiImplicitParam(name = ProductAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "铝制材料"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ProductAttrVOMeta.PAGE_INDEX , ProductAttrVOMeta.PAGE_SIZE , ProductAttrVOMeta.SEARCH_FIELD , ProductAttrVOMeta.FUZZY_FIELD , ProductAttrVOMeta.SEARCH_VALUE , ProductAttrVOMeta.DIRTY_FIELDS , ProductAttrVOMeta.SORT_FIELD , ProductAttrVOMeta.SORT_TYPE , ProductAttrVOMeta.DATA_ORIGIN , ProductAttrVOMeta.QUERY_LOGIC , ProductAttrVOMeta.REQUEST_ACTION , ProductAttrVOMeta.IDS } )
	@SentinelResource(value = ProductAttrServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductAttrServiceProxy.SAVE)
	public Result save(ProductAttrVO productAttrVO) {
		
		Result result=productAttrService.save(productAttrVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取产品属性
	*/
	@ApiOperation(value = "获取产品属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductAttrServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductAttrServiceProxy.GET_BY_ID)
	public Result<ProductAttr> getById(String id) {
		
		Result<ProductAttr> result=new Result<>();
		ProductAttr productAttr=productAttrService.getById(id);
		result.success(true).data(productAttr);
		return result;
	}


	/**
	 * 批量获取产品属性 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取产品属性")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ProductAttrVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ProductAttrServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductAttrServiceProxy.GET_BY_IDS)
	public Result<List<ProductAttr>> getByIds(List<String> ids) {
		
		Result<List<ProductAttr>> result=new Result<>();
		List<ProductAttr> list=productAttrService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询产品属性
	*/
	@ApiOperation(value = "查询产品属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684022092424806400"),
		@ApiImplicitParam(name = ProductAttrVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "铝制材料"),
		@ApiImplicitParam(name = ProductAttrVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "铝制材料"),
		@ApiImplicitParam(name = ProductAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "铝制材料"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ProductAttrVOMeta.PAGE_INDEX , ProductAttrVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ProductAttrServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductAttrServiceProxy.QUERY_LIST)
	public Result<List<ProductAttr>> queryList(ProductAttrVO sample) {
		
		Result<List<ProductAttr>> result=new Result<>();
		List<ProductAttr> list=productAttrService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询产品属性
	*/
	@ApiOperation(value = "分页查询产品属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductAttrVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684022092424806400"),
		@ApiImplicitParam(name = ProductAttrVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "铝制材料"),
		@ApiImplicitParam(name = ProductAttrVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "铝制材料"),
		@ApiImplicitParam(name = ProductAttrVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "铝制材料"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductAttrServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductAttrServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ProductAttr>> queryPagedList(ProductAttrVO sample) {
		
		Result<PagedList<ProductAttr>> result=new Result<>();
		PagedList<ProductAttr> list=productAttrService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}