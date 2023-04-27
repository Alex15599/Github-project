package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_C_CUST_INSPECT_TPL;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.CCustInspectTplMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检模版
 * <p>巡检模版 , 数据表 eam_c_cust_inspect_tpl 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-08 19:05:36
 * @sign 9501E54D09F3652FB324198C1B1C110B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_c_cust_inspect_tpl")
@ApiModel(description = "巡检模版 ; 巡检模版 , 数据表 eam_c_cust_inspect_tpl 的PO类型")
public class CCustInspectTpl extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_C_CUST_INSPECT_TPL.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "696280340544618496")
	private String id;
	
	/**
	 * 标题：标题
	*/
	@ApiModelProperty(required = false,value="标题" , notes = "标题" , example = "测试巡检无效")
	private String name;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "invalid")
	private String status;
	
	/**
	 * 备注：备注
	*/
	@ApiModelProperty(required = false,value="备注" , notes = "备注" , example = "测试")
	private String notes;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-04-06 08:49:29")
	private Date createTime;
	
	/**
	 * 修改人ID：修改人ID
	*/
	@ApiModelProperty(required = false,value="修改人ID" , notes = "修改人ID" , example = "110588348101165911")
	private String updateBy;
	
	/**
	 * 修改时间：修改时间
	*/
	@ApiModelProperty(required = false,value="修改时间" , notes = "修改时间" , example = "2023-04-08 05:42:49")
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
	 * 租户：租户
	*/
	@ApiModelProperty(required = false,value="租户" , notes = "租户" , example = "T001")
	private String tenantId;
	
	/**
	 * version：version
	*/
	@ApiModelProperty(required = true,value="version" , notes = "version" , example = "4")
	private Integer version;
	
	/**
	 * assetList：assetList
	*/
	@ApiModelProperty(required = false,value="assetList" , notes = "assetList")
	private List<Asset> assetList;
	
	/**
	 * assetIds：assetIds
	*/
	@ApiModelProperty(required = false,value="assetIds" , notes = "assetIds")
	private List<String> assetIds;
	
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
	public CCustInspectTpl setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 标题<br>
	 * 标题
	 * @return 标题
	*/
	public String getName() {
		return name;
	}
	
	/**
	 * 设置 标题
	 * @param name 标题
	 * @return 当前对象
	*/
	public CCustInspectTpl setName(String name) {
		this.name=name;
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
	public CCustInspectTpl setStatus(String status) {
		this.status=status;
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
	public CCustInspectTpl setNotes(String notes) {
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
	public CCustInspectTpl setCreateBy(String createBy) {
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
	public CCustInspectTpl setCreateTime(Date createTime) {
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
	public CCustInspectTpl setUpdateBy(String updateBy) {
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
	public CCustInspectTpl setUpdateTime(Date updateTime) {
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
	public CCustInspectTpl setDeleted(Integer deleted) {
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
	public CCustInspectTpl setDeleted(Boolean deletedBool) {
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
	public CCustInspectTpl setDeleteBy(String deleteBy) {
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
	public CCustInspectTpl setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
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
	public CCustInspectTpl setTenantId(String tenantId) {
		this.tenantId=tenantId;
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
	public CCustInspectTpl setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 assetList<br>
	 * assetList
	 * @return assetList
	*/
	public List<Asset> getAssetList() {
		return assetList;
	}
	
	/**
	 * 设置 assetList
	 * @param assetList assetList
	 * @return 当前对象
	*/
	public CCustInspectTpl setAssetList(List<Asset> assetList) {
		this.assetList=assetList;
		return this;
	}
	
	/**
	 * 添加 assetList
	 * @param asset assetList
	 * @return 当前对象
	*/
	public CCustInspectTpl addAsset(Asset... asset) {
		if(this.assetList==null) assetList=new ArrayList<>();
		this.assetList.addAll(Arrays.asList(asset));
		return this;
	}
	
	/**
	 * 获得 assetIds<br>
	 * assetIds
	 * @return assetIds
	*/
	public List<String> getAssetIds() {
		return assetIds;
	}
	
	/**
	 * 设置 assetIds
	 * @param assetIds assetIds
	 * @return 当前对象
	*/
	public CCustInspectTpl setAssetIds(List<String> assetIds) {
		this.assetIds=assetIds;
		return this;
	}
	
	/**
	 * 添加 assetIds
	 * @param assetId assetIds
	 * @return 当前对象
	*/
	public CCustInspectTpl addAssetId(String... assetId) {
		if(this.assetIds==null) assetIds=new ArrayList<>();
		this.assetIds.addAll(Arrays.asList(assetId));
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CCustInspectTpl , 转换好的 CCustInspectTpl 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CCustInspectTpl , 转换好的 PoJo 对象
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
	public CCustInspectTpl clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CCustInspectTpl duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CCustInspectTplMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CCustInspectTplMeta.$$proxy$$();
		inst.setNotes(this.getNotes());
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
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setAssetIds(this.getAssetIds());
			inst.setAssetList(this.getAssetList());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CCustInspectTpl clone(boolean deep) {
		return EntityContext.clone(CCustInspectTpl.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CCustInspectTpl
	 * @param cCustInspectTplMap 包含实体信息的 Map 对象
	 * @return CCustInspectTpl , 转换好的的 CCustInspectTpl 对象
	*/
	@Transient
	public static CCustInspectTpl createFrom(Map<String,Object> cCustInspectTplMap) {
		if(cCustInspectTplMap==null) return null;
		CCustInspectTpl po = create();
		EntityContext.copyProperties(po,cCustInspectTplMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CCustInspectTpl
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CCustInspectTpl , 转换好的的 CCustInspectTpl 对象
	*/
	@Transient
	public static CCustInspectTpl createFrom(Object pojo) {
		if(pojo==null) return null;
		CCustInspectTpl po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CCustInspectTpl，等同于 new
	 * @return CCustInspectTpl 对象
	*/
	@Transient
	public static CCustInspectTpl create() {
		return new com.dt.platform.domain.eam.meta.CCustInspectTplMeta.$$proxy$$();
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
			this.setNotes(DataParser.parse(String.class, map.get(CCustInspectTplMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CCustInspectTplMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CCustInspectTplMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CCustInspectTplMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CCustInspectTplMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CCustInspectTplMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CCustInspectTplMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CCustInspectTplMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, map.get(CCustInspectTplMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(CCustInspectTplMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CCustInspectTplMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CCustInspectTplMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(CCustInspectTplMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setNotes( (String)map.get(CCustInspectTplMeta.NOTES));
				this.setUpdateTime( (Date)map.get(CCustInspectTplMeta.UPDATE_TIME));
				this.setVersion( (Integer)map.get(CCustInspectTplMeta.VERSION));
				this.setCreateBy( (String)map.get(CCustInspectTplMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(CCustInspectTplMeta.DELETED));
				this.setCreateTime( (Date)map.get(CCustInspectTplMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CCustInspectTplMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CCustInspectTplMeta.DELETE_TIME));
				this.setName( (String)map.get(CCustInspectTplMeta.NAME));
				this.setTenantId( (String)map.get(CCustInspectTplMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(CCustInspectTplMeta.DELETE_BY));
				this.setId( (String)map.get(CCustInspectTplMeta.ID));
				this.setStatus( (String)map.get(CCustInspectTplMeta.STATUS));
				// others
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
			this.setNotes(DataParser.parse(String.class, r.getValue(CCustInspectTplMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CCustInspectTplMeta.UPDATE_TIME)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CCustInspectTplMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CCustInspectTplMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CCustInspectTplMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CCustInspectTplMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CCustInspectTplMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CCustInspectTplMeta.DELETE_TIME)));
			this.setName(DataParser.parse(String.class, r.getValue(CCustInspectTplMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(CCustInspectTplMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CCustInspectTplMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CCustInspectTplMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(CCustInspectTplMeta.STATUS)));
			return true;
		} else {
			try {
				this.setNotes( (String)r.getValue(CCustInspectTplMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(CCustInspectTplMeta.UPDATE_TIME));
				this.setVersion( (Integer)r.getValue(CCustInspectTplMeta.VERSION));
				this.setCreateBy( (String)r.getValue(CCustInspectTplMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(CCustInspectTplMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(CCustInspectTplMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CCustInspectTplMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CCustInspectTplMeta.DELETE_TIME));
				this.setName( (String)r.getValue(CCustInspectTplMeta.NAME));
				this.setTenantId( (String)r.getValue(CCustInspectTplMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(CCustInspectTplMeta.DELETE_BY));
				this.setId( (String)r.getValue(CCustInspectTplMeta.ID));
				this.setStatus( (String)r.getValue(CCustInspectTplMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}