package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.CmdbModelVO;
import java.util.List;
import com.dt.platform.domain.ops.CmdbModel;
import java.util.Date;
import com.dt.platform.domain.ops.CmdbObjAttribute;
import com.dt.platform.domain.ops.CmdbModelV;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-24 13:07:17
 * @sign 7BCC7CA20332EF3F712D48A667B223C5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CmdbModelVOMeta extends CmdbModelMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final String PARENT_ID="parentId";
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> PARENT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,PARENT_ID, java.lang.String.class, "父节点", "父节点", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 节点路径 , 类型: java.lang.String
	*/
	public static final String HIERARCHY="hierarchy";
	
	/**
	 * 节点路径 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> HIERARCHY_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,HIERARCHY, java.lang.String.class, "节点路径", "节点路径", java.lang.String.class, null);
	
	/**
	 * 节点路径名称 , 类型: java.lang.String
	*/
	public static final String HIERARCHY_NAME="hierarchyName";
	
	/**
	 * 节点路径名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> HIERARCHY_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,HIERARCHY_NAME, java.lang.String.class, "节点路径名称", "节点路径名称", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 全称 , 类型: java.lang.String
	*/
	public static final String FULL_NAME="fullName";
	
	/**
	 * 全称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> FULL_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,FULL_NAME, java.lang.String.class, "全称", "全称", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 模型类型 , 类型: java.lang.String
	*/
	public static final String MODEL_TYPE="modelType";
	
	/**
	 * 模型类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> MODEL_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,MODEL_TYPE, java.lang.String.class, "模型类型", "模型类型", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 类型: java.lang.String
	*/
	public static final String SOURCE_TYPE="sourceType";
	
	/**
	 * 数据来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> SOURCE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,SOURCE_TYPE, java.lang.String.class, "数据来源", "数据来源", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE="source";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,SOURCE, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 来源方式 , 类型: java.lang.String
	*/
	public static final String DATA_SOURCE="dataSource";
	
	/**
	 * 来源方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> DATA_SOURCE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,DATA_SOURCE, java.lang.String.class, "来源方式", "来源方式", java.lang.String.class, null);
	
	/**
	 * 存储方式 , 类型: java.lang.String
	*/
	public static final String STORAGE_TYPE="storageType";
	
	/**
	 * 存储方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> STORAGE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,STORAGE_TYPE, java.lang.String.class, "存储方式", "存储方式", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * cmdbObjAttributeList , cmdbObjAttribute , 集合类型: LIST , 类型: com.dt.platform.domain.ops.CmdbObjAttribute
	*/
	public static final String CMDB_OBJ_ATTRIBUTE_LIST="cmdbObjAttributeList";
	
	/**
	 * cmdbObjAttributeList , cmdbObjAttribute , 集合类型: LIST , 类型: com.dt.platform.domain.ops.CmdbObjAttribute
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,com.dt.platform.domain.ops.CmdbObjAttribute> CMDB_OBJ_ATTRIBUTE_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,CMDB_OBJ_ATTRIBUTE_LIST, java.util.List.class, "cmdbObjAttributeList", "cmdbObjAttribute", com.dt.platform.domain.ops.CmdbObjAttribute.class, null);
	
	/**
	 * cmdbModelVList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.CmdbModelV
	*/
	public static final String CMDB_MODEL_V_LIST="cmdbModelVList";
	
	/**
	 * cmdbModelVList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.CmdbModelV
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,com.dt.platform.domain.ops.CmdbModelV> CMDB_MODEL_V_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,CMDB_MODEL_V_LIST, java.util.List.class, "cmdbModelVList", "cmdbModelVList", com.dt.platform.domain.ops.CmdbModelV.class, null);
	
	/**
	 * cmdbObjAttributeParentList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.CmdbObjAttribute
	*/
	public static final String CMDB_OBJ_ATTRIBUTE_PARENT_LIST="cmdbObjAttributeParentList";
	
	/**
	 * cmdbObjAttributeParentList , 集合类型: LIST , 类型: com.dt.platform.domain.ops.CmdbObjAttribute
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,com.dt.platform.domain.ops.CmdbObjAttribute> CMDB_OBJ_ATTRIBUTE_PARENT_LIST_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,CMDB_OBJ_ATTRIBUTE_PARENT_LIST, java.util.List.class, "cmdbObjAttributeParentList", "cmdbObjAttributeParentList", com.dt.platform.domain.ops.CmdbObjAttribute.class, null);
	
	/**
	 * cmdbModelParent , 类型: com.dt.platform.domain.ops.CmdbModel
	*/
	public static final String CMDB_MODEL_PARENT="cmdbModelParent";
	
	/**
	 * cmdbModelParent , 类型: com.dt.platform.domain.ops.CmdbModel
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbModelVO,com.dt.platform.domain.ops.CmdbModel> CMDB_MODEL_PARENT_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbModelVO.class ,CMDB_MODEL_PARENT, com.dt.platform.domain.ops.CmdbModel.class, "cmdbModelParent", "cmdbModelParent", com.dt.platform.domain.ops.CmdbModel.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , PARENT_ID , STATUS , HIERARCHY , HIERARCHY_NAME , NAME , FULL_NAME , CODE , MODEL_TYPE , SOURCE_TYPE , SOURCE , DATA_SOURCE , STORAGE_TYPE , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CMDB_OBJ_ATTRIBUTE_LIST , CMDB_MODEL_V_LIST , CMDB_OBJ_ATTRIBUTE_PARENT_LIST , CMDB_MODEL_PARENT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.CmdbModelVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public CmdbModelVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public CmdbModelVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public CmdbModelVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public CmdbModelVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public CmdbModelVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public CmdbModelVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public CmdbModelVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public CmdbModelVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public CmdbModelVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CmdbModel setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 父节点
		 * @param parentId 父节点
		 * @return 当前对象
		*/
		public CmdbModel setParentId(String parentId) {
			super.change(PARENT_ID,super.getParentId(),parentId);
			super.setParentId(parentId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public CmdbModel setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 节点路径
		 * @param hierarchy 节点路径
		 * @return 当前对象
		*/
		public CmdbModel setHierarchy(String hierarchy) {
			super.change(HIERARCHY,super.getHierarchy(),hierarchy);
			super.setHierarchy(hierarchy);
			return this;
		}
		
		/**
		 * 设置 节点路径名称
		 * @param hierarchyName 节点路径名称
		 * @return 当前对象
		*/
		public CmdbModel setHierarchyName(String hierarchyName) {
			super.change(HIERARCHY_NAME,super.getHierarchyName(),hierarchyName);
			super.setHierarchyName(hierarchyName);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public CmdbModel setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 全称
		 * @param fullName 全称
		 * @return 当前对象
		*/
		public CmdbModel setFullName(String fullName) {
			super.change(FULL_NAME,super.getFullName(),fullName);
			super.setFullName(fullName);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public CmdbModel setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 模型类型
		 * @param modelType 模型类型
		 * @return 当前对象
		*/
		public CmdbModel setModelType(String modelType) {
			super.change(MODEL_TYPE,super.getModelType(),modelType);
			super.setModelType(modelType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param sourceType 数据来源
		 * @return 当前对象
		*/
		public CmdbModel setSourceType(String sourceType) {
			super.change(SOURCE_TYPE,super.getSourceType(),sourceType);
			super.setSourceType(sourceType);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param source 来源
		 * @return 当前对象
		*/
		public CmdbModel setSource(String source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 来源方式
		 * @param dataSource 来源方式
		 * @return 当前对象
		*/
		public CmdbModel setDataSource(String dataSource) {
			super.change(DATA_SOURCE,super.getDataSource(),dataSource);
			super.setDataSource(dataSource);
			return this;
		}
		
		/**
		 * 设置 存储方式
		 * @param storageType 存储方式
		 * @return 当前对象
		*/
		public CmdbModel setStorageType(String storageType) {
			super.change(STORAGE_TYPE,super.getStorageType(),storageType);
			super.setStorageType(storageType);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public CmdbModel setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CmdbModel setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CmdbModel setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CmdbModel setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CmdbModel setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CmdbModel setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CmdbModel setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CmdbModel setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CmdbModel setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CmdbModel setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public CmdbModel setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 cmdbObjAttributeList
		 * @param cmdbObjAttributeList cmdbObjAttributeList
		 * @return 当前对象
		*/
		public CmdbModel setCmdbObjAttributeList(List<CmdbObjAttribute> cmdbObjAttributeList) {
			super.change(CMDB_OBJ_ATTRIBUTE_LIST,super.getCmdbObjAttributeList(),cmdbObjAttributeList);
			super.setCmdbObjAttributeList(cmdbObjAttributeList);
			return this;
		}
		
		/**
		 * 设置 cmdbModelVList
		 * @param cmdbModelVList cmdbModelVList
		 * @return 当前对象
		*/
		public CmdbModel setCmdbModelVList(List<CmdbModelV> cmdbModelVList) {
			super.change(CMDB_MODEL_V_LIST,super.getCmdbModelVList(),cmdbModelVList);
			super.setCmdbModelVList(cmdbModelVList);
			return this;
		}
		
		/**
		 * 设置 cmdbObjAttributeParentList
		 * @param cmdbObjAttributeParentList cmdbObjAttributeParentList
		 * @return 当前对象
		*/
		public CmdbModel setCmdbObjAttributeParentList(List<CmdbObjAttribute> cmdbObjAttributeParentList) {
			super.change(CMDB_OBJ_ATTRIBUTE_PARENT_LIST,super.getCmdbObjAttributeParentList(),cmdbObjAttributeParentList);
			super.setCmdbObjAttributeParentList(cmdbObjAttributeParentList);
			return this;
		}
		
		/**
		 * 设置 cmdbModelParent
		 * @param cmdbModelParent cmdbModelParent
		 * @return 当前对象
		*/
		public CmdbModel setCmdbModelParent(CmdbModel cmdbModelParent) {
			super.change(CMDB_MODEL_PARENT,super.getCmdbModelParent(),cmdbModelParent);
			super.setCmdbModelParent(cmdbModelParent);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CmdbModelVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CmdbModelVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setHierarchy(this.getHierarchy());
			inst.setHierarchyName(this.getHierarchyName());
			inst.setFullName(this.getFullName());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setModelType(this.getModelType());
			inst.setSource(this.getSource());
			inst.setSort(this.getSort());
			inst.setVersion(this.getVersion());
			inst.setParentId(this.getParentId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setSourceType(this.getSourceType());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setStorageType(this.getStorageType());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setDataSource(this.getDataSource());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setCmdbModelVList(this.getCmdbModelVList());
				inst.setCmdbObjAttributeList(this.getCmdbObjAttributeList());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setCmdbModelParent(this.getCmdbModelParent());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setIds(this.getIds());
				inst.setCmdbObjAttributeParentList(this.getCmdbObjAttributeParentList());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}