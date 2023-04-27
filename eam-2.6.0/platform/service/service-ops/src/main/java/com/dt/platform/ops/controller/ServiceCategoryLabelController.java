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
import com.dt.platform.proxy.ops.ServiceCategoryLabelServiceProxy;
import com.dt.platform.domain.ops.meta.ServiceCategoryLabelVOMeta;
import com.dt.platform.domain.ops.ServiceCategoryLabel;
import com.dt.platform.domain.ops.ServiceCategoryLabelVO;
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
import com.dt.platform.domain.ops.meta.ServiceCategoryLabelMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IServiceCategoryLabelService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 分类标签 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-10 08:40:52
 */
@Api(tags = "分类标签")
@ApiSort(0)
@RestController("OpsServiceCategoryLabelController")
public class ServiceCategoryLabelController extends SuperController {

    @Autowired
    private IServiceCategoryLabelService serviceCategoryLabelService;

    /**
     * 添加分类标签
     */
    @ApiOperation(value = "添加分类标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.CATEGORY_ID, value = "分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.LABEL_CODE, value = "标签", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ServiceCategoryLabelServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryLabelServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ServiceCategoryLabelVO serviceCategoryLabelVO) {
        Result result = serviceCategoryLabelService.insert(serviceCategoryLabelVO, false);
        return result;
    }

    /**
     * 删除分类标签
     */
    @ApiOperation(value = "删除分类标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ServiceCategoryLabelServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryLabelServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  serviceCategoryLabelService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = serviceCategoryLabelService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除分类标签 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除分类标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServiceCategoryLabelServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryLabelServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = serviceCategoryLabelService.hasRefers(ids);
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
            Result result = serviceCategoryLabelService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = serviceCategoryLabelService.deleteByIdsLogical(canDeleteIds);
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
     * 更新分类标签
     */
    @ApiOperation(value = "更新分类标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.CATEGORY_ID, value = "分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.LABEL_CODE, value = "标签", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { ServiceCategoryLabelVOMeta.PAGE_INDEX, ServiceCategoryLabelVOMeta.PAGE_SIZE, ServiceCategoryLabelVOMeta.SEARCH_FIELD, ServiceCategoryLabelVOMeta.FUZZY_FIELD, ServiceCategoryLabelVOMeta.SEARCH_VALUE, ServiceCategoryLabelVOMeta.DIRTY_FIELDS, ServiceCategoryLabelVOMeta.SORT_FIELD, ServiceCategoryLabelVOMeta.SORT_TYPE, ServiceCategoryLabelVOMeta.IDS })
    @SentinelResource(value = ServiceCategoryLabelServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryLabelServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ServiceCategoryLabelVO serviceCategoryLabelVO) {
        Result result = serviceCategoryLabelService.update(serviceCategoryLabelVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存分类标签
     */
    @ApiOperation(value = "保存分类标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.CATEGORY_ID, value = "分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.LABEL_CODE, value = "标签", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServiceCategoryLabelVOMeta.PAGE_INDEX, ServiceCategoryLabelVOMeta.PAGE_SIZE, ServiceCategoryLabelVOMeta.SEARCH_FIELD, ServiceCategoryLabelVOMeta.FUZZY_FIELD, ServiceCategoryLabelVOMeta.SEARCH_VALUE, ServiceCategoryLabelVOMeta.DIRTY_FIELDS, ServiceCategoryLabelVOMeta.SORT_FIELD, ServiceCategoryLabelVOMeta.SORT_TYPE, ServiceCategoryLabelVOMeta.IDS })
    @SentinelResource(value = ServiceCategoryLabelServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryLabelServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ServiceCategoryLabelVO serviceCategoryLabelVO) {
        Result result = serviceCategoryLabelService.save(serviceCategoryLabelVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取分类标签
     */
    @ApiOperation(value = "获取分类标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ServiceCategoryLabelServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryLabelServiceProxy.GET_BY_ID)
    public Result<ServiceCategoryLabel> getById(String id) {
        Result<ServiceCategoryLabel> result = new Result<>();
        ServiceCategoryLabel serviceCategoryLabel = serviceCategoryLabelService.getById(id);
        result.success(true).data(serviceCategoryLabel);
        return result;
    }

    /**
     * 批量获取分类标签 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取分类标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServiceCategoryLabelServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryLabelServiceProxy.GET_BY_IDS)
    public Result<List<ServiceCategoryLabel>> getByIds(List<String> ids) {
        Result<List<ServiceCategoryLabel>> result = new Result<>();
        List<ServiceCategoryLabel> list = serviceCategoryLabelService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询分类标签
     */
    @ApiOperation(value = "查询分类标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.CATEGORY_ID, value = "分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.LABEL_CODE, value = "标签", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServiceCategoryLabelVOMeta.PAGE_INDEX, ServiceCategoryLabelVOMeta.PAGE_SIZE })
    @SentinelResource(value = ServiceCategoryLabelServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryLabelServiceProxy.QUERY_LIST)
    public Result<List<ServiceCategoryLabel>> queryList(ServiceCategoryLabelVO sample) {
        Result<List<ServiceCategoryLabel>> result = new Result<>();
        List<ServiceCategoryLabel> list = serviceCategoryLabelService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询分类标签
     */
    @ApiOperation(value = "分页查询分类标签")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.CATEGORY_ID, value = "分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceCategoryLabelVOMeta.LABEL_CODE, value = "标签", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ServiceCategoryLabelServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceCategoryLabelServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ServiceCategoryLabel>> queryPagedList(ServiceCategoryLabelVO sample) {
        Result<PagedList<ServiceCategoryLabel>> result = new Result<>();
        PagedList<ServiceCategoryLabel> list = serviceCategoryLabelService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
