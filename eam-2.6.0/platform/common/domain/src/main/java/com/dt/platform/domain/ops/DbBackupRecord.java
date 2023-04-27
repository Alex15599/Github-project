package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_BACKUP_RECORD;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 备份记录
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-12 16:56:55
 * @sign 378F4439B671FF9307F8E2A3234389F7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_backup_record")
public class DbBackupRecord extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_BACKUP_RECORD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
	private String dbId;
	
	/**
	 * 数据备份：数据备份
	*/
	@ApiModelProperty(required = false,value="数据备份" , notes = "数据备份")
	private String dbBkId;
	
	/**
	 * 数据库名称：数据库名称
	*/
	@ApiModelProperty(required = false,value="数据库名称" , notes = "数据库名称")
	private String dbName;
	
	/**
	 * 备份结果：备份结果
	*/
	@ApiModelProperty(required = false,value="备份结果" , notes = "备份结果")
	private String backupResult;
	
	/**
	 * 备份来源：备份来源
	*/
	@ApiModelProperty(required = false,value="备份来源" , notes = "备份来源")
	private String backupSource;
	
	/**
	 * 结果内容：结果内容
	*/
	@ApiModelProperty(required = false,value="结果内容" , notes = "结果内容")
	private String backupResultCt;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date backupStime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Date backupEtime;
	
	/**
	 * 备份大小：备份大小
	*/
	@ApiModelProperty(required = false,value="备份大小" , notes = "备份大小")
	private BigDecimal backupSize;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
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
	@ApiModelProperty(required = false,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
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
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * host：host
	*/
	@ApiModelProperty(required = false,value="host" , notes = "host")
	private Host host;
	
	/**
	 * db：db
	*/
	@ApiModelProperty(required = false,value="db" , notes = "db")
	private DbInfo db;
	
	/**
	 * backupInfo：backupInfo
	*/
	@ApiModelProperty(required = false,value="backupInfo" , notes = "backupInfo")
	private DbBackupInfo backupInfo;
	
	/**
	 * dbType：dbType
	*/
	@ApiModelProperty(required = false,value="dbType" , notes = "dbType")
	private ServiceInfo dbType;
	
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
	public DbBackupRecord setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public String getDbId() {
		return dbId;
	}
	
	/**
	 * 设置 数据库
	 * @param dbId 数据库
	 * @return 当前对象
	*/
	public DbBackupRecord setDbId(String dbId) {
		this.dbId=dbId;
		return this;
	}
	
	/**
	 * 获得 数据备份<br>
	 * 数据备份
	 * @return 数据备份
	*/
	public String getDbBkId() {
		return dbBkId;
	}
	
	/**
	 * 设置 数据备份
	 * @param dbBkId 数据备份
	 * @return 当前对象
	*/
	public DbBackupRecord setDbBkId(String dbBkId) {
		this.dbBkId=dbBkId;
		return this;
	}
	
	/**
	 * 获得 数据库名称<br>
	 * 数据库名称
	 * @return 数据库名称
	*/
	public String getDbName() {
		return dbName;
	}
	
	/**
	 * 设置 数据库名称
	 * @param dbName 数据库名称
	 * @return 当前对象
	*/
	public DbBackupRecord setDbName(String dbName) {
		this.dbName=dbName;
		return this;
	}
	
	/**
	 * 获得 备份结果<br>
	 * 备份结果
	 * @return 备份结果
	*/
	public String getBackupResult() {
		return backupResult;
	}
	
	/**
	 * 设置 备份结果
	 * @param backupResult 备份结果
	 * @return 当前对象
	*/
	public DbBackupRecord setBackupResult(String backupResult) {
		this.backupResult=backupResult;
		return this;
	}
	
	/**
	 * 获得 备份来源<br>
	 * 备份来源
	 * @return 备份来源
	*/
	public String getBackupSource() {
		return backupSource;
	}
	
	/**
	 * 设置 备份来源
	 * @param backupSource 备份来源
	 * @return 当前对象
	*/
	public DbBackupRecord setBackupSource(String backupSource) {
		this.backupSource=backupSource;
		return this;
	}
	
	/**
	 * 获得 结果内容<br>
	 * 结果内容
	 * @return 结果内容
	*/
	public String getBackupResultCt() {
		return backupResultCt;
	}
	
	/**
	 * 设置 结果内容
	 * @param backupResultCt 结果内容
	 * @return 当前对象
	*/
	public DbBackupRecord setBackupResultCt(String backupResultCt) {
		this.backupResultCt=backupResultCt;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getBackupStime() {
		return backupStime;
	}
	
	/**
	 * 设置 开始时间
	 * @param backupStime 开始时间
	 * @return 当前对象
	*/
	public DbBackupRecord setBackupStime(Date backupStime) {
		this.backupStime=backupStime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getBackupEtime() {
		return backupEtime;
	}
	
	/**
	 * 设置 结束时间
	 * @param backupEtime 结束时间
	 * @return 当前对象
	*/
	public DbBackupRecord setBackupEtime(Date backupEtime) {
		this.backupEtime=backupEtime;
		return this;
	}
	
	/**
	 * 获得 备份大小<br>
	 * 备份大小
	 * @return 备份大小
	*/
	public BigDecimal getBackupSize() {
		return backupSize;
	}
	
	/**
	 * 设置 备份大小
	 * @param backupSize 备份大小
	 * @return 当前对象
	*/
	public DbBackupRecord setBackupSize(BigDecimal backupSize) {
		this.backupSize=backupSize;
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
	public DbBackupRecord setNotes(String notes) {
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
	public DbBackupRecord setCreateBy(String createBy) {
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
	public DbBackupRecord setCreateTime(Date createTime) {
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
	public DbBackupRecord setUpdateBy(String updateBy) {
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
	public DbBackupRecord setUpdateTime(Date updateTime) {
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
	public DbBackupRecord setDeleted(Integer deleted) {
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
	public DbBackupRecord setDeleted(Boolean deletedBool) {
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
	public DbBackupRecord setDeleteBy(String deleteBy) {
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
	public DbBackupRecord setDeleteTime(Date deleteTime) {
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
	public DbBackupRecord setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 host<br>
	 * host
	 * @return host
	*/
	public Host getHost() {
		return host;
	}
	
	/**
	 * 设置 host
	 * @param host host
	 * @return 当前对象
	*/
	public DbBackupRecord setHost(Host host) {
		this.host=host;
		return this;
	}
	
	/**
	 * 获得 db<br>
	 * db
	 * @return db
	*/
	public DbInfo getDb() {
		return db;
	}
	
	/**
	 * 设置 db
	 * @param db db
	 * @return 当前对象
	*/
	public DbBackupRecord setDb(DbInfo db) {
		this.db=db;
		return this;
	}
	
	/**
	 * 获得 backupInfo<br>
	 * backupInfo
	 * @return backupInfo
	*/
	public DbBackupInfo getBackupInfo() {
		return backupInfo;
	}
	
	/**
	 * 设置 backupInfo
	 * @param backupInfo backupInfo
	 * @return 当前对象
	*/
	public DbBackupRecord setBackupInfo(DbBackupInfo backupInfo) {
		this.backupInfo=backupInfo;
		return this;
	}
	
	/**
	 * 获得 dbType<br>
	 * dbType
	 * @return dbType
	*/
	public ServiceInfo getDbType() {
		return dbType;
	}
	
	/**
	 * 设置 dbType
	 * @param dbType dbType
	 * @return 当前对象
	*/
	public DbBackupRecord setDbType(ServiceInfo dbType) {
		this.dbType=dbType;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbBackupRecord , 转换好的 DbBackupRecord 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbBackupRecord , 转换好的 PoJo 对象
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
	public DbBackupRecord clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbBackupRecord duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbBackupRecordMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbBackupRecordMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setDbName(this.getDbName());
		inst.setBackupStime(this.getBackupStime());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setDbBkId(this.getDbBkId());
		inst.setVersion(this.getVersion());
		inst.setBackupSize(this.getBackupSize());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDbId(this.getDbId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setBackupResultCt(this.getBackupResultCt());
		inst.setBackupResult(this.getBackupResult());
		inst.setBackupSource(this.getBackupSource());
		inst.setBackupEtime(this.getBackupEtime());
		if(all) {
			inst.setHost(this.getHost());
			inst.setDbType(this.getDbType());
			inst.setDb(this.getDb());
			inst.setBackupInfo(this.getBackupInfo());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbBackupRecord clone(boolean deep) {
		return EntityContext.clone(DbBackupRecord.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbBackupRecord
	 * @param dbBackupRecordMap 包含实体信息的 Map 对象
	 * @return DbBackupRecord , 转换好的的 DbBackupRecord 对象
	*/
	@Transient
	public static DbBackupRecord createFrom(Map<String,Object> dbBackupRecordMap) {
		if(dbBackupRecordMap==null) return null;
		DbBackupRecord po = create();
		EntityContext.copyProperties(po,dbBackupRecordMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbBackupRecord
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbBackupRecord , 转换好的的 DbBackupRecord 对象
	*/
	@Transient
	public static DbBackupRecord createFrom(Object pojo) {
		if(pojo==null) return null;
		DbBackupRecord po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbBackupRecord，等同于 new
	 * @return DbBackupRecord 对象
	*/
	@Transient
	public static DbBackupRecord create() {
		return new com.dt.platform.domain.ops.meta.DbBackupRecordMeta.$$proxy$$();
	}
}