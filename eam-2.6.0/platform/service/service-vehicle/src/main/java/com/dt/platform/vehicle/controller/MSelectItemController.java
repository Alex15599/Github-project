package com.dt.platform.vehicle.controller;

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


import com.dt.platform.proxy.vehicle.MSelectItemServiceProxy;
import com.dt.platform.domain.vehicle.meta.MSelectItemVOMeta;
import com.dt.platform.domain.vehicle.MSelectItem;
import com.dt.platform.domain.vehicle.MSelectItemVO;
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
import com.dt.platform.domain.vehicle.meta.MSelectItemMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.vehicle.service.IMSelectItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 车辆数据接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-03 07:27:12
*/

@InDoc
@Api(tags = "车辆数据")
@RestController("VehicleMSelectItemController")
public class MSelectItemController extends SuperController {

	@Autowired
	private IMSelectItemService mSelectItemService;

	/**
	 * 添加车辆数据
	*/
	@ApiOperation(value = "添加车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MSelectItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.INSERT)
	public Result insert(MSelectItemVO mSelectItemVO) {
		
		Result result=mSelectItemService.insert(mSelectItemVO,false);
		return result;
	}



	/**
	 * 删除车辆数据
	*/
	@ApiOperation(value = "删除车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MSelectItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  mSelectItemService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=mSelectItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除车辆数据 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MSelectItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = mSelectItemService.hasRefers(ids);
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
			Result result=mSelectItemService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=mSelectItemService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新车辆数据
	*/
	@ApiOperation(value = "更新车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MSelectItemVOMeta.PAGE_INDEX , MSelectItemVOMeta.PAGE_SIZE , MSelectItemVOMeta.SEARCH_FIELD , MSelectItemVOMeta.FUZZY_FIELD , MSelectItemVOMeta.SEARCH_VALUE , MSelectItemVOMeta.DIRTY_FIELDS , MSelectItemVOMeta.SORT_FIELD , MSelectItemVOMeta.SORT_TYPE , MSelectItemVOMeta.DATA_ORIGIN , MSelectItemVOMeta.QUERY_LOGIC , MSelectItemVOMeta.REQUEST_ACTION , MSelectItemVOMeta.IDS } )
	@SentinelResource(value = MSelectItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.UPDATE)
	public Result update(MSelectItemVO mSelectItemVO) {
		
		Result result=mSelectItemService.update(mSelectItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存车辆数据
	*/
	@ApiOperation(value = "保存车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MSelectItemVOMeta.PAGE_INDEX , MSelectItemVOMeta.PAGE_SIZE , MSelectItemVOMeta.SEARCH_FIELD , MSelectItemVOMeta.FUZZY_FIELD , MSelectItemVOMeta.SEARCH_VALUE , MSelectItemVOMeta.DIRTY_FIELDS , MSelectItemVOMeta.SORT_FIELD , MSelectItemVOMeta.SORT_TYPE , MSelectItemVOMeta.DATA_ORIGIN , MSelectItemVOMeta.QUERY_LOGIC , MSelectItemVOMeta.REQUEST_ACTION , MSelectItemVOMeta.IDS } )
	@SentinelResource(value = MSelectItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.SAVE)
	public Result save(MSelectItemVO mSelectItemVO) {
		
		Result result=mSelectItemService.save(mSelectItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取车辆数据
	*/
	@ApiOperation(value = "获取车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MSelectItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.GET_BY_ID)
	public Result<MSelectItem> getById(String id) {
		
		Result<MSelectItem> result=new Result<>();
		MSelectItem mSelectItem=mSelectItemService.getById(id);
		result.success(true).data(mSelectItem);
		return result;
	}


	/**
	 * 批量获取车辆数据 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取车辆数据")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MSelectItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MSelectItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.GET_BY_IDS)
	public Result<List<MSelectItem>> getByIds(List<String> ids) {
		
		Result<List<MSelectItem>> result=new Result<>();
		List<MSelectItem> list=mSelectItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询车辆数据
	*/
	@ApiOperation(value = "查询车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MSelectItemVOMeta.PAGE_INDEX , MSelectItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MSelectItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.QUERY_LIST)
	public Result<List<MSelectItem>> queryList(MSelectItemVO sample) {
		
		Result<List<MSelectItem>> result=new Result<>();
		List<MSelectItem> list=mSelectItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询车辆数据
	*/
	@ApiOperation(value = "分页查询车辆数据")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MSelectItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.HANDLE_ID , value = "处理" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MSelectItemVOMeta.ASSET_ID , value = "车辆" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MSelectItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MSelectItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MSelectItem>> queryPagedList(MSelectItemVO sample) {
		
		Result<PagedList<MSelectItem>> result=new Result<>();
		PagedList<MSelectItem> list=mSelectItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}