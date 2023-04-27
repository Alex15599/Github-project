package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_DEPRECIATION_HISTORY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 折旧历史
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-04 17:13:19
 * @sign 7F3299A5A79521211664F4C68D688206
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_depreciation_history")
public class AssetDepreciationHistory extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_DEPRECIATION_HISTORY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private String assetId;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号")
	private String businessCode;
	
	/**
	 * 资产编号：资产编号
	*/
	@ApiModelProperty(required = false,value="资产编号" , notes = "资产编号")
	private String assetCode;
	
	/**
	 * 折旧方式：折旧方式
	*/
	@ApiModelProperty(required = false,value="折旧方式" , notes = "折旧方式")
	private String depreciationMethod;
	
	/**
	 * 资产原值：资产原值
	*/
	@ApiModelProperty(required = false,value="资产原值" , notes = "资产原值")
	private BigDecimal originalUnitPrice;
	
	/**
	 * 折旧前价格：折旧前价格
	*/
	@ApiModelProperty(required = false,value="折旧前价格" , notes = "折旧前价格")
	private BigDecimal beforePrice;
	
	/**
	 * 折旧后价格：折旧后价格
	*/
	@ApiModelProperty(required = false,value="折旧后价格" , notes = "折旧后价格")
	private BigDecimal afterPrice;
	
	/**
	 * 折旧额：折旧额
	*/
	@ApiModelProperty(required = false,value="折旧额" , notes = "折旧额")
	private BigDecimal depreciationPrice;
	
	/**
	 * 操作人员：操作人员
	*/
	@ApiModelProperty(required = false,value="操作人员" , notes = "操作人员")
	private String operUserId;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间")
	private Date recordTime;
	
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
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private Asset asset;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String assetName;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
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
	public AssetDepreciationHistory setId(String id) {
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
	public AssetDepreciationHistory setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 业务编号<br>
	 * 业务编号
	 * @return 业务编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编号
	 * @param businessCode 业务编号
	 * @return 当前对象
	*/
	public AssetDepreciationHistory setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 资产编号<br>
	 * 资产编号
	 * @return 资产编号
	*/
	public String getAssetCode() {
		return assetCode;
	}
	
	/**
	 * 设置 资产编号
	 * @param assetCode 资产编号
	 * @return 当前对象
	*/
	public AssetDepreciationHistory setAssetCode(String assetCode) {
		this.assetCode=assetCode;
		return this;
	}
	
	/**
	 * 获得 折旧方式<br>
	 * 折旧方式
	 * @return 折旧方式
	*/
	public String getDepreciationMethod() {
		return depreciationMethod;
	}
	
	/**
	 * 设置 折旧方式
	 * @param depreciationMethod 折旧方式
	 * @return 当前对象
	*/
	public AssetDepreciationHistory setDepreciationMethod(String depreciationMethod) {
		this.depreciationMethod=depreciationMethod;
		return this;
	}
	
	/**
	 * 获得 资产原值<br>
	 * 资产原值
	 * @return 资产原值
	*/
	public BigDecimal getOriginalUnitPrice() {
		return originalUnitPrice;
	}
	
	/**
	 * 设置 资产原值
	 * @param originalUnitPrice 资产原值
	 * @return 当前对象
	*/
	public AssetDepreciationHistory setOriginalUnitPrice(BigDecimal originalUnitPrice) {
		this.originalUnitPrice=originalUnitPrice;
		return this;
	}
	
	/**
	 * 获得 折旧前价格<br>
	 * 折旧前价格
	 * @return 折旧前价格
	*/
	public BigDecimal getBeforePrice() {
		return beforePrice;
	}
	
	/**
	 * 设置 折旧前价格
	 * @param beforePrice 折旧前价格
	 * @return 当前对象
	*/
	public AssetDepreciationHistory setBeforePrice(BigDecimal beforePrice) {
		this.beforePrice=beforePrice;
		return this;
	}
	
	/**
	 * 获得 折旧后价格<br>
	 * 折旧后价格
	 * @return 折旧后价格
	*/
	public BigDecimal getAfterPrice() {
		return afterPrice;
	}
	
	/**
	 * 设置 折旧后价格
	 * @param afterPrice 折旧后价格
	 * @return 当前对象
	*/
	public AssetDepreciationHistory setAfterPrice(BigDecimal afterPrice) {
		this.afterPrice=afterPrice;
		return this;
	}
	
	/**
	 * 获得 折旧额<br>
	 * 折旧额
	 * @return 折旧额
	*/
	public BigDecimal getDepreciationPrice() {
		return depreciationPrice;
	}
	
	/**
	 * 设置 折旧额
	 * @param depreciationPrice 折旧额
	 * @return 当前对象
	*/
	public AssetDepreciationHistory setDepreciationPrice(BigDecimal depreciationPrice) {
		this.depreciationPrice=depreciationPrice;
		return this;
	}
	
	/**
	 * 获得 操作人员<br>
	 * 操作人员
	 * @return 操作人员
	*/
	public String getOperUserId() {
		return operUserId;
	}
	
	/**
	 * 设置 操作人员
	 * @param operUserId 操作人员
	 * @return 当前对象
	*/
	public AssetDepreciationHistory setOperUserId(String operUserId) {
		this.operUserId=operUserId;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRecordTime() {
		return recordTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param recordTime 记录时间
	 * @return 当前对象
	*/
	public AssetDepreciationHistory setRecordTime(Date recordTime) {
		this.recordTime=recordTime;
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
	public AssetDepreciationHistory setNotes(String notes) {
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
	public AssetDepreciationHistory setCreateBy(String createBy) {
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
	public AssetDepreciationHistory setCreateTime(Date createTime) {
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
	public AssetDepreciationHistory setUpdateBy(String updateBy) {
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
	public AssetDepreciationHistory setUpdateTime(Date updateTime) {
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
	public AssetDepreciationHistory setDeleted(Integer deleted) {
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
	public AssetDepreciationHistory setDeleted(Boolean deletedBool) {
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
	public AssetDepreciationHistory setDeleteBy(String deleteBy) {
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
	public AssetDepreciationHistory setDeleteTime(Date deleteTime) {
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
	public AssetDepreciationHistory setVersion(Integer version) {
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
	public AssetDepreciationHistory setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public AssetDepreciationHistory setAsset(Asset asset) {
		this.asset=asset;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public Employee getOriginator() {
		return originator;
	}
	
	/**
	 * 设置 制单人
	 * @param originator 制单人
	 * @return 当前对象
	*/
	public AssetDepreciationHistory setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getAssetName() {
		return assetName;
	}
	
	/**
	 * 设置 名称
	 * @param assetName 名称
	 * @return 当前对象
	*/
	public AssetDepreciationHistory setAssetName(String assetName) {
		this.assetName=assetName;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getAssetModel() {
		return assetModel;
	}
	
	/**
	 * 设置 类型
	 * @param assetModel 类型
	 * @return 当前对象
	*/
	public AssetDepreciationHistory setAssetModel(String assetModel) {
		this.assetModel=assetModel;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetDepreciationHistory , 转换好的 AssetDepreciationHistory 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDepreciationHistory , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetDepreciationHistory
	 * @param assetDepreciationHistoryMap 包含实体信息的 Map 对象
	 * @return AssetDepreciationHistory , 转换好的的 AssetDepreciationHistory 对象
	*/
	@Transient
	public static AssetDepreciationHistory createFrom(Map<String,Object> assetDepreciationHistoryMap) {
		if(assetDepreciationHistoryMap==null) return null;
		AssetDepreciationHistory po = EntityContext.create(AssetDepreciationHistory.class, assetDepreciationHistoryMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetDepreciationHistory
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDepreciationHistory , 转换好的的 AssetDepreciationHistory 对象
	*/
	@Transient
	public static AssetDepreciationHistory createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDepreciationHistory po = EntityContext.create(AssetDepreciationHistory.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetDepreciationHistory，等同于 new
	 * @return AssetDepreciationHistory 对象
	*/
	@Transient
	public static AssetDepreciationHistory create() {
		return EntityContext.create(AssetDepreciationHistory.class);
	}
}