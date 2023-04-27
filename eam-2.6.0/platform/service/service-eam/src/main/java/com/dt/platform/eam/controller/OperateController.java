package com.dt.platform.eam.controller;

import java.util.List;
import com.github.foxnic.commons.lang.StringUtil;
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
import com.dt.platform.proxy.eam.OperateServiceProxy;
import com.dt.platform.domain.eam.meta.OperateVOMeta;
import com.dt.platform.domain.eam.Operate;
import com.dt.platform.domain.eam.OperateVO;
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
import com.dt.platform.domain.eam.meta.OperateMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IOperateService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 资产操作 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-26 20:02:16
 */
@Api(tags = "资产操作")
@ApiSort(0)
@RestController("EamOperateController")
public class OperateController extends SuperController {

    @Autowired
    private IOperateService operateService;

    /**
     * 添加资产操作
     */
    @ApiOperation(value = "添加资产操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = OperateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.ALLOCATE_CODE, value = "分配编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.OPERATE_CODE, value = "操作编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.APPROVAL, value = "审批", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = OperateServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OperateServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(OperateVO operateVO) {
        Result result = operateService.insert(operateVO);
        return result;
    }

    /**
     * 删除资产操作
     */
    @ApiOperation(value = "删除资产操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = OperateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = OperateServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OperateServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = operateService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除资产操作 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除资产操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = OperateVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = OperateServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OperateServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = operateService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新资产操作
     */
    @ApiOperation(value = "更新资产操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = OperateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.ALLOCATE_CODE, value = "分配编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.OPERATE_CODE, value = "操作编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.APPROVAL, value = "审批", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { OperateVOMeta.PAGE_INDEX, OperateVOMeta.PAGE_SIZE, OperateVOMeta.SEARCH_FIELD, OperateVOMeta.FUZZY_FIELD, OperateVOMeta.SEARCH_VALUE, OperateVOMeta.SORT_FIELD, OperateVOMeta.SORT_TYPE, OperateVOMeta.IDS })
    @SentinelResource(value = OperateServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OperateServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(OperateVO operateVO) {
        Result result = operateService.update(operateVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 保存资产操作
     */
    @ApiOperation(value = "保存资产操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = OperateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.ALLOCATE_CODE, value = "分配编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.OPERATE_CODE, value = "操作编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.APPROVAL, value = "审批", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { OperateVOMeta.PAGE_INDEX, OperateVOMeta.PAGE_SIZE, OperateVOMeta.SEARCH_FIELD, OperateVOMeta.FUZZY_FIELD, OperateVOMeta.SEARCH_VALUE, OperateVOMeta.SORT_FIELD, OperateVOMeta.SORT_TYPE, OperateVOMeta.IDS })
    @SentinelResource(value = OperateServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OperateServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(OperateVO operateVO) {
        Result result = operateService.save(operateVO, SaveMode.NOT_NULL_FIELDS);
        return result;
    }

    /**
     * 获取资产操作
     */
    @ApiOperation(value = "获取资产操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = OperateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = OperateServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OperateServiceProxy.GET_BY_ID)
    public Result<Operate> getById(String id) {
        Result<Operate> result = new Result<>();
        Operate operate = operateService.getById(id);
        result.success(true).data(operate);
        return result;
    }

    /**
     * 批量删除资产操作 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除资产操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = OperateVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = OperateServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OperateServiceProxy.GET_BY_IDS)
    public Result<List<Operate>> getByIds(List<String> ids) {
        Result<List<Operate>> result = new Result<>();
        List<Operate> list = operateService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询资产操作
     */
    @ApiOperation(value = "查询资产操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = OperateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.ALLOCATE_CODE, value = "分配编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.OPERATE_CODE, value = "操作编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.APPROVAL, value = "审批", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { OperateVOMeta.PAGE_INDEX, OperateVOMeta.PAGE_SIZE })
    @SentinelResource(value = OperateServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OperateServiceProxy.QUERY_LIST)
    public Result<List<Operate>> queryList(OperateVO sample) {
        Result<List<Operate>> result = new Result<>();
        List<Operate> list = operateService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询资产操作
     */
    @ApiOperation(value = "分页查询资产操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = OperateVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.ALLOCATE_CODE, value = "分配编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.OPERATE_CODE, value = "操作编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.APPROVAL, value = "审批", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = OperateVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = OperateServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OperateServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Operate>> queryPagedList(OperateVO sample) {
        Result<PagedList<Operate>> result = new Result<>();
        PagedList<Operate> list = operateService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 是否需要审批
     */
    @ApiOperation(value = "获取资产操作")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "businessType", value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 9)
    @SentinelResource(value = OperateServiceProxy.APPROVAL_REQUIRED, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OperateServiceProxy.APPROVAL_REQUIRED)
    public Result approvalRequired(String businessType) {
        if (StringUtil.isBlank(businessType)) {
            return ErrorDesc.failureMessage("不存在businessType");
        }
        Result result = new Result();
        result.success(true).data(operateService.approvalRequired(businessType));
        return result;
    }

    /**
     *  资产更新判断
     */
    @ApiOperation(value = "资产更新判断")
    @ApiOperationSupport(order = 10)
    @SentinelResource(value = OperateServiceProxy.QUERY_ASSET_DIRECT_UPDATE_MODE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OperateServiceProxy.QUERY_ASSET_DIRECT_UPDATE_MODE)
    public Result queryAssetDirectUpdateMode() {
        Result result = new Result();
        result.success(true).data(operateService.queryAssetDirectUpdateMode());
        return result;
    }

    /**
     *  资产更新判断
     */
    @ApiOperation(value = "资产更新判断")
    @ApiOperationSupport(order = 11)
    @SentinelResource(value = OperateServiceProxy.QUERY_ASSET_STATUS_COLUMN_DISABLE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OperateServiceProxy.QUERY_ASSET_STATUS_COLUMN_DISABLE)
    public Result queryAssetStatusColumnDisable() {
        Result result = new Result();
        result.success(true).data(operateService.queryAssetStatusColumnDisable());
        return result;
    }

    /**
     *  资产编码判断
     */
    @ApiOperation(value = "资产编码判断")
    @ApiOperationSupport(order = 12)
    @SentinelResource(value = OperateServiceProxy.QUERY_ASSET_CODE_AUTO_CREATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(OperateServiceProxy.QUERY_ASSET_CODE_AUTO_CREATE)
    public Result queryAssetCodeAutoCreate() {
        Result result = new Result();
        result.success(true).data(operateService.queryAssetCodeAutoCreate());
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = OperateServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(OperateServiceProxy.EXPORT_EXCEL)
    public void exportExcel(OperateVO sample, HttpServletResponse response) throws Exception {
        // 生成 Excel 数据
        ExcelWriter ew = operateService.exportExcel(sample);
        // 下载
        DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = OperateServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(OperateServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        // 生成 Excel 模版
        ExcelWriter ew = operateService.exportExcelTemplate();
        // 下载
        DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
    }

    @SentinelResource(value = OperateServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(OperateServiceProxy.IMPORT_EXCEL)
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
        List<ValidateResult> errors = operateService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
