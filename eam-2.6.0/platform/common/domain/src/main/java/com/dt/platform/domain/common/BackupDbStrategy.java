package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_BACKUP_DB_STRATEGY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.BackupDbStrategyMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 备份策略
 * <p>备份策略 , 数据表 sys_backup_db_strategy 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-26 18:37:10
 * @sign 2F2C941E661ED24949134E7265B3B92A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_backup_db_strategy")
@ApiModel(description = "备份策略 ; 备份策略 , 数据表 sys_backup_db_strategy 的PO类型")
public class BackupDbStrategy extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_BACKUP_DB_STRATEGY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "001")
	private String id;
	
	/**
	 * 启用状态：启用状态
	*/
	@ApiModelProperty(required = false,value="启用状态" , notes = "启用状态" , example = "enable")
	private String status;
	
	/**
	 * 备份路径：备份路径
	*/
	@ApiModelProperty(required = false,value="备份路径" , notes = "备份路径" , example = "/app/app/backup/db")
	private String dataPath;
	
	/**
	 * 备份保留：备份保留
	*/
	@ApiModelProperty(required = false,value="备份保留" , notes = "备份保留")
	private Integer dataKeep;
	
	/**
	 * 备份周期：备份周期
	*/
	@ApiModelProperty(required = false,value="备份周期" , notes = "备份周期")
	private String crontab;
	
	/**
	 * 邮件：邮件
	*/
	@ApiModelProperty(required = false,value="邮件" , notes = "邮件")
	private String mail;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "每天晚上自动备份")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-01-26 10:54:30")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-01-26 11:06:54")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "5")
	private Integer version;
	
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
	public BackupDbStrategy setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 启用状态<br>
	 * 启用状态
	 * @return 启用状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 启用状态
	 * @param status 启用状态
	 * @return 当前对象
	*/
	public BackupDbStrategy setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 备份路径<br>
	 * 备份路径
	 * @return 备份路径
	*/
	public String getDataPath() {
		return dataPath;
	}
	
	/**
	 * 设置 备份路径
	 * @param dataPath 备份路径
	 * @return 当前对象
	*/
	public BackupDbStrategy setDataPath(String dataPath) {
		this.dataPath=dataPath;
		return this;
	}
	
	/**
	 * 获得 备份保留<br>
	 * 备份保留
	 * @return 备份保留
	*/
	public Integer getDataKeep() {
		return dataKeep;
	}
	
	/**
	 * 设置 备份保留
	 * @param dataKeep 备份保留
	 * @return 当前对象
	*/
	public BackupDbStrategy setDataKeep(Integer dataKeep) {
		this.dataKeep=dataKeep;
		return this;
	}
	
	/**
	 * 获得 备份周期<br>
	 * 备份周期
	 * @return 备份周期
	*/
	public String getCrontab() {
		return crontab;
	}
	
	/**
	 * 设置 备份周期
	 * @param crontab 备份周期
	 * @return 当前对象
	*/
	public BackupDbStrategy setCrontab(String crontab) {
		this.crontab=crontab;
		return this;
	}
	
	/**
	 * 获得 邮件<br>
	 * 邮件
	 * @return 邮件
	*/
	public String getMail() {
		return mail;
	}
	
	/**
	 * 设置 邮件
	 * @param mail 邮件
	 * @return 当前对象
	*/
	public BackupDbStrategy setMail(String mail) {
		this.mail=mail;
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
	public BackupDbStrategy setNotes(String notes) {
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
	public BackupDbStrategy setCreateBy(String createBy) {
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
	public BackupDbStrategy setCreateTime(Date createTime) {
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
	public BackupDbStrategy setUpdateBy(String updateBy) {
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
	public BackupDbStrategy setUpdateTime(Date updateTime) {
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
	public BackupDbStrategy setDeleted(Integer deleted) {
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
	public BackupDbStrategy setDeleted(Boolean deletedBool) {
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
	public BackupDbStrategy setDeleteBy(String deleteBy) {
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
	public BackupDbStrategy setDeleteTime(Date deleteTime) {
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
	public BackupDbStrategy setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return BackupDbStrategy , 转换好的 BackupDbStrategy 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return BackupDbStrategy , 转换好的 PoJo 对象
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
	public BackupDbStrategy clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public BackupDbStrategy duplicate(boolean all) {
		com.dt.platform.domain.common.meta.BackupDbStrategyMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.BackupDbStrategyMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setMail(this.getMail());
		inst.setCrontab(this.getCrontab());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setDataPath(this.getDataPath());
		inst.setDataKeep(this.getDataKeep());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public BackupDbStrategy clone(boolean deep) {
		return EntityContext.clone(BackupDbStrategy.class,this,deep);
	}

	/**
	 * 将 Map 转换成 BackupDbStrategy
	 * @param backupDbStrategyMap 包含实体信息的 Map 对象
	 * @return BackupDbStrategy , 转换好的的 BackupDbStrategy 对象
	*/
	@Transient
	public static BackupDbStrategy createFrom(Map<String,Object> backupDbStrategyMap) {
		if(backupDbStrategyMap==null) return null;
		BackupDbStrategy po = create();
		EntityContext.copyProperties(po,backupDbStrategyMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 BackupDbStrategy
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return BackupDbStrategy , 转换好的的 BackupDbStrategy 对象
	*/
	@Transient
	public static BackupDbStrategy createFrom(Object pojo) {
		if(pojo==null) return null;
		BackupDbStrategy po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 BackupDbStrategy，等同于 new
	 * @return BackupDbStrategy 对象
	*/
	@Transient
	public static BackupDbStrategy create() {
		return new com.dt.platform.domain.common.meta.BackupDbStrategyMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(BackupDbStrategyMeta.NOTES)));
			this.setMail(DataParser.parse(String.class, map.get(BackupDbStrategyMeta.MAIL)));
			this.setCrontab(DataParser.parse(String.class, map.get(BackupDbStrategyMeta.CRONTAB)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(BackupDbStrategyMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(BackupDbStrategyMeta.VERSION)));
			this.setDataPath(DataParser.parse(String.class, map.get(BackupDbStrategyMeta.DATA_PATH)));
			this.setDataKeep(DataParser.parse(Integer.class, map.get(BackupDbStrategyMeta.DATA_KEEP)));
			this.setCreateBy(DataParser.parse(String.class, map.get(BackupDbStrategyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(BackupDbStrategyMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(BackupDbStrategyMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(BackupDbStrategyMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(BackupDbStrategyMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(BackupDbStrategyMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(BackupDbStrategyMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(BackupDbStrategyMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(BackupDbStrategyMeta.NOTES));
				this.setMail( (String)map.get(BackupDbStrategyMeta.MAIL));
				this.setCrontab( (String)map.get(BackupDbStrategyMeta.CRONTAB));
				this.setUpdateTime( (Date)map.get(BackupDbStrategyMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(BackupDbStrategyMeta.VERSION));
				this.setDataPath( (String)map.get(BackupDbStrategyMeta.DATA_PATH));
				this.setDataKeep( (Integer)map.get(BackupDbStrategyMeta.DATA_KEEP));
				this.setCreateBy( (String)map.get(BackupDbStrategyMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(BackupDbStrategyMeta.DELETED));
				this.setCreateTime( (Date)map.get(BackupDbStrategyMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(BackupDbStrategyMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(BackupDbStrategyMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(BackupDbStrategyMeta.DELETE_BY));
				this.setId( (String)map.get(BackupDbStrategyMeta.ID));
				this.setStatus( (String)map.get(BackupDbStrategyMeta.STATUS));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(BackupDbStrategyMeta.NOTES)));
			this.setMail(DataParser.parse(String.class, r.getValue(BackupDbStrategyMeta.MAIL)));
			this.setCrontab(DataParser.parse(String.class, r.getValue(BackupDbStrategyMeta.CRONTAB)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(BackupDbStrategyMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(BackupDbStrategyMeta.VERSION)));
			this.setDataPath(DataParser.parse(String.class, r.getValue(BackupDbStrategyMeta.DATA_PATH)));
			this.setDataKeep(DataParser.parse(Integer.class, r.getValue(BackupDbStrategyMeta.DATA_KEEP)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(BackupDbStrategyMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(BackupDbStrategyMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(BackupDbStrategyMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(BackupDbStrategyMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(BackupDbStrategyMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(BackupDbStrategyMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(BackupDbStrategyMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(BackupDbStrategyMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(BackupDbStrategyMeta.NOTES));
				this.setMail( (String)r.getValue(BackupDbStrategyMeta.MAIL));
				this.setCrontab( (String)r.getValue(BackupDbStrategyMeta.CRONTAB));
				this.setUpdateTime( (Date)r.getValue(BackupDbStrategyMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(BackupDbStrategyMeta.VERSION));
				this.setDataPath( (String)r.getValue(BackupDbStrategyMeta.DATA_PATH));
				this.setDataKeep( (Integer)r.getValue(BackupDbStrategyMeta.DATA_KEEP));
				this.setCreateBy( (String)r.getValue(BackupDbStrategyMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(BackupDbStrategyMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(BackupDbStrategyMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(BackupDbStrategyMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(BackupDbStrategyMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(BackupDbStrategyMeta.DELETE_BY));
				this.setId( (String)r.getValue(BackupDbStrategyMeta.ID));
				this.setStatus( (String)r.getValue(BackupDbStrategyMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}