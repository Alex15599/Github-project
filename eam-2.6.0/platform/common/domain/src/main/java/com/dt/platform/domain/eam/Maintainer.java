package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_MAINTAINER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 维保厂商
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-30 22:05:17
 * @sign 1BBE6A4C8DA10A26842247FC3563DD4F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_maintainer")
public class Maintainer extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_MAINTAINER.$TABLE;
	
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
	private String maintainerName;
	
	/**
	 * 商务联系人：商务联系人
	*/
	@ApiModelProperty(required = false,value="商务联系人" , notes = "商务联系人")
	private String businessContacts;
	
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
	@ApiModelProperty(required = false,value="地址" , notes = "地址")
	private String address;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String maintainerNotes;
	
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
	public Maintainer setId(String id) {
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
	public Maintainer setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getMaintainerName() {
		return maintainerName;
	}
	
	/**
	 * 设置 名称
	 * @param maintainerName 名称
	 * @return 当前对象
	*/
	public Maintainer setMaintainerName(String maintainerName) {
		this.maintainerName=maintainerName;
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
	public Maintainer setBusinessContacts(String businessContacts) {
		this.businessContacts=businessContacts;
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
	public Maintainer setBusinessContactsInfo(String businessContactsInfo) {
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
	public Maintainer setAfterSalesContacts(String afterSalesContacts) {
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
	public Maintainer setAfterSalesContactsInfo(String afterSalesContactsInfo) {
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
	public Maintainer setUnitCode(String unitCode) {
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
	public Maintainer setAddress(String address) {
		this.address=address;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getMaintainerNotes() {
		return maintainerNotes;
	}
	
	/**
	 * 设置 备注
	 * @param maintainerNotes 备注
	 * @return 当前对象
	*/
	public Maintainer setMaintainerNotes(String maintainerNotes) {
		this.maintainerNotes=maintainerNotes;
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
	public Maintainer setCreateBy(String createBy) {
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
	public Maintainer setCreateTime(Date createTime) {
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
	public Maintainer setUpdateBy(String updateBy) {
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
	public Maintainer setUpdateTime(Date updateTime) {
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
	public Maintainer setDeleted(Integer deleted) {
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
	public Maintainer setDeleted(Boolean deletedBool) {
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
	public Maintainer setDeleteBy(String deleteBy) {
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
	public Maintainer setDeleteTime(Date deleteTime) {
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
	public Maintainer setVersion(Integer version) {
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
	public Maintainer setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Maintainer , 转换好的 Maintainer 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Maintainer , 转换好的 PoJo 对象
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
	public Maintainer clone() {
		return EntityContext.clone(Maintainer.class,this);
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Maintainer clone(boolean deep) {
		return EntityContext.clone(Maintainer.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Maintainer
	 * @param maintainerMap 包含实体信息的 Map 对象
	 * @return Maintainer , 转换好的的 Maintainer 对象
	*/
	@Transient
	public static Maintainer createFrom(Map<String,Object> maintainerMap) {
		if(maintainerMap==null) return null;
		Maintainer po = EntityContext.create(Maintainer.class, maintainerMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 Maintainer
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Maintainer , 转换好的的 Maintainer 对象
	*/
	@Transient
	public static Maintainer createFrom(Object pojo) {
		if(pojo==null) return null;
		Maintainer po = EntityContext.create(Maintainer.class,pojo);
		return po;
	}

	/**
	 * 创建一个 Maintainer，等同于 new
	 * @return Maintainer 对象
	*/
	@Transient
	public static Maintainer create() {
		return EntityContext.create(Maintainer.class);
	}
}