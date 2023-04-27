
ALTER TABLE sys_user
    ADD COLUMN `notes` varchar(512) NULL COMMENT '备注' AFTER `version`;

ALTER TABLE  sys_menu
    ADD COLUMN `notes` varchar(512) NULL COMMENT '备注' AFTER `version`;


ALTER TABLE sys_role
    ADD COLUMN `notes` varchar(512) NULL COMMENT '备注' AFTER `version`;

ALTER TABLE sys_busi_role
    ADD COLUMN `notes` varchar(512) NULL COMMENT '备注' AFTER `version`;


