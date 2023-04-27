package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InventoryAssetVO;
import java.util.List;
import com.dt.platform.domain.eam.InventoryAsset;
import java.util.Date;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Inventory;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-10 19:28:54
 * @sign A694483B206991F722270A248EFD64F9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InventoryAssetVOMeta extends InventoryAssetMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 盘点 , 类型: java.lang.String
	*/
	public static final String INVENTORY_ID="inventoryId";
	
	/**
	 * 盘点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> INVENTORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,INVENTORY_ID, java.lang.String.class, "盘点", "盘点", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,ASSET_ID, java.lang.String.class, "资产", "资产", java.lang.String.class, null);
	
	/**
	 * 员工 , 类型: java.lang.String
	*/
	public static final String OPER_EMPL_ID="operEmplId";
	
	/**
	 * 员工 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> OPER_EMPL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,OPER_EMPL_ID, java.lang.String.class, "员工", "员工", java.lang.String.class, null);
	
	/**
	 * 盘盈动作 , 类型: java.lang.String
	*/
	public static final String ASSET_PLUS_ACTION_TYPE="assetPlusActionType";
	
	/**
	 * 盘盈动作 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> ASSET_PLUS_ACTION_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,ASSET_PLUS_ACTION_TYPE, java.lang.String.class, "盘盈动作", "盘盈动作", java.lang.String.class, null);
	
	/**
	 * 盘亏动作 , 类型: java.lang.String
	*/
	public static final String ASSET_LOSS_ACTION_TYPE="assetLossActionType";
	
	/**
	 * 盘亏动作 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> ASSET_LOSS_ACTION_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,ASSET_LOSS_ACTION_TYPE, java.lang.String.class, "盘亏动作", "盘亏动作", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 类型: java.lang.String
	*/
	public static final String SOURCE="source";
	
	/**
	 * 数据来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,SOURCE, java.lang.String.class, "数据来源", "数据来源", java.lang.String.class, null);
	
	/**
	 * 标记 , 类型: java.lang.String
	*/
	public static final String FLAG="flag";
	
	/**
	 * 标记 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> FLAG_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,FLAG, java.lang.String.class, "标记", "标记", java.lang.String.class, null);
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final String OPER_DATE="operDate";
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.util.Date> OPER_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,OPER_DATE, java.util.Date.class, "操作时间", "操作时间", java.util.Date.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,PICTURE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET="asset";
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,com.dt.platform.domain.eam.Asset> ASSET_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,ASSET, com.dt.platform.domain.eam.Asset.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 操作人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OPERATER="operater";
	
	/**
	 * 操作人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,org.github.foxnic.web.domain.hrm.Employee> OPERATER_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,OPERATER, org.github.foxnic.web.domain.hrm.Employee.class, "操作人员", "操作人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * inventory , 类型: com.dt.platform.domain.eam.Inventory
	*/
	public static final String INVENTORY="inventory";
	
	/**
	 * inventory , 类型: com.dt.platform.domain.eam.Inventory
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAssetVO,com.dt.platform.domain.eam.Inventory> INVENTORY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAssetVO.class ,INVENTORY, com.dt.platform.domain.eam.Inventory.class, "inventory", "inventory", com.dt.platform.domain.eam.Inventory.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , IDS , ID , INVENTORY_ID , STATUS , ASSET_ID , OPER_EMPL_ID , ASSET_PLUS_ACTION_TYPE , ASSET_LOSS_ACTION_TYPE , SOURCE , FLAG , OPER_DATE , PICTURE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ASSET , OPERATER , INVENTORY };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InventoryAssetVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public InventoryAssetVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public InventoryAssetVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public InventoryAssetVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public InventoryAssetVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public InventoryAssetVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public InventoryAssetVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public InventoryAssetVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public InventoryAssetVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public InventoryAssetVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public InventoryAssetVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public InventoryAssetVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InventoryAsset setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 盘点
		 * @param inventoryId 盘点
		 * @return 当前对象
		*/
		public InventoryAsset setInventoryId(String inventoryId) {
			super.change(INVENTORY_ID,super.getInventoryId(),inventoryId);
			super.setInventoryId(inventoryId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public InventoryAsset setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetId 资产
		 * @return 当前对象
		*/
		public InventoryAsset setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 员工
		 * @param operEmplId 员工
		 * @return 当前对象
		*/
		public InventoryAsset setOperEmplId(String operEmplId) {
			super.change(OPER_EMPL_ID,super.getOperEmplId(),operEmplId);
			super.setOperEmplId(operEmplId);
			return this;
		}
		
		/**
		 * 设置 盘盈动作
		 * @param assetPlusActionType 盘盈动作
		 * @return 当前对象
		*/
		public InventoryAsset setAssetPlusActionType(String assetPlusActionType) {
			super.change(ASSET_PLUS_ACTION_TYPE,super.getAssetPlusActionType(),assetPlusActionType);
			super.setAssetPlusActionType(assetPlusActionType);
			return this;
		}
		
		/**
		 * 设置 盘亏动作
		 * @param assetLossActionType 盘亏动作
		 * @return 当前对象
		*/
		public InventoryAsset setAssetLossActionType(String assetLossActionType) {
			super.change(ASSET_LOSS_ACTION_TYPE,super.getAssetLossActionType(),assetLossActionType);
			super.setAssetLossActionType(assetLossActionType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param source 数据来源
		 * @return 当前对象
		*/
		public InventoryAsset setSource(String source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 标记
		 * @param flag 标记
		 * @return 当前对象
		*/
		public InventoryAsset setFlag(String flag) {
			super.change(FLAG,super.getFlag(),flag);
			super.setFlag(flag);
			return this;
		}
		
		/**
		 * 设置 操作时间
		 * @param operDate 操作时间
		 * @return 当前对象
		*/
		public InventoryAsset setOperDate(Date operDate) {
			super.change(OPER_DATE,super.getOperDate(),operDate);
			super.setOperDate(operDate);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictureId 图片
		 * @return 当前对象
		*/
		public InventoryAsset setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public InventoryAsset setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InventoryAsset setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InventoryAsset setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InventoryAsset setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InventoryAsset setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InventoryAsset setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InventoryAsset setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InventoryAsset setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public InventoryAsset setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param asset 资产
		 * @return 当前对象
		*/
		public InventoryAsset setAsset(Asset asset) {
			super.change(ASSET,super.getAsset(),asset);
			super.setAsset(asset);
			return this;
		}
		
		/**
		 * 设置 操作人员
		 * @param operater 操作人员
		 * @return 当前对象
		*/
		public InventoryAsset setOperater(Employee operater) {
			super.change(OPERATER,super.getOperater(),operater);
			super.setOperater(operater);
			return this;
		}
		
		/**
		 * 设置 inventory
		 * @param inventory inventory
		 * @return 当前对象
		*/
		public InventoryAsset setInventory(Inventory inventory) {
			super.change(INVENTORY,super.getInventory(),inventory);
			super.setInventory(inventory);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public InventoryAssetVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public InventoryAssetVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setAssetLossActionType(this.getAssetLossActionType());
			inst.setOperDate(this.getOperDate());
			inst.setFlag(this.getFlag());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSource(this.getSource());
			inst.setVersion(this.getVersion());
			inst.setAssetPlusActionType(this.getAssetPlusActionType());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setPictureId(this.getPictureId());
			inst.setOperEmplId(this.getOperEmplId());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAssetId(this.getAssetId());
			inst.setInventoryId(this.getInventoryId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setOperater(this.getOperater());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setInventory(this.getInventory());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setAsset(this.getAsset());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}