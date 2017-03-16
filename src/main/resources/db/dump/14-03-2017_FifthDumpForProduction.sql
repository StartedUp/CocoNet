/*
SQLyog Community v12.14 (64 bit)
MySQL - 5.7.9-log : Database - coconet
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`coconet` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `coconet`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address_holder_name` varchar(255) DEFAULT NULL,
  `address_line1` varchar(255) NOT NULL,
  `address_line2` varchar(255) NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `pincode` varchar(50) NOT NULL,
  `subscriber_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `subscriber_id` (`subscriber_id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`subscriber_id`) REFERENCES `subscriber` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `address` */

insert  into `address`(`id`,`address_holder_name`,`address_line1`,`address_line2`,`city`,`state`,`country`,`pincode`,`subscriber_id`) values 
(1,'Prithvi','144 Sornambal Nagar','Ammachatiram','Chennai','Tamilnadu','India','612103',1);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `measurement_unit` varchar(255) NOT NULL,
  `variety_name` varchar(255) DEFAULT NULL,
  `colour` varchar(255) DEFAULT NULL,
  `size_in_word` varchar(255) DEFAULT NULL,
  `price_per_unit` decimal(10,2) NOT NULL,
  `size_in_number` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `product` */

insert  into `product`(`id`,`product_name`,`measurement_unit`,`variety_name`,`colour`,`size_in_word`,`price_per_unit`,`size_in_number`) values 
(1,'Tender Coconut','piece',NULL,NULL,NULL,'33.00','0.00');

/*Table structure for table `subscriber` */

DROP TABLE IF EXISTS `subscriber`;

CREATE TABLE `subscriber` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `registration_token` varchar(255) NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `subscriber` */

insert  into `subscriber`(`id`,`firstname`,`lastname`,`email`,`mobile`,`password`,`registration_token`,`is_active`) values 
(1,'Prithviprakash','Ramachandran','rprithviprakash@gmail.com','8015972163','$2a$10$67fR4mpyN5DCjGa34.czDO1Jbq6TeGuKK6hJFzSp36azDNYkRl42K','dee89781-5e86-42a8-880a-4a83244ea7cf',1);

/*Table structure for table `subscription` */

DROP TABLE IF EXISTS `subscription`;

CREATE TABLE `subscription` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subscription_plan_id` bigint(20) NOT NULL,
  `subscriber_id` bigint(20) unsigned NOT NULL,
  `delivery_address` bigint(20) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `total_number_of_days` int(20) DEFAULT NULL,
  `preferred_delivery_time` time NOT NULL DEFAULT '10:00:00',
  `quantity_per_day` decimal(10,2) NOT NULL,
  `total_quantity` decimal(10,2) NOT NULL,
  `actual_price` decimal(10,2) NOT NULL,
  `discount_percentage` int(10) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  `total_price` decimal(10,2) NOT NULL,
  `payment_status` varchar(50) NOT NULL DEFAULT 'pending',
  `payment_type` varchar(50) NOT NULL DEFAULT 'online',
  `subscription_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `subscription_plan_id` (`subscription_plan_id`),
  KEY `subscriber_id` (`subscriber_id`),
  KEY `address_id` (`delivery_address`),
  CONSTRAINT `subscription_ibfk_1` FOREIGN KEY (`subscription_plan_id`) REFERENCES `subscription_plan` (`id`),
  CONSTRAINT `subscription_ibfk_2` FOREIGN KEY (`subscriber_id`) REFERENCES `subscriber` (`id`),
  CONSTRAINT `subscription_ibfk_3` FOREIGN KEY (`delivery_address`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `subscription` */

/*Table structure for table `subscription_plan` */

DROP TABLE IF EXISTS `subscription_plan`;

CREATE TABLE `subscription_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plan_name` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `subscription_duration_type` varchar(255) NOT NULL,
  `subscription_duration_number` int(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `routine_pattern` varchar(50) NOT NULL DEFAULT 'weekdays',
  `discount_percentage` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `subscription_plan_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `subscription_plan` */

insert  into `subscription_plan`(`id`,`plan_name`,`Description`,`subscription_duration_type`,`subscription_duration_number`,`product_id`,`routine_pattern`,`discount_percentage`) values 
(1,'Employees-Daily','Coconut is delivered on weekday','month',1,1,'weekdays',0),
(2,'Family-Daily','Coconut is delivered daily','month',1,1,'daily',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
