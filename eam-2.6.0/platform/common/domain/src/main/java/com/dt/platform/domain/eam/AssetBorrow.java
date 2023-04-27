package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_BORROW;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetBorrowMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产借用
 * <p>资产借用 , 数据表 eam_asset_borrow 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-13 09:02:44
 * @sign 2DBCFE192C923F95E8FA46724967C7DC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_borrow")
@ApiModel(description = "资产借用 ; 资产借用 , 数据表 eam_asset_borrow 的PO类型")
public class AssetBorrow extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_BORROW.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "563012113811898368")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "BO202204031404394")
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
	 * 借用状态：借用状态
	*/
	@ApiModelProperty(required = false,value="借用状态" , notes = "借用状态" , example = "returned")
	private String borrowStatus;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称")
	private String name;
	
	/**
	 * 借用人：借用人
	*/
	@ApiModelProperty(required = false,value="借用人" , notes = "借用人" , example = "558321538131034112")
	private String borrowerId;
	
	/**
	 * 借出时间：借出时间
	*/
	@ApiModelProperty(required = false,value="借出时间" , notes = "借出时间" , example = "2022-04-07 12:00:00")
	private Date borrowTime;
	
	/**
	 * 预计归还时间：预计归还时间
	*/
	@ApiModelProperty(required = false,value="预计归还时间" , notes = "预计归还时间" , example = "2022-05-04 12:00:00")
	private Date planReturnDate;
	
	/**
	 * 归还时间：归还时间
	*/
	@ApiModelProperty(required = false,value="归还时间" , notes = "归还时间" , example = "2022-04-30 12:00:00")
	private Date returnDate;
	
	/**
	 * 借出说明：借出说明
	*/
	@ApiModelProperty(required = false,value="借出说明" , notes = "借出说明")
	private String content;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人" , example = "E001")
	private String originatorId;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期" , example = "2022-04-03 12:00:00")
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-04-03 02:49:08")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-04-03 02:49:12")
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
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据" , example = "1648968533000")
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
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<AssetItem> assetItemList;
	
	/**
	 * 申请人：申请人
	*/
	@ApiModelProperty(required = false,value="申请人" , notes = "申请人")
	private String originatorUserName;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 借用人：借用人
	*/
	@ApiModelProperty(required = false,value="借用人" , notes = "借用人")
	private Employee borrower;
	
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
	public AssetBorrow setId(String id) {
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
	public AssetBorrow setBusinessCode(String businessCode) {
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
	public AssetBorrow setProcId(String procId) {
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
	public AssetBorrow setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 借用状态<br>
	 * 借用状态
	 * @return 借用状态
	*/
	public String getBorrowStatus() {
		return borrowStatus;
	}
	
	/**
	 * 设置 借用状态
	 * @param borrowStatus 借用状态
	 * @return 当前对象
	*/
	public AssetBorrow setBorrowStatus(String borrowStatus) {
		this.borrowStatus=borrowStatus;
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
	public AssetBorrow setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 借用人<br>
	 * 借用人
	 * @return 借用人
	*/
	public String getBorrowerId() {
		return borrowerId;
	}
	
	/**
	 * 设置 借用人
	 * @param borrowerId 借用人
	 * @return 当前对象
	*/
	public AssetBorrow setBorrowerId(String borrowerId) {
		this.borrowerId=borrowerId;
		return this;
	}
	
	/**
	 * 获得 借出时间<br>
	 * 借出时间
	 * @return 借出时间
	*/
	public Date getBorrowTime() {
		return borrowTime;
	}
	
	/**
	 * 设置 借出时间
	 * @param borrowTime 借出时间
	 * @return 当前对象
	*/
	public AssetBorrow setBorrowTime(Date borrowTime) {
		this.borrowTime=borrowTime;
		return this;
	}
	
	/**
	 * 获得 预计归还时间<br>
	 * 预计归还时间
	 * @return 预计归还时间
	*/
	public Date getPlanReturnDate() {
		return planReturnDate;
	}
	
	/**
	 * 设置 预计归还时间
	 * @param planReturnDate 预计归还时间
	 * @return 当前对象
	*/
	public AssetBorrow setPlanReturnDate(Date planReturnDate) {
		this.planReturnDate=planReturnDate;
		return this;
	}
	
	/**
	 * 获得 归还时间<br>
	 * 归还时间
	 * @return 归还时间
	*/
	public Date getReturnDate() {
		return returnDate;
	}
	
	/**
	 * 设置 归还时间
	 * @param returnDate 归还时间
	 * @return 当前对象
	*/
	public AssetBorrow setReturnDate(Date returnDate) {
		this.returnDate=returnDate;
		return this;
	}
	
	/**
	 * 获得 借出说明<br>
	 * 借出说明
	 * @return 借出说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 借出说明
	 * @param content 借出说明
	 * @return 当前对象
	*/
	public AssetBorrow setContent(String content) {
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
	public AssetBorrow setOriginatorId(String originatorId) {
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
	public AssetBorrow setBusinessDate(Date businessDate) {
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
	public AssetBorrow setAttach(String attach) {
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
	public AssetBorrow setCreateBy(String createBy) {
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
	public AssetBorrow setCreateTime(Date createTime) {
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
	public AssetBorrow setUpdateBy(String updateBy) {
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
	public AssetBorrow setUpdateTime(Date updateTime) {
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
	public AssetBorrow setDeleted(Integer deleted) {
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
	public AssetBorrow setDeleted(Boolean deletedBool) {
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
	public AssetBorrow setDeleteBy(String deleteBy) {
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
	public AssetBorrow setDeleteTime(Date deleteTime) {
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
	public AssetBorrow setVersion(Integer version) {
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
	public AssetBorrow setTenantId(String tenantId) {
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
	public AssetBorrow setSelectedCode(String selectedCode) {
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
	public AssetBorrow setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public AssetBorrow addAsset(Asset... asset) {
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
	public AssetBorrow setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public AssetBorrow addAssetId(String... assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.addAll(Arrays.asList(assetId));
		return this;
	}
	
	/**
	 * 获得 资产列表<br>
	 * 资产列表
	 * @return 资产列表
	*/
	public List<AssetItem> getAssetItemList() {
		return assetItemList;
	}
	
	/**
	 * 设置 资产列表
	 * @param assetItemList 资产列表
	 * @return 当前对象
	*/
	public AssetBorrow setAssetItemList(List<AssetItem> assetItemList) {
		this.assetItemList=assetItemList;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetItem 资产列表
	 * @return 当前对象
	*/
	public AssetBorrow addAssetItem(AssetItem... assetItem) {
		if(this.assetItemList==null) assetItemList=new ArrayList<>();
		this.assetItemList.addAll(Arrays.asList(assetItem));
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
	public AssetBorrow setOriginatorUserName(String originatorUserName) {
		this.originatorUserName=originatorUserName;
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
	public AssetBorrow setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 借用人<br>
	 * 借用人
	 * @return 借用人
	*/
	public Employee getBorrower() {
		return borrower;
	}
	
	/**
	 * 设置 借用人
	 * @param borrower 借用人
	 * @return 当前对象
	*/
	public AssetBorrow setBorrower(Employee borrower) {
		this.borrower=borrower;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetBorrow , 转换好的 AssetBorrow 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetBorrow , 转换好的 PoJo 对象
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
	public AssetBorrow clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetBorrow duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetBorrowMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetBorrowMeta.$$proxy$$();
		inst.setBorrowerId(this.getBorrowerId());
		inst.setPlanReturnDate(this.getPlanReturnDate());
		inst.setProcId(this.getProcId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setReturnDate(this.getReturnDate());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setBorrowStatus(this.getBorrowStatus());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setBorrowTime(this.getBorrowTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttach(this.getAttach());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setAssetItemList(this.getAssetItemList());
			inst.setBorrower(this.getBorrower());
			inst.setAssetIds(this.getAssetIds());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setOriginatorUserName(this.getOriginatorUserName());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetBorrow clone(boolean deep) {
		return EntityContext.clone(AssetBorrow.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetBorrow
	 * @param assetBorrowMap 包含实体信息的 Map 对象
	 * @return AssetBorrow , 转换好的的 AssetBorrow 对象
	*/
	@Transient
	public static AssetBorrow createFrom(Map<String,Object> assetBorrowMap) {
		if(assetBorrowMap==null) return null;
		AssetBorrow po = create();
		EntityContext.copyProperties(po,assetBorrowMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetBorrow
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetBorrow , 转换好的的 AssetBorrow 对象
	*/
	@Transient
	public static AssetBorrow createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetBorrow po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetBorrow，等同于 new
	 * @return AssetBorrow 对象
	*/
	@Transient
	public static AssetBorrow create() {
		return new com.dt.platform.domain.eam.meta.AssetBorrowMeta.$$proxy$$();
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
			this.setBorrowerId(DataParser.parse(String.class, map.get(AssetBorrowMeta.BORROWER_ID)));
			this.setPlanReturnDate(DataParser.parse(Date.class, map.get(AssetBorrowMeta.PLAN_RETURN_DATE)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetBorrowMeta.PROC_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetBorrowMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetBorrowMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetBorrowMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetBorrowMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetBorrowMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetBorrowMeta.BUSINESS_CODE)));
			this.setReturnDate(DataParser.parse(Date.class, map.get(AssetBorrowMeta.RETURN_DATE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetBorrowMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetBorrowMeta.DELETED)));
			this.setBorrowStatus(DataParser.parse(String.class, map.get(AssetBorrowMeta.BORROW_STATUS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetBorrowMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetBorrowMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetBorrowMeta.DELETE_TIME)));
			this.setBorrowTime(DataParser.parse(Date.class, map.get(AssetBorrowMeta.BORROW_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetBorrowMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetBorrowMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetBorrowMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetBorrowMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetBorrowMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, map.get(AssetBorrowMeta.ATTACH)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetBorrowMeta.STATUS)));
			// others
			this.setBorrower(DataParser.parse(Employee.class, map.get(AssetBorrowMeta.BORROWER)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetBorrowMeta.ORIGINATOR)));
			this.setOriginatorUserName(DataParser.parse(String.class, map.get(AssetBorrowMeta.ORIGINATOR_USER_NAME)));
			return true;
		} else {
			try {
				this.setBorrowerId( (String)map.get(AssetBorrowMeta.BORROWER_ID));
				this.setPlanReturnDate( (Date)map.get(AssetBorrowMeta.PLAN_RETURN_DATE));
				this.setProcId( (String)map.get(AssetBorrowMeta.PROC_ID));
				this.setUpdateTime( (Date)map.get(AssetBorrowMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetBorrowMeta.VERSION));
				this.setSelectedCode( (String)map.get(AssetBorrowMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetBorrowMeta.CONTENT));
				this.setBusinessDate( (Date)map.get(AssetBorrowMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetBorrowMeta.BUSINESS_CODE));
				this.setReturnDate( (Date)map.get(AssetBorrowMeta.RETURN_DATE));
				this.setCreateBy( (String)map.get(AssetBorrowMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetBorrowMeta.DELETED));
				this.setBorrowStatus( (String)map.get(AssetBorrowMeta.BORROW_STATUS));
				this.setCreateTime( (Date)map.get(AssetBorrowMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetBorrowMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetBorrowMeta.DELETE_TIME));
				this.setBorrowTime( (Date)map.get(AssetBorrowMeta.BORROW_TIME));
				this.setName( (String)map.get(AssetBorrowMeta.NAME));
				this.setTenantId( (String)map.get(AssetBorrowMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetBorrowMeta.DELETE_BY));
				this.setId( (String)map.get(AssetBorrowMeta.ID));
				this.setOriginatorId( (String)map.get(AssetBorrowMeta.ORIGINATOR_ID));
				this.setAttach( (String)map.get(AssetBorrowMeta.ATTACH));
				this.setStatus( (String)map.get(AssetBorrowMeta.STATUS));
				// others
				this.setBorrower( (Employee)map.get(AssetBorrowMeta.BORROWER));
				this.setOriginator( (Employee)map.get(AssetBorrowMeta.ORIGINATOR));
				this.setOriginatorUserName( (String)map.get(AssetBorrowMeta.ORIGINATOR_USER_NAME));
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
			this.setBorrowerId(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.BORROWER_ID)));
			this.setPlanReturnDate(DataParser.parse(Date.class, r.getValue(AssetBorrowMeta.PLAN_RETURN_DATE)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.PROC_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetBorrowMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetBorrowMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetBorrowMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.BUSINESS_CODE)));
			this.setReturnDate(DataParser.parse(Date.class, r.getValue(AssetBorrowMeta.RETURN_DATE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetBorrowMeta.DELETED)));
			this.setBorrowStatus(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.BORROW_STATUS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetBorrowMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetBorrowMeta.DELETE_TIME)));
			this.setBorrowTime(DataParser.parse(Date.class, r.getValue(AssetBorrowMeta.BORROW_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.ATTACH)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetBorrowMeta.STATUS)));
			return true;
		} else {
			try {
				this.setBorrowerId( (String)r.getValue(AssetBorrowMeta.BORROWER_ID));
				this.setPlanReturnDate( (Date)r.getValue(AssetBorrowMeta.PLAN_RETURN_DATE));
				this.setProcId( (String)r.getValue(AssetBorrowMeta.PROC_ID));
				this.setUpdateTime( (Date)r.getValue(AssetBorrowMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetBorrowMeta.VERSION));
				this.setSelectedCode( (String)r.getValue(AssetBorrowMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetBorrowMeta.CONTENT));
				this.setBusinessDate( (Date)r.getValue(AssetBorrowMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetBorrowMeta.BUSINESS_CODE));
				this.setReturnDate( (Date)r.getValue(AssetBorrowMeta.RETURN_DATE));
				this.setCreateBy( (String)r.getValue(AssetBorrowMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetBorrowMeta.DELETED));
				this.setBorrowStatus( (String)r.getValue(AssetBorrowMeta.BORROW_STATUS));
				this.setCreateTime( (Date)r.getValue(AssetBorrowMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetBorrowMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetBorrowMeta.DELETE_TIME));
				this.setBorrowTime( (Date)r.getValue(AssetBorrowMeta.BORROW_TIME));
				this.setName( (String)r.getValue(AssetBorrowMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetBorrowMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetBorrowMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetBorrowMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetBorrowMeta.ORIGINATOR_ID));
				this.setAttach( (String)r.getValue(AssetBorrowMeta.ATTACH));
				this.setStatus( (String)r.getValue(AssetBorrowMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}