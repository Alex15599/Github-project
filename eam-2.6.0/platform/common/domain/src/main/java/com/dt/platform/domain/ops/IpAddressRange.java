package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_IP_ADDRESS_RANGE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import org.github.foxnic.web.domain.system.DictItem;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * IP地址段
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-30 07:16:57
 * @sign 33C6E06FC336E6BDF2303441639F5A94
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_ip_address_range")
public class IpAddressRange extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_IP_ADDRESS_RANGE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 地址段：地址段
	*/
	@ApiModelProperty(required = false,value="地址段" , notes = "地址段")
	private String addressSegment;
	
	/**
	 * 区域：区域
	*/
	@ApiModelProperty(required = false,value="区域" , notes = "区域")
	private String regionId;
	
	/**
	 * 分类：分类
	*/
	@ApiModelProperty(required = false,value="分类" , notes = "分类")
	private String classId;
	
	/**
	 * 环境：环境
	*/
	@ApiModelProperty(required = false,value="环境" , notes = "环境")
	private String prodId;
	
	/**
	 * 场景：场景
	*/
	@ApiModelProperty(required = false,value="场景" , notes = "场景")
	private String scene;
	
	/**
	 * VLAN：VLAN
	*/
	@ApiModelProperty(required = false,value="VLAN" , notes = "VLAN")
	private String vlan;
	
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * regionDict：regionDict
	*/
	@ApiModelProperty(required = false,value="regionDict" , notes = "regionDict")
	private DictItem regionDict;
	
	/**
	 * classDict：classDict
	*/
	@ApiModelProperty(required = false,value="classDict" , notes = "classDict")
	private DictItem classDict;
	
	/**
	 * prodDict：prodDict
	*/
	@ApiModelProperty(required = false,value="prodDict" , notes = "prodDict")
	private DictItem prodDict;
	
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
	public IpAddressRange setId(String id) {
		this.id=id;
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
	public IpAddressRange setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 地址段<br>
	 * 地址段
	 * @return 地址段
	*/
	public String getAddressSegment() {
		return addressSegment;
	}
	
	/**
	 * 设置 地址段
	 * @param addressSegment 地址段
	 * @return 当前对象
	*/
	public IpAddressRange setAddressSegment(String addressSegment) {
		this.addressSegment=addressSegment;
		return this;
	}
	
	/**
	 * 获得 区域<br>
	 * 区域
	 * @return 区域
	*/
	public String getRegionId() {
		return regionId;
	}
	
	/**
	 * 设置 区域
	 * @param regionId 区域
	 * @return 当前对象
	*/
	public IpAddressRange setRegionId(String regionId) {
		this.regionId=regionId;
		return this;
	}
	
	/**
	 * 获得 分类<br>
	 * 分类
	 * @return 分类
	*/
	public String getClassId() {
		return classId;
	}
	
	/**
	 * 设置 分类
	 * @param classId 分类
	 * @return 当前对象
	*/
	public IpAddressRange setClassId(String classId) {
		this.classId=classId;
		return this;
	}
	
	/**
	 * 获得 环境<br>
	 * 环境
	 * @return 环境
	*/
	public String getProdId() {
		return prodId;
	}
	
	/**
	 * 设置 环境
	 * @param prodId 环境
	 * @return 当前对象
	*/
	public IpAddressRange setProdId(String prodId) {
		this.prodId=prodId;
		return this;
	}
	
	/**
	 * 获得 场景<br>
	 * 场景
	 * @return 场景
	*/
	public String getScene() {
		return scene;
	}
	
	/**
	 * 设置 场景
	 * @param scene 场景
	 * @return 当前对象
	*/
	public IpAddressRange setScene(String scene) {
		this.scene=scene;
		return this;
	}
	
	/**
	 * 获得 VLAN<br>
	 * VLAN
	 * @return VLAN
	*/
	public String getVlan() {
		return vlan;
	}
	
	/**
	 * 设置 VLAN
	 * @param vlan VLAN
	 * @return 当前对象
	*/
	public IpAddressRange setVlan(String vlan) {
		this.vlan=vlan;
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
	public IpAddressRange setNotes(String notes) {
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
	public IpAddressRange setCreateBy(String createBy) {
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
	public IpAddressRange setCreateTime(Date createTime) {
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
	public IpAddressRange setUpdateBy(String updateBy) {
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
	public IpAddressRange setUpdateTime(Date updateTime) {
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
	public IpAddressRange setDeleted(Integer deleted) {
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
	public IpAddressRange setDeleted(Boolean deletedBool) {
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
	public IpAddressRange setDeleteBy(String deleteBy) {
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
	public IpAddressRange setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public IpAddressRange setVersion(Integer version) {
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
	public IpAddressRange setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 regionDict<br>
	 * regionDict
	 * @return regionDict
	*/
	public DictItem getRegionDict() {
		return regionDict;
	}
	
	/**
	 * 设置 regionDict
	 * @param regionDict regionDict
	 * @return 当前对象
	*/
	public IpAddressRange setRegionDict(DictItem regionDict) {
		this.regionDict=regionDict;
		return this;
	}
	
	/**
	 * 获得 classDict<br>
	 * classDict
	 * @return classDict
	*/
	public DictItem getClassDict() {
		return classDict;
	}
	
	/**
	 * 设置 classDict
	 * @param classDict classDict
	 * @return 当前对象
	*/
	public IpAddressRange setClassDict(DictItem classDict) {
		this.classDict=classDict;
		return this;
	}
	
	/**
	 * 获得 prodDict<br>
	 * prodDict
	 * @return prodDict
	*/
	public DictItem getProdDict() {
		return prodDict;
	}
	
	/**
	 * 设置 prodDict
	 * @param prodDict prodDict
	 * @return 当前对象
	*/
	public IpAddressRange setProdDict(DictItem prodDict) {
		this.prodDict=prodDict;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return IpAddressRange , 转换好的 IpAddressRange 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return IpAddressRange , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 IpAddressRange
	 * @param ipAddressRangeMap 包含实体信息的 Map 对象
	 * @return IpAddressRange , 转换好的的 IpAddressRange 对象
	*/
	@Transient
	public static IpAddressRange createFrom(Map<String,Object> ipAddressRangeMap) {
		if(ipAddressRangeMap==null) return null;
		IpAddressRange po = EntityContext.create(IpAddressRange.class, ipAddressRangeMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 IpAddressRange
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return IpAddressRange , 转换好的的 IpAddressRange 对象
	*/
	@Transient
	public static IpAddressRange createFrom(Object pojo) {
		if(pojo==null) return null;
		IpAddressRange po = EntityContext.create(IpAddressRange.class,pojo);
		return po;
	}

	/**
	 * 创建一个 IpAddressRange，等同于 new
	 * @return IpAddressRange 对象
	*/
	@Transient
	public static IpAddressRange create() {
		return EntityContext.create(IpAddressRange.class);
	}
}