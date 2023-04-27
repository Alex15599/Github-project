CREATE TABLE `eam_inventory_feedback` (
                                          `id` varchar(50) NOT NULL COMMENT '主键',
                                          `inventory_id` varchar(50) DEFAULT NULL COMMENT '盘点',
                                          `status` varchar(50) DEFAULT NULL COMMENT '状态',
                                          `user_id` varchar(50) DEFAULT NULL COMMENT '用户',
                                          `content` varchar(1000) DEFAULT NULL COMMENT '内容',
                                          `picture_id` varchar(300) DEFAULT NULL COMMENT '照片',
                                          `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                          `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                          `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                          `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                          `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                          `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                          `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                          `version` int(11) NOT NULL DEFAULT '1' COMMENT '数据版本号',
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='盘点反馈';


CREATE TABLE `eam_inventory_feedback_msg` (
                                              `id` varchar(50) NOT NULL COMMENT '主键',
                                              `feedback_id` varchar(50) DEFAULT NULL COMMENT '反馈',
                                              `user_id` varchar(50) DEFAULT NULL COMMENT '用户',
                                              `record_time` datetime DEFAULT NULL COMMENT '时间',
                                              `content` varchar(1000) DEFAULT NULL COMMENT '内容',
                                              `picture_id` varchar(300) DEFAULT NULL COMMENT '照片',
                                              `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                              `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                              `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                              `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                              `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                              `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                              `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                              `version` int(11) NOT NULL DEFAULT '1' COMMENT '数据版本号',
                                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='反馈消息';
