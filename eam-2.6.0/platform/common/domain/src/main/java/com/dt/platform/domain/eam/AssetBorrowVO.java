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
import com.dt.platform.domain.eam.meta.AssetBorrowVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产借用VO类型
 * <p>资产借用 , 数据表 eam_asset_borrow 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-13 09:02:44
 * @sign 0672F52F4172AB6780A36A868D31982F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产借用VO类型 ; 资产借用 , 数据表 eam_asset_borrow 的通用VO类型" , parent = AssetBorrow.class)
public class AssetBorrowVO extends AssetBorrow {

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
	public AssetBorrowVO setPageIndex(Integer pageIndex) {
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
	public AssetBorrowVO setPageSize(Integer pageSize) {
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
	public AssetBorrowVO setSearchField(String searchField) {
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
	public AssetBorrowVO setFuzzyField(String fuzzyField) {
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
	public AssetBorrowVO setSearchValue(String searchValue) {
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
	public AssetBorrowVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetBorrowVO addDirtyField(String... dirtyField) {
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
	public AssetBorrowVO setSortField(String sortField) {
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
	public AssetBorrowVO setSortType(String sortType) {
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
	public AssetBorrowVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetBorrowVO addId(String... id) {
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
	 * @return AssetBorrowVO , 转换好的 AssetBorrowVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetBorrowVO , 转换好的 PoJo 对象
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
	public AssetBorrowVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetBorrowVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetBorrowVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetBorrowVOMeta.$$proxy$$();
		inst.setBorrowerId(this.getBorrowerId());
		inst.setPlanReturnDate(this.getPlanReturnDate());
		inst.setProcId(this.getProcId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setReturnDate(this.getReturnDate());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setBorrowStatus(this.getBorrowStatus());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setBorrowTime(this.getBorrowTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttach(this.getAttach());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setBorrower(this.getBorrower());
			inst.setAssetIds(this.getAssetIds());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setOriginatorUserName(this.getOriginatorUserName());
			inst.setAssetItemList(this.getAssetItemList());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
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
	public AssetBorrowVO clone(boolean deep) {
		return EntityContext.clone(AssetBorrowVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetBorrowVO
	 * @param assetBorrowMap 包含实体信息的 Map 对象
	 * @return AssetBorrowVO , 转换好的的 AssetBorrow 对象
	*/
	@Transient
	public static AssetBorrowVO createFrom(Map<String,Object> assetBorrowMap) {
		if(assetBorrowMap==null) return null;
		AssetBorrowVO vo = create();
		EntityContext.copyProperties(vo,assetBorrowMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetBorrowVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetBorrowVO , 转换好的的 AssetBorrow 对象
	*/
	@Transient
	public static AssetBorrowVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetBorrowVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetBorrowVO，等同于 new
	 * @return AssetBorrowVO 对象
	*/
	@Transient
	public static AssetBorrowVO create() {
		return new com.dt.platform.domain.eam.meta.AssetBorrowVOMeta.$$proxy$$();
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
			this.setBorrowerId(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.BORROWER_ID)));
			this.setPlanReturnDate(DataParser.parse(Date.class, map.get(AssetBorrowVOMeta.PLAN_RETURN_DATE)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.PROC_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetBorrowVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetBorrowVOMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetBorrowVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.BUSINESS_CODE)));
			this.setReturnDate(DataParser.parse(Date.class, map.get(AssetBorrowVOMeta.RETURN_DATE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetBorrowVOMeta.DELETED)));
			this.setBorrowStatus(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.BORROW_STATUS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetBorrowVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetBorrowVOMeta.DELETE_TIME)));
			this.setBorrowTime(DataParser.parse(Date.class, map.get(AssetBorrowVOMeta.BORROW_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.ATTACH)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.FUZZY_FIELD)));
			this.setBorrower(DataParser.parse(Employee.class, map.get(AssetBorrowVOMeta.BORROWER)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetBorrowVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetBorrowVOMeta.ORIGINATOR)));
			this.setOriginatorUserName(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.ORIGINATOR_USER_NAME)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetBorrowVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.SORT_FIELD)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetBorrowVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setBorrowerId( (String)map.get(AssetBorrowVOMeta.BORROWER_ID));
				this.setPlanReturnDate( (Date)map.get(AssetBorrowVOMeta.PLAN_RETURN_DATE));
				this.setProcId( (String)map.get(AssetBorrowVOMeta.PROC_ID));
				this.setUpdateTime( (Date)map.get(AssetBorrowVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetBorrowVOMeta.VERSION));
				this.setSelectedCode( (String)map.get(AssetBorrowVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetBorrowVOMeta.CONTENT));
				this.setBusinessDate( (Date)map.get(AssetBorrowVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetBorrowVOMeta.BUSINESS_CODE));
				this.setReturnDate( (Date)map.get(AssetBorrowVOMeta.RETURN_DATE));
				this.setCreateBy( (String)map.get(AssetBorrowVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetBorrowVOMeta.DELETED));
				this.setBorrowStatus( (String)map.get(AssetBorrowVOMeta.BORROW_STATUS));
				this.setCreateTime( (Date)map.get(AssetBorrowVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetBorrowVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetBorrowVOMeta.DELETE_TIME));
				this.setBorrowTime( (Date)map.get(AssetBorrowVOMeta.BORROW_TIME));
				this.setName( (String)map.get(AssetBorrowVOMeta.NAME));
				this.setTenantId( (String)map.get(AssetBorrowVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetBorrowVOMeta.DELETE_BY));
				this.setId( (String)map.get(AssetBorrowVOMeta.ID));
				this.setOriginatorId( (String)map.get(AssetBorrowVOMeta.ORIGINATOR_ID));
				this.setAttach( (String)map.get(AssetBorrowVOMeta.ATTACH));
				this.setStatus( (String)map.get(AssetBorrowVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(AssetBorrowVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(AssetBorrowVOMeta.FUZZY_FIELD));
				this.setBorrower( (Employee)map.get(AssetBorrowVOMeta.BORROWER));
				this.setPageSize( (Integer)map.get(AssetBorrowVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(AssetBorrowVOMeta.ORIGINATOR));
				this.setOriginatorUserName( (String)map.get(AssetBorrowVOMeta.ORIGINATOR_USER_NAME));
				this.setPageIndex( (Integer)map.get(AssetBorrowVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetBorrowVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssetBorrowVOMeta.SORT_FIELD));
				this.setSearchValue( (String)map.get(AssetBorrowVOMeta.SEARCH_VALUE));
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
			this.setBorrowerId(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.BORROWER_ID)));
			this.setPlanReturnDate(DataParser.parse(Date.class, r.getValue(AssetBorrowVOMeta.PLAN_RETURN_DATE)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.PROC_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetBorrowVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetBorrowVOMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetBorrowVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.BUSINESS_CODE)));
			this.setReturnDate(DataParser.parse(Date.class, r.getValue(AssetBorrowVOMeta.RETURN_DATE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetBorrowVOMeta.DELETED)));
			this.setBorrowStatus(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.BORROW_STATUS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetBorrowVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetBorrowVOMeta.DELETE_TIME)));
			this.setBorrowTime(DataParser.parse(Date.class, r.getValue(AssetBorrowVOMeta.BORROW_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.ATTACH)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetBorrowVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setBorrowerId( (String)r.getValue(AssetBorrowVOMeta.BORROWER_ID));
				this.setPlanReturnDate( (Date)r.getValue(AssetBorrowVOMeta.PLAN_RETURN_DATE));
				this.setProcId( (String)r.getValue(AssetBorrowVOMeta.PROC_ID));
				this.setUpdateTime( (Date)r.getValue(AssetBorrowVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetBorrowVOMeta.VERSION));
				this.setSelectedCode( (String)r.getValue(AssetBorrowVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetBorrowVOMeta.CONTENT));
				this.setBusinessDate( (Date)r.getValue(AssetBorrowVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetBorrowVOMeta.BUSINESS_CODE));
				this.setReturnDate( (Date)r.getValue(AssetBorrowVOMeta.RETURN_DATE));
				this.setCreateBy( (String)r.getValue(AssetBorrowVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetBorrowVOMeta.DELETED));
				this.setBorrowStatus( (String)r.getValue(AssetBorrowVOMeta.BORROW_STATUS));
				this.setCreateTime( (Date)r.getValue(AssetBorrowVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetBorrowVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetBorrowVOMeta.DELETE_TIME));
				this.setBorrowTime( (Date)r.getValue(AssetBorrowVOMeta.BORROW_TIME));
				this.setName( (String)r.getValue(AssetBorrowVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetBorrowVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetBorrowVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetBorrowVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetBorrowVOMeta.ORIGINATOR_ID));
				this.setAttach( (String)r.getValue(AssetBorrowVOMeta.ATTACH));
				this.setStatus( (String)r.getValue(AssetBorrowVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}