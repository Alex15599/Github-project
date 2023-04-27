package com.dt.platform.ops.controller;

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


import com.dt.platform.proxy.ops.DbBackupInfoServiceProxy;
import com.dt.platform.domain.ops.meta.DbBackupInfoVOMeta;
import com.dt.platform.domain.ops.DbBackupInfo;
import com.dt.platform.domain.ops.DbBackupInfoVO;
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
import com.dt.platform.domain.ops.meta.DbBackupInfoMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.DbInfo;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.DbInfoMeta;
import com.dt.platform.domain.ops.meta.ServiceInfoMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbBackupInfoService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 数据库备份接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-31 22:15:26
*/

@InDoc
@Api(tags = "数据库备份")
@RestController("OpsDbBackupInfoController")
public class DbBackupInfoController extends SuperController {

	@Autowired
	private IDbBackupInfoService dbBackupInfoService;


	/**
	 * 添加数据库备份
	*/
	@ApiOperation(value = "添加数据库备份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "621369753377701888"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.DATABASE_ID , value = "数据库" , required = false , dataTypeClass=String.class , example = "621350881815691264"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.UID , value = "UID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.STATUS , value = "备份状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_STRATEGY , value = "备份策略" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_TYPE , value = "备份类型" , required = false , dataTypeClass=String.class , example = "physical"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_METHOD , value = "备份方式" , required = false , dataTypeClass=String.class , example = "full"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_DATAKEEP , value = "备份保留时长" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_RESULT , value = "备份结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_SOURCE , value = "备份来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_SIZE , value = "备份大小" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_TIME , value = "上次备份" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_RESULT_CT , value = "结果内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.STORAGE , value = "存放位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true , ignorePrimaryKey = true)
	@ApiOperationSupport(order=1 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbBackupInfoServiceProxy.INSERT , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbBackupInfoServiceProxy.INSERT)
	public Result insert(DbBackupInfoVO dbBackupInfoVO) {
		Result result=dbBackupInfoService.insert(dbBackupInfoVO,false);
		return result;
	}



	/**
	 * 删除数据库备份
	*/
	@ApiOperation(value = "删除数据库备份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "621369753377701888")
	})
	@ApiOperationSupport(order=2 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbBackupInfoServiceProxy.DELETE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbBackupInfoServiceProxy.DELETE)
	public Result deleteById(String id) {
		this.validator().asserts(id).require("缺少id值");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}
		// 引用校验
		ReferCause cause =  dbBackupInfoService.hasRefers(id);
		// 判断是否可以删除
		this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
		if(this.validator().failure()) {
			return this.validator().getFirstResult().messageLevel4Confirm();
		}
		Result result=dbBackupInfoService.deleteByIdLogical(id);
		return result;
	}


	/**
	 * 批量删除数据库备份 <br>
	 * 联合主键时，请自行调整实现
	*/
	@ApiOperation(value = "批量删除数据库备份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
	})
	@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
	@SentinelResource(value = DbBackupInfoServiceProxy.DELETE_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbBackupInfoServiceProxy.DELETE_BY_IDS)
	public Result deleteByIds(List<String> ids) {

		// 参数校验
		this.validator().asserts(ids).require("缺少ids参数");
		if(this.validator().failure()) {
			return this.validator().getFirstResult();
		}

		// 查询引用
		Map<String, ReferCause> causeMap = dbBackupInfoService.hasRefers(ids);
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
			Result result=dbBackupInfoService.deleteByIdsLogical(canDeleteIds);
			return result;
		} else if (canDeleteIds.size()>0 && canDeleteIds.size() < ids.size()) {
			// 如果部分行可以删除
			Result result=dbBackupInfoService.deleteByIdsLogical(canDeleteIds);
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
	 * 更新数据库备份
	*/
	@ApiOperation(value = "更新数据库备份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "621369753377701888"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.DATABASE_ID , value = "数据库" , required = false , dataTypeClass=String.class , example = "621350881815691264"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.UID , value = "UID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.STATUS , value = "备份状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_STRATEGY , value = "备份策略" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_TYPE , value = "备份类型" , required = false , dataTypeClass=String.class , example = "physical"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_METHOD , value = "备份方式" , required = false , dataTypeClass=String.class , example = "full"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_DATAKEEP , value = "备份保留时长" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_RESULT , value = "备份结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_SOURCE , value = "备份来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_SIZE , value = "备份大小" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_TIME , value = "上次备份" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_RESULT_CT , value = "结果内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.STORAGE , value = "存放位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport( order=4 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbBackupInfoVOMeta.PAGE_INDEX , DbBackupInfoVOMeta.PAGE_SIZE , DbBackupInfoVOMeta.SEARCH_FIELD , DbBackupInfoVOMeta.FUZZY_FIELD , DbBackupInfoVOMeta.SEARCH_VALUE , DbBackupInfoVOMeta.DIRTY_FIELDS , DbBackupInfoVOMeta.SORT_FIELD , DbBackupInfoVOMeta.SORT_TYPE , DbBackupInfoVOMeta.DATA_ORIGIN , DbBackupInfoVOMeta.QUERY_LOGIC , DbBackupInfoVOMeta.IDS } )
	@SentinelResource(value = DbBackupInfoServiceProxy.UPDATE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbBackupInfoServiceProxy.UPDATE)
	public Result update(DbBackupInfoVO dbBackupInfoVO) {
		Result result=dbBackupInfoService.update(dbBackupInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 保存数据库备份
	*/
	@ApiOperation(value = "保存数据库备份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "621369753377701888"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.DATABASE_ID , value = "数据库" , required = false , dataTypeClass=String.class , example = "621350881815691264"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.UID , value = "UID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.STATUS , value = "备份状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_STRATEGY , value = "备份策略" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_TYPE , value = "备份类型" , required = false , dataTypeClass=String.class , example = "physical"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_METHOD , value = "备份方式" , required = false , dataTypeClass=String.class , example = "full"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_DATAKEEP , value = "备份保留时长" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_RESULT , value = "备份结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_SOURCE , value = "备份来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_SIZE , value = "备份大小" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_TIME , value = "上次备份" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_RESULT_CT , value = "结果内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.STORAGE , value = "存放位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
	@ApiOperationSupport(order=5 ,  ignoreParameters = { DbBackupInfoVOMeta.PAGE_INDEX , DbBackupInfoVOMeta.PAGE_SIZE , DbBackupInfoVOMeta.SEARCH_FIELD , DbBackupInfoVOMeta.FUZZY_FIELD , DbBackupInfoVOMeta.SEARCH_VALUE , DbBackupInfoVOMeta.DIRTY_FIELDS , DbBackupInfoVOMeta.SORT_FIELD , DbBackupInfoVOMeta.SORT_TYPE , DbBackupInfoVOMeta.DATA_ORIGIN , DbBackupInfoVOMeta.QUERY_LOGIC , DbBackupInfoVOMeta.IDS } )
	@SentinelResource(value = DbBackupInfoServiceProxy.SAVE , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbBackupInfoServiceProxy.SAVE)
	public Result save(DbBackupInfoVO dbBackupInfoVO) {
		Result result=dbBackupInfoService.save(dbBackupInfoVO,SaveMode.DIRTY_OR_NOT_NULL_FIELDS,false);
		return result;
	}


	/**
	 * 获取数据库备份
	*/
	@ApiOperation(value = "获取数据库备份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "1"),
	})
	@ApiOperationSupport(order=6 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbBackupInfoServiceProxy.GET_BY_ID , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbBackupInfoServiceProxy.GET_BY_ID)
	public Result<DbBackupInfo> getById(String id) {
		Result<DbBackupInfo> result=new Result<>();
		DbBackupInfo dbBackupInfo=dbBackupInfoService.getById(id);
		// join 关联的对象
		dbBackupInfoService.dao().fill(dbBackupInfo)
			.with(DbBackupInfoMeta.HOST)
			.with(DbBackupInfoMeta.DB)
			.with(DbBackupInfoMeta.DB_TYPE)
			.execute();
		result.success(true).data(dbBackupInfo);
		return result;
	}


	/**
	 * 批量获取数据库备份 <br>
	 * 联合主键时，请自行调整实现
	*/
		@ApiOperation(value = "批量获取数据库备份")
		@ApiImplicitParams({
				@ApiImplicitParam(name = DbBackupInfoVOMeta.IDS , value = "主键清单" , required = true , dataTypeClass=List.class , example = "[1,3,4]")
		})
		@ApiOperationSupport(order=3 , author="金杰 , maillank@qq.com") 
		@SentinelResource(value = DbBackupInfoServiceProxy.GET_BY_IDS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbBackupInfoServiceProxy.GET_BY_IDS)
	public Result<List<DbBackupInfo>> getByIds(List<String> ids) {
		Result<List<DbBackupInfo>> result=new Result<>();
		List<DbBackupInfo> list=dbBackupInfoService.queryListByIds(ids);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 查询数据库备份
	*/
	@ApiOperation(value = "查询数据库备份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "621369753377701888"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.DATABASE_ID , value = "数据库" , required = false , dataTypeClass=String.class , example = "621350881815691264"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.UID , value = "UID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.STATUS , value = "备份状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_STRATEGY , value = "备份策略" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_TYPE , value = "备份类型" , required = false , dataTypeClass=String.class , example = "physical"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_METHOD , value = "备份方式" , required = false , dataTypeClass=String.class , example = "full"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_DATAKEEP , value = "备份保留时长" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_RESULT , value = "备份结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_SOURCE , value = "备份来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_SIZE , value = "备份大小" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_TIME , value = "上次备份" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_RESULT_CT , value = "结果内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.STORAGE , value = "存放位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=5 , author="金杰 , maillank@qq.com" ,  ignoreParameters = { DbBackupInfoVOMeta.PAGE_INDEX , DbBackupInfoVOMeta.PAGE_SIZE } )
	@SentinelResource(value = DbBackupInfoServiceProxy.QUERY_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbBackupInfoServiceProxy.QUERY_LIST)
	public Result<List<DbBackupInfo>> queryList(DbBackupInfoVO sample) {
		Result<List<DbBackupInfo>> result=new Result<>();
		List<DbBackupInfo> list=dbBackupInfoService.queryList(sample);
		result.success(true).data(list);
		return result;
	}


	/**
	 * 分页查询数据库备份
	*/
	@ApiOperation(value = "分页查询数据库备份")
	@ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupInfoVOMeta.ID , value = "主键" , required = true , dataTypeClass=String.class , example = "621369753377701888"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.DATABASE_ID , value = "数据库" , required = false , dataTypeClass=String.class , example = "621350881815691264"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.UID , value = "UID" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.NAME , value = "名称" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.STATUS , value = "备份状态" , required = false , dataTypeClass=String.class , example = "online"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_STRATEGY , value = "备份策略" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_TYPE , value = "备份类型" , required = false , dataTypeClass=String.class , example = "physical"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_METHOD , value = "备份方式" , required = false , dataTypeClass=String.class , example = "full"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_DATAKEEP , value = "备份保留时长" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_RESULT , value = "备份结果" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_SOURCE , value = "备份来源" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_SIZE , value = "备份大小" , required = false , dataTypeClass=BigDecimal.class , example = "0.00"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_TIME , value = "上次备份" , required = false , dataTypeClass=Date.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.BACKUP_RESULT_CT , value = "结果内容" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.STORAGE , value = "存放位置" , required = false , dataTypeClass=String.class),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.NOTES , value = "备注" , required = false , dataTypeClass=String.class , example = "12"),
		@ApiImplicitParam(name = DbBackupInfoVOMeta.SELECTED_CODE , value = "选择" , required = false , dataTypeClass=String.class),
	})
	@ApiOperationSupport(order=8 , author="金杰 , maillank@qq.com")
	@SentinelResource(value = DbBackupInfoServiceProxy.QUERY_PAGED_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
	@PostMapping(DbBackupInfoServiceProxy.QUERY_PAGED_LIST)
	public Result<PagedList<DbBackupInfo>> queryPagedList(DbBackupInfoVO sample) {
		Result<PagedList<DbBackupInfo>> result=new Result<>();
		PagedList<DbBackupInfo> list=dbBackupInfoService.queryPagedList(sample,sample.getPageSize(),sample.getPageIndex());
		// join 关联的对象
		dbBackupInfoService.dao().fill(list)
			.with(DbBackupInfoMeta.HOST)
			.with(DbBackupInfoMeta.DB)
			.with(DbBackupInfoMeta.DB_TYPE)
			.execute();
		result.success(true).data(list);
		return result;
	}






}