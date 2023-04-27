package com.dt.platform.eam.controller;

import java.util.*;
import com.dt.platform.domain.eam.*;
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
import com.dt.platform.proxy.eam.CCustRepairApplyServiceProxy;
import com.dt.platform.domain.eam.meta.CCustRepairApplyVOMeta;
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
import com.dt.platform.domain.eam.meta.CCustRepairApplyMeta;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.ICCustRepairApplyService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 报修申请接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-01 13:45:49
 */
@InDoc
@Api(tags = "报修申请")
@RestController("EamCCustRepairApplyController")
public class CCustRepairApplyController extends SuperController {

    @Autowired
    private ICCustRepairApplyService cCustRepairApplyService;

    /**
     * 添加报修申请
     */
    @ApiOperation(value = "添加报修申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.NAME, value = "报修标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PLAN_FINISH_DATE, value = "报修时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.CONTENT, value = "报修内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.REPORT_USER_NAME, value = "发起人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.CONTACT, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PROCESS_USER_ID, value = "处理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.START_DATE, value = "发起时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.FINISH_DATE, value = "完成时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.POS, value = "位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.REPORT_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.RESULT, value = "处理结果", required = false, dataTypeClass = String.class, example = "")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustRepairApplyServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustRepairApplyServiceProxy.INSERT)
    public Result insert(CCustRepairApplyVO cCustRepairApplyVO) {
        Result result = cCustRepairApplyService.insert(cCustRepairApplyVO, false);
        return result;
    }

    /**
     * 删除报修申请
     */
    @ApiOperation(value = "删除报修申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustRepairApplyServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustRepairApplyServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = cCustRepairApplyService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = cCustRepairApplyService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除报修申请 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除报修申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustRepairApplyServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustRepairApplyServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = cCustRepairApplyService.hasRefers(ids);
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
            Result result = cCustRepairApplyService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = cCustRepairApplyService.deleteByIdsLogical(canDeleteIds);
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
     * 更新报修申请
     */
    @ApiOperation(value = "更新报修申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.NAME, value = "报修标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PLAN_FINISH_DATE, value = "报修时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.CONTENT, value = "报修内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.REPORT_USER_NAME, value = "发起人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.CONTACT, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PROCESS_USER_ID, value = "处理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.START_DATE, value = "发起时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.FINISH_DATE, value = "完成时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.POS, value = "位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.REPORT_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.RESULT, value = "处理结果", required = false, dataTypeClass = String.class, example = "")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { CCustRepairApplyVOMeta.PAGE_INDEX, CCustRepairApplyVOMeta.PAGE_SIZE, CCustRepairApplyVOMeta.SEARCH_FIELD, CCustRepairApplyVOMeta.FUZZY_FIELD, CCustRepairApplyVOMeta.SEARCH_VALUE, CCustRepairApplyVOMeta.DIRTY_FIELDS, CCustRepairApplyVOMeta.SORT_FIELD, CCustRepairApplyVOMeta.SORT_TYPE, CCustRepairApplyVOMeta.DATA_ORIGIN, CCustRepairApplyVOMeta.QUERY_LOGIC, CCustRepairApplyVOMeta.REQUEST_ACTION, CCustRepairApplyVOMeta.IDS })
    @SentinelResource(value = CCustRepairApplyServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustRepairApplyServiceProxy.UPDATE)
    public Result update(CCustRepairApplyVO cCustRepairApplyVO) {
        Result result = cCustRepairApplyService.update(cCustRepairApplyVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存报修申请
     */
    @ApiOperation(value = "保存报修申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.NAME, value = "报修标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PLAN_FINISH_DATE, value = "报修时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.CONTENT, value = "报修内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.REPORT_USER_NAME, value = "发起人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.CONTACT, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PROCESS_USER_ID, value = "处理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.START_DATE, value = "发起时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.FINISH_DATE, value = "完成时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.POS, value = "位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.REPORT_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.RESULT, value = "处理结果", required = false, dataTypeClass = String.class, example = "")
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { CCustRepairApplyVOMeta.PAGE_INDEX, CCustRepairApplyVOMeta.PAGE_SIZE, CCustRepairApplyVOMeta.SEARCH_FIELD, CCustRepairApplyVOMeta.FUZZY_FIELD, CCustRepairApplyVOMeta.SEARCH_VALUE, CCustRepairApplyVOMeta.DIRTY_FIELDS, CCustRepairApplyVOMeta.SORT_FIELD, CCustRepairApplyVOMeta.SORT_TYPE, CCustRepairApplyVOMeta.DATA_ORIGIN, CCustRepairApplyVOMeta.QUERY_LOGIC, CCustRepairApplyVOMeta.REQUEST_ACTION, CCustRepairApplyVOMeta.IDS })
    @SentinelResource(value = CCustRepairApplyServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustRepairApplyServiceProxy.SAVE)
    public Result save(CCustRepairApplyVO cCustRepairApplyVO) {
        Result result = cCustRepairApplyService.save(cCustRepairApplyVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取报修申请
     */
    @ApiOperation(value = "获取报修申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustRepairApplyServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustRepairApplyServiceProxy.GET_BY_ID)
    public Result<CCustRepairApply> getById(String id) {
        Result<CCustRepairApply> result = new Result<>();
        CCustRepairApply cCustRepairApply = cCustRepairApplyService.getById(id);
        // join 关联的对象
        cCustRepairApplyService.dao().fill(cCustRepairApply).with("processUser").with(CCustRepairApplyMeta.REPIAR_ITEM_DATA).with("reportUser").with(CCustRepairApplyMeta.ASSET_LIST).execute();
        cCustRepairApplyService.dao().join(cCustRepairApply.getReportUser(), Person.class);
        cCustRepairApplyService.dao().join(cCustRepairApply.getProcessUser(), Person.class);
        List<CCustRepiarItem> list = cCustRepairApply.getRepiarItemData();
        cCustRepairApplyService.dao().fill(list).with("processUser").execute();
        if (list != null && list.size() > 0) {
            List<Employee> user = CollectorUtil.collectList(list, CCustRepiarItem::getProcessUser);
            cCustRepairApplyService.dao().join(user, Person.class);
        }
        result.success(true).data(cCustRepairApply);
        return result;
    }

    /**
     * 取消
     */
    @ApiOperation(value = "取消")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustRepairApplyServiceProxy.CANCEL, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustRepairApplyServiceProxy.CANCEL)
    public Result cancel(String id) {
        return cCustRepairApplyService.cancel(id);
    }

    /**
     * 完成
     */
    @ApiOperation(value = "完成")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustRepairApplyServiceProxy.FINISH, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustRepairApplyServiceProxy.FINISH)
    public Result finish(String id,String ct) {
        return cCustRepairApplyService.finish(id,ct);
    }

    /**
     * 接单
     */
    @ApiOperation(value = "接单")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustRepairApplyServiceProxy.RECEIVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustRepairApplyServiceProxy.RECEIVE)
    public Result receive(String id) {
        return cCustRepairApplyService.receive(id);
    }

    /**
     * 回复
     */
    @ApiOperation(value = "回复")
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustRepairApplyServiceProxy.ANSWER, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustRepairApplyServiceProxy.ANSWER)
    public Result ans(CCustRepiarItem data) {
        return cCustRepairApplyService.answer(data);
    }

    /**
     * 批量获取报修申请 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取报修申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustRepairApplyServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustRepairApplyServiceProxy.GET_BY_IDS)
    public Result<List<CCustRepairApply>> getByIds(List<String> ids) {
        Result<List<CCustRepairApply>> result = new Result<>();
        List<CCustRepairApply> list = cCustRepairApplyService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询报修申请
     */
    @ApiOperation(value = "查询报修申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.NAME, value = "报修标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PLAN_FINISH_DATE, value = "报修时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.CONTENT, value = "报修内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.REPORT_USER_NAME, value = "发起人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.CONTACT, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PROCESS_USER_ID, value = "处理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.START_DATE, value = "发起时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.FINISH_DATE, value = "完成时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.POS, value = "位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.REPORT_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.RESULT, value = "处理结果", required = false, dataTypeClass = String.class, example = "")
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { CCustRepairApplyVOMeta.PAGE_INDEX, CCustRepairApplyVOMeta.PAGE_SIZE })
    @SentinelResource(value = CCustRepairApplyServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustRepairApplyServiceProxy.QUERY_LIST)
    public Result<List<CCustRepairApply>> queryList(CCustRepairApplyVO sample) {
        Result<List<CCustRepairApply>> result = new Result<>();
        List<CCustRepairApply> list = cCustRepairApplyService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询报修申请
     */
    @ApiOperation(value = "分页查询报修申请")
    @ApiImplicitParams({
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.BUSINESS_CODE, value = "业务编号", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.NAME, value = "报修标题", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PLAN_FINISH_DATE, value = "报修时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.CONTENT, value = "报修内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.REPORT_USER_NAME, value = "发起人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.CONTACT, value = "联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PICTURE_ID, value = "图片", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.PROCESS_USER_ID, value = "处理人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.START_DATE, value = "发起时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.FINISH_DATE, value = "完成时间", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.POS, value = "位置", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.REPORT_USER_ID, value = "使用人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = CCustRepairApplyVOMeta.RESULT, value = "处理结果", required = false, dataTypeClass = String.class, example = "")
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = CCustRepairApplyServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(CCustRepairApplyServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<CCustRepairApply>> queryPagedList(CCustRepairApplyVO sample) {
        Result<PagedList<CCustRepairApply>> result = new Result<>();
        PagedList<CCustRepairApply> list = cCustRepairApplyService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        cCustRepairApplyService.dao().fill(list).with("processUser").with("reportUser").with(CCustRepairApplyMeta.ASSET_LIST).with(CCustRepairApplyMeta.REPIAR_ITEM_DATA).execute();
        List<Employee> user1 = CollectorUtil.collectList(list, CCustRepairApply::getProcessUser);
        cCustRepairApplyService.dao().join(user1, Person.class);
        List<Employee> user2 = CollectorUtil.collectList(list, CCustRepairApply::getReportUser);
        cCustRepairApplyService.dao().join(user2, Person.class);
        result.success(true).data(list);
        return result;
    }
}
