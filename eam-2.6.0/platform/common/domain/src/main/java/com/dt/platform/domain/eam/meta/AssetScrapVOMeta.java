package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetScrapVO;
import java.util.List;
import com.dt.platform.domain.eam.AssetScrap;
import java.util.Date;
import com.dt.platform.domain.eam.Asset;
import org.github.foxnic.web.domain.system.DictItem;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-10-25 19:54:32
 * @sign D1CC760B76F49AD8A0DEB3936B7A82A5
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetScrapVOMeta extends AssetScrapMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 清理状态 , 类型: java.lang.String
	*/
	public static final String CLEAN_STATUS="cleanStatus";
	
	/**
	 * 清理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> CLEAN_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,CLEAN_STATUS, java.lang.String.class, "清理状态", "清理状态", java.lang.String.class, null);
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 业务名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,NAME, java.lang.String.class, "业务名称", "业务名称", java.lang.String.class, null);
	
	/**
	 * 报废方式 , 类型: java.lang.String
	*/
	public static final String METHOD="method";
	
	/**
	 * 报废方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,METHOD, java.lang.String.class, "报废方式", "报废方式", java.lang.String.class, null);
	
	/**
	 * 报废时间 , 类型: java.lang.String
	*/
	public static final String SCRAP_DATE="scrapDate";
	
	/**
	 * 报废时间 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> SCRAP_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,SCRAP_DATE, java.lang.String.class, "报废时间", "报废时间", java.lang.String.class, null);
	
	/**
	 * 报废说明 , 类型: java.lang.String
	*/
	public static final String CONTENT="content";
	
	/**
	 * 报废说明 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> CONTENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,CONTENT, java.lang.String.class, "报废说明", "报废说明", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final String BUSINESS_DATE="businessDate";
	
	/**
	 * 业务日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.util.Date> BUSINESS_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,BUSINESS_DATE, java.util.Date.class, "业务日期", "业务日期", java.util.Date.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH="attach";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> ATTACH_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,ATTACH, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * version , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,VERSION, java.lang.Integer.class, "version", "version", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final String SELECTED_CODE="selectedCode";
	
	/**
	 * 选择数据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> SELECTED_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,SELECTED_CODE, java.lang.String.class, "选择数据", "选择数据", java.lang.String.class, null);
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final String CHS_TYPE="chsType";
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> CHS_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,CHS_TYPE, java.lang.String.class, "变更类型", "变更类型", java.lang.String.class, null);
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final String CHS_STATUS="chsStatus";
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> CHS_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,CHS_STATUS, java.lang.String.class, "变更状态", "变更状态", java.lang.String.class, null);
	
	/**
	 * 变更版本号 , 类型: java.lang.String
	*/
	public static final String CHS_VERSION="chsVersion";
	
	/**
	 * 变更版本号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> CHS_VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,CHS_VERSION, java.lang.String.class, "变更版本号", "变更版本号", java.lang.String.class, null);
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final String CHANGE_INSTANCE_ID="changeInstanceId";
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> CHANGE_INSTANCE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,CHANGE_INSTANCE_ID, java.lang.String.class, "变更ID", "变更ID", java.lang.String.class, null);
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final String SUMMARY="summary";
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> SUMMARY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,SUMMARY, java.lang.String.class, "流程概要", "流程概要", java.lang.String.class, null);
	
	/**
	 * 最后审批人账户ID , 类型: java.lang.String
	*/
	public static final String LATEST_APPROVER_ID="latestApproverId";
	
	/**
	 * 最后审批人账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> LATEST_APPROVER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,LATEST_APPROVER_ID, java.lang.String.class, "最后审批人账户ID", "最后审批人账户ID", java.lang.String.class, null);
	
	/**
	 * 最后审批人姓名 , 类型: java.lang.String
	*/
	public static final String LATEST_APPROVER_NAME="latestApproverName";
	
	/**
	 * 最后审批人姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> LATEST_APPROVER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,LATEST_APPROVER_NAME, java.lang.String.class, "最后审批人姓名", "最后审批人姓名", java.lang.String.class, null);
	
	/**
	 * 下一节点审批人 , 类型: java.lang.String
	*/
	public static final String NEXT_APPROVER_IDS="nextApproverIds";
	
	/**
	 * 下一节点审批人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> NEXT_APPROVER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,NEXT_APPROVER_IDS, java.lang.String.class, "下一节点审批人", "下一节点审批人", java.lang.String.class, null);
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final String NEXT_APPROVER_NAMES="nextApproverNames";
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> NEXT_APPROVER_NAMES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,NEXT_APPROVER_NAMES, java.lang.String.class, "下一个审批节点审批人姓名", "用逗号隔开", java.lang.String.class, null);
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final String APPROVAL_OPINION="approvalOpinion";
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> APPROVAL_OPINION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,APPROVAL_OPINION, java.lang.String.class, "审批意见", "审批意见", java.lang.String.class, null);
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final String ASSET_LIST="assetList";
	
	/**
	 * 资产 , 集合类型: LIST , 类型: com.dt.platform.domain.eam.Asset
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,com.dt.platform.domain.eam.Asset> ASSET_LIST_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,ASSET_LIST, java.util.List.class, "资产", "资产", com.dt.platform.domain.eam.Asset.class, null);
	
	/**
	 * methodDict , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String METHOD_DICT="methodDict";
	
	/**
	 * methodDict , 集合类型: LIST , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,org.github.foxnic.web.domain.system.DictItem> METHOD_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,METHOD_DICT, java.util.List.class, "methodDict", "methodDict", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String ASSET_IDS="assetIds";
	
	/**
	 * 资产列表 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> ASSET_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,ASSET_IDS, java.util.List.class, "资产列表", "资产列表", java.lang.String.class, null);
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_USER_NAME="originatorUserName";
	
	/**
	 * 申请人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,java.lang.String> ORIGINATOR_USER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,ORIGINATOR_USER_NAME, java.lang.String.class, "申请人", "申请人", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 变更实例 , 类型: org.github.foxnic.web.domain.changes.ChangeInstance
	*/
	public static final String CHANGE_INSTANCE="changeInstance";
	
	/**
	 * 变更实例 , 类型: org.github.foxnic.web.domain.changes.ChangeInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetScrapVO,org.github.foxnic.web.domain.changes.ChangeInstance> CHANGE_INSTANCE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetScrapVO.class ,CHANGE_INSTANCE, org.github.foxnic.web.domain.changes.ChangeInstance.class, "变更实例", "变更实例", org.github.foxnic.web.domain.changes.ChangeInstance.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , BUSINESS_CODE , PROC_ID , STATUS , CLEAN_STATUS , NAME , METHOD , SCRAP_DATE , CONTENT , ORIGINATOR_ID , BUSINESS_DATE , ATTACH , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , SELECTED_CODE , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION , ASSET_LIST , METHOD_DICT , ASSET_IDS , ORIGINATOR_USER_NAME , ORIGINATOR , CHANGE_INSTANCE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetScrapVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssetScrapVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssetScrapVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssetScrapVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssetScrapVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssetScrapVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssetScrapVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssetScrapVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssetScrapVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssetScrapVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public AssetScrap setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public AssetScrap setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public AssetScrap setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public AssetScrap setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 清理状态
		 * @param cleanStatus 清理状态
		 * @return 当前对象
		*/
		public AssetScrap setCleanStatus(String cleanStatus) {
			super.change(CLEAN_STATUS,super.getCleanStatus(),cleanStatus);
			super.setCleanStatus(cleanStatus);
			return this;
		}
		
		/**
		 * 设置 业务名称
		 * @param name 业务名称
		 * @return 当前对象
		*/
		public AssetScrap setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 报废方式
		 * @param method 报废方式
		 * @return 当前对象
		*/
		public AssetScrap setMethod(String method) {
			super.change(METHOD,super.getMethod(),method);
			super.setMethod(method);
			return this;
		}
		
		/**
		 * 设置 报废时间
		 * @param scrapDate 报废时间
		 * @return 当前对象
		*/
		public AssetScrap setScrapDate(String scrapDate) {
			super.change(SCRAP_DATE,super.getScrapDate(),scrapDate);
			super.setScrapDate(scrapDate);
			return this;
		}
		
		/**
		 * 设置 报废说明
		 * @param content 报废说明
		 * @return 当前对象
		*/
		public AssetScrap setContent(String content) {
			super.change(CONTENT,super.getContent(),content);
			super.setContent(content);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public AssetScrap setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 业务日期
		 * @param businessDate 业务日期
		 * @return 当前对象
		*/
		public AssetScrap setBusinessDate(Date businessDate) {
			super.change(BUSINESS_DATE,super.getBusinessDate(),businessDate);
			super.setBusinessDate(businessDate);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attach 附件
		 * @return 当前对象
		*/
		public AssetScrap setAttach(String attach) {
			super.change(ATTACH,super.getAttach(),attach);
			super.setAttach(attach);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public AssetScrap setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public AssetScrap setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public AssetScrap setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public AssetScrap setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public AssetScrap setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public AssetScrap setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public AssetScrap setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 version
		 * @param version version
		 * @return 当前对象
		*/
		public AssetScrap setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public AssetScrap setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 选择数据
		 * @param selectedCode 选择数据
		 * @return 当前对象
		*/
		public AssetScrap setSelectedCode(String selectedCode) {
			super.change(SELECTED_CODE,super.getSelectedCode(),selectedCode);
			super.setSelectedCode(selectedCode);
			return this;
		}
		
		/**
		 * 设置 变更类型
		 * @param chsType 变更类型
		 * @return 当前对象
		*/
		public AssetScrap setChsType(String chsType) {
			super.change(CHS_TYPE,super.getChsType(),chsType);
			super.setChsType(chsType);
			return this;
		}
		
		/**
		 * 设置 变更状态
		 * @param chsStatus 变更状态
		 * @return 当前对象
		*/
		public AssetScrap setChsStatus(String chsStatus) {
			super.change(CHS_STATUS,super.getChsStatus(),chsStatus);
			super.setChsStatus(chsStatus);
			return this;
		}
		
		/**
		 * 设置 变更版本号
		 * @param chsVersion 变更版本号
		 * @return 当前对象
		*/
		public AssetScrap setChsVersion(String chsVersion) {
			super.change(CHS_VERSION,super.getChsVersion(),chsVersion);
			super.setChsVersion(chsVersion);
			return this;
		}
		
		/**
		 * 设置 变更ID
		 * @param changeInstanceId 变更ID
		 * @return 当前对象
		*/
		public AssetScrap setChangeInstanceId(String changeInstanceId) {
			super.change(CHANGE_INSTANCE_ID,super.getChangeInstanceId(),changeInstanceId);
			super.setChangeInstanceId(changeInstanceId);
			return this;
		}
		
		/**
		 * 设置 流程概要
		 * @param summary 流程概要
		 * @return 当前对象
		*/
		public AssetScrap setSummary(String summary) {
			super.change(SUMMARY,super.getSummary(),summary);
			super.setSummary(summary);
			return this;
		}
		
		/**
		 * 设置 最后审批人账户ID
		 * @param latestApproverId 最后审批人账户ID
		 * @return 当前对象
		*/
		public AssetScrap setLatestApproverId(String latestApproverId) {
			super.change(LATEST_APPROVER_ID,super.getLatestApproverId(),latestApproverId);
			super.setLatestApproverId(latestApproverId);
			return this;
		}
		
		/**
		 * 设置 最后审批人姓名
		 * @param latestApproverName 最后审批人姓名
		 * @return 当前对象
		*/
		public AssetScrap setLatestApproverName(String latestApproverName) {
			super.change(LATEST_APPROVER_NAME,super.getLatestApproverName(),latestApproverName);
			super.setLatestApproverName(latestApproverName);
			return this;
		}
		
		/**
		 * 设置 下一节点审批人
		 * @param nextApproverIds 下一节点审批人
		 * @return 当前对象
		*/
		public AssetScrap setNextApproverIds(String nextApproverIds) {
			super.change(NEXT_APPROVER_IDS,super.getNextApproverIds(),nextApproverIds);
			super.setNextApproverIds(nextApproverIds);
			return this;
		}
		
		/**
		 * 设置 下一个审批节点审批人姓名
		 * @param nextApproverNames 下一个审批节点审批人姓名
		 * @return 当前对象
		*/
		public AssetScrap setNextApproverNames(String nextApproverNames) {
			super.change(NEXT_APPROVER_NAMES,super.getNextApproverNames(),nextApproverNames);
			super.setNextApproverNames(nextApproverNames);
			return this;
		}
		
		/**
		 * 设置 审批意见
		 * @param approvalOpinion 审批意见
		 * @return 当前对象
		*/
		public AssetScrap setApprovalOpinion(String approvalOpinion) {
			super.change(APPROVAL_OPINION,super.getApprovalOpinion(),approvalOpinion);
			super.setApprovalOpinion(approvalOpinion);
			return this;
		}
		
		/**
		 * 设置 资产
		 * @param assetList 资产
		 * @return 当前对象
		*/
		public AssetScrap setAssetList(List<Asset> assetList) {
			super.change(ASSET_LIST,super.getAssetList(),assetList);
			super.setAssetList(assetList);
			return this;
		}
		
		/**
		 * 设置 methodDict
		 * @param methodDict methodDict
		 * @return 当前对象
		*/
		public AssetScrap setMethodDict(List<DictItem> methodDict) {
			super.change(METHOD_DICT,super.getMethodDict(),methodDict);
			super.setMethodDict(methodDict);
			return this;
		}
		
		/**
		 * 设置 资产列表
		 * @param assetIds 资产列表
		 * @return 当前对象
		*/
		public AssetScrap setAssetIds(List<String> assetIds) {
			super.change(ASSET_IDS,super.getAssetIds(),assetIds);
			super.setAssetIds(assetIds);
			return this;
		}
		
		/**
		 * 设置 申请人
		 * @param originatorUserName 申请人
		 * @return 当前对象
		*/
		public AssetScrap setOriginatorUserName(String originatorUserName) {
			super.change(ORIGINATOR_USER_NAME,super.getOriginatorUserName(),originatorUserName);
			super.setOriginatorUserName(originatorUserName);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public AssetScrap setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 变更实例
		 * @param changeInstance 变更实例
		 * @return 当前对象
		*/
		public AssetScrap setChangeInstance(ChangeInstance changeInstance) {
			super.change(CHANGE_INSTANCE,super.getChangeInstance(),changeInstance);
			super.setChangeInstance(changeInstance);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetScrapVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetScrapVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setChsVersion(this.getChsVersion());
			inst.setCleanStatus(this.getCleanStatus());
			inst.setProcId(this.getProcId());
			inst.setLatestApproverName(this.getLatestApproverName());
			inst.setChangeInstanceId(this.getChangeInstanceId());
			inst.setSelectedCode(this.getSelectedCode());
			inst.setContent(this.getContent());
			inst.setNextApproverIds(this.getNextApproverIds());
			inst.setApprovalOpinion(this.getApprovalOpinion());
			inst.setChsStatus(this.getChsStatus());
			inst.setBusinessDate(this.getBusinessDate());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setId(this.getId());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setAttach(this.getAttach());
			inst.setSummary(this.getSummary());
			inst.setNextApproverNames(this.getNextApproverNames());
			inst.setLatestApproverId(this.getLatestApproverId());
			inst.setMethod(this.getMethod());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setVersion(this.getVersion());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setChsType(this.getChsType());
			inst.setScrapDate(this.getScrapDate());
			inst.setName(this.getName());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setAssetIds(this.getAssetIds());
				inst.setOriginator(this.getOriginator());
				inst.setAssetList(this.getAssetList());
				inst.setOriginatorUserName(this.getOriginatorUserName());
				inst.setChangeInstance(this.getChangeInstance());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setMethodDict(this.getMethodDict());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setIds(this.getIds());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}