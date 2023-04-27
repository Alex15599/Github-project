package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InspectionTaskPointVO;
import java.util.List;
import com.dt.platform.domain.eam.InspectionTaskPoint;
import java.util.Date;
import com.dt.platform.domain.eam.InspectionRoute;
import com.dt.platform.domain.eam.InspectionTask;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.InspectionPointPos;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-11 12:47:53
 * @sign 651D328B81E70EC1A0B8941BD7D880C5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InspectionTaskPointVOMeta extends InspectionTaskPointMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final String TASK_ID="taskId";
	
	/**
	 * 任务 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> TASK_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,TASK_ID, java.lang.String.class, "任务", "任务", java.lang.String.class, null);
	
	/**
	 * 巡检状态 , 类型: java.lang.String
	*/
	public static final String POINT_STATUS="pointStatus";
	
	/**
	 * 巡检状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> POINT_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,POINT_STATUS, java.lang.String.class, "巡检状态", "巡检状态", java.lang.String.class, null);
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final String OPER_TIME="operTime";
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.util.Date> OPER_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,OPER_TIME, java.util.Date.class, "操作时间", "操作时间", java.util.Date.class, null);
	
	/**
	 * 巡检结果 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 巡检结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,CONTENT, java.lang.String.class, "巡检结果", "巡检结果", java.lang.String.class, null);
	
	/**
	 * 巡检点 , 类型: java.lang.String
	*/
	public static final String POINT_ID="pointId";
	
	/**
	 * 巡检点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> POINT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,POINT_ID, java.lang.String.class, "巡检点", "巡检点", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String POINT_CODE="pointCode";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> POINT_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,POINT_CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 检 , 类型: java.lang.String
	*/
	public static final String POINT_NAME="pointName";
	
	/**
	 * 检 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> POINT_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,POINT_NAME, java.lang.String.class, "检", "检", java.lang.String.class, null);
	
	/**
	 * 巡检内容 , 类型: java.lang.String
	*/
	public static final String POINT_CONTENT="pointContent";
	
	/**
	 * 巡检内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> POINT_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,POINT_CONTENT, java.lang.String.class, "巡检内容", "巡检内容", java.lang.String.class, null);
	
	/**
	 * 巡检路线 , 类型: java.lang.String
	*/
	public static final String POINT_ROUTE_ID="pointRouteId";
	
	/**
	 * 巡检路线 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> POINT_ROUTE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,POINT_ROUTE_ID, java.lang.String.class, "巡检路线", "巡检路线", java.lang.String.class, null);
	
	/**
	 * RFID , 类型: java.lang.String
	*/
	public static final String POINT_RFID="pointRfid";
	
	/**
	 * RFID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> POINT_RFID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,POINT_RFID, java.lang.String.class, "RFID", "RFID", java.lang.String.class, null);
	
	/**
	 * 位置详情 , 类型: java.lang.String
	*/
	public static final String POINT_POS="pointPos";
	
	/**
	 * 位置详情 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> POINT_POS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,POINT_POS, java.lang.String.class, "位置详情", "位置详情", java.lang.String.class, null);
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final String POINT_POS_ID="pointPosId";
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> POINT_POS_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,POINT_POS_ID, java.lang.String.class, "位置", "位置", java.lang.String.class, null);
	
	/**
	 * 位置经度 , 类型: java.lang.String
	*/
	public static final String POINT_POS_LONGITUDE="pointPosLongitude";
	
	/**
	 * 位置经度 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> POINT_POS_LONGITUDE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,POINT_POS_LONGITUDE, java.lang.String.class, "位置经度", "位置经度", java.lang.String.class, null);
	
	/**
	 * 位置纬度 , 类型: java.lang.String
	*/
	public static final String POINT_POS_LATITUDE="pointPosLatitude";
	
	/**
	 * 位置纬度 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> POINT_POS_LATITUDE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,POINT_POS_LATITUDE, java.lang.String.class, "位置纬度", "位置纬度", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String POINT_NOTES="pointNotes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> POINT_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,POINT_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final String OPER_ID="operId";
	
	/**
	 * 操作人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> OPER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,OPER_ID, java.lang.String.class, "操作人", "操作人", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * route , 类型: com.dt.platform.domain.eam.InspectionRoute
	*/
	public static final String ROUTE="route";
	
	/**
	 * route , 类型: com.dt.platform.domain.eam.InspectionRoute
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,com.dt.platform.domain.eam.InspectionRoute> ROUTE_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,ROUTE, com.dt.platform.domain.eam.InspectionRoute.class, "route", "route", com.dt.platform.domain.eam.InspectionRoute.class, null);
	
	/**
	 * task , 类型: com.dt.platform.domain.eam.InspectionTask
	*/
	public static final String TASK="task";
	
	/**
	 * task , 类型: com.dt.platform.domain.eam.InspectionTask
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,com.dt.platform.domain.eam.InspectionTask> TASK_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,TASK, com.dt.platform.domain.eam.InspectionTask.class, "task", "task", com.dt.platform.domain.eam.InspectionTask.class, null);
	
	/**
	 * operUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OPER_USER="operUser";
	
	/**
	 * operUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,org.github.foxnic.web.domain.hrm.Employee> OPER_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,OPER_USER, org.github.foxnic.web.domain.hrm.Employee.class, "operUser", "operUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * inspectionPointPos , 类型: com.dt.platform.domain.eam.InspectionPointPos
	*/
	public static final String INSPECTION_POINT_POS="inspectionPointPos";
	
	/**
	 * inspectionPointPos , 类型: com.dt.platform.domain.eam.InspectionPointPos
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InspectionTaskPointVO,com.dt.platform.domain.eam.InspectionPointPos> INSPECTION_POINT_POS_PROP = new BeanProperty(com.dt.platform.domain.eam.InspectionTaskPointVO.class ,INSPECTION_POINT_POS, com.dt.platform.domain.eam.InspectionPointPos.class, "inspectionPointPos", "inspectionPointPos", com.dt.platform.domain.eam.InspectionPointPos.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , TASK_ID , POINT_STATUS , OPER_TIME , CONTENT , POINT_ID , POINT_CODE , POINT_NAME , POINT_CONTENT , POINT_ROUTE_ID , POINT_RFID , POINT_POS , POINT_POS_ID , POINT_POS_LONGITUDE , POINT_POS_LATITUDE , POINT_NOTES , SORT , OPER_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , SELECTED_CODE , VERSION , ROUTE , TASK , OPER_USER , INSPECTION_POINT_POS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InspectionTaskPointVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public InspectionTaskPointVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public InspectionTaskPointVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public InspectionTaskPointVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public InspectionTaskPointVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public InspectionTaskPointVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public InspectionTaskPointVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public InspectionTaskPointVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public InspectionTaskPointVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public InspectionTaskPointVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public InspectionTaskPointVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public InspectionTaskPointVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public InspectionTaskPointVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InspectionTaskPoint setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 任务
		 * @param taskId 任务
		 * @return 当前对象
		*/
		public InspectionTaskPoint setTaskId(String taskId) {
			super.change(TASK_ID,super.getTaskId(),taskId);
			super.setTaskId(taskId);
			return this;
		}
		
		/**
		 * 设置 巡检状态
		 * @param pointStatus 巡检状态
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointStatus(String pointStatus) {
			super.change(POINT_STATUS,super.getPointStatus(),pointStatus);
			super.setPointStatus(pointStatus);
			return this;
		}
		
		/**
		 * 设置 操作时间
		 * @param operTime 操作时间
		 * @return 当前对象
		*/
		public InspectionTaskPoint setOperTime(Date operTime) {
			super.change(OPER_TIME,super.getOperTime(),operTime);
			super.setOperTime(operTime);
			return this;
		}
		
		/**
		 * 设置 巡检结果
		 * @param content 巡检结果
		 * @return 当前对象
		*/
		public InspectionTaskPoint setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 巡检点
		 * @param pointId 巡检点
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointId(String pointId) {
			super.change(POINT_ID,super.getPointId(),pointId);
			super.setPointId(pointId);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param pointCode 编码
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointCode(String pointCode) {
			super.change(POINT_CODE,super.getPointCode(),pointCode);
			super.setPointCode(pointCode);
			return this;
		}
		
		/**
		 * 设置 检
		 * @param pointName 检
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointName(String pointName) {
			super.change(POINT_NAME,super.getPointName(),pointName);
			super.setPointName(pointName);
			return this;
		}
		
		/**
		 * 设置 巡检内容
		 * @param pointContent 巡检内容
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointContent(String pointContent) {
			super.change(POINT_CONTENT,super.getPointContent(),pointContent);
			super.setPointContent(pointContent);
			return this;
		}
		
		/**
		 * 设置 巡检路线
		 * @param pointRouteId 巡检路线
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointRouteId(String pointRouteId) {
			super.change(POINT_ROUTE_ID,super.getPointRouteId(),pointRouteId);
			super.setPointRouteId(pointRouteId);
			return this;
		}
		
		/**
		 * 设置 RFID
		 * @param pointRfid RFID
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointRfid(String pointRfid) {
			super.change(POINT_RFID,super.getPointRfid(),pointRfid);
			super.setPointRfid(pointRfid);
			return this;
		}
		
		/**
		 * 设置 位置详情
		 * @param pointPos 位置详情
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointPos(String pointPos) {
			super.change(POINT_POS,super.getPointPos(),pointPos);
			super.setPointPos(pointPos);
			return this;
		}
		
		/**
		 * 设置 位置
		 * @param pointPosId 位置
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointPosId(String pointPosId) {
			super.change(POINT_POS_ID,super.getPointPosId(),pointPosId);
			super.setPointPosId(pointPosId);
			return this;
		}
		
		/**
		 * 设置 位置经度
		 * @param pointPosLongitude 位置经度
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointPosLongitude(String pointPosLongitude) {
			super.change(POINT_POS_LONGITUDE,super.getPointPosLongitude(),pointPosLongitude);
			super.setPointPosLongitude(pointPosLongitude);
			return this;
		}
		
		/**
		 * 设置 位置纬度
		 * @param pointPosLatitude 位置纬度
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointPosLatitude(String pointPosLatitude) {
			super.change(POINT_POS_LATITUDE,super.getPointPosLatitude(),pointPosLatitude);
			super.setPointPosLatitude(pointPosLatitude);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param pointNotes 备注
		 * @return 当前对象
		*/
		public InspectionTaskPoint setPointNotes(String pointNotes) {
			super.change(POINT_NOTES,super.getPointNotes(),pointNotes);
			super.setPointNotes(pointNotes);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public InspectionTaskPoint setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 操作人
		 * @param operId 操作人
		 * @return 当前对象
		*/
		public InspectionTaskPoint setOperId(String operId) {
			super.change(OPER_ID,super.getOperId(),operId);
			super.setOperId(operId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public InspectionTaskPoint setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InspectionTaskPoint setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InspectionTaskPoint setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InspectionTaskPoint setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InspectionTaskPoint setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InspectionTaskPoint setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InspectionTaskPoint setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InspectionTaskPoint setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public InspectionTaskPoint setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public InspectionTaskPoint setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public InspectionTaskPoint setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 route
		 * @param route route
		 * @return 当前对象
		*/
		public InspectionTaskPoint setRoute(InspectionRoute route) {
			super.change(ROUTE,super.getRoute(),route);
			super.setRoute(route);
			return this;
		}
		
		/**
		 * 设置 task
		 * @param task task
		 * @return 当前对象
		*/
		public InspectionTaskPoint setTask(InspectionTask task) {
			super.change(TASK,super.getTask(),task);
			super.setTask(task);
			return this;
		}
		
		/**
		 * 设置 operUser
		 * @param operUser operUser
		 * @return 当前对象
		*/
		public InspectionTaskPoint setOperUser(Employee operUser) {
			super.change(OPER_USER,super.getOperUser(),operUser);
			super.setOperUser(operUser);
			return this;
		}
		
		/**
		 * 设置 inspectionPointPos
		 * @param inspectionPointPos inspectionPointPos
		 * @return 当前对象
		*/
		public InspectionTaskPoint setInspectionPointPos(InspectionPointPos inspectionPointPos) {
			super.change(INSPECTION_POINT_POS,super.getInspectionPointPos(),inspectionPointPos);
			super.setInspectionPointPos(inspectionPointPos);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public InspectionTaskPointVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public InspectionTaskPointVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
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
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setInspectionPointPos(this.getInspectionPointPos());
				inst.setRoute(this.getRoute());
				inst.setTask(this.getTask());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
				inst.setOperUser(this.getOperUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}