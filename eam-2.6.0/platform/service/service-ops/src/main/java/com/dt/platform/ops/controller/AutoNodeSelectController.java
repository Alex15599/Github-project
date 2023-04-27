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
import com.dt.platform.proxy.ops.AutoNodeSelectServiceProxy;
import com.dt.platform.domain.ops.meta.AutoNodeSelectVOMeta;
import com.dt.platform.domain.ops.AutoNodeSelect;
import com.dt.platform.domain.ops.AutoNodeSelectVO;
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
import com.dt.platform.domain.ops.meta.AutoNodeSelectMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IAutoNodeSelectService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 节点选择 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 21:24:47
 */
@Api(tags = "节点选择")
@ApiSort(0)
@RestController("OpsAutoNodeSelectController")
public class AutoNodeSelectController extends SuperController {

    @Autowired
    private IAutoNodeSelectService autoNodeSelectService;

    /**
     * 添加节点选择
     */
    @ApiOperation(value = "添加节点选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614202302030413824"),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class, example = "614080623438467072"),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class, example = "1661173235000")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AutoNodeSelectServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoNodeSelectServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AutoNodeSelectVO autoNodeSelectVO) {
        Result result = autoNodeSelectService.insert(autoNodeSelectVO, false);
        return result;
    }

    /**
     * 删除节点选择
     */
    @ApiOperation(value = "删除节点选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614202302030413824")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AutoNodeSelectServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoNodeSelectServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  autoNodeSelectService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = autoNodeSelectService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除节点选择 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除节点选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoNodeSelectServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoNodeSelectServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = autoNodeSelectService.hasRefers(ids);
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
            Result result = autoNodeSelectService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = autoNodeSelectService.deleteByIdsLogical(canDeleteIds);
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
     * 更新节点选择
     */
    @ApiOperation(value = "更新节点选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614202302030413824"),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class, example = "614080623438467072"),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class, example = "1661173235000")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AutoNodeSelectVOMeta.PAGE_INDEX, AutoNodeSelectVOMeta.PAGE_SIZE, AutoNodeSelectVOMeta.SEARCH_FIELD, AutoNodeSelectVOMeta.FUZZY_FIELD, AutoNodeSelectVOMeta.SEARCH_VALUE, AutoNodeSelectVOMeta.DIRTY_FIELDS, AutoNodeSelectVOMeta.SORT_FIELD, AutoNodeSelectVOMeta.SORT_TYPE, AutoNodeSelectVOMeta.IDS })
    @SentinelResource(value = AutoNodeSelectServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoNodeSelectServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AutoNodeSelectVO autoNodeSelectVO) {
        Result result = autoNodeSelectService.update(autoNodeSelectVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存节点选择
     */
    @ApiOperation(value = "保存节点选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614202302030413824"),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class, example = "614080623438467072"),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class, example = "1661173235000")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoNodeSelectVOMeta.PAGE_INDEX, AutoNodeSelectVOMeta.PAGE_SIZE, AutoNodeSelectVOMeta.SEARCH_FIELD, AutoNodeSelectVOMeta.FUZZY_FIELD, AutoNodeSelectVOMeta.SEARCH_VALUE, AutoNodeSelectVOMeta.DIRTY_FIELDS, AutoNodeSelectVOMeta.SORT_FIELD, AutoNodeSelectVOMeta.SORT_TYPE, AutoNodeSelectVOMeta.IDS })
    @SentinelResource(value = AutoNodeSelectServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoNodeSelectServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AutoNodeSelectVO autoNodeSelectVO) {
        Result result = autoNodeSelectService.save(autoNodeSelectVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取节点选择
     */
    @ApiOperation(value = "获取节点选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AutoNodeSelectServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoNodeSelectServiceProxy.GET_BY_ID)
    public Result<AutoNodeSelect> getById(String id) {
        Result<AutoNodeSelect> result = new Result<>();
        AutoNodeSelect autoNodeSelect = autoNodeSelectService.getById(id);
        result.success(true).data(autoNodeSelect);
        return result;
    }

    /**
     * 批量获取节点选择 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取节点选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoNodeSelectServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoNodeSelectServiceProxy.GET_BY_IDS)
    public Result<List<AutoNodeSelect>> getByIds(List<String> ids) {
        Result<List<AutoNodeSelect>> result = new Result<>();
        List<AutoNodeSelect> list = autoNodeSelectService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询节点选择
     */
    @ApiOperation(value = "查询节点选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614202302030413824"),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class, example = "614080623438467072"),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class, example = "1661173235000")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoNodeSelectVOMeta.PAGE_INDEX, AutoNodeSelectVOMeta.PAGE_SIZE })
    @SentinelResource(value = AutoNodeSelectServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoNodeSelectServiceProxy.QUERY_LIST)
    public Result<List<AutoNodeSelect>> queryList(AutoNodeSelectVO sample) {
        Result<List<AutoNodeSelect>> result = new Result<>();
        List<AutoNodeSelect> list = autoNodeSelectService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询节点选择
     */
    @ApiOperation(value = "分页查询节点选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614202302030413824"),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class, example = "614080623438467072"),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoNodeSelectVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class, example = "1661173235000")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AutoNodeSelectServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoNodeSelectServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AutoNodeSelect>> queryPagedList(AutoNodeSelectVO sample) {
        Result<PagedList<AutoNodeSelect>> result = new Result<>();
        PagedList<AutoNodeSelect> list = autoNodeSelectService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
