package com.dt.platform.domain.wms;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.WmsTables.WMS_SUPPLIER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.wms.meta.SupplierMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 供应商
 * <p>供应商 , 数据表 wms_supplier 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:31:08
 * @sign 83A3A444802C13B938C6274163841093
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "wms_supplier")
@ApiModel(description = "供应商 ; 供应商 , 数据表 wms_supplier 的PO类型")
public class Supplier extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WMS_SUPPLIER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "684323862413836288")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "供应商1")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "供应商1")
	private String supplierName;
	
	/**
	 * 企业属性：企业属性
	*/
	@ApiModelProperty(required = false,value="企业属性" , notes = "企业属性")
	private String companyType;
	
	/**
	 * 商务联系人：商务联系人
	*/
	@ApiModelProperty(required = false,value="商务联系人" , notes = "商务联系人")
	private String businessContacts;
	
	/**
	 * 评级：评级
	*/
	@ApiModelProperty(required = false,value="评级" , notes = "评级")
	private String grade;
	
	/**
	 * 商务联系方式：商务联系方式
	*/
	@ApiModelProperty(required = false,value="商务联系方式" , notes = "商务联系方式")
	private String businessContactsInfo;
	
	/**
	 * 售后联系人：售后联系人
	*/
	@ApiModelProperty(required = false,value="售后联系人" , notes = "售后联系人")
	private String afterSalesContacts;
	
	/**
	 * 售后联系方式：售后联系方式
	*/
	@ApiModelProperty(required = false,value="售后联系方式" , notes = "售后联系方式")
	private String afterSalesContactsInfo;
	
	/**
	 * 统一社会信用代码：统一社会信用代码
	*/
	@ApiModelProperty(required = false,value="统一社会信用代码" , notes = "统一社会信用代码")
	private String unitCode;
	
	/**
	 * 地址：地址
	*/
	@ApiModelProperty(required = false,value="地址" , notes = "地址" , example = "供应商1")
	private String address;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String supplierNotes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-03-04 08:58:43")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-03-04 08:58:54")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "3")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * gradeDict：gradeDict
	*/
	@ApiModelProperty(required = false,value="gradeDict" , notes = "gradeDict")
	private DictItem gradeDict;
	
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
	public Supplier setId(String id) {
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
	public Supplier setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getSupplierName() {
		return supplierName;
	}
	
	/**
	 * 设置 名称
	 * @param supplierName 名称
	 * @return 当前对象
	*/
	public Supplier setSupplierName(String supplierName) {
		this.supplierName=supplierName;
		return this;
	}
	
	/**
	 * 获得 企业属性<br>
	 * 企业属性
	 * @return 企业属性
	*/
	public String getCompanyType() {
		return companyType;
	}
	
	/**
	 * 设置 企业属性
	 * @param companyType 企业属性
	 * @return 当前对象
	*/
	public Supplier setCompanyType(String companyType) {
		this.companyType=companyType;
		return this;
	}
	
	/**
	 * 获得 商务联系人<br>
	 * 商务联系人
	 * @return 商务联系人
	*/
	public String getBusinessContacts() {
		return businessContacts;
	}
	
	/**
	 * 设置 商务联系人
	 * @param businessContacts 商务联系人
	 * @return 当前对象
	*/
	public Supplier setBusinessContacts(String businessContacts) {
		this.businessContacts=businessContacts;
		return this;
	}
	
	/**
	 * 获得 评级<br>
	 * 评级
	 * @return 评级
	*/
	public String getGrade() {
		return grade;
	}
	
	/**
	 * 设置 评级
	 * @param grade 评级
	 * @return 当前对象
	*/
	public Supplier setGrade(String grade) {
		this.grade=grade;
		return this;
	}
	
	/**
	 * 获得 商务联系方式<br>
	 * 商务联系方式
	 * @return 商务联系方式
	*/
	public String getBusinessContactsInfo() {
		return businessContactsInfo;
	}
	
	/**
	 * 设置 商务联系方式
	 * @param businessContactsInfo 商务联系方式
	 * @return 当前对象
	*/
	public Supplier setBusinessContactsInfo(String businessContactsInfo) {
		this.businessContactsInfo=businessContactsInfo;
		return this;
	}
	
	/**
	 * 获得 售后联系人<br>
	 * 售后联系人
	 * @return 售后联系人
	*/
	public String getAfterSalesContacts() {
		return afterSalesContacts;
	}
	
	/**
	 * 设置 售后联系人
	 * @param afterSalesContacts 售后联系人
	 * @return 当前对象
	*/
	public Supplier setAfterSalesContacts(String afterSalesContacts) {
		this.afterSalesContacts=afterSalesContacts;
		return this;
	}
	
	/**
	 * 获得 售后联系方式<br>
	 * 售后联系方式
	 * @return 售后联系方式
	*/
	public String getAfterSalesContactsInfo() {
		return afterSalesContactsInfo;
	}
	
	/**
	 * 设置 售后联系方式
	 * @param afterSalesContactsInfo 售后联系方式
	 * @return 当前对象
	*/
	public Supplier setAfterSalesContactsInfo(String afterSalesContactsInfo) {
		this.afterSalesContactsInfo=afterSalesContactsInfo;
		return this;
	}
	
	/**
	 * 获得 统一社会信用代码<br>
	 * 统一社会信用代码
	 * @return 统一社会信用代码
	*/
	public String getUnitCode() {
		return unitCode;
	}
	
	/**
	 * 设置 统一社会信用代码
	 * @param unitCode 统一社会信用代码
	 * @return 当前对象
	*/
	public Supplier setUnitCode(String unitCode) {
		this.unitCode=unitCode;
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
	public Supplier setAddress(String address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getSupplierNotes() {
		return supplierNotes;
	}
	
	/**
	 * 设置 备注
	 * @param supplierNotes 备注
	 * @return 当前对象
	*/
	public Supplier setSupplierNotes(String supplierNotes) {
		this.supplierNotes=supplierNotes;
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
	public Supplier setCreateBy(String createBy) {
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
	public Supplier setCreateTime(Date createTime) {
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
	public Supplier setUpdateBy(String updateBy) {
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
	public Supplier setUpdateTime(Date updateTime) {
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
	public Supplier setDeleted(Integer deleted) {
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
	public Supplier setDeleted(Boolean deletedBool) {
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
	public Supplier setDeleteBy(String deleteBy) {
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
	public Supplier setDeleteTime(Date deleteTime) {
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
	public Supplier setVersion(Integer version) {
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
	public Supplier setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 gradeDict<br>
	 * gradeDict
	 * @return gradeDict
	*/
	public DictItem getGradeDict() {
		return gradeDict;
	}
	
	/**
	 * 设置 gradeDict
	 * @param gradeDict gradeDict
	 * @return 当前对象
	*/
	public Supplier setGradeDict(DictItem gradeDict) {
		this.gradeDict=gradeDict;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Supplier , 转换好的 Supplier 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Supplier , 转换好的 PoJo 对象
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
	public Supplier clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Supplier duplicate(boolean all) {
		com.dt.platform.domain.wms.meta.SupplierMeta.$$proxy$$ inst = new com.dt.platform.domain.wms.meta.SupplierMeta.$$proxy$$();
		inst.setSupplierName(this.getSupplierName());
		inst.setBusinessContactsInfo(this.getBusinessContactsInfo());
		inst.setCode(this.getCode());
		inst.setBusinessContacts(this.getBusinessContacts());
		inst.setAddress(this.getAddress());
		inst.setAfterSalesContacts(this.getAfterSalesContacts());
		inst.setCompanyType(this.getCompanyType());
		inst.setSupplierNotes(this.getSupplierNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setAfterSalesContactsInfo(this.getAfterSalesContactsInfo());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setGrade(this.getGrade());
		inst.setUnitCode(this.getUnitCode());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setGradeDict(this.getGradeDict());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Supplier clone(boolean deep) {
		return EntityContext.clone(Supplier.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Supplier
	 * @param supplierMap 包含实体信息的 Map 对象
	 * @return Supplier , 转换好的的 Supplier 对象
	*/
	@Transient
	public static Supplier createFrom(Map<String,Object> supplierMap) {
		if(supplierMap==null) return null;
		Supplier po = create();
		EntityContext.copyProperties(po,supplierMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Supplier
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Supplier , 转换好的的 Supplier 对象
	*/
	@Transient
	public static Supplier createFrom(Object pojo) {
		if(pojo==null) return null;
		Supplier po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Supplier，等同于 new
	 * @return Supplier 对象
	*/
	@Transient
	public static Supplier create() {
		return new com.dt.platform.domain.wms.meta.SupplierMeta.$$proxy$$();
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
			this.setSupplierName(DataParser.parse(String.class, map.get(SupplierMeta.SUPPLIER_NAME)));
			this.setBusinessContactsInfo(DataParser.parse(String.class, map.get(SupplierMeta.BUSINESS_CONTACTS_INFO)));
			this.setCode(DataParser.parse(String.class, map.get(SupplierMeta.CODE)));
			this.setBusinessContacts(DataParser.parse(String.class, map.get(SupplierMeta.BUSINESS_CONTACTS)));
			this.setAddress(DataParser.parse(String.class, map.get(SupplierMeta.ADDRESS)));
			this.setAfterSalesContacts(DataParser.parse(String.class, map.get(SupplierMeta.AFTER_SALES_CONTACTS)));
			this.setCompanyType(DataParser.parse(String.class, map.get(SupplierMeta.COMPANY_TYPE)));
			this.setSupplierNotes(DataParser.parse(String.class, map.get(SupplierMeta.SUPPLIER_NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(SupplierMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(SupplierMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(SupplierMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(SupplierMeta.DELETED)));
			this.setAfterSalesContactsInfo(DataParser.parse(String.class, map.get(SupplierMeta.AFTER_SALES_CONTACTS_INFO)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(SupplierMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(SupplierMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(SupplierMeta.DELETE_TIME)));
			this.setGrade(DataParser.parse(String.class, map.get(SupplierMeta.GRADE)));
			this.setUnitCode(DataParser.parse(String.class, map.get(SupplierMeta.UNIT_CODE)));
			this.setTenantId(DataParser.parse(String.class, map.get(SupplierMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(SupplierMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(SupplierMeta.ID)));
			// others
			this.setGradeDict(DataParser.parse(DictItem.class, map.get(SupplierMeta.GRADE_DICT)));
			return true;
		} else {
			try {
				this.setSupplierName( (String)map.get(SupplierMeta.SUPPLIER_NAME));
				this.setBusinessContactsInfo( (String)map.get(SupplierMeta.BUSINESS_CONTACTS_INFO));
				this.setCode( (String)map.get(SupplierMeta.CODE));
				this.setBusinessContacts( (String)map.get(SupplierMeta.BUSINESS_CONTACTS));
				this.setAddress( (String)map.get(SupplierMeta.ADDRESS));
				this.setAfterSalesContacts( (String)map.get(SupplierMeta.AFTER_SALES_CONTACTS));
				this.setCompanyType( (String)map.get(SupplierMeta.COMPANY_TYPE));
				this.setSupplierNotes( (String)map.get(SupplierMeta.SUPPLIER_NOTES));
				this.setUpdateTime( (Date)map.get(SupplierMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(SupplierMeta.VERSION));
				this.setCreateBy( (String)map.get(SupplierMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(SupplierMeta.DELETED));
				this.setAfterSalesContactsInfo( (String)map.get(SupplierMeta.AFTER_SALES_CONTACTS_INFO));
				this.setCreateTime( (Date)map.get(SupplierMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(SupplierMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(SupplierMeta.DELETE_TIME));
				this.setGrade( (String)map.get(SupplierMeta.GRADE));
				this.setUnitCode( (String)map.get(SupplierMeta.UNIT_CODE));
				this.setTenantId( (String)map.get(SupplierMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(SupplierMeta.DELETE_BY));
				this.setId( (String)map.get(SupplierMeta.ID));
				// others
				this.setGradeDict( (DictItem)map.get(SupplierMeta.GRADE_DICT));
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
			this.setSupplierName(DataParser.parse(String.class, r.getValue(SupplierMeta.SUPPLIER_NAME)));
			this.setBusinessContactsInfo(DataParser.parse(String.class, r.getValue(SupplierMeta.BUSINESS_CONTACTS_INFO)));
			this.setCode(DataParser.parse(String.class, r.getValue(SupplierMeta.CODE)));
			this.setBusinessContacts(DataParser.parse(String.class, r.getValue(SupplierMeta.BUSINESS_CONTACTS)));
			this.setAddress(DataParser.parse(String.class, r.getValue(SupplierMeta.ADDRESS)));
			this.setAfterSalesContacts(DataParser.parse(String.class, r.getValue(SupplierMeta.AFTER_SALES_CONTACTS)));
			this.setCompanyType(DataParser.parse(String.class, r.getValue(SupplierMeta.COMPANY_TYPE)));
			this.setSupplierNotes(DataParser.parse(String.class, r.getValue(SupplierMeta.SUPPLIER_NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(SupplierMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(SupplierMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(SupplierMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(SupplierMeta.DELETED)));
			this.setAfterSalesContactsInfo(DataParser.parse(String.class, r.getValue(SupplierMeta.AFTER_SALES_CONTACTS_INFO)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(SupplierMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(SupplierMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(SupplierMeta.DELETE_TIME)));
			this.setGrade(DataParser.parse(String.class, r.getValue(SupplierMeta.GRADE)));
			this.setUnitCode(DataParser.parse(String.class, r.getValue(SupplierMeta.UNIT_CODE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(SupplierMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(SupplierMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(SupplierMeta.ID)));
			return true;
		} else {
			try {
				this.setSupplierName( (String)r.getValue(SupplierMeta.SUPPLIER_NAME));
				this.setBusinessContactsInfo( (String)r.getValue(SupplierMeta.BUSINESS_CONTACTS_INFO));
				this.setCode( (String)r.getValue(SupplierMeta.CODE));
				this.setBusinessContacts( (String)r.getValue(SupplierMeta.BUSINESS_CONTACTS));
				this.setAddress( (String)r.getValue(SupplierMeta.ADDRESS));
				this.setAfterSalesContacts( (String)r.getValue(SupplierMeta.AFTER_SALES_CONTACTS));
				this.setCompanyType( (String)r.getValue(SupplierMeta.COMPANY_TYPE));
				this.setSupplierNotes( (String)r.getValue(SupplierMeta.SUPPLIER_NOTES));
				this.setUpdateTime( (Date)r.getValue(SupplierMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(SupplierMeta.VERSION));
				this.setCreateBy( (String)r.getValue(SupplierMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(SupplierMeta.DELETED));
				this.setAfterSalesContactsInfo( (String)r.getValue(SupplierMeta.AFTER_SALES_CONTACTS_INFO));
				this.setCreateTime( (Date)r.getValue(SupplierMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(SupplierMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(SupplierMeta.DELETE_TIME));
				this.setGrade( (String)r.getValue(SupplierMeta.GRADE));
				this.setUnitCode( (String)r.getValue(SupplierMeta.UNIT_CODE));
				this.setTenantId( (String)r.getValue(SupplierMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(SupplierMeta.DELETE_BY));
				this.setId( (String)r.getValue(SupplierMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}