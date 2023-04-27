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
import com.dt.platform.proxy.ops.HostExByHostServiceProxy;
import com.dt.platform.domain.ops.meta.HostExByHostVOMeta;
import com.dt.platform.domain.ops.HostExByHost;
import com.dt.platform.domain.ops.HostExByHostVO;
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
import com.dt.platform.domain.ops.meta.HostExByHostMeta;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.meta.HostMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IHostExByHostService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 主机排除 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-11 16:26:30
 */
@Api(tags = "主机排除")
@ApiSort(0)
@RestController("OpsHostExByHostController")
public class HostExByHostController extends SuperController {

    @Autowired
    private IHostExByHostService hostExByHostService;

    /**
     * 添加主机排除
     */
    @ApiOperation(value = "添加主机排除")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = HostExByHostVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = HostExByHostVOMeta.HOST_ID, value = "主机", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = HostExByHostVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = HostExByHostServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(HostExByHostServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(HostExByHostVO hostExByHostVO) {
        Result result = hostExByHostService.insert(hostExByHostVO, false);
        return result;
    }

    /**
     * 删除主机排除
     */
    @ApiOperation(value = "删除主机排除")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = HostExByHostVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = HostExByHostServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(HostExByHostServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  hostExByHostService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = hostExByHostService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除主机排除 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除主机排除")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = HostExByHostVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = HostExByHostServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(HostExByHostServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = hostExByHostService.hasRefers(ids);
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
            Result result = hostExByHostService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = hostExByHostService.deleteByIdsLogical(canDeleteIds);
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
     * 更新主机排除
     */
    @ApiOperation(value = "更新主机排除")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = HostExByHostVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = HostExByHostVOMeta.HOST_ID, value = "主机", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = HostExByHostVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { HostExByHostVOMeta.PAGE_INDEX, HostExByHostVOMeta.PAGE_SIZE, HostExByHostVOMeta.SEARCH_FIELD, HostExByHostVOMeta.FUZZY_FIELD, HostExByHostVOMeta.SEARCH_VALUE, HostExByHostVOMeta.DIRTY_FIELDS, HostExByHostVOMeta.SORT_FIELD, HostExByHostVOMeta.SORT_TYPE, HostExByHostVOMeta.IDS })
    @SentinelResource(value = HostExByHostServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(HostExByHostServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(HostExByHostVO hostExByHostVO) {
        Result result = hostExByHostService.update(hostExByHostVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存主机排除
     */
    @ApiOperation(value = "保存主机排除")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = HostExByHostVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = HostExByHostVOMeta.HOST_ID, value = "主机", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = HostExByHostVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { HostExByHostVOMeta.PAGE_INDEX, HostExByHostVOMeta.PAGE_SIZE, HostExByHostVOMeta.SEARCH_FIELD, HostExByHostVOMeta.FUZZY_FIELD, HostExByHostVOMeta.SEARCH_VALUE, HostExByHostVOMeta.DIRTY_FIELDS, HostExByHostVOMeta.SORT_FIELD, HostExByHostVOMeta.SORT_TYPE, HostExByHostVOMeta.IDS })
    @SentinelResource(value = HostExByHostServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(HostExByHostServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(HostExByHostVO hostExByHostVO) {
        Result result = hostExByHostService.save(hostExByHostVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取主机排除
     */
    @ApiOperation(value = "获取主机排除")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = HostExByHostVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = HostExByHostServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(HostExByHostServiceProxy.GET_BY_ID)
    public Result<HostExByHost> getById(String id) {
        Result<HostExByHost> result = new Result<>();
        HostExByHost hostExByHost = hostExByHostService.getById(id);
        // join 关联的对象
        hostExByHostService.dao().fill(hostExByHost).with(HostExByHostMeta.HOST).with(HostExByHostMeta.HOST).execute();
        result.success(true).data(hostExByHost);
        return result;
    }

    /**
     * 批量获取主机排除 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取主机排除")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = HostExByHostVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = HostExByHostServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(HostExByHostServiceProxy.GET_BY_IDS)
    public Result<List<HostExByHost>> getByIds(List<String> ids) {
        Result<List<HostExByHost>> result = new Result<>();
        List<HostExByHost> list = hostExByHostService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询主机排除
     */
    @ApiOperation(value = "查询主机排除")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = HostExByHostVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = HostExByHostVOMeta.HOST_ID, value = "主机", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = HostExByHostVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { HostExByHostVOMeta.PAGE_INDEX, HostExByHostVOMeta.PAGE_SIZE })
    @SentinelResource(value = HostExByHostServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(HostExByHostServiceProxy.QUERY_LIST)
    public Result<List<HostExByHost>> queryList(HostExByHostVO sample) {
        Result<List<HostExByHost>> result = new Result<>();
        List<HostExByHost> list = hostExByHostService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询主机排除
     */
    @ApiOperation(value = "分页查询主机排除")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = HostExByHostVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = HostExByHostVOMeta.HOST_ID, value = "主机", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = HostExByHostVOMeta.NOTE, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = HostExByHostServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(HostExByHostServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<HostExByHost>> queryPagedList(HostExByHostVO sample) {
        Result<PagedList<HostExByHost>> result = new Result<>();
        PagedList<HostExByHost> list = hostExByHostService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        hostExByHostService.dao().fill(list).with(HostExByHostMeta.HOST).with(HostExByHostMeta.HOST).execute();
        result.success(true).data(list);
        return result;
    }
}
