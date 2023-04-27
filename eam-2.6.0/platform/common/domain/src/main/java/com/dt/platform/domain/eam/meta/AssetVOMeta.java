package com.dt.platform.domain.eam.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.eam.AssetVO;
import java.util.List;
import com.dt.platform.domain.eam.Asset;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.eam.AssetExtData;
import java.util.Map;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import com.dt.platform.domain.eam.Position;
import com.dt.platform.domain.eam.CategoryFinance;
import org.github.foxnic.web.domain.pcm.Catalog;
import com.dt.platform.domain.eam.Goods;
import com.dt.platform.domain.eam.Manufacturer;
import com.dt.platform.domain.eam.Warehouse;
import org.github.foxnic.web.domain.hrm.Employee;
import com.dt.platform.domain.eam.Supplier;
import com.dt.platform.domain.eam.Maintainer;
import org.github.foxnic.web.domain.hrm.Organization;
import org.github.foxnic.web.domain.system.DictItem;
import com.dt.platform.domain.eam.AssetStatus;
import com.dt.platform.domain.eam.AssetRack;
import org.github.foxnic.web.domain.changes.ChangeInstance;
import com.dt.platform.domain.eam.GoodsStock;
import com.dt.platform.domain.eam.AssetRegion;
import com.dt.platform.domain.eam.AssetCollection;
import com.dt.platform.domain.eam.AssetBorrow;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2022-12-07 18:19:38
 * @sign C05127D02CE5B4FBBB8CDA17B7C59FAA
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class AssetVOMeta extends AssetMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final String CATEGORY_ID="categoryId";
	
	/**
	 * 资产分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CATEGORY_ID, java.lang.String.class, "资产分类", "资产分类", java.lang.String.class, null);
	
	/**
	 * 分类编码 , 类型: java.lang.String
	*/
	public static final String CATEGORY_CODE="categoryCode";
	
	/**
	 * 分类编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> CATEGORY_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CATEGORY_CODE, java.lang.String.class, "分类编码", "分类编码", java.lang.String.class, null);
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final String BUSINESS_CODE="businessCode";
	
	/**
	 * 业务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> BUSINESS_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,BUSINESS_CODE, java.lang.String.class, "业务编号", "业务编号", java.lang.String.class, null);
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final String PROC_ID="procId";
	
	/**
	 * 流程 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> PROC_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,PROC_ID, java.lang.String.class, "流程", "流程", java.lang.String.class, null);
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 办理状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,STATUS, java.lang.String.class, "办理状态", "办理状态", java.lang.String.class, null);
	
	/**
	 * 批次编码 , 类型: java.lang.String
	*/
	public static final String BATCH_CODE="batchCode";
	
	/**
	 * 批次编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> BATCH_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,BATCH_CODE, java.lang.String.class, "批次编码", "批次编码", java.lang.String.class, null);
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final String OWNER_CODE="ownerCode";
	
	/**
	 * 归属 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> OWNER_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,OWNER_CODE, java.lang.String.class, "归属", "归属", java.lang.String.class, null);
	
	/**
	 * 资产编号 , 类型: java.lang.String
	*/
	public static final String ASSET_CODE="assetCode";
	
	/**
	 * 资产编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> ASSET_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ASSET_CODE, java.lang.String.class, "资产编号", "资产编号", java.lang.String.class, null);
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final String ASSET_STATUS="assetStatus";
	
	/**
	 * 资产状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> ASSET_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ASSET_STATUS, java.lang.String.class, "资产状态", "资产状态", java.lang.String.class, null);
	
	/**
	 * 是否显示 , 类型: java.lang.String
	*/
	public static final String DISPLAY="display";
	
	/**
	 * 是否显示 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> DISPLAY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,DISPLAY, java.lang.String.class, "是否显示", "是否显示", java.lang.String.class, null);
	
	/**
	 * 是否清理 , 类型: java.lang.String
	*/
	public static final String CLEAN_OUT="cleanOut";
	
	/**
	 * 是否清理 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> CLEAN_OUT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CLEAN_OUT, java.lang.String.class, "是否清理", "是否清理", java.lang.String.class, null);
	
	/**
	 * 标准物品档案 , 类型: java.lang.String
	*/
	public static final String GOODS_ID="goodsId";
	
	/**
	 * 标准物品档案 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> GOODS_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,GOODS_ID, java.lang.String.class, "标准物品档案", "标准物品档案", java.lang.String.class, null);
	
	/**
	 * 标准型号资产名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 标准型号资产名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,NAME, java.lang.String.class, "标准型号资产名称", "标准型号资产名称", java.lang.String.class, null);
	
	/**
	 * 标准型号厂商 , 类型: java.lang.String
	*/
	public static final String MANUFACTURER_ID="manufacturerId";
	
	/**
	 * 标准型号厂商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> MANUFACTURER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MANUFACTURER_ID, java.lang.String.class, "标准型号厂商", "标准型号厂商", java.lang.String.class, null);
	
	/**
	 * 标准型号规格型号 , 类型: java.lang.String
	*/
	public static final String MODEL="model";
	
	/**
	 * 标准型号规格型号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> MODEL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MODEL, java.lang.String.class, "标准型号规格型号", "标准型号规格型号", java.lang.String.class, null);
	
	/**
	 * 标准型号物品图片 , 类型: java.lang.String
	*/
	public static final String PICTURE_ID="pictureId";
	
	/**
	 * 标准型号物品图片 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> PICTURE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,PICTURE_ID, java.lang.String.class, "标准型号物品图片", "标准型号物品图片", java.lang.String.class, null);
	
	/**
	 * 标准型号计量单位 , 类型: java.lang.String
	*/
	public static final String UNIT="unit";
	
	/**
	 * 标准型号计量单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> UNIT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,UNIT, java.lang.String.class, "标准型号计量单位", "标准型号计量单位", java.lang.String.class, null);
	
	/**
	 * 使用期限 , (月) , 类型: java.math.BigDecimal
	*/
	public static final String SERVICE_LIFE="serviceLife";
	
	/**
	 * 使用期限 , (月) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> SERVICE_LIFE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SERVICE_LIFE, java.math.BigDecimal.class, "使用期限", "(月)", java.math.BigDecimal.class, null);
	
	/**
	 * 安全等级 , 类型: java.lang.String
	*/
	public static final String SAFETY_LEVEL_CODE="safetyLevelCode";
	
	/**
	 * 安全等级 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> SAFETY_LEVEL_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SAFETY_LEVEL_CODE, java.lang.String.class, "安全等级", "安全等级", java.lang.String.class, null);
	
	/**
	 * 序列号 , 类型: java.lang.String
	*/
	public static final String SERIAL_NUMBER="serialNumber";
	
	/**
	 * 序列号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> SERIAL_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SERIAL_NUMBER, java.lang.String.class, "序列号", "序列号", java.lang.String.class, null);
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final String OWN_COMPANY_ID="ownCompanyId";
	
	/**
	 * 所属公司 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> OWN_COMPANY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,OWN_COMPANY_ID, java.lang.String.class, "所属公司", "所属公司", java.lang.String.class, null);
	
	/**
	 * 管理人员 , 类型: java.lang.String
	*/
	public static final String MANAGER_ID="managerId";
	
	/**
	 * 管理人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> MANAGER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MANAGER_ID, java.lang.String.class, "管理人员", "管理人员", java.lang.String.class, null);
	
	/**
	 * 使用公司/部门 , 类型: java.lang.String
	*/
	public static final String USE_ORGANIZATION_ID="useOrganizationId";
	
	/**
	 * 使用公司/部门 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> USE_ORGANIZATION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,USE_ORGANIZATION_ID, java.lang.String.class, "使用公司/部门", "使用公司/部门", java.lang.String.class, null);
	
	/**
	 * 使用人员 , 类型: java.lang.String
	*/
	public static final String USE_USER_ID="useUserId";
	
	/**
	 * 使用人员 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> USE_USER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,USE_USER_ID, java.lang.String.class, "使用人员", "使用人员", java.lang.String.class, null);
	
	/**
	 * 存放区域 , 类型: java.lang.String
	*/
	public static final String REGION_ID="regionId";
	
	/**
	 * 存放区域 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> REGION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,REGION_ID, java.lang.String.class, "存放区域", "存放区域", java.lang.String.class, null);
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final String POSITION_ID="positionId";
	
	/**
	 * 存放位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> POSITION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,POSITION_ID, java.lang.String.class, "存放位置", "存放位置", java.lang.String.class, null);
	
	/**
	 * 详细位置 , 类型: java.lang.String
	*/
	public static final String POSITION_DETAIL="positionDetail";
	
	/**
	 * 详细位置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> POSITION_DETAIL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,POSITION_DETAIL, java.lang.String.class, "详细位置", "详细位置", java.lang.String.class, null);
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final String WAREHOUSE_ID="warehouseId";
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> WAREHOUSE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,WAREHOUSE_ID, java.lang.String.class, "仓库", "仓库", java.lang.String.class, null);
	
	/**
	 * 库存物品 , 类型: java.lang.String
	*/
	public static final String GOODS_STOCK_ID="goodsStockId";
	
	/**
	 * 库存物品 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> GOODS_STOCK_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,GOODS_STOCK_ID, java.lang.String.class, "库存物品", "库存物品", java.lang.String.class, null);
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final String SOURCE_ID="sourceId";
	
	/**
	 * 来源 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> SOURCE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SOURCE_ID, java.lang.String.class, "来源", "来源", java.lang.String.class, null);
	
	/**
	 * 资产数量 , 类型: java.lang.Integer
	*/
	public static final String ASSET_NUMBER="assetNumber";
	
	/**
	 * 资产数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.Integer> ASSET_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ASSET_NUMBER, java.lang.Integer.class, "资产数量", "资产数量", java.lang.Integer.class, null);
	
	/**
	 * 剩余数量 , 类型: java.lang.Integer
	*/
	public static final String REMAIN_NUMBER="remainNumber";
	
	/**
	 * 剩余数量 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.Integer> REMAIN_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,REMAIN_NUMBER, java.lang.Integer.class, "剩余数量", "剩余数量", java.lang.Integer.class, null);
	
	/**
	 * 采购日期 , 类型: java.util.Date
	*/
	public static final String PURCHASE_DATE="purchaseDate";
	
	/**
	 * 采购日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.util.Date> PURCHASE_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,PURCHASE_DATE, java.util.Date.class, "采购日期", "采购日期", java.util.Date.class, null);
	
	/**
	 * 生产日期 , 类型: java.util.Date
	*/
	public static final String PRODUCTION_DATE="productionDate";
	
	/**
	 * 生产日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.util.Date> PRODUCTION_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,PRODUCTION_DATE, java.util.Date.class, "生产日期", "生产日期", java.util.Date.class, null);
	
	/**
	 * 入账日期 , 类型: java.util.Date
	*/
	public static final String REGISTER_DATE="registerDate";
	
	/**
	 * 入账日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.util.Date> REGISTER_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,REGISTER_DATE, java.util.Date.class, "入账日期", "入账日期", java.util.Date.class, null);
	
	/**
	 * RFID标签 , 类型: java.lang.String
	*/
	public static final String RFID="rfid";
	
	/**
	 * RFID标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> RFID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,RFID, java.lang.String.class, "RFID标签", "RFID标签", java.lang.String.class, null);
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final String ATTACH="attach";
	
	/**
	 * 附件 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> ATTACH_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ATTACH, java.lang.String.class, "附件", "附件", java.lang.String.class, null);
	
	/**
	 * 最近核对日期 , 类型: java.util.Date
	*/
	public static final String LAST_VERIFICATION_DATE="lastVerificationDate";
	
	/**
	 * 最近核对日期 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.util.Date> LAST_VERIFICATION_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,LAST_VERIFICATION_DATE, java.util.Date.class, "最近核对日期", "最近核对日期", java.util.Date.class, null);
	
	/**
	 * 用途 , 类型: java.lang.String
	*/
	public static final String PURPOSE="purpose";
	
	/**
	 * 用途 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> PURPOSE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,PURPOSE, java.lang.String.class, "用途", "用途", java.lang.String.class, null);
	
	/**
	 * 资产备注 , 类型: java.lang.String
	*/
	public static final String ASSET_NOTES="assetNotes";
	
	/**
	 * 资产备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> ASSET_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ASSET_NOTES, java.lang.String.class, "资产备注", "资产备注", java.lang.String.class, null);
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final String MAINTAINER_ID="maintainerId";
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> MAINTAINER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MAINTAINER_ID, java.lang.String.class, "维保厂商", "维保厂商", java.lang.String.class, null);
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final String MAINTAINER_NAME="maintainerName";
	
	/**
	 * 维保厂商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> MAINTAINER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MAINTAINER_NAME, java.lang.String.class, "维保厂商", "维保厂商", java.lang.String.class, null);
	
	/**
	 * 维保状态 , 类型: java.lang.String
	*/
	public static final String MAINTENANCE_STATUS="maintenanceStatus";
	
	/**
	 * 维保状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> MAINTENANCE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MAINTENANCE_STATUS, java.lang.String.class, "维保状态", "维保状态", java.lang.String.class, null);
	
	/**
	 * 维保价格 , 类型: java.math.BigDecimal
	*/
	public static final String MAINTENANCE_PRICE="maintenancePrice";
	
	/**
	 * 维保价格 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> MAINTENANCE_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MAINTENANCE_PRICE, java.math.BigDecimal.class, "维保价格", "维保价格", java.math.BigDecimal.class, null);
	
	/**
	 * 维保方式 , 类型: java.lang.String
	*/
	public static final String MAINTENANCE_METHOD="maintenanceMethod";
	
	/**
	 * 维保方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MAINTENANCE_METHOD, java.lang.String.class, "维保方式", "维保方式", java.lang.String.class, null);
	
	/**
	 * 建议维保方式 , 类型: java.lang.String
	*/
	public static final String SUGGEST_MAINTENANCE_METHOD="suggestMaintenanceMethod";
	
	/**
	 * 建议维保方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> SUGGEST_MAINTENANCE_METHOD_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SUGGEST_MAINTENANCE_METHOD, java.lang.String.class, "建议维保方式", "建议维保方式", java.lang.String.class, null);
	
	/**
	 * 联系人 , 类型: java.lang.String
	*/
	public static final String CONTACTS="contacts";
	
	/**
	 * 联系人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> CONTACTS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CONTACTS, java.lang.String.class, "联系人", "联系人", java.lang.String.class, null);
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final String CONTACT_INFORMATION="contactInformation";
	
	/**
	 * 联系方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> CONTACT_INFORMATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CONTACT_INFORMATION, java.lang.String.class, "联系方式", "联系方式", java.lang.String.class, null);
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final String DIRECTOR="director";
	
	/**
	 * 负责人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> DIRECTOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,DIRECTOR, java.lang.String.class, "负责人", "负责人", java.lang.String.class, null);
	
	/**
	 * 维保开始时间 , 类型: java.util.Date
	*/
	public static final String MAINTENANCE_START_DATE="maintenanceStartDate";
	
	/**
	 * 维保开始时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.util.Date> MAINTENANCE_START_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MAINTENANCE_START_DATE, java.util.Date.class, "维保开始时间", "维保开始时间", java.util.Date.class, null);
	
	/**
	 * 维保到期时间 , 类型: java.util.Date
	*/
	public static final String MAINTENANCE_END_DATE="maintenanceEndDate";
	
	/**
	 * 维保到期时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.util.Date> MAINTENANCE_END_DATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MAINTENANCE_END_DATE, java.util.Date.class, "维保到期时间", "维保到期时间", java.util.Date.class, null);
	
	/**
	 * 维保备注 , 类型: java.lang.String
	*/
	public static final String MAINTENANCE_NOTES="maintenanceNotes";
	
	/**
	 * 维保备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> MAINTENANCE_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MAINTENANCE_NOTES, java.lang.String.class, "维保备注", "维保备注", java.lang.String.class, null);
	
	/**
	 * 财务分类 , 类型: java.lang.String
	*/
	public static final String FINANCIAL_CATEGORY_ID="financialCategoryId";
	
	/**
	 * 财务分类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> FINANCIAL_CATEGORY_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,FINANCIAL_CATEGORY_ID, java.lang.String.class, "财务分类", "财务分类", java.lang.String.class, null);
	
	/**
	 * 财务编号 , 类型: java.lang.String
	*/
	public static final String FINANCIAL_CODE="financialCode";
	
	/**
	 * 财务编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> FINANCIAL_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,FINANCIAL_CODE, java.lang.String.class, "财务编号", "财务编号", java.lang.String.class, null);
	
	/**
	 * 财务选项 , 类型: java.lang.String
	*/
	public static final String FINANCIAL_OPTION="financialOption";
	
	/**
	 * 财务选项 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> FINANCIAL_OPTION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,FINANCIAL_OPTION, java.lang.String.class, "财务选项", "财务选项", java.lang.String.class, null);
	
	/**
	 * 费用项目 , 类型: java.lang.String
	*/
	public static final String EXPENSE_ITEM="expenseItem";
	
	/**
	 * 费用项目 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> EXPENSE_ITEM_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,EXPENSE_ITEM, java.lang.String.class, "费用项目", "费用项目", java.lang.String.class, null);
	
	/**
	 * 资产供应商 , 类型: java.lang.String
	*/
	public static final String SUPPLIER_ID="supplierId";
	
	/**
	 * 资产供应商 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> SUPPLIER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SUPPLIER_ID, java.lang.String.class, "资产供应商", "资产供应商", java.lang.String.class, null);
	
	/**
	 * 客户信息 , 类型: java.lang.String
	*/
	public static final String CUSTOMER_INFO="customerInfo";
	
	/**
	 * 客户信息 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> CUSTOMER_INFO_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CUSTOMER_INFO, java.lang.String.class, "客户信息", "客户信息", java.lang.String.class, null);
	
	/**
	 * 含税总值 , (含税数量>2) , 类型: java.math.BigDecimal
	*/
	public static final String TAX_AMOUNT_PRICE="taxAmountPrice";
	
	/**
	 * 含税总值 , (含税数量>2) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> TAX_AMOUNT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,TAX_AMOUNT_PRICE, java.math.BigDecimal.class, "含税总值", "(含税数量>2)", java.math.BigDecimal.class, null);
	
	/**
	 * 未税总值 , (数量>2) , 类型: java.math.BigDecimal
	*/
	public static final String TOTAL_AMOUNT_PRICE="totalAmountPrice";
	
	/**
	 * 未税总值 , (数量>2) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> TOTAL_AMOUNT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,TOTAL_AMOUNT_PRICE, java.math.BigDecimal.class, "未税总值", "(数量>2)", java.math.BigDecimal.class, null);
	
	/**
	 * 含税单价 , (含税) , 类型: java.math.BigDecimal
	*/
	public static final String PURCHASE_UNIT_PRICE="purchaseUnitPrice";
	
	/**
	 * 含税单价 , (含税) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> PURCHASE_UNIT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,PURCHASE_UNIT_PRICE, java.math.BigDecimal.class, "含税单价", "(含税)", java.math.BigDecimal.class, null);
	
	/**
	 * 资产原值 , (未税) , 类型: java.math.BigDecimal
	*/
	public static final String ORIGINAL_UNIT_PRICE="originalUnitPrice";
	
	/**
	 * 资产原值 , (未税) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> ORIGINAL_UNIT_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ORIGINAL_UNIT_PRICE, java.math.BigDecimal.class, "资产原值", "(未税)", java.math.BigDecimal.class, null);
	
	/**
	 * 资产净值 , (当前) , 类型: java.math.BigDecimal
	*/
	public static final String NAV_PRICE="navPrice";
	
	/**
	 * 资产净值 , (当前) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> NAV_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,NAV_PRICE, java.math.BigDecimal.class, "资产净值", "(当前)", java.math.BigDecimal.class, null);
	
	/**
	 * 已用期限 , (月) , 类型: java.math.BigDecimal
	*/
	public static final String ASSET_USED_SERVICE_LIFE="assetUsedServiceLife";
	
	/**
	 * 已用期限 , (月) , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> ASSET_USED_SERVICE_LIFE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ASSET_USED_SERVICE_LIFE, java.math.BigDecimal.class, "已用期限", "(月)", java.math.BigDecimal.class, null);
	
	/**
	 * 最后折旧 , 类型: java.lang.String
	*/
	public static final String DEPRECIATION_ID="depreciationId";
	
	/**
	 * 最后折旧 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> DEPRECIATION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,DEPRECIATION_ID, java.lang.String.class, "最后折旧", "最后折旧", java.lang.String.class, null);
	
	/**
	 * 最后折旧时间 , 类型: java.util.Date
	*/
	public static final String DEPRECIATION_OPER_TIME="depreciationOperTime";
	
	/**
	 * 最后折旧时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.util.Date> DEPRECIATION_OPER_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,DEPRECIATION_OPER_TIME, java.util.Date.class, "最后折旧时间", "最后折旧时间", java.util.Date.class, null);
	
	/**
	 * residuals_rate , 类型: java.math.BigDecimal
	*/
	public static final String RESIDUALS_RATE="residualsRate";
	
	/**
	 * residuals_rate , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> RESIDUALS_RATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,RESIDUALS_RATE, java.math.BigDecimal.class, "residuals_rate", "residuals_rate", java.math.BigDecimal.class, null);
	
	/**
	 * 残值 , 类型: java.math.BigDecimal
	*/
	public static final String RESIDUALS_PRICE="residualsPrice";
	
	/**
	 * 残值 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> RESIDUALS_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,RESIDUALS_PRICE, java.math.BigDecimal.class, "残值", "残值", java.math.BigDecimal.class, null);
	
	/**
	 * 税额 , 类型: java.math.BigDecimal
	*/
	public static final String TAX_AMOUNT_RATE="taxAmountRate";
	
	/**
	 * 税额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> TAX_AMOUNT_RATE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,TAX_AMOUNT_RATE, java.math.BigDecimal.class, "税额", "税额", java.math.BigDecimal.class, null);
	
	/**
	 * 本年折旧 , 类型: java.math.BigDecimal
	*/
	public static final String CURRENT_YEAR_DEPRECIATION="currentYearDepreciation";
	
	/**
	 * 本年折旧 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> CURRENT_YEAR_DEPRECIATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CURRENT_YEAR_DEPRECIATION, java.math.BigDecimal.class, "本年折旧", "本年折旧", java.math.BigDecimal.class, null);
	
	/**
	 * 折旧年份 , 类型: java.lang.Integer
	*/
	public static final String DEPRECIATION_YEAR="depreciationYear";
	
	/**
	 * 折旧年份 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.Integer> DEPRECIATION_YEAR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,DEPRECIATION_YEAR, java.lang.Integer.class, "折旧年份", "折旧年份", java.lang.Integer.class, null);
	
	/**
	 * 累计折旧 , 类型: java.math.BigDecimal
	*/
	public static final String ACCUMULATED_DEPRECIATION="accumulatedDepreciation";
	
	/**
	 * 累计折旧 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> ACCUMULATED_DEPRECIATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ACCUMULATED_DEPRECIATION, java.math.BigDecimal.class, "累计折旧", "累计折旧", java.math.BigDecimal.class, null);
	
	/**
	 * 月折金额 , 类型: java.math.BigDecimal
	*/
	public static final String MONTH_DEPRECIATION_PRICE="monthDepreciationPrice";
	
	/**
	 * 月折金额 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.math.BigDecimal> MONTH_DEPRECIATION_PRICE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MONTH_DEPRECIATION_PRICE, java.math.BigDecimal.class, "月折金额", "月折金额", java.math.BigDecimal.class, null);
	
	/**
	 * 登记时间 , 类型: java.util.Date
	*/
	public static final String ENTRY_TIME="entryTime";
	
	/**
	 * 登记时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.util.Date> ENTRY_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ENTRY_TIME, java.util.Date.class, "登记时间", "登记时间", java.util.Date.class, null);
	
	/**
	 * 财务备注 , 类型: java.lang.String
	*/
	public static final String FINANCIAL_NOTES="financialNotes";
	
	/**
	 * 财务备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> FINANCIAL_NOTES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,FINANCIAL_NOTES, java.lang.String.class, "财务备注", "财务备注", java.lang.String.class, null);
	
	/**
	 * 设备编号 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_CODE="equipmentCode";
	
	/**
	 * 设备编号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> EQUIPMENT_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,EQUIPMENT_CODE, java.lang.String.class, "设备编号", "设备编号", java.lang.String.class, null);
	
	/**
	 * 设备状态 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_STATUS="equipmentStatus";
	
	/**
	 * 设备状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> EQUIPMENT_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,EQUIPMENT_STATUS, java.lang.String.class, "设备状态", "设备状态", java.lang.String.class, null);
	
	/**
	 * 设备IP , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_IP="equipmentIp";
	
	/**
	 * 设备IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> EQUIPMENT_IP_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,EQUIPMENT_IP, java.lang.String.class, "设备IP", "设备IP", java.lang.String.class, null);
	
	/**
	 * 管理IP , 类型: java.lang.String
	*/
	public static final String MANAGE_IP="manageIp";
	
	/**
	 * 管理IP , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> MANAGE_IP_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MANAGE_IP, java.lang.String.class, "管理IP", "管理IP", java.lang.String.class, null);
	
	/**
	 * 设备CPU , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_CPU="equipmentCpu";
	
	/**
	 * 设备CPU , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> EQUIPMENT_CPU_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,EQUIPMENT_CPU, java.lang.String.class, "设备CPU", "设备CPU", java.lang.String.class, null);
	
	/**
	 * 设备内存 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_MEMORY="equipmentMemory";
	
	/**
	 * 设备内存 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> EQUIPMENT_MEMORY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,EQUIPMENT_MEMORY, java.lang.String.class, "设备内存", "设备内存", java.lang.String.class, null);
	
	/**
	 * 设备标签 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_LABEL="equipmentLabel";
	
	/**
	 * 设备标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> EQUIPMENT_LABEL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,EQUIPMENT_LABEL, java.lang.String.class, "设备标签", "设备标签", java.lang.String.class, null);
	
	/**
	 * 设备配置 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_CONF="equipmentConf";
	
	/**
	 * 设备配置 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> EQUIPMENT_CONF_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,EQUIPMENT_CONF, java.lang.String.class, "设备配置", "设备配置", java.lang.String.class, null);
	
	/**
	 * 设备运行环境 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_ENVIRONMENT_CODE="equipmentEnvironmentCode";
	
	/**
	 * 设备运行环境 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> EQUIPMENT_ENVIRONMENT_CODE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,EQUIPMENT_ENVIRONMENT_CODE, java.lang.String.class, "设备运行环境", "设备运行环境", java.lang.String.class, null);
	
	/**
	 * 设备序列号 , 类型: java.lang.String
	*/
	public static final String EQUIPMENT_SERIAL_NUMBER="equipmentSerialNumber";
	
	/**
	 * 设备序列号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> EQUIPMENT_SERIAL_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,EQUIPMENT_SERIAL_NUMBER, java.lang.String.class, "设备序列号", "设备序列号", java.lang.String.class, null);
	
	/**
	 * 设备机柜 , 类型: java.lang.String
	*/
	public static final String RACK_ID="rackId";
	
	/**
	 * 设备机柜 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> RACK_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,RACK_ID, java.lang.String.class, "设备机柜", "设备机柜", java.lang.String.class, null);
	
	/**
	 * 设备机柜上位置 , 类型: java.lang.Integer
	*/
	public static final String RACK_UP_NUMBER="rackUpNumber";
	
	/**
	 * 设备机柜上位置 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.Integer> RACK_UP_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,RACK_UP_NUMBER, java.lang.Integer.class, "设备机柜上位置", "设备机柜上位置", java.lang.Integer.class, null);
	
	/**
	 * 设备机柜下位置 , 类型: java.lang.Integer
	*/
	public static final String RACK_DOWN_NUMBER="rackDownNumber";
	
	/**
	 * 设备机柜下位置 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.Integer> RACK_DOWN_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,RACK_DOWN_NUMBER, java.lang.Integer.class, "设备机柜下位置", "设备机柜下位置", java.lang.Integer.class, null);
	
	/**
	 * 短标签1 , 类型: java.lang.String
	*/
	public static final String LABEL="label";
	
	/**
	 * 短标签1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> LABEL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,LABEL, java.lang.String.class, "短标签1", "短标签1", java.lang.String.class, null);
	
	/**
	 * 长标签2 , 类型: java.lang.String
	*/
	public static final String LABEL2="label2";
	
	/**
	 * 长标签2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> LABEL2_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,LABEL2, java.lang.String.class, "长标签2", "长标签2", java.lang.String.class, null);
	
	/**
	 * 短标签3 , 类型: java.lang.String
	*/
	public static final String LABEL3="label3";
	
	/**
	 * 短标签3 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> LABEL3_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,LABEL3, java.lang.String.class, "短标签3", "短标签3", java.lang.String.class, null);
	
	/**
	 * 长标签4 , 类型: java.lang.String
	*/
	public static final String LABEL4="label4";
	
	/**
	 * 长标签4 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> LABEL4_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,LABEL4, java.lang.String.class, "长标签4", "长标签4", java.lang.String.class, null);
	
	/**
	 * 短标签5 , 类型: java.lang.String
	*/
	public static final String LABEL5="label5";
	
	/**
	 * 短标签5 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> LABEL5_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,LABEL5, java.lang.String.class, "短标签5", "短标签5", java.lang.String.class, null);
	
	/**
	 * 单据 , 类型: java.lang.String
	*/
	public static final String BILL_ID="billId";
	
	/**
	 * 单据 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> BILL_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,BILL_ID, java.lang.String.class, "单据", "单据", java.lang.String.class, null);
	
	/**
	 * 内部控制标签 , 类型: java.lang.String
	*/
	public static final String INTERNAL_CONTROL_LABEL="internalControlLabel";
	
	/**
	 * 内部控制标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> INTERNAL_CONTROL_LABEL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,INTERNAL_CONTROL_LABEL, java.lang.String.class, "内部控制标签", "内部控制标签", java.lang.String.class, null);
	
	/**
	 * 领用ID , 类型: java.lang.String
	*/
	public static final String COLLECTION_ID="collectionId";
	
	/**
	 * 领用ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> COLLECTION_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,COLLECTION_ID, java.lang.String.class, "领用ID", "领用ID", java.lang.String.class, null);
	
	/**
	 * 借用ID , 类型: java.lang.String
	*/
	public static final String BORROW_ID="borrowId";
	
	/**
	 * 借用ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> BORROW_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,BORROW_ID, java.lang.String.class, "借用ID", "借用ID", java.lang.String.class, null);
	
	/**
	 * 报废ID , 类型: java.lang.String
	*/
	public static final String SCRAP_ID="scrapId";
	
	/**
	 * 报废ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> SCRAP_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SCRAP_ID, java.lang.String.class, "报废ID", "报废ID", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 版本 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,VERSION, java.lang.Integer.class, "版本", "版本", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final String ORIGINATOR_ID="originatorId";
	
	/**
	 * 制单人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> ORIGINATOR_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ORIGINATOR_ID, java.lang.String.class, "制单人", "制单人", java.lang.String.class, null);
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final String CHS_TYPE="chsType";
	
	/**
	 * 变更类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> CHS_TYPE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CHS_TYPE, java.lang.String.class, "变更类型", "变更类型", java.lang.String.class, null);
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final String CHS_STATUS="chsStatus";
	
	/**
	 * 变更状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> CHS_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CHS_STATUS, java.lang.String.class, "变更状态", "变更状态", java.lang.String.class, null);
	
	/**
	 * 变更版本号 , 类型: java.lang.String
	*/
	public static final String CHS_VERSION="chsVersion";
	
	/**
	 * 变更版本号 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> CHS_VERSION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CHS_VERSION, java.lang.String.class, "变更版本号", "变更版本号", java.lang.String.class, null);
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final String CHANGE_INSTANCE_ID="changeInstanceId";
	
	/**
	 * 变更ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> CHANGE_INSTANCE_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CHANGE_INSTANCE_ID, java.lang.String.class, "变更ID", "变更ID", java.lang.String.class, null);
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final String SUMMARY="summary";
	
	/**
	 * 流程概要 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> SUMMARY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SUMMARY, java.lang.String.class, "流程概要", "流程概要", java.lang.String.class, null);
	
	/**
	 * 最后审批人账户ID , 类型: java.lang.String
	*/
	public static final String LATEST_APPROVER_ID="latestApproverId";
	
	/**
	 * 最后审批人账户ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> LATEST_APPROVER_ID_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,LATEST_APPROVER_ID, java.lang.String.class, "最后审批人账户ID", "最后审批人账户ID", java.lang.String.class, null);
	
	/**
	 * 最后审批人姓名 , 类型: java.lang.String
	*/
	public static final String LATEST_APPROVER_NAME="latestApproverName";
	
	/**
	 * 最后审批人姓名 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> LATEST_APPROVER_NAME_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,LATEST_APPROVER_NAME, java.lang.String.class, "最后审批人姓名", "最后审批人姓名", java.lang.String.class, null);
	
	/**
	 * 下一节点审批人 , 类型: java.lang.String
	*/
	public static final String NEXT_APPROVER_IDS="nextApproverIds";
	
	/**
	 * 下一节点审批人 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> NEXT_APPROVER_IDS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,NEXT_APPROVER_IDS, java.lang.String.class, "下一节点审批人", "下一节点审批人", java.lang.String.class, null);
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final String NEXT_APPROVER_NAMES="nextApproverNames";
	
	/**
	 * 下一个审批节点审批人姓名 , 用逗号隔开 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> NEXT_APPROVER_NAMES_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,NEXT_APPROVER_NAMES, java.lang.String.class, "下一个审批节点审批人姓名", "用逗号隔开", java.lang.String.class, null);
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final String APPROVAL_OPINION="approvalOpinion";
	
	/**
	 * 审批意见 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> APPROVAL_OPINION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,APPROVAL_OPINION, java.lang.String.class, "审批意见", "审批意见", java.lang.String.class, null);
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final String ASSET_SELECTED_DATA="assetSelectedData";
	
	/**
	 * 选择 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.String> ASSET_SELECTED_DATA_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ASSET_SELECTED_DATA, java.lang.String.class, "选择", "选择", java.lang.String.class, null);
	
	/**
	 * 扩展数据 , 类型: com.dt.platform.domain.eam.AssetExtData
	*/
	public static final String EXT_DATA="extData";
	
	/**
	 * 扩展数据 , 类型: com.dt.platform.domain.eam.AssetExtData
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.AssetExtData> EXT_DATA_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,EXT_DATA, com.dt.platform.domain.eam.AssetExtData.class, "扩展数据", "扩展数据", com.dt.platform.domain.eam.AssetExtData.class, null);
	
	/**
	 * PCM数据 , 集合类型: MAP , 类型: java.lang.Object
	*/
	public static final String PCM_DATA="pcmData";
	
	/**
	 * PCM数据 , 集合类型: MAP , 类型: java.lang.Object
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,java.lang.Object> PCM_DATA_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,PCM_DATA, java.util.Map.class, "PCM数据", "PCM数据", java.lang.Object.class, java.lang.String.class);
	
	/**
	 * 自定义数据属性字段 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.CatalogAttribute
	*/
	public static final String CATALOG_ATTRIBUTE="catalogAttribute";
	
	/**
	 * 自定义数据属性字段 , 集合类型: LIST , 类型: org.github.foxnic.web.domain.pcm.CatalogAttribute
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.pcm.CatalogAttribute> CATALOG_ATTRIBUTE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CATALOG_ATTRIBUTE, java.util.List.class, "自定义数据属性字段", "自定义数据属性字段", org.github.foxnic.web.domain.pcm.CatalogAttribute.class, null);
	
	/**
	 * 存放位置 , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final String POSITION="position";
	
	/**
	 * 存放位置 , 类型: com.dt.platform.domain.eam.Position
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.Position> POSITION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,POSITION, com.dt.platform.domain.eam.Position.class, "存放位置", "存放位置", com.dt.platform.domain.eam.Position.class, null);
	
	/**
	 * 财务分类 , 类型: com.dt.platform.domain.eam.CategoryFinance
	*/
	public static final String CATEGORY_FINANCE="categoryFinance";
	
	/**
	 * 财务分类 , 类型: com.dt.platform.domain.eam.CategoryFinance
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.CategoryFinance> CATEGORY_FINANCE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CATEGORY_FINANCE, com.dt.platform.domain.eam.CategoryFinance.class, "财务分类", "财务分类", com.dt.platform.domain.eam.CategoryFinance.class, null);
	
	/**
	 * 资产分类 , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final String CATEGORY="category";
	
	/**
	 * 资产分类 , 类型: org.github.foxnic.web.domain.pcm.Catalog
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.pcm.Catalog> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CATEGORY, org.github.foxnic.web.domain.pcm.Catalog.class, "资产分类", "资产分类", org.github.foxnic.web.domain.pcm.Catalog.class, null);
	
	/**
	 * 物品档案 , 类型: com.dt.platform.domain.eam.Goods
	*/
	public static final String GOODS="goods";
	
	/**
	 * 物品档案 , 类型: com.dt.platform.domain.eam.Goods
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.Goods> GOODS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,GOODS, com.dt.platform.domain.eam.Goods.class, "物品档案", "物品档案", com.dt.platform.domain.eam.Goods.class, null);
	
	/**
	 * 生产厂商 , 类型: com.dt.platform.domain.eam.Manufacturer
	*/
	public static final String MANUFACTURER="manufacturer";
	
	/**
	 * 生产厂商 , 类型: com.dt.platform.domain.eam.Manufacturer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.Manufacturer> MANUFACTURER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MANUFACTURER, com.dt.platform.domain.eam.Manufacturer.class, "生产厂商", "生产厂商", com.dt.platform.domain.eam.Manufacturer.class, null);
	
	/**
	 * 仓库 , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final String WAREHOUSE="warehouse";
	
	/**
	 * 仓库 , 类型: com.dt.platform.domain.eam.Warehouse
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.Warehouse> WAREHOUSE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,WAREHOUSE, com.dt.platform.domain.eam.Warehouse.class, "仓库", "仓库", com.dt.platform.domain.eam.Warehouse.class, null);
	
	/**
	 * 使用人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String USE_USER="useUser";
	
	/**
	 * 使用人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.hrm.Employee> USE_USER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,USE_USER, org.github.foxnic.web.domain.hrm.Employee.class, "使用人员", "使用人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 管理人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String MANAGER="manager";
	
	/**
	 * 管理人员 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.hrm.Employee> MANAGER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MANAGER, org.github.foxnic.web.domain.hrm.Employee.class, "管理人员", "管理人员", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final String ORIGINATOR="originator";
	
	/**
	 * 制单人 , 类型: org.github.foxnic.web.domain.hrm.Employee
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.hrm.Employee> ORIGINATOR_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ORIGINATOR, org.github.foxnic.web.domain.hrm.Employee.class, "制单人", "制单人", org.github.foxnic.web.domain.hrm.Employee.class, null);
	
	/**
	 * 供应商 , 类型: com.dt.platform.domain.eam.Supplier
	*/
	public static final String SUPPLIER="supplier";
	
	/**
	 * 供应商 , 类型: com.dt.platform.domain.eam.Supplier
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.Supplier> SUPPLIER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SUPPLIER, com.dt.platform.domain.eam.Supplier.class, "供应商", "供应商", com.dt.platform.domain.eam.Supplier.class, null);
	
	/**
	 * 维保商 , 类型: com.dt.platform.domain.eam.Maintainer
	*/
	public static final String MAINTNAINER="maintnainer";
	
	/**
	 * 维保商 , 类型: com.dt.platform.domain.eam.Maintainer
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.Maintainer> MAINTNAINER_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MAINTNAINER, com.dt.platform.domain.eam.Maintainer.class, "维保商", "维保商", com.dt.platform.domain.eam.Maintainer.class, null);
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String OWNER_COMPANY="ownerCompany";
	
	/**
	 * 所属公司 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.hrm.Organization> OWNER_COMPANY_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,OWNER_COMPANY, org.github.foxnic.web.domain.hrm.Organization.class, "所属公司", "所属公司", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final String USE_ORGANIZATION="useOrganization";
	
	/**
	 * 使用公司/部门 , 类型: org.github.foxnic.web.domain.hrm.Organization
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.hrm.Organization> USE_ORGANIZATION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,USE_ORGANIZATION, org.github.foxnic.web.domain.hrm.Organization.class, "使用公司/部门", "使用公司/部门", org.github.foxnic.web.domain.hrm.Organization.class, null);
	
	/**
	 * 来源 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SOURCE="source";
	
	/**
	 * 来源 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.system.DictItem> SOURCE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SOURCE, org.github.foxnic.web.domain.system.DictItem.class, "来源", "来源", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 设备运行环境 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String EQUIPMENT_ENVIRONMENT="equipmentEnvironment";
	
	/**
	 * 设备运行环境 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.system.DictItem> EQUIPMENT_ENVIRONMENT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,EQUIPMENT_ENVIRONMENT, org.github.foxnic.web.domain.system.DictItem.class, "设备运行环境", "设备运行环境", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 安全等级 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SAFETY_LEVEL="safetyLevel";
	
	/**
	 * 安全等级 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.system.DictItem> SAFETY_LEVEL_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SAFETY_LEVEL, org.github.foxnic.web.domain.system.DictItem.class, "安全等级", "安全等级", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 维保状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String ASSET_MAINTENANCE_STATUS="assetMaintenanceStatus";
	
	/**
	 * 维保状态 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.system.DictItem> ASSET_MAINTENANCE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ASSET_MAINTENANCE_STATUS, org.github.foxnic.web.domain.system.DictItem.class, "维保状态", "维保状态", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 建议维保方式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String SUGGEST_MAINTENANCE_METHOD_DATA="suggestMaintenanceMethodData";
	
	/**
	 * 建议维保方式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.system.DictItem> SUGGEST_MAINTENANCE_METHOD_DATA_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,SUGGEST_MAINTENANCE_METHOD_DATA, org.github.foxnic.web.domain.system.DictItem.class, "建议维保方式", "建议维保方式", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 维保方式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String MAINTENANCE_METHOD_DATA="maintenanceMethodData";
	
	/**
	 * 维保方式 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.system.DictItem> MAINTENANCE_METHOD_DATA_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,MAINTENANCE_METHOD_DATA, org.github.foxnic.web.domain.system.DictItem.class, "维保方式", "维保方式", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * assetCycleStatus , 类型: com.dt.platform.domain.eam.AssetStatus
	*/
	public static final String ASSET_CYCLE_STATUS="assetCycleStatus";
	
	/**
	 * assetCycleStatus , 类型: com.dt.platform.domain.eam.AssetStatus
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.AssetStatus> ASSET_CYCLE_STATUS_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ASSET_CYCLE_STATUS, com.dt.platform.domain.eam.AssetStatus.class, "assetCycleStatus", "assetCycleStatus", com.dt.platform.domain.eam.AssetStatus.class, null);
	
	/**
	 * 机柜 , 类型: com.dt.platform.domain.eam.AssetRack
	*/
	public static final String RACK="rack";
	
	/**
	 * 机柜 , 类型: com.dt.platform.domain.eam.AssetRack
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.AssetRack> RACK_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,RACK, com.dt.platform.domain.eam.AssetRack.class, "机柜", "机柜", com.dt.platform.domain.eam.AssetRack.class, null);
	
	/**
	 * 变更实例 , 类型: org.github.foxnic.web.domain.changes.ChangeInstance
	*/
	public static final String CHANGE_INSTANCE="changeInstance";
	
	/**
	 * 变更实例 , 类型: org.github.foxnic.web.domain.changes.ChangeInstance
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.changes.ChangeInstance> CHANGE_INSTANCE_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,CHANGE_INSTANCE, org.github.foxnic.web.domain.changes.ChangeInstance.class, "变更实例", "变更实例", org.github.foxnic.web.domain.changes.ChangeInstance.class, null);
	
	/**
	 * 库存物品 , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final String GOODS_STOCK="goodsStock";
	
	/**
	 * 库存物品 , 类型: com.dt.platform.domain.eam.GoodsStock
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.GoodsStock> GOODS_STOCK_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,GOODS_STOCK, com.dt.platform.domain.eam.GoodsStock.class, "库存物品", "库存物品", com.dt.platform.domain.eam.GoodsStock.class, null);
	
	/**
	 * 存放区域 , 类型: com.dt.platform.domain.eam.AssetRegion
	*/
	public static final String REGION="region";
	
	/**
	 * 存放区域 , 类型: com.dt.platform.domain.eam.AssetRegion
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.AssetRegion> REGION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,REGION, com.dt.platform.domain.eam.AssetRegion.class, "存放区域", "存放区域", com.dt.platform.domain.eam.AssetRegion.class, null);
	
	/**
	 * 财务选项 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String FINANCIAL_OPTION_DICT="financialOptionDict";
	
	/**
	 * 财务选项 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.system.DictItem> FINANCIAL_OPTION_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,FINANCIAL_OPTION_DICT, org.github.foxnic.web.domain.system.DictItem.class, "财务选项", "财务选项", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * 费用项目 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final String EXPENSE_ITEM_DICT="expenseItemDict";
	
	/**
	 * 费用项目 , 类型: org.github.foxnic.web.domain.system.DictItem
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,org.github.foxnic.web.domain.system.DictItem> EXPENSE_ITEM_DICT_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,EXPENSE_ITEM_DICT, org.github.foxnic.web.domain.system.DictItem.class, "费用项目", "费用项目", org.github.foxnic.web.domain.system.DictItem.class, null);
	
	/**
	 * assetCollection , 类型: com.dt.platform.domain.eam.AssetCollection
	*/
	public static final String ASSET_COLLECTION="assetCollection";
	
	/**
	 * assetCollection , 类型: com.dt.platform.domain.eam.AssetCollection
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.AssetCollection> ASSET_COLLECTION_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ASSET_COLLECTION, com.dt.platform.domain.eam.AssetCollection.class, "assetCollection", "assetCollection", com.dt.platform.domain.eam.AssetCollection.class, null);
	
	/**
	 * assetBorrow , 类型: com.dt.platform.domain.eam.AssetBorrow
	*/
	public static final String ASSET_BORROW="assetBorrow";
	
	/**
	 * assetBorrow , 类型: com.dt.platform.domain.eam.AssetBorrow
	*/
	public static final BeanProperty<com.dt.platform.domain.eam.AssetVO,com.dt.platform.domain.eam.AssetBorrow> ASSET_BORROW_PROP = new BeanProperty(com.dt.platform.domain.eam.AssetVO.class ,ASSET_BORROW, com.dt.platform.domain.eam.AssetBorrow.class, "assetBorrow", "assetBorrow", com.dt.platform.domain.eam.AssetBorrow.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , IDS , ID , CATEGORY_ID , CATEGORY_CODE , BUSINESS_CODE , PROC_ID , STATUS , BATCH_CODE , OWNER_CODE , ASSET_CODE , ASSET_STATUS , DISPLAY , CLEAN_OUT , GOODS_ID , NAME , MANUFACTURER_ID , MODEL , PICTURE_ID , UNIT , SERVICE_LIFE , SAFETY_LEVEL_CODE , SERIAL_NUMBER , OWN_COMPANY_ID , MANAGER_ID , USE_ORGANIZATION_ID , USE_USER_ID , REGION_ID , POSITION_ID , POSITION_DETAIL , WAREHOUSE_ID , GOODS_STOCK_ID , SOURCE_ID , ASSET_NUMBER , REMAIN_NUMBER , PURCHASE_DATE , PRODUCTION_DATE , REGISTER_DATE , RFID , ATTACH , LAST_VERIFICATION_DATE , PURPOSE , ASSET_NOTES , MAINTAINER_ID , MAINTAINER_NAME , MAINTENANCE_STATUS , MAINTENANCE_PRICE , MAINTENANCE_METHOD , SUGGEST_MAINTENANCE_METHOD , CONTACTS , CONTACT_INFORMATION , DIRECTOR , MAINTENANCE_START_DATE , MAINTENANCE_END_DATE , MAINTENANCE_NOTES , FINANCIAL_CATEGORY_ID , FINANCIAL_CODE , FINANCIAL_OPTION , EXPENSE_ITEM , SUPPLIER_ID , CUSTOMER_INFO , TAX_AMOUNT_PRICE , TOTAL_AMOUNT_PRICE , PURCHASE_UNIT_PRICE , ORIGINAL_UNIT_PRICE , NAV_PRICE , ASSET_USED_SERVICE_LIFE , DEPRECIATION_ID , DEPRECIATION_OPER_TIME , RESIDUALS_RATE , RESIDUALS_PRICE , TAX_AMOUNT_RATE , CURRENT_YEAR_DEPRECIATION , DEPRECIATION_YEAR , ACCUMULATED_DEPRECIATION , MONTH_DEPRECIATION_PRICE , ENTRY_TIME , FINANCIAL_NOTES , EQUIPMENT_CODE , EQUIPMENT_STATUS , EQUIPMENT_IP , MANAGE_IP , EQUIPMENT_CPU , EQUIPMENT_MEMORY , EQUIPMENT_LABEL , EQUIPMENT_CONF , EQUIPMENT_ENVIRONMENT_CODE , EQUIPMENT_SERIAL_NUMBER , RACK_ID , RACK_UP_NUMBER , RACK_DOWN_NUMBER , LABEL , LABEL2 , LABEL3 , LABEL4 , LABEL5 , BILL_ID , INTERNAL_CONTROL_LABEL , COLLECTION_ID , BORROW_ID , SCRAP_ID , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , ORIGINATOR_ID , CHS_TYPE , CHS_STATUS , CHS_VERSION , CHANGE_INSTANCE_ID , SUMMARY , LATEST_APPROVER_ID , LATEST_APPROVER_NAME , NEXT_APPROVER_IDS , NEXT_APPROVER_NAMES , APPROVAL_OPINION , ASSET_SELECTED_DATA , EXT_DATA , PCM_DATA , CATALOG_ATTRIBUTE , POSITION , CATEGORY_FINANCE , CATEGORY , GOODS , MANUFACTURER , WAREHOUSE , USE_USER , MANAGER , ORIGINATOR , SUPPLIER , MAINTNAINER , OWNER_COMPANY , USE_ORGANIZATION , SOURCE , EQUIPMENT_ENVIRONMENT , SAFETY_LEVEL , ASSET_MAINTENANCE_STATUS , SUGGEST_MAINTENANCE_METHOD_DATA , MAINTENANCE_METHOD_DATA , ASSET_CYCLE_STATUS , RACK , CHANGE_INSTANCE , GOODS_STOCK , REGION , FINANCIAL_OPTION_DICT , EXPENSE_ITEM_DICT , ASSET_COLLECTION , ASSET_BORROW };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.eam.AssetVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public AssetVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public AssetVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public AssetVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public AssetVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public AssetVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public AssetVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public AssetVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public AssetVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public AssetVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Asset setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param categoryId 资产分类
		 * @return 当前对象
		*/
		public Asset setCategoryId(String categoryId) {
			super.change(CATEGORY_ID,super.getCategoryId(),categoryId);
			super.setCategoryId(categoryId);
			return this;
		}
		
		/**
		 * 设置 分类编码
		 * @param categoryCode 分类编码
		 * @return 当前对象
		*/
		public Asset setCategoryCode(String categoryCode) {
			super.change(CATEGORY_CODE,super.getCategoryCode(),categoryCode);
			super.setCategoryCode(categoryCode);
			return this;
		}
		
		/**
		 * 设置 业务编号
		 * @param businessCode 业务编号
		 * @return 当前对象
		*/
		public Asset setBusinessCode(String businessCode) {
			super.change(BUSINESS_CODE,super.getBusinessCode(),businessCode);
			super.setBusinessCode(businessCode);
			return this;
		}
		
		/**
		 * 设置 流程
		 * @param procId 流程
		 * @return 当前对象
		*/
		public Asset setProcId(String procId) {
			super.change(PROC_ID,super.getProcId(),procId);
			super.setProcId(procId);
			return this;
		}
		
		/**
		 * 设置 办理状态
		 * @param status 办理状态
		 * @return 当前对象
		*/
		public Asset setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 批次编码
		 * @param batchCode 批次编码
		 * @return 当前对象
		*/
		public Asset setBatchCode(String batchCode) {
			super.change(BATCH_CODE,super.getBatchCode(),batchCode);
			super.setBatchCode(batchCode);
			return this;
		}
		
		/**
		 * 设置 归属
		 * @param ownerCode 归属
		 * @return 当前对象
		*/
		public Asset setOwnerCode(String ownerCode) {
			super.change(OWNER_CODE,super.getOwnerCode(),ownerCode);
			super.setOwnerCode(ownerCode);
			return this;
		}
		
		/**
		 * 设置 资产编号
		 * @param assetCode 资产编号
		 * @return 当前对象
		*/
		public Asset setAssetCode(String assetCode) {
			super.change(ASSET_CODE,super.getAssetCode(),assetCode);
			super.setAssetCode(assetCode);
			return this;
		}
		
		/**
		 * 设置 资产状态
		 * @param assetStatus 资产状态
		 * @return 当前对象
		*/
		public Asset setAssetStatus(String assetStatus) {
			super.change(ASSET_STATUS,super.getAssetStatus(),assetStatus);
			super.setAssetStatus(assetStatus);
			return this;
		}
		
		/**
		 * 设置 是否显示
		 * @param display 是否显示
		 * @return 当前对象
		*/
		public Asset setDisplay(String display) {
			super.change(DISPLAY,super.getDisplay(),display);
			super.setDisplay(display);
			return this;
		}
		
		/**
		 * 设置 是否清理
		 * @param cleanOut 是否清理
		 * @return 当前对象
		*/
		public Asset setCleanOut(String cleanOut) {
			super.change(CLEAN_OUT,super.getCleanOut(),cleanOut);
			super.setCleanOut(cleanOut);
			return this;
		}
		
		/**
		 * 设置 标准物品档案
		 * @param goodsId 标准物品档案
		 * @return 当前对象
		*/
		public Asset setGoodsId(String goodsId) {
			super.change(GOODS_ID,super.getGoodsId(),goodsId);
			super.setGoodsId(goodsId);
			return this;
		}
		
		/**
		 * 设置 标准型号资产名称
		 * @param name 标准型号资产名称
		 * @return 当前对象
		*/
		public Asset setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 标准型号厂商
		 * @param manufacturerId 标准型号厂商
		 * @return 当前对象
		*/
		public Asset setManufacturerId(String manufacturerId) {
			super.change(MANUFACTURER_ID,super.getManufacturerId(),manufacturerId);
			super.setManufacturerId(manufacturerId);
			return this;
		}
		
		/**
		 * 设置 标准型号规格型号
		 * @param model 标准型号规格型号
		 * @return 当前对象
		*/
		public Asset setModel(String model) {
			super.change(MODEL,super.getModel(),model);
			super.setModel(model);
			return this;
		}
		
		/**
		 * 设置 标准型号物品图片
		 * @param pictureId 标准型号物品图片
		 * @return 当前对象
		*/
		public Asset setPictureId(String pictureId) {
			super.change(PICTURE_ID,super.getPictureId(),pictureId);
			super.setPictureId(pictureId);
			return this;
		}
		
		/**
		 * 设置 标准型号计量单位
		 * @param unit 标准型号计量单位
		 * @return 当前对象
		*/
		public Asset setUnit(String unit) {
			super.change(UNIT,super.getUnit(),unit);
			super.setUnit(unit);
			return this;
		}
		
		/**
		 * 设置 使用期限
		 * @param serviceLife 使用期限
		 * @return 当前对象
		*/
		public Asset setServiceLife(BigDecimal serviceLife) {
			super.change(SERVICE_LIFE,super.getServiceLife(),serviceLife);
			super.setServiceLife(serviceLife);
			return this;
		}
		
		/**
		 * 设置 安全等级
		 * @param safetyLevelCode 安全等级
		 * @return 当前对象
		*/
		public Asset setSafetyLevelCode(String safetyLevelCode) {
			super.change(SAFETY_LEVEL_CODE,super.getSafetyLevelCode(),safetyLevelCode);
			super.setSafetyLevelCode(safetyLevelCode);
			return this;
		}
		
		/**
		 * 设置 序列号
		 * @param serialNumber 序列号
		 * @return 当前对象
		*/
		public Asset setSerialNumber(String serialNumber) {
			super.change(SERIAL_NUMBER,super.getSerialNumber(),serialNumber);
			super.setSerialNumber(serialNumber);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownCompanyId 所属公司
		 * @return 当前对象
		*/
		public Asset setOwnCompanyId(String ownCompanyId) {
			super.change(OWN_COMPANY_ID,super.getOwnCompanyId(),ownCompanyId);
			super.setOwnCompanyId(ownCompanyId);
			return this;
		}
		
		/**
		 * 设置 管理人员
		 * @param managerId 管理人员
		 * @return 当前对象
		*/
		public Asset setManagerId(String managerId) {
			super.change(MANAGER_ID,super.getManagerId(),managerId);
			super.setManagerId(managerId);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganizationId 使用公司/部门
		 * @return 当前对象
		*/
		public Asset setUseOrganizationId(String useOrganizationId) {
			super.change(USE_ORGANIZATION_ID,super.getUseOrganizationId(),useOrganizationId);
			super.setUseOrganizationId(useOrganizationId);
			return this;
		}
		
		/**
		 * 设置 使用人员
		 * @param useUserId 使用人员
		 * @return 当前对象
		*/
		public Asset setUseUserId(String useUserId) {
			super.change(USE_USER_ID,super.getUseUserId(),useUserId);
			super.setUseUserId(useUserId);
			return this;
		}
		
		/**
		 * 设置 存放区域
		 * @param regionId 存放区域
		 * @return 当前对象
		*/
		public Asset setRegionId(String regionId) {
			super.change(REGION_ID,super.getRegionId(),regionId);
			super.setRegionId(regionId);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param positionId 存放位置
		 * @return 当前对象
		*/
		public Asset setPositionId(String positionId) {
			super.change(POSITION_ID,super.getPositionId(),positionId);
			super.setPositionId(positionId);
			return this;
		}
		
		/**
		 * 设置 详细位置
		 * @param positionDetail 详细位置
		 * @return 当前对象
		*/
		public Asset setPositionDetail(String positionDetail) {
			super.change(POSITION_DETAIL,super.getPositionDetail(),positionDetail);
			super.setPositionDetail(positionDetail);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param warehouseId 仓库
		 * @return 当前对象
		*/
		public Asset setWarehouseId(String warehouseId) {
			super.change(WAREHOUSE_ID,super.getWarehouseId(),warehouseId);
			super.setWarehouseId(warehouseId);
			return this;
		}
		
		/**
		 * 设置 库存物品
		 * @param goodsStockId 库存物品
		 * @return 当前对象
		*/
		public Asset setGoodsStockId(String goodsStockId) {
			super.change(GOODS_STOCK_ID,super.getGoodsStockId(),goodsStockId);
			super.setGoodsStockId(goodsStockId);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param sourceId 来源
		 * @return 当前对象
		*/
		public Asset setSourceId(String sourceId) {
			super.change(SOURCE_ID,super.getSourceId(),sourceId);
			super.setSourceId(sourceId);
			return this;
		}
		
		/**
		 * 设置 资产数量
		 * @param assetNumber 资产数量
		 * @return 当前对象
		*/
		public Asset setAssetNumber(Integer assetNumber) {
			super.change(ASSET_NUMBER,super.getAssetNumber(),assetNumber);
			super.setAssetNumber(assetNumber);
			return this;
		}
		
		/**
		 * 设置 剩余数量
		 * @param remainNumber 剩余数量
		 * @return 当前对象
		*/
		public Asset setRemainNumber(Integer remainNumber) {
			super.change(REMAIN_NUMBER,super.getRemainNumber(),remainNumber);
			super.setRemainNumber(remainNumber);
			return this;
		}
		
		/**
		 * 设置 采购日期
		 * @param purchaseDate 采购日期
		 * @return 当前对象
		*/
		public Asset setPurchaseDate(Date purchaseDate) {
			super.change(PURCHASE_DATE,super.getPurchaseDate(),purchaseDate);
			super.setPurchaseDate(purchaseDate);
			return this;
		}
		
		/**
		 * 设置 生产日期
		 * @param productionDate 生产日期
		 * @return 当前对象
		*/
		public Asset setProductionDate(Date productionDate) {
			super.change(PRODUCTION_DATE,super.getProductionDate(),productionDate);
			super.setProductionDate(productionDate);
			return this;
		}
		
		/**
		 * 设置 入账日期
		 * @param registerDate 入账日期
		 * @return 当前对象
		*/
		public Asset setRegisterDate(Date registerDate) {
			super.change(REGISTER_DATE,super.getRegisterDate(),registerDate);
			super.setRegisterDate(registerDate);
			return this;
		}
		
		/**
		 * 设置 RFID标签
		 * @param rfid RFID标签
		 * @return 当前对象
		*/
		public Asset setRfid(String rfid) {
			super.change(RFID,super.getRfid(),rfid);
			super.setRfid(rfid);
			return this;
		}
		
		/**
		 * 设置 附件
		 * @param attach 附件
		 * @return 当前对象
		*/
		public Asset setAttach(String attach) {
			super.change(ATTACH,super.getAttach(),attach);
			super.setAttach(attach);
			return this;
		}
		
		/**
		 * 设置 最近核对日期
		 * @param lastVerificationDate 最近核对日期
		 * @return 当前对象
		*/
		public Asset setLastVerificationDate(Date lastVerificationDate) {
			super.change(LAST_VERIFICATION_DATE,super.getLastVerificationDate(),lastVerificationDate);
			super.setLastVerificationDate(lastVerificationDate);
			return this;
		}
		
		/**
		 * 设置 用途
		 * @param purpose 用途
		 * @return 当前对象
		*/
		public Asset setPurpose(String purpose) {
			super.change(PURPOSE,super.getPurpose(),purpose);
			super.setPurpose(purpose);
			return this;
		}
		
		/**
		 * 设置 资产备注
		 * @param assetNotes 资产备注
		 * @return 当前对象
		*/
		public Asset setAssetNotes(String assetNotes) {
			super.change(ASSET_NOTES,super.getAssetNotes(),assetNotes);
			super.setAssetNotes(assetNotes);
			return this;
		}
		
		/**
		 * 设置 维保厂商
		 * @param maintainerId 维保厂商
		 * @return 当前对象
		*/
		public Asset setMaintainerId(String maintainerId) {
			super.change(MAINTAINER_ID,super.getMaintainerId(),maintainerId);
			super.setMaintainerId(maintainerId);
			return this;
		}
		
		/**
		 * 设置 维保厂商
		 * @param maintainerName 维保厂商
		 * @return 当前对象
		*/
		public Asset setMaintainerName(String maintainerName) {
			super.change(MAINTAINER_NAME,super.getMaintainerName(),maintainerName);
			super.setMaintainerName(maintainerName);
			return this;
		}
		
		/**
		 * 设置 维保状态
		 * @param maintenanceStatus 维保状态
		 * @return 当前对象
		*/
		public Asset setMaintenanceStatus(String maintenanceStatus) {
			super.change(MAINTENANCE_STATUS,super.getMaintenanceStatus(),maintenanceStatus);
			super.setMaintenanceStatus(maintenanceStatus);
			return this;
		}
		
		/**
		 * 设置 维保价格
		 * @param maintenancePrice 维保价格
		 * @return 当前对象
		*/
		public Asset setMaintenancePrice(BigDecimal maintenancePrice) {
			super.change(MAINTENANCE_PRICE,super.getMaintenancePrice(),maintenancePrice);
			super.setMaintenancePrice(maintenancePrice);
			return this;
		}
		
		/**
		 * 设置 维保方式
		 * @param maintenanceMethod 维保方式
		 * @return 当前对象
		*/
		public Asset setMaintenanceMethod(String maintenanceMethod) {
			super.change(MAINTENANCE_METHOD,super.getMaintenanceMethod(),maintenanceMethod);
			super.setMaintenanceMethod(maintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 建议维保方式
		 * @param suggestMaintenanceMethod 建议维保方式
		 * @return 当前对象
		*/
		public Asset setSuggestMaintenanceMethod(String suggestMaintenanceMethod) {
			super.change(SUGGEST_MAINTENANCE_METHOD,super.getSuggestMaintenanceMethod(),suggestMaintenanceMethod);
			super.setSuggestMaintenanceMethod(suggestMaintenanceMethod);
			return this;
		}
		
		/**
		 * 设置 联系人
		 * @param contacts 联系人
		 * @return 当前对象
		*/
		public Asset setContacts(String contacts) {
			super.change(CONTACTS,super.getContacts(),contacts);
			super.setContacts(contacts);
			return this;
		}
		
		/**
		 * 设置 联系方式
		 * @param contactInformation 联系方式
		 * @return 当前对象
		*/
		public Asset setContactInformation(String contactInformation) {
			super.change(CONTACT_INFORMATION,super.getContactInformation(),contactInformation);
			super.setContactInformation(contactInformation);
			return this;
		}
		
		/**
		 * 设置 负责人
		 * @param director 负责人
		 * @return 当前对象
		*/
		public Asset setDirector(String director) {
			super.change(DIRECTOR,super.getDirector(),director);
			super.setDirector(director);
			return this;
		}
		
		/**
		 * 设置 维保开始时间
		 * @param maintenanceStartDate 维保开始时间
		 * @return 当前对象
		*/
		public Asset setMaintenanceStartDate(Date maintenanceStartDate) {
			super.change(MAINTENANCE_START_DATE,super.getMaintenanceStartDate(),maintenanceStartDate);
			super.setMaintenanceStartDate(maintenanceStartDate);
			return this;
		}
		
		/**
		 * 设置 维保到期时间
		 * @param maintenanceEndDate 维保到期时间
		 * @return 当前对象
		*/
		public Asset setMaintenanceEndDate(Date maintenanceEndDate) {
			super.change(MAINTENANCE_END_DATE,super.getMaintenanceEndDate(),maintenanceEndDate);
			super.setMaintenanceEndDate(maintenanceEndDate);
			return this;
		}
		
		/**
		 * 设置 维保备注
		 * @param maintenanceNotes 维保备注
		 * @return 当前对象
		*/
		public Asset setMaintenanceNotes(String maintenanceNotes) {
			super.change(MAINTENANCE_NOTES,super.getMaintenanceNotes(),maintenanceNotes);
			super.setMaintenanceNotes(maintenanceNotes);
			return this;
		}
		
		/**
		 * 设置 财务分类
		 * @param financialCategoryId 财务分类
		 * @return 当前对象
		*/
		public Asset setFinancialCategoryId(String financialCategoryId) {
			super.change(FINANCIAL_CATEGORY_ID,super.getFinancialCategoryId(),financialCategoryId);
			super.setFinancialCategoryId(financialCategoryId);
			return this;
		}
		
		/**
		 * 设置 财务编号
		 * @param financialCode 财务编号
		 * @return 当前对象
		*/
		public Asset setFinancialCode(String financialCode) {
			super.change(FINANCIAL_CODE,super.getFinancialCode(),financialCode);
			super.setFinancialCode(financialCode);
			return this;
		}
		
		/**
		 * 设置 财务选项
		 * @param financialOption 财务选项
		 * @return 当前对象
		*/
		public Asset setFinancialOption(String financialOption) {
			super.change(FINANCIAL_OPTION,super.getFinancialOption(),financialOption);
			super.setFinancialOption(financialOption);
			return this;
		}
		
		/**
		 * 设置 费用项目
		 * @param expenseItem 费用项目
		 * @return 当前对象
		*/
		public Asset setExpenseItem(String expenseItem) {
			super.change(EXPENSE_ITEM,super.getExpenseItem(),expenseItem);
			super.setExpenseItem(expenseItem);
			return this;
		}
		
		/**
		 * 设置 资产供应商
		 * @param supplierId 资产供应商
		 * @return 当前对象
		*/
		public Asset setSupplierId(String supplierId) {
			super.change(SUPPLIER_ID,super.getSupplierId(),supplierId);
			super.setSupplierId(supplierId);
			return this;
		}
		
		/**
		 * 设置 客户信息
		 * @param customerInfo 客户信息
		 * @return 当前对象
		*/
		public Asset setCustomerInfo(String customerInfo) {
			super.change(CUSTOMER_INFO,super.getCustomerInfo(),customerInfo);
			super.setCustomerInfo(customerInfo);
			return this;
		}
		
		/**
		 * 设置 含税总值
		 * @param taxAmountPrice 含税总值
		 * @return 当前对象
		*/
		public Asset setTaxAmountPrice(BigDecimal taxAmountPrice) {
			super.change(TAX_AMOUNT_PRICE,super.getTaxAmountPrice(),taxAmountPrice);
			super.setTaxAmountPrice(taxAmountPrice);
			return this;
		}
		
		/**
		 * 设置 未税总值
		 * @param totalAmountPrice 未税总值
		 * @return 当前对象
		*/
		public Asset setTotalAmountPrice(BigDecimal totalAmountPrice) {
			super.change(TOTAL_AMOUNT_PRICE,super.getTotalAmountPrice(),totalAmountPrice);
			super.setTotalAmountPrice(totalAmountPrice);
			return this;
		}
		
		/**
		 * 设置 含税单价
		 * @param purchaseUnitPrice 含税单价
		 * @return 当前对象
		*/
		public Asset setPurchaseUnitPrice(BigDecimal purchaseUnitPrice) {
			super.change(PURCHASE_UNIT_PRICE,super.getPurchaseUnitPrice(),purchaseUnitPrice);
			super.setPurchaseUnitPrice(purchaseUnitPrice);
			return this;
		}
		
		/**
		 * 设置 资产原值
		 * @param originalUnitPrice 资产原值
		 * @return 当前对象
		*/
		public Asset setOriginalUnitPrice(BigDecimal originalUnitPrice) {
			super.change(ORIGINAL_UNIT_PRICE,super.getOriginalUnitPrice(),originalUnitPrice);
			super.setOriginalUnitPrice(originalUnitPrice);
			return this;
		}
		
		/**
		 * 设置 资产净值
		 * @param navPrice 资产净值
		 * @return 当前对象
		*/
		public Asset setNavPrice(BigDecimal navPrice) {
			super.change(NAV_PRICE,super.getNavPrice(),navPrice);
			super.setNavPrice(navPrice);
			return this;
		}
		
		/**
		 * 设置 已用期限
		 * @param assetUsedServiceLife 已用期限
		 * @return 当前对象
		*/
		public Asset setAssetUsedServiceLife(BigDecimal assetUsedServiceLife) {
			super.change(ASSET_USED_SERVICE_LIFE,super.getAssetUsedServiceLife(),assetUsedServiceLife);
			super.setAssetUsedServiceLife(assetUsedServiceLife);
			return this;
		}
		
		/**
		 * 设置 最后折旧
		 * @param depreciationId 最后折旧
		 * @return 当前对象
		*/
		public Asset setDepreciationId(String depreciationId) {
			super.change(DEPRECIATION_ID,super.getDepreciationId(),depreciationId);
			super.setDepreciationId(depreciationId);
			return this;
		}
		
		/**
		 * 设置 最后折旧时间
		 * @param depreciationOperTime 最后折旧时间
		 * @return 当前对象
		*/
		public Asset setDepreciationOperTime(Date depreciationOperTime) {
			super.change(DEPRECIATION_OPER_TIME,super.getDepreciationOperTime(),depreciationOperTime);
			super.setDepreciationOperTime(depreciationOperTime);
			return this;
		}
		
		/**
		 * 设置 residuals_rate
		 * @param residualsRate residuals_rate
		 * @return 当前对象
		*/
		public Asset setResidualsRate(BigDecimal residualsRate) {
			super.change(RESIDUALS_RATE,super.getResidualsRate(),residualsRate);
			super.setResidualsRate(residualsRate);
			return this;
		}
		
		/**
		 * 设置 残值
		 * @param residualsPrice 残值
		 * @return 当前对象
		*/
		public Asset setResidualsPrice(BigDecimal residualsPrice) {
			super.change(RESIDUALS_PRICE,super.getResidualsPrice(),residualsPrice);
			super.setResidualsPrice(residualsPrice);
			return this;
		}
		
		/**
		 * 设置 税额
		 * @param taxAmountRate 税额
		 * @return 当前对象
		*/
		public Asset setTaxAmountRate(BigDecimal taxAmountRate) {
			super.change(TAX_AMOUNT_RATE,super.getTaxAmountRate(),taxAmountRate);
			super.setTaxAmountRate(taxAmountRate);
			return this;
		}
		
		/**
		 * 设置 本年折旧
		 * @param currentYearDepreciation 本年折旧
		 * @return 当前对象
		*/
		public Asset setCurrentYearDepreciation(BigDecimal currentYearDepreciation) {
			super.change(CURRENT_YEAR_DEPRECIATION,super.getCurrentYearDepreciation(),currentYearDepreciation);
			super.setCurrentYearDepreciation(currentYearDepreciation);
			return this;
		}
		
		/**
		 * 设置 折旧年份
		 * @param depreciationYear 折旧年份
		 * @return 当前对象
		*/
		public Asset setDepreciationYear(Integer depreciationYear) {
			super.change(DEPRECIATION_YEAR,super.getDepreciationYear(),depreciationYear);
			super.setDepreciationYear(depreciationYear);
			return this;
		}
		
		/**
		 * 设置 累计折旧
		 * @param accumulatedDepreciation 累计折旧
		 * @return 当前对象
		*/
		public Asset setAccumulatedDepreciation(BigDecimal accumulatedDepreciation) {
			super.change(ACCUMULATED_DEPRECIATION,super.getAccumulatedDepreciation(),accumulatedDepreciation);
			super.setAccumulatedDepreciation(accumulatedDepreciation);
			return this;
		}
		
		/**
		 * 设置 月折金额
		 * @param monthDepreciationPrice 月折金额
		 * @return 当前对象
		*/
		public Asset setMonthDepreciationPrice(BigDecimal monthDepreciationPrice) {
			super.change(MONTH_DEPRECIATION_PRICE,super.getMonthDepreciationPrice(),monthDepreciationPrice);
			super.setMonthDepreciationPrice(monthDepreciationPrice);
			return this;
		}
		
		/**
		 * 设置 登记时间
		 * @param entryTime 登记时间
		 * @return 当前对象
		*/
		public Asset setEntryTime(Date entryTime) {
			super.change(ENTRY_TIME,super.getEntryTime(),entryTime);
			super.setEntryTime(entryTime);
			return this;
		}
		
		/**
		 * 设置 财务备注
		 * @param financialNotes 财务备注
		 * @return 当前对象
		*/
		public Asset setFinancialNotes(String financialNotes) {
			super.change(FINANCIAL_NOTES,super.getFinancialNotes(),financialNotes);
			super.setFinancialNotes(financialNotes);
			return this;
		}
		
		/**
		 * 设置 设备编号
		 * @param equipmentCode 设备编号
		 * @return 当前对象
		*/
		public Asset setEquipmentCode(String equipmentCode) {
			super.change(EQUIPMENT_CODE,super.getEquipmentCode(),equipmentCode);
			super.setEquipmentCode(equipmentCode);
			return this;
		}
		
		/**
		 * 设置 设备状态
		 * @param equipmentStatus 设备状态
		 * @return 当前对象
		*/
		public Asset setEquipmentStatus(String equipmentStatus) {
			super.change(EQUIPMENT_STATUS,super.getEquipmentStatus(),equipmentStatus);
			super.setEquipmentStatus(equipmentStatus);
			return this;
		}
		
		/**
		 * 设置 设备IP
		 * @param equipmentIp 设备IP
		 * @return 当前对象
		*/
		public Asset setEquipmentIp(String equipmentIp) {
			super.change(EQUIPMENT_IP,super.getEquipmentIp(),equipmentIp);
			super.setEquipmentIp(equipmentIp);
			return this;
		}
		
		/**
		 * 设置 管理IP
		 * @param manageIp 管理IP
		 * @return 当前对象
		*/
		public Asset setManageIp(String manageIp) {
			super.change(MANAGE_IP,super.getManageIp(),manageIp);
			super.setManageIp(manageIp);
			return this;
		}
		
		/**
		 * 设置 设备CPU
		 * @param equipmentCpu 设备CPU
		 * @return 当前对象
		*/
		public Asset setEquipmentCpu(String equipmentCpu) {
			super.change(EQUIPMENT_CPU,super.getEquipmentCpu(),equipmentCpu);
			super.setEquipmentCpu(equipmentCpu);
			return this;
		}
		
		/**
		 * 设置 设备内存
		 * @param equipmentMemory 设备内存
		 * @return 当前对象
		*/
		public Asset setEquipmentMemory(String equipmentMemory) {
			super.change(EQUIPMENT_MEMORY,super.getEquipmentMemory(),equipmentMemory);
			super.setEquipmentMemory(equipmentMemory);
			return this;
		}
		
		/**
		 * 设置 设备标签
		 * @param equipmentLabel 设备标签
		 * @return 当前对象
		*/
		public Asset setEquipmentLabel(String equipmentLabel) {
			super.change(EQUIPMENT_LABEL,super.getEquipmentLabel(),equipmentLabel);
			super.setEquipmentLabel(equipmentLabel);
			return this;
		}
		
		/**
		 * 设置 设备配置
		 * @param equipmentConf 设备配置
		 * @return 当前对象
		*/
		public Asset setEquipmentConf(String equipmentConf) {
			super.change(EQUIPMENT_CONF,super.getEquipmentConf(),equipmentConf);
			super.setEquipmentConf(equipmentConf);
			return this;
		}
		
		/**
		 * 设置 设备运行环境
		 * @param equipmentEnvironmentCode 设备运行环境
		 * @return 当前对象
		*/
		public Asset setEquipmentEnvironmentCode(String equipmentEnvironmentCode) {
			super.change(EQUIPMENT_ENVIRONMENT_CODE,super.getEquipmentEnvironmentCode(),equipmentEnvironmentCode);
			super.setEquipmentEnvironmentCode(equipmentEnvironmentCode);
			return this;
		}
		
		/**
		 * 设置 设备序列号
		 * @param equipmentSerialNumber 设备序列号
		 * @return 当前对象
		*/
		public Asset setEquipmentSerialNumber(String equipmentSerialNumber) {
			super.change(EQUIPMENT_SERIAL_NUMBER,super.getEquipmentSerialNumber(),equipmentSerialNumber);
			super.setEquipmentSerialNumber(equipmentSerialNumber);
			return this;
		}
		
		/**
		 * 设置 设备机柜
		 * @param rackId 设备机柜
		 * @return 当前对象
		*/
		public Asset setRackId(String rackId) {
			super.change(RACK_ID,super.getRackId(),rackId);
			super.setRackId(rackId);
			return this;
		}
		
		/**
		 * 设置 设备机柜上位置
		 * @param rackUpNumber 设备机柜上位置
		 * @return 当前对象
		*/
		public Asset setRackUpNumber(Integer rackUpNumber) {
			super.change(RACK_UP_NUMBER,super.getRackUpNumber(),rackUpNumber);
			super.setRackUpNumber(rackUpNumber);
			return this;
		}
		
		/**
		 * 设置 设备机柜下位置
		 * @param rackDownNumber 设备机柜下位置
		 * @return 当前对象
		*/
		public Asset setRackDownNumber(Integer rackDownNumber) {
			super.change(RACK_DOWN_NUMBER,super.getRackDownNumber(),rackDownNumber);
			super.setRackDownNumber(rackDownNumber);
			return this;
		}
		
		/**
		 * 设置 短标签1
		 * @param label 短标签1
		 * @return 当前对象
		*/
		public Asset setLabel(String label) {
			super.change(LABEL,super.getLabel(),label);
			super.setLabel(label);
			return this;
		}
		
		/**
		 * 设置 长标签2
		 * @param label2 长标签2
		 * @return 当前对象
		*/
		public Asset setLabel2(String label2) {
			super.change(LABEL2,super.getLabel2(),label2);
			super.setLabel2(label2);
			return this;
		}
		
		/**
		 * 设置 短标签3
		 * @param label3 短标签3
		 * @return 当前对象
		*/
		public Asset setLabel3(String label3) {
			super.change(LABEL3,super.getLabel3(),label3);
			super.setLabel3(label3);
			return this;
		}
		
		/**
		 * 设置 长标签4
		 * @param label4 长标签4
		 * @return 当前对象
		*/
		public Asset setLabel4(String label4) {
			super.change(LABEL4,super.getLabel4(),label4);
			super.setLabel4(label4);
			return this;
		}
		
		/**
		 * 设置 短标签5
		 * @param label5 短标签5
		 * @return 当前对象
		*/
		public Asset setLabel5(String label5) {
			super.change(LABEL5,super.getLabel5(),label5);
			super.setLabel5(label5);
			return this;
		}
		
		/**
		 * 设置 单据
		 * @param billId 单据
		 * @return 当前对象
		*/
		public Asset setBillId(String billId) {
			super.change(BILL_ID,super.getBillId(),billId);
			super.setBillId(billId);
			return this;
		}
		
		/**
		 * 设置 内部控制标签
		 * @param internalControlLabel 内部控制标签
		 * @return 当前对象
		*/
		public Asset setInternalControlLabel(String internalControlLabel) {
			super.change(INTERNAL_CONTROL_LABEL,super.getInternalControlLabel(),internalControlLabel);
			super.setInternalControlLabel(internalControlLabel);
			return this;
		}
		
		/**
		 * 设置 领用ID
		 * @param collectionId 领用ID
		 * @return 当前对象
		*/
		public Asset setCollectionId(String collectionId) {
			super.change(COLLECTION_ID,super.getCollectionId(),collectionId);
			super.setCollectionId(collectionId);
			return this;
		}
		
		/**
		 * 设置 借用ID
		 * @param borrowId 借用ID
		 * @return 当前对象
		*/
		public Asset setBorrowId(String borrowId) {
			super.change(BORROW_ID,super.getBorrowId(),borrowId);
			super.setBorrowId(borrowId);
			return this;
		}
		
		/**
		 * 设置 报废ID
		 * @param scrapId 报废ID
		 * @return 当前对象
		*/
		public Asset setScrapId(String scrapId) {
			super.change(SCRAP_ID,super.getScrapId(),scrapId);
			super.setScrapId(scrapId);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Asset setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Asset setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Asset setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Asset setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Asset setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Asset setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Asset setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 版本
		 * @param version 版本
		 * @return 当前对象
		*/
		public Asset setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Asset setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originatorId 制单人
		 * @return 当前对象
		*/
		public Asset setOriginatorId(String originatorId) {
			super.change(ORIGINATOR_ID,super.getOriginatorId(),originatorId);
			super.setOriginatorId(originatorId);
			return this;
		}
		
		/**
		 * 设置 变更类型
		 * @param chsType 变更类型
		 * @return 当前对象
		*/
		public Asset setChsType(String chsType) {
			super.change(CHS_TYPE,super.getChsType(),chsType);
			super.setChsType(chsType);
			return this;
		}
		
		/**
		 * 设置 变更状态
		 * @param chsStatus 变更状态
		 * @return 当前对象
		*/
		public Asset setChsStatus(String chsStatus) {
			super.change(CHS_STATUS,super.getChsStatus(),chsStatus);
			super.setChsStatus(chsStatus);
			return this;
		}
		
		/**
		 * 设置 变更版本号
		 * @param chsVersion 变更版本号
		 * @return 当前对象
		*/
		public Asset setChsVersion(String chsVersion) {
			super.change(CHS_VERSION,super.getChsVersion(),chsVersion);
			super.setChsVersion(chsVersion);
			return this;
		}
		
		/**
		 * 设置 变更ID
		 * @param changeInstanceId 变更ID
		 * @return 当前对象
		*/
		public Asset setChangeInstanceId(String changeInstanceId) {
			super.change(CHANGE_INSTANCE_ID,super.getChangeInstanceId(),changeInstanceId);
			super.setChangeInstanceId(changeInstanceId);
			return this;
		}
		
		/**
		 * 设置 流程概要
		 * @param summary 流程概要
		 * @return 当前对象
		*/
		public Asset setSummary(String summary) {
			super.change(SUMMARY,super.getSummary(),summary);
			super.setSummary(summary);
			return this;
		}
		
		/**
		 * 设置 最后审批人账户ID
		 * @param latestApproverId 最后审批人账户ID
		 * @return 当前对象
		*/
		public Asset setLatestApproverId(String latestApproverId) {
			super.change(LATEST_APPROVER_ID,super.getLatestApproverId(),latestApproverId);
			super.setLatestApproverId(latestApproverId);
			return this;
		}
		
		/**
		 * 设置 最后审批人姓名
		 * @param latestApproverName 最后审批人姓名
		 * @return 当前对象
		*/
		public Asset setLatestApproverName(String latestApproverName) {
			super.change(LATEST_APPROVER_NAME,super.getLatestApproverName(),latestApproverName);
			super.setLatestApproverName(latestApproverName);
			return this;
		}
		
		/**
		 * 设置 下一节点审批人
		 * @param nextApproverIds 下一节点审批人
		 * @return 当前对象
		*/
		public Asset setNextApproverIds(String nextApproverIds) {
			super.change(NEXT_APPROVER_IDS,super.getNextApproverIds(),nextApproverIds);
			super.setNextApproverIds(nextApproverIds);
			return this;
		}
		
		/**
		 * 设置 下一个审批节点审批人姓名
		 * @param nextApproverNames 下一个审批节点审批人姓名
		 * @return 当前对象
		*/
		public Asset setNextApproverNames(String nextApproverNames) {
			super.change(NEXT_APPROVER_NAMES,super.getNextApproverNames(),nextApproverNames);
			super.setNextApproverNames(nextApproverNames);
			return this;
		}
		
		/**
		 * 设置 审批意见
		 * @param approvalOpinion 审批意见
		 * @return 当前对象
		*/
		public Asset setApprovalOpinion(String approvalOpinion) {
			super.change(APPROVAL_OPINION,super.getApprovalOpinion(),approvalOpinion);
			super.setApprovalOpinion(approvalOpinion);
			return this;
		}
		
		/**
		 * 设置 选择
		 * @param assetSelectedData 选择
		 * @return 当前对象
		*/
		public Asset setAssetSelectedData(String assetSelectedData) {
			super.change(ASSET_SELECTED_DATA,super.getAssetSelectedData(),assetSelectedData);
			super.setAssetSelectedData(assetSelectedData);
			return this;
		}
		
		/**
		 * 设置 扩展数据
		 * @param extData 扩展数据
		 * @return 当前对象
		*/
		public Asset setExtData(AssetExtData extData) {
			super.change(EXT_DATA,super.getExtData(),extData);
			super.setExtData(extData);
			return this;
		}
		
		/**
		 * 设置 PCM数据
		 * @param pcmData PCM数据
		 * @return 当前对象
		*/
		public Asset setPcmData(Map<String,Object> pcmData) {
			super.change(PCM_DATA,super.getPcmData(),pcmData);
			super.setPcmData(pcmData);
			return this;
		}
		
		/**
		 * 设置 自定义数据属性字段
		 * @param catalogAttribute 自定义数据属性字段
		 * @return 当前对象
		*/
		public Asset setCatalogAttribute(List<CatalogAttribute> catalogAttribute) {
			super.change(CATALOG_ATTRIBUTE,super.getCatalogAttribute(),catalogAttribute);
			super.setCatalogAttribute(catalogAttribute);
			return this;
		}
		
		/**
		 * 设置 存放位置
		 * @param position 存放位置
		 * @return 当前对象
		*/
		public Asset setPosition(Position position) {
			super.change(POSITION,super.getPosition(),position);
			super.setPosition(position);
			return this;
		}
		
		/**
		 * 设置 财务分类
		 * @param categoryFinance 财务分类
		 * @return 当前对象
		*/
		public Asset setCategoryFinance(CategoryFinance categoryFinance) {
			super.change(CATEGORY_FINANCE,super.getCategoryFinance(),categoryFinance);
			super.setCategoryFinance(categoryFinance);
			return this;
		}
		
		/**
		 * 设置 资产分类
		 * @param category 资产分类
		 * @return 当前对象
		*/
		public Asset setCategory(Catalog category) {
			super.change(CATEGORY,super.getCategory(),category);
			super.setCategory(category);
			return this;
		}
		
		/**
		 * 设置 物品档案
		 * @param goods 物品档案
		 * @return 当前对象
		*/
		public Asset setGoods(Goods goods) {
			super.change(GOODS,super.getGoods(),goods);
			super.setGoods(goods);
			return this;
		}
		
		/**
		 * 设置 生产厂商
		 * @param manufacturer 生产厂商
		 * @return 当前对象
		*/
		public Asset setManufacturer(Manufacturer manufacturer) {
			super.change(MANUFACTURER,super.getManufacturer(),manufacturer);
			super.setManufacturer(manufacturer);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param warehouse 仓库
		 * @return 当前对象
		*/
		public Asset setWarehouse(Warehouse warehouse) {
			super.change(WAREHOUSE,super.getWarehouse(),warehouse);
			super.setWarehouse(warehouse);
			return this;
		}
		
		/**
		 * 设置 使用人员
		 * @param useUser 使用人员
		 * @return 当前对象
		*/
		public Asset setUseUser(Employee useUser) {
			super.change(USE_USER,super.getUseUser(),useUser);
			super.setUseUser(useUser);
			return this;
		}
		
		/**
		 * 设置 管理人员
		 * @param manager 管理人员
		 * @return 当前对象
		*/
		public Asset setManager(Employee manager) {
			super.change(MANAGER,super.getManager(),manager);
			super.setManager(manager);
			return this;
		}
		
		/**
		 * 设置 制单人
		 * @param originator 制单人
		 * @return 当前对象
		*/
		public Asset setOriginator(Employee originator) {
			super.change(ORIGINATOR,super.getOriginator(),originator);
			super.setOriginator(originator);
			return this;
		}
		
		/**
		 * 设置 供应商
		 * @param supplier 供应商
		 * @return 当前对象
		*/
		public Asset setSupplier(Supplier supplier) {
			super.change(SUPPLIER,super.getSupplier(),supplier);
			super.setSupplier(supplier);
			return this;
		}
		
		/**
		 * 设置 维保商
		 * @param maintnainer 维保商
		 * @return 当前对象
		*/
		public Asset setMaintnainer(Maintainer maintnainer) {
			super.change(MAINTNAINER,super.getMaintnainer(),maintnainer);
			super.setMaintnainer(maintnainer);
			return this;
		}
		
		/**
		 * 设置 所属公司
		 * @param ownerCompany 所属公司
		 * @return 当前对象
		*/
		public Asset setOwnerCompany(Organization ownerCompany) {
			super.change(OWNER_COMPANY,super.getOwnerCompany(),ownerCompany);
			super.setOwnerCompany(ownerCompany);
			return this;
		}
		
		/**
		 * 设置 使用公司/部门
		 * @param useOrganization 使用公司/部门
		 * @return 当前对象
		*/
		public Asset setUseOrganization(Organization useOrganization) {
			super.change(USE_ORGANIZATION,super.getUseOrganization(),useOrganization);
			super.setUseOrganization(useOrganization);
			return this;
		}
		
		/**
		 * 设置 来源
		 * @param source 来源
		 * @return 当前对象
		*/
		public Asset setSource(DictItem source) {
			super.change(SOURCE,super.getSource(),source);
			super.setSource(source);
			return this;
		}
		
		/**
		 * 设置 设备运行环境
		 * @param equipmentEnvironment 设备运行环境
		 * @return 当前对象
		*/
		public Asset setEquipmentEnvironment(DictItem equipmentEnvironment) {
			super.change(EQUIPMENT_ENVIRONMENT,super.getEquipmentEnvironment(),equipmentEnvironment);
			super.setEquipmentEnvironment(equipmentEnvironment);
			return this;
		}
		
		/**
		 * 设置 安全等级
		 * @param safetyLevel 安全等级
		 * @return 当前对象
		*/
		public Asset setSafetyLevel(DictItem safetyLevel) {
			super.change(SAFETY_LEVEL,super.getSafetyLevel(),safetyLevel);
			super.setSafetyLevel(safetyLevel);
			return this;
		}
		
		/**
		 * 设置 维保状态
		 * @param assetMaintenanceStatus 维保状态
		 * @return 当前对象
		*/
		public Asset setAssetMaintenanceStatus(DictItem assetMaintenanceStatus) {
			super.change(ASSET_MAINTENANCE_STATUS,super.getAssetMaintenanceStatus(),assetMaintenanceStatus);
			super.setAssetMaintenanceStatus(assetMaintenanceStatus);
			return this;
		}
		
		/**
		 * 设置 建议维保方式
		 * @param suggestMaintenanceMethodData 建议维保方式
		 * @return 当前对象
		*/
		public Asset setSuggestMaintenanceMethodData(DictItem suggestMaintenanceMethodData) {
			super.change(SUGGEST_MAINTENANCE_METHOD_DATA,super.getSuggestMaintenanceMethodData(),suggestMaintenanceMethodData);
			super.setSuggestMaintenanceMethodData(suggestMaintenanceMethodData);
			return this;
		}
		
		/**
		 * 设置 维保方式
		 * @param maintenanceMethodData 维保方式
		 * @return 当前对象
		*/
		public Asset setMaintenanceMethodData(DictItem maintenanceMethodData) {
			super.change(MAINTENANCE_METHOD_DATA,super.getMaintenanceMethodData(),maintenanceMethodData);
			super.setMaintenanceMethodData(maintenanceMethodData);
			return this;
		}
		
		/**
		 * 设置 assetCycleStatus
		 * @param assetCycleStatus assetCycleStatus
		 * @return 当前对象
		*/
		public Asset setAssetCycleStatus(AssetStatus assetCycleStatus) {
			super.change(ASSET_CYCLE_STATUS,super.getAssetCycleStatus(),assetCycleStatus);
			super.setAssetCycleStatus(assetCycleStatus);
			return this;
		}
		
		/**
		 * 设置 机柜
		 * @param rack 机柜
		 * @return 当前对象
		*/
		public Asset setRack(AssetRack rack) {
			super.change(RACK,super.getRack(),rack);
			super.setRack(rack);
			return this;
		}
		
		/**
		 * 设置 变更实例
		 * @param changeInstance 变更实例
		 * @return 当前对象
		*/
		public Asset setChangeInstance(ChangeInstance changeInstance) {
			super.change(CHANGE_INSTANCE,super.getChangeInstance(),changeInstance);
			super.setChangeInstance(changeInstance);
			return this;
		}
		
		/**
		 * 设置 库存物品
		 * @param goodsStock 库存物品
		 * @return 当前对象
		*/
		public Asset setGoodsStock(GoodsStock goodsStock) {
			super.change(GOODS_STOCK,super.getGoodsStock(),goodsStock);
			super.setGoodsStock(goodsStock);
			return this;
		}
		
		/**
		 * 设置 存放区域
		 * @param region 存放区域
		 * @return 当前对象
		*/
		public Asset setRegion(AssetRegion region) {
			super.change(REGION,super.getRegion(),region);
			super.setRegion(region);
			return this;
		}
		
		/**
		 * 设置 财务选项
		 * @param financialOptionDict 财务选项
		 * @return 当前对象
		*/
		public Asset setFinancialOptionDict(DictItem financialOptionDict) {
			super.change(FINANCIAL_OPTION_DICT,super.getFinancialOptionDict(),financialOptionDict);
			super.setFinancialOptionDict(financialOptionDict);
			return this;
		}
		
		/**
		 * 设置 费用项目
		 * @param expenseItemDict 费用项目
		 * @return 当前对象
		*/
		public Asset setExpenseItemDict(DictItem expenseItemDict) {
			super.change(EXPENSE_ITEM_DICT,super.getExpenseItemDict(),expenseItemDict);
			super.setExpenseItemDict(expenseItemDict);
			return this;
		}
		
		/**
		 * 设置 assetCollection
		 * @param assetCollection assetCollection
		 * @return 当前对象
		*/
		public Asset setAssetCollection(AssetCollection assetCollection) {
			super.change(ASSET_COLLECTION,super.getAssetCollection(),assetCollection);
			super.setAssetCollection(assetCollection);
			return this;
		}
		
		/**
		 * 设置 assetBorrow
		 * @param assetBorrow assetBorrow
		 * @return 当前对象
		*/
		public Asset setAssetBorrow(AssetBorrow assetBorrow) {
			super.change(ASSET_BORROW,super.getAssetBorrow(),assetBorrow);
			super.setAssetBorrow(assetBorrow);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public AssetVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public AssetVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setEquipmentCode(this.getEquipmentCode());
			inst.setCustomerInfo(this.getCustomerInfo());
			inst.setPurchaseUnitPrice(this.getPurchaseUnitPrice());
			inst.setApprovalOpinion(this.getApprovalOpinion());
			inst.setMaintenanceStatus(this.getMaintenanceStatus());
			inst.setNavPrice(this.getNavPrice());
			inst.setLabel4(this.getLabel4());
			inst.setLabel5(this.getLabel5());
			inst.setBusinessCode(this.getBusinessCode());
			inst.setAssetNumber(this.getAssetNumber());
			inst.setModel(this.getModel());
			inst.setId(this.getId());
			inst.setScrapId(this.getScrapId());
			inst.setEquipmentEnvironmentCode(this.getEquipmentEnvironmentCode());
			inst.setDirector(this.getDirector());
			inst.setMonthDepreciationPrice(this.getMonthDepreciationPrice());
			inst.setVersion(this.getVersion());
			inst.setSafetyLevelCode(this.getSafetyLevelCode());
			inst.setMaintainerId(this.getMaintainerId());
			inst.setMaintenanceNotes(this.getMaintenanceNotes());
			inst.setEntryTime(this.getEntryTime());
			inst.setManageIp(this.getManageIp());
			inst.setWarehouseId(this.getWarehouseId());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setFinancialNotes(this.getFinancialNotes());
			inst.setMaintenanceMethod(this.getMaintenanceMethod());
			inst.setFinancialOption(this.getFinancialOption());
			inst.setStatus(this.getStatus());
			inst.setPurchaseDate(this.getPurchaseDate());
			inst.setOwnerCode(this.getOwnerCode());
			inst.setRemainNumber(this.getRemainNumber());
			inst.setGoodsId(this.getGoodsId());
			inst.setChangeInstanceId(this.getChangeInstanceId());
			inst.setEquipmentConf(this.getEquipmentConf());
			inst.setAssetNotes(this.getAssetNotes());
			inst.setOriginalUnitPrice(this.getOriginalUnitPrice());
			inst.setDepreciationId(this.getDepreciationId());
			inst.setPictureId(this.getPictureId());
			inst.setSuggestMaintenanceMethod(this.getSuggestMaintenanceMethod());
			inst.setTotalAmountPrice(this.getTotalAmountPrice());
			inst.setServiceLife(this.getServiceLife());
			inst.setAttach(this.getAttach());
			inst.setMaintainerName(this.getMaintainerName());
			inst.setOriginatorId(this.getOriginatorId());
			inst.setCleanOut(this.getCleanOut());
			inst.setRackId(this.getRackId());
			inst.setDisplay(this.getDisplay());
			inst.setManufacturerId(this.getManufacturerId());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setCategoryCode(this.getCategoryCode());
			inst.setManagerId(this.getManagerId());
			inst.setAccumulatedDepreciation(this.getAccumulatedDepreciation());
			inst.setLabel2(this.getLabel2());
			inst.setLabel3(this.getLabel3());
			inst.setAssetSelectedData(this.getAssetSelectedData());
			inst.setDeleted(this.getDeleted());
			inst.setPositionId(this.getPositionId());
			inst.setCreateTime(this.getCreateTime());
			inst.setTenantId(this.getTenantId());
			inst.setRfid(this.getRfid());
			inst.setMaintenanceStartDate(this.getMaintenanceStartDate());
			inst.setLastVerificationDate(this.getLastVerificationDate());
			inst.setUseUserId(this.getUseUserId());
			inst.setContacts(this.getContacts());
			inst.setSourceId(this.getSourceId());
			inst.setProcId(this.getProcId());
			inst.setFinancialCategoryId(this.getFinancialCategoryId());
			inst.setMaintenancePrice(this.getMaintenancePrice());
			inst.setEquipmentIp(this.getEquipmentIp());
			inst.setMaintenanceEndDate(this.getMaintenanceEndDate());
			inst.setDepreciationOperTime(this.getDepreciationOperTime());
			inst.setNextApproverNames(this.getNextApproverNames());
			inst.setAssetCode(this.getAssetCode());
			inst.setSerialNumber(this.getSerialNumber());
			inst.setLatestApproverId(this.getLatestApproverId());
			inst.setGoodsStockId(this.getGoodsStockId());
			inst.setTaxAmountRate(this.getTaxAmountRate());
			inst.setCurrentYearDepreciation(this.getCurrentYearDepreciation());
			inst.setUseOrganizationId(this.getUseOrganizationId());
			inst.setEquipmentLabel(this.getEquipmentLabel());
			inst.setUnit(this.getUnit());
			inst.setOwnCompanyId(this.getOwnCompanyId());
			inst.setBillId(this.getBillId());
			inst.setName(this.getName());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setFinancialCode(this.getFinancialCode());
			inst.setRackUpNumber(this.getRackUpNumber());
			inst.setResidualsRate(this.getResidualsRate());
			inst.setAssetStatus(this.getAssetStatus());
			inst.setExpenseItem(this.getExpenseItem());
			inst.setChsVersion(this.getChsVersion());
			inst.setSupplierId(this.getSupplierId());
			inst.setPurpose(this.getPurpose());
			inst.setResidualsPrice(this.getResidualsPrice());
			inst.setInternalControlLabel(this.getInternalControlLabel());
			inst.setLatestApproverName(this.getLatestApproverName());
			inst.setAssetUsedServiceLife(this.getAssetUsedServiceLife());
			inst.setNextApproverIds(this.getNextApproverIds());
			inst.setChsStatus(this.getChsStatus());
			inst.setProductionDate(this.getProductionDate());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setCollectionId(this.getCollectionId());
			inst.setRegisterDate(this.getRegisterDate());
			inst.setSummary(this.getSummary());
			inst.setEquipmentSerialNumber(this.getEquipmentSerialNumber());
			inst.setBatchCode(this.getBatchCode());
			inst.setEquipmentCpu(this.getEquipmentCpu());
			inst.setEquipmentMemory(this.getEquipmentMemory());
			inst.setLabel(this.getLabel());
			inst.setEquipmentStatus(this.getEquipmentStatus());
			inst.setPositionDetail(this.getPositionDetail());
			inst.setDepreciationYear(this.getDepreciationYear());
			inst.setCreateBy(this.getCreateBy());
			inst.setContactInformation(this.getContactInformation());
			inst.setTaxAmountPrice(this.getTaxAmountPrice());
			inst.setRegionId(this.getRegionId());
			inst.setChsType(this.getChsType());
			inst.setRackDownNumber(this.getRackDownNumber());
			inst.setBorrowId(this.getBorrowId());
			inst.setCategoryId(this.getCategoryId());
			if(all) {
				inst.setOwnerCompany(this.getOwnerCompany());
				inst.setSuggestMaintenanceMethodData(this.getSuggestMaintenanceMethodData());
				inst.setSearchField(this.getSearchField());
				inst.setSafetyLevel(this.getSafetyLevel());
				inst.setCategoryFinance(this.getCategoryFinance());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setGoods(this.getGoods());
				inst.setOriginator(this.getOriginator());
				inst.setSource(this.getSource());
				inst.setFinancialOptionDict(this.getFinancialOptionDict());
				inst.setManufacturer(this.getManufacturer());
				inst.setCatalogAttribute(this.getCatalogAttribute());
				inst.setExpenseItemDict(this.getExpenseItemDict());
				inst.setSupplier(this.getSupplier());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setMaintenanceMethodData(this.getMaintenanceMethodData());
				inst.setUseUser(this.getUseUser());
				inst.setEquipmentEnvironment(this.getEquipmentEnvironment());
				inst.setAssetCycleStatus(this.getAssetCycleStatus());
				inst.setRack(this.getRack());
				inst.setManager(this.getManager());
				inst.setWarehouse(this.getWarehouse());
				inst.setPcmData(this.getPcmData());
				inst.setGoodsStock(this.getGoodsStock());
				inst.setUseOrganization(this.getUseOrganization());
				inst.setAssetCollection(this.getAssetCollection());
				inst.setChangeInstance(this.getChangeInstance());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setExtData(this.getExtData());
				inst.setMaintnainer(this.getMaintnainer());
				inst.setAssetMaintenanceStatus(this.getAssetMaintenanceStatus());
				inst.setIds(this.getIds());
				inst.setPosition(this.getPosition());
				inst.setAssetBorrow(this.getAssetBorrow());
				inst.setCategory(this.getCategory());
				inst.setRegion(this.getRegion());
				inst.setSearchValue(this.getSearchValue());
			}
			inst.clearModifies();
			return inst;
		}

	}
}