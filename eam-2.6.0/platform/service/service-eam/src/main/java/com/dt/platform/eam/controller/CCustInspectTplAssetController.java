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


import com.dt.platform.proxy.eam.CCustInspectTplAssetServiceProxy;
import com.dt.platform.domain.eam.meta.CCustInspectTplAssetVOMeta;
import com.dt.platform.domain.eam.CCustInspectTplAsset;
import com.dt.platform.domain.eam.CCustInspectTplAssetVO;
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
import com.dt.platform.domain.eam.meta.CCustInspectTplAssetMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICCustInspectTplAssetService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 设备接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-08 19:00:26
*/

@InDoc
@Api(tags = "设备")
@RestController("EamCCustInspectTplAssetController")
public class CCustInspectTplAssetController extends SuperController {

	@Autowired
	private ICCustInspectTplAssetService cCustInspectTplAssetService;

	/**
	 * 添加设备
	*/
	@ApiOperation(value = "添加设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.OWNER_ID , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectTplAssetServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplAssetServiceProxy.INSERT)
	public Result insert(CCustInspectTplAssetVO cCustInspectTplAssetVO) {
		
		Result result=cCustInspectTplAssetService.insert(cCustInspectTplAssetVO,false);
		return result;
	}



	/**
	 * 删除设备
	*/
	@ApiOperation(value = "删除设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectTplAssetServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplAssetServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  cCustInspectTplAssetService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=cCustInspectTplAssetService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除设备 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CCustInspectTplAssetServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplAssetServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = cCustInspectTplAssetService.hasRefers(ids);
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
			Result result=cCustInspectTplAssetService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=cCustInspectTplAssetService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新设备
	*/
	@ApiOperation(value = "更新设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.OWNER_ID , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustInspectTplAssetVOMeta.PAGE_INDEX , CCustInspectTplAssetVOMeta.PAGE_SIZE , CCustInspectTplAssetVOMeta.SEARCH_FIELD , CCustInspectTplAssetVOMeta.FUZZY_FIELD , CCustInspectTplAssetVOMeta.SEARCH_VALUE , CCustInspectTplAssetVOMeta.DIRTY_FIELDS , CCustInspectTplAssetVOMeta.SORT_FIELD , CCustInspectTplAssetVOMeta.SORT_TYPE , CCustInspectTplAssetVOMeta.DATA_ORIGIN , CCustInspectTplAssetVOMeta.QUERY_LOGIC , CCustInspectTplAssetVOMeta.REQUEST_ACTION , CCustInspectTplAssetVOMeta.IDS } )
	@SentinelResource(value = CCustInspectTplAssetServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplAssetServiceProxy.UPDATE)
	public Result update(CCustInspectTplAssetVO cCustInspectTplAssetVO) {
		
		Result result=cCustInspectTplAssetService.update(cCustInspectTplAssetVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存设备
	*/
	@ApiOperation(value = "保存设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.OWNER_ID , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CCustInspectTplAssetVOMeta.PAGE_INDEX , CCustInspectTplAssetVOMeta.PAGE_SIZE , CCustInspectTplAssetVOMeta.SEARCH_FIELD , CCustInspectTplAssetVOMeta.FUZZY_FIELD , CCustInspectTplAssetVOMeta.SEARCH_VALUE , CCustInspectTplAssetVOMeta.DIRTY_FIELDS , CCustInspectTplAssetVOMeta.SORT_FIELD , CCustInspectTplAssetVOMeta.SORT_TYPE , CCustInspectTplAssetVOMeta.DATA_ORIGIN , CCustInspectTplAssetVOMeta.QUERY_LOGIC , CCustInspectTplAssetVOMeta.REQUEST_ACTION , CCustInspectTplAssetVOMeta.IDS } )
	@SentinelResource(value = CCustInspectTplAssetServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplAssetServiceProxy.SAVE)
	public Result save(CCustInspectTplAssetVO cCustInspectTplAssetVO) {
		
		Result result=cCustInspectTplAssetService.save(cCustInspectTplAssetVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取设备
	*/
	@ApiOperation(value = "获取设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectTplAssetServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplAssetServiceProxy.GET_BY_ID)
	public Result<CCustInspectTplAsset> getById(String id) {
		
		Result<CCustInspectTplAsset> result=new Result<>();
		CCustInspectTplAsset cCustInspectTplAsset=cCustInspectTplAssetService.getById(id);
		result.success(true).data(cCustInspectTplAsset);
		return result;
	}


	/**
	 * 批量获取设备 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取设备")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CCustInspectTplAssetServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplAssetServiceProxy.GET_BY_IDS)
	public Result<List<CCustInspectTplAsset>> getByIds(List<String> ids) {
		
		Result<List<CCustInspectTplAsset>> result=new Result<>();
		List<CCustInspectTplAsset> list=cCustInspectTplAssetService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询设备
	*/
	@ApiOperation(value = "查询设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.OWNER_ID , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CCustInspectTplAssetVOMeta.PAGE_INDEX , CCustInspectTplAssetVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CCustInspectTplAssetServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplAssetServiceProxy.QUERY_LIST)
	public Result<List<CCustInspectTplAsset>> queryList(CCustInspectTplAssetVO sample) {
		
		Result<List<CCustInspectTplAsset>> result=new Result<>();
		List<CCustInspectTplAsset> list=cCustInspectTplAssetService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询设备
	*/
	@ApiOperation(value = "分页查询设备")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.OWNER_ID , value = "归属" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = CCustInspectTplAssetVOMeta.ASSET_ID , value = "资产" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CCustInspectTplAssetServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CCustInspectTplAssetServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CCustInspectTplAsset>> queryPagedList(CCustInspectTplAssetVO sample) {
		
		Result<PagedList<CCustInspectTplAsset>> result=new Result<>();
		PagedList<CCustInspectTplAsset> list=cCustInspectTplAssetService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}