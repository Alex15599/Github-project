package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_LABEL_PAPER;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.AssetLabelPaperMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 纸张类型
 * <p>纸张类型 , 数据表 eam_asset_label_paper 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-03 12:56:15
 * @sign EACEAC990CACA80C4B3EE3B4FA1283AA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_label_paper")
@ApiModel(description = "纸张类型 ; 纸张类型 , 数据表 eam_asset_label_paper 的PO类型")
public class AssetLabelPaper extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_LABEL_PAPER.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "1")
	private String id;
	
	/**
	 * 名称：名称
	*/
	@ApiModelProperty(required = false,value="名称" , notes = "名称" , example = "标签专用纸")
	private String name;
	
	/**
	 * 是否启用：是否启用
	*/
	@ApiModelProperty(required = false,value="是否启用" , notes = "是否启用" , example = "enable")
	private String status;
	
	/**
	 * 长度：长度
	*/
	@ApiModelProperty(required = false,value="长度" , notes = "长度" , example = "232.00")
	private BigDecimal w;
	
	/**
	 * 宽带：宽带
	*/
	@ApiModelProperty(required = false,value="宽带" , notes = "宽带" , example = "174.00")
	private BigDecimal h;
	
	/**
	 * 实现动作：实现动作
	*/
	@ApiModelProperty(required = false,value="实现动作" , notes = "实现动作" , example = "special")
	private String actionCode;
	
	/**
	 * 类型：paper|special
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "paper|special" , example = "special")
	private String type;
	
	/**
	 * 列数：列数
	*/
	@ApiModelProperty(required = false,value="列数" , notes = "列数" , example = "1")
	private Integer columnNumber;
	
	/**
	 * 排序：排序
	*/
	@ApiModelProperty(required = false,value="排序" , notes = "排序" , example = "0")
	private Integer sort;
	
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
	public AssetLabelPaper setId(String id) {
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
	public AssetLabelPaper setName(String name) {
		this.name=name;
		return this;
	}
	
	/**
	 * 获得 是否启用<br>
	 * 是否启用
	 * @return 是否启用
	*/
	public String getStatus() {
		return status;
	}
	
	/**
	 * 设置 是否启用
	 * @param status 是否启用
	 * @return 当前对象
	*/
	public AssetLabelPaper setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 长度<br>
	 * 长度
	 * @return 长度
	*/
	public BigDecimal getW() {
		return w;
	}
	
	/**
	 * 设置 长度
	 * @param w 长度
	 * @return 当前对象
	*/
	public AssetLabelPaper setW(BigDecimal w) {
		this.w=w;
		return this;
	}
	
	/**
	 * 获得 宽带<br>
	 * 宽带
	 * @return 宽带
	*/
	public BigDecimal getH() {
		return h;
	}
	
	/**
	 * 设置 宽带
	 * @param h 宽带
	 * @return 当前对象
	*/
	public AssetLabelPaper setH(BigDecimal h) {
		this.h=h;
		return this;
	}
	
	/**
	 * 获得 实现动作<br>
	 * 实现动作
	 * @return 实现动作
	*/
	public String getActionCode() {
		return actionCode;
	}
	
	/**
	 * 设置 实现动作
	 * @param actionCode 实现动作
	 * @return 当前对象
	*/
	public AssetLabelPaper setActionCode(String actionCode) {
		this.actionCode=actionCode;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * paper|special
	 * @return 类型
	*/
	public String getType() {
		return type;
	}
	
	/**
	 * 设置 类型
	 * @param type 类型
	 * @return 当前对象
	*/
	public AssetLabelPaper setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 列数<br>
	 * 列数
	 * @return 列数
	*/
	public Integer getColumnNumber() {
		return columnNumber;
	}
	
	/**
	 * 设置 列数
	 * @param columnNumber 列数
	 * @return 当前对象
	*/
	public AssetLabelPaper setColumnNumber(Integer columnNumber) {
		this.columnNumber=columnNumber;
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
	public AssetLabelPaper setSort(Integer sort) {
		this.sort=sort;
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
	public AssetLabelPaper setCreateBy(String createBy) {
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
	public AssetLabelPaper setCreateTime(Date createTime) {
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
	public AssetLabelPaper setUpdateBy(String updateBy) {
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
	public AssetLabelPaper setUpdateTime(Date updateTime) {
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
	public AssetLabelPaper setDeleted(Integer deleted) {
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
	public AssetLabelPaper setDeleted(Boolean deletedBool) {
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
	public AssetLabelPaper setDeleteBy(String deleteBy) {
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
	public AssetLabelPaper setDeleteTime(Date deleteTime) {
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
	public AssetLabelPaper setVersion(Integer version) {
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
	public AssetLabelPaper setTenantId(String tenantId) {
		this.tenantId=tenantId;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetLabelPaper , 转换好的 AssetLabelPaper 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetLabelPaper , 转换好的 PoJo 对象
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
	public AssetLabelPaper clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetLabelPaper duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetLabelPaperMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetLabelPaperMeta.$$proxy$$();
		inst.setH(this.getH());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setColumnNumber(this.getColumnNumber());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setW(this.getW());
		inst.setName(this.getName());
		inst.setTenantId(this.getTenantId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setActionCode(this.getActionCode());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetLabelPaper clone(boolean deep) {
		return EntityContext.clone(AssetLabelPaper.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetLabelPaper
	 * @param assetLabelPaperMap 包含实体信息的 Map 对象
	 * @return AssetLabelPaper , 转换好的的 AssetLabelPaper 对象
	*/
	@Transient
	public static AssetLabelPaper createFrom(Map<String,Object> assetLabelPaperMap) {
		if(assetLabelPaperMap==null) return null;
		AssetLabelPaper po = create();
		EntityContext.copyProperties(po,assetLabelPaperMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetLabelPaper
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetLabelPaper , 转换好的的 AssetLabelPaper 对象
	*/
	@Transient
	public static AssetLabelPaper createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetLabelPaper po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetLabelPaper，等同于 new
	 * @return AssetLabelPaper 对象
	*/
	@Transient
	public static AssetLabelPaper create() {
		return new com.dt.platform.domain.eam.meta.AssetLabelPaperMeta.$$proxy$$();
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
			this.setH(DataParser.parse(BigDecimal.class, map.get(AssetLabelPaperMeta.H)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetLabelPaperMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(AssetLabelPaperMeta.SORT)));
			this.setType(DataParser.parse(String.class, map.get(AssetLabelPaperMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetLabelPaperMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetLabelPaperMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetLabelPaperMeta.DELETED)));
			this.setColumnNumber(DataParser.parse(Integer.class, map.get(AssetLabelPaperMeta.COLUMN_NUMBER)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetLabelPaperMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetLabelPaperMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetLabelPaperMeta.DELETE_TIME)));
			this.setW(DataParser.parse(BigDecimal.class, map.get(AssetLabelPaperMeta.W)));
			this.setName(DataParser.parse(String.class, map.get(AssetLabelPaperMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, map.get(AssetLabelPaperMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetLabelPaperMeta.DELETE_BY)));
			this.setActionCode(DataParser.parse(String.class, map.get(AssetLabelPaperMeta.ACTION_CODE)));
			this.setId(DataParser.parse(String.class, map.get(AssetLabelPaperMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(AssetLabelPaperMeta.STATUS)));
			// others
			return true;
		} else {
			try {
				this.setH( (BigDecimal)map.get(AssetLabelPaperMeta.H));
				this.setUpdateTime( (Date)map.get(AssetLabelPaperMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(AssetLabelPaperMeta.SORT));
				this.setType( (String)map.get(AssetLabelPaperMeta.TYPE));
				this.setVersion( (Integer)map.get(AssetLabelPaperMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetLabelPaperMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetLabelPaperMeta.DELETED));
				this.setColumnNumber( (Integer)map.get(AssetLabelPaperMeta.COLUMN_NUMBER));
				this.setCreateTime( (Date)map.get(AssetLabelPaperMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetLabelPaperMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetLabelPaperMeta.DELETE_TIME));
				this.setW( (BigDecimal)map.get(AssetLabelPaperMeta.W));
				this.setName( (String)map.get(AssetLabelPaperMeta.NAME));
				this.setTenantId( (String)map.get(AssetLabelPaperMeta.TENANT_ID));
				this.setDeleteBy( (String)map.get(AssetLabelPaperMeta.DELETE_BY));
				this.setActionCode( (String)map.get(AssetLabelPaperMeta.ACTION_CODE));
				this.setId( (String)map.get(AssetLabelPaperMeta.ID));
				this.setStatus( (String)map.get(AssetLabelPaperMeta.STATUS));
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
			this.setH(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelPaperMeta.H)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetLabelPaperMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(AssetLabelPaperMeta.SORT)));
			this.setType(DataParser.parse(String.class, r.getValue(AssetLabelPaperMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetLabelPaperMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetLabelPaperMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetLabelPaperMeta.DELETED)));
			this.setColumnNumber(DataParser.parse(Integer.class, r.getValue(AssetLabelPaperMeta.COLUMN_NUMBER)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetLabelPaperMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetLabelPaperMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetLabelPaperMeta.DELETE_TIME)));
			this.setW(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelPaperMeta.W)));
			this.setName(DataParser.parse(String.class, r.getValue(AssetLabelPaperMeta.NAME)));
			this.setTenantId(DataParser.parse(String.class, r.getValue(AssetLabelPaperMeta.TENANT_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetLabelPaperMeta.DELETE_BY)));
			this.setActionCode(DataParser.parse(String.class, r.getValue(AssetLabelPaperMeta.ACTION_CODE)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetLabelPaperMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(AssetLabelPaperMeta.STATUS)));
			return true;
		} else {
			try {
				this.setH( (BigDecimal)r.getValue(AssetLabelPaperMeta.H));
				this.setUpdateTime( (Date)r.getValue(AssetLabelPaperMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(AssetLabelPaperMeta.SORT));
				this.setType( (String)r.getValue(AssetLabelPaperMeta.TYPE));
				this.setVersion( (Integer)r.getValue(AssetLabelPaperMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetLabelPaperMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetLabelPaperMeta.DELETED));
				this.setColumnNumber( (Integer)r.getValue(AssetLabelPaperMeta.COLUMN_NUMBER));
				this.setCreateTime( (Date)r.getValue(AssetLabelPaperMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetLabelPaperMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetLabelPaperMeta.DELETE_TIME));
				this.setW( (BigDecimal)r.getValue(AssetLabelPaperMeta.W));
				this.setName( (String)r.getValue(AssetLabelPaperMeta.NAME));
				this.setTenantId( (String)r.getValue(AssetLabelPaperMeta.TENANT_ID));
				this.setDeleteBy( (String)r.getValue(AssetLabelPaperMeta.DELETE_BY));
				this.setActionCode( (String)r.getValue(AssetLabelPaperMeta.ACTION_CODE));
				this.setId( (String)r.getValue(AssetLabelPaperMeta.ID));
				this.setStatus( (String)r.getValue(AssetLabelPaperMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}