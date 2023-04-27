package com.dt.platform.mobile.controller;

import java.util.List;
import java.util.ArrayList;
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
import com.dt.platform.proxy.mobile.ModuleInfoServiceProxy;
import com.dt.platform.domain.mobile.meta.ModuleInfoVOMeta;
import com.dt.platform.domain.mobile.ModuleInfo;
import com.dt.platform.domain.mobile.ModuleInfoVO;
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
import com.dt.platform.domain.mobile.meta.ModuleInfoMeta;
import com.dt.platform.domain.mobile.ModuleGroup;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.mobile.service.IModuleInfoService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 移动端模块 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-20 22:31:33
 */
@Api(tags = "移动端模块")
@ApiSort(0)
@RestController("AppModuleInfoController")
public class ModuleInfoController extends SuperController {

    @Autowired
    private IModuleInfoService moduleInfoService;

    /**
     * 添加移动端模块
     */
    @ApiOperation(value = "添加移动端模块")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "eam_mobile_asset_mgr_repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "简单报修"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class, example = "2"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NAME, value = "图标", required = false, dataTypeClass = String.class, example = "/static/functionIcon/setting.png"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.PATH, value = "路径", required = false, dataTypeClass = String.class, example = "/pages/index/repair/repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ModuleInfoVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = ModuleInfoServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleInfoServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(ModuleInfoVO moduleInfoVO) {
        Result result = moduleInfoService.insert(moduleInfoVO, false);
        return result;
    }

    /**
     * 删除移动端模块
     */
    @ApiOperation(value = "删除移动端模块")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = ModuleInfoServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleInfoServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  moduleInfoService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = moduleInfoService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除移动端模块 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除移动端模块")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleInfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ModuleInfoServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleInfoServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = moduleInfoService.hasRefers(ids);
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
            Result result = moduleInfoService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = moduleInfoService.deleteByIdsLogical(canDeleteIds);
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
     * 更新移动端模块
     */
    @ApiOperation(value = "更新移动端模块")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "eam_mobile_asset_mgr_repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "简单报修"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class, example = "2"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NAME, value = "图标", required = false, dataTypeClass = String.class, example = "/static/functionIcon/setting.png"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.PATH, value = "路径", required = false, dataTypeClass = String.class, example = "/pages/index/repair/repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ModuleInfoVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { ModuleInfoVOMeta.PAGE_INDEX, ModuleInfoVOMeta.PAGE_SIZE, ModuleInfoVOMeta.SEARCH_FIELD, ModuleInfoVOMeta.FUZZY_FIELD, ModuleInfoVOMeta.SEARCH_VALUE, ModuleInfoVOMeta.DIRTY_FIELDS, ModuleInfoVOMeta.SORT_FIELD, ModuleInfoVOMeta.SORT_TYPE, ModuleInfoVOMeta.IDS })
    @SentinelResource(value = ModuleInfoServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleInfoServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(ModuleInfoVO moduleInfoVO) {
        Result result = moduleInfoService.update(moduleInfoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存移动端模块
     */
    @ApiOperation(value = "保存移动端模块")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "eam_mobile_asset_mgr_repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "简单报修"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class, example = "2"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NAME, value = "图标", required = false, dataTypeClass = String.class, example = "/static/functionIcon/setting.png"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.PATH, value = "路径", required = false, dataTypeClass = String.class, example = "/pages/index/repair/repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ModuleInfoVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ModuleInfoVOMeta.PAGE_INDEX, ModuleInfoVOMeta.PAGE_SIZE, ModuleInfoVOMeta.SEARCH_FIELD, ModuleInfoVOMeta.FUZZY_FIELD, ModuleInfoVOMeta.SEARCH_VALUE, ModuleInfoVOMeta.DIRTY_FIELDS, ModuleInfoVOMeta.SORT_FIELD, ModuleInfoVOMeta.SORT_TYPE, ModuleInfoVOMeta.IDS })
    @SentinelResource(value = ModuleInfoServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleInfoServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(ModuleInfoVO moduleInfoVO) {
        Result result = moduleInfoService.save(moduleInfoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取移动端模块
     */
    @ApiOperation(value = "获取移动端模块")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = ModuleInfoServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleInfoServiceProxy.GET_BY_ID)
    public Result<ModuleInfo> getById(String id) {
        Result<ModuleInfo> result = new Result<>();
        ModuleInfo moduleInfo = moduleInfoService.getById(id);
        // join 关联的对象
        moduleInfoService.dao().fill(moduleInfo).with(ModuleInfoMeta.MODULE_GROUP).execute();
        result.success(true).data(moduleInfo);
        return result;
    }

    /**
     * 批量获取移动端模块 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取移动端模块")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleInfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = ModuleInfoServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleInfoServiceProxy.GET_BY_IDS)
    public Result<List<ModuleInfo>> getByIds(List<String> ids) {
        Result<List<ModuleInfo>> result = new Result<>();
        List<ModuleInfo> list = moduleInfoService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询移动端模块
     */
    @ApiOperation(value = "查询移动端模块")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "eam_mobile_asset_mgr_repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "简单报修"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class, example = "2"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NAME, value = "图标", required = false, dataTypeClass = String.class, example = "/static/functionIcon/setting.png"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.PATH, value = "路径", required = false, dataTypeClass = String.class, example = "/pages/index/repair/repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ModuleInfoVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { ModuleInfoVOMeta.PAGE_INDEX, ModuleInfoVOMeta.PAGE_SIZE })
    @SentinelResource(value = ModuleInfoServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleInfoServiceProxy.QUERY_LIST)
    public Result<List<ModuleInfo>> queryList(ModuleInfoVO sample) {
        Result<List<ModuleInfo>> result = new Result<>();
        List<ModuleInfo> list = moduleInfoService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询移动端模块
     */
    @ApiOperation(value = "分页查询移动端模块")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = ModuleInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class, example = "eam_mobile_asset_mgr_repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class, example = "简单报修"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class, example = "2"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NAME, value = "图标", required = false, dataTypeClass = String.class, example = "/static/functionIcon/setting.png"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.PATH, value = "路径", required = false, dataTypeClass = String.class, example = "/pages/index/repair/repair"),
		@ApiImplicitParam(name = ModuleInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = ModuleInfoVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class, example = "0")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = ModuleInfoServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(ModuleInfoServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<ModuleInfo>> queryPagedList(ModuleInfoVO sample) {
        Result<PagedList<ModuleInfo>> result = new Result<>();
        PagedList<ModuleInfo> list = moduleInfoService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        moduleInfoService.dao().fill(list).with(ModuleInfoMeta.MODULE_GROUP).execute();
        result.success(true).data(list);
        return result;
    }
}
