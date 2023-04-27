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


import com.dt.platform.proxy.wms.StorehouseAttrVServiceProxy;
import com.dt.platform.domain.wms.meta.StorehouseAttrVVOMeta;
import com.dt.platform.domain.wms.StorehouseAttrV;
import com.dt.platform.domain.wms.StorehouseAttrVVO;
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
import com.dt.platform.domain.wms.meta.StorehouseAttrVMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IStorehouseAttrVService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 仓库属性接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:30:29
*/

@InDoc
@Api(tags = "仓库属性")
@RestController("WmsStorehouseAttrVController")
public class StorehouseAttrVController extends SuperController {

	@Autowired
	private IStorehouseAttrVService storehouseAttrVService;

	/**
	 * 添加仓库属性
	*/
	@ApiOperation(value = "添加仓库属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684130665242820608"),
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.STORE_ID , value = "仓库" , required = false , dataTypeClass=String.class , example = "684034962759876608"),
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.ATTR_ID , value = "属性" , required = false , dataTypeClass=String.class , example = "684022092424806400"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StorehouseAttrVServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseAttrVServiceProxy.INSERT)
	public Result insert(StorehouseAttrVVO storehouseAttrVVO) {
		
		Result result=storehouseAttrVService.insert(storehouseAttrVVO,false);
		return result;
	}



	/**
	 * 删除仓库属性
	*/
	@ApiOperation(value = "删除仓库属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684130665242820608")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StorehouseAttrVServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseAttrVServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  storehouseAttrVService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=storehouseAttrVService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除仓库属性 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除仓库属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = StorehouseAttrVServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseAttrVServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = storehouseAttrVService.hasRefers(ids);
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
			Result result=storehouseAttrVService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=storehouseAttrVService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新仓库属性
	*/
	@ApiOperation(value = "更新仓库属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684130665242820608"),
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.STORE_ID , value = "仓库" , required = false , dataTypeClass=String.class , example = "684034962759876608"),
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.ATTR_ID , value = "属性" , required = false , dataTypeClass=String.class , example = "684022092424806400"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { StorehouseAttrVVOMeta.PAGE_INDEX , StorehouseAttrVVOMeta.PAGE_SIZE , StorehouseAttrVVOMeta.SEARCH_FIELD , StorehouseAttrVVOMeta.FUZZY_FIELD , StorehouseAttrVVOMeta.SEARCH_VALUE , StorehouseAttrVVOMeta.DIRTY_FIELDS , StorehouseAttrVVOMeta.SORT_FIELD , StorehouseAttrVVOMeta.SORT_TYPE , StorehouseAttrVVOMeta.DATA_ORIGIN , StorehouseAttrVVOMeta.QUERY_LOGIC , StorehouseAttrVVOMeta.REQUEST_ACTION , StorehouseAttrVVOMeta.IDS } )
	@SentinelResource(value = StorehouseAttrVServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseAttrVServiceProxy.UPDATE)
	public Result update(StorehouseAttrVVO storehouseAttrVVO) {
		
		Result result=storehouseAttrVService.update(storehouseAttrVVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存仓库属性
	*/
	@ApiOperation(value = "保存仓库属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684130665242820608"),
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.STORE_ID , value = "仓库" , required = false , dataTypeClass=String.class , example = "684034962759876608"),
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.ATTR_ID , value = "属性" , required = false , dataTypeClass=String.class , example = "684022092424806400"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { StorehouseAttrVVOMeta.PAGE_INDEX , StorehouseAttrVVOMeta.PAGE_SIZE , StorehouseAttrVVOMeta.SEARCH_FIELD , StorehouseAttrVVOMeta.FUZZY_FIELD , StorehouseAttrVVOMeta.SEARCH_VALUE , StorehouseAttrVVOMeta.DIRTY_FIELDS , StorehouseAttrVVOMeta.SORT_FIELD , StorehouseAttrVVOMeta.SORT_TYPE , StorehouseAttrVVOMeta.DATA_ORIGIN , StorehouseAttrVVOMeta.QUERY_LOGIC , StorehouseAttrVVOMeta.REQUEST_ACTION , StorehouseAttrVVOMeta.IDS } )
	@SentinelResource(value = StorehouseAttrVServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseAttrVServiceProxy.SAVE)
	public Result save(StorehouseAttrVVO storehouseAttrVVO) {
		
		Result result=storehouseAttrVService.save(storehouseAttrVVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取仓库属性
	*/
	@ApiOperation(value = "获取仓库属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StorehouseAttrVServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseAttrVServiceProxy.GET_BY_ID)
	public Result<StorehouseAttrV> getById(String id) {
		
		Result<StorehouseAttrV> result=new Result<>();
		StorehouseAttrV storehouseAttrV=storehouseAttrVService.getById(id);
		result.success(true).data(storehouseAttrV);
		return result;
	}


	/**
	 * 批量获取仓库属性 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取仓库属性")
		@ApiImplicitParams({
				@ApiImplicitParam(name = StorehouseAttrVVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = StorehouseAttrVServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseAttrVServiceProxy.GET_BY_IDS)
	public Result<List<StorehouseAttrV>> getByIds(List<String> ids) {
		
		Result<List<StorehouseAttrV>> result=new Result<>();
		List<StorehouseAttrV> list=storehouseAttrVService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询仓库属性
	*/
	@ApiOperation(value = "查询仓库属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684130665242820608"),
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.STORE_ID , value = "仓库" , required = false , dataTypeClass=String.class , example = "684034962759876608"),
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.ATTR_ID , value = "属性" , required = false , dataTypeClass=String.class , example = "684022092424806400"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { StorehouseAttrVVOMeta.PAGE_INDEX , StorehouseAttrVVOMeta.PAGE_SIZE } )
	@SentinelResource(value = StorehouseAttrVServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseAttrVServiceProxy.QUERY_LIST)
	public Result<List<StorehouseAttrV>> queryList(StorehouseAttrVVO sample) {
		
		Result<List<StorehouseAttrV>> result=new Result<>();
		List<StorehouseAttrV> list=storehouseAttrVService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询仓库属性
	*/
	@ApiOperation(value = "分页查询仓库属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684130665242820608"),
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.STORE_ID , value = "仓库" , required = false , dataTypeClass=String.class , example = "684034962759876608"),
		@ApiImplicitParam(name = StorehouseAttrVVOMeta.ATTR_ID , value = "属性" , required = false , dataTypeClass=String.class , example = "684022092424806400"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = StorehouseAttrVServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(StorehouseAttrVServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<StorehouseAttrV>> queryPagedList(StorehouseAttrVVO sample) {
		
		Result<PagedList<StorehouseAttrV>> result=new Result<>();
		PagedList<StorehouseAttrV> list=storehouseAttrVService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}