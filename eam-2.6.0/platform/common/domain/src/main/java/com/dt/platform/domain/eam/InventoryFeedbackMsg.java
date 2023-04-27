package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INVENTORY_FEEDBACK_MSG;
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
import com.dt.platform.domain.eam.meta.InventoryFeedbackMsgMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 反馈消息
 * <p>反馈消息 , 数据表 eam_inventory_feedback_msg 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-08 06:57:04
 * @sign CA5335BE6E988963A3737F6ECD3FFBA4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inventory_feedback_msg")
@ApiModel(description = "反馈消息 ; 反馈消息 , 数据表 eam_inventory_feedback_msg 的PO类型")
public class InventoryFeedbackMsg extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INVENTORY_FEEDBACK_MSG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 反馈：反馈
	*/
	@ApiModelProperty(required = false,value="反馈" , notes = "反馈")
	private String feedbackId;
	
	/**
	 * 用户：用户
	*/
	@ApiModelProperty(required = false,value="用户" , notes = "用户")
	private String userId;
	
	/**
	 * 时间：时间
	*/
	@ApiModelProperty(required = false,value="时间" , notes = "时间")
	private Date recordTime;
	
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
	public InventoryFeedbackMsg setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 反馈<br>
	 * 反馈
	 * @return 反馈
	*/
	public String getFeedbackId() {
		return feedbackId;
	}
	
	/**
	 * 设置 反馈
	 * @param feedbackId 反馈
	 * @return 当前对象
	*/
	public InventoryFeedbackMsg setFeedbackId(String feedbackId) {
		this.feedbackId=feedbackId;
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
	public InventoryFeedbackMsg setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 时间<br>
	 * 时间
	 * @return 时间
	*/
	public Date getRecordTime() {
		return recordTime;
	}
	
	/**
	 * 设置 时间
	 * @param recordTime 时间
	 * @return 当前对象
	*/
	public InventoryFeedbackMsg setRecordTime(Date recordTime) {
		this.recordTime=recordTime;
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
	public InventoryFeedbackMsg setContent(String content) {
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
	public InventoryFeedbackMsg setPictureId(String pictureId) {
		this.pictureId=pictureId;
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
	public InventoryFeedbackMsg setCreateBy(String createBy) {
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
	public InventoryFeedbackMsg setCreateTime(Date createTime) {
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
	public InventoryFeedbackMsg setUpdateBy(String updateBy) {
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
	public InventoryFeedbackMsg setUpdateTime(Date updateTime) {
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
	public InventoryFeedbackMsg setDeleted(Integer deleted) {
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
	public InventoryFeedbackMsg setDeleted(Boolean deletedBool) {
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
	public InventoryFeedbackMsg setDeleteBy(String deleteBy) {
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
	public InventoryFeedbackMsg setDeleteTime(Date deleteTime) {
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
	public InventoryFeedbackMsg setVersion(Integer version) {
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
	public InventoryFeedbackMsg setUser(Employee user) {
		this.user=user;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InventoryFeedbackMsg , 转换好的 InventoryFeedbackMsg 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InventoryFeedbackMsg , 转换好的 PoJo 对象
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
	public InventoryFeedbackMsg clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InventoryFeedbackMsg duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InventoryFeedbackMsgMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InventoryFeedbackMsgMeta.$$proxy$$();
		inst.setFeedbackId(this.getFeedbackId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setRecordTime(this.getRecordTime());
		inst.setDeleted(this.getDeleted());
		inst.setPictureId(this.getPictureId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
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
	public InventoryFeedbackMsg clone(boolean deep) {
		return EntityContext.clone(InventoryFeedbackMsg.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InventoryFeedbackMsg
	 * @param inventoryFeedbackMsgMap 包含实体信息的 Map 对象
	 * @return InventoryFeedbackMsg , 转换好的的 InventoryFeedbackMsg 对象
	*/
	@Transient
	public static InventoryFeedbackMsg createFrom(Map<String,Object> inventoryFeedbackMsgMap) {
		if(inventoryFeedbackMsgMap==null) return null;
		InventoryFeedbackMsg po = create();
		EntityContext.copyProperties(po,inventoryFeedbackMsgMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InventoryFeedbackMsg
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InventoryFeedbackMsg , 转换好的的 InventoryFeedbackMsg 对象
	*/
	@Transient
	public static InventoryFeedbackMsg createFrom(Object pojo) {
		if(pojo==null) return null;
		InventoryFeedbackMsg po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InventoryFeedbackMsg，等同于 new
	 * @return InventoryFeedbackMsg 对象
	*/
	@Transient
	public static InventoryFeedbackMsg create() {
		return new com.dt.platform.domain.eam.meta.InventoryFeedbackMsgMeta.$$proxy$$();
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
			this.setFeedbackId(DataParser.parse(String.class, map.get(InventoryFeedbackMsgMeta.FEEDBACK_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InventoryFeedbackMsgMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, map.get(InventoryFeedbackMsgMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InventoryFeedbackMsgMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, map.get(InventoryFeedbackMsgMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InventoryFeedbackMsgMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, map.get(InventoryFeedbackMsgMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InventoryFeedbackMsgMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, map.get(InventoryFeedbackMsgMeta.PICTURE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InventoryFeedbackMsgMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InventoryFeedbackMsgMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InventoryFeedbackMsgMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InventoryFeedbackMsgMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(InventoryFeedbackMsgMeta.ID)));
			// others
			this.setUser(DataParser.parse(Employee.class, map.get(InventoryFeedbackMsgMeta.USER)));
			return true;
		} else {
			try {
				this.setFeedbackId( (String)map.get(InventoryFeedbackMsgMeta.FEEDBACK_ID));
				this.setUpdateTime( (Date)map.get(InventoryFeedbackMsgMeta.UPDATE_TIME));
				this.setUserId( (String)map.get(InventoryFeedbackMsgMeta.USER_ID));
				this.setVersion( (Integer)map.get(InventoryFeedbackMsgMeta.VERSION));
				this.setContent( (String)map.get(InventoryFeedbackMsgMeta.CONTENT));
				this.setCreateBy( (String)map.get(InventoryFeedbackMsgMeta.CREATE_BY));
				this.setRecordTime( (Date)map.get(InventoryFeedbackMsgMeta.RECORD_TIME));
				this.setDeleted( (Integer)map.get(InventoryFeedbackMsgMeta.DELETED));
				this.setPictureId( (String)map.get(InventoryFeedbackMsgMeta.PICTURE_ID));
				this.setCreateTime( (Date)map.get(InventoryFeedbackMsgMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(InventoryFeedbackMsgMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(InventoryFeedbackMsgMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(InventoryFeedbackMsgMeta.DELETE_BY));
				this.setId( (String)map.get(InventoryFeedbackMsgMeta.ID));
				// others
				this.setUser( (Employee)map.get(InventoryFeedbackMsgMeta.USER));
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
			this.setFeedbackId(DataParser.parse(String.class, r.getValue(InventoryFeedbackMsgMeta.FEEDBACK_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InventoryFeedbackMsgMeta.UPDATE_TIME)));
			this.setUserId(DataParser.parse(String.class, r.getValue(InventoryFeedbackMsgMeta.USER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InventoryFeedbackMsgMeta.VERSION)));
			this.setContent(DataParser.parse(String.class, r.getValue(InventoryFeedbackMsgMeta.CONTENT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InventoryFeedbackMsgMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, r.getValue(InventoryFeedbackMsgMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InventoryFeedbackMsgMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(InventoryFeedbackMsgMeta.PICTURE_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InventoryFeedbackMsgMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InventoryFeedbackMsgMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InventoryFeedbackMsgMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InventoryFeedbackMsgMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(InventoryFeedbackMsgMeta.ID)));
			return true;
		} else {
			try {
				this.setFeedbackId( (String)r.getValue(InventoryFeedbackMsgMeta.FEEDBACK_ID));
				this.setUpdateTime( (Date)r.getValue(InventoryFeedbackMsgMeta.UPDATE_TIME));
				this.setUserId( (String)r.getValue(InventoryFeedbackMsgMeta.USER_ID));
				this.setVersion( (Integer)r.getValue(InventoryFeedbackMsgMeta.VERSION));
				this.setContent( (String)r.getValue(InventoryFeedbackMsgMeta.CONTENT));
				this.setCreateBy( (String)r.getValue(InventoryFeedbackMsgMeta.CREATE_BY));
				this.setRecordTime( (Date)r.getValue(InventoryFeedbackMsgMeta.RECORD_TIME));
				this.setDeleted( (Integer)r.getValue(InventoryFeedbackMsgMeta.DELETED));
				this.setPictureId( (String)r.getValue(InventoryFeedbackMsgMeta.PICTURE_ID));
				this.setCreateTime( (Date)r.getValue(InventoryFeedbackMsgMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(InventoryFeedbackMsgMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(InventoryFeedbackMsgMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(InventoryFeedbackMsgMeta.DELETE_BY));
				this.setId( (String)r.getValue(InventoryFeedbackMsgMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}