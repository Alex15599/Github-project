package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_MAINTAIN_PLAN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.MaintainPlanMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 保养方案
 * <p>保养方案 , 数据表 eam_maintain_plan 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-12 21:34:12
 * @sign CB852288668EC4A24DDBEFD8FB6F807E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_maintain_plan")
@ApiModel(description = "保养方案 ; 保养方案 , 数据表 eam_maintain_plan 的PO类型")
public class MaintainPlan extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_MAINTAIN_PLAN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "698202515644088320")
	private String id;
	
	/**
	 * 编号：编号
	*/
	@ApiModelProperty(required = false,value="编号" , notes = "编号" , example = "MP202304111604601")
	private String code;
	
	/**
	 * 方案名称：方案名称
	*/
	@ApiModelProperty(required = false,value="方案名称" , notes = "方案名称" , example = "12")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "stop")
	private String status;
	
	/**
	 * 设备：设备
	*/
	@ApiModelProperty(required = false,value="设备" , notes = "设备" , example = "681881153086423040")
	private String assetId;
	
	/**
	 * 执行班组：执行班组
	*/
	@ApiModelProperty(required = false,value="执行班组" , notes = "执行班组" , example = "698150545436704768")
	private String groupId;
	
	/**
	 * 保养类型：保养类型
	*/
	@ApiModelProperty(required = false,value="保养类型" , notes = "保养类型" , example = "default")
	private String maintainType;
	
	/**
	 * 循环方式：循环方式
	*/
	@ApiModelProperty(required = false,value="循环方式" , notes = "循环方式" , example = "once")
	private String cycleMethod;
	
	/**
	 * 保养周期：保养周期
	*/
	@ApiModelProperty(required = false,value="保养周期" , notes = "保养周期")
	private String actionCycleId;
	
	/**
	 * 开始时间：开始时间
	*/
	@ApiModelProperty(required = false,value="开始时间" , notes = "开始时间" , example = "2023-04-11 04:04:59")
	private Date startTime;
	
	/**
	 * 结束时间：结束时间
	*/
	@ApiModelProperty(required = false,value="结束时间" , notes = "结束时间")
	private Date endTime;
	
	/**
	 * 预计工时：小时)
	*/
	@ApiModelProperty(required = false,value="预计工时" , notes = "小时)" , example = "0.00")
	private BigDecimal totalCost;
	
	/**
	 * 超时时间：小时)
	*/
	@ApiModelProperty(required = false,value="超时时间" , notes = "小时)" , example = "2.00")
	private BigDecimal timeout;
	
	/**
	 * 方案说明：方案说明
	*/
	@ApiModelProperty(required = false,value="方案说明" , notes = "方案说明" , example = "121212")
	private String info;
	
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
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择" , example = "1681200299000")
	private String selectedCode;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-04-11 04:07:32")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
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
	 * 项目：项目
	*/
	@ApiModelProperty(required = false,value="项目" , notes = "项目")
	private List<MaintainProject> projectList;
	
	/**
	 * 项目：项目
	*/
	@ApiModelProperty(required = false,value="项目" , notes = "项目")
	private List<String> projectIds;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private DictItem maintainTypeDict;
	
	/**
	 * 执行班组：执行班组
	*/
	@ApiModelProperty(required = false,value="执行班组" , notes = "执行班组")
	private MaintainGroup maintainGroup;
	
	/**
	 * 周期：周期
	*/
	@ApiModelProperty(required = false,value="周期" , notes = "周期")
	private ActionCrontab actionCrontab;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * asset：asset
	*/
	@ApiModelProperty(required = false,value="asset" , notes = "asset")
	private Asset asset;
	
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
	public MaintainPlan setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编号<br>
	 * 编号
	 * @return 编号
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编号
	 * @param code 编号
	 * @return 当前对象
	*/
	public MaintainPlan setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 方案名称<br>
	 * 方案名称
	 * @return 方案名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 方案名称
	 * @param name 方案名称
	 * @return 当前对象
	*/
	public MaintainPlan setName(String name) {
		this.name=name;
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
	public MaintainPlan setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 设备<br>
	 * 设备
	 * @return 设备
	*/
	public String getAssetId() {
		return assetId;
	}
	
	/**
	 * 设置 设备
	 * @param assetId 设备
	 * @return 当前对象
	*/
	public MaintainPlan setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 执行班组<br>
	 * 执行班组
	 * @return 执行班组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 执行班组
	 * @param groupId 执行班组
	 * @return 当前对象
	*/
	public MaintainPlan setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 保养类型<br>
	 * 保养类型
	 * @return 保养类型
	*/
	public String getMaintainType() {
		return maintainType;
	}
	
	/**
	 * 设置 保养类型
	 * @param maintainType 保养类型
	 * @return 当前对象
	*/
	public MaintainPlan setMaintainType(String maintainType) {
		this.maintainType=maintainType;
		return this;
	}
	
	/**
	 * 获得 循环方式<br>
	 * 循环方式
	 * @return 循环方式
	*/
	public String getCycleMethod() {
		return cycleMethod;
	}
	
	/**
	 * 设置 循环方式
	 * @param cycleMethod 循环方式
	 * @return 当前对象
	*/
	public MaintainPlan setCycleMethod(String cycleMethod) {
		this.cycleMethod=cycleMethod;
		return this;
	}
	
	/**
	 * 获得 保养周期<br>
	 * 保养周期
	 * @return 保养周期
	*/
	public String getActionCycleId() {
		return actionCycleId;
	}
	
	/**
	 * 设置 保养周期
	 * @param actionCycleId 保养周期
	 * @return 当前对象
	*/
	public MaintainPlan setActionCycleId(String actionCycleId) {
		this.actionCycleId=actionCycleId;
		return this;
	}
	
	/**
	 * 获得 开始时间<br>
	 * 开始时间
	 * @return 开始时间
	*/
	public Date getStartTime() {
		return startTime;
	}
	
	/**
	 * 设置 开始时间
	 * @param startTime 开始时间
	 * @return 当前对象
	*/
	public MaintainPlan setStartTime(Date startTime) {
		this.startTime=startTime;
		return this;
	}
	
	/**
	 * 获得 结束时间<br>
	 * 结束时间
	 * @return 结束时间
	*/
	public Date getEndTime() {
		return endTime;
	}
	
	/**
	 * 设置 结束时间
	 * @param endTime 结束时间
	 * @return 当前对象
	*/
	public MaintainPlan setEndTime(Date endTime) {
		this.endTime=endTime;
		return this;
	}
	
	/**
	 * 获得 预计工时<br>
	 * 小时)
	 * @return 预计工时
	*/
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	
	/**
	 * 设置 预计工时
	 * @param totalCost 预计工时
	 * @return 当前对象
	*/
	public MaintainPlan setTotalCost(BigDecimal totalCost) {
		this.totalCost=totalCost;
		return this;
	}
	
	/**
	 * 获得 超时时间<br>
	 * 小时)
	 * @return 超时时间
	*/
	public BigDecimal getTimeout() {
		return timeout;
	}
	
	/**
	 * 设置 超时时间
	 * @param timeout 超时时间
	 * @return 当前对象
	*/
	public MaintainPlan setTimeout(BigDecimal timeout) {
		this.timeout=timeout;
		return this;
	}
	
	/**
	 * 获得 方案说明<br>
	 * 方案说明
	 * @return 方案说明
	*/
	public String getInfo() {
		return info;
	}
	
	/**
	 * 设置 方案说明
	 * @param info 方案说明
	 * @return 当前对象
	*/
	public MaintainPlan setInfo(String info) {
		this.info=info;
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
	public MaintainPlan setNotes(String notes) {
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
	public MaintainPlan setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public MaintainPlan setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public MaintainPlan setCreateBy(String createBy) {
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
	public MaintainPlan setCreateTime(Date createTime) {
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
	public MaintainPlan setUpdateBy(String updateBy) {
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
	public MaintainPlan setUpdateTime(Date updateTime) {
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
	public MaintainPlan setDeleted(Integer deleted) {
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
	public MaintainPlan setDeleted(Boolean deletedBool) {
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
	public MaintainPlan setDeleteBy(String deleteBy) {
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
	public MaintainPlan setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public MaintainPlan setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public MaintainPlan setVersion(Integer version) {
		this.version=version;
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
	public MaintainPlan setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public MaintainPlan addAsset(Asset... asset) {
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
	public MaintainPlan setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 资产列表
	 * @param assetId 资产列表
	 * @return 当前对象
	*/
	public MaintainPlan addAssetId(String... assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.addAll(Arrays.asList(assetId));
		return this;
	}
	
	/**
	 * 获得 项目<br>
	 * 项目
	 * @return 项目
	*/
	public List<MaintainProject> getProjectList() {
		return projectList;
	}
	
	/**
	 * 设置 项目
	 * @param projectList 项目
	 * @return 当前对象
	*/
	public MaintainPlan setProjectList(List<MaintainProject> projectList) {
		this.projectList=projectList;
		return this;
	}
	
	/**
	 * 添加 项目
	 * @param project 项目
	 * @return 当前对象
	*/
	public MaintainPlan addProject(MaintainProject... project) {
		if(this.projectList==null) projectList=new ArrayList<>();
		this.projectList.addAll(Arrays.asList(project));
		return this;
	}
	
	/**
	 * 获得 项目<br>
	 * 项目
	 * @return 项目
	*/
	public List<String> getProjectIds() {
		return projectIds;
	}
	
	/**
	 * 设置 项目
	 * @param projectIds 项目
	 * @return 当前对象
	*/
	public MaintainPlan setProjectIds(List<String> projectIds) {
		this.projectIds=projectIds;
		return this;
	}
	
	/**
	 * 添加 项目
	 * @param projectId 项目
	 * @return 当前对象
	*/
	public MaintainPlan addProjectId(String... projectId) {
		if(this.projectIds==null) projectIds=new ArrayList<>();
		this.projectIds.addAll(Arrays.asList(projectId));
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public DictItem getMaintainTypeDict() {
		return maintainTypeDict;
	}
	
	/**
	 * 设置 类型
	 * @param maintainTypeDict 类型
	 * @return 当前对象
	*/
	public MaintainPlan setMaintainTypeDict(DictItem maintainTypeDict) {
		this.maintainTypeDict=maintainTypeDict;
		return this;
	}
	
	/**
	 * 获得 执行班组<br>
	 * 执行班组
	 * @return 执行班组
	*/
	public MaintainGroup getMaintainGroup() {
		return maintainGroup;
	}
	
	/**
	 * 设置 执行班组
	 * @param maintainGroup 执行班组
	 * @return 当前对象
	*/
	public MaintainPlan setMaintainGroup(MaintainGroup maintainGroup) {
		this.maintainGroup=maintainGroup;
		return this;
	}
	
	/**
	 * 获得 周期<br>
	 * 周期
	 * @return 周期
	*/
	public ActionCrontab getActionCrontab() {
		return actionCrontab;
	}
	
	/**
	 * 设置 周期
	 * @param actionCrontab 周期
	 * @return 当前对象
	*/
	public MaintainPlan setActionCrontab(ActionCrontab actionCrontab) {
		this.actionCrontab=actionCrontab;
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
	public MaintainPlan setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 asset<br>
	 * asset
	 * @return asset
	*/
	public Asset getAsset() {
		return asset;
	}
	
	/**
	 * 设置 asset
	 * @param asset asset
	 * @return 当前对象
	*/
	public MaintainPlan setAsset(Asset asset) {
		this.asset=asset;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MaintainPlan , 转换好的 MaintainPlan 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MaintainPlan , 转换好的 PoJo 对象
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
	public MaintainPlan clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MaintainPlan duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.MaintainPlanMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.MaintainPlanMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setGroupId(this.getGroupId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setTimeout(this.getTimeout());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setAssetId(this.getAssetId());
		inst.setStartTime(this.getStartTime());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setMaintainType(this.getMaintainType());
		inst.setInfo(this.getInfo());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setActionCycleId(this.getActionCycleId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setCycleMethod(this.getCycleMethod());
		inst.setEndTime(this.getEndTime());
		inst.setTotalCost(this.getTotalCost());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setProjectList(this.getProjectList());
			inst.setActionCrontab(this.getActionCrontab());
			inst.setAssetIds(this.getAssetIds());
			inst.setProjectIds(this.getProjectIds());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setAsset(this.getAsset());
			inst.setMaintainTypeDict(this.getMaintainTypeDict());
			inst.setMaintainGroup(this.getMaintainGroup());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public MaintainPlan clone(boolean deep) {
		return EntityContext.clone(MaintainPlan.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MaintainPlan
	 * @param maintainPlanMap 包含实体信息的 Map 对象
	 * @return MaintainPlan , 转换好的的 MaintainPlan 对象
	*/
	@Transient
	public static MaintainPlan createFrom(Map<String,Object> maintainPlanMap) {
		if(maintainPlanMap==null) return null;
		MaintainPlan po = create();
		EntityContext.copyProperties(po,maintainPlanMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MaintainPlan
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MaintainPlan , 转换好的的 MaintainPlan 对象
	*/
	@Transient
	public static MaintainPlan createFrom(Object pojo) {
		if(pojo==null) return null;
		MaintainPlan po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MaintainPlan，等同于 new
	 * @return MaintainPlan 对象
	*/
	@Transient
	public static MaintainPlan create() {
		return new com.dt.platform.domain.eam.meta.MaintainPlanMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(MaintainPlanMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(MaintainPlanMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, map.get(MaintainPlanMeta.GROUP_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(MaintainPlanMeta.SELECTED_CODE)));
			this.setTimeout(DataParser.parse(BigDecimal.class, map.get(MaintainPlanMeta.TIMEOUT)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MaintainPlanMeta.UPDATE_BY)));
			this.setAssetId(DataParser.parse(String.class, map.get(MaintainPlanMeta.ASSET_ID)));
			this.setStartTime(DataParser.parse(Date.class, map.get(MaintainPlanMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, map.get(MaintainPlanMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(MaintainPlanMeta.ORIGINATOR_ID)));
			this.setMaintainType(DataParser.parse(String.class, map.get(MaintainPlanMeta.MAINTAIN_TYPE)));
			this.setInfo(DataParser.parse(String.class, map.get(MaintainPlanMeta.INFO)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MaintainPlanMeta.UPDATE_TIME)));
			this.setActionCycleId(DataParser.parse(String.class, map.get(MaintainPlanMeta.ACTION_CYCLE_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MaintainPlanMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MaintainPlanMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MaintainPlanMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MaintainPlanMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MaintainPlanMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(MaintainPlanMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(MaintainPlanMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MaintainPlanMeta.DELETE_BY)));
			this.setCycleMethod(DataParser.parse(String.class, map.get(MaintainPlanMeta.CYCLE_METHOD)));
			this.setEndTime(DataParser.parse(Date.class, map.get(MaintainPlanMeta.END_TIME)));
			this.setTotalCost(DataParser.parse(BigDecimal.class, map.get(MaintainPlanMeta.TOTAL_COST)));
			this.setStatus(DataParser.parse(String.class, map.get(MaintainPlanMeta.STATUS)));
			// others
			this.setActionCrontab(DataParser.parse(ActionCrontab.class, map.get(MaintainPlanMeta.ACTION_CRONTAB)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(MaintainPlanMeta.ORIGINATOR)));
			this.setAsset(DataParser.parse(Asset.class, map.get(MaintainPlanMeta.ASSET)));
			this.setMaintainTypeDict(DataParser.parse(DictItem.class, map.get(MaintainPlanMeta.MAINTAIN_TYPE_DICT)));
			this.setMaintainGroup(DataParser.parse(MaintainGroup.class, map.get(MaintainPlanMeta.MAINTAIN_GROUP)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(MaintainPlanMeta.CODE));
				this.setNotes( (String)map.get(MaintainPlanMeta.NOTES));
				this.setGroupId( (String)map.get(MaintainPlanMeta.GROUP_ID));
				this.setSelectedCode( (String)map.get(MaintainPlanMeta.SELECTED_CODE));
				this.setTimeout( (BigDecimal)map.get(MaintainPlanMeta.TIMEOUT));
				this.setUpdateBy( (String)map.get(MaintainPlanMeta.UPDATE_BY));
				this.setAssetId( (String)map.get(MaintainPlanMeta.ASSET_ID));
				this.setStartTime( (Date)map.get(MaintainPlanMeta.START_TIME));
				this.setId( (String)map.get(MaintainPlanMeta.ID));
				this.setOriginatorId( (String)map.get(MaintainPlanMeta.ORIGINATOR_ID));
				this.setMaintainType( (String)map.get(MaintainPlanMeta.MAINTAIN_TYPE));
				this.setInfo( (String)map.get(MaintainPlanMeta.INFO));
				this.setUpdateTime( (Date)map.get(MaintainPlanMeta.UPDATE_TIME));
				this.setActionCycleId( (String)map.get(MaintainPlanMeta.ACTION_CYCLE_ID));
				this.setVersion( (Integer)map.get(MaintainPlanMeta.VERSION));
				this.setCreateBy( (String)map.get(MaintainPlanMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MaintainPlanMeta.DELETED));
				this.setCreateTime( (Date)map.get(MaintainPlanMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(MaintainPlanMeta.DELETE_TIME));
				this.setName( (String)map.get(MaintainPlanMeta.NAME));
				this.setTenantId( (String)map.get(MaintainPlanMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(MaintainPlanMeta.DELETE_BY));
				this.setCycleMethod( (String)map.get(MaintainPlanMeta.CYCLE_METHOD));
				this.setEndTime( (Date)map.get(MaintainPlanMeta.END_TIME));
				this.setTotalCost( (BigDecimal)map.get(MaintainPlanMeta.TOTAL_COST));
				this.setStatus( (String)map.get(MaintainPlanMeta.STATUS));
				// others
				this.setActionCrontab( (ActionCrontab)map.get(MaintainPlanMeta.ACTION_CRONTAB));
				this.setOriginator( (Employee)map.get(MaintainPlanMeta.ORIGINATOR));
				this.setAsset( (Asset)map.get(MaintainPlanMeta.ASSET));
				this.setMaintainTypeDict( (DictItem)map.get(MaintainPlanMeta.MAINTAIN_TYPE_DICT));
				this.setMaintainGroup( (MaintainGroup)map.get(MaintainPlanMeta.MAINTAIN_GROUP));
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
			this.setCode(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.GROUP_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.SELECTED_CODE)));
			this.setTimeout(DataParser.parse(BigDecimal.class, r.getValue(MaintainPlanMeta.TIMEOUT)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.UPDATE_BY)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.ASSET_ID)));
			this.setStartTime(DataParser.parse(Date.class, r.getValue(MaintainPlanMeta.START_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.ORIGINATOR_ID)));
			this.setMaintainType(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.MAINTAIN_TYPE)));
			this.setInfo(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.INFO)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MaintainPlanMeta.UPDATE_TIME)));
			this.setActionCycleId(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.ACTION_CYCLE_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MaintainPlanMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MaintainPlanMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MaintainPlanMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MaintainPlanMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.DELETE_BY)));
			this.setCycleMethod(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.CYCLE_METHOD)));
			this.setEndTime(DataParser.parse(Date.class, r.getValue(MaintainPlanMeta.END_TIME)));
			this.setTotalCost(DataParser.parse(BigDecimal.class, r.getValue(MaintainPlanMeta.TOTAL_COST)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MaintainPlanMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(MaintainPlanMeta.CODE));
				this.setNotes( (String)r.getValue(MaintainPlanMeta.NOTES));
				this.setGroupId( (String)r.getValue(MaintainPlanMeta.GROUP_ID));
				this.setSelectedCode( (String)r.getValue(MaintainPlanMeta.SELECTED_CODE));
				this.setTimeout( (BigDecimal)r.getValue(MaintainPlanMeta.TIMEOUT));
				this.setUpdateBy( (String)r.getValue(MaintainPlanMeta.UPDATE_BY));
				this.setAssetId( (String)r.getValue(MaintainPlanMeta.ASSET_ID));
				this.setStartTime( (Date)r.getValue(MaintainPlanMeta.START_TIME));
				this.setId( (String)r.getValue(MaintainPlanMeta.ID));
				this.setOriginatorId( (String)r.getValue(MaintainPlanMeta.ORIGINATOR_ID));
				this.setMaintainType( (String)r.getValue(MaintainPlanMeta.MAINTAIN_TYPE));
				this.setInfo( (String)r.getValue(MaintainPlanMeta.INFO));
				this.setUpdateTime( (Date)r.getValue(MaintainPlanMeta.UPDATE_TIME));
				this.setActionCycleId( (String)r.getValue(MaintainPlanMeta.ACTION_CYCLE_ID));
				this.setVersion( (Integer)r.getValue(MaintainPlanMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MaintainPlanMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MaintainPlanMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MaintainPlanMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(MaintainPlanMeta.DELETE_TIME));
				this.setName( (String)r.getValue(MaintainPlanMeta.NAME));
				this.setTenantId( (String)r.getValue(MaintainPlanMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(MaintainPlanMeta.DELETE_BY));
				this.setCycleMethod( (String)r.getValue(MaintainPlanMeta.CYCLE_METHOD));
				this.setEndTime( (Date)r.getValue(MaintainPlanMeta.END_TIME));
				this.setTotalCost( (BigDecimal)r.getValue(MaintainPlanMeta.TOTAL_COST));
				this.setStatus( (String)r.getValue(MaintainPlanMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}