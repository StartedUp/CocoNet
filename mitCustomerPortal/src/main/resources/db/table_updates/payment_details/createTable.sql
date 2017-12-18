CREATE TABLE `payment_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `payment_id` varchar(255) DEFAULT NULL,
  `payment_type` varchar(50) NOT NULL,
  `paid_date` datetime DEFAULT NULL,
  `amount` decimal(10,2) NOT NULL,
  `transaction_id` varchar(50) DEFAULT NULL,
  `payment_request_id` varchar(100) DEFAULT NULL,
  `payment_request_status` varchar(50) DEFAULT NULL,
  `payment_status` varchar(50) NOT NULL,
  `subscription_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `subscription_id` (`subscription_id`),
  CONSTRAINT `payment_details_ibfk_1` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
