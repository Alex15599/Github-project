package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_C_CUST_INSPECT_USER_R;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.CCustInspectUserRMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检人员
 * <p>巡检人员 , 数据表 eam_c_cust_inspect_user_r 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-06 08:37:48
 * @sign 0144E1E6F74EB1FD235114E79174175A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_c_cust_inspect_user_r")
@ApiModel(description = "巡检人员 ; 巡检人员 , 数据表 eam_c_cust_inspect_user_r 的PO类型")
public class CCustInspectUserR extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_C_CUST_INSPECT_USER_R.$TABLE;
	
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
	private String code;
	
	/**
	 * 分组：分组
	*/
	@ApiModelProperty(required = false,value="分组" , notes = "分组")
	private String group;
	
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
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
	public CCustInspectUserR setId(String id) {
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
	public CCustInspectUserR setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 分组<br>
	 * 分组
	 * @return 分组
	*/
	public String getGroup() {
		return group;
	}
	
	/**
	 * 设置 分组
	 * @param group 分组
	 * @return 当前对象
	*/
	public CCustInspectUserR setGroup(String group) {
		this.group=group;
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
	public CCustInspectUserR setNotes(String notes) {
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
	public CCustInspectUserR setCreateBy(String createBy) {
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
	public CCustInspectUserR setCreateTime(Date createTime) {
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
	public CCustInspectUserR setUpdateBy(String updateBy) {
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
	public CCustInspectUserR setUpdateTime(Date updateTime) {
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
	public CCustInspectUserR setDeleted(Integer deleted) {
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
	public CCustInspectUserR setDeleted(Boolean deletedBool) {
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
	public CCustInspectUserR setDeleteBy(String deleteBy) {
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
	public CCustInspectUserR setDeleteTime(Date deleteTime) {
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
	public CCustInspectUserR setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public CCustInspectUserR setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CCustInspectUserR , 转换好的 CCustInspectUserR 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CCustInspectUserR , 转换好的 PoJo 对象
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
	public CCustInspectUserR clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CCustInspectUserR duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CCustInspectUserRMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CCustInspectUserRMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setGroup(this.getGroup());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CCustInspectUserR clone(boolean deep) {
		return EntityContext.clone(CCustInspectUserR.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CCustInspectUserR
	 * @param cCustInspectUserRMap 包含实体信息的 Map 对象
	 * @return CCustInspectUserR , 转换好的的 CCustInspectUserR 对象
	*/
	@Transient
	public static CCustInspectUserR createFrom(Map<String,Object> cCustInspectUserRMap) {
		if(cCustInspectUserRMap==null) return null;
		CCustInspectUserR po = create();
		EntityContext.copyProperties(po,cCustInspectUserRMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CCustInspectUserR
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CCustInspectUserR , 转换好的的 CCustInspectUserR 对象
	*/
	@Transient
	public static CCustInspectUserR createFrom(Object pojo) {
		if(pojo==null) return null;
		CCustInspectUserR po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CCustInspectUserR，等同于 new
	 * @return CCustInspectUserR 对象
	*/
	@Transient
	public static CCustInspectUserR create() {
		return new com.dt.platform.domain.eam.meta.CCustInspectUserRMeta.$$proxy$$();
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
			this.setCode(DataParser.parse(String.class, map.get(CCustInspectUserRMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, map.get(CCustInspectUserRMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CCustInspectUserRMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CCustInspectUserRMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CCustInspectUserRMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CCustInspectUserRMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CCustInspectUserRMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CCustInspectUserRMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CCustInspectUserRMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CCustInspectUserRMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CCustInspectUserRMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CCustInspectUserRMeta.ID)));
			this.setGroup(DataParser.parse(String.class, map.get(CCustInspectUserRMeta.GROUP)));
			// others
			return true;
		} else {
			try {
				this.setCode( (String)map.get(CCustInspectUserRMeta.CODE));
				this.setNotes( (String)map.get(CCustInspectUserRMeta.NOTES));
				this.setUpdateTime( (Date)map.get(CCustInspectUserRMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(CCustInspectUserRMeta.VERSION));
				this.setCreateBy( (String)map.get(CCustInspectUserRMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CCustInspectUserRMeta.DELETED));
				this.setCreateTime( (Date)map.get(CCustInspectUserRMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CCustInspectUserRMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CCustInspectUserRMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(CCustInspectUserRMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CCustInspectUserRMeta.DELETE_BY));
				this.setId( (String)map.get(CCustInspectUserRMeta.ID));
				this.setGroup( (String)map.get(CCustInspectUserRMeta.GROUP));
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
			this.setCode(DataParser.parse(String.class, r.getValue(CCustInspectUserRMeta.CODE)));
			this.setNotes(DataParser.parse(String.class, r.getValue(CCustInspectUserRMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CCustInspectUserRMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CCustInspectUserRMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CCustInspectUserRMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CCustInspectUserRMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CCustInspectUserRMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CCustInspectUserRMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CCustInspectUserRMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CCustInspectUserRMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CCustInspectUserRMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CCustInspectUserRMeta.ID)));
			this.setGroup(DataParser.parse(String.class, r.getValue(CCustInspectUserRMeta.GROUP)));
			return true;
		} else {
			try {
				this.setCode( (String)r.getValue(CCustInspectUserRMeta.CODE));
				this.setNotes( (String)r.getValue(CCustInspectUserRMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(CCustInspectUserRMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(CCustInspectUserRMeta.VERSION));
				this.setCreateBy( (String)r.getValue(CCustInspectUserRMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CCustInspectUserRMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CCustInspectUserRMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CCustInspectUserRMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CCustInspectUserRMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(CCustInspectUserRMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CCustInspectUserRMeta.DELETE_BY));
				this.setId( (String)r.getValue(CCustInspectUserRMeta.ID));
				this.setGroup( (String)r.getValue(CCustInspectUserRMeta.GROUP));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}