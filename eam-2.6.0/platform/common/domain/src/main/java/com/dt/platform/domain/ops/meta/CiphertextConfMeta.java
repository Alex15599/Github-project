package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.CiphertextConf;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.ops.CiphertextBox;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-19 10:33:43
 * @sign EE37BE31FB05DF29B18FCE15A04CF9BC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CiphertextConfMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String BOX_ID="boxId";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,java.lang.String> BOX_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,BOX_ID, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,USER_ID, java.lang.String.class, "人员", "人员", java.lang.String.class, null);
	
	/**
	 * 解密权限 , 类型: java.lang.String
	*/
	public static final String DECRYPTION_PERM_STATUS="decryptionPermStatus";
	
	/**
	 * 解密权限 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,java.lang.String> DECRYPTION_PERM_STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,DECRYPTION_PERM_STATUS, java.lang.String.class, "解密权限", "解密权限", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER="user";
	
	/**
	 * 人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,org.github.foxnic.web.domain.hrm.Employee> USER_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,USER, org.github.foxnic.web.domain.hrm.Employee.class, "人员", "人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 密码箱 , 类型: com.dt.platform.domain.ops.CiphertextBox
	*/
	public static final String BOX="box";
	
	/**
	 * 密码箱 , 类型: com.dt.platform.domain.ops.CiphertextBox
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CiphertextConf,com.dt.platform.domain.ops.CiphertextBox> BOX_PROP = new BeanProperty(com.dt.platform.domain.ops.CiphertextConf.class ,BOX, com.dt.platform.domain.ops.CiphertextBox.class, "密码箱", "密码箱", com.dt.platform.domain.ops.CiphertextBox.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BOX_ID , USER_ID , DECRYPTION_PERM_STATUS , NOTES , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , USER , BOX };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.CiphertextConf {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CiphertextConf setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param boxId 类型
		 * @return 当前对象
		*/
		public CiphertextConf setBoxId(String boxId) {
			super.change(BOX_ID,super.getBoxId(),boxId);
			super.setBoxId(boxId);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param userId 人员
		 * @return 当前对象
		*/
		public CiphertextConf setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 解密权限
		 * @param decryptionPermStatus 解密权限
		 * @return 当前对象
		*/
		public CiphertextConf setDecryptionPermStatus(String decryptionPermStatus) {
			super.change(DECRYPTION_PERM_STATUS,super.getDecryptionPermStatus(),decryptionPermStatus);
			super.setDecryptionPermStatus(decryptionPermStatus);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CiphertextConf setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CiphertextConf setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CiphertextConf setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CiphertextConf setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CiphertextConf setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CiphertextConf setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CiphertextConf setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CiphertextConf setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param user 人员
		 * @return 当前对象
		*/
		public CiphertextConf setUser(Employee user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}
		
		/**
		 * 设置 密码箱
		 * @param box 密码箱
		 * @return 当前对象
		*/
		public CiphertextConf setBox(CiphertextBox box) {
			super.change(BOX,super.getBox(),box);
			super.setBox(box);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CiphertextConf clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CiphertextConf duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDecryptionPermStatus(this.getDecryptionPermStatus());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setId(this.getId());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setBoxId(this.getBoxId());
			if(all) {
				inst.setBox(this.getBox());
				inst.setUser(this.getUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}