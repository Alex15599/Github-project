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
import com.dt.platform.proxy.workorder.ServiceMyPortalServiceProxy;
import com.dt.platform.domain.workorder.meta.ServiceMyPortalVOMeta;
import com.dt.platform.domain.workorder.ServiceMyPortal;
import com.dt.platform.domain.workorder.ServiceMyPortalVO;
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
import com.dt.platform.domain.workorder.meta.ServiceMyPortalMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.workorder.service.IServiceMyPortalService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 我的门户 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-08 21:59:47
 */
@Api(tags = "我的门户")
@ApiSort(0)
@RestController("WoServiceMyPortalController")
public class ServiceMyPortalController extends SuperController {

    @Autowired
    private IServiceMyPortalService serviceMyPortalService;

    /**
     * 添加我的门户
     */
    @ApiOperation(value = "添加我的门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.PORTAL_ID, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.USER_ID, value = "我的", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ServiceMyPortalServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceMyPortalServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ServiceMyPortalVO serviceMyPortalVO) {
        Result result = serviceMyPortalService.insert(serviceMyPortalVO, false);
        return result;
    }

    /**
     * 删除我的门户
     */
    @ApiOperation(value = "删除我的门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ServiceMyPortalServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceMyPortalServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  serviceMyPortalService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = serviceMyPortalService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除我的门户 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除我的门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServiceMyPortalServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceMyPortalServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = serviceMyPortalService.hasRefers(ids);
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
            Result result = serviceMyPortalService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = serviceMyPortalService.deleteByIdsLogical(canDeleteIds);
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
     * 更新我的门户
     */
    @ApiOperation(value = "更新我的门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.PORTAL_ID, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.USER_ID, value = "我的", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { ServiceMyPortalVOMeta.PAGE_INDEX, ServiceMyPortalVOMeta.PAGE_SIZE, ServiceMyPortalVOMeta.SEARCH_FIELD, ServiceMyPortalVOMeta.FUZZY_FIELD, ServiceMyPortalVOMeta.SEARCH_VALUE, ServiceMyPortalVOMeta.DIRTY_FIELDS, ServiceMyPortalVOMeta.SORT_FIELD, ServiceMyPortalVOMeta.SORT_TYPE, ServiceMyPortalVOMeta.IDS })
    @SentinelResource(value = ServiceMyPortalServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceMyPortalServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ServiceMyPortalVO serviceMyPortalVO) {
        Result result = serviceMyPortalService.update(serviceMyPortalVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存我的门户
     */
    @ApiOperation(value = "保存我的门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.PORTAL_ID, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.USER_ID, value = "我的", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServiceMyPortalVOMeta.PAGE_INDEX, ServiceMyPortalVOMeta.PAGE_SIZE, ServiceMyPortalVOMeta.SEARCH_FIELD, ServiceMyPortalVOMeta.FUZZY_FIELD, ServiceMyPortalVOMeta.SEARCH_VALUE, ServiceMyPortalVOMeta.DIRTY_FIELDS, ServiceMyPortalVOMeta.SORT_FIELD, ServiceMyPortalVOMeta.SORT_TYPE, ServiceMyPortalVOMeta.IDS })
    @SentinelResource(value = ServiceMyPortalServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceMyPortalServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ServiceMyPortalVO serviceMyPortalVO) {
        Result result = serviceMyPortalService.save(serviceMyPortalVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取我的门户
     */
    @ApiOperation(value = "获取我的门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ServiceMyPortalServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceMyPortalServiceProxy.GET_BY_ID)
    public Result<ServiceMyPortal> getById(String id) {
        Result<ServiceMyPortal> result = new Result<>();
        ServiceMyPortal serviceMyPortal = serviceMyPortalService.getById(id);
        result.success(true).data(serviceMyPortal);
        return result;
    }

    /**
     * 批量获取我的门户 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取我的门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServiceMyPortalServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceMyPortalServiceProxy.GET_BY_IDS)
    public Result<List<ServiceMyPortal>> getByIds(List<String> ids) {
        Result<List<ServiceMyPortal>> result = new Result<>();
        List<ServiceMyPortal> list = serviceMyPortalService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询我的门户
     */
    @ApiOperation(value = "查询我的门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.PORTAL_ID, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.USER_ID, value = "我的", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServiceMyPortalVOMeta.PAGE_INDEX, ServiceMyPortalVOMeta.PAGE_SIZE })
    @SentinelResource(value = ServiceMyPortalServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceMyPortalServiceProxy.QUERY_LIST)
    public Result<List<ServiceMyPortal>> queryList(ServiceMyPortalVO sample) {
        Result<List<ServiceMyPortal>> result = new Result<>();
        List<ServiceMyPortal> list = serviceMyPortalService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询我的门户
     */
    @ApiOperation(value = "分页查询我的门户")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.PORTAL_ID, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceMyPortalVOMeta.USER_ID, value = "我的", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ServiceMyPortalServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceMyPortalServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ServiceMyPortal>> queryPagedList(ServiceMyPortalVO sample) {
        Result<PagedList<ServiceMyPortal>> result = new Result<>();
        PagedList<ServiceMyPortal> list = serviceMyPortalService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
