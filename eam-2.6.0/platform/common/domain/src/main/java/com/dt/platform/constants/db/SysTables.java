package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2023-04-17 12:28:49
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class SysTables {
	
	/**
	 * 模块角色
	*/
	public static class SYS_AUTO_MODULE_ROLE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_auto_module_role";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 模块
		*/
		public static final DBField MODULE = new DBField(DBDataType.STRING , "module","module","模块","模块",false,false,true);
		
		/**
		 * 类型,role|data_role|busi_role
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","role|data_role|busi_role",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_AUTO_MODULE_ROLE() {
			this.init($NAME,"模块角色" , ID , NAME , STATUS , MODULE , TYPE , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_AUTO_MODULE_ROLE $TABLE=new SYS_AUTO_MODULE_ROLE();
	}
	
	/**
	 * 赋权明细
	*/
	public static class SYS_AUTO_MODULE_ROLE_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_auto_module_role_item";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 模块
		*/
		public static final DBField MODULE_ROLE_ID = new DBField(DBDataType.STRING , "module_role_id","moduleRoleId","模块","模块",false,false,true);
		
		/**
		 * 角色
		*/
		public static final DBField ROLE_ID = new DBField(DBDataType.STRING , "role_id","roleId","角色","角色",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField ROLE_NAME = new DBField(DBDataType.STRING , "role_name","roleName","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_AUTO_MODULE_ROLE_ITEM() {
			this.init($NAME,"赋权明细" , ID , MODULE_ROLE_ID , ROLE_ID , ROLE_NAME , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_AUTO_MODULE_ROLE_ITEM $TABLE=new SYS_AUTO_MODULE_ROLE_ITEM();
	}
	
	/**
	 * 操作日志
	*/
	public static class SYS_AUTO_ROLE_GRANT_RCD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_auto_role_grant_rcd";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 模块
		*/
		public static final DBField MODULE_ROLE_ID = new DBField(DBDataType.STRING , "module_role_id","moduleRoleId","模块","模块",false,false,true);
		
		/**
		 * 角色
		*/
		public static final DBField ROLE_ID = new DBField(DBDataType.STRING , "role_id","roleId","角色","角色",false,false,true);
		
		/**
		 * 用户
		*/
		public static final DBField USER_ID = new DBField(DBDataType.STRING , "user_id","userId","用户","用户",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_AUTO_ROLE_GRANT_RCD() {
			this.init($NAME,"操作日志" , ID , MODULE_ROLE_ID , ROLE_ID , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_AUTO_ROLE_GRANT_RCD $TABLE=new SYS_AUTO_ROLE_GRANT_RCD();
	}
	
	/**
	 * 预定用户
	*/
	public static class SYS_AUTO_USER_PREDEFINED extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_auto_user_predefined";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 用户
		*/
		public static final DBField ACCOUNT = new DBField(DBDataType.STRING , "account","account","用户","用户",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_AUTO_USER_PREDEFINED() {
			this.init($NAME,"预定用户" , ID , ACCOUNT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_AUTO_USER_PREDEFINED $TABLE=new SYS_AUTO_USER_PREDEFINED();
	}
	
	/**
	 * 备份记录
	*/
	public static class SYS_BACKUP_DB extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_backup_db";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField DB_NAME = new DBField(DBDataType.STRING , "db_name","dbName","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 备份文件
		*/
		public static final DBField FILE_ROUTE = new DBField(DBDataType.STRING , "file_route","fileRoute","备份文件","备份文件",false,false,true);
		
		/**
		 * 大小
		*/
		public static final DBField FILE_SIZE = new DBField(DBDataType.DECIMAL , "file_size","fileSize","大小","大小",false,false,true);
		
		/**
		 * 开始时间
		*/
		public static final DBField START_TIME = new DBField(DBDataType.DATE , "start_time","startTime","开始时间","开始时间",false,false,true);
		
		/**
		 * 结束时间
		*/
		public static final DBField END_TIME = new DBField(DBDataType.DATE , "end_time","endTime","结束时间","结束时间",false,false,true);
		
		/**
		 * 失效日期
		*/
		public static final DBField INVALID_TIME = new DBField(DBDataType.DATE , "invalid_time","invalidTime","失效日期","失效日期",false,false,true);
		
		/**
		 * 内容
		*/
		public static final DBField CONTENT = new DBField(DBDataType.STRING , "content","content","内容","内容",false,false,true);
		
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
		
		public SYS_BACKUP_DB() {
			this.init($NAME,"备份记录" , ID , DB_NAME , STATUS , FILE_ROUTE , FILE_SIZE , START_TIME , END_TIME , INVALID_TIME , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_BACKUP_DB $TABLE=new SYS_BACKUP_DB();
	}
	
	/**
	 * 备份策略
	*/
	public static class SYS_BACKUP_DB_STRATEGY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_backup_db_strategy";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 启用状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","启用状态","启用状态",false,false,true);
		
		/**
		 * 备份路径
		*/
		public static final DBField DATA_PATH = new DBField(DBDataType.STRING , "data_path","dataPath","备份路径","备份路径",false,false,true);
		
		/**
		 * 备份保留
		*/
		public static final DBField DATA_KEEP = new DBField(DBDataType.INTEGER , "data_keep","dataKeep","备份保留","备份保留",false,false,true);
		
		/**
		 * 备份周期
		*/
		public static final DBField CRONTAB = new DBField(DBDataType.STRING , "crontab","crontab","备份周期","备份周期",false,false,true);
		
		/**
		 * 邮件
		*/
		public static final DBField MAIL = new DBField(DBDataType.STRING , "mail","mail","邮件","邮件",false,false,true);
		
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
		
		public SYS_BACKUP_DB_STRATEGY() {
			this.init($NAME,"备份策略" , ID , STATUS , DATA_PATH , DATA_KEEP , CRONTAB , MAIL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_BACKUP_DB_STRATEGY $TABLE=new SYS_BACKUP_DB_STRATEGY();
	}
	
	/**
	 * 版本切换
	*/
	public static class SYS_LICENCE_SWITCH extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_licence_switch";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 许可版本
		*/
		public static final DBField LICENCE_TAB = new DBField(DBDataType.STRING , "licence_tab","licenceTab","许可版本","许可版本",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 动作
		*/
		public static final DBField ACTION_CONTENT = new DBField(DBDataType.STRING , "action_content","actionContent","动作","动作",false,false,true);
		
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
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		public SYS_LICENCE_SWITCH() {
			this.init($NAME,"版本切换" , ID , LICENCE_TAB , STATUS , ACTION_CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_LICENCE_SWITCH $TABLE=new SYS_LICENCE_SWITCH();
	}
	
	/**
	 * 日志收集
	*/
	public static class SYS_LOG_COLLECT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_log_collect";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 范围
		*/
		public static final DBField COLLECT_RANGE = new DBField(DBDataType.STRING , "collect_range","collectRange","范围","范围",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 文件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","文件","文件",false,false,true);
		
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
		
		public SYS_LOG_COLLECT() {
			this.init($NAME,"日志收集" , ID , COLLECT_RANGE , STATUS , FILE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_LOG_COLLECT $TABLE=new SYS_LOG_COLLECT();
	}
	
	/**
	 * 节点负载
	*/
	public static class SYS_NODE_LOAD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "sys_node_load";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 节点
		*/
		public static final DBField NODE = new DBField(DBDataType.STRING , "node","node","节点","节点",false,false,true);
		
		/**
		 * IP
		*/
		public static final DBField IP = new DBField(DBDataType.STRING , "ip","ip","IP","IP",false,false,true);
		
		/**
		 * 用户使用率
		*/
		public static final DBField USER = new DBField(DBDataType.DECIMAL , "user","user","用户使用率","用户使用率",false,false,true);
		
		/**
		 * 系统使用率
		*/
		public static final DBField SYS = new DBField(DBDataType.DECIMAL , "sys","sys","系统使用率","系统使用率",false,false,true);
		
		/**
		 * 空闲使用率
		*/
		public static final DBField IDLE = new DBField(DBDataType.DECIMAL , "idle","idle","空闲使用率","空闲使用率",false,false,true);
		
		/**
		 * wio
		*/
		public static final DBField WIO = new DBField(DBDataType.DECIMAL , "wio","wio","wio","wio",false,false,true);
		
		/**
		 * load1
		*/
		public static final DBField LOAD1 = new DBField(DBDataType.DECIMAL , "load1","load1","load1","load1",false,false,true);
		
		/**
		 * load5
		*/
		public static final DBField LOAD5 = new DBField(DBDataType.DECIMAL , "load5","load5","load5","load5",false,false,true);
		
		/**
		 * load15
		*/
		public static final DBField LOAD15 = new DBField(DBDataType.DECIMAL , "load15","load15","load15","load15",false,false,true);
		
		/**
		 * 内存使用
		*/
		public static final DBField MEMORY_USED = new DBField(DBDataType.DECIMAL , "memory_used","memoryUsed","内存使用","内存使用",false,false,true);
		
		/**
		 * 内存使用率
		*/
		public static final DBField MEMORY_USED_PCT = new DBField(DBDataType.DECIMAL , "memory_used_pct","memoryUsedPct","内存使用率","内存使用率",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		public SYS_NODE_LOAD() {
			this.init($NAME,"节点负载" , ID , NODE , IP , USER , SYS , IDLE , WIO , LOAD1 , LOAD5 , LOAD15 , MEMORY_USED , MEMORY_USED_PCT , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final SYS_NODE_LOAD $TABLE=new SYS_NODE_LOAD();
	}
}