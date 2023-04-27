package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2022-08-28 12:45:10
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class OaTables {
	
	/**
	 * 车辆信息
	*/
	public static class OA_VEHICLE_INFO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "oa_vehicle_info";
		
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
		public static final DBField VEHICLE_STATUS = new DBField(DBDataType.STRING , "vehicle_status","vehicleStatus","状态","状态",false,false,true);
		
		/**
		 * 车辆类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","车辆类型","车辆类型",false,false,true);
		
		/**
		 * 车牌号
		*/
		public static final DBField VEHICLE_CODE = new DBField(DBDataType.STRING , "vehicle_code","vehicleCode","车牌号","车牌号",false,false,true);
		
		/**
		 * 品牌型号
		*/
		public static final DBField MODEL = new DBField(DBDataType.STRING , "model","model","品牌型号","品牌型号",false,false,true);
		
		/**
		 * 登记人
		*/
		public static final DBField REGISTRANT = new DBField(DBDataType.STRING , "registrant","registrant","登记人","登记人",false,false,true);
		
		/**
		 * 所属组织
		*/
		public static final DBField OWNER_ORG_ID = new DBField(DBDataType.STRING , "owner_org_id","ownerOrgId","所属组织","所属组织",false,false,true);
		
		/**
		 * 使用部门
		*/
		public static final DBField USE_ORG_ID = new DBField(DBDataType.STRING , "use_org_id","useOrgId","使用部门","使用部门",false,false,true);
		
		/**
		 * 使用人
		*/
		public static final DBField USE_USER_ID = new DBField(DBDataType.STRING , "use_user_id","useUserId","使用人","使用人",false,false,true);
		
		/**
		 * 颜色
		*/
		public static final DBField COLOR = new DBField(DBDataType.STRING , "color","color","颜色","颜色",false,false,true);
		
		/**
		 * 发动机号
		*/
		public static final DBField ENGINE_NUMBER = new DBField(DBDataType.STRING , "engine_number","engineNumber","发动机号","发动机号",false,false,true);
		
		/**
		 * 车架号
		*/
		public static final DBField FRAME_NUMBER = new DBField(DBDataType.STRING , "frame_number","frameNumber","车架号","车架号",false,false,true);
		
		/**
		 * 行驶证
		*/
		public static final DBField DRIVING_LICENSE = new DBField(DBDataType.STRING , "driving_license","drivingLicense","行驶证","行驶证",false,false,true);
		
		/**
		 * 公里数
		*/
		public static final DBField KILOMETERS = new DBField(DBDataType.DECIMAL , "kilometers","kilometers","公里数","公里数",false,false,true);
		
		/**
		 * 车船税
		*/
		public static final DBField CAR_BOAT_TAX = new DBField(DBDataType.DECIMAL , "car_boat_tax","carBoatTax","车船税","车船税",false,false,true);
		
		/**
		 * 抢险(元)
		*/
		public static final DBField RESCUE_MONEY = new DBField(DBDataType.DECIMAL , "rescue_money","rescueMoney","抢险(元)","抢险(元)",false,false,true);
		
		/**
		 * 商业险(元)
		*/
		public static final DBField COMMERCIAL_INSURANCE_MONEY = new DBField(DBDataType.DECIMAL , "commercial_insurance_money","commercialInsuranceMoney","商业险(元)","商业险(元)",false,false,true);
		
		/**
		 * 保险公司
		*/
		public static final DBField INSURANCE_COMPANY = new DBField(DBDataType.STRING , "insurance_company","insuranceCompany","保险公司","保险公司",false,false,true);
		
		/**
		 * 上牌时间
		*/
		public static final DBField LICENSING_TIME = new DBField(DBDataType.DATE , "licensing_time","licensingTime","上牌时间","上牌时间",false,false,true);
		
		/**
		 * 商业险到期
		*/
		public static final DBField INSURANCE_EXPIRE_DATE = new DBField(DBDataType.DATE , "insurance_expire_date","insuranceExpireDate","商业险到期","商业险到期",false,false,true);
		
		/**
		 * 抢险到期
		*/
		public static final DBField RESCUE_DUE_DATE = new DBField(DBDataType.DATE , "rescue_due_date","rescueDueDate","抢险到期","抢险到期",false,false,true);
		
		/**
		 * 版本
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","版本","版本",false,false,false);
		
		/**
		 * 报废时间
		*/
		public static final DBField SCRAP_TIME = new DBField(DBDataType.DATE , "scrap_time","scrapTime","报废时间","报废时间",false,false,true);
		
		/**
		 * 存放位置
		*/
		public static final DBField POSITION_DETAIL = new DBField(DBDataType.STRING , "position_detail","positionDetail","存放位置","存放位置",false,false,true);
		
		/**
		 * 图片
		*/
		public static final DBField PICTURES = new DBField(DBDataType.STRING , "pictures","pictures","图片","图片",false,false,true);
		
		/**
		 * 制单人
		*/
		public static final DBField ORIGINATOR_ID = new DBField(DBDataType.STRING , "originator_id","originatorId","制单人","制单人",false,false,true);
		
		/**
		 * 技术参数
		*/
		public static final DBField TECHNICAL_PARAMETER = new DBField(DBDataType.STRING , "technical_parameter","technicalParameter","技术参数","技术参数",false,false,true);
		
		/**
		 * 数量
		*/
		public static final DBField VEHICLE_COUNT = new DBField(DBDataType.INTEGER , "vehicle_count","vehicleCount","数量","数量",false,false,true);
		
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
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public OA_VEHICLE_INFO() {
			this.init($NAME,"车辆信息" , ID , NAME , VEHICLE_STATUS , TYPE , VEHICLE_CODE , MODEL , REGISTRANT , OWNER_ORG_ID , USE_ORG_ID , USE_USER_ID , COLOR , ENGINE_NUMBER , FRAME_NUMBER , DRIVING_LICENSE , KILOMETERS , CAR_BOAT_TAX , RESCUE_MONEY , COMMERCIAL_INSURANCE_MONEY , INSURANCE_COMPANY , LICENSING_TIME , INSURANCE_EXPIRE_DATE , RESCUE_DUE_DATE , VERSION , SCRAP_TIME , POSITION_DETAIL , PICTURES , ORIGINATOR_ID , TECHNICAL_PARAMETER , VEHICLE_COUNT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID);
		}
		public static final OA_VEHICLE_INFO $TABLE=new OA_VEHICLE_INFO();
	}
}