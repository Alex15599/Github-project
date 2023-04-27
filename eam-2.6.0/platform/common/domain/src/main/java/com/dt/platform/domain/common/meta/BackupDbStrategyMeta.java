package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.BackupDbStrategy;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-26 18:37:10
 * @sign 2F2C941E661ED24949134E7265B3B92A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class BackupDbStrategyMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 启用状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 启用状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,STATUS, java.lang.String.class, "启用状态", "启用状态", java.lang.String.class, null);
	
	/**
	 * 备份路径 , 类型: java.lang.String
	*/
	public static final String DATA_PATH="dataPath";
	
	/**
	 * 备份路径 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.lang.String> DATA_PATH_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,DATA_PATH, java.lang.String.class, "备份路径", "备份路径", java.lang.String.class, null);
	
	/**
	 * 备份保留 , 类型: java.lang.Integer
	*/
	public static final String DATA_KEEP="dataKeep";
	
	/**
	 * 备份保留 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.lang.Integer> DATA_KEEP_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,DATA_KEEP, java.lang.Integer.class, "备份保留", "备份保留", java.lang.Integer.class, null);
	
	/**
	 * 备份周期 , 类型: java.lang.String
	*/
	public static final String CRONTAB="crontab";
	
	/**
	 * 备份周期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.lang.String> CRONTAB_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,CRONTAB, java.lang.String.class, "备份周期", "备份周期", java.lang.String.class, null);
	
	/**
	 * 邮件 , 类型: java.lang.String
	*/
	public static final String MAIL="mail";
	
	/**
	 * 邮件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.lang.String> MAIL_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,MAIL, java.lang.String.class, "邮件", "邮件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDbStrategy,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDbStrategy.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , STATUS , DATA_PATH , DATA_KEEP , CRONTAB , MAIL , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.BackupDbStrategy {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public BackupDbStrategy setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 启用状态
		 * @param status 启用状态
		 * @return 当前对象
		*/
		public BackupDbStrategy setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 备份路径
		 * @param dataPath 备份路径
		 * @return 当前对象
		*/
		public BackupDbStrategy setDataPath(String dataPath) {
			super.change(DATA_PATH,super.getDataPath(),dataPath);
			super.setDataPath(dataPath);
			return this;
		}
		
		/**
		 * 设置 备份保留
		 * @param dataKeep 备份保留
		 * @return 当前对象
		*/
		public BackupDbStrategy setDataKeep(Integer dataKeep) {
			super.change(DATA_KEEP,super.getDataKeep(),dataKeep);
			super.setDataKeep(dataKeep);
			return this;
		}
		
		/**
		 * 设置 备份周期
		 * @param crontab 备份周期
		 * @return 当前对象
		*/
		public BackupDbStrategy setCrontab(String crontab) {
			super.change(CRONTAB,super.getCrontab(),crontab);
			super.setCrontab(crontab);
			return this;
		}
		
		/**
		 * 设置 邮件
		 * @param mail 邮件
		 * @return 当前对象
		*/
		public BackupDbStrategy setMail(String mail) {
			super.change(MAIL,super.getMail(),mail);
			super.setMail(mail);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public BackupDbStrategy setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public BackupDbStrategy setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public BackupDbStrategy setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public BackupDbStrategy setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public BackupDbStrategy setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public BackupDbStrategy setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public BackupDbStrategy setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public BackupDbStrategy setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public BackupDbStrategy setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public BackupDbStrategy clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public BackupDbStrategy duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setMail(this.getMail());
			inst.setCrontab(this.getCrontab());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setDataPath(this.getDataPath());
			inst.setDataKeep(this.getDataKeep());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			inst.clearModifies();
			return inst;
		}

	}
}