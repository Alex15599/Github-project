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
import com.dt.platform.proxy.ops.MonitorObjectTreeServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorObjectTreeVOMeta;
import com.dt.platform.domain.ops.MonitorObjectTree;
import com.dt.platform.domain.ops.MonitorObjectTreeVO;
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
import com.dt.platform.domain.ops.meta.MonitorObjectTreeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorObjectTreeService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 对象分组类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-11 07:33:32
 */
@Api(tags = "对象分组类型")
@ApiSort(0)
@RestController("OpsMonitorObjectTreeController")
public class MonitorObjectTreeController extends SuperController {

    @Autowired
    private IMonitorObjectTreeService monitorObjectTreeService;

    /**
     * 添加对象分组类型
     */
    @ApiOperation(value = "添加对象分组类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.PID, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MonitorObjectTreeServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTreeServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(MonitorObjectTreeVO monitorObjectTreeVO) {
        Result result = monitorObjectTreeService.insert(monitorObjectTreeVO, false);
        return result;
    }

    /**
     * 删除对象分组类型
     */
    @ApiOperation(value = "删除对象分组类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MonitorObjectTreeServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTreeServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  monitorObjectTreeService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = monitorObjectTreeService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除对象分组类型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除对象分组类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorObjectTreeServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTreeServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorObjectTreeService.hasRefers(ids);
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
            Result result = monitorObjectTreeService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorObjectTreeService.deleteByIdsLogical(canDeleteIds);
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
     * 更新对象分组类型
     */
    @ApiOperation(value = "更新对象分组类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.PID, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { MonitorObjectTreeVOMeta.PAGE_INDEX, MonitorObjectTreeVOMeta.PAGE_SIZE, MonitorObjectTreeVOMeta.SEARCH_FIELD, MonitorObjectTreeVOMeta.FUZZY_FIELD, MonitorObjectTreeVOMeta.SEARCH_VALUE, MonitorObjectTreeVOMeta.DIRTY_FIELDS, MonitorObjectTreeVOMeta.SORT_FIELD, MonitorObjectTreeVOMeta.SORT_TYPE, MonitorObjectTreeVOMeta.IDS })
    @SentinelResource(value = MonitorObjectTreeServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTreeServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(MonitorObjectTreeVO monitorObjectTreeVO) {
        Result result = monitorObjectTreeService.update(monitorObjectTreeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存对象分组类型
     */
    @ApiOperation(value = "保存对象分组类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.PID, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorObjectTreeVOMeta.PAGE_INDEX, MonitorObjectTreeVOMeta.PAGE_SIZE, MonitorObjectTreeVOMeta.SEARCH_FIELD, MonitorObjectTreeVOMeta.FUZZY_FIELD, MonitorObjectTreeVOMeta.SEARCH_VALUE, MonitorObjectTreeVOMeta.DIRTY_FIELDS, MonitorObjectTreeVOMeta.SORT_FIELD, MonitorObjectTreeVOMeta.SORT_TYPE, MonitorObjectTreeVOMeta.IDS })
    @SentinelResource(value = MonitorObjectTreeServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTreeServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(MonitorObjectTreeVO monitorObjectTreeVO) {
        Result result = monitorObjectTreeService.save(monitorObjectTreeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取对象分组类型
     */
    @ApiOperation(value = "获取对象分组类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MonitorObjectTreeServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTreeServiceProxy.GET_BY_ID)
    public Result<MonitorObjectTree> getById(String id) {
        Result<MonitorObjectTree> result = new Result<>();
        MonitorObjectTree monitorObjectTree = monitorObjectTreeService.getById(id);
        result.success(true).data(monitorObjectTree);
        return result;
    }

    /**
     * 批量获取对象分组类型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取对象分组类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorObjectTreeServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTreeServiceProxy.GET_BY_IDS)
    public Result<List<MonitorObjectTree>> getByIds(List<String> ids) {
        Result<List<MonitorObjectTree>> result = new Result<>();
        List<MonitorObjectTree> list = monitorObjectTreeService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询对象分组类型
     */
    @ApiOperation(value = "查询对象分组类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.PID, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorObjectTreeVOMeta.PAGE_INDEX, MonitorObjectTreeVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorObjectTreeServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTreeServiceProxy.QUERY_LIST)
    public Result<List<MonitorObjectTree>> queryList(MonitorObjectTreeVO sample) {
        Result<List<MonitorObjectTree>> result = new Result<>();
        List<MonitorObjectTree> list = monitorObjectTreeService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询对象分组类型
     */
    @ApiOperation(value = "分页查询对象分组类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.PID, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTreeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MonitorObjectTreeServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTreeServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorObjectTree>> queryPagedList(MonitorObjectTreeVO sample) {
        Result<PagedList<MonitorObjectTree>> result = new Result<>();
        PagedList<MonitorObjectTree> list = monitorObjectTreeService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
