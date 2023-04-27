package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.CCustInspectPlanVO;
import java.util.List;
import com.dt.platform.domain.eam.CCustInspectPlan;
import java.util.Date;
import com.dt.platform.domain.eam.CCustInspectTpl;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.CCustInspectItem;
import com.dt.platform.domain.eam.Asset;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-11 13:39:23
 * @sign DEE4C9109EB737707310B197D55E4466
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CCustInspectPlanVOMeta extends CCustInspectPlanMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 标题 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 标题 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,NAME, java.lang.String.class, "标题", "标题", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 追加 , 类型: java.lang.String
	*/
	public static final String ACTION_ADD="actionAdd";
	
	/**
	 * 追加 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> ACTION_ADD_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,ACTION_ADD, java.lang.String.class, "追加", "追加", java.lang.String.class, null);
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final String INSPECT_USER_ID="inspectUserId";
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> INSPECT_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,INSPECT_USER_ID, java.lang.String.class, "负责人", "负责人", java.lang.String.class, null);
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final String TPL_ID="tplId";
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,TPL_ID, java.lang.String.class, "模版", "模版", java.lang.String.class, null);
	
	/**
	 * 触发周期 , 类型: java.lang.String
	*/
	public static final String CRONTAB="crontab";
	
	/**
	 * 触发周期 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> CRONTAB_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,CRONTAB, java.lang.String.class, "触发周期", "触发周期", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 上次执行时间 , 类型: java.util.Date
	*/
	public static final String LAST_TIME="lastTime";
	
	/**
	 * 上次执行时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.util.Date> LAST_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,LAST_TIME, java.util.Date.class, "上次执行时间", "上次执行时间", java.util.Date.class, null);
	
	/**
	 * 下次执行时间 , 类型: java.util.Date
	*/
	public static final String NEXT_TIME="nextTime";
	
	/**
	 * 下次执行时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.util.Date> NEXT_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,NEXT_TIME, java.util.Date.class, "下次执行时间", "下次执行时间", java.util.Date.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * custInspectTpl , 类型: com.dt.platform.domain.eam.CCustInspectTpl
	*/
	public static final String CUST_INSPECT_TPL="custInspectTpl";
	
	/**
	 * custInspectTpl , 类型: com.dt.platform.domain.eam.CCustInspectTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,com.dt.platform.domain.eam.CCustInspectTpl> CUST_INSPECT_TPL_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,CUST_INSPECT_TPL, com.dt.platform.domain.eam.CCustInspectTpl.class, "custInspectTpl", "custInspectTpl", com.dt.platform.domain.eam.CCustInspectTpl.class, null);
	
	/**
	 * leader , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String LEADER="leader";
	
	/**
	 * leader , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,org.github.foxnic.web.domain.hrm.Employee> LEADER_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,LEADER, org.github.foxnic.web.domain.hrm.Employee.class, "leader", "leader", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 巡检人 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String MEMBER_LIST="memberList";
	
	/**
	 * 巡检人 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,org.github.foxnic.web.domain.hrm.Employee> MEMBER_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,MEMBER_LIST, java.util.List.class, "巡检人", "巡检人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 巡检人 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String MEMBER_IDS="memberIds";
	
	/**
	 * 巡检人 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> MEMBER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,MEMBER_IDS, java.util.List.class, "巡检人", "巡检人", java.lang.String.class, null);
	
	/**
	 * custInspectItemList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.CCustInspectItem
	*/
	public static final String CUST_INSPECT_ITEM_LIST="custInspectItemList";
	
	/**
	 * custInspectItemList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.CCustInspectItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,com.dt.platform.domain.eam.CCustInspectItem> CUST_INSPECT_ITEM_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,CUST_INSPECT_ITEM_LIST, java.util.List.class, "custInspectItemList", "custInspectItemList", com.dt.platform.domain.eam.CCustInspectItem.class, null);
	
	/**
	 * custInspectItemIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String CUST_INSPECT_ITEM_IDS="custInspectItemIds";
	
	/**
	 * custInspectItemIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,java.lang.String> CUST_INSPECT_ITEM_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,CUST_INSPECT_ITEM_IDS, java.util.List.class, "custInspectItemIds", "custInspectItemIds", java.lang.String.class, null);
	
	/**
	 * assetInTplList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET_IN_TPL_LIST="assetInTplList";
	
	/**
	 * assetInTplList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectPlanVO,com.dt.platform.domain.eam.Asset> ASSET_IN_TPL_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectPlanVO.class ,ASSET_IN_TPL_LIST, java.util.List.class, "assetInTplList", "assetInTplList", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , NAME , STATUS , ACTION_ADD , INSPECT_USER_ID , TPL_ID , CRONTAB , NOTES , LAST_TIME , NEXT_TIME , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , TENANT_ID , VERSION , CUST_INSPECT_TPL , LEADER , MEMBER_LIST , MEMBER_IDS , CUST_INSPECT_ITEM_LIST , CUST_INSPECT_ITEM_IDS , ASSET_IN_TPL_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.CCustInspectPlanVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public CCustInspectPlanVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public CCustInspectPlanVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public CCustInspectPlanVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public CCustInspectPlanVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public CCustInspectPlanVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public CCustInspectPlanVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public CCustInspectPlanVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public CCustInspectPlanVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public CCustInspectPlanVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public CCustInspectPlanVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public CCustInspectPlanVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public CCustInspectPlanVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CCustInspectPlan setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 标题
		 * @param name 标题
		 * @return 当前对象
		*/
		public CCustInspectPlan setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public CCustInspectPlan setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 追加
		 * @param actionAdd 追加
		 * @return 当前对象
		*/
		public CCustInspectPlan setActionAdd(String actionAdd) {
			super.change(ACTION_ADD,super.getActionAdd(),actionAdd);
			super.setActionAdd(actionAdd);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param inspectUserId 负责人
		 * @return 当前对象
		*/
		public CCustInspectPlan setInspectUserId(String inspectUserId) {
			super.change(INSPECT_USER_ID,super.getInspectUserId(),inspectUserId);
			super.setInspectUserId(inspectUserId);
			return this;
		}
		
		/**
		 * 设置 模版
		 * @param tplId 模版
		 * @return 当前对象
		*/
		public CCustInspectPlan setTplId(String tplId) {
			super.change(TPL_ID,super.getTplId(),tplId);
			super.setTplId(tplId);
			return this;
		}
		
		/**
		 * 设置 触发周期
		 * @param crontab 触发周期
		 * @return 当前对象
		*/
		public CCustInspectPlan setCrontab(String crontab) {
			super.change(CRONTAB,super.getCrontab(),crontab);
			super.setCrontab(crontab);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CCustInspectPlan setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 上次执行时间
		 * @param lastTime 上次执行时间
		 * @return 当前对象
		*/
		public CCustInspectPlan setLastTime(Date lastTime) {
			super.change(LAST_TIME,super.getLastTime(),lastTime);
			super.setLastTime(lastTime);
			return this;
		}
		
		/**
		 * 设置 下次执行时间
		 * @param nextTime 下次执行时间
		 * @return 当前对象
		*/
		public CCustInspectPlan setNextTime(Date nextTime) {
			super.change(NEXT_TIME,super.getNextTime(),nextTime);
			super.setNextTime(nextTime);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CCustInspectPlan setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CCustInspectPlan setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CCustInspectPlan setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CCustInspectPlan setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CCustInspectPlan setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CCustInspectPlan setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CCustInspectPlan setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public CCustInspectPlan setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CCustInspectPlan setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 custInspectTpl
		 * @param custInspectTpl custInspectTpl
		 * @return 当前对象
		*/
		public CCustInspectPlan setCustInspectTpl(CCustInspectTpl custInspectTpl) {
			super.change(CUST_INSPECT_TPL,super.getCustInspectTpl(),custInspectTpl);
			super.setCustInspectTpl(custInspectTpl);
			return this;
		}
		
		/**
		 * 设置 leader
		 * @param leader leader
		 * @return 当前对象
		*/
		public CCustInspectPlan setLeader(Employee leader) {
			super.change(LEADER,super.getLeader(),leader);
			super.setLeader(leader);
			return this;
		}
		
		/**
		 * 设置 巡检人
		 * @param memberList 巡检人
		 * @return 当前对象
		*/
		public CCustInspectPlan setMemberList(List<Employee> memberList) {
			super.change(MEMBER_LIST,super.getMemberList(),memberList);
			super.setMemberList(memberList);
			return this;
		}
		
		/**
		 * 设置 巡检人
		 * @param memberIds 巡检人
		 * @return 当前对象
		*/
		public CCustInspectPlan setMemberIds(List<String> memberIds) {
			super.change(MEMBER_IDS,super.getMemberIds(),memberIds);
			super.setMemberIds(memberIds);
			return this;
		}
		
		/**
		 * 设置 custInspectItemList
		 * @param custInspectItemList custInspectItemList
		 * @return 当前对象
		*/
		public CCustInspectPlan setCustInspectItemList(List<CCustInspectItem> custInspectItemList) {
			super.change(CUST_INSPECT_ITEM_LIST,super.getCustInspectItemList(),custInspectItemList);
			super.setCustInspectItemList(custInspectItemList);
			return this;
		}
		
		/**
		 * 设置 custInspectItemIds
		 * @param custInspectItemIds custInspectItemIds
		 * @return 当前对象
		*/
		public CCustInspectPlan setCustInspectItemIds(List<String> custInspectItemIds) {
			super.change(CUST_INSPECT_ITEM_IDS,super.getCustInspectItemIds(),custInspectItemIds);
			super.setCustInspectItemIds(custInspectItemIds);
			return this;
		}
		
		/**
		 * 设置 assetInTplList
		 * @param assetInTplList assetInTplList
		 * @return 当前对象
		*/
		public CCustInspectPlan setAssetInTplList(List<Asset> assetInTplList) {
			super.change(ASSET_IN_TPL_LIST,super.getAssetInTplList(),assetInTplList);
			super.setAssetInTplList(assetInTplList);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CCustInspectPlanVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CCustInspectPlanVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setLastTime(this.getLastTime());
			inst.setNotes(this.getNotes());
			inst.setCrontab(this.getCrontab());
			inst.setNextTime(this.getNextTime());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setActionAdd(this.getActionAdd());
			inst.setId(this.getId());
			inst.setTplId(this.getTplId());
			inst.setInspectUserId(this.getInspectUserId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setAssetInTplList(this.getAssetInTplList());
				inst.setLeader(this.getLeader());
				inst.setCustInspectItemList(this.getCustInspectItemList());
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setMemberList(this.getMemberList());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
				inst.setCustInspectTpl(this.getCustInspectTpl());
				inst.setMemberIds(this.getMemberIds());
				inst.setCustInspectItemIds(this.getCustInspectItemIds());
			}
			inst.clearModifies();
			return inst;
		}

	}
}