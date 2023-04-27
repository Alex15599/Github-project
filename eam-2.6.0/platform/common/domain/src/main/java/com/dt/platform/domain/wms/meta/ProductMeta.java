package com.dt.platform.domain.wms.meta;

import com.github.foxnic.api.bean.BeanProperty;
import com.dt.platform.domain.wms.Product;
import java.math.BigDecimal;
import java.util.Date;
import com.dt.platform.domain.wms.ProductAttr;
import java.util.List;
import com.dt.platform.domain.wms.Customer;
import com.dt.platform.domain.wms.Unit;
import com.dt.platform.domain.wms.ProductCategory;
import javax.persistence.Transient;



/**
 * @author 金杰 , maillank@qq.com
 * @since 2023-03-04 14:02:35
 * @sign F384678280ED10715A4C03F1CE3B72C2
 * 此文件由工具自动生成，请勿修改。若表结构或配置发生变动，请使用工具重新生成。
*/

public class ProductMeta {
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final String ID="id";
	
	/**
	 * 主键 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> ID_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,ID, java.lang.String.class, "主键", "主键", java.lang.String.class, null);
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final String CODE="code";
	
	/**
	 * 编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> CODE_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,CODE, java.lang.String.class, "编码", "编码", java.lang.String.class, null);
	
	/**
	 * 条形码 , 类型: java.lang.String
	*/
	public static final String BAR_CODE="barCode";
	
	/**
	 * 条形码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> BAR_CODE_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,BAR_CODE, java.lang.String.class, "条形码", "条形码", java.lang.String.class, null);
	
	/**
	 * 货主 , 类型: java.lang.String
	*/
	public static final String CUST_ID="custId";
	
	/**
	 * 货主 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> CUST_ID_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,CUST_ID, java.lang.String.class, "货主", "货主", java.lang.String.class, null);
	
	/**
	 * 客户商品编码 , 类型: java.lang.String
	*/
	public static final String CUST_PRODUCT_CODE="custProductCode";
	
	/**
	 * 客户商品编码 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> CUST_PRODUCT_CODE_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,CUST_PRODUCT_CODE, java.lang.String.class, "客户商品编码", "客户商品编码", java.lang.String.class, null);
	
	/**
	 * 商品规格 , 类型: java.lang.String
	*/
	public static final String PRODUCT_MODEL="productModel";
	
	/**
	 * 商品规格 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> PRODUCT_MODEL_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,PRODUCT_MODEL, java.lang.String.class, "商品规格", "商品规格", java.lang.String.class, null);
	
	/**
	 * 商品品牌 , 类型: java.lang.String
	*/
	public static final String PRODUCT_BRAND="productBrand";
	
	/**
	 * 商品品牌 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> PRODUCT_BRAND_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,PRODUCT_BRAND, java.lang.String.class, "商品品牌", "商品品牌", java.lang.String.class, null);
	
	/**
	 * 商品SKU , 类型: java.lang.String
	*/
	public static final String PRODUCT_SKU="productSku";
	
	/**
	 * 商品SKU , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> PRODUCT_SKU_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,PRODUCT_SKU, java.lang.String.class, "商品SKU", "商品SKU", java.lang.String.class, null);
	
	/**
	 * 大类 , 类型: java.lang.String
	*/
	public static final String CATEGORY="category";
	
	/**
	 * 大类 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,CATEGORY, java.lang.String.class, "大类", "大类", java.lang.String.class, null);
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final String NAME="name";
	
	/**
	 * 名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> NAME_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,NAME, java.lang.String.class, "名称", "名称", java.lang.String.class, null);
	
	/**
	 * 英文名称 , 类型: java.lang.String
	*/
	public static final String EN_NAME="enName";
	
	/**
	 * 英文名称 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> EN_NAME_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,EN_NAME, java.lang.String.class, "英文名称", "英文名称", java.lang.String.class, null);
	
	/**
	 * 单位 , 类型: java.lang.String
	*/
	public static final String UNIT="unit";
	
	/**
	 * 单位 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> UNIT_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,UNIT, java.lang.String.class, "单位", "单位", java.lang.String.class, null);
	
	/**
	 * 长 , 类型: java.math.BigDecimal
	*/
	public static final String LENGTH="length";
	
	/**
	 * 长 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.math.BigDecimal> LENGTH_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,LENGTH, java.math.BigDecimal.class, "长", "长", java.math.BigDecimal.class, null);
	
	/**
	 * 宽 , 类型: java.math.BigDecimal
	*/
	public static final String WIDTH="width";
	
	/**
	 * 宽 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.math.BigDecimal> WIDTH_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,WIDTH, java.math.BigDecimal.class, "宽", "宽", java.math.BigDecimal.class, null);
	
	/**
	 * 高 , 类型: java.math.BigDecimal
	*/
	public static final String HEIGHT="height";
	
	/**
	 * 高 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.math.BigDecimal> HEIGHT_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,HEIGHT, java.math.BigDecimal.class, "高", "高", java.math.BigDecimal.class, null);
	
	/**
	 * 最大体积 , 类型: java.math.BigDecimal
	*/
	public static final String MAX_VOLUME="maxVolume";
	
	/**
	 * 最大体积 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.math.BigDecimal> MAX_VOLUME_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,MAX_VOLUME, java.math.BigDecimal.class, "最大体积", "最大体积", java.math.BigDecimal.class, null);
	
	/**
	 * 最大重量 , 类型: java.math.BigDecimal
	*/
	public static final String MAX_WEIGHT="maxWeight";
	
	/**
	 * 最大重量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.math.BigDecimal> MAX_WEIGHT_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,MAX_WEIGHT, java.math.BigDecimal.class, "最大重量", "最大重量", java.math.BigDecimal.class, null);
	
	/**
	 * 保质期 , 类型: java.math.BigDecimal
	*/
	public static final String PERIOD="period";
	
	/**
	 * 保质期 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.math.BigDecimal> PERIOD_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,PERIOD, java.math.BigDecimal.class, "保质期", "保质期", java.math.BigDecimal.class, null);
	
	/**
	 * 允收天数 , 类型: java.math.BigDecimal
	*/
	public static final String KEEP_DATE="keepDate";
	
	/**
	 * 允收天数 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.math.BigDecimal> KEEP_DATE_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,KEEP_DATE, java.math.BigDecimal.class, "允收天数", "允收天数", java.math.BigDecimal.class, null);
	
	/**
	 * 最小库存数量 , 类型: java.math.BigDecimal
	*/
	public static final String MIN_STOCK_NUMBER="minStockNumber";
	
	/**
	 * 最小库存数量 , 类型: java.math.BigDecimal
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.math.BigDecimal> MIN_STOCK_NUMBER_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,MIN_STOCK_NUMBER, java.math.BigDecimal.class, "最小库存数量", "最小库存数量", java.math.BigDecimal.class, null);
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final String NOTES="notes";
	
	/**
	 * 备注 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> NOTES_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,NOTES, java.lang.String.class, "备注", "备注", java.lang.String.class, null);
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final String CREATE_BY="createBy";
	
	/**
	 * 创建人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> CREATE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,CREATE_BY, java.lang.String.class, "创建人ID", "创建人ID", java.lang.String.class, null);
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final String CREATE_TIME="createTime";
	
	/**
	 * 创建时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.util.Date> CREATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,CREATE_TIME, java.util.Date.class, "创建时间", "创建时间", java.util.Date.class, null);
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final String UPDATE_BY="updateBy";
	
	/**
	 * 修改人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> UPDATE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,UPDATE_BY, java.lang.String.class, "修改人ID", "修改人ID", java.lang.String.class, null);
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final String UPDATE_TIME="updateTime";
	
	/**
	 * 修改时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.util.Date> UPDATE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,UPDATE_TIME, java.util.Date.class, "修改时间", "修改时间", java.util.Date.class, null);
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final String DELETED="deleted";
	
	/**
	 * 是否已删除 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.Integer> DELETED_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,DELETED, java.lang.Integer.class, "是否已删除", "是否已删除", java.lang.Integer.class, null);
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final String DELETE_BY="deleteBy";
	
	/**
	 * 删除人ID , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> DELETE_BY_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,DELETE_BY, java.lang.String.class, "删除人ID", "删除人ID", java.lang.String.class, null);
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final String DELETE_TIME="deleteTime";
	
	/**
	 * 删除时间 , 类型: java.util.Date
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.util.Date> DELETE_TIME_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,DELETE_TIME, java.util.Date.class, "删除时间", "删除时间", java.util.Date.class, null);
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final String VERSION="version";
	
	/**
	 * 数据版本号 , 类型: java.lang.Integer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.Integer> VERSION_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,VERSION, java.lang.Integer.class, "数据版本号", "数据版本号", java.lang.Integer.class, null);
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final String TENANT_ID="tenantId";
	
	/**
	 * 租户 , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> TENANT_ID_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,TENANT_ID, java.lang.String.class, "租户", "租户", java.lang.String.class, null);
	
	/**
	 * productAttr , 集合类型: LIST , 类型: com.dt.platform.domain.wms.ProductAttr
	*/
	public static final String PRODUCT_ATTR_LIST="productAttrList";
	
	/**
	 * productAttr , 集合类型: LIST , 类型: com.dt.platform.domain.wms.ProductAttr
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,com.dt.platform.domain.wms.ProductAttr> PRODUCT_ATTR_LIST_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,PRODUCT_ATTR_LIST, java.util.List.class, "productAttr", "productAttr", com.dt.platform.domain.wms.ProductAttr.class, null);
	
	/**
	 * productAttrIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final String PRODUCT_ATTR_IDS="productAttrIds";
	
	/**
	 * productAttrIds , 集合类型: LIST , 类型: java.lang.String
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,java.lang.String> PRODUCT_ATTR_IDS_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,PRODUCT_ATTR_IDS, java.util.List.class, "productAttrIds", "productAttrIds", java.lang.String.class, null);
	
	/**
	 * customer , 类型: com.dt.platform.domain.wms.Customer
	*/
	public static final String CUSTOMER="customer";
	
	/**
	 * customer , 类型: com.dt.platform.domain.wms.Customer
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,com.dt.platform.domain.wms.Customer> CUSTOMER_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,CUSTOMER, com.dt.platform.domain.wms.Customer.class, "customer", "customer", com.dt.platform.domain.wms.Customer.class, null);
	
	/**
	 * UnitData , 类型: com.dt.platform.domain.wms.Unit
	*/
	public static final String UNIT_DATA="unitData";
	
	/**
	 * UnitData , 类型: com.dt.platform.domain.wms.Unit
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,com.dt.platform.domain.wms.Unit> UNIT_DATA_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,UNIT_DATA, com.dt.platform.domain.wms.Unit.class, "UnitData", "UnitData", com.dt.platform.domain.wms.Unit.class, null);
	
	/**
	 * productCategory , 类型: com.dt.platform.domain.wms.ProductCategory
	*/
	public static final String PRODUCT_CATEGORY="productCategory";
	
	/**
	 * productCategory , 类型: com.dt.platform.domain.wms.ProductCategory
	*/
	public static final BeanProperty<com.dt.platform.domain.wms.Product,com.dt.platform.domain.wms.ProductCategory> PRODUCT_CATEGORY_PROP = new BeanProperty(com.dt.platform.domain.wms.Product.class ,PRODUCT_CATEGORY, com.dt.platform.domain.wms.ProductCategory.class, "productCategory", "productCategory", com.dt.platform.domain.wms.ProductCategory.class, null);
	
	/**
	 * 全部属性清单
	*/
	public static final String[] $PROPS={ ID , CODE , BAR_CODE , CUST_ID , CUST_PRODUCT_CODE , PRODUCT_MODEL , PRODUCT_BRAND , PRODUCT_SKU , CATEGORY , NAME , EN_NAME , UNIT , LENGTH , WIDTH , HEIGHT , MAX_VOLUME , MAX_WEIGHT , PERIOD , KEEP_DATE , MIN_STOCK_NUMBER , NOTES , CREATE_BY , CREATE_TIME , UPDATE_BY , UPDATE_TIME , DELETED , DELETE_BY , DELETE_TIME , VERSION , TENANT_ID , PRODUCT_ATTR_LIST , PRODUCT_ATTR_IDS , CUSTOMER , UNIT_DATA , PRODUCT_CATEGORY };
	
	/**
	 * 代理类
	*/
	public static class $$proxy$$ extends com.dt.platform.domain.wms.Product {

		private static final long serialVersionUID = 1L;

		
		/**
		 * 设置 主键
		 * @param id 主键
		 * @return 当前对象
		*/
		public Product setId(String id) {
			super.change(ID,super.getId(),id);
			super.setId(id);
			return this;
		}
		
		/**
		 * 设置 编码
		 * @param code 编码
		 * @return 当前对象
		*/
		public Product setCode(String code) {
			super.change(CODE,super.getCode(),code);
			super.setCode(code);
			return this;
		}
		
		/**
		 * 设置 条形码
		 * @param barCode 条形码
		 * @return 当前对象
		*/
		public Product setBarCode(String barCode) {
			super.change(BAR_CODE,super.getBarCode(),barCode);
			super.setBarCode(barCode);
			return this;
		}
		
		/**
		 * 设置 货主
		 * @param custId 货主
		 * @return 当前对象
		*/
		public Product setCustId(String custId) {
			super.change(CUST_ID,super.getCustId(),custId);
			super.setCustId(custId);
			return this;
		}
		
		/**
		 * 设置 客户商品编码
		 * @param custProductCode 客户商品编码
		 * @return 当前对象
		*/
		public Product setCustProductCode(String custProductCode) {
			super.change(CUST_PRODUCT_CODE,super.getCustProductCode(),custProductCode);
			super.setCustProductCode(custProductCode);
			return this;
		}
		
		/**
		 * 设置 商品规格
		 * @param productModel 商品规格
		 * @return 当前对象
		*/
		public Product setProductModel(String productModel) {
			super.change(PRODUCT_MODEL,super.getProductModel(),productModel);
			super.setProductModel(productModel);
			return this;
		}
		
		/**
		 * 设置 商品品牌
		 * @param productBrand 商品品牌
		 * @return 当前对象
		*/
		public Product setProductBrand(String productBrand) {
			super.change(PRODUCT_BRAND,super.getProductBrand(),productBrand);
			super.setProductBrand(productBrand);
			return this;
		}
		
		/**
		 * 设置 商品SKU
		 * @param productSku 商品SKU
		 * @return 当前对象
		*/
		public Product setProductSku(String productSku) {
			super.change(PRODUCT_SKU,super.getProductSku(),productSku);
			super.setProductSku(productSku);
			return this;
		}
		
		/**
		 * 设置 大类
		 * @param category 大类
		 * @return 当前对象
		*/
		public Product setCategory(String category) {
			super.change(CATEGORY,super.getCategory(),category);
			super.setCategory(category);
			return this;
		}
		
		/**
		 * 设置 名称
		 * @param name 名称
		 * @return 当前对象
		*/
		public Product setName(String name) {
			super.change(NAME,super.getName(),name);
			super.setName(name);
			return this;
		}
		
		/**
		 * 设置 英文名称
		 * @param enName 英文名称
		 * @return 当前对象
		*/
		public Product setEnName(String enName) {
			super.change(EN_NAME,super.getEnName(),enName);
			super.setEnName(enName);
			return this;
		}
		
		/**
		 * 设置 单位
		 * @param unit 单位
		 * @return 当前对象
		*/
		public Product setUnit(String unit) {
			super.change(UNIT,super.getUnit(),unit);
			super.setUnit(unit);
			return this;
		}
		
		/**
		 * 设置 长
		 * @param length 长
		 * @return 当前对象
		*/
		public Product setLength(BigDecimal length) {
			super.change(LENGTH,super.getLength(),length);
			super.setLength(length);
			return this;
		}
		
		/**
		 * 设置 宽
		 * @param width 宽
		 * @return 当前对象
		*/
		public Product setWidth(BigDecimal width) {
			super.change(WIDTH,super.getWidth(),width);
			super.setWidth(width);
			return this;
		}
		
		/**
		 * 设置 高
		 * @param height 高
		 * @return 当前对象
		*/
		public Product setHeight(BigDecimal height) {
			super.change(HEIGHT,super.getHeight(),height);
			super.setHeight(height);
			return this;
		}
		
		/**
		 * 设置 最大体积
		 * @param maxVolume 最大体积
		 * @return 当前对象
		*/
		public Product setMaxVolume(BigDecimal maxVolume) {
			super.change(MAX_VOLUME,super.getMaxVolume(),maxVolume);
			super.setMaxVolume(maxVolume);
			return this;
		}
		
		/**
		 * 设置 最大重量
		 * @param maxWeight 最大重量
		 * @return 当前对象
		*/
		public Product setMaxWeight(BigDecimal maxWeight) {
			super.change(MAX_WEIGHT,super.getMaxWeight(),maxWeight);
			super.setMaxWeight(maxWeight);
			return this;
		}
		
		/**
		 * 设置 保质期
		 * @param period 保质期
		 * @return 当前对象
		*/
		public Product setPeriod(BigDecimal period) {
			super.change(PERIOD,super.getPeriod(),period);
			super.setPeriod(period);
			return this;
		}
		
		/**
		 * 设置 允收天数
		 * @param keepDate 允收天数
		 * @return 当前对象
		*/
		public Product setKeepDate(BigDecimal keepDate) {
			super.change(KEEP_DATE,super.getKeepDate(),keepDate);
			super.setKeepDate(keepDate);
			return this;
		}
		
		/**
		 * 设置 最小库存数量
		 * @param minStockNumber 最小库存数量
		 * @return 当前对象
		*/
		public Product setMinStockNumber(BigDecimal minStockNumber) {
			super.change(MIN_STOCK_NUMBER,super.getMinStockNumber(),minStockNumber);
			super.setMinStockNumber(minStockNumber);
			return this;
		}
		
		/**
		 * 设置 备注
		 * @param notes 备注
		 * @return 当前对象
		*/
		public Product setNotes(String notes) {
			super.change(NOTES,super.getNotes(),notes);
			super.setNotes(notes);
			return this;
		}
		
		/**
		 * 设置 创建人ID
		 * @param createBy 创建人ID
		 * @return 当前对象
		*/
		public Product setCreateBy(String createBy) {
			super.change(CREATE_BY,super.getCreateBy(),createBy);
			super.setCreateBy(createBy);
			return this;
		}
		
		/**
		 * 设置 创建时间
		 * @param createTime 创建时间
		 * @return 当前对象
		*/
		public Product setCreateTime(Date createTime) {
			super.change(CREATE_TIME,super.getCreateTime(),createTime);
			super.setCreateTime(createTime);
			return this;
		}
		
		/**
		 * 设置 修改人ID
		 * @param updateBy 修改人ID
		 * @return 当前对象
		*/
		public Product setUpdateBy(String updateBy) {
			super.change(UPDATE_BY,super.getUpdateBy(),updateBy);
			super.setUpdateBy(updateBy);
			return this;
		}
		
		/**
		 * 设置 修改时间
		 * @param updateTime 修改时间
		 * @return 当前对象
		*/
		public Product setUpdateTime(Date updateTime) {
			super.change(UPDATE_TIME,super.getUpdateTime(),updateTime);
			super.setUpdateTime(updateTime);
			return this;
		}
		
		/**
		 * 设置 是否已删除
		 * @param deleted 是否已删除
		 * @return 当前对象
		*/
		public Product setDeleted(Integer deleted) {
			super.change(DELETED,super.getDeleted(),deleted);
			super.setDeleted(deleted);
			return this;
		}
		
		/**
		 * 设置 删除人ID
		 * @param deleteBy 删除人ID
		 * @return 当前对象
		*/
		public Product setDeleteBy(String deleteBy) {
			super.change(DELETE_BY,super.getDeleteBy(),deleteBy);
			super.setDeleteBy(deleteBy);
			return this;
		}
		
		/**
		 * 设置 删除时间
		 * @param deleteTime 删除时间
		 * @return 当前对象
		*/
		public Product setDeleteTime(Date deleteTime) {
			super.change(DELETE_TIME,super.getDeleteTime(),deleteTime);
			super.setDeleteTime(deleteTime);
			return this;
		}
		
		/**
		 * 设置 数据版本号
		 * @param version 数据版本号
		 * @return 当前对象
		*/
		public Product setVersion(Integer version) {
			super.change(VERSION,super.getVersion(),version);
			super.setVersion(version);
			return this;
		}
		
		/**
		 * 设置 租户
		 * @param tenantId 租户
		 * @return 当前对象
		*/
		public Product setTenantId(String tenantId) {
			super.change(TENANT_ID,super.getTenantId(),tenantId);
			super.setTenantId(tenantId);
			return this;
		}
		
		/**
		 * 设置 productAttr
		 * @param productAttrList productAttr
		 * @return 当前对象
		*/
		public Product setProductAttrList(List<ProductAttr> productAttrList) {
			super.change(PRODUCT_ATTR_LIST,super.getProductAttrList(),productAttrList);
			super.setProductAttrList(productAttrList);
			return this;
		}
		
		/**
		 * 设置 productAttrIds
		 * @param productAttrIds productAttrIds
		 * @return 当前对象
		*/
		public Product setProductAttrIds(List<String> productAttrIds) {
			super.change(PRODUCT_ATTR_IDS,super.getProductAttrIds(),productAttrIds);
			super.setProductAttrIds(productAttrIds);
			return this;
		}
		
		/**
		 * 设置 customer
		 * @param customer customer
		 * @return 当前对象
		*/
		public Product setCustomer(Customer customer) {
			super.change(CUSTOMER,super.getCustomer(),customer);
			super.setCustomer(customer);
			return this;
		}
		
		/**
		 * 设置 UnitData
		 * @param unitData UnitData
		 * @return 当前对象
		*/
		public Product setUnitData(Unit unitData) {
			super.change(UNIT_DATA,super.getUnitData(),unitData);
			super.setUnitData(unitData);
			return this;
		}
		
		/**
		 * 设置 productCategory
		 * @param productCategory productCategory
		 * @return 当前对象
		*/
		public Product setProductCategory(ProductCategory productCategory) {
			super.change(PRODUCT_CATEGORY,super.getProductCategory(),productCategory);
			super.setProductCategory(productCategory);
			return this;
		}

		/**
		 * 克隆当前对象
		*/
		@Transient
		public Product clone() {
			return duplicate(true);
		}

		/**
		 * 复制当前对象
		 * @param all 是否复制全部属性，当 false 时，仅复制来自数据表的属性
		*/
		@Transient
		public Product duplicate(boolean all) {
			$$proxy$$ inst=new $$proxy$$();
			inst.setProductModel(this.getProductModel());
			inst.setCode(this.getCode());
			inst.setNotes(this.getNotes());
			inst.setKeepDate(this.getKeepDate());
			inst.setProductBrand(this.getProductBrand());
			inst.setProductSku(this.getProductSku());
			inst.setUpdateBy(this.getUpdateBy());
			inst.setCustId(this.getCustId());
			inst.setEnName(this.getEnName());
			inst.setId(this.getId());
			inst.setHeight(this.getHeight());
			inst.setCustProductCode(this.getCustProductCode());
			inst.setPeriod(this.getPeriod());
			inst.setLength(this.getLength());
			inst.setMinStockNumber(this.getMinStockNumber());
			inst.setUpdateTime(this.getUpdateTime());
			inst.setMaxWeight(this.getMaxWeight());
			inst.setVersion(this.getVersion());
			inst.setMaxVolume(this.getMaxVolume());
			inst.setBarCode(this.getBarCode());
			inst.setUnit(this.getUnit());
			inst.setCreateBy(this.getCreateBy());
			inst.setDeleted(this.getDeleted());
			inst.setCreateTime(this.getCreateTime());
			inst.setDeleteTime(this.getDeleteTime());
			inst.setName(this.getName());
			inst.setWidth(this.getWidth());
			inst.setTenantId(this.getTenantId());
			inst.setDeleteBy(this.getDeleteBy());
			inst.setCategory(this.getCategory());
			if(all) {
				inst.setProductAttrIds(this.getProductAttrIds());
				inst.setUnitData(this.getUnitData());
				inst.setProductAttrList(this.getProductAttrList());
				inst.setCustomer(this.getCustomer());
				inst.setProductCategory(this.getProductCategory());
			}
			inst.clearModifies();
			return inst;
		}

	}
}