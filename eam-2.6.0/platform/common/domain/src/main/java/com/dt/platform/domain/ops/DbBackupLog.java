package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_DB_BACKUP_LOG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.DbBackupLogMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 备份日志
 * <p>备份日志 , 数据表 ops_db_backup_log 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-31 23:12:44
 * @sign ED0A2147E506B4059E040CCF26F0F0E9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_db_backup_log")
@ApiModel(description = "备份日志 ; 备份日志 , 数据表 ops_db_backup_log 的PO类型")
public class DbBackupLog extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_DB_BACKUP_LOG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "2")
	private String id;
	
	/**
	 * UID：UID
	*/
	@ApiModelProperty(required = false,value="UID" , notes = "UID" , example = "aaaa")
	private String uid;
	
	/**
	 * 数据库实例：数据库实例
	*/
	@ApiModelProperty(required = false,value="数据库实例" , notes = "数据库实例" , example = "672922128638541824")
	private String dbId;
	
	/**
	 * IP：IP
	*/
	@ApiModelProperty(required = false,value="IP" , notes = "IP" , example = "192.168.1.1")
	private String ip;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "12")
	private String dbName;
	
	/**
	 * 动作：动作
	*/
	@ApiModelProperty(required = false,value="动作" , notes = "动作" , example = "finish")
	private String action;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "success")
	private String status;
	
	/**
	 * 方式：方式
	*/
	@ApiModelProperty(required = false,value="方式" , notes = "方式" , example = "local")
	private String method;
	
	/**
	 * 结果：结果
	*/
	@ApiModelProperty(required = false,value="结果" , notes = "结果" , example = "none")
	private String result;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2023-01-02 02:00:00")
	private Date stime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间" , example = "2023-01-02 02:00:00")
	private Date etime;
	
	/**
	 * 大小：大小
	*/
	@ApiModelProperty(required = false,value="大小" , notes = "大小" , example = "124.00")
	private BigDecimal size;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间" , example = "2023-01-02 02:00:00")
	private Date recordTime;
	
	/**
	 * 原始数据：原始数据
	*/
	@ApiModelProperty(required = false,value="原始数据" , notes = "原始数据" , example = "2023-01-02 02:00:00|method=local,uid=aaaa,action=finish,status=success,aliasname=123,dbname=12,ip=192.168.1.1,size=124,result=no...")
	private String source;
	
	/**
	 * 处理状态：处理状态
	*/
	@ApiModelProperty(required = false,value="处理状态" , notes = "处理状态" , example = "not_processed")
	private String processed;
	
	/**
	 * 处理结果：处理结果
	*/
	@ApiModelProperty(required = false,value="处理结果" , notes = "处理结果" , example = "处理完成")
	private String processResult;
	
	/**
	 * 处理时间：处理时间
	*/
	@ApiModelProperty(required = false,value="处理时间" , notes = "处理时间" , example = "2023-01-31 10:14:17")
	private Date lastProcessTime;
	
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
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-01-31 11:11:45")
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
	public DbBackupLog setId(String id) {
		this.id=id;
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
	public DbBackupLog setUid(String uid) {
		this.uid=uid;
		return this;
	}
	
	/**
	 * 获得 数据库实例<br>
	 * 数据库实例
	 * @return 数据库实例
	*/
	public String getDbId() {
		return dbId;
	}
	
	/**
	 * 设置 数据库实例
	 * @param dbId 数据库实例
	 * @return 当前对象
	*/
	public DbBackupLog setDbId(String dbId) {
		this.dbId=dbId;
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
	public DbBackupLog setIp(String ip) {
		this.ip=ip;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getDbName() {
		return dbName;
	}
	
	/**
	 * 设置 名称
	 * @param dbName 名称
	 * @return 当前对象
	*/
	public DbBackupLog setDbName(String dbName) {
		this.dbName=dbName;
		return this;
	}
	
	/**
	 * 获得 动作<br>
	 * 动作
	 * @return 动作
	*/
	public String getAction() {
		return action;
	}
	
	/**
	 * 设置 动作
	 * @param action 动作
	 * @return 当前对象
	*/
	public DbBackupLog setAction(String action) {
		this.action=action;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public DbBackupLog setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 方式<br>
	 * 方式
	 * @return 方式
	*/
	public String getMethod() {
		return method;
	}
	
	/**
	 * 设置 方式
	 * @param method 方式
	 * @return 当前对象
	*/
	public DbBackupLog setMethod(String method) {
		this.method=method;
		return this;
	}
	
	/**
	 * 获得 结果<br>
	 * 结果
	 * @return 结果
	*/
	public String getResult() {
		return result;
	}
	
	/**
	 * 设置 结果
	 * @param result 结果
	 * @return 当前对象
	*/
	public DbBackupLog setResult(String result) {
		this.result=result;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStime() {
		return stime;
	}
	
	/**
	 * 设置 开始时间
	 * @param stime 开始时间
	 * @return 当前对象
	*/
	public DbBackupLog setStime(Date stime) {
		this.stime=stime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getEtime() {
		return etime;
	}
	
	/**
	 * 设置 结束时间
	 * @param etime 结束时间
	 * @return 当前对象
	*/
	public DbBackupLog setEtime(Date etime) {
		this.etime=etime;
		return this;
	}
	
	/**
	 * 获得 大小<br>
	 * 大小
	 * @return 大小
	*/
	public BigDecimal getSize() {
		return size;
	}
	
	/**
	 * 设置 大小
	 * @param size 大小
	 * @return 当前对象
	*/
	public DbBackupLog setSize(BigDecimal size) {
		this.size=size;
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
	public DbBackupLog setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRecordTime() {
		return recordTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param recordTime 记录时间
	 * @return 当前对象
	*/
	public DbBackupLog setRecordTime(Date recordTime) {
		this.recordTime=recordTime;
		return this;
	}
	
	/**
	 * 获得 原始数据<br>
	 * 原始数据
	 * @return 原始数据
	*/
	public String getSource() {
		return source;
	}
	
	/**
	 * 设置 原始数据
	 * @param source 原始数据
	 * @return 当前对象
	*/
	public DbBackupLog setSource(String source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 处理状态<br>
	 * 处理状态
	 * @return 处理状态
	*/
	public String getProcessed() {
		return processed;
	}
	
	/**
	 * 设置 处理状态
	 * @param processed 处理状态
	 * @return 当前对象
	*/
	public DbBackupLog setProcessed(String processed) {
		this.processed=processed;
		return this;
	}
	
	/**
	 * 获得 处理结果<br>
	 * 处理结果
	 * @return 处理结果
	*/
	public String getProcessResult() {
		return processResult;
	}
	
	/**
	 * 设置 处理结果
	 * @param processResult 处理结果
	 * @return 当前对象
	*/
	public DbBackupLog setProcessResult(String processResult) {
		this.processResult=processResult;
		return this;
	}
	
	/**
	 * 获得 处理时间<br>
	 * 处理时间
	 * @return 处理时间
	*/
	public Date getLastProcessTime() {
		return lastProcessTime;
	}
	
	/**
	 * 设置 处理时间
	 * @param lastProcessTime 处理时间
	 * @return 当前对象
	*/
	public DbBackupLog setLastProcessTime(Date lastProcessTime) {
		this.lastProcessTime=lastProcessTime;
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
	public DbBackupLog setCreateBy(String createBy) {
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
	public DbBackupLog setCreateTime(Date createTime) {
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
	public DbBackupLog setUpdateBy(String updateBy) {
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
	public DbBackupLog setUpdateTime(Date updateTime) {
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
	public DbBackupLog setDeleted(Integer deleted) {
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
	public DbBackupLog setDeleted(Boolean deletedBool) {
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
	public DbBackupLog setDeleteBy(String deleteBy) {
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
	public DbBackupLog setDeleteTime(Date deleteTime) {
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
	public DbBackupLog setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return DbBackupLog , 转换好的 DbBackupLog 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return DbBackupLog , 转换好的 PoJo 对象
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
	public DbBackupLog clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public DbBackupLog duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.DbBackupLogMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.DbBackupLogMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setDbName(this.getDbName());
		inst.setStime(this.getStime());
		inst.setSource(this.getSource());
		inst.setResult(this.getResult());
		inst.setUid(this.getUid());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setLastProcessTime(this.getLastProcessTime());
		inst.setDbId(this.getDbId());
		inst.setAction(this.getAction());
		inst.setId(this.getId());
		inst.setMethod(this.getMethod());
		inst.setIp(this.getIp());
		inst.setProcessResult(this.getProcessResult());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setProcessed(this.getProcessed());
		inst.setCreateBy(this.getCreateBy());
		inst.setRecordTime(this.getRecordTime());
		inst.setDeleted(this.getDeleted());
		inst.setSize(this.getSize());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setEtime(this.getEtime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public DbBackupLog clone(boolean deep) {
		return EntityContext.clone(DbBackupLog.class,this,deep);
	}

	/**
	 * 将 Map 转换成 DbBackupLog
	 * @param dbBackupLogMap 包含实体信息的 Map 对象
	 * @return DbBackupLog , 转换好的的 DbBackupLog 对象
	*/
	@Transient
	public static DbBackupLog createFrom(Map<String,Object> dbBackupLogMap) {
		if(dbBackupLogMap==null) return null;
		DbBackupLog po = create();
		EntityContext.copyProperties(po,dbBackupLogMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 DbBackupLog
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return DbBackupLog , 转换好的的 DbBackupLog 对象
	*/
	@Transient
	public static DbBackupLog createFrom(Object pojo) {
		if(pojo==null) return null;
		DbBackupLog po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 DbBackupLog，等同于 new
	 * @return DbBackupLog 对象
	*/
	@Transient
	public static DbBackupLog create() {
		return new com.dt.platform.domain.ops.meta.DbBackupLogMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(DbBackupLogMeta.NOTES)));
			this.setDbName(DataParser.parse(String.class, map.get(DbBackupLogMeta.DB_NAME)));
			this.setStime(DataParser.parse(Date.class, map.get(DbBackupLogMeta.STIME)));
			this.setSource(DataParser.parse(String.class, map.get(DbBackupLogMeta.SOURCE)));
			this.setResult(DataParser.parse(String.class, map.get(DbBackupLogMeta.RESULT)));
			this.setUid(DataParser.parse(String.class, map.get(DbBackupLogMeta.UID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(DbBackupLogMeta.UPDATE_BY)));
			this.setLastProcessTime(DataParser.parse(Date.class, map.get(DbBackupLogMeta.LAST_PROCESS_TIME)));
			this.setDbId(DataParser.parse(String.class, map.get(DbBackupLogMeta.DB_ID)));
			this.setAction(DataParser.parse(String.class, map.get(DbBackupLogMeta.ACTION)));
			this.setId(DataParser.parse(String.class, map.get(DbBackupLogMeta.ID)));
			this.setMethod(DataParser.parse(String.class, map.get(DbBackupLogMeta.METHOD)));
			this.setIp(DataParser.parse(String.class, map.get(DbBackupLogMeta.IP)));
			this.setProcessResult(DataParser.parse(String.class, map.get(DbBackupLogMeta.PROCESS_RESULT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(DbBackupLogMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(DbBackupLogMeta.VERSION)));
			this.setProcessed(DataParser.parse(String.class, map.get(DbBackupLogMeta.PROCESSED)));
			this.setCreateBy(DataParser.parse(String.class, map.get(DbBackupLogMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, map.get(DbBackupLogMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(DbBackupLogMeta.DELETED)));
			this.setSize(DataParser.parse(BigDecimal.class, map.get(DbBackupLogMeta.SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(DbBackupLogMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(DbBackupLogMeta.DELETE_TIME)));
			this.setEtime(DataParser.parse(Date.class, map.get(DbBackupLogMeta.ETIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(DbBackupLogMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(DbBackupLogMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(DbBackupLogMeta.NOTES));
				this.setDbName( (String)map.get(DbBackupLogMeta.DB_NAME));
				this.setStime( (Date)map.get(DbBackupLogMeta.STIME));
				this.setSource( (String)map.get(DbBackupLogMeta.SOURCE));
				this.setResult( (String)map.get(DbBackupLogMeta.RESULT));
				this.setUid( (String)map.get(DbBackupLogMeta.UID));
				this.setUpdateBy( (String)map.get(DbBackupLogMeta.UPDATE_BY));
				this.setLastProcessTime( (Date)map.get(DbBackupLogMeta.LAST_PROCESS_TIME));
				this.setDbId( (String)map.get(DbBackupLogMeta.DB_ID));
				this.setAction( (String)map.get(DbBackupLogMeta.ACTION));
				this.setId( (String)map.get(DbBackupLogMeta.ID));
				this.setMethod( (String)map.get(DbBackupLogMeta.METHOD));
				this.setIp( (String)map.get(DbBackupLogMeta.IP));
				this.setProcessResult( (String)map.get(DbBackupLogMeta.PROCESS_RESULT));
				this.setUpdateTime( (Date)map.get(DbBackupLogMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(DbBackupLogMeta.VERSION));
				this.setProcessed( (String)map.get(DbBackupLogMeta.PROCESSED));
				this.setCreateBy( (String)map.get(DbBackupLogMeta.CREATE_BY));
				this.setRecordTime( (Date)map.get(DbBackupLogMeta.RECORD_TIME));
				this.setDeleted( (Integer)map.get(DbBackupLogMeta.DELETED));
				this.setSize( (BigDecimal)map.get(DbBackupLogMeta.SIZE));
				this.setCreateTime( (Date)map.get(DbBackupLogMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(DbBackupLogMeta.DELETE_TIME));
				this.setEtime( (Date)map.get(DbBackupLogMeta.ETIME));
				this.setDeleteBy( (String)map.get(DbBackupLogMeta.DELETE_BY));
				this.setStatus( (String)map.get(DbBackupLogMeta.STATUS));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.NOTES)));
			this.setDbName(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.DB_NAME)));
			this.setStime(DataParser.parse(Date.class, r.getValue(DbBackupLogMeta.STIME)));
			this.setSource(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.SOURCE)));
			this.setResult(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.RESULT)));
			this.setUid(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.UID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.UPDATE_BY)));
			this.setLastProcessTime(DataParser.parse(Date.class, r.getValue(DbBackupLogMeta.LAST_PROCESS_TIME)));
			this.setDbId(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.DB_ID)));
			this.setAction(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.ACTION)));
			this.setId(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.ID)));
			this.setMethod(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.METHOD)));
			this.setIp(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.IP)));
			this.setProcessResult(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.PROCESS_RESULT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(DbBackupLogMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(DbBackupLogMeta.VERSION)));
			this.setProcessed(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.PROCESSED)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, r.getValue(DbBackupLogMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(DbBackupLogMeta.DELETED)));
			this.setSize(DataParser.parse(BigDecimal.class, r.getValue(DbBackupLogMeta.SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(DbBackupLogMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(DbBackupLogMeta.DELETE_TIME)));
			this.setEtime(DataParser.parse(Date.class, r.getValue(DbBackupLogMeta.ETIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(DbBackupLogMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(DbBackupLogMeta.NOTES));
				this.setDbName( (String)r.getValue(DbBackupLogMeta.DB_NAME));
				this.setStime( (Date)r.getValue(DbBackupLogMeta.STIME));
				this.setSource( (String)r.getValue(DbBackupLogMeta.SOURCE));
				this.setResult( (String)r.getValue(DbBackupLogMeta.RESULT));
				this.setUid( (String)r.getValue(DbBackupLogMeta.UID));
				this.setUpdateBy( (String)r.getValue(DbBackupLogMeta.UPDATE_BY));
				this.setLastProcessTime( (Date)r.getValue(DbBackupLogMeta.LAST_PROCESS_TIME));
				this.setDbId( (String)r.getValue(DbBackupLogMeta.DB_ID));
				this.setAction( (String)r.getValue(DbBackupLogMeta.ACTION));
				this.setId( (String)r.getValue(DbBackupLogMeta.ID));
				this.setMethod( (String)r.getValue(DbBackupLogMeta.METHOD));
				this.setIp( (String)r.getValue(DbBackupLogMeta.IP));
				this.setProcessResult( (String)r.getValue(DbBackupLogMeta.PROCESS_RESULT));
				this.setUpdateTime( (Date)r.getValue(DbBackupLogMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(DbBackupLogMeta.VERSION));
				this.setProcessed( (String)r.getValue(DbBackupLogMeta.PROCESSED));
				this.setCreateBy( (String)r.getValue(DbBackupLogMeta.CREATE_BY));
				this.setRecordTime( (Date)r.getValue(DbBackupLogMeta.RECORD_TIME));
				this.setDeleted( (Integer)r.getValue(DbBackupLogMeta.DELETED));
				this.setSize( (BigDecimal)r.getValue(DbBackupLogMeta.SIZE));
				this.setCreateTime( (Date)r.getValue(DbBackupLogMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(DbBackupLogMeta.DELETE_TIME));
				this.setEtime( (Date)r.getValue(DbBackupLogMeta.ETIME));
				this.setDeleteBy( (String)r.getValue(DbBackupLogMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(DbBackupLogMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}