package com.dt.platform.domain.wms.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.wms.Storehouse;
import java.util.Date;
import com.dt.platform.domain.wms.ProductAttr;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:30:40
 * @sign EEF089A44BB4E680BE5B822E9F326CED
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class StorehouseMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * productAttr , 集合类型: LIST , 类型: com.dt.platform.domain.wms.ProductAttr
	*/
	public static final String PRODUCT_ATTR_LIST="productAttrList";
	
	/**
	 * productAttr , 集合类型: LIST , 类型: com.dt.platform.domain.wms.ProductAttr
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,com.dt.platform.domain.wms.ProductAttr> PRODUCT_ATTR_LIST_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,PRODUCT_ATTR_LIST, java.util.List.class, "productAttr", "productAttr", com.dt.platform.domain.wms.ProductAttr.class, null);
	
	/**
	 * productAttrIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String PRODUCT_ATTR_IDS="productAttrIds";
	
	/**
	 * productAttrIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Storehouse,java.lang.String> PRODUCT_ATTR_IDS_PROP = new BeanProperty(com.dt.platform.domain.wms.Storehouse.class ,PRODUCT_ATTR_IDS, java.util.List.class, "productAttrIds", "productAttrIds", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , NAME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PRODUCT_ATTR_LIST , PRODUCT_ATTR_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.wms.Storehouse {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Storehouse setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public Storehouse setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public Storehouse setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Storehouse setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Storehouse setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Storehouse setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Storehouse setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Storehouse setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Storehouse setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Storehouse setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Storehouse setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Storehouse setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Storehouse setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 productAttr
		 * @param productAttrList productAttr
		 * @return 当前对象
		*/
		public Storehouse setProductAttrList(List<ProductAttr> productAttrList) {
			super.change(PRODUCT_ATTR_LIST,super.getProductAttrList(),productAttrList);
			super.setProductAttrList(productAttrList);
			return this;
		}
		
		/**
		 * 设置 productAttrIds
		 * @param productAttrIds productAttrIds
		 * @return 当前对象
		*/
		public Storehouse setProductAttrIds(List<String> productAttrIds) {
			super.change(PRODUCT_ATTR_IDS,super.getProductAttrIds(),productAttrIds);
			super.setProductAttrIds(productAttrIds);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public Storehouse clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public Storehouse duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
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
			inst.setId(this.getId());
			if(all) {
				inst.setProductAttrIds(this.getProductAttrIds());
				inst.setProductAttrList(this.getProductAttrList());
			}
			inst.clearModifies();
			return inst;
		}

	}
}