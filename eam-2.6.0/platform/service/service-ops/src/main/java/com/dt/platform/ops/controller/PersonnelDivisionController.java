package com.dt.platform.ops.controller;

import java.util.*;
import com.dt.platform.domain.eam.AssetEmployeeRepair;
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
import com.dt.platform.proxy.ops.PersonnelDivisionServiceProxy;
import com.dt.platform.domain.ops.meta.PersonnelDivisionVOMeta;
import com.dt.platform.domain.ops.PersonnelDivision;
import com.dt.platform.domain.ops.PersonnelDivisionVO;
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
import com.dt.platform.domain.ops.meta.PersonnelDivisionMeta;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IPersonnelDivisionService;
import com.github.foxnic.api.validate.annotations.NotNull;

/**
 * <p>
 * 人员分工接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-04 15:22:09
 */
@InDoc
@Api(tags = "人员分工")
@RestController("OpsPersonnelDivisionController")
public class PersonnelDivisionController extends SuperController {

    @Autowired
    private IPersonnelDivisionService personnelDivisionService;

    /**
     * 添加人员分工
     */
    @ApiOperation(value = "添加人员分工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.OWNER, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.POS, value = "岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.RESPONSIBLE_CONTENT, value = "负责内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.JOB_CONTENT, value = "工作内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    @ApiOperationSupport(order = 1, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonnelDivisionServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonnelDivisionServiceProxy.INSERT)
    public Result insert(PersonnelDivisionVO personnelDivisionVO) {
        Result result = personnelDivisionService.insert(personnelDivisionVO, false);
        return result;
    }

    /**
     * 删除人员分工
     */
    @ApiOperation(value = "删除人员分工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonnelDivisionServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonnelDivisionServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause = personnelDivisionService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录：" + cause.message(), false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult().messageLevel4Confirm();
        }
        Result result = personnelDivisionService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除人员分工 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除人员分工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonnelDivisionServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonnelDivisionServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = personnelDivisionService.hasRefers(ids);
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
            Result result = personnelDivisionService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = personnelDivisionService.deleteByIdsLogical(canDeleteIds);
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
     * 更新人员分工
     */
    @ApiOperation(value = "更新人员分工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.OWNER, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.POS, value = "岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.RESPONSIBLE_CONTENT, value = "负责内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.JOB_CONTENT, value = "工作内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 4, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonnelDivisionVOMeta.PAGE_INDEX, PersonnelDivisionVOMeta.PAGE_SIZE, PersonnelDivisionVOMeta.SEARCH_FIELD, PersonnelDivisionVOMeta.FUZZY_FIELD, PersonnelDivisionVOMeta.SEARCH_VALUE, PersonnelDivisionVOMeta.DIRTY_FIELDS, PersonnelDivisionVOMeta.SORT_FIELD, PersonnelDivisionVOMeta.SORT_TYPE, PersonnelDivisionVOMeta.DATA_ORIGIN, PersonnelDivisionVOMeta.QUERY_LOGIC, PersonnelDivisionVOMeta.IDS })
    @SentinelResource(value = PersonnelDivisionServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonnelDivisionServiceProxy.UPDATE)
    public Result update(PersonnelDivisionVO personnelDivisionVO) {
        Result result = personnelDivisionService.update(personnelDivisionVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存人员分工
     */
    @ApiOperation(value = "保存人员分工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.OWNER, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.POS, value = "岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.RESPONSIBLE_CONTENT, value = "负责内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.JOB_CONTENT, value = "工作内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    @ApiOperationSupport(order = 5, ignoreParameters = { PersonnelDivisionVOMeta.PAGE_INDEX, PersonnelDivisionVOMeta.PAGE_SIZE, PersonnelDivisionVOMeta.SEARCH_FIELD, PersonnelDivisionVOMeta.FUZZY_FIELD, PersonnelDivisionVOMeta.SEARCH_VALUE, PersonnelDivisionVOMeta.DIRTY_FIELDS, PersonnelDivisionVOMeta.SORT_FIELD, PersonnelDivisionVOMeta.SORT_TYPE, PersonnelDivisionVOMeta.DATA_ORIGIN, PersonnelDivisionVOMeta.QUERY_LOGIC, PersonnelDivisionVOMeta.IDS })
    @SentinelResource(value = PersonnelDivisionServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonnelDivisionServiceProxy.SAVE)
    public Result save(PersonnelDivisionVO personnelDivisionVO) {
        Result result = personnelDivisionService.save(personnelDivisionVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取人员分工
     */
    @ApiOperation(value = "获取人员分工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonnelDivisionServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonnelDivisionServiceProxy.GET_BY_ID)
    public Result<PersonnelDivision> getById(String id) {
        Result<PersonnelDivision> result = new Result<>();
        PersonnelDivision personnelDivision = personnelDivisionService.getById(id);
        // join 关联的对象
        personnelDivisionService.dao().fill(personnelDivision).with("user").with(PersonnelDivisionMeta.OWNER_DATA).execute();
        result.success(true).data(personnelDivision);
        return result;
    }

    /**
     * 批量获取人员分工 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取人员分工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonnelDivisionServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonnelDivisionServiceProxy.GET_BY_IDS)
    public Result<List<PersonnelDivision>> getByIds(List<String> ids) {
        Result<List<PersonnelDivision>> result = new Result<>();
        List<PersonnelDivision> list = personnelDivisionService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询人员分工
     */
    @ApiOperation(value = "查询人员分工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.OWNER, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.POS, value = "岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.RESPONSIBLE_CONTENT, value = "负责内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.JOB_CONTENT, value = "工作内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 5, author = "金杰 , maillank@qq.com", ignoreParameters = { PersonnelDivisionVOMeta.PAGE_INDEX, PersonnelDivisionVOMeta.PAGE_SIZE })
    @SentinelResource(value = PersonnelDivisionServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonnelDivisionServiceProxy.QUERY_LIST)
    public Result<List<PersonnelDivision>> queryList(PersonnelDivisionVO sample) {
        Result<List<PersonnelDivision>> result = new Result<>();
        List<PersonnelDivision> list = personnelDivisionService.queryList(sample);
        List<Employee> employees = CollectorUtil.collectList(list, PersonnelDivision::getUser);
        personnelDivisionService.dao().join(employees, Person.class);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询人员分工
     */
    @ApiOperation(value = "分页查询人员分工")
    @ApiImplicitParams({
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.USER_ID, value = "用户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.OWNER, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.POS, value = "岗位", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.RESPONSIBLE_CONTENT, value = "负责内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.JOB_CONTENT, value = "工作内容", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonnelDivisionVOMeta.SORT, value = "排序", required = false, dataTypeClass = Integer.class)
	})
    @ApiOperationSupport(order = 8, author = "金杰 , maillank@qq.com")
    @SentinelResource(value = PersonnelDivisionServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonnelDivisionServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<PersonnelDivision>> queryPagedList(PersonnelDivisionVO sample) {
        Result<PagedList<PersonnelDivision>> result = new Result<>();
        PagedList<PersonnelDivision> list = personnelDivisionService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personnelDivisionService.dao().fill(list).with("user").with(PersonnelDivisionMeta.OWNER_DATA).execute();
        List<Employee> employees = CollectorUtil.collectList(list, PersonnelDivision::getUser);
        personnelDivisionService.dao().join(employees, Person.class);
        result.success(true).data(list);
        return result;
    }
}
