package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_DEPRECIATION_OPER;
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
import com.dt.platform.domain.eam.meta.AssetDepreciationOperMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 折旧操作
 * <p>折旧操作 , 数据表 eam_asset_depreciation_oper 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-27 09:07:59
 * @sign D8F7E05FD96565D17257D8CF6C2BBC00
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_depreciation_oper")
@ApiModel(description = "折旧操作 ; 折旧操作 , 数据表 eam_asset_depreciation_oper 的PO类型")
public class AssetDepreciationOper extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_DEPRECIATION_OPER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "648530956168200192")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "AD202211251411115")
	private String businessCode;
	
	/**
	 * 折旧编码：折旧编码
	*/
	@ApiModelProperty(required = false,value="折旧编码" , notes = "折旧编码" , example = "monthly")
	private String depreciationCode;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "complete")
	private String status;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "测试")
	private String name;
	
	/**
	 * 折旧方案：折旧方案
	*/
	@ApiModelProperty(required = false,value="折旧方案" , notes = "折旧方案" , example = "647736203386290176")
	private String depreciationId;
	
	/**
	 * 折旧内容：折旧内容
	*/
	@ApiModelProperty(required = false,value="折旧内容" , notes = "折旧内容" , example = "121212")
	private String content;
	
	/**
	 * 业务日期：业务日期
	*/
	@ApiModelProperty(required = false,value="业务日期" , notes = "业务日期" , example = "2022-11-25 12:00:00")
	private Date businessDate;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间")
	private Date executionStartTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间" , example = "2022-11-26 09:34:30")
	private Date executionEndTime;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人" , example = "E001")
	private String originatorId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-11-25 02:30:29")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-11-26 09:34:30")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "20")
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
	private List<Asset> assetSourceList;
	
	/**
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<String> assetSourceIds;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private List<Asset> assetTargetList;
	
	/**
	 * 资产列表：资产列表
	*/
	@ApiModelProperty(required = false,value="资产列表" , notes = "资产列表")
	private List<String> assetTargetIds;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private List<AssetDepreciationDetail> assetDepreciationList;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private List<String> assetDepreciationIds;
	
	/**
	 * 方案：方案
	*/
	@ApiModelProperty(required = false,value="方案" , notes = "方案")
	private AssetDepreciation assetDepreciation;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
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
	public AssetDepreciationOper setId(String id) {
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
	public AssetDepreciationOper setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 折旧编码<br>
	 * 折旧编码
	 * @return 折旧编码
	*/
	public String getDepreciationCode() {
		return depreciationCode;
	}
	
	/**
	 * 设置 折旧编码
	 * @param depreciationCode 折旧编码
	 * @return 当前对象
	*/
	public AssetDepreciationOper setDepreciationCode(String depreciationCode) {
		this.depreciationCode=depreciationCode;
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
	public AssetDepreciationOper setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public AssetDepreciationOper setName(String name) {
		this.name=name;
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
	public AssetDepreciationOper setDepreciationId(String depreciationId) {
		this.depreciationId=depreciationId;
		return this;
	}
	
	/**
	 * 获得 折旧内容<br>
	 * 折旧内容
	 * @return 折旧内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 折旧内容
	 * @param content 折旧内容
	 * @return 当前对象
	*/
	public AssetDepreciationOper setContent(String content) {
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
	public AssetDepreciationOper setBusinessDate(Date businessDate) {
		this.businessDate=businessDate;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getExecutionStartTime() {
		return executionStartTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param executionStartTime 开始时间
	 * @return 当前对象
	*/
	public AssetDepreciationOper setExecutionStartTime(Date executionStartTime) {
		this.executionStartTime=executionStartTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getExecutionEndTime() {
		return executionEndTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param executionEndTime 结束时间
	 * @return 当前对象
	*/
	public AssetDepreciationOper setExecutionEndTime(Date executionEndTime) {
		this.executionEndTime=executionEndTime;
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
	public AssetDepreciationOper setNotes(String notes) {
		this.notes=notes;
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
	public AssetDepreciationOper setOriginatorId(String originatorId) {
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
	public AssetDepreciationOper setCreateBy(String createBy) {
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
	public AssetDepreciationOper setCreateTime(Date createTime) {
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
	public AssetDepreciationOper setUpdateBy(String updateBy) {
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
	public AssetDepreciationOper setUpdateTime(Date updateTime) {
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
	public AssetDepreciationOper setDeleted(Integer deleted) {
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
	public AssetDepreciationOper setDeleted(Boolean deletedBool) {
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
	public AssetDepreciationOper setDeleteBy(String deleteBy) {
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
	public AssetDepreciationOper setDeleteTime(Date deleteTime) {
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
	public AssetDepreciationOper setVersion(Integer version) {
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
	public AssetDepreciationOper setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<Asset> getAssetSourceList() {
		return assetSourceList;
	}
	
	/**
	 * 设置 资产
	 * @param assetSourceList 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper setAssetSourceList(List<Asset> assetSourceList) {
		this.assetSourceList=assetSourceList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param assetSource 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper addAssetSource(Asset... assetSource) {
		if(this.assetSourceList==null) assetSourceList=new ArrayList<>();
		this.assetSourceList.addAll(Arrays.asList(assetSource));
		return this;
	}
	
	/**
	 * 获得 资产列表<br>
	 * 资产列表
	 * @return 资产列表
	*/
	public List<String> getAssetSourceIds() {
		return assetSourceIds;
	}
	
	/**
	 * 设置 资产列表
	 * @param assetSourceIds 资产列表
	 * @return 当前对象
	*/
	public AssetDepreciationOper setAssetSourceIds(List<String> assetSourceIds) {
		this.assetSourceIds=assetSourceIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetSourceId 资产列表
	 * @return 当前对象
	*/
	public AssetDepreciationOper addAssetSourceId(String... assetSourceId) {
		if(this.assetSourceIds==null) assetSourceIds=new ArrayList<>();
		this.assetSourceIds.addAll(Arrays.asList(assetSourceId));
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<Asset> getAssetTargetList() {
		return assetTargetList;
	}
	
	/**
	 * 设置 资产
	 * @param assetTargetList 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper setAssetTargetList(List<Asset> assetTargetList) {
		this.assetTargetList=assetTargetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param assetTarget 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper addAssetTarget(Asset... assetTarget) {
		if(this.assetTargetList==null) assetTargetList=new ArrayList<>();
		this.assetTargetList.addAll(Arrays.asList(assetTarget));
		return this;
	}
	
	/**
	 * 获得 资产列表<br>
	 * 资产列表
	 * @return 资产列表
	*/
	public List<String> getAssetTargetIds() {
		return assetTargetIds;
	}
	
	/**
	 * 设置 资产列表
	 * @param assetTargetIds 资产列表
	 * @return 当前对象
	*/
	public AssetDepreciationOper setAssetTargetIds(List<String> assetTargetIds) {
		this.assetTargetIds=assetTargetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetTargetId 资产列表
	 * @return 当前对象
	*/
	public AssetDepreciationOper addAssetTargetId(String... assetTargetId) {
		if(this.assetTargetIds==null) assetTargetIds=new ArrayList<>();
		this.assetTargetIds.addAll(Arrays.asList(assetTargetId));
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<AssetDepreciationDetail> getAssetDepreciationList() {
		return assetDepreciationList;
	}
	
	/**
	 * 设置 资产
	 * @param assetDepreciationList 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper setAssetDepreciationList(List<AssetDepreciationDetail> assetDepreciationList) {
		this.assetDepreciationList=assetDepreciationList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param assetDepreciation 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper addAssetDepreciation(AssetDepreciationDetail... assetDepreciation) {
		if(this.assetDepreciationList==null) assetDepreciationList=new ArrayList<>();
		this.assetDepreciationList.addAll(Arrays.asList(assetDepreciation));
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public List<String> getAssetDepreciationIds() {
		return assetDepreciationIds;
	}
	
	/**
	 * 设置 资产
	 * @param assetDepreciationIds 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper setAssetDepreciationIds(List<String> assetDepreciationIds) {
		this.assetDepreciationIds=assetDepreciationIds;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param assetDepreciationId 资产
	 * @return 当前对象
	*/
	public AssetDepreciationOper addAssetDepreciationId(String... assetDepreciationId) {
		if(this.assetDepreciationIds==null) assetDepreciationIds=new ArrayList<>();
		this.assetDepreciationIds.addAll(Arrays.asList(assetDepreciationId));
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
	public AssetDepreciationOper setAssetDepreciation(AssetDepreciation assetDepreciation) {
		this.assetDepreciation=assetDepreciation;
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
	public AssetDepreciationOper setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetDepreciationOper , 转换好的 AssetDepreciationOper 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDepreciationOper , 转换好的 PoJo 对象
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
	public AssetDepreciationOper clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetDepreciationOper duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetDepreciationOperMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetDepreciationOperMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setDepreciationCode(this.getDepreciationCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setExecutionEndTime(this.getExecutionEndTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setDepreciationId(this.getDepreciationId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setExecutionStartTime(this.getExecutionStartTime());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setAssetSourceIds(this.getAssetSourceIds());
			inst.setAssetDepreciationIds(this.getAssetDepreciationIds());
			inst.setAssetTargetList(this.getAssetTargetList());
			inst.setAssetDepreciationList(this.getAssetDepreciationList());
			inst.setOriginator(this.getOriginator());
			inst.setAssetTargetIds(this.getAssetTargetIds());
			inst.setAssetDepreciation(this.getAssetDepreciation());
			inst.setAssetSourceList(this.getAssetSourceList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetDepreciationOper clone(boolean deep) {
		return EntityContext.clone(AssetDepreciationOper.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetDepreciationOper
	 * @param assetDepreciationOperMap 包含实体信息的 Map 对象
	 * @return AssetDepreciationOper , 转换好的的 AssetDepreciationOper 对象
	*/
	@Transient
	public static AssetDepreciationOper createFrom(Map<String,Object> assetDepreciationOperMap) {
		if(assetDepreciationOperMap==null) return null;
		AssetDepreciationOper po = create();
		EntityContext.copyProperties(po,assetDepreciationOperMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetDepreciationOper
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDepreciationOper , 转换好的的 AssetDepreciationOper 对象
	*/
	@Transient
	public static AssetDepreciationOper createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDepreciationOper po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetDepreciationOper，等同于 new
	 * @return AssetDepreciationOper 对象
	*/
	@Transient
	public static AssetDepreciationOper create() {
		return new com.dt.platform.domain.eam.meta.AssetDepreciationOperMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssetDepreciationOperMeta.NOTES)));
			this.setDepreciationCode(DataParser.parse(String.class, map.get(AssetDepreciationOperMeta.DEPRECIATION_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetDepreciationOperMeta.UPDATE_TIME)));
			this.setExecutionEndTime(DataParser.parse(Date.class, map.get(AssetDepreciationOperMeta.EXECUTION_END_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetDepreciationOperMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(AssetDepreciationOperMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetDepreciationOperMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetDepreciationOperMeta.BUSINESS_CODE)));
			this.setDepreciationId(DataParser.parse(String.class, map.get(AssetDepreciationOperMeta.DEPRECIATION_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetDepreciationOperMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetDepreciationOperMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetDepreciationOperMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetDepreciationOperMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetDepreciationOperMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetDepreciationOperMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetDepreciationOperMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetDepreciationOperMeta.DELETE_BY)));
			this.setExecutionStartTime(DataParser.parse(Date.class, map.get(AssetDepreciationOperMeta.EXECUTION_START_TIME)));
			this.setId(DataParser.parse(String.class, map.get(AssetDepreciationOperMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetDepreciationOperMeta.ORIGINATOR_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetDepreciationOperMeta.STATUS)));
			// others
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetDepreciationOperMeta.ORIGINATOR)));
			this.setAssetDepreciation(DataParser.parse(AssetDepreciation.class, map.get(AssetDepreciationOperMeta.ASSET_DEPRECIATION)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssetDepreciationOperMeta.NOTES));
				this.setDepreciationCode( (String)map.get(AssetDepreciationOperMeta.DEPRECIATION_CODE));
				this.setUpdateTime( (Date)map.get(AssetDepreciationOperMeta.UPDATE_TIME));
				this.setExecutionEndTime( (Date)map.get(AssetDepreciationOperMeta.EXECUTION_END_TIME));
				this.setVersion( (Integer)map.get(AssetDepreciationOperMeta.VERSION));
				this.setContent( (String)map.get(AssetDepreciationOperMeta.CONTENT));
				this.setBusinessDate( (Date)map.get(AssetDepreciationOperMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetDepreciationOperMeta.BUSINESS_CODE));
				this.setDepreciationId( (String)map.get(AssetDepreciationOperMeta.DEPRECIATION_ID));
				this.setCreateBy( (String)map.get(AssetDepreciationOperMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetDepreciationOperMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetDepreciationOperMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetDepreciationOperMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetDepreciationOperMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetDepreciationOperMeta.NAME));
				this.setTenantId( (String)map.get(AssetDepreciationOperMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetDepreciationOperMeta.DELETE_BY));
				this.setExecutionStartTime( (Date)map.get(AssetDepreciationOperMeta.EXECUTION_START_TIME));
				this.setId( (String)map.get(AssetDepreciationOperMeta.ID));
				this.setOriginatorId( (String)map.get(AssetDepreciationOperMeta.ORIGINATOR_ID));
				this.setStatus( (String)map.get(AssetDepreciationOperMeta.STATUS));
				// others
				this.setOriginator( (Employee)map.get(AssetDepreciationOperMeta.ORIGINATOR));
				this.setAssetDepreciation( (AssetDepreciation)map.get(AssetDepreciationOperMeta.ASSET_DEPRECIATION));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetDepreciationOperMeta.NOTES)));
			this.setDepreciationCode(DataParser.parse(String.class, r.getValue(AssetDepreciationOperMeta.DEPRECIATION_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationOperMeta.UPDATE_TIME)));
			this.setExecutionEndTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationOperMeta.EXECUTION_END_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetDepreciationOperMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetDepreciationOperMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetDepreciationOperMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetDepreciationOperMeta.BUSINESS_CODE)));
			this.setDepreciationId(DataParser.parse(String.class, r.getValue(AssetDepreciationOperMeta.DEPRECIATION_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationOperMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetDepreciationOperMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationOperMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationOperMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationOperMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetDepreciationOperMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetDepreciationOperMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetDepreciationOperMeta.DELETE_BY)));
			this.setExecutionStartTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationOperMeta.EXECUTION_START_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetDepreciationOperMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetDepreciationOperMeta.ORIGINATOR_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetDepreciationOperMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssetDepreciationOperMeta.NOTES));
				this.setDepreciationCode( (String)r.getValue(AssetDepreciationOperMeta.DEPRECIATION_CODE));
				this.setUpdateTime( (Date)r.getValue(AssetDepreciationOperMeta.UPDATE_TIME));
				this.setExecutionEndTime( (Date)r.getValue(AssetDepreciationOperMeta.EXECUTION_END_TIME));
				this.setVersion( (Integer)r.getValue(AssetDepreciationOperMeta.VERSION));
				this.setContent( (String)r.getValue(AssetDepreciationOperMeta.CONTENT));
				this.setBusinessDate( (Date)r.getValue(AssetDepreciationOperMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetDepreciationOperMeta.BUSINESS_CODE));
				this.setDepreciationId( (String)r.getValue(AssetDepreciationOperMeta.DEPRECIATION_ID));
				this.setCreateBy( (String)r.getValue(AssetDepreciationOperMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetDepreciationOperMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetDepreciationOperMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetDepreciationOperMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetDepreciationOperMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetDepreciationOperMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetDepreciationOperMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetDepreciationOperMeta.DELETE_BY));
				this.setExecutionStartTime( (Date)r.getValue(AssetDepreciationOperMeta.EXECUTION_START_TIME));
				this.setId( (String)r.getValue(AssetDepreciationOperMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetDepreciationOperMeta.ORIGINATOR_ID));
				this.setStatus( (String)r.getValue(AssetDepreciationOperMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}