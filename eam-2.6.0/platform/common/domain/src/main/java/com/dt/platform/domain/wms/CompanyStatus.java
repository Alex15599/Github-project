package com.dt.platform.domain.wms;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.WmsTables.WMS_COMPANY_STATUS;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.wms.meta.CompanyStatusMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 企业状态
 * <p>企业状态 , 数据表 wms_company_status 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:28:55
 * @sign 87591A75CA8E4166223525484E301BC3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "wms_company_status")
@ApiModel(description = "企业状态 ; 企业状态 , 数据表 wms_company_status 的PO类型")
public class CompanyStatus extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WMS_COMPANY_STATUS.$TABLE;
	
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
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
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
	public CompanyStatus setId(String id) {
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
	public CompanyStatus setCode(String code) {
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
	public CompanyStatus setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public CompanyStatus setStatus(String status) {
		this.status=status;
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
	public CompanyStatus setNotes(String notes) {
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
	public CompanyStatus setCreateBy(String createBy) {
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
	public CompanyStatus setCreateTime(Date createTime) {
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
	public CompanyStatus setUpdateBy(String updateBy) {
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
	public CompanyStatus setUpdateTime(Date updateTime) {
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
	public CompanyStatus setDeleted(Integer deleted) {
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
	public CompanyStatus setDeleted(Boolean deletedBool) {
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
	public CompanyStatus setDeleteBy(String deleteBy) {
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
	public CompanyStatus setDeleteTime(Date deleteTime) {
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
	public CompanyStatus setVersion(Integer version) {
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
	public CompanyStatus setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CompanyStatus , 转换好的 CompanyStatus 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CompanyStatus , 转换好的 PoJo 对象
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
	public CompanyStatus clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CompanyStatus duplicate(boolean all) {
		com.dt.platform.domain.wms.meta.CompanyStatusMeta.$$proxy$$ inst = new com.dt.platform.domain.wms.meta.CompanyStatusMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
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
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CompanyStatus clone(boolean deep) {
		return EntityContext.clone(CompanyStatus.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CompanyStatus
	 * @param companyStatusMap 包含实体信息的 Map 对象
	 * @return CompanyStatus , 转换好的的 CompanyStatus 对象
	*/
	@Transient
	public static CompanyStatus createFrom(Map<String,Object> companyStatusMap) {
		if(companyStatusMap==null) return null;
		CompanyStatus po = create();
		EntityContext.copyProperties(po,companyStatusMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CompanyStatus
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CompanyStatus , 转换好的的 CompanyStatus 对象
	*/
	@Transient
	public static CompanyStatus createFrom(Object pojo) {
		if(pojo==null) return null;
		CompanyStatus po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CompanyStatus，等同于 new
	 * @return CompanyStatus 对象
	*/
	@Transient
	public static CompanyStatus create() {
		return new com.dt.platform.domain.wms.meta.CompanyStatusMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(CompanyStatusMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(CompanyStatusMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CompanyStatusMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CompanyStatusMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CompanyStatusMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CompanyStatusMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CompanyStatusMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CompanyStatusMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CompanyStatusMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(CompanyStatusMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CompanyStatusMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CompanyStatusMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CompanyStatusMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(CompanyStatusMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(CompanyStatusMeta.CODE));
				this.setNotes( (String)map.get(CompanyStatusMeta.NOTES));
				this.setUpdateTime( (Date)map.get(CompanyStatusMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(CompanyStatusMeta.VERSION));
				this.setCreateBy( (String)map.get(CompanyStatusMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CompanyStatusMeta.DELETED));
				this.setCreateTime( (Date)map.get(CompanyStatusMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CompanyStatusMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CompanyStatusMeta.DELETE_TIME));
				this.setName( (String)map.get(CompanyStatusMeta.NAME));
				this.setTenantId( (String)map.get(CompanyStatusMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CompanyStatusMeta.DELETE_BY));
				this.setId( (String)map.get(CompanyStatusMeta.ID));
				this.setStatus( (String)map.get(CompanyStatusMeta.STATUS));
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
			this.setCode(DataParser.parse(String.class, r.getValue(CompanyStatusMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(CompanyStatusMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CompanyStatusMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CompanyStatusMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CompanyStatusMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CompanyStatusMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CompanyStatusMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CompanyStatusMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CompanyStatusMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(CompanyStatusMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CompanyStatusMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CompanyStatusMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CompanyStatusMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(CompanyStatusMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(CompanyStatusMeta.CODE));
				this.setNotes( (String)r.getValue(CompanyStatusMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(CompanyStatusMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(CompanyStatusMeta.VERSION));
				this.setCreateBy( (String)r.getValue(CompanyStatusMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CompanyStatusMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CompanyStatusMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CompanyStatusMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CompanyStatusMeta.DELETE_TIME));
				this.setName( (String)r.getValue(CompanyStatusMeta.NAME));
				this.setTenantId( (String)r.getValue(CompanyStatusMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CompanyStatusMeta.DELETE_BY));
				this.setId( (String)r.getValue(CompanyStatusMeta.ID));
				this.setStatus( (String)r.getValue(CompanyStatusMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}