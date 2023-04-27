package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_MAINTAIN_TASK;
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
import com.dt.platform.domain.eam.meta.MaintainTaskMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 保养任务
 * <p>保养任务 , 数据表 eam_maintain_task 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-14 07:30:10
 * @sign 234089915D37B5B0886AFBFCB4AB3A0F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_maintain_task")
@ApiModel(description = "保养任务 ; 保养任务 , 数据表 eam_maintain_task 的PO类型")
public class MaintainTask extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_MAINTAIN_TASK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "698202584300650496")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "acting")
	private String status;
	
	/**
	 * 任务单据：任务单据
	*/
	@ApiModelProperty(required = false,value="任务单据" , notes = "任务单据" , example = "MT202304111604551")
	private String businessCode;
	
	/**
	 * 方案：方案
	*/
	@ApiModelProperty(required = false,value="方案" , notes = "方案" , example = "698202515644088320")
	private String planId;
	
	/**
	 * 保养类型：保养类型
	*/
	@ApiModelProperty(required = false,value="保养类型" , notes = "保养类型" , example = "default")
	private String maintainType;
	
	/**
	 * 执行班组：执行班组
	*/
	@ApiModelProperty(required = true,value="执行班组" , notes = "执行班组" , example = "698150545436704768")
	private String groupId;
	
	/**
	 * 设备：设备
	*/
	@ApiModelProperty(required = false,value="设备" , notes = "设备" , example = "690281218771517440")
	private String assetId;
	
	/**
	 * 设备名称：设备名称
	*/
	@ApiModelProperty(required = false,value="设备名称" , notes = "设备名称" , example = "这是一个测试")
	private String assetName;
	
	/**
	 * 设备编码：设备编码
	*/
	@ApiModelProperty(required = false,value="设备编码" , notes = "设备编码")
	private String assetCode;
	
	/**
	 * 设备型号：设备型号
	*/
	@ApiModelProperty(required = false,value="设备型号" , notes = "设备型号" , example = "规格")
	private String assetModel;
	
	/**
	 * 设备状态：设备状态
	*/
	@ApiModelProperty(required = false,value="设备状态" , notes = "设备状态" , example = "idle")
	private String assetStatus;
	
	/**
	 * 设备序列号：设备序列号
	*/
	@ApiModelProperty(required = false,value="设备序列号" , notes = "设备序列号")
	private String assetSn;
	
	/**
	 * 位置：位置
	*/
	@ApiModelProperty(required = false,value="位置" , notes = "位置")
	private String assetPos;
	
	/**
	 * 保养结果：保养结果
	*/
	@ApiModelProperty(required = false,value="保养结果" , notes = "保养结果")
	private String content;
	
	/**
	 * 执行人：执行人
	*/
	@ApiModelProperty(required = false,value="执行人" , notes = "执行人")
	private String executorId;
	
	/**
	 * 应开始时间：应开始时间
	*/
	@ApiModelProperty(required = false,value="应开始时间" , notes = "应开始时间" , example = "2023-04-11 04:07:48")
	private Date planStartTime;
	
	/**
	 * 实际开始时间：实际开始时间
	*/
	@ApiModelProperty(required = false,value="实际开始时间" , notes = "实际开始时间")
	private Date actStartTime;
	
	/**
	 * 实际完成时间：实际完成时间
	*/
	@ApiModelProperty(required = false,value="实际完成时间" , notes = "实际完成时间")
	private Date actFinishTime;
	
	/**
	 * 超时时间：超时时间
	*/
	@ApiModelProperty(required = false,value="超时时间" , notes = "超时时间")
	private BigDecimal timeout;
	
	/**
	 * 预计工时：预计工时
	*/
	@ApiModelProperty(required = false,value="预计工时" , notes = "预计工时" , example = "0.00")
	private BigDecimal totalCost;
	
	/**
	 * 实际工时：实际工时
	*/
	@ApiModelProperty(required = false,value="实际工时" , notes = "实际工时" , example = "0.00")
	private BigDecimal actTotalCost;
	
	/**
	 * 费用：元)
	*/
	@ApiModelProperty(required = false,value="费用" , notes = "元)")
	private BigDecimal cost;
	
	/**
	 * 逾期：逾期
	*/
	@ApiModelProperty(required = false,value="逾期" , notes = "逾期" , example = "normal")
	private String overdue;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-04-11 04:07:48")
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
	 * 项目：项目
	*/
	@ApiModelProperty(required = false,value="项目" , notes = "项目")
	private List<MaintainTaskProject> taskProjectList;
	
	/**
	 * 项目：项目
	*/
	@ApiModelProperty(required = false,value="项目" , notes = "项目")
	private List<String> taskProjectIds;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private Asset asset;
	
	/**
	 * 方案：方案
	*/
	@ApiModelProperty(required = false,value="方案" , notes = "方案")
	private MaintainPlan maintainPlan;
	
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
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private Employee originator;
	
	/**
	 * 执行人：执行人
	*/
	@ApiModelProperty(required = false,value="执行人" , notes = "执行人")
	private Employee executor;
	
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
	public MaintainTask setId(String id) {
		this.id=id;
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
	public MaintainTask setName(String name) {
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
	public MaintainTask setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 任务单据<br>
	 * 任务单据
	 * @return 任务单据
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 任务单据
	 * @param businessCode 任务单据
	 * @return 当前对象
	*/
	public MaintainTask setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 方案<br>
	 * 方案
	 * @return 方案
	*/
	public String getPlanId() {
		return planId;
	}
	
	/**
	 * 设置 方案
	 * @param planId 方案
	 * @return 当前对象
	*/
	public MaintainTask setPlanId(String planId) {
		this.planId=planId;
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
	public MaintainTask setMaintainType(String maintainType) {
		this.maintainType=maintainType;
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
	public MaintainTask setGroupId(String groupId) {
		this.groupId=groupId;
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
	public MaintainTask setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 设备名称<br>
	 * 设备名称
	 * @return 设备名称
	*/
	public String getAssetName() {
		return assetName;
	}
	
	/**
	 * 设置 设备名称
	 * @param assetName 设备名称
	 * @return 当前对象
	*/
	public MaintainTask setAssetName(String assetName) {
		this.assetName=assetName;
		return this;
	}
	
	/**
	 * 获得 设备编码<br>
	 * 设备编码
	 * @return 设备编码
	*/
	public String getAssetCode() {
		return assetCode;
	}
	
	/**
	 * 设置 设备编码
	 * @param assetCode 设备编码
	 * @return 当前对象
	*/
	public MaintainTask setAssetCode(String assetCode) {
		this.assetCode=assetCode;
		return this;
	}
	
	/**
	 * 获得 设备型号<br>
	 * 设备型号
	 * @return 设备型号
	*/
	public String getAssetModel() {
		return assetModel;
	}
	
	/**
	 * 设置 设备型号
	 * @param assetModel 设备型号
	 * @return 当前对象
	*/
	public MaintainTask setAssetModel(String assetModel) {
		this.assetModel=assetModel;
		return this;
	}
	
	/**
	 * 获得 设备状态<br>
	 * 设备状态
	 * @return 设备状态
	*/
	public String getAssetStatus() {
		return assetStatus;
	}
	
	/**
	 * 设置 设备状态
	 * @param assetStatus 设备状态
	 * @return 当前对象
	*/
	public MaintainTask setAssetStatus(String assetStatus) {
		this.assetStatus=assetStatus;
		return this;
	}
	
	/**
	 * 获得 设备序列号<br>
	 * 设备序列号
	 * @return 设备序列号
	*/
	public String getAssetSn() {
		return assetSn;
	}
	
	/**
	 * 设置 设备序列号
	 * @param assetSn 设备序列号
	 * @return 当前对象
	*/
	public MaintainTask setAssetSn(String assetSn) {
		this.assetSn=assetSn;
		return this;
	}
	
	/**
	 * 获得 位置<br>
	 * 位置
	 * @return 位置
	*/
	public String getAssetPos() {
		return assetPos;
	}
	
	/**
	 * 设置 位置
	 * @param assetPos 位置
	 * @return 当前对象
	*/
	public MaintainTask setAssetPos(String assetPos) {
		this.assetPos=assetPos;
		return this;
	}
	
	/**
	 * 获得 保养结果<br>
	 * 保养结果
	 * @return 保养结果
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 保养结果
	 * @param content 保养结果
	 * @return 当前对象
	*/
	public MaintainTask setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 执行人<br>
	 * 执行人
	 * @return 执行人
	*/
	public String getExecutorId() {
		return executorId;
	}
	
	/**
	 * 设置 执行人
	 * @param executorId 执行人
	 * @return 当前对象
	*/
	public MaintainTask setExecutorId(String executorId) {
		this.executorId=executorId;
		return this;
	}
	
	/**
	 * 获得 应开始时间<br>
	 * 应开始时间
	 * @return 应开始时间
	*/
	public Date getPlanStartTime() {
		return planStartTime;
	}
	
	/**
	 * 设置 应开始时间
	 * @param planStartTime 应开始时间
	 * @return 当前对象
	*/
	public MaintainTask setPlanStartTime(Date planStartTime) {
		this.planStartTime=planStartTime;
		return this;
	}
	
	/**
	 * 获得 实际开始时间<br>
	 * 实际开始时间
	 * @return 实际开始时间
	*/
	public Date getActStartTime() {
		return actStartTime;
	}
	
	/**
	 * 设置 实际开始时间
	 * @param actStartTime 实际开始时间
	 * @return 当前对象
	*/
	public MaintainTask setActStartTime(Date actStartTime) {
		this.actStartTime=actStartTime;
		return this;
	}
	
	/**
	 * 获得 实际完成时间<br>
	 * 实际完成时间
	 * @return 实际完成时间
	*/
	public Date getActFinishTime() {
		return actFinishTime;
	}
	
	/**
	 * 设置 实际完成时间
	 * @param actFinishTime 实际完成时间
	 * @return 当前对象
	*/
	public MaintainTask setActFinishTime(Date actFinishTime) {
		this.actFinishTime=actFinishTime;
		return this;
	}
	
	/**
	 * 获得 超时时间<br>
	 * 超时时间
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
	public MaintainTask setTimeout(BigDecimal timeout) {
		this.timeout=timeout;
		return this;
	}
	
	/**
	 * 获得 预计工时<br>
	 * 预计工时
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
	public MaintainTask setTotalCost(BigDecimal totalCost) {
		this.totalCost=totalCost;
		return this;
	}
	
	/**
	 * 获得 实际工时<br>
	 * 实际工时
	 * @return 实际工时
	*/
	public BigDecimal getActTotalCost() {
		return actTotalCost;
	}
	
	/**
	 * 设置 实际工时
	 * @param actTotalCost 实际工时
	 * @return 当前对象
	*/
	public MaintainTask setActTotalCost(BigDecimal actTotalCost) {
		this.actTotalCost=actTotalCost;
		return this;
	}
	
	/**
	 * 获得 费用<br>
	 * 元)
	 * @return 费用
	*/
	public BigDecimal getCost() {
		return cost;
	}
	
	/**
	 * 设置 费用
	 * @param cost 费用
	 * @return 当前对象
	*/
	public MaintainTask setCost(BigDecimal cost) {
		this.cost=cost;
		return this;
	}
	
	/**
	 * 获得 逾期<br>
	 * 逾期
	 * @return 逾期
	*/
	public String getOverdue() {
		return overdue;
	}
	
	/**
	 * 设置 逾期
	 * @param overdue 逾期
	 * @return 当前对象
	*/
	public MaintainTask setOverdue(String overdue) {
		this.overdue=overdue;
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
	public MaintainTask setNotes(String notes) {
		this.notes=notes;
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
	public MaintainTask setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public MaintainTask setOriginatorId(String originatorId) {
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
	public MaintainTask setCreateBy(String createBy) {
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
	public MaintainTask setCreateTime(Date createTime) {
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
	public MaintainTask setUpdateBy(String updateBy) {
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
	public MaintainTask setUpdateTime(Date updateTime) {
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
	public MaintainTask setDeleted(Integer deleted) {
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
	public MaintainTask setDeleted(Boolean deletedBool) {
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
	public MaintainTask setDeleteBy(String deleteBy) {
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
	public MaintainTask setDeleteTime(Date deleteTime) {
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
	public MaintainTask setTenantId(String tenantId) {
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
	public MaintainTask setVersion(Integer version) {
		this.version=version;
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
	public MaintainTask setProjectList(List<MaintainProject> projectList) {
		this.projectList=projectList;
		return this;
	}
	
	/**
	 * 添加 项目
	 * @param project 项目
	 * @return 当前对象
	*/
	public MaintainTask addProject(MaintainProject... project) {
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
	public MaintainTask setProjectIds(List<String> projectIds) {
		this.projectIds=projectIds;
		return this;
	}
	
	/**
	 * 添加 项目
	 * @param projectId 项目
	 * @return 当前对象
	*/
	public MaintainTask addProjectId(String... projectId) {
		if(this.projectIds==null) projectIds=new ArrayList<>();
		this.projectIds.addAll(Arrays.asList(projectId));
		return this;
	}
	
	/**
	 * 获得 项目<br>
	 * 项目
	 * @return 项目
	*/
	public List<MaintainTaskProject> getTaskProjectList() {
		return taskProjectList;
	}
	
	/**
	 * 设置 项目
	 * @param taskProjectList 项目
	 * @return 当前对象
	*/
	public MaintainTask setTaskProjectList(List<MaintainTaskProject> taskProjectList) {
		this.taskProjectList=taskProjectList;
		return this;
	}
	
	/**
	 * 添加 项目
	 * @param taskProject 项目
	 * @return 当前对象
	*/
	public MaintainTask addTaskProject(MaintainTaskProject... taskProject) {
		if(this.taskProjectList==null) taskProjectList=new ArrayList<>();
		this.taskProjectList.addAll(Arrays.asList(taskProject));
		return this;
	}
	
	/**
	 * 获得 项目<br>
	 * 项目
	 * @return 项目
	*/
	public List<String> getTaskProjectIds() {
		return taskProjectIds;
	}
	
	/**
	 * 设置 项目
	 * @param taskProjectIds 项目
	 * @return 当前对象
	*/
	public MaintainTask setTaskProjectIds(List<String> taskProjectIds) {
		this.taskProjectIds=taskProjectIds;
		return this;
	}
	
	/**
	 * 添加 项目
	 * @param taskProjectId 项目
	 * @return 当前对象
	*/
	public MaintainTask addTaskProjectId(String... taskProjectId) {
		if(this.taskProjectIds==null) taskProjectIds=new ArrayList<>();
		this.taskProjectIds.addAll(Arrays.asList(taskProjectId));
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
	public MaintainTask setAsset(Asset asset) {
		this.asset=asset;
		return this;
	}
	
	/**
	 * 获得 方案<br>
	 * 方案
	 * @return 方案
	*/
	public MaintainPlan getMaintainPlan() {
		return maintainPlan;
	}
	
	/**
	 * 设置 方案
	 * @param maintainPlan 方案
	 * @return 当前对象
	*/
	public MaintainTask setMaintainPlan(MaintainPlan maintainPlan) {
		this.maintainPlan=maintainPlan;
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
	public MaintainTask setMaintainTypeDict(DictItem maintainTypeDict) {
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
	public MaintainTask setMaintainGroup(MaintainGroup maintainGroup) {
		this.maintainGroup=maintainGroup;
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
	public MaintainTask setOriginator(Employee originator) {
		this.originator=originator;
		return this;
	}
	
	/**
	 * 获得 执行人<br>
	 * 执行人
	 * @return 执行人
	*/
	public Employee getExecutor() {
		return executor;
	}
	
	/**
	 * 设置 执行人
	 * @param executor 执行人
	 * @return 当前对象
	*/
	public MaintainTask setExecutor(Employee executor) {
		this.executor=executor;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return MaintainTask , 转换好的 MaintainTask 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return MaintainTask , 转换好的 PoJo 对象
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
	public MaintainTask clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public MaintainTask duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.MaintainTaskMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.MaintainTaskMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setAssetPos(this.getAssetPos());
		inst.setGroupId(this.getGroupId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setTimeout(this.getTimeout());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setActStartTime(this.getActStartTime());
		inst.setOverdue(this.getOverdue());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setAssetId(this.getAssetId());
		inst.setAssetSn(this.getAssetSn());
		inst.setPlanId(this.getPlanId());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setMaintainType(this.getMaintainType());
		inst.setActFinishTime(this.getActFinishTime());
		inst.setAssetCode(this.getAssetCode());
		inst.setCost(this.getCost());
		inst.setPlanStartTime(this.getPlanStartTime());
		inst.setExecutorId(this.getExecutorId());
		inst.setAssetModel(this.getAssetModel());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setActTotalCost(this.getActTotalCost());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setAssetName(this.getAssetName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setAssetStatus(this.getAssetStatus());
		inst.setTotalCost(this.getTotalCost());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setProjectList(this.getProjectList());
			inst.setTaskProjectList(this.getTaskProjectList());
			inst.setMaintainPlan(this.getMaintainPlan());
			inst.setExecutor(this.getExecutor());
			inst.setProjectIds(this.getProjectIds());
			inst.setTaskProjectIds(this.getTaskProjectIds());
			inst.setOriginator(this.getOriginator());
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
	public MaintainTask clone(boolean deep) {
		return EntityContext.clone(MaintainTask.class,this,deep);
	}

	/**
	 * 将 Map 转换成 MaintainTask
	 * @param maintainTaskMap 包含实体信息的 Map 对象
	 * @return MaintainTask , 转换好的的 MaintainTask 对象
	*/
	@Transient
	public static MaintainTask createFrom(Map<String,Object> maintainTaskMap) {
		if(maintainTaskMap==null) return null;
		MaintainTask po = create();
		EntityContext.copyProperties(po,maintainTaskMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 MaintainTask
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return MaintainTask , 转换好的的 MaintainTask 对象
	*/
	@Transient
	public static MaintainTask createFrom(Object pojo) {
		if(pojo==null) return null;
		MaintainTask po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 MaintainTask，等同于 new
	 * @return MaintainTask 对象
	*/
	@Transient
	public static MaintainTask create() {
		return new com.dt.platform.domain.eam.meta.MaintainTaskMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(MaintainTaskMeta.NOTES)));
			this.setAssetPos(DataParser.parse(String.class, map.get(MaintainTaskMeta.ASSET_POS)));
			this.setGroupId(DataParser.parse(String.class, map.get(MaintainTaskMeta.GROUP_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(MaintainTaskMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(MaintainTaskMeta.CONTENT)));
			this.setTimeout(DataParser.parse(BigDecimal.class, map.get(MaintainTaskMeta.TIMEOUT)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(MaintainTaskMeta.BUSINESS_CODE)));
			this.setActStartTime(DataParser.parse(Date.class, map.get(MaintainTaskMeta.ACT_START_TIME)));
			this.setOverdue(DataParser.parse(String.class, map.get(MaintainTaskMeta.OVERDUE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(MaintainTaskMeta.UPDATE_BY)));
			this.setAssetId(DataParser.parse(String.class, map.get(MaintainTaskMeta.ASSET_ID)));
			this.setAssetSn(DataParser.parse(String.class, map.get(MaintainTaskMeta.ASSET_SN)));
			this.setPlanId(DataParser.parse(String.class, map.get(MaintainTaskMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, map.get(MaintainTaskMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(MaintainTaskMeta.ORIGINATOR_ID)));
			this.setMaintainType(DataParser.parse(String.class, map.get(MaintainTaskMeta.MAINTAIN_TYPE)));
			this.setActFinishTime(DataParser.parse(Date.class, map.get(MaintainTaskMeta.ACT_FINISH_TIME)));
			this.setAssetCode(DataParser.parse(String.class, map.get(MaintainTaskMeta.ASSET_CODE)));
			this.setCost(DataParser.parse(BigDecimal.class, map.get(MaintainTaskMeta.COST)));
			this.setPlanStartTime(DataParser.parse(Date.class, map.get(MaintainTaskMeta.PLAN_START_TIME)));
			this.setExecutorId(DataParser.parse(String.class, map.get(MaintainTaskMeta.EXECUTOR_ID)));
			this.setAssetModel(DataParser.parse(String.class, map.get(MaintainTaskMeta.ASSET_MODEL)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(MaintainTaskMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(MaintainTaskMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(MaintainTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(MaintainTaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(MaintainTaskMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(MaintainTaskMeta.DELETE_TIME)));
			this.setActTotalCost(DataParser.parse(BigDecimal.class, map.get(MaintainTaskMeta.ACT_TOTAL_COST)));
			this.setName(DataParser.parse(String.class, map.get(MaintainTaskMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(MaintainTaskMeta.TENANT_ID)));
			this.setAssetName(DataParser.parse(String.class, map.get(MaintainTaskMeta.ASSET_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(MaintainTaskMeta.DELETE_BY)));
			this.setAssetStatus(DataParser.parse(String.class, map.get(MaintainTaskMeta.ASSET_STATUS)));
			this.setTotalCost(DataParser.parse(BigDecimal.class, map.get(MaintainTaskMeta.TOTAL_COST)));
			this.setStatus(DataParser.parse(String.class, map.get(MaintainTaskMeta.STATUS)));
			// others
			this.setMaintainPlan(DataParser.parse(MaintainPlan.class, map.get(MaintainTaskMeta.MAINTAIN_PLAN)));
			this.setExecutor(DataParser.parse(Employee.class, map.get(MaintainTaskMeta.EXECUTOR)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(MaintainTaskMeta.ORIGINATOR)));
			this.setAsset(DataParser.parse(Asset.class, map.get(MaintainTaskMeta.ASSET)));
			this.setMaintainTypeDict(DataParser.parse(DictItem.class, map.get(MaintainTaskMeta.MAINTAIN_TYPE_DICT)));
			this.setMaintainGroup(DataParser.parse(MaintainGroup.class, map.get(MaintainTaskMeta.MAINTAIN_GROUP)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(MaintainTaskMeta.NOTES));
				this.setAssetPos( (String)map.get(MaintainTaskMeta.ASSET_POS));
				this.setGroupId( (String)map.get(MaintainTaskMeta.GROUP_ID));
				this.setSelectedCode( (String)map.get(MaintainTaskMeta.SELECTED_CODE));
				this.setContent( (String)map.get(MaintainTaskMeta.CONTENT));
				this.setTimeout( (BigDecimal)map.get(MaintainTaskMeta.TIMEOUT));
				this.setBusinessCode( (String)map.get(MaintainTaskMeta.BUSINESS_CODE));
				this.setActStartTime( (Date)map.get(MaintainTaskMeta.ACT_START_TIME));
				this.setOverdue( (String)map.get(MaintainTaskMeta.OVERDUE));
				this.setUpdateBy( (String)map.get(MaintainTaskMeta.UPDATE_BY));
				this.setAssetId( (String)map.get(MaintainTaskMeta.ASSET_ID));
				this.setAssetSn( (String)map.get(MaintainTaskMeta.ASSET_SN));
				this.setPlanId( (String)map.get(MaintainTaskMeta.PLAN_ID));
				this.setId( (String)map.get(MaintainTaskMeta.ID));
				this.setOriginatorId( (String)map.get(MaintainTaskMeta.ORIGINATOR_ID));
				this.setMaintainType( (String)map.get(MaintainTaskMeta.MAINTAIN_TYPE));
				this.setActFinishTime( (Date)map.get(MaintainTaskMeta.ACT_FINISH_TIME));
				this.setAssetCode( (String)map.get(MaintainTaskMeta.ASSET_CODE));
				this.setCost( (BigDecimal)map.get(MaintainTaskMeta.COST));
				this.setPlanStartTime( (Date)map.get(MaintainTaskMeta.PLAN_START_TIME));
				this.setExecutorId( (String)map.get(MaintainTaskMeta.EXECUTOR_ID));
				this.setAssetModel( (String)map.get(MaintainTaskMeta.ASSET_MODEL));
				this.setUpdateTime( (Date)map.get(MaintainTaskMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(MaintainTaskMeta.VERSION));
				this.setCreateBy( (String)map.get(MaintainTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(MaintainTaskMeta.DELETED));
				this.setCreateTime( (Date)map.get(MaintainTaskMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(MaintainTaskMeta.DELETE_TIME));
				this.setActTotalCost( (BigDecimal)map.get(MaintainTaskMeta.ACT_TOTAL_COST));
				this.setName( (String)map.get(MaintainTaskMeta.NAME));
				this.setTenantId( (String)map.get(MaintainTaskMeta.TENANT_ID));
				this.setAssetName( (String)map.get(MaintainTaskMeta.ASSET_NAME));
				this.setDeleteBy( (String)map.get(MaintainTaskMeta.DELETE_BY));
				this.setAssetStatus( (String)map.get(MaintainTaskMeta.ASSET_STATUS));
				this.setTotalCost( (BigDecimal)map.get(MaintainTaskMeta.TOTAL_COST));
				this.setStatus( (String)map.get(MaintainTaskMeta.STATUS));
				// others
				this.setMaintainPlan( (MaintainPlan)map.get(MaintainTaskMeta.MAINTAIN_PLAN));
				this.setExecutor( (Employee)map.get(MaintainTaskMeta.EXECUTOR));
				this.setOriginator( (Employee)map.get(MaintainTaskMeta.ORIGINATOR));
				this.setAsset( (Asset)map.get(MaintainTaskMeta.ASSET));
				this.setMaintainTypeDict( (DictItem)map.get(MaintainTaskMeta.MAINTAIN_TYPE_DICT));
				this.setMaintainGroup( (MaintainGroup)map.get(MaintainTaskMeta.MAINTAIN_GROUP));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.NOTES)));
			this.setAssetPos(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.ASSET_POS)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.GROUP_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.CONTENT)));
			this.setTimeout(DataParser.parse(BigDecimal.class, r.getValue(MaintainTaskMeta.TIMEOUT)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.BUSINESS_CODE)));
			this.setActStartTime(DataParser.parse(Date.class, r.getValue(MaintainTaskMeta.ACT_START_TIME)));
			this.setOverdue(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.OVERDUE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.UPDATE_BY)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.ASSET_ID)));
			this.setAssetSn(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.ASSET_SN)));
			this.setPlanId(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.ORIGINATOR_ID)));
			this.setMaintainType(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.MAINTAIN_TYPE)));
			this.setActFinishTime(DataParser.parse(Date.class, r.getValue(MaintainTaskMeta.ACT_FINISH_TIME)));
			this.setAssetCode(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.ASSET_CODE)));
			this.setCost(DataParser.parse(BigDecimal.class, r.getValue(MaintainTaskMeta.COST)));
			this.setPlanStartTime(DataParser.parse(Date.class, r.getValue(MaintainTaskMeta.PLAN_START_TIME)));
			this.setExecutorId(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.EXECUTOR_ID)));
			this.setAssetModel(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.ASSET_MODEL)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(MaintainTaskMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(MaintainTaskMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(MaintainTaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(MaintainTaskMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(MaintainTaskMeta.DELETE_TIME)));
			this.setActTotalCost(DataParser.parse(BigDecimal.class, r.getValue(MaintainTaskMeta.ACT_TOTAL_COST)));
			this.setName(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.TENANT_ID)));
			this.setAssetName(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.ASSET_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.DELETE_BY)));
			this.setAssetStatus(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.ASSET_STATUS)));
			this.setTotalCost(DataParser.parse(BigDecimal.class, r.getValue(MaintainTaskMeta.TOTAL_COST)));
			this.setStatus(DataParser.parse(String.class, r.getValue(MaintainTaskMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(MaintainTaskMeta.NOTES));
				this.setAssetPos( (String)r.getValue(MaintainTaskMeta.ASSET_POS));
				this.setGroupId( (String)r.getValue(MaintainTaskMeta.GROUP_ID));
				this.setSelectedCode( (String)r.getValue(MaintainTaskMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(MaintainTaskMeta.CONTENT));
				this.setTimeout( (BigDecimal)r.getValue(MaintainTaskMeta.TIMEOUT));
				this.setBusinessCode( (String)r.getValue(MaintainTaskMeta.BUSINESS_CODE));
				this.setActStartTime( (Date)r.getValue(MaintainTaskMeta.ACT_START_TIME));
				this.setOverdue( (String)r.getValue(MaintainTaskMeta.OVERDUE));
				this.setUpdateBy( (String)r.getValue(MaintainTaskMeta.UPDATE_BY));
				this.setAssetId( (String)r.getValue(MaintainTaskMeta.ASSET_ID));
				this.setAssetSn( (String)r.getValue(MaintainTaskMeta.ASSET_SN));
				this.setPlanId( (String)r.getValue(MaintainTaskMeta.PLAN_ID));
				this.setId( (String)r.getValue(MaintainTaskMeta.ID));
				this.setOriginatorId( (String)r.getValue(MaintainTaskMeta.ORIGINATOR_ID));
				this.setMaintainType( (String)r.getValue(MaintainTaskMeta.MAINTAIN_TYPE));
				this.setActFinishTime( (Date)r.getValue(MaintainTaskMeta.ACT_FINISH_TIME));
				this.setAssetCode( (String)r.getValue(MaintainTaskMeta.ASSET_CODE));
				this.setCost( (BigDecimal)r.getValue(MaintainTaskMeta.COST));
				this.setPlanStartTime( (Date)r.getValue(MaintainTaskMeta.PLAN_START_TIME));
				this.setExecutorId( (String)r.getValue(MaintainTaskMeta.EXECUTOR_ID));
				this.setAssetModel( (String)r.getValue(MaintainTaskMeta.ASSET_MODEL));
				this.setUpdateTime( (Date)r.getValue(MaintainTaskMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(MaintainTaskMeta.VERSION));
				this.setCreateBy( (String)r.getValue(MaintainTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(MaintainTaskMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(MaintainTaskMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(MaintainTaskMeta.DELETE_TIME));
				this.setActTotalCost( (BigDecimal)r.getValue(MaintainTaskMeta.ACT_TOTAL_COST));
				this.setName( (String)r.getValue(MaintainTaskMeta.NAME));
				this.setTenantId( (String)r.getValue(MaintainTaskMeta.TENANT_ID));
				this.setAssetName( (String)r.getValue(MaintainTaskMeta.ASSET_NAME));
				this.setDeleteBy( (String)r.getValue(MaintainTaskMeta.DELETE_BY));
				this.setAssetStatus( (String)r.getValue(MaintainTaskMeta.ASSET_STATUS));
				this.setTotalCost( (BigDecimal)r.getValue(MaintainTaskMeta.TOTAL_COST));
				this.setStatus( (String)r.getValue(MaintainTaskMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}