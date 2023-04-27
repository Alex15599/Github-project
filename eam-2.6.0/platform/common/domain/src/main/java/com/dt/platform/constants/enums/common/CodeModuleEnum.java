package com.dt.platform.constants.enums.common;

import com.github.foxnic.api.constant.CodeTextEnum;


/**
 * @since 20210724 10:25:37
 * @author 金杰 , maillank@qq.com
 * 从 select code,name from sys_dict WHERE deleted=0 and module in ('eam','hrm') 生成
 * 此文件由工具自动生成，请勿修改。若表结构变动，请使用工具重新生成
*/


public enum CodeModuleEnum implements CodeTextEnum {

	COMMON_CODE("common_code" , "通用编码"),


	EAM_ASSET_STORAGE("eam_asset_storage" , "EAM_资产入库"),
	EAM_ASSET_CODE("eam_asset_code" , "EAM_资产编码"),
	EAM_ASSET_SOFTWARE_CODE("eam_asset_software_code" , "EAM_软件资产编码"),
	EAM_ASSET_STOCK_CODE("eam_asset_stock_code" , "EAM_资产库存编码"),
	EAM_ASSET_CONSUMABLES_CODE("eam_asset_consumables_code" , "EAM_资产耗材编码"),

	EAM_ASSET_EMPLOYEE_APPLY("eam_asset_employee_apply" , "EAM_员工领用申请"),
	EAM_ASSET_EMPLOYEE_HANDOVER("eam_asset_employee_handover" , "EAM_员工资产交接"),
	EAM_ASSET_EMPLOYEE_LOSS("eam_asset_employee_loss" , "EAM_员工资产报失"),
	EAM_ASSET_EMPLOYEE_REPAIR("eam_asset_employee_repair" , "EAM_员工资产报修"),



	//软件资产
	EAM_ASSET_SOFTWARE_INSERT("eam_asset_software_insert" , "EAM_资产软件登记"),
	EAM_ASSET_SOFTWARE_CHANGE("eam_asset_software_change" , "EAM_资产软件变更"),
	EAM_ASSET_SOFTWARE_MAINTENANCE("eam_asset_software_maintenance" , "EAM_资产软件维保"),
	EAM_ASSET_SOFTWARE_DISTRIBUTE("eam_asset_software_distribute" , "EAM_资产软件分发"),


	//资产单据
	EAM_ASSET_COLLECTION("eam_asset_collection" , "EAM_资产单据领用"),
	EAM_ASSET_COLLECTION_RETURN("eam_asset_collection_return" , "EAM_资产单据退库"),
	EAM_ASSET_BORROW("eam_asset_borrow" , "EAM_资产单据借用"),
	EAM_ASSET_BORROW_RETURN("eam_asset_borrow_return" , "EAM_资产单据借用归还"),
	EAM_ASSET_REPAIR("eam_asset_repair" , "EAM_资产单据报修"),
	EAM_ASSET_REPAIR_ORDER("eam_asset_repair_order" , "EAM_资产单据故障报修申请"),
	EAM_ASSET_REPAIR_ORDER_ACT("eam_asset_repair_order_act" , "EAM_资产单据维修工单"),
	EAM_ASSET_REPAIR_ORDER_ACCEPTANCE("eam_asset_repair_order_acceptance" , "EAM_资产单据维修验收"),
	EAM_ASSET_SCRAP("eam_asset_scrap" , "EAM_资产单据报废"),
	EAM_ASSET_ALLOCATE("eam_asset_allocate" , "EAM_资产单据调拨"),
	EAM_ASSET_TRANFER("eam_asset_tranfer" , "EAM_资产单据转移"),
	EAM_ASSET_CLEAN("eam_asset_clean" , "EAM_资产单据清理"),
	EAM_ASSET_INVENTORY("eam_asset_inventory" , "EAM_资产数据盘点"),

	EAM_EQUIPMENT_FAILURE_REGISTRATION("eam_equipment_failure_registration" , "EAM_设备故障登记"),

	EAM_ASSET_CUST_INSPECT("eam_asset_cust_inspect" , "EAM_设备巡检"),


	EAM_ASSET_MAINTAIN_PLAN("eam_asset_maintain_plan" , "EAM_资产保养方案"),
	EAM_ASSET_MAINTAIN_PROJECT("eam_asset_maintain_project" , "EAM_资产保养项目"),
	EAM_ASSET_MAINTAIN_TASK("eam_asset_maintain_task" , "EAM_资产保养任务"),
	EAM_ASSET_INSPECTION_PLAN("eam_asset_inspection_plan" , "EAM_巡检方案"),
	EAM_ASSET_INSPECTION_TASK("eam_asset_inspection_task" , "EAM_巡检任务"),




	//库存
	EAM_ASSET_STOCK_IN("eam_asset_stock_in" , "EAM_资产库存入库"),
	EAM_ASSET_STOCK_DELIVER("eam_asset_stock_deliver" , "EAM_资产库存出库"),
	EAM_ASSET_STOCK_ALLOCATE("eam_asset_stock_allocate" , "EAM_资产库存调拨"),
	EAM_ASSET_STOCK_DISTRIBUTE("eam_asset_stock_distribute" , "EAMi_资产库存分配"),
	EAM_ASSET_STOCK_INVENTORY("eam_asset_stock_inventory" , "EAM_资产库存盘点"),

	//物品库存
//	EAM_ASSET_STOCK_GOODS("eam_asset_stock_goods" , "EAM_库存物品入库"),
	EAM_ASSET_STOCK_GOODS_IN("eam_asset_stock_goods_in" , "EAM_库存物品入库"),
	EAM_ASSET_STOCK_GOODS_OUT("eam_asset_stock_goods_out" , "EAM_库存物品出库"),
	EAM_ASSET_STOCK_GOODS_TRANFER("eam_asset_stock_goods_tranfer" , "EAM_库存物品转移"),
	EAM_ASSET_STOCK_GOODS_ADJUST("eam_asset_stock_goods_adjust" , "EAM_库存物品调整"),
	EAM_ASSET_STOCK_GOODS_INVENTORY("eam_asset_stock_goods_inventory" , "EAM_库存物品盘点"),

	//物品耗材
//	EAM_ASSET_CONSUMABLES_GOODS("eam_asset_consumables_goods" , "EAM_耗材物品入库"),
	EAM_ASSET_CONSUMABLES_GOODS_IN("eam_asset_consumables_goods_in" , "EAM_耗材物品入库"),
	EAM_ASSET_CONSUMABLES_GOODS_OUT("eam_asset_consumables_goods_out" , "EAM_耗材物品出库"),
	EAM_ASSET_CONSUMABLES_GOODS_TRANFER("eam_asset_consumables_goods_tranfer" , "EAM_耗材物品转移"),
	EAM_ASSET_CONSUMABLES_GOODS_ADJUST("eam_asset_consumables_goods_adjust" , "EAM_耗材物品调整"),
	EAM_ASSET_CONSUMABLES_GOODS_INVENTORY("eam_asset_consumables_goods_inventory" , "EAM_耗材物品盘点"),

	//备件
	EAM_ASSET_PART_GOODS_IN("eam_asset_part_goods_in" , "EAM_备件物品入库"),
	EAM_ASSET_PART_GOODS_OUT("eam_asset_part_goods_out" , "EAM_备件物品出库"),
	EAM_ASSET_PART_GOODS_TRANFER("eam_asset_part_goods_tranfer" , "EAM_备件物品转移"),
	EAM_ASSET_PART_GOODS_ADJUST("eam_asset_part_goods_adjust" , "EAM_备件物品调整"),

	//耗材
	EAM_ASSET_CONSUMABLES_STOCK_IN("eam_asset_consumables_stock_in" , "EAM_资产耗材单据入库"),
	EAM_ASSET_CONSUMABLES_DELIVER("eam_asset_consumables_deliver" , "EAM_资产耗材单据出库"),
	EAM_ASSET_CONSUMABLES_COLLECTION("eam_asset_consumables_collection" , "EAM_资产耗材单据领用"),
	EAM_ASSET_CONSUMABLES_TRANFER("eam_asset_consumables_tranfer" , "EAM_资产耗材单据转移"),
	EAM_ASSET_CONSUMABLES_ALLOCATE("eam_asset_consumables_allocate" , "EAM_资产耗材单据调拨"),


	//变更
	EAM_ASSET_CHANGE_BASE_INFO("eam_asset_change_base_info" , "EAM_资产变更基本"),
	EAM_ASSET_CHANGE_MAINTENANCE("eam_asset_change_maintenance" , "EAM_资产变更维保"),
	EAM_ASSET_CHANGE_FINANCIAL("eam_asset_change_financial" , "EAM_资产变更财务"),
	EAM_ASSET_CHANGE_EQUIPMENT("eam_asset_change_equipment" , "EAM_资产变更设备"),



	VEHICLE_APPLY("vehicle_apply" , "申请领用"),
	VEHICLE_MAINTENANCE("vehicle_maintenance" , "报修保险"),



	EAM_ASSET_PURCHASE_CHECK("eam_asset_purchase_check" , "EAM_资产采购验收"),
	EAM_ASSET_PURCHASE_APPLY("eam_asset_purchase_apply" , "EAM_资产采购申请"),
	EAM_ASSET_PURCHASE_ORDER("eam_asset_purchase_order" , "EAM_资产采购订单"),


	EAM_ASSET_DEPRECIATION_OPER("eam_asset_depreciation_oper" , "EAM_资产折旧");


	private String code;
	private String text;
	private CodeModuleEnum(String code, String text)  {
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