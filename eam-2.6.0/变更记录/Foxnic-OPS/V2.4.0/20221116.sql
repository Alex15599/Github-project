CREATE TABLE `ops_db_info_label` (
                                     `id` varchar(50) NOT NULL COMMENT '主键',
                                     `db_id` varchar(50) DEFAULT NULL COMMENT '数据库',
                                     `label` varchar(50) DEFAULT NULL COMMENT '标签',
                                     `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                     `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                     `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                     `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                     `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                     `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                     `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                     `version` int(11) NOT NULL DEFAULT '1',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据库标签';

INSERT INTO `sys_dict` (`id`, `is_tree`, `name`, `code`, `module`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('645162833780146176', 0, '数据库标签', 'ops_db_label', '472036556115279872', '', '110588348101165911', '2022-11-16 07:26:46', NULL, NULL, 0, NULL, NULL, 1);

INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `valid`)
VALUES
('645162985697837056', '645162833780146176', 'ops_db_label', '', 'gch', '国产化', 1, '110588348101165911', '2022-11-16 07:27:22', NULL, NULL, 0, NULL, NULL, 1, 1);
