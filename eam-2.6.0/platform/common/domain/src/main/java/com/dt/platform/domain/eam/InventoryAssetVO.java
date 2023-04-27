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
import com.dt.platform.domain.eam.meta.InventoryAssetVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 盘点明细VO类型
 * <p>盘点明细 , 数据表 eam_inventory_asset 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-10 19:28:54
 * @sign A694483B206991F722270A248EFD64F9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "盘点明细VO类型 ; 盘点明细 , 数据表 eam_inventory_asset 的通用VO类型" , parent = InventoryAsset.class)
public class InventoryAssetVO extends InventoryAsset {

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
	public InventoryAssetVO setPageIndex(Integer pageIndex) {
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
	public InventoryAssetVO setPageSize(Integer pageSize) {
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
	public InventoryAssetVO setSearchField(String searchField) {
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
	public InventoryAssetVO setFuzzyField(String fuzzyField) {
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
	public InventoryAssetVO setSearchValue(String searchValue) {
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
	public InventoryAssetVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public InventoryAssetVO addDirtyField(String... dirtyField) {
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
	public InventoryAssetVO setSortField(String sortField) {
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
	public InventoryAssetVO setSortType(String sortType) {
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
	public InventoryAssetVO setDataOrigin(String dataOrigin) {
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
	public InventoryAssetVO setQueryLogic(String queryLogic) {
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
	public InventoryAssetVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public InventoryAssetVO addId(String... id) {
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
	 * @return InventoryAssetVO , 转换好的 InventoryAssetVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InventoryAssetVO , 转换好的 PoJo 对象
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
	public InventoryAssetVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InventoryAssetVO duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InventoryAssetVOMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InventoryAssetVOMeta.$$proxy$$();
		inst.setAssetLossActionType(this.getAssetLossActionType());
		inst.setOperDate(this.getOperDate());
		inst.setFlag(this.getFlag());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSource(this.getSource());
		inst.setVersion(this.getVersion());
		inst.setAssetPlusActionType(this.getAssetPlusActionType());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPictureId(this.getPictureId());
		inst.setOperEmplId(this.getOperEmplId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setInventoryId(this.getInventoryId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOperater(this.getOperater());
			inst.setSearchField(this.getSearchField());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setPageSize(this.getPageSize());
			inst.setInventory(this.getInventory());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setAsset(this.getAsset());
			inst.setSearchValue(this.getSearchValue());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InventoryAssetVO clone(boolean deep) {
		return EntityContext.clone(InventoryAssetVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InventoryAssetVO
	 * @param inventoryAssetMap 包含实体信息的 Map 对象
	 * @return InventoryAssetVO , 转换好的的 InventoryAsset 对象
	*/
	@Transient
	public static InventoryAssetVO createFrom(Map<String,Object> inventoryAssetMap) {
		if(inventoryAssetMap==null) return null;
		InventoryAssetVO vo = create();
		EntityContext.copyProperties(vo,inventoryAssetMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 InventoryAssetVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InventoryAssetVO , 转换好的的 InventoryAsset 对象
	*/
	@Transient
	public static InventoryAssetVO createFrom(Object pojo) {
		if(pojo==null) return null;
		InventoryAssetVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 InventoryAssetVO，等同于 new
	 * @return InventoryAssetVO 对象
	*/
	@Transient
	public static InventoryAssetVO create() {
		return new com.dt.platform.domain.eam.meta.InventoryAssetVOMeta.$$proxy$$();
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
			this.setAssetLossActionType(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.ASSET_LOSS_ACTION_TYPE)));
			this.setOperDate(DataParser.parse(Date.class, map.get(InventoryAssetVOMeta.OPER_DATE)));
			this.setFlag(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.FLAG)));
			this.setNotes(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InventoryAssetVOMeta.UPDATE_TIME)));
			this.setSource(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.SOURCE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InventoryAssetVOMeta.VERSION)));
			this.setAssetPlusActionType(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.ASSET_PLUS_ACTION_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InventoryAssetVOMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.PICTURE_ID)));
			this.setOperEmplId(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.OPER_EMPL_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InventoryAssetVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InventoryAssetVOMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.ASSET_ID)));
			this.setInventoryId(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.INVENTORY_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.STATUS)));
			// others
			this.setOperater(DataParser.parse(Employee.class, map.get(InventoryAssetVOMeta.OPERATER)));
			this.setSearchField(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.SEARCH_FIELD)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.FUZZY_FIELD)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(InventoryAssetVOMeta.PAGE_SIZE)));
			this.setInventory(DataParser.parse(Inventory.class, map.get(InventoryAssetVOMeta.INVENTORY)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(InventoryAssetVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.QUERY_LOGIC)));
			this.setAsset(DataParser.parse(Asset.class, map.get(InventoryAssetVOMeta.ASSET)));
			this.setSearchValue(DataParser.parse(String.class, map.get(InventoryAssetVOMeta.SEARCH_VALUE)));
			return true;
		} else {
			try {
				this.setAssetLossActionType( (String)map.get(InventoryAssetVOMeta.ASSET_LOSS_ACTION_TYPE));
				this.setOperDate( (Date)map.get(InventoryAssetVOMeta.OPER_DATE));
				this.setFlag( (String)map.get(InventoryAssetVOMeta.FLAG));
				this.setNotes( (String)map.get(InventoryAssetVOMeta.NOTES));
				this.setUpdateTime( (Date)map.get(InventoryAssetVOMeta.UPDATE_TIME));
				this.setSource( (String)map.get(InventoryAssetVOMeta.SOURCE));
				this.setVersion( (Integer)map.get(InventoryAssetVOMeta.VERSION));
				this.setAssetPlusActionType( (String)map.get(InventoryAssetVOMeta.ASSET_PLUS_ACTION_TYPE));
				this.setCreateBy( (String)map.get(InventoryAssetVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InventoryAssetVOMeta.DELETED));
				this.setPictureId( (String)map.get(InventoryAssetVOMeta.PICTURE_ID));
				this.setOperEmplId( (String)map.get(InventoryAssetVOMeta.OPER_EMPL_ID));
				this.setCreateTime( (Date)map.get(InventoryAssetVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(InventoryAssetVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(InventoryAssetVOMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(InventoryAssetVOMeta.ASSET_ID));
				this.setInventoryId( (String)map.get(InventoryAssetVOMeta.INVENTORY_ID));
				this.setDeleteBy( (String)map.get(InventoryAssetVOMeta.DELETE_BY));
				this.setId( (String)map.get(InventoryAssetVOMeta.ID));
				this.setStatus( (String)map.get(InventoryAssetVOMeta.STATUS));
				// others
				this.setOperater( (Employee)map.get(InventoryAssetVOMeta.OPERATER));
				this.setSearchField( (String)map.get(InventoryAssetVOMeta.SEARCH_FIELD));
				this.setFuzzyField( (String)map.get(InventoryAssetVOMeta.FUZZY_FIELD));
				this.setPageSize( (Integer)map.get(InventoryAssetVOMeta.PAGE_SIZE));
				this.setInventory( (Inventory)map.get(InventoryAssetVOMeta.INVENTORY));
				this.setPageIndex( (Integer)map.get(InventoryAssetVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(InventoryAssetVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(InventoryAssetVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(InventoryAssetVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(InventoryAssetVOMeta.QUERY_LOGIC));
				this.setAsset( (Asset)map.get(InventoryAssetVOMeta.ASSET));
				this.setSearchValue( (String)map.get(InventoryAssetVOMeta.SEARCH_VALUE));
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
			this.setAssetLossActionType(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.ASSET_LOSS_ACTION_TYPE)));
			this.setOperDate(DataParser.parse(Date.class, r.getValue(InventoryAssetVOMeta.OPER_DATE)));
			this.setFlag(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.FLAG)));
			this.setNotes(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InventoryAssetVOMeta.UPDATE_TIME)));
			this.setSource(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.SOURCE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InventoryAssetVOMeta.VERSION)));
			this.setAssetPlusActionType(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.ASSET_PLUS_ACTION_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InventoryAssetVOMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.PICTURE_ID)));
			this.setOperEmplId(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.OPER_EMPL_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InventoryAssetVOMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InventoryAssetVOMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.ASSET_ID)));
			this.setInventoryId(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.INVENTORY_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(InventoryAssetVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setAssetLossActionType( (String)r.getValue(InventoryAssetVOMeta.ASSET_LOSS_ACTION_TYPE));
				this.setOperDate( (Date)r.getValue(InventoryAssetVOMeta.OPER_DATE));
				this.setFlag( (String)r.getValue(InventoryAssetVOMeta.FLAG));
				this.setNotes( (String)r.getValue(InventoryAssetVOMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(InventoryAssetVOMeta.UPDATE_TIME));
				this.setSource( (String)r.getValue(InventoryAssetVOMeta.SOURCE));
				this.setVersion( (Integer)r.getValue(InventoryAssetVOMeta.VERSION));
				this.setAssetPlusActionType( (String)r.getValue(InventoryAssetVOMeta.ASSET_PLUS_ACTION_TYPE));
				this.setCreateBy( (String)r.getValue(InventoryAssetVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InventoryAssetVOMeta.DELETED));
				this.setPictureId( (String)r.getValue(InventoryAssetVOMeta.PICTURE_ID));
				this.setOperEmplId( (String)r.getValue(InventoryAssetVOMeta.OPER_EMPL_ID));
				this.setCreateTime( (Date)r.getValue(InventoryAssetVOMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(InventoryAssetVOMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(InventoryAssetVOMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(InventoryAssetVOMeta.ASSET_ID));
				this.setInventoryId( (String)r.getValue(InventoryAssetVOMeta.INVENTORY_ID));
				this.setDeleteBy( (String)r.getValue(InventoryAssetVOMeta.DELETE_BY));
				this.setId( (String)r.getValue(InventoryAssetVOMeta.ID));
				this.setStatus( (String)r.getValue(InventoryAssetVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}