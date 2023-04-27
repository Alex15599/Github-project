package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_ATTRIBUTE_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetAttributeItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产字段配置项
 * <p>资产字段配置项 , 数据表 eam_asset_attribute_item 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-28 17:53:45
 * @sign 76619BED4D662052BFE393E79FF5D75D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_attribute_item")
@ApiModel(description = "资产字段配置项 ; 资产字段配置项 , 数据表 eam_asset_attribute_item 的PO类型")
public class AssetAttributeItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_ATTRIBUTE_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "139aa6d6c-4f2b-11ec-83fb-00163e1b60a7")
	private String id;
	
	/**
	 * 所属模块：所属模块
	*/
	@ApiModelProperty(required = false,value="所属模块" , notes = "所属模块" , example = "asset_stock_show")
	private String ownerCode;
	
	/**
	 * 属性：属性
	*/
	@ApiModelProperty(required = false,value="属性" , notes = "属性" , example = "fe6a6910-0f8a-11ec-ab08-00163e2e6a36")
	private String attributeId;
	
	/**
	 * 所属维度：所属维度
	*/
	@ApiModelProperty(required = false,value="所属维度" , notes = "所属维度" , example = "attribution")
	private String dimension;
	
	/**
	 * 必选：必选
	*/
	@ApiModelProperty(required = false,value="必选" , notes = "必选" , example = "1")
	private String required;
	
	/**
	 * 布局类型：布局类型
	*/
	@ApiModelProperty(required = false,value="布局类型" , notes = "布局类型" , example = "3")
	private String layoutType;
	
	/**
	 * 列表显示：列表显示
	*/
	@ApiModelProperty(required = false,value="列表显示" , notes = "列表显示" , example = "1")
	private String listShow;
	
	/**
	 * 列表内容：列表内容
	*/
	@ApiModelProperty(required = false,value="列表内容" , notes = "列表内容")
	private String listContent;
	
	/**
	 * 列表排序：列表排序
	*/
	@ApiModelProperty(required = false,value="列表排序" , notes = "列表排序" , example = "20")
	private Integer listSort;
	
	/**
	 * 表单显示：表单显示
	*/
	@ApiModelProperty(required = false,value="表单显示" , notes = "表单显示" , example = "1")
	private String formShow;
	
	/**
	 * 行布局位置：行布局位置
	*/
	@ApiModelProperty(required = false,value="行布局位置" , notes = "行布局位置" , example = "1")
	private Integer layoutRow;
	
	/**
	 * 列布局位置：列布局位置
	*/
	@ApiModelProperty(required = false,value="列布局位置" , notes = "列布局位置" , example = "1")
	private Integer layoutColumn;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2021-10-25 02:04:05")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2021-11-25 06:33:48")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "4")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 属性：属性
	*/
	@ApiModelProperty(required = false,value="属性" , notes = "属性")
	private AssetAttribute attribute;
	
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
	public AssetAttributeItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属模块<br>
	 * 所属模块
	 * @return 所属模块
	*/
	public String getOwnerCode() {
		return ownerCode;
	}
	
	/**
	 * 设置 所属模块
	 * @param ownerCode 所属模块
	 * @return 当前对象
	*/
	public AssetAttributeItem setOwnerCode(String ownerCode) {
		this.ownerCode=ownerCode;
		return this;
	}
	
	/**
	 * 获得 属性<br>
	 * 属性
	 * @return 属性
	*/
	public String getAttributeId() {
		return attributeId;
	}
	
	/**
	 * 设置 属性
	 * @param attributeId 属性
	 * @return 当前对象
	*/
	public AssetAttributeItem setAttributeId(String attributeId) {
		this.attributeId=attributeId;
		return this;
	}
	
	/**
	 * 获得 所属维度<br>
	 * 所属维度
	 * @return 所属维度
	*/
	public String getDimension() {
		return dimension;
	}
	
	/**
	 * 设置 所属维度
	 * @param dimension 所属维度
	 * @return 当前对象
	*/
	public AssetAttributeItem setDimension(String dimension) {
		this.dimension=dimension;
		return this;
	}
	
	/**
	 * 获得 必选<br>
	 * 必选
	 * @return 必选
	*/
	public String getRequired() {
		return required;
	}
	
	/**
	 * 设置 必选
	 * @param required 必选
	 * @return 当前对象
	*/
	public AssetAttributeItem setRequired(String required) {
		this.required=required;
		return this;
	}
	
	/**
	 * 获得 布局类型<br>
	 * 布局类型
	 * @return 布局类型
	*/
	public String getLayoutType() {
		return layoutType;
	}
	
	/**
	 * 设置 布局类型
	 * @param layoutType 布局类型
	 * @return 当前对象
	*/
	public AssetAttributeItem setLayoutType(String layoutType) {
		this.layoutType=layoutType;
		return this;
	}
	
	/**
	 * 获得 列表显示<br>
	 * 列表显示
	 * @return 列表显示
	*/
	public String getListShow() {
		return listShow;
	}
	
	/**
	 * 设置 列表显示
	 * @param listShow 列表显示
	 * @return 当前对象
	*/
	public AssetAttributeItem setListShow(String listShow) {
		this.listShow=listShow;
		return this;
	}
	
	/**
	 * 获得 列表内容<br>
	 * 列表内容
	 * @return 列表内容
	*/
	public String getListContent() {
		return listContent;
	}
	
	/**
	 * 设置 列表内容
	 * @param listContent 列表内容
	 * @return 当前对象
	*/
	public AssetAttributeItem setListContent(String listContent) {
		this.listContent=listContent;
		return this;
	}
	
	/**
	 * 获得 列表排序<br>
	 * 列表排序
	 * @return 列表排序
	*/
	public Integer getListSort() {
		return listSort;
	}
	
	/**
	 * 设置 列表排序
	 * @param listSort 列表排序
	 * @return 当前对象
	*/
	public AssetAttributeItem setListSort(Integer listSort) {
		this.listSort=listSort;
		return this;
	}
	
	/**
	 * 获得 表单显示<br>
	 * 表单显示
	 * @return 表单显示
	*/
	public String getFormShow() {
		return formShow;
	}
	
	/**
	 * 设置 表单显示
	 * @param formShow 表单显示
	 * @return 当前对象
	*/
	public AssetAttributeItem setFormShow(String formShow) {
		this.formShow=formShow;
		return this;
	}
	
	/**
	 * 获得 行布局位置<br>
	 * 行布局位置
	 * @return 行布局位置
	*/
	public Integer getLayoutRow() {
		return layoutRow;
	}
	
	/**
	 * 设置 行布局位置
	 * @param layoutRow 行布局位置
	 * @return 当前对象
	*/
	public AssetAttributeItem setLayoutRow(Integer layoutRow) {
		this.layoutRow=layoutRow;
		return this;
	}
	
	/**
	 * 获得 列布局位置<br>
	 * 列布局位置
	 * @return 列布局位置
	*/
	public Integer getLayoutColumn() {
		return layoutColumn;
	}
	
	/**
	 * 设置 列布局位置
	 * @param layoutColumn 列布局位置
	 * @return 当前对象
	*/
	public AssetAttributeItem setLayoutColumn(Integer layoutColumn) {
		this.layoutColumn=layoutColumn;
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
	public AssetAttributeItem setNotes(String notes) {
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
	public AssetAttributeItem setCreateBy(String createBy) {
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
	public AssetAttributeItem setCreateTime(Date createTime) {
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
	public AssetAttributeItem setUpdateBy(String updateBy) {
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
	public AssetAttributeItem setUpdateTime(Date updateTime) {
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
	public AssetAttributeItem setDeleted(Integer deleted) {
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
	public AssetAttributeItem setDeleted(Boolean deletedBool) {
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
	public AssetAttributeItem setDeleteBy(String deleteBy) {
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
	public AssetAttributeItem setDeleteTime(Date deleteTime) {
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
	public AssetAttributeItem setVersion(Integer version) {
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
	public AssetAttributeItem setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 属性<br>
	 * 属性
	 * @return 属性
	*/
	public AssetAttribute getAttribute() {
		return attribute;
	}
	
	/**
	 * 设置 属性
	 * @param attribute 属性
	 * @return 当前对象
	*/
	public AssetAttributeItem setAttribute(AssetAttribute attribute) {
		this.attribute=attribute;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetAttributeItem , 转换好的 AssetAttributeItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetAttributeItem , 转换好的 PoJo 对象
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
	public AssetAttributeItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetAttributeItem duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetAttributeItemMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetAttributeItemMeta.$$proxy$$();
		inst.setLayoutRow(this.getLayoutRow());
		inst.setNotes(this.getNotes());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setListSort(this.getListSort());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setListContent(this.getListContent());
		inst.setVersion(this.getVersion());
		inst.setRequired(this.getRequired());
		inst.setListShow(this.getListShow());
		inst.setAttributeId(this.getAttributeId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setLayoutType(this.getLayoutType());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setFormShow(this.getFormShow());
		inst.setId(this.getId());
		inst.setLayoutColumn(this.getLayoutColumn());
		inst.setDimension(this.getDimension());
		if(all) {
			inst.setAttribute(this.getAttribute());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetAttributeItem clone(boolean deep) {
		return EntityContext.clone(AssetAttributeItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetAttributeItem
	 * @param assetAttributeItemMap 包含实体信息的 Map 对象
	 * @return AssetAttributeItem , 转换好的的 AssetAttributeItem 对象
	*/
	@Transient
	public static AssetAttributeItem createFrom(Map<String,Object> assetAttributeItemMap) {
		if(assetAttributeItemMap==null) return null;
		AssetAttributeItem po = create();
		EntityContext.copyProperties(po,assetAttributeItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetAttributeItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetAttributeItem , 转换好的的 AssetAttributeItem 对象
	*/
	@Transient
	public static AssetAttributeItem createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetAttributeItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetAttributeItem，等同于 new
	 * @return AssetAttributeItem 对象
	*/
	@Transient
	public static AssetAttributeItem create() {
		return new com.dt.platform.domain.eam.meta.AssetAttributeItemMeta.$$proxy$$();
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
			this.setLayoutRow(DataParser.parse(Integer.class, map.get(AssetAttributeItemMeta.LAYOUT_ROW)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.OWNER_CODE)));
			this.setListSort(DataParser.parse(Integer.class, map.get(AssetAttributeItemMeta.LIST_SORT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetAttributeItemMeta.UPDATE_TIME)));
			this.setListContent(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.LIST_CONTENT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetAttributeItemMeta.VERSION)));
			this.setRequired(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.REQUIRED)));
			this.setListShow(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.LIST_SHOW)));
			this.setAttributeId(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.ATTRIBUTE_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetAttributeItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetAttributeItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetAttributeItemMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.TENANT_ID)));
			this.setLayoutType(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.LAYOUT_TYPE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.DELETE_BY)));
			this.setFormShow(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.FORM_SHOW)));
			this.setId(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.ID)));
			this.setLayoutColumn(DataParser.parse(Integer.class, map.get(AssetAttributeItemMeta.LAYOUT_COLUMN)));
			this.setDimension(DataParser.parse(String.class, map.get(AssetAttributeItemMeta.DIMENSION)));
			// others
			this.setAttribute(DataParser.parse(AssetAttribute.class, map.get(AssetAttributeItemMeta.ATTRIBUTE)));
			return true;
		} else {
			try {
				this.setLayoutRow( (Integer)map.get(AssetAttributeItemMeta.LAYOUT_ROW));
				this.setNotes( (String)map.get(AssetAttributeItemMeta.NOTES));
				this.setOwnerCode( (String)map.get(AssetAttributeItemMeta.OWNER_CODE));
				this.setListSort( (Integer)map.get(AssetAttributeItemMeta.LIST_SORT));
				this.setUpdateTime( (Date)map.get(AssetAttributeItemMeta.UPDATE_TIME));
				this.setListContent( (String)map.get(AssetAttributeItemMeta.LIST_CONTENT));
				this.setVersion( (Integer)map.get(AssetAttributeItemMeta.VERSION));
				this.setRequired( (String)map.get(AssetAttributeItemMeta.REQUIRED));
				this.setListShow( (String)map.get(AssetAttributeItemMeta.LIST_SHOW));
				this.setAttributeId( (String)map.get(AssetAttributeItemMeta.ATTRIBUTE_ID));
				this.setCreateBy( (String)map.get(AssetAttributeItemMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetAttributeItemMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetAttributeItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetAttributeItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetAttributeItemMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(AssetAttributeItemMeta.TENANT_ID));
				this.setLayoutType( (String)map.get(AssetAttributeItemMeta.LAYOUT_TYPE));
				this.setDeleteBy( (String)map.get(AssetAttributeItemMeta.DELETE_BY));
				this.setFormShow( (String)map.get(AssetAttributeItemMeta.FORM_SHOW));
				this.setId( (String)map.get(AssetAttributeItemMeta.ID));
				this.setLayoutColumn( (Integer)map.get(AssetAttributeItemMeta.LAYOUT_COLUMN));
				this.setDimension( (String)map.get(AssetAttributeItemMeta.DIMENSION));
				// others
				this.setAttribute( (AssetAttribute)map.get(AssetAttributeItemMeta.ATTRIBUTE));
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
			this.setLayoutRow(DataParser.parse(Integer.class, r.getValue(AssetAttributeItemMeta.LAYOUT_ROW)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.OWNER_CODE)));
			this.setListSort(DataParser.parse(Integer.class, r.getValue(AssetAttributeItemMeta.LIST_SORT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetAttributeItemMeta.UPDATE_TIME)));
			this.setListContent(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.LIST_CONTENT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetAttributeItemMeta.VERSION)));
			this.setRequired(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.REQUIRED)));
			this.setListShow(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.LIST_SHOW)));
			this.setAttributeId(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.ATTRIBUTE_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetAttributeItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetAttributeItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetAttributeItemMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.TENANT_ID)));
			this.setLayoutType(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.LAYOUT_TYPE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.DELETE_BY)));
			this.setFormShow(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.FORM_SHOW)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.ID)));
			this.setLayoutColumn(DataParser.parse(Integer.class, r.getValue(AssetAttributeItemMeta.LAYOUT_COLUMN)));
			this.setDimension(DataParser.parse(String.class, r.getValue(AssetAttributeItemMeta.DIMENSION)));
			return true;
		} else {
			try {
				this.setLayoutRow( (Integer)r.getValue(AssetAttributeItemMeta.LAYOUT_ROW));
				this.setNotes( (String)r.getValue(AssetAttributeItemMeta.NOTES));
				this.setOwnerCode( (String)r.getValue(AssetAttributeItemMeta.OWNER_CODE));
				this.setListSort( (Integer)r.getValue(AssetAttributeItemMeta.LIST_SORT));
				this.setUpdateTime( (Date)r.getValue(AssetAttributeItemMeta.UPDATE_TIME));
				this.setListContent( (String)r.getValue(AssetAttributeItemMeta.LIST_CONTENT));
				this.setVersion( (Integer)r.getValue(AssetAttributeItemMeta.VERSION));
				this.setRequired( (String)r.getValue(AssetAttributeItemMeta.REQUIRED));
				this.setListShow( (String)r.getValue(AssetAttributeItemMeta.LIST_SHOW));
				this.setAttributeId( (String)r.getValue(AssetAttributeItemMeta.ATTRIBUTE_ID));
				this.setCreateBy( (String)r.getValue(AssetAttributeItemMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetAttributeItemMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetAttributeItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetAttributeItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetAttributeItemMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(AssetAttributeItemMeta.TENANT_ID));
				this.setLayoutType( (String)r.getValue(AssetAttributeItemMeta.LAYOUT_TYPE));
				this.setDeleteBy( (String)r.getValue(AssetAttributeItemMeta.DELETE_BY));
				this.setFormShow( (String)r.getValue(AssetAttributeItemMeta.FORM_SHOW));
				this.setId( (String)r.getValue(AssetAttributeItemMeta.ID));
				this.setLayoutColumn( (Integer)r.getValue(AssetAttributeItemMeta.LAYOUT_COLUMN));
				this.setDimension( (String)r.getValue(AssetAttributeItemMeta.DIMENSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}