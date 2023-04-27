package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_FEEDBACK;
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
import com.dt.platform.domain.eam.meta.FeedbackMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 反馈信息
 * <p>反馈信息 , 数据表 eam_feedback 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-08 06:50:48
 * @sign 0F682586C422ABECBA313C3B91B8A085
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_feedback")
@ApiModel(description = "反馈信息 ; 反馈信息 , 数据表 eam_feedback 的PO类型")
public class Feedback extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_FEEDBACK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 标题：标题
	*/
	@ApiModelProperty(required = false,value="标题" , notes = "标题")
	private String title;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 附件：附件
	*/
	@ApiModelProperty(required = false,value="附件" , notes = "附件")
	private String attach;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
	/**
	 * 制单人：制单人
	*/
	@ApiModelProperty(required = false,value="制单人" , notes = "制单人")
	private String originatorId;
	
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
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户")
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
	public Feedback setId(String id) {
		this.id=id;
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
	public Feedback setTitle(String title) {
		this.title=title;
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
	public Feedback setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 附件<br>
	 * 附件
	 * @return 附件
	*/
	public String getAttach() {
		return attach;
	}
	
	/**
	 * 设置 附件
	 * @param attach 附件
	 * @return 当前对象
	*/
	public Feedback setAttach(String attach) {
		this.attach=attach;
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
	public Feedback setNotes(String notes) {
		this.notes=notes;
		return this;
	}
	
	/**
	 * 获得 制单人<br>
	 * 制单人
	 * @return 制单人
	*/
	public String getOriginatorId() {
		return originatorId;
	}
	
	/**
	 * 设置 制单人
	 * @param originatorId 制单人
	 * @return 当前对象
	*/
	public Feedback setOriginatorId(String originatorId) {
		this.originatorId=originatorId;
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
	public Feedback setCreateBy(String createBy) {
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
	public Feedback setCreateTime(Date createTime) {
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
	public Feedback setUpdateBy(String updateBy) {
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
	public Feedback setUpdateTime(Date updateTime) {
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
	public Feedback setDeleted(Integer deleted) {
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
	public Feedback setDeleted(Boolean deletedBool) {
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
	public Feedback setDeleteBy(String deleteBy) {
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
	public Feedback setDeleteTime(Date deleteTime) {
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
	public Feedback setVersion(Integer version) {
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
	public Feedback setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 用户<br>
	 * 用户
	 * @return 用户
	*/
	public Employee getUser() {
		return user;
	}
	
	/**
	 * 设置 用户
	 * @param user 用户
	 * @return 当前对象
	*/
	public Feedback setUser(Employee user) {
		this.user=user;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return Feedback , 转换好的 Feedback 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return Feedback , 转换好的 PoJo 对象
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
	public Feedback clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public Feedback duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.FeedbackMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.FeedbackMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setTitle(this.getTitle());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setAttach(this.getAttach());
		inst.setOriginatorId(this.getOriginatorId());
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
	public Feedback clone(boolean deep) {
		return EntityContext.clone(Feedback.class,this,deep);
	}

	/**
	 * 将 Map 转换成 Feedback
	 * @param feedbackMap 包含实体信息的 Map 对象
	 * @return Feedback , 转换好的的 Feedback 对象
	*/
	@Transient
	public static Feedback createFrom(Map<String,Object> feedbackMap) {
		if(feedbackMap==null) return null;
		Feedback po = create();
		EntityContext.copyProperties(po,feedbackMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 Feedback
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return Feedback , 转换好的的 Feedback 对象
	*/
	@Transient
	public static Feedback createFrom(Object pojo) {
		if(pojo==null) return null;
		Feedback po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 Feedback，等同于 new
	 * @return Feedback 对象
	*/
	@Transient
	public static Feedback create() {
		return new com.dt.platform.domain.eam.meta.FeedbackMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(FeedbackMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(FeedbackMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, map.get(FeedbackMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(FeedbackMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(FeedbackMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(FeedbackMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(FeedbackMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(FeedbackMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(FeedbackMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(FeedbackMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, map.get(FeedbackMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(FeedbackMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(FeedbackMeta.ID)));
			this.setAttach(DataParser.parse(String.class, map.get(FeedbackMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, map.get(FeedbackMeta.ORIGINATOR_ID)));
			// others
			this.setUser(DataParser.parse(Employee.class, map.get(FeedbackMeta.USER)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(FeedbackMeta.NOTES));
				this.setUpdateTime( (Date)map.get(FeedbackMeta.UPDATE_TIME));
				this.setTitle( (String)map.get(FeedbackMeta.TITLE));
				this.setVersion( (Integer)map.get(FeedbackMeta.VERSION));
				this.setContent( (String)map.get(FeedbackMeta.CONTENT));
				this.setCreateBy( (String)map.get(FeedbackMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(FeedbackMeta.DELETED));
				this.setCreateTime( (Date)map.get(FeedbackMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(FeedbackMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(FeedbackMeta.DELETE_TIME));
				this.setTenantId( (String)map.get(FeedbackMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(FeedbackMeta.DELETE_BY));
				this.setId( (String)map.get(FeedbackMeta.ID));
				this.setAttach( (String)map.get(FeedbackMeta.ATTACH));
				this.setOriginatorId( (String)map.get(FeedbackMeta.ORIGINATOR_ID));
				// others
				this.setUser( (Employee)map.get(FeedbackMeta.USER));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(FeedbackMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(FeedbackMeta.UPDATE_TIME)));
			this.setTitle(DataParser.parse(String.class, r.getValue(FeedbackMeta.TITLE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(FeedbackMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(FeedbackMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(FeedbackMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(FeedbackMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(FeedbackMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(FeedbackMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(FeedbackMeta.DELETE_TIME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(FeedbackMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(FeedbackMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(FeedbackMeta.ID)));
			this.setAttach(DataParser.parse(String.class, r.getValue(FeedbackMeta.ATTACH)));
			this.setOriginatorId(DataParser.parse(String.class, r.getValue(FeedbackMeta.ORIGINATOR_ID)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(FeedbackMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(FeedbackMeta.UPDATE_TIME));
				this.setTitle( (String)r.getValue(FeedbackMeta.TITLE));
				this.setVersion( (Integer)r.getValue(FeedbackMeta.VERSION));
				this.setContent( (String)r.getValue(FeedbackMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(FeedbackMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(FeedbackMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(FeedbackMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(FeedbackMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(FeedbackMeta.DELETE_TIME));
				this.setTenantId( (String)r.getValue(FeedbackMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(FeedbackMeta.DELETE_BY));
				this.setId( (String)r.getValue(FeedbackMeta.ID));
				this.setAttach( (String)r.getValue(FeedbackMeta.ATTACH));
				this.setOriginatorId( (String)r.getValue(FeedbackMeta.ORIGINATOR_ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}