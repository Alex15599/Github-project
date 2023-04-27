package com.dt.platform.domain.wms;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.WmsTables.WMS_CUSTOMER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.wms.meta.CustomerMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 客户
 * <p>客户 , 数据表 wms_customer 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 12:16:10
 * @sign 150495EC6FDA69304B34031F1347101A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "wms_customer")
@ApiModel(description = "客户 ; 客户 , 数据表 wms_customer 的PO类型")
public class Customer extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WMS_CUSTOMER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 企业属性：企业属性
	*/
	@ApiModelProperty(required = false,value="企业属性" , notes = "企业属性")
	private String companyAttr;
	
	/**
	 * 属性：属性
	*/
	@ApiModelProperty(required = false,value="属性" , notes = "属性")
	private String attr;
	
	/**
	 * 出库计费：出库计费
	*/
	@ApiModelProperty(required = false,value="出库计费" , notes = "出库计费")
	private String billingMethod;
	
	/**
	 * 合同号：合同号
	*/
	@ApiModelProperty(required = false,value="合同号" , notes = "合同号")
	private String contractNumber;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private String businessContacts;
	
	/**
	 * 联系人：联系人
	*/
	@ApiModelProperty(required = false,value="联系人" , notes = "联系人")
	private String contactInformation;
	
	/**
	 * 地址：地址
	*/
	@ApiModelProperty(required = false,value="地址" , notes = "地址")
	private String address;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attach;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * companyAttrData：companyAttrData
	*/
	@ApiModelProperty(required = false,value="companyAttrData" , notes = "companyAttrData")
	private CompanyAttr companyAttrData;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public Customer setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	public Customer setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public Customer setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 企业属性<br>
	 * 企业属性
	 * @return 企业属性
	*/
	public String getCompanyAttr() {
		return companyAttr;
	}
	
	/**
	 * 设置 企业属性
	 * @param companyAttr 企业属性
	 * @return 当前对象
	*/
	public Customer setCompanyAttr(String companyAttr) {
		this.companyAttr=companyAttr;
		return this;
	}
	
	/**
	 * 获得 属性<br>
	 * 属性
	 * @return 属性
	*/
	public String getAttr() {
		return attr;
	}
	
	/**
	 * 设置 属性
	 * @param attr 属性
	 * @return 当前对象
	*/
	public Customer setAttr(String attr) {
		this.attr=attr;
		return this;
	}
	
	/**
	 * 获得 出库计费<br>
	 * 出库计费
	 * @return 出库计费
	*/
	public String getBillingMethod() {
		return billingMethod;
	}
	
	/**
	 * 设置 出库计费
	 * @param billingMethod 出库计费
	 * @return 当前对象
	*/
	public Customer setBillingMethod(String billingMethod) {
		this.billingMethod=billingMethod;
		return this;
	}
	
	/**
	 * 获得 合同号<br>
	 * 合同号
	 * @return 合同号
	*/
	public String getContractNumber() {
		return contractNumber;
	}
	
	/**
	 * 设置 合同号
	 * @param contractNumber 合同号
	 * @return 当前对象
	*/
	public Customer setContractNumber(String contractNumber) {
		this.contractNumber=contractNumber;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public String getBusinessContacts() {
		return businessContacts;
	}
	
	/**
	 * 设置 负责人
	 * @param businessContacts 负责人
	 * @return 当前对象
	*/
	public Customer setBusinessContacts(String businessContacts) {
		this.businessContacts=businessContacts;
		return this;
	}
	
	/**
	 * 获得 联系人<br>
	 * 联系人
	 * @return 联系人
	*/
	public String getContactInformation() {
		return contactInformation;
	}
	
	/**
	 * 设置 联系人
	 * @param contactInformation 联系人
	 * @return 当前对象
	*/
	public Customer setContactInformation(String contactInformation) {
		this.contactInformation=contactInformation;
		return this;
	}
	
	/**
	 * 获得 地址<br>
	 * 地址
	 * @return 地址
	*/
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置 地址
	 * @param address 地址
	 * @return 当前对象
	*/
	public Customer setAddress(String address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttach() {
		return attach;
	}
	
	/**
	 * 设置 附件
	 * @param attach 附件
	 * @return 当前对象
	*/
	public Customer setAttach(String attach) {
		this.attach=attach;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public Customer setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public Customer setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public Customer setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public Customer setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public Customer setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public Customer setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public Customer setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public Customer setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public Customer setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public Customer setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public Customer setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 companyAttrData<br>
	 * companyAttrData
	 * @return companyAttrData
	*/
	public CompanyAttr getCompanyAttrData() {
		return companyAttrData;
	}
	
	/**
	 * 设置 companyAttrData
	 * @param companyAttrData companyAttrData
	 * @return 当前对象
	*/
	public Customer setCompanyAttrData(CompanyAttr companyAttrData) {
		this.companyAttrData=companyAttrData;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Customer , 转换好的 Customer 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Customer , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
		com.dt.platform.domain.wms.meta.CustomerMeta.$$proxy$$ inst = new com.dt.platform.domain.wms.meta.CustomerMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Customer clone(boolean deep) {
		return EntityContext.clone(Customer.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Customer
	 * @param customerMap 包含实体信息的 Map 对象
	 * @return Customer , 转换好的的 Customer 对象
	*/
	@Transient
	public static Customer createFrom(Map<String,Object> customerMap) {
		if(customerMap==null) return null;
		Customer po = create();
		EntityContext.copyProperties(po,customerMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Customer
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Customer , 转换好的的 Customer 对象
	*/
	@Transient
	public static Customer createFrom(Object pojo) {
		if(pojo==null) return null;
		Customer po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Customer，等同于 new
	 * @return Customer 对象
	*/
	@Transient
	public static Customer create() {
		return new com.dt.platform.domain.wms.meta.CustomerMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setCode(DataParser.parse(String.class, map.get(CustomerMeta.CODE)));
			this.setBusinessContacts(DataParser.parse(String.class, map.get(CustomerMeta.BUSINESS_CONTACTS)));
			this.setAddress(DataParser.parse(String.class, map.get(CustomerMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, map.get(CustomerMeta.NOTES)));
			this.setCompanyAttr(DataParser.parse(String.class, map.get(CustomerMeta.COMPANY_ATTR)));
			this.setBillingMethod(DataParser.parse(String.class, map.get(CustomerMeta.BILLING_METHOD)));
			this.setContractNumber(DataParser.parse(String.class, map.get(CustomerMeta.CONTRACT_NUMBER)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CustomerMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CustomerMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CustomerMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(CustomerMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CustomerMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CustomerMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CustomerMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CustomerMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(CustomerMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CustomerMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CustomerMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CustomerMeta.ID)));
			this.setAttach(DataParser.parse(String.class, map.get(CustomerMeta.ATTACH)));
			this.setAttr(DataParser.parse(String.class, map.get(CustomerMeta.ATTR)));
			// others
			this.setCompanyAttrData(DataParser.parse(CompanyAttr.class, map.get(CustomerMeta.COMPANY_ATTR_DATA)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(CustomerMeta.CODE));
				this.setBusinessContacts( (String)map.get(CustomerMeta.BUSINESS_CONTACTS));
				this.setAddress( (String)map.get(CustomerMeta.ADDRESS));
				this.setNotes( (String)map.get(CustomerMeta.NOTES));
				this.setCompanyAttr( (String)map.get(CustomerMeta.COMPANY_ATTR));
				this.setBillingMethod( (String)map.get(CustomerMeta.BILLING_METHOD));
				this.setContractNumber( (String)map.get(CustomerMeta.CONTRACT_NUMBER));
				this.setUpdateTime( (Date)map.get(CustomerMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(CustomerMeta.VERSION));
				this.setCreateBy( (String)map.get(CustomerMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(CustomerMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)map.get(CustomerMeta.DELETED));
				this.setCreateTime( (Date)map.get(CustomerMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CustomerMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CustomerMeta.DELETE_TIME));
				this.setName( (String)map.get(CustomerMeta.NAME));
				this.setTenantId( (String)map.get(CustomerMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CustomerMeta.DELETE_BY));
				this.setId( (String)map.get(CustomerMeta.ID));
				this.setAttach( (String)map.get(CustomerMeta.ATTACH));
				this.setAttr( (String)map.get(CustomerMeta.ATTR));
				// others
				this.setCompanyAttrData( (CompanyAttr)map.get(CustomerMeta.COMPANY_ATTR_DATA));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setCode(DataParser.parse(String.class, r.getValue(CustomerMeta.CODE)));
			this.setBusinessContacts(DataParser.parse(String.class, r.getValue(CustomerMeta.BUSINESS_CONTACTS)));
			this.setAddress(DataParser.parse(String.class, r.getValue(CustomerMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, r.getValue(CustomerMeta.NOTES)));
			this.setCompanyAttr(DataParser.parse(String.class, r.getValue(CustomerMeta.COMPANY_ATTR)));
			this.setBillingMethod(DataParser.parse(String.class, r.getValue(CustomerMeta.BILLING_METHOD)));
			this.setContractNumber(DataParser.parse(String.class, r.getValue(CustomerMeta.CONTRACT_NUMBER)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CustomerMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CustomerMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CustomerMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(CustomerMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CustomerMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CustomerMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CustomerMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CustomerMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(CustomerMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CustomerMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CustomerMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CustomerMeta.ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(CustomerMeta.ATTACH)));
			this.setAttr(DataParser.parse(String.class, r.getValue(CustomerMeta.ATTR)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(CustomerMeta.CODE));
				this.setBusinessContacts( (String)r.getValue(CustomerMeta.BUSINESS_CONTACTS));
				this.setAddress( (String)r.getValue(CustomerMeta.ADDRESS));
				this.setNotes( (String)r.getValue(CustomerMeta.NOTES));
				this.setCompanyAttr( (String)r.getValue(CustomerMeta.COMPANY_ATTR));
				this.setBillingMethod( (String)r.getValue(CustomerMeta.BILLING_METHOD));
				this.setContractNumber( (String)r.getValue(CustomerMeta.CONTRACT_NUMBER));
				this.setUpdateTime( (Date)r.getValue(CustomerMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(CustomerMeta.VERSION));
				this.setCreateBy( (String)r.getValue(CustomerMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(CustomerMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)r.getValue(CustomerMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CustomerMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CustomerMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CustomerMeta.DELETE_TIME));
				this.setName( (String)r.getValue(CustomerMeta.NAME));
				this.setTenantId( (String)r.getValue(CustomerMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CustomerMeta.DELETE_BY));
				this.setId( (String)r.getValue(CustomerMeta.ID));
				this.setAttach( (String)r.getValue(CustomerMeta.ATTACH));
				this.setAttr( (String)r.getValue(CustomerMeta.ATTR));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}