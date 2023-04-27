package com.dt.platform.domain.eam;

import com.github.foxnic.dao.entity.Entity;
import io.swagger.annotations.ApiModel;
import javax.persistence.Table;
import com.github.foxnic.sql.meta.DBTable;
import com.dt.platform.constants.db.EAMTables.EAM_INVENTORY_ASSET;
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
import com.dt.platform.domain.eam.meta.InventoryAssetMeta;
import com.github.foxnic.sql.data.ExprRcd;



/**
 * 盘点明细
 * <p>盘点明细 , 数据表 eam_inventory_asset 的PO类型</p>
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-10 19:28:54
 * @sign 7318B9DA33B8B1A8F83D55431F791B28
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

@Table(name = "eam_inventory_asset")
@ApiModel(description = "盘点明细 ; 盘点明细 , 数据表 eam_inventory_asset 的PO类型")
public class InventoryAsset extends Entity {

	private static final long serialVersionUID = 1L;

	public static final DBTable TABLE =EAM_INVENTORY_ASSET.$TABLE;
	
	/**
	 * 主键：主键
	*/
	@Id
	@ApiModelProperty(required = true,value="主键" , notes = "主键" , example = "1c0cf538-5600-11ed-8950-00163e1b60a7")
	private String id;
	
	/**
	 * 盘点：盘点
	*/
	@ApiModelProperty(required = false,value="盘点" , notes = "盘点" , example = "638135645977444352")
	private String inventoryId;
	
	/**
	 * 状态：状态
	*/
	@ApiModelProperty(required = false,value="状态" , notes = "状态" , example = "not_counted")
	private String status;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产" , example = "572681223449608192")
	private String assetId;
	
	/**
	 * 员工：员工
	*/
	@ApiModelProperty(required = false,value="员工" , notes = "员工")
	private String operEmplId;
	
	/**
	 * 盘盈动作：盘盈动作
	*/
	@ApiModelProperty(required = false,value="盘盈动作" , notes = "盘盈动作" , example = "none")
	private String assetPlusActionType;
	
	/**
	 * 盘亏动作：盘亏动作
	*/
	@ApiModelProperty(required = false,value="盘亏动作" , notes = "盘亏动作" , example = "none")
	private String assetLossActionType;
	
	/**
	 * 数据来源：数据来源
	*/
	@ApiModelProperty(required = false,value="数据来源" , notes = "数据来源" , example = "asset")
	private String source;
	
	/**
	 * 标记：标记
	*/
	@ApiModelProperty(required = false,value="标记" , notes = "标记")
	private String flag;
	
	/**
	 * 操作时间：操作时间
	*/
	@ApiModelProperty(required = false,value="操作时间" , notes = "操作时间")
	private Date operDate;
	
	/**
	 * 图片：图片
	*/
	@ApiModelProperty(required = false,value="图片" , notes = "图片")
	private String pictureId;
	
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
	@ApiModelProperty(required = false,value="创建时间" , notes = "创建时间" , example = "2022-10-27 10:03:18")
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
	 * 数据版本号：数据版本号
	*/
	@ApiModelProperty(required = true,value="数据版本号" , notes = "数据版本号" , example = "1")
	private Integer version;
	
	/**
	 * 资产：资产
	*/
	@ApiModelProperty(required = false,value="资产" , notes = "资产")
	private Asset asset;
	
	/**
	 * 操作人员：操作人员
	*/
	@ApiModelProperty(required = false,value="操作人员" , notes = "操作人员")
	private Employee operater;
	
	/**
	 * inventory：inventory
	*/
	@ApiModelProperty(required = false,value="inventory" , notes = "inventory")
	private Inventory inventory;
	
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
	public InventoryAsset setId(String id) {
		this.id=id;
		return this;
	}
	
	/**
	 * 获得 盘点<br>
	 * 盘点
	 * @return 盘点
	*/
	public String getInventoryId() {
		return inventoryId;
	}
	
	/**
	 * 设置 盘点
	 * @param inventoryId 盘点
	 * @return 当前对象
	*/
	public InventoryAsset setInventoryId(String inventoryId) {
		this.inventoryId=inventoryId;
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
	public InventoryAsset setStatus(String status) {
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
	public InventoryAsset setAssetId(String assetId) {
		this.assetId=assetId;
		return this;
	}
	
	/**
	 * 获得 员工<br>
	 * 员工
	 * @return 员工
	*/
	public String getOperEmplId() {
		return operEmplId;
	}
	
	/**
	 * 设置 员工
	 * @param operEmplId 员工
	 * @return 当前对象
	*/
	public InventoryAsset setOperEmplId(String operEmplId) {
		this.operEmplId=operEmplId;
		return this;
	}
	
	/**
	 * 获得 盘盈动作<br>
	 * 盘盈动作
	 * @return 盘盈动作
	*/
	public String getAssetPlusActionType() {
		return assetPlusActionType;
	}
	
	/**
	 * 设置 盘盈动作
	 * @param assetPlusActionType 盘盈动作
	 * @return 当前对象
	*/
	public InventoryAsset setAssetPlusActionType(String assetPlusActionType) {
		this.assetPlusActionType=assetPlusActionType;
		return this;
	}
	
	/**
	 * 获得 盘亏动作<br>
	 * 盘亏动作
	 * @return 盘亏动作
	*/
	public String getAssetLossActionType() {
		return assetLossActionType;
	}
	
	/**
	 * 设置 盘亏动作
	 * @param assetLossActionType 盘亏动作
	 * @return 当前对象
	*/
	public InventoryAsset setAssetLossActionType(String assetLossActionType) {
		this.assetLossActionType=assetLossActionType;
		return this;
	}
	
	/**
	 * 获得 数据来源<br>
	 * 数据来源
	 * @return 数据来源
	*/
	public String getSource() {
		return source;
	}
	
	/**
	 * 设置 数据来源
	 * @param source 数据来源
	 * @return 当前对象
	*/
	public InventoryAsset setSource(String source) {
		this.source=source;
		return this;
	}
	
	/**
	 * 获得 标记<br>
	 * 标记
	 * @return 标记
	*/
	public String getFlag() {
		return flag;
	}
	
	/**
	 * 设置 标记
	 * @param flag 标记
	 * @return 当前对象
	*/
	public InventoryAsset setFlag(String flag) {
		this.flag=flag;
		return this;
	}
	
	/**
	 * 获得 操作时间<br>
	 * 操作时间
	 * @return 操作时间
	*/
	public Date getOperDate() {
		return operDate;
	}
	
	/**
	 * 设置 操作时间
	 * @param operDate 操作时间
	 * @return 当前对象
	*/
	public InventoryAsset setOperDate(Date operDate) {
		this.operDate=operDate;
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
	public InventoryAsset setPictureId(String pictureId) {
		this.pictureId=pictureId;
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
	public InventoryAsset setNotes(String notes) {
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
	public InventoryAsset setCreateBy(String createBy) {
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
	public InventoryAsset setCreateTime(Date createTime) {
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
	public InventoryAsset setUpdateBy(String updateBy) {
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
	public InventoryAsset setUpdateTime(Date updateTime) {
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
	public InventoryAsset setDeleted(Integer deleted) {
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
	public InventoryAsset setDeleted(Boolean deletedBool) {
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
	public InventoryAsset setDeleteBy(String deleteBy) {
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
	public InventoryAsset setDeleteTime(Date deleteTime) {
		this.deleteTime=deleteTime;
		return this;
	}
	
	/**
	 * 获得 数据版本号<br>
	 * 数据版本号
	 * @return 数据版本号
	*/
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 设置 数据版本号
	 * @param version 数据版本号
	 * @return 当前对象
	*/
	public InventoryAsset setVersion(Integer version) {
		this.version=version;
		return this;
	}
	
	/**
	 * 获得 资产<br>
	 * 资产
	 * @return 资产
	*/
	public Asset getAsset() {
		return asset;
	}
	
	/**
	 * 设置 资产
	 * @param asset 资产
	 * @return 当前对象
	*/
	public InventoryAsset setAsset(Asset asset) {
		this.asset=asset;
		return this;
	}
	
	/**
	 * 获得 操作人员<br>
	 * 操作人员
	 * @return 操作人员
	*/
	public Employee getOperater() {
		return operater;
	}
	
	/**
	 * 设置 操作人员
	 * @param operater 操作人员
	 * @return 当前对象
	*/
	public InventoryAsset setOperater(Employee operater) {
		this.operater=operater;
		return this;
	}
	
	/**
	 * 获得 inventory<br>
	 * inventory
	 * @return inventory
	*/
	public Inventory getInventory() {
		return inventory;
	}
	
	/**
	 * 设置 inventory
	 * @param inventory inventory
	 * @return 当前对象
	*/
	public InventoryAsset setInventory(Inventory inventory) {
		this.inventory=inventory;
		return this;
	}

	/**
	 * 将自己转换成指定类型的PO
	 * @param poType  PO类型
	 * @return InventoryAsset , 转换好的 InventoryAsset 对象
	*/
	@Transient
	public <T extends Entity> T toPO(Class<T> poType) {
		return EntityContext.create(poType, this);
	}

	/**
	 * 将自己转换成任意指定类型
	 * @param pojoType  Pojo类型
	 * @return InventoryAsset , 转换好的 PoJo 对象
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
	public InventoryAsset clone() {
		return duplicate(true);
	}

	/**
	 * 复制当前对象
	 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
	*/
	@Transient
	public InventoryAsset duplicate(boolean all) {
		com.dt.platform.domain.eam.meta.InventoryAssetMeta.$$proxy$$ inst = new com.dt.platform.domain.eam.meta.InventoryAssetMeta.$$proxy$$();
		inst.setAssetLossActionType(this.getAssetLossActionType());
		inst.setOperDate(this.getOperDate());
		inst.setFlag(this.getFlag());
		inst.setNotes(this.getNotes());
		inst.setUpdateTime(this.getUpdateTime());
		inst.setSource(this.getSource());
		inst.setVersion(this.getVersion());
		inst.setAssetPlusActionType(this.getAssetPlusActionType());
		inst.setCreateBy(this.getCreateBy());
		inst.setDeleted(this.getDeleted());
		inst.setPictureId(this.getPictureId());
		inst.setOperEmplId(this.getOperEmplId());
		inst.setCreateTime(this.getCreateTime());
		inst.setUpdateBy(this.getUpdateBy());
		inst.setDeleteTime(this.getDeleteTime());
		inst.setAssetId(this.getAssetId());
		inst.setInventoryId(this.getInventoryId());
		inst.setDeleteBy(this.getDeleteBy());
		inst.setId(this.getId());
		inst.setStatus(this.getStatus());
		if(all) {
			inst.setOperater(this.getOperater());
			inst.setAsset(this.getAsset());
			inst.setInventory(this.getInventory());
		}
		inst.clearModifies();
		return inst;
	}

	/**
	 * 克隆当前对象
	*/
	@Transient
	public InventoryAsset clone(boolean deep) {
		return EntityContext.clone(InventoryAsset.class,this,deep);
	}

	/**
	 * 将 Map 转换成 InventoryAsset
	 * @param inventoryAssetMap 包含实体信息的 Map 对象
	 * @return InventoryAsset , 转换好的的 InventoryAsset 对象
	*/
	@Transient
	public static InventoryAsset createFrom(Map<String,Object> inventoryAssetMap) {
		if(inventoryAssetMap==null) return null;
		InventoryAsset po = create();
		EntityContext.copyProperties(po,inventoryAssetMap);
		po.clearModifies();
		return po;
	}

	/**
	 * 将 Pojo 转换成 InventoryAsset
	 * @param pojo 包含实体信息的 Pojo 对象
	 * @return InventoryAsset , 转换好的的 InventoryAsset 对象
	*/
	@Transient
	public static InventoryAsset createFrom(Object pojo) {
		if(pojo==null) return null;
		InventoryAsset po = create();
		EntityContext.copyProperties(po,pojo);
		po.clearModifies();
		return po;
	}

	/**
	 * 创建一个 InventoryAsset，等同于 new
	 * @return InventoryAsset 对象
	*/
	@Transient
	public static InventoryAsset create() {
		return new com.dt.platform.domain.eam.meta.InventoryAssetMeta.$$proxy$$();
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
			this.setAssetLossActionType(DataParser.parse(String.class, map.get(InventoryAssetMeta.ASSET_LOSS_ACTION_TYPE)));
			this.setOperDate(DataParser.parse(Date.class, map.get(InventoryAssetMeta.OPER_DATE)));
			this.setFlag(DataParser.parse(String.class, map.get(InventoryAssetMeta.FLAG)));
			this.setNotes(DataParser.parse(String.class, map.get(InventoryAssetMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, map.get(InventoryAssetMeta.UPDATE_TIME)));
			this.setSource(DataParser.parse(String.class, map.get(InventoryAssetMeta.SOURCE)));
			this.setVersion(DataParser.parse(Integer.class, map.get(InventoryAssetMeta.VERSION)));
			this.setAssetPlusActionType(DataParser.parse(String.class, map.get(InventoryAssetMeta.ASSET_PLUS_ACTION_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, map.get(InventoryAssetMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, map.get(InventoryAssetMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, map.get(InventoryAssetMeta.PICTURE_ID)));
			this.setOperEmplId(DataParser.parse(String.class, map.get(InventoryAssetMeta.OPER_EMPL_ID)));
			this.setCreateTime(DataParser.parse(Date.class, map.get(InventoryAssetMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, map.get(InventoryAssetMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, map.get(InventoryAssetMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, map.get(InventoryAssetMeta.ASSET_ID)));
			this.setInventoryId(DataParser.parse(String.class, map.get(InventoryAssetMeta.INVENTORY_ID)));
			this.setDeleteBy(DataParser.parse(String.class, map.get(InventoryAssetMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, map.get(InventoryAssetMeta.ID)));
			this.setStatus(DataParser.parse(String.class, map.get(InventoryAssetMeta.STATUS)));
			// others
			this.setOperater(DataParser.parse(Employee.class, map.get(InventoryAssetMeta.OPERATER)));
			this.setAsset(DataParser.parse(Asset.class, map.get(InventoryAssetMeta.ASSET)));
			this.setInventory(DataParser.parse(Inventory.class, map.get(InventoryAssetMeta.INVENTORY)));
			return true;
		} else {
			try {
				this.setAssetLossActionType( (String)map.get(InventoryAssetMeta.ASSET_LOSS_ACTION_TYPE));
				this.setOperDate( (Date)map.get(InventoryAssetMeta.OPER_DATE));
				this.setFlag( (String)map.get(InventoryAssetMeta.FLAG));
				this.setNotes( (String)map.get(InventoryAssetMeta.NOTES));
				this.setUpdateTime( (Date)map.get(InventoryAssetMeta.UPDATE_TIME));
				this.setSource( (String)map.get(InventoryAssetMeta.SOURCE));
				this.setVersion( (Integer)map.get(InventoryAssetMeta.VERSION));
				this.setAssetPlusActionType( (String)map.get(InventoryAssetMeta.ASSET_PLUS_ACTION_TYPE));
				this.setCreateBy( (String)map.get(InventoryAssetMeta.CREATE_BY));
				this.setDeleted( (Integer)map.get(InventoryAssetMeta.DELETED));
				this.setPictureId( (String)map.get(InventoryAssetMeta.PICTURE_ID));
				this.setOperEmplId( (String)map.get(InventoryAssetMeta.OPER_EMPL_ID));
				this.setCreateTime( (Date)map.get(InventoryAssetMeta.CREATE_TIME));
				this.setUpdateBy( (String)map.get(InventoryAssetMeta.UPDATE_BY));
				this.setDeleteTime( (Date)map.get(InventoryAssetMeta.DELETE_TIME));
				this.setAssetId( (String)map.get(InventoryAssetMeta.ASSET_ID));
				this.setInventoryId( (String)map.get(InventoryAssetMeta.INVENTORY_ID));
				this.setDeleteBy( (String)map.get(InventoryAssetMeta.DELETE_BY));
				this.setId( (String)map.get(InventoryAssetMeta.ID));
				this.setStatus( (String)map.get(InventoryAssetMeta.STATUS));
				// others
				this.setOperater( (Employee)map.get(InventoryAssetMeta.OPERATER));
				this.setAsset( (Asset)map.get(InventoryAssetMeta.ASSET));
				this.setInventory( (Inventory)map.get(InventoryAssetMeta.INVENTORY));
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
			this.setAssetLossActionType(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.ASSET_LOSS_ACTION_TYPE)));
			this.setOperDate(DataParser.parse(Date.class, r.getValue(InventoryAssetMeta.OPER_DATE)));
			this.setFlag(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.FLAG)));
			this.setNotes(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.NOTES)));
			this.setUpdateTime(DataParser.parse(Date.class, r.getValue(InventoryAssetMeta.UPDATE_TIME)));
			this.setSource(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.SOURCE)));
			this.setVersion(DataParser.parse(Integer.class, r.getValue(InventoryAssetMeta.VERSION)));
			this.setAssetPlusActionType(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.ASSET_PLUS_ACTION_TYPE)));
			this.setCreateBy(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.CREATE_BY)));
			this.setDeleted(DataParser.parse(Integer.class, r.getValue(InventoryAssetMeta.DELETED)));
			this.setPictureId(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.PICTURE_ID)));
			this.setOperEmplId(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.OPER_EMPL_ID)));
			this.setCreateTime(DataParser.parse(Date.class, r.getValue(InventoryAssetMeta.CREATE_TIME)));
			this.setUpdateBy(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.UPDATE_BY)));
			this.setDeleteTime(DataParser.parse(Date.class, r.getValue(InventoryAssetMeta.DELETE_TIME)));
			this.setAssetId(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.ASSET_ID)));
			this.setInventoryId(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.INVENTORY_ID)));
			this.setDeleteBy(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.DELETE_BY)));
			this.setId(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.ID)));
			this.setStatus(DataParser.parse(String.class, r.getValue(InventoryAssetMeta.STATUS)));
			return true;
		} else {
			try {
				this.setAssetLossActionType( (String)r.getValue(InventoryAssetMeta.ASSET_LOSS_ACTION_TYPE));
				this.setOperDate( (Date)r.getValue(InventoryAssetMeta.OPER_DATE));
				this.setFlag( (String)r.getValue(InventoryAssetMeta.FLAG));
				this.setNotes( (String)r.getValue(InventoryAssetMeta.NOTES));
				this.setUpdateTime( (Date)r.getValue(InventoryAssetMeta.UPDATE_TIME));
				this.setSource( (String)r.getValue(InventoryAssetMeta.SOURCE));
				this.setVersion( (Integer)r.getValue(InventoryAssetMeta.VERSION));
				this.setAssetPlusActionType( (String)r.getValue(InventoryAssetMeta.ASSET_PLUS_ACTION_TYPE));
				this.setCreateBy( (String)r.getValue(InventoryAssetMeta.CREATE_BY));
				this.setDeleted( (Integer)r.getValue(InventoryAssetMeta.DELETED));
				this.setPictureId( (String)r.getValue(InventoryAssetMeta.PICTURE_ID));
				this.setOperEmplId( (String)r.getValue(InventoryAssetMeta.OPER_EMPL_ID));
				this.setCreateTime( (Date)r.getValue(InventoryAssetMeta.CREATE_TIME));
				this.setUpdateBy( (String)r.getValue(InventoryAssetMeta.UPDATE_BY));
				this.setDeleteTime( (Date)r.getValue(InventoryAssetMeta.DELETE_TIME));
				this.setAssetId( (String)r.getValue(InventoryAssetMeta.ASSET_ID));
				this.setInventoryId( (String)r.getValue(InventoryAssetMeta.INVENTORY_ID));
				this.setDeleteBy( (String)r.getValue(InventoryAssetMeta.DELETE_BY));
				this.setId( (String)r.getValue(InventoryAssetMeta.ID));
				this.setStatus( (String)r.getValue(InventoryAssetMeta.STATUS));
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
}