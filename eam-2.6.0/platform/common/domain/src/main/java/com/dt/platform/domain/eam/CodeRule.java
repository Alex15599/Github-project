package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_CODE_RULE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 编码字段
 * <p>编码字段 , 数据表 eam_code_rule 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-27 07:35:50
 * @sign 0E67117644020810D0FAC4321DF74D9A
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_code_rule")
@ApiModel(description = "编码字段 ; 编码字段 , 数据表 eam_code_rule 的PO类型")
public class CodeRule extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_CODE_RULE.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "T001")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "资产编码")
	private String name;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码" , example = "${time,yyyy}${time,hh}${time,ss}${number_seq,5,asset}")
	private String value;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码")
	private String sysValue;
	
	/**
	 * 组成：组成
	*/
	@ApiModelProperty(required = false,value="组成" , notes = "组成" , example = "[\"1\",\"4\",\"6\",\"7\"]")
	private String partIds;
	
	/**
	 * 分割符：分割符
	*/
	@ApiModelProperty(required = false,value="分割符" , notes = "分割符" , example = "-")
	private String codeSeparator;
	
	/**
	 * 随机数位数：随机数位数
	*/
	@ApiModelProperty(required = false,value="随机数位数" , notes = "随机数位数" , example = "5")
	private Integer numberSeq;
	
	/**
	 * 序列类型：序列类型
	*/
	@ApiModelProperty(required = false,value="序列类型" , notes = "序列类型" , example = "unique")
	private String numberSeqType;
	
	/**
	 * 固定字符串：固定字符串
	*/
	@ApiModelProperty(required = false,value="固定字符串" , notes = "固定字符串" , example = "AS")
	private String fs1;
	
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
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2022-10-26 12:37:04")
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
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "33")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
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
	public CodeRule setId(String id) {
		this.id=id;
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
	public CodeRule setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getValue() {
		return value;
	}
	
	/**
	 * 设置 编码
	 * @param value 编码
	 * @return 当前对象
	*/
	public CodeRule setValue(String value) {
		this.value=value;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getSysValue() {
		return sysValue;
	}
	
	/**
	 * 设置 编码
	 * @param sysValue 编码
	 * @return 当前对象
	*/
	public CodeRule setSysValue(String sysValue) {
		this.sysValue=sysValue;
		return this;
	}
	
	/**
	 * 获得 组成<br>
	 * 组成
	 * @return 组成
	*/
	public String getPartIds() {
		return partIds;
	}
	
	/**
	 * 设置 组成
	 * @param partIds 组成
	 * @return 当前对象
	*/
	public CodeRule setPartIds(String partIds) {
		this.partIds=partIds;
		return this;
	}
	
	/**
	 * 获得 分割符<br>
	 * 分割符
	 * @return 分割符
	*/
	public String getCodeSeparator() {
		return codeSeparator;
	}
	
	/**
	 * 设置 分割符
	 * @param codeSeparator 分割符
	 * @return 当前对象
	*/
	public CodeRule setCodeSeparator(String codeSeparator) {
		this.codeSeparator=codeSeparator;
		return this;
	}
	
	/**
	 * 获得 随机数位数<br>
	 * 随机数位数
	 * @return 随机数位数
	*/
	public Integer getNumberSeq() {
		return numberSeq;
	}
	
	/**
	 * 设置 随机数位数
	 * @param numberSeq 随机数位数
	 * @return 当前对象
	*/
	public CodeRule setNumberSeq(Integer numberSeq) {
		this.numberSeq=numberSeq;
		return this;
	}
	
	/**
	 * 获得 序列类型<br>
	 * 序列类型
	 * @return 序列类型
	*/
	public String getNumberSeqType() {
		return numberSeqType;
	}
	
	/**
	 * 设置 序列类型
	 * @param numberSeqType 序列类型
	 * @return 当前对象
	*/
	public CodeRule setNumberSeqType(String numberSeqType) {
		this.numberSeqType=numberSeqType;
		return this;
	}
	
	/**
	 * 获得 固定字符串<br>
	 * 固定字符串
	 * @return 固定字符串
	*/
	public String getFs1() {
		return fs1;
	}
	
	/**
	 * 设置 固定字符串
	 * @param fs1 固定字符串
	 * @return 当前对象
	*/
	public CodeRule setFs1(String fs1) {
		this.fs1=fs1;
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
	public CodeRule setCreateBy(String createBy) {
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
	public CodeRule setCreateTime(Date createTime) {
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
	public CodeRule setUpdateBy(String updateBy) {
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
	public CodeRule setUpdateTime(Date updateTime) {
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
	public CodeRule setDeleted(Integer deleted) {
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
	public CodeRule setDeleted(Boolean deletedBool) {
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
	public CodeRule setDeleteBy(String deleteBy) {
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
	public CodeRule setDeleteTime(Date deleteTime) {
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
	public CodeRule setVersion(Integer version) {
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
	public CodeRule setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CodeRule , 转换好的 CodeRule 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CodeRule , 转换好的 PoJo 对象
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
	public CodeRule clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CodeRule duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CodeRuleMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CodeRuleMeta.$$proxy$$();
		inst.setNumberSeq(this.getNumberSeq());
		inst.setSysValue(this.getSysValue());
		inst.setCodeSeparator(this.getCodeSeparator());
		inst.setFs1(this.getFs1());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setNumberSeqType(this.getNumberSeqType());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setPartIds(this.getPartIds());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setValue(this.getValue());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CodeRule clone(boolean deep) {
		return EntityContext.clone(CodeRule.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CodeRule
	 * @param codeRuleMap 包含实体信息的 Map 对象
	 * @return CodeRule , 转换好的的 CodeRule 对象
	*/
	@Transient
	public static CodeRule createFrom(Map<String,Object> codeRuleMap) {
		if(codeRuleMap==null) return null;
		CodeRule po = create();
		EntityContext.copyProperties(po,codeRuleMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CodeRule
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CodeRule , 转换好的的 CodeRule 对象
	*/
	@Transient
	public static CodeRule createFrom(Object pojo) {
		if(pojo==null) return null;
		CodeRule po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CodeRule，等同于 new
	 * @return CodeRule 对象
	*/
	@Transient
	public static CodeRule create() {
		return new com.dt.platform.domain.eam.meta.CodeRuleMeta.$$proxy$$();
	}
}