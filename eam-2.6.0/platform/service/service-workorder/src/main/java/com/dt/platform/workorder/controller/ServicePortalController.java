package com.dt.platform.workorder.controller;

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
import com.dt.platform.proxy.workorder.ServicePortalServiceProxy;
import com.dt.platform.domain.workorder.meta.ServicePortalVOMeta;
import com.dt.platform.domain.workorder.ServicePortal;
import com.dt.platform.domain.workorder.ServicePortalVO;
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
import com.dt.platform.domain.workorder.meta.ServicePortalMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.workorder.service.IServicePortalService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 服务门户 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-08 22:24:18
 */
@Api(tags = "服务门户")
@ApiSort(0)
@RestController("WoServicePortalController")
public class ServicePortalController extends SuperController {

    @Autowired
    private IServicePortalService servicePortalService;

    /**
     * 添加服务门户
     */
    @ApiOperation(value = "添加服务门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServicePortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.PERM, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.IMAGE, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.URL, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ServicePortalServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServicePortalServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ServicePortalVO servicePortalVO) {
        Result result = servicePortalService.insert(servicePortalVO, false);
        return result;
    }

    /**
     * 删除服务门户
     */
    @ApiOperation(value = "删除服务门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServicePortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ServicePortalServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServicePortalServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  servicePortalService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = servicePortalService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除服务门户 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除服务门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServicePortalVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServicePortalServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServicePortalServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = servicePortalService.hasRefers(ids);
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
            Result result = servicePortalService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = servicePortalService.deleteByIdsLogical(canDeleteIds);
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
     * 更新服务门户
     */
    @ApiOperation(value = "更新服务门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServicePortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.PERM, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.IMAGE, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.URL, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { ServicePortalVOMeta.PAGE_INDEX, ServicePortalVOMeta.PAGE_SIZE, ServicePortalVOMeta.SEARCH_FIELD, ServicePortalVOMeta.FUZZY_FIELD, ServicePortalVOMeta.SEARCH_VALUE, ServicePortalVOMeta.DIRTY_FIELDS, ServicePortalVOMeta.SORT_FIELD, ServicePortalVOMeta.SORT_TYPE, ServicePortalVOMeta.IDS })
    @SentinelResource(value = ServicePortalServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServicePortalServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ServicePortalVO servicePortalVO) {
        Result result = servicePortalService.update(servicePortalVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存服务门户
     */
    @ApiOperation(value = "保存服务门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServicePortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.PERM, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.IMAGE, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.URL, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServicePortalVOMeta.PAGE_INDEX, ServicePortalVOMeta.PAGE_SIZE, ServicePortalVOMeta.SEARCH_FIELD, ServicePortalVOMeta.FUZZY_FIELD, ServicePortalVOMeta.SEARCH_VALUE, ServicePortalVOMeta.DIRTY_FIELDS, ServicePortalVOMeta.SORT_FIELD, ServicePortalVOMeta.SORT_TYPE, ServicePortalVOMeta.IDS })
    @SentinelResource(value = ServicePortalServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServicePortalServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ServicePortalVO servicePortalVO) {
        Result result = servicePortalService.save(servicePortalVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取服务门户
     */
    @ApiOperation(value = "获取服务门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServicePortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ServicePortalServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServicePortalServiceProxy.GET_BY_ID)
    public Result<ServicePortal> getById(String id) {
        Result<ServicePortal> result = new Result<>();
        ServicePortal servicePortal = servicePortalService.getById(id);
        // join 关联的对象
        servicePortalService.dao().fill(servicePortal).with(ServicePortalMeta.GROUP).execute();
        result.success(true).data(servicePortal);
        return result;
    }

    /**
     * 批量获取服务门户 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取服务门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServicePortalVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServicePortalServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServicePortalServiceProxy.GET_BY_IDS)
    public Result<List<ServicePortal>> getByIds(List<String> ids) {
        Result<List<ServicePortal>> result = new Result<>();
        List<ServicePortal> list = servicePortalService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询服务门户
     */
    @ApiOperation(value = "查询服务门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServicePortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.PERM, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.IMAGE, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.URL, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServicePortalVOMeta.PAGE_INDEX, ServicePortalVOMeta.PAGE_SIZE })
    @SentinelResource(value = ServicePortalServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServicePortalServiceProxy.QUERY_LIST)
    public Result<List<ServicePortal>> queryList(ServicePortalVO sample) {
        Result<List<ServicePortal>> result = new Result<>();
        List<ServicePortal> list = servicePortalService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询服务门户
     */
    @ApiOperation(value = "分页查询服务门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServicePortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.PERM, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.IMAGE, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.URL, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServicePortalVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ServicePortalServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServicePortalServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ServicePortal>> queryPagedList(ServicePortalVO sample) {
        Result<PagedList<ServicePortal>> result = new Result<>();
        PagedList<ServicePortal> list = servicePortalService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        servicePortalService.dao().fill(list).with(ServicePortalMeta.GROUP).execute();
        result.success(true).data(list);
        return result;
    }
}
