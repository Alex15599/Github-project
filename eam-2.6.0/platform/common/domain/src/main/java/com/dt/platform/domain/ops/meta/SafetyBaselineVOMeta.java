package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.SafetyBaselineVO;
import java.util.List;
import com.dt.platform.domain.ops.SafetyBaseline;
import java.util.Date;
import com.dt.platform.domain.ops.SoftwareBaseType;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-16 08:37:37
 * @sign 925396EDE72B26C06FDCAD06B684B16E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SafetyBaselineVOMeta extends SafetyBaselineMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String BASE_TYPE_ID="baseTypeId";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> BASE_TYPE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,BASE_TYPE_ID, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.String
	*/
	public static final String BASE_VERSION="baseVersion";
	
	/**
	 * 版本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> BASE_VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,BASE_VERSION, java.lang.String.class, "版本", "版本", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 使用场景 , 类型: java.lang.String
	*/
	public static final String USAGE_SCENARIOS="usageScenarios";
	
	/**
	 * 使用场景 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> USAGE_SCENARIOS_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,USAGE_SCENARIOS, java.lang.String.class, "使用场景", "使用场景", java.lang.String.class, null);
	
	/**
	 * 基线文件 , 类型: java.lang.String
	*/
	public static final String FILE_ID="fileId";
	
	/**
	 * 基线文件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,FILE_ID, java.lang.String.class, "基线文件", "基线文件", java.lang.String.class, null);
	
	/**
	 * 检查文件 , 类型: java.lang.String
	*/
	public static final String CHECK_FILE_ID="checkFileId";
	
	/**
	 * 检查文件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> CHECK_FILE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,CHECK_FILE_ID, java.lang.String.class, "检查文件", "检查文件", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * baseType , 集合类型: LIST , 类型: com.dt.platform.domain.ops.SoftwareBaseType
	*/
	public static final String BASE_TYPE="baseType";
	
	/**
	 * baseType , 集合类型: LIST , 类型: com.dt.platform.domain.ops.SoftwareBaseType
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.SafetyBaselineVO,com.dt.platform.domain.ops.SoftwareBaseType> BASE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.SafetyBaselineVO.class ,BASE_TYPE, java.util.List.class, "baseType", "baseType", com.dt.platform.domain.ops.SoftwareBaseType.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , BASE_TYPE_ID , NAME , BASE_VERSION , STATUS , USAGE_SCENARIOS , FILE_ID , CHECK_FILE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , BASE_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.SafetyBaselineVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public SafetyBaselineVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public SafetyBaselineVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public SafetyBaselineVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public SafetyBaselineVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public SafetyBaselineVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public SafetyBaselineVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public SafetyBaselineVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public SafetyBaselineVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public SafetyBaselineVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public SafetyBaseline setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param baseTypeId 类型
		 * @return 当前对象
		*/
		public SafetyBaseline setBaseTypeId(String baseTypeId) {
			super.change(BASE_TYPE_ID,super.getBaseTypeId(),baseTypeId);
			super.setBaseTypeId(baseTypeId);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public SafetyBaseline setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param baseVersion 版本
		 * @return 当前对象
		*/
		public SafetyBaseline setBaseVersion(String baseVersion) {
			super.change(BASE_VERSION,super.getBaseVersion(),baseVersion);
			super.setBaseVersion(baseVersion);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public SafetyBaseline setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 使用场景
		 * @param usageScenarios 使用场景
		 * @return 当前对象
		*/
		public SafetyBaseline setUsageScenarios(String usageScenarios) {
			super.change(USAGE_SCENARIOS,super.getUsageScenarios(),usageScenarios);
			super.setUsageScenarios(usageScenarios);
			return this;
		}
		
		/**
		 * 设置 基线文件
		 * @param fileId 基线文件
		 * @return 当前对象
		*/
		public SafetyBaseline setFileId(String fileId) {
			super.change(FILE_ID,super.getFileId(),fileId);
			super.setFileId(fileId);
			return this;
		}
		
		/**
		 * 设置 检查文件
		 * @param checkFileId 检查文件
		 * @return 当前对象
		*/
		public SafetyBaseline setCheckFileId(String checkFileId) {
			super.change(CHECK_FILE_ID,super.getCheckFileId(),checkFileId);
			super.setCheckFileId(checkFileId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public SafetyBaseline setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public SafetyBaseline setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public SafetyBaseline setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public SafetyBaseline setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public SafetyBaseline setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public SafetyBaseline setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public SafetyBaseline setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public SafetyBaseline setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public SafetyBaseline setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public SafetyBaseline setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 baseType
		 * @param baseType baseType
		 * @return 当前对象
		*/
		public SafetyBaseline setBaseType(List<SoftwareBaseType> baseType) {
			super.change(BASE_TYPE,super.getBaseType(),baseType);
			super.setBaseType(baseType);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public SafetyBaselineVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public SafetyBaselineVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setUsageScenarios(this.getUsageScenarios());
			inst.setNotes(this.getNotes());
			inst.setBaseVersion(this.getBaseVersion());
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
			inst.setBaseTypeId(this.getBaseTypeId());
			inst.setId(this.getId());
			inst.setCheckFileId(this.getCheckFileId());
			inst.setStatus(this.getStatus());
			inst.setFileId(this.getFileId());
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
				inst.setBaseType(this.getBaseType());
			}
			inst.clearModifies();
			return inst;
		}

	}
}