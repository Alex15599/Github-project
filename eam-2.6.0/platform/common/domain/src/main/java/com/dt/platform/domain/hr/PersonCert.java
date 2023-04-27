package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_PERSON_CERT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.PersonCertMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 人员证书
 * <p>人员证书 , 数据表 hr_person_cert 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 15:12:49
 * @sign 5BAC1F994D803FA3C049B17783BBA708
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_person_cert")
@ApiModel(description = "人员证书 ; 人员证书 , 数据表 hr_person_cert 的PO类型")
public class PersonCert extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_PERSON_CERT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员")
	private String personId;
	
	/**
	 * 证书：证书
	*/
	@ApiModelProperty(required = false,value="证书" , notes = "证书")
	private String certId;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
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
	public PersonCert setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 人员<br>
	 * 人员
	 * @return 人员
	*/
	public String getPersonId() {
		return personId;
	}
	
	/**
	 * 设置 人员
	 * @param personId 人员
	 * @return 当前对象
	*/
	public PersonCert setPersonId(String personId) {
		this.personId=personId;
		return this;
	}
	
	/**
	 * 获得 证书<br>
	 * 证书
	 * @return 证书
	*/
	public String getCertId() {
		return certId;
	}
	
	/**
	 * 设置 证书
	 * @param certId 证书
	 * @return 当前对象
	*/
	public PersonCert setCertId(String certId) {
		this.certId=certId;
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
	public PersonCert setCreateBy(String createBy) {
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
	public PersonCert setCreateTime(Date createTime) {
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
	public PersonCert setUpdateBy(String updateBy) {
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
	public PersonCert setUpdateTime(Date updateTime) {
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
	public PersonCert setDeleted(Integer deleted) {
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
	public PersonCert setDeleted(Boolean deletedBool) {
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
	public PersonCert setDeleteBy(String deleteBy) {
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
	public PersonCert setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public PersonCert setVersion(Integer version) {
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
	public PersonCert setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonCert , 转换好的 PersonCert 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonCert , 转换好的 PoJo 对象
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
	public PersonCert clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonCert duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.PersonCertMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.PersonCertMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPersonId(this.getPersonId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setCertId(this.getCertId());
		inst.setVersion(this.getVersion());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonCert clone(boolean deep) {
		return EntityContext.clone(PersonCert.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonCert
	 * @param personCertMap 包含实体信息的 Map 对象
	 * @return PersonCert , 转换好的的 PersonCert 对象
	*/
	@Transient
	public static PersonCert createFrom(Map<String,Object> personCertMap) {
		if(personCertMap==null) return null;
		PersonCert po = create();
		EntityContext.copyProperties(po,personCertMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonCert
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonCert , 转换好的的 PersonCert 对象
	*/
	@Transient
	public static PersonCert createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonCert po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonCert，等同于 new
	 * @return PersonCert 对象
	*/
	@Transient
	public static PersonCert create() {
		return new com.dt.platform.domain.hr.meta.PersonCertMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonCertMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonCertMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonCertMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonCertMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonCertMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(PersonCertMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonCertMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, map.get(PersonCertMeta.PERSON_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonCertMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(PersonCertMeta.ID)));
			this.setCertId(DataParser.parse(String.class, map.get(PersonCertMeta.CERT_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonCertMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(PersonCertMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonCertMeta.DELETED));
				this.setCreateTime( (Date)map.get(PersonCertMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonCertMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonCertMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(PersonCertMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(PersonCertMeta.DELETE_BY));
				this.setPersonId( (String)map.get(PersonCertMeta.PERSON_ID));
				this.setUpdateTime( (Date)map.get(PersonCertMeta.UPDATE_TIME));
				this.setId( (String)map.get(PersonCertMeta.ID));
				this.setCertId( (String)map.get(PersonCertMeta.CERT_ID));
				this.setVersion( (Integer)map.get(PersonCertMeta.VERSION));
				// others
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonCertMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonCertMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonCertMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonCertMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonCertMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(PersonCertMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonCertMeta.DELETE_BY)));
			this.setPersonId(DataParser.parse(String.class, r.getValue(PersonCertMeta.PERSON_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonCertMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonCertMeta.ID)));
			this.setCertId(DataParser.parse(String.class, r.getValue(PersonCertMeta.CERT_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonCertMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(PersonCertMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonCertMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(PersonCertMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonCertMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonCertMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(PersonCertMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(PersonCertMeta.DELETE_BY));
				this.setPersonId( (String)r.getValue(PersonCertMeta.PERSON_ID));
				this.setUpdateTime( (Date)r.getValue(PersonCertMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(PersonCertMeta.ID));
				this.setCertId( (String)r.getValue(PersonCertMeta.CERT_ID));
				this.setVersion( (Integer)r.getValue(PersonCertMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}