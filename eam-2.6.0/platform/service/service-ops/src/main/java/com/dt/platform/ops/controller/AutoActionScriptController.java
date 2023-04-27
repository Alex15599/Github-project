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
import com.dt.platform.proxy.ops.AutoActionScriptServiceProxy;
import com.dt.platform.domain.ops.meta.AutoActionScriptVOMeta;
import com.dt.platform.domain.ops.AutoActionScript;
import com.dt.platform.domain.ops.AutoActionScriptVO;
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
import com.dt.platform.domain.ops.meta.AutoActionScriptMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IAutoActionScriptService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 执行脚本 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 12:51:30
 */
@Api(tags = "执行脚本")
@ApiSort(0)
@RestController("OpsAutoActionScriptController")
public class AutoActionScriptController extends SuperController {

    @Autowired
    private IAutoActionScriptService autoActionScriptService;

    /**
     * 添加执行脚本
     */
    @ApiOperation(value = "添加执行脚本")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613733471919013888"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class, example = "613733462595076097"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AutoActionScriptServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionScriptServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AutoActionScriptVO autoActionScriptVO) {
        Result result = autoActionScriptService.insert(autoActionScriptVO, false);
        return result;
    }

    /**
     * 删除执行脚本
     */
    @ApiOperation(value = "删除执行脚本")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613733471919013888")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AutoActionScriptServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionScriptServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  autoActionScriptService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = autoActionScriptService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除执行脚本 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除执行脚本")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionScriptVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoActionScriptServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionScriptServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = autoActionScriptService.hasRefers(ids);
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
            Result result = autoActionScriptService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = autoActionScriptService.deleteByIdsLogical(canDeleteIds);
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
     * 更新执行脚本
     */
    @ApiOperation(value = "更新执行脚本")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613733471919013888"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class, example = "613733462595076097"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AutoActionScriptVOMeta.PAGE_INDEX, AutoActionScriptVOMeta.PAGE_SIZE, AutoActionScriptVOMeta.SEARCH_FIELD, AutoActionScriptVOMeta.FUZZY_FIELD, AutoActionScriptVOMeta.SEARCH_VALUE, AutoActionScriptVOMeta.DIRTY_FIELDS, AutoActionScriptVOMeta.SORT_FIELD, AutoActionScriptVOMeta.SORT_TYPE, AutoActionScriptVOMeta.IDS })
    @SentinelResource(value = AutoActionScriptServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionScriptServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AutoActionScriptVO autoActionScriptVO) {
        Result result = autoActionScriptService.update(autoActionScriptVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存执行脚本
     */
    @ApiOperation(value = "保存执行脚本")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613733471919013888"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class, example = "613733462595076097"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoActionScriptVOMeta.PAGE_INDEX, AutoActionScriptVOMeta.PAGE_SIZE, AutoActionScriptVOMeta.SEARCH_FIELD, AutoActionScriptVOMeta.FUZZY_FIELD, AutoActionScriptVOMeta.SEARCH_VALUE, AutoActionScriptVOMeta.DIRTY_FIELDS, AutoActionScriptVOMeta.SORT_FIELD, AutoActionScriptVOMeta.SORT_TYPE, AutoActionScriptVOMeta.IDS })
    @SentinelResource(value = AutoActionScriptServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionScriptServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AutoActionScriptVO autoActionScriptVO) {
        Result result = autoActionScriptService.save(autoActionScriptVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取执行脚本
     */
    @ApiOperation(value = "获取执行脚本")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AutoActionScriptServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionScriptServiceProxy.GET_BY_ID)
    public Result<AutoActionScript> getById(String id) {
        Result<AutoActionScript> result = new Result<>();
        AutoActionScript autoActionScript = autoActionScriptService.getById(id);
        result.success(true).data(autoActionScript);
        return result;
    }

    /**
     * 批量获取执行脚本 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取执行脚本")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionScriptVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoActionScriptServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionScriptServiceProxy.GET_BY_IDS)
    public Result<List<AutoActionScript>> getByIds(List<String> ids) {
        Result<List<AutoActionScript>> result = new Result<>();
        List<AutoActionScript> list = autoActionScriptService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询执行脚本
     */
    @ApiOperation(value = "查询执行脚本")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613733471919013888"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class, example = "613733462595076097"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoActionScriptVOMeta.PAGE_INDEX, AutoActionScriptVOMeta.PAGE_SIZE })
    @SentinelResource(value = AutoActionScriptServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionScriptServiceProxy.QUERY_LIST)
    public Result<List<AutoActionScript>> queryList(AutoActionScriptVO sample) {
        Result<List<AutoActionScript>> result = new Result<>();
        List<AutoActionScript> list = autoActionScriptService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询执行脚本
     */
    @ApiOperation(value = "分页查询执行脚本")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionScriptVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613733471919013888"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class, example = "613733462595076097"),
		@ApiImplicitParam(name = AutoActionScriptVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AutoActionScriptServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionScriptServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AutoActionScript>> queryPagedList(AutoActionScriptVO sample) {
        Result<PagedList<AutoActionScript>> result = new Result<>();
        PagedList<AutoActionScript> list = autoActionScriptService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
