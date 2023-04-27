package com.dt.platform.domain.wms;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.WmsTables.WMS_AREA_INFO;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.wms.meta.AreaInfoMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 地区信息
 * <p>地区信息 , 数据表 wms_area_info 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 09:28:24
 * @sign 44B30E0A23B95EB65B34E9D47B7CD603
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "wms_area_info")
@ApiModel(description = "地区信息 ; 地区信息 , 数据表 wms_area_info 的PO类型")
public class AreaInfo extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WMS_AREA_INFO.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码")
	private String areaInfoCode;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 城市类型：城市类型
	*/
	@ApiModelProperty(required = false,value="城市类型" , notes = "城市类型")
	private String cityType;
	
	/**
	 * 大区：大区
	*/
	@ApiModelProperty(required = false,value="大区" , notes = "大区")
	private String region;
	
	/**
	 * 片区：片区
	*/
	@ApiModelProperty(required = false,value="片区" , notes = "片区")
	private String area;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
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
	public AreaInfo setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getAreaInfoCode() {
		return areaInfoCode;
	}
	
	/**
	 * 设置 编码
	 * @param areaInfoCode 编码
	 * @return 当前对象
	*/
	public AreaInfo setAreaInfoCode(String areaInfoCode) {
		this.areaInfoCode=areaInfoCode;
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
	public AreaInfo setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 城市类型<br>
	 * 城市类型
	 * @return 城市类型
	*/
	public String getCityType() {
		return cityType;
	}
	
	/**
	 * 设置 城市类型
	 * @param cityType 城市类型
	 * @return 当前对象
	*/
	public AreaInfo setCityType(String cityType) {
		this.cityType=cityType;
		return this;
	}
	
	/**
	 * 获得 大区<br>
	 * 大区
	 * @return 大区
	*/
	public String getRegion() {
		return region;
	}
	
	/**
	 * 设置 大区
	 * @param region 大区
	 * @return 当前对象
	*/
	public AreaInfo setRegion(String region) {
		this.region=region;
		return this;
	}
	
	/**
	 * 获得 片区<br>
	 * 片区
	 * @return 片区
	*/
	public String getArea() {
		return area;
	}
	
	/**
	 * 设置 片区
	 * @param area 片区
	 * @return 当前对象
	*/
	public AreaInfo setArea(String area) {
		this.area=area;
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
	public AreaInfo setStatus(String status) {
		this.status=status;
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
	public AreaInfo setNotes(String notes) {
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
	public AreaInfo setCreateBy(String createBy) {
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
	public AreaInfo setCreateTime(Date createTime) {
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
	public AreaInfo setUpdateBy(String updateBy) {
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
	public AreaInfo setUpdateTime(Date updateTime) {
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
	public AreaInfo setDeleted(Integer deleted) {
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
	public AreaInfo setDeleted(Boolean deletedBool) {
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
	public AreaInfo setDeleteBy(String deleteBy) {
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
	public AreaInfo setDeleteTime(Date deleteTime) {
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
	public AreaInfo setVersion(Integer version) {
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
	public AreaInfo setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AreaInfo , 转换好的 AreaInfo 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AreaInfo , 转换好的 PoJo 对象
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
	public AreaInfo clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AreaInfo duplicate(boolean all) {
		com.dt.platform.domain.wms.meta.AreaInfoMeta.$$proxy$$ inst = new com.dt.platform.domain.wms.meta.AreaInfoMeta.$$proxy$$();
		inst.setCityType(this.getCityType());
		inst.setArea(this.getArea());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setAreaInfoCode(this.getAreaInfoCode());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setRegion(this.getRegion());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AreaInfo clone(boolean deep) {
		return EntityContext.clone(AreaInfo.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AreaInfo
	 * @param areaInfoMap 包含实体信息的 Map 对象
	 * @return AreaInfo , 转换好的的 AreaInfo 对象
	*/
	@Transient
	public static AreaInfo createFrom(Map<String,Object> areaInfoMap) {
		if(areaInfoMap==null) return null;
		AreaInfo po = create();
		EntityContext.copyProperties(po,areaInfoMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AreaInfo
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AreaInfo , 转换好的的 AreaInfo 对象
	*/
	@Transient
	public static AreaInfo createFrom(Object pojo) {
		if(pojo==null) return null;
		AreaInfo po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AreaInfo，等同于 new
	 * @return AreaInfo 对象
	*/
	@Transient
	public static AreaInfo create() {
		return new com.dt.platform.domain.wms.meta.AreaInfoMeta.$$proxy$$();
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
			this.setCityType(DataParser.parse(String.class, map.get(AreaInfoMeta.CITY_TYPE)));
			this.setArea(DataParser.parse(String.class, map.get(AreaInfoMeta.AREA)));
			this.setNotes(DataParser.parse(String.class, map.get(AreaInfoMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AreaInfoMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AreaInfoMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AreaInfoMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AreaInfoMeta.DELETED)));
			this.setAreaInfoCode(DataParser.parse(String.class, map.get(AreaInfoMeta.AREA_INFO_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AreaInfoMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AreaInfoMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AreaInfoMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AreaInfoMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AreaInfoMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AreaInfoMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AreaInfoMeta.ID)));
			this.setRegion(DataParser.parse(String.class, map.get(AreaInfoMeta.REGION)));
			this.setStatus(DataParser.parse(String.class, map.get(AreaInfoMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setCityType( (String)map.get(AreaInfoMeta.CITY_TYPE));
				this.setArea( (String)map.get(AreaInfoMeta.AREA));
				this.setNotes( (String)map.get(AreaInfoMeta.NOTES));
				this.setUpdateTime( (Date)map.get(AreaInfoMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AreaInfoMeta.VERSION));
				this.setCreateBy( (String)map.get(AreaInfoMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AreaInfoMeta.DELETED));
				this.setAreaInfoCode( (String)map.get(AreaInfoMeta.AREA_INFO_CODE));
				this.setCreateTime( (Date)map.get(AreaInfoMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AreaInfoMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AreaInfoMeta.DELETE_TIME));
				this.setName( (String)map.get(AreaInfoMeta.NAME));
				this.setTenantId( (String)map.get(AreaInfoMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AreaInfoMeta.DELETE_BY));
				this.setId( (String)map.get(AreaInfoMeta.ID));
				this.setRegion( (String)map.get(AreaInfoMeta.REGION));
				this.setStatus( (String)map.get(AreaInfoMeta.STATUS));
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
			this.setCityType(DataParser.parse(String.class, r.getValue(AreaInfoMeta.CITY_TYPE)));
			this.setArea(DataParser.parse(String.class, r.getValue(AreaInfoMeta.AREA)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AreaInfoMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AreaInfoMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AreaInfoMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AreaInfoMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AreaInfoMeta.DELETED)));
			this.setAreaInfoCode(DataParser.parse(String.class, r.getValue(AreaInfoMeta.AREA_INFO_CODE)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AreaInfoMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AreaInfoMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AreaInfoMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AreaInfoMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AreaInfoMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AreaInfoMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AreaInfoMeta.ID)));
			this.setRegion(DataParser.parse(String.class, r.getValue(AreaInfoMeta.REGION)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AreaInfoMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCityType( (String)r.getValue(AreaInfoMeta.CITY_TYPE));
				this.setArea( (String)r.getValue(AreaInfoMeta.AREA));
				this.setNotes( (String)r.getValue(AreaInfoMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(AreaInfoMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AreaInfoMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AreaInfoMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AreaInfoMeta.DELETED));
				this.setAreaInfoCode( (String)r.getValue(AreaInfoMeta.AREA_INFO_CODE));
				this.setCreateTime( (Date)r.getValue(AreaInfoMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AreaInfoMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AreaInfoMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AreaInfoMeta.NAME));
				this.setTenantId( (String)r.getValue(AreaInfoMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AreaInfoMeta.DELETE_BY));
				this.setId( (String)r.getValue(AreaInfoMeta.ID));
				this.setRegion( (String)r.getValue(AreaInfoMeta.REGION));
				this.setStatus( (String)r.getValue(AreaInfoMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}