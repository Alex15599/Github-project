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
import com.dt.platform.proxy.ops.MonitorTplIndicatorTypeServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorTplIndicatorTypeVOMeta;
import com.dt.platform.domain.ops.MonitorTplIndicatorType;
import com.dt.platform.domain.ops.MonitorTplIndicatorTypeVO;
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
import com.dt.platform.domain.ops.meta.MonitorTplIndicatorTypeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorTplIndicatorTypeService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 指标类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-13 07:15:14
 */
@Api(tags = "指标类型")
@ApiSort(0)
@RestController("OpsMonitorTplIndicatorTypeController")
public class MonitorTplIndicatorTypeController extends SuperController {

    @Autowired
    private IMonitorTplIndicatorTypeService monitorTplIndicatorTypeService;

    /**
     * 添加指标类型
     */
    @ApiOperation(value = "添加指标类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "cpu"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "CPU"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "CPU")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorTypeServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(MonitorTplIndicatorTypeVO monitorTplIndicatorTypeVO) {
        Result result = monitorTplIndicatorTypeService.insert(monitorTplIndicatorTypeVO, false);
        return result;
    }

    /**
     * 删除指标类型
     */
    @ApiOperation(value = "删除指标类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorTypeServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  monitorTplIndicatorTypeService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = monitorTplIndicatorTypeService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除指标类型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除指标类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorTypeServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorTplIndicatorTypeService.hasRefers(ids);
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
            Result result = monitorTplIndicatorTypeService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorTplIndicatorTypeService.deleteByIdsLogical(canDeleteIds);
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
     * 更新指标类型
     */
    @ApiOperation(value = "更新指标类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "cpu"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "CPU"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "CPU")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { MonitorTplIndicatorTypeVOMeta.PAGE_INDEX, MonitorTplIndicatorTypeVOMeta.PAGE_SIZE, MonitorTplIndicatorTypeVOMeta.SEARCH_FIELD, MonitorTplIndicatorTypeVOMeta.FUZZY_FIELD, MonitorTplIndicatorTypeVOMeta.SEARCH_VALUE, MonitorTplIndicatorTypeVOMeta.DIRTY_FIELDS, MonitorTplIndicatorTypeVOMeta.SORT_FIELD, MonitorTplIndicatorTypeVOMeta.SORT_TYPE, MonitorTplIndicatorTypeVOMeta.IDS })
    @SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorTypeServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(MonitorTplIndicatorTypeVO monitorTplIndicatorTypeVO) {
        Result result = monitorTplIndicatorTypeService.update(monitorTplIndicatorTypeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存指标类型
     */
    @ApiOperation(value = "保存指标类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "cpu"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "CPU"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "CPU")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorTplIndicatorTypeVOMeta.PAGE_INDEX, MonitorTplIndicatorTypeVOMeta.PAGE_SIZE, MonitorTplIndicatorTypeVOMeta.SEARCH_FIELD, MonitorTplIndicatorTypeVOMeta.FUZZY_FIELD, MonitorTplIndicatorTypeVOMeta.SEARCH_VALUE, MonitorTplIndicatorTypeVOMeta.DIRTY_FIELDS, MonitorTplIndicatorTypeVOMeta.SORT_FIELD, MonitorTplIndicatorTypeVOMeta.SORT_TYPE, MonitorTplIndicatorTypeVOMeta.IDS })
    @SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorTypeServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(MonitorTplIndicatorTypeVO monitorTplIndicatorTypeVO) {
        Result result = monitorTplIndicatorTypeService.save(monitorTplIndicatorTypeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取指标类型
     */
    @ApiOperation(value = "获取指标类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorTypeServiceProxy.GET_BY_ID)
    public Result<MonitorTplIndicatorType> getById(String id) {
        Result<MonitorTplIndicatorType> result = new Result<>();
        MonitorTplIndicatorType monitorTplIndicatorType = monitorTplIndicatorTypeService.getById(id);
        result.success(true).data(monitorTplIndicatorType);
        return result;
    }

    /**
     * 批量获取指标类型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取指标类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorTypeServiceProxy.GET_BY_IDS)
    public Result<List<MonitorTplIndicatorType>> getByIds(List<String> ids) {
        Result<List<MonitorTplIndicatorType>> result = new Result<>();
        List<MonitorTplIndicatorType> list = monitorTplIndicatorTypeService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询指标类型
     */
    @ApiOperation(value = "查询指标类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "cpu"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "CPU"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "CPU")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorTplIndicatorTypeVOMeta.PAGE_INDEX, MonitorTplIndicatorTypeVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorTypeServiceProxy.QUERY_LIST)
    public Result<List<MonitorTplIndicatorType>> queryList(MonitorTplIndicatorTypeVO sample) {
        Result<List<MonitorTplIndicatorType>> result = new Result<>();
        List<MonitorTplIndicatorType> list = monitorTplIndicatorTypeService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询指标类型
     */
    @ApiOperation(value = "分页查询指标类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "cpu"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "CPU"),
		@ApiImplicitParam(name = MonitorTplIndicatorTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "CPU")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MonitorTplIndicatorTypeServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplIndicatorTypeServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorTplIndicatorType>> queryPagedList(MonitorTplIndicatorTypeVO sample) {
        Result<PagedList<MonitorTplIndicatorType>> result = new Result<>();
        PagedList<MonitorTplIndicatorType> list = monitorTplIndicatorTypeService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
