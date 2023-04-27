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
import com.dt.platform.proxy.ops.SystemConsoleInfoServiceProxy;
import com.dt.platform.domain.ops.meta.SystemConsoleInfoVOMeta;
import com.dt.platform.domain.ops.SystemConsoleInfo;
import com.dt.platform.domain.ops.SystemConsoleInfoVO;
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
import com.dt.platform.domain.ops.meta.SystemConsoleInfoMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ISystemConsoleInfoService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 管理台台账 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-04 07:30:04
 */
@Api(tags = "管理台台账")
@ApiSort(0)
@RestController("OpsSystemConsoleInfoController")
public class SystemConsoleInfoController extends SuperController {

    @Autowired
    private ISystemConsoleInfoService systemConsoleInfoService;

    /**
     * 添加管理台台账
     */
    @ApiOperation(value = "添加管理台台账")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "607473993401769984"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "was_console"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ENV, value = "环境", required = false, dataTypeClass = String.class, example = "test"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ADDRESS, value = "地址", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = SystemConsoleInfoServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SystemConsoleInfoServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(SystemConsoleInfoVO systemConsoleInfoVO) {
        Result result = systemConsoleInfoService.insert(systemConsoleInfoVO, false);
        return result;
    }

    /**
     * 删除管理台台账
     */
    @ApiOperation(value = "删除管理台台账")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "607473993401769984")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = SystemConsoleInfoServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SystemConsoleInfoServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  systemConsoleInfoService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = systemConsoleInfoService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除管理台台账 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除管理台台账")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = SystemConsoleInfoServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SystemConsoleInfoServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = systemConsoleInfoService.hasRefers(ids);
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
            Result result = systemConsoleInfoService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = systemConsoleInfoService.deleteByIdsLogical(canDeleteIds);
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
     * 更新管理台台账
     */
    @ApiOperation(value = "更新管理台台账")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "607473993401769984"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "was_console"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ENV, value = "环境", required = false, dataTypeClass = String.class, example = "test"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ADDRESS, value = "地址", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { SystemConsoleInfoVOMeta.PAGE_INDEX, SystemConsoleInfoVOMeta.PAGE_SIZE, SystemConsoleInfoVOMeta.SEARCH_FIELD, SystemConsoleInfoVOMeta.FUZZY_FIELD, SystemConsoleInfoVOMeta.SEARCH_VALUE, SystemConsoleInfoVOMeta.DIRTY_FIELDS, SystemConsoleInfoVOMeta.SORT_FIELD, SystemConsoleInfoVOMeta.SORT_TYPE, SystemConsoleInfoVOMeta.IDS })
    @SentinelResource(value = SystemConsoleInfoServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SystemConsoleInfoServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(SystemConsoleInfoVO systemConsoleInfoVO) {
        Result result = systemConsoleInfoService.update(systemConsoleInfoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存管理台台账
     */
    @ApiOperation(value = "保存管理台台账")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "607473993401769984"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "was_console"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ENV, value = "环境", required = false, dataTypeClass = String.class, example = "test"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ADDRESS, value = "地址", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { SystemConsoleInfoVOMeta.PAGE_INDEX, SystemConsoleInfoVOMeta.PAGE_SIZE, SystemConsoleInfoVOMeta.SEARCH_FIELD, SystemConsoleInfoVOMeta.FUZZY_FIELD, SystemConsoleInfoVOMeta.SEARCH_VALUE, SystemConsoleInfoVOMeta.DIRTY_FIELDS, SystemConsoleInfoVOMeta.SORT_FIELD, SystemConsoleInfoVOMeta.SORT_TYPE, SystemConsoleInfoVOMeta.IDS })
    @SentinelResource(value = SystemConsoleInfoServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SystemConsoleInfoServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(SystemConsoleInfoVO systemConsoleInfoVO) {
        Result result = systemConsoleInfoService.save(systemConsoleInfoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取管理台台账
     */
    @ApiOperation(value = "获取管理台台账")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = SystemConsoleInfoServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SystemConsoleInfoServiceProxy.GET_BY_ID)
    public Result<SystemConsoleInfo> getById(String id) {
        Result<SystemConsoleInfo> result = new Result<>();
        SystemConsoleInfo systemConsoleInfo = systemConsoleInfoService.getById(id);
        // join 关联的对象
        systemConsoleInfoService.dao().fill(systemConsoleInfo).with(SystemConsoleInfoMeta.TYPE_DICT).execute();
        result.success(true).data(systemConsoleInfo);
        return result;
    }

    /**
     * 批量获取管理台台账 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取管理台台账")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = SystemConsoleInfoServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SystemConsoleInfoServiceProxy.GET_BY_IDS)
    public Result<List<SystemConsoleInfo>> getByIds(List<String> ids) {
        Result<List<SystemConsoleInfo>> result = new Result<>();
        List<SystemConsoleInfo> list = systemConsoleInfoService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询管理台台账
     */
    @ApiOperation(value = "查询管理台台账")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "607473993401769984"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "was_console"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ENV, value = "环境", required = false, dataTypeClass = String.class, example = "test"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ADDRESS, value = "地址", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { SystemConsoleInfoVOMeta.PAGE_INDEX, SystemConsoleInfoVOMeta.PAGE_SIZE })
    @SentinelResource(value = SystemConsoleInfoServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SystemConsoleInfoServiceProxy.QUERY_LIST)
    public Result<List<SystemConsoleInfo>> queryList(SystemConsoleInfoVO sample) {
        Result<List<SystemConsoleInfo>> result = new Result<>();
        List<SystemConsoleInfo> list = systemConsoleInfoService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询管理台台账
     */
    @ApiOperation(value = "分页查询管理台台账")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "607473993401769984"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "was_console"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ENV, value = "环境", required = false, dataTypeClass = String.class, example = "test"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.ADDRESS, value = "地址", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = SystemConsoleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = SystemConsoleInfoServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SystemConsoleInfoServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<SystemConsoleInfo>> queryPagedList(SystemConsoleInfoVO sample) {
        Result<PagedList<SystemConsoleInfo>> result = new Result<>();
        PagedList<SystemConsoleInfo> list = systemConsoleInfoService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        systemConsoleInfoService.dao().fill(list).with(SystemConsoleInfoMeta.TYPE_DICT).execute();
        result.success(true).data(list);
        return result;
    }
}
