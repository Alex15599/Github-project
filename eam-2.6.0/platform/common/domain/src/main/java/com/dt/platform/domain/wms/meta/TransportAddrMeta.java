package com.dt.platform.domain.wms.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.wms.TransportAddr;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 15:06:54
 * @sign 0D8D30255A0C3F320BE1CE12B5BDF918
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class TransportAddrMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER="user";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.lang.String> USER_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,USER, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 联系人 , 类型: java.lang.String
	*/
	public static final String CONTACT="contact";
	
	/**
	 * 联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.lang.String> CONTACT_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,CONTACT, java.lang.String.class, "联系人", "联系人", java.lang.String.class, null);
	
	/**
	 * 联系电话 , 类型: java.lang.String
	*/
	public static final String MOBILE="mobile";
	
	/**
	 * 联系电话 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.lang.String> MOBILE_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,MOBILE, java.lang.String.class, "联系电话", "联系电话", java.lang.String.class, null);
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.lang.String> ADDRESS_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,ADDRESS, java.lang.String.class, "地址", "地址", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.TransportAddr,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.wms.TransportAddr.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , USER , CONTACT , MOBILE , ADDRESS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.wms.TransportAddr {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public TransportAddr setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param user 用户
		 * @return 当前对象
		*/
		public TransportAddr setUser(String user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}
		
		/**
		 * 设置 联系人
		 * @param contact 联系人
		 * @return 当前对象
		*/
		public TransportAddr setContact(String contact) {
			super.change(CONTACT,super.getContact(),contact);
			super.setContact(contact);
			return this;
		}
		
		/**
		 * 设置 联系电话
		 * @param mobile 联系电话
		 * @return 当前对象
		*/
		public TransportAddr setMobile(String mobile) {
			super.change(MOBILE,super.getMobile(),mobile);
			super.setMobile(mobile);
			return this;
		}
		
		/**
		 * 设置 地址
		 * @param address 地址
		 * @return 当前对象
		*/
		public TransportAddr setAddress(String address) {
			super.change(ADDRESS,super.getAddress(),address);
			super.setAddress(address);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public TransportAddr setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public TransportAddr setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public TransportAddr setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public TransportAddr setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public TransportAddr setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public TransportAddr setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public TransportAddr setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public TransportAddr setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public TransportAddr setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public TransportAddr setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public TransportAddr clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public TransportAddr duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setAddress(this.getAddress());
			inst.setNotes(this.getNotes());
			inst.setMobile(this.getMobile());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setContact(this.getContact());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setUser(this.getUser());
			inst.clearModifies();
			return inst;
		}

	}
}