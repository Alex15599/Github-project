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
import com.dt.platform.proxy.ops.AutoVoucherServiceProxy;
import com.dt.platform.domain.ops.meta.AutoVoucherVOMeta;
import com.dt.platform.domain.ops.AutoVoucher;
import com.dt.platform.domain.ops.AutoVoucherVO;
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
import com.dt.platform.domain.ops.meta.AutoVoucherMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IAutoVoucherService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 自动化凭证 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-21 14:09:43
 */
@Api(tags = "自动化凭证")
@ApiSort(0)
@RestController("OpsAutoVoucherController")
public class AutoVoucherController extends SuperController {

    @Autowired
    private IAutoVoucherService autoVoucherService;

    /**
     * 添加自动化凭证
     */
    @ApiOperation(value = "添加自动化凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoVoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.ACCOUNT, value = "账户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.VOUCHER, value = "凭证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AutoVoucherServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoVoucherServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AutoVoucherVO autoVoucherVO) {
        Result result = autoVoucherService.insert(autoVoucherVO, false);
        return result;
    }

    /**
     * 删除自动化凭证
     */
    @ApiOperation(value = "删除自动化凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoVoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AutoVoucherServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoVoucherServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  autoVoucherService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = autoVoucherService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除自动化凭证 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除自动化凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoVoucherVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoVoucherServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoVoucherServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = autoVoucherService.hasRefers(ids);
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
            Result result = autoVoucherService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = autoVoucherService.deleteByIdsLogical(canDeleteIds);
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
     * 更新自动化凭证
     */
    @ApiOperation(value = "更新自动化凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoVoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.ACCOUNT, value = "账户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.VOUCHER, value = "凭证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AutoVoucherVOMeta.PAGE_INDEX, AutoVoucherVOMeta.PAGE_SIZE, AutoVoucherVOMeta.SEARCH_FIELD, AutoVoucherVOMeta.FUZZY_FIELD, AutoVoucherVOMeta.SEARCH_VALUE, AutoVoucherVOMeta.DIRTY_FIELDS, AutoVoucherVOMeta.SORT_FIELD, AutoVoucherVOMeta.SORT_TYPE, AutoVoucherVOMeta.IDS })
    @SentinelResource(value = AutoVoucherServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoVoucherServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AutoVoucherVO autoVoucherVO) {
        Result result = autoVoucherService.update(autoVoucherVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存自动化凭证
     */
    @ApiOperation(value = "保存自动化凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoVoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.ACCOUNT, value = "账户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.VOUCHER, value = "凭证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoVoucherVOMeta.PAGE_INDEX, AutoVoucherVOMeta.PAGE_SIZE, AutoVoucherVOMeta.SEARCH_FIELD, AutoVoucherVOMeta.FUZZY_FIELD, AutoVoucherVOMeta.SEARCH_VALUE, AutoVoucherVOMeta.DIRTY_FIELDS, AutoVoucherVOMeta.SORT_FIELD, AutoVoucherVOMeta.SORT_TYPE, AutoVoucherVOMeta.IDS })
    @SentinelResource(value = AutoVoucherServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoVoucherServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AutoVoucherVO autoVoucherVO) {
        Result result = autoVoucherService.save(autoVoucherVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取自动化凭证
     */
    @ApiOperation(value = "获取自动化凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoVoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AutoVoucherServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoVoucherServiceProxy.GET_BY_ID)
    public Result<AutoVoucher> getById(String id) {
        Result<AutoVoucher> result = new Result<>();
        AutoVoucher autoVoucher = autoVoucherService.getById(id);
        result.success(true).data(autoVoucher);
        return result;
    }

    /**
     * 批量获取自动化凭证 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取自动化凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoVoucherVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoVoucherServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoVoucherServiceProxy.GET_BY_IDS)
    public Result<List<AutoVoucher>> getByIds(List<String> ids) {
        Result<List<AutoVoucher>> result = new Result<>();
        List<AutoVoucher> list = autoVoucherService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询自动化凭证
     */
    @ApiOperation(value = "查询自动化凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoVoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.ACCOUNT, value = "账户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.VOUCHER, value = "凭证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoVoucherVOMeta.PAGE_INDEX, AutoVoucherVOMeta.PAGE_SIZE })
    @SentinelResource(value = AutoVoucherServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoVoucherServiceProxy.QUERY_LIST)
    public Result<List<AutoVoucher>> queryList(AutoVoucherVO sample) {
        Result<List<AutoVoucher>> result = new Result<>();
        List<AutoVoucher> list = autoVoucherService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询自动化凭证
     */
    @ApiOperation(value = "分页查询自动化凭证")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoVoucherVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.ACCOUNT, value = "账户", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.VOUCHER, value = "凭证", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoVoucherVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AutoVoucherServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoVoucherServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AutoVoucher>> queryPagedList(AutoVoucherVO sample) {
        Result<PagedList<AutoVoucher>> result = new Result<>();
        PagedList<AutoVoucher> list = autoVoucherService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
