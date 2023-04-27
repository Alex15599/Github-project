package com.dt.platform.domain.ops.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.ops.DeployStandardVO;
import java.util.List;
import com.dt.platform.domain.ops.DeployStandard;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-03 09:20:27
 * @sign C094A3BE4C2171427E1A416FA9983B5A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class DeployStandardVOMeta extends DeployStandardMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE_ID="typeId";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> TYPE_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,TYPE_ID, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 用户标准 , 类型: java.lang.String
	*/
	public static final String USER_CONTENT="userContent";
	
	/**
	 * 用户标准 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> USER_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,USER_CONTENT, java.lang.String.class, "用户标准", "用户标准", java.lang.String.class, null);
	
	/**
	 * 目录标准 , 类型: java.lang.String
	*/
	public static final String DIR_CONTENT="dirContent";
	
	/**
	 * 目录标准 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> DIR_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,DIR_CONTENT, java.lang.String.class, "目录标准", "目录标准", java.lang.String.class, null);
	
	/**
	 * 部署标准 , 类型: java.lang.String
	*/
	public static final String DEPLOY_CONTENT="deployContent";
	
	/**
	 * 部署标准 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> DEPLOY_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,DEPLOY_CONTENT, java.lang.String.class, "部署标准", "部署标准", java.lang.String.class, null);
	
	/**
	 * 实例标准 , 类型: java.lang.String
	*/
	public static final String CREATE_DB_CONTENT="createDbContent";
	
	/**
	 * 实例标准 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> CREATE_DB_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,CREATE_DB_CONTENT, java.lang.String.class, "实例标准", "实例标准", java.lang.String.class, null);
	
	/**
	 * 日常维护 , 类型: java.lang.String
	*/
	public static final String MAINTENANCE_CONTENT="maintenanceContent";
	
	/**
	 * 日常维护 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> MAINTENANCE_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,MAINTENANCE_CONTENT, java.lang.String.class, "日常维护", "日常维护", java.lang.String.class, null);
	
	/**
	 * 备份脚本 , 类型: java.lang.String
	*/
	public static final String BACKUP_SCRIPT="backupScript";
	
	/**
	 * 备份脚本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> BACKUP_SCRIPT_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,BACKUP_SCRIPT, java.lang.String.class, "备份脚本", "备份脚本", java.lang.String.class, null);
	
	/**
	 * 版本 , 类型: java.lang.String
	*/
	public static final String RELEASE_VERSION="releaseVersion";
	
	/**
	 * 版本 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> RELEASE_VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,RELEASE_VERSION, java.lang.String.class, "版本", "版本", java.lang.String.class, null);
	
	/**
	 * 附件人 , 类型: java.lang.String
	*/
	public static final String ATTACH_ID="attachId";
	
	/**
	 * 附件人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> ATTACH_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,ATTACH_ID, java.lang.String.class, "附件人", "附件人", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.ops.DeployStandardVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.ops.DeployStandardVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , NAME , TYPE_ID , USER_CONTENT , DIR_CONTENT , DEPLOY_CONTENT , CREATE_DB_CONTENT , MAINTENANCE_CONTENT , BACKUP_SCRIPT , RELEASE_VERSION , ATTACH_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.ops.DeployStandardVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public DeployStandardVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public DeployStandardVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public DeployStandardVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public DeployStandardVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public DeployStandardVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public DeployStandardVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public DeployStandardVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public DeployStandardVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public DeployStandardVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public DeployStandard setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public DeployStandard setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param typeId 类型
		 * @return 当前对象
		*/
		public DeployStandard setTypeId(String typeId) {
			super.change(TYPE_ID,super.getTypeId(),typeId);
			super.setTypeId(typeId);
			return this;
		}
		
		/**
		 * 设置 用户标准
		 * @param userContent 用户标准
		 * @return 当前对象
		*/
		public DeployStandard setUserContent(String userContent) {
			super.change(USER_CONTENT,super.getUserContent(),userContent);
			super.setUserContent(userContent);
			return this;
		}
		
		/**
		 * 设置 目录标准
		 * @param dirContent 目录标准
		 * @return 当前对象
		*/
		public DeployStandard setDirContent(String dirContent) {
			super.change(DIR_CONTENT,super.getDirContent(),dirContent);
			super.setDirContent(dirContent);
			return this;
		}
		
		/**
		 * 设置 部署标准
		 * @param deployContent 部署标准
		 * @return 当前对象
		*/
		public DeployStandard setDeployContent(String deployContent) {
			super.change(DEPLOY_CONTENT,super.getDeployContent(),deployContent);
			super.setDeployContent(deployContent);
			return this;
		}
		
		/**
		 * 设置 实例标准
		 * @param createDbContent 实例标准
		 * @return 当前对象
		*/
		public DeployStandard setCreateDbContent(String createDbContent) {
			super.change(CREATE_DB_CONTENT,super.getCreateDbContent(),createDbContent);
			super.setCreateDbContent(createDbContent);
			return this;
		}
		
		/**
		 * 设置 日常维护
		 * @param maintenanceContent 日常维护
		 * @return 当前对象
		*/
		public DeployStandard setMaintenanceContent(String maintenanceContent) {
			super.change(MAINTENANCE_CONTENT,super.getMaintenanceContent(),maintenanceContent);
			super.setMaintenanceContent(maintenanceContent);
			return this;
		}
		
		/**
		 * 设置 备份脚本
		 * @param backupScript 备份脚本
		 * @return 当前对象
		*/
		public DeployStandard setBackupScript(String backupScript) {
			super.change(BACKUP_SCRIPT,super.getBackupScript(),backupScript);
			super.setBackupScript(backupScript);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param releaseVersion 版本
		 * @return 当前对象
		*/
		public DeployStandard setReleaseVersion(String releaseVersion) {
			super.change(RELEASE_VERSION,super.getReleaseVersion(),releaseVersion);
			super.setReleaseVersion(releaseVersion);
			return this;
		}
		
		/**
		 * 设置 附件人
		 * @param attachId 附件人
		 * @return 当前对象
		*/
		public DeployStandard setAttachId(String attachId) {
			super.change(ATTACH_ID,super.getAttachId(),attachId);
			super.setAttachId(attachId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public DeployStandard setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public DeployStandard setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public DeployStandard setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public DeployStandard setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public DeployStandard setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public DeployStandard setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public DeployStandard setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public DeployStandard setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public DeployStandard setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public DeployStandard setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public DeployStandardVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public DeployStandardVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setReleaseVersion(this.getReleaseVersion());
			inst.setMaintenanceContent(this.getMaintenanceContent());
			inst.setDeployContent(this.getDeployContent());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateDbContent(this.getCreateDbContent());
			inst.setBackupScript(this.getBackupScript());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setUserContent(this.getUserContent());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setTypeId(this.getTypeId());
			inst.setId(this.getId());
			inst.setDirContent(this.getDirContent());
			inst.setAttachId(this.getAttachId());
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