package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2022-07-14 07:38:20
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class WorkorderTables {
	
	/**
	 * 工单类型
	*/
	public static class WO_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_category";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public WO_CATEGORY() {
			this.init($NAME,"工单类型" , ID , NAME , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final WO_CATEGORY $TABLE=new WO_CATEGORY();
	}
	
	/**
	 * 网络策略申请
	*/
	public static class WO_NETWORK_STRATEGY_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_network_strategy_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 项目
		*/
		public static final DBField PROJECT_NAME = new DBField(DBDataType.STRING , "project_name","projectName","项目","项目",false,false,true);
		
		/**
		 * 运行环境
		*/
		public static final DBField ENVIRONMENT_ID = new DBField(DBDataType.STRING , "environment_id","environmentId","运行环境","运行环境",false,false,true);
		
		/**
		 * 有效期
		*/
		public static final DBField PERIOD_TYPE = new DBField(DBDataType.STRING , "period_type","periodType","有效期","有效期",false,false,true);
		
		/**
		 * 过期日期
		*/
		public static final DBField EXPIRATION_DATE = new DBField(DBDataType.DATE , "expiration_date","expirationDate","过期日期","过期日期",false,false,true);
		
		/**
		 * 申请日期
		*/
		public static final DBField APPLY_DATE = new DBField(DBDataType.DATE , "apply_date","applyDate","申请日期","申请日期",false,false,true);
		
		/**
		 * 期望日期
		*/
		public static final DBField EXPECTED_COMPLETION_DATE = new DBField(DBDataType.DATE , "expected_completion_date","expectedCompletionDate","期望日期","期望日期",false,false,true);
		
		/**
		 * 申请原因
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","申请原因","申请原因",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 申请人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","申请人","申请人",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public WO_NETWORK_STRATEGY_APPLY() {
			this.init($NAME,"网络策略申请" , ID , CODE , STATUS , NAME , PROJECT_NAME , ENVIRONMENT_ID , PERIOD_TYPE , EXPIRATION_DATE , APPLY_DATE , EXPECTED_COMPLETION_DATE , CONTENT , FILE_ID , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION);
		}
		public static final WO_NETWORK_STRATEGY_APPLY $TABLE=new WO_NETWORK_STRATEGY_APPLY();
	}
	
	/**
	 * 网络策略
	*/
	public static class WO_NETWORK_STRATEGY_INFO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_network_strategy_info";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 源名称
		*/
		public static final DBField SOURCE_NAME = new DBField(DBDataType.STRING , "source_name","sourceName","源名称","源名称",false,false,true);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所属","所属",false,false,true);
		
		/**
		 * 源IP
		*/
		public static final DBField SOURCE_IP = new DBField(DBDataType.STRING , "source_ip","sourceIp","源IP","源IP",false,false,true);
		
		/**
		 * 目标名称
		*/
		public static final DBField TARGET_NAME = new DBField(DBDataType.STRING , "target_name","targetName","目标名称","目标名称",false,false,true);
		
		/**
		 * 目标IP
		*/
		public static final DBField TARGET_IP = new DBField(DBDataType.STRING , "target_ip","targetIp","目标IP","目标IP",false,false,true);
		
		/**
		 * 目标端口
		*/
		public static final DBField TARGET_PORTS = new DBField(DBDataType.STRING , "target_ports","targetPorts","目标端口","目标端口",false,false,true);
		
		/**
		 * 使用协议
		*/
		public static final DBField USED_PROTOCOL_TYPE = new DBField(DBDataType.STRING , "used_protocol_type","usedProtocolType","使用协议","使用协议",false,false,true);
		
		/**
		 * 连接类型
		*/
		public static final DBField SESSION_TYPE = new DBField(DBDataType.STRING , "session_type","sessionType","连接类型","连接类型",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public WO_NETWORK_STRATEGY_INFO() {
			this.init($NAME,"网络策略" , ID , SOURCE_NAME , OWNER_ID , SOURCE_IP , TARGET_NAME , TARGET_IP , TARGET_PORTS , USED_PROTOCOL_TYPE , SESSION_TYPE , NOTES , SELECTED_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final WO_NETWORK_STRATEGY_INFO $TABLE=new WO_NETWORK_STRATEGY_INFO();
	}
	
	/**
	 * 服务器资源申请
	*/
	public static class WO_SERVER_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_server_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编号","编号",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 项目名称
		*/
		public static final DBField PROJECT_NAME = new DBField(DBDataType.STRING , "project_name","projectName","项目名称","项目名称",false,false,true);
		
		/**
		 * 运行环境
		*/
		public static final DBField ENVIRONMENT_ID = new DBField(DBDataType.STRING , "environment_id","environmentId","运行环境","运行环境",false,false,true);
		
		/**
		 * 有效期
		*/
		public static final DBField PERIOD_TYPE = new DBField(DBDataType.STRING , "period_type","periodType","有效期","有效期",false,false,true);
		
		/**
		 * 过期日期
		*/
		public static final DBField EXPIRATION_DATE = new DBField(DBDataType.DATE , "expiration_date","expirationDate","过期日期","过期日期",false,false,true);
		
		/**
		 * 申请日期
		*/
		public static final DBField APPLY_DATE = new DBField(DBDataType.DATE , "apply_date","applyDate","申请日期","申请日期",false,false,true);
		
		/**
		 * 期望日期
		*/
		public static final DBField EXPECTED_COMPLETION_DATE = new DBField(DBDataType.DATE , "expected_completion_date","expectedCompletionDate","期望日期","期望日期",false,false,true);
		
		/**
		 * 系统域名
		*/
		public static final DBField DOMAIN_NAME = new DBField(DBDataType.STRING , "domain_name","domainName","系统域名","系统域名",false,false,true);
		
		/**
		 * 申请原因
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","申请原因","申请原因",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 申请人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","申请人","申请人",false,false,true);
		
		/**
		 * 完成日期
		*/
		public static final DBField COMPLETION_DATE = new DBField(DBDataType.DATE , "completion_date","completionDate","完成日期","完成日期",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WO_SERVER_APPLY() {
			this.init($NAME,"服务器资源申请" , ID , CODE , STATUS , NAME , PROJECT_NAME , ENVIRONMENT_ID , PERIOD_TYPE , EXPIRATION_DATE , APPLY_DATE , EXPECTED_COMPLETION_DATE , DOMAIN_NAME , CONTENT , FILE_ID , ORIGINATOR_ID , COMPLETION_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WO_SERVER_APPLY $TABLE=new WO_SERVER_APPLY();
	}
	
	/**
	 * 服务器资源
	*/
	public static class WO_SERVER_INFO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_server_info";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所属","所属",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 服务器类型
		*/
		public static final DBField SERVER_TYPE = new DBField(DBDataType.STRING , "server_type","serverType","服务器类型","服务器类型",false,false,true);
		
		/**
		 * 系统版本
		*/
		public static final DBField OS_VERSION = new DBField(DBDataType.STRING , "os_version","osVersion","系统版本","系统版本",false,false,true);
		
		/**
		 * IP地址
		*/
		public static final DBField IP = new DBField(DBDataType.STRING , "ip","ip","IP地址","IP地址",false,false,true);
		
		/**
		 * 数据库
		*/
		public static final DBField DATABASE_VERSION = new DBField(DBDataType.STRING , "database_version","databaseVersion","数据库","数据库",false,false,true);
		
		/**
		 * 中间件
		*/
		public static final DBField MIDDLEWARE_VERSION = new DBField(DBDataType.STRING , "middleware_version","middlewareVersion","中间件","中间件",false,false,true);
		
		/**
		 * CPU数
		*/
		public static final DBField CPU = new DBField(DBDataType.INTEGER , "cpu","cpu","CPU数","CPU数",false,false,true);
		
		/**
		 * 内存(G)
		*/
		public static final DBField MEMORY = new DBField(DBDataType.INTEGER , "memory","memory","内存(G)","内存(G)",false,false,true);
		
		/**
		 * 空间(G)
		*/
		public static final DBField SPACE_SIZE = new DBField(DBDataType.INTEGER , "space_size","spaceSize","空间(G)","空间(G)",false,false,true);
		
		/**
		 * 数量
		*/
		public static final DBField SERVER_NUMBER = new DBField(DBDataType.INTEGER , "server_number","serverNumber","数量","数量",false,false,true);
		
		/**
		 * 用户列表
		*/
		public static final DBField USERLIST = new DBField(DBDataType.STRING , "userList","userlist","用户列表","用户列表",false,false,true);
		
		/**
		 * 端口列表
		*/
		public static final DBField PORTLIST = new DBField(DBDataType.STRING , "portList","portlist","端口列表","端口列表",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public WO_SERVER_INFO() {
			this.init($NAME,"服务器资源" , ID , OWNER_ID , NAME , SERVER_TYPE , OS_VERSION , IP , DATABASE_VERSION , MIDDLEWARE_VERSION , CPU , MEMORY , SPACE_SIZE , SERVER_NUMBER , USERLIST , PORTLIST , NOTES , SELECTED_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final WO_SERVER_INFO $TABLE=new WO_SERVER_INFO();
	}
	
	/**
	 * 操作系统
	*/
	public static class WO_SERVER_OS_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_server_os_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","顺序","顺序",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WO_SERVER_OS_TYPE() {
			this.init($NAME,"操作系统" , ID , NAME , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WO_SERVER_OS_TYPE $TABLE=new WO_SERVER_OS_TYPE();
	}
	
	/**
	 * 服务台
	*/
	public static class WO_SERVICE_DESK extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_service_desk";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 父节点
		*/
		public static final DBField PID = new DBField(DBDataType.STRING , "pid","pid","父节点","父节点",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 流程编码
		*/
		public static final DBField PROCESS_CODE = new DBField(DBDataType.STRING , "process_code","processCode","流程编码","流程编码",false,false,true);
		
		/**
		 * 权限
		*/
		public static final DBField PERM = new DBField(DBDataType.STRING , "perm","perm","权限","权限",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField IMAGE = new DBField(DBDataType.STRING , "image","image","图片","图片",false,false,true);
		
		/**
		 * 参数
		*/
		public static final DBField PARAMETER = new DBField(DBDataType.STRING , "parameter","parameter","参数","参数",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField URL = new DBField(DBDataType.STRING , "url","url","地址","地址",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WO_SERVICE_DESK() {
			this.init($NAME,"服务台" , ID , PID , NAME , LABEL , CODE , STATUS , TYPE , PROCESS_CODE , PERM , IMAGE , PARAMETER , URL , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WO_SERVICE_DESK $TABLE=new WO_SERVICE_DESK();
	}
	
	/**
	 * 我的门户
	*/
	public static class WO_SERVICE_MY_PORTAL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_service_my_portal";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField PORTAL_ID = new DBField(DBDataType.STRING , "portal_id","portalId","名称","名称",false,false,true);
		
		/**
		 * 我的
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","我的","我的",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WO_SERVICE_MY_PORTAL() {
			this.init($NAME,"我的门户" , ID , PORTAL_ID , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WO_SERVICE_MY_PORTAL $TABLE=new WO_SERVICE_MY_PORTAL();
	}
	
	/**
	 * 服务门户
	*/
	public static class WO_SERVICE_PORTAL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_service_portal";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 分组
		*/
		public static final DBField GROUP_ID = new DBField(DBDataType.STRING , "group_id","groupId","分组","分组",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 权限
		*/
		public static final DBField PERM = new DBField(DBDataType.STRING , "perm","perm","权限","权限",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField IMAGE = new DBField(DBDataType.STRING , "image","image","图片","图片",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField URL = new DBField(DBDataType.STRING , "url","url","地址","地址",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WO_SERVICE_PORTAL() {
			this.init($NAME,"服务门户" , ID , NAME , GROUP_ID , LABEL , CODE , STATUS , TYPE , PERM , IMAGE , URL , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WO_SERVICE_PORTAL $TABLE=new WO_SERVICE_PORTAL();
	}
	
	/**
	 * 负载策略申请
	*/
	public static class WO_SLB_STRATEGY_APPLY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_slb_strategy_apply";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编号","编号",false,false,true);
		
		/**
		 * 办理状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","办理状态","办理状态",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 项目名称
		*/
		public static final DBField PROJECT_NAME = new DBField(DBDataType.STRING , "project_name","projectName","项目名称","项目名称",false,false,true);
		
		/**
		 * 运行环境
		*/
		public static final DBField ENVIRONMENT_ID = new DBField(DBDataType.STRING , "environment_id","environmentId","运行环境","运行环境",false,false,true);
		
		/**
		 * 有效期
		*/
		public static final DBField PERIOD_TYPE = new DBField(DBDataType.STRING , "period_type","periodType","有效期","有效期",false,false,true);
		
		/**
		 * 过期日期
		*/
		public static final DBField EXPIRATION_DATE = new DBField(DBDataType.DATE , "expiration_date","expirationDate","过期日期","过期日期",false,false,true);
		
		/**
		 * 申请日期
		*/
		public static final DBField APPLY_DATE = new DBField(DBDataType.DATE , "apply_date","applyDate","申请日期","申请日期",false,false,true);
		
		/**
		 * 期望日期
		*/
		public static final DBField EXPECTED_COMPLETION_DATE = new DBField(DBDataType.DATE , "expected_completion_date","expectedCompletionDate","期望日期","期望日期",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 申请人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","申请人","申请人",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WO_SLB_STRATEGY_APPLY() {
			this.init($NAME,"负载策略申请" , ID , CODE , STATUS , NAME , PROJECT_NAME , ENVIRONMENT_ID , PERIOD_TYPE , EXPIRATION_DATE , APPLY_DATE , EXPECTED_COMPLETION_DATE , CONTENT , FILE_ID , NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WO_SLB_STRATEGY_APPLY $TABLE=new WO_SLB_STRATEGY_APPLY();
	}
	
	/**
	 * 负载策略
	*/
	public static class WO_SLB_STRATEGY_INFO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wo_slb_strategy_info";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所属
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所属","所属",false,false,true);
		
		/**
		 * 服务名称
		*/
		public static final DBField SERVICE_NAME = new DBField(DBDataType.STRING , "service_name","serviceName","服务名称","服务名称",false,false,true);
		
		/**
		 * 服务IP
		*/
		public static final DBField SERVICE_IP = new DBField(DBDataType.STRING , "service_ip","serviceIp","服务IP","服务IP",false,false,true);
		
		/**
		 * 节点IP
		*/
		public static final DBField NODE_IP = new DBField(DBDataType.STRING , "node_ip","nodeIp","节点IP","节点IP",false,false,true);
		
		/**
		 * 端口
		*/
		public static final DBField PORT = new DBField(DBDataType.STRING , "port","port","端口","端口",false,false,true);
		
		/**
		 * 均衡策略
		*/
		public static final DBField BALANCE_STRATEGY = new DBField(DBDataType.STRING , "balance_strategy","balanceStrategy","均衡策略","均衡策略",false,false,true);
		
		/**
		 * 会话保持
		*/
		public static final DBField SESSION_KEEP = new DBField(DBDataType.STRING , "session_keep","sessionKeep","会话保持","会话保持",false,false,true);
		
		/**
		 * 保持方式
		*/
		public static final DBField SESSION_KEEP_METHOD = new DBField(DBDataType.STRING , "session_keep_method","sessionKeepMethod","保持方式","保持方式",false,false,true);
		
		/**
		 * 使用协议
		*/
		public static final DBField USED_PROTOCOL_TYPE = new DBField(DBDataType.STRING , "used_protocol_type","usedProtocolType","使用协议","使用协议",false,false,true);
		
		/**
		 * 选择
		*/
		public static final DBField SELECTED_CODE = new DBField(DBDataType.STRING , "selected_code","selectedCode","选择","选择",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 创建人ID
		*/
		public static final DBField CREATE_BY = new DBField(DBDataType.STRING , "create_by","createBy","创建人ID","创建人ID",false,false,true);
		
		/**
		 * 创建时间
		*/
		public static final DBField CREATE_TIME = new DBField(DBDataType.DATE , "create_time","createTime","创建时间","创建时间",false,false,true);
		
		/**
		 * 修改人ID
		*/
		public static final DBField UPDATE_BY = new DBField(DBDataType.STRING , "update_by","updateBy","修改人ID","修改人ID",false,false,true);
		
		/**
		 * 修改时间
		*/
		public static final DBField UPDATE_TIME = new DBField(DBDataType.DATE , "update_time","updateTime","修改时间","修改时间",false,false,true);
		
		/**
		 * 是否已删除
		*/
		public static final DBField DELETED = new DBField(DBDataType.INTEGER , "deleted","deleted","是否已删除","是否已删除",false,false,false);
		
		/**
		 * 删除人ID
		*/
		public static final DBField DELETE_BY = new DBField(DBDataType.STRING , "delete_by","deleteBy","删除人ID","删除人ID",false,false,true);
		
		/**
		 * 删除时间
		*/
		public static final DBField DELETE_TIME = new DBField(DBDataType.DATE , "delete_time","deleteTime","删除时间","删除时间",false,false,true);
		
		/**
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,false);
		
		public WO_SLB_STRATEGY_INFO() {
			this.init($NAME,"负载策略" , ID , OWNER_ID , SERVICE_NAME , SERVICE_IP , NODE_IP , PORT , BALANCE_STRATEGY , SESSION_KEEP , SESSION_KEEP_METHOD , USED_PROTOCOL_TYPE , SELECTED_CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final WO_SLB_STRATEGY_INFO $TABLE=new WO_SLB_STRATEGY_INFO();
	}
}