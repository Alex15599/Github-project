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


import com.dt.platform.proxy.wms.OperTypeServiceProxy;
import com.dt.platform.domain.wms.meta.OperTypeVOMeta;
import com.dt.platform.domain.wms.OperType;
import com.dt.platform.domain.wms.OperTypeVO;
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
import com.dt.platform.domain.wms.meta.OperTypeMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IOperTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 操作类型接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:29:49
*/

@InDoc
@Api(tags = "操作类型")
@RestController("WmsOperTypeController")
public class OperTypeController extends SuperController {

	@Autowired
	private IOperTypeService operTypeService;

	/**
	 * 添加操作类型
	*/
	@ApiOperation(value = "添加操作类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OperTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = OperTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OperTypeServiceProxy.INSERT)
	public Result insert(OperTypeVO operTypeVO) {
		
		Result result=operTypeService.insert(operTypeVO,false);
		return result;
	}



	/**
	 * 删除操作类型
	*/
	@ApiOperation(value = "删除操作类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OperTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = OperTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OperTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  operTypeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=operTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除操作类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除操作类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OperTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = OperTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OperTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = operTypeService.hasRefers(ids);
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
			Result result=operTypeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=operTypeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新操作类型
	*/
	@ApiOperation(value = "更新操作类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OperTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { OperTypeVOMeta.PAGE_INDEX , OperTypeVOMeta.PAGE_SIZE , OperTypeVOMeta.SEARCH_FIELD , OperTypeVOMeta.FUZZY_FIELD , OperTypeVOMeta.SEARCH_VALUE , OperTypeVOMeta.DIRTY_FIELDS , OperTypeVOMeta.SORT_FIELD , OperTypeVOMeta.SORT_TYPE , OperTypeVOMeta.DATA_ORIGIN , OperTypeVOMeta.QUERY_LOGIC , OperTypeVOMeta.REQUEST_ACTION , OperTypeVOMeta.IDS } )
	@SentinelResource(value = OperTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OperTypeServiceProxy.UPDATE)
	public Result update(OperTypeVO operTypeVO) {
		
		Result result=operTypeService.update(operTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存操作类型
	*/
	@ApiOperation(value = "保存操作类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OperTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { OperTypeVOMeta.PAGE_INDEX , OperTypeVOMeta.PAGE_SIZE , OperTypeVOMeta.SEARCH_FIELD , OperTypeVOMeta.FUZZY_FIELD , OperTypeVOMeta.SEARCH_VALUE , OperTypeVOMeta.DIRTY_FIELDS , OperTypeVOMeta.SORT_FIELD , OperTypeVOMeta.SORT_TYPE , OperTypeVOMeta.DATA_ORIGIN , OperTypeVOMeta.QUERY_LOGIC , OperTypeVOMeta.REQUEST_ACTION , OperTypeVOMeta.IDS } )
	@SentinelResource(value = OperTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OperTypeServiceProxy.SAVE)
	public Result save(OperTypeVO operTypeVO) {
		
		Result result=operTypeService.save(operTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取操作类型
	*/
	@ApiOperation(value = "获取操作类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OperTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = OperTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OperTypeServiceProxy.GET_BY_ID)
	public Result<OperType> getById(String id) {
		
		Result<OperType> result=new Result<>();
		OperType operType=operTypeService.getById(id);
		result.success(true).data(operType);
		return result;
	}


	/**
	 * 批量获取操作类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取操作类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = OperTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = OperTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OperTypeServiceProxy.GET_BY_IDS)
	public Result<List<OperType>> getByIds(List<String> ids) {
		
		Result<List<OperType>> result=new Result<>();
		List<OperType> list=operTypeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询操作类型
	*/
	@ApiOperation(value = "查询操作类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OperTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { OperTypeVOMeta.PAGE_INDEX , OperTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = OperTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OperTypeServiceProxy.QUERY_LIST)
	public Result<List<OperType>> queryList(OperTypeVO sample) {
		
		Result<List<OperType>> result=new Result<>();
		List<OperType> list=operTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询操作类型
	*/
	@ApiOperation(value = "分页查询操作类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = OperTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = OperTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = OperTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(OperTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<OperType>> queryPagedList(OperTypeVO sample) {
		
		Result<PagedList<OperType>> result=new Result<>();
		PagedList<OperType> list=operTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}