package com.dt.platform.domain.knowledgebase.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.knowledgebase.ContentVO;
import java.util.List;
import com.dt.platform.domain.knowledgebase.Content;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.knowledgebase.Category;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-11 18:39:15
 * @sign F08FBC51D56381143EFEB65C4A6A64BF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ContentVOMeta extends ContentMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,CATEGORY_ID, java.lang.String.class, "分类", "分类", java.lang.String.class, null);
	
	/**
	 * 标题 , 类型: java.lang.String
	*/
	public static final String TITLE="title";
	
	/**
	 * 标题 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> TITLE_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,TITLE, java.lang.String.class, "标题", "标题", java.lang.String.class, null);
	
	/**
	 * 简介 , 类型: java.lang.String
	*/
	public static final String PROFILE="profile";
	
	/**
	 * 简介 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> PROFILE_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,PROFILE, java.lang.String.class, "简介", "简介", java.lang.String.class, null);
	
	/**
	 * 关键字 , 类型: java.lang.String
	*/
	public static final String KEY_WORDS="keyWords";
	
	/**
	 * 关键字 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> KEY_WORDS_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,KEY_WORDS, java.lang.String.class, "关键字", "关键字", java.lang.String.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABEL="label";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> LABEL_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,LABEL, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 知识内容 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 知识内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,CONTENT, java.lang.String.class, "知识内容", "知识内容", java.lang.String.class, null);
	
	/**
	 * 内容类型 , 类型: java.lang.String
	*/
	public static final String CONTENT_TYPE="contentType";
	
	/**
	 * 内容类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> CONTENT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,CONTENT_TYPE, java.lang.String.class, "内容类型", "内容类型", java.lang.String.class, null);
	
	/**
	 * 阅读数 , 类型: java.math.BigDecimal
	*/
	public static final String REVIEW_COUNT="reviewCount";
	
	/**
	 * 阅读数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.math.BigDecimal> REVIEW_COUNT_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,REVIEW_COUNT, java.math.BigDecimal.class, "阅读数", "阅读数", java.math.BigDecimal.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH="attach";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> ATTACH_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,ATTACH, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 是否显示 , 类型: java.lang.Integer
	*/
	public static final String DISPLAY="display";
	
	/**
	 * 是否显示 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.Integer> DISPLAY_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,DISPLAY, java.lang.Integer.class, "是否显示", "是否显示", java.lang.Integer.class, null);
	
	/**
	 * 链接地址 , 类型: java.lang.String
	*/
	public static final String LINK_ADDRESS="linkAddress";
	
	/**
	 * 链接地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> LINK_ADDRESS_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,LINK_ADDRESS, java.lang.String.class, "链接地址", "链接地址", java.lang.String.class, null);
	
	/**
	 * 等级 , 类型: java.lang.String
	*/
	public static final String GRADE_ID="gradeId";
	
	/**
	 * 等级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> GRADE_ID_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,GRADE_ID, java.lang.String.class, "等级", "等级", java.lang.String.class, null);
	
	/**
	 * 编辑人 , 类型: java.lang.String
	*/
	public static final String EDITOR_ID="editorId";
	
	/**
	 * 编辑人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> EDITOR_ID_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,EDITOR_ID, java.lang.String.class, "编辑人", "编辑人", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 知识分类 , 类型: com.dt.platform.domain.knowledgebase.Category
	*/
	public static final String CATEGORY="category";
	
	/**
	 * 知识分类 , 类型: com.dt.platform.domain.knowledgebase.Category
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,com.dt.platform.domain.knowledgebase.Category> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,CATEGORY, com.dt.platform.domain.knowledgebase.Category.class, "知识分类", "知识分类", com.dt.platform.domain.knowledgebase.Category.class, null);
	
	/**
	 * 编辑人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String EDITOR="editor";
	
	/**
	 * 编辑人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.knowledgebase.ContentVO,org.github.foxnic.web.domain.hrm.Employee> EDITOR_PROP = new BeanProperty(com.dt.platform.domain.knowledgebase.ContentVO.class ,EDITOR, org.github.foxnic.web.domain.hrm.Employee.class, "编辑人", "编辑人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , CATEGORY_ID , TITLE , PROFILE , KEY_WORDS , LABEL , CONTENT , CONTENT_TYPE , REVIEW_COUNT , ATTACH , DISPLAY , LINK_ADDRESS , GRADE_ID , EDITOR_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CATEGORY , EDITOR };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.knowledgebase.ContentVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public ContentVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public ContentVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public ContentVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public ContentVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public ContentVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public ContentVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public ContentVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public ContentVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public ContentVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public ContentVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public ContentVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public ContentVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Content setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 分类
		 * @param categoryId 分类
		 * @return 当前对象
		*/
		public Content setCategoryId(String categoryId) {
			super.change(CATEGORY_ID,super.getCategoryId(),categoryId);
			super.setCategoryId(categoryId);
			return this;
		}
		
		/**
		 * 设置 标题
		 * @param title 标题
		 * @return 当前对象
		*/
		public Content setTitle(String title) {
			super.change(TITLE,super.getTitle(),title);
			super.setTitle(title);
			return this;
		}
		
		/**
		 * 设置 简介
		 * @param profile 简介
		 * @return 当前对象
		*/
		public Content setProfile(String profile) {
			super.change(PROFILE,super.getProfile(),profile);
			super.setProfile(profile);
			return this;
		}
		
		/**
		 * 设置 关键字
		 * @param keyWords 关键字
		 * @return 当前对象
		*/
		public Content setKeyWords(String keyWords) {
			super.change(KEY_WORDS,super.getKeyWords(),keyWords);
			super.setKeyWords(keyWords);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param label 标签
		 * @return 当前对象
		*/
		public Content setLabel(String label) {
			super.change(LABEL,super.getLabel(),label);
			super.setLabel(label);
			return this;
		}
		
		/**
		 * 设置 知识内容
		 * @param content 知识内容
		 * @return 当前对象
		*/
		public Content setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 内容类型
		 * @param contentType 内容类型
		 * @return 当前对象
		*/
		public Content setContentType(String contentType) {
			super.change(CONTENT_TYPE,super.getContentType(),contentType);
			super.setContentType(contentType);
			return this;
		}
		
		/**
		 * 设置 阅读数
		 * @param reviewCount 阅读数
		 * @return 当前对象
		*/
		public Content setReviewCount(BigDecimal reviewCount) {
			super.change(REVIEW_COUNT,super.getReviewCount(),reviewCount);
			super.setReviewCount(reviewCount);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attach 附件
		 * @return 当前对象
		*/
		public Content setAttach(String attach) {
			super.change(ATTACH,super.getAttach(),attach);
			super.setAttach(attach);
			return this;
		}
		
		/**
		 * 设置 是否显示
		 * @param display 是否显示
		 * @return 当前对象
		*/
		public Content setDisplay(Integer display) {
			super.change(DISPLAY,super.getDisplay(),display);
			super.setDisplay(display);
			return this;
		}
		
		/**
		 * 设置 链接地址
		 * @param linkAddress 链接地址
		 * @return 当前对象
		*/
		public Content setLinkAddress(String linkAddress) {
			super.change(LINK_ADDRESS,super.getLinkAddress(),linkAddress);
			super.setLinkAddress(linkAddress);
			return this;
		}
		
		/**
		 * 设置 等级
		 * @param gradeId 等级
		 * @return 当前对象
		*/
		public Content setGradeId(String gradeId) {
			super.change(GRADE_ID,super.getGradeId(),gradeId);
			super.setGradeId(gradeId);
			return this;
		}
		
		/**
		 * 设置 编辑人
		 * @param editorId 编辑人
		 * @return 当前对象
		*/
		public Content setEditorId(String editorId) {
			super.change(EDITOR_ID,super.getEditorId(),editorId);
			super.setEditorId(editorId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Content setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Content setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Content setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Content setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Content setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Content setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Content setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Content setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public Content setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Content setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 知识分类
		 * @param category 知识分类
		 * @return 当前对象
		*/
		public Content setCategory(Category category) {
			super.change(CATEGORY,super.getCategory(),category);
			super.setCategory(category);
			return this;
		}
		
		/**
		 * 设置 编辑人
		 * @param editor 编辑人
		 * @return 当前对象
		*/
		public Content setEditor(Employee editor) {
			super.change(EDITOR,super.getEditor(),editor);
			super.setEditor(editor);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public ContentVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public ContentVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setKeyWords(this.getKeyWords());
			inst.setEditorId(this.getEditorId());
			inst.setGradeId(this.getGradeId());
			inst.setNotes(this.getNotes());
			inst.setProfile(this.getProfile());
			inst.setDisplay(this.getDisplay());
			inst.setLinkAddress(this.getLinkAddress());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setLabel(this.getLabel());
			inst.setTitle(this.getTitle());
			inst.setVersion(this.getVersion());
			inst.setContent(this.getContent());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setReviewCount(this.getReviewCount());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setAttach(this.getAttach());
			inst.setContentType(this.getContentType());
			inst.setCategoryId(this.getCategoryId());
			if(all) {
				inst.setEditor(this.getEditor());
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setCategory(this.getCategory());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}