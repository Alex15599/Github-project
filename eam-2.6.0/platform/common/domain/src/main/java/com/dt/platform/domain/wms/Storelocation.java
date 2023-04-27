package com.dt.platform.domain.wms;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.WmsTables.WMS_STORELOCATION;
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
import com.dt.platform.domain.wms.meta.StorelocationMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 储位
 * <p>储位 , 数据表 wms_storelocation 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 13:53:30
 * @sign F745605BE81C51AA5ECDF870BF3AEA64
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "wms_storelocation")
@ApiModel(description = "储位 ; 储位 , 数据表 wms_storelocation 的PO类型")
public class Storelocation extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WMS_STORELOCATION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 仓库：仓库
	*/
	@ApiModelProperty(required = false,value="仓库" , notes = "仓库")
	private String storehouseId;
	
	/**
	 * 所属客户：所属客户
	*/
	@ApiModelProperty(required = false,value="所属客户" , notes = "所属客户")
	private String customerId;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码")
	private String code;
	
	/**
	 * 条码：条码
	*/
	@ApiModelProperty(required = false,value="条码" , notes = "条码")
	private String barCode;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String type;
	
	/**
	 * 仓库组：仓库组
	*/
	@ApiModelProperty(required = false,value="仓库组" , notes = "仓库组")
	private String locationGroup;
	
	/**
	 * 库位属性：库位属性
	*/
	@ApiModelProperty(required = false,value="库位属性" , notes = "库位属性")
	private String locationAttribute;
	
	/**
	 * RFID标签：RFID标签
	*/
	@ApiModelProperty(required = false,value="RFID标签" , notes = "RFID标签")
	private String rfid;
	
	/**
	 * 长：长
	*/
	@ApiModelProperty(required = false,value="长" , notes = "长")
	private BigDecimal length;
	
	/**
	 * 宽：宽
	*/
	@ApiModelProperty(required = false,value="宽" , notes = "宽")
	private BigDecimal width;
	
	/**
	 * 高：高
	*/
	@ApiModelProperty(required = false,value="高" , notes = "高")
	private BigDecimal height;
	
	/**
	 * 最大体积：最大体积
	*/
	@ApiModelProperty(required = false,value="最大体积" , notes = "最大体积")
	private BigDecimal maxVolume;
	
	/**
	 * 最大重量：最大重量
	*/
	@ApiModelProperty(required = false,value="最大重量" , notes = "最大重量")
	private BigDecimal maxWeight;
	
	/**
	 * 最小批量：最小批量
	*/
	@ApiModelProperty(required = false,value="最小批量" , notes = "最小批量")
	private BigDecimal minBatch;
	
	/**
	 * 最大批量：最大批量
	*/
	@ApiModelProperty(required = false,value="最大批量" , notes = "最大批量")
	private BigDecimal maxBatch;
	
	/**
	 * X坐标：X坐标
	*/
	@ApiModelProperty(required = false,value="X坐标" , notes = "X坐标")
	private BigDecimal xCoordinate;
	
	/**
	 * Y坐标：Y坐标
	*/
	@ApiModelProperty(required = false,value="Y坐标" , notes = "Y坐标")
	private BigDecimal yCoordinate;
	
	/**
	 * Z坐标：Z坐标
	*/
	@ApiModelProperty(required = false,value="Z坐标" , notes = "Z坐标")
	private BigDecimal zCoordinate;
	
	/**
	 * 备注1：备注1
	*/
	@ApiModelProperty(required = false,value="备注1" , notes = "备注1")
	private String notes1;
	
	/**
	 * 备注2：备注2
	*/
	@ApiModelProperty(required = false,value="备注2" , notes = "备注2")
	private String notes2;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
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
	@ApiModelProperty(required = true,value="是否已删除" , notes = "是否已删除")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * storehouse：storehouse
	*/
	@ApiModelProperty(required = false,value="storehouse" , notes = "storehouse")
	private Storehouse storehouse;
	
	/**
	 * customer：customer
	*/
	@ApiModelProperty(required = false,value="customer" , notes = "customer")
	private Customer customer;
	
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
	 * locType：locType
	*/
	@ApiModelProperty(required = false,value="locType" , notes = "locType")
	private LocType locType;
	
	/**
	 * temperatureAttribute：temperatureAttribute
	*/
	@ApiModelProperty(required = false,value="temperatureAttribute" , notes = "temperatureAttribute")
	private TemperatureAttribute temperatureAttribute;
	
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
	public Storelocation setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 仓库<br>
	 * 仓库
	 * @return 仓库
	*/
	public String getStorehouseId() {
		return storehouseId;
	}
	
	/**
	 * 设置 仓库
	 * @param storehouseId 仓库
	 * @return 当前对象
	*/
	public Storelocation setStorehouseId(String storehouseId) {
		this.storehouseId=storehouseId;
		return this;
	}
	
	/**
	 * 获得 所属客户<br>
	 * 所属客户
	 * @return 所属客户
	*/
	public String getCustomerId() {
		return customerId;
	}
	
	/**
	 * 设置 所属客户
	 * @param customerId 所属客户
	 * @return 当前对象
	*/
	public Storelocation setCustomerId(String customerId) {
		this.customerId=customerId;
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
	public Storelocation setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 条码<br>
	 * 条码
	 * @return 条码
	*/
	public String getBarCode() {
		return barCode;
	}
	
	/**
	 * 设置 条码
	 * @param barCode 条码
	 * @return 当前对象
	*/
	public Storelocation setBarCode(String barCode) {
		this.barCode=barCode;
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
	public Storelocation setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 状态<br>
	 * 状态
	 * @return 状态
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 状态
	 * @param status 状态
	 * @return 当前对象
	*/
	public Storelocation setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public Storelocation setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 仓库组<br>
	 * 仓库组
	 * @return 仓库组
	*/
	public String getLocationGroup() {
		return locationGroup;
	}
	
	/**
	 * 设置 仓库组
	 * @param locationGroup 仓库组
	 * @return 当前对象
	*/
	public Storelocation setLocationGroup(String locationGroup) {
		this.locationGroup=locationGroup;
		return this;
	}
	
	/**
	 * 获得 库位属性<br>
	 * 库位属性
	 * @return 库位属性
	*/
	public String getLocationAttribute() {
		return locationAttribute;
	}
	
	/**
	 * 设置 库位属性
	 * @param locationAttribute 库位属性
	 * @return 当前对象
	*/
	public Storelocation setLocationAttribute(String locationAttribute) {
		this.locationAttribute=locationAttribute;
		return this;
	}
	
	/**
	 * 获得 RFID标签<br>
	 * RFID标签
	 * @return RFID标签
	*/
	public String getRfid() {
		return rfid;
	}
	
	/**
	 * 设置 RFID标签
	 * @param rfid RFID标签
	 * @return 当前对象
	*/
	public Storelocation setRfid(String rfid) {
		this.rfid=rfid;
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
	public Storelocation setLength(BigDecimal length) {
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
	public Storelocation setWidth(BigDecimal width) {
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
	public Storelocation setHeight(BigDecimal height) {
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
	public Storelocation setMaxVolume(BigDecimal maxVolume) {
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
	public Storelocation setMaxWeight(BigDecimal maxWeight) {
		this.maxWeight=maxWeight;
		return this;
	}
	
	/**
	 * 获得 最小批量<br>
	 * 最小批量
	 * @return 最小批量
	*/
	public BigDecimal getMinBatch() {
		return minBatch;
	}
	
	/**
	 * 设置 最小批量
	 * @param minBatch 最小批量
	 * @return 当前对象
	*/
	public Storelocation setMinBatch(BigDecimal minBatch) {
		this.minBatch=minBatch;
		return this;
	}
	
	/**
	 * 获得 最大批量<br>
	 * 最大批量
	 * @return 最大批量
	*/
	public BigDecimal getMaxBatch() {
		return maxBatch;
	}
	
	/**
	 * 设置 最大批量
	 * @param maxBatch 最大批量
	 * @return 当前对象
	*/
	public Storelocation setMaxBatch(BigDecimal maxBatch) {
		this.maxBatch=maxBatch;
		return this;
	}
	
	/**
	 * 获得 X坐标<br>
	 * X坐标
	 * @return X坐标
	*/
	public BigDecimal getXCoordinate() {
		return xCoordinate;
	}
	
	/**
	 * 设置 X坐标
	 * @param xCoordinate X坐标
	 * @return 当前对象
	*/
	public Storelocation setXCoordinate(BigDecimal xCoordinate) {
		this.xCoordinate=xCoordinate;
		return this;
	}
	
	/**
	 * 获得 Y坐标<br>
	 * Y坐标
	 * @return Y坐标
	*/
	public BigDecimal getYCoordinate() {
		return yCoordinate;
	}
	
	/**
	 * 设置 Y坐标
	 * @param yCoordinate Y坐标
	 * @return 当前对象
	*/
	public Storelocation setYCoordinate(BigDecimal yCoordinate) {
		this.yCoordinate=yCoordinate;
		return this;
	}
	
	/**
	 * 获得 Z坐标<br>
	 * Z坐标
	 * @return Z坐标
	*/
	public BigDecimal getZCoordinate() {
		return zCoordinate;
	}
	
	/**
	 * 设置 Z坐标
	 * @param zCoordinate Z坐标
	 * @return 当前对象
	*/
	public Storelocation setZCoordinate(BigDecimal zCoordinate) {
		this.zCoordinate=zCoordinate;
		return this;
	}
	
	/**
	 * 获得 备注1<br>
	 * 备注1
	 * @return 备注1
	*/
	public String getNotes1() {
		return notes1;
	}
	
	/**
	 * 设置 备注1
	 * @param notes1 备注1
	 * @return 当前对象
	*/
	public Storelocation setNotes1(String notes1) {
		this.notes1=notes1;
		return this;
	}
	
	/**
	 * 获得 备注2<br>
	 * 备注2
	 * @return 备注2
	*/
	public String getNotes2() {
		return notes2;
	}
	
	/**
	 * 设置 备注2
	 * @param notes2 备注2
	 * @return 当前对象
	*/
	public Storelocation setNotes2(String notes2) {
		this.notes2=notes2;
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
	public Storelocation setCreateBy(String createBy) {
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
	public Storelocation setCreateTime(Date createTime) {
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
	public Storelocation setUpdateBy(String updateBy) {
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
	public Storelocation setUpdateTime(Date updateTime) {
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
	public Storelocation setDeleted(Integer deleted) {
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
	public Storelocation setDeleted(Boolean deletedBool) {
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
	public Storelocation setDeleteBy(String deleteBy) {
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
	public Storelocation setDeleteTime(Date deleteTime) {
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
	public Storelocation setVersion(Integer version) {
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
	public Storelocation setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 storehouse<br>
	 * storehouse
	 * @return storehouse
	*/
	public Storehouse getStorehouse() {
		return storehouse;
	}
	
	/**
	 * 设置 storehouse
	 * @param storehouse storehouse
	 * @return 当前对象
	*/
	public Storelocation setStorehouse(Storehouse storehouse) {
		this.storehouse=storehouse;
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
	public Storelocation setCustomer(Customer customer) {
		this.customer=customer;
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
	public Storelocation setProductAttrList(List<ProductAttr> productAttrList) {
		this.productAttrList=productAttrList;
		return this;
	}
	
	/**
	 * 添加 productAttr
	 * @param productAttr productAttr
	 * @return 当前对象
	*/
	public Storelocation addProductAttr(ProductAttr... productAttr) {
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
	public Storelocation setProductAttrIds(List<String> productAttrIds) {
		this.productAttrIds=productAttrIds;
		return this;
	}
	
	/**
	 * 添加 productAttrIds
	 * @param productAttrId productAttrIds
	 * @return 当前对象
	*/
	public Storelocation addProductAttrId(String... productAttrId) {
		if(this.productAttrIds==null) productAttrIds=new ArrayList<>();
		this.productAttrIds.addAll(Arrays.asList(productAttrId));
		return this;
	}
	
	/**
	 * 获得 locType<br>
	 * locType
	 * @return locType
	*/
	public LocType getLocType() {
		return locType;
	}
	
	/**
	 * 设置 locType
	 * @param locType locType
	 * @return 当前对象
	*/
	public Storelocation setLocType(LocType locType) {
		this.locType=locType;
		return this;
	}
	
	/**
	 * 获得 temperatureAttribute<br>
	 * temperatureAttribute
	 * @return temperatureAttribute
	*/
	public TemperatureAttribute getTemperatureAttribute() {
		return temperatureAttribute;
	}
	
	/**
	 * 设置 temperatureAttribute
	 * @param temperatureAttribute temperatureAttribute
	 * @return 当前对象
	*/
	public Storelocation setTemperatureAttribute(TemperatureAttribute temperatureAttribute) {
		this.temperatureAttribute=temperatureAttribute;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Storelocation , 转换好的 Storelocation 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Storelocation , 转换好的 PoJo 对象
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
	public Storelocation clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Storelocation duplicate(boolean all) {
		com.dt.platform.domain.wms.meta.StorelocationMeta.$$proxy$$ inst = new com.dt.platform.domain.wms.meta.StorelocationMeta.$$proxy$$();
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
			inst.setProductAttrIds(this.getProductAttrIds());
			inst.setTemperatureAttribute(this.getTemperatureAttribute());
			inst.setLocType(this.getLocType());
			inst.setStorehouse(this.getStorehouse());
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
	public Storelocation clone(boolean deep) {
		return EntityContext.clone(Storelocation.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Storelocation
	 * @param storelocationMap 包含实体信息的 Map 对象
	 * @return Storelocation , 转换好的的 Storelocation 对象
	*/
	@Transient
	public static Storelocation createFrom(Map<String,Object> storelocationMap) {
		if(storelocationMap==null) return null;
		Storelocation po = create();
		EntityContext.copyProperties(po,storelocationMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Storelocation
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Storelocation , 转换好的的 Storelocation 对象
	*/
	@Transient
	public static Storelocation createFrom(Object pojo) {
		if(pojo==null) return null;
		Storelocation po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Storelocation，等同于 new
	 * @return Storelocation 对象
	*/
	@Transient
	public static Storelocation create() {
		return new com.dt.platform.domain.wms.meta.StorelocationMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(StorelocationMeta.CODE)));
			this.setMaxBatch(DataParser.parse(BigDecimal.class, map.get(StorelocationMeta.MAX_BATCH)));
			this.setType(DataParser.parse(String.class, map.get(StorelocationMeta.TYPE)));
			this.setYCoordinate(DataParser.parse(BigDecimal.class, map.get(StorelocationMeta.Y_COORDINATE)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(StorelocationMeta.UPDATE_BY)));
			this.setNotes2(DataParser.parse(String.class, map.get(StorelocationMeta.NOTES2)));
			this.setNotes1(DataParser.parse(String.class, map.get(StorelocationMeta.NOTES1)));
			this.setCustomerId(DataParser.parse(String.class, map.get(StorelocationMeta.CUSTOMER_ID)));
			this.setId(DataParser.parse(String.class, map.get(StorelocationMeta.ID)));
			this.setMinBatch(DataParser.parse(BigDecimal.class, map.get(StorelocationMeta.MIN_BATCH)));
			this.setLocationGroup(DataParser.parse(String.class, map.get(StorelocationMeta.LOCATION_GROUP)));
			this.setLocationAttribute(DataParser.parse(String.class, map.get(StorelocationMeta.LOCATION_ATTRIBUTE)));
			this.setHeight(DataParser.parse(BigDecimal.class, map.get(StorelocationMeta.HEIGHT)));
			this.setLength(DataParser.parse(BigDecimal.class, map.get(StorelocationMeta.LENGTH)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(StorelocationMeta.UPDATE_TIME)));
			this.setMaxWeight(DataParser.parse(BigDecimal.class, map.get(StorelocationMeta.MAX_WEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(StorelocationMeta.VERSION)));
			this.setMaxVolume(DataParser.parse(BigDecimal.class, map.get(StorelocationMeta.MAX_VOLUME)));
			this.setBarCode(DataParser.parse(String.class, map.get(StorelocationMeta.BAR_CODE)));
			this.setXCoordinate(DataParser.parse(BigDecimal.class, map.get(StorelocationMeta.X_COORDINATE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(StorelocationMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(StorelocationMeta.DELETED)));
			this.setStorehouseId(DataParser.parse(String.class, map.get(StorelocationMeta.STOREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(StorelocationMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(StorelocationMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(StorelocationMeta.NAME)));
			this.setWidth(DataParser.parse(BigDecimal.class, map.get(StorelocationMeta.WIDTH)));
			this.setZCoordinate(DataParser.parse(BigDecimal.class, map.get(StorelocationMeta.Z_COORDINATE)));
			this.setTenantId(DataParser.parse(String.class, map.get(StorelocationMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(StorelocationMeta.DELETE_BY)));
			this.setRfid(DataParser.parse(String.class, map.get(StorelocationMeta.RFID)));
			this.setStatus(DataParser.parse(String.class, map.get(StorelocationMeta.STATUS)));
			// others
			this.setTemperatureAttribute(DataParser.parse(TemperatureAttribute.class, map.get(StorelocationMeta.TEMPERATURE_ATTRIBUTE)));
			this.setLocType(DataParser.parse(LocType.class, map.get(StorelocationMeta.LOC_TYPE)));
			this.setStorehouse(DataParser.parse(Storehouse.class, map.get(StorelocationMeta.STOREHOUSE)));
			this.setCustomer(DataParser.parse(Customer.class, map.get(StorelocationMeta.CUSTOMER)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(StorelocationMeta.CODE));
				this.setMaxBatch( (BigDecimal)map.get(StorelocationMeta.MAX_BATCH));
				this.setType( (String)map.get(StorelocationMeta.TYPE));
				this.setYCoordinate( (BigDecimal)map.get(StorelocationMeta.Y_COORDINATE));
				this.setUpdateBy( (String)map.get(StorelocationMeta.UPDATE_BY));
				this.setNotes2( (String)map.get(StorelocationMeta.NOTES2));
				this.setNotes1( (String)map.get(StorelocationMeta.NOTES1));
				this.setCustomerId( (String)map.get(StorelocationMeta.CUSTOMER_ID));
				this.setId( (String)map.get(StorelocationMeta.ID));
				this.setMinBatch( (BigDecimal)map.get(StorelocationMeta.MIN_BATCH));
				this.setLocationGroup( (String)map.get(StorelocationMeta.LOCATION_GROUP));
				this.setLocationAttribute( (String)map.get(StorelocationMeta.LOCATION_ATTRIBUTE));
				this.setHeight( (BigDecimal)map.get(StorelocationMeta.HEIGHT));
				this.setLength( (BigDecimal)map.get(StorelocationMeta.LENGTH));
				this.setUpdateTime( (Date)map.get(StorelocationMeta.UPDATE_TIME));
				this.setMaxWeight( (BigDecimal)map.get(StorelocationMeta.MAX_WEIGHT));
				this.setVersion( (Integer)map.get(StorelocationMeta.VERSION));
				this.setMaxVolume( (BigDecimal)map.get(StorelocationMeta.MAX_VOLUME));
				this.setBarCode( (String)map.get(StorelocationMeta.BAR_CODE));
				this.setXCoordinate( (BigDecimal)map.get(StorelocationMeta.X_COORDINATE));
				this.setCreateBy( (String)map.get(StorelocationMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(StorelocationMeta.DELETED));
				this.setStorehouseId( (String)map.get(StorelocationMeta.STOREHOUSE_ID));
				this.setCreateTime( (Date)map.get(StorelocationMeta.CREATE_TIME));
				this.setDeleteTime( (Date)map.get(StorelocationMeta.DELETE_TIME));
				this.setName( (String)map.get(StorelocationMeta.NAME));
				this.setWidth( (BigDecimal)map.get(StorelocationMeta.WIDTH));
				this.setZCoordinate( (BigDecimal)map.get(StorelocationMeta.Z_COORDINATE));
				this.setTenantId( (String)map.get(StorelocationMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(StorelocationMeta.DELETE_BY));
				this.setRfid( (String)map.get(StorelocationMeta.RFID));
				this.setStatus( (String)map.get(StorelocationMeta.STATUS));
				// others
				this.setTemperatureAttribute( (TemperatureAttribute)map.get(StorelocationMeta.TEMPERATURE_ATTRIBUTE));
				this.setLocType( (LocType)map.get(StorelocationMeta.LOC_TYPE));
				this.setStorehouse( (Storehouse)map.get(StorelocationMeta.STOREHOUSE));
				this.setCustomer( (Customer)map.get(StorelocationMeta.CUSTOMER));
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
			this.setCode(DataParser.parse(String.class, r.getValue(StorelocationMeta.CODE)));
			this.setMaxBatch(DataParser.parse(BigDecimal.class, r.getValue(StorelocationMeta.MAX_BATCH)));
			this.setType(DataParser.parse(String.class, r.getValue(StorelocationMeta.TYPE)));
			this.setYCoordinate(DataParser.parse(BigDecimal.class, r.getValue(StorelocationMeta.Y_COORDINATE)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(StorelocationMeta.UPDATE_BY)));
			this.setNotes2(DataParser.parse(String.class, r.getValue(StorelocationMeta.NOTES2)));
			this.setNotes1(DataParser.parse(String.class, r.getValue(StorelocationMeta.NOTES1)));
			this.setCustomerId(DataParser.parse(String.class, r.getValue(StorelocationMeta.CUSTOMER_ID)));
			this.setId(DataParser.parse(String.class, r.getValue(StorelocationMeta.ID)));
			this.setMinBatch(DataParser.parse(BigDecimal.class, r.getValue(StorelocationMeta.MIN_BATCH)));
			this.setLocationGroup(DataParser.parse(String.class, r.getValue(StorelocationMeta.LOCATION_GROUP)));
			this.setLocationAttribute(DataParser.parse(String.class, r.getValue(StorelocationMeta.LOCATION_ATTRIBUTE)));
			this.setHeight(DataParser.parse(BigDecimal.class, r.getValue(StorelocationMeta.HEIGHT)));
			this.setLength(DataParser.parse(BigDecimal.class, r.getValue(StorelocationMeta.LENGTH)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(StorelocationMeta.UPDATE_TIME)));
			this.setMaxWeight(DataParser.parse(BigDecimal.class, r.getValue(StorelocationMeta.MAX_WEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(StorelocationMeta.VERSION)));
			this.setMaxVolume(DataParser.parse(BigDecimal.class, r.getValue(StorelocationMeta.MAX_VOLUME)));
			this.setBarCode(DataParser.parse(String.class, r.getValue(StorelocationMeta.BAR_CODE)));
			this.setXCoordinate(DataParser.parse(BigDecimal.class, r.getValue(StorelocationMeta.X_COORDINATE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(StorelocationMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(StorelocationMeta.DELETED)));
			this.setStorehouseId(DataParser.parse(String.class, r.getValue(StorelocationMeta.STOREHOUSE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(StorelocationMeta.CREATE_TIME)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(StorelocationMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(StorelocationMeta.NAME)));
			this.setWidth(DataParser.parse(BigDecimal.class, r.getValue(StorelocationMeta.WIDTH)));
			this.setZCoordinate(DataParser.parse(BigDecimal.class, r.getValue(StorelocationMeta.Z_COORDINATE)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(StorelocationMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(StorelocationMeta.DELETE_BY)));
			this.setRfid(DataParser.parse(String.class, r.getValue(StorelocationMeta.RFID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(StorelocationMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(StorelocationMeta.CODE));
				this.setMaxBatch( (BigDecimal)r.getValue(StorelocationMeta.MAX_BATCH));
				this.setType( (String)r.getValue(StorelocationMeta.TYPE));
				this.setYCoordinate( (BigDecimal)r.getValue(StorelocationMeta.Y_COORDINATE));
				this.setUpdateBy( (String)r.getValue(StorelocationMeta.UPDATE_BY));
				this.setNotes2( (String)r.getValue(StorelocationMeta.NOTES2));
				this.setNotes1( (String)r.getValue(StorelocationMeta.NOTES1));
				this.setCustomerId( (String)r.getValue(StorelocationMeta.CUSTOMER_ID));
				this.setId( (String)r.getValue(StorelocationMeta.ID));
				this.setMinBatch( (BigDecimal)r.getValue(StorelocationMeta.MIN_BATCH));
				this.setLocationGroup( (String)r.getValue(StorelocationMeta.LOCATION_GROUP));
				this.setLocationAttribute( (String)r.getValue(StorelocationMeta.LOCATION_ATTRIBUTE));
				this.setHeight( (BigDecimal)r.getValue(StorelocationMeta.HEIGHT));
				this.setLength( (BigDecimal)r.getValue(StorelocationMeta.LENGTH));
				this.setUpdateTime( (Date)r.getValue(StorelocationMeta.UPDATE_TIME));
				this.setMaxWeight( (BigDecimal)r.getValue(StorelocationMeta.MAX_WEIGHT));
				this.setVersion( (Integer)r.getValue(StorelocationMeta.VERSION));
				this.setMaxVolume( (BigDecimal)r.getValue(StorelocationMeta.MAX_VOLUME));
				this.setBarCode( (String)r.getValue(StorelocationMeta.BAR_CODE));
				this.setXCoordinate( (BigDecimal)r.getValue(StorelocationMeta.X_COORDINATE));
				this.setCreateBy( (String)r.getValue(StorelocationMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(StorelocationMeta.DELETED));
				this.setStorehouseId( (String)r.getValue(StorelocationMeta.STOREHOUSE_ID));
				this.setCreateTime( (Date)r.getValue(StorelocationMeta.CREATE_TIME));
				this.setDeleteTime( (Date)r.getValue(StorelocationMeta.DELETE_TIME));
				this.setName( (String)r.getValue(StorelocationMeta.NAME));
				this.setWidth( (BigDecimal)r.getValue(StorelocationMeta.WIDTH));
				this.setZCoordinate( (BigDecimal)r.getValue(StorelocationMeta.Z_COORDINATE));
				this.setTenantId( (String)r.getValue(StorelocationMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(StorelocationMeta.DELETE_BY));
				this.setRfid( (String)r.getValue(StorelocationMeta.RFID));
				this.setStatus( (String)r.getValue(StorelocationMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}