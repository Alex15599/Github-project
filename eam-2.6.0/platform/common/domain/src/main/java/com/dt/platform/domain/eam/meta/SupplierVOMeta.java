package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.SupplierVO;
import java.util.List;
import com.dt.platform.domain.eam.Supplier;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-30 08:31:34
 * @sign 982845ADEE250BB07F3DD3309914A8BD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class SupplierVOMeta extends SupplierMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String SUPPLIER_NAME="supplierName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> SUPPLIER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,SUPPLIER_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 商务联系人 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CONTACTS="businessContacts";
	
	/**
	 * 商务联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> BUSINESS_CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,BUSINESS_CONTACTS, java.lang.String.class, "商务联系人", "商务联系人", java.lang.String.class, null);
	
	/**
	 * 评级 , 类型: java.lang.String
	*/
	public static final String GRADE="grade";
	
	/**
	 * 评级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> GRADE_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,GRADE, java.lang.String.class, "评级", "评级", java.lang.String.class, null);
	
	/**
	 * 商务联系方式 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CONTACTS_INFO="businessContactsInfo";
	
	/**
	 * 商务联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> BUSINESS_CONTACTS_INFO_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,BUSINESS_CONTACTS_INFO, java.lang.String.class, "商务联系方式", "商务联系方式", java.lang.String.class, null);
	
	/**
	 * 售后联系人 , 类型: java.lang.String
	*/
	public static final String AFTER_SALES_CONTACTS="afterSalesContacts";
	
	/**
	 * 售后联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> AFTER_SALES_CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,AFTER_SALES_CONTACTS, java.lang.String.class, "售后联系人", "售后联系人", java.lang.String.class, null);
	
	/**
	 * 售后联系方式 , 类型: java.lang.String
	*/
	public static final String AFTER_SALES_CONTACTS_INFO="afterSalesContactsInfo";
	
	/**
	 * 售后联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> AFTER_SALES_CONTACTS_INFO_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,AFTER_SALES_CONTACTS_INFO, java.lang.String.class, "售后联系方式", "售后联系方式", java.lang.String.class, null);
	
	/**
	 * 统一社会信用代码 , 类型: java.lang.String
	*/
	public static final String UNIT_CODE="unitCode";
	
	/**
	 * 统一社会信用代码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> UNIT_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,UNIT_CODE, java.lang.String.class, "统一社会信用代码", "统一社会信用代码", java.lang.String.class, null);
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final String ADDRESS="address";
	
	/**
	 * 地址 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> ADDRESS_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,ADDRESS, java.lang.String.class, "地址", "地址", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String SUPPLIER_NOTES="supplierNotes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> SUPPLIER_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,SUPPLIER_NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * gradeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String GRADE_DICT="gradeDict";
	
	/**
	 * gradeDict , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.SupplierVO,org.github.foxnic.web.domain.system.DictItem> GRADE_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.SupplierVO.class ,GRADE_DICT, org.github.foxnic.web.domain.system.DictItem.class, "gradeDict", "gradeDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , CODE , SUPPLIER_NAME , BUSINESS_CONTACTS , GRADE , BUSINESS_CONTACTS_INFO , AFTER_SALES_CONTACTS , AFTER_SALES_CONTACTS_INFO , UNIT_CODE , ADDRESS , SUPPLIER_NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , GRADE_DICT };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.SupplierVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public SupplierVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public SupplierVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public SupplierVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public SupplierVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public SupplierVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public SupplierVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public SupplierVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public SupplierVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public SupplierVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Supplier setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public Supplier setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param supplierName 名称
		 * @return 当前对象
		*/
		public Supplier setSupplierName(String supplierName) {
			super.change(SUPPLIER_NAME,super.getSupplierName(),supplierName);
			super.setSupplierName(supplierName);
			return this;
		}
		
		/**
		 * 设置 商务联系人
		 * @param businessContacts 商务联系人
		 * @return 当前对象
		*/
		public Supplier setBusinessContacts(String businessContacts) {
			super.change(BUSINESS_CONTACTS,super.getBusinessContacts(),businessContacts);
			super.setBusinessContacts(businessContacts);
			return this;
		}
		
		/**
		 * 设置 评级
		 * @param grade 评级
		 * @return 当前对象
		*/
		public Supplier setGrade(String grade) {
			super.change(GRADE,super.getGrade(),grade);
			super.setGrade(grade);
			return this;
		}
		
		/**
		 * 设置 商务联系方式
		 * @param businessContactsInfo 商务联系方式
		 * @return 当前对象
		*/
		public Supplier setBusinessContactsInfo(String businessContactsInfo) {
			super.change(BUSINESS_CONTACTS_INFO,super.getBusinessContactsInfo(),businessContactsInfo);
			super.setBusinessContactsInfo(businessContactsInfo);
			return this;
		}
		
		/**
		 * 设置 售后联系人
		 * @param afterSalesContacts 售后联系人
		 * @return 当前对象
		*/
		public Supplier setAfterSalesContacts(String afterSalesContacts) {
			super.change(AFTER_SALES_CONTACTS,super.getAfterSalesContacts(),afterSalesContacts);
			super.setAfterSalesContacts(afterSalesContacts);
			return this;
		}
		
		/**
		 * 设置 售后联系方式
		 * @param afterSalesContactsInfo 售后联系方式
		 * @return 当前对象
		*/
		public Supplier setAfterSalesContactsInfo(String afterSalesContactsInfo) {
			super.change(AFTER_SALES_CONTACTS_INFO,super.getAfterSalesContactsInfo(),afterSalesContactsInfo);
			super.setAfterSalesContactsInfo(afterSalesContactsInfo);
			return this;
		}
		
		/**
		 * 设置 统一社会信用代码
		 * @param unitCode 统一社会信用代码
		 * @return 当前对象
		*/
		public Supplier setUnitCode(String unitCode) {
			super.change(UNIT_CODE,super.getUnitCode(),unitCode);
			super.setUnitCode(unitCode);
			return this;
		}
		
		/**
		 * 设置 地址
		 * @param address 地址
		 * @return 当前对象
		*/
		public Supplier setAddress(String address) {
			super.change(ADDRESS,super.getAddress(),address);
			super.setAddress(address);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param supplierNotes 备注
		 * @return 当前对象
		*/
		public Supplier setSupplierNotes(String supplierNotes) {
			super.change(SUPPLIER_NOTES,super.getSupplierNotes(),supplierNotes);
			super.setSupplierNotes(supplierNotes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Supplier setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Supplier setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Supplier setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Supplier setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Supplier setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Supplier setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Supplier setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Supplier setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Supplier setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 gradeDict
		 * @param gradeDict gradeDict
		 * @return 当前对象
		*/
		public Supplier setGradeDict(DictItem gradeDict) {
			super.change(GRADE_DICT,super.getGradeDict(),gradeDict);
			super.setGradeDict(gradeDict);
			return this;
		}
	}
}