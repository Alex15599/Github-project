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
import com.dt.platform.domain.eam.meta.AssetLabelTplVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 标签模版VO类型
 * <p>标签模版 , 数据表 eam_asset_label_tpl 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-18 12:30:46
 * @sign F5A6822B6B9E651BA3A472F6A2A8ECB5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "标签模版VO类型 ; 标签模版 , 数据表 eam_asset_label_tpl 的通用VO类型" , parent = AssetLabelTpl.class)
public class AssetLabelTplVO extends AssetLabelTpl {

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
	 * 数据来源：前端指定不同的来源，后端按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
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
	public AssetLabelTplVO setPageIndex(Integer pageIndex) {
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
	public AssetLabelTplVO setPageSize(Integer pageSize) {
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
	public AssetLabelTplVO setSearchField(String searchField) {
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
	public AssetLabelTplVO setFuzzyField(String fuzzyField) {
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
	public AssetLabelTplVO setSearchValue(String searchValue) {
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
	public AssetLabelTplVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetLabelTplVO addDirtyField(String... dirtyField) {
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
	public AssetLabelTplVO setSortField(String sortField) {
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
	public AssetLabelTplVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端按来源执行不同的逻辑
	 * @return 数据来源
	*/
	public String getDataOrigin() {
		return dataOrigin;
	}
	
	/**
	 * 设置 数据来源
	 * @param dataOrigin 数据来源
	 * @return 当前对象
	*/
	public AssetLabelTplVO setDataOrigin(String dataOrigin) {
		this.dataOrigin=dataOrigin;
		return this;
	}
	
	/**
	 * 获得 查询逻辑<br>
	 * 默认and，可指定 or 
	 * @return 查询逻辑
	*/
	public String getQueryLogic() {
		return queryLogic;
	}
	
	/**
	 * 设置 查询逻辑
	 * @param queryLogic 查询逻辑
	 * @return 当前对象
	*/
	public AssetLabelTplVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
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
	public AssetLabelTplVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetLabelTplVO addId(String... id) {
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
	 * @return AssetLabelTplVO , 转换好的 AssetLabelTplVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetLabelTplVO , 转换好的 PoJo 对象
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
	public AssetLabelTplVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetLabelTplVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetLabelTplVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetLabelTplVOMeta.$$proxy$$();
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
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setAssetLabelColumnlList(this.getAssetLabelColumnlList());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setAssetLabelItemList(this.getAssetLabelItemList());
			inst.setAssetLabelLayoutList(this.getAssetLabelLayoutList());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetLabelTplVO clone(boolean deep) {
		return EntityContext.clone(AssetLabelTplVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetLabelTplVO
	 * @param assetLabelTplMap 包含实体信息的 Map 对象
	 * @return AssetLabelTplVO , 转换好的的 AssetLabelTpl 对象
	*/
	@Transient
	public static AssetLabelTplVO createFrom(Map<String,Object> assetLabelTplMap) {
		if(assetLabelTplMap==null) return null;
		AssetLabelTplVO vo = create();
		EntityContext.copyProperties(vo,assetLabelTplMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetLabelTplVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetLabelTplVO , 转换好的的 AssetLabelTpl 对象
	*/
	@Transient
	public static AssetLabelTplVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetLabelTplVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetLabelTplVO，等同于 new
	 * @return AssetLabelTplVO 对象
	*/
	@Transient
	public static AssetLabelTplVO create() {
		return new com.dt.platform.domain.eam.meta.AssetLabelTplVOMeta.$$proxy$$();
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
			this.setImageMarginLeft(DataParser.parse(BigDecimal.class, map.get(AssetLabelTplVOMeta.IMAGE_MARGIN_LEFT)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.NOTES)));
			this.setLabelTableMarginLeft(DataParser.parse(BigDecimal.class, map.get(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_LEFT)));
			this.setType(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.TYPE)));
			this.setLabelFormatContent(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.LABEL_FORMAT_CONTENT)));
			this.setImageMarginBottom(DataParser.parse(BigDecimal.class, map.get(AssetLabelTplVOMeta.IMAGE_MARGIN_BOTTOM)));
			this.setImageColId(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.IMAGE_COL_ID)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.UPDATE_BY)));
			this.setImageMarginTop(DataParser.parse(BigDecimal.class, map.get(AssetLabelTplVOMeta.IMAGE_MARGIN_TOP)));
			this.setKeyBold(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.KEY_BOLD)));
			this.setId(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.ID)));
			this.setImageType(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.IMAGE_TYPE)));
			this.setImageShow(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.IMAGE_SHOW)));
			this.setImageWidth(DataParser.parse(BigDecimal.class, map.get(AssetLabelTplVOMeta.IMAGE_WIDTH)));
			this.setLabelTableMarginRight(DataParser.parse(BigDecimal.class, map.get(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_RIGHT)));
			this.setValueBlod(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.VALUE_BLOD)));
			this.setColIds(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.COL_IDS)));
			this.setImagePosition(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.IMAGE_POSITION)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetLabelTplVOMeta.UPDATE_TIME)));
			this.setImageMarginRight(DataParser.parse(BigDecimal.class, map.get(AssetLabelTplVOMeta.IMAGE_MARGIN_RIGHT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetLabelTplVOMeta.VERSION)));
			this.setImageHeight(DataParser.parse(BigDecimal.class, map.get(AssetLabelTplVOMeta.IMAGE_HEIGHT)));
			this.setImageLabelShow(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.IMAGE_LABEL_SHOW)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetLabelTplVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetLabelTplVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetLabelTplVOMeta.DELETE_TIME)));
			this.setLabelTableMarginTop(DataParser.parse(BigDecimal.class, map.get(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_TOP)));
			this.setIsCustom(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.IS_CUSTOM)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.DELETE_BY)));
			this.setLabelTableMarginBottom(DataParser.parse(BigDecimal.class, map.get(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_BOTTOM)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetLabelTplVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetLabelTplVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetLabelTplVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setImageMarginLeft( (BigDecimal)map.get(AssetLabelTplVOMeta.IMAGE_MARGIN_LEFT));
				this.setNotes( (String)map.get(AssetLabelTplVOMeta.NOTES));
				this.setLabelTableMarginLeft( (BigDecimal)map.get(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_LEFT));
				this.setType( (String)map.get(AssetLabelTplVOMeta.TYPE));
				this.setLabelFormatContent( (String)map.get(AssetLabelTplVOMeta.LABEL_FORMAT_CONTENT));
				this.setImageMarginBottom( (BigDecimal)map.get(AssetLabelTplVOMeta.IMAGE_MARGIN_BOTTOM));
				this.setImageColId( (String)map.get(AssetLabelTplVOMeta.IMAGE_COL_ID));
				this.setUpdateBy( (String)map.get(AssetLabelTplVOMeta.UPDATE_BY));
				this.setImageMarginTop( (BigDecimal)map.get(AssetLabelTplVOMeta.IMAGE_MARGIN_TOP));
				this.setKeyBold( (String)map.get(AssetLabelTplVOMeta.KEY_BOLD));
				this.setId( (String)map.get(AssetLabelTplVOMeta.ID));
				this.setImageType( (String)map.get(AssetLabelTplVOMeta.IMAGE_TYPE));
				this.setImageShow( (String)map.get(AssetLabelTplVOMeta.IMAGE_SHOW));
				this.setImageWidth( (BigDecimal)map.get(AssetLabelTplVOMeta.IMAGE_WIDTH));
				this.setLabelTableMarginRight( (BigDecimal)map.get(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_RIGHT));
				this.setValueBlod( (String)map.get(AssetLabelTplVOMeta.VALUE_BLOD));
				this.setColIds( (String)map.get(AssetLabelTplVOMeta.COL_IDS));
				this.setImagePosition( (String)map.get(AssetLabelTplVOMeta.IMAGE_POSITION));
				this.setUpdateTime( (Date)map.get(AssetLabelTplVOMeta.UPDATE_TIME));
				this.setImageMarginRight( (BigDecimal)map.get(AssetLabelTplVOMeta.IMAGE_MARGIN_RIGHT));
				this.setVersion( (Integer)map.get(AssetLabelTplVOMeta.VERSION));
				this.setImageHeight( (BigDecimal)map.get(AssetLabelTplVOMeta.IMAGE_HEIGHT));
				this.setImageLabelShow( (String)map.get(AssetLabelTplVOMeta.IMAGE_LABEL_SHOW));
				this.setCreateBy( (String)map.get(AssetLabelTplVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetLabelTplVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetLabelTplVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetLabelTplVOMeta.DELETE_TIME));
				this.setLabelTableMarginTop( (BigDecimal)map.get(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_TOP));
				this.setIsCustom( (String)map.get(AssetLabelTplVOMeta.IS_CUSTOM));
				this.setTenantId( (String)map.get(AssetLabelTplVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetLabelTplVOMeta.DELETE_BY));
				this.setLabelTableMarginBottom( (BigDecimal)map.get(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_BOTTOM));
				// others
				this.setSearchField( (String)map.get(AssetLabelTplVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(AssetLabelTplVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetLabelTplVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(AssetLabelTplVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetLabelTplVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssetLabelTplVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssetLabelTplVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AssetLabelTplVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(AssetLabelTplVOMeta.SEARCH_VALUE));
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
			this.setImageMarginLeft(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelTplVOMeta.IMAGE_MARGIN_LEFT)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.NOTES)));
			this.setLabelTableMarginLeft(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_LEFT)));
			this.setType(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.TYPE)));
			this.setLabelFormatContent(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.LABEL_FORMAT_CONTENT)));
			this.setImageMarginBottom(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelTplVOMeta.IMAGE_MARGIN_BOTTOM)));
			this.setImageColId(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.IMAGE_COL_ID)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.UPDATE_BY)));
			this.setImageMarginTop(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelTplVOMeta.IMAGE_MARGIN_TOP)));
			this.setKeyBold(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.KEY_BOLD)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.ID)));
			this.setImageType(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.IMAGE_TYPE)));
			this.setImageShow(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.IMAGE_SHOW)));
			this.setImageWidth(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelTplVOMeta.IMAGE_WIDTH)));
			this.setLabelTableMarginRight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_RIGHT)));
			this.setValueBlod(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.VALUE_BLOD)));
			this.setColIds(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.COL_IDS)));
			this.setImagePosition(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.IMAGE_POSITION)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetLabelTplVOMeta.UPDATE_TIME)));
			this.setImageMarginRight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelTplVOMeta.IMAGE_MARGIN_RIGHT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetLabelTplVOMeta.VERSION)));
			this.setImageHeight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelTplVOMeta.IMAGE_HEIGHT)));
			this.setImageLabelShow(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.IMAGE_LABEL_SHOW)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetLabelTplVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetLabelTplVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetLabelTplVOMeta.DELETE_TIME)));
			this.setLabelTableMarginTop(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_TOP)));
			this.setIsCustom(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.IS_CUSTOM)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetLabelTplVOMeta.DELETE_BY)));
			this.setLabelTableMarginBottom(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_BOTTOM)));
			return true;
		} else {
			try {
				this.setImageMarginLeft( (BigDecimal)r.getValue(AssetLabelTplVOMeta.IMAGE_MARGIN_LEFT));
				this.setNotes( (String)r.getValue(AssetLabelTplVOMeta.NOTES));
				this.setLabelTableMarginLeft( (BigDecimal)r.getValue(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_LEFT));
				this.setType( (String)r.getValue(AssetLabelTplVOMeta.TYPE));
				this.setLabelFormatContent( (String)r.getValue(AssetLabelTplVOMeta.LABEL_FORMAT_CONTENT));
				this.setImageMarginBottom( (BigDecimal)r.getValue(AssetLabelTplVOMeta.IMAGE_MARGIN_BOTTOM));
				this.setImageColId( (String)r.getValue(AssetLabelTplVOMeta.IMAGE_COL_ID));
				this.setUpdateBy( (String)r.getValue(AssetLabelTplVOMeta.UPDATE_BY));
				this.setImageMarginTop( (BigDecimal)r.getValue(AssetLabelTplVOMeta.IMAGE_MARGIN_TOP));
				this.setKeyBold( (String)r.getValue(AssetLabelTplVOMeta.KEY_BOLD));
				this.setId( (String)r.getValue(AssetLabelTplVOMeta.ID));
				this.setImageType( (String)r.getValue(AssetLabelTplVOMeta.IMAGE_TYPE));
				this.setImageShow( (String)r.getValue(AssetLabelTplVOMeta.IMAGE_SHOW));
				this.setImageWidth( (BigDecimal)r.getValue(AssetLabelTplVOMeta.IMAGE_WIDTH));
				this.setLabelTableMarginRight( (BigDecimal)r.getValue(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_RIGHT));
				this.setValueBlod( (String)r.getValue(AssetLabelTplVOMeta.VALUE_BLOD));
				this.setColIds( (String)r.getValue(AssetLabelTplVOMeta.COL_IDS));
				this.setImagePosition( (String)r.getValue(AssetLabelTplVOMeta.IMAGE_POSITION));
				this.setUpdateTime( (Date)r.getValue(AssetLabelTplVOMeta.UPDATE_TIME));
				this.setImageMarginRight( (BigDecimal)r.getValue(AssetLabelTplVOMeta.IMAGE_MARGIN_RIGHT));
				this.setVersion( (Integer)r.getValue(AssetLabelTplVOMeta.VERSION));
				this.setImageHeight( (BigDecimal)r.getValue(AssetLabelTplVOMeta.IMAGE_HEIGHT));
				this.setImageLabelShow( (String)r.getValue(AssetLabelTplVOMeta.IMAGE_LABEL_SHOW));
				this.setCreateBy( (String)r.getValue(AssetLabelTplVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetLabelTplVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetLabelTplVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetLabelTplVOMeta.DELETE_TIME));
				this.setLabelTableMarginTop( (BigDecimal)r.getValue(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_TOP));
				this.setIsCustom( (String)r.getValue(AssetLabelTplVOMeta.IS_CUSTOM));
				this.setTenantId( (String)r.getValue(AssetLabelTplVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetLabelTplVOMeta.DELETE_BY));
				this.setLabelTableMarginBottom( (BigDecimal)r.getValue(AssetLabelTplVOMeta.LABEL_TABLE_MARGIN_BOTTOM));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}