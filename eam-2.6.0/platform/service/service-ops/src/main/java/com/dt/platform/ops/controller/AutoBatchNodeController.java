package com.dt.platform.ops.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.domain.ops.AutoBatchNode;
import com.dt.platform.domain.ops.AutoBatchNodeVO;
import com.dt.platform.domain.ops.meta.AutoBatchNodeVOMeta;
import com.dt.platform.ops.service.IAutoBatchNodeService;
import com.dt.platform.proxy.ops.AutoBatchNodeServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 分组节点 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 10:20:37
 */
@Api(tags = "分组节点")
@ApiSort(0)
@RestController("OpsAutoBatchNodeController")
public class AutoBatchNodeController extends SuperController {

    @Autowired
    private IAutoBatchNodeService autoBatchNodeService;

    /**
     * 添加分组节点
     */
    @ApiOperation(value = "添加分组节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AutoBatchNodeServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchNodeServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AutoBatchNodeVO autoBatchNodeVO) {
        Result result = autoBatchNodeService.insert(autoBatchNodeVO, false);
        return result;
    }

    /**
     * 删除分组节点
     */
    @ApiOperation(value = "删除分组节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AutoBatchNodeServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchNodeServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  autoBatchNodeService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = autoBatchNodeService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除分组节点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除分组节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoBatchNodeServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchNodeServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = autoBatchNodeService.hasRefers(ids);
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
            Result result = autoBatchNodeService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = autoBatchNodeService.deleteByIdsLogical(canDeleteIds);
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
     * 更新分组节点
     */
    @ApiOperation(value = "更新分组节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AutoBatchNodeVOMeta.PAGE_INDEX, AutoBatchNodeVOMeta.PAGE_SIZE, AutoBatchNodeVOMeta.SEARCH_FIELD, AutoBatchNodeVOMeta.FUZZY_FIELD, AutoBatchNodeVOMeta.SEARCH_VALUE, AutoBatchNodeVOMeta.DIRTY_FIELDS, AutoBatchNodeVOMeta.SORT_FIELD, AutoBatchNodeVOMeta.SORT_TYPE, AutoBatchNodeVOMeta.IDS })
    @SentinelResource(value = AutoBatchNodeServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchNodeServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AutoBatchNodeVO autoBatchNodeVO) {
        Result result = autoBatchNodeService.update(autoBatchNodeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存分组节点
     */
    @ApiOperation(value = "保存分组节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoBatchNodeVOMeta.PAGE_INDEX, AutoBatchNodeVOMeta.PAGE_SIZE, AutoBatchNodeVOMeta.SEARCH_FIELD, AutoBatchNodeVOMeta.FUZZY_FIELD, AutoBatchNodeVOMeta.SEARCH_VALUE, AutoBatchNodeVOMeta.DIRTY_FIELDS, AutoBatchNodeVOMeta.SORT_FIELD, AutoBatchNodeVOMeta.SORT_TYPE, AutoBatchNodeVOMeta.IDS })
    @SentinelResource(value = AutoBatchNodeServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchNodeServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AutoBatchNodeVO autoBatchNodeVO) {
        Result result = autoBatchNodeService.save(autoBatchNodeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取分组节点
     */
    @ApiOperation(value = "获取分组节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AutoBatchNodeServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchNodeServiceProxy.GET_BY_ID)
    public Result<AutoBatchNode> getById(String id) {
        Result<AutoBatchNode> result = new Result<>();
        AutoBatchNode autoBatchNode = autoBatchNodeService.getById(id);
        result.success(true).data(autoBatchNode);
        return result;
    }

    /**
     * 批量获取分组节点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取分组节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoBatchNodeServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchNodeServiceProxy.GET_BY_IDS)
    public Result<List<AutoBatchNode>> getByIds(List<String> ids) {
        Result<List<AutoBatchNode>> result = new Result<>();
        List<AutoBatchNode> list = autoBatchNodeService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询分组节点
     */
    @ApiOperation(value = "查询分组节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoBatchNodeVOMeta.PAGE_INDEX, AutoBatchNodeVOMeta.PAGE_SIZE })
    @SentinelResource(value = AutoBatchNodeServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchNodeServiceProxy.QUERY_LIST)
    public Result<List<AutoBatchNode>> queryList(AutoBatchNodeVO sample) {
        Result<List<AutoBatchNode>> result = new Result<>();
        List<AutoBatchNode> list = autoBatchNodeService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询分组节点
     */
    @ApiOperation(value = "分页查询分组节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoBatchNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AutoBatchNodeServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchNodeServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AutoBatchNode>> queryPagedList(AutoBatchNodeVO sample) {
        Result<PagedList<AutoBatchNode>> result = new Result<>();
        PagedList<AutoBatchNode> list = autoBatchNodeService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
