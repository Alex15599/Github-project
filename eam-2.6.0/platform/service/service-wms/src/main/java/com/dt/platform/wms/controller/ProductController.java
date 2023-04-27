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


import com.dt.platform.proxy.wms.ProductServiceProxy;
import com.dt.platform.domain.wms.meta.ProductVOMeta;
import com.dt.platform.domain.wms.Product;
import com.dt.platform.domain.wms.ProductVO;
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
import com.dt.platform.domain.wms.meta.ProductMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.wms.ProductAttr;
import com.dt.platform.domain.wms.Customer;
import com.dt.platform.domain.wms.Unit;
import com.dt.platform.domain.wms.ProductCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IProductService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 商品接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 14:02:36
*/

@InDoc
@Api(tags = "商品")
@RestController("WmsProductController")
public class ProductController extends SuperController {

	@Autowired
	private IProductService productService;

	/**
	 * 添加商品
	*/
	@ApiOperation(value = "添加商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684397689625903104"),
		@ApiImplicitParam(name = ProductVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ProductVOMeta.BAR_CODE , value = "条形码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.CUST_ID , value = "货主" , required = false , dataTypeClass=String.class , example = "684373683455655936"),
		@ApiImplicitParam(name = ProductVOMeta.CUST_PRODUCT_CODE , value = "客户商品编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_MODEL , value = "商品规格" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_BRAND , value = "商品品牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_SKU , value = "商品SKU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.CATEGORY , value = "大类" , required = false , dataTypeClass=String.class , example = "684327471675342848"),
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "商品1"),
		@ApiImplicitParam(name = ProductVOMeta.EN_NAME , value = "英文名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.UNIT , value = "单位" , required = false , dataTypeClass=String.class , example = "684022001882365952"),
		@ApiImplicitParam(name = ProductVOMeta.LENGTH , value = "长" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.WIDTH , value = "宽" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.HEIGHT , value = "高" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.MAX_VOLUME , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.MAX_WEIGHT , value = "最大重量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.PERIOD , value = "保质期" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ProductVOMeta.KEEP_DATE , value = "允收天数" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ProductVOMeta.MIN_STOCK_NUMBER , value = "最小库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.INSERT)
	public Result insert(ProductVO productVO) {
		
		Result result=productService.insert(productVO,false);
		return result;
	}



	/**
	 * 删除商品
	*/
	@ApiOperation(value = "删除商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684397689625903104")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  productService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=productService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除商品 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = ProductServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = productService.hasRefers(ids);
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
			Result result=productService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=productService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新商品
	*/
	@ApiOperation(value = "更新商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684397689625903104"),
		@ApiImplicitParam(name = ProductVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ProductVOMeta.BAR_CODE , value = "条形码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.CUST_ID , value = "货主" , required = false , dataTypeClass=String.class , example = "684373683455655936"),
		@ApiImplicitParam(name = ProductVOMeta.CUST_PRODUCT_CODE , value = "客户商品编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_MODEL , value = "商品规格" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_BRAND , value = "商品品牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_SKU , value = "商品SKU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.CATEGORY , value = "大类" , required = false , dataTypeClass=String.class , example = "684327471675342848"),
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "商品1"),
		@ApiImplicitParam(name = ProductVOMeta.EN_NAME , value = "英文名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.UNIT , value = "单位" , required = false , dataTypeClass=String.class , example = "684022001882365952"),
		@ApiImplicitParam(name = ProductVOMeta.LENGTH , value = "长" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.WIDTH , value = "宽" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.HEIGHT , value = "高" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.MAX_VOLUME , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.MAX_WEIGHT , value = "最大重量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.PERIOD , value = "保质期" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ProductVOMeta.KEEP_DATE , value = "允收天数" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ProductVOMeta.MIN_STOCK_NUMBER , value = "最小库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ProductVOMeta.PAGE_INDEX , ProductVOMeta.PAGE_SIZE , ProductVOMeta.SEARCH_FIELD , ProductVOMeta.FUZZY_FIELD , ProductVOMeta.SEARCH_VALUE , ProductVOMeta.DIRTY_FIELDS , ProductVOMeta.SORT_FIELD , ProductVOMeta.SORT_TYPE , ProductVOMeta.DATA_ORIGIN , ProductVOMeta.QUERY_LOGIC , ProductVOMeta.REQUEST_ACTION , ProductVOMeta.IDS } )
	@SentinelResource(value = ProductServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.UPDATE)
	public Result update(ProductVO productVO) {
		
		Result result=productService.update(productVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存商品
	*/
	@ApiOperation(value = "保存商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684397689625903104"),
		@ApiImplicitParam(name = ProductVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ProductVOMeta.BAR_CODE , value = "条形码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.CUST_ID , value = "货主" , required = false , dataTypeClass=String.class , example = "684373683455655936"),
		@ApiImplicitParam(name = ProductVOMeta.CUST_PRODUCT_CODE , value = "客户商品编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_MODEL , value = "商品规格" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_BRAND , value = "商品品牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_SKU , value = "商品SKU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.CATEGORY , value = "大类" , required = false , dataTypeClass=String.class , example = "684327471675342848"),
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "商品1"),
		@ApiImplicitParam(name = ProductVOMeta.EN_NAME , value = "英文名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.UNIT , value = "单位" , required = false , dataTypeClass=String.class , example = "684022001882365952"),
		@ApiImplicitParam(name = ProductVOMeta.LENGTH , value = "长" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.WIDTH , value = "宽" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.HEIGHT , value = "高" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.MAX_VOLUME , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.MAX_WEIGHT , value = "最大重量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.PERIOD , value = "保质期" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ProductVOMeta.KEEP_DATE , value = "允收天数" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ProductVOMeta.MIN_STOCK_NUMBER , value = "最小库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { ProductVOMeta.PAGE_INDEX , ProductVOMeta.PAGE_SIZE , ProductVOMeta.SEARCH_FIELD , ProductVOMeta.FUZZY_FIELD , ProductVOMeta.SEARCH_VALUE , ProductVOMeta.DIRTY_FIELDS , ProductVOMeta.SORT_FIELD , ProductVOMeta.SORT_TYPE , ProductVOMeta.DATA_ORIGIN , ProductVOMeta.QUERY_LOGIC , ProductVOMeta.REQUEST_ACTION , ProductVOMeta.IDS } )
	@SentinelResource(value = ProductServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.SAVE)
	public Result save(ProductVO productVO) {
		
		Result result=productService.save(productVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取商品
	*/
	@ApiOperation(value = "获取商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.GET_BY_ID)
	public Result<Product> getById(String id) {
		
		Result<Product> result=new Result<>();
		Product product=productService.getById(id);
		// join 关联的对象
		productService.dao().fill(product)
			.with(ProductMeta.PRODUCT_ATTR_LIST)
			.with(ProductMeta.PRODUCT_CATEGORY)
			.with(ProductMeta.UNIT_DATA)
			.with(ProductMeta.CUSTOMER)
			.execute();
		result.success(true).data(product);
		return result;
	}


	/**
	 * 批量获取商品 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取商品")
		@ApiImplicitParams({
				@ApiImplicitParam(name = ProductVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = ProductServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.GET_BY_IDS)
	public Result<List<Product>> getByIds(List<String> ids) {
		
		Result<List<Product>> result=new Result<>();
		List<Product> list=productService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询商品
	*/
	@ApiOperation(value = "查询商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684397689625903104"),
		@ApiImplicitParam(name = ProductVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ProductVOMeta.BAR_CODE , value = "条形码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.CUST_ID , value = "货主" , required = false , dataTypeClass=String.class , example = "684373683455655936"),
		@ApiImplicitParam(name = ProductVOMeta.CUST_PRODUCT_CODE , value = "客户商品编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_MODEL , value = "商品规格" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_BRAND , value = "商品品牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_SKU , value = "商品SKU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.CATEGORY , value = "大类" , required = false , dataTypeClass=String.class , example = "684327471675342848"),
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "商品1"),
		@ApiImplicitParam(name = ProductVOMeta.EN_NAME , value = "英文名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.UNIT , value = "单位" , required = false , dataTypeClass=String.class , example = "684022001882365952"),
		@ApiImplicitParam(name = ProductVOMeta.LENGTH , value = "长" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.WIDTH , value = "宽" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.HEIGHT , value = "高" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.MAX_VOLUME , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.MAX_WEIGHT , value = "最大重量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.PERIOD , value = "保质期" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ProductVOMeta.KEEP_DATE , value = "允收天数" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ProductVOMeta.MIN_STOCK_NUMBER , value = "最小库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { ProductVOMeta.PAGE_INDEX , ProductVOMeta.PAGE_SIZE } )
	@SentinelResource(value = ProductServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.QUERY_LIST)
	public Result<List<Product>> queryList(ProductVO sample) {
		
		Result<List<Product>> result=new Result<>();
		List<Product> list=productService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询商品
	*/
	@ApiOperation(value = "分页查询商品")
	@ApiImplicitParams({
		@ApiImplicitParam(name = ProductVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684397689625903104"),
		@ApiImplicitParam(name = ProductVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ProductVOMeta.BAR_CODE , value = "条形码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.CUST_ID , value = "货主" , required = false , dataTypeClass=String.class , example = "684373683455655936"),
		@ApiImplicitParam(name = ProductVOMeta.CUST_PRODUCT_CODE , value = "客户商品编码" , required = false , dataTypeClass=String.class , example = "1212"),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_MODEL , value = "商品规格" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_BRAND , value = "商品品牌" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.PRODUCT_SKU , value = "商品SKU" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.CATEGORY , value = "大类" , required = false , dataTypeClass=String.class , example = "684327471675342848"),
		@ApiImplicitParam(name = ProductVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "商品1"),
		@ApiImplicitParam(name = ProductVOMeta.EN_NAME , value = "英文名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = ProductVOMeta.UNIT , value = "单位" , required = false , dataTypeClass=String.class , example = "684022001882365952"),
		@ApiImplicitParam(name = ProductVOMeta.LENGTH , value = "长" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.WIDTH , value = "宽" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.HEIGHT , value = "高" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.MAX_VOLUME , value = "最大体积" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.MAX_WEIGHT , value = "最大重量" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = ProductVOMeta.PERIOD , value = "保质期" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ProductVOMeta.KEEP_DATE , value = "允收天数" , required = false , dataTypeClass=BigDecimal.class , example = "0"),
		@ApiImplicitParam(name = ProductVOMeta.MIN_STOCK_NUMBER , value = "最小库存数量" , required = false , dataTypeClass=BigDecimal.class , example = "1"),
		@ApiImplicitParam(name = ProductVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = ProductServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(ProductServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Product>> queryPagedList(ProductVO sample) {
		
		Result<PagedList<Product>> result=new Result<>();
		PagedList<Product> list=productService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		productService.dao().fill(list)
			.with(ProductMeta.PRODUCT_ATTR_LIST)
			.with(ProductMeta.PRODUCT_CATEGORY)
			.with(ProductMeta.UNIT_DATA)
			.with(ProductMeta.CUSTOMER)
			.execute();
		result.success(true).data(list);
		return result;
	}





}