package com.dt.platform.eam.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.domain.eam.AssetMaintenanceRecord;
import com.dt.platform.domain.eam.AssetMaintenanceRecordVO;
import com.dt.platform.domain.eam.meta.AssetMaintenanceRecordMeta;
import com.dt.platform.domain.eam.meta.AssetMaintenanceRecordVOMeta;
import com.dt.platform.eam.service.IAssetMaintenanceRecordService;
import com.dt.platform.proxy.eam.AssetMaintenanceRecordServiceProxy;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.github.foxnic.api.swagger.InDoc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.dao.data.PagedList;
import com.github.foxnic.dao.data.SaveMode;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 维保更新记录接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-28 23:36:43
 */
@InDoc
@Api(tags = "维保更新记录")
@RestController("EamAssetMaintenanceRecordController")
public class AssetMaintenanceRecordController extends SuperController {

    @Autowired
    private IAssetMaintenanceRecordService assetMaintenanceRecordService;

    /**
     * 添加维保更新记录
     */
    @ApiOperation(value = "添加维保更新记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "638473058469806080"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_UPDATE_ID, value = "维保更新", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTAINER_ID, value = "维保厂商", required = false, dataTypeClass = String.class, example = "12121"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTAINER_ID, value = "维保厂商[状态]", required = false, dataTypeClass = String.class, example = "2121212"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTAINER_NAME, value = "维保厂商名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTAINER_NAME, value = "维保厂商名称[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_STATUS, value = "维保状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_STATUS, value = "维保状态[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_METHOD, value = "维保方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_METHOD, value = "维保方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.SUGGEST_MAINTENANCE_METHOD, value = "建议维保方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_SUGGEST_MAINTENANCE_METHOD, value = "建议维保方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_CONTACTS, value = "联系人[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_CONTACT_INFORMATION, value = "联系方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.DIRECTOR, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_DIRECTOR, value = "负责人[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_START_DATE, value = "维保开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_START_DATE, value = "维保开始时间[状态]", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_END_DATE, value = "维保到期时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_END_DATE, value = "维保到期时间[状态]", required = false, dataTypeClass = Date.class),
	@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_NOTES, value = "备注[状态]", required = false, dataTypeClass = String.class, example = "disable")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssetMaintenanceRecordServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetMaintenanceRecordServiceProxy.INSERT)
    public Result insert(AssetMaintenanceRecordVO assetMaintenanceRecordVO) {
        Result result = assetMaintenanceRecordService.insert(assetMaintenanceRecordVO, false);
        return result;
    }

    /**
     * 删除维保更新记录
     */
    @ApiOperation(value = "删除维保更新记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "638473058469806080")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssetMaintenanceRecordServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetMaintenanceRecordServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  assetMaintenanceRecordService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = assetMaintenanceRecordService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除维保更新记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除维保更新记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssetMaintenanceRecordServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetMaintenanceRecordServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assetMaintenanceRecordService.hasRefers(ids);
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
            Result result = assetMaintenanceRecordService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assetMaintenanceRecordService.deleteByIdsLogical(canDeleteIds);
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
     * 更新维保更新记录
     */
    @ApiOperation(value = "更新维保更新记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "638473058469806080"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_UPDATE_ID, value = "维保更新", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTAINER_ID, value = "维保厂商", required = false, dataTypeClass = String.class, example = "12121"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTAINER_ID, value = "维保厂商[状态]", required = false, dataTypeClass = String.class, example = "2121212"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTAINER_NAME, value = "维保厂商名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTAINER_NAME, value = "维保厂商名称[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_STATUS, value = "维保状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_STATUS, value = "维保状态[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_METHOD, value = "维保方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_METHOD, value = "维保方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.SUGGEST_MAINTENANCE_METHOD, value = "建议维保方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_SUGGEST_MAINTENANCE_METHOD, value = "建议维保方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_CONTACTS, value = "联系人[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_CONTACT_INFORMATION, value = "联系方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.DIRECTOR, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_DIRECTOR, value = "负责人[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_START_DATE, value = "维保开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_START_DATE, value = "维保开始时间[状态]", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_END_DATE, value = "维保到期时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_END_DATE, value = "维保到期时间[状态]", required = false, dataTypeClass = Date.class),
	 	@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_NOTES, value = "备注[状态]", required = false, dataTypeClass = String.class, example = "disable")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { AssetMaintenanceRecordVOMeta.PAGE_INDEX, AssetMaintenanceRecordVOMeta.PAGE_SIZE, AssetMaintenanceRecordVOMeta.SEARCH_FIELD, AssetMaintenanceRecordVOMeta.FUZZY_FIELD, AssetMaintenanceRecordVOMeta.SEARCH_VALUE, AssetMaintenanceRecordVOMeta.DIRTY_FIELDS, AssetMaintenanceRecordVOMeta.SORT_FIELD, AssetMaintenanceRecordVOMeta.SORT_TYPE, AssetMaintenanceRecordVOMeta.IDS })
    @SentinelResource(value = AssetMaintenanceRecordServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetMaintenanceRecordServiceProxy.UPDATE)
    public Result update(AssetMaintenanceRecordVO assetMaintenanceRecordVO) {
        Result result = assetMaintenanceRecordService.update(assetMaintenanceRecordVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存维保更新记录
     */
    @ApiOperation(value = "保存维保更新记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "638473058469806080"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_UPDATE_ID, value = "维保更新", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTAINER_ID, value = "维保厂商", required = false, dataTypeClass = String.class, example = "12121"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTAINER_ID, value = "维保厂商[状态]", required = false, dataTypeClass = String.class, example = "2121212"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTAINER_NAME, value = "维保厂商名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTAINER_NAME, value = "维保厂商名称[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_STATUS, value = "维保状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_STATUS, value = "维保状态[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_METHOD, value = "维保方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_METHOD, value = "维保方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.SUGGEST_MAINTENANCE_METHOD, value = "建议维保方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_SUGGEST_MAINTENANCE_METHOD, value = "建议维保方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_CONTACTS, value = "联系人[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_CONTACT_INFORMATION, value = "联系方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.DIRECTOR, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_DIRECTOR, value = "负责人[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_START_DATE, value = "维保开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_START_DATE, value = "维保开始时间[状态]", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_END_DATE, value = "维保到期时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_END_DATE, value = "维保到期时间[状态]", required = false, dataTypeClass = Date.class),
		 @ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_NOTES, value = "备注[状态]", required = false, dataTypeClass = String.class, example = "disable")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetMaintenanceRecordVOMeta.PAGE_INDEX, AssetMaintenanceRecordVOMeta.PAGE_SIZE, AssetMaintenanceRecordVOMeta.SEARCH_FIELD, AssetMaintenanceRecordVOMeta.FUZZY_FIELD, AssetMaintenanceRecordVOMeta.SEARCH_VALUE, AssetMaintenanceRecordVOMeta.DIRTY_FIELDS, AssetMaintenanceRecordVOMeta.SORT_FIELD, AssetMaintenanceRecordVOMeta.SORT_TYPE, AssetMaintenanceRecordVOMeta.IDS })
    @SentinelResource(value = AssetMaintenanceRecordServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetMaintenanceRecordServiceProxy.SAVE)
    public Result save(AssetMaintenanceRecordVO assetMaintenanceRecordVO) {
        Result result = assetMaintenanceRecordService.save(assetMaintenanceRecordVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取维保更新记录
     */
    @ApiOperation(value = "获取维保更新记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssetMaintenanceRecordServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetMaintenanceRecordServiceProxy.GET_BY_ID)
    public Result<AssetMaintenanceRecord> getById(String id) {
        Result<AssetMaintenanceRecord> result = new Result<>();
        AssetMaintenanceRecord assetMaintenanceRecord = assetMaintenanceRecordService.getById(id);
        // join 关联的对象
        assetMaintenanceRecordService.dao().fill(assetMaintenanceRecord).with(AssetMaintenanceRecordMeta.ASSET).with(AssetMaintenanceRecordMeta.MAINTNAINER).with(AssetMaintenanceRecordMeta.ASSET_MAINTENANCE_STATUS).with(AssetMaintenanceRecordMeta.MAINTENANCE_METHOD_DATA).with(AssetMaintenanceRecordMeta.SUGGEST_MAINTENANCE_METHOD_DATA).execute();
        result.success(true).data(assetMaintenanceRecord);
        return result;
    }

    /**
     * 批量获取维保更新记录 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取维保更新记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssetMaintenanceRecordServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetMaintenanceRecordServiceProxy.GET_BY_IDS)
    public Result<List<AssetMaintenanceRecord>> getByIds(List<String> ids) {
        Result<List<AssetMaintenanceRecord>> result = new Result<>();
        List<AssetMaintenanceRecord> list = assetMaintenanceRecordService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询维保更新记录
     */
    @ApiOperation(value = "查询维保更新记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "638473058469806080"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_UPDATE_ID, value = "维保更新", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTAINER_ID, value = "维保厂商", required = false, dataTypeClass = String.class, example = "12121"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTAINER_ID, value = "维保厂商[状态]", required = false, dataTypeClass = String.class, example = "2121212"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTAINER_NAME, value = "维保厂商名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTAINER_NAME, value = "维保厂商名称[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_STATUS, value = "维保状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_STATUS, value = "维保状态[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_METHOD, value = "维保方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_METHOD, value = "维保方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.SUGGEST_MAINTENANCE_METHOD, value = "建议维保方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_SUGGEST_MAINTENANCE_METHOD, value = "建议维保方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_CONTACTS, value = "联系人[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_CONTACT_INFORMATION, value = "联系方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.DIRECTOR, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_DIRECTOR, value = "负责人[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_START_DATE, value = "维保开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_START_DATE, value = "维保开始时间[状态]", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_END_DATE, value = "维保到期时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_END_DATE, value = "维保到期时间[状态]", required = false, dataTypeClass = Date.class),
		 @ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_NOTES, value = "备注[状态]", required = false, dataTypeClass = String.class, example = "disable")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { AssetMaintenanceRecordVOMeta.PAGE_INDEX, AssetMaintenanceRecordVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssetMaintenanceRecordServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetMaintenanceRecordServiceProxy.QUERY_LIST)
    public Result<List<AssetMaintenanceRecord>> queryList(AssetMaintenanceRecordVO sample) {
        Result<List<AssetMaintenanceRecord>> result = new Result<>();
        List<AssetMaintenanceRecord> list = assetMaintenanceRecordService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询维保更新记录
     */
    @ApiOperation(value = "分页查询维保更新记录")
    @ApiImplicitParams({
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "638473058469806080"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_UPDATE_ID, value = "维保更新", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTAINER_ID, value = "维保厂商", required = false, dataTypeClass = String.class, example = "12121"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTAINER_ID, value = "维保厂商[状态]", required = false, dataTypeClass = String.class, example = "2121212"),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTAINER_NAME, value = "维保厂商名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTAINER_NAME, value = "维保厂商名称[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_STATUS, value = "维保状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_STATUS, value = "维保状态[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_METHOD, value = "维保方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_METHOD, value = "维保方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.SUGGEST_MAINTENANCE_METHOD, value = "建议维保方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_SUGGEST_MAINTENANCE_METHOD, value = "建议维保方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.CONTACTS, value = "联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_CONTACTS, value = "联系人[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_CONTACT_INFORMATION, value = "联系方式[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.DIRECTOR, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_DIRECTOR, value = "负责人[状态]", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_START_DATE, value = "维保开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_START_DATE, value = "维保开始时间[状态]", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_END_DATE, value = "维保到期时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_END_DATE, value = "维保到期时间[状态]", required = false, dataTypeClass = Date.class),
		 @ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.MAINTENANCE_NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetMaintenanceRecordVOMeta.S_MAINTENANCE_NOTES, value = "备注[状态]", required = false, dataTypeClass = String.class, example = "disable")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = AssetMaintenanceRecordServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetMaintenanceRecordServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssetMaintenanceRecord>> queryPagedList(AssetMaintenanceRecordVO sample) {
        Result<PagedList<AssetMaintenanceRecord>> result = new Result<>();
        PagedList<AssetMaintenanceRecord> list = assetMaintenanceRecordService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        assetMaintenanceRecordService.dao().fill(list).with(AssetMaintenanceRecordMeta.ASSET).with(AssetMaintenanceRecordMeta.ASSET_STATUS).with(AssetMaintenanceRecordMeta.CATEGORY).with(AssetMaintenanceRecordMeta.MAINTNAINER).with(AssetMaintenanceRecordMeta.ASSET_MAINTENANCE_STATUS).with(AssetMaintenanceRecordMeta.MAINTENANCE_METHOD_DATA).with(AssetMaintenanceRecordMeta.SUGGEST_MAINTENANCE_METHOD_DATA).execute();
        result.success(true).data(list);
        return result;
    }
}
