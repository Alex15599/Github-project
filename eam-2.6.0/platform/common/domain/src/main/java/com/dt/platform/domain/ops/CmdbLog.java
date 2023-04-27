package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_CMDB_LOG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 配置日志
 * <p>配置日志 , 数据表 ops_cmdb_log 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-22 14:18:35
 * @sign AFE5466156DF66E422094AA8D9608777
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_cmdb_log")
@ApiModel(description = "配置日志 ; 配置日志 , 数据表 ops_cmdb_log 的PO类型")
public class CmdbLog extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_CMDB_LOG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 模型：模型
	*/
	@ApiModelProperty(required = false,value="模型" , notes = "模型")
	private String modelId;
	
	/**
	 * 对象：对象
	*/
	@ApiModelProperty(required = false,value="对象" , notes = "对象")
	private String objId;
	
	/**
	 * 日志级别：日志级别
	*/
	@ApiModelProperty(required = false,value="日志级别" , notes = "日志级别")
	private String logLevel;
	
	/**
	 * TRACE：TRACE
	*/
	@ApiModelProperty(required = false,value="TRACE" , notes = "TRACE")
	private String traceId;
	
	/**
	 * 日志：日志
	*/
	@ApiModelProperty(required = false,value="日志" , notes = "日志")
	private String logRecord;
	
	/**
	 * 时间：时间
	*/
	@ApiModelProperty(required = false,value="时间" , notes = "时间")
	private Date rcdTime;
	
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
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
	@ApiModelProperty(required = false,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * cmdbModelV：cmdbModelV
	*/
	@ApiModelProperty(required = false,value="cmdbModelV" , notes = "cmdbModelV")
	private CmdbModelV cmdbModelV;
	
	/**
	 * cmdbModel：cmdbModel
	*/
	@ApiModelProperty(required = false,value="cmdbModel" , notes = "cmdbModel")
	private CmdbModel cmdbModel;
	
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
	public CmdbLog setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 模型<br>
	 * 模型
	 * @return 模型
	*/
	public String getModelId() {
		return modelId;
	}
	
	/**
	 * 设置 模型
	 * @param modelId 模型
	 * @return 当前对象
	*/
	public CmdbLog setModelId(String modelId) {
		this.modelId=modelId;
		return this;
	}
	
	/**
	 * 获得 对象<br>
	 * 对象
	 * @return 对象
	*/
	public String getObjId() {
		return objId;
	}
	
	/**
	 * 设置 对象
	 * @param objId 对象
	 * @return 当前对象
	*/
	public CmdbLog setObjId(String objId) {
		this.objId=objId;
		return this;
	}
	
	/**
	 * 获得 日志级别<br>
	 * 日志级别
	 * @return 日志级别
	*/
	public String getLogLevel() {
		return logLevel;
	}
	
	/**
	 * 设置 日志级别
	 * @param logLevel 日志级别
	 * @return 当前对象
	*/
	public CmdbLog setLogLevel(String logLevel) {
		this.logLevel=logLevel;
		return this;
	}
	
	/**
	 * 获得 TRACE<br>
	 * TRACE
	 * @return TRACE
	*/
	public String getTraceId() {
		return traceId;
	}
	
	/**
	 * 设置 TRACE
	 * @param traceId TRACE
	 * @return 当前对象
	*/
	public CmdbLog setTraceId(String traceId) {
		this.traceId=traceId;
		return this;
	}
	
	/**
	 * 获得 日志<br>
	 * 日志
	 * @return 日志
	*/
	public String getLogRecord() {
		return logRecord;
	}
	
	/**
	 * 设置 日志
	 * @param logRecord 日志
	 * @return 当前对象
	*/
	public CmdbLog setLogRecord(String logRecord) {
		this.logRecord=logRecord;
		return this;
	}
	
	/**
	 * 获得 时间<br>
	 * 时间
	 * @return 时间
	*/
	public Date getRcdTime() {
		return rcdTime;
	}
	
	/**
	 * 设置 时间
	 * @param rcdTime 时间
	 * @return 当前对象
	*/
	public CmdbLog setRcdTime(Date rcdTime) {
		this.rcdTime=rcdTime;
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
	public CmdbLog setNotes(String notes) {
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
	public CmdbLog setCreateBy(String createBy) {
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
	public CmdbLog setCreateTime(Date createTime) {
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
	public CmdbLog setUpdateBy(String updateBy) {
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
	public CmdbLog setUpdateTime(Date updateTime) {
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
	public CmdbLog setDeleted(Integer deleted) {
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
	public CmdbLog setDeleted(Boolean deletedBool) {
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
	public CmdbLog setDeleteBy(String deleteBy) {
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
	public CmdbLog setDeleteTime(Date deleteTime) {
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
	public CmdbLog setVersion(Integer version) {
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
	public CmdbLog setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 cmdbModelV<br>
	 * cmdbModelV
	 * @return cmdbModelV
	*/
	public CmdbModelV getCmdbModelV() {
		return cmdbModelV;
	}
	
	/**
	 * 设置 cmdbModelV
	 * @param cmdbModelV cmdbModelV
	 * @return 当前对象
	*/
	public CmdbLog setCmdbModelV(CmdbModelV cmdbModelV) {
		this.cmdbModelV=cmdbModelV;
		return this;
	}
	
	/**
	 * 获得 cmdbModel<br>
	 * cmdbModel
	 * @return cmdbModel
	*/
	public CmdbModel getCmdbModel() {
		return cmdbModel;
	}
	
	/**
	 * 设置 cmdbModel
	 * @param cmdbModel cmdbModel
	 * @return 当前对象
	*/
	public CmdbLog setCmdbModel(CmdbModel cmdbModel) {
		this.cmdbModel=cmdbModel;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CmdbLog , 转换好的 CmdbLog 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CmdbLog , 转换好的 PoJo 对象
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
	public CmdbLog clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CmdbLog duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.CmdbLogMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.CmdbLogMeta.$$proxy$$();
		inst.setTraceId(this.getTraceId());
		inst.setNotes(this.getNotes());
		inst.setModelId(this.getModelId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setLogLevel(this.getLogLevel());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setObjId(this.getObjId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setLogRecord(this.getLogRecord());
		inst.setRcdTime(this.getRcdTime());
		if(all) {
			inst.setCmdbModel(this.getCmdbModel());
			inst.setCmdbModelV(this.getCmdbModelV());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CmdbLog clone(boolean deep) {
		return EntityContext.clone(CmdbLog.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CmdbLog
	 * @param cmdbLogMap 包含实体信息的 Map 对象
	 * @return CmdbLog , 转换好的的 CmdbLog 对象
	*/
	@Transient
	public static CmdbLog createFrom(Map<String,Object> cmdbLogMap) {
		if(cmdbLogMap==null) return null;
		CmdbLog po = create();
		EntityContext.copyProperties(po,cmdbLogMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CmdbLog
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CmdbLog , 转换好的的 CmdbLog 对象
	*/
	@Transient
	public static CmdbLog createFrom(Object pojo) {
		if(pojo==null) return null;
		CmdbLog po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CmdbLog，等同于 new
	 * @return CmdbLog 对象
	*/
	@Transient
	public static CmdbLog create() {
		return new com.dt.platform.domain.ops.meta.CmdbLogMeta.$$proxy$$();
	}
}