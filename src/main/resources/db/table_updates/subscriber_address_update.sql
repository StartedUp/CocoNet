ALTER TABLE subscriber ADD address_id bigint(20);
ALTER TABLE `coconet`.`subscriber` ADD FOREIGN KEY (`address_id`) REFERENCES `coconet`.`address`(`id`);
ALTER TABLE `coconet`.`subscriber` CHANGE `address_id` `address_id` BIGINT(20) NOT NULL;