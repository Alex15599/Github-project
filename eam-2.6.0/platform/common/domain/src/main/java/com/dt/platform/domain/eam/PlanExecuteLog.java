package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_PLAN_EXECUTE_LOG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.PlanExecuteLogMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 执行日志
 * <p>执行日志 , 数据表 eam_plan_execute_log 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-11 13:35:39
 * @sign F2D8C6E54239768D5A85A84388E92C84
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_plan_execute_log")
@ApiModel(description = "执行日志 ; 执行日志 , 数据表 eam_plan_execute_log 的PO类型")
public class PlanExecuteLog extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_PLAN_EXECUTE_LOG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 计划：计划
	*/
	@ApiModelProperty(required = false,value="计划" , notes = "计划")
	private String planId;
	
	/**
	 * 执行时间：执行时间
	*/
	@ApiModelProperty(required = false,value="执行时间" , notes = "执行时间")
	private Date executeTime;
	
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
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 是否已经执行：是否已经执行
	*/
	@ApiModelProperty(required = false,value="是否已经执行" , notes = "是否已经执行")
	private Integer executed;
	
	/**
	 * 执行错误：执行错误
	*/
	@ApiModelProperty(required = false,value="执行错误" , notes = "执行错误")
	private String errors;
	
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
	public PlanExecuteLog setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 计划<br>
	 * 计划
	 * @return 计划
	*/
	public String getPlanId() {
		return planId;
	}
	
	/**
	 * 设置 计划
	 * @param planId 计划
	 * @return 当前对象
	*/
	public PlanExecuteLog setPlanId(String planId) {
		this.planId=planId;
		return this;
	}
	
	/**
	 * 获得 执行时间<br>
	 * 执行时间
	 * @return 执行时间
	*/
	public Date getExecuteTime() {
		return executeTime;
	}
	
	/**
	 * 设置 执行时间
	 * @param executeTime 执行时间
	 * @return 当前对象
	*/
	public PlanExecuteLog setExecuteTime(Date executeTime) {
		this.executeTime=executeTime;
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
	public PlanExecuteLog setCreateBy(String createBy) {
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
	public PlanExecuteLog setCreateTime(Date createTime) {
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
	public PlanExecuteLog setUpdateBy(String updateBy) {
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
	public PlanExecuteLog setUpdateTime(Date updateTime) {
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
	public PlanExecuteLog setDeleted(Integer deleted) {
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
	public PlanExecuteLog setDeleted(Boolean deletedBool) {
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
	public PlanExecuteLog setDeleteBy(String deleteBy) {
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
	public PlanExecuteLog setDeleteTime(Date deleteTime) {
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
	public PlanExecuteLog setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 是否已经执行<br>
	 * 是否已经执行
	 * @return 是否已经执行
	*/
	public Integer getExecuted() {
		return executed;
	}
	
	/**
	 * 设置 是否已经执行
	 * @param executed 是否已经执行
	 * @return 当前对象
	*/
	public PlanExecuteLog setExecuted(Integer executed) {
		this.executed=executed;
		return this;
	}
	
	/**
	 * 获得 执行错误<br>
	 * 执行错误
	 * @return 执行错误
	*/
	public String getErrors() {
		return errors;
	}
	
	/**
	 * 设置 执行错误
	 * @param errors 执行错误
	 * @return 当前对象
	*/
	public PlanExecuteLog setErrors(String errors) {
		this.errors=errors;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PlanExecuteLog , 转换好的 PlanExecuteLog 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PlanExecuteLog , 转换好的 PoJo 对象
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
	public PlanExecuteLog clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PlanExecuteLog duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.PlanExecuteLogMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.PlanExecuteLogMeta.$$proxy$$();
		inst.setUpdateTime(this.getUpdateTime());
		inst.setExecuted(this.getExecuted());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPlanId(this.getPlanId());
		inst.setId(this.getId());
		inst.setErrors(this.getErrors());
		inst.setExecuteTime(this.getExecuteTime());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PlanExecuteLog clone(boolean deep) {
		return EntityContext.clone(PlanExecuteLog.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PlanExecuteLog
	 * @param planExecuteLogMap 包含实体信息的 Map 对象
	 * @return PlanExecuteLog , 转换好的的 PlanExecuteLog 对象
	*/
	@Transient
	public static PlanExecuteLog createFrom(Map<String,Object> planExecuteLogMap) {
		if(planExecuteLogMap==null) return null;
		PlanExecuteLog po = create();
		EntityContext.copyProperties(po,planExecuteLogMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PlanExecuteLog
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PlanExecuteLog , 转换好的的 PlanExecuteLog 对象
	*/
	@Transient
	public static PlanExecuteLog createFrom(Object pojo) {
		if(pojo==null) return null;
		PlanExecuteLog po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PlanExecuteLog，等同于 new
	 * @return PlanExecuteLog 对象
	*/
	@Transient
	public static PlanExecuteLog create() {
		return new com.dt.platform.domain.eam.meta.PlanExecuteLogMeta.$$proxy$$();
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
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PlanExecuteLogMeta.UPDATE_TIME)));
			this.setExecuted(DataParser.parse(Integer.class, map.get(PlanExecuteLogMeta.EXECUTED)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PlanExecuteLogMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PlanExecuteLogMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PlanExecuteLogMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PlanExecuteLogMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PlanExecuteLogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PlanExecuteLogMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PlanExecuteLogMeta.DELETE_BY)));
			this.setPlanId(DataParser.parse(String.class, map.get(PlanExecuteLogMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, map.get(PlanExecuteLogMeta.ID)));
			this.setErrors(DataParser.parse(String.class, map.get(PlanExecuteLogMeta.ERRORS)));
			this.setExecuteTime(DataParser.parse(Date.class, map.get(PlanExecuteLogMeta.EXECUTE_TIME)));
			// others
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)map.get(PlanExecuteLogMeta.UPDATE_TIME));
				this.setExecuted( (Integer)map.get(PlanExecuteLogMeta.EXECUTED));
				this.setVersion( (Integer)map.get(PlanExecuteLogMeta.VERSION));
				this.setCreateBy( (String)map.get(PlanExecuteLogMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PlanExecuteLogMeta.DELETED));
				this.setCreateTime( (Date)map.get(PlanExecuteLogMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PlanExecuteLogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PlanExecuteLogMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(PlanExecuteLogMeta.DELETE_BY));
				this.setPlanId( (String)map.get(PlanExecuteLogMeta.PLAN_ID));
				this.setId( (String)map.get(PlanExecuteLogMeta.ID));
				this.setErrors( (String)map.get(PlanExecuteLogMeta.ERRORS));
				this.setExecuteTime( (Date)map.get(PlanExecuteLogMeta.EXECUTE_TIME));
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
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PlanExecuteLogMeta.UPDATE_TIME)));
			this.setExecuted(DataParser.parse(Integer.class, r.getValue(PlanExecuteLogMeta.EXECUTED)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PlanExecuteLogMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PlanExecuteLogMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PlanExecuteLogMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PlanExecuteLogMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PlanExecuteLogMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PlanExecuteLogMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PlanExecuteLogMeta.DELETE_BY)));
			this.setPlanId(DataParser.parse(String.class, r.getValue(PlanExecuteLogMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(PlanExecuteLogMeta.ID)));
			this.setErrors(DataParser.parse(String.class, r.getValue(PlanExecuteLogMeta.ERRORS)));
			this.setExecuteTime(DataParser.parse(Date.class, r.getValue(PlanExecuteLogMeta.EXECUTE_TIME)));
			return true;
		} else {
			try {
				this.setUpdateTime( (Date)r.getValue(PlanExecuteLogMeta.UPDATE_TIME));
				this.setExecuted( (Integer)r.getValue(PlanExecuteLogMeta.EXECUTED));
				this.setVersion( (Integer)r.getValue(PlanExecuteLogMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PlanExecuteLogMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PlanExecuteLogMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PlanExecuteLogMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PlanExecuteLogMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PlanExecuteLogMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(PlanExecuteLogMeta.DELETE_BY));
				this.setPlanId( (String)r.getValue(PlanExecuteLogMeta.PLAN_ID));
				this.setId( (String)r.getValue(PlanExecuteLogMeta.ID));
				this.setErrors( (String)r.getValue(PlanExecuteLogMeta.ERRORS));
				this.setExecuteTime( (Date)r.getValue(PlanExecuteLogMeta.EXECUTE_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}