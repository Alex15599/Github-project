package com.dt.platform.common.controller;

import java.util.*;
import com.alibaba.fastjson.JSONObject;
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
import com.dt.platform.proxy.common.NodeLoadServiceProxy;
import com.dt.platform.domain.common.meta.NodeLoadVOMeta;
import com.dt.platform.domain.common.NodeLoad;
import com.dt.platform.domain.common.NodeLoadVO;
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
import com.dt.platform.domain.common.meta.NodeLoadMeta;
import java.math.BigDecimal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.common.service.INodeLoadService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 节点负载接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:37:38
 */
@InDoc
@Api(tags = "节点负载")
@RestController("SysNodeLoadController")
public class NodeLoadController extends SuperController {

    @Autowired
    private INodeLoadService nodeLoadService;

    /**
     * 添加节点负载
     */
    @ApiOperation(value = "添加节点负载")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NodeLoadVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.NODE, value = "节点", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.USER, value = "用户使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.SYS, value = "系统使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.IDLE, value = "空闲使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.WIO, value = "wio", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD1, value = "load1", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD5, value = "load5", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD15, value = "load15", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.MEMORY_USED, value = "内存使用", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.MEMORY_USED_PCT, value = "内存使用率", required = false, dataTypeClass = BigDecimal.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NodeLoadServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NodeLoadServiceProxy.INSERT)
    public Result insert(NodeLoadVO nodeLoadVO) {
        Result result = nodeLoadService.insert(nodeLoadVO, false);
        return result;
    }

    /**
     * 删除节点负载
     */
    @ApiOperation(value = "删除节点负载")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NodeLoadVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NodeLoadServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NodeLoadServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = nodeLoadService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = nodeLoadService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除节点负载 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除节点负载")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NodeLoadVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NodeLoadServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NodeLoadServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = nodeLoadService.hasRefers(ids);
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
            Result result = nodeLoadService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = nodeLoadService.deleteByIdsLogical(canDeleteIds);
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
     * 更新节点负载
     */
    @ApiOperation(value = "更新节点负载")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NodeLoadVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.NODE, value = "节点", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.USER, value = "用户使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.SYS, value = "系统使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.IDLE, value = "空闲使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.WIO, value = "wio", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD1, value = "load1", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD5, value = "load5", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD15, value = "load15", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.MEMORY_USED, value = "内存使用", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.MEMORY_USED_PCT, value = "内存使用率", required = false, dataTypeClass = BigDecimal.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { NodeLoadVOMeta.PAGE_INDEX, NodeLoadVOMeta.PAGE_SIZE, NodeLoadVOMeta.SEARCH_FIELD, NodeLoadVOMeta.FUZZY_FIELD, NodeLoadVOMeta.SEARCH_VALUE, NodeLoadVOMeta.DIRTY_FIELDS, NodeLoadVOMeta.SORT_FIELD, NodeLoadVOMeta.SORT_TYPE, NodeLoadVOMeta.DATA_ORIGIN, NodeLoadVOMeta.QUERY_LOGIC, NodeLoadVOMeta.IDS })
    @SentinelResource(value = NodeLoadServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NodeLoadServiceProxy.UPDATE)
    public Result update(NodeLoadVO nodeLoadVO) {
        Result result = nodeLoadService.update(nodeLoadVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存节点负载
     */
    @ApiOperation(value = "保存节点负载")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NodeLoadVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.NODE, value = "节点", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.USER, value = "用户使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.SYS, value = "系统使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.IDLE, value = "空闲使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.WIO, value = "wio", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD1, value = "load1", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD5, value = "load5", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD15, value = "load15", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.MEMORY_USED, value = "内存使用", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.MEMORY_USED_PCT, value = "内存使用率", required = false, dataTypeClass = BigDecimal.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { NodeLoadVOMeta.PAGE_INDEX, NodeLoadVOMeta.PAGE_SIZE, NodeLoadVOMeta.SEARCH_FIELD, NodeLoadVOMeta.FUZZY_FIELD, NodeLoadVOMeta.SEARCH_VALUE, NodeLoadVOMeta.DIRTY_FIELDS, NodeLoadVOMeta.SORT_FIELD, NodeLoadVOMeta.SORT_TYPE, NodeLoadVOMeta.DATA_ORIGIN, NodeLoadVOMeta.QUERY_LOGIC, NodeLoadVOMeta.IDS })
    @SentinelResource(value = NodeLoadServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NodeLoadServiceProxy.SAVE)
    public Result save(NodeLoadVO nodeLoadVO) {
        Result result = nodeLoadService.save(nodeLoadVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取节点负载
     */
    @ApiOperation(value = "获取节点负载")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NodeLoadVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NodeLoadServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NodeLoadServiceProxy.GET_BY_ID)
    public Result<NodeLoad> getById(String id) {
        Result<NodeLoad> result = new Result<>();
        NodeLoad nodeLoad = nodeLoadService.getById(id);
        result.success(true).data(nodeLoad);
        return result;
    }

    /**
     * 获取节点负载
     */
    @ApiOperation(value = "获取节点负载")
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NodeLoadServiceProxy.LOAD_DATA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NodeLoadServiceProxy.LOAD_DATA)
    public Result<JSONObject> loadData(String ctl) {
        return nodeLoadService.loadData(ctl);
    }

    /**
     * 批量获取节点负载 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取节点负载")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NodeLoadVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NodeLoadServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NodeLoadServiceProxy.GET_BY_IDS)
    public Result<List<NodeLoad>> getByIds(List<String> ids) {
        Result<List<NodeLoad>> result = new Result<>();
        List<NodeLoad> list = nodeLoadService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询节点负载
     */
    @ApiOperation(value = "查询节点负载")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NodeLoadVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.NODE, value = "节点", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.USER, value = "用户使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.SYS, value = "系统使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.IDLE, value = "空闲使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.WIO, value = "wio", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD1, value = "load1", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD5, value = "load5", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD15, value = "load15", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.MEMORY_USED, value = "内存使用", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.MEMORY_USED_PCT, value = "内存使用率", required = false, dataTypeClass = BigDecimal.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { NodeLoadVOMeta.PAGE_INDEX, NodeLoadVOMeta.PAGE_SIZE })
    @SentinelResource(value = NodeLoadServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NodeLoadServiceProxy.QUERY_LIST)
    public Result<List<NodeLoad>> queryList(NodeLoadVO sample) {
        Result<List<NodeLoad>> result = new Result<>();
        List<NodeLoad> list = nodeLoadService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询节点负载
     */
    @ApiOperation(value = "分页查询节点负载")
    @ApiImplicitParams({
		@ApiImplicitParam(name = NodeLoadVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.NODE, value = "节点", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.USER, value = "用户使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.SYS, value = "系统使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.IDLE, value = "空闲使用率", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.WIO, value = "wio", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD1, value = "load1", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD5, value = "load5", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.LOAD15, value = "load15", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.MEMORY_USED, value = "内存使用", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = NodeLoadVOMeta.MEMORY_USED_PCT, value = "内存使用率", required = false, dataTypeClass = BigDecimal.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = NodeLoadServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NodeLoadServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<NodeLoad>> queryPagedList(NodeLoadVO sample) {
        Result<PagedList<NodeLoad>> result = new Result<>();
        PagedList<NodeLoad> list = nodeLoadService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
