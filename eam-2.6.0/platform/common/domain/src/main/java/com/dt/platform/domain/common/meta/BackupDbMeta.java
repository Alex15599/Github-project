package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.BackupDb;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 17:48:39
 * @sign F42E15D2FBB98DDFB93A7C78C11F3D7F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class BackupDbMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String DB_NAME="dbName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.lang.String> DB_NAME_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,DB_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 备份文件 , 类型: java.lang.String
	*/
	public static final String FILE_ROUTE="fileRoute";
	
	/**
	 * 备份文件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.lang.String> FILE_ROUTE_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,FILE_ROUTE, java.lang.String.class, "备份文件", "备份文件", java.lang.String.class, null);
	
	/**
	 * 大小 , 类型: java.math.BigDecimal
	*/
	public static final String FILE_SIZE="fileSize";
	
	/**
	 * 大小 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.math.BigDecimal> FILE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,FILE_SIZE, java.math.BigDecimal.class, "大小", "大小", java.math.BigDecimal.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String START_TIME="startTime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.util.Date> START_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,START_TIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String END_TIME="endTime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.util.Date> END_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,END_TIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 失效日期 , 类型: java.util.Date
	*/
	public static final String INVALID_TIME="invalidTime";
	
	/**
	 * 失效日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.util.Date> INVALID_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,INVALID_TIME, java.util.Date.class, "失效日期", "失效日期", java.util.Date.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,CONTENT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.BackupDb,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.BackupDb.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , DB_NAME , STATUS , FILE_ROUTE , FILE_SIZE , START_TIME , END_TIME , INVALID_TIME , CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.BackupDb {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public BackupDb setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param dbName 名称
		 * @return 当前对象
		*/
		public BackupDb setDbName(String dbName) {
			super.change(DB_NAME,super.getDbName(),dbName);
			super.setDbName(dbName);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public BackupDb setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 备份文件
		 * @param fileRoute 备份文件
		 * @return 当前对象
		*/
		public BackupDb setFileRoute(String fileRoute) {
			super.change(FILE_ROUTE,super.getFileRoute(),fileRoute);
			super.setFileRoute(fileRoute);
			return this;
		}
		
		/**
		 * 设置 大小
		 * @param fileSize 大小
		 * @return 当前对象
		*/
		public BackupDb setFileSize(BigDecimal fileSize) {
			super.change(FILE_SIZE,super.getFileSize(),fileSize);
			super.setFileSize(fileSize);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param startTime 开始时间
		 * @return 当前对象
		*/
		public BackupDb setStartTime(Date startTime) {
			super.change(START_TIME,super.getStartTime(),startTime);
			super.setStartTime(startTime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param endTime 结束时间
		 * @return 当前对象
		*/
		public BackupDb setEndTime(Date endTime) {
			super.change(END_TIME,super.getEndTime(),endTime);
			super.setEndTime(endTime);
			return this;
		}
		
		/**
		 * 设置 失效日期
		 * @param invalidTime 失效日期
		 * @return 当前对象
		*/
		public BackupDb setInvalidTime(Date invalidTime) {
			super.change(INVALID_TIME,super.getInvalidTime(),invalidTime);
			super.setInvalidTime(invalidTime);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param content 内容
		 * @return 当前对象
		*/
		public BackupDb setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public BackupDb setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public BackupDb setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public BackupDb setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public BackupDb setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public BackupDb setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public BackupDb setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public BackupDb setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public BackupDb setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public BackupDb setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public BackupDb clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public BackupDb duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setDbName(this.getDbName());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setInvalidTime(this.getInvalidTime());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setFileSize(this.getFileSize());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setStartTime(this.getStartTime());
			inst.setId(this.getId());
			inst.setEndTime(this.getEndTime());
			inst.setFileRoute(this.getFileRoute());
			inst.setStatus(this.getStatus());
			inst.clearModifies();
			return inst;
		}

	}
}