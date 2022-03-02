-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: timetable
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES (1,'100','А'),(2,'101','А'),(3,'200','Б'),(4,'201','Б'),(5,'300','В'),(6,'301','В');
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
INSERT INTO `schedule` VALUES (1,'2','3','4','1','2','3','12:10','13:40'),(2,'3','4','1','2','3','4','13:50','15:20');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentgroups`
--

LOCK TABLES `studentgroups` WRITE;
/*!40000 ALTER TABLE `studentgroups` DISABLE KEYS */;
INSERT INTO `studentgroups` VALUES (1,'ПИ-1-18-1','4'),(2,'ПИ-1-19-1','3'),(3,'ПИ-1-20-1','2'),(4,'ПИ-1-21-1','1');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Надёжность_Программного_Обеспечения'),(2,'Сетевые_Операционные_Системы'),(3,'Командная_Разработка_Программных_Систем'),(4,'Управление_Программными_Проектами');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Ермаков А.А','Надёжность Программного Обеспечения'),(2,'Курганская О.В.','Командная Разработка Программных Систем'),(3,'Абасова Н.И.','Управление Программными Проектами'),(4,'Шурховецкий Г.Н.','Сетевые Операционные Системы');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typesubject`
--

LOCK TABLES `typesubject` WRITE;
/*!40000 ALTER TABLE `typesubject` DISABLE KEYS */;
INSERT INTO `typesubject` VALUES (1,'Лекция'),(2,'Лабораторная Работа'),(3,'Семинар');
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

-- Dump completed on 2022-02-02  1:58:48
