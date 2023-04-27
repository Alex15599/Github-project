package com.dt.platform.eam.controller;


import java.util.*;
import org.github.foxnic.web.framework.web.SuperController;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;


import com.dt.platform.proxy.eam.AssetMaintenanceRecordUServiceProxy;
import com.dt.platform.domain.eam.meta.AssetMaintenanceRecordUVOMeta;
import com.dt.platform.domain.eam.AssetMaintenanceRecordU;
import com.dt.platform.domain.eam.AssetMaintenanceRecordUVO;
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
import com.dt.platform.domain.eam.meta.AssetMaintenanceRecordUMeta;
import com.dt.platform.domain.eam.Maintainer;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.AssetMaintenanceUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetMaintenanceRecordUService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 维保更新记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-29 15:12:32
*/

@InDoc
@Api(tags = "维保更新记录")
@RestController("EamAssetMaintenanceRecordUController")
public class AssetMaintenanceRecordUController extends SuperController {

	@Autowired
	private IAssetMaintenanceRecordUService assetMaintenanceRecordUService;


	/**
	 * 添加维保更新记录
	*/
	@ApiOperation(value = "添加维保更新记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_UPDATE_ID , value = "维保更新" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTAINER_ID , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTAINER_ID , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_ID , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTAINER_NAME , value = "维保厂商名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTAINER_NAME , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTAINER_NAME , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_NAME , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_STATUS , value = "维保状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_STATUS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_STATUS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_METHOD , value = "维保方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_METHOD , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_CONTACT_INFORMATION , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_CONTACT_INFORMATION , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_CONTACT_INFORMATION , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.SUGGEST_MAINTENANCE_METHOD , value = "建议维保方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_SUGGEST_MAINTENANCE_METHOD , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_SUGGEST_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_SUGGEST_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_CONTACTS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_CONTACTS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_CONTACTS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_DIRECTOR , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_DIRECTOR , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_DIRECTOR , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_START_DATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_START_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_START_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_END_DATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_END_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_END_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_NOTES , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_NOTES , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_NOTES , value = "更新方式" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetMaintenanceRecordUServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceRecordUServiceProxy.INSERT)
	public Result insert(AssetMaintenanceRecordUVO assetMaintenanceRecordUVO) {
		Result result=assetMaintenanceRecordUService.insert(assetMaintenanceRecordUVO,false);
		return result;
	}



	/**
	 * 删除维保更新记录
	*/
	@ApiOperation(value = "删除维保更新记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class)
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetMaintenanceRecordUServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceRecordUServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  assetMaintenanceRecordUService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		Result result=assetMaintenanceRecordUService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除维保更新记录 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除维保更新记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = AssetMaintenanceRecordUServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceRecordUServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = assetMaintenanceRecordUService.hasRefers(ids);
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
			Result result=assetMaintenanceRecordUService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=assetMaintenanceRecordUService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新维保更新记录
	*/
	@ApiOperation(value = "更新维保更新记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_UPDATE_ID , value = "维保更新" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTAINER_ID , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTAINER_ID , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_ID , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTAINER_NAME , value = "维保厂商名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTAINER_NAME , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTAINER_NAME , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_NAME , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_STATUS , value = "维保状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_STATUS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_STATUS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_METHOD , value = "维保方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_METHOD , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_CONTACT_INFORMATION , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_CONTACT_INFORMATION , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_CONTACT_INFORMATION , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.SUGGEST_MAINTENANCE_METHOD , value = "建议维保方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_SUGGEST_MAINTENANCE_METHOD , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_SUGGEST_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_SUGGEST_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_CONTACTS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_CONTACTS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_CONTACTS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_DIRECTOR , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_DIRECTOR , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_DIRECTOR , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_START_DATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_START_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_START_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_END_DATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_END_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_END_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_NOTES , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_NOTES , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_NOTES , value = "更新方式" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetMaintenanceRecordUVOMeta.PAGE_INDEX , AssetMaintenanceRecordUVOMeta.PAGE_SIZE , AssetMaintenanceRecordUVOMeta.SEARCH_FIELD , AssetMaintenanceRecordUVOMeta.FUZZY_FIELD , AssetMaintenanceRecordUVOMeta.SEARCH_VALUE , AssetMaintenanceRecordUVOMeta.DIRTY_FIELDS , AssetMaintenanceRecordUVOMeta.SORT_FIELD , AssetMaintenanceRecordUVOMeta.SORT_TYPE , AssetMaintenanceRecordUVOMeta.IDS } )
	@SentinelResource(value = AssetMaintenanceRecordUServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceRecordUServiceProxy.UPDATE)
	public Result update(AssetMaintenanceRecordUVO assetMaintenanceRecordUVO) {
		Result result=assetMaintenanceRecordUService.update(assetMaintenanceRecordUVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存维保更新记录
	*/
	@ApiOperation(value = "保存维保更新记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_UPDATE_ID , value = "维保更新" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTAINER_ID , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTAINER_ID , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_ID , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTAINER_NAME , value = "维保厂商名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTAINER_NAME , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTAINER_NAME , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_NAME , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_STATUS , value = "维保状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_STATUS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_STATUS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_METHOD , value = "维保方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_METHOD , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_CONTACT_INFORMATION , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_CONTACT_INFORMATION , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_CONTACT_INFORMATION , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.SUGGEST_MAINTENANCE_METHOD , value = "建议维保方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_SUGGEST_MAINTENANCE_METHOD , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_SUGGEST_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_SUGGEST_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_CONTACTS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_CONTACTS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_CONTACTS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_DIRECTOR , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_DIRECTOR , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_DIRECTOR , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_START_DATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_START_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_START_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_END_DATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_END_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_END_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_NOTES , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_NOTES , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_NOTES , value = "更新方式" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { AssetMaintenanceRecordUVOMeta.PAGE_INDEX , AssetMaintenanceRecordUVOMeta.PAGE_SIZE , AssetMaintenanceRecordUVOMeta.SEARCH_FIELD , AssetMaintenanceRecordUVOMeta.FUZZY_FIELD , AssetMaintenanceRecordUVOMeta.SEARCH_VALUE , AssetMaintenanceRecordUVOMeta.DIRTY_FIELDS , AssetMaintenanceRecordUVOMeta.SORT_FIELD , AssetMaintenanceRecordUVOMeta.SORT_TYPE , AssetMaintenanceRecordUVOMeta.IDS } )
	@SentinelResource(value = AssetMaintenanceRecordUServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceRecordUServiceProxy.SAVE)
	public Result save(AssetMaintenanceRecordUVO assetMaintenanceRecordUVO) {
		Result result=assetMaintenanceRecordUService.save(assetMaintenanceRecordUVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取维保更新记录
	*/
	@ApiOperation(value = "获取维保更新记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetMaintenanceRecordUServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceRecordUServiceProxy.GET_BY_ID)
	public Result<AssetMaintenanceRecordU> getById(String id) {
		Result<AssetMaintenanceRecordU> result=new Result<>();
		AssetMaintenanceRecordU assetMaintenanceRecordU=assetMaintenanceRecordUService.getById(id);
		// join 关联的对象
		assetMaintenanceRecordUService.dao().fill(assetMaintenanceRecordU)
			.with(AssetMaintenanceRecordUMeta.MAINTNAINER)
			.with(AssetMaintenanceRecordUMeta.ASSET_MAINTENANCE_STATUS)
			.with(AssetMaintenanceRecordUMeta.MAINTENANCE_METHOD_DATA)
			.with(AssetMaintenanceRecordUMeta.SUGGEST_MAINTENANCE_METHOD_DATA)
			.execute();
		result.success(true).data(assetMaintenanceRecordU);
		return result;
	}


	/**
	 * 批量获取维保更新记录 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取维保更新记录")
		@ApiImplicitParams({
				@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = AssetMaintenanceRecordUServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceRecordUServiceProxy.GET_BY_IDS)
	public Result<List<AssetMaintenanceRecordU>> getByIds(List<String> ids) {
		Result<List<AssetMaintenanceRecordU>> result=new Result<>();
		List<AssetMaintenanceRecordU> list=assetMaintenanceRecordUService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询维保更新记录
	*/
	@ApiOperation(value = "查询维保更新记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_UPDATE_ID , value = "维保更新" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTAINER_ID , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTAINER_ID , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_ID , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTAINER_NAME , value = "维保厂商名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTAINER_NAME , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTAINER_NAME , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_NAME , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_STATUS , value = "维保状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_STATUS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_STATUS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_METHOD , value = "维保方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_METHOD , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_CONTACT_INFORMATION , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_CONTACT_INFORMATION , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_CONTACT_INFORMATION , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.SUGGEST_MAINTENANCE_METHOD , value = "建议维保方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_SUGGEST_MAINTENANCE_METHOD , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_SUGGEST_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_SUGGEST_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_CONTACTS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_CONTACTS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_CONTACTS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_DIRECTOR , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_DIRECTOR , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_DIRECTOR , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_START_DATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_START_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_START_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_END_DATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_END_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_END_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_NOTES , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_NOTES , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_NOTES , value = "更新方式" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { AssetMaintenanceRecordUVOMeta.PAGE_INDEX , AssetMaintenanceRecordUVOMeta.PAGE_SIZE } )
	@SentinelResource(value = AssetMaintenanceRecordUServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceRecordUServiceProxy.QUERY_LIST)
	public Result<List<AssetMaintenanceRecordU>> queryList(AssetMaintenanceRecordUVO sample) {
		Result<List<AssetMaintenanceRecordU>> result=new Result<>();
		List<AssetMaintenanceRecordU> list=assetMaintenanceRecordUService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询维保更新记录
	*/
	@ApiOperation(value = "分页查询维保更新记录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_UPDATE_ID , value = "维保更新" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTAINER_ID , value = "维保厂商" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTAINER_ID , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTAINER_ID , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_ID , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTAINER_NAME , value = "维保厂商名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTAINER_NAME , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTAINER_NAME , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_NAME , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_STATUS , value = "维保状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_STATUS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_STATUS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_STATUS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_METHOD , value = "维保方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_METHOD , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.CONTACT_INFORMATION , value = "联系方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_CONTACT_INFORMATION , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_CONTACT_INFORMATION , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_CONTACT_INFORMATION , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.SUGGEST_MAINTENANCE_METHOD , value = "建议维保方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_SUGGEST_MAINTENANCE_METHOD , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_SUGGEST_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_SUGGEST_MAINTENANCE_METHOD , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.CONTACTS , value = "联系人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_CONTACTS , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_CONTACTS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_CONTACTS , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.DIRECTOR , value = "负责人" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_DIRECTOR , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_DIRECTOR , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_DIRECTOR , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_START_DATE , value = "维保开始时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_START_DATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_START_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_START_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_END_DATE , value = "维保到期时间" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_END_DATE , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_END_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_END_DATE , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.MAINTENANCE_NOTES , value = "备注" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_NOTES , value = "状态" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_NOTES , value = "更新方式" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_NOTES , value = "更新方式" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = AssetMaintenanceRecordUServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(AssetMaintenanceRecordUServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<AssetMaintenanceRecordU>> queryPagedList(AssetMaintenanceRecordUVO sample) {
		Result<PagedList<AssetMaintenanceRecordU>> result=new Result<>();
		PagedList<AssetMaintenanceRecordU> list=assetMaintenanceRecordUService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		assetMaintenanceRecordUService.dao().fill(list)
			.with(AssetMaintenanceRecordUMeta.MAINTNAINER)
			.with(AssetMaintenanceRecordUMeta.ASSET_MAINTENANCE_STATUS)
			.with(AssetMaintenanceRecordUMeta.MAINTENANCE_METHOD_DATA)
			.with(AssetMaintenanceRecordUMeta.SUGGEST_MAINTENANCE_METHOD_DATA)
			.execute();
		result.success(true).data(list);
		return result;
	}






}