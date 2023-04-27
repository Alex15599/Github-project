package com.dt.platform.ops.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.domain.ops.MonitorTplGraph;
import com.dt.platform.ops.service.IMonitorStatisticalDataService;
import com.dt.platform.ops.service.IMonitorTplGraphService;
import com.dt.platform.proxy.ops.MonitorStatisticalDataServiceProxy;
import com.github.foxnic.api.transter.Result;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.github.foxnic.web.framework.sentinel.SentinelExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.dao.entity.ReferCause;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "节点统计数据")
@ApiSort(0)
@RestController("MonitorStatisticalDataController")
public class MonitorStatisticalDataController {

    @Autowired
    private IMonitorStatisticalDataService monitorStatisticalData;

    @Autowired
    private IMonitorTplGraphService monitorTplGraphService;

    /**
     * 查询节点统计数据
     */
    @ApiOperation(value = "查询节点统计数据")
    @ApiOperationSupport(order=1)
    @SentinelResource(value = MonitorStatisticalDataServiceProxy.QUERY_NODE_STATISTICS , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorStatisticalDataServiceProxy.QUERY_NODE_STATISTICS)
    public Result<JSONObject> queryNodeStatistics() {
        return monitorStatisticalData.queryNodeStatistics();
    }

    /**
     * 查询主机节点TOP数据
     */
    @ApiOperation(value = "查询主机节点TOP数据")
    @ApiOperationSupport(order=2)
    @SentinelResource(value = MonitorStatisticalDataServiceProxy.QUERY_NODE_HOST_TOP_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorStatisticalDataServiceProxy.QUERY_NODE_HOST_TOP_DATA)
    public Result<JSONObject> queryNodeHostTopData(List<String> topList,String top,String day) {
        return monitorStatisticalData.queryNodeHostTopData(topList,Integer.parseInt(top),Integer.parseInt(day));
    }

    /**
     * 查询主机节点列表
     */
    @ApiOperation(value = "查询主机节点列表")
    @ApiOperationSupport(order=3)
    @SentinelResource(value = MonitorStatisticalDataServiceProxy.QUERY_NODE_HOST_RESOURCE_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorStatisticalDataServiceProxy.QUERY_NODE_HOST_RESOURCE_LIST)
    public Result<JSONObject> queryNodeHostResourceList() {
        return monitorStatisticalData.queryNodeHostResourceList();
    }

    /**
     * 查询主机报错节点信息
     */
    @ApiOperation(value = "查询节点")
    @ApiOperationSupport(order=4)
    @SentinelResource(value = MonitorStatisticalDataServiceProxy.QUERY_NODE_COLLECT_DATA_FAILED , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorStatisticalDataServiceProxy.QUERY_NODE_COLLECT_DATA_FAILED)
    public Result<JSONObject> queryNodeCollectDataFailed() {
        return monitorStatisticalData.queryNodeCollectDataFailed();
    }

    /**
     * 查询主机
     */
    @ApiOperation(value = "查询节点")
    @ApiOperationSupport(order=5)
    @SentinelResource(value = MonitorStatisticalDataServiceProxy.QUERY_NODE_COLLECT_DATA , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorStatisticalDataServiceProxy.QUERY_NODE_COLLECT_DATA)
    public Result<JSONObject> queryNodeCollectData(String nodeId) {
        return monitorStatisticalData.queryNodeCollectData(nodeId);
    }

    /**
     * 查询节点图形数据
     */
    @ApiOperation(value = "查询节点图形数据")
    @ApiOperationSupport(order=6)
    @SentinelResource(value = MonitorStatisticalDataServiceProxy.QUERY_NODE_COLLECT_DATA_GRAPH , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorStatisticalDataServiceProxy.QUERY_NODE_COLLECT_DATA_GRAPH)
    public Result<JSONObject> queryNodeCollectDataGraph(String nodeId,String tplCode,String sdate,String edate,String day) {
        return monitorStatisticalData.queryNodeCollectDataGraph(nodeId,tplCode,sdate,edate,day);
    }

    /**
     * 查询节点图形数据
     */
    @ApiOperation(value = "查询节点图形数据")
    @ApiOperationSupport(order=7)
    @SentinelResource(value = MonitorStatisticalDataServiceProxy.QUERY_NODE_COLLECT_DATA_GRAPH_BY_GRAPH , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorStatisticalDataServiceProxy.QUERY_NODE_COLLECT_DATA_GRAPH_BY_GRAPH)
    public Result<JSONObject> queryNodeCollectData(String graphId,String nodeId,String sdate,String edate,String day) {
        MonitorTplGraph graph =monitorTplGraphService.getById(graphId);
        return monitorStatisticalData.queryNodeCollectDataGraphByGraph(graph,nodeId,sdate,edate,day);
    }

    /**
     * 查询节点树形数据
     */
    @ApiOperation(value = "查询节点树形数据")
    @ApiOperationSupport(order=8)
    @SentinelResource(value = MonitorStatisticalDataServiceProxy.QUERY_NODE_TREE_RESOURCE_LIST , blockHandlerClass = { SentinelExceptionUtil.class } , blockHandler = SentinelExceptionUtil.HANDLER )
    @PostMapping(MonitorStatisticalDataServiceProxy.QUERY_NODE_TREE_RESOURCE_LIST)
    public Result<JSONArray> queryNodeTreeResourceList(String type) {
        return monitorStatisticalData.queryNodeTreeResourceList();
    }

}
