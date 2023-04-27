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


import com.dt.platform.proxy.wms.AreaInfoServiceProxy;
import com.dt.platform.domain.wms.meta.AreaInfoVOMeta;
import com.dt.platform.domain.wms.AreaInfo;
import com.dt.platform.domain.wms.AreaInfoVO;
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
import com.dt.platform.domain.wms.meta.AreaInfoMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IAreaInfoService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 地区信息接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:28:25
*/

@InDoc
@Api(tags = "地区信息")
@RestController("WmsAreaInfoController")
public class AreaInfoController extends SuperController {

	@Autowired
	private IAreaInfoService areaInfoService;

	/**
	 * 添加地区信息
	*/
	@ApiOperation(value = "添加地区信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.AREA_INFO_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.CITY_TYPE , value = "城市类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.REGION , value = "大区" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.AREA , value = "片区" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AreaInfoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaInfoServiceProxy.INSERT)
	public Result insert(AreaInfoVO areaInfoVO) {
		
		Result result=areaInfoService.insert(areaInfoVO,false);
		return result;
	}



	/**
	 * 删除地区信息
	*/
	@ApiOperation(value = "删除地区信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AreaInfoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaInfoServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  areaInfoService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=areaInfoService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除地区信息 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除地区信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AreaInfoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaInfoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = areaInfoService.hasRefers(ids);
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
			Result result=areaInfoService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=areaInfoService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新地区信息
	*/
	@ApiOperation(value = "更新地区信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.AREA_INFO_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.CITY_TYPE , value = "城市类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.REGION , value = "大区" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.AREA , value = "片区" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AreaInfoVOMeta.PAGE_INDEX , AreaInfoVOMeta.PAGE_SIZE , AreaInfoVOMeta.SEARCH_FIELD , AreaInfoVOMeta.FUZZY_FIELD , AreaInfoVOMeta.SEARCH_VALUE , AreaInfoVOMeta.DIRTY_FIELDS , AreaInfoVOMeta.SORT_FIELD , AreaInfoVOMeta.SORT_TYPE , AreaInfoVOMeta.DATA_ORIGIN , AreaInfoVOMeta.QUERY_LOGIC , AreaInfoVOMeta.REQUEST_ACTION , AreaInfoVOMeta.IDS } )
	@SentinelResource(value = AreaInfoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaInfoServiceProxy.UPDATE)
	public Result update(AreaInfoVO areaInfoVO) {
		
		Result result=areaInfoService.update(areaInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存地区信息
	*/
	@ApiOperation(value = "保存地区信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.AREA_INFO_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.CITY_TYPE , value = "城市类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.REGION , value = "大区" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.AREA , value = "片区" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AreaInfoVOMeta.PAGE_INDEX , AreaInfoVOMeta.PAGE_SIZE , AreaInfoVOMeta.SEARCH_FIELD , AreaInfoVOMeta.FUZZY_FIELD , AreaInfoVOMeta.SEARCH_VALUE , AreaInfoVOMeta.DIRTY_FIELDS , AreaInfoVOMeta.SORT_FIELD , AreaInfoVOMeta.SORT_TYPE , AreaInfoVOMeta.DATA_ORIGIN , AreaInfoVOMeta.QUERY_LOGIC , AreaInfoVOMeta.REQUEST_ACTION , AreaInfoVOMeta.IDS } )
	@SentinelResource(value = AreaInfoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaInfoServiceProxy.SAVE)
	public Result save(AreaInfoVO areaInfoVO) {
		
		Result result=areaInfoService.save(areaInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取地区信息
	*/
	@ApiOperation(value = "获取地区信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AreaInfoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaInfoServiceProxy.GET_BY_ID)
	public Result<AreaInfo> getById(String id) {
		
		Result<AreaInfo> result=new Result<>();
		AreaInfo areaInfo=areaInfoService.getById(id);
		result.success(true).data(areaInfo);
		return result;
	}


	/**
	 * 批量获取地区信息 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取地区信息")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AreaInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AreaInfoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaInfoServiceProxy.GET_BY_IDS)
	public Result<List<AreaInfo>> getByIds(List<String> ids) {
		
		Result<List<AreaInfo>> result=new Result<>();
		List<AreaInfo> list=areaInfoService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询地区信息
	*/
	@ApiOperation(value = "查询地区信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.AREA_INFO_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.CITY_TYPE , value = "城市类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.REGION , value = "大区" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.AREA , value = "片区" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AreaInfoVOMeta.PAGE_INDEX , AreaInfoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AreaInfoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaInfoServiceProxy.QUERY_LIST)
	public Result<List<AreaInfo>> queryList(AreaInfoVO sample) {
		
		Result<List<AreaInfo>> result=new Result<>();
		List<AreaInfo> list=areaInfoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询地区信息
	*/
	@ApiOperation(value = "分页查询地区信息")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AreaInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.AREA_INFO_CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.CITY_TYPE , value = "城市类型" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.REGION , value = "大区" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.AREA , value = "片区" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AreaInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AreaInfoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AreaInfoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AreaInfo>> queryPagedList(AreaInfoVO sample) {
		
		Result<PagedList<AreaInfo>> result=new Result<>();
		PagedList<AreaInfo> list=areaInfoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}