package com.dt.platform.common.controller;

import java.io.*;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.*;

import com.dt.platform.constants.enums.common.BackupStatusEnum;
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
import com.dt.platform.proxy.common.BackupDbServiceProxy;
import com.dt.platform.domain.common.meta.BackupDbVOMeta;
import com.dt.platform.domain.common.BackupDb;
import com.dt.platform.domain.common.BackupDbVO;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.springboot.web.DownloadUtil;
import com.github.foxnic.dao.data.PagedList;

import java.util.Date;

import com.github.foxnic.api.error.ErrorDesc;

import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.dt.platform.common.service.IBackupDbService;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 备份记录接口控制器
 * </p>
 *
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-26 11:21:40
 */
@InDoc
@Api(tags = "备份记录")
@RestController("SysBackupDbController")
public class BackupDbController extends SuperController {

    @Autowired
    private IBackupDbService backupDbService;

    /**
     * 添加备份记录
     */
    @ApiOperation(value = "添加备份记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = BackupDbVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "669147059651084288"),
            @ApiImplicitParam(name = BackupDbVOMeta.DB_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "gg"),
            @ApiImplicitParam(name = BackupDbVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "valid"),
            @ApiImplicitParam(name = BackupDbVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.FILE_ROUTE, value = "备份文件", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.START_TIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = ""),
            @ApiImplicitParam(name = BackupDbVOMeta.END_TIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = ""),
            @ApiImplicitParam(name = BackupDbVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = BigDecimal.class),
            @ApiImplicitParam(name = BackupDbVOMeta.INVALID_TIME, value = "失效日期", required = false, dataTypeClass = Date.class, example = "")
    })
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = BackupDbServiceProxy.INSERT, blockHandlerClass = {SentinelExceptionUtil.class}, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BackupDbServiceProxy.INSERT)
    public Result insert(BackupDbVO backupDbVO) {
        Result result = backupDbService.insert(backupDbVO, false);
        return result;
    }

    /**
     * 删除备份记录
     */
    @ApiOperation(value = "删除备份记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = BackupDbVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "669147059651084288")
    })
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = BackupDbServiceProxy.DELETE, blockHandlerClass = {SentinelExceptionUtil.class}, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BackupDbServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = backupDbService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = backupDbService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除备份记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除备份记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = BackupDbVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
    })
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = BackupDbServiceProxy.DELETE_BY_IDS, blockHandlerClass = {SentinelExceptionUtil.class}, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BackupDbServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = backupDbService.hasRefers(ids);
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
            Result result = backupDbService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = backupDbService.deleteByIdsLogical(canDeleteIds);
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
     * 更新备份记录
     */
    @ApiOperation(value = "更新备份记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = BackupDbVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "669147059651084288"),
            @ApiImplicitParam(name = BackupDbVOMeta.DB_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "gg"),
            @ApiImplicitParam(name = BackupDbVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "valid"),
            @ApiImplicitParam(name = BackupDbVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.FILE_ROUTE, value = "备份文件", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.START_TIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = ""),
            @ApiImplicitParam(name = BackupDbVOMeta.END_TIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = ""),
            @ApiImplicitParam(name = BackupDbVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = BigDecimal.class),
            @ApiImplicitParam(name = BackupDbVOMeta.INVALID_TIME, value = "失效日期", required = false, dataTypeClass = Date.class, example = "")
    })
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = {BackupDbVOMeta.PAGE_INDEX, BackupDbVOMeta.PAGE_SIZE, BackupDbVOMeta.SEARCH_FIELD, BackupDbVOMeta.FUZZY_FIELD, BackupDbVOMeta.SEARCH_VALUE, BackupDbVOMeta.DIRTY_FIELDS, BackupDbVOMeta.SORT_FIELD, BackupDbVOMeta.SORT_TYPE, BackupDbVOMeta.DATA_ORIGIN, BackupDbVOMeta.QUERY_LOGIC, BackupDbVOMeta.IDS})
    @SentinelResource(value = BackupDbServiceProxy.UPDATE, blockHandlerClass = {SentinelExceptionUtil.class}, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BackupDbServiceProxy.UPDATE)
    public Result update(BackupDbVO backupDbVO) {
        Result result = backupDbService.update(backupDbVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存备份记录
     */
    @ApiOperation(value = "保存备份记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = BackupDbVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "669147059651084288"),
            @ApiImplicitParam(name = BackupDbVOMeta.DB_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "gg"),
            @ApiImplicitParam(name = BackupDbVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "valid"),
            @ApiImplicitParam(name = BackupDbVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.FILE_ROUTE, value = "备份文件", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.START_TIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = ""),
            @ApiImplicitParam(name = BackupDbVOMeta.END_TIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = ""),
            @ApiImplicitParam(name = BackupDbVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = BigDecimal.class),
            @ApiImplicitParam(name = BackupDbVOMeta.INVALID_TIME, value = "失效日期", required = false, dataTypeClass = Date.class, example = "")
    })
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = {BackupDbVOMeta.PAGE_INDEX, BackupDbVOMeta.PAGE_SIZE, BackupDbVOMeta.SEARCH_FIELD, BackupDbVOMeta.FUZZY_FIELD, BackupDbVOMeta.SEARCH_VALUE, BackupDbVOMeta.DIRTY_FIELDS, BackupDbVOMeta.SORT_FIELD, BackupDbVOMeta.SORT_TYPE, BackupDbVOMeta.DATA_ORIGIN, BackupDbVOMeta.QUERY_LOGIC, BackupDbVOMeta.IDS})
    @SentinelResource(value = BackupDbServiceProxy.SAVE, blockHandlerClass = {SentinelExceptionUtil.class}, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BackupDbServiceProxy.SAVE)
    public Result save(BackupDbVO backupDbVO) {
        Result result = backupDbService.save(backupDbVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取备份记录
     */
    @ApiOperation(value = "获取备份记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = BackupDbVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
    })
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = BackupDbServiceProxy.GET_BY_ID, blockHandlerClass = {SentinelExceptionUtil.class}, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BackupDbServiceProxy.GET_BY_ID)
    public Result<BackupDb> getById(String id) {
        Result<BackupDb> result = new Result<>();
        BackupDb backupDb = backupDbService.getById(id);
        // join 关联的对象
        result.success(true).data(backupDb);
        //   backupDbService.executeBackup();
        return result;
    }

    /**
     * 执行备份记录
     */
    @ApiOperation(value = "执行备份记录")
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = BackupDbServiceProxy.EXECUTE_BACKUP, blockHandlerClass = {SentinelExceptionUtil.class}, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BackupDbServiceProxy.EXECUTE_BACKUP)
    public Result executeBackup() {
        return backupDbService.executeBackup();
    }


    /**
     * 批量获取备份记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取备份记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = BackupDbVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
    })
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = BackupDbServiceProxy.GET_BY_IDS, blockHandlerClass = {SentinelExceptionUtil.class}, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BackupDbServiceProxy.GET_BY_IDS)
    public Result<List<BackupDb>> getByIds(List<String> ids) {
        Result<List<BackupDb>> result = new Result<>();
        List<BackupDb> list = backupDbService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询备份记录
     */
    @ApiOperation(value = "查询备份记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = BackupDbVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "669147059651084288"),
            @ApiImplicitParam(name = BackupDbVOMeta.DB_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "gg"),
            @ApiImplicitParam(name = BackupDbVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "valid"),
            @ApiImplicitParam(name = BackupDbVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.FILE_ROUTE, value = "备份文件", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.START_TIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = ""),
            @ApiImplicitParam(name = BackupDbVOMeta.END_TIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = ""),
            @ApiImplicitParam(name = BackupDbVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = BigDecimal.class),
            @ApiImplicitParam(name = BackupDbVOMeta.INVALID_TIME, value = "失效日期", required = false, dataTypeClass = Date.class, example = "")
    })
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = {BackupDbVOMeta.PAGE_INDEX, BackupDbVOMeta.PAGE_SIZE})
    @SentinelResource(value = BackupDbServiceProxy.QUERY_LIST, blockHandlerClass = {SentinelExceptionUtil.class}, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BackupDbServiceProxy.QUERY_LIST)
    public Result<List<BackupDb>> queryList(BackupDbVO sample) {
        Result<List<BackupDb>> result = new Result<>();
        List<BackupDb> list = backupDbService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询备份记录
     */
    @ApiOperation(value = "分页查询备份记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = BackupDbVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "669147059651084288"),
            @ApiImplicitParam(name = BackupDbVOMeta.DB_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "gg"),
            @ApiImplicitParam(name = BackupDbVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "valid"),
            @ApiImplicitParam(name = BackupDbVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.FILE_ROUTE, value = "备份文件", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.START_TIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = ""),
            @ApiImplicitParam(name = BackupDbVOMeta.END_TIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = ""),
            @ApiImplicitParam(name = BackupDbVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = BackupDbVOMeta.FILE_SIZE, value = "大小", required = false, dataTypeClass = BigDecimal.class),
            @ApiImplicitParam(name = BackupDbVOMeta.INVALID_TIME, value = "失效日期", required = false, dataTypeClass = Date.class, example = "")
    })
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = BackupDbServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = {SentinelExceptionUtil.class}, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BackupDbServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<BackupDb>> queryPagedList(BackupDbVO sample) {
        Result<PagedList<BackupDb>> result = new Result<>();
        PagedList<BackupDb> list = backupDbService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        result.success(true).data(list);
        return result;
    }

    /**
     * 获取备份记录
     */
    @ApiOperation(value = "获取备份记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = BackupDbVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
    })
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = BackupDbServiceProxy.DOWN_FILE, blockHandlerClass = {SentinelExceptionUtil.class}, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BackupDbServiceProxy.DOWN_FILE)
    public Result downFile(HttpServletResponse response, String id) {
        BackupDb rec = backupDbService.getById(id);
        if (rec == null) {
            return ErrorDesc.failureMessage("备份文件不存在");
        }
        if (!BackupStatusEnum.VALID.code().equals(rec.getStatus())) {
            return ErrorDesc.failureMessage("当前备份文件无效");
        }
        String filepath = rec.getFileRoute();
        File file = new File(filepath);
        try {
            if (file.exists()) {
                response.setHeader("content-type", "application/octet-stream");
                // response.setContentType("application/zip");
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("备份文件.zip", "UTF-8"))));
                DownloadUtil.writeDownloadSuccess(response);
                // 以流的形式下载文件。
                InputStream fis = new BufferedInputStream(new FileInputStream(filepath));
                byte[] buffer = new byte[0];
                buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                // 清空response
              //  response.reset();
                // 设置response的Header
                response.addHeader("Content-Length", "" + file.length());
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());

                toClient.write(buffer);
                toClient.flush();
                toClient.close();
            } else {
                return ErrorDesc.failureMessage("文件不存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        DownloadUtil.writeDownloadSuccess(response);
        return ErrorDesc.success();
    }

}
