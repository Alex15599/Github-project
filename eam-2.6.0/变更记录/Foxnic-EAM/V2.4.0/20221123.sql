
insert into sys_file(id,file_name,location,size,media_type,file_type)values('T001_eam_30','eam_asset_depreciation_report.xls','/tpl/T001/eam_asset_depreciation_report.xls',10000,'application/octet-stream','xls');
insert into sys_tpl_file(id,type,name,code,file_id,tenant_id)values('T001_eam_30','eam_asset_excel','资产折旧','eam_asset_depreciation_report','T001_eam_30','T001');

ALTER TABLE eam_asset ADD COLUMN `asset_used_service_life` int(11) default 0 COMMENT '' AFTER `month_depreciation_price`;
ALTER TABLE eam_asset ADD COLUMN `financial_option` VARCHAR(50) NULL COMMENT '' AFTER `financial_code`;
ALTER TABLE eam_asset ADD COLUMN `expense_item` VARCHAR(50) NULL COMMENT '' AFTER `financial_option`;
ALTER TABLE eam_asset ADD COLUMN `customer_info` VARCHAR(200) NULL COMMENT '' AFTER `supplier_id`;


ALTER TABLE eam_asset modify `entry_time` date;

INSERT INTO `sys_dict` (`id`, `is_tree`, `name`, `code`, `module`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('647778649096847360', 0, '财务费用项目', 'eam_expense_items', 'eam', '', '110588348101165911', '2022-11-23 12:41:05', NULL, NULL, 0, NULL, NULL, 1);

INSERT INTO `sys_dict` (`id`, `is_tree`, `name`, `code`, `module`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('647778562429943808', 0, '财务选项', 'eam_financial_options', 'eam', '', '110588348101165911', '2022-11-23 12:40:44', NULL, NULL, 0, NULL, NULL, 1);

INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `valid`)
VALUES
('647779267416948736', '647778562429943808', 'eam_financial_options', '', 'front', '前台', 1, '110588348101165911', '2022-11-23 12:43:33', NULL, NULL, 0, NULL, NULL, 1, 1),
('647779299109109760', '647778562429943808', 'eam_financial_options', '', 'back', '后台', 2, '110588348101165911', '2022-11-23 12:43:40', NULL, NULL, 0, NULL, NULL, 1, 1);


INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `valid`)
VALUES
('647779614747262976', '647778649096847360', 'eam_expense_items', '', 'manage', '固定资产-管理费用', 1, '110588348101165911', '2022-11-23 12:44:55', NULL, NULL, 0, NULL, NULL, 1, 1),
('647779749506056192', '647778649096847360', 'eam_expense_items', '', 'sale', '固定资产-销售费用', 2, '110588348101165911', '2022-11-23 12:45:27', NULL, NULL, 0, NULL, NULL, 1, 1),
('647779816610725888', '647778649096847360', 'eam_expense_items', '', 'development', '固定资产-研发费用', 3, '110588348101165911', '2022-11-23 12:45:43', NULL, NULL, 0, NULL, NULL, 1, 1),
('647779935850594304', '647778649096847360', 'eam_expense_items', '', 'main_business', '固定资产-主营业务成本', 4, '110588348101165911', '2022-11-23 12:46:12', NULL, NULL, 0, NULL, NULL, 1, 1);


--
ALTER TABLE eam_asset_depreciation ADD COLUMN `code` VARCHAR(50) NULL COMMENT '' AFTER `status`;
