-- eam_manufacturer,eam_maintainer
alter table eam_manufacturer add column code varchar(50) after manufacturer_name;
alter table eam_maintainer add column code varchar(50) after maintainer_name;

-- eam_position
drop table eam_position_bak;
create table eam_position_bak as select * from eam_position;
drop table eam_position;
CREATE TABLE `eam_position` (
                                `id` varchar(50) NOT NULL COMMENT '主键',
                                `code` varchar(50) DEFAULT NULL COMMENT '编码',
                                `name` varchar(500) DEFAULT NULL COMMENT '名称',
                                `status` varchar(50) DEFAULT 'enable' COMMENT '状态',
                                `parent_id` varchar(50) DEFAULT NULL COMMENT '父节点',
                                `hierarchy` varchar(1000) DEFAULT NULL COMMENT '节点路径',
                                `hierarchy_name` varchar(1000) DEFAULT NULL COMMENT '节点路径名称',
                                `sort` int(11) DEFAULT '0' COMMENT '排序',
                                `notes` varchar(500) DEFAULT NULL COMMENT '备注',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='存放位置';
insert into eam_position(id,name,notes,tenant_id,parent_id,hierarchy,hierarchy_name) select id,name,notes,tenant_id,'0' parent_id,id,name from eam_position_bak where deleted=0;

-- eam_asset_rack,eam_asset_rack_info
CREATE TABLE `eam_asset_rack` (
                                  `id` varchar(50) NOT NULL COMMENT '主键',
                                  `code` varchar(50) DEFAULT NULL COMMENT '编码',
                                  `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                  `type` varchar(50) DEFAULT 'loc' COMMENT '类型',
                                  `status` varchar(50) DEFAULT NULL COMMENT '状态',
                                  `rack_id` varchar(50) DEFAULT NULL COMMENT '机柜',
                                  `parent_id` varchar(50) DEFAULT NULL COMMENT '父节点',
                                  `hierarchy` varchar(1000) DEFAULT NULL COMMENT '节点路径',
                                  `hierarchy_name` varchar(1000) DEFAULT NULL COMMENT '节点路径名称',
                                  `sort` int(11) DEFAULT '0' COMMENT '排序',
                                  `notes` varchar(500) DEFAULT NULL COMMENT '备注',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备机柜';
CREATE TABLE `eam_asset_rack_info` (
                                       `id` varchar(50) NOT NULL COMMENT '主键',
                                       `rack_code` varchar(100) DEFAULT NULL COMMENT '编码',
                                       `rack_type` varchar(100) DEFAULT NULL COMMENT '类型',
                                       `rack_name` varchar(100) DEFAULT NULL COMMENT '名称',
                                       `status` varchar(50) DEFAULT NULL COMMENT '状态',
                                       `environment` varchar(50) DEFAULT NULL COMMENT '环境',
                                       `rack_used_type` varchar(100) DEFAULT NULL COMMENT '使用分类',
                                       `rack_captical` decimal(10,2) DEFAULT '50.00' COMMENT '容量',
                                       `u_postion_number` int(5) DEFAULT NULL COMMENT 'U位数量',
                                       `pdu_number` int(5) DEFAULT '0' COMMENT 'PDU数量',
                                       `jumper_number` int(5) DEFAULT '0' COMMENT '跳线数',
                                       `contract_power` int(5) DEFAULT '0' COMMENT '合同电力',
                                       `equipment_number` int(5) DEFAULT '0' COMMENT '设备数量',
                                       `expire_date` date DEFAULT NULL COMMENT '到期日期',
                                       `rack_label1` varchar(500) DEFAULT NULL COMMENT '标签1',
                                       `rack_label2` varchar(500) DEFAULT NULL COMMENT '标签2',
                                       `rack_notes` varchar(500) DEFAULT NULL COMMENT '备注',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='机柜';

-- eam_asset_scrap
alter table eam_asset_scrap add column method varchar(50) after name;

-- dict
INSERT INTO `sys_dict` (`id`, `is_tree`, `name`, `code`, `module`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('616176710315933696', 0, '资产报废方式', 'eam_scrap_method', 'eam', '', '110588348101165911', '2022-08-28 07:46:16', NULL, NULL, 0, NULL, NULL, 1);
INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `valid`)
VALUES
('616177173685862400', '616176710315933696', 'eam_scrap_method', '', 'damage', '损坏', 3, '110588348101165911', '2022-08-28 07:48:06', '110588348101165911', '2022-08-28 07:48:08', 0, NULL, NULL, 2, 1),
('616177035840061440', '616176710315933696', 'eam_scrap_method', '', 'expire', '过期', 2, '110588348101165911', '2022-08-28 07:47:33', NULL, NULL, 0, NULL, NULL, 1, 1),
('616176839584382976', '616176710315933696', 'eam_scrap_method', '', 'loss', '丢失', 1, '110588348101165911', '2022-08-28 07:46:47', NULL, NULL, 0, NULL, NULL, 1, 1);
