-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.21-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para owl24
CREATE DATABASE IF NOT EXISTS `owl24` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `owl24`;

-- Volcando estructura para tabla owl24.maquinas
CREATE TABLE IF NOT EXISTS `maquinas` (
  `machid` int(11) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `poblacion` varchar(20) NOT NULL,
  `direccion1` varchar(15) NOT NULL,
  `direccion2` int(8) NOT NULL,
  `rating` double DEFAULT '0',
  `marca` varchar(15) NOT NULL,
  PRIMARY KEY (`machid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla owl24.maquinas: ~14 rows (aproximadamente)
/*!40000 ALTER TABLE `maquinas` DISABLE KEYS */;
INSERT INTO `maquinas` (`machid`, `nombre`, `poblacion`, `direccion1`, `direccion2`, `rating`, `marca`) VALUES
	(1, 'robocop', 'catarroja', 'en jaume', 14, 2.3, 'adidas'),
	(2, 'doraemon', 'valencia', 'piruleta', 123, 4.5, 'nike'),
	(3, 'prueba1', 'valencia', 'patata', 34, 3.4, 'nike'),
	(4, 'prueba2', 'valencia', 'tomate', 34, 3.5, 'adidas'),
	(5, 'prueba3', 'valencia', 'lechuga', 34, 3.7, 'nike'),
	(6, 'prueba4', 'catarroja', 'platano', 34, 2.6, 'adidas'),
	(7, 'prueba5', 'catarroja', 'manzana', 34, 4.2, 'nike'),
	(8, 'prueba6', 'catarroja', 'melon', 34, 1.5, 'adidas'),
	(9, 'prueba7', 'valencia', 'pera', 12, 1.4, 'adidas'),
	(10, 'prueba8', 'valencia', 'sandia', 2, 4.9, 'nike'),
	(11, 'prueba9', 'valencia', 'pepino', 3, 3.5, 'adidas'),
	(12, 'prueba10', 'catarroja', 'melocoton', 14, 2.8, 'nike'),
	(13, 'prueba11', 'catarroja', 'zanahoria', 23, 3.9, 'adidas'),
	(14, 'prueba12', 'catarroja', 'cebolla', 25, 2.2, 'nike');
/*!40000 ALTER TABLE `maquinas` ENABLE KEYS */;

-- Volcando estructura para tabla owl24.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `cuenta` varchar(20) NOT NULL,
  `nombre` varchar(15) DEFAULT NULL,
  `apellido1` varchar(15) DEFAULT NULL,
  `apellido2` varchar(15) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `poblacion` varchar(20) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `pasword` varchar(64) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla owl24.usuarios: ~11 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`userid`, `admin`, `cuenta`, `nombre`, `apellido1`, `apellido2`, `edad`, `poblacion`, `email`, `pasword`) VALUES
	(1, 0, 'toloco', 'juan', 'tarrega', 'lozano', 30, 'torrent', 'juantarrega@gmail.com', 'tortilladepatatas'),
	(2, 0, 'patata', 'sara', 'varas', 'lópez', 20, 'alfafar', 'saravaras@gmail.com', 'bocatadecalamalesconalioli'),
	(3, 0, 'dani borras', NULL, NULL, NULL, NULL, NULL, 'danicorreo@gmail.com', 'patata'),
	(7, 0, 'pepe', NULL, NULL, NULL, NULL, NULL, 'pepe@gmai.com', 'passpepe'),
	(8, 0, 'paco', NULL, NULL, NULL, NULL, NULL, 'paco@gmail.ocom', 'paspaco'),
	(9, 0, 'tomas', NULL, NULL, NULL, NULL, NULL, 'caca', 'caca'),
	(10, 0, 'dadadad', NULL, NULL, NULL, NULL, NULL, 'dadadad', 'dadadad'),
	(11, 0, 'pedro', NULL, NULL, NULL, NULL, NULL, 'pedro', 'pedro'),
	(12, 0, 'papa', NULL, NULL, NULL, NULL, NULL, 'papa', 'papa'),
	(13, 0, 'papa12', NULL, NULL, NULL, NULL, NULL, 'papa12', 'papa12'),
	(14, 0, 'cuenta1', NULL, NULL, NULL, NULL, NULL, 'cuenta1@hotmail.com', 'cuenta1');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
