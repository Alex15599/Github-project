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
import com.dt.platform.proxy.ops.MonitorTplIndicatorServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorTplIndicatorVOMeta;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.dt.platform.domain.ops.MonitorTplIndicatorVO;
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
import com.dt.platform.domain.ops.meta.MonitorTplIndicatorMeta;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplIndicatorType;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorTplIndicatorService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 模版指标 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-14 16:33:31
 */
@Api(tags = "模版指标")
@ApiSort(0)
@RestController("OpsMonitorTplIndicatorController")
public class MonitorTplIndicatorController extends SuperController {

    @Autowired
    private IMonitorTplIndicatorService monitorTplIndicatorService;

    /**
     * 添加模版指标
     */
    @ApiOperation(value = "添加模版指标")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "100"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "系统负载"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "os.load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class, example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.MONITOR_METHOD, value = "监控方式", required = false, dataTypeClass = String.class, example = "script"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INDICATOR_TYPE, value = "指标类型", required = false, dataTypeClass = String.class, example = "system"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_ROWS, value = "值行数", required = false, dataTypeClass = String.class, example = "single"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_COLS, value = "值列数", required = false, dataTypeClass = String.class, example = "single"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_TYPE, value = "数值类型", required = false, dataTypeClass = String.class, example = "number"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN, value = "数值字段", required = false, dataTypeClass = String.class, example = "os_load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_MAP, value = "数值字段映射", required = false, dataTypeClass = String.class, example = "os_load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_NAME, value = "字段名称", required = false, dataTypeClass = String.class, example = "系统负载"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.TIME_OUT, value = "超时(秒)", required = false, dataTypeClass = Integer.class, example = "15"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INTERVAL_TIME, value = "间隔时间(秒）", required = false, dataTypeClass = Integer.class, example = "180"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.DATA_KEEP_DAY, value = "数据保留天数", required = false, dataTypeClass = Integer.class, example = "365"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.COMMAND, value = "命令", required = false, dataTypeClass = String.class, example = "uptime|awk -F \":\" '{print $NF}'|awk -F \",\" '{print $1}'"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.COMMAND_VALUE, value = "命令值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INDICATOR_VARIABLE, value = "变量", required = false, dataTypeClass = String.class, example = "[]"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.SNMP_OID, value = "snmp元数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.ITEM_SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "800"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "系统负载")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MonitorTplIndicatorServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(MonitorTplIndicatorVO monitorTplIndicatorVO) {
        Result result = monitorTplIndicatorService.insert(monitorTplIndicatorVO, false);
        return result;
    }

    /**
     * 删除模版指标
     */
    @ApiOperation(value = "删除模版指标")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "100")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MonitorTplIndicatorServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  monitorTplIndicatorService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = monitorTplIndicatorService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除模版指标 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除模版指标")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorTplIndicatorServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorTplIndicatorService.hasRefers(ids);
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
            Result result = monitorTplIndicatorService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorTplIndicatorService.deleteByIdsLogical(canDeleteIds);
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
     * 更新模版指标
     */
    @ApiOperation(value = "更新模版指标")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "100"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "系统负载"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "os.load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class, example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.MONITOR_METHOD, value = "监控方式", required = false, dataTypeClass = String.class, example = "script"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INDICATOR_TYPE, value = "指标类型", required = false, dataTypeClass = String.class, example = "system"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_ROWS, value = "值行数", required = false, dataTypeClass = String.class, example = "single"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_COLS, value = "值列数", required = false, dataTypeClass = String.class, example = "single"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_TYPE, value = "数值类型", required = false, dataTypeClass = String.class, example = "number"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN, value = "数值字段", required = false, dataTypeClass = String.class, example = "os_load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_MAP, value = "数值字段映射", required = false, dataTypeClass = String.class, example = "os_load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_NAME, value = "字段名称", required = false, dataTypeClass = String.class, example = "系统负载"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.TIME_OUT, value = "超时(秒)", required = false, dataTypeClass = Integer.class, example = "15"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INTERVAL_TIME, value = "间隔时间(秒）", required = false, dataTypeClass = Integer.class, example = "180"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.DATA_KEEP_DAY, value = "数据保留天数", required = false, dataTypeClass = Integer.class, example = "365"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.COMMAND, value = "命令", required = false, dataTypeClass = String.class, example = "uptime|awk -F \":\" '{print $NF}'|awk -F \",\" '{print $1}'"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.COMMAND_VALUE, value = "命令值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INDICATOR_VARIABLE, value = "变量", required = false, dataTypeClass = String.class, example = "[]"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.SNMP_OID, value = "snmp元数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.ITEM_SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "800"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "系统负载")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { MonitorTplIndicatorVOMeta.PAGE_INDEX, MonitorTplIndicatorVOMeta.PAGE_SIZE, MonitorTplIndicatorVOMeta.SEARCH_FIELD, MonitorTplIndicatorVOMeta.FUZZY_FIELD, MonitorTplIndicatorVOMeta.SEARCH_VALUE, MonitorTplIndicatorVOMeta.DIRTY_FIELDS, MonitorTplIndicatorVOMeta.SORT_FIELD, MonitorTplIndicatorVOMeta.SORT_TYPE, MonitorTplIndicatorVOMeta.IDS })
    @SentinelResource(value = MonitorTplIndicatorServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(MonitorTplIndicatorVO monitorTplIndicatorVO) {
        Result result = monitorTplIndicatorService.update(monitorTplIndicatorVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存模版指标
     */
    @ApiOperation(value = "保存模版指标")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "100"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "系统负载"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "os.load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class, example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.MONITOR_METHOD, value = "监控方式", required = false, dataTypeClass = String.class, example = "script"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INDICATOR_TYPE, value = "指标类型", required = false, dataTypeClass = String.class, example = "system"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_ROWS, value = "值行数", required = false, dataTypeClass = String.class, example = "single"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_COLS, value = "值列数", required = false, dataTypeClass = String.class, example = "single"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_TYPE, value = "数值类型", required = false, dataTypeClass = String.class, example = "number"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN, value = "数值字段", required = false, dataTypeClass = String.class, example = "os_load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_MAP, value = "数值字段映射", required = false, dataTypeClass = String.class, example = "os_load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_NAME, value = "字段名称", required = false, dataTypeClass = String.class, example = "系统负载"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.TIME_OUT, value = "超时(秒)", required = false, dataTypeClass = Integer.class, example = "15"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INTERVAL_TIME, value = "间隔时间(秒）", required = false, dataTypeClass = Integer.class, example = "180"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.DATA_KEEP_DAY, value = "数据保留天数", required = false, dataTypeClass = Integer.class, example = "365"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.COMMAND, value = "命令", required = false, dataTypeClass = String.class, example = "uptime|awk -F \":\" '{print $NF}'|awk -F \",\" '{print $1}'"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.COMMAND_VALUE, value = "命令值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INDICATOR_VARIABLE, value = "变量", required = false, dataTypeClass = String.class, example = "[]"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.SNMP_OID, value = "snmp元数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.ITEM_SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "800"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "系统负载")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorTplIndicatorVOMeta.PAGE_INDEX, MonitorTplIndicatorVOMeta.PAGE_SIZE, MonitorTplIndicatorVOMeta.SEARCH_FIELD, MonitorTplIndicatorVOMeta.FUZZY_FIELD, MonitorTplIndicatorVOMeta.SEARCH_VALUE, MonitorTplIndicatorVOMeta.DIRTY_FIELDS, MonitorTplIndicatorVOMeta.SORT_FIELD, MonitorTplIndicatorVOMeta.SORT_TYPE, MonitorTplIndicatorVOMeta.IDS })
    @SentinelResource(value = MonitorTplIndicatorServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(MonitorTplIndicatorVO monitorTplIndicatorVO) {
        Result result = monitorTplIndicatorService.save(monitorTplIndicatorVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取模版指标
     */
    @ApiOperation(value = "获取模版指标")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MonitorTplIndicatorServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorServiceProxy.GET_BY_ID)
    public Result<MonitorTplIndicator> getById(String id) {
        Result<MonitorTplIndicator> result = new Result<>();
        MonitorTplIndicator monitorTplIndicator = monitorTplIndicatorService.getById(id);
        // join 关联的对象
        monitorTplIndicatorService.dao().fill(monitorTplIndicator).with(MonitorTplIndicatorMeta.TPL).with(MonitorTplIndicatorMeta.MONITOR_INDICATOR_TYPE).execute();
        result.success(true).data(monitorTplIndicator);
        return result;
    }

    /**
     * 批量获取模版指标 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取模版指标")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorTplIndicatorServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorServiceProxy.GET_BY_IDS)
    public Result<List<MonitorTplIndicator>> getByIds(List<String> ids) {
        Result<List<MonitorTplIndicator>> result = new Result<>();
        List<MonitorTplIndicator> list = monitorTplIndicatorService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询模版指标
     */
    @ApiOperation(value = "查询模版指标")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "100"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "系统负载"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "os.load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class, example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.MONITOR_METHOD, value = "监控方式", required = false, dataTypeClass = String.class, example = "script"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INDICATOR_TYPE, value = "指标类型", required = false, dataTypeClass = String.class, example = "system"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_ROWS, value = "值行数", required = false, dataTypeClass = String.class, example = "single"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_COLS, value = "值列数", required = false, dataTypeClass = String.class, example = "single"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_TYPE, value = "数值类型", required = false, dataTypeClass = String.class, example = "number"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN, value = "数值字段", required = false, dataTypeClass = String.class, example = "os_load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_MAP, value = "数值字段映射", required = false, dataTypeClass = String.class, example = "os_load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_NAME, value = "字段名称", required = false, dataTypeClass = String.class, example = "系统负载"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.TIME_OUT, value = "超时(秒)", required = false, dataTypeClass = Integer.class, example = "15"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INTERVAL_TIME, value = "间隔时间(秒）", required = false, dataTypeClass = Integer.class, example = "180"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.DATA_KEEP_DAY, value = "数据保留天数", required = false, dataTypeClass = Integer.class, example = "365"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.COMMAND, value = "命令", required = false, dataTypeClass = String.class, example = "uptime|awk -F \":\" '{print $NF}'|awk -F \",\" '{print $1}'"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.COMMAND_VALUE, value = "命令值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INDICATOR_VARIABLE, value = "变量", required = false, dataTypeClass = String.class, example = "[]"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.SNMP_OID, value = "snmp元数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.ITEM_SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "800"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "系统负载")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorTplIndicatorVOMeta.PAGE_INDEX, MonitorTplIndicatorVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorTplIndicatorServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorServiceProxy.QUERY_LIST)
    public Result<List<MonitorTplIndicator>> queryList(MonitorTplIndicatorVO sample) {
        Result<List<MonitorTplIndicator>> result = new Result<>();
        List<MonitorTplIndicator> list = monitorTplIndicatorService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询模版指标
     */
    @ApiOperation(value = "分页查询模版指标")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "100"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "系统负载"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "os.load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.MONITOR_TPL_CODE, value = "监控模版", required = false, dataTypeClass = String.class, example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.MONITOR_METHOD, value = "监控方式", required = false, dataTypeClass = String.class, example = "script"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INDICATOR_TYPE, value = "指标类型", required = false, dataTypeClass = String.class, example = "system"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_ROWS, value = "值行数", required = false, dataTypeClass = String.class, example = "single"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_COLS, value = "值列数", required = false, dataTypeClass = String.class, example = "single"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_TYPE, value = "数值类型", required = false, dataTypeClass = String.class, example = "number"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN, value = "数值字段", required = false, dataTypeClass = String.class, example = "os_load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_MAP, value = "数值字段映射", required = false, dataTypeClass = String.class, example = "os_load"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.VALUE_COLUMN_NAME, value = "字段名称", required = false, dataTypeClass = String.class, example = "系统负载"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.TIME_OUT, value = "超时(秒)", required = false, dataTypeClass = Integer.class, example = "15"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INTERVAL_TIME, value = "间隔时间(秒）", required = false, dataTypeClass = Integer.class, example = "180"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.DATA_KEEP_DAY, value = "数据保留天数", required = false, dataTypeClass = Integer.class, example = "365"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.COMMAND, value = "命令", required = false, dataTypeClass = String.class, example = "uptime|awk -F \":\" '{print $NF}'|awk -F \",\" '{print $1}'"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.COMMAND_VALUE, value = "命令值", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.INDICATOR_VARIABLE, value = "变量", required = false, dataTypeClass = String.class, example = "[]"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.SNMP_OID, value = "snmp元数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.ITEM_SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "800"),
		@ApiImplicitParam(name = MonitorTplIndicatorVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "系统负载")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MonitorTplIndicatorServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorTplIndicator>> queryPagedList(MonitorTplIndicatorVO sample) {
        Result<PagedList<MonitorTplIndicator>> result = new Result<>();
        PagedList<MonitorTplIndicator> list = monitorTplIndicatorService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        monitorTplIndicatorService.dao().fill(list).with(MonitorTplIndicatorMeta.TPL).with(MonitorTplIndicatorMeta.MONITOR_INDICATOR_TYPE).execute();
        result.success(true).data(list);
        return result;
    }
}
