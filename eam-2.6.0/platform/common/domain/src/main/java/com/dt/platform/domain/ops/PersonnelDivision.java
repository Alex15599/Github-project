package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_PERSONNEL_DIVISION;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.ops.meta.PersonnelDivisionMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 人员分工
 * <p>人员分工 , 数据表 ops_personnel_division 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-02-11 20:39:58
 * @sign 0032BADDAD5811889AD0B644278D7AF6
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_personnel_division")
@ApiModel(description = "人员分工 ; 人员分工 , 数据表 ops_personnel_division 的PO类型")
public class PersonnelDivision extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_PERSONNEL_DIVISION.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "674273806814019584")
	private String id;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "enable")
	private String status;
	
	/**
	 * 所属：所属
	*/
	@ApiModelProperty(required = false,value="所属" , notes = "所属" , example = "general")
	private String owner;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户" , example = "571627450430128128")
	private String userId;
	
	/**
	 * 岗位：岗位
	*/
	@ApiModelProperty(required = false,value="岗位" , notes = "岗位" , example = "综合管理")
	private String pos;
	
	/**
	 * 负责内容：负责内容
	*/
	@ApiModelProperty(required = false,value="负责内容" , notes = "负责内容" , example = "1、负责XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX 2、负责XXXXXXXXXXXXXXXXX...")
	private String responsibleContent;
	
	/**
	 * 工作内容：工作内容
	*/
	@ApiModelProperty(required = false,value="工作内容" , notes = "工作内容" , example = "1、负责XX 2、负责XX 3、负责XX 4、负责XxXXX  ")
	private String jobContent;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "121212")
	private String notes;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序" , example = "0")
	private Integer sort;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-02-04 03:23:23")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-02-04 07:12:21")
	private Date updateTime;
	
	/**
	 * 是否已删除：是否已删除
	*/
	@ApiModelProperty(required = false,value="是否已删除" , notes = "是否已删除" , example = "0")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "6")
	private Integer version;
	
	/**
	 * ownerData：ownerData
	*/
	@ApiModelProperty(required = false,value="ownerData" , notes = "ownerData")
	private DictItem ownerData;
	
	/**
	 * user：user
	*/
	@ApiModelProperty(required = false,value="user" , notes = "user")
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
	public PersonnelDivision setId(String id) {
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
	public PersonnelDivision setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 所属<br>
	 * 所属
	 * @return 所属
	*/
	public String getOwner() {
		return owner;
	}
	
	/**
	 * 设置 所属
	 * @param owner 所属
	 * @return 当前对象
	*/
	public PersonnelDivision setOwner(String owner) {
		this.owner=owner;
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
	public PersonnelDivision setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 岗位<br>
	 * 岗位
	 * @return 岗位
	*/
	public String getPos() {
		return pos;
	}
	
	/**
	 * 设置 岗位
	 * @param pos 岗位
	 * @return 当前对象
	*/
	public PersonnelDivision setPos(String pos) {
		this.pos=pos;
		return this;
	}
	
	/**
	 * 获得 负责内容<br>
	 * 负责内容
	 * @return 负责内容
	*/
	public String getResponsibleContent() {
		return responsibleContent;
	}
	
	/**
	 * 设置 负责内容
	 * @param responsibleContent 负责内容
	 * @return 当前对象
	*/
	public PersonnelDivision setResponsibleContent(String responsibleContent) {
		this.responsibleContent=responsibleContent;
		return this;
	}
	
	/**
	 * 获得 工作内容<br>
	 * 工作内容
	 * @return 工作内容
	*/
	public String getJobContent() {
		return jobContent;
	}
	
	/**
	 * 设置 工作内容
	 * @param jobContent 工作内容
	 * @return 当前对象
	*/
	public PersonnelDivision setJobContent(String jobContent) {
		this.jobContent=jobContent;
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
	public PersonnelDivision setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 排序<br>
	 * 排序
	 * @return 排序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 排序
	 * @param sort 排序
	 * @return 当前对象
	*/
	public PersonnelDivision setSort(Integer sort) {
		this.sort=sort;
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
	public PersonnelDivision setCreateBy(String createBy) {
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
	public PersonnelDivision setCreateTime(Date createTime) {
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
	public PersonnelDivision setUpdateBy(String updateBy) {
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
	public PersonnelDivision setUpdateTime(Date updateTime) {
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
	public PersonnelDivision setDeleted(Integer deleted) {
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
	public PersonnelDivision setDeleted(Boolean deletedBool) {
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
	public PersonnelDivision setDeleteBy(String deleteBy) {
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
	public PersonnelDivision setDeleteTime(Date deleteTime) {
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
	public PersonnelDivision setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 ownerData<br>
	 * ownerData
	 * @return ownerData
	*/
	public DictItem getOwnerData() {
		return ownerData;
	}
	
	/**
	 * 设置 ownerData
	 * @param ownerData ownerData
	 * @return 当前对象
	*/
	public PersonnelDivision setOwnerData(DictItem ownerData) {
		this.ownerData=ownerData;
		return this;
	}
	
	/**
	 * 获得 user<br>
	 * user
	 * @return user
	*/
	public Employee getUser() {
		return user;
	}
	
	/**
	 * 设置 user
	 * @param user user
	 * @return 当前对象
	*/
	public PersonnelDivision setUser(Employee user) {
		this.user=user;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return PersonnelDivision , 转换好的 PersonnelDivision 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return PersonnelDivision , 转换好的 PoJo 对象
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
	public PersonnelDivision clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public PersonnelDivision duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.PersonnelDivisionMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.PersonnelDivisionMeta.$$proxy$$();
		inst.setOwner(this.getOwner());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setJobContent(this.getJobContent());
		inst.setSort(this.getSort());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPos(this.getPos());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setResponsibleContent(this.getResponsibleContent());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOwnerData(this.getOwnerData());
			inst.setUser(this.getUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public PersonnelDivision clone(boolean deep) {
		return EntityContext.clone(PersonnelDivision.class,this,deep);
	}

	/**
	 * 将 Map 转换成 PersonnelDivision
	 * @param personnelDivisionMap 包含实体信息的 Map 对象
	 * @return PersonnelDivision , 转换好的的 PersonnelDivision 对象
	*/
	@Transient
	public static PersonnelDivision createFrom(Map<String,Object> personnelDivisionMap) {
		if(personnelDivisionMap==null) return null;
		PersonnelDivision po = create();
		EntityContext.copyProperties(po,personnelDivisionMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 PersonnelDivision
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return PersonnelDivision , 转换好的的 PersonnelDivision 对象
	*/
	@Transient
	public static PersonnelDivision createFrom(Object pojo) {
		if(pojo==null) return null;
		PersonnelDivision po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 PersonnelDivision，等同于 new
	 * @return PersonnelDivision 对象
	*/
	@Transient
	public static PersonnelDivision create() {
		return new com.dt.platform.domain.ops.meta.PersonnelDivisionMeta.$$proxy$$();
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
			this.setOwner(DataParser.parse(String.class, map.get(PersonnelDivisionMeta.OWNER)));
			this.setNotes(DataParser.parse(String.class, map.get(PersonnelDivisionMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(PersonnelDivisionMeta.UPDATE_TIME)));
			this.setJobContent(DataParser.parse(String.class, map.get(PersonnelDivisionMeta.JOB_CONTENT)));
			this.setSort(DataParser.parse(Integer.class, map.get(PersonnelDivisionMeta.SORT)));
			this.setUserId(DataParser.parse(String.class, map.get(PersonnelDivisionMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(PersonnelDivisionMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(PersonnelDivisionMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(PersonnelDivisionMeta.DELETED)));
			this.setPos(DataParser.parse(String.class, map.get(PersonnelDivisionMeta.POS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(PersonnelDivisionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(PersonnelDivisionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(PersonnelDivisionMeta.DELETE_TIME)));
			this.setResponsibleContent(DataParser.parse(String.class, map.get(PersonnelDivisionMeta.RESPONSIBLE_CONTENT)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(PersonnelDivisionMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(PersonnelDivisionMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(PersonnelDivisionMeta.STATUS)));
			// others
			this.setOwnerData(DataParser.parse(DictItem.class, map.get(PersonnelDivisionMeta.OWNER_DATA)));
			this.setUser(DataParser.parse(Employee.class, map.get(PersonnelDivisionMeta.USER)));
			return true;
		} else {
			try {
				this.setOwner( (String)map.get(PersonnelDivisionMeta.OWNER));
				this.setNotes( (String)map.get(PersonnelDivisionMeta.NOTES));
				this.setUpdateTime( (Date)map.get(PersonnelDivisionMeta.UPDATE_TIME));
				this.setJobContent( (String)map.get(PersonnelDivisionMeta.JOB_CONTENT));
				this.setSort( (Integer)map.get(PersonnelDivisionMeta.SORT));
				this.setUserId( (String)map.get(PersonnelDivisionMeta.USER_ID));
				this.setVersion( (Integer)map.get(PersonnelDivisionMeta.VERSION));
				this.setCreateBy( (String)map.get(PersonnelDivisionMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(PersonnelDivisionMeta.DELETED));
				this.setPos( (String)map.get(PersonnelDivisionMeta.POS));
				this.setCreateTime( (Date)map.get(PersonnelDivisionMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(PersonnelDivisionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(PersonnelDivisionMeta.DELETE_TIME));
				this.setResponsibleContent( (String)map.get(PersonnelDivisionMeta.RESPONSIBLE_CONTENT));
				this.setDeleteBy( (String)map.get(PersonnelDivisionMeta.DELETE_BY));
				this.setId( (String)map.get(PersonnelDivisionMeta.ID));
				this.setStatus( (String)map.get(PersonnelDivisionMeta.STATUS));
				// others
				this.setOwnerData( (DictItem)map.get(PersonnelDivisionMeta.OWNER_DATA));
				this.setUser( (Employee)map.get(PersonnelDivisionMeta.USER));
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
			this.setOwner(DataParser.parse(String.class, r.getValue(PersonnelDivisionMeta.OWNER)));
			this.setNotes(DataParser.parse(String.class, r.getValue(PersonnelDivisionMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(PersonnelDivisionMeta.UPDATE_TIME)));
			this.setJobContent(DataParser.parse(String.class, r.getValue(PersonnelDivisionMeta.JOB_CONTENT)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(PersonnelDivisionMeta.SORT)));
			this.setUserId(DataParser.parse(String.class, r.getValue(PersonnelDivisionMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(PersonnelDivisionMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(PersonnelDivisionMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(PersonnelDivisionMeta.DELETED)));
			this.setPos(DataParser.parse(String.class, r.getValue(PersonnelDivisionMeta.POS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(PersonnelDivisionMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(PersonnelDivisionMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(PersonnelDivisionMeta.DELETE_TIME)));
			this.setResponsibleContent(DataParser.parse(String.class, r.getValue(PersonnelDivisionMeta.RESPONSIBLE_CONTENT)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(PersonnelDivisionMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(PersonnelDivisionMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(PersonnelDivisionMeta.STATUS)));
			return true;
		} else {
			try {
				this.setOwner( (String)r.getValue(PersonnelDivisionMeta.OWNER));
				this.setNotes( (String)r.getValue(PersonnelDivisionMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(PersonnelDivisionMeta.UPDATE_TIME));
				this.setJobContent( (String)r.getValue(PersonnelDivisionMeta.JOB_CONTENT));
				this.setSort( (Integer)r.getValue(PersonnelDivisionMeta.SORT));
				this.setUserId( (String)r.getValue(PersonnelDivisionMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(PersonnelDivisionMeta.VERSION));
				this.setCreateBy( (String)r.getValue(PersonnelDivisionMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(PersonnelDivisionMeta.DELETED));
				this.setPos( (String)r.getValue(PersonnelDivisionMeta.POS));
				this.setCreateTime( (Date)r.getValue(PersonnelDivisionMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(PersonnelDivisionMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(PersonnelDivisionMeta.DELETE_TIME));
				this.setResponsibleContent( (String)r.getValue(PersonnelDivisionMeta.RESPONSIBLE_CONTENT));
				this.setDeleteBy( (String)r.getValue(PersonnelDivisionMeta.DELETE_BY));
				this.setId( (String)r.getValue(PersonnelDivisionMeta.ID));
				this.setStatus( (String)r.getValue(PersonnelDivisionMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}