package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InventoryFeedback;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-08 07:00:15
 * @sign 71301D92B8169B915A602718A4C8607D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InventoryFeedbackMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 盘点 , 类型: java.lang.String
	*/
	public static final String INVENTORY_ID="inventoryId";
	
	/**
	 * 盘点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.lang.String> INVENTORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,INVENTORY_ID, java.lang.String.class, "盘点", "盘点", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,USER_ID, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 照片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 照片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,PICTURE_ID, java.lang.String.class, "照片", "照片", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 用户 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER="user";
	
	/**
	 * 用户 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedback,org.github.foxnic.web.domain.hrm.Employee> USER_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedback.class ,USER, org.github.foxnic.web.domain.hrm.Employee.class, "用户", "用户", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , INVENTORY_ID , STATUS , USER_ID , CONTENT , PICTURE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InventoryFeedback {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InventoryFeedback setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 盘点
		 * @param inventoryId 盘点
		 * @return 当前对象
		*/
		public InventoryFeedback setInventoryId(String inventoryId) {
			super.change(INVENTORY_ID,super.getInventoryId(),inventoryId);
			super.setInventoryId(inventoryId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public InventoryFeedback setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userId 用户
		 * @return 当前对象
		*/
		public InventoryFeedback setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public InventoryFeedback setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 照片
		 * @param pictureId 照片
		 * @return 当前对象
		*/
		public InventoryFeedback setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public InventoryFeedback setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InventoryFeedback setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InventoryFeedback setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InventoryFeedback setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InventoryFeedback setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InventoryFeedback setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InventoryFeedback setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InventoryFeedback setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public InventoryFeedback setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param user 用户
		 * @return 当前对象
		*/
		public InventoryFeedback setUser(Employee user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public InventoryFeedback clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public InventoryFeedback duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPictureId(this.getPictureId());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setInventoryId(this.getInventoryId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setUser(this.getUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}