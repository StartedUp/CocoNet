ALTER TABLE `coconet`.`subscriber` ADD COLUMN `is_active` TINYINT(1) DEFAULT 0 NULL AFTER `registration_token`;
ALTER TABLE `coconet`.`subscriber` CHANGE `is_active` `is_active` TINYINT(1) DEFAULT 0 NOT NULL;
