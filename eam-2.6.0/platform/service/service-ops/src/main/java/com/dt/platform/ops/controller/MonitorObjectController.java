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
import com.dt.platform.proxy.ops.MonitorObjectServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorObjectVOMeta;
import com.dt.platform.domain.ops.MonitorObject;
import com.dt.platform.domain.ops.MonitorObjectVO;
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
import com.dt.platform.domain.ops.meta.MonitorObjectMeta;
import com.dt.platform.domain.ops.MonitorObjectGroup;
import com.dt.platform.domain.ops.MonitorObjectModel;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorObjectService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 监控对象 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-10 09:04:00
 */
@Api(tags = "监控对象")
@ApiSort(0)
@RestController("OpsMonitorObjectController")
public class MonitorObjectController extends SuperController {

    @Autowired
    private IMonitorObjectService monitorObjectService;

    /**
     * 添加监控对象
     */
    @ApiOperation(value = "添加监控对象")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "598430433176195072"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.OBJECT_MODEL_ID, value = "模型", required = false, dataTypeClass = String.class, example = "598422473460940800"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.GROUP_CODE, value = "分组", required = false, dataTypeClass = String.class, example = "middleware"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MonitorObjectServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(MonitorObjectVO monitorObjectVO) {
        Result result = monitorObjectService.insert(monitorObjectVO, false);
        return result;
    }

    /**
     * 删除监控对象
     */
    @ApiOperation(value = "删除监控对象")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "598430433176195072")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MonitorObjectServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  monitorObjectService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = monitorObjectService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除监控对象 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除监控对象")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorObjectServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorObjectService.hasRefers(ids);
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
            Result result = monitorObjectService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorObjectService.deleteByIdsLogical(canDeleteIds);
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
     * 更新监控对象
     */
    @ApiOperation(value = "更新监控对象")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "598430433176195072"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.OBJECT_MODEL_ID, value = "模型", required = false, dataTypeClass = String.class, example = "598422473460940800"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.GROUP_CODE, value = "分组", required = false, dataTypeClass = String.class, example = "middleware"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { MonitorObjectVOMeta.PAGE_INDEX, MonitorObjectVOMeta.PAGE_SIZE, MonitorObjectVOMeta.SEARCH_FIELD, MonitorObjectVOMeta.FUZZY_FIELD, MonitorObjectVOMeta.SEARCH_VALUE, MonitorObjectVOMeta.DIRTY_FIELDS, MonitorObjectVOMeta.SORT_FIELD, MonitorObjectVOMeta.SORT_TYPE, MonitorObjectVOMeta.IDS })
    @SentinelResource(value = MonitorObjectServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(MonitorObjectVO monitorObjectVO) {
        Result result = monitorObjectService.update(monitorObjectVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存监控对象
     */
    @ApiOperation(value = "保存监控对象")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "598430433176195072"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.OBJECT_MODEL_ID, value = "模型", required = false, dataTypeClass = String.class, example = "598422473460940800"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.GROUP_CODE, value = "分组", required = false, dataTypeClass = String.class, example = "middleware"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorObjectVOMeta.PAGE_INDEX, MonitorObjectVOMeta.PAGE_SIZE, MonitorObjectVOMeta.SEARCH_FIELD, MonitorObjectVOMeta.FUZZY_FIELD, MonitorObjectVOMeta.SEARCH_VALUE, MonitorObjectVOMeta.DIRTY_FIELDS, MonitorObjectVOMeta.SORT_FIELD, MonitorObjectVOMeta.SORT_TYPE, MonitorObjectVOMeta.IDS })
    @SentinelResource(value = MonitorObjectServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(MonitorObjectVO monitorObjectVO) {
        Result result = monitorObjectService.save(monitorObjectVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取监控对象
     */
    @ApiOperation(value = "获取监控对象")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MonitorObjectServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectServiceProxy.GET_BY_ID)
    public Result<MonitorObject> getById(String id) {
        Result<MonitorObject> result = new Result<>();
        MonitorObject monitorObject = monitorObjectService.getById(id);
        // join 关联的对象
        monitorObjectService.dao().fill(monitorObject).with(MonitorObjectMeta.GROUP).with(MonitorObjectMeta.OBJECT_MODEL).execute();
        result.success(true).data(monitorObject);
        return result;
    }

    /**
     * 批量获取监控对象 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取监控对象")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorObjectServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectServiceProxy.GET_BY_IDS)
    public Result<List<MonitorObject>> getByIds(List<String> ids) {
        Result<List<MonitorObject>> result = new Result<>();
        List<MonitorObject> list = monitorObjectService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询监控对象
     */
    @ApiOperation(value = "查询监控对象")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "598430433176195072"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.OBJECT_MODEL_ID, value = "模型", required = false, dataTypeClass = String.class, example = "598422473460940800"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.GROUP_CODE, value = "分组", required = false, dataTypeClass = String.class, example = "middleware"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorObjectVOMeta.PAGE_INDEX, MonitorObjectVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorObjectServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectServiceProxy.QUERY_LIST)
    public Result<List<MonitorObject>> queryList(MonitorObjectVO sample) {
        Result<List<MonitorObject>> result = new Result<>();
        List<MonitorObject> list = monitorObjectService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询监控对象
     */
    @ApiOperation(value = "分页查询监控对象")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorObjectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "598430433176195072"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.OBJECT_MODEL_ID, value = "模型", required = false, dataTypeClass = String.class, example = "598422473460940800"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.GROUP_CODE, value = "分组", required = false, dataTypeClass = String.class, example = "middleware"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = MonitorObjectVOMeta.IP, value = "IP", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MonitorObjectServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorObjectServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorObject>> queryPagedList(MonitorObjectVO sample) {
        Result<PagedList<MonitorObject>> result = new Result<>();
        PagedList<MonitorObject> list = monitorObjectService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        monitorObjectService.dao().fill(list).with(MonitorObjectMeta.GROUP).with(MonitorObjectMeta.OBJECT_MODEL).execute();
        result.success(true).data(list);
        return result;
    }
}
