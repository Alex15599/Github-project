package com.dt.platform.eam.controller;

import java.util.List;
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
import com.dt.platform.proxy.eam.PurchaseOrderServiceProxy;
import com.dt.platform.domain.eam.meta.PurchaseOrderVOMeta;
import com.dt.platform.domain.eam.PurchaseOrder;
import com.dt.platform.domain.eam.PurchaseOrderVO;
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
import com.dt.platform.domain.eam.meta.PurchaseOrderMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Asset;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IPurchaseOrderService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 采购订单 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-17 01:46:37
 */
@Api(tags = "采购订单")
@ApiSort(0)
@RestController("EamPurchaseOrderController")
public class PurchaseOrderController extends SuperController {

    @Autowired
    private IPurchaseOrderService purchaseOrderService;

    /**
     * 添加采购订单
     */
    @ApiOperation(value = "添加采购订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PurchaseOrderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "567219047221952512"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.BUSINESS_CODE, value = "业务编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.CODE, value = "订单编号", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.NAME, value = "订单名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.APPLY_ID, value = "采购申请单", required = false, dataTypeClass = String.class, example = "567749173793800192"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.CHECK_ID, value = "验收单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.GOODS_TYPE, value = "物品类型", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.STORAGE_TYPE, value = "存放类型", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = PurchaseOrderServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseOrderServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(PurchaseOrderVO purchaseOrderVO) {
        Result result = purchaseOrderService.insert(purchaseOrderVO, false);
        return result;
    }

    /**
     * 删除采购订单
     */
    @ApiOperation(value = "删除采购订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PurchaseOrderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "567219047221952512")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = PurchaseOrderServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseOrderServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = purchaseOrderService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除采购订单 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除采购订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PurchaseOrderVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = PurchaseOrderServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseOrderServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = purchaseOrderService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新采购订单
     */
    @ApiOperation(value = "更新采购订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PurchaseOrderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "567219047221952512"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.BUSINESS_CODE, value = "业务编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.CODE, value = "订单编号", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.NAME, value = "订单名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.APPLY_ID, value = "采购申请单", required = false, dataTypeClass = String.class, example = "567749173793800192"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.CHECK_ID, value = "验收单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.GOODS_TYPE, value = "物品类型", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.STORAGE_TYPE, value = "存放类型", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { PurchaseOrderVOMeta.PAGE_INDEX, PurchaseOrderVOMeta.PAGE_SIZE, PurchaseOrderVOMeta.SEARCH_FIELD, PurchaseOrderVOMeta.FUZZY_FIELD, PurchaseOrderVOMeta.SEARCH_VALUE, PurchaseOrderVOMeta.DIRTY_FIELDS, PurchaseOrderVOMeta.SORT_FIELD, PurchaseOrderVOMeta.SORT_TYPE, PurchaseOrderVOMeta.IDS })
    @SentinelResource(value = PurchaseOrderServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseOrderServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(PurchaseOrderVO purchaseOrderVO) {
        Result result = purchaseOrderService.update(purchaseOrderVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存采购订单
     */
    @ApiOperation(value = "保存采购订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PurchaseOrderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "567219047221952512"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.BUSINESS_CODE, value = "业务编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.CODE, value = "订单编号", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.NAME, value = "订单名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.APPLY_ID, value = "采购申请单", required = false, dataTypeClass = String.class, example = "567749173793800192"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.CHECK_ID, value = "验收单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.GOODS_TYPE, value = "物品类型", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.STORAGE_TYPE, value = "存放类型", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { PurchaseOrderVOMeta.PAGE_INDEX, PurchaseOrderVOMeta.PAGE_SIZE, PurchaseOrderVOMeta.SEARCH_FIELD, PurchaseOrderVOMeta.FUZZY_FIELD, PurchaseOrderVOMeta.SEARCH_VALUE, PurchaseOrderVOMeta.DIRTY_FIELDS, PurchaseOrderVOMeta.SORT_FIELD, PurchaseOrderVOMeta.SORT_TYPE, PurchaseOrderVOMeta.IDS })
    @SentinelResource(value = PurchaseOrderServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseOrderServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(PurchaseOrderVO purchaseOrderVO) {
        Result result = purchaseOrderService.save(purchaseOrderVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取采购订单
     */
    @ApiOperation(value = "获取采购订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PurchaseOrderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = PurchaseOrderServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseOrderServiceProxy.GET_BY_ID)
    public Result<PurchaseOrder> getById(String id) {
        Result<PurchaseOrder> result = new Result<>();
        PurchaseOrder purchaseOrder = purchaseOrderService.getById(id);
        // join 关联的对象
        purchaseOrderService.dao().fill(purchaseOrder).with(PurchaseOrderMeta.PURCHASE_APPLY).execute();
        result.success(true).data(purchaseOrder);
        return result;
    }

    /**
     * 批量获取采购订单 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取采购订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PurchaseOrderVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = PurchaseOrderServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseOrderServiceProxy.GET_BY_IDS)
    public Result<List<PurchaseOrder>> getByIds(List<String> ids) {
        Result<List<PurchaseOrder>> result = new Result<>();
        List<PurchaseOrder> list = purchaseOrderService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询采购订单
     */
    @ApiOperation(value = "查询采购订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PurchaseOrderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "567219047221952512"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.BUSINESS_CODE, value = "业务编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.CODE, value = "订单编号", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.NAME, value = "订单名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.APPLY_ID, value = "采购申请单", required = false, dataTypeClass = String.class, example = "567749173793800192"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.CHECK_ID, value = "验收单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.GOODS_TYPE, value = "物品类型", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.STORAGE_TYPE, value = "存放类型", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { PurchaseOrderVOMeta.PAGE_INDEX, PurchaseOrderVOMeta.PAGE_SIZE })
    @SentinelResource(value = PurchaseOrderServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseOrderServiceProxy.QUERY_LIST)
    public Result<List<PurchaseOrder>> queryList(PurchaseOrderVO sample) {
        Result<List<PurchaseOrder>> result = new Result<>();
        List<PurchaseOrder> list = purchaseOrderService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询采购订单
     */
    @ApiOperation(value = "分页查询采购订单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PurchaseOrderVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "567219047221952512"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.BUSINESS_CODE, value = "业务编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.CODE, value = "订单编号", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.NAME, value = "订单名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.APPLY_ID, value = "采购申请单", required = false, dataTypeClass = String.class, example = "567749173793800192"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.CHECK_ID, value = "验收单", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.GOODS_TYPE, value = "物品类型", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.STORAGE_TYPE, value = "存放类型", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PurchaseOrderVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = PurchaseOrderServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PurchaseOrderServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<PurchaseOrder>> queryPagedList(PurchaseOrderVO sample) {
        Result<PagedList<PurchaseOrder>> result = new Result<>();
        PagedList<PurchaseOrder> list = purchaseOrderService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        purchaseOrderService.dao().fill(list).with(PurchaseOrderMeta.PURCHASE_APPLY).execute();
        result.success(true).data(list);
        return result;
    }
}
