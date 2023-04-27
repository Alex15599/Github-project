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
import com.dt.platform.domain.eam.meta.AssetAttributeItemVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产字段配置项VO类型
 * <p>资产字段配置项 , 数据表 eam_asset_attribute_item 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-28 17:53:45
 * @sign 85325CEF894AB6E021D32EDCCE49F093
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产字段配置项VO类型 ; 资产字段配置项 , 数据表 eam_asset_attribute_item 的通用VO类型" , parent = AssetAttributeItem.class)
public class AssetAttributeItemVO extends AssetAttributeItem {

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
	public AssetAttributeItemVO setPageIndex(Integer pageIndex) {
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
	public AssetAttributeItemVO setPageSize(Integer pageSize) {
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
	public AssetAttributeItemVO setSearchField(String searchField) {
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
	public AssetAttributeItemVO setFuzzyField(String fuzzyField) {
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
	public AssetAttributeItemVO setSearchValue(String searchValue) {
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
	public AssetAttributeItemVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetAttributeItemVO addDirtyField(String... dirtyField) {
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
	public AssetAttributeItemVO setSortField(String sortField) {
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
	public AssetAttributeItemVO setSortType(String sortType) {
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
	public AssetAttributeItemVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetAttributeItemVO addId(String... id) {
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
	 * @return AssetAttributeItemVO , 转换好的 AssetAttributeItemVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetAttributeItemVO , 转换好的 PoJo 对象
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
	public AssetAttributeItemVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetAttributeItemVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetAttributeItemVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetAttributeItemVOMeta.$$proxy$$();
		inst.setLayoutRow(this.getLayoutRow());
		inst.setNotes(this.getNotes());
		inst.setOwnerCode(this.getOwnerCode());
		inst.setListSort(this.getListSort());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setListContent(this.getListContent());
		inst.setVersion(this.getVersion());
		inst.setRequired(this.getRequired());
		inst.setListShow(this.getListShow());
		inst.setAttributeId(this.getAttributeId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setLayoutType(this.getLayoutType());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setFormShow(this.getFormShow());
		inst.setId(this.getId());
		inst.setLayoutColumn(this.getLayoutColumn());
		inst.setDimension(this.getDimension());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setPageSize(this.getPageSize());
			inst.setIds(this.getIds());
			inst.setAttribute(this.getAttribute());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetAttributeItemVO clone(boolean deep) {
		return EntityContext.clone(AssetAttributeItemVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetAttributeItemVO
	 * @param assetAttributeItemMap 包含实体信息的 Map 对象
	 * @return AssetAttributeItemVO , 转换好的的 AssetAttributeItem 对象
	*/
	@Transient
	public static AssetAttributeItemVO createFrom(Map<String,Object> assetAttributeItemMap) {
		if(assetAttributeItemMap==null) return null;
		AssetAttributeItemVO vo = create();
		EntityContext.copyProperties(vo,assetAttributeItemMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetAttributeItemVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetAttributeItemVO , 转换好的的 AssetAttributeItem 对象
	*/
	@Transient
	public static AssetAttributeItemVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetAttributeItemVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetAttributeItemVO，等同于 new
	 * @return AssetAttributeItemVO 对象
	*/
	@Transient
	public static AssetAttributeItemVO create() {
		return new com.dt.platform.domain.eam.meta.AssetAttributeItemVOMeta.$$proxy$$();
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
			this.setLayoutRow(DataParser.parse(Integer.class, map.get(AssetAttributeItemVOMeta.LAYOUT_ROW)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.OWNER_CODE)));
			this.setListSort(DataParser.parse(Integer.class, map.get(AssetAttributeItemVOMeta.LIST_SORT)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetAttributeItemVOMeta.UPDATE_TIME)));
			this.setListContent(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.LIST_CONTENT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetAttributeItemVOMeta.VERSION)));
			this.setRequired(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.REQUIRED)));
			this.setListShow(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.LIST_SHOW)));
			this.setAttributeId(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.ATTRIBUTE_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetAttributeItemVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetAttributeItemVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetAttributeItemVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.TENANT_ID)));
			this.setLayoutType(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.LAYOUT_TYPE)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.DELETE_BY)));
			this.setFormShow(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.FORM_SHOW)));
			this.setId(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.ID)));
			this.setLayoutColumn(DataParser.parse(Integer.class, map.get(AssetAttributeItemVOMeta.LAYOUT_COLUMN)));
			this.setDimension(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.DIMENSION)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetAttributeItemVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetAttributeItemVOMeta.PAGE_SIZE)));
			this.setAttribute(DataParser.parse(AssetAttribute.class, map.get(AssetAttributeItemVOMeta.ATTRIBUTE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetAttributeItemVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setLayoutRow( (Integer)map.get(AssetAttributeItemVOMeta.LAYOUT_ROW));
				this.setNotes( (String)map.get(AssetAttributeItemVOMeta.NOTES));
				this.setOwnerCode( (String)map.get(AssetAttributeItemVOMeta.OWNER_CODE));
				this.setListSort( (Integer)map.get(AssetAttributeItemVOMeta.LIST_SORT));
				this.setUpdateTime( (Date)map.get(AssetAttributeItemVOMeta.UPDATE_TIME));
				this.setListContent( (String)map.get(AssetAttributeItemVOMeta.LIST_CONTENT));
				this.setVersion( (Integer)map.get(AssetAttributeItemVOMeta.VERSION));
				this.setRequired( (String)map.get(AssetAttributeItemVOMeta.REQUIRED));
				this.setListShow( (String)map.get(AssetAttributeItemVOMeta.LIST_SHOW));
				this.setAttributeId( (String)map.get(AssetAttributeItemVOMeta.ATTRIBUTE_ID));
				this.setCreateBy( (String)map.get(AssetAttributeItemVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetAttributeItemVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetAttributeItemVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetAttributeItemVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetAttributeItemVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(AssetAttributeItemVOMeta.TENANT_ID));
				this.setLayoutType( (String)map.get(AssetAttributeItemVOMeta.LAYOUT_TYPE));
				this.setDeleteBy( (String)map.get(AssetAttributeItemVOMeta.DELETE_BY));
				this.setFormShow( (String)map.get(AssetAttributeItemVOMeta.FORM_SHOW));
				this.setId( (String)map.get(AssetAttributeItemVOMeta.ID));
				this.setLayoutColumn( (Integer)map.get(AssetAttributeItemVOMeta.LAYOUT_COLUMN));
				this.setDimension( (String)map.get(AssetAttributeItemVOMeta.DIMENSION));
				// others
				this.setSearchField( (String)map.get(AssetAttributeItemVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(AssetAttributeItemVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetAttributeItemVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(AssetAttributeItemVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(AssetAttributeItemVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(AssetAttributeItemVOMeta.PAGE_SIZE));
				this.setAttribute( (AssetAttribute)map.get(AssetAttributeItemVOMeta.ATTRIBUTE));
				this.setSearchValue( (String)map.get(AssetAttributeItemVOMeta.SEARCH_VALUE));
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
			this.setLayoutRow(DataParser.parse(Integer.class, r.getValue(AssetAttributeItemVOMeta.LAYOUT_ROW)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.NOTES)));
			this.setOwnerCode(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.OWNER_CODE)));
			this.setListSort(DataParser.parse(Integer.class, r.getValue(AssetAttributeItemVOMeta.LIST_SORT)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetAttributeItemVOMeta.UPDATE_TIME)));
			this.setListContent(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.LIST_CONTENT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetAttributeItemVOMeta.VERSION)));
			this.setRequired(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.REQUIRED)));
			this.setListShow(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.LIST_SHOW)));
			this.setAttributeId(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.ATTRIBUTE_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetAttributeItemVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetAttributeItemVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetAttributeItemVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.TENANT_ID)));
			this.setLayoutType(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.LAYOUT_TYPE)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.DELETE_BY)));
			this.setFormShow(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.FORM_SHOW)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.ID)));
			this.setLayoutColumn(DataParser.parse(Integer.class, r.getValue(AssetAttributeItemVOMeta.LAYOUT_COLUMN)));
			this.setDimension(DataParser.parse(String.class, r.getValue(AssetAttributeItemVOMeta.DIMENSION)));
			return true;
		} else {
			try {
				this.setLayoutRow( (Integer)r.getValue(AssetAttributeItemVOMeta.LAYOUT_ROW));
				this.setNotes( (String)r.getValue(AssetAttributeItemVOMeta.NOTES));
				this.setOwnerCode( (String)r.getValue(AssetAttributeItemVOMeta.OWNER_CODE));
				this.setListSort( (Integer)r.getValue(AssetAttributeItemVOMeta.LIST_SORT));
				this.setUpdateTime( (Date)r.getValue(AssetAttributeItemVOMeta.UPDATE_TIME));
				this.setListContent( (String)r.getValue(AssetAttributeItemVOMeta.LIST_CONTENT));
				this.setVersion( (Integer)r.getValue(AssetAttributeItemVOMeta.VERSION));
				this.setRequired( (String)r.getValue(AssetAttributeItemVOMeta.REQUIRED));
				this.setListShow( (String)r.getValue(AssetAttributeItemVOMeta.LIST_SHOW));
				this.setAttributeId( (String)r.getValue(AssetAttributeItemVOMeta.ATTRIBUTE_ID));
				this.setCreateBy( (String)r.getValue(AssetAttributeItemVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetAttributeItemVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetAttributeItemVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetAttributeItemVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetAttributeItemVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(AssetAttributeItemVOMeta.TENANT_ID));
				this.setLayoutType( (String)r.getValue(AssetAttributeItemVOMeta.LAYOUT_TYPE));
				this.setDeleteBy( (String)r.getValue(AssetAttributeItemVOMeta.DELETE_BY));
				this.setFormShow( (String)r.getValue(AssetAttributeItemVOMeta.FORM_SHOW));
				this.setId( (String)r.getValue(AssetAttributeItemVOMeta.ID));
				this.setLayoutColumn( (Integer)r.getValue(AssetAttributeItemVOMeta.LAYOUT_COLUMN));
				this.setDimension( (String)r.getValue(AssetAttributeItemVOMeta.DIMENSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}