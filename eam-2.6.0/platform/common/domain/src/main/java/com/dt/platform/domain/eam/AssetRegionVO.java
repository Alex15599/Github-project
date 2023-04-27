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
import com.dt.platform.domain.eam.meta.AssetRegionVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 存放区域VO类型
 * <p>存放区域 , 数据表 eam_asset_region 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-25 22:19:46
 * @sign 33A14763A7577401C32B15FB22C22655
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "存放区域VO类型 ; 存放区域 , 数据表 eam_asset_region 的通用VO类型" , parent = AssetRegion.class)
public class AssetRegionVO extends AssetRegion {

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
	public AssetRegionVO setPageIndex(Integer pageIndex) {
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
	public AssetRegionVO setPageSize(Integer pageSize) {
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
	public AssetRegionVO setSearchField(String searchField) {
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
	public AssetRegionVO setFuzzyField(String fuzzyField) {
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
	public AssetRegionVO setSearchValue(String searchValue) {
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
	public AssetRegionVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetRegionVO addDirtyField(String... dirtyField) {
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
	public AssetRegionVO setSortField(String sortField) {
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
	public AssetRegionVO setSortType(String sortType) {
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
	public AssetRegionVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetRegionVO addId(String... id) {
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
	 * @return AssetRegionVO , 转换好的 AssetRegionVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetRegionVO , 转换好的 PoJo 对象
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
	public AssetRegionVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetRegionVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetRegionVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetRegionVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setRegionName(this.getRegionName());
		inst.setHierarchy(this.getHierarchy());
		inst.setHierarchyName(this.getHierarchyName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setParentId(this.getParentId());
		inst.setRegionCode(this.getRegionCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
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
	public AssetRegionVO clone(boolean deep) {
		return EntityContext.clone(AssetRegionVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetRegionVO
	 * @param assetRegionMap 包含实体信息的 Map 对象
	 * @return AssetRegionVO , 转换好的的 AssetRegion 对象
	*/
	@Transient
	public static AssetRegionVO createFrom(Map<String,Object> assetRegionMap) {
		if(assetRegionMap==null) return null;
		AssetRegionVO vo = create();
		EntityContext.copyProperties(vo,assetRegionMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetRegionVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetRegionVO , 转换好的的 AssetRegion 对象
	*/
	@Transient
	public static AssetRegionVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetRegionVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetRegionVO，等同于 new
	 * @return AssetRegionVO 对象
	*/
	@Transient
	public static AssetRegionVO create() {
		return new com.dt.platform.domain.eam.meta.AssetRegionVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssetRegionVOMeta.NOTES)));
			this.setRegionName(DataParser.parse(String.class, map.get(AssetRegionVOMeta.REGION_NAME)));
			this.setHierarchy(DataParser.parse(String.class, map.get(AssetRegionVOMeta.HIERARCHY)));
			this.setHierarchyName(DataParser.parse(String.class, map.get(AssetRegionVOMeta.HIERARCHY_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetRegionVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(AssetRegionVOMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetRegionVOMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, map.get(AssetRegionVOMeta.PARENT_ID)));
			this.setRegionCode(DataParser.parse(String.class, map.get(AssetRegionVOMeta.REGION_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetRegionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetRegionVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetRegionVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetRegionVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetRegionVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetRegionVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetRegionVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetRegionVOMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetRegionVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetRegionVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetRegionVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetRegionVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetRegionVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetRegionVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetRegionVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetRegionVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssetRegionVOMeta.NOTES));
				this.setRegionName( (String)map.get(AssetRegionVOMeta.REGION_NAME));
				this.setHierarchy( (String)map.get(AssetRegionVOMeta.HIERARCHY));
				this.setHierarchyName( (String)map.get(AssetRegionVOMeta.HIERARCHY_NAME));
				this.setUpdateTime( (Date)map.get(AssetRegionVOMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(AssetRegionVOMeta.SORT));
				this.setVersion( (Integer)map.get(AssetRegionVOMeta.VERSION));
				this.setParentId( (String)map.get(AssetRegionVOMeta.PARENT_ID));
				this.setRegionCode( (String)map.get(AssetRegionVOMeta.REGION_CODE));
				this.setCreateBy( (String)map.get(AssetRegionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetRegionVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetRegionVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetRegionVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetRegionVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(AssetRegionVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetRegionVOMeta.DELETE_BY));
				this.setId( (String)map.get(AssetRegionVOMeta.ID));
				this.setStatus( (String)map.get(AssetRegionVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(AssetRegionVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(AssetRegionVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetRegionVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(AssetRegionVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(AssetRegionVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(AssetRegionVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(AssetRegionVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetRegionVOMeta.NOTES)));
			this.setRegionName(DataParser.parse(String.class, r.getValue(AssetRegionVOMeta.REGION_NAME)));
			this.setHierarchy(DataParser.parse(String.class, r.getValue(AssetRegionVOMeta.HIERARCHY)));
			this.setHierarchyName(DataParser.parse(String.class, r.getValue(AssetRegionVOMeta.HIERARCHY_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetRegionVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(AssetRegionVOMeta.SORT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetRegionVOMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, r.getValue(AssetRegionVOMeta.PARENT_ID)));
			this.setRegionCode(DataParser.parse(String.class, r.getValue(AssetRegionVOMeta.REGION_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetRegionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetRegionVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetRegionVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetRegionVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetRegionVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetRegionVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetRegionVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetRegionVOMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetRegionVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssetRegionVOMeta.NOTES));
				this.setRegionName( (String)r.getValue(AssetRegionVOMeta.REGION_NAME));
				this.setHierarchy( (String)r.getValue(AssetRegionVOMeta.HIERARCHY));
				this.setHierarchyName( (String)r.getValue(AssetRegionVOMeta.HIERARCHY_NAME));
				this.setUpdateTime( (Date)r.getValue(AssetRegionVOMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(AssetRegionVOMeta.SORT));
				this.setVersion( (Integer)r.getValue(AssetRegionVOMeta.VERSION));
				this.setParentId( (String)r.getValue(AssetRegionVOMeta.PARENT_ID));
				this.setRegionCode( (String)r.getValue(AssetRegionVOMeta.REGION_CODE));
				this.setCreateBy( (String)r.getValue(AssetRegionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetRegionVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetRegionVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetRegionVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetRegionVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(AssetRegionVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetRegionVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetRegionVOMeta.ID));
				this.setStatus( (String)r.getValue(AssetRegionVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}