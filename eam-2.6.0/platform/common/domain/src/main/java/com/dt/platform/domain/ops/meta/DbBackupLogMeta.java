package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.DbBackupLog;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-31 23:12:44
 * @sign ED0A2147E506B4059E040CCF26F0F0E9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DbBackupLogMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * UID , 类型: java.lang.String
	*/
	public static final String UID="uid";
	
	/**
	 * UID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> UID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,UID, java.lang.String.class, "UID", "UID", java.lang.String.class, null);
	
	/**
	 * 数据库实例 , 类型: java.lang.String
	*/
	public static final String DB_ID="dbId";
	
	/**
	 * 数据库实例 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> DB_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,DB_ID, java.lang.String.class, "数据库实例", "数据库实例", java.lang.String.class, null);
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final String IP="ip";
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> IP_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,IP, java.lang.String.class, "IP", "IP", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String DB_NAME="dbName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> DB_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,DB_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 动作 , 类型: java.lang.String
	*/
	public static final String ACTION="action";
	
	/**
	 * 动作 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> ACTION_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,ACTION, java.lang.String.class, "动作", "动作", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 方式 , 类型: java.lang.String
	*/
	public static final String METHOD="method";
	
	/**
	 * 方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,METHOD, java.lang.String.class, "方式", "方式", java.lang.String.class, null);
	
	/**
	 * 结果 , 类型: java.lang.String
	*/
	public static final String RESULT="result";
	
	/**
	 * 结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> RESULT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,RESULT, java.lang.String.class, "结果", "结果", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String STIME="stime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.util.Date> STIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,STIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String ETIME="etime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.util.Date> ETIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,ETIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 大小 , 类型: java.math.BigDecimal
	*/
	public static final String SIZE="size";
	
	/**
	 * 大小 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.math.BigDecimal> SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,SIZE, java.math.BigDecimal.class, "大小", "大小", java.math.BigDecimal.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String RECORD_TIME="recordTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.util.Date> RECORD_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,RECORD_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 原始数据 , 类型: java.lang.String
	*/
	public static final String SOURCE="source";
	
	/**
	 * 原始数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,SOURCE, java.lang.String.class, "原始数据", "原始数据", java.lang.String.class, null);
	
	/**
	 * 处理状态 , 类型: java.lang.String
	*/
	public static final String PROCESSED="processed";
	
	/**
	 * 处理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> PROCESSED_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,PROCESSED, java.lang.String.class, "处理状态", "处理状态", java.lang.String.class, null);
	
	/**
	 * 处理结果 , 类型: java.lang.String
	*/
	public static final String PROCESS_RESULT="processResult";
	
	/**
	 * 处理结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> PROCESS_RESULT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,PROCESS_RESULT, java.lang.String.class, "处理结果", "处理结果", java.lang.String.class, null);
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final String LAST_PROCESS_TIME="lastProcessTime";
	
	/**
	 * 处理时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.util.Date> LAST_PROCESS_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,LAST_PROCESS_TIME, java.util.Date.class, "处理时间", "处理时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupLog,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupLog.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , UID , DB_ID , IP , DB_NAME , ACTION , STATUS , METHOD , RESULT , STIME , ETIME , SIZE , NOTES , RECORD_TIME , SOURCE , PROCESSED , PROCESS_RESULT , LAST_PROCESS_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.DbBackupLog {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DbBackupLog setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 UID
		 * @param uid UID
		 * @return 当前对象
		*/
		public DbBackupLog setUid(String uid) {
			super.change(UID,super.getUid(),uid);
			super.setUid(uid);
			return this;
		}
		
		/**
		 * 设置 数据库实例
		 * @param dbId 数据库实例
		 * @return 当前对象
		*/
		public DbBackupLog setDbId(String dbId) {
			super.change(DB_ID,super.getDbId(),dbId);
			super.setDbId(dbId);
			return this;
		}
		
		/**
		 * 设置 IP
		 * @param ip IP
		 * @return 当前对象
		*/
		public DbBackupLog setIp(String ip) {
			super.change(IP,super.getIp(),ip);
			super.setIp(ip);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param dbName 名称
		 * @return 当前对象
		*/
		public DbBackupLog setDbName(String dbName) {
			super.change(DB_NAME,super.getDbName(),dbName);
			super.setDbName(dbName);
			return this;
		}
		
		/**
		 * 设置 动作
		 * @param action 动作
		 * @return 当前对象
		*/
		public DbBackupLog setAction(String action) {
			super.change(ACTION,super.getAction(),action);
			super.setAction(action);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public DbBackupLog setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 方式
		 * @param method 方式
		 * @return 当前对象
		*/
		public DbBackupLog setMethod(String method) {
			super.change(METHOD,super.getMethod(),method);
			super.setMethod(method);
			return this;
		}
		
		/**
		 * 设置 结果
		 * @param result 结果
		 * @return 当前对象
		*/
		public DbBackupLog setResult(String result) {
			super.change(RESULT,super.getResult(),result);
			super.setResult(result);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param stime 开始时间
		 * @return 当前对象
		*/
		public DbBackupLog setStime(Date stime) {
			super.change(STIME,super.getStime(),stime);
			super.setStime(stime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param etime 结束时间
		 * @return 当前对象
		*/
		public DbBackupLog setEtime(Date etime) {
			super.change(ETIME,super.getEtime(),etime);
			super.setEtime(etime);
			return this;
		}
		
		/**
		 * 设置 大小
		 * @param size 大小
		 * @return 当前对象
		*/
		public DbBackupLog setSize(BigDecimal size) {
			super.change(SIZE,super.getSize(),size);
			super.setSize(size);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public DbBackupLog setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param recordTime 记录时间
		 * @return 当前对象
		*/
		public DbBackupLog setRecordTime(Date recordTime) {
			super.change(RECORD_TIME,super.getRecordTime(),recordTime);
			super.setRecordTime(recordTime);
			return this;
		}
		
		/**
		 * 设置 原始数据
		 * @param source 原始数据
		 * @return 当前对象
		*/
		public DbBackupLog setSource(String source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 处理状态
		 * @param processed 处理状态
		 * @return 当前对象
		*/
		public DbBackupLog setProcessed(String processed) {
			super.change(PROCESSED,super.getProcessed(),processed);
			super.setProcessed(processed);
			return this;
		}
		
		/**
		 * 设置 处理结果
		 * @param processResult 处理结果
		 * @return 当前对象
		*/
		public DbBackupLog setProcessResult(String processResult) {
			super.change(PROCESS_RESULT,super.getProcessResult(),processResult);
			super.setProcessResult(processResult);
			return this;
		}
		
		/**
		 * 设置 处理时间
		 * @param lastProcessTime 处理时间
		 * @return 当前对象
		*/
		public DbBackupLog setLastProcessTime(Date lastProcessTime) {
			super.change(LAST_PROCESS_TIME,super.getLastProcessTime(),lastProcessTime);
			super.setLastProcessTime(lastProcessTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DbBackupLog setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DbBackupLog setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DbBackupLog setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DbBackupLog setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DbBackupLog setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DbBackupLog setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DbBackupLog setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DbBackupLog setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public DbBackupLog clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public DbBackupLog duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setDbName(this.getDbName());
			inst.setStime(this.getStime());
			inst.setSource(this.getSource());
			inst.setResult(this.getResult());
			inst.setUid(this.getUid());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setLastProcessTime(this.getLastProcessTime());
			inst.setDbId(this.getDbId());
			inst.setAction(this.getAction());
			inst.setId(this.getId());
			inst.setMethod(this.getMethod());
			inst.setIp(this.getIp());
			inst.setProcessResult(this.getProcessResult());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setProcessed(this.getProcessed());
			inst.setCreateBy(this.getCreateBy());
			inst.setRecordTime(this.getRecordTime());
			inst.setDeleted(this.getDeleted());
			inst.setSize(this.getSize());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setEtime(this.getEtime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setStatus(this.getStatus());
			inst.clearModifies();
			return inst;
		}

	}
}