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
import com.dt.platform.domain.eam.meta.AssetMaintenanceRecordVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.pcm.Catalog;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 维保更新记录VO类型
 * <p>维保更新记录 , 数据表 eam_asset_maintenance_record 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-29 13:55:07
 * @sign 2D6E227CC779714000B12B26C237B860
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "维保更新记录VO类型 ; 维保更新记录 , 数据表 eam_asset_maintenance_record 的通用VO类型" , parent = AssetMaintenanceRecord.class)
public class AssetMaintenanceRecordVO extends AssetMaintenanceRecord {

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
	public AssetMaintenanceRecordVO setPageIndex(Integer pageIndex) {
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
	public AssetMaintenanceRecordVO setPageSize(Integer pageSize) {
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
	public AssetMaintenanceRecordVO setSearchField(String searchField) {
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
	public AssetMaintenanceRecordVO setFuzzyField(String fuzzyField) {
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
	public AssetMaintenanceRecordVO setSearchValue(String searchValue) {
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
	public AssetMaintenanceRecordVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordVO addDirtyField(String... dirtyField) {
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
	public AssetMaintenanceRecordVO setSortField(String sortField) {
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
	public AssetMaintenanceRecordVO setSortType(String sortType) {
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
	public AssetMaintenanceRecordVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordVO addId(String... id) {
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
	 * @return AssetMaintenanceRecordVO , 转换好的 AssetMaintenanceRecordVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetMaintenanceRecordVO , 转换好的 PoJo 对象
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
	public AssetMaintenanceRecordVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetMaintenanceRecordVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetMaintenanceRecordVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetMaintenanceRecordVOMeta.$$proxy$$();
		inst.setMaintenanceStatus(this.getMaintenanceStatus());
		inst.setSMaintenanceStartDate(this.getSMaintenanceStartDate());
		inst.setMaintenanceEndDate(this.getMaintenanceEndDate());
		inst.setSContactInformation(this.getSContactInformation());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setAssetId(this.getAssetId());
		inst.setSuggestMaintenanceMethod(this.getSuggestMaintenanceMethod());
		inst.setId(this.getId());
		inst.setMaintainerName(this.getMaintainerName());
		inst.setSMaintenanceMethod(this.getSMaintenanceMethod());
		inst.setSDirector(this.getSDirector());
		inst.setSContacts(this.getSContacts());
		inst.setSSuggestMaintenanceMethod(this.getSSuggestMaintenanceMethod());
		inst.setSMaintainerName(this.getSMaintainerName());
		inst.setDirector(this.getDirector());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setSMaintenanceNotes(this.getSMaintenanceNotes());
		inst.setSMaintainerId(this.getSMaintainerId());
		inst.setSMaintenanceStatus(this.getSMaintenanceStatus());
		inst.setMaintenanceNotes(this.getMaintenanceNotes());
		inst.setMaintainerId(this.getMaintainerId());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setMaintenanceUpdateId(this.getMaintenanceUpdateId());
		inst.setTenantId(this.getTenantId());
		inst.setMaintenanceMethod(this.getMaintenanceMethod());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setMaintenanceStartDate(this.getMaintenanceStartDate());
		inst.setSMaintenanceEndDate(this.getSMaintenanceEndDate());
		inst.setContacts(this.getContacts());
		if(all) {
			inst.setAssetAssetName(this.getAssetAssetName());
			inst.setSuggestMaintenanceMethodData(this.getSuggestMaintenanceMethodData());
			inst.setAssetAssetStatus(this.getAssetAssetStatus());
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setAssetAssetCode(this.getAssetAssetCode());
			inst.setPageSize(this.getPageSize());
			inst.setAssetAssetCatalog(this.getAssetAssetCatalog());
			inst.setAssetAssetModel(this.getAssetAssetModel());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setMaintnainer(this.getMaintnainer());
			inst.setAssetMaintenanceStatus(this.getAssetMaintenanceStatus());
			inst.setAssetMaintenanceUpdate(this.getAssetMaintenanceUpdate());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setMaintenanceMethodData(this.getMaintenanceMethodData());
			inst.setIds(this.getIds());
			inst.setAsset(this.getAsset());
			inst.setCategory(this.getCategory());
			inst.setAssetStatus(this.getAssetStatus());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetMaintenanceRecordVO clone(boolean deep) {
		return EntityContext.clone(AssetMaintenanceRecordVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetMaintenanceRecordVO
	 * @param assetMaintenanceRecordMap 包含实体信息的 Map 对象
	 * @return AssetMaintenanceRecordVO , 转换好的的 AssetMaintenanceRecord 对象
	*/
	@Transient
	public static AssetMaintenanceRecordVO createFrom(Map<String,Object> assetMaintenanceRecordMap) {
		if(assetMaintenanceRecordMap==null) return null;
		AssetMaintenanceRecordVO vo = create();
		EntityContext.copyProperties(vo,assetMaintenanceRecordMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetMaintenanceRecordVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetMaintenanceRecordVO , 转换好的的 AssetMaintenanceRecord 对象
	*/
	@Transient
	public static AssetMaintenanceRecordVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetMaintenanceRecordVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetMaintenanceRecordVO，等同于 new
	 * @return AssetMaintenanceRecordVO 对象
	*/
	@Transient
	public static AssetMaintenanceRecordVO create() {
		return new com.dt.platform.domain.eam.meta.AssetMaintenanceRecordVOMeta.$$proxy$$();
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
			this.setMaintenanceStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_STATUS)));
			this.setSMaintenanceStartDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_START_DATE)));
			this.setMaintenanceEndDate(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_END_DATE)));
			this.setSContactInformation(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.S_CONTACT_INFORMATION)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.UPDATE_BY)));
			this.setAssetId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.ASSET_ID)));
			this.setSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.SUGGEST_MAINTENANCE_METHOD)));
			this.setId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.ID)));
			this.setMaintainerName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.MAINTAINER_NAME)));
			this.setSMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_METHOD)));
			this.setSDirector(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.S_DIRECTOR)));
			this.setSContacts(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.S_CONTACTS)));
			this.setSSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.S_SUGGEST_MAINTENANCE_METHOD)));
			this.setSMaintainerName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.S_MAINTAINER_NAME)));
			this.setDirector(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.DIRECTOR)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetMaintenanceRecordVOMeta.VERSION)));
			this.setSMaintenanceNotes(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_NOTES)));
			this.setSMaintainerId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.S_MAINTAINER_ID)));
			this.setSMaintenanceStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_STATUS)));
			this.setMaintenanceNotes(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_NOTES)));
			this.setMaintainerId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.MAINTAINER_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetMaintenanceRecordVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordVOMeta.DELETE_TIME)));
			this.setMaintenanceUpdateId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_UPDATE_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.TENANT_ID)));
			this.setMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_METHOD)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.DELETE_BY)));
			this.setMaintenanceStartDate(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_START_DATE)));
			this.setSMaintenanceEndDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_END_DATE)));
			this.setContacts(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.CONTACTS)));
			// others
			this.setAssetAssetName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.ASSET_ASSET_NAME)));
			this.setSuggestMaintenanceMethodData(DataParser.parse(DictItem.class, map.get(AssetMaintenanceRecordVOMeta.SUGGEST_MAINTENANCE_METHOD_DATA)));
			this.setAssetAssetStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.ASSET_ASSET_STATUS)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.FUZZY_FIELD)));
			this.setAssetAssetCode(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.ASSET_ASSET_CODE)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetMaintenanceRecordVOMeta.PAGE_SIZE)));
			this.setAssetAssetCatalog(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.ASSET_ASSET_CATALOG)));
			this.setAssetAssetModel(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.ASSET_ASSET_MODEL)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetMaintenanceRecordVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.SORT_TYPE)));
			this.setMaintnainer(DataParser.parse(Maintainer.class, map.get(AssetMaintenanceRecordVOMeta.MAINTNAINER)));
			this.setAssetMaintenanceStatus(DataParser.parse(DictItem.class, map.get(AssetMaintenanceRecordVOMeta.ASSET_MAINTENANCE_STATUS)));
			this.setAssetMaintenanceUpdate(DataParser.parse(AssetMaintenanceUpdate.class, map.get(AssetMaintenanceRecordVOMeta.ASSET_MAINTENANCE_UPDATE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.SORT_FIELD)));
			this.setMaintenanceMethodData(DataParser.parse(DictItem.class, map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_METHOD_DATA)));
			this.setAsset(DataParser.parse(Asset.class, map.get(AssetMaintenanceRecordVOMeta.ASSET)));
			this.setCategory(DataParser.parse(Catalog.class, map.get(AssetMaintenanceRecordVOMeta.CATEGORY)));
			this.setAssetStatus(DataParser.parse(AssetStatus.class, map.get(AssetMaintenanceRecordVOMeta.ASSET_STATUS)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetMaintenanceRecordVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setMaintenanceStatus( (String)map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_STATUS));
				this.setSMaintenanceStartDate( (String)map.get(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_START_DATE));
				this.setMaintenanceEndDate( (Date)map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_END_DATE));
				this.setSContactInformation( (String)map.get(AssetMaintenanceRecordVOMeta.S_CONTACT_INFORMATION));
				this.setUpdateBy( (String)map.get(AssetMaintenanceRecordVOMeta.UPDATE_BY));
				this.setAssetId( (String)map.get(AssetMaintenanceRecordVOMeta.ASSET_ID));
				this.setSuggestMaintenanceMethod( (String)map.get(AssetMaintenanceRecordVOMeta.SUGGEST_MAINTENANCE_METHOD));
				this.setId( (String)map.get(AssetMaintenanceRecordVOMeta.ID));
				this.setMaintainerName( (String)map.get(AssetMaintenanceRecordVOMeta.MAINTAINER_NAME));
				this.setSMaintenanceMethod( (String)map.get(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_METHOD));
				this.setSDirector( (String)map.get(AssetMaintenanceRecordVOMeta.S_DIRECTOR));
				this.setSContacts( (String)map.get(AssetMaintenanceRecordVOMeta.S_CONTACTS));
				this.setSSuggestMaintenanceMethod( (String)map.get(AssetMaintenanceRecordVOMeta.S_SUGGEST_MAINTENANCE_METHOD));
				this.setSMaintainerName( (String)map.get(AssetMaintenanceRecordVOMeta.S_MAINTAINER_NAME));
				this.setDirector( (String)map.get(AssetMaintenanceRecordVOMeta.DIRECTOR));
				this.setUpdateTime( (Date)map.get(AssetMaintenanceRecordVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetMaintenanceRecordVOMeta.VERSION));
				this.setSMaintenanceNotes( (String)map.get(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_NOTES));
				this.setSMaintainerId( (String)map.get(AssetMaintenanceRecordVOMeta.S_MAINTAINER_ID));
				this.setSMaintenanceStatus( (String)map.get(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_STATUS));
				this.setMaintenanceNotes( (String)map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_NOTES));
				this.setMaintainerId( (String)map.get(AssetMaintenanceRecordVOMeta.MAINTAINER_ID));
				this.setCreateBy( (String)map.get(AssetMaintenanceRecordVOMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(AssetMaintenanceRecordVOMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)map.get(AssetMaintenanceRecordVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetMaintenanceRecordVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(AssetMaintenanceRecordVOMeta.DELETE_TIME));
				this.setMaintenanceUpdateId( (String)map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_UPDATE_ID));
				this.setTenantId( (String)map.get(AssetMaintenanceRecordVOMeta.TENANT_ID));
				this.setMaintenanceMethod( (String)map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_METHOD));
				this.setDeleteBy( (String)map.get(AssetMaintenanceRecordVOMeta.DELETE_BY));
				this.setMaintenanceStartDate( (Date)map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_START_DATE));
				this.setSMaintenanceEndDate( (String)map.get(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_END_DATE));
				this.setContacts( (String)map.get(AssetMaintenanceRecordVOMeta.CONTACTS));
				// others
				this.setAssetAssetName( (String)map.get(AssetMaintenanceRecordVOMeta.ASSET_ASSET_NAME));
				this.setSuggestMaintenanceMethodData( (DictItem)map.get(AssetMaintenanceRecordVOMeta.SUGGEST_MAINTENANCE_METHOD_DATA));
				this.setAssetAssetStatus( (String)map.get(AssetMaintenanceRecordVOMeta.ASSET_ASSET_STATUS));
				this.setSearchField( (String)map.get(AssetMaintenanceRecordVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(AssetMaintenanceRecordVOMeta.FUZZY_FIELD));
				this.setAssetAssetCode( (String)map.get(AssetMaintenanceRecordVOMeta.ASSET_ASSET_CODE));
				this.setPageSize( (Integer)map.get(AssetMaintenanceRecordVOMeta.PAGE_SIZE));
				this.setAssetAssetCatalog( (String)map.get(AssetMaintenanceRecordVOMeta.ASSET_ASSET_CATALOG));
				this.setAssetAssetModel( (String)map.get(AssetMaintenanceRecordVOMeta.ASSET_ASSET_MODEL));
				this.setPageIndex( (Integer)map.get(AssetMaintenanceRecordVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetMaintenanceRecordVOMeta.SORT_TYPE));
				this.setMaintnainer( (Maintainer)map.get(AssetMaintenanceRecordVOMeta.MAINTNAINER));
				this.setAssetMaintenanceStatus( (DictItem)map.get(AssetMaintenanceRecordVOMeta.ASSET_MAINTENANCE_STATUS));
				this.setAssetMaintenanceUpdate( (AssetMaintenanceUpdate)map.get(AssetMaintenanceRecordVOMeta.ASSET_MAINTENANCE_UPDATE));
				this.setSortField( (String)map.get(AssetMaintenanceRecordVOMeta.SORT_FIELD));
				this.setMaintenanceMethodData( (DictItem)map.get(AssetMaintenanceRecordVOMeta.MAINTENANCE_METHOD_DATA));
				this.setAsset( (Asset)map.get(AssetMaintenanceRecordVOMeta.ASSET));
				this.setCategory( (Catalog)map.get(AssetMaintenanceRecordVOMeta.CATEGORY));
				this.setAssetStatus( (AssetStatus)map.get(AssetMaintenanceRecordVOMeta.ASSET_STATUS));
				this.setSearchValue( (String)map.get(AssetMaintenanceRecordVOMeta.SEARCH_VALUE));
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
			this.setMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.MAINTENANCE_STATUS)));
			this.setSMaintenanceStartDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_START_DATE)));
			this.setMaintenanceEndDate(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordVOMeta.MAINTENANCE_END_DATE)));
			this.setSContactInformation(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.S_CONTACT_INFORMATION)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.UPDATE_BY)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.ASSET_ID)));
			this.setSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.SUGGEST_MAINTENANCE_METHOD)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.ID)));
			this.setMaintainerName(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.MAINTAINER_NAME)));
			this.setSMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_METHOD)));
			this.setSDirector(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.S_DIRECTOR)));
			this.setSContacts(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.S_CONTACTS)));
			this.setSSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.S_SUGGEST_MAINTENANCE_METHOD)));
			this.setSMaintainerName(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTAINER_NAME)));
			this.setDirector(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.DIRECTOR)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetMaintenanceRecordVOMeta.VERSION)));
			this.setSMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_NOTES)));
			this.setSMaintainerId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTAINER_ID)));
			this.setSMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_STATUS)));
			this.setMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.MAINTENANCE_NOTES)));
			this.setMaintainerId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.MAINTAINER_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetMaintenanceRecordVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordVOMeta.DELETE_TIME)));
			this.setMaintenanceUpdateId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.MAINTENANCE_UPDATE_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.TENANT_ID)));
			this.setMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.MAINTENANCE_METHOD)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.DELETE_BY)));
			this.setMaintenanceStartDate(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordVOMeta.MAINTENANCE_START_DATE)));
			this.setSMaintenanceEndDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_END_DATE)));
			this.setContacts(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordVOMeta.CONTACTS)));
			return true;
		} else {
			try {
				this.setMaintenanceStatus( (String)r.getValue(AssetMaintenanceRecordVOMeta.MAINTENANCE_STATUS));
				this.setSMaintenanceStartDate( (String)r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_START_DATE));
				this.setMaintenanceEndDate( (Date)r.getValue(AssetMaintenanceRecordVOMeta.MAINTENANCE_END_DATE));
				this.setSContactInformation( (String)r.getValue(AssetMaintenanceRecordVOMeta.S_CONTACT_INFORMATION));
				this.setUpdateBy( (String)r.getValue(AssetMaintenanceRecordVOMeta.UPDATE_BY));
				this.setAssetId( (String)r.getValue(AssetMaintenanceRecordVOMeta.ASSET_ID));
				this.setSuggestMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordVOMeta.SUGGEST_MAINTENANCE_METHOD));
				this.setId( (String)r.getValue(AssetMaintenanceRecordVOMeta.ID));
				this.setMaintainerName( (String)r.getValue(AssetMaintenanceRecordVOMeta.MAINTAINER_NAME));
				this.setSMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_METHOD));
				this.setSDirector( (String)r.getValue(AssetMaintenanceRecordVOMeta.S_DIRECTOR));
				this.setSContacts( (String)r.getValue(AssetMaintenanceRecordVOMeta.S_CONTACTS));
				this.setSSuggestMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordVOMeta.S_SUGGEST_MAINTENANCE_METHOD));
				this.setSMaintainerName( (String)r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTAINER_NAME));
				this.setDirector( (String)r.getValue(AssetMaintenanceRecordVOMeta.DIRECTOR));
				this.setUpdateTime( (Date)r.getValue(AssetMaintenanceRecordVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetMaintenanceRecordVOMeta.VERSION));
				this.setSMaintenanceNotes( (String)r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_NOTES));
				this.setSMaintainerId( (String)r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTAINER_ID));
				this.setSMaintenanceStatus( (String)r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_STATUS));
				this.setMaintenanceNotes( (String)r.getValue(AssetMaintenanceRecordVOMeta.MAINTENANCE_NOTES));
				this.setMaintainerId( (String)r.getValue(AssetMaintenanceRecordVOMeta.MAINTAINER_ID));
				this.setCreateBy( (String)r.getValue(AssetMaintenanceRecordVOMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(AssetMaintenanceRecordVOMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)r.getValue(AssetMaintenanceRecordVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetMaintenanceRecordVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(AssetMaintenanceRecordVOMeta.DELETE_TIME));
				this.setMaintenanceUpdateId( (String)r.getValue(AssetMaintenanceRecordVOMeta.MAINTENANCE_UPDATE_ID));
				this.setTenantId( (String)r.getValue(AssetMaintenanceRecordVOMeta.TENANT_ID));
				this.setMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordVOMeta.MAINTENANCE_METHOD));
				this.setDeleteBy( (String)r.getValue(AssetMaintenanceRecordVOMeta.DELETE_BY));
				this.setMaintenanceStartDate( (Date)r.getValue(AssetMaintenanceRecordVOMeta.MAINTENANCE_START_DATE));
				this.setSMaintenanceEndDate( (String)r.getValue(AssetMaintenanceRecordVOMeta.S_MAINTENANCE_END_DATE));
				this.setContacts( (String)r.getValue(AssetMaintenanceRecordVOMeta.CONTACTS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}