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
import com.dt.platform.proxy.ops.DbBackupLogServiceProxy;
import com.dt.platform.domain.ops.meta.DbBackupLogVOMeta;
import com.dt.platform.domain.ops.DbBackupLog;
import com.dt.platform.domain.ops.DbBackupLogVO;
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
import com.dt.platform.domain.ops.meta.DbBackupLogMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IDbBackupLogService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 备份日志接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-30 20:06:33
 */
@InDoc
@Api(tags = "备份日志")
@RestController("OpsDbBackupLogController")
public class DbBackupLogController extends SuperController {

    @Autowired
    private IDbBackupLogService dbBackupLogService;

    /**
     * 添加备份日志
     */
    @ApiOperation(value = "添加备份日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "672531349382365184"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.UID, value = "UID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.DB_ID, value = "数据库实例", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.DB_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.ACTION, value = "动作", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "processed"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.METHOD, value = "方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.SIZE, value = "大小", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.SOURCE, value = "原始数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.PROCESSED, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.PROCESS_RESULT, value = "处理结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.LAST_PROCESS_TIME, value = "处理时间", required = false, dataTypeClass = Date.class, example = ""), // @ApiImplicitParam(name = DbBackupLogVOMeta.RTIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = ""),
    @ApiImplicitParam(name = DbBackupLogVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = "")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbBackupLogServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbBackupLogServiceProxy.INSERT)
    public Result insert(DbBackupLogVO dbBackupLogVO) {
        Result result = dbBackupLogService.insert(dbBackupLogVO, false);
        return result;
    }

    /**
     * 删除备份日志
     */
    @ApiOperation(value = "删除备份日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "672531349382365184")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbBackupLogServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbBackupLogServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = dbBackupLogService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = dbBackupLogService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除备份日志 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除备份日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupLogVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbBackupLogServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbBackupLogServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = dbBackupLogService.hasRefers(ids);
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
            return ErrorDesc.failure().message("无法删除您选中的数据行：").data(0).addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(), (e) -> {
                return e.hasRefer();
            }), ReferCause::message, String.class)).messageLevel4Confirm();
        } else if (canDeleteIds.size() == ids.size()) {
            // 如果全部可以删除
            Result result = dbBackupLogService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = dbBackupLogService.deleteByIdsLogical(canDeleteIds);
            if (result.failure()) {
                return result;
            } else {
                return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").data(canDeleteIds.size()).addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(), (e) -> {
                    return e.hasRefer();
                }), ReferCause::message, String.class)).messageLevel4Confirm();
            }
        } else {
            // 理论上，这个分支不存在
            return ErrorDesc.success().message("数据删除未处理");
        }
    }

    /**
     * 更新备份日志
     */
    @ApiOperation(value = "更新备份日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "672531349382365184"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.UID, value = "UID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.DB_ID, value = "数据库实例", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.DB_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.ACTION, value = "动作", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "processed"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.METHOD, value = "方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.SIZE, value = "大小", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.SOURCE, value = "原始数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.PROCESSED, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.PROCESS_RESULT, value = "处理结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.LAST_PROCESS_TIME, value = "处理时间", required = false, dataTypeClass = Date.class, example = ""), // @ApiImplicitParam(name = DbBackupLogVOMeta.RTIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = ""),
    @ApiImplicitParam(name = DbBackupLogVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = "")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { DbBackupLogVOMeta.PAGE_INDEX, DbBackupLogVOMeta.PAGE_SIZE, DbBackupLogVOMeta.SEARCH_FIELD, DbBackupLogVOMeta.FUZZY_FIELD, DbBackupLogVOMeta.SEARCH_VALUE, DbBackupLogVOMeta.DIRTY_FIELDS, DbBackupLogVOMeta.SORT_FIELD, DbBackupLogVOMeta.SORT_TYPE, DbBackupLogVOMeta.DATA_ORIGIN, DbBackupLogVOMeta.QUERY_LOGIC, DbBackupLogVOMeta.IDS })
    @SentinelResource(value = DbBackupLogServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbBackupLogServiceProxy.UPDATE)
    public Result update(DbBackupLogVO dbBackupLogVO) {
        Result result = dbBackupLogService.update(dbBackupLogVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存备份日志
     */
    @ApiOperation(value = "保存备份日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "672531349382365184"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.UID, value = "UID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.DB_ID, value = "数据库实例", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.DB_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.ACTION, value = "动作", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "processed"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.METHOD, value = "方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.SIZE, value = "大小", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.SOURCE, value = "原始数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.PROCESSED, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.PROCESS_RESULT, value = "处理结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.LAST_PROCESS_TIME, value = "处理时间", required = false, dataTypeClass = Date.class, example = ""), // @ApiImplicitParam(name = DbBackupLogVOMeta.RTIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = ""),
    @ApiImplicitParam(name = DbBackupLogVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = "")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { DbBackupLogVOMeta.PAGE_INDEX, DbBackupLogVOMeta.PAGE_SIZE, DbBackupLogVOMeta.SEARCH_FIELD, DbBackupLogVOMeta.FUZZY_FIELD, DbBackupLogVOMeta.SEARCH_VALUE, DbBackupLogVOMeta.DIRTY_FIELDS, DbBackupLogVOMeta.SORT_FIELD, DbBackupLogVOMeta.SORT_TYPE, DbBackupLogVOMeta.DATA_ORIGIN, DbBackupLogVOMeta.QUERY_LOGIC, DbBackupLogVOMeta.IDS })
    @SentinelResource(value = DbBackupLogServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbBackupLogServiceProxy.SAVE)
    public Result save(DbBackupLogVO dbBackupLogVO) {
        Result result = dbBackupLogService.save(dbBackupLogVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取备份日志
     */
    @ApiOperation(value = "获取备份日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbBackupLogServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbBackupLogServiceProxy.GET_BY_ID)
    public Result<DbBackupLog> getById(String id) {
        Result<DbBackupLog> result = new Result<>();
        DbBackupLog dbBackupLog = dbBackupLogService.getById(id);
        result.success(true).data(dbBackupLog);
        return result;
    }


    /**
     * 获取备份日志
     */
    @ApiOperation(value = "处理数据")

    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbBackupLogServiceProxy.PARSE_LOG, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbBackupLogServiceProxy.PARSE_LOG)
    public Result parseLog() {
        return dbBackupLogService.parseLog();
    }


    /**
     * 批量获取备份日志 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取备份日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupLogVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbBackupLogServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbBackupLogServiceProxy.GET_BY_IDS)
    public Result<List<DbBackupLog>> getByIds(List<String> ids) {
        Result<List<DbBackupLog>> result = new Result<>();
        List<DbBackupLog> list = dbBackupLogService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询备份日志
     */
    @ApiOperation(value = "查询备份日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "672531349382365184"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.UID, value = "UID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.DB_ID, value = "数据库实例", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.DB_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.ACTION, value = "动作", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "processed"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.METHOD, value = "方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.SIZE, value = "大小", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.SOURCE, value = "原始数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.PROCESSED, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.PROCESS_RESULT, value = "处理结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.LAST_PROCESS_TIME, value = "处理时间", required = false, dataTypeClass = Date.class, example = ""), // @ApiImplicitParam(name = DbBackupLogVOMeta.RTIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = ""),
    @ApiImplicitParam(name = DbBackupLogVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = "")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { DbBackupLogVOMeta.PAGE_INDEX, DbBackupLogVOMeta.PAGE_SIZE })
    @SentinelResource(value = DbBackupLogServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbBackupLogServiceProxy.QUERY_LIST)
    public Result<List<DbBackupLog>> queryList(DbBackupLogVO sample) {
        Result<List<DbBackupLog>> result = new Result<>();
        List<DbBackupLog> list = dbBackupLogService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询备份日志
     */
    @ApiOperation(value = "分页查询备份日志")
    @ApiImplicitParams({
		@ApiImplicitParam(name = DbBackupLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "672531349382365184"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.UID, value = "UID", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.DB_ID, value = "数据库实例", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.DB_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.ACTION, value = "动作", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "processed"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.METHOD, value = "方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.RESULT, value = "结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.SIZE, value = "大小", required = false, dataTypeClass = BigDecimal.class, example = "0.00"),
		@ApiImplicitParam(name = DbBackupLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.SOURCE, value = "原始数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.PROCESSED, value = "处理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.PROCESS_RESULT, value = "处理结果", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = DbBackupLogVOMeta.LAST_PROCESS_TIME, value = "处理时间", required = false, dataTypeClass = Date.class, example = ""), // @ApiImplicitParam(name = DbBackupLogVOMeta.RTIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = ""),
    @ApiImplicitParam(name = DbBackupLogVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = "")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = DbBackupLogServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(DbBackupLogServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<DbBackupLog>> queryPagedList(DbBackupLogVO sample) {
        Result<PagedList<DbBackupLog>> result = new Result<>();
        PagedList<DbBackupLog> list = dbBackupLogService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
