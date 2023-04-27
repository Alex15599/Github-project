package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_C_CUST_INSPECT_USER_S;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.CCustInspectUserSMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检人员
 * <p>巡检人员 , 数据表 eam_c_cust_inspect_user_s 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-06 08:37:30
 * @sign 3E3BD543CF54425B3A67F4F9C65BD709
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_c_cust_inspect_user_s")
@ApiModel(description = "巡检人员 ; 巡检人员 , 数据表 eam_c_cust_inspect_user_s 的PO类型")
public class CCustInspectUserS extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_C_CUST_INSPECT_USER_S.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 所属于：所属于
	*/
	@ApiModelProperty(required = false,value="所属于" , notes = "所属于")
	private String ownerId;
	
	/**
	 * 巡检人：巡检人
	*/
	@ApiModelProperty(required = false,value="巡检人" , notes = "巡检人")
	private String userId;
	
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
	public CCustInspectUserS setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 所属于<br>
	 * 所属于
	 * @return 所属于
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 所属于
	 * @param ownerId 所属于
	 * @return 当前对象
	*/
	public CCustInspectUserS setOwnerId(String ownerId) {
		this.ownerId=ownerId;
		return this;
	}
	
	/**
	 * 获得 巡检人<br>
	 * 巡检人
	 * @return 巡检人
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 巡检人
	 * @param userId 巡检人
	 * @return 当前对象
	*/
	public CCustInspectUserS setUserId(String userId) {
		this.userId=userId;
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
	public CCustInspectUserS setCreateBy(String createBy) {
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
	public CCustInspectUserS setCreateTime(Date createTime) {
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
	public CCustInspectUserS setUpdateBy(String updateBy) {
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
	public CCustInspectUserS setUpdateTime(Date updateTime) {
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
	public CCustInspectUserS setDeleted(Integer deleted) {
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
	public CCustInspectUserS setDeleted(Boolean deletedBool) {
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
	public CCustInspectUserS setDeleteBy(String deleteBy) {
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
	public CCustInspectUserS setDeleteTime(Date deleteTime) {
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
	public CCustInspectUserS setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CCustInspectUserS , 转换好的 CCustInspectUserS 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CCustInspectUserS , 转换好的 PoJo 对象
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
	public CCustInspectUserS clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CCustInspectUserS duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CCustInspectUserSMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CCustInspectUserSMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setOwnerId(this.getOwnerId());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CCustInspectUserS clone(boolean deep) {
		return EntityContext.clone(CCustInspectUserS.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CCustInspectUserS
	 * @param cCustInspectUserSMap 包含实体信息的 Map 对象
	 * @return CCustInspectUserS , 转换好的的 CCustInspectUserS 对象
	*/
	@Transient
	public static CCustInspectUserS createFrom(Map<String,Object> cCustInspectUserSMap) {
		if(cCustInspectUserSMap==null) return null;
		CCustInspectUserS po = create();
		EntityContext.copyProperties(po,cCustInspectUserSMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CCustInspectUserS
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CCustInspectUserS , 转换好的的 CCustInspectUserS 对象
	*/
	@Transient
	public static CCustInspectUserS createFrom(Object pojo) {
		if(pojo==null) return null;
		CCustInspectUserS po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CCustInspectUserS，等同于 new
	 * @return CCustInspectUserS 对象
	*/
	@Transient
	public static CCustInspectUserS create() {
		return new com.dt.platform.domain.eam.meta.CCustInspectUserSMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(CCustInspectUserSMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CCustInspectUserSMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CCustInspectUserSMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CCustInspectUserSMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CCustInspectUserSMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CCustInspectUserSMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CCustInspectUserSMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(CCustInspectUserSMeta.ID)));
			this.setOwnerId(DataParser.parse(String.class, map.get(CCustInspectUserSMeta.OWNER_ID)));
			this.setUserId(DataParser.parse(String.class, map.get(CCustInspectUserSMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CCustInspectUserSMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(CCustInspectUserSMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CCustInspectUserSMeta.DELETED));
				this.setCreateTime( (Date)map.get(CCustInspectUserSMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CCustInspectUserSMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CCustInspectUserSMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(CCustInspectUserSMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(CCustInspectUserSMeta.UPDATE_TIME));
				this.setId( (String)map.get(CCustInspectUserSMeta.ID));
				this.setOwnerId( (String)map.get(CCustInspectUserSMeta.OWNER_ID));
				this.setUserId( (String)map.get(CCustInspectUserSMeta.USER_ID));
				this.setVersion( (Integer)map.get(CCustInspectUserSMeta.VERSION));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CCustInspectUserSMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CCustInspectUserSMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CCustInspectUserSMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CCustInspectUserSMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CCustInspectUserSMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CCustInspectUserSMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CCustInspectUserSMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(CCustInspectUserSMeta.ID)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(CCustInspectUserSMeta.OWNER_ID)));
			this.setUserId(DataParser.parse(String.class, r.getValue(CCustInspectUserSMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CCustInspectUserSMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(CCustInspectUserSMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CCustInspectUserSMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CCustInspectUserSMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CCustInspectUserSMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CCustInspectUserSMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(CCustInspectUserSMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(CCustInspectUserSMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(CCustInspectUserSMeta.ID));
				this.setOwnerId( (String)r.getValue(CCustInspectUserSMeta.OWNER_ID));
				this.setUserId( (String)r.getValue(CCustInspectUserSMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(CCustInspectUserSMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}