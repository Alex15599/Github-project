package com.dt.platform.eam.controller;

import java.util.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.CCustInspectItemMeta;
import com.dt.platform.domain.eam.meta.CCustInspectTaskMeta;
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
import com.dt.platform.proxy.eam.CCustInspectPlanServiceProxy;
import com.dt.platform.domain.eam.meta.CCustInspectPlanVOMeta;
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
import com.dt.platform.domain.eam.meta.CCustInspectPlanMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICCustInspectPlanService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 巡检计划接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-07 10:57:13
 */
@InDoc
@Api(tags = "巡检计划")
@RestController("EamCCustInspectPlanController")
public class CCustInspectPlanController extends SuperController {

    @Autowired
    private ICCustInspectPlanService cCustInspectPlanService;

    /**
     * 添加巡检计划
     */
    @ApiOperation(value = "添加巡检计划")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "696673753869844480"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NAME, value = "标题", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "valid"),
		 @ApiImplicitParam(name = CCustInspectPlanVOMeta.INSPECT_USER_ID, value = "负责人", required = false, dataTypeClass = String.class, example = "586965217661943808"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class, example = "696311000567119872"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.CRONTAB, value = "触发周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.LAST_TIME, value = "上次执行时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NEXT_TIME, value = "下次执行时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.ACTION_ADD, value = "追加", required = false, dataTypeClass = String.class, example = "tpl")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectPlanServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectPlanServiceProxy.INSERT)
    public Result insert(CCustInspectPlanVO cCustInspectPlanVO) {
        Result result = cCustInspectPlanService.insert(cCustInspectPlanVO, false);
        return result;
    }

    /**
     * 删除巡检计划
     */
    @ApiOperation(value = "删除巡检计划")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "696673753869844480")
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectPlanServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectPlanServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = cCustInspectPlanService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = cCustInspectPlanService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除巡检计划 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除巡检计划")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectPlanServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectPlanServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = cCustInspectPlanService.hasRefers(ids);
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
            Result result = cCustInspectPlanService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = cCustInspectPlanService.deleteByIdsLogical(canDeleteIds);
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
     * 更新巡检计划
     */
    @ApiOperation(value = "更新巡检计划")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "696673753869844480"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NAME, value = "标题", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "valid"),
	 	@ApiImplicitParam(name = CCustInspectPlanVOMeta.INSPECT_USER_ID, value = "负责人", required = false, dataTypeClass = String.class, example = "586965217661943808"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class, example = "696311000567119872"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.CRONTAB, value = "触发周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.LAST_TIME, value = "上次执行时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NEXT_TIME, value = "下次执行时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.ACTION_ADD, value = "追加", required = false, dataTypeClass = String.class, example = "tpl")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CCustInspectPlanVOMeta.PAGE_INDEX, CCustInspectPlanVOMeta.PAGE_SIZE, CCustInspectPlanVOMeta.SEARCH_FIELD, CCustInspectPlanVOMeta.FUZZY_FIELD, CCustInspectPlanVOMeta.SEARCH_VALUE, CCustInspectPlanVOMeta.DIRTY_FIELDS, CCustInspectPlanVOMeta.SORT_FIELD, CCustInspectPlanVOMeta.SORT_TYPE, CCustInspectPlanVOMeta.DATA_ORIGIN, CCustInspectPlanVOMeta.QUERY_LOGIC, CCustInspectPlanVOMeta.REQUEST_ACTION, CCustInspectPlanVOMeta.IDS })
    @SentinelResource(value = CCustInspectPlanServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectPlanServiceProxy.UPDATE)
    public Result update(CCustInspectPlanVO cCustInspectPlanVO) {
        Result result = cCustInspectPlanService.update(cCustInspectPlanVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存巡检计划
     */
    @ApiOperation(value = "保存巡检计划")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "696673753869844480"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NAME, value = "标题", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "valid"),
	    @ApiImplicitParam(name = CCustInspectPlanVOMeta.INSPECT_USER_ID, value = "负责人", required = false, dataTypeClass = String.class, example = "586965217661943808"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class, example = "696311000567119872"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.CRONTAB, value = "触发周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.LAST_TIME, value = "上次执行时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NEXT_TIME, value = "下次执行时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.ACTION_ADD, value = "追加", required = false, dataTypeClass = String.class, example = "tpl")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CCustInspectPlanVOMeta.PAGE_INDEX, CCustInspectPlanVOMeta.PAGE_SIZE, CCustInspectPlanVOMeta.SEARCH_FIELD, CCustInspectPlanVOMeta.FUZZY_FIELD, CCustInspectPlanVOMeta.SEARCH_VALUE, CCustInspectPlanVOMeta.DIRTY_FIELDS, CCustInspectPlanVOMeta.SORT_FIELD, CCustInspectPlanVOMeta.SORT_TYPE, CCustInspectPlanVOMeta.DATA_ORIGIN, CCustInspectPlanVOMeta.QUERY_LOGIC, CCustInspectPlanVOMeta.REQUEST_ACTION, CCustInspectPlanVOMeta.IDS })
    @SentinelResource(value = CCustInspectPlanServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectPlanServiceProxy.SAVE)
    public Result save(CCustInspectPlanVO cCustInspectPlanVO) {
        Result result = cCustInspectPlanService.save(cCustInspectPlanVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }


    /**
     * 执行
     */
    @ApiOperation(value = "执行")
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectPlanServiceProxy.EXECUTE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectPlanServiceProxy.EXECUTE)
    public Result execute() {
        return cCustInspectPlanService.execute();
    }

    /**
     * 执行
     */
    @ApiOperation(value = "执行")
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectPlanServiceProxy.CREATE_TASK, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectPlanServiceProxy.CREATE_TASK)
    public Result createTask(String id,String type) {
        return cCustInspectPlanService.createTask(id,type);
    }


    /**
     * 获取巡检计划
     */
    @ApiOperation(value = "获取巡检计划")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectPlanServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectPlanServiceProxy.GET_BY_ID)
    public Result<CCustInspectPlan> getById(String id) {
        Result<CCustInspectPlan> result = new Result<>();
        CCustInspectPlan cCustInspectPlan = cCustInspectPlanService.getById(id);
        // join 关联的对象
        cCustInspectPlanService.dao().fill(cCustInspectPlan).with("leader").with(CCustInspectPlanMeta.CUST_INSPECT_ITEM_LIST).with(CCustInspectPlanMeta.MEMBER_LIST).with(CCustInspectPlanMeta.CUST_INSPECT_TPL).execute();
        cCustInspectPlanService.dao().join(cCustInspectPlan.getLeader(), Person.class);
        List<Employee> user1 = cCustInspectPlan.getMemberList();
        if (user1 != null && user1.size() > 0) {
            cCustInspectPlanService.dao().join(user1, Person.class);
        }
        result.success(true).data(cCustInspectPlan);
        return result;
    }

    /**
     * 批量获取巡检计划 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取巡检计划")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectPlanServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectPlanServiceProxy.GET_BY_IDS)
    public Result<List<CCustInspectPlan>> getByIds(List<String> ids) {
        Result<List<CCustInspectPlan>> result = new Result<>();
        List<CCustInspectPlan> list = cCustInspectPlanService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询巡检计划
     */
    @ApiOperation(value = "查询巡检计划")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "696673753869844480"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NAME, value = "标题", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "valid"),
		 @ApiImplicitParam(name = CCustInspectPlanVOMeta.INSPECT_USER_ID, value = "负责人", required = false, dataTypeClass = String.class, example = "586965217661943808"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class, example = "696311000567119872"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.CRONTAB, value = "触发周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.LAST_TIME, value = "上次执行时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NEXT_TIME, value = "下次执行时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.ACTION_ADD, value = "追加", required = false, dataTypeClass = String.class, example = "tpl")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CCustInspectPlanVOMeta.PAGE_INDEX, CCustInspectPlanVOMeta.PAGE_SIZE })
    @SentinelResource(value = CCustInspectPlanServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectPlanServiceProxy.QUERY_LIST)
    public Result<List<CCustInspectPlan>> queryList(CCustInspectPlanVO sample) {
        Result<List<CCustInspectPlan>> result = new Result<>();
        List<CCustInspectPlan> list = cCustInspectPlanService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询巡检计划
     */
    @ApiOperation(value = "分页查询巡检计划")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "696673753869844480"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NAME, value = "标题", required = false, dataTypeClass = String.class, example = "12"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "valid"),
		 @ApiImplicitParam(name = CCustInspectPlanVOMeta.INSPECT_USER_ID, value = "负责人", required = false, dataTypeClass = String.class, example = "586965217661943808"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.TPL_ID, value = "模版", required = false, dataTypeClass = String.class, example = "696311000567119872"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.CRONTAB, value = "触发周期", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.LAST_TIME, value = "上次执行时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.NEXT_TIME, value = "下次执行时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustInspectPlanVOMeta.ACTION_ADD, value = "追加", required = false, dataTypeClass = String.class, example = "tpl")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustInspectPlanServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustInspectPlanServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CCustInspectPlan>> queryPagedList(CCustInspectPlanVO sample) {
        Result<PagedList<CCustInspectPlan>> result = new Result<>();
        PagedList<CCustInspectPlan> list = cCustInspectPlanService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        cCustInspectPlanService.dao().fill(list).with("leader").with(CCustInspectPlanMeta.CUST_INSPECT_ITEM_LIST).with(CCustInspectPlanMeta.MEMBER_LIST).with(CCustInspectPlanMeta.CUST_INSPECT_TPL).execute();
        List<Employee> user1 = CollectorUtil.collectList(list, CCustInspectPlan::getLeader);
        cCustInspectPlanService.dao().join(user1, Person.class);
        List<List<Employee>> userList = CollectorUtil.collectList(list.getList(), CCustInspectPlan::getMemberList);
        List<Employee> users = userList.stream().collect(ArrayList::new, ArrayList::addAll, ArrayList::addAll);
        cCustInspectPlanService.dao().join(users, Person.class);
        result.success(true).data(list);
        return result;
    }
}
