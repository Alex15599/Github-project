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


import com.dt.platform.proxy.common.AutoModuleRoleItemServiceProxy;
import com.dt.platform.domain.common.meta.AutoModuleRoleItemVOMeta;
import com.dt.platform.domain.common.AutoModuleRoleItem;
import com.dt.platform.domain.common.AutoModuleRoleItemVO;
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
import com.dt.platform.domain.common.meta.AutoModuleRoleItemMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IAutoModuleRoleItemService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 赋权明细接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:04:25
*/

@InDoc
@Api(tags = "赋权明细")
@RestController("SysAutoModuleRoleItemController")
public class AutoModuleRoleItemController extends SuperController {

	@Autowired
	private IAutoModuleRoleItemService autoModuleRoleItemService;


	/**
	 * 添加赋权明细
	*/
	@ApiOperation(value = "添加赋权明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.MODULE_ROLE_ID , value = "模块" , required = false , dataTypeClass=String.class , example = "eam_role"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ROLE_ID , value = "角色" , required = false , dataTypeClass=String.class , example = "505736820663779328"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ROLE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "固定资产员工"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoModuleRoleItemServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleItemServiceProxy.INSERT)
	public Result insert(AutoModuleRoleItemVO autoModuleRoleItemVO) {
		Result result=autoModuleRoleItemService.insert(autoModuleRoleItemVO,false);
		return result;
	}



	/**
	 * 删除赋权明细
	*/
	@ApiOperation(value = "删除赋权明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoModuleRoleItemServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleItemServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  autoModuleRoleItemService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=autoModuleRoleItemService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除赋权明细 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除赋权明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AutoModuleRoleItemServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleItemServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = autoModuleRoleItemService.hasRefers(ids);
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
			Result result=autoModuleRoleItemService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=autoModuleRoleItemService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新赋权明细
	*/
	@ApiOperation(value = "更新赋权明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.MODULE_ROLE_ID , value = "模块" , required = false , dataTypeClass=String.class , example = "eam_role"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ROLE_ID , value = "角色" , required = false , dataTypeClass=String.class , example = "505736820663779328"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ROLE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "固定资产员工"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AutoModuleRoleItemVOMeta.PAGE_INDEX , AutoModuleRoleItemVOMeta.PAGE_SIZE , AutoModuleRoleItemVOMeta.SEARCH_FIELD , AutoModuleRoleItemVOMeta.FUZZY_FIELD , AutoModuleRoleItemVOMeta.SEARCH_VALUE , AutoModuleRoleItemVOMeta.DIRTY_FIELDS , AutoModuleRoleItemVOMeta.SORT_FIELD , AutoModuleRoleItemVOMeta.SORT_TYPE , AutoModuleRoleItemVOMeta.DATA_ORIGIN , AutoModuleRoleItemVOMeta.QUERY_LOGIC , AutoModuleRoleItemVOMeta.IDS } )
	@SentinelResource(value = AutoModuleRoleItemServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleItemServiceProxy.UPDATE)
	public Result update(AutoModuleRoleItemVO autoModuleRoleItemVO) {
		Result result=autoModuleRoleItemService.update(autoModuleRoleItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存赋权明细
	*/
	@ApiOperation(value = "保存赋权明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.MODULE_ROLE_ID , value = "模块" , required = false , dataTypeClass=String.class , example = "eam_role"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ROLE_ID , value = "角色" , required = false , dataTypeClass=String.class , example = "505736820663779328"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ROLE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "固定资产员工"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AutoModuleRoleItemVOMeta.PAGE_INDEX , AutoModuleRoleItemVOMeta.PAGE_SIZE , AutoModuleRoleItemVOMeta.SEARCH_FIELD , AutoModuleRoleItemVOMeta.FUZZY_FIELD , AutoModuleRoleItemVOMeta.SEARCH_VALUE , AutoModuleRoleItemVOMeta.DIRTY_FIELDS , AutoModuleRoleItemVOMeta.SORT_FIELD , AutoModuleRoleItemVOMeta.SORT_TYPE , AutoModuleRoleItemVOMeta.DATA_ORIGIN , AutoModuleRoleItemVOMeta.QUERY_LOGIC , AutoModuleRoleItemVOMeta.IDS } )
	@SentinelResource(value = AutoModuleRoleItemServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleItemServiceProxy.SAVE)
	public Result save(AutoModuleRoleItemVO autoModuleRoleItemVO) {
		Result result=autoModuleRoleItemService.save(autoModuleRoleItemVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取赋权明细
	*/
	@ApiOperation(value = "获取赋权明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoModuleRoleItemServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleItemServiceProxy.GET_BY_ID)
	public Result<AutoModuleRoleItem> getById(String id) {
		Result<AutoModuleRoleItem> result=new Result<>();
		AutoModuleRoleItem autoModuleRoleItem=autoModuleRoleItemService.getById(id);
		result.success(true).data(autoModuleRoleItem);
		return result;
	}


	/**
	 * 批量获取赋权明细 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取赋权明细")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AutoModuleRoleItemServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleItemServiceProxy.GET_BY_IDS)
	public Result<List<AutoModuleRoleItem>> getByIds(List<String> ids) {
		Result<List<AutoModuleRoleItem>> result=new Result<>();
		List<AutoModuleRoleItem> list=autoModuleRoleItemService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询赋权明细
	*/
	@ApiOperation(value = "查询赋权明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.MODULE_ROLE_ID , value = "模块" , required = false , dataTypeClass=String.class , example = "eam_role"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ROLE_ID , value = "角色" , required = false , dataTypeClass=String.class , example = "505736820663779328"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ROLE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "固定资产员工"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AutoModuleRoleItemVOMeta.PAGE_INDEX , AutoModuleRoleItemVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AutoModuleRoleItemServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleItemServiceProxy.QUERY_LIST)
	public Result<List<AutoModuleRoleItem>> queryList(AutoModuleRoleItemVO sample) {
		Result<List<AutoModuleRoleItem>> result=new Result<>();
		List<AutoModuleRoleItem> list=autoModuleRoleItemService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询赋权明细
	*/
	@ApiOperation(value = "分页查询赋权明细")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.MODULE_ROLE_ID , value = "模块" , required = false , dataTypeClass=String.class , example = "eam_role"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ROLE_ID , value = "角色" , required = false , dataTypeClass=String.class , example = "505736820663779328"),
		@ApiImplicitParam(name = AutoModuleRoleItemVOMeta.ROLE_NAME , value = "名称" , required = false , dataTypeClass=String.class , example = "固定资产员工"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AutoModuleRoleItemServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AutoModuleRoleItemServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AutoModuleRoleItem>> queryPagedList(AutoModuleRoleItemVO sample) {
		Result<PagedList<AutoModuleRoleItem>> result=new Result<>();
		PagedList<AutoModuleRoleItem> list=autoModuleRoleItemService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}