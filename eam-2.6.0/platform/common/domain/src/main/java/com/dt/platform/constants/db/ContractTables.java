package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2023-04-14 07:28:00
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class ContractTables {
	
	/**
	 * 合同表
	*/
	public static class CONT_CONTRACT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 合同类型，主合同，子合同、附加协议; ContractType
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","合同类型","主合同，子合同、附加协议; ContractType",false,false,true);
		
		/**
		 * 合同状态;枚举 ContractStatus
		*/
		public static final DBField CONTRACT_STATUS = new DBField(DBDataType.STRING , "contract_status","contractStatus","合同状态","枚举 ContractStatus",false,false,true);
		
		/**
		 * 合同编号
		*/
		public static final DBField CONTRACT_NO = new DBField(DBDataType.STRING , "contract_no","contractNo","合同编号","合同编号",false,false,true);
		
		/**
		 * 合同抬头
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","合同抬头","合同抬头",false,false,true);
		
		/**
		 * 合同分类代码，关联字典
		*/
		public static final DBField CATALOG_CODE = new DBField(DBDataType.STRING , "catalog_code","catalogCode","合同分类代码","关联字典",false,false,true);
		
		/**
		 * 归属部门ID
		*/
		public static final DBField DEPARTMENT_ID = new DBField(DBDataType.STRING , "department_id","departmentId","归属部门ID","归属部门ID",false,false,true);
		
		/**
		 * 签订主体
		*/
		public static final DBField ENTITY = new DBField(DBDataType.STRING , "entity","entity","签订主体","签订主体",false,false,true);
		
		/**
		 * 签约人
		*/
		public static final DBField SIGNATORY_ID = new DBField(DBDataType.STRING , "signatory_id","signatoryId","签约人","签约人",false,false,true);
		
		/**
		 * 经办人
		*/
		public static final DBField HANDLER_ID = new DBField(DBDataType.STRING , "handler_id","handlerId","经办人","经办人",false,false,true);
		
		/**
		 * 交付物
		*/
		public static final DBField DELIVERABLES = new DBField(DBDataType.STRING , "deliverables","deliverables","交付物","交付物",false,false,true);
		
		/**
		 * 交付地
		*/
		public static final DBField DELIVERY_LOCATION = new DBField(DBDataType.STRING , "delivery_location","deliveryLocation","交付地","交付地",false,false,true);
		
		/**
		 * 父合同
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","父合同","父合同",false,false,true);
		
		/**
		 * 摘要信息
		*/
		public static final DBField SUMMARY = new DBField(DBDataType.STRING , "summary","summary","摘要信息","摘要信息",false,false,true);
		
		/**
		 * 签订日期
		*/
		public static final DBField SIGNING_DATE = new DBField(DBDataType.DATE , "signing_date","signingDate","签订日期","签订日期",false,false,true);
		
		/**
		 * 生效日期
		*/
		public static final DBField EFFECTIVE_DATE = new DBField(DBDataType.DATE , "effective_date","effectiveDate","生效日期","生效日期",false,false,true);
		
		/**
		 * 结束日期
		*/
		public static final DBField END_DATE = new DBField(DBDataType.DATE , "end_date","endDate","结束日期","结束日期",false,false,true);
		
		/**
		 * 失效日期
		*/
		public static final DBField EXPIRATION_DATE = new DBField(DBDataType.DATE , "expiration_date","expirationDate","失效日期","失效日期",false,false,true);
		
		/**
		 * 合同金额
		*/
		public static final DBField AMOUNT = new DBField(DBDataType.DECIMAL , "amount","amount","合同金额","合同金额",false,false,true);
		
		/**
		 * 资金状态；枚举 FundingStatus
		*/
		public static final DBField FUNDING_STATUS = new DBField(DBDataType.STRING , "funding_status","fundingStatus","资金状态","枚举 FundingStatus",false,false,true);
		
		/**
		 * 资金流向，关联字典
		*/
		public static final DBField FUNDING_DIRECTION = new DBField(DBDataType.STRING , "funding_direction","fundingDirection","资金流向","关联字典",false,false,true);
		
		/**
		 * 是否归档
		*/
		public static final DBField ARCH = new DBField(DBDataType.STRING , "arch","arch","是否归档","是否归档",false,false,true);
		
		/**
		 * 合同附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","合同附件","合同附件",false,false,true);
		
		/**
		 * 其他附件
		*/
		public static final DBField OTHER_ATTACH = new DBField(DBDataType.STRING , "other_attach","otherAttach","其他附件","其他附件",false,false,true);
		
		/**
		 * 创建者
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","创建者","创建者",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT() {
			this.init($NAME,"合同表" , ID , TYPE , CONTRACT_STATUS , CONTRACT_NO , TITLE , CATALOG_CODE , DEPARTMENT_ID , ENTITY , SIGNATORY_ID , HANDLER_ID , DELIVERABLES , DELIVERY_LOCATION , PARENT_ID , SUMMARY , SIGNING_DATE , EFFECTIVE_DATE , END_DATE , EXPIRATION_DATE , AMOUNT , FUNDING_STATUS , FUNDING_DIRECTION , ARCH , ATTACH , OTHER_ATTACH , OWNER_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT $TABLE=new CONT_CONTRACT();
	}
	
	/**
	 * 合同验收
	*/
	public static class CONT_CONTRACT_ACCEPT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_accept";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 归属
		*/
		public static final DBField BELONG_ID = new DBField(DBDataType.STRING , "belong_id","belongId","归属","归属",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","类型","类型",false,false,true);
		
		/**
		 * 验收时间
		*/
		public static final DBField ACCEPT_DATE = new DBField(DBDataType.DATE , "accept_date","acceptDate","验收时间","验收时间",false,false,true);
		
		/**
		 * 验收人
		*/
		public static final DBField ACCEPT_USER_ID = new DBField(DBDataType.STRING , "accept_user_id","acceptUserId","验收人","验收人",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","制单人","制单人",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 生效版本
		*/
		public static final DBField OPER_APPLY_VERSION = new DBField(DBDataType.STRING , "oper_apply_version","operApplyVersion","生效版本","生效版本",false,false,true);
		
		/**
		 * 应用标记
		*/
		public static final DBField OPER_APPLY_FLAG = new DBField(DBDataType.STRING , "oper_apply_flag","operApplyFlag","应用标记","应用标记",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT_ACCEPT() {
			this.init($NAME,"合同验收" , ID , BELONG_ID , LABEL , ACCEPT_DATE , ACCEPT_USER_ID , OWNER_ID , ATTACH , NOTES , OPER_APPLY_VERSION , OPER_APPLY_FLAG , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_ACCEPT $TABLE=new CONT_CONTRACT_ACCEPT();
	}
	
	/**
	 * 档案管理
	*/
	public static class CONT_CONTRACT_ARCHIVE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_archive";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 档案编号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","档案编号","档案编号",false,false,true);
		
		/**
		 * 档案名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","档案名称","档案名称",false,false,true);
		
		/**
		 * 保密登记
		*/
		public static final DBField LEVEL = new DBField(DBDataType.STRING , "level","level","保密登记","保密登记",false,false,true);
		
		/**
		 * 存放位置
		*/
		public static final DBField LOC = new DBField(DBDataType.STRING , "loc","loc","存放位置","存放位置",false,false,true);
		
		/**
		 * 年份
		*/
		public static final DBField YEAR = new DBField(DBDataType.STRING , "year","year","年份","年份",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT_ARCHIVE() {
			this.init($NAME,"档案管理" , ID , CODE , NAME , LEVEL , LOC , YEAR , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_ARCHIVE $TABLE=new CONT_CONTRACT_ARCHIVE();
	}
	
	/**
	 * 合同附件
	*/
	public static class CONT_CONTRACT_ATTACHMENT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_attachment";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所有者
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所有者","所有者",false,false,true);
		
		/**
		 * 文件
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","文件","文件",false,false,true);
		
		/**
		 * 附件名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","附件名称","附件名称",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT_ATTACHMENT() {
			this.init($NAME,"合同附件" , ID , OWNER_ID , FILE_ID , NAME , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_ATTACHMENT $TABLE=new CONT_CONTRACT_ATTACHMENT();
	}
	
	/**
	 * 合同分类
	*/
	public static class CONT_CONTRACT_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_category";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField CATEGORY_NAME = new DBField(DBDataType.STRING , "category_name","categoryName","名称","名称",false,false,true);
		
		/**
		 * 全称
		*/
		public static final DBField CATEGORY_FULLNAME = new DBField(DBDataType.STRING , "category_fullname","categoryFullname","全称","全称",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CATEGORY_CODE = new DBField(DBDataType.STRING , "category_code","categoryCode","编码","编码",false,false,true);
		
		/**
		 * 父节点
		*/
		public static final DBField PARENT_ID = new DBField(DBDataType.STRING , "parent_id","parentId","父节点","父节点",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
		/**
		 * 节点路径
		*/
		public static final DBField HIERARCHY = new DBField(DBDataType.STRING , "hierarchy","hierarchy","节点路径","节点路径",false,false,true);
		
		/**
		 * 节点路径名称
		*/
		public static final DBField HIERARCHY_NAME = new DBField(DBDataType.STRING , "hierarchy_name","hierarchyName","节点路径名称","节点路径名称",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public CONT_CONTRACT_CATEGORY() {
			this.init($NAME,"合同分类" , ID , CATEGORY_NAME , CATEGORY_FULLNAME , CATEGORY_CODE , PARENT_ID , SORT , HIERARCHY , HIERARCHY_NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final CONT_CONTRACT_CATEGORY $TABLE=new CONT_CONTRACT_CATEGORY();
	}
	
	/**
	 * 合同表变动记录
	*/
	public static class CONT_CONTRACT_CHANGE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_change";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT_CHANGE() {
			this.init($NAME,"合同表变动记录" , ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_CHANGE $TABLE=new CONT_CONTRACT_CHANGE();
	}
	
	/**
	 * 合同收款记录
	*/
	public static class CONT_CONTRACT_COLLECT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_collect";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT_COLLECT() {
			this.init($NAME,"合同收款记录" , ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_COLLECT $TABLE=new CONT_CONTRACT_COLLECT();
	}
	
	/**
	 * 合同相对方
	*/
	public static class CONT_CONTRACT_COUNTERPARTY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_counterparty";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 法定代表
		*/
		public static final DBField LEGAL_REPRESENTATIVE = new DBField(DBDataType.STRING , "legal_representative","legalRepresentative","法定代表","法定代表",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 类别
		*/
		public static final DBField ENTITY_CLASS = new DBField(DBDataType.STRING , "entity_class","entityClass","类别","类别",false,false,true);
		
		/**
		 * 级别
		*/
		public static final DBField LEVEL = new DBField(DBDataType.STRING , "level","level","级别","级别",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","地址","地址",false,false,true);
		
		/**
		 * 联系人姓名
		*/
		public static final DBField CONTACT_PERSON = new DBField(DBDataType.STRING , "contact_person","contactPerson","联系人姓名","联系人姓名",false,false,true);
		
		/**
		 * 联系人手机
		*/
		public static final DBField CONTACT_PHONE = new DBField(DBDataType.STRING , "contact_phone","contactPhone","联系人手机","联系人手机",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 显示顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","显示顺序","显示顺序",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT_COUNTERPARTY() {
			this.init($NAME,"合同相对方" , ID , NAME , LEGAL_REPRESENTATIVE , TYPE , ENTITY_CLASS , LEVEL , STATUS , ADDRESS , CONTACT_PERSON , CONTACT_PHONE , NOTES , SORT , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_COUNTERPARTY $TABLE=new CONT_CONTRACT_COUNTERPARTY();
	}
	
	/**
	 * 内部主体
	*/
	public static class CONT_CONTRACT_INTERNAL_BODY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_internal_body";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 联系人姓名
		*/
		public static final DBField CONTACT_PERSON = new DBField(DBDataType.STRING , "contact_person","contactPerson","联系人姓名","联系人姓名",false,false,true);
		
		/**
		 * 联系人手机
		*/
		public static final DBField CONTACT_PHONE = new DBField(DBDataType.STRING , "contact_phone","contactPhone","联系人手机","联系人手机",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 显示顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","显示顺序","显示顺序",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT_INTERNAL_BODY() {
			this.init($NAME,"内部主体" , ID , NAME , STATUS , CONTACT_PERSON , CONTACT_PHONE , NOTES , SORT , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_INTERNAL_BODY $TABLE=new CONT_CONTRACT_INTERNAL_BODY();
	}
	
	/**
	 * 发票信息
	*/
	public static class CONT_CONTRACT_INVOICE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_invoice";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 所有者ID
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所有者ID","所有者ID",false,false,true);
		
		/**
		 * 文件ID
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","文件ID","文件ID",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 销售方
		*/
		public static final DBField SELLER = new DBField(DBDataType.STRING , "seller","seller","销售方","销售方",false,false,true);
		
		/**
		 * 发票类型
		*/
		public static final DBField INVOICE_TYPE = new DBField(DBDataType.STRING , "invoice_type","invoiceType","发票类型","发票类型",false,false,true);
		
		/**
		 * 含税价格
		*/
		public static final DBField TAX_PRICE = new DBField(DBDataType.DECIMAL , "tax_price","taxPrice","含税价格","含税价格",false,false,true);
		
		/**
		 * 开盘时间
		*/
		public static final DBField INVOICE_DATE = new DBField(DBDataType.DATE , "invoice_date","invoiceDate","开盘时间","开盘时间",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT_INVOICE() {
			this.init($NAME,"发票信息" , ID , OWNER_ID , FILE_ID , NAME , SELLER , INVOICE_TYPE , TAX_PRICE , INVOICE_DATE , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_INVOICE $TABLE=new CONT_CONTRACT_INVOICE();
	}
	
	/**
	 * 合同标签
	*/
	public static class CONT_CONTRACT_LABEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_label";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public CONT_CONTRACT_LABEL() {
			this.init($NAME,"合同标签" , ID , LABEL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final CONT_CONTRACT_LABEL $TABLE=new CONT_CONTRACT_LABEL();
	}
	
	/**
	 * 合同标签
	*/
	public static class CONT_CONTRACT_LABEL_S extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_label_s";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 合同
		*/
		public static final DBField CONTRACT_ID = new DBField(DBDataType.STRING , "contract_id","contractId","合同","合同",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","标签","标签",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public CONT_CONTRACT_LABEL_S() {
			this.init($NAME,"合同标签" , ID , CONTRACT_ID , LABEL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final CONT_CONTRACT_LABEL_S $TABLE=new CONT_CONTRACT_LABEL_S();
	}
	
	/**
	 * 合同付款记录
	*/
	public static class CONT_CONTRACT_PAY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_pay";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT_PAY() {
			this.init($NAME,"合同付款记录" , ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_PAY $TABLE=new CONT_CONTRACT_PAY();
	}
	
	/**
	 * 合同款项
	*/
	public static class CONT_CONTRACT_PAYMENT_LABEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_payment_label";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 标签
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","标签","标签",false,false,true);
		
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
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","version","version",false,false,true);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public CONT_CONTRACT_PAYMENT_LABEL() {
			this.init($NAME,"合同款项" , ID , CODE , NAME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final CONT_CONTRACT_PAYMENT_LABEL $TABLE=new CONT_CONTRACT_PAYMENT_LABEL();
	}
	
	/**
	 * 履行情况表
	*/
	public static class CONT_CONTRACT_PERFORMANCE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_performance";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 合同名称
		*/
		public static final DBField CONTRACT_ID = new DBField(DBDataType.STRING , "contract_id","contractId","合同名称","合同名称",false,false,true);
		
		/**
		 * 合同编号
		*/
		public static final DBField CONTRACT_NO = new DBField(DBDataType.STRING , "contract_no","contractNo","合同编号","合同编号",false,false,true);
		
		/**
		 * 概述
		*/
		public static final DBField TITLE = new DBField(DBDataType.STRING , "title","title","概述","概述",false,false,true);
		
		/**
		 * 动作
		*/
		public static final DBField ACTION = new DBField(DBDataType.STRING , "action","action","动作","动作",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 款项
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","款项","款项",false,false,true);
		
		/**
		 * 计划日期
		*/
		public static final DBField PLAN_DATE = new DBField(DBDataType.STRING , "plan_date","planDate","计划日期","计划日期",false,false,true);
		
		/**
		 * 实际日期
		*/
		public static final DBField ACT_DATE = new DBField(DBDataType.STRING , "act_date","actDate","实际日期","实际日期",false,false,true);
		
		/**
		 * 履约细节
		*/
		public static final DBField DETAIL = new DBField(DBDataType.STRING , "detail","detail","履约细节","履约细节",false,false,true);
		
		/**
		 * 验收人
		*/
		public static final DBField ACCEPT_USER_ID = new DBField(DBDataType.STRING , "accept_user_id","acceptUserId","验收人","验收人",false,false,true);
		
		/**
		 * 验收类型
		*/
		public static final DBField ACCEPT_LABEL = new DBField(DBDataType.STRING , "accept_label","acceptLabel","验收类型","验收类型",false,false,true);
		
		/**
		 * 是否验收
		*/
		public static final DBField ACCEPT_IF = new DBField(DBDataType.STRING , "accept_if","acceptIf","是否验收","是否验收",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","制单人","制单人",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT_PERFORMANCE() {
			this.init($NAME,"履行情况表" , ID , CONTRACT_ID , CONTRACT_NO , TITLE , ACTION , STATUS , LABEL , PLAN_DATE , ACT_DATE , DETAIL , ACCEPT_USER_ID , ACCEPT_LABEL , ACCEPT_IF , ATTACH , OWNER_ID , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_PERFORMANCE $TABLE=new CONT_CONTRACT_PERFORMANCE();
	}
	
	/**
	 * 签订方列表
	*/
	public static class CONT_CONTRACT_SIGN_ITEM extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_sign_item";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 合同
		*/
		public static final DBField CONTRACT_ID = new DBField(DBDataType.STRING , "contract_id","contractId","合同","合同",false,false,true);
		
		/**
		 * 签订方
		*/
		public static final DBField SIGNER_ID = new DBField(DBDataType.STRING , "signer_id","signerId","签订方","签订方",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT_SIGN_ITEM() {
			this.init($NAME,"签订方列表" , ID , CONTRACT_ID , SIGNER_ID , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_SIGN_ITEM $TABLE=new CONT_CONTRACT_SIGN_ITEM();
	}
	
	/**
	 * 合同签订方
	*/
	public static class CONT_CONTRACT_SIGNER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_signer";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 合同ID
		*/
		public static final DBField CONTRACT_ID = new DBField(DBDataType.STRING , "contract_id","contractId","合同ID","合同ID",false,false,true);
		
		/**
		 * 显示顺序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","显示顺序","显示顺序",false,false,true);
		
		/**
		 * 别名，甲方/乙方等；枚举：SignerAlias
		*/
		public static final DBField ALIAS = new DBField(DBDataType.STRING , "alias","alias","别名","甲方/乙方等；枚举：SignerAlias",false,false,true);
		
		/**
		 * 签订方类型，企业或个人；枚举：SignerType
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","签订方类型","企业或个人；枚举：SignerType",false,false,true);
		
		/**
		 * 唯一代码，统一社会信用代码/身份证号码
		*/
		public static final DBField IDENTITY_CDOE = new DBField(DBDataType.STRING , "identity_cdoe","identityCdoe","唯一代码","统一社会信用代码/身份证号码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 座机号码
		*/
		public static final DBField LANDLINE_NUMBER = new DBField(DBDataType.STRING , "landline_number","landlineNumber","座机号码","座机号码",false,false,true);
		
		/**
		 * 传真号码
		*/
		public static final DBField FAX_NUMBER = new DBField(DBDataType.STRING , "fax_number","faxNumber","传真号码","传真号码",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","地址","地址",false,false,true);
		
		/**
		 * 联系人姓名
		*/
		public static final DBField CONTACT_PERSON = new DBField(DBDataType.STRING , "contact_person","contactPerson","联系人姓名","联系人姓名",false,false,true);
		
		/**
		 * 联系人手机
		*/
		public static final DBField CONTACT_PHONE = new DBField(DBDataType.STRING , "contact_phone","contactPhone","联系人手机","联系人手机",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT_SIGNER() {
			this.init($NAME,"合同签订方" , ID , CONTRACT_ID , SORT , ALIAS , TYPE , IDENTITY_CDOE , NAME , LANDLINE_NUMBER , FAX_NUMBER , ADDRESS , CONTACT_PERSON , CONTACT_PHONE , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_SIGNER $TABLE=new CONT_CONTRACT_SIGNER();
	}
	
	/**
	 * 签订方类型
	*/
	public static class CONT_CONTRACT_SIGNER_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_contract_signer_type";
		
		/**
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","id","id",true,false,false);
		
		/**
		 * 类型
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","类型","类型",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_CONTRACT_SIGNER_TYPE() {
			this.init($NAME,"签订方类型" , ID , NAME , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_CONTRACT_SIGNER_TYPE $TABLE=new CONT_CONTRACT_SIGNER_TYPE();
	}
	
	/**
	 * 开票
	*/
	public static class CONT_INVOICE_OUT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_invoice_out";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 发票状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","发票状态","发票状态",false,false,true);
		
		/**
		 * 所有者
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所有者","所有者",false,false,true);
		
		/**
		 * 组织
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","组织","组织",false,false,true);
		
		/**
		 * 发票类型
		*/
		public static final DBField INVOICE_TYPE = new DBField(DBDataType.STRING , "invoice_type","invoiceType","发票类型","发票类型",false,false,true);
		
		/**
		 * 对应款项
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","对应款项","对应款项",false,false,true);
		
		/**
		 * 发票
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","发票","发票",false,false,true);
		
		/**
		 * 含税价格
		*/
		public static final DBField TAX_PRICE = new DBField(DBDataType.DECIMAL , "tax_price","taxPrice","含税价格","含税价格",false,false,true);
		
		/**
		 * 税额
		*/
		public static final DBField TAX = new DBField(DBDataType.DECIMAL , "tax","tax","税额","税额",false,false,true);
		
		/**
		 * 合同
		*/
		public static final DBField CONTRACT_ID = new DBField(DBDataType.STRING , "contract_id","contractId","合同","合同",false,false,true);
		
		/**
		 * 纳税人识别号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","纳税人识别号","纳税人识别号",false,false,true);
		
		/**
		 * 开票时间
		*/
		public static final DBField INVOICE_DATE = new DBField(DBDataType.DATE , "invoice_date","invoiceDate","开票时间","开票时间",false,false,true);
		
		/**
		 * 币种
		*/
		public static final DBField CURRENCY_TYPE = new DBField(DBDataType.STRING , "currency_type","currencyType","币种","币种",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_INVOICE_OUT() {
			this.init($NAME,"开票" , ID , STATUS , OWNER_ID , ORG_ID , INVOICE_TYPE , LABEL , FILE_ID , TAX_PRICE , TAX , CONTRACT_ID , CODE , INVOICE_DATE , CURRENCY_TYPE , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_INVOICE_OUT $TABLE=new CONT_INVOICE_OUT();
	}
	
	/**
	 * 收票
	*/
	public static class CONT_INVOICE_RECEIVE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "cont_invoice_receive";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 发票状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","发票状态","发票状态",false,false,true);
		
		/**
		 * 所有者
		*/
		public static final DBField OWNER_ID = new DBField(DBDataType.STRING , "owner_id","ownerId","所有者","所有者",false,false,true);
		
		/**
		 * 组织
		*/
		public static final DBField ORG_ID = new DBField(DBDataType.STRING , "org_id","orgId","组织","组织",false,false,true);
		
		/**
		 * 发票类型
		*/
		public static final DBField INVOICE_TYPE = new DBField(DBDataType.STRING , "invoice_type","invoiceType","发票类型","发票类型",false,false,true);
		
		/**
		 * 对应款项
		*/
		public static final DBField LABEL = new DBField(DBDataType.STRING , "label","label","对应款项","对应款项",false,false,true);
		
		/**
		 * 发票
		*/
		public static final DBField FILE_ID = new DBField(DBDataType.STRING , "file_id","fileId","发票","发票",false,false,true);
		
		/**
		 * 含税价格
		*/
		public static final DBField TAX_PRICE = new DBField(DBDataType.DECIMAL , "tax_price","taxPrice","含税价格","含税价格",false,false,true);
		
		/**
		 * 税额
		*/
		public static final DBField TAX = new DBField(DBDataType.DECIMAL , "tax","tax","税额","税额",false,false,true);
		
		/**
		 * 合同
		*/
		public static final DBField CONTRACT_ID = new DBField(DBDataType.STRING , "contract_id","contractId","合同","合同",false,false,true);
		
		/**
		 * 纳税人识别号
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","纳税人识别号","纳税人识别号",false,false,true);
		
		/**
		 * 开票时间
		*/
		public static final DBField INVOICE_DATE = new DBField(DBDataType.DATE , "invoice_date","invoiceDate","开票时间","开票时间",false,false,true);
		
		/**
		 * 币种
		*/
		public static final DBField CURRENCY_TYPE = new DBField(DBDataType.STRING , "currency_type","currencyType","币种","币种",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField NOTES = new DBField(DBDataType.STRING , "notes","notes","备注","备注",false,false,true);
		
		/**
		 * 租户ID
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户ID","租户ID",false,false,true);
		
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
		
		public CONT_INVOICE_RECEIVE() {
			this.init($NAME,"收票" , ID , STATUS , OWNER_ID , ORG_ID , INVOICE_TYPE , LABEL , FILE_ID , TAX_PRICE , TAX , CONTRACT_ID , CODE , INVOICE_DATE , CURRENCY_TYPE , NOTES , TENANT_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION);
		}
		public static final CONT_INVOICE_RECEIVE $TABLE=new CONT_INVOICE_RECEIVE();
	}
}