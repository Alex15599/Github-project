
-- 每个box类型，一个source一条记录，insert 前会判断是否有解密权限，没有解密权限无法插入，
-- 有解密权限:可以插入，可以更新，可以查看
-- 无解密权限:查看密文
--

CREATE TABLE `ops_ciphertext_box` (
                                      `id` varchar(50) NOT NULL COMMENT '主键',
                                      `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                      `type` varchar(50) DEFAULT NULL COMMENT '类型',
                                      `encryption_key` varchar(50) DEFAULT 'box' COMMENT 'KEY',
                                      `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                      `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                      `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                      `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                      `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                      `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                      `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                      `version` int(11) NOT NULL DEFAULT '1',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='密文箱';

CREATE TABLE `ops_ciphertext_box_data` (
                                           `id` varchar(50) NOT NULL COMMENT '主键',
                                           `source_id` varchar(50) NOT NULL COMMENT '来源',
                                           `box_id` varchar(50) DEFAULT NULL COMMENT '密码箱',
                                           `box_type` varchar(50) DEFAULT NULL COMMENT '密码类型',
                                           `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                           `content` varchar(1000) DEFAULT NULL COMMENT '内容',
                                           `plaintext` varchar(1000) DEFAULT NULL COMMENT '加密',
                                           `ciphertext` varchar(1000) DEFAULT NULL COMMENT '密文',
                                           `notes` varchar(50) DEFAULT NULL COMMENT '备注',
                                           `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                           `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                           `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                           `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                           `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                           `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                           `version` int(11) NOT NULL DEFAULT '1',
                                           PRIMARY KEY (`id`) USING BTREE,
                                           UNIQUE KEY `ciphertext_box_data_id1` (`source_id`,`box_id`,`deleted`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='密文数据';

CREATE TABLE `ops_ciphertext_conf` (
                                       `id` varchar(50) NOT NULL COMMENT '主键',
                                       `box_id` varchar(50) DEFAULT NULL COMMENT '类型',
                                       `user_id` varchar(50) DEFAULT NULL COMMENT '人员',
                                       `decryption_perm_status` varchar(50) DEFAULT NULL COMMENT '解密权限',
                                       `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                       `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                       `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                       `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                       `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                       `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                       `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                       `version` int(11) NOT NULL DEFAULT '1',
                                       PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限配置';

CREATE TABLE `ops_ciphertext_history` (
                                          `id` varchar(50) NOT NULL COMMENT '主键',
                                          `type` varchar(50) DEFAULT NULL COMMENT '类型',
                                          `box_type` varchar(50) DEFAULT NULL COMMENT '密文箱类型',
                                          `source_value` varchar(50) DEFAULT NULL COMMENT '来源',
                                          `content` varchar(2000) DEFAULT NULL COMMENT '内容',
                                          `encryption_content` varchar(2500) DEFAULT NULL COMMENT '加密内容',
                                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                          `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                          `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                          `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                          `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                          `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                          `version` int(11) NOT NULL DEFAULT '1',
                                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='历史记录';

INSERT INTO `ops_ciphertext_box` (`id`, `name`, `type`, `encryption_key`, `notes`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('635126109893033985', '数据库', 'database', '635126109893033984', NULL, '2022-10-19 14:44:25', NULL, NULL, 0, NULL, NULL, 1),
('635126186522968065', '操作系统', 'operating_system', '635126186522968064', NULL, '2022-10-19 14:44:43', '110588348101165911', '2022-10-19 22:33:56', 0, NULL, NULL, 4),
('635126280857059329', '信息系统', 'information system', '635126280857059328', NULL, '2022-10-19 14:45:05', '110588348101165911', '2022-10-19 22:34:01', 0, NULL, NULL, 7),
('635394284450742272', '数据库实例', 'database_instance', '635394284228444160', NULL, '2022-10-20 08:30:02', NULL, NULL, 0, NULL, NULL, 1),
('635402909449715712', '资产', 'asset', '635402909349052416', '资产', '2022-10-20 09:04:19', NULL, NULL, 0, NULL, NULL, 1);


INSERT INTO `ops_ciphertext_conf` (`id`, `box_id`, `user_id`, `decryption_perm_status`, `notes`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('635126829329416192', '635126109893033985', 'E001', 'enable', '', '2022-10-19 14:47:16', NULL, NULL, 0, NULL, NULL, 1),
('635401491317784576', '635394284450742272', 'E001', 'enable', '', '2022-10-20 08:58:41', NULL, NULL, 0, NULL, NULL, 1),
('635403136386727936', '635402909449715712', 'E001', 'enable', '', '2022-10-20 09:05:13', NULL, NULL, 0, NULL, NULL, 1);

