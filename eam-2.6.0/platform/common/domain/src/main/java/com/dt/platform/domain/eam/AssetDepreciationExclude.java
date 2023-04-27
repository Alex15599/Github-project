package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_DEPRECIATION_EXCLUDE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetDepreciationExcludeMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 折旧排除
 * <p>折旧排除 , 数据表 eam_asset_depreciation_exclude 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-28 20:42:05
 * @sign D4BE7365B29CEE64D914AC37CB332BC9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_depreciation_exclude")
@ApiModel(description = "折旧排除 ; 折旧排除 , 数据表 eam_asset_depreciation_exclude 的PO类型")
public class AssetDepreciationExclude extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_DEPRECIATION_EXCLUDE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "649264051653705728")
	private String id;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产" , example = "649264028098494465")
	private String assetId;
	
	/**
	 * 折旧方案：折旧方案
	*/
	@ApiModelProperty(required = false,value="折旧方案" , notes = "折旧方案" , example = "647736203386290176")
	private String depreciationId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "折旧排除")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 方案：方案
	*/
	@ApiModelProperty(required = false,value="方案" , notes = "方案")
	private AssetDepreciation assetDepreciation;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private Asset asset;
	
	/**
	 * assetCode：assetCode
	*/
	@ApiModelProperty(required = false,value="assetCode" , notes = "assetCode")
	private String assetCode;
	
	/**
	 * assetName：assetName
	*/
	@ApiModelProperty(required = false,value="assetName" , notes = "assetName")
	private String assetName;
	
	/**
	 * assetModel：assetModel
	*/
	@ApiModelProperty(required = false,value="assetModel" , notes = "assetModel")
	private String assetModel;
	
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
	public AssetDepreciationExclude setId(String id) {
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
	public AssetDepreciationExclude setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 折旧方案<br>
	 * 折旧方案
	 * @return 折旧方案
	*/
	public String getDepreciationId() {
		return depreciationId;
	}
	
	/**
	 * 设置 折旧方案
	 * @param depreciationId 折旧方案
	 * @return 当前对象
	*/
	public AssetDepreciationExclude setDepreciationId(String depreciationId) {
		this.depreciationId=depreciationId;
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
	public AssetDepreciationExclude setNotes(String notes) {
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
	public AssetDepreciationExclude setCreateBy(String createBy) {
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
	public AssetDepreciationExclude setCreateTime(Date createTime) {
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
	public AssetDepreciationExclude setUpdateBy(String updateBy) {
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
	public AssetDepreciationExclude setUpdateTime(Date updateTime) {
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
	public AssetDepreciationExclude setDeleted(Integer deleted) {
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
	public AssetDepreciationExclude setDeleted(Boolean deletedBool) {
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
	public AssetDepreciationExclude setDeleteBy(String deleteBy) {
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
	public AssetDepreciationExclude setDeleteTime(Date deleteTime) {
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
	public AssetDepreciationExclude setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 方案<br>
	 * 方案
	 * @return 方案
	*/
	public AssetDepreciation getAssetDepreciation() {
		return assetDepreciation;
	}
	
	/**
	 * 设置 方案
	 * @param assetDepreciation 方案
	 * @return 当前对象
	*/
	public AssetDepreciationExclude setAssetDepreciation(AssetDepreciation assetDepreciation) {
		this.assetDepreciation=assetDepreciation;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public Asset getAsset() {
		return asset;
	}
	
	/**
	 * 设置 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public AssetDepreciationExclude setAsset(Asset asset) {
		this.asset=asset;
		return this;
	}
	
	/**
	 * 获得 assetCode<br>
	 * assetCode
	 * @return assetCode
	*/
	public String getAssetCode() {
		return assetCode;
	}
	
	/**
	 * 设置 assetCode
	 * @param assetCode assetCode
	 * @return 当前对象
	*/
	public AssetDepreciationExclude setAssetCode(String assetCode) {
		this.assetCode=assetCode;
		return this;
	}
	
	/**
	 * 获得 assetName<br>
	 * assetName
	 * @return assetName
	*/
	public String getAssetName() {
		return assetName;
	}
	
	/**
	 * 设置 assetName
	 * @param assetName assetName
	 * @return 当前对象
	*/
	public AssetDepreciationExclude setAssetName(String assetName) {
		this.assetName=assetName;
		return this;
	}
	
	/**
	 * 获得 assetModel<br>
	 * assetModel
	 * @return assetModel
	*/
	public String getAssetModel() {
		return assetModel;
	}
	
	/**
	 * 设置 assetModel
	 * @param assetModel assetModel
	 * @return 当前对象
	*/
	public AssetDepreciationExclude setAssetModel(String assetModel) {
		this.assetModel=assetModel;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetDepreciationExclude , 转换好的 AssetDepreciationExclude 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDepreciationExclude , 转换好的 PoJo 对象
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
	public AssetDepreciationExclude clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetDepreciationExclude duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetDepreciationExcludeMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetDepreciationExcludeMeta.$$proxy$$();
		inst.setDepreciationId(this.getDepreciationId());
		inst.setCreateBy(this.getCreateBy());
		inst.setNotes(this.getNotes());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		if(all) {
			inst.setAssetCode(this.getAssetCode());
			inst.setAssetModel(this.getAssetModel());
			inst.setAssetName(this.getAssetName());
			inst.setAsset(this.getAsset());
			inst.setAssetDepreciation(this.getAssetDepreciation());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetDepreciationExclude clone(boolean deep) {
		return EntityContext.clone(AssetDepreciationExclude.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetDepreciationExclude
	 * @param assetDepreciationExcludeMap 包含实体信息的 Map 对象
	 * @return AssetDepreciationExclude , 转换好的的 AssetDepreciationExclude 对象
	*/
	@Transient
	public static AssetDepreciationExclude createFrom(Map<String,Object> assetDepreciationExcludeMap) {
		if(assetDepreciationExcludeMap==null) return null;
		AssetDepreciationExclude po = create();
		EntityContext.copyProperties(po,assetDepreciationExcludeMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetDepreciationExclude
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDepreciationExclude , 转换好的的 AssetDepreciationExclude 对象
	*/
	@Transient
	public static AssetDepreciationExclude createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDepreciationExclude po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetDepreciationExclude，等同于 new
	 * @return AssetDepreciationExclude 对象
	*/
	@Transient
	public static AssetDepreciationExclude create() {
		return new com.dt.platform.domain.eam.meta.AssetDepreciationExcludeMeta.$$proxy$$();
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
			this.setDepreciationId(DataParser.parse(String.class, map.get(AssetDepreciationExcludeMeta.DEPRECIATION_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetDepreciationExcludeMeta.CREATE_BY)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetDepreciationExcludeMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetDepreciationExcludeMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetDepreciationExcludeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetDepreciationExcludeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetDepreciationExcludeMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(AssetDepreciationExcludeMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetDepreciationExcludeMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetDepreciationExcludeMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(AssetDepreciationExcludeMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetDepreciationExcludeMeta.VERSION)));
			// others
			this.setAssetCode(DataParser.parse(String.class, map.get(AssetDepreciationExcludeMeta.ASSET_CODE)));
			this.setAssetModel(DataParser.parse(String.class, map.get(AssetDepreciationExcludeMeta.ASSET_MODEL)));
			this.setAssetName(DataParser.parse(String.class, map.get(AssetDepreciationExcludeMeta.ASSET_NAME)));
			this.setAsset(DataParser.parse(Asset.class, map.get(AssetDepreciationExcludeMeta.ASSET)));
			this.setAssetDepreciation(DataParser.parse(AssetDepreciation.class, map.get(AssetDepreciationExcludeMeta.ASSET_DEPRECIATION)));
			return true;
		} else {
			try {
				this.setDepreciationId( (String)map.get(AssetDepreciationExcludeMeta.DEPRECIATION_ID));
				this.setCreateBy( (String)map.get(AssetDepreciationExcludeMeta.CREATE_BY));
				this.setNotes( (String)map.get(AssetDepreciationExcludeMeta.NOTES));
				this.setDeleted( (Integer)map.get(AssetDepreciationExcludeMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetDepreciationExcludeMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetDepreciationExcludeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetDepreciationExcludeMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(AssetDepreciationExcludeMeta.ASSET_ID));
				this.setDeleteBy( (String)map.get(AssetDepreciationExcludeMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(AssetDepreciationExcludeMeta.UPDATE_TIME));
				this.setId( (String)map.get(AssetDepreciationExcludeMeta.ID));
				this.setVersion( (Integer)map.get(AssetDepreciationExcludeMeta.VERSION));
				// others
				this.setAssetCode( (String)map.get(AssetDepreciationExcludeMeta.ASSET_CODE));
				this.setAssetModel( (String)map.get(AssetDepreciationExcludeMeta.ASSET_MODEL));
				this.setAssetName( (String)map.get(AssetDepreciationExcludeMeta.ASSET_NAME));
				this.setAsset( (Asset)map.get(AssetDepreciationExcludeMeta.ASSET));
				this.setAssetDepreciation( (AssetDepreciation)map.get(AssetDepreciationExcludeMeta.ASSET_DEPRECIATION));
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
			this.setDepreciationId(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeMeta.DEPRECIATION_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeMeta.CREATE_BY)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetDepreciationExcludeMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationExcludeMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationExcludeMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationExcludeMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetDepreciationExcludeMeta.VERSION)));
			return true;
		} else {
			try {
				this.setDepreciationId( (String)r.getValue(AssetDepreciationExcludeMeta.DEPRECIATION_ID));
				this.setCreateBy( (String)r.getValue(AssetDepreciationExcludeMeta.CREATE_BY));
				this.setNotes( (String)r.getValue(AssetDepreciationExcludeMeta.NOTES));
				this.setDeleted( (Integer)r.getValue(AssetDepreciationExcludeMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetDepreciationExcludeMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetDepreciationExcludeMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetDepreciationExcludeMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(AssetDepreciationExcludeMeta.ASSET_ID));
				this.setDeleteBy( (String)r.getValue(AssetDepreciationExcludeMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(AssetDepreciationExcludeMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(AssetDepreciationExcludeMeta.ID));
				this.setVersion( (Integer)r.getValue(AssetDepreciationExcludeMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}