package com.dt.platform.domain.wms;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.WmsTables.WMS_PRODUCT_ATTR;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.wms.meta.ProductAttrMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 产品属性
 * <p>产品属性 , 数据表 wms_product_attr 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:29:56
 * @sign D486196EC23D25D4D19E244E0AC46748
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "wms_product_attr")
@ApiModel(description = "产品属性 ; 产品属性 , 数据表 wms_product_attr 的PO类型")
public class ProductAttr extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WMS_PRODUCT_ATTR.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "684022092424806400")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "铝制材料")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "铝制材料")
	private String name;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "铝制材料")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-03-03 12:59:35")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
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
	public ProductAttr setId(String id) {
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
	public ProductAttr setCode(String code) {
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
	public ProductAttr setName(String name) {
		this.name=name;
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
	public ProductAttr setNotes(String notes) {
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
	public ProductAttr setCreateBy(String createBy) {
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
	public ProductAttr setCreateTime(Date createTime) {
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
	public ProductAttr setUpdateBy(String updateBy) {
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
	public ProductAttr setUpdateTime(Date updateTime) {
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
	public ProductAttr setDeleted(Integer deleted) {
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
	public ProductAttr setDeleted(Boolean deletedBool) {
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
	public ProductAttr setDeleteBy(String deleteBy) {
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
	public ProductAttr setDeleteTime(Date deleteTime) {
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
	public ProductAttr setVersion(Integer version) {
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
	public ProductAttr setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ProductAttr , 转换好的 ProductAttr 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProductAttr , 转换好的 PoJo 对象
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
	public ProductAttr clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ProductAttr duplicate(boolean all) {
		com.dt.platform.domain.wms.meta.ProductAttrMeta.$$proxy$$ inst = new com.dt.platform.domain.wms.meta.ProductAttrMeta.$$proxy$$();
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
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProductAttr clone(boolean deep) {
		return EntityContext.clone(ProductAttr.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ProductAttr
	 * @param productAttrMap 包含实体信息的 Map 对象
	 * @return ProductAttr , 转换好的的 ProductAttr 对象
	*/
	@Transient
	public static ProductAttr createFrom(Map<String,Object> productAttrMap) {
		if(productAttrMap==null) return null;
		ProductAttr po = create();
		EntityContext.copyProperties(po,productAttrMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ProductAttr
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProductAttr , 转换好的的 ProductAttr 对象
	*/
	@Transient
	public static ProductAttr createFrom(Object pojo) {
		if(pojo==null) return null;
		ProductAttr po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ProductAttr，等同于 new
	 * @return ProductAttr 对象
	*/
	@Transient
	public static ProductAttr create() {
		return new com.dt.platform.domain.wms.meta.ProductAttrMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(ProductAttrMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(ProductAttrMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProductAttrMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProductAttrMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProductAttrMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProductAttrMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProductAttrMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProductAttrMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProductAttrMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(ProductAttrMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(ProductAttrMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProductAttrMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(ProductAttrMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(ProductAttrMeta.CODE));
				this.setNotes( (String)map.get(ProductAttrMeta.NOTES));
				this.setUpdateTime( (Date)map.get(ProductAttrMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(ProductAttrMeta.VERSION));
				this.setCreateBy( (String)map.get(ProductAttrMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ProductAttrMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProductAttrMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(ProductAttrMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(ProductAttrMeta.DELETE_TIME));
				this.setName( (String)map.get(ProductAttrMeta.NAME));
				this.setTenantId( (String)map.get(ProductAttrMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ProductAttrMeta.DELETE_BY));
				this.setId( (String)map.get(ProductAttrMeta.ID));
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
			this.setCode(DataParser.parse(String.class, r.getValue(ProductAttrMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ProductAttrMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProductAttrMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProductAttrMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProductAttrMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProductAttrMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProductAttrMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProductAttrMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProductAttrMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(ProductAttrMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ProductAttrMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProductAttrMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(ProductAttrMeta.ID)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(ProductAttrMeta.CODE));
				this.setNotes( (String)r.getValue(ProductAttrMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(ProductAttrMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(ProductAttrMeta.VERSION));
				this.setCreateBy( (String)r.getValue(ProductAttrMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ProductAttrMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProductAttrMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(ProductAttrMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(ProductAttrMeta.DELETE_TIME));
				this.setName( (String)r.getValue(ProductAttrMeta.NAME));
				this.setTenantId( (String)r.getValue(ProductAttrMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ProductAttrMeta.DELETE_BY));
				this.setId( (String)r.getValue(ProductAttrMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}