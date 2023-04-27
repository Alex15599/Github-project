package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_SAFETY_BASELINE;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 安全基线
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-16 08:37:37
 * @sign 824F2BD31C423CB18E138E53E2CA7A10
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_safety_baseline")
public class SafetyBaseline extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_SAFETY_BASELINE.$TABLE;
	
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
	private String baseTypeId;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 版本：版本
	*/
	@ApiModelProperty(required = false,value="版本" , notes = "版本")
	private String baseVersion;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 使用场景：使用场景
	*/
	@ApiModelProperty(required = false,value="使用场景" , notes = "使用场景")
	private String usageScenarios;
	
	/**
	 * 基线文件：基线文件
	*/
	@ApiModelProperty(required = false,value="基线文件" , notes = "基线文件")
	private String fileId;
	
	/**
	 * 检查文件：检查文件
	*/
	@ApiModelProperty(required = false,value="检查文件" , notes = "检查文件")
	private String checkFileId;
	
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
	@ApiModelProperty(required = true,value="version" , notes = "version")
	private Integer version;
	
	/**
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * baseType：baseType
	*/
	@ApiModelProperty(required = false,value="baseType" , notes = "baseType")
	private List<SoftwareBaseType> baseType;
	
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
	public SafetyBaseline setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
	 * @return 类型
	*/
	public String getBaseTypeId() {
		return baseTypeId;
	}
	
	/**
	 * 设置 类型
	 * @param baseTypeId 类型
	 * @return 当前对象
	*/
	public SafetyBaseline setBaseTypeId(String baseTypeId) {
		this.baseTypeId=baseTypeId;
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
	public SafetyBaseline setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 版本<br>
	 * 版本
	 * @return 版本
	*/
	public String getBaseVersion() {
		return baseVersion;
	}
	
	/**
	 * 设置 版本
	 * @param baseVersion 版本
	 * @return 当前对象
	*/
	public SafetyBaseline setBaseVersion(String baseVersion) {
		this.baseVersion=baseVersion;
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
	public SafetyBaseline setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 使用场景<br>
	 * 使用场景
	 * @return 使用场景
	*/
	public String getUsageScenarios() {
		return usageScenarios;
	}
	
	/**
	 * 设置 使用场景
	 * @param usageScenarios 使用场景
	 * @return 当前对象
	*/
	public SafetyBaseline setUsageScenarios(String usageScenarios) {
		this.usageScenarios=usageScenarios;
		return this;
	}
	
	/**
	 * 获得 基线文件<br>
	 * 基线文件
	 * @return 基线文件
	*/
	public String getFileId() {
		return fileId;
	}
	
	/**
	 * 设置 基线文件
	 * @param fileId 基线文件
	 * @return 当前对象
	*/
	public SafetyBaseline setFileId(String fileId) {
		this.fileId=fileId;
		return this;
	}
	
	/**
	 * 获得 检查文件<br>
	 * 检查文件
	 * @return 检查文件
	*/
	public String getCheckFileId() {
		return checkFileId;
	}
	
	/**
	 * 设置 检查文件
	 * @param checkFileId 检查文件
	 * @return 当前对象
	*/
	public SafetyBaseline setCheckFileId(String checkFileId) {
		this.checkFileId=checkFileId;
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
	public SafetyBaseline setNotes(String notes) {
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
	public SafetyBaseline setCreateBy(String createBy) {
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
	public SafetyBaseline setCreateTime(Date createTime) {
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
	public SafetyBaseline setUpdateBy(String updateBy) {
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
	public SafetyBaseline setUpdateTime(Date updateTime) {
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
	public SafetyBaseline setDeleted(Integer deleted) {
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
	public SafetyBaseline setDeleted(Boolean deletedBool) {
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
	public SafetyBaseline setDeleteBy(String deleteBy) {
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
	public SafetyBaseline setDeleteTime(Date deleteTime) {
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
	public SafetyBaseline setVersion(Integer version) {
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
	public SafetyBaseline setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 baseType<br>
	 * baseType
	 * @return baseType
	*/
	public List<SoftwareBaseType> getBaseType() {
		return baseType;
	}
	
	/**
	 * 设置 baseType
	 * @param baseType baseType
	 * @return 当前对象
	*/
	public SafetyBaseline setBaseType(List<SoftwareBaseType> baseType) {
		this.baseType=baseType;
		return this;
	}
	
	/**
	 * 添加 baseType
	 * @param entity baseType
	 * @return 当前对象
	*/
	public SafetyBaseline addBaseType(SoftwareBaseType... entity) {
		if(this.baseType==null) baseType=new ArrayList<>();
		this.baseType.addAll(Arrays.asList(entity));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return SafetyBaseline , 转换好的 SafetyBaseline 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return SafetyBaseline , 转换好的 PoJo 对象
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
	public SafetyBaseline clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public SafetyBaseline duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.SafetyBaselineMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.SafetyBaselineMeta.$$proxy$$();
		inst.setUsageScenarios(this.getUsageScenarios());
		inst.setNotes(this.getNotes());
		inst.setBaseVersion(this.getBaseVersion());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setBaseTypeId(this.getBaseTypeId());
		inst.setId(this.getId());
		inst.setCheckFileId(this.getCheckFileId());
		inst.setStatus(this.getStatus());
		inst.setFileId(this.getFileId());
		if(all) {
			inst.setBaseType(this.getBaseType());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public SafetyBaseline clone(boolean deep) {
		return EntityContext.clone(SafetyBaseline.class,this,deep);
	}

	/**
	 * 将 Map 转换成 SafetyBaseline
	 * @param safetyBaselineMap 包含实体信息的 Map 对象
	 * @return SafetyBaseline , 转换好的的 SafetyBaseline 对象
	*/
	@Transient
	public static SafetyBaseline createFrom(Map<String,Object> safetyBaselineMap) {
		if(safetyBaselineMap==null) return null;
		SafetyBaseline po = create();
		EntityContext.copyProperties(po,safetyBaselineMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 SafetyBaseline
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return SafetyBaseline , 转换好的的 SafetyBaseline 对象
	*/
	@Transient
	public static SafetyBaseline createFrom(Object pojo) {
		if(pojo==null) return null;
		SafetyBaseline po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 SafetyBaseline，等同于 new
	 * @return SafetyBaseline 对象
	*/
	@Transient
	public static SafetyBaseline create() {
		return new com.dt.platform.domain.ops.meta.SafetyBaselineMeta.$$proxy$$();
	}
}