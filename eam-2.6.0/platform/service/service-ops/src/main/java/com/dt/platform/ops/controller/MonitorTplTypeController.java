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
import com.dt.platform.proxy.ops.MonitorTplTypeServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorTplTypeVOMeta;
import com.dt.platform.domain.ops.MonitorTplType;
import com.dt.platform.domain.ops.MonitorTplTypeVO;
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
import com.dt.platform.domain.ops.meta.MonitorTplTypeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorTplTypeService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 模版类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-13 07:15:58
 */
@Api(tags = "模版类型")
@ApiSort(0)
@RestController("OpsMonitorTplTypeController")
public class MonitorTplTypeController extends SuperController {

    @Autowired
    private IMonitorTplTypeService monitorTplTypeService;

    /**
     * 添加模版类型
     */
    @ApiOperation(value = "添加模版类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "主机"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "主机类型")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MonitorTplTypeServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTypeServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(MonitorTplTypeVO monitorTplTypeVO) {
        Result result = monitorTplTypeService.insert(monitorTplTypeVO, false);
        return result;
    }

    /**
     * 删除模版类型
     */
    @ApiOperation(value = "删除模版类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MonitorTplTypeServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTypeServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  monitorTplTypeService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = monitorTplTypeService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除模版类型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除模版类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorTplTypeServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTypeServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorTplTypeService.hasRefers(ids);
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
            Result result = monitorTplTypeService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorTplTypeService.deleteByIdsLogical(canDeleteIds);
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
     * 更新模版类型
     */
    @ApiOperation(value = "更新模版类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "主机"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "主机类型")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { MonitorTplTypeVOMeta.PAGE_INDEX, MonitorTplTypeVOMeta.PAGE_SIZE, MonitorTplTypeVOMeta.SEARCH_FIELD, MonitorTplTypeVOMeta.FUZZY_FIELD, MonitorTplTypeVOMeta.SEARCH_VALUE, MonitorTplTypeVOMeta.DIRTY_FIELDS, MonitorTplTypeVOMeta.SORT_FIELD, MonitorTplTypeVOMeta.SORT_TYPE, MonitorTplTypeVOMeta.IDS })
    @SentinelResource(value = MonitorTplTypeServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTypeServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(MonitorTplTypeVO monitorTplTypeVO) {
        Result result = monitorTplTypeService.update(monitorTplTypeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存模版类型
     */
    @ApiOperation(value = "保存模版类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "主机"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "主机类型")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorTplTypeVOMeta.PAGE_INDEX, MonitorTplTypeVOMeta.PAGE_SIZE, MonitorTplTypeVOMeta.SEARCH_FIELD, MonitorTplTypeVOMeta.FUZZY_FIELD, MonitorTplTypeVOMeta.SEARCH_VALUE, MonitorTplTypeVOMeta.DIRTY_FIELDS, MonitorTplTypeVOMeta.SORT_FIELD, MonitorTplTypeVOMeta.SORT_TYPE, MonitorTplTypeVOMeta.IDS })
    @SentinelResource(value = MonitorTplTypeServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTypeServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(MonitorTplTypeVO monitorTplTypeVO) {
        Result result = monitorTplTypeService.save(monitorTplTypeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取模版类型
     */
    @ApiOperation(value = "获取模版类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MonitorTplTypeServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTypeServiceProxy.GET_BY_ID)
    public Result<MonitorTplType> getById(String id) {
        Result<MonitorTplType> result = new Result<>();
        MonitorTplType monitorTplType = monitorTplTypeService.getById(id);
        result.success(true).data(monitorTplType);
        return result;
    }

    /**
     * 批量获取模版类型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取模版类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorTplTypeServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTypeServiceProxy.GET_BY_IDS)
    public Result<List<MonitorTplType>> getByIds(List<String> ids) {
        Result<List<MonitorTplType>> result = new Result<>();
        List<MonitorTplType> list = monitorTplTypeService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询模版类型
     */
    @ApiOperation(value = "查询模版类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "主机"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "主机类型")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorTplTypeVOMeta.PAGE_INDEX, MonitorTplTypeVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorTplTypeServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTypeServiceProxy.QUERY_LIST)
    public Result<List<MonitorTplType>> queryList(MonitorTplTypeVO sample) {
        Result<List<MonitorTplType>> result = new Result<>();
        List<MonitorTplType> list = monitorTplTypeService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询模版类型
     */
    @ApiOperation(value = "分页查询模版类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "主机"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = MonitorTplTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "主机类型")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MonitorTplTypeServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorTplTypeServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorTplType>> queryPagedList(MonitorTplTypeVO sample) {
        Result<PagedList<MonitorTplType>> result = new Result<>();
        PagedList<MonitorTplType> list = monitorTplTypeService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
