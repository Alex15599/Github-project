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
import com.dt.platform.proxy.ops.MonitorObjectGroupServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorObjectGroupVOMeta;
import com.dt.platform.domain.ops.MonitorObjectGroup;
import com.dt.platform.domain.ops.MonitorObjectGroupVO;
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
import com.dt.platform.domain.ops.meta.MonitorObjectGroupMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorObjectGroupService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 对象分组 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-10 07:36:30
 */
@Api(tags = "对象分组")
@ApiSort(0)
@RestController("OpsMonitorObjectGroupController")
public class MonitorObjectGroupController extends SuperController {

    @Autowired
    private IMonitorObjectGroupService monitorObjectGroupService;

    /**
     * 添加对象分组
     */
    @ApiOperation(value = "添加对象分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MonitorObjectGroupServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectGroupServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(MonitorObjectGroupVO monitorObjectGroupVO) {
        Result result = monitorObjectGroupService.insert(monitorObjectGroupVO, false);
        return result;
    }

    /**
     * 删除对象分组
     */
    @ApiOperation(value = "删除对象分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MonitorObjectGroupServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectGroupServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  monitorObjectGroupService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = monitorObjectGroupService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除对象分组 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除对象分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorObjectGroupServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectGroupServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorObjectGroupService.hasRefers(ids);
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
            Result result = monitorObjectGroupService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorObjectGroupService.deleteByIdsLogical(canDeleteIds);
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
     * 更新对象分组
     */
    @ApiOperation(value = "更新对象分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { MonitorObjectGroupVOMeta.PAGE_INDEX, MonitorObjectGroupVOMeta.PAGE_SIZE, MonitorObjectGroupVOMeta.SEARCH_FIELD, MonitorObjectGroupVOMeta.FUZZY_FIELD, MonitorObjectGroupVOMeta.SEARCH_VALUE, MonitorObjectGroupVOMeta.DIRTY_FIELDS, MonitorObjectGroupVOMeta.SORT_FIELD, MonitorObjectGroupVOMeta.SORT_TYPE, MonitorObjectGroupVOMeta.IDS })
    @SentinelResource(value = MonitorObjectGroupServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectGroupServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(MonitorObjectGroupVO monitorObjectGroupVO) {
        Result result = monitorObjectGroupService.update(monitorObjectGroupVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存对象分组
     */
    @ApiOperation(value = "保存对象分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorObjectGroupVOMeta.PAGE_INDEX, MonitorObjectGroupVOMeta.PAGE_SIZE, MonitorObjectGroupVOMeta.SEARCH_FIELD, MonitorObjectGroupVOMeta.FUZZY_FIELD, MonitorObjectGroupVOMeta.SEARCH_VALUE, MonitorObjectGroupVOMeta.DIRTY_FIELDS, MonitorObjectGroupVOMeta.SORT_FIELD, MonitorObjectGroupVOMeta.SORT_TYPE, MonitorObjectGroupVOMeta.IDS })
    @SentinelResource(value = MonitorObjectGroupServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectGroupServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(MonitorObjectGroupVO monitorObjectGroupVO) {
        Result result = monitorObjectGroupService.save(monitorObjectGroupVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取对象分组
     */
    @ApiOperation(value = "获取对象分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MonitorObjectGroupServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectGroupServiceProxy.GET_BY_ID)
    public Result<MonitorObjectGroup> getById(String id) {
        Result<MonitorObjectGroup> result = new Result<>();
        MonitorObjectGroup monitorObjectGroup = monitorObjectGroupService.getById(id);
        result.success(true).data(monitorObjectGroup);
        return result;
    }

    /**
     * 批量获取对象分组 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取对象分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorObjectGroupServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectGroupServiceProxy.GET_BY_IDS)
    public Result<List<MonitorObjectGroup>> getByIds(List<String> ids) {
        Result<List<MonitorObjectGroup>> result = new Result<>();
        List<MonitorObjectGroup> list = monitorObjectGroupService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询对象分组
     */
    @ApiOperation(value = "查询对象分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorObjectGroupVOMeta.PAGE_INDEX, MonitorObjectGroupVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorObjectGroupServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectGroupServiceProxy.QUERY_LIST)
    public Result<List<MonitorObjectGroup>> queryList(MonitorObjectGroupVO sample) {
        Result<List<MonitorObjectGroup>> result = new Result<>();
        List<MonitorObjectGroup> list = monitorObjectGroupService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询对象分组
     */
    @ApiOperation(value = "分页查询对象分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MonitorObjectGroupServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectGroupServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorObjectGroup>> queryPagedList(MonitorObjectGroupVO sample) {
        Result<PagedList<MonitorObjectGroup>> result = new Result<>();
        PagedList<MonitorObjectGroup> list = monitorObjectGroupService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
