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


import com.dt.platform.proxy.eam.AssetRegionServiceProxy;
import com.dt.platform.domain.eam.meta.AssetRegionVOMeta;
import com.dt.platform.domain.eam.AssetRegion;
import com.dt.platform.domain.eam.AssetRegionVO;
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
import com.dt.platform.domain.eam.meta.AssetRegionMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetRegionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 存放区域接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-25 22:19:46
*/

@InDoc
@Api(tags = "存放区域")
@RestController("EamAssetRegionController")
public class AssetRegionController extends SuperController {

	@Autowired
	private IAssetRegionService assetRegionService;


	/**
	 * 添加存放区域
	*/
	@ApiOperation(value = "添加存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.REGION_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.REGION_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetRegionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRegionServiceProxy.INSERT)
	public Result insert(AssetRegionVO assetRegionVO) {
		Result result=assetRegionService.insert(assetRegionVO,false);
		return result;
	}



	/**
	 * 删除存放区域
	*/
	@ApiOperation(value = "删除存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetRegionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRegionServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetRegionService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=assetRegionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除存放区域 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRegionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetRegionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRegionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetRegionService.hasRefers(ids);
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
			Result result=assetRegionService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetRegionService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新存放区域
	*/
	@ApiOperation(value = "更新存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.REGION_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.REGION_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetRegionVOMeta.PAGE_INDEX , AssetRegionVOMeta.PAGE_SIZE , AssetRegionVOMeta.SEARCH_FIELD , AssetRegionVOMeta.FUZZY_FIELD , AssetRegionVOMeta.SEARCH_VALUE , AssetRegionVOMeta.DIRTY_FIELDS , AssetRegionVOMeta.SORT_FIELD , AssetRegionVOMeta.SORT_TYPE , AssetRegionVOMeta.IDS } )
	@SentinelResource(value = AssetRegionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRegionServiceProxy.UPDATE)
	public Result update(AssetRegionVO assetRegionVO) {
		Result result=assetRegionService.update(assetRegionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存存放区域
	*/
	@ApiOperation(value = "保存存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.REGION_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.REGION_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetRegionVOMeta.PAGE_INDEX , AssetRegionVOMeta.PAGE_SIZE , AssetRegionVOMeta.SEARCH_FIELD , AssetRegionVOMeta.FUZZY_FIELD , AssetRegionVOMeta.SEARCH_VALUE , AssetRegionVOMeta.DIRTY_FIELDS , AssetRegionVOMeta.SORT_FIELD , AssetRegionVOMeta.SORT_TYPE , AssetRegionVOMeta.IDS } )
	@SentinelResource(value = AssetRegionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRegionServiceProxy.SAVE)
	public Result save(AssetRegionVO assetRegionVO) {
		Result result=assetRegionService.save(assetRegionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取存放区域
	*/
	@ApiOperation(value = "获取存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetRegionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRegionServiceProxy.GET_BY_ID)
	public Result<AssetRegion> getById(String id) {
		Result<AssetRegion> result=new Result<>();
		AssetRegion assetRegion=assetRegionService.getById(id);
		result.success(true).data(assetRegion);
		return result;
	}


	/**
	 * 批量获取存放区域 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取存放区域")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetRegionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetRegionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRegionServiceProxy.GET_BY_IDS)
	public Result<List<AssetRegion>> getByIds(List<String> ids) {
		Result<List<AssetRegion>> result=new Result<>();
		List<AssetRegion> list=assetRegionService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询存放区域
	*/
	@ApiOperation(value = "查询存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.REGION_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.REGION_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetRegionVOMeta.PAGE_INDEX , AssetRegionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetRegionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRegionServiceProxy.QUERY_LIST)
	public Result<List<AssetRegion>> queryList(AssetRegionVO sample) {
		Result<List<AssetRegion>> result=new Result<>();
		List<AssetRegion> list=assetRegionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询存放区域
	*/
	@ApiOperation(value = "分页查询存放区域")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetRegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.REGION_NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.REGION_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.PARENT_ID , value = "父节点" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.SORT , value = "排序" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.HIERARCHY , value = "节点路径" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.HIERARCHY_NAME , value = "节点路径名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetRegionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetRegionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetRegionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetRegion>> queryPagedList(AssetRegionVO sample) {
		Result<PagedList<AssetRegion>> result=new Result<>();
		PagedList<AssetRegion> list=assetRegionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}