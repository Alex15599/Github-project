package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_TASK_POINT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.InspectionTaskPointMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检点
 * <p>巡检点 , 数据表 eam_inspection_task_point 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-11 12:47:53
 * @sign BB247BF598F67C6419ECC5C306B2E9DB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_task_point")
@ApiModel(description = "巡检点 ; 巡检点 , 数据表 eam_inspection_task_point 的PO类型")
public class InspectionTaskPoint extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_TASK_POINT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "697562178735046656")
	private String id;
	
	/**
	 * 任务：任务
	*/
	@ApiModelProperty(required = false,value="任务" , notes = "任务" , example = "697562178361753600")
	private String taskId;
	
	/**
	 * 巡检状态：巡检状态
	*/
	@ApiModelProperty(required = false,value="巡检状态" , notes = "巡检状态" , example = "normal")
	private String pointStatus;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date operTime;
	
	/**
	 * 巡检结果：巡检结果
	*/
	@ApiModelProperty(required = false,value="巡检结果" , notes = "巡检结果")
	private String content;
	
	/**
	 * 巡检点：巡检点
	*/
	@ApiModelProperty(required = false,value="巡检点" , notes = "巡检点")
	private String pointId;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "point2")
	private String pointCode;
	
	/**
	 * 检：检
	*/
	@ApiModelProperty(required = false,value="检" , notes = "检" , example = "point2")
	private String pointName;
	
	/**
	 * 巡检内容：巡检内容
	*/
	@ApiModelProperty(required = false,value="巡检内容" , notes = "巡检内容")
	private String pointContent;
	
	/**
	 * 巡检路线：巡检路线
	*/
	@ApiModelProperty(required = false,value="巡检路线" , notes = "巡检路线" , example = "697560681343352832")
	private String pointRouteId;
	
	/**
	 * RFID：RFID
	*/
	@ApiModelProperty(required = false,value="RFID" , notes = "RFID")
	private String pointRfid;
	
	/**
	 * 位置详情：位置详情
	*/
	@ApiModelProperty(required = false,value="位置详情" , notes = "位置详情")
	private String pointPos;
	
	/**
	 * 位置：位置
	*/
	@ApiModelProperty(required = false,value="位置" , notes = "位置")
	private String pointPosId;
	
	/**
	 * 位置经度：位置经度
	*/
	@ApiModelProperty(required = false,value="位置经度" , notes = "位置经度" , example = "0.0")
	private String pointPosLongitude;
	
	/**
	 * 位置纬度：位置纬度
	*/
	@ApiModelProperty(required = false,value="位置纬度" , notes = "位置纬度" , example = "0.0")
	private String pointPosLatitude;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String pointNotes;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序" , example = "0")
	private Integer sort;
	
	/**
	 * 操作人：操作人
	*/
	@ApiModelProperty(required = false,value="操作人" , notes = "操作人")
	private String operId;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-04-09 09:43:04")
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
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * route：route
	*/
	@ApiModelProperty(required = false,value="route" , notes = "route")
	private InspectionRoute route;
	
	/**
	 * task：task
	*/
	@ApiModelProperty(required = false,value="task" , notes = "task")
	private InspectionTask task;
	
	/**
	 * operUser：operUser
	*/
	@ApiModelProperty(required = false,value="operUser" , notes = "operUser")
	private Employee operUser;
	
	/**
	 * inspectionPointPos：inspectionPointPos
	*/
	@ApiModelProperty(required = false,value="inspectionPointPos" , notes = "inspectionPointPos")
	private InspectionPointPos inspectionPointPos;
	
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
	public InspectionTaskPoint setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 任务<br>
	 * 任务
	 * @return 任务
	*/
	public String getTaskId() {
		return taskId;
	}
	
	/**
	 * 设置 任务
	 * @param taskId 任务
	 * @return 当前对象
	*/
	public InspectionTaskPoint setTaskId(String taskId) {
		this.taskId=taskId;
		return this;
	}
	
	/**
	 * 获得 巡检状态<br>
	 * 巡检状态
	 * @return 巡检状态
	*/
	public String getPointStatus() {
		return pointStatus;
	}
	
	/**
	 * 设置 巡检状态
	 * @param pointStatus 巡检状态
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointStatus(String pointStatus) {
		this.pointStatus=pointStatus;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getOperTime() {
		return operTime;
	}
	
	/**
	 * 设置 操作时间
	 * @param operTime 操作时间
	 * @return 当前对象
	*/
	public InspectionTaskPoint setOperTime(Date operTime) {
		this.operTime=operTime;
		return this;
	}
	
	/**
	 * 获得 巡检结果<br>
	 * 巡检结果
	 * @return 巡检结果
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 巡检结果
	 * @param content 巡检结果
	 * @return 当前对象
	*/
	public InspectionTaskPoint setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 巡检点<br>
	 * 巡检点
	 * @return 巡检点
	*/
	public String getPointId() {
		return pointId;
	}
	
	/**
	 * 设置 巡检点
	 * @param pointId 巡检点
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointId(String pointId) {
		this.pointId=pointId;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getPointCode() {
		return pointCode;
	}
	
	/**
	 * 设置 编码
	 * @param pointCode 编码
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointCode(String pointCode) {
		this.pointCode=pointCode;
		return this;
	}
	
	/**
	 * 获得 检<br>
	 * 检
	 * @return 检
	*/
	public String getPointName() {
		return pointName;
	}
	
	/**
	 * 设置 检
	 * @param pointName 检
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointName(String pointName) {
		this.pointName=pointName;
		return this;
	}
	
	/**
	 * 获得 巡检内容<br>
	 * 巡检内容
	 * @return 巡检内容
	*/
	public String getPointContent() {
		return pointContent;
	}
	
	/**
	 * 设置 巡检内容
	 * @param pointContent 巡检内容
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointContent(String pointContent) {
		this.pointContent=pointContent;
		return this;
	}
	
	/**
	 * 获得 巡检路线<br>
	 * 巡检路线
	 * @return 巡检路线
	*/
	public String getPointRouteId() {
		return pointRouteId;
	}
	
	/**
	 * 设置 巡检路线
	 * @param pointRouteId 巡检路线
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointRouteId(String pointRouteId) {
		this.pointRouteId=pointRouteId;
		return this;
	}
	
	/**
	 * 获得 RFID<br>
	 * RFID
	 * @return RFID
	*/
	public String getPointRfid() {
		return pointRfid;
	}
	
	/**
	 * 设置 RFID
	 * @param pointRfid RFID
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointRfid(String pointRfid) {
		this.pointRfid=pointRfid;
		return this;
	}
	
	/**
	 * 获得 位置详情<br>
	 * 位置详情
	 * @return 位置详情
	*/
	public String getPointPos() {
		return pointPos;
	}
	
	/**
	 * 设置 位置详情
	 * @param pointPos 位置详情
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointPos(String pointPos) {
		this.pointPos=pointPos;
		return this;
	}
	
	/**
	 * 获得 位置<br>
	 * 位置
	 * @return 位置
	*/
	public String getPointPosId() {
		return pointPosId;
	}
	
	/**
	 * 设置 位置
	 * @param pointPosId 位置
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointPosId(String pointPosId) {
		this.pointPosId=pointPosId;
		return this;
	}
	
	/**
	 * 获得 位置经度<br>
	 * 位置经度
	 * @return 位置经度
	*/
	public String getPointPosLongitude() {
		return pointPosLongitude;
	}
	
	/**
	 * 设置 位置经度
	 * @param pointPosLongitude 位置经度
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointPosLongitude(String pointPosLongitude) {
		this.pointPosLongitude=pointPosLongitude;
		return this;
	}
	
	/**
	 * 获得 位置纬度<br>
	 * 位置纬度
	 * @return 位置纬度
	*/
	public String getPointPosLatitude() {
		return pointPosLatitude;
	}
	
	/**
	 * 设置 位置纬度
	 * @param pointPosLatitude 位置纬度
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointPosLatitude(String pointPosLatitude) {
		this.pointPosLatitude=pointPosLatitude;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getPointNotes() {
		return pointNotes;
	}
	
	/**
	 * 设置 备注
	 * @param pointNotes 备注
	 * @return 当前对象
	*/
	public InspectionTaskPoint setPointNotes(String pointNotes) {
		this.pointNotes=pointNotes;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public InspectionTaskPoint setSort(Integer sort) {
		this.sort=sort;
		return this;
	}
	
	/**
	 * 获得 操作人<br>
	 * 操作人
	 * @return 操作人
	*/
	public String getOperId() {
		return operId;
	}
	
	/**
	 * 设置 操作人
	 * @param operId 操作人
	 * @return 当前对象
	*/
	public InspectionTaskPoint setOperId(String operId) {
		this.operId=operId;
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
	public InspectionTaskPoint setNotes(String notes) {
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
	public InspectionTaskPoint setCreateBy(String createBy) {
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
	public InspectionTaskPoint setCreateTime(Date createTime) {
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
	public InspectionTaskPoint setUpdateBy(String updateBy) {
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
	public InspectionTaskPoint setUpdateTime(Date updateTime) {
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
	public InspectionTaskPoint setDeleted(Integer deleted) {
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
	public InspectionTaskPoint setDeleted(Boolean deletedBool) {
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
	public InspectionTaskPoint setDeleteBy(String deleteBy) {
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
	public InspectionTaskPoint setDeleteTime(Date deleteTime) {
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
	public InspectionTaskPoint setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public InspectionTaskPoint setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
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
	public InspectionTaskPoint setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 route<br>
	 * route
	 * @return route
	*/
	public InspectionRoute getRoute() {
		return route;
	}
	
	/**
	 * 设置 route
	 * @param route route
	 * @return 当前对象
	*/
	public InspectionTaskPoint setRoute(InspectionRoute route) {
		this.route=route;
		return this;
	}
	
	/**
	 * 获得 task<br>
	 * task
	 * @return task
	*/
	public InspectionTask getTask() {
		return task;
	}
	
	/**
	 * 设置 task
	 * @param task task
	 * @return 当前对象
	*/
	public InspectionTaskPoint setTask(InspectionTask task) {
		this.task=task;
		return this;
	}
	
	/**
	 * 获得 operUser<br>
	 * operUser
	 * @return operUser
	*/
	public Employee getOperUser() {
		return operUser;
	}
	
	/**
	 * 设置 operUser
	 * @param operUser operUser
	 * @return 当前对象
	*/
	public InspectionTaskPoint setOperUser(Employee operUser) {
		this.operUser=operUser;
		return this;
	}
	
	/**
	 * 获得 inspectionPointPos<br>
	 * inspectionPointPos
	 * @return inspectionPointPos
	*/
	public InspectionPointPos getInspectionPointPos() {
		return inspectionPointPos;
	}
	
	/**
	 * 设置 inspectionPointPos
	 * @param inspectionPointPos inspectionPointPos
	 * @return 当前对象
	*/
	public InspectionTaskPoint setInspectionPointPos(InspectionPointPos inspectionPointPos) {
		this.inspectionPointPos=inspectionPointPos;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionTaskPoint , 转换好的 InspectionTaskPoint 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionTaskPoint , 转换好的 PoJo 对象
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
	public InspectionTaskPoint clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InspectionTaskPoint duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InspectionTaskPointMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InspectionTaskPointMeta.$$proxy$$();
		inst.setPointRfid(this.getPointRfid());
		inst.setNotes(this.getNotes());
		inst.setPointName(this.getPointName());
		inst.setOperId(this.getOperId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setPointId(this.getPointId());
		inst.setPointRouteId(this.getPointRouteId());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setPointNotes(this.getPointNotes());
		inst.setId(this.getId());
		inst.setPointStatus(this.getPointStatus());
		inst.setOperTime(this.getOperTime());
		inst.setPointCode(this.getPointCode());
		inst.setPointContent(this.getPointContent());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setPointPos(this.getPointPos());
		inst.setPointPosLongitude(this.getPointPosLongitude());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPointPosId(this.getPointPosId());
		inst.setPointPosLatitude(this.getPointPosLatitude());
		inst.setTaskId(this.getTaskId());
		if(all) {
			inst.setRoute(this.getRoute());
			inst.setTask(this.getTask());
			inst.setInspectionPointPos(this.getInspectionPointPos());
			inst.setOperUser(this.getOperUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InspectionTaskPoint clone(boolean deep) {
		return EntityContext.clone(InspectionTaskPoint.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InspectionTaskPoint
	 * @param inspectionTaskPointMap 包含实体信息的 Map 对象
	 * @return InspectionTaskPoint , 转换好的的 InspectionTaskPoint 对象
	*/
	@Transient
	public static InspectionTaskPoint createFrom(Map<String,Object> inspectionTaskPointMap) {
		if(inspectionTaskPointMap==null) return null;
		InspectionTaskPoint po = create();
		EntityContext.copyProperties(po,inspectionTaskPointMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionTaskPoint
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionTaskPoint , 转换好的的 InspectionTaskPoint 对象
	*/
	@Transient
	public static InspectionTaskPoint createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionTaskPoint po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InspectionTaskPoint，等同于 new
	 * @return InspectionTaskPoint 对象
	*/
	@Transient
	public static InspectionTaskPoint create() {
		return new com.dt.platform.domain.eam.meta.InspectionTaskPointMeta.$$proxy$$();
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
			this.setPointRfid(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.POINT_RFID)));
			this.setNotes(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.NOTES)));
			this.setPointName(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.POINT_NAME)));
			this.setOperId(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.OPER_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.CONTENT)));
			this.setPointId(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.POINT_ID)));
			this.setPointRouteId(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.POINT_ROUTE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.UPDATE_BY)));
			this.setPointNotes(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.POINT_NOTES)));
			this.setId(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.ID)));
			this.setPointStatus(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.POINT_STATUS)));
			this.setOperTime(DataParser.parse(Date.class, map.get(InspectionTaskPointMeta.OPER_TIME)));
			this.setPointCode(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.POINT_CODE)));
			this.setPointContent(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.POINT_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InspectionTaskPointMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(InspectionTaskPointMeta.SORT)));
			this.setPointPos(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.POINT_POS)));
			this.setPointPosLongitude(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.POINT_POS_LONGITUDE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InspectionTaskPointMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InspectionTaskPointMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InspectionTaskPointMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InspectionTaskPointMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.DELETE_BY)));
			this.setPointPosId(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.POINT_POS_ID)));
			this.setPointPosLatitude(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.POINT_POS_LATITUDE)));
			this.setTaskId(DataParser.parse(String.class, map.get(InspectionTaskPointMeta.TASK_ID)));
			// others
			this.setRoute(DataParser.parse(InspectionRoute.class, map.get(InspectionTaskPointMeta.ROUTE)));
			this.setTask(DataParser.parse(InspectionTask.class, map.get(InspectionTaskPointMeta.TASK)));
			this.setInspectionPointPos(DataParser.parse(InspectionPointPos.class, map.get(InspectionTaskPointMeta.INSPECTION_POINT_POS)));
			this.setOperUser(DataParser.parse(Employee.class, map.get(InspectionTaskPointMeta.OPER_USER)));
			return true;
		} else {
			try {
				this.setPointRfid( (String)map.get(InspectionTaskPointMeta.POINT_RFID));
				this.setNotes( (String)map.get(InspectionTaskPointMeta.NOTES));
				this.setPointName( (String)map.get(InspectionTaskPointMeta.POINT_NAME));
				this.setOperId( (String)map.get(InspectionTaskPointMeta.OPER_ID));
				this.setSelectedCode( (String)map.get(InspectionTaskPointMeta.SELECTED_CODE));
				this.setContent( (String)map.get(InspectionTaskPointMeta.CONTENT));
				this.setPointId( (String)map.get(InspectionTaskPointMeta.POINT_ID));
				this.setPointRouteId( (String)map.get(InspectionTaskPointMeta.POINT_ROUTE_ID));
				this.setUpdateBy( (String)map.get(InspectionTaskPointMeta.UPDATE_BY));
				this.setPointNotes( (String)map.get(InspectionTaskPointMeta.POINT_NOTES));
				this.setId( (String)map.get(InspectionTaskPointMeta.ID));
				this.setPointStatus( (String)map.get(InspectionTaskPointMeta.POINT_STATUS));
				this.setOperTime( (Date)map.get(InspectionTaskPointMeta.OPER_TIME));
				this.setPointCode( (String)map.get(InspectionTaskPointMeta.POINT_CODE));
				this.setPointContent( (String)map.get(InspectionTaskPointMeta.POINT_CONTENT));
				this.setUpdateTime( (Date)map.get(InspectionTaskPointMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(InspectionTaskPointMeta.SORT));
				this.setPointPos( (String)map.get(InspectionTaskPointMeta.POINT_POS));
				this.setPointPosLongitude( (String)map.get(InspectionTaskPointMeta.POINT_POS_LONGITUDE));
				this.setVersion( (Integer)map.get(InspectionTaskPointMeta.VERSION));
				this.setCreateBy( (String)map.get(InspectionTaskPointMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InspectionTaskPointMeta.DELETED));
				this.setCreateTime( (Date)map.get(InspectionTaskPointMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(InspectionTaskPointMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(InspectionTaskPointMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InspectionTaskPointMeta.DELETE_BY));
				this.setPointPosId( (String)map.get(InspectionTaskPointMeta.POINT_POS_ID));
				this.setPointPosLatitude( (String)map.get(InspectionTaskPointMeta.POINT_POS_LATITUDE));
				this.setTaskId( (String)map.get(InspectionTaskPointMeta.TASK_ID));
				// others
				this.setRoute( (InspectionRoute)map.get(InspectionTaskPointMeta.ROUTE));
				this.setTask( (InspectionTask)map.get(InspectionTaskPointMeta.TASK));
				this.setInspectionPointPos( (InspectionPointPos)map.get(InspectionTaskPointMeta.INSPECTION_POINT_POS));
				this.setOperUser( (Employee)map.get(InspectionTaskPointMeta.OPER_USER));
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
			this.setPointRfid(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.POINT_RFID)));
			this.setNotes(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.NOTES)));
			this.setPointName(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.POINT_NAME)));
			this.setOperId(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.OPER_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.CONTENT)));
			this.setPointId(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.POINT_ID)));
			this.setPointRouteId(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.POINT_ROUTE_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.UPDATE_BY)));
			this.setPointNotes(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.POINT_NOTES)));
			this.setId(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.ID)));
			this.setPointStatus(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.POINT_STATUS)));
			this.setOperTime(DataParser.parse(Date.class, r.getValue(InspectionTaskPointMeta.OPER_TIME)));
			this.setPointCode(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.POINT_CODE)));
			this.setPointContent(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.POINT_CONTENT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InspectionTaskPointMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(InspectionTaskPointMeta.SORT)));
			this.setPointPos(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.POINT_POS)));
			this.setPointPosLongitude(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.POINT_POS_LONGITUDE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InspectionTaskPointMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InspectionTaskPointMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InspectionTaskPointMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InspectionTaskPointMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.DELETE_BY)));
			this.setPointPosId(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.POINT_POS_ID)));
			this.setPointPosLatitude(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.POINT_POS_LATITUDE)));
			this.setTaskId(DataParser.parse(String.class, r.getValue(InspectionTaskPointMeta.TASK_ID)));
			return true;
		} else {
			try {
				this.setPointRfid( (String)r.getValue(InspectionTaskPointMeta.POINT_RFID));
				this.setNotes( (String)r.getValue(InspectionTaskPointMeta.NOTES));
				this.setPointName( (String)r.getValue(InspectionTaskPointMeta.POINT_NAME));
				this.setOperId( (String)r.getValue(InspectionTaskPointMeta.OPER_ID));
				this.setSelectedCode( (String)r.getValue(InspectionTaskPointMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(InspectionTaskPointMeta.CONTENT));
				this.setPointId( (String)r.getValue(InspectionTaskPointMeta.POINT_ID));
				this.setPointRouteId( (String)r.getValue(InspectionTaskPointMeta.POINT_ROUTE_ID));
				this.setUpdateBy( (String)r.getValue(InspectionTaskPointMeta.UPDATE_BY));
				this.setPointNotes( (String)r.getValue(InspectionTaskPointMeta.POINT_NOTES));
				this.setId( (String)r.getValue(InspectionTaskPointMeta.ID));
				this.setPointStatus( (String)r.getValue(InspectionTaskPointMeta.POINT_STATUS));
				this.setOperTime( (Date)r.getValue(InspectionTaskPointMeta.OPER_TIME));
				this.setPointCode( (String)r.getValue(InspectionTaskPointMeta.POINT_CODE));
				this.setPointContent( (String)r.getValue(InspectionTaskPointMeta.POINT_CONTENT));
				this.setUpdateTime( (Date)r.getValue(InspectionTaskPointMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(InspectionTaskPointMeta.SORT));
				this.setPointPos( (String)r.getValue(InspectionTaskPointMeta.POINT_POS));
				this.setPointPosLongitude( (String)r.getValue(InspectionTaskPointMeta.POINT_POS_LONGITUDE));
				this.setVersion( (Integer)r.getValue(InspectionTaskPointMeta.VERSION));
				this.setCreateBy( (String)r.getValue(InspectionTaskPointMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InspectionTaskPointMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(InspectionTaskPointMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(InspectionTaskPointMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(InspectionTaskPointMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InspectionTaskPointMeta.DELETE_BY));
				this.setPointPosId( (String)r.getValue(InspectionTaskPointMeta.POINT_POS_ID));
				this.setPointPosLatitude( (String)r.getValue(InspectionTaskPointMeta.POINT_POS_LATITUDE));
				this.setTaskId( (String)r.getValue(InspectionTaskPointMeta.TASK_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}