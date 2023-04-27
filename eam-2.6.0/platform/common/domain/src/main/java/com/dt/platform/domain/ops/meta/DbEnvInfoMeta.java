package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.DbEnvInfo;
import java.util.Date;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.DbInfo;
import com.dt.platform.domain.ops.CiphertextBoxData;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-01 20:41:05
 * @sign B50C221069FBD2774BE243AB8D7D3831
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DbEnvInfoMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABEL="label";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.String> LABEL_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,LABEL, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DB_INST_ID="dbInstId";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.String> DB_INST_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,DB_INST_ID, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DB="db";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.String> DB_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,DB, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final String IP="ip";
	
	/**
	 * IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.String> IP_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,IP, java.lang.String.class, "IP", "IP", java.lang.String.class, null);
	
	/**
	 * 凭证 , 类型: java.lang.String
	*/
	public static final String VOUCHER="voucher";
	
	/**
	 * 凭证 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.String> VOUCHER_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,VOUCHER, java.lang.String.class, "凭证", "凭证", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * host , 类型: com.dt.platform.domain.ops.Host
	*/
	public static final String HOST="host";
	
	/**
	 * host , 类型: com.dt.platform.domain.ops.Host
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,com.dt.platform.domain.ops.Host> HOST_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,HOST, com.dt.platform.domain.ops.Host.class, "host", "host", com.dt.platform.domain.ops.Host.class, null);
	
	/**
	 * hostName , 类型: java.lang.String
	*/
	public static final String HOST_NAME="hostName";
	
	/**
	 * hostName , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.String> HOST_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,HOST_NAME, java.lang.String.class, "hostName", "hostName", java.lang.String.class, null);
	
	/**
	 * hostIp , 类型: java.lang.String
	*/
	public static final String HOST_IP="hostIp";
	
	/**
	 * hostIp , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.String> HOST_IP_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,HOST_IP, java.lang.String.class, "hostIp", "hostIp", java.lang.String.class, null);
	
	/**
	 * dbInfo , 类型: com.dt.platform.domain.ops.DbInfo
	*/
	public static final String DB_INFO="dbInfo";
	
	/**
	 * dbInfo , 类型: com.dt.platform.domain.ops.DbInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,com.dt.platform.domain.ops.DbInfo> DB_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,DB_INFO, com.dt.platform.domain.ops.DbInfo.class, "dbInfo", "dbInfo", com.dt.platform.domain.ops.DbInfo.class, null);
	
	/**
	 * dbName , 类型: java.lang.String
	*/
	public static final String DB_NAME="dbName";
	
	/**
	 * dbName , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,java.lang.String> DB_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,DB_NAME, java.lang.String.class, "dbName", "dbName", java.lang.String.class, null);
	
	/**
	 * ciphertextBoxData , 类型: com.dt.platform.domain.ops.CiphertextBoxData
	*/
	public static final String CIPHERTEXT_BOX_DATA="ciphertextBoxData";
	
	/**
	 * ciphertextBoxData , 类型: com.dt.platform.domain.ops.CiphertextBoxData
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbEnvInfo,com.dt.platform.domain.ops.CiphertextBoxData> CIPHERTEXT_BOX_DATA_PROP = new BeanProperty(com.dt.platform.domain.ops.DbEnvInfo.class ,CIPHERTEXT_BOX_DATA, com.dt.platform.domain.ops.CiphertextBoxData.class, "ciphertextBoxData", "ciphertextBoxData", com.dt.platform.domain.ops.CiphertextBoxData.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , LABEL , DB_INST_ID , DB , IP , VOUCHER , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , HOST , HOST_NAME , HOST_IP , DB_INFO , DB_NAME , CIPHERTEXT_BOX_DATA };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.DbEnvInfo {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DbEnvInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param label 标签
		 * @return 当前对象
		*/
		public DbEnvInfo setLabel(String label) {
			super.change(LABEL,super.getLabel(),label);
			super.setLabel(label);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param dbInstId 数据库
		 * @return 当前对象
		*/
		public DbEnvInfo setDbInstId(String dbInstId) {
			super.change(DB_INST_ID,super.getDbInstId(),dbInstId);
			super.setDbInstId(dbInstId);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param db 数据库
		 * @return 当前对象
		*/
		public DbEnvInfo setDb(String db) {
			super.change(DB,super.getDb(),db);
			super.setDb(db);
			return this;
		}
		
		/**
		 * 设置 IP
		 * @param ip IP
		 * @return 当前对象
		*/
		public DbEnvInfo setIp(String ip) {
			super.change(IP,super.getIp(),ip);
			super.setIp(ip);
			return this;
		}
		
		/**
		 * 设置 凭证
		 * @param voucher 凭证
		 * @return 当前对象
		*/
		public DbEnvInfo setVoucher(String voucher) {
			super.change(VOUCHER,super.getVoucher(),voucher);
			super.setVoucher(voucher);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public DbEnvInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DbEnvInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DbEnvInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DbEnvInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DbEnvInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DbEnvInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DbEnvInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DbEnvInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DbEnvInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 host
		 * @param host host
		 * @return 当前对象
		*/
		public DbEnvInfo setHost(Host host) {
			super.change(HOST,super.getHost(),host);
			super.setHost(host);
			return this;
		}
		
		/**
		 * 设置 hostName
		 * @param hostName hostName
		 * @return 当前对象
		*/
		public DbEnvInfo setHostName(String hostName) {
			super.change(HOST_NAME,super.getHostName(),hostName);
			super.setHostName(hostName);
			return this;
		}
		
		/**
		 * 设置 hostIp
		 * @param hostIp hostIp
		 * @return 当前对象
		*/
		public DbEnvInfo setHostIp(String hostIp) {
			super.change(HOST_IP,super.getHostIp(),hostIp);
			super.setHostIp(hostIp);
			return this;
		}
		
		/**
		 * 设置 dbInfo
		 * @param dbInfo dbInfo
		 * @return 当前对象
		*/
		public DbEnvInfo setDbInfo(DbInfo dbInfo) {
			super.change(DB_INFO,super.getDbInfo(),dbInfo);
			super.setDbInfo(dbInfo);
			return this;
		}
		
		/**
		 * 设置 dbName
		 * @param dbName dbName
		 * @return 当前对象
		*/
		public DbEnvInfo setDbName(String dbName) {
			super.change(DB_NAME,super.getDbName(),dbName);
			super.setDbName(dbName);
			return this;
		}
		
		/**
		 * 设置 ciphertextBoxData
		 * @param ciphertextBoxData ciphertextBoxData
		 * @return 当前对象
		*/
		public DbEnvInfo setCiphertextBoxData(CiphertextBoxData ciphertextBoxData) {
			super.change(CIPHERTEXT_BOX_DATA,super.getCiphertextBoxData(),ciphertextBoxData);
			super.setCiphertextBoxData(ciphertextBoxData);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public DbEnvInfo clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public DbEnvInfo duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setVoucher(this.getVoucher());
			inst.setIp(this.getIp());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setLabel(this.getLabel());
			inst.setVersion(this.getVersion());
			inst.setDbInstId(this.getDbInstId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setDb(this.getDb());
			if(all) {
				inst.setDbInfo(this.getDbInfo());
				inst.setHostName(this.getHostName());
				inst.setHostIp(this.getHostIp());
				inst.setDbName(this.getDbName());
				inst.setHost(this.getHost());
				inst.setCiphertextBoxData(this.getCiphertextBoxData());
			}
			inst.clearModifies();
			return inst;
		}

	}
}