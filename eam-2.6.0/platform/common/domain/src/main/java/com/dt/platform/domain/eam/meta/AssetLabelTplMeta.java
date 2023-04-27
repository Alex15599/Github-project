package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetLabelTpl;
import java.util.Date;
import java.math.BigDecimal;
import com.dt.platform.domain.eam.AssetLabelTplItem;
import java.util.List;
import com.dt.platform.domain.eam.AssetLabelCol;
import com.dt.platform.domain.eam.AssetLabelLayout;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-18 12:30:46
 * @sign CCC6AC1FA7C53D09D210F63BCF562F07
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetLabelTplMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 类型 , 默认为1 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 默认为1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,TYPE, java.lang.String.class, "类型", "默认为1", java.lang.String.class, null);
	
	/**
	 * 是否自定义 , 类型: java.lang.String
	*/
	public static final String IS_CUSTOM="isCustom";
	
	/**
	 * 是否自定义 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> IS_CUSTOM_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IS_CUSTOM, java.lang.String.class, "是否自定义", "是否自定义", java.lang.String.class, null);
	
	/**
	 * 字段 , 类型: java.lang.String
	*/
	public static final String COL_IDS="colIds";
	
	/**
	 * 字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> COL_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,COL_IDS, java.lang.String.class, "字段", "字段", java.lang.String.class, null);
	
	/**
	 * 位置:u , d , 类型: java.lang.String
	*/
	public static final String IMAGE_POSITION="imagePosition";
	
	/**
	 * 位置:u , d , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> IMAGE_POSITION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_POSITION, java.lang.String.class, "位置:u", "d", java.lang.String.class, null);
	
	/**
	 * 图像 , 类型: java.lang.String
	*/
	public static final String IMAGE_COL_ID="imageColId";
	
	/**
	 * 图像 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> IMAGE_COL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_COL_ID, java.lang.String.class, "图像", "图像", java.lang.String.class, null);
	
	/**
	 * 图像显示 , 类型: java.lang.String
	*/
	public static final String IMAGE_SHOW="imageShow";
	
	/**
	 * 图像显示 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> IMAGE_SHOW_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_SHOW, java.lang.String.class, "图像显示", "图像显示", java.lang.String.class, null);
	
	/**
	 * 图像label显示 , 类型: java.lang.String
	*/
	public static final String IMAGE_LABEL_SHOW="imageLabelShow";
	
	/**
	 * 图像label显示 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> IMAGE_LABEL_SHOW_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_LABEL_SHOW, java.lang.String.class, "图像label显示", "图像label显示", java.lang.String.class, null);
	
	/**
	 * 图像类型txm , rwm , 类型: java.lang.String
	*/
	public static final String IMAGE_TYPE="imageType";
	
	/**
	 * 图像类型txm , rwm , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> IMAGE_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_TYPE, java.lang.String.class, "图像类型txm", "rwm", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String LABEL_FORMAT_CONTENT="labelFormatContent";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> LABEL_FORMAT_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,LABEL_FORMAT_CONTENT, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 表格marginTop(mm) , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_TABLE_MARGIN_TOP="labelTableMarginTop";
	
	/**
	 * 表格marginTop(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.math.BigDecimal> LABEL_TABLE_MARGIN_TOP_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,LABEL_TABLE_MARGIN_TOP, java.math.BigDecimal.class, "表格marginTop(mm)", "表格marginTop(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 表格marginBottom(mm) , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_TABLE_MARGIN_BOTTOM="labelTableMarginBottom";
	
	/**
	 * 表格marginBottom(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.math.BigDecimal> LABEL_TABLE_MARGIN_BOTTOM_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,LABEL_TABLE_MARGIN_BOTTOM, java.math.BigDecimal.class, "表格marginBottom(mm)", "表格marginBottom(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 表格marginLeft(mm) , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_TABLE_MARGIN_LEFT="labelTableMarginLeft";
	
	/**
	 * 表格marginLeft(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.math.BigDecimal> LABEL_TABLE_MARGIN_LEFT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,LABEL_TABLE_MARGIN_LEFT, java.math.BigDecimal.class, "表格marginLeft(mm)", "表格marginLeft(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 表格marginRight(mm) , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_TABLE_MARGIN_RIGHT="labelTableMarginRight";
	
	/**
	 * 表格marginRight(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.math.BigDecimal> LABEL_TABLE_MARGIN_RIGHT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,LABEL_TABLE_MARGIN_RIGHT, java.math.BigDecimal.class, "表格marginRight(mm)", "表格marginRight(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 表格内Key是否加粗 , 类型: java.lang.String
	*/
	public static final String KEY_BOLD="keyBold";
	
	/**
	 * 表格内Key是否加粗 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> KEY_BOLD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,KEY_BOLD, java.lang.String.class, "表格内Key是否加粗", "表格内Key是否加粗", java.lang.String.class, null);
	
	/**
	 * 表格内Value是否加粗 , 类型: java.lang.String
	*/
	public static final String VALUE_BLOD="valueBlod";
	
	/**
	 * 表格内Value是否加粗 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.lang.String> VALUE_BLOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,VALUE_BLOD, java.lang.String.class, "表格内Value是否加粗", "表格内Value是否加粗", java.lang.String.class, null);
	
	/**
	 * 图片marginTop(mm) , 类型: java.math.BigDecimal
	*/
	public static final String IMAGE_MARGIN_TOP="imageMarginTop";
	
	/**
	 * 图片marginTop(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.math.BigDecimal> IMAGE_MARGIN_TOP_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_MARGIN_TOP, java.math.BigDecimal.class, "图片marginTop(mm)", "图片marginTop(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 图片marginBottom(mm) , 类型: java.math.BigDecimal
	*/
	public static final String IMAGE_MARGIN_BOTTOM="imageMarginBottom";
	
	/**
	 * 图片marginBottom(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.math.BigDecimal> IMAGE_MARGIN_BOTTOM_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_MARGIN_BOTTOM, java.math.BigDecimal.class, "图片marginBottom(mm)", "图片marginBottom(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 图片marginLeft(mm) , 类型: java.math.BigDecimal
	*/
	public static final String IMAGE_MARGIN_LEFT="imageMarginLeft";
	
	/**
	 * 图片marginLeft(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.math.BigDecimal> IMAGE_MARGIN_LEFT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_MARGIN_LEFT, java.math.BigDecimal.class, "图片marginLeft(mm)", "图片marginLeft(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 图片marginRight(mm) , 类型: java.math.BigDecimal
	*/
	public static final String IMAGE_MARGIN_RIGHT="imageMarginRight";
	
	/**
	 * 图片marginRight(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.math.BigDecimal> IMAGE_MARGIN_RIGHT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_MARGIN_RIGHT, java.math.BigDecimal.class, "图片marginRight(mm)", "图片marginRight(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 图片宽度 , 类型: java.math.BigDecimal
	*/
	public static final String IMAGE_WIDTH="imageWidth";
	
	/**
	 * 图片宽度 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.math.BigDecimal> IMAGE_WIDTH_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_WIDTH, java.math.BigDecimal.class, "图片宽度", "图片宽度", java.math.BigDecimal.class, null);
	
	/**
	 * 图片高度 , 类型: java.math.BigDecimal
	*/
	public static final String IMAGE_HEIGHT="imageHeight";
	
	/**
	 * 图片高度 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,java.math.BigDecimal> IMAGE_HEIGHT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,IMAGE_HEIGHT, java.math.BigDecimal.class, "图片高度", "图片高度", java.math.BigDecimal.class, null);
	
	/**
	 * Item , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetLabelTplItem
	*/
	public static final String ASSET_LABEL_ITEM_LIST="assetLabelItemList";
	
	/**
	 * Item , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetLabelTplItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,com.dt.platform.domain.eam.AssetLabelTplItem> ASSET_LABEL_ITEM_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,ASSET_LABEL_ITEM_LIST, java.util.List.class, "Item", "Item", com.dt.platform.domain.eam.AssetLabelTplItem.class, null);
	
	/**
	 * Column , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetLabelCol
	*/
	public static final String ASSET_LABEL_COLUMNL_LIST="assetLabelColumnlList";
	
	/**
	 * Column , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetLabelCol
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,com.dt.platform.domain.eam.AssetLabelCol> ASSET_LABEL_COLUMNL_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,ASSET_LABEL_COLUMNL_LIST, java.util.List.class, "Column", "Column", com.dt.platform.domain.eam.AssetLabelCol.class, null);
	
	/**
	 * assetLabelLayout , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetLabelLayout
	*/
	public static final String ASSET_LABEL_LAYOUT_LIST="assetLabelLayoutList";
	
	/**
	 * assetLabelLayout , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetLabelLayout
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabelTpl,com.dt.platform.domain.eam.AssetLabelLayout> ASSET_LABEL_LAYOUT_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabelTpl.class ,ASSET_LABEL_LAYOUT_LIST, java.util.List.class, "assetLabelLayout", "assetLabelLayout", com.dt.platform.domain.eam.AssetLabelLayout.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , TYPE , IS_CUSTOM , COL_IDS , IMAGE_POSITION , IMAGE_COL_ID , IMAGE_SHOW , IMAGE_LABEL_SHOW , IMAGE_TYPE , LABEL_FORMAT_CONTENT , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , LABEL_TABLE_MARGIN_TOP , LABEL_TABLE_MARGIN_BOTTOM , LABEL_TABLE_MARGIN_LEFT , LABEL_TABLE_MARGIN_RIGHT , KEY_BOLD , VALUE_BLOD , IMAGE_MARGIN_TOP , IMAGE_MARGIN_BOTTOM , IMAGE_MARGIN_LEFT , IMAGE_MARGIN_RIGHT , IMAGE_WIDTH , IMAGE_HEIGHT , ASSET_LABEL_ITEM_LIST , ASSET_LABEL_COLUMNL_LIST , ASSET_LABEL_LAYOUT_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetLabelTpl {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetLabelTpl setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public AssetLabelTpl setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 是否自定义
		 * @param isCustom 是否自定义
		 * @return 当前对象
		*/
		public AssetLabelTpl setIsCustom(String isCustom) {
			super.change(IS_CUSTOM,super.getIsCustom(),isCustom);
			super.setIsCustom(isCustom);
			return this;
		}
		
		/**
		 * 设置 字段
		 * @param colIds 字段
		 * @return 当前对象
		*/
		public AssetLabelTpl setColIds(String colIds) {
			super.change(COL_IDS,super.getColIds(),colIds);
			super.setColIds(colIds);
			return this;
		}
		
		/**
		 * 设置 位置:u
		 * @param imagePosition 位置:u
		 * @return 当前对象
		*/
		public AssetLabelTpl setImagePosition(String imagePosition) {
			super.change(IMAGE_POSITION,super.getImagePosition(),imagePosition);
			super.setImagePosition(imagePosition);
			return this;
		}
		
		/**
		 * 设置 图像
		 * @param imageColId 图像
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageColId(String imageColId) {
			super.change(IMAGE_COL_ID,super.getImageColId(),imageColId);
			super.setImageColId(imageColId);
			return this;
		}
		
		/**
		 * 设置 图像显示
		 * @param imageShow 图像显示
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageShow(String imageShow) {
			super.change(IMAGE_SHOW,super.getImageShow(),imageShow);
			super.setImageShow(imageShow);
			return this;
		}
		
		/**
		 * 设置 图像label显示
		 * @param imageLabelShow 图像label显示
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageLabelShow(String imageLabelShow) {
			super.change(IMAGE_LABEL_SHOW,super.getImageLabelShow(),imageLabelShow);
			super.setImageLabelShow(imageLabelShow);
			return this;
		}
		
		/**
		 * 设置 图像类型txm
		 * @param imageType 图像类型txm
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageType(String imageType) {
			super.change(IMAGE_TYPE,super.getImageType(),imageType);
			super.setImageType(imageType);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param labelFormatContent 类型
		 * @return 当前对象
		*/
		public AssetLabelTpl setLabelFormatContent(String labelFormatContent) {
			super.change(LABEL_FORMAT_CONTENT,super.getLabelFormatContent(),labelFormatContent);
			super.setLabelFormatContent(labelFormatContent);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetLabelTpl setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetLabelTpl setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetLabelTpl setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetLabelTpl setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetLabelTpl setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetLabelTpl setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetLabelTpl setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetLabelTpl setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetLabelTpl setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetLabelTpl setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 表格marginTop(mm)
		 * @param labelTableMarginTop 表格marginTop(mm)
		 * @return 当前对象
		*/
		public AssetLabelTpl setLabelTableMarginTop(BigDecimal labelTableMarginTop) {
			super.change(LABEL_TABLE_MARGIN_TOP,super.getLabelTableMarginTop(),labelTableMarginTop);
			super.setLabelTableMarginTop(labelTableMarginTop);
			return this;
		}
		
		/**
		 * 设置 表格marginBottom(mm)
		 * @param labelTableMarginBottom 表格marginBottom(mm)
		 * @return 当前对象
		*/
		public AssetLabelTpl setLabelTableMarginBottom(BigDecimal labelTableMarginBottom) {
			super.change(LABEL_TABLE_MARGIN_BOTTOM,super.getLabelTableMarginBottom(),labelTableMarginBottom);
			super.setLabelTableMarginBottom(labelTableMarginBottom);
			return this;
		}
		
		/**
		 * 设置 表格marginLeft(mm)
		 * @param labelTableMarginLeft 表格marginLeft(mm)
		 * @return 当前对象
		*/
		public AssetLabelTpl setLabelTableMarginLeft(BigDecimal labelTableMarginLeft) {
			super.change(LABEL_TABLE_MARGIN_LEFT,super.getLabelTableMarginLeft(),labelTableMarginLeft);
			super.setLabelTableMarginLeft(labelTableMarginLeft);
			return this;
		}
		
		/**
		 * 设置 表格marginRight(mm)
		 * @param labelTableMarginRight 表格marginRight(mm)
		 * @return 当前对象
		*/
		public AssetLabelTpl setLabelTableMarginRight(BigDecimal labelTableMarginRight) {
			super.change(LABEL_TABLE_MARGIN_RIGHT,super.getLabelTableMarginRight(),labelTableMarginRight);
			super.setLabelTableMarginRight(labelTableMarginRight);
			return this;
		}
		
		/**
		 * 设置 表格内Key是否加粗
		 * @param keyBold 表格内Key是否加粗
		 * @return 当前对象
		*/
		public AssetLabelTpl setKeyBold(String keyBold) {
			super.change(KEY_BOLD,super.getKeyBold(),keyBold);
			super.setKeyBold(keyBold);
			return this;
		}
		
		/**
		 * 设置 表格内Value是否加粗
		 * @param valueBlod 表格内Value是否加粗
		 * @return 当前对象
		*/
		public AssetLabelTpl setValueBlod(String valueBlod) {
			super.change(VALUE_BLOD,super.getValueBlod(),valueBlod);
			super.setValueBlod(valueBlod);
			return this;
		}
		
		/**
		 * 设置 图片marginTop(mm)
		 * @param imageMarginTop 图片marginTop(mm)
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageMarginTop(BigDecimal imageMarginTop) {
			super.change(IMAGE_MARGIN_TOP,super.getImageMarginTop(),imageMarginTop);
			super.setImageMarginTop(imageMarginTop);
			return this;
		}
		
		/**
		 * 设置 图片marginBottom(mm)
		 * @param imageMarginBottom 图片marginBottom(mm)
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageMarginBottom(BigDecimal imageMarginBottom) {
			super.change(IMAGE_MARGIN_BOTTOM,super.getImageMarginBottom(),imageMarginBottom);
			super.setImageMarginBottom(imageMarginBottom);
			return this;
		}
		
		/**
		 * 设置 图片marginLeft(mm)
		 * @param imageMarginLeft 图片marginLeft(mm)
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageMarginLeft(BigDecimal imageMarginLeft) {
			super.change(IMAGE_MARGIN_LEFT,super.getImageMarginLeft(),imageMarginLeft);
			super.setImageMarginLeft(imageMarginLeft);
			return this;
		}
		
		/**
		 * 设置 图片marginRight(mm)
		 * @param imageMarginRight 图片marginRight(mm)
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageMarginRight(BigDecimal imageMarginRight) {
			super.change(IMAGE_MARGIN_RIGHT,super.getImageMarginRight(),imageMarginRight);
			super.setImageMarginRight(imageMarginRight);
			return this;
		}
		
		/**
		 * 设置 图片宽度
		 * @param imageWidth 图片宽度
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageWidth(BigDecimal imageWidth) {
			super.change(IMAGE_WIDTH,super.getImageWidth(),imageWidth);
			super.setImageWidth(imageWidth);
			return this;
		}
		
		/**
		 * 设置 图片高度
		 * @param imageHeight 图片高度
		 * @return 当前对象
		*/
		public AssetLabelTpl setImageHeight(BigDecimal imageHeight) {
			super.change(IMAGE_HEIGHT,super.getImageHeight(),imageHeight);
			super.setImageHeight(imageHeight);
			return this;
		}
		
		/**
		 * 设置 Item
		 * @param assetLabelItemList Item
		 * @return 当前对象
		*/
		public AssetLabelTpl setAssetLabelItemList(List<AssetLabelTplItem> assetLabelItemList) {
			super.change(ASSET_LABEL_ITEM_LIST,super.getAssetLabelItemList(),assetLabelItemList);
			super.setAssetLabelItemList(assetLabelItemList);
			return this;
		}
		
		/**
		 * 设置 Column
		 * @param assetLabelColumnlList Column
		 * @return 当前对象
		*/
		public AssetLabelTpl setAssetLabelColumnlList(List<AssetLabelCol> assetLabelColumnlList) {
			super.change(ASSET_LABEL_COLUMNL_LIST,super.getAssetLabelColumnlList(),assetLabelColumnlList);
			super.setAssetLabelColumnlList(assetLabelColumnlList);
			return this;
		}
		
		/**
		 * 设置 assetLabelLayout
		 * @param assetLabelLayoutList assetLabelLayout
		 * @return 当前对象
		*/
		public AssetLabelTpl setAssetLabelLayoutList(List<AssetLabelLayout> assetLabelLayoutList) {
			super.change(ASSET_LABEL_LAYOUT_LIST,super.getAssetLabelLayoutList(),assetLabelLayoutList);
			super.setAssetLabelLayoutList(assetLabelLayoutList);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetLabelTpl clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetLabelTpl duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setImageMarginLeft(this.getImageMarginLeft());
			inst.setNotes(this.getNotes());
			inst.setLabelTableMarginLeft(this.getLabelTableMarginLeft());
			inst.setType(this.getType());
			inst.setLabelFormatContent(this.getLabelFormatContent());
			inst.setImageMarginBottom(this.getImageMarginBottom());
			inst.setImageColId(this.getImageColId());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setImageMarginTop(this.getImageMarginTop());
			inst.setKeyBold(this.getKeyBold());
			inst.setId(this.getId());
			inst.setImageType(this.getImageType());
			inst.setImageShow(this.getImageShow());
			inst.setImageWidth(this.getImageWidth());
			inst.setLabelTableMarginRight(this.getLabelTableMarginRight());
			inst.setValueBlod(this.getValueBlod());
			inst.setColIds(this.getColIds());
			inst.setImagePosition(this.getImagePosition());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setImageMarginRight(this.getImageMarginRight());
			inst.setVersion(this.getVersion());
			inst.setImageHeight(this.getImageHeight());
			inst.setImageLabelShow(this.getImageLabelShow());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setLabelTableMarginTop(this.getLabelTableMarginTop());
			inst.setIsCustom(this.getIsCustom());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setLabelTableMarginBottom(this.getLabelTableMarginBottom());
			if(all) {
				inst.setAssetLabelColumnlList(this.getAssetLabelColumnlList());
				inst.setAssetLabelItemList(this.getAssetLabelItemList());
				inst.setAssetLabelLayoutList(this.getAssetLabelLayoutList());
			}
			inst.clearModifies();
			return inst;
		}

	}
}