package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.InformationSystemVO;
import java.util.List;
import com.dt.platform.domain.ops.InformationSystem;
import java.util.Date;
import com.dt.platform.domain.ops.Voucher;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-03 16:00:36
 * @sign A4760002E2C46A63027FD19148F51477
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InformationSystemVOMeta extends InformationSystemMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final String PID="pid";
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> PID_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,PID, java.lang.String.class, "父节点", "父节点", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 介绍 , 类型: java.lang.String
	*/
	public static final String PROFILE="profile";
	
	/**
	 * 介绍 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> PROFILE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,PROFILE, java.lang.String.class, "介绍", "介绍", java.lang.String.class, null);
	
	/**
	 * 当前状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 当前状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,STATUS, java.lang.String.class, "当前状态", "当前状态", java.lang.String.class, null);
	
	/**
	 * 访问地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 访问地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> ADDRESS_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,ADDRESS, java.lang.String.class, "访问地址", "访问地址", java.lang.String.class, null);
	
	/**
	 * 运维模式 , 类型: java.lang.String
	*/
	public static final String OPS_METHOD="opsMethod";
	
	/**
	 * 运维模式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> OPS_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,OPS_METHOD, java.lang.String.class, "运维模式", "运维模式", java.lang.String.class, null);
	
	/**
	 * 开发模式 , 类型: java.lang.String
	*/
	public static final String DEV_METHOD="devMethod";
	
	/**
	 * 开发模式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> DEV_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,DEV_METHOD, java.lang.String.class, "开发模式", "开发模式", java.lang.String.class, null);
	
	/**
	 * 技术联系人 , 类型: java.lang.String
	*/
	public static final String TECHNICAL_CONTACT="technicalContact";
	
	/**
	 * 技术联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> TECHNICAL_CONTACT_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,TECHNICAL_CONTACT, java.lang.String.class, "技术联系人", "技术联系人", java.lang.String.class, null);
	
	/**
	 * 业务联系人 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CONTACT="businessContact";
	
	/**
	 * 业务联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> BUSINESS_CONTACT_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,BUSINESS_CONTACT, java.lang.String.class, "业务联系人", "业务联系人", java.lang.String.class, null);
	
	/**
	 * 所属公司/部门 , 类型: java.lang.String
	*/
	public static final String BELONG_ORG_ID="belongOrgId";
	
	/**
	 * 所属公司/部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> BELONG_ORG_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,BELONG_ORG_ID, java.lang.String.class, "所属公司/部门", "所属公司/部门", java.lang.String.class, null);
	
	/**
	 * 最后一次演练 , 类型: java.util.Date
	*/
	public static final String LASTDRILL_DATE="lastdrillDate";
	
	/**
	 * 最后一次演练 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.util.Date> LASTDRILL_DATE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,LASTDRILL_DATE, java.util.Date.class, "最后一次演练", "最后一次演练", java.util.Date.class, null);
	
	/**
	 * 上线时间 , 类型: java.util.Date
	*/
	public static final String ONLINE_DATE="onlineDate";
	
	/**
	 * 上线时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.util.Date> ONLINE_DATE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,ONLINE_DATE, java.util.Date.class, "上线时间", "上线时间", java.util.Date.class, null);
	
	/**
	 * 下线时间 , 类型: java.util.Date
	*/
	public static final String OFFLINE_DATE="offlineDate";
	
	/**
	 * 下线时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.util.Date> OFFLINE_DATE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,OFFLINE_DATE, java.util.Date.class, "下线时间", "下线时间", java.util.Date.class, null);
	
	/**
	 * 操作系统 , 类型: java.lang.String
	*/
	public static final String OS_INFO="osInfo";
	
	/**
	 * 操作系统 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> OS_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,OS_INFO, java.lang.String.class, "操作系统", "操作系统", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DB_INFO="dbInfo";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> DB_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,DB_INFO, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * 应用 , 类型: java.lang.String
	*/
	public static final String APP_INFO="appInfo";
	
	/**
	 * 应用 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> APP_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,APP_INFO, java.lang.String.class, "应用", "应用", java.lang.String.class, null);
	
	/**
	 * 等级 , 类型: java.lang.String
	*/
	public static final String GRADE="grade";
	
	/**
	 * 等级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> GRADE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,GRADE, java.lang.String.class, "等级", "等级", java.lang.String.class, null);
	
	/**
	 * RTO , 类型: java.lang.String
	*/
	public static final String RTO="rto";
	
	/**
	 * RTO , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> RTO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,RTO, java.lang.String.class, "RTO", "RTO", java.lang.String.class, null);
	
	/**
	 * RPO , 类型: java.lang.String
	*/
	public static final String RPO="rpo";
	
	/**
	 * RPO , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> RPO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,RPO, java.lang.String.class, "RPO", "RPO", java.lang.String.class, null);
	
	/**
	 * 硬件信息 , 类型: java.lang.String
	*/
	public static final String HARDWARE_INFO="hardwareInfo";
	
	/**
	 * 硬件信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> HARDWARE_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,HARDWARE_INFO, java.lang.String.class, "硬件信息", "硬件信息", java.lang.String.class, null);
	
	/**
	 * 备份信息 , 类型: java.lang.String
	*/
	public static final String BACKUP_INFO="backupInfo";
	
	/**
	 * 备份信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> BACKUP_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,BACKUP_INFO, java.lang.String.class, "备份信息", "备份信息", java.lang.String.class, null);
	
	/**
	 * 本地备份 , 类型: java.lang.String
	*/
	public static final String SAMEPLACE_BACUP_INFO="sameplaceBacupInfo";
	
	/**
	 * 本地备份 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> SAMEPLACE_BACUP_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,SAMEPLACE_BACUP_INFO, java.lang.String.class, "本地备份", "本地备份", java.lang.String.class, null);
	
	/**
	 * 异地备份 , 类型: java.lang.String
	*/
	public static final String DIFFPLACE_BACKUP_INFO="diffplaceBackupInfo";
	
	/**
	 * 异地备份 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> DIFFPLACE_BACKUP_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,DIFFPLACE_BACKUP_INFO, java.lang.String.class, "异地备份", "异地备份", java.lang.String.class, null);
	
	/**
	 * 归档模式 , 类型: java.lang.String
	*/
	public static final String ARCH_METHOD="archMethod";
	
	/**
	 * 归档模式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> ARCH_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,ARCH_METHOD, java.lang.String.class, "归档模式", "归档模式", java.lang.String.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABELS="labels";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> LABELS_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,LABELS, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 凭证 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.Voucher
	*/
	public static final String VOUCHER_LIST="voucherList";
	
	/**
	 * 凭证 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.Voucher
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,com.dt.platform.domain.ops.Voucher> VOUCHER_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,VOUCHER_LIST, java.util.List.class, "凭证", "凭证", com.dt.platform.domain.ops.Voucher.class, null);
	
	/**
	 * 凭证 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String VOUCHER_IDS="voucherIds";
	
	/**
	 * 凭证 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,java.lang.String> VOUCHER_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,VOUCHER_IDS, java.util.List.class, "凭证", "凭证", java.lang.String.class, null);
	
	/**
	 * 所属公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String BELONG_ORGANIZATION="belongOrganization";
	
	/**
	 * 所属公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,org.github.foxnic.web.domain.hrm.Organization> BELONG_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,BELONG_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "所属公司/部门", "所属公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String INFO_SYSTEM_STATUS="infoSystemStatus";
	
	/**
	 * 状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,org.github.foxnic.web.domain.system.DictItem> INFO_SYSTEM_STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,INFO_SYSTEM_STATUS, org.github.foxnic.web.domain.system.DictItem.class, "状态", "状态", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 运维模式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String INFO_SYSTEM_OPS_METHOD="infoSystemOpsMethod";
	
	/**
	 * 运维模式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,org.github.foxnic.web.domain.system.DictItem> INFO_SYSTEM_OPS_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,INFO_SYSTEM_OPS_METHOD, org.github.foxnic.web.domain.system.DictItem.class, "运维模式", "运维模式", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 开发模式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String INFO_SYSTEM_DEV_METHOD="infoSystemDevMethod";
	
	/**
	 * 开发模式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,org.github.foxnic.web.domain.system.DictItem> INFO_SYSTEM_DEV_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,INFO_SYSTEM_DEV_METHOD, org.github.foxnic.web.domain.system.DictItem.class, "开发模式", "开发模式", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 系统分级 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String INFO_SYSTEM_GRADE="infoSystemGrade";
	
	/**
	 * 系统分级 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.InformationSystemVO,org.github.foxnic.web.domain.system.DictItem> INFO_SYSTEM_GRADE_PROP = new BeanProperty(com.dt.platform.domain.ops.InformationSystemVO.class ,INFO_SYSTEM_GRADE, org.github.foxnic.web.domain.system.DictItem.class, "系统分级", "系统分级", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , IDS , ID , PID , NAME , PROFILE , STATUS , ADDRESS , OPS_METHOD , DEV_METHOD , TECHNICAL_CONTACT , BUSINESS_CONTACT , BELONG_ORG_ID , LASTDRILL_DATE , ONLINE_DATE , OFFLINE_DATE , OS_INFO , DB_INFO , APP_INFO , GRADE , RTO , RPO , HARDWARE_INFO , BACKUP_INFO , SAMEPLACE_BACUP_INFO , DIFFPLACE_BACKUP_INFO , ARCH_METHOD , LABELS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , VOUCHER_LIST , VOUCHER_IDS , BELONG_ORGANIZATION , INFO_SYSTEM_STATUS , INFO_SYSTEM_OPS_METHOD , INFO_SYSTEM_DEV_METHOD , INFO_SYSTEM_GRADE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.InformationSystemVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public InformationSystemVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public InformationSystemVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public InformationSystemVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public InformationSystemVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public InformationSystemVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public InformationSystemVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public InformationSystemVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public InformationSystemVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public InformationSystemVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public InformationSystemVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public InformationSystemVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InformationSystem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 父节点
		 * @param pid 父节点
		 * @return 当前对象
		*/
		public InformationSystem setPid(String pid) {
			super.change(PID,super.getPid(),pid);
			super.setPid(pid);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public InformationSystem setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 介绍
		 * @param profile 介绍
		 * @return 当前对象
		*/
		public InformationSystem setProfile(String profile) {
			super.change(PROFILE,super.getProfile(),profile);
			super.setProfile(profile);
			return this;
		}
		
		/**
		 * 设置 当前状态
		 * @param status 当前状态
		 * @return 当前对象
		*/
		public InformationSystem setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 访问地址
		 * @param address 访问地址
		 * @return 当前对象
		*/
		public InformationSystem setAddress(String address) {
			super.change(ADDRESS,super.getAddress(),address);
			super.setAddress(address);
			return this;
		}
		
		/**
		 * 设置 运维模式
		 * @param opsMethod 运维模式
		 * @return 当前对象
		*/
		public InformationSystem setOpsMethod(String opsMethod) {
			super.change(OPS_METHOD,super.getOpsMethod(),opsMethod);
			super.setOpsMethod(opsMethod);
			return this;
		}
		
		/**
		 * 设置 开发模式
		 * @param devMethod 开发模式
		 * @return 当前对象
		*/
		public InformationSystem setDevMethod(String devMethod) {
			super.change(DEV_METHOD,super.getDevMethod(),devMethod);
			super.setDevMethod(devMethod);
			return this;
		}
		
		/**
		 * 设置 技术联系人
		 * @param technicalContact 技术联系人
		 * @return 当前对象
		*/
		public InformationSystem setTechnicalContact(String technicalContact) {
			super.change(TECHNICAL_CONTACT,super.getTechnicalContact(),technicalContact);
			super.setTechnicalContact(technicalContact);
			return this;
		}
		
		/**
		 * 设置 业务联系人
		 * @param businessContact 业务联系人
		 * @return 当前对象
		*/
		public InformationSystem setBusinessContact(String businessContact) {
			super.change(BUSINESS_CONTACT,super.getBusinessContact(),businessContact);
			super.setBusinessContact(businessContact);
			return this;
		}
		
		/**
		 * 设置 所属公司/部门
		 * @param belongOrgId 所属公司/部门
		 * @return 当前对象
		*/
		public InformationSystem setBelongOrgId(String belongOrgId) {
			super.change(BELONG_ORG_ID,super.getBelongOrgId(),belongOrgId);
			super.setBelongOrgId(belongOrgId);
			return this;
		}
		
		/**
		 * 设置 最后一次演练
		 * @param lastdrillDate 最后一次演练
		 * @return 当前对象
		*/
		public InformationSystem setLastdrillDate(Date lastdrillDate) {
			super.change(LASTDRILL_DATE,super.getLastdrillDate(),lastdrillDate);
			super.setLastdrillDate(lastdrillDate);
			return this;
		}
		
		/**
		 * 设置 上线时间
		 * @param onlineDate 上线时间
		 * @return 当前对象
		*/
		public InformationSystem setOnlineDate(Date onlineDate) {
			super.change(ONLINE_DATE,super.getOnlineDate(),onlineDate);
			super.setOnlineDate(onlineDate);
			return this;
		}
		
		/**
		 * 设置 下线时间
		 * @param offlineDate 下线时间
		 * @return 当前对象
		*/
		public InformationSystem setOfflineDate(Date offlineDate) {
			super.change(OFFLINE_DATE,super.getOfflineDate(),offlineDate);
			super.setOfflineDate(offlineDate);
			return this;
		}
		
		/**
		 * 设置 操作系统
		 * @param osInfo 操作系统
		 * @return 当前对象
		*/
		public InformationSystem setOsInfo(String osInfo) {
			super.change(OS_INFO,super.getOsInfo(),osInfo);
			super.setOsInfo(osInfo);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param dbInfo 数据库
		 * @return 当前对象
		*/
		public InformationSystem setDbInfo(String dbInfo) {
			super.change(DB_INFO,super.getDbInfo(),dbInfo);
			super.setDbInfo(dbInfo);
			return this;
		}
		
		/**
		 * 设置 应用
		 * @param appInfo 应用
		 * @return 当前对象
		*/
		public InformationSystem setAppInfo(String appInfo) {
			super.change(APP_INFO,super.getAppInfo(),appInfo);
			super.setAppInfo(appInfo);
			return this;
		}
		
		/**
		 * 设置 等级
		 * @param grade 等级
		 * @return 当前对象
		*/
		public InformationSystem setGrade(String grade) {
			super.change(GRADE,super.getGrade(),grade);
			super.setGrade(grade);
			return this;
		}
		
		/**
		 * 设置 RTO
		 * @param rto RTO
		 * @return 当前对象
		*/
		public InformationSystem setRto(String rto) {
			super.change(RTO,super.getRto(),rto);
			super.setRto(rto);
			return this;
		}
		
		/**
		 * 设置 RPO
		 * @param rpo RPO
		 * @return 当前对象
		*/
		public InformationSystem setRpo(String rpo) {
			super.change(RPO,super.getRpo(),rpo);
			super.setRpo(rpo);
			return this;
		}
		
		/**
		 * 设置 硬件信息
		 * @param hardwareInfo 硬件信息
		 * @return 当前对象
		*/
		public InformationSystem setHardwareInfo(String hardwareInfo) {
			super.change(HARDWARE_INFO,super.getHardwareInfo(),hardwareInfo);
			super.setHardwareInfo(hardwareInfo);
			return this;
		}
		
		/**
		 * 设置 备份信息
		 * @param backupInfo 备份信息
		 * @return 当前对象
		*/
		public InformationSystem setBackupInfo(String backupInfo) {
			super.change(BACKUP_INFO,super.getBackupInfo(),backupInfo);
			super.setBackupInfo(backupInfo);
			return this;
		}
		
		/**
		 * 设置 本地备份
		 * @param sameplaceBacupInfo 本地备份
		 * @return 当前对象
		*/
		public InformationSystem setSameplaceBacupInfo(String sameplaceBacupInfo) {
			super.change(SAMEPLACE_BACUP_INFO,super.getSameplaceBacupInfo(),sameplaceBacupInfo);
			super.setSameplaceBacupInfo(sameplaceBacupInfo);
			return this;
		}
		
		/**
		 * 设置 异地备份
		 * @param diffplaceBackupInfo 异地备份
		 * @return 当前对象
		*/
		public InformationSystem setDiffplaceBackupInfo(String diffplaceBackupInfo) {
			super.change(DIFFPLACE_BACKUP_INFO,super.getDiffplaceBackupInfo(),diffplaceBackupInfo);
			super.setDiffplaceBackupInfo(diffplaceBackupInfo);
			return this;
		}
		
		/**
		 * 设置 归档模式
		 * @param archMethod 归档模式
		 * @return 当前对象
		*/
		public InformationSystem setArchMethod(String archMethod) {
			super.change(ARCH_METHOD,super.getArchMethod(),archMethod);
			super.setArchMethod(archMethod);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param labels 标签
		 * @return 当前对象
		*/
		public InformationSystem setLabels(String labels) {
			super.change(LABELS,super.getLabels(),labels);
			super.setLabels(labels);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public InformationSystem setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InformationSystem setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InformationSystem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InformationSystem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InformationSystem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InformationSystem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InformationSystem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InformationSystem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public InformationSystem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public InformationSystem setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 凭证
		 * @param voucherList 凭证
		 * @return 当前对象
		*/
		public InformationSystem setVoucherList(List<Voucher> voucherList) {
			super.change(VOUCHER_LIST,super.getVoucherList(),voucherList);
			super.setVoucherList(voucherList);
			return this;
		}
		
		/**
		 * 设置 凭证
		 * @param voucherIds 凭证
		 * @return 当前对象
		*/
		public InformationSystem setVoucherIds(List<String> voucherIds) {
			super.change(VOUCHER_IDS,super.getVoucherIds(),voucherIds);
			super.setVoucherIds(voucherIds);
			return this;
		}
		
		/**
		 * 设置 所属公司/部门
		 * @param belongOrganization 所属公司/部门
		 * @return 当前对象
		*/
		public InformationSystem setBelongOrganization(Organization belongOrganization) {
			super.change(BELONG_ORGANIZATION,super.getBelongOrganization(),belongOrganization);
			super.setBelongOrganization(belongOrganization);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param infoSystemStatus 状态
		 * @return 当前对象
		*/
		public InformationSystem setInfoSystemStatus(DictItem infoSystemStatus) {
			super.change(INFO_SYSTEM_STATUS,super.getInfoSystemStatus(),infoSystemStatus);
			super.setInfoSystemStatus(infoSystemStatus);
			return this;
		}
		
		/**
		 * 设置 运维模式
		 * @param infoSystemOpsMethod 运维模式
		 * @return 当前对象
		*/
		public InformationSystem setInfoSystemOpsMethod(DictItem infoSystemOpsMethod) {
			super.change(INFO_SYSTEM_OPS_METHOD,super.getInfoSystemOpsMethod(),infoSystemOpsMethod);
			super.setInfoSystemOpsMethod(infoSystemOpsMethod);
			return this;
		}
		
		/**
		 * 设置 开发模式
		 * @param infoSystemDevMethod 开发模式
		 * @return 当前对象
		*/
		public InformationSystem setInfoSystemDevMethod(DictItem infoSystemDevMethod) {
			super.change(INFO_SYSTEM_DEV_METHOD,super.getInfoSystemDevMethod(),infoSystemDevMethod);
			super.setInfoSystemDevMethod(infoSystemDevMethod);
			return this;
		}
		
		/**
		 * 设置 系统分级
		 * @param infoSystemGrade 系统分级
		 * @return 当前对象
		*/
		public InformationSystem setInfoSystemGrade(DictItem infoSystemGrade) {
			super.change(INFO_SYSTEM_GRADE,super.getInfoSystemGrade(),infoSystemGrade);
			super.setInfoSystemGrade(infoSystemGrade);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public InformationSystemVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public InformationSystemVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setSameplaceBacupInfo(this.getSameplaceBacupInfo());
			inst.setArchMethod(this.getArchMethod());
			inst.setNotes(this.getNotes());
			inst.setAppInfo(this.getAppInfo());
			inst.setPid(this.getPid());
			inst.setDevMethod(this.getDevMethod());
			inst.setTechnicalContact(this.getTechnicalContact());
			inst.setOsInfo(this.getOsInfo());
			inst.setHardwareInfo(this.getHardwareInfo());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setId(this.getId());
			inst.setBackupInfo(this.getBackupInfo());
			inst.setDbInfo(this.getDbInfo());
			inst.setDiffplaceBackupInfo(this.getDiffplaceBackupInfo());
			inst.setAddress(this.getAddress());
			inst.setBelongOrgId(this.getBelongOrgId());
			inst.setProfile(this.getProfile());
			inst.setBusinessContact(this.getBusinessContact());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setRto(this.getRto());
			inst.setVersion(this.getVersion());
			inst.setLabels(this.getLabels());
			inst.setOnlineDate(this.getOnlineDate());
			inst.setRpo(this.getRpo());
			inst.setCreateBy(this.getCreateBy());
			inst.setOfflineDate(this.getOfflineDate());
			inst.setDeleted(this.getDeleted());
			inst.setOpsMethod(this.getOpsMethod());
			inst.setLastdrillDate(this.getLastdrillDate());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setGrade(this.getGrade());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setInfoSystemStatus(this.getInfoSystemStatus());
				inst.setVoucherList(this.getVoucherList());
				inst.setInfoSystemDevMethod(this.getInfoSystemDevMethod());
				inst.setInfoSystemGrade(this.getInfoSystemGrade());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setBelongOrganization(this.getBelongOrganization());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setInfoSystemOpsMethod(this.getInfoSystemOpsMethod());
				inst.setSearchValue(this.getSearchValue());
				inst.setVoucherIds(this.getVoucherIds());
			}
			inst.clearModifies();
			return inst;
		}

	}
}