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
import com.dt.platform.domain.eam.meta.AssetCopyVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产复制VO类型
 * <p>资产复制 , 数据表 eam_asset_copy 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-16 12:39:45
 * @sign DB8C8770F6E59192667424AE08B44C73
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产复制VO类型 ; 资产复制 , 数据表 eam_asset_copy 的通用VO类型" , parent = AssetCopy.class)
public class AssetCopyVO extends AssetCopy {

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
	public AssetCopyVO setPageIndex(Integer pageIndex) {
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
	public AssetCopyVO setPageSize(Integer pageSize) {
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
	public AssetCopyVO setSearchField(String searchField) {
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
	public AssetCopyVO setFuzzyField(String fuzzyField) {
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
	public AssetCopyVO setSearchValue(String searchValue) {
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
	public AssetCopyVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetCopyVO addDirtyField(String... dirtyField) {
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
	public AssetCopyVO setSortField(String sortField) {
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
	public AssetCopyVO setSortType(String sortType) {
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
	public AssetCopyVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetCopyVO addId(String... id) {
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
	 * @return AssetCopyVO , 转换好的 AssetCopyVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetCopyVO , 转换好的 PoJo 对象
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
	public AssetCopyVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetCopyVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetCopyVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetCopyVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setAssetNumber(this.getAssetNumber());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
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
	public AssetCopyVO clone(boolean deep) {
		return EntityContext.clone(AssetCopyVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetCopyVO
	 * @param assetCopyMap 包含实体信息的 Map 对象
	 * @return AssetCopyVO , 转换好的的 AssetCopy 对象
	*/
	@Transient
	public static AssetCopyVO createFrom(Map<String,Object> assetCopyMap) {
		if(assetCopyMap==null) return null;
		AssetCopyVO vo = create();
		EntityContext.copyProperties(vo,assetCopyMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetCopyVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetCopyVO , 转换好的的 AssetCopy 对象
	*/
	@Transient
	public static AssetCopyVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetCopyVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetCopyVO，等同于 new
	 * @return AssetCopyVO 对象
	*/
	@Transient
	public static AssetCopyVO create() {
		return new com.dt.platform.domain.eam.meta.AssetCopyVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssetCopyVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetCopyVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetCopyVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetCopyVOMeta.CREATE_BY)));
			this.setAssetNumber(DataParser.parse(Integer.class, map.get(AssetCopyVOMeta.ASSET_NUMBER)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetCopyVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetCopyVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetCopyVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetCopyVOMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(AssetCopyVOMeta.ASSET_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetCopyVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetCopyVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetCopyVOMeta.ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetCopyVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetCopyVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetCopyVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetCopyVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetCopyVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetCopyVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetCopyVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssetCopyVOMeta.NOTES));
				this.setUpdateTime( (Date)map.get(AssetCopyVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetCopyVOMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetCopyVOMeta.CREATE_BY));
				this.setAssetNumber( (Integer)map.get(AssetCopyVOMeta.ASSET_NUMBER));
				this.setDeleted( (Integer)map.get(AssetCopyVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetCopyVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetCopyVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetCopyVOMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(AssetCopyVOMeta.ASSET_ID));
				this.setTenantId( (String)map.get(AssetCopyVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetCopyVOMeta.DELETE_BY));
				this.setId( (String)map.get(AssetCopyVOMeta.ID));
				// others
				this.setSearchField( (String)map.get(AssetCopyVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(AssetCopyVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetCopyVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(AssetCopyVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(AssetCopyVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(AssetCopyVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(AssetCopyVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetCopyVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetCopyVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetCopyVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetCopyVOMeta.CREATE_BY)));
			this.setAssetNumber(DataParser.parse(Integer.class, r.getValue(AssetCopyVOMeta.ASSET_NUMBER)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetCopyVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetCopyVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetCopyVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetCopyVOMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(AssetCopyVOMeta.ASSET_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetCopyVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetCopyVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetCopyVOMeta.ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssetCopyVOMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(AssetCopyVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetCopyVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetCopyVOMeta.CREATE_BY));
				this.setAssetNumber( (Integer)r.getValue(AssetCopyVOMeta.ASSET_NUMBER));
				this.setDeleted( (Integer)r.getValue(AssetCopyVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetCopyVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetCopyVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetCopyVOMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(AssetCopyVOMeta.ASSET_ID));
				this.setTenantId( (String)r.getValue(AssetCopyVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetCopyVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetCopyVOMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}