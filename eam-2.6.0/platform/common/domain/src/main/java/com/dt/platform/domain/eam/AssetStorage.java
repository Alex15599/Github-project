package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_STORAGE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetStorageMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产入库
 * <p>资产入库 , 数据表 eam_asset_storage 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-07 15:34:13
 * @sign 7FB08675CC4466CA4FC88B5516E96A12
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_storage")
@ApiModel(description = "资产入库 ; 资产入库 , 数据表 eam_asset_storage 的PO类型")
public class AssetStorage extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_STORAGE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号")
	private String businessCode;
	
	/**
	 * 流程：流程
	*/
	@ApiModelProperty(required = false,value="流程" , notes = "流程")
	private String procId;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态")
	private String status;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称")
	private String name;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private String supplierId;
	
	/**
	 * 供应商备注：供应商备注
	*/
	@ApiModelProperty(required = false,value="供应商备注" , notes = "供应商备注")
	private String supplierInfo;
	
	/**
	 * 归属公司：归属公司
	*/
	@ApiModelProperty(required = false,value="归属公司" , notes = "归属公司")
	private String ownCompanyId;
	
	/**
	 * 管理人员：管理人员
	*/
	@ApiModelProperty(required = false,value="管理人员" , notes = "管理人员")
	private String managerUserId;
	
	/**
	 * 位置信息：位置信息
	*/
	@ApiModelProperty(required = false,value="位置信息" , notes = "位置信息")
	private String locationName;
	
	/**
	 * 入库说明：入库说明
	*/
	@ApiModelProperty(required = false,value="入库说明" , notes = "入库说明")
	private String content;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期")
	private Date businessDate;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attach;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
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
	 * 自定义数据：自定义数据
	*/
	@ApiModelProperty(required = false,value="自定义数据" , notes = "自定义数据")
	private String customData;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * 申请人：申请人
	*/
	@ApiModelProperty(required = false,value="申请人" , notes = "申请人")
	private String originatorUserName;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private List<Asset> assetList;
	
	/**
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<String> assetIds;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 管理人员：管理人员
	*/
	@ApiModelProperty(required = false,value="管理人员" , notes = "管理人员")
	private Employee managerUser;
	
	/**
	 * 所属公司：所属公司
	*/
	@ApiModelProperty(required = false,value="所属公司" , notes = "所属公司")
	private Organization ownerCompany;
	
	/**
	 * 供应商：供应商
	*/
	@ApiModelProperty(required = false,value="供应商" , notes = "供应商")
	private Supplier supplier;
	
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
	public AssetStorage setId(String id) {
		this.id=id;
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
	public AssetStorage setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 流程<br>
	 * 流程
	 * @return 流程
	*/
	public String getProcId() {
		return procId;
	}
	
	/**
	 * 设置 流程
	 * @param procId 流程
	 * @return 当前对象
	*/
	public AssetStorage setProcId(String procId) {
		this.procId=procId;
		return this;
	}
	
	/**
	 * 获得 办理状态<br>
	 * 办理状态
	 * @return 办理状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 办理状态
	 * @param status 办理状态
	 * @return 当前对象
	*/
	public AssetStorage setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 业务名称<br>
	 * 业务名称
	 * @return 业务名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 业务名称
	 * @param name 业务名称
	 * @return 当前对象
	*/
	public AssetStorage setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 供应商<br>
	 * 供应商
	 * @return 供应商
	*/
	public String getSupplierId() {
		return supplierId;
	}
	
	/**
	 * 设置 供应商
	 * @param supplierId 供应商
	 * @return 当前对象
	*/
	public AssetStorage setSupplierId(String supplierId) {
		this.supplierId=supplierId;
		return this;
	}
	
	/**
	 * 获得 供应商备注<br>
	 * 供应商备注
	 * @return 供应商备注
	*/
	public String getSupplierInfo() {
		return supplierInfo;
	}
	
	/**
	 * 设置 供应商备注
	 * @param supplierInfo 供应商备注
	 * @return 当前对象
	*/
	public AssetStorage setSupplierInfo(String supplierInfo) {
		this.supplierInfo=supplierInfo;
		return this;
	}
	
	/**
	 * 获得 归属公司<br>
	 * 归属公司
	 * @return 归属公司
	*/
	public String getOwnCompanyId() {
		return ownCompanyId;
	}
	
	/**
	 * 设置 归属公司
	 * @param ownCompanyId 归属公司
	 * @return 当前对象
	*/
	public AssetStorage setOwnCompanyId(String ownCompanyId) {
		this.ownCompanyId=ownCompanyId;
		return this;
	}
	
	/**
	 * 获得 管理人员<br>
	 * 管理人员
	 * @return 管理人员
	*/
	public String getManagerUserId() {
		return managerUserId;
	}
	
	/**
	 * 设置 管理人员
	 * @param managerUserId 管理人员
	 * @return 当前对象
	*/
	public AssetStorage setManagerUserId(String managerUserId) {
		this.managerUserId=managerUserId;
		return this;
	}
	
	/**
	 * 获得 位置信息<br>
	 * 位置信息
	 * @return 位置信息
	*/
	public String getLocationName() {
		return locationName;
	}
	
	/**
	 * 设置 位置信息
	 * @param locationName 位置信息
	 * @return 当前对象
	*/
	public AssetStorage setLocationName(String locationName) {
		this.locationName=locationName;
		return this;
	}
	
	/**
	 * 获得 入库说明<br>
	 * 入库说明
	 * @return 入库说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 入库说明
	 * @param content 入库说明
	 * @return 当前对象
	*/
	public AssetStorage setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 业务日期<br>
	 * 业务日期
	 * @return 业务日期
	*/
	public Date getBusinessDate() {
		return businessDate;
	}
	
	/**
	 * 设置 业务日期
	 * @param businessDate 业务日期
	 * @return 当前对象
	*/
	public AssetStorage setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttach() {
		return attach;
	}
	
	/**
	 * 设置 附件
	 * @param attach 附件
	 * @return 当前对象
	*/
	public AssetStorage setAttach(String attach) {
		this.attach=attach;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人
	 * @param originatorId 制单人
	 * @return 当前对象
	*/
	public AssetStorage setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public AssetStorage setCreateBy(String createBy) {
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
	public AssetStorage setCreateTime(Date createTime) {
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
	public AssetStorage setUpdateBy(String updateBy) {
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
	public AssetStorage setUpdateTime(Date updateTime) {
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
	public AssetStorage setDeleted(Integer deleted) {
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
	public AssetStorage setDeleted(Boolean deletedBool) {
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
	public AssetStorage setDeleteBy(String deleteBy) {
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
	public AssetStorage setDeleteTime(Date deleteTime) {
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
	public AssetStorage setVersion(Integer version) {
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
	public AssetStorage setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 自定义数据<br>
	 * 自定义数据
	 * @return 自定义数据
	*/
	public String getCustomData() {
		return customData;
	}
	
	/**
	 * 设置 自定义数据
	 * @param customData 自定义数据
	 * @return 当前对象
	*/
	public AssetStorage setCustomData(String customData) {
		this.customData=customData;
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
	public AssetStorage setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 申请人<br>
	 * 申请人
	 * @return 申请人
	*/
	public String getOriginatorUserName() {
		return originatorUserName;
	}
	
	/**
	 * 设置 申请人
	 * @param originatorUserName 申请人
	 * @return 当前对象
	*/
	public AssetStorage setOriginatorUserName(String originatorUserName) {
		this.originatorUserName=originatorUserName;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<Asset> getAssetList() {
		return assetList;
	}
	
	/**
	 * 设置 资产
	 * @param assetList 资产
	 * @return 当前对象
	*/
	public AssetStorage setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public AssetStorage addAsset(Asset... asset) {
		if(this.assetList==null) assetList=new ArrayList<>();
		this.assetList.addAll(Arrays.asList(asset));
		return this;
	}
	
	/**
	 * 获得 资产列表<br>
	 * 资产列表
	 * @return 资产列表
	*/
	public List<String> getAssetIds() {
		return assetIds;
	}
	
	/**
	 * 设置 资产列表
	 * @param assetIds 资产列表
	 * @return 当前对象
	*/
	public AssetStorage setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public AssetStorage addAssetId(String... assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.addAll(Arrays.asList(assetId));
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
	public AssetStorage setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 管理人员<br>
	 * 管理人员
	 * @return 管理人员
	*/
	public Employee getManagerUser() {
		return managerUser;
	}
	
	/**
	 * 设置 管理人员
	 * @param managerUser 管理人员
	 * @return 当前对象
	*/
	public AssetStorage setManagerUser(Employee managerUser) {
		this.managerUser=managerUser;
		return this;
	}
	
	/**
	 * 获得 所属公司<br>
	 * 所属公司
	 * @return 所属公司
	*/
	public Organization getOwnerCompany() {
		return ownerCompany;
	}
	
	/**
	 * 设置 所属公司
	 * @param ownerCompany 所属公司
	 * @return 当前对象
	*/
	public AssetStorage setOwnerCompany(Organization ownerCompany) {
		this.ownerCompany=ownerCompany;
		return this;
	}
	
	/**
	 * 获得 供应商<br>
	 * 供应商
	 * @return 供应商
	*/
	public Supplier getSupplier() {
		return supplier;
	}
	
	/**
	 * 设置 供应商
	 * @param supplier 供应商
	 * @return 当前对象
	*/
	public AssetStorage setSupplier(Supplier supplier) {
		this.supplier=supplier;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetStorage , 转换好的 AssetStorage 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStorage , 转换好的 PoJo 对象
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
	public AssetStorage clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetStorage duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetStorageMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetStorageMeta.$$proxy$$();
		inst.setSupplierId(this.getSupplierId());
		inst.setProcId(this.getProcId());
		inst.setCustomData(this.getCustomData());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setSupplierInfo(this.getSupplierInfo());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setAttach(this.getAttach());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setLocationName(this.getLocationName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setManagerUserId(this.getManagerUserId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setSupplier(this.getSupplier());
			inst.setAssetIds(this.getAssetIds());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setOriginatorUserName(this.getOriginatorUserName());
			inst.setManagerUser(this.getManagerUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetStorage clone(boolean deep) {
		return EntityContext.clone(AssetStorage.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetStorage
	 * @param assetStorageMap 包含实体信息的 Map 对象
	 * @return AssetStorage , 转换好的的 AssetStorage 对象
	*/
	@Transient
	public static AssetStorage createFrom(Map<String,Object> assetStorageMap) {
		if(assetStorageMap==null) return null;
		AssetStorage po = create();
		EntityContext.copyProperties(po,assetStorageMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetStorage
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStorage , 转换好的的 AssetStorage 对象
	*/
	@Transient
	public static AssetStorage createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStorage po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetStorage，等同于 new
	 * @return AssetStorage 对象
	*/
	@Transient
	public static AssetStorage create() {
		return new com.dt.platform.domain.eam.meta.AssetStorageMeta.$$proxy$$();
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
			this.setSupplierId(DataParser.parse(String.class, map.get(AssetStorageMeta.SUPPLIER_ID)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetStorageMeta.PROC_ID)));
			this.setCustomData(DataParser.parse(String.class, map.get(AssetStorageMeta.CUSTOM_DATA)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetStorageMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetStorageMeta.CONTENT)));
			this.setSupplierInfo(DataParser.parse(String.class, map.get(AssetStorageMeta.SUPPLIER_INFO)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetStorageMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetStorageMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetStorageMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetStorageMeta.ID)));
			this.setAttach(DataParser.parse(String.class, map.get(AssetStorageMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetStorageMeta.ORIGINATOR_ID)));
			this.setLocationName(DataParser.parse(String.class, map.get(AssetStorageMeta.LOCATION_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetStorageMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetStorageMeta.VERSION)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(AssetStorageMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetStorageMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetStorageMeta.DELETED)));
			this.setManagerUserId(DataParser.parse(String.class, map.get(AssetStorageMeta.MANAGER_USER_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetStorageMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetStorageMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetStorageMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetStorageMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetStorageMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetStorageMeta.STATUS)));
			// others
			this.setOwnerCompany(DataParser.parse(Organization.class, map.get(AssetStorageMeta.OWNER_COMPANY)));
			this.setSupplier(DataParser.parse(Supplier.class, map.get(AssetStorageMeta.SUPPLIER)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetStorageMeta.ORIGINATOR)));
			this.setOriginatorUserName(DataParser.parse(String.class, map.get(AssetStorageMeta.ORIGINATOR_USER_NAME)));
			this.setManagerUser(DataParser.parse(Employee.class, map.get(AssetStorageMeta.MANAGER_USER)));
			return true;
		} else {
			try {
				this.setSupplierId( (String)map.get(AssetStorageMeta.SUPPLIER_ID));
				this.setProcId( (String)map.get(AssetStorageMeta.PROC_ID));
				this.setCustomData( (String)map.get(AssetStorageMeta.CUSTOM_DATA));
				this.setSelectedCode( (String)map.get(AssetStorageMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetStorageMeta.CONTENT));
				this.setSupplierInfo( (String)map.get(AssetStorageMeta.SUPPLIER_INFO));
				this.setBusinessDate( (Date)map.get(AssetStorageMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetStorageMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(AssetStorageMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetStorageMeta.ID));
				this.setAttach( (String)map.get(AssetStorageMeta.ATTACH));
				this.setOriginatorId( (String)map.get(AssetStorageMeta.ORIGINATOR_ID));
				this.setLocationName( (String)map.get(AssetStorageMeta.LOCATION_NAME));
				this.setUpdateTime( (Date)map.get(AssetStorageMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetStorageMeta.VERSION));
				this.setOwnCompanyId( (String)map.get(AssetStorageMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)map.get(AssetStorageMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetStorageMeta.DELETED));
				this.setManagerUserId( (String)map.get(AssetStorageMeta.MANAGER_USER_ID));
				this.setCreateTime( (Date)map.get(AssetStorageMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetStorageMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetStorageMeta.NAME));
				this.setTenantId( (String)map.get(AssetStorageMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetStorageMeta.DELETE_BY));
				this.setStatus( (String)map.get(AssetStorageMeta.STATUS));
				// others
				this.setOwnerCompany( (Organization)map.get(AssetStorageMeta.OWNER_COMPANY));
				this.setSupplier( (Supplier)map.get(AssetStorageMeta.SUPPLIER));
				this.setOriginator( (Employee)map.get(AssetStorageMeta.ORIGINATOR));
				this.setOriginatorUserName( (String)map.get(AssetStorageMeta.ORIGINATOR_USER_NAME));
				this.setManagerUser( (Employee)map.get(AssetStorageMeta.MANAGER_USER));
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
			this.setSupplierId(DataParser.parse(String.class, r.getValue(AssetStorageMeta.SUPPLIER_ID)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetStorageMeta.PROC_ID)));
			this.setCustomData(DataParser.parse(String.class, r.getValue(AssetStorageMeta.CUSTOM_DATA)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetStorageMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetStorageMeta.CONTENT)));
			this.setSupplierInfo(DataParser.parse(String.class, r.getValue(AssetStorageMeta.SUPPLIER_INFO)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetStorageMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetStorageMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetStorageMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetStorageMeta.ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(AssetStorageMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetStorageMeta.ORIGINATOR_ID)));
			this.setLocationName(DataParser.parse(String.class, r.getValue(AssetStorageMeta.LOCATION_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetStorageMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetStorageMeta.VERSION)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(AssetStorageMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetStorageMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetStorageMeta.DELETED)));
			this.setManagerUserId(DataParser.parse(String.class, r.getValue(AssetStorageMeta.MANAGER_USER_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetStorageMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetStorageMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetStorageMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetStorageMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetStorageMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetStorageMeta.STATUS)));
			return true;
		} else {
			try {
				this.setSupplierId( (String)r.getValue(AssetStorageMeta.SUPPLIER_ID));
				this.setProcId( (String)r.getValue(AssetStorageMeta.PROC_ID));
				this.setCustomData( (String)r.getValue(AssetStorageMeta.CUSTOM_DATA));
				this.setSelectedCode( (String)r.getValue(AssetStorageMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetStorageMeta.CONTENT));
				this.setSupplierInfo( (String)r.getValue(AssetStorageMeta.SUPPLIER_INFO));
				this.setBusinessDate( (Date)r.getValue(AssetStorageMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetStorageMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(AssetStorageMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetStorageMeta.ID));
				this.setAttach( (String)r.getValue(AssetStorageMeta.ATTACH));
				this.setOriginatorId( (String)r.getValue(AssetStorageMeta.ORIGINATOR_ID));
				this.setLocationName( (String)r.getValue(AssetStorageMeta.LOCATION_NAME));
				this.setUpdateTime( (Date)r.getValue(AssetStorageMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetStorageMeta.VERSION));
				this.setOwnCompanyId( (String)r.getValue(AssetStorageMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)r.getValue(AssetStorageMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetStorageMeta.DELETED));
				this.setManagerUserId( (String)r.getValue(AssetStorageMeta.MANAGER_USER_ID));
				this.setCreateTime( (Date)r.getValue(AssetStorageMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetStorageMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetStorageMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetStorageMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetStorageMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(AssetStorageMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}