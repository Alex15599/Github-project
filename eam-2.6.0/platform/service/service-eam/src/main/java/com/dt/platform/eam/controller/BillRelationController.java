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
import com.dt.platform.proxy.eam.BillRelationServiceProxy;
import com.dt.platform.domain.eam.meta.BillRelationVOMeta;
import com.dt.platform.domain.eam.BillRelation;
import com.dt.platform.domain.eam.BillRelationVO;
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
import com.dt.platform.domain.eam.meta.BillRelationMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IBillRelationService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 单据关联 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-24 19:16:17
 */
@Api(tags = "单据关联")
@ApiSort(0)
@RestController("EamBillRelationController")
public class BillRelationController extends SuperController {

    @Autowired
    private IBillRelationService billRelationService;

    /**
     * 添加单据关联
     */
    @ApiOperation(value = "添加单据关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = BillRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = BillRelationVOMeta.MASTER_ID, value = "主节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BillRelationVOMeta.SLAVER_ID, value = "从节点", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = BillRelationServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BillRelationServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(BillRelationVO billRelationVO) {
        Result result = billRelationService.insert(billRelationVO, false);
        return result;
    }

    /**
     * 删除单据关联
     */
    @ApiOperation(value = "删除单据关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = BillRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = BillRelationServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BillRelationServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = billRelationService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除单据关联 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除单据关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = BillRelationVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = BillRelationServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BillRelationServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = billRelationService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新单据关联
     */
    @ApiOperation(value = "更新单据关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = BillRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = BillRelationVOMeta.MASTER_ID, value = "主节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BillRelationVOMeta.SLAVER_ID, value = "从节点", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { BillRelationVOMeta.PAGE_INDEX, BillRelationVOMeta.PAGE_SIZE, BillRelationVOMeta.SEARCH_FIELD, BillRelationVOMeta.FUZZY_FIELD, BillRelationVOMeta.SEARCH_VALUE, BillRelationVOMeta.DIRTY_FIELDS, BillRelationVOMeta.SORT_FIELD, BillRelationVOMeta.SORT_TYPE, BillRelationVOMeta.IDS })
    @SentinelResource(value = BillRelationServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BillRelationServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(BillRelationVO billRelationVO) {
        Result result = billRelationService.update(billRelationVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存单据关联
     */
    @ApiOperation(value = "保存单据关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = BillRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = BillRelationVOMeta.MASTER_ID, value = "主节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BillRelationVOMeta.SLAVER_ID, value = "从节点", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { BillRelationVOMeta.PAGE_INDEX, BillRelationVOMeta.PAGE_SIZE, BillRelationVOMeta.SEARCH_FIELD, BillRelationVOMeta.FUZZY_FIELD, BillRelationVOMeta.SEARCH_VALUE, BillRelationVOMeta.DIRTY_FIELDS, BillRelationVOMeta.SORT_FIELD, BillRelationVOMeta.SORT_TYPE, BillRelationVOMeta.IDS })
    @SentinelResource(value = BillRelationServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BillRelationServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(BillRelationVO billRelationVO) {
        Result result = billRelationService.save(billRelationVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取单据关联
     */
    @ApiOperation(value = "获取单据关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = BillRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = BillRelationServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BillRelationServiceProxy.GET_BY_ID)
    public Result<BillRelation> getById(String id) {
        Result<BillRelation> result = new Result<>();
        BillRelation billRelation = billRelationService.getById(id);
        result.success(true).data(billRelation);
        return result;
    }

    /**
     * 批量获取单据关联 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取单据关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = BillRelationVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = BillRelationServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BillRelationServiceProxy.GET_BY_IDS)
    public Result<List<BillRelation>> getByIds(List<String> ids) {
        Result<List<BillRelation>> result = new Result<>();
        List<BillRelation> list = billRelationService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询单据关联
     */
    @ApiOperation(value = "查询单据关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = BillRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = BillRelationVOMeta.MASTER_ID, value = "主节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BillRelationVOMeta.SLAVER_ID, value = "从节点", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { BillRelationVOMeta.PAGE_INDEX, BillRelationVOMeta.PAGE_SIZE })
    @SentinelResource(value = BillRelationServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BillRelationServiceProxy.QUERY_LIST)
    public Result<List<BillRelation>> queryList(BillRelationVO sample) {
        Result<List<BillRelation>> result = new Result<>();
        List<BillRelation> list = billRelationService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询单据关联
     */
    @ApiOperation(value = "分页查询单据关联")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = BillRelationVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = BillRelationVOMeta.MASTER_ID, value = "主节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = BillRelationVOMeta.SLAVER_ID, value = "从节点", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = BillRelationServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(BillRelationServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<BillRelation>> queryPagedList(BillRelationVO sample) {
        Result<PagedList<BillRelation>> result = new Result<>();
        PagedList<BillRelation> list = billRelationService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = BillRelationServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(BillRelationServiceProxy.EXPORT_EXCEL)
    public void exportExcel(BillRelationVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            ExcelWriter ew = billRelationService.exportExcel(sample);
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = BillRelationServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(BillRelationServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = billRelationService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = BillRelationServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(BillRelationServiceProxy.IMPORT_EXCEL)
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
        List<ValidateResult> errors = billRelationService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
