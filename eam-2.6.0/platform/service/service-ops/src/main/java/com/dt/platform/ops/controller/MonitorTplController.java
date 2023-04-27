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
import com.dt.platform.proxy.ops.MonitorTplServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorTplVOMeta;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplVO;
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
import com.dt.platform.domain.ops.meta.MonitorTplMeta;
import com.dt.platform.domain.ops.MonitorTplType;
import com.dt.platform.domain.ops.MonitorTplIndicator;
import com.dt.platform.domain.ops.MonitorTplGraph;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorTplService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 监控模版 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-14 16:26:06
 */
@Api(tags = "监控模版")
@ApiSort(0)
@RestController("OpsMonitorTplController")
public class MonitorTplController extends SuperController {

    @Autowired
    private IMonitorTplService monitorTplService;

    /**
     * 添加监控模版
     */
    @ApiOperation(value = "添加监控模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Linux监控zabbix模版"),
		@ApiImplicitParam(name = MonitorTplVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "tpl_host_linux_zabbix"),
		@ApiImplicitParam(name = MonitorTplVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "Linux主机监控模版")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MonitorTplServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(MonitorTplVO monitorTplVO) {
        Result result = monitorTplService.insert(monitorTplVO, false);
        return result;
    }

    /**
     * 删除监控模版
     */
    @ApiOperation(value = "删除监控模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MonitorTplServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  monitorTplService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = monitorTplService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除监控模版 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除监控模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorTplServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorTplService.hasRefers(ids);
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
            Result result = monitorTplService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorTplService.deleteByIdsLogical(canDeleteIds);
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
     * 更新监控模版
     */
    @ApiOperation(value = "更新监控模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Linux监控zabbix模版"),
		@ApiImplicitParam(name = MonitorTplVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "tpl_host_linux_zabbix"),
		@ApiImplicitParam(name = MonitorTplVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "Linux主机监控模版")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { MonitorTplVOMeta.PAGE_INDEX, MonitorTplVOMeta.PAGE_SIZE, MonitorTplVOMeta.SEARCH_FIELD, MonitorTplVOMeta.FUZZY_FIELD, MonitorTplVOMeta.SEARCH_VALUE, MonitorTplVOMeta.DIRTY_FIELDS, MonitorTplVOMeta.SORT_FIELD, MonitorTplVOMeta.SORT_TYPE, MonitorTplVOMeta.IDS })
    @SentinelResource(value = MonitorTplServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(MonitorTplVO monitorTplVO) {
        Result result = monitorTplService.update(monitorTplVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存监控模版
     */
    @ApiOperation(value = "保存监控模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Linux监控zabbix模版"),
		@ApiImplicitParam(name = MonitorTplVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "tpl_host_linux_zabbix"),
		@ApiImplicitParam(name = MonitorTplVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "Linux主机监控模版")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorTplVOMeta.PAGE_INDEX, MonitorTplVOMeta.PAGE_SIZE, MonitorTplVOMeta.SEARCH_FIELD, MonitorTplVOMeta.FUZZY_FIELD, MonitorTplVOMeta.SEARCH_VALUE, MonitorTplVOMeta.DIRTY_FIELDS, MonitorTplVOMeta.SORT_FIELD, MonitorTplVOMeta.SORT_TYPE, MonitorTplVOMeta.IDS })
    @SentinelResource(value = MonitorTplServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(MonitorTplVO monitorTplVO) {
        Result result = monitorTplService.save(monitorTplVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取监控模版
     */
    @ApiOperation(value = "获取监控模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MonitorTplServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplServiceProxy.GET_BY_ID)
    public Result<MonitorTpl> getById(String id) {
        Result<MonitorTpl> result = new Result<>();
        MonitorTpl monitorTpl = monitorTplService.getById(id);
        // join 关联的对象
        monitorTplService.dao().fill(monitorTpl).with(MonitorTplMeta.TPL_TYPE).execute();
        result.success(true).data(monitorTpl);
        return result;
    }

    /**
     * 批量获取监控模版 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取监控模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorTplServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplServiceProxy.GET_BY_IDS)
    public Result<List<MonitorTpl>> getByIds(List<String> ids) {
        Result<List<MonitorTpl>> result = new Result<>();
        List<MonitorTpl> list = monitorTplService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询监控模版
     */
    @ApiOperation(value = "查询监控模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Linux监控zabbix模版"),
		@ApiImplicitParam(name = MonitorTplVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "tpl_host_linux_zabbix"),
		@ApiImplicitParam(name = MonitorTplVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "Linux主机监控模版")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorTplVOMeta.PAGE_INDEX, MonitorTplVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorTplServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplServiceProxy.QUERY_LIST)
    public Result<List<MonitorTpl>> queryList(MonitorTplVO sample) {
        Result<List<MonitorTpl>> result = new Result<>();
        List<MonitorTpl> list = monitorTplService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询监控模版
     */
    @ApiOperation(value = "分页查询监控模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Linux监控zabbix模版"),
		@ApiImplicitParam(name = MonitorTplVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "tpl_host_linux_zabbix"),
		@ApiImplicitParam(name = MonitorTplVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplVOMeta.TYPE, value = "分类", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = MonitorTplVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "Linux主机监控模版")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MonitorTplServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorTpl>> queryPagedList(MonitorTplVO sample) {
        Result<PagedList<MonitorTpl>> result = new Result<>();
        PagedList<MonitorTpl> list = monitorTplService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        monitorTplService.dao().fill(list).with(MonitorTplMeta.TPL_TYPE).execute();
        result.success(true).data(list);
        return result;
    }
}
