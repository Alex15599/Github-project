package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.IpAddressRangeVO;
import java.util.List;
import com.dt.platform.domain.ops.IpAddressRange;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-30 07:16:57
 * @sign D2BE44B0F1EDBEDD314372D04D8AE509
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class IpAddressRangeVOMeta extends IpAddressRangeMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 地址段 , 类型: java.lang.String
	*/
	public static final String ADDRESS_SEGMENT="addressSegment";
	
	/**
	 * 地址段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> ADDRESS_SEGMENT_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,ADDRESS_SEGMENT, java.lang.String.class, "地址段", "地址段", java.lang.String.class, null);
	
	/**
	 * 区域 , 类型: java.lang.String
	*/
	public static final String REGION_ID="regionId";
	
	/**
	 * 区域 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> REGION_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,REGION_ID, java.lang.String.class, "区域", "区域", java.lang.String.class, null);
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final String CLASS_ID="classId";
	
	/**
	 * 分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> CLASS_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,CLASS_ID, java.lang.String.class, "分类", "分类", java.lang.String.class, null);
	
	/**
	 * 环境 , 类型: java.lang.String
	*/
	public static final String PROD_ID="prodId";
	
	/**
	 * 环境 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> PROD_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,PROD_ID, java.lang.String.class, "环境", "环境", java.lang.String.class, null);
	
	/**
	 * 场景 , 类型: java.lang.String
	*/
	public static final String SCENE="scene";
	
	/**
	 * 场景 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> SCENE_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,SCENE, java.lang.String.class, "场景", "场景", java.lang.String.class, null);
	
	/**
	 * VLAN , 类型: java.lang.String
	*/
	public static final String VLAN="vlan";
	
	/**
	 * VLAN , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> VLAN_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,VLAN, java.lang.String.class, "VLAN", "VLAN", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * regionDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String REGION_DICT="regionDict";
	
	/**
	 * regionDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,org.github.foxnic.web.domain.system.DictItem> REGION_DICT_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,REGION_DICT, org.github.foxnic.web.domain.system.DictItem.class, "regionDict", "regionDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * classDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String CLASS_DICT="classDict";
	
	/**
	 * classDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,org.github.foxnic.web.domain.system.DictItem> CLASS_DICT_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,CLASS_DICT, org.github.foxnic.web.domain.system.DictItem.class, "classDict", "classDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * prodDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String PROD_DICT="prodDict";
	
	/**
	 * prodDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.IpAddressRangeVO,org.github.foxnic.web.domain.system.DictItem> PROD_DICT_PROP = new BeanProperty(com.dt.platform.domain.ops.IpAddressRangeVO.class ,PROD_DICT, org.github.foxnic.web.domain.system.DictItem.class, "prodDict", "prodDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , STATUS , ADDRESS_SEGMENT , REGION_ID , CLASS_ID , PROD_ID , SCENE , VLAN , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , REGION_DICT , CLASS_DICT , PROD_DICT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.IpAddressRangeVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public IpAddressRangeVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public IpAddressRangeVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public IpAddressRangeVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public IpAddressRangeVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public IpAddressRangeVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public IpAddressRangeVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public IpAddressRangeVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public IpAddressRangeVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public IpAddressRangeVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public IpAddressRange setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public IpAddressRange setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 地址段
		 * @param addressSegment 地址段
		 * @return 当前对象
		*/
		public IpAddressRange setAddressSegment(String addressSegment) {
			super.change(ADDRESS_SEGMENT,super.getAddressSegment(),addressSegment);
			super.setAddressSegment(addressSegment);
			return this;
		}
		
		/**
		 * 设置 区域
		 * @param regionId 区域
		 * @return 当前对象
		*/
		public IpAddressRange setRegionId(String regionId) {
			super.change(REGION_ID,super.getRegionId(),regionId);
			super.setRegionId(regionId);
			return this;
		}
		
		/**
		 * 设置 分类
		 * @param classId 分类
		 * @return 当前对象
		*/
		public IpAddressRange setClassId(String classId) {
			super.change(CLASS_ID,super.getClassId(),classId);
			super.setClassId(classId);
			return this;
		}
		
		/**
		 * 设置 环境
		 * @param prodId 环境
		 * @return 当前对象
		*/
		public IpAddressRange setProdId(String prodId) {
			super.change(PROD_ID,super.getProdId(),prodId);
			super.setProdId(prodId);
			return this;
		}
		
		/**
		 * 设置 场景
		 * @param scene 场景
		 * @return 当前对象
		*/
		public IpAddressRange setScene(String scene) {
			super.change(SCENE,super.getScene(),scene);
			super.setScene(scene);
			return this;
		}
		
		/**
		 * 设置 VLAN
		 * @param vlan VLAN
		 * @return 当前对象
		*/
		public IpAddressRange setVlan(String vlan) {
			super.change(VLAN,super.getVlan(),vlan);
			super.setVlan(vlan);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public IpAddressRange setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public IpAddressRange setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public IpAddressRange setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public IpAddressRange setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public IpAddressRange setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public IpAddressRange setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public IpAddressRange setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public IpAddressRange setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public IpAddressRange setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public IpAddressRange setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 regionDict
		 * @param regionDict regionDict
		 * @return 当前对象
		*/
		public IpAddressRange setRegionDict(DictItem regionDict) {
			super.change(REGION_DICT,super.getRegionDict(),regionDict);
			super.setRegionDict(regionDict);
			return this;
		}
		
		/**
		 * 设置 classDict
		 * @param classDict classDict
		 * @return 当前对象
		*/
		public IpAddressRange setClassDict(DictItem classDict) {
			super.change(CLASS_DICT,super.getClassDict(),classDict);
			super.setClassDict(classDict);
			return this;
		}
		
		/**
		 * 设置 prodDict
		 * @param prodDict prodDict
		 * @return 当前对象
		*/
		public IpAddressRange setProdDict(DictItem prodDict) {
			super.change(PROD_DICT,super.getProdDict(),prodDict);
			super.setProdDict(prodDict);
			return this;
		}
	}
}