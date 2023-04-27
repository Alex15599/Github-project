package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ACTION_CRONTAB;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.ActionCrontabMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 执行动作
 * <p>执行动作 , 数据表 eam_action_crontab 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-09 22:04:32
 * @sign C49762D877C26553A889E8FCE966CAA2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_action_crontab")
@ApiModel(description = "执行动作 ; 执行动作 , 数据表 eam_action_crontab 的PO类型")
public class ActionCrontab extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ACTION_CRONTAB.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "585027341697155072")
	private String id;
	
	/**
	 * 所属于：所属于
	*/
	@ApiModelProperty(required = false,value="所属于" , notes = "所属于")
	private String ownerId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "1212")
	private String name;
	
	/**
	 * 表达式：表达式
	*/
	@ApiModelProperty(required = false,value="表达式" , notes = "表达式" , example = "0,2,11 * * * * ?")
	private String crontab;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2022-06-08 12:00:00")
	private Date startExecutionTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间" , example = "2022-06-25 12:00:00")
	private Date finishExecutionTime;
	
	/**
	 * 上次执行时间：上次执行时间
	*/
	@ApiModelProperty(required = false,value="上次执行时间" , notes = "上次执行时间")
	private Date lastExecutionTime;
	
	/**
	 * 下次执行时间：下次执行时间
	*/
	@ApiModelProperty(required = false,value="下次执行时间" , notes = "下次执行时间")
	private Date nextExecutionTime;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-06-03 08:49:48")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-06-03 08:51:59")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * 日志：日志
	*/
	@ApiModelProperty(required = false,value="日志" , notes = "日志")
	private ActionCrontabLog actionCrontabLog;
	
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
	public ActionCrontab setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属于<br>
	 * 所属于
	 * @return 所属于
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 所属于
	 * @param ownerId 所属于
	 * @return 当前对象
	*/
	public ActionCrontab setOwnerId(String ownerId) {
		this.ownerId=ownerId;
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
	public ActionCrontab setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 表达式<br>
	 * 表达式
	 * @return 表达式
	*/
	public String getCrontab() {
		return crontab;
	}
	
	/**
	 * 设置 表达式
	 * @param crontab 表达式
	 * @return 当前对象
	*/
	public ActionCrontab setCrontab(String crontab) {
		this.crontab=crontab;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStartExecutionTime() {
		return startExecutionTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param startExecutionTime 开始时间
	 * @return 当前对象
	*/
	public ActionCrontab setStartExecutionTime(Date startExecutionTime) {
		this.startExecutionTime=startExecutionTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getFinishExecutionTime() {
		return finishExecutionTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param finishExecutionTime 结束时间
	 * @return 当前对象
	*/
	public ActionCrontab setFinishExecutionTime(Date finishExecutionTime) {
		this.finishExecutionTime=finishExecutionTime;
		return this;
	}
	
	/**
	 * 获得 上次执行时间<br>
	 * 上次执行时间
	 * @return 上次执行时间
	*/
	public Date getLastExecutionTime() {
		return lastExecutionTime;
	}
	
	/**
	 * 设置 上次执行时间
	 * @param lastExecutionTime 上次执行时间
	 * @return 当前对象
	*/
	public ActionCrontab setLastExecutionTime(Date lastExecutionTime) {
		this.lastExecutionTime=lastExecutionTime;
		return this;
	}
	
	/**
	 * 获得 下次执行时间<br>
	 * 下次执行时间
	 * @return 下次执行时间
	*/
	public Date getNextExecutionTime() {
		return nextExecutionTime;
	}
	
	/**
	 * 设置 下次执行时间
	 * @param nextExecutionTime 下次执行时间
	 * @return 当前对象
	*/
	public ActionCrontab setNextExecutionTime(Date nextExecutionTime) {
		this.nextExecutionTime=nextExecutionTime;
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
	public ActionCrontab setNotes(String notes) {
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
	public ActionCrontab setCreateBy(String createBy) {
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
	public ActionCrontab setCreateTime(Date createTime) {
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
	public ActionCrontab setUpdateBy(String updateBy) {
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
	public ActionCrontab setUpdateTime(Date updateTime) {
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
	public ActionCrontab setDeleted(Integer deleted) {
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
	public ActionCrontab setDeleted(Boolean deletedBool) {
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
	public ActionCrontab setDeleteBy(String deleteBy) {
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
	public ActionCrontab setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public ActionCrontab setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public ActionCrontab setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 日志<br>
	 * 日志
	 * @return 日志
	*/
	public ActionCrontabLog getActionCrontabLog() {
		return actionCrontabLog;
	}
	
	/**
	 * 设置 日志
	 * @param actionCrontabLog 日志
	 * @return 当前对象
	*/
	public ActionCrontab setActionCrontabLog(ActionCrontabLog actionCrontabLog) {
		this.actionCrontabLog=actionCrontabLog;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ActionCrontab , 转换好的 ActionCrontab 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ActionCrontab , 转换好的 PoJo 对象
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
	public ActionCrontab clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ActionCrontab duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.ActionCrontabMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.ActionCrontabMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setNextExecutionTime(this.getNextExecutionTime());
		inst.setCrontab(this.getCrontab());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOwnerId(this.getOwnerId());
		inst.setStartExecutionTime(this.getStartExecutionTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setFinishExecutionTime(this.getFinishExecutionTime());
		inst.setLastExecutionTime(this.getLastExecutionTime());
		if(all) {
			inst.setActionCrontabLog(this.getActionCrontabLog());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ActionCrontab clone(boolean deep) {
		return EntityContext.clone(ActionCrontab.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ActionCrontab
	 * @param actionCrontabMap 包含实体信息的 Map 对象
	 * @return ActionCrontab , 转换好的的 ActionCrontab 对象
	*/
	@Transient
	public static ActionCrontab createFrom(Map<String,Object> actionCrontabMap) {
		if(actionCrontabMap==null) return null;
		ActionCrontab po = create();
		EntityContext.copyProperties(po,actionCrontabMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ActionCrontab
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ActionCrontab , 转换好的的 ActionCrontab 对象
	*/
	@Transient
	public static ActionCrontab createFrom(Object pojo) {
		if(pojo==null) return null;
		ActionCrontab po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ActionCrontab，等同于 new
	 * @return ActionCrontab 对象
	*/
	@Transient
	public static ActionCrontab create() {
		return new com.dt.platform.domain.eam.meta.ActionCrontabMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(ActionCrontabMeta.NOTES)));
			this.setNextExecutionTime(DataParser.parse(Date.class, map.get(ActionCrontabMeta.NEXT_EXECUTION_TIME)));
			this.setCrontab(DataParser.parse(String.class, map.get(ActionCrontabMeta.CRONTAB)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ActionCrontabMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, map.get(ActionCrontabMeta.OWNER_ID)));
			this.setStartExecutionTime(DataParser.parse(Date.class, map.get(ActionCrontabMeta.START_EXECUTION_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ActionCrontabMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ActionCrontabMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ActionCrontabMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ActionCrontabMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ActionCrontabMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ActionCrontabMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(ActionCrontabMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ActionCrontabMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ActionCrontabMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ActionCrontabMeta.ID)));
			this.setFinishExecutionTime(DataParser.parse(Date.class, map.get(ActionCrontabMeta.FINISH_EXECUTION_TIME)));
			this.setLastExecutionTime(DataParser.parse(Date.class, map.get(ActionCrontabMeta.LAST_EXECUTION_TIME)));
			// others
			this.setActionCrontabLog(DataParser.parse(ActionCrontabLog.class, map.get(ActionCrontabMeta.ACTION_CRONTAB_LOG)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(ActionCrontabMeta.NOTES));
				this.setNextExecutionTime( (Date)map.get(ActionCrontabMeta.NEXT_EXECUTION_TIME));
				this.setCrontab( (String)map.get(ActionCrontabMeta.CRONTAB));
				this.setUpdateTime( (Date)map.get(ActionCrontabMeta.UPDATE_TIME));
				this.setOwnerId( (String)map.get(ActionCrontabMeta.OWNER_ID));
				this.setStartExecutionTime( (Date)map.get(ActionCrontabMeta.START_EXECUTION_TIME));
				this.setVersion( (Integer)map.get(ActionCrontabMeta.VERSION));
				this.setCreateBy( (String)map.get(ActionCrontabMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ActionCrontabMeta.DELETED));
				this.setCreateTime( (Date)map.get(ActionCrontabMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ActionCrontabMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ActionCrontabMeta.DELETE_TIME));
				this.setName( (String)map.get(ActionCrontabMeta.NAME));
				this.setTenantId( (String)map.get(ActionCrontabMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ActionCrontabMeta.DELETE_BY));
				this.setId( (String)map.get(ActionCrontabMeta.ID));
				this.setFinishExecutionTime( (Date)map.get(ActionCrontabMeta.FINISH_EXECUTION_TIME));
				this.setLastExecutionTime( (Date)map.get(ActionCrontabMeta.LAST_EXECUTION_TIME));
				// others
				this.setActionCrontabLog( (ActionCrontabLog)map.get(ActionCrontabMeta.ACTION_CRONTAB_LOG));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(ActionCrontabMeta.NOTES)));
			this.setNextExecutionTime(DataParser.parse(Date.class, r.getValue(ActionCrontabMeta.NEXT_EXECUTION_TIME)));
			this.setCrontab(DataParser.parse(String.class, r.getValue(ActionCrontabMeta.CRONTAB)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ActionCrontabMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(ActionCrontabMeta.OWNER_ID)));
			this.setStartExecutionTime(DataParser.parse(Date.class, r.getValue(ActionCrontabMeta.START_EXECUTION_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ActionCrontabMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ActionCrontabMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ActionCrontabMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ActionCrontabMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ActionCrontabMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ActionCrontabMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(ActionCrontabMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ActionCrontabMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ActionCrontabMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ActionCrontabMeta.ID)));
			this.setFinishExecutionTime(DataParser.parse(Date.class, r.getValue(ActionCrontabMeta.FINISH_EXECUTION_TIME)));
			this.setLastExecutionTime(DataParser.parse(Date.class, r.getValue(ActionCrontabMeta.LAST_EXECUTION_TIME)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(ActionCrontabMeta.NOTES));
				this.setNextExecutionTime( (Date)r.getValue(ActionCrontabMeta.NEXT_EXECUTION_TIME));
				this.setCrontab( (String)r.getValue(ActionCrontabMeta.CRONTAB));
				this.setUpdateTime( (Date)r.getValue(ActionCrontabMeta.UPDATE_TIME));
				this.setOwnerId( (String)r.getValue(ActionCrontabMeta.OWNER_ID));
				this.setStartExecutionTime( (Date)r.getValue(ActionCrontabMeta.START_EXECUTION_TIME));
				this.setVersion( (Integer)r.getValue(ActionCrontabMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ActionCrontabMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ActionCrontabMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ActionCrontabMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ActionCrontabMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ActionCrontabMeta.DELETE_TIME));
				this.setName( (String)r.getValue(ActionCrontabMeta.NAME));
				this.setTenantId( (String)r.getValue(ActionCrontabMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ActionCrontabMeta.DELETE_BY));
				this.setId( (String)r.getValue(ActionCrontabMeta.ID));
				this.setFinishExecutionTime( (Date)r.getValue(ActionCrontabMeta.FINISH_EXECUTION_TIME));
				this.setLastExecutionTime( (Date)r.getValue(ActionCrontabMeta.LAST_EXECUTION_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}