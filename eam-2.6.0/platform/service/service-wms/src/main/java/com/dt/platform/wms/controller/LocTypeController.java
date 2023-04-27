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


import com.dt.platform.proxy.wms.LocTypeServiceProxy;
import com.dt.platform.domain.wms.meta.LocTypeVOMeta;
import com.dt.platform.domain.wms.LocType;
import com.dt.platform.domain.wms.LocTypeVO;
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
import com.dt.platform.domain.wms.meta.LocTypeMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.ILocTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 库位类型接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:29:36
*/

@InDoc
@Api(tags = "库位类型")
@RestController("WmsLocTypeController")
public class LocTypeController extends SuperController {

	@Autowired
	private ILocTypeService locTypeService;

	/**
	 * 添加库位类型
	*/
	@ApiOperation(value = "添加库位类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LocTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684080886831906816"),
		@ApiImplicitParam(name = LocTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "不良品区"),
		@ApiImplicitParam(name = LocTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "不良品区"),
		@ApiImplicitParam(name = LocTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LocTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LocTypeServiceProxy.INSERT)
	public Result insert(LocTypeVO locTypeVO) {
		
		Result result=locTypeService.insert(locTypeVO,false);
		return result;
	}



	/**
	 * 删除库位类型
	*/
	@ApiOperation(value = "删除库位类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LocTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684080886831906816")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LocTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LocTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  locTypeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=locTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除库位类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除库位类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LocTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = LocTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LocTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = locTypeService.hasRefers(ids);
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
			Result result=locTypeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=locTypeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新库位类型
	*/
	@ApiOperation(value = "更新库位类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LocTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684080886831906816"),
		@ApiImplicitParam(name = LocTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "不良品区"),
		@ApiImplicitParam(name = LocTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "不良品区"),
		@ApiImplicitParam(name = LocTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { LocTypeVOMeta.PAGE_INDEX , LocTypeVOMeta.PAGE_SIZE , LocTypeVOMeta.SEARCH_FIELD , LocTypeVOMeta.FUZZY_FIELD , LocTypeVOMeta.SEARCH_VALUE , LocTypeVOMeta.DIRTY_FIELDS , LocTypeVOMeta.SORT_FIELD , LocTypeVOMeta.SORT_TYPE , LocTypeVOMeta.DATA_ORIGIN , LocTypeVOMeta.QUERY_LOGIC , LocTypeVOMeta.REQUEST_ACTION , LocTypeVOMeta.IDS } )
	@SentinelResource(value = LocTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LocTypeServiceProxy.UPDATE)
	public Result update(LocTypeVO locTypeVO) {
		
		Result result=locTypeService.update(locTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存库位类型
	*/
	@ApiOperation(value = "保存库位类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LocTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684080886831906816"),
		@ApiImplicitParam(name = LocTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "不良品区"),
		@ApiImplicitParam(name = LocTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "不良品区"),
		@ApiImplicitParam(name = LocTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { LocTypeVOMeta.PAGE_INDEX , LocTypeVOMeta.PAGE_SIZE , LocTypeVOMeta.SEARCH_FIELD , LocTypeVOMeta.FUZZY_FIELD , LocTypeVOMeta.SEARCH_VALUE , LocTypeVOMeta.DIRTY_FIELDS , LocTypeVOMeta.SORT_FIELD , LocTypeVOMeta.SORT_TYPE , LocTypeVOMeta.DATA_ORIGIN , LocTypeVOMeta.QUERY_LOGIC , LocTypeVOMeta.REQUEST_ACTION , LocTypeVOMeta.IDS } )
	@SentinelResource(value = LocTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LocTypeServiceProxy.SAVE)
	public Result save(LocTypeVO locTypeVO) {
		
		Result result=locTypeService.save(locTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取库位类型
	*/
	@ApiOperation(value = "获取库位类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LocTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LocTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LocTypeServiceProxy.GET_BY_ID)
	public Result<LocType> getById(String id) {
		
		Result<LocType> result=new Result<>();
		LocType locType=locTypeService.getById(id);
		result.success(true).data(locType);
		return result;
	}


	/**
	 * 批量获取库位类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取库位类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = LocTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = LocTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LocTypeServiceProxy.GET_BY_IDS)
	public Result<List<LocType>> getByIds(List<String> ids) {
		
		Result<List<LocType>> result=new Result<>();
		List<LocType> list=locTypeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询库位类型
	*/
	@ApiOperation(value = "查询库位类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LocTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684080886831906816"),
		@ApiImplicitParam(name = LocTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "不良品区"),
		@ApiImplicitParam(name = LocTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "不良品区"),
		@ApiImplicitParam(name = LocTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { LocTypeVOMeta.PAGE_INDEX , LocTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = LocTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LocTypeServiceProxy.QUERY_LIST)
	public Result<List<LocType>> queryList(LocTypeVO sample) {
		
		Result<List<LocType>> result=new Result<>();
		List<LocType> list=locTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询库位类型
	*/
	@ApiOperation(value = "分页查询库位类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = LocTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684080886831906816"),
		@ApiImplicitParam(name = LocTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "不良品区"),
		@ApiImplicitParam(name = LocTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "不良品区"),
		@ApiImplicitParam(name = LocTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = LocTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(LocTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<LocType>> queryPagedList(LocTypeVO sample) {
		
		Result<PagedList<LocType>> result=new Result<>();
		PagedList<LocType> list=locTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}