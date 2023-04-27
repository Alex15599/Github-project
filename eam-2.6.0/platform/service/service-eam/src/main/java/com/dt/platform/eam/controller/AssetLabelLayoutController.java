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


import com.dt.platform.proxy.eam.AssetLabelLayoutServiceProxy;
import com.dt.platform.domain.eam.meta.AssetLabelLayoutVOMeta;
import com.dt.platform.domain.eam.AssetLabelLayout;
import com.dt.platform.domain.eam.AssetLabelLayoutVO;
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
import com.dt.platform.domain.eam.meta.AssetLabelLayoutMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetLabelLayoutService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 标签布局接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-02 19:38:47
*/

@InDoc
@Api(tags = "标签布局")
@RestController("EamAssetLabelLayoutController")
public class AssetLabelLayoutController extends SuperController {

	@Autowired
	private IAssetLabelLayoutService assetLabelLayoutService;


	/**
	 * 添加标签布局
	*/
	@ApiOperation(value = "添加标签布局")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class , example = "650449362169626624"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_ID , value = "字段ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_CODE , value = "字段编码" , required = false , dataTypeClass=String.class , example = "资产"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "label"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_NUMBER , value = "行数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_HEIGHT , value = "行高度" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_SPAN , value = "row" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_SPAN , value = "col" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetLabelLayoutServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelLayoutServiceProxy.INSERT)
	public Result insert(AssetLabelLayoutVO assetLabelLayoutVO) {
		Result result=assetLabelLayoutService.insert(assetLabelLayoutVO,false);
		return result;
	}



	/**
	 * 删除标签布局
	*/
	@ApiOperation(value = "删除标签布局")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetLabelLayoutServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelLayoutServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetLabelLayoutService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assetLabelLayoutService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除标签布局 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除标签布局")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetLabelLayoutServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelLayoutServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetLabelLayoutService.hasRefers(ids);
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
			Result result=assetLabelLayoutService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetLabelLayoutService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新标签布局
	*/
	@ApiOperation(value = "更新标签布局")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class , example = "650449362169626624"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_ID , value = "字段ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_CODE , value = "字段编码" , required = false , dataTypeClass=String.class , example = "资产"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "label"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_NUMBER , value = "行数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_HEIGHT , value = "行高度" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_SPAN , value = "row" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_SPAN , value = "col" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetLabelLayoutVOMeta.PAGE_INDEX , AssetLabelLayoutVOMeta.PAGE_SIZE , AssetLabelLayoutVOMeta.SEARCH_FIELD , AssetLabelLayoutVOMeta.FUZZY_FIELD , AssetLabelLayoutVOMeta.SEARCH_VALUE , AssetLabelLayoutVOMeta.DIRTY_FIELDS , AssetLabelLayoutVOMeta.SORT_FIELD , AssetLabelLayoutVOMeta.SORT_TYPE , AssetLabelLayoutVOMeta.IDS } )
	@SentinelResource(value = AssetLabelLayoutServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelLayoutServiceProxy.UPDATE)
	public Result update(AssetLabelLayoutVO assetLabelLayoutVO) {
		Result result=assetLabelLayoutService.update(assetLabelLayoutVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存标签布局
	*/
	@ApiOperation(value = "保存标签布局")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class , example = "650449362169626624"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_ID , value = "字段ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_CODE , value = "字段编码" , required = false , dataTypeClass=String.class , example = "资产"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "label"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_NUMBER , value = "行数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_HEIGHT , value = "行高度" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_SPAN , value = "row" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_SPAN , value = "col" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetLabelLayoutVOMeta.PAGE_INDEX , AssetLabelLayoutVOMeta.PAGE_SIZE , AssetLabelLayoutVOMeta.SEARCH_FIELD , AssetLabelLayoutVOMeta.FUZZY_FIELD , AssetLabelLayoutVOMeta.SEARCH_VALUE , AssetLabelLayoutVOMeta.DIRTY_FIELDS , AssetLabelLayoutVOMeta.SORT_FIELD , AssetLabelLayoutVOMeta.SORT_TYPE , AssetLabelLayoutVOMeta.IDS } )
	@SentinelResource(value = AssetLabelLayoutServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelLayoutServiceProxy.SAVE)
	public Result save(AssetLabelLayoutVO assetLabelLayoutVO) {
		Result result=assetLabelLayoutService.save(assetLabelLayoutVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取标签布局
	*/
	@ApiOperation(value = "获取标签布局")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetLabelLayoutServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelLayoutServiceProxy.GET_BY_ID)
	public Result<AssetLabelLayout> getById(String id) {
		Result<AssetLabelLayout> result=new Result<>();
		AssetLabelLayout assetLabelLayout=assetLabelLayoutService.getById(id);
		result.success(true).data(assetLabelLayout);
		return result;
	}


	/**
	 * 批量获取标签布局 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取标签布局")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetLabelLayoutVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetLabelLayoutServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelLayoutServiceProxy.GET_BY_IDS)
	public Result<List<AssetLabelLayout>> getByIds(List<String> ids) {
		Result<List<AssetLabelLayout>> result=new Result<>();
		List<AssetLabelLayout> list=assetLabelLayoutService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询标签布局
	*/
	@ApiOperation(value = "查询标签布局")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class , example = "650449362169626624"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_ID , value = "字段ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_CODE , value = "字段编码" , required = false , dataTypeClass=String.class , example = "资产"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "label"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_NUMBER , value = "行数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_HEIGHT , value = "行高度" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_SPAN , value = "row" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_SPAN , value = "col" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetLabelLayoutVOMeta.PAGE_INDEX , AssetLabelLayoutVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetLabelLayoutServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelLayoutServiceProxy.QUERY_LIST)
	public Result<List<AssetLabelLayout>> queryList(AssetLabelLayoutVO sample) {
		Result<List<AssetLabelLayout>> result=new Result<>();
		List<AssetLabelLayout> list=assetLabelLayoutService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询标签布局
	*/
	@ApiOperation(value = "分页查询标签布局")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.TPL_ID , value = "模版" , required = false , dataTypeClass=String.class , example = "650449362169626624"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_ID , value = "字段ID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_CODE , value = "字段编码" , required = false , dataTypeClass=String.class , example = "资产"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "label"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_NUMBER , value = "行数" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_HEIGHT , value = "行高度" , required = false , dataTypeClass=BigDecimal.class , example = "2.00"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.ROW_SPAN , value = "row" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.COL_SPAN , value = "col" , required = false , dataTypeClass=Integer.class , example = "1"),
		@ApiImplicitParam(name = AssetLabelLayoutVOMeta.SORT , value = "顺序" , required = false , dataTypeClass=Integer.class , example = "0"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetLabelLayoutServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetLabelLayoutServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetLabelLayout>> queryPagedList(AssetLabelLayoutVO sample) {
		Result<PagedList<AssetLabelLayout>> result=new Result<>();
		PagedList<AssetLabelLayout> list=assetLabelLayoutService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}