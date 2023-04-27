package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_DATA_PERMISSIONS_O_ORG;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;



/**
 * 所属
 * @author 金杰 , maillank@qq.com
 * @since 2022-08-17 06:31:21
 * @sign AADF8A5855F4F4C15841C088EC357B14
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_data_permissions_o_org")
public class AssetDataPermissionsOOrg extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_DATA_PERMISSIONS_O_ORG.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键")
	private String id;
	
	/**
	 * 权限：权限
	*/
	@ApiModelProperty(required = false,value="权限" , notes = "权限")
	private String permissionId;
	
	/**
	 * 值：值
	*/
	@ApiModelProperty(required = false,value="值" , notes = "值")
	private String value;
	
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
	public AssetDataPermissionsOOrg setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 权限<br>
	 * 权限
	 * @return 权限
	*/
	public String getPermissionId() {
		return permissionId;
	}
	
	/**
	 * 设置 权限
	 * @param permissionId 权限
	 * @return 当前对象
	*/
	public AssetDataPermissionsOOrg setPermissionId(String permissionId) {
		this.permissionId=permissionId;
		return this;
	}
	
	/**
	 * 获得 值<br>
	 * 值
	 * @return 值
	*/
	public String getValue() {
		return value;
	}
	
	/**
	 * 设置 值
	 * @param value 值
	 * @return 当前对象
	*/
	public AssetDataPermissionsOOrg setValue(String value) {
		this.value=value;
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
	public AssetDataPermissionsOOrg setCreateBy(String createBy) {
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
	public AssetDataPermissionsOOrg setCreateTime(Date createTime) {
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
	public AssetDataPermissionsOOrg setUpdateBy(String updateBy) {
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
	public AssetDataPermissionsOOrg setUpdateTime(Date updateTime) {
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
	public AssetDataPermissionsOOrg setDeleted(Integer deleted) {
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
	public AssetDataPermissionsOOrg setDeleted(Boolean deletedBool) {
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
	public AssetDataPermissionsOOrg setDeleteBy(String deleteBy) {
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
	public AssetDataPermissionsOOrg setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetDataPermissionsOOrg , 转换好的 AssetDataPermissionsOOrg 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetDataPermissionsOOrg , 转换好的 PoJo 对象
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
	 * 将 Map 转换成 AssetDataPermissionsOOrg
	 * @param assetDataPermissionsOOrgMap 包含实体信息的 Map 对象
	 * @return AssetDataPermissionsOOrg , 转换好的的 AssetDataPermissionsOOrg 对象
	*/
	@Transient
	public static AssetDataPermissionsOOrg createFrom(Map<String,Object> assetDataPermissionsOOrgMap) {
		if(assetDataPermissionsOOrgMap==null) return null;
		AssetDataPermissionsOOrg po = EntityContext.create(AssetDataPermissionsOOrg.class, assetDataPermissionsOOrgMap);
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetDataPermissionsOOrg
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetDataPermissionsOOrg , 转换好的的 AssetDataPermissionsOOrg 对象
	*/
	@Transient
	public static AssetDataPermissionsOOrg createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetDataPermissionsOOrg po = EntityContext.create(AssetDataPermissionsOOrg.class,pojo);
		return po;
	}

	/**
	 * 创建一个 AssetDataPermissionsOOrg，等同于 new
	 * @return AssetDataPermissionsOOrg 对象
	*/
	@Transient
	public static AssetDataPermissionsOOrg create() {
		return EntityContext.create(AssetDataPermissionsOOrg.class);
	}
}