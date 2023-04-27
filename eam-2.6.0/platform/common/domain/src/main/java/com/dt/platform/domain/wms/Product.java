package com.dt.platform.domain.wms;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.WmsTables.WMS_PRODUCT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.wms.meta.ProductMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 商品
 * <p>商品 , 数据表 wms_product 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 14:02:35
 * @sign F384678280ED10715A4C03F1CE3B72C2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "wms_product")
@ApiModel(description = "商品 ; 商品 , 数据表 wms_product 的PO类型")
public class Product extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WMS_PRODUCT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "684397689625903104")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "1212")
	private String code;
	
	/**
	 * 条形码：条形码
	*/
	@ApiModelProperty(required = false,value="条形码" , notes = "条形码")
	private String barCode;
	
	/**
	 * 货主：货主
	*/
	@ApiModelProperty(required = false,value="货主" , notes = "货主" , example = "684373683455655936")
	private String custId;
	
	/**
	 * 客户商品编码：客户商品编码
	*/
	@ApiModelProperty(required = false,value="客户商品编码" , notes = "客户商品编码" , example = "1212")
	private String custProductCode;
	
	/**
	 * 商品规格：商品规格
	*/
	@ApiModelProperty(required = false,value="商品规格" , notes = "商品规格")
	private String productModel;
	
	/**
	 * 商品品牌：商品品牌
	*/
	@ApiModelProperty(required = false,value="商品品牌" , notes = "商品品牌")
	private String productBrand;
	
	/**
	 * 商品SKU：商品SKU
	*/
	@ApiModelProperty(required = false,value="商品SKU" , notes = "商品SKU")
	private String productSku;
	
	/**
	 * 大类：大类
	*/
	@ApiModelProperty(required = false,value="大类" , notes = "大类" , example = "684327471675342848")
	private String category;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "商品1")
	private String name;
	
	/**
	 * 英文名称：英文名称
	*/
	@ApiModelProperty(required = false,value="英文名称" , notes = "英文名称")
	private String enName;
	
	/**
	 * 单位：单位
	*/
	@ApiModelProperty(required = false,value="单位" , notes = "单位" , example = "684022001882365952")
	private String unit;
	
	/**
	 * 长：长
	*/
	@ApiModelProperty(required = false,value="长" , notes = "长" , example = "0.00")
	private BigDecimal length;
	
	/**
	 * 宽：宽
	*/
	@ApiModelProperty(required = false,value="宽" , notes = "宽" , example = "0.00")
	private BigDecimal width;
	
	/**
	 * 高：高
	*/
	@ApiModelProperty(required = false,value="高" , notes = "高" , example = "0.00")
	private BigDecimal height;
	
	/**
	 * 最大体积：最大体积
	*/
	@ApiModelProperty(required = false,value="最大体积" , notes = "最大体积" , example = "0.00")
	private BigDecimal maxVolume;
	
	/**
	 * 最大重量：最大重量
	*/
	@ApiModelProperty(required = false,value="最大重量" , notes = "最大重量" , example = "0.00")
	private BigDecimal maxWeight;
	
	/**
	 * 保质期：保质期
	*/
	@ApiModelProperty(required = false,value="保质期" , notes = "保质期" , example = "0")
	private BigDecimal period;
	
	/**
	 * 允收天数：允收天数
	*/
	@ApiModelProperty(required = false,value="允收天数" , notes = "允收天数" , example = "0")
	private BigDecimal keepDate;
	
	/**
	 * 最小库存数量：最小库存数量
	*/
	@ApiModelProperty(required = false,value="最小库存数量" , notes = "最小库存数量" , example = "1")
	private BigDecimal minStockNumber;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-03-04 01:52:05")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除" , example = "0")
	private Integer deleted;
	@Transient
	@EnumFor("deleted")
	private Boolean deletedBool;
	
	/**
	 * 删除人ID：删除人ID
	*/
	@ApiModelProperty(required = false,value="删除人ID" , notes = "删除人ID")
	private String deleteBy;
	
	/**
	 * 删除时间：删除时间
	*/
	@ApiModelProperty(required = false,value="删除时间" , notes = "删除时间")
	private Date deleteTime;
	
	/**
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * productAttr：productAttr
	*/
	@ApiModelProperty(required = false,value="productAttr" , notes = "productAttr")
	private List<ProductAttr> productAttrList;
	
	/**
	 * productAttrIds：productAttrIds
	*/
	@ApiModelProperty(required = false,value="productAttrIds" , notes = "productAttrIds")
	private List<String> productAttrIds;
	
	/**
	 * customer：customer
	*/
	@ApiModelProperty(required = false,value="customer" , notes = "customer")
	private Customer customer;
	
	/**
	 * UnitData：UnitData
	*/
	@ApiModelProperty(required = false,value="UnitData" , notes = "UnitData")
	private Unit unitData;
	
	/**
	 * productCategory：productCategory
	*/
	@ApiModelProperty(required = false,value="productCategory" , notes = "productCategory")
	private ProductCategory productCategory;
	
	/**
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public Product setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	public Product setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 条形码<br>
	 * 条形码
	 * @return 条形码
	*/
	public String getBarCode() {
		return barCode;
	}
	
	/**
	 * 设置 条形码
	 * @param barCode 条形码
	 * @return 当前对象
	*/
	public Product setBarCode(String barCode) {
		this.barCode=barCode;
		return this;
	}
	
	/**
	 * 获得 货主<br>
	 * 货主
	 * @return 货主
	*/
	public String getCustId() {
		return custId;
	}
	
	/**
	 * 设置 货主
	 * @param custId 货主
	 * @return 当前对象
	*/
	public Product setCustId(String custId) {
		this.custId=custId;
		return this;
	}
	
	/**
	 * 获得 客户商品编码<br>
	 * 客户商品编码
	 * @return 客户商品编码
	*/
	public String getCustProductCode() {
		return custProductCode;
	}
	
	/**
	 * 设置 客户商品编码
	 * @param custProductCode 客户商品编码
	 * @return 当前对象
	*/
	public Product setCustProductCode(String custProductCode) {
		this.custProductCode=custProductCode;
		return this;
	}
	
	/**
	 * 获得 商品规格<br>
	 * 商品规格
	 * @return 商品规格
	*/
	public String getProductModel() {
		return productModel;
	}
	
	/**
	 * 设置 商品规格
	 * @param productModel 商品规格
	 * @return 当前对象
	*/
	public Product setProductModel(String productModel) {
		this.productModel=productModel;
		return this;
	}
	
	/**
	 * 获得 商品品牌<br>
	 * 商品品牌
	 * @return 商品品牌
	*/
	public String getProductBrand() {
		return productBrand;
	}
	
	/**
	 * 设置 商品品牌
	 * @param productBrand 商品品牌
	 * @return 当前对象
	*/
	public Product setProductBrand(String productBrand) {
		this.productBrand=productBrand;
		return this;
	}
	
	/**
	 * 获得 商品SKU<br>
	 * 商品SKU
	 * @return 商品SKU
	*/
	public String getProductSku() {
		return productSku;
	}
	
	/**
	 * 设置 商品SKU
	 * @param productSku 商品SKU
	 * @return 当前对象
	*/
	public Product setProductSku(String productSku) {
		this.productSku=productSku;
		return this;
	}
	
	/**
	 * 获得 大类<br>
	 * 大类
	 * @return 大类
	*/
	public String getCategory() {
		return category;
	}
	
	/**
	 * 设置 大类
	 * @param category 大类
	 * @return 当前对象
	*/
	public Product setCategory(String category) {
		this.category=category;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 名称
	 * @param name 名称
	 * @return 当前对象
	*/
	public Product setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 英文名称<br>
	 * 英文名称
	 * @return 英文名称
	*/
	public String getEnName() {
		return enName;
	}
	
	/**
	 * 设置 英文名称
	 * @param enName 英文名称
	 * @return 当前对象
	*/
	public Product setEnName(String enName) {
		this.enName=enName;
		return this;
	}
	
	/**
	 * 获得 单位<br>
	 * 单位
	 * @return 单位
	*/
	public String getUnit() {
		return unit;
	}
	
	/**
	 * 设置 单位
	 * @param unit 单位
	 * @return 当前对象
	*/
	public Product setUnit(String unit) {
		this.unit=unit;
		return this;
	}
	
	/**
	 * 获得 长<br>
	 * 长
	 * @return 长
	*/
	public BigDecimal getLength() {
		return length;
	}
	
	/**
	 * 设置 长
	 * @param length 长
	 * @return 当前对象
	*/
	public Product setLength(BigDecimal length) {
		this.length=length;
		return this;
	}
	
	/**
	 * 获得 宽<br>
	 * 宽
	 * @return 宽
	*/
	public BigDecimal getWidth() {
		return width;
	}
	
	/**
	 * 设置 宽
	 * @param width 宽
	 * @return 当前对象
	*/
	public Product setWidth(BigDecimal width) {
		this.width=width;
		return this;
	}
	
	/**
	 * 获得 高<br>
	 * 高
	 * @return 高
	*/
	public BigDecimal getHeight() {
		return height;
	}
	
	/**
	 * 设置 高
	 * @param height 高
	 * @return 当前对象
	*/
	public Product setHeight(BigDecimal height) {
		this.height=height;
		return this;
	}
	
	/**
	 * 获得 最大体积<br>
	 * 最大体积
	 * @return 最大体积
	*/
	public BigDecimal getMaxVolume() {
		return maxVolume;
	}
	
	/**
	 * 设置 最大体积
	 * @param maxVolume 最大体积
	 * @return 当前对象
	*/
	public Product setMaxVolume(BigDecimal maxVolume) {
		this.maxVolume=maxVolume;
		return this;
	}
	
	/**
	 * 获得 最大重量<br>
	 * 最大重量
	 * @return 最大重量
	*/
	public BigDecimal getMaxWeight() {
		return maxWeight;
	}
	
	/**
	 * 设置 最大重量
	 * @param maxWeight 最大重量
	 * @return 当前对象
	*/
	public Product setMaxWeight(BigDecimal maxWeight) {
		this.maxWeight=maxWeight;
		return this;
	}
	
	/**
	 * 获得 保质期<br>
	 * 保质期
	 * @return 保质期
	*/
	public BigDecimal getPeriod() {
		return period;
	}
	
	/**
	 * 设置 保质期
	 * @param period 保质期
	 * @return 当前对象
	*/
	public Product setPeriod(BigDecimal period) {
		this.period=period;
		return this;
	}
	
	/**
	 * 获得 允收天数<br>
	 * 允收天数
	 * @return 允收天数
	*/
	public BigDecimal getKeepDate() {
		return keepDate;
	}
	
	/**
	 * 设置 允收天数
	 * @param keepDate 允收天数
	 * @return 当前对象
	*/
	public Product setKeepDate(BigDecimal keepDate) {
		this.keepDate=keepDate;
		return this;
	}
	
	/**
	 * 获得 最小库存数量<br>
	 * 最小库存数量
	 * @return 最小库存数量
	*/
	public BigDecimal getMinStockNumber() {
		return minStockNumber;
	}
	
	/**
	 * 设置 最小库存数量
	 * @param minStockNumber 最小库存数量
	 * @return 当前对象
	*/
	public Product setMinStockNumber(BigDecimal minStockNumber) {
		this.minStockNumber=minStockNumber;
		return this;
	}
	
	/**
	 * 获得 备注<br>
	 * 备注
	 * @return 备注
	*/
	public String getNotes() {
		return notes;
	}
	
	/**
	 * 设置 备注
	 * @param notes 备注
	 * @return 当前对象
	*/
	public Product setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 创建人ID<br>
	 * 创建人ID
	 * @return 创建人ID
	*/
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 设置 创建人ID
	 * @param createBy 创建人ID
	 * @return 当前对象
	*/
	public Product setCreateBy(String createBy) {
		this.createBy=createBy;
		return this;
	}
	
	/**
	 * 获得 创建时间<br>
	 * 创建时间
	 * @return 创建时间
	*/
	public Date getCreateTime() {
		return createTime;
	}
	
	/**
	 * 设置 创建时间
	 * @param createTime 创建时间
	 * @return 当前对象
	*/
	public Product setCreateTime(Date createTime) {
		this.createTime=createTime;
		return this;
	}
	
	/**
	 * 获得 修改人ID<br>
	 * 修改人ID
	 * @return 修改人ID
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	
	/**
	 * 设置 修改人ID
	 * @param updateBy 修改人ID
	 * @return 当前对象
	*/
	public Product setUpdateBy(String updateBy) {
		this.updateBy=updateBy;
		return this;
	}
	
	/**
	 * 获得 修改时间<br>
	 * 修改时间
	 * @return 修改时间
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	
	/**
	 * 设置 修改时间
	 * @param updateTime 修改时间
	 * @return 当前对象
	*/
	public Product setUpdateTime(Date updateTime) {
		this.updateTime=updateTime;
		return this;
	}
	
	/**
	 * 获得 是否已删除<br>
	 * 是否已删除
	 * @return 是否已删除
	*/
	public Integer getDeleted() {
		return deleted;
	}
	
	/**
	 * 获得 是否已删除 的投影属性<br>
	 * 等价于 getDeleted 方法，获得对应的枚举类型
	 * @return 是否已删除
	*/
	@Transient
	public Boolean isDeleted() {
		if(this.deletedBool==null) {
			this.deletedBool=DataParser.parseBoolean(deleted);
		}
		return this.deletedBool ;
	}
	
	/**
	 * 设置 是否已删除
	 * @param deleted 是否已删除
	 * @return 当前对象
	*/
	@JsonProperty("deleted")
	public Product setDeleted(Integer deleted) {
		this.deleted=deleted;
		this.deletedBool=DataParser.parseBoolean(deleted);
		return this;
	}
	
	/**
	 * 设置 是否已删除的投影属性，等同于设置 是否已删除
	 * @param deletedBool 是否已删除
	 * @return 当前对象
	*/
	@Transient
	public Product setDeleted(Boolean deletedBool) {
		if(deletedBool==null) {
			this.deleted=null;
		} else {
			this.deleted=deletedBool?1:0;
		}
		this.deletedBool=deletedBool;
		return this;
	}
	
	/**
	 * 获得 删除人ID<br>
	 * 删除人ID
	 * @return 删除人ID
	*/
	public String getDeleteBy() {
		return deleteBy;
	}
	
	/**
	 * 设置 删除人ID
	 * @param deleteBy 删除人ID
	 * @return 当前对象
	*/
	public Product setDeleteBy(String deleteBy) {
		this.deleteBy=deleteBy;
		return this;
	}
	
	/**
	 * 获得 删除时间<br>
	 * 删除时间
	 * @return 删除时间
	*/
	public Date getDeleteTime() {
		return deleteTime;
	}
	
	/**
	 * 设置 删除时间
	 * @param deleteTime 删除时间
	 * @return 当前对象
	*/
	public Product setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public Product setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 租户<br>
	 * 租户
	 * @return 租户
	*/
	public String getTenantId() {
		return tenantId;
	}
	
	/**
	 * 设置 租户
	 * @param tenantId 租户
	 * @return 当前对象
	*/
	public Product setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 productAttr<br>
	 * productAttr
	 * @return productAttr
	*/
	public List<ProductAttr> getProductAttrList() {
		return productAttrList;
	}
	
	/**
	 * 设置 productAttr
	 * @param productAttrList productAttr
	 * @return 当前对象
	*/
	public Product setProductAttrList(List<ProductAttr> productAttrList) {
		this.productAttrList=productAttrList;
		return this;
	}
	
	/**
	 * 添加 productAttr
	 * @param productAttr productAttr
	 * @return 当前对象
	*/
	public Product addProductAttr(ProductAttr... productAttr) {
		if(this.productAttrList==null) productAttrList=new ArrayList<>();
		this.productAttrList.addAll(Arrays.asList(productAttr));
		return this;
	}
	
	/**
	 * 获得 productAttrIds<br>
	 * productAttrIds
	 * @return productAttrIds
	*/
	public List<String> getProductAttrIds() {
		return productAttrIds;
	}
	
	/**
	 * 设置 productAttrIds
	 * @param productAttrIds productAttrIds
	 * @return 当前对象
	*/
	public Product setProductAttrIds(List<String> productAttrIds) {
		this.productAttrIds=productAttrIds;
		return this;
	}
	
	/**
	 * 添加 productAttrIds
	 * @param productAttrId productAttrIds
	 * @return 当前对象
	*/
	public Product addProductAttrId(String... productAttrId) {
		if(this.productAttrIds==null) productAttrIds=new ArrayList<>();
		this.productAttrIds.addAll(Arrays.asList(productAttrId));
		return this;
	}
	
	/**
	 * 获得 customer<br>
	 * customer
	 * @return customer
	*/
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * 设置 customer
	 * @param customer customer
	 * @return 当前对象
	*/
	public Product setCustomer(Customer customer) {
		this.customer=customer;
		return this;
	}
	
	/**
	 * 获得 UnitData<br>
	 * UnitData
	 * @return UnitData
	*/
	public Unit getUnitData() {
		return unitData;
	}
	
	/**
	 * 设置 UnitData
	 * @param unitData UnitData
	 * @return 当前对象
	*/
	public Product setUnitData(Unit unitData) {
		this.unitData=unitData;
		return this;
	}
	
	/**
	 * 获得 productCategory<br>
	 * productCategory
	 * @return productCategory
	*/
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	
	/**
	 * 设置 productCategory
	 * @param productCategory productCategory
	 * @return 当前对象
	*/
	public Product setProductCategory(ProductCategory productCategory) {
		this.productCategory=productCategory;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Product , 转换好的 Product 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Product , 转换好的 PoJo 对象
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
	public Product clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Product duplicate(boolean all) {
		com.dt.platform.domain.wms.meta.ProductMeta.$$proxy$$ inst = new com.dt.platform.domain.wms.meta.ProductMeta.$$proxy$$();
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
			inst.setProductAttrIds(this.getProductAttrIds());
			inst.setUnitData(this.getUnitData());
			inst.setProductAttrList(this.getProductAttrList());
			inst.setCustomer(this.getCustomer());
			inst.setProductCategory(this.getProductCategory());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Product clone(boolean deep) {
		return EntityContext.clone(Product.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Product
	 * @param productMap 包含实体信息的 Map 对象
	 * @return Product , 转换好的的 Product 对象
	*/
	@Transient
	public static Product createFrom(Map<String,Object> productMap) {
		if(productMap==null) return null;
		Product po = create();
		EntityContext.copyProperties(po,productMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Product
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Product , 转换好的的 Product 对象
	*/
	@Transient
	public static Product createFrom(Object pojo) {
		if(pojo==null) return null;
		Product po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Product，等同于 new
	 * @return Product 对象
	*/
	@Transient
	public static Product create() {
		return new com.dt.platform.domain.wms.meta.ProductMeta.$$proxy$$();
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
			this.setProductModel(DataParser.parse(String.class, map.get(ProductMeta.PRODUCT_MODEL)));
			this.setCode(DataParser.parse(String.class, map.get(ProductMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(ProductMeta.NOTES)));
			this.setKeepDate(DataParser.parse(BigDecimal.class, map.get(ProductMeta.KEEP_DATE)));
			this.setProductBrand(DataParser.parse(String.class, map.get(ProductMeta.PRODUCT_BRAND)));
			this.setProductSku(DataParser.parse(String.class, map.get(ProductMeta.PRODUCT_SKU)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(ProductMeta.UPDATE_BY)));
			this.setCustId(DataParser.parse(String.class, map.get(ProductMeta.CUST_ID)));
			this.setEnName(DataParser.parse(String.class, map.get(ProductMeta.EN_NAME)));
			this.setId(DataParser.parse(String.class, map.get(ProductMeta.ID)));
			this.setHeight(DataParser.parse(BigDecimal.class, map.get(ProductMeta.HEIGHT)));
			this.setCustProductCode(DataParser.parse(String.class, map.get(ProductMeta.CUST_PRODUCT_CODE)));
			this.setPeriod(DataParser.parse(BigDecimal.class, map.get(ProductMeta.PERIOD)));
			this.setLength(DataParser.parse(BigDecimal.class, map.get(ProductMeta.LENGTH)));
			this.setMinStockNumber(DataParser.parse(BigDecimal.class, map.get(ProductMeta.MIN_STOCK_NUMBER)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(ProductMeta.UPDATE_TIME)));
			this.setMaxWeight(DataParser.parse(BigDecimal.class, map.get(ProductMeta.MAX_WEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(ProductMeta.VERSION)));
			this.setMaxVolume(DataParser.parse(BigDecimal.class, map.get(ProductMeta.MAX_VOLUME)));
			this.setBarCode(DataParser.parse(String.class, map.get(ProductMeta.BAR_CODE)));
			this.setUnit(DataParser.parse(String.class, map.get(ProductMeta.UNIT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(ProductMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(ProductMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(ProductMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(ProductMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(ProductMeta.NAME)));
			this.setWidth(DataParser.parse(BigDecimal.class, map.get(ProductMeta.WIDTH)));
			this.setTenantId(DataParser.parse(String.class, map.get(ProductMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(ProductMeta.DELETE_BY)));
			this.setCategory(DataParser.parse(String.class, map.get(ProductMeta.CATEGORY)));
			// others
			this.setUnitData(DataParser.parse(Unit.class, map.get(ProductMeta.UNIT_DATA)));
			this.setCustomer(DataParser.parse(Customer.class, map.get(ProductMeta.CUSTOMER)));
			this.setProductCategory(DataParser.parse(ProductCategory.class, map.get(ProductMeta.PRODUCT_CATEGORY)));
			return true;
		} else {
			try {
				this.setProductModel( (String)map.get(ProductMeta.PRODUCT_MODEL));
				this.setCode( (String)map.get(ProductMeta.CODE));
				this.setNotes( (String)map.get(ProductMeta.NOTES));
				this.setKeepDate( (BigDecimal)map.get(ProductMeta.KEEP_DATE));
				this.setProductBrand( (String)map.get(ProductMeta.PRODUCT_BRAND));
				this.setProductSku( (String)map.get(ProductMeta.PRODUCT_SKU));
				this.setUpdateBy( (String)map.get(ProductMeta.UPDATE_BY));
				this.setCustId( (String)map.get(ProductMeta.CUST_ID));
				this.setEnName( (String)map.get(ProductMeta.EN_NAME));
				this.setId( (String)map.get(ProductMeta.ID));
				this.setHeight( (BigDecimal)map.get(ProductMeta.HEIGHT));
				this.setCustProductCode( (String)map.get(ProductMeta.CUST_PRODUCT_CODE));
				this.setPeriod( (BigDecimal)map.get(ProductMeta.PERIOD));
				this.setLength( (BigDecimal)map.get(ProductMeta.LENGTH));
				this.setMinStockNumber( (BigDecimal)map.get(ProductMeta.MIN_STOCK_NUMBER));
				this.setUpdateTime( (Date)map.get(ProductMeta.UPDATE_TIME));
				this.setMaxWeight( (BigDecimal)map.get(ProductMeta.MAX_WEIGHT));
				this.setVersion( (Integer)map.get(ProductMeta.VERSION));
				this.setMaxVolume( (BigDecimal)map.get(ProductMeta.MAX_VOLUME));
				this.setBarCode( (String)map.get(ProductMeta.BAR_CODE));
				this.setUnit( (String)map.get(ProductMeta.UNIT));
				this.setCreateBy( (String)map.get(ProductMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(ProductMeta.DELETED));
				this.setCreateTime( (Date)map.get(ProductMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(ProductMeta.DELETE_TIME));
				this.setName( (String)map.get(ProductMeta.NAME));
				this.setWidth( (BigDecimal)map.get(ProductMeta.WIDTH));
				this.setTenantId( (String)map.get(ProductMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(ProductMeta.DELETE_BY));
				this.setCategory( (String)map.get(ProductMeta.CATEGORY));
				// others
				this.setUnitData( (Unit)map.get(ProductMeta.UNIT_DATA));
				this.setCustomer( (Customer)map.get(ProductMeta.CUSTOMER));
				this.setProductCategory( (ProductCategory)map.get(ProductMeta.PRODUCT_CATEGORY));
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
			this.setProductModel(DataParser.parse(String.class, r.getValue(ProductMeta.PRODUCT_MODEL)));
			this.setCode(DataParser.parse(String.class, r.getValue(ProductMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(ProductMeta.NOTES)));
			this.setKeepDate(DataParser.parse(BigDecimal.class, r.getValue(ProductMeta.KEEP_DATE)));
			this.setProductBrand(DataParser.parse(String.class, r.getValue(ProductMeta.PRODUCT_BRAND)));
			this.setProductSku(DataParser.parse(String.class, r.getValue(ProductMeta.PRODUCT_SKU)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(ProductMeta.UPDATE_BY)));
			this.setCustId(DataParser.parse(String.class, r.getValue(ProductMeta.CUST_ID)));
			this.setEnName(DataParser.parse(String.class, r.getValue(ProductMeta.EN_NAME)));
			this.setId(DataParser.parse(String.class, r.getValue(ProductMeta.ID)));
			this.setHeight(DataParser.parse(BigDecimal.class, r.getValue(ProductMeta.HEIGHT)));
			this.setCustProductCode(DataParser.parse(String.class, r.getValue(ProductMeta.CUST_PRODUCT_CODE)));
			this.setPeriod(DataParser.parse(BigDecimal.class, r.getValue(ProductMeta.PERIOD)));
			this.setLength(DataParser.parse(BigDecimal.class, r.getValue(ProductMeta.LENGTH)));
			this.setMinStockNumber(DataParser.parse(BigDecimal.class, r.getValue(ProductMeta.MIN_STOCK_NUMBER)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(ProductMeta.UPDATE_TIME)));
			this.setMaxWeight(DataParser.parse(BigDecimal.class, r.getValue(ProductMeta.MAX_WEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(ProductMeta.VERSION)));
			this.setMaxVolume(DataParser.parse(BigDecimal.class, r.getValue(ProductMeta.MAX_VOLUME)));
			this.setBarCode(DataParser.parse(String.class, r.getValue(ProductMeta.BAR_CODE)));
			this.setUnit(DataParser.parse(String.class, r.getValue(ProductMeta.UNIT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(ProductMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(ProductMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(ProductMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(ProductMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(ProductMeta.NAME)));
			this.setWidth(DataParser.parse(BigDecimal.class, r.getValue(ProductMeta.WIDTH)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(ProductMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(ProductMeta.DELETE_BY)));
			this.setCategory(DataParser.parse(String.class, r.getValue(ProductMeta.CATEGORY)));
			return true;
		} else {
			try {
				this.setProductModel( (String)r.getValue(ProductMeta.PRODUCT_MODEL));
				this.setCode( (String)r.getValue(ProductMeta.CODE));
				this.setNotes( (String)r.getValue(ProductMeta.NOTES));
				this.setKeepDate( (BigDecimal)r.getValue(ProductMeta.KEEP_DATE));
				this.setProductBrand( (String)r.getValue(ProductMeta.PRODUCT_BRAND));
				this.setProductSku( (String)r.getValue(ProductMeta.PRODUCT_SKU));
				this.setUpdateBy( (String)r.getValue(ProductMeta.UPDATE_BY));
				this.setCustId( (String)r.getValue(ProductMeta.CUST_ID));
				this.setEnName( (String)r.getValue(ProductMeta.EN_NAME));
				this.setId( (String)r.getValue(ProductMeta.ID));
				this.setHeight( (BigDecimal)r.getValue(ProductMeta.HEIGHT));
				this.setCustProductCode( (String)r.getValue(ProductMeta.CUST_PRODUCT_CODE));
				this.setPeriod( (BigDecimal)r.getValue(ProductMeta.PERIOD));
				this.setLength( (BigDecimal)r.getValue(ProductMeta.LENGTH));
				this.setMinStockNumber( (BigDecimal)r.getValue(ProductMeta.MIN_STOCK_NUMBER));
				this.setUpdateTime( (Date)r.getValue(ProductMeta.UPDATE_TIME));
				this.setMaxWeight( (BigDecimal)r.getValue(ProductMeta.MAX_WEIGHT));
				this.setVersion( (Integer)r.getValue(ProductMeta.VERSION));
				this.setMaxVolume( (BigDecimal)r.getValue(ProductMeta.MAX_VOLUME));
				this.setBarCode( (String)r.getValue(ProductMeta.BAR_CODE));
				this.setUnit( (String)r.getValue(ProductMeta.UNIT));
				this.setCreateBy( (String)r.getValue(ProductMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(ProductMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(ProductMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(ProductMeta.DELETE_TIME));
				this.setName( (String)r.getValue(ProductMeta.NAME));
				this.setWidth( (BigDecimal)r.getValue(ProductMeta.WIDTH));
				this.setTenantId( (String)r.getValue(ProductMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(ProductMeta.DELETE_BY));
				this.setCategory( (String)r.getValue(ProductMeta.CATEGORY));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}