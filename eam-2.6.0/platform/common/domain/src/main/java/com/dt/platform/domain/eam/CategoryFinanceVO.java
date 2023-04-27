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
import com.dt.platform.domain.eam.meta.CategoryFinanceVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 财务分类VO类型
 * <p>财务分类 , 数据表 eam_category_finance 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-27 08:06:14
 * @sign 5D046D35527881F06B135AF181500C10
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "财务分类VO类型 ; 财务分类 , 数据表 eam_category_finance 的通用VO类型" , parent = CategoryFinance.class)
public class CategoryFinanceVO extends CategoryFinance {

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
	public CategoryFinanceVO setPageIndex(Integer pageIndex) {
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
	public CategoryFinanceVO setPageSize(Integer pageSize) {
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
	public CategoryFinanceVO setSearchField(String searchField) {
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
	public CategoryFinanceVO setFuzzyField(String fuzzyField) {
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
	public CategoryFinanceVO setSearchValue(String searchValue) {
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
	public CategoryFinanceVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public CategoryFinanceVO addDirtyField(String... dirtyField) {
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
	public CategoryFinanceVO setSortField(String sortField) {
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
	public CategoryFinanceVO setSortType(String sortType) {
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
	public CategoryFinanceVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public CategoryFinanceVO addId(String... id) {
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
	 * @return CategoryFinanceVO , 转换好的 CategoryFinanceVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CategoryFinanceVO , 转换好的 PoJo 对象
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
	public CategoryFinanceVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CategoryFinanceVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CategoryFinanceVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CategoryFinanceVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setHierarchy(this.getHierarchy());
		inst.setHierarchyName(this.getHierarchyName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setCategoryCode(this.getCategoryCode());
		inst.setSort(this.getSort());
		inst.setCategoryName(this.getCategoryName());
		inst.setVersion(this.getVersion());
		inst.setParentId(this.getParentId());
		inst.setCategoryFullname(this.getCategoryFullname());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setServiceLife(this.getServiceLife());
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
	public CategoryFinanceVO clone(boolean deep) {
		return EntityContext.clone(CategoryFinanceVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CategoryFinanceVO
	 * @param categoryFinanceMap 包含实体信息的 Map 对象
	 * @return CategoryFinanceVO , 转换好的的 CategoryFinance 对象
	*/
	@Transient
	public static CategoryFinanceVO createFrom(Map<String,Object> categoryFinanceMap) {
		if(categoryFinanceMap==null) return null;
		CategoryFinanceVO vo = create();
		EntityContext.copyProperties(vo,categoryFinanceMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 CategoryFinanceVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CategoryFinanceVO , 转换好的的 CategoryFinance 对象
	*/
	@Transient
	public static CategoryFinanceVO createFrom(Object pojo) {
		if(pojo==null) return null;
		CategoryFinanceVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 CategoryFinanceVO，等同于 new
	 * @return CategoryFinanceVO 对象
	*/
	@Transient
	public static CategoryFinanceVO create() {
		return new com.dt.platform.domain.eam.meta.CategoryFinanceVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.NOTES)));
			this.setHierarchy(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.HIERARCHY)));
			this.setHierarchyName(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.HIERARCHY_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CategoryFinanceVOMeta.UPDATE_TIME)));
			this.setCategoryCode(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.CATEGORY_CODE)));
			this.setSort(DataParser.parse(Integer.class, map.get(CategoryFinanceVOMeta.SORT)));
			this.setCategoryName(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.CATEGORY_NAME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CategoryFinanceVOMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.PARENT_ID)));
			this.setCategoryFullname(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.CATEGORY_FULLNAME)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CategoryFinanceVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CategoryFinanceVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CategoryFinanceVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.DELETE_BY)));
			this.setServiceLife(DataParser.parse(BigDecimal.class, map.get(CategoryFinanceVOMeta.SERVICE_LIFE)));
			this.setId(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(CategoryFinanceVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(CategoryFinanceVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(CategoryFinanceVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(CategoryFinanceVOMeta.NOTES));
				this.setHierarchy( (String)map.get(CategoryFinanceVOMeta.HIERARCHY));
				this.setHierarchyName( (String)map.get(CategoryFinanceVOMeta.HIERARCHY_NAME));
				this.setUpdateTime( (Date)map.get(CategoryFinanceVOMeta.UPDATE_TIME));
				this.setCategoryCode( (String)map.get(CategoryFinanceVOMeta.CATEGORY_CODE));
				this.setSort( (Integer)map.get(CategoryFinanceVOMeta.SORT));
				this.setCategoryName( (String)map.get(CategoryFinanceVOMeta.CATEGORY_NAME));
				this.setVersion( (Integer)map.get(CategoryFinanceVOMeta.VERSION));
				this.setParentId( (String)map.get(CategoryFinanceVOMeta.PARENT_ID));
				this.setCategoryFullname( (String)map.get(CategoryFinanceVOMeta.CATEGORY_FULLNAME));
				this.setCreateBy( (String)map.get(CategoryFinanceVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CategoryFinanceVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(CategoryFinanceVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CategoryFinanceVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CategoryFinanceVOMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(CategoryFinanceVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CategoryFinanceVOMeta.DELETE_BY));
				this.setServiceLife( (BigDecimal)map.get(CategoryFinanceVOMeta.SERVICE_LIFE));
				this.setId( (String)map.get(CategoryFinanceVOMeta.ID));
				this.setStatus( (String)map.get(CategoryFinanceVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(CategoryFinanceVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(CategoryFinanceVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(CategoryFinanceVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(CategoryFinanceVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(CategoryFinanceVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(CategoryFinanceVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(CategoryFinanceVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(CategoryFinanceVOMeta.NOTES)));
			this.setHierarchy(DataParser.parse(String.class, r.getValue(CategoryFinanceVOMeta.HIERARCHY)));
			this.setHierarchyName(DataParser.parse(String.class, r.getValue(CategoryFinanceVOMeta.HIERARCHY_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CategoryFinanceVOMeta.UPDATE_TIME)));
			this.setCategoryCode(DataParser.parse(String.class, r.getValue(CategoryFinanceVOMeta.CATEGORY_CODE)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(CategoryFinanceVOMeta.SORT)));
			this.setCategoryName(DataParser.parse(String.class, r.getValue(CategoryFinanceVOMeta.CATEGORY_NAME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CategoryFinanceVOMeta.VERSION)));
			this.setParentId(DataParser.parse(String.class, r.getValue(CategoryFinanceVOMeta.PARENT_ID)));
			this.setCategoryFullname(DataParser.parse(String.class, r.getValue(CategoryFinanceVOMeta.CATEGORY_FULLNAME)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CategoryFinanceVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CategoryFinanceVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CategoryFinanceVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CategoryFinanceVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CategoryFinanceVOMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CategoryFinanceVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CategoryFinanceVOMeta.DELETE_BY)));
			this.setServiceLife(DataParser.parse(BigDecimal.class, r.getValue(CategoryFinanceVOMeta.SERVICE_LIFE)));
			this.setId(DataParser.parse(String.class, r.getValue(CategoryFinanceVOMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(CategoryFinanceVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(CategoryFinanceVOMeta.NOTES));
				this.setHierarchy( (String)r.getValue(CategoryFinanceVOMeta.HIERARCHY));
				this.setHierarchyName( (String)r.getValue(CategoryFinanceVOMeta.HIERARCHY_NAME));
				this.setUpdateTime( (Date)r.getValue(CategoryFinanceVOMeta.UPDATE_TIME));
				this.setCategoryCode( (String)r.getValue(CategoryFinanceVOMeta.CATEGORY_CODE));
				this.setSort( (Integer)r.getValue(CategoryFinanceVOMeta.SORT));
				this.setCategoryName( (String)r.getValue(CategoryFinanceVOMeta.CATEGORY_NAME));
				this.setVersion( (Integer)r.getValue(CategoryFinanceVOMeta.VERSION));
				this.setParentId( (String)r.getValue(CategoryFinanceVOMeta.PARENT_ID));
				this.setCategoryFullname( (String)r.getValue(CategoryFinanceVOMeta.CATEGORY_FULLNAME));
				this.setCreateBy( (String)r.getValue(CategoryFinanceVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CategoryFinanceVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CategoryFinanceVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CategoryFinanceVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CategoryFinanceVOMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(CategoryFinanceVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CategoryFinanceVOMeta.DELETE_BY));
				this.setServiceLife( (BigDecimal)r.getValue(CategoryFinanceVOMeta.SERVICE_LIFE));
				this.setId( (String)r.getValue(CategoryFinanceVOMeta.ID));
				this.setStatus( (String)r.getValue(CategoryFinanceVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}