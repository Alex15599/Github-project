package com.dt.platform.eam.controller;

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


import com.dt.platform.proxy.eam.AssetDepreciationExcludeServiceProxy;
import com.dt.platform.domain.eam.meta.AssetDepreciationExcludeVOMeta;
import com.dt.platform.domain.eam.AssetDepreciationExclude;
import com.dt.platform.domain.eam.AssetDepreciationExcludeVO;
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
import com.dt.platform.domain.eam.meta.AssetDepreciationExcludeMeta;
import com.dt.platform.domain.eam.AssetDepreciation;
import com.dt.platform.domain.eam.Asset;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetDepreciationExcludeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 折旧排除接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-28 20:42:05
*/

@InDoc
@Api(tags = "折旧排除")
@RestController("EamAssetDepreciationExcludeController")
public class AssetDepreciationExcludeController extends SuperController {

	@Autowired
	private IAssetDepreciationExcludeService assetDepreciationExcludeService;


	/**
	 * 添加折旧排除
	*/
	@ApiOperation(value = "添加折旧排除")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "649264051653705728"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "649264028098494465"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "647736203386290176"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "折旧排除"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetDepreciationExcludeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationExcludeServiceProxy.INSERT)
	public Result insert(AssetDepreciationExcludeVO assetDepreciationExcludeVO) {
		Result result=assetDepreciationExcludeService.insert(assetDepreciationExcludeVO,false);
		return result;
	}



	/**
	 * 删除折旧排除
	*/
	@ApiOperation(value = "删除折旧排除")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "649264051653705728")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetDepreciationExcludeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationExcludeServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetDepreciationExcludeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assetDepreciationExcludeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除折旧排除 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除折旧排除")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetDepreciationExcludeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationExcludeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetDepreciationExcludeService.hasRefers(ids);
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
			Result result=assetDepreciationExcludeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetDepreciationExcludeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新折旧排除
	*/
	@ApiOperation(value = "更新折旧排除")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "649264051653705728"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "649264028098494465"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "647736203386290176"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "折旧排除"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetDepreciationExcludeVOMeta.PAGE_INDEX , AssetDepreciationExcludeVOMeta.PAGE_SIZE , AssetDepreciationExcludeVOMeta.SEARCH_FIELD , AssetDepreciationExcludeVOMeta.FUZZY_FIELD , AssetDepreciationExcludeVOMeta.SEARCH_VALUE , AssetDepreciationExcludeVOMeta.DIRTY_FIELDS , AssetDepreciationExcludeVOMeta.SORT_FIELD , AssetDepreciationExcludeVOMeta.SORT_TYPE , AssetDepreciationExcludeVOMeta.IDS } )
	@SentinelResource(value = AssetDepreciationExcludeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationExcludeServiceProxy.UPDATE)
	public Result update(AssetDepreciationExcludeVO assetDepreciationExcludeVO) {
		Result result=assetDepreciationExcludeService.update(assetDepreciationExcludeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存折旧排除
	*/
	@ApiOperation(value = "保存折旧排除")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "649264051653705728"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "649264028098494465"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "647736203386290176"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "折旧排除"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDepreciationExcludeVOMeta.PAGE_INDEX , AssetDepreciationExcludeVOMeta.PAGE_SIZE , AssetDepreciationExcludeVOMeta.SEARCH_FIELD , AssetDepreciationExcludeVOMeta.FUZZY_FIELD , AssetDepreciationExcludeVOMeta.SEARCH_VALUE , AssetDepreciationExcludeVOMeta.DIRTY_FIELDS , AssetDepreciationExcludeVOMeta.SORT_FIELD , AssetDepreciationExcludeVOMeta.SORT_TYPE , AssetDepreciationExcludeVOMeta.IDS } )
	@SentinelResource(value = AssetDepreciationExcludeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationExcludeServiceProxy.SAVE)
	public Result save(AssetDepreciationExcludeVO assetDepreciationExcludeVO) {
		Result result=assetDepreciationExcludeService.save(assetDepreciationExcludeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取折旧排除
	*/
	@ApiOperation(value = "获取折旧排除")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetDepreciationExcludeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationExcludeServiceProxy.GET_BY_ID)
	public Result<AssetDepreciationExclude> getById(String id) {
		Result<AssetDepreciationExclude> result=new Result<>();
		AssetDepreciationExclude assetDepreciationExclude=assetDepreciationExcludeService.getById(id);
		// join 关联的对象
		assetDepreciationExcludeService.dao().fill(assetDepreciationExclude)
			.with(AssetDepreciationExcludeMeta.ASSET_DEPRECIATION)
			.with(AssetDepreciationExcludeMeta.ASSET)
			.execute();
		result.success(true).data(assetDepreciationExclude);
		return result;
	}


	/**
	 * 批量获取折旧排除 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取折旧排除")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetDepreciationExcludeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationExcludeServiceProxy.GET_BY_IDS)
	public Result<List<AssetDepreciationExclude>> getByIds(List<String> ids) {
		Result<List<AssetDepreciationExclude>> result=new Result<>();
		List<AssetDepreciationExclude> list=assetDepreciationExcludeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询折旧排除
	*/
	@ApiOperation(value = "查询折旧排除")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "649264051653705728"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "649264028098494465"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "647736203386290176"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "折旧排除"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetDepreciationExcludeVOMeta.PAGE_INDEX , AssetDepreciationExcludeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetDepreciationExcludeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationExcludeServiceProxy.QUERY_LIST)
	public Result<List<AssetDepreciationExclude>> queryList(AssetDepreciationExcludeVO sample) {
		Result<List<AssetDepreciationExclude>> result=new Result<>();
		List<AssetDepreciationExclude> list=assetDepreciationExcludeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询折旧排除
	*/
	@ApiOperation(value = "分页查询折旧排除")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "649264051653705728"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class , example = "649264028098494465"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "647736203386290176"),
		@ApiImplicitParam(name = AssetDepreciationExcludeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "折旧排除"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetDepreciationExcludeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationExcludeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetDepreciationExclude>> queryPagedList(AssetDepreciationExcludeVO sample) {
		Result<PagedList<AssetDepreciationExclude>> result=new Result<>();
		PagedList<AssetDepreciationExclude> list=assetDepreciationExcludeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetDepreciationExcludeService.dao().fill(list)
			.with(AssetDepreciationExcludeMeta.ASSET_DEPRECIATION)
			.with(AssetDepreciationExcludeMeta.ASSET)
			.execute();
		result.success(true).data(list);
		return result;
	}






}