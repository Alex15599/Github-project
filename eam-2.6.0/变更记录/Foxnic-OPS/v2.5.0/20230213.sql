CREATE TABLE `ops_db_env_info` (
                                   `id` varchar(50) NOT NULL COMMENT '主键',
                                   `label` varchar(50) DEFAULT NULL COMMENT '标签',
                                   `db_inst_id` varchar(50) DEFAULT NULL COMMENT '数据库',
                                   `ip` varchar(50) DEFAULT NULL COMMENT 'IP',
                                   `voucher` varchar(800) DEFAULT NULL COMMENT '凭证',
                                   `notes` varchar(800) DEFAULT NULL COMMENT '备注',
                                   `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                   `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                   `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                   `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                   `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                   `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                   `version` int(11) NOT NULL DEFAULT '1',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='数据库环境';

