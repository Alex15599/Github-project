package com.dt.platform.eam.controller;

import java.util.List;
import java.util.ArrayList;
import com.dt.platform.domain.eam.AssetEmployeeLoss;
import com.github.foxnic.commons.collection.CollectorUtil;
import org.github.foxnic.web.domain.hrm.Person;
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
import org.github.foxnic.web.constants.enums.bpm.BpmEventType;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import com.dt.platform.proxy.eam.AssetEmployeeRepairServiceProxy;
import com.dt.platform.domain.eam.meta.AssetEmployeeRepairVOMeta;
import com.dt.platform.domain.eam.AssetEmployeeRepair;
import com.dt.platform.domain.eam.AssetEmployeeRepairVO;
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
import com.dt.platform.domain.eam.meta.AssetEmployeeRepairMeta;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetEmployeeRepairService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 资产报修 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-02 12:53:52
 */
@Api(tags = "资产报修")
@ApiSort(0)
@RestController("EamAssetEmployeeRepairController")
public class AssetEmployeeRepairController extends SuperController implements BpmCallbackController {

    @Autowired
    private IAssetEmployeeRepairService assetEmployeeRepairService;

    /**
     * 添加资产报修
     */
    @ApiOperation(value = "添加资产报修")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "592479694884962304"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class, example = "500994919175819264"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.CONTENT, value = "故障原因", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AssetEmployeeRepairServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeRepairServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AssetEmployeeRepairVO assetEmployeeRepairVO) {
        Result result = assetEmployeeRepairService.insert(assetEmployeeRepairVO, false);
        return result;
    }

    /**
     * 删除资产报修
     */
    @ApiOperation(value = "删除资产报修")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "592479694884962304")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AssetEmployeeRepairServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeRepairServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  assetEmployeeRepairService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = assetEmployeeRepairService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除资产报修 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除资产报修")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetEmployeeRepairServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeRepairServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assetEmployeeRepairService.hasRefers(ids);
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
            Result result = assetEmployeeRepairService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assetEmployeeRepairService.deleteByIdsLogical(canDeleteIds);
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
     * 更新资产报修
     */
    @ApiOperation(value = "更新资产报修")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "592479694884962304"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class, example = "500994919175819264"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.CONTENT, value = "故障原因", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AssetEmployeeRepairVOMeta.PAGE_INDEX, AssetEmployeeRepairVOMeta.PAGE_SIZE, AssetEmployeeRepairVOMeta.SEARCH_FIELD, AssetEmployeeRepairVOMeta.FUZZY_FIELD, AssetEmployeeRepairVOMeta.SEARCH_VALUE, AssetEmployeeRepairVOMeta.DIRTY_FIELDS, AssetEmployeeRepairVOMeta.SORT_FIELD, AssetEmployeeRepairVOMeta.SORT_TYPE, AssetEmployeeRepairVOMeta.IDS })
    @SentinelResource(value = AssetEmployeeRepairServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeRepairServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AssetEmployeeRepairVO assetEmployeeRepairVO) {
        Result result = assetEmployeeRepairService.update(assetEmployeeRepairVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存资产报修
     */
    @ApiOperation(value = "保存资产报修")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "592479694884962304"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class, example = "500994919175819264"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.CONTENT, value = "故障原因", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetEmployeeRepairVOMeta.PAGE_INDEX, AssetEmployeeRepairVOMeta.PAGE_SIZE, AssetEmployeeRepairVOMeta.SEARCH_FIELD, AssetEmployeeRepairVOMeta.FUZZY_FIELD, AssetEmployeeRepairVOMeta.SEARCH_VALUE, AssetEmployeeRepairVOMeta.DIRTY_FIELDS, AssetEmployeeRepairVOMeta.SORT_FIELD, AssetEmployeeRepairVOMeta.SORT_TYPE, AssetEmployeeRepairVOMeta.IDS })
    @SentinelResource(value = AssetEmployeeRepairServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeRepairServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AssetEmployeeRepairVO assetEmployeeRepairVO) {
        Result result = assetEmployeeRepairService.save(assetEmployeeRepairVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取资产报修
     */
    @ApiOperation(value = "获取资产报修")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AssetEmployeeRepairServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeRepairServiceProxy.GET_BY_ID)
    public Result<AssetEmployeeRepair> getById(String id) {
        Result<AssetEmployeeRepair> result = new Result<>();
        AssetEmployeeRepair assetEmployeeRepair = assetEmployeeRepairService.getById(id);
        // join 关联的对象
        assetEmployeeRepairService.dao().fill(assetEmployeeRepair).with("organization").with("originator").execute();
        assetEmployeeRepairService.dao().join(assetEmployeeRepair.getOriginator(), Person.class);
        result.success(true).data(assetEmployeeRepair);
        return result;
    }

    /**
     * 批量获取资产报修 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取资产报修")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetEmployeeRepairServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeRepairServiceProxy.GET_BY_IDS)
    public Result<List<AssetEmployeeRepair>> getByIds(List<String> ids) {
        Result<List<AssetEmployeeRepair>> result = new Result<>();
        List<AssetEmployeeRepair> list = assetEmployeeRepairService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询资产报修
     */
    @ApiOperation(value = "查询资产报修")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "592479694884962304"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class, example = "500994919175819264"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.CONTENT, value = "故障原因", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetEmployeeRepairVOMeta.PAGE_INDEX, AssetEmployeeRepairVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssetEmployeeRepairServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeRepairServiceProxy.QUERY_LIST)
    public Result<List<AssetEmployeeRepair>> queryList(AssetEmployeeRepairVO sample) {
        Result<List<AssetEmployeeRepair>> result = new Result<>();
        List<AssetEmployeeRepair> list = assetEmployeeRepairService.queryList(sample);
        List<Employee> employees = CollectorUtil.collectList(list, AssetEmployeeRepair::getOriginator);
        assetEmployeeRepairService.dao().join(employees, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询资产报修
     */
    @ApiOperation(value = "分页查询资产报修")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "592479694884962304"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class, example = "500994919175819264"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.CONTENT, value = "故障原因", required = false, dataTypeClass = String.class, example = "121212"),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeRepairVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AssetEmployeeRepairServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeRepairServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssetEmployeeRepair>> queryPagedList(AssetEmployeeRepairVO sample) {
        Result<PagedList<AssetEmployeeRepair>> result = new Result<>();
        PagedList<AssetEmployeeRepair> list = assetEmployeeRepairService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        assetEmployeeRepairService.dao().fill(list).with("organization").with("originator").execute();
        // 填充流程相关的属性
        assetEmployeeRepairService.joinProcess(list);
        List<Employee> employees = CollectorUtil.collectList(list, AssetEmployeeRepair::getOriginator);
        assetEmployeeRepairService.dao().join(employees, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     *  流程回调处理
     */
    @SentinelResource(value = AssetEmployeeRepairServiceProxy.BPM_CALLBACK, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeRepairServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event) {
        return assetEmployeeRepairService.onProcessCallback(event);
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = AssetEmployeeRepairServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetEmployeeRepairServiceProxy.EXPORT_EXCEL)
    public void exportExcel(AssetEmployeeRepairVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            ExcelWriter ew = assetEmployeeRepairService.exportExcel(sample);
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = AssetEmployeeRepairServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetEmployeeRepairServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = assetEmployeeRepairService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = AssetEmployeeRepairServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetEmployeeRepairServiceProxy.IMPORT_EXCEL)
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
        List<ValidateResult> errors = assetEmployeeRepairService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
