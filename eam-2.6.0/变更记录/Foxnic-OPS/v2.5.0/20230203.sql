INSERT INTO `sys_dict` (`id`, `is_tree`, `name`, `code`, `module`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('674184348886368256', 0, '开放列表类型', 'ops_public_list_type', '472036556115279872', '', '110588348101165911', '2023-02-04 09:27:55', NULL, NULL, 0, NULL, NULL, 1);


INSERT INTO `sys_dict` (`id`, `is_tree`, `name`, `code`, `module`, `notes`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('674248788960870400', 0, '人员归属', 'ops_person_owner', '472036556115279872', '', '110588348101165911', '2023-02-04 13:43:58', NULL, NULL, 0, NULL, NULL, 1);



INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `valid`)
VALUES
('674184443094630400', '674184348886368256', 'ops_public_list_type', '', 'softdown', '软件下载', 1, '110588348101165911', '2023-02-04 09:28:17', NULL, NULL, 0, NULL, NULL, 1, 1),
('674184511759581184', '674184348886368256', 'ops_public_list_type', '', 'infosystem', '信息系统', 2, '110588348101165911', '2023-02-04 09:28:33', NULL, NULL, 0, NULL, NULL, 1, 1),
('674184556642828288', '674184348886368256', 'ops_public_list_type', '', 'list', '信息清单', 3, '110588348101165911', '2023-02-04 09:28:44', NULL, NULL, 0, NULL, NULL, 1, 1),
('674189961167110144', '674184348886368256', 'ops_public_list_type', '', 'other', '其他', 5, '110588348101165911', '2023-02-04 09:50:13', NULL, NULL, 0, NULL, NULL, 1, 1);

INSERT INTO `sys_dict_item` (`id`, `dict_id`, `dict_code`, `parent_id`, `code`, `label`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`, `valid`)
VALUES
('674248841062514688', '674248788960870400', 'ops_person_owner', '', 'dev', '开发中心', 1, '110588348101165911', '2023-02-04 13:44:11', NULL, NULL, 0, NULL, NULL, 1, 1),
('674248914496389120', '674248788960870400', 'ops_person_owner', '', 'ops', '运维中心', 2, '110588348101165911', '2023-02-04 13:44:28', NULL, NULL, 0, NULL, NULL, 1, 1),
('674248951951523840', '674248788960870400', 'ops_person_owner', '', 'data', '大数据', 3, '110588348101165911', '2023-02-04 13:44:37', NULL, NULL, 0, NULL, NULL, 1, 1),
('674249005282099200', '674248788960870400', 'ops_person_owner', '', 'project', '项目质量部', 3, '110588348101165911', '2023-02-04 13:44:50', NULL, NULL, 0, NULL, NULL, 1, 1),
('674249089025572864', '674248788960870400', 'ops_person_owner', '', 'security', '安全部', 5, '110588348101165911', '2023-02-04 13:45:10', NULL, NULL, 0, NULL, NULL, 1, 1),
('674249252477599744', '674248788960870400', 'ops_person_owner', '', 'general', '综合部', 5, '110588348101165911', '2023-02-04 13:45:49', NULL, NULL, 0, NULL, NULL, 1, 1);


CREATE TABLE `ops_public_content` (
                                      `id` varchar(50) NOT NULL COMMENT '主键',
                                      `status` varchar(50) DEFAULT NULL COMMENT '状态',
                                      `type` varchar(50) DEFAULT NULL COMMENT '类型',
                                      `name` varchar(50) DEFAULT NULL COMMENT '名称',
                                      `address` varchar(500) DEFAULT NULL COMMENT '地址',
                                      `files` varchar(500) DEFAULT NULL COMMENT '文件',
                                      `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                      `sort` int(11) DEFAULT '100' COMMENT '排序',
                                      `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                      `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                      `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                      `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                      `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                      `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                      `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                      `version` int(11) NOT NULL DEFAULT '1',
                                      PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='开放列表';


INSERT INTO `ops_public_content` (`id`, `status`, `type`, `name`, `address`, `files`, `notes`, `sort`, `create_by`, `create_time`, `update_by`, `update_time`, `deleted`, `delete_by`, `delete_time`, `version`)
VALUES
('673971266721415168', 'enable', 'list', '(仅内部使用误外传)-数据库例列表-(生产环境)', 'http://127.0.0.1:8089/business/ops/db_info/db_info_public_list.html', '', '请做好保密措施，仅内部使用误外传！ 提供信息系统数据库例基本信息查询', 100, '110588348101165911', '2023-02-03 19:21:12', '110588348101165911', '2023-02-04 12:34:38', 0, NULL, NULL, 10),
('673975322655326208', 'enable', 'list', '(仅内部使用误外传)-主机列表-(生产环境)', 'http://127.0.0.1:8089/business/ops/host/host_public_list.html', '', '请做好保密措施，仅内部使用误外传！ 提供信息系统主机基本信息查询', 100, '110588348101165911', '2023-02-03 19:37:19', '110588348101165911', '2023-02-04 12:34:28', 0, NULL, NULL, 10),
('673975358281744384', 'enable', 'list', '(仅内部使用误外传)-信息系统列表-(生产环境)', 'http://127.0.0.1:8089/business/ops/information_system/information_system_public_list.html', '', '请做好保密措施，仅内部使用误外传！ 提供信息系统基本信息查询', 100, '110588348101165911', '2023-02-03 19:37:27', '110588348101165911', '2023-02-04 12:44:29', 0, NULL, NULL, 12),
('674183307902058496', 'enable', 'softdown', '常用IT相关运维和开发工具下载', 'http://127.0.0.1:8089/business/ops/software_media/software_media_public_list.html', '', '提供常用IT相关运维和开发工具下载', 100, '110588348101165911', '2023-02-04 09:23:46', '110588348101165911', '2023-02-04 12:29:05', 0, NULL, NULL, 6),
('674233347521642496', 'enable', 'infosystem', '统一日志系统', 'http://www.baidu.com', '', '提供信息系统应用日志查询功能，请于值班室用个人账户登录系统查询相关日志信息', 100, '110588348101165911', '2023-02-04 12:42:37', '110588348101165911', '2023-02-04 12:42:56', 0, NULL, NULL, 2),
('674240146345820160', 'enable', 'list', '科技岗位人员工作分工情况', 'http://127.0.0.1:8089/business/ops/personnel_division/personnel_division_public_list.html', '', '提供科技部员工岗位分工情况，在协调中提高工作效率', 100, '110588348101165911', '2023-02-04 13:09:38', '110588348101165911', '2023-02-04 15:35:59', 0, NULL, NULL, 4);


CREATE TABLE `ops_personnel_division` (
                                          `id` varchar(50) NOT NULL COMMENT '主键',
                                          `status` varchar(50) DEFAULT NULL COMMENT '状态',
                                          `user_id` varchar(50) DEFAULT NULL COMMENT '用户',
                                          `owner` varchar(100) DEFAULT NULL COMMENT '所属',
                                          `pos` varchar(100) DEFAULT NULL COMMENT '岗位',
                                          `responsible_content` varchar(800) DEFAULT NULL COMMENT '负责内容',
                                          `job_content` varchar(800) DEFAULT NULL COMMENT '工作内容',
                                          `notes` varchar(500) DEFAULT NULL COMMENT '备注',
                                          `sort` int(11) DEFAULT '100' COMMENT '排序',
                                          `create_by` varchar(18) DEFAULT NULL COMMENT '创建人ID',
                                          `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                          `update_by` varchar(18) DEFAULT NULL COMMENT '修改人ID',
                                          `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                          `deleted` tinyint(1) DEFAULT '0' COMMENT '是否已删除',
                                          `delete_by` varchar(18) DEFAULT NULL COMMENT '删除人ID',
                                          `delete_time` datetime DEFAULT NULL COMMENT '删除时间',
                                          `version` int(11) NOT NULL DEFAULT '1',
                                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='人员分工';