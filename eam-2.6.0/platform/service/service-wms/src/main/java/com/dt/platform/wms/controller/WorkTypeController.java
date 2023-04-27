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


import com.dt.platform.proxy.wms.WorkTypeServiceProxy;
import com.dt.platform.domain.wms.meta.WorkTypeVOMeta;
import com.dt.platform.domain.wms.WorkType;
import com.dt.platform.domain.wms.WorkTypeVO;
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
import com.dt.platform.domain.wms.meta.WorkTypeMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.wms.service.IWorkTypeService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 作业类型接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:31:29
*/

@InDoc
@Api(tags = "作业类型")
@RestController("WmsWorkTypeController")
public class WorkTypeController extends SuperController {

	@Autowired
	private IWorkTypeService workTypeService;

	/**
	 * 添加作业类型
	*/
	@ApiOperation(value = "添加作业类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = WorkTypeServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkTypeServiceProxy.INSERT)
	public Result insert(WorkTypeVO workTypeVO) {
		
		Result result=workTypeService.insert(workTypeVO,false);
		return result;
	}



	/**
	 * 删除作业类型
	*/
	@ApiOperation(value = "删除作业类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = WorkTypeServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkTypeServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  workTypeService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=workTypeService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除作业类型 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除作业类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = WorkTypeServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkTypeServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = workTypeService.hasRefers(ids);
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
			Result result=workTypeService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=workTypeService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新作业类型
	*/
	@ApiOperation(value = "更新作业类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { WorkTypeVOMeta.PAGE_INDEX , WorkTypeVOMeta.PAGE_SIZE , WorkTypeVOMeta.SEARCH_FIELD , WorkTypeVOMeta.FUZZY_FIELD , WorkTypeVOMeta.SEARCH_VALUE , WorkTypeVOMeta.DIRTY_FIELDS , WorkTypeVOMeta.SORT_FIELD , WorkTypeVOMeta.SORT_TYPE , WorkTypeVOMeta.DATA_ORIGIN , WorkTypeVOMeta.QUERY_LOGIC , WorkTypeVOMeta.REQUEST_ACTION , WorkTypeVOMeta.IDS } )
	@SentinelResource(value = WorkTypeServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkTypeServiceProxy.UPDATE)
	public Result update(WorkTypeVO workTypeVO) {
		
		Result result=workTypeService.update(workTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存作业类型
	*/
	@ApiOperation(value = "保存作业类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { WorkTypeVOMeta.PAGE_INDEX , WorkTypeVOMeta.PAGE_SIZE , WorkTypeVOMeta.SEARCH_FIELD , WorkTypeVOMeta.FUZZY_FIELD , WorkTypeVOMeta.SEARCH_VALUE , WorkTypeVOMeta.DIRTY_FIELDS , WorkTypeVOMeta.SORT_FIELD , WorkTypeVOMeta.SORT_TYPE , WorkTypeVOMeta.DATA_ORIGIN , WorkTypeVOMeta.QUERY_LOGIC , WorkTypeVOMeta.REQUEST_ACTION , WorkTypeVOMeta.IDS } )
	@SentinelResource(value = WorkTypeServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkTypeServiceProxy.SAVE)
	public Result save(WorkTypeVO workTypeVO) {
		
		Result result=workTypeService.save(workTypeVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取作业类型
	*/
	@ApiOperation(value = "获取作业类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = WorkTypeServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkTypeServiceProxy.GET_BY_ID)
	public Result<WorkType> getById(String id) {
		
		Result<WorkType> result=new Result<>();
		WorkType workType=workTypeService.getById(id);
		result.success(true).data(workType);
		return result;
	}


	/**
	 * 批量获取作业类型 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取作业类型")
		@ApiImplicitParams({
				@ApiImplicitParam(name = WorkTypeVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = WorkTypeServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkTypeServiceProxy.GET_BY_IDS)
	public Result<List<WorkType>> getByIds(List<String> ids) {
		
		Result<List<WorkType>> result=new Result<>();
		List<WorkType> list=workTypeService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询作业类型
	*/
	@ApiOperation(value = "查询作业类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { WorkTypeVOMeta.PAGE_INDEX , WorkTypeVOMeta.PAGE_SIZE } )
	@SentinelResource(value = WorkTypeServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkTypeServiceProxy.QUERY_LIST)
	public Result<List<WorkType>> queryList(WorkTypeVO sample) {
		
		Result<List<WorkType>> result=new Result<>();
		List<WorkType> list=workTypeService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询作业类型
	*/
	@ApiOperation(value = "分页查询作业类型")
	@ApiImplicitParams({
		@ApiImplicitParam(name = WorkTypeVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.CODE , value = "编码" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = WorkTypeVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = WorkTypeServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(WorkTypeServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<WorkType>> queryPagedList(WorkTypeVO sample) {
		
		Result<PagedList<WorkType>> result=new Result<>();
		PagedList<WorkType> list=workTypeService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}