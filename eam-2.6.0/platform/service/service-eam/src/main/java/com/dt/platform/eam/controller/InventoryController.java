package com.dt.platform.eam.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.eam.AssetInventoryDetailStatusEnum;
import com.dt.platform.constants.enums.eam.AssetOperateEnum;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.InventoryAssetMeta;
import com.dt.platform.eam.service.IAssetDataService;
import com.dt.platform.eam.service.IAssetService;
import com.dt.platform.eam.service.IInventoryAssetService;
import com.dt.platform.proxy.common.TplFileServiceProxy;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import io.swagger.models.auth.In;
import org.apache.poi.ss.usermodel.Workbook;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.session.SessionUser;
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
import com.dt.platform.proxy.eam.InventoryServiceProxy;
import com.dt.platform.domain.eam.meta.InventoryVOMeta;
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
import com.dt.platform.domain.eam.meta.InventoryMeta;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IInventoryService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 资产盘点 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-11-20 13:23:35
 */
@Api(tags = "资产盘点")
@ApiSort(0)
@RestController("EamInventoryController")
public class InventoryController extends SuperController {

    @Autowired
    private IInventoryService inventoryService;

    @Autowired
    private IAssetService assetService;

    @Autowired
    private IAssetDataService assetDataService;

    @Autowired
    private IInventoryAssetService inventoryAssetService;

    /**
     * 添加资产盘点
     */
    @ApiOperation(value = "添加资产盘点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "514089040971042816"),
		@ApiImplicitParam(name = InventoryVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_CODE, value = "业务编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWNER_CODE, value = "所属", required = false, dataTypeClass = String.class, example = "inventory"),
		@ApiImplicitParam(name = InventoryVOMeta.STATUS, value = "业务状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.NAME, value = "盘点名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_STATUS, value = "盘点状态", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.DATA_STATUS, value = "数据状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.ALL_EMPLOYEE, value = "全员盘点", required = false, dataTypeClass = String.class, example = "0"),
		@ApiImplicitParam(name = InventoryVOMeta.ASSET_STATUS, value = "资产状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.CATEGORY_ID, value = "资产分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.USE_ORGANIZATION_ID, value = "使用公司/部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_START_DATE, value = "购置开始日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_END_DATE, value = "购置结束日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.START_TIME, value = "盘点开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.FINISH_TIME, value = "盘点结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_DATE, value = "业务日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PLAN_ID, value = "计划编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_REPEAT, value = "重复盘点", required = false, dataTypeClass = String.class, example = "N")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = InventoryServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(InventoryVO inventoryVO) {
        Result result = inventoryService.insert(inventoryVO, false);
        return result;
    }

    /**
     * 删除资产盘点
     */
    @ApiOperation(value = "删除资产盘点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "514089040971042816")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = InventoryServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = inventoryService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除资产盘点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除资产盘点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = InventoryServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = inventoryService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新资产盘点
     */
    @ApiOperation(value = "更新资产盘点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "514089040971042816"),
		@ApiImplicitParam(name = InventoryVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_CODE, value = "业务编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWNER_CODE, value = "所属", required = false, dataTypeClass = String.class, example = "inventory"),
		@ApiImplicitParam(name = InventoryVOMeta.STATUS, value = "业务状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.NAME, value = "盘点名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_STATUS, value = "盘点状态", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.DATA_STATUS, value = "数据状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.ALL_EMPLOYEE, value = "全员盘点", required = false, dataTypeClass = String.class, example = "0"),
		@ApiImplicitParam(name = InventoryVOMeta.ASSET_STATUS, value = "资产状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.CATEGORY_ID, value = "资产分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.USE_ORGANIZATION_ID, value = "使用公司/部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_START_DATE, value = "购置开始日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_END_DATE, value = "购置结束日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.START_TIME, value = "盘点开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.FINISH_TIME, value = "盘点结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_DATE, value = "业务日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PLAN_ID, value = "计划编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_REPEAT, value = "重复盘点", required = false, dataTypeClass = String.class, example = "N")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { InventoryVOMeta.PAGE_INDEX, InventoryVOMeta.PAGE_SIZE, InventoryVOMeta.SEARCH_FIELD, InventoryVOMeta.FUZZY_FIELD, InventoryVOMeta.SEARCH_VALUE, InventoryVOMeta.DIRTY_FIELDS, InventoryVOMeta.SORT_FIELD, InventoryVOMeta.SORT_TYPE, InventoryVOMeta.IDS })
    @SentinelResource(value = InventoryServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(InventoryVO inventoryVO) {
        Result result = inventoryService.update(inventoryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存资产盘点
     */
    @ApiOperation(value = "保存资产盘点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "514089040971042816"),
		@ApiImplicitParam(name = InventoryVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_CODE, value = "业务编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWNER_CODE, value = "所属", required = false, dataTypeClass = String.class, example = "inventory"),
		@ApiImplicitParam(name = InventoryVOMeta.STATUS, value = "业务状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.NAME, value = "盘点名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_STATUS, value = "盘点状态", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.DATA_STATUS, value = "数据状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.ALL_EMPLOYEE, value = "全员盘点", required = false, dataTypeClass = String.class, example = "0"),
		@ApiImplicitParam(name = InventoryVOMeta.ASSET_STATUS, value = "资产状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.CATEGORY_ID, value = "资产分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.USE_ORGANIZATION_ID, value = "使用公司/部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_START_DATE, value = "购置开始日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_END_DATE, value = "购置结束日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.START_TIME, value = "盘点开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.FINISH_TIME, value = "盘点结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_DATE, value = "业务日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PLAN_ID, value = "计划编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_REPEAT, value = "重复盘点", required = false, dataTypeClass = String.class, example = "N")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { InventoryVOMeta.PAGE_INDEX, InventoryVOMeta.PAGE_SIZE, InventoryVOMeta.SEARCH_FIELD, InventoryVOMeta.FUZZY_FIELD, InventoryVOMeta.SEARCH_VALUE, InventoryVOMeta.DIRTY_FIELDS, InventoryVOMeta.SORT_FIELD, InventoryVOMeta.SORT_TYPE, InventoryVOMeta.IDS })
    @SentinelResource(value = InventoryServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(InventoryVO inventoryVO) {
        Result result = inventoryService.save(inventoryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取资产盘点
     */
    @ApiOperation(value = "获取资产盘点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = InventoryServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.GET_BY_ID)
    public Result<Inventory> getById(String id) {
        Result<Inventory> result = new Result<>();
        Inventory inventory = inventoryService.getById(id);
        // join 关联的对象
        inventoryService.dao().fill(inventory).with(InventoryMeta.INVENTORY_ASSET_INFO_LIST).with(InventoryMeta.MANAGER).with(InventoryMeta.ORIGINATOR).with(InventoryMeta.DIRECTOR).with(InventoryMeta.INVENTORY_USER).with(InventoryMeta.CATEGORY).with(InventoryMeta.WAREHOUSE).with(InventoryMeta.POSITION).execute();
        inventoryService.dao().join(inventory.getDirector(), Person.class);
        inventoryService.dao().join(inventory.getManager(), Person.class);
        inventoryService.dao().join(inventory.getOriginator(), Person.class);
        inventoryService.dao().join(inventory.getInventoryUser(), Person.class);
        result.success(true).data(inventory);
        return result;
    }

    /**
     * 批量获取资产盘点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取资产盘点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = InventoryServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.GET_BY_IDS)
    public Result<List<Inventory>> getByIds(List<String> ids) {
        Result<List<Inventory>> result = new Result<>();
        List<Inventory> list = inventoryService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询资产盘点
     */
    @ApiOperation(value = "查询资产盘点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "514089040971042816"),
		@ApiImplicitParam(name = InventoryVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_CODE, value = "业务编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWNER_CODE, value = "所属", required = false, dataTypeClass = String.class, example = "inventory"),
		@ApiImplicitParam(name = InventoryVOMeta.STATUS, value = "业务状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.NAME, value = "盘点名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_STATUS, value = "盘点状态", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.DATA_STATUS, value = "数据状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.ALL_EMPLOYEE, value = "全员盘点", required = false, dataTypeClass = String.class, example = "0"),
		@ApiImplicitParam(name = InventoryVOMeta.ASSET_STATUS, value = "资产状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.CATEGORY_ID, value = "资产分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.USE_ORGANIZATION_ID, value = "使用公司/部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_START_DATE, value = "购置开始日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_END_DATE, value = "购置结束日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.START_TIME, value = "盘点开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.FINISH_TIME, value = "盘点结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_DATE, value = "业务日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PLAN_ID, value = "计划编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_REPEAT, value = "重复盘点", required = false, dataTypeClass = String.class, example = "N")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { InventoryVOMeta.PAGE_INDEX, InventoryVOMeta.PAGE_SIZE })
    @SentinelResource(value = InventoryServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.QUERY_LIST)
    public Result<List<Inventory>> queryList(InventoryVO sample) {
        Result<List<Inventory>> result = new Result<>();
        List<Inventory> list = inventoryService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询资产盘点
     */
    @ApiOperation(value = "分页查询资产盘点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "514089040971042816"),
		@ApiImplicitParam(name = InventoryVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_CODE, value = "业务编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWNER_CODE, value = "所属", required = false, dataTypeClass = String.class, example = "inventory"),
		@ApiImplicitParam(name = InventoryVOMeta.STATUS, value = "业务状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.NAME, value = "盘点名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_STATUS, value = "盘点状态", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = InventoryVOMeta.DATA_STATUS, value = "数据状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.ALL_EMPLOYEE, value = "全员盘点", required = false, dataTypeClass = String.class, example = "0"),
		@ApiImplicitParam(name = InventoryVOMeta.ASSET_STATUS, value = "资产状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.CATEGORY_ID, value = "资产分类", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.OWN_COMPANY_ID, value = "所属公司", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.USE_ORGANIZATION_ID, value = "使用公司/部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_START_DATE, value = "购置开始日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.PURCHASE_END_DATE, value = "购置结束日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.START_TIME, value = "盘点开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.FINISH_TIME, value = "盘点结束时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.BUSINESS_DATE, value = "业务日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = InventoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.PLAN_ID, value = "计划编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = InventoryVOMeta.INVENTORY_REPEAT, value = "重复盘点", required = false, dataTypeClass = String.class, example = "N")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = InventoryServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Inventory>> queryPagedList(InventoryVO sample) {
        Result<PagedList<Inventory>> result = new Result<>();
        PagedList<Inventory> list = inventoryService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        inventoryService.dao().fill(list).with(InventoryMeta.INVENTORY_ASSET_INFO_LIST).with(InventoryMeta.MANAGER).with(InventoryMeta.ORIGINATOR).with(InventoryMeta.INVENTORY_USER).with(InventoryMeta.DIRECTOR).with(InventoryMeta.CATEGORY).with(InventoryMeta.WAREHOUSE).with(InventoryMeta.POSITION).execute();
        List<List<Employee>> managerList = CollectorUtil.collectList(list.getList(), Inventory::getManager);
        List<Employee> managers = managerList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        inventoryService.dao().join(managers, Person.class);
        List<Employee> originator = CollectorUtil.collectList(list.getList(), Inventory::getOriginator);
        inventoryService.dao().join(originator, Person.class);
        List<List<Employee>> usersList = CollectorUtil.collectList(list.getList(), Inventory::getInventoryUser);
        List<Employee> users = usersList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        inventoryService.dao().join(users, Person.class);
        List<List<Employee>> directorList = CollectorUtil.collectList(list.getList(), Inventory::getDirector);
        List<Employee> directors = directorList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        inventoryService.dao().join(directors, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 	盘点开始
     */
    @ApiOperation(value = "盘点开始")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 9)
    @SentinelResource(value = InventoryServiceProxy.START, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.START)
    public Result start(String id) {
        Result result = inventoryService.start(id);
        return result;
    }

    /**
     * 	盘点取消
     */
    @ApiOperation(value = "盘点取消")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 10)
    @SentinelResource(value = InventoryServiceProxy.CANCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.CANCEL)
    public Result cancel(String id) {
        Result result = inventoryService.cancel(id);
        return result;
    }

    /**
     * 全员盘点的情况获取资产盘点
     */
    @ApiOperation(value = "获取资产盘点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = InventoryServiceProxy.GET_BY_ID_FOR_EMPLOYEE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.GET_BY_ID_FOR_EMPLOYEE)
    public Result<Inventory> getByIdForEmployee(String id) {
        Result<Inventory> result = new Result<>();
        Inventory inventory = inventoryService.getById(id);
        // join 关联的对象
        inventoryService.dao().fill(inventory).with(InventoryMeta.MANAGER).with(InventoryMeta.ORIGINATOR).with(InventoryMeta.DIRECTOR).with(InventoryMeta.INVENTORY_USER).with(InventoryMeta.CATEGORY).with(InventoryMeta.WAREHOUSE).with(InventoryMeta.POSITION).execute();
        inventoryService.dao().join(inventory.getDirector(), Person.class);
        inventoryService.dao().join(inventory.getManager(), Person.class);
        inventoryService.dao().join(inventory.getOriginator(), Person.class);
        inventoryService.dao().join(inventory.getInventoryUser(), Person.class);
        String userId = SessionUser.getCurrent().getActivatedEmployeeId();

        //盘点是否是行政人员
        String sql="";
        String managerSql="select 1 from sys_busi_role a,sys_busi_role_member b where a.code='employ_inventory_manag_role' and a.id=b.role_id and a.deleted=0 and b.member_type='employee' and b.member_id=?";
        Rcd managerRs=inventoryService.dao().queryRecord(managerSql,userId);
        RcdSet rs = null;
        if(managerRs==null){
            Logger.info("普通员工查询");
            //普通员工盘点，盘点当前获取的资产是否是本人
             sql = "select a.status,count(1) cnt from eam_inventory_asset a,eam_asset b where a.asset_id=b.id and a.deleted=0 and b.deleted=0 and a.inventory_id=? and b.use_user_id=? group by a.status";
               rs=inventoryService.dao().query(sql, id, userId);
        }else{
            //行政管理人员盘点，盘点当前管理人员是否是行政人员，并且资产状态为idle
            Logger.info("管理人员查询");
            sql="select a.status,count(1) cnt from eam_inventory_asset a, eam_asset b where a.inventory_id=? \n" +
                    "and a.asset_id=b.id \n" +
                    "and a.deleted=0 \n" +
                    "and b.deleted=0 \n" +
                    "and\n" +
                    "(\n" +
                    "b.use_user_id=? or   \n" +
                    "(b.asset_status in (select status_code from eam_asset_status_rule_v where deleted=0 and oper_code='eam_asset_inventory_employ_mode') and b.manager_id=?)\n" +
                    ") \n" +
                    "group by a.status";
            rs=inventoryService.dao().query(sql, id, userId, userId);
        }

        int surplus = 0;
        int loss = 0;
        int counted = 0;
        int not_counted = 0;
        int exception = 0;
        for (Rcd rcd : rs) {
            if (AssetInventoryDetailStatusEnum.SURPLUS.code().equals(rcd.getString("status"))) {
                surplus = rcd.getInteger("cnt");
            } else if (AssetInventoryDetailStatusEnum.EXCEPTION.code().equals(rcd.getString("status"))) {
                exception = rcd.getInteger("cnt");
            } else if (AssetInventoryDetailStatusEnum.NOT_COUNTED.code().equals(rcd.getString("status"))) {
                not_counted = rcd.getInteger("cnt");
            } else if (AssetInventoryDetailStatusEnum.LOSS.code().equals(rcd.getString("status"))) {
                loss = rcd.getInteger("cnt");
            } else if (AssetInventoryDetailStatusEnum.COUNTED.code().equals(rcd.getString("status"))) {
                counted = rcd.getInteger("cnt");
            }
        }
        inventory.setInventoryAssetCountByException(exception);
        inventory.setInventoryAssetCountBySurplus(surplus);
        inventory.setInventoryAssetCountByNotCounted(not_counted);
        inventory.setInventoryAssetCountByCounted(counted);
        inventory.setInventoryAssetCountByLoss(loss);
        result.success(true).data(inventory);
        return result;
    }

    /**
     * 	盘点结束
     */
    @ApiOperation(value = "盘点结束")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 11)
    @SentinelResource(value = InventoryServiceProxy.FINISH, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.FINISH)
    public Result finish(String id) {
        Result result = inventoryService.finish(id);
        return result;
    }

    /**
     * 	数据同步
     */
    @ApiOperation(value = "数据同步")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 12)
    @SentinelResource(value = InventoryServiceProxy.DATA_SYNC, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.DATA_SYNC)
    public Result dataSync(String id) {
        Result result = inventoryService.dataSync(id);
        return result;
    }

    /**
     * 	盘点
     */
    @ApiOperation(value = "盘点")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = "assetId", value = "资产", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = "action", value = "动作", required = true, dataTypeClass = String.class, example = "loss")
	})
    @ApiOperationSupport(order = 13)
    @SentinelResource(value = InventoryServiceProxy.INVENTORY_ASSET, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.INVENTORY_ASSET)
    public Result inventoryAsset(String id, String assetId, String action, String notes) {
        Result result = inventoryService.inventoryAsset(id, assetId, action, notes);
        return result;
    }

    /**
     * 	盘盈新增
     */
    @ApiOperation(value = "盘盈新增")
    @ApiImplicitParams({
		@ApiImplicitParam(name = InventoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = "assetId", value = "资产", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 13)
    @SentinelResource(value = InventoryServiceProxy.ASSET_PLUS_DATA, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.ASSET_PLUS_DATA)
    public Result inventoryAsset(String inventoryId, String assetId) {
        return inventoryService.assetPlusData(inventoryId, assetId);
    }

    /**
     * 	盘点全员数据
     */
    @ApiOperation(value = "盘点全员数据")
    @ApiOperationSupport(order = 14)
    @SentinelResource(value = InventoryServiceProxy.QUERY_ASSET_BY_EMPLOYEE_MODE_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.QUERY_ASSET_BY_EMPLOYEE_MODE_PAGED_LIST)
    public Result<PagedList<Asset>> queryAssetByEmployeeModePagedList(String inventoryId) {
        PagedList<Asset> list = inventoryService.queryAssetByEmployeeModePagedList(inventoryId);
        Result<PagedList<Asset>> result = new Result<>();
        result.success(true).data(list);
        return result;
    }

    /**
     * 	全员盘点员工资产
     */
    @ApiOperation(value = "全员盘点我的员工资产")
    @ApiOperationSupport(order = 15)
    @SentinelResource(value = InventoryServiceProxy.QUERY_MY_ASSET_BY_EMPLOYEE_MODE_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.QUERY_MY_ASSET_BY_EMPLOYEE_MODE_PAGED_LIST)
    public Result<PagedList<InventoryAsset>> queryMyAssetByEmployeeModePagedList(InventoryAssetVO sample) {
        PagedList<InventoryAsset> list = inventoryService.queryMyAssetByEmployeeModePagedList(sample, sample.getPageSize(), sample.getPageIndex());
        Result<PagedList<InventoryAsset>> result = new Result<>();
        // join 关联的对象
        inventoryAssetService.dao().fill(list).with(InventoryAssetMeta.OPERATER).with(InventoryAssetMeta.ASSET).execute();
        List<Employee> operList = CollectorUtil.collectList(list.getList(), InventoryAsset::getOperater);
        inventoryAssetService.dao().join(operList, Person.class);
        List<Asset> assetList = CollectorUtil.collectList(list.getList(), InventoryAsset::getAsset);
        assetService.joinData(assetList);
        result.success(true).data(list);
        return result;
    }

    /**
     * 	全员盘点
     */
    @ApiOperation(value = "全员盘点清单")
    @ApiOperationSupport(order = 15)
    @SentinelResource(value = InventoryServiceProxy.QUERY_BY_EMPLOYEE_MODE_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(InventoryServiceProxy.QUERY_BY_EMPLOYEE_MODE_PAGED_LIST)
    public Result<PagedList<Inventory>> queryByEmployeeModePagedList(InventoryVO sample) {
        PagedList<Inventory> list = inventoryService.queryByEmployeeModePagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        inventoryService.dao().fill(list).with(InventoryMeta.INVENTORY_ASSET_INFO_LIST).with(InventoryMeta.MANAGER).with(InventoryMeta.ORIGINATOR).with(InventoryMeta.INVENTORY_USER).with(InventoryMeta.DIRECTOR).with(InventoryMeta.CATEGORY).with(InventoryMeta.WAREHOUSE).with(InventoryMeta.POSITION).execute();
        List<List<Employee>> managerList = CollectorUtil.collectList(list.getList(), Inventory::getManager);
        List<Employee> managers = managerList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        inventoryService.dao().join(managers, Person.class);

        List<Employee> originator = CollectorUtil.collectList(list.getList(), Inventory::getOriginator);
        inventoryService.dao().join(originator, Person.class);

        List<List<Employee>> usersList = CollectorUtil.collectList(list.getList(), Inventory::getInventoryUser);

        List<Employee> users = usersList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        inventoryService.dao().join(users, Person.class);
        List<List<Employee>> directorList = CollectorUtil.collectList(list.getList(), Inventory::getDirector);
        List<Employee> directors = directorList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        inventoryService.dao().join(directors, Person.class);

        Result<PagedList<Inventory>> result = new Result<>();
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = InventoryServiceProxy.QUERY_ASSET_BY_INVENTORY, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InventoryServiceProxy.QUERY_ASSET_BY_INVENTORY)
    public Result<JSONObject> queryAssetByInventory(String inventoryId, String assetId, String assetCode, String type) {
        return inventoryService.queryAssetByInventory(inventoryId, assetId, assetCode, type);
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = InventoryServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InventoryServiceProxy.EXPORT_EXCEL)
    public void exportExcel(InventoryVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            ExcelWriter ew = inventoryService.exportExcel(sample);
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = InventoryServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InventoryServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = inventoryService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = InventoryServiceProxy.DOWNLOAD_ASSET, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InventoryServiceProxy.DOWNLOAD_ASSET)
    public void downloadAsset(HttpServletResponse response, String inventoryId) throws Exception {
        try {
            // 生成 Excel 数据
            InputStream inputstream = TplFileServiceProxy.api().getTplFileStreamByCode(AssetOperateEnum.EAM_DOWNLOAD_ASSET_INVENTORY_ASSET.code());
            if (inputstream == null) {
                Logger.info("为找到下载模版文件");
                return;
            }
            File f = assetDataService.saveTempFile(inputstream, "tmp_download_inventory_asset_data.xls");
            Map<String, Object> map = inventoryService.queryInventoryAssetMap(inventoryId);
            TemplateExportParams templateExportParams = new TemplateExportParams(f.getPath());
            templateExportParams.setScanAllsheet(true);
            Workbook workbook = ExcelExportUtil.exportExcel(templateExportParams, map);
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode("资产数据.xls", "UTF-8"))));
            response.setContentType("application/vnd.ms-excel");
            // 下载
            DownloadUtil.writeToOutput(response, workbook, "盘点资产数据.xls");
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = InventoryServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(InventoryServiceProxy.IMPORT_EXCEL)
    public Result importExcel(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获得上传的文件
        Map<String, MultipartFile> map = request.getFileMap();
        InputStream input = null;
        for (MultipartFile mf : map.values()) {
            input = StreamUtil.bytes2input(mf.getBytes());
            break;
        }
        if (input == null) {
            return ErrorDesc.failure().message("缺少上传的文件");
        }
        List<ValidateResult> errors = inventoryService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
