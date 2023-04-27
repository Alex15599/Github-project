package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.PersonnelDivisionVO;
import java.util.List;
import com.dt.platform.domain.ops.PersonnelDivision;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-11 20:39:58
 * @sign 3BA4182588DF8420B1233C8731F25291
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class PersonnelDivisionVOMeta extends PersonnelDivisionMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final String OWNER="owner";
	
	/**
	 * 所属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> OWNER_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,OWNER, java.lang.String.class, "所属", "所属", java.lang.String.class, null);
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final String USER_ID="userId";
	
	/**
	 * 用户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> USER_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,USER_ID, java.lang.String.class, "用户", "用户", java.lang.String.class, null);
	
	/**
	 * 岗位 , 类型: java.lang.String
	*/
	public static final String POS="pos";
	
	/**
	 * 岗位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> POS_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,POS, java.lang.String.class, "岗位", "岗位", java.lang.String.class, null);
	
	/**
	 * 负责内容 , 类型: java.lang.String
	*/
	public static final String RESPONSIBLE_CONTENT="responsibleContent";
	
	/**
	 * 负责内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> RESPONSIBLE_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,RESPONSIBLE_CONTENT, java.lang.String.class, "负责内容", "负责内容", java.lang.String.class, null);
	
	/**
	 * 工作内容 , 类型: java.lang.String
	*/
	public static final String JOB_CONTENT="jobContent";
	
	/**
	 * 工作内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> JOB_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,JOB_CONTENT, java.lang.String.class, "工作内容", "工作内容", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * ownerData , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String OWNER_DATA="ownerData";
	
	/**
	 * ownerData , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,org.github.foxnic.web.domain.system.DictItem> OWNER_DATA_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,OWNER_DATA, org.github.foxnic.web.domain.system.DictItem.class, "ownerData", "ownerData", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USER="user";
	
	/**
	 * user , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.PersonnelDivisionVO,org.github.foxnic.web.domain.hrm.Employee> USER_PROP = new BeanProperty(com.dt.platform.domain.ops.PersonnelDivisionVO.class ,USER, org.github.foxnic.web.domain.hrm.Employee.class, "user", "user", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , STATUS , OWNER , USER_ID , POS , RESPONSIBLE_CONTENT , JOB_CONTENT , NOTES , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , OWNER_DATA , USER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.PersonnelDivisionVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public PersonnelDivisionVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public PersonnelDivisionVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public PersonnelDivisionVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public PersonnelDivisionVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public PersonnelDivisionVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public PersonnelDivisionVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public PersonnelDivisionVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public PersonnelDivisionVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public PersonnelDivisionVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public PersonnelDivisionVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public PersonnelDivisionVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public PersonnelDivisionVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public PersonnelDivision setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public PersonnelDivision setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 所属
		 * @param owner 所属
		 * @return 当前对象
		*/
		public PersonnelDivision setOwner(String owner) {
			super.change(OWNER,super.getOwner(),owner);
			super.setOwner(owner);
			return this;
		}
		
		/**
		 * 设置 用户
		 * @param userId 用户
		 * @return 当前对象
		*/
		public PersonnelDivision setUserId(String userId) {
			super.change(USER_ID,super.getUserId(),userId);
			super.setUserId(userId);
			return this;
		}
		
		/**
		 * 设置 岗位
		 * @param pos 岗位
		 * @return 当前对象
		*/
		public PersonnelDivision setPos(String pos) {
			super.change(POS,super.getPos(),pos);
			super.setPos(pos);
			return this;
		}
		
		/**
		 * 设置 负责内容
		 * @param responsibleContent 负责内容
		 * @return 当前对象
		*/
		public PersonnelDivision setResponsibleContent(String responsibleContent) {
			super.change(RESPONSIBLE_CONTENT,super.getResponsibleContent(),responsibleContent);
			super.setResponsibleContent(responsibleContent);
			return this;
		}
		
		/**
		 * 设置 工作内容
		 * @param jobContent 工作内容
		 * @return 当前对象
		*/
		public PersonnelDivision setJobContent(String jobContent) {
			super.change(JOB_CONTENT,super.getJobContent(),jobContent);
			super.setJobContent(jobContent);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public PersonnelDivision setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public PersonnelDivision setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public PersonnelDivision setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public PersonnelDivision setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public PersonnelDivision setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public PersonnelDivision setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public PersonnelDivision setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public PersonnelDivision setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public PersonnelDivision setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public PersonnelDivision setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 ownerData
		 * @param ownerData ownerData
		 * @return 当前对象
		*/
		public PersonnelDivision setOwnerData(DictItem ownerData) {
			super.change(OWNER_DATA,super.getOwnerData(),ownerData);
			super.setOwnerData(ownerData);
			return this;
		}
		
		/**
		 * 设置 user
		 * @param user user
		 * @return 当前对象
		*/
		public PersonnelDivision setUser(Employee user) {
			super.change(USER,super.getUser(),user);
			super.setUser(user);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public PersonnelDivisionVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public PersonnelDivisionVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setOwner(this.getOwner());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setJobContent(this.getJobContent());
			inst.setSort(this.getSort());
			inst.setUserId(this.getUserId());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPos(this.getPos());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setResponsibleContent(this.getResponsibleContent());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setOwnerData(this.getOwnerData());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
				inst.setUser(this.getUser());
			}
			inst.clearModifies();
			return inst;
		}

	}
}