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
import com.dt.platform.domain.eam.meta.AssetDepreciationVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 折旧方案VO类型
 * <p>折旧方案 , 数据表 eam_asset_depreciation 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-27 12:24:36
 * @sign 6ED67DFA8CB43209E521A1C25B226E71
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "折旧方案VO类型 ; 折旧方案 , 数据表 eam_asset_depreciation 的通用VO类型" , parent = AssetDepreciation.class)
public class AssetDepreciationVO extends AssetDepreciation {

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
	public AssetDepreciationVO setPageIndex(Integer pageIndex) {
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
	public AssetDepreciationVO setPageSize(Integer pageSize) {
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
	public AssetDepreciationVO setSearchField(String searchField) {
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
	public AssetDepreciationVO setFuzzyField(String fuzzyField) {
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
	public AssetDepreciationVO setSearchValue(String searchValue) {
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
	public AssetDepreciationVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetDepreciationVO addDirtyField(String... dirtyField) {
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
	public AssetDepreciationVO setSortField(String sortField) {
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
	public AssetDepreciationVO setSortType(String sortType) {
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
	public AssetDepreciationVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetDepreciationVO addId(String... id) {
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
	 * @return AssetDepreciationVO , 转换好的 AssetDepreciationVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDepreciationVO , 转换好的 PoJo 对象
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
	public AssetDepreciationVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetDepreciationVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetDepreciationVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetDepreciationVOMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setMethod(this.getMethod());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setResidualValueSelect(this.getResidualValueSelect());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setVersion(this.getVersion());
		inst.setFirstDepreciationMethod(this.getFirstDepreciationMethod());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setPreResidualRate(this.getPreResidualRate());
		inst.setId(this.getId());
		inst.setCategoryId(this.getCategoryId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setCategoryIds(this.getCategoryIds());
			inst.setCalRuleList(this.getCalRuleList());
			inst.setCalRuleIds(this.getCalRuleIds());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setIds(this.getIds());
			inst.setCategory(this.getCategory());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetDepreciationVO clone(boolean deep) {
		return EntityContext.clone(AssetDepreciationVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetDepreciationVO
	 * @param assetDepreciationMap 包含实体信息的 Map 对象
	 * @return AssetDepreciationVO , 转换好的的 AssetDepreciation 对象
	*/
	@Transient
	public static AssetDepreciationVO createFrom(Map<String,Object> assetDepreciationMap) {
		if(assetDepreciationMap==null) return null;
		AssetDepreciationVO vo = create();
		EntityContext.copyProperties(vo,assetDepreciationMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetDepreciationVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDepreciationVO , 转换好的的 AssetDepreciation 对象
	*/
	@Transient
	public static AssetDepreciationVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDepreciationVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetDepreciationVO，等同于 new
	 * @return AssetDepreciationVO 对象
	*/
	@Transient
	public static AssetDepreciationVO create() {
		return new com.dt.platform.domain.eam.meta.AssetDepreciationVOMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.NOTES)));
			this.setMethod(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetDepreciationVOMeta.UPDATE_TIME)));
			this.setResidualValueSelect(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.RESIDUAL_VALUE_SELECT)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetDepreciationVOMeta.VERSION)));
			this.setFirstDepreciationMethod(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.FIRST_DEPRECIATION_METHOD)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetDepreciationVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetDepreciationVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetDepreciationVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.DELETE_BY)));
			this.setPreResidualRate(DataParser.parse(BigDecimal.class, map.get(AssetDepreciationVOMeta.PRE_RESIDUAL_RATE)));
			this.setId(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.ID)));
			this.setCategoryId(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.CATEGORY_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetDepreciationVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetDepreciationVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.SORT_FIELD)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetDepreciationVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(AssetDepreciationVOMeta.CODE));
				this.setNotes( (String)map.get(AssetDepreciationVOMeta.NOTES));
				this.setMethod( (String)map.get(AssetDepreciationVOMeta.METHOD));
				this.setUpdateTime( (Date)map.get(AssetDepreciationVOMeta.UPDATE_TIME));
				this.setResidualValueSelect( (String)map.get(AssetDepreciationVOMeta.RESIDUAL_VALUE_SELECT));
				this.setSelectedCode( (String)map.get(AssetDepreciationVOMeta.SELECTED_CODE));
				this.setVersion( (Integer)map.get(AssetDepreciationVOMeta.VERSION));
				this.setFirstDepreciationMethod( (String)map.get(AssetDepreciationVOMeta.FIRST_DEPRECIATION_METHOD));
				this.setOwnCompanyId( (String)map.get(AssetDepreciationVOMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)map.get(AssetDepreciationVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetDepreciationVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetDepreciationVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetDepreciationVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetDepreciationVOMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetDepreciationVOMeta.NAME));
				this.setTenantId( (String)map.get(AssetDepreciationVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetDepreciationVOMeta.DELETE_BY));
				this.setPreResidualRate( (BigDecimal)map.get(AssetDepreciationVOMeta.PRE_RESIDUAL_RATE));
				this.setId( (String)map.get(AssetDepreciationVOMeta.ID));
				this.setCategoryId( (String)map.get(AssetDepreciationVOMeta.CATEGORY_ID));
				this.setStatus( (String)map.get(AssetDepreciationVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(AssetDepreciationVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(AssetDepreciationVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetDepreciationVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(AssetDepreciationVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetDepreciationVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssetDepreciationVOMeta.SORT_FIELD));
				this.setSearchValue( (String)map.get(AssetDepreciationVOMeta.SEARCH_VALUE));
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
			this.setCode(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.NOTES)));
			this.setMethod(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.METHOD)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationVOMeta.UPDATE_TIME)));
			this.setResidualValueSelect(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.RESIDUAL_VALUE_SELECT)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetDepreciationVOMeta.VERSION)));
			this.setFirstDepreciationMethod(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.FIRST_DEPRECIATION_METHOD)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetDepreciationVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.DELETE_BY)));
			this.setPreResidualRate(DataParser.parse(BigDecimal.class, r.getValue(AssetDepreciationVOMeta.PRE_RESIDUAL_RATE)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.ID)));
			this.setCategoryId(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.CATEGORY_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetDepreciationVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(AssetDepreciationVOMeta.CODE));
				this.setNotes( (String)r.getValue(AssetDepreciationVOMeta.NOTES));
				this.setMethod( (String)r.getValue(AssetDepreciationVOMeta.METHOD));
				this.setUpdateTime( (Date)r.getValue(AssetDepreciationVOMeta.UPDATE_TIME));
				this.setResidualValueSelect( (String)r.getValue(AssetDepreciationVOMeta.RESIDUAL_VALUE_SELECT));
				this.setSelectedCode( (String)r.getValue(AssetDepreciationVOMeta.SELECTED_CODE));
				this.setVersion( (Integer)r.getValue(AssetDepreciationVOMeta.VERSION));
				this.setFirstDepreciationMethod( (String)r.getValue(AssetDepreciationVOMeta.FIRST_DEPRECIATION_METHOD));
				this.setOwnCompanyId( (String)r.getValue(AssetDepreciationVOMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)r.getValue(AssetDepreciationVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetDepreciationVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetDepreciationVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetDepreciationVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetDepreciationVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetDepreciationVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetDepreciationVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetDepreciationVOMeta.DELETE_BY));
				this.setPreResidualRate( (BigDecimal)r.getValue(AssetDepreciationVOMeta.PRE_RESIDUAL_RATE));
				this.setId( (String)r.getValue(AssetDepreciationVOMeta.ID));
				this.setCategoryId( (String)r.getValue(AssetDepreciationVOMeta.CATEGORY_ID));
				this.setStatus( (String)r.getValue(AssetDepreciationVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}