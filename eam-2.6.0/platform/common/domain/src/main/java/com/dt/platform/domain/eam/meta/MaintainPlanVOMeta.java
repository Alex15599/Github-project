package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.MaintainPlanVO;
import java.util.List;
import com.dt.platform.domain.eam.MaintainPlan;
import java.util.Date;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.MaintainProject;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.MaintainGroup;
import com.dt.platform.domain.eam.ActionCrontab;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-12 21:34:12
 * @sign C8E16B1999220CF1B368CB50BBEA512E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class MaintainPlanVOMeta extends MaintainPlanMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,CODE, java.lang.String.class, "编号", "编号", java.lang.String.class, null);
	
	/**
	 * 方案名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 方案名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,NAME, java.lang.String.class, "方案名称", "方案名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 设备 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 设备 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,ASSET_ID, java.lang.String.class, "设备", "设备", java.lang.String.class, null);
	
	/**
	 * 执行班组 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 执行班组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,GROUP_ID, java.lang.String.class, "执行班组", "执行班组", java.lang.String.class, null);
	
	/**
	 * 保养类型 , 类型: java.lang.String
	*/
	public static final String MAINTAIN_TYPE="maintainType";
	
	/**
	 * 保养类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> MAINTAIN_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,MAINTAIN_TYPE, java.lang.String.class, "保养类型", "保养类型", java.lang.String.class, null);
	
	/**
	 * 循环方式 , 类型: java.lang.String
	*/
	public static final String CYCLE_METHOD="cycleMethod";
	
	/**
	 * 循环方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> CYCLE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,CYCLE_METHOD, java.lang.String.class, "循环方式", "循环方式", java.lang.String.class, null);
	
	/**
	 * 保养周期 , 类型: java.lang.String
	*/
	public static final String ACTION_CYCLE_ID="actionCycleId";
	
	/**
	 * 保养周期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> ACTION_CYCLE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,ACTION_CYCLE_ID, java.lang.String.class, "保养周期", "保养周期", java.lang.String.class, null);
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final String START_TIME="startTime";
	
	/**
	 * 开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.util.Date> START_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,START_TIME, java.util.Date.class, "开始时间", "开始时间", java.util.Date.class, null);
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final String END_TIME="endTime";
	
	/**
	 * 结束时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.util.Date> END_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,END_TIME, java.util.Date.class, "结束时间", "结束时间", java.util.Date.class, null);
	
	/**
	 * 预计工时 , 小时) , 类型: java.math.BigDecimal
	*/
	public static final String TOTAL_COST="totalCost";
	
	/**
	 * 预计工时 , 小时) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.math.BigDecimal> TOTAL_COST_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,TOTAL_COST, java.math.BigDecimal.class, "预计工时", "小时)", java.math.BigDecimal.class, null);
	
	/**
	 * 超时时间 , 小时) , 类型: java.math.BigDecimal
	*/
	public static final String TIMEOUT="timeout";
	
	/**
	 * 超时时间 , 小时) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.math.BigDecimal> TIMEOUT_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,TIMEOUT, java.math.BigDecimal.class, "超时时间", "小时)", java.math.BigDecimal.class, null);
	
	/**
	 * 方案说明 , 类型: java.lang.String
	*/
	public static final String INFO="info";
	
	/**
	 * 方案说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> INFO_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,INFO, java.lang.String.class, "方案说明", "方案说明", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET_LIST="assetList";
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,com.dt.platform.domain.eam.Asset> ASSET_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,ASSET_LIST, java.util.List.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ASSET_IDS="assetIds";
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> ASSET_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,ASSET_IDS, java.util.List.class, "资产列表", "资产列表", java.lang.String.class, null);
	
	/**
	 * 项目 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.MaintainProject
	*/
	public static final String PROJECT_LIST="projectList";
	
	/**
	 * 项目 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.MaintainProject
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,com.dt.platform.domain.eam.MaintainProject> PROJECT_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,PROJECT_LIST, java.util.List.class, "项目", "项目", com.dt.platform.domain.eam.MaintainProject.class, null);
	
	/**
	 * 项目 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String PROJECT_IDS="projectIds";
	
	/**
	 * 项目 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,java.lang.String> PROJECT_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,PROJECT_IDS, java.util.List.class, "项目", "项目", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String MAINTAIN_TYPE_DICT="maintainTypeDict";
	
	/**
	 * 类型 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,org.github.foxnic.web.domain.system.DictItem> MAINTAIN_TYPE_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,MAINTAIN_TYPE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "类型", "类型", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 执行班组 , 类型: com.dt.platform.domain.eam.MaintainGroup
	*/
	public static final String MAINTAIN_GROUP="maintainGroup";
	
	/**
	 * 执行班组 , 类型: com.dt.platform.domain.eam.MaintainGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,com.dt.platform.domain.eam.MaintainGroup> MAINTAIN_GROUP_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,MAINTAIN_GROUP, com.dt.platform.domain.eam.MaintainGroup.class, "执行班组", "执行班组", com.dt.platform.domain.eam.MaintainGroup.class, null);
	
	/**
	 * 周期 , 类型: com.dt.platform.domain.eam.ActionCrontab
	*/
	public static final String ACTION_CRONTAB="actionCrontab";
	
	/**
	 * 周期 , 类型: com.dt.platform.domain.eam.ActionCrontab
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,com.dt.platform.domain.eam.ActionCrontab> ACTION_CRONTAB_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,ACTION_CRONTAB, com.dt.platform.domain.eam.ActionCrontab.class, "周期", "周期", com.dt.platform.domain.eam.ActionCrontab.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * asset , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET="asset";
	
	/**
	 * asset , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.MaintainPlanVO,com.dt.platform.domain.eam.Asset> ASSET_PROP = new BeanProperty(com.dt.platform.domain.eam.MaintainPlanVO.class ,ASSET, com.dt.platform.domain.eam.Asset.class, "asset", "asset", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , CODE , NAME , STATUS , ASSET_ID , GROUP_ID , MAINTAIN_TYPE , CYCLE_METHOD , ACTION_CYCLE_ID , START_TIME , END_TIME , TOTAL_COST , TIMEOUT , INFO , NOTES , ORIGINATOR_ID , SELECTED_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , ASSET_LIST , ASSET_IDS , PROJECT_LIST , PROJECT_IDS , MAINTAIN_TYPE_DICT , MAINTAIN_GROUP , ACTION_CRONTAB , ORIGINATOR , ASSET };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.MaintainPlanVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public MaintainPlanVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public MaintainPlanVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public MaintainPlanVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public MaintainPlanVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public MaintainPlanVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public MaintainPlanVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public MaintainPlanVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public MaintainPlanVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public MaintainPlanVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public MaintainPlanVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public MaintainPlanVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public MaintainPlanVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public MaintainPlan setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编号
		 * @param code 编号
		 * @return 当前对象
		*/
		public MaintainPlan setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 方案名称
		 * @param name 方案名称
		 * @return 当前对象
		*/
		public MaintainPlan setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public MaintainPlan setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 设备
		 * @param assetId 设备
		 * @return 当前对象
		*/
		public MaintainPlan setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 执行班组
		 * @param groupId 执行班组
		 * @return 当前对象
		*/
		public MaintainPlan setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 保养类型
		 * @param maintainType 保养类型
		 * @return 当前对象
		*/
		public MaintainPlan setMaintainType(String maintainType) {
			super.change(MAINTAIN_TYPE,super.getMaintainType(),maintainType);
			super.setMaintainType(maintainType);
			return this;
		}
		
		/**
		 * 设置 循环方式
		 * @param cycleMethod 循环方式
		 * @return 当前对象
		*/
		public MaintainPlan setCycleMethod(String cycleMethod) {
			super.change(CYCLE_METHOD,super.getCycleMethod(),cycleMethod);
			super.setCycleMethod(cycleMethod);
			return this;
		}
		
		/**
		 * 设置 保养周期
		 * @param actionCycleId 保养周期
		 * @return 当前对象
		*/
		public MaintainPlan setActionCycleId(String actionCycleId) {
			super.change(ACTION_CYCLE_ID,super.getActionCycleId(),actionCycleId);
			super.setActionCycleId(actionCycleId);
			return this;
		}
		
		/**
		 * 设置 开始时间
		 * @param startTime 开始时间
		 * @return 当前对象
		*/
		public MaintainPlan setStartTime(Date startTime) {
			super.change(START_TIME,super.getStartTime(),startTime);
			super.setStartTime(startTime);
			return this;
		}
		
		/**
		 * 设置 结束时间
		 * @param endTime 结束时间
		 * @return 当前对象
		*/
		public MaintainPlan setEndTime(Date endTime) {
			super.change(END_TIME,super.getEndTime(),endTime);
			super.setEndTime(endTime);
			return this;
		}
		
		/**
		 * 设置 预计工时
		 * @param totalCost 预计工时
		 * @return 当前对象
		*/
		public MaintainPlan setTotalCost(BigDecimal totalCost) {
			super.change(TOTAL_COST,super.getTotalCost(),totalCost);
			super.setTotalCost(totalCost);
			return this;
		}
		
		/**
		 * 设置 超时时间
		 * @param timeout 超时时间
		 * @return 当前对象
		*/
		public MaintainPlan setTimeout(BigDecimal timeout) {
			super.change(TIMEOUT,super.getTimeout(),timeout);
			super.setTimeout(timeout);
			return this;
		}
		
		/**
		 * 设置 方案说明
		 * @param info 方案说明
		 * @return 当前对象
		*/
		public MaintainPlan setInfo(String info) {
			super.change(INFO,super.getInfo(),info);
			super.setInfo(info);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public MaintainPlan setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public MaintainPlan setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public MaintainPlan setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public MaintainPlan setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public MaintainPlan setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public MaintainPlan setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public MaintainPlan setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public MaintainPlan setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public MaintainPlan setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public MaintainPlan setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public MaintainPlan setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public MaintainPlan setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetList 资产
		 * @return 当前对象
		*/
		public MaintainPlan setAssetList(List<Asset> assetList) {
			super.change(ASSET_LIST,super.getAssetList(),assetList);
			super.setAssetList(assetList);
			return this;
		}
		
		/**
		 * 设置 资产列表
		 * @param assetIds 资产列表
		 * @return 当前对象
		*/
		public MaintainPlan setAssetIds(List<String> assetIds) {
			super.change(ASSET_IDS,super.getAssetIds(),assetIds);
			super.setAssetIds(assetIds);
			return this;
		}
		
		/**
		 * 设置 项目
		 * @param projectList 项目
		 * @return 当前对象
		*/
		public MaintainPlan setProjectList(List<MaintainProject> projectList) {
			super.change(PROJECT_LIST,super.getProjectList(),projectList);
			super.setProjectList(projectList);
			return this;
		}
		
		/**
		 * 设置 项目
		 * @param projectIds 项目
		 * @return 当前对象
		*/
		public MaintainPlan setProjectIds(List<String> projectIds) {
			super.change(PROJECT_IDS,super.getProjectIds(),projectIds);
			super.setProjectIds(projectIds);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param maintainTypeDict 类型
		 * @return 当前对象
		*/
		public MaintainPlan setMaintainTypeDict(DictItem maintainTypeDict) {
			super.change(MAINTAIN_TYPE_DICT,super.getMaintainTypeDict(),maintainTypeDict);
			super.setMaintainTypeDict(maintainTypeDict);
			return this;
		}
		
		/**
		 * 设置 执行班组
		 * @param maintainGroup 执行班组
		 * @return 当前对象
		*/
		public MaintainPlan setMaintainGroup(MaintainGroup maintainGroup) {
			super.change(MAINTAIN_GROUP,super.getMaintainGroup(),maintainGroup);
			super.setMaintainGroup(maintainGroup);
			return this;
		}
		
		/**
		 * 设置 周期
		 * @param actionCrontab 周期
		 * @return 当前对象
		*/
		public MaintainPlan setActionCrontab(ActionCrontab actionCrontab) {
			super.change(ACTION_CRONTAB,super.getActionCrontab(),actionCrontab);
			super.setActionCrontab(actionCrontab);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public MaintainPlan setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 asset
		 * @param asset asset
		 * @return 当前对象
		*/
		public MaintainPlan setAsset(Asset asset) {
			super.change(ASSET,super.getAsset(),asset);
			super.setAsset(asset);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public MaintainPlanVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public MaintainPlanVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
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
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setAssetIds(this.getAssetIds());
				inst.setProjectIds(this.getProjectIds());
				inst.setOriginator(this.getOriginator());
				inst.setAssetList(this.getAssetList());
				inst.setMaintainTypeDict(this.getMaintainTypeDict());
				inst.setActionCrontab(this.getActionCrontab());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
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