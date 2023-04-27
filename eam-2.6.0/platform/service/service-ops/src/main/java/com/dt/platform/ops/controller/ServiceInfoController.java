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
import com.dt.platform.proxy.ops.ServiceInfoServiceProxy;
import com.dt.platform.domain.ops.meta.ServiceInfoVOMeta;
import com.dt.platform.domain.ops.ServiceInfo;
import com.dt.platform.domain.ops.ServiceInfoVO;
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
import com.dt.platform.domain.ops.meta.ServiceInfoMeta;
import com.dt.platform.domain.ops.ServiceCategory;
import com.dt.platform.domain.ops.ServiceGroup;
import com.dt.platform.domain.ops.meta.ServiceCategoryMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IServiceInfoService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 服务 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-12 22:05:38
 */
@Api(tags = "服务")
@ApiSort(0)
@RestController("OpsServiceInfoController")
public class ServiceInfoController extends SuperController {

    @Autowired
    private IServiceInfoService serviceInfoService;

    /**
     * 添加服务
     */
    @ApiOperation(value = "添加服务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "223e5dc8-0ddc-11ec-ab08-00163e2e6a36"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.GROUP_ID, value = "服务分组", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SERVICE_CATEGORY_ID, value = "服务分类", required = false, dataTypeClass = String.class, example = "473621743190147072"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Redhat 7.8"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.PATCH, value = "补丁", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ServiceInfoServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceInfoServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ServiceInfoVO serviceInfoVO) {
        Result result = serviceInfoService.insert(serviceInfoVO, false);
        return result;
    }

    /**
     * 删除服务
     */
    @ApiOperation(value = "删除服务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "223e5dc8-0ddc-11ec-ab08-00163e2e6a36")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ServiceInfoServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceInfoServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  serviceInfoService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = serviceInfoService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除服务 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除服务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceInfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServiceInfoServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceInfoServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = serviceInfoService.hasRefers(ids);
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
            Result result = serviceInfoService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = serviceInfoService.deleteByIdsLogical(canDeleteIds);
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
     * 更新服务
     */
    @ApiOperation(value = "更新服务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "223e5dc8-0ddc-11ec-ab08-00163e2e6a36"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.GROUP_ID, value = "服务分组", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SERVICE_CATEGORY_ID, value = "服务分类", required = false, dataTypeClass = String.class, example = "473621743190147072"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Redhat 7.8"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.PATCH, value = "补丁", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { ServiceInfoVOMeta.PAGE_INDEX, ServiceInfoVOMeta.PAGE_SIZE, ServiceInfoVOMeta.SEARCH_FIELD, ServiceInfoVOMeta.FUZZY_FIELD, ServiceInfoVOMeta.SEARCH_VALUE, ServiceInfoVOMeta.DIRTY_FIELDS, ServiceInfoVOMeta.SORT_FIELD, ServiceInfoVOMeta.SORT_TYPE, ServiceInfoVOMeta.IDS })
    @SentinelResource(value = ServiceInfoServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceInfoServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ServiceInfoVO serviceInfoVO) {
        Result result = serviceInfoService.update(serviceInfoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存服务
     */
    @ApiOperation(value = "保存服务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "223e5dc8-0ddc-11ec-ab08-00163e2e6a36"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.GROUP_ID, value = "服务分组", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SERVICE_CATEGORY_ID, value = "服务分类", required = false, dataTypeClass = String.class, example = "473621743190147072"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Redhat 7.8"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.PATCH, value = "补丁", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServiceInfoVOMeta.PAGE_INDEX, ServiceInfoVOMeta.PAGE_SIZE, ServiceInfoVOMeta.SEARCH_FIELD, ServiceInfoVOMeta.FUZZY_FIELD, ServiceInfoVOMeta.SEARCH_VALUE, ServiceInfoVOMeta.DIRTY_FIELDS, ServiceInfoVOMeta.SORT_FIELD, ServiceInfoVOMeta.SORT_TYPE, ServiceInfoVOMeta.IDS })
    @SentinelResource(value = ServiceInfoServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceInfoServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ServiceInfoVO serviceInfoVO) {
        Result result = serviceInfoService.save(serviceInfoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取服务
     */
    @ApiOperation(value = "获取服务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ServiceInfoServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceInfoServiceProxy.GET_BY_ID)
    public Result<ServiceInfo> getById(String id) {
        Result<ServiceInfo> result = new Result<>();
        ServiceInfo serviceInfo = serviceInfoService.getById(id);
        // join 关联的对象
        serviceInfoService.dao().fill(serviceInfo).with(ServiceCategoryMeta.GROUP).with(ServiceInfoMeta.SERVICE_CATEGORY).execute();
        result.success(true).data(serviceInfo);
        return result;
    }

    /**
     * 批量获取服务 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取服务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceInfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServiceInfoServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceInfoServiceProxy.GET_BY_IDS)
    public Result<List<ServiceInfo>> getByIds(List<String> ids) {
        Result<List<ServiceInfo>> result = new Result<>();
        List<ServiceInfo> list = serviceInfoService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询服务
     */
    @ApiOperation(value = "查询服务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "223e5dc8-0ddc-11ec-ab08-00163e2e6a36"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.GROUP_ID, value = "服务分组", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SERVICE_CATEGORY_ID, value = "服务分类", required = false, dataTypeClass = String.class, example = "473621743190147072"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Redhat 7.8"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.PATCH, value = "补丁", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServiceInfoVOMeta.PAGE_INDEX, ServiceInfoVOMeta.PAGE_SIZE })
    @SentinelResource(value = ServiceInfoServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceInfoServiceProxy.QUERY_LIST)
    public Result<List<ServiceInfo>> queryList(ServiceInfoVO sample) {
        Result<List<ServiceInfo>> result = new Result<>();
        List<ServiceInfo> list = serviceInfoService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询服务
     */
    @ApiOperation(value = "分页查询服务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "223e5dc8-0ddc-11ec-ab08-00163e2e6a36"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.GROUP_ID, value = "服务分组", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SERVICE_CATEGORY_ID, value = "服务分类", required = false, dataTypeClass = String.class, example = "473621743190147072"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Redhat 7.8"),
		@ApiImplicitParam(name = ServiceInfoVOMeta.PATCH, value = "补丁", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceInfoVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ServiceInfoServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceInfoServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ServiceInfo>> queryPagedList(ServiceInfoVO sample) {
        Result<PagedList<ServiceInfo>> result = new Result<>();
        PagedList<ServiceInfo> list = serviceInfoService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        serviceInfoService.dao().fill(list).with(ServiceCategoryMeta.GROUP).with(ServiceInfoMeta.SERVICE_CATEGORY).execute();
        result.success(true).data(list);
        return result;
    }
}
