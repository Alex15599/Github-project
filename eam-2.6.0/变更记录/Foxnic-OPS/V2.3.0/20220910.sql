
INSERT INTO `sys_dict` (`id`, `is_tree`, `name`, `code`, `module`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('620878341703991296', 0, '服务分类标签', 'ops_service_category_label', '472036556115279872', '', '110588348101165911', '2022-09-10 07:08:52', NULL, NULL, 0, NULL, NULL, 1);

INSERT INTO `sys_dict` (`id`, `is_tree`, `name`, `code`, `module`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('621812235370496000', 0, '数据库部署模式', 'ops_db_deploy_mode', '472036556115279872', '', '110588348101165911', '2022-09-12 20:59:50', NULL, NULL, 0, NULL, NULL, 1);




alter table ops_service_category add column label_code varchar(50) after name;
INSERT INTO `sys_dict` (`id`, `is_tree`, `name`, `code`, `module`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('620878341703991296', 0, '服务分类标签', 'ops_service_category_label', '472036556115279872', '', '110588348101165911', '2022-09-10 07:08:52', NULL, NULL, 0, NULL, NULL, 1);

INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `valid`)
VALUES
('621812335056519168', '621812235370496000', 'ops_db_deploy_mode', '', 'single', '单体部署', 1, '110588348101165911', '2022-09-12 21:00:13', '110588348101165911', '2022-09-12 21:02:32', 0, NULL, NULL, 3, 1),
('621812388642947072', '621812235370496000', 'ops_db_deploy_mode', '', 'oracle_rac', 'Oracle RAC', 2, '110588348101165911', '2022-09-12 21:00:26', NULL, NULL, 0, NULL, NULL, 1, 1),
('621812638724128768', '621812235370496000', 'ops_db_deploy_mode', '', 'master_slave_m', '主从架构(主节点)', 3, '110588348101165911', '2022-09-12 21:01:26', NULL, NULL, 0, NULL, NULL, 1, 1),
('621812723415515136', '621812235370496000', 'ops_db_deploy_mode', '', 'master_slave_s', '主从架构_从节点', 2, '110588348101165911', '2022-09-12 21:01:46', NULL, NULL, 0, NULL, NULL, 1, 1),
('621812864474152960', '621812235370496000', 'ops_db_deploy_mode', '', 'oracle_dataguard_s', 'Oracle DataGuard备节点', 3, '110588348101165911', '2022-09-12 21:02:20', NULL, NULL, 0, NULL, NULL, 1, 1),
('621813045663891456', '621812235370496000', 'ops_db_deploy_mode', '', 'distributed', '分布式部署', 1, '110588348101165911', '2022-09-12 21:03:03', NULL, NULL, 0, NULL, NULL, 1, 1),
('621813434706558976', '621812235370496000', 'ops_db_deploy_mode', '', 'backup_node', '备节点', 11, '110588348101165911', '2022-09-12 21:04:36', NULL, NULL, 0, NULL, NULL, 1, 1);



INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `valid`)
VALUES
('620878615269081088', '620878341703991296', 'ops_service_category_label', '', 'xc', '信创', 1, '110588348101165911', '2022-09-10 07:09:57', NULL, NULL, 0, NULL, NULL, 1, 1),
('620878700426035200', '620878341703991296', 'ops_service_category_label', '', 'ky', '开源', 2, '110588348101165911', '2022-09-10 07:10:18', NULL, NULL, 0, NULL, NULL, 1, 1),
('620878963299844096', '620878341703991296', 'ops_service_category_label', '', 'sy', '商业(国外)', 3, '110588348101165911', '2022-09-10 07:11:20', '110588348101165911', '2022-09-10 07:11:22', 0, NULL, NULL, 2, 1);




delete from sys_dict_item  where dict_code='ops_db_log_method';
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `valid`)
VALUES
('620981073450369024', '478595190265745408', 'ops_db_log_method', '', 'no_arch', '非归档', 1, '110588348101165911', '2022-09-10 13:57:05', NULL, NULL, 0, NULL, NULL, 1, 1),
('620981131726028800', '478595190265745408', 'ops_db_log_method', '', 'arch', '归档', 2, '110588348101165911', '2022-09-10 13:57:19', NULL, NULL, 0, NULL, NULL, 1, 1);

delete from sys_dict_item  where dict_code='ops_host_backup_method';
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `valid`)
VALUES
('600050173598498816', '112', 'ops_host_backup_method', '', 'not_need', '不需要', 1, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1, 1),
('600050225649811456', '112', 'ops_host_backup_method', '', 'vmware', '虚拟机整机', 2, NULL, NULL, NULL, NULL, 0, NULL, NULL, 1, 1);




CREATE TABLE `ops_host_ex_by_host` (
                                       `id` varchar(50) NOT NULL COMMENT '主键',
                                       `host_id` varchar(50) DEFAULT NULL COMMENT '主机',
                                       `note` varchar(500) DEFAULT NULL COMMENT '备注',
                                       `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                       `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                       `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                       `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                       `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                       `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                       `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                       `version` int(11) NOT NULL DEFAULT '1',
                                       `tenant_id` varchar(18) DEFAULT NULL COMMENT '租户',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='主机排除';

CREATE TABLE `ops_host_ex_by_db` (
                                     `id` varchar(50) NOT NULL COMMENT '主键',
                                     `host_id` varchar(50) DEFAULT NULL COMMENT '主机',
                                     `note` varchar(500) DEFAULT NULL COMMENT '备注',
                                     `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                     `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                     `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                     `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                     `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                     `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                     `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                     `version` int(11) NOT NULL DEFAULT '1',
                                     `tenant_id` varchar(18) DEFAULT NULL COMMENT '租户',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据库排除';


CREATE TABLE `ops_service_category_label` (
                                              `id` varchar(50) NOT NULL COMMENT '主键',
                                              `category_id` varchar(50) DEFAULT NULL COMMENT '分类',
                                              `label_code` varchar(50) DEFAULT NULL COMMENT '标签',
                                              `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                              `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                              `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                              `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                              `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                              `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                              `tenant_id` varchar(18) DEFAULT NULL COMMENT '租户',
                                              PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='分类标签';


CREATE TABLE `ops_db_info` (
                               `id` varchar(50) NOT NULL COMMENT '主键',
                               `host_id` varchar(50) DEFAULT NULL COMMENT '主机',
                               `type_id` varchar(50) DEFAULT NULL COMMENT '数据库类型',
                               `name` varchar(200) DEFAULT NULL COMMENT '数据库名',
                               `status` varchar(50) DEFAULT NULL COMMENT '状态',
                               `backup_status` varchar(50) DEFAULT NULL COMMENT '备份状态',
                               `deploy_mode` varchar(50) DEFAULT NULL COMMENT '部署模式',
                               `backup_strategy` varchar(500) DEFAULT NULL COMMENT '备份策略',
                               `db_size` decimal(10,2) DEFAULT '0.00' COMMENT '大小(M)',
                               `log_method` varchar(50) DEFAULT NULL COMMENT '日志模式',
                               `admin_user_list` varchar(500) DEFAULT NULL COMMENT '管理员账户',
                               `app_user_list` varchar(500) DEFAULT NULL COMMENT '应用账户',
                               `other_user_list` varchar(500) DEFAULT NULL COMMENT '其他账户',
                               `voucher_str` varchar(500) DEFAULT NULL COMMENT '凭证信息',
                               `db_port` varchar(50) DEFAULT NULL COMMENT '连接端口',
                               `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                               `selected_code` varchar(50) DEFAULT NULL COMMENT '选择',
                               `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                               `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                               `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                               `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                               `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                               `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                               `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                               `version` int(11) NOT NULL DEFAULT '1',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据库';

CREATE TABLE `ops_db_backup_info` (
                                      `id` varchar(50) NOT NULL COMMENT '主键',
                                      `database_id` varchar(50) DEFAULT NULL COMMENT '数据库',
                                      `name` varchar(500) DEFAULT NULL COMMENT '名称',
                                      `status` varchar(50) DEFAULT 'online' COMMENT '状态',
                                      `backup_strategy` varchar(500) DEFAULT NULL COMMENT '备份策略',
                                      `backup_type` varchar(50) DEFAULT NULL COMMENT '备份类型',
                                      `backup_method` varchar(50) DEFAULT NULL COMMENT '备份方式',
                                      `backup_datakeep` varchar(500) DEFAULT NULL COMMENT '备份保留时长',
                                      `backup_result` varchar(50) DEFAULT NULL COMMENT '备份结果',
                                      `backup_source` varchar(50) DEFAULT NULL COMMENT '备份来源',
                                      `backup_size` decimal(8,2) DEFAULT '0.00' COMMENT '备份大小',
                                      `backup_time` datetime DEFAULT NULL COMMENT '上次备份',
                                      `backup_result_ct` varchar(2000) DEFAULT NULL COMMENT '结果内容',
                                      `storage` varchar(500) DEFAULT NULL COMMENT '存放位置',
                                      `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                      `selected_code` varchar(50) DEFAULT NULL COMMENT '选择',
                                      `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                      `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                      `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                      `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                      `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                      `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                      `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                      `version` int(11) NOT NULL DEFAULT '1',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据库备份';


CREATE TABLE `ops_db_backup_record` (
                                        `id` varchar(50) NOT NULL COMMENT '主键',
                                        `db_id` varchar(50) DEFAULT NULL COMMENT '数据库',
                                        `db_bk_id` varchar(50) DEFAULT NULL COMMENT '数据备份',
                                        `db_name` varchar(50) DEFAULT NULL COMMENT '数据库名称',
                                        `backup_result` varchar(50) DEFAULT NULL COMMENT '备份结果',
                                        `backup_source` varchar(500) DEFAULT NULL COMMENT '备份来源',
                                        `backup_result_ct` varchar(2000) DEFAULT NULL COMMENT '结果内容',
                                        `backup_stime` datetime DEFAULT NULL COMMENT '开始时间',
                                        `backup_etime` datetime DEFAULT NULL COMMENT '结束时间',
                                        `backup_size` decimal(8,2) DEFAULT '0.00' COMMENT '备份大小',
                                        `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                        `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                        `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                        `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                        `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                        `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                        `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                        `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                        `version` int(11) NOT NULL DEFAULT '1',
                                        PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


alter table ops_host alter column arch set default '0';
update ops_host set arch='0';
alter table ops_service_category add column code varchar(50) after group_id;
create unique index serviceCategoryInd on ops_service_category(code,tenant_id);



