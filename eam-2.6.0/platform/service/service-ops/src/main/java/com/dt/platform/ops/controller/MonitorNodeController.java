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
import com.dt.platform.proxy.ops.MonitorNodeServiceProxy;
import com.dt.platform.domain.ops.meta.MonitorNodeVOMeta;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorNodeVO;
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
import com.dt.platform.domain.ops.meta.MonitorNodeMeta;
import com.dt.platform.domain.ops.MonitorVoucher;
import com.dt.platform.domain.ops.MonitorNodeDb;
import com.dt.platform.domain.ops.MonitorNodeValue;
import com.dt.platform.domain.ops.MonitorNodeGroup;
import com.dt.platform.domain.ops.MonitorNodeType;
import com.dt.platform.domain.ops.MonitorNodeSubtype;
import com.dt.platform.domain.ops.MonitorTpl;
import io.swagger.annotations.Api;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiImplicitParam;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.dt.platform.ops.service.IMonitorNodeService;
import com.github.foxnic.api.swagger.ApiParamSupport;

/**
 * <p>
 * 节点 接口控制器
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-14 16:24:30
 */
@Api(tags = "节点")
@ApiSort(0)
@RestController("OpsMonitorNodeController")
public class MonitorNodeController extends SuperController {

    @Autowired
    private IMonitorNodeService monitorNodeService;

    /**
     * 添加节点
     */
    @ApiOperation(value = "添加节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_IP, value = "IP", required = false, dataTypeClass = String.class, example = "121.43.103.102"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class, example = "0"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SUB_TYPE, value = "子类型", required = false, dataTypeClass = String.class, example = "Redhat"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.GROUP_ID, value = "节点分组", required = false, dataTypeClass = String.class, example = "543027032871665664"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME, value = "主机名", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME_SHOW, value = "可见主机名", required = false, dataTypeClass = String.class, example = "121.43.103.10222"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_ENABLED, value = "是否启用", required = false, dataTypeClass = String.class, example = "disabled"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.STATUS, value = "监控状态", required = false, dataTypeClass = String.class, example = "online"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_VOUCHER_ID, value = "凭证(SSH)", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_PORT, value = "SSH端口", required = false, dataTypeClass = Integer.class, example = "22"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.AGENT_PORT, value = "Agent端口", required = false, dataTypeClass = Integer.class, example = "10052"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.ZABBIX_AGENT_PORT, value = "Zabbix代理端口", required = false, dataTypeClass = Integer.class, example = "10050"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_PORT, value = "Snmp端口", required = false, dataTypeClass = Integer.class, example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_VERSION, value = "Snmp版本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_COMMUNITY, value = "Snmp团体", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JMX_PORT, value = "Jmx端口", required = false, dataTypeClass = Integer.class, example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.IMPI_PORT, value = "Jmx端口", required = false, dataTypeClass = Integer.class, example = "623"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JDBC_URL, value = "Jdbc地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 1)
    @SentinelResource(value = MonitorNodeServiceProxy.INSERT, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeServiceProxy.INSERT)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true, ignorePrimaryKey = true)
    public Result insert(MonitorNodeVO monitorNodeVO) {
        Result result = monitorNodeService.insert(monitorNodeVO, false);
        return result;
    }

    /**
     * 删除节点
     */
    @ApiOperation(value = "删除节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 2)
    @SentinelResource(value = MonitorNodeServiceProxy.DELETE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeServiceProxy.DELETE)
    public Result deleteById(String id) {
        this.validator().asserts(id).require("缺少id值");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 引用校验
        ReferCause cause =  monitorNodeService.hasRefers(id);
        // 判断是否可以删除
        this.validator().asserts(cause.hasRefer()).requireEqual("不允许删除当前记录："+cause.message(),false);
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        Result result = monitorNodeService.deleteByIdLogical(id);
        return result;
    }

    /**
     * 批量删除节点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量删除节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorNodeServiceProxy.DELETE_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeServiceProxy.DELETE_BY_IDS)
    public Result deleteByIds(List<String> ids) {
        // 参数校验
        this.validator().asserts(ids).require("缺少ids参数");
        if (this.validator().failure()) {
            return this.validator().getFirstResult();
        }
        // 查询引用
        Map<String, ReferCause> causeMap = monitorNodeService.hasRefers(ids);
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
            Result result = monitorNodeService.deleteByIdsLogical(canDeleteIds);
            return result;
        } else if (canDeleteIds.size() > 0 && canDeleteIds.size() < ids.size()) {
            // 如果部分行可以删除
            Result result = monitorNodeService.deleteByIdsLogical(canDeleteIds);
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
     * 更新节点
     */
    @ApiOperation(value = "更新节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_IP, value = "IP", required = false, dataTypeClass = String.class, example = "121.43.103.102"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class, example = "0"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SUB_TYPE, value = "子类型", required = false, dataTypeClass = String.class, example = "Redhat"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.GROUP_ID, value = "节点分组", required = false, dataTypeClass = String.class, example = "543027032871665664"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME, value = "主机名", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME_SHOW, value = "可见主机名", required = false, dataTypeClass = String.class, example = "121.43.103.10222"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_ENABLED, value = "是否启用", required = false, dataTypeClass = String.class, example = "disabled"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.STATUS, value = "监控状态", required = false, dataTypeClass = String.class, example = "online"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_VOUCHER_ID, value = "凭证(SSH)", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_PORT, value = "SSH端口", required = false, dataTypeClass = Integer.class, example = "22"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.AGENT_PORT, value = "Agent端口", required = false, dataTypeClass = Integer.class, example = "10052"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.ZABBIX_AGENT_PORT, value = "Zabbix代理端口", required = false, dataTypeClass = Integer.class, example = "10050"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_PORT, value = "Snmp端口", required = false, dataTypeClass = Integer.class, example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_VERSION, value = "Snmp版本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_COMMUNITY, value = "Snmp团体", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JMX_PORT, value = "Jmx端口", required = false, dataTypeClass = Integer.class, example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.IMPI_PORT, value = "Jmx端口", required = false, dataTypeClass = Integer.class, example = "623"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JDBC_URL, value = "Jdbc地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 4, ignoreParameters = { MonitorNodeVOMeta.PAGE_INDEX, MonitorNodeVOMeta.PAGE_SIZE, MonitorNodeVOMeta.SEARCH_FIELD, MonitorNodeVOMeta.FUZZY_FIELD, MonitorNodeVOMeta.SEARCH_VALUE, MonitorNodeVOMeta.DIRTY_FIELDS, MonitorNodeVOMeta.SORT_FIELD, MonitorNodeVOMeta.SORT_TYPE, MonitorNodeVOMeta.IDS })
    @SentinelResource(value = MonitorNodeServiceProxy.UPDATE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeServiceProxy.UPDATE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result update(MonitorNodeVO monitorNodeVO) {
        Result result = monitorNodeService.update(monitorNodeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 保存节点
     */
    @ApiOperation(value = "保存节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_IP, value = "IP", required = false, dataTypeClass = String.class, example = "121.43.103.102"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class, example = "0"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SUB_TYPE, value = "子类型", required = false, dataTypeClass = String.class, example = "Redhat"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.GROUP_ID, value = "节点分组", required = false, dataTypeClass = String.class, example = "543027032871665664"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME, value = "主机名", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME_SHOW, value = "可见主机名", required = false, dataTypeClass = String.class, example = "121.43.103.10222"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_ENABLED, value = "是否启用", required = false, dataTypeClass = String.class, example = "disabled"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.STATUS, value = "监控状态", required = false, dataTypeClass = String.class, example = "online"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_VOUCHER_ID, value = "凭证(SSH)", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_PORT, value = "SSH端口", required = false, dataTypeClass = Integer.class, example = "22"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.AGENT_PORT, value = "Agent端口", required = false, dataTypeClass = Integer.class, example = "10052"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.ZABBIX_AGENT_PORT, value = "Zabbix代理端口", required = false, dataTypeClass = Integer.class, example = "10050"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_PORT, value = "Snmp端口", required = false, dataTypeClass = Integer.class, example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_VERSION, value = "Snmp版本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_COMMUNITY, value = "Snmp团体", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JMX_PORT, value = "Jmx端口", required = false, dataTypeClass = Integer.class, example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.IMPI_PORT, value = "Jmx端口", required = false, dataTypeClass = Integer.class, example = "623"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JDBC_URL, value = "Jdbc地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorNodeVOMeta.PAGE_INDEX, MonitorNodeVOMeta.PAGE_SIZE, MonitorNodeVOMeta.SEARCH_FIELD, MonitorNodeVOMeta.FUZZY_FIELD, MonitorNodeVOMeta.SEARCH_VALUE, MonitorNodeVOMeta.DIRTY_FIELDS, MonitorNodeVOMeta.SORT_FIELD, MonitorNodeVOMeta.SORT_TYPE, MonitorNodeVOMeta.IDS })
    @SentinelResource(value = MonitorNodeServiceProxy.SAVE, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeServiceProxy.SAVE)
    @ApiParamSupport(ignoreDBTreatyProperties = true, ignoreDefaultVoProperties = true)
    public Result save(MonitorNodeVO monitorNodeVO) {
        Result result = monitorNodeService.save(monitorNodeVO, SaveMode.DIRTY_OR_NOT_NULL_FIELDS, false);
        return result;
    }

    /**
     * 获取节点
     */
    @ApiOperation(value = "获取节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1")
	})
    @ApiOperationSupport(order = 6)
    @SentinelResource(value = MonitorNodeServiceProxy.GET_BY_ID, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeServiceProxy.GET_BY_ID)
    public Result<MonitorNode> getById(String id) {
        Result<MonitorNode> result = new Result<>();
        MonitorNode monitorNode = monitorNodeService.getById(id);
        // join 关联的对象
        monitorNodeService.dao().fill(monitorNode).with(MonitorNodeMeta.MONITOR_TPL_LIST).with(MonitorNodeMeta.SSH_VOUCHER).with(MonitorNodeMeta.MONITOR_NODE_GROUP).with(MonitorNodeMeta.MONITOR_NODE_TYPE).execute();
        result.success(true).data(monitorNode);
        return result;
    }

    /**
     * 批量获取节点 <br>
     * 联合主键时，请自行调整实现
     */
    @ApiOperation(value = "批量获取节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeVOMeta.IDS, value = "主键清单", required = true, dataTypeClass = List.class, example = "[1,3,4]")
	})
    @ApiOperationSupport(order = 3)
    @SentinelResource(value = MonitorNodeServiceProxy.GET_BY_IDS, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeServiceProxy.GET_BY_IDS)
    public Result<List<MonitorNode>> getByIds(List<String> ids) {
        Result<List<MonitorNode>> result = new Result<>();
        List<MonitorNode> list = monitorNodeService.queryListByIds(ids);
        result.success(true).data(list);
        return result;
    }

    /**
     * 查询节点
     */
    @ApiOperation(value = "查询节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_IP, value = "IP", required = false, dataTypeClass = String.class, example = "121.43.103.102"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class, example = "0"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SUB_TYPE, value = "子类型", required = false, dataTypeClass = String.class, example = "Redhat"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.GROUP_ID, value = "节点分组", required = false, dataTypeClass = String.class, example = "543027032871665664"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME, value = "主机名", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME_SHOW, value = "可见主机名", required = false, dataTypeClass = String.class, example = "121.43.103.10222"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_ENABLED, value = "是否启用", required = false, dataTypeClass = String.class, example = "disabled"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.STATUS, value = "监控状态", required = false, dataTypeClass = String.class, example = "online"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_VOUCHER_ID, value = "凭证(SSH)", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_PORT, value = "SSH端口", required = false, dataTypeClass = Integer.class, example = "22"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.AGENT_PORT, value = "Agent端口", required = false, dataTypeClass = Integer.class, example = "10052"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.ZABBIX_AGENT_PORT, value = "Zabbix代理端口", required = false, dataTypeClass = Integer.class, example = "10050"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_PORT, value = "Snmp端口", required = false, dataTypeClass = Integer.class, example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_VERSION, value = "Snmp版本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_COMMUNITY, value = "Snmp团体", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JMX_PORT, value = "Jmx端口", required = false, dataTypeClass = Integer.class, example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.IMPI_PORT, value = "Jmx端口", required = false, dataTypeClass = Integer.class, example = "623"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JDBC_URL, value = "Jdbc地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 5, ignoreParameters = { MonitorNodeVOMeta.PAGE_INDEX, MonitorNodeVOMeta.PAGE_SIZE })
    @SentinelResource(value = MonitorNodeServiceProxy.QUERY_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeServiceProxy.QUERY_LIST)
    public Result<List<MonitorNode>> queryList(MonitorNodeVO sample) {
        Result<List<MonitorNode>> result = new Result<>();
        List<MonitorNode> list = monitorNodeService.queryList(sample);
        result.success(true).data(list);
        return result;
    }

    /**
     * 分页查询节点
     */
    @ApiOperation(value = "分页查询节点")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = MonitorNodeVOMeta.ID, value = "主键", required = true, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_IP, value = "IP", required = false, dataTypeClass = String.class, example = "121.43.103.102"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.PID, value = "父节点", required = false, dataTypeClass = String.class, example = "0"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.TYPE, value = "类型", required = false, dataTypeClass = String.class, example = "os"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SUB_TYPE, value = "子类型", required = false, dataTypeClass = String.class, example = "Redhat"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.GROUP_ID, value = "节点分组", required = false, dataTypeClass = String.class, example = "543027032871665664"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME, value = "主机名", required = false, dataTypeClass = String.class, example = "192.168.1.1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_NAME_SHOW, value = "可见主机名", required = false, dataTypeClass = String.class, example = "121.43.103.10222"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_TYPE, value = "类型", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NODE_ENABLED, value = "是否启用", required = false, dataTypeClass = String.class, example = "disabled"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.STATUS, value = "监控状态", required = false, dataTypeClass = String.class, example = "online"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_VOUCHER_ID, value = "凭证(SSH)", required = false, dataTypeClass = String.class, example = "1"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SSH_PORT, value = "SSH端口", required = false, dataTypeClass = Integer.class, example = "22"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.AGENT_PORT, value = "Agent端口", required = false, dataTypeClass = Integer.class, example = "10052"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.ZABBIX_AGENT_PORT, value = "Zabbix代理端口", required = false, dataTypeClass = Integer.class, example = "10050"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_PORT, value = "Snmp端口", required = false, dataTypeClass = Integer.class, example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_VERSION, value = "Snmp版本", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.SNMP_COMMUNITY, value = "Snmp团体", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JMX_PORT, value = "Jmx端口", required = false, dataTypeClass = Integer.class, example = "12345"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.IMPI_PORT, value = "Jmx端口", required = false, dataTypeClass = Integer.class, example = "623"),
		@ApiImplicitParam(name = MonitorNodeVOMeta.JDBC_URL, value = "Jdbc地址", required = false, dataTypeClass = String.class),
		@ApiImplicitParam(name = MonitorNodeVOMeta.NOTES, value = "备注", required = false, dataTypeClass = String.class)
	})
    @ApiOperationSupport(order = 8)
    @SentinelResource(value = MonitorNodeServiceProxy.QUERY_PAGED_LIST, blockHandlerClass = { SentinelExceptionUtil.class }, blockHandler = SentinelExceptionUtil.HANDLER)
    @PostMapping(MonitorNodeServiceProxy.QUERY_PAGED_LIST)
    public Result<PagedList<MonitorNode>> queryPagedList(MonitorNodeVO sample) {
        Result<PagedList<MonitorNode>> result = new Result<>();
        PagedList<MonitorNode> list = monitorNodeService.queryPagedList(sample, sample.getPageSize(), sample.getPageIndex());
        // join 关联的对象
        monitorNodeService.dao().fill(list).with(MonitorNodeMeta.MONITOR_TPL_LIST).with(MonitorNodeMeta.SSH_VOUCHER).with(MonitorNodeMeta.MONITOR_NODE_GROUP).with(MonitorNodeMeta.MONITOR_NODE_TYPE).execute();
        result.success(true).data(list);
        return result;
    }
}
