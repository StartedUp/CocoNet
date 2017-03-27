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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `subscription_plan` */

insert  into `subscription_plan`(`id`,`plan_name`,`Description`,`subscription_duration_type`,`subscription_duration_number`,`product_id`,`routine_pattern`,`discount_percentage`) values 

(1,'Employee-monthly','The product is delivered on weekdays for a month-Validity 1 month','month',1,1,'weekdays',0),

(2,'Family-monthly','The product is delivered daily for a month-Validity 1 month','month',1,1,'daily',0),

(3,'Employee-weekly','The product is delivered on weekdays for one week-Validity 1 week','week',1,1,'weekdays',0),

(4,'Family-weekly','The product is delivered daily for one week-Validity 1 week','week',1,1,'daily',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
