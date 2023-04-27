package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.AutoModuleRoleItem;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:04:25
 * @sign 775263D162566BC1372FE92414B2F6AC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AutoModuleRoleItemMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoModuleRoleItem,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.AutoModuleRoleItem.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 模块 , 类型: java.lang.String
	*/
	public static final String MODULE_ROLE_ID="moduleRoleId";
	
	/**
	 * 模块 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoModuleRoleItem,java.lang.String> MODULE_ROLE_ID_PROP = new BeanProperty(com.dt.platform.domain.common.AutoModuleRoleItem.class ,MODULE_ROLE_ID, java.lang.String.class, "模块", "模块", java.lang.String.class, null);
	
	/**
	 * 角色 , 类型: java.lang.String
	*/
	public static final String ROLE_ID="roleId";
	
	/**
	 * 角色 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoModuleRoleItem,java.lang.String> ROLE_ID_PROP = new BeanProperty(com.dt.platform.domain.common.AutoModuleRoleItem.class ,ROLE_ID, java.lang.String.class, "角色", "角色", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String ROLE_NAME="roleName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoModuleRoleItem,java.lang.String> ROLE_NAME_PROP = new BeanProperty(com.dt.platform.domain.common.AutoModuleRoleItem.class ,ROLE_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoModuleRoleItem,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.AutoModuleRoleItem.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoModuleRoleItem,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.AutoModuleRoleItem.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoModuleRoleItem,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.AutoModuleRoleItem.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoModuleRoleItem,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.AutoModuleRoleItem.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoModuleRoleItem,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.AutoModuleRoleItem.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoModuleRoleItem,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.AutoModuleRoleItem.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoModuleRoleItem,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.AutoModuleRoleItem.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , MODULE_ROLE_ID , ROLE_ID , ROLE_NAME , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.AutoModuleRoleItem {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AutoModuleRoleItem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 模块
		 * @param moduleRoleId 模块
		 * @return 当前对象
		*/
		public AutoModuleRoleItem setModuleRoleId(String moduleRoleId) {
			super.change(MODULE_ROLE_ID,super.getModuleRoleId(),moduleRoleId);
			super.setModuleRoleId(moduleRoleId);
			return this;
		}
		
		/**
		 * 设置 角色
		 * @param roleId 角色
		 * @return 当前对象
		*/
		public AutoModuleRoleItem setRoleId(String roleId) {
			super.change(ROLE_ID,super.getRoleId(),roleId);
			super.setRoleId(roleId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param roleName 名称
		 * @return 当前对象
		*/
		public AutoModuleRoleItem setRoleName(String roleName) {
			super.change(ROLE_NAME,super.getRoleName(),roleName);
			super.setRoleName(roleName);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AutoModuleRoleItem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AutoModuleRoleItem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AutoModuleRoleItem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AutoModuleRoleItem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AutoModuleRoleItem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AutoModuleRoleItem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AutoModuleRoleItem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AutoModuleRoleItem clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AutoModuleRoleItem duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setRoleId(this.getRoleId());
			inst.setRoleName(this.getRoleName());
			inst.setModuleRoleId(this.getModuleRoleId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setId(this.getId());
			inst.setVersion(this.getVersion());
			inst.clearModifies();
			return inst;
		}

	}
}