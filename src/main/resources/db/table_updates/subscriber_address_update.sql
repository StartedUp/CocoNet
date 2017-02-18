ALTER TABLE subscriber ADD address_id bigint(20);
ALTER TABLE `coconet`.`subscriber` ADD FOREIGN KEY (`address_id`) REFERENCES `coconet`.`address`(`id`);
ALTER TABLE address ADD UNIQUE address (address_line1, address_line2, city, state, country, pincode);
