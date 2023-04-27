package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_C_CUST_REPIAR_ITEM;
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
import com.dt.platform.domain.eam.meta.CCustRepiarItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 内容
 * <p>内容 , 数据表 eam_c_cust_repiar_item 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-01 22:26:48
 * @sign D6945F97758D38B485ED76200DF970A2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_c_cust_repiar_item")
@ApiModel(description = "内容 ; 内容 , 数据表 eam_c_cust_repiar_item 的PO类型")
public class CCustRepiarItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_C_CUST_REPIAR_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "694644264046428160")
	private String id;
	
	/**
	 * 报修：报修
	*/
	@ApiModelProperty(required = false,value="报修" , notes = "报修" , example = "694583157466333184")
	private String repairId;
	
	/**
	 * 处理人：处理人
	*/
	@ApiModelProperty(required = false,value="处理人" , notes = "处理人" , example = "E001")
	private String processUserId;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容" , example = "开始处理")
	private String ct;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间" , example = "2023-04-01 08:28:18")
	private Date recordTime;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-04-01 08:28:18")
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
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "1")
	private Integer version;
	
	/**
	 * 处理人：制单人
	*/
	@ApiModelProperty(required = false,value="处理人" , notes = "制单人")
	private Employee processUser;
	
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
	public CCustRepiarItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 报修<br>
	 * 报修
	 * @return 报修
	*/
	public String getRepairId() {
		return repairId;
	}
	
	/**
	 * 设置 报修
	 * @param repairId 报修
	 * @return 当前对象
	*/
	public CCustRepiarItem setRepairId(String repairId) {
		this.repairId=repairId;
		return this;
	}
	
	/**
	 * 获得 处理人<br>
	 * 处理人
	 * @return 处理人
	*/
	public String getProcessUserId() {
		return processUserId;
	}
	
	/**
	 * 设置 处理人
	 * @param processUserId 处理人
	 * @return 当前对象
	*/
	public CCustRepiarItem setProcessUserId(String processUserId) {
		this.processUserId=processUserId;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getCt() {
		return ct;
	}
	
	/**
	 * 设置 内容
	 * @param ct 内容
	 * @return 当前对象
	*/
	public CCustRepiarItem setCt(String ct) {
		this.ct=ct;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRecordTime() {
		return recordTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param recordTime 记录时间
	 * @return 当前对象
	*/
	public CCustRepiarItem setRecordTime(Date recordTime) {
		this.recordTime=recordTime;
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
	public CCustRepiarItem setCreateBy(String createBy) {
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
	public CCustRepiarItem setCreateTime(Date createTime) {
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
	public CCustRepiarItem setUpdateBy(String updateBy) {
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
	public CCustRepiarItem setUpdateTime(Date updateTime) {
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
	public CCustRepiarItem setDeleted(Integer deleted) {
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
	public CCustRepiarItem setDeleted(Boolean deletedBool) {
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
	public CCustRepiarItem setDeleteBy(String deleteBy) {
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
	public CCustRepiarItem setDeleteTime(Date deleteTime) {
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
	public CCustRepiarItem setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 处理人<br>
	 * 制单人
	 * @return 处理人
	*/
	public Employee getProcessUser() {
		return processUser;
	}
	
	/**
	 * 设置 处理人
	 * @param processUser 处理人
	 * @return 当前对象
	*/
	public CCustRepiarItem setProcessUser(Employee processUser) {
		this.processUser=processUser;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CCustRepiarItem , 转换好的 CCustRepiarItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CCustRepiarItem , 转换好的 PoJo 对象
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
	public CCustRepiarItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CCustRepiarItem duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CCustRepiarItemMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CCustRepiarItemMeta.$$proxy$$();
		inst.setRepairId(this.getRepairId());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCt(this.getCt());
		inst.setCreateBy(this.getCreateBy());
		inst.setRecordTime(this.getRecordTime());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setProcessUserId(this.getProcessUserId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		if(all) {
			inst.setProcessUser(this.getProcessUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CCustRepiarItem clone(boolean deep) {
		return EntityContext.clone(CCustRepiarItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CCustRepiarItem
	 * @param cCustRepiarItemMap 包含实体信息的 Map 对象
	 * @return CCustRepiarItem , 转换好的的 CCustRepiarItem 对象
	*/
	@Transient
	public static CCustRepiarItem createFrom(Map<String,Object> cCustRepiarItemMap) {
		if(cCustRepiarItemMap==null) return null;
		CCustRepiarItem po = create();
		EntityContext.copyProperties(po,cCustRepiarItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CCustRepiarItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CCustRepiarItem , 转换好的的 CCustRepiarItem 对象
	*/
	@Transient
	public static CCustRepiarItem createFrom(Object pojo) {
		if(pojo==null) return null;
		CCustRepiarItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CCustRepiarItem，等同于 new
	 * @return CCustRepiarItem 对象
	*/
	@Transient
	public static CCustRepiarItem create() {
		return new com.dt.platform.domain.eam.meta.CCustRepiarItemMeta.$$proxy$$();
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
			this.setRepairId(DataParser.parse(String.class, map.get(CCustRepiarItemMeta.REPAIR_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CCustRepiarItemMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CCustRepiarItemMeta.VERSION)));
			this.setCt(DataParser.parse(String.class, map.get(CCustRepiarItemMeta.CT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CCustRepiarItemMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, map.get(CCustRepiarItemMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CCustRepiarItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CCustRepiarItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CCustRepiarItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CCustRepiarItemMeta.DELETE_TIME)));
			this.setProcessUserId(DataParser.parse(String.class, map.get(CCustRepiarItemMeta.PROCESS_USER_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CCustRepiarItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CCustRepiarItemMeta.ID)));
			// others
			this.setProcessUser(DataParser.parse(Employee.class, map.get(CCustRepiarItemMeta.PROCESS_USER)));
			return true;
		} else {
			try {
				this.setRepairId( (String)map.get(CCustRepiarItemMeta.REPAIR_ID));
				this.setUpdateTime( (Date)map.get(CCustRepiarItemMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(CCustRepiarItemMeta.VERSION));
				this.setCt( (String)map.get(CCustRepiarItemMeta.CT));
				this.setCreateBy( (String)map.get(CCustRepiarItemMeta.CREATE_BY));
				this.setRecordTime( (Date)map.get(CCustRepiarItemMeta.RECORD_TIME));
				this.setDeleted( (Integer)map.get(CCustRepiarItemMeta.DELETED));
				this.setCreateTime( (Date)map.get(CCustRepiarItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CCustRepiarItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CCustRepiarItemMeta.DELETE_TIME));
				this.setProcessUserId( (String)map.get(CCustRepiarItemMeta.PROCESS_USER_ID));
				this.setDeleteBy( (String)map.get(CCustRepiarItemMeta.DELETE_BY));
				this.setId( (String)map.get(CCustRepiarItemMeta.ID));
				// others
				this.setProcessUser( (Employee)map.get(CCustRepiarItemMeta.PROCESS_USER));
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
			this.setRepairId(DataParser.parse(String.class, r.getValue(CCustRepiarItemMeta.REPAIR_ID)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CCustRepiarItemMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CCustRepiarItemMeta.VERSION)));
			this.setCt(DataParser.parse(String.class, r.getValue(CCustRepiarItemMeta.CT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CCustRepiarItemMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, r.getValue(CCustRepiarItemMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CCustRepiarItemMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CCustRepiarItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CCustRepiarItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CCustRepiarItemMeta.DELETE_TIME)));
			this.setProcessUserId(DataParser.parse(String.class, r.getValue(CCustRepiarItemMeta.PROCESS_USER_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CCustRepiarItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CCustRepiarItemMeta.ID)));
			return true;
		} else {
			try {
				this.setRepairId( (String)r.getValue(CCustRepiarItemMeta.REPAIR_ID));
				this.setUpdateTime( (Date)r.getValue(CCustRepiarItemMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(CCustRepiarItemMeta.VERSION));
				this.setCt( (String)r.getValue(CCustRepiarItemMeta.CT));
				this.setCreateBy( (String)r.getValue(CCustRepiarItemMeta.CREATE_BY));
				this.setRecordTime( (Date)r.getValue(CCustRepiarItemMeta.RECORD_TIME));
				this.setDeleted( (Integer)r.getValue(CCustRepiarItemMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CCustRepiarItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CCustRepiarItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CCustRepiarItemMeta.DELETE_TIME));
				this.setProcessUserId( (String)r.getValue(CCustRepiarItemMeta.PROCESS_USER_ID));
				this.setDeleteBy( (String)r.getValue(CCustRepiarItemMeta.DELETE_BY));
				this.setId( (String)r.getValue(CCustRepiarItemMeta.ID));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}