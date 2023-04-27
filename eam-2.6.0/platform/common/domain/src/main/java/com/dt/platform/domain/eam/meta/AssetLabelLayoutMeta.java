package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetLabelLayout;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-02 19:38:47
 * @sign 65ADFA5C7D3FCD096CAE1756F9F5DCB1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetLabelLayoutMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final String TPL_ID="tplId";
	
	/**
	 * 模版 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.String> TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,TPL_ID, java.lang.String.class, "模版", "模版", java.lang.String.class, null);
	
	/**
	 * 字段ID , 类型: java.lang.String
	*/
	public static final String COL_ID="colId";
	
	/**
	 * 字段ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.String> COL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,COL_ID, java.lang.String.class, "字段ID", "字段ID", java.lang.String.class, null);
	
	/**
	 * 字段编码 , 类型: java.lang.String
	*/
	public static final String COL_CODE="colCode";
	
	/**
	 * 字段编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.String> COL_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,COL_CODE, java.lang.String.class, "字段编码", "字段编码", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 行数 , 类型: java.lang.Integer
	*/
	public static final String ROW_NUMBER="rowNumber";
	
	/**
	 * 行数 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.Integer> ROW_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,ROW_NUMBER, java.lang.Integer.class, "行数", "行数", java.lang.Integer.class, null);
	
	/**
	 * 行高度 , 类型: java.math.BigDecimal
	*/
	public static final String ROW_HEIGHT="rowHeight";
	
	/**
	 * 行高度 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.math.BigDecimal> ROW_HEIGHT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,ROW_HEIGHT, java.math.BigDecimal.class, "行高度", "行高度", java.math.BigDecimal.class, null);
	
	/**
	 * row , span , 类型: java.lang.Integer
	*/
	public static final String ROW_SPAN="rowSpan";
	
	/**
	 * row , span , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.Integer> ROW_SPAN_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,ROW_SPAN, java.lang.Integer.class, "row", "span", java.lang.Integer.class, null);
	
	/**
	 * col , span , 类型: java.lang.Integer
	*/
	public static final String COL_SPAN="colSpan";
	
	/**
	 * col , span , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.Integer> COL_SPAN_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,COL_SPAN, java.lang.Integer.class, "col", "span", java.lang.Integer.class, null);
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final String SORT="sort";
	
	/**
	 * 顺序 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.Integer> SORT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,SORT, java.lang.Integer.class, "顺序", "顺序", java.lang.Integer.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelLayout,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelLayout.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TPL_ID , COL_ID , COL_CODE , TYPE , ROW_NUMBER , ROW_HEIGHT , ROW_SPAN , COL_SPAN , SORT , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetLabelLayout {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetLabelLayout setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 模版
		 * @param tplId 模版
		 * @return 当前对象
		*/
		public AssetLabelLayout setTplId(String tplId) {
			super.change(TPL_ID,super.getTplId(),tplId);
			super.setTplId(tplId);
			return this;
		}
		
		/**
		 * 设置 字段ID
		 * @param colId 字段ID
		 * @return 当前对象
		*/
		public AssetLabelLayout setColId(String colId) {
			super.change(COL_ID,super.getColId(),colId);
			super.setColId(colId);
			return this;
		}
		
		/**
		 * 设置 字段编码
		 * @param colCode 字段编码
		 * @return 当前对象
		*/
		public AssetLabelLayout setColCode(String colCode) {
			super.change(COL_CODE,super.getColCode(),colCode);
			super.setColCode(colCode);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public AssetLabelLayout setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 行数
		 * @param rowNumber 行数
		 * @return 当前对象
		*/
		public AssetLabelLayout setRowNumber(Integer rowNumber) {
			super.change(ROW_NUMBER,super.getRowNumber(),rowNumber);
			super.setRowNumber(rowNumber);
			return this;
		}
		
		/**
		 * 设置 行高度
		 * @param rowHeight 行高度
		 * @return 当前对象
		*/
		public AssetLabelLayout setRowHeight(BigDecimal rowHeight) {
			super.change(ROW_HEIGHT,super.getRowHeight(),rowHeight);
			super.setRowHeight(rowHeight);
			return this;
		}
		
		/**
		 * 设置 row
		 * @param rowSpan row
		 * @return 当前对象
		*/
		public AssetLabelLayout setRowSpan(Integer rowSpan) {
			super.change(ROW_SPAN,super.getRowSpan(),rowSpan);
			super.setRowSpan(rowSpan);
			return this;
		}
		
		/**
		 * 设置 col
		 * @param colSpan col
		 * @return 当前对象
		*/
		public AssetLabelLayout setColSpan(Integer colSpan) {
			super.change(COL_SPAN,super.getColSpan(),colSpan);
			super.setColSpan(colSpan);
			return this;
		}
		
		/**
		 * 设置 顺序
		 * @param sort 顺序
		 * @return 当前对象
		*/
		public AssetLabelLayout setSort(Integer sort) {
			super.change(SORT,super.getSort(),sort);
			super.setSort(sort);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetLabelLayout setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetLabelLayout setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetLabelLayout setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetLabelLayout setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetLabelLayout setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetLabelLayout setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetLabelLayout setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetLabelLayout setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetLabelLayout clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetLabelLayout duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setRowSpan(this.getRowSpan());
			inst.setColSpan(this.getColSpan());
			inst.setColCode(this.getColCode());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSort(this.getSort());
			inst.setType(this.getType());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setTplId(this.getTplId());
			inst.setColId(this.getColId());
			inst.setRowNumber(this.getRowNumber());
			inst.setRowHeight(this.getRowHeight());
			inst.clearModifies();
			return inst;
		}

	}
}