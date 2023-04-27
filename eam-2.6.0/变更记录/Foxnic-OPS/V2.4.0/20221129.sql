ALTER TABLE `ops_db_info` ADD COLUMN `ops_user_list` varchar(500) NULL COMMENT '运维账户' AFTER `app_user_list`;
ALTER TABLE `ops_db_info` ADD COLUMN `user_use_info` varchar(500) NULL COMMENT '使用情况' AFTER `other_user_list`;

