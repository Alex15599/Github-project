package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_MAINTENANCE_UPDATE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetMaintenanceUpdateMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 维保更新
 * <p>维保更新 , 数据表 eam_asset_maintenance_update 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-28 22:25:06
 * @sign C147DE99814C00C5E307D86455DDCB3F
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_maintenance_update")
@ApiModel(description = "维保更新 ; 维保更新 , 数据表 eam_asset_maintenance_update 的PO类型")
public class AssetMaintenanceUpdate extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_MAINTENANCE_UPDATE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "638495539125551104")
	private String id;
	
	/**
	 * 业务编号：业务编号
	*/
	@ApiModelProperty(required = false,value="业务编号" , notes = "业务编号" , example = "C2147483647")
	private String businessCode;
	
	/**
	 * 处理状态：处理状态
	*/
	@ApiModelProperty(required = false,value="处理状态" , notes = "处理状态" , example = "finish")
	private String handleStatus;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "1212")
	private String name;
	
	/**
	 * 原因：原因
	*/
	@ApiModelProperty(required = false,value="原因" , notes = "原因")
	private String reason;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attachId;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-10-28 09:53:19")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
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
	public AssetMaintenanceUpdate setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 业务编号<br>
	 * 业务编号
	 * @return 业务编号
	*/
	public String getBusinessCode() {
		return businessCode;
	}
	
	/**
	 * 设置 业务编号
	 * @param businessCode 业务编号
	 * @return 当前对象
	*/
	public AssetMaintenanceUpdate setBusinessCode(String businessCode) {
		this.businessCode=businessCode;
		return this;
	}
	
	/**
	 * 获得 处理状态<br>
	 * 处理状态
	 * @return 处理状态
	*/
	public String getHandleStatus() {
		return handleStatus;
	}
	
	/**
	 * 设置 处理状态
	 * @param handleStatus 处理状态
	 * @return 当前对象
	*/
	public AssetMaintenanceUpdate setHandleStatus(String handleStatus) {
		this.handleStatus=handleStatus;
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
	public AssetMaintenanceUpdate setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 原因<br>
	 * 原因
	 * @return 原因
	*/
	public String getReason() {
		return reason;
	}
	
	/**
	 * 设置 原因
	 * @param reason 原因
	 * @return 当前对象
	*/
	public AssetMaintenanceUpdate setReason(String reason) {
		this.reason=reason;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 内容
	 * @param content 内容
	 * @return 当前对象
	*/
	public AssetMaintenanceUpdate setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttachId() {
		return attachId;
	}
	
	/**
	 * 设置 附件
	 * @param attachId 附件
	 * @return 当前对象
	*/
	public AssetMaintenanceUpdate setAttachId(String attachId) {
		this.attachId=attachId;
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
	public AssetMaintenanceUpdate setNotes(String notes) {
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
	public AssetMaintenanceUpdate setCreateBy(String createBy) {
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
	public AssetMaintenanceUpdate setCreateTime(Date createTime) {
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
	public AssetMaintenanceUpdate setUpdateBy(String updateBy) {
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
	public AssetMaintenanceUpdate setUpdateTime(Date updateTime) {
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
	public AssetMaintenanceUpdate setDeleted(Integer deleted) {
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
	public AssetMaintenanceUpdate setDeleted(Boolean deletedBool) {
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
	public AssetMaintenanceUpdate setDeleteBy(String deleteBy) {
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
	public AssetMaintenanceUpdate setDeleteTime(Date deleteTime) {
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
	public AssetMaintenanceUpdate setVersion(Integer version) {
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
	public AssetMaintenanceUpdate setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetMaintenanceUpdate , 转换好的 AssetMaintenanceUpdate 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetMaintenanceUpdate , 转换好的 PoJo 对象
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
	public AssetMaintenanceUpdate clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetMaintenanceUpdate duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetMaintenanceUpdateMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetMaintenanceUpdateMeta.$$proxy$$();
		inst.setReason(this.getReason());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setBusinessCode(this.getBusinessCode());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setHandleStatus(this.getHandleStatus());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setAttachId(this.getAttachId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetMaintenanceUpdate clone(boolean deep) {
		return EntityContext.clone(AssetMaintenanceUpdate.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetMaintenanceUpdate
	 * @param assetMaintenanceUpdateMap 包含实体信息的 Map 对象
	 * @return AssetMaintenanceUpdate , 转换好的的 AssetMaintenanceUpdate 对象
	*/
	@Transient
	public static AssetMaintenanceUpdate createFrom(Map<String,Object> assetMaintenanceUpdateMap) {
		if(assetMaintenanceUpdateMap==null) return null;
		AssetMaintenanceUpdate po = create();
		EntityContext.copyProperties(po,assetMaintenanceUpdateMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetMaintenanceUpdate
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetMaintenanceUpdate , 转换好的的 AssetMaintenanceUpdate 对象
	*/
	@Transient
	public static AssetMaintenanceUpdate createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetMaintenanceUpdate po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetMaintenanceUpdate，等同于 new
	 * @return AssetMaintenanceUpdate 对象
	*/
	@Transient
	public static AssetMaintenanceUpdate create() {
		return new com.dt.platform.domain.eam.meta.AssetMaintenanceUpdateMeta.$$proxy$$();
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
			this.setReason(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateMeta.REASON)));
			this.setNotes(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetMaintenanceUpdateMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetMaintenanceUpdateMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetMaintenanceUpdateMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetMaintenanceUpdateMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetMaintenanceUpdateMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateMeta.TENANT_ID)));
			this.setHandleStatus(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateMeta.HANDLE_STATUS)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateMeta.ID)));
			this.setAttachId(DataParser.parse(String.class, map.get(AssetMaintenanceUpdateMeta.ATTACH_ID)));
			// others
			return true;
		} else {
			try {
				this.setReason( (String)map.get(AssetMaintenanceUpdateMeta.REASON));
				this.setNotes( (String)map.get(AssetMaintenanceUpdateMeta.NOTES));
				this.setUpdateTime( (Date)map.get(AssetMaintenanceUpdateMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(AssetMaintenanceUpdateMeta.VERSION));
				this.setContent( (String)map.get(AssetMaintenanceUpdateMeta.CONTENT));
				this.setBusinessCode( (String)map.get(AssetMaintenanceUpdateMeta.BUSINESS_CODE));
				this.setCreateBy( (String)map.get(AssetMaintenanceUpdateMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetMaintenanceUpdateMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetMaintenanceUpdateMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetMaintenanceUpdateMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetMaintenanceUpdateMeta.DELETE_TIME));
				this.setName( (String)map.get(AssetMaintenanceUpdateMeta.NAME));
				this.setTenantId( (String)map.get(AssetMaintenanceUpdateMeta.TENANT_ID));
				this.setHandleStatus( (String)map.get(AssetMaintenanceUpdateMeta.HANDLE_STATUS));
				this.setDeleteBy( (String)map.get(AssetMaintenanceUpdateMeta.DELETE_BY));
				this.setId( (String)map.get(AssetMaintenanceUpdateMeta.ID));
				this.setAttachId( (String)map.get(AssetMaintenanceUpdateMeta.ATTACH_ID));
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
			this.setReason(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateMeta.REASON)));
			this.setNotes(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceUpdateMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetMaintenanceUpdateMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateMeta.CONTENT)));
			this.setBusinessCode(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateMeta.BUSINESS_CODE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetMaintenanceUpdateMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceUpdateMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetMaintenanceUpdateMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateMeta.TENANT_ID)));
			this.setHandleStatus(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateMeta.HANDLE_STATUS)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateMeta.ID)));
			this.setAttachId(DataParser.parse(String.class, r.getValue(AssetMaintenanceUpdateMeta.ATTACH_ID)));
			return true;
		} else {
			try {
				this.setReason( (String)r.getValue(AssetMaintenanceUpdateMeta.REASON));
				this.setNotes( (String)r.getValue(AssetMaintenanceUpdateMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(AssetMaintenanceUpdateMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(AssetMaintenanceUpdateMeta.VERSION));
				this.setContent( (String)r.getValue(AssetMaintenanceUpdateMeta.CONTENT));
				this.setBusinessCode( (String)r.getValue(AssetMaintenanceUpdateMeta.BUSINESS_CODE));
				this.setCreateBy( (String)r.getValue(AssetMaintenanceUpdateMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetMaintenanceUpdateMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetMaintenanceUpdateMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetMaintenanceUpdateMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetMaintenanceUpdateMeta.DELETE_TIME));
				this.setName( (String)r.getValue(AssetMaintenanceUpdateMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetMaintenanceUpdateMeta.TENANT_ID));
				this.setHandleStatus( (String)r.getValue(AssetMaintenanceUpdateMeta.HANDLE_STATUS));
				this.setDeleteBy( (String)r.getValue(AssetMaintenanceUpdateMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetMaintenanceUpdateMeta.ID));
				this.setAttachId( (String)r.getValue(AssetMaintenanceUpdateMeta.ATTACH_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}