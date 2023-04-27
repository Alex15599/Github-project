package com.dt.platform.eam.controller;

import java.util.*;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.CCustInspectItemMeta;
import com.dt.platform.domain.eam.meta.CCustInspectPlanMeta;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.framework.web.SuperController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.api.swagger.InDoc;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import com.github.foxnic.api.swagger.ApiParamSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.proxy.eam.CCustInspectTaskServiceProxy;
import com.dt.platform.domain.eam.meta.CCustInspectTaskVOMeta;
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
import com.dt.platform.domain.eam.meta.CCustInspectTaskMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICCustInspectTaskService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检任务单接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-06 10:32:46
 */
@InDoc
@Api(tags = "巡检任务单")
@RestController("EamCCustInspectTaskController")
public class CCustInspectTaskController extends SuperController {

    @Autowired
    private ICCustInspectTaskService cCustInspectTaskService;

    /**
     * 添加巡检任务单
     */
    @ApiOperation(value = "添加巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.NAME, value = "标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.START_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.FINISH_TIME, value = "完成时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.INSPECT_USER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ACTION_ADD, value = "追加", required = false, dataTypeClass = String.class, example = "tpl"),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.CODE, value = "编号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectTaskServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.INSERT)
    public Result insert(CCustInspectTaskVO cCustInspectTaskVO) {
        Result result = cCustInspectTaskService.insert(cCustInspectTaskVO, false);
        return result;
    }

    /**
     * 删除巡检任务单
     */
    @ApiOperation(value = "删除巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectTaskServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = cCustInspectTaskService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = cCustInspectTaskService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除巡检任务单 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectTaskServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = cCustInspectTaskService.hasRefers(ids);
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
            return ErrorDesc.failure().message("无法删除您选中的数据行：").data(0).addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(), (e) -> {
                return e.hasRefer();
            }), ReferCause::message, String.class)).messageLevel4Confirm();
        } else if (canDeleteIds.size() == ids.size()) {
            // 如果全部可以删除
            Result result = cCustInspectTaskService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = cCustInspectTaskService.deleteByIdsLogical(canDeleteIds);
            if (result.failure()) {
                return result;
            } else {
                return ErrorDesc.success().message("已删除 " + canDeleteIds.size() + " 行，但另有 " + (ids.size() - canDeleteIds.size()) + " 行数据无法删除").data(canDeleteIds.size()).addErrors(CollectorUtil.collectArray(CollectorUtil.filter(causeMap.values(), (e) -> {
                    return e.hasRefer();
                }), ReferCause::message, String.class)).messageLevel4Confirm();
            }
        } else {
            // 理论上，这个分支不存在
            return ErrorDesc.success().message("数据删除未处理");
        }
    }

    /**
     * 更新巡检任务单
     */
    @ApiOperation(value = "更新巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.NAME, value = "标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.START_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.FINISH_TIME, value = "完成时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.INSPECT_USER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ACTION_ADD, value = "追加", required = false, dataTypeClass = String.class, example = "tpl"),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.CODE, value = "编号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CCustInspectTaskVOMeta.PAGE_INDEX, CCustInspectTaskVOMeta.PAGE_SIZE, CCustInspectTaskVOMeta.SEARCH_FIELD, CCustInspectTaskVOMeta.FUZZY_FIELD, CCustInspectTaskVOMeta.SEARCH_VALUE, CCustInspectTaskVOMeta.DIRTY_FIELDS, CCustInspectTaskVOMeta.SORT_FIELD, CCustInspectTaskVOMeta.SORT_TYPE, CCustInspectTaskVOMeta.DATA_ORIGIN, CCustInspectTaskVOMeta.QUERY_LOGIC, CCustInspectTaskVOMeta.REQUEST_ACTION, CCustInspectTaskVOMeta.IDS })
    @SentinelResource(value = CCustInspectTaskServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.UPDATE)
    public Result update(CCustInspectTaskVO cCustInspectTaskVO) {
        Result result = cCustInspectTaskService.update(cCustInspectTaskVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存巡检任务单
     */
    @ApiOperation(value = "保存巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.NAME, value = "标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.START_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.FINISH_TIME, value = "完成时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.INSPECT_USER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ACTION_ADD, value = "追加", required = false, dataTypeClass = String.class, example = "tpl"),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.CODE, value = "编号", required = false, dataTypeClass = String.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CCustInspectTaskVOMeta.PAGE_INDEX, CCustInspectTaskVOMeta.PAGE_SIZE, CCustInspectTaskVOMeta.SEARCH_FIELD, CCustInspectTaskVOMeta.FUZZY_FIELD, CCustInspectTaskVOMeta.SEARCH_VALUE, CCustInspectTaskVOMeta.DIRTY_FIELDS, CCustInspectTaskVOMeta.SORT_FIELD, CCustInspectTaskVOMeta.SORT_TYPE, CCustInspectTaskVOMeta.DATA_ORIGIN, CCustInspectTaskVOMeta.QUERY_LOGIC, CCustInspectTaskVOMeta.REQUEST_ACTION, CCustInspectTaskVOMeta.IDS })
    @SentinelResource(value = CCustInspectTaskServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.SAVE)
    public Result save(CCustInspectTaskVO cCustInspectTaskVO) {
        Result result = cCustInspectTaskService.save(cCustInspectTaskVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 取消任务单
     */
    @ApiOperation(value = "取消任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectTaskServiceProxy.CANCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.CANCEL)
    public Result cancel(String id) {
        return cCustInspectTaskService.cancel(id);
    }

    /**
     * 完成任务单
     */
    @ApiOperation(value = "完成任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectTaskServiceProxy.FINISH, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.FINISH)
    public Result finish(String id) {
        return cCustInspectTaskService.finish(id);
    }

    /**
     * 完成任务单
     */
    @ApiOperation(value = "开始巡检")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectTaskServiceProxy.START, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.START)
    public Result start(String id) {
        return cCustInspectTaskService.start(id);
    }

    /**
     * 完成任务单
     */
    @ApiOperation(value = "开始巡检")
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectTaskServiceProxy.INSPECT_SCAN, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.INSPECT_SCAN)
    public Result<JSONObject> inspectScan(String taskId, String assetCode) {
        return cCustInspectTaskService.inspectScan(taskId, assetCode);
    }

    /**
     * 巡检务单
     */
    @ApiOperation(value = "巡检务单")
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectTaskServiceProxy.INSPECT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.INSPECT)
    public Result inspect(String taskId, String assetId, String status, String ct, String picIds) {
        return cCustInspectTaskService.inspect(taskId, assetId, status, ct, picIds);
    }

    /**
     * 获取巡检任务单
     */
    @ApiOperation(value = "获取巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectTaskServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.GET_BY_ID)
    public Result<CCustInspectTask> getById(String id) {
        Result<CCustInspectTask> result = new Result<>();
        CCustInspectTask cCustInspectTask = cCustInspectTaskService.getById(id);
        // join 关联的对象
        cCustInspectTaskService.dao().fill(cCustInspectTask).with("leader").with(CCustInspectTaskMeta.CUST_INSPECT_TPL).with(CCustInspectTaskMeta.CUST_INSPECT_ITEM_LIST).with(CCustInspectTaskMeta.MEMBER_LIST).execute();
        cCustInspectTaskService.dao().join(cCustInspectTask.getLeader(), Person.class);
        List<Employee> user1 = cCustInspectTask.getMemberList();
        if (user1 != null && user1.size() > 0) {
            cCustInspectTaskService.dao().join(user1, Person.class);
        }
        List<CCustInspectItem> itemList = cCustInspectTask.getCustInspectItemList();
        if (itemList != null && itemList.size() > 0) {
            cCustInspectTaskService.dao().join(itemList, CCustInspectItemMeta.ASSET);
        }
        result.success(true).data(cCustInspectTask);
        return result;
    }

    /**
     * 批量获取巡检任务单 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectTaskServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.GET_BY_IDS)
    public Result<List<CCustInspectTask>> getByIds(List<String> ids) {
        Result<List<CCustInspectTask>> result = new Result<>();
        List<CCustInspectTask> list = cCustInspectTaskService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询巡检任务单
     */
    @ApiOperation(value = "查询巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.NAME, value = "标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.START_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.FINISH_TIME, value = "完成时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.INSPECT_USER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ACTION_ADD, value = "追加", required = false, dataTypeClass = String.class, example = "tpl"),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.CODE, value = "编号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CCustInspectTaskVOMeta.PAGE_INDEX, CCustInspectTaskVOMeta.PAGE_SIZE })
    @SentinelResource(value = CCustInspectTaskServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.QUERY_LIST)
    public Result<List<CCustInspectTask>> queryList(CCustInspectTaskVO sample) {
        Result<List<CCustInspectTask>> result = new Result<>();
        List<CCustInspectTask> list = cCustInspectTaskService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询巡检任务单
     */
    @ApiOperation(value = "分页查询巡检任务单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.NAME, value = "标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.START_TIME, value = "开始时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.FINISH_TIME, value = "完成时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.INSPECT_USER_ID, value = "负责人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.ACTION_ADD, value = "追加", required = false, dataTypeClass = String.class, example = "tpl"),
		@ApiImplicitParam(name = CCustInspectTaskVOMeta.CODE, value = "编号", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectTaskServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectTaskServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CCustInspectTask>> queryPagedList(CCustInspectTaskVO sample) {
        Result<PagedList<CCustInspectTask>> result = new Result<>();
        PagedList<CCustInspectTask> list = cCustInspectTaskService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        cCustInspectTaskService.dao().fill(list).with("leader").with(CCustInspectTaskMeta.CUST_INSPECT_ITEM_LIST).with(CCustInspectTaskMeta.MEMBER_LIST).with(CCustInspectTaskMeta.CUST_INSPECT_TPL).execute();
        List<Employee> user1 = CollectorUtil.collectList(list, CCustInspectTask::getLeader);
        cCustInspectTaskService.dao().join(user1, Person.class);
        List<List<Employee>> userList = CollectorUtil.collectList(list.getList(), CCustInspectTask::getMemberList);
        List<Employee> users = userList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        cCustInspectTaskService.dao().join(users, Person.class);
        result.success(true).data(list);
        return result;
    }
}
