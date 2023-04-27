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
import com.dt.platform.proxy.ops.AutoActionServiceProxy;
import com.dt.platform.domain.ops.meta.AutoActionVOMeta;
import com.dt.platform.domain.ops.AutoAction;
import com.dt.platform.domain.ops.AutoActionVO;
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
import com.dt.platform.domain.ops.meta.AutoActionMeta;
import com.dt.platform.domain.ops.AutoActionScript;
import com.dt.platform.domain.ops.AutoActionFile;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IAutoActionService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 执行任务 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-23 19:33:17
 */
@Api(tags = "执行任务")
@ApiSort(0)
@RestController("OpsAutoActionController")
public class AutoActionController extends SuperController {

    @Autowired
    private IAutoActionService autoActionService;

    /**
     * 添加执行任务
     */
    @ApiOperation(value = "添加执行任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613756265390145536"),
		@ApiImplicitParam(name = AutoActionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "测试1"),
		@ApiImplicitParam(name = AutoActionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoActionVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = AutoActionVOMeta.TPL_VERSION, value = "模版版本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.SUPPORT, value = "场景", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.INFO, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.FILE_STATUS, value = "介质状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.NODE_NUMBER_TYPE, value = "节点数量", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.CONF_CONTENT, value = "配置内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoActionVOMeta.EXAMPLE_CONF_CONTENT, value = "配置例子", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.EXECUTE_CONTENT, value = "执行内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoActionVOMeta.EXECUTE_TOOL, value = "执行工具", required = false, dataTypeClass = String.class, example = "ops_tool"),
		@ApiImplicitParam(name = AutoActionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AutoActionServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AutoActionVO autoActionVO) {
        Result result = autoActionService.insert(autoActionVO, false);
        return result;
    }

    /**
     * 删除执行任务
     */
    @ApiOperation(value = "删除执行任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613756265390145536")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AutoActionServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  autoActionService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = autoActionService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除执行任务 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除执行任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoActionServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = autoActionService.hasRefers(ids);
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
            Result result = autoActionService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = autoActionService.deleteByIdsLogical(canDeleteIds);
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
     * 更新执行任务
     */
    @ApiOperation(value = "更新执行任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613756265390145536"),
		@ApiImplicitParam(name = AutoActionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "测试1"),
		@ApiImplicitParam(name = AutoActionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoActionVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = AutoActionVOMeta.TPL_VERSION, value = "模版版本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.SUPPORT, value = "场景", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.INFO, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.FILE_STATUS, value = "介质状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.NODE_NUMBER_TYPE, value = "节点数量", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.CONF_CONTENT, value = "配置内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoActionVOMeta.EXAMPLE_CONF_CONTENT, value = "配置例子", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.EXECUTE_CONTENT, value = "执行内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoActionVOMeta.EXECUTE_TOOL, value = "执行工具", required = false, dataTypeClass = String.class, example = "ops_tool"),
		@ApiImplicitParam(name = AutoActionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AutoActionVOMeta.PAGE_INDEX, AutoActionVOMeta.PAGE_SIZE, AutoActionVOMeta.SEARCH_FIELD, AutoActionVOMeta.FUZZY_FIELD, AutoActionVOMeta.SEARCH_VALUE, AutoActionVOMeta.DIRTY_FIELDS, AutoActionVOMeta.SORT_FIELD, AutoActionVOMeta.SORT_TYPE, AutoActionVOMeta.IDS })
    @SentinelResource(value = AutoActionServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AutoActionVO autoActionVO) {
        Result result = autoActionService.update(autoActionVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存执行任务
     */
    @ApiOperation(value = "保存执行任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613756265390145536"),
		@ApiImplicitParam(name = AutoActionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "测试1"),
		@ApiImplicitParam(name = AutoActionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoActionVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = AutoActionVOMeta.TPL_VERSION, value = "模版版本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.SUPPORT, value = "场景", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.INFO, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.FILE_STATUS, value = "介质状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.NODE_NUMBER_TYPE, value = "节点数量", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.CONF_CONTENT, value = "配置内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoActionVOMeta.EXAMPLE_CONF_CONTENT, value = "配置例子", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.EXECUTE_CONTENT, value = "执行内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoActionVOMeta.EXECUTE_TOOL, value = "执行工具", required = false, dataTypeClass = String.class, example = "ops_tool"),
		@ApiImplicitParam(name = AutoActionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoActionVOMeta.PAGE_INDEX, AutoActionVOMeta.PAGE_SIZE, AutoActionVOMeta.SEARCH_FIELD, AutoActionVOMeta.FUZZY_FIELD, AutoActionVOMeta.SEARCH_VALUE, AutoActionVOMeta.DIRTY_FIELDS, AutoActionVOMeta.SORT_FIELD, AutoActionVOMeta.SORT_TYPE, AutoActionVOMeta.IDS })
    @SentinelResource(value = AutoActionServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AutoActionVO autoActionVO) {
        Result result = autoActionService.save(autoActionVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取执行任务
     */
    @ApiOperation(value = "获取执行任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AutoActionServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionServiceProxy.GET_BY_ID)
    public Result<AutoAction> getById(String id) {
        Result<AutoAction> result = new Result<>();
        AutoAction autoAction = autoActionService.getById(id);
        // join 关联的对象
        autoActionService.dao().fill(autoAction).with(AutoActionMeta.AUTO_ACTION_SCRIPT_LIST).with(AutoActionMeta.AUTO_ACTION_FILE_LIST).execute();
        result.success(true).data(autoAction);
        return result;
    }

    /**
     * 批量获取执行任务 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取执行任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoActionServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionServiceProxy.GET_BY_IDS)
    public Result<List<AutoAction>> getByIds(List<String> ids) {
        Result<List<AutoAction>> result = new Result<>();
        List<AutoAction> list = autoActionService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询执行任务
     */
    @ApiOperation(value = "查询执行任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613756265390145536"),
		@ApiImplicitParam(name = AutoActionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "测试1"),
		@ApiImplicitParam(name = AutoActionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoActionVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = AutoActionVOMeta.TPL_VERSION, value = "模版版本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.SUPPORT, value = "场景", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.INFO, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.FILE_STATUS, value = "介质状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.NODE_NUMBER_TYPE, value = "节点数量", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.CONF_CONTENT, value = "配置内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoActionVOMeta.EXAMPLE_CONF_CONTENT, value = "配置例子", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.EXECUTE_CONTENT, value = "执行内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoActionVOMeta.EXECUTE_TOOL, value = "执行工具", required = false, dataTypeClass = String.class, example = "ops_tool"),
		@ApiImplicitParam(name = AutoActionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoActionVOMeta.PAGE_INDEX, AutoActionVOMeta.PAGE_SIZE })
    @SentinelResource(value = AutoActionServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionServiceProxy.QUERY_LIST)
    public Result<List<AutoAction>> queryList(AutoActionVO sample) {
        Result<List<AutoAction>> result = new Result<>();
        List<AutoAction> list = autoActionService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询执行任务
     */
    @ApiOperation(value = "分页查询执行任务")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613756265390145536"),
		@ApiImplicitParam(name = AutoActionVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "测试1"),
		@ApiImplicitParam(name = AutoActionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoActionVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "host"),
		@ApiImplicitParam(name = AutoActionVOMeta.TPL_VERSION, value = "模版版本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.SUPPORT, value = "场景", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.INFO, value = "说明", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.FILE_STATUS, value = "介质状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.NODE_NUMBER_TYPE, value = "节点数量", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.CONF_CONTENT, value = "配置内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoActionVOMeta.EXAMPLE_CONF_CONTENT, value = "配置例子", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionVOMeta.EXECUTE_CONTENT, value = "执行内容", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = AutoActionVOMeta.EXECUTE_TOOL, value = "执行工具", required = false, dataTypeClass = String.class, example = "ops_tool"),
		@ApiImplicitParam(name = AutoActionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "12")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AutoActionServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AutoAction>> queryPagedList(AutoActionVO sample) {
        Result<PagedList<AutoAction>> result = new Result<>();
        PagedList<AutoAction> list = autoActionService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        autoActionService.dao().fill(list).with(AutoActionMeta.AUTO_ACTION_SCRIPT_LIST).with(AutoActionMeta.AUTO_ACTION_FILE_LIST).execute();
        result.success(true).data(list);
        return result;
    }
}
