package com.dt.platform.domain.common.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.common.CodeAttr;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-25 09:57:38
 * @sign 59CA230998EC5706750C67D1FD175A37
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CodeAttrMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 编码名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,NAME, java.lang.String.class, "编码名称", "编码名称", java.lang.String.class, null);
	
	/**
	 * 编码类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 编码类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,TYPE, java.lang.String.class, "编码类型", "编码类型", java.lang.String.class, null);
	
	/**
	 * 占位符 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 占位符 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,CODE, java.lang.String.class, "占位符", "占位符", java.lang.String.class, null);
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 排序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,SORT, java.lang.Integer.class, "排序", "排序", java.lang.Integer.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.common.CodeAttr,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.common.CodeAttr.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , NAME , TYPE , CODE , SORT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.common.CodeAttr {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CodeAttr setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编码名称
		 * @param name 编码名称
		 * @return 当前对象
		*/
		public CodeAttr setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 编码类型
		 * @param type 编码类型
		 * @return 当前对象
		*/
		public CodeAttr setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 占位符
		 * @param code 占位符
		 * @return 当前对象
		*/
		public CodeAttr setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 排序
		 * @param sort 排序
		 * @return 当前对象
		*/
		public CodeAttr setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public CodeAttr setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CodeAttr setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CodeAttr setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CodeAttr setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CodeAttr setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CodeAttr setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CodeAttr setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CodeAttr setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CodeAttr setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public CodeAttr clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public CodeAttr duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSort(this.getSort());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.clearModifies();
			return inst;
		}

	}
}