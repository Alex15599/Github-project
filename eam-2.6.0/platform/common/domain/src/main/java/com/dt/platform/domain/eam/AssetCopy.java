package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_COPY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetCopyMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产复制
 * <p>资产复制 , 数据表 eam_asset_copy 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-16 12:39:45
 * @sign F9A7309258946BCFF8E406B53EB9E778
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_copy")
@ApiModel(description = "资产复制 ; 资产复制 , 数据表 eam_asset_copy 的PO类型")
public class AssetCopy extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_COPY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "645240338448908288")
	private String id;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产" , example = "644266092318949376")
	private String assetId;
	
	/**
	 * 复制数量：复制数量
	*/
	@ApiModelProperty(required = false,value="复制数量" , notes = "复制数量" , example = "1")
	private Integer assetNumber;
	
	/**
	 * 说明：说明
	*/
	@ApiModelProperty(required = false,value="说明" , notes = "说明")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-11-16 12:34:45")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-11-16 12:34:45")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "2")
	private Integer version;
	
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
	public AssetCopy setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public String getAssetId() {
		return assetId;
	}
	
	/**
	 * 设置 资产
	 * @param assetId 资产
	 * @return 当前对象
	*/
	public AssetCopy setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 复制数量<br>
	 * 复制数量
	 * @return 复制数量
	*/
	public Integer getAssetNumber() {
		return assetNumber;
	}
	
	/**
	 * 设置 复制数量
	 * @param assetNumber 复制数量
	 * @return 当前对象
	*/
	public AssetCopy setAssetNumber(Integer assetNumber) {
		this.assetNumber=assetNumber;
		return this;
	}
	
	/**
	 * 获得 说明<br>
	 * 说明
	 * @return 说明
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 说明
	 * @param notes 说明
	 * @return 当前对象
	*/
	public AssetCopy setNotes(String notes) {
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
	public AssetCopy setCreateBy(String createBy) {
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
	public AssetCopy setCreateTime(Date createTime) {
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
	public AssetCopy setUpdateBy(String updateBy) {
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
	public AssetCopy setUpdateTime(Date updateTime) {
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
	public AssetCopy setDeleted(Integer deleted) {
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
	public AssetCopy setDeleted(Boolean deletedBool) {
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
	public AssetCopy setDeleteBy(String deleteBy) {
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
	public AssetCopy setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public AssetCopy setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public AssetCopy setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetCopy , 转换好的 AssetCopy 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetCopy , 转换好的 PoJo 对象
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
	public AssetCopy clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetCopy duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetCopyMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetCopyMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setAssetNumber(this.getAssetNumber());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
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
	public AssetCopy clone(boolean deep) {
		return EntityContext.clone(AssetCopy.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetCopy
	 * @param assetCopyMap 包含实体信息的 Map 对象
	 * @return AssetCopy , 转换好的的 AssetCopy 对象
	*/
	@Transient
	public static AssetCopy createFrom(Map<String,Object> assetCopyMap) {
		if(assetCopyMap==null) return null;
		AssetCopy po = create();
		EntityContext.copyProperties(po,assetCopyMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetCopy
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetCopy , 转换好的的 AssetCopy 对象
	*/
	@Transient
	public static AssetCopy createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetCopy po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetCopy，等同于 new
	 * @return AssetCopy 对象
	*/
	@Transient
	public static AssetCopy create() {
		return new com.dt.platform.domain.eam.meta.AssetCopyMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssetCopyMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetCopyMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetCopyMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetCopyMeta.CREATE_BY)));
			this.setAssetNumber(DataParser.parse(Integer.class, map.get(AssetCopyMeta.ASSET_NUMBER)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetCopyMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetCopyMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetCopyMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetCopyMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(AssetCopyMeta.ASSET_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetCopyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetCopyMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetCopyMeta.ID)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssetCopyMeta.NOTES));
				this.setUpdateTime( (Date)map.get(AssetCopyMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetCopyMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetCopyMeta.CREATE_BY));
				this.setAssetNumber( (Integer)map.get(AssetCopyMeta.ASSET_NUMBER));
				this.setDeleted( (Integer)map.get(AssetCopyMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetCopyMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetCopyMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetCopyMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(AssetCopyMeta.ASSET_ID));
				this.setTenantId( (String)map.get(AssetCopyMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetCopyMeta.DELETE_BY));
				this.setId( (String)map.get(AssetCopyMeta.ID));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetCopyMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetCopyMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetCopyMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetCopyMeta.CREATE_BY)));
			this.setAssetNumber(DataParser.parse(Integer.class, r.getValue(AssetCopyMeta.ASSET_NUMBER)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetCopyMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetCopyMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetCopyMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetCopyMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(AssetCopyMeta.ASSET_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetCopyMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetCopyMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetCopyMeta.ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssetCopyMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(AssetCopyMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetCopyMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetCopyMeta.CREATE_BY));
				this.setAssetNumber( (Integer)r.getValue(AssetCopyMeta.ASSET_NUMBER));
				this.setDeleted( (Integer)r.getValue(AssetCopyMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetCopyMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetCopyMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetCopyMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(AssetCopyMeta.ASSET_ID));
				this.setTenantId( (String)r.getValue(AssetCopyMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetCopyMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetCopyMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}