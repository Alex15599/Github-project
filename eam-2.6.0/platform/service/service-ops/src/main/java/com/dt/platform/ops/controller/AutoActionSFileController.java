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
import com.dt.platform.proxy.ops.AutoActionSFileServiceProxy;
import com.dt.platform.domain.ops.meta.AutoActionSFileVOMeta;
import com.dt.platform.domain.ops.AutoActionSFile;
import com.dt.platform.domain.ops.AutoActionSFileVO;
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
import com.dt.platform.domain.ops.meta.AutoActionSFileMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IAutoActionSFileService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 介质选择 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-21 15:00:31
 */
@Api(tags = "介质选择")
@ApiSort(0)
@RestController("OpsAutoActionSFileController")
public class AutoActionSFileController extends SuperController {

    @Autowired
    private IAutoActionSFileService autoActionSFileService;

    /**
     * 添加介质选择
     */
    @ApiOperation(value = "添加介质选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSFileVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSFileVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AutoActionSFileServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSFileServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AutoActionSFileVO autoActionSFileVO) {
        Result result = autoActionSFileService.insert(autoActionSFileVO, false);
        return result;
    }

    /**
     * 删除介质选择
     */
    @ApiOperation(value = "删除介质选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AutoActionSFileServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSFileServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  autoActionSFileService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = autoActionSFileService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除介质选择 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除介质选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSFileVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoActionSFileServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSFileServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = autoActionSFileService.hasRefers(ids);
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
            Result result = autoActionSFileService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = autoActionSFileService.deleteByIdsLogical(canDeleteIds);
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
     * 更新介质选择
     */
    @ApiOperation(value = "更新介质选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSFileVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSFileVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AutoActionSFileVOMeta.PAGE_INDEX, AutoActionSFileVOMeta.PAGE_SIZE, AutoActionSFileVOMeta.SEARCH_FIELD, AutoActionSFileVOMeta.FUZZY_FIELD, AutoActionSFileVOMeta.SEARCH_VALUE, AutoActionSFileVOMeta.DIRTY_FIELDS, AutoActionSFileVOMeta.SORT_FIELD, AutoActionSFileVOMeta.SORT_TYPE, AutoActionSFileVOMeta.IDS })
    @SentinelResource(value = AutoActionSFileServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSFileServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AutoActionSFileVO autoActionSFileVO) {
        Result result = autoActionSFileService.update(autoActionSFileVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存介质选择
     */
    @ApiOperation(value = "保存介质选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSFileVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSFileVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoActionSFileVOMeta.PAGE_INDEX, AutoActionSFileVOMeta.PAGE_SIZE, AutoActionSFileVOMeta.SEARCH_FIELD, AutoActionSFileVOMeta.FUZZY_FIELD, AutoActionSFileVOMeta.SEARCH_VALUE, AutoActionSFileVOMeta.DIRTY_FIELDS, AutoActionSFileVOMeta.SORT_FIELD, AutoActionSFileVOMeta.SORT_TYPE, AutoActionSFileVOMeta.IDS })
    @SentinelResource(value = AutoActionSFileServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSFileServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AutoActionSFileVO autoActionSFileVO) {
        Result result = autoActionSFileService.save(autoActionSFileVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取介质选择
     */
    @ApiOperation(value = "获取介质选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AutoActionSFileServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSFileServiceProxy.GET_BY_ID)
    public Result<AutoActionSFile> getById(String id) {
        Result<AutoActionSFile> result = new Result<>();
        AutoActionSFile autoActionSFile = autoActionSFileService.getById(id);
        result.success(true).data(autoActionSFile);
        return result;
    }

    /**
     * 批量获取介质选择 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取介质选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSFileVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoActionSFileServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSFileServiceProxy.GET_BY_IDS)
    public Result<List<AutoActionSFile>> getByIds(List<String> ids) {
        Result<List<AutoActionSFile>> result = new Result<>();
        List<AutoActionSFile> list = autoActionSFileService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询介质选择
     */
    @ApiOperation(value = "查询介质选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSFileVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSFileVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoActionSFileVOMeta.PAGE_INDEX, AutoActionSFileVOMeta.PAGE_SIZE })
    @SentinelResource(value = AutoActionSFileServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSFileServiceProxy.QUERY_LIST)
    public Result<List<AutoActionSFile>> queryList(AutoActionSFileVO sample) {
        Result<List<AutoActionSFile>> result = new Result<>();
        List<AutoActionSFile> list = autoActionSFileService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询介质选择
     */
    @ApiOperation(value = "分页查询介质选择")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionSFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSFileVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionSFileVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AutoActionSFileServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionSFileServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AutoActionSFile>> queryPagedList(AutoActionSFileVO sample) {
        Result<PagedList<AutoActionSFile>> result = new Result<>();
        PagedList<AutoActionSFile> list = autoActionSFileService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
