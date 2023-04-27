package com.dt.platform.ops.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.ops.HostMonitorStatusEnum;
import com.dt.platform.constants.enums.ops.HostStatusEnum;
import com.dt.platform.constants.enums.ops.OpsHostDataExportColumnEnum;
import com.dt.platform.constants.enums.ops.OpsISDataExportColumnEnum;
import com.dt.platform.domain.ops.*;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.dt.platform.domain.ops.meta.InformationSystemMeta;
import com.dt.platform.ops.service.*;
import com.github.foxnic.api.constant.CodeTextEnum;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanNameUtil;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.collection.MapUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.entity.ReferCause;
import com.github.foxnic.dao.entity.SuperService;
import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.domain.hrm.OrganizationVO;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.system.DictItemVO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.github.foxnic.web.misc.ztree.ZTreeNode;
import org.github.foxnic.web.proxy.hrm.OrganizationServiceProxy;
import org.github.foxnic.web.proxy.system.DictItemServiceProxy;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 * 主机 服务实现
 * </p>
 * @author 金杰 , maillank@qq.com
 * @since 2021-09-12 13:06:43
*/


@Service("OpsDataService")
public class OpsDataServiceImpl extends SuperService<Host> implements IOpsDataService {
	
	/**
	 * 注入DAO对象
	 * */
	@Resource(name=DBConfigs.PRIMARY_DAO) 
	private DAO dao=null;
	
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

	@Autowired
	IHostService hostService;

	@Autowired
	IInformationSystemService informationSystemService;

	@Autowired
	IDbInstanceService dbinstanceService;

	@Autowired
	IHostPositionService hostPositionService;



	//主机总数量
	public static String HOST_COUNT="host_count";
	//下线主机数量
	public static String HOST_OFFLINE_COUNT="host_offline_count";
	//数据库主机数量
	public static String HOST_DATABASE_COUNT="host_database_count";
	//主机业务分类
	public static String HOST_TYPE="host_type";
	//主机备份方式
	public static String HOST_BACKUP_METHOD="host_backup_method";
	//主机操作系统
	public static String HOST_OS_TYPE="host_os_type";
	//主机运行环境
	public static String HOST_ENV="host_env";
	//上线时间
	public static String HOST_ONLINE_TIME="host_online_time";

	@Override
	public List<Host> queryHostList(HostVO host) {
		return hostService.queryList(host);
	}

	@Override
	public HashMap<String,String> queryDictItemDataByDictCode(String dictCode){
		HashMap<String,String> map=new HashMap<>();
		DictItemVO vo=new DictItemVO();
		vo.setDictCode(dictCode);
		Result<List<DictItem>> result=DictItemServiceProxy.api().queryList(vo);
		if(result.isSuccess()){
			List<DictItem> list=result.getData();
			for(int i=0;i<list.size();i++){
				map.put(list.get(i).getCode(),list.get(i).getLabel());
			}
		}else{
		}
		return map;
	}


	@Override
	public HashMap<String,String> queryUseOrganizationNodes(){
		//id name
		HashMap<String,String> map=new HashMap<String,String>();
		OrganizationVO vo=new OrganizationVO();
		vo.setIsLoadAllDescendants(1);
		vo.setTenantId(SessionUser.getCurrent().getActivatedTenantId());
		Result r= OrganizationServiceProxy.api().queryNodesFlatten(vo);
		if(r.isSuccess()){
			List<ZTreeNode> list= (List<ZTreeNode> )r.getData();
			for(ZTreeNode node:list){
				String path="";
				for(int j=0;j<node.getNamePathArray().size();j++){
					if(j==0){
						path=node.getNamePathArray().get(j);
					}else{
						path=path+"/"+node.getNamePathArray().get(j);
					}
				}
				map.put(node.getId(),path);
			}
		}
		return map;
	}


	@Override
	public Map<String, Object> queryHostMap(List<Host> list) {
		Map<String,Object> map=new HashMap<>();


		// 关联出 信息系统 数据
		hostService.join(list, HostMeta.INFO_SYSTEM);
		// 关联出 所在位置 数据
		hostService.join(list,HostMeta.POSITION);
		// 关联出 数据库 数据
		hostService.join(list,HostMeta.HOST_DB_LIST);
		// 关联出 中间件 数据
		hostService.join(list,HostMeta.HOST_MIDDLEWARE_LIST);
		// 关联出 操作系统 数据
		hostService.join(list,HostMeta.HOST_OS_LIST);
		// 关联出 操作系统 数据
		hostService.join(list,HostMeta.BACKUP_METHOD);



		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for(int i=0;i<list.size();i++){
			Host item=list.get(i);
			Map<String, Object> hostMap= BeanUtil.toMap(item);
			if(item.getPosition()!=null){
				hostMap.put(OpsHostDataExportColumnEnum.POSITION_ID.code(),item.getPosition().getName());
			}

			if(item.getInfoSystem()!=null){
				hostMap.put(OpsHostDataExportColumnEnum.HOST_INFO_SYSTEM_NAME.code(),item.getInfoSystem().getName());
			}


			if(item.getBackupMethod()!=null){
				hostMap.put(OpsHostDataExportColumnEnum.HOST_BACKUP_METHOD.code(),item.getBackupMethod().getLabel());
			}


			//状态
			CodeTextEnum vStatus= EnumUtil.parseByCode(HostStatusEnum.class,item.getStatus());
			hostMap.put(OpsHostDataExportColumnEnum.HOST_STATUS.code(),vStatus==null?"":vStatus.text());


			//monitor状态
			CodeTextEnum vMonitorStatus= EnumUtil.parseByCode(HostMonitorStatusEnum.class,item.getMonitorStatus());
			hostMap.put(OpsHostDataExportColumnEnum.HOST_MONITOR_STATUS.code(),vMonitorStatus==null?"":vMonitorStatus.text());

			//HOST_TYPE
			String hostType=item.getHostType();
			if(StringUtil.isBlank(hostType)){
				hostMap.put(OpsHostDataExportColumnEnum.HOST_TYPE.code(),"");
			}else{
				Rcd rs=dao.queryRecord("select * from sys_dict_item where dict_code=? and code=?","ops_host_type",hostType);
				if(rs!=null){
					hostMap.put(OpsHostDataExportColumnEnum.HOST_TYPE.code(),rs.getString("label"));
				}else{
					hostMap.put(OpsHostDataExportColumnEnum.HOST_TYPE.code(),"");
				}
			}


			//PASSWORD_STRATEGY_ID
			String hostPasswordStrategy=item.getPasswordStrategyId();
			if(StringUtil.isBlank(hostPasswordStrategy)){
				hostMap.put(OpsHostDataExportColumnEnum.HOST_PASSWORD_STRATEGY.code(),"");
			}else{
				Rcd rs=dao.queryRecord("select * from sys_dict_item where dict_code=? and code=?","ops_host_password_strategy",hostPasswordStrategy);
				if(rs!=null){
					hostMap.put(OpsHostDataExportColumnEnum.HOST_PASSWORD_STRATEGY.code(),rs.getString("label"));
				}else{
					hostMap.put(OpsHostDataExportColumnEnum.HOST_PASSWORD_STRATEGY.code(),"");
				}
//				DictItemVO vo=new DictItemVO();
//				vo.setDictCode("ops_host_password_strategy");
//				vo.setCode(hostPasswordStrategy);
//				List<DictItem> itemList=DictProxyUtil.getList(vo);
//				if(itemList.size()==1){
//					hostMap.put(OpsHostDataExportColumnEnum.HOST_PASSWORD_STRATEGY.code(),itemList.get(0).getLabel());
//				}else{
//					hostMap.put(OpsHostDataExportColumnEnum.HOST_PASSWORD_STRATEGY.code(),"");
//				}
			}

			//ENVIRONMENT
			String hostEnv=item.getEnvironment();
			if(StringUtil.isBlank(hostEnv)){
				hostMap.put(OpsHostDataExportColumnEnum.HOST_ENVIRONMENT.code(),"");
			}else{
				Rcd rs=dao.queryRecord("select * from sys_dict_item where dict_code=? and code=?","ops_environment",hostEnv);
				if(rs!=null){
					hostMap.put(OpsHostDataExportColumnEnum.HOST_ENVIRONMENT.code(),rs.getString("label"));
				}else{
					hostMap.put(OpsHostDataExportColumnEnum.HOST_ENVIRONMENT.code(),"");
				}

//				DictItemVO vo=new DictItemVO();
//				vo.setDictCode("ops_environment");
//				vo.setCode(hostEnv);
//				List<DictItem> itemList=DictProxyUtil.getList(vo);
//				if(itemList.size()==1){
//					hostMap.put(OpsHostDataExportColumnEnum.HOST_ENVIRONMENT.code(),itemList.get(0).getLabel());
//				}else{
//					hostMap.put(OpsHostDataExportColumnEnum.HOST_ENVIRONMENT.code(),"");
//				}
			}

			if(item.getHostOsList()!=null){
				List<ServiceInfo> os=item.getHostOsList();
				String osstr="";
				for(int j=0;j<os.size();j++){
					osstr=osstr+","+os.get(j).getName();
				}
				hostMap.put(OpsHostDataExportColumnEnum.HOST_OS.code(),osstr.replaceFirst(",",""));
			}

			if(item.getHostDbList()!=null){
				List<ServiceInfo> db=item.getHostDbList();
				String dbstr="";
				for(int j=0;j<db.size();j++){
					dbstr=dbstr+","+db.get(j).getName();
				}
				hostMap.put(OpsHostDataExportColumnEnum.HOST_DB.code(),dbstr.replaceFirst(",",""));
			}

			if(item.getHostMiddlewareList()!=null){
				List<ServiceInfo> mid=item.getHostMiddlewareList();
				String midstr="";
				for(int j=0;j<mid.size();j++){
					midstr=midstr+","+mid.get(j).getName();
				}
				hostMap.put(OpsHostDataExportColumnEnum.HOST_MID.code(),midstr.replaceFirst(",",""));
			}
			listMap.add(hostMap);
		}
		map.put("dataList", listMap);
		return map;
	}


	@Override
	public Result verifyISRecord(Rcd rcd, HashMap<String,HashMap<String,String>> matchMap, boolean filldata){

		HashMap<String,String> organizationMap=matchMap.get("organizationMap");
		HashMap<String,String> opsMethodMap=matchMap.get("opsMethodMap");
		HashMap<String,String> devMethodMap=matchMap.get("devMethodMap");
		HashMap<String,String> gradeMap=matchMap.get("gradeMap");
		HashMap<String,String> statusMap=matchMap.get("statusMap");


		String belongOrg=BeanNameUtil.instance().depart(InformationSystemMeta.BELONG_ORG_ID);
		String valueBelongOrg=rcd.getString(belongOrg);
		if(!StringUtil.isBlank(valueBelongOrg)){
			if(organizationMap.containsValue(valueBelongOrg.trim())){
				String key=getMapKey(organizationMap,valueBelongOrg);
				rcd.setValue(belongOrg,key);
			}else{
				//返回报错
				return ErrorDesc.failureMessage("组织节点不存在:"+valueBelongOrg);
			}

		}



		//下拉框类型
		String belongOrganization=BeanNameUtil.instance().depart(InformationSystemMeta.BELONG_ORGANIZATION);
		String valueBelongOrganization=rcd.getString(belongOrganization);
		if(!StringUtil.isBlank(valueBelongOrganization)){
			if(organizationMap.containsValue(valueBelongOrganization.trim())){
				String key=getMapKey(organizationMap,valueBelongOrganization);
				rcd.setValue(belongOrganization,key);
			}else{
				//返回报错
				return ErrorDesc.failureMessage("组织节点不存在:"+valueBelongOrganization);
			}
		}


		//运行状态
		String status=BeanNameUtil.instance().depart(InformationSystemMeta.STATUS);
		String valueStatus=rcd.getString(status);
		if(!StringUtil.isBlank(valueStatus)){
			if(statusMap.containsValue(valueStatus)){
				String key=getMapKey(statusMap,valueStatus);
				rcd.setValue(status,key);
			}else{
				return ErrorDesc.failureMessage("运行状态不存在:"+valueStatus);
			}
		}



		//分级
		String grade=BeanNameUtil.instance().depart(InformationSystemMeta.GRADE);
		String valueGrade=rcd.getString(grade);

		if(!StringUtil.isBlank(valueGrade)){
			if(gradeMap.containsValue(valueGrade)){
				String key=getMapKey(gradeMap,valueGrade);
				rcd.setValue(grade,key);
			}else{
				return ErrorDesc.failureMessage("分级不存在:"+valueGrade);
			}
		}


		//开发模式
		String devMethod=BeanNameUtil.instance().depart(InformationSystemMeta.DEV_METHOD);
		String valueDevMethod=rcd.getString(devMethod);
		if(!StringUtil.isBlank(valueDevMethod)){
			if(devMethodMap.containsValue(valueDevMethod)){
				String key=getMapKey(devMethodMap,valueDevMethod);
				rcd.setValue(devMethod,key);
			}else{
				return ErrorDesc.failureMessage("开发模式不存在:"+valueDevMethod);
			}
		}


		//运维模式
		String opsMethod=BeanNameUtil.instance().depart(InformationSystemMeta.OPS_METHOD);
		String valueOpsMethod=rcd.getString(opsMethod);
		if(!StringUtil.isBlank(valueOpsMethod)){
			if(opsMethodMap.containsValue(valueOpsMethod)){
				String key=getMapKey(opsMethodMap,valueOpsMethod);
				rcd.setValue(opsMethod,key);
			}else{
				return ErrorDesc.failureMessage("运维模式不存在:"+valueOpsMethod);
			}
		}





		//日期类型
		String[] dateColumns = {InformationSystemMeta.LASTDRILL_DATE,InformationSystemMeta.OFFLINE_DATE,InformationSystemMeta.OFFLINE_DATE,};
		for(int j=0;j<dateColumns.length;j++){
			String dateColumn=dateColumns[j];
			String value=rcd.getString(BeanNameUtil.instance().depart(dateColumn));
			if(!StringUtil.isBlank(value)){
				int valueLen=value.trim().length();
				try {
					DateFormat format1=null;
					if(valueLen==10){
						format1 = new SimpleDateFormat("yyyy-MM-dd");
					}else if(valueLen==19){
						format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					}else{
						return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
					}
					Date date = format1.parse(value);
					rcd.set(dateColumn,date);
				} catch (ParseException e) {
					return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
				}
			}


		}
		return ErrorDesc.success();
	}



	@Override
	public String getMapKey(HashMap<String,String> map,String value){
		String key = null;
		//Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
		for(String getKey: map.keySet()){
			if(map.get(getKey).equals(value)){
				key = getKey;
				return key;
			}
		}
		return key;
		//这个key肯定是最后一个满足该条件的key.
	}




	@Override
	public Result<JSONObject> queryHostData(String codes) {

		JSONObject result=new JSONObject();
		String[] codeArr=codes.split(",");
		for(int i=0;i<codeArr.length;i++){

			result.put(codeArr[i],queryHostDataByCode(codeArr[i]));
		}

		Result<JSONObject> r=new Result<>();
		r.data(result);
		r.success();
		return r;
	}

	public String hostDefineInfoSql="select aa.id service_info_id2,aa.name service_name,bb.name category_name,bb.code category_code ,cc.name group_name,cc.code group_code from ops_service_info aa\n" +
			"left join ops_service_category bb\n" +
			"on aa.service_category_id=bb.id\n" +
			"left join ops_service_group cc\n" +
			"on aa.group_id= cc.code \n" +
			"where aa.group_id='os'";


	public String hostInfoDetail="select * from (\n" +
			"select a.*,b.service_info_id from ops_host a,ops_host_os b\n" +
			"where a.deleted=0 and a.arch='0' and a.environment='prod'\n" +
			"and a.id=b.host_id\n" +
			")T1 \n" +
			"left join (\n" +
			"select aa.id service_info_id2,aa.name service_name,bb.name category_name,bb.code category_code ,cc.name group_name,cc.code group_code \n" +
			"from ops_service_info aa \n" +
			"left join ops_service_category bb\n" +
			"on aa.service_category_id=bb.id\t\t\n" +
			"left join ops_service_group cc\n" +
			"on aa.group_id= cc.code \n" +
			"where aa.group_id='os'\n" +
			")T2 \n" +
			"on T1.service_info_id=T2.service_info_id2";

	private JSONObject queryHostDataByCode(String code) {
		JSONObject result=new JSONObject();
		if(HOST_COUNT.equals(code)) {
			result = queryHostDataByHostCount();
		}else if(HOST_DATABASE_COUNT.equals(code)){
			result = queryHostDataByHostDataBaseCount();
		}else if(HOST_OFFLINE_COUNT.equals(code)){
			result = queryHostDataByHostOfflineCount();
		}else if(HOST_TYPE.equals(code)){
			JSONArray data = queryHostDataByHostType();
			result.put("data",data);
			JSONArray labelList=new JSONArray();
			JSONArray dataList=new JSONArray();
			JSONArray pieData=new JSONArray();
			for(int i=0;i<data.size();i++){
				JSONObject pie=new JSONObject();
				String name=data.getJSONObject(i).getString("hostTypeName");
				if(StringUtil.isBlank(name)){
					name="未设置";
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

		}else if(HOST_OS_TYPE.equals(code)){
			JSONArray data = queryHostDataByHostOsType();
			result.put("data",data);
			JSONArray labelList=new JSONArray();
			JSONArray dataList=new JSONArray();
			JSONArray pieData=new JSONArray();
			for(int i=0;i<data.size();i++){
				JSONObject pie=new JSONObject();
				String name=data.getJSONObject(i).getString("categoryCode");
				if(StringUtil.isBlank(name)){
					name="未设置";
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
		}else if(HOST_ONLINE_TIME.equals(code)){
			result = queryHostDataByHostOnlineTime();
		}else if(HOST_BACKUP_METHOD.equals(code)){
			JSONArray data = queryHostDataByHostBackupMethod();
			result.put("data",data);
			JSONArray labelList=new JSONArray();
			JSONArray dataList=new JSONArray();
			JSONArray pieData=new JSONArray();
			for(int i=0;i<data.size();i++){
				JSONObject pie=new JSONObject();
				String name=data.getJSONObject(i).getString("hostBackupMethodName");
				if(StringUtil.isBlank(name)){
					name="未设置";
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

		}
		return result;
	}

	private JSONObject queryHostDataByHostCount(){
		String sql="select count(1) cnt from ops_host where deleted=0 and arch='0' and environment='prod'";
		JSONObject res=new JSONObject();
		res.put("count",dao.queryRecord(sql).getInteger("cnt"));
		return res;
	}


	private JSONObject queryHostDataByHostOfflineCount(){
		String sql="select count(1) cnt from ops_host where deleted=0 and arch='0' and environment='prod' and status<>'1'";
		JSONObject res=new JSONObject();
		res.put("count",dao.queryRecord(sql).getInteger("cnt"));
		return res;
	}

	/*统计在线的节点，生产环境，且非归档*/
	private JSONObject queryHostDataByHostDataBaseCount(){
		String sql="select count(1) cnt from ops_host a,ops_host_db b\n" +
				"where a.deleted=0 and a.arch='0' and a.environment='prod'\n" +
				"and a.id=b.host_id\n" +
				"and b.deleted=0\n" +
				"and b.service_info_id is not null\n" +
				"and b.service_info_id <>''\n";
		JSONObject res=new JSONObject();
		res.put("count",dao.queryRecord(sql).getInteger("cnt"));
		return res;
	}

	/*统计在线的节点，生产环境，且非归档*/
	private JSONArray queryHostDataByHostType(){
		String sql="\n" +
				"select \n" +
				"(select label from sys_dict_item dict where dict.dict_code='ops_host_type' and dict.code=tab.host_type) host_type_name,\n" +
				"host_type ,count(1) cnt from ("+hostInfoDetail+") tab group by host_type order by 3 desc";
		return dao.query(sql).toJSONArrayWithJSONObject();

	}

	/*统计在线的节点，生产环境，且非归档*/
	private JSONArray queryHostDataByHostBackupMethod(){
		String sql="\n" +
				"select \n" +
				"(select label from sys_dict_item dict where dict.dict_code='ops_host_backup_method' and dict.code=tab.host_backup_method) host_backup_method_name,\n" +
				"host_backup_method ,count(1) cnt from ("+hostInfoDetail+") tab group by host_backup_method order by 3 desc";
		return dao.query(sql).toJSONArrayWithJSONObject();

	}


	/*统计在线的节点，生产环境，且非归档*/
	private JSONArray queryHostDataByHostOsType(){
		String sql="select category_code,count(1) cnt from ("+hostInfoDetail+" ) tab group by category_code order by 2 desc\n";
		return dao.query(sql).toJSONArrayWithJSONObject();
	}

	/*统计在线的节点，生产环境，且非归档*/
	private JSONObject queryHostDataByHostOnlineTime(){

		return null;
	}


	@Override
	public HashMap<String,String> queryDictItemData(String code){
		HashMap<String,String> map=new HashMap<>();
		DictItemVO vo=new DictItemVO();
		vo.setDictCode(code);
		Result<List<DictItem>> result=DictItemServiceProxy.api().queryList(vo);
		if(result.isSuccess()){
			List<DictItem> list=result.getData();
			for(int i=0;i<list.size();i++){
				 map.put(list.get(i).getCode(),list.get(i).getLabel());
			}
		}
		return map;
	}

	public String queryMapKeyByValue(HashMap<String,String> map, String value){
		String key = null;
		//Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
		for(String getKey: map.keySet()){
			if(map.get(getKey).equals(value)){
				key = getKey;
				return key;
			}
		}
		return key;
	}
	@Override
	public Result verifyHostRecord(Rcd rcd, HashMap<String,HashMap<String,String>> matchMap, boolean filldata){


		//日期类型
		String[] dateColumns = {HostMeta.OFFLINE_TIME,HostMeta.ONLINE_TIME};
		for(int j=0;j<dateColumns.length;j++){
			String dateColumn=dateColumns[j];
			String value=rcd.getString(BeanNameUtil.instance().depart(dateColumn));
			if(!StringUtil.isBlank(value)){
				int valueLen=value.trim().length();
				try {
					DateFormat format1=null;
					if(valueLen==10){
						format1 = new SimpleDateFormat("yyyy-MM-dd");
					}else if(valueLen==19){
						format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					}else{
						return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
					}
					Date date = format1.parse(value);
					rcd.set(dateColumn,date);
				} catch (ParseException e) {
					return ErrorDesc.failureMessage("时间转换失败,字段:"+dateColumn+",时间:"+value);
				}
			}
		}

		//下拉框
		//位置
		String valuePosition=rcd.getString(BeanNameUtil.instance().depart(HostMeta.POSITION_ID));
		if(!StringUtil.isBlank(valuePosition)){
			HostPosition position = hostPositionService.queryEntity(HostPosition.create().setName(valuePosition));
			if(position==null){
				if(filldata){
					position=new HostPosition();
					position.setName(valuePosition);
					hostPositionService.insert(position);
					rcd.setValue(BeanNameUtil.instance().depart(HostMeta.POSITION_ID),position.getId());
				}else{
					return ErrorDesc.failureMessage("资产位置不存在:"+valuePosition);
				}
			}else{
				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.POSITION_ID),position.getId());
			}
		}



		String valueIs=rcd.getString(BeanNameUtil.instance().depart(HostMeta.SYSTEM_ID));
		if(!StringUtil.isBlank(valueIs)){
			InformationSystem infoSystem = informationSystemService.queryEntity(InformationSystem.create().setName(valueIs));
			if(infoSystem==null){
				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.SYSTEM_ID),"");
			}else{
				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.SYSTEM_ID),infoSystem.getId());
			}
		}


//		String valueEnv=rcd.getString(BeanNameUtil.instance().depart(HostMeta.ENVIRONMENT));
//		if(!StringUtil.isBlank(valueEnv)){
//			DictItemVO dictVo=new DictItemVO();
//			dictVo.setLabel(valueEnv);
//			dictVo.setDictCode("ops_environment");
//			Result<List<DictItem> >dictItemResult= DictItemServiceProxy.api().queryList(dictVo);
//			if(dictItemResult.isSuccess()&&dictItemResult.getData().size()>0){
//				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.ENVIRONMENT),dictItemResult.getData().get(0).getCode());
//			}else{
//				//返回报错
//				return ErrorDesc.failureMessage("环境不存在:"+valueEnv);
//			}
//		}

//		String valuePwdStragety=rcd.getString(BeanNameUtil.instance().depart(HostMeta.PASSWORD_STRATEGY_ID));
//		if(!StringUtil.isBlank(valuePwdStragety)){
//			DictItemVO dictVo=new DictItemVO();
//			dictVo.setLabel(valuePwdStragety);
//			dictVo.setDictCode("ops_host_password_strategy");
//			Result<List<DictItem> >dictItemResult= DictItemServiceProxy.api().queryList(dictVo);
//			if(dictItemResult.isSuccess()&&dictItemResult.getData().size()>0){
//				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.PASSWORD_STRATEGY_ID),dictItemResult.getData().get(0).getCode());
//			}else{
//				//返回报错
//				return ErrorDesc.failureMessage("密码策略不存在:"+valuePwdStragety);
//			}
//		}


		String valueBackupMethod=rcd.getString(BeanNameUtil.instance().depart(HostMeta.HOST_BACKUP_METHOD));
		String dictCode="ops_host_backup_method";

//		if(!StringUtil.isBlank(valueBackupMethod)){
//			if(backupMethodMap.containsValue(valueBackupMethod)){
//				String key=getMapKey(backupMethodMap,valueBackupMethod);
//				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.HOST_BACKUP_METHOD),key);
//			}else{
//				if(filldata){
//					//返回报错
//					DictVO dictVO=new DictVO();
//					dictVO.setCode(dictCode);
//					Result<List<Dict>> dictResult=DictServiceProxy.api().queryList(dictVO);
//					if(dictResult.isSuccess()&&dictResult.getData().size()>0){
//						Dict dict=dictResult.getData().get(0);
//						String id=IDGenerator.getSnowflakeIdString();
//						DictItemVO dictItemVO=new DictItemVO();
//						dictItemVO.setDictCode(dict.getCode());
//						dictItemVO.setId(id);
//						dictItemVO.setDictId(dict.getId());
//						dictItemVO.setLabel(valueBackupMethod);
//						DictItemServiceProxy.api().insert(dictItemVO);
//						backupMethodMap.put(id,valueBackupMethod);
//						rcd.setValue(BeanNameUtil.instance().depart(HostMeta.HOST_BACKUP_METHOD),dictItemVO.getId());
//					}else{
//						return ErrorDesc.failureMessage("备份方式数据字典不存在:"+valueBackupMethod);
//					}
//				}else{
//					return ErrorDesc.failureMessage("备份方式数据字典条目不存在:"+valueBackupMethod);
//				}
//			}
//		}

		HashMap<String,String> dictColumns=new HashMap<>();
		dictColumns.put(HostMeta.HOST_BACKUP_METHOD,"ops_host_backup_method,备份方式");
		dictColumns.put(HostMeta.HOST_TYPE,"ops_host_type,主机类型");
		dictColumns.put(HostMeta.ENVIRONMENT,"ops_environment,运行环境");
		dictColumns.put(HostMeta.PASSWORD_STRATEGY_ID,"ops_host_password_strategy,改密策略");
		for(String key:dictColumns.keySet()){
			String keyValue=dictColumns.get(key);
			String[] keyValueArr=keyValue.split(",");
			String dict=keyValueArr[0];
			String notes=keyValueArr[1];
			HashMap<String,String> map=matchMap.get(dict);
			String col=BeanNameUtil.instance().depart(key);
			String valueCol=rcd.getString(col);
			if(!StringUtil.isBlank(valueCol)){
				if(map.containsValue(valueCol)){
					rcd.setValue(col,queryMapKeyByValue(map,valueCol));
				}else{
					return ErrorDesc.failureMessage(notes+":"+valueCol);
				}
			}
		}


//		String valeHostType=rcd.getString(BeanNameUtil.instance().depart(HostMeta.HOST_TYPE));
//		if(!StringUtil.isBlank(valeHostType)){
//			DictItemVO dictVo=new DictItemVO();
//			dictVo.setLabel(valeHostType);
//			dictVo.setDictCode("ops_host_type");
//			Result<List<DictItem>>dictItemResult = DictItemServiceProxy.api().queryList(dictVo);
//			if(dictItemResult.isSuccess()&&dictItemResult.getData().size()>0){
//				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.HOST_TYPE),dictItemResult.getData().get(0).getCode());
//			}else{
//				//返回报错
//				return ErrorDesc.failureMessage("主机类型不存在:"+valeHostType);
//			}
//		}


		//枚举
		String valueStatus=rcd.getString(BeanNameUtil.instance().depart(HostMeta.STATUS));
		if(!StringUtil.isBlank(valueStatus)){
			CodeTextEnum value=EnumUtil.parseByText(HostStatusEnum.class,valueStatus) ;
			if(value==null){
				return ErrorDesc.failureMessage("主机状态不存在:"+valueStatus);
			}else{
				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.STATUS),value.code());
			}
		} else{
			return ErrorDesc.failureMessage("主机状态不存在:"+valueStatus);
		}


		String valueMonitorStatus=rcd.getString(BeanNameUtil.instance().depart(HostMeta.MONITOR_STATUS));
		if(!StringUtil.isBlank(valueMonitorStatus)){
			CodeTextEnum value=EnumUtil.parseByText(HostMonitorStatusEnum.class,valueMonitorStatus) ;
			if(value==null){
				return ErrorDesc.failureMessage("监控状态不存在:"+valueMonitorStatus);
			}else{
				rcd.setValue(BeanNameUtil.instance().depart(HostMeta.MONITOR_STATUS),value.code());
			}
		} else{
			return ErrorDesc.failureMessage("监控状态不存在:"+valueMonitorStatus);
		}

		return ErrorDesc.success();

	}
	@Override
	public List<InformationSystem> queryInformationSystemList(InformationSystemVO sample) {
		return informationSystemService.queryList(sample);
	}

	@Override
	public Map<String, Object> queryInformationSystemMap(List<InformationSystem> list) {
		Map<String,Object> map=new HashMap<>();
		HashMap<String,String> orgMap=queryUseOrganizationNodes();

		informationSystemService.join(list,InformationSystemMeta.INFO_SYSTEM_GRADE);
		informationSystemService.join(list,InformationSystemMeta.INFO_SYSTEM_STATUS);
		informationSystemService.join(list,InformationSystemMeta.INFO_SYSTEM_DEV_METHOD);
		informationSystemService.join(list,InformationSystemMeta.INFO_SYSTEM_OPS_METHOD);

		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for(int i=0;i<list.size();i++) {
			InformationSystem item = list.get(i);
			Map<String, Object> dataMap= BeanUtil.toMap(item);

			String orgName=orgMap.get(item.getBelongOrgId());
			dataMap.put(OpsISDataExportColumnEnum.BELONG_ORG_NAME.code(),orgName);



			if(item.getInfoSystemStatus()!=null){
				dataMap.put(OpsISDataExportColumnEnum.STATUS_NAME.code(),item.getInfoSystemStatus().getLabel());
			}

			if(item.getInfoSystemOpsMethod()!=null){
				dataMap.put(OpsISDataExportColumnEnum.OPS_METHOD_NAME.code(),item.getInfoSystemOpsMethod().getLabel());
			}

			if(item.getInfoSystemDevMethod()!=null){
				dataMap.put(OpsISDataExportColumnEnum.DEV_METHOD_NAME.code(),item.getInfoSystemDevMethod().getLabel());
			}

			if(item.getInfoSystemGrade()!=null){
				dataMap.put(OpsISDataExportColumnEnum.GRADE_NAME.code(),item.getInfoSystemGrade().getLabel());
			}

			listMap.add(dataMap);
		}

		map.put("dataList", listMap);
		return map;
	}

	@Override
	public List<DbInstance> queryDatabaseInstanceList(DbInstanceVO sample) {
		return dbinstanceService.queryList(sample);
	}

	@Override
	public Map<String, Object> queryDatabaseInstanceMap(List<DbInstance> list){
		Map<String,Object> map=new HashMap<>();
		List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
		for(int i=0;i<list.size();i++) {
			DbInstance item = list.get(i);
			Map<String, Object> hostMap= BeanUtil.toMap(item);

			listMap.add(hostMap);

		}
		map.put("dataList", listMap);
		return map;

	}

	public File saveTempFile(InputStream is, String fileName){

		int BYTESIZE=1024;
		String path = System.getProperty("java.io.tmpdir");
		File temp = new File(path + File.separator+fileName);
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try{
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(new FileOutputStream(temp));                            //把文件流转为文件，保存在临时目录
			int len = 0;
			byte[] buf = new byte[10*BYTESIZE];                                                    //缓冲区
			while((len=bis.read(buf)) != -1){
				bos.write(buf, 0, len);
			}
			bos.flush();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try {
				if(bos!=null) bos.close();
				if(bis!=null) bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}



}