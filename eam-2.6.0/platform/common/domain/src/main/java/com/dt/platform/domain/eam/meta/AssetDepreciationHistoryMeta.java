package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetDepreciationHistory;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.hrm.Employee;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-07-04 17:13:19
 * @sign 7F3299A5A79521211664F4C68D688206
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetDepreciationHistoryMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final String ASSET_ID="assetId";
	
	/**
	 * 资产 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.String> ASSET_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,ASSET_ID, java.lang.String.class, "资产", "资产", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 资产编号 , 类型: java.lang.String
	*/
	public static final String ASSET_CODE="assetCode";
	
	/**
	 * 资产编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.String> ASSET_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,ASSET_CODE, java.lang.String.class, "资产编号", "资产编号", java.lang.String.class, null);
	
	/**
	 * 折旧方式 , 类型: java.lang.String
	*/
	public static final String DEPRECIATION_METHOD="depreciationMethod";
	
	/**
	 * 折旧方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.String> DEPRECIATION_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,DEPRECIATION_METHOD, java.lang.String.class, "折旧方式", "折旧方式", java.lang.String.class, null);
	
	/**
	 * 资产原值 , 类型: java.math.BigDecimal
	*/
	public static final String ORIGINAL_UNIT_PRICE="originalUnitPrice";
	
	/**
	 * 资产原值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.math.BigDecimal> ORIGINAL_UNIT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,ORIGINAL_UNIT_PRICE, java.math.BigDecimal.class, "资产原值", "资产原值", java.math.BigDecimal.class, null);
	
	/**
	 * 折旧前价格 , 类型: java.math.BigDecimal
	*/
	public static final String BEFORE_PRICE="beforePrice";
	
	/**
	 * 折旧前价格 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.math.BigDecimal> BEFORE_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,BEFORE_PRICE, java.math.BigDecimal.class, "折旧前价格", "折旧前价格", java.math.BigDecimal.class, null);
	
	/**
	 * 折旧后价格 , 类型: java.math.BigDecimal
	*/
	public static final String AFTER_PRICE="afterPrice";
	
	/**
	 * 折旧后价格 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.math.BigDecimal> AFTER_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,AFTER_PRICE, java.math.BigDecimal.class, "折旧后价格", "折旧后价格", java.math.BigDecimal.class, null);
	
	/**
	 * 折旧额 , 类型: java.math.BigDecimal
	*/
	public static final String DEPRECIATION_PRICE="depreciationPrice";
	
	/**
	 * 折旧额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.math.BigDecimal> DEPRECIATION_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,DEPRECIATION_PRICE, java.math.BigDecimal.class, "折旧额", "折旧额", java.math.BigDecimal.class, null);
	
	/**
	 * 操作人员 , 类型: java.lang.String
	*/
	public static final String OPER_USER_ID="operUserId";
	
	/**
	 * 操作人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.String> OPER_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,OPER_USER_ID, java.lang.String.class, "操作人员", "操作人员", java.lang.String.class, null);
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final String RECORD_TIME="recordTime";
	
	/**
	 * 记录时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.util.Date> RECORD_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,RECORD_TIME, java.util.Date.class, "记录时间", "记录时间", java.util.Date.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET="asset";
	
	/**
	 * 资产 , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,com.dt.platform.domain.eam.Asset> ASSET_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,ASSET, com.dt.platform.domain.eam.Asset.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String ASSET_NAME="assetName";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.String> ASSET_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,ASSET_NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String ASSET_MODEL="assetModel";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationHistory,java.lang.String> ASSET_MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationHistory.class ,ASSET_MODEL, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , ASSET_ID , BUSINESS_CODE , ASSET_CODE , DEPRECIATION_METHOD , ORIGINAL_UNIT_PRICE , BEFORE_PRICE , AFTER_PRICE , DEPRECIATION_PRICE , OPER_USER_ID , RECORD_TIME , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ASSET , ORIGINATOR , ASSET_NAME , ASSET_MODEL };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetDepreciationHistory {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetId 资产
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setAssetId(String assetId) {
			super.change(ASSET_ID,super.getAssetId(),assetId);
			super.setAssetId(assetId);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 资产编号
		 * @param assetCode 资产编号
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setAssetCode(String assetCode) {
			super.change(ASSET_CODE,super.getAssetCode(),assetCode);
			super.setAssetCode(assetCode);
			return this;
		}
		
		/**
		 * 设置 折旧方式
		 * @param depreciationMethod 折旧方式
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setDepreciationMethod(String depreciationMethod) {
			super.change(DEPRECIATION_METHOD,super.getDepreciationMethod(),depreciationMethod);
			super.setDepreciationMethod(depreciationMethod);
			return this;
		}
		
		/**
		 * 设置 资产原值
		 * @param originalUnitPrice 资产原值
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setOriginalUnitPrice(BigDecimal originalUnitPrice) {
			super.change(ORIGINAL_UNIT_PRICE,super.getOriginalUnitPrice(),originalUnitPrice);
			super.setOriginalUnitPrice(originalUnitPrice);
			return this;
		}
		
		/**
		 * 设置 折旧前价格
		 * @param beforePrice 折旧前价格
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setBeforePrice(BigDecimal beforePrice) {
			super.change(BEFORE_PRICE,super.getBeforePrice(),beforePrice);
			super.setBeforePrice(beforePrice);
			return this;
		}
		
		/**
		 * 设置 折旧后价格
		 * @param afterPrice 折旧后价格
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setAfterPrice(BigDecimal afterPrice) {
			super.change(AFTER_PRICE,super.getAfterPrice(),afterPrice);
			super.setAfterPrice(afterPrice);
			return this;
		}
		
		/**
		 * 设置 折旧额
		 * @param depreciationPrice 折旧额
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setDepreciationPrice(BigDecimal depreciationPrice) {
			super.change(DEPRECIATION_PRICE,super.getDepreciationPrice(),depreciationPrice);
			super.setDepreciationPrice(depreciationPrice);
			return this;
		}
		
		/**
		 * 设置 操作人员
		 * @param operUserId 操作人员
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setOperUserId(String operUserId) {
			super.change(OPER_USER_ID,super.getOperUserId(),operUserId);
			super.setOperUserId(operUserId);
			return this;
		}
		
		/**
		 * 设置 记录时间
		 * @param recordTime 记录时间
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setRecordTime(Date recordTime) {
			super.change(RECORD_TIME,super.getRecordTime(),recordTime);
			super.setRecordTime(recordTime);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param asset 资产
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setAsset(Asset asset) {
			super.change(ASSET,super.getAsset(),asset);
			super.setAsset(asset);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param assetName 名称
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setAssetName(String assetName) {
			super.change(ASSET_NAME,super.getAssetName(),assetName);
			super.setAssetName(assetName);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param assetModel 类型
		 * @return 当前对象
		*/
		public AssetDepreciationHistory setAssetModel(String assetModel) {
			super.change(ASSET_MODEL,super.getAssetModel(),assetModel);
			super.setAssetModel(assetModel);
			return this;
		}
	}
}