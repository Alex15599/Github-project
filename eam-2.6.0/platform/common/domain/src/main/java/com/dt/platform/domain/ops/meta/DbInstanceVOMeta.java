package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.DbInstanceVO;
import java.util.List;
import com.dt.platform.domain.ops.DbInstance;
import java.util.Date;
import java.math.BigDecimal;
import com.dt.platform.domain.ops.Host;
import com.dt.platform.domain.ops.ServiceInfo;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-04 06:17:08
 * @sign 9C6A9036A02C6E253BFFAD3E81347B7E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DbInstanceVOMeta extends DbInstanceMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 主机编号 , 类型: java.lang.String
	*/
	public static final String HOST_ID="hostId";
	
	/**
	 * 主机编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> HOST_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,HOST_ID, java.lang.String.class, "主机编号", "主机编号", java.lang.String.class, null);
	
	/**
	 * 数据库编号 , 类型: java.lang.String
	*/
	public static final String DATABASE_ID="databaseId";
	
	/**
	 * 数据库编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> DATABASE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,DATABASE_ID, java.lang.String.class, "数据库编号", "数据库编号", java.lang.String.class, null);
	
	/**
	 * 实例名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 实例名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,NAME, java.lang.String.class, "实例名称", "实例名称", java.lang.String.class, null);
	
	/**
	 * 日志模式 , 类型: java.lang.String
	*/
	public static final String LOG_METHOD="logMethod";
	
	/**
	 * 日志模式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> LOG_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,LOG_METHOD, java.lang.String.class, "日志模式", "日志模式", java.lang.String.class, null);
	
	/**
	 * 备份策略 , 类型: java.lang.String
	*/
	public static final String BACKUP_STRATEGY="backupStrategy";
	
	/**
	 * 备份策略 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> BACKUP_STRATEGY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,BACKUP_STRATEGY, java.lang.String.class, "备份策略", "备份策略", java.lang.String.class, null);
	
	/**
	 * 备份类型 , 类型: java.lang.String
	*/
	public static final String BACKUP_TYPE="backupType";
	
	/**
	 * 备份类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> BACKUP_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,BACKUP_TYPE, java.lang.String.class, "备份类型", "备份类型", java.lang.String.class, null);
	
	/**
	 * 备份保留时长 , 类型: java.lang.String
	*/
	public static final String BACKUP_DATAKEEP="backupDatakeep";
	
	/**
	 * 备份保留时长 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> BACKUP_DATAKEEP_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,BACKUP_DATAKEEP, java.lang.String.class, "备份保留时长", "备份保留时长", java.lang.String.class, null);
	
	/**
	 * 备份状态 , 类型: java.lang.String
	*/
	public static final String BACKUP_STATUS="backupStatus";
	
	/**
	 * 备份状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> BACKUP_STATUS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,BACKUP_STATUS, java.lang.String.class, "备份状态", "备份状态", java.lang.String.class, null);
	
	/**
	 * 备份方式 , 类型: java.lang.String
	*/
	public static final String BACKUP_METHOD="backupMethod";
	
	/**
	 * 备份方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> BACKUP_METHOD_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,BACKUP_METHOD, java.lang.String.class, "备份方式", "备份方式", java.lang.String.class, null);
	
	/**
	 * 上次备份 , 类型: java.util.Date
	*/
	public static final String BACKUP_TIME="backupTime";
	
	/**
	 * 上次备份 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.util.Date> BACKUP_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,BACKUP_TIME, java.util.Date.class, "上次备份", "上次备份", java.util.Date.class, null);
	
	/**
	 * 备份大小 , 类型: java.math.BigDecimal
	*/
	public static final String BACKUP_SIZE="backupSize";
	
	/**
	 * 备份大小 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.math.BigDecimal> BACKUP_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,BACKUP_SIZE, java.math.BigDecimal.class, "备份大小", "备份大小", java.math.BigDecimal.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABELS="labels";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> LABELS_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,LABELS, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 所在位置 , 类型: com.dt.platform.domain.ops.Host
	*/
	public static final String HOST="host";
	
	/**
	 * 所在位置 , 类型: com.dt.platform.domain.ops.Host
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,com.dt.platform.domain.ops.Host> HOST_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,HOST, com.dt.platform.domain.ops.Host.class, "所在位置", "所在位置", com.dt.platform.domain.ops.Host.class, null);
	
	/**
	 * 数据库 , 类型: com.dt.platform.domain.ops.ServiceInfo
	*/
	public static final String DATABASE="database";
	
	/**
	 * 数据库 , 类型: com.dt.platform.domain.ops.ServiceInfo
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DbInstanceVO,com.dt.platform.domain.ops.ServiceInfo> DATABASE_PROP = new BeanProperty(com.dt.platform.domain.ops.DbInstanceVO.class ,DATABASE, com.dt.platform.domain.ops.ServiceInfo.class, "数据库", "数据库", com.dt.platform.domain.ops.ServiceInfo.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , HOST_ID , DATABASE_ID , NAME , LOG_METHOD , BACKUP_STRATEGY , BACKUP_TYPE , BACKUP_DATAKEEP , BACKUP_STATUS , BACKUP_METHOD , BACKUP_TIME , BACKUP_SIZE , LABELS , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , HOST , DATABASE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.DbInstanceVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public DbInstanceVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public DbInstanceVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public DbInstanceVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public DbInstanceVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public DbInstanceVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public DbInstanceVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public DbInstanceVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public DbInstanceVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public DbInstanceVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DbInstance setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 主机编号
		 * @param hostId 主机编号
		 * @return 当前对象
		*/
		public DbInstance setHostId(String hostId) {
			super.change(HOST_ID,super.getHostId(),hostId);
			super.setHostId(hostId);
			return this;
		}
		
		/**
		 * 设置 数据库编号
		 * @param databaseId 数据库编号
		 * @return 当前对象
		*/
		public DbInstance setDatabaseId(String databaseId) {
			super.change(DATABASE_ID,super.getDatabaseId(),databaseId);
			super.setDatabaseId(databaseId);
			return this;
		}
		
		/**
		 * 设置 实例名称
		 * @param name 实例名称
		 * @return 当前对象
		*/
		public DbInstance setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 日志模式
		 * @param logMethod 日志模式
		 * @return 当前对象
		*/
		public DbInstance setLogMethod(String logMethod) {
			super.change(LOG_METHOD,super.getLogMethod(),logMethod);
			super.setLogMethod(logMethod);
			return this;
		}
		
		/**
		 * 设置 备份策略
		 * @param backupStrategy 备份策略
		 * @return 当前对象
		*/
		public DbInstance setBackupStrategy(String backupStrategy) {
			super.change(BACKUP_STRATEGY,super.getBackupStrategy(),backupStrategy);
			super.setBackupStrategy(backupStrategy);
			return this;
		}
		
		/**
		 * 设置 备份类型
		 * @param backupType 备份类型
		 * @return 当前对象
		*/
		public DbInstance setBackupType(String backupType) {
			super.change(BACKUP_TYPE,super.getBackupType(),backupType);
			super.setBackupType(backupType);
			return this;
		}
		
		/**
		 * 设置 备份保留时长
		 * @param backupDatakeep 备份保留时长
		 * @return 当前对象
		*/
		public DbInstance setBackupDatakeep(String backupDatakeep) {
			super.change(BACKUP_DATAKEEP,super.getBackupDatakeep(),backupDatakeep);
			super.setBackupDatakeep(backupDatakeep);
			return this;
		}
		
		/**
		 * 设置 备份状态
		 * @param backupStatus 备份状态
		 * @return 当前对象
		*/
		public DbInstance setBackupStatus(String backupStatus) {
			super.change(BACKUP_STATUS,super.getBackupStatus(),backupStatus);
			super.setBackupStatus(backupStatus);
			return this;
		}
		
		/**
		 * 设置 备份方式
		 * @param backupMethod 备份方式
		 * @return 当前对象
		*/
		public DbInstance setBackupMethod(String backupMethod) {
			super.change(BACKUP_METHOD,super.getBackupMethod(),backupMethod);
			super.setBackupMethod(backupMethod);
			return this;
		}
		
		/**
		 * 设置 上次备份
		 * @param backupTime 上次备份
		 * @return 当前对象
		*/
		public DbInstance setBackupTime(Date backupTime) {
			super.change(BACKUP_TIME,super.getBackupTime(),backupTime);
			super.setBackupTime(backupTime);
			return this;
		}
		
		/**
		 * 设置 备份大小
		 * @param backupSize 备份大小
		 * @return 当前对象
		*/
		public DbInstance setBackupSize(BigDecimal backupSize) {
			super.change(BACKUP_SIZE,super.getBackupSize(),backupSize);
			super.setBackupSize(backupSize);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param labels 标签
		 * @return 当前对象
		*/
		public DbInstance setLabels(String labels) {
			super.change(LABELS,super.getLabels(),labels);
			super.setLabels(labels);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public DbInstance setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DbInstance setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DbInstance setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DbInstance setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DbInstance setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DbInstance setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DbInstance setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DbInstance setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DbInstance setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public DbInstance setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 所在位置
		 * @param host 所在位置
		 * @return 当前对象
		*/
		public DbInstance setHost(Host host) {
			super.change(HOST,super.getHost(),host);
			super.setHost(host);
			return this;
		}
		
		/**
		 * 设置 数据库
		 * @param database 数据库
		 * @return 当前对象
		*/
		public DbInstance setDatabase(ServiceInfo database) {
			super.change(DATABASE,super.getDatabase(),database);
			super.setDatabase(database);
			return this;
		}
	}
}