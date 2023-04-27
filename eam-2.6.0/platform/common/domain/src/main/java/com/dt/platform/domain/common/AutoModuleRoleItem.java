package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_AUTO_MODULE_ROLE_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.AutoModuleRoleItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 赋权明细
 * <p>赋权明细 , 数据表 sys_auto_module_role_item 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:04:25
 * @sign 775263D162566BC1372FE92414B2F6AC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_auto_module_role_item")
@ApiModel(description = "赋权明细 ; 赋权明细 , 数据表 sys_auto_module_role_item 的PO类型")
public class AutoModuleRoleItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_AUTO_MODULE_ROLE_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "1")
	private String id;
	
	/**
	 * 模块：模块
	*/
	@ApiModelProperty(required = false,value="模块" , notes = "模块" , example = "eam_role")
	private String moduleRoleId;
	
	/**
	 * 角色：角色
	*/
	@ApiModelProperty(required = false,value="角色" , notes = "角色" , example = "505736820663779328")
	private String roleId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "固定资产员工")
	private String roleName;
	
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
	public AutoModuleRoleItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 模块<br>
	 * 模块
	 * @return 模块
	*/
	public String getModuleRoleId() {
		return moduleRoleId;
	}
	
	/**
	 * 设置 模块
	 * @param moduleRoleId 模块
	 * @return 当前对象
	*/
	public AutoModuleRoleItem setModuleRoleId(String moduleRoleId) {
		this.moduleRoleId=moduleRoleId;
		return this;
	}
	
	/**
	 * 获得 角色<br>
	 * 角色
	 * @return 角色
	*/
	public String getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置 角色
	 * @param roleId 角色
	 * @return 当前对象
	*/
	public AutoModuleRoleItem setRoleId(String roleId) {
		this.roleId=roleId;
		return this;
	}
	
	/**
	 * 获得 名称<br>
	 * 名称
	 * @return 名称
	*/
	public String getRoleName() {
		return roleName;
	}
	
	/**
	 * 设置 名称
	 * @param roleName 名称
	 * @return 当前对象
	*/
	public AutoModuleRoleItem setRoleName(String roleName) {
		this.roleName=roleName;
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
	public AutoModuleRoleItem setCreateTime(Date createTime) {
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
	public AutoModuleRoleItem setUpdateBy(String updateBy) {
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
	public AutoModuleRoleItem setUpdateTime(Date updateTime) {
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
	public AutoModuleRoleItem setDeleted(Integer deleted) {
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
	public AutoModuleRoleItem setDeleted(Boolean deletedBool) {
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
	public AutoModuleRoleItem setDeleteBy(String deleteBy) {
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
	public AutoModuleRoleItem setDeleteTime(Date deleteTime) {
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
	public AutoModuleRoleItem setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoModuleRoleItem , 转换好的 AutoModuleRoleItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoModuleRoleItem , 转换好的 PoJo 对象
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
	public AutoModuleRoleItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoModuleRoleItem duplicate(boolean all) {
		com.dt.platform.domain.common.meta.AutoModuleRoleItemMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.AutoModuleRoleItemMeta.$$proxy$$();
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setRoleId(this.getRoleId());
		inst.setRoleName(this.getRoleName());
		inst.setModuleRoleId(this.getModuleRoleId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setVersion(this.getVersion());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoModuleRoleItem clone(boolean deep) {
		return EntityContext.clone(AutoModuleRoleItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoModuleRoleItem
	 * @param autoModuleRoleItemMap 包含实体信息的 Map 对象
	 * @return AutoModuleRoleItem , 转换好的的 AutoModuleRoleItem 对象
	*/
	@Transient
	public static AutoModuleRoleItem createFrom(Map<String,Object> autoModuleRoleItemMap) {
		if(autoModuleRoleItemMap==null) return null;
		AutoModuleRoleItem po = create();
		EntityContext.copyProperties(po,autoModuleRoleItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoModuleRoleItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoModuleRoleItem , 转换好的的 AutoModuleRoleItem 对象
	*/
	@Transient
	public static AutoModuleRoleItem createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoModuleRoleItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoModuleRoleItem，等同于 new
	 * @return AutoModuleRoleItem 对象
	*/
	@Transient
	public static AutoModuleRoleItem create() {
		return new com.dt.platform.domain.common.meta.AutoModuleRoleItemMeta.$$proxy$$();
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
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoModuleRoleItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AutoModuleRoleItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoModuleRoleItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoModuleRoleItemMeta.DELETE_TIME)));
			this.setRoleId(DataParser.parse(String.class, map.get(AutoModuleRoleItemMeta.ROLE_ID)));
			this.setRoleName(DataParser.parse(String.class, map.get(AutoModuleRoleItemMeta.ROLE_NAME)));
			this.setModuleRoleId(DataParser.parse(String.class, map.get(AutoModuleRoleItemMeta.MODULE_ROLE_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoModuleRoleItemMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoModuleRoleItemMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(AutoModuleRoleItemMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoModuleRoleItemMeta.VERSION)));
			// others
			return true;
		} else {
			try {
				this.setDeleted( (Integer)map.get(AutoModuleRoleItemMeta.DELETED));
				this.setCreateTime( (Date)map.get(AutoModuleRoleItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AutoModuleRoleItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoModuleRoleItemMeta.DELETE_TIME));
				this.setRoleId( (String)map.get(AutoModuleRoleItemMeta.ROLE_ID));
				this.setRoleName( (String)map.get(AutoModuleRoleItemMeta.ROLE_NAME));
				this.setModuleRoleId( (String)map.get(AutoModuleRoleItemMeta.MODULE_ROLE_ID));
				this.setDeleteBy( (String)map.get(AutoModuleRoleItemMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(AutoModuleRoleItemMeta.UPDATE_TIME));
				this.setId( (String)map.get(AutoModuleRoleItemMeta.ID));
				this.setVersion( (Integer)map.get(AutoModuleRoleItemMeta.VERSION));
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
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoModuleRoleItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AutoModuleRoleItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoModuleRoleItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoModuleRoleItemMeta.DELETE_TIME)));
			this.setRoleId(DataParser.parse(String.class, r.getValue(AutoModuleRoleItemMeta.ROLE_ID)));
			this.setRoleName(DataParser.parse(String.class, r.getValue(AutoModuleRoleItemMeta.ROLE_NAME)));
			this.setModuleRoleId(DataParser.parse(String.class, r.getValue(AutoModuleRoleItemMeta.MODULE_ROLE_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoModuleRoleItemMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoModuleRoleItemMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoModuleRoleItemMeta.ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoModuleRoleItemMeta.VERSION)));
			return true;
		} else {
			try {
				this.setDeleted( (Integer)r.getValue(AutoModuleRoleItemMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AutoModuleRoleItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AutoModuleRoleItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoModuleRoleItemMeta.DELETE_TIME));
				this.setRoleId( (String)r.getValue(AutoModuleRoleItemMeta.ROLE_ID));
				this.setRoleName( (String)r.getValue(AutoModuleRoleItemMeta.ROLE_NAME));
				this.setModuleRoleId( (String)r.getValue(AutoModuleRoleItemMeta.MODULE_ROLE_ID));
				this.setDeleteBy( (String)r.getValue(AutoModuleRoleItemMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(AutoModuleRoleItemMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(AutoModuleRoleItemMeta.ID));
				this.setVersion( (Integer)r.getValue(AutoModuleRoleItemMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}