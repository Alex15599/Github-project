package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.CCustRepiarItem;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-01 22:26:48
 * @sign D6945F97758D38B485ED76200DF970A2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CCustRepiarItemMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 报修 , 类型: java.lang.String
	*/
	public static final String REPAIR_ID="repairId";
	
	/**
	 * 报修 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,java.lang.String> REPAIR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,REPAIR_ID, java.lang.String.class, "报修", "报修", java.lang.String.class, null);
	
	/**
	 * 处理人 , 类型: java.lang.String
	*/
	public static final String PROCESS_USER_ID="processUserId";
	
	/**
	 * 处理人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,java.lang.String> PROCESS_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,PROCESS_USER_ID, java.lang.String.class, "处理人", "处理人", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CT="ct";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,java.lang.String> CT_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,CT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String RECORD_TIME="recordTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,java.util.Date> RECORD_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,RECORD_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 处理人 , 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String PROCESS_USER="processUser";
	
	/**
	 * 处理人 , 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustRepiarItem,org.github.foxnic.web.domain.hrm.Employee> PROCESS_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustRepiarItem.class ,PROCESS_USER, org.github.foxnic.web.domain.hrm.Employee.class, "处理人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , REPAIR_ID , PROCESS_USER_ID , CT , RECORD_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , PROCESS_USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.CCustRepiarItem {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CCustRepiarItem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 报修
		 * @param repairId 报修
		 * @return 当前对象
		*/
		public CCustRepiarItem setRepairId(String repairId) {
			super.change(REPAIR_ID,super.getRepairId(),repairId);
			super.setRepairId(repairId);
			return this;
		}
		
		/**
		 * 设置 处理人
		 * @param processUserId 处理人
		 * @return 当前对象
		*/
		public CCustRepiarItem setProcessUserId(String processUserId) {
			super.change(PROCESS_USER_ID,super.getProcessUserId(),processUserId);
			super.setProcessUserId(processUserId);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param ct 内容
		 * @return 当前对象
		*/
		public CCustRepiarItem setCt(String ct) {
			super.change(CT,super.getCt(),ct);
			super.setCt(ct);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param recordTime 记录时间
		 * @return 当前对象
		*/
		public CCustRepiarItem setRecordTime(Date recordTime) {
			super.change(RECORD_TIME,super.getRecordTime(),recordTime);
			super.setRecordTime(recordTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CCustRepiarItem setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CCustRepiarItem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CCustRepiarItem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CCustRepiarItem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CCustRepiarItem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CCustRepiarItem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CCustRepiarItem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CCustRepiarItem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 处理人
		 * @param processUser 处理人
		 * @return 当前对象
		*/
		public CCustRepiarItem setProcessUser(Employee processUser) {
			super.change(PROCESS_USER,super.getProcessUser(),processUser);
			super.setProcessUser(processUser);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CCustRepiarItem clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CCustRepiarItem duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setRepairId(this.getRepairId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCt(this.getCt());
			inst.setCreateBy(this.getCreateBy());
			inst.setRecordTime(this.getRecordTime());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setProcessUserId(this.getProcessUserId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setProcessUser(this.getProcessUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}