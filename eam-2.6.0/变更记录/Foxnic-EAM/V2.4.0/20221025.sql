CREATE TABLE `eam_asset_copy` (
                                  `id` varchar(64) NOT NULL COMMENT '主键',
                                  `asset_id` varchar(50) DEFAULT NULL COMMENT '资产',
                                  `asset_number` int(11) DEFAULT NULL COMMENT '复制数量',
                                  `notes` varchar(512) DEFAULT NULL COMMENT '说明',
                                  `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                  `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                  `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                  `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                  `tenant_id` varchar(18) DEFAULT NULL COMMENT '租户',
                                  `version` int(11) NOT NULL DEFAULT '1' COMMENT '数据版本号',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资产复制';

CREATE TABLE `eam_asset_copy_record` (
                                         `id` varchar(64) NOT NULL COMMENT '主键',
                                         `copy_id` varchar(50) DEFAULT NULL COMMENT '复制',
                                         `copy_asset_id` int(11) DEFAULT NULL COMMENT '资产',
                                         `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                         `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                         `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                         `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除',
                                         `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                         `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                         `tenant_id` varchar(18) DEFAULT NULL COMMENT '租户',
                                         `version` int(11) NOT NULL DEFAULT '1' COMMENT '数据版本号',
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='资产复制记录';


-- modify eam_asset
alter table eam_asset add column suggest_maintenance_method varchar(50) default null comment '建议维保方式' after maintenance_status;
alter table eam_asset add column maintenance_method varchar(50) default null comment '维保方式' after maintenance_status;
alter table eam_asset add column maintenance_price decimal(10,2) default 0.0  comment '维保价格' after maintenance_status;

-- add sys_config data
INSERT INTO `sys_config` (`id`, `profile_id`, `catalog_code`, `code`, `name`, `type`, `type_desc`, `value`, `valid`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('eam.assetCodeAutoCreate', 'default', 'eam', 'eam.assetCodeAutoCreate', '资产编码自动生成', 'ENUM', 'org.github.foxnic.web.constants.enums.system.YesNo', '1', 1, '资产编码自动生成', NULL, NULL, NULL, NULL, 0, NULL, NULL, 1);



-- add dict data
INSERT INTO `sys_dict` (`id`, `is_tree`, `name`, `code`, `module`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
	('638426144403619840', 0, '建议维保方式', 'eam_suggest_maintenance_method', 'eam', '', '110588348101165911', '2022-10-28 17:17:34', NULL, NULL, 0, NULL, NULL, 1),
	('638426183687471104', 0, '维保方式', 'eam_maintenance_method', 'eam', '', '110588348101165911', '2022-10-28 17:17:44', NULL, NULL, 0, NULL, NULL, 1);

INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `valid`)
VALUES
('638426847486410752', '638426183687471104', 'eam_maintenance_method', '', 'original_factory', '原厂', 1, '110588348101165911', '2022-10-28 17:20:22', NULL, NULL, 0, NULL, NULL, 1, 1),
('638426938729299968', '638426183687471104', 'eam_maintenance_method', '', 'third_party', '第三方', 2, '110588348101165911', '2022-10-28 17:20:44', NULL, NULL, 0, NULL, NULL, 1, 1),
('638427101254385664', '638426144403619840', 'eam_suggest_maintenance_method', '', 'original_factory', '原厂', 1, '110588348101165911', '2022-10-28 17:21:22', NULL, NULL, 0, NULL, NULL, 1, 1),
('638427138009071616', '638426144403619840', 'eam_suggest_maintenance_method', '', 'third_party', '第三方', 2, '110588348101165911', '2022-10-28 17:21:31', NULL, NULL, 0, NULL, NULL, 1, 1);


INSERT INTO `eam_asset_attribute` (`id`, `code`, `label`, `value_type`, `value_path`, `label_notes`, `dimension`, `status`, `required`, `required_modify`, `component_type`, `component_content`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `tenant_id`, `owner`)
VALUES
('638434244581916672', 'suggest_maintenance_method', '建议维保方式', 'dict', 'suggestMaintenanceMethodData,label', '', 'maintainer', 'valid', '0', '1', 'select_box', '', '', '110588348101165911', '2022-10-28 17:49:45', '110588348101165911', '2022-10-28 17:50:11', 0, NULL, NULL, 2, 'T001', 'asset'),
('638434602091806720', 'maintenance_method', '维保方式', 'dict', 'maintenanceMethodData,label', '', 'maintainer', 'valid', '0', '1', 'select_box', '', '', '110588348101165911', '2022-10-28 17:51:11', NULL, NULL, 0, NULL, NULL, 1, 'T001', 'asset');

INSERT INTO `eam_asset_attribute_item` (`id`, `owner_code`, `attribute_id`, `dimension`, `required`, `layout_type`, `list_show`, `list_content`, `list_sort`, `form_show`, `layout_row`, `layout_column`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `tenant_id`)
VALUES
('638435508103413760', 'base', '638434244581916672', 'maintainer', '0', '3', '0', '', 999, '1', 3, 3, '', '110588348101165911', '2022-10-28 17:54:47', '110588348101165911', '2022-10-28 18:41:59', 0, NULL, NULL, 2, 'T001'),
('638435683752476672', 'base', '638434602091806720', 'maintainer', '0', '3', '1', '', 999, '1', 3, 2, '', '110588348101165911', '2022-10-28 17:55:29', '110588348101165911', '2022-10-28 18:41:51', 0, NULL, NULL, 2, 'T001');


CREATE TABLE `eam_asset_maintenance_update` (
                                                `id` varchar(50) NOT NULL COMMENT '主键',
                                                `business_code` varchar(50) DEFAULT NULL COMMENT '业务编号',
                                                `handle_status` varchar(50) DEFAULT NULL COMMENT '处理状态',
                                                `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                                `reason` varchar(512) DEFAULT NULL COMMENT '原因',
                                                `content` varchar(512) DEFAULT NULL COMMENT '内容',
                                                `attach_id` varchar(500) DEFAULT NULL COMMENT '附件',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='维保更新';

CREATE TABLE `eam_asset_maintenance_record_u` (
                                                  `id` varchar(50) NOT NULL COMMENT '主键',
                                                  `maintenance_update_id` varchar(50) DEFAULT NULL COMMENT '维保更新',
                                                  `maintainer_id` varchar(50) DEFAULT NULL COMMENT '维保厂商',
                                                  `s_maintainer_id` varchar(50) DEFAULT 'disable' COMMENT '状态',
                                                  `u_maintainer_id` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `u_s_maintainer_id` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `maintainer_name` varchar(100) DEFAULT NULL COMMENT '维保厂商名称',
                                                  `s_maintainer_name` varchar(50) DEFAULT 'disable' COMMENT '状态',
                                                  `u_maintainer_name` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `u_s_maintainer_name` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `maintenance_status` varchar(50) DEFAULT NULL COMMENT '维保状态',
                                                  `s_maintenance_status` varchar(50) DEFAULT NULL COMMENT '状态',
                                                  `u_maintenance_status` varchar(50) DEFAULT 'disable' COMMENT '更新方式',
                                                  `u_s_maintenance_status` varchar(50) DEFAULT 'disable' COMMENT '更新方式',
                                                  `maintenance_method` varchar(50) DEFAULT NULL COMMENT '维保方式',
                                                  `s_maintenance_method` varchar(50) DEFAULT 'disable' COMMENT '状态',
                                                  `u_maintenance_method` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `u_s_maintenance_method` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `contact_information` varchar(100) DEFAULT NULL COMMENT '联系方式',
                                                  `s_contact_information` varchar(50) DEFAULT 'disable' COMMENT '状态',
                                                  `u_contact_information` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `u_s_contact_information` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `suggest_maintenance_method` varchar(50) DEFAULT NULL COMMENT '建议维保方式',
                                                  `s_suggest_maintenance_method` varchar(50) DEFAULT 'disable' COMMENT '状态',
                                                  `u_suggest_maintenance_method` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `u_s_suggest_maintenance_method` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `contacts` varchar(100) DEFAULT NULL COMMENT '联系人',
                                                  `s_contacts` varchar(100) DEFAULT 'disable' COMMENT '状态',
                                                  `u_contacts` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `u_s_contacts` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `director` varchar(50) DEFAULT NULL COMMENT '负责人',
                                                  `s_director` varchar(50) DEFAULT 'disable' COMMENT '状态',
                                                  `u_director` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `u_s_director` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `maintenance_start_date` date DEFAULT NULL COMMENT '维保开始时间',
                                                  `s_maintenance_start_date` varchar(50) DEFAULT 'disable' COMMENT '状态',
                                                  `u_maintenance_start_date` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `u_s_maintenance_start_date` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `maintenance_end_date` date DEFAULT NULL COMMENT '维保到期时间',
                                                  `s_maintenance_end_date` varchar(50) DEFAULT 'disable' COMMENT '状态',
                                                  `u_maintenance_end_date` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `u_s_maintenance_end_date` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `maintenance_notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                                  `s_maintenance_notes` varchar(50) DEFAULT 'disable' COMMENT '状态',
                                                  `u_maintenance_notes` varchar(50) DEFAULT '' COMMENT '更新方式',
                                                  `u_s_maintenance_notes` varchar(50) DEFAULT '' COMMENT '更新方式',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='维保更新记录';

CREATE TABLE `eam_asset_maintenance_record` (
                                                `id` varchar(50) NOT NULL COMMENT '主键',
                                                `maintenance_update_id` varchar(50) DEFAULT NULL COMMENT '维保更新',
                                                `asset_id` varchar(50) DEFAULT NULL COMMENT '资产',
                                                `maintenance_notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                                `s_maintenance_notes` varchar(50) DEFAULT 'disable' COMMENT '备注[状态]',
                                                `maintainer_id` varchar(50) DEFAULT NULL COMMENT '维保厂商',
                                                `s_maintainer_id` varchar(50) DEFAULT 'disable' COMMENT '维保厂商[状态]',
                                                `maintainer_name` varchar(100) DEFAULT NULL COMMENT '维保厂商名称',
                                                `s_maintainer_name` varchar(50) DEFAULT 'disable' COMMENT '维保厂商名称[状态]',
                                                `maintenance_status` varchar(50) DEFAULT NULL COMMENT '维保状态',
                                                `s_maintenance_status` varchar(50) DEFAULT 'disable' COMMENT '维保状态[状态]',
                                                `maintenance_method` varchar(50) DEFAULT NULL COMMENT '维保方式',
                                                `s_maintenance_method` varchar(50) DEFAULT 'disable' COMMENT '维保方式[状态]',
                                                `suggest_maintenance_method` varchar(50) DEFAULT NULL COMMENT '建议维保方式',
                                                `s_suggest_maintenance_method` varchar(50) DEFAULT 'disable' COMMENT '建议维保方式[状态]',
                                                `contacts` varchar(100) DEFAULT NULL COMMENT '联系人',
                                                `s_contacts` varchar(100) DEFAULT 'disable' COMMENT '联系人[状态]',
                                                `contact_information` varchar(100) DEFAULT NULL COMMENT '联系方式',
                                                `s_contact_information` varchar(100) DEFAULT 'disable' COMMENT '联系方式[状态]',
                                                `director` varchar(50) DEFAULT NULL COMMENT '负责人',
                                                `s_director` varchar(50) DEFAULT 'disable' COMMENT '负责人[状态]',
                                                `maintenance_start_date` date DEFAULT NULL COMMENT '维保开始时间',
                                                `s_maintenance_start_date` varchar(50) DEFAULT 'disable' COMMENT '维保开始时间[状态]',
                                                `maintenance_end_date` date DEFAULT NULL COMMENT '维保到期时间',
                                                `s_maintenance_end_date` varchar(50) DEFAULT 'disable' COMMENT '维保到期时间[状态]',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='维保更新记录';

create table eam_inventory_asset_bak_001 as select * from eam_inventory_asset_bak;


-- eam_inventory_asset
CREATE TABLE `eam_inventory_asset` (
                                       `id` varchar(50) NOT NULL COMMENT '主键',
                                       `inventory_id` varchar(50) DEFAULT NULL COMMENT '盘点',
                                       `status` varchar(50) DEFAULT NULL COMMENT '状态',
                                       `asset_id` varchar(50) DEFAULT NULL COMMENT '资产',
                                       `oper_empl_id` varchar(50) DEFAULT NULL COMMENT '员工',
                                       `asset_plus_action_type` varchar(50) DEFAULT 'none' COMMENT '盘盈动作',
                                       `asset_loss_action_type` varchar(50) DEFAULT 'none' COMMENT '盘亏动作',
                                       `source` varchar(50) DEFAULT 'asset' COMMENT '数据来源',
                                       `oper_date` datetime DEFAULT NULL COMMENT '操作时间',
                                       `picture_id` varchar(100) DEFAULT NULL COMMENT '照片',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='盘点明细';


