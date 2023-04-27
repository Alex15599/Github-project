CREATE TABLE `sys_node_load` (
  `id` varchar(18) NOT NULL COMMENT '主键',
  `node` varchar(100) DEFAULT NULL COMMENT '节点',
  `ip` varchar(50) DEFAULT NULL COMMENT 'IP',
  `user` decimal(10,2) DEFAULT NULL COMMENT '用户使用率',
  `sys` decimal(10,2) DEFAULT NULL COMMENT '系统使用率',
  `idle` decimal(10,2) DEFAULT NULL COMMENT '空闲使用率',
  `wio` decimal(10,2) DEFAULT NULL COMMENT 'wio',
  `load1` decimal(10,2) DEFAULT NULL COMMENT 'load1',
  `load5` decimal(10,2) DEFAULT NULL COMMENT 'load5',
  `load15` decimal(10,2) DEFAULT NULL COMMENT 'load15',
  `memory_used` decimal(20,2) DEFAULT NULL COMMENT '内存使用',
  `memory_used_pct` decimal(10,2) DEFAULT NULL COMMENT '内存使用率',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
  `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '数据版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='节点负载';


CREATE TABLE `sys_backup_db` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `db_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `status` varchar(50) DEFAULT '' COMMENT '状态',
  `file_route` varchar(500) DEFAULT NULL COMMENT '备份文件',
  `file_size` decimal(10,2) DEFAULT NULL COMMENT '大小',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `invalid_time` datetime DEFAULT NULL COMMENT '失效日期',
  `content` varchar(1000) DEFAULT NULL COMMENT '内容',
  `notes` varchar(100) DEFAULT '' COMMENT '备注',
  `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
  `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `version` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='备份记录';



CREATE TABLE `sys_backup_db_strategy` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `status` varchar(50) DEFAULT NULL COMMENT '启用状态',
  `data_path` varchar(500) DEFAULT NULL COMMENT '备份路径',
  `data_keep` int(50) DEFAULT NULL COMMENT '备份保留',
  `crontab` varchar(500) DEFAULT NULL COMMENT '备份周期',
  `mail` varchar(50) DEFAULT NULL COMMENT '邮件',
  `notes` varchar(100) DEFAULT '' COMMENT '备注',
  `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
  `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `version` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='备份策略';

INSERT INTO `sys_backup_db_strategy` (`id`, `status`, `data_path`, `data_keep`, `crontab`, `mail`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
	('001', 'enable', '/app/app/backup/db', 90, NULL, NULL, '每天晚上自动备份,默认保留90天', '110588348101165911', '2023-01-26 10:54:30', '110588348101165911', '2023-01-27 16:34:17', 0, NULL, NULL, 20);



CREATE TABLE `ops_software_media` (
  `id` varchar(50) NOT NULL COMMENT '主键',
  `code` varchar(100) DEFAULT NULL COMMENT '编码',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `type` varchar(50) DEFAULT '' COMMENT '类型',
  `status` varchar(50) DEFAULT '' COMMENT '状态',
  `file_id` varchar(100) DEFAULT NULL COMMENT '文件',
  `rec_time` datetime DEFAULT NULL COMMENT '上传时间',
  `notes` varchar(100) DEFAULT '' COMMENT '备注',
  `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
  `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
  `version` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='软件介质';

INSERT INTO `sys_dict` (`id`, `is_tree`, `name`, `code`, `module`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('672189934609629184', 0, '软件介质类型', 'ops_software_media', '472036556115279872', '', '110588348101165911', '2023-01-29 21:22:49', '110588348101165911', '2023-01-29 21:23:06', 0, NULL, NULL, 2);


INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `valid`)
VALUES
('672190061067894784', '672189934609629184', 'ops_software_media', '', 'db', '数据库相关', 1, '110588348101165911', '2023-01-29 21:23:19', NULL, NULL, 0, NULL, NULL, 1, 1),
('672190121885302784', '672189934609629184', 'ops_software_media', '', 'dev', '开发相关', 2, '110588348101165911', '2023-01-29 21:23:34', NULL, NULL, 0, NULL, NULL, 1, 1),
('672213966256078848', '672189934609629184', 'ops_software_media', '', 'ops', '运维工具', 3, '110588348101165911', '2023-01-29 22:58:19', NULL, NULL, 0, NULL, NULL, 1, 1);


