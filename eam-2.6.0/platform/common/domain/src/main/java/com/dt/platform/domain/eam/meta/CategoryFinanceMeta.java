package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.CategoryFinance;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-27 08:06:14
 * @sign 5F389383F67603135F5270B83765D639
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CategoryFinanceMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String CATEGORY_NAME="categoryName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.String> CATEGORY_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,CATEGORY_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 全称 , 类型: java.lang.String
	*/
	public static final String CATEGORY_FULLNAME="categoryFullname";
	
	/**
	 * 全称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.String> CATEGORY_FULLNAME_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,CATEGORY_FULLNAME, java.lang.String.class, "全称", "全称", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CATEGORY_CODE="categoryCode";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.String> CATEGORY_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,CATEGORY_CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 使用期限 , 类型: java.math.BigDecimal
	*/
	public static final String SERVICE_LIFE="serviceLife";
	
	/**
	 * 使用期限 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.math.BigDecimal> SERVICE_LIFE_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,SERVICE_LIFE, java.math.BigDecimal.class, "使用期限", "使用期限", java.math.BigDecimal.class, null);
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final String PARENT_ID="parentId";
	
	/**
	 * 父节点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.String> PARENT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,PARENT_ID, java.lang.String.class, "父节点", "父节点", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 节点路径 , 类型: java.lang.String
	*/
	public static final String HIERARCHY="hierarchy";
	
	/**
	 * 节点路径 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.String> HIERARCHY_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,HIERARCHY, java.lang.String.class, "节点路径", "节点路径", java.lang.String.class, null);
	
	/**
	 * 节点路径名称 , 类型: java.lang.String
	*/
	public static final String HIERARCHY_NAME="hierarchyName";
	
	/**
	 * 节点路径名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.String> HIERARCHY_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,HIERARCHY_NAME, java.lang.String.class, "节点路径名称", "节点路径名称", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CategoryFinance,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CategoryFinance.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , STATUS , CATEGORY_NAME , CATEGORY_FULLNAME , CATEGORY_CODE , SERVICE_LIFE , PARENT_ID , SORT , HIERARCHY , HIERARCHY_NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.CategoryFinance {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CategoryFinance setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public CategoryFinance setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param categoryName 名称
		 * @return 当前对象
		*/
		public CategoryFinance setCategoryName(String categoryName) {
			super.change(CATEGORY_NAME,super.getCategoryName(),categoryName);
			super.setCategoryName(categoryName);
			return this;
		}
		
		/**
		 * 设置 全称
		 * @param categoryFullname 全称
		 * @return 当前对象
		*/
		public CategoryFinance setCategoryFullname(String categoryFullname) {
			super.change(CATEGORY_FULLNAME,super.getCategoryFullname(),categoryFullname);
			super.setCategoryFullname(categoryFullname);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param categoryCode 编码
		 * @return 当前对象
		*/
		public CategoryFinance setCategoryCode(String categoryCode) {
			super.change(CATEGORY_CODE,super.getCategoryCode(),categoryCode);
			super.setCategoryCode(categoryCode);
			return this;
		}
		
		/**
		 * 设置 使用期限
		 * @param serviceLife 使用期限
		 * @return 当前对象
		*/
		public CategoryFinance setServiceLife(BigDecimal serviceLife) {
			super.change(SERVICE_LIFE,super.getServiceLife(),serviceLife);
			super.setServiceLife(serviceLife);
			return this;
		}
		
		/**
		 * 设置 父节点
		 * @param parentId 父节点
		 * @return 当前对象
		*/
		public CategoryFinance setParentId(String parentId) {
			super.change(PARENT_ID,super.getParentId(),parentId);
			super.setParentId(parentId);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public CategoryFinance setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 节点路径
		 * @param hierarchy 节点路径
		 * @return 当前对象
		*/
		public CategoryFinance setHierarchy(String hierarchy) {
			super.change(HIERARCHY,super.getHierarchy(),hierarchy);
			super.setHierarchy(hierarchy);
			return this;
		}
		
		/**
		 * 设置 节点路径名称
		 * @param hierarchyName 节点路径名称
		 * @return 当前对象
		*/
		public CategoryFinance setHierarchyName(String hierarchyName) {
			super.change(HIERARCHY_NAME,super.getHierarchyName(),hierarchyName);
			super.setHierarchyName(hierarchyName);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CategoryFinance setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CategoryFinance setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CategoryFinance setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CategoryFinance setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CategoryFinance setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CategoryFinance setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CategoryFinance setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CategoryFinance setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CategoryFinance setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public CategoryFinance setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CategoryFinance clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CategoryFinance duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setNotes(this.getNotes());
			inst.setHierarchy(this.getHierarchy());
			inst.setHierarchyName(this.getHierarchyName());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setCategoryCode(this.getCategoryCode());
			inst.setSort(this.getSort());
			inst.setCategoryName(this.getCategoryName());
			inst.setVersion(this.getVersion());
			inst.setParentId(this.getParentId());
			inst.setCategoryFullname(this.getCategoryFullname());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setServiceLife(this.getServiceLife());
			inst.setId(this.getId());
			inst.setStatus(this.getStatus());
			inst.clearModifies();
			return inst;
		}

	}
}