package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.DbBackupInfoVO;
import java.util.List;
import com.dt.platform.domain.ops.DbBackupInfo;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.DbInfo;
import com.dt.platform.domain.ops.ServiceInfo;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-31 22:15:26
 * @sign 55DC0293DB9696189044F24BB2EE2CFC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DbBackupInfoVOMeta extends DbBackupInfoMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final String DATABASE_ID="databaseId";
	
	/**
	 * 数据库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> DATABASE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,DATABASE_ID, java.lang.String.class, "数据库", "数据库", java.lang.String.class, null);
	
	/**
	 * UID , 类型: java.lang.String
	*/
	public static final String UID="uid";
	
	/**
	 * UID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> UID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,UID, java.lang.String.class, "UID", "UID", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 备份状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 备份状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,STATUS, java.lang.String.class, "备份状态", "备份状态", java.lang.String.class, null);
	
	/**
	 * 备份策略 , 类型: java.lang.String
	*/
	public static final String BACKUP_STRATEGY="backupStrategy";
	
	/**
	 * 备份策略 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> BACKUP_STRATEGY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,BACKUP_STRATEGY, java.lang.String.class, "备份策略", "备份策略", java.lang.String.class, null);
	
	/**
	 * 备份类型 , 类型: java.lang.String
	*/
	public static final String BACKUP_TYPE="backupType";
	
	/**
	 * 备份类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> BACKUP_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,BACKUP_TYPE, java.lang.String.class, "备份类型", "备份类型", java.lang.String.class, null);
	
	/**
	 * 备份方式 , 类型: java.lang.String
	*/
	public static final String BACKUP_METHOD="backupMethod";
	
	/**
	 * 备份方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> BACKUP_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,BACKUP_METHOD, java.lang.String.class, "备份方式", "备份方式", java.lang.String.class, null);
	
	/**
	 * 备份保留时长 , 类型: java.lang.String
	*/
	public static final String BACKUP_DATAKEEP="backupDatakeep";
	
	/**
	 * 备份保留时长 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> BACKUP_DATAKEEP_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,BACKUP_DATAKEEP, java.lang.String.class, "备份保留时长", "备份保留时长", java.lang.String.class, null);
	
	/**
	 * 备份结果 , 类型: java.lang.String
	*/
	public static final String BACKUP_RESULT="backupResult";
	
	/**
	 * 备份结果 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> BACKUP_RESULT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,BACKUP_RESULT, java.lang.String.class, "备份结果", "备份结果", java.lang.String.class, null);
	
	/**
	 * 备份来源 , 类型: java.lang.String
	*/
	public static final String BACKUP_SOURCE="backupSource";
	
	/**
	 * 备份来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> BACKUP_SOURCE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,BACKUP_SOURCE, java.lang.String.class, "备份来源", "备份来源", java.lang.String.class, null);
	
	/**
	 * 备份大小 , 类型: java.math.BigDecimal
	*/
	public static final String BACKUP_SIZE="backupSize";
	
	/**
	 * 备份大小 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.math.BigDecimal> BACKUP_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,BACKUP_SIZE, java.math.BigDecimal.class, "备份大小", "备份大小", java.math.BigDecimal.class, null);
	
	/**
	 * 上次备份 , 类型: java.util.Date
	*/
	public static final String BACKUP_TIME="backupTime";
	
	/**
	 * 上次备份 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.util.Date> BACKUP_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,BACKUP_TIME, java.util.Date.class, "上次备份", "上次备份", java.util.Date.class, null);
	
	/**
	 * 结果内容 , 类型: java.lang.String
	*/
	public static final String BACKUP_RESULT_CT="backupResultCt";
	
	/**
	 * 结果内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> BACKUP_RESULT_CT_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,BACKUP_RESULT_CT, java.lang.String.class, "结果内容", "结果内容", java.lang.String.class, null);
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final String STORAGE="storage";
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> STORAGE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,STORAGE, java.lang.String.class, "存放位置", "存放位置", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * host , 类型: com.dt.platform.domain.ops.Host
	*/
	public static final String HOST="host";
	
	/**
	 * host , 类型: com.dt.platform.domain.ops.Host
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,com.dt.platform.domain.ops.Host> HOST_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,HOST, com.dt.platform.domain.ops.Host.class, "host", "host", com.dt.platform.domain.ops.Host.class, null);
	
	/**
	 * db , 类型: com.dt.platform.domain.ops.DbInfo
	*/
	public static final String DB="db";
	
	/**
	 * db , 类型: com.dt.platform.domain.ops.DbInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,com.dt.platform.domain.ops.DbInfo> DB_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,DB, com.dt.platform.domain.ops.DbInfo.class, "db", "db", com.dt.platform.domain.ops.DbInfo.class, null);
	
	/**
	 * dbType , 类型: com.dt.platform.domain.ops.ServiceInfo
	*/
	public static final String DB_TYPE="dbType";
	
	/**
	 * dbType , 类型: com.dt.platform.domain.ops.ServiceInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbBackupInfoVO,com.dt.platform.domain.ops.ServiceInfo> DB_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbBackupInfoVO.class ,DB_TYPE, com.dt.platform.domain.ops.ServiceInfo.class, "dbType", "dbType", com.dt.platform.domain.ops.ServiceInfo.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , IDS , ID , DATABASE_ID , UID , NAME , STATUS , BACKUP_STRATEGY , BACKUP_TYPE , BACKUP_METHOD , BACKUP_DATAKEEP , BACKUP_RESULT , BACKUP_SOURCE , BACKUP_SIZE , BACKUP_TIME , BACKUP_RESULT_CT , STORAGE , NOTES , SELECTED_CODE , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , HOST , DB , DB_TYPE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.DbBackupInfoVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public DbBackupInfoVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public DbBackupInfoVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public DbBackupInfoVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public DbBackupInfoVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public DbBackupInfoVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public DbBackupInfoVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public DbBackupInfoVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public DbBackupInfoVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public DbBackupInfoVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public DbBackupInfoVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public DbBackupInfoVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DbBackupInfo setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param databaseId 数据库
		 * @return 当前对象
		*/
		public DbBackupInfo setDatabaseId(String databaseId) {
			super.change(DATABASE_ID,super.getDatabaseId(),databaseId);
			super.setDatabaseId(databaseId);
			return this;
		}
		
		/**
		 * 设置 UID
		 * @param uid UID
		 * @return 当前对象
		*/
		public DbBackupInfo setUid(String uid) {
			super.change(UID,super.getUid(),uid);
			super.setUid(uid);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public DbBackupInfo setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 备份状态
		 * @param status 备份状态
		 * @return 当前对象
		*/
		public DbBackupInfo setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 备份策略
		 * @param backupStrategy 备份策略
		 * @return 当前对象
		*/
		public DbBackupInfo setBackupStrategy(String backupStrategy) {
			super.change(BACKUP_STRATEGY,super.getBackupStrategy(),backupStrategy);
			super.setBackupStrategy(backupStrategy);
			return this;
		}
		
		/**
		 * 设置 备份类型
		 * @param backupType 备份类型
		 * @return 当前对象
		*/
		public DbBackupInfo setBackupType(String backupType) {
			super.change(BACKUP_TYPE,super.getBackupType(),backupType);
			super.setBackupType(backupType);
			return this;
		}
		
		/**
		 * 设置 备份方式
		 * @param backupMethod 备份方式
		 * @return 当前对象
		*/
		public DbBackupInfo setBackupMethod(String backupMethod) {
			super.change(BACKUP_METHOD,super.getBackupMethod(),backupMethod);
			super.setBackupMethod(backupMethod);
			return this;
		}
		
		/**
		 * 设置 备份保留时长
		 * @param backupDatakeep 备份保留时长
		 * @return 当前对象
		*/
		public DbBackupInfo setBackupDatakeep(String backupDatakeep) {
			super.change(BACKUP_DATAKEEP,super.getBackupDatakeep(),backupDatakeep);
			super.setBackupDatakeep(backupDatakeep);
			return this;
		}
		
		/**
		 * 设置 备份结果
		 * @param backupResult 备份结果
		 * @return 当前对象
		*/
		public DbBackupInfo setBackupResult(String backupResult) {
			super.change(BACKUP_RESULT,super.getBackupResult(),backupResult);
			super.setBackupResult(backupResult);
			return this;
		}
		
		/**
		 * 设置 备份来源
		 * @param backupSource 备份来源
		 * @return 当前对象
		*/
		public DbBackupInfo setBackupSource(String backupSource) {
			super.change(BACKUP_SOURCE,super.getBackupSource(),backupSource);
			super.setBackupSource(backupSource);
			return this;
		}
		
		/**
		 * 设置 备份大小
		 * @param backupSize 备份大小
		 * @return 当前对象
		*/
		public DbBackupInfo setBackupSize(BigDecimal backupSize) {
			super.change(BACKUP_SIZE,super.getBackupSize(),backupSize);
			super.setBackupSize(backupSize);
			return this;
		}
		
		/**
		 * 设置 上次备份
		 * @param backupTime 上次备份
		 * @return 当前对象
		*/
		public DbBackupInfo setBackupTime(Date backupTime) {
			super.change(BACKUP_TIME,super.getBackupTime(),backupTime);
			super.setBackupTime(backupTime);
			return this;
		}
		
		/**
		 * 设置 结果内容
		 * @param backupResultCt 结果内容
		 * @return 当前对象
		*/
		public DbBackupInfo setBackupResultCt(String backupResultCt) {
			super.change(BACKUP_RESULT_CT,super.getBackupResultCt(),backupResultCt);
			super.setBackupResultCt(backupResultCt);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param storage 存放位置
		 * @return 当前对象
		*/
		public DbBackupInfo setStorage(String storage) {
			super.change(STORAGE,super.getStorage(),storage);
			super.setStorage(storage);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public DbBackupInfo setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public DbBackupInfo setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DbBackupInfo setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DbBackupInfo setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DbBackupInfo setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DbBackupInfo setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DbBackupInfo setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DbBackupInfo setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DbBackupInfo setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DbBackupInfo setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 host
		 * @param host host
		 * @return 当前对象
		*/
		public DbBackupInfo setHost(Host host) {
			super.change(HOST,super.getHost(),host);
			super.setHost(host);
			return this;
		}
		
		/**
		 * 设置 db
		 * @param db db
		 * @return 当前对象
		*/
		public DbBackupInfo setDb(DbInfo db) {
			super.change(DB,super.getDb(),db);
			super.setDb(db);
			return this;
		}
		
		/**
		 * 设置 dbType
		 * @param dbType dbType
		 * @return 当前对象
		*/
		public DbBackupInfo setDbType(ServiceInfo dbType) {
			super.change(DB_TYPE,super.getDbType(),dbType);
			super.setDbType(dbType);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public DbBackupInfoVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public DbBackupInfoVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setStorage(this.getStorage());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setBackupDatakeep(this.getBackupDatakeep());
			inst.setBackupType(this.getBackupType());
			inst.setUid(this.getUid());
			inst.setBackupStrategy(this.getBackupStrategy());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setId(this.getId());
			inst.setDatabaseId(this.getDatabaseId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setBackupSize(this.getBackupSize());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setBackupMethod(this.getBackupMethod());
			inst.setBackupTime(this.getBackupTime());
			inst.setBackupResultCt(this.getBackupResultCt());
			inst.setStatus(this.getStatus());
			inst.setBackupResult(this.getBackupResult());
			inst.setBackupSource(this.getBackupSource());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setDbType(this.getDbType());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setHost(this.getHost());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setSearchValue(this.getSearchValue());
				inst.setDb(this.getDb());
			}
			inst.clearModifies();
			return inst;
		}

	}
}