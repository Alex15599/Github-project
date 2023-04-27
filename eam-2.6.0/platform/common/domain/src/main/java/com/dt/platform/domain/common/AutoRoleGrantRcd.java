package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.SysTables.SYS_AUTO_ROLE_GRANT_RCD;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.common.meta.AutoRoleGrantRcdMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 操作日志
 * <p>操作日志 , 数据表 sys_auto_role_grant_rcd 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-01-27 14:19:24
 * @sign 6AB3253CA1F8EC103A00869FB568B73E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_auto_role_grant_rcd")
@ApiModel(description = "操作日志 ; 操作日志 , 数据表 sys_auto_role_grant_rcd 的PO类型")
public class AutoRoleGrantRcd extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_AUTO_ROLE_GRANT_RCD.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "617806989879148544")
	private String id;
	
	/**
	 * 模块：模块
	*/
	@ApiModelProperty(required = false,value="模块" , notes = "模块" , example = "eam_role")
	private String moduleRoleId;
	
	/**
	 * 角色：角色
	*/
	@ApiModelProperty(required = false,value="角色" , notes = "角色" , example = "617293164289458176")
	private String roleId;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户" , example = "110588348101165911")
	private String userId;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-09-01 07:44:24")
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
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员")
	private Employee user;
	
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
	public AutoRoleGrantRcd setId(String id) {
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
	public AutoRoleGrantRcd setModuleRoleId(String moduleRoleId) {
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
	public AutoRoleGrantRcd setRoleId(String roleId) {
		this.roleId=roleId;
		return this;
	}
	
	/**
	 * 获得 用户<br>
	 * 用户
	 * @return 用户
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 用户
	 * @param userId 用户
	 * @return 当前对象
	*/
	public AutoRoleGrantRcd setUserId(String userId) {
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
	public AutoRoleGrantRcd setCreateBy(String createBy) {
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
	public AutoRoleGrantRcd setCreateTime(Date createTime) {
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
	public AutoRoleGrantRcd setUpdateBy(String updateBy) {
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
	public AutoRoleGrantRcd setUpdateTime(Date updateTime) {
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
	public AutoRoleGrantRcd setDeleted(Integer deleted) {
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
	public AutoRoleGrantRcd setDeleted(Boolean deletedBool) {
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
	public AutoRoleGrantRcd setDeleteBy(String deleteBy) {
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
	public AutoRoleGrantRcd setDeleteTime(Date deleteTime) {
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
	public AutoRoleGrantRcd setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 人员<br>
	 * 人员
	 * @return 人员
	*/
	public Employee getUser() {
		return user;
	}
	
	/**
	 * 设置 人员
	 * @param user 人员
	 * @return 当前对象
	*/
	public AutoRoleGrantRcd setUser(Employee user) {
		this.user=user;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AutoRoleGrantRcd , 转换好的 AutoRoleGrantRcd 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AutoRoleGrantRcd , 转换好的 PoJo 对象
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
	public AutoRoleGrantRcd clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AutoRoleGrantRcd duplicate(boolean all) {
		com.dt.platform.domain.common.meta.AutoRoleGrantRcdMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.AutoRoleGrantRcdMeta.$$proxy$$();
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setRoleId(this.getRoleId());
		inst.setModuleRoleId(this.getModuleRoleId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		if(all) {
			inst.setUser(this.getUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AutoRoleGrantRcd clone(boolean deep) {
		return EntityContext.clone(AutoRoleGrantRcd.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AutoRoleGrantRcd
	 * @param autoRoleGrantRcdMap 包含实体信息的 Map 对象
	 * @return AutoRoleGrantRcd , 转换好的的 AutoRoleGrantRcd 对象
	*/
	@Transient
	public static AutoRoleGrantRcd createFrom(Map<String,Object> autoRoleGrantRcdMap) {
		if(autoRoleGrantRcdMap==null) return null;
		AutoRoleGrantRcd po = create();
		EntityContext.copyProperties(po,autoRoleGrantRcdMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AutoRoleGrantRcd
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AutoRoleGrantRcd , 转换好的的 AutoRoleGrantRcd 对象
	*/
	@Transient
	public static AutoRoleGrantRcd createFrom(Object pojo) {
		if(pojo==null) return null;
		AutoRoleGrantRcd po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AutoRoleGrantRcd，等同于 new
	 * @return AutoRoleGrantRcd 对象
	*/
	@Transient
	public static AutoRoleGrantRcd create() {
		return new com.dt.platform.domain.common.meta.AutoRoleGrantRcdMeta.$$proxy$$();
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
			this.setCreateBy(DataParser.parse(String.class, map.get(AutoRoleGrantRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AutoRoleGrantRcdMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AutoRoleGrantRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AutoRoleGrantRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AutoRoleGrantRcdMeta.DELETE_TIME)));
			this.setRoleId(DataParser.parse(String.class, map.get(AutoRoleGrantRcdMeta.ROLE_ID)));
			this.setModuleRoleId(DataParser.parse(String.class, map.get(AutoRoleGrantRcdMeta.MODULE_ROLE_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AutoRoleGrantRcdMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AutoRoleGrantRcdMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, map.get(AutoRoleGrantRcdMeta.ID)));
			this.setUserId(DataParser.parse(String.class, map.get(AutoRoleGrantRcdMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AutoRoleGrantRcdMeta.VERSION)));
			// others
			this.setUser(DataParser.parse(Employee.class, map.get(AutoRoleGrantRcdMeta.USER)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)map.get(AutoRoleGrantRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AutoRoleGrantRcdMeta.DELETED));
				this.setCreateTime( (Date)map.get(AutoRoleGrantRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AutoRoleGrantRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AutoRoleGrantRcdMeta.DELETE_TIME));
				this.setRoleId( (String)map.get(AutoRoleGrantRcdMeta.ROLE_ID));
				this.setModuleRoleId( (String)map.get(AutoRoleGrantRcdMeta.MODULE_ROLE_ID));
				this.setDeleteBy( (String)map.get(AutoRoleGrantRcdMeta.DELETE_BY));
				this.setUpdateTime( (Date)map.get(AutoRoleGrantRcdMeta.UPDATE_TIME));
				this.setId( (String)map.get(AutoRoleGrantRcdMeta.ID));
				this.setUserId( (String)map.get(AutoRoleGrantRcdMeta.USER_ID));
				this.setVersion( (Integer)map.get(AutoRoleGrantRcdMeta.VERSION));
				// others
				this.setUser( (Employee)map.get(AutoRoleGrantRcdMeta.USER));
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
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AutoRoleGrantRcdMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AutoRoleGrantRcdMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AutoRoleGrantRcdMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AutoRoleGrantRcdMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AutoRoleGrantRcdMeta.DELETE_TIME)));
			this.setRoleId(DataParser.parse(String.class, r.getValue(AutoRoleGrantRcdMeta.ROLE_ID)));
			this.setModuleRoleId(DataParser.parse(String.class, r.getValue(AutoRoleGrantRcdMeta.MODULE_ROLE_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AutoRoleGrantRcdMeta.DELETE_BY)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AutoRoleGrantRcdMeta.UPDATE_TIME)));
			this.setId(DataParser.parse(String.class, r.getValue(AutoRoleGrantRcdMeta.ID)));
			this.setUserId(DataParser.parse(String.class, r.getValue(AutoRoleGrantRcdMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AutoRoleGrantRcdMeta.VERSION)));
			return true;
		} else {
			try {
				this.setCreateBy( (String)r.getValue(AutoRoleGrantRcdMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AutoRoleGrantRcdMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AutoRoleGrantRcdMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AutoRoleGrantRcdMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AutoRoleGrantRcdMeta.DELETE_TIME));
				this.setRoleId( (String)r.getValue(AutoRoleGrantRcdMeta.ROLE_ID));
				this.setModuleRoleId( (String)r.getValue(AutoRoleGrantRcdMeta.MODULE_ROLE_ID));
				this.setDeleteBy( (String)r.getValue(AutoRoleGrantRcdMeta.DELETE_BY));
				this.setUpdateTime( (Date)r.getValue(AutoRoleGrantRcdMeta.UPDATE_TIME));
				this.setId( (String)r.getValue(AutoRoleGrantRcdMeta.ID));
				this.setUserId( (String)r.getValue(AutoRoleGrantRcdMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(AutoRoleGrantRcdMeta.VERSION));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}