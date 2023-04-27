package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_HOST;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.HostMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 主机
 * <p>主机 , 数据表 ops_host 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-18 11:19:27
 * @sign 76B9736ACA102F60F73F8A0282D331CA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_host")
@ApiModel(description = "主机 ; 主机 , 数据表 ops_host 的PO类型")
public class Host extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_HOST.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "599359342004666368")
	private String id;
	
	/**
	 * 信息系统：信息系统
	*/
	@ApiModelProperty(required = false,value="信息系统" , notes = "信息系统" , example = "599359261440475136")
	private String systemId;
	
	/**
	 * 主机类型：主机类型
	*/
	@ApiModelProperty(required = false,value="主机类型" , notes = "主机类型" , example = "office")
	private String hostType;
	
	/**
	 * 主机状态：主机状态
	*/
	@ApiModelProperty(required = false,value="主机状态" , notes = "主机状态" , example = "1")
	private String status;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "1212")
	private String hostName;
	
	/**
	 * 物理IP：物理IP
	*/
	@ApiModelProperty(required = false,value="物理IP" , notes = "物理IP")
	private String hostIp;
	
	/**
	 * 虚拟VIP：虚拟VIP
	*/
	@ApiModelProperty(required = false,value="虚拟VIP" , notes = "虚拟VIP")
	private String hostVip;
	
	/**
	 * IPV6：IPV6
	*/
	@ApiModelProperty(required = false,value="IPV6" , notes = "IPV6")
	private String hostIpv6;
	
	/**
	 * 运行环境：运行环境
	*/
	@ApiModelProperty(required = false,value="运行环境" , notes = "运行环境" , example = "prod")
	private String environment;
	
	/**
	 * 位置：位置
	*/
	@ApiModelProperty(required = false,value="位置" , notes = "位置")
	private String positionId;
	
	/**
	 * 监控状态：监控状态
	*/
	@ApiModelProperty(required = false,value="监控状态" , notes = "监控状态" , example = "1")
	private String monitorStatus;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private String directorUsername;
	
	/**
	 * 内存：内存
	*/
	@ApiModelProperty(required = false,value="内存" , notes = "内存")
	private BigDecimal hostMemory;
	
	/**
	 * CPU：CPU
	*/
	@ApiModelProperty(required = false,value="CPU" , notes = "CPU")
	private BigDecimal hostCpu;
	
	/**
	 * 其他配置：其他配置
	*/
	@ApiModelProperty(required = false,value="其他配置" , notes = "其他配置")
	private String hostConf;
	
	/**
	 * 端口列表：端口列表
	*/
	@ApiModelProperty(required = false,value="端口列表" , notes = "端口列表")
	private String portList;
	
	/**
	 * 系统管理员：系统管理员
	*/
	@ApiModelProperty(required = false,value="系统管理员" , notes = "系统管理员")
	private String userOsAdmin;
	
	/**
	 * 数据库管理员：数据库管理员
	*/
	@ApiModelProperty(required = false,value="数据库管理员" , notes = "数据库管理员")
	private String userDbAdmin;
	
	/**
	 * 数据库使用用户：数据库使用用户
	*/
	@ApiModelProperty(required = false,value="数据库使用用户" , notes = "数据库使用用户")
	private String userDbUsed;
	
	/**
	 * 应用使用用户：应用使用用户
	*/
	@ApiModelProperty(required = false,value="应用使用用户" , notes = "应用使用用户")
	private String userAppUsed;
	
	/**
	 * 运维操作用户：运维操作用户
	*/
	@ApiModelProperty(required = false,value="运维操作用户" , notes = "运维操作用户")
	private String userOpsOper;
	
	/**
	 * 其他用户：其他用户
	*/
	@ApiModelProperty(required = false,value="其他用户" , notes = "其他用户")
	private String userOther;
	
	/**
	 * 改密策略：改密策略
	*/
	@ApiModelProperty(required = false,value="改密策略" , notes = "改密策略")
	private String passwordStrategyId;
	
	/**
	 * 备份方式：备份方式
	*/
	@ApiModelProperty(required = false,value="备份方式" , notes = "备份方式")
	private String hostBackupMethod;
	
	/**
	 * 备份情况：备份情况
	*/
	@ApiModelProperty(required = false,value="备份情况" , notes = "备份情况")
	private String hostBackupInfo;
	
	/**
	 * 下线时间：下线时间
	*/
	@ApiModelProperty(required = false,value="下线时间" , notes = "下线时间")
	private Date offlineTime;
	
	/**
	 * 上线时间：上线时间
	*/
	@ApiModelProperty(required = false,value="上线时间" , notes = "上线时间" , example = "2022-07-12 12:00:00")
	private Date onlineTime;
	
	/**
	 * 是否归档：是否归档
	*/
	@ApiModelProperty(required = false,value="是否归档" , notes = "是否归档" , example = "0")
	private String arch;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String labels;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String hostNotes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-07-12 10:00:03")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = false,value="是否已删除" , notes = "是否已删除" , example = "1")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 凭证：凭证
	*/
	@ApiModelProperty(required = false,value="凭证" , notes = "凭证")
	private List<Voucher> voucherList;
	
	/**
	 * 凭证：凭证
	*/
	@ApiModelProperty(required = false,value="凭证" , notes = "凭证")
	private List<String> voucherIds;
	
	/**
	 * 信息系统：信息系统
	*/
	@ApiModelProperty(required = false,value="信息系统" , notes = "信息系统")
	private InformationSystem infoSystem;
	
	/**
	 * 所在位置：所在位置
	*/
	@ApiModelProperty(required = false,value="所在位置" , notes = "所在位置")
	private HostPosition position;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
	private List<ServiceInfo> hostDbList;
	
	/**
	 * 数据库列表：数据库
	*/
	@ApiModelProperty(required = false,value="数据库列表" , notes = "数据库")
	private List<String> hostDbIds;
	
	/**
	 * 中间件：中间件
	*/
	@ApiModelProperty(required = false,value="中间件" , notes = "中间件")
	private List<ServiceInfo> hostMiddlewareList;
	
	/**
	 * 中间件列表：中间件
	*/
	@ApiModelProperty(required = false,value="中间件列表" , notes = "中间件")
	private List<String> hostMiddlewareIds;
	
	/**
	 * 操作系统：操作系统
	*/
	@ApiModelProperty(required = false,value="操作系统" , notes = "操作系统")
	private List<ServiceInfo> hostOsList;
	
	/**
	 * 操作系统列表：操作系统
	*/
	@ApiModelProperty(required = false,value="操作系统列表" , notes = "操作系统")
	private List<String> hostOsIds;
	
	/**
	 * 备份情况：备份情况
	*/
	@ApiModelProperty(required = false,value="备份情况" , notes = "备份情况")
	private DictItem backupMethod;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public Host setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 信息系统<br>
	 * 信息系统
	 * @return 信息系统
	*/
	public String getSystemId() {
		return systemId;
	}
	
	/**
	 * 设置 信息系统
	 * @param systemId 信息系统
	 * @return 当前对象
	*/
	public Host setSystemId(String systemId) {
		this.systemId=systemId;
		return this;
	}
	
	/**
	 * 获得 主机类型<br>
	 * 主机类型
	 * @return 主机类型
	*/
	public String getHostType() {
		return hostType;
	}
	
	/**
	 * 设置 主机类型
	 * @param hostType 主机类型
	 * @return 当前对象
	*/
	public Host setHostType(String hostType) {
		this.hostType=hostType;
		return this;
	}
	
	/**
	 * 获得 主机状态<br>
	 * 主机状态
	 * @return 主机状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 主机状态
	 * @param status 主机状态
	 * @return 当前对象
	*/
	public Host setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getHostName() {
		return hostName;
	}
	
	/**
	 * 设置 名称
	 * @param hostName 名称
	 * @return 当前对象
	*/
	public Host setHostName(String hostName) {
		this.hostName=hostName;
		return this;
	}
	
	/**
	 * 获得 物理IP<br>
	 * 物理IP
	 * @return 物理IP
	*/
	public String getHostIp() {
		return hostIp;
	}
	
	/**
	 * 设置 物理IP
	 * @param hostIp 物理IP
	 * @return 当前对象
	*/
	public Host setHostIp(String hostIp) {
		this.hostIp=hostIp;
		return this;
	}
	
	/**
	 * 获得 虚拟VIP<br>
	 * 虚拟VIP
	 * @return 虚拟VIP
	*/
	public String getHostVip() {
		return hostVip;
	}
	
	/**
	 * 设置 虚拟VIP
	 * @param hostVip 虚拟VIP
	 * @return 当前对象
	*/
	public Host setHostVip(String hostVip) {
		this.hostVip=hostVip;
		return this;
	}
	
	/**
	 * 获得 IPV6<br>
	 * IPV6
	 * @return IPV6
	*/
	public String getHostIpv6() {
		return hostIpv6;
	}
	
	/**
	 * 设置 IPV6
	 * @param hostIpv6 IPV6
	 * @return 当前对象
	*/
	public Host setHostIpv6(String hostIpv6) {
		this.hostIpv6=hostIpv6;
		return this;
	}
	
	/**
	 * 获得 运行环境<br>
	 * 运行环境
	 * @return 运行环境
	*/
	public String getEnvironment() {
		return environment;
	}
	
	/**
	 * 设置 运行环境
	 * @param environment 运行环境
	 * @return 当前对象
	*/
	public Host setEnvironment(String environment) {
		this.environment=environment;
		return this;
	}
	
	/**
	 * 获得 位置<br>
	 * 位置
	 * @return 位置
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 位置
	 * @param positionId 位置
	 * @return 当前对象
	*/
	public Host setPositionId(String positionId) {
		this.positionId=positionId;
		return this;
	}
	
	/**
	 * 获得 监控状态<br>
	 * 监控状态
	 * @return 监控状态
	*/
	public String getMonitorStatus() {
		return monitorStatus;
	}
	
	/**
	 * 设置 监控状态
	 * @param monitorStatus 监控状态
	 * @return 当前对象
	*/
	public Host setMonitorStatus(String monitorStatus) {
		this.monitorStatus=monitorStatus;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public String getDirectorUsername() {
		return directorUsername;
	}
	
	/**
	 * 设置 负责人
	 * @param directorUsername 负责人
	 * @return 当前对象
	*/
	public Host setDirectorUsername(String directorUsername) {
		this.directorUsername=directorUsername;
		return this;
	}
	
	/**
	 * 获得 内存<br>
	 * 内存
	 * @return 内存
	*/
	public BigDecimal getHostMemory() {
		return hostMemory;
	}
	
	/**
	 * 设置 内存
	 * @param hostMemory 内存
	 * @return 当前对象
	*/
	public Host setHostMemory(BigDecimal hostMemory) {
		this.hostMemory=hostMemory;
		return this;
	}
	
	/**
	 * 获得 CPU<br>
	 * CPU
	 * @return CPU
	*/
	public BigDecimal getHostCpu() {
		return hostCpu;
	}
	
	/**
	 * 设置 CPU
	 * @param hostCpu CPU
	 * @return 当前对象
	*/
	public Host setHostCpu(BigDecimal hostCpu) {
		this.hostCpu=hostCpu;
		return this;
	}
	
	/**
	 * 获得 其他配置<br>
	 * 其他配置
	 * @return 其他配置
	*/
	public String getHostConf() {
		return hostConf;
	}
	
	/**
	 * 设置 其他配置
	 * @param hostConf 其他配置
	 * @return 当前对象
	*/
	public Host setHostConf(String hostConf) {
		this.hostConf=hostConf;
		return this;
	}
	
	/**
	 * 获得 端口列表<br>
	 * 端口列表
	 * @return 端口列表
	*/
	public String getPortList() {
		return portList;
	}
	
	/**
	 * 设置 端口列表
	 * @param portList 端口列表
	 * @return 当前对象
	*/
	public Host setPortList(String portList) {
		this.portList=portList;
		return this;
	}
	
	/**
	 * 获得 系统管理员<br>
	 * 系统管理员
	 * @return 系统管理员
	*/
	public String getUserOsAdmin() {
		return userOsAdmin;
	}
	
	/**
	 * 设置 系统管理员
	 * @param userOsAdmin 系统管理员
	 * @return 当前对象
	*/
	public Host setUserOsAdmin(String userOsAdmin) {
		this.userOsAdmin=userOsAdmin;
		return this;
	}
	
	/**
	 * 获得 数据库管理员<br>
	 * 数据库管理员
	 * @return 数据库管理员
	*/
	public String getUserDbAdmin() {
		return userDbAdmin;
	}
	
	/**
	 * 设置 数据库管理员
	 * @param userDbAdmin 数据库管理员
	 * @return 当前对象
	*/
	public Host setUserDbAdmin(String userDbAdmin) {
		this.userDbAdmin=userDbAdmin;
		return this;
	}
	
	/**
	 * 获得 数据库使用用户<br>
	 * 数据库使用用户
	 * @return 数据库使用用户
	*/
	public String getUserDbUsed() {
		return userDbUsed;
	}
	
	/**
	 * 设置 数据库使用用户
	 * @param userDbUsed 数据库使用用户
	 * @return 当前对象
	*/
	public Host setUserDbUsed(String userDbUsed) {
		this.userDbUsed=userDbUsed;
		return this;
	}
	
	/**
	 * 获得 应用使用用户<br>
	 * 应用使用用户
	 * @return 应用使用用户
	*/
	public String getUserAppUsed() {
		return userAppUsed;
	}
	
	/**
	 * 设置 应用使用用户
	 * @param userAppUsed 应用使用用户
	 * @return 当前对象
	*/
	public Host setUserAppUsed(String userAppUsed) {
		this.userAppUsed=userAppUsed;
		return this;
	}
	
	/**
	 * 获得 运维操作用户<br>
	 * 运维操作用户
	 * @return 运维操作用户
	*/
	public String getUserOpsOper() {
		return userOpsOper;
	}
	
	/**
	 * 设置 运维操作用户
	 * @param userOpsOper 运维操作用户
	 * @return 当前对象
	*/
	public Host setUserOpsOper(String userOpsOper) {
		this.userOpsOper=userOpsOper;
		return this;
	}
	
	/**
	 * 获得 其他用户<br>
	 * 其他用户
	 * @return 其他用户
	*/
	public String getUserOther() {
		return userOther;
	}
	
	/**
	 * 设置 其他用户
	 * @param userOther 其他用户
	 * @return 当前对象
	*/
	public Host setUserOther(String userOther) {
		this.userOther=userOther;
		return this;
	}
	
	/**
	 * 获得 改密策略<br>
	 * 改密策略
	 * @return 改密策略
	*/
	public String getPasswordStrategyId() {
		return passwordStrategyId;
	}
	
	/**
	 * 设置 改密策略
	 * @param passwordStrategyId 改密策略
	 * @return 当前对象
	*/
	public Host setPasswordStrategyId(String passwordStrategyId) {
		this.passwordStrategyId=passwordStrategyId;
		return this;
	}
	
	/**
	 * 获得 备份方式<br>
	 * 备份方式
	 * @return 备份方式
	*/
	public String getHostBackupMethod() {
		return hostBackupMethod;
	}
	
	/**
	 * 设置 备份方式
	 * @param hostBackupMethod 备份方式
	 * @return 当前对象
	*/
	public Host setHostBackupMethod(String hostBackupMethod) {
		this.hostBackupMethod=hostBackupMethod;
		return this;
	}
	
	/**
	 * 获得 备份情况<br>
	 * 备份情况
	 * @return 备份情况
	*/
	public String getHostBackupInfo() {
		return hostBackupInfo;
	}
	
	/**
	 * 设置 备份情况
	 * @param hostBackupInfo 备份情况
	 * @return 当前对象
	*/
	public Host setHostBackupInfo(String hostBackupInfo) {
		this.hostBackupInfo=hostBackupInfo;
		return this;
	}
	
	/**
	 * 获得 下线时间<br>
	 * 下线时间
	 * @return 下线时间
	*/
	public Date getOfflineTime() {
		return offlineTime;
	}
	
	/**
	 * 设置 下线时间
	 * @param offlineTime 下线时间
	 * @return 当前对象
	*/
	public Host setOfflineTime(Date offlineTime) {
		this.offlineTime=offlineTime;
		return this;
	}
	
	/**
	 * 获得 上线时间<br>
	 * 上线时间
	 * @return 上线时间
	*/
	public Date getOnlineTime() {
		return onlineTime;
	}
	
	/**
	 * 设置 上线时间
	 * @param onlineTime 上线时间
	 * @return 当前对象
	*/
	public Host setOnlineTime(Date onlineTime) {
		this.onlineTime=onlineTime;
		return this;
	}
	
	/**
	 * 获得 是否归档<br>
	 * 是否归档
	 * @return 是否归档
	*/
	public String getArch() {
		return arch;
	}
	
	/**
	 * 设置 是否归档
	 * @param arch 是否归档
	 * @return 当前对象
	*/
	public Host setArch(String arch) {
		this.arch=arch;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabels() {
		return labels;
	}
	
	/**
	 * 设置 标签
	 * @param labels 标签
	 * @return 当前对象
	*/
	public Host setLabels(String labels) {
		this.labels=labels;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getHostNotes() {
		return hostNotes;
	}
	
	/**
	 * 设置 备注
	 * @param hostNotes 备注
	 * @return 当前对象
	*/
	public Host setHostNotes(String hostNotes) {
		this.hostNotes=hostNotes;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public Host setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public Host setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public Host setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public Host setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public Host setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public Host setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public Host setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public Host setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public Host setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public Host setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 凭证<br>
	 * 凭证
	 * @return 凭证
	*/
	public List<Voucher> getVoucherList() {
		return voucherList;
	}
	
	/**
	 * 设置 凭证
	 * @param voucherList 凭证
	 * @return 当前对象
	*/
	public Host setVoucherList(List<Voucher> voucherList) {
		this.voucherList=voucherList;
		return this;
	}
	
	/**
	 * 添加 凭证
	 * @param voucher 凭证
	 * @return 当前对象
	*/
	public Host addVoucher(Voucher... voucher) {
		if(this.voucherList==null) voucherList=new ArrayList<>();
		this.voucherList.addAll(Arrays.asList(voucher));
		return this;
	}
	
	/**
	 * 获得 凭证<br>
	 * 凭证
	 * @return 凭证
	*/
	public List<String> getVoucherIds() {
		return voucherIds;
	}
	
	/**
	 * 设置 凭证
	 * @param voucherIds 凭证
	 * @return 当前对象
	*/
	public Host setVoucherIds(List<String> voucherIds) {
		this.voucherIds=voucherIds;
		return this;
	}
	
	/**
	 * 添加 凭证
	 * @param voucherId 凭证
	 * @return 当前对象
	*/
	public Host addVoucherId(String... voucherId) {
		if(this.voucherIds==null) voucherIds=new ArrayList<>();
		this.voucherIds.addAll(Arrays.asList(voucherId));
		return this;
	}
	
	/**
	 * 获得 信息系统<br>
	 * 信息系统
	 * @return 信息系统
	*/
	public InformationSystem getInfoSystem() {
		return infoSystem;
	}
	
	/**
	 * 设置 信息系统
	 * @param infoSystem 信息系统
	 * @return 当前对象
	*/
	public Host setInfoSystem(InformationSystem infoSystem) {
		this.infoSystem=infoSystem;
		return this;
	}
	
	/**
	 * 获得 所在位置<br>
	 * 所在位置
	 * @return 所在位置
	*/
	public HostPosition getPosition() {
		return position;
	}
	
	/**
	 * 设置 所在位置
	 * @param position 所在位置
	 * @return 当前对象
	*/
	public Host setPosition(HostPosition position) {
		this.position=position;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public List<ServiceInfo> getHostDbList() {
		return hostDbList;
	}
	
	/**
	 * 设置 数据库
	 * @param hostDbList 数据库
	 * @return 当前对象
	*/
	public Host setHostDbList(List<ServiceInfo> hostDbList) {
		this.hostDbList=hostDbList;
		return this;
	}
	
	/**
	 * 添加 数据库
	 * @param hostDb 数据库
	 * @return 当前对象
	*/
	public Host addHostDb(ServiceInfo... hostDb) {
		if(this.hostDbList==null) hostDbList=new ArrayList<>();
		this.hostDbList.addAll(Arrays.asList(hostDb));
		return this;
	}
	
	/**
	 * 获得 数据库列表<br>
	 * 数据库
	 * @return 数据库列表
	*/
	public List<String> getHostDbIds() {
		return hostDbIds;
	}
	
	/**
	 * 设置 数据库列表
	 * @param hostDbIds 数据库列表
	 * @return 当前对象
	*/
	public Host setHostDbIds(List<String> hostDbIds) {
		this.hostDbIds=hostDbIds;
		return this;
	}
	
	/**
	 * 添加 数据库列表
	 * @param hostDbId 数据库列表
	 * @return 当前对象
	*/
	public Host addHostDbId(String... hostDbId) {
		if(this.hostDbIds==null) hostDbIds=new ArrayList<>();
		this.hostDbIds.addAll(Arrays.asList(hostDbId));
		return this;
	}
	
	/**
	 * 获得 中间件<br>
	 * 中间件
	 * @return 中间件
	*/
	public List<ServiceInfo> getHostMiddlewareList() {
		return hostMiddlewareList;
	}
	
	/**
	 * 设置 中间件
	 * @param hostMiddlewareList 中间件
	 * @return 当前对象
	*/
	public Host setHostMiddlewareList(List<ServiceInfo> hostMiddlewareList) {
		this.hostMiddlewareList=hostMiddlewareList;
		return this;
	}
	
	/**
	 * 添加 中间件
	 * @param hostMiddleware 中间件
	 * @return 当前对象
	*/
	public Host addHostMiddleware(ServiceInfo... hostMiddleware) {
		if(this.hostMiddlewareList==null) hostMiddlewareList=new ArrayList<>();
		this.hostMiddlewareList.addAll(Arrays.asList(hostMiddleware));
		return this;
	}
	
	/**
	 * 获得 中间件列表<br>
	 * 中间件
	 * @return 中间件列表
	*/
	public List<String> getHostMiddlewareIds() {
		return hostMiddlewareIds;
	}
	
	/**
	 * 设置 中间件列表
	 * @param hostMiddlewareIds 中间件列表
	 * @return 当前对象
	*/
	public Host setHostMiddlewareIds(List<String> hostMiddlewareIds) {
		this.hostMiddlewareIds=hostMiddlewareIds;
		return this;
	}
	
	/**
	 * 添加 中间件列表
	 * @param hostMiddlewareId 中间件列表
	 * @return 当前对象
	*/
	public Host addHostMiddlewareId(String... hostMiddlewareId) {
		if(this.hostMiddlewareIds==null) hostMiddlewareIds=new ArrayList<>();
		this.hostMiddlewareIds.addAll(Arrays.asList(hostMiddlewareId));
		return this;
	}
	
	/**
	 * 获得 操作系统<br>
	 * 操作系统
	 * @return 操作系统
	*/
	public List<ServiceInfo> getHostOsList() {
		return hostOsList;
	}
	
	/**
	 * 设置 操作系统
	 * @param hostOsList 操作系统
	 * @return 当前对象
	*/
	public Host setHostOsList(List<ServiceInfo> hostOsList) {
		this.hostOsList=hostOsList;
		return this;
	}
	
	/**
	 * 添加 操作系统
	 * @param hostOs 操作系统
	 * @return 当前对象
	*/
	public Host addHostOs(ServiceInfo... hostOs) {
		if(this.hostOsList==null) hostOsList=new ArrayList<>();
		this.hostOsList.addAll(Arrays.asList(hostOs));
		return this;
	}
	
	/**
	 * 获得 操作系统列表<br>
	 * 操作系统
	 * @return 操作系统列表
	*/
	public List<String> getHostOsIds() {
		return hostOsIds;
	}
	
	/**
	 * 设置 操作系统列表
	 * @param hostOsIds 操作系统列表
	 * @return 当前对象
	*/
	public Host setHostOsIds(List<String> hostOsIds) {
		this.hostOsIds=hostOsIds;
		return this;
	}
	
	/**
	 * 添加 操作系统列表
	 * @param hostOsId 操作系统列表
	 * @return 当前对象
	*/
	public Host addHostOsId(String... hostOsId) {
		if(this.hostOsIds==null) hostOsIds=new ArrayList<>();
		this.hostOsIds.addAll(Arrays.asList(hostOsId));
		return this;
	}
	
	/**
	 * 获得 备份情况<br>
	 * 备份情况
	 * @return 备份情况
	*/
	public DictItem getBackupMethod() {
		return backupMethod;
	}
	
	/**
	 * 设置 备份情况
	 * @param backupMethod 备份情况
	 * @return 当前对象
	*/
	public Host setBackupMethod(DictItem backupMethod) {
		this.backupMethod=backupMethod;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Host , 转换好的 Host 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Host , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
		com.dt.platform.domain.ops.meta.HostMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.HostMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Host clone(boolean deep) {
		return EntityContext.clone(Host.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Host
	 * @param hostMap 包含实体信息的 Map 对象
	 * @return Host , 转换好的的 Host 对象
	*/
	@Transient
	public static Host createFrom(Map<String,Object> hostMap) {
		if(hostMap==null) return null;
		Host po = create();
		EntityContext.copyProperties(po,hostMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Host
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Host , 转换好的的 Host 对象
	*/
	@Transient
	public static Host createFrom(Object pojo) {
		if(pojo==null) return null;
		Host po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Host，等同于 new
	 * @return Host 对象
	*/
	@Transient
	public static Host create() {
		return new com.dt.platform.domain.ops.meta.HostMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setHostName(DataParser.parse(String.class, map.get(HostMeta.HOST_NAME)));
			this.setUserDbUsed(DataParser.parse(String.class, map.get(HostMeta.USER_DB_USED)));
			this.setUserDbAdmin(DataParser.parse(String.class, map.get(HostMeta.USER_DB_ADMIN)));
			this.setPasswordStrategyId(DataParser.parse(String.class, map.get(HostMeta.PASSWORD_STRATEGY_ID)));
			this.setDirectorUsername(DataParser.parse(String.class, map.get(HostMeta.DIRECTOR_USERNAME)));
			this.setUserOsAdmin(DataParser.parse(String.class, map.get(HostMeta.USER_OS_ADMIN)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(HostMeta.UPDATE_BY)));
			this.setHostType(DataParser.parse(String.class, map.get(HostMeta.HOST_TYPE)));
			this.setPortList(DataParser.parse(String.class, map.get(HostMeta.PORT_LIST)));
			this.setOnlineTime(DataParser.parse(Date.class, map.get(HostMeta.ONLINE_TIME)));
			this.setOfflineTime(DataParser.parse(Date.class, map.get(HostMeta.OFFLINE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(HostMeta.ID)));
			this.setHostCpu(DataParser.parse(BigDecimal.class, map.get(HostMeta.HOST_CPU)));
			this.setUserAppUsed(DataParser.parse(String.class, map.get(HostMeta.USER_APP_USED)));
			this.setUserOther(DataParser.parse(String.class, map.get(HostMeta.USER_OTHER)));
			this.setHostBackupInfo(DataParser.parse(String.class, map.get(HostMeta.HOST_BACKUP_INFO)));
			this.setSystemId(DataParser.parse(String.class, map.get(HostMeta.SYSTEM_ID)));
			this.setHostConf(DataParser.parse(String.class, map.get(HostMeta.HOST_CONF)));
			this.setHostBackupMethod(DataParser.parse(String.class, map.get(HostMeta.HOST_BACKUP_METHOD)));
			this.setHostIp(DataParser.parse(String.class, map.get(HostMeta.HOST_IP)));
			this.setHostVip(DataParser.parse(String.class, map.get(HostMeta.HOST_VIP)));
			this.setHostMemory(DataParser.parse(BigDecimal.class, map.get(HostMeta.HOST_MEMORY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(HostMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(HostMeta.VERSION)));
			this.setLabels(DataParser.parse(String.class, map.get(HostMeta.LABELS)));
			this.setEnvironment(DataParser.parse(String.class, map.get(HostMeta.ENVIRONMENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(HostMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(HostMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(HostMeta.POSITION_ID)));
			this.setHostNotes(DataParser.parse(String.class, map.get(HostMeta.HOST_NOTES)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(HostMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(HostMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(HostMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(HostMeta.DELETE_BY)));
			this.setUserOpsOper(DataParser.parse(String.class, map.get(HostMeta.USER_OPS_OPER)));
			this.setArch(DataParser.parse(String.class, map.get(HostMeta.ARCH)));
			this.setMonitorStatus(DataParser.parse(String.class, map.get(HostMeta.MONITOR_STATUS)));
			this.setStatus(DataParser.parse(String.class, map.get(HostMeta.STATUS)));
			this.setHostIpv6(DataParser.parse(String.class, map.get(HostMeta.HOST_IPV6)));
			// others
			this.setInfoSystem(DataParser.parse(InformationSystem.class, map.get(HostMeta.INFO_SYSTEM)));
			this.setPosition(DataParser.parse(HostPosition.class, map.get(HostMeta.POSITION)));
			this.setBackupMethod(DataParser.parse(DictItem.class, map.get(HostMeta.BACKUP_METHOD)));
			return true;
		} else {
			try {
				this.setHostName( (String)map.get(HostMeta.HOST_NAME));
				this.setUserDbUsed( (String)map.get(HostMeta.USER_DB_USED));
				this.setUserDbAdmin( (String)map.get(HostMeta.USER_DB_ADMIN));
				this.setPasswordStrategyId( (String)map.get(HostMeta.PASSWORD_STRATEGY_ID));
				this.setDirectorUsername( (String)map.get(HostMeta.DIRECTOR_USERNAME));
				this.setUserOsAdmin( (String)map.get(HostMeta.USER_OS_ADMIN));
				this.setUpdateBy( (String)map.get(HostMeta.UPDATE_BY));
				this.setHostType( (String)map.get(HostMeta.HOST_TYPE));
				this.setPortList( (String)map.get(HostMeta.PORT_LIST));
				this.setOnlineTime( (Date)map.get(HostMeta.ONLINE_TIME));
				this.setOfflineTime( (Date)map.get(HostMeta.OFFLINE_TIME));
				this.setId( (String)map.get(HostMeta.ID));
				this.setHostCpu( (BigDecimal)map.get(HostMeta.HOST_CPU));
				this.setUserAppUsed( (String)map.get(HostMeta.USER_APP_USED));
				this.setUserOther( (String)map.get(HostMeta.USER_OTHER));
				this.setHostBackupInfo( (String)map.get(HostMeta.HOST_BACKUP_INFO));
				this.setSystemId( (String)map.get(HostMeta.SYSTEM_ID));
				this.setHostConf( (String)map.get(HostMeta.HOST_CONF));
				this.setHostBackupMethod( (String)map.get(HostMeta.HOST_BACKUP_METHOD));
				this.setHostIp( (String)map.get(HostMeta.HOST_IP));
				this.setHostVip( (String)map.get(HostMeta.HOST_VIP));
				this.setHostMemory( (BigDecimal)map.get(HostMeta.HOST_MEMORY));
				this.setUpdateTime( (Date)map.get(HostMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(HostMeta.VERSION));
				this.setLabels( (String)map.get(HostMeta.LABELS));
				this.setEnvironment( (String)map.get(HostMeta.ENVIRONMENT));
				this.setCreateBy( (String)map.get(HostMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(HostMeta.DELETED));
				this.setPositionId( (String)map.get(HostMeta.POSITION_ID));
				this.setHostNotes( (String)map.get(HostMeta.HOST_NOTES));
				this.setCreateTime( (Date)map.get(HostMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(HostMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(HostMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(HostMeta.DELETE_BY));
				this.setUserOpsOper( (String)map.get(HostMeta.USER_OPS_OPER));
				this.setArch( (String)map.get(HostMeta.ARCH));
				this.setMonitorStatus( (String)map.get(HostMeta.MONITOR_STATUS));
				this.setStatus( (String)map.get(HostMeta.STATUS));
				this.setHostIpv6( (String)map.get(HostMeta.HOST_IPV6));
				// others
				this.setInfoSystem( (InformationSystem)map.get(HostMeta.INFO_SYSTEM));
				this.setPosition( (HostPosition)map.get(HostMeta.POSITION));
				this.setBackupMethod( (DictItem)map.get(HostMeta.BACKUP_METHOD));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setHostName(DataParser.parse(String.class, r.getValue(HostMeta.HOST_NAME)));
			this.setUserDbUsed(DataParser.parse(String.class, r.getValue(HostMeta.USER_DB_USED)));
			this.setUserDbAdmin(DataParser.parse(String.class, r.getValue(HostMeta.USER_DB_ADMIN)));
			this.setPasswordStrategyId(DataParser.parse(String.class, r.getValue(HostMeta.PASSWORD_STRATEGY_ID)));
			this.setDirectorUsername(DataParser.parse(String.class, r.getValue(HostMeta.DIRECTOR_USERNAME)));
			this.setUserOsAdmin(DataParser.parse(String.class, r.getValue(HostMeta.USER_OS_ADMIN)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(HostMeta.UPDATE_BY)));
			this.setHostType(DataParser.parse(String.class, r.getValue(HostMeta.HOST_TYPE)));
			this.setPortList(DataParser.parse(String.class, r.getValue(HostMeta.PORT_LIST)));
			this.setOnlineTime(DataParser.parse(Date.class, r.getValue(HostMeta.ONLINE_TIME)));
			this.setOfflineTime(DataParser.parse(Date.class, r.getValue(HostMeta.OFFLINE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(HostMeta.ID)));
			this.setHostCpu(DataParser.parse(BigDecimal.class, r.getValue(HostMeta.HOST_CPU)));
			this.setUserAppUsed(DataParser.parse(String.class, r.getValue(HostMeta.USER_APP_USED)));
			this.setUserOther(DataParser.parse(String.class, r.getValue(HostMeta.USER_OTHER)));
			this.setHostBackupInfo(DataParser.parse(String.class, r.getValue(HostMeta.HOST_BACKUP_INFO)));
			this.setSystemId(DataParser.parse(String.class, r.getValue(HostMeta.SYSTEM_ID)));
			this.setHostConf(DataParser.parse(String.class, r.getValue(HostMeta.HOST_CONF)));
			this.setHostBackupMethod(DataParser.parse(String.class, r.getValue(HostMeta.HOST_BACKUP_METHOD)));
			this.setHostIp(DataParser.parse(String.class, r.getValue(HostMeta.HOST_IP)));
			this.setHostVip(DataParser.parse(String.class, r.getValue(HostMeta.HOST_VIP)));
			this.setHostMemory(DataParser.parse(BigDecimal.class, r.getValue(HostMeta.HOST_MEMORY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(HostMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(HostMeta.VERSION)));
			this.setLabels(DataParser.parse(String.class, r.getValue(HostMeta.LABELS)));
			this.setEnvironment(DataParser.parse(String.class, r.getValue(HostMeta.ENVIRONMENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(HostMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(HostMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(HostMeta.POSITION_ID)));
			this.setHostNotes(DataParser.parse(String.class, r.getValue(HostMeta.HOST_NOTES)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(HostMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(HostMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(HostMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(HostMeta.DELETE_BY)));
			this.setUserOpsOper(DataParser.parse(String.class, r.getValue(HostMeta.USER_OPS_OPER)));
			this.setArch(DataParser.parse(String.class, r.getValue(HostMeta.ARCH)));
			this.setMonitorStatus(DataParser.parse(String.class, r.getValue(HostMeta.MONITOR_STATUS)));
			this.setStatus(DataParser.parse(String.class, r.getValue(HostMeta.STATUS)));
			this.setHostIpv6(DataParser.parse(String.class, r.getValue(HostMeta.HOST_IPV6)));
			return true;
		} else {
			try {
				this.setHostName( (String)r.getValue(HostMeta.HOST_NAME));
				this.setUserDbUsed( (String)r.getValue(HostMeta.USER_DB_USED));
				this.setUserDbAdmin( (String)r.getValue(HostMeta.USER_DB_ADMIN));
				this.setPasswordStrategyId( (String)r.getValue(HostMeta.PASSWORD_STRATEGY_ID));
				this.setDirectorUsername( (String)r.getValue(HostMeta.DIRECTOR_USERNAME));
				this.setUserOsAdmin( (String)r.getValue(HostMeta.USER_OS_ADMIN));
				this.setUpdateBy( (String)r.getValue(HostMeta.UPDATE_BY));
				this.setHostType( (String)r.getValue(HostMeta.HOST_TYPE));
				this.setPortList( (String)r.getValue(HostMeta.PORT_LIST));
				this.setOnlineTime( (Date)r.getValue(HostMeta.ONLINE_TIME));
				this.setOfflineTime( (Date)r.getValue(HostMeta.OFFLINE_TIME));
				this.setId( (String)r.getValue(HostMeta.ID));
				this.setHostCpu( (BigDecimal)r.getValue(HostMeta.HOST_CPU));
				this.setUserAppUsed( (String)r.getValue(HostMeta.USER_APP_USED));
				this.setUserOther( (String)r.getValue(HostMeta.USER_OTHER));
				this.setHostBackupInfo( (String)r.getValue(HostMeta.HOST_BACKUP_INFO));
				this.setSystemId( (String)r.getValue(HostMeta.SYSTEM_ID));
				this.setHostConf( (String)r.getValue(HostMeta.HOST_CONF));
				this.setHostBackupMethod( (String)r.getValue(HostMeta.HOST_BACKUP_METHOD));
				this.setHostIp( (String)r.getValue(HostMeta.HOST_IP));
				this.setHostVip( (String)r.getValue(HostMeta.HOST_VIP));
				this.setHostMemory( (BigDecimal)r.getValue(HostMeta.HOST_MEMORY));
				this.setUpdateTime( (Date)r.getValue(HostMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(HostMeta.VERSION));
				this.setLabels( (String)r.getValue(HostMeta.LABELS));
				this.setEnvironment( (String)r.getValue(HostMeta.ENVIRONMENT));
				this.setCreateBy( (String)r.getValue(HostMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(HostMeta.DELETED));
				this.setPositionId( (String)r.getValue(HostMeta.POSITION_ID));
				this.setHostNotes( (String)r.getValue(HostMeta.HOST_NOTES));
				this.setCreateTime( (Date)r.getValue(HostMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(HostMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(HostMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(HostMeta.DELETE_BY));
				this.setUserOpsOper( (String)r.getValue(HostMeta.USER_OPS_OPER));
				this.setArch( (String)r.getValue(HostMeta.ARCH));
				this.setMonitorStatus( (String)r.getValue(HostMeta.MONITOR_STATUS));
				this.setStatus( (String)r.getValue(HostMeta.STATUS));
				this.setHostIpv6( (String)r.getValue(HostMeta.HOST_IPV6));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}