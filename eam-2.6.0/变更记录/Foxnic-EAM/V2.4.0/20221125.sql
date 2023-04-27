ALTER TABLE eam_asset_depreciation_oper ADD COLUMN `depreciation_code` VARCHAR(50) NULL COMMENT '' AFTER `business_code`;
ALTER TABLE eam_asset ADD COLUMN `depreciation_id` VARCHAR(50) NULL COMMENT '' AFTER `asset_used_service_life`;
ALTER TABLE eam_asset ADD COLUMN `depreciation_oper_time` datetime NULL COMMENT '' AFTER `depreciation_id`;
ALTER TABLE eam_category_finance ADD COLUMN `service_life` decimal(10,2) default 36.00 COMMENT '' AFTER `category_code`;
update eam_category_finance set service_life=36;


-- 折旧
CREATE TABLE `eam_asset_depreciation_status` (
                                                 `id` varchar(50) NOT NULL COMMENT '主键',
                                                 `depreciation_id` varchar(50) DEFAULT NULL COMMENT '折旧方案',
                                                 asset_status varchar(50) NOT NULL COMMENT '资产状态',
                                                 `create_by` varchar(18) NOT NULL COMMENT '创建人ID',
                                                 `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                                 `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                                 `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                                 `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                                 `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                                 `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                                 `version` int(11) NOT NULL DEFAULT '1',
                                                 `tenant_id` varchar(18) DEFAULT NULL COMMENT '租户',
                                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资产状态';


drop table eam_asset_depreciation_detail;
CREATE TABLE `eam_asset_depreciation_detail` (
                                                 `id` varchar(50) NOT NULL COMMENT '主键',
                                                 `depreciation_id` varchar(50) DEFAULT NULL COMMENT '折旧方案',
                                                 `oper_id` varchar(50) DEFAULT NULL COMMENT '折旧操作',
                                                 `action_code` varchar(50) DEFAULT NULL COMMENT '折旧动作',
                                                 `first_depreciation_method` varchar(50) DEFAULT NULL COMMENT '首次折旧方式',
                                                 `depreciation_method` varchar(50) DEFAULT NULL COMMENT '折旧方式',
                                                 `business_date` date DEFAULT NULL COMMENT '业务日期',
                                                 `result` varchar(50) DEFAULT NULL COMMENT '折旧结果',
                                                 `result_detail` varchar(500) DEFAULT NULL COMMENT '折旧结果明细',
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
                                                 `asset_service_life` decimal(10,2) DEFAULT NULL COMMENT '可使用期限,月',
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

CREATE TABLE `eam_asset_depreciation_cal_rule` (
                                                   `id` varchar(50) NOT NULL COMMENT '主键',
                                                   `depreciation_id` varchar(50) DEFAULT NULL COMMENT '折旧方案',
                                                   `status` varchar(50) DEFAULT NULL COMMENT '状态',
                                                   `action_code` varchar(50) DEFAULT NULL COMMENT '动作',
                                                   `rule_number` int(11) DEFAULT '0' COMMENT '规则编号',
                                                   `column_value` varchar(50) DEFAULT NULL COMMENT '字段值',
                                                   `column_name` varchar(50) DEFAULT NULL COMMENT '字段名称',
                                                   `calculation_type` varchar(50) DEFAULT NULL COMMENT '计算类型',
                                                   `method_content` varchar(500) DEFAULT NULL COMMENT '计算方法',
                                                   `method_content_info` varchar(500) DEFAULT NULL COMMENT '方法描述',
                                                   `return_type` varchar(50) DEFAULT NULL COMMENT '返回类型',
                                                   `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                                   `create_by` varchar(18) NOT NULL COMMENT '创建人ID',
                                                   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                                   `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                                   `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                                   `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                                   `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                                   `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                                   `version` int(11) NOT NULL DEFAULT '1',
                                                   `tenant_id` varchar(18) DEFAULT NULL COMMENT '租户',
                                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='计算方法';


drop table eam_asset_depreciation;
CREATE TABLE `eam_asset_depreciation` (
                                          `id` varchar(50) NOT NULL COMMENT '主键',
                                          `status` varchar(50) DEFAULT NULL COMMENT '状态',
                                          `code` varchar(50) DEFAULT NULL COMMENT '编码',
                                          `name` varchar(100) DEFAULT NULL COMMENT '折旧方案',
                                          `method` varchar(100) DEFAULT NULL COMMENT '折旧方式',
                                          `pre_residual_rate` decimal(10,2) DEFAULT '0.00' COMMENT '预计残值率',
                                          `residual_value_select` varchar(50) DEFAULT NULL COMMENT '残值选择',
                                          `first_depreciation_method` varchar(50) DEFAULT NULL COMMENT '首次折旧方式',
                                          `own_company_id` varchar(50) DEFAULT NULL COMMENT '所属公司',
                                          `category_id` varchar(1000) DEFAULT NULL COMMENT '资产分类',
                                          `selected_code` varchar(50) DEFAULT NULL COMMENT '选择',
                                          `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                          `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                          `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                          `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                          `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                          `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                          `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                          `version` int(11) NOT NULL DEFAULT '1',
                                          `tenant_id` varchar(18) DEFAULT NULL COMMENT '租户',
                                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='折旧方案';


drop table eam_asset_depreciation_exclude;
CREATE TABLE `eam_asset_depreciation_exclude` (
                                                  `id` varchar(50) NOT NULL COMMENT '主键',
                                                  `asset_id` varchar(100) DEFAULT NULL COMMENT '资产',
                                                  `depreciation_id` varchar(50) DEFAULT NULL COMMENT '折旧方案',
                                                  `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                                  `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                                  `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                                  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                                  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                                  `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                                  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                                  `version` int(11) NOT NULL DEFAULT '1',
                                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='折旧排除';

-- insert eam_asset_depreciation
INSERT INTO `eam_asset_depreciation` (`id`, `status`, `code`, `name`, `method`, `pre_residual_rate`, `residual_value_select`, `first_depreciation_method`, `own_company_id`, `category_id`, `selected_code`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `tenant_id`)
VALUES
('647736203386290176', 'enable', 'monthly', '按月折旧', 'average_age', 5.00, 'follow_asset', 'register_next_month', NULL, NULL, NULL, '', '110588348101165911', '2022-11-23 09:52:25', '110588348101165911', '2022-11-27 08:59:35', 0, NULL, NULL, 9, 'T001');

-- insert
INSERT INTO `eam_asset_depreciation_cal_rule` (`id`, `depreciation_id`, `status`, `rule_number`, `column_value`, `column_name`, `calculation_type`, `method_content`, `method_content_info`, `return_type`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `tenant_id`)
VALUES
('14', '647736203386290176', 'enable', 0, 'asset_original_unit_price', '未税成本', 'not_null', '', '先决条件，不能为空', 'boolean', '', '', NULL, '110588348101165911', '2022-11-26 16:45:58', 0, NULL, NULL, 2, 'T001'),
('16', '647736203386290176', 'enable', 0, 'asset_residuals_rate', '残值率', 'not_null', '', '先决条件，不能为空', 'boolean', '', '', NULL, '110588348101165911', '2022-11-26 16:45:29', 0, NULL, NULL, 3, 'T001'),
('17', '647736203386290176', 'enable', 0, 'asset_register_date', '入账日期', 'not_null', '', '先决条件，不能为空', 'boolean', '', '', NULL, '110588348101165911', '2022-11-26 16:45:24', 0, NULL, NULL, 2, 'T001'),
('18', '647736203386290176', 'enable', 0, 'business_date', '启用日期', 'not_null', '', '先决条件，不能为空', 'boolean', '', '', NULL, '110588348101165911', '2022-11-26 16:45:19', 0, NULL, NULL, 2, 'T001'),
('15', '647736203386290176', 'enable', 5, 'asset_service_life', '可使用期限(月)', 'not_null', '', '先决条件，不能为空', 'boolean', '', '', NULL, '110588348101165911', '2022-11-27 08:27:37', 0, NULL, NULL, 3, 'T001'),
('648928115883507712', '647736203386290176', 'enable', 10, 'first_depreciation', '先决条件,是否首次折旧', 'jexl_expression', 'commonFunction:equalMonth(asset.businessDate,asset.assetRegisterDate)', '是否首次折旧', 'string', '', '110588348101165911', '2022-11-26 16:48:39', '110588348101165911', '2022-11-26 17:05:39', 0, NULL, NULL, 5, 'T001'),
('648953946617937920', '647736203386290176', 'disable', 11, 'asset_nav_price', '上一期净值', 'not_null', '', '先决条件，不能为空', 'boolean', '', '110588348101165911', '2022-11-26 18:31:18', '110588348101165911', '2022-11-27 08:39:50', 0, NULL, NULL, 4, 'T001'),
('19', '647736203386290176', 'enable', 30, 'accounting_service_life', '会计期间所在的年份间已使用的月数', 'jexl_expression', 'commonFunction:usedLifeByAccountingPeriod(asset.assetRegisterDate,asset.businessDate)', '先决条件，不能为空', 'double', '', '', NULL, '110588348101165911', '2022-11-27 07:26:26', 0, NULL, NULL, 7, 'T001'),
('649169462397763584', '647736203386290176', 'enable', 90, 'c_used_service_life', '已使用期限(月)', 'jexl_expression', 'commonFunction:subtractMonth(asset.businessDate,asset.assetRegisterDate)', '', 'double', '', '110588348101165911', '2022-11-27 08:47:41', '110588348101165911', '2022-11-27 09:01:12', 0, NULL, NULL, 7, 'T001'),
('2', '647736203386290176', 'enable', 100, 'c_used_service_life', '已使用期限(月)', 'not_null', '', '先决条件，不能为空', 'boolean', '', '', NULL, '110588348101165911', '2022-11-26 16:45:10', 0, NULL, NULL, 2, 'T001'),
('13', '647736203386290176', 'enable', 200, 'asset_residuals_price', '残值', 'jexl_expression', '(asset.assetOriginalUnitPrice*asset.assetResidualsRate)/100', '残值=未税成本*残值率', 'double', '', '', NULL, '110588348101165911', '2022-11-27 08:43:18', 0, NULL, NULL, 4, 'T001'),
('1', '647736203386290176', 'enable', 300, 's_original_price', '(期初)期初原值', 'jexl_expression', 'asset.assetOriginalUnitPrice', '(期初)期初原值=上一期期末原值', 'double', '', '', NULL, '110588348101165911', '2022-11-27 08:37:08', 0, NULL, NULL, 4, 'T001'),
('4', '647736203386290176', 'enable', 400, 'c_depreciation_amount', '(本期发生)本期折旧额', 'jexl_expression', '(asset.assetOriginalUnitPrice-asset.assetResidualsPrice)/asset.assetServiceLife', '(本期发生)本期折旧额=(未税成本-残值)*可使用月数', 'double', '', '', NULL, '110588348101165911', '2022-11-27 09:03:22', 0, NULL, NULL, 6, 'T001'),
('10', '647736203386290176', 'enable', 500, 's_depreciation_amount', '(期初)期初累计折旧', 'jexl_expression', 'asset.cDepreciationAmount*(asset.cUsedServiceLife-1)', '(期初)期初累计折旧=(本期发生)本期折旧额*(已使用期限(月)-1)', 'double', '', '', NULL, '110588348101165911', '2022-11-26 16:46:21', 0, NULL, NULL, 2, 'T001'),
('11', '647736203386290176', 'enable', 600, 's_nav_amount', '(期初)期初净值', 'jexl_expression', 'asset.sOriginalPrice-asset.sDepreciationAmount', '(期初)期初净值=(期初)期初原值-(期初)期初累计折旧', 'double', '', '', NULL, '110588348101165911', '2022-11-26 16:46:25', 0, NULL, NULL, 2, 'T001'),
('12', '647736203386290176', 'enable', 700, 's_recoverable_amount', '(期初)期初可回收净额', 'jexl_expression', 'asset.sNavAmount', '(期初)期初可回收净额=(期初)期初净值', 'double', '', '', NULL, '110588348101165911', '2022-11-26 16:46:28', 0, NULL, NULL, 2, 'T001'),
('3', '647736203386290176', 'enable', 800, 'c_original_price_increase', '(本期发生)原值增加', 'jexl_expression', '0', '已确认不会有增加 ', 'double', '', '', NULL, '110588348101165911', '2022-11-26 16:45:04', 0, NULL, NULL, 3, 'T001'),
('5', '647736203386290176', 'enable', 900, 'c_year_depreciation_amount', '(本期发生)本年累计折旧额', 'jexl_expression', 'asset.cDepreciationAmount*asset.accountingServiceLife', '(本期发生)本年累计折旧额=(本期发生)本期折旧额*会计期间所在的年份间已使用的月数', 'double', '', '', NULL, '110588348101165911', '2022-11-26 16:44:56', 0, NULL, NULL, 3, 'T001'),
('6', '647736203386290176', 'enable', 1000, 'e_original_price', '(期末)期末原值', 'jexl_expression', 'asset.sOriginalPrice+asset.cOriginalPriceIncrease', '(期初)期初原值+(本期发生)原值增加', 'double', '', '', NULL, '110588348101165911', '2022-11-26 16:44:51', 0, NULL, NULL, 3, 'T001'),
('7', '647736203386290176', 'enable', 1100, 'e_depreciation_amount', '(期末)期末累计折旧', 'jexl_expression', 'asset.sDepreciationAmount+asset.cDepreciationAmount', '(期末)期末累计折旧=(期初)期初累计折旧+(本期发生)本期折旧额', 'double', '', '', NULL, '110588348101165911', '2022-11-27 08:41:40', 0, NULL, NULL, 4, 'T001'),
('8', '647736203386290176', 'enable', 1200, 'e_nav_amount', '(期末)期末净值', 'jexl_expression', 'asset.eOriginalPrice-asset.eDepreciationAmount', '(期末)期末净值=(期末)期末原值-(期末)期末累计折旧', 'double', '', '', NULL, '110588348101165911', '2022-11-27 08:39:27', 0, NULL, NULL, 4, 'T001'),
('9', '647736203386290176', 'enable', 1300, 'e_recoverable_amount', '(期末)期末可回收金额', 'jexl_expression', 'asset.eNavAmount', '(期末)期末可回收金额=(期末)期末净值', 'double', '', '', NULL, '110588348101165911', '2022-11-26 16:43:11', 0, NULL, NULL, 3, 'T001');
