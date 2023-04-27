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
import com.dt.platform.domain.eam.meta.AssetCollectionVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Organization;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 资产领用VO类型
 * <p>资产领用 , 数据表 eam_asset_collection 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-14 16:09:23
 * @sign F26C67BE0E00579ADDA7738B60E8E6E4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "资产领用VO类型 ; 资产领用 , 数据表 eam_asset_collection 的通用VO类型" , parent = AssetCollection.class)
public class AssetCollectionVO extends AssetCollection {

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
	 * 数据来源：前端指定不同的来源，后端按来源执行不同的逻辑
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "前端指定不同的来源，后端按来源执行不同的逻辑")
	private String dataOrigin;
	
	/**
	 * 查询逻辑：默认and，可指定 or 
	*/
	@ApiModelProperty(required = false,value="查询逻辑" , notes = "默认and，可指定 or ")
	private String queryLogic;
	
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
	public AssetCollectionVO setPageIndex(Integer pageIndex) {
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
	public AssetCollectionVO setPageSize(Integer pageSize) {
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
	public AssetCollectionVO setSearchField(String searchField) {
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
	public AssetCollectionVO setFuzzyField(String fuzzyField) {
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
	public AssetCollectionVO setSearchValue(String searchValue) {
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
	public AssetCollectionVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetCollectionVO addDirtyField(String... dirtyField) {
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
	public AssetCollectionVO setSortField(String sortField) {
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
	public AssetCollectionVO setSortType(String sortType) {
		this.sortType=sortType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 前端指定不同的来源，后端按来源执行不同的逻辑
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
	public AssetCollectionVO setDataOrigin(String dataOrigin) {
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
	public AssetCollectionVO setQueryLogic(String queryLogic) {
		this.queryLogic=queryLogic;
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
	public AssetCollectionVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetCollectionVO addId(String... id) {
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
	 * @return AssetCollectionVO , 转换好的 AssetCollectionVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetCollectionVO , 转换好的 PoJo 对象
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
	public AssetCollectionVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetCollectionVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetCollectionVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetCollectionVOMeta.$$proxy$$();
		inst.setProcId(this.getProcId());
		inst.setUseOrganizationId(this.getUseOrganizationId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setCollectionDate(this.getCollectionDate());
		inst.setVersion(this.getVersion());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setContent(this.getContent());
		inst.setPositionDetail(this.getPositionDetail());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPositionId(this.getPositionId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setAttach(this.getAttach());
		inst.setUseUserId(this.getUseUserId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setAssetIds(this.getAssetIds());
			inst.setPageSize(this.getPageSize());
			inst.setOriginator(this.getOriginator());
			inst.setAssetList(this.getAssetList());
			inst.setOriginatorUserName(this.getOriginatorUserName());
			inst.setUseOrganization(this.getUseOrganization());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
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
	public AssetCollectionVO clone(boolean deep) {
		return EntityContext.clone(AssetCollectionVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetCollectionVO
	 * @param assetCollectionMap 包含实体信息的 Map 对象
	 * @return AssetCollectionVO , 转换好的的 AssetCollection 对象
	*/
	@Transient
	public static AssetCollectionVO createFrom(Map<String,Object> assetCollectionMap) {
		if(assetCollectionMap==null) return null;
		AssetCollectionVO vo = create();
		EntityContext.copyProperties(vo,assetCollectionMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetCollectionVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetCollectionVO , 转换好的的 AssetCollection 对象
	*/
	@Transient
	public static AssetCollectionVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetCollectionVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetCollectionVO，等同于 new
	 * @return AssetCollectionVO 对象
	*/
	@Transient
	public static AssetCollectionVO create() {
		return new com.dt.platform.domain.eam.meta.AssetCollectionVOMeta.$$proxy$$();
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
			this.setProcId(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.PROC_ID)));
			this.setUseOrganizationId(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.USE_ORGANIZATION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetCollectionVOMeta.UPDATE_TIME)));
			this.setCollectionDate(DataParser.parse(Date.class, map.get(AssetCollectionVOMeta.COLLECTION_DATE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetCollectionVOMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.CONTENT)));
			this.setPositionDetail(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.POSITION_DETAIL)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetCollectionVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetCollectionVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetCollectionVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetCollectionVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.ATTACH)));
			this.setUseUserId(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.USE_USER_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetCollectionVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetCollectionVOMeta.ORIGINATOR)));
			this.setOriginatorUserName(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.ORIGINATOR_USER_NAME)));
			this.setUseOrganization(DataParser.parse(Organization.class, map.get(AssetCollectionVOMeta.USE_ORGANIZATION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetCollectionVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.QUERY_LOGIC)));
			this.setPosition(DataParser.parse(Position.class, map.get(AssetCollectionVOMeta.POSITION)));
			this.setUseUser(DataParser.parse(Employee.class, map.get(AssetCollectionVOMeta.USE_USER)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetCollectionVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setProcId( (String)map.get(AssetCollectionVOMeta.PROC_ID));
				this.setUseOrganizationId( (String)map.get(AssetCollectionVOMeta.USE_ORGANIZATION_ID));
				this.setUpdateTime( (Date)map.get(AssetCollectionVOMeta.UPDATE_TIME));
				this.setCollectionDate( (Date)map.get(AssetCollectionVOMeta.COLLECTION_DATE));
				this.setVersion( (Integer)map.get(AssetCollectionVOMeta.VERSION));
				this.setSelectedCode( (String)map.get(AssetCollectionVOMeta.SELECTED_CODE));
				this.setContent( (String)map.get(AssetCollectionVOMeta.CONTENT));
				this.setPositionDetail( (String)map.get(AssetCollectionVOMeta.POSITION_DETAIL));
				this.setBusinessDate( (Date)map.get(AssetCollectionVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetCollectionVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(AssetCollectionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetCollectionVOMeta.DELETED));
				this.setPositionId( (String)map.get(AssetCollectionVOMeta.POSITION_ID));
				this.setCreateTime( (Date)map.get(AssetCollectionVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetCollectionVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetCollectionVOMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetCollectionVOMeta.NAME));
				this.setTenantId( (String)map.get(AssetCollectionVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetCollectionVOMeta.DELETE_BY));
				this.setId( (String)map.get(AssetCollectionVOMeta.ID));
				this.setOriginatorId( (String)map.get(AssetCollectionVOMeta.ORIGINATOR_ID));
				this.setAttach( (String)map.get(AssetCollectionVOMeta.ATTACH));
				this.setUseUserId( (String)map.get(AssetCollectionVOMeta.USE_USER_ID));
				this.setStatus( (String)map.get(AssetCollectionVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(AssetCollectionVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(AssetCollectionVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetCollectionVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(AssetCollectionVOMeta.ORIGINATOR));
				this.setOriginatorUserName( (String)map.get(AssetCollectionVOMeta.ORIGINATOR_USER_NAME));
				this.setUseOrganization( (Organization)map.get(AssetCollectionVOMeta.USE_ORGANIZATION));
				this.setPageIndex( (Integer)map.get(AssetCollectionVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetCollectionVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssetCollectionVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(AssetCollectionVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(AssetCollectionVOMeta.QUERY_LOGIC));
				this.setPosition( (Position)map.get(AssetCollectionVOMeta.POSITION));
				this.setUseUser( (Employee)map.get(AssetCollectionVOMeta.USE_USER));
				this.setSearchValue( (String)map.get(AssetCollectionVOMeta.SEARCH_VALUE));
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
			this.setProcId(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.PROC_ID)));
			this.setUseOrganizationId(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.USE_ORGANIZATION_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetCollectionVOMeta.UPDATE_TIME)));
			this.setCollectionDate(DataParser.parse(Date.class, r.getValue(AssetCollectionVOMeta.COLLECTION_DATE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetCollectionVOMeta.VERSION)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.SELECTED_CODE)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.CONTENT)));
			this.setPositionDetail(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.POSITION_DETAIL)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetCollectionVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetCollectionVOMeta.DELETED)));
			this.setPositionId(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.POSITION_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetCollectionVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetCollectionVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.ORIGINATOR_ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.ATTACH)));
			this.setUseUserId(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.USE_USER_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetCollectionVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setProcId( (String)r.getValue(AssetCollectionVOMeta.PROC_ID));
				this.setUseOrganizationId( (String)r.getValue(AssetCollectionVOMeta.USE_ORGANIZATION_ID));
				this.setUpdateTime( (Date)r.getValue(AssetCollectionVOMeta.UPDATE_TIME));
				this.setCollectionDate( (Date)r.getValue(AssetCollectionVOMeta.COLLECTION_DATE));
				this.setVersion( (Integer)r.getValue(AssetCollectionVOMeta.VERSION));
				this.setSelectedCode( (String)r.getValue(AssetCollectionVOMeta.SELECTED_CODE));
				this.setContent( (String)r.getValue(AssetCollectionVOMeta.CONTENT));
				this.setPositionDetail( (String)r.getValue(AssetCollectionVOMeta.POSITION_DETAIL));
				this.setBusinessDate( (Date)r.getValue(AssetCollectionVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetCollectionVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(AssetCollectionVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetCollectionVOMeta.DELETED));
				this.setPositionId( (String)r.getValue(AssetCollectionVOMeta.POSITION_ID));
				this.setCreateTime( (Date)r.getValue(AssetCollectionVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetCollectionVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetCollectionVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetCollectionVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetCollectionVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetCollectionVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetCollectionVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetCollectionVOMeta.ORIGINATOR_ID));
				this.setAttach( (String)r.getValue(AssetCollectionVOMeta.ATTACH));
				this.setUseUserId( (String)r.getValue(AssetCollectionVOMeta.USE_USER_ID));
				this.setStatus( (String)r.getValue(AssetCollectionVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}