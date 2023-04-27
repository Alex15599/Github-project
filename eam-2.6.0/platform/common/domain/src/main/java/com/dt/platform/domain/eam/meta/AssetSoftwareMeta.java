package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetSoftware;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.pcm.Catalog;
import com.dt.platform.domain.eam.Supplier;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Maintainer;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-25 20:03:27
 * @sign E6AC84F693C3E2E90D5E8ADCD5849022
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetSoftwareMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER_CODE="ownerCode";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> OWNER_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,OWNER_CODE, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 软件名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 软件名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,NAME, java.lang.String.class, "软件名称", "软件名称", java.lang.String.class, null);
	
	/**
	 * 软件分类 , 类型: java.lang.String
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 软件分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,CATEGORY_ID, java.lang.String.class, "软件分类", "软件分类", java.lang.String.class, null);
	
	/**
	 * 软件编号 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 软件编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,CODE, java.lang.String.class, "软件编号", "软件编号", java.lang.String.class, null);
	
	/**
	 * 软件版本 , 类型: java.lang.String
	*/
	public static final String SOFTWARE_VERSION="softwareVersion";
	
	/**
	 * 软件版本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> SOFTWARE_VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,SOFTWARE_VERSION, java.lang.String.class, "软件版本", "软件版本", java.lang.String.class, null);
	
	/**
	 * 版权类型 , 类型: java.lang.String
	*/
	public static final String COPYRIGHT_TYPE="copyrightType";
	
	/**
	 * 版权类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> COPYRIGHT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,COPYRIGHT_TYPE, java.lang.String.class, "版权类型", "版权类型", java.lang.String.class, null);
	
	/**
	 * 许可方式 , 类型: java.lang.String
	*/
	public static final String LICENSE_MODE="licenseMode";
	
	/**
	 * 许可方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> LICENSE_MODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,LICENSE_MODE, java.lang.String.class, "许可方式", "许可方式", java.lang.String.class, null);
	
	/**
	 * 成本 , 类型: java.math.BigDecimal
	*/
	public static final String COST_PRICE="costPrice";
	
	/**
	 * 成本 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.math.BigDecimal> COST_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,COST_PRICE, java.math.BigDecimal.class, "成本", "成本", java.math.BigDecimal.class, null);
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final String OWN_COMPANY_ID="ownCompanyId";
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> OWN_COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,OWN_COMPANY_ID, java.lang.String.class, "所属公司", "所属公司", java.lang.String.class, null);
	
	/**
	 * 使用公司 , 类型: java.lang.String
	*/
	public static final String USE_ORGANIZATION_ID="useOrganizationId";
	
	/**
	 * 使用公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> USE_ORGANIZATION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,USE_ORGANIZATION_ID, java.lang.String.class, "使用公司", "使用公司", java.lang.String.class, null);
	
	/**
	 * 供应商 , 类型: java.lang.String
	*/
	public static final String SUPPLIER_ID="supplierId";
	
	/**
	 * 供应商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> SUPPLIER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,SUPPLIER_ID, java.lang.String.class, "供应商", "供应商", java.lang.String.class, null);
	
	/**
	 * 管理人 , 类型: java.lang.String
	*/
	public static final String MANAGER_ID="managerId";
	
	/**
	 * 管理人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> MANAGER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,MANAGER_ID, java.lang.String.class, "管理人", "管理人", java.lang.String.class, null);
	
	/**
	 * 详细位置 , 类型: java.lang.String
	*/
	public static final String POSITION_DETAIL="positionDetail";
	
	/**
	 * 详细位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> POSITION_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,POSITION_DETAIL, java.lang.String.class, "详细位置", "详细位置", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE_ID="sourceId";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> SOURCE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,SOURCE_ID, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 来源明细 , 类型: java.lang.String
	*/
	public static final String SOURCE_DETAIL="sourceDetail";
	
	/**
	 * 来源明细 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> SOURCE_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,SOURCE_DETAIL, java.lang.String.class, "来源明细", "来源明细", java.lang.String.class, null);
	
	/**
	 * 授权信息 , 类型: java.lang.String
	*/
	public static final String AUTHORIZATION_INFO="authorizationInfo";
	
	/**
	 * 授权信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> AUTHORIZATION_INFO_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,AUTHORIZATION_INFO, java.lang.String.class, "授权信息", "授权信息", java.lang.String.class, null);
	
	/**
	 * 授权数量 , 类型: java.lang.Integer
	*/
	public static final String AUTHORIZED_NUMBER="authorizedNumber";
	
	/**
	 * 授权数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.Integer> AUTHORIZED_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,AUTHORIZED_NUMBER, java.lang.Integer.class, "授权数量", "授权数量", java.lang.Integer.class, null);
	
	/**
	 * 可用数量 , 类型: java.lang.Integer
	*/
	public static final String AUTHORIZED_AVAILABLE_NUMBER="authorizedAvailableNumber";
	
	/**
	 * 可用数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.Integer> AUTHORIZED_AVAILABLE_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,AUTHORIZED_AVAILABLE_NUMBER, java.lang.Integer.class, "可用数量", "可用数量", java.lang.Integer.class, null);
	
	/**
	 * 无限授权 , 类型: java.lang.String
	*/
	public static final String AUTHORIZED_NUMBER_UNLIMIT="authorizedNumberUnlimit";
	
	/**
	 * 无限授权 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> AUTHORIZED_NUMBER_UNLIMIT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,AUTHORIZED_NUMBER_UNLIMIT, java.lang.String.class, "无限授权", "无限授权", java.lang.String.class, null);
	
	/**
	 * 授权码 , 类型: java.lang.String
	*/
	public static final String AUTHORIZATION_CODE="authorizationCode";
	
	/**
	 * 授权码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> AUTHORIZATION_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,AUTHORIZATION_CODE, java.lang.String.class, "授权码", "授权码", java.lang.String.class, null);
	
	/**
	 * 授权到期时间 , 类型: java.util.Date
	*/
	public static final String AUTHORIZATION_EXPIRATION_DATE="authorizationExpirationDate";
	
	/**
	 * 授权到期时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.util.Date> AUTHORIZATION_EXPIRATION_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,AUTHORIZATION_EXPIRATION_DATE, java.util.Date.class, "授权到期时间", "授权到期时间", java.util.Date.class, null);
	
	/**
	 * 永久授权 , 类型: java.lang.String
	*/
	public static final String AUTHORIZATION_EXPIRATION_UNLIMIT="authorizationExpirationUnlimit";
	
	/**
	 * 永久授权 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> AUTHORIZATION_EXPIRATION_UNLIMIT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,AUTHORIZATION_EXPIRATION_UNLIMIT, java.lang.String.class, "永久授权", "永久授权", java.lang.String.class, null);
	
	/**
	 * 是否维保 , 类型: java.lang.String
	*/
	public static final String NEED_MAINTENANCE="needMaintenance";
	
	/**
	 * 是否维保 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> NEED_MAINTENANCE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,NEED_MAINTENANCE, java.lang.String.class, "是否维保", "是否维保", java.lang.String.class, null);
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final String MAINTAINER_ID="maintainerId";
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> MAINTAINER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,MAINTAINER_ID, java.lang.String.class, "维保厂商", "维保厂商", java.lang.String.class, null);
	
	/**
	 * 维保开始时间 , 类型: java.util.Date
	*/
	public static final String MAINTENANCE_START_DATE="maintenanceStartDate";
	
	/**
	 * 维保开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.util.Date> MAINTENANCE_START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,MAINTENANCE_START_DATE, java.util.Date.class, "维保开始时间", "维保开始时间", java.util.Date.class, null);
	
	/**
	 * 维保到期时间 , 类型: java.util.Date
	*/
	public static final String MAINTENANCE_END_DATE="maintenanceEndDate";
	
	/**
	 * 维保到期时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.util.Date> MAINTENANCE_END_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,MAINTENANCE_END_DATE, java.util.Date.class, "维保到期时间", "维保到期时间", java.util.Date.class, null);
	
	/**
	 * 购置日期 , 类型: java.util.Date
	*/
	public static final String PURCHASE_DATE="purchaseDate";
	
	/**
	 * 购置日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.util.Date> PURCHASE_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,PURCHASE_DATE, java.util.Date.class, "购置日期", "购置日期", java.util.Date.class, null);
	
	/**
	 * 登记时间 , 类型: java.util.Date
	*/
	public static final String REGISTER_DATE="registerDate";
	
	/**
	 * 登记时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.util.Date> REGISTER_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,REGISTER_DATE, java.util.Date.class, "登记时间", "登记时间", java.util.Date.class, null);
	
	/**
	 * 软件说明 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 软件说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,CONTENT, java.lang.String.class, "软件说明", "软件说明", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH_ID="attachId";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> ATTACH_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,ATTACH_ID, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 标签1 , 类型: java.lang.String
	*/
	public static final String LABEL1="label1";
	
	/**
	 * 标签1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> LABEL1_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,LABEL1, java.lang.String.class, "标签1", "标签1", java.lang.String.class, null);
	
	/**
	 * 标签2 , 类型: java.lang.String
	*/
	public static final String LABEL2="label2";
	
	/**
	 * 标签2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> LABEL2_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,LABEL2, java.lang.String.class, "标签2", "标签2", java.lang.String.class, null);
	
	/**
	 * 标签3 , 类型: java.lang.String
	*/
	public static final String LABEL3="label3";
	
	/**
	 * 标签3 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> LABEL3_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,LABEL3, java.lang.String.class, "标签3", "标签3", java.lang.String.class, null);
	
	/**
	 * 标签4 , 类型: java.lang.String
	*/
	public static final String LABEL4="label4";
	
	/**
	 * 标签4 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> LABEL4_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,LABEL4, java.lang.String.class, "标签4", "标签4", java.lang.String.class, null);
	
	/**
	 * 控制 , 类型: java.lang.String
	*/
	public static final String CTL="ctl";
	
	/**
	 * 控制 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> CTL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,CTL, java.lang.String.class, "控制", "控制", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final String CHS_TYPE="chsType";
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> CHS_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,CHS_TYPE, java.lang.String.class, "变更类型", "变更类型", java.lang.String.class, null);
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final String CHS_STATUS="chsStatus";
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> CHS_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,CHS_STATUS, java.lang.String.class, "变更状态", "变更状态", java.lang.String.class, null);
	
	/**
	 * 变更版本号 , 类型: java.lang.String
	*/
	public static final String CHS_VERSION="chsVersion";
	
	/**
	 * 变更版本号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> CHS_VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,CHS_VERSION, java.lang.String.class, "变更版本号", "变更版本号", java.lang.String.class, null);
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final String CHANGE_INSTANCE_ID="changeInstanceId";
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> CHANGE_INSTANCE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,CHANGE_INSTANCE_ID, java.lang.String.class, "变更ID", "变更ID", java.lang.String.class, null);
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final String SUMMARY="summary";
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> SUMMARY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,SUMMARY, java.lang.String.class, "流程概要", "流程概要", java.lang.String.class, null);
	
	/**
	 * 最后审批人账户ID , 类型: java.lang.String
	*/
	public static final String LATEST_APPROVER_ID="latestApproverId";
	
	/**
	 * 最后审批人账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> LATEST_APPROVER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,LATEST_APPROVER_ID, java.lang.String.class, "最后审批人账户ID", "最后审批人账户ID", java.lang.String.class, null);
	
	/**
	 * 最后审批人姓名 , 类型: java.lang.String
	*/
	public static final String LATEST_APPROVER_NAME="latestApproverName";
	
	/**
	 * 最后审批人姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> LATEST_APPROVER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,LATEST_APPROVER_NAME, java.lang.String.class, "最后审批人姓名", "最后审批人姓名", java.lang.String.class, null);
	
	/**
	 * 下一节点审批人 , 类型: java.lang.String
	*/
	public static final String NEXT_APPROVER_IDS="nextApproverIds";
	
	/**
	 * 下一节点审批人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> NEXT_APPROVER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,NEXT_APPROVER_IDS, java.lang.String.class, "下一节点审批人", "下一节点审批人", java.lang.String.class, null);
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final String NEXT_APPROVER_NAMES="nextApproverNames";
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> NEXT_APPROVER_NAMES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,NEXT_APPROVER_NAMES, java.lang.String.class, "下一个审批节点审批人姓名", "用逗号隔开", java.lang.String.class, null);
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final String APPROVAL_OPINION="approvalOpinion";
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> APPROVAL_OPINION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,APPROVAL_OPINION, java.lang.String.class, "审批意见", "审批意见", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 资产分类 , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final String CATEGORY="category";
	
	/**
	 * 资产分类 , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,org.github.foxnic.web.domain.pcm.Catalog> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,CATEGORY, org.github.foxnic.web.domain.pcm.Catalog.class, "资产分类", "资产分类", org.github.foxnic.web.domain.pcm.Catalog.class, null);
	
	/**
	 * 供应商 , 类型: com.dt.platform.domain.eam.Supplier
	*/
	public static final String SUPPLIER="supplier";
	
	/**
	 * 供应商 , 类型: com.dt.platform.domain.eam.Supplier
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,com.dt.platform.domain.eam.Supplier> SUPPLIER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,SUPPLIER, com.dt.platform.domain.eam.Supplier.class, "供应商", "供应商", com.dt.platform.domain.eam.Supplier.class, null);
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String OWNER_COMPANY="ownerCompany";
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,org.github.foxnic.web.domain.hrm.Organization> OWNER_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,OWNER_COMPANY, org.github.foxnic.web.domain.hrm.Organization.class, "所属公司", "所属公司", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 来源 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SOURCE="source";
	
	/**
	 * 来源 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,org.github.foxnic.web.domain.system.DictItem> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,SOURCE, org.github.foxnic.web.domain.system.DictItem.class, "来源", "来源", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 管理人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String MANAGER="manager";
	
	/**
	 * 管理人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,org.github.foxnic.web.domain.hrm.Employee> MANAGER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,MANAGER, org.github.foxnic.web.domain.hrm.Employee.class, "管理人", "管理人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 版权 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String COPYRIGHT_TYPE_DICT="copyrightTypeDict";
	
	/**
	 * 版权 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,org.github.foxnic.web.domain.system.DictItem> COPYRIGHT_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,COPYRIGHT_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "版权", "版权", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 许可 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String LICENSE_MODE_DICT="licenseModeDict";
	
	/**
	 * 许可 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,org.github.foxnic.web.domain.system.DictItem> LICENSE_MODE_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,LICENSE_MODE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "许可", "许可", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 维保商 , 类型: com.dt.platform.domain.eam.Maintainer
	*/
	public static final String MAINTAINER="maintainer";
	
	/**
	 * 维保商 , 类型: com.dt.platform.domain.eam.Maintainer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetSoftware,com.dt.platform.domain.eam.Maintainer> MAINTAINER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetSoftware.class ,MAINTAINER, com.dt.platform.domain.eam.Maintainer.class, "维保商", "维保商", com.dt.platform.domain.eam.Maintainer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , OWNER_CODE , PROC_ID , STATUS , NAME , CATEGORY_ID , CODE , SOFTWARE_VERSION , COPYRIGHT_TYPE , LICENSE_MODE , COST_PRICE , OWN_COMPANY_ID , USE_ORGANIZATION_ID , SUPPLIER_ID , MANAGER_ID , POSITION_DETAIL , SOURCE_ID , SOURCE_DETAIL , AUTHORIZATION_INFO , AUTHORIZED_NUMBER , AUTHORIZED_AVAILABLE_NUMBER , AUTHORIZED_NUMBER_UNLIMIT , AUTHORIZATION_CODE , AUTHORIZATION_EXPIRATION_DATE , AUTHORIZATION_EXPIRATION_UNLIMIT , NEED_MAINTENANCE , MAINTAINER_ID , MAINTENANCE_START_DATE , MAINTENANCE_END_DATE , PURCHASE_DATE , REGISTER_DATE , CONTENT , NOTES , ATTACH_ID , LABEL1 , LABEL2 , LABEL3 , LABEL4 , CTL , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ORIGINATOR_ID , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION , SELECTED_CODE , CATEGORY , SUPPLIER , USE_ORGANIZATION , OWNER_COMPANY , SOURCE , ORIGINATOR , MANAGER , COPYRIGHT_TYPE_DICT , LICENSE_MODE_DICT , MAINTAINER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetSoftware {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetSoftware setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public AssetSoftware setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param ownerCode 所属
		 * @return 当前对象
		*/
		public AssetSoftware setOwnerCode(String ownerCode) {
			super.change(OWNER_CODE,super.getOwnerCode(),ownerCode);
			super.setOwnerCode(ownerCode);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public AssetSoftware setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public AssetSoftware setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 软件名称
		 * @param name 软件名称
		 * @return 当前对象
		*/
		public AssetSoftware setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 软件分类
		 * @param categoryId 软件分类
		 * @return 当前对象
		*/
		public AssetSoftware setCategoryId(String categoryId) {
			super.change(CATEGORY_ID,super.getCategoryId(),categoryId);
			super.setCategoryId(categoryId);
			return this;
		}
		
		/**
		 * 设置 软件编号
		 * @param code 软件编号
		 * @return 当前对象
		*/
		public AssetSoftware setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 软件版本
		 * @param softwareVersion 软件版本
		 * @return 当前对象
		*/
		public AssetSoftware setSoftwareVersion(String softwareVersion) {
			super.change(SOFTWARE_VERSION,super.getSoftwareVersion(),softwareVersion);
			super.setSoftwareVersion(softwareVersion);
			return this;
		}
		
		/**
		 * 设置 版权类型
		 * @param copyrightType 版权类型
		 * @return 当前对象
		*/
		public AssetSoftware setCopyrightType(String copyrightType) {
			super.change(COPYRIGHT_TYPE,super.getCopyrightType(),copyrightType);
			super.setCopyrightType(copyrightType);
			return this;
		}
		
		/**
		 * 设置 许可方式
		 * @param licenseMode 许可方式
		 * @return 当前对象
		*/
		public AssetSoftware setLicenseMode(String licenseMode) {
			super.change(LICENSE_MODE,super.getLicenseMode(),licenseMode);
			super.setLicenseMode(licenseMode);
			return this;
		}
		
		/**
		 * 设置 成本
		 * @param costPrice 成本
		 * @return 当前对象
		*/
		public AssetSoftware setCostPrice(BigDecimal costPrice) {
			super.change(COST_PRICE,super.getCostPrice(),costPrice);
			super.setCostPrice(costPrice);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownCompanyId 所属公司
		 * @return 当前对象
		*/
		public AssetSoftware setOwnCompanyId(String ownCompanyId) {
			super.change(OWN_COMPANY_ID,super.getOwnCompanyId(),ownCompanyId);
			super.setOwnCompanyId(ownCompanyId);
			return this;
		}
		
		/**
		 * 设置 使用公司
		 * @param useOrganizationId 使用公司
		 * @return 当前对象
		*/
		public AssetSoftware setUseOrganizationId(String useOrganizationId) {
			super.change(USE_ORGANIZATION_ID,super.getUseOrganizationId(),useOrganizationId);
			super.setUseOrganizationId(useOrganizationId);
			return this;
		}
		
		/**
		 * 设置 供应商
		 * @param supplierId 供应商
		 * @return 当前对象
		*/
		public AssetSoftware setSupplierId(String supplierId) {
			super.change(SUPPLIER_ID,super.getSupplierId(),supplierId);
			super.setSupplierId(supplierId);
			return this;
		}
		
		/**
		 * 设置 管理人
		 * @param managerId 管理人
		 * @return 当前对象
		*/
		public AssetSoftware setManagerId(String managerId) {
			super.change(MANAGER_ID,super.getManagerId(),managerId);
			super.setManagerId(managerId);
			return this;
		}
		
		/**
		 * 设置 详细位置
		 * @param positionDetail 详细位置
		 * @return 当前对象
		*/
		public AssetSoftware setPositionDetail(String positionDetail) {
			super.change(POSITION_DETAIL,super.getPositionDetail(),positionDetail);
			super.setPositionDetail(positionDetail);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param sourceId 来源
		 * @return 当前对象
		*/
		public AssetSoftware setSourceId(String sourceId) {
			super.change(SOURCE_ID,super.getSourceId(),sourceId);
			super.setSourceId(sourceId);
			return this;
		}
		
		/**
		 * 设置 来源明细
		 * @param sourceDetail 来源明细
		 * @return 当前对象
		*/
		public AssetSoftware setSourceDetail(String sourceDetail) {
			super.change(SOURCE_DETAIL,super.getSourceDetail(),sourceDetail);
			super.setSourceDetail(sourceDetail);
			return this;
		}
		
		/**
		 * 设置 授权信息
		 * @param authorizationInfo 授权信息
		 * @return 当前对象
		*/
		public AssetSoftware setAuthorizationInfo(String authorizationInfo) {
			super.change(AUTHORIZATION_INFO,super.getAuthorizationInfo(),authorizationInfo);
			super.setAuthorizationInfo(authorizationInfo);
			return this;
		}
		
		/**
		 * 设置 授权数量
		 * @param authorizedNumber 授权数量
		 * @return 当前对象
		*/
		public AssetSoftware setAuthorizedNumber(Integer authorizedNumber) {
			super.change(AUTHORIZED_NUMBER,super.getAuthorizedNumber(),authorizedNumber);
			super.setAuthorizedNumber(authorizedNumber);
			return this;
		}
		
		/**
		 * 设置 可用数量
		 * @param authorizedAvailableNumber 可用数量
		 * @return 当前对象
		*/
		public AssetSoftware setAuthorizedAvailableNumber(Integer authorizedAvailableNumber) {
			super.change(AUTHORIZED_AVAILABLE_NUMBER,super.getAuthorizedAvailableNumber(),authorizedAvailableNumber);
			super.setAuthorizedAvailableNumber(authorizedAvailableNumber);
			return this;
		}
		
		/**
		 * 设置 无限授权
		 * @param authorizedNumberUnlimit 无限授权
		 * @return 当前对象
		*/
		public AssetSoftware setAuthorizedNumberUnlimit(String authorizedNumberUnlimit) {
			super.change(AUTHORIZED_NUMBER_UNLIMIT,super.getAuthorizedNumberUnlimit(),authorizedNumberUnlimit);
			super.setAuthorizedNumberUnlimit(authorizedNumberUnlimit);
			return this;
		}
		
		/**
		 * 设置 授权码
		 * @param authorizationCode 授权码
		 * @return 当前对象
		*/
		public AssetSoftware setAuthorizationCode(String authorizationCode) {
			super.change(AUTHORIZATION_CODE,super.getAuthorizationCode(),authorizationCode);
			super.setAuthorizationCode(authorizationCode);
			return this;
		}
		
		/**
		 * 设置 授权到期时间
		 * @param authorizationExpirationDate 授权到期时间
		 * @return 当前对象
		*/
		public AssetSoftware setAuthorizationExpirationDate(Date authorizationExpirationDate) {
			super.change(AUTHORIZATION_EXPIRATION_DATE,super.getAuthorizationExpirationDate(),authorizationExpirationDate);
			super.setAuthorizationExpirationDate(authorizationExpirationDate);
			return this;
		}
		
		/**
		 * 设置 永久授权
		 * @param authorizationExpirationUnlimit 永久授权
		 * @return 当前对象
		*/
		public AssetSoftware setAuthorizationExpirationUnlimit(String authorizationExpirationUnlimit) {
			super.change(AUTHORIZATION_EXPIRATION_UNLIMIT,super.getAuthorizationExpirationUnlimit(),authorizationExpirationUnlimit);
			super.setAuthorizationExpirationUnlimit(authorizationExpirationUnlimit);
			return this;
		}
		
		/**
		 * 设置 是否维保
		 * @param needMaintenance 是否维保
		 * @return 当前对象
		*/
		public AssetSoftware setNeedMaintenance(String needMaintenance) {
			super.change(NEED_MAINTENANCE,super.getNeedMaintenance(),needMaintenance);
			super.setNeedMaintenance(needMaintenance);
			return this;
		}
		
		/**
		 * 设置 维保厂商
		 * @param maintainerId 维保厂商
		 * @return 当前对象
		*/
		public AssetSoftware setMaintainerId(String maintainerId) {
			super.change(MAINTAINER_ID,super.getMaintainerId(),maintainerId);
			super.setMaintainerId(maintainerId);
			return this;
		}
		
		/**
		 * 设置 维保开始时间
		 * @param maintenanceStartDate 维保开始时间
		 * @return 当前对象
		*/
		public AssetSoftware setMaintenanceStartDate(Date maintenanceStartDate) {
			super.change(MAINTENANCE_START_DATE,super.getMaintenanceStartDate(),maintenanceStartDate);
			super.setMaintenanceStartDate(maintenanceStartDate);
			return this;
		}
		
		/**
		 * 设置 维保到期时间
		 * @param maintenanceEndDate 维保到期时间
		 * @return 当前对象
		*/
		public AssetSoftware setMaintenanceEndDate(Date maintenanceEndDate) {
			super.change(MAINTENANCE_END_DATE,super.getMaintenanceEndDate(),maintenanceEndDate);
			super.setMaintenanceEndDate(maintenanceEndDate);
			return this;
		}
		
		/**
		 * 设置 购置日期
		 * @param purchaseDate 购置日期
		 * @return 当前对象
		*/
		public AssetSoftware setPurchaseDate(Date purchaseDate) {
			super.change(PURCHASE_DATE,super.getPurchaseDate(),purchaseDate);
			super.setPurchaseDate(purchaseDate);
			return this;
		}
		
		/**
		 * 设置 登记时间
		 * @param registerDate 登记时间
		 * @return 当前对象
		*/
		public AssetSoftware setRegisterDate(Date registerDate) {
			super.change(REGISTER_DATE,super.getRegisterDate(),registerDate);
			super.setRegisterDate(registerDate);
			return this;
		}
		
		/**
		 * 设置 软件说明
		 * @param content 软件说明
		 * @return 当前对象
		*/
		public AssetSoftware setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetSoftware setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attachId 附件
		 * @return 当前对象
		*/
		public AssetSoftware setAttachId(String attachId) {
			super.change(ATTACH_ID,super.getAttachId(),attachId);
			super.setAttachId(attachId);
			return this;
		}
		
		/**
		 * 设置 标签1
		 * @param label1 标签1
		 * @return 当前对象
		*/
		public AssetSoftware setLabel1(String label1) {
			super.change(LABEL1,super.getLabel1(),label1);
			super.setLabel1(label1);
			return this;
		}
		
		/**
		 * 设置 标签2
		 * @param label2 标签2
		 * @return 当前对象
		*/
		public AssetSoftware setLabel2(String label2) {
			super.change(LABEL2,super.getLabel2(),label2);
			super.setLabel2(label2);
			return this;
		}
		
		/**
		 * 设置 标签3
		 * @param label3 标签3
		 * @return 当前对象
		*/
		public AssetSoftware setLabel3(String label3) {
			super.change(LABEL3,super.getLabel3(),label3);
			super.setLabel3(label3);
			return this;
		}
		
		/**
		 * 设置 标签4
		 * @param label4 标签4
		 * @return 当前对象
		*/
		public AssetSoftware setLabel4(String label4) {
			super.change(LABEL4,super.getLabel4(),label4);
			super.setLabel4(label4);
			return this;
		}
		
		/**
		 * 设置 控制
		 * @param ctl 控制
		 * @return 当前对象
		*/
		public AssetSoftware setCtl(String ctl) {
			super.change(CTL,super.getCtl(),ctl);
			super.setCtl(ctl);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetSoftware setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetSoftware setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetSoftware setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetSoftware setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetSoftware setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetSoftware setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetSoftware setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetSoftware setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetSoftware setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public AssetSoftware setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 变更类型
		 * @param chsType 变更类型
		 * @return 当前对象
		*/
		public AssetSoftware setChsType(String chsType) {
			super.change(CHS_TYPE,super.getChsType(),chsType);
			super.setChsType(chsType);
			return this;
		}
		
		/**
		 * 设置 变更状态
		 * @param chsStatus 变更状态
		 * @return 当前对象
		*/
		public AssetSoftware setChsStatus(String chsStatus) {
			super.change(CHS_STATUS,super.getChsStatus(),chsStatus);
			super.setChsStatus(chsStatus);
			return this;
		}
		
		/**
		 * 设置 变更版本号
		 * @param chsVersion 变更版本号
		 * @return 当前对象
		*/
		public AssetSoftware setChsVersion(String chsVersion) {
			super.change(CHS_VERSION,super.getChsVersion(),chsVersion);
			super.setChsVersion(chsVersion);
			return this;
		}
		
		/**
		 * 设置 变更ID
		 * @param changeInstanceId 变更ID
		 * @return 当前对象
		*/
		public AssetSoftware setChangeInstanceId(String changeInstanceId) {
			super.change(CHANGE_INSTANCE_ID,super.getChangeInstanceId(),changeInstanceId);
			super.setChangeInstanceId(changeInstanceId);
			return this;
		}
		
		/**
		 * 设置 流程概要
		 * @param summary 流程概要
		 * @return 当前对象
		*/
		public AssetSoftware setSummary(String summary) {
			super.change(SUMMARY,super.getSummary(),summary);
			super.setSummary(summary);
			return this;
		}
		
		/**
		 * 设置 最后审批人账户ID
		 * @param latestApproverId 最后审批人账户ID
		 * @return 当前对象
		*/
		public AssetSoftware setLatestApproverId(String latestApproverId) {
			super.change(LATEST_APPROVER_ID,super.getLatestApproverId(),latestApproverId);
			super.setLatestApproverId(latestApproverId);
			return this;
		}
		
		/**
		 * 设置 最后审批人姓名
		 * @param latestApproverName 最后审批人姓名
		 * @return 当前对象
		*/
		public AssetSoftware setLatestApproverName(String latestApproverName) {
			super.change(LATEST_APPROVER_NAME,super.getLatestApproverName(),latestApproverName);
			super.setLatestApproverName(latestApproverName);
			return this;
		}
		
		/**
		 * 设置 下一节点审批人
		 * @param nextApproverIds 下一节点审批人
		 * @return 当前对象
		*/
		public AssetSoftware setNextApproverIds(String nextApproverIds) {
			super.change(NEXT_APPROVER_IDS,super.getNextApproverIds(),nextApproverIds);
			super.setNextApproverIds(nextApproverIds);
			return this;
		}
		
		/**
		 * 设置 下一个审批节点审批人姓名
		 * @param nextApproverNames 下一个审批节点审批人姓名
		 * @return 当前对象
		*/
		public AssetSoftware setNextApproverNames(String nextApproverNames) {
			super.change(NEXT_APPROVER_NAMES,super.getNextApproverNames(),nextApproverNames);
			super.setNextApproverNames(nextApproverNames);
			return this;
		}
		
		/**
		 * 设置 审批意见
		 * @param approvalOpinion 审批意见
		 * @return 当前对象
		*/
		public AssetSoftware setApprovalOpinion(String approvalOpinion) {
			super.change(APPROVAL_OPINION,super.getApprovalOpinion(),approvalOpinion);
			super.setApprovalOpinion(approvalOpinion);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public AssetSoftware setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param category 资产分类
		 * @return 当前对象
		*/
		public AssetSoftware setCategory(Catalog category) {
			super.change(CATEGORY,super.getCategory(),category);
			super.setCategory(category);
			return this;
		}
		
		/**
		 * 设置 供应商
		 * @param supplier 供应商
		 * @return 当前对象
		*/
		public AssetSoftware setSupplier(Supplier supplier) {
			super.change(SUPPLIER,super.getSupplier(),supplier);
			super.setSupplier(supplier);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganization 使用公司/部门
		 * @return 当前对象
		*/
		public AssetSoftware setUseOrganization(Organization useOrganization) {
			super.change(USE_ORGANIZATION,super.getUseOrganization(),useOrganization);
			super.setUseOrganization(useOrganization);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownerCompany 所属公司
		 * @return 当前对象
		*/
		public AssetSoftware setOwnerCompany(Organization ownerCompany) {
			super.change(OWNER_COMPANY,super.getOwnerCompany(),ownerCompany);
			super.setOwnerCompany(ownerCompany);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param source 来源
		 * @return 当前对象
		*/
		public AssetSoftware setSource(DictItem source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public AssetSoftware setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 管理人
		 * @param manager 管理人
		 * @return 当前对象
		*/
		public AssetSoftware setManager(Employee manager) {
			super.change(MANAGER,super.getManager(),manager);
			super.setManager(manager);
			return this;
		}
		
		/**
		 * 设置 版权
		 * @param copyrightTypeDict 版权
		 * @return 当前对象
		*/
		public AssetSoftware setCopyrightTypeDict(DictItem copyrightTypeDict) {
			super.change(COPYRIGHT_TYPE_DICT,super.getCopyrightTypeDict(),copyrightTypeDict);
			super.setCopyrightTypeDict(copyrightTypeDict);
			return this;
		}
		
		/**
		 * 设置 许可
		 * @param licenseModeDict 许可
		 * @return 当前对象
		*/
		public AssetSoftware setLicenseModeDict(DictItem licenseModeDict) {
			super.change(LICENSE_MODE_DICT,super.getLicenseModeDict(),licenseModeDict);
			super.setLicenseModeDict(licenseModeDict);
			return this;
		}
		
		/**
		 * 设置 维保商
		 * @param maintainer 维保商
		 * @return 当前对象
		*/
		public AssetSoftware setMaintainer(Maintainer maintainer) {
			super.change(MAINTAINER,super.getMaintainer(),maintainer);
			super.setMaintainer(maintainer);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetSoftware clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetSoftware duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setSourceId(this.getSourceId());
			inst.setAuthorizationInfo(this.getAuthorizationInfo());
			inst.setAuthorizedNumberUnlimit(this.getAuthorizedNumberUnlimit());
			inst.setNotes(this.getNotes());
			inst.setProcId(this.getProcId());
			inst.setApprovalOpinion(this.getApprovalOpinion());
			inst.setLabel4(this.getLabel4());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setMaintenanceEndDate(this.getMaintenanceEndDate());
			inst.setAuthorizationExpirationDate(this.getAuthorizationExpirationDate());
			inst.setCtl(this.getCtl());
			inst.setId(this.getId());
			inst.setAuthorizedNumber(this.getAuthorizedNumber());
			inst.setNextApproverNames(this.getNextApproverNames());
			inst.setLatestApproverId(this.getLatestApproverId());
			inst.setUseOrganizationId(this.getUseOrganizationId());
			inst.setNeedMaintenance(this.getNeedMaintenance());
			inst.setVersion(this.getVersion());
			inst.setOwnCompanyId(this.getOwnCompanyId());
			inst.setMaintainerId(this.getMaintainerId());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setSoftwareVersion(this.getSoftwareVersion());
			inst.setStatus(this.getStatus());
			inst.setPurchaseDate(this.getPurchaseDate());
			inst.setChsVersion(this.getChsVersion());
			inst.setCode(this.getCode());
			inst.setLicenseMode(this.getLicenseMode());
			inst.setSupplierId(this.getSupplierId());
			inst.setOwnerCode(this.getOwnerCode());
			inst.setAuthorizationCode(this.getAuthorizationCode());
			inst.setLatestApproverName(this.getLatestApproverName());
			inst.setChangeInstanceId(this.getChangeInstanceId());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setContent(this.getContent());
			inst.setNextApproverIds(this.getNextApproverIds());
			inst.setChsStatus(this.getChsStatus());
			inst.setCopyrightType(this.getCopyrightType());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setAttachId(this.getAttachId());
			inst.setAuthorizationExpirationUnlimit(this.getAuthorizationExpirationUnlimit());
			inst.setRegisterDate(this.getRegisterDate());
			inst.setSummary(this.getSummary());
			inst.setCostPrice(this.getCostPrice());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setManagerId(this.getManagerId());
			inst.setLabel1(this.getLabel1());
			inst.setLabel2(this.getLabel2());
			inst.setLabel3(this.getLabel3());
			inst.setPositionDetail(this.getPositionDetail());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setSourceDetail(this.getSourceDetail());
			inst.setAuthorizedAvailableNumber(this.getAuthorizedAvailableNumber());
			inst.setCreateTime(this.getCreateTime());
			inst.setChsType(this.getChsType());
			inst.setTenantId(this.getTenantId());
			inst.setMaintenanceStartDate(this.getMaintenanceStartDate());
			inst.setCategoryId(this.getCategoryId());
			if(all) {
				inst.setUseOrganization(this.getUseOrganization());
				inst.setOwnerCompany(this.getOwnerCompany());
				inst.setManager(this.getManager());
				inst.setLicenseModeDict(this.getLicenseModeDict());
				inst.setSupplier(this.getSupplier());
				inst.setSource(this.getSource());
				inst.setOriginator(this.getOriginator());
				inst.setCategory(this.getCategory());
				inst.setMaintainer(this.getMaintainer());
				inst.setCopyrightTypeDict(this.getCopyrightTypeDict());
			}
			inst.clearModifies();
			return inst;
		}

	}
}