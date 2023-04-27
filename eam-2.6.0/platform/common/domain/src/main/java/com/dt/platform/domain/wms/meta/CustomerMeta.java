package com.dt.platform.domain.wms.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.wms.Customer;
import java.util.Date;
import com.dt.platform.domain.wms.CompanyAttr;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 12:16:10
 * @sign 150495EC6FDA69304B34031F1347101A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CustomerMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 企业属性 , 类型: java.lang.String
	*/
	public static final String COMPANY_ATTR="companyAttr";
	
	/**
	 * 企业属性 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> COMPANY_ATTR_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,COMPANY_ATTR, java.lang.String.class, "企业属性", "企业属性", java.lang.String.class, null);
	
	/**
	 * 属性 , 类型: java.lang.String
	*/
	public static final String ATTR="attr";
	
	/**
	 * 属性 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> ATTR_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,ATTR, java.lang.String.class, "属性", "属性", java.lang.String.class, null);
	
	/**
	 * 出库计费 , 类型: java.lang.String
	*/
	public static final String BILLING_METHOD="billingMethod";
	
	/**
	 * 出库计费 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> BILLING_METHOD_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,BILLING_METHOD, java.lang.String.class, "出库计费", "出库计费", java.lang.String.class, null);
	
	/**
	 * 合同号 , 类型: java.lang.String
	*/
	public static final String CONTRACT_NUMBER="contractNumber";
	
	/**
	 * 合同号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> CONTRACT_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,CONTRACT_NUMBER, java.lang.String.class, "合同号", "合同号", java.lang.String.class, null);
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CONTACTS="businessContacts";
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> BUSINESS_CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,BUSINESS_CONTACTS, java.lang.String.class, "负责人", "负责人", java.lang.String.class, null);
	
	/**
	 * 联系人 , 类型: java.lang.String
	*/
	public static final String CONTACT_INFORMATION="contactInformation";
	
	/**
	 * 联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,CONTACT_INFORMATION, java.lang.String.class, "联系人", "联系人", java.lang.String.class, null);
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> ADDRESS_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,ADDRESS, java.lang.String.class, "地址", "地址", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH="attach";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> ATTACH_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,ATTACH, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * companyAttrData , 类型: com.dt.platform.domain.wms.CompanyAttr
	*/
	public static final String COMPANY_ATTR_DATA="companyAttrData";
	
	/**
	 * companyAttrData , 类型: com.dt.platform.domain.wms.CompanyAttr
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Customer,com.dt.platform.domain.wms.CompanyAttr> COMPANY_ATTR_DATA_PROP = new BeanProperty(com.dt.platform.domain.wms.Customer.class ,COMPANY_ATTR_DATA, com.dt.platform.domain.wms.CompanyAttr.class, "companyAttrData", "companyAttrData", com.dt.platform.domain.wms.CompanyAttr.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , COMPANY_ATTR , ATTR , BILLING_METHOD , CONTRACT_NUMBER , BUSINESS_CONTACTS , CONTACT_INFORMATION , ADDRESS , ATTACH , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , COMPANY_ATTR_DATA };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.wms.Customer {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Customer setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public Customer setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public Customer setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 企业属性
		 * @param companyAttr 企业属性
		 * @return 当前对象
		*/
		public Customer setCompanyAttr(String companyAttr) {
			super.change(COMPANY_ATTR,super.getCompanyAttr(),companyAttr);
			super.setCompanyAttr(companyAttr);
			return this;
		}
		
		/**
		 * 设置 属性
		 * @param attr 属性
		 * @return 当前对象
		*/
		public Customer setAttr(String attr) {
			super.change(ATTR,super.getAttr(),attr);
			super.setAttr(attr);
			return this;
		}
		
		/**
		 * 设置 出库计费
		 * @param billingMethod 出库计费
		 * @return 当前对象
		*/
		public Customer setBillingMethod(String billingMethod) {
			super.change(BILLING_METHOD,super.getBillingMethod(),billingMethod);
			super.setBillingMethod(billingMethod);
			return this;
		}
		
		/**
		 * 设置 合同号
		 * @param contractNumber 合同号
		 * @return 当前对象
		*/
		public Customer setContractNumber(String contractNumber) {
			super.change(CONTRACT_NUMBER,super.getContractNumber(),contractNumber);
			super.setContractNumber(contractNumber);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param businessContacts 负责人
		 * @return 当前对象
		*/
		public Customer setBusinessContacts(String businessContacts) {
			super.change(BUSINESS_CONTACTS,super.getBusinessContacts(),businessContacts);
			super.setBusinessContacts(businessContacts);
			return this;
		}
		
		/**
		 * 设置 联系人
		 * @param contactInformation 联系人
		 * @return 当前对象
		*/
		public Customer setContactInformation(String contactInformation) {
			super.change(CONTACT_INFORMATION,super.getContactInformation(),contactInformation);
			super.setContactInformation(contactInformation);
			return this;
		}
		
		/**
		 * 设置 地址
		 * @param address 地址
		 * @return 当前对象
		*/
		public Customer setAddress(String address) {
			super.change(ADDRESS,super.getAddress(),address);
			super.setAddress(address);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attach 附件
		 * @return 当前对象
		*/
		public Customer setAttach(String attach) {
			super.change(ATTACH,super.getAttach(),attach);
			super.setAttach(attach);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Customer setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Customer setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Customer setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Customer setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Customer setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Customer setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Customer setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Customer setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Customer setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Customer setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 companyAttrData
		 * @param companyAttrData companyAttrData
		 * @return 当前对象
		*/
		public Customer setCompanyAttrData(CompanyAttr companyAttrData) {
			super.change(COMPANY_ATTR_DATA,super.getCompanyAttrData(),companyAttrData);
			super.setCompanyAttrData(companyAttrData);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public Customer clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public Customer duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setBusinessContacts(this.getBusinessContacts());
			inst.setAddress(this.getAddress());
			inst.setNotes(this.getNotes());
			inst.setCompanyAttr(this.getCompanyAttr());
			inst.setBillingMethod(this.getBillingMethod());
			inst.setContractNumber(this.getContractNumber());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setContactInformation(this.getContactInformation());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setAttach(this.getAttach());
			inst.setAttr(this.getAttr());
			if(all) {
				inst.setCompanyAttrData(this.getCompanyAttrData());
			}
			inst.clearModifies();
			return inst;
		}

	}
}