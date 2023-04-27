package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_ASSET_LABEL_LAYOUT;
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
import com.dt.platform.domain.eam.meta.AssetLabelLayoutMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 标签布局
 * <p>标签布局 , 数据表 eam_asset_label_layout 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-02 19:38:47
 * @sign 65ADFA5C7D3FCD096CAE1756F9F5DCB1
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_asset_label_layout")
@ApiModel(description = "标签布局 ; 标签布局 , 数据表 eam_asset_label_layout 的PO类型")
public class AssetLabelLayout extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_ASSET_LABEL_LAYOUT.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "1")
	private String id;
	
	/**
	 * 模版：模版
	*/
	@ApiModelProperty(required = false,value="模版" , notes = "模版" , example = "650449362169626624")
	private String tplId;
	
	/**
	 * 字段ID：字段ID
	*/
	@ApiModelProperty(required = false,value="字段ID" , notes = "字段ID")
	private String colId;
	
	/**
	 * 字段编码：字段编码
	*/
	@ApiModelProperty(required = false,value="字段编码" , notes = "字段编码" , example = "资产")
	private String colCode;
	
	/**
	 * 类型：类型
	*/
	@ApiModelProperty(required = false,value="类型" , notes = "类型" , example = "label")
	private String type;
	
	/**
	 * 行数：行数
	*/
	@ApiModelProperty(required = false,value="行数" , notes = "行数" , example = "1")
	private Integer rowNumber;
	
	/**
	 * 行高度：行高度
	*/
	@ApiModelProperty(required = false,value="行高度" , notes = "行高度" , example = "2.00")
	private BigDecimal rowHeight;
	
	/**
	 * row：span
	*/
	@ApiModelProperty(required = false,value="row" , notes = "span" , example = "1")
	private Integer rowSpan;
	
	/**
	 * col：span
	*/
	@ApiModelProperty(required = false,value="col" , notes = "span" , example = "1")
	private Integer colSpan;
	
	/**
	 * 顺序：顺序
	*/
	@ApiModelProperty(required = false,value="顺序" , notes = "顺序" , example = "0")
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
	public AssetLabelLayout setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 模版<br>
	 * 模版
	 * @return 模版
	*/
	public String getTplId() {
		return tplId;
	}
	
	/**
	 * 设置 模版
	 * @param tplId 模版
	 * @return 当前对象
	*/
	public AssetLabelLayout setTplId(String tplId) {
		this.tplId=tplId;
		return this;
	}
	
	/**
	 * 获得 字段ID<br>
	 * 字段ID
	 * @return 字段ID
	*/
	public String getColId() {
		return colId;
	}
	
	/**
	 * 设置 字段ID
	 * @param colId 字段ID
	 * @return 当前对象
	*/
	public AssetLabelLayout setColId(String colId) {
		this.colId=colId;
		return this;
	}
	
	/**
	 * 获得 字段编码<br>
	 * 字段编码
	 * @return 字段编码
	*/
	public String getColCode() {
		return colCode;
	}
	
	/**
	 * 设置 字段编码
	 * @param colCode 字段编码
	 * @return 当前对象
	*/
	public AssetLabelLayout setColCode(String colCode) {
		this.colCode=colCode;
		return this;
	}
	
	/**
	 * 获得 类型<br>
	 * 类型
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
	public AssetLabelLayout setType(String type) {
		this.type=type;
		return this;
	}
	
	/**
	 * 获得 行数<br>
	 * 行数
	 * @return 行数
	*/
	public Integer getRowNumber() {
		return rowNumber;
	}
	
	/**
	 * 设置 行数
	 * @param rowNumber 行数
	 * @return 当前对象
	*/
	public AssetLabelLayout setRowNumber(Integer rowNumber) {
		this.rowNumber=rowNumber;
		return this;
	}
	
	/**
	 * 获得 行高度<br>
	 * 行高度
	 * @return 行高度
	*/
	public BigDecimal getRowHeight() {
		return rowHeight;
	}
	
	/**
	 * 设置 行高度
	 * @param rowHeight 行高度
	 * @return 当前对象
	*/
	public AssetLabelLayout setRowHeight(BigDecimal rowHeight) {
		this.rowHeight=rowHeight;
		return this;
	}
	
	/**
	 * 获得 row<br>
	 * span
	 * @return row
	*/
	public Integer getRowSpan() {
		return rowSpan;
	}
	
	/**
	 * 设置 row
	 * @param rowSpan row
	 * @return 当前对象
	*/
	public AssetLabelLayout setRowSpan(Integer rowSpan) {
		this.rowSpan=rowSpan;
		return this;
	}
	
	/**
	 * 获得 col<br>
	 * span
	 * @return col
	*/
	public Integer getColSpan() {
		return colSpan;
	}
	
	/**
	 * 设置 col
	 * @param colSpan col
	 * @return 当前对象
	*/
	public AssetLabelLayout setColSpan(Integer colSpan) {
		this.colSpan=colSpan;
		return this;
	}
	
	/**
	 * 获得 顺序<br>
	 * 顺序
	 * @return 顺序
	*/
	public Integer getSort() {
		return sort;
	}
	
	/**
	 * 设置 顺序
	 * @param sort 顺序
	 * @return 当前对象
	*/
	public AssetLabelLayout setSort(Integer sort) {
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
	public AssetLabelLayout setCreateBy(String createBy) {
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
	public AssetLabelLayout setCreateTime(Date createTime) {
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
	public AssetLabelLayout setUpdateBy(String updateBy) {
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
	public AssetLabelLayout setUpdateTime(Date updateTime) {
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
	public AssetLabelLayout setDeleted(Integer deleted) {
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
	public AssetLabelLayout setDeleted(Boolean deletedBool) {
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
	public AssetLabelLayout setDeleteBy(String deleteBy) {
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
	public AssetLabelLayout setDeleteTime(Date deleteTime) {
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
	public AssetLabelLayout setVersion(Integer version) {
		this.version=version;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return AssetLabelLayout , 转换好的 AssetLabelLayout 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return AssetLabelLayout , 转换好的 PoJo 对象
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
	public AssetLabelLayout clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public AssetLabelLayout duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.AssetLabelLayoutMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.AssetLabelLayoutMeta.$$proxy$$();
		inst.setRowSpan(this.getRowSpan());
		inst.setColSpan(this.getColSpan());
		inst.setColCode(this.getColCode());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSort(this.getSort());
		inst.setType(this.getType());
		inst.setVersion(this.getVersion());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setTplId(this.getTplId());
		inst.setColId(this.getColId());
		inst.setRowNumber(this.getRowNumber());
		inst.setRowHeight(this.getRowHeight());
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public AssetLabelLayout clone(boolean deep) {
		return EntityContext.clone(AssetLabelLayout.class,this,deep);
	}

	/**
	 * 将 Map 转换成 AssetLabelLayout
	 * @param assetLabelLayoutMap 包含实体信息的 Map 对象
	 * @return AssetLabelLayout , 转换好的的 AssetLabelLayout 对象
	*/
	@Transient
	public static AssetLabelLayout createFrom(Map<String,Object> assetLabelLayoutMap) {
		if(assetLabelLayoutMap==null) return null;
		AssetLabelLayout po = create();
		EntityContext.copyProperties(po,assetLabelLayoutMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 AssetLabelLayout
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return AssetLabelLayout , 转换好的的 AssetLabelLayout 对象
	*/
	@Transient
	public static AssetLabelLayout createFrom(Object pojo) {
		if(pojo==null) return null;
		AssetLabelLayout po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 AssetLabelLayout，等同于 new
	 * @return AssetLabelLayout 对象
	*/
	@Transient
	public static AssetLabelLayout create() {
		return new com.dt.platform.domain.eam.meta.AssetLabelLayoutMeta.$$proxy$$();
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
			this.setRowSpan(DataParser.parse(Integer.class, map.get(AssetLabelLayoutMeta.ROW_SPAN)));
			this.setColSpan(DataParser.parse(Integer.class, map.get(AssetLabelLayoutMeta.COL_SPAN)));
			this.setColCode(DataParser.parse(String.class, map.get(AssetLabelLayoutMeta.COL_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(AssetLabelLayoutMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, map.get(AssetLabelLayoutMeta.SORT)));
			this.setType(DataParser.parse(String.class, map.get(AssetLabelLayoutMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(AssetLabelLayoutMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, map.get(AssetLabelLayoutMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(AssetLabelLayoutMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(AssetLabelLayoutMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(AssetLabelLayoutMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(AssetLabelLayoutMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(AssetLabelLayoutMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(AssetLabelLayoutMeta.ID)));
			this.setTplId(DataParser.parse(String.class, map.get(AssetLabelLayoutMeta.TPL_ID)));
			this.setColId(DataParser.parse(String.class, map.get(AssetLabelLayoutMeta.COL_ID)));
			this.setRowNumber(DataParser.parse(Integer.class, map.get(AssetLabelLayoutMeta.ROW_NUMBER)));
			this.setRowHeight(DataParser.parse(BigDecimal.class, map.get(AssetLabelLayoutMeta.ROW_HEIGHT)));
			// others
			return true;
		} else {
			try {
				this.setRowSpan( (Integer)map.get(AssetLabelLayoutMeta.ROW_SPAN));
				this.setColSpan( (Integer)map.get(AssetLabelLayoutMeta.COL_SPAN));
				this.setColCode( (String)map.get(AssetLabelLayoutMeta.COL_CODE));
				this.setUpdateTime( (Date)map.get(AssetLabelLayoutMeta.UPDATE_TIME));
				this.setSort( (Integer)map.get(AssetLabelLayoutMeta.SORT));
				this.setType( (String)map.get(AssetLabelLayoutMeta.TYPE));
				this.setVersion( (Integer)map.get(AssetLabelLayoutMeta.VERSION));
				this.setCreateBy( (String)map.get(AssetLabelLayoutMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(AssetLabelLayoutMeta.DELETED));
				this.setCreateTime( (Date)map.get(AssetLabelLayoutMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(AssetLabelLayoutMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(AssetLabelLayoutMeta.DELETE_TIME));
				this.setDeleteBy( (String)map.get(AssetLabelLayoutMeta.DELETE_BY));
				this.setId( (String)map.get(AssetLabelLayoutMeta.ID));
				this.setTplId( (String)map.get(AssetLabelLayoutMeta.TPL_ID));
				this.setColId( (String)map.get(AssetLabelLayoutMeta.COL_ID));
				this.setRowNumber( (Integer)map.get(AssetLabelLayoutMeta.ROW_NUMBER));
				this.setRowHeight( (BigDecimal)map.get(AssetLabelLayoutMeta.ROW_HEIGHT));
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
			this.setRowSpan(DataParser.parse(Integer.class, r.getValue(AssetLabelLayoutMeta.ROW_SPAN)));
			this.setColSpan(DataParser.parse(Integer.class, r.getValue(AssetLabelLayoutMeta.COL_SPAN)));
			this.setColCode(DataParser.parse(String.class, r.getValue(AssetLabelLayoutMeta.COL_CODE)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(AssetLabelLayoutMeta.UPDATE_TIME)));
			this.setSort(DataParser.parse(Integer.class, r.getValue(AssetLabelLayoutMeta.SORT)));
			this.setType(DataParser.parse(String.class, r.getValue(AssetLabelLayoutMeta.TYPE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(AssetLabelLayoutMeta.VERSION)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(AssetLabelLayoutMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(AssetLabelLayoutMeta.DELETED)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(AssetLabelLayoutMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(AssetLabelLayoutMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(AssetLabelLayoutMeta.DELETE_TIME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(AssetLabelLayoutMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(AssetLabelLayoutMeta.ID)));
			this.setTplId(DataParser.parse(String.class, r.getValue(AssetLabelLayoutMeta.TPL_ID)));
			this.setColId(DataParser.parse(String.class, r.getValue(AssetLabelLayoutMeta.COL_ID)));
			this.setRowNumber(DataParser.parse(Integer.class, r.getValue(AssetLabelLayoutMeta.ROW_NUMBER)));
			this.setRowHeight(DataParser.parse(BigDecimal.class, r.getValue(AssetLabelLayoutMeta.ROW_HEIGHT)));
			return true;
		} else {
			try {
				this.setRowSpan( (Integer)r.getValue(AssetLabelLayoutMeta.ROW_SPAN));
				this.setColSpan( (Integer)r.getValue(AssetLabelLayoutMeta.COL_SPAN));
				this.setColCode( (String)r.getValue(AssetLabelLayoutMeta.COL_CODE));
				this.setUpdateTime( (Date)r.getValue(AssetLabelLayoutMeta.UPDATE_TIME));
				this.setSort( (Integer)r.getValue(AssetLabelLayoutMeta.SORT));
				this.setType( (String)r.getValue(AssetLabelLayoutMeta.TYPE));
				this.setVersion( (Integer)r.getValue(AssetLabelLayoutMeta.VERSION));
				this.setCreateBy( (String)r.getValue(AssetLabelLayoutMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(AssetLabelLayoutMeta.DELETED));
				this.setCreateTime( (Date)r.getValue(AssetLabelLayoutMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(AssetLabelLayoutMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(AssetLabelLayoutMeta.DELETE_TIME));
				this.setDeleteBy( (String)r.getValue(AssetLabelLayoutMeta.DELETE_BY));
				this.setId( (String)r.getValue(AssetLabelLayoutMeta.ID));
				this.setTplId( (String)r.getValue(AssetLabelLayoutMeta.TPL_ID));
				this.setColId( (String)r.getValue(AssetLabelLayoutMeta.COL_ID));
				this.setRowNumber( (Integer)r.getValue(AssetLabelLayoutMeta.ROW_NUMBER));
				this.setRowHeight( (BigDecimal)r.getValue(AssetLabelLayoutMeta.ROW_HEIGHT));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}