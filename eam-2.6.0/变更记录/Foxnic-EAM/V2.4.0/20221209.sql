INSERT INTO `sys_menu` (`id`, `batch_id`, `authority`, `hidden`, `css`, `label`, `type`, `path_resource_id`, `url`, `params`, `parent_id`, `dynamic_handler`, `hierarchy`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `notes`)
VALUES
('653631024370024448', '', 'eam_inventory_asset:asset-add', 0, '', '新增资产', 'function', '', '', '', '482573207753195520', '', 'eam/471985681850171393/482573207753195520/653631024370024448', 999999, '110588348101165911', '2022-12-09 16:16:20', '110588348101165911', '2022-12-09 16:16:46', 0, NULL, NULL, 3, '');

INSERT INTO `sys_resourze` (`id`, `name`, `type`, `access_type`, `url`, `method`, `batch_id`, `create_by`, `table_name`, `module`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('653631892507066368', '盘点资产确认', 'api', 'LOGIN', '/service-eam/eam-inventory/query-asset-by-inventory', 'POST', '', '110588348101165911', '', '', '2022-12-09 16:19:47', NULL, NULL, 0, NULL, NULL, 1);

INSERT INTO `sys_config` (`id`, `profile_id`, `catalog_code`, `code`, `name`, `type`, `type_desc`, `value`, `valid`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('eam.assetServiceLifeValueSource', 'default', 'eam', 'eam.assetServiceLifeValueSource', '资产可使用期限来源', 'STRING', '', 'finance', 1, 'asset,finance ,财务计算使用', NULL, NULL, '110588348101165911', '2021-11-22 10:10:52', 0, '', NULL, 2);


INSERT INTO `sys_resourze` (`id`, `name`, `type`, `access_type`, `url`, `method`, `batch_id`, `create_by`, `table_name`, `module`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('654352614833520640', '盘点新增资产', 'api', 'LOGIN', '/service-eam/eam-inventory/asset-add-data', 'POST', '', '110588348101165911', '', '', '2022-12-11 16:03:41', NULL, NULL, 0, NULL, NULL, 1);


INSERT INTO `sys_busi_role` (`id`, `org_id`, `code`, `name`, `valid`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `notes`)
VALUES
('654353803348279296', NULL, 'employ_inventory_manag_role', '全员盘点管理角色', 1, '110588348101165911', '2022-12-11 16:08:24', NULL, NULL, 0, NULL, NULL, 1, '');


drop table eam_asset_depreciation_detail;
CREATE TABLE `eam_asset_depreciation_detail` (
                                                 `id` varchar(50) NOT NULL COMMENT '主键',
                                                 `depreciation_id` varchar(50) DEFAULT NULL COMMENT '折旧方案',
                                                 `oper_id` varchar(50) DEFAULT NULL COMMENT '折旧操作',
                                                 `action_code` varchar(50) DEFAULT NULL COMMENT '折旧动作',
                                                 `first_depreciation_method` varchar(50) DEFAULT NULL COMMENT '首次折旧方式',
                                                 `depreciation_method` varchar(50) DEFAULT NULL COMMENT '折旧方式',
                                                 `business_date` date DEFAULT NULL COMMENT '业务日期',
                                                 `result` varchar(50) DEFAULT NULL COMMENT '折旧规则',
                                                 `result_status` varchar(50) DEFAULT 'not_calculated' COMMENT '折旧结果',
                                                 `result_detail` varchar(500) DEFAULT NULL COMMENT '结果明细',
                                                 `asset_id` varchar(50) DEFAULT NULL COMMENT '资产',
                                                 `asset_category_id` varchar(50) DEFAULT NULL COMMENT '资产类别',
                                                 `asset_category_name` varchar(500) DEFAULT NULL COMMENT '资产类别',
                                                 `asset_finance_category_id` varchar(50) DEFAULT NULL COMMENT '财务分类',
                                                 `asset_finance_category_name` varchar(500) DEFAULT NULL COMMENT '财务分类',
                                                 `asset_code` varchar(50) DEFAULT NULL COMMENT '资产编码',
                                                 `asset_name` varchar(50) DEFAULT NULL COMMENT '资产名称',
                                                 `asset_model` varchar(500) DEFAULT NULL COMMENT '资产型号',
                                                 `asset_status_name` varchar(50) DEFAULT NULL COMMENT '资产状态',
                                                 `asset_purchase_date` date DEFAULT NULL COMMENT '采购日期',
                                                 `asset_register_date` date DEFAULT NULL COMMENT '入账日期',
                                                 `asset_original_unit_price` decimal(10,2) DEFAULT NULL COMMENT '资产原值',
                                                 `asset_purchase_unit_price` decimal(10,2) DEFAULT NULL COMMENT '含税单价',
                                                 `asset_nav_price` decimal(10,2) DEFAULT NULL COMMENT '资产净值,(当前)',
                                                 `asset_tax_amount_rate` decimal(10,2) DEFAULT NULL COMMENT '税额',
                                                 `asset_service_life` decimal(10,2) DEFAULT NULL COMMENT '可使用期限(资产),月',
                                                 `asset_finance_service_life` decimal(10,2) DEFAULT NULL COMMENT '可使用期限(财务),月',
                                                 `asset_residuals_rate` decimal(10,2) DEFAULT NULL COMMENT '本期残值率',
                                                 `asset_residuals_price` decimal(10,2) DEFAULT NULL COMMENT '本期残值',
                                                 `s_original_price` decimal(10,2) DEFAULT NULL COMMENT '(期初)期初原值',
                                                 `s_depreciation_amount` decimal(10,2) DEFAULT NULL COMMENT '(期初)期初累计折旧',
                                                 `s_nav_amount` decimal(10,2) DEFAULT NULL COMMENT '(期初)期初净值',
                                                 `s_recoverable_amount` decimal(10,2) DEFAULT NULL COMMENT '(期初)期初可回收净额',
                                                 `c_used_service_life` decimal(10,2) DEFAULT NULL COMMENT '已使用期限,月',
                                                 `c_original_price_increase` decimal(10,2) DEFAULT NULL COMMENT '(本期发生)原值增加',
                                                 `c_depreciation_amount` decimal(10,2) DEFAULT NULL COMMENT '(本期发生)本期折旧额',
                                                 `c_year_depreciation_amount` decimal(10,2) DEFAULT NULL COMMENT '(本期发生)本年累计折旧额',
                                                 `e_original_price` decimal(10,2) DEFAULT NULL COMMENT '(期末)期末原值',
                                                 `e_depreciation_amount` decimal(10,2) DEFAULT NULL COMMENT '(期末)期末累计折旧',
                                                 `e_nav_amount` decimal(10,2) DEFAULT NULL COMMENT '(期末)期末净值',
                                                 `e_recoverable_amount` decimal(10,2) DEFAULT NULL COMMENT '(期末)期末可回收金额',
                                                 `accounting_service_life` decimal(10,2) DEFAULT NULL COMMENT '会计期间已使用期限,月',
                                                 `first_depreciation` varchar(10) DEFAULT NULL COMMENT '首次折旧,0否,1是',
                                                 `use_user_id` varchar(50) DEFAULT NULL COMMENT '使用人ID',
                                                 `use_user_name` varchar(50) DEFAULT NULL COMMENT '使用人',
                                                 `manager_id` varchar(50) DEFAULT NULL COMMENT '管理人员',
                                                 `manager_name` varchar(50) DEFAULT NULL COMMENT '管理人员',
                                                 `use_org_id` varchar(50) DEFAULT NULL COMMENT '部门ID',
                                                 `use_org_name` varchar(50) DEFAULT NULL COMMENT '使用部门',
                                                 `financial_option_key` varchar(50) DEFAULT NULL COMMENT '财务选项KEY',
                                                 `expense_item_key` varchar(50) DEFAULT NULL COMMENT '费用项目KEY',
                                                 `financial_option_name` varchar(50) DEFAULT NULL COMMENT '财务选项',
                                                 `expense_item_name` varchar(50) DEFAULT NULL COMMENT '费用项目',
                                                 `customer_info` varchar(200) DEFAULT NULL COMMENT '客户情况',
                                                 `detail_id_source` varchar(50) DEFAULT NULL COMMENT '源资产',
                                                 `detail_id_target` varchar(50) DEFAULT NULL COMMENT '目标资产',
                                                 `last_oper_id` varchar(50) DEFAULT NULL COMMENT '上次折旧单据',
                                                 `last_oper_time` datetime DEFAULT NULL COMMENT '上次折旧时间',
                                                 `label` varchar(500) DEFAULT NULL COMMENT '标签',
                                                 `create_by` varchar(18) NOT NULL COMMENT '创建人ID',
                                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                                 `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                                 `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                                 `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                                 `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                                 `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                                 `version` int(11) NOT NULL DEFAULT '1',
                                                 `result_value_str` varchar(500) DEFAULT NULL COMMENT '结果字符串',
                                                 `result_value_float` decimal(10,2) DEFAULT NULL COMMENT '结果浮点',
                                                 PRIMARY KEY (`id`) USING BTREE,
                                                 KEY `eam_asset_depreciation_detail_1` (`depreciation_id`),
                                                 KEY `eam_asset_depreciation_detail_2` (`oper_id`),
                                                 KEY `eam_asset_depreciation_detail_3` (`oper_id`,`result`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='折旧明细表';

drop table eam_inventory;
CREATE TABLE `eam_inventory` (
                                 `id` varchar(50) NOT NULL COMMENT '主键',
                                 `type` varchar(50) DEFAULT NULL COMMENT '类型',
                                 `business_code` varchar(50) DEFAULT NULL COMMENT '业务编码',
                                 `owner_code` varchar(50) DEFAULT NULL COMMENT '所属',
                                 `status` varchar(50) DEFAULT NULL COMMENT '业务状态',
                                 `name` varchar(50) DEFAULT NULL COMMENT '盘点名称',
                                 `inventory_status` varchar(50) DEFAULT NULL COMMENT '盘点状态',
                                 `data_status` varchar(50) DEFAULT NULL COMMENT '数据状态',
                                 `all_employee` varchar(50) DEFAULT NULL COMMENT '全员盘点',
                                 `asset_status` varchar(100) DEFAULT NULL COMMENT '资产状态',
                                 `category_id` varchar(1000) DEFAULT NULL COMMENT '资产分类',
                                 `own_company_id` varchar(1000) DEFAULT NULL COMMENT '所属公司',
                                 `use_organization_id` varchar(1000) DEFAULT NULL COMMENT '使用公司/部门',
                                 `purchase_start_date` date DEFAULT NULL COMMENT '购置开始日期',
                                 `purchase_end_date` date DEFAULT NULL COMMENT '购置结束日期',
                                 `start_time` datetime DEFAULT NULL COMMENT '盘点开始时间',
                                 `finish_time` datetime DEFAULT NULL COMMENT '盘点结束时间',
                                 `originator_id` varchar(50) DEFAULT NULL COMMENT '制单人',
                                 `business_date` date DEFAULT NULL COMMENT '业务日期',
                                 `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                 `plan_id` varchar(50) DEFAULT NULL COMMENT '计划编号',
                                 `inventory_repeat` varchar(50) DEFAULT '0' COMMENT '重复盘点,1,0',
                                 `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                 `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                 `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                 `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                 `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                 `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                 `version` int(11) NOT NULL DEFAULT '1' COMMENT '数据版本号',
                                 `tenant_id` varchar(18) DEFAULT NULL COMMENT '租户',
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资产盘点';

