package com.dt.platform.common.controller;

import java.io.*;
import java.util.*;
import com.dt.platform.constants.enums.common.CollectStatusEnum;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.Insert;
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
import com.dt.platform.proxy.common.LogCollectServiceProxy;
import com.dt.platform.domain.common.meta.LogCollectVOMeta;
import com.dt.platform.domain.common.LogCollect;
import com.dt.platform.domain.common.LogCollectVO;
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
import com.dt.platform.domain.common.meta.LogCollectMeta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.ILogCollectService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 日志收集接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-17 10:53:57
 */
@InDoc
@Api(tags = "日志收集")
@RestController("SysLogCollectController")
public class LogCollectController extends SuperController {

    @Autowired
    private ILogCollectService logCollectService;

    /**
     * 添加日志收集
     */
    @ApiOperation(value = "添加日志收集")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LogCollectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.COLLECT_RANGE, value = "范围", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = LogCollectServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LogCollectServiceProxy.INSERT)
    public Result insert(LogCollectVO logCollectVO) {
        Result result = logCollectService.insert(logCollectVO, false);
        return result;
    }

    /**
     * 删除日志收集
     */
    @ApiOperation(value = "删除日志收集")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LogCollectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = LogCollectServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LogCollectServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = logCollectService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = logCollectService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除日志收集 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除日志收集")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LogCollectVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = LogCollectServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LogCollectServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = logCollectService.hasRefers(ids);
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
            Result result = logCollectService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = logCollectService.deleteByIdsLogical(canDeleteIds);
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
     * 更新日志收集
     */
    @ApiOperation(value = "更新日志收集")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LogCollectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.COLLECT_RANGE, value = "范围", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { LogCollectVOMeta.PAGE_INDEX, LogCollectVOMeta.PAGE_SIZE, LogCollectVOMeta.SEARCH_FIELD, LogCollectVOMeta.FUZZY_FIELD, LogCollectVOMeta.SEARCH_VALUE, LogCollectVOMeta.DIRTY_FIELDS, LogCollectVOMeta.SORT_FIELD, LogCollectVOMeta.SORT_TYPE, LogCollectVOMeta.DATA_ORIGIN, LogCollectVOMeta.QUERY_LOGIC, LogCollectVOMeta.REQUEST_ACTION, LogCollectVOMeta.IDS })
    @SentinelResource(value = LogCollectServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LogCollectServiceProxy.UPDATE)
    public Result update(LogCollectVO logCollectVO) {
        Result result = logCollectService.update(logCollectVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 收集日志
     */
    @ApiOperation(value = "收集日志")
    @SentinelResource(value = LogCollectServiceProxy.COLLECT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LogCollectServiceProxy.COLLECT)
    public Result collect() {
        String fileId= IDGenerator.getSnowflakeIdString();
        LogCollect log = new LogCollect();
        log.setCollectRange("应用系统日志收集");
        log.setStatus(CollectStatusEnum.VALID.code());
        log.setFileId(fileId);
        try {
            File directory = new File("");
            System.out.println(directory.getCanonicalPath());//获取标准的路径
            System.out.println("开始进行收集执行,当前路径:"+directory.getCanonicalPath());
            //cd /app/app/app/app
            Process process=Runtime.getRuntime().exec("sh ./../../bin/collectLog.sh "+fileId);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream())); //虽然cmd命令可以直接输出，但是通过IO流技术可以保证对数据进行一个缓冲。
            System.out.println("执行该编译");
            String msg = null;
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
            }
            Insert ins=new Insert("sys_file");
            ins.set("id",fileId);
            ins.set("file_name","日志.tar.gz");
            ins.set("location","/collect/log/"+fileId+".tar.gz");
            ins.set("media_type","application/octet-stream");
            ins.set("file_type","gz");
            ins.set("size","1000");
            logCollectService.dao().execute(ins);
        }
        catch (IOException e) {
            e.printStackTrace();
            return ErrorDesc.failureMessage("收集失败,"+e.getMessage());
        }
        return logCollectService.insert(log);
    }

    /**
     * 保存日志收集
     */
    @ApiOperation(value = "保存日志收集")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LogCollectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.COLLECT_RANGE, value = "范围", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { LogCollectVOMeta.PAGE_INDEX, LogCollectVOMeta.PAGE_SIZE, LogCollectVOMeta.SEARCH_FIELD, LogCollectVOMeta.FUZZY_FIELD, LogCollectVOMeta.SEARCH_VALUE, LogCollectVOMeta.DIRTY_FIELDS, LogCollectVOMeta.SORT_FIELD, LogCollectVOMeta.SORT_TYPE, LogCollectVOMeta.DATA_ORIGIN, LogCollectVOMeta.QUERY_LOGIC, LogCollectVOMeta.REQUEST_ACTION, LogCollectVOMeta.IDS })
    @SentinelResource(value = LogCollectServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LogCollectServiceProxy.SAVE)
    public Result save(LogCollectVO logCollectVO) {
        Result result = logCollectService.save(logCollectVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取日志收集
     */
    @ApiOperation(value = "获取日志收集")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LogCollectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = LogCollectServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LogCollectServiceProxy.GET_BY_ID)
    public Result<LogCollect> getById(String id) {
        Result<LogCollect> result = new Result<>();
        LogCollect logCollect = logCollectService.getById(id);
        result.success(true).data(logCollect);
        return result;
    }

    /**
     * 批量获取日志收集 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取日志收集")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LogCollectVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = LogCollectServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LogCollectServiceProxy.GET_BY_IDS)
    public Result<List<LogCollect>> getByIds(List<String> ids) {
        Result<List<LogCollect>> result = new Result<>();
        List<LogCollect> list = logCollectService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询日志收集
     */
    @ApiOperation(value = "查询日志收集")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LogCollectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.COLLECT_RANGE, value = "范围", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { LogCollectVOMeta.PAGE_INDEX, LogCollectVOMeta.PAGE_SIZE })
    @SentinelResource(value = LogCollectServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LogCollectServiceProxy.QUERY_LIST)
    public Result<List<LogCollect>> queryList(LogCollectVO sample) {
        Result<List<LogCollect>> result = new Result<>();
        List<LogCollect> list = logCollectService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询日志收集
     */
    @ApiOperation(value = "分页查询日志收集")
    @ApiImplicitParams({
		@ApiImplicitParam(name = LogCollectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = LogCollectVOMeta.COLLECT_RANGE, value = "范围", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = LogCollectServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(LogCollectServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<LogCollect>> queryPagedList(LogCollectVO sample) {
        Result<PagedList<LogCollect>> result = new Result<>();
        PagedList<LogCollect> list = logCollectService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
