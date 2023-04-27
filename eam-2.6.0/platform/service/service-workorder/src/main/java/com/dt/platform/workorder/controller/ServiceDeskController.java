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
import com.dt.platform.proxy.workorder.ServiceDeskServiceProxy;
import com.dt.platform.domain.workorder.meta.ServiceDeskVOMeta;
import com.dt.platform.domain.workorder.ServiceDesk;
import com.dt.platform.domain.workorder.ServiceDeskVO;
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
import com.dt.platform.domain.workorder.meta.ServiceDeskMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.workorder.service.IServiceDeskService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 服务台 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-07 07:36:40
 */
@Api(tags = "服务台")
@ApiSort(0)
@RestController("WoServiceDeskController")
public class ServiceDeskController extends SuperController {

    @Autowired
    private IServiceDeskService serviceDeskService;

    /**
     * 添加服务台
     */
    @ApiOperation(value = "添加服务台")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceDeskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PROCESS_CODE, value = "流程编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PERM, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.IMAGE, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PARAMETER, value = "参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ServiceDeskServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceDeskServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ServiceDeskVO serviceDeskVO) {
        Result result = serviceDeskService.insert(serviceDeskVO, false);
        return result;
    }

    /**
     * 删除服务台
     */
    @ApiOperation(value = "删除服务台")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceDeskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ServiceDeskServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceDeskServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  serviceDeskService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = serviceDeskService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除服务台 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除服务台")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceDeskVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServiceDeskServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceDeskServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = serviceDeskService.hasRefers(ids);
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
            Result result = serviceDeskService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = serviceDeskService.deleteByIdsLogical(canDeleteIds);
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
     * 更新服务台
     */
    @ApiOperation(value = "更新服务台")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceDeskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PROCESS_CODE, value = "流程编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PERM, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.IMAGE, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PARAMETER, value = "参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { ServiceDeskVOMeta.PAGE_INDEX, ServiceDeskVOMeta.PAGE_SIZE, ServiceDeskVOMeta.SEARCH_FIELD, ServiceDeskVOMeta.FUZZY_FIELD, ServiceDeskVOMeta.SEARCH_VALUE, ServiceDeskVOMeta.DIRTY_FIELDS, ServiceDeskVOMeta.SORT_FIELD, ServiceDeskVOMeta.SORT_TYPE, ServiceDeskVOMeta.IDS })
    @SentinelResource(value = ServiceDeskServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceDeskServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ServiceDeskVO serviceDeskVO) {
        Result result = serviceDeskService.update(serviceDeskVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存服务台
     */
    @ApiOperation(value = "保存服务台")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceDeskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PROCESS_CODE, value = "流程编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PERM, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.IMAGE, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PARAMETER, value = "参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServiceDeskVOMeta.PAGE_INDEX, ServiceDeskVOMeta.PAGE_SIZE, ServiceDeskVOMeta.SEARCH_FIELD, ServiceDeskVOMeta.FUZZY_FIELD, ServiceDeskVOMeta.SEARCH_VALUE, ServiceDeskVOMeta.DIRTY_FIELDS, ServiceDeskVOMeta.SORT_FIELD, ServiceDeskVOMeta.SORT_TYPE, ServiceDeskVOMeta.IDS })
    @SentinelResource(value = ServiceDeskServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceDeskServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ServiceDeskVO serviceDeskVO) {
        Result result = serviceDeskService.save(serviceDeskVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取服务台
     */
    @ApiOperation(value = "获取服务台")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceDeskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ServiceDeskServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceDeskServiceProxy.GET_BY_ID)
    public Result<ServiceDesk> getById(String id) {
        Result<ServiceDesk> result = new Result<>();
        ServiceDesk serviceDesk = serviceDeskService.getById(id);
        result.success(true).data(serviceDesk);
        return result;
    }

    /**
     * 批量获取服务台 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取服务台")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceDeskVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ServiceDeskServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceDeskServiceProxy.GET_BY_IDS)
    public Result<List<ServiceDesk>> getByIds(List<String> ids) {
        Result<List<ServiceDesk>> result = new Result<>();
        List<ServiceDesk> list = serviceDeskService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询服务台
     */
    @ApiOperation(value = "查询服务台")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceDeskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PROCESS_CODE, value = "流程编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PERM, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.IMAGE, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PARAMETER, value = "参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ServiceDeskVOMeta.PAGE_INDEX, ServiceDeskVOMeta.PAGE_SIZE })
    @SentinelResource(value = ServiceDeskServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceDeskServiceProxy.QUERY_LIST)
    public Result<List<ServiceDesk>> queryList(ServiceDeskVO sample) {
        Result<List<ServiceDesk>> result = new Result<>();
        List<ServiceDesk> list = serviceDeskService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询服务台
     */
    @ApiOperation(value = "分页查询服务台")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ServiceDeskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PROCESS_CODE, value = "流程编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PERM, value = "权限", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.IMAGE, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.PARAMETER, value = "参数", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ServiceDeskVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ServiceDeskServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ServiceDeskServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ServiceDesk>> queryPagedList(ServiceDeskVO sample) {
        Result<PagedList<ServiceDesk>> result = new Result<>();
        PagedList<ServiceDesk> list = serviceDeskService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
