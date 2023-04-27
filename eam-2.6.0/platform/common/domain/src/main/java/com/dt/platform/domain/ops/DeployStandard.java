package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DEPLOY_STANDARD;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.DeployStandardMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 部署标准
 * <p>部署标准 , 数据表 ops_deploy_standard 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-03 09:20:27
 * @sign 3E3431D39D801242F23A072336914039
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_deploy_standard")
@ApiModel(description = "部署标准 ; 部署标准 , 数据表 ops_deploy_standard 的PO类型")
public class DeployStandard extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DEPLOY_STANDARD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "640473848730353664")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "Mysql数据库")
	private String name;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String typeId;
	
	/**
	 * 用户标准：用户标准
	*/
	@ApiModelProperty(required = false,value="用户标准" , notes = "用户标准" , example = "操作系统用户 mysql  数据库用户 管理员:root 应用:app")
	private String userContent;
	
	/**
	 * 目录标准：目录标准
	*/
	@ApiModelProperty(required = false,value="目录标准" , notes = "目录标准" , example = "mysql安装目录 /db  mysql备份目录 /dbbackup  ")
	private String dirContent;
	
	/**
	 * 部署标准：部署标准
	*/
	@ApiModelProperty(required = false,value="部署标准" , notes = "部署标准")
	private String deployContent;
	
	/**
	 * 实例标准：实例标准
	*/
	@ApiModelProperty(required = false,value="实例标准" , notes = "实例标准")
	private String createDbContent;
	
	/**
	 * 日常维护：日常维护
	*/
	@ApiModelProperty(required = false,value="日常维护" , notes = "日常维护")
	private String maintenanceContent;
	
	/**
	 * 备份脚本：备份脚本
	*/
	@ApiModelProperty(required = false,value="备份脚本" , notes = "备份脚本")
	private String backupScript;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = false,value="版本" , notes = "版本" , example = "1.0")
	private String releaseVersion;
	
	/**
	 * 附件人：附件人
	*/
	@ApiModelProperty(required = false,value="附件人" , notes = "附件人")
	private String attachId;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-11-03 08:54:25")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-11-03 09:11:08")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "3")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
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
	public DeployStandard setId(String id) {
		this.id=id;
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
	public DeployStandard setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getTypeId() {
		return typeId;
	}
	
	/**
	 * 设置 类型
	 * @param typeId 类型
	 * @return 当前对象
	*/
	public DeployStandard setTypeId(String typeId) {
		this.typeId=typeId;
		return this;
	}
	
	/**
	 * 获得 用户标准<br>
	 * 用户标准
	 * @return 用户标准
	*/
	public String getUserContent() {
		return userContent;
	}
	
	/**
	 * 设置 用户标准
	 * @param userContent 用户标准
	 * @return 当前对象
	*/
	public DeployStandard setUserContent(String userContent) {
		this.userContent=userContent;
		return this;
	}
	
	/**
	 * 获得 目录标准<br>
	 * 目录标准
	 * @return 目录标准
	*/
	public String getDirContent() {
		return dirContent;
	}
	
	/**
	 * 设置 目录标准
	 * @param dirContent 目录标准
	 * @return 当前对象
	*/
	public DeployStandard setDirContent(String dirContent) {
		this.dirContent=dirContent;
		return this;
	}
	
	/**
	 * 获得 部署标准<br>
	 * 部署标准
	 * @return 部署标准
	*/
	public String getDeployContent() {
		return deployContent;
	}
	
	/**
	 * 设置 部署标准
	 * @param deployContent 部署标准
	 * @return 当前对象
	*/
	public DeployStandard setDeployContent(String deployContent) {
		this.deployContent=deployContent;
		return this;
	}
	
	/**
	 * 获得 实例标准<br>
	 * 实例标准
	 * @return 实例标准
	*/
	public String getCreateDbContent() {
		return createDbContent;
	}
	
	/**
	 * 设置 实例标准
	 * @param createDbContent 实例标准
	 * @return 当前对象
	*/
	public DeployStandard setCreateDbContent(String createDbContent) {
		this.createDbContent=createDbContent;
		return this;
	}
	
	/**
	 * 获得 日常维护<br>
	 * 日常维护
	 * @return 日常维护
	*/
	public String getMaintenanceContent() {
		return maintenanceContent;
	}
	
	/**
	 * 设置 日常维护
	 * @param maintenanceContent 日常维护
	 * @return 当前对象
	*/
	public DeployStandard setMaintenanceContent(String maintenanceContent) {
		this.maintenanceContent=maintenanceContent;
		return this;
	}
	
	/**
	 * 获得 备份脚本<br>
	 * 备份脚本
	 * @return 备份脚本
	*/
	public String getBackupScript() {
		return backupScript;
	}
	
	/**
	 * 设置 备份脚本
	 * @param backupScript 备份脚本
	 * @return 当前对象
	*/
	public DeployStandard setBackupScript(String backupScript) {
		this.backupScript=backupScript;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public String getReleaseVersion() {
		return releaseVersion;
	}
	
	/**
	 * 设置 版本
	 * @param releaseVersion 版本
	 * @return 当前对象
	*/
	public DeployStandard setReleaseVersion(String releaseVersion) {
		this.releaseVersion=releaseVersion;
		return this;
	}
	
	/**
	 * 获得 附件人<br>
	 * 附件人
	 * @return 附件人
	*/
	public String getAttachId() {
		return attachId;
	}
	
	/**
	 * 设置 附件人
	 * @param attachId 附件人
	 * @return 当前对象
	*/
	public DeployStandard setAttachId(String attachId) {
		this.attachId=attachId;
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
	public DeployStandard setNotes(String notes) {
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
	public DeployStandard setCreateBy(String createBy) {
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
	public DeployStandard setCreateTime(Date createTime) {
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
	public DeployStandard setUpdateBy(String updateBy) {
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
	public DeployStandard setUpdateTime(Date updateTime) {
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
	public DeployStandard setDeleted(Integer deleted) {
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
	public DeployStandard setDeleted(Boolean deletedBool) {
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
	public DeployStandard setDeleteBy(String deleteBy) {
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
	public DeployStandard setDeleteTime(Date deleteTime) {
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
	public DeployStandard setVersion(Integer version) {
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
	public DeployStandard setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DeployStandard , 转换好的 DeployStandard 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DeployStandard , 转换好的 PoJo 对象
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
	public DeployStandard clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DeployStandard duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DeployStandardMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DeployStandardMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setReleaseVersion(this.getReleaseVersion());
		inst.setMaintenanceContent(this.getMaintenanceContent());
		inst.setDeployContent(this.getDeployContent());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateDbContent(this.getCreateDbContent());
		inst.setBackupScript(this.getBackupScript());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setUserContent(this.getUserContent());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setTypeId(this.getTypeId());
		inst.setId(this.getId());
		inst.setDirContent(this.getDirContent());
		inst.setAttachId(this.getAttachId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DeployStandard clone(boolean deep) {
		return EntityContext.clone(DeployStandard.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DeployStandard
	 * @param deployStandardMap 包含实体信息的 Map 对象
	 * @return DeployStandard , 转换好的的 DeployStandard 对象
	*/
	@Transient
	public static DeployStandard createFrom(Map<String,Object> deployStandardMap) {
		if(deployStandardMap==null) return null;
		DeployStandard po = create();
		EntityContext.copyProperties(po,deployStandardMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DeployStandard
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DeployStandard , 转换好的的 DeployStandard 对象
	*/
	@Transient
	public static DeployStandard createFrom(Object pojo) {
		if(pojo==null) return null;
		DeployStandard po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DeployStandard，等同于 new
	 * @return DeployStandard 对象
	*/
	@Transient
	public static DeployStandard create() {
		return new com.dt.platform.domain.ops.meta.DeployStandardMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DeployStandardMeta.NOTES)));
			this.setReleaseVersion(DataParser.parse(String.class, map.get(DeployStandardMeta.RELEASE_VERSION)));
			this.setMaintenanceContent(DataParser.parse(String.class, map.get(DeployStandardMeta.MAINTENANCE_CONTENT)));
			this.setDeployContent(DataParser.parse(String.class, map.get(DeployStandardMeta.DEPLOY_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DeployStandardMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DeployStandardMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DeployStandardMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DeployStandardMeta.DELETED)));
			this.setCreateDbContent(DataParser.parse(String.class, map.get(DeployStandardMeta.CREATE_DB_CONTENT)));
			this.setBackupScript(DataParser.parse(String.class, map.get(DeployStandardMeta.BACKUP_SCRIPT)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DeployStandardMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DeployStandardMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DeployStandardMeta.DELETE_TIME)));
			this.setUserContent(DataParser.parse(String.class, map.get(DeployStandardMeta.USER_CONTENT)));
			this.setName(DataParser.parse(String.class, map.get(DeployStandardMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(DeployStandardMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DeployStandardMeta.DELETE_BY)));
			this.setTypeId(DataParser.parse(String.class, map.get(DeployStandardMeta.TYPE_ID)));
			this.setId(DataParser.parse(String.class, map.get(DeployStandardMeta.ID)));
			this.setDirContent(DataParser.parse(String.class, map.get(DeployStandardMeta.DIR_CONTENT)));
			this.setAttachId(DataParser.parse(String.class, map.get(DeployStandardMeta.ATTACH_ID)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DeployStandardMeta.NOTES));
				this.setReleaseVersion( (String)map.get(DeployStandardMeta.RELEASE_VERSION));
				this.setMaintenanceContent( (String)map.get(DeployStandardMeta.MAINTENANCE_CONTENT));
				this.setDeployContent( (String)map.get(DeployStandardMeta.DEPLOY_CONTENT));
				this.setUpdateTime( (Date)map.get(DeployStandardMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(DeployStandardMeta.VERSION));
				this.setCreateBy( (String)map.get(DeployStandardMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DeployStandardMeta.DELETED));
				this.setCreateDbContent( (String)map.get(DeployStandardMeta.CREATE_DB_CONTENT));
				this.setBackupScript( (String)map.get(DeployStandardMeta.BACKUP_SCRIPT));
				this.setCreateTime( (Date)map.get(DeployStandardMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DeployStandardMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DeployStandardMeta.DELETE_TIME));
				this.setUserContent( (String)map.get(DeployStandardMeta.USER_CONTENT));
				this.setName( (String)map.get(DeployStandardMeta.NAME));
				this.setTenantId( (String)map.get(DeployStandardMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(DeployStandardMeta.DELETE_BY));
				this.setTypeId( (String)map.get(DeployStandardMeta.TYPE_ID));
				this.setId( (String)map.get(DeployStandardMeta.ID));
				this.setDirContent( (String)map.get(DeployStandardMeta.DIR_CONTENT));
				this.setAttachId( (String)map.get(DeployStandardMeta.ATTACH_ID));
				// others
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DeployStandardMeta.NOTES)));
			this.setReleaseVersion(DataParser.parse(String.class, r.getValue(DeployStandardMeta.RELEASE_VERSION)));
			this.setMaintenanceContent(DataParser.parse(String.class, r.getValue(DeployStandardMeta.MAINTENANCE_CONTENT)));
			this.setDeployContent(DataParser.parse(String.class, r.getValue(DeployStandardMeta.DEPLOY_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DeployStandardMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DeployStandardMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DeployStandardMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DeployStandardMeta.DELETED)));
			this.setCreateDbContent(DataParser.parse(String.class, r.getValue(DeployStandardMeta.CREATE_DB_CONTENT)));
			this.setBackupScript(DataParser.parse(String.class, r.getValue(DeployStandardMeta.BACKUP_SCRIPT)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DeployStandardMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DeployStandardMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DeployStandardMeta.DELETE_TIME)));
			this.setUserContent(DataParser.parse(String.class, r.getValue(DeployStandardMeta.USER_CONTENT)));
			this.setName(DataParser.parse(String.class, r.getValue(DeployStandardMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(DeployStandardMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DeployStandardMeta.DELETE_BY)));
			this.setTypeId(DataParser.parse(String.class, r.getValue(DeployStandardMeta.TYPE_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(DeployStandardMeta.ID)));
			this.setDirContent(DataParser.parse(String.class, r.getValue(DeployStandardMeta.DIR_CONTENT)));
			this.setAttachId(DataParser.parse(String.class, r.getValue(DeployStandardMeta.ATTACH_ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DeployStandardMeta.NOTES));
				this.setReleaseVersion( (String)r.getValue(DeployStandardMeta.RELEASE_VERSION));
				this.setMaintenanceContent( (String)r.getValue(DeployStandardMeta.MAINTENANCE_CONTENT));
				this.setDeployContent( (String)r.getValue(DeployStandardMeta.DEPLOY_CONTENT));
				this.setUpdateTime( (Date)r.getValue(DeployStandardMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(DeployStandardMeta.VERSION));
				this.setCreateBy( (String)r.getValue(DeployStandardMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DeployStandardMeta.DELETED));
				this.setCreateDbContent( (String)r.getValue(DeployStandardMeta.CREATE_DB_CONTENT));
				this.setBackupScript( (String)r.getValue(DeployStandardMeta.BACKUP_SCRIPT));
				this.setCreateTime( (Date)r.getValue(DeployStandardMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DeployStandardMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DeployStandardMeta.DELETE_TIME));
				this.setUserContent( (String)r.getValue(DeployStandardMeta.USER_CONTENT));
				this.setName( (String)r.getValue(DeployStandardMeta.NAME));
				this.setTenantId( (String)r.getValue(DeployStandardMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(DeployStandardMeta.DELETE_BY));
				this.setTypeId( (String)r.getValue(DeployStandardMeta.TYPE_ID));
				this.setId( (String)r.getValue(DeployStandardMeta.ID));
				this.setDirContent( (String)r.getValue(DeployStandardMeta.DIR_CONTENT));
				this.setAttachId( (String)r.getValue(DeployStandardMeta.ATTACH_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}