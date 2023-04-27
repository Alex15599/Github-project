package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetBorrowVO;
import java.util.List;
import com.dt.platform.domain.eam.AssetBorrow;
import java.util.Date;
import com.dt.platform.domain.eam.Asset;
import com.dt.platform.domain.eam.AssetItem;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-13 09:02:44
 * @sign 0672F52F4172AB6780A36A868D31982F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetBorrowVOMeta extends AssetBorrowMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 借用状态 , 类型: java.lang.String
	*/
	public static final String BORROW_STATUS="borrowStatus";
	
	/**
	 * 借用状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> BORROW_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,BORROW_STATUS, java.lang.String.class, "借用状态", "借用状态", java.lang.String.class, null);
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,NAME, java.lang.String.class, "业务名称", "业务名称", java.lang.String.class, null);
	
	/**
	 * 借用人 , 类型: java.lang.String
	*/
	public static final String BORROWER_ID="borrowerId";
	
	/**
	 * 借用人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> BORROWER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,BORROWER_ID, java.lang.String.class, "借用人", "借用人", java.lang.String.class, null);
	
	/**
	 * 借出时间 , 类型: java.util.Date
	*/
	public static final String BORROW_TIME="borrowTime";
	
	/**
	 * 借出时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.util.Date> BORROW_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,BORROW_TIME, java.util.Date.class, "借出时间", "借出时间", java.util.Date.class, null);
	
	/**
	 * 预计归还时间 , 类型: java.util.Date
	*/
	public static final String PLAN_RETURN_DATE="planReturnDate";
	
	/**
	 * 预计归还时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.util.Date> PLAN_RETURN_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,PLAN_RETURN_DATE, java.util.Date.class, "预计归还时间", "预计归还时间", java.util.Date.class, null);
	
	/**
	 * 归还时间 , 类型: java.util.Date
	*/
	public static final String RETURN_DATE="returnDate";
	
	/**
	 * 归还时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.util.Date> RETURN_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,RETURN_DATE, java.util.Date.class, "归还时间", "归还时间", java.util.Date.class, null);
	
	/**
	 * 借出说明 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 借出说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,CONTENT, java.lang.String.class, "借出说明", "借出说明", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH="attach";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> ATTACH_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,ATTACH, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET_LIST="assetList";
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,com.dt.platform.domain.eam.Asset> ASSET_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,ASSET_LIST, java.util.List.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ASSET_IDS="assetIds";
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> ASSET_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,ASSET_IDS, java.util.List.class, "资产列表", "资产列表", java.lang.String.class, null);
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetItem
	*/
	public static final String ASSET_ITEM_LIST="assetItemList";
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,com.dt.platform.domain.eam.AssetItem> ASSET_ITEM_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,ASSET_ITEM_LIST, java.util.List.class, "资产列表", "资产列表", com.dt.platform.domain.eam.AssetItem.class, null);
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_USER_NAME="originatorUserName";
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,java.lang.String> ORIGINATOR_USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,ORIGINATOR_USER_NAME, java.lang.String.class, "申请人", "申请人", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 借用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String BORROWER="borrower";
	
	/**
	 * 借用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrowVO,org.github.foxnic.web.domain.hrm.Employee> BORROWER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrowVO.class ,BORROWER, org.github.foxnic.web.domain.hrm.Employee.class, "借用人", "借用人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , BUSINESS_CODE , PROC_ID , STATUS , BORROW_STATUS , NAME , BORROWER_ID , BORROW_TIME , PLAN_RETURN_DATE , RETURN_DATE , CONTENT , ORIGINATOR_ID , BUSINESS_DATE , ATTACH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , ASSET_LIST , ASSET_IDS , ASSET_ITEM_LIST , ORIGINATOR_USER_NAME , ORIGINATOR , BORROWER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetBorrowVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssetBorrowVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssetBorrowVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssetBorrowVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssetBorrowVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssetBorrowVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssetBorrowVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssetBorrowVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssetBorrowVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssetBorrowVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetBorrow setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public AssetBorrow setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public AssetBorrow setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public AssetBorrow setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 借用状态
		 * @param borrowStatus 借用状态
		 * @return 当前对象
		*/
		public AssetBorrow setBorrowStatus(String borrowStatus) {
			super.change(BORROW_STATUS,super.getBorrowStatus(),borrowStatus);
			super.setBorrowStatus(borrowStatus);
			return this;
		}
		
		/**
		 * 设置 业务名称
		 * @param name 业务名称
		 * @return 当前对象
		*/
		public AssetBorrow setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 借用人
		 * @param borrowerId 借用人
		 * @return 当前对象
		*/
		public AssetBorrow setBorrowerId(String borrowerId) {
			super.change(BORROWER_ID,super.getBorrowerId(),borrowerId);
			super.setBorrowerId(borrowerId);
			return this;
		}
		
		/**
		 * 设置 借出时间
		 * @param borrowTime 借出时间
		 * @return 当前对象
		*/
		public AssetBorrow setBorrowTime(Date borrowTime) {
			super.change(BORROW_TIME,super.getBorrowTime(),borrowTime);
			super.setBorrowTime(borrowTime);
			return this;
		}
		
		/**
		 * 设置 预计归还时间
		 * @param planReturnDate 预计归还时间
		 * @return 当前对象
		*/
		public AssetBorrow setPlanReturnDate(Date planReturnDate) {
			super.change(PLAN_RETURN_DATE,super.getPlanReturnDate(),planReturnDate);
			super.setPlanReturnDate(planReturnDate);
			return this;
		}
		
		/**
		 * 设置 归还时间
		 * @param returnDate 归还时间
		 * @return 当前对象
		*/
		public AssetBorrow setReturnDate(Date returnDate) {
			super.change(RETURN_DATE,super.getReturnDate(),returnDate);
			super.setReturnDate(returnDate);
			return this;
		}
		
		/**
		 * 设置 借出说明
		 * @param content 借出说明
		 * @return 当前对象
		*/
		public AssetBorrow setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public AssetBorrow setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 业务日期
		 * @param businessDate 业务日期
		 * @return 当前对象
		*/
		public AssetBorrow setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attach 附件
		 * @return 当前对象
		*/
		public AssetBorrow setAttach(String attach) {
			super.change(ATTACH,super.getAttach(),attach);
			super.setAttach(attach);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetBorrow setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetBorrow setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetBorrow setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetBorrow setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetBorrow setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetBorrow setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetBorrow setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetBorrow setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetBorrow setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public AssetBorrow setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetList 资产
		 * @return 当前对象
		*/
		public AssetBorrow setAssetList(List<Asset> assetList) {
			super.change(ASSET_LIST,super.getAssetList(),assetList);
			super.setAssetList(assetList);
			return this;
		}
		
		/**
		 * 设置 资产列表
		 * @param assetIds 资产列表
		 * @return 当前对象
		*/
		public AssetBorrow setAssetIds(List<String> assetIds) {
			super.change(ASSET_IDS,super.getAssetIds(),assetIds);
			super.setAssetIds(assetIds);
			return this;
		}
		
		/**
		 * 设置 资产列表
		 * @param assetItemList 资产列表
		 * @return 当前对象
		*/
		public AssetBorrow setAssetItemList(List<AssetItem> assetItemList) {
			super.change(ASSET_ITEM_LIST,super.getAssetItemList(),assetItemList);
			super.setAssetItemList(assetItemList);
			return this;
		}
		
		/**
		 * 设置 申请人
		 * @param originatorUserName 申请人
		 * @return 当前对象
		*/
		public AssetBorrow setOriginatorUserName(String originatorUserName) {
			super.change(ORIGINATOR_USER_NAME,super.getOriginatorUserName(),originatorUserName);
			super.setOriginatorUserName(originatorUserName);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public AssetBorrow setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 借用人
		 * @param borrower 借用人
		 * @return 当前对象
		*/
		public AssetBorrow setBorrower(Employee borrower) {
			super.change(BORROWER,super.getBorrower(),borrower);
			super.setBorrower(borrower);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetBorrowVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetBorrowVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setBorrowerId(this.getBorrowerId());
			inst.setPlanReturnDate(this.getPlanReturnDate());
			inst.setProcId(this.getProcId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setContent(this.getContent());
			inst.setBusinessDate(this.getBusinessDate());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setReturnDate(this.getReturnDate());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setBorrowStatus(this.getBorrowStatus());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setBorrowTime(this.getBorrowTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setAttach(this.getAttach());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setBorrower(this.getBorrower());
				inst.setPageSize(this.getPageSize());
				inst.setAssetIds(this.getAssetIds());
				inst.setOriginator(this.getOriginator());
				inst.setAssetList(this.getAssetList());
				inst.setOriginatorUserName(this.getOriginatorUserName());
				inst.setAssetItemList(this.getAssetItemList());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setIds(this.getIds());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}