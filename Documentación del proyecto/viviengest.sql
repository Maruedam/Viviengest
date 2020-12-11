-- MySQL dump 10.13  Distrib 5.7.30, for Win64 (x86_64)
--
-- Host: localhost    Database: viviengest
-- ------------------------------------------------------
-- Server version	5.7.30-log

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
-- Current Database: `viviengest`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `viviengest` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `viviengest`;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `administrador` (
  `mododios` tinyint(1) DEFAULT NULL,
  `idusuario` smallint(6) NOT NULL,
  PRIMARY KEY (`idusuario`),
  CONSTRAINT `administrador_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `administrador`
--

LOCK TABLES `administrador` WRITE;
/*!40000 ALTER TABLE `administrador` DISABLE KEYS */;
INSERT INTO `administrador` VALUES (1,1);
/*!40000 ALTER TABLE `administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alquiladapor`
--

DROP TABLE IF EXISTS `alquiladapor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alquiladapor` (
  `idusuario` smallint(6) NOT NULL,
  `idvivienda` smallint(6) NOT NULL,
  PRIMARY KEY (`idusuario`,`idvivienda`),
  KEY `idvivienda` (`idvivienda`),
  CONSTRAINT `alquiladapor_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `inquilinos` (`idusuario`),
  CONSTRAINT `alquiladapor_ibfk_2` FOREIGN KEY (`idvivienda`) REFERENCES `viviendas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquiladapor`
--

LOCK TABLES `alquiladapor` WRITE;
/*!40000 ALTER TABLE `alquiladapor` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquiladapor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alquileres`
--

DROP TABLE IF EXISTS `alquileres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alquileres` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `idPropietario` smallint(6) DEFAULT NULL,
  `idInquilino` smallint(6) DEFAULT NULL,
  `fecha_entrada` date NOT NULL,
  `fecha_salida` date DEFAULT NULL,
  `idvivienda` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idvivienda` (`idvivienda`),
  KEY `idPropietario` (`idPropietario`),
  KEY `idInquilino` (`idInquilino`),
  CONSTRAINT `alquileres_ibfk_1` FOREIGN KEY (`idvivienda`) REFERENCES `viviendas` (`id`),
  CONSTRAINT `alquileres_ibfk_2` FOREIGN KEY (`idPropietario`) REFERENCES `propietarios` (`idusuario`),
  CONSTRAINT `alquileres_ibfk_3` FOREIGN KEY (`idInquilino`) REFERENCES `inquilinos` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquileres`
--

LOCK TABLES `alquileres` WRITE;
/*!40000 ALTER TABLE `alquileres` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquileres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inquilinos`
--

DROP TABLE IF EXISTS `inquilinos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inquilinos` (
  `idusuario` smallint(6) NOT NULL,
  `ultima_nomina` double DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  CONSTRAINT `inquilinos_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquilinos`
--

LOCK TABLES `inquilinos` WRITE;
/*!40000 ALTER TABLE `inquilinos` DISABLE KEYS */;
/*!40000 ALTER TABLE `inquilinos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propietarios`
--

DROP TABLE IF EXISTS `propietarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `propietarios` (
  `idusuario` smallint(6) NOT NULL,
  `numecuenta` varchar(30) NOT NULL,
  `direccion_postal` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  CONSTRAINT `propietarios_ibfk_1` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propietarios`
--

LOCK TABLES `propietarios` WRITE;
/*!40000 ALTER TABLE `propietarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `propietarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `nif` varchar(9) NOT NULL,
  `telefono` int(9) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `ultimoacceso` datetime DEFAULT NULL,
  `roll` varchar(14) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','admin','00000000a',666666666,'admin@admin.es','21232f297a57a5a743894a0e4a801fc3',NULL,'ADMIN');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `viviendas`
--

DROP TABLE IF EXISTS `viviendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `viviendas` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(50) NOT NULL,
  `c_postal` int(5) NOT NULL,
  `localidad` varchar(30) NOT NULL,
  `provincia` varchar(20) NOT NULL,
  `n_habitaciones` tinyint(2) NOT NULL,
  `ascensor` tinyint(1) NOT NULL,
  `calefaccion` tinyint(1) NOT NULL,
  `aire_acondicionado` tinyint(1) NOT NULL,
  `amueblado` tinyint(1) NOT NULL,
  `tipo_de_suelo` varchar(20) NOT NULL,
  `n_banios` tinyint(2) NOT NULL,
  `metros_cuadrados` int(6) NOT NULL,
  `minimo_meses` tinyint(2) NOT NULL,
  `importe_mensual` double NOT NULL,
  `importe_finaza` double NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `anio_contruccion` smallint(4) DEFAULT NULL,
  `pagado_mes` tinyint(1) NOT NULL,
  `comunidad` double DEFAULT NULL,
  `idPropietario` smallint(6) DEFAULT NULL,
  `foto` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idPropietario` (`idPropietario`),
  CONSTRAINT `viviendas_ibfk_1` FOREIGN KEY (`idPropietario`) REFERENCES `usuarios` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `viviendas`
--

LOCK TABLES `viviendas` WRITE;
/*!40000 ALTER TABLE `viviendas` DISABLE KEYS */;
/*!40000 ALTER TABLE `viviendas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

CREATE USER 'java2020'@'localhost' IDENTIFIED BY '2019';
GRANT ALL PRIVILEGES ON *.* TO 'java2020'@'localhost';

-- Dump completed on 2020-12-10 23:34:53
