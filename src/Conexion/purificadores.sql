-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-08-2014 a las 18:00:48
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `purificadores`
--
CREATE DATABASE IF NOT EXISTS `purificadores` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `purificadores`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `cedula` varchar(15) NOT NULL,
  `cliente` varchar(50) NOT NULL,
  `direccion_casa` varchar(30) NOT NULL,
  `telefono_casa` varchar(15) NOT NULL,
  `direccion_oficina` varchar(15) NOT NULL,
  `telefono_oficina` varchar(15) NOT NULL,
  `correo` varchar(30) NOT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_factura`
--

DROP TABLE IF EXISTS `detalle_factura`;
CREATE TABLE IF NOT EXISTS `detalle_factura` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_factura` bigint(20) NOT NULL,
  `id_purificador` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_factura` (`id_factura`),
  KEY `id_purificador` (`id_purificador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE IF NOT EXISTS `factura` (
  `id` bigint(20) NOT NULL,
  `fecha` date NOT NULL,
  `forma_pago` varchar(30) NOT NULL,
  `total_pago` bigint(20) NOT NULL,
  `pagado` bigint(20) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `id_cliente` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden_instalacion`
--

DROP TABLE IF EXISTS `orden_instalacion`;
CREATE TABLE IF NOT EXISTS `orden_instalacion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `id_cliente` varchar(15) NOT NULL,
  `id_purificador` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_purificador` (`id_purificador`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `purificador`
--

DROP TABLE IF EXISTS `purificador`;
CREATE TABLE IF NOT EXISTS `purificador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `cantidad` bigint(20) NOT NULL,
  `valor` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recibo_provicional`
--

DROP TABLE IF EXISTS `recibo_provicional`;
CREATE TABLE IF NOT EXISTS `recibo_provicional` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `id_cliente` varchar(15) NOT NULL,
  `id_factura` bigint(20) NOT NULL,
  `valor_pagado` bigint(20) NOT NULL,
  `saldo` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_factura` (`id_factura`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `referencias`
--

DROP TABLE IF EXISTS `referencias`;
CREATE TABLE IF NOT EXISTS `referencias` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `cedula` varchar(15) NOT NULL,
  `cedula_cliente` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cedula_cliente` (`cedula_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_purificador`
--

DROP TABLE IF EXISTS `tipo_purificador`;
CREATE TABLE IF NOT EXISTS `tipo_purificador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  `detalle` varchar(255) NOT NULL,
  `id_purificador` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_purificador` (`id_purificador`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD CONSTRAINT `id_pur_detalle` FOREIGN KEY (`id_purificador`) REFERENCES `purificador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `id_fac_detalle` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `cedula_cliente_fac` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `orden_instalacion`
--
ALTER TABLE `orden_instalacion`
  ADD CONSTRAINT `id_pur_orden` FOREIGN KEY (`id_purificador`) REFERENCES `purificador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cedula_clie_orden` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `recibo_provicional`
--
ALTER TABLE `recibo_provicional`
  ADD CONSTRAINT `id_fact_recibo` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cedula_cli_recibo` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `referencias`
--
ALTER TABLE `referencias`
  ADD CONSTRAINT `cedula_cliente` FOREIGN KEY (`cedula_cliente`) REFERENCES `cliente` (`cedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tipo_purificador`
--
ALTER TABLE `tipo_purificador`
  ADD CONSTRAINT `id_purificador` FOREIGN KEY (`id_purificador`) REFERENCES `purificador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
