package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_AUTO_TASK_M_LOG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 执行日志
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-24 13:10:23
 * @sign 133281E9FDAFECEFA0479DDD24900BC6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_auto_task_m_log")
public class AutoTaskMLog extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_AUTO_TASK_M_LOG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 作业：作业
	*/
	@ApiModelProperty(required = false,value="作业" , notes = "作业")
	private String taskId;
	
	/**
	 * 动作：动作
	*/
	@ApiModelProperty(required = false,value="动作" , notes = "动作")
	private String actionId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date stime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Date etime;
	
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
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * task：task
	*/
	@ApiModelProperty(required = false,value="task" , notes = "task")
	private AutoTask task;
	
	/**
	 * action：action
	*/
	@ApiModelProperty(required = false,value="action" , notes = "action")
	private AutoAction action;
	
	/**
	 * logList：logList
	*/
	@ApiModelProperty(required = false,value="logList" , notes = "logList")
	private List<AutoTaskLog> logList;
	
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
	public AutoTaskMLog setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 作业<br>
	 * 作业
	 * @return 作业
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 作业
	 * @param taskId 作业
	 * @return 当前对象
	*/
	public AutoTaskMLog setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}
	
	/**
	 * 获得 动作<br>
	 * 动作
	 * @return 动作
	*/
	public String getActionId() {
		return actionId;
	}
	
	/**
	 * 设置 动作
	 * @param actionId 动作
	 * @return 当前对象
	*/
	public AutoTaskMLog setActionId(String actionId) {
		this.actionId=actionId;
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
	public AutoTaskMLog setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 内容
	 * @param content 内容
	 * @return 当前对象
	*/
	public AutoTaskMLog setContent(String content) {
		this.content=content;
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
	public AutoTaskMLog setStime(Date stime) {
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
	public AutoTaskMLog setEtime(Date etime) {
		this.etime=etime;
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
	public AutoTaskMLog setUpdateBy(String updateBy) {
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
	public AutoTaskMLog setUpdateTime(Date updateTime) {
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
	public AutoTaskMLog setDeleted(Integer deleted) {
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
	public AutoTaskMLog setDeleted(Boolean deletedBool) {
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
	public AutoTaskMLog setDeleteBy(String deleteBy) {
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
	public AutoTaskMLog setDeleteTime(Date deleteTime) {
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
	public AutoTaskMLog setVersion(Integer version) {
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
	public AutoTaskMLog setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 task<br>
	 * task
	 * @return task
	*/
	public AutoTask getTask() {
		return task;
	}
	
	/**
	 * 设置 task
	 * @param task task
	 * @return 当前对象
	*/
	public AutoTaskMLog setTask(AutoTask task) {
		this.task=task;
		return this;
	}
	
	/**
	 * 获得 action<br>
	 * action
	 * @return action
	*/
	public AutoAction getAction() {
		return action;
	}
	
	/**
	 * 设置 action
	 * @param action action
	 * @return 当前对象
	*/
	public AutoTaskMLog setAction(AutoAction action) {
		this.action=action;
		return this;
	}
	
	/**
	 * 获得 logList<br>
	 * logList
	 * @return logList
	*/
	public List<AutoTaskLog> getLogList() {
		return logList;
	}
	
	/**
	 * 设置 logList
	 * @param logList logList
	 * @return 当前对象
	*/
	public AutoTaskMLog setLogList(List<AutoTaskLog> logList) {
		this.logList=logList;
		return this;
	}
	
	/**
	 * 添加 logList
	 * @param log logList
	 * @return 当前对象
	*/
	public AutoTaskMLog addLog(AutoTaskLog... log) {
		if(this.logList==null) logList=new ArrayList<>();
		this.logList.addAll(Arrays.asList(log));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoTaskMLog , 转换好的 AutoTaskMLog 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoTaskMLog , 转换好的 PoJo 对象
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
	public AutoTaskMLog clone() {
		return EntityContext.clone(AutoTaskMLog.class,this);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoTaskMLog clone(boolean deep) {
		return EntityContext.clone(AutoTaskMLog.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoTaskMLog
	 * @param autoTaskMLogMap 包含实体信息的 Map 对象
	 * @return AutoTaskMLog , 转换好的的 AutoTaskMLog 对象
	*/
	@Transient
	public static AutoTaskMLog createFrom(Map<String,Object> autoTaskMLogMap) {
		if(autoTaskMLogMap==null) return null;
		AutoTaskMLog po = EntityContext.create(AutoTaskMLog.class, autoTaskMLogMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoTaskMLog
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoTaskMLog , 转换好的的 AutoTaskMLog 对象
	*/
	@Transient
	public static AutoTaskMLog createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoTaskMLog po = EntityContext.create(AutoTaskMLog.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AutoTaskMLog，等同于 new
	 * @return AutoTaskMLog 对象
	*/
	@Transient
	public static AutoTaskMLog create() {
		return EntityContext.create(AutoTaskMLog.class);
	}
}