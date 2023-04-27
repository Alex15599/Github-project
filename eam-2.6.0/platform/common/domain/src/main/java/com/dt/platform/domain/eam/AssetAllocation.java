package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_ALLOCATION;
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



/**
 * 资产调拨
 * <p>资产调拨 , 数据表 eam_asset_allocation 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-25 19:53:16
 * @sign D3E7E834C9623BF8B05E34907B21AE1C
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_allocation")
@ApiModel(description = "资产调拨 ; 资产调拨 , 数据表 eam_asset_allocation 的PO类型")
public class AssetAllocation extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_ALLOCATION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "604777916768727040")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "AL202207272007279")
	private String businessCode;
	
	/**
	 * 流程：流程
	*/
	@ApiModelProperty(required = false,value="流程" , notes = "流程")
	private String procId;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态" , example = "complete")
	private String status;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称" , example = "1212")
	private String name;
	
	/**
	 * 调出所属公司：调出所属公司
	*/
	@ApiModelProperty(required = false,value="调出所属公司" , notes = "调出所属公司" , example = "2")
	private String outOwnCompanyId;
	
	/**
	 * 调入所属公司：调入所属公司
	*/
	@ApiModelProperty(required = false,value="调入所属公司" , notes = "调入所属公司" , example = "2")
	private String inOwnCompanyId;
	
	/**
	 * 调入管理员：调入管理员
	*/
	@ApiModelProperty(required = false,value="调入管理员" , notes = "调入管理员" , example = "569945398324494336")
	private String managerId;
	
	/**
	 * 调拨说明：调拨说明
	*/
	@ApiModelProperty(required = false,value="调拨说明" , notes = "调拨说明" , example = "12")
	private String content;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人" , example = "E001")
	private String originatorId;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期" , example = "2022-07-27 12:00:00")
	private Date businessDate;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attach;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-07-27 08:51:32")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-07-27 08:51:35")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 选择数据：选择数据
	*/
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据" , example = "1658926274000")
	private String selectedCode;
	
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
	 * 管理人：管理人
	*/
	@ApiModelProperty(required = false,value="管理人" , notes = "管理人")
	private Employee manager;
	
	/**
	 * 调出公司：调出公司
	*/
	@ApiModelProperty(required = false,value="调出公司" , notes = "调出公司")
	private Organization outOwnerCompany;
	
	/**
	 * 调入公司：调入公司
	*/
	@ApiModelProperty(required = false,value="调入公司" , notes = "调入公司")
	private Organization inOwnerCompany;
	
	/**
	 * 申请人：申请人
	*/
	@ApiModelProperty(required = false,value="申请人" , notes = "申请人")
	private String originatorUserName;
	
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
	public AssetAllocation setId(String id) {
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
	public AssetAllocation setBusinessCode(String businessCode) {
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
	public AssetAllocation setProcId(String procId) {
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
	public AssetAllocation setStatus(String status) {
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
	public AssetAllocation setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 调出所属公司<br>
	 * 调出所属公司
	 * @return 调出所属公司
	*/
	public String getOutOwnCompanyId() {
		return outOwnCompanyId;
	}
	
	/**
	 * 设置 调出所属公司
	 * @param outOwnCompanyId 调出所属公司
	 * @return 当前对象
	*/
	public AssetAllocation setOutOwnCompanyId(String outOwnCompanyId) {
		this.outOwnCompanyId=outOwnCompanyId;
		return this;
	}
	
	/**
	 * 获得 调入所属公司<br>
	 * 调入所属公司
	 * @return 调入所属公司
	*/
	public String getInOwnCompanyId() {
		return inOwnCompanyId;
	}
	
	/**
	 * 设置 调入所属公司
	 * @param inOwnCompanyId 调入所属公司
	 * @return 当前对象
	*/
	public AssetAllocation setInOwnCompanyId(String inOwnCompanyId) {
		this.inOwnCompanyId=inOwnCompanyId;
		return this;
	}
	
	/**
	 * 获得 调入管理员<br>
	 * 调入管理员
	 * @return 调入管理员
	*/
	public String getManagerId() {
		return managerId;
	}
	
	/**
	 * 设置 调入管理员
	 * @param managerId 调入管理员
	 * @return 当前对象
	*/
	public AssetAllocation setManagerId(String managerId) {
		this.managerId=managerId;
		return this;
	}
	
	/**
	 * 获得 调拨说明<br>
	 * 调拨说明
	 * @return 调拨说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 调拨说明
	 * @param content 调拨说明
	 * @return 当前对象
	*/
	public AssetAllocation setContent(String content) {
		this.content=content;
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
	public AssetAllocation setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public AssetAllocation setBusinessDate(Date businessDate) {
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
	public AssetAllocation setAttach(String attach) {
		this.attach=attach;
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
	public AssetAllocation setCreateBy(String createBy) {
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
	public AssetAllocation setCreateTime(Date createTime) {
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
	public AssetAllocation setUpdateBy(String updateBy) {
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
	public AssetAllocation setUpdateTime(Date updateTime) {
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
	public AssetAllocation setDeleted(Integer deleted) {
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
	public AssetAllocation setDeleted(Boolean deletedBool) {
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
	public AssetAllocation setDeleteBy(String deleteBy) {
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
	public AssetAllocation setDeleteTime(Date deleteTime) {
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
	public AssetAllocation setVersion(Integer version) {
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
	public AssetAllocation setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 选择数据<br>
	 * 选择数据
	 * @return 选择数据
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择数据
	 * @param selectedCode 选择数据
	 * @return 当前对象
	*/
	public AssetAllocation setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public AssetAllocation setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public AssetAllocation addAsset(Asset... asset) {
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
	public AssetAllocation setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public AssetAllocation addAssetId(String... assetId) {
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
	public AssetAllocation setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 管理人<br>
	 * 管理人
	 * @return 管理人
	*/
	public Employee getManager() {
		return manager;
	}
	
	/**
	 * 设置 管理人
	 * @param manager 管理人
	 * @return 当前对象
	*/
	public AssetAllocation setManager(Employee manager) {
		this.manager=manager;
		return this;
	}
	
	/**
	 * 获得 调出公司<br>
	 * 调出公司
	 * @return 调出公司
	*/
	public Organization getOutOwnerCompany() {
		return outOwnerCompany;
	}
	
	/**
	 * 设置 调出公司
	 * @param outOwnerCompany 调出公司
	 * @return 当前对象
	*/
	public AssetAllocation setOutOwnerCompany(Organization outOwnerCompany) {
		this.outOwnerCompany=outOwnerCompany;
		return this;
	}
	
	/**
	 * 获得 调入公司<br>
	 * 调入公司
	 * @return 调入公司
	*/
	public Organization getInOwnerCompany() {
		return inOwnerCompany;
	}
	
	/**
	 * 设置 调入公司
	 * @param inOwnerCompany 调入公司
	 * @return 当前对象
	*/
	public AssetAllocation setInOwnerCompany(Organization inOwnerCompany) {
		this.inOwnerCompany=inOwnerCompany;
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
	public AssetAllocation setOriginatorUserName(String originatorUserName) {
		this.originatorUserName=originatorUserName;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetAllocation , 转换好的 AssetAllocation 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetAllocation , 转换好的 PoJo 对象
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
	public AssetAllocation clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetAllocation duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetAllocationMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetAllocationMeta.$$proxy$$();
		inst.setInOwnCompanyId(this.getInOwnCompanyId());
		inst.setProcId(this.getProcId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOutOwnCompanyId(this.getOutOwnCompanyId());
		inst.setManagerId(this.getManagerId());
		inst.setVersion(this.getVersion());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttach(this.getAttach());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setManager(this.getManager());
			inst.setInOwnerCompany(this.getInOwnerCompany());
			inst.setAssetIds(this.getAssetIds());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setOutOwnerCompany(this.getOutOwnerCompany());
			inst.setOriginatorUserName(this.getOriginatorUserName());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetAllocation clone(boolean deep) {
		return EntityContext.clone(AssetAllocation.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetAllocation
	 * @param assetAllocationMap 包含实体信息的 Map 对象
	 * @return AssetAllocation , 转换好的的 AssetAllocation 对象
	*/
	@Transient
	public static AssetAllocation createFrom(Map<String,Object> assetAllocationMap) {
		if(assetAllocationMap==null) return null;
		AssetAllocation po = create();
		EntityContext.copyProperties(po,assetAllocationMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetAllocation
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetAllocation , 转换好的的 AssetAllocation 对象
	*/
	@Transient
	public static AssetAllocation createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetAllocation po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetAllocation，等同于 new
	 * @return AssetAllocation 对象
	*/
	@Transient
	public static AssetAllocation create() {
		return new com.dt.platform.domain.eam.meta.AssetAllocationMeta.$$proxy$$();
	}
}