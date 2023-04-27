package com.dt.platform.wms.controller;

import java.util.*;

import com.dt.platform.domain.knowledgebase.Category;
import com.github.foxnic.commons.lang.StringUtil;
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


import com.dt.platform.proxy.wms.ProductCategoryServiceProxy;
import com.dt.platform.domain.wms.meta.ProductCategoryVOMeta;
import com.dt.platform.domain.wms.ProductCategory;
import com.dt.platform.domain.wms.ProductCategoryVO;
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
import com.dt.platform.domain.wms.meta.ProductCategoryMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IProductCategoryService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 商品分类接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 08:50:26
*/

@InDoc
@Api(tags = "商品分类")
@RestController("WmsProductCategoryController")
public class ProductCategoryController extends SuperController {

	@Autowired
	private IProductCategoryService productCategoryService;

	/**
	 * 添加商品分类
	*/
	@ApiOperation(value = "添加商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_FULLNAME , value = "具体名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductCategoryServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductCategoryServiceProxy.INSERT)
	public Result insert(ProductCategoryVO categoryVO) {

		categoryVO.setSort(9999);
		if (StringUtil.isBlank(categoryVO.getParentId())) {
			categoryVO.setParentId("0");
		}
		Result result = productCategoryService.insert(categoryVO,false);
		if (result.success()) {
			ProductCategory currentCategory = new ProductCategory();
			currentCategory.setId(categoryVO.getId());
			if ("0".equals(categoryVO.getParentId())) {
				currentCategory.setHierarchy(categoryVO.getId());
				currentCategory.setHierarchyName(categoryVO.getCategoryName());
			} else {
				ProductCategory parentCategory = productCategoryService.getById(categoryVO.getParentId());
				currentCategory.setHierarchy(parentCategory.getHierarchy() + "/" + categoryVO.getId());
				currentCategory.setHierarchyName(parentCategory.getHierarchyName() + "/" + categoryVO.getCategoryName());
			}
			productCategoryService.update(currentCategory, SaveMode.NOT_NULL_FIELDS);
			categoryVO.setHierarchy(currentCategory.getHierarchy());
			categoryVO.setHierarchyName(currentCategory.getHierarchyName());
			result.data(categoryVO);
		}
		return result;

	}



	/**
	 * 删除商品分类
	*/
	@ApiOperation(value = "删除商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductCategoryServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductCategoryServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		Result<Category> result = new Result<>();
		List<ProductCategory> list = productCategoryService.queryList(ProductCategory.create().setParentId(id));
		if (list.size() > 0) {
			result.success(false).message("请先删除下级节点");
		} else {
			return productCategoryService.deleteByIdLogical(id);
		}

		return result;

	}


	/**
	 * 批量删除商品分类 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ProductCategoryServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductCategoryServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = productCategoryService.hasRefers(ids);
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
			Result result=productCategoryService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=productCategoryService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新商品分类
	*/
	@ApiOperation(value = "更新商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_FULLNAME , value = "具体名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ProductCategoryVOMeta.PAGE_INDEX , ProductCategoryVOMeta.PAGE_SIZE , ProductCategoryVOMeta.SEARCH_FIELD , ProductCategoryVOMeta.FUZZY_FIELD , ProductCategoryVOMeta.SEARCH_VALUE , ProductCategoryVOMeta.DIRTY_FIELDS , ProductCategoryVOMeta.SORT_FIELD , ProductCategoryVOMeta.SORT_TYPE , ProductCategoryVOMeta.DATA_ORIGIN , ProductCategoryVOMeta.QUERY_LOGIC , ProductCategoryVOMeta.REQUEST_ACTION , ProductCategoryVOMeta.IDS } )
	@SentinelResource(value = ProductCategoryServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductCategoryServiceProxy.UPDATE)
	public Result update(ProductCategoryVO productCategoryVO) {
		
		Result result=productCategoryService.update(productCategoryVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);

		if (result.isSuccess()) {
			// 更新分类名称
			return productCategoryService.updateHierarchy(productCategoryVO.getId());
		}

		return result;
	}


	/**
	 * 保存商品分类
	*/
	@ApiOperation(value = "保存商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_FULLNAME , value = "具体名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ProductCategoryVOMeta.PAGE_INDEX , ProductCategoryVOMeta.PAGE_SIZE , ProductCategoryVOMeta.SEARCH_FIELD , ProductCategoryVOMeta.FUZZY_FIELD , ProductCategoryVOMeta.SEARCH_VALUE , ProductCategoryVOMeta.DIRTY_FIELDS , ProductCategoryVOMeta.SORT_FIELD , ProductCategoryVOMeta.SORT_TYPE , ProductCategoryVOMeta.DATA_ORIGIN , ProductCategoryVOMeta.QUERY_LOGIC , ProductCategoryVOMeta.REQUEST_ACTION , ProductCategoryVOMeta.IDS } )
	@SentinelResource(value = ProductCategoryServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductCategoryServiceProxy.SAVE)
	public Result save(ProductCategoryVO productCategoryVO) {
		
		Result result=productCategoryService.save(productCategoryVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取商品分类
	*/
	@ApiOperation(value = "获取商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductCategoryServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductCategoryServiceProxy.GET_BY_ID)
	public Result<ProductCategory> getById(String id) {
		
		Result<ProductCategory> result=new Result<>();
		ProductCategory productCategory=productCategoryService.getById(id);
		result.success(true).data(productCategory);
		return result;
	}


	/**
	 * 批量获取商品分类 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取商品分类")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ProductCategoryVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ProductCategoryServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductCategoryServiceProxy.GET_BY_IDS)
	public Result<List<ProductCategory>> getByIds(List<String> ids) {
		
		Result<List<ProductCategory>> result=new Result<>();
		List<ProductCategory> list=productCategoryService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询商品分类
	*/
	@ApiOperation(value = "查询商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_FULLNAME , value = "具体名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ProductCategoryVOMeta.PAGE_INDEX , ProductCategoryVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ProductCategoryServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductCategoryServiceProxy.QUERY_LIST)
	public Result<List<ProductCategory>> queryList(ProductCategoryVO sample) {
		
		Result<List<ProductCategory>> result=new Result<>();
		List<ProductCategory> list=productCategoryService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询商品分类
	*/
	@ApiOperation(value = "分页查询商品分类")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductCategoryVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_FULLNAME , value = "具体名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.CATEGORY_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductCategoryVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductCategoryServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductCategoryServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<ProductCategory>> queryPagedList(ProductCategoryVO sample) {
		
		Result<PagedList<ProductCategory>> result=new Result<>();
		PagedList<ProductCategory> list=productCategoryService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}