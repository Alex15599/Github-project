package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.InventoryAsset;
import java.util.Date;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Inventory;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-10 19:28:54
 * @sign 7318B9DA33B8B1A8F83D55431F791B28
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class InventoryAssetMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 盘点 , 类型: java.lang.String
	*/
	public static final String INVENTORY_ID="inventoryId";
	
	/**
	 * 盘点 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> INVENTORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,INVENTORY_ID, java.lang.String.class, "盘点", "盘点", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,ASSET_ID, java.lang.String.class, "资产", "资产", java.lang.String.class, null);
	
	/**
	 * 员工 , 类型: java.lang.String
	*/
	public static final String OPER_EMPL_ID="operEmplId";
	
	/**
	 * 员工 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> OPER_EMPL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,OPER_EMPL_ID, java.lang.String.class, "员工", "员工", java.lang.String.class, null);
	
	/**
	 * 盘盈动作 , 类型: java.lang.String
	*/
	public static final String ASSET_PLUS_ACTION_TYPE="assetPlusActionType";
	
	/**
	 * 盘盈动作 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> ASSET_PLUS_ACTION_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,ASSET_PLUS_ACTION_TYPE, java.lang.String.class, "盘盈动作", "盘盈动作", java.lang.String.class, null);
	
	/**
	 * 盘亏动作 , 类型: java.lang.String
	*/
	public static final String ASSET_LOSS_ACTION_TYPE="assetLossActionType";
	
	/**
	 * 盘亏动作 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> ASSET_LOSS_ACTION_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,ASSET_LOSS_ACTION_TYPE, java.lang.String.class, "盘亏动作", "盘亏动作", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 类型: java.lang.String
	*/
	public static final String SOURCE="source";
	
	/**
	 * 数据来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,SOURCE, java.lang.String.class, "数据来源", "数据来源", java.lang.String.class, null);
	
	/**
	 * 标记 , 类型: java.lang.String
	*/
	public static final String FLAG="flag";
	
	/**
	 * 标记 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> FLAG_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,FLAG, java.lang.String.class, "标记", "标记", java.lang.String.class, null);
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final String OPER_DATE="operDate";
	
	/**
	 * 操作时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.util.Date> OPER_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,OPER_DATE, java.util.Date.class, "操作时间", "操作时间", java.util.Date.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,PICTURE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET="asset";
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,com.dt.platform.domain.eam.Asset> ASSET_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,ASSET, com.dt.platform.domain.eam.Asset.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 操作人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String OPERATER="operater";
	
	/**
	 * 操作人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,org.github.foxnic.web.domain.hrm.Employee> OPERATER_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,OPERATER, org.github.foxnic.web.domain.hrm.Employee.class, "操作人员", "操作人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * inventory , 类型: com.dt.platform.domain.eam.Inventory
	*/
	public static final String INVENTORY="inventory";
	
	/**
	 * inventory , 类型: com.dt.platform.domain.eam.Inventory
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.InventoryAsset,com.dt.platform.domain.eam.Inventory> INVENTORY_PROP = new BeanProperty(com.dt.platform.domain.eam.InventoryAsset.class ,INVENTORY, com.dt.platform.domain.eam.Inventory.class, "inventory", "inventory", com.dt.platform.domain.eam.Inventory.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , INVENTORY_ID , STATUS , ASSET_ID , OPER_EMPL_ID , ASSET_PLUS_ACTION_TYPE , ASSET_LOSS_ACTION_TYPE , SOURCE , FLAG , OPER_DATE , PICTURE_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ASSET , OPERATER , INVENTORY };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.InventoryAsset {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public InventoryAsset setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 盘点
		 * @param inventoryId 盘点
		 * @return 当前对象
		*/
		public InventoryAsset setInventoryId(String inventoryId) {
			super.change(INVENTORY_ID,super.getInventoryId(),inventoryId);
			super.setInventoryId(inventoryId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public InventoryAsset setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetId 资产
		 * @return 当前对象
		*/
		public InventoryAsset setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 员工
		 * @param operEmplId 员工
		 * @return 当前对象
		*/
		public InventoryAsset setOperEmplId(String operEmplId) {
			super.change(OPER_EMPL_ID,super.getOperEmplId(),operEmplId);
			super.setOperEmplId(operEmplId);
			return this;
		}
		
		/**
		 * 设置 盘盈动作
		 * @param assetPlusActionType 盘盈动作
		 * @return 当前对象
		*/
		public InventoryAsset setAssetPlusActionType(String assetPlusActionType) {
			super.change(ASSET_PLUS_ACTION_TYPE,super.getAssetPlusActionType(),assetPlusActionType);
			super.setAssetPlusActionType(assetPlusActionType);
			return this;
		}
		
		/**
		 * 设置 盘亏动作
		 * @param assetLossActionType 盘亏动作
		 * @return 当前对象
		*/
		public InventoryAsset setAssetLossActionType(String assetLossActionType) {
			super.change(ASSET_LOSS_ACTION_TYPE,super.getAssetLossActionType(),assetLossActionType);
			super.setAssetLossActionType(assetLossActionType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param source 数据来源
		 * @return 当前对象
		*/
		public InventoryAsset setSource(String source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 标记
		 * @param flag 标记
		 * @return 当前对象
		*/
		public InventoryAsset setFlag(String flag) {
			super.change(FLAG,super.getFlag(),flag);
			super.setFlag(flag);
			return this;
		}
		
		/**
		 * 设置 操作时间
		 * @param operDate 操作时间
		 * @return 当前对象
		*/
		public InventoryAsset setOperDate(Date operDate) {
			super.change(OPER_DATE,super.getOperDate(),operDate);
			super.setOperDate(operDate);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictureId 图片
		 * @return 当前对象
		*/
		public InventoryAsset setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public InventoryAsset setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public InventoryAsset setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public InventoryAsset setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public InventoryAsset setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public InventoryAsset setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public InventoryAsset setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public InventoryAsset setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public InventoryAsset setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public InventoryAsset setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param asset 资产
		 * @return 当前对象
		*/
		public InventoryAsset setAsset(Asset asset) {
			super.change(ASSET,super.getAsset(),asset);
			super.setAsset(asset);
			return this;
		}
		
		/**
		 * 设置 操作人员
		 * @param operater 操作人员
		 * @return 当前对象
		*/
		public InventoryAsset setOperater(Employee operater) {
			super.change(OPERATER,super.getOperater(),operater);
			super.setOperater(operater);
			return this;
		}
		
		/**
		 * 设置 inventory
		 * @param inventory inventory
		 * @return 当前对象
		*/
		public InventoryAsset setInventory(Inventory inventory) {
			super.change(INVENTORY,super.getInventory(),inventory);
			super.setInventory(inventory);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}