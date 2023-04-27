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
import com.dt.platform.proxy.workorder.NetworkStrategyInfoServiceProxy;
import com.dt.platform.domain.workorder.meta.NetworkStrategyInfoVOMeta;
import com.dt.platform.domain.workorder.NetworkStrategyInfo;
import com.dt.platform.domain.workorder.NetworkStrategyInfoVO;
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
import com.dt.platform.domain.workorder.meta.NetworkStrategyInfoMeta;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.workorder.service.INetworkStrategyInfoService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 网络策略 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-06 06:16:46
 */
@Api(tags = "网络策略")
@ApiSort(0)
@RestController("WoNetworkStrategyInfoController")
public class NetworkStrategyInfoController extends SuperController {

    @Autowired
    private INetworkStrategyInfoService networkStrategyInfoService;

    /**
     * 添加网络策略
     */
    @ApiOperation(value = "添加网络策略")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "596613755035451392"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SOURCE_NAME, value = "源名称", required = false, dataTypeClass = String.class, example = "终端"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SOURCE_IP, value = "源IP", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_NAME, value = "目标名称", required = false, dataTypeClass = String.class, example = "网站"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_IP, value = "目标IP", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_PORTS, value = "目标端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.USED_PROTOCOL_TYPE, value = "使用协议", required = false, dataTypeClass = String.class, example = "tcp"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SESSION_TYPE, value = "连接类型", required = false, dataTypeClass = String.class, example = "long"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = NetworkStrategyInfoServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyInfoServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(NetworkStrategyInfoVO networkStrategyInfoVO) {
        Result result = networkStrategyInfoService.insert(networkStrategyInfoVO, false);
        return result;
    }

    /**
     * 删除网络策略
     */
    @ApiOperation(value = "删除网络策略")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "596613755035451392")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = NetworkStrategyInfoServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyInfoServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  networkStrategyInfoService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = networkStrategyInfoService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除网络策略 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除网络策略")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = NetworkStrategyInfoServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyInfoServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = networkStrategyInfoService.hasRefers(ids);
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
            Result result = networkStrategyInfoService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = networkStrategyInfoService.deleteByIdsLogical(canDeleteIds);
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
     * 更新网络策略
     */
    @ApiOperation(value = "更新网络策略")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "596613755035451392"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SOURCE_NAME, value = "源名称", required = false, dataTypeClass = String.class, example = "终端"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SOURCE_IP, value = "源IP", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_NAME, value = "目标名称", required = false, dataTypeClass = String.class, example = "网站"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_IP, value = "目标IP", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_PORTS, value = "目标端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.USED_PROTOCOL_TYPE, value = "使用协议", required = false, dataTypeClass = String.class, example = "tcp"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SESSION_TYPE, value = "连接类型", required = false, dataTypeClass = String.class, example = "long"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { NetworkStrategyInfoVOMeta.PAGE_INDEX, NetworkStrategyInfoVOMeta.PAGE_SIZE, NetworkStrategyInfoVOMeta.SEARCH_FIELD, NetworkStrategyInfoVOMeta.FUZZY_FIELD, NetworkStrategyInfoVOMeta.SEARCH_VALUE, NetworkStrategyInfoVOMeta.DIRTY_FIELDS, NetworkStrategyInfoVOMeta.SORT_FIELD, NetworkStrategyInfoVOMeta.SORT_TYPE, NetworkStrategyInfoVOMeta.IDS })
    @SentinelResource(value = NetworkStrategyInfoServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyInfoServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(NetworkStrategyInfoVO networkStrategyInfoVO) {
        Result result = networkStrategyInfoService.update(networkStrategyInfoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存网络策略
     */
    @ApiOperation(value = "保存网络策略")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "596613755035451392"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SOURCE_NAME, value = "源名称", required = false, dataTypeClass = String.class, example = "终端"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SOURCE_IP, value = "源IP", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_NAME, value = "目标名称", required = false, dataTypeClass = String.class, example = "网站"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_IP, value = "目标IP", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_PORTS, value = "目标端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.USED_PROTOCOL_TYPE, value = "使用协议", required = false, dataTypeClass = String.class, example = "tcp"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SESSION_TYPE, value = "连接类型", required = false, dataTypeClass = String.class, example = "long"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { NetworkStrategyInfoVOMeta.PAGE_INDEX, NetworkStrategyInfoVOMeta.PAGE_SIZE, NetworkStrategyInfoVOMeta.SEARCH_FIELD, NetworkStrategyInfoVOMeta.FUZZY_FIELD, NetworkStrategyInfoVOMeta.SEARCH_VALUE, NetworkStrategyInfoVOMeta.DIRTY_FIELDS, NetworkStrategyInfoVOMeta.SORT_FIELD, NetworkStrategyInfoVOMeta.SORT_TYPE, NetworkStrategyInfoVOMeta.IDS })
    @SentinelResource(value = NetworkStrategyInfoServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyInfoServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(NetworkStrategyInfoVO networkStrategyInfoVO) {
        Result result = networkStrategyInfoService.save(networkStrategyInfoVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取网络策略
     */
    @ApiOperation(value = "获取网络策略")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = NetworkStrategyInfoServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyInfoServiceProxy.GET_BY_ID)
    public Result<NetworkStrategyInfo> getById(String id) {
        Result<NetworkStrategyInfo> result = new Result<>();
        NetworkStrategyInfo networkStrategyInfo = networkStrategyInfoService.getById(id);
        result.success(true).data(networkStrategyInfo);
        return result;
    }

    /**
     * 批量获取网络策略 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取网络策略")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = NetworkStrategyInfoServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyInfoServiceProxy.GET_BY_IDS)
    public Result<List<NetworkStrategyInfo>> getByIds(List<String> ids) {
        Result<List<NetworkStrategyInfo>> result = new Result<>();
        List<NetworkStrategyInfo> list = networkStrategyInfoService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询网络策略
     */
    @ApiOperation(value = "查询网络策略")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "596613755035451392"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SOURCE_NAME, value = "源名称", required = false, dataTypeClass = String.class, example = "终端"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SOURCE_IP, value = "源IP", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_NAME, value = "目标名称", required = false, dataTypeClass = String.class, example = "网站"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_IP, value = "目标IP", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_PORTS, value = "目标端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.USED_PROTOCOL_TYPE, value = "使用协议", required = false, dataTypeClass = String.class, example = "tcp"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SESSION_TYPE, value = "连接类型", required = false, dataTypeClass = String.class, example = "long"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { NetworkStrategyInfoVOMeta.PAGE_INDEX, NetworkStrategyInfoVOMeta.PAGE_SIZE })
    @SentinelResource(value = NetworkStrategyInfoServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyInfoServiceProxy.QUERY_LIST)
    public Result<List<NetworkStrategyInfo>> queryList(NetworkStrategyInfoVO sample) {
        Result<List<NetworkStrategyInfo>> result = new Result<>();
        List<NetworkStrategyInfo> list = networkStrategyInfoService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询网络策略
     */
    @ApiOperation(value = "分页查询网络策略")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "596613755035451392"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SOURCE_NAME, value = "源名称", required = false, dataTypeClass = String.class, example = "终端"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.OWNER_ID, value = "所属", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SOURCE_IP, value = "源IP", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_NAME, value = "目标名称", required = false, dataTypeClass = String.class, example = "网站"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_IP, value = "目标IP", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.TARGET_PORTS, value = "目标端口", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.USED_PROTOCOL_TYPE, value = "使用协议", required = false, dataTypeClass = String.class, example = "tcp"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SESSION_TYPE, value = "连接类型", required = false, dataTypeClass = String.class, example = "long"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class, example = "1212"),
		@ApiImplicitParam(name = NetworkStrategyInfoVOMeta.SELECTED_CODE, value = "选择", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = NetworkStrategyInfoServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(NetworkStrategyInfoServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<NetworkStrategyInfo>> queryPagedList(NetworkStrategyInfoVO sample) {
        Result<PagedList<NetworkStrategyInfo>> result = new Result<>();
        PagedList<NetworkStrategyInfo> list = networkStrategyInfoService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        result.success(true).data(list);
        return result;
    }
}
