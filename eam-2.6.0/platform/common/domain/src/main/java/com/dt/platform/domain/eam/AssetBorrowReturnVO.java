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
import com.dt.platform.domain.eam.meta.AssetBorrowReturnVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产归还VO类型
 * <p>资产归还 , 数据表 eam_asset_borrow_return 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-13 18:22:44
 * @sign 844E952B3002F903D117C82E617C31F4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产归还VO类型 ; 资产归还 , 数据表 eam_asset_borrow_return 的通用VO类型" , parent = AssetBorrowReturn.class)
public class AssetBorrowReturnVO extends AssetBorrowReturn {

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
	public AssetBorrowReturnVO setPageIndex(Integer pageIndex) {
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
	public AssetBorrowReturnVO setPageSize(Integer pageSize) {
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
	public AssetBorrowReturnVO setSearchField(String searchField) {
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
	public AssetBorrowReturnVO setFuzzyField(String fuzzyField) {
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
	public AssetBorrowReturnVO setSearchValue(String searchValue) {
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
	public AssetBorrowReturnVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetBorrowReturnVO addDirtyField(String... dirtyField) {
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
	public AssetBorrowReturnVO setSortField(String sortField) {
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
	public AssetBorrowReturnVO setSortType(String sortType) {
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
	public AssetBorrowReturnVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetBorrowReturnVO addId(String... id) {
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
	 * @return AssetBorrowReturnVO , 转换好的 AssetBorrowReturnVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetBorrowReturnVO , 转换好的 PoJo 对象
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
	public AssetBorrowReturnVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetBorrowReturnVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetBorrowReturnVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetBorrowReturnVOMeta.$$proxy$$();
		inst.setProcId(this.getProcId());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setReturnDate(this.getReturnDate());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttach(this.getAttach());
		inst.setUseOrganizationId(this.getUseOrganizationId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setManagerId(this.getManagerId());
		inst.setVersion(this.getVersion());
		inst.setPositionDetail(this.getPositionDetail());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUseUserId(this.getUseUserId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setManager(this.getManager());
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setAssetIds(this.getAssetIds());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setOriginatorUserName(this.getOriginatorUserName());
			inst.setAssetItemList(this.getAssetItemList());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setIds(this.getIds());
			inst.setPosition(this.getPosition());
			inst.setUseUser(this.getUseUser());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetBorrowReturnVO clone(boolean deep) {
		return EntityContext.clone(AssetBorrowReturnVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetBorrowReturnVO
	 * @param assetBorrowReturnMap 包含实体信息的 Map 对象
	 * @return AssetBorrowReturnVO , 转换好的的 AssetBorrowReturn 对象
	*/
	@Transient
	public static AssetBorrowReturnVO createFrom(Map<String,Object> assetBorrowReturnMap) {
		if(assetBorrowReturnMap==null) return null;
		AssetBorrowReturnVO vo = create();
		EntityContext.copyProperties(vo,assetBorrowReturnMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetBorrowReturnVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetBorrowReturnVO , 转换好的的 AssetBorrowReturn 对象
	*/
	@Transient
	public static AssetBorrowReturnVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetBorrowReturnVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetBorrowReturnVO，等同于 new
	 * @return AssetBorrowReturnVO 对象
	*/
	@Transient
	public static AssetBorrowReturnVO create() {
		return new com.dt.platform.domain.eam.meta.AssetBorrowReturnVOMeta.$$proxy$$();
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
			this.setProcId(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.PROC_ID)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetBorrowReturnVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.BUSINESS_CODE)));
			this.setReturnDate(DataParser.parse(Date.class, map.get(AssetBorrowReturnVOMeta.RETURN_DATE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.ATTACH)));
			this.setUseOrganizationId(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.USE_ORGANIZATION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetBorrowReturnVOMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.MANAGER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetBorrowReturnVOMeta.VERSION)));
			this.setPositionDetail(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.POSITION_DETAIL)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetBorrowReturnVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetBorrowReturnVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetBorrowReturnVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.DELETE_BY)));
			this.setUseUserId(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.USE_USER_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.STATUS)));
			// others
			this.setManager(DataParser.parse(Employee.class, map.get(AssetBorrowReturnVOMeta.MANAGER)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetBorrowReturnVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetBorrowReturnVOMeta.ORIGINATOR)));
			this.setOriginatorUserName(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.ORIGINATOR_USER_NAME)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(AssetBorrowReturnVOMeta.USE_ORGANIZATION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetBorrowReturnVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.SORT_FIELD)));
			this.setPosition(DataParser.parse(Position.class, map.get(AssetBorrowReturnVOMeta.POSITION)));
			this.setUseUser(DataParser.parse(Employee.class, map.get(AssetBorrowReturnVOMeta.USE_USER)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetBorrowReturnVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setProcId( (String)map.get(AssetBorrowReturnVOMeta.PROC_ID));
				this.setSelectedCode( (String)map.get(AssetBorrowReturnVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetBorrowReturnVOMeta.CONTENT));
				this.setBusinessDate( (Date)map.get(AssetBorrowReturnVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetBorrowReturnVOMeta.BUSINESS_CODE));
				this.setReturnDate( (Date)map.get(AssetBorrowReturnVOMeta.RETURN_DATE));
				this.setUpdateBy( (String)map.get(AssetBorrowReturnVOMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetBorrowReturnVOMeta.ID));
				this.setOriginatorId( (String)map.get(AssetBorrowReturnVOMeta.ORIGINATOR_ID));
				this.setAttach( (String)map.get(AssetBorrowReturnVOMeta.ATTACH));
				this.setUseOrganizationId( (String)map.get(AssetBorrowReturnVOMeta.USE_ORGANIZATION_ID));
				this.setUpdateTime( (Date)map.get(AssetBorrowReturnVOMeta.UPDATE_TIME));
				this.setManagerId( (String)map.get(AssetBorrowReturnVOMeta.MANAGER_ID));
				this.setVersion( (Integer)map.get(AssetBorrowReturnVOMeta.VERSION));
				this.setPositionDetail( (String)map.get(AssetBorrowReturnVOMeta.POSITION_DETAIL));
				this.setCreateBy( (String)map.get(AssetBorrowReturnVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetBorrowReturnVOMeta.DELETED));
				this.setPositionId( (String)map.get(AssetBorrowReturnVOMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(AssetBorrowReturnVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetBorrowReturnVOMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetBorrowReturnVOMeta.NAME));
				this.setTenantId( (String)map.get(AssetBorrowReturnVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetBorrowReturnVOMeta.DELETE_BY));
				this.setUseUserId( (String)map.get(AssetBorrowReturnVOMeta.USE_USER_ID));
				this.setStatus( (String)map.get(AssetBorrowReturnVOMeta.STATUS));
				// others
				this.setManager( (Employee)map.get(AssetBorrowReturnVOMeta.MANAGER));
				this.setSearchField( (String)map.get(AssetBorrowReturnVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(AssetBorrowReturnVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetBorrowReturnVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(AssetBorrowReturnVOMeta.ORIGINATOR));
				this.setOriginatorUserName( (String)map.get(AssetBorrowReturnVOMeta.ORIGINATOR_USER_NAME));
				this.setUseOrganization( (Organization)map.get(AssetBorrowReturnVOMeta.USE_ORGANIZATION));
				this.setPageIndex( (Integer)map.get(AssetBorrowReturnVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetBorrowReturnVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssetBorrowReturnVOMeta.SORT_FIELD));
				this.setPosition( (Position)map.get(AssetBorrowReturnVOMeta.POSITION));
				this.setUseUser( (Employee)map.get(AssetBorrowReturnVOMeta.USE_USER));
				this.setSearchValue( (String)map.get(AssetBorrowReturnVOMeta.SEARCH_VALUE));
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
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.PROC_ID)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetBorrowReturnVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.BUSINESS_CODE)));
			this.setReturnDate(DataParser.parse(Date.class, r.getValue(AssetBorrowReturnVOMeta.RETURN_DATE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.ATTACH)));
			this.setUseOrganizationId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.USE_ORGANIZATION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetBorrowReturnVOMeta.UPDATE_TIME)));
			this.setManagerId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.MANAGER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetBorrowReturnVOMeta.VERSION)));
			this.setPositionDetail(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.POSITION_DETAIL)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetBorrowReturnVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetBorrowReturnVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetBorrowReturnVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.DELETE_BY)));
			this.setUseUserId(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.USE_USER_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetBorrowReturnVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setProcId( (String)r.getValue(AssetBorrowReturnVOMeta.PROC_ID));
				this.setSelectedCode( (String)r.getValue(AssetBorrowReturnVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetBorrowReturnVOMeta.CONTENT));
				this.setBusinessDate( (Date)r.getValue(AssetBorrowReturnVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetBorrowReturnVOMeta.BUSINESS_CODE));
				this.setReturnDate( (Date)r.getValue(AssetBorrowReturnVOMeta.RETURN_DATE));
				this.setUpdateBy( (String)r.getValue(AssetBorrowReturnVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetBorrowReturnVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetBorrowReturnVOMeta.ORIGINATOR_ID));
				this.setAttach( (String)r.getValue(AssetBorrowReturnVOMeta.ATTACH));
				this.setUseOrganizationId( (String)r.getValue(AssetBorrowReturnVOMeta.USE_ORGANIZATION_ID));
				this.setUpdateTime( (Date)r.getValue(AssetBorrowReturnVOMeta.UPDATE_TIME));
				this.setManagerId( (String)r.getValue(AssetBorrowReturnVOMeta.MANAGER_ID));
				this.setVersion( (Integer)r.getValue(AssetBorrowReturnVOMeta.VERSION));
				this.setPositionDetail( (String)r.getValue(AssetBorrowReturnVOMeta.POSITION_DETAIL));
				this.setCreateBy( (String)r.getValue(AssetBorrowReturnVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetBorrowReturnVOMeta.DELETED));
				this.setPositionId( (String)r.getValue(AssetBorrowReturnVOMeta.POSITION_ID));
				this.setCreateTime( (Date)r.getValue(AssetBorrowReturnVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetBorrowReturnVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetBorrowReturnVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetBorrowReturnVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetBorrowReturnVOMeta.DELETE_BY));
				this.setUseUserId( (String)r.getValue(AssetBorrowReturnVOMeta.USE_USER_ID));
				this.setStatus( (String)r.getValue(AssetBorrowReturnVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}