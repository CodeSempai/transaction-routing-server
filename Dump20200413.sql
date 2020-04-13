-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: TransactionRouting
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `bank_issuer`
--

DROP TABLE IF EXISTS `bank_issuer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_issuer` (
  `id` int NOT NULL,
  `target_name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_issuer`
--

LOCK TABLES `bank_issuer` WRITE;
/*!40000 ALTER TABLE `bank_issuer` DISABLE KEYS */;
INSERT INTO `bank_issuer` VALUES (3,NULL,'www.yandex.ru'),(5,'google','www.google.com'),(7,'google','www.google.com'),(12,'yandex','www.yandex.ru'),(18,'test','www.test.ru'),(19,'okey','works.com'),(21,'test','www.test.com'),(24,'ban','tony.com'),(26,'yandexx','www.yandex.ru'),(27,'ga','www'),(29,'testttttt','www.test.ru'),(30,'testes','www.test.ru'),(31,'testes','www.test.com'),(32,'w','w');
/*!40000 ALTER TABLE `bank_issuer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_issuer_bin`
--

DROP TABLE IF EXISTS `bank_issuer_bin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_issuer_bin` (
  `id` int NOT NULL,
  `bin` varchar(255) DEFAULT NULL,
  `bank_issuer_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbtxf88ssdfxddtiplhlxc9mum` (`bank_issuer_id`),
  CONSTRAINT `FKbtxf88ssdfxddtiplhlxc9mum` FOREIGN KEY (`bank_issuer_id`) REFERENCES `bank_issuer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_issuer_bin`
--

LOCK TABLES `bank_issuer_bin` WRITE;
/*!40000 ALTER TABLE `bank_issuer_bin` DISABLE KEYS */;
INSERT INTO `bank_issuer_bin` VALUES (10,'1515',5),(11,'564112',5),(17,'90902',31),(23,'18484141',21),(25,'9999',5),(35,'2',27);
/*!40000 ALTER TABLE `bank_issuer_bin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (36);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-13 13:25:30
