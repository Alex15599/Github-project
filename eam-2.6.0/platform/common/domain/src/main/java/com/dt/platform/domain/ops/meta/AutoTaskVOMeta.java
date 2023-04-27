package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.AutoTaskVO;
import java.util.List;
import com.dt.platform.domain.ops.AutoTask;
import java.util.Date;
import com.dt.platform.domain.ops.AutoGroup;
import com.dt.platform.domain.ops.AutoBatch;
import com.dt.platform.domain.ops.AutoAction;
import com.dt.platform.domain.ops.AutoNode;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-24 08:44:56
 * @sign B1CE662BECAE3FCFFFE43FD667718D21
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AutoTaskVOMeta extends AutoTaskMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,OWNER_ID, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 运行状态 , 类型: java.lang.String
	*/
	public static final String RUN_STATUS="runStatus";
	
	/**
	 * 运行状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> RUN_STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,RUN_STATUS, java.lang.String.class, "运行状态", "运行状态", java.lang.String.class, null);
	
	/**
	 * 分组 , 类型: java.lang.String
	*/
	public static final String GROUP_ID="groupId";
	
	/**
	 * 分组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> GROUP_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,GROUP_ID, java.lang.String.class, "分组", "分组", java.lang.String.class, null);
	
	/**
	 * 批次 , 类型: java.lang.String
	*/
	public static final String BATCH_ID="batchId";
	
	/**
	 * 批次 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> BATCH_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,BATCH_ID, java.lang.String.class, "批次", "批次", java.lang.String.class, null);
	
	/**
	 * 部署模版 , 类型: java.lang.String
	*/
	public static final String ACTION_ID="actionId";
	
	/**
	 * 部署模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> ACTION_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,ACTION_ID, java.lang.String.class, "部署模版", "部署模版", java.lang.String.class, null);
	
	/**
	 * 动作配置 , 类型: java.lang.String
	*/
	public static final String CONF_CONTENT="confContent";
	
	/**
	 * 动作配置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> CONF_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,CONF_CONTENT, java.lang.String.class, "动作配置", "动作配置", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * group , 类型: com.dt.platform.domain.ops.AutoGroup
	*/
	public static final String GROUP="group";
	
	/**
	 * group , 类型: com.dt.platform.domain.ops.AutoGroup
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,com.dt.platform.domain.ops.AutoGroup> GROUP_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,GROUP, com.dt.platform.domain.ops.AutoGroup.class, "group", "group", com.dt.platform.domain.ops.AutoGroup.class, null);
	
	/**
	 * batch , 类型: com.dt.platform.domain.ops.AutoBatch
	*/
	public static final String BATCH="batch";
	
	/**
	 * batch , 类型: com.dt.platform.domain.ops.AutoBatch
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,com.dt.platform.domain.ops.AutoBatch> BATCH_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,BATCH, com.dt.platform.domain.ops.AutoBatch.class, "batch", "batch", com.dt.platform.domain.ops.AutoBatch.class, null);
	
	/**
	 * action , 类型: com.dt.platform.domain.ops.AutoAction
	*/
	public static final String ACTION="action";
	
	/**
	 * action , 类型: com.dt.platform.domain.ops.AutoAction
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,com.dt.platform.domain.ops.AutoAction> ACTION_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,ACTION, com.dt.platform.domain.ops.AutoAction.class, "action", "action", com.dt.platform.domain.ops.AutoAction.class, null);
	
	/**
	 * actionConfContent , 类型: java.lang.String
	*/
	public static final String ACTION_CONF_CONTENT="actionConfContent";
	
	/**
	 * actionConfContent , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> ACTION_CONF_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,ACTION_CONF_CONTENT, java.lang.String.class, "actionConfContent", "actionConfContent", java.lang.String.class, null);
	
	/**
	 * actionExecuteContent , 类型: java.lang.String
	*/
	public static final String ACTION_EXECUTE_CONTENT="actionExecuteContent";
	
	/**
	 * actionExecuteContent , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> ACTION_EXECUTE_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,ACTION_EXECUTE_CONTENT, java.lang.String.class, "actionExecuteContent", "actionExecuteContent", java.lang.String.class, null);
	
	/**
	 * actionInfo , 类型: java.lang.String
	*/
	public static final String ACTION_INFO="actionInfo";
	
	/**
	 * actionInfo , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> ACTION_INFO_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,ACTION_INFO, java.lang.String.class, "actionInfo", "actionInfo", java.lang.String.class, null);
	
	/**
	 * actionSupport , 类型: java.lang.String
	*/
	public static final String ACTION_SUPPORT="actionSupport";
	
	/**
	 * actionSupport , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> ACTION_SUPPORT_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,ACTION_SUPPORT, java.lang.String.class, "actionSupport", "actionSupport", java.lang.String.class, null);
	
	/**
	 * nodeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.AutoNode
	*/
	public static final String NODE_LIST="nodeList";
	
	/**
	 * nodeList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.AutoNode
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,com.dt.platform.domain.ops.AutoNode> NODE_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,NODE_LIST, java.util.List.class, "nodeList", "nodeList", com.dt.platform.domain.ops.AutoNode.class, null);
	
	/**
	 * nodeIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String NODE_IDS="nodeIds";
	
	/**
	 * nodeIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.AutoTaskVO,java.lang.String> NODE_IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.AutoTaskVO.class ,NODE_IDS, java.util.List.class, "nodeIds", "nodeIds", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , OWNER_ID , NAME , STATUS , RUN_STATUS , GROUP_ID , BATCH_ID , ACTION_ID , CONF_CONTENT , NOTES , SELECTED_CODE , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , GROUP , BATCH , ACTION , ACTION_CONF_CONTENT , ACTION_EXECUTE_CONTENT , ACTION_INFO , ACTION_SUPPORT , NODE_LIST , NODE_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.AutoTaskVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AutoTaskVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AutoTaskVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AutoTaskVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AutoTaskVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AutoTaskVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AutoTaskVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AutoTaskVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AutoTaskVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AutoTaskVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AutoTask setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param ownerId 所属
		 * @return 当前对象
		*/
		public AutoTask setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public AutoTask setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public AutoTask setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 运行状态
		 * @param runStatus 运行状态
		 * @return 当前对象
		*/
		public AutoTask setRunStatus(String runStatus) {
			super.change(RUN_STATUS,super.getRunStatus(),runStatus);
			super.setRunStatus(runStatus);
			return this;
		}
		
		/**
		 * 设置 分组
		 * @param groupId 分组
		 * @return 当前对象
		*/
		public AutoTask setGroupId(String groupId) {
			super.change(GROUP_ID,super.getGroupId(),groupId);
			super.setGroupId(groupId);
			return this;
		}
		
		/**
		 * 设置 批次
		 * @param batchId 批次
		 * @return 当前对象
		*/
		public AutoTask setBatchId(String batchId) {
			super.change(BATCH_ID,super.getBatchId(),batchId);
			super.setBatchId(batchId);
			return this;
		}
		
		/**
		 * 设置 部署模版
		 * @param actionId 部署模版
		 * @return 当前对象
		*/
		public AutoTask setActionId(String actionId) {
			super.change(ACTION_ID,super.getActionId(),actionId);
			super.setActionId(actionId);
			return this;
		}
		
		/**
		 * 设置 动作配置
		 * @param confContent 动作配置
		 * @return 当前对象
		*/
		public AutoTask setConfContent(String confContent) {
			super.change(CONF_CONTENT,super.getConfContent(),confContent);
			super.setConfContent(confContent);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AutoTask setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public AutoTask setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AutoTask setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AutoTask setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AutoTask setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AutoTask setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AutoTask setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AutoTask setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AutoTask setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 group
		 * @param group group
		 * @return 当前对象
		*/
		public AutoTask setGroup(AutoGroup group) {
			super.change(GROUP,super.getGroup(),group);
			super.setGroup(group);
			return this;
		}
		
		/**
		 * 设置 batch
		 * @param batch batch
		 * @return 当前对象
		*/
		public AutoTask setBatch(AutoBatch batch) {
			super.change(BATCH,super.getBatch(),batch);
			super.setBatch(batch);
			return this;
		}
		
		/**
		 * 设置 action
		 * @param action action
		 * @return 当前对象
		*/
		public AutoTask setAction(AutoAction action) {
			super.change(ACTION,super.getAction(),action);
			super.setAction(action);
			return this;
		}
		
		/**
		 * 设置 actionConfContent
		 * @param actionConfContent actionConfContent
		 * @return 当前对象
		*/
		public AutoTask setActionConfContent(String actionConfContent) {
			super.change(ACTION_CONF_CONTENT,super.getActionConfContent(),actionConfContent);
			super.setActionConfContent(actionConfContent);
			return this;
		}
		
		/**
		 * 设置 actionExecuteContent
		 * @param actionExecuteContent actionExecuteContent
		 * @return 当前对象
		*/
		public AutoTask setActionExecuteContent(String actionExecuteContent) {
			super.change(ACTION_EXECUTE_CONTENT,super.getActionExecuteContent(),actionExecuteContent);
			super.setActionExecuteContent(actionExecuteContent);
			return this;
		}
		
		/**
		 * 设置 actionInfo
		 * @param actionInfo actionInfo
		 * @return 当前对象
		*/
		public AutoTask setActionInfo(String actionInfo) {
			super.change(ACTION_INFO,super.getActionInfo(),actionInfo);
			super.setActionInfo(actionInfo);
			return this;
		}
		
		/**
		 * 设置 actionSupport
		 * @param actionSupport actionSupport
		 * @return 当前对象
		*/
		public AutoTask setActionSupport(String actionSupport) {
			super.change(ACTION_SUPPORT,super.getActionSupport(),actionSupport);
			super.setActionSupport(actionSupport);
			return this;
		}
		
		/**
		 * 设置 nodeList
		 * @param nodeList nodeList
		 * @return 当前对象
		*/
		public AutoTask setNodeList(List<AutoNode> nodeList) {
			super.change(NODE_LIST,super.getNodeList(),nodeList);
			super.setNodeList(nodeList);
			return this;
		}
		
		/**
		 * 设置 nodeIds
		 * @param nodeIds nodeIds
		 * @return 当前对象
		*/
		public AutoTask setNodeIds(List<String> nodeIds) {
			super.change(NODE_IDS,super.getNodeIds(),nodeIds);
			super.setNodeIds(nodeIds);
			return this;
		}
	}
}