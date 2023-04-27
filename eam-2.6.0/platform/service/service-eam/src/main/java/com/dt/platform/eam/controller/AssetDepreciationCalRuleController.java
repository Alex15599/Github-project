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


import com.dt.platform.proxy.eam.AssetDepreciationCalRuleServiceProxy;
import com.dt.platform.domain.eam.meta.AssetDepreciationCalRuleVOMeta;
import com.dt.platform.domain.eam.AssetDepreciationCalRule;
import com.dt.platform.domain.eam.AssetDepreciationCalRuleVO;
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
import com.dt.platform.domain.eam.meta.AssetDepreciationCalRuleMeta;
import com.dt.platform.domain.eam.AssetDepreciation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetDepreciationCalRuleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 计算方法接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-27 17:04:42
*/

@InDoc
@Api(tags = "计算方法")
@RestController("EamAssetDepreciationCalRuleController")
public class AssetDepreciationCalRuleController extends SuperController {

	@Autowired
	private IAssetDepreciationCalRuleService assetDepreciationCalRuleService;


	/**
	 * 添加计算方法
	*/
	@ApiOperation(value = "添加计算方法")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "647736203386290176"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.ACTION_CODE , value = "动作" , required = false , dataTypeClass=String.class , example = "depreciation_normal"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.RULE_NUMBER , value = "规则编号" , required = false , dataTypeClass=Integer.class , example = "300"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.COLUMN_VALUE , value = "字段值" , required = false , dataTypeClass=String.class , example = "s_original_price"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.COLUMN_NAME , value = "字段名称" , required = false , dataTypeClass=String.class , example = "(期初)期初原值"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.CALCULATION_TYPE , value = "计算类型" , required = false , dataTypeClass=String.class , example = "jexl_expression"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.METHOD_CONTENT , value = "计算方法" , required = false , dataTypeClass=String.class , example = "asset.assetOriginalUnitPrice"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.METHOD_CONTENT_INFO , value = "方法描述" , required = false , dataTypeClass=String.class , example = "(期初)期初原值=上一期期末原值"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.RETURN_TYPE , value = "返回类型" , required = false , dataTypeClass=String.class , example = "double"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetDepreciationCalRuleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCalRuleServiceProxy.INSERT)
	public Result insert(AssetDepreciationCalRuleVO assetDepreciationCalRuleVO) {
		Result result=assetDepreciationCalRuleService.insert(assetDepreciationCalRuleVO,false);
		return result;
	}



	/**
	 * 删除计算方法
	*/
	@ApiOperation(value = "删除计算方法")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetDepreciationCalRuleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCalRuleServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause = assetDepreciationCalRuleService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assetDepreciationCalRuleService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除计算方法 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除计算方法")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetDepreciationCalRuleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCalRuleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetDepreciationCalRuleService.hasRefers(ids);
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
			Result result=assetDepreciationCalRuleService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetDepreciationCalRuleService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新计算方法
	*/
	@ApiOperation(value = "更新计算方法")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "647736203386290176"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.ACTION_CODE , value = "动作" , required = false , dataTypeClass=String.class , example = "depreciation_normal"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.RULE_NUMBER , value = "规则编号" , required = false , dataTypeClass=Integer.class , example = "300"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.COLUMN_VALUE , value = "字段值" , required = false , dataTypeClass=String.class , example = "s_original_price"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.COLUMN_NAME , value = "字段名称" , required = false , dataTypeClass=String.class , example = "(期初)期初原值"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.CALCULATION_TYPE , value = "计算类型" , required = false , dataTypeClass=String.class , example = "jexl_expression"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.METHOD_CONTENT , value = "计算方法" , required = false , dataTypeClass=String.class , example = "asset.assetOriginalUnitPrice"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.METHOD_CONTENT_INFO , value = "方法描述" , required = false , dataTypeClass=String.class , example = "(期初)期初原值=上一期期末原值"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.RETURN_TYPE , value = "返回类型" , required = false , dataTypeClass=String.class , example = "double"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetDepreciationCalRuleVOMeta.PAGE_INDEX , AssetDepreciationCalRuleVOMeta.PAGE_SIZE , AssetDepreciationCalRuleVOMeta.SEARCH_FIELD , AssetDepreciationCalRuleVOMeta.FUZZY_FIELD , AssetDepreciationCalRuleVOMeta.SEARCH_VALUE , AssetDepreciationCalRuleVOMeta.DIRTY_FIELDS , AssetDepreciationCalRuleVOMeta.SORT_FIELD , AssetDepreciationCalRuleVOMeta.SORT_TYPE , AssetDepreciationCalRuleVOMeta.IDS } )
	@SentinelResource(value = AssetDepreciationCalRuleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCalRuleServiceProxy.UPDATE)
	public Result update(AssetDepreciationCalRuleVO assetDepreciationCalRuleVO) {
		Result result=assetDepreciationCalRuleService.update(assetDepreciationCalRuleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存计算方法
	*/
	@ApiOperation(value = "保存计算方法")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "647736203386290176"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.ACTION_CODE , value = "动作" , required = false , dataTypeClass=String.class , example = "depreciation_normal"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.RULE_NUMBER , value = "规则编号" , required = false , dataTypeClass=Integer.class , example = "300"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.COLUMN_VALUE , value = "字段值" , required = false , dataTypeClass=String.class , example = "s_original_price"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.COLUMN_NAME , value = "字段名称" , required = false , dataTypeClass=String.class , example = "(期初)期初原值"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.CALCULATION_TYPE , value = "计算类型" , required = false , dataTypeClass=String.class , example = "jexl_expression"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.METHOD_CONTENT , value = "计算方法" , required = false , dataTypeClass=String.class , example = "asset.assetOriginalUnitPrice"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.METHOD_CONTENT_INFO , value = "方法描述" , required = false , dataTypeClass=String.class , example = "(期初)期初原值=上一期期末原值"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.RETURN_TYPE , value = "返回类型" , required = false , dataTypeClass=String.class , example = "double"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetDepreciationCalRuleVOMeta.PAGE_INDEX , AssetDepreciationCalRuleVOMeta.PAGE_SIZE , AssetDepreciationCalRuleVOMeta.SEARCH_FIELD , AssetDepreciationCalRuleVOMeta.FUZZY_FIELD , AssetDepreciationCalRuleVOMeta.SEARCH_VALUE , AssetDepreciationCalRuleVOMeta.DIRTY_FIELDS , AssetDepreciationCalRuleVOMeta.SORT_FIELD , AssetDepreciationCalRuleVOMeta.SORT_TYPE , AssetDepreciationCalRuleVOMeta.IDS } )
	@SentinelResource(value = AssetDepreciationCalRuleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCalRuleServiceProxy.SAVE)
	public Result save(AssetDepreciationCalRuleVO assetDepreciationCalRuleVO) {
		Result result=assetDepreciationCalRuleService.save(assetDepreciationCalRuleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取计算方法
	*/
	@ApiOperation(value = "获取计算方法")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetDepreciationCalRuleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCalRuleServiceProxy.GET_BY_ID)
	public Result<AssetDepreciationCalRule> getById(String id) {
		Result<AssetDepreciationCalRule> result=new Result<>();
		AssetDepreciationCalRule assetDepreciationCalRule=assetDepreciationCalRuleService.getById(id);
		// join 关联的对象
		assetDepreciationCalRuleService.dao().fill(assetDepreciationCalRule)
			.with(AssetDepreciationCalRuleMeta.ASSET_DEPRECIATION)
			.execute();
		result.success(true).data(assetDepreciationCalRule);
		return result;
	}


	/**
	 * 批量获取计算方法 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取计算方法")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetDepreciationCalRuleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCalRuleServiceProxy.GET_BY_IDS)
	public Result<List<AssetDepreciationCalRule>> getByIds(List<String> ids) {
		Result<List<AssetDepreciationCalRule>> result=new Result<>();
		List<AssetDepreciationCalRule> list=assetDepreciationCalRuleService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询计算方法
	*/
	@ApiOperation(value = "查询计算方法")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "647736203386290176"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.ACTION_CODE , value = "动作" , required = false , dataTypeClass=String.class , example = "depreciation_normal"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.RULE_NUMBER , value = "规则编号" , required = false , dataTypeClass=Integer.class , example = "300"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.COLUMN_VALUE , value = "字段值" , required = false , dataTypeClass=String.class , example = "s_original_price"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.COLUMN_NAME , value = "字段名称" , required = false , dataTypeClass=String.class , example = "(期初)期初原值"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.CALCULATION_TYPE , value = "计算类型" , required = false , dataTypeClass=String.class , example = "jexl_expression"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.METHOD_CONTENT , value = "计算方法" , required = false , dataTypeClass=String.class , example = "asset.assetOriginalUnitPrice"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.METHOD_CONTENT_INFO , value = "方法描述" , required = false , dataTypeClass=String.class , example = "(期初)期初原值=上一期期末原值"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.RETURN_TYPE , value = "返回类型" , required = false , dataTypeClass=String.class , example = "double"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetDepreciationCalRuleVOMeta.PAGE_INDEX , AssetDepreciationCalRuleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetDepreciationCalRuleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCalRuleServiceProxy.QUERY_LIST)
	public Result<List<AssetDepreciationCalRule>> queryList(AssetDepreciationCalRuleVO sample) {
		Result<List<AssetDepreciationCalRule>> result=new Result<>();
		List<AssetDepreciationCalRule> list=assetDepreciationCalRuleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询计算方法
	*/
	@ApiOperation(value = "分页查询计算方法")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.DEPRECIATION_ID , value = "折旧方案" , required = false , dataTypeClass=String.class , example = "647736203386290176"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.ACTION_CODE , value = "动作" , required = false , dataTypeClass=String.class , example = "depreciation_normal"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.RULE_NUMBER , value = "规则编号" , required = false , dataTypeClass=Integer.class , example = "300"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.COLUMN_VALUE , value = "字段值" , required = false , dataTypeClass=String.class , example = "s_original_price"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.COLUMN_NAME , value = "字段名称" , required = false , dataTypeClass=String.class , example = "(期初)期初原值"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.CALCULATION_TYPE , value = "计算类型" , required = false , dataTypeClass=String.class , example = "jexl_expression"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.METHOD_CONTENT , value = "计算方法" , required = false , dataTypeClass=String.class , example = "asset.assetOriginalUnitPrice"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.METHOD_CONTENT_INFO , value = "方法描述" , required = false , dataTypeClass=String.class , example = "(期初)期初原值=上一期期末原值"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.RETURN_TYPE , value = "返回类型" , required = false , dataTypeClass=String.class , example = "double"),
		@ApiImplicitParam(name = AssetDepreciationCalRuleVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetDepreciationCalRuleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetDepreciationCalRuleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetDepreciationCalRule>> queryPagedList(AssetDepreciationCalRuleVO sample) {
		Result<PagedList<AssetDepreciationCalRule>> result=new Result<>();
		PagedList<AssetDepreciationCalRule> list=assetDepreciationCalRuleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetDepreciationCalRuleService.dao().fill(list)
			.with(AssetDepreciationCalRuleMeta.ASSET_DEPRECIATION)
			.execute();
		result.success(true).data(list);
		return result;
	}






}