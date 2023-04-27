package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InventoryFeedbackMsg;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-08 06:57:04
 * @sign CA5335BE6E988963A3737F6ECD3FFBA4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InventoryFeedbackMsgMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 反馈 , 类型: java.lang.String
	*/
	public static final String FEEDBACK_ID="feedbackId";
	
	/**
	 * 反馈 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.lang.String> FEEDBACK_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,FEEDBACK_ID, java.lang.String.class, "反馈", "反馈", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,USER_ID, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 时间 , 类型: java.util.Date
	*/
	public static final String RECORD_TIME="recordTime";
	
	/**
	 * 时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.util.Date> RECORD_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,RECORD_TIME, java.util.Date.class, "时间", "时间", java.util.Date.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 照片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 照片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,PICTURE_ID, java.lang.String.class, "照片", "照片", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 用户 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER="user";
	
	/**
	 * 用户 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryFeedbackMsg,org.github.foxnic.web.domain.hrm.Employee> USER_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryFeedbackMsg.class ,USER, org.github.foxnic.web.domain.hrm.Employee.class, "用户", "用户", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , FEEDBACK_ID , USER_ID , RECORD_TIME , CONTENT , PICTURE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InventoryFeedbackMsg {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 反馈
		 * @param feedbackId 反馈
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setFeedbackId(String feedbackId) {
			super.change(FEEDBACK_ID,super.getFeedbackId(),feedbackId);
			super.setFeedbackId(feedbackId);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userId 用户
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 时间
		 * @param recordTime 时间
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setRecordTime(Date recordTime) {
			super.change(RECORD_TIME,super.getRecordTime(),recordTime);
			super.setRecordTime(recordTime);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 照片
		 * @param pictureId 照片
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param user 用户
		 * @return 当前对象
		*/
		public InventoryFeedbackMsg setUser(Employee user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public InventoryFeedbackMsg clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public InventoryFeedbackMsg duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setFeedbackId(this.getFeedbackId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setCreateBy(this.getCreateBy());
			inst.setRecordTime(this.getRecordTime());
			inst.setDeleted(this.getDeleted());
			inst.setPictureId(this.getPictureId());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setUser(this.getUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}