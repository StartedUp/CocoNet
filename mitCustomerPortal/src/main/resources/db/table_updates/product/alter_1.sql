ALTER TABLE `coconet`.`product`
  ADD COLUMN `product_name` VARCHAR(255) NOT NULL AFTER `id`,
  ADD COLUMN `measurement_unit` VARCHAR(255) NOT NULL AFTER `name`,
  ADD COLUMN `variety_name` VARCHAR(255) NULL AFTER `measurement_unit`,
  ADD COLUMN `colour` VARCHAR(255) NULL AFTER `variety_name`,
  ADD COLUMN `size_in_word` VARCHAR(255) NULL AFTER `colour`,
  ADD COLUMN `size_in_number` DECIMAL(10,2) NULL AFTER `size_in_word`,
  ADD COLUMN `price_per_unit` DECIMAL(10,2) NOT NULL AFTER `size`;
