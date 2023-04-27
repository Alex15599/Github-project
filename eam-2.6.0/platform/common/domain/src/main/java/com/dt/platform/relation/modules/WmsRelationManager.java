package com.dt.platform.relation.modules;

 
import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.VehicleTables;
import com.dt.platform.constants.db.WmsTables;
import com.dt.platform.constants.db.WorkorderTables;
import com.dt.platform.domain.eam.meta.MaintainTaskProjectMeta;
import com.dt.platform.domain.vehicle.meta.InfoMeta;
import com.dt.platform.domain.wms.Storelocation;
import com.dt.platform.domain.wms.Supplier;
import com.dt.platform.domain.wms.meta.*;
import com.dt.platform.domain.workorder.meta.*;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

public class WmsRelationManager extends RelationManager {

	@Override
	protected void config() {

		this.setupStoreHouse();
		this.setupStoreHouseLoc();
		this.setupSupplier();
		this.setupCustomer();
		this.setupProduct();

	}

	public void setupProduct() {
		this.property(ProductMeta.UNIT_DATA_PROP)
				.using(WmsTables.WMS_PRODUCT.UNIT).join(WmsTables.WMS_UNIT.ID);

		this.property(ProductMeta.CUSTOMER_PROP)
				.using(WmsTables.WMS_PRODUCT.CUST_ID).join(WmsTables.WMS_CUSTOMER.ID);

		this.property(ProductMeta.PRODUCT_ATTR_LIST_PROP)
				.using(WmsTables.WMS_PRODUCT.ID).join(WmsTables.WMS_STOREHOUSE_ATTR_V.STORE_ID)
				.using(WmsTables.WMS_STOREHOUSE_ATTR_V.ATTR_ID).join(WmsTables.WMS_PRODUCT_ATTR.ID);


		this.property(ProductMeta.PRODUCT_CATEGORY_PROP)
				.using(WmsTables.WMS_PRODUCT.CATEGORY).join(WmsTables.WMS_PRODUCT_CATEGORY.ID);


	}

	public void setupCustomer() {
		this.property(CustomerMeta.COMPANY_ATTR_DATA_PROP)
				.using(WmsTables.WMS_CUSTOMER.COMPANY_ATTR).join(WmsTables.WMS_COMPANY_ATTR.ID);

	}

	public void setupSupplier() {

		this.property(SupplierMeta.GRADE_DICT_PROP)
				.using(WmsTables.WMS_SUPPLIER.GRADE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='wms_supplier_grade'");

	}


	public void setupStoreHouse() {

		this.property(StorehouseMeta.PRODUCT_ATTR_LIST_PROP)
				.using(WmsTables.WMS_STOREHOUSE.ID).join(WmsTables.WMS_STOREHOUSE_ATTR_V.STORE_ID)
			.using(WmsTables.WMS_STOREHOUSE_ATTR_V.ATTR_ID).join(WmsTables.WMS_PRODUCT_ATTR.ID);

	}

	public void setupStoreHouseLoc() {

		this.property(StorelocationMeta.PRODUCT_ATTR_LIST_PROP)
				.using(WmsTables.WMS_STORELOCATION.ID).join(WmsTables.WMS_STOREHOUSE_ATTR_V.STORE_ID)
				.using(WmsTables.WMS_STOREHOUSE_ATTR_V.ATTR_ID).join(WmsTables.WMS_PRODUCT_ATTR.ID);


		this.property(StorelocationMeta.LOC_TYPE_PROP)
				.using(WmsTables.WMS_STORELOCATION.TYPE).join(WmsTables.WMS_LOC_TYPE.ID);

		this.property(StorelocationMeta.CUSTOMER_PROP)
				.using(WmsTables.WMS_STORELOCATION.CUSTOMER_ID).join(WmsTables.WMS_CUSTOMER.ID);


		this.property(StorelocationMeta.TEMPERATURE_ATTRIBUTE_PROP)
				.using(WmsTables.WMS_STORELOCATION.LOCATION_ATTRIBUTE).join(WmsTables.WMS_TEMPERATURE_ATTRIBUTE.ID);

	}

	public void setupProperties() {

	}

	private void setupRelations() {

	}

}
