package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_ENV_INFO;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.DbEnvInfoMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 数据库环境
 * <p>数据库环境 , 数据表 ops_db_env_info 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-01 20:41:05
 * @sign B50C221069FBD2774BE243AB8D7D3831
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_env_info")
@ApiModel(description = "数据库环境 ; 数据库环境 , 数据表 ops_db_env_info 的PO类型")
public class DbEnvInfo extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_ENV_INFO.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "677563001003311104")
	private String id;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签" , example = "dev")
	private String label;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
	private String dbInstId;
	
	/**
	 * 数据库：数据库
	*/
	@ApiModelProperty(required = false,value="数据库" , notes = "数据库")
	private String db;
	
	/**
	 * IP：IP
	*/
	@ApiModelProperty(required = false,value="IP" , notes = "IP" , example = "192.168.1.1")
	private String ip;
	
	/**
	 * 凭证：凭证
	*/
	@ApiModelProperty(required = false,value="凭证" , notes = "凭证" , example = "12")
	private String voucher;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "1212")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-02-13 05:13:28")
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
	 * hostName：hostName
	*/
	@ApiModelProperty(required = false,value="hostName" , notes = "hostName")
	private String hostName;
	
	/**
	 * hostIp：hostIp
	*/
	@ApiModelProperty(required = false,value="hostIp" , notes = "hostIp")
	private String hostIp;
	
	/**
	 * dbInfo：dbInfo
	*/
	@ApiModelProperty(required = false,value="dbInfo" , notes = "dbInfo")
	private DbInfo dbInfo;
	
	/**
	 * dbName：dbName
	*/
	@ApiModelProperty(required = false,value="dbName" , notes = "dbName")
	private String dbName;
	
	/**
	 * ciphertextBoxData：ciphertextBoxData
	*/
	@ApiModelProperty(required = false,value="ciphertextBoxData" , notes = "ciphertextBoxData")
	private CiphertextBoxData ciphertextBoxData;
	
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
	public DbEnvInfo setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabel() {
		return label;
	}
	
	/**
	 * 设置 标签
	 * @param label 标签
	 * @return 当前对象
	*/
	public DbEnvInfo setLabel(String label) {
		this.label=label;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public String getDbInstId() {
		return dbInstId;
	}
	
	/**
	 * 设置 数据库
	 * @param dbInstId 数据库
	 * @return 当前对象
	*/
	public DbEnvInfo setDbInstId(String dbInstId) {
		this.dbInstId=dbInstId;
		return this;
	}
	
	/**
	 * 获得 数据库<br>
	 * 数据库
	 * @return 数据库
	*/
	public String getDb() {
		return db;
	}
	
	/**
	 * 设置 数据库
	 * @param db 数据库
	 * @return 当前对象
	*/
	public DbEnvInfo setDb(String db) {
		this.db=db;
		return this;
	}
	
	/**
	 * 获得 IP<br>
	 * IP
	 * @return IP
	*/
	public String getIp() {
		return ip;
	}
	
	/**
	 * 设置 IP
	 * @param ip IP
	 * @return 当前对象
	*/
	public DbEnvInfo setIp(String ip) {
		this.ip=ip;
		return this;
	}
	
	/**
	 * 获得 凭证<br>
	 * 凭证
	 * @return 凭证
	*/
	public String getVoucher() {
		return voucher;
	}
	
	/**
	 * 设置 凭证
	 * @param voucher 凭证
	 * @return 当前对象
	*/
	public DbEnvInfo setVoucher(String voucher) {
		this.voucher=voucher;
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
	public DbEnvInfo setNotes(String notes) {
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
	public DbEnvInfo setCreateBy(String createBy) {
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
	public DbEnvInfo setCreateTime(Date createTime) {
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
	public DbEnvInfo setUpdateBy(String updateBy) {
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
	public DbEnvInfo setUpdateTime(Date updateTime) {
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
	public DbEnvInfo setDeleted(Integer deleted) {
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
	public DbEnvInfo setDeleted(Boolean deletedBool) {
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
	public DbEnvInfo setDeleteBy(String deleteBy) {
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
	public DbEnvInfo setDeleteTime(Date deleteTime) {
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
	public DbEnvInfo setVersion(Integer version) {
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
	public DbEnvInfo setHost(Host host) {
		this.host=host;
		return this;
	}
	
	/**
	 * 获得 hostName<br>
	 * hostName
	 * @return hostName
	*/
	public String getHostName() {
		return hostName;
	}
	
	/**
	 * 设置 hostName
	 * @param hostName hostName
	 * @return 当前对象
	*/
	public DbEnvInfo setHostName(String hostName) {
		this.hostName=hostName;
		return this;
	}
	
	/**
	 * 获得 hostIp<br>
	 * hostIp
	 * @return hostIp
	*/
	public String getHostIp() {
		return hostIp;
	}
	
	/**
	 * 设置 hostIp
	 * @param hostIp hostIp
	 * @return 当前对象
	*/
	public DbEnvInfo setHostIp(String hostIp) {
		this.hostIp=hostIp;
		return this;
	}
	
	/**
	 * 获得 dbInfo<br>
	 * dbInfo
	 * @return dbInfo
	*/
	public DbInfo getDbInfo() {
		return dbInfo;
	}
	
	/**
	 * 设置 dbInfo
	 * @param dbInfo dbInfo
	 * @return 当前对象
	*/
	public DbEnvInfo setDbInfo(DbInfo dbInfo) {
		this.dbInfo=dbInfo;
		return this;
	}
	
	/**
	 * 获得 dbName<br>
	 * dbName
	 * @return dbName
	*/
	public String getDbName() {
		return dbName;
	}
	
	/**
	 * 设置 dbName
	 * @param dbName dbName
	 * @return 当前对象
	*/
	public DbEnvInfo setDbName(String dbName) {
		this.dbName=dbName;
		return this;
	}
	
	/**
	 * 获得 ciphertextBoxData<br>
	 * ciphertextBoxData
	 * @return ciphertextBoxData
	*/
	public CiphertextBoxData getCiphertextBoxData() {
		return ciphertextBoxData;
	}
	
	/**
	 * 设置 ciphertextBoxData
	 * @param ciphertextBoxData ciphertextBoxData
	 * @return 当前对象
	*/
	public DbEnvInfo setCiphertextBoxData(CiphertextBoxData ciphertextBoxData) {
		this.ciphertextBoxData=ciphertextBoxData;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbEnvInfo , 转换好的 DbEnvInfo 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbEnvInfo , 转换好的 PoJo 对象
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
	public DbEnvInfo clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbEnvInfo duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbEnvInfoMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbEnvInfoMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setVoucher(this.getVoucher());
		inst.setIp(this.getIp());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setLabel(this.getLabel());
		inst.setVersion(this.getVersion());
		inst.setDbInstId(this.getDbInstId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setDb(this.getDb());
		if(all) {
			inst.setDbInfo(this.getDbInfo());
			inst.setHostName(this.getHostName());
			inst.setHostIp(this.getHostIp());
			inst.setDbName(this.getDbName());
			inst.setHost(this.getHost());
			inst.setCiphertextBoxData(this.getCiphertextBoxData());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbEnvInfo clone(boolean deep) {
		return EntityContext.clone(DbEnvInfo.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbEnvInfo
	 * @param dbEnvInfoMap 包含实体信息的 Map 对象
	 * @return DbEnvInfo , 转换好的的 DbEnvInfo 对象
	*/
	@Transient
	public static DbEnvInfo createFrom(Map<String,Object> dbEnvInfoMap) {
		if(dbEnvInfoMap==null) return null;
		DbEnvInfo po = create();
		EntityContext.copyProperties(po,dbEnvInfoMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbEnvInfo
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbEnvInfo , 转换好的的 DbEnvInfo 对象
	*/
	@Transient
	public static DbEnvInfo createFrom(Object pojo) {
		if(pojo==null) return null;
		DbEnvInfo po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbEnvInfo，等同于 new
	 * @return DbEnvInfo 对象
	*/
	@Transient
	public static DbEnvInfo create() {
		return new com.dt.platform.domain.ops.meta.DbEnvInfoMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DbEnvInfoMeta.NOTES)));
			this.setVoucher(DataParser.parse(String.class, map.get(DbEnvInfoMeta.VOUCHER)));
			this.setIp(DataParser.parse(String.class, map.get(DbEnvInfoMeta.IP)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbEnvInfoMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, map.get(DbEnvInfoMeta.LABEL)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbEnvInfoMeta.VERSION)));
			this.setDbInstId(DataParser.parse(String.class, map.get(DbEnvInfoMeta.DB_INST_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbEnvInfoMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbEnvInfoMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbEnvInfoMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbEnvInfoMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbEnvInfoMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbEnvInfoMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(DbEnvInfoMeta.ID)));
			this.setDb(DataParser.parse(String.class, map.get(DbEnvInfoMeta.DB)));
			// others
			this.setDbInfo(DataParser.parse(DbInfo.class, map.get(DbEnvInfoMeta.DB_INFO)));
			this.setHostName(DataParser.parse(String.class, map.get(DbEnvInfoMeta.HOST_NAME)));
			this.setHostIp(DataParser.parse(String.class, map.get(DbEnvInfoMeta.HOST_IP)));
			this.setDbName(DataParser.parse(String.class, map.get(DbEnvInfoMeta.DB_NAME)));
			this.setHost(DataParser.parse(Host.class, map.get(DbEnvInfoMeta.HOST)));
			this.setCiphertextBoxData(DataParser.parse(CiphertextBoxData.class, map.get(DbEnvInfoMeta.CIPHERTEXT_BOX_DATA)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DbEnvInfoMeta.NOTES));
				this.setVoucher( (String)map.get(DbEnvInfoMeta.VOUCHER));
				this.setIp( (String)map.get(DbEnvInfoMeta.IP));
				this.setUpdateTime( (Date)map.get(DbEnvInfoMeta.UPDATE_TIME));
				this.setLabel( (String)map.get(DbEnvInfoMeta.LABEL));
				this.setVersion( (Integer)map.get(DbEnvInfoMeta.VERSION));
				this.setDbInstId( (String)map.get(DbEnvInfoMeta.DB_INST_ID));
				this.setCreateBy( (String)map.get(DbEnvInfoMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(DbEnvInfoMeta.DELETED));
				this.setCreateTime( (Date)map.get(DbEnvInfoMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(DbEnvInfoMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(DbEnvInfoMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(DbEnvInfoMeta.DELETE_BY));
				this.setId( (String)map.get(DbEnvInfoMeta.ID));
				this.setDb( (String)map.get(DbEnvInfoMeta.DB));
				// others
				this.setDbInfo( (DbInfo)map.get(DbEnvInfoMeta.DB_INFO));
				this.setHostName( (String)map.get(DbEnvInfoMeta.HOST_NAME));
				this.setHostIp( (String)map.get(DbEnvInfoMeta.HOST_IP));
				this.setDbName( (String)map.get(DbEnvInfoMeta.DB_NAME));
				this.setHost( (Host)map.get(DbEnvInfoMeta.HOST));
				this.setCiphertextBoxData( (CiphertextBoxData)map.get(DbEnvInfoMeta.CIPHERTEXT_BOX_DATA));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DbEnvInfoMeta.NOTES)));
			this.setVoucher(DataParser.parse(String.class, r.getValue(DbEnvInfoMeta.VOUCHER)));
			this.setIp(DataParser.parse(String.class, r.getValue(DbEnvInfoMeta.IP)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbEnvInfoMeta.UPDATE_TIME)));
			this.setLabel(DataParser.parse(String.class, r.getValue(DbEnvInfoMeta.LABEL)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbEnvInfoMeta.VERSION)));
			this.setDbInstId(DataParser.parse(String.class, r.getValue(DbEnvInfoMeta.DB_INST_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbEnvInfoMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbEnvInfoMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbEnvInfoMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbEnvInfoMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbEnvInfoMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbEnvInfoMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(DbEnvInfoMeta.ID)));
			this.setDb(DataParser.parse(String.class, r.getValue(DbEnvInfoMeta.DB)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DbEnvInfoMeta.NOTES));
				this.setVoucher( (String)r.getValue(DbEnvInfoMeta.VOUCHER));
				this.setIp( (String)r.getValue(DbEnvInfoMeta.IP));
				this.setUpdateTime( (Date)r.getValue(DbEnvInfoMeta.UPDATE_TIME));
				this.setLabel( (String)r.getValue(DbEnvInfoMeta.LABEL));
				this.setVersion( (Integer)r.getValue(DbEnvInfoMeta.VERSION));
				this.setDbInstId( (String)r.getValue(DbEnvInfoMeta.DB_INST_ID));
				this.setCreateBy( (String)r.getValue(DbEnvInfoMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(DbEnvInfoMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(DbEnvInfoMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(DbEnvInfoMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(DbEnvInfoMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(DbEnvInfoMeta.DELETE_BY));
				this.setId( (String)r.getValue(DbEnvInfoMeta.ID));
				this.setDb( (String)r.getValue(DbEnvInfoMeta.DB));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}