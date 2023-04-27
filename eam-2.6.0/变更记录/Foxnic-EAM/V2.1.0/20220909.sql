INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `valid`)
VALUES
('sys_config_catalog_004', 'sys_config_catalog', 'sys_config_catalog', NULL, 'ops', '运维系统', 9999, NULL, NULL, '', NULL, 0, NULL, NULL, 1, 1),
('sys_config_catalog_003', 'sys_config_catalog', 'sys_config_catalog', NULL, 'eam', '固定资产', 9999, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1, 1);


update sys_config set catalog_code='ops' where id like 'ops%';
update sys_config set catalog_code='eam' where id like 'eam%';
update sys_config set catalog_code='system' where id like 'system%';
a