package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_LABEL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetLabelMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产标签
 * <p>资产标签 , 数据表 eam_asset_label 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-07 09:48:43
 * @sign 96D2836263185E2A41E3AEC3F9B0F82F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_label")
@ApiModel(description = "资产标签 ; 资产标签 , 数据表 eam_asset_label 的PO类型")
public class AssetLabel extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_LABEL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "1")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = true,value="编码" , notes = "编码" , example = "T001")
	private String code;
	
	/**
	 * 字体：字体
	*/
	@ApiModelProperty(required = false,value="字体" , notes = "字体" , example = "MYSH")
	private String fontType;
	
	/**
	 * 字体路径：字体路径
	*/
	@ApiModelProperty(required = false,value="字体路径" , notes = "字体路径" , example = "/Users/lankl/IdeaProjects/eam/bin/simhei.ttf")
	private String fontPath;
	
	/**
	 * 标签：标签
	*/
	@ApiModelProperty(required = false,value="标签" , notes = "标签" , example = "650449362169626624")
	private String labelTplId;
	
	/**
	 * 标签宽度(cm)：标签宽度(cm)
	*/
	@ApiModelProperty(required = false,value="标签宽度(cm)" , notes = "标签宽度(cm)" , example = "8.00")
	private BigDecimal labelWidth;
	
	/**
	 * 标签高度(cm)：标签高度(cm)
	*/
	@ApiModelProperty(required = false,value="标签高度(cm)" , notes = "标签高度(cm)" , example = "6.00")
	private BigDecimal labelHeight;
	
	/**
	 * 标签布局(暂时不用)：标签布局(暂时不用)
	*/
	@ApiModelProperty(required = false,value="标签布局(暂时不用)" , notes = "标签布局(暂时不用)")
	private String labelLayout;
	
	/**
	 * 标签间隔：标签间隔
	*/
	@ApiModelProperty(required = false,value="标签间隔" , notes = "标签间隔" , example = "1.00")
	private BigDecimal labelTableMargin;
	
	/**
	 * 表格marginTop(mm)：表格marginTop(mm)
	*/
	@ApiModelProperty(required = false,value="表格marginTop(mm)" , notes = "表格marginTop(mm)" , example = "0.30")
	private BigDecimal labelTableMarginTop;
	
	/**
	 * 表格marginBottom(mm)：表格marginBottom(mm)
	*/
	@ApiModelProperty(required = false,value="表格marginBottom(mm)" , notes = "表格marginBottom(mm)" , example = "0.00")
	private BigDecimal labelTableMarginBottom;
	
	/**
	 * 表格marginLeft(mm)：表格marginLeft(mm)
	*/
	@ApiModelProperty(required = false,value="表格marginLeft(mm)" , notes = "表格marginLeft(mm)" , example = "0.00")
	private BigDecimal labelTableMarginLeft;
	
	/**
	 * 表格marginRight(mm)：表格marginRight(mm)
	*/
	@ApiModelProperty(required = false,value="表格marginRight(mm)" , notes = "表格marginRight(mm)" , example = "0.00")
	private BigDecimal labelTableMarginRight;
	
	/**
	 * 字体大小(mm)：字体大小(mm)
	*/
	@ApiModelProperty(required = false,value="字体大小(mm)" , notes = "字体大小(mm)" , example = "2.80")
	private BigDecimal labelKeyFontSize;
	
	/**
	 * Key宽度：Key宽度
	*/
	@ApiModelProperty(required = false,value="Key宽度" , notes = "Key宽度" , example = "15.00")
	private BigDecimal labelKeyWidth;
	
	/**
	 * 字体大小(mm)：字体大小(mm)
	*/
	@ApiModelProperty(required = false,value="字体大小(mm)" , notes = "字体大小(mm)" , example = "2.80")
	private BigDecimal labelValueFontSize;
	
	/**
	 * 专用标签：图像容器大小(mm)
	*/
	@ApiModelProperty(required = false,value="专用标签" , notes = "图像容器大小(mm)" , example = "28.00")
	private BigDecimal imageContainHeight;
	
	/**
	 * 专用标签：图形宽度
	*/
	@ApiModelProperty(required = false,value="专用标签" , notes = "图形宽度" , example = "27.00")
	private BigDecimal imageWidth;
	
	/**
	 * 专用标签：图形高度
	*/
	@ApiModelProperty(required = false,value="专用标签" , notes = "图形高度" , example = "27.00")
	private BigDecimal imageHeight;
	
	/**
	 * 图片marginTop：图片marginTop
	*/
	@ApiModelProperty(required = false,value="图片marginTop" , notes = "图片marginTop" , example = "1.00")
	private BigDecimal imageMarginTop;
	
	/**
	 * 图片marginBottom：图片marginBottom
	*/
	@ApiModelProperty(required = false,value="图片marginBottom" , notes = "图片marginBottom" , example = "10.00")
	private BigDecimal imageMarginBottom;
	
	/**
	 * 图片marginLeft：图片marginLeft
	*/
	@ApiModelProperty(required = false,value="图片marginLeft" , notes = "图片marginLeft" , example = "0.00")
	private BigDecimal imageMarginLeft;
	
	/**
	 * 图片marginRight：图片marginRight
	*/
	@ApiModelProperty(required = false,value="图片marginRight" , notes = "图片marginRight" , example = "0.00")
	private BigDecimal imageMarginRight;
	
	/**
	 * 纸张类型：纸张类型
	*/
	@ApiModelProperty(required = false,value="纸张类型" , notes = "纸张类型" , example = "1")
	private String paperTypeId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-12-03 02:06:23")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "32")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 模版：模版
	*/
	@ApiModelProperty(required = false,value="模版" , notes = "模版")
	private AssetLabelTpl assetTpl;
	
	/**
	 * 纸张类型：纸张类型
	*/
	@ApiModelProperty(required = false,value="纸张类型" , notes = "纸张类型")
	private AssetLabelPaper assetPaper;
	
	/**
	 * ColumnList：ColumnList
	*/
	@ApiModelProperty(required = false,value="ColumnList" , notes = "ColumnList")
	private List<AssetLabelCol> assetLabelColumnList;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public AssetLabel setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	public AssetLabel setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 字体<br>
	 * 字体
	 * @return 字体
	*/
	public String getFontType() {
		return fontType;
	}
	
	/**
	 * 设置 字体
	 * @param fontType 字体
	 * @return 当前对象
	*/
	public AssetLabel setFontType(String fontType) {
		this.fontType=fontType;
		return this;
	}
	
	/**
	 * 获得 字体路径<br>
	 * 字体路径
	 * @return 字体路径
	*/
	public String getFontPath() {
		return fontPath;
	}
	
	/**
	 * 设置 字体路径
	 * @param fontPath 字体路径
	 * @return 当前对象
	*/
	public AssetLabel setFontPath(String fontPath) {
		this.fontPath=fontPath;
		return this;
	}
	
	/**
	 * 获得 标签<br>
	 * 标签
	 * @return 标签
	*/
	public String getLabelTplId() {
		return labelTplId;
	}
	
	/**
	 * 设置 标签
	 * @param labelTplId 标签
	 * @return 当前对象
	*/
	public AssetLabel setLabelTplId(String labelTplId) {
		this.labelTplId=labelTplId;
		return this;
	}
	
	/**
	 * 获得 标签宽度(cm)<br>
	 * 标签宽度(cm)
	 * @return 标签宽度(cm)
	*/
	public BigDecimal getLabelWidth() {
		return labelWidth;
	}
	
	/**
	 * 设置 标签宽度(cm)
	 * @param labelWidth 标签宽度(cm)
	 * @return 当前对象
	*/
	public AssetLabel setLabelWidth(BigDecimal labelWidth) {
		this.labelWidth=labelWidth;
		return this;
	}
	
	/**
	 * 获得 标签高度(cm)<br>
	 * 标签高度(cm)
	 * @return 标签高度(cm)
	*/
	public BigDecimal getLabelHeight() {
		return labelHeight;
	}
	
	/**
	 * 设置 标签高度(cm)
	 * @param labelHeight 标签高度(cm)
	 * @return 当前对象
	*/
	public AssetLabel setLabelHeight(BigDecimal labelHeight) {
		this.labelHeight=labelHeight;
		return this;
	}
	
	/**
	 * 获得 标签布局(暂时不用)<br>
	 * 标签布局(暂时不用)
	 * @return 标签布局(暂时不用)
	*/
	public String getLabelLayout() {
		return labelLayout;
	}
	
	/**
	 * 设置 标签布局(暂时不用)
	 * @param labelLayout 标签布局(暂时不用)
	 * @return 当前对象
	*/
	public AssetLabel setLabelLayout(String labelLayout) {
		this.labelLayout=labelLayout;
		return this;
	}
	
	/**
	 * 获得 标签间隔<br>
	 * 标签间隔
	 * @return 标签间隔
	*/
	public BigDecimal getLabelTableMargin() {
		return labelTableMargin;
	}
	
	/**
	 * 设置 标签间隔
	 * @param labelTableMargin 标签间隔
	 * @return 当前对象
	*/
	public AssetLabel setLabelTableMargin(BigDecimal labelTableMargin) {
		this.labelTableMargin=labelTableMargin;
		return this;
	}
	
	/**
	 * 获得 表格marginTop(mm)<br>
	 * 表格marginTop(mm)
	 * @return 表格marginTop(mm)
	*/
	public BigDecimal getLabelTableMarginTop() {
		return labelTableMarginTop;
	}
	
	/**
	 * 设置 表格marginTop(mm)
	 * @param labelTableMarginTop 表格marginTop(mm)
	 * @return 当前对象
	*/
	public AssetLabel setLabelTableMarginTop(BigDecimal labelTableMarginTop) {
		this.labelTableMarginTop=labelTableMarginTop;
		return this;
	}
	
	/**
	 * 获得 表格marginBottom(mm)<br>
	 * 表格marginBottom(mm)
	 * @return 表格marginBottom(mm)
	*/
	public BigDecimal getLabelTableMarginBottom() {
		return labelTableMarginBottom;
	}
	
	/**
	 * 设置 表格marginBottom(mm)
	 * @param labelTableMarginBottom 表格marginBottom(mm)
	 * @return 当前对象
	*/
	public AssetLabel setLabelTableMarginBottom(BigDecimal labelTableMarginBottom) {
		this.labelTableMarginBottom=labelTableMarginBottom;
		return this;
	}
	
	/**
	 * 获得 表格marginLeft(mm)<br>
	 * 表格marginLeft(mm)
	 * @return 表格marginLeft(mm)
	*/
	public BigDecimal getLabelTableMarginLeft() {
		return labelTableMarginLeft;
	}
	
	/**
	 * 设置 表格marginLeft(mm)
	 * @param labelTableMarginLeft 表格marginLeft(mm)
	 * @return 当前对象
	*/
	public AssetLabel setLabelTableMarginLeft(BigDecimal labelTableMarginLeft) {
		this.labelTableMarginLeft=labelTableMarginLeft;
		return this;
	}
	
	/**
	 * 获得 表格marginRight(mm)<br>
	 * 表格marginRight(mm)
	 * @return 表格marginRight(mm)
	*/
	public BigDecimal getLabelTableMarginRight() {
		return labelTableMarginRight;
	}
	
	/**
	 * 设置 表格marginRight(mm)
	 * @param labelTableMarginRight 表格marginRight(mm)
	 * @return 当前对象
	*/
	public AssetLabel setLabelTableMarginRight(BigDecimal labelTableMarginRight) {
		this.labelTableMarginRight=labelTableMarginRight;
		return this;
	}
	
	/**
	 * 获得 字体大小(mm)<br>
	 * 字体大小(mm)
	 * @return 字体大小(mm)
	*/
	public BigDecimal getLabelKeyFontSize() {
		return labelKeyFontSize;
	}
	
	/**
	 * 设置 字体大小(mm)
	 * @param labelKeyFontSize 字体大小(mm)
	 * @return 当前对象
	*/
	public AssetLabel setLabelKeyFontSize(BigDecimal labelKeyFontSize) {
		this.labelKeyFontSize=labelKeyFontSize;
		return this;
	}
	
	/**
	 * 获得 Key宽度<br>
	 * Key宽度
	 * @return Key宽度
	*/
	public BigDecimal getLabelKeyWidth() {
		return labelKeyWidth;
	}
	
	/**
	 * 设置 Key宽度
	 * @param labelKeyWidth Key宽度
	 * @return 当前对象
	*/
	public AssetLabel setLabelKeyWidth(BigDecimal labelKeyWidth) {
		this.labelKeyWidth=labelKeyWidth;
		return this;
	}
	
	/**
	 * 获得 字体大小(mm)<br>
	 * 字体大小(mm)
	 * @return 字体大小(mm)
	*/
	public BigDecimal getLabelValueFontSize() {
		return labelValueFontSize;
	}
	
	/**
	 * 设置 字体大小(mm)
	 * @param labelValueFontSize 字体大小(mm)
	 * @return 当前对象
	*/
	public AssetLabel setLabelValueFontSize(BigDecimal labelValueFontSize) {
		this.labelValueFontSize=labelValueFontSize;
		return this;
	}
	
	/**
	 * 获得 专用标签<br>
	 * 图像容器大小(mm)
	 * @return 专用标签
	*/
	public BigDecimal getImageContainHeight() {
		return imageContainHeight;
	}
	
	/**
	 * 设置 专用标签
	 * @param imageContainHeight 专用标签
	 * @return 当前对象
	*/
	public AssetLabel setImageContainHeight(BigDecimal imageContainHeight) {
		this.imageContainHeight=imageContainHeight;
		return this;
	}
	
	/**
	 * 获得 专用标签<br>
	 * 图形宽度
	 * @return 专用标签
	*/
	public BigDecimal getImageWidth() {
		return imageWidth;
	}
	
	/**
	 * 设置 专用标签
	 * @param imageWidth 专用标签
	 * @return 当前对象
	*/
	public AssetLabel setImageWidth(BigDecimal imageWidth) {
		this.imageWidth=imageWidth;
		return this;
	}
	
	/**
	 * 获得 专用标签<br>
	 * 图形高度
	 * @return 专用标签
	*/
	public BigDecimal getImageHeight() {
		return imageHeight;
	}
	
	/**
	 * 设置 专用标签
	 * @param imageHeight 专用标签
	 * @return 当前对象
	*/
	public AssetLabel setImageHeight(BigDecimal imageHeight) {
		this.imageHeight=imageHeight;
		return this;
	}
	
	/**
	 * 获得 图片marginTop<br>
	 * 图片marginTop
	 * @return 图片marginTop
	*/
	public BigDecimal getImageMarginTop() {
		return imageMarginTop;
	}
	
	/**
	 * 设置 图片marginTop
	 * @param imageMarginTop 图片marginTop
	 * @return 当前对象
	*/
	public AssetLabel setImageMarginTop(BigDecimal imageMarginTop) {
		this.imageMarginTop=imageMarginTop;
		return this;
	}
	
	/**
	 * 获得 图片marginBottom<br>
	 * 图片marginBottom
	 * @return 图片marginBottom
	*/
	public BigDecimal getImageMarginBottom() {
		return imageMarginBottom;
	}
	
	/**
	 * 设置 图片marginBottom
	 * @param imageMarginBottom 图片marginBottom
	 * @return 当前对象
	*/
	public AssetLabel setImageMarginBottom(BigDecimal imageMarginBottom) {
		this.imageMarginBottom=imageMarginBottom;
		return this;
	}
	
	/**
	 * 获得 图片marginLeft<br>
	 * 图片marginLeft
	 * @return 图片marginLeft
	*/
	public BigDecimal getImageMarginLeft() {
		return imageMarginLeft;
	}
	
	/**
	 * 设置 图片marginLeft
	 * @param imageMarginLeft 图片marginLeft
	 * @return 当前对象
	*/
	public AssetLabel setImageMarginLeft(BigDecimal imageMarginLeft) {
		this.imageMarginLeft=imageMarginLeft;
		return this;
	}
	
	/**
	 * 获得 图片marginRight<br>
	 * 图片marginRight
	 * @return 图片marginRight
	*/
	public BigDecimal getImageMarginRight() {
		return imageMarginRight;
	}
	
	/**
	 * 设置 图片marginRight
	 * @param imageMarginRight 图片marginRight
	 * @return 当前对象
	*/
	public AssetLabel setImageMarginRight(BigDecimal imageMarginRight) {
		this.imageMarginRight=imageMarginRight;
		return this;
	}
	
	/**
	 * 获得 纸张类型<br>
	 * 纸张类型
	 * @return 纸张类型
	*/
	public String getPaperTypeId() {
		return paperTypeId;
	}
	
	/**
	 * 设置 纸张类型
	 * @param paperTypeId 纸张类型
	 * @return 当前对象
	*/
	public AssetLabel setPaperTypeId(String paperTypeId) {
		this.paperTypeId=paperTypeId;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public AssetLabel setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public AssetLabel setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public AssetLabel setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public AssetLabel setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public AssetLabel setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public AssetLabel setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public AssetLabel setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public AssetLabel setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public AssetLabel setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public AssetLabel setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 模版<br>
	 * 模版
	 * @return 模版
	*/
	public AssetLabelTpl getAssetTpl() {
		return assetTpl;
	}
	
	/**
	 * 设置 模版
	 * @param assetTpl 模版
	 * @return 当前对象
	*/
	public AssetLabel setAssetTpl(AssetLabelTpl assetTpl) {
		this.assetTpl=assetTpl;
		return this;
	}
	
	/**
	 * 获得 纸张类型<br>
	 * 纸张类型
	 * @return 纸张类型
	*/
	public AssetLabelPaper getAssetPaper() {
		return assetPaper;
	}
	
	/**
	 * 设置 纸张类型
	 * @param assetPaper 纸张类型
	 * @return 当前对象
	*/
	public AssetLabel setAssetPaper(AssetLabelPaper assetPaper) {
		this.assetPaper=assetPaper;
		return this;
	}
	
	/**
	 * 获得 ColumnList<br>
	 * ColumnList
	 * @return ColumnList
	*/
	public List<AssetLabelCol> getAssetLabelColumnList() {
		return assetLabelColumnList;
	}
	
	/**
	 * 设置 ColumnList
	 * @param assetLabelColumnList ColumnList
	 * @return 当前对象
	*/
	public AssetLabel setAssetLabelColumnList(List<AssetLabelCol> assetLabelColumnList) {
		this.assetLabelColumnList=assetLabelColumnList;
		return this;
	}
	
	/**
	 * 添加 ColumnList
	 * @param assetLabelColumn ColumnList
	 * @return 当前对象
	*/
	public AssetLabel addAssetLabelColumn(AssetLabelCol... assetLabelColumn) {
		if(this.assetLabelColumnList==null) assetLabelColumnList=new ArrayList<>();
		this.assetLabelColumnList.addAll(Arrays.asList(assetLabelColumn));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetLabel , 转换好的 AssetLabel 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetLabel , 转换好的 PoJo 对象
	*/
	@Transient
	public <T> T toPojo(Class<T> pojoType) {
		if(Entity.class.isAssignableFrom(pojoType)) {
			return (T)this.toPO((Class<Entity>)pojoType);
		}
		try {
			T pojo=pojoType.newInstance();
			EntityContext.copyProperties(pojo, this);
			return pojo;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
		com.dt.platform.domain.eam.meta.AssetLabelMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetLabelMeta.$$proxy$$();
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

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetLabel clone(boolean deep) {
		return EntityContext.clone(AssetLabel.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetLabel
	 * @param assetLabelMap 包含实体信息的 Map 对象
	 * @return AssetLabel , 转换好的的 AssetLabel 对象
	*/
	@Transient
	public static AssetLabel createFrom(Map<String,Object> assetLabelMap) {
		if(assetLabelMap==null) return null;
		AssetLabel po = create();
		EntityContext.copyProperties(po,assetLabelMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetLabel
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetLabel , 转换好的的 AssetLabel 对象
	*/
	@Transient
	public static AssetLabel createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetLabel po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetLabel，等同于 new
	 * @return AssetLabel 对象
	*/
	@Transient
	public static AssetLabel create() {
		return new com.dt.platform.domain.eam.meta.AssetLabelMeta.$$proxy$$();
	}

	/**
	 * 从 Map 读取
	 * @param map 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(Map<String, Object> map,boolean cast) {
		if(map==null) return false;
		if(cast) {
			this.setImageMarginLeft(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.IMAGE_MARGIN_LEFT)));
			this.setCode(DataParser.parse(String.class, map.get(AssetLabelMeta.CODE)));
			this.setLabelKeyWidth(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.LABEL_KEY_WIDTH)));
			this.setPaperTypeId(DataParser.parse(String.class, map.get(AssetLabelMeta.PAPER_TYPE_ID)));
			this.setLabelTplId(DataParser.parse(String.class, map.get(AssetLabelMeta.LABEL_TPL_ID)));
			this.setLabelTableMargin(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.LABEL_TABLE_MARGIN)));
			this.setLabelLayout(DataParser.parse(String.class, map.get(AssetLabelMeta.LABEL_LAYOUT)));
			this.setLabelWidth(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.LABEL_WIDTH)));
			this.setLabelTableMarginLeft(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.LABEL_TABLE_MARGIN_LEFT)));
			this.setLabelValueFontSize(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.LABEL_VALUE_FONT_SIZE)));
			this.setImageMarginBottom(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.IMAGE_MARGIN_BOTTOM)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetLabelMeta.UPDATE_BY)));
			this.setImageMarginTop(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.IMAGE_MARGIN_TOP)));
			this.setId(DataParser.parse(String.class, map.get(AssetLabelMeta.ID)));
			this.setFontPath(DataParser.parse(String.class, map.get(AssetLabelMeta.FONT_PATH)));
			this.setImageWidth(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.IMAGE_WIDTH)));
			this.setFontType(DataParser.parse(String.class, map.get(AssetLabelMeta.FONT_TYPE)));
			this.setLabelTableMarginRight(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.LABEL_TABLE_MARGIN_RIGHT)));
			this.setImageContainHeight(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.IMAGE_CONTAIN_HEIGHT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetLabelMeta.UPDATE_TIME)));
			this.setImageMarginRight(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.IMAGE_MARGIN_RIGHT)));
			this.setLabelHeight(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.LABEL_HEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetLabelMeta.VERSION)));
			this.setImageHeight(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.IMAGE_HEIGHT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetLabelMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetLabelMeta.DELETED)));
			this.setLabelKeyFontSize(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.LABEL_KEY_FONT_SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetLabelMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetLabelMeta.DELETE_TIME)));
			this.setLabelTableMarginTop(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.LABEL_TABLE_MARGIN_TOP)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetLabelMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetLabelMeta.DELETE_BY)));
			this.setLabelTableMarginBottom(DataParser.parse(BigDecimal.class, map.get(AssetLabelMeta.LABEL_TABLE_MARGIN_BOTTOM)));
			// others
			this.setAssetTpl(DataParser.parse(AssetLabelTpl.class, map.get(AssetLabelMeta.ASSET_TPL)));
			this.setAssetPaper(DataParser.parse(AssetLabelPaper.class, map.get(AssetLabelMeta.ASSET_PAPER)));
			return true;
		} else {
			try {
				this.setImageMarginLeft( (BigDecimal)map.get(AssetLabelMeta.IMAGE_MARGIN_LEFT));
				this.setCode( (String)map.get(AssetLabelMeta.CODE));
				this.setLabelKeyWidth( (BigDecimal)map.get(AssetLabelMeta.LABEL_KEY_WIDTH));
				this.setPaperTypeId( (String)map.get(AssetLabelMeta.PAPER_TYPE_ID));
				this.setLabelTplId( (String)map.get(AssetLabelMeta.LABEL_TPL_ID));
				this.setLabelTableMargin( (BigDecimal)map.get(AssetLabelMeta.LABEL_TABLE_MARGIN));
				this.setLabelLayout( (String)map.get(AssetLabelMeta.LABEL_LAYOUT));
				this.setLabelWidth( (BigDecimal)map.get(AssetLabelMeta.LABEL_WIDTH));
				this.setLabelTableMarginLeft( (BigDecimal)map.get(AssetLabelMeta.LABEL_TABLE_MARGIN_LEFT));
				this.setLabelValueFontSize( (BigDecimal)map.get(AssetLabelMeta.LABEL_VALUE_FONT_SIZE));
				this.setImageMarginBottom( (BigDecimal)map.get(AssetLabelMeta.IMAGE_MARGIN_BOTTOM));
				this.setUpdateBy( (String)map.get(AssetLabelMeta.UPDATE_BY));
				this.setImageMarginTop( (BigDecimal)map.get(AssetLabelMeta.IMAGE_MARGIN_TOP));
				this.setId( (String)map.get(AssetLabelMeta.ID));
				this.setFontPath( (String)map.get(AssetLabelMeta.FONT_PATH));
				this.setImageWidth( (BigDecimal)map.get(AssetLabelMeta.IMAGE_WIDTH));
				this.setFontType( (String)map.get(AssetLabelMeta.FONT_TYPE));
				this.setLabelTableMarginRight( (BigDecimal)map.get(AssetLabelMeta.LABEL_TABLE_MARGIN_RIGHT));
				this.setImageContainHeight( (BigDecimal)map.get(AssetLabelMeta.IMAGE_CONTAIN_HEIGHT));
				this.setUpdateTime( (Date)map.get(AssetLabelMeta.UPDATE_TIME));
				this.setImageMarginRight( (BigDecimal)map.get(AssetLabelMeta.IMAGE_MARGIN_RIGHT));
				this.setLabelHeight( (BigDecimal)map.get(AssetLabelMeta.LABEL_HEIGHT));
				this.setVersion( (Integer)map.get(AssetLabelMeta.VERSION));
				this.setImageHeight( (BigDecimal)map.get(AssetLabelMeta.IMAGE_HEIGHT));
				this.setCreateBy( (String)map.get(AssetLabelMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetLabelMeta.DELETED));
				this.setLabelKeyFontSize( (BigDecimal)map.get(AssetLabelMeta.LABEL_KEY_FONT_SIZE));
				this.setCreateTime( (Date)map.get(AssetLabelMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetLabelMeta.DELETE_TIME));
				this.setLabelTableMarginTop( (BigDecimal)map.get(AssetLabelMeta.LABEL_TABLE_MARGIN_TOP));
				this.setTenantId( (String)map.get(AssetLabelMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetLabelMeta.DELETE_BY));
				this.setLabelTableMarginBottom( (BigDecimal)map.get(AssetLabelMeta.LABEL_TABLE_MARGIN_BOTTOM));
				// others
				this.setAssetTpl( (AssetLabelTpl)map.get(AssetLabelMeta.ASSET_TPL));
				this.setAssetPaper( (AssetLabelPaper)map.get(AssetLabelMeta.ASSET_PAPER));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	/**
	 * 从 Map 读取
	 * @param r 记录数据
	 * @param cast 是否用 DataParser 进行类型转换
	 * @return  是否读取成功
	*/
	public boolean read(ExprRcd r,boolean cast) {
		if(r==null) return false;
		if(cast) {
			this.setImageMarginLeft(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.IMAGE_MARGIN_LEFT)));
			this.setCode(DataParser.parse(String.class, r.getValue(AssetLabelMeta.CODE)));
			this.setLabelKeyWidth(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.LABEL_KEY_WIDTH)));
			this.setPaperTypeId(DataParser.parse(String.class, r.getValue(AssetLabelMeta.PAPER_TYPE_ID)));
			this.setLabelTplId(DataParser.parse(String.class, r.getValue(AssetLabelMeta.LABEL_TPL_ID)));
			this.setLabelTableMargin(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.LABEL_TABLE_MARGIN)));
			this.setLabelLayout(DataParser.parse(String.class, r.getValue(AssetLabelMeta.LABEL_LAYOUT)));
			this.setLabelWidth(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.LABEL_WIDTH)));
			this.setLabelTableMarginLeft(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.LABEL_TABLE_MARGIN_LEFT)));
			this.setLabelValueFontSize(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.LABEL_VALUE_FONT_SIZE)));
			this.setImageMarginBottom(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.IMAGE_MARGIN_BOTTOM)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetLabelMeta.UPDATE_BY)));
			this.setImageMarginTop(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.IMAGE_MARGIN_TOP)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetLabelMeta.ID)));
			this.setFontPath(DataParser.parse(String.class, r.getValue(AssetLabelMeta.FONT_PATH)));
			this.setImageWidth(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.IMAGE_WIDTH)));
			this.setFontType(DataParser.parse(String.class, r.getValue(AssetLabelMeta.FONT_TYPE)));
			this.setLabelTableMarginRight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.LABEL_TABLE_MARGIN_RIGHT)));
			this.setImageContainHeight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.IMAGE_CONTAIN_HEIGHT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetLabelMeta.UPDATE_TIME)));
			this.setImageMarginRight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.IMAGE_MARGIN_RIGHT)));
			this.setLabelHeight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.LABEL_HEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetLabelMeta.VERSION)));
			this.setImageHeight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.IMAGE_HEIGHT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetLabelMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetLabelMeta.DELETED)));
			this.setLabelKeyFontSize(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.LABEL_KEY_FONT_SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetLabelMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetLabelMeta.DELETE_TIME)));
			this.setLabelTableMarginTop(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.LABEL_TABLE_MARGIN_TOP)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetLabelMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetLabelMeta.DELETE_BY)));
			this.setLabelTableMarginBottom(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelMeta.LABEL_TABLE_MARGIN_BOTTOM)));
			return true;
		} else {
			try {
				this.setImageMarginLeft( (BigDecimal)r.getValue(AssetLabelMeta.IMAGE_MARGIN_LEFT));
				this.setCode( (String)r.getValue(AssetLabelMeta.CODE));
				this.setLabelKeyWidth( (BigDecimal)r.getValue(AssetLabelMeta.LABEL_KEY_WIDTH));
				this.setPaperTypeId( (String)r.getValue(AssetLabelMeta.PAPER_TYPE_ID));
				this.setLabelTplId( (String)r.getValue(AssetLabelMeta.LABEL_TPL_ID));
				this.setLabelTableMargin( (BigDecimal)r.getValue(AssetLabelMeta.LABEL_TABLE_MARGIN));
				this.setLabelLayout( (String)r.getValue(AssetLabelMeta.LABEL_LAYOUT));
				this.setLabelWidth( (BigDecimal)r.getValue(AssetLabelMeta.LABEL_WIDTH));
				this.setLabelTableMarginLeft( (BigDecimal)r.getValue(AssetLabelMeta.LABEL_TABLE_MARGIN_LEFT));
				this.setLabelValueFontSize( (BigDecimal)r.getValue(AssetLabelMeta.LABEL_VALUE_FONT_SIZE));
				this.setImageMarginBottom( (BigDecimal)r.getValue(AssetLabelMeta.IMAGE_MARGIN_BOTTOM));
				this.setUpdateBy( (String)r.getValue(AssetLabelMeta.UPDATE_BY));
				this.setImageMarginTop( (BigDecimal)r.getValue(AssetLabelMeta.IMAGE_MARGIN_TOP));
				this.setId( (String)r.getValue(AssetLabelMeta.ID));
				this.setFontPath( (String)r.getValue(AssetLabelMeta.FONT_PATH));
				this.setImageWidth( (BigDecimal)r.getValue(AssetLabelMeta.IMAGE_WIDTH));
				this.setFontType( (String)r.getValue(AssetLabelMeta.FONT_TYPE));
				this.setLabelTableMarginRight( (BigDecimal)r.getValue(AssetLabelMeta.LABEL_TABLE_MARGIN_RIGHT));
				this.setImageContainHeight( (BigDecimal)r.getValue(AssetLabelMeta.IMAGE_CONTAIN_HEIGHT));
				this.setUpdateTime( (Date)r.getValue(AssetLabelMeta.UPDATE_TIME));
				this.setImageMarginRight( (BigDecimal)r.getValue(AssetLabelMeta.IMAGE_MARGIN_RIGHT));
				this.setLabelHeight( (BigDecimal)r.getValue(AssetLabelMeta.LABEL_HEIGHT));
				this.setVersion( (Integer)r.getValue(AssetLabelMeta.VERSION));
				this.setImageHeight( (BigDecimal)r.getValue(AssetLabelMeta.IMAGE_HEIGHT));
				this.setCreateBy( (String)r.getValue(AssetLabelMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetLabelMeta.DELETED));
				this.setLabelKeyFontSize( (BigDecimal)r.getValue(AssetLabelMeta.LABEL_KEY_FONT_SIZE));
				this.setCreateTime( (Date)r.getValue(AssetLabelMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetLabelMeta.DELETE_TIME));
				this.setLabelTableMarginTop( (BigDecimal)r.getValue(AssetLabelMeta.LABEL_TABLE_MARGIN_TOP));
				this.setTenantId( (String)r.getValue(AssetLabelMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetLabelMeta.DELETE_BY));
				this.setLabelTableMarginBottom( (BigDecimal)r.getValue(AssetLabelMeta.LABEL_TABLE_MARGIN_BOTTOM));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}