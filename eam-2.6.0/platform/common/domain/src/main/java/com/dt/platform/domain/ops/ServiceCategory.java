package com.dt.platform.domain.ops;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.OpsTables.OPS_SERVICE_CATEGORY;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import org.github.foxnic.web.domain.system.DictItem;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 服务类型
 * @author 金杰 , maillank@qq.com
 * @since 2022-09-13 06:31:54
 * @sign F5650A086B441E738461391925B4E2B4
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "ops_service_category")
public class ServiceCategory extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =OPS_SERVICE_CATEGORY.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 服务分组：服务分组
	*/
	@ApiModelProperty(required = false,value="服务分组" , notes = "服务分组")
	private String groupId;
	
	/**
	 * 编码：编码
	*/
	@ApiModelProperty(required = false,value="编码" , notes = "编码")
	private String code;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称")
	private String name;
	
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
	 * 服务分组：服务分组
	*/
	@ApiModelProperty(required = false,value="服务分组" , notes = "服务分组")
	private ServiceGroup group;
	
	/**
	 * labelList：labelList
	*/
	@ApiModelProperty(required = false,value="labelList" , notes = "labelList")
	private List<DictItem> labelList;
	
	/**
	 * labelIds：labelIds
	*/
	@ApiModelProperty(required = false,value="labelIds" , notes = "labelIds")
	private List<String> labelIds;
	
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
	public ServiceCategory setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 服务分组<br>
	 * 服务分组
	 * @return 服务分组
	*/
	public String getGroupId() {
		return groupId;
	}
	
	/**
	 * 设置 服务分组
	 * @param groupId 服务分组
	 * @return 当前对象
	*/
	public ServiceCategory setGroupId(String groupId) {
		this.groupId=groupId;
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
	public ServiceCategory setCode(String code) {
		this.code=code;
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
	public ServiceCategory setName(String name) {
		this.name=name;
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
	public ServiceCategory setNotes(String notes) {
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
	public ServiceCategory setCreateBy(String createBy) {
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
	public ServiceCategory setCreateTime(Date createTime) {
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
	public ServiceCategory setUpdateBy(String updateBy) {
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
	public ServiceCategory setUpdateTime(Date updateTime) {
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
	public ServiceCategory setDeleted(Integer deleted) {
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
	public ServiceCategory setDeleted(Boolean deletedBool) {
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
	public ServiceCategory setDeleteBy(String deleteBy) {
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
	public ServiceCategory setDeleteTime(Date deleteTime) {
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
	public ServiceCategory setVersion(Integer version) {
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
	public ServiceCategory setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}
	
	/**
	 * 获得 服务分组<br>
	 * 服务分组
	 * @return 服务分组
	*/
	public ServiceGroup getGroup() {
		return group;
	}
	
	/**
	 * 设置 服务分组
	 * @param group 服务分组
	 * @return 当前对象
	*/
	public ServiceCategory setGroup(ServiceGroup group) {
		this.group=group;
		return this;
	}
	
	/**
	 * 获得 labelList<br>
	 * labelList
	 * @return labelList
	*/
	public List<DictItem> getLabelList() {
		return labelList;
	}
	
	/**
	 * 设置 labelList
	 * @param labelList labelList
	 * @return 当前对象
	*/
	public ServiceCategory setLabelList(List<DictItem> labelList) {
		this.labelList=labelList;
		return this;
	}
	
	/**
	 * 添加 labelList
	 * @param label labelList
	 * @return 当前对象
	*/
	public ServiceCategory addLabel(DictItem... label) {
		if(this.labelList==null) labelList=new ArrayList<>();
		this.labelList.addAll(Arrays.asList(label));
		return this;
	}
	
	/**
	 * 获得 labelIds<br>
	 * labelIds
	 * @return labelIds
	*/
	public List<String> getLabelIds() {
		return labelIds;
	}
	
	/**
	 * 设置 labelIds
	 * @param labelIds labelIds
	 * @return 当前对象
	*/
	public ServiceCategory setLabelIds(List<String> labelIds) {
		this.labelIds=labelIds;
		return this;
	}
	
	/**
	 * 添加 labelIds
	 * @param labelId labelIds
	 * @return 当前对象
	*/
	public ServiceCategory addLabelId(String... labelId) {
		if(this.labelIds==null) labelIds=new ArrayList<>();
		this.labelIds.addAll(Arrays.asList(labelId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return ServiceCategory , 转换好的 ServiceCategory 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return ServiceCategory , 转换好的 PoJo 对象
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
	public ServiceCategory clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public ServiceCategory duplicate(boolean all) {
		com.dt.platform.domain.ops.meta.ServiceCategoryMeta.$$proxy$$ inst = new com.dt.platform.domain.ops.meta.ServiceCategoryMeta.$$proxy$$();
		inst.setCode(this.getCode());
		inst.setNotes(this.getNotes());
		inst.setGroupId(this.getGroupId());
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
		inst.setId(this.getId());
		if(all) {
			inst.setLabelList(this.getLabelList());
			inst.setLabelIds(this.getLabelIds());
			inst.setGroup(this.getGroup());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public ServiceCategory clone(boolean deep) {
		return EntityContext.clone(ServiceCategory.class,this,deep);
	}

	/**
	 * 将 Map 转换成 ServiceCategory
	 * @param serviceCategoryMap 包含实体信息的 Map 对象
	 * @return ServiceCategory , 转换好的的 ServiceCategory 对象
	*/
	@Transient
	public static ServiceCategory createFrom(Map<String,Object> serviceCategoryMap) {
		if(serviceCategoryMap==null) return null;
		ServiceCategory po = create();
		EntityContext.copyProperties(po,serviceCategoryMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 ServiceCategory
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return ServiceCategory , 转换好的的 ServiceCategory 对象
	*/
	@Transient
	public static ServiceCategory createFrom(Object pojo) {
		if(pojo==null) return null;
		ServiceCategory po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 ServiceCategory，等同于 new
	 * @return ServiceCategory 对象
	*/
	@Transient
	public static ServiceCategory create() {
		return new com.dt.platform.domain.ops.meta.ServiceCategoryMeta.$$proxy$$();
	}
}