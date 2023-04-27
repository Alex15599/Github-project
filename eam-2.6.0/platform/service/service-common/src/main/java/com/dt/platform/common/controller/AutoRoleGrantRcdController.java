package com.dt.platform.common.controller;

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


import com.dt.platform.proxy.common.AutoRoleGrantRcdServiceProxy;
import com.dt.platform.domain.common.meta.AutoRoleGrantRcdVOMeta;
import com.dt.platform.domain.common.AutoRoleGrantRcd;
import com.dt.platform.domain.common.AutoRoleGrantRcdVO;
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
import com.dt.platform.domain.common.meta.AutoRoleGrantRcdMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IAutoRoleGrantRcdService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 操作日志接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:19:24
*/

@InDoc
@Api(tags = "操作日志")
@RestController("SysAutoRoleGrantRcdController")
public class AutoRoleGrantRcdController extends SuperController {

	@Autowired
	private IAutoRoleGrantRcdService autoRoleGrantRcdService;


	/**
	 * 添加操作日志
	*/
	@ApiOperation(value = "添加操作日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "617806989879148544"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.MODULE_ROLE_ID , value = "模块" , required = false , dataTypeClass=String.class , example = "eam_role"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.ROLE_ID , value = "角色" , required = false , dataTypeClass=String.class , example = "617293164289458176"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoRoleGrantRcdServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoRoleGrantRcdServiceProxy.INSERT)
	public Result insert(AutoRoleGrantRcdVO autoRoleGrantRcdVO) {
		Result result=autoRoleGrantRcdService.insert(autoRoleGrantRcdVO,false);
		return result;
	}



	/**
	 * 删除操作日志
	*/
	@ApiOperation(value = "删除操作日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "617806989879148544")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoRoleGrantRcdServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoRoleGrantRcdServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  autoRoleGrantRcdService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=autoRoleGrantRcdService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除操作日志 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除操作日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AutoRoleGrantRcdServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoRoleGrantRcdServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = autoRoleGrantRcdService.hasRefers(ids);
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
			Result result=autoRoleGrantRcdService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=autoRoleGrantRcdService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新操作日志
	*/
	@ApiOperation(value = "更新操作日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "617806989879148544"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.MODULE_ROLE_ID , value = "模块" , required = false , dataTypeClass=String.class , example = "eam_role"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.ROLE_ID , value = "角色" , required = false , dataTypeClass=String.class , example = "617293164289458176"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AutoRoleGrantRcdVOMeta.PAGE_INDEX , AutoRoleGrantRcdVOMeta.PAGE_SIZE , AutoRoleGrantRcdVOMeta.SEARCH_FIELD , AutoRoleGrantRcdVOMeta.FUZZY_FIELD , AutoRoleGrantRcdVOMeta.SEARCH_VALUE , AutoRoleGrantRcdVOMeta.DIRTY_FIELDS , AutoRoleGrantRcdVOMeta.SORT_FIELD , AutoRoleGrantRcdVOMeta.SORT_TYPE , AutoRoleGrantRcdVOMeta.DATA_ORIGIN , AutoRoleGrantRcdVOMeta.QUERY_LOGIC , AutoRoleGrantRcdVOMeta.IDS } )
	@SentinelResource(value = AutoRoleGrantRcdServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoRoleGrantRcdServiceProxy.UPDATE)
	public Result update(AutoRoleGrantRcdVO autoRoleGrantRcdVO) {
		Result result=autoRoleGrantRcdService.update(autoRoleGrantRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存操作日志
	*/
	@ApiOperation(value = "保存操作日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "617806989879148544"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.MODULE_ROLE_ID , value = "模块" , required = false , dataTypeClass=String.class , example = "eam_role"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.ROLE_ID , value = "角色" , required = false , dataTypeClass=String.class , example = "617293164289458176"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AutoRoleGrantRcdVOMeta.PAGE_INDEX , AutoRoleGrantRcdVOMeta.PAGE_SIZE , AutoRoleGrantRcdVOMeta.SEARCH_FIELD , AutoRoleGrantRcdVOMeta.FUZZY_FIELD , AutoRoleGrantRcdVOMeta.SEARCH_VALUE , AutoRoleGrantRcdVOMeta.DIRTY_FIELDS , AutoRoleGrantRcdVOMeta.SORT_FIELD , AutoRoleGrantRcdVOMeta.SORT_TYPE , AutoRoleGrantRcdVOMeta.DATA_ORIGIN , AutoRoleGrantRcdVOMeta.QUERY_LOGIC , AutoRoleGrantRcdVOMeta.IDS } )
	@SentinelResource(value = AutoRoleGrantRcdServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoRoleGrantRcdServiceProxy.SAVE)
	public Result save(AutoRoleGrantRcdVO autoRoleGrantRcdVO) {
		Result result=autoRoleGrantRcdService.save(autoRoleGrantRcdVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取操作日志
	*/
	@ApiOperation(value = "获取操作日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoRoleGrantRcdServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoRoleGrantRcdServiceProxy.GET_BY_ID)
	public Result<AutoRoleGrantRcd> getById(String id) {
		Result<AutoRoleGrantRcd> result=new Result<>();
		AutoRoleGrantRcd autoRoleGrantRcd=autoRoleGrantRcdService.getById(id);
		// join 关联的对象
		autoRoleGrantRcdService.dao().fill(autoRoleGrantRcd)
			.with("user")
			.execute();
		result.success(true).data(autoRoleGrantRcd);
		return result;
	}


	/**
	 * 批量获取操作日志 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取操作日志")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AutoRoleGrantRcdServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoRoleGrantRcdServiceProxy.GET_BY_IDS)
	public Result<List<AutoRoleGrantRcd>> getByIds(List<String> ids) {
		Result<List<AutoRoleGrantRcd>> result=new Result<>();
		List<AutoRoleGrantRcd> list=autoRoleGrantRcdService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询操作日志
	*/
	@ApiOperation(value = "查询操作日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "617806989879148544"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.MODULE_ROLE_ID , value = "模块" , required = false , dataTypeClass=String.class , example = "eam_role"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.ROLE_ID , value = "角色" , required = false , dataTypeClass=String.class , example = "617293164289458176"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AutoRoleGrantRcdVOMeta.PAGE_INDEX , AutoRoleGrantRcdVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AutoRoleGrantRcdServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoRoleGrantRcdServiceProxy.QUERY_LIST)
	public Result<List<AutoRoleGrantRcd>> queryList(AutoRoleGrantRcdVO sample) {
		Result<List<AutoRoleGrantRcd>> result=new Result<>();
		List<AutoRoleGrantRcd> list=autoRoleGrantRcdService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询操作日志
	*/
	@ApiOperation(value = "分页查询操作日志")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "617806989879148544"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.MODULE_ROLE_ID , value = "模块" , required = false , dataTypeClass=String.class , example = "eam_role"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.ROLE_ID , value = "角色" , required = false , dataTypeClass=String.class , example = "617293164289458176"),
		@ApiImplicitParam(name = AutoRoleGrantRcdVOMeta.USER_ID , value = "用户" , required = false , dataTypeClass=String.class , example = "110588348101165911"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoRoleGrantRcdServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoRoleGrantRcdServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AutoRoleGrantRcd>> queryPagedList(AutoRoleGrantRcdVO sample) {
		Result<PagedList<AutoRoleGrantRcd>> result=new Result<>();
		PagedList<AutoRoleGrantRcd> list=autoRoleGrantRcdService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		autoRoleGrantRcdService.dao().fill(list)
			.with("user")
			.execute();
		result.success(true).data(list);
		return result;
	}






}