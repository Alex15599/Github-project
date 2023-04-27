package com.dt.platform.ops.controller;

import java.util.List;
import java.util.ArrayList;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.proxy.ops.CmdbLogServiceProxy;
import com.dt.platform.domain.ops.meta.CmdbLogVOMeta;
import com.dt.platform.domain.ops.CmdbLog;
import com.dt.platform.domain.ops.CmdbLogVO;
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
import com.dt.platform.domain.ops.meta.CmdbLogMeta;
import com.dt.platform.domain.ops.CmdbModelV;
import com.dt.platform.domain.ops.CmdbModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ICmdbLogService;

/**
 * <p>
 * 配置日志接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-22 14:18:36
 */
@InDoc
@Api(tags = "null/配置日志")
@RestController("OpsCmdbLogController")
public class CmdbLogController extends SuperController {

    @Autowired
    private ICmdbLogService cmdbLogService;

    /**
     * 添加配置日志
     */
    @ApiOperation(value = "添加配置日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.MODEL_ID, value = "模型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.OBJ_ID, value = "对象", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.LOG_LEVEL, value = "日志级别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.TRACE_ID, value = "TRACE", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.LOG_RECORD, value = "日志", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.RCD_TIME, value = "时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbLogServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbLogServiceProxy.INSERT)
    public Result insert(CmdbLogVO cmdbLogVO) {
        Result result = cmdbLogService.insert(cmdbLogVO, false);
        return result;
    }

    /**
     * 删除配置日志
     */
    @ApiOperation(value = "删除配置日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbLogServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbLogServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  cmdbLogService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = cmdbLogService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除配置日志 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除配置日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbLogVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbLogServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbLogServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = cmdbLogService.hasRefers(ids);
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
            Result result = cmdbLogService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = cmdbLogService.deleteByIdsLogical(canDeleteIds);
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
     * 更新配置日志
     */
    @ApiOperation(value = "更新配置日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.MODEL_ID, value = "模型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.OBJ_ID, value = "对象", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.LOG_LEVEL, value = "日志级别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.TRACE_ID, value = "TRACE", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.LOG_RECORD, value = "日志", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.RCD_TIME, value = "时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CmdbLogVOMeta.PAGE_INDEX, CmdbLogVOMeta.PAGE_SIZE, CmdbLogVOMeta.SEARCH_FIELD, CmdbLogVOMeta.FUZZY_FIELD, CmdbLogVOMeta.SEARCH_VALUE, CmdbLogVOMeta.DIRTY_FIELDS, CmdbLogVOMeta.SORT_FIELD, CmdbLogVOMeta.SORT_TYPE, CmdbLogVOMeta.IDS })
    @SentinelResource(value = CmdbLogServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbLogServiceProxy.UPDATE)
    public Result update(CmdbLogVO cmdbLogVO) {
        Result result = cmdbLogService.update(cmdbLogVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存配置日志
     */
    @ApiOperation(value = "保存配置日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.MODEL_ID, value = "模型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.OBJ_ID, value = "对象", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.LOG_LEVEL, value = "日志级别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.TRACE_ID, value = "TRACE", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.LOG_RECORD, value = "日志", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.RCD_TIME, value = "时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CmdbLogVOMeta.PAGE_INDEX, CmdbLogVOMeta.PAGE_SIZE, CmdbLogVOMeta.SEARCH_FIELD, CmdbLogVOMeta.FUZZY_FIELD, CmdbLogVOMeta.SEARCH_VALUE, CmdbLogVOMeta.DIRTY_FIELDS, CmdbLogVOMeta.SORT_FIELD, CmdbLogVOMeta.SORT_TYPE, CmdbLogVOMeta.IDS })
    @SentinelResource(value = CmdbLogServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbLogServiceProxy.SAVE)
    public Result save(CmdbLogVO cmdbLogVO) {
        Result result = cmdbLogService.save(cmdbLogVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取配置日志
     */
    @ApiOperation(value = "获取配置日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbLogServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbLogServiceProxy.GET_BY_ID)
    public Result<CmdbLog> getById(String id) {
        Result<CmdbLog> result = new Result<>();
        CmdbLog cmdbLog = cmdbLogService.getById(id);
        // join 关联的对象
        cmdbLogService.dao().fill(cmdbLog).with(CmdbLogMeta.CMDB_MODEL).with(CmdbLogMeta.CMDB_MODEL_V).execute();
        result.success(true).data(cmdbLog);
        return result;
    }

    /**
     * 批量获取配置日志 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取配置日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbLogVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbLogServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbLogServiceProxy.GET_BY_IDS)
    public Result<List<CmdbLog>> getByIds(List<String> ids) {
        Result<List<CmdbLog>> result = new Result<>();
        List<CmdbLog> list = cmdbLogService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询配置日志
     */
    @ApiOperation(value = "查询配置日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.MODEL_ID, value = "模型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.OBJ_ID, value = "对象", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.LOG_LEVEL, value = "日志级别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.TRACE_ID, value = "TRACE", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.LOG_RECORD, value = "日志", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.RCD_TIME, value = "时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CmdbLogVOMeta.PAGE_INDEX, CmdbLogVOMeta.PAGE_SIZE })
    @SentinelResource(value = CmdbLogServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbLogServiceProxy.QUERY_LIST)
    public Result<List<CmdbLog>> queryList(CmdbLogVO sample) {
        Result<List<CmdbLog>> result = new Result<>();
        List<CmdbLog> list = cmdbLogService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询配置日志
     */
    @ApiOperation(value = "分页查询配置日志")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CmdbLogVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.MODEL_ID, value = "模型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.OBJ_ID, value = "对象", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.LOG_LEVEL, value = "日志级别", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.TRACE_ID, value = "TRACE", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.LOG_RECORD, value = "日志", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.RCD_TIME, value = "时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CmdbLogVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CmdbLogServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CmdbLogServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CmdbLog>> queryPagedList(CmdbLogVO sample) {
        Result<PagedList<CmdbLog>> result = new Result<>();
        PagedList<CmdbLog> list = cmdbLogService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        cmdbLogService.dao().fill(list).with(CmdbLogMeta.CMDB_MODEL).with(CmdbLogMeta.CMDB_MODEL_V).execute();
        result.success(true).data(list);
        return result;
    }
}
