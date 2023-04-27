package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_TASK;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
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
import com.dt.platform.domain.eam.meta.InspectionTaskMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检任务
 * <p>巡检任务 , 数据表 eam_inspection_task 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-14 07:30:19
 * @sign A0A137B1407B3775EBF078093B3E3696
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_task")
@ApiModel(description = "巡检任务 ; 巡检任务 , 数据表 eam_inspection_task 的PO类型")
public class InspectionTask extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_TASK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "697562178361753600")
	private String id;
	
	/**
	 * 巡检计划：巡检计划
	*/
	@ApiModelProperty(required = false,value="巡检计划" , notes = "巡检计划" , example = "697561212996550656")
	private String planId;
	
	/**
	 * 任务状态：任务状态
	*/
	@ApiModelProperty(required = false,value="任务状态" , notes = "任务状态" , example = "not_start")
	private String taskStatus;
	
	/**
	 * 任务单据：任务单据
	*/
	@ApiModelProperty(required = false,value="任务单据" , notes = "任务单据" , example = "INSPT202304092104809")
	private String taskCode;
	
	/**
	 * 巡检编码：巡检编码
	*/
	@ApiModelProperty(required = false,value="巡检编码" , notes = "巡检编码" , example = "INSP202304092104919")
	private String planCode;
	
	/**
	 * 巡检名称：巡检名称
	*/
	@ApiModelProperty(required = false,value="巡检名称" , notes = "巡检名称" , example = "模版")
	private String planName;
	
	/**
	 * 巡检顺序：巡检顺序
	*/
	@ApiModelProperty(required = false,value="巡检顺序" , notes = "巡检顺序" , example = "random")
	private String planInspectionMethod;
	
	/**
	 * 时间要求：时间要求
	*/
	@ApiModelProperty(required = false,value="时间要求" , notes = "时间要求" , example = "2.00")
	private BigDecimal planCompletionTime;
	
	/**
	 * 巡检备注：巡检备注
	*/
	@ApiModelProperty(required = false,value="巡检备注" , notes = "巡检备注" , example = "yujk")
	private String planNotes;
	
	/**
	 * 巡检班组：巡检班组
	*/
	@ApiModelProperty(required = true,value="巡检班组" , notes = "巡检班组" , example = "571667627504570368")
	private String groupId;
	
	/**
	 * 执行人：执行人
	*/
	@ApiModelProperty(required = false,value="执行人" , notes = "执行人")
	private String executorId;
	
	/**
	 * 应开始时间：应开始时间
	*/
	@ApiModelProperty(required = false,value="应开始时间" , notes = "应开始时间" , example = "2023-04-09 09:43:03")
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
	 * 实际工时：实际工时
	*/
	@ApiModelProperty(required = false,value="实际工时" , notes = "实际工时" , example = "0.00")
	private BigDecimal actTotalCost;
	
	/**
	 * 任务反馈：任务反馈
	*/
	@ApiModelProperty(required = false,value="任务反馈" , notes = "任务反馈")
	private String content;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-04-09 09:43:03")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-04-10 07:27:14")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "1")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID" , example = "110588348101165911")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间" , example = "2023-04-10 07:27:14")
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
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * 计划：计划
	*/
	@ApiModelProperty(required = false,value="计划" , notes = "计划")
	private InspectionPlan inspectionPlan;
	
	/**
	 * 巡检点：巡检点
	*/
	@ApiModelProperty(required = false,value="巡检点" , notes = "巡检点")
	private List<InspectionPoint> inspectionPointList;
	
	/**
	 * 巡检点：巡检点
	*/
	@ApiModelProperty(required = false,value="巡检点" , notes = "巡检点")
	private List<String> inspectionPointIds;
	
	/**
	 * 任务巡检点：任务巡检点
	*/
	@ApiModelProperty(required = false,value="任务巡检点" , notes = "任务巡检点")
	private List<InspectionTaskPoint> inspectionTaskPointList;
	
	/**
	 * 任务巡检点：任务巡检点
	*/
	@ApiModelProperty(required = false,value="任务巡检点" , notes = "任务巡检点")
	private List<String> inspectionTaskPointIds;
	
	/**
	 * 时间：时间
	*/
	@ApiModelProperty(required = false,value="时间" , notes = "时间")
	private DictItem timeDict;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private DictItem inspectionTypeDict;
	
	/**
	 * 班组：班组
	*/
	@ApiModelProperty(required = false,value="班组" , notes = "班组")
	private InspectionGroup inspectionGroup;
	
	/**
	 * inspectUserList：inspectUserList
	*/
	@ApiModelProperty(required = false,value="inspectUserList" , notes = "inspectUserList")
	private List<Employee> inspectUserList;
	
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
	public InspectionTask setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 巡检计划<br>
	 * 巡检计划
	 * @return 巡检计划
	*/
	public String getPlanId() {
		return planId;
	}
	
	/**
	 * 设置 巡检计划
	 * @param planId 巡检计划
	 * @return 当前对象
	*/
	public InspectionTask setPlanId(String planId) {
		this.planId=planId;
		return this;
	}
	
	/**
	 * 获得 任务状态<br>
	 * 任务状态
	 * @return 任务状态
	*/
	public String getTaskStatus() {
		return taskStatus;
	}
	
	/**
	 * 设置 任务状态
	 * @param taskStatus 任务状态
	 * @return 当前对象
	*/
	public InspectionTask setTaskStatus(String taskStatus) {
		this.taskStatus=taskStatus;
		return this;
	}
	
	/**
	 * 获得 任务单据<br>
	 * 任务单据
	 * @return 任务单据
	*/
	public String getTaskCode() {
		return taskCode;
	}
	
	/**
	 * 设置 任务单据
	 * @param taskCode 任务单据
	 * @return 当前对象
	*/
	public InspectionTask setTaskCode(String taskCode) {
		this.taskCode=taskCode;
		return this;
	}
	
	/**
	 * 获得 巡检编码<br>
	 * 巡检编码
	 * @return 巡检编码
	*/
	public String getPlanCode() {
		return planCode;
	}
	
	/**
	 * 设置 巡检编码
	 * @param planCode 巡检编码
	 * @return 当前对象
	*/
	public InspectionTask setPlanCode(String planCode) {
		this.planCode=planCode;
		return this;
	}
	
	/**
	 * 获得 巡检名称<br>
	 * 巡检名称
	 * @return 巡检名称
	*/
	public String getPlanName() {
		return planName;
	}
	
	/**
	 * 设置 巡检名称
	 * @param planName 巡检名称
	 * @return 当前对象
	*/
	public InspectionTask setPlanName(String planName) {
		this.planName=planName;
		return this;
	}
	
	/**
	 * 获得 巡检顺序<br>
	 * 巡检顺序
	 * @return 巡检顺序
	*/
	public String getPlanInspectionMethod() {
		return planInspectionMethod;
	}
	
	/**
	 * 设置 巡检顺序
	 * @param planInspectionMethod 巡检顺序
	 * @return 当前对象
	*/
	public InspectionTask setPlanInspectionMethod(String planInspectionMethod) {
		this.planInspectionMethod=planInspectionMethod;
		return this;
	}
	
	/**
	 * 获得 时间要求<br>
	 * 时间要求
	 * @return 时间要求
	*/
	public BigDecimal getPlanCompletionTime() {
		return planCompletionTime;
	}
	
	/**
	 * 设置 时间要求
	 * @param planCompletionTime 时间要求
	 * @return 当前对象
	*/
	public InspectionTask setPlanCompletionTime(BigDecimal planCompletionTime) {
		this.planCompletionTime=planCompletionTime;
		return this;
	}
	
	/**
	 * 获得 巡检备注<br>
	 * 巡检备注
	 * @return 巡检备注
	*/
	public String getPlanNotes() {
		return planNotes;
	}
	
	/**
	 * 设置 巡检备注
	 * @param planNotes 巡检备注
	 * @return 当前对象
	*/
	public InspectionTask setPlanNotes(String planNotes) {
		this.planNotes=planNotes;
		return this;
	}
	
	/**
	 * 获得 巡检班组<br>
	 * 巡检班组
	 * @return 巡检班组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 巡检班组
	 * @param groupId 巡检班组
	 * @return 当前对象
	*/
	public InspectionTask setGroupId(String groupId) {
		this.groupId=groupId;
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
	public InspectionTask setExecutorId(String executorId) {
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
	public InspectionTask setPlanStartTime(Date planStartTime) {
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
	public InspectionTask setActStartTime(Date actStartTime) {
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
	public InspectionTask setActFinishTime(Date actFinishTime) {
		this.actFinishTime=actFinishTime;
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
	public InspectionTask setActTotalCost(BigDecimal actTotalCost) {
		this.actTotalCost=actTotalCost;
		return this;
	}
	
	/**
	 * 获得 任务反馈<br>
	 * 任务反馈
	 * @return 任务反馈
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 任务反馈
	 * @param content 任务反馈
	 * @return 当前对象
	*/
	public InspectionTask setContent(String content) {
		this.content=content;
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
	public InspectionTask setNotes(String notes) {
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
	public InspectionTask setOriginatorId(String originatorId) {
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
	public InspectionTask setCreateBy(String createBy) {
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
	public InspectionTask setCreateTime(Date createTime) {
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
	public InspectionTask setUpdateBy(String updateBy) {
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
	public InspectionTask setUpdateTime(Date updateTime) {
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
	public InspectionTask setDeleted(Integer deleted) {
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
	public InspectionTask setDeleted(Boolean deletedBool) {
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
	public InspectionTask setDeleteBy(String deleteBy) {
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
	public InspectionTask setDeleteTime(Date deleteTime) {
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
	public InspectionTask setTenantId(String tenantId) {
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
	public InspectionTask setVersion(Integer version) {
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
	public InspectionTask setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 计划<br>
	 * 计划
	 * @return 计划
	*/
	public InspectionPlan getInspectionPlan() {
		return inspectionPlan;
	}
	
	/**
	 * 设置 计划
	 * @param inspectionPlan 计划
	 * @return 当前对象
	*/
	public InspectionTask setInspectionPlan(InspectionPlan inspectionPlan) {
		this.inspectionPlan=inspectionPlan;
		return this;
	}
	
	/**
	 * 获得 巡检点<br>
	 * 巡检点
	 * @return 巡检点
	*/
	public List<InspectionPoint> getInspectionPointList() {
		return inspectionPointList;
	}
	
	/**
	 * 设置 巡检点
	 * @param inspectionPointList 巡检点
	 * @return 当前对象
	*/
	public InspectionTask setInspectionPointList(List<InspectionPoint> inspectionPointList) {
		this.inspectionPointList=inspectionPointList;
		return this;
	}
	
	/**
	 * 添加 巡检点
	 * @param inspectionPoint 巡检点
	 * @return 当前对象
	*/
	public InspectionTask addInspectionPoint(InspectionPoint... inspectionPoint) {
		if(this.inspectionPointList==null) inspectionPointList=new ArrayList<>();
		this.inspectionPointList.addAll(Arrays.asList(inspectionPoint));
		return this;
	}
	
	/**
	 * 获得 巡检点<br>
	 * 巡检点
	 * @return 巡检点
	*/
	public List<String> getInspectionPointIds() {
		return inspectionPointIds;
	}
	
	/**
	 * 设置 巡检点
	 * @param inspectionPointIds 巡检点
	 * @return 当前对象
	*/
	public InspectionTask setInspectionPointIds(List<String> inspectionPointIds) {
		this.inspectionPointIds=inspectionPointIds;
		return this;
	}
	
	/**
	 * 添加 巡检点
	 * @param inspectionPointId 巡检点
	 * @return 当前对象
	*/
	public InspectionTask addInspectionPointId(String... inspectionPointId) {
		if(this.inspectionPointIds==null) inspectionPointIds=new ArrayList<>();
		this.inspectionPointIds.addAll(Arrays.asList(inspectionPointId));
		return this;
	}
	
	/**
	 * 获得 任务巡检点<br>
	 * 任务巡检点
	 * @return 任务巡检点
	*/
	public List<InspectionTaskPoint> getInspectionTaskPointList() {
		return inspectionTaskPointList;
	}
	
	/**
	 * 设置 任务巡检点
	 * @param inspectionTaskPointList 任务巡检点
	 * @return 当前对象
	*/
	public InspectionTask setInspectionTaskPointList(List<InspectionTaskPoint> inspectionTaskPointList) {
		this.inspectionTaskPointList=inspectionTaskPointList;
		return this;
	}
	
	/**
	 * 添加 任务巡检点
	 * @param inspectionTaskPoint 任务巡检点
	 * @return 当前对象
	*/
	public InspectionTask addInspectionTaskPoint(InspectionTaskPoint... inspectionTaskPoint) {
		if(this.inspectionTaskPointList==null) inspectionTaskPointList=new ArrayList<>();
		this.inspectionTaskPointList.addAll(Arrays.asList(inspectionTaskPoint));
		return this;
	}
	
	/**
	 * 获得 任务巡检点<br>
	 * 任务巡检点
	 * @return 任务巡检点
	*/
	public List<String> getInspectionTaskPointIds() {
		return inspectionTaskPointIds;
	}
	
	/**
	 * 设置 任务巡检点
	 * @param inspectionTaskPointIds 任务巡检点
	 * @return 当前对象
	*/
	public InspectionTask setInspectionTaskPointIds(List<String> inspectionTaskPointIds) {
		this.inspectionTaskPointIds=inspectionTaskPointIds;
		return this;
	}
	
	/**
	 * 添加 任务巡检点
	 * @param inspectionTaskPointId 任务巡检点
	 * @return 当前对象
	*/
	public InspectionTask addInspectionTaskPointId(String... inspectionTaskPointId) {
		if(this.inspectionTaskPointIds==null) inspectionTaskPointIds=new ArrayList<>();
		this.inspectionTaskPointIds.addAll(Arrays.asList(inspectionTaskPointId));
		return this;
	}
	
	/**
	 * 获得 时间<br>
	 * 时间
	 * @return 时间
	*/
	public DictItem getTimeDict() {
		return timeDict;
	}
	
	/**
	 * 设置 时间
	 * @param timeDict 时间
	 * @return 当前对象
	*/
	public InspectionTask setTimeDict(DictItem timeDict) {
		this.timeDict=timeDict;
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
	public InspectionTask setInspectionTypeDict(DictItem inspectionTypeDict) {
		this.inspectionTypeDict=inspectionTypeDict;
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
	public InspectionTask setInspectionGroup(InspectionGroup inspectionGroup) {
		this.inspectionGroup=inspectionGroup;
		return this;
	}
	
	/**
	 * 获得 inspectUserList<br>
	 * inspectUserList
	 * @return inspectUserList
	*/
	public List<Employee> getInspectUserList() {
		return inspectUserList;
	}
	
	/**
	 * 设置 inspectUserList
	 * @param inspectUserList inspectUserList
	 * @return 当前对象
	*/
	public InspectionTask setInspectUserList(List<Employee> inspectUserList) {
		this.inspectUserList=inspectUserList;
		return this;
	}
	
	/**
	 * 添加 inspectUserList
	 * @param inspectUser inspectUserList
	 * @return 当前对象
	*/
	public InspectionTask addInspectUser(Employee... inspectUser) {
		if(this.inspectUserList==null) inspectUserList=new ArrayList<>();
		this.inspectUserList.addAll(Arrays.asList(inspectUser));
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
	public InspectionTask setOriginator(Employee originator) {
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
	public InspectionTask setExecutor(Employee executor) {
		this.executor=executor;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionTask , 转换好的 InspectionTask 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionTask , 转换好的 PoJo 对象
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
	public InspectionTask clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InspectionTask duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InspectionTaskMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InspectionTaskMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setGroupId(this.getGroupId());
		inst.setPlanName(this.getPlanName());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setActStartTime(this.getActStartTime());
		inst.setTaskCode(this.getTaskCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setPlanId(this.getPlanId());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setPlanInspectionMethod(this.getPlanInspectionMethod());
		inst.setActFinishTime(this.getActFinishTime());
		inst.setTaskStatus(this.getTaskStatus());
		inst.setPlanStartTime(this.getPlanStartTime());
		inst.setExecutorId(this.getExecutorId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setPlanCode(this.getPlanCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setActTotalCost(this.getActTotalCost());
		inst.setPlanNotes(this.getPlanNotes());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPlanCompletionTime(this.getPlanCompletionTime());
		if(all) {
			inst.setInspectionPointList(this.getInspectionPointList());
			inst.setTimeDict(this.getTimeDict());
			inst.setExecutor(this.getExecutor());
			inst.setInspectionTypeDict(this.getInspectionTypeDict());
			inst.setInspectionPlan(this.getInspectionPlan());
			inst.setInspectionTaskPointList(this.getInspectionTaskPointList());
			inst.setInspectionTaskPointIds(this.getInspectionTaskPointIds());
			inst.setInspectUserList(this.getInspectUserList());
			inst.setOriginator(this.getOriginator());
			inst.setInspectionPointIds(this.getInspectionPointIds());
			inst.setInspectionGroup(this.getInspectionGroup());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InspectionTask clone(boolean deep) {
		return EntityContext.clone(InspectionTask.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InspectionTask
	 * @param inspectionTaskMap 包含实体信息的 Map 对象
	 * @return InspectionTask , 转换好的的 InspectionTask 对象
	*/
	@Transient
	public static InspectionTask createFrom(Map<String,Object> inspectionTaskMap) {
		if(inspectionTaskMap==null) return null;
		InspectionTask po = create();
		EntityContext.copyProperties(po,inspectionTaskMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionTask
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionTask , 转换好的的 InspectionTask 对象
	*/
	@Transient
	public static InspectionTask createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionTask po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InspectionTask，等同于 new
	 * @return InspectionTask 对象
	*/
	@Transient
	public static InspectionTask create() {
		return new com.dt.platform.domain.eam.meta.InspectionTaskMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(InspectionTaskMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, map.get(InspectionTaskMeta.GROUP_ID)));
			this.setPlanName(DataParser.parse(String.class, map.get(InspectionTaskMeta.PLAN_NAME)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(InspectionTaskMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(InspectionTaskMeta.CONTENT)));
			this.setActStartTime(DataParser.parse(Date.class, map.get(InspectionTaskMeta.ACT_START_TIME)));
			this.setTaskCode(DataParser.parse(String.class, map.get(InspectionTaskMeta.TASK_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InspectionTaskMeta.UPDATE_BY)));
			this.setPlanId(DataParser.parse(String.class, map.get(InspectionTaskMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, map.get(InspectionTaskMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(InspectionTaskMeta.ORIGINATOR_ID)));
			this.setPlanInspectionMethod(DataParser.parse(String.class, map.get(InspectionTaskMeta.PLAN_INSPECTION_METHOD)));
			this.setActFinishTime(DataParser.parse(Date.class, map.get(InspectionTaskMeta.ACT_FINISH_TIME)));
			this.setTaskStatus(DataParser.parse(String.class, map.get(InspectionTaskMeta.TASK_STATUS)));
			this.setPlanStartTime(DataParser.parse(Date.class, map.get(InspectionTaskMeta.PLAN_START_TIME)));
			this.setExecutorId(DataParser.parse(String.class, map.get(InspectionTaskMeta.EXECUTOR_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InspectionTaskMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InspectionTaskMeta.VERSION)));
			this.setPlanCode(DataParser.parse(String.class, map.get(InspectionTaskMeta.PLAN_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InspectionTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InspectionTaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InspectionTaskMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InspectionTaskMeta.DELETE_TIME)));
			this.setActTotalCost(DataParser.parse(BigDecimal.class, map.get(InspectionTaskMeta.ACT_TOTAL_COST)));
			this.setPlanNotes(DataParser.parse(String.class, map.get(InspectionTaskMeta.PLAN_NOTES)));
			this.setTenantId(DataParser.parse(String.class, map.get(InspectionTaskMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InspectionTaskMeta.DELETE_BY)));
			this.setPlanCompletionTime(DataParser.parse(BigDecimal.class, map.get(InspectionTaskMeta.PLAN_COMPLETION_TIME)));
			// others
			this.setTimeDict(DataParser.parse(DictItem.class, map.get(InspectionTaskMeta.TIME_DICT)));
			this.setExecutor(DataParser.parse(Employee.class, map.get(InspectionTaskMeta.EXECUTOR)));
			this.setInspectionTypeDict(DataParser.parse(DictItem.class, map.get(InspectionTaskMeta.INSPECTION_TYPE_DICT)));
			this.setInspectionPlan(DataParser.parse(InspectionPlan.class, map.get(InspectionTaskMeta.INSPECTION_PLAN)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(InspectionTaskMeta.ORIGINATOR)));
			this.setInspectionGroup(DataParser.parse(InspectionGroup.class, map.get(InspectionTaskMeta.INSPECTION_GROUP)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(InspectionTaskMeta.NOTES));
				this.setGroupId( (String)map.get(InspectionTaskMeta.GROUP_ID));
				this.setPlanName( (String)map.get(InspectionTaskMeta.PLAN_NAME));
				this.setSelectedCode( (String)map.get(InspectionTaskMeta.SELECTED_CODE));
				this.setContent( (String)map.get(InspectionTaskMeta.CONTENT));
				this.setActStartTime( (Date)map.get(InspectionTaskMeta.ACT_START_TIME));
				this.setTaskCode( (String)map.get(InspectionTaskMeta.TASK_CODE));
				this.setUpdateBy( (String)map.get(InspectionTaskMeta.UPDATE_BY));
				this.setPlanId( (String)map.get(InspectionTaskMeta.PLAN_ID));
				this.setId( (String)map.get(InspectionTaskMeta.ID));
				this.setOriginatorId( (String)map.get(InspectionTaskMeta.ORIGINATOR_ID));
				this.setPlanInspectionMethod( (String)map.get(InspectionTaskMeta.PLAN_INSPECTION_METHOD));
				this.setActFinishTime( (Date)map.get(InspectionTaskMeta.ACT_FINISH_TIME));
				this.setTaskStatus( (String)map.get(InspectionTaskMeta.TASK_STATUS));
				this.setPlanStartTime( (Date)map.get(InspectionTaskMeta.PLAN_START_TIME));
				this.setExecutorId( (String)map.get(InspectionTaskMeta.EXECUTOR_ID));
				this.setUpdateTime( (Date)map.get(InspectionTaskMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(InspectionTaskMeta.VERSION));
				this.setPlanCode( (String)map.get(InspectionTaskMeta.PLAN_CODE));
				this.setCreateBy( (String)map.get(InspectionTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InspectionTaskMeta.DELETED));
				this.setCreateTime( (Date)map.get(InspectionTaskMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(InspectionTaskMeta.DELETE_TIME));
				this.setActTotalCost( (BigDecimal)map.get(InspectionTaskMeta.ACT_TOTAL_COST));
				this.setPlanNotes( (String)map.get(InspectionTaskMeta.PLAN_NOTES));
				this.setTenantId( (String)map.get(InspectionTaskMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InspectionTaskMeta.DELETE_BY));
				this.setPlanCompletionTime( (BigDecimal)map.get(InspectionTaskMeta.PLAN_COMPLETION_TIME));
				// others
				this.setTimeDict( (DictItem)map.get(InspectionTaskMeta.TIME_DICT));
				this.setExecutor( (Employee)map.get(InspectionTaskMeta.EXECUTOR));
				this.setInspectionTypeDict( (DictItem)map.get(InspectionTaskMeta.INSPECTION_TYPE_DICT));
				this.setInspectionPlan( (InspectionPlan)map.get(InspectionTaskMeta.INSPECTION_PLAN));
				this.setOriginator( (Employee)map.get(InspectionTaskMeta.ORIGINATOR));
				this.setInspectionGroup( (InspectionGroup)map.get(InspectionTaskMeta.INSPECTION_GROUP));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.NOTES)));
			this.setGroupId(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.GROUP_ID)));
			this.setPlanName(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.PLAN_NAME)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.CONTENT)));
			this.setActStartTime(DataParser.parse(Date.class, r.getValue(InspectionTaskMeta.ACT_START_TIME)));
			this.setTaskCode(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.TASK_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.UPDATE_BY)));
			this.setPlanId(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.PLAN_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.ORIGINATOR_ID)));
			this.setPlanInspectionMethod(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.PLAN_INSPECTION_METHOD)));
			this.setActFinishTime(DataParser.parse(Date.class, r.getValue(InspectionTaskMeta.ACT_FINISH_TIME)));
			this.setTaskStatus(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.TASK_STATUS)));
			this.setPlanStartTime(DataParser.parse(Date.class, r.getValue(InspectionTaskMeta.PLAN_START_TIME)));
			this.setExecutorId(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.EXECUTOR_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InspectionTaskMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InspectionTaskMeta.VERSION)));
			this.setPlanCode(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.PLAN_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InspectionTaskMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InspectionTaskMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InspectionTaskMeta.DELETE_TIME)));
			this.setActTotalCost(DataParser.parse(BigDecimal.class, r.getValue(InspectionTaskMeta.ACT_TOTAL_COST)));
			this.setPlanNotes(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.PLAN_NOTES)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InspectionTaskMeta.DELETE_BY)));
			this.setPlanCompletionTime(DataParser.parse(BigDecimal.class, r.getValue(InspectionTaskMeta.PLAN_COMPLETION_TIME)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(InspectionTaskMeta.NOTES));
				this.setGroupId( (String)r.getValue(InspectionTaskMeta.GROUP_ID));
				this.setPlanName( (String)r.getValue(InspectionTaskMeta.PLAN_NAME));
				this.setSelectedCode( (String)r.getValue(InspectionTaskMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(InspectionTaskMeta.CONTENT));
				this.setActStartTime( (Date)r.getValue(InspectionTaskMeta.ACT_START_TIME));
				this.setTaskCode( (String)r.getValue(InspectionTaskMeta.TASK_CODE));
				this.setUpdateBy( (String)r.getValue(InspectionTaskMeta.UPDATE_BY));
				this.setPlanId( (String)r.getValue(InspectionTaskMeta.PLAN_ID));
				this.setId( (String)r.getValue(InspectionTaskMeta.ID));
				this.setOriginatorId( (String)r.getValue(InspectionTaskMeta.ORIGINATOR_ID));
				this.setPlanInspectionMethod( (String)r.getValue(InspectionTaskMeta.PLAN_INSPECTION_METHOD));
				this.setActFinishTime( (Date)r.getValue(InspectionTaskMeta.ACT_FINISH_TIME));
				this.setTaskStatus( (String)r.getValue(InspectionTaskMeta.TASK_STATUS));
				this.setPlanStartTime( (Date)r.getValue(InspectionTaskMeta.PLAN_START_TIME));
				this.setExecutorId( (String)r.getValue(InspectionTaskMeta.EXECUTOR_ID));
				this.setUpdateTime( (Date)r.getValue(InspectionTaskMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(InspectionTaskMeta.VERSION));
				this.setPlanCode( (String)r.getValue(InspectionTaskMeta.PLAN_CODE));
				this.setCreateBy( (String)r.getValue(InspectionTaskMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InspectionTaskMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(InspectionTaskMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(InspectionTaskMeta.DELETE_TIME));
				this.setActTotalCost( (BigDecimal)r.getValue(InspectionTaskMeta.ACT_TOTAL_COST));
				this.setPlanNotes( (String)r.getValue(InspectionTaskMeta.PLAN_NOTES));
				this.setTenantId( (String)r.getValue(InspectionTaskMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InspectionTaskMeta.DELETE_BY));
				this.setPlanCompletionTime( (BigDecimal)r.getValue(InspectionTaskMeta.PLAN_COMPLETION_TIME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}