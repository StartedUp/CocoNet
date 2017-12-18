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
  `address_line1` varchar(255) NOT NULL,
  `address_line2` varchar(255) NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `pincode` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `address` (`address_line1`,`address_line2`,`city`,`state`,`country`,`pincode`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `address` */

insert  into `address`(`id`,`address_line1`,`address_line2`,`city`,`state`,`country`,`pincode`) values 
(6,'144 Sornambal Nagar','Ammachatiram','Chennai','TamilNadu','India','612103');

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
(1,'Tender Coconut','piece',NULL,NULL,NULL,'27.00','0.00');

/*Table structure for table `subscriber` */

DROP TABLE IF EXISTS `subscriber`;

CREATE TABLE `subscriber` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `registration_token` varchar(255) NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `subscriber_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `subscriber` */

insert  into `subscriber`(`id`,`firstname`,`lastname`,`email`,`mobile`,`password`,`address_id`,`registration_token`,`is_active`) values 
(13,'Prithviprakash','Ramachandran','rprithviprakash@gmail.com','8015972163','$2a$10$eFmgTnMJCAOpkfpix14BDOgU0tzNYvtnvqwJq6GZpO1Z.vBj5qbMW',6,'fb9274e7-6f31-4d83-8f09-52a93a0b6abf',1);

/*Table structure for table `subscription` */

DROP TABLE IF EXISTS `subscription`;

CREATE TABLE `subscription` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subscription_plan_id` bigint(20) NOT NULL,
  `subscriber_id` bigint(20) NOT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `total_number_of_days` int(20) DEFAULT NULL,
  `preferred_delivery_time` time DEFAULT '10:00:00',
  `quantity_per_day` decimal(10,2) NOT NULL,
  `total_quantity` decimal(10,2) NOT NULL,
  `actual_price` decimal(10,2) NOT NULL,
  `discount_percentage` int(10) DEFAULT NULL,
  `discount` decimal(10,2) DEFAULT NULL,
  `total_price` decimal(10,2) NOT NULL,
  `payment_status` varchar(50) NOT NULL DEFAULT 'pending',
  `payment_type` varchar(50) NOT NULL DEFAULT 'online',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `subscription` */

/*Table structure for table `subscription_plan` */

DROP TABLE IF EXISTS `subscription_plan`;

CREATE TABLE `subscription_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plan_name` varchar(255) NOT NULL,
  `subscription_duration_type` varchar(255) NOT NULL,
  `subscription_duration_number` int(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `routine_pattern` varchar(50) NOT NULL DEFAULT 'weekdays',
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `subscription_plan_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `subscription_plan` */

insert  into `subscription_plan`(`id`,`plan_name`,`subscription_duration_type`,`subscription_duration_number`,`product_id`,`routine_pattern`) values 
(1,'Employees-Daily','month',1,1,'weekdays'),
(2,'Family-Daily','month',1,1,'daily');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
