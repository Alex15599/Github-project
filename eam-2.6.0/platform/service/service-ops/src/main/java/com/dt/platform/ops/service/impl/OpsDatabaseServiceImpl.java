package com.dt.platform.ops.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.ops.OpsDbBackupResultEnum;
import com.dt.platform.domain.ops.DbBackupInfo;
import com.dt.platform.domain.ops.DbBackupRecord;
import com.dt.platform.domain.ops.DbInfo;
import com.dt.platform.ops.service.IDbBackupInfoService;
import com.dt.platform.ops.service.IDbBackupRecordService;
import com.dt.platform.ops.service.IOpsDatabaseService;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.RcdSet;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 主机 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:06:43
*/


@Service("OpsDatabaseService")
public class OpsDatabaseServiceImpl extends SuperService<DbInfo> implements IOpsDatabaseService {
	
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;

	@Autowired
	private IDbBackupRecordService dbBackupRecordService;


	@Autowired
	private IDbBackupInfoService dbBackupInfoService;

	/**
	 * 获得 DAO 对象
	 * */
	public DAO dao() { return dao; }

/**
	 * 批量检查引用
	 * @param ids  检查这些ID是否又被外部表引用
	 * */
	@Override
	public <T> Map<T, ReferCause> hasRefers(List<T> ids) {
		// 默认无业务逻辑，返回此行；有业务逻辑需要校验时，请修改并使用已注释的行代码！！！
		return MapUtil.asMap(ids,new ReferCause(false));
		// return super.hasRefers(FoxnicWeb.BPM_PROCESS_INSTANCE.FORM_DEFINITION_ID,ids);
	}


	//数据相关
	public static String DB_SOFTWARE_COUNT="db_software_count";
	public static String DB_SOFTWARE_TYPE="db_software_type";
	public static String DB_SOFTWARE_INFO="db_software_info";
	public static String DB_COUNT="db_count";
	public static String DB_TYPE="db_type";
	public static String DB_SIZE="db_size";
	//备份相关
	public static String DB_BACKUP_TASK_SETTING_NONE_COUNT="backup_task_setting_none_count";
	public static String DB_BACKUP_COUNT="backup_count";
	public static String DB_BACKUP_TASK_COUNT="task_count";
	public static String DB_BACKUP_RESULT_DIST="backup_result_dist";
	public static String DB_BACKUP_COUNT_TREND="backup_count_trend";
	public static String DB_BACKUP_FAILED_COUNT_TREND="backup_failed_count_trend";
	public static String DB_BACKUP_TIME_TOP="db_backup_time_top";
	public static String DB_BACKUP_INFO_DETAIL_LIST="db_backup_info_detail_list";
	public static String DB_BACKUP_INFO_TODAY="db_backup_info_today";


	/*数据库类型定义数据*/
	public String dbDefineInfoSql="select aa.id service_info_id2,aa.name service_name,bb.name category_name,bb.code category_code ,cc.name group_name,cc.code group_code from ops_service_info aa\n" +
			"left join ops_service_category bb\n" +
			"on aa.service_category_id=bb.id\n" +
			"left join ops_service_group cc\n" +
			"on aa.group_id= cc.code \n" +
			"where aa.group_id='db'";

	/*数据库软件基本数据*/
	public String softwareDbBaseInfoSql="select \n" +
			"(select count(1) from ops_db_info info where info.deleted=0 and info.host_id=a.id) db_info_count,\n"+
			"a.*,b.service_info_id from ops_host a,ops_host_db b\n" +
			"where a.deleted=0 and a.status=1 and a.environment='prod'\n" +
			"and a.id=b.host_id \n" +
			"and b.service_info_id is not null\n" +
			"and b.service_info_id <>'' \n"+
			"and b.deleted=0\n" +
			"and a.arch='0'\n" +
			"and a.id not in (select host_id from ops_host_ex_by_db where deleted=0)";

	/*数据库软件基本数据明细*/
	public String softwareDbBaseInfoDetailSql="select * from ("+softwareDbBaseInfoSql +") T1\n" +
			"left join \n" +
			"( "+dbDefineInfoSql+ ") T2 \n" +
			"on T1.service_info_id=T2.service_info_id2\n";

	/*数据库基本数据*/
	public String dbBaseInfoSql="select b.*,a.host_ip,a.host_name,b.type_id service_info_id from ops_host a,ops_db_info b\n" +
			"where b.status='online' and b.deleted=0 \n" +
			"and a.deleted=0 and a.status=1 and a.environment='prod'\n" +
			"and a.arch='0'\n" +
			"and a.id not in (select host_id from ops_host_ex_by_db where deleted=0)\n" +
			"and a.id=b.host_id";

	/*数据库基本数据明细*/
	public String dbBaseInfoDetailSql="select * from ("+dbBaseInfoSql+") T1\n" +
			"left join \n" +
			"("+dbDefineInfoSql+") T2 \n" +
			"on T1.service_info_id=T2.service_info_id2\n";


	/*数据库备份节点基本数据*/
	public String dbBackupInfoSql="select a.*,b.host_ip,b.host_name from ops_db_info a,ops_host b \n" +
			"where a.host_id=b.id\n" +
			"and b.deleted=0 and b.status='1' and b.environment='prod'\n" +
			"and a.deleted=0\n" +
			"and a.status='online'\n" +
			"and b.id not in (select host_id from ops_host_ex_by_db where deleted=0)\n" +
			"and backup_status='backup'";


	/*数据库备份节点基本数据明细*/
	public String dbBackupInfoDetailSql="select T2.*,T1.backup_result from \n" +
			"(\n" +
			"select * from ops_db_backup_info where status='online' and deleted=0\n" +
			")T1,\n" +
			"("+dbBackupInfoSql+")T2\n" +
			"where T1.database_id=T2.id\n";

	/*数据库最近备份情况*/
	public String dbBackupInfoDetailListSql="select * from (\n" +
			"select a.id db_info_id,b.host_name,b.host_ip,a.name db_info_name,a.status db_status,backup_status db_backup_status \n" +
			"from ops_db_info a,ops_host b\n" +
			"where a.backup_status='backup' and a.host_id=b.id and a.deleted=0 and b.deleted=0\n" +
			"and a.status='online'\n" +
			")aa\n" +
			"left join(\n" +
			"select * from ops_db_backup_record c where (db_id,backup_stime) in ((select db_id,max(backup_stime) max_backup_stime from ops_db_backup_record where backup_stime> subdate(now(),30) and deleted=0 group by db_id))\n" +
			")cc\n" +
			"on aa.db_info_id=cc.db_id order by backup_stime";


	/*当前实现以dbBkId识别为主*/
	@Override
	public Result recordDatabaseBackup(DbBackupRecord dbBackupRecord) {

		//如果设置的dbId，dbId优先匹配
		if(!StringUtil.isBlank(dbBackupRecord.getDbId())){
			Rcd dbRs=dao.queryRecord("select * from ops_db_info where id=?",dbBackupRecord.getDbId());
			if(dbRs==null){
				return ErrorDesc.failureMessage("数据库条目未匹配,请设置正确的dbId值");
			}
		}else{
			String dbBkId=dbBackupRecord.getDbBkId();
			if(StringUtil.isBlank(dbBkId)){
				return ErrorDesc.failureMessage("数据库备份条目未匹配,请设置正确的dbBkId值");
			}

			Rcd dbBackupRs=dao.queryRecord("select * from ops_db_backup_info where id=?",dbBkId);
			if(dbBackupRs==null){
				return ErrorDesc.failureMessage("数据库备份条目未匹配,请设置正确的dbBkId值");
			}
			dbBackupRecord.setDbId(dbBackupRs.getString("database_id"));
		}
		if(StringUtil.isBlank(dbBackupRecord.getDbId())){
			return ErrorDesc.failureMessage("数据库条目未匹配,请设置正确的dbId值");
		}
		Result r=dbBackupRecordService.insert(dbBackupRecord,false);
		if(r.isSuccess()){
			Logger.info("recored backup succcess,dbId:"+dbBackupRecord.getDbId());
			//则同步更新数据
			if(!StringUtil.isBlank(dbBackupRecord.getDbBkId())){
				DbBackupRecord dbBackupRecordSave=dbBackupRecordService.getById(dbBackupRecord.getId());
				DbBackupInfo dbBackupInfo=new DbBackupInfo();
				dbBackupInfo.setId(dbBackupRecordSave.getDbBkId());
				dbBackupInfo.setBackupSize(dbBackupRecordSave.getBackupSize());
				dbBackupInfo.setBackupTime(dbBackupRecordSave.getBackupStime());
				dbBackupInfo.setBackupResult(dbBackupRecordSave.getBackupResult());
				dbBackupInfo.setBackupResultCt(dbBackupRecordSave.getBackupResultCt());
				dbBackupInfo.setBackupSource(dbBackupRecordSave.getBackupSource());
				dbBackupInfoService.update(dbBackupInfo,SaveMode.NOT_NULL_FIELDS);
			}
		}
		return ErrorDesc.success();
	}


	@Override
	public Result<JSONObject> queryDatabaseData(String codes) {
		Logger.info("process codes:"+codes);
		JSONObject result=new JSONObject();
		String[] codeArr=codes.split(",");
		for(int i=0;i<codeArr.length;i++){
			Logger.info("process data:"+codeArr[i]);
			result.put(codeArr[i],queryDatabaseDataByCode(codeArr[i]));
		}
		Logger.info("result:\n"+result);
		Result<JSONObject> r=new Result<>();
		r.data(result);
		r.success();
		return r;
	}


	private JSONObject queryDatabaseDataByCode(String code) {

		JSONObject result=new JSONObject();
		if(DB_SOFTWARE_COUNT.equals(code)){
			result=queryDatabaseDataByDbSoftwareCount();
		}else if(DB_SOFTWARE_TYPE.equals(code)) {
			JSONArray typeData=queryDatabaseDataByDbSoftwareType();
			result.put("data",typeData);
			JSONArray labelList=new JSONArray();
			JSONArray dataList=new JSONArray();
			JSONArray pieData=new JSONArray();
			for(int i=0;i<typeData.size();i++){
				JSONObject pie=new JSONObject();
				pie.put("name",typeData.getJSONObject(i).getString("categoryName"));
				pie.put("value",typeData.getJSONObject(i).getInteger("cnt"));
				pieData.add(pie);
				labelList.add(typeData.getJSONObject(i).getString("categoryName"));
				dataList.add(typeData.getJSONObject(i).getInteger("cnt"));
			}
			result.put("labelList",labelList);
			result.put("dataList",dataList);
			result.put("pieData",pieData);

		}else if(DB_COUNT.equals(code)) {
			result=queryDatabaseDataByDbCount();
		}else if(DB_SOFTWARE_INFO.equals(code)) {
			JSONArray data=queryDbSoftwareInfo();
			result.put("data",data);
		}else if(DB_TYPE.equals(code)) {
			JSONArray typeData=queryDatabaseDataByDbType();
			result.put("data",typeData);
			JSONArray labelList=new JSONArray();
			JSONArray dataList=new JSONArray();
			JSONArray pieData=new JSONArray();
			for(int i=0;i<typeData.size();i++){
				JSONObject pie=new JSONObject();
				pie.put("name",typeData.getJSONObject(i).getString("categoryName"));
				pie.put("value",typeData.getJSONObject(i).getInteger("cnt"));
				pieData.add(pie);
				labelList.add(typeData.getJSONObject(i).getString("categoryName"));
				dataList.add(typeData.getJSONObject(i).getInteger("cnt"));
			}
			result.put("labelList",labelList);
			result.put("dataList",dataList);
			result.put("pieData",pieData);
		}else if(DB_SIZE.equals(code)) {
			JSONArray data=queryDatabaseSize("0");
			result.put("data",data);
			JSONArray labelList=new JSONArray();
			JSONArray dataList=new JSONArray();
			for(int i=0;i<data.size();i++){
				String dbName=data.getJSONObject(i).getString("name");
				String serviceName=data.getJSONObject(i).getString("serviceName");
				String ip=data.getJSONObject(i).getString("hostIp");
				String ct=serviceName+"_"+dbName+"_"+ip;
				labelList.add(ct);
				dataList.add(data.getJSONObject(i).getInteger("dbSize"));
			}
			result.put("labelList",labelList);
			result.put("dataList",dataList);
		}else if(DB_BACKUP_TASK_COUNT.equals(code)) {
			result=queryDbBackupTaskCount();
		}else if(DB_BACKUP_COUNT.equals(code)) {
			result=queryDbBackupCount();
		}else if(DB_BACKUP_RESULT_DIST.equals(code)) {
			JSONArray data=queryDbBackupResultDist();
			result.put("data",data);
			JSONArray labelList=new JSONArray();
			JSONArray dataList=new JSONArray();
			JSONArray pieData=new JSONArray();
			for(int i=0;i<data.size();i++){
				JSONObject pie=new JSONObject();
				String name=data.getJSONObject(i).getString("name");
				if(StringUtil.isBlank(name)){
					name="未设置";
				}
				if(OpsDbBackupResultEnum.FAILED.code().equals(name)){
					name=OpsDbBackupResultEnum.FAILED.text();
				}else if(OpsDbBackupResultEnum.SUCCESS.code().equals(name)){
					name=OpsDbBackupResultEnum.SUCCESS.text();
				}else if(OpsDbBackupResultEnum.UNKNOW.code().equals(name)){
					name=OpsDbBackupResultEnum.UNKNOW.text();
				}else if(OpsDbBackupResultEnum.NOT_START.code().equals(name)){
					name=OpsDbBackupResultEnum.NOT_START.text();
				}
				pie.put("name",name);
				pie.put("value",data.getJSONObject(i).getInteger("cnt"));
				pieData.add(pie);

				labelList.add(name);
				dataList.add(data.getJSONObject(i).getInteger("cnt"));
			}
			result.put("labelList",labelList);
			result.put("dataList",dataList);
			result.put("pieData",pieData);
		}else if(DB_BACKUP_COUNT_TREND.equals(code)) {
			JSONArray data=queryDbBackupCountTrend();
			result.put("data",data);
			JSONArray labelList=new JSONArray();
			JSONArray dataList=new JSONArray();
			for(int i=0;i<data.size();i++){
				String name=data.getJSONObject(i).getString("stime");
				labelList.add(name);
				dataList.add(data.getJSONObject(i).getInteger("cnt"));
			}
			result.put("labelList",labelList);
			result.put("dataList",dataList);
		}else if(DB_BACKUP_FAILED_COUNT_TREND.equals(code)) {
			JSONArray data=queryDbBackupFailedCountTrend();
			result.put("data",data);
			JSONArray labelList=new JSONArray();
			JSONArray dataList=new JSONArray();
			for(int i=0;i<data.size();i++){
				String name=data.getJSONObject(i).getString("stime");
				labelList.add(name);
				dataList.add(data.getJSONObject(i).getInteger("cnt"));
			}
			result.put("labelList",labelList);
			result.put("dataList",dataList);

		}else if(DB_BACKUP_TASK_SETTING_NONE_COUNT.equals(code)){
			result=queryDbBackupTaskSettingNoneCount();
		}else if(DB_BACKUP_TIME_TOP.equals(code)){
			JSONArray data=queryDbBackupTimeTop();
			result.put("data",data);
			JSONArray labelList=new JSONArray();
			JSONArray dataList=new JSONArray();
			for(int i=0;i<data.size();i++){
				String defDbName=data.getJSONObject(i).getString("defDbName");
				String hostName=data.getJSONObject(i).getString("hostName");
				String ip=data.getJSONObject(i).getString("hostIp");
				String ct=hostName+"_"+defDbName+"_"+ip;
				labelList.add(ct);
				dataList.add(data.getJSONObject(i).getInteger("diffMinute"));
			}
			result.put("labelList",labelList);
			result.put("dataList",dataList);
		}else if(DB_BACKUP_INFO_DETAIL_LIST.equals(code)){
			JSONArray data=queryDbBackupInfoDetailList();
			result.put("data",data);
		}else if(DB_BACKUP_INFO_TODAY.equals(code)){
			JSONObject data=dbBackupInfoToday();
			result.put("data",data);
		}
		return result;
	}

	private JSONObject dbBackupInfoToday(){

		String sql="select ifnull(backup_result,'none')backup_result,count(1) cnt from (\n" +
				"" +dbBackupInfoDetailListSql+") end where 1=1 \n" +
				"and end.backup_result='success' and  end.backup_stime>DATE_FORMAT(CURDATE(),'%Y-%m-%d %H:%i:%s')\n" +
				"group by backup_result";
		RcdSet rs=dao.query(sql);
		JSONObject res=new JSONObject();
		int successCnt=0;
		int failedCnt=0;
		int noneCnt=0;
		String backupDataSiz="0";
		for(int i=0;i<rs.size();i++){
			if("success".equals(rs.getRcd(i).getString("backup_result"))){
				successCnt=rs.getRcd(i).getInteger("cnt");
			}else if("failed".equals(rs.getRcd(i).getString("backup_result"))){
				failedCnt=rs.getRcd(i).getInteger("cnt");
			}else if("none".equals(rs.getRcd(i).getString("backup_result"))){
				noneCnt=rs.getRcd(i).getInteger("cnt");
			}
		}

		res.put("backupSuccessCount",successCnt);
		res.put("backupFailedCount",failedCnt);
		res.put("backupNoneCount",noneCnt);
		res.put("backupDataSize",backupDataSiz);
		return res;
	}


	//**
	private JSONArray queryDbBackupInfoDetailList(){
		return dao.query(dbBackupInfoDetailListSql).toJSONArrayWithJSONObject();
	}

	private JSONObject queryDbBackupTaskSettingNoneCount(){
		String sql=dbBackupInfoSql+ " and a.id not in (select database_id from ops_db_backup_info where deleted=0)";
		String sql1="select count(1) cnt from ("+sql+") tab";
		JSONObject res=new JSONObject();
		res.put("count",dao.queryRecord(sql1).getInteger("cnt"));
		return res;
	}

	private JSONArray queryDbBackupTimeTop(){
		String sql="\n" +
				"select * from (\n" +
				"select * from (\n" +
				"select a.*,\n" +
				"b.host_name,b.host_ip,b.db_name def_db_name,\n" +
				"TIMESTAMPDIFF(minute,a.backup_stime,a.backup_etime) diff_minute from ops_db_backup_record a,\n" +
				"(select dd.id database_id, cc.host_name,cc.host_ip,dd.name db_name from ops_host cc,ops_db_info dd where cc.id=dd.host_id)b\n" +
				"where a.backup_result='success' \n" +
				"and a.backup_stime is not null \n" +
				"and a.backup_etime is not null \n" +
				"and a.deleted=0\n" +
				"and b.database_id=a.db_id\n" +
				"and a.backup_stime>STR_TO_DATE(date_format(now()-10000000,'%Y-%m-%d'),'%Y-%m-%d') \n" +
				")tab order by diff_minute desc \n" +
				")endTable limit 50";

		return dao.query(sql).toJSONArrayWithJSONObject();
	}
	/*
	 */
	private JSONArray queryDbBackupCountTrend(){
		int day=60;
		String subSql=buildDateSql(day);
		String sql="select stime,sum(cnt) cnt from ( "+subSql+" union all\n" +
				"select date_format(backup_stime,'%Y-%m-%d') stime,count(1) cnt from ops_db_backup_record where deleted=0 and backup_stime> subdate(now(),"+day+") \n" +
				"group by date_format(backup_stime,'%Y-%m-%d')  \n" +
				") t group by stime order by 1 desc";
		return dao.query(sql).toJSONArrayWithJSONObject();
	}

	private JSONArray queryDbBackupFailedCountTrend(){
		int day=60;
		String subSql=buildDateSql(day);
		String sql="select stime,sum(cnt) cnt from ( "+subSql+" union all\n" +
				"select date_format(backup_stime,'%Y-%m-%d') stime,count(1) cnt from ops_db_backup_record where backup_result<>'success' and deleted=0 and backup_stime> subdate(now(),"+day+") \n" +
				"group by date_format(backup_stime,'%Y-%m-%d')  \n" +
				") t group by stime order by 1 desc";
		return dao.query(sql).toJSONArrayWithJSONObject();
	}
	private String buildDateSql(int day){
		String sql="";
		if(day<1){
			day=1;
		}
		for(int i=0;i<day;i++){
			if(i==0){
				sql=" select date_format(subdate(now(),"+i+"),'%Y-%m-%d')stime,0 cnt ";
			}else{
				sql=sql+" union all \n select date_format(subdate(now(),"+i+"),'%Y-%m-%d')stime,0 cnt ";
			}
		}
		return sql;
	}

	/*
	 */
	private JSONObject queryDbBackupTaskCount(){
		String sql1="select count(1) cnt from ("+dbBackupInfoDetailSql+") tab";
		JSONObject res=new JSONObject();
		res.put("count",dao.queryRecord(sql1).getInteger("cnt"));
		return res;
	}

	/*
	 */
	private JSONObject queryDbBackupCount(){
		String sql1="select count(1) cnt from ("+dbBackupInfoSql+") tab";
		JSONObject res=new JSONObject();
		res.put("count",dao.queryRecord(sql1).getInteger("cnt"));
		return res;
	}

	private JSONArray queryDbBackupResultDist(){
		String sql1="select backup_result name,count(1) cnt from ("+dbBackupInfoDetailSql+") tab\n" +
				"group by backup_result order by 2 desc\n";
		return dao.query(sql1).toJSONArrayWithJSONObject();
	}


	/*
	 * 数据库软件，
	 * 统计主机在线，生产环境并且非归档
	 */
	private JSONArray queryDbSoftwareInfo(){
		String sql="select * from ("+softwareDbBaseInfoDetailSql+") tab order by host_ip";
		return dao.query(sql).toJSONArrayWithJSONObject();
	}


	/*
	 * 数据库软件数量，
	 * 统计主机在线，生产环境并且非归档
	 */
	private JSONObject queryDatabaseDataByDbSoftwareCount (){
		String sql1="select count(1) cnt from ("+softwareDbBaseInfoSql+") tab";
		JSONObject res=new JSONObject();
		res.put("count",dao.queryRecord(sql1).getInteger("cnt"));
		return res;
	}

	/*
	 * 数据库大小数量，
	 * 统计主机在线，生产环境并且非归档
	 */
	private JSONArray queryDatabaseSize(String size) {
		String sql2="select * from (\n" +
				"select * from ("+dbBaseInfoSql+") T1\n" +
				"left join \n" +
				"("+dbDefineInfoSql+") T2 \n" +
				"on T1.service_info_id=T2.service_info_id2 order by db_size desc)endtable limit 50\n";
		return dao.query(sql2).toJSONArrayWithJSONObject();
	}

	/*
	 * 数据库软件分类信息
	 * 统计主机在线，生产环境并且非归档
	 */
	private JSONArray queryDatabaseDataByDbSoftwareType(){
		String sql2="select category_code,category_name,count(1) cnt from ("+softwareDbBaseInfoDetailSql+") t5 group by category_code,category_name order by 3 desc";
		return dao.query(sql2).toJSONArrayWithJSONObject();
	}

	/*
	 * 数据软件数量
	 * 统计主机在线，生产环境并且非归档
	 */
	private JSONObject queryDatabaseDataByDbCount(){
		String sql1="select count(1) cnt from ("+dbBaseInfoSql+") tab";
		JSONObject res=new JSONObject();
		res.put("count",dao.queryRecord(sql1).getInteger("cnt"));
		return res;
	}

	/*
	 * 数据库软件分类信息
	 * 统计主机在线，生产环境并且非归档
	 */
	private JSONArray queryDatabaseDataByDbType(){
		String sql2="select category_code,category_name,count(1) cnt from ("+dbBaseInfoDetailSql+") t5 group by category_code,category_name order by 3 desc";
		return dao.query(sql2).toJSONArrayWithJSONObject();
	}


}