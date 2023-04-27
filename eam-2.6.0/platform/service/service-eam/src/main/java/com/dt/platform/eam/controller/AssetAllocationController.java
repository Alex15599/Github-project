package com.dt.platform.eam.controller;

import java.util.List;
import com.dt.platform.constants.enums.eam.AssetHandleStatusEnum;
import com.dt.platform.domain.eam.AssetBorrow;
import com.dt.platform.domain.eam.meta.AssetDataChangeVOMeta;
import com.dt.platform.domain.eam.meta.AssetVOMeta;
import com.dt.platform.proxy.eam.AssetDataChangeServiceProxy;
import com.dt.platform.proxy.eam.AssetScrapServiceProxy;
import com.dt.platform.proxy.eam.AssetServiceProxy;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.lang.StringUtil;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import org.github.foxnic.web.domain.changes.ProcessApproveVO;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
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
import com.dt.platform.proxy.eam.AssetAllocationServiceProxy;
import com.dt.platform.domain.eam.meta.AssetAllocationVOMeta;
import com.dt.platform.domain.eam.AssetAllocation;
import com.dt.platform.domain.eam.AssetAllocationVO;
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
import com.dt.platform.domain.eam.meta.AssetAllocationMeta;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetAllocationService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 资产调拨 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-22 16:52:24
 */
@Api(tags = "资产调拨")
@ApiSort(0)
@RestController("EamAssetAllocationController")
public class AssetAllocationController extends SuperController implements BpmCallbackController {

    @Autowired
    private IAssetAllocationService assetAllocationService;

    /**
     * 添加资产调拨
     */
    @ApiOperation(value = "添加资产调拨")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetAllocationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "480667967441350656"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.PROC_ID, value = "流程", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.OUT_OWN_COMPANY_ID, value = "调出所属公司", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.IN_OWN_COMPANY_ID, value = "调入所属公司", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.MANAGER_ID, value = "调入管理员", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.CONTENT, value = "调拨说明", required = false, dataTypeClass = String.class, example = "1212121212"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.BUSINESS_DATE, value = "业务日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.ATTACH, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AssetAllocationServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetAllocationServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AssetAllocationVO assetAllocationVO) {
        return assetAllocationService.insert(assetAllocationVO);
    }

    /**
     * 删除资产调拨
     */
    @ApiOperation(value = "删除资产调拨")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetAllocationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "480667967441350656")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AssetAllocationServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetAllocationServiceProxy.DELETE)
    public Result deleteById(String id) {
        AssetAllocation assetAllocation = assetAllocationService.getById(id);
        if (AssetHandleStatusEnum.CANCEL.code().equals(assetAllocation.getStatus()) || AssetHandleStatusEnum.INCOMPLETE.code().equals(assetAllocation.getStatus())) {
            Result result = assetAllocationService.deleteByIdLogical(id);
            return result;
        } else {
            return ErrorDesc.failure().message("当前状态不允许删除");
        }
    }

    /**
     * 批量删除资产调拨 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除资产调拨")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetAllocationVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetAllocationServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetAllocationServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = assetAllocationService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新资产调拨
     */
    @ApiOperation(value = "更新资产调拨")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetAllocationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "480667967441350656"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.PROC_ID, value = "流程", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.OUT_OWN_COMPANY_ID, value = "调出所属公司", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.IN_OWN_COMPANY_ID, value = "调入所属公司", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.MANAGER_ID, value = "调入管理员", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.CONTENT, value = "调拨说明", required = false, dataTypeClass = String.class, example = "1212121212"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.BUSINESS_DATE, value = "业务日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.ATTACH, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AssetAllocationVOMeta.PAGE_INDEX, AssetAllocationVOMeta.PAGE_SIZE, AssetAllocationVOMeta.SEARCH_FIELD, AssetAllocationVOMeta.FUZZY_FIELD, AssetAllocationVOMeta.SEARCH_VALUE, AssetAllocationVOMeta.SORT_FIELD, AssetAllocationVOMeta.SORT_TYPE, AssetAllocationVOMeta.IDS })
    @SentinelResource(value = AssetAllocationServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetAllocationServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AssetAllocationVO assetAllocationVO) {
        AssetAllocation assetAllocation = assetAllocationService.getById(assetAllocationVO.getId());
        if (AssetHandleStatusEnum.COMPLETE.code().equals(assetAllocation.getStatus()) || AssetHandleStatusEnum.APPROVAL.code().equals(assetAllocation.getStatus())) {
            return ErrorDesc.failure().message("当前状态不允许修改");
        }
        Result result = assetAllocationService.update(assetAllocationVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 保存资产调拨
     */
    @ApiOperation(value = "保存资产调拨")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetAllocationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "480667967441350656"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.PROC_ID, value = "流程", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.OUT_OWN_COMPANY_ID, value = "调出所属公司", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.IN_OWN_COMPANY_ID, value = "调入所属公司", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.MANAGER_ID, value = "调入管理员", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.CONTENT, value = "调拨说明", required = false, dataTypeClass = String.class, example = "1212121212"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.BUSINESS_DATE, value = "业务日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.ATTACH, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetAllocationVOMeta.PAGE_INDEX, AssetAllocationVOMeta.PAGE_SIZE, AssetAllocationVOMeta.SEARCH_FIELD, AssetAllocationVOMeta.FUZZY_FIELD, AssetAllocationVOMeta.SEARCH_VALUE, AssetAllocationVOMeta.SORT_FIELD, AssetAllocationVOMeta.SORT_TYPE, AssetAllocationVOMeta.IDS })
    @SentinelResource(value = AssetAllocationServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetAllocationServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AssetAllocationVO assetAllocationVO) {
        Result result = assetAllocationService.save(assetAllocationVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 获取资产调拨
     */
    @ApiOperation(value = "获取资产调拨")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetAllocationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AssetAllocationServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetAllocationServiceProxy.GET_BY_ID)
    public Result<AssetAllocation> getById(String id) {
        Result<AssetAllocation> result = new Result<>();
        AssetAllocation assetAllocation = assetAllocationService.getById(id);
        // 关联出 调出所属公司 数据
        assetAllocationService.join(assetAllocation, AssetAllocationMeta.OUT_OWNER_COMPANY);
        // 关联出 调入所属公司 数据
        assetAllocationService.join(assetAllocation, AssetAllocationMeta.IN_OWNER_COMPANY);
        // 关联出 调入管理员 数据
        assetAllocationService.join(assetAllocation, AssetAllocationMeta.MANAGER);
        // 关联出 制单人 数据
        assetAllocationService.join(assetAllocation, AssetAllocationMeta.ORIGINATOR);
        assetAllocationService.dao().join(assetAllocation.getManager(), Person.class);
        assetAllocationService.dao().join(assetAllocation.getOriginator(), Person.class);
        result.success(true).data(assetAllocation);
        return result;
    }

    /**
     * 批量删除资产调拨 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除资产调拨")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetAllocationVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetAllocationServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetAllocationServiceProxy.GET_BY_IDS)
    public Result<List<AssetAllocation>> getByIds(List<String> ids) {
        Result<List<AssetAllocation>> result = new Result<>();
        List<AssetAllocation> list = assetAllocationService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询资产调拨
     */
    @ApiOperation(value = "查询资产调拨")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetAllocationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "480667967441350656"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.PROC_ID, value = "流程", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.OUT_OWN_COMPANY_ID, value = "调出所属公司", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.IN_OWN_COMPANY_ID, value = "调入所属公司", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.MANAGER_ID, value = "调入管理员", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.CONTENT, value = "调拨说明", required = false, dataTypeClass = String.class, example = "1212121212"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.BUSINESS_DATE, value = "业务日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.ATTACH, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetAllocationVOMeta.PAGE_INDEX, AssetAllocationVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssetAllocationServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetAllocationServiceProxy.QUERY_LIST)
    public Result<List<AssetAllocation>> queryList(AssetAllocationVO sample) {
        Result<List<AssetAllocation>> result = new Result<>();
        List<AssetAllocation> list = assetAllocationService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询资产调拨
     */
    @ApiOperation(value = "分页查询资产调拨")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetAllocationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "480667967441350656"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.PROC_ID, value = "流程", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.OUT_OWN_COMPANY_ID, value = "调出所属公司", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.IN_OWN_COMPANY_ID, value = "调入所属公司", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.MANAGER_ID, value = "调入管理员", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.CONTENT, value = "调拨说明", required = false, dataTypeClass = String.class, example = "1212121212"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetAllocationVOMeta.BUSINESS_DATE, value = "业务日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.ATTACH, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetAllocationVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AssetAllocationServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetAllocationServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssetAllocation>> queryPagedList(AssetAllocationVO sample) {
        Result<PagedList<AssetAllocation>> result = new Result<>();
        PagedList<AssetAllocation> list = assetAllocationService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // 关联出 调出所属公司 数据
        assetAllocationService.join(list, AssetAllocationMeta.OUT_OWNER_COMPANY);
        // 关联出 调入所属公司 数据
        assetAllocationService.join(list, AssetAllocationMeta.IN_OWNER_COMPANY);
        // 关联出 调入管理员 数据
        assetAllocationService.join(list, AssetAllocationMeta.MANAGER);
        // 关联出 制单人 数据
        assetAllocationService.join(list, AssetAllocationMeta.ORIGINATOR);
        List<Employee> employees = CollectorUtil.collectList(list, AssetAllocation::getOriginator);
        List<Employee> managers = CollectorUtil.collectList(list, AssetAllocation::getManager);
        assetAllocationService.dao().join(employees, Person.class);
        assetAllocationService.dao().join(managers, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 确认
     */
    @ApiOperation(value = "调拨确认")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetAllocationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 13)
    @SentinelResource(value = AssetAllocationServiceProxy.CONFIRM_OPERATION, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetAllocationServiceProxy.CONFIRM_OPERATION)
    public Result confirmOperation(String id) {
        return assetAllocationService.confirmOperation(id);
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = AssetAllocationServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetAllocationServiceProxy.EXPORT_EXCEL)
    public void exportExcel(AssetAllocationVO sample, HttpServletResponse response) throws Exception {
        // 生成 Excel 数据
        ExcelWriter ew = assetAllocationService.exportExcel(sample);
        // 下载
        DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = AssetAllocationServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetAllocationServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        // 生成 Excel 模版
        ExcelWriter ew = assetAllocationService.exportExcelTemplate();
        // 下载
        DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
    }

    /**
     *  流程回调处理
     */
    @SentinelResource(value = AssetAllocationServiceProxy.BPM_CALLBACK, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetAllocationServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event) {
        return assetAllocationService.onProcessCallback(event);
    }

    @SentinelResource(value = AssetAllocationServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetAllocationServiceProxy.IMPORT_EXCEL)
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
        List<ValidateResult> errors = assetAllocationService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
