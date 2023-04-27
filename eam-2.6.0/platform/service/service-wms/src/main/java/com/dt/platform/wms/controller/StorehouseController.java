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


import com.dt.platform.proxy.wms.StorehouseServiceProxy;
import com.dt.platform.domain.wms.meta.StorehouseVOMeta;
import com.dt.platform.domain.wms.Storehouse;
import com.dt.platform.domain.wms.StorehouseVO;
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
import com.dt.platform.domain.wms.meta.StorehouseMeta;
import com.dt.platform.domain.wms.ProductAttr;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IStorehouseService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 仓库接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:30:40
*/

@InDoc
@Api(tags = "仓库")
@RestController("WmsStorehouseController")
public class StorehouseController extends SuperController {

	@Autowired
	private IStorehouseService storehouseService;

	/**
	 * 添加仓库
	*/
	@ApiOperation(value = "添加仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684034962759876608"),
		@ApiImplicitParam(name = StorehouseVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = StorehouseVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = StorehouseVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StorehouseServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseServiceProxy.INSERT)
	public Result insert(StorehouseVO storehouseVO) {
		
		Result result=storehouseService.insert(storehouseVO,false);
		return result;
	}



	/**
	 * 删除仓库
	*/
	@ApiOperation(value = "删除仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684034962759876608")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StorehouseServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  storehouseService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=storehouseService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除仓库 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = StorehouseServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = storehouseService.hasRefers(ids);
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
			Result result=storehouseService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=storehouseService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新仓库
	*/
	@ApiOperation(value = "更新仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684034962759876608"),
		@ApiImplicitParam(name = StorehouseVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = StorehouseVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = StorehouseVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { StorehouseVOMeta.PAGE_INDEX , StorehouseVOMeta.PAGE_SIZE , StorehouseVOMeta.SEARCH_FIELD , StorehouseVOMeta.FUZZY_FIELD , StorehouseVOMeta.SEARCH_VALUE , StorehouseVOMeta.DIRTY_FIELDS , StorehouseVOMeta.SORT_FIELD , StorehouseVOMeta.SORT_TYPE , StorehouseVOMeta.DATA_ORIGIN , StorehouseVOMeta.QUERY_LOGIC , StorehouseVOMeta.REQUEST_ACTION , StorehouseVOMeta.IDS } )
	@SentinelResource(value = StorehouseServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseServiceProxy.UPDATE)
	public Result update(StorehouseVO storehouseVO) {
		
		Result result=storehouseService.update(storehouseVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存仓库
	*/
	@ApiOperation(value = "保存仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684034962759876608"),
		@ApiImplicitParam(name = StorehouseVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = StorehouseVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = StorehouseVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { StorehouseVOMeta.PAGE_INDEX , StorehouseVOMeta.PAGE_SIZE , StorehouseVOMeta.SEARCH_FIELD , StorehouseVOMeta.FUZZY_FIELD , StorehouseVOMeta.SEARCH_VALUE , StorehouseVOMeta.DIRTY_FIELDS , StorehouseVOMeta.SORT_FIELD , StorehouseVOMeta.SORT_TYPE , StorehouseVOMeta.DATA_ORIGIN , StorehouseVOMeta.QUERY_LOGIC , StorehouseVOMeta.REQUEST_ACTION , StorehouseVOMeta.IDS } )
	@SentinelResource(value = StorehouseServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseServiceProxy.SAVE)
	public Result save(StorehouseVO storehouseVO) {
		
		Result result=storehouseService.save(storehouseVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取仓库
	*/
	@ApiOperation(value = "获取仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StorehouseServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseServiceProxy.GET_BY_ID)
	public Result<Storehouse> getById(String id) {
		
		Result<Storehouse> result=new Result<>();
		Storehouse storehouse=storehouseService.getById(id);
		// join 关联的对象
		storehouseService.dao().fill(storehouse)
			.with(StorehouseMeta.PRODUCT_ATTR_LIST)
			.execute();
		result.success(true).data(storehouse);
		return result;
	}


	/**
	 * 批量获取仓库 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取仓库")
		@ApiImplicitParams({
				@ApiImplicitParam(name = StorehouseVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = StorehouseServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseServiceProxy.GET_BY_IDS)
	public Result<List<Storehouse>> getByIds(List<String> ids) {
		
		Result<List<Storehouse>> result=new Result<>();
		List<Storehouse> list=storehouseService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询仓库
	*/
	@ApiOperation(value = "查询仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684034962759876608"),
		@ApiImplicitParam(name = StorehouseVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = StorehouseVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = StorehouseVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { StorehouseVOMeta.PAGE_INDEX , StorehouseVOMeta.PAGE_SIZE } )
	@SentinelResource(value = StorehouseServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseServiceProxy.QUERY_LIST)
	public Result<List<Storehouse>> queryList(StorehouseVO sample) {
		
		Result<List<Storehouse>> result=new Result<>();
		List<Storehouse> list=storehouseService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询仓库
	*/
	@ApiOperation(value = "分页查询仓库")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684034962759876608"),
		@ApiImplicitParam(name = StorehouseVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = StorehouseVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "仓库1"),
		@ApiImplicitParam(name = StorehouseVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "1212"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StorehouseServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Storehouse>> queryPagedList(StorehouseVO sample) {
		
		Result<PagedList<Storehouse>> result=new Result<>();
		PagedList<Storehouse> list=storehouseService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		storehouseService.dao().fill(list)
			.with(StorehouseMeta.PRODUCT_ATTR_LIST)
			.execute();
		result.success(true).data(list);
		return result;
	}





}