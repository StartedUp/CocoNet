ALTER TABLE `coconet`.`subscription_delivery_record`
  ADD COLUMN `updated_at` DATETIME NULL AFTER `delivered_by`;
