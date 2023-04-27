package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetDepreciation;
import java.math.BigDecimal;
import java.util.Date;
import org.github.foxnic.web.domain.pcm.Catalog;
import java.util.List;
import com.dt.platform.domain.eam.AssetDepreciationCalRule;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-27 12:24:36
 * @sign 2167A9512830F2F86763A1931003DE0E
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetDepreciationMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 折旧方案 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 折旧方案 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,NAME, java.lang.String.class, "折旧方案", "折旧方案", java.lang.String.class, null);
	
	/**
	 * 折旧方式 , 类型: java.lang.String
	*/
	public static final String METHOD="method";
	
	/**
	 * 折旧方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,METHOD, java.lang.String.class, "折旧方式", "折旧方式", java.lang.String.class, null);
	
	/**
	 * 预计残值率 , 类型: java.math.BigDecimal
	*/
	public static final String PRE_RESIDUAL_RATE="preResidualRate";
	
	/**
	 * 预计残值率 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.math.BigDecimal> PRE_RESIDUAL_RATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,PRE_RESIDUAL_RATE, java.math.BigDecimal.class, "预计残值率", "预计残值率", java.math.BigDecimal.class, null);
	
	/**
	 * 残值选择 , 类型: java.lang.String
	*/
	public static final String RESIDUAL_VALUE_SELECT="residualValueSelect";
	
	/**
	 * 残值选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> RESIDUAL_VALUE_SELECT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,RESIDUAL_VALUE_SELECT, java.lang.String.class, "残值选择", "残值选择", java.lang.String.class, null);
	
	/**
	 * 首次折旧方式 , 类型: java.lang.String
	*/
	public static final String FIRST_DEPRECIATION_METHOD="firstDepreciationMethod";
	
	/**
	 * 首次折旧方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> FIRST_DEPRECIATION_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,FIRST_DEPRECIATION_METHOD, java.lang.String.class, "首次折旧方式", "首次折旧方式", java.lang.String.class, null);
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final String OWN_COMPANY_ID="ownCompanyId";
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> OWN_COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,OWN_COMPANY_ID, java.lang.String.class, "所属公司", "所属公司", java.lang.String.class, null);
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,CATEGORY_ID, java.lang.String.class, "资产分类", "资产分类", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,SELECTED_CODE, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final String CATEGORY="category";
	
	/**
	 * 资产分类 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,org.github.foxnic.web.domain.pcm.Catalog> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,CATEGORY, java.util.List.class, "资产分类", "资产分类", org.github.foxnic.web.domain.pcm.Catalog.class, null);
	
	/**
	 * 资产分类Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String CATEGORY_IDS="categoryIds";
	
	/**
	 * 资产分类Ids , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> CATEGORY_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,CATEGORY_IDS, java.util.List.class, "资产分类Ids", "资产分类Ids", java.lang.String.class, null);
	
	/**
	 * calRuleList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetDepreciationCalRule
	*/
	public static final String CAL_RULE_LIST="calRuleList";
	
	/**
	 * calRuleList , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetDepreciationCalRule
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,com.dt.platform.domain.eam.AssetDepreciationCalRule> CAL_RULE_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,CAL_RULE_LIST, java.util.List.class, "calRuleList", "calRuleList", com.dt.platform.domain.eam.AssetDepreciationCalRule.class, null);
	
	/**
	 * calRuleIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String CAL_RULE_IDS="calRuleIds";
	
	/**
	 * calRuleIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetDepreciation,java.lang.String> CAL_RULE_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetDepreciation.class ,CAL_RULE_IDS, java.util.List.class, "calRuleIds", "calRuleIds", java.lang.String.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , STATUS , CODE , NAME , METHOD , PRE_RESIDUAL_RATE , RESIDUAL_VALUE_SELECT , FIRST_DEPRECIATION_METHOD , OWN_COMPANY_ID , CATEGORY_ID , SELECTED_CODE , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , CATEGORY , CATEGORY_IDS , CAL_RULE_LIST , CAL_RULE_IDS };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetDepreciation {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetDepreciation setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public AssetDepreciation setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public AssetDepreciation setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 折旧方案
		 * @param name 折旧方案
		 * @return 当前对象
		*/
		public AssetDepreciation setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 折旧方式
		 * @param method 折旧方式
		 * @return 当前对象
		*/
		public AssetDepreciation setMethod(String method) {
			super.change(METHOD,super.getMethod(),method);
			super.setMethod(method);
			return this;
		}
		
		/**
		 * 设置 预计残值率
		 * @param preResidualRate 预计残值率
		 * @return 当前对象
		*/
		public AssetDepreciation setPreResidualRate(BigDecimal preResidualRate) {
			super.change(PRE_RESIDUAL_RATE,super.getPreResidualRate(),preResidualRate);
			super.setPreResidualRate(preResidualRate);
			return this;
		}
		
		/**
		 * 设置 残值选择
		 * @param residualValueSelect 残值选择
		 * @return 当前对象
		*/
		public AssetDepreciation setResidualValueSelect(String residualValueSelect) {
			super.change(RESIDUAL_VALUE_SELECT,super.getResidualValueSelect(),residualValueSelect);
			super.setResidualValueSelect(residualValueSelect);
			return this;
		}
		
		/**
		 * 设置 首次折旧方式
		 * @param firstDepreciationMethod 首次折旧方式
		 * @return 当前对象
		*/
		public AssetDepreciation setFirstDepreciationMethod(String firstDepreciationMethod) {
			super.change(FIRST_DEPRECIATION_METHOD,super.getFirstDepreciationMethod(),firstDepreciationMethod);
			super.setFirstDepreciationMethod(firstDepreciationMethod);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownCompanyId 所属公司
		 * @return 当前对象
		*/
		public AssetDepreciation setOwnCompanyId(String ownCompanyId) {
			super.change(OWN_COMPANY_ID,super.getOwnCompanyId(),ownCompanyId);
			super.setOwnCompanyId(ownCompanyId);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param categoryId 资产分类
		 * @return 当前对象
		*/
		public AssetDepreciation setCategoryId(String categoryId) {
			super.change(CATEGORY_ID,super.getCategoryId(),categoryId);
			super.setCategoryId(categoryId);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param selectedCode 选择
		 * @return 当前对象
		*/
		public AssetDepreciation setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public AssetDepreciation setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetDepreciation setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetDepreciation setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetDepreciation setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetDepreciation setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetDepreciation setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetDepreciation setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetDepreciation setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetDepreciation setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetDepreciation setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param category 资产分类
		 * @return 当前对象
		*/
		public AssetDepreciation setCategory(List<Catalog> category) {
			super.change(CATEGORY,super.getCategory(),category);
			super.setCategory(category);
			return this;
		}
		
		/**
		 * 设置 资产分类Ids
		 * @param categoryIds 资产分类Ids
		 * @return 当前对象
		*/
		public AssetDepreciation setCategoryIds(List<String> categoryIds) {
			super.change(CATEGORY_IDS,super.getCategoryIds(),categoryIds);
			super.setCategoryIds(categoryIds);
			return this;
		}
		
		/**
		 * 设置 calRuleList
		 * @param calRuleList calRuleList
		 * @return 当前对象
		*/
		public AssetDepreciation setCalRuleList(List<AssetDepreciationCalRule> calRuleList) {
			super.change(CAL_RULE_LIST,super.getCalRuleList(),calRuleList);
			super.setCalRuleList(calRuleList);
			return this;
		}
		
		/**
		 * 设置 calRuleIds
		 * @param calRuleIds calRuleIds
		 * @return 当前对象
		*/
		public AssetDepreciation setCalRuleIds(List<String> calRuleIds) {
			super.change(CAL_RULE_IDS,super.getCalRuleIds(),calRuleIds);
			super.setCalRuleIds(calRuleIds);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetDepreciation clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetDepreciation duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setMethod(this.getMethod());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setResidualValueSelect(this.getResidualValueSelect());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setVersion(this.getVersion());
			inst.setFirstDepreciationMethod(this.getFirstDepreciationMethod());
			inst.setOwnCompanyId(this.getOwnCompanyId());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setPreResidualRate(this.getPreResidualRate());
			inst.setId(this.getId());
			inst.setCategoryId(this.getCategoryId());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setCategoryIds(this.getCategoryIds());
				inst.setCalRuleList(this.getCalRuleList());
				inst.setCalRuleIds(this.getCalRuleIds());
				inst.setCategory(this.getCategory());
			}
			inst.clearModifies();
			return inst;
		}

	}
}