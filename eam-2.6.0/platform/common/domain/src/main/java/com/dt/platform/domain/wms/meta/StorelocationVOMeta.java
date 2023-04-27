package com.dt.platform.domain.wms.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.wms.StorelocationVO;
import java.util.List;
import com.dt.platform.domain.wms.Storelocation;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.wms.Storehouse;
import com.dt.platform.domain.wms.Customer;
import com.dt.platform.domain.wms.ProductAttr;
import com.dt.platform.domain.wms.LocType;
import com.dt.platform.domain.wms.TemperatureAttribute;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 13:53:30
 * @sign 7D224A61321B8C84C0E187F99554C0D7
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class StorelocationVOMeta extends StorelocationMeta {
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final String PAGE_INDEX="pageIndex";
	
	/**
	 * 页码 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.Integer> PAGE_INDEX_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,PAGE_INDEX, java.lang.Integer.class, "页码", "", java.lang.Integer.class, null);
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final String PAGE_SIZE="pageSize";
	
	/**
	 * 分页大小 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.Integer> PAGE_SIZE_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,PAGE_SIZE, java.lang.Integer.class, "分页大小", "", java.lang.Integer.class, null);
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final String SEARCH_FIELD="searchField";
	
	/**
	 * 搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> SEARCH_FIELD_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,SEARCH_FIELD, java.lang.String.class, "搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final String FUZZY_FIELD="fuzzyField";
	
	/**
	 * 模糊搜索字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> FUZZY_FIELD_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,FUZZY_FIELD, java.lang.String.class, "模糊搜索字段", "", java.lang.String.class, null);
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final String SEARCH_VALUE="searchValue";
	
	/**
	 * 搜索的值 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> SEARCH_VALUE_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,SEARCH_VALUE, java.lang.String.class, "搜索的值", "", java.lang.String.class, null);
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String DIRTY_FIELDS="dirtyFields";
	
	/**
	 * 已修改字段 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> DIRTY_FIELDS_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,DIRTY_FIELDS, java.util.List.class, "已修改字段", "", java.lang.String.class, null);
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final String SORT_FIELD="sortField";
	
	/**
	 * 排序字段 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> SORT_FIELD_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,SORT_FIELD, java.lang.String.class, "排序字段", "", java.lang.String.class, null);
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final String SORT_TYPE="sortType";
	
	/**
	 * 排序方式 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> SORT_TYPE_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,SORT_TYPE, java.lang.String.class, "排序方式", "", java.lang.String.class, null);
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String DATA_ORIGIN="dataOrigin";
	
	/**
	 * 数据来源 , 前端指定不同的来源，后端可按来源执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> DATA_ORIGIN_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,DATA_ORIGIN, java.lang.String.class, "数据来源", "前端指定不同的来源，后端可按来源执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final String QUERY_LOGIC="queryLogic";
	
	/**
	 * 查询逻辑 , 默认and，可指定 or  , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> QUERY_LOGIC_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,QUERY_LOGIC, java.lang.String.class, "查询逻辑", "默认and，可指定 or ", java.lang.String.class, null);
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final String REQUEST_ACTION="requestAction";
	
	/**
	 * 请求动作 , 前端指定不同的Action，后端可Action执行不同的逻辑 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> REQUEST_ACTION_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,REQUEST_ACTION, java.lang.String.class, "请求动作", "前端指定不同的Action，后端可Action执行不同的逻辑", java.lang.String.class, null);
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String IDS="ids";
	
	/**
	 * 主键清单 , 用于接收批量主键参数 , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> IDS_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,IDS, java.util.List.class, "主键清单", "用于接收批量主键参数", java.lang.String.class, null);
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final String STOREHOUSE_ID="storehouseId";
	
	/**
	 * 仓库 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> STOREHOUSE_ID_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,STOREHOUSE_ID, java.lang.String.class, "仓库", "仓库", java.lang.String.class, null);
	
	/**
	 * 所属客户 , 类型: java.lang.String
	*/
	public static final String CUSTOMER_ID="customerId";
	
	/**
	 * 所属客户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> CUSTOMER_ID_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,CUSTOMER_ID, java.lang.String.class, "所属客户", "所属客户", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 条码 , 类型: java.lang.String
	*/
	public static final String BAR_CODE="barCode";
	
	/**
	 * 条码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> BAR_CODE_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,BAR_CODE, java.lang.String.class, "条码", "条码", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final String STATUS="status";
	
	/**
	 * 状态 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> STATUS_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,STATUS, java.lang.String.class, "状态", "状态", java.lang.String.class, null);
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final String TYPE="type";
	
	/**
	 * 类型 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> TYPE_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,TYPE, java.lang.String.class, "类型", "类型", java.lang.String.class, null);
	
	/**
	 * 仓库组 , 类型: java.lang.String
	*/
	public static final String LOCATION_GROUP="locationGroup";
	
	/**
	 * 仓库组 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> LOCATION_GROUP_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,LOCATION_GROUP, java.lang.String.class, "仓库组", "仓库组", java.lang.String.class, null);
	
	/**
	 * 库位属性 , 类型: java.lang.String
	*/
	public static final String LOCATION_ATTRIBUTE="locationAttribute";
	
	/**
	 * 库位属性 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> LOCATION_ATTRIBUTE_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,LOCATION_ATTRIBUTE, java.lang.String.class, "库位属性", "库位属性", java.lang.String.class, null);
	
	/**
	 * RFID标签 , 类型: java.lang.String
	*/
	public static final String RFID="rfid";
	
	/**
	 * RFID标签 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> RFID_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,RFID, java.lang.String.class, "RFID标签", "RFID标签", java.lang.String.class, null);
	
	/**
	 * 长 , 类型: java.math.BigDecimal
	*/
	public static final String LENGTH="length";
	
	/**
	 * 长 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.math.BigDecimal> LENGTH_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,LENGTH, java.math.BigDecimal.class, "长", "长", java.math.BigDecimal.class, null);
	
	/**
	 * 宽 , 类型: java.math.BigDecimal
	*/
	public static final String WIDTH="width";
	
	/**
	 * 宽 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.math.BigDecimal> WIDTH_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,WIDTH, java.math.BigDecimal.class, "宽", "宽", java.math.BigDecimal.class, null);
	
	/**
	 * 高 , 类型: java.math.BigDecimal
	*/
	public static final String HEIGHT="height";
	
	/**
	 * 高 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.math.BigDecimal> HEIGHT_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,HEIGHT, java.math.BigDecimal.class, "高", "高", java.math.BigDecimal.class, null);
	
	/**
	 * 最大体积 , 类型: java.math.BigDecimal
	*/
	public static final String MAX_VOLUME="maxVolume";
	
	/**
	 * 最大体积 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.math.BigDecimal> MAX_VOLUME_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,MAX_VOLUME, java.math.BigDecimal.class, "最大体积", "最大体积", java.math.BigDecimal.class, null);
	
	/**
	 * 最大重量 , 类型: java.math.BigDecimal
	*/
	public static final String MAX_WEIGHT="maxWeight";
	
	/**
	 * 最大重量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.math.BigDecimal> MAX_WEIGHT_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,MAX_WEIGHT, java.math.BigDecimal.class, "最大重量", "最大重量", java.math.BigDecimal.class, null);
	
	/**
	 * 最小批量 , 类型: java.math.BigDecimal
	*/
	public static final String MIN_BATCH="minBatch";
	
	/**
	 * 最小批量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.math.BigDecimal> MIN_BATCH_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,MIN_BATCH, java.math.BigDecimal.class, "最小批量", "最小批量", java.math.BigDecimal.class, null);
	
	/**
	 * 最大批量 , 类型: java.math.BigDecimal
	*/
	public static final String MAX_BATCH="maxBatch";
	
	/**
	 * 最大批量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.math.BigDecimal> MAX_BATCH_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,MAX_BATCH, java.math.BigDecimal.class, "最大批量", "最大批量", java.math.BigDecimal.class, null);
	
	/**
	 * X坐标 , 类型: java.math.BigDecimal
	*/
	public static final String X_COORDINATE="xCoordinate";
	
	/**
	 * X坐标 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.math.BigDecimal> X_COORDINATE_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,X_COORDINATE, java.math.BigDecimal.class, "X坐标", "X坐标", java.math.BigDecimal.class, null);
	
	/**
	 * Y坐标 , 类型: java.math.BigDecimal
	*/
	public static final String Y_COORDINATE="yCoordinate";
	
	/**
	 * Y坐标 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.math.BigDecimal> Y_COORDINATE_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,Y_COORDINATE, java.math.BigDecimal.class, "Y坐标", "Y坐标", java.math.BigDecimal.class, null);
	
	/**
	 * Z坐标 , 类型: java.math.BigDecimal
	*/
	public static final String Z_COORDINATE="zCoordinate";
	
	/**
	 * Z坐标 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.math.BigDecimal> Z_COORDINATE_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,Z_COORDINATE, java.math.BigDecimal.class, "Z坐标", "Z坐标", java.math.BigDecimal.class, null);
	
	/**
	 * 备注1 , 类型: java.lang.String
	*/
	public static final String NOTES1="notes1";
	
	/**
	 * 备注1 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> NOTES1_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,NOTES1, java.lang.String.class, "备注1", "备注1", java.lang.String.class, null);
	
	/**
	 * 备注2 , 类型: java.lang.String
	*/
	public static final String NOTES2="notes2";
	
	/**
	 * 备注2 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> NOTES2_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,NOTES2, java.lang.String.class, "备注2", "备注2", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * storehouse , 类型: com.dt.platform.domain.wms.Storehouse
	*/
	public static final String STOREHOUSE="storehouse";
	
	/**
	 * storehouse , 类型: com.dt.platform.domain.wms.Storehouse
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,com.dt.platform.domain.wms.Storehouse> STOREHOUSE_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,STOREHOUSE, com.dt.platform.domain.wms.Storehouse.class, "storehouse", "storehouse", com.dt.platform.domain.wms.Storehouse.class, null);
	
	/**
	 * customer , 类型: com.dt.platform.domain.wms.Customer
	*/
	public static final String CUSTOMER="customer";
	
	/**
	 * customer , 类型: com.dt.platform.domain.wms.Customer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,com.dt.platform.domain.wms.Customer> CUSTOMER_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,CUSTOMER, com.dt.platform.domain.wms.Customer.class, "customer", "customer", com.dt.platform.domain.wms.Customer.class, null);
	
	/**
	 * productAttr , 集合类型: LIST , 类型: com.dt.platform.domain.wms.ProductAttr
	*/
	public static final String PRODUCT_ATTR_LIST="productAttrList";
	
	/**
	 * productAttr , 集合类型: LIST , 类型: com.dt.platform.domain.wms.ProductAttr
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,com.dt.platform.domain.wms.ProductAttr> PRODUCT_ATTR_LIST_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,PRODUCT_ATTR_LIST, java.util.List.class, "productAttr", "productAttr", com.dt.platform.domain.wms.ProductAttr.class, null);
	
	/**
	 * productAttrIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String PRODUCT_ATTR_IDS="productAttrIds";
	
	/**
	 * productAttrIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,java.lang.String> PRODUCT_ATTR_IDS_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,PRODUCT_ATTR_IDS, java.util.List.class, "productAttrIds", "productAttrIds", java.lang.String.class, null);
	
	/**
	 * locType , 类型: com.dt.platform.domain.wms.LocType
	*/
	public static final String LOC_TYPE="locType";
	
	/**
	 * locType , 类型: com.dt.platform.domain.wms.LocType
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,com.dt.platform.domain.wms.LocType> LOC_TYPE_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,LOC_TYPE, com.dt.platform.domain.wms.LocType.class, "locType", "locType", com.dt.platform.domain.wms.LocType.class, null);
	
	/**
	 * temperatureAttribute , 类型: com.dt.platform.domain.wms.TemperatureAttribute
	*/
	public static final String TEMPERATURE_ATTRIBUTE="temperatureAttribute";
	
	/**
	 * temperatureAttribute , 类型: com.dt.platform.domain.wms.TemperatureAttribute
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.StorelocationVO,com.dt.platform.domain.wms.TemperatureAttribute> TEMPERATURE_ATTRIBUTE_PROP = new BeanProperty(com.dt.platform.domain.wms.StorelocationVO.class ,TEMPERATURE_ATTRIBUTE, com.dt.platform.domain.wms.TemperatureAttribute.class, "temperatureAttribute", "temperatureAttribute", com.dt.platform.domain.wms.TemperatureAttribute.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ PAGE_INDEX , PAGE_SIZE , SEARCH_FIELD , FUZZY_FIELD , SEARCH_VALUE , DIRTY_FIELDS , SORT_FIELD , SORT_TYPE , DATA_ORIGIN , QUERY_LOGIC , REQUEST_ACTION , IDS , ID , STOREHOUSE_ID , CUSTOMER_ID , CODE , BAR_CODE , NAME , STATUS , TYPE , LOCATION_GROUP , LOCATION_ATTRIBUTE , RFID , LENGTH , WIDTH , HEIGHT , MAX_VOLUME , MAX_WEIGHT , MIN_BATCH , MAX_BATCH , X_COORDINATE , Y_COORDINATE , Z_COORDINATE , NOTES1 , NOTES2 , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , STOREHOUSE , CUSTOMER , PRODUCT_ATTR_LIST , PRODUCT_ATTR_IDS , LOC_TYPE , TEMPERATURE_ATTRIBUTE };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.wms.StorelocationVO {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 页码
		 * @param pageIndex 页码
		 * @return 当前对象
		*/
		public StorelocationVO setPageIndex(Integer pageIndex) {
			super.change(PAGE_INDEX,super.getPageIndex(),pageIndex);
			super.setPageIndex(pageIndex);
			return this;
		}
		
		/**
		 * 设置 分页大小
		 * @param pageSize 分页大小
		 * @return 当前对象
		*/
		public StorelocationVO setPageSize(Integer pageSize) {
			super.change(PAGE_SIZE,super.getPageSize(),pageSize);
			super.setPageSize(pageSize);
			return this;
		}
		
		/**
		 * 设置 搜索字段
		 * @param searchField 搜索字段
		 * @return 当前对象
		*/
		public StorelocationVO setSearchField(String searchField) {
			super.change(SEARCH_FIELD,super.getSearchField(),searchField);
			super.setSearchField(searchField);
			return this;
		}
		
		/**
		 * 设置 模糊搜索字段
		 * @param fuzzyField 模糊搜索字段
		 * @return 当前对象
		*/
		public StorelocationVO setFuzzyField(String fuzzyField) {
			super.change(FUZZY_FIELD,super.getFuzzyField(),fuzzyField);
			super.setFuzzyField(fuzzyField);
			return this;
		}
		
		/**
		 * 设置 搜索的值
		 * @param searchValue 搜索的值
		 * @return 当前对象
		*/
		public StorelocationVO setSearchValue(String searchValue) {
			super.change(SEARCH_VALUE,super.getSearchValue(),searchValue);
			super.setSearchValue(searchValue);
			return this;
		}
		
		/**
		 * 设置 已修改字段
		 * @param dirtyFields 已修改字段
		 * @return 当前对象
		*/
		public StorelocationVO setDirtyFields(List<String> dirtyFields) {
			super.change(DIRTY_FIELDS,super.getDirtyFields(),dirtyFields);
			super.setDirtyFields(dirtyFields);
			return this;
		}
		
		/**
		 * 设置 排序字段
		 * @param sortField 排序字段
		 * @return 当前对象
		*/
		public StorelocationVO setSortField(String sortField) {
			super.change(SORT_FIELD,super.getSortField(),sortField);
			super.setSortField(sortField);
			return this;
		}
		
		/**
		 * 设置 排序方式
		 * @param sortType 排序方式
		 * @return 当前对象
		*/
		public StorelocationVO setSortType(String sortType) {
			super.change(SORT_TYPE,super.getSortType(),sortType);
			super.setSortType(sortType);
			return this;
		}
		
		/**
		 * 设置 数据来源
		 * @param dataOrigin 数据来源
		 * @return 当前对象
		*/
		public StorelocationVO setDataOrigin(String dataOrigin) {
			super.change(DATA_ORIGIN,super.getDataOrigin(),dataOrigin);
			super.setDataOrigin(dataOrigin);
			return this;
		}
		
		/**
		 * 设置 查询逻辑
		 * @param queryLogic 查询逻辑
		 * @return 当前对象
		*/
		public StorelocationVO setQueryLogic(String queryLogic) {
			super.change(QUERY_LOGIC,super.getQueryLogic(),queryLogic);
			super.setQueryLogic(queryLogic);
			return this;
		}
		
		/**
		 * 设置 请求动作
		 * @param requestAction 请求动作
		 * @return 当前对象
		*/
		public StorelocationVO setRequestAction(String requestAction) {
			super.change(REQUEST_ACTION,super.getRequestAction(),requestAction);
			super.setRequestAction(requestAction);
			return this;
		}
		
		/**
		 * 设置 主键清单
		 * @param ids 主键清单
		 * @return 当前对象
		*/
		public StorelocationVO setIds(List<String> ids) {
			super.change(IDS,super.getIds(),ids);
			super.setIds(ids);
			return this;
		}
		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Storelocation setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 仓库
		 * @param storehouseId 仓库
		 * @return 当前对象
		*/
		public Storelocation setStorehouseId(String storehouseId) {
			super.change(STOREHOUSE_ID,super.getStorehouseId(),storehouseId);
			super.setStorehouseId(storehouseId);
			return this;
		}
		
		/**
		 * 设置 所属客户
		 * @param customerId 所属客户
		 * @return 当前对象
		*/
		public Storelocation setCustomerId(String customerId) {
			super.change(CUSTOMER_ID,super.getCustomerId(),customerId);
			super.setCustomerId(customerId);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public Storelocation setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 条码
		 * @param barCode 条码
		 * @return 当前对象
		*/
		public Storelocation setBarCode(String barCode) {
			super.change(BAR_CODE,super.getBarCode(),barCode);
			super.setBarCode(barCode);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public Storelocation setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 状态
		 * @param status 状态
		 * @return 当前对象
		*/
		public Storelocation setStatus(String status) {
			super.change(STATUS,super.getStatus(),status);
			super.setStatus(status);
			return this;
		}
		
		/**
		 * 设置 类型
		 * @param type 类型
		 * @return 当前对象
		*/
		public Storelocation setType(String type) {
			super.change(TYPE,super.getType(),type);
			super.setType(type);
			return this;
		}
		
		/**
		 * 设置 仓库组
		 * @param locationGroup 仓库组
		 * @return 当前对象
		*/
		public Storelocation setLocationGroup(String locationGroup) {
			super.change(LOCATION_GROUP,super.getLocationGroup(),locationGroup);
			super.setLocationGroup(locationGroup);
			return this;
		}
		
		/**
		 * 设置 库位属性
		 * @param locationAttribute 库位属性
		 * @return 当前对象
		*/
		public Storelocation setLocationAttribute(String locationAttribute) {
			super.change(LOCATION_ATTRIBUTE,super.getLocationAttribute(),locationAttribute);
			super.setLocationAttribute(locationAttribute);
			return this;
		}
		
		/**
		 * 设置 RFID标签
		 * @param rfid RFID标签
		 * @return 当前对象
		*/
		public Storelocation setRfid(String rfid) {
			super.change(RFID,super.getRfid(),rfid);
			super.setRfid(rfid);
			return this;
		}
		
		/**
		 * 设置 长
		 * @param length 长
		 * @return 当前对象
		*/
		public Storelocation setLength(BigDecimal length) {
			super.change(LENGTH,super.getLength(),length);
			super.setLength(length);
			return this;
		}
		
		/**
		 * 设置 宽
		 * @param width 宽
		 * @return 当前对象
		*/
		public Storelocation setWidth(BigDecimal width) {
			super.change(WIDTH,super.getWidth(),width);
			super.setWidth(width);
			return this;
		}
		
		/**
		 * 设置 高
		 * @param height 高
		 * @return 当前对象
		*/
		public Storelocation setHeight(BigDecimal height) {
			super.change(HEIGHT,super.getHeight(),height);
			super.setHeight(height);
			return this;
		}
		
		/**
		 * 设置 最大体积
		 * @param maxVolume 最大体积
		 * @return 当前对象
		*/
		public Storelocation setMaxVolume(BigDecimal maxVolume) {
			super.change(MAX_VOLUME,super.getMaxVolume(),maxVolume);
			super.setMaxVolume(maxVolume);
			return this;
		}
		
		/**
		 * 设置 最大重量
		 * @param maxWeight 最大重量
		 * @return 当前对象
		*/
		public Storelocation setMaxWeight(BigDecimal maxWeight) {
			super.change(MAX_WEIGHT,super.getMaxWeight(),maxWeight);
			super.setMaxWeight(maxWeight);
			return this;
		}
		
		/**
		 * 设置 最小批量
		 * @param minBatch 最小批量
		 * @return 当前对象
		*/
		public Storelocation setMinBatch(BigDecimal minBatch) {
			super.change(MIN_BATCH,super.getMinBatch(),minBatch);
			super.setMinBatch(minBatch);
			return this;
		}
		
		/**
		 * 设置 最大批量
		 * @param maxBatch 最大批量
		 * @return 当前对象
		*/
		public Storelocation setMaxBatch(BigDecimal maxBatch) {
			super.change(MAX_BATCH,super.getMaxBatch(),maxBatch);
			super.setMaxBatch(maxBatch);
			return this;
		}
		
		/**
		 * 设置 X坐标
		 * @param xCoordinate X坐标
		 * @return 当前对象
		*/
		public Storelocation setXCoordinate(BigDecimal xCoordinate) {
			super.change(X_COORDINATE,super.getXCoordinate(),xCoordinate);
			super.setXCoordinate(xCoordinate);
			return this;
		}
		
		/**
		 * 设置 Y坐标
		 * @param yCoordinate Y坐标
		 * @return 当前对象
		*/
		public Storelocation setYCoordinate(BigDecimal yCoordinate) {
			super.change(Y_COORDINATE,super.getYCoordinate(),yCoordinate);
			super.setYCoordinate(yCoordinate);
			return this;
		}
		
		/**
		 * 设置 Z坐标
		 * @param zCoordinate Z坐标
		 * @return 当前对象
		*/
		public Storelocation setZCoordinate(BigDecimal zCoordinate) {
			super.change(Z_COORDINATE,super.getZCoordinate(),zCoordinate);
			super.setZCoordinate(zCoordinate);
			return this;
		}
		
		/**
		 * 设置 备注1
		 * @param notes1 备注1
		 * @return 当前对象
		*/
		public Storelocation setNotes1(String notes1) {
			super.change(NOTES1,super.getNotes1(),notes1);
			super.setNotes1(notes1);
			return this;
		}
		
		/**
		 * 设置 备注2
		 * @param notes2 备注2
		 * @return 当前对象
		*/
		public Storelocation setNotes2(String notes2) {
			super.change(NOTES2,super.getNotes2(),notes2);
			super.setNotes2(notes2);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Storelocation setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Storelocation setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Storelocation setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Storelocation setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Storelocation setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Storelocation setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Storelocation setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Storelocation setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Storelocation setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 storehouse
		 * @param storehouse storehouse
		 * @return 当前对象
		*/
		public Storelocation setStorehouse(Storehouse storehouse) {
			super.change(STOREHOUSE,super.getStorehouse(),storehouse);
			super.setStorehouse(storehouse);
			return this;
		}
		
		/**
		 * 设置 customer
		 * @param customer customer
		 * @return 当前对象
		*/
		public Storelocation setCustomer(Customer customer) {
			super.change(CUSTOMER,super.getCustomer(),customer);
			super.setCustomer(customer);
			return this;
		}
		
		/**
		 * 设置 productAttr
		 * @param productAttrList productAttr
		 * @return 当前对象
		*/
		public Storelocation setProductAttrList(List<ProductAttr> productAttrList) {
			super.change(PRODUCT_ATTR_LIST,super.getProductAttrList(),productAttrList);
			super.setProductAttrList(productAttrList);
			return this;
		}
		
		/**
		 * 设置 productAttrIds
		 * @param productAttrIds productAttrIds
		 * @return 当前对象
		*/
		public Storelocation setProductAttrIds(List<String> productAttrIds) {
			super.change(PRODUCT_ATTR_IDS,super.getProductAttrIds(),productAttrIds);
			super.setProductAttrIds(productAttrIds);
			return this;
		}
		
		/**
		 * 设置 locType
		 * @param locType locType
		 * @return 当前对象
		*/
		public Storelocation setLocType(LocType locType) {
			super.change(LOC_TYPE,super.getLocType(),locType);
			super.setLocType(locType);
			return this;
		}
		
		/**
		 * 设置 temperatureAttribute
		 * @param temperatureAttribute temperatureAttribute
		 * @return 当前对象
		*/
		public Storelocation setTemperatureAttribute(TemperatureAttribute temperatureAttribute) {
			super.change(TEMPERATURE_ATTRIBUTE,super.getTemperatureAttribute(),temperatureAttribute);
			super.setTemperatureAttribute(temperatureAttribute);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public StorelocationVO clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public StorelocationVO duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setCode(this.getCode());
			inst.setMaxBatch(this.getMaxBatch());
			inst.setType(this.getType());
			inst.setYCoordinate(this.getYCoordinate());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setNotes2(this.getNotes2());
			inst.setNotes1(this.getNotes1());
			inst.setCustomerId(this.getCustomerId());
			inst.setId(this.getId());
			inst.setMinBatch(this.getMinBatch());
			inst.setLocationGroup(this.getLocationGroup());
			inst.setLocationAttribute(this.getLocationAttribute());
			inst.setHeight(this.getHeight());
			inst.setLength(this.getLength());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setMaxWeight(this.getMaxWeight());
			inst.setVersion(this.getVersion());
			inst.setMaxVolume(this.getMaxVolume());
			inst.setBarCode(this.getBarCode());
			inst.setXCoordinate(this.getXCoordinate());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setStorehouseId(this.getStorehouseId());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setWidth(this.getWidth());
			inst.setZCoordinate(this.getZCoordinate());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setRfid(this.getRfid());
			inst.setStatus(this.getStatus());
			if(all) {
				inst.setSearchField(this.getSearchField());
				inst.setRequestAction(this.getRequestAction());
				inst.setFuzzyField(this.getFuzzyField());
				inst.setPageSize(this.getPageSize());
				inst.setTemperatureAttribute(this.getTemperatureAttribute());
				inst.setStorehouse(this.getStorehouse());
				inst.setProductAttrIds(this.getProductAttrIds());
				inst.setPageIndex(this.getPageIndex());
				inst.setSortType(this.getSortType());
				inst.setDirtyFields(this.getDirtyFields());
				inst.setSortField(this.getSortField());
				inst.setDataOrigin(this.getDataOrigin());
				inst.setIds(this.getIds());
				inst.setQueryLogic(this.getQueryLogic());
				inst.setLocType(this.getLocType());
				inst.setSearchValue(this.getSearchValue());
				inst.setCustomer(this.getCustomer());
				inst.setProductAttrList(this.getProductAttrList());
			}
			inst.clearModifies();
			return inst;
		}

	}
}