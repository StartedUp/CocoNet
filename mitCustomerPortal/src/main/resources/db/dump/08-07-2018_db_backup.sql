-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: localhost    Database: coconet
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  CONSTRAINT `FKe0edubmu016ajrqn34332tkp4` FOREIGN KEY (`subscriber_id`) REFERENCES `subscriber` (`id`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`subscriber_id`) REFERENCES `subscriber` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Prithvi','144 Sornambal Nagar','Ammachatiram','Chennai','Tamilnadu','India','612103',1),(11,'Dhanraj','Pudhunagar','Medavakkam','Chennai','TamilNadu','India','600100',8),(12,'vcv','jjk','jhjh','Chennai','TamilNadu','India','ghfg',8),(13,'Gokul','Pudhu nagar','Medavaakam','Chennai','TamilNadu','India','600100',10),(14,'Manimaran ','Green court apartments,Ebony flats','rice mill road,medavakkam','Chennai','TamilNadu','India','600100',13),(15,'Raghunathan','FF1, Block 1, 1st floor, Meera Homes Greean court','Jaladianpet','Chennai','TamilNadu','India','600100',21),(16,'Ganesh','Oliyas Green court , Onyx Block F2','Jaganathapuram cross street, jalladianpet, medavakkam ','Chennai','TamilNadu','India','600100',22),(17,'Muthukumar','Wipro Tech','Hopes college. Coimbatore','Chennai','TamilNadu','India','638703',9),(18,'Abcd','Abcd','Abcd','Chennai','TamilNadu','India','641001',24),(19,'A block, S1, Iswarya Homes','Mambakkam main road','Medavakkam','Chennai','TamilNadu','India','600100',26),(20,'Rajesh','7B3, XS REAL, GREEN COURT','JEGANATHAPURAM, JELLADIYANPET, PALLIKARUNAI','Chennai','TamilNadu','India','600100',27),(21,'Raja Ramesh','#4/432, Pudhu Nagar 4th Street','Medavakkam','Chennai','TamilNadu','India','600100',28),(22,'Balaji','Siddharth Apartments, Flat F2, 5th Main Road','BHEL Nagar, Medavakkam','Chennai','TamilNadu','India','600100',31),(23,'Doddanna','45','Street ','Chennai','TamilNadu','India','612103',1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_details`
--

DROP TABLE IF EXISTS `payment_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  CONSTRAINT `FKiva0jertpiqrqao7cl4tauyp0` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`id`),
  CONSTRAINT `payment_details_ibfk_1` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_details`
--

LOCK TABLES `payment_details` WRITE;
/*!40000 ALTER TABLE `payment_details` DISABLE KEYS */;
INSERT INTO `payment_details` VALUES (1,NULL,'cod',NULL,1623.88,NULL,NULL,NULL,'pending',18),(2,NULL,'cod',NULL,1623.88,NULL,NULL,NULL,'pending',20),(3,NULL,'cod',NULL,3244.31,NULL,NULL,NULL,'pending',21),(4,NULL,'cod',NULL,2164.03,NULL,NULL,NULL,'pending',23),(5,'MOJO7327005N15704752','online','2017-03-27 15:09:43',206.00,'25','aa893e38c95e4a71a49a738aa817aee2',NULL,'completed',25),(6,NULL,'cod',NULL,1049.98,NULL,NULL,NULL,'pending',26),(7,'MOJO7329005N94502838','online','2017-03-29 20:20:47',543.59,'27','527301fd561b4b81b3cd0785858c872b',NULL,'completed',27),(8,'MOJO7404005N55284232','online','2017-04-04 11:27:05',273.52,'30','d2b12e75012f414ba1968d907da375e1',NULL,'completed',30),(9,NULL,'cod',NULL,273.52,NULL,NULL,NULL,'pending',31),(10,NULL,'cod',NULL,273.52,NULL,NULL,NULL,'pending',32),(11,'MOJO7417005N91466485','online','2017-04-17 12:06:20',273.52,'33','daa614234d6f4dd5ab6a62a362910212',NULL,'completed',33),(12,NULL,'cod',NULL,49.48,NULL,NULL,NULL,'pending',34),(13,NULL,'cod',NULL,49.48,NULL,NULL,NULL,'pending',35),(14,NULL,'cod',NULL,49.48,NULL,NULL,NULL,'pending',36),(15,NULL,'cod',NULL,49.48,NULL,NULL,NULL,'pending',38),(16,NULL,'cod',NULL,49.48,NULL,NULL,NULL,'pending',40),(17,NULL,'cod',NULL,49.48,NULL,NULL,NULL,'pending',41);
/*!40000 ALTER TABLE `payment_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) NOT NULL,
  `measurement_unit` int(11) NOT NULL,
  `variety_name` varchar(255) DEFAULT NULL,
  `colour` varchar(255) DEFAULT NULL,
  `size_in_word` varchar(255) DEFAULT NULL,
  `price_per_unit` decimal(10,2) NOT NULL,
  `size_in_number` decimal(10,2) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `minimum_quantity` decimal(19,2) DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Tender Coconut',1,'','','',45.00,NULL,'It is a healthy drink',10.00,''),(6,'Banana',1,'Morris','Yellow','One',5.00,1.00,'Natural fruit',12.00,''),(7,'Sugar can juice',4,'Sugar can juice','Yellow','One',25.00,1.00,'It is a natural drink',10.00,'\0'),(8,'Almond',2,'','','',450.00,NULL,'Dry fruit',0.50,'\0');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_image`
--

DROP TABLE IF EXISTS `product_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `size` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6oo0cvcdtb6qmwsga468uuukk` (`product_id`),
  CONSTRAINT `FK6oo0cvcdtb6qmwsga468uuukk` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_ProductImage` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_image`
--

LOCK TABLES `product_image` WRITE;
/*!40000 ALTER TABLE `product_image` DISABLE KEYS */;
INSERT INTO `product_image` VALUES (2,'tender_coconut_2.jpg',2,0,'images/productImages/tender_coconut/tender_coconut_2.jpg',1),(3,'banana_3.jpg',2,0,'images/productImages/banana/banana_3.jpg',6),(11,'banana_1520325479264.png',1,0,'images/productImages/banana/banana_1520318817584.png',6),(16,'banana_1520326261013.jpg',1,0,'images/productImages/banana/banana_1520326261013.jpg',6),(18,'tender_coconut_1520360885825.jpg',1,0,'images/productImages/tender_coconut/tender_coconut_1520360885825.jpg',1);
/*!40000 ALTER TABLE `product_image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_EMPLOYEE');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriber`
--

DROP TABLE IF EXISTS `subscriber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subscriber` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `registration_token` varchar(255) NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '0',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriber`
--

LOCK TABLES `subscriber` WRITE;
/*!40000 ALTER TABLE `subscriber` DISABLE KEYS */;
INSERT INTO `subscriber` VALUES (1,'Prithviprakash','Ramachandran','rprithviprakash@gmail.com','8015972163','$2a$10$67fR4mpyN5DCjGa34.czDO1Jbq6TeGuKK6hJFzSp36azDNYkRl42K','dee89781-5e86-42a8-880a-4a83244ea7cf',1,NULL),(5,'Dhanraj','Devendran','dhanutrading5@gmail.com','8438258092','$2a$10$dUXVrJM/Fq8nqVT8yl2iWeNfDthLaBUW2OX.Q.ErFH0xSpEFvtBK.','1d56f169-8182-4e4c-90f7-ab3d32819375',0,NULL),(6,'Manoj','Prabhakar','b.manoj1992@gmail.com','9042711227','$2a$10$afpQ4SK4CPJ/sIYyGpSUz.BG3t6qw2K15vgeH8oBZeg0r0SLkJjvO','02abdb9f-9ad3-4f00-b144-e66a02b14c78',1,'2017-03-20 16:28:00'),(7,'Ganesamoorthy','S','mailtoganesamoorthy@gmail.com','9489424017','$2a$10$yqh19rM9JOQI5sXEYktMRu.cOS50KZiPgMYW7LyP0ZCGGdjok09rS','03b42c91-0e1b-4a1e-9182-4d7a3807a52e',1,'2017-03-20 21:22:43'),(8,'Dhanraj','D','dydhanraj5@gmail.com','8438258092','$2a$10$NZD4o2LXth5FUFzv5KGwOeH4.LABO0yM7Tqn1DKaZX/3tZAyseAdi','e8e1eb59-09ea-4acc-b502-9cbd4c5b7d33',1,'2017-03-22 22:19:08'),(9,'Muthu ','Kumar','kumardprm@gmail.com','9843938703','$2a$10$BEqR8NcSCdU9kfZ41s3xqOI/LagYrpfruPitV2F633PcbLDzI5Lve','d6d9d782-2a8d-4c69-b159-239af91e8067',1,'2017-03-22 22:52:15'),(10,'Gokul','Raj','gokulaet@gmail.com','9159323787','$2a$10$aylvoVCNHzmUwwESVTOYF.FbKGNGQP928DcT2T1CUg1NTUI9sbVXu','944e36a2-8d45-408f-a543-8d87c04ae9d7',1,'2017-03-22 23:55:32'),(11,'Parasu','N','parasu12@gmail.com','9444710404','$2a$10$3wW6TX4SgiCR55rlaPHm.OacjVRvsRrWpt8Jo3KggMCOwEQS9XUUm','1d2c39fa-226b-4f6f-835a-b576000492c7',1,'2017-03-23 03:22:15'),(12,'shamritha','Murali','shamrithamurali25@gmail.com','9444386528','$2a$10$h7pLOfBdp2GNAHSZCNNaNONL3jEYXx1zWCP6LKlt/KlzhORtL/lO2','7fcdfcbf-d003-4e8f-9687-4bbb0d455583',1,'2017-03-23 07:50:15'),(13,'Manimaran','Pitchairaju','manimaran80@gmail.com','9940859096','$2a$10$5I11tERzuTavJh4G9rdQ6uJxW/UL/HEvg2A4UH2nSS4vt2fBphhY6','104cdf8d-3f4f-414b-a50f-cf278da4b39d',1,'2017-03-23 11:16:01'),(14,'Arun','A','ecearun12@gmail.com','8807323690','$2a$10$SSSpVfEjS7aXTjEfSLsmwuTW9Jg1z65n9esLhCeYBs5MyORw9eRF.','06658425-6865-40b7-8e96-0d7b0559404a',1,'2017-03-23 19:33:45'),(15,'Sajitha','Rajagopal','Sajitha474@gmail.com','7811811015','$2a$10$XZGLNIOearaJbPEcaRxVXeLPUWKACd19ybv.YnyhEnhXgwSsVJsN.','21b732ea-f77f-4985-903d-5b9de6a2fa70',1,'2017-03-26 21:43:38'),(16,'Jayanthi ','paramasivam','jayanthithilagam@gmail.com','8124407599','$2a$10$RZcT8WFoQVLkT6Dh7r50iu0Vw0Hj3Q69SWaFfkS2Vs4U16Pyoo3kG','7a628afb-1de1-4177-8f05-e98b98866c34',1,'2017-03-26 21:47:05'),(17,'suji','j','sujinehru93@gmail.com','9488266732','$2a$10$YuDXpjWKfSZd4NIcmeXPKeoun6qb9fvlrXSZcO8p.4QARjJ8MGCxK','40fdd264-9969-4415-b4f2-119d41e74780',1,'2017-03-26 21:50:00'),(18,'Manjula','Swaminathan','manju.swami90@gmail.com','9994393005','$2a$10$MbVVJxTYar63botYzUlLZ.5JCpHHDh3p2J3iZqGcbOBdLLCDS.7MC','2871d640-c089-4549-be6e-2a64c9d567ab',1,'2017-03-27 18:17:25'),(19,'Arunaigiri','NM','arunagirimalaai@gmail.com','9176673212','$2a$10$6WEdpSP4wn7JVi5.0ladCe2kxPIE92lgBRF062ZRKME5qCv2GanFq','cb272281-04dc-4468-910b-34e055904b98',1,'2017-03-28 00:07:35'),(20,'Jagadeesh','Yarra','jagadeesh.yarra@gmail.com','9600075304','$2a$10$YT/qGSQYPbS4PGjaRmfXAeH1CX2jducKXxdWEdHEbzpcDuODnA8/u','9754fb72-0579-47be-89b6-1ec7a1276219',1,'2017-03-29 16:26:19'),(21,'Raghunathan','Ravindranathan','raviraghunath.ms@gmail.com','8754392120','$2a$10$Lu6VH050IaqJ35N10liGJurvpb0/cNTDb4ZodM/mpQZMxEqriD8JK','c854b45e-ca0d-47a0-b17d-8ad4e9e23a92',1,'2017-03-29 17:59:27'),(22,'Ganesh','K','mailtoganeshk@gmail.com','9994126348','$2a$10$bZM8wOlR0PpxDbSy8DxlreU78fFBVB9lbEgfqDZTqePo8Ccd9zJ4e','9c3c39af-0d5f-4840-b2b2-369da25eba65',1,'2017-03-29 20:12:02'),(23,'MANJULA','','manju12792@gmail.com','9488056488','$2a$10$wdr1Z0dcywhq05YLYYTfo.7bcmCEJRsIKs1bHX/.NPVNYuvwsyO/6','9ca48091-3367-4702-9f5c-ef705cbda481',1,'2017-03-31 16:30:52'),(24,'Fahid','M','fahidroid@gmail.com','9578006633','$2a$10$cKRAQMdGxxNyWlM9IfCbXuvqQv9Kcno2Ie/A2eYezIaEQUt5D161y','b4edd1ed-f217-4450-ae92-f2b4192bac67',1,'2017-04-02 22:27:13'),(25,'Saravana','','mahadevansaravana12@gmail.com','9894656268','$2a$10$/u1Li4jzumDLNTuYrhRyFeWKrDsOwnmnPsKWTA4I3D/M7KhXIPAVS','5254caca-115c-414c-84c7-1d910af6099e',1,'2017-04-02 22:48:13'),(26,'Alan','','alan.joseph241@gmail.com','9840854096','$2a$10$IVw3fajqLCs2IRWoTMRy.uuEdSBBiT4gQCJY3eJsBHREEZXqGmFA6','4b670336-3daf-4288-b96a-a1cb1b306557',1,'2017-04-04 11:22:53'),(27,'Rajesh RS','','rs.rajeshmail@gmail.com','7708844089','$2a$10$/oLi4G6IEM74AAHM8KvM2OKoSiKL8ivJqRu9CZI1fYkAW0nTfP/li','965b4b5a-9fa5-49f1-9dd7-647489e8704d',1,'2017-04-05 09:54:17'),(28,'Raja','Ramesh','rajaramesh.balla09@gmail.com','8939445795','$2a$10$9bcJ9c4POc.1WN2zQxVYKuxJ7Y/vLNKtcMdWiil5R0UyiUFSwqeBe','df970a99-afa6-485e-98cb-1a6098add2e6',1,'2017-04-05 16:18:49'),(29,'Prema','Kumari','premaviji111@gmail.com','8220936399','$2a$10$3WMxjjhxWLsLfrB2HnG2EOy4.D5/IHinRjKBAHPTegxCJsGFws.46','e359081d-2eaa-46fa-a1b3-38a9cdda3b17',1,'2017-04-05 16:58:58'),(30,'Nisha','','meharun.90@gmail.com','7358397986','$2a$10$0mM2oNCn936kUSkpDSXWnO9OtMhj7FbBlMsyREMHcwzmuZznbCepe','fb099518-2ae2-4dc8-b9dc-785df448ad89',1,'2017-04-06 19:20:35'),(31,'Balaji','Panneerselvam','happybalaji@gmail.com','9943484583','$2a$10$Kj3Tv/F5AGxfl7xQLuUo0eNu4Hkp3SMEG/YsXOv/LOzJMGu8BhP2i','441c80ae-9ffa-4d11-9d18-f5b76e98fce7',1,'2017-06-21 12:59:01'),(32,'Shivu','Hiremath','shivu.r.hiremath@gmail.com','9535456221','$2a$10$.ylyZ0LId2BRyyU.JcNfr.wDQtEW2XtVyLBEEdWnXi.A37mwQhAoW','2fdbde85-f8bc-4868-8b18-e8303189160d',1,'2017-07-12 23:17:05');
/*!40000 ALTER TABLE `subscriber` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription`
--

DROP TABLE IF EXISTS `subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  `create_date` datetime DEFAULT NULL,
  `product_id` bigint(20) NOT NULL,
  `order_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `subscription_plan_id` (`subscription_plan_id`),
  KEY `subscriber_id` (`subscriber_id`),
  KEY `address_id` (`delivery_address`),
  KEY `FKg40gg635cui0m07vh433dri4x` (`product_id`),
  CONSTRAINT `FK78xqyso20wts083wlxo0yu2bt` FOREIGN KEY (`delivery_address`) REFERENCES `address` (`id`),
  CONSTRAINT `FK9bk70dbs5dcy2g5l41u4e46qy` FOREIGN KEY (`subscriber_id`) REFERENCES `subscriber` (`id`),
  CONSTRAINT `FKg40gg635cui0m07vh433dri4x` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKhn8hnxbdoi29nb4m7ojkocqfm` FOREIGN KEY (`subscription_plan_id`) REFERENCES `subscription_plan` (`id`),
  CONSTRAINT `subscription_ibfk_1` FOREIGN KEY (`subscription_plan_id`) REFERENCES `subscription_plan` (`id`),
  CONSTRAINT `subscription_ibfk_2` FOREIGN KEY (`subscriber_id`) REFERENCES `subscriber` (`id`),
  CONSTRAINT `subscription_ibfk_3` FOREIGN KEY (`delivery_address`) REFERENCES `address` (`id`),
  CONSTRAINT `subscription_ibfk_4` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription`
--

LOCK TABLES `subscription` WRITE;
/*!40000 ALTER TABLE `subscription` DISABLE KEYS */;
INSERT INTO `subscription` VALUES (15,1,1,1,'2017-03-27 12:00:00','2017-04-27 12:00:00',24,'10:00:00',1.00,24.00,813.67,0,0.00,813.67,'pending','online','initialized','2017-03-20 12:36:07',1,''),(16,1,1,1,'2017-03-27 12:00:00','2017-04-27 12:00:00',24,'10:00:00',1.00,24.00,813.67,0,0.00,813.67,'pending','online','initialized','2017-03-20 13:30:34',1,''),(17,2,8,11,'2017-03-27 12:00:01','2017-04-27 12:00:01',32,'10:00:00',1.00,32.00,1083.74,0,0.00,1083.74,'pending','online','initialized','2017-03-22 22:21:13',1,''),(18,1,8,11,'2017-03-27 12:00:01','2017-04-27 12:00:01',24,'10:00:00',2.00,48.00,1623.88,0,0.00,1623.88,'pending','cod','initialized','2017-03-22 23:05:50',1,''),(19,1,8,11,'2017-03-27 12:00:00','2017-04-27 12:00:00',24,'10:00:00',2.00,48.00,1623.88,0,0.00,1623.88,'pending','online','initialized','2017-03-22 23:12:22',1,''),(20,1,8,11,'2017-03-27 12:00:01','2017-04-27 12:00:01',24,'10:00:00',2.00,48.00,1623.88,0,0.00,1623.88,'pending','cod','initialized','2017-03-22 23:13:45',1,''),(21,2,8,11,'2017-03-27 12:00:00','2017-04-27 12:00:00',32,'10:00:00',3.00,96.00,3244.31,0,0.00,3244.31,'pending','cod','initialized','2017-03-22 23:16:33',1,''),(22,2,10,13,'2017-03-27 12:00:01','2017-04-27 12:00:01',32,'17:00:00',2.00,64.00,2164.03,0,0.00,2164.03,'pending','online','initialized','2017-03-22 23:59:17',1,''),(23,2,10,13,'2017-03-27 00:00:01','2017-04-27 00:00:01',32,'17:00:00',2.00,64.00,2164.03,0,0.00,2164.03,'pending','cod','initialized','2017-03-23 00:00:30',1,''),(24,1,13,14,'2017-03-27 00:00:01','2017-04-27 00:00:01',24,'18:00:00',1.00,24.00,813.67,0,0.00,813.67,'pending','online','initialized','2017-03-23 11:19:42',1,''),(25,3,13,14,'2017-03-28 00:00:00','2017-04-04 00:00:00',6,'10:00:00',1.00,6.00,206.00,0,0.00,206.00,'completed','online','completed','2017-03-27 15:07:31',1,''),(26,2,21,15,'2017-04-03 00:00:00','2017-05-04 00:00:00',31,'06:00:00',1.00,31.00,1049.98,0,0.00,1049.98,'pending','cod','initialized','2017-03-29 18:01:32',1,''),(27,4,22,16,'2017-03-30 00:00:00','2017-04-06 00:00:00',8,'06:00:00',2.00,16.00,543.59,0,0.00,543.59,'completed','online','completed','2017-03-29 20:19:05',1,''),(28,1,9,17,'2017-03-31 00:00:00','2017-05-01 00:00:00',22,'10:00:00',1.00,22.00,746.15,0,0.00,746.15,'pending','online','initialized','2017-03-30 11:16:20',1,''),(29,1,24,18,'2017-04-06 00:00:00','2017-05-08 00:00:00',23,'18:00:00',10.00,230.00,7768.02,0,0.00,7768.02,'pending','online','initialized','2017-04-02 22:32:26',1,''),(30,4,26,19,'2017-04-05 00:00:00','2017-04-12 00:00:00',8,'06:00:00',1.00,8.00,273.52,0,0.00,273.52,'completed','online','active','2017-04-04 11:25:49',1,''),(31,4,27,20,'2017-04-06 00:00:00','2017-04-13 00:00:00',8,'07:00:00',1.00,8.00,273.52,0,0.00,273.52,'pending','cod','initialized','2017-04-05 09:59:31',1,''),(32,4,28,21,'2017-04-06 00:00:00','2017-04-13 00:00:00',8,'07:00:00',1.00,8.00,273.52,0,0.00,273.52,'pending','cod','initialized','2017-04-05 16:22:58',1,''),(33,4,26,19,'2017-04-18 00:00:00','2017-04-25 00:00:00',8,'07:00:00',1.00,8.00,273.52,0,0.00,273.52,'completed','online','active','2017-04-17 12:04:19',1,''),(34,5,1,1,'2018-06-23 16:50:32','2018-06-27 16:50:32',0,'16:50:31',1.00,1.00,49.48,0,NULL,49.48,'pending','cod','initialized','2018-06-23 16:50:32',1,''),(35,5,1,1,'2018-06-23 16:59:23','2018-06-23 16:59:23',0,'16:59:23',1.00,1.00,49.48,0,NULL,49.48,'pending','cod','initialized','2018-06-23 16:59:23',1,'351529753363270'),(36,5,1,1,'2018-06-23 21:26:07','2018-06-23 21:26:07',0,'21:26:07',1.00,1.00,49.48,0,NULL,49.48,'pending','cod','initialized','2018-06-23 21:26:07',1,'361529769367906'),(37,5,1,1,'2018-06-23 21:26:25','2018-06-23 21:26:25',0,'21:26:24',1.00,1.00,49.48,0,NULL,49.48,'pending','online','initialized','2018-06-23 21:26:25',1,'371529769385006'),(38,5,1,1,'2018-06-23 21:48:07','2018-06-23 21:48:07',0,'21:48:06',1.00,1.00,49.48,0,NULL,49.48,'pending','cod','initialized','2018-06-23 21:48:07',1,'381529770687081'),(39,5,1,1,'2018-06-23 21:52:29','2018-06-23 21:52:29',0,'21:52:28',1.00,1.00,49.48,0,NULL,49.48,'pending','online','initialized','2018-06-23 21:52:29',1,'391529770948829'),(40,5,1,1,'2018-06-23 21:54:27','2018-06-23 21:54:27',0,'21:54:27',1.00,1.00,49.48,0,NULL,49.48,'pending','cod','initialized','2018-06-23 21:54:27',1,'401529771067167'),(41,5,1,1,'2018-06-23 21:54:56','2018-06-23 21:54:56',0,'21:54:56',1.00,1.00,49.48,0,NULL,49.48,'pending','cod','initialized','2018-06-23 21:54:56',1,'411529771096246'),(42,5,1,1,'2018-06-23 21:58:33','2018-06-23 21:58:33',0,'21:58:33',3.00,3.00,18.79,0,NULL,18.79,'pending','online','initialized','2018-06-23 21:58:33',6,'421529771313606');
/*!40000 ALTER TABLE `subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription_delivery_record`
--

DROP TABLE IF EXISTS `subscription_delivery_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subscription_delivery_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subscription_id` bigint(20) NOT NULL,
  `date` datetime NOT NULL,
  `is_delivered` tinyint(1) NOT NULL DEFAULT '0',
  `quantity_delivered` decimal(10,2) NOT NULL,
  `delivered_by` varchar(255) DEFAULT 'MadeInTreesTeam',
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `subscription_id` (`subscription_id`),
  CONSTRAINT `FKtorojala4hnxc15dmivsk4lst` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`id`),
  CONSTRAINT `subscription_delivery_record_ibfk_1` FOREIGN KEY (`subscription_id`) REFERENCES `subscription` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription_delivery_record`
--

LOCK TABLES `subscription_delivery_record` WRITE;
/*!40000 ALTER TABLE `subscription_delivery_record` DISABLE KEYS */;
INSERT INTO `subscription_delivery_record` VALUES (1,18,'2017-03-27 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(2,18,'2017-03-28 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(3,18,'2017-03-29 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(4,18,'2017-03-30 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(5,18,'2017-03-31 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(6,18,'2017-04-03 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(7,18,'2017-04-04 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(8,18,'2017-04-05 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(9,18,'2017-04-06 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(10,18,'2017-04-07 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(11,18,'2017-04-10 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(12,18,'2017-04-11 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(13,18,'2017-04-12 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(14,18,'2017-04-13 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(15,18,'2017-04-14 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(16,18,'2017-04-17 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(17,18,'2017-04-18 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(18,18,'2017-04-19 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(19,18,'2017-04-20 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(20,18,'2017-04-21 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(21,18,'2017-04-24 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(22,18,'2017-04-25 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(23,18,'2017-04-26 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(24,18,'2017-04-27 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(25,20,'2017-03-27 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(26,20,'2017-03-28 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(27,20,'2017-03-29 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(28,20,'2017-03-30 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(29,20,'2017-03-31 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(30,20,'2017-04-03 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(31,20,'2017-04-04 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(32,20,'2017-04-05 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(33,20,'2017-04-06 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(34,20,'2017-04-07 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(35,20,'2017-04-10 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(36,20,'2017-04-11 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(37,20,'2017-04-12 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(38,20,'2017-04-13 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(39,20,'2017-04-14 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(40,20,'2017-04-17 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(41,20,'2017-04-18 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(42,20,'2017-04-19 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(43,20,'2017-04-20 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(44,20,'2017-04-21 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(45,20,'2017-04-24 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(46,20,'2017-04-25 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(47,20,'2017-04-26 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(48,20,'2017-04-27 12:00:01',0,0.00,'MadeInTreesTeam',NULL),(49,21,'2017-03-27 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(50,21,'2017-03-28 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(51,21,'2017-03-29 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(52,21,'2017-03-30 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(53,21,'2017-03-31 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(54,21,'2017-04-01 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(55,21,'2017-04-02 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(56,21,'2017-04-03 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(57,21,'2017-04-04 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(58,21,'2017-04-05 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(59,21,'2017-04-06 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(60,21,'2017-04-07 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(61,21,'2017-04-08 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(62,21,'2017-04-09 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(63,21,'2017-04-10 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(64,21,'2017-04-11 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(65,21,'2017-04-12 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(66,21,'2017-04-13 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(67,21,'2017-04-14 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(68,21,'2017-04-15 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(69,21,'2017-04-16 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(70,21,'2017-04-17 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(71,21,'2017-04-18 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(72,21,'2017-04-19 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(73,21,'2017-04-20 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(74,21,'2017-04-21 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(75,21,'2017-04-22 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(76,21,'2017-04-23 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(77,21,'2017-04-24 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(78,21,'2017-04-25 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(79,21,'2017-04-26 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(80,21,'2017-04-27 12:00:00',0,0.00,'MadeInTreesTeam',NULL),(81,23,'2017-03-27 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(82,23,'2017-03-28 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(83,23,'2017-03-29 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(84,23,'2017-03-30 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(85,23,'2017-03-31 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(86,23,'2017-04-01 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(87,23,'2017-04-02 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(88,23,'2017-04-03 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(89,23,'2017-04-04 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(90,23,'2017-04-05 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(91,23,'2017-04-06 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(92,23,'2017-04-07 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(93,23,'2017-04-08 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(94,23,'2017-04-09 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(95,23,'2017-04-10 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(96,23,'2017-04-11 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(97,23,'2017-04-12 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(98,23,'2017-04-13 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(99,23,'2017-04-14 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(100,23,'2017-04-15 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(101,23,'2017-04-16 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(102,23,'2017-04-17 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(103,23,'2017-04-18 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(104,23,'2017-04-19 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(105,23,'2017-04-20 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(106,23,'2017-04-21 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(107,23,'2017-04-22 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(108,23,'2017-04-23 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(109,23,'2017-04-24 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(110,23,'2017-04-25 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(111,23,'2017-04-26 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(112,23,'2017-04-27 00:00:01',0,0.00,'MadeInTreesTeam',NULL),(113,25,'2017-03-28 00:00:00',1,1.00,'MadeInTreesTeam','2017-03-28 05:45:03'),(114,25,'2017-03-29 00:00:00',1,1.00,'MadeInTreesTeam','2017-03-29 06:05:56'),(115,25,'2017-03-30 00:00:00',1,1.00,'MadeInTreesTeam','2017-03-30 02:11:05'),(116,25,'2017-03-31 00:00:00',1,1.00,'MadeInTreesTeam','2017-03-31 06:01:58'),(117,25,'2017-04-03 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-01 14:31:32'),(118,25,'2017-04-04 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-03 17:38:21'),(119,26,'2017-04-03 00:00:00',0,0.00,'MadeInTreesTeam',NULL),(120,26,'2017-04-04 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-04 06:41:45'),(121,26,'2017-04-05 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-05 11:24:28'),(122,26,'2017-04-06 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-06 15:57:57'),(123,26,'2017-04-07 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-07 22:46:02'),(124,26,'2017-04-08 00:00:00',0,1.00,'MadeInTreesTeam','2017-04-08 08:31:16'),(125,26,'2017-04-09 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-09 08:41:23'),(126,26,'2017-04-10 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-10 07:38:53'),(127,26,'2017-04-11 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-11 07:35:15'),(128,26,'2017-04-12 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-17 13:20:20'),(129,26,'2017-04-13 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-17 13:20:20'),(130,26,'2017-04-14 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-17 13:20:20'),(131,26,'2017-04-15 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-17 13:20:20'),(132,26,'2017-04-16 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-17 13:20:20'),(133,26,'2017-04-17 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-17 13:16:57'),(134,26,'2017-04-18 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-18 07:30:20'),(135,26,'2017-04-19 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-19 07:56:34'),(136,26,'2017-04-20 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-20 08:33:44'),(137,26,'2017-04-21 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-21 08:51:42'),(138,26,'2017-04-22 00:00:00',0,0.00,'MadeInTreesTeam',NULL),(139,26,'2017-04-23 00:00:00',0,0.00,'MadeInTreesTeam',NULL),(140,26,'2017-04-24 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-24 07:19:12'),(141,26,'2017-04-25 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-25 09:08:49'),(142,26,'2017-04-26 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-26 21:04:35'),(143,26,'2017-04-27 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-27 22:56:50'),(144,26,'2017-04-28 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-28 07:33:34'),(145,26,'2017-04-29 00:00:00',0,0.00,'MadeInTreesTeam',NULL),(146,26,'2017-04-30 00:00:00',0,0.00,'MadeInTreesTeam',NULL),(147,26,'2017-05-01 00:00:00',1,1.00,'MadeInTreesTeam','2017-05-01 07:36:03'),(148,26,'2017-05-02 00:00:00',0,0.00,'MadeInTreesTeam',NULL),(149,26,'2017-05-03 00:00:00',0,0.00,'MadeInTreesTeam',NULL),(150,27,'2017-03-30 00:00:00',1,2.00,'MadeInTreesTeam','2017-03-30 01:55:07'),(151,27,'2017-03-31 00:00:00',1,2.00,'MadeInTreesTeam','2017-03-31 06:02:29'),(152,27,'2017-04-01 00:00:00',1,2.00,'MadeInTreesTeam','2017-04-01 14:31:20'),(153,27,'2017-04-02 00:00:00',1,2.00,'MadeInTreesTeam','2017-04-02 10:01:32'),(154,27,'2017-04-03 00:00:00',1,2.00,'MadeInTreesTeam','2017-04-03 17:39:15'),(155,27,'2017-04-04 00:00:00',1,2.00,'MadeInTreesTeam','2017-04-04 06:41:07'),(156,27,'2017-04-05 00:00:00',1,2.00,'MadeInTreesTeam','2017-04-05 11:25:07'),(157,27,'2017-04-06 00:00:00',1,2.00,'MadeInTreesTeam','2017-04-06 15:58:10'),(158,30,'2017-04-05 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-05 11:26:55'),(159,30,'2017-04-06 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-06 15:58:21'),(160,30,'2017-04-07 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-07 22:46:16'),(161,30,'2017-04-08 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-08 08:31:31'),(162,30,'2017-04-09 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-09 08:41:46'),(163,30,'2017-04-10 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-10 07:39:11'),(164,30,'2017-04-11 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-17 12:33:35'),(165,30,'2017-04-12 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-17 12:33:35'),(166,26,'2017-05-04 00:00:00',0,0.00,'MadeInTreesTeam','2017-04-04 06:37:58'),(167,31,'2017-04-06 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-06 15:58:32'),(168,31,'2017-04-07 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-07 22:46:33'),(169,31,'2017-04-08 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-08 08:31:44'),(170,31,'2017-04-09 00:00:00',0,0.00,'MadeInTreesTeam',NULL),(171,31,'2017-04-10 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-10 07:39:24'),(172,31,'2017-04-11 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-11 07:36:02'),(173,31,'2017-04-12 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-17 12:33:35'),(174,31,'2017-04-13 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-17 12:33:35'),(175,32,'2017-04-06 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-06 15:58:47'),(176,32,'2017-04-07 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-07 22:46:45'),(177,32,'2017-04-08 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-08 08:31:55'),(178,32,'2017-04-09 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-09 08:43:04'),(179,32,'2017-04-10 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-10 07:39:35'),(180,32,'2017-04-11 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-11 07:36:36'),(181,32,'2017-04-12 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-17 12:33:35'),(182,32,'2017-04-13 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-17 12:33:35'),(183,33,'2017-04-18 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-18 07:30:31'),(184,33,'2017-04-19 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-19 07:56:45'),(185,33,'2017-04-20 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-20 08:33:53'),(186,33,'2017-04-21 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-21 08:51:51'),(187,33,'2017-04-22 00:00:00',0,0.00,'MadeInTreesTeam',NULL),(188,33,'2017-04-23 00:00:00',0,0.00,'MadeInTreesTeam',NULL),(189,33,'2017-04-24 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-24 07:19:24'),(190,33,'2017-04-25 00:00:00',1,1.00,'MadeInTreesTeam','2017-04-25 09:08:58'),(191,34,'2018-06-23 16:50:32',0,0.00,'MadeInTreesTeam',NULL),(192,34,'2018-06-24 16:50:32',0,0.00,'MadeInTreesTeam',NULL),(193,34,'2018-06-25 16:50:32',0,0.00,'MadeInTreesTeam',NULL),(194,34,'2018-06-26 16:50:32',0,0.00,'MadeInTreesTeam',NULL),(195,34,'2018-06-27 16:50:32',0,0.00,'MadeInTreesTeam',NULL),(196,35,'2018-06-23 16:59:23',0,0.00,'MadeInTreesTeam',NULL),(197,36,'2018-06-23 21:26:07',0,0.00,'MadeInTreesTeam',NULL),(198,38,'2018-06-23 21:48:07',0,0.00,'MadeInTreesTeam',NULL),(199,40,'2018-06-23 21:54:27',0,0.00,'MadeInTreesTeam',NULL),(200,41,'2018-06-23 21:54:56',0,0.00,'MadeInTreesTeam',NULL);
/*!40000 ALTER TABLE `subscription_delivery_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription_plan`
--

DROP TABLE IF EXISTS `subscription_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subscription_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `plan_name` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `subscription_duration_type` varchar(255) NOT NULL,
  `subscription_duration_number` int(20) NOT NULL,
  `routine_pattern` varchar(50) NOT NULL DEFAULT 'weekdays',
  `discount_percentage` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription_plan`
--

LOCK TABLES `subscription_plan` WRITE;
/*!40000 ALTER TABLE `subscription_plan` DISABLE KEYS */;
INSERT INTO `subscription_plan` VALUES (1,'Employee-monthly','The product is delivered on weekdays for a month-Validity 1 month','month',1,'weekdays',0),(2,'Family-monthly','The product is delivered daily for a month-Validity 1 month','month',1,'daily',0),(3,'Employee-weekly','The product is delivered on weekdays for one week-Validity 1 week','week',1,'weekdays',0),(4,'Family-weekly','The product is delivered daily for one week-Validity 1 week','week',1,'daily',0),(5,'One-time-delivery','The product is deliveres once per order','daily',1,'once',0);
/*!40000 ALTER TABLE `subscription_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin@madeintrees.com',NULL,'$2a$10$OjczdLlBY/TA2d1EBpjgnO43w56lyYz7vhVSq3.zM6ywHLLt/iuxG','admin'),(3,'rprithviprakash@gmail.com',NULL,'$2a$10$OjczdLlBY/TA2d1EBpjgnO43w56lyYz7vhVSq3.zM6ywHLLt/iuxG','Prithu'),(4,'dhanraj@madeintrees.com',NULL,'$2a$10$ABqGzeSUOP2TUOV7SQEvSuUjpPREzMSlfSg0S6XtgUs4w7g7FP68K','Dhanu');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(1,2),(4,2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-08 19:49:43
