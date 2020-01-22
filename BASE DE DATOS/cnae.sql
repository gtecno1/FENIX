-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-08-2016 a las 17:38:06
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `cnae`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `año`
--

CREATE TABLE IF NOT EXISTS `año` (
  `id$seccion` varchar(30) NOT NULL,
  PRIMARY KEY (`id$seccion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `año`
--

INSERT INTO `año` (`id$seccion`) VALUES
('CUARTO'),
('PRIMERO'),
('QUINTO'),
('SEGUNDO'),
('SEPTIMO'),
('SEXTO'),
('TERCERO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `botones`
--

CREATE TABLE IF NOT EXISTS `botones` (
  `id$activi` int(11) NOT NULL DEFAULT '0',
  `descripcion` varchar(60) NOT NULL,
  `activo` varchar(30) NOT NULL,
  PRIMARY KEY (`id$activi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `botones`
--

INSERT INTO `botones` (`id$activi`, `descripcion`, `activo`) VALUES
(1, 'Guardar', '0'),
(2, 'Editar', '0'),
(3, 'Eliminar', '0'),
(4, 'Todo', '0'),
(5, 'G+ED', '0'),
(6, 'ED+El', '0'),
(7, 'G+El', '0'),
(8, 'Ninguna', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colaboracion1`
--

CREATE TABLE IF NOT EXISTS `colaboracion1` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` int(15) NOT NULL,
  `cantida` int(11) NOT NULL,
  `fecha` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `cp` (`cedula`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Volcado de datos para la tabla `colaboracion1`
--

INSERT INTO `colaboracion1` (`codigo`, `cedula`, `cantida`, `fecha`) VALUES
(12, 19916867, 10, '30/ago/2016'),
(13, 19916867, 10, '30/ago/2016');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comedor`
--

CREATE TABLE IF NOT EXISTS `comedor` (
  `idc` int(11) NOT NULL AUTO_INCREMENT,
  `Ced` int(11) NOT NULL,
  `nomb` varchar(60) NOT NULL,
  `Apelli` varchar(60) NOT NULL,
  `fecha` varchar(30) NOT NULL,
  PRIMARY KEY (`idc`),
  KEY `ced` (`Ced`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `comedor`
--

INSERT INTO `comedor` (`idc`, `Ced`, `nomb`, `Apelli`, `fecha`) VALUES
(15, 19916867, 'Douglas ', 'Arévalo', '30/ago/2016');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inventario`
--

CREATE TABLE IF NOT EXISTS `inventario` (
  `idinventario` int(11) NOT NULL AUTO_INCREMENT,
  `producto` varchar(70) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `unidad_medida` varchar(30) NOT NULL,
  `etiqueta` varchar(30) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha_ingre` varchar(30) NOT NULL,
  PRIMARY KEY (`idinventario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `inventario`
--

INSERT INTO `inventario` (`idinventario`, `producto`, `descripcion`, `unidad_medida`, `etiqueta`, `cantidad`, `fecha_ingre`) VALUES
(12, 'Arroz', 'El Arco', '1', 'kg(Kilogramo)', 24, '30/ago/2016'),
(13, 'Lentejas', 'LaLa', '1', 'kg(Kilogramo)', 12, '30/ago/2016'),
(14, 'Azeite', 'El Catire', '2', 'l(Litro)', 30, '30/ago/2016'),
(15, 'Patilla', 'Rellada', '3', 'kg(Kilogramo)', 8, '30/ago/2016');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificacion`
--

CREATE TABLE IF NOT EXISTS `notificacion` (
  `id_noti` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) NOT NULL,
  `apellido` varchar(15) NOT NULL,
  `rol` int(11) NOT NULL,
  PRIMARY KEY (`id_noti`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `idCedula` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `sexo` varchar(30) NOT NULL,
  `edad` int(11) NOT NULL,
  `año` varchar(11) NOT NULL,
  `seccion` varchar(50) NOT NULL,
  PRIMARY KEY (`idCedula`),
  KEY `Año` (`año`),
  KEY `sex` (`sexo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idCedula`, `nombre`, `apellido`, `sexo`, `edad`, `año`, `seccion`) VALUES
(19916867, 'Douglas ', 'Arévalo', 'M', 22, 'QUINTO', 'E'),
(23459679, 'Néstor ', 'Finol      ', 'M', 21, 'SEXTO', 'C'),
(25311294, 'geraldo', 'jimenez', 'M', 21, 'QUINTO', 'A'),
(25351918, ' Gusmely', ' Sabril    ', 'F', 22, 'SEPTIMO', 'E');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proceso`
--

CREATE TABLE IF NOT EXISTS `proceso` (
  `id$pro` int(11) NOT NULL AUTO_INCREMENT,
  `descricion` varchar(60) NOT NULL,
  PRIMARY KEY (`id$pro`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;

--
-- Volcado de datos para la tabla `proceso`
--

INSERT INTO `proceso` (`id$pro`, `descricion`) VALUES
(1, 'Colaboracion'),
(2, 'Deposito'),
(3, 'Asignacion'),
(4, 'Todo'),
(5, 'DE+COL'),
(6, 'DE+AS'),
(7, 'AS+COL'),
(8, 'Registro'),
(9, 'Comedor'),
(10, 'COM+RE'),
(11, 'COM+COL'),
(12, 'COM+AS'),
(13, 'COM+DE'),
(14, 'RE+COL'),
(15, 'RE+DE'),
(16, 'RE+AS'),
(17, 'AS+DE+COL'),
(18, 'RE+COM+AS'),
(19, 'RE+COM+COL'),
(20, 'RE+COM+DE'),
(21, 'RE+AS+DE'),
(22, 'RE+AS+COL'),
(23, 'COM+AS+DE'),
(24, 'COM+AS+COL'),
(25, 'DE+AS+COL+COM'),
(26, 'DE+AS+COL+RE'),
(27, 'COL+DE+RE+COM'),
(28, 'COL+AS+RE+COM'),
(29, 'DE+AS+RE+COM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prorolact`
--

CREATE TABLE IF NOT EXISTS `prorolact` (
  `id$3` int(11) NOT NULL AUTO_INCREMENT,
  `id$rol` int(11) NOT NULL,
  `id$pro` int(11) NOT NULL,
  `idactiro` int(11) NOT NULL,
  `idactide` int(11) NOT NULL,
  `idactireg` int(11) NOT NULL,
  `idacticol` int(11) NOT NULL,
  `idacticon` int(11) NOT NULL,
  `Activo` varchar(30) NOT NULL,
  PRIMARY KEY (`id$3`),
  KEY `rolx` (`id$rol`),
  KEY `pro1` (`id$pro`),
  KEY `acti1` (`idactiro`),
  KEY `bd` (`idactide`),
  KEY `bre` (`idactireg`),
  KEY `bcol` (`idacticol`),
  KEY `bcom` (`idacticon`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=69 ;

--
-- Volcado de datos para la tabla `prorolact`
--

INSERT INTO `prorolact` (`id$3`, `id$rol`, `id$pro`, `idactiro`, `idactide`, `idactireg`, `idacticol`, `idacticon`, `Activo`) VALUES
(68, 1, 4, 4, 4, 4, 1, 1, '21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE IF NOT EXISTS `rol` (
  `id$rol` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(60) NOT NULL,
  PRIMARY KEY (`id$rol`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id$rol`, `descripcion`) VALUES
(1, 'Director'),
(2, 'Coordinador'),
(3, 'Trabajador'),
(4, 'Desactivado'),
(5, 'Ninguno'),
(6, 'Sub director'),
(7, 'Secretario(a)'),
(8, 'Cosinero'),
(9, 'Encargado'),
(10, 'Profesor'),
(11, 'Obrero'),
(12, 'Visitante');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sexo`
--

CREATE TABLE IF NOT EXISTS `sexo` (
  `id$sexo` varchar(30) NOT NULL,
  PRIMARY KEY (`id$sexo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sexo`
--

INSERT INTO `sexo` (`id$sexo`) VALUES
('F'),
('M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sms`
--

CREATE TABLE IF NOT EXISTS `sms` (
  `idsms` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` int(11) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `apellido` varchar(15) NOT NULL,
  `contenido` varchar(140) NOT NULL,
  `mensajero` int(11) NOT NULL,
  PRIMARY KEY (`idsms`),
  KEY `usuc` (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id$usu` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(60) NOT NULL,
  `contraseña` varchar(60) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `rol` int(11) NOT NULL,
  `activo` varchar(10) NOT NULL,
  PRIMARY KEY (`id$usu`),
  KEY `role` (`rol`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id$usu`, `usuario`, `contraseña`, `nombre`, `apellido`, `rol`, `activo`) VALUES
(21, '83d58178f5a7a8423831e90e6767f074', '41aca332512049b1e0631dfec5550d14', 'Ruben', 'Martines', 1, '0');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `colaboracion1`
--
ALTER TABLE `colaboracion1`
  ADD CONSTRAINT `cp` FOREIGN KEY (`cedula`) REFERENCES `persona` (`idCedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `comedor`
--
ALTER TABLE `comedor`
  ADD CONSTRAINT `df` FOREIGN KEY (`Ced`) REFERENCES `persona` (`idCedula`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `año1` FOREIGN KEY (`año`) REFERENCES `año` (`id$seccion`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sex1` FOREIGN KEY (`sexo`) REFERENCES `sexo` (`id$sexo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `prorolact`
--
ALTER TABLE `prorolact`
  ADD CONSTRAINT `bcol` FOREIGN KEY (`idacticol`) REFERENCES `botones` (`id$activi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bcom` FOREIGN KEY (`idacticon`) REFERENCES `botones` (`id$activi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bd` FOREIGN KEY (`idactide`) REFERENCES `botones` (`id$activi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bot` FOREIGN KEY (`idactiro`) REFERENCES `botones` (`id$activi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bre` FOREIGN KEY (`idactireg`) REFERENCES `botones` (`id$activi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prox1` FOREIGN KEY (`id$pro`) REFERENCES `proceso` (`id$pro`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rolx1` FOREIGN KEY (`id$rol`) REFERENCES `rol` (`id$rol`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `sms`
--
ALTER TABLE `sms`
  ADD CONSTRAINT `usuc` FOREIGN KEY (`codigo`) REFERENCES `usuario` (`id$usu`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `rol1` FOREIGN KEY (`rol`) REFERENCES `rol` (`id$rol`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
