package com.dt.platform.domain.wms;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.WmsTables.WMS_CAR;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.wms.meta.CarMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 车辆管理
 * <p>车辆管理 , 数据表 wms_car 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 15:01:45
 * @sign 0AF40195DFB373BDE6DF285DD2BCF105
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "wms_car")
@ApiModel(description = "车辆管理 ; 车辆管理 , 数据表 wms_car 的PO类型")
public class Car extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WMS_CAR.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 车号：车号
	*/
	@ApiModelProperty(required = false,value="车号" , notes = "车号")
	private String carNumber;
	
	/**
	 * 车型：车型
	*/
	@ApiModelProperty(required = false,value="车型" , notes = "车型")
	private String carModel;
	
	/**
	 * 最大载重：最大载重
	*/
	@ApiModelProperty(required = false,value="最大载重" , notes = "最大载重")
	private BigDecimal maxWeight;
	
	/**
	 * 最大体积：最大体积
	*/
	@ApiModelProperty(required = false,value="最大体积" , notes = "最大体积")
	private BigDecimal maxVolumn;
	
	/**
	 * 载人数：载人数
	*/
	@ApiModelProperty(required = false,value="载人数" , notes = "载人数")
	private BigDecimal maxPeople;
	
	/**
	 * 驾照：驾照
	*/
	@ApiModelProperty(required = false,value="驾照" , notes = "驾照")
	private String driveNumber;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "姓名")
	private String user;
	
	/**
	 * 联系方式：联系方式
	*/
	@ApiModelProperty(required = false,value="联系方式" , notes = "联系方式")
	private String mobile;
	
	/**
	 * 车牌：车牌
	*/
	@ApiModelProperty(required = false,value="车牌" , notes = "车牌")
	private String carValue;
	
	/**
	 * 区域：区域
	*/
	@ApiModelProperty(required = false,value="区域" , notes = "区域")
	private String area;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	public Car setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 车号<br>
	 * 车号
	 * @return 车号
	*/
	public String getCarNumber() {
		return carNumber;
	}
	
	/**
	 * 设置 车号
	 * @param carNumber 车号
	 * @return 当前对象
	*/
	public Car setCarNumber(String carNumber) {
		this.carNumber=carNumber;
		return this;
	}
	
	/**
	 * 获得 车型<br>
	 * 车型
	 * @return 车型
	*/
	public String getCarModel() {
		return carModel;
	}
	
	/**
	 * 设置 车型
	 * @param carModel 车型
	 * @return 当前对象
	*/
	public Car setCarModel(String carModel) {
		this.carModel=carModel;
		return this;
	}
	
	/**
	 * 获得 最大载重<br>
	 * 最大载重
	 * @return 最大载重
	*/
	public BigDecimal getMaxWeight() {
		return maxWeight;
	}
	
	/**
	 * 设置 最大载重
	 * @param maxWeight 最大载重
	 * @return 当前对象
	*/
	public Car setMaxWeight(BigDecimal maxWeight) {
		this.maxWeight=maxWeight;
		return this;
	}
	
	/**
	 * 获得 最大体积<br>
	 * 最大体积
	 * @return 最大体积
	*/
	public BigDecimal getMaxVolumn() {
		return maxVolumn;
	}
	
	/**
	 * 设置 最大体积
	 * @param maxVolumn 最大体积
	 * @return 当前对象
	*/
	public Car setMaxVolumn(BigDecimal maxVolumn) {
		this.maxVolumn=maxVolumn;
		return this;
	}
	
	/**
	 * 获得 载人数<br>
	 * 载人数
	 * @return 载人数
	*/
	public BigDecimal getMaxPeople() {
		return maxPeople;
	}
	
	/**
	 * 设置 载人数
	 * @param maxPeople 载人数
	 * @return 当前对象
	*/
	public Car setMaxPeople(BigDecimal maxPeople) {
		this.maxPeople=maxPeople;
		return this;
	}
	
	/**
	 * 获得 驾照<br>
	 * 驾照
	 * @return 驾照
	*/
	public String getDriveNumber() {
		return driveNumber;
	}
	
	/**
	 * 设置 驾照
	 * @param driveNumber 驾照
	 * @return 当前对象
	*/
	public Car setDriveNumber(String driveNumber) {
		this.driveNumber=driveNumber;
		return this;
	}
	
	/**
	 * 获得 姓名<br>
	 * 姓名
	 * @return 姓名
	*/
	public String getUser() {
		return user;
	}
	
	/**
	 * 设置 姓名
	 * @param user 姓名
	 * @return 当前对象
	*/
	public Car setUser(String user) {
		this.user=user;
		return this;
	}
	
	/**
	 * 获得 联系方式<br>
	 * 联系方式
	 * @return 联系方式
	*/
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置 联系方式
	 * @param mobile 联系方式
	 * @return 当前对象
	*/
	public Car setMobile(String mobile) {
		this.mobile=mobile;
		return this;
	}
	
	/**
	 * 获得 车牌<br>
	 * 车牌
	 * @return 车牌
	*/
	public String getCarValue() {
		return carValue;
	}
	
	/**
	 * 设置 车牌
	 * @param carValue 车牌
	 * @return 当前对象
	*/
	public Car setCarValue(String carValue) {
		this.carValue=carValue;
		return this;
	}
	
	/**
	 * 获得 区域<br>
	 * 区域
	 * @return 区域
	*/
	public String getArea() {
		return area;
	}
	
	/**
	 * 设置 区域
	 * @param area 区域
	 * @return 当前对象
	*/
	public Car setArea(String area) {
		this.area=area;
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
	public Car setNotes(String notes) {
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
	public Car setCreateBy(String createBy) {
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
	public Car setCreateTime(Date createTime) {
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
	public Car setUpdateBy(String updateBy) {
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
	public Car setUpdateTime(Date updateTime) {
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
	public Car setDeleted(Integer deleted) {
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
	public Car setDeleted(Boolean deletedBool) {
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
	public Car setDeleteBy(String deleteBy) {
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
	public Car setDeleteTime(Date deleteTime) {
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
	public Car setVersion(Integer version) {
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
	public Car setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Car , 转换好的 Car 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Car , 转换好的 PoJo 对象
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
	public Car clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Car duplicate(boolean all) {
		com.dt.platform.domain.wms.meta.CarMeta.$$proxy$$ inst = new com.dt.platform.domain.wms.meta.CarMeta.$$proxy$$();
		inst.setArea(this.getArea());
		inst.setNotes(this.getNotes());
		inst.setMobile(this.getMobile());
		inst.setDriveNumber(this.getDriveNumber());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setMaxWeight(this.getMaxWeight());
		inst.setVersion(this.getVersion());
		inst.setCarNumber(this.getCarNumber());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setMaxVolumn(this.getMaxVolumn());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setMaxPeople(this.getMaxPeople());
		inst.setUser(this.getUser());
		inst.setCarModel(this.getCarModel());
		inst.setCarValue(this.getCarValue());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public Car clone(boolean deep) {
		return EntityContext.clone(Car.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Car
	 * @param carMap 包含实体信息的 Map 对象
	 * @return Car , 转换好的的 Car 对象
	*/
	@Transient
	public static Car createFrom(Map<String,Object> carMap) {
		if(carMap==null) return null;
		Car po = create();
		EntityContext.copyProperties(po,carMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Car
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Car , 转换好的的 Car 对象
	*/
	@Transient
	public static Car createFrom(Object pojo) {
		if(pojo==null) return null;
		Car po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Car，等同于 new
	 * @return Car 对象
	*/
	@Transient
	public static Car create() {
		return new com.dt.platform.domain.wms.meta.CarMeta.$$proxy$$();
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
			this.setArea(DataParser.parse(String.class, map.get(CarMeta.AREA)));
			this.setNotes(DataParser.parse(String.class, map.get(CarMeta.NOTES)));
			this.setMobile(DataParser.parse(String.class, map.get(CarMeta.MOBILE)));
			this.setDriveNumber(DataParser.parse(String.class, map.get(CarMeta.DRIVE_NUMBER)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CarMeta.UPDATE_TIME)));
			this.setMaxWeight(DataParser.parse(BigDecimal.class, map.get(CarMeta.MAX_WEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CarMeta.VERSION)));
			this.setCarNumber(DataParser.parse(String.class, map.get(CarMeta.CAR_NUMBER)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CarMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CarMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CarMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CarMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CarMeta.DELETE_TIME)));
			this.setMaxVolumn(DataParser.parse(BigDecimal.class, map.get(CarMeta.MAX_VOLUMN)));
			this.setTenantId(DataParser.parse(String.class, map.get(CarMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CarMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CarMeta.ID)));
			this.setMaxPeople(DataParser.parse(BigDecimal.class, map.get(CarMeta.MAX_PEOPLE)));
			this.setUser(DataParser.parse(String.class, map.get(CarMeta.USER)));
			this.setCarModel(DataParser.parse(String.class, map.get(CarMeta.CAR_MODEL)));
			this.setCarValue(DataParser.parse(String.class, map.get(CarMeta.CAR_VALUE)));
			// others
			return true;
		} else {
			try {
				this.setArea( (String)map.get(CarMeta.AREA));
				this.setNotes( (String)map.get(CarMeta.NOTES));
				this.setMobile( (String)map.get(CarMeta.MOBILE));
				this.setDriveNumber( (String)map.get(CarMeta.DRIVE_NUMBER));
				this.setUpdateTime( (Date)map.get(CarMeta.UPDATE_TIME));
				this.setMaxWeight( (BigDecimal)map.get(CarMeta.MAX_WEIGHT));
				this.setVersion( (Integer)map.get(CarMeta.VERSION));
				this.setCarNumber( (String)map.get(CarMeta.CAR_NUMBER));
				this.setCreateBy( (String)map.get(CarMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CarMeta.DELETED));
				this.setCreateTime( (Date)map.get(CarMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CarMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CarMeta.DELETE_TIME));
				this.setMaxVolumn( (BigDecimal)map.get(CarMeta.MAX_VOLUMN));
				this.setTenantId( (String)map.get(CarMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CarMeta.DELETE_BY));
				this.setId( (String)map.get(CarMeta.ID));
				this.setMaxPeople( (BigDecimal)map.get(CarMeta.MAX_PEOPLE));
				this.setUser( (String)map.get(CarMeta.USER));
				this.setCarModel( (String)map.get(CarMeta.CAR_MODEL));
				this.setCarValue( (String)map.get(CarMeta.CAR_VALUE));
				// others
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
			this.setArea(DataParser.parse(String.class, r.getValue(CarMeta.AREA)));
			this.setNotes(DataParser.parse(String.class, r.getValue(CarMeta.NOTES)));
			this.setMobile(DataParser.parse(String.class, r.getValue(CarMeta.MOBILE)));
			this.setDriveNumber(DataParser.parse(String.class, r.getValue(CarMeta.DRIVE_NUMBER)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CarMeta.UPDATE_TIME)));
			this.setMaxWeight(DataParser.parse(BigDecimal.class, r.getValue(CarMeta.MAX_WEIGHT)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CarMeta.VERSION)));
			this.setCarNumber(DataParser.parse(String.class, r.getValue(CarMeta.CAR_NUMBER)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CarMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CarMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CarMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CarMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CarMeta.DELETE_TIME)));
			this.setMaxVolumn(DataParser.parse(BigDecimal.class, r.getValue(CarMeta.MAX_VOLUMN)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CarMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CarMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CarMeta.ID)));
			this.setMaxPeople(DataParser.parse(BigDecimal.class, r.getValue(CarMeta.MAX_PEOPLE)));
			this.setUser(DataParser.parse(String.class, r.getValue(CarMeta.USER)));
			this.setCarModel(DataParser.parse(String.class, r.getValue(CarMeta.CAR_MODEL)));
			this.setCarValue(DataParser.parse(String.class, r.getValue(CarMeta.CAR_VALUE)));
			return true;
		} else {
			try {
				this.setArea( (String)r.getValue(CarMeta.AREA));
				this.setNotes( (String)r.getValue(CarMeta.NOTES));
				this.setMobile( (String)r.getValue(CarMeta.MOBILE));
				this.setDriveNumber( (String)r.getValue(CarMeta.DRIVE_NUMBER));
				this.setUpdateTime( (Date)r.getValue(CarMeta.UPDATE_TIME));
				this.setMaxWeight( (BigDecimal)r.getValue(CarMeta.MAX_WEIGHT));
				this.setVersion( (Integer)r.getValue(CarMeta.VERSION));
				this.setCarNumber( (String)r.getValue(CarMeta.CAR_NUMBER));
				this.setCreateBy( (String)r.getValue(CarMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CarMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CarMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CarMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CarMeta.DELETE_TIME));
				this.setMaxVolumn( (BigDecimal)r.getValue(CarMeta.MAX_VOLUMN));
				this.setTenantId( (String)r.getValue(CarMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CarMeta.DELETE_BY));
				this.setId( (String)r.getValue(CarMeta.ID));
				this.setMaxPeople( (BigDecimal)r.getValue(CarMeta.MAX_PEOPLE));
				this.setUser( (String)r.getValue(CarMeta.USER));
				this.setCarModel( (String)r.getValue(CarMeta.CAR_MODEL));
				this.setCarValue( (String)r.getValue(CarMeta.CAR_VALUE));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}