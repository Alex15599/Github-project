package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_PLAN;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.InspectionPlanMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检计划
 * <p>巡检计划 , 数据表 eam_inspection_plan 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-12 21:22:49
 * @sign 6FBD0C95F2995FEC17B9966D5022DFA9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_plan")
@ApiModel(description = "巡检计划 ; 巡检计划 , 数据表 eam_inspection_plan 的PO类型")
public class InspectionPlan extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_PLAN.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "697561212996550656")
	private String id;
	
	/**
	 * 计划编号：计划编号
	*/
	@ApiModelProperty(required = false,value="计划编号" , notes = "计划编号" , example = "INSP202304092104919")
	private String planCode;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "模版")
	private String name;
	
	/**
	 * 办理状态：办理状态
	*/
	@ApiModelProperty(required = false,value="办理状态" , notes = "办理状态" , example = "stop")
	private String status;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "acting")
	private String planStatus;
	
	/**
	 * 计划类型：计划类型
	*/
	@ApiModelProperty(required = false,value="计划类型" , notes = "计划类型" , example = "inspection")
	private String planType;
	
	/**
	 * 负责人：负责人
	*/
	@ApiModelProperty(required = false,value="负责人" , notes = "负责人")
	private String leaderId;
	
	/**
	 * 班组：班组
	*/
	@ApiModelProperty(required = false,value="班组" , notes = "班组" , example = "571667627504570368")
	private String groupId;
	
	/**
	 * 开始日期：开始日期
	*/
	@ApiModelProperty(required = false,value="开始日期" , notes = "开始日期" , example = "2023-04-09 12:00:00")
	private Date startDate;
	
	/**
	 * 截止日期：截止日期
	*/
	@ApiModelProperty(required = false,value="截止日期" , notes = "截止日期" , example = "2023-04-09 12:00:00")
	private Date endDate;
	
	/**
	 * 周期：周期
	*/
	@ApiModelProperty(required = false,value="周期" , notes = "周期")
	private String actionCycleId;
	
	/**
	 * 巡检顺序：巡检顺序
	*/
	@ApiModelProperty(required = false,value="巡检顺序" , notes = "巡检顺序" , example = "random")
	private String inspectionMethod;
	
	/**
	 * 时间要求：小时)
	*/
	@ApiModelProperty(required = false,value="时间要求" , notes = "小时)" , example = "2.00")
	private BigDecimal completionTime;
	
	/**
	 * 超时处理：超时处理
	*/
	@ApiModelProperty(required = false,value="超时处理" , notes = "超时处理" , example = "not_handle")
	private String overtimeMethod;
	
	/**
	 * 提醒时间：小时)
	*/
	@ApiModelProperty(required = false,value="提醒时间" , notes = "小时)" , example = "2.00")
	private BigDecimal remindTime;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "yujk")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-04-09 09:39:13")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-04-09 10:15:20")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "2")
	private Integer version;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择" , example = "1681049719000")
	private String selectedCode;
	
	/**
	 * 班组：班组
	*/
	@ApiModelProperty(required = false,value="班组" , notes = "班组")
	private InspectionGroup inspectionGroup;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private DictItem inspectionTypeDict;
	
	/**
	 * 周期：周期
	*/
	@ApiModelProperty(required = false,value="周期" , notes = "周期")
	private ActionCrontab actionCrontab;
	
	/**
	 * 巡检点：巡检点
	*/
	@ApiModelProperty(required = false,value="巡检点" , notes = "巡检点")
	private List<InspectionPlanPoint> inspectionPlanPointList;
	
	/**
	 * 巡检点：巡检点
	*/
	@ApiModelProperty(required = false,value="巡检点" , notes = "巡检点")
	private List<String> inspectionPlanPointIds;
	
	/**
	 * 巡检点：巡检点
	*/
	@ApiModelProperty(required = false,value="巡检点" , notes = "巡检点")
	private List<InspectionPointOwner> inspectionPointOwnerList;
	
	/**
	 * 巡检点：巡检点
	*/
	@ApiModelProperty(required = false,value="巡检点" , notes = "巡检点")
	private List<String> inspectionPointOwnerIds;
	
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
	public InspectionPlan setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 计划编号<br>
	 * 计划编号
	 * @return 计划编号
	*/
	public String getPlanCode() {
		return planCode;
	}
	
	/**
	 * 设置 计划编号
	 * @param planCode 计划编号
	 * @return 当前对象
	*/
	public InspectionPlan setPlanCode(String planCode) {
		this.planCode=planCode;
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
	public InspectionPlan setName(String name) {
		this.name=name;
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
	public InspectionPlan setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getPlanStatus() {
		return planStatus;
	}
	
	/**
	 * 设置 状态
	 * @param planStatus 状态
	 * @return 当前对象
	*/
	public InspectionPlan setPlanStatus(String planStatus) {
		this.planStatus=planStatus;
		return this;
	}
	
	/**
	 * 获得 计划类型<br>
	 * 计划类型
	 * @return 计划类型
	*/
	public String getPlanType() {
		return planType;
	}
	
	/**
	 * 设置 计划类型
	 * @param planType 计划类型
	 * @return 当前对象
	*/
	public InspectionPlan setPlanType(String planType) {
		this.planType=planType;
		return this;
	}
	
	/**
	 * 获得 负责人<br>
	 * 负责人
	 * @return 负责人
	*/
	public String getLeaderId() {
		return leaderId;
	}
	
	/**
	 * 设置 负责人
	 * @param leaderId 负责人
	 * @return 当前对象
	*/
	public InspectionPlan setLeaderId(String leaderId) {
		this.leaderId=leaderId;
		return this;
	}
	
	/**
	 * 获得 班组<br>
	 * 班组
	 * @return 班组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 班组
	 * @param groupId 班组
	 * @return 当前对象
	*/
	public InspectionPlan setGroupId(String groupId) {
		this.groupId=groupId;
		return this;
	}
	
	/**
	 * 获得 开始日期<br>
	 * 开始日期
	 * @return 开始日期
	*/
	public Date getStartDate() {
		return startDate;
	}
	
	/**
	 * 设置 开始日期
	 * @param startDate 开始日期
	 * @return 当前对象
	*/
	public InspectionPlan setStartDate(Date startDate) {
		this.startDate=startDate;
		return this;
	}
	
	/**
	 * 获得 截止日期<br>
	 * 截止日期
	 * @return 截止日期
	*/
	public Date getEndDate() {
		return endDate;
	}
	
	/**
	 * 设置 截止日期
	 * @param endDate 截止日期
	 * @return 当前对象
	*/
	public InspectionPlan setEndDate(Date endDate) {
		this.endDate=endDate;
		return this;
	}
	
	/**
	 * 获得 周期<br>
	 * 周期
	 * @return 周期
	*/
	public String getActionCycleId() {
		return actionCycleId;
	}
	
	/**
	 * 设置 周期
	 * @param actionCycleId 周期
	 * @return 当前对象
	*/
	public InspectionPlan setActionCycleId(String actionCycleId) {
		this.actionCycleId=actionCycleId;
		return this;
	}
	
	/**
	 * 获得 巡检顺序<br>
	 * 巡检顺序
	 * @return 巡检顺序
	*/
	public String getInspectionMethod() {
		return inspectionMethod;
	}
	
	/**
	 * 设置 巡检顺序
	 * @param inspectionMethod 巡检顺序
	 * @return 当前对象
	*/
	public InspectionPlan setInspectionMethod(String inspectionMethod) {
		this.inspectionMethod=inspectionMethod;
		return this;
	}
	
	/**
	 * 获得 时间要求<br>
	 * 小时)
	 * @return 时间要求
	*/
	public BigDecimal getCompletionTime() {
		return completionTime;
	}
	
	/**
	 * 设置 时间要求
	 * @param completionTime 时间要求
	 * @return 当前对象
	*/
	public InspectionPlan setCompletionTime(BigDecimal completionTime) {
		this.completionTime=completionTime;
		return this;
	}
	
	/**
	 * 获得 超时处理<br>
	 * 超时处理
	 * @return 超时处理
	*/
	public String getOvertimeMethod() {
		return overtimeMethod;
	}
	
	/**
	 * 设置 超时处理
	 * @param overtimeMethod 超时处理
	 * @return 当前对象
	*/
	public InspectionPlan setOvertimeMethod(String overtimeMethod) {
		this.overtimeMethod=overtimeMethod;
		return this;
	}
	
	/**
	 * 获得 提醒时间<br>
	 * 小时)
	 * @return 提醒时间
	*/
	public BigDecimal getRemindTime() {
		return remindTime;
	}
	
	/**
	 * 设置 提醒时间
	 * @param remindTime 提醒时间
	 * @return 当前对象
	*/
	public InspectionPlan setRemindTime(BigDecimal remindTime) {
		this.remindTime=remindTime;
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
	public InspectionPlan setNotes(String notes) {
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
	public InspectionPlan setCreateBy(String createBy) {
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
	public InspectionPlan setCreateTime(Date createTime) {
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
	public InspectionPlan setUpdateBy(String updateBy) {
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
	public InspectionPlan setUpdateTime(Date updateTime) {
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
	public InspectionPlan setDeleted(Integer deleted) {
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
	public InspectionPlan setDeleted(Boolean deletedBool) {
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
	public InspectionPlan setDeleteBy(String deleteBy) {
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
	public InspectionPlan setDeleteTime(Date deleteTime) {
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
	public InspectionPlan setTenantId(String tenantId) {
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
	public InspectionPlan setVersion(Integer version) {
		this.version=version;
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
	public InspectionPlan setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 班组<br>
	 * 班组
	 * @return 班组
	*/
	public InspectionGroup getInspectionGroup() {
		return inspectionGroup;
	}
	
	/**
	 * 设置 班组
	 * @param inspectionGroup 班组
	 * @return 当前对象
	*/
	public InspectionPlan setInspectionGroup(InspectionGroup inspectionGroup) {
		this.inspectionGroup=inspectionGroup;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public DictItem getInspectionTypeDict() {
		return inspectionTypeDict;
	}
	
	/**
	 * 设置 类型
	 * @param inspectionTypeDict 类型
	 * @return 当前对象
	*/
	public InspectionPlan setInspectionTypeDict(DictItem inspectionTypeDict) {
		this.inspectionTypeDict=inspectionTypeDict;
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
	public InspectionPlan setActionCrontab(ActionCrontab actionCrontab) {
		this.actionCrontab=actionCrontab;
		return this;
	}
	
	/**
	 * 获得 巡检点<br>
	 * 巡检点
	 * @return 巡检点
	*/
	public List<InspectionPlanPoint> getInspectionPlanPointList() {
		return inspectionPlanPointList;
	}
	
	/**
	 * 设置 巡检点
	 * @param inspectionPlanPointList 巡检点
	 * @return 当前对象
	*/
	public InspectionPlan setInspectionPlanPointList(List<InspectionPlanPoint> inspectionPlanPointList) {
		this.inspectionPlanPointList=inspectionPlanPointList;
		return this;
	}
	
	/**
	 * 添加 巡检点
	 * @param inspectionPlanPoint 巡检点
	 * @return 当前对象
	*/
	public InspectionPlan addInspectionPlanPoint(InspectionPlanPoint... inspectionPlanPoint) {
		if(this.inspectionPlanPointList==null) inspectionPlanPointList=new ArrayList<>();
		this.inspectionPlanPointList.addAll(Arrays.asList(inspectionPlanPoint));
		return this;
	}
	
	/**
	 * 获得 巡检点<br>
	 * 巡检点
	 * @return 巡检点
	*/
	public List<String> getInspectionPlanPointIds() {
		return inspectionPlanPointIds;
	}
	
	/**
	 * 设置 巡检点
	 * @param inspectionPlanPointIds 巡检点
	 * @return 当前对象
	*/
	public InspectionPlan setInspectionPlanPointIds(List<String> inspectionPlanPointIds) {
		this.inspectionPlanPointIds=inspectionPlanPointIds;
		return this;
	}
	
	/**
	 * 添加 巡检点
	 * @param inspectionPlanPointId 巡检点
	 * @return 当前对象
	*/
	public InspectionPlan addInspectionPlanPointId(String... inspectionPlanPointId) {
		if(this.inspectionPlanPointIds==null) inspectionPlanPointIds=new ArrayList<>();
		this.inspectionPlanPointIds.addAll(Arrays.asList(inspectionPlanPointId));
		return this;
	}
	
	/**
	 * 获得 巡检点<br>
	 * 巡检点
	 * @return 巡检点
	*/
	public List<InspectionPointOwner> getInspectionPointOwnerList() {
		return inspectionPointOwnerList;
	}
	
	/**
	 * 设置 巡检点
	 * @param inspectionPointOwnerList 巡检点
	 * @return 当前对象
	*/
	public InspectionPlan setInspectionPointOwnerList(List<InspectionPointOwner> inspectionPointOwnerList) {
		this.inspectionPointOwnerList=inspectionPointOwnerList;
		return this;
	}
	
	/**
	 * 添加 巡检点
	 * @param inspectionPointOwner 巡检点
	 * @return 当前对象
	*/
	public InspectionPlan addInspectionPointOwner(InspectionPointOwner... inspectionPointOwner) {
		if(this.inspectionPointOwnerList==null) inspectionPointOwnerList=new ArrayList<>();
		this.inspectionPointOwnerList.addAll(Arrays.asList(inspectionPointOwner));
		return this;
	}
	
	/**
	 * 获得 巡检点<br>
	 * 巡检点
	 * @return 巡检点
	*/
	public List<String> getInspectionPointOwnerIds() {
		return inspectionPointOwnerIds;
	}
	
	/**
	 * 设置 巡检点
	 * @param inspectionPointOwnerIds 巡检点
	 * @return 当前对象
	*/
	public InspectionPlan setInspectionPointOwnerIds(List<String> inspectionPointOwnerIds) {
		this.inspectionPointOwnerIds=inspectionPointOwnerIds;
		return this;
	}
	
	/**
	 * 添加 巡检点
	 * @param inspectionPointOwnerId 巡检点
	 * @return 当前对象
	*/
	public InspectionPlan addInspectionPointOwnerId(String... inspectionPointOwnerId) {
		if(this.inspectionPointOwnerIds==null) inspectionPointOwnerIds=new ArrayList<>();
		this.inspectionPointOwnerIds.addAll(Arrays.asList(inspectionPointOwnerId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionPlan , 转换好的 InspectionPlan 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionPlan , 转换好的 PoJo 对象
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
	public InspectionPlan clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InspectionPlan duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InspectionPlanMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InspectionPlanMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setEndDate(this.getEndDate());
		inst.setGroupId(this.getGroupId());
		inst.setPlanStatus(this.getPlanStatus());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setLeaderId(this.getLeaderId());
		inst.setCompletionTime(this.getCompletionTime());
		inst.setRemindTime(this.getRemindTime());
		inst.setOvertimeMethod(this.getOvertimeMethod());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setInspectionMethod(this.getInspectionMethod());
		inst.setPlanType(this.getPlanType());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setActionCycleId(this.getActionCycleId());
		inst.setVersion(this.getVersion());
		inst.setPlanCode(this.getPlanCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStartDate(this.getStartDate());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setActionCrontab(this.getActionCrontab());
			inst.setInspectionPointOwnerIds(this.getInspectionPointOwnerIds());
			inst.setInspectionTypeDict(this.getInspectionTypeDict());
			inst.setInspectionPointOwnerList(this.getInspectionPointOwnerList());
			inst.setInspectionPlanPointList(this.getInspectionPlanPointList());
			inst.setInspectionGroup(this.getInspectionGroup());
			inst.setInspectionPlanPointIds(this.getInspectionPlanPointIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InspectionPlan clone(boolean deep) {
		return EntityContext.clone(InspectionPlan.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InspectionPlan
	 * @param inspectionPlanMap 包含实体信息的 Map 对象
	 * @return InspectionPlan , 转换好的的 InspectionPlan 对象
	*/
	@Transient
	public static InspectionPlan createFrom(Map<String,Object> inspectionPlanMap) {
		if(inspectionPlanMap==null) return null;
		InspectionPlan po = create();
		EntityContext.copyProperties(po,inspectionPlanMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionPlan
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionPlan , 转换好的的 InspectionPlan 对象
	*/
	@Transient
	public static InspectionPlan createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionPlan po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InspectionPlan，等同于 new
	 * @return InspectionPlan 对象
	*/
	@Transient
	public static InspectionPlan create() {
		return new com.dt.platform.domain.eam.meta.InspectionPlanMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(InspectionPlanMeta.NOTES)));
			this.setEndDate(DataParser.parse(Date.class, map.get(InspectionPlanMeta.END_DATE)));
			this.setGroupId(DataParser.parse(String.class, map.get(InspectionPlanMeta.GROUP_ID)));
			this.setPlanStatus(DataParser.parse(String.class, map.get(InspectionPlanMeta.PLAN_STATUS)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(InspectionPlanMeta.SELECTED_CODE)));
			this.setLeaderId(DataParser.parse(String.class, map.get(InspectionPlanMeta.LEADER_ID)));
			this.setCompletionTime(DataParser.parse(BigDecimal.class, map.get(InspectionPlanMeta.COMPLETION_TIME)));
			this.setRemindTime(DataParser.parse(BigDecimal.class, map.get(InspectionPlanMeta.REMIND_TIME)));
			this.setOvertimeMethod(DataParser.parse(String.class, map.get(InspectionPlanMeta.OVERTIME_METHOD)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InspectionPlanMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(InspectionPlanMeta.ID)));
			this.setInspectionMethod(DataParser.parse(String.class, map.get(InspectionPlanMeta.INSPECTION_METHOD)));
			this.setPlanType(DataParser.parse(String.class, map.get(InspectionPlanMeta.PLAN_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InspectionPlanMeta.UPDATE_TIME)));
			this.setActionCycleId(DataParser.parse(String.class, map.get(InspectionPlanMeta.ACTION_CYCLE_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InspectionPlanMeta.VERSION)));
			this.setPlanCode(DataParser.parse(String.class, map.get(InspectionPlanMeta.PLAN_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InspectionPlanMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InspectionPlanMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InspectionPlanMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InspectionPlanMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(InspectionPlanMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(InspectionPlanMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InspectionPlanMeta.DELETE_BY)));
			this.setStartDate(DataParser.parse(Date.class, map.get(InspectionPlanMeta.START_DATE)));
			this.setStatus(DataParser.parse(String.class, map.get(InspectionPlanMeta.STATUS)));
			// others
			this.setActionCrontab(DataParser.parse(ActionCrontab.class, map.get(InspectionPlanMeta.ACTION_CRONTAB)));
			this.setInspectionTypeDict(DataParser.parse(DictItem.class, map.get(InspectionPlanMeta.INSPECTION_TYPE_DICT)));
			this.setInspectionGroup(DataParser.parse(InspectionGroup.class, map.get(InspectionPlanMeta.INSPECTION_GROUP)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(InspectionPlanMeta.NOTES));
				this.setEndDate( (Date)map.get(InspectionPlanMeta.END_DATE));
				this.setGroupId( (String)map.get(InspectionPlanMeta.GROUP_ID));
				this.setPlanStatus( (String)map.get(InspectionPlanMeta.PLAN_STATUS));
				this.setSelectedCode( (String)map.get(InspectionPlanMeta.SELECTED_CODE));
				this.setLeaderId( (String)map.get(InspectionPlanMeta.LEADER_ID));
				this.setCompletionTime( (BigDecimal)map.get(InspectionPlanMeta.COMPLETION_TIME));
				this.setRemindTime( (BigDecimal)map.get(InspectionPlanMeta.REMIND_TIME));
				this.setOvertimeMethod( (String)map.get(InspectionPlanMeta.OVERTIME_METHOD));
				this.setUpdateBy( (String)map.get(InspectionPlanMeta.UPDATE_BY));
				this.setId( (String)map.get(InspectionPlanMeta.ID));
				this.setInspectionMethod( (String)map.get(InspectionPlanMeta.INSPECTION_METHOD));
				this.setPlanType( (String)map.get(InspectionPlanMeta.PLAN_TYPE));
				this.setUpdateTime( (Date)map.get(InspectionPlanMeta.UPDATE_TIME));
				this.setActionCycleId( (String)map.get(InspectionPlanMeta.ACTION_CYCLE_ID));
				this.setVersion( (Integer)map.get(InspectionPlanMeta.VERSION));
				this.setPlanCode( (String)map.get(InspectionPlanMeta.PLAN_CODE));
				this.setCreateBy( (String)map.get(InspectionPlanMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InspectionPlanMeta.DELETED));
				this.setCreateTime( (Date)map.get(InspectionPlanMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(InspectionPlanMeta.DELETE_TIME));
				this.setName( (String)map.get(InspectionPlanMeta.NAME));
				this.setTenantId( (String)map.get(InspectionPlanMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InspectionPlanMeta.DELETE_BY));
				this.setStartDate( (Date)map.get(InspectionPlanMeta.START_DATE));
				this.setStatus( (String)map.get(InspectionPlanMeta.STATUS));
				// others
				this.setActionCrontab( (ActionCrontab)map.get(InspectionPlanMeta.ACTION_CRONTAB));
				this.setInspectionTypeDict( (DictItem)map.get(InspectionPlanMeta.INSPECTION_TYPE_DICT));
				this.setInspectionGroup( (InspectionGroup)map.get(InspectionPlanMeta.INSPECTION_GROUP));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.NOTES)));
			this.setEndDate(DataParser.parse(Date.class, r.getValue(InspectionPlanMeta.END_DATE)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.GROUP_ID)));
			this.setPlanStatus(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.PLAN_STATUS)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.SELECTED_CODE)));
			this.setLeaderId(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.LEADER_ID)));
			this.setCompletionTime(DataParser.parse(BigDecimal.class, r.getValue(InspectionPlanMeta.COMPLETION_TIME)));
			this.setRemindTime(DataParser.parse(BigDecimal.class, r.getValue(InspectionPlanMeta.REMIND_TIME)));
			this.setOvertimeMethod(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.OVERTIME_METHOD)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.ID)));
			this.setInspectionMethod(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.INSPECTION_METHOD)));
			this.setPlanType(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.PLAN_TYPE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InspectionPlanMeta.UPDATE_TIME)));
			this.setActionCycleId(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.ACTION_CYCLE_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InspectionPlanMeta.VERSION)));
			this.setPlanCode(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.PLAN_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InspectionPlanMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InspectionPlanMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InspectionPlanMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.DELETE_BY)));
			this.setStartDate(DataParser.parse(Date.class, r.getValue(InspectionPlanMeta.START_DATE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(InspectionPlanMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(InspectionPlanMeta.NOTES));
				this.setEndDate( (Date)r.getValue(InspectionPlanMeta.END_DATE));
				this.setGroupId( (String)r.getValue(InspectionPlanMeta.GROUP_ID));
				this.setPlanStatus( (String)r.getValue(InspectionPlanMeta.PLAN_STATUS));
				this.setSelectedCode( (String)r.getValue(InspectionPlanMeta.SELECTED_CODE));
				this.setLeaderId( (String)r.getValue(InspectionPlanMeta.LEADER_ID));
				this.setCompletionTime( (BigDecimal)r.getValue(InspectionPlanMeta.COMPLETION_TIME));
				this.setRemindTime( (BigDecimal)r.getValue(InspectionPlanMeta.REMIND_TIME));
				this.setOvertimeMethod( (String)r.getValue(InspectionPlanMeta.OVERTIME_METHOD));
				this.setUpdateBy( (String)r.getValue(InspectionPlanMeta.UPDATE_BY));
				this.setId( (String)r.getValue(InspectionPlanMeta.ID));
				this.setInspectionMethod( (String)r.getValue(InspectionPlanMeta.INSPECTION_METHOD));
				this.setPlanType( (String)r.getValue(InspectionPlanMeta.PLAN_TYPE));
				this.setUpdateTime( (Date)r.getValue(InspectionPlanMeta.UPDATE_TIME));
				this.setActionCycleId( (String)r.getValue(InspectionPlanMeta.ACTION_CYCLE_ID));
				this.setVersion( (Integer)r.getValue(InspectionPlanMeta.VERSION));
				this.setPlanCode( (String)r.getValue(InspectionPlanMeta.PLAN_CODE));
				this.setCreateBy( (String)r.getValue(InspectionPlanMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InspectionPlanMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(InspectionPlanMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(InspectionPlanMeta.DELETE_TIME));
				this.setName( (String)r.getValue(InspectionPlanMeta.NAME));
				this.setTenantId( (String)r.getValue(InspectionPlanMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InspectionPlanMeta.DELETE_BY));
				this.setStartDate( (Date)r.getValue(InspectionPlanMeta.START_DATE));
				this.setStatus( (String)r.getValue(InspectionPlanMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}