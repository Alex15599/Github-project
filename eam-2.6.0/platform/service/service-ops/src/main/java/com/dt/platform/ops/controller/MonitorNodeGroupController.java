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
import com.dt.platform.proxy.ops.MonitorNodeGroupServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorNodeGroupVOMeta;
import com.dt.platform.domain.ops.MonitorNodeGroup;
import com.dt.platform.domain.ops.MonitorNodeGroupVO;
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
import com.dt.platform.domain.ops.meta.MonitorNodeGroupMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorNodeGroupService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 节点分组 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-13 07:13:47
 */
@Api(tags = "节点分组")
@ApiSort(0)
@RestController("OpsMonitorNodeGroupController")
public class MonitorNodeGroupController extends SuperController {

    @Autowired
    private IMonitorNodeGroupService monitorNodeGroupService;

    /**
     * 添加节点分组
     */
    @ApiOperation(value = "添加节点分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "543027008297238528"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Linux分组"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "Linux分组")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MonitorNodeGroupServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeGroupServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(MonitorNodeGroupVO monitorNodeGroupVO) {
        Result result = monitorNodeGroupService.insert(monitorNodeGroupVO, false);
        return result;
    }

    /**
     * 删除节点分组
     */
    @ApiOperation(value = "删除节点分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "543027008297238528")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MonitorNodeGroupServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeGroupServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  monitorNodeGroupService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = monitorNodeGroupService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除节点分组 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除节点分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorNodeGroupServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeGroupServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorNodeGroupService.hasRefers(ids);
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
            Result result = monitorNodeGroupService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorNodeGroupService.deleteByIdsLogical(canDeleteIds);
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
     * 更新节点分组
     */
    @ApiOperation(value = "更新节点分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "543027008297238528"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Linux分组"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "Linux分组")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { MonitorNodeGroupVOMeta.PAGE_INDEX, MonitorNodeGroupVOMeta.PAGE_SIZE, MonitorNodeGroupVOMeta.SEARCH_FIELD, MonitorNodeGroupVOMeta.FUZZY_FIELD, MonitorNodeGroupVOMeta.SEARCH_VALUE, MonitorNodeGroupVOMeta.DIRTY_FIELDS, MonitorNodeGroupVOMeta.SORT_FIELD, MonitorNodeGroupVOMeta.SORT_TYPE, MonitorNodeGroupVOMeta.IDS })
    @SentinelResource(value = MonitorNodeGroupServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeGroupServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(MonitorNodeGroupVO monitorNodeGroupVO) {
        Result result = monitorNodeGroupService.update(monitorNodeGroupVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存节点分组
     */
    @ApiOperation(value = "保存节点分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "543027008297238528"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Linux分组"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "Linux分组")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorNodeGroupVOMeta.PAGE_INDEX, MonitorNodeGroupVOMeta.PAGE_SIZE, MonitorNodeGroupVOMeta.SEARCH_FIELD, MonitorNodeGroupVOMeta.FUZZY_FIELD, MonitorNodeGroupVOMeta.SEARCH_VALUE, MonitorNodeGroupVOMeta.DIRTY_FIELDS, MonitorNodeGroupVOMeta.SORT_FIELD, MonitorNodeGroupVOMeta.SORT_TYPE, MonitorNodeGroupVOMeta.IDS })
    @SentinelResource(value = MonitorNodeGroupServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeGroupServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(MonitorNodeGroupVO monitorNodeGroupVO) {
        Result result = monitorNodeGroupService.save(monitorNodeGroupVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取节点分组
     */
    @ApiOperation(value = "获取节点分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MonitorNodeGroupServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeGroupServiceProxy.GET_BY_ID)
    public Result<MonitorNodeGroup> getById(String id) {
        Result<MonitorNodeGroup> result = new Result<>();
        MonitorNodeGroup monitorNodeGroup = monitorNodeGroupService.getById(id);
        result.success(true).data(monitorNodeGroup);
        return result;
    }

    /**
     * 批量获取节点分组 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取节点分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorNodeGroupServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeGroupServiceProxy.GET_BY_IDS)
    public Result<List<MonitorNodeGroup>> getByIds(List<String> ids) {
        Result<List<MonitorNodeGroup>> result = new Result<>();
        List<MonitorNodeGroup> list = monitorNodeGroupService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询节点分组
     */
    @ApiOperation(value = "查询节点分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "543027008297238528"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Linux分组"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "Linux分组")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorNodeGroupVOMeta.PAGE_INDEX, MonitorNodeGroupVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorNodeGroupServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeGroupServiceProxy.QUERY_LIST)
    public Result<List<MonitorNodeGroup>> queryList(MonitorNodeGroupVO sample) {
        Result<List<MonitorNodeGroup>> result = new Result<>();
        List<MonitorNodeGroup> list = monitorNodeGroupService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询节点分组
     */
    @ApiOperation(value = "分页查询节点分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "543027008297238528"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Linux分组"),
		@ApiImplicitParam(name = MonitorNodeGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "Linux分组")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MonitorNodeGroupServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeGroupServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorNodeGroup>> queryPagedList(MonitorNodeGroupVO sample) {
        Result<PagedList<MonitorNodeGroup>> result = new Result<>();
        PagedList<MonitorNodeGroup> list = monitorNodeGroupService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
