package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.Host;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.ops.Voucher;
import java.util.List;
import com.dt.platform.domain.ops.InformationSystem;
import com.dt.platform.domain.ops.HostPosition;
import com.dt.platform.domain.ops.ServiceInfo;
import org.github.foxnic.web.domain.system.DictItem;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-18 11:19:27
 * @sign 76B9736ACA102F60F73F8A0282D331CA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class HostMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 信息系统 , 类型: java.lang.String
	*/
	public static final String SYSTEM_ID="systemId";
	
	/**
	 * 信息系统 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> SYSTEM_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,SYSTEM_ID, java.lang.String.class, "信息系统", "信息系统", java.lang.String.class, null);
	
	/**
	 * 主机类型 , 类型: java.lang.String
	*/
	public static final String HOST_TYPE="hostType";
	
	/**
	 * 主机类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> HOST_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_TYPE, java.lang.String.class, "主机类型", "主机类型", java.lang.String.class, null);
	
	/**
	 * 主机状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 主机状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,STATUS, java.lang.String.class, "主机状态", "主机状态", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String HOST_NAME="hostName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> HOST_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 物理IP , 类型: java.lang.String
	*/
	public static final String HOST_IP="hostIp";
	
	/**
	 * 物理IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> HOST_IP_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_IP, java.lang.String.class, "物理IP", "物理IP", java.lang.String.class, null);
	
	/**
	 * 虚拟VIP , 类型: java.lang.String
	*/
	public static final String HOST_VIP="hostVip";
	
	/**
	 * 虚拟VIP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> HOST_VIP_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_VIP, java.lang.String.class, "虚拟VIP", "虚拟VIP", java.lang.String.class, null);
	
	/**
	 * IPV6 , 类型: java.lang.String
	*/
	public static final String HOST_IPV6="hostIpv6";
	
	/**
	 * IPV6 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> HOST_IPV6_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_IPV6, java.lang.String.class, "IPV6", "IPV6", java.lang.String.class, null);
	
	/**
	 * 运行环境 , 类型: java.lang.String
	*/
	public static final String ENVIRONMENT="environment";
	
	/**
	 * 运行环境 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> ENVIRONMENT_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,ENVIRONMENT, java.lang.String.class, "运行环境", "运行环境", java.lang.String.class, null);
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final String POSITION_ID="positionId";
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> POSITION_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,POSITION_ID, java.lang.String.class, "位置", "位置", java.lang.String.class, null);
	
	/**
	 * 监控状态 , 类型: java.lang.String
	*/
	public static final String MONITOR_STATUS="monitorStatus";
	
	/**
	 * 监控状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> MONITOR_STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,MONITOR_STATUS, java.lang.String.class, "监控状态", "监控状态", java.lang.String.class, null);
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final String DIRECTOR_USERNAME="directorUsername";
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> DIRECTOR_USERNAME_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,DIRECTOR_USERNAME, java.lang.String.class, "负责人", "负责人", java.lang.String.class, null);
	
	/**
	 * 内存 , 类型: java.math.BigDecimal
	*/
	public static final String HOST_MEMORY="hostMemory";
	
	/**
	 * 内存 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.math.BigDecimal> HOST_MEMORY_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_MEMORY, java.math.BigDecimal.class, "内存", "内存", java.math.BigDecimal.class, null);
	
	/**
	 * CPU , 类型: java.math.BigDecimal
	*/
	public static final String HOST_CPU="hostCpu";
	
	/**
	 * CPU , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.math.BigDecimal> HOST_CPU_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_CPU, java.math.BigDecimal.class, "CPU", "CPU", java.math.BigDecimal.class, null);
	
	/**
	 * 其他配置 , 类型: java.lang.String
	*/
	public static final String HOST_CONF="hostConf";
	
	/**
	 * 其他配置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> HOST_CONF_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_CONF, java.lang.String.class, "其他配置", "其他配置", java.lang.String.class, null);
	
	/**
	 * 端口列表 , 类型: java.lang.String
	*/
	public static final String PORT_LIST="portList";
	
	/**
	 * 端口列表 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> PORT_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,PORT_LIST, java.lang.String.class, "端口列表", "端口列表", java.lang.String.class, null);
	
	/**
	 * 系统管理员 , 类型: java.lang.String
	*/
	public static final String USER_OS_ADMIN="userOsAdmin";
	
	/**
	 * 系统管理员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> USER_OS_ADMIN_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,USER_OS_ADMIN, java.lang.String.class, "系统管理员", "系统管理员", java.lang.String.class, null);
	
	/**
	 * 数据库管理员 , 类型: java.lang.String
	*/
	public static final String USER_DB_ADMIN="userDbAdmin";
	
	/**
	 * 数据库管理员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> USER_DB_ADMIN_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,USER_DB_ADMIN, java.lang.String.class, "数据库管理员", "数据库管理员", java.lang.String.class, null);
	
	/**
	 * 数据库使用用户 , 类型: java.lang.String
	*/
	public static final String USER_DB_USED="userDbUsed";
	
	/**
	 * 数据库使用用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> USER_DB_USED_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,USER_DB_USED, java.lang.String.class, "数据库使用用户", "数据库使用用户", java.lang.String.class, null);
	
	/**
	 * 应用使用用户 , 类型: java.lang.String
	*/
	public static final String USER_APP_USED="userAppUsed";
	
	/**
	 * 应用使用用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> USER_APP_USED_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,USER_APP_USED, java.lang.String.class, "应用使用用户", "应用使用用户", java.lang.String.class, null);
	
	/**
	 * 运维操作用户 , 类型: java.lang.String
	*/
	public static final String USER_OPS_OPER="userOpsOper";
	
	/**
	 * 运维操作用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> USER_OPS_OPER_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,USER_OPS_OPER, java.lang.String.class, "运维操作用户", "运维操作用户", java.lang.String.class, null);
	
	/**
	 * 其他用户 , 类型: java.lang.String
	*/
	public static final String USER_OTHER="userOther";
	
	/**
	 * 其他用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> USER_OTHER_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,USER_OTHER, java.lang.String.class, "其他用户", "其他用户", java.lang.String.class, null);
	
	/**
	 * 改密策略 , 类型: java.lang.String
	*/
	public static final String PASSWORD_STRATEGY_ID="passwordStrategyId";
	
	/**
	 * 改密策略 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> PASSWORD_STRATEGY_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,PASSWORD_STRATEGY_ID, java.lang.String.class, "改密策略", "改密策略", java.lang.String.class, null);
	
	/**
	 * 备份方式 , 类型: java.lang.String
	*/
	public static final String HOST_BACKUP_METHOD="hostBackupMethod";
	
	/**
	 * 备份方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> HOST_BACKUP_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_BACKUP_METHOD, java.lang.String.class, "备份方式", "备份方式", java.lang.String.class, null);
	
	/**
	 * 备份情况 , 类型: java.lang.String
	*/
	public static final String HOST_BACKUP_INFO="hostBackupInfo";
	
	/**
	 * 备份情况 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> HOST_BACKUP_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_BACKUP_INFO, java.lang.String.class, "备份情况", "备份情况", java.lang.String.class, null);
	
	/**
	 * 下线时间 , 类型: java.util.Date
	*/
	public static final String OFFLINE_TIME="offlineTime";
	
	/**
	 * 下线时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.util.Date> OFFLINE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,OFFLINE_TIME, java.util.Date.class, "下线时间", "下线时间", java.util.Date.class, null);
	
	/**
	 * 上线时间 , 类型: java.util.Date
	*/
	public static final String ONLINE_TIME="onlineTime";
	
	/**
	 * 上线时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.util.Date> ONLINE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,ONLINE_TIME, java.util.Date.class, "上线时间", "上线时间", java.util.Date.class, null);
	
	/**
	 * 是否归档 , 类型: java.lang.String
	*/
	public static final String ARCH="arch";
	
	/**
	 * 是否归档 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> ARCH_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,ARCH, java.lang.String.class, "是否归档", "是否归档", java.lang.String.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABELS="labels";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> LABELS_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,LABELS, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String HOST_NOTES="hostNotes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> HOST_NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 凭证 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.Voucher
	*/
	public static final String VOUCHER_LIST="voucherList";
	
	/**
	 * 凭证 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.Voucher
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,com.dt.platform.domain.ops.Voucher> VOUCHER_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,VOUCHER_LIST, java.util.List.class, "凭证", "凭证", com.dt.platform.domain.ops.Voucher.class, null);
	
	/**
	 * 凭证 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String VOUCHER_IDS="voucherIds";
	
	/**
	 * 凭证 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> VOUCHER_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,VOUCHER_IDS, java.util.List.class, "凭证", "凭证", java.lang.String.class, null);
	
	/**
	 * 信息系统 , 类型: com.dt.platform.domain.ops.InformationSystem
	*/
	public static final String INFO_SYSTEM="infoSystem";
	
	/**
	 * 信息系统 , 类型: com.dt.platform.domain.ops.InformationSystem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,com.dt.platform.domain.ops.InformationSystem> INFO_SYSTEM_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,INFO_SYSTEM, com.dt.platform.domain.ops.InformationSystem.class, "信息系统", "信息系统", com.dt.platform.domain.ops.InformationSystem.class, null);
	
	/**
	 * 所在位置 , 类型: com.dt.platform.domain.ops.HostPosition
	*/
	public static final String POSITION="position";
	
	/**
	 * 所在位置 , 类型: com.dt.platform.domain.ops.HostPosition
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,com.dt.platform.domain.ops.HostPosition> POSITION_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,POSITION, com.dt.platform.domain.ops.HostPosition.class, "所在位置", "所在位置", com.dt.platform.domain.ops.HostPosition.class, null);
	
	/**
	 * 数据库 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.ServiceInfo
	*/
	public static final String HOST_DB_LIST="hostDbList";
	
	/**
	 * 数据库 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.ServiceInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,com.dt.platform.domain.ops.ServiceInfo> HOST_DB_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_DB_LIST, java.util.List.class, "数据库", "数据库", com.dt.platform.domain.ops.ServiceInfo.class, null);
	
	/**
	 * 数据库列表 , 数据库 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String HOST_DB_IDS="hostDbIds";
	
	/**
	 * 数据库列表 , 数据库 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> HOST_DB_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_DB_IDS, java.util.List.class, "数据库列表", "数据库", java.lang.String.class, null);
	
	/**
	 * 中间件 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.ServiceInfo
	*/
	public static final String HOST_MIDDLEWARE_LIST="hostMiddlewareList";
	
	/**
	 * 中间件 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.ServiceInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,com.dt.platform.domain.ops.ServiceInfo> HOST_MIDDLEWARE_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_MIDDLEWARE_LIST, java.util.List.class, "中间件", "中间件", com.dt.platform.domain.ops.ServiceInfo.class, null);
	
	/**
	 * 中间件列表 , 中间件 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String HOST_MIDDLEWARE_IDS="hostMiddlewareIds";
	
	/**
	 * 中间件列表 , 中间件 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> HOST_MIDDLEWARE_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_MIDDLEWARE_IDS, java.util.List.class, "中间件列表", "中间件", java.lang.String.class, null);
	
	/**
	 * 操作系统 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.ServiceInfo
	*/
	public static final String HOST_OS_LIST="hostOsList";
	
	/**
	 * 操作系统 , 集合类型: LIST , 类型: com.dt.platform.domain.ops.ServiceInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,com.dt.platform.domain.ops.ServiceInfo> HOST_OS_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_OS_LIST, java.util.List.class, "操作系统", "操作系统", com.dt.platform.domain.ops.ServiceInfo.class, null);
	
	/**
	 * 操作系统列表 , 操作系统 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String HOST_OS_IDS="hostOsIds";
	
	/**
	 * 操作系统列表 , 操作系统 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,java.lang.String> HOST_OS_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,HOST_OS_IDS, java.util.List.class, "操作系统列表", "操作系统", java.lang.String.class, null);
	
	/**
	 * 备份情况 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String BACKUP_METHOD="backupMethod";
	
	/**
	 * 备份情况 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.Host,org.github.foxnic.web.domain.system.DictItem> BACKUP_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.Host.class ,BACKUP_METHOD, org.github.foxnic.web.domain.system.DictItem.class, "备份情况", "备份情况", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , SYSTEM_ID , HOST_TYPE , STATUS , HOST_NAME , HOST_IP , HOST_VIP , HOST_IPV6 , ENVIRONMENT , POSITION_ID , MONITOR_STATUS , DIRECTOR_USERNAME , HOST_MEMORY , HOST_CPU , HOST_CONF , PORT_LIST , USER_OS_ADMIN , USER_DB_ADMIN , USER_DB_USED , USER_APP_USED , USER_OPS_OPER , USER_OTHER , PASSWORD_STRATEGY_ID , HOST_BACKUP_METHOD , HOST_BACKUP_INFO , OFFLINE_TIME , ONLINE_TIME , ARCH , LABELS , HOST_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , VOUCHER_LIST , VOUCHER_IDS , INFO_SYSTEM , POSITION , HOST_DB_LIST , HOST_DB_IDS , HOST_MIDDLEWARE_LIST , HOST_MIDDLEWARE_IDS , HOST_OS_LIST , HOST_OS_IDS , BACKUP_METHOD };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.Host {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Host setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 信息系统
		 * @param systemId 信息系统
		 * @return 当前对象
		*/
		public Host setSystemId(String systemId) {
			super.change(SYSTEM_ID,super.getSystemId(),systemId);
			super.setSystemId(systemId);
			return this;
		}
		
		/**
		 * 设置 主机类型
		 * @param hostType 主机类型
		 * @return 当前对象
		*/
		public Host setHostType(String hostType) {
			super.change(HOST_TYPE,super.getHostType(),hostType);
			super.setHostType(hostType);
			return this;
		}
		
		/**
		 * 设置 主机状态
		 * @param status 主机状态
		 * @return 当前对象
		*/
		public Host setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param hostName 名称
		 * @return 当前对象
		*/
		public Host setHostName(String hostName) {
			super.change(HOST_NAME,super.getHostName(),hostName);
			super.setHostName(hostName);
			return this;
		}
		
		/**
		 * 设置 物理IP
		 * @param hostIp 物理IP
		 * @return 当前对象
		*/
		public Host setHostIp(String hostIp) {
			super.change(HOST_IP,super.getHostIp(),hostIp);
			super.setHostIp(hostIp);
			return this;
		}
		
		/**
		 * 设置 虚拟VIP
		 * @param hostVip 虚拟VIP
		 * @return 当前对象
		*/
		public Host setHostVip(String hostVip) {
			super.change(HOST_VIP,super.getHostVip(),hostVip);
			super.setHostVip(hostVip);
			return this;
		}
		
		/**
		 * 设置 IPV6
		 * @param hostIpv6 IPV6
		 * @return 当前对象
		*/
		public Host setHostIpv6(String hostIpv6) {
			super.change(HOST_IPV6,super.getHostIpv6(),hostIpv6);
			super.setHostIpv6(hostIpv6);
			return this;
		}
		
		/**
		 * 设置 运行环境
		 * @param environment 运行环境
		 * @return 当前对象
		*/
		public Host setEnvironment(String environment) {
			super.change(ENVIRONMENT,super.getEnvironment(),environment);
			super.setEnvironment(environment);
			return this;
		}
		
		/**
		 * 设置 位置
		 * @param positionId 位置
		 * @return 当前对象
		*/
		public Host setPositionId(String positionId) {
			super.change(POSITION_ID,super.getPositionId(),positionId);
			super.setPositionId(positionId);
			return this;
		}
		
		/**
		 * 设置 监控状态
		 * @param monitorStatus 监控状态
		 * @return 当前对象
		*/
		public Host setMonitorStatus(String monitorStatus) {
			super.change(MONITOR_STATUS,super.getMonitorStatus(),monitorStatus);
			super.setMonitorStatus(monitorStatus);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param directorUsername 负责人
		 * @return 当前对象
		*/
		public Host setDirectorUsername(String directorUsername) {
			super.change(DIRECTOR_USERNAME,super.getDirectorUsername(),directorUsername);
			super.setDirectorUsername(directorUsername);
			return this;
		}
		
		/**
		 * 设置 内存
		 * @param hostMemory 内存
		 * @return 当前对象
		*/
		public Host setHostMemory(BigDecimal hostMemory) {
			super.change(HOST_MEMORY,super.getHostMemory(),hostMemory);
			super.setHostMemory(hostMemory);
			return this;
		}
		
		/**
		 * 设置 CPU
		 * @param hostCpu CPU
		 * @return 当前对象
		*/
		public Host setHostCpu(BigDecimal hostCpu) {
			super.change(HOST_CPU,super.getHostCpu(),hostCpu);
			super.setHostCpu(hostCpu);
			return this;
		}
		
		/**
		 * 设置 其他配置
		 * @param hostConf 其他配置
		 * @return 当前对象
		*/
		public Host setHostConf(String hostConf) {
			super.change(HOST_CONF,super.getHostConf(),hostConf);
			super.setHostConf(hostConf);
			return this;
		}
		
		/**
		 * 设置 端口列表
		 * @param portList 端口列表
		 * @return 当前对象
		*/
		public Host setPortList(String portList) {
			super.change(PORT_LIST,super.getPortList(),portList);
			super.setPortList(portList);
			return this;
		}
		
		/**
		 * 设置 系统管理员
		 * @param userOsAdmin 系统管理员
		 * @return 当前对象
		*/
		public Host setUserOsAdmin(String userOsAdmin) {
			super.change(USER_OS_ADMIN,super.getUserOsAdmin(),userOsAdmin);
			super.setUserOsAdmin(userOsAdmin);
			return this;
		}
		
		/**
		 * 设置 数据库管理员
		 * @param userDbAdmin 数据库管理员
		 * @return 当前对象
		*/
		public Host setUserDbAdmin(String userDbAdmin) {
			super.change(USER_DB_ADMIN,super.getUserDbAdmin(),userDbAdmin);
			super.setUserDbAdmin(userDbAdmin);
			return this;
		}
		
		/**
		 * 设置 数据库使用用户
		 * @param userDbUsed 数据库使用用户
		 * @return 当前对象
		*/
		public Host setUserDbUsed(String userDbUsed) {
			super.change(USER_DB_USED,super.getUserDbUsed(),userDbUsed);
			super.setUserDbUsed(userDbUsed);
			return this;
		}
		
		/**
		 * 设置 应用使用用户
		 * @param userAppUsed 应用使用用户
		 * @return 当前对象
		*/
		public Host setUserAppUsed(String userAppUsed) {
			super.change(USER_APP_USED,super.getUserAppUsed(),userAppUsed);
			super.setUserAppUsed(userAppUsed);
			return this;
		}
		
		/**
		 * 设置 运维操作用户
		 * @param userOpsOper 运维操作用户
		 * @return 当前对象
		*/
		public Host setUserOpsOper(String userOpsOper) {
			super.change(USER_OPS_OPER,super.getUserOpsOper(),userOpsOper);
			super.setUserOpsOper(userOpsOper);
			return this;
		}
		
		/**
		 * 设置 其他用户
		 * @param userOther 其他用户
		 * @return 当前对象
		*/
		public Host setUserOther(String userOther) {
			super.change(USER_OTHER,super.getUserOther(),userOther);
			super.setUserOther(userOther);
			return this;
		}
		
		/**
		 * 设置 改密策略
		 * @param passwordStrategyId 改密策略
		 * @return 当前对象
		*/
		public Host setPasswordStrategyId(String passwordStrategyId) {
			super.change(PASSWORD_STRATEGY_ID,super.getPasswordStrategyId(),passwordStrategyId);
			super.setPasswordStrategyId(passwordStrategyId);
			return this;
		}
		
		/**
		 * 设置 备份方式
		 * @param hostBackupMethod 备份方式
		 * @return 当前对象
		*/
		public Host setHostBackupMethod(String hostBackupMethod) {
			super.change(HOST_BACKUP_METHOD,super.getHostBackupMethod(),hostBackupMethod);
			super.setHostBackupMethod(hostBackupMethod);
			return this;
		}
		
		/**
		 * 设置 备份情况
		 * @param hostBackupInfo 备份情况
		 * @return 当前对象
		*/
		public Host setHostBackupInfo(String hostBackupInfo) {
			super.change(HOST_BACKUP_INFO,super.getHostBackupInfo(),hostBackupInfo);
			super.setHostBackupInfo(hostBackupInfo);
			return this;
		}
		
		/**
		 * 设置 下线时间
		 * @param offlineTime 下线时间
		 * @return 当前对象
		*/
		public Host setOfflineTime(Date offlineTime) {
			super.change(OFFLINE_TIME,super.getOfflineTime(),offlineTime);
			super.setOfflineTime(offlineTime);
			return this;
		}
		
		/**
		 * 设置 上线时间
		 * @param onlineTime 上线时间
		 * @return 当前对象
		*/
		public Host setOnlineTime(Date onlineTime) {
			super.change(ONLINE_TIME,super.getOnlineTime(),onlineTime);
			super.setOnlineTime(onlineTime);
			return this;
		}
		
		/**
		 * 设置 是否归档
		 * @param arch 是否归档
		 * @return 当前对象
		*/
		public Host setArch(String arch) {
			super.change(ARCH,super.getArch(),arch);
			super.setArch(arch);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param labels 标签
		 * @return 当前对象
		*/
		public Host setLabels(String labels) {
			super.change(LABELS,super.getLabels(),labels);
			super.setLabels(labels);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param hostNotes 备注
		 * @return 当前对象
		*/
		public Host setHostNotes(String hostNotes) {
			super.change(HOST_NOTES,super.getHostNotes(),hostNotes);
			super.setHostNotes(hostNotes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Host setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Host setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Host setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Host setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Host setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Host setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Host setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Host setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Host setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 凭证
		 * @param voucherList 凭证
		 * @return 当前对象
		*/
		public Host setVoucherList(List<Voucher> voucherList) {
			super.change(VOUCHER_LIST,super.getVoucherList(),voucherList);
			super.setVoucherList(voucherList);
			return this;
		}
		
		/**
		 * 设置 凭证
		 * @param voucherIds 凭证
		 * @return 当前对象
		*/
		public Host setVoucherIds(List<String> voucherIds) {
			super.change(VOUCHER_IDS,super.getVoucherIds(),voucherIds);
			super.setVoucherIds(voucherIds);
			return this;
		}
		
		/**
		 * 设置 信息系统
		 * @param infoSystem 信息系统
		 * @return 当前对象
		*/
		public Host setInfoSystem(InformationSystem infoSystem) {
			super.change(INFO_SYSTEM,super.getInfoSystem(),infoSystem);
			super.setInfoSystem(infoSystem);
			return this;
		}
		
		/**
		 * 设置 所在位置
		 * @param position 所在位置
		 * @return 当前对象
		*/
		public Host setPosition(HostPosition position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param hostDbList 数据库
		 * @return 当前对象
		*/
		public Host setHostDbList(List<ServiceInfo> hostDbList) {
			super.change(HOST_DB_LIST,super.getHostDbList(),hostDbList);
			super.setHostDbList(hostDbList);
			return this;
		}
		
		/**
		 * 设置 数据库列表
		 * @param hostDbIds 数据库列表
		 * @return 当前对象
		*/
		public Host setHostDbIds(List<String> hostDbIds) {
			super.change(HOST_DB_IDS,super.getHostDbIds(),hostDbIds);
			super.setHostDbIds(hostDbIds);
			return this;
		}
		
		/**
		 * 设置 中间件
		 * @param hostMiddlewareList 中间件
		 * @return 当前对象
		*/
		public Host setHostMiddlewareList(List<ServiceInfo> hostMiddlewareList) {
			super.change(HOST_MIDDLEWARE_LIST,super.getHostMiddlewareList(),hostMiddlewareList);
			super.setHostMiddlewareList(hostMiddlewareList);
			return this;
		}
		
		/**
		 * 设置 中间件列表
		 * @param hostMiddlewareIds 中间件列表
		 * @return 当前对象
		*/
		public Host setHostMiddlewareIds(List<String> hostMiddlewareIds) {
			super.change(HOST_MIDDLEWARE_IDS,super.getHostMiddlewareIds(),hostMiddlewareIds);
			super.setHostMiddlewareIds(hostMiddlewareIds);
			return this;
		}
		
		/**
		 * 设置 操作系统
		 * @param hostOsList 操作系统
		 * @return 当前对象
		*/
		public Host setHostOsList(List<ServiceInfo> hostOsList) {
			super.change(HOST_OS_LIST,super.getHostOsList(),hostOsList);
			super.setHostOsList(hostOsList);
			return this;
		}
		
		/**
		 * 设置 操作系统列表
		 * @param hostOsIds 操作系统列表
		 * @return 当前对象
		*/
		public Host setHostOsIds(List<String> hostOsIds) {
			super.change(HOST_OS_IDS,super.getHostOsIds(),hostOsIds);
			super.setHostOsIds(hostOsIds);
			return this;
		}
		
		/**
		 * 设置 备份情况
		 * @param backupMethod 备份情况
		 * @return 当前对象
		*/
		public Host setBackupMethod(DictItem backupMethod) {
			super.change(BACKUP_METHOD,super.getBackupMethod(),backupMethod);
			super.setBackupMethod(backupMethod);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public Host clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public Host duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setHostName(this.getHostName());
			inst.setUserDbUsed(this.getUserDbUsed());
			inst.setUserDbAdmin(this.getUserDbAdmin());
			inst.setPasswordStrategyId(this.getPasswordStrategyId());
			inst.setDirectorUsername(this.getDirectorUsername());
			inst.setUserOsAdmin(this.getUserOsAdmin());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setHostType(this.getHostType());
			inst.setPortList(this.getPortList());
			inst.setOnlineTime(this.getOnlineTime());
			inst.setOfflineTime(this.getOfflineTime());
			inst.setId(this.getId());
			inst.setHostCpu(this.getHostCpu());
			inst.setUserAppUsed(this.getUserAppUsed());
			inst.setUserOther(this.getUserOther());
			inst.setHostBackupInfo(this.getHostBackupInfo());
			inst.setSystemId(this.getSystemId());
			inst.setHostConf(this.getHostConf());
			inst.setHostBackupMethod(this.getHostBackupMethod());
			inst.setHostIp(this.getHostIp());
			inst.setHostVip(this.getHostVip());
			inst.setHostMemory(this.getHostMemory());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setLabels(this.getLabels());
			inst.setEnvironment(this.getEnvironment());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPositionId(this.getPositionId());
			inst.setHostNotes(this.getHostNotes());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setUserOpsOper(this.getUserOpsOper());
			inst.setArch(this.getArch());
			inst.setMonitorStatus(this.getMonitorStatus());
			inst.setStatus(this.getStatus());
			inst.setHostIpv6(this.getHostIpv6());
			if(all) {
				inst.setHostOsIds(this.getHostOsIds());
				inst.setHostMiddlewareList(this.getHostMiddlewareList());
				inst.setVoucherList(this.getVoucherList());
				inst.setHostDbIds(this.getHostDbIds());
				inst.setInfoSystem(this.getInfoSystem());
				inst.setHostOsList(this.getHostOsList());
				inst.setHostDbList(this.getHostDbList());
				inst.setPosition(this.getPosition());
				inst.setBackupMethod(this.getBackupMethod());
				inst.setHostMiddlewareIds(this.getHostMiddlewareIds());
				inst.setVoucherIds(this.getVoucherIds());
			}
			inst.clearModifies();
			return inst;
		}

	}
}