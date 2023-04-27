package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_BORROW_RETURN;
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
import com.dt.platform.domain.eam.meta.AssetBorrowReturnMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产归还
 * <p>资产归还 , 数据表 eam_asset_borrow_return 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-13 18:22:44
 * @sign E60626DFD55602E60AAEFA7643AC63E7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_borrow_return")
@ApiModel(description = "资产归还 ; 资产归还 , 数据表 eam_asset_borrow_return 的PO类型")
public class AssetBorrowReturn extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_BORROW_RETURN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "644170156838223872")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "BR202211131311799")
	private String businessCode;
	
	/**
	 * 流程：流程
	*/
	@ApiModelProperty(required = false,value="流程" , notes = "流程")
	private String procId;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态" , example = "incomplete")
	private String status;
	
	/**
	 * 业务名称：业务名称
	*/
	@ApiModelProperty(required = false,value="业务名称" , notes = "业务名称" , example = "12345")
	private String name;
	
	/**
	 * 归还后公司/部门：归还后公司/部门
	*/
	@ApiModelProperty(required = false,value="归还后公司/部门" , notes = "归还后公司/部门")
	private String useOrganizationId;
	
	/**
	 * 归还后位置：归还后位置
	*/
	@ApiModelProperty(required = false,value="归还后位置" , notes = "归还后位置" , example = "616015163073495040")
	private String positionId;
	
	/**
	 * 详细位置：详细位置
	*/
	@ApiModelProperty(required = false,value="详细位置" , notes = "详细位置")
	private String positionDetail;
	
	/**
	 * 归还说明：归还说明
	*/
	@ApiModelProperty(required = false,value="归还说明" , notes = "归还说明")
	private String content;
	
	/**
	 * 归还日期：归还日期
	*/
	@ApiModelProperty(required = false,value="归还日期" , notes = "归还日期" , example = "2022-11-13 12:00:00")
	private Date returnDate;
	
	/**
	 * 管理人：管理人
	*/
	@ApiModelProperty(required = false,value="管理人" , notes = "管理人")
	private String managerId;
	
	/**
	 * 使用人：使用人
	*/
	@ApiModelProperty(required = false,value="使用人" , notes = "使用人")
	private String useUserId;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人" , example = "E001")
	private String originatorId;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期" , example = "2022-11-13 12:00:00")
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-11-13 01:42:13")
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
	 * 选择数据：选择数据
	*/
	@ApiModelProperty(required = false,value="选择数据" , notes = "选择数据" , example = "1668318010000")
	private String selectedCode;
	
	/**
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<AssetItem> assetItemList;
	
	/**
	 * 存放位置：存放位置
	*/
	@ApiModelProperty(required = false,value="存放位置" , notes = "存放位置")
	private Position position;
	
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
	 * 归还人：归还人
	*/
	@ApiModelProperty(required = false,value="归还人" , notes = "归还人")
	private String originatorUserName;
	
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
	 * 使用人：使用人
	*/
	@ApiModelProperty(required = false,value="使用人" , notes = "使用人")
	private Employee useUser;
	
	/**
	 * 归还后公司：归还后公司
	*/
	@ApiModelProperty(required = false,value="归还后公司" , notes = "归还后公司")
	private Organization useOrganization;
	
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
	public AssetBorrowReturn setId(String id) {
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
	public AssetBorrowReturn setBusinessCode(String businessCode) {
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
	public AssetBorrowReturn setProcId(String procId) {
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
	public AssetBorrowReturn setStatus(String status) {
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
	public AssetBorrowReturn setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 归还后公司/部门<br>
	 * 归还后公司/部门
	 * @return 归还后公司/部门
	*/
	public String getUseOrganizationId() {
		return useOrganizationId;
	}
	
	/**
	 * 设置 归还后公司/部门
	 * @param useOrganizationId 归还后公司/部门
	 * @return 当前对象
	*/
	public AssetBorrowReturn setUseOrganizationId(String useOrganizationId) {
		this.useOrganizationId=useOrganizationId;
		return this;
	}
	
	/**
	 * 获得 归还后位置<br>
	 * 归还后位置
	 * @return 归还后位置
	*/
	public String getPositionId() {
		return positionId;
	}
	
	/**
	 * 设置 归还后位置
	 * @param positionId 归还后位置
	 * @return 当前对象
	*/
	public AssetBorrowReturn setPositionId(String positionId) {
		this.positionId=positionId;
		return this;
	}
	
	/**
	 * 获得 详细位置<br>
	 * 详细位置
	 * @return 详细位置
	*/
	public String getPositionDetail() {
		return positionDetail;
	}
	
	/**
	 * 设置 详细位置
	 * @param positionDetail 详细位置
	 * @return 当前对象
	*/
	public AssetBorrowReturn setPositionDetail(String positionDetail) {
		this.positionDetail=positionDetail;
		return this;
	}
	
	/**
	 * 获得 归还说明<br>
	 * 归还说明
	 * @return 归还说明
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 归还说明
	 * @param content 归还说明
	 * @return 当前对象
	*/
	public AssetBorrowReturn setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 归还日期<br>
	 * 归还日期
	 * @return 归还日期
	*/
	public Date getReturnDate() {
		return returnDate;
	}
	
	/**
	 * 设置 归还日期
	 * @param returnDate 归还日期
	 * @return 当前对象
	*/
	public AssetBorrowReturn setReturnDate(Date returnDate) {
		this.returnDate=returnDate;
		return this;
	}
	
	/**
	 * 获得 管理人<br>
	 * 管理人
	 * @return 管理人
	*/
	public String getManagerId() {
		return managerId;
	}
	
	/**
	 * 设置 管理人
	 * @param managerId 管理人
	 * @return 当前对象
	*/
	public AssetBorrowReturn setManagerId(String managerId) {
		this.managerId=managerId;
		return this;
	}
	
	/**
	 * 获得 使用人<br>
	 * 使用人
	 * @return 使用人
	*/
	public String getUseUserId() {
		return useUserId;
	}
	
	/**
	 * 设置 使用人
	 * @param useUserId 使用人
	 * @return 当前对象
	*/
	public AssetBorrowReturn setUseUserId(String useUserId) {
		this.useUserId=useUserId;
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
	public AssetBorrowReturn setOriginatorId(String originatorId) {
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
	public AssetBorrowReturn setBusinessDate(Date businessDate) {
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
	public AssetBorrowReturn setAttach(String attach) {
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
	public AssetBorrowReturn setCreateBy(String createBy) {
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
	public AssetBorrowReturn setCreateTime(Date createTime) {
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
	public AssetBorrowReturn setUpdateBy(String updateBy) {
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
	public AssetBorrowReturn setUpdateTime(Date updateTime) {
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
	public AssetBorrowReturn setDeleted(Integer deleted) {
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
	public AssetBorrowReturn setDeleted(Boolean deletedBool) {
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
	public AssetBorrowReturn setDeleteBy(String deleteBy) {
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
	public AssetBorrowReturn setDeleteTime(Date deleteTime) {
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
	public AssetBorrowReturn setVersion(Integer version) {
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
	public AssetBorrowReturn setTenantId(String tenantId) {
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
	public AssetBorrowReturn setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public AssetBorrowReturn setAssetItemList(List<AssetItem> assetItemList) {
		this.assetItemList=assetItemList;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetItem 资产列表
	 * @return 当前对象
	*/
	public AssetBorrowReturn addAssetItem(AssetItem... assetItem) {
		if(this.assetItemList==null) assetItemList=new ArrayList<>();
		this.assetItemList.addAll(Arrays.asList(assetItem));
		return this;
	}
	
	/**
	 * 获得 存放位置<br>
	 * 存放位置
	 * @return 存放位置
	*/
	public Position getPosition() {
		return position;
	}
	
	/**
	 * 设置 存放位置
	 * @param position 存放位置
	 * @return 当前对象
	*/
	public AssetBorrowReturn setPosition(Position position) {
		this.position=position;
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
	public AssetBorrowReturn setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public AssetBorrowReturn addAsset(Asset... asset) {
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
	public AssetBorrowReturn setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public AssetBorrowReturn addAssetId(String... assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.addAll(Arrays.asList(assetId));
		return this;
	}
	
	/**
	 * 获得 归还人<br>
	 * 归还人
	 * @return 归还人
	*/
	public String getOriginatorUserName() {
		return originatorUserName;
	}
	
	/**
	 * 设置 归还人
	 * @param originatorUserName 归还人
	 * @return 当前对象
	*/
	public AssetBorrowReturn setOriginatorUserName(String originatorUserName) {
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
	public AssetBorrowReturn setOriginator(Employee originator) {
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
	public AssetBorrowReturn setManager(Employee manager) {
		this.manager=manager;
		return this;
	}
	
	/**
	 * 获得 使用人<br>
	 * 使用人
	 * @return 使用人
	*/
	public Employee getUseUser() {
		return useUser;
	}
	
	/**
	 * 设置 使用人
	 * @param useUser 使用人
	 * @return 当前对象
	*/
	public AssetBorrowReturn setUseUser(Employee useUser) {
		this.useUser=useUser;
		return this;
	}
	
	/**
	 * 获得 归还后公司<br>
	 * 归还后公司
	 * @return 归还后公司
	*/
	public Organization getUseOrganization() {
		return useOrganization;
	}
	
	/**
	 * 设置 归还后公司
	 * @param useOrganization 归还后公司
	 * @return 当前对象
	*/
	public AssetBorrowReturn setUseOrganization(Organization useOrganization) {
		this.useOrganization=useOrganization;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetBorrowReturn , 转换好的 AssetBorrowReturn 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetBorrowReturn , 转换好的 PoJo 对象
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
	public AssetBorrowReturn clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetBorrowReturn duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetBorrowReturnMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetBorrowReturnMeta.$$proxy$$();
		inst.setProcId(this.getProcId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setReturnDate(this.getReturnDate());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttach(this.getAttach());
		inst.setUseOrganizationId(this.getUseOrganizationId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setManagerId(this.getManagerId());
		inst.setVersion(this.getVersion());
		inst.setPositionDetail(this.getPositionDetail());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUseUserId(this.getUseUserId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setAssetItemList(this.getAssetItemList());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setManager(this.getManager());
			inst.setAssetIds(this.getAssetIds());
			inst.setPosition(this.getPosition());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setUseUser(this.getUseUser());
			inst.setOriginatorUserName(this.getOriginatorUserName());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetBorrowReturn clone(boolean deep) {
		return EntityContext.clone(AssetBorrowReturn.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetBorrowReturn
	 * @param assetBorrowReturnMap 包含实体信息的 Map 对象
	 * @return AssetBorrowReturn , 转换好的的 AssetBorrowReturn 对象
	*/
	@Transient
	public static AssetBorrowReturn createFrom(Map<String,Object> assetBorrowReturnMap) {
		if(assetBorrowReturnMap==null) return null;
		AssetBorrowReturn po = create();
		EntityContext.copyProperties(po,assetBorrowReturnMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetBorrowReturn
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetBorrowReturn , 转换好的的 AssetBorrowReturn 对象
	*/
	@Transient
	public static AssetBorrowReturn createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetBorrowReturn po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetBorrowReturn，等同于 new
	 * @return AssetBorrowReturn 对象
	*/
	@Transient
	public static AssetBorrowReturn create() {
		return new com.dt.platform.domain.eam.meta.AssetBorrowReturnMeta.$$proxy$$();
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
			this.setProcId(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.PROC_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetBorrowReturnMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.BUSINESS_CODE)));
			this.setReturnDate(DataParser.parse(Date.class, map.get(AssetBorrowReturnMeta.RETURN_DATE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.ATTACH)));
			this.setUseOrganizationId(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.USE_ORGANIZATION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetBorrowReturnMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.MANAGER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetBorrowReturnMeta.VERSION)));
			this.setPositionDetail(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.POSITION_DETAIL)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetBorrowReturnMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetBorrowReturnMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetBorrowReturnMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.DELETE_BY)));
			this.setUseUserId(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.USE_USER_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.STATUS)));
			// others
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(AssetBorrowReturnMeta.USE_ORGANIZATION)));
			this.setManager(DataParser.parse(Employee.class, map.get(AssetBorrowReturnMeta.MANAGER)));
			this.setPosition(DataParser.parse(Position.class, map.get(AssetBorrowReturnMeta.POSITION)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetBorrowReturnMeta.ORIGINATOR)));
			this.setUseUser(DataParser.parse(Employee.class, map.get(AssetBorrowReturnMeta.USE_USER)));
			this.setOriginatorUserName(DataParser.parse(String.class, map.get(AssetBorrowReturnMeta.ORIGINATOR_USER_NAME)));
			return true;
		} else {
			try {
				this.setProcId( (String)map.get(AssetBorrowReturnMeta.PROC_ID));
				this.setSelectedCode( (String)map.get(AssetBorrowReturnMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetBorrowReturnMeta.CONTENT));
				this.setBusinessDate( (Date)map.get(AssetBorrowReturnMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetBorrowReturnMeta.BUSINESS_CODE));
				this.setReturnDate( (Date)map.get(AssetBorrowReturnMeta.RETURN_DATE));
				this.setUpdateBy( (String)map.get(AssetBorrowReturnMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetBorrowReturnMeta.ID));
				this.setOriginatorId( (String)map.get(AssetBorrowReturnMeta.ORIGINATOR_ID));
				this.setAttach( (String)map.get(AssetBorrowReturnMeta.ATTACH));
				this.setUseOrganizationId( (String)map.get(AssetBorrowReturnMeta.USE_ORGANIZATION_ID));
				this.setUpdateTime( (Date)map.get(AssetBorrowReturnMeta.UPDATE_TIME));
				this.setManagerId( (String)map.get(AssetBorrowReturnMeta.MANAGER_ID));
				this.setVersion( (Integer)map.get(AssetBorrowReturnMeta.VERSION));
				this.setPositionDetail( (String)map.get(AssetBorrowReturnMeta.POSITION_DETAIL));
				this.setCreateBy( (String)map.get(AssetBorrowReturnMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetBorrowReturnMeta.DELETED));
				this.setPositionId( (String)map.get(AssetBorrowReturnMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(AssetBorrowReturnMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetBorrowReturnMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetBorrowReturnMeta.NAME));
				this.setTenantId( (String)map.get(AssetBorrowReturnMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetBorrowReturnMeta.DELETE_BY));
				this.setUseUserId( (String)map.get(AssetBorrowReturnMeta.USE_USER_ID));
				this.setStatus( (String)map.get(AssetBorrowReturnMeta.STATUS));
				// others
				this.setUseOrganization( (Organization)map.get(AssetBorrowReturnMeta.USE_ORGANIZATION));
				this.setManager( (Employee)map.get(AssetBorrowReturnMeta.MANAGER));
				this.setPosition( (Position)map.get(AssetBorrowReturnMeta.POSITION));
				this.setOriginator( (Employee)map.get(AssetBorrowReturnMeta.ORIGINATOR));
				this.setUseUser( (Employee)map.get(AssetBorrowReturnMeta.USE_USER));
				this.setOriginatorUserName( (String)map.get(AssetBorrowReturnMeta.ORIGINATOR_USER_NAME));
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
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.PROC_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetBorrowReturnMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.BUSINESS_CODE)));
			this.setReturnDate(DataParser.parse(Date.class, r.getValue(AssetBorrowReturnMeta.RETURN_DATE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.ATTACH)));
			this.setUseOrganizationId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.USE_ORGANIZATION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetBorrowReturnMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.MANAGER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetBorrowReturnMeta.VERSION)));
			this.setPositionDetail(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.POSITION_DETAIL)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetBorrowReturnMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetBorrowReturnMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetBorrowReturnMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.DELETE_BY)));
			this.setUseUserId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.USE_USER_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetBorrowReturnMeta.STATUS)));
			return true;
		} else {
			try {
				this.setProcId( (String)r.getValue(AssetBorrowReturnMeta.PROC_ID));
				this.setSelectedCode( (String)r.getValue(AssetBorrowReturnMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetBorrowReturnMeta.CONTENT));
				this.setBusinessDate( (Date)r.getValue(AssetBorrowReturnMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetBorrowReturnMeta.BUSINESS_CODE));
				this.setReturnDate( (Date)r.getValue(AssetBorrowReturnMeta.RETURN_DATE));
				this.setUpdateBy( (String)r.getValue(AssetBorrowReturnMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetBorrowReturnMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetBorrowReturnMeta.ORIGINATOR_ID));
				this.setAttach( (String)r.getValue(AssetBorrowReturnMeta.ATTACH));
				this.setUseOrganizationId( (String)r.getValue(AssetBorrowReturnMeta.USE_ORGANIZATION_ID));
				this.setUpdateTime( (Date)r.getValue(AssetBorrowReturnMeta.UPDATE_TIME));
				this.setManagerId( (String)r.getValue(AssetBorrowReturnMeta.MANAGER_ID));
				this.setVersion( (Integer)r.getValue(AssetBorrowReturnMeta.VERSION));
				this.setPositionDetail( (String)r.getValue(AssetBorrowReturnMeta.POSITION_DETAIL));
				this.setCreateBy( (String)r.getValue(AssetBorrowReturnMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetBorrowReturnMeta.DELETED));
				this.setPositionId( (String)r.getValue(AssetBorrowReturnMeta.POSITION_ID));
				this.setCreateTime( (Date)r.getValue(AssetBorrowReturnMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetBorrowReturnMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetBorrowReturnMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetBorrowReturnMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetBorrowReturnMeta.DELETE_BY));
				this.setUseUserId( (String)r.getValue(AssetBorrowReturnMeta.USE_USER_ID));
				this.setStatus( (String)r.getValue(AssetBorrowReturnMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}