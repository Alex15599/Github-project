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
import com.dt.platform.proxy.eam.AssetDepreciationHistoryServiceProxy;
import com.dt.platform.domain.eam.meta.AssetDepreciationHistoryVOMeta;
import com.dt.platform.domain.eam.AssetDepreciationHistory;
import com.dt.platform.domain.eam.AssetDepreciationHistoryVO;
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
import com.dt.platform.domain.eam.meta.AssetDepreciationHistoryMeta;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetDepreciationHistoryService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 折旧历史 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-04 17:13:19
 */
@Api(tags = "折旧历史")
@ApiSort(0)
@RestController("EamAssetDepreciationHistoryController")
public class AssetDepreciationHistoryController extends SuperController {

    @Autowired
    private IAssetDepreciationHistoryService assetDepreciationHistoryService;

    /**
     * 添加折旧历史
     */
    @ApiOperation(value = "添加折旧历史")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ASSET_CODE, value = "资产编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.DEPRECIATION_METHOD, value = "折旧方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ORIGINAL_UNIT_PRICE, value = "资产原值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.BEFORE_PRICE, value = "折旧前价格", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.AFTER_PRICE, value = "折旧后价格", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.DEPRECIATION_PRICE, value = "折旧额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AssetDepreciationHistoryServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDepreciationHistoryServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AssetDepreciationHistoryVO assetDepreciationHistoryVO) {
        Result result = assetDepreciationHistoryService.insert(assetDepreciationHistoryVO, false);
        return result;
    }

    /**
     * 删除折旧历史
     */
    @ApiOperation(value = "删除折旧历史")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AssetDepreciationHistoryServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDepreciationHistoryServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  assetDepreciationHistoryService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = assetDepreciationHistoryService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除折旧历史 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除折旧历史")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetDepreciationHistoryServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDepreciationHistoryServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assetDepreciationHistoryService.hasRefers(ids);
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
            Result result = assetDepreciationHistoryService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assetDepreciationHistoryService.deleteByIdsLogical(canDeleteIds);
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
     * 更新折旧历史
     */
    @ApiOperation(value = "更新折旧历史")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ASSET_CODE, value = "资产编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.DEPRECIATION_METHOD, value = "折旧方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ORIGINAL_UNIT_PRICE, value = "资产原值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.BEFORE_PRICE, value = "折旧前价格", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.AFTER_PRICE, value = "折旧后价格", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.DEPRECIATION_PRICE, value = "折旧额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AssetDepreciationHistoryVOMeta.PAGE_INDEX, AssetDepreciationHistoryVOMeta.PAGE_SIZE, AssetDepreciationHistoryVOMeta.SEARCH_FIELD, AssetDepreciationHistoryVOMeta.FUZZY_FIELD, AssetDepreciationHistoryVOMeta.SEARCH_VALUE, AssetDepreciationHistoryVOMeta.DIRTY_FIELDS, AssetDepreciationHistoryVOMeta.SORT_FIELD, AssetDepreciationHistoryVOMeta.SORT_TYPE, AssetDepreciationHistoryVOMeta.IDS })
    @SentinelResource(value = AssetDepreciationHistoryServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDepreciationHistoryServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AssetDepreciationHistoryVO assetDepreciationHistoryVO) {
        Result result = assetDepreciationHistoryService.update(assetDepreciationHistoryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存折旧历史
     */
    @ApiOperation(value = "保存折旧历史")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ASSET_CODE, value = "资产编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.DEPRECIATION_METHOD, value = "折旧方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ORIGINAL_UNIT_PRICE, value = "资产原值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.BEFORE_PRICE, value = "折旧前价格", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.AFTER_PRICE, value = "折旧后价格", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.DEPRECIATION_PRICE, value = "折旧额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetDepreciationHistoryVOMeta.PAGE_INDEX, AssetDepreciationHistoryVOMeta.PAGE_SIZE, AssetDepreciationHistoryVOMeta.SEARCH_FIELD, AssetDepreciationHistoryVOMeta.FUZZY_FIELD, AssetDepreciationHistoryVOMeta.SEARCH_VALUE, AssetDepreciationHistoryVOMeta.DIRTY_FIELDS, AssetDepreciationHistoryVOMeta.SORT_FIELD, AssetDepreciationHistoryVOMeta.SORT_TYPE, AssetDepreciationHistoryVOMeta.IDS })
    @SentinelResource(value = AssetDepreciationHistoryServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDepreciationHistoryServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AssetDepreciationHistoryVO assetDepreciationHistoryVO) {
        Result result = assetDepreciationHistoryService.save(assetDepreciationHistoryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取折旧历史
     */
    @ApiOperation(value = "获取折旧历史")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AssetDepreciationHistoryServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDepreciationHistoryServiceProxy.GET_BY_ID)
    public Result<AssetDepreciationHistory> getById(String id) {
        Result<AssetDepreciationHistory> result = new Result<>();
        AssetDepreciationHistory assetDepreciationHistory = assetDepreciationHistoryService.getById(id);
        // join 关联的对象
        assetDepreciationHistoryService.dao().fill(assetDepreciationHistory).with(AssetDepreciationHistoryMeta.ASSET).execute();
        result.success(true).data(assetDepreciationHistory);
        return result;
    }

    /**
     * 批量获取折旧历史 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取折旧历史")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetDepreciationHistoryServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDepreciationHistoryServiceProxy.GET_BY_IDS)
    public Result<List<AssetDepreciationHistory>> getByIds(List<String> ids) {
        Result<List<AssetDepreciationHistory>> result = new Result<>();
        List<AssetDepreciationHistory> list = assetDepreciationHistoryService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询折旧历史
     */
    @ApiOperation(value = "查询折旧历史")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ASSET_CODE, value = "资产编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.DEPRECIATION_METHOD, value = "折旧方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ORIGINAL_UNIT_PRICE, value = "资产原值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.BEFORE_PRICE, value = "折旧前价格", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.AFTER_PRICE, value = "折旧后价格", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.DEPRECIATION_PRICE, value = "折旧额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetDepreciationHistoryVOMeta.PAGE_INDEX, AssetDepreciationHistoryVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssetDepreciationHistoryServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDepreciationHistoryServiceProxy.QUERY_LIST)
    public Result<List<AssetDepreciationHistory>> queryList(AssetDepreciationHistoryVO sample) {
        Result<List<AssetDepreciationHistory>> result = new Result<>();
        List<AssetDepreciationHistory> list = assetDepreciationHistoryService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询折旧历史
     */
    @ApiOperation(value = "分页查询折旧历史")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ASSET_ID, value = "资产", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ASSET_CODE, value = "资产编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.DEPRECIATION_METHOD, value = "折旧方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.ORIGINAL_UNIT_PRICE, value = "资产原值", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.BEFORE_PRICE, value = "折旧前价格", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.AFTER_PRICE, value = "折旧后价格", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.DEPRECIATION_PRICE, value = "折旧额", required = false, dataTypeClass = BigDecimal.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.OPER_USER_ID, value = "操作人员", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetDepreciationHistoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AssetDepreciationHistoryServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetDepreciationHistoryServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssetDepreciationHistory>> queryPagedList(AssetDepreciationHistoryVO sample) {
        Result<PagedList<AssetDepreciationHistory>> result = new Result<>();
        PagedList<AssetDepreciationHistory> list = assetDepreciationHistoryService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        assetDepreciationHistoryService.dao().fill(list).with(AssetDepreciationHistoryMeta.ASSET).execute();
        result.success(true).data(list);
        return result;
    }
}
