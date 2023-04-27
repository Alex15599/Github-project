ALTER TABLE ops_db_info ADD COLUMN `clear_strategy` VARCHAR(500) NULL COMMENT '' AFTER `backup_strategy`;
ALTER TABLE ops_db_info ADD COLUMN `tool_strategy` VARCHAR(500) NULL COMMENT '' AFTER `backup_strategy`;
ALTER TABLE ops_db_info ADD COLUMN `disaster_recovery_strategy` VARCHAR(500) NULL COMMENT '' AFTER `backup_strategy`;
ALTER TABLE ops_db_info ADD COLUMN `tool_strategy` VARCHAR(500) NULL COMMENT '' AFTER `backup_strategy`;