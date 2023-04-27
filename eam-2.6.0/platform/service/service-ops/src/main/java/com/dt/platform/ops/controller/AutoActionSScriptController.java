package com.dt.platform.ops.controller;

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
import com.dt.platform.proxy.ops.AutoActionSScriptServiceProxy;
import com.dt.platform.domain.ops.meta.AutoActionSScriptVOMeta;
import com.dt.platform.domain.ops.AutoActionSScript;
import com.dt.platform.domain.ops.AutoActionSScriptVO;
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
import com.dt.platform.domain.ops.meta.AutoActionSScriptMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IAutoActionSScriptService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 脚本选择 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-21 15:00:39
 */
@Api(tags = "脚本选择")
@ApiSort(0)
@RestController("OpsAutoActionSScriptController")
public class AutoActionSScriptController extends SuperController {

    @Autowired
    private IAutoActionSScriptService autoActionSScriptService;

    /**
     * 添加脚本选择
     */
    @ApiOperation(value = "添加脚本选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.SCRIPT_ID, value = "文件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AutoActionSScriptServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSScriptServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AutoActionSScriptVO autoActionSScriptVO) {
        Result result = autoActionSScriptService.insert(autoActionSScriptVO, false);
        return result;
    }

    /**
     * 删除脚本选择
     */
    @ApiOperation(value = "删除脚本选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AutoActionSScriptServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSScriptServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  autoActionSScriptService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = autoActionSScriptService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除脚本选择 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除脚本选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoActionSScriptServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSScriptServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = autoActionSScriptService.hasRefers(ids);
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
            Result result = autoActionSScriptService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = autoActionSScriptService.deleteByIdsLogical(canDeleteIds);
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
     * 更新脚本选择
     */
    @ApiOperation(value = "更新脚本选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.SCRIPT_ID, value = "文件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AutoActionSScriptVOMeta.PAGE_INDEX, AutoActionSScriptVOMeta.PAGE_SIZE, AutoActionSScriptVOMeta.SEARCH_FIELD, AutoActionSScriptVOMeta.FUZZY_FIELD, AutoActionSScriptVOMeta.SEARCH_VALUE, AutoActionSScriptVOMeta.DIRTY_FIELDS, AutoActionSScriptVOMeta.SORT_FIELD, AutoActionSScriptVOMeta.SORT_TYPE, AutoActionSScriptVOMeta.IDS })
    @SentinelResource(value = AutoActionSScriptServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSScriptServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AutoActionSScriptVO autoActionSScriptVO) {
        Result result = autoActionSScriptService.update(autoActionSScriptVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存脚本选择
     */
    @ApiOperation(value = "保存脚本选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.SCRIPT_ID, value = "文件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoActionSScriptVOMeta.PAGE_INDEX, AutoActionSScriptVOMeta.PAGE_SIZE, AutoActionSScriptVOMeta.SEARCH_FIELD, AutoActionSScriptVOMeta.FUZZY_FIELD, AutoActionSScriptVOMeta.SEARCH_VALUE, AutoActionSScriptVOMeta.DIRTY_FIELDS, AutoActionSScriptVOMeta.SORT_FIELD, AutoActionSScriptVOMeta.SORT_TYPE, AutoActionSScriptVOMeta.IDS })
    @SentinelResource(value = AutoActionSScriptServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSScriptServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AutoActionSScriptVO autoActionSScriptVO) {
        Result result = autoActionSScriptService.save(autoActionSScriptVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取脚本选择
     */
    @ApiOperation(value = "获取脚本选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AutoActionSScriptServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSScriptServiceProxy.GET_BY_ID)
    public Result<AutoActionSScript> getById(String id) {
        Result<AutoActionSScript> result = new Result<>();
        AutoActionSScript autoActionSScript = autoActionSScriptService.getById(id);
        result.success(true).data(autoActionSScript);
        return result;
    }

    /**
     * 批量获取脚本选择 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取脚本选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoActionSScriptServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSScriptServiceProxy.GET_BY_IDS)
    public Result<List<AutoActionSScript>> getByIds(List<String> ids) {
        Result<List<AutoActionSScript>> result = new Result<>();
        List<AutoActionSScript> list = autoActionSScriptService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询脚本选择
     */
    @ApiOperation(value = "查询脚本选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.SCRIPT_ID, value = "文件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoActionSScriptVOMeta.PAGE_INDEX, AutoActionSScriptVOMeta.PAGE_SIZE })
    @SentinelResource(value = AutoActionSScriptServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSScriptServiceProxy.QUERY_LIST)
    public Result<List<AutoActionSScript>> queryList(AutoActionSScriptVO sample) {
        Result<List<AutoActionSScript>> result = new Result<>();
        List<AutoActionSScript> list = autoActionSScriptService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询脚本选择
     */
    @ApiOperation(value = "分页查询脚本选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSScriptVOMeta.SCRIPT_ID, value = "文件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AutoActionSScriptServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSScriptServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AutoActionSScript>> queryPagedList(AutoActionSScriptVO sample) {
        Result<PagedList<AutoActionSScript>> result = new Result<>();
        PagedList<AutoActionSScript> list = autoActionSScriptService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
