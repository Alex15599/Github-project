package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_AUTO_MODULE_ROLE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.AutoModuleRoleMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 模块角色
 * <p>模块角色 , 数据表 sys_auto_module_role 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-04 15:14:30
 * @sign 9513C6C8DE583C1601C264AFB79339FB
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_auto_module_role")
@ApiModel(description = "模块角色 ; 模块角色 , 数据表 sys_auto_module_role 的PO类型")
public class AutoModuleRole extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_AUTO_MODULE_ROLE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "eam_data_role")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "系统-用户自动配置数据角色")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 模块：模块
	*/
	@ApiModelProperty(required = false,value="模块" , notes = "模块" , example = "eam")
	private String module;
	
	/**
	 * 类型：role|data_role|busi_role
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "role|data_role|busi_role" , example = "busi_role")
	private String type;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-01-27 01:56:41")
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
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "2")
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
	public AutoModuleRole setId(String id) {
		this.id=id;
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
	public AutoModuleRole setName(String name) {
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
	public AutoModuleRole setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 模块<br>
	 * 模块
	 * @return 模块
	*/
	public String getModule() {
		return module;
	}
	
	/**
	 * 设置 模块
	 * @param module 模块
	 * @return 当前对象
	*/
	public AutoModuleRole setModule(String module) {
		this.module=module;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * role|data_role|busi_role
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
	public AutoModuleRole setType(String type) {
		this.type=type;
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
	public AutoModuleRole setCreateTime(Date createTime) {
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
	public AutoModuleRole setUpdateBy(String updateBy) {
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
	public AutoModuleRole setUpdateTime(Date updateTime) {
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
	public AutoModuleRole setDeleted(Integer deleted) {
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
	public AutoModuleRole setDeleted(Boolean deletedBool) {
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
	public AutoModuleRole setDeleteBy(String deleteBy) {
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
	public AutoModuleRole setDeleteTime(Date deleteTime) {
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
	public AutoModuleRole setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoModuleRole , 转换好的 AutoModuleRole 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoModuleRole , 转换好的 PoJo 对象
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
	public AutoModuleRole clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoModuleRole duplicate(boolean all) {
		com.dt.platform.domain.common.meta.AutoModuleRoleMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.AutoModuleRoleMeta.$$proxy$$();
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setModule(this.getModule());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoModuleRole clone(boolean deep) {
		return EntityContext.clone(AutoModuleRole.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoModuleRole
	 * @param autoModuleRoleMap 包含实体信息的 Map 对象
	 * @return AutoModuleRole , 转换好的的 AutoModuleRole 对象
	*/
	@Transient
	public static AutoModuleRole createFrom(Map<String,Object> autoModuleRoleMap) {
		if(autoModuleRoleMap==null) return null;
		AutoModuleRole po = create();
		EntityContext.copyProperties(po,autoModuleRoleMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoModuleRole
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoModuleRole , 转换好的的 AutoModuleRole 对象
	*/
	@Transient
	public static AutoModuleRole createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoModuleRole po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoModuleRole，等同于 new
	 * @return AutoModuleRole 对象
	*/
	@Transient
	public static AutoModuleRole create() {
		return new com.dt.platform.domain.common.meta.AutoModuleRoleMeta.$$proxy$$();
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
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoModuleRoleMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AutoModuleRoleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoModuleRoleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoModuleRoleMeta.DELETE_TIME)));
			this.setModule(DataParser.parse(String.class, map.get(AutoModuleRoleMeta.MODULE)));
			this.setName(DataParser.parse(String.class, map.get(AutoModuleRoleMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoModuleRoleMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoModuleRoleMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(AutoModuleRoleMeta.ID)));
			this.setType(DataParser.parse(String.class, map.get(AutoModuleRoleMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoModuleRoleMeta.VERSION)));
			this.setStatus(DataParser.parse(String.class, map.get(AutoModuleRoleMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setDeleted( (Integer)map.get(AutoModuleRoleMeta.DELETED));
				this.setCreateTime( (Date)map.get(AutoModuleRoleMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AutoModuleRoleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoModuleRoleMeta.DELETE_TIME));
				this.setModule( (String)map.get(AutoModuleRoleMeta.MODULE));
				this.setName( (String)map.get(AutoModuleRoleMeta.NAME));
				this.setDeleteBy( (String)map.get(AutoModuleRoleMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(AutoModuleRoleMeta.UPDATE_TIME));
				this.setId( (String)map.get(AutoModuleRoleMeta.ID));
				this.setType( (String)map.get(AutoModuleRoleMeta.TYPE));
				this.setVersion( (Integer)map.get(AutoModuleRoleMeta.VERSION));
				this.setStatus( (String)map.get(AutoModuleRoleMeta.STATUS));
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
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoModuleRoleMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AutoModuleRoleMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoModuleRoleMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoModuleRoleMeta.DELETE_TIME)));
			this.setModule(DataParser.parse(String.class, r.getValue(AutoModuleRoleMeta.MODULE)));
			this.setName(DataParser.parse(String.class, r.getValue(AutoModuleRoleMeta.NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoModuleRoleMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoModuleRoleMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoModuleRoleMeta.ID)));
			this.setType(DataParser.parse(String.class, r.getValue(AutoModuleRoleMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoModuleRoleMeta.VERSION)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AutoModuleRoleMeta.STATUS)));
			return true;
		} else {
			try {
				this.setDeleted( (Integer)r.getValue(AutoModuleRoleMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AutoModuleRoleMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AutoModuleRoleMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoModuleRoleMeta.DELETE_TIME));
				this.setModule( (String)r.getValue(AutoModuleRoleMeta.MODULE));
				this.setName( (String)r.getValue(AutoModuleRoleMeta.NAME));
				this.setDeleteBy( (String)r.getValue(AutoModuleRoleMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(AutoModuleRoleMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(AutoModuleRoleMeta.ID));
				this.setType( (String)r.getValue(AutoModuleRoleMeta.TYPE));
				this.setVersion( (Integer)r.getValue(AutoModuleRoleMeta.VERSION));
				this.setStatus( (String)r.getValue(AutoModuleRoleMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}