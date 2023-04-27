package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_CMDB_OBJ_ATTRIBUTE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 配置属性
 * <p>配置属性 , 数据表 ops_cmdb_obj_attribute 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-23 22:49:17
 * @sign 630D1CA745745FC8B2EA02FE936C211A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_cmdb_obj_attribute")
@ApiModel(description = "配置属性 ; 配置属性 , 数据表 ops_cmdb_obj_attribute 的PO类型")
public class CmdbObjAttribute extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_CMDB_OBJ_ATTRIBUTE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 模型对象：模型对象
	*/
	@ApiModelProperty(required = false,value="模型对象" , notes = "模型对象")
	private String modelId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 属性名称：属性名称
	*/
	@ApiModelProperty(required = false,value="属性名称" , notes = "属性名称")
	private String attributeName;
	
	/**
	 * 属性类型：属性类型
	*/
	@ApiModelProperty(required = false,value="属性类型" , notes = "属性类型")
	private String attributeType;
	
	/**
	 * 字段来源：字段来源
	*/
	@ApiModelProperty(required = false,value="字段来源" , notes = "字段来源")
	private String attributeColSource;
	
	/**
	 * 字段填充：字段填充
	*/
	@ApiModelProperty(required = false,value="字段填充" , notes = "字段填充")
	private String attributeColFill;
	
	/**
	 * 显示字段：显示字段
	*/
	@ApiModelProperty(required = false,value="显示字段" , notes = "显示字段")
	private String attributeColShow;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private Integer sort;
	
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
	@ApiModelProperty(required = false,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * cmdbModel：cmdbModel
	*/
	@ApiModelProperty(required = false,value="cmdbModel" , notes = "cmdbModel")
	private CmdbModel cmdbModel;
	
	/**
	 * cmdbAttributeC：cmdbAttributeC
	*/
	@ApiModelProperty(required = false,value="cmdbAttributeC" , notes = "cmdbAttributeC")
	private CmdbAttributeC cmdbAttributeC;
	
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
	public CmdbObjAttribute setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 模型对象<br>
	 * 模型对象
	 * @return 模型对象
	*/
	public String getModelId() {
		return modelId;
	}
	
	/**
	 * 设置 模型对象
	 * @param modelId 模型对象
	 * @return 当前对象
	*/
	public CmdbObjAttribute setModelId(String modelId) {
		this.modelId=modelId;
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
	public CmdbObjAttribute setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 属性名称<br>
	 * 属性名称
	 * @return 属性名称
	*/
	public String getAttributeName() {
		return attributeName;
	}
	
	/**
	 * 设置 属性名称
	 * @param attributeName 属性名称
	 * @return 当前对象
	*/
	public CmdbObjAttribute setAttributeName(String attributeName) {
		this.attributeName=attributeName;
		return this;
	}
	
	/**
	 * 获得 属性类型<br>
	 * 属性类型
	 * @return 属性类型
	*/
	public String getAttributeType() {
		return attributeType;
	}
	
	/**
	 * 设置 属性类型
	 * @param attributeType 属性类型
	 * @return 当前对象
	*/
	public CmdbObjAttribute setAttributeType(String attributeType) {
		this.attributeType=attributeType;
		return this;
	}
	
	/**
	 * 获得 字段来源<br>
	 * 字段来源
	 * @return 字段来源
	*/
	public String getAttributeColSource() {
		return attributeColSource;
	}
	
	/**
	 * 设置 字段来源
	 * @param attributeColSource 字段来源
	 * @return 当前对象
	*/
	public CmdbObjAttribute setAttributeColSource(String attributeColSource) {
		this.attributeColSource=attributeColSource;
		return this;
	}
	
	/**
	 * 获得 字段填充<br>
	 * 字段填充
	 * @return 字段填充
	*/
	public String getAttributeColFill() {
		return attributeColFill;
	}
	
	/**
	 * 设置 字段填充
	 * @param attributeColFill 字段填充
	 * @return 当前对象
	*/
	public CmdbObjAttribute setAttributeColFill(String attributeColFill) {
		this.attributeColFill=attributeColFill;
		return this;
	}
	
	/**
	 * 获得 显示字段<br>
	 * 显示字段
	 * @return 显示字段
	*/
	public String getAttributeColShow() {
		return attributeColShow;
	}
	
	/**
	 * 设置 显示字段
	 * @param attributeColShow 显示字段
	 * @return 当前对象
	*/
	public CmdbObjAttribute setAttributeColShow(String attributeColShow) {
		this.attributeColShow=attributeColShow;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public CmdbObjAttribute setSort(Integer sort) {
		this.sort=sort;
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
	public CmdbObjAttribute setNotes(String notes) {
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
	public CmdbObjAttribute setCreateBy(String createBy) {
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
	public CmdbObjAttribute setCreateTime(Date createTime) {
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
	public CmdbObjAttribute setUpdateBy(String updateBy) {
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
	public CmdbObjAttribute setUpdateTime(Date updateTime) {
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
	public CmdbObjAttribute setDeleted(Integer deleted) {
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
	public CmdbObjAttribute setDeleted(Boolean deletedBool) {
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
	public CmdbObjAttribute setDeleteBy(String deleteBy) {
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
	public CmdbObjAttribute setDeleteTime(Date deleteTime) {
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
	public CmdbObjAttribute setVersion(Integer version) {
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
	public CmdbObjAttribute setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 cmdbModel<br>
	 * cmdbModel
	 * @return cmdbModel
	*/
	public CmdbModel getCmdbModel() {
		return cmdbModel;
	}
	
	/**
	 * 设置 cmdbModel
	 * @param cmdbModel cmdbModel
	 * @return 当前对象
	*/
	public CmdbObjAttribute setCmdbModel(CmdbModel cmdbModel) {
		this.cmdbModel=cmdbModel;
		return this;
	}
	
	/**
	 * 获得 cmdbAttributeC<br>
	 * cmdbAttributeC
	 * @return cmdbAttributeC
	*/
	public CmdbAttributeC getCmdbAttributeC() {
		return cmdbAttributeC;
	}
	
	/**
	 * 设置 cmdbAttributeC
	 * @param cmdbAttributeC cmdbAttributeC
	 * @return 当前对象
	*/
	public CmdbObjAttribute setCmdbAttributeC(CmdbAttributeC cmdbAttributeC) {
		this.cmdbAttributeC=cmdbAttributeC;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CmdbObjAttribute , 转换好的 CmdbObjAttribute 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CmdbObjAttribute , 转换好的 PoJo 对象
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
	public CmdbObjAttribute clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CmdbObjAttribute duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.CmdbObjAttributeMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.CmdbObjAttributeMeta.$$proxy$$();
		inst.setAttributeColShow(this.getAttributeColShow());
		inst.setNotes(this.getNotes());
		inst.setModelId(this.getModelId());
		inst.setAttributeColSource(this.getAttributeColSource());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAttributeType(this.getAttributeType());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setAttributeName(this.getAttributeName());
		inst.setId(this.getId());
		inst.setAttributeColFill(this.getAttributeColFill());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setCmdbAttributeC(this.getCmdbAttributeC());
			inst.setCmdbModel(this.getCmdbModel());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CmdbObjAttribute clone(boolean deep) {
		return EntityContext.clone(CmdbObjAttribute.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CmdbObjAttribute
	 * @param cmdbObjAttributeMap 包含实体信息的 Map 对象
	 * @return CmdbObjAttribute , 转换好的的 CmdbObjAttribute 对象
	*/
	@Transient
	public static CmdbObjAttribute createFrom(Map<String,Object> cmdbObjAttributeMap) {
		if(cmdbObjAttributeMap==null) return null;
		CmdbObjAttribute po = create();
		EntityContext.copyProperties(po,cmdbObjAttributeMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CmdbObjAttribute
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CmdbObjAttribute , 转换好的的 CmdbObjAttribute 对象
	*/
	@Transient
	public static CmdbObjAttribute createFrom(Object pojo) {
		if(pojo==null) return null;
		CmdbObjAttribute po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CmdbObjAttribute，等同于 new
	 * @return CmdbObjAttribute 对象
	*/
	@Transient
	public static CmdbObjAttribute create() {
		return new com.dt.platform.domain.ops.meta.CmdbObjAttributeMeta.$$proxy$$();
	}
}