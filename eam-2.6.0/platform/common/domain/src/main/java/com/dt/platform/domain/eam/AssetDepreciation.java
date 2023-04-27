package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_DEPRECIATION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.pcm.Catalog;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetDepreciationMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 折旧方案
 * <p>折旧方案 , 数据表 eam_asset_depreciation 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-27 12:24:36
 * @sign 2167A9512830F2F86763A1931003DE0E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_depreciation")
@ApiModel(description = "折旧方案 ; 折旧方案 , 数据表 eam_asset_depreciation 的PO类型")
public class AssetDepreciation extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_DEPRECIATION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "647736203386290176")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "monthly")
	private String code;
	
	/**
	 * 折旧方案：折旧方案
	*/
	@ApiModelProperty(required = false,value="折旧方案" , notes = "折旧方案" , example = "按月折旧")
	private String name;
	
	/**
	 * 折旧方式：折旧方式
	*/
	@ApiModelProperty(required = false,value="折旧方式" , notes = "折旧方式" , example = "average_age")
	private String method;
	
	/**
	 * 预计残值率：预计残值率
	*/
	@ApiModelProperty(required = false,value="预计残值率" , notes = "预计残值率" , example = "5.00")
	private BigDecimal preResidualRate;
	
	/**
	 * 残值选择：残值选择
	*/
	@ApiModelProperty(required = false,value="残值选择" , notes = "残值选择" , example = "follow_asset")
	private String residualValueSelect;
	
	/**
	 * 首次折旧方式：首次折旧方式
	*/
	@ApiModelProperty(required = false,value="首次折旧方式" , notes = "首次折旧方式" , example = "register_next_month")
	private String firstDepreciationMethod;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private String ownCompanyId;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private String categoryId;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-11-23 09:52:25")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-11-27 08:59:35")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "9")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private List<Catalog> category;
	
	/**
	 * 资产分类Ids：资产分类Ids
	*/
	@ApiModelProperty(required = false,value="资产分类Ids" , notes = "资产分类Ids")
	private List<String> categoryIds;
	
	/**
	 * calRuleList：calRuleList
	*/
	@ApiModelProperty(required = false,value="calRuleList" , notes = "calRuleList")
	private List<AssetDepreciationCalRule> calRuleList;
	
	/**
	 * calRuleIds：calRuleIds
	*/
	@ApiModelProperty(required = false,value="calRuleIds" , notes = "calRuleIds")
	private List<String> calRuleIds;
	
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
	public AssetDepreciation setId(String id) {
		this.id=id;
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
	public AssetDepreciation setStatus(String status) {
		this.status=status;
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
	public AssetDepreciation setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 折旧方案<br>
	 * 折旧方案
	 * @return 折旧方案
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 折旧方案
	 * @param name 折旧方案
	 * @return 当前对象
	*/
	public AssetDepreciation setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 折旧方式<br>
	 * 折旧方式
	 * @return 折旧方式
	*/
	public String getMethod() {
		return method;
	}
	
	/**
	 * 设置 折旧方式
	 * @param method 折旧方式
	 * @return 当前对象
	*/
	public AssetDepreciation setMethod(String method) {
		this.method=method;
		return this;
	}
	
	/**
	 * 获得 预计残值率<br>
	 * 预计残值率
	 * @return 预计残值率
	*/
	public BigDecimal getPreResidualRate() {
		return preResidualRate;
	}
	
	/**
	 * 设置 预计残值率
	 * @param preResidualRate 预计残值率
	 * @return 当前对象
	*/
	public AssetDepreciation setPreResidualRate(BigDecimal preResidualRate) {
		this.preResidualRate=preResidualRate;
		return this;
	}
	
	/**
	 * 获得 残值选择<br>
	 * 残值选择
	 * @return 残值选择
	*/
	public String getResidualValueSelect() {
		return residualValueSelect;
	}
	
	/**
	 * 设置 残值选择
	 * @param residualValueSelect 残值选择
	 * @return 当前对象
	*/
	public AssetDepreciation setResidualValueSelect(String residualValueSelect) {
		this.residualValueSelect=residualValueSelect;
		return this;
	}
	
	/**
	 * 获得 首次折旧方式<br>
	 * 首次折旧方式
	 * @return 首次折旧方式
	*/
	public String getFirstDepreciationMethod() {
		return firstDepreciationMethod;
	}
	
	/**
	 * 设置 首次折旧方式
	 * @param firstDepreciationMethod 首次折旧方式
	 * @return 当前对象
	*/
	public AssetDepreciation setFirstDepreciationMethod(String firstDepreciationMethod) {
		this.firstDepreciationMethod=firstDepreciationMethod;
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public String getOwnCompanyId() {
		return ownCompanyId;
	}
	
	/**
	 * 设置 所属公司
	 * @param ownCompanyId 所属公司
	 * @return 当前对象
	*/
	public AssetDepreciation setOwnCompanyId(String ownCompanyId) {
		this.ownCompanyId=ownCompanyId;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public String getCategoryId() {
		return categoryId;
	}
	
	/**
	 * 设置 资产分类
	 * @param categoryId 资产分类
	 * @return 当前对象
	*/
	public AssetDepreciation setCategoryId(String categoryId) {
		this.categoryId=categoryId;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择
	 * @param selectedCode 选择
	 * @return 当前对象
	*/
	public AssetDepreciation setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public AssetDepreciation setNotes(String notes) {
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
	public AssetDepreciation setCreateBy(String createBy) {
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
	public AssetDepreciation setCreateTime(Date createTime) {
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
	public AssetDepreciation setUpdateBy(String updateBy) {
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
	public AssetDepreciation setUpdateTime(Date updateTime) {
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
	public AssetDepreciation setDeleted(Integer deleted) {
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
	public AssetDepreciation setDeleted(Boolean deletedBool) {
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
	public AssetDepreciation setDeleteBy(String deleteBy) {
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
	public AssetDepreciation setDeleteTime(Date deleteTime) {
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
	public AssetDepreciation setVersion(Integer version) {
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
	public AssetDepreciation setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public List<Catalog> getCategory() {
		return category;
	}
	
	/**
	 * 设置 资产分类
	 * @param category 资产分类
	 * @return 当前对象
	*/
	public AssetDepreciation setCategory(List<Catalog> category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 添加 资产分类
	 * @param entity 资产分类
	 * @return 当前对象
	*/
	public AssetDepreciation addCategory(Catalog... entity) {
		if(this.category==null) category=new ArrayList<>();
		this.category.addAll(Arrays.asList(entity));
		return this;
	}
	
	/**
	 * 获得 资产分类Ids<br>
	 * 资产分类Ids
	 * @return 资产分类Ids
	*/
	public List<String> getCategoryIds() {
		return categoryIds;
	}
	
	/**
	 * 设置 资产分类Ids
	 * @param categoryIds 资产分类Ids
	 * @return 当前对象
	*/
	public AssetDepreciation setCategoryIds(List<String> categoryIds) {
		this.categoryIds=categoryIds;
		return this;
	}
	
	/**
	 * 添加 资产分类Ids
	 * @param categoryId 资产分类Ids
	 * @return 当前对象
	*/
	public AssetDepreciation addCategoryId(String... categoryId) {
		if(this.categoryIds==null) categoryIds=new ArrayList<>();
		this.categoryIds.addAll(Arrays.asList(categoryId));
		return this;
	}
	
	/**
	 * 获得 calRuleList<br>
	 * calRuleList
	 * @return calRuleList
	*/
	public List<AssetDepreciationCalRule> getCalRuleList() {
		return calRuleList;
	}
	
	/**
	 * 设置 calRuleList
	 * @param calRuleList calRuleList
	 * @return 当前对象
	*/
	public AssetDepreciation setCalRuleList(List<AssetDepreciationCalRule> calRuleList) {
		this.calRuleList=calRuleList;
		return this;
	}
	
	/**
	 * 添加 calRuleList
	 * @param calRule calRuleList
	 * @return 当前对象
	*/
	public AssetDepreciation addCalRule(AssetDepreciationCalRule... calRule) {
		if(this.calRuleList==null) calRuleList=new ArrayList<>();
		this.calRuleList.addAll(Arrays.asList(calRule));
		return this;
	}
	
	/**
	 * 获得 calRuleIds<br>
	 * calRuleIds
	 * @return calRuleIds
	*/
	public List<String> getCalRuleIds() {
		return calRuleIds;
	}
	
	/**
	 * 设置 calRuleIds
	 * @param calRuleIds calRuleIds
	 * @return 当前对象
	*/
	public AssetDepreciation setCalRuleIds(List<String> calRuleIds) {
		this.calRuleIds=calRuleIds;
		return this;
	}
	
	/**
	 * 添加 calRuleIds
	 * @param calRuleId calRuleIds
	 * @return 当前对象
	*/
	public AssetDepreciation addCalRuleId(String... calRuleId) {
		if(this.calRuleIds==null) calRuleIds=new ArrayList<>();
		this.calRuleIds.addAll(Arrays.asList(calRuleId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetDepreciation , 转换好的 AssetDepreciation 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDepreciation , 转换好的 PoJo 对象
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
	public AssetDepreciation clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetDepreciation duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetDepreciationMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetDepreciationMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setMethod(this.getMethod());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setResidualValueSelect(this.getResidualValueSelect());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setVersion(this.getVersion());
		inst.setFirstDepreciationMethod(this.getFirstDepreciationMethod());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPreResidualRate(this.getPreResidualRate());
		inst.setId(this.getId());
		inst.setCategoryId(this.getCategoryId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setCategoryIds(this.getCategoryIds());
			inst.setCalRuleList(this.getCalRuleList());
			inst.setCalRuleIds(this.getCalRuleIds());
			inst.setCategory(this.getCategory());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetDepreciation clone(boolean deep) {
		return EntityContext.clone(AssetDepreciation.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetDepreciation
	 * @param assetDepreciationMap 包含实体信息的 Map 对象
	 * @return AssetDepreciation , 转换好的的 AssetDepreciation 对象
	*/
	@Transient
	public static AssetDepreciation createFrom(Map<String,Object> assetDepreciationMap) {
		if(assetDepreciationMap==null) return null;
		AssetDepreciation po = create();
		EntityContext.copyProperties(po,assetDepreciationMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetDepreciation
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDepreciation , 转换好的的 AssetDepreciation 对象
	*/
	@Transient
	public static AssetDepreciation createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDepreciation po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetDepreciation，等同于 new
	 * @return AssetDepreciation 对象
	*/
	@Transient
	public static AssetDepreciation create() {
		return new com.dt.platform.domain.eam.meta.AssetDepreciationMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(AssetDepreciationMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetDepreciationMeta.NOTES)));
			this.setMethod(DataParser.parse(String.class, map.get(AssetDepreciationMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetDepreciationMeta.UPDATE_TIME)));
			this.setResidualValueSelect(DataParser.parse(String.class, map.get(AssetDepreciationMeta.RESIDUAL_VALUE_SELECT)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetDepreciationMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetDepreciationMeta.VERSION)));
			this.setFirstDepreciationMethod(DataParser.parse(String.class, map.get(AssetDepreciationMeta.FIRST_DEPRECIATION_METHOD)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(AssetDepreciationMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetDepreciationMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetDepreciationMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetDepreciationMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetDepreciationMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetDepreciationMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetDepreciationMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetDepreciationMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetDepreciationMeta.DELETE_BY)));
			this.setPreResidualRate(DataParser.parse(BigDecimal.class, map.get(AssetDepreciationMeta.PRE_RESIDUAL_RATE)));
			this.setId(DataParser.parse(String.class, map.get(AssetDepreciationMeta.ID)));
			this.setCategoryId(DataParser.parse(String.class, map.get(AssetDepreciationMeta.CATEGORY_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetDepreciationMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(AssetDepreciationMeta.CODE));
				this.setNotes( (String)map.get(AssetDepreciationMeta.NOTES));
				this.setMethod( (String)map.get(AssetDepreciationMeta.METHOD));
				this.setUpdateTime( (Date)map.get(AssetDepreciationMeta.UPDATE_TIME));
				this.setResidualValueSelect( (String)map.get(AssetDepreciationMeta.RESIDUAL_VALUE_SELECT));
				this.setSelectedCode( (String)map.get(AssetDepreciationMeta.SELECTED_CODE));
				this.setVersion( (Integer)map.get(AssetDepreciationMeta.VERSION));
				this.setFirstDepreciationMethod( (String)map.get(AssetDepreciationMeta.FIRST_DEPRECIATION_METHOD));
				this.setOwnCompanyId( (String)map.get(AssetDepreciationMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)map.get(AssetDepreciationMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetDepreciationMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetDepreciationMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetDepreciationMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetDepreciationMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetDepreciationMeta.NAME));
				this.setTenantId( (String)map.get(AssetDepreciationMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetDepreciationMeta.DELETE_BY));
				this.setPreResidualRate( (BigDecimal)map.get(AssetDepreciationMeta.PRE_RESIDUAL_RATE));
				this.setId( (String)map.get(AssetDepreciationMeta.ID));
				this.setCategoryId( (String)map.get(AssetDepreciationMeta.CATEGORY_ID));
				this.setStatus( (String)map.get(AssetDepreciationMeta.STATUS));
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
			this.setCode(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.NOTES)));
			this.setMethod(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationMeta.UPDATE_TIME)));
			this.setResidualValueSelect(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.RESIDUAL_VALUE_SELECT)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetDepreciationMeta.VERSION)));
			this.setFirstDepreciationMethod(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.FIRST_DEPRECIATION_METHOD)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetDepreciationMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.DELETE_BY)));
			this.setPreResidualRate(DataParser.parse(BigDecimal.class, r.getValue(AssetDepreciationMeta.PRE_RESIDUAL_RATE)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.ID)));
			this.setCategoryId(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.CATEGORY_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetDepreciationMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(AssetDepreciationMeta.CODE));
				this.setNotes( (String)r.getValue(AssetDepreciationMeta.NOTES));
				this.setMethod( (String)r.getValue(AssetDepreciationMeta.METHOD));
				this.setUpdateTime( (Date)r.getValue(AssetDepreciationMeta.UPDATE_TIME));
				this.setResidualValueSelect( (String)r.getValue(AssetDepreciationMeta.RESIDUAL_VALUE_SELECT));
				this.setSelectedCode( (String)r.getValue(AssetDepreciationMeta.SELECTED_CODE));
				this.setVersion( (Integer)r.getValue(AssetDepreciationMeta.VERSION));
				this.setFirstDepreciationMethod( (String)r.getValue(AssetDepreciationMeta.FIRST_DEPRECIATION_METHOD));
				this.setOwnCompanyId( (String)r.getValue(AssetDepreciationMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)r.getValue(AssetDepreciationMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetDepreciationMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetDepreciationMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetDepreciationMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetDepreciationMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetDepreciationMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetDepreciationMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetDepreciationMeta.DELETE_BY));
				this.setPreResidualRate( (BigDecimal)r.getValue(AssetDepreciationMeta.PRE_RESIDUAL_RATE));
				this.setId( (String)r.getValue(AssetDepreciationMeta.ID));
				this.setCategoryId( (String)r.getValue(AssetDepreciationMeta.CATEGORY_ID));
				this.setStatus( (String)r.getValue(AssetDepreciationMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}