package com.dt.platform.domain.mobile.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.mobile.SoftwareInfo;
import java.util.Date;
import com.dt.platform.domain.mobile.SoftwareGroup;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-06-26 15:08:05
 * @sign C170D094570A633894C317289C0DDE3A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SoftwareInfoMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 软件组 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 软件组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,GROUP_ID, java.lang.String.class, "软件组", "软件组", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 软件版本 , 类型: java.lang.String
	*/
	public static final String SOFTWARE_VERSION="softwareVersion";
	
	/**
	 * 软件版本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> SOFTWARE_VERSION_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,SOFTWARE_VERSION, java.lang.String.class, "软件版本", "软件版本", java.lang.String.class, null);
	
	/**
	 * 图标 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 图标 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,PICTURE_ID, java.lang.String.class, "图标", "图标", java.lang.String.class, null);
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 文件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,FILE_ID, java.lang.String.class, "文件", "文件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 组 , 类型: com.dt.platform.domain.mobile.SoftwareGroup
	*/
	public static final String GROUP="group";
	
	/**
	 * 组 , 类型: com.dt.platform.domain.mobile.SoftwareGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.mobile.SoftwareInfo,com.dt.platform.domain.mobile.SoftwareGroup> GROUP_PROP = new BeanProperty(com.dt.platform.domain.mobile.SoftwareInfo.class ,GROUP, com.dt.platform.domain.mobile.SoftwareGroup.class, "组", "组", com.dt.platform.domain.mobile.SoftwareGroup.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , GROUP_ID , NAME , STATUS , TYPE , SOFTWARE_VERSION , PICTURE_ID , FILE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , GROUP };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.mobile.SoftwareInfo {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SoftwareInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public SoftwareInfo setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 软件组
		 * @param groupId 软件组
		 * @return 当前对象
		*/
		public SoftwareInfo setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public SoftwareInfo setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public SoftwareInfo setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public SoftwareInfo setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 软件版本
		 * @param softwareVersion 软件版本
		 * @return 当前对象
		*/
		public SoftwareInfo setSoftwareVersion(String softwareVersion) {
			super.change(SOFTWARE_VERSION,super.getSoftwareVersion(),softwareVersion);
			super.setSoftwareVersion(softwareVersion);
			return this;
		}
		
		/**
		 * 设置 图标
		 * @param pictureId 图标
		 * @return 当前对象
		*/
		public SoftwareInfo setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 文件
		 * @param fileId 文件
		 * @return 当前对象
		*/
		public SoftwareInfo setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SoftwareInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SoftwareInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SoftwareInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SoftwareInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SoftwareInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SoftwareInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SoftwareInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SoftwareInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public SoftwareInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SoftwareInfo setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 组
		 * @param group 组
		 * @return 当前对象
		*/
		public SoftwareInfo setGroup(SoftwareGroup group) {
			super.change(GROUP,super.getGroup(),group);
			super.setGroup(group);
			return this;
		}
	}
}