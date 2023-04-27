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
import com.dt.platform.domain.wms.meta.ProductVOMeta;
import com.github.foxnic.commons.lang.DataParser;
import java.math.BigDecimal;
import java.util.Date;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 商品VO类型
 * <p>商品 , 数据表 wms_product 的通用VO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 14:02:35
 * @sign F35768A7386ABC9CE252DBD9AC70691D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@ApiModel(description = "商品VO类型 ; 商品 , 数据表 wms_product 的通用VO类型" , parent = Product.class)
public class ProductVO extends Product {

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
	public ProductVO setPageIndex(Integer pageIndex) {
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
	public ProductVO setPageSize(Integer pageSize) {
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
	public ProductVO setSearchField(String searchField) {
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
	public ProductVO setFuzzyField(String fuzzyField) {
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
	public ProductVO setSearchValue(String searchValue) {
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
	public ProductVO setDirtyFields(List<String> dirtyFields) {
		this.dirtyFields=dirtyFields;
		return this;
	}
	
	/**
	 * 添加 已修改字段
	 * @param dirtyField 已修改字段
	 * @return 当前对象
	*/
	public ProductVO addDirtyField(String... dirtyField) {
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
	public ProductVO setSortField(String sortField) {
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
	public ProductVO setSortType(String sortType) {
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
	public ProductVO setDataOrigin(String dataOrigin) {
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
	public ProductVO setQueryLogic(String queryLogic) {
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
	public ProductVO setRequestAction(String requestAction) {
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
	public ProductVO setIds(List<String> ids) {
		this.ids=ids;
		return this;
	}
	
	/**
	 * 添加 主键清单
	 * @param id 主键清单
	 * @return 当前对象
	*/
	public ProductVO addId(String... id) {
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
	 * @return ProductVO , 转换好的 ProductVO 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ProductVO , 转换好的 PoJo 对象
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
	public ProductVO clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ProductVO duplicate(boolean all) {
		com.dt.platform.domain.wms.meta.ProductVOMeta.$$proxy$$ inst = new com.dt.platform.domain.wms.meta.ProductVOMeta.$$proxy$$();
		inst.setProductModel(this.getProductModel());
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setKeepDate(this.getKeepDate());
		inst.setProductBrand(this.getProductBrand());
		inst.setProductSku(this.getProductSku());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setCustId(this.getCustId());
		inst.setEnName(this.getEnName());
		inst.setId(this.getId());
		inst.setHeight(this.getHeight());
		inst.setCustProductCode(this.getCustProductCode());
		inst.setPeriod(this.getPeriod());
		inst.setLength(this.getLength());
		inst.setMinStockNumber(this.getMinStockNumber());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setMaxWeight(this.getMaxWeight());
		inst.setVersion(this.getVersion());
		inst.setMaxVolume(this.getMaxVolume());
		inst.setBarCode(this.getBarCode());
		inst.setUnit(this.getUnit());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setWidth(this.getWidth());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setCategory(this.getCategory());
		if(all) {
			inst.setSearchField(this.getSearchField());
			inst.setRequestAction(this.getRequestAction());
			inst.setFuzzyField(this.getFuzzyField());
			inst.setUnitData(this.getUnitData());
			inst.setPageSize(this.getPageSize());
			inst.setProductCategory(this.getProductCategory());
			inst.setProductAttrIds(this.getProductAttrIds());
			inst.setPageIndex(this.getPageIndex());
			inst.setSortType(this.getSortType());
			inst.setDirtyFields(this.getDirtyFields());
			inst.setSortField(this.getSortField());
			inst.setDataOrigin(this.getDataOrigin());
			inst.setIds(this.getIds());
			inst.setQueryLogic(this.getQueryLogic());
			inst.setSearchValue(this.getSearchValue());
			inst.setProductAttrList(this.getProductAttrList());
			inst.setCustomer(this.getCustomer());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ProductVO clone(boolean deep) {
		return EntityContext.clone(ProductVO.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ProductVO
	 * @param productMap 包含实体信息的 Map 对象
	 * @return ProductVO , 转换好的的 Product 对象
	*/
	@Transient
	public static ProductVO createFrom(Map<String,Object> productMap) {
		if(productMap==null) return null;
		ProductVO vo = create();
		EntityContext.copyProperties(vo,productMap);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 将 Pojo 转换成 ProductVO
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ProductVO , 转换好的的 Product 对象
	*/
	@Transient
	public static ProductVO createFrom(Object pojo) {
		if(pojo==null) return null;
		ProductVO vo = create();
		EntityContext.copyProperties(vo,pojo);
		vo.clearModifies();
		return vo;
	}

	/**
	 * 创建一个 ProductVO，等同于 new
	 * @return ProductVO 对象
	*/
	@Transient
	public static ProductVO create() {
		return new com.dt.platform.domain.wms.meta.ProductVOMeta.$$proxy$$();
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
			this.setProductModel(DataParser.parse(String.class, map.get(ProductVOMeta.PRODUCT_MODEL)));
			this.setCode(DataParser.parse(String.class, map.get(ProductVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(ProductVOMeta.NOTES)));
			this.setKeepDate(DataParser.parse(BigDecimal.class, map.get(ProductVOMeta.KEEP_DATE)));
			this.setProductBrand(DataParser.parse(String.class, map.get(ProductVOMeta.PRODUCT_BRAND)));
			this.setProductSku(DataParser.parse(String.class, map.get(ProductVOMeta.PRODUCT_SKU)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProductVOMeta.UPDATE_BY)));
			this.setCustId(DataParser.parse(String.class, map.get(ProductVOMeta.CUST_ID)));
			this.setEnName(DataParser.parse(String.class, map.get(ProductVOMeta.EN_NAME)));
			this.setId(DataParser.parse(String.class, map.get(ProductVOMeta.ID)));
			this.setHeight(DataParser.parse(BigDecimal.class, map.get(ProductVOMeta.HEIGHT)));
			this.setCustProductCode(DataParser.parse(String.class, map.get(ProductVOMeta.CUST_PRODUCT_CODE)));
			this.setPeriod(DataParser.parse(BigDecimal.class, map.get(ProductVOMeta.PERIOD)));
			this.setLength(DataParser.parse(BigDecimal.class, map.get(ProductVOMeta.LENGTH)));
			this.setMinStockNumber(DataParser.parse(BigDecimal.class, map.get(ProductVOMeta.MIN_STOCK_NUMBER)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProductVOMeta.UPDATE_TIME)));
			this.setMaxWeight(DataParser.parse(BigDecimal.class, map.get(ProductVOMeta.MAX_WEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProductVOMeta.VERSION)));
			this.setMaxVolume(DataParser.parse(BigDecimal.class, map.get(ProductVOMeta.MAX_VOLUME)));
			this.setBarCode(DataParser.parse(String.class, map.get(ProductVOMeta.BAR_CODE)));
			this.setUnit(DataParser.parse(String.class, map.get(ProductVOMeta.UNIT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProductVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProductVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProductVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProductVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(ProductVOMeta.NAME)));
			this.setWidth(DataParser.parse(BigDecimal.class, map.get(ProductVOMeta.WIDTH)));
			this.setTenantId(DataParser.parse(String.class, map.get(ProductVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProductVOMeta.DELETE_BY)));
			this.setCategory(DataParser.parse(String.class, map.get(ProductVOMeta.CATEGORY)));
			// others
			this.setSearchField(DataParser.parse(String.class, map.get(ProductVOMeta.SEARCH_FIELD)));
			this.setRequestAction(DataParser.parse(String.class, map.get(ProductVOMeta.REQUEST_ACTION)));
			this.setFuzzyField(DataParser.parse(String.class, map.get(ProductVOMeta.FUZZY_FIELD)));
			this.setUnitData(DataParser.parse(Unit.class, map.get(ProductVOMeta.UNIT_DATA)));
			this.setPageSize(DataParser.parse(Integer.class, map.get(ProductVOMeta.PAGE_SIZE)));
			this.setProductCategory(DataParser.parse(ProductCategory.class, map.get(ProductVOMeta.PRODUCT_CATEGORY)));
			this.setPageIndex(DataParser.parse(Integer.class, map.get(ProductVOMeta.PAGE_INDEX)));
			this.setSortType(DataParser.parse(String.class, map.get(ProductVOMeta.SORT_TYPE)));
			this.setSortField(DataParser.parse(String.class, map.get(ProductVOMeta.SORT_FIELD)));
			this.setDataOrigin(DataParser.parse(String.class, map.get(ProductVOMeta.DATA_ORIGIN)));
			this.setQueryLogic(DataParser.parse(String.class, map.get(ProductVOMeta.QUERY_LOGIC)));
			this.setSearchValue(DataParser.parse(String.class, map.get(ProductVOMeta.SEARCH_VALUE)));
			this.setCustomer(DataParser.parse(Customer.class, map.get(ProductVOMeta.CUSTOMER)));
			return true;
		} else {
			try {
				this.setProductModel( (String)map.get(ProductVOMeta.PRODUCT_MODEL));
				this.setCode( (String)map.get(ProductVOMeta.CODE));
				this.setNotes( (String)map.get(ProductVOMeta.NOTES));
				this.setKeepDate( (BigDecimal)map.get(ProductVOMeta.KEEP_DATE));
				this.setProductBrand( (String)map.get(ProductVOMeta.PRODUCT_BRAND));
				this.setProductSku( (String)map.get(ProductVOMeta.PRODUCT_SKU));
				this.setUpdateBy( (String)map.get(ProductVOMeta.UPDATE_BY));
				this.setCustId( (String)map.get(ProductVOMeta.CUST_ID));
				this.setEnName( (String)map.get(ProductVOMeta.EN_NAME));
				this.setId( (String)map.get(ProductVOMeta.ID));
				this.setHeight( (BigDecimal)map.get(ProductVOMeta.HEIGHT));
				this.setCustProductCode( (String)map.get(ProductVOMeta.CUST_PRODUCT_CODE));
				this.setPeriod( (BigDecimal)map.get(ProductVOMeta.PERIOD));
				this.setLength( (BigDecimal)map.get(ProductVOMeta.LENGTH));
				this.setMinStockNumber( (BigDecimal)map.get(ProductVOMeta.MIN_STOCK_NUMBER));
				this.setUpdateTime( (Date)map.get(ProductVOMeta.UPDATE_TIME));
				this.setMaxWeight( (BigDecimal)map.get(ProductVOMeta.MAX_WEIGHT));
				this.setVersion( (Integer)map.get(ProductVOMeta.VERSION));
				this.setMaxVolume( (BigDecimal)map.get(ProductVOMeta.MAX_VOLUME));
				this.setBarCode( (String)map.get(ProductVOMeta.BAR_CODE));
				this.setUnit( (String)map.get(ProductVOMeta.UNIT));
				this.setCreateBy( (String)map.get(ProductVOMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ProductVOMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProductVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(ProductVOMeta.DELETE_TIME));
				this.setName( (String)map.get(ProductVOMeta.NAME));
				this.setWidth( (BigDecimal)map.get(ProductVOMeta.WIDTH));
				this.setTenantId( (String)map.get(ProductVOMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ProductVOMeta.DELETE_BY));
				this.setCategory( (String)map.get(ProductVOMeta.CATEGORY));
				// others
				this.setSearchField( (String)map.get(ProductVOMeta.SEARCH_FIELD));
				this.setRequestAction( (String)map.get(ProductVOMeta.REQUEST_ACTION));
				this.setFuzzyField( (String)map.get(ProductVOMeta.FUZZY_FIELD));
				this.setUnitData( (Unit)map.get(ProductVOMeta.UNIT_DATA));
				this.setPageSize( (Integer)map.get(ProductVOMeta.PAGE_SIZE));
				this.setProductCategory( (ProductCategory)map.get(ProductVOMeta.PRODUCT_CATEGORY));
				this.setPageIndex( (Integer)map.get(ProductVOMeta.PAGE_INDEX));
				this.setSortType( (String)map.get(ProductVOMeta.SORT_TYPE));
				this.setSortField( (String)map.get(ProductVOMeta.SORT_FIELD));
				this.setDataOrigin( (String)map.get(ProductVOMeta.DATA_ORIGIN));
				this.setQueryLogic( (String)map.get(ProductVOMeta.QUERY_LOGIC));
				this.setSearchValue( (String)map.get(ProductVOMeta.SEARCH_VALUE));
				this.setCustomer( (Customer)map.get(ProductVOMeta.CUSTOMER));
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
			this.setProductModel(DataParser.parse(String.class, r.getValue(ProductVOMeta.PRODUCT_MODEL)));
			this.setCode(DataParser.parse(String.class, r.getValue(ProductVOMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ProductVOMeta.NOTES)));
			this.setKeepDate(DataParser.parse(BigDecimal.class, r.getValue(ProductVOMeta.KEEP_DATE)));
			this.setProductBrand(DataParser.parse(String.class, r.getValue(ProductVOMeta.PRODUCT_BRAND)));
			this.setProductSku(DataParser.parse(String.class, r.getValue(ProductVOMeta.PRODUCT_SKU)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProductVOMeta.UPDATE_BY)));
			this.setCustId(DataParser.parse(String.class, r.getValue(ProductVOMeta.CUST_ID)));
			this.setEnName(DataParser.parse(String.class, r.getValue(ProductVOMeta.EN_NAME)));
			this.setId(DataParser.parse(String.class, r.getValue(ProductVOMeta.ID)));
			this.setHeight(DataParser.parse(BigDecimal.class, r.getValue(ProductVOMeta.HEIGHT)));
			this.setCustProductCode(DataParser.parse(String.class, r.getValue(ProductVOMeta.CUST_PRODUCT_CODE)));
			this.setPeriod(DataParser.parse(BigDecimal.class, r.getValue(ProductVOMeta.PERIOD)));
			this.setLength(DataParser.parse(BigDecimal.class, r.getValue(ProductVOMeta.LENGTH)));
			this.setMinStockNumber(DataParser.parse(BigDecimal.class, r.getValue(ProductVOMeta.MIN_STOCK_NUMBER)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProductVOMeta.UPDATE_TIME)));
			this.setMaxWeight(DataParser.parse(BigDecimal.class, r.getValue(ProductVOMeta.MAX_WEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProductVOMeta.VERSION)));
			this.setMaxVolume(DataParser.parse(BigDecimal.class, r.getValue(ProductVOMeta.MAX_VOLUME)));
			this.setBarCode(DataParser.parse(String.class, r.getValue(ProductVOMeta.BAR_CODE)));
			this.setUnit(DataParser.parse(String.class, r.getValue(ProductVOMeta.UNIT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProductVOMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProductVOMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProductVOMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProductVOMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(ProductVOMeta.NAME)));
			this.setWidth(DataParser.parse(BigDecimal.class, r.getValue(ProductVOMeta.WIDTH)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ProductVOMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProductVOMeta.DELETE_BY)));
			this.setCategory(DataParser.parse(String.class, r.getValue(ProductVOMeta.CATEGORY)));
			return true;
		} else {
			try {
				this.setProductModel( (String)r.getValue(ProductVOMeta.PRODUCT_MODEL));
				this.setCode( (String)r.getValue(ProductVOMeta.CODE));
				this.setNotes( (String)r.getValue(ProductVOMeta.NOTES));
				this.setKeepDate( (BigDecimal)r.getValue(ProductVOMeta.KEEP_DATE));
				this.setProductBrand( (String)r.getValue(ProductVOMeta.PRODUCT_BRAND));
				this.setProductSku( (String)r.getValue(ProductVOMeta.PRODUCT_SKU));
				this.setUpdateBy( (String)r.getValue(ProductVOMeta.UPDATE_BY));
				this.setCustId( (String)r.getValue(ProductVOMeta.CUST_ID));
				this.setEnName( (String)r.getValue(ProductVOMeta.EN_NAME));
				this.setId( (String)r.getValue(ProductVOMeta.ID));
				this.setHeight( (BigDecimal)r.getValue(ProductVOMeta.HEIGHT));
				this.setCustProductCode( (String)r.getValue(ProductVOMeta.CUST_PRODUCT_CODE));
				this.setPeriod( (BigDecimal)r.getValue(ProductVOMeta.PERIOD));
				this.setLength( (BigDecimal)r.getValue(ProductVOMeta.LENGTH));
				this.setMinStockNumber( (BigDecimal)r.getValue(ProductVOMeta.MIN_STOCK_NUMBER));
				this.setUpdateTime( (Date)r.getValue(ProductVOMeta.UPDATE_TIME));
				this.setMaxWeight( (BigDecimal)r.getValue(ProductVOMeta.MAX_WEIGHT));
				this.setVersion( (Integer)r.getValue(ProductVOMeta.VERSION));
				this.setMaxVolume( (BigDecimal)r.getValue(ProductVOMeta.MAX_VOLUME));
				this.setBarCode( (String)r.getValue(ProductVOMeta.BAR_CODE));
				this.setUnit( (String)r.getValue(ProductVOMeta.UNIT));
				this.setCreateBy( (String)r.getValue(ProductVOMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ProductVOMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProductVOMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(ProductVOMeta.DELETE_TIME));
				this.setName( (String)r.getValue(ProductVOMeta.NAME));
				this.setWidth( (BigDecimal)r.getValue(ProductVOMeta.WIDTH));
				this.setTenantId( (String)r.getValue(ProductVOMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ProductVOMeta.DELETE_BY));
				this.setCategory( (String)r.getValue(ProductVOMeta.CATEGORY));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}