package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetLabel;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.AssetLabelTpl;
import com.dt.platform.domain.eam.AssetLabelPaper;
import com.dt.platform.domain.eam.AssetLabelCol;
import java.util.List;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-07 09:48:43
 * @sign 96D2836263185E2A41E3AEC3F9B0F82F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetLabelMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 字体 , 类型: java.lang.String
	*/
	public static final String FONT_TYPE="fontType";
	
	/**
	 * 字体 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.lang.String> FONT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,FONT_TYPE, java.lang.String.class, "字体", "字体", java.lang.String.class, null);
	
	/**
	 * 字体路径 , 类型: java.lang.String
	*/
	public static final String FONT_PATH="fontPath";
	
	/**
	 * 字体路径 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.lang.String> FONT_PATH_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,FONT_PATH, java.lang.String.class, "字体路径", "字体路径", java.lang.String.class, null);
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final String LABEL_TPL_ID="labelTplId";
	
	/**
	 * 标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.lang.String> LABEL_TPL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,LABEL_TPL_ID, java.lang.String.class, "标签", "标签", java.lang.String.class, null);
	
	/**
	 * 标签宽度(cm) , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_WIDTH="labelWidth";
	
	/**
	 * 标签宽度(cm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> LABEL_WIDTH_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,LABEL_WIDTH, java.math.BigDecimal.class, "标签宽度(cm)", "标签宽度(cm)", java.math.BigDecimal.class, null);
	
	/**
	 * 标签高度(cm) , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_HEIGHT="labelHeight";
	
	/**
	 * 标签高度(cm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> LABEL_HEIGHT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,LABEL_HEIGHT, java.math.BigDecimal.class, "标签高度(cm)", "标签高度(cm)", java.math.BigDecimal.class, null);
	
	/**
	 * 标签布局(暂时不用) , 类型: java.lang.String
	*/
	public static final String LABEL_LAYOUT="labelLayout";
	
	/**
	 * 标签布局(暂时不用) , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.lang.String> LABEL_LAYOUT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,LABEL_LAYOUT, java.lang.String.class, "标签布局(暂时不用)", "标签布局(暂时不用)", java.lang.String.class, null);
	
	/**
	 * 标签间隔 , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_TABLE_MARGIN="labelTableMargin";
	
	/**
	 * 标签间隔 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> LABEL_TABLE_MARGIN_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,LABEL_TABLE_MARGIN, java.math.BigDecimal.class, "标签间隔", "标签间隔", java.math.BigDecimal.class, null);
	
	/**
	 * 表格marginTop(mm) , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_TABLE_MARGIN_TOP="labelTableMarginTop";
	
	/**
	 * 表格marginTop(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> LABEL_TABLE_MARGIN_TOP_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,LABEL_TABLE_MARGIN_TOP, java.math.BigDecimal.class, "表格marginTop(mm)", "表格marginTop(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 表格marginBottom(mm) , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_TABLE_MARGIN_BOTTOM="labelTableMarginBottom";
	
	/**
	 * 表格marginBottom(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> LABEL_TABLE_MARGIN_BOTTOM_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,LABEL_TABLE_MARGIN_BOTTOM, java.math.BigDecimal.class, "表格marginBottom(mm)", "表格marginBottom(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 表格marginLeft(mm) , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_TABLE_MARGIN_LEFT="labelTableMarginLeft";
	
	/**
	 * 表格marginLeft(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> LABEL_TABLE_MARGIN_LEFT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,LABEL_TABLE_MARGIN_LEFT, java.math.BigDecimal.class, "表格marginLeft(mm)", "表格marginLeft(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 表格marginRight(mm) , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_TABLE_MARGIN_RIGHT="labelTableMarginRight";
	
	/**
	 * 表格marginRight(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> LABEL_TABLE_MARGIN_RIGHT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,LABEL_TABLE_MARGIN_RIGHT, java.math.BigDecimal.class, "表格marginRight(mm)", "表格marginRight(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 字体大小(mm) , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_KEY_FONT_SIZE="labelKeyFontSize";
	
	/**
	 * 字体大小(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> LABEL_KEY_FONT_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,LABEL_KEY_FONT_SIZE, java.math.BigDecimal.class, "字体大小(mm)", "字体大小(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * Key宽度 , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_KEY_WIDTH="labelKeyWidth";
	
	/**
	 * Key宽度 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> LABEL_KEY_WIDTH_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,LABEL_KEY_WIDTH, java.math.BigDecimal.class, "Key宽度", "Key宽度", java.math.BigDecimal.class, null);
	
	/**
	 * 字体大小(mm) , 类型: java.math.BigDecimal
	*/
	public static final String LABEL_VALUE_FONT_SIZE="labelValueFontSize";
	
	/**
	 * 字体大小(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> LABEL_VALUE_FONT_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,LABEL_VALUE_FONT_SIZE, java.math.BigDecimal.class, "字体大小(mm)", "字体大小(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 专用标签 , 图像容器大小(mm) , 类型: java.math.BigDecimal
	*/
	public static final String IMAGE_CONTAIN_HEIGHT="imageContainHeight";
	
	/**
	 * 专用标签 , 图像容器大小(mm) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> IMAGE_CONTAIN_HEIGHT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,IMAGE_CONTAIN_HEIGHT, java.math.BigDecimal.class, "专用标签", "图像容器大小(mm)", java.math.BigDecimal.class, null);
	
	/**
	 * 专用标签 , 图形宽度 , 类型: java.math.BigDecimal
	*/
	public static final String IMAGE_WIDTH="imageWidth";
	
	/**
	 * 专用标签 , 图形宽度 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> IMAGE_WIDTH_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,IMAGE_WIDTH, java.math.BigDecimal.class, "专用标签", "图形宽度", java.math.BigDecimal.class, null);
	
	/**
	 * 专用标签 , 图形高度 , 类型: java.math.BigDecimal
	*/
	public static final String IMAGE_HEIGHT="imageHeight";
	
	/**
	 * 专用标签 , 图形高度 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> IMAGE_HEIGHT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,IMAGE_HEIGHT, java.math.BigDecimal.class, "专用标签", "图形高度", java.math.BigDecimal.class, null);
	
	/**
	 * 图片marginTop , 类型: java.math.BigDecimal
	*/
	public static final String IMAGE_MARGIN_TOP="imageMarginTop";
	
	/**
	 * 图片marginTop , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> IMAGE_MARGIN_TOP_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,IMAGE_MARGIN_TOP, java.math.BigDecimal.class, "图片marginTop", "图片marginTop", java.math.BigDecimal.class, null);
	
	/**
	 * 图片marginBottom , 类型: java.math.BigDecimal
	*/
	public static final String IMAGE_MARGIN_BOTTOM="imageMarginBottom";
	
	/**
	 * 图片marginBottom , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> IMAGE_MARGIN_BOTTOM_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,IMAGE_MARGIN_BOTTOM, java.math.BigDecimal.class, "图片marginBottom", "图片marginBottom", java.math.BigDecimal.class, null);
	
	/**
	 * 图片marginLeft , 类型: java.math.BigDecimal
	*/
	public static final String IMAGE_MARGIN_LEFT="imageMarginLeft";
	
	/**
	 * 图片marginLeft , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> IMAGE_MARGIN_LEFT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,IMAGE_MARGIN_LEFT, java.math.BigDecimal.class, "图片marginLeft", "图片marginLeft", java.math.BigDecimal.class, null);
	
	/**
	 * 图片marginRight , 类型: java.math.BigDecimal
	*/
	public static final String IMAGE_MARGIN_RIGHT="imageMarginRight";
	
	/**
	 * 图片marginRight , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.math.BigDecimal> IMAGE_MARGIN_RIGHT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,IMAGE_MARGIN_RIGHT, java.math.BigDecimal.class, "图片marginRight", "图片marginRight", java.math.BigDecimal.class, null);
	
	/**
	 * 纸张类型 , 类型: java.lang.String
	*/
	public static final String PAPER_TYPE_ID="paperTypeId";
	
	/**
	 * 纸张类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.lang.String> PAPER_TYPE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,PAPER_TYPE_ID, java.lang.String.class, "纸张类型", "纸张类型", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 模版 , 类型: com.dt.platform.domain.eam.AssetLabelTpl
	*/
	public static final String ASSET_TPL="assetTpl";
	
	/**
	 * 模版 , 类型: com.dt.platform.domain.eam.AssetLabelTpl
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,com.dt.platform.domain.eam.AssetLabelTpl> ASSET_TPL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,ASSET_TPL, com.dt.platform.domain.eam.AssetLabelTpl.class, "模版", "模版", com.dt.platform.domain.eam.AssetLabelTpl.class, null);
	
	/**
	 * 纸张类型 , 类型: com.dt.platform.domain.eam.AssetLabelPaper
	*/
	public static final String ASSET_PAPER="assetPaper";
	
	/**
	 * 纸张类型 , 类型: com.dt.platform.domain.eam.AssetLabelPaper
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,com.dt.platform.domain.eam.AssetLabelPaper> ASSET_PAPER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,ASSET_PAPER, com.dt.platform.domain.eam.AssetLabelPaper.class, "纸张类型", "纸张类型", com.dt.platform.domain.eam.AssetLabelPaper.class, null);
	
	/**
	 * ColumnList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetLabelCol
	*/
	public static final String ASSET_LABEL_COLUMN_LIST="assetLabelColumnList";
	
	/**
	 * ColumnList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetLabelCol
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetLabel,com.dt.platform.domain.eam.AssetLabelCol> ASSET_LABEL_COLUMN_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetLabel.class ,ASSET_LABEL_COLUMN_LIST, java.util.List.class, "ColumnList", "ColumnList", com.dt.platform.domain.eam.AssetLabelCol.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , FONT_TYPE , FONT_PATH , LABEL_TPL_ID , LABEL_WIDTH , LABEL_HEIGHT , LABEL_LAYOUT , LABEL_TABLE_MARGIN , LABEL_TABLE_MARGIN_TOP , LABEL_TABLE_MARGIN_BOTTOM , LABEL_TABLE_MARGIN_LEFT , LABEL_TABLE_MARGIN_RIGHT , LABEL_KEY_FONT_SIZE , LABEL_KEY_WIDTH , LABEL_VALUE_FONT_SIZE , IMAGE_CONTAIN_HEIGHT , IMAGE_WIDTH , IMAGE_HEIGHT , IMAGE_MARGIN_TOP , IMAGE_MARGIN_BOTTOM , IMAGE_MARGIN_LEFT , IMAGE_MARGIN_RIGHT , PAPER_TYPE_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ASSET_TPL , ASSET_PAPER , ASSET_LABEL_COLUMN_LIST };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetLabel {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetLabel setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public AssetLabel setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 字体
		 * @param fontType 字体
		 * @return 当前对象
		*/
		public AssetLabel setFontType(String fontType) {
			super.change(FONT_TYPE,super.getFontType(),fontType);
			super.setFontType(fontType);
			return this;
		}
		
		/**
		 * 设置 字体路径
		 * @param fontPath 字体路径
		 * @return 当前对象
		*/
		public AssetLabel setFontPath(String fontPath) {
			super.change(FONT_PATH,super.getFontPath(),fontPath);
			super.setFontPath(fontPath);
			return this;
		}
		
		/**
		 * 设置 标签
		 * @param labelTplId 标签
		 * @return 当前对象
		*/
		public AssetLabel setLabelTplId(String labelTplId) {
			super.change(LABEL_TPL_ID,super.getLabelTplId(),labelTplId);
			super.setLabelTplId(labelTplId);
			return this;
		}
		
		/**
		 * 设置 标签宽度(cm)
		 * @param labelWidth 标签宽度(cm)
		 * @return 当前对象
		*/
		public AssetLabel setLabelWidth(BigDecimal labelWidth) {
			super.change(LABEL_WIDTH,super.getLabelWidth(),labelWidth);
			super.setLabelWidth(labelWidth);
			return this;
		}
		
		/**
		 * 设置 标签高度(cm)
		 * @param labelHeight 标签高度(cm)
		 * @return 当前对象
		*/
		public AssetLabel setLabelHeight(BigDecimal labelHeight) {
			super.change(LABEL_HEIGHT,super.getLabelHeight(),labelHeight);
			super.setLabelHeight(labelHeight);
			return this;
		}
		
		/**
		 * 设置 标签布局(暂时不用)
		 * @param labelLayout 标签布局(暂时不用)
		 * @return 当前对象
		*/
		public AssetLabel setLabelLayout(String labelLayout) {
			super.change(LABEL_LAYOUT,super.getLabelLayout(),labelLayout);
			super.setLabelLayout(labelLayout);
			return this;
		}
		
		/**
		 * 设置 标签间隔
		 * @param labelTableMargin 标签间隔
		 * @return 当前对象
		*/
		public AssetLabel setLabelTableMargin(BigDecimal labelTableMargin) {
			super.change(LABEL_TABLE_MARGIN,super.getLabelTableMargin(),labelTableMargin);
			super.setLabelTableMargin(labelTableMargin);
			return this;
		}
		
		/**
		 * 设置 表格marginTop(mm)
		 * @param labelTableMarginTop 表格marginTop(mm)
		 * @return 当前对象
		*/
		public AssetLabel setLabelTableMarginTop(BigDecimal labelTableMarginTop) {
			super.change(LABEL_TABLE_MARGIN_TOP,super.getLabelTableMarginTop(),labelTableMarginTop);
			super.setLabelTableMarginTop(labelTableMarginTop);
			return this;
		}
		
		/**
		 * 设置 表格marginBottom(mm)
		 * @param labelTableMarginBottom 表格marginBottom(mm)
		 * @return 当前对象
		*/
		public AssetLabel setLabelTableMarginBottom(BigDecimal labelTableMarginBottom) {
			super.change(LABEL_TABLE_MARGIN_BOTTOM,super.getLabelTableMarginBottom(),labelTableMarginBottom);
			super.setLabelTableMarginBottom(labelTableMarginBottom);
			return this;
		}
		
		/**
		 * 设置 表格marginLeft(mm)
		 * @param labelTableMarginLeft 表格marginLeft(mm)
		 * @return 当前对象
		*/
		public AssetLabel setLabelTableMarginLeft(BigDecimal labelTableMarginLeft) {
			super.change(LABEL_TABLE_MARGIN_LEFT,super.getLabelTableMarginLeft(),labelTableMarginLeft);
			super.setLabelTableMarginLeft(labelTableMarginLeft);
			return this;
		}
		
		/**
		 * 设置 表格marginRight(mm)
		 * @param labelTableMarginRight 表格marginRight(mm)
		 * @return 当前对象
		*/
		public AssetLabel setLabelTableMarginRight(BigDecimal labelTableMarginRight) {
			super.change(LABEL_TABLE_MARGIN_RIGHT,super.getLabelTableMarginRight(),labelTableMarginRight);
			super.setLabelTableMarginRight(labelTableMarginRight);
			return this;
		}
		
		/**
		 * 设置 字体大小(mm)
		 * @param labelKeyFontSize 字体大小(mm)
		 * @return 当前对象
		*/
		public AssetLabel setLabelKeyFontSize(BigDecimal labelKeyFontSize) {
			super.change(LABEL_KEY_FONT_SIZE,super.getLabelKeyFontSize(),labelKeyFontSize);
			super.setLabelKeyFontSize(labelKeyFontSize);
			return this;
		}
		
		/**
		 * 设置 Key宽度
		 * @param labelKeyWidth Key宽度
		 * @return 当前对象
		*/
		public AssetLabel setLabelKeyWidth(BigDecimal labelKeyWidth) {
			super.change(LABEL_KEY_WIDTH,super.getLabelKeyWidth(),labelKeyWidth);
			super.setLabelKeyWidth(labelKeyWidth);
			return this;
		}
		
		/**
		 * 设置 字体大小(mm)
		 * @param labelValueFontSize 字体大小(mm)
		 * @return 当前对象
		*/
		public AssetLabel setLabelValueFontSize(BigDecimal labelValueFontSize) {
			super.change(LABEL_VALUE_FONT_SIZE,super.getLabelValueFontSize(),labelValueFontSize);
			super.setLabelValueFontSize(labelValueFontSize);
			return this;
		}
		
		/**
		 * 设置 专用标签
		 * @param imageContainHeight 专用标签
		 * @return 当前对象
		*/
		public AssetLabel setImageContainHeight(BigDecimal imageContainHeight) {
			super.change(IMAGE_CONTAIN_HEIGHT,super.getImageContainHeight(),imageContainHeight);
			super.setImageContainHeight(imageContainHeight);
			return this;
		}
		
		/**
		 * 设置 专用标签
		 * @param imageWidth 专用标签
		 * @return 当前对象
		*/
		public AssetLabel setImageWidth(BigDecimal imageWidth) {
			super.change(IMAGE_WIDTH,super.getImageWidth(),imageWidth);
			super.setImageWidth(imageWidth);
			return this;
		}
		
		/**
		 * 设置 专用标签
		 * @param imageHeight 专用标签
		 * @return 当前对象
		*/
		public AssetLabel setImageHeight(BigDecimal imageHeight) {
			super.change(IMAGE_HEIGHT,super.getImageHeight(),imageHeight);
			super.setImageHeight(imageHeight);
			return this;
		}
		
		/**
		 * 设置 图片marginTop
		 * @param imageMarginTop 图片marginTop
		 * @return 当前对象
		*/
		public AssetLabel setImageMarginTop(BigDecimal imageMarginTop) {
			super.change(IMAGE_MARGIN_TOP,super.getImageMarginTop(),imageMarginTop);
			super.setImageMarginTop(imageMarginTop);
			return this;
		}
		
		/**
		 * 设置 图片marginBottom
		 * @param imageMarginBottom 图片marginBottom
		 * @return 当前对象
		*/
		public AssetLabel setImageMarginBottom(BigDecimal imageMarginBottom) {
			super.change(IMAGE_MARGIN_BOTTOM,super.getImageMarginBottom(),imageMarginBottom);
			super.setImageMarginBottom(imageMarginBottom);
			return this;
		}
		
		/**
		 * 设置 图片marginLeft
		 * @param imageMarginLeft 图片marginLeft
		 * @return 当前对象
		*/
		public AssetLabel setImageMarginLeft(BigDecimal imageMarginLeft) {
			super.change(IMAGE_MARGIN_LEFT,super.getImageMarginLeft(),imageMarginLeft);
			super.setImageMarginLeft(imageMarginLeft);
			return this;
		}
		
		/**
		 * 设置 图片marginRight
		 * @param imageMarginRight 图片marginRight
		 * @return 当前对象
		*/
		public AssetLabel setImageMarginRight(BigDecimal imageMarginRight) {
			super.change(IMAGE_MARGIN_RIGHT,super.getImageMarginRight(),imageMarginRight);
			super.setImageMarginRight(imageMarginRight);
			return this;
		}
		
		/**
		 * 设置 纸张类型
		 * @param paperTypeId 纸张类型
		 * @return 当前对象
		*/
		public AssetLabel setPaperTypeId(String paperTypeId) {
			super.change(PAPER_TYPE_ID,super.getPaperTypeId(),paperTypeId);
			super.setPaperTypeId(paperTypeId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetLabel setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetLabel setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetLabel setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetLabel setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetLabel setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetLabel setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetLabel setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetLabel setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetLabel setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 模版
		 * @param assetTpl 模版
		 * @return 当前对象
		*/
		public AssetLabel setAssetTpl(AssetLabelTpl assetTpl) {
			super.change(ASSET_TPL,super.getAssetTpl(),assetTpl);
			super.setAssetTpl(assetTpl);
			return this;
		}
		
		/**
		 * 设置 纸张类型
		 * @param assetPaper 纸张类型
		 * @return 当前对象
		*/
		public AssetLabel setAssetPaper(AssetLabelPaper assetPaper) {
			super.change(ASSET_PAPER,super.getAssetPaper(),assetPaper);
			super.setAssetPaper(assetPaper);
			return this;
		}
		
		/**
		 * 设置 ColumnList
		 * @param assetLabelColumnList ColumnList
		 * @return 当前对象
		*/
		public AssetLabel setAssetLabelColumnList(List<AssetLabelCol> assetLabelColumnList) {
			super.change(ASSET_LABEL_COLUMN_LIST,super.getAssetLabelColumnList(),assetLabelColumnList);
			super.setAssetLabelColumnList(assetLabelColumnList);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetLabel clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetLabel duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setImageMarginLeft(this.getImageMarginLeft());
			inst.setCode(this.getCode());
			inst.setLabelKeyWidth(this.getLabelKeyWidth());
			inst.setPaperTypeId(this.getPaperTypeId());
			inst.setLabelTplId(this.getLabelTplId());
			inst.setLabelTableMargin(this.getLabelTableMargin());
			inst.setLabelLayout(this.getLabelLayout());
			inst.setLabelWidth(this.getLabelWidth());
			inst.setLabelTableMarginLeft(this.getLabelTableMarginLeft());
			inst.setLabelValueFontSize(this.getLabelValueFontSize());
			inst.setImageMarginBottom(this.getImageMarginBottom());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setImageMarginTop(this.getImageMarginTop());
			inst.setId(this.getId());
			inst.setFontPath(this.getFontPath());
			inst.setImageWidth(this.getImageWidth());
			inst.setFontType(this.getFontType());
			inst.setLabelTableMarginRight(this.getLabelTableMarginRight());
			inst.setImageContainHeight(this.getImageContainHeight());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setImageMarginRight(this.getImageMarginRight());
			inst.setLabelHeight(this.getLabelHeight());
			inst.setVersion(this.getVersion());
			inst.setImageHeight(this.getImageHeight());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setLabelKeyFontSize(this.getLabelKeyFontSize());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setLabelTableMarginTop(this.getLabelTableMarginTop());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setLabelTableMarginBottom(this.getLabelTableMarginBottom());
			if(all) {
				inst.setAssetLabelColumnList(this.getAssetLabelColumnList());
				inst.setAssetTpl(this.getAssetTpl());
				inst.setAssetPaper(this.getAssetPaper());
			}
			inst.clearModifies();
			return inst;
		}

	}
}