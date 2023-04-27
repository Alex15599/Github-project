package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetMaintenanceRecord;
import java.util.Date;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetStatus;
import org.github.foxnic.web.domain.pcm.Catalog;
import com.dt.platform.domain.eam.Maintainer;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.AssetMaintenanceUpdate;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-29 13:55:07
 * @sign 3642472EB799DEE09BA88B78E57CE64F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetMaintenanceRecordMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 维保更新 , 类型: java.lang.String
	*/
	public static final String MAINTENANCE_UPDATE_ID="maintenanceUpdateId";
	
	/**
	 * 维保更新 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> MAINTENANCE_UPDATE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,MAINTENANCE_UPDATE_ID, java.lang.String.class, "维保更新", "维保更新", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,ASSET_ID, java.lang.String.class, "资产", "资产", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String MAINTENANCE_NOTES="maintenanceNotes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> MAINTENANCE_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,MAINTENANCE_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 备注[状态] , 类型: java.lang.String
	*/
	public static final String S_MAINTENANCE_NOTES="sMaintenanceNotes";
	
	/**
	 * 备注[状态] , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> S_MAINTENANCE_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,S_MAINTENANCE_NOTES, java.lang.String.class, "备注[状态]", "备注[状态]", java.lang.String.class, null);
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final String MAINTAINER_ID="maintainerId";
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> MAINTAINER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,MAINTAINER_ID, java.lang.String.class, "维保厂商", "维保厂商", java.lang.String.class, null);
	
	/**
	 * 维保厂商[状态] , 类型: java.lang.String
	*/
	public static final String S_MAINTAINER_ID="sMaintainerId";
	
	/**
	 * 维保厂商[状态] , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> S_MAINTAINER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,S_MAINTAINER_ID, java.lang.String.class, "维保厂商[状态]", "维保厂商[状态]", java.lang.String.class, null);
	
	/**
	 * 维保厂商名称 , 类型: java.lang.String
	*/
	public static final String MAINTAINER_NAME="maintainerName";
	
	/**
	 * 维保厂商名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> MAINTAINER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,MAINTAINER_NAME, java.lang.String.class, "维保厂商名称", "维保厂商名称", java.lang.String.class, null);
	
	/**
	 * 维保厂商名称[状态] , 类型: java.lang.String
	*/
	public static final String S_MAINTAINER_NAME="sMaintainerName";
	
	/**
	 * 维保厂商名称[状态] , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> S_MAINTAINER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,S_MAINTAINER_NAME, java.lang.String.class, "维保厂商名称[状态]", "维保厂商名称[状态]", java.lang.String.class, null);
	
	/**
	 * 维保状态 , 类型: java.lang.String
	*/
	public static final String MAINTENANCE_STATUS="maintenanceStatus";
	
	/**
	 * 维保状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> MAINTENANCE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,MAINTENANCE_STATUS, java.lang.String.class, "维保状态", "维保状态", java.lang.String.class, null);
	
	/**
	 * 维保状态[状态] , 类型: java.lang.String
	*/
	public static final String S_MAINTENANCE_STATUS="sMaintenanceStatus";
	
	/**
	 * 维保状态[状态] , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> S_MAINTENANCE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,S_MAINTENANCE_STATUS, java.lang.String.class, "维保状态[状态]", "维保状态[状态]", java.lang.String.class, null);
	
	/**
	 * 维保方式 , 类型: java.lang.String
	*/
	public static final String MAINTENANCE_METHOD="maintenanceMethod";
	
	/**
	 * 维保方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,MAINTENANCE_METHOD, java.lang.String.class, "维保方式", "维保方式", java.lang.String.class, null);
	
	/**
	 * 维保方式[状态] , 类型: java.lang.String
	*/
	public static final String S_MAINTENANCE_METHOD="sMaintenanceMethod";
	
	/**
	 * 维保方式[状态] , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> S_MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,S_MAINTENANCE_METHOD, java.lang.String.class, "维保方式[状态]", "维保方式[状态]", java.lang.String.class, null);
	
	/**
	 * 建议维保方式 , 类型: java.lang.String
	*/
	public static final String SUGGEST_MAINTENANCE_METHOD="suggestMaintenanceMethod";
	
	/**
	 * 建议维保方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> SUGGEST_MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,SUGGEST_MAINTENANCE_METHOD, java.lang.String.class, "建议维保方式", "建议维保方式", java.lang.String.class, null);
	
	/**
	 * 建议维保方式[状态] , 类型: java.lang.String
	*/
	public static final String S_SUGGEST_MAINTENANCE_METHOD="sSuggestMaintenanceMethod";
	
	/**
	 * 建议维保方式[状态] , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> S_SUGGEST_MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,S_SUGGEST_MAINTENANCE_METHOD, java.lang.String.class, "建议维保方式[状态]", "建议维保方式[状态]", java.lang.String.class, null);
	
	/**
	 * 联系人 , 类型: java.lang.String
	*/
	public static final String CONTACTS="contacts";
	
	/**
	 * 联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,CONTACTS, java.lang.String.class, "联系人", "联系人", java.lang.String.class, null);
	
	/**
	 * 联系人[状态] , 类型: java.lang.String
	*/
	public static final String S_CONTACTS="sContacts";
	
	/**
	 * 联系人[状态] , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> S_CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,S_CONTACTS, java.lang.String.class, "联系人[状态]", "联系人[状态]", java.lang.String.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String CONTACT_INFORMATION="contactInformation";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,CONTACT_INFORMATION, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 联系方式[状态] , 类型: java.lang.String
	*/
	public static final String S_CONTACT_INFORMATION="sContactInformation";
	
	/**
	 * 联系方式[状态] , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> S_CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,S_CONTACT_INFORMATION, java.lang.String.class, "联系方式[状态]", "联系方式[状态]", java.lang.String.class, null);
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final String DIRECTOR="director";
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> DIRECTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,DIRECTOR, java.lang.String.class, "负责人", "负责人", java.lang.String.class, null);
	
	/**
	 * 负责人[状态] , 类型: java.lang.String
	*/
	public static final String S_DIRECTOR="sDirector";
	
	/**
	 * 负责人[状态] , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> S_DIRECTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,S_DIRECTOR, java.lang.String.class, "负责人[状态]", "负责人[状态]", java.lang.String.class, null);
	
	/**
	 * 维保开始时间 , 类型: java.util.Date
	*/
	public static final String MAINTENANCE_START_DATE="maintenanceStartDate";
	
	/**
	 * 维保开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.util.Date> MAINTENANCE_START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,MAINTENANCE_START_DATE, java.util.Date.class, "维保开始时间", "维保开始时间", java.util.Date.class, null);
	
	/**
	 * 维保开始时间[状态] , 类型: java.lang.String
	*/
	public static final String S_MAINTENANCE_START_DATE="sMaintenanceStartDate";
	
	/**
	 * 维保开始时间[状态] , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> S_MAINTENANCE_START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,S_MAINTENANCE_START_DATE, java.lang.String.class, "维保开始时间[状态]", "维保开始时间[状态]", java.lang.String.class, null);
	
	/**
	 * 维保到期时间 , 类型: java.util.Date
	*/
	public static final String MAINTENANCE_END_DATE="maintenanceEndDate";
	
	/**
	 * 维保到期时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.util.Date> MAINTENANCE_END_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,MAINTENANCE_END_DATE, java.util.Date.class, "维保到期时间", "维保到期时间", java.util.Date.class, null);
	
	/**
	 * 维保到期时间[状态] , 类型: java.lang.String
	*/
	public static final String S_MAINTENANCE_END_DATE="sMaintenanceEndDate";
	
	/**
	 * 维保到期时间[状态] , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> S_MAINTENANCE_END_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,S_MAINTENANCE_END_DATE, java.lang.String.class, "维保到期时间[状态]", "维保到期时间[状态]", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET="asset";
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,com.dt.platform.domain.eam.Asset> ASSET_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,ASSET, com.dt.platform.domain.eam.Asset.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 资产名称 , 类型: java.lang.String
	*/
	public static final String ASSET_ASSET_NAME="assetAssetName";
	
	/**
	 * 资产名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> ASSET_ASSET_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,ASSET_ASSET_NAME, java.lang.String.class, "资产名称", "资产名称", java.lang.String.class, null);
	
	/**
	 * 资产编码 , 类型: java.lang.String
	*/
	public static final String ASSET_ASSET_CODE="assetAssetCode";
	
	/**
	 * 资产编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> ASSET_ASSET_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,ASSET_ASSET_CODE, java.lang.String.class, "资产编码", "资产编码", java.lang.String.class, null);
	
	/**
	 * 资产型号 , 类型: java.lang.String
	*/
	public static final String ASSET_ASSET_MODEL="assetAssetModel";
	
	/**
	 * 资产型号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> ASSET_ASSET_MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,ASSET_ASSET_MODEL, java.lang.String.class, "资产型号", "资产型号", java.lang.String.class, null);
	
	/**
	 * 资产状态 , 类型: com.dt.platform.domain.eam.AssetStatus
	*/
	public static final String ASSET_STATUS="assetStatus";
	
	/**
	 * 资产状态 , 类型: com.dt.platform.domain.eam.AssetStatus
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,com.dt.platform.domain.eam.AssetStatus> ASSET_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,ASSET_STATUS, com.dt.platform.domain.eam.AssetStatus.class, "资产状态", "资产状态", com.dt.platform.domain.eam.AssetStatus.class, null);
	
	/**
	 * 资产分类 , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final String CATEGORY="category";
	
	/**
	 * 资产分类 , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,org.github.foxnic.web.domain.pcm.Catalog> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,CATEGORY, org.github.foxnic.web.domain.pcm.Catalog.class, "资产分类", "资产分类", org.github.foxnic.web.domain.pcm.Catalog.class, null);
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final String ASSET_ASSET_STATUS="assetAssetStatus";
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> ASSET_ASSET_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,ASSET_ASSET_STATUS, java.lang.String.class, "资产状态", "资产状态", java.lang.String.class, null);
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final String ASSET_ASSET_CATALOG="assetAssetCatalog";
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,java.lang.String> ASSET_ASSET_CATALOG_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,ASSET_ASSET_CATALOG, java.lang.String.class, "资产状态", "资产状态", java.lang.String.class, null);
	
	/**
	 * 维保商 , 类型: com.dt.platform.domain.eam.Maintainer
	*/
	public static final String MAINTNAINER="maintnainer";
	
	/**
	 * 维保商 , 类型: com.dt.platform.domain.eam.Maintainer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,com.dt.platform.domain.eam.Maintainer> MAINTNAINER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,MAINTNAINER, com.dt.platform.domain.eam.Maintainer.class, "维保商", "维保商", com.dt.platform.domain.eam.Maintainer.class, null);
	
	/**
	 * 维保状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String ASSET_MAINTENANCE_STATUS="assetMaintenanceStatus";
	
	/**
	 * 维保状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,org.github.foxnic.web.domain.system.DictItem> ASSET_MAINTENANCE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,ASSET_MAINTENANCE_STATUS, org.github.foxnic.web.domain.system.DictItem.class, "维保状态", "维保状态", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 建议维保方式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SUGGEST_MAINTENANCE_METHOD_DATA="suggestMaintenanceMethodData";
	
	/**
	 * 建议维保方式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,org.github.foxnic.web.domain.system.DictItem> SUGGEST_MAINTENANCE_METHOD_DATA_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,SUGGEST_MAINTENANCE_METHOD_DATA, org.github.foxnic.web.domain.system.DictItem.class, "建议维保方式", "建议维保方式", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 维保方式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String MAINTENANCE_METHOD_DATA="maintenanceMethodData";
	
	/**
	 * 维保方式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,org.github.foxnic.web.domain.system.DictItem> MAINTENANCE_METHOD_DATA_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,MAINTENANCE_METHOD_DATA, org.github.foxnic.web.domain.system.DictItem.class, "维保方式", "维保方式", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * assetMaintenanceUpdate , 类型: com.dt.platform.domain.eam.AssetMaintenanceUpdate
	*/
	public static final String ASSET_MAINTENANCE_UPDATE="assetMaintenanceUpdate";
	
	/**
	 * assetMaintenanceUpdate , 类型: com.dt.platform.domain.eam.AssetMaintenanceUpdate
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecord,com.dt.platform.domain.eam.AssetMaintenanceUpdate> ASSET_MAINTENANCE_UPDATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecord.class ,ASSET_MAINTENANCE_UPDATE, com.dt.platform.domain.eam.AssetMaintenanceUpdate.class, "assetMaintenanceUpdate", "assetMaintenanceUpdate", com.dt.platform.domain.eam.AssetMaintenanceUpdate.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , MAINTENANCE_UPDATE_ID , ASSET_ID , MAINTENANCE_NOTES , S_MAINTENANCE_NOTES , MAINTAINER_ID , S_MAINTAINER_ID , MAINTAINER_NAME , S_MAINTAINER_NAME , MAINTENANCE_STATUS , S_MAINTENANCE_STATUS , MAINTENANCE_METHOD , S_MAINTENANCE_METHOD , SUGGEST_MAINTENANCE_METHOD , S_SUGGEST_MAINTENANCE_METHOD , CONTACTS , S_CONTACTS , CONTACT_INFORMATION , S_CONTACT_INFORMATION , DIRECTOR , S_DIRECTOR , MAINTENANCE_START_DATE , S_MAINTENANCE_START_DATE , MAINTENANCE_END_DATE , S_MAINTENANCE_END_DATE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ASSET , ASSET_ASSET_NAME , ASSET_ASSET_CODE , ASSET_ASSET_MODEL , ASSET_STATUS , CATEGORY , ASSET_ASSET_STATUS , ASSET_ASSET_CATALOG , MAINTNAINER , ASSET_MAINTENANCE_STATUS , SUGGEST_MAINTENANCE_METHOD_DATA , MAINTENANCE_METHOD_DATA , ASSET_MAINTENANCE_UPDATE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetMaintenanceRecord {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 维保更新
		 * @param maintenanceUpdateId 维保更新
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setMaintenanceUpdateId(String maintenanceUpdateId) {
			super.change(MAINTENANCE_UPDATE_ID,super.getMaintenanceUpdateId(),maintenanceUpdateId);
			super.setMaintenanceUpdateId(maintenanceUpdateId);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetId 资产
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param maintenanceNotes 备注
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setMaintenanceNotes(String maintenanceNotes) {
			super.change(MAINTENANCE_NOTES,super.getMaintenanceNotes(),maintenanceNotes);
			super.setMaintenanceNotes(maintenanceNotes);
			return this;
		}
		
		/**
		 * 设置 备注[状态]
		 * @param sMaintenanceNotes 备注[状态]
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setSMaintenanceNotes(String sMaintenanceNotes) {
			super.change(S_MAINTENANCE_NOTES,super.getSMaintenanceNotes(),sMaintenanceNotes);
			super.setSMaintenanceNotes(sMaintenanceNotes);
			return this;
		}
		
		/**
		 * 设置 维保厂商
		 * @param maintainerId 维保厂商
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setMaintainerId(String maintainerId) {
			super.change(MAINTAINER_ID,super.getMaintainerId(),maintainerId);
			super.setMaintainerId(maintainerId);
			return this;
		}
		
		/**
		 * 设置 维保厂商[状态]
		 * @param sMaintainerId 维保厂商[状态]
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setSMaintainerId(String sMaintainerId) {
			super.change(S_MAINTAINER_ID,super.getSMaintainerId(),sMaintainerId);
			super.setSMaintainerId(sMaintainerId);
			return this;
		}
		
		/**
		 * 设置 维保厂商名称
		 * @param maintainerName 维保厂商名称
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setMaintainerName(String maintainerName) {
			super.change(MAINTAINER_NAME,super.getMaintainerName(),maintainerName);
			super.setMaintainerName(maintainerName);
			return this;
		}
		
		/**
		 * 设置 维保厂商名称[状态]
		 * @param sMaintainerName 维保厂商名称[状态]
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setSMaintainerName(String sMaintainerName) {
			super.change(S_MAINTAINER_NAME,super.getSMaintainerName(),sMaintainerName);
			super.setSMaintainerName(sMaintainerName);
			return this;
		}
		
		/**
		 * 设置 维保状态
		 * @param maintenanceStatus 维保状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setMaintenanceStatus(String maintenanceStatus) {
			super.change(MAINTENANCE_STATUS,super.getMaintenanceStatus(),maintenanceStatus);
			super.setMaintenanceStatus(maintenanceStatus);
			return this;
		}
		
		/**
		 * 设置 维保状态[状态]
		 * @param sMaintenanceStatus 维保状态[状态]
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setSMaintenanceStatus(String sMaintenanceStatus) {
			super.change(S_MAINTENANCE_STATUS,super.getSMaintenanceStatus(),sMaintenanceStatus);
			super.setSMaintenanceStatus(sMaintenanceStatus);
			return this;
		}
		
		/**
		 * 设置 维保方式
		 * @param maintenanceMethod 维保方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setMaintenanceMethod(String maintenanceMethod) {
			super.change(MAINTENANCE_METHOD,super.getMaintenanceMethod(),maintenanceMethod);
			super.setMaintenanceMethod(maintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 维保方式[状态]
		 * @param sMaintenanceMethod 维保方式[状态]
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setSMaintenanceMethod(String sMaintenanceMethod) {
			super.change(S_MAINTENANCE_METHOD,super.getSMaintenanceMethod(),sMaintenanceMethod);
			super.setSMaintenanceMethod(sMaintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 建议维保方式
		 * @param suggestMaintenanceMethod 建议维保方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setSuggestMaintenanceMethod(String suggestMaintenanceMethod) {
			super.change(SUGGEST_MAINTENANCE_METHOD,super.getSuggestMaintenanceMethod(),suggestMaintenanceMethod);
			super.setSuggestMaintenanceMethod(suggestMaintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 建议维保方式[状态]
		 * @param sSuggestMaintenanceMethod 建议维保方式[状态]
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setSSuggestMaintenanceMethod(String sSuggestMaintenanceMethod) {
			super.change(S_SUGGEST_MAINTENANCE_METHOD,super.getSSuggestMaintenanceMethod(),sSuggestMaintenanceMethod);
			super.setSSuggestMaintenanceMethod(sSuggestMaintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 联系人
		 * @param contacts 联系人
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setContacts(String contacts) {
			super.change(CONTACTS,super.getContacts(),contacts);
			super.setContacts(contacts);
			return this;
		}
		
		/**
		 * 设置 联系人[状态]
		 * @param sContacts 联系人[状态]
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setSContacts(String sContacts) {
			super.change(S_CONTACTS,super.getSContacts(),sContacts);
			super.setSContacts(sContacts);
			return this;
		}
		
		/**
		 * 设置 联系方式
		 * @param contactInformation 联系方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setContactInformation(String contactInformation) {
			super.change(CONTACT_INFORMATION,super.getContactInformation(),contactInformation);
			super.setContactInformation(contactInformation);
			return this;
		}
		
		/**
		 * 设置 联系方式[状态]
		 * @param sContactInformation 联系方式[状态]
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setSContactInformation(String sContactInformation) {
			super.change(S_CONTACT_INFORMATION,super.getSContactInformation(),sContactInformation);
			super.setSContactInformation(sContactInformation);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param director 负责人
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setDirector(String director) {
			super.change(DIRECTOR,super.getDirector(),director);
			super.setDirector(director);
			return this;
		}
		
		/**
		 * 设置 负责人[状态]
		 * @param sDirector 负责人[状态]
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setSDirector(String sDirector) {
			super.change(S_DIRECTOR,super.getSDirector(),sDirector);
			super.setSDirector(sDirector);
			return this;
		}
		
		/**
		 * 设置 维保开始时间
		 * @param maintenanceStartDate 维保开始时间
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setMaintenanceStartDate(Date maintenanceStartDate) {
			super.change(MAINTENANCE_START_DATE,super.getMaintenanceStartDate(),maintenanceStartDate);
			super.setMaintenanceStartDate(maintenanceStartDate);
			return this;
		}
		
		/**
		 * 设置 维保开始时间[状态]
		 * @param sMaintenanceStartDate 维保开始时间[状态]
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setSMaintenanceStartDate(String sMaintenanceStartDate) {
			super.change(S_MAINTENANCE_START_DATE,super.getSMaintenanceStartDate(),sMaintenanceStartDate);
			super.setSMaintenanceStartDate(sMaintenanceStartDate);
			return this;
		}
		
		/**
		 * 设置 维保到期时间
		 * @param maintenanceEndDate 维保到期时间
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setMaintenanceEndDate(Date maintenanceEndDate) {
			super.change(MAINTENANCE_END_DATE,super.getMaintenanceEndDate(),maintenanceEndDate);
			super.setMaintenanceEndDate(maintenanceEndDate);
			return this;
		}
		
		/**
		 * 设置 维保到期时间[状态]
		 * @param sMaintenanceEndDate 维保到期时间[状态]
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setSMaintenanceEndDate(String sMaintenanceEndDate) {
			super.change(S_MAINTENANCE_END_DATE,super.getSMaintenanceEndDate(),sMaintenanceEndDate);
			super.setSMaintenanceEndDate(sMaintenanceEndDate);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param asset 资产
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setAsset(Asset asset) {
			super.change(ASSET,super.getAsset(),asset);
			super.setAsset(asset);
			return this;
		}
		
		/**
		 * 设置 资产名称
		 * @param assetAssetName 资产名称
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setAssetAssetName(String assetAssetName) {
			super.change(ASSET_ASSET_NAME,super.getAssetAssetName(),assetAssetName);
			super.setAssetAssetName(assetAssetName);
			return this;
		}
		
		/**
		 * 设置 资产编码
		 * @param assetAssetCode 资产编码
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setAssetAssetCode(String assetAssetCode) {
			super.change(ASSET_ASSET_CODE,super.getAssetAssetCode(),assetAssetCode);
			super.setAssetAssetCode(assetAssetCode);
			return this;
		}
		
		/**
		 * 设置 资产型号
		 * @param assetAssetModel 资产型号
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setAssetAssetModel(String assetAssetModel) {
			super.change(ASSET_ASSET_MODEL,super.getAssetAssetModel(),assetAssetModel);
			super.setAssetAssetModel(assetAssetModel);
			return this;
		}
		
		/**
		 * 设置 资产状态
		 * @param assetStatus 资产状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setAssetStatus(AssetStatus assetStatus) {
			super.change(ASSET_STATUS,super.getAssetStatus(),assetStatus);
			super.setAssetStatus(assetStatus);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param category 资产分类
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setCategory(Catalog category) {
			super.change(CATEGORY,super.getCategory(),category);
			super.setCategory(category);
			return this;
		}
		
		/**
		 * 设置 资产状态
		 * @param assetAssetStatus 资产状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setAssetAssetStatus(String assetAssetStatus) {
			super.change(ASSET_ASSET_STATUS,super.getAssetAssetStatus(),assetAssetStatus);
			super.setAssetAssetStatus(assetAssetStatus);
			return this;
		}
		
		/**
		 * 设置 资产状态
		 * @param assetAssetCatalog 资产状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setAssetAssetCatalog(String assetAssetCatalog) {
			super.change(ASSET_ASSET_CATALOG,super.getAssetAssetCatalog(),assetAssetCatalog);
			super.setAssetAssetCatalog(assetAssetCatalog);
			return this;
		}
		
		/**
		 * 设置 维保商
		 * @param maintnainer 维保商
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setMaintnainer(Maintainer maintnainer) {
			super.change(MAINTNAINER,super.getMaintnainer(),maintnainer);
			super.setMaintnainer(maintnainer);
			return this;
		}
		
		/**
		 * 设置 维保状态
		 * @param assetMaintenanceStatus 维保状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setAssetMaintenanceStatus(DictItem assetMaintenanceStatus) {
			super.change(ASSET_MAINTENANCE_STATUS,super.getAssetMaintenanceStatus(),assetMaintenanceStatus);
			super.setAssetMaintenanceStatus(assetMaintenanceStatus);
			return this;
		}
		
		/**
		 * 设置 建议维保方式
		 * @param suggestMaintenanceMethodData 建议维保方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setSuggestMaintenanceMethodData(DictItem suggestMaintenanceMethodData) {
			super.change(SUGGEST_MAINTENANCE_METHOD_DATA,super.getSuggestMaintenanceMethodData(),suggestMaintenanceMethodData);
			super.setSuggestMaintenanceMethodData(suggestMaintenanceMethodData);
			return this;
		}
		
		/**
		 * 设置 维保方式
		 * @param maintenanceMethodData 维保方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setMaintenanceMethodData(DictItem maintenanceMethodData) {
			super.change(MAINTENANCE_METHOD_DATA,super.getMaintenanceMethodData(),maintenanceMethodData);
			super.setMaintenanceMethodData(maintenanceMethodData);
			return this;
		}
		
		/**
		 * 设置 assetMaintenanceUpdate
		 * @param assetMaintenanceUpdate assetMaintenanceUpdate
		 * @return 当前对象
		*/
		public AssetMaintenanceRecord setAssetMaintenanceUpdate(AssetMaintenanceUpdate assetMaintenanceUpdate) {
			super.change(ASSET_MAINTENANCE_UPDATE,super.getAssetMaintenanceUpdate(),assetMaintenanceUpdate);
			super.setAssetMaintenanceUpdate(assetMaintenanceUpdate);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetMaintenanceRecord clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetMaintenanceRecord duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setMaintenanceStatus(this.getMaintenanceStatus());
			inst.setSMaintenanceStartDate(this.getSMaintenanceStartDate());
			inst.setMaintenanceEndDate(this.getMaintenanceEndDate());
			inst.setSContactInformation(this.getSContactInformation());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setAssetId(this.getAssetId());
			inst.setSuggestMaintenanceMethod(this.getSuggestMaintenanceMethod());
			inst.setId(this.getId());
			inst.setMaintainerName(this.getMaintainerName());
			inst.setSMaintenanceMethod(this.getSMaintenanceMethod());
			inst.setSDirector(this.getSDirector());
			inst.setSContacts(this.getSContacts());
			inst.setSSuggestMaintenanceMethod(this.getSSuggestMaintenanceMethod());
			inst.setSMaintainerName(this.getSMaintainerName());
			inst.setDirector(this.getDirector());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setSMaintenanceNotes(this.getSMaintenanceNotes());
			inst.setSMaintainerId(this.getSMaintainerId());
			inst.setSMaintenanceStatus(this.getSMaintenanceStatus());
			inst.setMaintenanceNotes(this.getMaintenanceNotes());
			inst.setMaintainerId(this.getMaintainerId());
			inst.setCreateBy(this.getCreateBy());
			inst.setContactInformation(this.getContactInformation());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setMaintenanceUpdateId(this.getMaintenanceUpdateId());
			inst.setTenantId(this.getTenantId());
			inst.setMaintenanceMethod(this.getMaintenanceMethod());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setMaintenanceStartDate(this.getMaintenanceStartDate());
			inst.setSMaintenanceEndDate(this.getSMaintenanceEndDate());
			inst.setContacts(this.getContacts());
			if(all) {
				inst.setAssetAssetName(this.getAssetAssetName());
				inst.setSuggestMaintenanceMethodData(this.getSuggestMaintenanceMethodData());
				inst.setAssetAssetStatus(this.getAssetAssetStatus());
				inst.setAssetAssetCode(this.getAssetAssetCode());
				inst.setAssetAssetCatalog(this.getAssetAssetCatalog());
				inst.setAssetAssetModel(this.getAssetAssetModel());
				inst.setMaintnainer(this.getMaintnainer());
				inst.setAssetMaintenanceStatus(this.getAssetMaintenanceStatus());
				inst.setAssetMaintenanceUpdate(this.getAssetMaintenanceUpdate());
				inst.setMaintenanceMethodData(this.getMaintenanceMethodData());
				inst.setAsset(this.getAsset());
				inst.setCategory(this.getCategory());
				inst.setAssetStatus(this.getAssetStatus());
			}
			inst.clearModifies();
			return inst;
		}

	}
}