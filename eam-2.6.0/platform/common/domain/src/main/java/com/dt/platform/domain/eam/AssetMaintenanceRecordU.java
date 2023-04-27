package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_MAINTENANCE_RECORD_U;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.system.DictItem;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetMaintenanceRecordUMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 维保更新记录
 * <p>维保更新记录 , 数据表 eam_asset_maintenance_record_u 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-29 15:12:32
 * @sign 2A61B2A7BDB02816853AD4DC514B9B22
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_maintenance_record_u")
@ApiModel(description = "维保更新记录 ; 维保更新记录 , 数据表 eam_asset_maintenance_record_u 的PO类型")
public class AssetMaintenanceRecordU extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_MAINTENANCE_RECORD_U.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 维保更新：维保更新
	*/
	@ApiModelProperty(required = false,value="维保更新" , notes = "维保更新")
	private String maintenanceUpdateId;
	
	/**
	 * 维保厂商：维保厂商
	*/
	@ApiModelProperty(required = false,value="维保厂商" , notes = "维保厂商")
	private String maintainerId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String sMaintainerId;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uMaintainerId;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uSMaintainerId;
	
	/**
	 * 维保厂商名称：维保厂商名称
	*/
	@ApiModelProperty(required = false,value="维保厂商名称" , notes = "维保厂商名称")
	private String maintainerName;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String sMaintainerName;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uMaintainerName;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uSMaintainerName;
	
	/**
	 * 维保状态：维保状态
	*/
	@ApiModelProperty(required = false,value="维保状态" , notes = "维保状态")
	private String maintenanceStatus;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String sMaintenanceStatus;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uMaintenanceStatus;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uSMaintenanceStatus;
	
	/**
	 * 维保方式：维保方式
	*/
	@ApiModelProperty(required = false,value="维保方式" , notes = "维保方式")
	private String maintenanceMethod;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String sMaintenanceMethod;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uMaintenanceMethod;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uSMaintenanceMethod;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式")
	private String contactInformation;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String sContactInformation;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uContactInformation;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uSContactInformation;
	
	/**
	 * 建议维保方式：建议维保方式
	*/
	@ApiModelProperty(required = false,value="建议维保方式" , notes = "建议维保方式")
	private String suggestMaintenanceMethod;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String sSuggestMaintenanceMethod;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uSuggestMaintenanceMethod;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uSSuggestMaintenanceMethod;
	
	/**
	 * 联系人：联系人
	*/
	@ApiModelProperty(required = false,value="联系人" , notes = "联系人")
	private String contacts;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String sContacts;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uContacts;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uSContacts;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private String director;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String sDirector;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uDirector;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uSDirector;
	
	/**
	 * 维保开始时间：维保开始时间
	*/
	@ApiModelProperty(required = false,value="维保开始时间" , notes = "维保开始时间")
	private Date maintenanceStartDate;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String sMaintenanceStartDate;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uMaintenanceStartDate;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uSMaintenanceStartDate;
	
	/**
	 * 维保到期时间：维保到期时间
	*/
	@ApiModelProperty(required = false,value="维保到期时间" , notes = "维保到期时间")
	private Date maintenanceEndDate;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String sMaintenanceEndDate;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uMaintenanceEndDate;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uSMaintenanceEndDate;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String maintenanceNotes;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String sMaintenanceNotes;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uMaintenanceNotes;
	
	/**
	 * 更新方式：更新方式
	*/
	@ApiModelProperty(required = false,value="更新方式" , notes = "更新方式")
	private String uSMaintenanceNotes;
	
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
	 * recordIdList：recordIdList
	*/
	@ApiModelProperty(required = false,value="recordIdList" , notes = "recordIdList")
	private List<String> recordIdList;
	
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
	public AssetMaintenanceRecordU setId(String id) {
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
	public AssetMaintenanceRecordU setMaintenanceUpdateId(String maintenanceUpdateId) {
		this.maintenanceUpdateId=maintenanceUpdateId;
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
	public AssetMaintenanceRecordU setMaintainerId(String maintainerId) {
		this.maintainerId=maintainerId;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getSMaintainerId() {
		return sMaintainerId;
	}
	
	/**
	 * 设置 状态
	 * @param sMaintainerId 状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setSMaintainerId(String sMaintainerId) {
		this.sMaintainerId=sMaintainerId;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUMaintainerId() {
		return uMaintainerId;
	}
	
	/**
	 * 设置 更新方式
	 * @param uMaintainerId 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUMaintainerId(String uMaintainerId) {
		this.uMaintainerId=uMaintainerId;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUSMaintainerId() {
		return uSMaintainerId;
	}
	
	/**
	 * 设置 更新方式
	 * @param uSMaintainerId 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUSMaintainerId(String uSMaintainerId) {
		this.uSMaintainerId=uSMaintainerId;
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
	public AssetMaintenanceRecordU setMaintainerName(String maintainerName) {
		this.maintainerName=maintainerName;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getSMaintainerName() {
		return sMaintainerName;
	}
	
	/**
	 * 设置 状态
	 * @param sMaintainerName 状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setSMaintainerName(String sMaintainerName) {
		this.sMaintainerName=sMaintainerName;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUMaintainerName() {
		return uMaintainerName;
	}
	
	/**
	 * 设置 更新方式
	 * @param uMaintainerName 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUMaintainerName(String uMaintainerName) {
		this.uMaintainerName=uMaintainerName;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUSMaintainerName() {
		return uSMaintainerName;
	}
	
	/**
	 * 设置 更新方式
	 * @param uSMaintainerName 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUSMaintainerName(String uSMaintainerName) {
		this.uSMaintainerName=uSMaintainerName;
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
	public AssetMaintenanceRecordU setMaintenanceStatus(String maintenanceStatus) {
		this.maintenanceStatus=maintenanceStatus;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getSMaintenanceStatus() {
		return sMaintenanceStatus;
	}
	
	/**
	 * 设置 状态
	 * @param sMaintenanceStatus 状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setSMaintenanceStatus(String sMaintenanceStatus) {
		this.sMaintenanceStatus=sMaintenanceStatus;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUMaintenanceStatus() {
		return uMaintenanceStatus;
	}
	
	/**
	 * 设置 更新方式
	 * @param uMaintenanceStatus 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUMaintenanceStatus(String uMaintenanceStatus) {
		this.uMaintenanceStatus=uMaintenanceStatus;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUSMaintenanceStatus() {
		return uSMaintenanceStatus;
	}
	
	/**
	 * 设置 更新方式
	 * @param uSMaintenanceStatus 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUSMaintenanceStatus(String uSMaintenanceStatus) {
		this.uSMaintenanceStatus=uSMaintenanceStatus;
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
	public AssetMaintenanceRecordU setMaintenanceMethod(String maintenanceMethod) {
		this.maintenanceMethod=maintenanceMethod;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getSMaintenanceMethod() {
		return sMaintenanceMethod;
	}
	
	/**
	 * 设置 状态
	 * @param sMaintenanceMethod 状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setSMaintenanceMethod(String sMaintenanceMethod) {
		this.sMaintenanceMethod=sMaintenanceMethod;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUMaintenanceMethod() {
		return uMaintenanceMethod;
	}
	
	/**
	 * 设置 更新方式
	 * @param uMaintenanceMethod 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUMaintenanceMethod(String uMaintenanceMethod) {
		this.uMaintenanceMethod=uMaintenanceMethod;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUSMaintenanceMethod() {
		return uSMaintenanceMethod;
	}
	
	/**
	 * 设置 更新方式
	 * @param uSMaintenanceMethod 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUSMaintenanceMethod(String uSMaintenanceMethod) {
		this.uSMaintenanceMethod=uSMaintenanceMethod;
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
	public AssetMaintenanceRecordU setContactInformation(String contactInformation) {
		this.contactInformation=contactInformation;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getSContactInformation() {
		return sContactInformation;
	}
	
	/**
	 * 设置 状态
	 * @param sContactInformation 状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setSContactInformation(String sContactInformation) {
		this.sContactInformation=sContactInformation;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUContactInformation() {
		return uContactInformation;
	}
	
	/**
	 * 设置 更新方式
	 * @param uContactInformation 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUContactInformation(String uContactInformation) {
		this.uContactInformation=uContactInformation;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUSContactInformation() {
		return uSContactInformation;
	}
	
	/**
	 * 设置 更新方式
	 * @param uSContactInformation 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUSContactInformation(String uSContactInformation) {
		this.uSContactInformation=uSContactInformation;
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
	public AssetMaintenanceRecordU setSuggestMaintenanceMethod(String suggestMaintenanceMethod) {
		this.suggestMaintenanceMethod=suggestMaintenanceMethod;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getSSuggestMaintenanceMethod() {
		return sSuggestMaintenanceMethod;
	}
	
	/**
	 * 设置 状态
	 * @param sSuggestMaintenanceMethod 状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setSSuggestMaintenanceMethod(String sSuggestMaintenanceMethod) {
		this.sSuggestMaintenanceMethod=sSuggestMaintenanceMethod;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUSuggestMaintenanceMethod() {
		return uSuggestMaintenanceMethod;
	}
	
	/**
	 * 设置 更新方式
	 * @param uSuggestMaintenanceMethod 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUSuggestMaintenanceMethod(String uSuggestMaintenanceMethod) {
		this.uSuggestMaintenanceMethod=uSuggestMaintenanceMethod;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUSSuggestMaintenanceMethod() {
		return uSSuggestMaintenanceMethod;
	}
	
	/**
	 * 设置 更新方式
	 * @param uSSuggestMaintenanceMethod 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUSSuggestMaintenanceMethod(String uSSuggestMaintenanceMethod) {
		this.uSSuggestMaintenanceMethod=uSSuggestMaintenanceMethod;
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
	public AssetMaintenanceRecordU setContacts(String contacts) {
		this.contacts=contacts;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getSContacts() {
		return sContacts;
	}
	
	/**
	 * 设置 状态
	 * @param sContacts 状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setSContacts(String sContacts) {
		this.sContacts=sContacts;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUContacts() {
		return uContacts;
	}
	
	/**
	 * 设置 更新方式
	 * @param uContacts 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUContacts(String uContacts) {
		this.uContacts=uContacts;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUSContacts() {
		return uSContacts;
	}
	
	/**
	 * 设置 更新方式
	 * @param uSContacts 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUSContacts(String uSContacts) {
		this.uSContacts=uSContacts;
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
	public AssetMaintenanceRecordU setDirector(String director) {
		this.director=director;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getSDirector() {
		return sDirector;
	}
	
	/**
	 * 设置 状态
	 * @param sDirector 状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setSDirector(String sDirector) {
		this.sDirector=sDirector;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUDirector() {
		return uDirector;
	}
	
	/**
	 * 设置 更新方式
	 * @param uDirector 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUDirector(String uDirector) {
		this.uDirector=uDirector;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUSDirector() {
		return uSDirector;
	}
	
	/**
	 * 设置 更新方式
	 * @param uSDirector 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUSDirector(String uSDirector) {
		this.uSDirector=uSDirector;
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
	public AssetMaintenanceRecordU setMaintenanceStartDate(Date maintenanceStartDate) {
		this.maintenanceStartDate=maintenanceStartDate;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getSMaintenanceStartDate() {
		return sMaintenanceStartDate;
	}
	
	/**
	 * 设置 状态
	 * @param sMaintenanceStartDate 状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setSMaintenanceStartDate(String sMaintenanceStartDate) {
		this.sMaintenanceStartDate=sMaintenanceStartDate;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUMaintenanceStartDate() {
		return uMaintenanceStartDate;
	}
	
	/**
	 * 设置 更新方式
	 * @param uMaintenanceStartDate 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUMaintenanceStartDate(String uMaintenanceStartDate) {
		this.uMaintenanceStartDate=uMaintenanceStartDate;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUSMaintenanceStartDate() {
		return uSMaintenanceStartDate;
	}
	
	/**
	 * 设置 更新方式
	 * @param uSMaintenanceStartDate 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUSMaintenanceStartDate(String uSMaintenanceStartDate) {
		this.uSMaintenanceStartDate=uSMaintenanceStartDate;
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
	public AssetMaintenanceRecordU setMaintenanceEndDate(Date maintenanceEndDate) {
		this.maintenanceEndDate=maintenanceEndDate;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getSMaintenanceEndDate() {
		return sMaintenanceEndDate;
	}
	
	/**
	 * 设置 状态
	 * @param sMaintenanceEndDate 状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setSMaintenanceEndDate(String sMaintenanceEndDate) {
		this.sMaintenanceEndDate=sMaintenanceEndDate;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUMaintenanceEndDate() {
		return uMaintenanceEndDate;
	}
	
	/**
	 * 设置 更新方式
	 * @param uMaintenanceEndDate 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUMaintenanceEndDate(String uMaintenanceEndDate) {
		this.uMaintenanceEndDate=uMaintenanceEndDate;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUSMaintenanceEndDate() {
		return uSMaintenanceEndDate;
	}
	
	/**
	 * 设置 更新方式
	 * @param uSMaintenanceEndDate 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUSMaintenanceEndDate(String uSMaintenanceEndDate) {
		this.uSMaintenanceEndDate=uSMaintenanceEndDate;
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
	public AssetMaintenanceRecordU setMaintenanceNotes(String maintenanceNotes) {
		this.maintenanceNotes=maintenanceNotes;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getSMaintenanceNotes() {
		return sMaintenanceNotes;
	}
	
	/**
	 * 设置 状态
	 * @param sMaintenanceNotes 状态
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setSMaintenanceNotes(String sMaintenanceNotes) {
		this.sMaintenanceNotes=sMaintenanceNotes;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUMaintenanceNotes() {
		return uMaintenanceNotes;
	}
	
	/**
	 * 设置 更新方式
	 * @param uMaintenanceNotes 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUMaintenanceNotes(String uMaintenanceNotes) {
		this.uMaintenanceNotes=uMaintenanceNotes;
		return this;
	}
	
	/**
	 * 获得 更新方式<br>
	 * 更新方式
	 * @return 更新方式
	*/
	public String getUSMaintenanceNotes() {
		return uSMaintenanceNotes;
	}
	
	/**
	 * 设置 更新方式
	 * @param uSMaintenanceNotes 更新方式
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setUSMaintenanceNotes(String uSMaintenanceNotes) {
		this.uSMaintenanceNotes=uSMaintenanceNotes;
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
	public AssetMaintenanceRecordU setCreateBy(String createBy) {
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
	public AssetMaintenanceRecordU setCreateTime(Date createTime) {
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
	public AssetMaintenanceRecordU setUpdateBy(String updateBy) {
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
	public AssetMaintenanceRecordU setUpdateTime(Date updateTime) {
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
	public AssetMaintenanceRecordU setDeleted(Integer deleted) {
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
	public AssetMaintenanceRecordU setDeleted(Boolean deletedBool) {
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
	public AssetMaintenanceRecordU setDeleteBy(String deleteBy) {
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
	public AssetMaintenanceRecordU setDeleteTime(Date deleteTime) {
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
	public AssetMaintenanceRecordU setVersion(Integer version) {
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
	public AssetMaintenanceRecordU setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 recordIdList<br>
	 * recordIdList
	 * @return recordIdList
	*/
	public List<String> getRecordIdList() {
		return recordIdList;
	}
	
	/**
	 * 设置 recordIdList
	 * @param recordIdList recordIdList
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU setRecordIdList(List<String> recordIdList) {
		this.recordIdList=recordIdList;
		return this;
	}
	
	/**
	 * 添加 recordIdList
	 * @param recordId recordIdList
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordU addRecordId(String... recordId) {
		if(this.recordIdList==null) recordIdList=new ArrayList<>();
		this.recordIdList.addAll(Arrays.asList(recordId));
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
	public AssetMaintenanceRecordU setMaintnainer(Maintainer maintnainer) {
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
	public AssetMaintenanceRecordU setAssetMaintenanceStatus(DictItem assetMaintenanceStatus) {
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
	public AssetMaintenanceRecordU setSuggestMaintenanceMethodData(DictItem suggestMaintenanceMethodData) {
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
	public AssetMaintenanceRecordU setMaintenanceMethodData(DictItem maintenanceMethodData) {
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
	public AssetMaintenanceRecordU setAssetMaintenanceUpdate(AssetMaintenanceUpdate assetMaintenanceUpdate) {
		this.assetMaintenanceUpdate=assetMaintenanceUpdate;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetMaintenanceRecordU , 转换好的 AssetMaintenanceRecordU 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetMaintenanceRecordU , 转换好的 PoJo 对象
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
	public AssetMaintenanceRecordU clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetMaintenanceRecordU duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetMaintenanceRecordUMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetMaintenanceRecordUMeta.$$proxy$$();
		inst.setUContactInformation(this.getUContactInformation());
		inst.setUMaintenanceMethod(this.getUMaintenanceMethod());
		inst.setUSuggestMaintenanceMethod(this.getUSuggestMaintenanceMethod());
		inst.setMaintenanceStatus(this.getMaintenanceStatus());
		inst.setMaintenanceEndDate(this.getMaintenanceEndDate());
		inst.setUMaintenanceStatus(this.getUMaintenanceStatus());
		inst.setId(this.getId());
		inst.setSMaintenanceMethod(this.getSMaintenanceMethod());
		inst.setUSContactInformation(this.getUSContactInformation());
		inst.setUMaintenanceStartDate(this.getUMaintenanceStartDate());
		inst.setSContacts(this.getSContacts());
		inst.setSSuggestMaintenanceMethod(this.getSSuggestMaintenanceMethod());
		inst.setSMaintainerName(this.getSMaintainerName());
		inst.setUContacts(this.getUContacts());
		inst.setDirector(this.getDirector());
		inst.setUSMaintenanceMethod(this.getUSMaintenanceMethod());
		inst.setVersion(this.getVersion());
		inst.setMaintainerId(this.getMaintainerId());
		inst.setMaintenanceNotes(this.getMaintenanceNotes());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setMaintenanceMethod(this.getMaintenanceMethod());
		inst.setUSContacts(this.getUSContacts());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setSMaintenanceEndDate(this.getSMaintenanceEndDate());
		inst.setUMaintenanceNotes(this.getUMaintenanceNotes());
		inst.setUSMaintenanceEndDate(this.getUSMaintenanceEndDate());
		inst.setUSMaintainerName(this.getUSMaintainerName());
		inst.setUMaintenanceEndDate(this.getUMaintenanceEndDate());
		inst.setSMaintenanceStartDate(this.getSMaintenanceStartDate());
		inst.setSContactInformation(this.getSContactInformation());
		inst.setUSMaintenanceNotes(this.getUSMaintenanceNotes());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setSuggestMaintenanceMethod(this.getSuggestMaintenanceMethod());
		inst.setUSMaintenanceStartDate(this.getUSMaintenanceStartDate());
		inst.setMaintainerName(this.getMaintainerName());
		inst.setSDirector(this.getSDirector());
		inst.setUSMaintenanceStatus(this.getUSMaintenanceStatus());
		inst.setUMaintainerId(this.getUMaintainerId());
		inst.setUDirector(this.getUDirector());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSMaintainerId(this.getSMaintainerId());
		inst.setSMaintenanceNotes(this.getSMaintenanceNotes());
		inst.setUSDirector(this.getUSDirector());
		inst.setSMaintenanceStatus(this.getSMaintenanceStatus());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setDeleted(this.getDeleted());
		inst.setUSMaintainerId(this.getUSMaintainerId());
		inst.setCreateTime(this.getCreateTime());
		inst.setMaintenanceUpdateId(this.getMaintenanceUpdateId());
		inst.setTenantId(this.getTenantId());
		inst.setMaintenanceStartDate(this.getMaintenanceStartDate());
		inst.setContacts(this.getContacts());
		inst.setUMaintainerName(this.getUMaintainerName());
		inst.setUSSuggestMaintenanceMethod(this.getUSSuggestMaintenanceMethod());
		if(all) {
			inst.setSuggestMaintenanceMethodData(this.getSuggestMaintenanceMethodData());
			inst.setMaintnainer(this.getMaintnainer());
			inst.setAssetMaintenanceStatus(this.getAssetMaintenanceStatus());
			inst.setAssetMaintenanceUpdate(this.getAssetMaintenanceUpdate());
			inst.setMaintenanceMethodData(this.getMaintenanceMethodData());
			inst.setRecordIdList(this.getRecordIdList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetMaintenanceRecordU clone(boolean deep) {
		return EntityContext.clone(AssetMaintenanceRecordU.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetMaintenanceRecordU
	 * @param assetMaintenanceRecordUMap 包含实体信息的 Map 对象
	 * @return AssetMaintenanceRecordU , 转换好的的 AssetMaintenanceRecordU 对象
	*/
	@Transient
	public static AssetMaintenanceRecordU createFrom(Map<String,Object> assetMaintenanceRecordUMap) {
		if(assetMaintenanceRecordUMap==null) return null;
		AssetMaintenanceRecordU po = create();
		EntityContext.copyProperties(po,assetMaintenanceRecordUMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetMaintenanceRecordU
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetMaintenanceRecordU , 转换好的的 AssetMaintenanceRecordU 对象
	*/
	@Transient
	public static AssetMaintenanceRecordU createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetMaintenanceRecordU po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetMaintenanceRecordU，等同于 new
	 * @return AssetMaintenanceRecordU 对象
	*/
	@Transient
	public static AssetMaintenanceRecordU create() {
		return new com.dt.platform.domain.eam.meta.AssetMaintenanceRecordUMeta.$$proxy$$();
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
			this.setUContactInformation(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_CONTACT_INFORMATION)));
			this.setUMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_MAINTENANCE_METHOD)));
			this.setUSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_SUGGEST_MAINTENANCE_METHOD)));
			this.setMaintenanceStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_STATUS)));
			this.setMaintenanceEndDate(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_END_DATE)));
			this.setUMaintenanceStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_MAINTENANCE_STATUS)));
			this.setId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.ID)));
			this.setSMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.S_MAINTENANCE_METHOD)));
			this.setUSContactInformation(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_S_CONTACT_INFORMATION)));
			this.setUMaintenanceStartDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_MAINTENANCE_START_DATE)));
			this.setSContacts(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.S_CONTACTS)));
			this.setSSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.S_SUGGEST_MAINTENANCE_METHOD)));
			this.setSMaintainerName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.S_MAINTAINER_NAME)));
			this.setUContacts(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_CONTACTS)));
			this.setDirector(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.DIRECTOR)));
			this.setUSMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_METHOD)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetMaintenanceRecordUMeta.VERSION)));
			this.setMaintainerId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.MAINTAINER_ID)));
			this.setMaintenanceNotes(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_NOTES)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordUMeta.DELETE_TIME)));
			this.setMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_METHOD)));
			this.setUSContacts(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_S_CONTACTS)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.DELETE_BY)));
			this.setSMaintenanceEndDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.S_MAINTENANCE_END_DATE)));
			this.setUMaintenanceNotes(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_MAINTENANCE_NOTES)));
			this.setUSMaintenanceEndDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_END_DATE)));
			this.setUSMaintainerName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_S_MAINTAINER_NAME)));
			this.setUMaintenanceEndDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_MAINTENANCE_END_DATE)));
			this.setSMaintenanceStartDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.S_MAINTENANCE_START_DATE)));
			this.setSContactInformation(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.S_CONTACT_INFORMATION)));
			this.setUSMaintenanceNotes(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_NOTES)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.UPDATE_BY)));
			this.setSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.SUGGEST_MAINTENANCE_METHOD)));
			this.setUSMaintenanceStartDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_START_DATE)));
			this.setMaintainerName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.MAINTAINER_NAME)));
			this.setSDirector(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.S_DIRECTOR)));
			this.setUSMaintenanceStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_STATUS)));
			this.setUMaintainerId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_MAINTAINER_ID)));
			this.setUDirector(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_DIRECTOR)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordUMeta.UPDATE_TIME)));
			this.setSMaintainerId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.S_MAINTAINER_ID)));
			this.setSMaintenanceNotes(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.S_MAINTENANCE_NOTES)));
			this.setUSDirector(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_S_DIRECTOR)));
			this.setSMaintenanceStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.S_MAINTENANCE_STATUS)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetMaintenanceRecordUMeta.DELETED)));
			this.setUSMaintainerId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_S_MAINTAINER_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordUMeta.CREATE_TIME)));
			this.setMaintenanceUpdateId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_UPDATE_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.TENANT_ID)));
			this.setMaintenanceStartDate(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_START_DATE)));
			this.setContacts(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.CONTACTS)));
			this.setUMaintainerName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_MAINTAINER_NAME)));
			this.setUSSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUMeta.U_S_SUGGEST_MAINTENANCE_METHOD)));
			// others
			this.setSuggestMaintenanceMethodData(DataParser.parse(DictItem.class, map.get(AssetMaintenanceRecordUMeta.SUGGEST_MAINTENANCE_METHOD_DATA)));
			this.setMaintnainer(DataParser.parse(Maintainer.class, map.get(AssetMaintenanceRecordUMeta.MAINTNAINER)));
			this.setAssetMaintenanceStatus(DataParser.parse(DictItem.class, map.get(AssetMaintenanceRecordUMeta.ASSET_MAINTENANCE_STATUS)));
			this.setAssetMaintenanceUpdate(DataParser.parse(AssetMaintenanceUpdate.class, map.get(AssetMaintenanceRecordUMeta.ASSET_MAINTENANCE_UPDATE)));
			this.setMaintenanceMethodData(DataParser.parse(DictItem.class, map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_METHOD_DATA)));
			return true;
		} else {
			try {
				this.setUContactInformation( (String)map.get(AssetMaintenanceRecordUMeta.U_CONTACT_INFORMATION));
				this.setUMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUMeta.U_MAINTENANCE_METHOD));
				this.setUSuggestMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUMeta.U_SUGGEST_MAINTENANCE_METHOD));
				this.setMaintenanceStatus( (String)map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_STATUS));
				this.setMaintenanceEndDate( (Date)map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_END_DATE));
				this.setUMaintenanceStatus( (String)map.get(AssetMaintenanceRecordUMeta.U_MAINTENANCE_STATUS));
				this.setId( (String)map.get(AssetMaintenanceRecordUMeta.ID));
				this.setSMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUMeta.S_MAINTENANCE_METHOD));
				this.setUSContactInformation( (String)map.get(AssetMaintenanceRecordUMeta.U_S_CONTACT_INFORMATION));
				this.setUMaintenanceStartDate( (String)map.get(AssetMaintenanceRecordUMeta.U_MAINTENANCE_START_DATE));
				this.setSContacts( (String)map.get(AssetMaintenanceRecordUMeta.S_CONTACTS));
				this.setSSuggestMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUMeta.S_SUGGEST_MAINTENANCE_METHOD));
				this.setSMaintainerName( (String)map.get(AssetMaintenanceRecordUMeta.S_MAINTAINER_NAME));
				this.setUContacts( (String)map.get(AssetMaintenanceRecordUMeta.U_CONTACTS));
				this.setDirector( (String)map.get(AssetMaintenanceRecordUMeta.DIRECTOR));
				this.setUSMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_METHOD));
				this.setVersion( (Integer)map.get(AssetMaintenanceRecordUMeta.VERSION));
				this.setMaintainerId( (String)map.get(AssetMaintenanceRecordUMeta.MAINTAINER_ID));
				this.setMaintenanceNotes( (String)map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_NOTES));
				this.setDeleteTime( (Date)map.get(AssetMaintenanceRecordUMeta.DELETE_TIME));
				this.setMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_METHOD));
				this.setUSContacts( (String)map.get(AssetMaintenanceRecordUMeta.U_S_CONTACTS));
				this.setDeleteBy( (String)map.get(AssetMaintenanceRecordUMeta.DELETE_BY));
				this.setSMaintenanceEndDate( (String)map.get(AssetMaintenanceRecordUMeta.S_MAINTENANCE_END_DATE));
				this.setUMaintenanceNotes( (String)map.get(AssetMaintenanceRecordUMeta.U_MAINTENANCE_NOTES));
				this.setUSMaintenanceEndDate( (String)map.get(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_END_DATE));
				this.setUSMaintainerName( (String)map.get(AssetMaintenanceRecordUMeta.U_S_MAINTAINER_NAME));
				this.setUMaintenanceEndDate( (String)map.get(AssetMaintenanceRecordUMeta.U_MAINTENANCE_END_DATE));
				this.setSMaintenanceStartDate( (String)map.get(AssetMaintenanceRecordUMeta.S_MAINTENANCE_START_DATE));
				this.setSContactInformation( (String)map.get(AssetMaintenanceRecordUMeta.S_CONTACT_INFORMATION));
				this.setUSMaintenanceNotes( (String)map.get(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_NOTES));
				this.setUpdateBy( (String)map.get(AssetMaintenanceRecordUMeta.UPDATE_BY));
				this.setSuggestMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUMeta.SUGGEST_MAINTENANCE_METHOD));
				this.setUSMaintenanceStartDate( (String)map.get(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_START_DATE));
				this.setMaintainerName( (String)map.get(AssetMaintenanceRecordUMeta.MAINTAINER_NAME));
				this.setSDirector( (String)map.get(AssetMaintenanceRecordUMeta.S_DIRECTOR));
				this.setUSMaintenanceStatus( (String)map.get(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_STATUS));
				this.setUMaintainerId( (String)map.get(AssetMaintenanceRecordUMeta.U_MAINTAINER_ID));
				this.setUDirector( (String)map.get(AssetMaintenanceRecordUMeta.U_DIRECTOR));
				this.setUpdateTime( (Date)map.get(AssetMaintenanceRecordUMeta.UPDATE_TIME));
				this.setSMaintainerId( (String)map.get(AssetMaintenanceRecordUMeta.S_MAINTAINER_ID));
				this.setSMaintenanceNotes( (String)map.get(AssetMaintenanceRecordUMeta.S_MAINTENANCE_NOTES));
				this.setUSDirector( (String)map.get(AssetMaintenanceRecordUMeta.U_S_DIRECTOR));
				this.setSMaintenanceStatus( (String)map.get(AssetMaintenanceRecordUMeta.S_MAINTENANCE_STATUS));
				this.setCreateBy( (String)map.get(AssetMaintenanceRecordUMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(AssetMaintenanceRecordUMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)map.get(AssetMaintenanceRecordUMeta.DELETED));
				this.setUSMaintainerId( (String)map.get(AssetMaintenanceRecordUMeta.U_S_MAINTAINER_ID));
				this.setCreateTime( (Date)map.get(AssetMaintenanceRecordUMeta.CREATE_TIME));
				this.setMaintenanceUpdateId( (String)map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_UPDATE_ID));
				this.setTenantId( (String)map.get(AssetMaintenanceRecordUMeta.TENANT_ID));
				this.setMaintenanceStartDate( (Date)map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_START_DATE));
				this.setContacts( (String)map.get(AssetMaintenanceRecordUMeta.CONTACTS));
				this.setUMaintainerName( (String)map.get(AssetMaintenanceRecordUMeta.U_MAINTAINER_NAME));
				this.setUSSuggestMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUMeta.U_S_SUGGEST_MAINTENANCE_METHOD));
				// others
				this.setSuggestMaintenanceMethodData( (DictItem)map.get(AssetMaintenanceRecordUMeta.SUGGEST_MAINTENANCE_METHOD_DATA));
				this.setMaintnainer( (Maintainer)map.get(AssetMaintenanceRecordUMeta.MAINTNAINER));
				this.setAssetMaintenanceStatus( (DictItem)map.get(AssetMaintenanceRecordUMeta.ASSET_MAINTENANCE_STATUS));
				this.setAssetMaintenanceUpdate( (AssetMaintenanceUpdate)map.get(AssetMaintenanceRecordUMeta.ASSET_MAINTENANCE_UPDATE));
				this.setMaintenanceMethodData( (DictItem)map.get(AssetMaintenanceRecordUMeta.MAINTENANCE_METHOD_DATA));
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
			this.setUContactInformation(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_CONTACT_INFORMATION)));
			this.setUMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_MAINTENANCE_METHOD)));
			this.setUSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_SUGGEST_MAINTENANCE_METHOD)));
			this.setMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.MAINTENANCE_STATUS)));
			this.setMaintenanceEndDate(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordUMeta.MAINTENANCE_END_DATE)));
			this.setUMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_MAINTENANCE_STATUS)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.ID)));
			this.setSMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.S_MAINTENANCE_METHOD)));
			this.setUSContactInformation(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_S_CONTACT_INFORMATION)));
			this.setUMaintenanceStartDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_MAINTENANCE_START_DATE)));
			this.setSContacts(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.S_CONTACTS)));
			this.setSSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.S_SUGGEST_MAINTENANCE_METHOD)));
			this.setSMaintainerName(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.S_MAINTAINER_NAME)));
			this.setUContacts(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_CONTACTS)));
			this.setDirector(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.DIRECTOR)));
			this.setUSMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_METHOD)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetMaintenanceRecordUMeta.VERSION)));
			this.setMaintainerId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.MAINTAINER_ID)));
			this.setMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.MAINTENANCE_NOTES)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordUMeta.DELETE_TIME)));
			this.setMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.MAINTENANCE_METHOD)));
			this.setUSContacts(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_S_CONTACTS)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.DELETE_BY)));
			this.setSMaintenanceEndDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.S_MAINTENANCE_END_DATE)));
			this.setUMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_MAINTENANCE_NOTES)));
			this.setUSMaintenanceEndDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_END_DATE)));
			this.setUSMaintainerName(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTAINER_NAME)));
			this.setUMaintenanceEndDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_MAINTENANCE_END_DATE)));
			this.setSMaintenanceStartDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.S_MAINTENANCE_START_DATE)));
			this.setSContactInformation(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.S_CONTACT_INFORMATION)));
			this.setUSMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_NOTES)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.UPDATE_BY)));
			this.setSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.SUGGEST_MAINTENANCE_METHOD)));
			this.setUSMaintenanceStartDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_START_DATE)));
			this.setMaintainerName(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.MAINTAINER_NAME)));
			this.setSDirector(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.S_DIRECTOR)));
			this.setUSMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_STATUS)));
			this.setUMaintainerId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_MAINTAINER_ID)));
			this.setUDirector(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_DIRECTOR)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordUMeta.UPDATE_TIME)));
			this.setSMaintainerId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.S_MAINTAINER_ID)));
			this.setSMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.S_MAINTENANCE_NOTES)));
			this.setUSDirector(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_S_DIRECTOR)));
			this.setSMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.S_MAINTENANCE_STATUS)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetMaintenanceRecordUMeta.DELETED)));
			this.setUSMaintainerId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTAINER_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordUMeta.CREATE_TIME)));
			this.setMaintenanceUpdateId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.MAINTENANCE_UPDATE_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.TENANT_ID)));
			this.setMaintenanceStartDate(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordUMeta.MAINTENANCE_START_DATE)));
			this.setContacts(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.CONTACTS)));
			this.setUMaintainerName(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_MAINTAINER_NAME)));
			this.setUSSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUMeta.U_S_SUGGEST_MAINTENANCE_METHOD)));
			return true;
		} else {
			try {
				this.setUContactInformation( (String)r.getValue(AssetMaintenanceRecordUMeta.U_CONTACT_INFORMATION));
				this.setUMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUMeta.U_MAINTENANCE_METHOD));
				this.setUSuggestMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUMeta.U_SUGGEST_MAINTENANCE_METHOD));
				this.setMaintenanceStatus( (String)r.getValue(AssetMaintenanceRecordUMeta.MAINTENANCE_STATUS));
				this.setMaintenanceEndDate( (Date)r.getValue(AssetMaintenanceRecordUMeta.MAINTENANCE_END_DATE));
				this.setUMaintenanceStatus( (String)r.getValue(AssetMaintenanceRecordUMeta.U_MAINTENANCE_STATUS));
				this.setId( (String)r.getValue(AssetMaintenanceRecordUMeta.ID));
				this.setSMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUMeta.S_MAINTENANCE_METHOD));
				this.setUSContactInformation( (String)r.getValue(AssetMaintenanceRecordUMeta.U_S_CONTACT_INFORMATION));
				this.setUMaintenanceStartDate( (String)r.getValue(AssetMaintenanceRecordUMeta.U_MAINTENANCE_START_DATE));
				this.setSContacts( (String)r.getValue(AssetMaintenanceRecordUMeta.S_CONTACTS));
				this.setSSuggestMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUMeta.S_SUGGEST_MAINTENANCE_METHOD));
				this.setSMaintainerName( (String)r.getValue(AssetMaintenanceRecordUMeta.S_MAINTAINER_NAME));
				this.setUContacts( (String)r.getValue(AssetMaintenanceRecordUMeta.U_CONTACTS));
				this.setDirector( (String)r.getValue(AssetMaintenanceRecordUMeta.DIRECTOR));
				this.setUSMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_METHOD));
				this.setVersion( (Integer)r.getValue(AssetMaintenanceRecordUMeta.VERSION));
				this.setMaintainerId( (String)r.getValue(AssetMaintenanceRecordUMeta.MAINTAINER_ID));
				this.setMaintenanceNotes( (String)r.getValue(AssetMaintenanceRecordUMeta.MAINTENANCE_NOTES));
				this.setDeleteTime( (Date)r.getValue(AssetMaintenanceRecordUMeta.DELETE_TIME));
				this.setMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUMeta.MAINTENANCE_METHOD));
				this.setUSContacts( (String)r.getValue(AssetMaintenanceRecordUMeta.U_S_CONTACTS));
				this.setDeleteBy( (String)r.getValue(AssetMaintenanceRecordUMeta.DELETE_BY));
				this.setSMaintenanceEndDate( (String)r.getValue(AssetMaintenanceRecordUMeta.S_MAINTENANCE_END_DATE));
				this.setUMaintenanceNotes( (String)r.getValue(AssetMaintenanceRecordUMeta.U_MAINTENANCE_NOTES));
				this.setUSMaintenanceEndDate( (String)r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_END_DATE));
				this.setUSMaintainerName( (String)r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTAINER_NAME));
				this.setUMaintenanceEndDate( (String)r.getValue(AssetMaintenanceRecordUMeta.U_MAINTENANCE_END_DATE));
				this.setSMaintenanceStartDate( (String)r.getValue(AssetMaintenanceRecordUMeta.S_MAINTENANCE_START_DATE));
				this.setSContactInformation( (String)r.getValue(AssetMaintenanceRecordUMeta.S_CONTACT_INFORMATION));
				this.setUSMaintenanceNotes( (String)r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_NOTES));
				this.setUpdateBy( (String)r.getValue(AssetMaintenanceRecordUMeta.UPDATE_BY));
				this.setSuggestMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUMeta.SUGGEST_MAINTENANCE_METHOD));
				this.setUSMaintenanceStartDate( (String)r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_START_DATE));
				this.setMaintainerName( (String)r.getValue(AssetMaintenanceRecordUMeta.MAINTAINER_NAME));
				this.setSDirector( (String)r.getValue(AssetMaintenanceRecordUMeta.S_DIRECTOR));
				this.setUSMaintenanceStatus( (String)r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTENANCE_STATUS));
				this.setUMaintainerId( (String)r.getValue(AssetMaintenanceRecordUMeta.U_MAINTAINER_ID));
				this.setUDirector( (String)r.getValue(AssetMaintenanceRecordUMeta.U_DIRECTOR));
				this.setUpdateTime( (Date)r.getValue(AssetMaintenanceRecordUMeta.UPDATE_TIME));
				this.setSMaintainerId( (String)r.getValue(AssetMaintenanceRecordUMeta.S_MAINTAINER_ID));
				this.setSMaintenanceNotes( (String)r.getValue(AssetMaintenanceRecordUMeta.S_MAINTENANCE_NOTES));
				this.setUSDirector( (String)r.getValue(AssetMaintenanceRecordUMeta.U_S_DIRECTOR));
				this.setSMaintenanceStatus( (String)r.getValue(AssetMaintenanceRecordUMeta.S_MAINTENANCE_STATUS));
				this.setCreateBy( (String)r.getValue(AssetMaintenanceRecordUMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(AssetMaintenanceRecordUMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)r.getValue(AssetMaintenanceRecordUMeta.DELETED));
				this.setUSMaintainerId( (String)r.getValue(AssetMaintenanceRecordUMeta.U_S_MAINTAINER_ID));
				this.setCreateTime( (Date)r.getValue(AssetMaintenanceRecordUMeta.CREATE_TIME));
				this.setMaintenanceUpdateId( (String)r.getValue(AssetMaintenanceRecordUMeta.MAINTENANCE_UPDATE_ID));
				this.setTenantId( (String)r.getValue(AssetMaintenanceRecordUMeta.TENANT_ID));
				this.setMaintenanceStartDate( (Date)r.getValue(AssetMaintenanceRecordUMeta.MAINTENANCE_START_DATE));
				this.setContacts( (String)r.getValue(AssetMaintenanceRecordUMeta.CONTACTS));
				this.setUMaintainerName( (String)r.getValue(AssetMaintenanceRecordUMeta.U_MAINTAINER_NAME));
				this.setUSSuggestMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUMeta.U_S_SUGGEST_MAINTENANCE_METHOD));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}