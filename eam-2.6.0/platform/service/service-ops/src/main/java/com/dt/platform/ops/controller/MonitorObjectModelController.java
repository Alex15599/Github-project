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
import com.dt.platform.proxy.ops.MonitorObjectModelServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorObjectModelVOMeta;
import com.dt.platform.domain.ops.MonitorObjectModel;
import com.dt.platform.domain.ops.MonitorObjectModelVO;
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
import com.dt.platform.domain.ops.meta.MonitorObjectModelMeta;
import com.dt.platform.domain.ops.MonitorObjectGroup;
import com.dt.platform.domain.ops.MonitorObjectGrafana;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorObjectModelService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 对象模型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-11 00:00:47
 */
@Api(tags = "对象模型")
@ApiSort(0)
@RestController("OpsMonitorObjectModelController")
public class MonitorObjectModelController extends SuperController {

    @Autowired
    private IMonitorObjectModelService monitorObjectModelService;

    /**
     * 添加对象模型
     */
    @ApiOperation(value = "添加对象模型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.GRAFANA_ID, value = "图表", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.GROUP_ID, value = "群组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MonitorObjectModelServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectModelServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(MonitorObjectModelVO monitorObjectModelVO) {
        Result result = monitorObjectModelService.insert(monitorObjectModelVO, false);
        return result;
    }

    /**
     * 删除对象模型
     */
    @ApiOperation(value = "删除对象模型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MonitorObjectModelServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectModelServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  monitorObjectModelService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = monitorObjectModelService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除对象模型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除对象模型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorObjectModelServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectModelServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorObjectModelService.hasRefers(ids);
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
            Result result = monitorObjectModelService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorObjectModelService.deleteByIdsLogical(canDeleteIds);
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
     * 更新对象模型
     */
    @ApiOperation(value = "更新对象模型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.GRAFANA_ID, value = "图表", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.GROUP_ID, value = "群组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { MonitorObjectModelVOMeta.PAGE_INDEX, MonitorObjectModelVOMeta.PAGE_SIZE, MonitorObjectModelVOMeta.SEARCH_FIELD, MonitorObjectModelVOMeta.FUZZY_FIELD, MonitorObjectModelVOMeta.SEARCH_VALUE, MonitorObjectModelVOMeta.DIRTY_FIELDS, MonitorObjectModelVOMeta.SORT_FIELD, MonitorObjectModelVOMeta.SORT_TYPE, MonitorObjectModelVOMeta.IDS })
    @SentinelResource(value = MonitorObjectModelServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectModelServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(MonitorObjectModelVO monitorObjectModelVO) {
        Result result = monitorObjectModelService.update(monitorObjectModelVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存对象模型
     */
    @ApiOperation(value = "保存对象模型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.GRAFANA_ID, value = "图表", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.GROUP_ID, value = "群组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorObjectModelVOMeta.PAGE_INDEX, MonitorObjectModelVOMeta.PAGE_SIZE, MonitorObjectModelVOMeta.SEARCH_FIELD, MonitorObjectModelVOMeta.FUZZY_FIELD, MonitorObjectModelVOMeta.SEARCH_VALUE, MonitorObjectModelVOMeta.DIRTY_FIELDS, MonitorObjectModelVOMeta.SORT_FIELD, MonitorObjectModelVOMeta.SORT_TYPE, MonitorObjectModelVOMeta.IDS })
    @SentinelResource(value = MonitorObjectModelServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectModelServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(MonitorObjectModelVO monitorObjectModelVO) {
        Result result = monitorObjectModelService.save(monitorObjectModelVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取对象模型
     */
    @ApiOperation(value = "获取对象模型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MonitorObjectModelServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectModelServiceProxy.GET_BY_ID)
    public Result<MonitorObjectModel> getById(String id) {
        Result<MonitorObjectModel> result = new Result<>();
        MonitorObjectModel monitorObjectModel = monitorObjectModelService.getById(id);
        // join 关联的对象
        monitorObjectModelService.dao().fill(monitorObjectModel).with(MonitorObjectModelMeta.GROUP).execute();
        result.success(true).data(monitorObjectModel);
        return result;
    }

    /**
     * 批量获取对象模型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取对象模型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorObjectModelServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectModelServiceProxy.GET_BY_IDS)
    public Result<List<MonitorObjectModel>> getByIds(List<String> ids) {
        Result<List<MonitorObjectModel>> result = new Result<>();
        List<MonitorObjectModel> list = monitorObjectModelService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询对象模型
     */
    @ApiOperation(value = "查询对象模型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.GRAFANA_ID, value = "图表", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.GROUP_ID, value = "群组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorObjectModelVOMeta.PAGE_INDEX, MonitorObjectModelVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorObjectModelServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectModelServiceProxy.QUERY_LIST)
    public Result<List<MonitorObjectModel>> queryList(MonitorObjectModelVO sample) {
        Result<List<MonitorObjectModel>> result = new Result<>();
        List<MonitorObjectModel> list = monitorObjectModelService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询对象模型
     */
    @ApiOperation(value = "分页查询对象模型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.GRAFANA_ID, value = "图表", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.GROUP_ID, value = "群组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectModelVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MonitorObjectModelServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectModelServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorObjectModel>> queryPagedList(MonitorObjectModelVO sample) {
        Result<PagedList<MonitorObjectModel>> result = new Result<>();
        PagedList<MonitorObjectModel> list = monitorObjectModelService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        monitorObjectModelService.dao().fill(list).with(MonitorObjectModelMeta.GROUP).execute();
        result.success(true).data(list);
        return result;
    }
}
