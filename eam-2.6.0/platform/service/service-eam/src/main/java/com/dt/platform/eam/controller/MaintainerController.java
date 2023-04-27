package com.dt.platform.eam.controller;

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
import com.dt.platform.proxy.eam.MaintainerServiceProxy;
import com.dt.platform.domain.eam.meta.MaintainerVOMeta;
import com.dt.platform.domain.eam.Maintainer;
import com.dt.platform.domain.eam.MaintainerVO;
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
import com.dt.platform.domain.eam.meta.MaintainerMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.eam.service.IMaintainerService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 维保厂商 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-30 22:05:17
 */
@Api(tags = "维保厂商")
@ApiSort(0)
@RestController("EamMaintainerController")
public class MaintainerController extends SuperController {

    @Autowired
    private IMaintainerService maintainerService;

    /**
     * 添加维保厂商
     */
    @ApiOperation(value = "添加维保厂商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MaintainerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "471599404445335552"),
		@ApiImplicitParam(name = MaintainerVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "华为科技有限公司"),
		@ApiImplicitParam(name = MaintainerVOMeta.BUSINESS_CONTACTS, value = "商务联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.BUSINESS_CONTACTS_INFO, value = "商务联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.AFTER_SALES_CONTACTS, value = "售后联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.AFTER_SALES_CONTACTS_INFO, value = "售后联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.UNIT_CODE, value = "统一社会信用代码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.ADDRESS, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MaintainerServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MaintainerServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(MaintainerVO maintainerVO) {
        Result result = maintainerService.insert(maintainerVO, false);
        return result;
    }

    /**
     * 删除维保厂商
     */
    @ApiOperation(value = "删除维保厂商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MaintainerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "471599404445335552")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MaintainerServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MaintainerServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  maintainerService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = maintainerService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除维保厂商 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除维保厂商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MaintainerVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MaintainerServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MaintainerServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = maintainerService.hasRefers(ids);
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
            Result result = maintainerService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = maintainerService.deleteByIdsLogical(canDeleteIds);
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
     * 更新维保厂商
     */
    @ApiOperation(value = "更新维保厂商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MaintainerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "471599404445335552"),
		@ApiImplicitParam(name = MaintainerVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "华为科技有限公司"),
		@ApiImplicitParam(name = MaintainerVOMeta.BUSINESS_CONTACTS, value = "商务联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.BUSINESS_CONTACTS_INFO, value = "商务联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.AFTER_SALES_CONTACTS, value = "售后联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.AFTER_SALES_CONTACTS_INFO, value = "售后联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.UNIT_CODE, value = "统一社会信用代码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.ADDRESS, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { MaintainerVOMeta.PAGE_INDEX, MaintainerVOMeta.PAGE_SIZE, MaintainerVOMeta.SEARCH_FIELD, MaintainerVOMeta.FUZZY_FIELD, MaintainerVOMeta.SEARCH_VALUE, MaintainerVOMeta.DIRTY_FIELDS, MaintainerVOMeta.SORT_FIELD, MaintainerVOMeta.SORT_TYPE, MaintainerVOMeta.IDS })
    @SentinelResource(value = MaintainerServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MaintainerServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(MaintainerVO maintainerVO) {
        Result result = maintainerService.update(maintainerVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存维保厂商
     */
    @ApiOperation(value = "保存维保厂商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MaintainerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "471599404445335552"),
		@ApiImplicitParam(name = MaintainerVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "华为科技有限公司"),
		@ApiImplicitParam(name = MaintainerVOMeta.BUSINESS_CONTACTS, value = "商务联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.BUSINESS_CONTACTS_INFO, value = "商务联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.AFTER_SALES_CONTACTS, value = "售后联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.AFTER_SALES_CONTACTS_INFO, value = "售后联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.UNIT_CODE, value = "统一社会信用代码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.ADDRESS, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MaintainerVOMeta.PAGE_INDEX, MaintainerVOMeta.PAGE_SIZE, MaintainerVOMeta.SEARCH_FIELD, MaintainerVOMeta.FUZZY_FIELD, MaintainerVOMeta.SEARCH_VALUE, MaintainerVOMeta.DIRTY_FIELDS, MaintainerVOMeta.SORT_FIELD, MaintainerVOMeta.SORT_TYPE, MaintainerVOMeta.IDS })
    @SentinelResource(value = MaintainerServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MaintainerServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(MaintainerVO maintainerVO) {
        Result result = maintainerService.save(maintainerVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取维保厂商
     */
    @ApiOperation(value = "获取维保厂商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MaintainerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MaintainerServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MaintainerServiceProxy.GET_BY_ID)
    public Result<Maintainer> getById(String id) {
        Result<Maintainer> result = new Result<>();
        Maintainer maintainer = maintainerService.getById(id);
        result.success(true).data(maintainer);
        return result;
    }

    /**
     * 批量获取维保厂商 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取维保厂商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MaintainerVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MaintainerServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MaintainerServiceProxy.GET_BY_IDS)
    public Result<List<Maintainer>> getByIds(List<String> ids) {
        Result<List<Maintainer>> result = new Result<>();
        List<Maintainer> list = maintainerService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询维保厂商
     */
    @ApiOperation(value = "查询维保厂商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MaintainerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "471599404445335552"),
		@ApiImplicitParam(name = MaintainerVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "华为科技有限公司"),
		@ApiImplicitParam(name = MaintainerVOMeta.BUSINESS_CONTACTS, value = "商务联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.BUSINESS_CONTACTS_INFO, value = "商务联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.AFTER_SALES_CONTACTS, value = "售后联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.AFTER_SALES_CONTACTS_INFO, value = "售后联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.UNIT_CODE, value = "统一社会信用代码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.ADDRESS, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MaintainerVOMeta.PAGE_INDEX, MaintainerVOMeta.PAGE_SIZE })
    @SentinelResource(value = MaintainerServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MaintainerServiceProxy.QUERY_LIST)
    public Result<List<Maintainer>> queryList(MaintainerVO sample) {
        Result<List<Maintainer>> result = new Result<>();
        List<Maintainer> list = maintainerService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询维保厂商
     */
    @ApiOperation(value = "分页查询维保厂商")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MaintainerVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "471599404445335552"),
		@ApiImplicitParam(name = MaintainerVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NAME, value = "名称", required = false, dataTypeClass = String.class, example = "华为科技有限公司"),
		@ApiImplicitParam(name = MaintainerVOMeta.BUSINESS_CONTACTS, value = "商务联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.BUSINESS_CONTACTS_INFO, value = "商务联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.AFTER_SALES_CONTACTS, value = "售后联系人", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.AFTER_SALES_CONTACTS_INFO, value = "售后联系方式", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.UNIT_CODE, value = "统一社会信用代码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.ADDRESS, value = "地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MaintainerVOMeta.MAINTAINER_NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MaintainerServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MaintainerServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<Maintainer>> queryPagedList(MaintainerVO sample) {
        Result<PagedList<Maintainer>> result = new Result<>();
        PagedList<Maintainer> list = maintainerService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
