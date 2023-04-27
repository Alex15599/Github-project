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
import com.dt.platform.proxy.ops.AutoBatchServiceProxy;
import com.dt.platform.domain.ops.meta.AutoBatchVOMeta;
import com.dt.platform.domain.ops.AutoBatch;
import com.dt.platform.domain.ops.AutoBatchVO;
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
import com.dt.platform.domain.ops.meta.AutoBatchMeta;
import com.dt.platform.domain.ops.AutoNode;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IAutoBatchService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 节点批次 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 14:26:33
 */
@Api(tags = "节点批次")
@ApiSort(0)
@RestController("OpsAutoBatchController")
public class AutoBatchController extends SuperController {

    @Autowired
    private IAutoBatchService autoBatchService;

    /**
     * 添加节点批次
     */
    @ApiOperation(value = "添加节点批次")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614051736079826944"),
		@ApiImplicitParam(name = AutoBatchVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "批次2"),
		@ApiImplicitParam(name = AutoBatchVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoBatchVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoBatchVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AutoBatchServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AutoBatchVO autoBatchVO) {
        Result result = autoBatchService.insert(autoBatchVO, false);
        return result;
    }

    /**
     * 删除节点批次
     */
    @ApiOperation(value = "删除节点批次")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614051736079826944")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AutoBatchServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  autoBatchService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = autoBatchService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除节点批次 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除节点批次")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoBatchServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = autoBatchService.hasRefers(ids);
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
            Result result = autoBatchService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = autoBatchService.deleteByIdsLogical(canDeleteIds);
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
     * 更新节点批次
     */
    @ApiOperation(value = "更新节点批次")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614051736079826944"),
		@ApiImplicitParam(name = AutoBatchVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "批次2"),
		@ApiImplicitParam(name = AutoBatchVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoBatchVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoBatchVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AutoBatchVOMeta.PAGE_INDEX, AutoBatchVOMeta.PAGE_SIZE, AutoBatchVOMeta.SEARCH_FIELD, AutoBatchVOMeta.FUZZY_FIELD, AutoBatchVOMeta.SEARCH_VALUE, AutoBatchVOMeta.DIRTY_FIELDS, AutoBatchVOMeta.SORT_FIELD, AutoBatchVOMeta.SORT_TYPE, AutoBatchVOMeta.IDS })
    @SentinelResource(value = AutoBatchServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AutoBatchVO autoBatchVO) {
        Result result = autoBatchService.update(autoBatchVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存节点批次
     */
    @ApiOperation(value = "保存节点批次")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614051736079826944"),
		@ApiImplicitParam(name = AutoBatchVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "批次2"),
		@ApiImplicitParam(name = AutoBatchVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoBatchVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoBatchVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoBatchVOMeta.PAGE_INDEX, AutoBatchVOMeta.PAGE_SIZE, AutoBatchVOMeta.SEARCH_FIELD, AutoBatchVOMeta.FUZZY_FIELD, AutoBatchVOMeta.SEARCH_VALUE, AutoBatchVOMeta.DIRTY_FIELDS, AutoBatchVOMeta.SORT_FIELD, AutoBatchVOMeta.SORT_TYPE, AutoBatchVOMeta.IDS })
    @SentinelResource(value = AutoBatchServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AutoBatchVO autoBatchVO) {
        Result result = autoBatchService.save(autoBatchVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取节点批次
     */
    @ApiOperation(value = "获取节点批次")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AutoBatchServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchServiceProxy.GET_BY_ID)
    public Result<AutoBatch> getById(String id) {
        Result<AutoBatch> result = new Result<>();
        AutoBatch autoBatch = autoBatchService.getById(id);
        result.success(true).data(autoBatch);
        return result;
    }

    /**
     * 批量获取节点批次 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取节点批次")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoBatchServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchServiceProxy.GET_BY_IDS)
    public Result<List<AutoBatch>> getByIds(List<String> ids) {
        Result<List<AutoBatch>> result = new Result<>();
        List<AutoBatch> list = autoBatchService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询节点批次
     */
    @ApiOperation(value = "查询节点批次")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614051736079826944"),
		@ApiImplicitParam(name = AutoBatchVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "批次2"),
		@ApiImplicitParam(name = AutoBatchVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoBatchVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoBatchVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoBatchVOMeta.PAGE_INDEX, AutoBatchVOMeta.PAGE_SIZE })
    @SentinelResource(value = AutoBatchServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchServiceProxy.QUERY_LIST)
    public Result<List<AutoBatch>> queryList(AutoBatchVO sample) {
        Result<List<AutoBatch>> result = new Result<>();
        List<AutoBatch> list = autoBatchService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询节点批次
     */
    @ApiOperation(value = "分页查询节点批次")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoBatchVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "614051736079826944"),
		@ApiImplicitParam(name = AutoBatchVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "批次2"),
		@ApiImplicitParam(name = AutoBatchVOMeta.STATUS, value = "状态", required = false, dataTypeClass = String.class, example = "enable"),
		@ApiImplicitParam(name = AutoBatchVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = AutoBatchVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AutoBatchServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoBatchServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AutoBatch>> queryPagedList(AutoBatchVO sample) {
        Result<PagedList<AutoBatch>> result = new Result<>();
        PagedList<AutoBatch> list = autoBatchService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
