package com.dt.platform.domain.eam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import com.github.foxnic.api.model.CompositeParameter;
import javax.persistence.Transient;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.dao.entity.EntityContext;
import com.github.foxnic.dao.entity.Entity;
import java.util.Map;
import com.dt.platform.domain.eam.meta.AssetLabelVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产标签VO类型
 * <p>资产标签 , 数据表 eam_asset_label 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-07 09:48:43
 * @sign FBF616F005186112710DC3B1B46F1F4B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产标签VO类型 ; 资产标签 , 数据表 eam_asset_label 的通用VO类型" , parent = AssetLabel.class)
public class AssetLabelVO extends AssetLabel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 页码
	*/
	@ApiModelProperty(required = false,value="页码" , notes = "")
	private Integer pageIndex;
	
	/**
	 * 分页大小
	*/
	@ApiModelProperty(required = false,value="分页大小" , notes = "")
	private Integer pageSize;
	
	/**
	 * 搜索字段
	*/
	@ApiModelProperty(required = false,value="搜索字段" , notes = "")
	private String searchField;
	
	/**
	 * 模糊搜索字段
	*/
	@ApiModelProperty(required = false,value="模糊搜索字段" , notes = "")
	private String fuzzyField;
	
	/**
	 * 搜索的值
	*/
	@ApiModelProperty(required = false,value="搜索的值" , notes = "")
	private String searchValue;
	
	/**
	 * 已修改字段
	*/
	@ApiModelProperty(required = false,value="已修改字段" , notes = "")
	private List<String> dirtyFields;
	
	/**
	 * 排序字段
	*/
	@ApiModelProperty(required = false,value="排序字段" , notes = "")
	private String sortField;
	
	/**
	 * 排序方式
	*/
	@ApiModelProperty(required = false,value="排序方式" , notes = "")
	private String sortType;
	
	/**
	 * 主键清单：用于接收批量主键参数
	*/
	@ApiModelProperty(required = false,value="主键清单" , notes = "用于接收批量主键参数")
	private List<String> ids;
	
	/**
	 * 获得 页码<br>
	 * @return 页码
	*/
	public Integer getPageIndex() {
		return pageIndex;
	}
	
	/**
	 * 设置 页码
	 * @param pageIndex 页码
	 * @return 当前对象
	*/
	public AssetLabelVO setPageIndex(Integer pageIndex) {
		this.pageIndex=pageIndex;
		return this;
	}
	
	/**
	 * 获得 分页大小<br>
	 * @return 分页大小
	*/
	public Integer getPageSize() {
		return pageSize;
	}
	
	/**
	 * 设置 分页大小
	 * @param pageSize 分页大小
	 * @return 当前对象
	*/
	public AssetLabelVO setPageSize(Integer pageSize) {
		this.pageSize=pageSize;
		return this;
	}
	
	/**
	 * 获得 搜索字段<br>
	 * @return 搜索字段
	*/
	public String getSearchField() {
		return searchField;
	}
	
	/**
	 * 设置 搜索字段
	 * @param searchField 搜索字段
	 * @return 当前对象
	*/
	public AssetLabelVO setSearchField(String searchField) {
		this.searchField=searchField;
		return this;
	}
	
	/**
	 * 获得 模糊搜索字段<br>
	 * @return 模糊搜索字段
	*/
	public String getFuzzyField() {
		return fuzzyField;
	}
	
	/**
	 * 设置 模糊搜索字段
	 * @param fuzzyField 模糊搜索字段
	 * @return 当前对象
	*/
	public AssetLabelVO setFuzzyField(String fuzzyField) {
		this.fuzzyField=fuzzyField;
		return this;
	}
	
	/**
	 * 获得 搜索的值<br>
	 * @return 搜索的值
	*/
	public String getSearchValue() {
		return searchValue;
	}
	
	/**
	 * 设置 搜索的值
	 * @param searchValue 搜索的值
	 * @return 当前对象
	*/
	public AssetLabelVO setSearchValue(String searchValue) {
		this.searchValue=searchValue;
		return this;
	}
	
	/**
	 * 获得 已修改字段<br>
	 * @return 已修改字段
	*/
	public List<String> getDirtyFields() {
		return dirtyFields;
	}
	
	/**
	 * 设置 已修改字段
	 * @param dirtyFields 已修改字段
	 * @return 当前对象
	*/
	public AssetLabelVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetLabelVO addDirtyField(String... dirtyField) {
		if(this.dirtyFields==null) dirtyFields=new ArrayList<>();
		this.dirtyFields.addAll(Arrays.asList(dirtyField));
		return this;
	}
	
	/**
	 * 获得 排序字段<br>
	 * @return 排序字段
	*/
	public String getSortField() {
		return sortField;
	}
	
	/**
	 * 设置 排序字段
	 * @param sortField 排序字段
	 * @return 当前对象
	*/
	public AssetLabelVO setSortField(String sortField) {
		this.sortField=sortField;
		return this;
	}
	
	/**
	 * 获得 排序方式<br>
	 * @return 排序方式
	*/
	public String getSortType() {
		return sortType;
	}
	
	/**
	 * 设置 排序方式
	 * @param sortType 排序方式
	 * @return 当前对象
	*/
	public AssetLabelVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 主键清单<br>
	 * 用于接收批量主键参数
	 * @return 主键清单
	*/
	public List<String> getIds() {
		return ids;
	}
	
	/**
	 * 设置 主键清单
	 * @param ids 主键清单
	 * @return 当前对象
	*/
	public AssetLabelVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetLabelVO addId(String... id) {
		if(this.ids==null) ids=new ArrayList<>();
		this.ids.addAll(Arrays.asList(id));
		return this;
	}
	@Transient
	private transient CompositeParameter $compositeParameter;
	/**
	 * 获得解析后的复合查询参数
	 */
	@Transient
	public CompositeParameter getCompositeParameter() {
		if($compositeParameter!=null) return  $compositeParameter;
		$compositeParameter=new CompositeParameter(this.getSearchValue(),BeanUtil.toMap(this));
		return  $compositeParameter;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetLabelVO , 转换好的 AssetLabelVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetLabelVO , 转换好的 PoJo 对象
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
	public AssetLabelVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetLabelVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetLabelVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetLabelVOMeta.$$proxy$$();
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
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setAssetPaper(this.getAssetPaper());
			inst.setPageSize(this.getPageSize());
			inst.setIds(this.getIds());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetLabelVO clone(boolean deep) {
		return EntityContext.clone(AssetLabelVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetLabelVO
	 * @param assetLabelMap 包含实体信息的 Map 对象
	 * @return AssetLabelVO , 转换好的的 AssetLabel 对象
	*/
	@Transient
	public static AssetLabelVO createFrom(Map<String,Object> assetLabelMap) {
		if(assetLabelMap==null) return null;
		AssetLabelVO vo = create();
		EntityContext.copyProperties(vo,assetLabelMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetLabelVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetLabelVO , 转换好的的 AssetLabel 对象
	*/
	@Transient
	public static AssetLabelVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetLabelVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetLabelVO，等同于 new
	 * @return AssetLabelVO 对象
	*/
	@Transient
	public static AssetLabelVO create() {
		return new com.dt.platform.domain.eam.meta.AssetLabelVOMeta.$$proxy$$();
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
			this.setImageMarginLeft(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.IMAGE_MARGIN_LEFT)));
			this.setCode(DataParser.parse(String.class, map.get(AssetLabelVOMeta.CODE)));
			this.setLabelKeyWidth(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.LABEL_KEY_WIDTH)));
			this.setPaperTypeId(DataParser.parse(String.class, map.get(AssetLabelVOMeta.PAPER_TYPE_ID)));
			this.setLabelTplId(DataParser.parse(String.class, map.get(AssetLabelVOMeta.LABEL_TPL_ID)));
			this.setLabelTableMargin(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.LABEL_TABLE_MARGIN)));
			this.setLabelLayout(DataParser.parse(String.class, map.get(AssetLabelVOMeta.LABEL_LAYOUT)));
			this.setLabelWidth(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.LABEL_WIDTH)));
			this.setLabelTableMarginLeft(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.LABEL_TABLE_MARGIN_LEFT)));
			this.setLabelValueFontSize(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.LABEL_VALUE_FONT_SIZE)));
			this.setImageMarginBottom(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.IMAGE_MARGIN_BOTTOM)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetLabelVOMeta.UPDATE_BY)));
			this.setImageMarginTop(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.IMAGE_MARGIN_TOP)));
			this.setId(DataParser.parse(String.class, map.get(AssetLabelVOMeta.ID)));
			this.setFontPath(DataParser.parse(String.class, map.get(AssetLabelVOMeta.FONT_PATH)));
			this.setImageWidth(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.IMAGE_WIDTH)));
			this.setFontType(DataParser.parse(String.class, map.get(AssetLabelVOMeta.FONT_TYPE)));
			this.setLabelTableMarginRight(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.LABEL_TABLE_MARGIN_RIGHT)));
			this.setImageContainHeight(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.IMAGE_CONTAIN_HEIGHT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetLabelVOMeta.UPDATE_TIME)));
			this.setImageMarginRight(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.IMAGE_MARGIN_RIGHT)));
			this.setLabelHeight(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.LABEL_HEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetLabelVOMeta.VERSION)));
			this.setImageHeight(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.IMAGE_HEIGHT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetLabelVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetLabelVOMeta.DELETED)));
			this.setLabelKeyFontSize(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.LABEL_KEY_FONT_SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetLabelVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetLabelVOMeta.DELETE_TIME)));
			this.setLabelTableMarginTop(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.LABEL_TABLE_MARGIN_TOP)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetLabelVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetLabelVOMeta.DELETE_BY)));
			this.setLabelTableMarginBottom(DataParser.parse(BigDecimal.class, map.get(AssetLabelVOMeta.LABEL_TABLE_MARGIN_BOTTOM)));
			// others
			this.setAssetTpl(DataParser.parse(AssetLabelTpl.class, map.get(AssetLabelVOMeta.ASSET_TPL)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssetLabelVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetLabelVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetLabelVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetLabelVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetLabelVOMeta.SORT_FIELD)));
			this.setAssetPaper(DataParser.parse(AssetLabelPaper.class, map.get(AssetLabelVOMeta.ASSET_PAPER)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetLabelVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetLabelVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setImageMarginLeft( (BigDecimal)map.get(AssetLabelVOMeta.IMAGE_MARGIN_LEFT));
				this.setCode( (String)map.get(AssetLabelVOMeta.CODE));
				this.setLabelKeyWidth( (BigDecimal)map.get(AssetLabelVOMeta.LABEL_KEY_WIDTH));
				this.setPaperTypeId( (String)map.get(AssetLabelVOMeta.PAPER_TYPE_ID));
				this.setLabelTplId( (String)map.get(AssetLabelVOMeta.LABEL_TPL_ID));
				this.setLabelTableMargin( (BigDecimal)map.get(AssetLabelVOMeta.LABEL_TABLE_MARGIN));
				this.setLabelLayout( (String)map.get(AssetLabelVOMeta.LABEL_LAYOUT));
				this.setLabelWidth( (BigDecimal)map.get(AssetLabelVOMeta.LABEL_WIDTH));
				this.setLabelTableMarginLeft( (BigDecimal)map.get(AssetLabelVOMeta.LABEL_TABLE_MARGIN_LEFT));
				this.setLabelValueFontSize( (BigDecimal)map.get(AssetLabelVOMeta.LABEL_VALUE_FONT_SIZE));
				this.setImageMarginBottom( (BigDecimal)map.get(AssetLabelVOMeta.IMAGE_MARGIN_BOTTOM));
				this.setUpdateBy( (String)map.get(AssetLabelVOMeta.UPDATE_BY));
				this.setImageMarginTop( (BigDecimal)map.get(AssetLabelVOMeta.IMAGE_MARGIN_TOP));
				this.setId( (String)map.get(AssetLabelVOMeta.ID));
				this.setFontPath( (String)map.get(AssetLabelVOMeta.FONT_PATH));
				this.setImageWidth( (BigDecimal)map.get(AssetLabelVOMeta.IMAGE_WIDTH));
				this.setFontType( (String)map.get(AssetLabelVOMeta.FONT_TYPE));
				this.setLabelTableMarginRight( (BigDecimal)map.get(AssetLabelVOMeta.LABEL_TABLE_MARGIN_RIGHT));
				this.setImageContainHeight( (BigDecimal)map.get(AssetLabelVOMeta.IMAGE_CONTAIN_HEIGHT));
				this.setUpdateTime( (Date)map.get(AssetLabelVOMeta.UPDATE_TIME));
				this.setImageMarginRight( (BigDecimal)map.get(AssetLabelVOMeta.IMAGE_MARGIN_RIGHT));
				this.setLabelHeight( (BigDecimal)map.get(AssetLabelVOMeta.LABEL_HEIGHT));
				this.setVersion( (Integer)map.get(AssetLabelVOMeta.VERSION));
				this.setImageHeight( (BigDecimal)map.get(AssetLabelVOMeta.IMAGE_HEIGHT));
				this.setCreateBy( (String)map.get(AssetLabelVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetLabelVOMeta.DELETED));
				this.setLabelKeyFontSize( (BigDecimal)map.get(AssetLabelVOMeta.LABEL_KEY_FONT_SIZE));
				this.setCreateTime( (Date)map.get(AssetLabelVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetLabelVOMeta.DELETE_TIME));
				this.setLabelTableMarginTop( (BigDecimal)map.get(AssetLabelVOMeta.LABEL_TABLE_MARGIN_TOP));
				this.setTenantId( (String)map.get(AssetLabelVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetLabelVOMeta.DELETE_BY));
				this.setLabelTableMarginBottom( (BigDecimal)map.get(AssetLabelVOMeta.LABEL_TABLE_MARGIN_BOTTOM));
				// others
				this.setAssetTpl( (AssetLabelTpl)map.get(AssetLabelVOMeta.ASSET_TPL));
				this.setSearchField( (String)map.get(AssetLabelVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(AssetLabelVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetLabelVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(AssetLabelVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(AssetLabelVOMeta.SORT_FIELD));
				this.setAssetPaper( (AssetLabelPaper)map.get(AssetLabelVOMeta.ASSET_PAPER));
				this.setPageSize( (Integer)map.get(AssetLabelVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(AssetLabelVOMeta.SEARCH_VALUE));
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
			this.setImageMarginLeft(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.IMAGE_MARGIN_LEFT)));
			this.setCode(DataParser.parse(String.class, r.getValue(AssetLabelVOMeta.CODE)));
			this.setLabelKeyWidth(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.LABEL_KEY_WIDTH)));
			this.setPaperTypeId(DataParser.parse(String.class, r.getValue(AssetLabelVOMeta.PAPER_TYPE_ID)));
			this.setLabelTplId(DataParser.parse(String.class, r.getValue(AssetLabelVOMeta.LABEL_TPL_ID)));
			this.setLabelTableMargin(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.LABEL_TABLE_MARGIN)));
			this.setLabelLayout(DataParser.parse(String.class, r.getValue(AssetLabelVOMeta.LABEL_LAYOUT)));
			this.setLabelWidth(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.LABEL_WIDTH)));
			this.setLabelTableMarginLeft(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.LABEL_TABLE_MARGIN_LEFT)));
			this.setLabelValueFontSize(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.LABEL_VALUE_FONT_SIZE)));
			this.setImageMarginBottom(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.IMAGE_MARGIN_BOTTOM)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetLabelVOMeta.UPDATE_BY)));
			this.setImageMarginTop(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.IMAGE_MARGIN_TOP)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetLabelVOMeta.ID)));
			this.setFontPath(DataParser.parse(String.class, r.getValue(AssetLabelVOMeta.FONT_PATH)));
			this.setImageWidth(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.IMAGE_WIDTH)));
			this.setFontType(DataParser.parse(String.class, r.getValue(AssetLabelVOMeta.FONT_TYPE)));
			this.setLabelTableMarginRight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.LABEL_TABLE_MARGIN_RIGHT)));
			this.setImageContainHeight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.IMAGE_CONTAIN_HEIGHT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetLabelVOMeta.UPDATE_TIME)));
			this.setImageMarginRight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.IMAGE_MARGIN_RIGHT)));
			this.setLabelHeight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.LABEL_HEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetLabelVOMeta.VERSION)));
			this.setImageHeight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.IMAGE_HEIGHT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetLabelVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetLabelVOMeta.DELETED)));
			this.setLabelKeyFontSize(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.LABEL_KEY_FONT_SIZE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetLabelVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetLabelVOMeta.DELETE_TIME)));
			this.setLabelTableMarginTop(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.LABEL_TABLE_MARGIN_TOP)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetLabelVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetLabelVOMeta.DELETE_BY)));
			this.setLabelTableMarginBottom(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelVOMeta.LABEL_TABLE_MARGIN_BOTTOM)));
			return true;
		} else {
			try {
				this.setImageMarginLeft( (BigDecimal)r.getValue(AssetLabelVOMeta.IMAGE_MARGIN_LEFT));
				this.setCode( (String)r.getValue(AssetLabelVOMeta.CODE));
				this.setLabelKeyWidth( (BigDecimal)r.getValue(AssetLabelVOMeta.LABEL_KEY_WIDTH));
				this.setPaperTypeId( (String)r.getValue(AssetLabelVOMeta.PAPER_TYPE_ID));
				this.setLabelTplId( (String)r.getValue(AssetLabelVOMeta.LABEL_TPL_ID));
				this.setLabelTableMargin( (BigDecimal)r.getValue(AssetLabelVOMeta.LABEL_TABLE_MARGIN));
				this.setLabelLayout( (String)r.getValue(AssetLabelVOMeta.LABEL_LAYOUT));
				this.setLabelWidth( (BigDecimal)r.getValue(AssetLabelVOMeta.LABEL_WIDTH));
				this.setLabelTableMarginLeft( (BigDecimal)r.getValue(AssetLabelVOMeta.LABEL_TABLE_MARGIN_LEFT));
				this.setLabelValueFontSize( (BigDecimal)r.getValue(AssetLabelVOMeta.LABEL_VALUE_FONT_SIZE));
				this.setImageMarginBottom( (BigDecimal)r.getValue(AssetLabelVOMeta.IMAGE_MARGIN_BOTTOM));
				this.setUpdateBy( (String)r.getValue(AssetLabelVOMeta.UPDATE_BY));
				this.setImageMarginTop( (BigDecimal)r.getValue(AssetLabelVOMeta.IMAGE_MARGIN_TOP));
				this.setId( (String)r.getValue(AssetLabelVOMeta.ID));
				this.setFontPath( (String)r.getValue(AssetLabelVOMeta.FONT_PATH));
				this.setImageWidth( (BigDecimal)r.getValue(AssetLabelVOMeta.IMAGE_WIDTH));
				this.setFontType( (String)r.getValue(AssetLabelVOMeta.FONT_TYPE));
				this.setLabelTableMarginRight( (BigDecimal)r.getValue(AssetLabelVOMeta.LABEL_TABLE_MARGIN_RIGHT));
				this.setImageContainHeight( (BigDecimal)r.getValue(AssetLabelVOMeta.IMAGE_CONTAIN_HEIGHT));
				this.setUpdateTime( (Date)r.getValue(AssetLabelVOMeta.UPDATE_TIME));
				this.setImageMarginRight( (BigDecimal)r.getValue(AssetLabelVOMeta.IMAGE_MARGIN_RIGHT));
				this.setLabelHeight( (BigDecimal)r.getValue(AssetLabelVOMeta.LABEL_HEIGHT));
				this.setVersion( (Integer)r.getValue(AssetLabelVOMeta.VERSION));
				this.setImageHeight( (BigDecimal)r.getValue(AssetLabelVOMeta.IMAGE_HEIGHT));
				this.setCreateBy( (String)r.getValue(AssetLabelVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetLabelVOMeta.DELETED));
				this.setLabelKeyFontSize( (BigDecimal)r.getValue(AssetLabelVOMeta.LABEL_KEY_FONT_SIZE));
				this.setCreateTime( (Date)r.getValue(AssetLabelVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetLabelVOMeta.DELETE_TIME));
				this.setLabelTableMarginTop( (BigDecimal)r.getValue(AssetLabelVOMeta.LABEL_TABLE_MARGIN_TOP));
				this.setTenantId( (String)r.getValue(AssetLabelVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetLabelVOMeta.DELETE_BY));
				this.setLabelTableMarginBottom( (BigDecimal)r.getValue(AssetLabelVOMeta.LABEL_TABLE_MARGIN_BOTTOM));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}