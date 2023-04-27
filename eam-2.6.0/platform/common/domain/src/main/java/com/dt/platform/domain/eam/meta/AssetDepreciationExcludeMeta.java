package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetDepreciationExclude;
import java.util.Date;
import com.dt.platform.domain.eam.AssetDepreciation;
import com.dt.platform.domain.eam.Asset;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-28 20:42:05
 * @sign D4BE7365B29CEE64D914AC37CB332BC9
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetDepreciationExcludeMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,ASSET_ID, java.lang.String.class, "资产", "资产", java.lang.String.class, null);
	
	/**
	 * 折旧方案 , 类型: java.lang.String
	*/
	public static final String DEPRECIATION_ID="depreciationId";
	
	/**
	 * 折旧方案 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.lang.String> DEPRECIATION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,DEPRECIATION_ID, java.lang.String.class, "折旧方案", "折旧方案", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 方案 , 类型: com.dt.platform.domain.eam.AssetDepreciation
	*/
	public static final String ASSET_DEPRECIATION="assetDepreciation";
	
	/**
	 * 方案 , 类型: com.dt.platform.domain.eam.AssetDepreciation
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,com.dt.platform.domain.eam.AssetDepreciation> ASSET_DEPRECIATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,ASSET_DEPRECIATION, com.dt.platform.domain.eam.AssetDepreciation.class, "方案", "方案", com.dt.platform.domain.eam.AssetDepreciation.class, null);
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET="asset";
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,com.dt.platform.domain.eam.Asset> ASSET_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,ASSET, com.dt.platform.domain.eam.Asset.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * assetCode , 类型: java.lang.String
	*/
	public static final String ASSET_CODE="assetCode";
	
	/**
	 * assetCode , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.lang.String> ASSET_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,ASSET_CODE, java.lang.String.class, "assetCode", "assetCode", java.lang.String.class, null);
	
	/**
	 * assetName , 类型: java.lang.String
	*/
	public static final String ASSET_NAME="assetName";
	
	/**
	 * assetName , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.lang.String> ASSET_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,ASSET_NAME, java.lang.String.class, "assetName", "assetName", java.lang.String.class, null);
	
	/**
	 * assetModel , 类型: java.lang.String
	*/
	public static final String ASSET_MODEL="assetModel";
	
	/**
	 * assetModel , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationExclude,java.lang.String> ASSET_MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationExclude.class ,ASSET_MODEL, java.lang.String.class, "assetModel", "assetModel", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ASSET_ID , DEPRECIATION_ID , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , ASSET_DEPRECIATION , ASSET , ASSET_CODE , ASSET_NAME , ASSET_MODEL };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetDepreciationExclude {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetId 资产
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 折旧方案
		 * @param depreciationId 折旧方案
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setDepreciationId(String depreciationId) {
			super.change(DEPRECIATION_ID,super.getDepreciationId(),depreciationId);
			super.setDepreciationId(depreciationId);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 方案
		 * @param assetDepreciation 方案
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setAssetDepreciation(AssetDepreciation assetDepreciation) {
			super.change(ASSET_DEPRECIATION,super.getAssetDepreciation(),assetDepreciation);
			super.setAssetDepreciation(assetDepreciation);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param asset 资产
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setAsset(Asset asset) {
			super.change(ASSET,super.getAsset(),asset);
			super.setAsset(asset);
			return this;
		}
		
		/**
		 * 设置 assetCode
		 * @param assetCode assetCode
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setAssetCode(String assetCode) {
			super.change(ASSET_CODE,super.getAssetCode(),assetCode);
			super.setAssetCode(assetCode);
			return this;
		}
		
		/**
		 * 设置 assetName
		 * @param assetName assetName
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setAssetName(String assetName) {
			super.change(ASSET_NAME,super.getAssetName(),assetName);
			super.setAssetName(assetName);
			return this;
		}
		
		/**
		 * 设置 assetModel
		 * @param assetModel assetModel
		 * @return 当前对象
		*/
		public AssetDepreciationExclude setAssetModel(String assetModel) {
			super.change(ASSET_MODEL,super.getAssetModel(),assetModel);
			super.setAssetModel(assetModel);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetDepreciationExclude clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetDepreciationExclude duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setDepreciationId(this.getDepreciationId());
			inst.setCreateBy(this.getCreateBy());
			inst.setNotes(this.getNotes());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setAssetId(this.getAssetId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setId(this.getId());
			inst.setVersion(this.getVersion());
			if(all) {
				inst.setAssetCode(this.getAssetCode());
				inst.setAssetModel(this.getAssetModel());
				inst.setAssetName(this.getAssetName());
				inst.setAsset(this.getAsset());
				inst.setAssetDepreciation(this.getAssetDepreciation());
			}
			inst.clearModifies();
			return inst;
		}

	}
}