package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.MaintainTaskVO;
import java.util.List;
import com.dt.platform.domain.eam.MaintainTask;
import java.util.Date;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.MaintainProject;
import com.dt.platform.domain.eam.MaintainTaskProject;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.MaintainPlan;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.MaintainGroup;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-14 07:30:10
 * @sign 8B3D8B895A93C4002249F053A1457FB2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MaintainTaskVOMeta extends MaintainTaskMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 任务单据 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 任务单据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,BUSINESS_CODE, java.lang.String.class, "任务单据", "任务单据", java.lang.String.class, null);
	
	/**
	 * 方案 , 类型: java.lang.String
	*/
	public static final String PLAN_ID="planId";
	
	/**
	 * 方案 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> PLAN_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,PLAN_ID, java.lang.String.class, "方案", "方案", java.lang.String.class, null);
	
	/**
	 * 保养类型 , 类型: java.lang.String
	*/
	public static final String MAINTAIN_TYPE="maintainType";
	
	/**
	 * 保养类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> MAINTAIN_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,MAINTAIN_TYPE, java.lang.String.class, "保养类型", "保养类型", java.lang.String.class, null);
	
	/**
	 * 执行班组 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 执行班组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,GROUP_ID, java.lang.String.class, "执行班组", "执行班组", java.lang.String.class, null);
	
	/**
	 * 设备 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 设备 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ASSET_ID, java.lang.String.class, "设备", "设备", java.lang.String.class, null);
	
	/**
	 * 设备名称 , 类型: java.lang.String
	*/
	public static final String ASSET_NAME="assetName";
	
	/**
	 * 设备名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> ASSET_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ASSET_NAME, java.lang.String.class, "设备名称", "设备名称", java.lang.String.class, null);
	
	/**
	 * 设备编码 , 类型: java.lang.String
	*/
	public static final String ASSET_CODE="assetCode";
	
	/**
	 * 设备编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> ASSET_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ASSET_CODE, java.lang.String.class, "设备编码", "设备编码", java.lang.String.class, null);
	
	/**
	 * 设备型号 , 类型: java.lang.String
	*/
	public static final String ASSET_MODEL="assetModel";
	
	/**
	 * 设备型号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> ASSET_MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ASSET_MODEL, java.lang.String.class, "设备型号", "设备型号", java.lang.String.class, null);
	
	/**
	 * 设备状态 , 类型: java.lang.String
	*/
	public static final String ASSET_STATUS="assetStatus";
	
	/**
	 * 设备状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> ASSET_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ASSET_STATUS, java.lang.String.class, "设备状态", "设备状态", java.lang.String.class, null);
	
	/**
	 * 设备序列号 , 类型: java.lang.String
	*/
	public static final String ASSET_SN="assetSn";
	
	/**
	 * 设备序列号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> ASSET_SN_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ASSET_SN, java.lang.String.class, "设备序列号", "设备序列号", java.lang.String.class, null);
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final String ASSET_POS="assetPos";
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> ASSET_POS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ASSET_POS, java.lang.String.class, "位置", "位置", java.lang.String.class, null);
	
	/**
	 * 保养结果 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 保养结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,CONTENT, java.lang.String.class, "保养结果", "保养结果", java.lang.String.class, null);
	
	/**
	 * 执行人 , 类型: java.lang.String
	*/
	public static final String EXECUTOR_ID="executorId";
	
	/**
	 * 执行人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> EXECUTOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,EXECUTOR_ID, java.lang.String.class, "执行人", "执行人", java.lang.String.class, null);
	
	/**
	 * 应开始时间 , 类型: java.util.Date
	*/
	public static final String PLAN_START_TIME="planStartTime";
	
	/**
	 * 应开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.util.Date> PLAN_START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,PLAN_START_TIME, java.util.Date.class, "应开始时间", "应开始时间", java.util.Date.class, null);
	
	/**
	 * 实际开始时间 , 类型: java.util.Date
	*/
	public static final String ACT_START_TIME="actStartTime";
	
	/**
	 * 实际开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.util.Date> ACT_START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ACT_START_TIME, java.util.Date.class, "实际开始时间", "实际开始时间", java.util.Date.class, null);
	
	/**
	 * 实际完成时间 , 类型: java.util.Date
	*/
	public static final String ACT_FINISH_TIME="actFinishTime";
	
	/**
	 * 实际完成时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.util.Date> ACT_FINISH_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ACT_FINISH_TIME, java.util.Date.class, "实际完成时间", "实际完成时间", java.util.Date.class, null);
	
	/**
	 * 超时时间 , 类型: java.math.BigDecimal
	*/
	public static final String TIMEOUT="timeout";
	
	/**
	 * 超时时间 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.math.BigDecimal> TIMEOUT_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,TIMEOUT, java.math.BigDecimal.class, "超时时间", "超时时间", java.math.BigDecimal.class, null);
	
	/**
	 * 预计工时 , 类型: java.math.BigDecimal
	*/
	public static final String TOTAL_COST="totalCost";
	
	/**
	 * 预计工时 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.math.BigDecimal> TOTAL_COST_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,TOTAL_COST, java.math.BigDecimal.class, "预计工时", "预计工时", java.math.BigDecimal.class, null);
	
	/**
	 * 实际工时 , 类型: java.math.BigDecimal
	*/
	public static final String ACT_TOTAL_COST="actTotalCost";
	
	/**
	 * 实际工时 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.math.BigDecimal> ACT_TOTAL_COST_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ACT_TOTAL_COST, java.math.BigDecimal.class, "实际工时", "实际工时", java.math.BigDecimal.class, null);
	
	/**
	 * 费用 , 元) , 类型: java.math.BigDecimal
	*/
	public static final String COST="cost";
	
	/**
	 * 费用 , 元) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.math.BigDecimal> COST_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,COST, java.math.BigDecimal.class, "费用", "元)", java.math.BigDecimal.class, null);
	
	/**
	 * 逾期 , 类型: java.lang.String
	*/
	public static final String OVERDUE="overdue";
	
	/**
	 * 逾期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> OVERDUE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,OVERDUE, java.lang.String.class, "逾期", "逾期", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 项目 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.MaintainProject
	*/
	public static final String PROJECT_LIST="projectList";
	
	/**
	 * 项目 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.MaintainProject
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,com.dt.platform.domain.eam.MaintainProject> PROJECT_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,PROJECT_LIST, java.util.List.class, "项目", "项目", com.dt.platform.domain.eam.MaintainProject.class, null);
	
	/**
	 * 项目 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String PROJECT_IDS="projectIds";
	
	/**
	 * 项目 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> PROJECT_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,PROJECT_IDS, java.util.List.class, "项目", "项目", java.lang.String.class, null);
	
	/**
	 * 项目 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.MaintainTaskProject
	*/
	public static final String TASK_PROJECT_LIST="taskProjectList";
	
	/**
	 * 项目 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.MaintainTaskProject
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,com.dt.platform.domain.eam.MaintainTaskProject> TASK_PROJECT_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,TASK_PROJECT_LIST, java.util.List.class, "项目", "项目", com.dt.platform.domain.eam.MaintainTaskProject.class, null);
	
	/**
	 * 项目 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String TASK_PROJECT_IDS="taskProjectIds";
	
	/**
	 * 项目 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,java.lang.String> TASK_PROJECT_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,TASK_PROJECT_IDS, java.util.List.class, "项目", "项目", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET="asset";
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,com.dt.platform.domain.eam.Asset> ASSET_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ASSET, com.dt.platform.domain.eam.Asset.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 方案 , 类型: com.dt.platform.domain.eam.MaintainPlan
	*/
	public static final String MAINTAIN_PLAN="maintainPlan";
	
	/**
	 * 方案 , 类型: com.dt.platform.domain.eam.MaintainPlan
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,com.dt.platform.domain.eam.MaintainPlan> MAINTAIN_PLAN_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,MAINTAIN_PLAN, com.dt.platform.domain.eam.MaintainPlan.class, "方案", "方案", com.dt.platform.domain.eam.MaintainPlan.class, null);
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String MAINTAIN_TYPE_DICT="maintainTypeDict";
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,org.github.foxnic.web.domain.system.DictItem> MAINTAIN_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,MAINTAIN_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "类型", "类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 执行班组 , 类型: com.dt.platform.domain.eam.MaintainGroup
	*/
	public static final String MAINTAIN_GROUP="maintainGroup";
	
	/**
	 * 执行班组 , 类型: com.dt.platform.domain.eam.MaintainGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,com.dt.platform.domain.eam.MaintainGroup> MAINTAIN_GROUP_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,MAINTAIN_GROUP, com.dt.platform.domain.eam.MaintainGroup.class, "执行班组", "执行班组", com.dt.platform.domain.eam.MaintainGroup.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 执行人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EXECUTOR="executor";
	
	/**
	 * 执行人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainTaskVO,org.github.foxnic.web.domain.hrm.Employee> EXECUTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainTaskVO.class ,EXECUTOR, org.github.foxnic.web.domain.hrm.Employee.class, "执行人", "执行人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , NAME , STATUS , BUSINESS_CODE , PLAN_ID , MAINTAIN_TYPE , GROUP_ID , ASSET_ID , ASSET_NAME , ASSET_CODE , ASSET_MODEL , ASSET_STATUS , ASSET_SN , ASSET_POS , CONTENT , EXECUTOR_ID , PLAN_START_TIME , ACT_START_TIME , ACT_FINISH_TIME , TIMEOUT , TOTAL_COST , ACT_TOTAL_COST , COST , OVERDUE , NOTES , SELECTED_CODE , ORIGINATOR_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , PROJECT_LIST , PROJECT_IDS , TASK_PROJECT_LIST , TASK_PROJECT_IDS , ASSET , MAINTAIN_PLAN , MAINTAIN_TYPE_DICT , MAINTAIN_GROUP , ORIGINATOR , EXECUTOR };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.MaintainTaskVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public MaintainTaskVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public MaintainTaskVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public MaintainTaskVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public MaintainTaskVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public MaintainTaskVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public MaintainTaskVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public MaintainTaskVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public MaintainTaskVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public MaintainTaskVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public MaintainTaskVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public MaintainTaskVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public MaintainTaskVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MaintainTask setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public MaintainTask setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public MaintainTask setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 任务单据
		 * @param businessCode 任务单据
		 * @return 当前对象
		*/
		public MaintainTask setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 方案
		 * @param planId 方案
		 * @return 当前对象
		*/
		public MaintainTask setPlanId(String planId) {
			super.change(PLAN_ID,super.getPlanId(),planId);
			super.setPlanId(planId);
			return this;
		}
		
		/**
		 * 设置 保养类型
		 * @param maintainType 保养类型
		 * @return 当前对象
		*/
		public MaintainTask setMaintainType(String maintainType) {
			super.change(MAINTAIN_TYPE,super.getMaintainType(),maintainType);
			super.setMaintainType(maintainType);
			return this;
		}
		
		/**
		 * 设置 执行班组
		 * @param groupId 执行班组
		 * @return 当前对象
		*/
		public MaintainTask setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 设备
		 * @param assetId 设备
		 * @return 当前对象
		*/
		public MaintainTask setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 设备名称
		 * @param assetName 设备名称
		 * @return 当前对象
		*/
		public MaintainTask setAssetName(String assetName) {
			super.change(ASSET_NAME,super.getAssetName(),assetName);
			super.setAssetName(assetName);
			return this;
		}
		
		/**
		 * 设置 设备编码
		 * @param assetCode 设备编码
		 * @return 当前对象
		*/
		public MaintainTask setAssetCode(String assetCode) {
			super.change(ASSET_CODE,super.getAssetCode(),assetCode);
			super.setAssetCode(assetCode);
			return this;
		}
		
		/**
		 * 设置 设备型号
		 * @param assetModel 设备型号
		 * @return 当前对象
		*/
		public MaintainTask setAssetModel(String assetModel) {
			super.change(ASSET_MODEL,super.getAssetModel(),assetModel);
			super.setAssetModel(assetModel);
			return this;
		}
		
		/**
		 * 设置 设备状态
		 * @param assetStatus 设备状态
		 * @return 当前对象
		*/
		public MaintainTask setAssetStatus(String assetStatus) {
			super.change(ASSET_STATUS,super.getAssetStatus(),assetStatus);
			super.setAssetStatus(assetStatus);
			return this;
		}
		
		/**
		 * 设置 设备序列号
		 * @param assetSn 设备序列号
		 * @return 当前对象
		*/
		public MaintainTask setAssetSn(String assetSn) {
			super.change(ASSET_SN,super.getAssetSn(),assetSn);
			super.setAssetSn(assetSn);
			return this;
		}
		
		/**
		 * 设置 位置
		 * @param assetPos 位置
		 * @return 当前对象
		*/
		public MaintainTask setAssetPos(String assetPos) {
			super.change(ASSET_POS,super.getAssetPos(),assetPos);
			super.setAssetPos(assetPos);
			return this;
		}
		
		/**
		 * 设置 保养结果
		 * @param content 保养结果
		 * @return 当前对象
		*/
		public MaintainTask setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 执行人
		 * @param executorId 执行人
		 * @return 当前对象
		*/
		public MaintainTask setExecutorId(String executorId) {
			super.change(EXECUTOR_ID,super.getExecutorId(),executorId);
			super.setExecutorId(executorId);
			return this;
		}
		
		/**
		 * 设置 应开始时间
		 * @param planStartTime 应开始时间
		 * @return 当前对象
		*/
		public MaintainTask setPlanStartTime(Date planStartTime) {
			super.change(PLAN_START_TIME,super.getPlanStartTime(),planStartTime);
			super.setPlanStartTime(planStartTime);
			return this;
		}
		
		/**
		 * 设置 实际开始时间
		 * @param actStartTime 实际开始时间
		 * @return 当前对象
		*/
		public MaintainTask setActStartTime(Date actStartTime) {
			super.change(ACT_START_TIME,super.getActStartTime(),actStartTime);
			super.setActStartTime(actStartTime);
			return this;
		}
		
		/**
		 * 设置 实际完成时间
		 * @param actFinishTime 实际完成时间
		 * @return 当前对象
		*/
		public MaintainTask setActFinishTime(Date actFinishTime) {
			super.change(ACT_FINISH_TIME,super.getActFinishTime(),actFinishTime);
			super.setActFinishTime(actFinishTime);
			return this;
		}
		
		/**
		 * 设置 超时时间
		 * @param timeout 超时时间
		 * @return 当前对象
		*/
		public MaintainTask setTimeout(BigDecimal timeout) {
			super.change(TIMEOUT,super.getTimeout(),timeout);
			super.setTimeout(timeout);
			return this;
		}
		
		/**
		 * 设置 预计工时
		 * @param totalCost 预计工时
		 * @return 当前对象
		*/
		public MaintainTask setTotalCost(BigDecimal totalCost) {
			super.change(TOTAL_COST,super.getTotalCost(),totalCost);
			super.setTotalCost(totalCost);
			return this;
		}
		
		/**
		 * 设置 实际工时
		 * @param actTotalCost 实际工时
		 * @return 当前对象
		*/
		public MaintainTask setActTotalCost(BigDecimal actTotalCost) {
			super.change(ACT_TOTAL_COST,super.getActTotalCost(),actTotalCost);
			super.setActTotalCost(actTotalCost);
			return this;
		}
		
		/**
		 * 设置 费用
		 * @param cost 费用
		 * @return 当前对象
		*/
		public MaintainTask setCost(BigDecimal cost) {
			super.change(COST,super.getCost(),cost);
			super.setCost(cost);
			return this;
		}
		
		/**
		 * 设置 逾期
		 * @param overdue 逾期
		 * @return 当前对象
		*/
		public MaintainTask setOverdue(String overdue) {
			super.change(OVERDUE,super.getOverdue(),overdue);
			super.setOverdue(overdue);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MaintainTask setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public MaintainTask setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public MaintainTask setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MaintainTask setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MaintainTask setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MaintainTask setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MaintainTask setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MaintainTask setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MaintainTask setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MaintainTask setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public MaintainTask setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public MaintainTask setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 项目
		 * @param projectList 项目
		 * @return 当前对象
		*/
		public MaintainTask setProjectList(List<MaintainProject> projectList) {
			super.change(PROJECT_LIST,super.getProjectList(),projectList);
			super.setProjectList(projectList);
			return this;
		}
		
		/**
		 * 设置 项目
		 * @param projectIds 项目
		 * @return 当前对象
		*/
		public MaintainTask setProjectIds(List<String> projectIds) {
			super.change(PROJECT_IDS,super.getProjectIds(),projectIds);
			super.setProjectIds(projectIds);
			return this;
		}
		
		/**
		 * 设置 项目
		 * @param taskProjectList 项目
		 * @return 当前对象
		*/
		public MaintainTask setTaskProjectList(List<MaintainTaskProject> taskProjectList) {
			super.change(TASK_PROJECT_LIST,super.getTaskProjectList(),taskProjectList);
			super.setTaskProjectList(taskProjectList);
			return this;
		}
		
		/**
		 * 设置 项目
		 * @param taskProjectIds 项目
		 * @return 当前对象
		*/
		public MaintainTask setTaskProjectIds(List<String> taskProjectIds) {
			super.change(TASK_PROJECT_IDS,super.getTaskProjectIds(),taskProjectIds);
			super.setTaskProjectIds(taskProjectIds);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param asset 资产
		 * @return 当前对象
		*/
		public MaintainTask setAsset(Asset asset) {
			super.change(ASSET,super.getAsset(),asset);
			super.setAsset(asset);
			return this;
		}
		
		/**
		 * 设置 方案
		 * @param maintainPlan 方案
		 * @return 当前对象
		*/
		public MaintainTask setMaintainPlan(MaintainPlan maintainPlan) {
			super.change(MAINTAIN_PLAN,super.getMaintainPlan(),maintainPlan);
			super.setMaintainPlan(maintainPlan);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param maintainTypeDict 类型
		 * @return 当前对象
		*/
		public MaintainTask setMaintainTypeDict(DictItem maintainTypeDict) {
			super.change(MAINTAIN_TYPE_DICT,super.getMaintainTypeDict(),maintainTypeDict);
			super.setMaintainTypeDict(maintainTypeDict);
			return this;
		}
		
		/**
		 * 设置 执行班组
		 * @param maintainGroup 执行班组
		 * @return 当前对象
		*/
		public MaintainTask setMaintainGroup(MaintainGroup maintainGroup) {
			super.change(MAINTAIN_GROUP,super.getMaintainGroup(),maintainGroup);
			super.setMaintainGroup(maintainGroup);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public MaintainTask setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 执行人
		 * @param executor 执行人
		 * @return 当前对象
		*/
		public MaintainTask setExecutor(Employee executor) {
			super.change(EXECUTOR,super.getExecutor(),executor);
			super.setExecutor(executor);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public MaintainTaskVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public MaintainTaskVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
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
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setProjectIds(this.getProjectIds());
				inst.setTaskProjectIds(this.getTaskProjectIds());
				inst.setOriginator(this.getOriginator());
				inst.setMaintainTypeDict(this.getMaintainTypeDict());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setExecutor(this.getExecutor());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setAsset(this.getAsset());
				inst.setSearchValue(this.getSearchValue());
				inst.setMaintainGroup(this.getMaintainGroup());
			}
			inst.clearModifies();
			return inst;
		}

	}
}