package com.dt.platform.constants.enums.eam;

import com.dt.platform.constants.enums.common.CodeModuleEnum;
import com.github.foxnic.api.constant.CodeTextEnum;

public enum AssetOperateEnum implements CodeTextEnum {

    //资产
    EAM_ASSET_INSERT("eam_asset_insert" , "EAM_资产登记"),
    EAM_ASSET_IMPORT("eam_asset_import" , "EAM_资产导入"),
    EAM_BATCH_UPLOAD_ASSET("eam_batch_upload_asset" , "EAM_资产批量导入"),
    EAM_ASSET_STORAGE(CodeModuleEnum.EAM_ASSET_STORAGE.code(), CodeModuleEnum.EAM_ASSET_STORAGE.text()),

    //员工审批
    EAM_ASSET_EMPLOYEE_APPLY(CodeModuleEnum.EAM_ASSET_EMPLOYEE_APPLY.code(), CodeModuleEnum.EAM_ASSET_EMPLOYEE_APPLY.text()),
    EAM_ASSET_EMPLOYEE_HANDOVER(CodeModuleEnum.EAM_ASSET_EMPLOYEE_HANDOVER.code() , CodeModuleEnum.EAM_ASSET_EMPLOYEE_HANDOVER.text()),
    EAM_ASSET_EMPLOYEE_LOSS(CodeModuleEnum.EAM_ASSET_EMPLOYEE_LOSS.code(), CodeModuleEnum.EAM_ASSET_EMPLOYEE_LOSS.text()),
    EAM_ASSET_EMPLOYEE_REPAIR(CodeModuleEnum.EAM_ASSET_EMPLOYEE_REPAIR.code(), CodeModuleEnum.EAM_ASSET_EMPLOYEE_REPAIR.text()),


    //软件资产
    EAM_ASSET_SOFTWARE_INSERT(CodeModuleEnum.EAM_ASSET_SOFTWARE_INSERT.code(), CodeModuleEnum.EAM_ASSET_SOFTWARE_INSERT.text()),
    EAM_ASSET_SOFTWARE_DISTRIBUTE(CodeModuleEnum.EAM_ASSET_SOFTWARE_DISTRIBUTE.code(), CodeModuleEnum.EAM_ASSET_SOFTWARE_DISTRIBUTE.text()),
    EAM_ASSET_SOFTWARE_CHANGE(CodeModuleEnum.EAM_ASSET_SOFTWARE_CHANGE.code(), CodeModuleEnum.EAM_ASSET_SOFTWARE_CHANGE.text()),
    EAM_ASSET_SOFTWARE_MAINTENANCE(CodeModuleEnum.EAM_ASSET_SOFTWARE_MAINTENANCE.code(), CodeModuleEnum.EAM_ASSET_SOFTWARE_MAINTENANCE.text()),



    //资产单据
    EAM_ASSET_COLLECTION(CodeModuleEnum.EAM_ASSET_COLLECTION.code(), CodeModuleEnum.EAM_ASSET_COLLECTION.text()),
    EAM_ASSET_COLLECTION_RETURN(CodeModuleEnum.EAM_ASSET_COLLECTION_RETURN.code(), CodeModuleEnum.EAM_ASSET_COLLECTION_RETURN.text()),
    EAM_ASSET_BORROW(CodeModuleEnum.EAM_ASSET_BORROW.code(), CodeModuleEnum.EAM_ASSET_BORROW.text()),
    EAM_ASSET_BORROW_RETURN(CodeModuleEnum.EAM_ASSET_BORROW_RETURN.code(), CodeModuleEnum.EAM_ASSET_BORROW_RETURN.text()),
    EAM_ASSET_REPAIR(CodeModuleEnum.EAM_ASSET_REPAIR.code(), CodeModuleEnum.EAM_ASSET_REPAIR.text()),
    EAM_ASSET_REPAIR_ORDER(CodeModuleEnum.EAM_ASSET_REPAIR_ORDER.code(), CodeModuleEnum.EAM_ASSET_REPAIR_ORDER.text()),
    EAM_ASSET_REPAIR_ORDER_ACT(CodeModuleEnum.EAM_ASSET_REPAIR_ORDER_ACT.code(), CodeModuleEnum.EAM_ASSET_REPAIR_ORDER_ACT.text()),
    EAM_ASSET_REPAIR_ORDER_ACCEPTANCE(CodeModuleEnum.EAM_ASSET_REPAIR_ORDER_ACCEPTANCE.code(), CodeModuleEnum.EAM_ASSET_REPAIR_ORDER_ACCEPTANCE.text()),
    EAM_ASSET_SCRAP(CodeModuleEnum.EAM_ASSET_SCRAP.code(), CodeModuleEnum.EAM_ASSET_SCRAP.text()),
    EAM_ASSET_ALLOCATE(CodeModuleEnum.EAM_ASSET_ALLOCATE.code(), CodeModuleEnum.EAM_ASSET_ALLOCATE.text()),
    EAM_ASSET_TRANFER(CodeModuleEnum.EAM_ASSET_TRANFER.code(), CodeModuleEnum.EAM_ASSET_TRANFER.text()),
    EAM_ASSET_CLEAN(CodeModuleEnum.EAM_ASSET_CLEAN.code(), CodeModuleEnum.EAM_ASSET_CLEAN.text()),
    EAM_ASSET_INVENTORY(CodeModuleEnum.EAM_ASSET_INVENTORY.code(), CodeModuleEnum.EAM_ASSET_INVENTORY.text()),
    EAM_ASSET_CUST_INSPECT(CodeModuleEnum.EAM_ASSET_CUST_INSPECT.code(), CodeModuleEnum.EAM_ASSET_CUST_INSPECT.text()),
    EAM_EQUIPMENT_FAILURE_REGISTRATION(CodeModuleEnum.EAM_EQUIPMENT_FAILURE_REGISTRATION.code(), CodeModuleEnum.EAM_EQUIPMENT_FAILURE_REGISTRATION.text()),


    EAM_ASSET_MAINTAIN_PLAN(CodeModuleEnum.EAM_ASSET_MAINTAIN_PLAN.code(), CodeModuleEnum.EAM_ASSET_MAINTAIN_PLAN.text()),
    EAM_ASSET_MAINTAIN_TASK(CodeModuleEnum.EAM_ASSET_MAINTAIN_TASK.code(), CodeModuleEnum.EAM_ASSET_MAINTAIN_TASK.text()),
    EAM_ASSET_INSPECTION_PLAN(CodeModuleEnum.EAM_ASSET_INSPECTION_PLAN.code(), CodeModuleEnum.EAM_ASSET_INSPECTION_PLAN.text()),
    EAM_ASSET_INSPECTION_TASK(CodeModuleEnum.EAM_ASSET_INSPECTION_TASK.code(), CodeModuleEnum.EAM_ASSET_INSPECTION_TASK.text()),
    EAM_ASSET_MAINTAIN_PROJECT(CodeModuleEnum.EAM_ASSET_MAINTAIN_PROJECT.code(), CodeModuleEnum.EAM_ASSET_MAINTAIN_PROJECT.text()),


    EAM_ASSET_CHANGE_BASE_INFO(CodeModuleEnum.EAM_ASSET_CHANGE_BASE_INFO.code(), CodeModuleEnum.EAM_ASSET_CHANGE_BASE_INFO.text()),
    EAM_ASSET_CHANGE_MAINTENANCE(CodeModuleEnum.EAM_ASSET_CHANGE_MAINTENANCE.code(), CodeModuleEnum.EAM_ASSET_CHANGE_MAINTENANCE.text()),
    EAM_ASSET_CHANGE_FINANCIAL(CodeModuleEnum.EAM_ASSET_CHANGE_FINANCIAL.code(), CodeModuleEnum.EAM_ASSET_CHANGE_FINANCIAL.text()),
    EAM_ASSET_CHANGE_EQUIPMENT(CodeModuleEnum.EAM_ASSET_CHANGE_EQUIPMENT.code(), CodeModuleEnum.EAM_ASSET_CHANGE_EQUIPMENT.text()),

    //维保数据变更
    EAM_ASSET_CHANGE_MAINTENANCE_2(CodeModuleEnum.EAM_ASSET_CHANGE_MAINTENANCE.code(), CodeModuleEnum.EAM_ASSET_CHANGE_MAINTENANCE.text()),




    EAM_ASSET_CONSUMABLES_STOCK_IN(CodeModuleEnum.EAM_ASSET_CONSUMABLES_STOCK_IN.code(), CodeModuleEnum.EAM_ASSET_CONSUMABLES_STOCK_IN.text()),
    EAM_ASSET_CONSUMABLES_DELIVER(CodeModuleEnum.EAM_ASSET_CONSUMABLES_DELIVER.code(), CodeModuleEnum.EAM_ASSET_CONSUMABLES_DELIVER.text()),
    EAM_ASSET_CONSUMABLES_COLLECTION(CodeModuleEnum.EAM_ASSET_CONSUMABLES_COLLECTION.code(), CodeModuleEnum.EAM_ASSET_CONSUMABLES_COLLECTION.text()),
    EAM_ASSET_CONSUMABLES_TRANFER(CodeModuleEnum.EAM_ASSET_CONSUMABLES_TRANFER.code(), CodeModuleEnum.EAM_ASSET_CONSUMABLES_TRANFER.text()),



    EAM_ASSET_STOCK_DELIVER(CodeModuleEnum.EAM_ASSET_STOCK_DELIVER.code(), CodeModuleEnum.EAM_ASSET_STOCK_DELIVER.text()),
    EAM_ASSET_STOCK_IN(CodeModuleEnum.EAM_ASSET_STOCK_IN.code(), CodeModuleEnum.EAM_ASSET_STOCK_IN.text()),
    EAM_ASSET_STOCK_ALLOCATE(CodeModuleEnum.EAM_ASSET_STOCK_ALLOCATE.code(), CodeModuleEnum.EAM_ASSET_STOCK_ALLOCATE.text()),
    EAM_ASSET_STOCK_DISTRIBUTE(CodeModuleEnum.EAM_ASSET_STOCK_DISTRIBUTE.code(), CodeModuleEnum.EAM_ASSET_STOCK_DISTRIBUTE.text()),
    EAM_ASSET_STOCK_INVENTORY(CodeModuleEnum.EAM_ASSET_STOCK_INVENTORY.code(), CodeModuleEnum.EAM_ASSET_STOCK_INVENTORY.text()),






    //物品库存
    EAM_ASSET_STOCK_GOODS_IN(CodeModuleEnum.EAM_ASSET_STOCK_GOODS_IN.code(), CodeModuleEnum.EAM_ASSET_STOCK_GOODS_IN.text()),
    EAM_ASSET_STOCK_GOODS_OUT(CodeModuleEnum.EAM_ASSET_STOCK_GOODS_OUT.code(), CodeModuleEnum.EAM_ASSET_STOCK_GOODS_OUT.text()),
    EAM_ASSET_STOCK_GOODS_TRANFER(CodeModuleEnum.EAM_ASSET_STOCK_GOODS_TRANFER.code(), CodeModuleEnum.EAM_ASSET_STOCK_GOODS_TRANFER.text()),
    EAM_ASSET_STOCK_GOODS_ADJUST(CodeModuleEnum.EAM_ASSET_STOCK_GOODS_ADJUST.code(), CodeModuleEnum.EAM_ASSET_STOCK_GOODS_ADJUST.text()),
    EAM_ASSET_STOCK_GOODS_INVENTORY(CodeModuleEnum.EAM_ASSET_STOCK_GOODS_INVENTORY.code(), CodeModuleEnum.EAM_ASSET_STOCK_GOODS_INVENTORY.text()),



    EAM_ASSET_PART_GOODS_IN(CodeModuleEnum.EAM_ASSET_PART_GOODS_IN.code(), CodeModuleEnum.EAM_ASSET_PART_GOODS_IN.text()),
    EAM_ASSET_PART_GOODS_OUT(CodeModuleEnum.EAM_ASSET_PART_GOODS_OUT.code(), CodeModuleEnum.EAM_ASSET_PART_GOODS_OUT.text()),
    EAM_ASSET_PART_GOODS_TRANFER(CodeModuleEnum.EAM_ASSET_PART_GOODS_TRANFER.code(), CodeModuleEnum.EAM_ASSET_PART_GOODS_TRANFER.text()),
    EAM_ASSET_PART_GOODS_ADJUST(CodeModuleEnum.EAM_ASSET_PART_GOODS_ADJUST.code(), CodeModuleEnum.EAM_ASSET_PART_GOODS_ADJUST.text()),




    //物品耗材
//    EAM_ASSET_CONSUMABLES_GOODS(CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS.code(), "EAM_资产物品库存入库"),
    EAM_ASSET_CONSUMABLES_GOODS_IN(CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_IN.code(), CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_IN.text()),
    EAM_ASSET_CONSUMABLES_GOODS_OUT(CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_OUT.code(), CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_OUT.text()),
    EAM_ASSET_CONSUMABLES_GOODS_TRANFER(CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_TRANFER.code(), CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_TRANFER.text()),
    EAM_ASSET_CONSUMABLES_GOODS_ADJUST(CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_ADJUST.code(), CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_ADJUST.text()),
    EAM_ASSET_CONSUMABLES_GOODS_INVENTORY(CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_INVENTORY.code(), CodeModuleEnum.EAM_ASSET_CONSUMABLES_GOODS_INVENTORY.text()),


    //采购
    EAM_ASSET_PURCHASE_CHECK(CodeModuleEnum.EAM_ASSET_PURCHASE_CHECK.code(), CodeModuleEnum.EAM_ASSET_PURCHASE_CHECK.text()),
    EAM_ASSET_PURCHASE_APPLY(CodeModuleEnum.EAM_ASSET_PURCHASE_APPLY.code(), CodeModuleEnum.EAM_ASSET_PURCHASE_APPLY.text()),
    EAM_ASSET_PURCHASE_ORDER(CodeModuleEnum.EAM_ASSET_PURCHASE_ORDER.code(), CodeModuleEnum.EAM_ASSET_PURCHASE_ORDER.text()),

    //资产折旧
    EAM_ASSET_DEPRECIATION_OPER(CodeModuleEnum.EAM_ASSET_DEPRECIATION_OPER.code(), CodeModuleEnum.EAM_ASSET_DEPRECIATION_OPER.text()),

    EAM_DOWNLOAD_ASSET_SOFTWARE_INSERT_BILL("eam_download_asset_software_insert_bill" , "EAM_资产软件登记下载"),
    EAM_DOWNLOAD_ASSET_SOFTWARE_DISTRIBUTE_BILL("eam_download_asset_software_distribute_bill" , "EAM_资产软件分发下载"),
    EAM_DOWNLOAD_ASSET_SOFTWARE_CHANGE_BILL("eam_download_asset_software_change_bill" , "EAM_资产软件变更下载"),
    EAM_DOWNLOAD_ASSET_SOFTWARE_MAINTENANCE_BILL("eam_download_asset_software_maintenance_bill" , "EAM_资产软件维保下载"),


    EAM_ASSET_DOWNLOAD_DEPRECIATION_REPORT("eam_asset_download_depreciation_report", "资产折旧报表"),


    //单据下载
    EAM_DOWNLOAD_ASSET("eam_download_asset", "EAM_资产数据下载"),
    EAM_DOWNLOAD_ASSET_STORAGE_BILL("eam_download_asset_storage_bill", "EAM_资产入库单据下载"),
    EAM_DOWNLOAD_ASSET_REGISTER_BILL("eam_download_asset_register_bill" , "EAM_资产登记单据"),
    EAM_DOWNLOAD_ASSET_CARD("eam_download_asset_card" , "EAM_资产卡片下载"),
    EAM_DOWNLOAD_ASSET_LABEl("eam_download_asset_label" , "EAM_资产标签下载"),
    EAM_DOWNLOAD_ASSET_TRANFER_BILL("eam_download_asset_tranfer_bill" , "EAM_资产转移下载"),
    EAM_DOWNLOAD_ASSET_ALLOCATE_BILL("eam_download_asset_allocate_bill" , "EAM_资产调拨下载"),
    EAM_DOWNLOAD_ASSET_COLLECTION_BILL("eam_download_asset_collection_bill" , "EAM_资产领用下载"),
    EAM_DOWNLOAD_ASSET_COLLECTION_RETURN_BILL("eam_download_asset_collection_return_bill" , "EAM_资产退库下载"),

    EAM_DOWNLOAD_ASSET_BORROW_BILL("eam_download_asset_borrow_bill" , "EAM_资产借用下载"),
    EAM_DOWNLOAD_ASSET_BORROW_RETURN_BILL("eam_download_asset_borrow_return_bill" , "EAM_资产借用归还下载"),
    EAM_DOWNLOAD_ASSET_REPAIR_BILL("eam_download_asset_repair_bill" , "EAM_资产报修下载"),
    EAM_DOWNLOAD_ASSET_REPAIR_ORDER_BILL("eam_download_asset_repair_order_bill" , "EAM_资产维修工单下载"),
    EAM_DOWNLOAD_ASSET_SCRAP_BILL("eam_download_asset_scrap_bill" , "EAM_资产报废下载"),

    EAM_DOWNLOAD_ASSET_INVENTORY_BILL("eam_download_asset_inventory_bill" , "EAM_资产盘点单据下载"),
    EAM_DOWNLOAD_ASSET_INVENTORY_ASSET("eam_download_asset_inventory_asset" , "EAM_资产盘点资产下载"),

    //库存
    EAM_DOWNLOAD_ASSET_STOCK_GOODS_IN_BILL2("eam_download_asset_stock_goods_in_bill2" , "EAM_资产物品库存入库单下载"),
    EAM_DOWNLOAD_ASSET_STOCK_GOODS_OUT_BILL2("eam_download_asset_stock_goods_out_bill2" , "EAM_资产物品库存出库单下载"),

    //库存
    EAM_DOWNLOAD_ASSET_STOCK_GOODS_IN_BILL("eam_download_asset_stock_goods_in_bill" , "EAM_资产物品库存入库单下载"),
    EAM_DOWNLOAD_ASSET_STOCK_GOODS_OUT_BILL("eam_download_asset_stock_goods_out_bill" , "EAM_资产物品库存出库单下载"),
    EAM_DOWNLOAD_ASSET_STOCK_GOODS_TRANFER_BILL("eam_download_asset_stock_goods_tranfer_bill" , "EAM_资产物品库存转移单下载"),
    EAM_DOWNLOAD_ASSET_STOCK_GOODS_ADJUST_BILL("eam_download_asset_stock_goods_adjust_bill" , "EAM_资产物品库存调整单下载"),

    //备件
    EAM_DOWNLOAD_ASSET_PART_GOODS_IN_BILL("eam_download_asset_part_goods_in_bill" , "EAM_资产备件库存入库单下载"),
    EAM_DOWNLOAD_ASSET_PART_GOODS_OUT_BILL("eam_download_asset_part_goods_out_bill" , "EAM_资产备件库存出库单下载"),
    EAM_DOWNLOAD_ASSET_PART_GOODS_TRANFER_BILL("eam_download_asset_part_goods_tranfer_bill" , "EAM_资产备件库存转移单下载"),
    EAM_DOWNLOAD_ASSET_PART_GOODS_ADJUST_BILL("eam_download_asset_part_goods_adjust_bill" , "EAM_资产备件库存调整单下载"),



    //耗材
    EAM_DOWNLOAD_ASSET_CONSUMABLES_GOODS_IN_BILL("eam_download_asset_consumables_goods_in_bill" , "EAM_耗材库存入库单下载"),
    EAM_DOWNLOAD_ASSET_CONSUMABLES_GOODS_OUT_BILL("eam_download_asset_consumables_goods_out_bill" , "EAM_耗材库存出库单下载"),
    EAM_DOWNLOAD_ASSET_CONSUMABLES_GOODS_TRANFER_BILL("eam_download_asset_consumables_goods_tranfer_bill" , "EAM_资产物品库存转移单下载"),
    EAM_DOWNLOAD_ASSET_CONSUMABLES_GOODS_ADJUST_BILL("eam_download_asset_consumables_goods_adjust_bill" , "EAM_资产物品库存调整单下载"),

    EAM_ASSET_DATA_SYNC("eam_asset_data_sync" , "EAM_资产数据同步");


    private String code;
    private String text;
    private AssetOperateEnum(String code, String text)  {
        this.code=code;
        this.text=text;
    }

    public String code() {
        return code;
    }

    public String text() {
        return text;
    }


}
