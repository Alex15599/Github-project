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


import com.dt.platform.proxy.wms.RegionServiceProxy;
import com.dt.platform.domain.wms.meta.RegionVOMeta;
import com.dt.platform.domain.wms.Region;
import com.dt.platform.domain.wms.RegionVO;
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
import com.dt.platform.domain.wms.meta.RegionMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IRegionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 大区接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:30:21
*/

@InDoc
@Api(tags = "大区")
@RestController("WmsRegionController")
public class RegionController extends SuperController {

	@Autowired
	private IRegionService regionService;

	/**
	 * 添加大区
	*/
	@ApiOperation(value = "添加大区")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684017707279974400"),
		@ApiImplicitParam(name = RegionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "大区1"),
		@ApiImplicitParam(name = RegionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "大区1"),
		@ApiImplicitParam(name = RegionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "大区1"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RegionServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RegionServiceProxy.INSERT)
	public Result insert(RegionVO regionVO) {
		
		Result result=regionService.insert(regionVO,false);
		return result;
	}



	/**
	 * 删除大区
	*/
	@ApiOperation(value = "删除大区")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684017707279974400")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RegionServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RegionServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  regionService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=regionService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除大区 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除大区")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RegionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = RegionServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RegionServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = regionService.hasRefers(ids);
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
			Result result=regionService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=regionService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新大区
	*/
	@ApiOperation(value = "更新大区")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684017707279974400"),
		@ApiImplicitParam(name = RegionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "大区1"),
		@ApiImplicitParam(name = RegionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "大区1"),
		@ApiImplicitParam(name = RegionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "大区1"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RegionVOMeta.PAGE_INDEX , RegionVOMeta.PAGE_SIZE , RegionVOMeta.SEARCH_FIELD , RegionVOMeta.FUZZY_FIELD , RegionVOMeta.SEARCH_VALUE , RegionVOMeta.DIRTY_FIELDS , RegionVOMeta.SORT_FIELD , RegionVOMeta.SORT_TYPE , RegionVOMeta.DATA_ORIGIN , RegionVOMeta.QUERY_LOGIC , RegionVOMeta.REQUEST_ACTION , RegionVOMeta.IDS } )
	@SentinelResource(value = RegionServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RegionServiceProxy.UPDATE)
	public Result update(RegionVO regionVO) {
		
		Result result=regionService.update(regionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存大区
	*/
	@ApiOperation(value = "保存大区")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684017707279974400"),
		@ApiImplicitParam(name = RegionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "大区1"),
		@ApiImplicitParam(name = RegionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "大区1"),
		@ApiImplicitParam(name = RegionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "大区1"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { RegionVOMeta.PAGE_INDEX , RegionVOMeta.PAGE_SIZE , RegionVOMeta.SEARCH_FIELD , RegionVOMeta.FUZZY_FIELD , RegionVOMeta.SEARCH_VALUE , RegionVOMeta.DIRTY_FIELDS , RegionVOMeta.SORT_FIELD , RegionVOMeta.SORT_TYPE , RegionVOMeta.DATA_ORIGIN , RegionVOMeta.QUERY_LOGIC , RegionVOMeta.REQUEST_ACTION , RegionVOMeta.IDS } )
	@SentinelResource(value = RegionServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RegionServiceProxy.SAVE)
	public Result save(RegionVO regionVO) {
		
		Result result=regionService.save(regionVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取大区
	*/
	@ApiOperation(value = "获取大区")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RegionServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RegionServiceProxy.GET_BY_ID)
	public Result<Region> getById(String id) {
		
		Result<Region> result=new Result<>();
		Region region=regionService.getById(id);
		result.success(true).data(region);
		return result;
	}


	/**
	 * 批量获取大区 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取大区")
		@ApiImplicitParams({
				@ApiImplicitParam(name = RegionVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = RegionServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RegionServiceProxy.GET_BY_IDS)
	public Result<List<Region>> getByIds(List<String> ids) {
		
		Result<List<Region>> result=new Result<>();
		List<Region> list=regionService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询大区
	*/
	@ApiOperation(value = "查询大区")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684017707279974400"),
		@ApiImplicitParam(name = RegionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "大区1"),
		@ApiImplicitParam(name = RegionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "大区1"),
		@ApiImplicitParam(name = RegionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "大区1"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { RegionVOMeta.PAGE_INDEX , RegionVOMeta.PAGE_SIZE } )
	@SentinelResource(value = RegionServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RegionServiceProxy.QUERY_LIST)
	public Result<List<Region>> queryList(RegionVO sample) {
		
		Result<List<Region>> result=new Result<>();
		List<Region> list=regionService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询大区
	*/
	@ApiOperation(value = "分页查询大区")
	@ApiImplicitParams({
		@ApiImplicitParam(name = RegionVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684017707279974400"),
		@ApiImplicitParam(name = RegionVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "大区1"),
		@ApiImplicitParam(name = RegionVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "大区1"),
		@ApiImplicitParam(name = RegionVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "大区1"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = RegionServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(RegionServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Region>> queryPagedList(RegionVO sample) {
		
		Result<PagedList<Region>> result=new Result<>();
		PagedList<Region> list=regionService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}