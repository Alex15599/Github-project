package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INVENTORY_FEEDBACK;
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
import com.dt.platform.domain.eam.meta.InventoryFeedbackMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 盘点反馈
 * <p>盘点反馈 , 数据表 eam_inventory_feedback 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-08 07:00:15
 * @sign 71301D92B8169B915A602718A4C8607D
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inventory_feedback")
@ApiModel(description = "盘点反馈 ; 盘点反馈 , 数据表 eam_inventory_feedback 的PO类型")
public class InventoryFeedback extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INVENTORY_FEEDBACK.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 盘点：盘点
	*/
	@ApiModelProperty(required = false,value="盘点" , notes = "盘点")
	private String inventoryId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户")
	private String userId;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 照片：照片
	*/
	@ApiModelProperty(required = false,value="照片" , notes = "照片")
	private String pictureId;
	
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
	public InventoryFeedback setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 盘点<br>
	 * 盘点
	 * @return 盘点
	*/
	public String getInventoryId() {
		return inventoryId;
	}
	
	/**
	 * 设置 盘点
	 * @param inventoryId 盘点
	 * @return 当前对象
	*/
	public InventoryFeedback setInventoryId(String inventoryId) {
		this.inventoryId=inventoryId;
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
	public InventoryFeedback setStatus(String status) {
		this.status=status;
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
	public InventoryFeedback setUserId(String userId) {
		this.userId=userId;
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
	public InventoryFeedback setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 照片<br>
	 * 照片
	 * @return 照片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 照片
	 * @param pictureId 照片
	 * @return 当前对象
	*/
	public InventoryFeedback setPictureId(String pictureId) {
		this.pictureId=pictureId;
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
	public InventoryFeedback setNotes(String notes) {
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
	public InventoryFeedback setCreateBy(String createBy) {
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
	public InventoryFeedback setCreateTime(Date createTime) {
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
	public InventoryFeedback setUpdateBy(String updateBy) {
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
	public InventoryFeedback setUpdateTime(Date updateTime) {
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
	public InventoryFeedback setDeleted(Integer deleted) {
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
	public InventoryFeedback setDeleted(Boolean deletedBool) {
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
	public InventoryFeedback setDeleteBy(String deleteBy) {
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
	public InventoryFeedback setDeleteTime(Date deleteTime) {
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
	public InventoryFeedback setVersion(Integer version) {
		this.version=version;
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
	public InventoryFeedback setUser(Employee user) {
		this.user=user;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InventoryFeedback , 转换好的 InventoryFeedback 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InventoryFeedback , 转换好的 PoJo 对象
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
	public InventoryFeedback clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InventoryFeedback duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InventoryFeedbackMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InventoryFeedbackMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPictureId(this.getPictureId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setInventoryId(this.getInventoryId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
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
	public InventoryFeedback clone(boolean deep) {
		return EntityContext.clone(InventoryFeedback.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InventoryFeedback
	 * @param inventoryFeedbackMap 包含实体信息的 Map 对象
	 * @return InventoryFeedback , 转换好的的 InventoryFeedback 对象
	*/
	@Transient
	public static InventoryFeedback createFrom(Map<String,Object> inventoryFeedbackMap) {
		if(inventoryFeedbackMap==null) return null;
		InventoryFeedback po = create();
		EntityContext.copyProperties(po,inventoryFeedbackMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InventoryFeedback
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InventoryFeedback , 转换好的的 InventoryFeedback 对象
	*/
	@Transient
	public static InventoryFeedback createFrom(Object pojo) {
		if(pojo==null) return null;
		InventoryFeedback po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InventoryFeedback，等同于 new
	 * @return InventoryFeedback 对象
	*/
	@Transient
	public static InventoryFeedback create() {
		return new com.dt.platform.domain.eam.meta.InventoryFeedbackMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(InventoryFeedbackMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InventoryFeedbackMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(InventoryFeedbackMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InventoryFeedbackMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(InventoryFeedbackMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InventoryFeedbackMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InventoryFeedbackMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, map.get(InventoryFeedbackMeta.PICTURE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InventoryFeedbackMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InventoryFeedbackMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InventoryFeedbackMeta.DELETE_TIME)));
			this.setInventoryId(DataParser.parse(String.class, map.get(InventoryFeedbackMeta.INVENTORY_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InventoryFeedbackMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(InventoryFeedbackMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(InventoryFeedbackMeta.STATUS)));
			// others
			this.setUser(DataParser.parse(Employee.class, map.get(InventoryFeedbackMeta.USER)));
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(InventoryFeedbackMeta.NOTES));
				this.setUpdateTime( (Date)map.get(InventoryFeedbackMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(InventoryFeedbackMeta.USER_ID));
				this.setVersion( (Integer)map.get(InventoryFeedbackMeta.VERSION));
				this.setContent( (String)map.get(InventoryFeedbackMeta.CONTENT));
				this.setCreateBy( (String)map.get(InventoryFeedbackMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InventoryFeedbackMeta.DELETED));
				this.setPictureId( (String)map.get(InventoryFeedbackMeta.PICTURE_ID));
				this.setCreateTime( (Date)map.get(InventoryFeedbackMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(InventoryFeedbackMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(InventoryFeedbackMeta.DELETE_TIME));
				this.setInventoryId( (String)map.get(InventoryFeedbackMeta.INVENTORY_ID));
				this.setDeleteBy( (String)map.get(InventoryFeedbackMeta.DELETE_BY));
				this.setId( (String)map.get(InventoryFeedbackMeta.ID));
				this.setStatus( (String)map.get(InventoryFeedbackMeta.STATUS));
				// others
				this.setUser( (Employee)map.get(InventoryFeedbackMeta.USER));
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
			this.setNotes(DataParser.parse(String.class, r.getValue(InventoryFeedbackMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InventoryFeedbackMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(InventoryFeedbackMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InventoryFeedbackMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(InventoryFeedbackMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InventoryFeedbackMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InventoryFeedbackMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(InventoryFeedbackMeta.PICTURE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InventoryFeedbackMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InventoryFeedbackMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InventoryFeedbackMeta.DELETE_TIME)));
			this.setInventoryId(DataParser.parse(String.class, r.getValue(InventoryFeedbackMeta.INVENTORY_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InventoryFeedbackMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(InventoryFeedbackMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(InventoryFeedbackMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(InventoryFeedbackMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(InventoryFeedbackMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(InventoryFeedbackMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(InventoryFeedbackMeta.VERSION));
				this.setContent( (String)r.getValue(InventoryFeedbackMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(InventoryFeedbackMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InventoryFeedbackMeta.DELETED));
				this.setPictureId( (String)r.getValue(InventoryFeedbackMeta.PICTURE_ID));
				this.setCreateTime( (Date)r.getValue(InventoryFeedbackMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(InventoryFeedbackMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(InventoryFeedbackMeta.DELETE_TIME));
				this.setInventoryId( (String)r.getValue(InventoryFeedbackMeta.INVENTORY_ID));
				this.setDeleteBy( (String)r.getValue(InventoryFeedbackMeta.DELETE_BY));
				this.setId( (String)r.getValue(InventoryFeedbackMeta.ID));
				this.setStatus( (String)r.getValue(InventoryFeedbackMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}