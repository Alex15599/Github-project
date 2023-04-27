package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetLabelLayoutVO;
import java.util.List;
import com.dt.platform.domain.eam.AssetLabelLayout;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-02 19:38:47
 * @sign 681AAA4A2078AE5C5EC9B33085A3336D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetLabelLayoutVOMeta extends AssetLabelLayoutMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final String TPL_ID="tplId";
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,TPL_ID, java.lang.String.class, "模版", "模版", java.lang.String.class, null);
	
	/**
	 * 字段ID , 类型: java.lang.String
	*/
	public static final String COL_ID="colId";
	
	/**
	 * 字段ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> COL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,COL_ID, java.lang.String.class, "字段ID", "字段ID", java.lang.String.class, null);
	
	/**
	 * 字段编码 , 类型: java.lang.String
	*/
	public static final String COL_CODE="colCode";
	
	/**
	 * 字段编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> COL_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,COL_CODE, java.lang.String.class, "字段编码", "字段编码", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 行数 , 类型: java.lang.Integer
	*/
	public static final String ROW_NUMBER="rowNumber";
	
	/**
	 * 行数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.Integer> ROW_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,ROW_NUMBER, java.lang.Integer.class, "行数", "行数", java.lang.Integer.class, null);
	
	/**
	 * 行高度 , 类型: java.math.BigDecimal
	*/
	public static final String ROW_HEIGHT="rowHeight";
	
	/**
	 * 行高度 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.math.BigDecimal> ROW_HEIGHT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,ROW_HEIGHT, java.math.BigDecimal.class, "行高度", "行高度", java.math.BigDecimal.class, null);
	
	/**
	 * row , span , 类型: java.lang.Integer
	*/
	public static final String ROW_SPAN="rowSpan";
	
	/**
	 * row , span , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.Integer> ROW_SPAN_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,ROW_SPAN, java.lang.Integer.class, "row", "span", java.lang.Integer.class, null);
	
	/**
	 * col , span , 类型: java.lang.Integer
	*/
	public static final String COL_SPAN="colSpan";
	
	/**
	 * col , span , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.Integer> COL_SPAN_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,COL_SPAN, java.lang.Integer.class, "col", "span", java.lang.Integer.class, null);
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,SORT, java.lang.Integer.class, "顺序", "顺序", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayoutVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayoutVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , TPL_ID , COL_ID , COL_CODE , TYPE , ROW_NUMBER , ROW_HEIGHT , ROW_SPAN , COL_SPAN , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetLabelLayoutVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssetLabelLayoutVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssetLabelLayoutVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssetLabelLayoutVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssetLabelLayoutVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssetLabelLayoutVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssetLabelLayoutVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssetLabelLayoutVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssetLabelLayoutVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssetLabelLayoutVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetLabelLayout setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 模版
		 * @param tplId 模版
		 * @return 当前对象
		*/
		public AssetLabelLayout setTplId(String tplId) {
			super.change(TPL_ID,super.getTplId(),tplId);
			super.setTplId(tplId);
			return this;
		}
		
		/**
		 * 设置 字段ID
		 * @param colId 字段ID
		 * @return 当前对象
		*/
		public AssetLabelLayout setColId(String colId) {
			super.change(COL_ID,super.getColId(),colId);
			super.setColId(colId);
			return this;
		}
		
		/**
		 * 设置 字段编码
		 * @param colCode 字段编码
		 * @return 当前对象
		*/
		public AssetLabelLayout setColCode(String colCode) {
			super.change(COL_CODE,super.getColCode(),colCode);
			super.setColCode(colCode);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public AssetLabelLayout setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 行数
		 * @param rowNumber 行数
		 * @return 当前对象
		*/
		public AssetLabelLayout setRowNumber(Integer rowNumber) {
			super.change(ROW_NUMBER,super.getRowNumber(),rowNumber);
			super.setRowNumber(rowNumber);
			return this;
		}
		
		/**
		 * 设置 行高度
		 * @param rowHeight 行高度
		 * @return 当前对象
		*/
		public AssetLabelLayout setRowHeight(BigDecimal rowHeight) {
			super.change(ROW_HEIGHT,super.getRowHeight(),rowHeight);
			super.setRowHeight(rowHeight);
			return this;
		}
		
		/**
		 * 设置 row
		 * @param rowSpan row
		 * @return 当前对象
		*/
		public AssetLabelLayout setRowSpan(Integer rowSpan) {
			super.change(ROW_SPAN,super.getRowSpan(),rowSpan);
			super.setRowSpan(rowSpan);
			return this;
		}
		
		/**
		 * 设置 col
		 * @param colSpan col
		 * @return 当前对象
		*/
		public AssetLabelLayout setColSpan(Integer colSpan) {
			super.change(COL_SPAN,super.getColSpan(),colSpan);
			super.setColSpan(colSpan);
			return this;
		}
		
		/**
		 * 设置 顺序
		 * @param sort 顺序
		 * @return 当前对象
		*/
		public AssetLabelLayout setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetLabelLayout setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetLabelLayout setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetLabelLayout setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetLabelLayout setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetLabelLayout setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetLabelLayout setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetLabelLayout setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetLabelLayout setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetLabelLayoutVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetLabelLayoutVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setRowSpan(this.getRowSpan());
			inst.setColSpan(this.getColSpan());
			inst.setColCode(this.getColCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSort(this.getSort());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setTplId(this.getTplId());
			inst.setColId(this.getColId());
			inst.setRowNumber(this.getRowNumber());
			inst.setRowHeight(this.getRowHeight());
			if(all) {
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