package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.AutoRoleGrantRcd;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:19:24
 * @sign 6AB3253CA1F8EC103A00869FB568B73E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AutoRoleGrantRcdMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoRoleGrantRcd,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.AutoRoleGrantRcd.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 模块 , 类型: java.lang.String
	*/
	public static final String MODULE_ROLE_ID="moduleRoleId";
	
	/**
	 * 模块 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoRoleGrantRcd,java.lang.String> MODULE_ROLE_ID_PROP = new BeanProperty(com.dt.platform.domain.common.AutoRoleGrantRcd.class ,MODULE_ROLE_ID, java.lang.String.class, "模块", "模块", java.lang.String.class, null);
	
	/**
	 * 角色 , 类型: java.lang.String
	*/
	public static final String ROLE_ID="roleId";
	
	/**
	 * 角色 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoRoleGrantRcd,java.lang.String> ROLE_ID_PROP = new BeanProperty(com.dt.platform.domain.common.AutoRoleGrantRcd.class ,ROLE_ID, java.lang.String.class, "角色", "角色", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoRoleGrantRcd,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.common.AutoRoleGrantRcd.class ,USER_ID, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoRoleGrantRcd,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.AutoRoleGrantRcd.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoRoleGrantRcd,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.AutoRoleGrantRcd.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoRoleGrantRcd,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.AutoRoleGrantRcd.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoRoleGrantRcd,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.AutoRoleGrantRcd.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoRoleGrantRcd,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.AutoRoleGrantRcd.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoRoleGrantRcd,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.AutoRoleGrantRcd.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoRoleGrantRcd,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.AutoRoleGrantRcd.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoRoleGrantRcd,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.AutoRoleGrantRcd.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER="user";
	
	/**
	 * 人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.common.AutoRoleGrantRcd,org.github.foxnic.web.domain.hrm.Employee> USER_PROP = new BeanProperty(com.dt.platform.domain.common.AutoRoleGrantRcd.class ,USER, org.github.foxnic.web.domain.hrm.Employee.class, "人员", "人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , MODULE_ROLE_ID , ROLE_ID , USER_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.AutoRoleGrantRcd {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AutoRoleGrantRcd setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 模块
		 * @param moduleRoleId 模块
		 * @return 当前对象
		*/
		public AutoRoleGrantRcd setModuleRoleId(String moduleRoleId) {
			super.change(MODULE_ROLE_ID,super.getModuleRoleId(),moduleRoleId);
			super.setModuleRoleId(moduleRoleId);
			return this;
		}
		
		/**
		 * 设置 角色
		 * @param roleId 角色
		 * @return 当前对象
		*/
		public AutoRoleGrantRcd setRoleId(String roleId) {
			super.change(ROLE_ID,super.getRoleId(),roleId);
			super.setRoleId(roleId);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userId 用户
		 * @return 当前对象
		*/
		public AutoRoleGrantRcd setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AutoRoleGrantRcd setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AutoRoleGrantRcd setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AutoRoleGrantRcd setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AutoRoleGrantRcd setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AutoRoleGrantRcd setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AutoRoleGrantRcd setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AutoRoleGrantRcd setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public AutoRoleGrantRcd setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 人员
		 * @param user 人员
		 * @return 当前对象
		*/
		public AutoRoleGrantRcd setUser(Employee user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AutoRoleGrantRcd clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AutoRoleGrantRcd duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setRoleId(this.getRoleId());
			inst.setModuleRoleId(this.getModuleRoleId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setId(this.getId());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			if(all) {
				inst.setUser(this.getUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}