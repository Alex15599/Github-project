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
import com.dt.platform.proxy.ops.MonitorObjectTplServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorObjectTplVOMeta;
import com.dt.platform.domain.ops.MonitorObjectTpl;
import com.dt.platform.domain.ops.MonitorObjectTplVO;
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
import com.dt.platform.domain.ops.meta.MonitorObjectTplMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorObjectTplService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 对象模版 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-11 08:28:32
 */
@Api(tags = "对象模版")
@ApiSort(0)
@RestController("OpsMonitorObjectTplController")
public class MonitorObjectTplController extends SuperController {

    @Autowired
    private IMonitorObjectTplService monitorObjectTplService;

    /**
     * 添加对象模版
     */
    @ApiOperation(value = "添加对象模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.MODEL_ID, value = "模型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MonitorObjectTplServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTplServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(MonitorObjectTplVO monitorObjectTplVO) {
        Result result = monitorObjectTplService.insert(monitorObjectTplVO, false);
        return result;
    }

    /**
     * 删除对象模版
     */
    @ApiOperation(value = "删除对象模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MonitorObjectTplServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTplServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  monitorObjectTplService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = monitorObjectTplService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除对象模版 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除对象模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorObjectTplServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTplServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorObjectTplService.hasRefers(ids);
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
            Result result = monitorObjectTplService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorObjectTplService.deleteByIdsLogical(canDeleteIds);
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
     * 更新对象模版
     */
    @ApiOperation(value = "更新对象模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.MODEL_ID, value = "模型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { MonitorObjectTplVOMeta.PAGE_INDEX, MonitorObjectTplVOMeta.PAGE_SIZE, MonitorObjectTplVOMeta.SEARCH_FIELD, MonitorObjectTplVOMeta.FUZZY_FIELD, MonitorObjectTplVOMeta.SEARCH_VALUE, MonitorObjectTplVOMeta.DIRTY_FIELDS, MonitorObjectTplVOMeta.SORT_FIELD, MonitorObjectTplVOMeta.SORT_TYPE, MonitorObjectTplVOMeta.IDS })
    @SentinelResource(value = MonitorObjectTplServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTplServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(MonitorObjectTplVO monitorObjectTplVO) {
        Result result = monitorObjectTplService.update(monitorObjectTplVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存对象模版
     */
    @ApiOperation(value = "保存对象模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.MODEL_ID, value = "模型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorObjectTplVOMeta.PAGE_INDEX, MonitorObjectTplVOMeta.PAGE_SIZE, MonitorObjectTplVOMeta.SEARCH_FIELD, MonitorObjectTplVOMeta.FUZZY_FIELD, MonitorObjectTplVOMeta.SEARCH_VALUE, MonitorObjectTplVOMeta.DIRTY_FIELDS, MonitorObjectTplVOMeta.SORT_FIELD, MonitorObjectTplVOMeta.SORT_TYPE, MonitorObjectTplVOMeta.IDS })
    @SentinelResource(value = MonitorObjectTplServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTplServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(MonitorObjectTplVO monitorObjectTplVO) {
        Result result = monitorObjectTplService.save(monitorObjectTplVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取对象模版
     */
    @ApiOperation(value = "获取对象模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MonitorObjectTplServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTplServiceProxy.GET_BY_ID)
    public Result<MonitorObjectTpl> getById(String id) {
        Result<MonitorObjectTpl> result = new Result<>();
        MonitorObjectTpl monitorObjectTpl = monitorObjectTplService.getById(id);
        result.success(true).data(monitorObjectTpl);
        return result;
    }

    /**
     * 批量获取对象模版 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取对象模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorObjectTplServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTplServiceProxy.GET_BY_IDS)
    public Result<List<MonitorObjectTpl>> getByIds(List<String> ids) {
        Result<List<MonitorObjectTpl>> result = new Result<>();
        List<MonitorObjectTpl> list = monitorObjectTplService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询对象模版
     */
    @ApiOperation(value = "查询对象模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.MODEL_ID, value = "模型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorObjectTplVOMeta.PAGE_INDEX, MonitorObjectTplVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorObjectTplServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTplServiceProxy.QUERY_LIST)
    public Result<List<MonitorObjectTpl>> queryList(MonitorObjectTplVO sample) {
        Result<List<MonitorObjectTpl>> result = new Result<>();
        List<MonitorObjectTpl> list = monitorObjectTplService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询对象模版
     */
    @ApiOperation(value = "分页查询对象模版")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.MODEL_ID, value = "模型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorObjectTplVOMeta.SOURCE, value = "来源", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MonitorObjectTplServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectTplServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorObjectTpl>> queryPagedList(MonitorObjectTplVO sample) {
        Result<PagedList<MonitorObjectTpl>> result = new Result<>();
        PagedList<MonitorObjectTpl> list = monitorObjectTplService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
