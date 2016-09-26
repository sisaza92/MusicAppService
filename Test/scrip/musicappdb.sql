-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-09-2016 a las 19:25:21
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `musicappdb`
--
CREATE DATABASE musicappdb;
USE musicappdb;



-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cancion`
--

CREATE TABLE `cancion` (
  `idCancion` int(11) NOT NULL,
  `tituloCancion` varchar(100) NOT NULL,
  `album` varchar(100) DEFAULT NULL,
  `artista` varchar(50) DEFAULT NULL,
  `rutaCancion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `playlist`
--

CREATE TABLE `playlist` (
  `idRonda` int(11) NOT NULL,
  `idCancion` int(11) NOT NULL,
  `totalVotos` int(11) NOT NULL,
  `envotacion` bit(1) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `voto`
--

CREATE TABLE `voto` (
  `idCancion` int(11) NOT NULL,
  `idUsuario` varchar(25) NOT NULL,
  `fecha` date NOT NULL,
  `idRonda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cancion`
--
ALTER TABLE `cancion`
  ADD PRIMARY KEY (`idCancion`);

--
-- Indices de la tabla `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`idRonda`,`idCancion`,`fecha`);

--
-- Indices de la tabla `voto`
--
ALTER TABLE `voto`
  ADD PRIMARY KEY (`idCancion`,`idUsuario`,`fecha`,`idRonda`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

INSERT INTO `cancion` (`idCancion`, `tituloCancion`, `album`, `artista`, `rutaCancion`) VALUES 
('1', 'Entre dos Tierras', 'Album art 2005', 'Rata Blanca', 'C://Documents/'),
('2', 'cancion2', 'album2', 'autor1', 'rutaCancion2');

INSERT INTO `playlist` (`idRonda`, `idCancion`, `totalVotos`, `envotacion`,`fecha`) VALUES 
('1', '1', 50, 1,'2016-09-26'),
('1', '2', 20, 1,'2016-09-26');

INSERT INTO `voto` (`idCancion`, `idUsuario`, `fecha`, `idRonda`) VALUES 
('1', 'user1','2016-09-26',1),
('2', 'user2','2016-09-26',1);
