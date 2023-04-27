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
import com.dt.platform.proxy.eam.AssetStatusServiceProxy;
import com.dt.platform.domain.eam.meta.AssetStatusVOMeta;
import com.dt.platform.domain.eam.AssetStatus;
import com.dt.platform.domain.eam.AssetStatusVO;
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
import com.dt.platform.domain.eam.meta.AssetStatusMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetStatusService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 资产状态 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-06 09:44:10
 */
@Api(tags = "资产状态")
@ApiSort(0)
@RestController("EamAssetStatusController")
public class AssetStatusController extends SuperController {

    @Autowired
    private IAssetStatusService assetStatusService;

    /**
     * 添加资产状态
     */
    @ApiOperation(value = "添加资产状态")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AssetStatusServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AssetStatusVO assetStatusVO) {
        Result result = assetStatusService.insert(assetStatusVO, false);
        return result;
    }

    /**
     * 删除资产状态
     */
    @ApiOperation(value = "删除资产状态")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AssetStatusServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  assetStatusService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = assetStatusService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除资产状态 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除资产状态")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetStatusServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assetStatusService.hasRefers(ids);
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
            Result result = assetStatusService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assetStatusService.deleteByIdsLogical(canDeleteIds);
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
     * 更新资产状态
     */
    @ApiOperation(value = "更新资产状态")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AssetStatusVOMeta.PAGE_INDEX, AssetStatusVOMeta.PAGE_SIZE, AssetStatusVOMeta.SEARCH_FIELD, AssetStatusVOMeta.FUZZY_FIELD, AssetStatusVOMeta.SEARCH_VALUE, AssetStatusVOMeta.DIRTY_FIELDS, AssetStatusVOMeta.SORT_FIELD, AssetStatusVOMeta.SORT_TYPE, AssetStatusVOMeta.IDS })
    @SentinelResource(value = AssetStatusServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AssetStatusVO assetStatusVO) {
        Result result = assetStatusService.update(assetStatusVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存资产状态
     */
    @ApiOperation(value = "保存资产状态")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetStatusVOMeta.PAGE_INDEX, AssetStatusVOMeta.PAGE_SIZE, AssetStatusVOMeta.SEARCH_FIELD, AssetStatusVOMeta.FUZZY_FIELD, AssetStatusVOMeta.SEARCH_VALUE, AssetStatusVOMeta.DIRTY_FIELDS, AssetStatusVOMeta.SORT_FIELD, AssetStatusVOMeta.SORT_TYPE, AssetStatusVOMeta.IDS })
    @SentinelResource(value = AssetStatusServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AssetStatusVO assetStatusVO) {
        Result result = assetStatusService.save(assetStatusVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取资产状态
     */
    @ApiOperation(value = "获取资产状态")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AssetStatusServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusServiceProxy.GET_BY_ID)
    public Result<AssetStatus> getById(String id) {
        Result<AssetStatus> result = new Result<>();
        AssetStatus assetStatus = assetStatusService.getById(id);
        result.success(true).data(assetStatus);
        return result;
    }

    /**
     * 批量获取资产状态 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取资产状态")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetStatusServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusServiceProxy.GET_BY_IDS)
    public Result<List<AssetStatus>> getByIds(List<String> ids) {
        Result<List<AssetStatus>> result = new Result<>();
        List<AssetStatus> list = assetStatusService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询资产状态
     */
    @ApiOperation(value = "查询资产状态")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetStatusVOMeta.PAGE_INDEX, AssetStatusVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssetStatusServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusServiceProxy.QUERY_LIST)
    public Result<List<AssetStatus>> queryList(AssetStatusVO sample) {
        Result<List<AssetStatus>> result = new Result<>();
        List<AssetStatus> list = assetStatusService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询资产状态
     */
    @ApiOperation(value = "分页查询资产状态")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetStatusVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class),
		@ApiImplicitParam(name = AssetStatusVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AssetStatusServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetStatusServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssetStatus>> queryPagedList(AssetStatusVO sample) {
        Result<PagedList<AssetStatus>> result = new Result<>();
        PagedList<AssetStatus> list = assetStatusService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
