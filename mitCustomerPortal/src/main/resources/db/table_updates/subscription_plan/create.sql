CREATE TABLE `coconet`.`subscription_plan`(
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `plan_name` VARCHAR(255) NOT NULL ,
  `subscription_duration_type` VARCHAR(255) NOT NULL,
  `subscription_duration_number` INT(20)NOT NULL,
  `product_id` BIGINT(20) NOT NULL,
  `routine_pattern` VARCHAR(255) NOT NULL DEFAULT 'weekdays',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`product_id`) REFERENCES `coconet`.`product`(`id`)
);
