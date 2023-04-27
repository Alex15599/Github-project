package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_BACKUP_INFO;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.DbBackupInfoMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据库备份
 * <p>数据库备份 , 数据表 ops_db_backup_info 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-31 22:15:26
 * @sign 2837A8E8E5F4E2BEF8925213308DAB89
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_backup_info")
@ApiModel(description = "数据库备份 ; 数据库备份 , 数据表 ops_db_backup_info 的PO类型")
public class DbBackupInfo extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_BACKUP_INFO.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "621369753377701888")
	private String id;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库" , example = "621350881815691264")
	private String databaseId;
	
	/**
	 * UID：UID
	*/
	@ApiModelProperty(required = false,value="UID" , notes = "UID")
	private String uid;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 备份状态：备份状态
	*/
	@ApiModelProperty(required = false,value="备份状态" , notes = "备份状态" , example = "online")
	private String status;
	
	/**
	 * 备份策略：备份策略
	*/
	@ApiModelProperty(required = false,value="备份策略" , notes = "备份策略")
	private String backupStrategy;
	
	/**
	 * 备份类型：备份类型
	*/
	@ApiModelProperty(required = false,value="备份类型" , notes = "备份类型" , example = "physical")
	private String backupType;
	
	/**
	 * 备份方式：备份方式
	*/
	@ApiModelProperty(required = false,value="备份方式" , notes = "备份方式" , example = "full")
	private String backupMethod;
	
	/**
	 * 备份保留时长：备份保留时长
	*/
	@ApiModelProperty(required = false,value="备份保留时长" , notes = "备份保留时长")
	private String backupDatakeep;
	
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
	 * 备份大小：备份大小
	*/
	@ApiModelProperty(required = false,value="备份大小" , notes = "备份大小" , example = "0.00")
	private BigDecimal backupSize;
	
	/**
	 * 上次备份：上次备份
	*/
	@ApiModelProperty(required = false,value="上次备份" , notes = "上次备份")
	private Date backupTime;
	
	/**
	 * 结果内容：结果内容
	*/
	@ApiModelProperty(required = false,value="结果内容" , notes = "结果内容")
	private String backupResultCt;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private String storage;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "12")
	private String notes;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-09-11 03:41:34")
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
	@ApiModelProperty(required = false,value="是否已删除" , notes = "是否已删除" , example = "0")
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
	public DbBackupInfo setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public String getDatabaseId() {
		return databaseId;
	}
	
	/**
	 * 设置 数据库
	 * @param databaseId 数据库
	 * @return 当前对象
	*/
	public DbBackupInfo setDatabaseId(String databaseId) {
		this.databaseId=databaseId;
		return this;
	}
	
	/**
	 * 获得 UID<br>
	 * UID
	 * @return UID
	*/
	public String getUid() {
		return uid;
	}
	
	/**
	 * 设置 UID
	 * @param uid UID
	 * @return 当前对象
	*/
	public DbBackupInfo setUid(String uid) {
		this.uid=uid;
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
	public DbBackupInfo setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 备份状态<br>
	 * 备份状态
	 * @return 备份状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 备份状态
	 * @param status 备份状态
	 * @return 当前对象
	*/
	public DbBackupInfo setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 备份策略<br>
	 * 备份策略
	 * @return 备份策略
	*/
	public String getBackupStrategy() {
		return backupStrategy;
	}
	
	/**
	 * 设置 备份策略
	 * @param backupStrategy 备份策略
	 * @return 当前对象
	*/
	public DbBackupInfo setBackupStrategy(String backupStrategy) {
		this.backupStrategy=backupStrategy;
		return this;
	}
	
	/**
	 * 获得 备份类型<br>
	 * 备份类型
	 * @return 备份类型
	*/
	public String getBackupType() {
		return backupType;
	}
	
	/**
	 * 设置 备份类型
	 * @param backupType 备份类型
	 * @return 当前对象
	*/
	public DbBackupInfo setBackupType(String backupType) {
		this.backupType=backupType;
		return this;
	}
	
	/**
	 * 获得 备份方式<br>
	 * 备份方式
	 * @return 备份方式
	*/
	public String getBackupMethod() {
		return backupMethod;
	}
	
	/**
	 * 设置 备份方式
	 * @param backupMethod 备份方式
	 * @return 当前对象
	*/
	public DbBackupInfo setBackupMethod(String backupMethod) {
		this.backupMethod=backupMethod;
		return this;
	}
	
	/**
	 * 获得 备份保留时长<br>
	 * 备份保留时长
	 * @return 备份保留时长
	*/
	public String getBackupDatakeep() {
		return backupDatakeep;
	}
	
	/**
	 * 设置 备份保留时长
	 * @param backupDatakeep 备份保留时长
	 * @return 当前对象
	*/
	public DbBackupInfo setBackupDatakeep(String backupDatakeep) {
		this.backupDatakeep=backupDatakeep;
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
	public DbBackupInfo setBackupResult(String backupResult) {
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
	public DbBackupInfo setBackupSource(String backupSource) {
		this.backupSource=backupSource;
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
	public DbBackupInfo setBackupSize(BigDecimal backupSize) {
		this.backupSize=backupSize;
		return this;
	}
	
	/**
	 * 获得 上次备份<br>
	 * 上次备份
	 * @return 上次备份
	*/
	public Date getBackupTime() {
		return backupTime;
	}
	
	/**
	 * 设置 上次备份
	 * @param backupTime 上次备份
	 * @return 当前对象
	*/
	public DbBackupInfo setBackupTime(Date backupTime) {
		this.backupTime=backupTime;
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
	public DbBackupInfo setBackupResultCt(String backupResultCt) {
		this.backupResultCt=backupResultCt;
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public String getStorage() {
		return storage;
	}
	
	/**
	 * 设置 存放位置
	 * @param storage 存放位置
	 * @return 当前对象
	*/
	public DbBackupInfo setStorage(String storage) {
		this.storage=storage;
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
	public DbBackupInfo setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择
	 * @param selectedCode 选择
	 * @return 当前对象
	*/
	public DbBackupInfo setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public DbBackupInfo setCreateBy(String createBy) {
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
	public DbBackupInfo setCreateTime(Date createTime) {
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
	public DbBackupInfo setUpdateBy(String updateBy) {
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
	public DbBackupInfo setUpdateTime(Date updateTime) {
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
	public DbBackupInfo setDeleted(Integer deleted) {
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
	public DbBackupInfo setDeleted(Boolean deletedBool) {
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
	public DbBackupInfo setDeleteBy(String deleteBy) {
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
	public DbBackupInfo setDeleteTime(Date deleteTime) {
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
	public DbBackupInfo setVersion(Integer version) {
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
	public DbBackupInfo setHost(Host host) {
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
	public DbBackupInfo setDb(DbInfo db) {
		this.db=db;
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
	public DbBackupInfo setDbType(ServiceInfo dbType) {
		this.dbType=dbType;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbBackupInfo , 转换好的 DbBackupInfo 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbBackupInfo , 转换好的 PoJo 对象
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
	public DbBackupInfo clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbBackupInfo duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbBackupInfoMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbBackupInfoMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setStorage(this.getStorage());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setBackupDatakeep(this.getBackupDatakeep());
		inst.setBackupType(this.getBackupType());
		inst.setUid(this.getUid());
		inst.setBackupStrategy(this.getBackupStrategy());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setDatabaseId(this.getDatabaseId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setBackupSize(this.getBackupSize());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setBackupMethod(this.getBackupMethod());
		inst.setBackupTime(this.getBackupTime());
		inst.setBackupResultCt(this.getBackupResultCt());
		inst.setStatus(this.getStatus());
		inst.setBackupResult(this.getBackupResult());
		inst.setBackupSource(this.getBackupSource());
		if(all) {
			inst.setHost(this.getHost());
			inst.setDbType(this.getDbType());
			inst.setDb(this.getDb());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbBackupInfo clone(boolean deep) {
		return EntityContext.clone(DbBackupInfo.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbBackupInfo
	 * @param dbBackupInfoMap 包含实体信息的 Map 对象
	 * @return DbBackupInfo , 转换好的的 DbBackupInfo 对象
	*/
	@Transient
	public static DbBackupInfo createFrom(Map<String,Object> dbBackupInfoMap) {
		if(dbBackupInfoMap==null) return null;
		DbBackupInfo po = create();
		EntityContext.copyProperties(po,dbBackupInfoMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbBackupInfo
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbBackupInfo , 转换好的的 DbBackupInfo 对象
	*/
	@Transient
	public static DbBackupInfo createFrom(Object pojo) {
		if(pojo==null) return null;
		DbBackupInfo po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbBackupInfo，等同于 new
	 * @return DbBackupInfo 对象
	*/
	@Transient
	public static DbBackupInfo create() {
		return new com.dt.platform.domain.ops.meta.DbBackupInfoMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DbBackupInfoMeta.NOTES)));
			this.setStorage(DataParser.parse(String.class, map.get(DbBackupInfoMeta.STORAGE)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(DbBackupInfoMeta.SELECTED_CODE)));
			this.setBackupDatakeep(DataParser.parse(String.class, map.get(DbBackupInfoMeta.BACKUP_DATAKEEP)));
			this.setBackupType(DataParser.parse(String.class, map.get(DbBackupInfoMeta.BACKUP_TYPE)));
			this.setUid(DataParser.parse(String.class, map.get(DbBackupInfoMeta.UID)));
			this.setBackupStrategy(DataParser.parse(String.class, map.get(DbBackupInfoMeta.BACKUP_STRATEGY)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbBackupInfoMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DbBackupInfoMeta.ID)));
			this.setDatabaseId(DataParser.parse(String.class, map.get(DbBackupInfoMeta.DATABASE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbBackupInfoMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbBackupInfoMeta.VERSION)));
			this.setBackupSize(DataParser.parse(BigDecimal.class, map.get(DbBackupInfoMeta.BACKUP_SIZE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbBackupInfoMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbBackupInfoMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbBackupInfoMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbBackupInfoMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(DbBackupInfoMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbBackupInfoMeta.DELETE_BY)));
			this.setBackupMethod(DataParser.parse(String.class, map.get(DbBackupInfoMeta.BACKUP_METHOD)));
			this.setBackupTime(DataParser.parse(Date.class, map.get(DbBackupInfoMeta.BACKUP_TIME)));
			this.setBackupResultCt(DataParser.parse(String.class, map.get(DbBackupInfoMeta.BACKUP_RESULT_CT)));
			this.setStatus(DataParser.parse(String.class, map.get(DbBackupInfoMeta.STATUS)));
			this.setBackupResult(DataParser.parse(String.class, map.get(DbBackupInfoMeta.BACKUP_RESULT)));
			this.setBackupSource(DataParser.parse(String.class, map.get(DbBackupInfoMeta.BACKUP_SOURCE)));
			// others
			this.setHost(DataParser.parse(Host.class, map.get(DbBackupInfoMeta.HOST)));
			this.setDbType(DataParser.parse(ServiceInfo.class, map.get(DbBackupInfoMeta.DB_TYPE)));
			this.setDb(DataParser.parse(DbInfo.class, map.get(DbBackupInfoMeta.DB)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DbBackupInfoMeta.NOTES));
				this.setStorage( (String)map.get(DbBackupInfoMeta.STORAGE));
				this.setSelectedCode( (String)map.get(DbBackupInfoMeta.SELECTED_CODE));
				this.setBackupDatakeep( (String)map.get(DbBackupInfoMeta.BACKUP_DATAKEEP));
				this.setBackupType( (String)map.get(DbBackupInfoMeta.BACKUP_TYPE));
				this.setUid( (String)map.get(DbBackupInfoMeta.UID));
				this.setBackupStrategy( (String)map.get(DbBackupInfoMeta.BACKUP_STRATEGY));
				this.setUpdateBy( (String)map.get(DbBackupInfoMeta.UPDATE_BY));
				this.setId( (String)map.get(DbBackupInfoMeta.ID));
				this.setDatabaseId( (String)map.get(DbBackupInfoMeta.DATABASE_ID));
				this.setUpdateTime( (Date)map.get(DbBackupInfoMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(DbBackupInfoMeta.VERSION));
				this.setBackupSize( (BigDecimal)map.get(DbBackupInfoMeta.BACKUP_SIZE));
				this.setCreateBy( (String)map.get(DbBackupInfoMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DbBackupInfoMeta.DELETED));
				this.setCreateTime( (Date)map.get(DbBackupInfoMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(DbBackupInfoMeta.DELETE_TIME));
				this.setName( (String)map.get(DbBackupInfoMeta.NAME));
				this.setDeleteBy( (String)map.get(DbBackupInfoMeta.DELETE_BY));
				this.setBackupMethod( (String)map.get(DbBackupInfoMeta.BACKUP_METHOD));
				this.setBackupTime( (Date)map.get(DbBackupInfoMeta.BACKUP_TIME));
				this.setBackupResultCt( (String)map.get(DbBackupInfoMeta.BACKUP_RESULT_CT));
				this.setStatus( (String)map.get(DbBackupInfoMeta.STATUS));
				this.setBackupResult( (String)map.get(DbBackupInfoMeta.BACKUP_RESULT));
				this.setBackupSource( (String)map.get(DbBackupInfoMeta.BACKUP_SOURCE));
				// others
				this.setHost( (Host)map.get(DbBackupInfoMeta.HOST));
				this.setDbType( (ServiceInfo)map.get(DbBackupInfoMeta.DB_TYPE));
				this.setDb( (DbInfo)map.get(DbBackupInfoMeta.DB));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.NOTES)));
			this.setStorage(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.STORAGE)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.SELECTED_CODE)));
			this.setBackupDatakeep(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.BACKUP_DATAKEEP)));
			this.setBackupType(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.BACKUP_TYPE)));
			this.setUid(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.UID)));
			this.setBackupStrategy(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.BACKUP_STRATEGY)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.ID)));
			this.setDatabaseId(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.DATABASE_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbBackupInfoMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbBackupInfoMeta.VERSION)));
			this.setBackupSize(DataParser.parse(BigDecimal.class, r.getValue(DbBackupInfoMeta.BACKUP_SIZE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbBackupInfoMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbBackupInfoMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbBackupInfoMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.DELETE_BY)));
			this.setBackupMethod(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.BACKUP_METHOD)));
			this.setBackupTime(DataParser.parse(Date.class, r.getValue(DbBackupInfoMeta.BACKUP_TIME)));
			this.setBackupResultCt(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.BACKUP_RESULT_CT)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.STATUS)));
			this.setBackupResult(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.BACKUP_RESULT)));
			this.setBackupSource(DataParser.parse(String.class, r.getValue(DbBackupInfoMeta.BACKUP_SOURCE)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DbBackupInfoMeta.NOTES));
				this.setStorage( (String)r.getValue(DbBackupInfoMeta.STORAGE));
				this.setSelectedCode( (String)r.getValue(DbBackupInfoMeta.SELECTED_CODE));
				this.setBackupDatakeep( (String)r.getValue(DbBackupInfoMeta.BACKUP_DATAKEEP));
				this.setBackupType( (String)r.getValue(DbBackupInfoMeta.BACKUP_TYPE));
				this.setUid( (String)r.getValue(DbBackupInfoMeta.UID));
				this.setBackupStrategy( (String)r.getValue(DbBackupInfoMeta.BACKUP_STRATEGY));
				this.setUpdateBy( (String)r.getValue(DbBackupInfoMeta.UPDATE_BY));
				this.setId( (String)r.getValue(DbBackupInfoMeta.ID));
				this.setDatabaseId( (String)r.getValue(DbBackupInfoMeta.DATABASE_ID));
				this.setUpdateTime( (Date)r.getValue(DbBackupInfoMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(DbBackupInfoMeta.VERSION));
				this.setBackupSize( (BigDecimal)r.getValue(DbBackupInfoMeta.BACKUP_SIZE));
				this.setCreateBy( (String)r.getValue(DbBackupInfoMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DbBackupInfoMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(DbBackupInfoMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(DbBackupInfoMeta.DELETE_TIME));
				this.setName( (String)r.getValue(DbBackupInfoMeta.NAME));
				this.setDeleteBy( (String)r.getValue(DbBackupInfoMeta.DELETE_BY));
				this.setBackupMethod( (String)r.getValue(DbBackupInfoMeta.BACKUP_METHOD));
				this.setBackupTime( (Date)r.getValue(DbBackupInfoMeta.BACKUP_TIME));
				this.setBackupResultCt( (String)r.getValue(DbBackupInfoMeta.BACKUP_RESULT_CT));
				this.setStatus( (String)r.getValue(DbBackupInfoMeta.STATUS));
				this.setBackupResult( (String)r.getValue(DbBackupInfoMeta.BACKUP_RESULT));
				this.setBackupSource( (String)r.getValue(DbBackupInfoMeta.BACKUP_SOURCE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}