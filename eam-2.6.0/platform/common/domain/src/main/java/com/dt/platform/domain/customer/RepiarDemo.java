package com.dt.platform.domain.customer;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.CustTables.CUST_REPIAR_DEMO;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.customer.meta.RepiarDemoMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 报修
 * <p>报修 , 数据表 cust_repiar_demo 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-06 09:23:38
 * @sign E46A4C8B6AF4855DB4E33816844D9BC5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "cust_repiar_demo")
@ApiModel(description = "报修 ; 报修 , 数据表 cust_repiar_demo 的PO类型")
public class RepiarDemo extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =CUST_REPIAR_DEMO.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private Long id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 标题：标题
	*/
	@ApiModelProperty(required = false,value="标题" , notes = "标题")
	private String title;
	
	/**
	 * 姓名：姓名
	*/
	@ApiModelProperty(required = false,value="姓名" , notes = "姓名")
	private String user;
	
	/**
	 * 申报人部门：申报人部门
	*/
	@ApiModelProperty(required = false,value="申报人部门" , notes = "申报人部门")
	private String org;
	
	/**
	 * 报修内容：报修内容
	*/
	@ApiModelProperty(required = false,value="报修内容" , notes = "报修内容")
	private String content;
	
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
	 * 获得 主键<br>
	 * 主键
	 * @return 主键
	*/
	public Long getId() {
		return id;
	}
	
	/**
	 * 设置 主键
	 * @param id 主键
	 * @return 当前对象
	*/
	public RepiarDemo setId(Long id) {
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
	public RepiarDemo setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 标题<br>
	 * 标题
	 * @return 标题
	*/
	public String getTitle() {
		return title;
	}
	
	/**
	 * 设置 标题
	 * @param title 标题
	 * @return 当前对象
	*/
	public RepiarDemo setTitle(String title) {
		this.title=title;
		return this;
	}
	
	/**
	 * 获得 姓名<br>
	 * 姓名
	 * @return 姓名
	*/
	public String getUser() {
		return user;
	}
	
	/**
	 * 设置 姓名
	 * @param user 姓名
	 * @return 当前对象
	*/
	public RepiarDemo setUser(String user) {
		this.user=user;
		return this;
	}
	
	/**
	 * 获得 申报人部门<br>
	 * 申报人部门
	 * @return 申报人部门
	*/
	public String getOrg() {
		return org;
	}
	
	/**
	 * 设置 申报人部门
	 * @param org 申报人部门
	 * @return 当前对象
	*/
	public RepiarDemo setOrg(String org) {
		this.org=org;
		return this;
	}
	
	/**
	 * 获得 报修内容<br>
	 * 报修内容
	 * @return 报修内容
	*/
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置 报修内容
	 * @param content 报修内容
	 * @return 当前对象
	*/
	public RepiarDemo setContent(String content) {
		this.content=content;
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
	public RepiarDemo setNotes(String notes) {
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
	public RepiarDemo setCreateBy(String createBy) {
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
	public RepiarDemo setCreateTime(Date createTime) {
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
	public RepiarDemo setUpdateBy(String updateBy) {
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
	public RepiarDemo setUpdateTime(Date updateTime) {
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
	public RepiarDemo setDeleted(Integer deleted) {
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
	public RepiarDemo setDeleted(Boolean deletedBool) {
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
	public RepiarDemo setDeleteBy(String deleteBy) {
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
	public RepiarDemo setDeleteTime(Date deleteTime) {
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
	public RepiarDemo setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return RepiarDemo , 转换好的 RepiarDemo 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return RepiarDemo , 转换好的 PoJo 对象
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
	public RepiarDemo clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public RepiarDemo duplicate(boolean all) {
		com.dt.platform.domain.customer.meta.RepiarDemoMeta.$$proxy$$ inst = new com.dt.platform.domain.customer.meta.RepiarDemoMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setOrg(this.getOrg());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setTitle(this.getTitle());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setUser(this.getUser());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public RepiarDemo clone(boolean deep) {
		return EntityContext.clone(RepiarDemo.class,this,deep);
	}

	/**
	 * 将 Map 转换成 RepiarDemo
	 * @param repiarDemoMap 包含实体信息的 Map 对象
	 * @return RepiarDemo , 转换好的的 RepiarDemo 对象
	*/
	@Transient
	public static RepiarDemo createFrom(Map<String,Object> repiarDemoMap) {
		if(repiarDemoMap==null) return null;
		RepiarDemo po = create();
		EntityContext.copyProperties(po,repiarDemoMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 RepiarDemo
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return RepiarDemo , 转换好的的 RepiarDemo 对象
	*/
	@Transient
	public static RepiarDemo createFrom(Object pojo) {
		if(pojo==null) return null;
		RepiarDemo po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 RepiarDemo，等同于 new
	 * @return RepiarDemo 对象
	*/
	@Transient
	public static RepiarDemo create() {
		return new com.dt.platform.domain.customer.meta.RepiarDemoMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(RepiarDemoMeta.NOTES)));
			this.setOrg(DataParser.parse(String.class, map.get(RepiarDemoMeta.ORG)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(RepiarDemoMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, map.get(RepiarDemoMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(RepiarDemoMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(RepiarDemoMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(RepiarDemoMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(RepiarDemoMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(RepiarDemoMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(RepiarDemoMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(RepiarDemoMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(RepiarDemoMeta.DELETE_BY)));
			this.setId(DataParser.parse(Long.class, map.get(RepiarDemoMeta.ID)));
			this.setUser(DataParser.parse(String.class, map.get(RepiarDemoMeta.USER)));
			this.setStatus(DataParser.parse(String.class, map.get(RepiarDemoMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(RepiarDemoMeta.NOTES));
				this.setOrg( (String)map.get(RepiarDemoMeta.ORG));
				this.setUpdateTime( (Date)map.get(RepiarDemoMeta.UPDATE_TIME));
				this.setTitle( (String)map.get(RepiarDemoMeta.TITLE));
				this.setVersion( (Integer)map.get(RepiarDemoMeta.VERSION));
				this.setContent( (String)map.get(RepiarDemoMeta.CONTENT));
				this.setCreateBy( (String)map.get(RepiarDemoMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(RepiarDemoMeta.DELETED));
				this.setCreateTime( (Date)map.get(RepiarDemoMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(RepiarDemoMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(RepiarDemoMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(RepiarDemoMeta.DELETE_BY));
				this.setId( (Long)map.get(RepiarDemoMeta.ID));
				this.setUser( (String)map.get(RepiarDemoMeta.USER));
				this.setStatus( (String)map.get(RepiarDemoMeta.STATUS));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(RepiarDemoMeta.NOTES)));
			this.setOrg(DataParser.parse(String.class, r.getValue(RepiarDemoMeta.ORG)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(RepiarDemoMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, r.getValue(RepiarDemoMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(RepiarDemoMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(RepiarDemoMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(RepiarDemoMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(RepiarDemoMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(RepiarDemoMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(RepiarDemoMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(RepiarDemoMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(RepiarDemoMeta.DELETE_BY)));
			this.setId(DataParser.parse(Long.class, r.getValue(RepiarDemoMeta.ID)));
			this.setUser(DataParser.parse(String.class, r.getValue(RepiarDemoMeta.USER)));
			this.setStatus(DataParser.parse(String.class, r.getValue(RepiarDemoMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(RepiarDemoMeta.NOTES));
				this.setOrg( (String)r.getValue(RepiarDemoMeta.ORG));
				this.setUpdateTime( (Date)r.getValue(RepiarDemoMeta.UPDATE_TIME));
				this.setTitle( (String)r.getValue(RepiarDemoMeta.TITLE));
				this.setVersion( (Integer)r.getValue(RepiarDemoMeta.VERSION));
				this.setContent( (String)r.getValue(RepiarDemoMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(RepiarDemoMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(RepiarDemoMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(RepiarDemoMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(RepiarDemoMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(RepiarDemoMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(RepiarDemoMeta.DELETE_BY));
				this.setId( (Long)r.getValue(RepiarDemoMeta.ID));
				this.setUser( (String)r.getValue(RepiarDemoMeta.USER));
				this.setStatus( (String)r.getValue(RepiarDemoMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}