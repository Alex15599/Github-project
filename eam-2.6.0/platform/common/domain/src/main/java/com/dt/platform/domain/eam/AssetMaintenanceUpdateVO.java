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
import com.dt.platform.domain.eam.meta.AssetMaintenanceUpdateVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 维保更新VO类型
 * <p>维保更新 , 数据表 eam_asset_maintenance_update 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-28 22:25:06
 * @sign BCA4AACDC7DBE602B46795C9E328631B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "维保更新VO类型 ; 维保更新 , 数据表 eam_asset_maintenance_update 的通用VO类型" , parent = AssetMaintenanceUpdate.class)
public class AssetMaintenanceUpdateVO extends AssetMaintenanceUpdate {

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
	public AssetMaintenanceUpdateVO setPageIndex(Integer pageIndex) {
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
	public AssetMaintenanceUpdateVO setPageSize(Integer pageSize) {
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
	public AssetMaintenanceUpdateVO setSearchField(String searchField) {
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
	public AssetMaintenanceUpdateVO setFuzzyField(String fuzzyField) {
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
	public AssetMaintenanceUpdateVO setSearchValue(String searchValue) {
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
	public AssetMaintenanceUpdateVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetMaintenanceUpdateVO addDirtyField(String... dirtyField) {
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
	public AssetMaintenanceUpdateVO setSortField(String sortField) {
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
	public AssetMaintenanceUpdateVO setSortType(String sortType) {
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
	public AssetMaintenanceUpdateVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetMaintenanceUpdateVO addId(String... id) {
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
	 * @return AssetMaintenanceUpdateVO , 转换好的 AssetMaintenanceUpdateVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetMaintenanceUpdateVO , 转换好的 PoJo 对象
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
	public AssetMaintenanceUpdateVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetMaintenanceUpdateVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetMaintenanceUpdateVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetMaintenanceUpdateVOMeta.$$proxy$$();
		inst.setReason(this.getReason());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setHandleStatus(this.getHandleStatus());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setAttachId(this.getAttachId());
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
	public AssetMaintenanceUpdateVO clone(boolean deep) {
		return EntityContext.clone(AssetMaintenanceUpdateVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetMaintenanceUpdateVO
	 * @param assetMaintenanceUpdateMap 包含实体信息的 Map 对象
	 * @return AssetMaintenanceUpdateVO , 转换好的的 AssetMaintenanceUpdate 对象
	*/
	@Transient
	public static AssetMaintenanceUpdateVO createFrom(Map<String,Object> assetMaintenanceUpdateMap) {
		if(assetMaintenanceUpdateMap==null) return null;
		AssetMaintenanceUpdateVO vo = create();
		EntityContext.copyProperties(vo,assetMaintenanceUpdateMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetMaintenanceUpdateVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetMaintenanceUpdateVO , 转换好的的 AssetMaintenanceUpdate 对象
	*/
	@Transient
	public static AssetMaintenanceUpdateVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetMaintenanceUpdateVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetMaintenanceUpdateVO，等同于 new
	 * @return AssetMaintenanceUpdateVO 对象
	*/
	@Transient
	public static AssetMaintenanceUpdateVO create() {
		return new com.dt.platform.domain.eam.meta.AssetMaintenanceUpdateVOMeta.$$proxy$$();
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
			this.setReason(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.REASON)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetMaintenanceUpdateVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetMaintenanceUpdateVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetMaintenanceUpdateVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetMaintenanceUpdateVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetMaintenanceUpdateVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.TENANT_ID)));
			this.setHandleStatus(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.HANDLE_STATUS)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.ID)));
			this.setAttachId(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.ATTACH_ID)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.SEARCH_FIELD)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetMaintenanceUpdateVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.SORT_TYPE)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.FUZZY_FIELD)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.SORT_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetMaintenanceUpdateVOMeta.PAGE_SIZE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setReason( (String)map.get(AssetMaintenanceUpdateVOMeta.REASON));
				this.setNotes( (String)map.get(AssetMaintenanceUpdateVOMeta.NOTES));
				this.setUpdateTime( (Date)map.get(AssetMaintenanceUpdateVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetMaintenanceUpdateVOMeta.VERSION));
				this.setContent( (String)map.get(AssetMaintenanceUpdateVOMeta.CONTENT));
				this.setBusinessCode( (String)map.get(AssetMaintenanceUpdateVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(AssetMaintenanceUpdateVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetMaintenanceUpdateVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetMaintenanceUpdateVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetMaintenanceUpdateVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetMaintenanceUpdateVOMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetMaintenanceUpdateVOMeta.NAME));
				this.setTenantId( (String)map.get(AssetMaintenanceUpdateVOMeta.TENANT_ID));
				this.setHandleStatus( (String)map.get(AssetMaintenanceUpdateVOMeta.HANDLE_STATUS));
				this.setDeleteBy( (String)map.get(AssetMaintenanceUpdateVOMeta.DELETE_BY));
				this.setId( (String)map.get(AssetMaintenanceUpdateVOMeta.ID));
				this.setAttachId( (String)map.get(AssetMaintenanceUpdateVOMeta.ATTACH_ID));
				// others
				this.setSearchField( (String)map.get(AssetMaintenanceUpdateVOMeta.SEARCH_FIELD));
				this.setPageIndex( (Integer)map.get(AssetMaintenanceUpdateVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetMaintenanceUpdateVOMeta.SORT_TYPE));
				this.setFuzzyField( (String)map.get(AssetMaintenanceUpdateVOMeta.FUZZY_FIELD));
				this.setSortField( (String)map.get(AssetMaintenanceUpdateVOMeta.SORT_FIELD));
				this.setPageSize( (Integer)map.get(AssetMaintenanceUpdateVOMeta.PAGE_SIZE));
				this.setSearchValue( (String)map.get(AssetMaintenanceUpdateVOMeta.SEARCH_VALUE));
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
			this.setReason(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateVOMeta.REASON)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceUpdateVOMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetMaintenanceUpdateVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateVOMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateVOMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetMaintenanceUpdateVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceUpdateVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceUpdateVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateVOMeta.TENANT_ID)));
			this.setHandleStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateVOMeta.HANDLE_STATUS)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateVOMeta.ID)));
			this.setAttachId(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateVOMeta.ATTACH_ID)));
			return true;
		} else {
			try {
				this.setReason( (String)r.getValue(AssetMaintenanceUpdateVOMeta.REASON));
				this.setNotes( (String)r.getValue(AssetMaintenanceUpdateVOMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(AssetMaintenanceUpdateVOMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetMaintenanceUpdateVOMeta.VERSION));
				this.setContent( (String)r.getValue(AssetMaintenanceUpdateVOMeta.CONTENT));
				this.setBusinessCode( (String)r.getValue(AssetMaintenanceUpdateVOMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(AssetMaintenanceUpdateVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetMaintenanceUpdateVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetMaintenanceUpdateVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetMaintenanceUpdateVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetMaintenanceUpdateVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetMaintenanceUpdateVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetMaintenanceUpdateVOMeta.TENANT_ID));
				this.setHandleStatus( (String)r.getValue(AssetMaintenanceUpdateVOMeta.HANDLE_STATUS));
				this.setDeleteBy( (String)r.getValue(AssetMaintenanceUpdateVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetMaintenanceUpdateVOMeta.ID));
				this.setAttachId( (String)r.getValue(AssetMaintenanceUpdateVOMeta.ATTACH_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}