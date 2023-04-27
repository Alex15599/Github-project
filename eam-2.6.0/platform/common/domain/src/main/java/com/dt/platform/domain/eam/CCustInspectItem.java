package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_C_CUST_INSPECT_ITEM;
import javax.persistence.Id;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Transient;
import com.github.foxnic.api.swagger.EnumFor;
import org.github.foxnic.web.domain.hrm.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.foxnic.commons.lang.DataParser;
import java.util.Map;
import com.github.foxnic.dao.entity.EntityContext;
import com.dt.platform.domain.eam.meta.CCustInspectItemMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 巡检记录
 * <p>巡检记录 , 数据表 eam_c_cust_inspect_item 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-09 16:39:30
 * @sign 1F420D583353F841779A8C89D213F2BF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_c_cust_inspect_item")
@ApiModel(description = "巡检记录 ; 巡检记录 , 数据表 eam_c_cust_inspect_item 的PO类型")
public class CCustInspectItem extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_C_CUST_INSPECT_ITEM.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "697370899862519808")
	private String id;
	
	/**
	 * 归属：归属
	*/
	@ApiModelProperty(required = false,value="归属" , notes = "归属" , example = "697370866316476416")
	private String ownerId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "wait")
	private String status;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产" , example = "690281218771517440")
	private String assetId;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片")
	private String pictureId;
	
	/**
	 * 巡检人：巡检人
	*/
	@ApiModelProperty(required = false,value="巡检人" , notes = "巡检人")
	private String inspectUserId;
	
	/**
	 * 记录时间：记录时间
	*/
	@ApiModelProperty(required = false,value="记录时间" , notes = "记录时间")
	private Date recordTime;
	
	/**
	 * 内容：内容
	*/
	@ApiModelProperty(required = false,value="内容" , notes = "内容")
	private String ct;
	
	/**
	 * 位置：位置
	*/
	@ApiModelProperty(required = false,value="位置" , notes = "位置")
	private String pos;
	
	/**
	 * 设备编号：设备编号
	*/
	@ApiModelProperty(required = false,value="设备编号" , notes = "设备编号" , example = "AS16225")
	private String assetCode;
	
	/**
	 * 设备名称：设备名称
	*/
	@ApiModelProperty(required = false,value="设备名称" , notes = "设备名称" , example = "12121212")
	private String assetName;
	
	/**
	 * 设备型号：设备型号
	*/
	@ApiModelProperty(required = false,value="设备型号" , notes = "设备型号")
	private String assetModel;
	
	/**
	 * 设备序列：设备序列
	*/
	@ApiModelProperty(required = false,value="设备序列" , notes = "设备序列")
	private String assetSeq;
	
	/**
	 * 创建人ID：创建人ID
	*/
	@ApiModelProperty(required = false,value="创建人ID" , notes = "创建人ID" , example = "110588348101165911")
	private String createBy;
	
	/**
	 * 创建时间：创建时间
	*/
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2023-04-09 09:02:59")
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
	 * inspectUser：inspectUser
	*/
	@ApiModelProperty(required = false,value="inspectUser" , notes = "inspectUser")
	private Employee inspectUser;
	
	/**
	 * asset：asset
	*/
	@ApiModelProperty(required = false,value="asset" , notes = "asset")
	private Asset asset;
	
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
	public CCustInspectItem setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 归属<br>
	 * 归属
	 * @return 归属
	*/
	public String getOwnerId() {
		return ownerId;
	}
	
	/**
	 * 设置 归属
	 * @param ownerId 归属
	 * @return 当前对象
	*/
	public CCustInspectItem setOwnerId(String ownerId) {
		this.ownerId=ownerId;
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
	public CCustInspectItem setStatus(String status) {
		this.status=status;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public String getAssetId() {
		return assetId;
	}
	
	/**
	 * 设置 资产
	 * @param assetId 资产
	 * @return 当前对象
	*/
	public CCustInspectItem setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 图片<br>
	 * 图片
	 * @return 图片
	*/
	public String getPictureId() {
		return pictureId;
	}
	
	/**
	 * 设置 图片
	 * @param pictureId 图片
	 * @return 当前对象
	*/
	public CCustInspectItem setPictureId(String pictureId) {
		this.pictureId=pictureId;
		return this;
	}
	
	/**
	 * 获得 巡检人<br>
	 * 巡检人
	 * @return 巡检人
	*/
	public String getInspectUserId() {
		return inspectUserId;
	}
	
	/**
	 * 设置 巡检人
	 * @param inspectUserId 巡检人
	 * @return 当前对象
	*/
	public CCustInspectItem setInspectUserId(String inspectUserId) {
		this.inspectUserId=inspectUserId;
		return this;
	}
	
	/**
	 * 获得 记录时间<br>
	 * 记录时间
	 * @return 记录时间
	*/
	public Date getRecordTime() {
		return recordTime;
	}
	
	/**
	 * 设置 记录时间
	 * @param recordTime 记录时间
	 * @return 当前对象
	*/
	public CCustInspectItem setRecordTime(Date recordTime) {
		this.recordTime=recordTime;
		return this;
	}
	
	/**
	 * 获得 内容<br>
	 * 内容
	 * @return 内容
	*/
	public String getCt() {
		return ct;
	}
	
	/**
	 * 设置 内容
	 * @param ct 内容
	 * @return 当前对象
	*/
	public CCustInspectItem setCt(String ct) {
		this.ct=ct;
		return this;
	}
	
	/**
	 * 获得 位置<br>
	 * 位置
	 * @return 位置
	*/
	public String getPos() {
		return pos;
	}
	
	/**
	 * 设置 位置
	 * @param pos 位置
	 * @return 当前对象
	*/
	public CCustInspectItem setPos(String pos) {
		this.pos=pos;
		return this;
	}
	
	/**
	 * 获得 设备编号<br>
	 * 设备编号
	 * @return 设备编号
	*/
	public String getAssetCode() {
		return assetCode;
	}
	
	/**
	 * 设置 设备编号
	 * @param assetCode 设备编号
	 * @return 当前对象
	*/
	public CCustInspectItem setAssetCode(String assetCode) {
		this.assetCode=assetCode;
		return this;
	}
	
	/**
	 * 获得 设备名称<br>
	 * 设备名称
	 * @return 设备名称
	*/
	public String getAssetName() {
		return assetName;
	}
	
	/**
	 * 设置 设备名称
	 * @param assetName 设备名称
	 * @return 当前对象
	*/
	public CCustInspectItem setAssetName(String assetName) {
		this.assetName=assetName;
		return this;
	}
	
	/**
	 * 获得 设备型号<br>
	 * 设备型号
	 * @return 设备型号
	*/
	public String getAssetModel() {
		return assetModel;
	}
	
	/**
	 * 设置 设备型号
	 * @param assetModel 设备型号
	 * @return 当前对象
	*/
	public CCustInspectItem setAssetModel(String assetModel) {
		this.assetModel=assetModel;
		return this;
	}
	
	/**
	 * 获得 设备序列<br>
	 * 设备序列
	 * @return 设备序列
	*/
	public String getAssetSeq() {
		return assetSeq;
	}
	
	/**
	 * 设置 设备序列
	 * @param assetSeq 设备序列
	 * @return 当前对象
	*/
	public CCustInspectItem setAssetSeq(String assetSeq) {
		this.assetSeq=assetSeq;
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
	public CCustInspectItem setCreateBy(String createBy) {
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
	public CCustInspectItem setCreateTime(Date createTime) {
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
	public CCustInspectItem setUpdateBy(String updateBy) {
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
	public CCustInspectItem setUpdateTime(Date updateTime) {
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
	public CCustInspectItem setDeleted(Integer deleted) {
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
	public CCustInspectItem setDeleted(Boolean deletedBool) {
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
	public CCustInspectItem setDeleteBy(String deleteBy) {
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
	public CCustInspectItem setDeleteTime(Date deleteTime) {
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
	public CCustInspectItem setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 inspectUser<br>
	 * inspectUser
	 * @return inspectUser
	*/
	public Employee getInspectUser() {
		return inspectUser;
	}
	
	/**
	 * 设置 inspectUser
	 * @param inspectUser inspectUser
	 * @return 当前对象
	*/
	public CCustInspectItem setInspectUser(Employee inspectUser) {
		this.inspectUser=inspectUser;
		return this;
	}
	
	/**
	 * 获得 asset<br>
	 * asset
	 * @return asset
	*/
	public Asset getAsset() {
		return asset;
	}
	
	/**
	 * 设置 asset
	 * @param asset asset
	 * @return 当前对象
	*/
	public CCustInspectItem setAsset(Asset asset) {
		this.asset=asset;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return CCustInspectItem , 转换好的 CCustInspectItem 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return CCustInspectItem , 转换好的 PoJo 对象
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
	public CCustInspectItem clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public CCustInspectItem duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.CCustInspectItemMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.CCustInspectItemMeta.$$proxy$$();
		inst.setAssetCode(this.getAssetCode());
		inst.setAssetModel(this.getAssetModel());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setOwnerId(this.getOwnerId());
		inst.setVersion(this.getVersion());
		inst.setAssetSeq(this.getAssetSeq());
		inst.setCt(this.getCt());
		inst.setCreateBy(this.getCreateBy());
		inst.setRecordTime(this.getRecordTime());
		inst.setDeleted(this.getDeleted());
		inst.setPictureId(this.getPictureId());
		inst.setPos(this.getPos());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setAssetName(this.getAssetName());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setInspectUserId(this.getInspectUserId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setInspectUser(this.getInspectUser());
			inst.setAsset(this.getAsset());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public CCustInspectItem clone(boolean deep) {
		return EntityContext.clone(CCustInspectItem.class,this,deep);
	}

	/**
	 * 将 Map 转换成 CCustInspectItem
	 * @param cCustInspectItemMap 包含实体信息的 Map 对象
	 * @return CCustInspectItem , 转换好的的 CCustInspectItem 对象
	*/
	@Transient
	public static CCustInspectItem createFrom(Map<String,Object> cCustInspectItemMap) {
		if(cCustInspectItemMap==null) return null;
		CCustInspectItem po = create();
		EntityContext.copyProperties(po,cCustInspectItemMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 CCustInspectItem
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return CCustInspectItem , 转换好的的 CCustInspectItem 对象
	*/
	@Transient
	public static CCustInspectItem createFrom(Object pojo) {
		if(pojo==null) return null;
		CCustInspectItem po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 CCustInspectItem，等同于 new
	 * @return CCustInspectItem 对象
	*/
	@Transient
	public static CCustInspectItem create() {
		return new com.dt.platform.domain.eam.meta.CCustInspectItemMeta.$$proxy$$();
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
			this.setAssetCode(DataParser.parse(String.class, map.get(CCustInspectItemMeta.ASSET_CODE)));
			this.setAssetModel(DataParser.parse(String.class, map.get(CCustInspectItemMeta.ASSET_MODEL)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(CCustInspectItemMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, map.get(CCustInspectItemMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, map.get(CCustInspectItemMeta.VERSION)));
			this.setAssetSeq(DataParser.parse(String.class, map.get(CCustInspectItemMeta.ASSET_SEQ)));
			this.setCt(DataParser.parse(String.class, map.get(CCustInspectItemMeta.CT)));
			this.setCreateBy(DataParser.parse(String.class, map.get(CCustInspectItemMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, map.get(CCustInspectItemMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(CCustInspectItemMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, map.get(CCustInspectItemMeta.PICTURE_ID)));
			this.setPos(DataParser.parse(String.class, map.get(CCustInspectItemMeta.POS)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(CCustInspectItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(CCustInspectItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(CCustInspectItemMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(CCustInspectItemMeta.ASSET_ID)));
			this.setAssetName(DataParser.parse(String.class, map.get(CCustInspectItemMeta.ASSET_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(CCustInspectItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(CCustInspectItemMeta.ID)));
			this.setInspectUserId(DataParser.parse(String.class, map.get(CCustInspectItemMeta.INSPECT_USER_ID)));
			this.setStatus(DataParser.parse(String.class, map.get(CCustInspectItemMeta.STATUS)));
			// others
			this.setInspectUser(DataParser.parse(Employee.class, map.get(CCustInspectItemMeta.INSPECT_USER)));
			this.setAsset(DataParser.parse(Asset.class, map.get(CCustInspectItemMeta.ASSET)));
			return true;
		} else {
			try {
				this.setAssetCode( (String)map.get(CCustInspectItemMeta.ASSET_CODE));
				this.setAssetModel( (String)map.get(CCustInspectItemMeta.ASSET_MODEL));
				this.setUpdateTime( (Date)map.get(CCustInspectItemMeta.UPDATE_TIME));
				this.setOwnerId( (String)map.get(CCustInspectItemMeta.OWNER_ID));
				this.setVersion( (Integer)map.get(CCustInspectItemMeta.VERSION));
				this.setAssetSeq( (String)map.get(CCustInspectItemMeta.ASSET_SEQ));
				this.setCt( (String)map.get(CCustInspectItemMeta.CT));
				this.setCreateBy( (String)map.get(CCustInspectItemMeta.CREATE_BY));
				this.setRecordTime( (Date)map.get(CCustInspectItemMeta.RECORD_TIME));
				this.setDeleted( (Integer)map.get(CCustInspectItemMeta.DELETED));
				this.setPictureId( (String)map.get(CCustInspectItemMeta.PICTURE_ID));
				this.setPos( (String)map.get(CCustInspectItemMeta.POS));
				this.setCreateTime( (Date)map.get(CCustInspectItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(CCustInspectItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(CCustInspectItemMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(CCustInspectItemMeta.ASSET_ID));
				this.setAssetName( (String)map.get(CCustInspectItemMeta.ASSET_NAME));
				this.setDeleteBy( (String)map.get(CCustInspectItemMeta.DELETE_BY));
				this.setId( (String)map.get(CCustInspectItemMeta.ID));
				this.setInspectUserId( (String)map.get(CCustInspectItemMeta.INSPECT_USER_ID));
				this.setStatus( (String)map.get(CCustInspectItemMeta.STATUS));
				// others
				this.setInspectUser( (Employee)map.get(CCustInspectItemMeta.INSPECT_USER));
				this.setAsset( (Asset)map.get(CCustInspectItemMeta.ASSET));
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
			this.setAssetCode(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.ASSET_CODE)));
			this.setAssetModel(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.ASSET_MODEL)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(CCustInspectItemMeta.UPDATE_TIME)));
			this.setOwnerId(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.OWNER_ID)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(CCustInspectItemMeta.VERSION)));
			this.setAssetSeq(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.ASSET_SEQ)));
			this.setCt(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.CT)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.CREATE_BY)));
			this.setRecordTime(DataParser.parse(Date.class, r.getValue(CCustInspectItemMeta.RECORD_TIME)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(CCustInspectItemMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.PICTURE_ID)));
			this.setPos(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.POS)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(CCustInspectItemMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(CCustInspectItemMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.ASSET_ID)));
			this.setAssetName(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.ASSET_NAME)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.ID)));
			this.setInspectUserId(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.INSPECT_USER_ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(CCustInspectItemMeta.STATUS)));
			return true;
		} else {
			try {
				this.setAssetCode( (String)r.getValue(CCustInspectItemMeta.ASSET_CODE));
				this.setAssetModel( (String)r.getValue(CCustInspectItemMeta.ASSET_MODEL));
				this.setUpdateTime( (Date)r.getValue(CCustInspectItemMeta.UPDATE_TIME));
				this.setOwnerId( (String)r.getValue(CCustInspectItemMeta.OWNER_ID));
				this.setVersion( (Integer)r.getValue(CCustInspectItemMeta.VERSION));
				this.setAssetSeq( (String)r.getValue(CCustInspectItemMeta.ASSET_SEQ));
				this.setCt( (String)r.getValue(CCustInspectItemMeta.CT));
				this.setCreateBy( (String)r.getValue(CCustInspectItemMeta.CREATE_BY));
				this.setRecordTime( (Date)r.getValue(CCustInspectItemMeta.RECORD_TIME));
				this.setDeleted( (Integer)r.getValue(CCustInspectItemMeta.DELETED));
				this.setPictureId( (String)r.getValue(CCustInspectItemMeta.PICTURE_ID));
				this.setPos( (String)r.getValue(CCustInspectItemMeta.POS));
				this.setCreateTime( (Date)r.getValue(CCustInspectItemMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(CCustInspectItemMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(CCustInspectItemMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(CCustInspectItemMeta.ASSET_ID));
				this.setAssetName( (String)r.getValue(CCustInspectItemMeta.ASSET_NAME));
				this.setDeleteBy( (String)r.getValue(CCustInspectItemMeta.DELETE_BY));
				this.setId( (String)r.getValue(CCustInspectItemMeta.ID));
				this.setInspectUserId( (String)r.getValue(CCustInspectItemMeta.INSPECT_USER_ID));
				this.setStatus( (String)r.getValue(CCustInspectItemMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}