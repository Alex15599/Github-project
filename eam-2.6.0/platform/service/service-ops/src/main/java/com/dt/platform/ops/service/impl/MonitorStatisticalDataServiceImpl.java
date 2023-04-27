package com.dt.platform.ops.service.impl;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.ops.MonitorTopDataEnum;
import com.dt.platform.constants.enums.ops.MonitorTplGraphTypeEnum;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.domain.ops.MonitorTpl;
import com.dt.platform.domain.ops.MonitorTplGraph;
import com.dt.platform.domain.ops.MonitorTplGraphItem;
import com.dt.platform.domain.ops.meta.MonitorNodeMeta;
import com.dt.platform.domain.ops.meta.MonitorTplGraphMeta;
import com.dt.platform.domain.ops.meta.MonitorTplMeta;
import com.dt.platform.ops.service.IMonitorNodeService;
import com.dt.platform.ops.service.IMonitorStatisticalDataService;
import com.dt.platform.ops.service.IMonitorTplGraphService;
import com.dt.platform.ops.service.IMonitorTplService;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.concurrent.SimpleJoinForkTask;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import com.github.foxnic.sql.expr.Insert;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLSyntaxErrorException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("MonitorStatisticalDataService")
public class MonitorStatisticalDataServiceImpl extends SuperService<MonitorNode> implements IMonitorStatisticalDataService {

        /**
     * 注入DAO对象
     * */
    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    @Autowired
    private IMonitorNodeService monitorNodeService;

    @Autowired
    private IMonitorTplGraphService monitorTplGraphService;

    @Autowired
    private IMonitorTplService monitorTplService;

    /**
     * 获得 DAO 对象
     * */
    public DAO dao() { return dao; }

    @Override
    public <T> Map<T, ReferCause> hasRefers(List<T> list) {
        return null;
    }


    @Override
    public Result<JSONObject> queryNodeStatistics() {
        Result<JSONObject> result=new Result<>();
        JSONObject resultData=new JSONObject();
        //统计节点个数
        String sql="select a.name,a.code,ifnull(b.cnt,0) cnt from ops_monitor_node_type a left join (select type,count(1) cnt from ops_monitor_node where deleted=0 group by type) b on a.code=b.type";
        resultData.put("nodeStatistics",dao.query(sql).toJSONArrayWithJSONObject());
        return result.success(true).data(resultData);
    }

    @Override
    public Result<JSONObject> queryNodeHostResourceList() {

        String sql=" \n" +
                "select\n" +

                "\n" +
                "(select 100-cpu_idle\n" +
                "from ops_monitor_node_value_last t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value_last where result_status='sucess'  and  indicator_code='os.cpu' group by node_id,indicator_code)\n" +
                " and t.node_id=end.id limit 1\n" +
                ") data_os_cpu_used, \n" +
//                "(select max_record_time from \n" +
//                "(select node_id, max(record_time) max_record_time from ops_monitor_node_value_last where result_status='sucess' group by node_id) t\n" +
//                "where t.node_id=end.id limit 1\n" +
//                ") data_max_record_time,\n" +
                "(\n" +
                "select p_memory_size\n" +
                "from ops_monitor_node_value_last t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value_last where result_status='sucess' and indicator_code='os.memory_size' group by node_id,indicator_code)\n" +
                "  and t.node_id=end.id limit 1\n" +
                ") data_p_memory_size,\n" +
                "(\n" +
                "select process_cnt\n" +
                "from ops_monitor_node_value_last t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value_last where result_status='sucess'  and indicator_code='os.process_cnt' group by node_id,indicator_code)\n" +
                "  and t.node_id=end.id limit 1\n" +
                ") data_process_cnt,\n" +
                "(\n" +
                "select os_load\n" +
                "from ops_monitor_node_value_last t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value_last where result_status='sucess' and indicator_code='os.load'  group by node_id,indicator_code)\n" +
                "  and t.node_id=end.id limit 1\n" +
                ") data_os_load,\n" +
                "(\n" +
                "select cpu_number\n" +
                "from ops_monitor_node_value_last t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value_last where result_status='sucess'  and indicator_code='os.cpu_number'  group by node_id,indicator_code)\n" +
                "and t.node_id=end.id limit 1\n" +
                ") data_os_cpu_number,\n" +
                "(\n" +
                "select hostname\n" +
                "from ops_monitor_node_value_last t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value_last where result_status='sucess'  and indicator_code='os.hostname'  group by node_id,indicator_code)\n" +
                " and t.node_id=end.id limit 1\n" +
                ") data_hostname,\n" +
                "\n" +
                "(\n" +
                "select p_memory_used\n" +
                "from ops_monitor_node_value_last t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value_last where result_status='sucess'  and indicator_code='os.memory_used'  group by node_id,indicator_code)\n" +
                " and t.node_id=end.id limit 1\n" +
                ") data_p_memory_used,\n" +
                "(\n" +
                "select os_datetime\n" +
                "from ops_monitor_node_value_last t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value_last where result_status='sucess'   and indicator_code='os.datetime'  group by node_id,indicator_code)\n" +
                "and t.node_id=end.id limit 1\n" +
                ") data_os_datetime,\n" +
                "\n" +
                "(\n" +
                "select max(list_value_number1) flow_up\n" +
                "from ops_monitor_node_value_last t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value_last where result_status='sucess' and indicator_code='os.net_interface_flow'  group by node_id,indicator_code)\n" +
                "  and t.node_id=end.id limit 1\n" +
                ") data_os_net_interface_flow_up,\n" +
                "(\n" +
                "select max(list_value_number2) flow_down\n" +
                "from ops_monitor_node_value_last t where \n" +
                "(node_id,indicator_code,record_time) in \n" +
                "(select node_id,indicator_code, max(record_time) max_record_time from ops_monitor_node_value_last where result_status='sucess' and indicator_code='os.net_interface_flow' group by node_id,indicator_code)\n" +
                "  and t.node_id=end.id limit 1\n" +
                ") data_os_net_interface_flow_down,\n" +
                "\n" +
                "end.*\n" +
                "from ops_monitor_node end where node_enabled='enable' and deleted=0 \n" ;
        Result<JSONObject> result=new Result<>();
        JSONObject resultData=new JSONObject();
        //统计节点个数
        resultData.put("nodeHostList",dao.query(sql).toJSONArrayWithJSONObject());
        return result.success(true).data(resultData);
    }




    @Override
    public Result<JSONArray> queryNodeTreeResourceList() {

         String sql="select * from ops_monitor_node_group where deleted=0 and id in (select distinct group_id from ops_monitor_node a where a.node_enabled='enable' and a.deleted=0)";
         Result<JSONArray> result=new Result<>();
         JSONArray data=new JSONArray();
         RcdSet rs=dao.query(sql);
         for(Rcd r:rs){
             JSONObject obj=new JSONObject();
             obj.put("parentId","0");
             obj.put("id",r.getString("id"));
             obj.put("ip","");
             obj.put("name",r.getString("name"));
             obj.put("type","group");
             data.add(obj);
             String nodeSql="select id,node_ip,node_name_show name,a.type show_type from ops_monitor_node a where a.node_enabled='enable' and a.deleted=0 and group_id=?";
             RcdSet nodeRs=dao.query(nodeSql,r.getString("id"));
             for(Rcd noder:nodeRs){
                 JSONObject nodeObj=new JSONObject();
                 nodeObj.put("parentId",r.getString("id"));
                 nodeObj.put("id",noder.getString("id"));
                 nodeObj.put("ip",noder.getString("node_ip"));
                 nodeObj.put("name",noder.getString("name")+"["+noder.getString("node_ip")+"]");
                 nodeObj.put("type","node");
                 nodeObj.put("showType",noder.getString("show_type"));
                 data.add(nodeObj);
             }
         }
        return result.success(true).data(data);
    }

    @Override
    public Result<JSONObject> queryNodeCollectDataFailed() {

        String sql="select t1.*,t2.node_ip,t2.node_name_show,t3.name tpl_name from \n" +
                "(\n" +
                "select node_id,monitor_tpl_code,indicator_code,record_time,result_message  \n" +
                "from ops_monitor_node_value_last t \n" +
                "where (node_id,monitor_tpl_code,indicator_code,record_time) in (\n" +
                "\n" +
                "select node_id,monitor_tpl_code,indicator_code,max_record_time from (\n" +
                "select a1.*, a2.max_record_time a2_max_record_time from (\n" +
                "select node_id,monitor_tpl_code,indicator_code, max(record_time) max_record_time from ops_monitor_node_value_last where result_status='failed' group by node_id,monitor_tpl_code,indicator_code\n" +
                ")a1 left join \n" +
                "(\n" +
                "select node_id,monitor_tpl_code,indicator_code, max(record_time) max_record_time from ops_monitor_node_value_last where result_status='sucess' group by node_id,monitor_tpl_code,indicator_code\n" +
                ")a2\n" +
                "on  a1.node_id=a2.node_id\n" +
                "and a1.monitor_tpl_code=a2.monitor_tpl_code\n" +
                "and a1.indicator_code=a2.indicator_code\n" +
                ") end where a2_max_record_time is null or max_record_time>a2_max_record_time\n" +
                ")\n" +
                ")t1,ops_monitor_node t2,ops_monitor_tpl t3\n" +
                "where t1.node_id=t2.id and t3.code=t1.monitor_tpl_code";
        Result<JSONObject> result=new Result<>();
        JSONObject resultData=new JSONObject();
        //统计节点个数
        resultData.put("nodeList",dao.query(sql).toJSONArrayWithJSONObject());
        return result.success(true).data(resultData);
    }


    public String lineToHump(String str) {
        Pattern linePattern = Pattern.compile("_(\\w)");
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /*
    * nodeIp,
    * nodeShowName
    * tplName
    * indicatorCode
    * value
    * */
    private JSONObject parseCollectData(JSONObject meta){

        JSONObject result=new JSONObject();
        result.put("nodeIp",meta.getString("nodeIp"));
        result.put("nodeNameShow",meta.getString("nodeNameShow"));
        result.put("monitorTplCode",meta.getString("monitorTplCode"));
        result.put("indicatorCode",meta.getString("code"));
        result.put("indicatorName",meta.getString("name"));
        result.put("recordTime",meta.getString("recordTime"));
        result.put("valueColumnName",meta.getString("valueColumnName"));
        String colType=meta.getString("valueColumnCols");
        if("single".equals(colType)){
            String col=meta.getString("valueColumn");
            result.put("value",meta.getString(lineToHump(col)));
        }else if("multiple".equals(colType)){
            String[] colArr=meta.getString("valueColumn").split(",");

            if(colArr.length>0){
                String v="";
                for(int i=0;i<colArr.length;i++){
                    if(i==0){
                        v=meta.getString(lineToHump(colArr[i]));
                    }else{
                        v=v+","+meta.getString(lineToHump(colArr[i]));
                    }
                }
                result.put("value",v);
            }else{
                result.put("value","未知错误");
            }
        }else{
            result.put("value","未知错误");
        }
        return result;
    }

    @Override
    public Result<JSONObject> queryNodeCollectDataGraph(String nodeId,String tplCode,String sdate,String edate,String day) {
        Result<JSONObject> result=new Result<>();
        JSONObject resultData=new JSONObject();
        MonitorNode monitorNode=monitorNodeService.getById(nodeId);
        // join 关联的对象
        monitorNodeService.dao().fill(monitorNode)
                .with(MonitorNodeMeta.MONITOR_TPL_LIST)
                .execute();
        resultData.put("nodeInfo",BeanUtil.toJSONObject(monitorNode));
        JSONArray tplData=new JSONArray();
        if(monitorNode.getMonitorTplList()!=null&&monitorNode.getMonitorTplList().size()>0){
            for(MonitorTpl tpl:monitorNode.getMonitorTplList()){
                if(!"enable".equals(tpl.getStatus())){
                    continue;
                }
                Boolean match=false;
                //tplCode 存在值,并且匹配
                if(StringUtil.isBlank(tplCode)) {
                    match=true;
                }else{
                    if(tpl.getCode().equals(tplCode)){
                        match=true;
                    }
                }
                if(match){
                    Result<JSONArray> r=queryNodeCollectDataTpl(tpl,nodeId,sdate,edate,day);
                    if(r.isSuccess()){
                        tplData.add(r.getData());
                    }
                }
            }
            resultData.put("tplData",tplData);
        }
        return result.success(true).data(resultData);
    }

    @Override
    public Result<JSONArray> queryNodeCollectDataTpl(MonitorTpl tpl,String nodeId,String sdate,String edate,String day) {
        Result<JSONArray> result=new Result<>();
        JSONArray resultData=new JSONArray();
        // join 关联的对象
        monitorTplService.dao().fill(tpl)
                .with(MonitorTplMeta.GRAPH_LIST)
                .execute();
        if(tpl.getGraphList()!=null&&tpl.getGraphList().size()>0){
            SimpleJoinForkTask<MonitorTplGraph,JSONObject> task=new SimpleJoinForkTask<>(tpl.getGraphList(),2);
            List<JSONObject> rvs=task.execute(els->{
                // 打印当前线程信息
                Logger.info("Thread name:"+Thread.currentThread().getName());
                // 处理当前分到的 若干元素，此处为 5 个
                List<JSONObject> rs=new ArrayList<>();
                for (MonitorTplGraph graph : els) {
                    if("enable".equals(graph.getStatus())){
                    Result<JSONObject> r=queryNodeCollectDataGraphByGraph(graph,nodeId,sdate,edate,day);
                    if(r.isSuccess()){
                        rs.add(r.getData());
                    }
                }
                }
                // 处理完毕，返回本批次的处理结果，由 SimpleJoinForkTask 负责合并全部结果，并由 rvs 变量接收
                return rs;
            });
            for(JSONObject obj:rvs){
                resultData.add(obj);
            }
        }
        return result.success(true).data(resultData);
    }




    @Override
    public Result<JSONObject> queryNodeCollectDataGraphByGraph(MonitorTplGraph graph,String nodeId,String sdate,String edate,String day) {
        Logger.info("graphName:"+graph.getName()+",nodeId:"+nodeId);
        Result<JSONObject> result=new Result<>();
        JSONObject resultData=new JSONObject();
        monitorTplGraphService.dao().fill(graph)
                .with(MonitorTplGraphMeta.GRAPH_ITEM)
                .execute();
        String tplCode=graph.getTplCode();
        JSONArray graphCols=new JSONArray();
        JSONArray graphData=new JSONArray();
        JSONArray graphSeries=new JSONArray();
        JSONArray graphPidData=new JSONArray();
        JSONArray legendData=new JSONArray();
        JSONObject tableData=new JSONObject();
        resultData.put("graphInfo",BeanUtil.toJSONObject(graph));
        if(MonitorTplGraphTypeEnum.PIE.code().equals(graph.getGraphType())){
            //饼图
            String ds=graph.getDs();
            if(ds!=null&&ds.length()>0){
                graphPidData=dao.query(ds).toJSONArrayWithJSONObject();
            }
        }else if(MonitorTplGraphTypeEnum.LINE_CALCULATION.code().equals(graph.getGraphType())){

            if(graph.getGraphItem()!=null&&graph.getGraphItem().size()>0) {
                for (MonitorTplGraphItem item : graph.getGraphItem()) {
                    String name=item.getName();
                    tableData.put("name",name);
                    String route=item.getRoute();
                    if(!"enable".equals(item.getStatus())){
                        continue;
                    }
                    String[] routeArr=route.split(",");
                    if(routeArr.length<2){
                        continue;
                    }
                    String colDef=routeArr[0];
                    String colValue=routeArr[1];
                    String colSql="select distinct "+colDef+" colname from ops_monitor_node_value where monitor_tpl_code='"+tplCode+"' and indicator_code='"+item.getIndicatorCode()+"'\n" +
                            "and result_status='sucess' and node_id=?\n" +
                            "and record_time=(select max(record_time) from ops_monitor_node_value where monitor_tpl_code='"+tplCode+"' and indicator_code='"+item.getIndicatorCode()+"' and result_status='sucess' and node_id=?)";
                    RcdSet colRs=null;
                    try {
                        colRs = dao.query(colSql, nodeId, nodeId);
                    }catch(UncategorizedSQLException e){
                        e.printStackTrace();
                        Logger.info("Sql query uncategorizedSQLException error,sql:"+colSql);
                    }catch(DataAccessException e2){
                        e2.printStackTrace();
                        Logger.info("Sql query SQLSyntaxErrorException error,sql:"+colSql);
                    }

                    if(colRs==null||colRs.size()==0){
                        continue;
                    }
                    for(Rcd r:colRs){
                        String colName=r.getString("colname");
                        legendData.add(colName);
                        String dsql="";
                        try{
                            dsql="select unix_timestamp(record_time)*1000 unix_record_time,"+colValue+" from ops_monitor_node_value where monitor_tpl_code='"+tplCode+"' and  "+colDef+"='"+colName+"' and indicator_code='"+item.getIndicatorCode()+"' and node_id='"+nodeId+"' and result_status='sucess' and "+colValue+" is not null";
                            if(sdate.length()==16){
                                dsql=dsql+" and record_time>str_to_date('"+sdate+"','%Y-%m-%d %H:%i')\n";
                            }
                            if(edate.length()==16){
                                dsql=dsql+" and record_time<str_to_date('"+edate+"','%Y-%m-%d %H:%i')\n";
                            }
                            dsql=dsql+" order by record_time";
                            JSONArray dArr=dao.query(dsql).toJSONArrayWithJSONArray();
                            JSONObject graphSeriesJson=new JSONObject();
                            graphSeriesJson.put("name",colName);
                            graphSeriesJson.put("symbol","none");
                            graphSeriesJson.put("type",MonitorTplGraphTypeEnum.LINE.code());
                            graphSeriesJson.put("data",dArr);
                            graphSeries.add(graphSeriesJson);
                        }catch(UncategorizedSQLException e){
                            e.printStackTrace();
                            Logger.info("Sql query uncategorizedSQLException error,sql:"+dsql);
                        }catch(DataAccessException e2){
                            e2.printStackTrace();
                            Logger.info("Sql query SQLSyntaxErrorException error,sql:"+dsql);
                        }
                    }
                }
            }

        }else if(MonitorTplGraphTypeEnum.TABLE.code().equals(graph.getGraphType())){
            if(graph.getGraphItem()!=null&&graph.getGraphItem().size()>0){
                for(MonitorTplGraphItem item:graph.getGraphItem()){
                    String name=item.getName();
                    String route=item.getRoute();
                    tableData.put("name",name);
                    if(!"enable".equals(item.getStatus())){
                        continue;
                    }
                    String tabMetaSql="select value_column_name from ops_monitor_tpl_indicator where deleted=0 and code=? and monitor_tpl_code=? limit 1";
                    Rcd tabMetaRs=dao.queryRecord(tabMetaSql,item.getIndicatorCode(),graph.getTplCode());
                    if(tabMetaRs==null){
                        continue;
                    }
                    String header=tabMetaRs.getString("value_column_name");
                    String[] headerArr=header.split(",");
                    String[] routeArr=route.split(",");
                    if( !(headerArr.length==routeArr.length&&headerArr.length>0) ){
                        tableData.put("header",new JSONArray());
                        tableData.put("route",new JSONArray());
                        continue;
                    }
                    JSONArray headerArray=new JSONArray();
                    JSONArray routeArray=new JSONArray();
                    for(int i=0;i<headerArr.length;i++){
                        headerArray.add(headerArr[i]);
                        routeArray.add(this.lineToHump(routeArr[i]));
                    }
                    headerArray.add("记录时间");
                    routeArray.add("recordTime");
                    tableData.put("header",headerArray);
                    tableData.put("route",routeArray);
                    String tabSql="";
                    try{
                        tabSql="select "+route+",record_time from ops_monitor_node_value where monitor_tpl_code='"+tplCode+"' and indicator_code='"+item.getIndicatorCode()+"' \n" +
                                "and result_status='sucess' and node_id=?\n" +
                                "and record_time=(select max(record_time) from ops_monitor_node_value where monitor_tpl_code='"+tplCode+"' and indicator_code='"+item.getIndicatorCode()+"' and result_status='sucess' and node_id=?)";
                        RcdSet tabRs=dao.query(tabSql,nodeId,nodeId);
                        tableData.put("data",tabRs.toJSONArrayWithJSONObject());
                    }catch(UncategorizedSQLException e){
                        e.printStackTrace();
                        Logger.info("Sql query uncategorizedSQLException error,sql:"+tabSql);
                    }catch(DataAccessException e2){
                        e2.printStackTrace();
                        Logger.info("Sql query SQLSyntaxErrorException error,sql:"+tabSql);
                    }
                }
            }

        }else if(MonitorTplGraphTypeEnum.LINE.code().equals(graph.getGraphType())){
            //线形图
            if(graph.getGraphItem()!=null&&graph.getGraphItem().size()>0){
                for(MonitorTplGraphItem item:graph.getGraphItem()){
                    String route=item.getRoute();
                    String name=item.getName();
                    if("enable".equals(item.getStatus())){
                        String dsql="";
                        try{
                            dsql="select unix_timestamp(record_time)*1000 unix_record_time,"+route+" from ops_monitor_node_value where  monitor_tpl_code='"+tplCode+"' and indicator_code='"+item.getIndicatorCode()+"' and node_id='"+nodeId+"' and result_status='sucess' ";
                            if(sdate.length()==16){
                                dsql=dsql+" and record_time>str_to_date('"+sdate+"','%Y-%m-%d %H:%i')\n";
                            }
                            if(edate.length()==16){
                                dsql=dsql+" and record_time<str_to_date('"+edate+"','%Y-%m-%d %H:%i')\n";
                            }
                            dsql=dsql+" order by record_time";
                            JSONArray dArr=dao.query(dsql).toJSONArrayWithJSONArray();
                            JSONObject graphSeriesJson=new JSONObject();
                            graphSeriesJson.put("name",name);
                            graphSeriesJson.put("symbol","none");
                            graphSeriesJson.put("type",MonitorTplGraphTypeEnum.LINE.code());
                            graphSeriesJson.put("data",dArr);
                            graphSeries.add(graphSeriesJson);
                            legendData.add(name);
                        }catch(UncategorizedSQLException e){
                            e.printStackTrace();
                            Logger.info("Sql query uncategorizedSQLException error,sql:"+dsql);
                        }catch(DataAccessException e2){
                            e2.printStackTrace();
                            Logger.info("Sql query SQLSyntaxErrorException error,sql:"+dsql);
                        }
                    }
                }
            }
        }
        resultData.put("graphCols",graphCols);
        resultData.put("graphData",graphData);
        resultData.put("seriesData",graphSeries);
        resultData.put("legendData",legendData);
        resultData.put("graphPidData",graphPidData);
        resultData.put("tableData",tableData);
        return result.success(true).data(resultData);
    }



    @Override
    public Result<JSONObject> queryNodeCollectData(String nodeId) {

        Result<JSONObject> result=new Result<>();
        JSONObject resultData=new JSONObject();
        MonitorNode monitorNode=monitorNodeService.getById(nodeId);

        // join 关联的对象
        monitorNodeService.dao().fill(monitorNode)
                .with(MonitorNodeMeta.MONITOR_TPL_LIST)
                .with(MonitorNodeMeta.SSH_VOUCHER)
                .with(MonitorNodeMeta.MONITOR_NODE_GROUP)
                .with(MonitorNodeMeta.MONITOR_NODE_TYPE)
                .execute();

        JSONArray nodeCollectData=new JSONArray();
        List<MonitorTpl> nodeTplList=monitorNode.getMonitorTplList();
        if(nodeTplList!=null&&nodeTplList.size()>0)
        for(MonitorTpl tpl:nodeTplList){
            String tplCode=tpl.getCode();
            String dataSql="select \n" +
                    "(select node_ip from ops_monitor_node where id=a2.node_id)node_ip,\n" +
                    "(select node_name_show from ops_monitor_node where id=a2.node_id)node_name_show,\n" +
                    "a1.* ,a2.* from " +
                   "(select * from ops_monitor_tpl_indicator where monitor_tpl_code='"+tplCode+"' and status='enable'\n" +
                   ") a1 left join \n" +
                   "(\n" +
                   "select * from ops_monitor_node_value_last where node_id='"+nodeId+"' and (indicator_code,record_time) \n" +
                   "in(\n" +
                   "select indicator_code,max(record_time) max_record_time from (select * from ops_monitor_node_value_last where node_id='"+nodeId+"' and result_status='sucess' and monitor_tpl_code='"+tplCode+"') t group by node_id,indicator_code\n" +
                   "))a2 on a1.monitor_tpl_code=a2.monitor_tpl_code and a1.code=a2.indicator_code order by a1.monitor_tpl_code, a1.code\n";
           RcdSet rs=dao.query(dataSql);
           for(Rcd r:rs){
               JSONObject data=parseCollectData(r.toJSONObject());
               nodeCollectData.add(data);
           }
        }

        resultData.put("nodeCollectDataList",nodeCollectData);
        resultData.put("nodeInfo",BeanUtil.toJSONObject(monitorNode));
        return result.success(true).data(resultData);

    }


    @Override
    public Result<JSONObject> queryNodeHostTopData(List<String> topList,int top,int day) {
        Result<JSONObject> result=new Result<>();
        JSONObject resultData=new JSONObject();
        if(topList!=null&&topList.size()>0){
            HashMap<String,JSONArray> map=new HashMap<>();
            // 创建 ForkJoin 工具，其中 输入一个 Integer 元素的 List ，输出 Long 元素的 List ，每个线程处理 若干元素 ，此处为 5 个
            //并行处理数据  List<MonitorNode> nodeList=queryExecuteNodeList();
            SimpleJoinForkTask<String,HashMap<String,JSONArray>> task=new SimpleJoinForkTask<>(topList,1);
            // 并行执行
            List<HashMap<String,JSONArray>> rvs=task.execute(els->{
                // 打印当前线程信息
                Logger.info("Thread name:"+Thread.currentThread().getName());
                // 处理当前分到的 若干元素，此处为 5 个
                List<HashMap<String,JSONArray>> rs=new ArrayList<>();
                for (String topValue : els) {
                    if(MonitorTopDataEnum.OS_CPU_USED.code().equals(topValue)){
                        map.put("osCpuUsed",this.queryNodeHostTopDataOsCpuUsed(top,day));
                    }else if(MonitorTopDataEnum.OS_FS_USED.code().equals(topValue)){
                        map.put("osFs",this.queryNodeHostTopDataOsFsUsed(top,day));
                    }else if(MonitorTopDataEnum.OS_FS_INODE_USED.code().equals(topValue)){
                        map.put("osFsInodeUsed",this.queryNodeHostTopDataOsFsInodeUsed(top,day));
                    }else if(MonitorTopDataEnum.OS_LOAD.code().equals(topValue)){
                        map.put("osLoad",this.queryNodeHostTopDataOsLoad(top,day));
                    }else if(MonitorTopDataEnum.OS_P_MEMORY_USED.code().equals(topValue)){
                        map.put("osPMemoryUsed",this.queryNodeHostTopDataOsMemoryUsed(top,day));
                    }else if(MonitorTopDataEnum.OS_V_MEMORY_USED.code().equals(topValue)){
                        map.put("osVMemoryUsed",this.queryNodeHostTopDataOsVmemoryUsed(top,day));
                    }else if(MonitorTopDataEnum.OS_NET_FLOW_UP.code().equals(topValue)){
                        map.put("osNetFlowUp",this.queryNodeHostTopDataOsNetFlowUp(top,day));
                    }else if(MonitorTopDataEnum.OS_NET_FLOW_DOWN.code().equals(topValue)){
                        map.put("osNetFlowDown",this.queryNodeHostTopDataOsNetFlowDown(top,day));
                    }
                    rs.add(map);
                }
                // 处理完毕，返回本批次的处理结果，由 SimpleJoinForkTask 负责合并全部结果，并由 rvs 变量接收
                return rs;
            });

            for(HashMap<String,JSONArray> mapValue:rvs){
                Iterator<Map.Entry<String, JSONArray>> it = mapValue.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, JSONArray> entry = it.next();
                    resultData.put(entry.getKey(),entry.getValue());

                }
            }
        }

        return result.success(true).data(resultData);
    }

    private JSONArray queryNodeHostTopDataOsFsUsed(int top,int day){
        String sql="select * from (       \n" +
                "select b.node_ip,b.node_name_show,a.list_value_str1 fs_name,list_value_number1 pct from ops_monitor_node_value_last a,ops_monitor_node b\n" +
                "where a.node_id=b.id \n" +
                "and b.type='os' \n" +
                "and b.node_enabled='enable' \n" +
               // "and b.status='online' \n" +
                "and (node_id,indicator_code,list_value_str1,record_time) \n" +
                "in (\n" +
                "select node_id,indicator_code,list_value_str1,max(record_time) max_record_time from (select * from ops_monitor_node_value_last where indicator_code='os.fs' and result_status='sucess') t group by node_id,indicator_code,list_value_str1\n" +
                ")\n" +
                "order by a.list_value_number1 desc) end limit "+top;
        return dao.query(sql).toJSONArrayWithJSONObject();
    }
    private JSONArray queryNodeHostTopDataOsFsInodeUsed(int top,int day){
        String sql="";
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsNetFlowUp(int top,int day){
        String sql="select * from (       \n" +
                "select b.node_ip,b.node_name_show,a.list_value_str1 net_inter,a.list_value_number1 up_flow from ops_monitor_node_value_last a,ops_monitor_node b\n" +
                "where a.node_id=b.id \n" +
                "and b.type='os' \n" +
                "and b.node_enabled='enable' \n" +
             //  "and b.status='online' \n" +
                "and (node_id,indicator_code,list_value_str1,record_time) \n" +
                "in (select node_id,indicator_code,list_value_str1,max(record_time) max_record_time from (select * from ops_monitor_node_value_last where indicator_code='os.net_interface_flow' and result_status='sucess') t group by node_id,indicator_code,list_value_str1)\n" +
                "order by a.list_value_number1 desc) end limit "+top;
        return dao.query(sql).toJSONArrayWithJSONObject();
    }
    private JSONArray queryNodeHostTopDataOsNetFlowDown(int top,int day){
        String sql="select * from (       \n" +
                "select b.node_ip,b.node_name_show,a.list_value_str1 net_inter,a.list_value_number2 down_flow from ops_monitor_node_value_last a,ops_monitor_node b\n" +
                "where a.node_id=b.id \n" +
                "and b.type='os' \n" +
                "and b.node_enabled='enable' \n" +
             //   "and b.status='online' \n" +
                "and (node_id,indicator_code,list_value_str1,record_time) \n" +
                "in (select node_id,indicator_code,list_value_str1,max(record_time) max_record_time from (select * from ops_monitor_node_value_last where indicator_code='os.net_interface_flow' and result_status='sucess') t group by node_id,indicator_code,list_value_str1)\n" +
                "order by a.list_value_number2 desc) end limit "+top;
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsCpuUsed(int top,int day){
        String sql="select * from (       \n" +
                "select b.node_ip,b.node_name_show,100-a.cpu_idle cpu_used from ops_monitor_node_value_last a,ops_monitor_node b\n" +
                "where a.node_id=b.id \n" +
                "and b.type='os' \n" +
                "and b.node_enabled='enable' \n" +
              //  "and b.status='online' \n" +
                "and (node_id,indicator_code,record_time) \n" +
                "in (select node_id,indicator_code,max(record_time) max_record_time from (select * from ops_monitor_node_value_last where indicator_code='os.cpu' and result_status='sucess') t group by node_id,indicator_code)\n" +
                "and cpu_idle is not null order by cpu_used desc) end limit "+top;
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsLoad(int top,int day){
        String sql="select * from (       \n" +
                "select b.node_ip,b.node_name_show,a.os_load from ops_monitor_node_value_last a,ops_monitor_node b\n" +
                "where a.node_id=b.id \n" +
                "and b.type='os' \n" +
                "and b.node_enabled='enable' \n" +
             //   "and b.status='online' \n" +
                "and (node_id,indicator_code,record_time) \n" +
                "in (select node_id,indicator_code,max(record_time) max_record_time from (select * from ops_monitor_node_value_last where indicator_code='os.load' and result_status='sucess') t group by node_id,indicator_code)\n" +
                "order by os_load desc) end limit "+top;
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsMemoryUsed(int top,int day){
        String sql="select * from (       \n" +
                "select b.node_ip,b.node_name_show,a.p_memory_used from ops_monitor_node_value_last a,ops_monitor_node b\n" +
                "where a.node_id=b.id \n" +
                "and b.type='os' \n" +
                "and b.node_enabled='enable' \n" +
           //     "and b.status='online' \n" +
                "and (node_id,indicator_code,record_time) \n" +
                "in (select node_id,indicator_code,max(record_time) max_record_time from (select * from ops_monitor_node_value_last where indicator_code='os.memory_used' and result_status='sucess') t group by node_id,indicator_code)\n" +
                "order by p_memory_used desc)end limit "+top;
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

    private JSONArray queryNodeHostTopDataOsVmemoryUsed(int top,int day){
        String sql="";
        return dao.query(sql).toJSONArrayWithJSONObject();
    }

}
