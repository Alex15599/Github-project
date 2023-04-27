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
import com.dt.platform.domain.eam.meta.AssetStorageVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产入库VO类型
 * <p>资产入库 , 数据表 eam_asset_storage 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-07 15:34:13
 * @sign 3AA4F2FF7FE8561DEE3ED66253416EED
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产入库VO类型 ; 资产入库 , 数据表 eam_asset_storage 的通用VO类型" , parent = AssetStorage.class)
public class AssetStorageVO extends AssetStorage {

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
	 * 数据来源：前端指定不同的来源，后端可按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端可按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
	/**
	 * 请求动作：前端指定不同的Action，后端可Action执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="请求动作" , notes = "前端指定不同的Action，后端可Action执行不同的逻辑")
	private String requestAction;
	
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
	public AssetStorageVO setPageIndex(Integer pageIndex) {
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
	public AssetStorageVO setPageSize(Integer pageSize) {
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
	public AssetStorageVO setSearchField(String searchField) {
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
	public AssetStorageVO setFuzzyField(String fuzzyField) {
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
	public AssetStorageVO setSearchValue(String searchValue) {
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
	public AssetStorageVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetStorageVO addDirtyField(String... dirtyField) {
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
	public AssetStorageVO setSortField(String sortField) {
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
	public AssetStorageVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端可按来源执行不同的逻辑
	 * @return 数据来源
	*/
	public String getDataOrigin() {
		return dataOrigin;
	}
	
	/**
	 * 设置 数据来源
	 * @param dataOrigin 数据来源
	 * @return 当前对象
	*/
	public AssetStorageVO setDataOrigin(String dataOrigin) {
		this.dataOrigin=dataOrigin;
		return this;
	}
	
	/**
	 * 获得 查询逻辑<br>
	 * 默认and，可指定 or 
	 * @return 查询逻辑
	*/
	public String getQueryLogic() {
		return queryLogic;
	}
	
	/**
	 * 设置 查询逻辑
	 * @param queryLogic 查询逻辑
	 * @return 当前对象
	*/
	public AssetStorageVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
		return this;
	}
	
	/**
	 * 获得 请求动作<br>
	 * 前端指定不同的Action，后端可Action执行不同的逻辑
	 * @return 请求动作
	*/
	public String getRequestAction() {
		return requestAction;
	}
	
	/**
	 * 设置 请求动作
	 * @param requestAction 请求动作
	 * @return 当前对象
	*/
	public AssetStorageVO setRequestAction(String requestAction) {
		this.requestAction=requestAction;
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
	public AssetStorageVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetStorageVO addId(String... id) {
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
	 * @return AssetStorageVO , 转换好的 AssetStorageVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetStorageVO , 转换好的 PoJo 对象
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
	public AssetStorageVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetStorageVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetStorageVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetStorageVOMeta.$$proxy$$();
		inst.setSupplierId(this.getSupplierId());
		inst.setProcId(this.getProcId());
		inst.setCustomData(this.getCustomData());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setSupplierInfo(this.getSupplierInfo());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setId(this.getId());
		inst.setAttach(this.getAttach());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setLocationName(this.getLocationName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setOwnCompanyId(this.getOwnCompanyId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setManagerUserId(this.getManagerUserId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOwnerCompany(this.getOwnerCompany());
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setAssetIds(this.getAssetIds());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setOriginatorUserName(this.getOriginatorUserName());
			inst.setManagerUser(this.getManagerUser());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setSupplier(this.getSupplier());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetStorageVO clone(boolean deep) {
		return EntityContext.clone(AssetStorageVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetStorageVO
	 * @param assetStorageMap 包含实体信息的 Map 对象
	 * @return AssetStorageVO , 转换好的的 AssetStorage 对象
	*/
	@Transient
	public static AssetStorageVO createFrom(Map<String,Object> assetStorageMap) {
		if(assetStorageMap==null) return null;
		AssetStorageVO vo = create();
		EntityContext.copyProperties(vo,assetStorageMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetStorageVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetStorageVO , 转换好的的 AssetStorage 对象
	*/
	@Transient
	public static AssetStorageVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetStorageVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetStorageVO，等同于 new
	 * @return AssetStorageVO 对象
	*/
	@Transient
	public static AssetStorageVO create() {
		return new com.dt.platform.domain.eam.meta.AssetStorageVOMeta.$$proxy$$();
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
			this.setSupplierId(DataParser.parse(String.class, map.get(AssetStorageVOMeta.SUPPLIER_ID)));
			this.setProcId(DataParser.parse(String.class, map.get(AssetStorageVOMeta.PROC_ID)));
			this.setCustomData(DataParser.parse(String.class, map.get(AssetStorageVOMeta.CUSTOM_DATA)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetStorageVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetStorageVOMeta.CONTENT)));
			this.setSupplierInfo(DataParser.parse(String.class, map.get(AssetStorageVOMeta.SUPPLIER_INFO)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetStorageVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetStorageVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetStorageVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetStorageVOMeta.ID)));
			this.setAttach(DataParser.parse(String.class, map.get(AssetStorageVOMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetStorageVOMeta.ORIGINATOR_ID)));
			this.setLocationName(DataParser.parse(String.class, map.get(AssetStorageVOMeta.LOCATION_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetStorageVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetStorageVOMeta.VERSION)));
			this.setOwnCompanyId(DataParser.parse(String.class, map.get(AssetStorageVOMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetStorageVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetStorageVOMeta.DELETED)));
			this.setManagerUserId(DataParser.parse(String.class, map.get(AssetStorageVOMeta.MANAGER_USER_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetStorageVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetStorageVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetStorageVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetStorageVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetStorageVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetStorageVOMeta.STATUS)));
			// others
			this.setOwnerCompany(DataParser.parse(Organization.class, map.get(AssetStorageVOMeta.OWNER_COMPANY)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssetStorageVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(AssetStorageVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetStorageVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetStorageVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetStorageVOMeta.ORIGINATOR)));
			this.setOriginatorUserName(DataParser.parse(String.class, map.get(AssetStorageVOMeta.ORIGINATOR_USER_NAME)));
			this.setManagerUser(DataParser.parse(Employee.class, map.get(AssetStorageVOMeta.MANAGER_USER)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetStorageVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetStorageVOMeta.SORT_TYPE)));
			this.setSupplier(DataParser.parse(Supplier.class, map.get(AssetStorageVOMeta.SUPPLIER)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetStorageVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssetStorageVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssetStorageVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetStorageVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setSupplierId( (String)map.get(AssetStorageVOMeta.SUPPLIER_ID));
				this.setProcId( (String)map.get(AssetStorageVOMeta.PROC_ID));
				this.setCustomData( (String)map.get(AssetStorageVOMeta.CUSTOM_DATA));
				this.setSelectedCode( (String)map.get(AssetStorageVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetStorageVOMeta.CONTENT));
				this.setSupplierInfo( (String)map.get(AssetStorageVOMeta.SUPPLIER_INFO));
				this.setBusinessDate( (Date)map.get(AssetStorageVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetStorageVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)map.get(AssetStorageVOMeta.UPDATE_BY));
				this.setId( (String)map.get(AssetStorageVOMeta.ID));
				this.setAttach( (String)map.get(AssetStorageVOMeta.ATTACH));
				this.setOriginatorId( (String)map.get(AssetStorageVOMeta.ORIGINATOR_ID));
				this.setLocationName( (String)map.get(AssetStorageVOMeta.LOCATION_NAME));
				this.setUpdateTime( (Date)map.get(AssetStorageVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetStorageVOMeta.VERSION));
				this.setOwnCompanyId( (String)map.get(AssetStorageVOMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)map.get(AssetStorageVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetStorageVOMeta.DELETED));
				this.setManagerUserId( (String)map.get(AssetStorageVOMeta.MANAGER_USER_ID));
				this.setCreateTime( (Date)map.get(AssetStorageVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetStorageVOMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetStorageVOMeta.NAME));
				this.setTenantId( (String)map.get(AssetStorageVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetStorageVOMeta.DELETE_BY));
				this.setStatus( (String)map.get(AssetStorageVOMeta.STATUS));
				// others
				this.setOwnerCompany( (Organization)map.get(AssetStorageVOMeta.OWNER_COMPANY));
				this.setSearchField( (String)map.get(AssetStorageVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(AssetStorageVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(AssetStorageVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetStorageVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(AssetStorageVOMeta.ORIGINATOR));
				this.setOriginatorUserName( (String)map.get(AssetStorageVOMeta.ORIGINATOR_USER_NAME));
				this.setManagerUser( (Employee)map.get(AssetStorageVOMeta.MANAGER_USER));
				this.setPageIndex( (Integer)map.get(AssetStorageVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetStorageVOMeta.SORT_TYPE));
				this.setSupplier( (Supplier)map.get(AssetStorageVOMeta.SUPPLIER));
				this.setSortField( (String)map.get(AssetStorageVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssetStorageVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AssetStorageVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(AssetStorageVOMeta.SEARCH_VALUE));
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
			this.setSupplierId(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.SUPPLIER_ID)));
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.PROC_ID)));
			this.setCustomData(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.CUSTOM_DATA)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.CONTENT)));
			this.setSupplierInfo(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.SUPPLIER_INFO)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetStorageVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.BUSINESS_CODE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.UPDATE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.ORIGINATOR_ID)));
			this.setLocationName(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.LOCATION_NAME)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetStorageVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetStorageVOMeta.VERSION)));
			this.setOwnCompanyId(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.OWN_COMPANY_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetStorageVOMeta.DELETED)));
			this.setManagerUserId(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.MANAGER_USER_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetStorageVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetStorageVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.DELETE_BY)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetStorageVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setSupplierId( (String)r.getValue(AssetStorageVOMeta.SUPPLIER_ID));
				this.setProcId( (String)r.getValue(AssetStorageVOMeta.PROC_ID));
				this.setCustomData( (String)r.getValue(AssetStorageVOMeta.CUSTOM_DATA));
				this.setSelectedCode( (String)r.getValue(AssetStorageVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetStorageVOMeta.CONTENT));
				this.setSupplierInfo( (String)r.getValue(AssetStorageVOMeta.SUPPLIER_INFO));
				this.setBusinessDate( (Date)r.getValue(AssetStorageVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetStorageVOMeta.BUSINESS_CODE));
				this.setUpdateBy( (String)r.getValue(AssetStorageVOMeta.UPDATE_BY));
				this.setId( (String)r.getValue(AssetStorageVOMeta.ID));
				this.setAttach( (String)r.getValue(AssetStorageVOMeta.ATTACH));
				this.setOriginatorId( (String)r.getValue(AssetStorageVOMeta.ORIGINATOR_ID));
				this.setLocationName( (String)r.getValue(AssetStorageVOMeta.LOCATION_NAME));
				this.setUpdateTime( (Date)r.getValue(AssetStorageVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetStorageVOMeta.VERSION));
				this.setOwnCompanyId( (String)r.getValue(AssetStorageVOMeta.OWN_COMPANY_ID));
				this.setCreateBy( (String)r.getValue(AssetStorageVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetStorageVOMeta.DELETED));
				this.setManagerUserId( (String)r.getValue(AssetStorageVOMeta.MANAGER_USER_ID));
				this.setCreateTime( (Date)r.getValue(AssetStorageVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetStorageVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetStorageVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetStorageVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetStorageVOMeta.DELETE_BY));
				this.setStatus( (String)r.getValue(AssetStorageVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}