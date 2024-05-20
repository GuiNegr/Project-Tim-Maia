CREATE DATABASE  IF NOT EXISTS `tim_maia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tim_maia`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: tim_maia
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `ID_PRODUTO` int NOT NULL AUTO_INCREMENT,
  `NOME_PRODUTO` varchar(100) NOT NULL,
  `TIPO_PRODUTO` varchar(100) NOT NULL,
  `VALIDAE_PRODUTO` date NOT NULL,
  `QUANTIDADE_PRODUTO` varchar(100) NOT NULL,
  PRIMARY KEY (`ID_PRODUTO`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (5,'Arroz','GRAOS','2024-06-30','10'),(6,'Feijão','GRAOS','2024-07-15','8'),(7,'Açúcar','GRAOS','2024-08-10','15'),(8,'Óleo de Soja','INDUSTRIAL','2024-09-20','5'),(9,'Farinha de Trigo','GRAOS','2024-08-05','12'),(10,'Carne de Frango','CARNE','2024-06-25','20'),(11,'Leite em Pó','INDUSTRIAL','2024-07-10','7'),(12,'Milho','GRAOS','2024-08-15','18'),(13,'Óleo de Milho','INDUSTRIAL','2024-09-05','6'),(14,'Carne de Boi','CARNE','2024-06-20','22'),(15,'Café','GRAOS','2024-07-30','10'),(16,'Macarrão','INDUSTRIAL','2024-08-25','9'),(17,'Fubá','GRAOS','2024-09-10','14'),(18,'Peixe','CARNE','2024-06-15','15'),(19,'Sal','INDUSTRIAL','2024-07-05','20'),(20,'Margarina','INDUSTRIAL','2024-08-30','8'),(21,'Frutas','VEGETAL','2024-09-15','25'),(22,'Verduras','VEGETAL','2024-06-10','30'),(23,'Legumes','VEGETAL','2024-07-20','27'),(24,'Tomate','VEGETAL','2024-08-10','10'),(25,'Cebola','VEGETAL','2024-09-25','12'),(26,'Alho','VEGETAL','2024-06-05','8'),(27,'Peito de Frango','CARNE','2024-07-15','18'),(28,'Coxa de Frango','CARNE','2024-08-20','20'),(29,'Pernil de Porco','CARNE','2024-09-10','15'),(30,'Filé Mignon','CARNE','2024-06-30','10'),(31,'Alcatra','CARNE','2024-07-25','12'),(32,'Linguiça','CARNE','2024-08-05','20'),(33,'Salsicha','CARNE','2024-09-15','10'),(34,'Bacon','CARNE','2024-06-20','8'),(35,'Brócolis','VEGETAL','2024-07-10','15'),(36,'Couve-Flor','VEGETAL','2024-08-30','10'),(37,'Abóbora','VEGETAL','2024-09-05','12'),(38,'Batata','VEGETAL','2024-06-15','20'),(39,'Mandioca','VEGETAL','2024-07-20','18'),(40,'Cenoura','VEGETAL','2024-08-10','25'),(41,'Beterraba','VEGETAL','2024-09-25','30');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-20 12:11:41
