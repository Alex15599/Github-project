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
import com.dt.platform.domain.eam.meta.AssetLabelLayoutVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import java.math.BigDecimal;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 标签布局VO类型
 * <p>标签布局 , 数据表 eam_asset_label_layout 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-02 19:38:47
 * @sign 681AAA4A2078AE5C5EC9B33085A3336D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "标签布局VO类型 ; 标签布局 , 数据表 eam_asset_label_layout 的通用VO类型" , parent = AssetLabelLayout.class)
public class AssetLabelLayoutVO extends AssetLabelLayout {

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
	public AssetLabelLayoutVO setPageIndex(Integer pageIndex) {
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
	public AssetLabelLayoutVO setPageSize(Integer pageSize) {
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
	public AssetLabelLayoutVO setSearchField(String searchField) {
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
	public AssetLabelLayoutVO setFuzzyField(String fuzzyField) {
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
	public AssetLabelLayoutVO setSearchValue(String searchValue) {
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
	public AssetLabelLayoutVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetLabelLayoutVO addDirtyField(String... dirtyField) {
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
	public AssetLabelLayoutVO setSortField(String sortField) {
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
	public AssetLabelLayoutVO setSortType(String sortType) {
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
	public AssetLabelLayoutVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetLabelLayoutVO addId(String... id) {
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
	 * @return AssetLabelLayoutVO , 转换好的 AssetLabelLayoutVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetLabelLayoutVO , 转换好的 PoJo 对象
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
	public AssetLabelLayoutVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetLabelLayoutVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetLabelLayoutVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetLabelLayoutVOMeta.$$proxy$$();
		inst.setRowSpan(this.getRowSpan());
		inst.setColSpan(this.getColSpan());
		inst.setColCode(this.getColCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTplId(this.getTplId());
		inst.setColId(this.getColId());
		inst.setRowNumber(this.getRowNumber());
		inst.setRowHeight(this.getRowHeight());
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
	public AssetLabelLayoutVO clone(boolean deep) {
		return EntityContext.clone(AssetLabelLayoutVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetLabelLayoutVO
	 * @param assetLabelLayoutMap 包含实体信息的 Map 对象
	 * @return AssetLabelLayoutVO , 转换好的的 AssetLabelLayout 对象
	*/
	@Transient
	public static AssetLabelLayoutVO createFrom(Map<String,Object> assetLabelLayoutMap) {
		if(assetLabelLayoutMap==null) return null;
		AssetLabelLayoutVO vo = create();
		EntityContext.copyProperties(vo,assetLabelLayoutMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetLabelLayoutVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetLabelLayoutVO , 转换好的的 AssetLabelLayout 对象
	*/
	@Transient
	public static AssetLabelLayoutVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetLabelLayoutVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetLabelLayoutVO，等同于 new
	 * @return AssetLabelLayoutVO 对象
	*/
	@Transient
	public static AssetLabelLayoutVO create() {
		return new com.dt.platform.domain.eam.meta.AssetLabelLayoutVOMeta.$$proxy$$();
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
			this.setRowSpan(DataParser.parse(Integer.class, map.get(AssetLabelLayoutVOMeta.ROW_SPAN)));
			this.setColSpan(DataParser.parse(Integer.class, map.get(AssetLabelLayoutVOMeta.COL_SPAN)));
			this.setColCode(DataParser.parse(String.class, map.get(AssetLabelLayoutVOMeta.COL_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetLabelLayoutVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(AssetLabelLayoutVOMeta.SORT)));
			this.setType(DataParser.parse(String.class, map.get(AssetLabelLayoutVOMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetLabelLayoutVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetLabelLayoutVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetLabelLayoutVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetLabelLayoutVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetLabelLayoutVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetLabelLayoutVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetLabelLayoutVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetLabelLayoutVOMeta.ID)));
			this.setTplId(DataParser.parse(String.class, map.get(AssetLabelLayoutVOMeta.TPL_ID)));
			this.setColId(DataParser.parse(String.class, map.get(AssetLabelLayoutVOMeta.COL_ID)));
			this.setRowNumber(DataParser.parse(Integer.class, map.get(AssetLabelLayoutVOMeta.ROW_NUMBER)));
			this.setRowHeight(DataParser.parse(BigDecimal.class, map.get(AssetLabelLayoutVOMeta.ROW_HEIGHT)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetLabelLayoutVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetLabelLayoutVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetLabelLayoutVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetLabelLayoutVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetLabelLayoutVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetLabelLayoutVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetLabelLayoutVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setRowSpan( (Integer)map.get(AssetLabelLayoutVOMeta.ROW_SPAN));
				this.setColSpan( (Integer)map.get(AssetLabelLayoutVOMeta.COL_SPAN));
				this.setColCode( (String)map.get(AssetLabelLayoutVOMeta.COL_CODE));
				this.setUpdateTime( (Date)map.get(AssetLabelLayoutVOMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(AssetLabelLayoutVOMeta.SORT));
				this.setType( (String)map.get(AssetLabelLayoutVOMeta.TYPE));
				this.setVersion( (Integer)map.get(AssetLabelLayoutVOMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetLabelLayoutVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetLabelLayoutVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetLabelLayoutVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetLabelLayoutVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetLabelLayoutVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(AssetLabelLayoutVOMeta.DELETE_BY));
				this.setId( (String)map.get(AssetLabelLayoutVOMeta.ID));
				this.setTplId( (String)map.get(AssetLabelLayoutVOMeta.TPL_ID));
				this.setColId( (String)map.get(AssetLabelLayoutVOMeta.COL_ID));
				this.setRowNumber( (Integer)map.get(AssetLabelLayoutVOMeta.ROW_NUMBER));
				this.setRowHeight( (BigDecimal)map.get(AssetLabelLayoutVOMeta.ROW_HEIGHT));
				// others
				this.setSearchField( (String)map.get(AssetLabelLayoutVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(AssetLabelLayoutVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetLabelLayoutVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(AssetLabelLayoutVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(AssetLabelLayoutVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(AssetLabelLayoutVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(AssetLabelLayoutVOMeta.SEARCH_VALUE));
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
			this.setRowSpan(DataParser.parse(Integer.class, r.getValue(AssetLabelLayoutVOMeta.ROW_SPAN)));
			this.setColSpan(DataParser.parse(Integer.class, r.getValue(AssetLabelLayoutVOMeta.COL_SPAN)));
			this.setColCode(DataParser.parse(String.class, r.getValue(AssetLabelLayoutVOMeta.COL_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetLabelLayoutVOMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(AssetLabelLayoutVOMeta.SORT)));
			this.setType(DataParser.parse(String.class, r.getValue(AssetLabelLayoutVOMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetLabelLayoutVOMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetLabelLayoutVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetLabelLayoutVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetLabelLayoutVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetLabelLayoutVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetLabelLayoutVOMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetLabelLayoutVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetLabelLayoutVOMeta.ID)));
			this.setTplId(DataParser.parse(String.class, r.getValue(AssetLabelLayoutVOMeta.TPL_ID)));
			this.setColId(DataParser.parse(String.class, r.getValue(AssetLabelLayoutVOMeta.COL_ID)));
			this.setRowNumber(DataParser.parse(Integer.class, r.getValue(AssetLabelLayoutVOMeta.ROW_NUMBER)));
			this.setRowHeight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelLayoutVOMeta.ROW_HEIGHT)));
			return true;
		} else {
			try {
				this.setRowSpan( (Integer)r.getValue(AssetLabelLayoutVOMeta.ROW_SPAN));
				this.setColSpan( (Integer)r.getValue(AssetLabelLayoutVOMeta.COL_SPAN));
				this.setColCode( (String)r.getValue(AssetLabelLayoutVOMeta.COL_CODE));
				this.setUpdateTime( (Date)r.getValue(AssetLabelLayoutVOMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(AssetLabelLayoutVOMeta.SORT));
				this.setType( (String)r.getValue(AssetLabelLayoutVOMeta.TYPE));
				this.setVersion( (Integer)r.getValue(AssetLabelLayoutVOMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetLabelLayoutVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetLabelLayoutVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetLabelLayoutVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetLabelLayoutVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetLabelLayoutVOMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(AssetLabelLayoutVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetLabelLayoutVOMeta.ID));
				this.setTplId( (String)r.getValue(AssetLabelLayoutVOMeta.TPL_ID));
				this.setColId( (String)r.getValue(AssetLabelLayoutVOMeta.COL_ID));
				this.setRowNumber( (Integer)r.getValue(AssetLabelLayoutVOMeta.ROW_NUMBER));
				this.setRowHeight( (BigDecimal)r.getValue(AssetLabelLayoutVOMeta.ROW_HEIGHT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}