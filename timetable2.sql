-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: raspisanie
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `1`
--

DROP TABLE IF EXISTS `1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `1` (
  `id1` int NOT NULL,
  PRIMARY KEY (`id1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `1`
--

LOCK TABLES `1` WRITE;
/*!40000 ALTER TABLE `1` DISABLE KEYS */;
/*!40000 ALTER TABLE `1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classroom` (
  `idclassroom` int NOT NULL AUTO_INCREMENT,
  `number` varchar(45) NOT NULL,
  `building` varchar(45) NOT NULL,
  PRIMARY KEY (`idclassroom`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES (1,'100','А'),(2,'101','А'),(3,'200','А'),(4,'201','А'),(5,'300','А'),(6,'301','А'),(7,'400','А'),(8,'401','А'),(9,'100','Б'),(10,'101','Б'),(11,'200','Б'),(12,'201','Б'),(13,'300','Б'),(14,'301','Б'),(15,'400','Б'),(16,'401','Б'),(17,'100','В'),(18,'101','В'),(19,'200','В'),(20,'201','В'),(21,'300','В'),(22,'301','В'),(23,'400','В'),(24,'401','В'),(25,'100','Г'),(26,'101','Г'),(27,'200','Г'),(28,'201','Г'),(29,'300','Г'),(30,'301','Г'),(31,'400','Г'),(32,'401','Г'),(33,'100','Д'),(34,'101','Д'),(35,'200','Д');
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `schedule` (
  `idschedule` int NOT NULL,
  `idweekday` varchar(45) NOT NULL,
  `idsubject` varchar(45) NOT NULL,
  `idstudentgroup` varchar(45) NOT NULL,
  `idtypesubject` varchar(45) NOT NULL,
  `idclassroom` varchar(45) NOT NULL,
  `idteacher` varchar(45) NOT NULL,
  `starttime` varchar(45) NOT NULL,
  `endtime` varchar(45) NOT NULL,
  PRIMARY KEY (`idschedule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,'1','10','10','1','20','10','8:30','10:00'),(2,'2','9','10','2','19','9','10:10','11:40'),(3,'3','8','9','3','18','8','12:10','13:40'),(4,'4','7','9','4','17','7','13:50','15:20'),(5,'5','6','8','5','16','6','15:30','17:00'),(6,'1','5','8','6','15','5','17:10','18:40'),(7,'2','4','7','7','14','4','18:50','20:20'),(8,'3','3','7','8','13','3','8:30','10:10'),(9,'4','2','6','9','12','2','10:10','11:40'),(10,'5','1','6','10','11','1','12:10','13:40'),(11,'1','10','5','11','10','10','13:50','15:20'),(12,'2','9','5','12','9','9','15:30','17:00'),(13,'3','8','4','13','8','8','17:10','18:40'),(14,'4','7','4','14','7','7','18:50','20:20'),(15,'5','6','3','15','6','6','8:30','10:00'),(16,'1','5','3','16','5','5','10:10','11:40'),(17,'2','4','2','17','4','4','12:10','13:40'),(18,'3','3','2','18','3','3','13:40','15:20'),(19,'4','2','1','19','2','2','15:30','17:00'),(20,'5','1','1','20','1','1','17:10','18:40');
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentgroups`
--

DROP TABLE IF EXISTS `studentgroups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentgroups` (
  `idstudentgroups` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `course` varchar(45) NOT NULL,
  PRIMARY KEY (`idstudentgroups`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentgroups`
--

LOCK TABLES `studentgroups` WRITE;
/*!40000 ALTER TABLE `studentgroups` DISABLE KEYS */;
INSERT INTO `studentgroups` VALUES (1,'ПИ-1-18-1','4'),(2,'ПИ-1-19-1','3'),(3,'ПИ-1-20-1','2'),(4,'ПИ-1-21-1','1'),(5,'БИ-1-18-1','4'),(6,'БИ-1-19-1','3'),(7,'БИ-1-20-1','2'),(8,'БИ-1-21-1','1'),(9,'ИС-1-18-1','4'),(10,'ИС-1-19-1','3'),(11,'ИС-1-20-1','2'),(12,'ИС-1-21-1','1'),(13,'ФКБ-1-18-1','4'),(14,'ФКБ-1-19-1','3'),(15,'ФКБ-1-20-1','2'),(16,'ФКБ-1-21-1','1');
/*!40000 ALTER TABLE `studentgroups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `idsubject` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`idsubject`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Надёжность_Программного_Обеспечения'),(2,'Сетевые_Операционные_Системы'),(3,'Командная_Разработка_Программных_Систем'),(4,'Управление_Программными_Проектами'),(5,'Физкультура'),(6,'Теория языков программирования'),(7,'Функциональное и логическое программирование'),(8,'Эксплуатация программного обеспечения'),(9,'Базы данных'),(10,'Операционные системы и сети');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `idteacher` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `subject` varchar(45) NOT NULL,
  PRIMARY KEY (`idteacher`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Ермаков А.А','Надёжность Программного Обеспечения'),(2,'Курганская О.В.','Командная Разработка Программных Систем'),(3,'Абасова Н.И.','Управление Программными Проектами'),(4,'Шурховецкий Г.Н.','Сетевые Операционные Системы'),(5,'Панасенко А.Н.','Физкультура'),(6,'Фереферов Е.С.','Теория языков программирования'),(7,'Деканова Н.П.','Функциональное и логическое программирование'),(8,'Михаэлис В.В.','Эксплуатация программного обеспечения'),(9,'Тирских В.В.','Базы данных'),(10,'Кашковский В.В','Операционные системы и сети');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typesubject`
--

DROP TABLE IF EXISTS `typesubject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typesubject` (
  `idtypesubject` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`idtypesubject`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typesubject`
--

LOCK TABLES `typesubject` WRITE;
/*!40000 ALTER TABLE `typesubject` DISABLE KEYS */;
INSERT INTO `typesubject` VALUES (1,'Лекция'),(2,'Лабораторная Работа'),(3,'Семинар'),(4,'Лекция'),(5,'Лабораторная'),(6,'Лекция'),(7,'Лабораторная'),(8,'Семинар'),(9,'Лекция'),(10,'Лабораторная'),(11,'Семинар'),(12,'Лекция'),(13,'Лабораторная'),(14,'Семинар'),(15,'Лекция'),(16,'Лабораторная'),(17,'Семинар'),(18,'Лекция'),(19,'Лабораторная'),(20,'Семинар');
/*!40000 ALTER TABLE `typesubject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weekday`
--

DROP TABLE IF EXISTS `weekday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `weekday` (
  `idweekday` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`idweekday`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weekday`
--

LOCK TABLES `weekday` WRITE;
/*!40000 ALTER TABLE `weekday` DISABLE KEYS */;
INSERT INTO `weekday` VALUES (1,'Понедельник'),(2,'Вторник'),(3,'Среда'),(4,'Четверг'),(5,'Пятница'),(6,'Суббота'),(7,'Воскресенье');
/*!40000 ALTER TABLE `weekday` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-16 11:58:26
