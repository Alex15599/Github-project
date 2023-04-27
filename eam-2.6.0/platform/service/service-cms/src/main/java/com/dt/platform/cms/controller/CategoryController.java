package com.dt.platform.cms.controller;

import java.util.List;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.github.foxnic.web.framework.web.SuperController;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.proxy.cms.CategoryServiceProxy;
import com.dt.platform.domain.cms.meta.CategoryVOMeta;
import com.dt.platform.domain.cms.Category;
import com.dt.platform.domain.cms.CategoryVO;
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
import com.dt.platform.domain.cms.meta.CategoryMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.cms.service.ICategoryService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 类型 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-04-10 11:54:36
 */
@Api(tags = "类型")
@ApiSort(0)
@RestController("CmsCategoryController")
public class CategoryController extends SuperController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * 添加类型
     */
    @ApiOperation(value = "添加类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CategoryVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CODE, value = "代码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = CategoryServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CategoryServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(CategoryVO categoryVO) {
        Result result = categoryService.insert(categoryVO, false);
        return result;
    }

    /**
     * 删除类型
     */
    @ApiOperation(value = "删除类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CategoryVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = CategoryServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CategoryServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = categoryService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除类型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CategoryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = CategoryServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CategoryServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = categoryService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新类型
     */
    @ApiOperation(value = "更新类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CategoryVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CODE, value = "代码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { CategoryVOMeta.PAGE_INDEX, CategoryVOMeta.PAGE_SIZE, CategoryVOMeta.SEARCH_FIELD, CategoryVOMeta.FUZZY_FIELD, CategoryVOMeta.SEARCH_VALUE, CategoryVOMeta.DIRTY_FIELDS, CategoryVOMeta.SORT_FIELD, CategoryVOMeta.SORT_TYPE, CategoryVOMeta.IDS })
    @SentinelResource(value = CategoryServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CategoryServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(CategoryVO categoryVO) {
        Result result = categoryService.update(categoryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存类型
     */
    @ApiOperation(value = "保存类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CategoryVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CODE, value = "代码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { CategoryVOMeta.PAGE_INDEX, CategoryVOMeta.PAGE_SIZE, CategoryVOMeta.SEARCH_FIELD, CategoryVOMeta.FUZZY_FIELD, CategoryVOMeta.SEARCH_VALUE, CategoryVOMeta.DIRTY_FIELDS, CategoryVOMeta.SORT_FIELD, CategoryVOMeta.SORT_TYPE, CategoryVOMeta.IDS })
    @SentinelResource(value = CategoryServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CategoryServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(CategoryVO categoryVO) {
        Result result = categoryService.save(categoryVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取类型
     */
    @ApiOperation(value = "获取类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CategoryVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = CategoryServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CategoryServiceProxy.GET_BY_ID)
    public Result<Category> getById(String id) {
        Result<Category> result = new Result<>();
        Category category = categoryService.getById(id);
        result.success(true).data(category);
        return result;
    }

    /**
     * 批量获取类型 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CategoryVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = CategoryServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CategoryServiceProxy.GET_BY_IDS)
    public Result<List<Category>> getByIds(List<String> ids) {
        Result<List<Category>> result = new Result<>();
        List<Category> list = categoryService.getByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询类型
     */
    @ApiOperation(value = "查询类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CategoryVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CODE, value = "代码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { CategoryVOMeta.PAGE_INDEX, CategoryVOMeta.PAGE_SIZE })
    @SentinelResource(value = CategoryServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CategoryServiceProxy.QUERY_LIST)
    public Result<List<Category>> queryList(CategoryVO sample) {
        Result<List<Category>> result = new Result<>();
        List<Category> list = categoryService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询类型
     */
    @ApiOperation(value = "分页查询类型")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = CategoryVOMeta.ID, value = "ID", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.CODE, value = "代码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CategoryVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = CategoryServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CategoryServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Category>> queryPagedList(CategoryVO sample) {
        Result<PagedList<Category>> result = new Result<>();
        PagedList<Category> list = categoryService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }

    /**
     * 导出 Excel
     */
    @SentinelResource(value = CategoryServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(CategoryServiceProxy.EXPORT_EXCEL)
    public void exportExcel(CategoryVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            ExcelWriter ew = categoryService.exportExcel(sample);
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = CategoryServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(CategoryServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = categoryService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = CategoryServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(CategoryServiceProxy.IMPORT_EXCEL)
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
        List<ValidateResult> errors = categoryService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
