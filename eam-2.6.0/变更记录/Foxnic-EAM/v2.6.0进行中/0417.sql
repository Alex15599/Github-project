ALTER TABLE eam_asset ADD COLUMN `longitude` decimal(10,2) NULL COMMENT '' AFTER `bill_id`;
ALTER TABLE eam_asset ADD COLUMN `dimension` decimal(10,2) NULL COMMENT '' AFTER `bill_id`;

