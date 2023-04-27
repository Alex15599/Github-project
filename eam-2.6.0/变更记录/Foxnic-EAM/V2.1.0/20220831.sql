-- 用户自动赋权配置表
CREATE TABLE `sys_auto_role_grant_rcd` (
                                           `id` varchar(18) NOT NULL COMMENT '主键',
                                           `module_role_id` varchar(50) DEFAULT NULL COMMENT '模块',
                                           `role_id` varchar(50) DEFAULT NULL COMMENT '角色',
                                           `user_id` varchar(50) DEFAULT NULL COMMENT '用户',
                                           `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                           `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                           `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                           `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                           `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                           `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                           `version` int(11) NOT NULL DEFAULT '1' COMMENT '数据版本号',
                                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='自动赋权';


CREATE TABLE `sys_auto_module_role` (
                                        `id` varchar(18) NOT NULL COMMENT '主键',
                                        `name` varchar(100) DEFAULT NULL COMMENT '名称',
                                        `status` varchar(50) DEFAULT NULL COMMENT '状态',
                                        `module` varchar(50) DEFAULT NULL COMMENT '模块',
                                        `type` varchar(50) DEFAULT NULL COMMENT '类型,role|data_role|busi_role',
                                        `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                        `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                        `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                        `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                        `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                        `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                        `version` int(11) NOT NULL DEFAULT '1' COMMENT '数据版本号',
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='模块角色';


CREATE TABLE `sys_auto_module_role_item` (
                                             `id` varchar(18) NOT NULL COMMENT '主键',
                                             `module_role_id` varchar(50) DEFAULT NULL COMMENT '模块',
                                             `role_id` varchar(50) DEFAULT NULL COMMENT '角色',
                                             `role_name` varchar(50) DEFAULT NULL COMMENT '名称',
                                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                             `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                             `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                             `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                             `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                             `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                             `version` int(11) NOT NULL DEFAULT '1' COMMENT '数据版本号',
                                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='模块角色明细';


INSERT INTO `sys_auto_module_role` (`id`, `name`, `status`, `module`, `type`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('eam_data_role', '资产系统-用户自动配置数据角色', 'enable', 'eam', 'busi_role', NULL, NULL, NULL, 0, NULL, NULL, 1),
('eam_role', '资产系统-用户自动配置功能角色', 'enable', 'eam', 'role', NULL, NULL, NULL, 0, NULL, NULL, 1);


INSERT INTO `sys_auto_module_role_item` (`id`, `module_role_id`, `role_id`, `role_name`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('1', 'eam_role', '505736820663779328', '固定资产员工', NULL, NULL, NULL, 0, NULL, NULL, 1),
('2', 'eam_role', '617103797986000896', '基础通用角色', NULL, NULL, NULL, 0, NULL, NULL, 1),
('3', 'eam_role', '617293164289458176', '流程使用角色', NULL, NULL, NULL, 0, NULL, NULL, 1),
('5', 'eam_data_role', '612283690805886976', '资产数据权限默认', NULL, NULL, NULL, 0, NULL, NULL, 1);


INSERT INTO `sys_role` (`id`, `code`, `name`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('617293164289458176', 'bpm_user', '流程使用角色', '', '2022-08-31 09:42:39', '', NULL, 0, '', NULL, 1);




