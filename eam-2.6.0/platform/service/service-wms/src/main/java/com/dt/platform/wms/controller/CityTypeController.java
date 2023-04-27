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


import com.dt.platform.proxy.wms.CityTypeServiceProxy;
import com.dt.platform.domain.wms.meta.CityTypeVOMeta;
import com.dt.platform.domain.wms.CityType;
import com.dt.platform.domain.wms.CityTypeVO;
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
import com.dt.platform.domain.wms.meta.CityTypeMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.ICityTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 城市类型接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:28:32
*/

@InDoc
@Api(tags = "城市类型")
@RestController("WmsCityTypeController")
public class CityTypeController extends SuperController {

	@Autowired
	private ICityTypeService cityTypeService;

	/**
	 * 添加城市类型
	*/
	@ApiOperation(value = "添加城市类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CityTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684018481271668736"),
		@ApiImplicitParam(name = CityTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "城市类型1"),
		@ApiImplicitParam(name = CityTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "城市类型1"),
		@ApiImplicitParam(name = CityTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CityTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CityTypeServiceProxy.INSERT)
	public Result insert(CityTypeVO cityTypeVO) {
		
		Result result=cityTypeService.insert(cityTypeVO,false);
		return result;
	}



	/**
	 * 删除城市类型
	*/
	@ApiOperation(value = "删除城市类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CityTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684018481271668736")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CityTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CityTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  cityTypeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=cityTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除城市类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除城市类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CityTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = CityTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CityTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = cityTypeService.hasRefers(ids);
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
			Result result=cityTypeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=cityTypeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新城市类型
	*/
	@ApiOperation(value = "更新城市类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CityTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684018481271668736"),
		@ApiImplicitParam(name = CityTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "城市类型1"),
		@ApiImplicitParam(name = CityTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "城市类型1"),
		@ApiImplicitParam(name = CityTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CityTypeVOMeta.PAGE_INDEX , CityTypeVOMeta.PAGE_SIZE , CityTypeVOMeta.SEARCH_FIELD , CityTypeVOMeta.FUZZY_FIELD , CityTypeVOMeta.SEARCH_VALUE , CityTypeVOMeta.DIRTY_FIELDS , CityTypeVOMeta.SORT_FIELD , CityTypeVOMeta.SORT_TYPE , CityTypeVOMeta.DATA_ORIGIN , CityTypeVOMeta.QUERY_LOGIC , CityTypeVOMeta.REQUEST_ACTION , CityTypeVOMeta.IDS } )
	@SentinelResource(value = CityTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CityTypeServiceProxy.UPDATE)
	public Result update(CityTypeVO cityTypeVO) {
		
		Result result=cityTypeService.update(cityTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存城市类型
	*/
	@ApiOperation(value = "保存城市类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CityTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684018481271668736"),
		@ApiImplicitParam(name = CityTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "城市类型1"),
		@ApiImplicitParam(name = CityTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "城市类型1"),
		@ApiImplicitParam(name = CityTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { CityTypeVOMeta.PAGE_INDEX , CityTypeVOMeta.PAGE_SIZE , CityTypeVOMeta.SEARCH_FIELD , CityTypeVOMeta.FUZZY_FIELD , CityTypeVOMeta.SEARCH_VALUE , CityTypeVOMeta.DIRTY_FIELDS , CityTypeVOMeta.SORT_FIELD , CityTypeVOMeta.SORT_TYPE , CityTypeVOMeta.DATA_ORIGIN , CityTypeVOMeta.QUERY_LOGIC , CityTypeVOMeta.REQUEST_ACTION , CityTypeVOMeta.IDS } )
	@SentinelResource(value = CityTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CityTypeServiceProxy.SAVE)
	public Result save(CityTypeVO cityTypeVO) {
		
		Result result=cityTypeService.save(cityTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取城市类型
	*/
	@ApiOperation(value = "获取城市类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CityTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CityTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CityTypeServiceProxy.GET_BY_ID)
	public Result<CityType> getById(String id) {
		
		Result<CityType> result=new Result<>();
		CityType cityType=cityTypeService.getById(id);
		result.success(true).data(cityType);
		return result;
	}


	/**
	 * 批量获取城市类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取城市类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = CityTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = CityTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CityTypeServiceProxy.GET_BY_IDS)
	public Result<List<CityType>> getByIds(List<String> ids) {
		
		Result<List<CityType>> result=new Result<>();
		List<CityType> list=cityTypeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询城市类型
	*/
	@ApiOperation(value = "查询城市类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CityTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684018481271668736"),
		@ApiImplicitParam(name = CityTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "城市类型1"),
		@ApiImplicitParam(name = CityTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "城市类型1"),
		@ApiImplicitParam(name = CityTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { CityTypeVOMeta.PAGE_INDEX , CityTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = CityTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CityTypeServiceProxy.QUERY_LIST)
	public Result<List<CityType>> queryList(CityTypeVO sample) {
		
		Result<List<CityType>> result=new Result<>();
		List<CityType> list=cityTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询城市类型
	*/
	@ApiOperation(value = "分页查询城市类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = CityTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684018481271668736"),
		@ApiImplicitParam(name = CityTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "城市类型1"),
		@ApiImplicitParam(name = CityTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "城市类型1"),
		@ApiImplicitParam(name = CityTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = CityTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(CityTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<CityType>> queryPagedList(CityTypeVO sample) {
		
		Result<PagedList<CityType>> result=new Result<>();
		PagedList<CityType> list=cityTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}