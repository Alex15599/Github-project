package com.dt.platform.domain.hr;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.HrTables.HR_CERTIFICATE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.hr.meta.CertificateMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 证书管理
 * <p>证书管理 , 数据表 hr_certificate 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-15 09:46:20
 * @sign 9621AE2F0BC3A7EC845F244DD3688AA3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "hr_certificate")
@ApiModel(description = "证书管理 ; 证书管理 , 数据表 hr_certificate 的PO类型")
public class Certificate extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =HR_CERTIFICATE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String type;
	
	/**
	 * 级别：级别
	*/
	@ApiModelProperty(required = false,value="级别" , notes = "级别")
	private String certLevel;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private String sort;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String note;
	
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
	 * certificateType：certificateType
	*/
	@ApiModelProperty(required = false,value="certificateType" , notes = "certificateType")
	private CertificateType certificateType;
	
	/**
	 * certificateLevel：certificateLevel
	*/
	@ApiModelProperty(required = false,value="certificateLevel" , notes = "certificateLevel")
	private CertificateLevel certificateLevel;
	
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
	public Certificate setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public Certificate setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 级别<br>
	 * 级别
	 * @return 级别
	*/
	public String getCertLevel() {
		return certLevel;
	}
	
	/**
	 * 设置 级别
	 * @param certLevel 级别
	 * @return 当前对象
	*/
	public Certificate setCertLevel(String certLevel) {
		this.certLevel=certLevel;
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
	public Certificate setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public String getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public Certificate setSort(String sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNote() {
		return note;
	}
	
	/**
	 * 设置 备注
	 * @param note 备注
	 * @return 当前对象
	*/
	public Certificate setNote(String note) {
		this.note=note;
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
	public Certificate setCreateBy(String createBy) {
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
	public Certificate setCreateTime(Date createTime) {
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
	public Certificate setUpdateBy(String updateBy) {
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
	public Certificate setUpdateTime(Date updateTime) {
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
	public Certificate setDeleted(Integer deleted) {
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
	public Certificate setDeleted(Boolean deletedBool) {
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
	public Certificate setDeleteBy(String deleteBy) {
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
	public Certificate setDeleteTime(Date deleteTime) {
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
	public Certificate setVersion(Integer version) {
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
	public Certificate setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 certificateType<br>
	 * certificateType
	 * @return certificateType
	*/
	public CertificateType getCertificateType() {
		return certificateType;
	}
	
	/**
	 * 设置 certificateType
	 * @param certificateType certificateType
	 * @return 当前对象
	*/
	public Certificate setCertificateType(CertificateType certificateType) {
		this.certificateType=certificateType;
		return this;
	}
	
	/**
	 * 获得 certificateLevel<br>
	 * certificateLevel
	 * @return certificateLevel
	*/
	public CertificateLevel getCertificateLevel() {
		return certificateLevel;
	}
	
	/**
	 * 设置 certificateLevel
	 * @param certificateLevel certificateLevel
	 * @return 当前对象
	*/
	public Certificate setCertificateLevel(CertificateLevel certificateLevel) {
		this.certificateLevel=certificateLevel;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Certificate , 转换好的 Certificate 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Certificate , 转换好的 PoJo 对象
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
	public Certificate clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Certificate duplicate(boolean all) {
		com.dt.platform.domain.hr.meta.CertificateMeta.$$proxy$$ inst = new com.dt.platform.domain.hr.meta.CertificateMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Certificate clone(boolean deep) {
		return EntityContext.clone(Certificate.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Certificate
	 * @param certificateMap 包含实体信息的 Map 对象
	 * @return Certificate , 转换好的的 Certificate 对象
	*/
	@Transient
	public static Certificate createFrom(Map<String,Object> certificateMap) {
		if(certificateMap==null) return null;
		Certificate po = create();
		EntityContext.copyProperties(po,certificateMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Certificate
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Certificate , 转换好的的 Certificate 对象
	*/
	@Transient
	public static Certificate createFrom(Object pojo) {
		if(pojo==null) return null;
		Certificate po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Certificate，等同于 new
	 * @return Certificate 对象
	*/
	@Transient
	public static Certificate create() {
		return new com.dt.platform.domain.hr.meta.CertificateMeta.$$proxy$$();
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
			this.setNote(DataParser.parse(String.class, map.get(CertificateMeta.NOTE)));
			this.setCertLevel(DataParser.parse(String.class, map.get(CertificateMeta.CERT_LEVEL)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CertificateMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(String.class, map.get(CertificateMeta.SORT)));
			this.setType(DataParser.parse(String.class, map.get(CertificateMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CertificateMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CertificateMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CertificateMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CertificateMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CertificateMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CertificateMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(CertificateMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CertificateMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CertificateMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CertificateMeta.ID)));
			// others
			this.setCertificateLevel(DataParser.parse(CertificateLevel.class, map.get(CertificateMeta.CERTIFICATE_LEVEL)));
			this.setCertificateType(DataParser.parse(CertificateType.class, map.get(CertificateMeta.CERTIFICATE_TYPE)));
			return true;
		} else {
			try {
				this.setNote( (String)map.get(CertificateMeta.NOTE));
				this.setCertLevel( (String)map.get(CertificateMeta.CERT_LEVEL));
				this.setUpdateTime( (Date)map.get(CertificateMeta.UPDATE_TIME));
				this.setSort( (String)map.get(CertificateMeta.SORT));
				this.setType( (String)map.get(CertificateMeta.TYPE));
				this.setVersion( (Integer)map.get(CertificateMeta.VERSION));
				this.setCreateBy( (String)map.get(CertificateMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CertificateMeta.DELETED));
				this.setCreateTime( (Date)map.get(CertificateMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CertificateMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CertificateMeta.DELETE_TIME));
				this.setName( (String)map.get(CertificateMeta.NAME));
				this.setTenantId( (String)map.get(CertificateMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CertificateMeta.DELETE_BY));
				this.setId( (String)map.get(CertificateMeta.ID));
				// others
				this.setCertificateLevel( (CertificateLevel)map.get(CertificateMeta.CERTIFICATE_LEVEL));
				this.setCertificateType( (CertificateType)map.get(CertificateMeta.CERTIFICATE_TYPE));
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
			this.setNote(DataParser.parse(String.class, r.getValue(CertificateMeta.NOTE)));
			this.setCertLevel(DataParser.parse(String.class, r.getValue(CertificateMeta.CERT_LEVEL)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CertificateMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(String.class, r.getValue(CertificateMeta.SORT)));
			this.setType(DataParser.parse(String.class, r.getValue(CertificateMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CertificateMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CertificateMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CertificateMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CertificateMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CertificateMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CertificateMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(CertificateMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CertificateMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CertificateMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CertificateMeta.ID)));
			return true;
		} else {
			try {
				this.setNote( (String)r.getValue(CertificateMeta.NOTE));
				this.setCertLevel( (String)r.getValue(CertificateMeta.CERT_LEVEL));
				this.setUpdateTime( (Date)r.getValue(CertificateMeta.UPDATE_TIME));
				this.setSort( (String)r.getValue(CertificateMeta.SORT));
				this.setType( (String)r.getValue(CertificateMeta.TYPE));
				this.setVersion( (Integer)r.getValue(CertificateMeta.VERSION));
				this.setCreateBy( (String)r.getValue(CertificateMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CertificateMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CertificateMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CertificateMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CertificateMeta.DELETE_TIME));
				this.setName( (String)r.getValue(CertificateMeta.NAME));
				this.setTenantId( (String)r.getValue(CertificateMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CertificateMeta.DELETE_BY));
				this.setId( (String)r.getValue(CertificateMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}