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
import com.dt.platform.domain.eam.meta.AssetDepreciationExcludeVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 折旧排除VO类型
 * <p>折旧排除 , 数据表 eam_asset_depreciation_exclude 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-28 20:42:05
 * @sign 64616605F89329150DB2B9E4F70204DD
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "折旧排除VO类型 ; 折旧排除 , 数据表 eam_asset_depreciation_exclude 的通用VO类型" , parent = AssetDepreciationExclude.class)
public class AssetDepreciationExcludeVO extends AssetDepreciationExclude {

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
	public AssetDepreciationExcludeVO setPageIndex(Integer pageIndex) {
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
	public AssetDepreciationExcludeVO setPageSize(Integer pageSize) {
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
	public AssetDepreciationExcludeVO setSearchField(String searchField) {
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
	public AssetDepreciationExcludeVO setFuzzyField(String fuzzyField) {
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
	public AssetDepreciationExcludeVO setSearchValue(String searchValue) {
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
	public AssetDepreciationExcludeVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetDepreciationExcludeVO addDirtyField(String... dirtyField) {
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
	public AssetDepreciationExcludeVO setSortField(String sortField) {
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
	public AssetDepreciationExcludeVO setSortType(String sortType) {
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
	public AssetDepreciationExcludeVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetDepreciationExcludeVO addId(String... id) {
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
	 * @return AssetDepreciationExcludeVO , 转换好的 AssetDepreciationExcludeVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDepreciationExcludeVO , 转换好的 PoJo 对象
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
	public AssetDepreciationExcludeVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetDepreciationExcludeVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetDepreciationExcludeVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetDepreciationExcludeVOMeta.$$proxy$$();
		inst.setDepreciationId(this.getDepreciationId());
		inst.setCreateBy(this.getCreateBy());
		inst.setNotes(this.getNotes());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		if(all) {
			inst.setAssetCode(this.getAssetCode());
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setAssetModel(this.getAssetModel());
			inst.setPageSize(this.getPageSize());
			inst.setAssetDepreciation(this.getAssetDepreciation());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setAssetName(this.getAssetName());
			inst.setIds(this.getIds());
			inst.setAsset(this.getAsset());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetDepreciationExcludeVO clone(boolean deep) {
		return EntityContext.clone(AssetDepreciationExcludeVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetDepreciationExcludeVO
	 * @param assetDepreciationExcludeMap 包含实体信息的 Map 对象
	 * @return AssetDepreciationExcludeVO , 转换好的的 AssetDepreciationExclude 对象
	*/
	@Transient
	public static AssetDepreciationExcludeVO createFrom(Map<String,Object> assetDepreciationExcludeMap) {
		if(assetDepreciationExcludeMap==null) return null;
		AssetDepreciationExcludeVO vo = create();
		EntityContext.copyProperties(vo,assetDepreciationExcludeMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetDepreciationExcludeVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDepreciationExcludeVO , 转换好的的 AssetDepreciationExclude 对象
	*/
	@Transient
	public static AssetDepreciationExcludeVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDepreciationExcludeVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetDepreciationExcludeVO，等同于 new
	 * @return AssetDepreciationExcludeVO 对象
	*/
	@Transient
	public static AssetDepreciationExcludeVO create() {
		return new com.dt.platform.domain.eam.meta.AssetDepreciationExcludeVOMeta.$$proxy$$();
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
			this.setDepreciationId(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.DEPRECIATION_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.CREATE_BY)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetDepreciationExcludeVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetDepreciationExcludeVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetDepreciationExcludeVOMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetDepreciationExcludeVOMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetDepreciationExcludeVOMeta.VERSION)));
			// others
			this.setAssetCode(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.ASSET_CODE)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.FUZZY_FIELD)));
			this.setAssetModel(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.ASSET_MODEL)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetDepreciationExcludeVOMeta.PAGE_SIZE)));
			this.setAssetDepreciation(DataParser.parse(AssetDepreciation.class, map.get(AssetDepreciationExcludeVOMeta.ASSET_DEPRECIATION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetDepreciationExcludeVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.SORT_FIELD)));
			this.setAssetName(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.ASSET_NAME)));
			this.setAsset(DataParser.parse(Asset.class, map.get(AssetDepreciationExcludeVOMeta.ASSET)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetDepreciationExcludeVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setDepreciationId( (String)map.get(AssetDepreciationExcludeVOMeta.DEPRECIATION_ID));
				this.setCreateBy( (String)map.get(AssetDepreciationExcludeVOMeta.CREATE_BY));
				this.setNotes( (String)map.get(AssetDepreciationExcludeVOMeta.NOTES));
				this.setDeleted( (Integer)map.get(AssetDepreciationExcludeVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetDepreciationExcludeVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetDepreciationExcludeVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetDepreciationExcludeVOMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(AssetDepreciationExcludeVOMeta.ASSET_ID));
				this.setDeleteBy( (String)map.get(AssetDepreciationExcludeVOMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(AssetDepreciationExcludeVOMeta.UPDATE_TIME));
				this.setId( (String)map.get(AssetDepreciationExcludeVOMeta.ID));
				this.setVersion( (Integer)map.get(AssetDepreciationExcludeVOMeta.VERSION));
				// others
				this.setAssetCode( (String)map.get(AssetDepreciationExcludeVOMeta.ASSET_CODE));
				this.setSearchField( (String)map.get(AssetDepreciationExcludeVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(AssetDepreciationExcludeVOMeta.FUZZY_FIELD));
				this.setAssetModel( (String)map.get(AssetDepreciationExcludeVOMeta.ASSET_MODEL));
				this.setPageSize( (Integer)map.get(AssetDepreciationExcludeVOMeta.PAGE_SIZE));
				this.setAssetDepreciation( (AssetDepreciation)map.get(AssetDepreciationExcludeVOMeta.ASSET_DEPRECIATION));
				this.setPageIndex( (Integer)map.get(AssetDepreciationExcludeVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetDepreciationExcludeVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssetDepreciationExcludeVOMeta.SORT_FIELD));
				this.setAssetName( (String)map.get(AssetDepreciationExcludeVOMeta.ASSET_NAME));
				this.setAsset( (Asset)map.get(AssetDepreciationExcludeVOMeta.ASSET));
				this.setSearchValue( (String)map.get(AssetDepreciationExcludeVOMeta.SEARCH_VALUE));
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
			this.setDepreciationId(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeVOMeta.DEPRECIATION_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeVOMeta.CREATE_BY)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeVOMeta.NOTES)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetDepreciationExcludeVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationExcludeVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationExcludeVOMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeVOMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeVOMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationExcludeVOMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetDepreciationExcludeVOMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetDepreciationExcludeVOMeta.VERSION)));
			return true;
		} else {
			try {
				this.setDepreciationId( (String)r.getValue(AssetDepreciationExcludeVOMeta.DEPRECIATION_ID));
				this.setCreateBy( (String)r.getValue(AssetDepreciationExcludeVOMeta.CREATE_BY));
				this.setNotes( (String)r.getValue(AssetDepreciationExcludeVOMeta.NOTES));
				this.setDeleted( (Integer)r.getValue(AssetDepreciationExcludeVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetDepreciationExcludeVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetDepreciationExcludeVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetDepreciationExcludeVOMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(AssetDepreciationExcludeVOMeta.ASSET_ID));
				this.setDeleteBy( (String)r.getValue(AssetDepreciationExcludeVOMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(AssetDepreciationExcludeVOMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(AssetDepreciationExcludeVOMeta.ID));
				this.setVersion( (Integer)r.getValue(AssetDepreciationExcludeVOMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}