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
import com.dt.platform.proxy.ops.ServiceCategoryServiceProxy;
import com.dt.platform.domain.ops.meta.ServiceCategoryVOMeta;
import com.dt.platform.domain.ops.ServiceCategory;
import com.dt.platform.domain.ops.ServiceCategoryVO;
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
import com.dt.platform.domain.ops.meta.ServiceCategoryMeta;
import com.dt.platform.domain.ops.ServiceGroup;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IServiceCategoryService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 服务类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-13 06:31:54
 */
@Api(tags = "服务类型")
@ApiSort(0)
@RestController("OpsServiceCategoryController")
public class ServiceCategoryController extends SuperController {

    @Autowired
    private IServiceCategoryService serviceCategoryService;

    /**
     * 添加服务类型
     */
    @ApiOperation(value = "添加服务类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.GROUP_ID, value = "服务分组", required = false, dataTypeClass = String.class, example = "db"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ServiceCategoryServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ServiceCategoryVO serviceCategoryVO) {
        Result result = serviceCategoryService.insert(serviceCategoryVO, false);
        return result;
    }

    /**
     * 删除服务类型
     */
    @ApiOperation(value = "删除服务类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "473621482614816700")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ServiceCategoryServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  serviceCategoryService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = serviceCategoryService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除服务类型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除服务类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServiceCategoryServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = serviceCategoryService.hasRefers(ids);
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
            Result result = serviceCategoryService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = serviceCategoryService.deleteByIdsLogical(canDeleteIds);
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
     * 更新服务类型
     */
    @ApiOperation(value = "更新服务类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.GROUP_ID, value = "服务分组", required = false, dataTypeClass = String.class, example = "db"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { ServiceCategoryVOMeta.PAGE_INDEX, ServiceCategoryVOMeta.PAGE_SIZE, ServiceCategoryVOMeta.SEARCH_FIELD, ServiceCategoryVOMeta.FUZZY_FIELD, ServiceCategoryVOMeta.SEARCH_VALUE, ServiceCategoryVOMeta.DIRTY_FIELDS, ServiceCategoryVOMeta.SORT_FIELD, ServiceCategoryVOMeta.SORT_TYPE, ServiceCategoryVOMeta.IDS })
    @SentinelResource(value = ServiceCategoryServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ServiceCategoryVO serviceCategoryVO) {
        Result result = serviceCategoryService.update(serviceCategoryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存服务类型
     */
    @ApiOperation(value = "保存服务类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.GROUP_ID, value = "服务分组", required = false, dataTypeClass = String.class, example = "db"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServiceCategoryVOMeta.PAGE_INDEX, ServiceCategoryVOMeta.PAGE_SIZE, ServiceCategoryVOMeta.SEARCH_FIELD, ServiceCategoryVOMeta.FUZZY_FIELD, ServiceCategoryVOMeta.SEARCH_VALUE, ServiceCategoryVOMeta.DIRTY_FIELDS, ServiceCategoryVOMeta.SORT_FIELD, ServiceCategoryVOMeta.SORT_TYPE, ServiceCategoryVOMeta.IDS })
    @SentinelResource(value = ServiceCategoryServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ServiceCategoryVO serviceCategoryVO) {
        Result result = serviceCategoryService.save(serviceCategoryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取服务类型
     */
    @ApiOperation(value = "获取服务类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ServiceCategoryServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryServiceProxy.GET_BY_ID)
    public Result<ServiceCategory> getById(String id) {
        Result<ServiceCategory> result = new Result<>();
        ServiceCategory serviceCategory = serviceCategoryService.getById(id);
        // join 关联的对象
        serviceCategoryService.dao().fill(serviceCategory).with(ServiceCategoryMeta.GROUP).with(ServiceCategoryMeta.LABEL_LIST).execute();
        result.success(true).data(serviceCategory);
        return result;
    }

    /**
     * 批量获取服务类型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取服务类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServiceCategoryServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryServiceProxy.GET_BY_IDS)
    public Result<List<ServiceCategory>> getByIds(List<String> ids) {
        Result<List<ServiceCategory>> result = new Result<>();
        List<ServiceCategory> list = serviceCategoryService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询服务类型
     */
    @ApiOperation(value = "查询服务类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.GROUP_ID, value = "服务分组", required = false, dataTypeClass = String.class, example = "db"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServiceCategoryVOMeta.PAGE_INDEX, ServiceCategoryVOMeta.PAGE_SIZE })
    @SentinelResource(value = ServiceCategoryServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryServiceProxy.QUERY_LIST)
    public Result<List<ServiceCategory>> queryList(ServiceCategoryVO sample) {
        Result<List<ServiceCategory>> result = new Result<>();
        List<ServiceCategory> list = serviceCategoryService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询服务类型
     */
    @ApiOperation(value = "分页查询服务类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "473621482614816700"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.GROUP_ID, value = "服务分组", required = false, dataTypeClass = String.class, example = "db"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "Oracle"),
		@ApiImplicitParam(name = ServiceCategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ServiceCategoryServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ServiceCategory>> queryPagedList(ServiceCategoryVO sample) {
        Result<PagedList<ServiceCategory>> result = new Result<>();
        PagedList<ServiceCategory> list = serviceCategoryService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        serviceCategoryService.dao().fill(list).with(ServiceCategoryMeta.GROUP).with(ServiceCategoryMeta.LABEL_LIST).execute();
        result.success(true).data(list);
        return result;
    }
}
