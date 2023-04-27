package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_INFORMATION_SYSTEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.InformationSystemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 信息系统
 * <p>信息系统 , 数据表 ops_information_system 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-03 16:00:36
 * @sign 2CDDB9AB8C1C930E074CD97490FD7AB1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_information_system")
@ApiModel(description = "信息系统 ; 信息系统 , 数据表 ops_information_system 的PO类型")
public class InformationSystem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_INFORMATION_SYSTEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "599359261440475136")
	private String id;
	
	/**
	 * 父节点：父节点
	*/
	@ApiModelProperty(required = false,value="父节点" , notes = "父节点")
	private String pid;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "测试")
	private String name;
	
	/**
	 * 介绍：介绍
	*/
	@ApiModelProperty(required = false,value="介绍" , notes = "介绍")
	private String profile;
	
	/**
	 * 当前状态：当前状态
	*/
	@ApiModelProperty(required = false,value="当前状态" , notes = "当前状态" , example = "offline")
	private String status;
	
	/**
	 * 访问地址：访问地址
	*/
	@ApiModelProperty(required = false,value="访问地址" , notes = "访问地址")
	private String address;
	
	/**
	 * 运维模式：运维模式
	*/
	@ApiModelProperty(required = false,value="运维模式" , notes = "运维模式")
	private String opsMethod;
	
	/**
	 * 开发模式：开发模式
	*/
	@ApiModelProperty(required = false,value="开发模式" , notes = "开发模式")
	private String devMethod;
	
	/**
	 * 技术联系人：技术联系人
	*/
	@ApiModelProperty(required = false,value="技术联系人" , notes = "技术联系人")
	private String technicalContact;
	
	/**
	 * 业务联系人：业务联系人
	*/
	@ApiModelProperty(required = false,value="业务联系人" , notes = "业务联系人")
	private String businessContact;
	
	/**
	 * 所属公司/部门：所属公司/部门
	*/
	@ApiModelProperty(required = false,value="所属公司/部门" , notes = "所属公司/部门")
	private String belongOrgId;
	
	/**
	 * 最后一次演练：最后一次演练
	*/
	@ApiModelProperty(required = false,value="最后一次演练" , notes = "最后一次演练")
	private Date lastdrillDate;
	
	/**
	 * 上线时间：上线时间
	*/
	@ApiModelProperty(required = false,value="上线时间" , notes = "上线时间" , example = "2022-07-12 12:00:00")
	private Date onlineDate;
	
	/**
	 * 下线时间：下线时间
	*/
	@ApiModelProperty(required = false,value="下线时间" , notes = "下线时间")
	private Date offlineDate;
	
	/**
	 * 操作系统：操作系统
	*/
	@ApiModelProperty(required = false,value="操作系统" , notes = "操作系统")
	private String osInfo;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
	private String dbInfo;
	
	/**
	 * 应用：应用
	*/
	@ApiModelProperty(required = false,value="应用" , notes = "应用")
	private String appInfo;
	
	/**
	 * 等级：等级
	*/
	@ApiModelProperty(required = false,value="等级" , notes = "等级")
	private String grade;
	
	/**
	 * RTO：RTO
	*/
	@ApiModelProperty(required = false,value="RTO" , notes = "RTO")
	private String rto;
	
	/**
	 * RPO：RPO
	*/
	@ApiModelProperty(required = false,value="RPO" , notes = "RPO")
	private String rpo;
	
	/**
	 * 硬件信息：硬件信息
	*/
	@ApiModelProperty(required = false,value="硬件信息" , notes = "硬件信息")
	private String hardwareInfo;
	
	/**
	 * 备份信息：备份信息
	*/
	@ApiModelProperty(required = false,value="备份信息" , notes = "备份信息")
	private String backupInfo;
	
	/**
	 * 本地备份：本地备份
	*/
	@ApiModelProperty(required = false,value="本地备份" , notes = "本地备份")
	private String sameplaceBacupInfo;
	
	/**
	 * 异地备份：异地备份
	*/
	@ApiModelProperty(required = false,value="异地备份" , notes = "异地备份")
	private String diffplaceBackupInfo;
	
	/**
	 * 归档模式：归档模式
	*/
	@ApiModelProperty(required = false,value="归档模式" , notes = "归档模式")
	private String archMethod;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签")
	private String labels;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-07-12 09:59:43")
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "1")
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
	 * 所属公司/部门：所属公司/部门
	*/
	@ApiModelProperty(required = false,value="所属公司/部门" , notes = "所属公司/部门")
	private Organization belongOrganization;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private DictItem infoSystemStatus;
	
	/**
	 * 运维模式：运维模式
	*/
	@ApiModelProperty(required = false,value="运维模式" , notes = "运维模式")
	private DictItem infoSystemOpsMethod;
	
	/**
	 * 开发模式：开发模式
	*/
	@ApiModelProperty(required = false,value="开发模式" , notes = "开发模式")
	private DictItem infoSystemDevMethod;
	
	/**
	 * 系统分级：系统分级
	*/
	@ApiModelProperty(required = false,value="系统分级" , notes = "系统分级")
	private DictItem infoSystemGrade;
	
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
	public InformationSystem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 父节点<br>
	 * 父节点
	 * @return 父节点
	*/
	public String getPid() {
		return pid;
	}
	
	/**
	 * 设置 父节点
	 * @param pid 父节点
	 * @return 当前对象
	*/
	public InformationSystem setPid(String pid) {
		this.pid=pid;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public InformationSystem setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 介绍<br>
	 * 介绍
	 * @return 介绍
	*/
	public String getProfile() {
		return profile;
	}
	
	/**
	 * 设置 介绍
	 * @param profile 介绍
	 * @return 当前对象
	*/
	public InformationSystem setProfile(String profile) {
		this.profile=profile;
		return this;
	}
	
	/**
	 * 获得 当前状态<br>
	 * 当前状态
	 * @return 当前状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 当前状态
	 * @param status 当前状态
	 * @return 当前对象
	*/
	public InformationSystem setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 访问地址<br>
	 * 访问地址
	 * @return 访问地址
	*/
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置 访问地址
	 * @param address 访问地址
	 * @return 当前对象
	*/
	public InformationSystem setAddress(String address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 运维模式<br>
	 * 运维模式
	 * @return 运维模式
	*/
	public String getOpsMethod() {
		return opsMethod;
	}
	
	/**
	 * 设置 运维模式
	 * @param opsMethod 运维模式
	 * @return 当前对象
	*/
	public InformationSystem setOpsMethod(String opsMethod) {
		this.opsMethod=opsMethod;
		return this;
	}
	
	/**
	 * 获得 开发模式<br>
	 * 开发模式
	 * @return 开发模式
	*/
	public String getDevMethod() {
		return devMethod;
	}
	
	/**
	 * 设置 开发模式
	 * @param devMethod 开发模式
	 * @return 当前对象
	*/
	public InformationSystem setDevMethod(String devMethod) {
		this.devMethod=devMethod;
		return this;
	}
	
	/**
	 * 获得 技术联系人<br>
	 * 技术联系人
	 * @return 技术联系人
	*/
	public String getTechnicalContact() {
		return technicalContact;
	}
	
	/**
	 * 设置 技术联系人
	 * @param technicalContact 技术联系人
	 * @return 当前对象
	*/
	public InformationSystem setTechnicalContact(String technicalContact) {
		this.technicalContact=technicalContact;
		return this;
	}
	
	/**
	 * 获得 业务联系人<br>
	 * 业务联系人
	 * @return 业务联系人
	*/
	public String getBusinessContact() {
		return businessContact;
	}
	
	/**
	 * 设置 业务联系人
	 * @param businessContact 业务联系人
	 * @return 当前对象
	*/
	public InformationSystem setBusinessContact(String businessContact) {
		this.businessContact=businessContact;
		return this;
	}
	
	/**
	 * 获得 所属公司/部门<br>
	 * 所属公司/部门
	 * @return 所属公司/部门
	*/
	public String getBelongOrgId() {
		return belongOrgId;
	}
	
	/**
	 * 设置 所属公司/部门
	 * @param belongOrgId 所属公司/部门
	 * @return 当前对象
	*/
	public InformationSystem setBelongOrgId(String belongOrgId) {
		this.belongOrgId=belongOrgId;
		return this;
	}
	
	/**
	 * 获得 最后一次演练<br>
	 * 最后一次演练
	 * @return 最后一次演练
	*/
	public Date getLastdrillDate() {
		return lastdrillDate;
	}
	
	/**
	 * 设置 最后一次演练
	 * @param lastdrillDate 最后一次演练
	 * @return 当前对象
	*/
	public InformationSystem setLastdrillDate(Date lastdrillDate) {
		this.lastdrillDate=lastdrillDate;
		return this;
	}
	
	/**
	 * 获得 上线时间<br>
	 * 上线时间
	 * @return 上线时间
	*/
	public Date getOnlineDate() {
		return onlineDate;
	}
	
	/**
	 * 设置 上线时间
	 * @param onlineDate 上线时间
	 * @return 当前对象
	*/
	public InformationSystem setOnlineDate(Date onlineDate) {
		this.onlineDate=onlineDate;
		return this;
	}
	
	/**
	 * 获得 下线时间<br>
	 * 下线时间
	 * @return 下线时间
	*/
	public Date getOfflineDate() {
		return offlineDate;
	}
	
	/**
	 * 设置 下线时间
	 * @param offlineDate 下线时间
	 * @return 当前对象
	*/
	public InformationSystem setOfflineDate(Date offlineDate) {
		this.offlineDate=offlineDate;
		return this;
	}
	
	/**
	 * 获得 操作系统<br>
	 * 操作系统
	 * @return 操作系统
	*/
	public String getOsInfo() {
		return osInfo;
	}
	
	/**
	 * 设置 操作系统
	 * @param osInfo 操作系统
	 * @return 当前对象
	*/
	public InformationSystem setOsInfo(String osInfo) {
		this.osInfo=osInfo;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public String getDbInfo() {
		return dbInfo;
	}
	
	/**
	 * 设置 数据库
	 * @param dbInfo 数据库
	 * @return 当前对象
	*/
	public InformationSystem setDbInfo(String dbInfo) {
		this.dbInfo=dbInfo;
		return this;
	}
	
	/**
	 * 获得 应用<br>
	 * 应用
	 * @return 应用
	*/
	public String getAppInfo() {
		return appInfo;
	}
	
	/**
	 * 设置 应用
	 * @param appInfo 应用
	 * @return 当前对象
	*/
	public InformationSystem setAppInfo(String appInfo) {
		this.appInfo=appInfo;
		return this;
	}
	
	/**
	 * 获得 等级<br>
	 * 等级
	 * @return 等级
	*/
	public String getGrade() {
		return grade;
	}
	
	/**
	 * 设置 等级
	 * @param grade 等级
	 * @return 当前对象
	*/
	public InformationSystem setGrade(String grade) {
		this.grade=grade;
		return this;
	}
	
	/**
	 * 获得 RTO<br>
	 * RTO
	 * @return RTO
	*/
	public String getRto() {
		return rto;
	}
	
	/**
	 * 设置 RTO
	 * @param rto RTO
	 * @return 当前对象
	*/
	public InformationSystem setRto(String rto) {
		this.rto=rto;
		return this;
	}
	
	/**
	 * 获得 RPO<br>
	 * RPO
	 * @return RPO
	*/
	public String getRpo() {
		return rpo;
	}
	
	/**
	 * 设置 RPO
	 * @param rpo RPO
	 * @return 当前对象
	*/
	public InformationSystem setRpo(String rpo) {
		this.rpo=rpo;
		return this;
	}
	
	/**
	 * 获得 硬件信息<br>
	 * 硬件信息
	 * @return 硬件信息
	*/
	public String getHardwareInfo() {
		return hardwareInfo;
	}
	
	/**
	 * 设置 硬件信息
	 * @param hardwareInfo 硬件信息
	 * @return 当前对象
	*/
	public InformationSystem setHardwareInfo(String hardwareInfo) {
		this.hardwareInfo=hardwareInfo;
		return this;
	}
	
	/**
	 * 获得 备份信息<br>
	 * 备份信息
	 * @return 备份信息
	*/
	public String getBackupInfo() {
		return backupInfo;
	}
	
	/**
	 * 设置 备份信息
	 * @param backupInfo 备份信息
	 * @return 当前对象
	*/
	public InformationSystem setBackupInfo(String backupInfo) {
		this.backupInfo=backupInfo;
		return this;
	}
	
	/**
	 * 获得 本地备份<br>
	 * 本地备份
	 * @return 本地备份
	*/
	public String getSameplaceBacupInfo() {
		return sameplaceBacupInfo;
	}
	
	/**
	 * 设置 本地备份
	 * @param sameplaceBacupInfo 本地备份
	 * @return 当前对象
	*/
	public InformationSystem setSameplaceBacupInfo(String sameplaceBacupInfo) {
		this.sameplaceBacupInfo=sameplaceBacupInfo;
		return this;
	}
	
	/**
	 * 获得 异地备份<br>
	 * 异地备份
	 * @return 异地备份
	*/
	public String getDiffplaceBackupInfo() {
		return diffplaceBackupInfo;
	}
	
	/**
	 * 设置 异地备份
	 * @param diffplaceBackupInfo 异地备份
	 * @return 当前对象
	*/
	public InformationSystem setDiffplaceBackupInfo(String diffplaceBackupInfo) {
		this.diffplaceBackupInfo=diffplaceBackupInfo;
		return this;
	}
	
	/**
	 * 获得 归档模式<br>
	 * 归档模式
	 * @return 归档模式
	*/
	public String getArchMethod() {
		return archMethod;
	}
	
	/**
	 * 设置 归档模式
	 * @param archMethod 归档模式
	 * @return 当前对象
	*/
	public InformationSystem setArchMethod(String archMethod) {
		this.archMethod=archMethod;
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
	public InformationSystem setLabels(String labels) {
		this.labels=labels;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public InformationSystem setNotes(String notes) {
		this.notes=notes;
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
	public InformationSystem setCreateBy(String createBy) {
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
	public InformationSystem setCreateTime(Date createTime) {
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
	public InformationSystem setUpdateBy(String updateBy) {
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
	public InformationSystem setUpdateTime(Date updateTime) {
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
	public InformationSystem setDeleted(Integer deleted) {
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
	public InformationSystem setDeleted(Boolean deletedBool) {
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
	public InformationSystem setDeleteBy(String deleteBy) {
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
	public InformationSystem setDeleteTime(Date deleteTime) {
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
	public InformationSystem setVersion(Integer version) {
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
	public InformationSystem setTenantId(String tenantId) {
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
	public InformationSystem setVoucherList(List<Voucher> voucherList) {
		this.voucherList=voucherList;
		return this;
	}
	
	/**
	 * 添加 凭证
	 * @param voucher 凭证
	 * @return 当前对象
	*/
	public InformationSystem addVoucher(Voucher... voucher) {
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
	public InformationSystem setVoucherIds(List<String> voucherIds) {
		this.voucherIds=voucherIds;
		return this;
	}
	
	/**
	 * 添加 凭证
	 * @param voucherId 凭证
	 * @return 当前对象
	*/
	public InformationSystem addVoucherId(String... voucherId) {
		if(this.voucherIds==null) voucherIds=new ArrayList<>();
		this.voucherIds.addAll(Arrays.asList(voucherId));
		return this;
	}
	
	/**
	 * 获得 所属公司/部门<br>
	 * 所属公司/部门
	 * @return 所属公司/部门
	*/
	public Organization getBelongOrganization() {
		return belongOrganization;
	}
	
	/**
	 * 设置 所属公司/部门
	 * @param belongOrganization 所属公司/部门
	 * @return 当前对象
	*/
	public InformationSystem setBelongOrganization(Organization belongOrganization) {
		this.belongOrganization=belongOrganization;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public DictItem getInfoSystemStatus() {
		return infoSystemStatus;
	}
	
	/**
	 * 设置 状态
	 * @param infoSystemStatus 状态
	 * @return 当前对象
	*/
	public InformationSystem setInfoSystemStatus(DictItem infoSystemStatus) {
		this.infoSystemStatus=infoSystemStatus;
		return this;
	}
	
	/**
	 * 获得 运维模式<br>
	 * 运维模式
	 * @return 运维模式
	*/
	public DictItem getInfoSystemOpsMethod() {
		return infoSystemOpsMethod;
	}
	
	/**
	 * 设置 运维模式
	 * @param infoSystemOpsMethod 运维模式
	 * @return 当前对象
	*/
	public InformationSystem setInfoSystemOpsMethod(DictItem infoSystemOpsMethod) {
		this.infoSystemOpsMethod=infoSystemOpsMethod;
		return this;
	}
	
	/**
	 * 获得 开发模式<br>
	 * 开发模式
	 * @return 开发模式
	*/
	public DictItem getInfoSystemDevMethod() {
		return infoSystemDevMethod;
	}
	
	/**
	 * 设置 开发模式
	 * @param infoSystemDevMethod 开发模式
	 * @return 当前对象
	*/
	public InformationSystem setInfoSystemDevMethod(DictItem infoSystemDevMethod) {
		this.infoSystemDevMethod=infoSystemDevMethod;
		return this;
	}
	
	/**
	 * 获得 系统分级<br>
	 * 系统分级
	 * @return 系统分级
	*/
	public DictItem getInfoSystemGrade() {
		return infoSystemGrade;
	}
	
	/**
	 * 设置 系统分级
	 * @param infoSystemGrade 系统分级
	 * @return 当前对象
	*/
	public InformationSystem setInfoSystemGrade(DictItem infoSystemGrade) {
		this.infoSystemGrade=infoSystemGrade;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InformationSystem , 转换好的 InformationSystem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InformationSystem , 转换好的 PoJo 对象
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
	public InformationSystem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InformationSystem duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.InformationSystemMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.InformationSystemMeta.$$proxy$$();
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
			inst.setInfoSystemStatus(this.getInfoSystemStatus());
			inst.setVoucherList(this.getVoucherList());
			inst.setInfoSystemDevMethod(this.getInfoSystemDevMethod());
			inst.setInfoSystemGrade(this.getInfoSystemGrade());
			inst.setBelongOrganization(this.getBelongOrganization());
			inst.setInfoSystemOpsMethod(this.getInfoSystemOpsMethod());
			inst.setVoucherIds(this.getVoucherIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InformationSystem clone(boolean deep) {
		return EntityContext.clone(InformationSystem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InformationSystem
	 * @param informationSystemMap 包含实体信息的 Map 对象
	 * @return InformationSystem , 转换好的的 InformationSystem 对象
	*/
	@Transient
	public static InformationSystem createFrom(Map<String,Object> informationSystemMap) {
		if(informationSystemMap==null) return null;
		InformationSystem po = create();
		EntityContext.copyProperties(po,informationSystemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InformationSystem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InformationSystem , 转换好的的 InformationSystem 对象
	*/
	@Transient
	public static InformationSystem createFrom(Object pojo) {
		if(pojo==null) return null;
		InformationSystem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InformationSystem，等同于 new
	 * @return InformationSystem 对象
	*/
	@Transient
	public static InformationSystem create() {
		return new com.dt.platform.domain.ops.meta.InformationSystemMeta.$$proxy$$();
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
			this.setSameplaceBacupInfo(DataParser.parse(String.class, map.get(InformationSystemMeta.SAMEPLACE_BACUP_INFO)));
			this.setArchMethod(DataParser.parse(String.class, map.get(InformationSystemMeta.ARCH_METHOD)));
			this.setNotes(DataParser.parse(String.class, map.get(InformationSystemMeta.NOTES)));
			this.setAppInfo(DataParser.parse(String.class, map.get(InformationSystemMeta.APP_INFO)));
			this.setPid(DataParser.parse(String.class, map.get(InformationSystemMeta.PID)));
			this.setDevMethod(DataParser.parse(String.class, map.get(InformationSystemMeta.DEV_METHOD)));
			this.setTechnicalContact(DataParser.parse(String.class, map.get(InformationSystemMeta.TECHNICAL_CONTACT)));
			this.setOsInfo(DataParser.parse(String.class, map.get(InformationSystemMeta.OS_INFO)));
			this.setHardwareInfo(DataParser.parse(String.class, map.get(InformationSystemMeta.HARDWARE_INFO)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InformationSystemMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(InformationSystemMeta.ID)));
			this.setBackupInfo(DataParser.parse(String.class, map.get(InformationSystemMeta.BACKUP_INFO)));
			this.setDbInfo(DataParser.parse(String.class, map.get(InformationSystemMeta.DB_INFO)));
			this.setDiffplaceBackupInfo(DataParser.parse(String.class, map.get(InformationSystemMeta.DIFFPLACE_BACKUP_INFO)));
			this.setAddress(DataParser.parse(String.class, map.get(InformationSystemMeta.ADDRESS)));
			this.setBelongOrgId(DataParser.parse(String.class, map.get(InformationSystemMeta.BELONG_ORG_ID)));
			this.setProfile(DataParser.parse(String.class, map.get(InformationSystemMeta.PROFILE)));
			this.setBusinessContact(DataParser.parse(String.class, map.get(InformationSystemMeta.BUSINESS_CONTACT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InformationSystemMeta.UPDATE_TIME)));
			this.setRto(DataParser.parse(String.class, map.get(InformationSystemMeta.RTO)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InformationSystemMeta.VERSION)));
			this.setLabels(DataParser.parse(String.class, map.get(InformationSystemMeta.LABELS)));
			this.setOnlineDate(DataParser.parse(Date.class, map.get(InformationSystemMeta.ONLINE_DATE)));
			this.setRpo(DataParser.parse(String.class, map.get(InformationSystemMeta.RPO)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InformationSystemMeta.CREATE_BY)));
			this.setOfflineDate(DataParser.parse(Date.class, map.get(InformationSystemMeta.OFFLINE_DATE)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InformationSystemMeta.DELETED)));
			this.setOpsMethod(DataParser.parse(String.class, map.get(InformationSystemMeta.OPS_METHOD)));
			this.setLastdrillDate(DataParser.parse(Date.class, map.get(InformationSystemMeta.LASTDRILL_DATE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InformationSystemMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InformationSystemMeta.DELETE_TIME)));
			this.setGrade(DataParser.parse(String.class, map.get(InformationSystemMeta.GRADE)));
			this.setName(DataParser.parse(String.class, map.get(InformationSystemMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(InformationSystemMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InformationSystemMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(InformationSystemMeta.STATUS)));
			// others
			this.setInfoSystemStatus(DataParser.parse(DictItem.class, map.get(InformationSystemMeta.INFO_SYSTEM_STATUS)));
			this.setInfoSystemDevMethod(DataParser.parse(DictItem.class, map.get(InformationSystemMeta.INFO_SYSTEM_DEV_METHOD)));
			this.setInfoSystemGrade(DataParser.parse(DictItem.class, map.get(InformationSystemMeta.INFO_SYSTEM_GRADE)));
			this.setBelongOrganization(DataParser.parse(Organization.class, map.get(InformationSystemMeta.BELONG_ORGANIZATION)));
			this.setInfoSystemOpsMethod(DataParser.parse(DictItem.class, map.get(InformationSystemMeta.INFO_SYSTEM_OPS_METHOD)));
			return true;
		} else {
			try {
				this.setSameplaceBacupInfo( (String)map.get(InformationSystemMeta.SAMEPLACE_BACUP_INFO));
				this.setArchMethod( (String)map.get(InformationSystemMeta.ARCH_METHOD));
				this.setNotes( (String)map.get(InformationSystemMeta.NOTES));
				this.setAppInfo( (String)map.get(InformationSystemMeta.APP_INFO));
				this.setPid( (String)map.get(InformationSystemMeta.PID));
				this.setDevMethod( (String)map.get(InformationSystemMeta.DEV_METHOD));
				this.setTechnicalContact( (String)map.get(InformationSystemMeta.TECHNICAL_CONTACT));
				this.setOsInfo( (String)map.get(InformationSystemMeta.OS_INFO));
				this.setHardwareInfo( (String)map.get(InformationSystemMeta.HARDWARE_INFO));
				this.setUpdateBy( (String)map.get(InformationSystemMeta.UPDATE_BY));
				this.setId( (String)map.get(InformationSystemMeta.ID));
				this.setBackupInfo( (String)map.get(InformationSystemMeta.BACKUP_INFO));
				this.setDbInfo( (String)map.get(InformationSystemMeta.DB_INFO));
				this.setDiffplaceBackupInfo( (String)map.get(InformationSystemMeta.DIFFPLACE_BACKUP_INFO));
				this.setAddress( (String)map.get(InformationSystemMeta.ADDRESS));
				this.setBelongOrgId( (String)map.get(InformationSystemMeta.BELONG_ORG_ID));
				this.setProfile( (String)map.get(InformationSystemMeta.PROFILE));
				this.setBusinessContact( (String)map.get(InformationSystemMeta.BUSINESS_CONTACT));
				this.setUpdateTime( (Date)map.get(InformationSystemMeta.UPDATE_TIME));
				this.setRto( (String)map.get(InformationSystemMeta.RTO));
				this.setVersion( (Integer)map.get(InformationSystemMeta.VERSION));
				this.setLabels( (String)map.get(InformationSystemMeta.LABELS));
				this.setOnlineDate( (Date)map.get(InformationSystemMeta.ONLINE_DATE));
				this.setRpo( (String)map.get(InformationSystemMeta.RPO));
				this.setCreateBy( (String)map.get(InformationSystemMeta.CREATE_BY));
				this.setOfflineDate( (Date)map.get(InformationSystemMeta.OFFLINE_DATE));
				this.setDeleted( (Integer)map.get(InformationSystemMeta.DELETED));
				this.setOpsMethod( (String)map.get(InformationSystemMeta.OPS_METHOD));
				this.setLastdrillDate( (Date)map.get(InformationSystemMeta.LASTDRILL_DATE));
				this.setCreateTime( (Date)map.get(InformationSystemMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(InformationSystemMeta.DELETE_TIME));
				this.setGrade( (String)map.get(InformationSystemMeta.GRADE));
				this.setName( (String)map.get(InformationSystemMeta.NAME));
				this.setTenantId( (String)map.get(InformationSystemMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InformationSystemMeta.DELETE_BY));
				this.setStatus( (String)map.get(InformationSystemMeta.STATUS));
				// others
				this.setInfoSystemStatus( (DictItem)map.get(InformationSystemMeta.INFO_SYSTEM_STATUS));
				this.setInfoSystemDevMethod( (DictItem)map.get(InformationSystemMeta.INFO_SYSTEM_DEV_METHOD));
				this.setInfoSystemGrade( (DictItem)map.get(InformationSystemMeta.INFO_SYSTEM_GRADE));
				this.setBelongOrganization( (Organization)map.get(InformationSystemMeta.BELONG_ORGANIZATION));
				this.setInfoSystemOpsMethod( (DictItem)map.get(InformationSystemMeta.INFO_SYSTEM_OPS_METHOD));
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
			this.setSameplaceBacupInfo(DataParser.parse(String.class, r.getValue(InformationSystemMeta.SAMEPLACE_BACUP_INFO)));
			this.setArchMethod(DataParser.parse(String.class, r.getValue(InformationSystemMeta.ARCH_METHOD)));
			this.setNotes(DataParser.parse(String.class, r.getValue(InformationSystemMeta.NOTES)));
			this.setAppInfo(DataParser.parse(String.class, r.getValue(InformationSystemMeta.APP_INFO)));
			this.setPid(DataParser.parse(String.class, r.getValue(InformationSystemMeta.PID)));
			this.setDevMethod(DataParser.parse(String.class, r.getValue(InformationSystemMeta.DEV_METHOD)));
			this.setTechnicalContact(DataParser.parse(String.class, r.getValue(InformationSystemMeta.TECHNICAL_CONTACT)));
			this.setOsInfo(DataParser.parse(String.class, r.getValue(InformationSystemMeta.OS_INFO)));
			this.setHardwareInfo(DataParser.parse(String.class, r.getValue(InformationSystemMeta.HARDWARE_INFO)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InformationSystemMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(InformationSystemMeta.ID)));
			this.setBackupInfo(DataParser.parse(String.class, r.getValue(InformationSystemMeta.BACKUP_INFO)));
			this.setDbInfo(DataParser.parse(String.class, r.getValue(InformationSystemMeta.DB_INFO)));
			this.setDiffplaceBackupInfo(DataParser.parse(String.class, r.getValue(InformationSystemMeta.DIFFPLACE_BACKUP_INFO)));
			this.setAddress(DataParser.parse(String.class, r.getValue(InformationSystemMeta.ADDRESS)));
			this.setBelongOrgId(DataParser.parse(String.class, r.getValue(InformationSystemMeta.BELONG_ORG_ID)));
			this.setProfile(DataParser.parse(String.class, r.getValue(InformationSystemMeta.PROFILE)));
			this.setBusinessContact(DataParser.parse(String.class, r.getValue(InformationSystemMeta.BUSINESS_CONTACT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InformationSystemMeta.UPDATE_TIME)));
			this.setRto(DataParser.parse(String.class, r.getValue(InformationSystemMeta.RTO)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InformationSystemMeta.VERSION)));
			this.setLabels(DataParser.parse(String.class, r.getValue(InformationSystemMeta.LABELS)));
			this.setOnlineDate(DataParser.parse(Date.class, r.getValue(InformationSystemMeta.ONLINE_DATE)));
			this.setRpo(DataParser.parse(String.class, r.getValue(InformationSystemMeta.RPO)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InformationSystemMeta.CREATE_BY)));
			this.setOfflineDate(DataParser.parse(Date.class, r.getValue(InformationSystemMeta.OFFLINE_DATE)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InformationSystemMeta.DELETED)));
			this.setOpsMethod(DataParser.parse(String.class, r.getValue(InformationSystemMeta.OPS_METHOD)));
			this.setLastdrillDate(DataParser.parse(Date.class, r.getValue(InformationSystemMeta.LASTDRILL_DATE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InformationSystemMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InformationSystemMeta.DELETE_TIME)));
			this.setGrade(DataParser.parse(String.class, r.getValue(InformationSystemMeta.GRADE)));
			this.setName(DataParser.parse(String.class, r.getValue(InformationSystemMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InformationSystemMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InformationSystemMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(InformationSystemMeta.STATUS)));
			return true;
		} else {
			try {
				this.setSameplaceBacupInfo( (String)r.getValue(InformationSystemMeta.SAMEPLACE_BACUP_INFO));
				this.setArchMethod( (String)r.getValue(InformationSystemMeta.ARCH_METHOD));
				this.setNotes( (String)r.getValue(InformationSystemMeta.NOTES));
				this.setAppInfo( (String)r.getValue(InformationSystemMeta.APP_INFO));
				this.setPid( (String)r.getValue(InformationSystemMeta.PID));
				this.setDevMethod( (String)r.getValue(InformationSystemMeta.DEV_METHOD));
				this.setTechnicalContact( (String)r.getValue(InformationSystemMeta.TECHNICAL_CONTACT));
				this.setOsInfo( (String)r.getValue(InformationSystemMeta.OS_INFO));
				this.setHardwareInfo( (String)r.getValue(InformationSystemMeta.HARDWARE_INFO));
				this.setUpdateBy( (String)r.getValue(InformationSystemMeta.UPDATE_BY));
				this.setId( (String)r.getValue(InformationSystemMeta.ID));
				this.setBackupInfo( (String)r.getValue(InformationSystemMeta.BACKUP_INFO));
				this.setDbInfo( (String)r.getValue(InformationSystemMeta.DB_INFO));
				this.setDiffplaceBackupInfo( (String)r.getValue(InformationSystemMeta.DIFFPLACE_BACKUP_INFO));
				this.setAddress( (String)r.getValue(InformationSystemMeta.ADDRESS));
				this.setBelongOrgId( (String)r.getValue(InformationSystemMeta.BELONG_ORG_ID));
				this.setProfile( (String)r.getValue(InformationSystemMeta.PROFILE));
				this.setBusinessContact( (String)r.getValue(InformationSystemMeta.BUSINESS_CONTACT));
				this.setUpdateTime( (Date)r.getValue(InformationSystemMeta.UPDATE_TIME));
				this.setRto( (String)r.getValue(InformationSystemMeta.RTO));
				this.setVersion( (Integer)r.getValue(InformationSystemMeta.VERSION));
				this.setLabels( (String)r.getValue(InformationSystemMeta.LABELS));
				this.setOnlineDate( (Date)r.getValue(InformationSystemMeta.ONLINE_DATE));
				this.setRpo( (String)r.getValue(InformationSystemMeta.RPO));
				this.setCreateBy( (String)r.getValue(InformationSystemMeta.CREATE_BY));
				this.setOfflineDate( (Date)r.getValue(InformationSystemMeta.OFFLINE_DATE));
				this.setDeleted( (Integer)r.getValue(InformationSystemMeta.DELETED));
				this.setOpsMethod( (String)r.getValue(InformationSystemMeta.OPS_METHOD));
				this.setLastdrillDate( (Date)r.getValue(InformationSystemMeta.LASTDRILL_DATE));
				this.setCreateTime( (Date)r.getValue(InformationSystemMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(InformationSystemMeta.DELETE_TIME));
				this.setGrade( (String)r.getValue(InformationSystemMeta.GRADE));
				this.setName( (String)r.getValue(InformationSystemMeta.NAME));
				this.setTenantId( (String)r.getValue(InformationSystemMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InformationSystemMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(InformationSystemMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}