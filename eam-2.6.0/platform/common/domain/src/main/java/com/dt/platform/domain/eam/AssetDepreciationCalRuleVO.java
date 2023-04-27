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
import com.dt.platform.domain.eam.meta.AssetDepreciationCalRuleVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 计算方法VO类型
 * <p>计算方法 , 数据表 eam_asset_depreciation_cal_rule 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-27 17:04:42
 * @sign 28BAA1B1146496F48E6F2C484F903CEA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "计算方法VO类型 ; 计算方法 , 数据表 eam_asset_depreciation_cal_rule 的通用VO类型" , parent = AssetDepreciationCalRule.class)
public class AssetDepreciationCalRuleVO extends AssetDepreciationCalRule {

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
	public AssetDepreciationCalRuleVO setPageIndex(Integer pageIndex) {
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
	public AssetDepreciationCalRuleVO setPageSize(Integer pageSize) {
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
	public AssetDepreciationCalRuleVO setSearchField(String searchField) {
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
	public AssetDepreciationCalRuleVO setFuzzyField(String fuzzyField) {
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
	public AssetDepreciationCalRuleVO setSearchValue(String searchValue) {
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
	public AssetDepreciationCalRuleVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetDepreciationCalRuleVO addDirtyField(String... dirtyField) {
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
	public AssetDepreciationCalRuleVO setSortField(String sortField) {
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
	public AssetDepreciationCalRuleVO setSortType(String sortType) {
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
	public AssetDepreciationCalRuleVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetDepreciationCalRuleVO addId(String... id) {
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
	 * @return AssetDepreciationCalRuleVO , 转换好的 AssetDepreciationCalRuleVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDepreciationCalRuleVO , 转换好的 PoJo 对象
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
	public AssetDepreciationCalRuleVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetDepreciationCalRuleVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetDepreciationCalRuleVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetDepreciationCalRuleVOMeta.$$proxy$$();
		inst.setCalculationType(this.getCalculationType());
		inst.setNotes(this.getNotes());
		inst.setRuleNumber(this.getRuleNumber());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setMethodContentInfo(this.getMethodContentInfo());
		inst.setColumnValue(this.getColumnValue());
		inst.setVersion(this.getVersion());
		inst.setMethodContent(this.getMethodContent());
		inst.setDepreciationId(this.getDepreciationId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setActionCode(this.getActionCode());
		inst.setId(this.getId());
		inst.setReturnType(this.getReturnType());
		inst.setStatus(this.getStatus());
		inst.setColumnName(this.getColumnName());
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
			inst.setAssetDepreciation(this.getAssetDepreciation());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetDepreciationCalRuleVO clone(boolean deep) {
		return EntityContext.clone(AssetDepreciationCalRuleVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetDepreciationCalRuleVO
	 * @param assetDepreciationCalRuleMap 包含实体信息的 Map 对象
	 * @return AssetDepreciationCalRuleVO , 转换好的的 AssetDepreciationCalRule 对象
	*/
	@Transient
	public static AssetDepreciationCalRuleVO createFrom(Map<String,Object> assetDepreciationCalRuleMap) {
		if(assetDepreciationCalRuleMap==null) return null;
		AssetDepreciationCalRuleVO vo = create();
		EntityContext.copyProperties(vo,assetDepreciationCalRuleMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetDepreciationCalRuleVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDepreciationCalRuleVO , 转换好的的 AssetDepreciationCalRule 对象
	*/
	@Transient
	public static AssetDepreciationCalRuleVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDepreciationCalRuleVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetDepreciationCalRuleVO，等同于 new
	 * @return AssetDepreciationCalRuleVO 对象
	*/
	@Transient
	public static AssetDepreciationCalRuleVO create() {
		return new com.dt.platform.domain.eam.meta.AssetDepreciationCalRuleVOMeta.$$proxy$$();
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
			this.setCalculationType(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.CALCULATION_TYPE)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.NOTES)));
			this.setRuleNumber(DataParser.parse(Integer.class, map.get(AssetDepreciationCalRuleVOMeta.RULE_NUMBER)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetDepreciationCalRuleVOMeta.UPDATE_TIME)));
			this.setMethodContentInfo(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.METHOD_CONTENT_INFO)));
			this.setColumnValue(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.COLUMN_VALUE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetDepreciationCalRuleVOMeta.VERSION)));
			this.setMethodContent(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.METHOD_CONTENT)));
			this.setDepreciationId(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.DEPRECIATION_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetDepreciationCalRuleVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetDepreciationCalRuleVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetDepreciationCalRuleVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.DELETE_BY)));
			this.setActionCode(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.ACTION_CODE)));
			this.setId(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.ID)));
			this.setReturnType(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.RETURN_TYPE)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.STATUS)));
			this.setColumnName(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.COLUMN_NAME)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetDepreciationCalRuleVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetDepreciationCalRuleVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetDepreciationCalRuleVOMeta.SEARCH_VALUE)));
			this.setAssetDepreciation(DataParser.parse(AssetDepreciation.class, map.get(AssetDepreciationCalRuleVOMeta.ASSET_DEPRECIATION)));
			return true;
		} else {
			try {
				this.setCalculationType( (String)map.get(AssetDepreciationCalRuleVOMeta.CALCULATION_TYPE));
				this.setNotes( (String)map.get(AssetDepreciationCalRuleVOMeta.NOTES));
				this.setRuleNumber( (Integer)map.get(AssetDepreciationCalRuleVOMeta.RULE_NUMBER));
				this.setUpdateTime( (Date)map.get(AssetDepreciationCalRuleVOMeta.UPDATE_TIME));
				this.setMethodContentInfo( (String)map.get(AssetDepreciationCalRuleVOMeta.METHOD_CONTENT_INFO));
				this.setColumnValue( (String)map.get(AssetDepreciationCalRuleVOMeta.COLUMN_VALUE));
				this.setVersion( (Integer)map.get(AssetDepreciationCalRuleVOMeta.VERSION));
				this.setMethodContent( (String)map.get(AssetDepreciationCalRuleVOMeta.METHOD_CONTENT));
				this.setDepreciationId( (String)map.get(AssetDepreciationCalRuleVOMeta.DEPRECIATION_ID));
				this.setCreateBy( (String)map.get(AssetDepreciationCalRuleVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetDepreciationCalRuleVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetDepreciationCalRuleVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetDepreciationCalRuleVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetDepreciationCalRuleVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(AssetDepreciationCalRuleVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetDepreciationCalRuleVOMeta.DELETE_BY));
				this.setActionCode( (String)map.get(AssetDepreciationCalRuleVOMeta.ACTION_CODE));
				this.setId( (String)map.get(AssetDepreciationCalRuleVOMeta.ID));
				this.setReturnType( (String)map.get(AssetDepreciationCalRuleVOMeta.RETURN_TYPE));
				this.setStatus( (String)map.get(AssetDepreciationCalRuleVOMeta.STATUS));
				this.setColumnName( (String)map.get(AssetDepreciationCalRuleVOMeta.COLUMN_NAME));
				// others
				this.setSearchField( (String)map.get(AssetDepreciationCalRuleVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(AssetDepreciationCalRuleVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetDepreciationCalRuleVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(AssetDepreciationCalRuleVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(AssetDepreciationCalRuleVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(AssetDepreciationCalRuleVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(AssetDepreciationCalRuleVOMeta.SEARCH_VALUE));
				this.setAssetDepreciation( (AssetDepreciation)map.get(AssetDepreciationCalRuleVOMeta.ASSET_DEPRECIATION));
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
			this.setCalculationType(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.CALCULATION_TYPE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.NOTES)));
			this.setRuleNumber(DataParser.parse(Integer.class, r.getValue(AssetDepreciationCalRuleVOMeta.RULE_NUMBER)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationCalRuleVOMeta.UPDATE_TIME)));
			this.setMethodContentInfo(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.METHOD_CONTENT_INFO)));
			this.setColumnValue(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.COLUMN_VALUE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetDepreciationCalRuleVOMeta.VERSION)));
			this.setMethodContent(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.METHOD_CONTENT)));
			this.setDepreciationId(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.DEPRECIATION_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetDepreciationCalRuleVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationCalRuleVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationCalRuleVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.DELETE_BY)));
			this.setActionCode(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.ACTION_CODE)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.ID)));
			this.setReturnType(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.RETURN_TYPE)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.STATUS)));
			this.setColumnName(DataParser.parse(String.class, r.getValue(AssetDepreciationCalRuleVOMeta.COLUMN_NAME)));
			return true;
		} else {
			try {
				this.setCalculationType( (String)r.getValue(AssetDepreciationCalRuleVOMeta.CALCULATION_TYPE));
				this.setNotes( (String)r.getValue(AssetDepreciationCalRuleVOMeta.NOTES));
				this.setRuleNumber( (Integer)r.getValue(AssetDepreciationCalRuleVOMeta.RULE_NUMBER));
				this.setUpdateTime( (Date)r.getValue(AssetDepreciationCalRuleVOMeta.UPDATE_TIME));
				this.setMethodContentInfo( (String)r.getValue(AssetDepreciationCalRuleVOMeta.METHOD_CONTENT_INFO));
				this.setColumnValue( (String)r.getValue(AssetDepreciationCalRuleVOMeta.COLUMN_VALUE));
				this.setVersion( (Integer)r.getValue(AssetDepreciationCalRuleVOMeta.VERSION));
				this.setMethodContent( (String)r.getValue(AssetDepreciationCalRuleVOMeta.METHOD_CONTENT));
				this.setDepreciationId( (String)r.getValue(AssetDepreciationCalRuleVOMeta.DEPRECIATION_ID));
				this.setCreateBy( (String)r.getValue(AssetDepreciationCalRuleVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetDepreciationCalRuleVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetDepreciationCalRuleVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetDepreciationCalRuleVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetDepreciationCalRuleVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(AssetDepreciationCalRuleVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetDepreciationCalRuleVOMeta.DELETE_BY));
				this.setActionCode( (String)r.getValue(AssetDepreciationCalRuleVOMeta.ACTION_CODE));
				this.setId( (String)r.getValue(AssetDepreciationCalRuleVOMeta.ID));
				this.setReturnType( (String)r.getValue(AssetDepreciationCalRuleVOMeta.RETURN_TYPE));
				this.setStatus( (String)r.getValue(AssetDepreciationCalRuleVOMeta.STATUS));
				this.setColumnName( (String)r.getValue(AssetDepreciationCalRuleVOMeta.COLUMN_NAME));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}