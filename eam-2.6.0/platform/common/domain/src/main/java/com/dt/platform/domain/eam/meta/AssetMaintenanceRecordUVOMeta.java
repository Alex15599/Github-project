package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetMaintenanceRecordUVO;
import java.util.List;
import com.dt.platform.domain.eam.AssetMaintenanceRecordU;
import java.util.Date;
import com.dt.platform.domain.eam.Maintainer;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.AssetMaintenanceUpdate;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-29 15:12:32
 * @sign 9B0ACCC449BFC41E29E1C167B4932025
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetMaintenanceRecordUVOMeta extends AssetMaintenanceRecordUMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 维保更新 , 类型: java.lang.String
	*/
	public static final String MAINTENANCE_UPDATE_ID="maintenanceUpdateId";
	
	/**
	 * 维保更新 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> MAINTENANCE_UPDATE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,MAINTENANCE_UPDATE_ID, java.lang.String.class, "维保更新", "维保更新", java.lang.String.class, null);
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final String MAINTAINER_ID="maintainerId";
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> MAINTAINER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,MAINTAINER_ID, java.lang.String.class, "维保厂商", "维保厂商", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String S_MAINTAINER_ID="sMaintainerId";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> S_MAINTAINER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,S_MAINTAINER_ID, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_MAINTAINER_ID="uMaintainerId";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_MAINTAINER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_MAINTAINER_ID, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_S_MAINTAINER_ID="uSMaintainerId";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_S_MAINTAINER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_S_MAINTAINER_ID, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 维保厂商名称 , 类型: java.lang.String
	*/
	public static final String MAINTAINER_NAME="maintainerName";
	
	/**
	 * 维保厂商名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> MAINTAINER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,MAINTAINER_NAME, java.lang.String.class, "维保厂商名称", "维保厂商名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String S_MAINTAINER_NAME="sMaintainerName";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> S_MAINTAINER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,S_MAINTAINER_NAME, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_MAINTAINER_NAME="uMaintainerName";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_MAINTAINER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_MAINTAINER_NAME, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_S_MAINTAINER_NAME="uSMaintainerName";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_S_MAINTAINER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_S_MAINTAINER_NAME, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 维保状态 , 类型: java.lang.String
	*/
	public static final String MAINTENANCE_STATUS="maintenanceStatus";
	
	/**
	 * 维保状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> MAINTENANCE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,MAINTENANCE_STATUS, java.lang.String.class, "维保状态", "维保状态", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String S_MAINTENANCE_STATUS="sMaintenanceStatus";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> S_MAINTENANCE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,S_MAINTENANCE_STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_MAINTENANCE_STATUS="uMaintenanceStatus";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_MAINTENANCE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_MAINTENANCE_STATUS, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_S_MAINTENANCE_STATUS="uSMaintenanceStatus";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_S_MAINTENANCE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_S_MAINTENANCE_STATUS, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 维保方式 , 类型: java.lang.String
	*/
	public static final String MAINTENANCE_METHOD="maintenanceMethod";
	
	/**
	 * 维保方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,MAINTENANCE_METHOD, java.lang.String.class, "维保方式", "维保方式", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String S_MAINTENANCE_METHOD="sMaintenanceMethod";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> S_MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,S_MAINTENANCE_METHOD, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_MAINTENANCE_METHOD="uMaintenanceMethod";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_MAINTENANCE_METHOD, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_S_MAINTENANCE_METHOD="uSMaintenanceMethod";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_S_MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_S_MAINTENANCE_METHOD, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String CONTACT_INFORMATION="contactInformation";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,CONTACT_INFORMATION, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String S_CONTACT_INFORMATION="sContactInformation";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> S_CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,S_CONTACT_INFORMATION, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_CONTACT_INFORMATION="uContactInformation";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_CONTACT_INFORMATION, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_S_CONTACT_INFORMATION="uSContactInformation";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_S_CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_S_CONTACT_INFORMATION, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 建议维保方式 , 类型: java.lang.String
	*/
	public static final String SUGGEST_MAINTENANCE_METHOD="suggestMaintenanceMethod";
	
	/**
	 * 建议维保方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> SUGGEST_MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,SUGGEST_MAINTENANCE_METHOD, java.lang.String.class, "建议维保方式", "建议维保方式", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String S_SUGGEST_MAINTENANCE_METHOD="sSuggestMaintenanceMethod";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> S_SUGGEST_MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,S_SUGGEST_MAINTENANCE_METHOD, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_SUGGEST_MAINTENANCE_METHOD="uSuggestMaintenanceMethod";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_SUGGEST_MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_SUGGEST_MAINTENANCE_METHOD, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_S_SUGGEST_MAINTENANCE_METHOD="uSSuggestMaintenanceMethod";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_S_SUGGEST_MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_S_SUGGEST_MAINTENANCE_METHOD, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 联系人 , 类型: java.lang.String
	*/
	public static final String CONTACTS="contacts";
	
	/**
	 * 联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,CONTACTS, java.lang.String.class, "联系人", "联系人", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String S_CONTACTS="sContacts";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> S_CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,S_CONTACTS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_CONTACTS="uContacts";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_CONTACTS, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_S_CONTACTS="uSContacts";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_S_CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_S_CONTACTS, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final String DIRECTOR="director";
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> DIRECTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,DIRECTOR, java.lang.String.class, "负责人", "负责人", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String S_DIRECTOR="sDirector";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> S_DIRECTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,S_DIRECTOR, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_DIRECTOR="uDirector";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_DIRECTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_DIRECTOR, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_S_DIRECTOR="uSDirector";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_S_DIRECTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_S_DIRECTOR, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 维保开始时间 , 类型: java.util.Date
	*/
	public static final String MAINTENANCE_START_DATE="maintenanceStartDate";
	
	/**
	 * 维保开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.util.Date> MAINTENANCE_START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,MAINTENANCE_START_DATE, java.util.Date.class, "维保开始时间", "维保开始时间", java.util.Date.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String S_MAINTENANCE_START_DATE="sMaintenanceStartDate";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> S_MAINTENANCE_START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,S_MAINTENANCE_START_DATE, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_MAINTENANCE_START_DATE="uMaintenanceStartDate";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_MAINTENANCE_START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_MAINTENANCE_START_DATE, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_S_MAINTENANCE_START_DATE="uSMaintenanceStartDate";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_S_MAINTENANCE_START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_S_MAINTENANCE_START_DATE, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 维保到期时间 , 类型: java.util.Date
	*/
	public static final String MAINTENANCE_END_DATE="maintenanceEndDate";
	
	/**
	 * 维保到期时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.util.Date> MAINTENANCE_END_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,MAINTENANCE_END_DATE, java.util.Date.class, "维保到期时间", "维保到期时间", java.util.Date.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String S_MAINTENANCE_END_DATE="sMaintenanceEndDate";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> S_MAINTENANCE_END_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,S_MAINTENANCE_END_DATE, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_MAINTENANCE_END_DATE="uMaintenanceEndDate";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_MAINTENANCE_END_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_MAINTENANCE_END_DATE, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_S_MAINTENANCE_END_DATE="uSMaintenanceEndDate";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_S_MAINTENANCE_END_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_S_MAINTENANCE_END_DATE, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String MAINTENANCE_NOTES="maintenanceNotes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> MAINTENANCE_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,MAINTENANCE_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String S_MAINTENANCE_NOTES="sMaintenanceNotes";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> S_MAINTENANCE_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,S_MAINTENANCE_NOTES, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_MAINTENANCE_NOTES="uMaintenanceNotes";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_MAINTENANCE_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_MAINTENANCE_NOTES, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final String U_S_MAINTENANCE_NOTES="uSMaintenanceNotes";
	
	/**
	 * 更新方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> U_S_MAINTENANCE_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,U_S_MAINTENANCE_NOTES, java.lang.String.class, "更新方式", "更新方式", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * recordIdList , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String RECORD_ID_LIST="recordIdList";
	
	/**
	 * recordIdList , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,java.lang.String> RECORD_ID_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,RECORD_ID_LIST, java.util.List.class, "recordIdList", "recordIdList", java.lang.String.class, null);
	
	/**
	 * 维保商 , 类型: com.dt.platform.domain.eam.Maintainer
	*/
	public static final String MAINTNAINER="maintnainer";
	
	/**
	 * 维保商 , 类型: com.dt.platform.domain.eam.Maintainer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,com.dt.platform.domain.eam.Maintainer> MAINTNAINER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,MAINTNAINER, com.dt.platform.domain.eam.Maintainer.class, "维保商", "维保商", com.dt.platform.domain.eam.Maintainer.class, null);
	
	/**
	 * 维保状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String ASSET_MAINTENANCE_STATUS="assetMaintenanceStatus";
	
	/**
	 * 维保状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,org.github.foxnic.web.domain.system.DictItem> ASSET_MAINTENANCE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,ASSET_MAINTENANCE_STATUS, org.github.foxnic.web.domain.system.DictItem.class, "维保状态", "维保状态", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 建议维保方式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SUGGEST_MAINTENANCE_METHOD_DATA="suggestMaintenanceMethodData";
	
	/**
	 * 建议维保方式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,org.github.foxnic.web.domain.system.DictItem> SUGGEST_MAINTENANCE_METHOD_DATA_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,SUGGEST_MAINTENANCE_METHOD_DATA, org.github.foxnic.web.domain.system.DictItem.class, "建议维保方式", "建议维保方式", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 维保方式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String MAINTENANCE_METHOD_DATA="maintenanceMethodData";
	
	/**
	 * 维保方式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,org.github.foxnic.web.domain.system.DictItem> MAINTENANCE_METHOD_DATA_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,MAINTENANCE_METHOD_DATA, org.github.foxnic.web.domain.system.DictItem.class, "维保方式", "维保方式", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * assetMaintenanceUpdate , 类型: com.dt.platform.domain.eam.AssetMaintenanceUpdate
	*/
	public static final String ASSET_MAINTENANCE_UPDATE="assetMaintenanceUpdate";
	
	/**
	 * assetMaintenanceUpdate , 类型: com.dt.platform.domain.eam.AssetMaintenanceUpdate
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetMaintenanceRecordUVO,com.dt.platform.domain.eam.AssetMaintenanceUpdate> ASSET_MAINTENANCE_UPDATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetMaintenanceRecordUVO.class ,ASSET_MAINTENANCE_UPDATE, com.dt.platform.domain.eam.AssetMaintenanceUpdate.class, "assetMaintenanceUpdate", "assetMaintenanceUpdate", com.dt.platform.domain.eam.AssetMaintenanceUpdate.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , MAINTENANCE_UPDATE_ID , MAINTAINER_ID , S_MAINTAINER_ID , U_MAINTAINER_ID , U_S_MAINTAINER_ID , MAINTAINER_NAME , S_MAINTAINER_NAME , U_MAINTAINER_NAME , U_S_MAINTAINER_NAME , MAINTENANCE_STATUS , S_MAINTENANCE_STATUS , U_MAINTENANCE_STATUS , U_S_MAINTENANCE_STATUS , MAINTENANCE_METHOD , S_MAINTENANCE_METHOD , U_MAINTENANCE_METHOD , U_S_MAINTENANCE_METHOD , CONTACT_INFORMATION , S_CONTACT_INFORMATION , U_CONTACT_INFORMATION , U_S_CONTACT_INFORMATION , SUGGEST_MAINTENANCE_METHOD , S_SUGGEST_MAINTENANCE_METHOD , U_SUGGEST_MAINTENANCE_METHOD , U_S_SUGGEST_MAINTENANCE_METHOD , CONTACTS , S_CONTACTS , U_CONTACTS , U_S_CONTACTS , DIRECTOR , S_DIRECTOR , U_DIRECTOR , U_S_DIRECTOR , MAINTENANCE_START_DATE , S_MAINTENANCE_START_DATE , U_MAINTENANCE_START_DATE , U_S_MAINTENANCE_START_DATE , MAINTENANCE_END_DATE , S_MAINTENANCE_END_DATE , U_MAINTENANCE_END_DATE , U_S_MAINTENANCE_END_DATE , MAINTENANCE_NOTES , S_MAINTENANCE_NOTES , U_MAINTENANCE_NOTES , U_S_MAINTENANCE_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , RECORD_ID_LIST , MAINTNAINER , ASSET_MAINTENANCE_STATUS , SUGGEST_MAINTENANCE_METHOD_DATA , MAINTENANCE_METHOD_DATA , ASSET_MAINTENANCE_UPDATE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetMaintenanceRecordUVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordUVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordUVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordUVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordUVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordUVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordUVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordUVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordUVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordUVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 维保更新
		 * @param maintenanceUpdateId 维保更新
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setMaintenanceUpdateId(String maintenanceUpdateId) {
			super.change(MAINTENANCE_UPDATE_ID,super.getMaintenanceUpdateId(),maintenanceUpdateId);
			super.setMaintenanceUpdateId(maintenanceUpdateId);
			return this;
		}
		
		/**
		 * 设置 维保厂商
		 * @param maintainerId 维保厂商
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setMaintainerId(String maintainerId) {
			super.change(MAINTAINER_ID,super.getMaintainerId(),maintainerId);
			super.setMaintainerId(maintainerId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param sMaintainerId 状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setSMaintainerId(String sMaintainerId) {
			super.change(S_MAINTAINER_ID,super.getSMaintainerId(),sMaintainerId);
			super.setSMaintainerId(sMaintainerId);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uMaintainerId 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUMaintainerId(String uMaintainerId) {
			super.change(U_MAINTAINER_ID,super.getUMaintainerId(),uMaintainerId);
			super.setUMaintainerId(uMaintainerId);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uSMaintainerId 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUSMaintainerId(String uSMaintainerId) {
			super.change(U_S_MAINTAINER_ID,super.getUSMaintainerId(),uSMaintainerId);
			super.setUSMaintainerId(uSMaintainerId);
			return this;
		}
		
		/**
		 * 设置 维保厂商名称
		 * @param maintainerName 维保厂商名称
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setMaintainerName(String maintainerName) {
			super.change(MAINTAINER_NAME,super.getMaintainerName(),maintainerName);
			super.setMaintainerName(maintainerName);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param sMaintainerName 状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setSMaintainerName(String sMaintainerName) {
			super.change(S_MAINTAINER_NAME,super.getSMaintainerName(),sMaintainerName);
			super.setSMaintainerName(sMaintainerName);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uMaintainerName 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUMaintainerName(String uMaintainerName) {
			super.change(U_MAINTAINER_NAME,super.getUMaintainerName(),uMaintainerName);
			super.setUMaintainerName(uMaintainerName);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uSMaintainerName 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUSMaintainerName(String uSMaintainerName) {
			super.change(U_S_MAINTAINER_NAME,super.getUSMaintainerName(),uSMaintainerName);
			super.setUSMaintainerName(uSMaintainerName);
			return this;
		}
		
		/**
		 * 设置 维保状态
		 * @param maintenanceStatus 维保状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setMaintenanceStatus(String maintenanceStatus) {
			super.change(MAINTENANCE_STATUS,super.getMaintenanceStatus(),maintenanceStatus);
			super.setMaintenanceStatus(maintenanceStatus);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param sMaintenanceStatus 状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setSMaintenanceStatus(String sMaintenanceStatus) {
			super.change(S_MAINTENANCE_STATUS,super.getSMaintenanceStatus(),sMaintenanceStatus);
			super.setSMaintenanceStatus(sMaintenanceStatus);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uMaintenanceStatus 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUMaintenanceStatus(String uMaintenanceStatus) {
			super.change(U_MAINTENANCE_STATUS,super.getUMaintenanceStatus(),uMaintenanceStatus);
			super.setUMaintenanceStatus(uMaintenanceStatus);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uSMaintenanceStatus 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUSMaintenanceStatus(String uSMaintenanceStatus) {
			super.change(U_S_MAINTENANCE_STATUS,super.getUSMaintenanceStatus(),uSMaintenanceStatus);
			super.setUSMaintenanceStatus(uSMaintenanceStatus);
			return this;
		}
		
		/**
		 * 设置 维保方式
		 * @param maintenanceMethod 维保方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setMaintenanceMethod(String maintenanceMethod) {
			super.change(MAINTENANCE_METHOD,super.getMaintenanceMethod(),maintenanceMethod);
			super.setMaintenanceMethod(maintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param sMaintenanceMethod 状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setSMaintenanceMethod(String sMaintenanceMethod) {
			super.change(S_MAINTENANCE_METHOD,super.getSMaintenanceMethod(),sMaintenanceMethod);
			super.setSMaintenanceMethod(sMaintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uMaintenanceMethod 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUMaintenanceMethod(String uMaintenanceMethod) {
			super.change(U_MAINTENANCE_METHOD,super.getUMaintenanceMethod(),uMaintenanceMethod);
			super.setUMaintenanceMethod(uMaintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uSMaintenanceMethod 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUSMaintenanceMethod(String uSMaintenanceMethod) {
			super.change(U_S_MAINTENANCE_METHOD,super.getUSMaintenanceMethod(),uSMaintenanceMethod);
			super.setUSMaintenanceMethod(uSMaintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 联系方式
		 * @param contactInformation 联系方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setContactInformation(String contactInformation) {
			super.change(CONTACT_INFORMATION,super.getContactInformation(),contactInformation);
			super.setContactInformation(contactInformation);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param sContactInformation 状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setSContactInformation(String sContactInformation) {
			super.change(S_CONTACT_INFORMATION,super.getSContactInformation(),sContactInformation);
			super.setSContactInformation(sContactInformation);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uContactInformation 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUContactInformation(String uContactInformation) {
			super.change(U_CONTACT_INFORMATION,super.getUContactInformation(),uContactInformation);
			super.setUContactInformation(uContactInformation);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uSContactInformation 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUSContactInformation(String uSContactInformation) {
			super.change(U_S_CONTACT_INFORMATION,super.getUSContactInformation(),uSContactInformation);
			super.setUSContactInformation(uSContactInformation);
			return this;
		}
		
		/**
		 * 设置 建议维保方式
		 * @param suggestMaintenanceMethod 建议维保方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setSuggestMaintenanceMethod(String suggestMaintenanceMethod) {
			super.change(SUGGEST_MAINTENANCE_METHOD,super.getSuggestMaintenanceMethod(),suggestMaintenanceMethod);
			super.setSuggestMaintenanceMethod(suggestMaintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param sSuggestMaintenanceMethod 状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setSSuggestMaintenanceMethod(String sSuggestMaintenanceMethod) {
			super.change(S_SUGGEST_MAINTENANCE_METHOD,super.getSSuggestMaintenanceMethod(),sSuggestMaintenanceMethod);
			super.setSSuggestMaintenanceMethod(sSuggestMaintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uSuggestMaintenanceMethod 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUSuggestMaintenanceMethod(String uSuggestMaintenanceMethod) {
			super.change(U_SUGGEST_MAINTENANCE_METHOD,super.getUSuggestMaintenanceMethod(),uSuggestMaintenanceMethod);
			super.setUSuggestMaintenanceMethod(uSuggestMaintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uSSuggestMaintenanceMethod 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUSSuggestMaintenanceMethod(String uSSuggestMaintenanceMethod) {
			super.change(U_S_SUGGEST_MAINTENANCE_METHOD,super.getUSSuggestMaintenanceMethod(),uSSuggestMaintenanceMethod);
			super.setUSSuggestMaintenanceMethod(uSSuggestMaintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 联系人
		 * @param contacts 联系人
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setContacts(String contacts) {
			super.change(CONTACTS,super.getContacts(),contacts);
			super.setContacts(contacts);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param sContacts 状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setSContacts(String sContacts) {
			super.change(S_CONTACTS,super.getSContacts(),sContacts);
			super.setSContacts(sContacts);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uContacts 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUContacts(String uContacts) {
			super.change(U_CONTACTS,super.getUContacts(),uContacts);
			super.setUContacts(uContacts);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uSContacts 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUSContacts(String uSContacts) {
			super.change(U_S_CONTACTS,super.getUSContacts(),uSContacts);
			super.setUSContacts(uSContacts);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param director 负责人
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setDirector(String director) {
			super.change(DIRECTOR,super.getDirector(),director);
			super.setDirector(director);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param sDirector 状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setSDirector(String sDirector) {
			super.change(S_DIRECTOR,super.getSDirector(),sDirector);
			super.setSDirector(sDirector);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uDirector 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUDirector(String uDirector) {
			super.change(U_DIRECTOR,super.getUDirector(),uDirector);
			super.setUDirector(uDirector);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uSDirector 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUSDirector(String uSDirector) {
			super.change(U_S_DIRECTOR,super.getUSDirector(),uSDirector);
			super.setUSDirector(uSDirector);
			return this;
		}
		
		/**
		 * 设置 维保开始时间
		 * @param maintenanceStartDate 维保开始时间
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setMaintenanceStartDate(Date maintenanceStartDate) {
			super.change(MAINTENANCE_START_DATE,super.getMaintenanceStartDate(),maintenanceStartDate);
			super.setMaintenanceStartDate(maintenanceStartDate);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param sMaintenanceStartDate 状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setSMaintenanceStartDate(String sMaintenanceStartDate) {
			super.change(S_MAINTENANCE_START_DATE,super.getSMaintenanceStartDate(),sMaintenanceStartDate);
			super.setSMaintenanceStartDate(sMaintenanceStartDate);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uMaintenanceStartDate 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUMaintenanceStartDate(String uMaintenanceStartDate) {
			super.change(U_MAINTENANCE_START_DATE,super.getUMaintenanceStartDate(),uMaintenanceStartDate);
			super.setUMaintenanceStartDate(uMaintenanceStartDate);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uSMaintenanceStartDate 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUSMaintenanceStartDate(String uSMaintenanceStartDate) {
			super.change(U_S_MAINTENANCE_START_DATE,super.getUSMaintenanceStartDate(),uSMaintenanceStartDate);
			super.setUSMaintenanceStartDate(uSMaintenanceStartDate);
			return this;
		}
		
		/**
		 * 设置 维保到期时间
		 * @param maintenanceEndDate 维保到期时间
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setMaintenanceEndDate(Date maintenanceEndDate) {
			super.change(MAINTENANCE_END_DATE,super.getMaintenanceEndDate(),maintenanceEndDate);
			super.setMaintenanceEndDate(maintenanceEndDate);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param sMaintenanceEndDate 状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setSMaintenanceEndDate(String sMaintenanceEndDate) {
			super.change(S_MAINTENANCE_END_DATE,super.getSMaintenanceEndDate(),sMaintenanceEndDate);
			super.setSMaintenanceEndDate(sMaintenanceEndDate);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uMaintenanceEndDate 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUMaintenanceEndDate(String uMaintenanceEndDate) {
			super.change(U_MAINTENANCE_END_DATE,super.getUMaintenanceEndDate(),uMaintenanceEndDate);
			super.setUMaintenanceEndDate(uMaintenanceEndDate);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uSMaintenanceEndDate 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUSMaintenanceEndDate(String uSMaintenanceEndDate) {
			super.change(U_S_MAINTENANCE_END_DATE,super.getUSMaintenanceEndDate(),uSMaintenanceEndDate);
			super.setUSMaintenanceEndDate(uSMaintenanceEndDate);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param maintenanceNotes 备注
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setMaintenanceNotes(String maintenanceNotes) {
			super.change(MAINTENANCE_NOTES,super.getMaintenanceNotes(),maintenanceNotes);
			super.setMaintenanceNotes(maintenanceNotes);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param sMaintenanceNotes 状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setSMaintenanceNotes(String sMaintenanceNotes) {
			super.change(S_MAINTENANCE_NOTES,super.getSMaintenanceNotes(),sMaintenanceNotes);
			super.setSMaintenanceNotes(sMaintenanceNotes);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uMaintenanceNotes 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUMaintenanceNotes(String uMaintenanceNotes) {
			super.change(U_MAINTENANCE_NOTES,super.getUMaintenanceNotes(),uMaintenanceNotes);
			super.setUMaintenanceNotes(uMaintenanceNotes);
			return this;
		}
		
		/**
		 * 设置 更新方式
		 * @param uSMaintenanceNotes 更新方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUSMaintenanceNotes(String uSMaintenanceNotes) {
			super.change(U_S_MAINTENANCE_NOTES,super.getUSMaintenanceNotes(),uSMaintenanceNotes);
			super.setUSMaintenanceNotes(uSMaintenanceNotes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 recordIdList
		 * @param recordIdList recordIdList
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setRecordIdList(List<String> recordIdList) {
			super.change(RECORD_ID_LIST,super.getRecordIdList(),recordIdList);
			super.setRecordIdList(recordIdList);
			return this;
		}
		
		/**
		 * 设置 维保商
		 * @param maintnainer 维保商
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setMaintnainer(Maintainer maintnainer) {
			super.change(MAINTNAINER,super.getMaintnainer(),maintnainer);
			super.setMaintnainer(maintnainer);
			return this;
		}
		
		/**
		 * 设置 维保状态
		 * @param assetMaintenanceStatus 维保状态
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setAssetMaintenanceStatus(DictItem assetMaintenanceStatus) {
			super.change(ASSET_MAINTENANCE_STATUS,super.getAssetMaintenanceStatus(),assetMaintenanceStatus);
			super.setAssetMaintenanceStatus(assetMaintenanceStatus);
			return this;
		}
		
		/**
		 * 设置 建议维保方式
		 * @param suggestMaintenanceMethodData 建议维保方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setSuggestMaintenanceMethodData(DictItem suggestMaintenanceMethodData) {
			super.change(SUGGEST_MAINTENANCE_METHOD_DATA,super.getSuggestMaintenanceMethodData(),suggestMaintenanceMethodData);
			super.setSuggestMaintenanceMethodData(suggestMaintenanceMethodData);
			return this;
		}
		
		/**
		 * 设置 维保方式
		 * @param maintenanceMethodData 维保方式
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setMaintenanceMethodData(DictItem maintenanceMethodData) {
			super.change(MAINTENANCE_METHOD_DATA,super.getMaintenanceMethodData(),maintenanceMethodData);
			super.setMaintenanceMethodData(maintenanceMethodData);
			return this;
		}
		
		/**
		 * 设置 assetMaintenanceUpdate
		 * @param assetMaintenanceUpdate assetMaintenanceUpdate
		 * @return 当前对象
		*/
		public AssetMaintenanceRecordU setAssetMaintenanceUpdate(AssetMaintenanceUpdate assetMaintenanceUpdate) {
			super.change(ASSET_MAINTENANCE_UPDATE,super.getAssetMaintenanceUpdate(),assetMaintenanceUpdate);
			super.setAssetMaintenanceUpdate(assetMaintenanceUpdate);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetMaintenanceRecordUVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetMaintenanceRecordUVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUContactInformation(this.getUContactInformation());
			inst.setUMaintenanceMethod(this.getUMaintenanceMethod());
			inst.setUSuggestMaintenanceMethod(this.getUSuggestMaintenanceMethod());
			inst.setMaintenanceStatus(this.getMaintenanceStatus());
			inst.setMaintenanceEndDate(this.getMaintenanceEndDate());
			inst.setUMaintenanceStatus(this.getUMaintenanceStatus());
			inst.setId(this.getId());
			inst.setSMaintenanceMethod(this.getSMaintenanceMethod());
			inst.setUSContactInformation(this.getUSContactInformation());
			inst.setUMaintenanceStartDate(this.getUMaintenanceStartDate());
			inst.setSContacts(this.getSContacts());
			inst.setSSuggestMaintenanceMethod(this.getSSuggestMaintenanceMethod());
			inst.setSMaintainerName(this.getSMaintainerName());
			inst.setUContacts(this.getUContacts());
			inst.setDirector(this.getDirector());
			inst.setUSMaintenanceMethod(this.getUSMaintenanceMethod());
			inst.setVersion(this.getVersion());
			inst.setMaintainerId(this.getMaintainerId());
			inst.setMaintenanceNotes(this.getMaintenanceNotes());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setMaintenanceMethod(this.getMaintenanceMethod());
			inst.setUSContacts(this.getUSContacts());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setSMaintenanceEndDate(this.getSMaintenanceEndDate());
			inst.setUMaintenanceNotes(this.getUMaintenanceNotes());
			inst.setUSMaintenanceEndDate(this.getUSMaintenanceEndDate());
			inst.setUSMaintainerName(this.getUSMaintainerName());
			inst.setUMaintenanceEndDate(this.getUMaintenanceEndDate());
			inst.setSMaintenanceStartDate(this.getSMaintenanceStartDate());
			inst.setSContactInformation(this.getSContactInformation());
			inst.setUSMaintenanceNotes(this.getUSMaintenanceNotes());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setSuggestMaintenanceMethod(this.getSuggestMaintenanceMethod());
			inst.setUSMaintenanceStartDate(this.getUSMaintenanceStartDate());
			inst.setMaintainerName(this.getMaintainerName());
			inst.setSDirector(this.getSDirector());
			inst.setUSMaintenanceStatus(this.getUSMaintenanceStatus());
			inst.setUMaintainerId(this.getUMaintainerId());
			inst.setUDirector(this.getUDirector());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSMaintainerId(this.getSMaintainerId());
			inst.setSMaintenanceNotes(this.getSMaintenanceNotes());
			inst.setUSDirector(this.getUSDirector());
			inst.setSMaintenanceStatus(this.getSMaintenanceStatus());
			inst.setCreateBy(this.getCreateBy());
			inst.setContactInformation(this.getContactInformation());
			inst.setDeleted(this.getDeleted());
			inst.setUSMaintainerId(this.getUSMaintainerId());
			inst.setCreateTime(this.getCreateTime());
			inst.setMaintenanceUpdateId(this.getMaintenanceUpdateId());
			inst.setTenantId(this.getTenantId());
			inst.setMaintenanceStartDate(this.getMaintenanceStartDate());
			inst.setContacts(this.getContacts());
			inst.setUMaintainerName(this.getUMaintainerName());
			inst.setUSSuggestMaintenanceMethod(this.getUSSuggestMaintenanceMethod());
			if(all) {
				inst.setSuggestMaintenanceMethodData(this.getSuggestMaintenanceMethodData());
				inst.setSearchField(this.getSearchField());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setMaintnainer(this.getMaintnainer());
				inst.setAssetMaintenanceStatus(this.getAssetMaintenanceStatus());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setAssetMaintenanceUpdate(this.getAssetMaintenanceUpdate());
				inst.setIds(this.getIds());
				inst.setMaintenanceMethodData(this.getMaintenanceMethodData());
				inst.setSearchValue(this.getSearchValue());
				inst.setRecordIdList(this.getRecordIdList());
			}
			inst.clearModifies();
			return inst;
		}

	}
}