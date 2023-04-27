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
import com.dt.platform.domain.eam.meta.AssetMaintenanceRecordUVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 维保更新记录VO类型
 * <p>维保更新记录 , 数据表 eam_asset_maintenance_record_u 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-29 15:12:32
 * @sign 9B0ACCC449BFC41E29E1C167B4932025
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "维保更新记录VO类型 ; 维保更新记录 , 数据表 eam_asset_maintenance_record_u 的通用VO类型" , parent = AssetMaintenanceRecordU.class)
public class AssetMaintenanceRecordUVO extends AssetMaintenanceRecordU {

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
	public AssetMaintenanceRecordUVO setPageIndex(Integer pageIndex) {
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
	public AssetMaintenanceRecordUVO setPageSize(Integer pageSize) {
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
	public AssetMaintenanceRecordUVO setSearchField(String searchField) {
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
	public AssetMaintenanceRecordUVO setFuzzyField(String fuzzyField) {
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
	public AssetMaintenanceRecordUVO setSearchValue(String searchValue) {
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
	public AssetMaintenanceRecordUVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordUVO addDirtyField(String... dirtyField) {
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
	public AssetMaintenanceRecordUVO setSortField(String sortField) {
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
	public AssetMaintenanceRecordUVO setSortType(String sortType) {
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
	public AssetMaintenanceRecordUVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetMaintenanceRecordUVO addId(String... id) {
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
	 * @return AssetMaintenanceRecordUVO , 转换好的 AssetMaintenanceRecordUVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetMaintenanceRecordUVO , 转换好的 PoJo 对象
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
	public AssetMaintenanceRecordUVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetMaintenanceRecordUVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetMaintenanceRecordUVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetMaintenanceRecordUVOMeta.$$proxy$$();
		inst.setUContactInformation(this.getUContactInformation());
		inst.setUMaintenanceMethod(this.getUMaintenanceMethod());
		inst.setUSuggestMaintenanceMethod(this.getUSuggestMaintenanceMethod());
		inst.setMaintenanceStatus(this.getMaintenanceStatus());
		inst.setMaintenanceEndDate(this.getMaintenanceEndDate());
		inst.setUMaintenanceStatus(this.getUMaintenanceStatus());
		inst.setId(this.getId());
		inst.setSMaintenanceMethod(this.getSMaintenanceMethod());
		inst.setUSContactInformation(this.getUSContactInformation());
		inst.setUMaintenanceStartDate(this.getUMaintenanceStartDate());
		inst.setSContacts(this.getSContacts());
		inst.setSSuggestMaintenanceMethod(this.getSSuggestMaintenanceMethod());
		inst.setSMaintainerName(this.getSMaintainerName());
		inst.setUContacts(this.getUContacts());
		inst.setDirector(this.getDirector());
		inst.setUSMaintenanceMethod(this.getUSMaintenanceMethod());
		inst.setVersion(this.getVersion());
		inst.setMaintainerId(this.getMaintainerId());
		inst.setMaintenanceNotes(this.getMaintenanceNotes());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setMaintenanceMethod(this.getMaintenanceMethod());
		inst.setUSContacts(this.getUSContacts());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setSMaintenanceEndDate(this.getSMaintenanceEndDate());
		inst.setUMaintenanceNotes(this.getUMaintenanceNotes());
		inst.setUSMaintenanceEndDate(this.getUSMaintenanceEndDate());
		inst.setUSMaintainerName(this.getUSMaintainerName());
		inst.setUMaintenanceEndDate(this.getUMaintenanceEndDate());
		inst.setSMaintenanceStartDate(this.getSMaintenanceStartDate());
		inst.setSContactInformation(this.getSContactInformation());
		inst.setUSMaintenanceNotes(this.getUSMaintenanceNotes());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setSuggestMaintenanceMethod(this.getSuggestMaintenanceMethod());
		inst.setUSMaintenanceStartDate(this.getUSMaintenanceStartDate());
		inst.setMaintainerName(this.getMaintainerName());
		inst.setSDirector(this.getSDirector());
		inst.setUSMaintenanceStatus(this.getUSMaintenanceStatus());
		inst.setUMaintainerId(this.getUMaintainerId());
		inst.setUDirector(this.getUDirector());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSMaintainerId(this.getSMaintainerId());
		inst.setSMaintenanceNotes(this.getSMaintenanceNotes());
		inst.setUSDirector(this.getUSDirector());
		inst.setSMaintenanceStatus(this.getSMaintenanceStatus());
		inst.setCreateBy(this.getCreateBy());
		inst.setContactInformation(this.getContactInformation());
		inst.setDeleted(this.getDeleted());
		inst.setUSMaintainerId(this.getUSMaintainerId());
		inst.setCreateTime(this.getCreateTime());
		inst.setMaintenanceUpdateId(this.getMaintenanceUpdateId());
		inst.setTenantId(this.getTenantId());
		inst.setMaintenanceStartDate(this.getMaintenanceStartDate());
		inst.setContacts(this.getContacts());
		inst.setUMaintainerName(this.getUMaintainerName());
		inst.setUSSuggestMaintenanceMethod(this.getUSSuggestMaintenanceMethod());
		if(all) {
			inst.setSuggestMaintenanceMethodData(this.getSuggestMaintenanceMethodData());
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setMaintnainer(this.getMaintnainer());
			inst.setAssetMaintenanceStatus(this.getAssetMaintenanceStatus());
			inst.setAssetMaintenanceUpdate(this.getAssetMaintenanceUpdate());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setMaintenanceMethodData(this.getMaintenanceMethodData());
			inst.setIds(this.getIds());
			inst.setSearchValue(this.getSearchValue());
			inst.setRecordIdList(this.getRecordIdList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetMaintenanceRecordUVO clone(boolean deep) {
		return EntityContext.clone(AssetMaintenanceRecordUVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetMaintenanceRecordUVO
	 * @param assetMaintenanceRecordUMap 包含实体信息的 Map 对象
	 * @return AssetMaintenanceRecordUVO , 转换好的的 AssetMaintenanceRecordU 对象
	*/
	@Transient
	public static AssetMaintenanceRecordUVO createFrom(Map<String,Object> assetMaintenanceRecordUMap) {
		if(assetMaintenanceRecordUMap==null) return null;
		AssetMaintenanceRecordUVO vo = create();
		EntityContext.copyProperties(vo,assetMaintenanceRecordUMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetMaintenanceRecordUVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetMaintenanceRecordUVO , 转换好的的 AssetMaintenanceRecordU 对象
	*/
	@Transient
	public static AssetMaintenanceRecordUVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetMaintenanceRecordUVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetMaintenanceRecordUVO，等同于 new
	 * @return AssetMaintenanceRecordUVO 对象
	*/
	@Transient
	public static AssetMaintenanceRecordUVO create() {
		return new com.dt.platform.domain.eam.meta.AssetMaintenanceRecordUVOMeta.$$proxy$$();
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
			this.setUContactInformation(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_CONTACT_INFORMATION)));
			this.setUMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_METHOD)));
			this.setUSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_SUGGEST_MAINTENANCE_METHOD)));
			this.setMaintenanceStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_STATUS)));
			this.setMaintenanceEndDate(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_END_DATE)));
			this.setUMaintenanceStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_STATUS)));
			this.setId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.ID)));
			this.setSMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_METHOD)));
			this.setUSContactInformation(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_S_CONTACT_INFORMATION)));
			this.setUMaintenanceStartDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_START_DATE)));
			this.setSContacts(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.S_CONTACTS)));
			this.setSSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.S_SUGGEST_MAINTENANCE_METHOD)));
			this.setSMaintainerName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.S_MAINTAINER_NAME)));
			this.setUContacts(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_CONTACTS)));
			this.setDirector(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.DIRECTOR)));
			this.setUSMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_METHOD)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetMaintenanceRecordUVOMeta.VERSION)));
			this.setMaintainerId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.MAINTAINER_ID)));
			this.setMaintenanceNotes(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_NOTES)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordUVOMeta.DELETE_TIME)));
			this.setMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_METHOD)));
			this.setUSContacts(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_S_CONTACTS)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.DELETE_BY)));
			this.setSMaintenanceEndDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_END_DATE)));
			this.setUMaintenanceNotes(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_NOTES)));
			this.setUSMaintenanceEndDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_END_DATE)));
			this.setUSMaintainerName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_NAME)));
			this.setUMaintenanceEndDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_END_DATE)));
			this.setSMaintenanceStartDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_START_DATE)));
			this.setSContactInformation(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.S_CONTACT_INFORMATION)));
			this.setUSMaintenanceNotes(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_NOTES)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.UPDATE_BY)));
			this.setSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.SUGGEST_MAINTENANCE_METHOD)));
			this.setUSMaintenanceStartDate(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_START_DATE)));
			this.setMaintainerName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.MAINTAINER_NAME)));
			this.setSDirector(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.S_DIRECTOR)));
			this.setUSMaintenanceStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_STATUS)));
			this.setUMaintainerId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_MAINTAINER_ID)));
			this.setUDirector(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_DIRECTOR)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordUVOMeta.UPDATE_TIME)));
			this.setSMaintainerId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.S_MAINTAINER_ID)));
			this.setSMaintenanceNotes(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_NOTES)));
			this.setUSDirector(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_S_DIRECTOR)));
			this.setSMaintenanceStatus(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_STATUS)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetMaintenanceRecordUVOMeta.DELETED)));
			this.setUSMaintainerId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordUVOMeta.CREATE_TIME)));
			this.setMaintenanceUpdateId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_UPDATE_ID)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.TENANT_ID)));
			this.setMaintenanceStartDate(DataParser.parse(Date.class, map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_START_DATE)));
			this.setContacts(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.CONTACTS)));
			this.setUMaintainerName(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_MAINTAINER_NAME)));
			this.setUSSuggestMaintenanceMethod(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.U_S_SUGGEST_MAINTENANCE_METHOD)));
			// others
			this.setSuggestMaintenanceMethodData(DataParser.parse(DictItem.class, map.get(AssetMaintenanceRecordUVOMeta.SUGGEST_MAINTENANCE_METHOD_DATA)));
			this.setSearchField(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetMaintenanceRecordUVOMeta.PAGE_SIZE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetMaintenanceRecordUVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.SORT_TYPE)));
			this.setMaintnainer(DataParser.parse(Maintainer.class, map.get(AssetMaintenanceRecordUVOMeta.MAINTNAINER)));
			this.setAssetMaintenanceStatus(DataParser.parse(DictItem.class, map.get(AssetMaintenanceRecordUVOMeta.ASSET_MAINTENANCE_STATUS)));
			this.setAssetMaintenanceUpdate(DataParser.parse(AssetMaintenanceUpdate.class, map.get(AssetMaintenanceRecordUVOMeta.ASSET_MAINTENANCE_UPDATE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.SORT_FIELD)));
			this.setMaintenanceMethodData(DataParser.parse(DictItem.class, map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_METHOD_DATA)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetMaintenanceRecordUVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setUContactInformation( (String)map.get(AssetMaintenanceRecordUVOMeta.U_CONTACT_INFORMATION));
				this.setUMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_METHOD));
				this.setUSuggestMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUVOMeta.U_SUGGEST_MAINTENANCE_METHOD));
				this.setMaintenanceStatus( (String)map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_STATUS));
				this.setMaintenanceEndDate( (Date)map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_END_DATE));
				this.setUMaintenanceStatus( (String)map.get(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_STATUS));
				this.setId( (String)map.get(AssetMaintenanceRecordUVOMeta.ID));
				this.setSMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_METHOD));
				this.setUSContactInformation( (String)map.get(AssetMaintenanceRecordUVOMeta.U_S_CONTACT_INFORMATION));
				this.setUMaintenanceStartDate( (String)map.get(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_START_DATE));
				this.setSContacts( (String)map.get(AssetMaintenanceRecordUVOMeta.S_CONTACTS));
				this.setSSuggestMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUVOMeta.S_SUGGEST_MAINTENANCE_METHOD));
				this.setSMaintainerName( (String)map.get(AssetMaintenanceRecordUVOMeta.S_MAINTAINER_NAME));
				this.setUContacts( (String)map.get(AssetMaintenanceRecordUVOMeta.U_CONTACTS));
				this.setDirector( (String)map.get(AssetMaintenanceRecordUVOMeta.DIRECTOR));
				this.setUSMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_METHOD));
				this.setVersion( (Integer)map.get(AssetMaintenanceRecordUVOMeta.VERSION));
				this.setMaintainerId( (String)map.get(AssetMaintenanceRecordUVOMeta.MAINTAINER_ID));
				this.setMaintenanceNotes( (String)map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_NOTES));
				this.setDeleteTime( (Date)map.get(AssetMaintenanceRecordUVOMeta.DELETE_TIME));
				this.setMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_METHOD));
				this.setUSContacts( (String)map.get(AssetMaintenanceRecordUVOMeta.U_S_CONTACTS));
				this.setDeleteBy( (String)map.get(AssetMaintenanceRecordUVOMeta.DELETE_BY));
				this.setSMaintenanceEndDate( (String)map.get(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_END_DATE));
				this.setUMaintenanceNotes( (String)map.get(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_NOTES));
				this.setUSMaintenanceEndDate( (String)map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_END_DATE));
				this.setUSMaintainerName( (String)map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_NAME));
				this.setUMaintenanceEndDate( (String)map.get(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_END_DATE));
				this.setSMaintenanceStartDate( (String)map.get(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_START_DATE));
				this.setSContactInformation( (String)map.get(AssetMaintenanceRecordUVOMeta.S_CONTACT_INFORMATION));
				this.setUSMaintenanceNotes( (String)map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_NOTES));
				this.setUpdateBy( (String)map.get(AssetMaintenanceRecordUVOMeta.UPDATE_BY));
				this.setSuggestMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUVOMeta.SUGGEST_MAINTENANCE_METHOD));
				this.setUSMaintenanceStartDate( (String)map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_START_DATE));
				this.setMaintainerName( (String)map.get(AssetMaintenanceRecordUVOMeta.MAINTAINER_NAME));
				this.setSDirector( (String)map.get(AssetMaintenanceRecordUVOMeta.S_DIRECTOR));
				this.setUSMaintenanceStatus( (String)map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_STATUS));
				this.setUMaintainerId( (String)map.get(AssetMaintenanceRecordUVOMeta.U_MAINTAINER_ID));
				this.setUDirector( (String)map.get(AssetMaintenanceRecordUVOMeta.U_DIRECTOR));
				this.setUpdateTime( (Date)map.get(AssetMaintenanceRecordUVOMeta.UPDATE_TIME));
				this.setSMaintainerId( (String)map.get(AssetMaintenanceRecordUVOMeta.S_MAINTAINER_ID));
				this.setSMaintenanceNotes( (String)map.get(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_NOTES));
				this.setUSDirector( (String)map.get(AssetMaintenanceRecordUVOMeta.U_S_DIRECTOR));
				this.setSMaintenanceStatus( (String)map.get(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_STATUS));
				this.setCreateBy( (String)map.get(AssetMaintenanceRecordUVOMeta.CREATE_BY));
				this.setContactInformation( (String)map.get(AssetMaintenanceRecordUVOMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)map.get(AssetMaintenanceRecordUVOMeta.DELETED));
				this.setUSMaintainerId( (String)map.get(AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_ID));
				this.setCreateTime( (Date)map.get(AssetMaintenanceRecordUVOMeta.CREATE_TIME));
				this.setMaintenanceUpdateId( (String)map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_UPDATE_ID));
				this.setTenantId( (String)map.get(AssetMaintenanceRecordUVOMeta.TENANT_ID));
				this.setMaintenanceStartDate( (Date)map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_START_DATE));
				this.setContacts( (String)map.get(AssetMaintenanceRecordUVOMeta.CONTACTS));
				this.setUMaintainerName( (String)map.get(AssetMaintenanceRecordUVOMeta.U_MAINTAINER_NAME));
				this.setUSSuggestMaintenanceMethod( (String)map.get(AssetMaintenanceRecordUVOMeta.U_S_SUGGEST_MAINTENANCE_METHOD));
				// others
				this.setSuggestMaintenanceMethodData( (DictItem)map.get(AssetMaintenanceRecordUVOMeta.SUGGEST_MAINTENANCE_METHOD_DATA));
				this.setSearchField( (String)map.get(AssetMaintenanceRecordUVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(AssetMaintenanceRecordUVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetMaintenanceRecordUVOMeta.PAGE_SIZE));
				this.setPageIndex( (Integer)map.get(AssetMaintenanceRecordUVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetMaintenanceRecordUVOMeta.SORT_TYPE));
				this.setMaintnainer( (Maintainer)map.get(AssetMaintenanceRecordUVOMeta.MAINTNAINER));
				this.setAssetMaintenanceStatus( (DictItem)map.get(AssetMaintenanceRecordUVOMeta.ASSET_MAINTENANCE_STATUS));
				this.setAssetMaintenanceUpdate( (AssetMaintenanceUpdate)map.get(AssetMaintenanceRecordUVOMeta.ASSET_MAINTENANCE_UPDATE));
				this.setSortField( (String)map.get(AssetMaintenanceRecordUVOMeta.SORT_FIELD));
				this.setMaintenanceMethodData( (DictItem)map.get(AssetMaintenanceRecordUVOMeta.MAINTENANCE_METHOD_DATA));
				this.setSearchValue( (String)map.get(AssetMaintenanceRecordUVOMeta.SEARCH_VALUE));
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
			this.setUContactInformation(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_CONTACT_INFORMATION)));
			this.setUMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_METHOD)));
			this.setUSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_SUGGEST_MAINTENANCE_METHOD)));
			this.setMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.MAINTENANCE_STATUS)));
			this.setMaintenanceEndDate(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordUVOMeta.MAINTENANCE_END_DATE)));
			this.setUMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_STATUS)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.ID)));
			this.setSMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_METHOD)));
			this.setUSContactInformation(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_S_CONTACT_INFORMATION)));
			this.setUMaintenanceStartDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_START_DATE)));
			this.setSContacts(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.S_CONTACTS)));
			this.setSSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.S_SUGGEST_MAINTENANCE_METHOD)));
			this.setSMaintainerName(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTAINER_NAME)));
			this.setUContacts(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_CONTACTS)));
			this.setDirector(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.DIRECTOR)));
			this.setUSMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_METHOD)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetMaintenanceRecordUVOMeta.VERSION)));
			this.setMaintainerId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.MAINTAINER_ID)));
			this.setMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.MAINTENANCE_NOTES)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordUVOMeta.DELETE_TIME)));
			this.setMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.MAINTENANCE_METHOD)));
			this.setUSContacts(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_S_CONTACTS)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.DELETE_BY)));
			this.setSMaintenanceEndDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_END_DATE)));
			this.setUMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_NOTES)));
			this.setUSMaintenanceEndDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_END_DATE)));
			this.setUSMaintainerName(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_NAME)));
			this.setUMaintenanceEndDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_END_DATE)));
			this.setSMaintenanceStartDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_START_DATE)));
			this.setSContactInformation(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.S_CONTACT_INFORMATION)));
			this.setUSMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_NOTES)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.UPDATE_BY)));
			this.setSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.SUGGEST_MAINTENANCE_METHOD)));
			this.setUSMaintenanceStartDate(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_START_DATE)));
			this.setMaintainerName(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.MAINTAINER_NAME)));
			this.setSDirector(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.S_DIRECTOR)));
			this.setUSMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_STATUS)));
			this.setUMaintainerId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTAINER_ID)));
			this.setUDirector(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_DIRECTOR)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordUVOMeta.UPDATE_TIME)));
			this.setSMaintainerId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTAINER_ID)));
			this.setSMaintenanceNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_NOTES)));
			this.setUSDirector(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_S_DIRECTOR)));
			this.setSMaintenanceStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_STATUS)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.CREATE_BY)));
			this.setContactInformation(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.CONTACT_INFORMATION)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetMaintenanceRecordUVOMeta.DELETED)));
			this.setUSMaintainerId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordUVOMeta.CREATE_TIME)));
			this.setMaintenanceUpdateId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.MAINTENANCE_UPDATE_ID)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.TENANT_ID)));
			this.setMaintenanceStartDate(DataParser.parse(Date.class, r.getValue(AssetMaintenanceRecordUVOMeta.MAINTENANCE_START_DATE)));
			this.setContacts(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.CONTACTS)));
			this.setUMaintainerName(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTAINER_NAME)));
			this.setUSSuggestMaintenanceMethod(DataParser.parse(String.class, r.getValue(AssetMaintenanceRecordUVOMeta.U_S_SUGGEST_MAINTENANCE_METHOD)));
			return true;
		} else {
			try {
				this.setUContactInformation( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_CONTACT_INFORMATION));
				this.setUMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_METHOD));
				this.setUSuggestMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_SUGGEST_MAINTENANCE_METHOD));
				this.setMaintenanceStatus( (String)r.getValue(AssetMaintenanceRecordUVOMeta.MAINTENANCE_STATUS));
				this.setMaintenanceEndDate( (Date)r.getValue(AssetMaintenanceRecordUVOMeta.MAINTENANCE_END_DATE));
				this.setUMaintenanceStatus( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_STATUS));
				this.setId( (String)r.getValue(AssetMaintenanceRecordUVOMeta.ID));
				this.setSMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_METHOD));
				this.setUSContactInformation( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_S_CONTACT_INFORMATION));
				this.setUMaintenanceStartDate( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_START_DATE));
				this.setSContacts( (String)r.getValue(AssetMaintenanceRecordUVOMeta.S_CONTACTS));
				this.setSSuggestMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUVOMeta.S_SUGGEST_MAINTENANCE_METHOD));
				this.setSMaintainerName( (String)r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTAINER_NAME));
				this.setUContacts( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_CONTACTS));
				this.setDirector( (String)r.getValue(AssetMaintenanceRecordUVOMeta.DIRECTOR));
				this.setUSMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_METHOD));
				this.setVersion( (Integer)r.getValue(AssetMaintenanceRecordUVOMeta.VERSION));
				this.setMaintainerId( (String)r.getValue(AssetMaintenanceRecordUVOMeta.MAINTAINER_ID));
				this.setMaintenanceNotes( (String)r.getValue(AssetMaintenanceRecordUVOMeta.MAINTENANCE_NOTES));
				this.setDeleteTime( (Date)r.getValue(AssetMaintenanceRecordUVOMeta.DELETE_TIME));
				this.setMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUVOMeta.MAINTENANCE_METHOD));
				this.setUSContacts( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_S_CONTACTS));
				this.setDeleteBy( (String)r.getValue(AssetMaintenanceRecordUVOMeta.DELETE_BY));
				this.setSMaintenanceEndDate( (String)r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_END_DATE));
				this.setUMaintenanceNotes( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_NOTES));
				this.setUSMaintenanceEndDate( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_END_DATE));
				this.setUSMaintainerName( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_NAME));
				this.setUMaintenanceEndDate( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTENANCE_END_DATE));
				this.setSMaintenanceStartDate( (String)r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_START_DATE));
				this.setSContactInformation( (String)r.getValue(AssetMaintenanceRecordUVOMeta.S_CONTACT_INFORMATION));
				this.setUSMaintenanceNotes( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_NOTES));
				this.setUpdateBy( (String)r.getValue(AssetMaintenanceRecordUVOMeta.UPDATE_BY));
				this.setSuggestMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUVOMeta.SUGGEST_MAINTENANCE_METHOD));
				this.setUSMaintenanceStartDate( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_START_DATE));
				this.setMaintainerName( (String)r.getValue(AssetMaintenanceRecordUVOMeta.MAINTAINER_NAME));
				this.setSDirector( (String)r.getValue(AssetMaintenanceRecordUVOMeta.S_DIRECTOR));
				this.setUSMaintenanceStatus( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTENANCE_STATUS));
				this.setUMaintainerId( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTAINER_ID));
				this.setUDirector( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_DIRECTOR));
				this.setUpdateTime( (Date)r.getValue(AssetMaintenanceRecordUVOMeta.UPDATE_TIME));
				this.setSMaintainerId( (String)r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTAINER_ID));
				this.setSMaintenanceNotes( (String)r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_NOTES));
				this.setUSDirector( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_S_DIRECTOR));
				this.setSMaintenanceStatus( (String)r.getValue(AssetMaintenanceRecordUVOMeta.S_MAINTENANCE_STATUS));
				this.setCreateBy( (String)r.getValue(AssetMaintenanceRecordUVOMeta.CREATE_BY));
				this.setContactInformation( (String)r.getValue(AssetMaintenanceRecordUVOMeta.CONTACT_INFORMATION));
				this.setDeleted( (Integer)r.getValue(AssetMaintenanceRecordUVOMeta.DELETED));
				this.setUSMaintainerId( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_S_MAINTAINER_ID));
				this.setCreateTime( (Date)r.getValue(AssetMaintenanceRecordUVOMeta.CREATE_TIME));
				this.setMaintenanceUpdateId( (String)r.getValue(AssetMaintenanceRecordUVOMeta.MAINTENANCE_UPDATE_ID));
				this.setTenantId( (String)r.getValue(AssetMaintenanceRecordUVOMeta.TENANT_ID));
				this.setMaintenanceStartDate( (Date)r.getValue(AssetMaintenanceRecordUVOMeta.MAINTENANCE_START_DATE));
				this.setContacts( (String)r.getValue(AssetMaintenanceRecordUVOMeta.CONTACTS));
				this.setUMaintainerName( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_MAINTAINER_NAME));
				this.setUSSuggestMaintenanceMethod( (String)r.getValue(AssetMaintenanceRecordUVOMeta.U_S_SUGGEST_MAINTENANCE_METHOD));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}