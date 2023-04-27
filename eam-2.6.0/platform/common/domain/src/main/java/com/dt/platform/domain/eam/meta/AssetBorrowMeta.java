package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetBorrow;
import java.util.Date;
import com.dt.platform.domain.eam.Asset;
import java.util.List;
import com.dt.platform.domain.eam.AssetItem;
import org.github.foxnic.web.domain.hrm.Employee;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-11-13 09:02:44
 * @sign 2DBCFE192C923F95E8FA46724967C7DC
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetBorrowMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 借用状态 , 类型: java.lang.String
	*/
	public static final String BORROW_STATUS="borrowStatus";
	
	/**
	 * 借用状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> BORROW_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,BORROW_STATUS, java.lang.String.class, "借用状态", "借用状态", java.lang.String.class, null);
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,NAME, java.lang.String.class, "业务名称", "业务名称", java.lang.String.class, null);
	
	/**
	 * 借用人 , 类型: java.lang.String
	*/
	public static final String BORROWER_ID="borrowerId";
	
	/**
	 * 借用人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> BORROWER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,BORROWER_ID, java.lang.String.class, "借用人", "借用人", java.lang.String.class, null);
	
	/**
	 * 借出时间 , 类型: java.util.Date
	*/
	public static final String BORROW_TIME="borrowTime";
	
	/**
	 * 借出时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.util.Date> BORROW_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,BORROW_TIME, java.util.Date.class, "借出时间", "借出时间", java.util.Date.class, null);
	
	/**
	 * 预计归还时间 , 类型: java.util.Date
	*/
	public static final String PLAN_RETURN_DATE="planReturnDate";
	
	/**
	 * 预计归还时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.util.Date> PLAN_RETURN_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,PLAN_RETURN_DATE, java.util.Date.class, "预计归还时间", "预计归还时间", java.util.Date.class, null);
	
	/**
	 * 归还时间 , 类型: java.util.Date
	*/
	public static final String RETURN_DATE="returnDate";
	
	/**
	 * 归还时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.util.Date> RETURN_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,RETURN_DATE, java.util.Date.class, "归还时间", "归还时间", java.util.Date.class, null);
	
	/**
	 * 借出说明 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 借出说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,CONTENT, java.lang.String.class, "借出说明", "借出说明", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH="attach";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> ATTACH_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,ATTACH, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET_LIST="assetList";
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,com.dt.platform.domain.eam.Asset> ASSET_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,ASSET_LIST, java.util.List.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ASSET_IDS="assetIds";
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> ASSET_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,ASSET_IDS, java.util.List.class, "资产列表", "资产列表", java.lang.String.class, null);
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetItem
	*/
	public static final String ASSET_ITEM_LIST="assetItemList";
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.AssetItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,com.dt.platform.domain.eam.AssetItem> ASSET_ITEM_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,ASSET_ITEM_LIST, java.util.List.class, "资产列表", "资产列表", com.dt.platform.domain.eam.AssetItem.class, null);
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_USER_NAME="originatorUserName";
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,java.lang.String> ORIGINATOR_USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,ORIGINATOR_USER_NAME, java.lang.String.class, "申请人", "申请人", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 借用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String BORROWER="borrower";
	
	/**
	 * 借用人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetBorrow,org.github.foxnic.web.domain.hrm.Employee> BORROWER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetBorrow.class ,BORROWER, org.github.foxnic.web.domain.hrm.Employee.class, "借用人", "借用人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , BUSINESS_CODE , PROC_ID , STATUS , BORROW_STATUS , NAME , BORROWER_ID , BORROW_TIME , PLAN_RETURN_DATE , RETURN_DATE , CONTENT , ORIGINATOR_ID , BUSINESS_DATE , ATTACH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , ASSET_LIST , ASSET_IDS , ASSET_ITEM_LIST , ORIGINATOR_USER_NAME , ORIGINATOR , BORROWER };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetBorrow {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetBorrow setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public AssetBorrow setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public AssetBorrow setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public AssetBorrow setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 借用状态
		 * @param borrowStatus 借用状态
		 * @return 当前对象
		*/
		public AssetBorrow setBorrowStatus(String borrowStatus) {
			super.change(BORROW_STATUS,super.getBorrowStatus(),borrowStatus);
			super.setBorrowStatus(borrowStatus);
			return this;
		}
		
		/**
		 * 设置 业务名称
		 * @param name 业务名称
		 * @return 当前对象
		*/
		public AssetBorrow setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 借用人
		 * @param borrowerId 借用人
		 * @return 当前对象
		*/
		public AssetBorrow setBorrowerId(String borrowerId) {
			super.change(BORROWER_ID,super.getBorrowerId(),borrowerId);
			super.setBorrowerId(borrowerId);
			return this;
		}
		
		/**
		 * 设置 借出时间
		 * @param borrowTime 借出时间
		 * @return 当前对象
		*/
		public AssetBorrow setBorrowTime(Date borrowTime) {
			super.change(BORROW_TIME,super.getBorrowTime(),borrowTime);
			super.setBorrowTime(borrowTime);
			return this;
		}
		
		/**
		 * 设置 预计归还时间
		 * @param planReturnDate 预计归还时间
		 * @return 当前对象
		*/
		public AssetBorrow setPlanReturnDate(Date planReturnDate) {
			super.change(PLAN_RETURN_DATE,super.getPlanReturnDate(),planReturnDate);
			super.setPlanReturnDate(planReturnDate);
			return this;
		}
		
		/**
		 * 设置 归还时间
		 * @param returnDate 归还时间
		 * @return 当前对象
		*/
		public AssetBorrow setReturnDate(Date returnDate) {
			super.change(RETURN_DATE,super.getReturnDate(),returnDate);
			super.setReturnDate(returnDate);
			return this;
		}
		
		/**
		 * 设置 借出说明
		 * @param content 借出说明
		 * @return 当前对象
		*/
		public AssetBorrow setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public AssetBorrow setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 业务日期
		 * @param businessDate 业务日期
		 * @return 当前对象
		*/
		public AssetBorrow setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attach 附件
		 * @return 当前对象
		*/
		public AssetBorrow setAttach(String attach) {
			super.change(ATTACH,super.getAttach(),attach);
			super.setAttach(attach);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetBorrow setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetBorrow setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetBorrow setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetBorrow setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetBorrow setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetBorrow setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetBorrow setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetBorrow setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetBorrow setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public AssetBorrow setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetList 资产
		 * @return 当前对象
		*/
		public AssetBorrow setAssetList(List<Asset> assetList) {
			super.change(ASSET_LIST,super.getAssetList(),assetList);
			super.setAssetList(assetList);
			return this;
		}
		
		/**
		 * 设置 资产列表
		 * @param assetIds 资产列表
		 * @return 当前对象
		*/
		public AssetBorrow setAssetIds(List<String> assetIds) {
			super.change(ASSET_IDS,super.getAssetIds(),assetIds);
			super.setAssetIds(assetIds);
			return this;
		}
		
		/**
		 * 设置 资产列表
		 * @param assetItemList 资产列表
		 * @return 当前对象
		*/
		public AssetBorrow setAssetItemList(List<AssetItem> assetItemList) {
			super.change(ASSET_ITEM_LIST,super.getAssetItemList(),assetItemList);
			super.setAssetItemList(assetItemList);
			return this;
		}
		
		/**
		 * 设置 申请人
		 * @param originatorUserName 申请人
		 * @return 当前对象
		*/
		public AssetBorrow setOriginatorUserName(String originatorUserName) {
			super.change(ORIGINATOR_USER_NAME,super.getOriginatorUserName(),originatorUserName);
			super.setOriginatorUserName(originatorUserName);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public AssetBorrow setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 借用人
		 * @param borrower 借用人
		 * @return 当前对象
		*/
		public AssetBorrow setBorrower(Employee borrower) {
			super.change(BORROWER,super.getBorrower(),borrower);
			super.setBorrower(borrower);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetBorrow clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetBorrow duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setBorrowerId(this.getBorrowerId());
			inst.setPlanReturnDate(this.getPlanReturnDate());
			inst.setProcId(this.getProcId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setContent(this.getContent());
			inst.setBusinessDate(this.getBusinessDate());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setReturnDate(this.getReturnDate());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setBorrowStatus(this.getBorrowStatus());
			inst.setCreateTime(this.getCreateTime());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setBorrowTime(this.getBorrowTime());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setId(this.getId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setAttach(this.getAttach());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setAssetItemList(this.getAssetItemList());
				inst.setBorrower(this.getBorrower());
				inst.setAssetIds(this.getAssetIds());
				inst.setOriginator(this.getOriginator());
				inst.setAssetList(this.getAssetList());
				inst.setOriginatorUserName(this.getOriginatorUserName());
			}
			inst.clearModifies();
			return inst;
		}

	}
}