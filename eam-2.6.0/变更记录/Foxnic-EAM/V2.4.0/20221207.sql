drop table eam_asset_label;
CREATE TABLE `eam_asset_label` (
                                   `id` varchar(50) NOT NULL COMMENT '主键',
                                   `code` varchar(50) NOT NULL COMMENT '编码',
                                   `font_type` varchar(100) DEFAULT NULL COMMENT '字体',
                                   `font_path` varchar(100) DEFAULT NULL COMMENT '字体路径',
                                   `label_tpl_id` varchar(50) DEFAULT NULL COMMENT '标签',
                                   `label_width` decimal(10,2) DEFAULT '8.00' COMMENT '标签宽度(cm)',
                                   `label_height` decimal(10,2) DEFAULT '6.00' COMMENT '标签高度(cm)',
                                   `label_layout` varchar(50) DEFAULT 'center' COMMENT '标签布局(暂时不用)',
                                   `label_table_margin` decimal(10,2) DEFAULT '2.00' COMMENT '标签间隔',
                                   `label_table_margin_top` decimal(10,2) DEFAULT '0.00' COMMENT '表格marginTop(mm)',
                                   `label_table_margin_bottom` decimal(10,2) DEFAULT '0.00' COMMENT '表格marginBottom(mm)',
                                   `label_table_margin_left` decimal(10,2) DEFAULT '0.00' COMMENT '表格marginLeft(mm)',
                                   `label_table_margin_right` decimal(10,2) DEFAULT '0.00' COMMENT '表格marginRight(mm)',
                                   `label_key_font_size` decimal(10,2) DEFAULT '8.00' COMMENT '字体大小(mm)',
                                   `label_key_width` decimal(10,2) DEFAULT '0.00' COMMENT 'Key宽度',
                                   `label_value_font_size` decimal(10,2) DEFAULT '8.00' COMMENT '字体大小(mm)',
                                   `image_contain_height` decimal(10,2) DEFAULT '12.00' COMMENT '专用标签_图像容器大小(mm)',
                                   `image_width` decimal(10,2) DEFAULT '10.00' COMMENT '专用标签_图形宽度',
                                   `image_height` decimal(10,2) DEFAULT '10.00' COMMENT '专用标签_图形高度',
                                   `image_margin_top` decimal(10,2) DEFAULT '1.00' COMMENT '图片marginTop',
                                   `image_margin_bottom` decimal(10,2) DEFAULT '1.00' COMMENT '图片marginBottom',
                                   `image_margin_left` decimal(10,2) DEFAULT '0.00' COMMENT '图片marginLeft',
                                   `image_margin_right` decimal(10,2) DEFAULT '0.00' COMMENT '图片marginRight',
                                   `paper_type_id` varchar(50) DEFAULT NULL COMMENT '纸张类型',
                                   `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                   `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                   `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                   `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                   `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                   `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                   `version` int(11) NOT NULL DEFAULT '1',
                                   `tenant_id` varchar(18) DEFAULT NULL COMMENT '租户',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资产标签';
INSERT INTO `eam_asset_label` (`id`, `code`, `font_type`, `font_path`, `label_tpl_id`, `label_width`, `label_height`, `label_layout`, `label_table_margin`, `label_table_margin_top`, `label_table_margin_bottom`, `label_table_margin_left`, `label_table_margin_right`, `label_key_font_size`, `label_key_width`, `label_value_font_size`, `image_contain_height`, `image_width`, `image_height`, `image_margin_top`, `image_margin_bottom`, `image_margin_left`, `image_margin_right`, `paper_type_id`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `tenant_id`)
VALUES
('1', 'T001', 'MYSH', '/app/app/bin/msyh.ttf', '650449362169626624', 8.00, 6.00, NULL, 1.00, 0.30, 0.00, 0.00, 0.00, 2.80, 15.00, 2.80, 28.00, 27.00, 27.00, 1.00, 10.00, 0.00, 0.00, '1', NULL, NULL, '110588348101165911', '2022-12-03 14:06:23', 0, NULL, NULL, 32, 'T001');

update eam_asset_label set font_path='/app/app/bin/msyh.ttf' where id='1';
-- update eam_asset_label set font_path='/Users/lankl/Documents/msyh.ttf' where id='1';
