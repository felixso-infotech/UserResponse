-- MySQL dump 10.13  Distrib 5.5.23, for Win64 (x86)
--
-- Host: localhost    Database: userresponse
-- ------------------------------------------------------
-- Server version	5.5.23

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
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `commited_activity_id` bigint(20) DEFAULT NULL,
  `completed_challenge_id` bigint(20) DEFAULT NULL,
  `date_and_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='Comment entity. @author Anjali';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'good work','Freeman',3,NULL,'2019-08-23 20:09:28'),(2,'good','Joli',3,NULL,'2019-07-23 20:09:28'),(3,'thank you all','Sharai',3,NULL,'2019-06-23 20:09:28'),(4,'haha','Joli',3,NULL,'2019-03-23 20:09:28'),(5,'wow','Doy',3,NULL,'2019-02-23 20:09:28'),(6,'wow','Jerry',3,NULL,'2019-06-23 20:09:28'),(7,'wow','Jerry',4,NULL,'2019-08-23 20:09:28'),(8,'wow','Doy',4,NULL,'2019-08-20 20:09:28'),(9,'wow','Joli',4,NULL,'2019-09-21 20:09:28'),(10,'good job','Jerry',4,NULL,'2019-08-24 20:09:28'),(11,'thank you','Sharai',4,NULL,'2019-04-23 20:09:28'),(12,'good','Joli',5,NULL,'2019-08-21 20:09:28'),(13,'nice','Jerry',5,NULL,'2019-08-10 20:09:28'),(14,'good job','Sharai',5,NULL,'2019-08-13 20:09:28'),(15,'woow','Doy',5,NULL,'2019-08-19 20:09:28'),(16,'Thnkss','Freeman',5,NULL,'2019-08-16 20:09:28'),(17,'lovely','Sharai',6,NULL,'2019-08-15 20:09:28'),(18,'good','Doy',6,NULL,'2019-08-23 20:09:28'),(19,'good','Jerry',6,NULL,'2019-08-23 20:09:28'),(20,'good','Joli',6,NULL,'2019-08-23 20:09:28'),(21,'thanks','Freeman',6,NULL,'2019-08-23 20:09:28'),(22,'wow','Jerry',9,NULL,'2019-08-23 20:09:28'),(23,'super','Sharai',9,NULL,'2019-08-23 20:09:28'),(24,'excellent','Doy',9,NULL,'2019-08-23 20:09:28'),(25,'good','Freeman',9,NULL,'2019-08-23 20:09:28'),(26,'thank you','Joli',9,NULL,'2019-08-23 20:09:28'),(27,'good work','Freeman',10,NULL,'2019-08-23 20:09:28'),(28,'nice','Jerry',10,NULL,'2019-08-13 20:09:28'),(29,'haii','Doy',10,NULL,'2019-08-14 20:09:28'),(30,'good','Sharai',10,NULL,'2019-08-10 20:09:28'),(31,'thanks','Joli',10,NULL,'2019-06-23 20:09:28'),(32,'good','Freeman',14,NULL,'2019-09-23 20:09:28'),(33,'good','Jerry',14,NULL,'2019-07-23 20:09:28'),(34,'nice','Joli',14,NULL,'2019-04-23 20:09:28'),(35,'lovely','Sharai',14,NULL,'2019-08-23 20:09:28'),(36,'thanks','Doy',14,NULL,'2019-09-21 20:09:28'),(37,'good','Jerry',15,NULL,'2019-09-24 20:09:28'),(38,'good job','Joli',15,NULL,'2019-08-23 20:09:28'),(39,'good work','Freeman',15,NULL,'2019-08-23 20:09:28'),(40,'nice','Sharai',15,NULL,'2019-08-23 20:09:28'),(41,'thank you','Doy',15,NULL,'2019-08-23 20:09:28'),(42,'good ','Freeman',18,NULL,'2019-08-23 20:09:28'),(43,'good','Doy',18,NULL,'2019-08-23 20:09:28'),(44,'good','Sharai',18,NULL,'2019-08-22 20:09:28'),(45,'good job','Joli',18,NULL,'2019-05-13 20:09:28'),(46,'thanks','Jerry',18,NULL,'2019-08-23 20:09:28'),(47,'good','Joli',20,NULL,'2019-08-23 20:09:28'),(48,'good','Sharai',20,NULL,'2019-08-23 20:09:28'),(49,'good job','Freeman',20,NULL,'2019-08-23 20:09:28'),(50,'good work','Doy',20,NULL,'2019-08-23 20:09:28'),(51,'tq','Jerry',20,NULL,'2019-08-23 20:09:28');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databasechangelog`
--

DROP TABLE IF EXISTS `databasechangelog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `databasechangelog` (
  `ID` varchar(255) NOT NULL,
  `AUTHOR` varchar(255) NOT NULL,
  `FILENAME` varchar(255) NOT NULL,
  `DATEEXECUTED` datetime NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) NOT NULL,
  `MD5SUM` varchar(35) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TAG` varchar(255) DEFAULT NULL,
  `LIQUIBASE` varchar(20) DEFAULT NULL,
  `CONTEXTS` varchar(255) DEFAULT NULL,
  `LABELS` varchar(255) DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangelog`
--

LOCK TABLES `databasechangelog` WRITE;
/*!40000 ALTER TABLE `databasechangelog` DISABLE KEYS */;
INSERT INTO `databasechangelog` VALUES ('00000000000001','jhipster','config/liquibase/changelog/00000000000000_initial_schema.xml','2019-08-24 12:13:32',1,'EXECUTED','7:3628d21006c83bc696d51a75927e556f','createTable tableName=jhi_user; createTable tableName=jhi_authority; createTable tableName=jhi_user_authority; addPrimaryKey tableName=jhi_user_authority; addForeignKeyConstraint baseTableName=jhi_user_authority, constraintName=fk_authority_name, ...','',NULL,'3.5.4',NULL,NULL,'6628994717'),('20190823042043-1','jhipster','config/liquibase/changelog/20190823042043_added_entity_Love.xml','2019-08-24 12:13:33',2,'EXECUTED','7:12442d83d9b47e0f4781ca909927a76f','createTable tableName=love; dropDefaultValue columnName=date_and_time, tableName=love','',NULL,'3.5.4',NULL,NULL,'6628994717'),('20190823042044-1','jhipster','config/liquibase/changelog/20190823042044_added_entity_Comment.xml','2019-08-24 12:13:34',3,'EXECUTED','7:0e09bea6c737776e64641f0b1961c9b7','createTable tableName=comment; dropDefaultValue columnName=date_and_time, tableName=comment','',NULL,'3.5.4',NULL,NULL,'6628994717'),('20190823042045-1','jhipster','config/liquibase/changelog/20190823042045_added_entity_Reply.xml','2019-08-24 12:13:35',4,'EXECUTED','7:873e43243d733b10f4e983b87f080a70','createTable tableName=reply; dropDefaultValue columnName=date_and_time, tableName=reply','',NULL,'3.5.4',NULL,NULL,'6628994717'),('20190823042043-2','jhipster','config/liquibase/changelog/20190823042043_added_entity_constraints_Love.xml','2019-08-24 12:13:40',5,'EXECUTED','7:800bcdaabcd0c995453daa48a330a390','addForeignKeyConstraint baseTableName=love, constraintName=fk_love_comment_id, referencedTableName=comment; addForeignKeyConstraint baseTableName=love, constraintName=fk_love_reply_id, referencedTableName=reply','',NULL,'3.5.4',NULL,NULL,'6628994717'),('20190823042045-2','jhipster','config/liquibase/changelog/20190823042045_added_entity_constraints_Reply.xml','2019-08-24 12:13:41',6,'EXECUTED','7:20c54caa16572308342376bdbe1c083b','addForeignKeyConstraint baseTableName=reply, constraintName=fk_reply_comment_id, referencedTableName=comment','',NULL,'3.5.4',NULL,NULL,'6628994717');
/*!40000 ALTER TABLE `databasechangelog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databasechangeloglock`
--

DROP TABLE IF EXISTS `databasechangeloglock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `databasechangeloglock` (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime DEFAULT NULL,
  `LOCKEDBY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databasechangeloglock`
--

LOCK TABLES `databasechangeloglock` WRITE;
/*!40000 ALTER TABLE `databasechangeloglock` DISABLE KEYS */;
INSERT INTO `databasechangeloglock` VALUES (1,'\0',NULL,NULL);
/*!40000 ALTER TABLE `databasechangeloglock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_authority`
--

DROP TABLE IF EXISTS `jhi_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_authority` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_authority`
--

LOCK TABLES `jhi_authority` WRITE;
/*!40000 ALTER TABLE `jhi_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `jhi_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_persistent_audit_event`
--

DROP TABLE IF EXISTS `jhi_persistent_audit_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_persistent_audit_event` (
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `principal` varchar(50) NOT NULL,
  `event_date` timestamp NULL DEFAULT NULL,
  `event_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  KEY `idx_persistent_audit_event` (`principal`,`event_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_persistent_audit_event`
--

LOCK TABLES `jhi_persistent_audit_event` WRITE;
/*!40000 ALTER TABLE `jhi_persistent_audit_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `jhi_persistent_audit_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_persistent_audit_evt_data`
--

DROP TABLE IF EXISTS `jhi_persistent_audit_evt_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_persistent_audit_evt_data` (
  `event_id` bigint(20) NOT NULL,
  `name` varchar(150) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`event_id`,`name`),
  KEY `idx_persistent_audit_evt_data` (`event_id`),
  CONSTRAINT `fk_evt_pers_audit_evt_data` FOREIGN KEY (`event_id`) REFERENCES `jhi_persistent_audit_event` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_persistent_audit_evt_data`
--

LOCK TABLES `jhi_persistent_audit_evt_data` WRITE;
/*!40000 ALTER TABLE `jhi_persistent_audit_evt_data` DISABLE KEYS */;
/*!40000 ALTER TABLE `jhi_persistent_audit_evt_data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_user`
--

DROP TABLE IF EXISTS `jhi_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_user` (
  `id` varchar(100) NOT NULL,
  `login` varchar(50) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(254) DEFAULT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  `activated` bit(1) NOT NULL,
  `lang_key` varchar(6) DEFAULT NULL,
  `created_by` varchar(50) NOT NULL,
  `created_date` timestamp NULL DEFAULT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_user_login` (`login`),
  UNIQUE KEY `ux_user_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_user`
--

LOCK TABLES `jhi_user` WRITE;
/*!40000 ALTER TABLE `jhi_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `jhi_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jhi_user_authority`
--

DROP TABLE IF EXISTS `jhi_user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jhi_user_authority` (
  `user_id` varchar(100) NOT NULL,
  `authority_name` varchar(50) NOT NULL,
  PRIMARY KEY (`user_id`,`authority_name`),
  KEY `fk_authority_name` (`authority_name`),
  CONSTRAINT `fk_authority_name` FOREIGN KEY (`authority_name`) REFERENCES `jhi_authority` (`name`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `jhi_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jhi_user_authority`
--

LOCK TABLES `jhi_user_authority` WRITE;
/*!40000 ALTER TABLE `jhi_user_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `jhi_user_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `love`
--

DROP TABLE IF EXISTS `love`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `love` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `commited_activity_id` bigint(20) DEFAULT NULL,
  `completed_challenge_id` bigint(20) DEFAULT NULL,
  `date_and_time` datetime DEFAULT NULL,
  `comment_id` bigint(20) DEFAULT NULL,
  `reply_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_love_comment_id` (`comment_id`),
  KEY `fk_love_reply_id` (`reply_id`),
  CONSTRAINT `fk_love_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`),
  CONSTRAINT `fk_love_reply_id` FOREIGN KEY (`reply_id`) REFERENCES `reply` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8 COMMENT='Love entity. @author Anjali';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `love`
--

LOCK TABLES `love` WRITE;
/*!40000 ALTER TABLE `love` DISABLE KEYS */;
INSERT INTO `love` VALUES (1,'Freeman',3,NULL,'2019-08-22 20:09:28',NULL,NULL),(2,'Joli',3,NULL,'2019-08-22 20:09:28',NULL,NULL),(3,'Sharai',3,NULL,'2019-08-22 20:09:28',NULL,NULL),(4,'Doy',3,NULL,'2019-08-23 20:09:28',NULL,NULL),(5,'Jerry',3,NULL,'2019-08-23 20:09:28',NULL,NULL),(6,'Sharai',NULL,NULL,'2019-08-23 20:09:28',5,NULL),(7,'Joli',NULL,NULL,'2019-08-23 20:09:28',5,NULL),(8,'Doy',NULL,NULL,'2019-08-23 20:09:28',6,NULL),(9,'Freeman',NULL,NULL,'2019-08-23 20:09:28',NULL,1),(10,'Joli',NULL,NULL,'2019-08-23 20:09:28',NULL,2),(11,'Jerry',4,NULL,'2019-08-23 20:09:28',NULL,NULL),(12,'Freeman',4,NULL,'2019-08-23 20:09:28',NULL,NULL),(13,'Doy',4,NULL,'2019-08-22 20:09:28',NULL,NULL),(14,'Sharai',4,NULL,'2019-08-22 20:09:28',NULL,NULL),(15,'Sharai',NULL,NULL,'2019-08-22 20:09:28',8,NULL),(16,'Joli',NULL,NULL,'2019-08-22 20:09:28',8,NULL),(17,'Joli',NULL,NULL,'2019-08-22 20:09:28',9,NULL),(18,'Freeman',NULL,NULL,'2019-08-22 20:09:28',NULL,4),(19,'Doy',NULL,NULL,'2019-08-22 20:09:28',NULL,4),(20,'Freeman',5,NULL,'2019-08-22 20:09:28',NULL,NULL),(21,'Joli',5,NULL,'2019-08-22 20:09:28',NULL,NULL),(22,'Sharai',5,NULL,'2019-08-22 20:09:28',NULL,NULL),(23,'Doy',NULL,NULL,'2019-08-22 20:09:28',12,NULL),(24,'Doy',NULL,NULL,'2019-08-22 20:09:28',13,NULL),(25,'Joli',NULL,NULL,'2019-08-22 20:09:28',NULL,9),(26,'Freeman',NULL,NULL,'2019-08-22 20:09:28',NULL,9),(27,'Joli',6,NULL,'2019-08-22 20:09:28',NULL,NULL),(28,'Sharai',6,NULL,'2019-08-22 20:09:28',NULL,NULL),(29,'Doy',6,NULL,'2019-08-22 20:09:28',NULL,NULL),(30,'Jerry',NULL,NULL,'2019-08-22 20:09:28',18,NULL),(31,'Sharai',NULL,NULL,'2019-08-22 20:09:28',18,NULL),(32,'Sharai',NULL,NULL,'2019-08-22 20:09:28',NULL,12),(33,'Jerry',NULL,NULL,'2019-08-22 20:09:28',NULL,12),(34,'Sharai',NULL,NULL,'2019-08-22 20:09:28',NULL,13),(35,'Joli',9,NULL,'2019-08-22 20:09:28',NULL,13),(36,'Doy',9,NULL,'2019-08-22 20:09:28',NULL,13),(37,'Sharai',9,NULL,'2019-08-22 20:09:28',NULL,NULL),(38,'Joli',NULL,NULL,'2019-08-22 20:09:28',22,NULL),(39,'Freeman',NULL,NULL,'2019-08-22 20:09:28',23,NULL),(40,'Jerry',NULL,NULL,'2019-08-22 20:09:28',NULL,15),(41,'Sharai',NULL,NULL,'2019-08-22 20:09:28',NULL,16),(42,'Jerry',10,NULL,'2019-08-22 20:09:28',NULL,NULL),(43,'Freeman',10,NULL,'2019-08-22 20:09:28',NULL,NULL),(44,'Doy',NULL,NULL,'2019-08-22 20:09:28',27,NULL),(45,'Freeman',NULL,NULL,'2019-08-22 20:09:28',29,NULL),(46,'Joli',NULL,NULL,'2019-08-22 20:09:28',NULL,18),(47,'Jerry',NULL,NULL,'2019-08-22 20:09:28',NULL,19),(48,'Freeman',14,NULL,'2019-08-22 20:09:28',NULL,NULL),(49,'Joli',14,NULL,'2019-08-22 20:09:28',NULL,NULL),(50,'Jerry',14,NULL,'2019-08-22 20:09:28',NULL,NULL),(51,'Jerry',NULL,NULL,'2019-08-22 20:09:28',32,NULL),(52,'Freeman',NULL,NULL,'2019-08-22 20:09:28',32,NULL),(53,'Jerry',NULL,NULL,'2019-08-22 20:09:28',NULL,21),(54,'Jerry',NULL,NULL,'2019-08-22 20:09:28',NULL,20),(55,'Freeman',15,NULL,'2019-08-22 20:09:28',NULL,NULL),(56,'Jerry',15,NULL,'2019-08-22 20:09:28',NULL,NULL),(57,'Sharai',15,NULL,'2019-08-22 20:09:28',NULL,NULL),(58,'Doy',NULL,NULL,'2019-08-22 20:09:28',37,NULL),(59,'Jerry',NULL,NULL,'2019-08-22 20:09:28',38,NULL),(60,'Doy',NULL,NULL,'2019-08-22 20:09:28',39,NULL),(61,'Freeman',NULL,NULL,'2019-08-22 20:09:28',NULL,23),(62,'Jerry',NULL,NULL,'2019-08-22 20:09:28',NULL,24),(63,'Freeman',18,NULL,'2019-08-22 20:09:28',NULL,NULL),(64,'Doy',18,NULL,'2019-08-22 20:09:28',NULL,NULL),(65,'Sharai',18,NULL,'2019-08-22 20:09:28',NULL,NULL),(66,'Jerry',18,NULL,'2019-08-22 20:09:28',NULL,NULL),(67,'Sharai',NULL,NULL,'2019-08-22 20:09:28',44,NULL),(68,'Freeman',NULL,NULL,'2019-08-22 20:09:28',44,NULL),(69,'Joli',NULL,NULL,'2019-08-22 20:09:28',46,NULL),(70,'Joli',NULL,NULL,'2019-08-22 20:09:28',NULL,27),(71,'Joli',NULL,NULL,'2019-08-22 20:09:28',NULL,28),(72,'Sharai',20,NULL,'2019-08-22 20:09:28',NULL,NULL),(73,'Freeman',20,NULL,'2019-08-22 20:09:28',NULL,NULL),(74,'Joli',20,NULL,'2019-08-22 20:09:28',NULL,NULL),(75,'Jerry',20,NULL,'2019-08-22 20:09:28',NULL,NULL),(76,'Sharai',NULL,NULL,'2019-08-22 20:09:28',47,NULL),(77,'Joli',NULL,NULL,'2019-08-22 20:09:28',47,NULL),(78,'Joli',NULL,NULL,'2019-08-22 20:09:28',49,NULL),(79,'Freeman',NULL,NULL,'2019-08-22 20:09:28',50,NULL),(80,'Sharai',NULL,NULL,'2019-08-22 20:09:28',NULL,29),(81,'Joli',NULL,NULL,'2019-08-22 20:09:28',NULL,30),(82,'Freeman',NULL,NULL,'2019-08-22 20:09:28',NULL,31);
/*!40000 ALTER TABLE `love` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `date_and_time` datetime DEFAULT NULL,
  `comment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reply_comment_id` (`comment_id`),
  CONSTRAINT `fk_reply_comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='Reply entity. @author Anjali';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (1,'tq','Sharai','2019-08-22 20:09:28',1),(2,'thanku','Sharai','2019-08-20 20:09:28',2),(3,'thanku','Sharai','2019-08-21 20:09:28',4),(4,'thanku sir','Sharai','2019-08-22 20:09:28',7),(5,'thanku sir','Sharai','2019-08-22 20:09:28',8),(6,'thanku','Sharai','2019-06-21 20:09:28',9),(7,'thanku','Sharai','2019-07-12 20:09:28',10),(8,'thanku','Freeman','2019-07-12 20:09:28',12),(9,'thanks','Freeman','2019-07-12 20:09:28',13),(10,'tq','Freeman','2019-07-12 20:09:28',14),(11,'tqu','Freeman','2019-07-12 20:09:28',15),(12,'thanku','Freeman','2019-07-12 20:09:28',18),(13,'taks','Freeman','2019-07-12 20:09:28',19),(14,'thanku dear','Freeman','2019-07-12 20:09:28',20),(15,'thanku','Joli','2019-07-12 20:09:28',23),(16,'tq','Joli','2019-07-12 20:09:28',24),(17,'thanku dear','Joli','2019-07-12 20:09:28',25),(18,'thanku','Joli','2019-07-12 20:09:28',29),(19,'thanku','Joli','2019-07-12 20:09:28',30),(20,'thanku','Doy','2019-07-12 20:09:28',33),(21,'tq','Doy','2019-07-12 20:09:28',34),(22,'tquu','Doy','2019-07-12 20:09:28',35),(23,'tquu ','Doy','2019-07-12 20:09:28',38),(24,'tquu','Doy','2019-07-12 20:09:28',39),(25,'tquu','Doy','2019-07-12 20:09:28',40),(26,'tquu','Jerry','2019-07-12 20:09:28',43),(27,'thanks','Jerry','2019-07-12 20:09:28',44),(28,'thanks','Jerry','2019-07-12 20:09:28',45),(29,'thank u','Jerry','2019-07-12 20:09:28',48),(30,'thanks dear','Jerry','2019-07-12 20:09:28',49),(31,'thanks','Jerry','2019-07-12 20:09:28',50),(32,'nice','Joli','2019-07-12 20:09:28',50);
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-27 15:57:07
