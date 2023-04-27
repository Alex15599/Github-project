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
import com.dt.platform.proxy.ops.PersonServiceProxy;
import com.dt.platform.domain.ops.meta.PersonVOMeta;
import com.dt.platform.domain.ops.Person;
import com.dt.platform.domain.ops.PersonVO;
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
import com.dt.platform.domain.ops.meta.PersonMeta;
import org.github.foxnic.web.domain.system.DictItem;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IPersonService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 人员清单 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-12 21:51:48
 */
@Api(tags = "人员清单")
@ApiSort(0)
@RestController("OpsPersonController")
public class PersonController extends SuperController {

    @Autowired
    private IPersonService personService;

    /**
     * 添加人员清单
     */
    @ApiOperation(value = "添加人员清单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "591581191656701952"),
		@ApiImplicitParam(name = PersonVOMeta.COMPANY_NAME, value = "组织名称", required = false, dataTypeClass = String.class, example = "深信服"),
		@ApiImplicitParam(name = PersonVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class, example = "陈军"),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_TYPE, value = "人员类型", required = false, dataTypeClass = String.class, example = "business"),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class, example = "13726588768"),
		@ApiImplicitParam(name = PersonVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = PersonServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(PersonVO personVO) {
        Result result = personService.insert(personVO, false);
        return result;
    }

    /**
     * 删除人员清单
     */
    @ApiOperation(value = "删除人员清单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "591581191656701952")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = PersonServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  personService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = personService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除人员清单 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除人员清单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PersonVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = PersonServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = personService.hasRefers(ids);
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
            Result result = personService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = personService.deleteByIdsLogical(canDeleteIds);
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
     * 更新人员清单
     */
    @ApiOperation(value = "更新人员清单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "591581191656701952"),
		@ApiImplicitParam(name = PersonVOMeta.COMPANY_NAME, value = "组织名称", required = false, dataTypeClass = String.class, example = "深信服"),
		@ApiImplicitParam(name = PersonVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class, example = "陈军"),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_TYPE, value = "人员类型", required = false, dataTypeClass = String.class, example = "business"),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class, example = "13726588768"),
		@ApiImplicitParam(name = PersonVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { PersonVOMeta.PAGE_INDEX, PersonVOMeta.PAGE_SIZE, PersonVOMeta.SEARCH_FIELD, PersonVOMeta.FUZZY_FIELD, PersonVOMeta.SEARCH_VALUE, PersonVOMeta.DIRTY_FIELDS, PersonVOMeta.SORT_FIELD, PersonVOMeta.SORT_TYPE, PersonVOMeta.IDS })
    @SentinelResource(value = PersonServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(PersonVO personVO) {
        Result result = personService.update(personVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存人员清单
     */
    @ApiOperation(value = "保存人员清单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "591581191656701952"),
		@ApiImplicitParam(name = PersonVOMeta.COMPANY_NAME, value = "组织名称", required = false, dataTypeClass = String.class, example = "深信服"),
		@ApiImplicitParam(name = PersonVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class, example = "陈军"),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_TYPE, value = "人员类型", required = false, dataTypeClass = String.class, example = "business"),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class, example = "13726588768"),
		@ApiImplicitParam(name = PersonVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { PersonVOMeta.PAGE_INDEX, PersonVOMeta.PAGE_SIZE, PersonVOMeta.SEARCH_FIELD, PersonVOMeta.FUZZY_FIELD, PersonVOMeta.SEARCH_VALUE, PersonVOMeta.DIRTY_FIELDS, PersonVOMeta.SORT_FIELD, PersonVOMeta.SORT_TYPE, PersonVOMeta.IDS })
    @SentinelResource(value = PersonServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(PersonVO personVO) {
        Result result = personService.save(personVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取人员清单
     */
    @ApiOperation(value = "获取人员清单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = PersonServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.GET_BY_ID)
    public Result<Person> getById(String id) {
        Result<Person> result = new Result<>();
        Person person = personService.getById(id);
        // join 关联的对象
        personService.dao().fill(person).with(PersonMeta.PERSON_TYPE_DICT).execute();
        result.success(true).data(person);
        return result;
    }

    /**
     * 批量获取人员清单 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取人员清单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PersonVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = PersonServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.GET_BY_IDS)
    public Result<List<Person>> getByIds(List<String> ids) {
        Result<List<Person>> result = new Result<>();
        List<Person> list = personService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询人员清单
     */
    @ApiOperation(value = "查询人员清单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "591581191656701952"),
		@ApiImplicitParam(name = PersonVOMeta.COMPANY_NAME, value = "组织名称", required = false, dataTypeClass = String.class, example = "深信服"),
		@ApiImplicitParam(name = PersonVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class, example = "陈军"),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_TYPE, value = "人员类型", required = false, dataTypeClass = String.class, example = "business"),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class, example = "13726588768"),
		@ApiImplicitParam(name = PersonVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { PersonVOMeta.PAGE_INDEX, PersonVOMeta.PAGE_SIZE })
    @SentinelResource(value = PersonServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.QUERY_LIST)
    public Result<List<Person>> queryList(PersonVO sample) {
        Result<List<Person>> result = new Result<>();
        List<Person> list = personService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询人员清单
     */
    @ApiOperation(value = "分页查询人员清单")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = PersonVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "591581191656701952"),
		@ApiImplicitParam(name = PersonVOMeta.COMPANY_NAME, value = "组织名称", required = false, dataTypeClass = String.class, example = "深信服"),
		@ApiImplicitParam(name = PersonVOMeta.NAME, value = "姓名", required = false, dataTypeClass = String.class, example = "陈军"),
		@ApiImplicitParam(name = PersonVOMeta.PERSON_TYPE, value = "人员类型", required = false, dataTypeClass = String.class, example = "business"),
		@ApiImplicitParam(name = PersonVOMeta.CONTACT_INFORMATION, value = "联系方式", required = false, dataTypeClass = String.class, example = "13726588768"),
		@ApiImplicitParam(name = PersonVOMeta.LABEL, value = "标签", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = PersonVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = PersonServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(PersonServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Person>> queryPagedList(PersonVO sample) {
        Result<PagedList<Person>> result = new Result<>();
        PagedList<Person> list = personService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        personService.dao().fill(list).with(PersonMeta.PERSON_TYPE_DICT).execute();
        result.success(true).data(list);
        return result;
    }
}
