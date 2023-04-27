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


import com.dt.platform.proxy.eam.MaintainTaskProjectServiceProxy;
import com.dt.platform.domain.eam.meta.MaintainTaskProjectVOMeta;
import com.dt.platform.domain.eam.MaintainTaskProject;
import com.dt.platform.domain.eam.MaintainTaskProjectVO;
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
import com.dt.platform.domain.eam.meta.MaintainTaskProjectMeta;
import java.math.BigDecimal;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.meta.MaintainProjectMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IMaintainTaskProjectService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 保养项目接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-14 07:42:51
*/

@InDoc
@Api(tags = "保养项目")
@RestController("EamMaintainTaskProjectController")
public class MaintainTaskProjectController extends SuperController {

	@Autowired
	private IMaintainTaskProjectService maintainTaskProjectService;

	/**
	 * 添加保养项目
	*/
	@ApiOperation(value = "添加保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "698202584640389120"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class , example = "698150690282799104"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class , example = "698202584300650496"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "unexecuted"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.CONTENT , value = "保养结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_CODE , value = "项目编号" , required = false , dataTypeClass=String.class , example = "MPJ202304111204372"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "保养项目1"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_BASE_COST , value = "标准工时" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NOTES , value = "项目备注" , required = false , dataTypeClass=String.class , example = "保养项目111"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.BASE_COST , value = "标准工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaintainTaskProjectServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.INSERT)
	public Result insert(MaintainTaskProjectVO maintainTaskProjectVO) {
		
		Result result=maintainTaskProjectService.insert(maintainTaskProjectVO,false);
		return result;
	}



	/**
	 * 删除保养项目
	*/
	@ApiOperation(value = "删除保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "698202584640389120")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaintainTaskProjectServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  maintainTaskProjectService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=maintainTaskProjectService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除保养项目 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = MaintainTaskProjectServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = maintainTaskProjectService.hasRefers(ids);
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
			Result result=maintainTaskProjectService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=maintainTaskProjectService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新保养项目
	*/
	@ApiOperation(value = "更新保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "698202584640389120"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class , example = "698150690282799104"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class , example = "698202584300650496"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "unexecuted"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.CONTENT , value = "保养结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_CODE , value = "项目编号" , required = false , dataTypeClass=String.class , example = "MPJ202304111204372"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "保养项目1"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_BASE_COST , value = "标准工时" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NOTES , value = "项目备注" , required = false , dataTypeClass=String.class , example = "保养项目111"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.BASE_COST , value = "标准工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MaintainTaskProjectVOMeta.PAGE_INDEX , MaintainTaskProjectVOMeta.PAGE_SIZE , MaintainTaskProjectVOMeta.SEARCH_FIELD , MaintainTaskProjectVOMeta.FUZZY_FIELD , MaintainTaskProjectVOMeta.SEARCH_VALUE , MaintainTaskProjectVOMeta.DIRTY_FIELDS , MaintainTaskProjectVOMeta.SORT_FIELD , MaintainTaskProjectVOMeta.SORT_TYPE , MaintainTaskProjectVOMeta.DATA_ORIGIN , MaintainTaskProjectVOMeta.QUERY_LOGIC , MaintainTaskProjectVOMeta.REQUEST_ACTION , MaintainTaskProjectVOMeta.IDS } )
	@SentinelResource(value = MaintainTaskProjectServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.UPDATE)
	public Result update(MaintainTaskProjectVO maintainTaskProjectVO) {
		
		Result result=maintainTaskProjectService.update(maintainTaskProjectVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存保养项目
	*/
	@ApiOperation(value = "保存保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "698202584640389120"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class , example = "698150690282799104"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class , example = "698202584300650496"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "unexecuted"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.CONTENT , value = "保养结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_CODE , value = "项目编号" , required = false , dataTypeClass=String.class , example = "MPJ202304111204372"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "保养项目1"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_BASE_COST , value = "标准工时" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NOTES , value = "项目备注" , required = false , dataTypeClass=String.class , example = "保养项目111"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.BASE_COST , value = "标准工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { MaintainTaskProjectVOMeta.PAGE_INDEX , MaintainTaskProjectVOMeta.PAGE_SIZE , MaintainTaskProjectVOMeta.SEARCH_FIELD , MaintainTaskProjectVOMeta.FUZZY_FIELD , MaintainTaskProjectVOMeta.SEARCH_VALUE , MaintainTaskProjectVOMeta.DIRTY_FIELDS , MaintainTaskProjectVOMeta.SORT_FIELD , MaintainTaskProjectVOMeta.SORT_TYPE , MaintainTaskProjectVOMeta.DATA_ORIGIN , MaintainTaskProjectVOMeta.QUERY_LOGIC , MaintainTaskProjectVOMeta.REQUEST_ACTION , MaintainTaskProjectVOMeta.IDS } )
	@SentinelResource(value = MaintainTaskProjectServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.SAVE)
	public Result save(MaintainTaskProjectVO maintainTaskProjectVO) {
		
		Result result=maintainTaskProjectService.save(maintainTaskProjectVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取保养项目
	*/
	@ApiOperation(value = "获取保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaintainTaskProjectServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.GET_BY_ID)
	public Result<MaintainTaskProject> getById(String id) {
		
		Result<MaintainTaskProject> result=new Result<>();
		MaintainTaskProject maintainTaskProject=maintainTaskProjectService.getById(id);
		// join 关联的对象
		maintainTaskProjectService.dao().fill(maintainTaskProject)
			.with(MaintainProjectMeta.MAINTAIN_TYPE_DICT)
			.execute();
		result.success(true).data(maintainTaskProject);
		return result;
	}


	/**
	 * 批量获取保养项目 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取保养项目")
		@ApiImplicitParams({
				@ApiImplicitParam(name = MaintainTaskProjectVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = MaintainTaskProjectServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.GET_BY_IDS)
	public Result<List<MaintainTaskProject>> getByIds(List<String> ids) {
		
		Result<List<MaintainTaskProject>> result=new Result<>();
		List<MaintainTaskProject> list=maintainTaskProjectService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询保养项目
	*/
	@ApiOperation(value = "查询保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "698202584640389120"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class , example = "698150690282799104"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class , example = "698202584300650496"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "unexecuted"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.CONTENT , value = "保养结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_CODE , value = "项目编号" , required = false , dataTypeClass=String.class , example = "MPJ202304111204372"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "保养项目1"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_BASE_COST , value = "标准工时" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NOTES , value = "项目备注" , required = false , dataTypeClass=String.class , example = "保养项目111"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.BASE_COST , value = "标准工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { MaintainTaskProjectVOMeta.PAGE_INDEX , MaintainTaskProjectVOMeta.PAGE_SIZE } )
	@SentinelResource(value = MaintainTaskProjectServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.QUERY_LIST)
	public Result<List<MaintainTaskProject>> queryList(MaintainTaskProjectVO sample) {
		
		Result<List<MaintainTaskProject>> result=new Result<>();
		List<MaintainTaskProject> list=maintainTaskProjectService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询保养项目
	*/
	@ApiOperation(value = "分页查询保养项目")
	@ApiImplicitParams({
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "698202584640389120"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ID , value = "项目" , required = false , dataTypeClass=String.class , example = "698150690282799104"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.TASK_ID , value = "任务" , required = false , dataTypeClass=String.class , example = "698202584300650496"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "unexecuted"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.CONTENT , value = "保养结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_CODE , value = "项目编号" , required = false , dataTypeClass=String.class , example = "MPJ202304111204372"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NAME , value = "项目名称" , required = false , dataTypeClass=String.class , example = "保养项目1"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_MAINTAIN_TYPE , value = "保养类型" , required = false , dataTypeClass=String.class , example = "default"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_BASE_COST , value = "标准工时" , required = false , dataTypeClass=BigDecimal.class , example = "1.00"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_ATTACH_ID , value = "保养手册" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.PROJECT_NOTES , value = "项目备注" , required = false , dataTypeClass=String.class , example = "保养项目111"),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.BASE_COST , value = "标准工时" , required = false , dataTypeClass=BigDecimal.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.START_TIME , value = "开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.END_TIME , value = "结束时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = MaintainTaskProjectVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = MaintainTaskProjectServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(MaintainTaskProjectServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<MaintainTaskProject>> queryPagedList(MaintainTaskProjectVO sample) {
		
		Result<PagedList<MaintainTaskProject>> result=new Result<>();
		PagedList<MaintainTaskProject> list=maintainTaskProjectService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		maintainTaskProjectService.dao().fill(list)
			.with(MaintainProjectMeta.MAINTAIN_TYPE_DICT)
			.execute();
		result.success(true).data(list);
		return result;
	}





}