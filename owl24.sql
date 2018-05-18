-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-05-2018 a las 17:48:43
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `owl24`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maquinas`
--

CREATE TABLE `maquinas` (
  `machid` int(11) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `poblacion` varchar(20) NOT NULL,
  `direccion1` varchar(15) NOT NULL,
  `direccion2` int(8) NOT NULL,
  `rating` double null default 0
) ;

--
-- Volcado de datos para la tabla `maquinas`
--

INSERT INTO `maquinas` (`machid`, `nombre`, `poblacion`, `direccion1`, `direccion2`) VALUES
(1, 'robocop', 'catarroja', 'en jaume', 14),
(2, 'doraemon', 'valencia', 'piruleta', 123);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `userid` int(11) NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `cuenta` varchar(20) NOT NULL,
  `nombre` varchar(15) DEFAULT NULL,
  `apellido1` varchar(15) DEFAULT NULL,
  `apellido2` varchar(15) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `poblacion` varchar(20) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `pasword` varchar(64) NOT NULL
) ;

--
-- Volcado de datos para la tabla `usuarios`
--

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
(13, 0, 'papa12', NULL, NULL, NULL, NULL, NULL, 'papa12', 'papa12');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `maquinas`
--
ALTER TABLE `maquinas`
  ADD PRIMARY KEY (`machid`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`userid`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
