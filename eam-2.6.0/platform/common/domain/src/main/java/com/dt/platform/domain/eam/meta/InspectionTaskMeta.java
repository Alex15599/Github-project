package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InspectionTask;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.InspectionPlan;
import com.dt.platform.domain.eam.InspectionPoint;
import java.util.List;
import com.dt.platform.domain.eam.InspectionTaskPoint;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.InspectionGroup;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-14 07:30:19
 * @sign A0A137B1407B3775EBF078093B3E3696
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InspectionTaskMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 巡检计划 , 类型: java.lang.String
	*/
	public static final String PLAN_ID="planId";
	
	/**
	 * 巡检计划 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> PLAN_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,PLAN_ID, java.lang.String.class, "巡检计划", "巡检计划", java.lang.String.class, null);
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final String TASK_STATUS="taskStatus";
	
	/**
	 * 任务状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> TASK_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,TASK_STATUS, java.lang.String.class, "任务状态", "任务状态", java.lang.String.class, null);
	
	/**
	 * 任务单据 , 类型: java.lang.String
	*/
	public static final String TASK_CODE="taskCode";
	
	/**
	 * 任务单据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> TASK_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,TASK_CODE, java.lang.String.class, "任务单据", "任务单据", java.lang.String.class, null);
	
	/**
	 * 巡检编码 , 类型: java.lang.String
	*/
	public static final String PLAN_CODE="planCode";
	
	/**
	 * 巡检编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> PLAN_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,PLAN_CODE, java.lang.String.class, "巡检编码", "巡检编码", java.lang.String.class, null);
	
	/**
	 * 巡检名称 , 类型: java.lang.String
	*/
	public static final String PLAN_NAME="planName";
	
	/**
	 * 巡检名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> PLAN_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,PLAN_NAME, java.lang.String.class, "巡检名称", "巡检名称", java.lang.String.class, null);
	
	/**
	 * 巡检顺序 , 类型: java.lang.String
	*/
	public static final String PLAN_INSPECTION_METHOD="planInspectionMethod";
	
	/**
	 * 巡检顺序 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> PLAN_INSPECTION_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,PLAN_INSPECTION_METHOD, java.lang.String.class, "巡检顺序", "巡检顺序", java.lang.String.class, null);
	
	/**
	 * 时间要求 , 类型: java.math.BigDecimal
	*/
	public static final String PLAN_COMPLETION_TIME="planCompletionTime";
	
	/**
	 * 时间要求 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.math.BigDecimal> PLAN_COMPLETION_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,PLAN_COMPLETION_TIME, java.math.BigDecimal.class, "时间要求", "时间要求", java.math.BigDecimal.class, null);
	
	/**
	 * 巡检备注 , 类型: java.lang.String
	*/
	public static final String PLAN_NOTES="planNotes";
	
	/**
	 * 巡检备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> PLAN_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,PLAN_NOTES, java.lang.String.class, "巡检备注", "巡检备注", java.lang.String.class, null);
	
	/**
	 * 巡检班组 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 巡检班组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,GROUP_ID, java.lang.String.class, "巡检班组", "巡检班组", java.lang.String.class, null);
	
	/**
	 * 执行人 , 类型: java.lang.String
	*/
	public static final String EXECUTOR_ID="executorId";
	
	/**
	 * 执行人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> EXECUTOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,EXECUTOR_ID, java.lang.String.class, "执行人", "执行人", java.lang.String.class, null);
	
	/**
	 * 应开始时间 , 类型: java.util.Date
	*/
	public static final String PLAN_START_TIME="planStartTime";
	
	/**
	 * 应开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.util.Date> PLAN_START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,PLAN_START_TIME, java.util.Date.class, "应开始时间", "应开始时间", java.util.Date.class, null);
	
	/**
	 * 实际开始时间 , 类型: java.util.Date
	*/
	public static final String ACT_START_TIME="actStartTime";
	
	/**
	 * 实际开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.util.Date> ACT_START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,ACT_START_TIME, java.util.Date.class, "实际开始时间", "实际开始时间", java.util.Date.class, null);
	
	/**
	 * 实际完成时间 , 类型: java.util.Date
	*/
	public static final String ACT_FINISH_TIME="actFinishTime";
	
	/**
	 * 实际完成时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.util.Date> ACT_FINISH_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,ACT_FINISH_TIME, java.util.Date.class, "实际完成时间", "实际完成时间", java.util.Date.class, null);
	
	/**
	 * 实际工时 , 类型: java.math.BigDecimal
	*/
	public static final String ACT_TOTAL_COST="actTotalCost";
	
	/**
	 * 实际工时 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.math.BigDecimal> ACT_TOTAL_COST_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,ACT_TOTAL_COST, java.math.BigDecimal.class, "实际工时", "实际工时", java.math.BigDecimal.class, null);
	
	/**
	 * 任务反馈 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 任务反馈 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,CONTENT, java.lang.String.class, "任务反馈", "任务反馈", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 计划 , 类型: com.dt.platform.domain.eam.InspectionPlan
	*/
	public static final String INSPECTION_PLAN="inspectionPlan";
	
	/**
	 * 计划 , 类型: com.dt.platform.domain.eam.InspectionPlan
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,com.dt.platform.domain.eam.InspectionPlan> INSPECTION_PLAN_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,INSPECTION_PLAN, com.dt.platform.domain.eam.InspectionPlan.class, "计划", "计划", com.dt.platform.domain.eam.InspectionPlan.class, null);
	
	/**
	 * 巡检点 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InspectionPoint
	*/
	public static final String INSPECTION_POINT_LIST="inspectionPointList";
	
	/**
	 * 巡检点 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InspectionPoint
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,com.dt.platform.domain.eam.InspectionPoint> INSPECTION_POINT_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,INSPECTION_POINT_LIST, java.util.List.class, "巡检点", "巡检点", com.dt.platform.domain.eam.InspectionPoint.class, null);
	
	/**
	 * 巡检点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INSPECTION_POINT_IDS="inspectionPointIds";
	
	/**
	 * 巡检点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> INSPECTION_POINT_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,INSPECTION_POINT_IDS, java.util.List.class, "巡检点", "巡检点", java.lang.String.class, null);
	
	/**
	 * 任务巡检点 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InspectionTaskPoint
	*/
	public static final String INSPECTION_TASK_POINT_LIST="inspectionTaskPointList";
	
	/**
	 * 任务巡检点 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.InspectionTaskPoint
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,com.dt.platform.domain.eam.InspectionTaskPoint> INSPECTION_TASK_POINT_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,INSPECTION_TASK_POINT_LIST, java.util.List.class, "任务巡检点", "任务巡检点", com.dt.platform.domain.eam.InspectionTaskPoint.class, null);
	
	/**
	 * 任务巡检点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String INSPECTION_TASK_POINT_IDS="inspectionTaskPointIds";
	
	/**
	 * 任务巡检点 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,java.lang.String> INSPECTION_TASK_POINT_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,INSPECTION_TASK_POINT_IDS, java.util.List.class, "任务巡检点", "任务巡检点", java.lang.String.class, null);
	
	/**
	 * 时间 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String TIME_DICT="timeDict";
	
	/**
	 * 时间 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,org.github.foxnic.web.domain.system.DictItem> TIME_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,TIME_DICT, org.github.foxnic.web.domain.system.DictItem.class, "时间", "时间", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String INSPECTION_TYPE_DICT="inspectionTypeDict";
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,org.github.foxnic.web.domain.system.DictItem> INSPECTION_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,INSPECTION_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "类型", "类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 班组 , 类型: com.dt.platform.domain.eam.InspectionGroup
	*/
	public static final String INSPECTION_GROUP="inspectionGroup";
	
	/**
	 * 班组 , 类型: com.dt.platform.domain.eam.InspectionGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,com.dt.platform.domain.eam.InspectionGroup> INSPECTION_GROUP_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,INSPECTION_GROUP, com.dt.platform.domain.eam.InspectionGroup.class, "班组", "班组", com.dt.platform.domain.eam.InspectionGroup.class, null);
	
	/**
	 * inspectUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String INSPECT_USER_LIST="inspectUserList";
	
	/**
	 * inspectUserList , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,org.github.foxnic.web.domain.hrm.Employee> INSPECT_USER_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,INSPECT_USER_LIST, java.util.List.class, "inspectUserList", "inspectUserList", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 执行人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EXECUTOR="executor";
	
	/**
	 * 执行人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTask,org.github.foxnic.web.domain.hrm.Employee> EXECUTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTask.class ,EXECUTOR, org.github.foxnic.web.domain.hrm.Employee.class, "执行人", "执行人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , PLAN_ID , TASK_STATUS , TASK_CODE , PLAN_CODE , PLAN_NAME , PLAN_INSPECTION_METHOD , PLAN_COMPLETION_TIME , PLAN_NOTES , GROUP_ID , EXECUTOR_ID , PLAN_START_TIME , ACT_START_TIME , ACT_FINISH_TIME , ACT_TOTAL_COST , CONTENT , NOTES , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , SELECTED_CODE , INSPECTION_PLAN , INSPECTION_POINT_LIST , INSPECTION_POINT_IDS , INSPECTION_TASK_POINT_LIST , INSPECTION_TASK_POINT_IDS , TIME_DICT , INSPECTION_TYPE_DICT , INSPECTION_GROUP , INSPECT_USER_LIST , ORIGINATOR , EXECUTOR };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InspectionTask {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InspectionTask setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 巡检计划
		 * @param planId 巡检计划
		 * @return 当前对象
		*/
		public InspectionTask setPlanId(String planId) {
			super.change(PLAN_ID,super.getPlanId(),planId);
			super.setPlanId(planId);
			return this;
		}
		
		/**
		 * 设置 任务状态
		 * @param taskStatus 任务状态
		 * @return 当前对象
		*/
		public InspectionTask setTaskStatus(String taskStatus) {
			super.change(TASK_STATUS,super.getTaskStatus(),taskStatus);
			super.setTaskStatus(taskStatus);
			return this;
		}
		
		/**
		 * 设置 任务单据
		 * @param taskCode 任务单据
		 * @return 当前对象
		*/
		public InspectionTask setTaskCode(String taskCode) {
			super.change(TASK_CODE,super.getTaskCode(),taskCode);
			super.setTaskCode(taskCode);
			return this;
		}
		
		/**
		 * 设置 巡检编码
		 * @param planCode 巡检编码
		 * @return 当前对象
		*/
		public InspectionTask setPlanCode(String planCode) {
			super.change(PLAN_CODE,super.getPlanCode(),planCode);
			super.setPlanCode(planCode);
			return this;
		}
		
		/**
		 * 设置 巡检名称
		 * @param planName 巡检名称
		 * @return 当前对象
		*/
		public InspectionTask setPlanName(String planName) {
			super.change(PLAN_NAME,super.getPlanName(),planName);
			super.setPlanName(planName);
			return this;
		}
		
		/**
		 * 设置 巡检顺序
		 * @param planInspectionMethod 巡检顺序
		 * @return 当前对象
		*/
		public InspectionTask setPlanInspectionMethod(String planInspectionMethod) {
			super.change(PLAN_INSPECTION_METHOD,super.getPlanInspectionMethod(),planInspectionMethod);
			super.setPlanInspectionMethod(planInspectionMethod);
			return this;
		}
		
		/**
		 * 设置 时间要求
		 * @param planCompletionTime 时间要求
		 * @return 当前对象
		*/
		public InspectionTask setPlanCompletionTime(BigDecimal planCompletionTime) {
			super.change(PLAN_COMPLETION_TIME,super.getPlanCompletionTime(),planCompletionTime);
			super.setPlanCompletionTime(planCompletionTime);
			return this;
		}
		
		/**
		 * 设置 巡检备注
		 * @param planNotes 巡检备注
		 * @return 当前对象
		*/
		public InspectionTask setPlanNotes(String planNotes) {
			super.change(PLAN_NOTES,super.getPlanNotes(),planNotes);
			super.setPlanNotes(planNotes);
			return this;
		}
		
		/**
		 * 设置 巡检班组
		 * @param groupId 巡检班组
		 * @return 当前对象
		*/
		public InspectionTask setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 执行人
		 * @param executorId 执行人
		 * @return 当前对象
		*/
		public InspectionTask setExecutorId(String executorId) {
			super.change(EXECUTOR_ID,super.getExecutorId(),executorId);
			super.setExecutorId(executorId);
			return this;
		}
		
		/**
		 * 设置 应开始时间
		 * @param planStartTime 应开始时间
		 * @return 当前对象
		*/
		public InspectionTask setPlanStartTime(Date planStartTime) {
			super.change(PLAN_START_TIME,super.getPlanStartTime(),planStartTime);
			super.setPlanStartTime(planStartTime);
			return this;
		}
		
		/**
		 * 设置 实际开始时间
		 * @param actStartTime 实际开始时间
		 * @return 当前对象
		*/
		public InspectionTask setActStartTime(Date actStartTime) {
			super.change(ACT_START_TIME,super.getActStartTime(),actStartTime);
			super.setActStartTime(actStartTime);
			return this;
		}
		
		/**
		 * 设置 实际完成时间
		 * @param actFinishTime 实际完成时间
		 * @return 当前对象
		*/
		public InspectionTask setActFinishTime(Date actFinishTime) {
			super.change(ACT_FINISH_TIME,super.getActFinishTime(),actFinishTime);
			super.setActFinishTime(actFinishTime);
			return this;
		}
		
		/**
		 * 设置 实际工时
		 * @param actTotalCost 实际工时
		 * @return 当前对象
		*/
		public InspectionTask setActTotalCost(BigDecimal actTotalCost) {
			super.change(ACT_TOTAL_COST,super.getActTotalCost(),actTotalCost);
			super.setActTotalCost(actTotalCost);
			return this;
		}
		
		/**
		 * 设置 任务反馈
		 * @param content 任务反馈
		 * @return 当前对象
		*/
		public InspectionTask setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public InspectionTask setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public InspectionTask setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InspectionTask setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InspectionTask setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InspectionTask setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InspectionTask setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InspectionTask setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InspectionTask setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InspectionTask setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public InspectionTask setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public InspectionTask setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public InspectionTask setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 计划
		 * @param inspectionPlan 计划
		 * @return 当前对象
		*/
		public InspectionTask setInspectionPlan(InspectionPlan inspectionPlan) {
			super.change(INSPECTION_PLAN,super.getInspectionPlan(),inspectionPlan);
			super.setInspectionPlan(inspectionPlan);
			return this;
		}
		
		/**
		 * 设置 巡检点
		 * @param inspectionPointList 巡检点
		 * @return 当前对象
		*/
		public InspectionTask setInspectionPointList(List<InspectionPoint> inspectionPointList) {
			super.change(INSPECTION_POINT_LIST,super.getInspectionPointList(),inspectionPointList);
			super.setInspectionPointList(inspectionPointList);
			return this;
		}
		
		/**
		 * 设置 巡检点
		 * @param inspectionPointIds 巡检点
		 * @return 当前对象
		*/
		public InspectionTask setInspectionPointIds(List<String> inspectionPointIds) {
			super.change(INSPECTION_POINT_IDS,super.getInspectionPointIds(),inspectionPointIds);
			super.setInspectionPointIds(inspectionPointIds);
			return this;
		}
		
		/**
		 * 设置 任务巡检点
		 * @param inspectionTaskPointList 任务巡检点
		 * @return 当前对象
		*/
		public InspectionTask setInspectionTaskPointList(List<InspectionTaskPoint> inspectionTaskPointList) {
			super.change(INSPECTION_TASK_POINT_LIST,super.getInspectionTaskPointList(),inspectionTaskPointList);
			super.setInspectionTaskPointList(inspectionTaskPointList);
			return this;
		}
		
		/**
		 * 设置 任务巡检点
		 * @param inspectionTaskPointIds 任务巡检点
		 * @return 当前对象
		*/
		public InspectionTask setInspectionTaskPointIds(List<String> inspectionTaskPointIds) {
			super.change(INSPECTION_TASK_POINT_IDS,super.getInspectionTaskPointIds(),inspectionTaskPointIds);
			super.setInspectionTaskPointIds(inspectionTaskPointIds);
			return this;
		}
		
		/**
		 * 设置 时间
		 * @param timeDict 时间
		 * @return 当前对象
		*/
		public InspectionTask setTimeDict(DictItem timeDict) {
			super.change(TIME_DICT,super.getTimeDict(),timeDict);
			super.setTimeDict(timeDict);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param inspectionTypeDict 类型
		 * @return 当前对象
		*/
		public InspectionTask setInspectionTypeDict(DictItem inspectionTypeDict) {
			super.change(INSPECTION_TYPE_DICT,super.getInspectionTypeDict(),inspectionTypeDict);
			super.setInspectionTypeDict(inspectionTypeDict);
			return this;
		}
		
		/**
		 * 设置 班组
		 * @param inspectionGroup 班组
		 * @return 当前对象
		*/
		public InspectionTask setInspectionGroup(InspectionGroup inspectionGroup) {
			super.change(INSPECTION_GROUP,super.getInspectionGroup(),inspectionGroup);
			super.setInspectionGroup(inspectionGroup);
			return this;
		}
		
		/**
		 * 设置 inspectUserList
		 * @param inspectUserList inspectUserList
		 * @return 当前对象
		*/
		public InspectionTask setInspectUserList(List<Employee> inspectUserList) {
			super.change(INSPECT_USER_LIST,super.getInspectUserList(),inspectUserList);
			super.setInspectUserList(inspectUserList);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public InspectionTask setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 执行人
		 * @param executor 执行人
		 * @return 当前对象
		*/
		public InspectionTask setExecutor(Employee executor) {
			super.change(EXECUTOR,super.getExecutor(),executor);
			super.setExecutor(executor);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}