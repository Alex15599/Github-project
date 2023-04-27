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


import com.dt.platform.proxy.eam.AssetLabelPaperServiceProxy;
import com.dt.platform.domain.eam.meta.AssetLabelPaperVOMeta;
import com.dt.platform.domain.eam.AssetLabelPaper;
import com.dt.platform.domain.eam.AssetLabelPaperVO;
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
import com.dt.platform.domain.eam.meta.AssetLabelPaperMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetLabelPaperService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 纸张类型接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-03 12:56:15
*/

@InDoc
@Api(tags = "纸张类型")
@RestController("EamAssetLabelPaperController")
public class AssetLabelPaperController extends SuperController {

	@Autowired
	private IAssetLabelPaperService assetLabelPaperService;


	/**
	 * 添加纸张类型
	*/
	@ApiOperation(value = "添加纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "标签专用纸"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.STATUS , value = "是否启用" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.W , value = "长度" , required = false , dataTypeClass=BigDecimal.class , example = "232.00"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.H , value = "宽带" , required = false , dataTypeClass=BigDecimal.class , example = "174.00"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ACTION_CODE , value = "实现动作" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.COLUMN_NUMBER , value = "列数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetLabelPaperServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.INSERT)
	public Result insert(AssetLabelPaperVO assetLabelPaperVO) {
		Result result=assetLabelPaperService.insert(assetLabelPaperVO,false);
		return result;
	}



	/**
	 * 删除纸张类型
	*/
	@ApiOperation(value = "删除纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetLabelPaperServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetLabelPaperService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assetLabelPaperService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除纸张类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetLabelPaperServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetLabelPaperService.hasRefers(ids);
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
			Result result=assetLabelPaperService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetLabelPaperService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新纸张类型
	*/
	@ApiOperation(value = "更新纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "标签专用纸"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.STATUS , value = "是否启用" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.W , value = "长度" , required = false , dataTypeClass=BigDecimal.class , example = "232.00"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.H , value = "宽带" , required = false , dataTypeClass=BigDecimal.class , example = "174.00"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ACTION_CODE , value = "实现动作" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.COLUMN_NUMBER , value = "列数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetLabelPaperVOMeta.PAGE_INDEX , AssetLabelPaperVOMeta.PAGE_SIZE , AssetLabelPaperVOMeta.SEARCH_FIELD , AssetLabelPaperVOMeta.FUZZY_FIELD , AssetLabelPaperVOMeta.SEARCH_VALUE , AssetLabelPaperVOMeta.DIRTY_FIELDS , AssetLabelPaperVOMeta.SORT_FIELD , AssetLabelPaperVOMeta.SORT_TYPE , AssetLabelPaperVOMeta.IDS } )
	@SentinelResource(value = AssetLabelPaperServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.UPDATE)
	public Result update(AssetLabelPaperVO assetLabelPaperVO) {
		Result result=assetLabelPaperService.update(assetLabelPaperVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存纸张类型
	*/
	@ApiOperation(value = "保存纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "标签专用纸"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.STATUS , value = "是否启用" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.W , value = "长度" , required = false , dataTypeClass=BigDecimal.class , example = "232.00"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.H , value = "宽带" , required = false , dataTypeClass=BigDecimal.class , example = "174.00"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ACTION_CODE , value = "实现动作" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.COLUMN_NUMBER , value = "列数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetLabelPaperVOMeta.PAGE_INDEX , AssetLabelPaperVOMeta.PAGE_SIZE , AssetLabelPaperVOMeta.SEARCH_FIELD , AssetLabelPaperVOMeta.FUZZY_FIELD , AssetLabelPaperVOMeta.SEARCH_VALUE , AssetLabelPaperVOMeta.DIRTY_FIELDS , AssetLabelPaperVOMeta.SORT_FIELD , AssetLabelPaperVOMeta.SORT_TYPE , AssetLabelPaperVOMeta.IDS } )
	@SentinelResource(value = AssetLabelPaperServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.SAVE)
	public Result save(AssetLabelPaperVO assetLabelPaperVO) {
		Result result=assetLabelPaperService.save(assetLabelPaperVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取纸张类型
	*/
	@ApiOperation(value = "获取纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetLabelPaperServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.GET_BY_ID)
	public Result<AssetLabelPaper> getById(String id) {
		Result<AssetLabelPaper> result=new Result<>();
		AssetLabelPaper assetLabelPaper=assetLabelPaperService.getById(id);
		result.success(true).data(assetLabelPaper);
		return result;
	}


	/**
	 * 批量获取纸张类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取纸张类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetLabelPaperVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetLabelPaperServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.GET_BY_IDS)
	public Result<List<AssetLabelPaper>> getByIds(List<String> ids) {
		Result<List<AssetLabelPaper>> result=new Result<>();
		List<AssetLabelPaper> list=assetLabelPaperService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询纸张类型
	*/
	@ApiOperation(value = "查询纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "标签专用纸"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.STATUS , value = "是否启用" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.W , value = "长度" , required = false , dataTypeClass=BigDecimal.class , example = "232.00"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.H , value = "宽带" , required = false , dataTypeClass=BigDecimal.class , example = "174.00"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ACTION_CODE , value = "实现动作" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.COLUMN_NUMBER , value = "列数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetLabelPaperVOMeta.PAGE_INDEX , AssetLabelPaperVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetLabelPaperServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.QUERY_LIST)
	public Result<List<AssetLabelPaper>> queryList(AssetLabelPaperVO sample) {
		Result<List<AssetLabelPaper>> result=new Result<>();
		List<AssetLabelPaper> list=assetLabelPaperService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询纸张类型
	*/
	@ApiOperation(value = "分页查询纸张类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "标签专用纸"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.STATUS , value = "是否启用" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.W , value = "长度" , required = false , dataTypeClass=BigDecimal.class , example = "232.00"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.H , value = "宽带" , required = false , dataTypeClass=BigDecimal.class , example = "174.00"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.ACTION_CODE , value = "实现动作" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "special"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.COLUMN_NUMBER , value = "列数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelPaperVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetLabelPaperServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelPaperServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetLabelPaper>> queryPagedList(AssetLabelPaperVO sample) {
		Result<PagedList<AssetLabelPaper>> result=new Result<>();
		PagedList<AssetLabelPaper> list=assetLabelPaperService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}