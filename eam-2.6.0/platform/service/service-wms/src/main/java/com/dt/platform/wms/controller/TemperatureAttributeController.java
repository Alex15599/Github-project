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


import com.dt.platform.proxy.wms.TemperatureAttributeServiceProxy;
import com.dt.platform.domain.wms.meta.TemperatureAttributeVOMeta;
import com.dt.platform.domain.wms.TemperatureAttribute;
import com.dt.platform.domain.wms.TemperatureAttributeVO;
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
import com.dt.platform.domain.wms.meta.TemperatureAttributeMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.ITemperatureAttributeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 温度属性接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:31:14
*/

@InDoc
@Api(tags = "温度属性")
@RestController("WmsTemperatureAttributeController")
public class TemperatureAttributeController extends SuperController {

	@Autowired
	private ITemperatureAttributeService temperatureAttributeService;

	/**
	 * 添加温度属性
	*/
	@ApiOperation(value = "添加温度属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684054296664211456"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "常温"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "常温"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TemperatureAttributeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TemperatureAttributeServiceProxy.INSERT)
	public Result insert(TemperatureAttributeVO temperatureAttributeVO) {
		
		Result result=temperatureAttributeService.insert(temperatureAttributeVO,false);
		return result;
	}



	/**
	 * 删除温度属性
	*/
	@ApiOperation(value = "删除温度属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684054296664211456")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TemperatureAttributeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TemperatureAttributeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  temperatureAttributeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=temperatureAttributeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除温度属性 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除温度属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = TemperatureAttributeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TemperatureAttributeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = temperatureAttributeService.hasRefers(ids);
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
			Result result=temperatureAttributeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=temperatureAttributeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新温度属性
	*/
	@ApiOperation(value = "更新温度属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684054296664211456"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "常温"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "常温"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { TemperatureAttributeVOMeta.PAGE_INDEX , TemperatureAttributeVOMeta.PAGE_SIZE , TemperatureAttributeVOMeta.SEARCH_FIELD , TemperatureAttributeVOMeta.FUZZY_FIELD , TemperatureAttributeVOMeta.SEARCH_VALUE , TemperatureAttributeVOMeta.DIRTY_FIELDS , TemperatureAttributeVOMeta.SORT_FIELD , TemperatureAttributeVOMeta.SORT_TYPE , TemperatureAttributeVOMeta.DATA_ORIGIN , TemperatureAttributeVOMeta.QUERY_LOGIC , TemperatureAttributeVOMeta.REQUEST_ACTION , TemperatureAttributeVOMeta.IDS } )
	@SentinelResource(value = TemperatureAttributeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TemperatureAttributeServiceProxy.UPDATE)
	public Result update(TemperatureAttributeVO temperatureAttributeVO) {
		
		Result result=temperatureAttributeService.update(temperatureAttributeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存温度属性
	*/
	@ApiOperation(value = "保存温度属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684054296664211456"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "常温"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "常温"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { TemperatureAttributeVOMeta.PAGE_INDEX , TemperatureAttributeVOMeta.PAGE_SIZE , TemperatureAttributeVOMeta.SEARCH_FIELD , TemperatureAttributeVOMeta.FUZZY_FIELD , TemperatureAttributeVOMeta.SEARCH_VALUE , TemperatureAttributeVOMeta.DIRTY_FIELDS , TemperatureAttributeVOMeta.SORT_FIELD , TemperatureAttributeVOMeta.SORT_TYPE , TemperatureAttributeVOMeta.DATA_ORIGIN , TemperatureAttributeVOMeta.QUERY_LOGIC , TemperatureAttributeVOMeta.REQUEST_ACTION , TemperatureAttributeVOMeta.IDS } )
	@SentinelResource(value = TemperatureAttributeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TemperatureAttributeServiceProxy.SAVE)
	public Result save(TemperatureAttributeVO temperatureAttributeVO) {
		
		Result result=temperatureAttributeService.save(temperatureAttributeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取温度属性
	*/
	@ApiOperation(value = "获取温度属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TemperatureAttributeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TemperatureAttributeServiceProxy.GET_BY_ID)
	public Result<TemperatureAttribute> getById(String id) {
		
		Result<TemperatureAttribute> result=new Result<>();
		TemperatureAttribute temperatureAttribute=temperatureAttributeService.getById(id);
		result.success(true).data(temperatureAttribute);
		return result;
	}


	/**
	 * 批量获取温度属性 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取温度属性")
		@ApiImplicitParams({
				@ApiImplicitParam(name = TemperatureAttributeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = TemperatureAttributeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TemperatureAttributeServiceProxy.GET_BY_IDS)
	public Result<List<TemperatureAttribute>> getByIds(List<String> ids) {
		
		Result<List<TemperatureAttribute>> result=new Result<>();
		List<TemperatureAttribute> list=temperatureAttributeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询温度属性
	*/
	@ApiOperation(value = "查询温度属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684054296664211456"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "常温"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "常温"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { TemperatureAttributeVOMeta.PAGE_INDEX , TemperatureAttributeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = TemperatureAttributeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TemperatureAttributeServiceProxy.QUERY_LIST)
	public Result<List<TemperatureAttribute>> queryList(TemperatureAttributeVO sample) {
		
		Result<List<TemperatureAttribute>> result=new Result<>();
		List<TemperatureAttribute> list=temperatureAttributeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询温度属性
	*/
	@ApiOperation(value = "分页查询温度属性")
	@ApiImplicitParams({
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "684054296664211456"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class , example = "常温"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "常温"),
		@ApiImplicitParam(name = TemperatureAttributeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = TemperatureAttributeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(TemperatureAttributeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<TemperatureAttribute>> queryPagedList(TemperatureAttributeVO sample) {
		
		Result<PagedList<TemperatureAttribute>> result=new Result<>();
		PagedList<TemperatureAttribute> list=temperatureAttributeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}