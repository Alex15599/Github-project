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
import com.dt.platform.proxy.ops.ServiceGroupServiceProxy;
import com.dt.platform.domain.ops.meta.ServiceGroupVOMeta;
import com.dt.platform.domain.ops.ServiceGroup;
import com.dt.platform.domain.ops.ServiceGroupVO;
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
import com.dt.platform.domain.ops.meta.ServiceGroupMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IServiceGroupService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 服务分组 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-12 22:05:33
 */
@Api(tags = "服务分组")
@ApiSort(0)
@RestController("OpsServiceGroupController")
public class ServiceGroupController extends SuperController {

    @Autowired
    private IServiceGroupService serviceGroupService;

    /**
     * 添加服务分组
     */
    @ApiOperation(value = "添加服务分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "db"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "数据库")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ServiceGroupServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceGroupServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ServiceGroupVO serviceGroupVO) {
        Result result = serviceGroupService.insert(serviceGroupVO, false);
        return result;
    }

    /**
     * 删除服务分组
     */
    @ApiOperation(value = "删除服务分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ServiceGroupServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceGroupServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  serviceGroupService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = serviceGroupService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除服务分组 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除服务分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceGroupVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServiceGroupServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceGroupServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = serviceGroupService.hasRefers(ids);
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
            Result result = serviceGroupService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = serviceGroupService.deleteByIdsLogical(canDeleteIds);
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
     * 更新服务分组
     */
    @ApiOperation(value = "更新服务分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "db"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "数据库")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { ServiceGroupVOMeta.PAGE_INDEX, ServiceGroupVOMeta.PAGE_SIZE, ServiceGroupVOMeta.SEARCH_FIELD, ServiceGroupVOMeta.FUZZY_FIELD, ServiceGroupVOMeta.SEARCH_VALUE, ServiceGroupVOMeta.DIRTY_FIELDS, ServiceGroupVOMeta.SORT_FIELD, ServiceGroupVOMeta.SORT_TYPE, ServiceGroupVOMeta.IDS })
    @SentinelResource(value = ServiceGroupServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceGroupServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ServiceGroupVO serviceGroupVO) {
        Result result = serviceGroupService.update(serviceGroupVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存服务分组
     */
    @ApiOperation(value = "保存服务分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "db"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "数据库")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServiceGroupVOMeta.PAGE_INDEX, ServiceGroupVOMeta.PAGE_SIZE, ServiceGroupVOMeta.SEARCH_FIELD, ServiceGroupVOMeta.FUZZY_FIELD, ServiceGroupVOMeta.SEARCH_VALUE, ServiceGroupVOMeta.DIRTY_FIELDS, ServiceGroupVOMeta.SORT_FIELD, ServiceGroupVOMeta.SORT_TYPE, ServiceGroupVOMeta.IDS })
    @SentinelResource(value = ServiceGroupServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceGroupServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ServiceGroupVO serviceGroupVO) {
        Result result = serviceGroupService.save(serviceGroupVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取服务分组
     */
    @ApiOperation(value = "获取服务分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ServiceGroupServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceGroupServiceProxy.GET_BY_ID)
    public Result<ServiceGroup> getById(String id) {
        Result<ServiceGroup> result = new Result<>();
        ServiceGroup serviceGroup = serviceGroupService.getById(id);
        result.success(true).data(serviceGroup);
        return result;
    }

    /**
     * 批量获取服务分组 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取服务分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceGroupVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServiceGroupServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceGroupServiceProxy.GET_BY_IDS)
    public Result<List<ServiceGroup>> getByIds(List<String> ids) {
        Result<List<ServiceGroup>> result = new Result<>();
        List<ServiceGroup> list = serviceGroupService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询服务分组
     */
    @ApiOperation(value = "查询服务分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "db"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "数据库")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServiceGroupVOMeta.PAGE_INDEX, ServiceGroupVOMeta.PAGE_SIZE })
    @SentinelResource(value = ServiceGroupServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceGroupServiceProxy.QUERY_LIST)
    public Result<List<ServiceGroup>> queryList(ServiceGroupVO sample) {
        Result<List<ServiceGroup>> result = new Result<>();
        List<ServiceGroup> list = serviceGroupService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询服务分组
     */
    @ApiOperation(value = "分页查询服务分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "db"),
		@ApiImplicitParam(name = ServiceGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "数据库")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ServiceGroupServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceGroupServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ServiceGroup>> queryPagedList(ServiceGroupVO sample) {
        Result<PagedList<ServiceGroup>> result = new Result<>();
        PagedList<ServiceGroup> list = serviceGroupService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
