package com.dt.platform.domain.wms;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.WmsTables.WMS_TRANSPORT_ADDR;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.wms.meta.TransportAddrMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 地址管理
 * <p>地址管理 , 数据表 wms_transport_addr 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 15:06:54
 * @sign 0D8D30255A0C3F320BE1CE12B5BDF918
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "wms_transport_addr")
@ApiModel(description = "地址管理 ; 地址管理 , 数据表 wms_transport_addr 的PO类型")
public class TransportAddr extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =WMS_TRANSPORT_ADDR.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户")
	private String user;
	
	/**
	 * 联系人：联系人
	*/
	@ApiModelProperty(required = false,value="联系人" , notes = "联系人")
	private String contact;
	
	/**
	 * 联系电话：联系电话
	*/
	@ApiModelProperty(required = false,value="联系电话" , notes = "联系电话")
	private String mobile;
	
	/**
	 * 地址：地址
	*/
	@ApiModelProperty(required = false,value="地址" , notes = "地址")
	private String address;
	
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
	public TransportAddr setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 用户<br>
	 * 用户
	 * @return 用户
	*/
	public String getUser() {
		return user;
	}
	
	/**
	 * 设置 用户
	 * @param user 用户
	 * @return 当前对象
	*/
	public TransportAddr setUser(String user) {
		this.user=user;
		return this;
	}
	
	/**
	 * 获得 联系人<br>
	 * 联系人
	 * @return 联系人
	*/
	public String getContact() {
		return contact;
	}
	
	/**
	 * 设置 联系人
	 * @param contact 联系人
	 * @return 当前对象
	*/
	public TransportAddr setContact(String contact) {
		this.contact=contact;
		return this;
	}
	
	/**
	 * 获得 联系电话<br>
	 * 联系电话
	 * @return 联系电话
	*/
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置 联系电话
	 * @param mobile 联系电话
	 * @return 当前对象
	*/
	public TransportAddr setMobile(String mobile) {
		this.mobile=mobile;
		return this;
	}
	
	/**
	 * 获得 地址<br>
	 * 地址
	 * @return 地址
	*/
	public String getAddress() {
		return address;
	}
	
	/**
	 * 设置 地址
	 * @param address 地址
	 * @return 当前对象
	*/
	public TransportAddr setAddress(String address) {
		this.address=address;
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
	public TransportAddr setNotes(String notes) {
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
	public TransportAddr setCreateBy(String createBy) {
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
	public TransportAddr setCreateTime(Date createTime) {
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
	public TransportAddr setUpdateBy(String updateBy) {
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
	public TransportAddr setUpdateTime(Date updateTime) {
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
	public TransportAddr setDeleted(Integer deleted) {
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
	public TransportAddr setDeleted(Boolean deletedBool) {
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
	public TransportAddr setDeleteBy(String deleteBy) {
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
	public TransportAddr setDeleteTime(Date deleteTime) {
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
	public TransportAddr setVersion(Integer version) {
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
	public TransportAddr setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return TransportAddr , 转换好的 TransportAddr 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return TransportAddr , 转换好的 PoJo 对象
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
	public TransportAddr clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public TransportAddr duplicate(boolean all) {
		com.dt.platform.domain.wms.meta.TransportAddrMeta.$$proxy$$ inst = new com.dt.platform.domain.wms.meta.TransportAddrMeta.$$proxy$$();
		inst.setAddress(this.getAddress());
		inst.setNotes(this.getNotes());
		inst.setMobile(this.getMobile());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setContact(this.getContact());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setUser(this.getUser());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public TransportAddr clone(boolean deep) {
		return EntityContext.clone(TransportAddr.class,this,deep);
	}

	/**
	 * 将 Map 转换成 TransportAddr
	 * @param transportAddrMap 包含实体信息的 Map 对象
	 * @return TransportAddr , 转换好的的 TransportAddr 对象
	*/
	@Transient
	public static TransportAddr createFrom(Map<String,Object> transportAddrMap) {
		if(transportAddrMap==null) return null;
		TransportAddr po = create();
		EntityContext.copyProperties(po,transportAddrMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 TransportAddr
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return TransportAddr , 转换好的的 TransportAddr 对象
	*/
	@Transient
	public static TransportAddr createFrom(Object pojo) {
		if(pojo==null) return null;
		TransportAddr po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 TransportAddr，等同于 new
	 * @return TransportAddr 对象
	*/
	@Transient
	public static TransportAddr create() {
		return new com.dt.platform.domain.wms.meta.TransportAddrMeta.$$proxy$$();
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
			this.setAddress(DataParser.parse(String.class, map.get(TransportAddrMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, map.get(TransportAddrMeta.NOTES)));
			this.setMobile(DataParser.parse(String.class, map.get(TransportAddrMeta.MOBILE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(TransportAddrMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(TransportAddrMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(TransportAddrMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(TransportAddrMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(TransportAddrMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(TransportAddrMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(TransportAddrMeta.DELETE_TIME)));
			this.setContact(DataParser.parse(String.class, map.get(TransportAddrMeta.CONTACT)));
			this.setTenantId(DataParser.parse(String.class, map.get(TransportAddrMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(TransportAddrMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(TransportAddrMeta.ID)));
			this.setUser(DataParser.parse(String.class, map.get(TransportAddrMeta.USER)));
			// others
			return true;
		} else {
			try {
				this.setAddress( (String)map.get(TransportAddrMeta.ADDRESS));
				this.setNotes( (String)map.get(TransportAddrMeta.NOTES));
				this.setMobile( (String)map.get(TransportAddrMeta.MOBILE));
				this.setUpdateTime( (Date)map.get(TransportAddrMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(TransportAddrMeta.VERSION));
				this.setCreateBy( (String)map.get(TransportAddrMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(TransportAddrMeta.DELETED));
				this.setCreateTime( (Date)map.get(TransportAddrMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(TransportAddrMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(TransportAddrMeta.DELETE_TIME));
				this.setContact( (String)map.get(TransportAddrMeta.CONTACT));
				this.setTenantId( (String)map.get(TransportAddrMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(TransportAddrMeta.DELETE_BY));
				this.setId( (String)map.get(TransportAddrMeta.ID));
				this.setUser( (String)map.get(TransportAddrMeta.USER));
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
			this.setAddress(DataParser.parse(String.class, r.getValue(TransportAddrMeta.ADDRESS)));
			this.setNotes(DataParser.parse(String.class, r.getValue(TransportAddrMeta.NOTES)));
			this.setMobile(DataParser.parse(String.class, r.getValue(TransportAddrMeta.MOBILE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(TransportAddrMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(TransportAddrMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(TransportAddrMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(TransportAddrMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(TransportAddrMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(TransportAddrMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(TransportAddrMeta.DELETE_TIME)));
			this.setContact(DataParser.parse(String.class, r.getValue(TransportAddrMeta.CONTACT)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(TransportAddrMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(TransportAddrMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(TransportAddrMeta.ID)));
			this.setUser(DataParser.parse(String.class, r.getValue(TransportAddrMeta.USER)));
			return true;
		} else {
			try {
				this.setAddress( (String)r.getValue(TransportAddrMeta.ADDRESS));
				this.setNotes( (String)r.getValue(TransportAddrMeta.NOTES));
				this.setMobile( (String)r.getValue(TransportAddrMeta.MOBILE));
				this.setUpdateTime( (Date)r.getValue(TransportAddrMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(TransportAddrMeta.VERSION));
				this.setCreateBy( (String)r.getValue(TransportAddrMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(TransportAddrMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(TransportAddrMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(TransportAddrMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(TransportAddrMeta.DELETE_TIME));
				this.setContact( (String)r.getValue(TransportAddrMeta.CONTACT));
				this.setTenantId( (String)r.getValue(TransportAddrMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(TransportAddrMeta.DELETE_BY));
				this.setId( (String)r.getValue(TransportAddrMeta.ID));
				this.setUser( (String)r.getValue(TransportAddrMeta.USER));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}