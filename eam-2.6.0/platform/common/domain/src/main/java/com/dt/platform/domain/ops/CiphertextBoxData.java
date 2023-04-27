package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_CIPHERTEXT_BOX_DATA;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 密文数据
 * <p>密文数据 , 数据表 ops_ciphertext_box_data 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-23 20:34:32
 * @sign C7AEFC0615F0BF8CC26CFD4F5CA8E2CC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_ciphertext_box_data")
@ApiModel(description = "密文数据 ; 密文数据 , 数据表 ops_ciphertext_box_data 的PO类型")
public class CiphertextBoxData extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_CIPHERTEXT_BOX_DATA.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = true,value="来源" , notes = "来源")
	private String sourceId;
	
	/**
	 * 密文箱：密文箱
	*/
	@ApiModelProperty(required = false,value="密文箱" , notes = "密文箱")
	private String boxId;
	
	/**
	 * 密文类型：密文类型
	*/
	@ApiModelProperty(required = false,value="密文类型" , notes = "密文类型")
	private String boxType;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String content;
	
	/**
	 * 加密：加密
	*/
	@ApiModelProperty(required = false,value="加密" , notes = "加密")
	private String plaintext;
	
	/**
	 * 密文：密文
	*/
	@ApiModelProperty(required = false,value="密文" , notes = "密文")
	private String ciphertext;
	
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
	public CiphertextBoxData setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public String getSourceId() {
		return sourceId;
	}
	
	/**
	 * 设置 来源
	 * @param sourceId 来源
	 * @return 当前对象
	*/
	public CiphertextBoxData setSourceId(String sourceId) {
		this.sourceId=sourceId;
		return this;
	}
	
	/**
	 * 获得 密文箱<br>
	 * 密文箱
	 * @return 密文箱
	*/
	public String getBoxId() {
		return boxId;
	}
	
	/**
	 * 设置 密文箱
	 * @param boxId 密文箱
	 * @return 当前对象
	*/
	public CiphertextBoxData setBoxId(String boxId) {
		this.boxId=boxId;
		return this;
	}
	
	/**
	 * 获得 密文类型<br>
	 * 密文类型
	 * @return 密文类型
	*/
	public String getBoxType() {
		return boxType;
	}
	
	/**
	 * 设置 密文类型
	 * @param boxType 密文类型
	 * @return 当前对象
	*/
	public CiphertextBoxData setBoxType(String boxType) {
		this.boxType=boxType;
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
	public CiphertextBoxData setName(String name) {
		this.name=name;
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
	public CiphertextBoxData setContent(String content) {
		this.content=content;
		return this;
	}
	
	/**
	 * 获得 加密<br>
	 * 加密
	 * @return 加密
	*/
	public String getPlaintext() {
		return plaintext;
	}
	
	/**
	 * 设置 加密
	 * @param plaintext 加密
	 * @return 当前对象
	*/
	public CiphertextBoxData setPlaintext(String plaintext) {
		this.plaintext=plaintext;
		return this;
	}
	
	/**
	 * 获得 密文<br>
	 * 密文
	 * @return 密文
	*/
	public String getCiphertext() {
		return ciphertext;
	}
	
	/**
	 * 设置 密文
	 * @param ciphertext 密文
	 * @return 当前对象
	*/
	public CiphertextBoxData setCiphertext(String ciphertext) {
		this.ciphertext=ciphertext;
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
	public CiphertextBoxData setNotes(String notes) {
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
	public CiphertextBoxData setCreateBy(String createBy) {
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
	public CiphertextBoxData setCreateTime(Date createTime) {
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
	public CiphertextBoxData setUpdateBy(String updateBy) {
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
	public CiphertextBoxData setUpdateTime(Date updateTime) {
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
	public CiphertextBoxData setDeleted(Integer deleted) {
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
	public CiphertextBoxData setDeleted(Boolean deletedBool) {
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
	public CiphertextBoxData setDeleteBy(String deleteBy) {
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
	public CiphertextBoxData setDeleteTime(Date deleteTime) {
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
	public CiphertextBoxData setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CiphertextBoxData , 转换好的 CiphertextBoxData 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CiphertextBoxData , 转换好的 PoJo 对象
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
	public CiphertextBoxData clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CiphertextBoxData duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.CiphertextBoxDataMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.CiphertextBoxDataMeta.$$proxy$$();
		inst.setSourceId(this.getSourceId());
		inst.setCiphertext(this.getCiphertext());
		inst.setNotes(this.getNotes());
		inst.setBoxType(this.getBoxType());
		inst.setPlaintext(this.getPlaintext());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setContent(this.getContent());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setBoxId(this.getBoxId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CiphertextBoxData clone(boolean deep) {
		return EntityContext.clone(CiphertextBoxData.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CiphertextBoxData
	 * @param ciphertextBoxDataMap 包含实体信息的 Map 对象
	 * @return CiphertextBoxData , 转换好的的 CiphertextBoxData 对象
	*/
	@Transient
	public static CiphertextBoxData createFrom(Map<String,Object> ciphertextBoxDataMap) {
		if(ciphertextBoxDataMap==null) return null;
		CiphertextBoxData po = create();
		EntityContext.copyProperties(po,ciphertextBoxDataMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CiphertextBoxData
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CiphertextBoxData , 转换好的的 CiphertextBoxData 对象
	*/
	@Transient
	public static CiphertextBoxData createFrom(Object pojo) {
		if(pojo==null) return null;
		CiphertextBoxData po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CiphertextBoxData，等同于 new
	 * @return CiphertextBoxData 对象
	*/
	@Transient
	public static CiphertextBoxData create() {
		return new com.dt.platform.domain.ops.meta.CiphertextBoxDataMeta.$$proxy$$();
	}
}