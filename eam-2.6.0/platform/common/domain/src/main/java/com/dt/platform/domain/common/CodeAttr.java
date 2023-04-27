package com.dt.platform.domain.common;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.SYS_CODE_ATTR;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import com.dt.platform.constants.enums.common.CodeAttrTypeEnum;
import javax.persistence.Transient;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.reflect.EnumUtil;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 编码属性
 * <p>编码属性 , 数据表 sys_code_attr 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-25 09:57:37
 * @sign 59CA230998EC5706750C67D1FD175A37
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "sys_code_attr")
@ApiModel(description = "编码属性 ; 编码属性 , 数据表 sys_code_attr 的PO类型")
public class CodeAttr extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =SYS_CODE_ATTR.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 编码名称：编码名称
	*/
	@ApiModelProperty(required = false,value="编码名称" , notes = "编码名称")
	private String name;
	
	/**
	 * 编码类型：编码类型
	*/
	@ApiModelProperty(required = false,value="编码类型" , notes = "编码类型")
	private String type;
	@Transient
	private CodeAttrTypeEnum typeEnum;
	
	/**
	 * 占位符：占位符
	*/
	@ApiModelProperty(required = false,value="占位符" , notes = "占位符")
	private String code;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序")
	private Integer sort;
	
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
	@ApiModelProperty(required = false,value="version" , notes = "version")
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
	public CodeAttr setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 编码名称<br>
	 * 编码名称
	 * @return 编码名称
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 编码名称
	 * @param name 编码名称
	 * @return 当前对象
	*/
	public CodeAttr setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 编码类型<br>
	 * 编码类型
	 * @return 编码类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 获得 编码类型 的投影属性<br>
	 * 等价于 getType 方法，获得对应的枚举类型
	 * @return 编码类型
	*/
	@Transient
	public CodeAttrTypeEnum getTypeEnum() {
		if(this.typeEnum==null) {
			this.typeEnum = (CodeAttrTypeEnum) EnumUtil.parseByCode(CodeAttrTypeEnum.values(),type);
		}
		return this.typeEnum ;
	}
	
	/**
	 * 设置 编码类型
	 * @param type 编码类型
	 * @return 当前对象
	*/
	@JsonProperty("type")
	public CodeAttr setType(String type) {
		this.type=type;
		this.typeEnum= (CodeAttrTypeEnum) EnumUtil.parseByCode(CodeAttrTypeEnum.values(),type) ;
		if(StringUtil.hasContent(type) && this.typeEnum==null) {
			throw new IllegalArgumentException( type + " is not one of CodeAttrTypeEnum");
		}
		return this;
	}
	
	/**
	 * 设置 编码类型的投影属性，等同于设置 编码类型
	 * @param typeEnum 编码类型
	 * @return 当前对象
	*/
	@Transient
	public CodeAttr setTypeEnum(CodeAttrTypeEnum typeEnum) {
		if(typeEnum==null) {
			this.setType(null);
		} else {
			this.setType(typeEnum.code());
		}
		this.typeEnum=typeEnum;
		return this;
	}
	
	/**
	 * 获得 占位符<br>
	 * 占位符
	 * @return 占位符
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 占位符
	 * @param code 占位符
	 * @return 当前对象
	*/
	public CodeAttr setCode(String code) {
		this.code=code;
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
	public CodeAttr setSort(Integer sort) {
		this.sort=sort;
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
	public CodeAttr setNotes(String notes) {
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
	public CodeAttr setCreateBy(String createBy) {
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
	public CodeAttr setCreateTime(Date createTime) {
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
	public CodeAttr setUpdateBy(String updateBy) {
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
	public CodeAttr setUpdateTime(Date updateTime) {
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
	public CodeAttr setDeleted(Integer deleted) {
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
	public CodeAttr setDeleted(Boolean deletedBool) {
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
	public CodeAttr setDeleteBy(String deleteBy) {
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
	public CodeAttr setDeleteTime(Date deleteTime) {
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
	public CodeAttr setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CodeAttr , 转换好的 CodeAttr 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CodeAttr , 转换好的 PoJo 对象
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
	public CodeAttr clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CodeAttr duplicate(boolean all) {
		com.dt.platform.domain.common.meta.CodeAttrMeta.$$proxy$$ inst = new com.dt.platform.domain.common.meta.CodeAttrMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CodeAttr clone(boolean deep) {
		return EntityContext.clone(CodeAttr.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CodeAttr
	 * @param codeAttrMap 包含实体信息的 Map 对象
	 * @return CodeAttr , 转换好的的 CodeAttr 对象
	*/
	@Transient
	public static CodeAttr createFrom(Map<String,Object> codeAttrMap) {
		if(codeAttrMap==null) return null;
		CodeAttr po = create();
		EntityContext.copyProperties(po,codeAttrMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CodeAttr
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CodeAttr , 转换好的的 CodeAttr 对象
	*/
	@Transient
	public static CodeAttr createFrom(Object pojo) {
		if(pojo==null) return null;
		CodeAttr po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CodeAttr，等同于 new
	 * @return CodeAttr 对象
	*/
	@Transient
	public static CodeAttr create() {
		return new com.dt.platform.domain.common.meta.CodeAttrMeta.$$proxy$$();
	}
}