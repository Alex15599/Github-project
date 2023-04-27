package com.dt.platform.ops.controller;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.ops.*;
import com.github.foxnic.commons.busi.id.IDGenerator;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.apache.commons.io.IOUtils;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.proxy.ops.AutoTaskMLogServiceProxy;
import com.dt.platform.domain.ops.meta.AutoTaskMLogVOMeta;
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
import com.dt.platform.domain.ops.meta.AutoTaskMLogMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IAutoTaskMLogService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 执行日志 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 08:16:56
 */
@Api(tags = "执行日志")
@ApiSort(0)
@RestController("OpsAutoTaskMLogController")
public class AutoTaskMLogController extends SuperController {

    @Autowired
    private IAutoTaskMLogService autoTaskMLogService;

    /**
     * 添加执行日志
     */
    @ApiOperation(value = "添加执行日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AutoTaskMLogServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskMLogServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AutoTaskMLogVO autoTaskMLogVO) {
        Result result = autoTaskMLogService.insert(autoTaskMLogVO, false);
        return result;
    }

    /**
     * 删除执行日志
     */
    @ApiOperation(value = "删除执行日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "12")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AutoTaskMLogServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskMLogServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  autoTaskMLogService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = autoTaskMLogService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除执行日志 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除执行日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoTaskMLogServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskMLogServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = autoTaskMLogService.hasRefers(ids);
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
            Result result = autoTaskMLogService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = autoTaskMLogService.deleteByIdsLogical(canDeleteIds);
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
     * 更新执行日志
     */
    @ApiOperation(value = "更新执行日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AutoTaskMLogVOMeta.PAGE_INDEX, AutoTaskMLogVOMeta.PAGE_SIZE, AutoTaskMLogVOMeta.SEARCH_FIELD, AutoTaskMLogVOMeta.FUZZY_FIELD, AutoTaskMLogVOMeta.SEARCH_VALUE, AutoTaskMLogVOMeta.DIRTY_FIELDS, AutoTaskMLogVOMeta.SORT_FIELD, AutoTaskMLogVOMeta.SORT_TYPE, AutoTaskMLogVOMeta.IDS })
    @SentinelResource(value = AutoTaskMLogServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskMLogServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AutoTaskMLogVO autoTaskMLogVO) {
        Result result = autoTaskMLogService.update(autoTaskMLogVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存执行日志
     */
    @ApiOperation(value = "保存执行日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoTaskMLogVOMeta.PAGE_INDEX, AutoTaskMLogVOMeta.PAGE_SIZE, AutoTaskMLogVOMeta.SEARCH_FIELD, AutoTaskMLogVOMeta.FUZZY_FIELD, AutoTaskMLogVOMeta.SEARCH_VALUE, AutoTaskMLogVOMeta.DIRTY_FIELDS, AutoTaskMLogVOMeta.SORT_FIELD, AutoTaskMLogVOMeta.SORT_TYPE, AutoTaskMLogVOMeta.IDS })
    @SentinelResource(value = AutoTaskMLogServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskMLogServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AutoTaskMLogVO autoTaskMLogVO) {
        Result result = autoTaskMLogService.save(autoTaskMLogVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取执行日志
     */
    @ApiOperation(value = "获取执行日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AutoTaskMLogServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskMLogServiceProxy.GET_BY_ID)
    public Result<AutoTaskMLog> getById(String id) {
        Result<AutoTaskMLog> result = new Result<>();
        AutoTaskMLog autoTaskMLog = autoTaskMLogService.getById(id);
        // join 关联的对象
        autoTaskMLogService.dao().fill(autoTaskMLog).with(AutoTaskMLogMeta.TASK).with(AutoTaskMLogMeta.ACTION).execute();
        result.success(true).data(autoTaskMLog);
        return result;
    }

    /**
     * 批量获取执行日志 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取执行日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoTaskMLogServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskMLogServiceProxy.GET_BY_IDS)
    public Result<List<AutoTaskMLog>> getByIds(List<String> ids) {
        Result<List<AutoTaskMLog>> result = new Result<>();
        List<AutoTaskMLog> list = autoTaskMLogService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询执行日志
     */
    @ApiOperation(value = "查询执行日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoTaskMLogVOMeta.PAGE_INDEX, AutoTaskMLogVOMeta.PAGE_SIZE })
    @SentinelResource(value = AutoTaskMLogServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskMLogServiceProxy.QUERY_LIST)
    public Result<List<AutoTaskMLog>> queryList(AutoTaskMLogVO sample) {
        Result<List<AutoTaskMLog>> result = new Result<>();
        List<AutoTaskMLog> list = autoTaskMLogService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询执行日志
     */
    @ApiOperation(value = "分页查询执行日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AutoTaskMLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AutoTaskMLogServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskMLogServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AutoTaskMLog>> queryPagedList(AutoTaskMLogVO sample) {
        Result<PagedList<AutoTaskMLog>> result = new Result<>();
        PagedList<AutoTaskMLog> list = autoTaskMLogService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        autoTaskMLogService.dao().fill(list).with(AutoTaskMLogMeta.TASK).with(AutoTaskMLogMeta.ACTION).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 下载日志
     */
    @ApiOperation(value = "下载日志")
    @ApiImplicitParams({})
    @ApiOperationSupport(order = 9)
    @SentinelResource(value = AutoTaskMLogServiceProxy.LOG_DOWNLOAD, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskMLogServiceProxy.LOG_DOWNLOAD)
    public void queryPagedList(HttpServletRequest request, HttpServletResponse response, String id) {
        AutoTaskMLog log = autoTaskMLogService.logDownload(id);
        if (log != null) {
            StringBuffer logTxt = new StringBuffer();
            logTxt.append("---------任务批次:" + log.getTaskId() + "----------\n");
            logTxt.append("任务状态:" + log.getStatus() + "\n");
            logTxt.append("开始时间:" + log.getStime() + "\n");
            logTxt.append("结束时间:" + log.getEtime() + "\n");
            logTxt.append(log.getContent() + "\n");
            logTxt.append("\n\n");
            logTxt.append("---------开始打印节点日志----------\n");
            List<AutoTaskLog> listLog = log.getLogList();
            if (listLog != null) {
                for (int i = 0; i < listLog.size(); i++) {
                    logTxt.append("---------节点日志开始----------\n");
                    logTxt.append("节点Ip:" + listLog.get(i).getNodeIp() + "\n");
                    logTxt.append("节点状态:" + listLog.get(i).getStatus() + "\n");
                    logTxt.append("节点日志:\n" + listLog.get(i).getContentDetail() + "\n");
                    logTxt.append("\n\n");
                    logTxt.append("---------节点日志结束----------");
                    logTxt.append("\n\n\n");
                }
            }
            logTxt.append("---------任务批次结束----------");
            logTxt.append("\n\n\n\n");
            try {
                InputStream inputstream = IOUtils.toInputStream(logTxt.toString(), StandardCharsets.UTF_8.name());
                response.setCharacterEncoding("UTF-8");
                response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("日志.txt", "UTF-8"))));
                response.setContentType("application/octet-stream");
                OutputStream out = response.getOutputStream();
                IOUtils.copy(inputstream, out);
                out.flush();
            } catch (Exception e) {
                try {
                    DownloadUtil.writeDownloadError(response, e);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
