package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.SystemConsoleInfo;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import java.util.List;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-04 07:30:04
 * @sign 297D1438577A3CE9A934AE1C45DDCEC2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SystemConsoleInfoMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 环境 , 类型: java.lang.String
	*/
	public static final String ENV="env";
	
	/**
	 * 环境 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.lang.String> ENV_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,ENV, java.lang.String.class, "环境", "环境", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.lang.String> ADDRESS_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,ADDRESS, java.lang.String.class, "地址", "地址", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 类型 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String TYPE_DICT="typeDict";
	
	/**
	 * 类型 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,org.github.foxnic.web.domain.system.DictItem> TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,TYPE_DICT, java.util.List.class, "类型", "类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 环境 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String ENV_DICT="envDict";
	
	/**
	 * 环境 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SystemConsoleInfo,org.github.foxnic.web.domain.system.DictItem> ENV_DICT_PROP = new BeanProperty(com.dt.platform.domain.ops.SystemConsoleInfo.class ,ENV_DICT, java.util.List.class, "环境", "环境", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TYPE , ENV , STATUS , NAME , ADDRESS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , TYPE_DICT , ENV_DICT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.SystemConsoleInfo {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SystemConsoleInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public SystemConsoleInfo setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 环境
		 * @param env 环境
		 * @return 当前对象
		*/
		public SystemConsoleInfo setEnv(String env) {
			super.change(ENV,super.getEnv(),env);
			super.setEnv(env);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public SystemConsoleInfo setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public SystemConsoleInfo setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 地址
		 * @param address 地址
		 * @return 当前对象
		*/
		public SystemConsoleInfo setAddress(String address) {
			super.change(ADDRESS,super.getAddress(),address);
			super.setAddress(address);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SystemConsoleInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SystemConsoleInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SystemConsoleInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SystemConsoleInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SystemConsoleInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SystemConsoleInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SystemConsoleInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SystemConsoleInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public SystemConsoleInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SystemConsoleInfo setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param typeDict 类型
		 * @return 当前对象
		*/
		public SystemConsoleInfo setTypeDict(List<DictItem> typeDict) {
			super.change(TYPE_DICT,super.getTypeDict(),typeDict);
			super.setTypeDict(typeDict);
			return this;
		}
		
		/**
		 * 设置 环境
		 * @param envDict 环境
		 * @return 当前对象
		*/
		public SystemConsoleInfo setEnvDict(List<DictItem> envDict) {
			super.change(ENV_DICT,super.getEnvDict(),envDict);
			super.setEnvDict(envDict);
			return this;
		}
	}
}