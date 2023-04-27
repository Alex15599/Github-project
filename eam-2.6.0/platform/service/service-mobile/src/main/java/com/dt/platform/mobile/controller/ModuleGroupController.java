package com.dt.platform.mobile.controller;

import java.util.ArrayList;
import java.util.List;

import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.domain.mobile.meta.ModuleInfoMeta;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
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
import com.dt.platform.proxy.mobile.ModuleGroupServiceProxy;
import com.dt.platform.domain.mobile.meta.ModuleGroupVOMeta;
import com.dt.platform.domain.mobile.ModuleGroup;
import com.dt.platform.domain.mobile.ModuleGroupVO;
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
import com.dt.platform.domain.mobile.meta.ModuleGroupMeta;
import com.dt.platform.domain.mobile.ModuleInfo;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.mobile.service.IModuleGroupService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 移动端模块分组 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-28 20:41:10
 */
@Api(tags = "移动端模块分组")
@ApiSort(0)
@RestController("AppModuleGroupController")
public class ModuleGroupController extends SuperController {

    @Autowired
    private IModuleGroupService moduleGroupService;

    /**
     * 添加移动端模块分组
     */
    @ApiOperation(value = "添加移动端模块分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ModuleGroupVOMeta.TYPE, value = "类型", required = true, dataTypeClass = String.class, example = "eam"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "固资管理"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "EAM_固资产管理"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ModuleGroupServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleGroupServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ModuleGroupVO moduleGroupVO) {
        Result result = moduleGroupService.insert(moduleGroupVO, false);
        return result;
    }

    /**
     * 删除移动端模块分组
     */
    @ApiOperation(value = "删除移动端模块分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ModuleGroupServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleGroupServiceProxy.DELETE)
    public Result deleteById(String id) {
        Result result = moduleGroupService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除移动端模块分组 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除移动端模块分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleGroupVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ModuleGroupServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleGroupServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        Result result = moduleGroupService.deleteByIdsLogical(ids);
        return result;
    }

    /**
     * 更新移动端模块分组
     */
    @ApiOperation(value = "更新移动端模块分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ModuleGroupVOMeta.TYPE, value = "类型", required = true, dataTypeClass = String.class, example = "eam"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "固资管理"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "EAM_固资产管理"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { ModuleGroupVOMeta.PAGE_INDEX, ModuleGroupVOMeta.PAGE_SIZE, ModuleGroupVOMeta.SEARCH_FIELD, ModuleGroupVOMeta.FUZZY_FIELD, ModuleGroupVOMeta.SEARCH_VALUE, ModuleGroupVOMeta.DIRTY_FIELDS, ModuleGroupVOMeta.SORT_FIELD, ModuleGroupVOMeta.SORT_TYPE, ModuleGroupVOMeta.IDS })
    @SentinelResource(value = ModuleGroupServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleGroupServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ModuleGroupVO moduleGroupVO) {
        Result result = moduleGroupService.update(moduleGroupVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存移动端模块分组
     */
    @ApiOperation(value = "保存移动端模块分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ModuleGroupVOMeta.TYPE, value = "类型", required = true, dataTypeClass = String.class, example = "eam"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "固资管理"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "EAM_固资产管理"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ModuleGroupVOMeta.PAGE_INDEX, ModuleGroupVOMeta.PAGE_SIZE, ModuleGroupVOMeta.SEARCH_FIELD, ModuleGroupVOMeta.FUZZY_FIELD, ModuleGroupVOMeta.SEARCH_VALUE, ModuleGroupVOMeta.DIRTY_FIELDS, ModuleGroupVOMeta.SORT_FIELD, ModuleGroupVOMeta.SORT_TYPE, ModuleGroupVOMeta.IDS })
    @SentinelResource(value = ModuleGroupServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleGroupServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ModuleGroupVO moduleGroupVO) {
        Result result = moduleGroupService.save(moduleGroupVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取移动端模块分组
     */
    @ApiOperation(value = "获取移动端模块分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ModuleGroupServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleGroupServiceProxy.GET_BY_ID)
    public Result<ModuleGroup> getById(String id) {
        Result<ModuleGroup> result = new Result<>();
        ModuleGroup moduleGroup = moduleGroupService.getById(id);
        result.success(true).data(moduleGroup);
        return result;
    }

    /**
     * 批量获取移动端模块分组 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取移动端模块分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleGroupVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ModuleGroupServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleGroupServiceProxy.GET_BY_IDS)
    public Result<List<ModuleGroup>> getByIds(List<String> ids) {
        Result<List<ModuleGroup>> result = new Result<>();
        List<ModuleGroup> list = moduleGroupService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询移动端模块分组
     */
    @ApiOperation(value = "查询移动端模块分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ModuleGroupVOMeta.TYPE, value = "类型", required = true, dataTypeClass = String.class, example = "eam"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "固资管理"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "EAM_固资产管理"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ModuleGroupVOMeta.PAGE_INDEX, ModuleGroupVOMeta.PAGE_SIZE })
    @SentinelResource(value = ModuleGroupServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleGroupServiceProxy.QUERY_LIST)
    public Result<List<ModuleGroup>> queryList(ModuleGroupVO sample) {
        Result<List<ModuleGroup>> result = new Result<>();
        List<ModuleGroup> list = moduleGroupService.queryList(sample);
        // join 关联的对象
        moduleGroupService.dao().fill(list).with(ModuleGroupMeta.MODULE_INFO_LIST).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询移动端模块分组
     */
    @ApiOperation(value = "分页查询移动端模块分组")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ModuleGroupVOMeta.TYPE, value = "类型", required = true, dataTypeClass = String.class, example = "eam"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "固资管理"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "EAM_固资产管理"),
		@ApiImplicitParam(name = ModuleGroupVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ModuleGroupServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleGroupServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ModuleGroup>> queryPagedList(ModuleGroupVO sample) {
        Result<PagedList<ModuleGroup>> result = new Result<>();
        PagedList<ModuleGroup> list = moduleGroupService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        moduleGroupService.dao().fill(list).with(ModuleGroupMeta.MODULE_INFO_LIST).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询移动端模块分组
     */
    @ApiOperation(value = "分页查询移动端模块分组")
    @ApiImplicitParams({
            @ApiImplicitParam(name = ModuleGroupVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
            @ApiImplicitParam(name = ModuleGroupVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
            @ApiImplicitParam(name = ModuleGroupVOMeta.TYPE, value = "类型", required = true, dataTypeClass = String.class, example = "eam"),
            @ApiImplicitParam(name = ModuleGroupVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "固资管理"),
            @ApiImplicitParam(name = ModuleGroupVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
            @ApiImplicitParam(name = ModuleGroupVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "EAM_固资产管理"),
            @ApiImplicitParam(name = ModuleGroupVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
    })
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ModuleGroupServiceProxy.QUERY_FOR_MOBILE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleGroupServiceProxy.QUERY_FOR_MOBILE)
    public Result<List<ModuleGroup>> queryForMobile(ModuleGroupVO sample) {
        sample.setStatus(StatusEnableEnum.ENABLE.code());
        Result<List<ModuleGroup>> result = new Result<>();
        List<ModuleGroup> list = moduleGroupService.queryList(sample);
        // join 关联的对象
        if(list!=null&&list.size()>0){
            moduleGroupService.dao().fill(list).with(ModuleGroupMeta.MODULE_INFO_LIST).execute();
            for(int i=0;i<list.size();i++){
                List<ModuleInfo> infoList=list.get(i).getModuleInfoList();
                if(infoList!=null&&infoList.size()>0){
                    List<ModuleInfo> infoList2=new ArrayList<>();
                    for(ModuleInfo info:infoList){
                        if(SessionUser.getCurrent().permission().checkAuth(info.getCode())){
                            if(StatusEnableEnum.ENABLE.code().equals(info.getStatus())) {
                                infoList2.add(info);
                            }
                        }
                    }
                    list.get(i).setModuleInfoList(infoList2);
                }
            }
        }
        result.success(true).data(list);
        return result;
    }


    /**
     * 导出 Excel
     */
    @SentinelResource(value = ModuleGroupServiceProxy.EXPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(ModuleGroupServiceProxy.EXPORT_EXCEL)
    public void exportExcel(ModuleGroupVO sample, HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 数据
            ExcelWriter ew = moduleGroupService.exportExcel(sample);
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    /**
     * 导出 Excel 模板
     */
    @SentinelResource(value = ModuleGroupServiceProxy.EXPORT_EXCEL_TEMPLATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(ModuleGroupServiceProxy.EXPORT_EXCEL_TEMPLATE)
    public void exportExcelTemplate(HttpServletResponse response) throws Exception {
        try {
            // 生成 Excel 模版
            ExcelWriter ew = moduleGroupService.exportExcelTemplate();
            // 下载
            DownloadUtil.writeToOutput(response, ew.getWorkBook(), ew.getWorkBookName());
        } catch (Exception e) {
            DownloadUtil.writeDownloadError(response, e);
        }
    }

    @SentinelResource(value = ModuleGroupServiceProxy.IMPORT_EXCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @RequestMapping(ModuleGroupServiceProxy.IMPORT_EXCEL)
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
        List<ValidateResult> errors = moduleGroupService.importExcel(input, 0, true);
        if (errors == null || errors.isEmpty()) {
            return ErrorDesc.success();
        } else {
            return ErrorDesc.failure().message("导入失败").data(errors);
        }
    }
}
