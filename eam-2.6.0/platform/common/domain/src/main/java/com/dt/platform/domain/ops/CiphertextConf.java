package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_CIPHERTEXT_CONF;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 权限配置
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-19 10:33:43
 * @sign EE37BE31FB05DF29B18FCE15A04CF9BC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_ciphertext_conf")
public class CiphertextConf extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_CIPHERTEXT_CONF.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型")
	private String boxId;
	
	/**
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员")
	private String userId;
	
	/**
	 * 解密权限：解密权限
	*/
	@ApiModelProperty(required = false,value="解密权限" , notes = "解密权限")
	private String decryptionPermStatus;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注")
	private String notes;
	
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
	@ApiModelProperty(required = false,value="是否已删除" , notes = "是否已删除")
	private Integer deleted;
	@Transient
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
	 * 人员：人员
	*/
	@ApiModelProperty(required = false,value="人员" , notes = "人员")
	private Employee user;
	
	/**
	 * 密码箱：密码箱
	*/
	@ApiModelProperty(required = false,value="密码箱" , notes = "密码箱")
	private CiphertextBox box;
	
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
	public CiphertextConf setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getBoxId() {
		return boxId;
	}
	
	/**
	 * 设置 类型
	 * @param boxId 类型
	 * @return 当前对象
	*/
	public CiphertextConf setBoxId(String boxId) {
		this.boxId=boxId;
		return this;
	}
	
	/**
	 * 获得 人员<br>
	 * 人员
	 * @return 人员
	*/
	public String getUserId() {
		return userId;
	}
	
	/**
	 * 设置 人员
	 * @param userId 人员
	 * @return 当前对象
	*/
	public CiphertextConf setUserId(String userId) {
		this.userId=userId;
		return this;
	}
	
	/**
	 * 获得 解密权限<br>
	 * 解密权限
	 * @return 解密权限
	*/
	public String getDecryptionPermStatus() {
		return decryptionPermStatus;
	}
	
	/**
	 * 设置 解密权限
	 * @param decryptionPermStatus 解密权限
	 * @return 当前对象
	*/
	public CiphertextConf setDecryptionPermStatus(String decryptionPermStatus) {
		this.decryptionPermStatus=decryptionPermStatus;
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
	public CiphertextConf setNotes(String notes) {
		this.notes=notes;
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
	public CiphertextConf setCreateTime(Date createTime) {
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
	public CiphertextConf setUpdateBy(String updateBy) {
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
	public CiphertextConf setUpdateTime(Date updateTime) {
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
	public CiphertextConf setDeleted(Integer deleted) {
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
	public CiphertextConf setDeleted(Boolean deletedBool) {
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
	public CiphertextConf setDeleteBy(String deleteBy) {
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
	public CiphertextConf setDeleteTime(Date deleteTime) {
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
	public CiphertextConf setVersion(Integer version) {
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
	public CiphertextConf setUser(Employee user) {
		this.user=user;
		return this;
	}
	
	/**
	 * 获得 密码箱<br>
	 * 密码箱
	 * @return 密码箱
	*/
	public CiphertextBox getBox() {
		return box;
	}
	
	/**
	 * 设置 密码箱
	 * @param box 密码箱
	 * @return 当前对象
	*/
	public CiphertextConf setBox(CiphertextBox box) {
		this.box=box;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CiphertextConf , 转换好的 CiphertextConf 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CiphertextConf , 转换好的 PoJo 对象
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
	public CiphertextConf clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CiphertextConf duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.CiphertextConfMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.CiphertextConfMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDecryptionPermStatus(this.getDecryptionPermStatus());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setId(this.getId());
		inst.setUserId(this.getUserId());
		inst.setVersion(this.getVersion());
		inst.setBoxId(this.getBoxId());
		if(all) {
			inst.setBox(this.getBox());
			inst.setUser(this.getUser());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CiphertextConf clone(boolean deep) {
		return EntityContext.clone(CiphertextConf.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CiphertextConf
	 * @param ciphertextConfMap 包含实体信息的 Map 对象
	 * @return CiphertextConf , 转换好的的 CiphertextConf 对象
	*/
	@Transient
	public static CiphertextConf createFrom(Map<String,Object> ciphertextConfMap) {
		if(ciphertextConfMap==null) return null;
		CiphertextConf po = create();
		EntityContext.copyProperties(po,ciphertextConfMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CiphertextConf
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CiphertextConf , 转换好的的 CiphertextConf 对象
	*/
	@Transient
	public static CiphertextConf createFrom(Object pojo) {
		if(pojo==null) return null;
		CiphertextConf po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CiphertextConf，等同于 new
	 * @return CiphertextConf 对象
	*/
	@Transient
	public static CiphertextConf create() {
		return new com.dt.platform.domain.ops.meta.CiphertextConfMeta.$$proxy$$();
	}
}