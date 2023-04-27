package com.dt.platform.domain.hr.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.hr.Certificate;
import java.util.Date;
import com.dt.platform.domain.hr.CertificateType;
import com.dt.platform.domain.hr.CertificateLevel;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 09:46:20
 * @sign 9621AE2F0BC3A7EC845F244DD3688AA3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CertificateMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 级别 , 类型: java.lang.String
	*/
	public static final String CERT_LEVEL="certLevel";
	
	/**
	 * 级别 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.lang.String> CERT_LEVEL_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,CERT_LEVEL, java.lang.String.class, "级别", "级别", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.String
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.lang.String> SORT_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,SORT, java.lang.String.class, "排序", "排序", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTE="note";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.lang.String> NOTE_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,NOTE, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * certificateType , 类型: com.dt.platform.domain.hr.CertificateType
	*/
	public static final String CERTIFICATE_TYPE="certificateType";
	
	/**
	 * certificateType , 类型: com.dt.platform.domain.hr.CertificateType
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,com.dt.platform.domain.hr.CertificateType> CERTIFICATE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,CERTIFICATE_TYPE, com.dt.platform.domain.hr.CertificateType.class, "certificateType", "certificateType", com.dt.platform.domain.hr.CertificateType.class, null);
	
	/**
	 * certificateLevel , 类型: com.dt.platform.domain.hr.CertificateLevel
	*/
	public static final String CERTIFICATE_LEVEL="certificateLevel";
	
	/**
	 * certificateLevel , 类型: com.dt.platform.domain.hr.CertificateLevel
	*/
	public static final BeanProperty<com.dt.platform.domain.hr.Certificate,com.dt.platform.domain.hr.CertificateLevel> CERTIFICATE_LEVEL_PROP = new BeanProperty(com.dt.platform.domain.hr.Certificate.class ,CERTIFICATE_LEVEL, com.dt.platform.domain.hr.CertificateLevel.class, "certificateLevel", "certificateLevel", com.dt.platform.domain.hr.CertificateLevel.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TYPE , CERT_LEVEL , NAME , SORT , NOTE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CERTIFICATE_TYPE , CERTIFICATE_LEVEL };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.hr.Certificate {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Certificate setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public Certificate setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 级别
		 * @param certLevel 级别
		 * @return 当前对象
		*/
		public Certificate setCertLevel(String certLevel) {
			super.change(CERT_LEVEL,super.getCertLevel(),certLevel);
			super.setCertLevel(certLevel);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public Certificate setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public Certificate setSort(String sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param note 备注
		 * @return 当前对象
		*/
		public Certificate setNote(String note) {
			super.change(NOTE,super.getNote(),note);
			super.setNote(note);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Certificate setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Certificate setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Certificate setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Certificate setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Certificate setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Certificate setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Certificate setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Certificate setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Certificate setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 certificateType
		 * @param certificateType certificateType
		 * @return 当前对象
		*/
		public Certificate setCertificateType(CertificateType certificateType) {
			super.change(CERTIFICATE_TYPE,super.getCertificateType(),certificateType);
			super.setCertificateType(certificateType);
			return this;
		}
		
		/**
		 * 设置 certificateLevel
		 * @param certificateLevel certificateLevel
		 * @return 当前对象
		*/
		public Certificate setCertificateLevel(CertificateLevel certificateLevel) {
			super.change(CERTIFICATE_LEVEL,super.getCertificateLevel(),certificateLevel);
			super.setCertificateLevel(certificateLevel);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public Certificate clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public Certificate duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNote(this.getNote());
			inst.setCertLevel(this.getCertLevel());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSort(this.getSort());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			if(all) {
				inst.setCertificateLevel(this.getCertificateLevel());
				inst.setCertificateType(this.getCertificateType());
			}
			inst.clearModifies();
			return inst;
		}

	}
}