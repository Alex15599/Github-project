package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.PlanExecuteLog;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-11 13:35:39
 * @sign F2D8C6E54239768D5A85A84388E92C84
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PlanExecuteLogMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PlanExecuteLog,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PlanExecuteLog.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 计划 , 类型: java.lang.String
	*/
	public static final String PLAN_ID="planId";
	
	/**
	 * 计划 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PlanExecuteLog,java.lang.String> PLAN_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.PlanExecuteLog.class ,PLAN_ID, java.lang.String.class, "计划", "计划", java.lang.String.class, null);
	
	/**
	 * 执行时间 , 类型: java.util.Date
	*/
	public static final String EXECUTE_TIME="executeTime";
	
	/**
	 * 执行时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PlanExecuteLog,java.util.Date> EXECUTE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.PlanExecuteLog.class ,EXECUTE_TIME, java.util.Date.class, "执行时间", "执行时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PlanExecuteLog,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.PlanExecuteLog.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PlanExecuteLog,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.PlanExecuteLog.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PlanExecuteLog,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.PlanExecuteLog.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PlanExecuteLog,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.PlanExecuteLog.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PlanExecuteLog,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.PlanExecuteLog.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PlanExecuteLog,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.PlanExecuteLog.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PlanExecuteLog,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.PlanExecuteLog.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PlanExecuteLog,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.PlanExecuteLog.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 是否已经执行 , 类型: java.lang.Integer
	*/
	public static final String EXECUTED="executed";
	
	/**
	 * 是否已经执行 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PlanExecuteLog,java.lang.Integer> EXECUTED_PROP = new BeanProperty(com.dt.platform.domain.eam.PlanExecuteLog.class ,EXECUTED, java.lang.Integer.class, "是否已经执行", "是否已经执行", java.lang.Integer.class, null);
	
	/**
	 * 执行错误 , 类型: java.lang.String
	*/
	public static final String ERRORS="errors";
	
	/**
	 * 执行错误 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.PlanExecuteLog,java.lang.String> ERRORS_PROP = new BeanProperty(com.dt.platform.domain.eam.PlanExecuteLog.class ,ERRORS, java.lang.String.class, "执行错误", "执行错误", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PLAN_ID , EXECUTE_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , EXECUTED , ERRORS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.PlanExecuteLog {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PlanExecuteLog setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 计划
		 * @param planId 计划
		 * @return 当前对象
		*/
		public PlanExecuteLog setPlanId(String planId) {
			super.change(PLAN_ID,super.getPlanId(),planId);
			super.setPlanId(planId);
			return this;
		}
		
		/**
		 * 设置 执行时间
		 * @param executeTime 执行时间
		 * @return 当前对象
		*/
		public PlanExecuteLog setExecuteTime(Date executeTime) {
			super.change(EXECUTE_TIME,super.getExecuteTime(),executeTime);
			super.setExecuteTime(executeTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PlanExecuteLog setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PlanExecuteLog setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PlanExecuteLog setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PlanExecuteLog setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PlanExecuteLog setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PlanExecuteLog setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PlanExecuteLog setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PlanExecuteLog setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 是否已经执行
		 * @param executed 是否已经执行
		 * @return 当前对象
		*/
		public PlanExecuteLog setExecuted(Integer executed) {
			super.change(EXECUTED,super.getExecuted(),executed);
			super.setExecuted(executed);
			return this;
		}
		
		/**
		 * 设置 执行错误
		 * @param errors 执行错误
		 * @return 当前对象
		*/
		public PlanExecuteLog setErrors(String errors) {
			super.change(ERRORS,super.getErrors(),errors);
			super.setErrors(errors);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}