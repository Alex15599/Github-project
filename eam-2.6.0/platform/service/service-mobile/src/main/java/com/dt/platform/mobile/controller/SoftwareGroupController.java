package com.dt.platform.mobile.controller;

import java.util.List;
import com.dt.platform.domain.eam.meta.MaintainTaskMeta;
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
import com.dt.platform.proxy.mobile.SoftwareGroupServiceProxy;
import com.dt.platform.domain.mobile.meta.SoftwareGroupVOMeta;
import com.dt.platform.domain.mobile.SoftwareGroup;
import com.dt.platform.domain.mobile.SoftwareGroupVO;
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
import com.dt.platform.domain.mobile.meta.SoftwareGroupMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.mobile.service.ISoftwareGroupService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 软件组 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-26 08:16:10
 */
@Api(tags = "软件组")
@ApiSort(0)
@RestController("AppSoftwareGroupController")
public class SoftwareGroupController extends SuperController {

    @Autowired
    private ISoftwareGroupService softwareGroupService;

    /**
     * 添加软件组
     */
    @ApiOperation(value = "添加软件组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = SoftwareGroupServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareGroupServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(SoftwareGroupVO softwareGroupVO) {
        Result result = softwareGroupService.insert(softwareGroupVO, false);
        return result;
    }

    /**
     * 删除软件组
     */
    @ApiOperation(value = "删除软件组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = SoftwareGroupServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareGroupServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = softwareGroupService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除软件组 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除软件组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareGroupVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = SoftwareGroupServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareGroupServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = softwareGroupService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新软件组
     */
    @ApiOperation(value = "更新软件组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { SoftwareGroupVOMeta.PAGE_INDEX, SoftwareGroupVOMeta.PAGE_SIZE, SoftwareGroupVOMeta.SEARCH_FIELD, SoftwareGroupVOMeta.FUZZY_FIELD, SoftwareGroupVOMeta.SEARCH_VALUE, SoftwareGroupVOMeta.DIRTY_FIELDS, SoftwareGroupVOMeta.SORT_FIELD, SoftwareGroupVOMeta.SORT_TYPE, SoftwareGroupVOMeta.IDS })
    @SentinelResource(value = SoftwareGroupServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareGroupServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(SoftwareGroupVO softwareGroupVO) {
        Result result = softwareGroupService.update(softwareGroupVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存软件组
     */
    @ApiOperation(value = "保存软件组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { SoftwareGroupVOMeta.PAGE_INDEX, SoftwareGroupVOMeta.PAGE_SIZE, SoftwareGroupVOMeta.SEARCH_FIELD, SoftwareGroupVOMeta.FUZZY_FIELD, SoftwareGroupVOMeta.SEARCH_VALUE, SoftwareGroupVOMeta.DIRTY_FIELDS, SoftwareGroupVOMeta.SORT_FIELD, SoftwareGroupVOMeta.SORT_TYPE, SoftwareGroupVOMeta.IDS })
    @SentinelResource(value = SoftwareGroupServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareGroupServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(SoftwareGroupVO softwareGroupVO) {
        Result result = softwareGroupService.save(softwareGroupVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取软件组
     */
    @ApiOperation(value = "获取软件组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = SoftwareGroupServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareGroupServiceProxy.GET_BY_ID)
    public Result<SoftwareGroup> getById(String id) {
        Result<SoftwareGroup> result = new Result<>();
        SoftwareGroup softwareGroup = softwareGroupService.getById(id);
        result.success(true).data(softwareGroup);
        return result;
    }

    /**
     * 批量获取软件组 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取软件组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareGroupVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = SoftwareGroupServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareGroupServiceProxy.GET_BY_IDS)
    public Result<List<SoftwareGroup>> getByIds(List<String> ids) {
        Result<List<SoftwareGroup>> result = new Result<>();
        List<SoftwareGroup> list = softwareGroupService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询软件组
     */
    @ApiOperation(value = "查询软件组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { SoftwareGroupVOMeta.PAGE_INDEX, SoftwareGroupVOMeta.PAGE_SIZE })
    @SentinelResource(value = SoftwareGroupServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareGroupServiceProxy.QUERY_LIST)
    public Result<List<SoftwareGroup>> queryList(SoftwareGroupVO sample) {
        Result<List<SoftwareGroup>> result = new Result<>();
        List<SoftwareGroup> list = softwareGroupService.queryList(sample);
        softwareGroupService.dao().fill(list).with(SoftwareGroupMeta.SOFTWARE_INFO_LIST).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询软件组
     */
    @ApiOperation(value = "分页查询软件组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = SoftwareGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = SoftwareGroupVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = SoftwareGroupServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(SoftwareGroupServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<SoftwareGroup>> queryPagedList(SoftwareGroupVO sample) {
        Result<PagedList<SoftwareGroup>> result = new Result<>();
        PagedList<SoftwareGroup> list = softwareGroupService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        softwareGroupService.dao().fill(list).with(SoftwareGroupMeta.SOFTWARE_INFO_LIST).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = SoftwareGroupServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(SoftwareGroupServiceProxy.EXPORT_EXCEL)
    public void exportExcel(SoftwareGroupVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            ExcelWriter ew = softwareGroupService.exportExcel(sample);
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = SoftwareGroupServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(SoftwareGroupServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = softwareGroupService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = SoftwareGroupServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(SoftwareGroupServiceProxy.IMPORT_EXCEL)
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
        List<ValidateResult> errors = softwareGroupService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
