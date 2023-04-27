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


import com.dt.platform.proxy.common.BackupDbStrategyServiceProxy;
import com.dt.platform.domain.common.meta.BackupDbStrategyVOMeta;
import com.dt.platform.domain.common.BackupDbStrategy;
import com.dt.platform.domain.common.BackupDbStrategyVO;
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
import com.dt.platform.domain.common.meta.BackupDbStrategyMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.IBackupDbStrategyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 备份策略接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-26 18:37:10
*/

@InDoc
@Api(tags = "备份策略")
@RestController("SysBackupDbStrategyController")
public class BackupDbStrategyController extends SuperController {

	@Autowired
	private IBackupDbStrategyService backupDbStrategyService;


	/**
	 * 添加备份策略
	*/
	@ApiOperation(value = "添加备份策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.DATA_PATH , value = "备份路径" , required = false , dataTypeClass=String.class , example = "/app/app/backup/db"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.DATA_KEEP , value = "备份保留" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.CRONTAB , value = "备份周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.MAIL , value = "邮件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "每天晚上自动备份"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BackupDbStrategyServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BackupDbStrategyServiceProxy.INSERT)
	public Result insert(BackupDbStrategyVO backupDbStrategyVO) {
		Result result=backupDbStrategyService.insert(backupDbStrategyVO,false);
		return result;
	}



	/**
	 * 删除备份策略
	*/
	@ApiOperation(value = "删除备份策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BackupDbStrategyServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BackupDbStrategyServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  backupDbStrategyService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=backupDbStrategyService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除备份策略 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除备份策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = BackupDbStrategyServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BackupDbStrategyServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = backupDbStrategyService.hasRefers(ids);
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
			Result result=backupDbStrategyService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=backupDbStrategyService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新备份策略
	*/
	@ApiOperation(value = "更新备份策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.DATA_PATH , value = "备份路径" , required = false , dataTypeClass=String.class , example = "/app/app/backup/db"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.DATA_KEEP , value = "备份保留" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.CRONTAB , value = "备份周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.MAIL , value = "邮件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "每天晚上自动备份"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { BackupDbStrategyVOMeta.PAGE_INDEX , BackupDbStrategyVOMeta.PAGE_SIZE , BackupDbStrategyVOMeta.SEARCH_FIELD , BackupDbStrategyVOMeta.FUZZY_FIELD , BackupDbStrategyVOMeta.SEARCH_VALUE , BackupDbStrategyVOMeta.DIRTY_FIELDS , BackupDbStrategyVOMeta.SORT_FIELD , BackupDbStrategyVOMeta.SORT_TYPE , BackupDbStrategyVOMeta.DATA_ORIGIN , BackupDbStrategyVOMeta.QUERY_LOGIC , BackupDbStrategyVOMeta.IDS } )
	@SentinelResource(value = BackupDbStrategyServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BackupDbStrategyServiceProxy.UPDATE)
	public Result update(BackupDbStrategyVO backupDbStrategyVO) {
		Result result=backupDbStrategyService.update(backupDbStrategyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存备份策略
	*/
	@ApiOperation(value = "保存备份策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.DATA_PATH , value = "备份路径" , required = false , dataTypeClass=String.class , example = "/app/app/backup/db"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.DATA_KEEP , value = "备份保留" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.CRONTAB , value = "备份周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.MAIL , value = "邮件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "每天晚上自动备份"),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { BackupDbStrategyVOMeta.PAGE_INDEX , BackupDbStrategyVOMeta.PAGE_SIZE , BackupDbStrategyVOMeta.SEARCH_FIELD , BackupDbStrategyVOMeta.FUZZY_FIELD , BackupDbStrategyVOMeta.SEARCH_VALUE , BackupDbStrategyVOMeta.DIRTY_FIELDS , BackupDbStrategyVOMeta.SORT_FIELD , BackupDbStrategyVOMeta.SORT_TYPE , BackupDbStrategyVOMeta.DATA_ORIGIN , BackupDbStrategyVOMeta.QUERY_LOGIC , BackupDbStrategyVOMeta.IDS } )
	@SentinelResource(value = BackupDbStrategyServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BackupDbStrategyServiceProxy.SAVE)
	public Result save(BackupDbStrategyVO backupDbStrategyVO) {
		Result result=backupDbStrategyService.save(backupDbStrategyVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取备份策略
	*/
	@ApiOperation(value = "获取备份策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BackupDbStrategyServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BackupDbStrategyServiceProxy.GET_BY_ID)
	public Result<BackupDbStrategy> getById(String id) {
		Result<BackupDbStrategy> result=new Result<>();
		BackupDbStrategy backupDbStrategy=backupDbStrategyService.getById(id);
		result.success(true).data(backupDbStrategy);
		return result;
	}


	/**
	 * 批量获取备份策略 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取备份策略")
		@ApiImplicitParams({
				@ApiImplicitParam(name = BackupDbStrategyVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = BackupDbStrategyServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BackupDbStrategyServiceProxy.GET_BY_IDS)
	public Result<List<BackupDbStrategy>> getByIds(List<String> ids) {
		Result<List<BackupDbStrategy>> result=new Result<>();
		List<BackupDbStrategy> list=backupDbStrategyService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询备份策略
	*/
	@ApiOperation(value = "查询备份策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.DATA_PATH , value = "备份路径" , required = false , dataTypeClass=String.class , example = "/app/app/backup/db"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.DATA_KEEP , value = "备份保留" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.CRONTAB , value = "备份周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.MAIL , value = "邮件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "每天晚上自动备份"),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { BackupDbStrategyVOMeta.PAGE_INDEX , BackupDbStrategyVOMeta.PAGE_SIZE } )
	@SentinelResource(value = BackupDbStrategyServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BackupDbStrategyServiceProxy.QUERY_LIST)
	public Result<List<BackupDbStrategy>> queryList(BackupDbStrategyVO sample) {
		Result<List<BackupDbStrategy>> result=new Result<>();
		List<BackupDbStrategy> list=backupDbStrategyService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询备份策略
	*/
	@ApiOperation(value = "分页查询备份策略")
	@ApiImplicitParams({
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "001"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.STATUS , value = "启用状态" , required = false , dataTypeClass=String.class , example = "enable"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.DATA_PATH , value = "备份路径" , required = false , dataTypeClass=String.class , example = "/app/app/backup/db"),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.DATA_KEEP , value = "备份保留" , required = false , dataTypeClass=Integer.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.CRONTAB , value = "备份周期" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.MAIL , value = "邮件" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = BackupDbStrategyVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "每天晚上自动备份"),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = BackupDbStrategyServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(BackupDbStrategyServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<BackupDbStrategy>> queryPagedList(BackupDbStrategyVO sample) {
		Result<PagedList<BackupDbStrategy>> result=new Result<>();
		PagedList<BackupDbStrategy> list=backupDbStrategyService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		result.success(true).data(list);
		return result;
	}






}