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
import com.dt.platform.proxy.ops.AutoActionFileServiceProxy;
import com.dt.platform.domain.ops.meta.AutoActionFileVOMeta;
import com.dt.platform.domain.ops.AutoActionFile;
import com.dt.platform.domain.ops.AutoActionFileVO;
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
import com.dt.platform.domain.ops.meta.AutoActionFileMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IAutoActionFileService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 执行介质 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-21 13:59:12
 */
@Api(tags = "执行介质")
@ApiSort(0)
@RestController("OpsAutoActionFileController")
public class AutoActionFileController extends SuperController {

    @Autowired
    private IAutoActionFileService autoActionFileService;

    /**
     * 添加执行介质
     */
    @ApiOperation(value = "添加执行介质")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AutoActionFileServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionFileServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AutoActionFileVO autoActionFileVO) {
        Result result = autoActionFileService.insert(autoActionFileVO, false);
        return result;
    }

    /**
     * 删除执行介质
     */
    @ApiOperation(value = "删除执行介质")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AutoActionFileServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionFileServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  autoActionFileService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = autoActionFileService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除执行介质 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除执行介质")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionFileVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoActionFileServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionFileServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = autoActionFileService.hasRefers(ids);
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
            Result result = autoActionFileService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = autoActionFileService.deleteByIdsLogical(canDeleteIds);
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
     * 更新执行介质
     */
    @ApiOperation(value = "更新执行介质")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AutoActionFileVOMeta.PAGE_INDEX, AutoActionFileVOMeta.PAGE_SIZE, AutoActionFileVOMeta.SEARCH_FIELD, AutoActionFileVOMeta.FUZZY_FIELD, AutoActionFileVOMeta.SEARCH_VALUE, AutoActionFileVOMeta.DIRTY_FIELDS, AutoActionFileVOMeta.SORT_FIELD, AutoActionFileVOMeta.SORT_TYPE, AutoActionFileVOMeta.IDS })
    @SentinelResource(value = AutoActionFileServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionFileServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AutoActionFileVO autoActionFileVO) {
        Result result = autoActionFileService.update(autoActionFileVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存执行介质
     */
    @ApiOperation(value = "保存执行介质")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoActionFileVOMeta.PAGE_INDEX, AutoActionFileVOMeta.PAGE_SIZE, AutoActionFileVOMeta.SEARCH_FIELD, AutoActionFileVOMeta.FUZZY_FIELD, AutoActionFileVOMeta.SEARCH_VALUE, AutoActionFileVOMeta.DIRTY_FIELDS, AutoActionFileVOMeta.SORT_FIELD, AutoActionFileVOMeta.SORT_TYPE, AutoActionFileVOMeta.IDS })
    @SentinelResource(value = AutoActionFileServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionFileServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AutoActionFileVO autoActionFileVO) {
        Result result = autoActionFileService.save(autoActionFileVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取执行介质
     */
    @ApiOperation(value = "获取执行介质")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AutoActionFileServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionFileServiceProxy.GET_BY_ID)
    public Result<AutoActionFile> getById(String id) {
        Result<AutoActionFile> result = new Result<>();
        AutoActionFile autoActionFile = autoActionFileService.getById(id);
        result.success(true).data(autoActionFile);
        return result;
    }

    /**
     * 批量获取执行介质 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取执行介质")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionFileVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoActionFileServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionFileServiceProxy.GET_BY_IDS)
    public Result<List<AutoActionFile>> getByIds(List<String> ids) {
        Result<List<AutoActionFile>> result = new Result<>();
        List<AutoActionFile> list = autoActionFileService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询执行介质
     */
    @ApiOperation(value = "查询执行介质")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoActionFileVOMeta.PAGE_INDEX, AutoActionFileVOMeta.PAGE_SIZE })
    @SentinelResource(value = AutoActionFileServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionFileServiceProxy.QUERY_LIST)
    public Result<List<AutoActionFile>> queryList(AutoActionFileVO sample) {
        Result<List<AutoActionFile>> result = new Result<>();
        List<AutoActionFile> list = autoActionFileService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询执行介质
     */
    @ApiOperation(value = "分页查询执行介质")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoActionFileVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.FILE_NAME, value = "文件名称", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.FILE_ID, value = "文件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoActionFileVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AutoActionFileServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoActionFileServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AutoActionFile>> queryPagedList(AutoActionFileVO sample) {
        Result<PagedList<AutoActionFile>> result = new Result<>();
        PagedList<AutoActionFile> list = autoActionFileService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
