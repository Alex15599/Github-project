package com.dt.platform.domain.oa.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.oa.VehicleInfo;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-28 13:01:06
 * @sign 8AA383AB2132A8C19529514AF830D67F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class VehicleInfoMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String VEHICLE_STATUS="vehicleStatus";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> VEHICLE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,VEHICLE_STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 车辆类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 车辆类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,TYPE, java.lang.String.class, "车辆类型", "车辆类型", java.lang.String.class, null);
	
	/**
	 * 车牌号 , 类型: java.lang.String
	*/
	public static final String VEHICLE_CODE="vehicleCode";
	
	/**
	 * 车牌号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> VEHICLE_CODE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,VEHICLE_CODE, java.lang.String.class, "车牌号", "车牌号", java.lang.String.class, null);
	
	/**
	 * 品牌型号 , 类型: java.lang.String
	*/
	public static final String MODEL="model";
	
	/**
	 * 品牌型号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> MODEL_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,MODEL, java.lang.String.class, "品牌型号", "品牌型号", java.lang.String.class, null);
	
	/**
	 * 登记人 , 类型: java.lang.String
	*/
	public static final String REGISTRANT="registrant";
	
	/**
	 * 登记人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> REGISTRANT_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,REGISTRANT, java.lang.String.class, "登记人", "登记人", java.lang.String.class, null);
	
	/**
	 * 所属组织 , 类型: java.lang.String
	*/
	public static final String OWNER_ORG_ID="ownerOrgId";
	
	/**
	 * 所属组织 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> OWNER_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,OWNER_ORG_ID, java.lang.String.class, "所属组织", "所属组织", java.lang.String.class, null);
	
	/**
	 * 使用部门 , 类型: java.lang.String
	*/
	public static final String USE_ORG_ID="useOrgId";
	
	/**
	 * 使用部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> USE_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,USE_ORG_ID, java.lang.String.class, "使用部门", "使用部门", java.lang.String.class, null);
	
	/**
	 * 使用人 , 类型: java.lang.String
	*/
	public static final String USE_USER_ID="useUserId";
	
	/**
	 * 使用人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> USE_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,USE_USER_ID, java.lang.String.class, "使用人", "使用人", java.lang.String.class, null);
	
	/**
	 * 颜色 , 类型: java.lang.String
	*/
	public static final String COLOR="color";
	
	/**
	 * 颜色 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> COLOR_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,COLOR, java.lang.String.class, "颜色", "颜色", java.lang.String.class, null);
	
	/**
	 * 发动机号 , 类型: java.lang.String
	*/
	public static final String ENGINE_NUMBER="engineNumber";
	
	/**
	 * 发动机号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> ENGINE_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,ENGINE_NUMBER, java.lang.String.class, "发动机号", "发动机号", java.lang.String.class, null);
	
	/**
	 * 车架号 , 类型: java.lang.String
	*/
	public static final String FRAME_NUMBER="frameNumber";
	
	/**
	 * 车架号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> FRAME_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,FRAME_NUMBER, java.lang.String.class, "车架号", "车架号", java.lang.String.class, null);
	
	/**
	 * 行驶证 , 类型: java.lang.String
	*/
	public static final String DRIVING_LICENSE="drivingLicense";
	
	/**
	 * 行驶证 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> DRIVING_LICENSE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,DRIVING_LICENSE, java.lang.String.class, "行驶证", "行驶证", java.lang.String.class, null);
	
	/**
	 * 公里数 , 类型: java.math.BigDecimal
	*/
	public static final String KILOMETERS="kilometers";
	
	/**
	 * 公里数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.math.BigDecimal> KILOMETERS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,KILOMETERS, java.math.BigDecimal.class, "公里数", "公里数", java.math.BigDecimal.class, null);
	
	/**
	 * 车船税 , 类型: java.math.BigDecimal
	*/
	public static final String CAR_BOAT_TAX="carBoatTax";
	
	/**
	 * 车船税 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.math.BigDecimal> CAR_BOAT_TAX_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,CAR_BOAT_TAX, java.math.BigDecimal.class, "车船税", "车船税", java.math.BigDecimal.class, null);
	
	/**
	 * 抢险(元) , 类型: java.math.BigDecimal
	*/
	public static final String RESCUE_MONEY="rescueMoney";
	
	/**
	 * 抢险(元) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.math.BigDecimal> RESCUE_MONEY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,RESCUE_MONEY, java.math.BigDecimal.class, "抢险(元)", "抢险(元)", java.math.BigDecimal.class, null);
	
	/**
	 * 商业险(元) , 类型: java.math.BigDecimal
	*/
	public static final String COMMERCIAL_INSURANCE_MONEY="commercialInsuranceMoney";
	
	/**
	 * 商业险(元) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.math.BigDecimal> COMMERCIAL_INSURANCE_MONEY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,COMMERCIAL_INSURANCE_MONEY, java.math.BigDecimal.class, "商业险(元)", "商业险(元)", java.math.BigDecimal.class, null);
	
	/**
	 * 保险公司 , 类型: java.lang.String
	*/
	public static final String INSURANCE_COMPANY="insuranceCompany";
	
	/**
	 * 保险公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> INSURANCE_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,INSURANCE_COMPANY, java.lang.String.class, "保险公司", "保险公司", java.lang.String.class, null);
	
	/**
	 * 上牌时间 , 类型: java.util.Date
	*/
	public static final String LICENSING_TIME="licensingTime";
	
	/**
	 * 上牌时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.util.Date> LICENSING_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,LICENSING_TIME, java.util.Date.class, "上牌时间", "上牌时间", java.util.Date.class, null);
	
	/**
	 * 商业险到期 , 类型: java.util.Date
	*/
	public static final String INSURANCE_EXPIRE_DATE="insuranceExpireDate";
	
	/**
	 * 商业险到期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.util.Date> INSURANCE_EXPIRE_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,INSURANCE_EXPIRE_DATE, java.util.Date.class, "商业险到期", "商业险到期", java.util.Date.class, null);
	
	/**
	 * 抢险到期 , 类型: java.util.Date
	*/
	public static final String RESCUE_DUE_DATE="rescueDueDate";
	
	/**
	 * 抢险到期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.util.Date> RESCUE_DUE_DATE_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,RESCUE_DUE_DATE, java.util.Date.class, "抢险到期", "抢险到期", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 报废时间 , 类型: java.util.Date
	*/
	public static final String SCRAP_TIME="scrapTime";
	
	/**
	 * 报废时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.util.Date> SCRAP_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,SCRAP_TIME, java.util.Date.class, "报废时间", "报废时间", java.util.Date.class, null);
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final String POSITION_DETAIL="positionDetail";
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> POSITION_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,POSITION_DETAIL, java.lang.String.class, "存放位置", "存放位置", java.lang.String.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURES="pictures";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> PICTURES_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,PICTURES, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 技术参数 , 类型: java.lang.String
	*/
	public static final String TECHNICAL_PARAMETER="technicalParameter";
	
	/**
	 * 技术参数 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> TECHNICAL_PARAMETER_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,TECHNICAL_PARAMETER, java.lang.String.class, "技术参数", "技术参数", java.lang.String.class, null);
	
	/**
	 * 数量 , 类型: java.lang.Integer
	*/
	public static final String VEHICLE_COUNT="vehicleCount";
	
	/**
	 * 数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.Integer> VEHICLE_COUNT_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,VEHICLE_COUNT, java.lang.Integer.class, "数量", "数量", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String OWNER_COMPANY="ownerCompany";
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,org.github.foxnic.web.domain.hrm.Organization> OWNER_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,OWNER_COMPANY, org.github.foxnic.web.domain.hrm.Organization.class, "所属公司", "所属公司", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String VEHICLE_TYPE_DICT="vehicleTypeDict";
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,org.github.foxnic.web.domain.system.DictItem> VEHICLE_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,VEHICLE_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "类型", "类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String VEHICLE_STATUS_DICT="vehicleStatusDict";
	
	/**
	 * 状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,org.github.foxnic.web.domain.system.DictItem> VEHICLE_STATUS_DICT_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,VEHICLE_STATUS_DICT, org.github.foxnic.web.domain.system.DictItem.class, "状态", "状态", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 使用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USE_USER="useUser";
	
	/**
	 * 使用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,org.github.foxnic.web.domain.hrm.Employee> USE_USER_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,USE_USER, org.github.foxnic.web.domain.hrm.Employee.class, "使用人", "使用人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 车辆列表 , 类型: java.lang.String
	*/
	public static final String SELECT_IDS="selectIds";
	
	/**
	 * 车辆列表 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.oa.VehicleInfo,java.lang.String> SELECT_IDS_PROP = new BeanProperty(com.dt.platform.domain.oa.VehicleInfo.class ,SELECT_IDS, java.lang.String.class, "车辆列表", "车辆列表", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , VEHICLE_STATUS , TYPE , VEHICLE_CODE , MODEL , REGISTRANT , OWNER_ORG_ID , USE_ORG_ID , USE_USER_ID , COLOR , ENGINE_NUMBER , FRAME_NUMBER , DRIVING_LICENSE , KILOMETERS , CAR_BOAT_TAX , RESCUE_MONEY , COMMERCIAL_INSURANCE_MONEY , INSURANCE_COMPANY , LICENSING_TIME , INSURANCE_EXPIRE_DATE , RESCUE_DUE_DATE , VERSION , SCRAP_TIME , POSITION_DETAIL , PICTURES , ORIGINATOR_ID , TECHNICAL_PARAMETER , VEHICLE_COUNT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , OWNER_COMPANY , USE_ORGANIZATION , VEHICLE_TYPE_DICT , VEHICLE_STATUS_DICT , ORIGINATOR , USE_USER , SELECT_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.oa.VehicleInfo {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public VehicleInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public VehicleInfo setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param vehicleStatus 状态
		 * @return 当前对象
		*/
		public VehicleInfo setVehicleStatus(String vehicleStatus) {
			super.change(VEHICLE_STATUS,super.getVehicleStatus(),vehicleStatus);
			super.setVehicleStatus(vehicleStatus);
			return this;
		}
		
		/**
		 * 设置 车辆类型
		 * @param type 车辆类型
		 * @return 当前对象
		*/
		public VehicleInfo setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 车牌号
		 * @param vehicleCode 车牌号
		 * @return 当前对象
		*/
		public VehicleInfo setVehicleCode(String vehicleCode) {
			super.change(VEHICLE_CODE,super.getVehicleCode(),vehicleCode);
			super.setVehicleCode(vehicleCode);
			return this;
		}
		
		/**
		 * 设置 品牌型号
		 * @param model 品牌型号
		 * @return 当前对象
		*/
		public VehicleInfo setModel(String model) {
			super.change(MODEL,super.getModel(),model);
			super.setModel(model);
			return this;
		}
		
		/**
		 * 设置 登记人
		 * @param registrant 登记人
		 * @return 当前对象
		*/
		public VehicleInfo setRegistrant(String registrant) {
			super.change(REGISTRANT,super.getRegistrant(),registrant);
			super.setRegistrant(registrant);
			return this;
		}
		
		/**
		 * 设置 所属组织
		 * @param ownerOrgId 所属组织
		 * @return 当前对象
		*/
		public VehicleInfo setOwnerOrgId(String ownerOrgId) {
			super.change(OWNER_ORG_ID,super.getOwnerOrgId(),ownerOrgId);
			super.setOwnerOrgId(ownerOrgId);
			return this;
		}
		
		/**
		 * 设置 使用部门
		 * @param useOrgId 使用部门
		 * @return 当前对象
		*/
		public VehicleInfo setUseOrgId(String useOrgId) {
			super.change(USE_ORG_ID,super.getUseOrgId(),useOrgId);
			super.setUseOrgId(useOrgId);
			return this;
		}
		
		/**
		 * 设置 使用人
		 * @param useUserId 使用人
		 * @return 当前对象
		*/
		public VehicleInfo setUseUserId(String useUserId) {
			super.change(USE_USER_ID,super.getUseUserId(),useUserId);
			super.setUseUserId(useUserId);
			return this;
		}
		
		/**
		 * 设置 颜色
		 * @param color 颜色
		 * @return 当前对象
		*/
		public VehicleInfo setColor(String color) {
			super.change(COLOR,super.getColor(),color);
			super.setColor(color);
			return this;
		}
		
		/**
		 * 设置 发动机号
		 * @param engineNumber 发动机号
		 * @return 当前对象
		*/
		public VehicleInfo setEngineNumber(String engineNumber) {
			super.change(ENGINE_NUMBER,super.getEngineNumber(),engineNumber);
			super.setEngineNumber(engineNumber);
			return this;
		}
		
		/**
		 * 设置 车架号
		 * @param frameNumber 车架号
		 * @return 当前对象
		*/
		public VehicleInfo setFrameNumber(String frameNumber) {
			super.change(FRAME_NUMBER,super.getFrameNumber(),frameNumber);
			super.setFrameNumber(frameNumber);
			return this;
		}
		
		/**
		 * 设置 行驶证
		 * @param drivingLicense 行驶证
		 * @return 当前对象
		*/
		public VehicleInfo setDrivingLicense(String drivingLicense) {
			super.change(DRIVING_LICENSE,super.getDrivingLicense(),drivingLicense);
			super.setDrivingLicense(drivingLicense);
			return this;
		}
		
		/**
		 * 设置 公里数
		 * @param kilometers 公里数
		 * @return 当前对象
		*/
		public VehicleInfo setKilometers(BigDecimal kilometers) {
			super.change(KILOMETERS,super.getKilometers(),kilometers);
			super.setKilometers(kilometers);
			return this;
		}
		
		/**
		 * 设置 车船税
		 * @param carBoatTax 车船税
		 * @return 当前对象
		*/
		public VehicleInfo setCarBoatTax(BigDecimal carBoatTax) {
			super.change(CAR_BOAT_TAX,super.getCarBoatTax(),carBoatTax);
			super.setCarBoatTax(carBoatTax);
			return this;
		}
		
		/**
		 * 设置 抢险(元)
		 * @param rescueMoney 抢险(元)
		 * @return 当前对象
		*/
		public VehicleInfo setRescueMoney(BigDecimal rescueMoney) {
			super.change(RESCUE_MONEY,super.getRescueMoney(),rescueMoney);
			super.setRescueMoney(rescueMoney);
			return this;
		}
		
		/**
		 * 设置 商业险(元)
		 * @param commercialInsuranceMoney 商业险(元)
		 * @return 当前对象
		*/
		public VehicleInfo setCommercialInsuranceMoney(BigDecimal commercialInsuranceMoney) {
			super.change(COMMERCIAL_INSURANCE_MONEY,super.getCommercialInsuranceMoney(),commercialInsuranceMoney);
			super.setCommercialInsuranceMoney(commercialInsuranceMoney);
			return this;
		}
		
		/**
		 * 设置 保险公司
		 * @param insuranceCompany 保险公司
		 * @return 当前对象
		*/
		public VehicleInfo setInsuranceCompany(String insuranceCompany) {
			super.change(INSURANCE_COMPANY,super.getInsuranceCompany(),insuranceCompany);
			super.setInsuranceCompany(insuranceCompany);
			return this;
		}
		
		/**
		 * 设置 上牌时间
		 * @param licensingTime 上牌时间
		 * @return 当前对象
		*/
		public VehicleInfo setLicensingTime(Date licensingTime) {
			super.change(LICENSING_TIME,super.getLicensingTime(),licensingTime);
			super.setLicensingTime(licensingTime);
			return this;
		}
		
		/**
		 * 设置 商业险到期
		 * @param insuranceExpireDate 商业险到期
		 * @return 当前对象
		*/
		public VehicleInfo setInsuranceExpireDate(Date insuranceExpireDate) {
			super.change(INSURANCE_EXPIRE_DATE,super.getInsuranceExpireDate(),insuranceExpireDate);
			super.setInsuranceExpireDate(insuranceExpireDate);
			return this;
		}
		
		/**
		 * 设置 抢险到期
		 * @param rescueDueDate 抢险到期
		 * @return 当前对象
		*/
		public VehicleInfo setRescueDueDate(Date rescueDueDate) {
			super.change(RESCUE_DUE_DATE,super.getRescueDueDate(),rescueDueDate);
			super.setRescueDueDate(rescueDueDate);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public VehicleInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 报废时间
		 * @param scrapTime 报废时间
		 * @return 当前对象
		*/
		public VehicleInfo setScrapTime(Date scrapTime) {
			super.change(SCRAP_TIME,super.getScrapTime(),scrapTime);
			super.setScrapTime(scrapTime);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param positionDetail 存放位置
		 * @return 当前对象
		*/
		public VehicleInfo setPositionDetail(String positionDetail) {
			super.change(POSITION_DETAIL,super.getPositionDetail(),positionDetail);
			super.setPositionDetail(positionDetail);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictures 图片
		 * @return 当前对象
		*/
		public VehicleInfo setPictures(String pictures) {
			super.change(PICTURES,super.getPictures(),pictures);
			super.setPictures(pictures);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public VehicleInfo setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 技术参数
		 * @param technicalParameter 技术参数
		 * @return 当前对象
		*/
		public VehicleInfo setTechnicalParameter(String technicalParameter) {
			super.change(TECHNICAL_PARAMETER,super.getTechnicalParameter(),technicalParameter);
			super.setTechnicalParameter(technicalParameter);
			return this;
		}
		
		/**
		 * 设置 数量
		 * @param vehicleCount 数量
		 * @return 当前对象
		*/
		public VehicleInfo setVehicleCount(Integer vehicleCount) {
			super.change(VEHICLE_COUNT,super.getVehicleCount(),vehicleCount);
			super.setVehicleCount(vehicleCount);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public VehicleInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public VehicleInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public VehicleInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public VehicleInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public VehicleInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public VehicleInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public VehicleInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public VehicleInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public VehicleInfo setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownerCompany 所属公司
		 * @return 当前对象
		*/
		public VehicleInfo setOwnerCompany(Organization ownerCompany) {
			super.change(OWNER_COMPANY,super.getOwnerCompany(),ownerCompany);
			super.setOwnerCompany(ownerCompany);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganization 使用公司/部门
		 * @return 当前对象
		*/
		public VehicleInfo setUseOrganization(Organization useOrganization) {
			super.change(USE_ORGANIZATION,super.getUseOrganization(),useOrganization);
			super.setUseOrganization(useOrganization);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param vehicleTypeDict 类型
		 * @return 当前对象
		*/
		public VehicleInfo setVehicleTypeDict(DictItem vehicleTypeDict) {
			super.change(VEHICLE_TYPE_DICT,super.getVehicleTypeDict(),vehicleTypeDict);
			super.setVehicleTypeDict(vehicleTypeDict);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param vehicleStatusDict 状态
		 * @return 当前对象
		*/
		public VehicleInfo setVehicleStatusDict(DictItem vehicleStatusDict) {
			super.change(VEHICLE_STATUS_DICT,super.getVehicleStatusDict(),vehicleStatusDict);
			super.setVehicleStatusDict(vehicleStatusDict);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public VehicleInfo setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 使用人
		 * @param useUser 使用人
		 * @return 当前对象
		*/
		public VehicleInfo setUseUser(Employee useUser) {
			super.change(USE_USER,super.getUseUser(),useUser);
			super.setUseUser(useUser);
			return this;
		}
		
		/**
		 * 设置 车辆列表
		 * @param selectIds 车辆列表
		 * @return 当前对象
		*/
		public VehicleInfo setSelectIds(String selectIds) {
			super.change(SELECT_IDS,super.getSelectIds(),selectIds);
			super.setSelectIds(selectIds);
			return this;
		}
	}
}