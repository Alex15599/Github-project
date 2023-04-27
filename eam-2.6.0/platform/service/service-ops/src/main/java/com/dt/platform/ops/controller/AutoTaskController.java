package com.dt.platform.ops.controller;

import java.util.List;
import java.util.ArrayList;
import com.github.foxnic.commons.concurrent.task.SimpleTaskManager;
import net.bytebuddy.asm.MemberSubstitution;
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
import com.dt.platform.proxy.ops.AutoTaskServiceProxy;
import com.dt.platform.domain.ops.meta.AutoTaskVOMeta;
import com.dt.platform.domain.ops.AutoTask;
import com.dt.platform.domain.ops.AutoTaskVO;
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
import com.dt.platform.domain.ops.meta.AutoTaskMeta;
import com.dt.platform.domain.ops.AutoGroup;
import com.dt.platform.domain.ops.AutoAction;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IAutoTaskService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 批次作业 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-21 16:09:08
 */
@Api(tags = "批次作业")
@ApiSort(0)
@RestController("OpsAutoTaskController")
public class AutoTaskController extends SuperController {

    @Autowired
    private IAutoTaskService autoTaskService;

    /**
     * 添加批次作业
     */
    @ApiOperation(value = "添加批次作业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613764113549492224"),
		@ApiImplicitParam(name = AutoTaskVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoTaskVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class, example = "613661086134042624"),
		@ApiImplicitParam(name = AutoTaskVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class, example = "613756265390145536"),
		@ApiImplicitParam(name = AutoTaskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AutoTaskServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AutoTaskVO autoTaskVO) {
        Result result = autoTaskService.insert(autoTaskVO, false);
        return result;
    }

    /**
     * 删除批次作业
     */
    @ApiOperation(value = "删除批次作业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613764113549492224")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AutoTaskServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  autoTaskService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = autoTaskService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除批次作业 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除批次作业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoTaskServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = autoTaskService.hasRefers(ids);
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
            Result result = autoTaskService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = autoTaskService.deleteByIdsLogical(canDeleteIds);
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
     * 更新批次作业
     */
    @ApiOperation(value = "更新批次作业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613764113549492224"),
		@ApiImplicitParam(name = AutoTaskVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoTaskVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class, example = "613661086134042624"),
		@ApiImplicitParam(name = AutoTaskVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class, example = "613756265390145536"),
		@ApiImplicitParam(name = AutoTaskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AutoTaskVOMeta.PAGE_INDEX, AutoTaskVOMeta.PAGE_SIZE, AutoTaskVOMeta.SEARCH_FIELD, AutoTaskVOMeta.FUZZY_FIELD, AutoTaskVOMeta.SEARCH_VALUE, AutoTaskVOMeta.DIRTY_FIELDS, AutoTaskVOMeta.SORT_FIELD, AutoTaskVOMeta.SORT_TYPE, AutoTaskVOMeta.IDS })
    @SentinelResource(value = AutoTaskServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AutoTaskVO autoTaskVO) {
        Result result = autoTaskService.update(autoTaskVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存批次作业
     */
    @ApiOperation(value = "保存批次作业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613764113549492224"),
		@ApiImplicitParam(name = AutoTaskVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoTaskVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class, example = "613661086134042624"),
		@ApiImplicitParam(name = AutoTaskVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class, example = "613756265390145536"),
		@ApiImplicitParam(name = AutoTaskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoTaskVOMeta.PAGE_INDEX, AutoTaskVOMeta.PAGE_SIZE, AutoTaskVOMeta.SEARCH_FIELD, AutoTaskVOMeta.FUZZY_FIELD, AutoTaskVOMeta.SEARCH_VALUE, AutoTaskVOMeta.DIRTY_FIELDS, AutoTaskVOMeta.SORT_FIELD, AutoTaskVOMeta.SORT_TYPE, AutoTaskVOMeta.IDS })
    @SentinelResource(value = AutoTaskServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AutoTaskVO autoTaskVO) {
        Result result = autoTaskService.save(autoTaskVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取批次作业
     */
    @ApiOperation(value = "获取批次作业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AutoTaskServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskServiceProxy.GET_BY_ID)
    public Result<AutoTask> getById(String id) {
        Result<AutoTask> result = new Result<>();
        AutoTask autoTask = autoTaskService.getById(id);
        // join 关联的对象
        autoTaskService.dao().fill(autoTask).with(AutoTaskMeta.ACTION).with(AutoTaskMeta.BATCH).with(AutoTaskMeta.GROUP).execute();
        result.success(true).data(autoTask);
        return result;
    }

    /**
     * 批量获取批次作业 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取批次作业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoTaskServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskServiceProxy.GET_BY_IDS)
    public Result<List<AutoTask>> getByIds(List<String> ids) {
        Result<List<AutoTask>> result = new Result<>();
        List<AutoTask> list = autoTaskService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询批次作业
     */
    @ApiOperation(value = "查询批次作业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613764113549492224"),
		@ApiImplicitParam(name = AutoTaskVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoTaskVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class, example = "613661086134042624"),
		@ApiImplicitParam(name = AutoTaskVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class, example = "613756265390145536"),
		@ApiImplicitParam(name = AutoTaskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoTaskVOMeta.PAGE_INDEX, AutoTaskVOMeta.PAGE_SIZE })
    @SentinelResource(value = AutoTaskServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskServiceProxy.QUERY_LIST)
    public Result<List<AutoTask>> queryList(AutoTaskVO sample) {
        Result<List<AutoTask>> result = new Result<>();
        List<AutoTask> list = autoTaskService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询批次作业
     */
    @ApiOperation(value = "分页查询批次作业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613764113549492224"),
		@ApiImplicitParam(name = AutoTaskVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoTaskVOMeta.GROUP_ID, value = "分组", required = false, dataTypeClass = String.class, example = "613661086134042624"),
		@ApiImplicitParam(name = AutoTaskVOMeta.ACTION_ID, value = "动作", required = false, dataTypeClass = String.class, example = "613756265390145536"),
		@ApiImplicitParam(name = AutoTaskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212")
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AutoTaskServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AutoTask>> queryPagedList(AutoTaskVO sample) {
        Result<PagedList<AutoTask>> result = new Result<>();
        PagedList<AutoTask> list = autoTaskService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        autoTaskService.dao().fill(list).with(AutoTaskMeta.ACTION).with(AutoTaskMeta.BATCH).with(AutoTaskMeta.GROUP).execute();
        result.success(true).data(list);
        return result;
    }

    /**
     * 执行作业
     */
    @ApiOperation(value = "执行作业")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "613764113549492224")
	})
    @ApiOperationSupport(order = 9)
    @SentinelResource(value = AutoTaskServiceProxy.EXECUTE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskServiceProxy.EXECUTE)
    public Result execute(String id, String method) {
        SimpleTaskManager tm = new SimpleTaskManager();
        // tm.doDelayTask(new Runnable() {
        // @Override
        // public void run() {
        // Result result=autoTaskService.execute(id,method);
        // }
        // }, 10);
        Result result = autoTaskService.execute(id, method);
        Result r = new Result();
        r.success();
        r.message("已提交至后台执行,请在日志中查看执行结果");
        return r;
    }
}
