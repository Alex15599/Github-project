package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INSPECTION_POINT;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.InspectionPointMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检点
 * <p>巡检点 , 数据表 eam_inspection_point 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-11 20:39:36
 * @sign C8B21B8D61FF7E52EAEDF4E6DB9A7178
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inspection_point")
@ApiModel(description = "巡检点 ; 巡检点 , 数据表 eam_inspection_point 的PO类型")
public class InspectionPoint extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INSPECTION_POINT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "697560868916822016")
	private String id;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "point1")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "point1")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 巡检内容：巡检内容
	*/
	@ApiModelProperty(required = false,value="巡检内容" , notes = "巡检内容")
	private String content;
	
	/**
	 * 巡检路线：巡检路线
	*/
	@ApiModelProperty(required = false,value="巡检路线" , notes = "巡检路线" , example = "697560681343352832")
	private String routeId;
	
	/**
	 * RFID：RFID
	*/
	@ApiModelProperty(required = false,value="RFID" , notes = "RFID")
	private String rfid;
	
	/**
	 * 位置：位置
	*/
	@ApiModelProperty(required = false,value="位置" , notes = "位置" , example = "698104347535343616")
	private String posId;
	
	/**
	 * 位置详情：位置详情
	*/
	@ApiModelProperty(required = false,value="位置详情" , notes = "位置详情")
	private String pos;
	
	/**
	 * 位置经度：位置经度
	*/
	@ApiModelProperty(required = false,value="位置经度" , notes = "位置经度" , example = "0.0")
	private String posLongitude;
	
	/**
	 * 位置纬度：位置纬度
	*/
	@ApiModelProperty(required = false,value="位置纬度" , notes = "位置纬度" , example = "0.0")
	private String posLatitude;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片")
	private String pictureId;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-04-09 09:37:51")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-04-11 10:15:52")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * 选择：选择
	*/
	@ApiModelProperty(required = false,value="选择" , notes = "选择")
	private String selectedCode;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "3")
	private Integer version;
	
	/**
	 * route：route
	*/
	@ApiModelProperty(required = false,value="route" , notes = "route")
	private InspectionRoute route;
	
	/**
	 * inspectionPointPos：inspectionPointPos
	*/
	@ApiModelProperty(required = false,value="inspectionPointPos" , notes = "inspectionPointPos")
	private InspectionPointPos inspectionPointPos;
	
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
	public InspectionPoint setId(String id) {
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
	public InspectionPoint setCode(String code) {
		this.code=code;
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
	public InspectionPoint setName(String name) {
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
	public InspectionPoint setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 巡检内容<br>
	 * 巡检内容
	 * @return 巡检内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 巡检内容
	 * @param content 巡检内容
	 * @return 当前对象
	*/
	public InspectionPoint setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 巡检路线<br>
	 * 巡检路线
	 * @return 巡检路线
	*/
	public String getRouteId() {
		return routeId;
	}
	
	/**
	 * 设置 巡检路线
	 * @param routeId 巡检路线
	 * @return 当前对象
	*/
	public InspectionPoint setRouteId(String routeId) {
		this.routeId=routeId;
		return this;
	}
	
	/**
	 * 获得 RFID<br>
	 * RFID
	 * @return RFID
	*/
	public String getRfid() {
		return rfid;
	}
	
	/**
	 * 设置 RFID
	 * @param rfid RFID
	 * @return 当前对象
	*/
	public InspectionPoint setRfid(String rfid) {
		this.rfid=rfid;
		return this;
	}
	
	/**
	 * 获得 位置<br>
	 * 位置
	 * @return 位置
	*/
	public String getPosId() {
		return posId;
	}
	
	/**
	 * 设置 位置
	 * @param posId 位置
	 * @return 当前对象
	*/
	public InspectionPoint setPosId(String posId) {
		this.posId=posId;
		return this;
	}
	
	/**
	 * 获得 位置详情<br>
	 * 位置详情
	 * @return 位置详情
	*/
	public String getPos() {
		return pos;
	}
	
	/**
	 * 设置 位置详情
	 * @param pos 位置详情
	 * @return 当前对象
	*/
	public InspectionPoint setPos(String pos) {
		this.pos=pos;
		return this;
	}
	
	/**
	 * 获得 位置经度<br>
	 * 位置经度
	 * @return 位置经度
	*/
	public String getPosLongitude() {
		return posLongitude;
	}
	
	/**
	 * 设置 位置经度
	 * @param posLongitude 位置经度
	 * @return 当前对象
	*/
	public InspectionPoint setPosLongitude(String posLongitude) {
		this.posLongitude=posLongitude;
		return this;
	}
	
	/**
	 * 获得 位置纬度<br>
	 * 位置纬度
	 * @return 位置纬度
	*/
	public String getPosLatitude() {
		return posLatitude;
	}
	
	/**
	 * 设置 位置纬度
	 * @param posLatitude 位置纬度
	 * @return 当前对象
	*/
	public InspectionPoint setPosLatitude(String posLatitude) {
		this.posLatitude=posLatitude;
		return this;
	}
	
	/**
	 * 获得 图片<br>
	 * 图片
	 * @return 图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 图片
	 * @param pictureId 图片
	 * @return 当前对象
	*/
	public InspectionPoint setPictureId(String pictureId) {
		this.pictureId=pictureId;
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
	public InspectionPoint setNotes(String notes) {
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
	public InspectionPoint setCreateBy(String createBy) {
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
	public InspectionPoint setCreateTime(Date createTime) {
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
	public InspectionPoint setUpdateBy(String updateBy) {
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
	public InspectionPoint setUpdateTime(Date updateTime) {
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
	public InspectionPoint setDeleted(Integer deleted) {
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
	public InspectionPoint setDeleted(Boolean deletedBool) {
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
	public InspectionPoint setDeleteBy(String deleteBy) {
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
	public InspectionPoint setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public InspectionPoint setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 选择<br>
	 * 选择
	 * @return 选择
	*/
	public String getSelectedCode() {
		return selectedCode;
	}
	
	/**
	 * 设置 选择
	 * @param selectedCode 选择
	 * @return 当前对象
	*/
	public InspectionPoint setSelectedCode(String selectedCode) {
		this.selectedCode=selectedCode;
		return this;
	}
	
	/**
	 * 获得 version<br>
	 * version
	 * @return version
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 version
	 * @param version version
	 * @return 当前对象
	*/
	public InspectionPoint setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 route<br>
	 * route
	 * @return route
	*/
	public InspectionRoute getRoute() {
		return route;
	}
	
	/**
	 * 设置 route
	 * @param route route
	 * @return 当前对象
	*/
	public InspectionPoint setRoute(InspectionRoute route) {
		this.route=route;
		return this;
	}
	
	/**
	 * 获得 inspectionPointPos<br>
	 * inspectionPointPos
	 * @return inspectionPointPos
	*/
	public InspectionPointPos getInspectionPointPos() {
		return inspectionPointPos;
	}
	
	/**
	 * 设置 inspectionPointPos
	 * @param inspectionPointPos inspectionPointPos
	 * @return 当前对象
	*/
	public InspectionPoint setInspectionPointPos(InspectionPointPos inspectionPointPos) {
		this.inspectionPointPos=inspectionPointPos;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InspectionPoint , 转换好的 InspectionPoint 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InspectionPoint , 转换好的 PoJo 对象
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
	public InspectionPoint clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InspectionPoint duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InspectionPointMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InspectionPointMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setPosLatitude(this.getPosLatitude());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSelectedCode(this.getSelectedCode());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setPosId(this.getPosId());
		inst.setCreateBy(this.getCreateBy());
		inst.setRouteId(this.getRouteId());
		inst.setDeleted(this.getDeleted());
		inst.setPictureId(this.getPictureId());
		inst.setPos(this.getPos());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setRfid(this.getRfid());
		inst.setPosLongitude(this.getPosLongitude());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setRoute(this.getRoute());
			inst.setInspectionPointPos(this.getInspectionPointPos());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InspectionPoint clone(boolean deep) {
		return EntityContext.clone(InspectionPoint.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InspectionPoint
	 * @param inspectionPointMap 包含实体信息的 Map 对象
	 * @return InspectionPoint , 转换好的的 InspectionPoint 对象
	*/
	@Transient
	public static InspectionPoint createFrom(Map<String,Object> inspectionPointMap) {
		if(inspectionPointMap==null) return null;
		InspectionPoint po = create();
		EntityContext.copyProperties(po,inspectionPointMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InspectionPoint
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InspectionPoint , 转换好的的 InspectionPoint 对象
	*/
	@Transient
	public static InspectionPoint createFrom(Object pojo) {
		if(pojo==null) return null;
		InspectionPoint po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InspectionPoint，等同于 new
	 * @return InspectionPoint 对象
	*/
	@Transient
	public static InspectionPoint create() {
		return new com.dt.platform.domain.eam.meta.InspectionPointMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(InspectionPointMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(InspectionPointMeta.NOTES)));
			this.setPosLatitude(DataParser.parse(String.class, map.get(InspectionPointMeta.POS_LATITUDE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InspectionPointMeta.UPDATE_TIME)));
			this.setSelectedCode(DataParser.parse(String.class, map.get(InspectionPointMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InspectionPointMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(InspectionPointMeta.CONTENT)));
			this.setPosId(DataParser.parse(String.class, map.get(InspectionPointMeta.POS_ID)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InspectionPointMeta.CREATE_BY)));
			this.setRouteId(DataParser.parse(String.class, map.get(InspectionPointMeta.ROUTE_ID)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InspectionPointMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, map.get(InspectionPointMeta.PICTURE_ID)));
			this.setPos(DataParser.parse(String.class, map.get(InspectionPointMeta.POS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InspectionPointMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InspectionPointMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InspectionPointMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(InspectionPointMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(InspectionPointMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InspectionPointMeta.DELETE_BY)));
			this.setRfid(DataParser.parse(String.class, map.get(InspectionPointMeta.RFID)));
			this.setPosLongitude(DataParser.parse(String.class, map.get(InspectionPointMeta.POS_LONGITUDE)));
			this.setId(DataParser.parse(String.class, map.get(InspectionPointMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(InspectionPointMeta.STATUS)));
			// others
			this.setRoute(DataParser.parse(InspectionRoute.class, map.get(InspectionPointMeta.ROUTE)));
			this.setInspectionPointPos(DataParser.parse(InspectionPointPos.class, map.get(InspectionPointMeta.INSPECTION_POINT_POS)));
			return true;
		} else {
			try {
				this.setCode( (String)map.get(InspectionPointMeta.CODE));
				this.setNotes( (String)map.get(InspectionPointMeta.NOTES));
				this.setPosLatitude( (String)map.get(InspectionPointMeta.POS_LATITUDE));
				this.setUpdateTime( (Date)map.get(InspectionPointMeta.UPDATE_TIME));
				this.setSelectedCode( (String)map.get(InspectionPointMeta.SELECTED_CODE));
				this.setVersion( (Integer)map.get(InspectionPointMeta.VERSION));
				this.setContent( (String)map.get(InspectionPointMeta.CONTENT));
				this.setPosId( (String)map.get(InspectionPointMeta.POS_ID));
				this.setCreateBy( (String)map.get(InspectionPointMeta.CREATE_BY));
				this.setRouteId( (String)map.get(InspectionPointMeta.ROUTE_ID));
				this.setDeleted( (Integer)map.get(InspectionPointMeta.DELETED));
				this.setPictureId( (String)map.get(InspectionPointMeta.PICTURE_ID));
				this.setPos( (String)map.get(InspectionPointMeta.POS));
				this.setCreateTime( (Date)map.get(InspectionPointMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(InspectionPointMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(InspectionPointMeta.DELETE_TIME));
				this.setName( (String)map.get(InspectionPointMeta.NAME));
				this.setTenantId( (String)map.get(InspectionPointMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(InspectionPointMeta.DELETE_BY));
				this.setRfid( (String)map.get(InspectionPointMeta.RFID));
				this.setPosLongitude( (String)map.get(InspectionPointMeta.POS_LONGITUDE));
				this.setId( (String)map.get(InspectionPointMeta.ID));
				this.setStatus( (String)map.get(InspectionPointMeta.STATUS));
				// others
				this.setRoute( (InspectionRoute)map.get(InspectionPointMeta.ROUTE));
				this.setInspectionPointPos( (InspectionPointPos)map.get(InspectionPointMeta.INSPECTION_POINT_POS));
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
			this.setCode(DataParser.parse(String.class, r.getValue(InspectionPointMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(InspectionPointMeta.NOTES)));
			this.setPosLatitude(DataParser.parse(String.class, r.getValue(InspectionPointMeta.POS_LATITUDE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InspectionPointMeta.UPDATE_TIME)));
			this.setSelectedCode(DataParser.parse(String.class, r.getValue(InspectionPointMeta.SELECTED_CODE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InspectionPointMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(InspectionPointMeta.CONTENT)));
			this.setPosId(DataParser.parse(String.class, r.getValue(InspectionPointMeta.POS_ID)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InspectionPointMeta.CREATE_BY)));
			this.setRouteId(DataParser.parse(String.class, r.getValue(InspectionPointMeta.ROUTE_ID)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InspectionPointMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(InspectionPointMeta.PICTURE_ID)));
			this.setPos(DataParser.parse(String.class, r.getValue(InspectionPointMeta.POS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InspectionPointMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InspectionPointMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InspectionPointMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(InspectionPointMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(InspectionPointMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InspectionPointMeta.DELETE_BY)));
			this.setRfid(DataParser.parse(String.class, r.getValue(InspectionPointMeta.RFID)));
			this.setPosLongitude(DataParser.parse(String.class, r.getValue(InspectionPointMeta.POS_LONGITUDE)));
			this.setId(DataParser.parse(String.class, r.getValue(InspectionPointMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(InspectionPointMeta.STATUS)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(InspectionPointMeta.CODE));
				this.setNotes( (String)r.getValue(InspectionPointMeta.NOTES));
				this.setPosLatitude( (String)r.getValue(InspectionPointMeta.POS_LATITUDE));
				this.setUpdateTime( (Date)r.getValue(InspectionPointMeta.UPDATE_TIME));
				this.setSelectedCode( (String)r.getValue(InspectionPointMeta.SELECTED_CODE));
				this.setVersion( (Integer)r.getValue(InspectionPointMeta.VERSION));
				this.setContent( (String)r.getValue(InspectionPointMeta.CONTENT));
				this.setPosId( (String)r.getValue(InspectionPointMeta.POS_ID));
				this.setCreateBy( (String)r.getValue(InspectionPointMeta.CREATE_BY));
				this.setRouteId( (String)r.getValue(InspectionPointMeta.ROUTE_ID));
				this.setDeleted( (Integer)r.getValue(InspectionPointMeta.DELETED));
				this.setPictureId( (String)r.getValue(InspectionPointMeta.PICTURE_ID));
				this.setPos( (String)r.getValue(InspectionPointMeta.POS));
				this.setCreateTime( (Date)r.getValue(InspectionPointMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(InspectionPointMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(InspectionPointMeta.DELETE_TIME));
				this.setName( (String)r.getValue(InspectionPointMeta.NAME));
				this.setTenantId( (String)r.getValue(InspectionPointMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(InspectionPointMeta.DELETE_BY));
				this.setRfid( (String)r.getValue(InspectionPointMeta.RFID));
				this.setPosLongitude( (String)r.getValue(InspectionPointMeta.POS_LONGITUDE));
				this.setId( (String)r.getValue(InspectionPointMeta.ID));
				this.setStatus( (String)r.getValue(InspectionPointMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}