package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.CCustInspectItem;
import java.util.Date;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Asset;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-04-09 16:39:30
 * @sign 1F420D583353F841779A8C89D213F2BF
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class CCustInspectItemMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final String OWNER_ID="ownerId";
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> OWNER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,OWNER_ID, java.lang.String.class, "归属", "归属", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,ASSET_ID, java.lang.String.class, "资产", "资产", java.lang.String.class, null);
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,PICTURE_ID, java.lang.String.class, "图片", "图片", java.lang.String.class, null);
	
	/**
	 * 巡检人 , 类型: java.lang.String
	*/
	public static final String INSPECT_USER_ID="inspectUserId";
	
	/**
	 * 巡检人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> INSPECT_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,INSPECT_USER_ID, java.lang.String.class, "巡检人", "巡检人", java.lang.String.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String RECORD_TIME="recordTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.util.Date> RECORD_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,RECORD_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final String CT="ct";
	
	/**
	 * 内容 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> CT_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,CT, java.lang.String.class, "内容", "内容", java.lang.String.class, null);
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final String POS="pos";
	
	/**
	 * 位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> POS_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,POS, java.lang.String.class, "位置", "位置", java.lang.String.class, null);
	
	/**
	 * 设备编号 , 类型: java.lang.String
	*/
	public static final String ASSET_CODE="assetCode";
	
	/**
	 * 设备编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> ASSET_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,ASSET_CODE, java.lang.String.class, "设备编号", "设备编号", java.lang.String.class, null);
	
	/**
	 * 设备名称 , 类型: java.lang.String
	*/
	public static final String ASSET_NAME="assetName";
	
	/**
	 * 设备名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> ASSET_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,ASSET_NAME, java.lang.String.class, "设备名称", "设备名称", java.lang.String.class, null);
	
	/**
	 * 设备型号 , 类型: java.lang.String
	*/
	public static final String ASSET_MODEL="assetModel";
	
	/**
	 * 设备型号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> ASSET_MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,ASSET_MODEL, java.lang.String.class, "设备型号", "设备型号", java.lang.String.class, null);
	
	/**
	 * 设备序列 , 类型: java.lang.String
	*/
	public static final String ASSET_SEQ="assetSeq";
	
	/**
	 * 设备序列 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> ASSET_SEQ_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,ASSET_SEQ, java.lang.String.class, "设备序列", "设备序列", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * inspectUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String INSPECT_USER="inspectUser";
	
	/**
	 * inspectUser , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,org.github.foxnic.web.domain.hrm.Employee> INSPECT_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,INSPECT_USER, org.github.foxnic.web.domain.hrm.Employee.class, "inspectUser", "inspectUser", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * asset , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET="asset";
	
	/**
	 * asset , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.CCustInspectItem,com.dt.platform.domain.eam.Asset> ASSET_PROP = new BeanProperty(com.dt.platform.domain.eam.CCustInspectItem.class ,ASSET, com.dt.platform.domain.eam.Asset.class, "asset", "asset", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , OWNER_ID , STATUS , ASSET_ID , PICTURE_ID , INSPECT_USER_ID , RECORD_TIME , CT , POS , ASSET_CODE , ASSET_NAME , ASSET_MODEL , ASSET_SEQ , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , INSPECT_USER , ASSET };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.CCustInspectItem {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public CCustInspectItem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 归属
		 * @param ownerId 归属
		 * @return 当前对象
		*/
		public CCustInspectItem setOwnerId(String ownerId) {
			super.change(OWNER_ID,super.getOwnerId(),ownerId);
			super.setOwnerId(ownerId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public CCustInspectItem setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetId 资产
		 * @return 当前对象
		*/
		public CCustInspectItem setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 图片
		 * @param pictureId 图片
		 * @return 当前对象
		*/
		public CCustInspectItem setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 巡检人
		 * @param inspectUserId 巡检人
		 * @return 当前对象
		*/
		public CCustInspectItem setInspectUserId(String inspectUserId) {
			super.change(INSPECT_USER_ID,super.getInspectUserId(),inspectUserId);
			super.setInspectUserId(inspectUserId);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param recordTime 记录时间
		 * @return 当前对象
		*/
		public CCustInspectItem setRecordTime(Date recordTime) {
			super.change(RECORD_TIME,super.getRecordTime(),recordTime);
			super.setRecordTime(recordTime);
			return this;
		}
		
		/**
		 * 设置 内容
		 * @param ct 内容
		 * @return 当前对象
		*/
		public CCustInspectItem setCt(String ct) {
			super.change(CT,super.getCt(),ct);
			super.setCt(ct);
			return this;
		}
		
		/**
		 * 设置 位置
		 * @param pos 位置
		 * @return 当前对象
		*/
		public CCustInspectItem setPos(String pos) {
			super.change(POS,super.getPos(),pos);
			super.setPos(pos);
			return this;
		}
		
		/**
		 * 设置 设备编号
		 * @param assetCode 设备编号
		 * @return 当前对象
		*/
		public CCustInspectItem setAssetCode(String assetCode) {
			super.change(ASSET_CODE,super.getAssetCode(),assetCode);
			super.setAssetCode(assetCode);
			return this;
		}
		
		/**
		 * 设置 设备名称
		 * @param assetName 设备名称
		 * @return 当前对象
		*/
		public CCustInspectItem setAssetName(String assetName) {
			super.change(ASSET_NAME,super.getAssetName(),assetName);
			super.setAssetName(assetName);
			return this;
		}
		
		/**
		 * 设置 设备型号
		 * @param assetModel 设备型号
		 * @return 当前对象
		*/
		public CCustInspectItem setAssetModel(String assetModel) {
			super.change(ASSET_MODEL,super.getAssetModel(),assetModel);
			super.setAssetModel(assetModel);
			return this;
		}
		
		/**
		 * 设置 设备序列
		 * @param assetSeq 设备序列
		 * @return 当前对象
		*/
		public CCustInspectItem setAssetSeq(String assetSeq) {
			super.change(ASSET_SEQ,super.getAssetSeq(),assetSeq);
			super.setAssetSeq(assetSeq);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public CCustInspectItem setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public CCustInspectItem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public CCustInspectItem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public CCustInspectItem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public CCustInspectItem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public CCustInspectItem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public CCustInspectItem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public CCustInspectItem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 inspectUser
		 * @param inspectUser inspectUser
		 * @return 当前对象
		*/
		public CCustInspectItem setInspectUser(Employee inspectUser) {
			super.change(INSPECT_USER,super.getInspectUser(),inspectUser);
			super.setInspectUser(inspectUser);
			return this;
		}
		
		/**
		 * 设置 asset
		 * @param asset asset
		 * @return 当前对象
		*/
		public CCustInspectItem setAsset(Asset asset) {
			super.change(ASSET,super.getAsset(),asset);
			super.setAsset(asset);
			return this;
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
			$$proxy$$ inst=new $$proxy$$();
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

	}
}