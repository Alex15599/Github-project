package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.CmdbObjAttributeVO;
import java.util.List;
import com.dt.platform.domain.ops.CmdbObjAttribute;
import java.util.Date;
import com.dt.platform.domain.ops.CmdbModel;
import com.dt.platform.domain.ops.CmdbAttributeC;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-23 22:49:17
 * @sign D1284E3C0BFA97F34360F93384B7B8E3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CmdbObjAttributeVOMeta extends CmdbObjAttributeMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 模型对象 , 类型: java.lang.String
	*/
	public static final String MODEL_ID="modelId";
	
	/**
	 * 模型对象 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> MODEL_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,MODEL_ID, java.lang.String.class, "模型对象", "模型对象", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 属性名称 , 类型: java.lang.String
	*/
	public static final String ATTRIBUTE_NAME="attributeName";
	
	/**
	 * 属性名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> ATTRIBUTE_NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,ATTRIBUTE_NAME, java.lang.String.class, "属性名称", "属性名称", java.lang.String.class, null);
	
	/**
	 * 属性类型 , 类型: java.lang.String
	*/
	public static final String ATTRIBUTE_TYPE="attributeType";
	
	/**
	 * 属性类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> ATTRIBUTE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,ATTRIBUTE_TYPE, java.lang.String.class, "属性类型", "属性类型", java.lang.String.class, null);
	
	/**
	 * 字段来源 , 类型: java.lang.String
	*/
	public static final String ATTRIBUTE_COL_SOURCE="attributeColSource";
	
	/**
	 * 字段来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> ATTRIBUTE_COL_SOURCE_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,ATTRIBUTE_COL_SOURCE, java.lang.String.class, "字段来源", "字段来源", java.lang.String.class, null);
	
	/**
	 * 字段填充 , 类型: java.lang.String
	*/
	public static final String ATTRIBUTE_COL_FILL="attributeColFill";
	
	/**
	 * 字段填充 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> ATTRIBUTE_COL_FILL_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,ATTRIBUTE_COL_FILL, java.lang.String.class, "字段填充", "字段填充", java.lang.String.class, null);
	
	/**
	 * 显示字段 , 类型: java.lang.String
	*/
	public static final String ATTRIBUTE_COL_SHOW="attributeColShow";
	
	/**
	 * 显示字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> ATTRIBUTE_COL_SHOW_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,ATTRIBUTE_COL_SHOW, java.lang.String.class, "显示字段", "显示字段", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * cmdbModel , 类型: com.dt.platform.domain.ops.CmdbModel
	*/
	public static final String CMDB_MODEL="cmdbModel";
	
	/**
	 * cmdbModel , 类型: com.dt.platform.domain.ops.CmdbModel
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,com.dt.platform.domain.ops.CmdbModel> CMDB_MODEL_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,CMDB_MODEL, com.dt.platform.domain.ops.CmdbModel.class, "cmdbModel", "cmdbModel", com.dt.platform.domain.ops.CmdbModel.class, null);
	
	/**
	 * cmdbAttributeC , 类型: com.dt.platform.domain.ops.CmdbAttributeC
	*/
	public static final String CMDB_ATTRIBUTE_C="cmdbAttributeC";
	
	/**
	 * cmdbAttributeC , 类型: com.dt.platform.domain.ops.CmdbAttributeC
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.CmdbObjAttributeVO,com.dt.platform.domain.ops.CmdbAttributeC> CMDB_ATTRIBUTE_C_PROP = new BeanProperty(com.dt.platform.domain.ops.CmdbObjAttributeVO.class ,CMDB_ATTRIBUTE_C, com.dt.platform.domain.ops.CmdbAttributeC.class, "cmdbAttributeC", "cmdbAttributeC", com.dt.platform.domain.ops.CmdbAttributeC.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , MODEL_ID , STATUS , ATTRIBUTE_NAME , ATTRIBUTE_TYPE , ATTRIBUTE_COL_SOURCE , ATTRIBUTE_COL_FILL , ATTRIBUTE_COL_SHOW , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CMDB_MODEL , CMDB_ATTRIBUTE_C };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.CmdbObjAttributeVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public CmdbObjAttributeVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public CmdbObjAttributeVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public CmdbObjAttributeVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public CmdbObjAttributeVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public CmdbObjAttributeVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public CmdbObjAttributeVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public CmdbObjAttributeVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public CmdbObjAttributeVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public CmdbObjAttributeVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CmdbObjAttribute setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 模型对象
		 * @param modelId 模型对象
		 * @return 当前对象
		*/
		public CmdbObjAttribute setModelId(String modelId) {
			super.change(MODEL_ID,super.getModelId(),modelId);
			super.setModelId(modelId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public CmdbObjAttribute setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 属性名称
		 * @param attributeName 属性名称
		 * @return 当前对象
		*/
		public CmdbObjAttribute setAttributeName(String attributeName) {
			super.change(ATTRIBUTE_NAME,super.getAttributeName(),attributeName);
			super.setAttributeName(attributeName);
			return this;
		}
		
		/**
		 * 设置 属性类型
		 * @param attributeType 属性类型
		 * @return 当前对象
		*/
		public CmdbObjAttribute setAttributeType(String attributeType) {
			super.change(ATTRIBUTE_TYPE,super.getAttributeType(),attributeType);
			super.setAttributeType(attributeType);
			return this;
		}
		
		/**
		 * 设置 字段来源
		 * @param attributeColSource 字段来源
		 * @return 当前对象
		*/
		public CmdbObjAttribute setAttributeColSource(String attributeColSource) {
			super.change(ATTRIBUTE_COL_SOURCE,super.getAttributeColSource(),attributeColSource);
			super.setAttributeColSource(attributeColSource);
			return this;
		}
		
		/**
		 * 设置 字段填充
		 * @param attributeColFill 字段填充
		 * @return 当前对象
		*/
		public CmdbObjAttribute setAttributeColFill(String attributeColFill) {
			super.change(ATTRIBUTE_COL_FILL,super.getAttributeColFill(),attributeColFill);
			super.setAttributeColFill(attributeColFill);
			return this;
		}
		
		/**
		 * 设置 显示字段
		 * @param attributeColShow 显示字段
		 * @return 当前对象
		*/
		public CmdbObjAttribute setAttributeColShow(String attributeColShow) {
			super.change(ATTRIBUTE_COL_SHOW,super.getAttributeColShow(),attributeColShow);
			super.setAttributeColShow(attributeColShow);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public CmdbObjAttribute setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CmdbObjAttribute setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CmdbObjAttribute setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CmdbObjAttribute setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CmdbObjAttribute setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CmdbObjAttribute setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CmdbObjAttribute setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CmdbObjAttribute setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CmdbObjAttribute setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CmdbObjAttribute setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public CmdbObjAttribute setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 cmdbModel
		 * @param cmdbModel cmdbModel
		 * @return 当前对象
		*/
		public CmdbObjAttribute setCmdbModel(CmdbModel cmdbModel) {
			super.change(CMDB_MODEL,super.getCmdbModel(),cmdbModel);
			super.setCmdbModel(cmdbModel);
			return this;
		}
		
		/**
		 * 设置 cmdbAttributeC
		 * @param cmdbAttributeC cmdbAttributeC
		 * @return 当前对象
		*/
		public CmdbObjAttribute setCmdbAttributeC(CmdbAttributeC cmdbAttributeC) {
			super.change(CMDB_ATTRIBUTE_C,super.getCmdbAttributeC(),cmdbAttributeC);
			super.setCmdbAttributeC(cmdbAttributeC);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CmdbObjAttributeVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CmdbObjAttributeVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setAttributeColShow(this.getAttributeColShow());
			inst.setNotes(this.getNotes());
			inst.setModelId(this.getModelId());
			inst.setAttributeColSource(this.getAttributeColSource());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSort(this.getSort());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAttributeType(this.getAttributeType());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setAttributeName(this.getAttributeName());
			inst.setId(this.getId());
			inst.setAttributeColFill(this.getAttributeColFill());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setCmdbAttributeC(this.getCmdbAttributeC());
				inst.setCmdbModel(this.getCmdbModel());
				inst.setSearchField(this.getSearchField());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setPageSize(this.getPageSize());
				inst.setIds(this.getIds());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}