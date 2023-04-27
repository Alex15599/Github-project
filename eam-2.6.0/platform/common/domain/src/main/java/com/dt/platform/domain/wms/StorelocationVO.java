package com.dt.platform.domain.wms;

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
import com.dt.platform.domain.wms.meta.StorelocationVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 储位VO类型
 * <p>储位 , 数据表 wms_storelocation 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 13:53:30
 * @sign 7D224A61321B8C84C0E187F99554C0D7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "储位VO类型 ; 储位 , 数据表 wms_storelocation 的通用VO类型" , parent = Storelocation.class)
public class StorelocationVO extends Storelocation {

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
	public StorelocationVO setPageIndex(Integer pageIndex) {
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
	public StorelocationVO setPageSize(Integer pageSize) {
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
	public StorelocationVO setSearchField(String searchField) {
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
	public StorelocationVO setFuzzyField(String fuzzyField) {
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
	public StorelocationVO setSearchValue(String searchValue) {
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
	public StorelocationVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public StorelocationVO addDirtyField(String... dirtyField) {
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
	public StorelocationVO setSortField(String sortField) {
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
	public StorelocationVO setSortType(String sortType) {
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
	public StorelocationVO setDataOrigin(String dataOrigin) {
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
	public StorelocationVO setQueryLogic(String queryLogic) {
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
	public StorelocationVO setRequestAction(String requestAction) {
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
	public StorelocationVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public StorelocationVO addId(String... id) {
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
	 * @return StorelocationVO , 转换好的 StorelocationVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return StorelocationVO , 转换好的 PoJo 对象
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
	public StorelocationVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public StorelocationVO duplicate(boolean all) {
		com.dt.platform.domain.wms.meta.StorelocationVOMeta.$$proxy$$ inst = new com.dt.platform.domain.wms.meta.StorelocationVOMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setMaxBatch(this.getMaxBatch());
		inst.setType(this.getType());
		inst.setYCoordinate(this.getYCoordinate());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setNotes2(this.getNotes2());
		inst.setNotes1(this.getNotes1());
		inst.setCustomerId(this.getCustomerId());
		inst.setId(this.getId());
		inst.setMinBatch(this.getMinBatch());
		inst.setLocationGroup(this.getLocationGroup());
		inst.setLocationAttribute(this.getLocationAttribute());
		inst.setHeight(this.getHeight());
		inst.setLength(this.getLength());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setMaxWeight(this.getMaxWeight());
		inst.setVersion(this.getVersion());
		inst.setMaxVolume(this.getMaxVolume());
		inst.setBarCode(this.getBarCode());
		inst.setXCoordinate(this.getXCoordinate());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setStorehouseId(this.getStorehouseId());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setWidth(this.getWidth());
		inst.setZCoordinate(this.getZCoordinate());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setRfid(this.getRfid());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setTemperatureAttribute(this.getTemperatureAttribute());
			inst.setPageSize(this.getPageSize());
			inst.setStorehouse(this.getStorehouse());
			inst.setProductAttrIds(this.getProductAttrIds());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setLocType(this.getLocType());
			inst.setSearchValue(this.getSearchValue());
			inst.setCustomer(this.getCustomer());
			inst.setProductAttrList(this.getProductAttrList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public StorelocationVO clone(boolean deep) {
		return EntityContext.clone(StorelocationVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 StorelocationVO
	 * @param storelocationMap 包含实体信息的 Map 对象
	 * @return StorelocationVO , 转换好的的 Storelocation 对象
	*/
	@Transient
	public static StorelocationVO createFrom(Map<String,Object> storelocationMap) {
		if(storelocationMap==null) return null;
		StorelocationVO vo = create();
		EntityContext.copyProperties(vo,storelocationMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 StorelocationVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return StorelocationVO , 转换好的的 Storelocation 对象
	*/
	@Transient
	public static StorelocationVO createFrom(Object pojo) {
		if(pojo==null) return null;
		StorelocationVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 StorelocationVO，等同于 new
	 * @return StorelocationVO 对象
	*/
	@Transient
	public static StorelocationVO create() {
		return new com.dt.platform.domain.wms.meta.StorelocationVOMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(StorelocationVOMeta.CODE)));
			this.setMaxBatch(DataParser.parse(BigDecimal.class, map.get(StorelocationVOMeta.MAX_BATCH)));
			this.setType(DataParser.parse(String.class, map.get(StorelocationVOMeta.TYPE)));
			this.setYCoordinate(DataParser.parse(BigDecimal.class, map.get(StorelocationVOMeta.Y_COORDINATE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(StorelocationVOMeta.UPDATE_BY)));
			this.setNotes2(DataParser.parse(String.class, map.get(StorelocationVOMeta.NOTES2)));
			this.setNotes1(DataParser.parse(String.class, map.get(StorelocationVOMeta.NOTES1)));
			this.setCustomerId(DataParser.parse(String.class, map.get(StorelocationVOMeta.CUSTOMER_ID)));
			this.setId(DataParser.parse(String.class, map.get(StorelocationVOMeta.ID)));
			this.setMinBatch(DataParser.parse(BigDecimal.class, map.get(StorelocationVOMeta.MIN_BATCH)));
			this.setLocationGroup(DataParser.parse(String.class, map.get(StorelocationVOMeta.LOCATION_GROUP)));
			this.setLocationAttribute(DataParser.parse(String.class, map.get(StorelocationVOMeta.LOCATION_ATTRIBUTE)));
			this.setHeight(DataParser.parse(BigDecimal.class, map.get(StorelocationVOMeta.HEIGHT)));
			this.setLength(DataParser.parse(BigDecimal.class, map.get(StorelocationVOMeta.LENGTH)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(StorelocationVOMeta.UPDATE_TIME)));
			this.setMaxWeight(DataParser.parse(BigDecimal.class, map.get(StorelocationVOMeta.MAX_WEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(StorelocationVOMeta.VERSION)));
			this.setMaxVolume(DataParser.parse(BigDecimal.class, map.get(StorelocationVOMeta.MAX_VOLUME)));
			this.setBarCode(DataParser.parse(String.class, map.get(StorelocationVOMeta.BAR_CODE)));
			this.setXCoordinate(DataParser.parse(BigDecimal.class, map.get(StorelocationVOMeta.X_COORDINATE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(StorelocationVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(StorelocationVOMeta.DELETED)));
			this.setStorehouseId(DataParser.parse(String.class, map.get(StorelocationVOMeta.STOREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(StorelocationVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(StorelocationVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(StorelocationVOMeta.NAME)));
			this.setWidth(DataParser.parse(BigDecimal.class, map.get(StorelocationVOMeta.WIDTH)));
			this.setZCoordinate(DataParser.parse(BigDecimal.class, map.get(StorelocationVOMeta.Z_COORDINATE)));
			this.setTenantId(DataParser.parse(String.class, map.get(StorelocationVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(StorelocationVOMeta.DELETE_BY)));
			this.setRfid(DataParser.parse(String.class, map.get(StorelocationVOMeta.RFID)));
			this.setStatus(DataParser.parse(String.class, map.get(StorelocationVOMeta.STATUS)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(StorelocationVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(StorelocationVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(StorelocationVOMeta.FUZZY_FIELD)));
			this.setTemperatureAttribute(DataParser.parse(TemperatureAttribute.class, map.get(StorelocationVOMeta.TEMPERATURE_ATTRIBUTE)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(StorelocationVOMeta.PAGE_SIZE)));
			this.setStorehouse(DataParser.parse(Storehouse.class, map.get(StorelocationVOMeta.STOREHOUSE)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(StorelocationVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(StorelocationVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(StorelocationVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(StorelocationVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(StorelocationVOMeta.QUERY_LOGIC)));
			this.setLocType(DataParser.parse(LocType.class, map.get(StorelocationVOMeta.LOC_TYPE)));
			this.setSearchValue(DataParser.parse(String.class, map.get(StorelocationVOMeta.SEARCH_VALUE)));
			this.setCustomer(DataParser.parse(Customer.class, map.get(StorelocationVOMeta.CUSTOMER)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(StorelocationVOMeta.CODE));
				this.setMaxBatch( (BigDecimal)map.get(StorelocationVOMeta.MAX_BATCH));
				this.setType( (String)map.get(StorelocationVOMeta.TYPE));
				this.setYCoordinate( (BigDecimal)map.get(StorelocationVOMeta.Y_COORDINATE));
				this.setUpdateBy( (String)map.get(StorelocationVOMeta.UPDATE_BY));
				this.setNotes2( (String)map.get(StorelocationVOMeta.NOTES2));
				this.setNotes1( (String)map.get(StorelocationVOMeta.NOTES1));
				this.setCustomerId( (String)map.get(StorelocationVOMeta.CUSTOMER_ID));
				this.setId( (String)map.get(StorelocationVOMeta.ID));
				this.setMinBatch( (BigDecimal)map.get(StorelocationVOMeta.MIN_BATCH));
				this.setLocationGroup( (String)map.get(StorelocationVOMeta.LOCATION_GROUP));
				this.setLocationAttribute( (String)map.get(StorelocationVOMeta.LOCATION_ATTRIBUTE));
				this.setHeight( (BigDecimal)map.get(StorelocationVOMeta.HEIGHT));
				this.setLength( (BigDecimal)map.get(StorelocationVOMeta.LENGTH));
				this.setUpdateTime( (Date)map.get(StorelocationVOMeta.UPDATE_TIME));
				this.setMaxWeight( (BigDecimal)map.get(StorelocationVOMeta.MAX_WEIGHT));
				this.setVersion( (Integer)map.get(StorelocationVOMeta.VERSION));
				this.setMaxVolume( (BigDecimal)map.get(StorelocationVOMeta.MAX_VOLUME));
				this.setBarCode( (String)map.get(StorelocationVOMeta.BAR_CODE));
				this.setXCoordinate( (BigDecimal)map.get(StorelocationVOMeta.X_COORDINATE));
				this.setCreateBy( (String)map.get(StorelocationVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(StorelocationVOMeta.DELETED));
				this.setStorehouseId( (String)map.get(StorelocationVOMeta.STOREHOUSE_ID));
				this.setCreateTime( (Date)map.get(StorelocationVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(StorelocationVOMeta.DELETE_TIME));
				this.setName( (String)map.get(StorelocationVOMeta.NAME));
				this.setWidth( (BigDecimal)map.get(StorelocationVOMeta.WIDTH));
				this.setZCoordinate( (BigDecimal)map.get(StorelocationVOMeta.Z_COORDINATE));
				this.setTenantId( (String)map.get(StorelocationVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(StorelocationVOMeta.DELETE_BY));
				this.setRfid( (String)map.get(StorelocationVOMeta.RFID));
				this.setStatus( (String)map.get(StorelocationVOMeta.STATUS));
				// others
				this.setSearchField( (String)map.get(StorelocationVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(StorelocationVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(StorelocationVOMeta.FUZZY_FIELD));
				this.setTemperatureAttribute( (TemperatureAttribute)map.get(StorelocationVOMeta.TEMPERATURE_ATTRIBUTE));
				this.setPageSize( (Integer)map.get(StorelocationVOMeta.PAGE_SIZE));
				this.setStorehouse( (Storehouse)map.get(StorelocationVOMeta.STOREHOUSE));
				this.setPageIndex( (Integer)map.get(StorelocationVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(StorelocationVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(StorelocationVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(StorelocationVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(StorelocationVOMeta.QUERY_LOGIC));
				this.setLocType( (LocType)map.get(StorelocationVOMeta.LOC_TYPE));
				this.setSearchValue( (String)map.get(StorelocationVOMeta.SEARCH_VALUE));
				this.setCustomer( (Customer)map.get(StorelocationVOMeta.CUSTOMER));
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
			this.setCode(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.CODE)));
			this.setMaxBatch(DataParser.parse(BigDecimal.class, r.getValue(StorelocationVOMeta.MAX_BATCH)));
			this.setType(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.TYPE)));
			this.setYCoordinate(DataParser.parse(BigDecimal.class, r.getValue(StorelocationVOMeta.Y_COORDINATE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.UPDATE_BY)));
			this.setNotes2(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.NOTES2)));
			this.setNotes1(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.NOTES1)));
			this.setCustomerId(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.CUSTOMER_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.ID)));
			this.setMinBatch(DataParser.parse(BigDecimal.class, r.getValue(StorelocationVOMeta.MIN_BATCH)));
			this.setLocationGroup(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.LOCATION_GROUP)));
			this.setLocationAttribute(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.LOCATION_ATTRIBUTE)));
			this.setHeight(DataParser.parse(BigDecimal.class, r.getValue(StorelocationVOMeta.HEIGHT)));
			this.setLength(DataParser.parse(BigDecimal.class, r.getValue(StorelocationVOMeta.LENGTH)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(StorelocationVOMeta.UPDATE_TIME)));
			this.setMaxWeight(DataParser.parse(BigDecimal.class, r.getValue(StorelocationVOMeta.MAX_WEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(StorelocationVOMeta.VERSION)));
			this.setMaxVolume(DataParser.parse(BigDecimal.class, r.getValue(StorelocationVOMeta.MAX_VOLUME)));
			this.setBarCode(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.BAR_CODE)));
			this.setXCoordinate(DataParser.parse(BigDecimal.class, r.getValue(StorelocationVOMeta.X_COORDINATE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(StorelocationVOMeta.DELETED)));
			this.setStorehouseId(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.STOREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(StorelocationVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(StorelocationVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.NAME)));
			this.setWidth(DataParser.parse(BigDecimal.class, r.getValue(StorelocationVOMeta.WIDTH)));
			this.setZCoordinate(DataParser.parse(BigDecimal.class, r.getValue(StorelocationVOMeta.Z_COORDINATE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.DELETE_BY)));
			this.setRfid(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.RFID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(StorelocationVOMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(StorelocationVOMeta.CODE));
				this.setMaxBatch( (BigDecimal)r.getValue(StorelocationVOMeta.MAX_BATCH));
				this.setType( (String)r.getValue(StorelocationVOMeta.TYPE));
				this.setYCoordinate( (BigDecimal)r.getValue(StorelocationVOMeta.Y_COORDINATE));
				this.setUpdateBy( (String)r.getValue(StorelocationVOMeta.UPDATE_BY));
				this.setNotes2( (String)r.getValue(StorelocationVOMeta.NOTES2));
				this.setNotes1( (String)r.getValue(StorelocationVOMeta.NOTES1));
				this.setCustomerId( (String)r.getValue(StorelocationVOMeta.CUSTOMER_ID));
				this.setId( (String)r.getValue(StorelocationVOMeta.ID));
				this.setMinBatch( (BigDecimal)r.getValue(StorelocationVOMeta.MIN_BATCH));
				this.setLocationGroup( (String)r.getValue(StorelocationVOMeta.LOCATION_GROUP));
				this.setLocationAttribute( (String)r.getValue(StorelocationVOMeta.LOCATION_ATTRIBUTE));
				this.setHeight( (BigDecimal)r.getValue(StorelocationVOMeta.HEIGHT));
				this.setLength( (BigDecimal)r.getValue(StorelocationVOMeta.LENGTH));
				this.setUpdateTime( (Date)r.getValue(StorelocationVOMeta.UPDATE_TIME));
				this.setMaxWeight( (BigDecimal)r.getValue(StorelocationVOMeta.MAX_WEIGHT));
				this.setVersion( (Integer)r.getValue(StorelocationVOMeta.VERSION));
				this.setMaxVolume( (BigDecimal)r.getValue(StorelocationVOMeta.MAX_VOLUME));
				this.setBarCode( (String)r.getValue(StorelocationVOMeta.BAR_CODE));
				this.setXCoordinate( (BigDecimal)r.getValue(StorelocationVOMeta.X_COORDINATE));
				this.setCreateBy( (String)r.getValue(StorelocationVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(StorelocationVOMeta.DELETED));
				this.setStorehouseId( (String)r.getValue(StorelocationVOMeta.STOREHOUSE_ID));
				this.setCreateTime( (Date)r.getValue(StorelocationVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(StorelocationVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(StorelocationVOMeta.NAME));
				this.setWidth( (BigDecimal)r.getValue(StorelocationVOMeta.WIDTH));
				this.setZCoordinate( (BigDecimal)r.getValue(StorelocationVOMeta.Z_COORDINATE));
				this.setTenantId( (String)r.getValue(StorelocationVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(StorelocationVOMeta.DELETE_BY));
				this.setRfid( (String)r.getValue(StorelocationVOMeta.RFID));
				this.setStatus( (String)r.getValue(StorelocationVOMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}