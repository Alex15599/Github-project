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


import com.dt.platform.proxy.wms.UnitServiceProxy;
import com.dt.platform.domain.wms.meta.UnitVOMeta;
import com.dt.platform.domain.wms.Unit;
import com.dt.platform.domain.wms.UnitVO;
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
import com.dt.platform.domain.wms.meta.UnitMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IUnitService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 计量单位接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:31:22
*/

@InDoc
@Api(tags = "计量单位")
@RestController("WmsUnitController")
public class UnitController extends SuperController {

	@Autowired
	private IUnitService unitService;

	/**
	 * 添加计量单位
	*/
	@ApiOperation(value = "添加计量单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684018889750740992"),
		@ApiImplicitParam(name = UnitVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "份"),
		@ApiImplicitParam(name = UnitVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "份"),
		@ApiImplicitParam(name = UnitVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "份"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = UnitServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UnitServiceProxy.INSERT)
	public Result insert(UnitVO unitVO) {
		
		Result result=unitService.insert(unitVO,false);
		return result;
	}



	/**
	 * 删除计量单位
	*/
	@ApiOperation(value = "删除计量单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684018889750740992")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = UnitServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UnitServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  unitService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=unitService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除计量单位 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除计量单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UnitVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = UnitServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UnitServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = unitService.hasRefers(ids);
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
			Result result=unitService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=unitService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新计量单位
	*/
	@ApiOperation(value = "更新计量单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684018889750740992"),
		@ApiImplicitParam(name = UnitVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "份"),
		@ApiImplicitParam(name = UnitVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "份"),
		@ApiImplicitParam(name = UnitVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "份"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { UnitVOMeta.PAGE_INDEX , UnitVOMeta.PAGE_SIZE , UnitVOMeta.SEARCH_FIELD , UnitVOMeta.FUZZY_FIELD , UnitVOMeta.SEARCH_VALUE , UnitVOMeta.DIRTY_FIELDS , UnitVOMeta.SORT_FIELD , UnitVOMeta.SORT_TYPE , UnitVOMeta.DATA_ORIGIN , UnitVOMeta.QUERY_LOGIC , UnitVOMeta.REQUEST_ACTION , UnitVOMeta.IDS } )
	@SentinelResource(value = UnitServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UnitServiceProxy.UPDATE)
	public Result update(UnitVO unitVO) {
		
		Result result=unitService.update(unitVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存计量单位
	*/
	@ApiOperation(value = "保存计量单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684018889750740992"),
		@ApiImplicitParam(name = UnitVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "份"),
		@ApiImplicitParam(name = UnitVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "份"),
		@ApiImplicitParam(name = UnitVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "份"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { UnitVOMeta.PAGE_INDEX , UnitVOMeta.PAGE_SIZE , UnitVOMeta.SEARCH_FIELD , UnitVOMeta.FUZZY_FIELD , UnitVOMeta.SEARCH_VALUE , UnitVOMeta.DIRTY_FIELDS , UnitVOMeta.SORT_FIELD , UnitVOMeta.SORT_TYPE , UnitVOMeta.DATA_ORIGIN , UnitVOMeta.QUERY_LOGIC , UnitVOMeta.REQUEST_ACTION , UnitVOMeta.IDS } )
	@SentinelResource(value = UnitServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UnitServiceProxy.SAVE)
	public Result save(UnitVO unitVO) {
		
		Result result=unitService.save(unitVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取计量单位
	*/
	@ApiOperation(value = "获取计量单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = UnitServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UnitServiceProxy.GET_BY_ID)
	public Result<Unit> getById(String id) {
		
		Result<Unit> result=new Result<>();
		Unit unit=unitService.getById(id);
		result.success(true).data(unit);
		return result;
	}


	/**
	 * 批量获取计量单位 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取计量单位")
		@ApiImplicitParams({
				@ApiImplicitParam(name = UnitVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = UnitServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UnitServiceProxy.GET_BY_IDS)
	public Result<List<Unit>> getByIds(List<String> ids) {
		
		Result<List<Unit>> result=new Result<>();
		List<Unit> list=unitService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询计量单位
	*/
	@ApiOperation(value = "查询计量单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684018889750740992"),
		@ApiImplicitParam(name = UnitVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "份"),
		@ApiImplicitParam(name = UnitVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "份"),
		@ApiImplicitParam(name = UnitVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "份"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { UnitVOMeta.PAGE_INDEX , UnitVOMeta.PAGE_SIZE } )
	@SentinelResource(value = UnitServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UnitServiceProxy.QUERY_LIST)
	public Result<List<Unit>> queryList(UnitVO sample) {
		
		Result<List<Unit>> result=new Result<>();
		List<Unit> list=unitService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询计量单位
	*/
	@ApiOperation(value = "分页查询计量单位")
	@ApiImplicitParams({
		@ApiImplicitParam(name = UnitVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684018889750740992"),
		@ApiImplicitParam(name = UnitVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "份"),
		@ApiImplicitParam(name = UnitVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "份"),
		@ApiImplicitParam(name = UnitVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "份"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = UnitServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(UnitServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<Unit>> queryPagedList(UnitVO sample) {
		
		Result<PagedList<Unit>> result=new Result<>();
		PagedList<Unit> list=unitService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}