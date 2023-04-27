package com.dt.platform.common.controller;

import java.text.SimpleDateFormat;
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


import com.dt.platform.proxy.common.AutoModuleRoleServiceProxy;
import com.dt.platform.domain.common.meta.AutoModuleRoleVOMeta;
import com.dt.platform.domain.common.AutoModuleRole;
import com.dt.platform.domain.common.AutoModuleRoleVO;
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
import com.dt.platform.domain.common.meta.AutoModuleRoleMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IAutoModuleRoleService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 模块角色接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-04 15:14:30
*/

@InDoc
@Api(tags = "模块角色")
@RestController("SysAutoModuleRoleController")
public class AutoModuleRoleController extends SuperController {

	@Autowired
	private IAutoModuleRoleService autoModuleRoleService;

	/**
	 * 添加模块角色
	*/
	@ApiOperation(value = "添加模块角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "eam_data_role"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "系统-用户自动配置数据角色"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.MODULE , value = "模块" , required = false , dataTypeClass=String.class , example = "eam"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "busi_role"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoModuleRoleServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleServiceProxy.INSERT)
	public Result insert(AutoModuleRoleVO autoModuleRoleVO) {
		
		Result result=autoModuleRoleService.insert(autoModuleRoleVO,false);
		return result;
	}



	/**
	 * 删除模块角色
	*/
	@ApiOperation(value = "删除模块角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "eam_data_role")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoModuleRoleServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleServiceProxy.DELETE)
	public Result deleteById(String id) {
		
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  autoModuleRoleService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=autoModuleRoleService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除模块角色 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除模块角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AutoModuleRoleServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {
		
		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = autoModuleRoleService.hasRefers(ids);
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
			Result result=autoModuleRoleService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=autoModuleRoleService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新模块角色
	*/
	@ApiOperation(value = "更新模块角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "eam_data_role"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "系统-用户自动配置数据角色"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.MODULE , value = "模块" , required = false , dataTypeClass=String.class , example = "eam"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "busi_role"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AutoModuleRoleVOMeta.PAGE_INDEX , AutoModuleRoleVOMeta.PAGE_SIZE , AutoModuleRoleVOMeta.SEARCH_FIELD , AutoModuleRoleVOMeta.FUZZY_FIELD , AutoModuleRoleVOMeta.SEARCH_VALUE , AutoModuleRoleVOMeta.DIRTY_FIELDS , AutoModuleRoleVOMeta.SORT_FIELD , AutoModuleRoleVOMeta.SORT_TYPE , AutoModuleRoleVOMeta.DATA_ORIGIN , AutoModuleRoleVOMeta.QUERY_LOGIC , AutoModuleRoleVOMeta.REQUEST_ACTION , AutoModuleRoleVOMeta.IDS } )
	@SentinelResource(value = AutoModuleRoleServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleServiceProxy.UPDATE)
	public Result update(AutoModuleRoleVO autoModuleRoleVO) {
		
		Result result=autoModuleRoleService.update(autoModuleRoleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存模块角色
	*/
	@ApiOperation(value = "保存模块角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "eam_data_role"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "系统-用户自动配置数据角色"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.MODULE , value = "模块" , required = false , dataTypeClass=String.class , example = "eam"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "busi_role"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AutoModuleRoleVOMeta.PAGE_INDEX , AutoModuleRoleVOMeta.PAGE_SIZE , AutoModuleRoleVOMeta.SEARCH_FIELD , AutoModuleRoleVOMeta.FUZZY_FIELD , AutoModuleRoleVOMeta.SEARCH_VALUE , AutoModuleRoleVOMeta.DIRTY_FIELDS , AutoModuleRoleVOMeta.SORT_FIELD , AutoModuleRoleVOMeta.SORT_TYPE , AutoModuleRoleVOMeta.DATA_ORIGIN , AutoModuleRoleVOMeta.QUERY_LOGIC , AutoModuleRoleVOMeta.REQUEST_ACTION , AutoModuleRoleVOMeta.IDS } )
	@SentinelResource(value = AutoModuleRoleServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleServiceProxy.SAVE)
	public Result save(AutoModuleRoleVO autoModuleRoleVO) {
		
		Result result=autoModuleRoleService.save(autoModuleRoleVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取模块角色
	*/
	@ApiOperation(value = "获取模块角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoModuleRoleServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleServiceProxy.GET_BY_ID)
	public Result<AutoModuleRole> getById(String id) {
		
		Result<AutoModuleRole> result=new Result<>();
		AutoModuleRole autoModuleRole=autoModuleRoleService.getById(id);
		result.success(true).data(autoModuleRole);
		return result;
	}

	/**
	 * 降价服务
	 */
	@ApiOperation(value = "降价服务")

	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoModuleRoleServiceProxy.PERMISSION_DOWNGRADE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleServiceProxy.PERMISSION_DOWNGRADE)
	public Result permissionDowngrade() {
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("HHmmss");
		String str=df.format(date);
		String backupSql="create table r_"+str+" as select * from sys_resourze";
		String upsSql="update sys_resourze set access_type='LOGIN' where 1=1";
		autoModuleRoleService.dao().execute(backupSql);
		autoModuleRoleService.dao().execute(upsSql);
		return ErrorDesc.success();
	}


	/**
	 * 批量获取模块角色 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取模块角色")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AutoModuleRoleVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AutoModuleRoleServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleServiceProxy.GET_BY_IDS)
	public Result<List<AutoModuleRole>> getByIds(List<String> ids) {
		
		Result<List<AutoModuleRole>> result=new Result<>();
		List<AutoModuleRole> list=autoModuleRoleService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询模块角色
	*/
	@ApiOperation(value = "查询模块角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "eam_data_role"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "系统-用户自动配置数据角色"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.MODULE , value = "模块" , required = false , dataTypeClass=String.class , example = "eam"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "busi_role"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AutoModuleRoleVOMeta.PAGE_INDEX , AutoModuleRoleVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AutoModuleRoleServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleServiceProxy.QUERY_LIST)
	public Result<List<AutoModuleRole>> queryList(AutoModuleRoleVO sample) {
		
		Result<List<AutoModuleRole>> result=new Result<>();
		List<AutoModuleRole> list=autoModuleRoleService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询模块角色
	*/
	@ApiOperation(value = "分页查询模块角色")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "eam_data_role"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "系统-用户自动配置数据角色"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.STATUS , value = "状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.MODULE , value = "模块" , required = false , dataTypeClass=String.class , example = "eam"),
		@ApiImplicitParam(name = AutoModuleRoleVOMeta.TYPE , value = "类型" , required = false , dataTypeClass=String.class , example = "busi_role"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoModuleRoleServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AutoModuleRole>> queryPagedList(AutoModuleRoleVO sample) {
		
		Result<PagedList<AutoModuleRole>> result=new Result<>();
		PagedList<AutoModuleRole> list=autoModuleRoleService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}





}