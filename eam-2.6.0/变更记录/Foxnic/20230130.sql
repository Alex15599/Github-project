ALTER TABLE sys_token ADD COLUMN `session_id` varchar(128) NULL COMMENT '会话ID' AFTER `id`;

CREATE TABLE `sys_menu_fork`  (
                                  `id` varchar(18) NOT NULL COMMENT '主键',
                                  `menu_id` varchar(18) NULL COMMENT '菜单ID',
                                  `dir` varchar(32) NULL COMMENT '目录名称',
                                  `name` varchar(64) NULL COMMENT '名称',
                                  `notes` varchar(512) NULL COMMENT '备注',
                                  `sort` int(11) NOT NULL COMMENT '显示顺序',
                                  `create_by` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
                                  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                  `update_by` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人ID',
                                  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
                                  `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已删除',
                                  `delete_by` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除人ID',
                                  `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间',
                                  `version` int(11) NOT NULL DEFAULT 1 COMMENT '数据版本号',
                                  PRIMARY KEY (`id`),
                                  UNIQUE INDEX `uk`(`menu_id`, `dir`, `deleted`)
) COMMENT = '菜单功能分版本实现配置表';

ALTER TABLE `sys_menu`
    ADD COLUMN `link_type` varchar(8) NULL COMMENT '连接类型，外部链接、内部链接等' AFTER `notes`,
ADD COLUMN `open_type` varchar(8) NULL COMMENT '打开方式，Tab页或新窗口等' AFTER `link_type`;

ALTER TABLE `sys_profile`
    ADD COLUMN `sort` int(11) NOT NULL COMMENT '显示顺序' AFTER `notes`,
ADD COLUMN `create_by` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID' AFTER `sort`,
ADD COLUMN `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间' AFTER `create_by`,
ADD COLUMN `update_by` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人ID' AFTER `create_time`,
ADD COLUMN `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间' AFTER `update_by`,
ADD COLUMN `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已删除' AFTER `update_time`,
ADD COLUMN `delete_by` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除人ID' AFTER `deleted`,
ADD COLUMN `delete_time` datetime(0) NULL DEFAULT NULL COMMENT '删除时间' AFTER `delete_by`,
ADD COLUMN `version` int(11) NOT NULL DEFAULT 1 COMMENT '数据版本号' AFTER `delete_time`;

ALTER TABLE `sys_config` ADD COLUMN `parent_id` varchar(64) NULL COMMENT '上级ID' AFTER `version`;