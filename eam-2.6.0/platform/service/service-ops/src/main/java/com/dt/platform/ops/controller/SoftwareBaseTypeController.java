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
import com.dt.platform.proxy.ops.SoftwareBaseTypeServiceProxy;
import com.dt.platform.domain.ops.meta.SoftwareBaseTypeVOMeta;
import com.dt.platform.domain.ops.SoftwareBaseType;
import com.dt.platform.domain.ops.SoftwareBaseTypeVO;
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
import com.dt.platform.domain.ops.meta.SoftwareBaseTypeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.ISoftwareBaseTypeService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 软件基线类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-16 08:29:28
 */
@Api(tags = "软件基线类型")
@ApiSort(0)
@RestController("OpsSoftwareBaseTypeController")
public class SoftwareBaseTypeController extends SuperController {

    @Autowired
    private ISoftwareBaseTypeService softwareBaseTypeService;

    /**
     * 添加软件基线类型
     */
    @ApiOperation(value = "添加软件基线类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "操作系统"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = SoftwareBaseTypeServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareBaseTypeServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(SoftwareBaseTypeVO softwareBaseTypeVO) {
        Result result = softwareBaseTypeService.insert(softwareBaseTypeVO, false);
        return result;
    }

    /**
     * 删除软件基线类型
     */
    @ApiOperation(value = "删除软件基线类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "593841519329288192")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = SoftwareBaseTypeServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareBaseTypeServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  softwareBaseTypeService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = softwareBaseTypeService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除软件基线类型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除软件基线类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = SoftwareBaseTypeServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareBaseTypeServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = softwareBaseTypeService.hasRefers(ids);
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
            Result result = softwareBaseTypeService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = softwareBaseTypeService.deleteByIdsLogical(canDeleteIds);
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
     * 更新软件基线类型
     */
    @ApiOperation(value = "更新软件基线类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "操作系统"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { SoftwareBaseTypeVOMeta.PAGE_INDEX, SoftwareBaseTypeVOMeta.PAGE_SIZE, SoftwareBaseTypeVOMeta.SEARCH_FIELD, SoftwareBaseTypeVOMeta.FUZZY_FIELD, SoftwareBaseTypeVOMeta.SEARCH_VALUE, SoftwareBaseTypeVOMeta.DIRTY_FIELDS, SoftwareBaseTypeVOMeta.SORT_FIELD, SoftwareBaseTypeVOMeta.SORT_TYPE, SoftwareBaseTypeVOMeta.IDS })
    @SentinelResource(value = SoftwareBaseTypeServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareBaseTypeServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(SoftwareBaseTypeVO softwareBaseTypeVO) {
        Result result = softwareBaseTypeService.update(softwareBaseTypeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存软件基线类型
     */
    @ApiOperation(value = "保存软件基线类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "操作系统"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { SoftwareBaseTypeVOMeta.PAGE_INDEX, SoftwareBaseTypeVOMeta.PAGE_SIZE, SoftwareBaseTypeVOMeta.SEARCH_FIELD, SoftwareBaseTypeVOMeta.FUZZY_FIELD, SoftwareBaseTypeVOMeta.SEARCH_VALUE, SoftwareBaseTypeVOMeta.DIRTY_FIELDS, SoftwareBaseTypeVOMeta.SORT_FIELD, SoftwareBaseTypeVOMeta.SORT_TYPE, SoftwareBaseTypeVOMeta.IDS })
    @SentinelResource(value = SoftwareBaseTypeServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareBaseTypeServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(SoftwareBaseTypeVO softwareBaseTypeVO) {
        Result result = softwareBaseTypeService.save(softwareBaseTypeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取软件基线类型
     */
    @ApiOperation(value = "获取软件基线类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = SoftwareBaseTypeServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareBaseTypeServiceProxy.GET_BY_ID)
    public Result<SoftwareBaseType> getById(String id) {
        Result<SoftwareBaseType> result = new Result<>();
        SoftwareBaseType softwareBaseType = softwareBaseTypeService.getById(id);
        result.success(true).data(softwareBaseType);
        return result;
    }

    /**
     * 批量获取软件基线类型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取软件基线类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = SoftwareBaseTypeServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareBaseTypeServiceProxy.GET_BY_IDS)
    public Result<List<SoftwareBaseType>> getByIds(List<String> ids) {
        Result<List<SoftwareBaseType>> result = new Result<>();
        List<SoftwareBaseType> list = softwareBaseTypeService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询软件基线类型
     */
    @ApiOperation(value = "查询软件基线类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "操作系统"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { SoftwareBaseTypeVOMeta.PAGE_INDEX, SoftwareBaseTypeVOMeta.PAGE_SIZE })
    @SentinelResource(value = SoftwareBaseTypeServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareBaseTypeServiceProxy.QUERY_LIST)
    public Result<List<SoftwareBaseType>> queryList(SoftwareBaseTypeVO sample) {
        Result<List<SoftwareBaseType>> result = new Result<>();
        List<SoftwareBaseType> list = softwareBaseTypeService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询软件基线类型
     */
    @ApiOperation(value = "分页查询软件基线类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "593841519329288192"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "操作系统"),
		@ApiImplicitParam(name = SoftwareBaseTypeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = SoftwareBaseTypeServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareBaseTypeServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<SoftwareBaseType>> queryPagedList(SoftwareBaseTypeVO sample) {
        Result<PagedList<SoftwareBaseType>> result = new Result<>();
        PagedList<SoftwareBaseType> list = softwareBaseTypeService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
