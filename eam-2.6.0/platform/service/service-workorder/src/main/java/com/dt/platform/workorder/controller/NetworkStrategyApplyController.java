package com.dt.platform.workorder.controller;

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
import org.github.foxnic.web.constants.enums.bpm.BpmEventType;
import org.github.foxnic.web.proxy.bpm.BpmCallbackController;
import org.github.foxnic.web.domain.bpm.BpmActionResult;
import org.github.foxnic.web.domain.bpm.BpmEvent;
import com.dt.platform.proxy.workorder.NetworkStrategyApplyServiceProxy;
import com.dt.platform.domain.workorder.meta.NetworkStrategyApplyVOMeta;
import com.dt.platform.domain.workorder.NetworkStrategyApply;
import com.dt.platform.domain.workorder.NetworkStrategyApplyVO;
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
import com.dt.platform.domain.workorder.meta.NetworkStrategyApplyMeta;
import com.dt.platform.domain.workorder.NetworkStrategyInfo;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.workorder.service.INetworkStrategyApplyService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 网络策略申请 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-15 20:03:47
 */
@Api(tags = "网络策略申请")
@ApiSort(0)
@RestController("WoNetworkStrategyApplyController")
public class NetworkStrategyApplyController extends SuperController implements BpmCallbackController {

    @Autowired
    private INetworkStrategyApplyService networkStrategyApplyService;

    /**
     * 添加网络策略申请
     */
    @ApiOperation(value = "添加网络策略申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "596614640608215040"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.PROJECT_NAME, value = "项目", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ENVIRONMENT_ID, value = "运行环境", required = false, dataTypeClass = String.class, example = "prod"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.PERIOD_TYPE, value = "有效期", required = false, dataTypeClass = String.class, example = "permanent"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.EXPIRATION_DATE, value = "过期日期", required = false, dataTypeClass = Date.class, example = "2022-07-05 12:00:00"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.APPLY_DATE, value = "申请日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.EXPECTED_COMPLETION_DATE, value = "期望日期", required = false, dataTypeClass = Date.class, example = "2022-07-05 12:00:00"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.CONTENT, value = "申请原因", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ORIGINATOR_ID, value = "申请人", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = NetworkStrategyApplyServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyApplyServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(NetworkStrategyApplyVO networkStrategyApplyVO) {
        Result result = networkStrategyApplyService.insert(networkStrategyApplyVO, false);
        return result;
    }

    /**
     * 删除网络策略申请
     */
    @ApiOperation(value = "删除网络策略申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "596614640608215040")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = NetworkStrategyApplyServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyApplyServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  networkStrategyApplyService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = networkStrategyApplyService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除网络策略申请 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除网络策略申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = NetworkStrategyApplyServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyApplyServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = networkStrategyApplyService.hasRefers(ids);
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
            Result result = networkStrategyApplyService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = networkStrategyApplyService.deleteByIdsLogical(canDeleteIds);
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
     * 更新网络策略申请
     */
    @ApiOperation(value = "更新网络策略申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "596614640608215040"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.PROJECT_NAME, value = "项目", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ENVIRONMENT_ID, value = "运行环境", required = false, dataTypeClass = String.class, example = "prod"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.PERIOD_TYPE, value = "有效期", required = false, dataTypeClass = String.class, example = "permanent"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.EXPIRATION_DATE, value = "过期日期", required = false, dataTypeClass = Date.class, example = "2022-07-05 12:00:00"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.APPLY_DATE, value = "申请日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.EXPECTED_COMPLETION_DATE, value = "期望日期", required = false, dataTypeClass = Date.class, example = "2022-07-05 12:00:00"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.CONTENT, value = "申请原因", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ORIGINATOR_ID, value = "申请人", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { NetworkStrategyApplyVOMeta.PAGE_INDEX, NetworkStrategyApplyVOMeta.PAGE_SIZE, NetworkStrategyApplyVOMeta.SEARCH_FIELD, NetworkStrategyApplyVOMeta.FUZZY_FIELD, NetworkStrategyApplyVOMeta.SEARCH_VALUE, NetworkStrategyApplyVOMeta.DIRTY_FIELDS, NetworkStrategyApplyVOMeta.SORT_FIELD, NetworkStrategyApplyVOMeta.SORT_TYPE, NetworkStrategyApplyVOMeta.IDS })
    @SentinelResource(value = NetworkStrategyApplyServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyApplyServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(NetworkStrategyApplyVO networkStrategyApplyVO) {
        Result result = networkStrategyApplyService.update(networkStrategyApplyVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存网络策略申请
     */
    @ApiOperation(value = "保存网络策略申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "596614640608215040"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.PROJECT_NAME, value = "项目", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ENVIRONMENT_ID, value = "运行环境", required = false, dataTypeClass = String.class, example = "prod"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.PERIOD_TYPE, value = "有效期", required = false, dataTypeClass = String.class, example = "permanent"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.EXPIRATION_DATE, value = "过期日期", required = false, dataTypeClass = Date.class, example = "2022-07-05 12:00:00"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.APPLY_DATE, value = "申请日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.EXPECTED_COMPLETION_DATE, value = "期望日期", required = false, dataTypeClass = Date.class, example = "2022-07-05 12:00:00"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.CONTENT, value = "申请原因", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ORIGINATOR_ID, value = "申请人", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { NetworkStrategyApplyVOMeta.PAGE_INDEX, NetworkStrategyApplyVOMeta.PAGE_SIZE, NetworkStrategyApplyVOMeta.SEARCH_FIELD, NetworkStrategyApplyVOMeta.FUZZY_FIELD, NetworkStrategyApplyVOMeta.SEARCH_VALUE, NetworkStrategyApplyVOMeta.DIRTY_FIELDS, NetworkStrategyApplyVOMeta.SORT_FIELD, NetworkStrategyApplyVOMeta.SORT_TYPE, NetworkStrategyApplyVOMeta.IDS })
    @SentinelResource(value = NetworkStrategyApplyServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyApplyServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(NetworkStrategyApplyVO networkStrategyApplyVO) {
        Result result = networkStrategyApplyService.save(networkStrategyApplyVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取网络策略申请
     */
    @ApiOperation(value = "获取网络策略申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = NetworkStrategyApplyServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyApplyServiceProxy.GET_BY_ID)
    public Result<NetworkStrategyApply> getById(String id) {
        Result<NetworkStrategyApply> result = new Result<>();
        NetworkStrategyApply networkStrategyApply = networkStrategyApplyService.getById(id);
        // join 关联的对象
        networkStrategyApplyService.dao().fill(networkStrategyApply).with("originator").execute();
        result.success(true).data(networkStrategyApply);
        return result;
    }

    /**
     * 批量获取网络策略申请 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取网络策略申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = NetworkStrategyApplyServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyApplyServiceProxy.GET_BY_IDS)
    public Result<List<NetworkStrategyApply>> getByIds(List<String> ids) {
        Result<List<NetworkStrategyApply>> result = new Result<>();
        List<NetworkStrategyApply> list = networkStrategyApplyService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询网络策略申请
     */
    @ApiOperation(value = "查询网络策略申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "596614640608215040"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.PROJECT_NAME, value = "项目", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ENVIRONMENT_ID, value = "运行环境", required = false, dataTypeClass = String.class, example = "prod"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.PERIOD_TYPE, value = "有效期", required = false, dataTypeClass = String.class, example = "permanent"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.EXPIRATION_DATE, value = "过期日期", required = false, dataTypeClass = Date.class, example = "2022-07-05 12:00:00"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.APPLY_DATE, value = "申请日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.EXPECTED_COMPLETION_DATE, value = "期望日期", required = false, dataTypeClass = Date.class, example = "2022-07-05 12:00:00"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.CONTENT, value = "申请原因", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ORIGINATOR_ID, value = "申请人", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { NetworkStrategyApplyVOMeta.PAGE_INDEX, NetworkStrategyApplyVOMeta.PAGE_SIZE })
    @SentinelResource(value = NetworkStrategyApplyServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyApplyServiceProxy.QUERY_LIST)
    public Result<List<NetworkStrategyApply>> queryList(NetworkStrategyApplyVO sample) {
        Result<List<NetworkStrategyApply>> result = new Result<>();
        List<NetworkStrategyApply> list = networkStrategyApplyService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询网络策略申请
     */
    @ApiOperation(value = "分页查询网络策略申请")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "596614640608215040"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.CODE, value = "编码", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.STATUS, value = "办理状态", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.NAME, value = "名称", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.PROJECT_NAME, value = "项目", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ENVIRONMENT_ID, value = "运行环境", required = false, dataTypeClass = String.class, example = "prod"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.PERIOD_TYPE, value = "有效期", required = false, dataTypeClass = String.class, example = "permanent"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.EXPIRATION_DATE, value = "过期日期", required = false, dataTypeClass = Date.class, example = "2022-07-05 12:00:00"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.APPLY_DATE, value = "申请日期", required = false, dataTypeClass = Date.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.EXPECTED_COMPLETION_DATE, value = "期望日期", required = false, dataTypeClass = Date.class, example = "2022-07-05 12:00:00"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.CONTENT, value = "申请原因", required = false, dataTypeClass = String.class, example = "服务器策略申请"),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.FILE_ID, value = "附件", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyApplyVOMeta.ORIGINATOR_ID, value = "申请人", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = NetworkStrategyApplyServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyApplyServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<NetworkStrategyApply>> queryPagedList(NetworkStrategyApplyVO sample) {
        Result<PagedList<NetworkStrategyApply>> result = new Result<>();
        PagedList<NetworkStrategyApply> list = networkStrategyApplyService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        networkStrategyApplyService.dao().fill(list).with("originator").execute();
        // 填充流程相关的属性
        networkStrategyApplyService.joinProcess(list);
        result.success(true).data(list);
        return result;
    }

    /**
     *  流程回调处理
     */
    @SentinelResource(value = NetworkStrategyApplyServiceProxy.BPM_CALLBACK, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyApplyServiceProxy.BPM_CALLBACK)
    public BpmActionResult onProcessCallback(BpmEvent event) {
        return networkStrategyApplyService.onProcessCallback(event);
    }
}
