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
import com.dt.platform.proxy.ops.AutoTaskNodeServiceProxy;
import com.dt.platform.domain.ops.meta.AutoTaskNodeVOMeta;
import com.dt.platform.domain.ops.AutoTaskNode;
import com.dt.platform.domain.ops.AutoTaskNodeVO;
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
import com.dt.platform.domain.ops.meta.AutoTaskNodeMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IAutoTaskNodeService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 作业节点 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-22 13:41:33
 */
@Api(tags = "作业节点")
@ApiSort(0)
@RestController("OpsAutoTaskNodeController")
public class AutoTaskNodeController extends SuperController {

    @Autowired
    private IAutoTaskNodeService autoTaskNodeService;

    /**
     * 添加作业节点
     */
    @ApiOperation(value = "添加作业节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = AutoTaskNodeServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskNodeServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(AutoTaskNodeVO autoTaskNodeVO) {
        Result result = autoTaskNodeService.insert(autoTaskNodeVO, false);
        return result;
    }

    /**
     * 删除作业节点
     */
    @ApiOperation(value = "删除作业节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = AutoTaskNodeServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskNodeServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  autoTaskNodeService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = autoTaskNodeService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除作业节点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除作业节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoTaskNodeServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskNodeServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = autoTaskNodeService.hasRefers(ids);
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
            Result result = autoTaskNodeService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = autoTaskNodeService.deleteByIdsLogical(canDeleteIds);
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
     * 更新作业节点
     */
    @ApiOperation(value = "更新作业节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { AutoTaskNodeVOMeta.PAGE_INDEX, AutoTaskNodeVOMeta.PAGE_SIZE, AutoTaskNodeVOMeta.SEARCH_FIELD, AutoTaskNodeVOMeta.FUZZY_FIELD, AutoTaskNodeVOMeta.SEARCH_VALUE, AutoTaskNodeVOMeta.DIRTY_FIELDS, AutoTaskNodeVOMeta.SORT_FIELD, AutoTaskNodeVOMeta.SORT_TYPE, AutoTaskNodeVOMeta.IDS })
    @SentinelResource(value = AutoTaskNodeServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskNodeServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(AutoTaskNodeVO autoTaskNodeVO) {
        Result result = autoTaskNodeService.update(autoTaskNodeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存作业节点
     */
    @ApiOperation(value = "保存作业节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoTaskNodeVOMeta.PAGE_INDEX, AutoTaskNodeVOMeta.PAGE_SIZE, AutoTaskNodeVOMeta.SEARCH_FIELD, AutoTaskNodeVOMeta.FUZZY_FIELD, AutoTaskNodeVOMeta.SEARCH_VALUE, AutoTaskNodeVOMeta.DIRTY_FIELDS, AutoTaskNodeVOMeta.SORT_FIELD, AutoTaskNodeVOMeta.SORT_TYPE, AutoTaskNodeVOMeta.IDS })
    @SentinelResource(value = AutoTaskNodeServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskNodeServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(AutoTaskNodeVO autoTaskNodeVO) {
        Result result = autoTaskNodeService.save(autoTaskNodeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取作业节点
     */
    @ApiOperation(value = "获取作业节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = AutoTaskNodeServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskNodeServiceProxy.GET_BY_ID)
    public Result<AutoTaskNode> getById(String id) {
        Result<AutoTaskNode> result = new Result<>();
        AutoTaskNode autoTaskNode = autoTaskNodeService.getById(id);
        result.success(true).data(autoTaskNode);
        return result;
    }

    /**
     * 批量获取作业节点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取作业节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = AutoTaskNodeServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskNodeServiceProxy.GET_BY_IDS)
    public Result<List<AutoTaskNode>> getByIds(List<String> ids) {
        Result<List<AutoTaskNode>> result = new Result<>();
        List<AutoTaskNode> list = autoTaskNodeService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询作业节点
     */
    @ApiOperation(value = "查询作业节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { AutoTaskNodeVOMeta.PAGE_INDEX, AutoTaskNodeVOMeta.PAGE_SIZE })
    @SentinelResource(value = AutoTaskNodeServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskNodeServiceProxy.QUERY_LIST)
    public Result<List<AutoTaskNode>> queryList(AutoTaskNodeVO sample) {
        Result<List<AutoTaskNode>> result = new Result<>();
        List<AutoTaskNode> list = autoTaskNodeService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询作业节点
     */
    @ApiOperation(value = "分页查询作业节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.TASK_ID, value = "作业", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.NODE_ID, value = "节点", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = AutoTaskNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = AutoTaskNodeServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(AutoTaskNodeServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<AutoTaskNode>> queryPagedList(AutoTaskNodeVO sample) {
        Result<PagedList<AutoTaskNode>> result = new Result<>();
        PagedList<AutoTaskNode> list = autoTaskNodeService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
