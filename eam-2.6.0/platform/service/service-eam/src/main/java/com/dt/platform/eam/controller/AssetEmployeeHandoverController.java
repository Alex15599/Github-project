package com.dt.platform.eam.controller;

import java.util.List;
import java.util.ArrayList;
import com.dt.platform.domain.eam.AssetEmployeeApply;
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
import com.dt.platform.proxy.eam.AssetEmployeeHandoverServiceProxy;
import com.dt.platform.domain.eam.meta.AssetEmployeeHandoverVOMeta;
import com.dt.platform.domain.eam.AssetEmployeeHandover;
import com.dt.platform.domain.eam.AssetEmployeeHandoverVO;
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
import com.dt.platform.domain.eam.meta.AssetEmployeeHandoverMeta;
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
import com.dt.platform.eam.service.IAssetEmployeeHandoverService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 资产交接 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-02 22:09:25
 */
@Api(tags = "资产交接")
@ApiSort(0)
@RestController("EamAssetEmployeeHandoverController")
public class AssetEmployeeHandoverController extends SuperController implements BpmCallbackController {

    @Autowired
    private IAssetEmployeeHandoverService assetEmployeeHandoverService;

    /**
     * 添加资产交接
     */
    @ApiOperation(value = "添加资产交接")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID, value = "交接部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID, value = "交接人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AssetEmployeeHandoverServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeHandoverServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AssetEmployeeHandoverVO assetEmployeeHandoverVO) {
        Result result = assetEmployeeHandoverService.insert(assetEmployeeHandoverVO, false);
        return result;
    }

    /**
     * 删除资产交接
     */
    @ApiOperation(value = "删除资产交接")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AssetEmployeeHandoverServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeHandoverServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  assetEmployeeHandoverService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = assetEmployeeHandoverService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除资产交接 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除资产交接")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetEmployeeHandoverServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeHandoverServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = assetEmployeeHandoverService.hasRefers(ids);
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
            Result result = assetEmployeeHandoverService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = assetEmployeeHandoverService.deleteByIdsLogical(canDeleteIds);
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
     * 更新资产交接
     */
    @ApiOperation(value = "更新资产交接")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID, value = "交接部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID, value = "交接人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AssetEmployeeHandoverVOMeta.PAGE_INDEX, AssetEmployeeHandoverVOMeta.PAGE_SIZE, AssetEmployeeHandoverVOMeta.SEARCH_FIELD, AssetEmployeeHandoverVOMeta.FUZZY_FIELD, AssetEmployeeHandoverVOMeta.SEARCH_VALUE, AssetEmployeeHandoverVOMeta.DIRTY_FIELDS, AssetEmployeeHandoverVOMeta.SORT_FIELD, AssetEmployeeHandoverVOMeta.SORT_TYPE, AssetEmployeeHandoverVOMeta.IDS })
    @SentinelResource(value = AssetEmployeeHandoverServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeHandoverServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AssetEmployeeHandoverVO assetEmployeeHandoverVO) {
        Result result = assetEmployeeHandoverService.update(assetEmployeeHandoverVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存资产交接
     */
    @ApiOperation(value = "保存资产交接")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID, value = "交接部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID, value = "交接人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetEmployeeHandoverVOMeta.PAGE_INDEX, AssetEmployeeHandoverVOMeta.PAGE_SIZE, AssetEmployeeHandoverVOMeta.SEARCH_FIELD, AssetEmployeeHandoverVOMeta.FUZZY_FIELD, AssetEmployeeHandoverVOMeta.SEARCH_VALUE, AssetEmployeeHandoverVOMeta.DIRTY_FIELDS, AssetEmployeeHandoverVOMeta.SORT_FIELD, AssetEmployeeHandoverVOMeta.SORT_TYPE, AssetEmployeeHandoverVOMeta.IDS })
    @SentinelResource(value = AssetEmployeeHandoverServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeHandoverServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AssetEmployeeHandoverVO assetEmployeeHandoverVO) {
        Result result = assetEmployeeHandoverService.save(assetEmployeeHandoverVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取资产交接
     */
    @ApiOperation(value = "获取资产交接")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AssetEmployeeHandoverServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeHandoverServiceProxy.GET_BY_ID)
    public Result<AssetEmployeeHandover> getById(String id) {
        Result<AssetEmployeeHandover> result = new Result<>();
        AssetEmployeeHandover assetEmployeeHandover = assetEmployeeHandoverService.getById(id);
        // join 关联的对象
        assetEmployeeHandoverService.dao().fill(assetEmployeeHandover).with("organization").with("receiveOrganization").with("originator").with("receiverUser").execute();
        assetEmployeeHandoverService.dao().join(assetEmployeeHandover.getOriginator(), Person.class);
        assetEmployeeHandoverService.dao().join(assetEmployeeHandover.getReceiverUser(), Person.class);
        result.success(true).data(assetEmployeeHandover);
        return result;
    }

    /**
     * 批量获取资产交接 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取资产交接")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AssetEmployeeHandoverServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeHandoverServiceProxy.GET_BY_IDS)
    public Result<List<AssetEmployeeHandover>> getByIds(List<String> ids) {
        Result<List<AssetEmployeeHandover>> result = new Result<>();
        List<AssetEmployeeHandover> list = assetEmployeeHandoverService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询资产交接
     */
    @ApiOperation(value = "查询资产交接")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID, value = "交接部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID, value = "交接人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AssetEmployeeHandoverVOMeta.PAGE_INDEX, AssetEmployeeHandoverVOMeta.PAGE_SIZE })
    @SentinelResource(value = AssetEmployeeHandoverServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeHandoverServiceProxy.QUERY_LIST)
    public Result<List<AssetEmployeeHandover>> queryList(AssetEmployeeHandoverVO sample) {
        Result<List<AssetEmployeeHandover>> result = new Result<>();
        List<AssetEmployeeHandover> list = assetEmployeeHandoverService.queryList(sample);
        List<Employee> employees = CollectorUtil.collectList(list, AssetEmployeeHandover::getOriginator);
        assetEmployeeHandoverService.dao().join(employees, Person.class);
        List<Employee> receivers = CollectorUtil.collectList(list, AssetEmployeeHandover::getReceiverUser);
        assetEmployeeHandoverService.dao().join(receivers, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询资产交接
     */
    @ApiOperation(value = "分页查询资产交接")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NAME, value = "业务名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORG_ID, value = "申请部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_ORG_ID, value = "交接部门", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECEIVE_USER_ID, value = "交接人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.CONTENT, value = "内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.RECORD_TIME, value = "记录时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.ORIGINATOR_ID, value = "制单人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AssetEmployeeHandoverVOMeta.SELECTED_CODE, value = "选择数据", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AssetEmployeeHandoverServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeHandoverServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AssetEmployeeHandover>> queryPagedList(AssetEmployeeHandoverVO sample) {
        Result<PagedList<AssetEmployeeHandover>> result = new Result<>();
        PagedList<AssetEmployeeHandover> list = assetEmployeeHandoverService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        assetEmployeeHandoverService.dao().fill(list).with("organization").with("receiveOrganization").with("originator").with("receiverUser").execute();
        // 填充流程相关的属性
        assetEmployeeHandoverService.joinProcess(list);
        List<Employee> employees = CollectorUtil.collectList(list, AssetEmployeeHandover::getOriginator);
        assetEmployeeHandoverService.dao().join(employees, Person.class);
        List<Employee> receivers = CollectorUtil.collectList(list, AssetEmployeeHandover::getReceiverUser);
        assetEmployeeHandoverService.dao().join(receivers, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     *  流程回调处理
     */
    @SentinelResource(value = AssetEmployeeHandoverServiceProxy.BPM_CALLBACK, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AssetEmployeeHandoverServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event) {
        return assetEmployeeHandoverService.onProcessCallback(event);
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = AssetEmployeeHandoverServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetEmployeeHandoverServiceProxy.EXPORT_EXCEL)
    public void exportExcel(AssetEmployeeHandoverVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            ExcelWriter ew = assetEmployeeHandoverService.exportExcel(sample);
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = AssetEmployeeHandoverServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetEmployeeHandoverServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = assetEmployeeHandoverService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = AssetEmployeeHandoverServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(AssetEmployeeHandoverServiceProxy.IMPORT_EXCEL)
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
        List<ValidateResult> errors = assetEmployeeHandoverService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
