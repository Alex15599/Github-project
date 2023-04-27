
CREATE TABLE `sys_auto_user_predefined` (
                                            `id` varchar(18) NOT NULL COMMENT '主键',
                                            `account` varchar(50) DEFAULT NULL COMMENT '用户',
                                            `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                            `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                            `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                            `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                            `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                            `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                            `version` int(11) NOT NULL DEFAULT '1' COMMENT '数据版本号',
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='预定义用户';
INSERT INTO `sys_auto_user_predefined` (`id`, `account`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('1', 'admin', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('2', 'opsadmin', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('3', 'opsuser', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('4', 'opsquery', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('5', 'knadmin', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('6', 'knuser', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('7', 'eamadmin', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('8', 'eamuser', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1),
('9', 'eamquery', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1);

