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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='Comment entity. @author Anjali';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'good work','anjali',8,1,'2019-08-21 20:09:28'),(2,'good','sarangi',8,1,'2019-08-22 20:09:28'),(3,'good job','sanil',6,1,'2019-08-22 20:09:28'),(4,'good job','anjali',3,1,'2019-08-22 20:09:28'),(5,'wow','ruhail',6,1,'2019-08-21 20:09:28');
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
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='Love entity. @author Anjali';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `love`
--

LOCK TABLES `love` WRITE;
/*!40000 ALTER TABLE `love` DISABLE KEYS */;
INSERT INTO `love` VALUES (1,'anjali',8,1,'2019-08-22 20:09:28',NULL,NULL),(2,'sarangi',8,1,'2019-08-22 20:09:28',NULL,NULL),(3,'ruhail',3,1,'2019-08-22 20:09:28',NULL,NULL),(6,'sanil',3,1,'2019-08-23 20:09:28',NULL,NULL),(7,'sarangi',3,1,'2019-08-23 20:09:28',NULL,NULL),(8,'sanil',6,1,'2019-08-23 20:09:28',NULL,NULL),(9,'sanil',6,1,'2019-08-23 20:09:28',NULL,NULL),(10,'anjali',6,1,'2019-08-23 20:09:28',2,NULL),(14,'anjali',6,1,'2019-08-23 20:09:28',NULL,1),(15,'anjali',3,1,'2019-08-23 20:09:28',NULL,3),(16,'ruhail',8,1,'2019-08-23 20:09:28',NULL,3),(17,'ruhail',8,1,'2019-08-23 20:09:28',NULL,4),(18,'sanil',8,1,'2019-08-22 20:09:28',2,NULL),(21,'ruhail',3,1,'2019-08-22 20:09:28',NULL,4);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Reply entity. @author Anjali';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (1,'tq','sarangi','2019-08-22 20:09:28',1),(2,'thanku','anjali','2019-08-22 20:09:28',2),(3,'thanku','sarangi','2019-08-22 20:09:28',3),(4,'thanku sir','anjali','2019-08-22 20:09:28',3);
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

-- Dump completed on 2019-10-30 11:44:16
