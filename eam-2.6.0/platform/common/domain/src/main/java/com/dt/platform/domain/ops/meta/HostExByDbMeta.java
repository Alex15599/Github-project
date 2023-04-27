package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.HostExByDb;
import java.util.Date;
import com.dt.platform.domain.ops.Host;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-11 16:23:26
 * @sign 176E629ADDBB67FFD795B61E96B1E8AA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class HostExByDbMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostExByDb,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.HostExByDb.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 主机 , 类型: java.lang.String
	*/
	public static final String HOST_ID="hostId";
	
	/**
	 * 主机 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostExByDb,java.lang.String> HOST_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.HostExByDb.class ,HOST_ID, java.lang.String.class, "主机", "主机", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTE="note";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostExByDb,java.lang.String> NOTE_PROP = new BeanProperty(com.dt.platform.domain.ops.HostExByDb.class ,NOTE, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostExByDb,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.HostExByDb.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostExByDb,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.HostExByDb.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostExByDb,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.HostExByDb.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostExByDb,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.HostExByDb.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostExByDb,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.HostExByDb.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostExByDb,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.HostExByDb.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostExByDb,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.HostExByDb.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostExByDb,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.HostExByDb.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostExByDb,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.HostExByDb.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * host , 类型: com.dt.platform.domain.ops.Host
	*/
	public static final String HOST="host";
	
	/**
	 * host , 类型: com.dt.platform.domain.ops.Host
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.HostExByDb,com.dt.platform.domain.ops.Host> HOST_PROP = new BeanProperty(com.dt.platform.domain.ops.HostExByDb.class ,HOST, com.dt.platform.domain.ops.Host.class, "host", "host", com.dt.platform.domain.ops.Host.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , HOST_ID , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , HOST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.HostExByDb {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public HostExByDb setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 主机
		 * @param hostId 主机
		 * @return 当前对象
		*/
		public HostExByDb setHostId(String hostId) {
			super.change(HOST_ID,super.getHostId(),hostId);
			super.setHostId(hostId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param note 备注
		 * @return 当前对象
		*/
		public HostExByDb setNote(String note) {
			super.change(NOTE,super.getNote(),note);
			super.setNote(note);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public HostExByDb setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public HostExByDb setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public HostExByDb setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public HostExByDb setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public HostExByDb setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public HostExByDb setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public HostExByDb setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public HostExByDb setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public HostExByDb setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 host
		 * @param host host
		 * @return 当前对象
		*/
		public HostExByDb setHost(Host host) {
			super.change(HOST,super.getHost(),host);
			super.setHost(host);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public HostExByDb clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public HostExByDb duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNote(this.getNote());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setHostId(this.getHostId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setId(this.getId());
			inst.setVersion(this.getVersion());
			if(all) {
				inst.setHost(this.getHost());
			}
			inst.clearModifies();
			return inst;
		}

	}
}