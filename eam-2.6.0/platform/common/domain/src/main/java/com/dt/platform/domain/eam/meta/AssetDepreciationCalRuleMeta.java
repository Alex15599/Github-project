package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetDepreciationCalRule;
import java.util.Date;
import com.dt.platform.domain.eam.AssetDepreciation;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-27 17:04:42
 * @sign 028FA54B25CCA1BC8071AAAB3CBE628B
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetDepreciationCalRuleMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 折旧方案 , 类型: java.lang.String
	*/
	public static final String DEPRECIATION_ID="depreciationId";
	
	/**
	 * 折旧方案 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> DEPRECIATION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,DEPRECIATION_ID, java.lang.String.class, "折旧方案", "折旧方案", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 动作 , 类型: java.lang.String
	*/
	public static final String ACTION_CODE="actionCode";
	
	/**
	 * 动作 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> ACTION_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,ACTION_CODE, java.lang.String.class, "动作", "动作", java.lang.String.class, null);
	
	/**
	 * 规则编号 , 类型: java.lang.Integer
	*/
	public static final String RULE_NUMBER="ruleNumber";
	
	/**
	 * 规则编号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.Integer> RULE_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,RULE_NUMBER, java.lang.Integer.class, "规则编号", "规则编号", java.lang.Integer.class, null);
	
	/**
	 * 字段值 , 类型: java.lang.String
	*/
	public static final String COLUMN_VALUE="columnValue";
	
	/**
	 * 字段值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> COLUMN_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,COLUMN_VALUE, java.lang.String.class, "字段值", "字段值", java.lang.String.class, null);
	
	/**
	 * 字段名称 , 类型: java.lang.String
	*/
	public static final String COLUMN_NAME="columnName";
	
	/**
	 * 字段名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> COLUMN_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,COLUMN_NAME, java.lang.String.class, "字段名称", "字段名称", java.lang.String.class, null);
	
	/**
	 * 计算类型 , 类型: java.lang.String
	*/
	public static final String CALCULATION_TYPE="calculationType";
	
	/**
	 * 计算类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> CALCULATION_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,CALCULATION_TYPE, java.lang.String.class, "计算类型", "计算类型", java.lang.String.class, null);
	
	/**
	 * 计算方法 , 类型: java.lang.String
	*/
	public static final String METHOD_CONTENT="methodContent";
	
	/**
	 * 计算方法 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> METHOD_CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,METHOD_CONTENT, java.lang.String.class, "计算方法", "计算方法", java.lang.String.class, null);
	
	/**
	 * 方法描述 , 类型: java.lang.String
	*/
	public static final String METHOD_CONTENT_INFO="methodContentInfo";
	
	/**
	 * 方法描述 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> METHOD_CONTENT_INFO_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,METHOD_CONTENT_INFO, java.lang.String.class, "方法描述", "方法描述", java.lang.String.class, null);
	
	/**
	 * 返回类型 , 类型: java.lang.String
	*/
	public static final String RETURN_TYPE="returnType";
	
	/**
	 * 返回类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> RETURN_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,RETURN_TYPE, java.lang.String.class, "返回类型", "返回类型", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 方案 , 类型: com.dt.platform.domain.eam.AssetDepreciation
	*/
	public static final String ASSET_DEPRECIATION="assetDepreciation";
	
	/**
	 * 方案 , 类型: com.dt.platform.domain.eam.AssetDepreciation
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciationCalRule,com.dt.platform.domain.eam.AssetDepreciation> ASSET_DEPRECIATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciationCalRule.class ,ASSET_DEPRECIATION, com.dt.platform.domain.eam.AssetDepreciation.class, "方案", "方案", com.dt.platform.domain.eam.AssetDepreciation.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , DEPRECIATION_ID , STATUS , ACTION_CODE , RULE_NUMBER , COLUMN_VALUE , COLUMN_NAME , CALCULATION_TYPE , METHOD_CONTENT , METHOD_CONTENT_INFO , RETURN_TYPE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ASSET_DEPRECIATION };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetDepreciationCalRule {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 折旧方案
		 * @param depreciationId 折旧方案
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setDepreciationId(String depreciationId) {
			super.change(DEPRECIATION_ID,super.getDepreciationId(),depreciationId);
			super.setDepreciationId(depreciationId);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 动作
		 * @param actionCode 动作
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setActionCode(String actionCode) {
			super.change(ACTION_CODE,super.getActionCode(),actionCode);
			super.setActionCode(actionCode);
			return this;
		}
		
		/**
		 * 设置 规则编号
		 * @param ruleNumber 规则编号
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setRuleNumber(Integer ruleNumber) {
			super.change(RULE_NUMBER,super.getRuleNumber(),ruleNumber);
			super.setRuleNumber(ruleNumber);
			return this;
		}
		
		/**
		 * 设置 字段值
		 * @param columnValue 字段值
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setColumnValue(String columnValue) {
			super.change(COLUMN_VALUE,super.getColumnValue(),columnValue);
			super.setColumnValue(columnValue);
			return this;
		}
		
		/**
		 * 设置 字段名称
		 * @param columnName 字段名称
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setColumnName(String columnName) {
			super.change(COLUMN_NAME,super.getColumnName(),columnName);
			super.setColumnName(columnName);
			return this;
		}
		
		/**
		 * 设置 计算类型
		 * @param calculationType 计算类型
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setCalculationType(String calculationType) {
			super.change(CALCULATION_TYPE,super.getCalculationType(),calculationType);
			super.setCalculationType(calculationType);
			return this;
		}
		
		/**
		 * 设置 计算方法
		 * @param methodContent 计算方法
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setMethodContent(String methodContent) {
			super.change(METHOD_CONTENT,super.getMethodContent(),methodContent);
			super.setMethodContent(methodContent);
			return this;
		}
		
		/**
		 * 设置 方法描述
		 * @param methodContentInfo 方法描述
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setMethodContentInfo(String methodContentInfo) {
			super.change(METHOD_CONTENT_INFO,super.getMethodContentInfo(),methodContentInfo);
			super.setMethodContentInfo(methodContentInfo);
			return this;
		}
		
		/**
		 * 设置 返回类型
		 * @param returnType 返回类型
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setReturnType(String returnType) {
			super.change(RETURN_TYPE,super.getReturnType(),returnType);
			super.setReturnType(returnType);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 方案
		 * @param assetDepreciation 方案
		 * @return 当前对象
		*/
		public AssetDepreciationCalRule setAssetDepreciation(AssetDepreciation assetDepreciation) {
			super.change(ASSET_DEPRECIATION,super.getAssetDepreciation(),assetDepreciation);
			super.setAssetDepreciation(assetDepreciation);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetDepreciationCalRule clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetDepreciationCalRule duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCalculationType(this.getCalculationType());
			inst.setNotes(this.getNotes());
			inst.setRuleNumber(this.getRuleNumber());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setMethodContentInfo(this.getMethodContentInfo());
			inst.setColumnValue(this.getColumnValue());
			inst.setVersion(this.getVersion());
			inst.setMethodContent(this.getMethodContent());
			inst.setDepreciationId(this.getDepreciationId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setActionCode(this.getActionCode());
			inst.setId(this.getId());
			inst.setReturnType(this.getReturnType());
			inst.setStatus(this.getStatus());
			inst.setColumnName(this.getColumnName());
			if(all) {
				inst.setAssetDepreciation(this.getAssetDepreciation());
			}
			inst.clearModifies();
			return inst;
		}

	}
}