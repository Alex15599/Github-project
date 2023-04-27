package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.DeployStandard;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-03 09:20:27
 * @sign 3E3431D39D801242F23A072336914039
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DeployStandardMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE_ID="typeId";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> TYPE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,TYPE_ID, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 用户标准 , 类型: java.lang.String
	*/
	public static final String USER_CONTENT="userContent";
	
	/**
	 * 用户标准 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> USER_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,USER_CONTENT, java.lang.String.class, "用户标准", "用户标准", java.lang.String.class, null);
	
	/**
	 * 目录标准 , 类型: java.lang.String
	*/
	public static final String DIR_CONTENT="dirContent";
	
	/**
	 * 目录标准 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> DIR_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,DIR_CONTENT, java.lang.String.class, "目录标准", "目录标准", java.lang.String.class, null);
	
	/**
	 * 部署标准 , 类型: java.lang.String
	*/
	public static final String DEPLOY_CONTENT="deployContent";
	
	/**
	 * 部署标准 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> DEPLOY_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,DEPLOY_CONTENT, java.lang.String.class, "部署标准", "部署标准", java.lang.String.class, null);
	
	/**
	 * 实例标准 , 类型: java.lang.String
	*/
	public static final String CREATE_DB_CONTENT="createDbContent";
	
	/**
	 * 实例标准 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> CREATE_DB_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,CREATE_DB_CONTENT, java.lang.String.class, "实例标准", "实例标准", java.lang.String.class, null);
	
	/**
	 * 日常维护 , 类型: java.lang.String
	*/
	public static final String MAINTENANCE_CONTENT="maintenanceContent";
	
	/**
	 * 日常维护 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> MAINTENANCE_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,MAINTENANCE_CONTENT, java.lang.String.class, "日常维护", "日常维护", java.lang.String.class, null);
	
	/**
	 * 备份脚本 , 类型: java.lang.String
	*/
	public static final String BACKUP_SCRIPT="backupScript";
	
	/**
	 * 备份脚本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> BACKUP_SCRIPT_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,BACKUP_SCRIPT, java.lang.String.class, "备份脚本", "备份脚本", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.String
	*/
	public static final String RELEASE_VERSION="releaseVersion";
	
	/**
	 * 版本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> RELEASE_VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,RELEASE_VERSION, java.lang.String.class, "版本", "版本", java.lang.String.class, null);
	
	/**
	 * 附件人 , 类型: java.lang.String
	*/
	public static final String ATTACH_ID="attachId";
	
	/**
	 * 附件人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> ATTACH_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,ATTACH_ID, java.lang.String.class, "附件人", "附件人", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandard,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandard.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , TYPE_ID , USER_CONTENT , DIR_CONTENT , DEPLOY_CONTENT , CREATE_DB_CONTENT , MAINTENANCE_CONTENT , BACKUP_SCRIPT , RELEASE_VERSION , ATTACH_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.DeployStandard {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DeployStandard setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public DeployStandard setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param typeId 类型
		 * @return 当前对象
		*/
		public DeployStandard setTypeId(String typeId) {
			super.change(TYPE_ID,super.getTypeId(),typeId);
			super.setTypeId(typeId);
			return this;
		}
		
		/**
		 * 设置 用户标准
		 * @param userContent 用户标准
		 * @return 当前对象
		*/
		public DeployStandard setUserContent(String userContent) {
			super.change(USER_CONTENT,super.getUserContent(),userContent);
			super.setUserContent(userContent);
			return this;
		}
		
		/**
		 * 设置 目录标准
		 * @param dirContent 目录标准
		 * @return 当前对象
		*/
		public DeployStandard setDirContent(String dirContent) {
			super.change(DIR_CONTENT,super.getDirContent(),dirContent);
			super.setDirContent(dirContent);
			return this;
		}
		
		/**
		 * 设置 部署标准
		 * @param deployContent 部署标准
		 * @return 当前对象
		*/
		public DeployStandard setDeployContent(String deployContent) {
			super.change(DEPLOY_CONTENT,super.getDeployContent(),deployContent);
			super.setDeployContent(deployContent);
			return this;
		}
		
		/**
		 * 设置 实例标准
		 * @param createDbContent 实例标准
		 * @return 当前对象
		*/
		public DeployStandard setCreateDbContent(String createDbContent) {
			super.change(CREATE_DB_CONTENT,super.getCreateDbContent(),createDbContent);
			super.setCreateDbContent(createDbContent);
			return this;
		}
		
		/**
		 * 设置 日常维护
		 * @param maintenanceContent 日常维护
		 * @return 当前对象
		*/
		public DeployStandard setMaintenanceContent(String maintenanceContent) {
			super.change(MAINTENANCE_CONTENT,super.getMaintenanceContent(),maintenanceContent);
			super.setMaintenanceContent(maintenanceContent);
			return this;
		}
		
		/**
		 * 设置 备份脚本
		 * @param backupScript 备份脚本
		 * @return 当前对象
		*/
		public DeployStandard setBackupScript(String backupScript) {
			super.change(BACKUP_SCRIPT,super.getBackupScript(),backupScript);
			super.setBackupScript(backupScript);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param releaseVersion 版本
		 * @return 当前对象
		*/
		public DeployStandard setReleaseVersion(String releaseVersion) {
			super.change(RELEASE_VERSION,super.getReleaseVersion(),releaseVersion);
			super.setReleaseVersion(releaseVersion);
			return this;
		}
		
		/**
		 * 设置 附件人
		 * @param attachId 附件人
		 * @return 当前对象
		*/
		public DeployStandard setAttachId(String attachId) {
			super.change(ATTACH_ID,super.getAttachId(),attachId);
			super.setAttachId(attachId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public DeployStandard setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DeployStandard setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DeployStandard setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DeployStandard setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DeployStandard setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DeployStandard setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DeployStandard setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DeployStandard setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DeployStandard setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public DeployStandard setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public DeployStandard clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public DeployStandard duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setReleaseVersion(this.getReleaseVersion());
			inst.setMaintenanceContent(this.getMaintenanceContent());
			inst.setDeployContent(this.getDeployContent());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateDbContent(this.getCreateDbContent());
			inst.setBackupScript(this.getBackupScript());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setUserContent(this.getUserContent());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setTypeId(this.getTypeId());
			inst.setId(this.getId());
			inst.setDirContent(this.getDirContent());
			inst.setAttachId(this.getAttachId());
			inst.clearModifies();
			return inst;
		}

	}
}