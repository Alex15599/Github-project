ALTER TABLE eam_asset
    ADD COLUMN `borrow_id` varchar(50) NULL COMMENT '借用ID' AFTER `internal_control_label`;



ALTER TABLE eam_asset_item
    ADD COLUMN `flag` varchar(50) NULL COMMENT '标记' AFTER `crd`;


ALTER TABLE eam_asset_item
    ADD COLUMN `flag` varchar(50) NULL COMMENT '标记' AFTER `crd`;