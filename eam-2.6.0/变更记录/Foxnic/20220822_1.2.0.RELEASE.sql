ALTER TABLE `sys_session_online`
    ADD COLUMN `access_token` varchar(2048) NULL COMMENT 'accessToken' AFTER `node_id`,
ADD COLUMN `refresh_token` varchar(2048) NULL COMMENT 'refreshToken' AFTER `access_token`;


ALTER TABLE `sys_dict_item`
    ADD COLUMN `valid` int(11) NULL DEFAULT NULL COMMENT '有效，是否有效' AFTER `version`;

update sys_dict_item set valid=1;

