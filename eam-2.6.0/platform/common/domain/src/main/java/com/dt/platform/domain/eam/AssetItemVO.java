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
import com.dt.platform.domain.eam.meta.AssetItemVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产VO类型
 * <p>资产 , 数据表 eam_asset_item 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-13 18:13:51
 * @sign 43ACC8582D5BAFAE871200ABB1CAAC6E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产VO类型 ; 资产 , 数据表 eam_asset_item 的通用VO类型" , parent = AssetItem.class)
public class AssetItemVO extends AssetItem {

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
	public AssetItemVO setPageIndex(Integer pageIndex) {
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
	public AssetItemVO setPageSize(Integer pageSize) {
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
	public AssetItemVO setSearchField(String searchField) {
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
	public AssetItemVO setFuzzyField(String fuzzyField) {
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
	public AssetItemVO setSearchValue(String searchValue) {
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
	public AssetItemVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetItemVO addDirtyField(String... dirtyField) {
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
	public AssetItemVO setSortField(String sortField) {
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
	public AssetItemVO setSortType(String sortType) {
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
	public AssetItemVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetItemVO addId(String... id) {
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
	 * @return AssetItemVO , 转换好的 AssetItemVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetItemVO , 转换好的 PoJo 对象
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
	public AssetItemVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetItemVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetItemVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetItemVOMeta.$$proxy$$();
		inst.setBeforeAssetStatus(this.getBeforeAssetStatus());
		inst.setFlag(this.getFlag());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCrd(this.getCrd());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setHandleId(this.getHandleId());
		inst.setBeforeUseUserId(this.getBeforeUseUserId());
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
	public AssetItemVO clone(boolean deep) {
		return EntityContext.clone(AssetItemVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetItemVO
	 * @param assetItemMap 包含实体信息的 Map 对象
	 * @return AssetItemVO , 转换好的的 AssetItem 对象
	*/
	@Transient
	public static AssetItemVO createFrom(Map<String,Object> assetItemMap) {
		if(assetItemMap==null) return null;
		AssetItemVO vo = create();
		EntityContext.copyProperties(vo,assetItemMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetItemVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetItemVO , 转换好的的 AssetItem 对象
	*/
	@Transient
	public static AssetItemVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetItemVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetItemVO，等同于 new
	 * @return AssetItemVO 对象
	*/
	@Transient
	public static AssetItemVO create() {
		return new com.dt.platform.domain.eam.meta.AssetItemVOMeta.$$proxy$$();
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
			this.setBeforeAssetStatus(DataParser.parse(String.class, map.get(AssetItemVOMeta.BEFORE_ASSET_STATUS)));
			this.setFlag(DataParser.parse(String.class, map.get(AssetItemVOMeta.FLAG)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetItemVOMeta.UPDATE_TIME)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetItemVOMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetItemVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetItemVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetItemVOMeta.DELETED)));
			this.setCrd(DataParser.parse(String.class, map.get(AssetItemVOMeta.CRD)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetItemVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetItemVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetItemVOMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(AssetItemVOMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetItemVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetItemVOMeta.ID)));
			this.setHandleId(DataParser.parse(String.class, map.get(AssetItemVOMeta.HANDLE_ID)));
			this.setBeforeUseUserId(DataParser.parse(String.class, map.get(AssetItemVOMeta.BEFORE_USE_USER_ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetItemVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetItemVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetItemVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetItemVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetItemVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetItemVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetItemVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setBeforeAssetStatus( (String)map.get(AssetItemVOMeta.BEFORE_ASSET_STATUS));
				this.setFlag( (String)map.get(AssetItemVOMeta.FLAG));
				this.setUpdateTime( (Date)map.get(AssetItemVOMeta.UPDATE_TIME));
				this.setSelectedCode( (String)map.get(AssetItemVOMeta.SELECTED_CODE));
				this.setVersion( (Integer)map.get(AssetItemVOMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetItemVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetItemVOMeta.DELETED));
				this.setCrd( (String)map.get(AssetItemVOMeta.CRD));
				this.setCreateTime( (Date)map.get(AssetItemVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetItemVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetItemVOMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(AssetItemVOMeta.ASSET_ID));
				this.setDeleteBy( (String)map.get(AssetItemVOMeta.DELETE_BY));
				this.setId( (String)map.get(AssetItemVOMeta.ID));
				this.setHandleId( (String)map.get(AssetItemVOMeta.HANDLE_ID));
				this.setBeforeUseUserId( (String)map.get(AssetItemVOMeta.BEFORE_USE_USER_ID));
				// others
				this.setSearchField( (String)map.get(AssetItemVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(AssetItemVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetItemVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(AssetItemVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(AssetItemVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(AssetItemVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(AssetItemVOMeta.SEARCH_VALUE));
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
			this.setBeforeAssetStatus(DataParser.parse(String.class, r.getValue(AssetItemVOMeta.BEFORE_ASSET_STATUS)));
			this.setFlag(DataParser.parse(String.class, r.getValue(AssetItemVOMeta.FLAG)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetItemVOMeta.UPDATE_TIME)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetItemVOMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetItemVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetItemVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetItemVOMeta.DELETED)));
			this.setCrd(DataParser.parse(String.class, r.getValue(AssetItemVOMeta.CRD)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetItemVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetItemVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetItemVOMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(AssetItemVOMeta.ASSET_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetItemVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetItemVOMeta.ID)));
			this.setHandleId(DataParser.parse(String.class, r.getValue(AssetItemVOMeta.HANDLE_ID)));
			this.setBeforeUseUserId(DataParser.parse(String.class, r.getValue(AssetItemVOMeta.BEFORE_USE_USER_ID)));
			return true;
		} else {
			try {
				this.setBeforeAssetStatus( (String)r.getValue(AssetItemVOMeta.BEFORE_ASSET_STATUS));
				this.setFlag( (String)r.getValue(AssetItemVOMeta.FLAG));
				this.setUpdateTime( (Date)r.getValue(AssetItemVOMeta.UPDATE_TIME));
				this.setSelectedCode( (String)r.getValue(AssetItemVOMeta.SELECTED_CODE));
				this.setVersion( (Integer)r.getValue(AssetItemVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetItemVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetItemVOMeta.DELETED));
				this.setCrd( (String)r.getValue(AssetItemVOMeta.CRD));
				this.setCreateTime( (Date)r.getValue(AssetItemVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetItemVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetItemVOMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(AssetItemVOMeta.ASSET_ID));
				this.setDeleteBy( (String)r.getValue(AssetItemVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetItemVOMeta.ID));
				this.setHandleId( (String)r.getValue(AssetItemVOMeta.HANDLE_ID));
				this.setBeforeUseUserId( (String)r.getValue(AssetItemVOMeta.BEFORE_USE_USER_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}