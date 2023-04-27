package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_STATUS_RULE_V;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetStatusRuleVMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 状态规则值
 * <p>状态规则值 , 数据表 eam_asset_status_rule_v 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-13 13:02:58
 * @sign 7AB147DF240C1D58587C73E117F6315A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_status_rule_v")
@ApiModel(description = "状态规则值 ; 状态规则值 , 数据表 eam_asset_status_rule_v 的PO类型")
public class AssetStatusRuleV extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_STATUS_RULE_V.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "1")
	private String id;
	
	/**
	 * 操作编码：操作编码
	*/
	@ApiModelProperty(required = false,value="操作编码" , notes = "操作编码" , example = "eam_asset_borrow")
	private String operCode;
	
	/**
	 * 状态编码：状态编码
	*/
	@ApiModelProperty(required = false,value="状态编码" , notes = "状态编码" , example = "borrow")
	private String statusCode;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = true,value="创建人ID" , notes = "创建人ID")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * assetCycleStatus：assetCycleStatus
	*/
	@ApiModelProperty(required = false,value="assetCycleStatus" , notes = "assetCycleStatus")
	private AssetStatus assetCycleStatus;
	
	/**
	 * assetStatusRule：assetStatusRule
	*/
	@ApiModelProperty(required = false,value="assetStatusRule" , notes = "assetStatusRule")
	private AssetStatusRule assetStatusRule;
	
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
	public AssetStatusRuleV setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 操作编码<br>
	 * 操作编码
	 * @return 操作编码
	*/
	public String getOperCode() {
		return operCode;
	}
	
	/**
	 * 设置 操作编码
	 * @param operCode 操作编码
	 * @return 当前对象
	*/
	public AssetStatusRuleV setOperCode(String operCode) {
		this.operCode=operCode;
		return this;
	}
	
	/**
	 * 获得 状态编码<br>
	 * 状态编码
	 * @return 状态编码
	*/
	public String getStatusCode() {
		return statusCode;
	}
	
	/**
	 * 设置 状态编码
	 * @param statusCode 状态编码
	 * @return 当前对象
	*/
	public AssetStatusRuleV setStatusCode(String statusCode) {
		this.statusCode=statusCode;
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
	public AssetStatusRuleV setCreateBy(String createBy) {
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
	public AssetStatusRuleV setCreateTime(Date createTime) {
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
	public AssetStatusRuleV setUpdateBy(String updateBy) {
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
	public AssetStatusRuleV setUpdateTime(Date updateTime) {
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
	public AssetStatusRuleV setDeleted(Integer deleted) {
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
	public AssetStatusRuleV setDeleted(Boolean deletedBool) {
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
	public AssetStatusRuleV setDeleteBy(String deleteBy) {
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
	public AssetStatusRuleV setDeleteTime(Date deleteTime) {
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
	public AssetStatusRuleV setVersion(Integer version) {
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
	public AssetStatusRuleV setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 assetCycleStatus<br>
	 * assetCycleStatus
	 * @return assetCycleStatus
	*/
	public AssetStatus getAssetCycleStatus() {
		return assetCycleStatus;
	}
	
	/**
	 * 设置 assetCycleStatus
	 * @param assetCycleStatus assetCycleStatus
	 * @return 当前对象
	*/
	public AssetStatusRuleV setAssetCycleStatus(AssetStatus assetCycleStatus) {
		this.assetCycleStatus=assetCycleStatus;
		return this;
	}
	
	/**
	 * 获得 assetStatusRule<br>
	 * assetStatusRule
	 * @return assetStatusRule
	*/
	public AssetStatusRule getAssetStatusRule() {
		return assetStatusRule;
	}
	
	/**
	 * 设置 assetStatusRule
	 * @param assetStatusRule assetStatusRule
	 * @return 当前对象
	*/
	public AssetStatusRuleV setAssetStatusRule(AssetStatusRule assetStatusRule) {
		this.assetStatusRule=assetStatusRule;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetStatusRuleV , 转换好的 AssetStatusRuleV 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStatusRuleV , 转换好的 PoJo 对象
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
	public AssetStatusRuleV clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetStatusRuleV duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetStatusRuleVMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetStatusRuleVMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setOperCode(this.getOperCode());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		inst.setStatusCode(this.getStatusCode());
		if(all) {
			inst.setAssetCycleStatus(this.getAssetCycleStatus());
			inst.setAssetStatusRule(this.getAssetStatusRule());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetStatusRuleV clone(boolean deep) {
		return EntityContext.clone(AssetStatusRuleV.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetStatusRuleV
	 * @param assetStatusRuleVMap 包含实体信息的 Map 对象
	 * @return AssetStatusRuleV , 转换好的的 AssetStatusRuleV 对象
	*/
	@Transient
	public static AssetStatusRuleV createFrom(Map<String,Object> assetStatusRuleVMap) {
		if(assetStatusRuleVMap==null) return null;
		AssetStatusRuleV po = create();
		EntityContext.copyProperties(po,assetStatusRuleVMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetStatusRuleV
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStatusRuleV , 转换好的的 AssetStatusRuleV 对象
	*/
	@Transient
	public static AssetStatusRuleV createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStatusRuleV po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetStatusRuleV，等同于 new
	 * @return AssetStatusRuleV 对象
	*/
	@Transient
	public static AssetStatusRuleV create() {
		return new com.dt.platform.domain.eam.meta.AssetStatusRuleVMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetStatusRuleVMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetStatusRuleVMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetStatusRuleVMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetStatusRuleVMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetStatusRuleVMeta.DELETE_TIME)));
			this.setOperCode(DataParser.parse(String.class, map.get(AssetStatusRuleVMeta.OPER_CODE)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetStatusRuleVMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetStatusRuleVMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetStatusRuleVMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(AssetStatusRuleVMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetStatusRuleVMeta.VERSION)));
			this.setStatusCode(DataParser.parse(String.class, map.get(AssetStatusRuleVMeta.STATUS_CODE)));
			// others
			this.setAssetCycleStatus(DataParser.parse(AssetStatus.class, map.get(AssetStatusRuleVMeta.ASSET_CYCLE_STATUS)));
			this.setAssetStatusRule(DataParser.parse(AssetStatusRule.class, map.get(AssetStatusRuleVMeta.ASSET_STATUS_RULE)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(AssetStatusRuleVMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetStatusRuleVMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetStatusRuleVMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetStatusRuleVMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetStatusRuleVMeta.DELETE_TIME));
				this.setOperCode( (String)map.get(AssetStatusRuleVMeta.OPER_CODE));
				this.setTenantId( (String)map.get(AssetStatusRuleVMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetStatusRuleVMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(AssetStatusRuleVMeta.UPDATE_TIME));
				this.setId( (String)map.get(AssetStatusRuleVMeta.ID));
				this.setVersion( (Integer)map.get(AssetStatusRuleVMeta.VERSION));
				this.setStatusCode( (String)map.get(AssetStatusRuleVMeta.STATUS_CODE));
				// others
				this.setAssetCycleStatus( (AssetStatus)map.get(AssetStatusRuleVMeta.ASSET_CYCLE_STATUS));
				this.setAssetStatusRule( (AssetStatusRule)map.get(AssetStatusRuleVMeta.ASSET_STATUS_RULE));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetStatusRuleVMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetStatusRuleVMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetStatusRuleVMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetStatusRuleVMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetStatusRuleVMeta.DELETE_TIME)));
			this.setOperCode(DataParser.parse(String.class, r.getValue(AssetStatusRuleVMeta.OPER_CODE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetStatusRuleVMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetStatusRuleVMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetStatusRuleVMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetStatusRuleVMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetStatusRuleVMeta.VERSION)));
			this.setStatusCode(DataParser.parse(String.class, r.getValue(AssetStatusRuleVMeta.STATUS_CODE)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(AssetStatusRuleVMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetStatusRuleVMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetStatusRuleVMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetStatusRuleVMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetStatusRuleVMeta.DELETE_TIME));
				this.setOperCode( (String)r.getValue(AssetStatusRuleVMeta.OPER_CODE));
				this.setTenantId( (String)r.getValue(AssetStatusRuleVMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetStatusRuleVMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(AssetStatusRuleVMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(AssetStatusRuleVMeta.ID));
				this.setVersion( (Integer)r.getValue(AssetStatusRuleVMeta.VERSION));
				this.setStatusCode( (String)r.getValue(AssetStatusRuleVMeta.STATUS_CODE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}