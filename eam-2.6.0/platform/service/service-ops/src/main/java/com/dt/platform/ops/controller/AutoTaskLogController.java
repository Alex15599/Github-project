package com.dt.platform.ops.controller;

import java.util.List;
import java.util.ArrayList;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.proxy.ops.AutoTaskLogServiceProxy;
import com.dt.platform.domain.ops.meta.AutoTaskLogVOMeta;
import com.dt.platform.domain.ops.AutoTaskLog;
import com.dt.platform.domain.ops.AutoTaskLogVO;
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
import com.dt.platform.domain.ops.meta.AutoTaskLogMeta;
import com.dt.platform.domain.ops.AutoTask;
import com.dt.platform.domain.ops.AutoAction;
import com.dt.platform.domain.ops.AutoNode;
import com.dt.platform.domain.ops.AutoTaskMLog;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IAutoTaskLogService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 明细日志 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-24 13:48:41
 */
@Api(tags = "明细日志")
@ApiSort(0)
@RestController("OpsAutoTaskLogController")
public class AutoTaskLogController extends SuperController {

    @Autowired
    private IAutoTaskLogService autoTaskLogService;

    /**
     * 添加明细日志
     */
    @ApiOperation(value = "添加明细日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614532689201987584"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class, example = "614532481739128832"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.M_LOG_ID, value = "日志", required = false, dataTypeClass = String.class, example = "614532688249880576"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class, example = "614531850873864192"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NODE_IP, value = "IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class, example = "614532378768965632"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "failed"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:53:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:58:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.RECORD_CONTENT, value = "记录结果", required = false, dataTypeClass = String.class, example = "Connect to host by sftp error!"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.CONTENT_DETAIL, value = "内容明细", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:53:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AutoTaskLogServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskLogServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AutoTaskLogVO autoTaskLogVO) {
        Result result = autoTaskLogService.insert(autoTaskLogVO, false);
        return result;
    }

    /**
     * 删除明细日志
     */
    @ApiOperation(value = "删除明细日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614532689201987584")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AutoTaskLogServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskLogServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  autoTaskLogService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = autoTaskLogService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除明细日志 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除明细日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskLogVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoTaskLogServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskLogServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = autoTaskLogService.hasRefers(ids);
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
            Result result = autoTaskLogService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = autoTaskLogService.deleteByIdsLogical(canDeleteIds);
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
     * 更新明细日志
     */
    @ApiOperation(value = "更新明细日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614532689201987584"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class, example = "614532481739128832"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.M_LOG_ID, value = "日志", required = false, dataTypeClass = String.class, example = "614532688249880576"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class, example = "614531850873864192"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NODE_IP, value = "IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class, example = "614532378768965632"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "failed"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:53:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:58:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.RECORD_CONTENT, value = "记录结果", required = false, dataTypeClass = String.class, example = "Connect to host by sftp error!"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.CONTENT_DETAIL, value = "内容明细", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:53:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AutoTaskLogVOMeta.PAGE_INDEX, AutoTaskLogVOMeta.PAGE_SIZE, AutoTaskLogVOMeta.SEARCH_FIELD, AutoTaskLogVOMeta.FUZZY_FIELD, AutoTaskLogVOMeta.SEARCH_VALUE, AutoTaskLogVOMeta.DIRTY_FIELDS, AutoTaskLogVOMeta.SORT_FIELD, AutoTaskLogVOMeta.SORT_TYPE, AutoTaskLogVOMeta.IDS })
    @SentinelResource(value = AutoTaskLogServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskLogServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AutoTaskLogVO autoTaskLogVO) {
        Result result = autoTaskLogService.update(autoTaskLogVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存明细日志
     */
    @ApiOperation(value = "保存明细日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614532689201987584"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class, example = "614532481739128832"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.M_LOG_ID, value = "日志", required = false, dataTypeClass = String.class, example = "614532688249880576"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class, example = "614531850873864192"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NODE_IP, value = "IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class, example = "614532378768965632"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "failed"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:53:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:58:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.RECORD_CONTENT, value = "记录结果", required = false, dataTypeClass = String.class, example = "Connect to host by sftp error!"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.CONTENT_DETAIL, value = "内容明细", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:53:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoTaskLogVOMeta.PAGE_INDEX, AutoTaskLogVOMeta.PAGE_SIZE, AutoTaskLogVOMeta.SEARCH_FIELD, AutoTaskLogVOMeta.FUZZY_FIELD, AutoTaskLogVOMeta.SEARCH_VALUE, AutoTaskLogVOMeta.DIRTY_FIELDS, AutoTaskLogVOMeta.SORT_FIELD, AutoTaskLogVOMeta.SORT_TYPE, AutoTaskLogVOMeta.IDS })
    @SentinelResource(value = AutoTaskLogServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskLogServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AutoTaskLogVO autoTaskLogVO) {
        Result result = autoTaskLogService.save(autoTaskLogVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取明细日志
     */
    @ApiOperation(value = "获取明细日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AutoTaskLogServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskLogServiceProxy.GET_BY_ID)
    public Result<AutoTaskLog> getById(String id) {
        Result<AutoTaskLog> result = new Result<>();
        AutoTaskLog autoTaskLog = autoTaskLogService.getById(id);
        // join 关联的对象
        autoTaskLogService.dao().fill(autoTaskLog).with(AutoTaskLogMeta.M_LOG).with(AutoTaskLogMeta.NODE).with(AutoTaskLogMeta.TASK).with(AutoTaskLogMeta.ACTION).execute();
        result.success(true).data(autoTaskLog);
        return result;
    }

    /**
     * 批量获取明细日志 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取明细日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskLogVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoTaskLogServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskLogServiceProxy.GET_BY_IDS)
    public Result<List<AutoTaskLog>> getByIds(List<String> ids) {
        Result<List<AutoTaskLog>> result = new Result<>();
        List<AutoTaskLog> list = autoTaskLogService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询明细日志
     */
    @ApiOperation(value = "查询明细日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614532689201987584"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class, example = "614532481739128832"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.M_LOG_ID, value = "日志", required = false, dataTypeClass = String.class, example = "614532688249880576"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class, example = "614531850873864192"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NODE_IP, value = "IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class, example = "614532378768965632"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "failed"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:53:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:58:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.RECORD_CONTENT, value = "记录结果", required = false, dataTypeClass = String.class, example = "Connect to host by sftp error!"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.CONTENT_DETAIL, value = "内容明细", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:53:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoTaskLogVOMeta.PAGE_INDEX, AutoTaskLogVOMeta.PAGE_SIZE })
    @SentinelResource(value = AutoTaskLogServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskLogServiceProxy.QUERY_LIST)
    public Result<List<AutoTaskLog>> queryList(AutoTaskLogVO sample) {
        Result<List<AutoTaskLog>> result = new Result<>();
        List<AutoTaskLog> list = autoTaskLogService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询明细日志
     */
    @ApiOperation(value = "分页查询明细日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614532689201987584"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class, example = "614532481739128832"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.M_LOG_ID, value = "日志", required = false, dataTypeClass = String.class, example = "614532688249880576"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class, example = "614531850873864192"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NODE_IP, value = "IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class, example = "614532378768965632"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "failed"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.STIME, value = "开始时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:53:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.ETIME, value = "结束时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:58:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.RECORD_CONTENT, value = "记录结果", required = false, dataTypeClass = String.class, example = "Connect to host by sftp error!"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.CONTENT_DETAIL, value = "内容明细", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class, example = "2022-08-23 06:53:31"),
		@ApiImplicitParam(name = AutoTaskLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AutoTaskLogServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskLogServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AutoTaskLog>> queryPagedList(AutoTaskLogVO sample) {
        Result<PagedList<AutoTaskLog>> result = new Result<>();
        PagedList<AutoTaskLog> list = autoTaskLogService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        autoTaskLogService.dao().fill(list).with(AutoTaskLogMeta.M_LOG).with(AutoTaskLogMeta.NODE).with(AutoTaskLogMeta.TASK).with(AutoTaskLogMeta.ACTION).execute();
        result.success(true).data(list);
        return result;
    }
}
