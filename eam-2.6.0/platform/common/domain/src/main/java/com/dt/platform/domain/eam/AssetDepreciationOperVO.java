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
import com.dt.platform.domain.eam.meta.AssetDepreciationOperVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 折旧操作VO类型
 * <p>折旧操作 , 数据表 eam_asset_depreciation_oper 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-27 09:07:59
 * @sign BB9297D6EE1735DBBADAAF0AB0486CA3
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "折旧操作VO类型 ; 折旧操作 , 数据表 eam_asset_depreciation_oper 的通用VO类型" , parent = AssetDepreciationOper.class)
public class AssetDepreciationOperVO extends AssetDepreciationOper {

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
	public AssetDepreciationOperVO setPageIndex(Integer pageIndex) {
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
	public AssetDepreciationOperVO setPageSize(Integer pageSize) {
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
	public AssetDepreciationOperVO setSearchField(String searchField) {
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
	public AssetDepreciationOperVO setFuzzyField(String fuzzyField) {
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
	public AssetDepreciationOperVO setSearchValue(String searchValue) {
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
	public AssetDepreciationOperVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public AssetDepreciationOperVO addDirtyField(String... dirtyField) {
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
	public AssetDepreciationOperVO setSortField(String sortField) {
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
	public AssetDepreciationOperVO setSortType(String sortType) {
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
	public AssetDepreciationOperVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public AssetDepreciationOperVO addId(String... id) {
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
	 * @return AssetDepreciationOperVO , 转换好的 AssetDepreciationOperVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDepreciationOperVO , 转换好的 PoJo 对象
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
	public AssetDepreciationOperVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetDepreciationOperVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetDepreciationOperVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetDepreciationOperVOMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setDepreciationCode(this.getDepreciationCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setExecutionEndTime(this.getExecutionEndTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setBusinessDate(this.getBusinessDate());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setDepreciationId(this.getDepreciationId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setExecutionStartTime(this.getExecutionStartTime());
		inst.setId(this.getId());
		inst.setOriginatorId(this.getOriginatorId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setAssetSourceIds(this.getAssetSourceIds());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setAssetDepreciationList(this.getAssetDepreciationList());
			inst.setOriginator(this.getOriginator());
			inst.setAssetDepreciation(this.getAssetDepreciation());
			inst.setAssetSourceList(this.getAssetSourceList());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setAssetDepreciationIds(this.getAssetDepreciationIds());
			inst.setAssetTargetList(this.getAssetTargetList());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setIds(this.getIds());
			inst.setSearchValue(this.getSearchValue());
			inst.setAssetTargetIds(this.getAssetTargetIds());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetDepreciationOperVO clone(boolean deep) {
		return EntityContext.clone(AssetDepreciationOperVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetDepreciationOperVO
	 * @param assetDepreciationOperMap 包含实体信息的 Map 对象
	 * @return AssetDepreciationOperVO , 转换好的的 AssetDepreciationOper 对象
	*/
	@Transient
	public static AssetDepreciationOperVO createFrom(Map<String,Object> assetDepreciationOperMap) {
		if(assetDepreciationOperMap==null) return null;
		AssetDepreciationOperVO vo = create();
		EntityContext.copyProperties(vo,assetDepreciationOperMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 AssetDepreciationOperVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDepreciationOperVO , 转换好的的 AssetDepreciationOper 对象
	*/
	@Transient
	public static AssetDepreciationOperVO createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDepreciationOperVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 AssetDepreciationOperVO，等同于 new
	 * @return AssetDepreciationOperVO 对象
	*/
	@Transient
	public static AssetDepreciationOperVO create() {
		return new com.dt.platform.domain.eam.meta.AssetDepreciationOperVOMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.NOTES)));
			this.setDepreciationCode(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.DEPRECIATION_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetDepreciationOperVOMeta.UPDATE_TIME)));
			this.setExecutionEndTime(DataParser.parse(Date.class, map.get(AssetDepreciationOperVOMeta.EXECUTION_END_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetDepreciationOperVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, map.get(AssetDepreciationOperVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.BUSINESS_CODE)));
			this.setDepreciationId(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.DEPRECIATION_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetDepreciationOperVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetDepreciationOperVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetDepreciationOperVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.DELETE_BY)));
			this.setExecutionStartTime(DataParser.parse(Date.class, map.get(AssetDepreciationOperVOMeta.EXECUTION_START_TIME)));
			this.setId(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.ORIGINATOR_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(AssetDepreciationOperVOMeta.PAGE_SIZE)));
			this.setOriginator(DataParser.parse(Employee.class, map.get(AssetDepreciationOperVOMeta.ORIGINATOR)));
			this.setAssetDepreciation(DataParser.parse(AssetDepreciation.class, map.get(AssetDepreciationOperVOMeta.ASSET_DEPRECIATION)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(AssetDepreciationOperVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.SORT_FIELD)));
			this.setSearchValue(DataParser.parse(String.class, map.get(AssetDepreciationOperVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(AssetDepreciationOperVOMeta.NOTES));
				this.setDepreciationCode( (String)map.get(AssetDepreciationOperVOMeta.DEPRECIATION_CODE));
				this.setUpdateTime( (Date)map.get(AssetDepreciationOperVOMeta.UPDATE_TIME));
				this.setExecutionEndTime( (Date)map.get(AssetDepreciationOperVOMeta.EXECUTION_END_TIME));
				this.setVersion( (Integer)map.get(AssetDepreciationOperVOMeta.VERSION));
				this.setContent( (String)map.get(AssetDepreciationOperVOMeta.CONTENT));
				this.setBusinessDate( (Date)map.get(AssetDepreciationOperVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)map.get(AssetDepreciationOperVOMeta.BUSINESS_CODE));
				this.setDepreciationId( (String)map.get(AssetDepreciationOperVOMeta.DEPRECIATION_ID));
				this.setCreateBy( (String)map.get(AssetDepreciationOperVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetDepreciationOperVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetDepreciationOperVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetDepreciationOperVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetDepreciationOperVOMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetDepreciationOperVOMeta.NAME));
				this.setTenantId( (String)map.get(AssetDepreciationOperVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetDepreciationOperVOMeta.DELETE_BY));
				this.setExecutionStartTime( (Date)map.get(AssetDepreciationOperVOMeta.EXECUTION_START_TIME));
				this.setId( (String)map.get(AssetDepreciationOperVOMeta.ID));
				this.setOriginatorId( (String)map.get(AssetDepreciationOperVOMeta.ORIGINATOR_ID));
				this.setStatus( (String)map.get(AssetDepreciationOperVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(AssetDepreciationOperVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(AssetDepreciationOperVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(AssetDepreciationOperVOMeta.PAGE_SIZE));
				this.setOriginator( (Employee)map.get(AssetDepreciationOperVOMeta.ORIGINATOR));
				this.setAssetDepreciation( (AssetDepreciation)map.get(AssetDepreciationOperVOMeta.ASSET_DEPRECIATION));
				this.setPageIndex( (Integer)map.get(AssetDepreciationOperVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(AssetDepreciationOperVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(AssetDepreciationOperVOMeta.SORT_FIELD));
				this.setSearchValue( (String)map.get(AssetDepreciationOperVOMeta.SEARCH_VALUE));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetDepreciationOperVOMeta.NOTES)));
			this.setDepreciationCode(DataParser.parse(String.class, r.getValue(AssetDepreciationOperVOMeta.DEPRECIATION_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationOperVOMeta.UPDATE_TIME)));
			this.setExecutionEndTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationOperVOMeta.EXECUTION_END_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetDepreciationOperVOMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetDepreciationOperVOMeta.CONTENT)));
			this.setBusinessDate(DataParser.parse(Date.class, r.getValue(AssetDepreciationOperVOMeta.BUSINESS_DATE)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetDepreciationOperVOMeta.BUSINESS_CODE)));
			this.setDepreciationId(DataParser.parse(String.class, r.getValue(AssetDepreciationOperVOMeta.DEPRECIATION_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationOperVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetDepreciationOperVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationOperVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetDepreciationOperVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationOperVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetDepreciationOperVOMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetDepreciationOperVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetDepreciationOperVOMeta.DELETE_BY)));
			this.setExecutionStartTime(DataParser.parse(Date.class, r.getValue(AssetDepreciationOperVOMeta.EXECUTION_START_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetDepreciationOperVOMeta.ID)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(AssetDepreciationOperVOMeta.ORIGINATOR_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetDepreciationOperVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(AssetDepreciationOperVOMeta.NOTES));
				this.setDepreciationCode( (String)r.getValue(AssetDepreciationOperVOMeta.DEPRECIATION_CODE));
				this.setUpdateTime( (Date)r.getValue(AssetDepreciationOperVOMeta.UPDATE_TIME));
				this.setExecutionEndTime( (Date)r.getValue(AssetDepreciationOperVOMeta.EXECUTION_END_TIME));
				this.setVersion( (Integer)r.getValue(AssetDepreciationOperVOMeta.VERSION));
				this.setContent( (String)r.getValue(AssetDepreciationOperVOMeta.CONTENT));
				this.setBusinessDate( (Date)r.getValue(AssetDepreciationOperVOMeta.BUSINESS_DATE));
				this.setBusinessCode( (String)r.getValue(AssetDepreciationOperVOMeta.BUSINESS_CODE));
				this.setDepreciationId( (String)r.getValue(AssetDepreciationOperVOMeta.DEPRECIATION_ID));
				this.setCreateBy( (String)r.getValue(AssetDepreciationOperVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetDepreciationOperVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetDepreciationOperVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetDepreciationOperVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetDepreciationOperVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetDepreciationOperVOMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetDepreciationOperVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetDepreciationOperVOMeta.DELETE_BY));
				this.setExecutionStartTime( (Date)r.getValue(AssetDepreciationOperVOMeta.EXECUTION_START_TIME));
				this.setId( (String)r.getValue(AssetDepreciationOperVOMeta.ID));
				this.setOriginatorId( (String)r.getValue(AssetDepreciationOperVOMeta.ORIGINATOR_ID));
				this.setStatus( (String)r.getValue(AssetDepreciationOperVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}