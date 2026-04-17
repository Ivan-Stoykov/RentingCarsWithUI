CREATE DATABASE  IF NOT EXISTS `cars` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cars`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: cars
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `avtomobil`
--

DROP TABLE IF EXISTS `avtomobil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avtomobil` (
  `AVTOMOBIL_ID` int NOT NULL AUTO_INCREMENT,
  `IZMINATIKILOMETRI` int DEFAULT NULL,
  `CVQT_ID` int DEFAULT NULL,
  `spec_id` int DEFAULT NULL,
  `img_url` varchar(255) DEFAULT NULL,
  `isDeleted` tinyint DEFAULT '0',
  PRIMARY KEY (`AVTOMOBIL_ID`),
  KEY `CVQT_ID` (`CVQT_ID`),
  KEY `FK4ui7tspt7gybvnhgaxbyh9sna` (`spec_id`),
  CONSTRAINT `avtomobil_ibfk_3` FOREIGN KEY (`CVQT_ID`) REFERENCES `cvqt` (`CVQT_ID`),
  CONSTRAINT `FK4ui7tspt7gybvnhgaxbyh9sna` FOREIGN KEY (`spec_id`) REFERENCES `specifikacii` (`spec_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avtomobil`
--

LOCK TABLES `avtomobil` WRITE;
/*!40000 ALTER TABLE `avtomobil` DISABLE KEYS */;
INSERT INTO `avtomobil` VALUES (1,500000,1,1,'https://www.edmunds.com/assets/m/for-sale/fa-wvwma63b9xe507619/img-1-600x400.jpg',0),(2,2000,2,2,'https://gtspirit.com/wp-content/uploads/2019/08/Mercedes-AMG-GLE-53-Coupe.jpg',0),(3,2000,4,3,'https://files.idyllic.app/files/static/3655219',0),(4,500,3,4,'https://images-archive.allbids.com.au/auctions/37939/cars/medium/37939-1d_ex.jpg',0),(5,5000,5,5,'https://www.edmunds.com/assets/m/for-sale/0b-3vwg17au7jm284227/img-1-600x400.jpg',0),(6,5000,5,6,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJPZL01vZoR67TpDuDta2V1_PfmfNl4ShwNg&s',0),(7,4000,4,7,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcRZSd7-nyUIIVTQOs8p9GFPUoxcb8hV1UuQ&s',0),(8,2000,3,8,'https://hips.hearstapps.com/hmg-prod/images/2020-mercedes-benz-gle-class-placement-1542046844.jpg',0),(9,2000,2,9,'https://i.ytimg.com/vi/fbqfu8458dk/maxresdefault.jpg',0),(10,2000,1,10,'https://media.carsandbids.com/cdn-cgi/image/width=2080,quality=70/20309e251cb7341d1fb94cb5d4546882260d2202/photos/application/s-Hb9VMD_/edit/GSUCZ.jpg?t=176843173577',0),(11,2000,3,11,'https://hips.hearstapps.com/hmg-prod/images/fitzgerald-s-m3-hwsi-663a6cde3c0b2.jpg?crop=0.510xw:0.357xh;0.243xw,0.283xh&resize=980:*',0),(12,2000,1,12,'https://www.lloydmotorgroup.com/VehicleLibrary/553155-1xoIIw2GwU6Ew34EwXIhtw.jpg?height=648.75&heightratio=0.75&mode=crop&upscale=true&width=865',0),(13,200,2,13,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTuVjdnLOy_wtuCb85QtWGILpYjU6mHeCWyYw&s',0),(14,200,5,14,'https://d2bq9obxtvkjtt.cloudfront.net/images/cars/2025/2025-audi-q7-455539-640-01.jpg',0),(15,20000,1,15,'https://uploads.audi-mediacenter.com/system/production/media/126264/images/af906b8533f9f159852ecd9dd394065371b87e41/A244112_web_2880.jpg?1726141263',0),(16,15000,4,16,'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQysTrEjGnjIMkhp9ROFMVnueMU0BfAaVShzA&s',0),(17,35000,1,17,'https://i.ytimg.com/vi/WLU0FwfeFG4/sddefault.jpg',0),(18,30000,2,18,'https://i.ytimg.com/vi/JI3Nb0hDF4g/maxresdefault.jpg',0),(19,30000,1,19,'https://product-detail-www-opennext.snc-prod.aws.cinch.co.uk/_next/image?url=https%3A%2F%2Feu.cdn.autosonshow.tv%2F2808%2Fcinch%2FKW16EOX%2F06_md.jpg&w=3840&q=75',0),(20,50000,1,20,'https://c0.carsie.ie/d43864c90df075c94489ddbe4ca5ffe9983851aab4bf3b14b1bf829e17b66590.jpg',0),(21,500,2,21,'https://scene7.toyota.eu/is/image/toyotaeurope/COR0001a_25_WEB_CROP:Large-Landscape?ts=0&resMode=sharp2&op_usm=1.75,0.3,2,0&fmt=png-alpha',0);
/*!40000 ALTER TABLE `avtomobil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `avtomobilview`
--

DROP TABLE IF EXISTS `avtomobilview`;
/*!50001 DROP VIEW IF EXISTS `avtomobilview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `avtomobilview` AS SELECT 
 1 AS `avtomobil_ID`,
 1 AS `marka_name`,
 1 AS `kolamodel`,
 1 AS `vid`,
 1 AS `godina`,
 1 AS `cvqt`,
 1 AS `ime_extra`,
 1 AS `cena_za_den`,
 1 AS `IZMINATIKILOMETRI`,
 1 AS `img_url`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `cvqt`
--

DROP TABLE IF EXISTS `cvqt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cvqt` (
  `CVQT_ID` int NOT NULL AUTO_INCREMENT,
  `cvqt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CVQT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cvqt`
--

LOCK TABLES `cvqt` WRITE;
/*!40000 ALTER TABLE `cvqt` DISABLE KEYS */;
INSERT INTO `cvqt` VALUES (1,'CHEREN'),(2,'BQL'),(3,'SIN'),(4,'LILAV'),(5,'SIV');
/*!40000 ALTER TABLE `cvqt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `durjavi`
--

DROP TABLE IF EXISTS `durjavi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `durjavi` (
  `durjava_ID` int NOT NULL AUTO_INCREMENT,
  `durjava` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`durjava_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `durjavi`
--

LOCK TABLES `durjavi` WRITE;
/*!40000 ALTER TABLE `durjavi` DISABLE KEYS */;
INSERT INTO `durjavi` VALUES (1,'Bulgaria'),(2,'durjava'),(3,'aaaaaa'),(4,'bbb');
/*!40000 ALTER TABLE `durjavi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ekstri`
--

DROP TABLE IF EXISTS `ekstri`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ekstri` (
  `extra_Id` int NOT NULL AUTO_INCREMENT,
  `ime_extra` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`extra_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ekstri`
--

LOCK TABLES `ekstri` WRITE;
/*!40000 ALTER TABLE `ekstri` DISABLE KEYS */;
INSERT INTO `ekstri` VALUES (1,'bez');
/*!40000 ALTER TABLE `ekstri` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gradove`
--

DROP TABLE IF EXISTS `gradove`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gradove` (
  `GRAD_ID` int NOT NULL AUTO_INCREMENT,
  `grad` varchar(255) DEFAULT NULL,
  `durjava_ID` int DEFAULT NULL,
  PRIMARY KEY (`GRAD_ID`),
  KEY `durjava_ID` (`durjava_ID`),
  CONSTRAINT `gradove_ibfk_1` FOREIGN KEY (`durjava_ID`) REFERENCES `durjavi` (`durjava_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gradove`
--

LOCK TABLES `gradove` WRITE;
/*!40000 ALTER TABLE `gradove` DISABLE KEYS */;
INSERT INTO `gradove` VALUES (1,'VARNA',1),(2,'SOFIQ',1),(3,'PLOVDIV',1),(4,'grad',2),(5,'aaaaaaaa',3),(6,'aaa',4);
/*!40000 ALTER TABLE `gradove` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `klient`
--

DROP TABLE IF EXISTS `klient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `klient` (
  `KLIENT_ID` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) DEFAULT NULL,
  `GRAD_ID` int DEFAULT NULL,
  `ULICA` varchar(255) DEFAULT NULL,
  `telefon` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rolq` varchar(255) DEFAULT NULL,
  `isDeleted` tinyint DEFAULT '0',
  PRIMARY KEY (`KLIENT_ID`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `GRAD_ID` (`GRAD_ID`),
  CONSTRAINT `klient_ibfk_1` FOREIGN KEY (`GRAD_ID`) REFERENCES `gradove` (`GRAD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klient`
--

LOCK TABLES `klient` WRITE;
/*!40000 ALTER TABLE `klient` DISABLE KEYS */;
INSERT INTO `klient` VALUES (1,'Vankata',1,'ul. Dubrovnik','0123456789','test@test.com','123456','admin',0),(2,'GOSHO',2,'nqkva ulica','1111111111','gosho@test.com','123456','user',0),(3,'Petur',3,'Roza','2222222222','petur@test.com','123456','user',0),(4,'Niki',1,'Lulin','3333333333','niki@test.com','123456','user',0),(5,'Kristiqn',2,'Drin','4444444444','kristiqn@test.com','123456','user',0),(6,'Hristiqn',3,'Iglika','5555555555','hristiqn@test.com','123456','user',0),(7,'Ivan',1,'Dubrovnik','6666666666','ivan@test.com','123456','user',0),(8,'Dragan',2,'Slivnica','7777777777','dragan@test.com','123456','user',0),(9,'Petkan',3,'Studentska','8888888888',NULL,'123456','user',1),(10,'Sergei',1,'Dubrovnik','9999999999',NULL,'123456','user',1);
/*!40000 ALTER TABLE `klient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `klientview`
--

DROP TABLE IF EXISTS `klientview`;
/*!50001 DROP VIEW IF EXISTS `klientview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `klientview` AS SELECT 
 1 AS `KLIENT_ID`,
 1 AS `ime`,
 1 AS `ULICA`,
 1 AS `telefon`,
 1 AS `email`,
 1 AS `grad`,
 1 AS `durjava`,
 1 AS `rolq`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `kolamodel`
--

DROP TABLE IF EXISTS `kolamodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kolamodel` (
  `MODEL_ID` int NOT NULL AUTO_INCREMENT,
  `kolamodel` varchar(255) DEFAULT NULL,
  `MARKA_ID` int DEFAULT NULL,
  PRIMARY KEY (`MODEL_ID`),
  KEY `FKmdj13w6q8tg2u3j9q69yyygor` (`MARKA_ID`),
  CONSTRAINT `FKmdj13w6q8tg2u3j9q69yyygor` FOREIGN KEY (`MARKA_ID`) REFERENCES `marka` (`MARKA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kolamodel`
--

LOCK TABLES `kolamodel` WRITE;
/*!40000 ALTER TABLE `kolamodel` DISABLE KEYS */;
INSERT INTO `kolamodel` VALUES (1,'PASSAT',1),(2,'CLA 200',2),(3,'GOLF',1),(4,'GLE',2),(5,'X5',3),(6,'M3',3),(7,'RS E-TRON GT',4),(8,'Q7',4),(9,'FABIA',5),(10,'OCTAVIA',5),(11,'Corolla',7);
/*!40000 ALTER TABLE `kolamodel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marka`
--

DROP TABLE IF EXISTS `marka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marka` (
  `MARKA_ID` int NOT NULL AUTO_INCREMENT,
  `marka_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MARKA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marka`
--

LOCK TABLES `marka` WRITE;
/*!40000 ALTER TABLE `marka` DISABLE KEYS */;
INSERT INTO `marka` VALUES (1,'VOLKSWAGEN'),(2,'MERCEDES'),(3,'BMW'),(4,'AUDI'),(5,'SKODA'),(7,'Toyota');
/*!40000 ALTER TABLE `marka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otdadeni`
--

DROP TABLE IF EXISTS `otdadeni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `otdadeni` (
  `ZAEM_ID` int NOT NULL AUTO_INCREMENT,
  `KLIENT_ID` int DEFAULT NULL,
  `AVTOMOBIL_ID` int DEFAULT NULL,
  `DATAZAEMANE` datetime DEFAULT NULL,
  `BROIDNI` int DEFAULT NULL,
  `DATAVRUSHTANE` datetime DEFAULT NULL,
  `isDeleted` tinyint DEFAULT '0',
  PRIMARY KEY (`ZAEM_ID`),
  KEY `AVTOMOBIL_ID` (`AVTOMOBIL_ID`),
  KEY `KLIENT_ID` (`KLIENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otdadeni`
--

LOCK TABLES `otdadeni` WRITE;
/*!40000 ALTER TABLE `otdadeni` DISABLE KEYS */;
INSERT INTO `otdadeni` VALUES (1,1,3,'2026-04-01 00:00:00',4,'2026-04-04 00:00:00',0);
/*!40000 ALTER TABLE `otdadeni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `otdadeniview`
--

DROP TABLE IF EXISTS `otdadeniview`;
/*!50001 DROP VIEW IF EXISTS `otdadeniview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `otdadeniview` AS SELECT 
 1 AS `zaem_id`,
 1 AS `marka_name`,
 1 AS `kolamodel`,
 1 AS `vid`,
 1 AS `godina`,
 1 AS `cvqt`,
 1 AS `ime_extra`,
 1 AS `cena_za_den`,
 1 AS `datazaemane`,
 1 AS `broidni`,
 1 AS `datavrushtane`,
 1 AS `izminatikilometri`,
 1 AS `img_url`,
 1 AS `avtomobil_id`,
 1 AS `klient`,
 1 AS `email`,
 1 AS `klient_ID`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `specifikacii`
--

DROP TABLE IF EXISTS `specifikacii`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specifikacii` (
  `spec_ID` int NOT NULL AUTO_INCREMENT,
  `model_id` int DEFAULT NULL,
  `vid_id` int DEFAULT NULL,
  `ekstri_id` int DEFAULT NULL,
  `godina` int DEFAULT NULL,
  `cena_za_den` double DEFAULT NULL,
  PRIMARY KEY (`spec_ID`),
  KEY `model_id` (`model_id`),
  KEY `vid_id` (`vid_id`),
  KEY `ekstri_id` (`ekstri_id`),
  CONSTRAINT `specifikacii_ibfk_1` FOREIGN KEY (`model_id`) REFERENCES `kolamodel` (`MODEL_ID`),
  CONSTRAINT `specifikacii_ibfk_2` FOREIGN KEY (`vid_id`) REFERENCES `vid` (`VID_ID`),
  CONSTRAINT `specifikacii_ibfk_3` FOREIGN KEY (`ekstri_id`) REFERENCES `ekstri` (`extra_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specifikacii`
--

LOCK TABLES `specifikacii` WRITE;
/*!40000 ALTER TABLE `specifikacii` DISABLE KEYS */;
INSERT INTO `specifikacii` VALUES (1,1,1,1,2001,16.99),(2,4,4,1,2020,24.99),(3,1,3,1,2005,39.99),(4,3,3,1,2018,29.99),(5,3,1,1,2018,29.99),(6,2,1,1,2016,29.99),(7,2,4,1,2019,24.99),(8,4,2,1,2020,24.99),(9,5,1,1,2022,64.99),(10,5,4,1,2022,64.99),(11,6,4,1,2024,64.99),(12,6,1,1,2024,64.99),(13,8,3,1,2025,64.99),(14,8,5,1,2025,69.99),(15,7,1,1,2020,49.99),(16,7,4,1,2020,54.99),(17,9,5,1,2015,24.99),(18,9,3,1,2016,24.99),(19,10,5,1,2016,24.99),(20,10,1,1,2010,15.99),(21,11,3,1,2025,49.99),(22,1,1,1,2020,16.99);
/*!40000 ALTER TABLE `specifikacii` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vid`
--

DROP TABLE IF EXISTS `vid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vid` (
  `VID_ID` int NOT NULL AUTO_INCREMENT,
  `vid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`VID_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vid`
--

LOCK TABLES `vid` WRITE;
/*!40000 ALTER TABLE `vid` DISABLE KEYS */;
INSERT INTO `vid` VALUES (1,'SEDAN'),(2,'SUV'),(3,'HATCHBACK'),(4,'COUPE'),(5,'CROSSOVER');
/*!40000 ALTER TABLE `vid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zaqvki`
--

DROP TABLE IF EXISTS `zaqvki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zaqvki` (
  `ZAEM_ID` int NOT NULL AUTO_INCREMENT,
  `KLIENT_ID` int DEFAULT NULL,
  `AVTOMOBIL_ID` int DEFAULT NULL,
  `DATAZAEMANE` datetime DEFAULT NULL,
  `BROIDNI` int DEFAULT NULL,
  `DATAVRUSHTANE` datetime DEFAULT NULL,
  `isDeleted` tinyint DEFAULT '0',
  PRIMARY KEY (`ZAEM_ID`),
  KEY `AVTOMOBIL_ID` (`AVTOMOBIL_ID`),
  KEY `KLIENT_ID` (`KLIENT_ID`),
  CONSTRAINT `zaqvki_ibfk_1` FOREIGN KEY (`AVTOMOBIL_ID`) REFERENCES `avtomobil` (`AVTOMOBIL_ID`),
  CONSTRAINT `zaqvki_ibfk_2` FOREIGN KEY (`KLIENT_ID`) REFERENCES `klient` (`KLIENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zaqvki`
--

LOCK TABLES `zaqvki` WRITE;
/*!40000 ALTER TABLE `zaqvki` DISABLE KEYS */;
INSERT INTO `zaqvki` VALUES (1,1,3,'2026-04-01 00:00:00',4,'2026-04-04 00:00:00',1);
/*!40000 ALTER TABLE `zaqvki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `zaqvkiview`
--

DROP TABLE IF EXISTS `zaqvkiview`;
/*!50001 DROP VIEW IF EXISTS `zaqvkiview`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `zaqvkiview` AS SELECT 
 1 AS `zaem_id`,
 1 AS `marka_name`,
 1 AS `kolamodel`,
 1 AS `vid`,
 1 AS `godina`,
 1 AS `cvqt`,
 1 AS `ime_extra`,
 1 AS `cena_za_den`,
 1 AS `datazaemane`,
 1 AS `broidni`,
 1 AS `datavrushtane`,
 1 AS `izminatikilometri`,
 1 AS `img_url`,
 1 AS `avtomobil_id`,
 1 AS `klient`,
 1 AS `email`,
 1 AS `klient_ID`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping routines for database 'cars'
--
/*!50003 DROP PROCEDURE IF EXISTS `AddNewAvtomobil` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddNewAvtomobil`(
    IN p_marka VARCHAR(255),
    IN p_model VARCHAR(255),
    IN p_vid VARCHAR(255),
    IN p_godina INT,
    IN p_cvqt VARCHAR(255),
    IN p_ekstri VARCHAR(255),
    IN p_cenaZaDen DOUBLE,
    IN p_izminatiKilometri INT,
    IN p_img_url VARCHAR(255)
)
BEGIN
    DECLARE v_ekstri_id INT;
    DECLARE v_spec_id INT;
    DECLARE v_cvqt_id INT;
    DECLARE v_vid_id INT;
    DECLARE v_marka_id INT;
    DECLARE v_model_id INT;
    
    SELECT extra_Id INTO v_ekstri_id 
    FROM ekstri 
    WHERE UPPER(ime_extra) = UPPER(p_ekstri) 
    LIMIT 1;

    IF v_ekstri_id IS NULL THEN
        INSERT INTO ekstri (ime_extra) VALUES (p_ekstri);
        SET v_ekstri_id = LAST_INSERT_ID();
    END IF;
    
    SELECT cvqt_id INTO v_cvqt_id 
    FROM cvqt 
    WHERE UPPER(cvqt) = UPPER(p_cvqt) 
    LIMIT 1;

    IF v_cvqt_id IS NULL THEN
        INSERT INTO cvqt (cvqt) VALUES (p_cvqt);
        SET v_cvqt_id = LAST_INSERT_ID();
    END IF;
    
    SELECT vid_id INTO v_vid_id 
    FROM vid 
    WHERE UPPER(vid) = UPPER(p_vid)
    LIMIT 1;

    IF v_vid_id IS NULL THEN
        INSERT INTO vid (vid) VALUES (p_vid);
        SET v_vid_id = LAST_INSERT_ID();
    END IF;
    
    SELECT marka_id INTO v_marka_id 
    FROM marka 
    WHERE UPPER(marka_name) = UPPER(p_marka)
    LIMIT 1;

    IF v_marka_id IS NULL THEN
        INSERT INTO marka (marka_name) VALUES (p_marka);
        SET v_marka_id = LAST_INSERT_ID();
    END IF;
    
    SELECT model_id INTO v_model_id 
    FROM kolamodel 
    WHERE UPPER(kolamodel) = UPPER(p_model) AND marka_id = v_marka_id
    LIMIT 1;

    IF v_model_id IS NULL THEN
        INSERT INTO kolamodel (kolamodel, marka_id) VALUES (p_model, v_marka_id);
        SET v_marka_id = LAST_INSERT_ID();
    END IF;

    SELECT spec_id INTO v_spec_id
    FROM specifikacii
    WHERE model_id = v_model_id
      AND vid_id = v_vid_id
      AND ekstri_id = v_ekstri_id
      AND godina = p_godina
      AND cena_za_den = p_cenaZaDen
    LIMIT 1;

    IF v_spec_id IS NULL THEN
        INSERT INTO specifikacii (model_id, vid_id, ekstri_id, godina, cena_za_den)
        VALUES (v_model_id, v_vid_id, v_ekstri_id, p_godina, p_cenaZaDen);
        
        SET v_spec_id = LAST_INSERT_ID();
    END IF;

    INSERT INTO avtomobil (IZMINATIKILOMETRI, CVQT_ID, spec_id, img_url)
    VALUES (p_izminatiKilometri, v_cvqt_id, v_spec_id, p_img_url);
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `checkAvailability` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `checkAvailability`(
    IN p_avtomobil_id INT,
    IN p_data_zaemane DATETIME,
    IN p_data_vrushtane DATETIME,
    OUT p_is_free BOOLEAN
)
BEGIN
    DECLARE v_count INT;
    
    SELECT COUNT(*) INTO v_count
    FROM zaqvki
    WHERE avtomobil_id = p_avtomobil_id
      AND datazaemane < p_data_vrushtane
      AND datavrushtane > p_data_zaemane;

    -- Задаваме стойност на изходящия параметър
    IF v_count > 0 THEN
        SET p_is_free = FALSE;
    ELSE
        SET p_is_free = TRUE;
    END IF;
    
    IF p_data_zaemane > p_data_vrushtane THEN
    SET p_is_free = FALSE;
    END IF;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `clientRents` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `clientRents`(p_id INT)
BEGIN
SELECT * from zaqvkiview z LEFT JOIN zaqvki za on z.zaem_id = za.zaem_id WHERE za.klient_id = p_id ORDER BY z.datazaemane DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteCar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteCar`(p_id INT)
BEGIN
update avtomobil set isDeleted = true where avtomobil_id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteClient` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteClient`(p_id INT)
BEGIN
update klient set isDeleted = true where klient_id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `deleteRent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteRent`(p_id INT)
BEGIN
update zaqvki set isDeleted = true where zaem_id = p_id;
update otdadeni set isDeleted = true where zaem_id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `fetchCar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `fetchCar`(p_id INT)
BEGIN
SELECT * from avtomobilview where avtomobil_id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `fetchClient` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `fetchClient`(p_id INT)
BEGIN
SELECT * from klientview where klient_id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `fetchOtdadeni` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `fetchOtdadeni`()
BEGIN
SELECT * FROM otdadeniview WHERE DATAZAEMANE IS NOT NULL AND DATAVRUSHTANE IS NULL;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `fetchRent` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `fetchRent`(p_id INT)
BEGIN
SELECT * from zaqvkiview where zaem_id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `fetchZaOtdavane` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `fetchZaOtdavane`()
BEGIN
SELECT * from zaqvkiView JOIN zaqvki WHERE isDeleted = false;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `filteredAutomobiles` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `filteredAutomobiles`(
    p_avtomobil varchar(255),
    p_vid varchar(255),
    p_cvqt varchar(255),
    p_cena double,
    p_godina int,
    p_dataZaemane DATETIME,
    p_dataVrushtane DATETIME
)
BEGIN
    SELECT 
        a.avtomobil_id, 
        a.marka_name, 
        a.kolamodel, 
        a.vid, 
        a.godina, 
        a.cvqt, 
        a.ime_extra, 
        a.cena_za_den, 
        a.IZMINATIKILOMETRI, 
        a.img_url 
    FROM avtomobilview a 
    WHERE (CONCAT( a.marka_name, ' ',a.kolamodel) like CONCAT('%', p_avtomobil, '%') OR p_avtomobil IS NULL)
      AND (a.vid = p_vid OR p_vid IS NULL)
      AND (a.cvqt = p_cvqt OR p_cvqt IS NULL)
      AND (a.cena_za_den <= p_cena OR p_cena IS NULL)
      AND (a.godina = p_godina OR p_godina IS NULL)
      AND (
          p_dataZaemane IS NULL 
          OR p_dataVrushtane IS NULL 
          OR NOT EXISTS (
              SELECT 1 
              FROM zaqvki z 
              WHERE z.avtomobil_id = a.avtomobil_id
                AND z.datazaemane < p_dataVrushtane
                AND z.datavrushtane > p_dataZaemane
          )
      ) order by a.avtomobil_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getClients` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getClients`(p_ime VARCHAR(255))
BEGIN
SELECT * FROM cars.klientview where (ime like CONCAT('%', p_ime, '%') OR p_ime IS NULL);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `latestSixAutomobiles` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `latestSixAutomobiles`()
BEGIN
select * from avtomobilview ORDER BY avtomobilview.avtomobil_ID DESC LIMIT 6;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `login`(p_email VARCHAR(255), p_password VARCHAR(255))
BEGIN
SELECT 
        `k`.`KLIENT_ID` AS `KLIENT_ID`,
        `k`.`ime` AS `ime`,
        `k`.`ULICA` AS `ULICA`,
        `k`.`telefon` AS `telefon`,
        `k`.`email` AS `email`,
        `g`.`grad` AS `grad`,
        `d`.`durjava` AS `durjava`,
        `k`.`rolq` AS `rolq`
    FROM
        ((`klient` `k`
        JOIN `gradove` `g` ON ((`k`.`GRAD_ID` = `g`.`GRAD_ID`)))
        JOIN `durjavi` `d` ON ((`d`.`durjava_ID` = `g`.`durjava_ID`))) WHERE k.email = p_email AND k.password = p_password;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `newZaem` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `newZaem`(
IN p_avtomobil_id INT,
IN p_klient_id INT,
IN p_zaemane DATE,
IN p_vrushtane DATE,
IN p_broiDni INT
)
BEGIN
INSERT INTO zaqvki (klient_id, avtomobil_id, datazaemane, datavrushtane, broidni, isDeleted) VALUES
 (p_klient_id, p_avtomobil_id, p_zaemane, p_vrushtane, p_broiDni, false);
 INSERT INTO otdadeni (klient_id, avtomobil_id, datazaemane, datavrushtane, broidni, isDeleted) VALUES
 (p_klient_id, p_avtomobil_id, null, null, null, false);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `otdavane` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `otdavane`(p_id INT, p_otdavane DATETIME)
BEGIN
UPDATE otdadeni SET DATAZAEMANE = p_otdavane WHERE otdadeni.zaem_id = p_id;
UPDATE zaqvki SET isDeleted = true where zaem_id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `register` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `register`(p_ime VARCHAR(255), p_email VARCHAR(255), p_password VARCHAR(255), p_telefon VARCHAR(255), p_ulica varchar(255), p_grad varchar(255), p_durjava varchar(255))
BEGIN
declare v_gradId INT;
declare v_durjavaId INT;
declare v_klientId INT;

SELECT durjava_id INTO v_durjavaId 
    FROM durjavi 
    WHERE durjava = p_durjava 
    LIMIT 1;

    IF v_durjavaId IS NULL THEN
        INSERT INTO durjavi (durjava) VALUES (p_durjava);
        SET v_durjavaId = LAST_INSERT_ID();
    END IF;
    
    SELECT grad_id INTO v_gradId 
    FROM gradove 
    WHERE grad = p_grad 
    LIMIT 1;

    IF v_gradId IS NULL THEN
        INSERT INTO gradove (grad, durjava_ID) VALUES (p_grad, v_durjavaId);
        SET v_gradId = LAST_INSERT_ID();
    END IF;
    
    SELECT klient_id INTO v_klientId 
    FROM klient 
    WHERE email = p_email 
    LIMIT 1;
    
    if v_klientId IS NULL THEN
		INSERT INTO klient(ime, grad_id, ulica, telefon, email, password, rolq) VALUES (p_ime, v_gradId, p_ulica, p_telefon, p_email, p_password, 'user');
	else
    SIGNAL SQLSTATE '45001' SET MESSAGE_TEXT = 'Sushtestvuva takuv email';
    end if;

SELECT 
        `k`.`KLIENT_ID` AS `KLIENT_ID`,
        `k`.`ime` AS `ime`,
        `k`.`ULICA` AS `ULICA`,
        `k`.`telefon` AS `telefon`,
        `k`.`email` AS `email`,
        `g`.`grad` AS `grad`,
        `d`.`durjava` AS `durjava`,
        `k`.`rolq` AS `rolq`
    FROM
        ((`klient` `k`
        JOIN `gradove` `g` ON ((`k`.`GRAD_ID` = `g`.`GRAD_ID`)))
        JOIN `durjavi` `d` ON ((`d`.`durjava_ID` = `g`.`durjava_ID`))) WHERE k.email = p_email AND k.password = p_password;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateCar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateCar`(
	IN p_id INT,
    IN p_marka VARCHAR(255),
    IN p_model VARCHAR(255),
    IN p_vid VARCHAR(255),
    IN p_godina INT,
    IN p_cvqt VARCHAR(255),
    IN p_ekstri VARCHAR(255),
    IN p_cenaZaDen DOUBLE,
    IN p_izminatiKilometri INT,
    IN p_img_url VARCHAR(255)
)
BEGIN
    DECLARE v_ekstri_id INT;
    DECLARE v_spec_id INT;
    DECLARE v_cvqt_id INT;
    DECLARE v_vid_id INT;
    DECLARE v_marka_id INT;
    DECLARE v_model_id INT;
    
    SELECT extra_Id INTO v_ekstri_id 
    FROM ekstri 
    WHERE UPPER(ime_extra) = UPPER(p_ekstri) 
    LIMIT 1;

    IF v_ekstri_id IS NULL THEN
        INSERT INTO ekstri (ime_extra) VALUES (p_ekstri);
        SET v_ekstri_id = LAST_INSERT_ID();
    END IF;
    
    SELECT cvqt_id INTO v_cvqt_id 
    FROM cvqt 
    WHERE UPPER(cvqt) = UPPER(p_cvqt) 
    LIMIT 1;

    IF v_cvqt_id IS NULL THEN
        INSERT INTO cvqt (cvqt) VALUES (p_cvqt);
        SET v_cvqt_id = LAST_INSERT_ID();
    END IF;
    
    SELECT vid_id INTO v_vid_id 
    FROM vid 
    WHERE UPPER(vid) = UPPER(p_vid)
    LIMIT 1;

    IF v_vid_id IS NULL THEN
        INSERT INTO vid (vid) VALUES (p_vid);
        SET v_vid_id = LAST_INSERT_ID();
    END IF;
    
    SELECT marka_id INTO v_marka_id 
    FROM marka 
    WHERE UPPER(marka_name) = UPPER(p_marka)
    LIMIT 1;

    IF v_marka_id IS NULL THEN
        INSERT INTO marka (marka_name) VALUES (p_marka);
        SET v_marka_id = LAST_INSERT_ID();
    END IF;
    
    SELECT model_id INTO v_model_id 
    FROM kolamodel 
    WHERE UPPER(kolamodel) = UPPER(p_model) AND marka_id = v_marka_id
    LIMIT 1;

    IF v_model_id IS NULL THEN
        INSERT INTO kolamodel (kolamodel, marka_id) VALUES (p_model, v_marka_id);
        SET v_marka_id = LAST_INSERT_ID();
    END IF;

    SELECT spec_id INTO v_spec_id
    FROM specifikacii
    WHERE model_id = v_model_id
      AND vid_id = v_vid_id
      AND ekstri_id = v_ekstri_id
      AND godina = p_godina
      AND cena_za_den = p_cenaZaDen
    LIMIT 1;

    IF v_spec_id IS NULL THEN
        INSERT INTO specifikacii (model_id, vid_id, ekstri_id, godina, cena_za_den)
        VALUES (v_model_id, v_vid_id, v_ekstri_id, p_godina, p_cenaZaDen);
        
        SET v_spec_id = LAST_INSERT_ID();
    END IF;

    UPDATE avtomobil SET IZMINATIKILOMETRI = p_izminatiKilometri, CVQT_ID = v_cvqt_id, spec_id = v_spec_id, img_url = p_img_url WHERE avtomobil_id = p_id;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateClient` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateClient`(
p_id INT,
p_ime VARCHAR(255),
p_email VARCHAR(255),
p_telefon VARCHAR(255),
p_ulica VARCHAR(255),
p_grad VARCHAR(255),
p_durjava VARCHAR(255),
p_rolq VARCHAR(255)
)
BEGIN
declare v_gradId INT;
declare v_durjavaId INT;
declare v_klientId INT;

SELECT durjava_id INTO v_durjavaId 
    FROM durjavi 
    WHERE durjava = p_durjava 
    LIMIT 1;

    IF v_durjavaId IS NULL THEN
        INSERT INTO durjavi (durjava) VALUES (p_durjava);
        SET v_durjavaId = LAST_INSERT_ID();
    END IF;
    
    SELECT grad_id INTO v_gradId 
    FROM gradove 
    WHERE grad = p_grad 
    LIMIT 1;

    IF v_gradId IS NULL THEN
        INSERT INTO gradove (grad, durjava_ID) VALUES (p_grad, v_durjavaId);
        SET v_gradId = LAST_INSERT_ID();
    END IF;
    
    SELECT klient_id INTO v_klientId 
    FROM klient 
    WHERE email = p_email AND KLIENT_ID != p_id
    LIMIT 1;
    
    if v_klientId IS NULL THEN
		UPDATE klient SET ime = p_ime, grad_id = v_gradId, ulica = p_ulica, telefon = p_telefon, email = p_email, rolq = p_rolq where KLIENT_ID = p_id;
	else
    SIGNAL SQLSTATE '45001' SET MESSAGE_TEXT = 'Sushtestvuva takuv email';
    end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateZaem` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateZaem`(
IN p_id INT,
IN p_avtomobil_id INT,
IN p_klient_id INT,
IN p_zaemane DATE,
IN p_vrushtane DATE,
IN p_broiDni INT
)
BEGIN
UPDATE zaqvki SET klient_id = p_klient_id, avtomobil_id = p_avtomobil_id, datazaemane = p_zaemane,
 datavrushtane = p_vrushtane, broidni = p_broiDni WHERE ZAEM_ID = p_id;
 
 UPDATE otdadeni SET klient_id = p_klient_id, avtomobil_id = p_avtomobil_id WHERE ZAEM_ID = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `vrushtane` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `vrushtane`(p_id INT, p_vrushtane DATETIME)
BEGIN
UPDATE otdadeni SET DATAVRUSHTANE = p_vrushtane, BROIDNI = DATEDIFF(datavrushtane, datazaemane) + 1 WHERE otdadeni.zaem_id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `avtomobilview`
--

/*!50001 DROP VIEW IF EXISTS `avtomobilview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `avtomobilview` AS select `a`.`AVTOMOBIL_ID` AS `avtomobil_ID`,`m`.`marka_name` AS `marka_name`,`k`.`kolamodel` AS `kolamodel`,`v`.`vid` AS `vid`,`s`.`godina` AS `godina`,`c`.`cvqt` AS `cvqt`,`e`.`ime_extra` AS `ime_extra`,`s`.`cena_za_den` AS `cena_za_den`,`a`.`IZMINATIKILOMETRI` AS `IZMINATIKILOMETRI`,`a`.`img_url` AS `img_url` from ((((((`avtomobil` `a` join `specifikacii` `s` on((`a`.`spec_id` = `s`.`spec_ID`))) join `ekstri` `e` on((`e`.`extra_Id` = `s`.`ekstri_id`))) join `vid` `v` on((`s`.`vid_id` = `v`.`VID_ID`))) join `kolamodel` `k` on((`k`.`MODEL_ID` = `s`.`model_id`))) join `marka` `m` on((`m`.`MARKA_ID` = `k`.`MARKA_ID`))) join `cvqt` `c` on((`c`.`CVQT_ID` = `a`.`CVQT_ID`))) where (`a`.`isDeleted` = false) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `klientview`
--

/*!50001 DROP VIEW IF EXISTS `klientview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `klientview` AS select `k`.`KLIENT_ID` AS `KLIENT_ID`,`k`.`ime` AS `ime`,`k`.`ULICA` AS `ULICA`,`k`.`telefon` AS `telefon`,`k`.`email` AS `email`,`g`.`grad` AS `grad`,`d`.`durjava` AS `durjava`,`k`.`rolq` AS `rolq` from ((`klient` `k` join `gradove` `g` on((`k`.`GRAD_ID` = `g`.`GRAD_ID`))) join `durjavi` `d` on((`d`.`durjava_ID` = `g`.`durjava_ID`))) where (`k`.`isDeleted` = false) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `otdadeniview`
--

/*!50001 DROP VIEW IF EXISTS `otdadeniview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `otdadeniview` AS select `o`.`ZAEM_ID` AS `zaem_id`,`m`.`marka_name` AS `marka_name`,`k`.`kolamodel` AS `kolamodel`,`v`.`vid` AS `vid`,`s`.`godina` AS `godina`,`c`.`cvqt` AS `cvqt`,`e`.`ime_extra` AS `ime_extra`,`s`.`cena_za_den` AS `cena_za_den`,`o`.`DATAZAEMANE` AS `datazaemane`,`o`.`BROIDNI` AS `broidni`,`o`.`DATAVRUSHTANE` AS `datavrushtane`,`a`.`IZMINATIKILOMETRI` AS `izminatikilometri`,`a`.`img_url` AS `img_url`,`a`.`AVTOMOBIL_ID` AS `avtomobil_id`,`kl`.`ime` AS `klient`,`kl`.`email` AS `email`,`kl`.`KLIENT_ID` AS `klient_ID` from ((((((((`otdadeni` `o` join `klient` `kl` on((`o`.`KLIENT_ID` = `kl`.`KLIENT_ID`))) join `avtomobil` `a` on((`a`.`AVTOMOBIL_ID` = `o`.`AVTOMOBIL_ID`))) join `specifikacii` `s` on((`a`.`spec_id` = `s`.`spec_ID`))) join `ekstri` `e` on((`e`.`extra_Id` = `s`.`ekstri_id`))) join `vid` `v` on((`s`.`vid_id` = `v`.`VID_ID`))) join `kolamodel` `k` on((`k`.`MODEL_ID` = `s`.`model_id`))) join `marka` `m` on((`m`.`MARKA_ID` = `k`.`MARKA_ID`))) join `cvqt` `c` on((`c`.`CVQT_ID` = `a`.`CVQT_ID`))) where (`o`.`isDeleted` = false) order by `o`.`DATAZAEMANE` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `zaqvkiview`
--

/*!50001 DROP VIEW IF EXISTS `zaqvkiview`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `zaqvkiview` AS select `z`.`ZAEM_ID` AS `zaem_id`,`m`.`marka_name` AS `marka_name`,`k`.`kolamodel` AS `kolamodel`,`v`.`vid` AS `vid`,`s`.`godina` AS `godina`,`c`.`cvqt` AS `cvqt`,`e`.`ime_extra` AS `ime_extra`,`s`.`cena_za_den` AS `cena_za_den`,`z`.`DATAZAEMANE` AS `datazaemane`,`z`.`BROIDNI` AS `broidni`,`z`.`DATAVRUSHTANE` AS `datavrushtane`,`a`.`IZMINATIKILOMETRI` AS `izminatikilometri`,`a`.`img_url` AS `img_url`,`a`.`AVTOMOBIL_ID` AS `avtomobil_id`,`kl`.`ime` AS `klient`,`kl`.`email` AS `email`,`kl`.`KLIENT_ID` AS `klient_ID` from ((((((((`zaqvki` `z` join `klient` `kl` on((`z`.`KLIENT_ID` = `kl`.`KLIENT_ID`))) join `avtomobil` `a` on((`a`.`AVTOMOBIL_ID` = `z`.`AVTOMOBIL_ID`))) join `specifikacii` `s` on((`a`.`spec_id` = `s`.`spec_ID`))) join `ekstri` `e` on((`e`.`extra_Id` = `s`.`ekstri_id`))) join `vid` `v` on((`s`.`vid_id` = `v`.`VID_ID`))) join `kolamodel` `k` on((`k`.`MODEL_ID` = `s`.`model_id`))) join `marka` `m` on((`m`.`MARKA_ID` = `k`.`MARKA_ID`))) join `cvqt` `c` on((`c`.`CVQT_ID` = `a`.`CVQT_ID`))) where (`z`.`isDeleted` = false) order by `z`.`DATAZAEMANE` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-17 16:36:17
