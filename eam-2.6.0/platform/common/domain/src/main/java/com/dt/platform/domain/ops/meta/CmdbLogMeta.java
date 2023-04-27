package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.CmdbLog;
import java.util.Date;
import com.dt.platform.domain.ops.CmdbModelV;
import com.dt.platform.domain.ops.CmdbModel;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-22 14:18:35
 * @sign AFE5466156DF66E422094AA8D9608777
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CmdbLogMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 模型 , 类型: java.lang.String
	*/
	public static final String MODEL_ID="modelId";
	
	/**
	 * 模型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.lang.String> MODEL_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,MODEL_ID, java.lang.String.class, "模型", "模型", java.lang.String.class, null);
	
	/**
	 * 对象 , 类型: java.lang.String
	*/
	public static final String OBJ_ID="objId";
	
	/**
	 * 对象 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.lang.String> OBJ_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,OBJ_ID, java.lang.String.class, "对象", "对象", java.lang.String.class, null);
	
	/**
	 * 日志级别 , 类型: java.lang.String
	*/
	public static final String LOG_LEVEL="logLevel";
	
	/**
	 * 日志级别 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.lang.String> LOG_LEVEL_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,LOG_LEVEL, java.lang.String.class, "日志级别", "日志级别", java.lang.String.class, null);
	
	/**
	 * TRACE , 类型: java.lang.String
	*/
	public static final String TRACE_ID="traceId";
	
	/**
	 * TRACE , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.lang.String> TRACE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,TRACE_ID, java.lang.String.class, "TRACE", "TRACE", java.lang.String.class, null);
	
	/**
	 * 日志 , 类型: java.lang.String
	*/
	public static final String LOG_RECORD="logRecord";
	
	/**
	 * 日志 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.lang.String> LOG_RECORD_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,LOG_RECORD, java.lang.String.class, "日志", "日志", java.lang.String.class, null);
	
	/**
	 * 时间 , 类型: java.util.Date
	*/
	public static final String RCD_TIME="rcdTime";
	
	/**
	 * 时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.util.Date> RCD_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,RCD_TIME, java.util.Date.class, "时间", "时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * cmdbModelV , 类型: com.dt.platform.domain.ops.CmdbModelV
	*/
	public static final String CMDB_MODEL_V="cmdbModelV";
	
	/**
	 * cmdbModelV , 类型: com.dt.platform.domain.ops.CmdbModelV
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,com.dt.platform.domain.ops.CmdbModelV> CMDB_MODEL_V_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,CMDB_MODEL_V, com.dt.platform.domain.ops.CmdbModelV.class, "cmdbModelV", "cmdbModelV", com.dt.platform.domain.ops.CmdbModelV.class, null);
	
	/**
	 * cmdbModel , 类型: com.dt.platform.domain.ops.CmdbModel
	*/
	public static final String CMDB_MODEL="cmdbModel";
	
	/**
	 * cmdbModel , 类型: com.dt.platform.domain.ops.CmdbModel
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbLog,com.dt.platform.domain.ops.CmdbModel> CMDB_MODEL_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbLog.class ,CMDB_MODEL, com.dt.platform.domain.ops.CmdbModel.class, "cmdbModel", "cmdbModel", com.dt.platform.domain.ops.CmdbModel.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , MODEL_ID , OBJ_ID , LOG_LEVEL , TRACE_ID , LOG_RECORD , RCD_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CMDB_MODEL_V , CMDB_MODEL };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.CmdbLog {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CmdbLog setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 模型
		 * @param modelId 模型
		 * @return 当前对象
		*/
		public CmdbLog setModelId(String modelId) {
			super.change(MODEL_ID,super.getModelId(),modelId);
			super.setModelId(modelId);
			return this;
		}
		
		/**
		 * 设置 对象
		 * @param objId 对象
		 * @return 当前对象
		*/
		public CmdbLog setObjId(String objId) {
			super.change(OBJ_ID,super.getObjId(),objId);
			super.setObjId(objId);
			return this;
		}
		
		/**
		 * 设置 日志级别
		 * @param logLevel 日志级别
		 * @return 当前对象
		*/
		public CmdbLog setLogLevel(String logLevel) {
			super.change(LOG_LEVEL,super.getLogLevel(),logLevel);
			super.setLogLevel(logLevel);
			return this;
		}
		
		/**
		 * 设置 TRACE
		 * @param traceId TRACE
		 * @return 当前对象
		*/
		public CmdbLog setTraceId(String traceId) {
			super.change(TRACE_ID,super.getTraceId(),traceId);
			super.setTraceId(traceId);
			return this;
		}
		
		/**
		 * 设置 日志
		 * @param logRecord 日志
		 * @return 当前对象
		*/
		public CmdbLog setLogRecord(String logRecord) {
			super.change(LOG_RECORD,super.getLogRecord(),logRecord);
			super.setLogRecord(logRecord);
			return this;
		}
		
		/**
		 * 设置 时间
		 * @param rcdTime 时间
		 * @return 当前对象
		*/
		public CmdbLog setRcdTime(Date rcdTime) {
			super.change(RCD_TIME,super.getRcdTime(),rcdTime);
			super.setRcdTime(rcdTime);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CmdbLog setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CmdbLog setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CmdbLog setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CmdbLog setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CmdbLog setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CmdbLog setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CmdbLog setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CmdbLog setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CmdbLog setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public CmdbLog setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 cmdbModelV
		 * @param cmdbModelV cmdbModelV
		 * @return 当前对象
		*/
		public CmdbLog setCmdbModelV(CmdbModelV cmdbModelV) {
			super.change(CMDB_MODEL_V,super.getCmdbModelV(),cmdbModelV);
			super.setCmdbModelV(cmdbModelV);
			return this;
		}
		
		/**
		 * 设置 cmdbModel
		 * @param cmdbModel cmdbModel
		 * @return 当前对象
		*/
		public CmdbLog setCmdbModel(CmdbModel cmdbModel) {
			super.change(CMDB_MODEL,super.getCmdbModel(),cmdbModel);
			super.setCmdbModel(cmdbModel);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CmdbLog clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CmdbLog duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setTraceId(this.getTraceId());
			inst.setNotes(this.getNotes());
			inst.setModelId(this.getModelId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setLogLevel(this.getLogLevel());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setObjId(this.getObjId());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setLogRecord(this.getLogRecord());
			inst.setRcdTime(this.getRcdTime());
			if(all) {
				inst.setCmdbModel(this.getCmdbModel());
				inst.setCmdbModelV(this.getCmdbModelV());
			}
			inst.clearModifies();
			return inst;
		}

	}
}