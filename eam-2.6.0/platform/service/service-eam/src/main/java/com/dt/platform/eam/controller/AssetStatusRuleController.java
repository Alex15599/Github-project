package com.dt.platform.eam.controller;

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
import com.dt.platform.proxy.eam.AssetStatusRuleServiceProxy;
import com.dt.platform.domain.eam.meta.AssetStatusRuleVOMeta;
import com.dt.platform.domain.eam.AssetStatusRule;
import com.dt.platform.domain.eam.AssetStatusRuleVO;
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
import com.dt.platform.domain.eam.meta.AssetStatusRuleMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetStatusRuleService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 状态规则 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-07 12:23:17
 */
@Api(tags = "状态规则")
@ApiSort(0)
@RestController("EamAssetStatusRuleController")
public class AssetStatusRuleController extends SuperController {

    @Autowired
    private IAssetStatusRuleService assetStatusRuleService;

    /**
     * 添加状态规则
     */
    @ApiOperation(value = "添加状态规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.OPER_CODE, value = "操作编码", required = false, dataTypeClass = String.class, example = "eam_asset_borrow"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.OPER_CONDITION, value = "条件", required = false, dataTypeClass = String.class, example = "not_in"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AssetStatusRuleServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusRuleServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AssetStatusRuleVO assetStatusRuleVO) {
        Result result = assetStatusRuleService.insert(assetStatusRuleVO, false);
        return result;
    }

    /**
     * 删除状态规则
     */
    @ApiOperation(value = "删除状态规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AssetStatusRuleServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusRuleServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  assetStatusRuleService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = assetStatusRuleService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除状态规则 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除状态规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetStatusRuleServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusRuleServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assetStatusRuleService.hasRefers(ids);
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
            Result result = assetStatusRuleService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assetStatusRuleService.deleteByIdsLogical(canDeleteIds);
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
     * 更新状态规则
     */
    @ApiOperation(value = "更新状态规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.OPER_CODE, value = "操作编码", required = false, dataTypeClass = String.class, example = "eam_asset_borrow"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.OPER_CONDITION, value = "条件", required = false, dataTypeClass = String.class, example = "not_in"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AssetStatusRuleVOMeta.PAGE_INDEX, AssetStatusRuleVOMeta.PAGE_SIZE, AssetStatusRuleVOMeta.SEARCH_FIELD, AssetStatusRuleVOMeta.FUZZY_FIELD, AssetStatusRuleVOMeta.SEARCH_VALUE, AssetStatusRuleVOMeta.DIRTY_FIELDS, AssetStatusRuleVOMeta.SORT_FIELD, AssetStatusRuleVOMeta.SORT_TYPE, AssetStatusRuleVOMeta.IDS })
    @SentinelResource(value = AssetStatusRuleServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusRuleServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AssetStatusRuleVO assetStatusRuleVO) {
        Result result = assetStatusRuleService.update(assetStatusRuleVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存状态规则
     */
    @ApiOperation(value = "保存状态规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.OPER_CODE, value = "操作编码", required = false, dataTypeClass = String.class, example = "eam_asset_borrow"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.OPER_CONDITION, value = "条件", required = false, dataTypeClass = String.class, example = "not_in"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetStatusRuleVOMeta.PAGE_INDEX, AssetStatusRuleVOMeta.PAGE_SIZE, AssetStatusRuleVOMeta.SEARCH_FIELD, AssetStatusRuleVOMeta.FUZZY_FIELD, AssetStatusRuleVOMeta.SEARCH_VALUE, AssetStatusRuleVOMeta.DIRTY_FIELDS, AssetStatusRuleVOMeta.SORT_FIELD, AssetStatusRuleVOMeta.SORT_TYPE, AssetStatusRuleVOMeta.IDS })
    @SentinelResource(value = AssetStatusRuleServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusRuleServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AssetStatusRuleVO assetStatusRuleVO) {
        Result result = assetStatusRuleService.save(assetStatusRuleVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取状态规则
     */
    @ApiOperation(value = "获取状态规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AssetStatusRuleServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusRuleServiceProxy.GET_BY_ID)
    public Result<AssetStatusRule> getById(String id) {
        Result<AssetStatusRule> result = new Result<>();
        AssetStatusRule assetStatusRule = assetStatusRuleService.getById(id);
        result.success(true).data(assetStatusRule);
        return result;
    }

    /**
     * 批量获取状态规则 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取状态规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetStatusRuleServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusRuleServiceProxy.GET_BY_IDS)
    public Result<List<AssetStatusRule>> getByIds(List<String> ids) {
        Result<List<AssetStatusRule>> result = new Result<>();
        List<AssetStatusRule> list = assetStatusRuleService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询状态规则
     */
    @ApiOperation(value = "查询状态规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.OPER_CODE, value = "操作编码", required = false, dataTypeClass = String.class, example = "eam_asset_borrow"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.OPER_CONDITION, value = "条件", required = false, dataTypeClass = String.class, example = "not_in"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetStatusRuleVOMeta.PAGE_INDEX, AssetStatusRuleVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssetStatusRuleServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusRuleServiceProxy.QUERY_LIST)
    public Result<List<AssetStatusRule>> queryList(AssetStatusRuleVO sample) {
        Result<List<AssetStatusRule>> result = new Result<>();
        List<AssetStatusRule> list = assetStatusRuleService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询状态规则
     */
    @ApiOperation(value = "分页查询状态规则")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.OPER_CODE, value = "操作编码", required = false, dataTypeClass = String.class, example = "eam_asset_borrow"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.OPER_CONDITION, value = "条件", required = false, dataTypeClass = String.class, example = "not_in"),
		@ApiImplicitParam(name = AssetStatusRuleVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AssetStatusRuleServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusRuleServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssetStatusRule>> queryPagedList(AssetStatusRuleVO sample) {
        Result<PagedList<AssetStatusRule>> result = new Result<>();
        PagedList<AssetStatusRule> list = assetStatusRuleService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
