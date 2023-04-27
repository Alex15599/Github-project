


ALTER TABLE eam_asset
    ADD COLUMN `collection_id` varchar(50) NULL COMMENT '领用ID' AFTER `internal_control_label`;


ALTER TABLE eam_asset
    ADD COLUMN `scrap_id` varchar(50) NULL COMMENT '已用期限,(月)' AFTER `internal_control_label`;