package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetItem;
import java.util.Date;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-13 18:13:51
 * @sign 18FABF07026DC9BABF26484FC1156091
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetItemMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 处理 , 类型: java.lang.String
	*/
	public static final String HANDLE_ID="handleId";
	
	/**
	 * 处理 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.lang.String> HANDLE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,HANDLE_ID, java.lang.String.class, "处理", "处理", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,ASSET_ID, java.lang.String.class, "资产", "资产", java.lang.String.class, null);
	
	/**
	 * 资产使用人 , 类型: java.lang.String
	*/
	public static final String BEFORE_USE_USER_ID="beforeUseUserId";
	
	/**
	 * 资产使用人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.lang.String> BEFORE_USE_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,BEFORE_USE_USER_ID, java.lang.String.class, "资产使用人", "资产使用人", java.lang.String.class, null);
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final String BEFORE_ASSET_STATUS="beforeAssetStatus";
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.lang.String> BEFORE_ASSET_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,BEFORE_ASSET_STATUS, java.lang.String.class, "资产状态", "资产状态", java.lang.String.class, null);
	
	/**
	 * 标记 , 类型: java.lang.String
	*/
	public static final String FLAG="flag";
	
	/**
	 * 标记 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.lang.String> FLAG_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,FLAG, java.lang.String.class, "标记", "标记", java.lang.String.class, null);
	
	/**
	 * 修改标记 , 类型: java.lang.String
	*/
	public static final String CRD="crd";
	
	/**
	 * 修改标记 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.lang.String> CRD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,CRD, java.lang.String.class, "修改标记", "修改标记", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetItem,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetItem.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , HANDLE_ID , ASSET_ID , BEFORE_USE_USER_ID , BEFORE_ASSET_STATUS , FLAG , CRD , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , SELECTED_CODE , VERSION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetItem {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetItem setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 处理
		 * @param handleId 处理
		 * @return 当前对象
		*/
		public AssetItem setHandleId(String handleId) {
			super.change(HANDLE_ID,super.getHandleId(),handleId);
			super.setHandleId(handleId);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetId 资产
		 * @return 当前对象
		*/
		public AssetItem setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 资产使用人
		 * @param beforeUseUserId 资产使用人
		 * @return 当前对象
		*/
		public AssetItem setBeforeUseUserId(String beforeUseUserId) {
			super.change(BEFORE_USE_USER_ID,super.getBeforeUseUserId(),beforeUseUserId);
			super.setBeforeUseUserId(beforeUseUserId);
			return this;
		}
		
		/**
		 * 设置 资产状态
		 * @param beforeAssetStatus 资产状态
		 * @return 当前对象
		*/
		public AssetItem setBeforeAssetStatus(String beforeAssetStatus) {
			super.change(BEFORE_ASSET_STATUS,super.getBeforeAssetStatus(),beforeAssetStatus);
			super.setBeforeAssetStatus(beforeAssetStatus);
			return this;
		}
		
		/**
		 * 设置 标记
		 * @param flag 标记
		 * @return 当前对象
		*/
		public AssetItem setFlag(String flag) {
			super.change(FLAG,super.getFlag(),flag);
			super.setFlag(flag);
			return this;
		}
		
		/**
		 * 设置 修改标记
		 * @param crd 修改标记
		 * @return 当前对象
		*/
		public AssetItem setCrd(String crd) {
			super.change(CRD,super.getCrd(),crd);
			super.setCrd(crd);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetItem setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetItem setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetItem setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetItem setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetItem setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetItem setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetItem setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public AssetItem setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetItem setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetItem clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetItem duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setBeforeAssetStatus(this.getBeforeAssetStatus());
			inst.setFlag(this.getFlag());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCrd(this.getCrd());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAssetId(this.getAssetId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setHandleId(this.getHandleId());
			inst.setBeforeUseUserId(this.getBeforeUseUserId());
			inst.clearModifies();
			return inst;
		}

	}
}