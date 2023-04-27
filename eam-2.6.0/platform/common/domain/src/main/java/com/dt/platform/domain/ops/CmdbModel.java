package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_CMDB_MODEL;
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
 * 配置库
 * <p>配置库 , 数据表 ops_cmdb_model 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-24 13:07:17
 * @sign CFCB8B84E804BE1F2EE157007D5268AE
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_cmdb_model")
@ApiModel(description = "配置库 ; 配置库 , 数据表 ops_cmdb_model 的PO类型")
public class CmdbModel extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_CMDB_MODEL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 父节点：父节点
	*/
	@ApiModelProperty(required = false,value="父节点" , notes = "父节点")
	private String parentId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态")
	private String status;
	
	/**
	 * 节点路径：节点路径
	*/
	@ApiModelProperty(required = false,value="节点路径" , notes = "节点路径")
	private String hierarchy;
	
	/**
	 * 节点路径名称：节点路径名称
	*/
	@ApiModelProperty(required = false,value="节点路径名称" , notes = "节点路径名称")
	private String hierarchyName;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
	/**
	 * 全称：全称
	*/
	@ApiModelProperty(required = false,value="全称" , notes = "全称")
	private String fullName;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码")
	private String code;
	
	/**
	 * 模型类型：模型类型
	*/
	@ApiModelProperty(required = false,value="模型类型" , notes = "模型类型")
	private String modelType;
	
	/**
	 * 数据来源：数据来源
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "数据来源")
	private String sourceType;
	
	/**
	 * 来源：来源
	*/
	@ApiModelProperty(required = false,value="来源" , notes = "来源")
	private String source;
	
	/**
	 * 来源方式：来源方式
	*/
	@ApiModelProperty(required = false,value="来源方式" , notes = "来源方式")
	private String dataSource;
	
	/**
	 * 存储方式：存储方式
	*/
	@ApiModelProperty(required = false,value="存储方式" , notes = "存储方式")
	private String storageType;
	
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户")
	private String tenantId;
	
	/**
	 * cmdbObjAttributeList：cmdbObjAttribute
	*/
	@ApiModelProperty(required = false,value="cmdbObjAttributeList" , notes = "cmdbObjAttribute")
	private List<CmdbObjAttribute> cmdbObjAttributeList;
	
	/**
	 * cmdbModelVList：cmdbModelVList
	*/
	@ApiModelProperty(required = false,value="cmdbModelVList" , notes = "cmdbModelVList")
	private List<CmdbModelV> cmdbModelVList;
	
	/**
	 * cmdbObjAttributeParentList：cmdbObjAttributeParentList
	*/
	@ApiModelProperty(required = false,value="cmdbObjAttributeParentList" , notes = "cmdbObjAttributeParentList")
	private List<CmdbObjAttribute> cmdbObjAttributeParentList;
	
	/**
	 * cmdbModelParent：cmdbModelParent
	*/
	@ApiModelProperty(required = false,value="cmdbModelParent" , notes = "cmdbModelParent")
	private CmdbModel cmdbModelParent;
	
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
	public CmdbModel setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 父节点<br>
	 * 父节点
	 * @return 父节点
	*/
	public String getParentId() {
		return parentId;
	}
	
	/**
	 * 设置 父节点
	 * @param parentId 父节点
	 * @return 当前对象
	*/
	public CmdbModel setParentId(String parentId) {
		this.parentId=parentId;
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
	public CmdbModel setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 节点路径<br>
	 * 节点路径
	 * @return 节点路径
	*/
	public String getHierarchy() {
		return hierarchy;
	}
	
	/**
	 * 设置 节点路径
	 * @param hierarchy 节点路径
	 * @return 当前对象
	*/
	public CmdbModel setHierarchy(String hierarchy) {
		this.hierarchy=hierarchy;
		return this;
	}
	
	/**
	 * 获得 节点路径名称<br>
	 * 节点路径名称
	 * @return 节点路径名称
	*/
	public String getHierarchyName() {
		return hierarchyName;
	}
	
	/**
	 * 设置 节点路径名称
	 * @param hierarchyName 节点路径名称
	 * @return 当前对象
	*/
	public CmdbModel setHierarchyName(String hierarchyName) {
		this.hierarchyName=hierarchyName;
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
	public CmdbModel setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 全称<br>
	 * 全称
	 * @return 全称
	*/
	public String getFullName() {
		return fullName;
	}
	
	/**
	 * 设置 全称
	 * @param fullName 全称
	 * @return 当前对象
	*/
	public CmdbModel setFullName(String fullName) {
		this.fullName=fullName;
		return this;
	}
	
	/**
	 * 获得 编码<br>
	 * 编码
	 * @return 编码
	*/
	public String getCode() {
		return code;
	}
	
	/**
	 * 设置 编码
	 * @param code 编码
	 * @return 当前对象
	*/
	public CmdbModel setCode(String code) {
		this.code=code;
		return this;
	}
	
	/**
	 * 获得 模型类型<br>
	 * 模型类型
	 * @return 模型类型
	*/
	public String getModelType() {
		return modelType;
	}
	
	/**
	 * 设置 模型类型
	 * @param modelType 模型类型
	 * @return 当前对象
	*/
	public CmdbModel setModelType(String modelType) {
		this.modelType=modelType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 数据来源
	 * @return 数据来源
	*/
	public String getSourceType() {
		return sourceType;
	}
	
	/**
	 * 设置 数据来源
	 * @param sourceType 数据来源
	 * @return 当前对象
	*/
	public CmdbModel setSourceType(String sourceType) {
		this.sourceType=sourceType;
		return this;
	}
	
	/**
	 * 获得 来源<br>
	 * 来源
	 * @return 来源
	*/
	public String getSource() {
		return source;
	}
	
	/**
	 * 设置 来源
	 * @param source 来源
	 * @return 当前对象
	*/
	public CmdbModel setSource(String source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 来源方式<br>
	 * 来源方式
	 * @return 来源方式
	*/
	public String getDataSource() {
		return dataSource;
	}
	
	/**
	 * 设置 来源方式
	 * @param dataSource 来源方式
	 * @return 当前对象
	*/
	public CmdbModel setDataSource(String dataSource) {
		this.dataSource=dataSource;
		return this;
	}
	
	/**
	 * 获得 存储方式<br>
	 * 存储方式
	 * @return 存储方式
	*/
	public String getStorageType() {
		return storageType;
	}
	
	/**
	 * 设置 存储方式
	 * @param storageType 存储方式
	 * @return 当前对象
	*/
	public CmdbModel setStorageType(String storageType) {
		this.storageType=storageType;
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
	public CmdbModel setSort(Integer sort) {
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
	public CmdbModel setNotes(String notes) {
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
	public CmdbModel setCreateBy(String createBy) {
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
	public CmdbModel setCreateTime(Date createTime) {
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
	public CmdbModel setUpdateBy(String updateBy) {
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
	public CmdbModel setUpdateTime(Date updateTime) {
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
	public CmdbModel setDeleted(Integer deleted) {
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
	public CmdbModel setDeleted(Boolean deletedBool) {
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
	public CmdbModel setDeleteBy(String deleteBy) {
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
	public CmdbModel setDeleteTime(Date deleteTime) {
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
	public CmdbModel setVersion(Integer version) {
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
	public CmdbModel setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 cmdbObjAttributeList<br>
	 * cmdbObjAttribute
	 * @return cmdbObjAttributeList
	*/
	public List<CmdbObjAttribute> getCmdbObjAttributeList() {
		return cmdbObjAttributeList;
	}
	
	/**
	 * 设置 cmdbObjAttributeList
	 * @param cmdbObjAttributeList cmdbObjAttributeList
	 * @return 当前对象
	*/
	public CmdbModel setCmdbObjAttributeList(List<CmdbObjAttribute> cmdbObjAttributeList) {
		this.cmdbObjAttributeList=cmdbObjAttributeList;
		return this;
	}
	
	/**
	 * 添加 cmdbObjAttributeList
	 * @param cmdbObjAttribute cmdbObjAttributeList
	 * @return 当前对象
	*/
	public CmdbModel addCmdbObjAttribute(CmdbObjAttribute... cmdbObjAttribute) {
		if(this.cmdbObjAttributeList==null) cmdbObjAttributeList=new ArrayList<>();
		this.cmdbObjAttributeList.addAll(Arrays.asList(cmdbObjAttribute));
		return this;
	}
	
	/**
	 * 获得 cmdbModelVList<br>
	 * cmdbModelVList
	 * @return cmdbModelVList
	*/
	public List<CmdbModelV> getCmdbModelVList() {
		return cmdbModelVList;
	}
	
	/**
	 * 设置 cmdbModelVList
	 * @param cmdbModelVList cmdbModelVList
	 * @return 当前对象
	*/
	public CmdbModel setCmdbModelVList(List<CmdbModelV> cmdbModelVList) {
		this.cmdbModelVList=cmdbModelVList;
		return this;
	}
	
	/**
	 * 添加 cmdbModelVList
	 * @param cmdbModelV cmdbModelVList
	 * @return 当前对象
	*/
	public CmdbModel addCmdbModelV(CmdbModelV... cmdbModelV) {
		if(this.cmdbModelVList==null) cmdbModelVList=new ArrayList<>();
		this.cmdbModelVList.addAll(Arrays.asList(cmdbModelV));
		return this;
	}
	
	/**
	 * 获得 cmdbObjAttributeParentList<br>
	 * cmdbObjAttributeParentList
	 * @return cmdbObjAttributeParentList
	*/
	public List<CmdbObjAttribute> getCmdbObjAttributeParentList() {
		return cmdbObjAttributeParentList;
	}
	
	/**
	 * 设置 cmdbObjAttributeParentList
	 * @param cmdbObjAttributeParentList cmdbObjAttributeParentList
	 * @return 当前对象
	*/
	public CmdbModel setCmdbObjAttributeParentList(List<CmdbObjAttribute> cmdbObjAttributeParentList) {
		this.cmdbObjAttributeParentList=cmdbObjAttributeParentList;
		return this;
	}
	
	/**
	 * 添加 cmdbObjAttributeParentList
	 * @param cmdbObjAttributeParent cmdbObjAttributeParentList
	 * @return 当前对象
	*/
	public CmdbModel addCmdbObjAttributeParent(CmdbObjAttribute... cmdbObjAttributeParent) {
		if(this.cmdbObjAttributeParentList==null) cmdbObjAttributeParentList=new ArrayList<>();
		this.cmdbObjAttributeParentList.addAll(Arrays.asList(cmdbObjAttributeParent));
		return this;
	}
	
	/**
	 * 获得 cmdbModelParent<br>
	 * cmdbModelParent
	 * @return cmdbModelParent
	*/
	public CmdbModel getCmdbModelParent() {
		return cmdbModelParent;
	}
	
	/**
	 * 设置 cmdbModelParent
	 * @param cmdbModelParent cmdbModelParent
	 * @return 当前对象
	*/
	public CmdbModel setCmdbModelParent(CmdbModel cmdbModelParent) {
		this.cmdbModelParent=cmdbModelParent;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CmdbModel , 转换好的 CmdbModel 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CmdbModel , 转换好的 PoJo 对象
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
	public CmdbModel clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CmdbModel duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.CmdbModelMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.CmdbModelMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setHierarchy(this.getHierarchy());
		inst.setHierarchyName(this.getHierarchyName());
		inst.setFullName(this.getFullName());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setModelType(this.getModelType());
		inst.setSource(this.getSource());
		inst.setSort(this.getSort());
		inst.setVersion(this.getVersion());
		inst.setParentId(this.getParentId());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setSourceType(this.getSourceType());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setStorageType(this.getStorageType());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setDataSource(this.getDataSource());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setCmdbObjAttributeList(this.getCmdbObjAttributeList());
			inst.setCmdbModelParent(this.getCmdbModelParent());
			inst.setCmdbModelVList(this.getCmdbModelVList());
			inst.setCmdbObjAttributeParentList(this.getCmdbObjAttributeParentList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CmdbModel clone(boolean deep) {
		return EntityContext.clone(CmdbModel.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CmdbModel
	 * @param cmdbModelMap 包含实体信息的 Map 对象
	 * @return CmdbModel , 转换好的的 CmdbModel 对象
	*/
	@Transient
	public static CmdbModel createFrom(Map<String,Object> cmdbModelMap) {
		if(cmdbModelMap==null) return null;
		CmdbModel po = create();
		EntityContext.copyProperties(po,cmdbModelMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CmdbModel
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CmdbModel , 转换好的的 CmdbModel 对象
	*/
	@Transient
	public static CmdbModel createFrom(Object pojo) {
		if(pojo==null) return null;
		CmdbModel po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CmdbModel，等同于 new
	 * @return CmdbModel 对象
	*/
	@Transient
	public static CmdbModel create() {
		return new com.dt.platform.domain.ops.meta.CmdbModelMeta.$$proxy$$();
	}
}