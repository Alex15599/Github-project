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
import com.dt.platform.proxy.ops.MonitorTplGraphServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorTplGraphVOMeta;
import com.dt.platform.domain.ops.MonitorTplGraph;
import com.dt.platform.domain.ops.MonitorTplGraphVO;
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
import com.dt.platform.domain.ops.meta.MonitorTplGraphMeta;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplGraphItem;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorTplGraphService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 模版图形 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-14 16:30:58
 */
@Api(tags = "模版图形")
@ApiSort(0)
@RestController("OpsMonitorTplGraphController")
public class MonitorTplGraphController extends SuperController {

    @Autowired
    private IMonitorTplGraphService monitorTplGraphService;

    /**
     * 添加模版图形
     */
    @ApiOperation(value = "添加模版图形")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "CPU使用情况"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.TPL_CODE, value = "模版", required = false, dataTypeClass = String.class, example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_WIDTH, value = "宽度", required = false, dataTypeClass = Integer.class, example = "900"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_HEIGHT, value = "高度", required = false, dataTypeClass = Integer.class, example = "200"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_TYPE, value = "图形类别", required = false, dataTypeClass = String.class, example = "line"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.CONTENT, value = "图形设置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.DS, value = "数据来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "800"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MonitorTplGraphServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplGraphServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(MonitorTplGraphVO monitorTplGraphVO) {
        Result result = monitorTplGraphService.insert(monitorTplGraphVO, false);
        return result;
    }

    /**
     * 删除模版图形
     */
    @ApiOperation(value = "删除模版图形")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MonitorTplGraphServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplGraphServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  monitorTplGraphService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = monitorTplGraphService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除模版图形 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除模版图形")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorTplGraphServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplGraphServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorTplGraphService.hasRefers(ids);
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
            Result result = monitorTplGraphService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorTplGraphService.deleteByIdsLogical(canDeleteIds);
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
     * 更新模版图形
     */
    @ApiOperation(value = "更新模版图形")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "CPU使用情况"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.TPL_CODE, value = "模版", required = false, dataTypeClass = String.class, example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_WIDTH, value = "宽度", required = false, dataTypeClass = Integer.class, example = "900"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_HEIGHT, value = "高度", required = false, dataTypeClass = Integer.class, example = "200"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_TYPE, value = "图形类别", required = false, dataTypeClass = String.class, example = "line"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.CONTENT, value = "图形设置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.DS, value = "数据来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "800"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { MonitorTplGraphVOMeta.PAGE_INDEX, MonitorTplGraphVOMeta.PAGE_SIZE, MonitorTplGraphVOMeta.SEARCH_FIELD, MonitorTplGraphVOMeta.FUZZY_FIELD, MonitorTplGraphVOMeta.SEARCH_VALUE, MonitorTplGraphVOMeta.DIRTY_FIELDS, MonitorTplGraphVOMeta.SORT_FIELD, MonitorTplGraphVOMeta.SORT_TYPE, MonitorTplGraphVOMeta.IDS })
    @SentinelResource(value = MonitorTplGraphServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplGraphServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(MonitorTplGraphVO monitorTplGraphVO) {
        Result result = monitorTplGraphService.update(monitorTplGraphVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存模版图形
     */
    @ApiOperation(value = "保存模版图形")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "CPU使用情况"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.TPL_CODE, value = "模版", required = false, dataTypeClass = String.class, example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_WIDTH, value = "宽度", required = false, dataTypeClass = Integer.class, example = "900"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_HEIGHT, value = "高度", required = false, dataTypeClass = Integer.class, example = "200"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_TYPE, value = "图形类别", required = false, dataTypeClass = String.class, example = "line"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.CONTENT, value = "图形设置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.DS, value = "数据来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "800"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorTplGraphVOMeta.PAGE_INDEX, MonitorTplGraphVOMeta.PAGE_SIZE, MonitorTplGraphVOMeta.SEARCH_FIELD, MonitorTplGraphVOMeta.FUZZY_FIELD, MonitorTplGraphVOMeta.SEARCH_VALUE, MonitorTplGraphVOMeta.DIRTY_FIELDS, MonitorTplGraphVOMeta.SORT_FIELD, MonitorTplGraphVOMeta.SORT_TYPE, MonitorTplGraphVOMeta.IDS })
    @SentinelResource(value = MonitorTplGraphServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplGraphServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(MonitorTplGraphVO monitorTplGraphVO) {
        Result result = monitorTplGraphService.save(monitorTplGraphVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取模版图形
     */
    @ApiOperation(value = "获取模版图形")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MonitorTplGraphServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplGraphServiceProxy.GET_BY_ID)
    public Result<MonitorTplGraph> getById(String id) {
        Result<MonitorTplGraph> result = new Result<>();
        MonitorTplGraph monitorTplGraph = monitorTplGraphService.getById(id);
        // join 关联的对象
        monitorTplGraphService.dao().fill(monitorTplGraph).with(MonitorTplGraphMeta.TPL).execute();
        result.success(true).data(monitorTplGraph);
        return result;
    }

    /**
     * 批量获取模版图形 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取模版图形")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorTplGraphServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplGraphServiceProxy.GET_BY_IDS)
    public Result<List<MonitorTplGraph>> getByIds(List<String> ids) {
        Result<List<MonitorTplGraph>> result = new Result<>();
        List<MonitorTplGraph> list = monitorTplGraphService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询模版图形
     */
    @ApiOperation(value = "查询模版图形")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "CPU使用情况"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.TPL_CODE, value = "模版", required = false, dataTypeClass = String.class, example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_WIDTH, value = "宽度", required = false, dataTypeClass = Integer.class, example = "900"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_HEIGHT, value = "高度", required = false, dataTypeClass = Integer.class, example = "200"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_TYPE, value = "图形类别", required = false, dataTypeClass = String.class, example = "line"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.CONTENT, value = "图形设置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.DS, value = "数据来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "800"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorTplGraphVOMeta.PAGE_INDEX, MonitorTplGraphVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorTplGraphServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplGraphServiceProxy.QUERY_LIST)
    public Result<List<MonitorTplGraph>> queryList(MonitorTplGraphVO sample) {
        Result<List<MonitorTplGraph>> result = new Result<>();
        List<MonitorTplGraph> list = monitorTplGraphService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询模版图形
     */
    @ApiOperation(value = "分页查询模版图形")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "CPU使用情况"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.TPL_CODE, value = "模版", required = false, dataTypeClass = String.class, example = "tpl_host_linux_script"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_WIDTH, value = "宽度", required = false, dataTypeClass = Integer.class, example = "900"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_HEIGHT, value = "高度", required = false, dataTypeClass = Integer.class, example = "200"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.GRAPH_TYPE, value = "图形类别", required = false, dataTypeClass = String.class, example = "line"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.CONTENT, value = "图形设置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.DS, value = "数据来源", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "800"),
		@ApiImplicitParam(name = MonitorTplGraphVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MonitorTplGraphServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplGraphServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorTplGraph>> queryPagedList(MonitorTplGraphVO sample) {
        Result<PagedList<MonitorTplGraph>> result = new Result<>();
        PagedList<MonitorTplGraph> list = monitorTplGraphService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        monitorTplGraphService.dao().fill(list).with(MonitorTplGraphMeta.TPL).execute();
        result.success(true).data(list);
        return result;
    }
}
