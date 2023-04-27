package com.dt.platform.constants.db;

import com.github.foxnic.sql.meta.DBField;
import com.github.foxnic.sql.meta.DBTable;
import com.github.foxnic.sql.meta.DBDataType;



/**
 * @since 2023-03-04 14:25:28
 * @author 金杰 , maillank@qq.com
 * 数据库描述文件
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成。
*/

public class WmsTables {
	
	/**
	 * 片区
	*/
	public static class WMS_AREA extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_area";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_AREA() {
			this.init($NAME,"片区" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_AREA $TABLE=new WMS_AREA();
	}
	
	/**
	 * 地区信息
	*/
	public static class WMS_AREA_INFO extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_area_info";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField AREA_INFO_CODE = new DBField(DBDataType.STRING , "area_info_code","areaInfoCode","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 城市类型
		*/
		public static final DBField CITY_TYPE = new DBField(DBDataType.STRING , "city_type","cityType","城市类型","城市类型",false,false,true);
		
		/**
		 * 大区
		*/
		public static final DBField REGION = new DBField(DBDataType.STRING , "region","region","大区","大区",false,false,true);
		
		/**
		 * 片区
		*/
		public static final DBField AREA = new DBField(DBDataType.STRING , "area","area","片区","片区",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_AREA_INFO() {
			this.init($NAME,"地区信息" , ID , AREA_INFO_CODE , NAME , CITY_TYPE , REGION , AREA , STATUS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_AREA_INFO $TABLE=new WMS_AREA_INFO();
	}
	
	/**
	 * 业务类型
	*/
	public static class WMS_BUSINESS_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_business_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_BUSINESS_TYPE() {
			this.init($NAME,"业务类型" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_BUSINESS_TYPE $TABLE=new WMS_BUSINESS_TYPE();
	}
	
	/**
	 * 车辆管理
	*/
	public static class WMS_CAR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_car";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 车号
		*/
		public static final DBField CAR_NUMBER = new DBField(DBDataType.STRING , "car_number","carNumber","车号","车号",false,false,true);
		
		/**
		 * 车型
		*/
		public static final DBField CAR_MODEL = new DBField(DBDataType.STRING , "car_model","carModel","车型","车型",false,false,true);
		
		/**
		 * 最大载重
		*/
		public static final DBField MAX_WEIGHT = new DBField(DBDataType.DECIMAL , "max_weight","maxWeight","最大载重","最大载重",false,false,true);
		
		/**
		 * 最大体积
		*/
		public static final DBField MAX_VOLUMN = new DBField(DBDataType.DECIMAL , "max_volumn","maxVolumn","最大体积","最大体积",false,false,true);
		
		/**
		 * 载人数
		*/
		public static final DBField MAX_PEOPLE = new DBField(DBDataType.DECIMAL , "max_people","maxPeople","载人数","载人数",false,false,true);
		
		/**
		 * 驾照
		*/
		public static final DBField DRIVE_NUMBER = new DBField(DBDataType.STRING , "drive_number","driveNumber","驾照","驾照",false,false,true);
		
		/**
		 * 姓名
		*/
		public static final DBField USER = new DBField(DBDataType.STRING , "user","user","姓名","姓名",false,false,true);
		
		/**
		 * 联系方式
		*/
		public static final DBField MOBILE = new DBField(DBDataType.STRING , "mobile","mobile","联系方式","联系方式",false,false,true);
		
		/**
		 * 车牌
		*/
		public static final DBField CAR_VALUE = new DBField(DBDataType.STRING , "car_value","carValue","车牌","车牌",false,false,true);
		
		/**
		 * 区域
		*/
		public static final DBField AREA = new DBField(DBDataType.STRING , "area","area","区域","区域",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_CAR() {
			this.init($NAME,"车辆管理" , ID , CAR_NUMBER , CAR_MODEL , MAX_WEIGHT , MAX_VOLUMN , MAX_PEOPLE , DRIVE_NUMBER , USER , MOBILE , CAR_VALUE , AREA , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_CAR $TABLE=new WMS_CAR();
	}
	
	/**
	 * 城市类型
	*/
	public static class WMS_CITY_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_city_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_CITY_TYPE() {
			this.init($NAME,"城市类型" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_CITY_TYPE $TABLE=new WMS_CITY_TYPE();
	}
	
	/**
	 * 企业属性
	*/
	public static class WMS_COMPANY_ATTR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_company_attr";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_COMPANY_ATTR() {
			this.init($NAME,"企业属性" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_COMPANY_ATTR $TABLE=new WMS_COMPANY_ATTR();
	}
	
	/**
	 * 企业等级
	*/
	public static class WMS_COMPANY_LEVEL extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_company_level";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 排序
		*/
		public static final DBField SORT = new DBField(DBDataType.INTEGER , "sort","sort","排序","排序",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_COMPANY_LEVEL() {
			this.init($NAME,"企业等级" , ID , CODE , NAME , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_COMPANY_LEVEL $TABLE=new WMS_COMPANY_LEVEL();
	}
	
	/**
	 * 企业状态
	*/
	public static class WMS_COMPANY_STATUS extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_company_status";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_COMPANY_STATUS() {
			this.init($NAME,"企业状态" , ID , CODE , NAME , STATUS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_COMPANY_STATUS $TABLE=new WMS_COMPANY_STATUS();
	}
	
	/**
	 * 行业信息
	*/
	public static class WMS_COMPANY_TRADE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_company_trade";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_COMPANY_TRADE() {
			this.init($NAME,"行业信息" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_COMPANY_TRADE $TABLE=new WMS_COMPANY_TRADE();
	}
	
	/**
	 * 客户
	*/
	public static class WMS_CUSTOMER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_customer";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 企业属性
		*/
		public static final DBField COMPANY_ATTR = new DBField(DBDataType.STRING , "company_attr","companyAttr","企业属性","企业属性",false,false,true);
		
		/**
		 * 属性
		*/
		public static final DBField ATTR = new DBField(DBDataType.STRING , "attr","attr","属性","属性",false,false,true);
		
		/**
		 * 出库计费
		*/
		public static final DBField BILLING_METHOD = new DBField(DBDataType.STRING , "billing_method","billingMethod","出库计费","出库计费",false,false,true);
		
		/**
		 * 合同号
		*/
		public static final DBField CONTRACT_NUMBER = new DBField(DBDataType.STRING , "contract_number","contractNumber","合同号","合同号",false,false,true);
		
		/**
		 * 负责人
		*/
		public static final DBField BUSINESS_CONTACTS = new DBField(DBDataType.STRING , "business_contacts","businessContacts","负责人","负责人",false,false,true);
		
		/**
		 * 联系人
		*/
		public static final DBField CONTACT_INFORMATION = new DBField(DBDataType.STRING , "contact_information","contactInformation","联系人","联系人",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","地址","地址",false,false,true);
		
		/**
		 * 附件
		*/
		public static final DBField ATTACH = new DBField(DBDataType.STRING , "attach","attach","附件","附件",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_CUSTOMER() {
			this.init($NAME,"客户" , ID , CODE , NAME , COMPANY_ATTR , ATTR , BILLING_METHOD , CONTRACT_NUMBER , BUSINESS_CONTACTS , CONTACT_INFORMATION , ADDRESS , ATTACH , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_CUSTOMER $TABLE=new WMS_CUSTOMER();
	}
	
	/**
	 * 提货方式
	*/
	public static class WMS_DELIVERY_METHOD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_delivery_method";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_DELIVERY_METHOD() {
			this.init($NAME,"提货方式" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_DELIVERY_METHOD $TABLE=new WMS_DELIVERY_METHOD();
	}
	
	/**
	 * 库位类型
	*/
	public static class WMS_LOC_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_loc_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_LOC_TYPE() {
			this.init($NAME,"库位类型" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_LOC_TYPE $TABLE=new WMS_LOC_TYPE();
	}
	
	/**
	 * 操作类型
	*/
	public static class WMS_OPER_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_oper_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_OPER_TYPE() {
			this.init($NAME,"操作类型" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_OPER_TYPE $TABLE=new WMS_OPER_TYPE();
	}
	
	/**
	 * 订单类型
	*/
	public static class WMS_ORDER_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_order_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_ORDER_TYPE() {
			this.init($NAME,"订单类型" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_ORDER_TYPE $TABLE=new WMS_ORDER_TYPE();
	}
	
	/**
	 * 商品
	*/
	public static class WMS_PRODUCT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_product";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 条形码
		*/
		public static final DBField BAR_CODE = new DBField(DBDataType.STRING , "bar_code","barCode","条形码","条形码",false,false,true);
		
		/**
		 * 货主
		*/
		public static final DBField CUST_ID = new DBField(DBDataType.STRING , "cust_id","custId","货主","货主",false,false,true);
		
		/**
		 * 客户商品编码
		*/
		public static final DBField CUST_PRODUCT_CODE = new DBField(DBDataType.STRING , "cust_product_code","custProductCode","客户商品编码","客户商品编码",false,false,true);
		
		/**
		 * 商品规格
		*/
		public static final DBField PRODUCT_MODEL = new DBField(DBDataType.STRING , "product_model","productModel","商品规格","商品规格",false,false,true);
		
		/**
		 * 商品品牌
		*/
		public static final DBField PRODUCT_BRAND = new DBField(DBDataType.STRING , "product_brand","productBrand","商品品牌","商品品牌",false,false,true);
		
		/**
		 * 商品SKU
		*/
		public static final DBField PRODUCT_SKU = new DBField(DBDataType.STRING , "product_sku","productSku","商品SKU","商品SKU",false,false,true);
		
		/**
		 * 大类
		*/
		public static final DBField CATEGORY = new DBField(DBDataType.STRING , "category","category","大类","大类",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 英文名称
		*/
		public static final DBField EN_NAME = new DBField(DBDataType.STRING , "en_name","enName","英文名称","英文名称",false,false,true);
		
		/**
		 * 单位
		*/
		public static final DBField UNIT = new DBField(DBDataType.STRING , "unit","unit","单位","单位",false,false,true);
		
		/**
		 * 长
		*/
		public static final DBField LENGTH = new DBField(DBDataType.DECIMAL , "length","length","长","长",false,false,true);
		
		/**
		 * 宽
		*/
		public static final DBField WIDTH = new DBField(DBDataType.DECIMAL , "width","width","宽","宽",false,false,true);
		
		/**
		 * 高
		*/
		public static final DBField HEIGHT = new DBField(DBDataType.DECIMAL , "height","height","高","高",false,false,true);
		
		/**
		 * 最大体积
		*/
		public static final DBField MAX_VOLUME = new DBField(DBDataType.DECIMAL , "max_volume","maxVolume","最大体积","最大体积",false,false,true);
		
		/**
		 * 最大重量
		*/
		public static final DBField MAX_WEIGHT = new DBField(DBDataType.DECIMAL , "max_weight","maxWeight","最大重量","最大重量",false,false,true);
		
		/**
		 * 保质期
		*/
		public static final DBField PERIOD = new DBField(DBDataType.DECIMAL , "period","period","保质期","保质期",false,false,true);
		
		/**
		 * 允收天数
		*/
		public static final DBField KEEP_DATE = new DBField(DBDataType.DECIMAL , "keep_date","keepDate","允收天数","允收天数",false,false,true);
		
		/**
		 * 最小库存数量
		*/
		public static final DBField MIN_STOCK_NUMBER = new DBField(DBDataType.DECIMAL , "min_stock_number","minStockNumber","最小库存数量","最小库存数量",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_PRODUCT() {
			this.init($NAME,"商品" , ID , CODE , BAR_CODE , CUST_ID , CUST_PRODUCT_CODE , PRODUCT_MODEL , PRODUCT_BRAND , PRODUCT_SKU , CATEGORY , NAME , EN_NAME , UNIT , LENGTH , WIDTH , HEIGHT , MAX_VOLUME , MAX_WEIGHT , PERIOD , KEEP_DATE , MIN_STOCK_NUMBER , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_PRODUCT $TABLE=new WMS_PRODUCT();
	}
	
	/**
	 * 产品属性
	*/
	public static class WMS_PRODUCT_ATTR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_product_attr";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_PRODUCT_ATTR() {
			this.init($NAME,"产品属性" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_PRODUCT_ATTR $TABLE=new WMS_PRODUCT_ATTR();
	}
	
	/**
	 * 商品分类
	*/
	public static class WMS_PRODUCT_CATEGORY extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_product_category";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 名称
		*/
		public static final DBField CATEGORY_NAME = new DBField(DBDataType.STRING , "category_name","categoryName","名称","名称",false,false,true);
		
		/**
		 * 具体名称
		*/
		public static final DBField CATEGORY_FULLNAME = new DBField(DBDataType.STRING , "category_fullname","categoryFullname","具体名称","具体名称",false,false,true);
		
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
		
		public WMS_PRODUCT_CATEGORY() {
			this.init($NAME,"商品分类" , ID , CATEGORY_NAME , CATEGORY_FULLNAME , CATEGORY_CODE , PARENT_ID , SORT , HIERARCHY , HIERARCHY_NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_PRODUCT_CATEGORY $TABLE=new WMS_PRODUCT_CATEGORY();
	}
	
	/**
	 * 接货方式
	*/
	public static class WMS_RECEIVE_METHOD extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_receive_method";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_RECEIVE_METHOD() {
			this.init($NAME,"接货方式" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_RECEIVE_METHOD $TABLE=new WMS_RECEIVE_METHOD();
	}
	
	/**
	 * 大区
	*/
	public static class WMS_REGION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_region";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_REGION() {
			this.init($NAME,"大区" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_REGION $TABLE=new WMS_REGION();
	}
	
	/**
	 * 仓库
	*/
	public static class WMS_STOREHOUSE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_storehouse";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_STOREHOUSE() {
			this.init($NAME,"仓库" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_STOREHOUSE $TABLE=new WMS_STOREHOUSE();
	}
	
	/**
	 * 仓库属性
	*/
	public static class WMS_STOREHOUSE_ATTR_V extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_storehouse_attr_v";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 仓库
		*/
		public static final DBField STORE_ID = new DBField(DBDataType.STRING , "store_id","storeId","仓库","仓库",false,false,true);
		
		/**
		 * 属性
		*/
		public static final DBField ATTR_ID = new DBField(DBDataType.STRING , "attr_id","attrId","属性","属性",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_STOREHOUSE_ATTR_V() {
			this.init($NAME,"仓库属性" , ID , STORE_ID , ATTR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_STOREHOUSE_ATTR_V $TABLE=new WMS_STOREHOUSE_ATTR_V();
	}
	
	/**
	 * 储位
	*/
	public static class WMS_STORELOCATION extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_storelocation";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 仓库
		*/
		public static final DBField STOREHOUSE_ID = new DBField(DBDataType.STRING , "storehouse_id","storehouseId","仓库","仓库",false,false,true);
		
		/**
		 * 所属客户
		*/
		public static final DBField CUSTOMER_ID = new DBField(DBDataType.STRING , "customer_id","customerId","所属客户","所属客户",false,false,true);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 条码
		*/
		public static final DBField BAR_CODE = new DBField(DBDataType.STRING , "bar_code","barCode","条码","条码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
		/**
		 * 状态
		*/
		public static final DBField STATUS = new DBField(DBDataType.STRING , "status","status","状态","状态",false,false,true);
		
		/**
		 * 类型
		*/
		public static final DBField TYPE = new DBField(DBDataType.STRING , "type","type","类型","类型",false,false,true);
		
		/**
		 * 仓库组
		*/
		public static final DBField LOCATION_GROUP = new DBField(DBDataType.STRING , "location_group","locationGroup","仓库组","仓库组",false,false,true);
		
		/**
		 * 库位属性
		*/
		public static final DBField LOCATION_ATTRIBUTE = new DBField(DBDataType.STRING , "location_attribute","locationAttribute","库位属性","库位属性",false,false,true);
		
		/**
		 * RFID标签
		*/
		public static final DBField RFID = new DBField(DBDataType.STRING , "rfid","rfid","RFID标签","RFID标签",false,false,true);
		
		/**
		 * 长
		*/
		public static final DBField LENGTH = new DBField(DBDataType.DECIMAL , "length","length","长","长",false,false,true);
		
		/**
		 * 宽
		*/
		public static final DBField WIDTH = new DBField(DBDataType.DECIMAL , "width","width","宽","宽",false,false,true);
		
		/**
		 * 高
		*/
		public static final DBField HEIGHT = new DBField(DBDataType.DECIMAL , "height","height","高","高",false,false,true);
		
		/**
		 * 最大体积
		*/
		public static final DBField MAX_VOLUME = new DBField(DBDataType.DECIMAL , "max_volume","maxVolume","最大体积","最大体积",false,false,true);
		
		/**
		 * 最大重量
		*/
		public static final DBField MAX_WEIGHT = new DBField(DBDataType.DECIMAL , "max_weight","maxWeight","最大重量","最大重量",false,false,true);
		
		/**
		 * 最小批量
		*/
		public static final DBField MIN_BATCH = new DBField(DBDataType.DECIMAL , "min_batch","minBatch","最小批量","最小批量",false,false,true);
		
		/**
		 * 最大批量
		*/
		public static final DBField MAX_BATCH = new DBField(DBDataType.DECIMAL , "max_batch","maxBatch","最大批量","最大批量",false,false,true);
		
		/**
		 * X坐标
		*/
		public static final DBField X_COORDINATE = new DBField(DBDataType.DECIMAL , "x_coordinate","xCoordinate","X坐标","X坐标",false,false,true);
		
		/**
		 * Y坐标
		*/
		public static final DBField Y_COORDINATE = new DBField(DBDataType.DECIMAL , "y_coordinate","yCoordinate","Y坐标","Y坐标",false,false,true);
		
		/**
		 * Z坐标
		*/
		public static final DBField Z_COORDINATE = new DBField(DBDataType.DECIMAL , "z_coordinate","zCoordinate","Z坐标","Z坐标",false,false,true);
		
		/**
		 * 备注1
		*/
		public static final DBField NOTES1 = new DBField(DBDataType.STRING , "notes1","notes1","备注1","备注1",false,false,true);
		
		/**
		 * 备注2
		*/
		public static final DBField NOTES2 = new DBField(DBDataType.STRING , "notes2","notes2","备注2","备注2",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_STORELOCATION() {
			this.init($NAME,"储位" , ID , STOREHOUSE_ID , CUSTOMER_ID , CODE , BAR_CODE , NAME , STATUS , TYPE , LOCATION_GROUP , LOCATION_ATTRIBUTE , RFID , LENGTH , WIDTH , HEIGHT , MAX_VOLUME , MAX_WEIGHT , MIN_BATCH , MAX_BATCH , X_COORDINATE , Y_COORDINATE , Z_COORDINATE , NOTES1 , NOTES2 , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_STORELOCATION $TABLE=new WMS_STORELOCATION();
	}
	
	/**
	 * 供应商
	*/
	public static class WMS_SUPPLIER extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_supplier";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField SUPPLIER_NAME = new DBField(DBDataType.STRING , "supplier_name","supplierName","名称","名称",false,false,true);
		
		/**
		 * 企业属性
		*/
		public static final DBField COMPANY_TYPE = new DBField(DBDataType.STRING , "company_type","companyType","企业属性","企业属性",false,false,true);
		
		/**
		 * 商务联系人
		*/
		public static final DBField BUSINESS_CONTACTS = new DBField(DBDataType.STRING , "business_contacts","businessContacts","商务联系人","商务联系人",false,false,true);
		
		/**
		 * 评级
		*/
		public static final DBField GRADE = new DBField(DBDataType.STRING , "grade","grade","评级","评级",false,false,true);
		
		/**
		 * 商务联系方式
		*/
		public static final DBField BUSINESS_CONTACTS_INFO = new DBField(DBDataType.STRING , "business_contacts_info","businessContactsInfo","商务联系方式","商务联系方式",false,false,true);
		
		/**
		 * 售后联系人
		*/
		public static final DBField AFTER_SALES_CONTACTS = new DBField(DBDataType.STRING , "after_sales_contacts","afterSalesContacts","售后联系人","售后联系人",false,false,true);
		
		/**
		 * 售后联系方式
		*/
		public static final DBField AFTER_SALES_CONTACTS_INFO = new DBField(DBDataType.STRING , "after_sales_contacts_info","afterSalesContactsInfo","售后联系方式","售后联系方式",false,false,true);
		
		/**
		 * 统一社会信用代码
		*/
		public static final DBField UNIT_CODE = new DBField(DBDataType.STRING , "unit_code","unitCode","统一社会信用代码","统一社会信用代码",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","地址","地址",false,false,true);
		
		/**
		 * 备注
		*/
		public static final DBField SUPPLIER_NOTES = new DBField(DBDataType.STRING , "supplier_notes","supplierNotes","备注","备注",false,false,true);
		
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
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_SUPPLIER() {
			this.init($NAME,"供应商" , ID , CODE , SUPPLIER_NAME , COMPANY_TYPE , BUSINESS_CONTACTS , GRADE , BUSINESS_CONTACTS_INFO , AFTER_SALES_CONTACTS , AFTER_SALES_CONTACTS_INFO , UNIT_CODE , ADDRESS , SUPPLIER_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_SUPPLIER $TABLE=new WMS_SUPPLIER();
	}
	
	/**
	 * 温度属性
	*/
	public static class WMS_TEMPERATURE_ATTRIBUTE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_temperature_attribute";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_TEMPERATURE_ATTRIBUTE() {
			this.init($NAME,"温度属性" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_TEMPERATURE_ATTRIBUTE $TABLE=new WMS_TEMPERATURE_ATTRIBUTE();
	}
	
	/**
	 * 地址管理
	*/
	public static class WMS_TRANSPORT_ADDR extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_transport_addr";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 用户
		*/
		public static final DBField USER = new DBField(DBDataType.STRING , "user","user","用户","用户",false,false,true);
		
		/**
		 * 联系人
		*/
		public static final DBField CONTACT = new DBField(DBDataType.STRING , "contact","contact","联系人","联系人",false,false,true);
		
		/**
		 * 联系电话
		*/
		public static final DBField MOBILE = new DBField(DBDataType.STRING , "mobile","mobile","联系电话","联系电话",false,false,true);
		
		/**
		 * 地址
		*/
		public static final DBField ADDRESS = new DBField(DBDataType.STRING , "address","address","地址","地址",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_TRANSPORT_ADDR() {
			this.init($NAME,"地址管理" , ID , USER , CONTACT , MOBILE , ADDRESS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_TRANSPORT_ADDR $TABLE=new WMS_TRANSPORT_ADDR();
	}
	
	/**
	 * 计量单位
	*/
	public static class WMS_UNIT extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_unit";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_UNIT() {
			this.init($NAME,"计量单位" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_UNIT $TABLE=new WMS_UNIT();
	}
	
	/**
	 * 作业类型
	*/
	public static class WMS_WORK_TYPE extends DBTable {
		
		/**
		 * 表名
		*/
		public static final String $NAME = "wms_work_type";
		
		/**
		 * 主键
		*/
		public static final DBField ID = new DBField(DBDataType.STRING , "id","id","主键","主键",true,false,false);
		
		/**
		 * 编码
		*/
		public static final DBField CODE = new DBField(DBDataType.STRING , "code","code","编码","编码",false,false,true);
		
		/**
		 * 名称
		*/
		public static final DBField NAME = new DBField(DBDataType.STRING , "name","name","名称","名称",false,false,true);
		
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
		 * 数据版本号
		*/
		public static final DBField VERSION = new DBField(DBDataType.INTEGER , "version","version","数据版本号","数据版本号",false,false,false);
		
		/**
		 * 租户
		*/
		public static final DBField TENANT_ID = new DBField(DBDataType.STRING , "tenant_id","tenantId","租户","租户",false,false,true);
		
		public WMS_WORK_TYPE() {
			this.init($NAME,"作业类型" , ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID);
		}
		public static final WMS_WORK_TYPE $TABLE=new WMS_WORK_TYPE();
	}
}