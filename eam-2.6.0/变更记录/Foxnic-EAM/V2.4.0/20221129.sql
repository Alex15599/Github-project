ALTER TABLE `hrm_organization` ADD COLUMN `notes` varchar(512) NULL COMMENT '备注' AFTER `version`;

CREATE TABLE `pcm_data_emp_ext`  (
                                     `id` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
                                     `catalog_id` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类ID',
                                     `tenant_id` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '租户ID',
                                     `owner_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '所有者ID',
                                     `create_by` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
                                     `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                     `update_by` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人ID',
                                     `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                                     `deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否已删除',
                                     `delete_by` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '删除人ID',
                                     `delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
                                     `version` int(11) NULL DEFAULT 1 COMMENT '数据版本号',
                                     `f_1` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                                     `f_2` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据存储表' ROW_FORMAT = Dynamic;

INSERT INTO `pcm_catalog` (`id`, `code`, `name`, `parent_id`, `sort`, `valid`, `hierarchy`, `data_table`, `tenant_id`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('649972251323531264', '649972251323531264', '基础数据扩展', '0', 999999, 1, '649972251323531264', NULL, 'T001', '110588348101165911', '2022-11-29 13:57:41', '110588348101165911', '2022-11-29 14:01:47', 0, NULL, NULL, 4),
('649972331808030720', 'EMP_EXT_INFO', '员工扩展信息', '649972251323531264', 999999, 1, '649972251323531264/649972331808030720', 'pcm_data_emp_ext', 'T001', '110588348101165911', '2022-11-29 13:58:00', '110588348101165911', '2022-11-29 13:58:20', 0, '', NULL, 3),
('649972501375352832', 'EMP_ORG_INFO', '组织扩展信息', '649972251323531264', 999999, 1, '649972251323531264/649972501375352832', 'pcm_data_org_ext', 'T001', '110588348101165911', '2022-11-29 13:58:40', '110588348101165911', '2022-11-29 13:58:40', 0, '', NULL, 2);
