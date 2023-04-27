package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_MAINTENANCE_RECORD;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.pcm.Catalog;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetMaintenanceRecordMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 维保更新记录
 * <p>维保更新记录 , 数据表 eam_asset_maintenance_record 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-29 13:55:07
 * @sign 3642472EB799DEE09BA88B78E57CE64F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_maintenance_record")
@ApiModel(description = "维保更新记录 ; 维保更新记录 , 数据表 eam_asset_maintenance_record 的PO类型")
public class AssetMaintenanceRecord extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_MAINTENANCE_RECORD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "638473058469806080")
	private String id;
	
	/**
	 * 维保更新：维保更新
	*/
	@ApiModelProperty(required = false,value="维保更新" , notes = "维保更新")
	private String maintenanceUpdateId;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private String assetId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String maintenanceNotes;
	
	/**
	 * 备注[状态]：备注[状态]
	*/
	@ApiModelProperty(required = false,value="备注[状态]" , notes = "备注[状态]" , example = "disable")
	private String sMaintenanceNotes;
	
	/**
	 * 维保厂商：维保厂商
	*/
	@ApiModelProperty(required = false,value="维保厂商" , notes = "维保厂商" , example = "12121")
	private String maintainerId;
	
	/**
	 * 维保厂商[状态]：维保厂商[状态]
	*/
	@ApiModelProperty(required = false,value="维保厂商[状态]" , notes = "维保厂商[状态]" , example = "2121212")
	private String sMaintainerId;
	
	/**
	 * 维保厂商名称：维保厂商名称
	*/
	@ApiModelProperty(required = false,value="维保厂商名称" , notes = "维保厂商名称")
	private String maintainerName;
	
	/**
	 * 维保厂商名称[状态]：维保厂商名称[状态]
	*/
	@ApiModelProperty(required = false,value="维保厂商名称[状态]" , notes = "维保厂商名称[状态]")
	private String sMaintainerName;
	
	/**
	 * 维保状态：维保状态
	*/
	@ApiModelProperty(required = false,value="维保状态" , notes = "维保状态")
	private String maintenanceStatus;
	
	/**
	 * 维保状态[状态]：维保状态[状态]
	*/
	@ApiModelProperty(required = false,value="维保状态[状态]" , notes = "维保状态[状态]")
	private String sMaintenanceStatus;
	
	/**
	 * 维保方式：维保方式
	*/
	@ApiModelProperty(required = false,value="维保方式" , notes = "维保方式")
	private String maintenanceMethod;
	
	/**
	 * 维保方式[状态]：维保方式[状态]
	*/
	@ApiModelProperty(required = false,value="维保方式[状态]" , notes = "维保方式[状态]")
	private String sMaintenanceMethod;
	
	/**
	 * 建议维保方式：建议维保方式
	*/
	@ApiModelProperty(required = false,value="建议维保方式" , notes = "建议维保方式")
	private String suggestMaintenanceMethod;
	
	/**
	 * 建议维保方式[状态]：建议维保方式[状态]
	*/
	@ApiModelProperty(required = false,value="建议维保方式[状态]" , notes = "建议维保方式[状态]")
	private String sSuggestMaintenanceMethod;
	
	/**
	 * 联系人：联系人
	*/
	@ApiModelProperty(required = false,value="联系人" , notes = "联系人")
	private String contacts;
	
	/**
	 * 联系人[状态]：联系人[状态]
	*/
	@ApiModelProperty(required = false,value="联系人[状态]" , notes = "联系人[状态]")
	private String sContacts;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式")
	private String contactInformation;
	
	/**
	 * 联系方式[状态]：联系方式[状态]
	*/
	@ApiModelProperty(required = false,value="联系方式[状态]" , notes = "联系方式[状态]")
	private String sContactInformation;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private String director;
	
	/**
	 * 负责人[状态]：负责人[状态]
	*/
	@ApiModelProperty(required = false,value="负责人[状态]" , notes = "负责人[状态]")
	private String sDirector;
	
	/**
	 * 维保开始时间：维保开始时间
	*/
	@ApiModelProperty(required = false,value="维保开始时间" , notes = "维保开始时间")
	private Date maintenanceStartDate;
	
	/**
	 * 维保开始时间[状态]：维保开始时间[状态]
	*/
	@ApiModelProperty(required = false,value="维保开始时间[状态]" , notes = "维保开始时间[状态]")
	private String sMaintenanceStartDate;
	
	/**
	 * 维保到期时间：维保到期时间
	*/
	@ApiModelProperty(required = false,value="维保到期时间" , notes = "维保到期时间")
	private Date maintenanceEndDate;
	
	/**
	 * 维保到期时间[状态]：维保到期时间[状态]
	*/
	@ApiModelProperty(required = false,value="维保到期时间[状态]" , notes = "维保到期时间[状态]")
	private String sMaintenanceEndDate;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-10-28 08:23:59")
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
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private Asset asset;
	
	/**
	 * 资产名称：资产名称
	*/
	@ApiModelProperty(required = false,value="资产名称" , notes = "资产名称")
	private String assetAssetName;
	
	/**
	 * 资产编码：资产编码
	*/
	@ApiModelProperty(required = false,value="资产编码" , notes = "资产编码")
	private String assetAssetCode;
	
	/**
	 * 资产型号：资产型号
	*/
	@ApiModelProperty(required = false,value="资产型号" , notes = "资产型号")
	private String assetAssetModel;
	
	/**
	 * 资产状态：资产状态
	*/
	@ApiModelProperty(required = false,value="资产状态" , notes = "资产状态")
	private AssetStatus assetStatus;
	
	/**
	 * 资产分类：资产分类
	*/
	@ApiModelProperty(required = false,value="资产分类" , notes = "资产分类")
	private Catalog category;
	
	/**
	 * 资产状态：资产状态
	*/
	@ApiModelProperty(required = false,value="资产状态" , notes = "资产状态")
	private String assetAssetStatus;
	
	/**
	 * 资产状态：资产状态
	*/
	@ApiModelProperty(required = false,value="资产状态" , notes = "资产状态")
	private String assetAssetCatalog;
	
	/**
	 * 维保商：维保商
	*/
	@ApiModelProperty(required = false,value="维保商" , notes = "维保商")
	private Maintainer maintnainer;
	
	/**
	 * 维保状态：维保状态
	*/
	@ApiModelProperty(required = false,value="维保状态" , notes = "维保状态")
	private DictItem assetMaintenanceStatus;
	
	/**
	 * 建议维保方式：建议维保方式
	*/
	@ApiModelProperty(required = false,value="建议维保方式" , notes = "建议维保方式")
	private DictItem suggestMaintenanceMethodData;
	
	/**
	 * 维保方式：维保方式
	*/
	@ApiModelProperty(required = false,value="维保方式" , notes = "维保方式")
	private DictItem maintenanceMethodData;
	
	/**
	 * assetMaintenanceUpdate：assetMaintenanceUpdate
	*/
	@ApiModelProperty(required = false,value="assetMaintenanceUpdate" , notes = "assetMaintenanceUpdate")
	private AssetMaintenanceUpdate assetMaintenanceUpdate;
	
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
	public AssetMaintenanceRecord setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 维保更新<br>
	 * 维保更新
	 * @return 维保更新
	*/
	public String getMaintenanceUpdateId() {
		return maintenanceUpdateId;
	}
	
	/**
	 * 设置 维保更新
	 * @param maintenanceUpdateId 维保更新
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setMaintenanceUpdateId(String maintenanceUpdateId) {
		this.maintenanceUpdateId=maintenanceUpdateId;
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
	public AssetMaintenanceRecord setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getMaintenanceNotes() {
		return maintenanceNotes;
	}
	
	/**
	 * 设置 备注
	 * @param maintenanceNotes 备注
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setMaintenanceNotes(String maintenanceNotes) {
		this.maintenanceNotes=maintenanceNotes;
		return this;
	}
	
	/**
	 * 获得 备注[状态]<br>
	 * 备注[状态]
	 * @return 备注[状态]
	*/
	public String getSMaintenanceNotes() {
		return sMaintenanceNotes;
	}
	
	/**
	 * 设置 备注[状态]
	 * @param sMaintenanceNotes 备注[状态]
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setSMaintenanceNotes(String sMaintenanceNotes) {
		this.sMaintenanceNotes=sMaintenanceNotes;
		return this;
	}
	
	/**
	 * 获得 维保厂商<br>
	 * 维保厂商
	 * @return 维保厂商
	*/
	public String getMaintainerId() {
		return maintainerId;
	}
	
	/**
	 * 设置 维保厂商
	 * @param maintainerId 维保厂商
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setMaintainerId(String maintainerId) {
		this.maintainerId=maintainerId;
		return this;
	}
	
	/**
	 * 获得 维保厂商[状态]<br>
	 * 维保厂商[状态]
	 * @return 维保厂商[状态]
	*/
	public String getSMaintainerId() {
		return sMaintainerId;
	}
	
	/**
	 * 设置 维保厂商[状态]
	 * @param sMaintainerId 维保厂商[状态]
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setSMaintainerId(String sMaintainerId) {
		this.sMaintainerId=sMaintainerId;
		return this;
	}
	
	/**
	 * 获得 维保厂商名称<br>
	 * 维保厂商名称
	 * @return 维保厂商名称
	*/
	public String getMaintainerName() {
		return maintainerName;
	}
	
	/**
	 * 设置 维保厂商名称
	 * @param maintainerName 维保厂商名称
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setMaintainerName(String maintainerName) {
		this.maintainerName=maintainerName;
		return this;
	}
	
	/**
	 * 获得 维保厂商名称[状态]<br>
	 * 维保厂商名称[状态]
	 * @return 维保厂商名称[状态]
	*/
	public String getSMaintainerName() {
		return sMaintainerName;
	}
	
	/**
	 * 设置 维保厂商名称[状态]
	 * @param sMaintainerName 维保厂商名称[状态]
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setSMaintainerName(String sMaintainerName) {
		this.sMaintainerName=sMaintainerName;
		return this;
	}
	
	/**
	 * 获得 维保状态<br>
	 * 维保状态
	 * @return 维保状态
	*/
	public String getMaintenanceStatus() {
		return maintenanceStatus;
	}
	
	/**
	 * 设置 维保状态
	 * @param maintenanceStatus 维保状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setMaintenanceStatus(String maintenanceStatus) {
		this.maintenanceStatus=maintenanceStatus;
		return this;
	}
	
	/**
	 * 获得 维保状态[状态]<br>
	 * 维保状态[状态]
	 * @return 维保状态[状态]
	*/
	public String getSMaintenanceStatus() {
		return sMaintenanceStatus;
	}
	
	/**
	 * 设置 维保状态[状态]
	 * @param sMaintenanceStatus 维保状态[状态]
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setSMaintenanceStatus(String sMaintenanceStatus) {
		this.sMaintenanceStatus=sMaintenanceStatus;
		return this;
	}
	
	/**
	 * 获得 维保方式<br>
	 * 维保方式
	 * @return 维保方式
	*/
	public String getMaintenanceMethod() {
		return maintenanceMethod;
	}
	
	/**
	 * 设置 维保方式
	 * @param maintenanceMethod 维保方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setMaintenanceMethod(String maintenanceMethod) {
		this.maintenanceMethod=maintenanceMethod;
		return this;
	}
	
	/**
	 * 获得 维保方式[状态]<br>
	 * 维保方式[状态]
	 * @return 维保方式[状态]
	*/
	public String getSMaintenanceMethod() {
		return sMaintenanceMethod;
	}
	
	/**
	 * 设置 维保方式[状态]
	 * @param sMaintenanceMethod 维保方式[状态]
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setSMaintenanceMethod(String sMaintenanceMethod) {
		this.sMaintenanceMethod=sMaintenanceMethod;
		return this;
	}
	
	/**
	 * 获得 建议维保方式<br>
	 * 建议维保方式
	 * @return 建议维保方式
	*/
	public String getSuggestMaintenanceMethod() {
		return suggestMaintenanceMethod;
	}
	
	/**
	 * 设置 建议维保方式
	 * @param suggestMaintenanceMethod 建议维保方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setSuggestMaintenanceMethod(String suggestMaintenanceMethod) {
		this.suggestMaintenanceMethod=suggestMaintenanceMethod;
		return this;
	}
	
	/**
	 * 获得 建议维保方式[状态]<br>
	 * 建议维保方式[状态]
	 * @return 建议维保方式[状态]
	*/
	public String getSSuggestMaintenanceMethod() {
		return sSuggestMaintenanceMethod;
	}
	
	/**
	 * 设置 建议维保方式[状态]
	 * @param sSuggestMaintenanceMethod 建议维保方式[状态]
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setSSuggestMaintenanceMethod(String sSuggestMaintenanceMethod) {
		this.sSuggestMaintenanceMethod=sSuggestMaintenanceMethod;
		return this;
	}
	
	/**
	 * 获得 联系人<br>
	 * 联系人
	 * @return 联系人
	*/
	public String getContacts() {
		return contacts;
	}
	
	/**
	 * 设置 联系人
	 * @param contacts 联系人
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setContacts(String contacts) {
		this.contacts=contacts;
		return this;
	}
	
	/**
	 * 获得 联系人[状态]<br>
	 * 联系人[状态]
	 * @return 联系人[状态]
	*/
	public String getSContacts() {
		return sContacts;
	}
	
	/**
	 * 设置 联系人[状态]
	 * @param sContacts 联系人[状态]
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setSContacts(String sContacts) {
		this.sContacts=sContacts;
		return this;
	}
	
	/**
	 * 获得 联系方式<br>
	 * 联系方式
	 * @return 联系方式
	*/
	public String getContactInformation() {
		return contactInformation;
	}
	
	/**
	 * 设置 联系方式
	 * @param contactInformation 联系方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setContactInformation(String contactInformation) {
		this.contactInformation=contactInformation;
		return this;
	}
	
	/**
	 * 获得 联系方式[状态]<br>
	 * 联系方式[状态]
	 * @return 联系方式[状态]
	*/
	public String getSContactInformation() {
		return sContactInformation;
	}
	
	/**
	 * 设置 联系方式[状态]
	 * @param sContactInformation 联系方式[状态]
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setSContactInformation(String sContactInformation) {
		this.sContactInformation=sContactInformation;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public String getDirector() {
		return director;
	}
	
	/**
	 * 设置 负责人
	 * @param director 负责人
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setDirector(String director) {
		this.director=director;
		return this;
	}
	
	/**
	 * 获得 负责人[状态]<br>
	 * 负责人[状态]
	 * @return 负责人[状态]
	*/
	public String getSDirector() {
		return sDirector;
	}
	
	/**
	 * 设置 负责人[状态]
	 * @param sDirector 负责人[状态]
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setSDirector(String sDirector) {
		this.sDirector=sDirector;
		return this;
	}
	
	/**
	 * 获得 维保开始时间<br>
	 * 维保开始时间
	 * @return 维保开始时间
	*/
	public Date getMaintenanceStartDate() {
		return maintenanceStartDate;
	}
	
	/**
	 * 设置 维保开始时间
	 * @param maintenanceStartDate 维保开始时间
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setMaintenanceStartDate(Date maintenanceStartDate) {
		this.maintenanceStartDate=maintenanceStartDate;
		return this;
	}
	
	/**
	 * 获得 维保开始时间[状态]<br>
	 * 维保开始时间[状态]
	 * @return 维保开始时间[状态]
	*/
	public String getSMaintenanceStartDate() {
		return sMaintenanceStartDate;
	}
	
	/**
	 * 设置 维保开始时间[状态]
	 * @param sMaintenanceStartDate 维保开始时间[状态]
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setSMaintenanceStartDate(String sMaintenanceStartDate) {
		this.sMaintenanceStartDate=sMaintenanceStartDate;
		return this;
	}
	
	/**
	 * 获得 维保到期时间<br>
	 * 维保到期时间
	 * @return 维保到期时间
	*/
	public Date getMaintenanceEndDate() {
		return maintenanceEndDate;
	}
	
	/**
	 * 设置 维保到期时间
	 * @param maintenanceEndDate 维保到期时间
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setMaintenanceEndDate(Date maintenanceEndDate) {
		this.maintenanceEndDate=maintenanceEndDate;
		return this;
	}
	
	/**
	 * 获得 维保到期时间[状态]<br>
	 * 维保到期时间[状态]
	 * @return 维保到期时间[状态]
	*/
	public String getSMaintenanceEndDate() {
		return sMaintenanceEndDate;
	}
	
	/**
	 * 设置 维保到期时间[状态]
	 * @param sMaintenanceEndDate 维保到期时间[状态]
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setSMaintenanceEndDate(String sMaintenanceEndDate) {
		this.sMaintenanceEndDate=sMaintenanceEndDate;
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
	public AssetMaintenanceRecord setCreateBy(String createBy) {
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
	public AssetMaintenanceRecord setCreateTime(Date createTime) {
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
	public AssetMaintenanceRecord setUpdateBy(String updateBy) {
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
	public AssetMaintenanceRecord setUpdateTime(Date updateTime) {
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
	public AssetMaintenanceRecord setDeleted(Integer deleted) {
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
	public AssetMaintenanceRecord setDeleted(Boolean deletedBool) {
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
	public AssetMaintenanceRecord setDeleteBy(String deleteBy) {
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
	public AssetMaintenanceRecord setDeleteTime(Date deleteTime) {
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
	public AssetMaintenanceRecord setVersion(Integer version) {
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
	public AssetMaintenanceRecord setTenantId(String tenantId) {
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
	public AssetMaintenanceRecord setAsset(Asset asset) {
		this.asset=asset;
		return this;
	}
	
	/**
	 * 获得 资产名称<br>
	 * 资产名称
	 * @return 资产名称
	*/
	public String getAssetAssetName() {
		return assetAssetName;
	}
	
	/**
	 * 设置 资产名称
	 * @param assetAssetName 资产名称
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setAssetAssetName(String assetAssetName) {
		this.assetAssetName=assetAssetName;
		return this;
	}
	
	/**
	 * 获得 资产编码<br>
	 * 资产编码
	 * @return 资产编码
	*/
	public String getAssetAssetCode() {
		return assetAssetCode;
	}
	
	/**
	 * 设置 资产编码
	 * @param assetAssetCode 资产编码
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setAssetAssetCode(String assetAssetCode) {
		this.assetAssetCode=assetAssetCode;
		return this;
	}
	
	/**
	 * 获得 资产型号<br>
	 * 资产型号
	 * @return 资产型号
	*/
	public String getAssetAssetModel() {
		return assetAssetModel;
	}
	
	/**
	 * 设置 资产型号
	 * @param assetAssetModel 资产型号
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setAssetAssetModel(String assetAssetModel) {
		this.assetAssetModel=assetAssetModel;
		return this;
	}
	
	/**
	 * 获得 资产状态<br>
	 * 资产状态
	 * @return 资产状态
	*/
	public AssetStatus getAssetStatus() {
		return assetStatus;
	}
	
	/**
	 * 设置 资产状态
	 * @param assetStatus 资产状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setAssetStatus(AssetStatus assetStatus) {
		this.assetStatus=assetStatus;
		return this;
	}
	
	/**
	 * 获得 资产分类<br>
	 * 资产分类
	 * @return 资产分类
	*/
	public Catalog getCategory() {
		return category;
	}
	
	/**
	 * 设置 资产分类
	 * @param category 资产分类
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setCategory(Catalog category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 获得 资产状态<br>
	 * 资产状态
	 * @return 资产状态
	*/
	public String getAssetAssetStatus() {
		return assetAssetStatus;
	}
	
	/**
	 * 设置 资产状态
	 * @param assetAssetStatus 资产状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setAssetAssetStatus(String assetAssetStatus) {
		this.assetAssetStatus=assetAssetStatus;
		return this;
	}
	
	/**
	 * 获得 资产状态<br>
	 * 资产状态
	 * @return 资产状态
	*/
	public String getAssetAssetCatalog() {
		return assetAssetCatalog;
	}
	
	/**
	 * 设置 资产状态
	 * @param assetAssetCatalog 资产状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setAssetAssetCatalog(String assetAssetCatalog) {
		this.assetAssetCatalog=assetAssetCatalog;
		return this;
	}
	
	/**
	 * 获得 维保商<br>
	 * 维保商
	 * @return 维保商
	*/
	public Maintainer getMaintnainer() {
		return maintnainer;
	}
	
	/**
	 * 设置 维保商
	 * @param maintnainer 维保商
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setMaintnainer(Maintainer maintnainer) {
		this.maintnainer=maintnainer;
		return this;
	}
	
	/**
	 * 获得 维保状态<br>
	 * 维保状态
	 * @return 维保状态
	*/
	public DictItem getAssetMaintenanceStatus() {
		return assetMaintenanceStatus;
	}
	
	/**
	 * 设置 维保状态
	 * @param assetMaintenanceStatus 维保状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setAssetMaintenanceStatus(DictItem assetMaintenanceStatus) {
		this.assetMaintenanceStatus=assetMaintenanceStatus;
		return this;
	}
	
	/**
	 * 获得 建议维保方式<br>
	 * 建议维保方式
	 * @return 建议维保方式
	*/
	public DictItem getSuggestMaintenanceMethodData() {
		return suggestMaintenanceMethodData;
	}
	
	/**
	 * 设置 建议维保方式
	 * @param suggestMaintenanceMethodData 建议维保方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setSuggestMaintenanceMethodData(DictItem suggestMaintenanceMethodData) {
		this.suggestMaintenanceMethodData=suggestMaintenanceMethodData;
		return this;
	}
	
	/**
	 * 获得 维保方式<br>
	 * 维保方式
	 * @return 维保方式
	*/
	public DictItem getMaintenanceMethodData() {
		return maintenanceMethodData;
	}
	
	/**
	 * 设置 维保方式
	 * @param maintenanceMethodData 维保方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setMaintenanceMethodData(DictItem maintenanceMethodData) {
		this.maintenanceMethodData=maintenanceMethodData;
		return this;
	}
	
	/**
	 * 获得 assetMaintenanceUpdate<br>
	 * assetMaintenanceUpdate
	 * @return assetMaintenanceUpdate
	*/
	public AssetMaintenanceUpdate getAssetMaintenanceUpdate() {
		return assetMaintenanceUpdate;
	}
	
	/**
	 * 设置 assetMaintenanceUpdate
	 * @param assetMaintenanceUpdate assetMaintenanceUpdate
	 * @return 当前对象
	*/
	public AssetMaintenanceRecord setAssetMaintenanceUpdate(AssetMaintenanceUpdate assetMaintenanceUpdate) {
		this.assetMaintenanceUpdate=assetMaintenanceUpdate;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetMaintenanceRecord , 转换好的 AssetMaintenanceRecord 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetMaintenanceRecord , 转换好的 PoJo 对象
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
	public AssetMaintenanceRecord clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetMaintenanceRecord duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetMaintenanceRecordMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetMaintenanceRecordMeta.$$proxy$$();
		inst.setMaintenanceStatus(this.getMaintenanceStatus());
		inst.setSMaintenanceStartDate(this.getSMaintenanceStartDate());
		inst.setMaintenanceEndDate(this.getMaintenanceEndDate());
		inst.setSContactInformation(this.getSContactInformation());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setAssetId(this.getAssetId());
		inst.setSuggestMaintenanceMethod(this.getSuggestMaintenanceMethod());
		inst.setId(this.getId());
		inst.setMaintainerName(this.getMaintainerName());
		inst.setSMaintenanceMethod(this.getSMaintenanceMethod());
		inst.setSDirector(this.getSDirector());
		inst.setSContacts(this.getSContacts());
		inst.setSSuggestMaintenanceMethod(this.getSSuggestMaintenanceMethod());
		inst.setSMaintainerName(this.getSMaintainerName());
		inst.setDirector(this.getDirector());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setSMaintenanceNotes(this.getSMaintenanceNotes());
		inst.setSMaintainerId(this.getSMaintainerId());
		inst.setSMaintenanceStatus(this.getSMaintenanceStatus());
		inst.setMaintenanceNotes(this.getMaintenanceNotes());
		inst.setMaintainerId(this.getMaintainerId());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setMaintenanceUpdateId(this.getMaintenanceUpdateId());
		inst.setTenantId(this.getTenantId());
		inst.setMaintenanceMethod(this.getMaintenanceMethod());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setMaintenanceStartDate(this.getMaintenanceStartDate());
		inst.setSMaintenanceEndDate(this.getSMaintenanceEndDate());
		inst.setContacts(this.getContacts());
		if(all) {
			inst.setAssetAssetName(this.getAssetAssetName());
			inst.setSuggestMaintenanceMethodData(this.getSuggestMaintenanceMethodData());
			inst.setAssetAssetStatus(this.getAssetAssetStatus());
			inst.setAssetAssetCode(this.getAssetAssetCode());
			inst.setAssetAssetCatalog(this.getAssetAssetCatalog());
			inst.setAssetAssetModel(this.getAssetAssetModel());
			inst.setMaintnainer(this.getMaintnainer());
			inst.setAssetMaintenanceStatus(this.getAssetMaintenanceStatus());
			inst.setAssetMaintenanceUpdate(this.getAssetMaintenanceUpdate());
			inst.setMaintenanceMethodData(this.getMaintenanceMethodData());
			inst.setAsset(this.getAsset());
			inst.setCategory(this.getCategory());
			inst.setAssetStatus(this.getAssetStatus());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetMaintenanceRecord clone(boolean deep) {
		return EntityContext.clone(AssetMaintenanceRecord.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetMaintenanceRecord
	 * @param assetMaintenanceRecordMap 包含实体信息的 Map 对象
	 * @return AssetMaintenanceRecord , 转换好的的 AssetMaintenanceRecord 对象
	*/
	@Transient
	public static AssetMaintenanceRecord createFrom(Map<String,Object> assetMaintenanceRecordMap) {
		if(assetMaintenanceRecordMap==null) return null;
		AssetMaintenanceRecord po = create();
		EntityContext.copyProperties(po,assetMaintenanceRecordMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetMaintenanceRecord
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetMaintenanceRecord , 转换好的的 AssetMaintenanceRecord 对象
	*/
	@Transient
	public static AssetMaintenanceRecord createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetMaintenanceRecord po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetMaintenanceRecord，等同于 new
	 * @return AssetMaintenanceRecord 对象
	*/
	@Transient
	public static AssetMaintenanceRecord create() {
		return new com.dt.platform.domain.eam.meta.AssetMaintenanceRecordMeta.$$proxy$$();
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
			this.setMaintenanceStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.MAINTENANCE_STATUS)));
			this.setSMaintenanceStartDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.S_MAINTENANCE_START_DATE)));
			this.setMaintenanceEndDate(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordMeta.MAINTENANCE_END_DATE)));
			this.setSContactInformation(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.S_CONTACT_INFORMATION)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.UPDATE_BY)));
			this.setAssetId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.ASSET_ID)));
			this.setSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.SUGGEST_MAINTENANCE_METHOD)));
			this.setId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.ID)));
			this.setMaintainerName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.MAINTAINER_NAME)));
			this.setSMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.S_MAINTENANCE_METHOD)));
			this.setSDirector(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.S_DIRECTOR)));
			this.setSContacts(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.S_CONTACTS)));
			this.setSSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.S_SUGGEST_MAINTENANCE_METHOD)));
			this.setSMaintainerName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.S_MAINTAINER_NAME)));
			this.setDirector(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.DIRECTOR)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetMaintenanceRecordMeta.VERSION)));
			this.setSMaintenanceNotes(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.S_MAINTENANCE_NOTES)));
			this.setSMaintainerId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.S_MAINTAINER_ID)));
			this.setSMaintenanceStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.S_MAINTENANCE_STATUS)));
			this.setMaintenanceNotes(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.MAINTENANCE_NOTES)));
			this.setMaintainerId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.MAINTAINER_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetMaintenanceRecordMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordMeta.DELETE_TIME)));
			this.setMaintenanceUpdateId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.MAINTENANCE_UPDATE_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.TENANT_ID)));
			this.setMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.MAINTENANCE_METHOD)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.DELETE_BY)));
			this.setMaintenanceStartDate(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordMeta.MAINTENANCE_START_DATE)));
			this.setSMaintenanceEndDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.S_MAINTENANCE_END_DATE)));
			this.setContacts(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.CONTACTS)));
			// others
			this.setAssetAssetName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.ASSET_ASSET_NAME)));
			this.setSuggestMaintenanceMethodData(DataParser.parse(DictItem.class, map.get(AssetMaintenanceRecordMeta.SUGGEST_MAINTENANCE_METHOD_DATA)));
			this.setAssetAssetStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.ASSET_ASSET_STATUS)));
			this.setAssetAssetCode(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.ASSET_ASSET_CODE)));
			this.setAssetAssetCatalog(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.ASSET_ASSET_CATALOG)));
			this.setAssetAssetModel(DataParser.parse(String.class, map.get(AssetMaintenanceRecordMeta.ASSET_ASSET_MODEL)));
			this.setMaintnainer(DataParser.parse(Maintainer.class, map.get(AssetMaintenanceRecordMeta.MAINTNAINER)));
			this.setAssetMaintenanceStatus(DataParser.parse(DictItem.class, map.get(AssetMaintenanceRecordMeta.ASSET_MAINTENANCE_STATUS)));
			this.setAssetMaintenanceUpdate(DataParser.parse(AssetMaintenanceUpdate.class, map.get(AssetMaintenanceRecordMeta.ASSET_MAINTENANCE_UPDATE)));
			this.setMaintenanceMethodData(DataParser.parse(DictItem.class, map.get(AssetMaintenanceRecordMeta.MAINTENANCE_METHOD_DATA)));
			this.setAsset(DataParser.parse(Asset.class, map.get(AssetMaintenanceRecordMeta.ASSET)));
			this.setCategory(DataParser.parse(Catalog.class, map.get(AssetMaintenanceRecordMeta.CATEGORY)));
			this.setAssetStatus(DataParser.parse(AssetStatus.class, map.get(AssetMaintenanceRecordMeta.ASSET_STATUS)));
			return true;
		} else {
			try {
				this.setMaintenanceStatus( (String)map.get(AssetMaintenanceRecordMeta.MAINTENANCE_STATUS));
				this.setSMaintenanceStartDate( (String)map.get(AssetMaintenanceRecordMeta.S_MAINTENANCE_START_DATE));
				this.setMaintenanceEndDate( (Date)map.get(AssetMaintenanceRecordMeta.MAINTENANCE_END_DATE));
				this.setSContactInformation( (String)map.get(AssetMaintenanceRecordMeta.S_CONTACT_INFORMATION));
				this.setUpdateBy( (String)map.get(AssetMaintenanceRecordMeta.UPDATE_BY));
				this.setAssetId( (String)map.get(AssetMaintenanceRecordMeta.ASSET_ID));
				this.setSuggestMaintenanceMethod( (String)map.get(AssetMaintenanceRecordMeta.SUGGEST_MAINTENANCE_METHOD));
				this.setId( (String)map.get(AssetMaintenanceRecordMeta.ID));
				this.setMaintainerName( (String)map.get(AssetMaintenanceRecordMeta.MAINTAINER_NAME));
				this.setSMaintenanceMethod( (String)map.get(AssetMaintenanceRecordMeta.S_MAINTENANCE_METHOD));
				this.setSDirector( (String)map.get(AssetMaintenanceRecordMeta.S_DIRECTOR));
				this.setSContacts( (String)map.get(AssetMaintenanceRecordMeta.S_CONTACTS));
				this.setSSuggestMaintenanceMethod( (String)map.get(AssetMaintenanceRecordMeta.S_SUGGEST_MAINTENANCE_METHOD));
				this.setSMaintainerName( (String)map.get(AssetMaintenanceRecordMeta.S_MAINTAINER_NAME));
				this.setDirector( (String)map.get(AssetMaintenanceRecordMeta.DIRECTOR));
				this.setUpdateTime( (Date)map.get(AssetMaintenanceRecordMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetMaintenanceRecordMeta.VERSION));
				this.setSMaintenanceNotes( (String)map.get(AssetMaintenanceRecordMeta.S_MAINTENANCE_NOTES));
				this.setSMaintainerId( (String)map.get(AssetMaintenanceRecordMeta.S_MAINTAINER_ID));
				this.setSMaintenanceStatus( (String)map.get(AssetMaintenanceRecordMeta.S_MAINTENANCE_STATUS));
				this.setMaintenanceNotes( (String)map.get(AssetMaintenanceRecordMeta.MAINTENANCE_NOTES));
				this.setMaintainerId( (String)map.get(AssetMaintenanceRecordMeta.MAINTAINER_ID));
				this.setCreateBy( (String)map.get(AssetMaintenanceRecordMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(AssetMaintenanceRecordMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)map.get(AssetMaintenanceRecordMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetMaintenanceRecordMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetMaintenanceRecordMeta.DELETE_TIME));
				this.setMaintenanceUpdateId( (String)map.get(AssetMaintenanceRecordMeta.MAINTENANCE_UPDATE_ID));
				this.setTenantId( (String)map.get(AssetMaintenanceRecordMeta.TENANT_ID));
				this.setMaintenanceMethod( (String)map.get(AssetMaintenanceRecordMeta.MAINTENANCE_METHOD));
				this.setDeleteBy( (String)map.get(AssetMaintenanceRecordMeta.DELETE_BY));
				this.setMaintenanceStartDate( (Date)map.get(AssetMaintenanceRecordMeta.MAINTENANCE_START_DATE));
				this.setSMaintenanceEndDate( (String)map.get(AssetMaintenanceRecordMeta.S_MAINTENANCE_END_DATE));
				this.setContacts( (String)map.get(AssetMaintenanceRecordMeta.CONTACTS));
				// others
				this.setAssetAssetName( (String)map.get(AssetMaintenanceRecordMeta.ASSET_ASSET_NAME));
				this.setSuggestMaintenanceMethodData( (DictItem)map.get(AssetMaintenanceRecordMeta.SUGGEST_MAINTENANCE_METHOD_DATA));
				this.setAssetAssetStatus( (String)map.get(AssetMaintenanceRecordMeta.ASSET_ASSET_STATUS));
				this.setAssetAssetCode( (String)map.get(AssetMaintenanceRecordMeta.ASSET_ASSET_CODE));
				this.setAssetAssetCatalog( (String)map.get(AssetMaintenanceRecordMeta.ASSET_ASSET_CATALOG));
				this.setAssetAssetModel( (String)map.get(AssetMaintenanceRecordMeta.ASSET_ASSET_MODEL));
				this.setMaintnainer( (Maintainer)map.get(AssetMaintenanceRecordMeta.MAINTNAINER));
				this.setAssetMaintenanceStatus( (DictItem)map.get(AssetMaintenanceRecordMeta.ASSET_MAINTENANCE_STATUS));
				this.setAssetMaintenanceUpdate( (AssetMaintenanceUpdate)map.get(AssetMaintenanceRecordMeta.ASSET_MAINTENANCE_UPDATE));
				this.setMaintenanceMethodData( (DictItem)map.get(AssetMaintenanceRecordMeta.MAINTENANCE_METHOD_DATA));
				this.setAsset( (Asset)map.get(AssetMaintenanceRecordMeta.ASSET));
				this.setCategory( (Catalog)map.get(AssetMaintenanceRecordMeta.CATEGORY));
				this.setAssetStatus( (AssetStatus)map.get(AssetMaintenanceRecordMeta.ASSET_STATUS));
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
			this.setMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.MAINTENANCE_STATUS)));
			this.setSMaintenanceStartDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.S_MAINTENANCE_START_DATE)));
			this.setMaintenanceEndDate(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordMeta.MAINTENANCE_END_DATE)));
			this.setSContactInformation(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.S_CONTACT_INFORMATION)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.UPDATE_BY)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.ASSET_ID)));
			this.setSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.SUGGEST_MAINTENANCE_METHOD)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.ID)));
			this.setMaintainerName(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.MAINTAINER_NAME)));
			this.setSMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.S_MAINTENANCE_METHOD)));
			this.setSDirector(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.S_DIRECTOR)));
			this.setSContacts(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.S_CONTACTS)));
			this.setSSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.S_SUGGEST_MAINTENANCE_METHOD)));
			this.setSMaintainerName(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.S_MAINTAINER_NAME)));
			this.setDirector(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.DIRECTOR)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetMaintenanceRecordMeta.VERSION)));
			this.setSMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.S_MAINTENANCE_NOTES)));
			this.setSMaintainerId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.S_MAINTAINER_ID)));
			this.setSMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.S_MAINTENANCE_STATUS)));
			this.setMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.MAINTENANCE_NOTES)));
			this.setMaintainerId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.MAINTAINER_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetMaintenanceRecordMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordMeta.DELETE_TIME)));
			this.setMaintenanceUpdateId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.MAINTENANCE_UPDATE_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.TENANT_ID)));
			this.setMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.MAINTENANCE_METHOD)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.DELETE_BY)));
			this.setMaintenanceStartDate(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordMeta.MAINTENANCE_START_DATE)));
			this.setSMaintenanceEndDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.S_MAINTENANCE_END_DATE)));
			this.setContacts(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordMeta.CONTACTS)));
			return true;
		} else {
			try {
				this.setMaintenanceStatus( (String)r.getValue(AssetMaintenanceRecordMeta.MAINTENANCE_STATUS));
				this.setSMaintenanceStartDate( (String)r.getValue(AssetMaintenanceRecordMeta.S_MAINTENANCE_START_DATE));
				this.setMaintenanceEndDate( (Date)r.getValue(AssetMaintenanceRecordMeta.MAINTENANCE_END_DATE));
				this.setSContactInformation( (String)r.getValue(AssetMaintenanceRecordMeta.S_CONTACT_INFORMATION));
				this.setUpdateBy( (String)r.getValue(AssetMaintenanceRecordMeta.UPDATE_BY));
				this.setAssetId( (String)r.getValue(AssetMaintenanceRecordMeta.ASSET_ID));
				this.setSuggestMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordMeta.SUGGEST_MAINTENANCE_METHOD));
				this.setId( (String)r.getValue(AssetMaintenanceRecordMeta.ID));
				this.setMaintainerName( (String)r.getValue(AssetMaintenanceRecordMeta.MAINTAINER_NAME));
				this.setSMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordMeta.S_MAINTENANCE_METHOD));
				this.setSDirector( (String)r.getValue(AssetMaintenanceRecordMeta.S_DIRECTOR));
				this.setSContacts( (String)r.getValue(AssetMaintenanceRecordMeta.S_CONTACTS));
				this.setSSuggestMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordMeta.S_SUGGEST_MAINTENANCE_METHOD));
				this.setSMaintainerName( (String)r.getValue(AssetMaintenanceRecordMeta.S_MAINTAINER_NAME));
				this.setDirector( (String)r.getValue(AssetMaintenanceRecordMeta.DIRECTOR));
				this.setUpdateTime( (Date)r.getValue(AssetMaintenanceRecordMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetMaintenanceRecordMeta.VERSION));
				this.setSMaintenanceNotes( (String)r.getValue(AssetMaintenanceRecordMeta.S_MAINTENANCE_NOTES));
				this.setSMaintainerId( (String)r.getValue(AssetMaintenanceRecordMeta.S_MAINTAINER_ID));
				this.setSMaintenanceStatus( (String)r.getValue(AssetMaintenanceRecordMeta.S_MAINTENANCE_STATUS));
				this.setMaintenanceNotes( (String)r.getValue(AssetMaintenanceRecordMeta.MAINTENANCE_NOTES));
				this.setMaintainerId( (String)r.getValue(AssetMaintenanceRecordMeta.MAINTAINER_ID));
				this.setCreateBy( (String)r.getValue(AssetMaintenanceRecordMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(AssetMaintenanceRecordMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)r.getValue(AssetMaintenanceRecordMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetMaintenanceRecordMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetMaintenanceRecordMeta.DELETE_TIME));
				this.setMaintenanceUpdateId( (String)r.getValue(AssetMaintenanceRecordMeta.MAINTENANCE_UPDATE_ID));
				this.setTenantId( (String)r.getValue(AssetMaintenanceRecordMeta.TENANT_ID));
				this.setMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordMeta.MAINTENANCE_METHOD));
				this.setDeleteBy( (String)r.getValue(AssetMaintenanceRecordMeta.DELETE_BY));
				this.setMaintenanceStartDate( (Date)r.getValue(AssetMaintenanceRecordMeta.MAINTENANCE_START_DATE));
				this.setSMaintenanceEndDate( (String)r.getValue(AssetMaintenanceRecordMeta.S_MAINTENANCE_END_DATE));
				this.setContacts( (String)r.getValue(AssetMaintenanceRecordMeta.CONTACTS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}