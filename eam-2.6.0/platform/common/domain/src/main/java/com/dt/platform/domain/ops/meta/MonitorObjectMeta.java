package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.MonitorObject;
import java.util.Date;
import com.dt.platform.domain.ops.MonitorObjectGroup;
import com.dt.platform.domain.ops.MonitorObjectModel;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-10 09:04:00
 * @sign 3D8604B49BC7A3E3F5BA0BD0E53C2E9C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MonitorObjectMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 模型 , 类型: java.lang.String
	*/
	public static final String OBJECT_MODEL_ID="objectModelId";
	
	/**
	 * 模型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,java.lang.String> OBJECT_MODEL_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,OBJECT_MODEL_ID, java.lang.String.class, "模型", "模型", java.lang.String.class, null);
	
	/**
	 * 分组 , 类型: java.lang.String
	*/
	public static final String GROUP_CODE="groupCode";
	
	/**
	 * 分组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,java.lang.String> GROUP_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,GROUP_CODE, java.lang.String.class, "分组", "分组", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final String IP="ip";
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,java.lang.String> IP_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,IP, java.lang.String.class, "IP", "IP", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * group , 类型: com.dt.platform.domain.ops.MonitorObjectGroup
	*/
	public static final String GROUP="group";
	
	/**
	 * group , 类型: com.dt.platform.domain.ops.MonitorObjectGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,com.dt.platform.domain.ops.MonitorObjectGroup> GROUP_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,GROUP, com.dt.platform.domain.ops.MonitorObjectGroup.class, "group", "group", com.dt.platform.domain.ops.MonitorObjectGroup.class, null);
	
	/**
	 * objectModel , 类型: com.dt.platform.domain.ops.MonitorObjectModel
	*/
	public static final String OBJECT_MODEL="objectModel";
	
	/**
	 * objectModel , 类型: com.dt.platform.domain.ops.MonitorObjectModel
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.MonitorObject,com.dt.platform.domain.ops.MonitorObjectModel> OBJECT_MODEL_PROP = new BeanProperty(com.dt.platform.domain.ops.MonitorObject.class ,OBJECT_MODEL, com.dt.platform.domain.ops.MonitorObjectModel.class, "objectModel", "objectModel", com.dt.platform.domain.ops.MonitorObjectModel.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , OBJECT_MODEL_ID , GROUP_CODE , NAME , IP , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , GROUP , OBJECT_MODEL };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.MonitorObject {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MonitorObject setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 模型
		 * @param objectModelId 模型
		 * @return 当前对象
		*/
		public MonitorObject setObjectModelId(String objectModelId) {
			super.change(OBJECT_MODEL_ID,super.getObjectModelId(),objectModelId);
			super.setObjectModelId(objectModelId);
			return this;
		}
		
		/**
		 * 设置 分组
		 * @param groupCode 分组
		 * @return 当前对象
		*/
		public MonitorObject setGroupCode(String groupCode) {
			super.change(GROUP_CODE,super.getGroupCode(),groupCode);
			super.setGroupCode(groupCode);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public MonitorObject setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 IP
		 * @param ip IP
		 * @return 当前对象
		*/
		public MonitorObject setIp(String ip) {
			super.change(IP,super.getIp(),ip);
			super.setIp(ip);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MonitorObject setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MonitorObject setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MonitorObject setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MonitorObject setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MonitorObject setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MonitorObject setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MonitorObject setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public MonitorObject setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 group
		 * @param group group
		 * @return 当前对象
		*/
		public MonitorObject setGroup(MonitorObjectGroup group) {
			super.change(GROUP,super.getGroup(),group);
			super.setGroup(group);
			return this;
		}
		
		/**
		 * 设置 objectModel
		 * @param objectModel objectModel
		 * @return 当前对象
		*/
		public MonitorObject setObjectModel(MonitorObjectModel objectModel) {
			super.change(OBJECT_MODEL,super.getObjectModel(),objectModel);
			super.setObjectModel(objectModel);
			return this;
		}
	}
}