package com.dt.platform.eam.controller;

import java.util.List;
import java.util.ArrayList;
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
import com.dt.platform.proxy.eam.AssetEmployeeLossServiceProxy;
import com.dt.platform.domain.eam.meta.AssetEmployeeLossVOMeta;
import com.dt.platform.domain.eam.AssetEmployeeLoss;
import com.dt.platform.domain.eam.AssetEmployeeLossVO;
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
import com.dt.platform.domain.eam.meta.AssetEmployeeLossMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IAssetEmployeeLossService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 资产报失 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-02 22:09:17
 */
@Api(tags = "资产报失")
@ApiSort(0)
@RestController("EamAssetEmployeeLossController")
public class AssetEmployeeLossController extends SuperController implements BpmCallbackController {

    @Autowired
    private IAssetEmployeeLossService assetEmployeeLossService;

    /**
     * 添加资产报失
     */
    @ApiOperation(value = "添加资产报失")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "595737460403601408"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.CONTENT, value = "报失原因", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class, example = "2")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AssetEmployeeLossServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeLossServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AssetEmployeeLossVO assetEmployeeLossVO) {
        Result result = assetEmployeeLossService.insert(assetEmployeeLossVO, false);
        return result;
    }

    /**
     * 删除资产报失
     */
    @ApiOperation(value = "删除资产报失")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "595737460403601408")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AssetEmployeeLossServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeLossServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  assetEmployeeLossService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = assetEmployeeLossService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除资产报失 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除资产报失")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetEmployeeLossServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeLossServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assetEmployeeLossService.hasRefers(ids);
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
            Result result = assetEmployeeLossService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assetEmployeeLossService.deleteByIdsLogical(canDeleteIds);
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
     * 更新资产报失
     */
    @ApiOperation(value = "更新资产报失")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "595737460403601408"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.CONTENT, value = "报失原因", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class, example = "2")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AssetEmployeeLossVOMeta.PAGE_INDEX, AssetEmployeeLossVOMeta.PAGE_SIZE, AssetEmployeeLossVOMeta.SEARCH_FIELD, AssetEmployeeLossVOMeta.FUZZY_FIELD, AssetEmployeeLossVOMeta.SEARCH_VALUE, AssetEmployeeLossVOMeta.DIRTY_FIELDS, AssetEmployeeLossVOMeta.SORT_FIELD, AssetEmployeeLossVOMeta.SORT_TYPE, AssetEmployeeLossVOMeta.IDS })
    @SentinelResource(value = AssetEmployeeLossServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeLossServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AssetEmployeeLossVO assetEmployeeLossVO) {
        Result result = assetEmployeeLossService.update(assetEmployeeLossVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存资产报失
     */
    @ApiOperation(value = "保存资产报失")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "595737460403601408"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.CONTENT, value = "报失原因", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class, example = "2")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetEmployeeLossVOMeta.PAGE_INDEX, AssetEmployeeLossVOMeta.PAGE_SIZE, AssetEmployeeLossVOMeta.SEARCH_FIELD, AssetEmployeeLossVOMeta.FUZZY_FIELD, AssetEmployeeLossVOMeta.SEARCH_VALUE, AssetEmployeeLossVOMeta.DIRTY_FIELDS, AssetEmployeeLossVOMeta.SORT_FIELD, AssetEmployeeLossVOMeta.SORT_TYPE, AssetEmployeeLossVOMeta.IDS })
    @SentinelResource(value = AssetEmployeeLossServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeLossServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AssetEmployeeLossVO assetEmployeeLossVO) {
        Result result = assetEmployeeLossService.save(assetEmployeeLossVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取资产报失
     */
    @ApiOperation(value = "获取资产报失")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AssetEmployeeLossServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeLossServiceProxy.GET_BY_ID)
    public Result<AssetEmployeeLoss> getById(String id) {
        Result<AssetEmployeeLoss> result = new Result<>();
        AssetEmployeeLoss assetEmployeeLoss = assetEmployeeLossService.getById(id);
        // join 关联的对象
        assetEmployeeLossService.dao().fill(assetEmployeeLoss).with("organization").with("originator").execute();
        assetEmployeeLossService.dao().join(assetEmployeeLoss.getOriginator(), Person.class);
        result.success(true).data(assetEmployeeLoss);
        return result;
    }

    /**
     * 批量获取资产报失 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取资产报失")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetEmployeeLossServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeLossServiceProxy.GET_BY_IDS)
    public Result<List<AssetEmployeeLoss>> getByIds(List<String> ids) {
        Result<List<AssetEmployeeLoss>> result = new Result<>();
        List<AssetEmployeeLoss> list = assetEmployeeLossService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询资产报失
     */
    @ApiOperation(value = "查询资产报失")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "595737460403601408"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.CONTENT, value = "报失原因", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class, example = "2")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetEmployeeLossVOMeta.PAGE_INDEX, AssetEmployeeLossVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssetEmployeeLossServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeLossServiceProxy.QUERY_LIST)
    public Result<List<AssetEmployeeLoss>> queryList(AssetEmployeeLossVO sample) {
        Result<List<AssetEmployeeLoss>> result = new Result<>();
        List<AssetEmployeeLoss> list = assetEmployeeLossService.queryList(sample);
        List<Employee> employees = CollectorUtil.collectList(list, AssetEmployeeLoss::getOriginator);
        assetEmployeeLossService.dao().join(employees, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询资产报失
     */
    @ApiOperation(value = "分页查询资产报失")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "595737460403601408"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.CONTENT, value = "报失原因", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeLossVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class, example = "2")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AssetEmployeeLossServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeLossServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssetEmployeeLoss>> queryPagedList(AssetEmployeeLossVO sample) {
        Result<PagedList<AssetEmployeeLoss>> result = new Result<>();
        PagedList<AssetEmployeeLoss> list = assetEmployeeLossService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        assetEmployeeLossService.dao().fill(list).with("organization").with("originator").execute();
        // 填充流程相关的属性
        List<Employee> employees = CollectorUtil.collectList(list, AssetEmployeeLoss::getOriginator);
        assetEmployeeLossService.dao().join(employees, Person.class);
        assetEmployeeLossService.joinProcess(list);
        result.success(true).data(list);
        return result;
    }

    /**
     *  流程回调处理
     */
    @SentinelResource(value = AssetEmployeeLossServiceProxy.BPM_CALLBACK, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeLossServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event) {
        return assetEmployeeLossService.onProcessCallback(event);
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = AssetEmployeeLossServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetEmployeeLossServiceProxy.EXPORT_EXCEL)
    public void exportExcel(AssetEmployeeLossVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            ExcelWriter ew = assetEmployeeLossService.exportExcel(sample);
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = AssetEmployeeLossServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetEmployeeLossServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = assetEmployeeLossService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = AssetEmployeeLossServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetEmployeeLossServiceProxy.IMPORT_EXCEL)
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
        List<ValidateResult> errors = assetEmployeeLossService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
