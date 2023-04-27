package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_DEPRECIATION_CAL_RULE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetDepreciationCalRuleMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 计算方法
 * <p>计算方法 , 数据表 eam_asset_depreciation_cal_rule 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-27 17:04:42
 * @sign 028FA54B25CCA1BC8071AAAB3CBE628B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_depreciation_cal_rule")
@ApiModel(description = "计算方法 ; 计算方法 , 数据表 eam_asset_depreciation_cal_rule 的PO类型")
public class AssetDepreciationCalRule extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_DEPRECIATION_CAL_RULE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "1")
	private String id;
	
	/**
	 * 折旧方案：折旧方案
	*/
	@ApiModelProperty(required = false,value="折旧方案" , notes = "折旧方案" , example = "647736203386290176")
	private String depreciationId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 动作：动作
	*/
	@ApiModelProperty(required = false,value="动作" , notes = "动作" , example = "depreciation_normal")
	private String actionCode;
	
	/**
	 * 规则编号：规则编号
	*/
	@ApiModelProperty(required = false,value="规则编号" , notes = "规则编号" , example = "300")
	private Integer ruleNumber;
	
	/**
	 * 字段值：字段值
	*/
	@ApiModelProperty(required = false,value="字段值" , notes = "字段值" , example = "s_original_price")
	private String columnValue;
	
	/**
	 * 字段名称：字段名称
	*/
	@ApiModelProperty(required = false,value="字段名称" , notes = "字段名称" , example = "(期初)期初原值")
	private String columnName;
	
	/**
	 * 计算类型：计算类型
	*/
	@ApiModelProperty(required = false,value="计算类型" , notes = "计算类型" , example = "jexl_expression")
	private String calculationType;
	
	/**
	 * 计算方法：计算方法
	*/
	@ApiModelProperty(required = false,value="计算方法" , notes = "计算方法" , example = "asset.assetOriginalUnitPrice")
	private String methodContent;
	
	/**
	 * 方法描述：方法描述
	*/
	@ApiModelProperty(required = false,value="方法描述" , notes = "方法描述" , example = "(期初)期初原值=上一期期末原值")
	private String methodContentInfo;
	
	/**
	 * 返回类型：返回类型
	*/
	@ApiModelProperty(required = false,value="返回类型" , notes = "返回类型" , example = "double")
	private String returnType;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-11-27 08:37:08")
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
	 * 方案：方案
	*/
	@ApiModelProperty(required = false,value="方案" , notes = "方案")
	private AssetDepreciation assetDepreciation;
	
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
	public AssetDepreciationCalRule setId(String id) {
		this.id=id;
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
	public AssetDepreciationCalRule setDepreciationId(String depreciationId) {
		this.depreciationId=depreciationId;
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
	public AssetDepreciationCalRule setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 动作<br>
	 * 动作
	 * @return 动作
	*/
	public String getActionCode() {
		return actionCode;
	}
	
	/**
	 * 设置 动作
	 * @param actionCode 动作
	 * @return 当前对象
	*/
	public AssetDepreciationCalRule setActionCode(String actionCode) {
		this.actionCode=actionCode;
		return this;
	}
	
	/**
	 * 获得 规则编号<br>
	 * 规则编号
	 * @return 规则编号
	*/
	public Integer getRuleNumber() {
		return ruleNumber;
	}
	
	/**
	 * 设置 规则编号
	 * @param ruleNumber 规则编号
	 * @return 当前对象
	*/
	public AssetDepreciationCalRule setRuleNumber(Integer ruleNumber) {
		this.ruleNumber=ruleNumber;
		return this;
	}
	
	/**
	 * 获得 字段值<br>
	 * 字段值
	 * @return 字段值
	*/
	public String getColumnValue() {
		return columnValue;
	}
	
	/**
	 * 设置 字段值
	 * @param columnValue 字段值
	 * @return 当前对象
	*/
	public AssetDepreciationCalRule setColumnValue(String columnValue) {
		this.columnValue=columnValue;
		return this;
	}
	
	/**
	 * 获得 字段名称<br>
	 * 字段名称
	 * @return 字段名称
	*/
	public String getColumnName() {
		return columnName;
	}
	
	/**
	 * 设置 字段名称
	 * @param columnName 字段名称
	 * @return 当前对象
	*/
	public AssetDepreciationCalRule setColumnName(String columnName) {
		this.columnName=columnName;
		return this;
	}
	
	/**
	 * 获得 计算类型<br>
	 * 计算类型
	 * @return 计算类型
	*/
	public String getCalculationType() {
		return calculationType;
	}
	
	/**
	 * 设置 计算类型
	 * @param calculationType 计算类型
	 * @return 当前对象
	*/
	public AssetDepreciationCalRule setCalculationType(String calculationType) {
		this.calculationType=calculationType;
		return this;
	}
	
	/**
	 * 获得 计算方法<br>
	 * 计算方法
	 * @return 计算方法
	*/
	public String getMethodContent() {
		return methodContent;
	}
	
	/**
	 * 设置 计算方法
	 * @param methodContent 计算方法
	 * @return 当前对象
	*/
	public AssetDepreciationCalRule setMethodContent(String methodContent) {
		this.methodContent=methodContent;
		return this;
	}
	
	/**
	 * 获得 方法描述<br>
	 * 方法描述
	 * @return 方法描述
	*/
	public String getMethodContentInfo() {
		return methodContentInfo;
	}
	
	/**
	 * 设置 方法描述
	 * @param methodContentInfo 方法描述
	 * @return 当前对象
	*/
	public AssetDepreciationCalRule setMethodContentInfo(String methodContentInfo) {
		this.methodContentInfo=methodContentInfo;
		return this;
	}
	
	/**
	 * 获得 返回类型<br>
	 * 返回类型
	 * @return 返回类型
	*/
	public String getReturnType() {
		return returnType;
	}
	
	/**
	 * 设置 返回类型
	 * @param returnType 返回类型
	 * @return 当前对象
	*/
	public AssetDepreciationCalRule setReturnType(String returnType) {
		this.returnType=returnType;
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
	public AssetDepreciationCalRule setNotes(String notes) {
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
	public AssetDepreciationCalRule setCreateBy(String createBy) {
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
	public AssetDepreciationCalRule setCreateTime(Date createTime) {
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
	public AssetDepreciationCalRule setUpdateBy(String updateBy) {
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
	public AssetDepreciationCalRule setUpdateTime(Date updateTime) {
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
	public AssetDepreciationCalRule setDeleted(Integer deleted) {
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
	public AssetDepreciationCalRule setDeleted(Boolean deletedBool) {
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
	public AssetDepreciationCalRule setDeleteBy(String deleteBy) {
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
	public AssetDepreciationCalRule setDeleteTime(Date deleteTime) {
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
	public AssetDepreciationCalRule setVersion(Integer version) {
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
	public AssetDepreciationCalRule setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public AssetDepreciationCalRule setAssetDepreciation(AssetDepreciation assetDepreciation) {
		this.assetDepreciation=assetDepreciation;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetDepreciationCalRule , 转换好的 AssetDepreciationCalRule 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDepreciationCalRule , 转换好的 PoJo 对象
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
	public AssetDepreciationCalRule clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetDepreciationCalRule duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetDepreciationCalRuleMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetDepreciationCalRuleMeta.$$proxy$$();
		inst.setCalculationType(this.getCalculationType());
		inst.setNotes(this.getNotes());
		inst.setRuleNumber(this.getRuleNumber());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setMethodContentInfo(this.getMethodContentInfo());
		inst.setColumnValue(this.getColumnValue());
		inst.setVersion(this.getVersion());
		inst.setMethodContent(this.getMethodContent());
		inst.setDepreciationId(this.getDepreciationId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setActionCode(this.getActionCode());
		inst.setId(this.getId());
		inst.setReturnType(this.getReturnType());
		inst.setStatus(this.getStatus());
		inst.setColumnName(this.getColumnName());
		if(all) {
			inst.setAssetDepreciation(this.getAssetDepreciation());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetDepreciationCalRule clone(boolean deep) {
		return EntityContext.clone(AssetDepreciationCalRule.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetDepreciationCalRule
	 * @param assetDepreciationCalRuleMap 包含实体信息的 Map 对象
	 * @return AssetDepreciationCalRule , 转换好的的 AssetDepreciationCalRule 对象
	*/
	@Transient
	public static AssetDepreciationCalRule createFrom(Map<String,Object> assetDepreciationCalRuleMap) {
		if(assetDepreciationCalRuleMap==null) return null;
		AssetDepreciationCalRule po = create();
		EntityContext.copyProperties(po,assetDepreciationCalRuleMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetDepreciationCalRule
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDepreciationCalRule , 转换好的的 AssetDepreciationCalRule 对象
	*/
	@Transient
	public static AssetDepreciationCalRule createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDepreciationCalRule po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetDepreciationCalRule，等同于 new
	 * @return AssetDepreciationCalRule 对象
	*/
	@Transient
	public static AssetDepreciationCalRule create() {
		return new com.dt.platform.domain.eam.meta.AssetDepreciationCalRuleMeta.$$proxy$$();
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
			this.setCalculationType(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.CALCULATION_TYPE)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.NOTES)));
			this.setRuleNumber(DataParser.parse(Integer.class, map.get(AssetDepreciationCalRuleMeta.RULE_NUMBER)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetDepreciationCalRuleMeta.UPDATE_TIME)));
			this.setMethodContentInfo(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.METHOD_CONTENT_INFO)));
			this.setColumnValue(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.COLUMN_VALUE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetDepreciationCalRuleMeta.VERSION)));
			this.setMethodContent(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.METHOD_CONTENT)));
			this.setDepreciationId(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.DEPRECIATION_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetDepreciationCalRuleMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetDepreciationCalRuleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetDepreciationCalRuleMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.DELETE_BY)));
			this.setActionCode(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.ACTION_CODE)));
			this.setId(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.ID)));
			this.setReturnType(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.RETURN_TYPE)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.STATUS)));
			this.setColumnName(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleMeta.COLUMN_NAME)));
			// others
			this.setAssetDepreciation(DataParser.parse(AssetDepreciation.class, map.get(AssetDepreciationCalRuleMeta.ASSET_DEPRECIATION)));
			return true;
		} else {
			try {
				this.setCalculationType( (String)map.get(AssetDepreciationCalRuleMeta.CALCULATION_TYPE));
				this.setNotes( (String)map.get(AssetDepreciationCalRuleMeta.NOTES));
				this.setRuleNumber( (Integer)map.get(AssetDepreciationCalRuleMeta.RULE_NUMBER));
				this.setUpdateTime( (Date)map.get(AssetDepreciationCalRuleMeta.UPDATE_TIME));
				this.setMethodContentInfo( (String)map.get(AssetDepreciationCalRuleMeta.METHOD_CONTENT_INFO));
				this.setColumnValue( (String)map.get(AssetDepreciationCalRuleMeta.COLUMN_VALUE));
				this.setVersion( (Integer)map.get(AssetDepreciationCalRuleMeta.VERSION));
				this.setMethodContent( (String)map.get(AssetDepreciationCalRuleMeta.METHOD_CONTENT));
				this.setDepreciationId( (String)map.get(AssetDepreciationCalRuleMeta.DEPRECIATION_ID));
				this.setCreateBy( (String)map.get(AssetDepreciationCalRuleMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetDepreciationCalRuleMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetDepreciationCalRuleMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetDepreciationCalRuleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetDepreciationCalRuleMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(AssetDepreciationCalRuleMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetDepreciationCalRuleMeta.DELETE_BY));
				this.setActionCode( (String)map.get(AssetDepreciationCalRuleMeta.ACTION_CODE));
				this.setId( (String)map.get(AssetDepreciationCalRuleMeta.ID));
				this.setReturnType( (String)map.get(AssetDepreciationCalRuleMeta.RETURN_TYPE));
				this.setStatus( (String)map.get(AssetDepreciationCalRuleMeta.STATUS));
				this.setColumnName( (String)map.get(AssetDepreciationCalRuleMeta.COLUMN_NAME));
				// others
				this.setAssetDepreciation( (AssetDepreciation)map.get(AssetDepreciationCalRuleMeta.ASSET_DEPRECIATION));
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
			this.setCalculationType(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.CALCULATION_TYPE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.NOTES)));
			this.setRuleNumber(DataParser.parse(Integer.class, r.getValue(AssetDepreciationCalRuleMeta.RULE_NUMBER)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationCalRuleMeta.UPDATE_TIME)));
			this.setMethodContentInfo(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.METHOD_CONTENT_INFO)));
			this.setColumnValue(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.COLUMN_VALUE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetDepreciationCalRuleMeta.VERSION)));
			this.setMethodContent(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.METHOD_CONTENT)));
			this.setDepreciationId(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.DEPRECIATION_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetDepreciationCalRuleMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationCalRuleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationCalRuleMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.DELETE_BY)));
			this.setActionCode(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.ACTION_CODE)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.ID)));
			this.setReturnType(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.RETURN_TYPE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.STATUS)));
			this.setColumnName(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleMeta.COLUMN_NAME)));
			return true;
		} else {
			try {
				this.setCalculationType( (String)r.getValue(AssetDepreciationCalRuleMeta.CALCULATION_TYPE));
				this.setNotes( (String)r.getValue(AssetDepreciationCalRuleMeta.NOTES));
				this.setRuleNumber( (Integer)r.getValue(AssetDepreciationCalRuleMeta.RULE_NUMBER));
				this.setUpdateTime( (Date)r.getValue(AssetDepreciationCalRuleMeta.UPDATE_TIME));
				this.setMethodContentInfo( (String)r.getValue(AssetDepreciationCalRuleMeta.METHOD_CONTENT_INFO));
				this.setColumnValue( (String)r.getValue(AssetDepreciationCalRuleMeta.COLUMN_VALUE));
				this.setVersion( (Integer)r.getValue(AssetDepreciationCalRuleMeta.VERSION));
				this.setMethodContent( (String)r.getValue(AssetDepreciationCalRuleMeta.METHOD_CONTENT));
				this.setDepreciationId( (String)r.getValue(AssetDepreciationCalRuleMeta.DEPRECIATION_ID));
				this.setCreateBy( (String)r.getValue(AssetDepreciationCalRuleMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetDepreciationCalRuleMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetDepreciationCalRuleMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetDepreciationCalRuleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetDepreciationCalRuleMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(AssetDepreciationCalRuleMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetDepreciationCalRuleMeta.DELETE_BY));
				this.setActionCode( (String)r.getValue(AssetDepreciationCalRuleMeta.ACTION_CODE));
				this.setId( (String)r.getValue(AssetDepreciationCalRuleMeta.ID));
				this.setReturnType( (String)r.getValue(AssetDepreciationCalRuleMeta.RETURN_TYPE));
				this.setStatus( (String)r.getValue(AssetDepreciationCalRuleMeta.STATUS));
				this.setColumnName( (String)r.getValue(AssetDepreciationCalRuleMeta.COLUMN_NAME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}