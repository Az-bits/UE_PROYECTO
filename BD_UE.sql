-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-06-2023 a las 08:55:42
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_ue`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrativo`
--

CREATE TABLE `administrativo` (
  `ADMINISTRATIVO_NRO` varchar(10) NOT NULL,
  `CARGO` varchar(30) DEFAULT NULL,
  `PERSONA_NRO` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Disparadores `administrativo`
--
DELIMITER $$
CREATE TRIGGER `TR_ADMINISTRATIVO_INSERT_ID` BEFORE INSERT ON `administrativo` FOR EACH ROW BEGIN 
            DECLARE ADM_ID INT;
            SET ADM_ID = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(ADMINISTRATIVO_NRO,5),SIGNED INTEGER)),0) FROM ADMINISTRATIVO) + 1;
            SET NEW.ADMINISTRATIVO_NRO = CONCAT('ADM-',LPAD(ADM_ID,3,'0')); 
        END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignatura`
--

CREATE TABLE `asignatura` (
  `ASIGNATURA_NRO` varchar(10) NOT NULL,
  `DESCRIPCION` varchar(50) DEFAULT NULL,
  `SIGLA` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `asignatura`
--

INSERT INTO `asignatura` (`ASIGNATURA_NRO`, `DESCRIPCION`, `SIGLA`) VALUES
('ASIG-001', 'MATEMATICA', 'MAT-206');

--
-- Disparadores `asignatura`
--
DELIMITER $$
CREATE TRIGGER `TR_ASIGNATURA_INSERT_ID` BEFORE INSERT ON `asignatura` FOR EACH ROW BEGIN 
    DECLARE ASIG_ID INT;
    SET ASIG_ID = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(ASIGNATURA_NRO,6),SIGNED INTEGER)),0) FROM ASIGNATURA) + 1;
    SET NEW.ASIGNATURA_NRO = CONCAT('ASIG-',LPAD(ASIG_ID,3,'0')); 
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `ESTUDIANTE_NRO` varchar(10) NOT NULL,
  `RUDE` int(11) NOT NULL,
  `PERSONA_NRO` varchar(10) DEFAULT NULL,
  `TUTOR_NRO` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Disparadores `estudiante`
--
DELIMITER $$
CREATE TRIGGER `TR_ESTUDIANTE_INSERT_ID` BEFORE INSERT ON `estudiante` FOR EACH ROW BEGIN 
            DECLARE EST_ID INT;
            SET EST_ID = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(ESTUDIANTE_NRO,5),SIGNED INTEGER)),0) FROM ESTUDIANTE) + 1;
            SET NEW.ESTUDIANTE_NRO = CONCAT('EST-',LPAD(EST_ID,3,'0')); 
        END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grado`
--

CREATE TABLE `grado` (
  `GRADO_NRO` varchar(10) NOT NULL,
  `DESCRIPCION` varchar(15) DEFAULT NULL,
  `NIVEL` varchar(15) DEFAULT NULL,
  `PARALELO_NRO` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `grado`
--

INSERT INTO `grado` (`GRADO_NRO`, `DESCRIPCION`, `NIVEL`, `PARALELO_NRO`) VALUES
('GRA-001', 'PRIMERO', 'PRIMARIA', 'PAR-001');

--
-- Disparadores `grado`
--
DELIMITER $$
CREATE TRIGGER `TR_GRADO_INSERT_ID` BEFORE INSERT ON `grado` FOR EACH ROW BEGIN 
    DECLARE GRA_ID INT;
    SET GRA_ID = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(GRADO_NRO,5),SIGNED INTEGER)),0) FROM GRADO) + 1;
    SET NEW.GRADO_NRO = CONCAT('GRA-',LPAD(GRA_ID,3,'0')); 
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `INSCRIPCION_NRO` varchar(10) NOT NULL,
  `RUDE` int(11) DEFAULT NULL,
  `GRADO_NRO` varchar(10) DEFAULT NULL,
  `TURNO_NRO` varchar(10) DEFAULT NULL,
  `FECHA_INSCRIPCION` date DEFAULT NULL,
  `DETALLE_INSCRIPCION` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Disparadores `inscripcion`
--
DELIMITER $$
CREATE TRIGGER `TR_INSCRIPCION_INSERT_ID` BEFORE INSERT ON `inscripcion` FOR EACH ROW BEGIN 
            DECLARE INS_ID INT;
            SET INS_ID = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(INSCRIPCION_NRO,5),SIGNED INTEGER)),0) FROM INSCRIPCION) + 1;
            SET NEW.INSCRIPCION_NRO = CONCAT('INS-',LPAD(INS_ID,3,'0')); 
        END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `licencia_laboral`
--

CREATE TABLE `licencia_laboral` (
  `LICENCIA_LABORAL_NRO` varchar(10) NOT NULL,
  `DESCRIPCION` varchar(60) NOT NULL,
  `FECHA_SOLICITUD` datetime DEFAULT NULL,
  `FECHA_INICIO` date DEFAULT NULL,
  `FECHA_FINAL` date DEFAULT NULL,
  `ADMINISTRATIVO_NRO` varchar(10) DEFAULT NULL,
  `PROFESOR_NRO` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Disparadores `licencia_laboral`
--
DELIMITER $$
CREATE TRIGGER `TR_LICENCIA_INSERT_ID` BEFORE INSERT ON `licencia_laboral` FOR EACH ROW BEGIN 
            DECLARE LIC_ID INT;
            SET LIC_ID = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(LICENCIA_LABORAL_NRO,5),SIGNED INTEGER)),0) FROM LICENCIA_LABORAL) + 1;
            SET NEW.LICENCIA_LABORAL_NRO = CONCAT('LIC-',LPAD(LIC_ID,3,'0')); 
        END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota`
--

CREATE TABLE `nota` (
  `NOTA_NRO` varchar(10) NOT NULL,
  `RUDE` int(11) DEFAULT NULL,
  `PRIMER_BIMESTRE` int(10) DEFAULT NULL,
  `SEGUNDO_BIMESTRE` int(10) DEFAULT NULL,
  `TERCER_BIMESTRE` int(10) DEFAULT NULL,
  `CUARTO_BIMESTRE` int(10) DEFAULT NULL,
  `ESTADO` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Disparadores `nota`
--
DELIMITER $$
CREATE TRIGGER `TR_NOTA_INSERT_ID` BEFORE INSERT ON `nota` FOR EACH ROW BEGIN 
            DECLARE NOT_ID INT;
            SET NOT_ID = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(NOTA_NRO,5),SIGNED INTEGER)),0) FROM NOTA) + 1;
            SET NEW.NOTA_NRO = CONCAT('NOT-',LPAD(NOT_ID,3,'0')); 
        END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paralelo`
--

CREATE TABLE `paralelo` (
  `PARALELO_NRO` varchar(10) NOT NULL,
  `PARALELO` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paralelo`
--

INSERT INTO `paralelo` (`PARALELO_NRO`, `PARALELO`) VALUES
('PAR-001', 'A');

--
-- Disparadores `paralelo`
--
DELIMITER $$
CREATE TRIGGER `TR_PARALELO_INSERT_ID` BEFORE INSERT ON `paralelo` FOR EACH ROW BEGIN 
    DECLARE PAR_ID INT;
    SET PAR_ID = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(PARALELO_NRO,5),SIGNED INTEGER)),0) FROM PARALELO) + 1;
    SET NEW.PARALELO_NRO = CONCAT('PAR-',LPAD(PAR_ID,3,'0')); 
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `PERSONA_NRO` varchar(10) NOT NULL,
  `CI` varchar(25) DEFAULT NULL,
  `NOMBRE` varchar(25) DEFAULT NULL,
  `PATERNO` varchar(25) DEFAULT NULL,
  `MATERNO` varchar(25) DEFAULT NULL,
  `FECHA_NAC` date DEFAULT NULL,
  `DIRECCION` varchar(255) DEFAULT NULL,
  `TELEFONO` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`PERSONA_NRO`, `CI`, `NOMBRE`, `PATERNO`, `MATERNO`, `FECHA_NAC`, `DIRECCION`, `TELEFONO`) VALUES
('PER-001', '9922636', 'HARRY', 'POTTER', 'DODLY', '2011-07-15', 'CALLEJON DIAGON', 78910771);

--
-- Disparadores `persona`
--
DELIMITER $$
CREATE TRIGGER `TR_PERSONA_INSERT_ID` BEFORE INSERT ON `persona` FOR EACH ROW BEGIN 
    DECLARE SIG_ID INT;
    SET SIG_ID = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(PERSONA_NRO,5),SIGNED INTEGER)),0) FROM PERSONA) + 1;
    SET NEW.PERSONA_NRO = CONCAT('PER-',LPAD(SIG_ID,3,'0')); 
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE `profesor` (
  `PROFESOR_NRO` varchar(10) NOT NULL,
  `PERSONA_NRO` varchar(10) DEFAULT NULL,
  `ASIGNATURA_NRO` varchar(10) DEFAULT NULL,
  `GRADO_NRO` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Disparadores `profesor`
--
DELIMITER $$
CREATE TRIGGER `TR_PROFESOR_INSERT_ID` BEFORE INSERT ON `profesor` FOR EACH ROW BEGIN 
    DECLARE PRO_ID INT;
    SET PRO_ID = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(PROFESOR_NRO,5),SIGNED INTEGER)),0) FROM PROFESOR) + 1;
    SET NEW.PROFESOR_NRO = CONCAT('PRO-',LPAD(PRO_ID,3,'0')); 
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE `turno` (
  `TURNO_NRO` varchar(10) NOT NULL,
  `TURNO` varchar(20) DEFAULT NULL,
  `ENTRADA` time DEFAULT NULL,
  `salida` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `turno`
--

INSERT INTO `turno` (`TURNO_NRO`, `TURNO`, `ENTRADA`, `salida`) VALUES
('TUR-001', 'MAÑANA', '08:00:00', '12:30:00'),
('TUR-002', 'TARDE', '13:30:00', '18:00:00');

--
-- Disparadores `turno`
--
DELIMITER $$
CREATE TRIGGER `TR_TURNO_INSERT_ID` BEFORE INSERT ON `turno` FOR EACH ROW BEGIN 
    DECLARE TUR_ID INT;
    SET TUR_ID = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(TURNO_NRO,5),SIGNED INTEGER)),0) FROM TURNO) + 1;
    SET NEW.TURNO_NRO = CONCAT('TUR-',LPAD(TUR_ID,3,'0')); 
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tutor`
--

CREATE TABLE `tutor` (
  `TUTOR_NRO` varchar(10) NOT NULL,
  `PARENTESCO` varchar(20) DEFAULT NULL,
  `PERSONA_NRO` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Disparadores `tutor`
--
DELIMITER $$
CREATE TRIGGER `TR_TUTOR_INSERT_ID` BEFORE INSERT ON `tutor` FOR EACH ROW BEGIN 
            DECLARE TUT_ID INT;
            SET TUT_ID = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(TUTOR_NRO,5),SIGNED INTEGER)),0) FROM TUTOR) + 1;
            SET NEW.TUTOR_NRO = CONCAT('TUT-',LPAD(TUT_ID,3,'0')); 
        END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `USUARIO_NRO` varchar(10) NOT NULL,
  `PERSONA_NRO` varchar(10) DEFAULT NULL,
  `USUARIO` varchar(20) NOT NULL,
  `CONTRASEÑA` varchar(20) NOT NULL,
  `TIPO_USUARIO` varchar(20) DEFAULT NULL,
  `CORREO_ELECTRONICO` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Disparadores `usuario`
--
DELIMITER $$
CREATE TRIGGER `TR_USUARIO_INSERT_ID` BEFORE INSERT ON `usuario` FOR EACH ROW BEGIN 
            DECLARE USU_ID INT;
            SET USU_ID = (SELECT IFNULL(MAX(CONVERT(SUBSTRING(USUARIO_NRO,5),SIGNED INTEGER)),0) FROM USUARIO) + 1;
            SET NEW.USUARIO_NRO = CONCAT('USU-',LPAD(USU_ID,3,'0')); 
        END
$$
DELIMITER ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrativo`
--
ALTER TABLE `administrativo`
  ADD PRIMARY KEY (`ADMINISTRATIVO_NRO`),
  ADD KEY `FK_ADMINISTRATIVO1` (`PERSONA_NRO`);

--
-- Indices de la tabla `asignatura`
--
ALTER TABLE `asignatura`
  ADD PRIMARY KEY (`ASIGNATURA_NRO`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`RUDE`),
  ADD KEY `FK_ESTUDIANTE1` (`PERSONA_NRO`),
  ADD KEY `FK_ESTUDIANTE2` (`TUTOR_NRO`);

--
-- Indices de la tabla `grado`
--
ALTER TABLE `grado`
  ADD PRIMARY KEY (`GRADO_NRO`),
  ADD KEY `FK_GRADO` (`PARALELO_NRO`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`INSCRIPCION_NRO`),
  ADD KEY `FK_INSCRIPCION1` (`RUDE`),
  ADD KEY `FK_INSCRIPCION2` (`GRADO_NRO`),
  ADD KEY `FK_INSCRIPCION3` (`TURNO_NRO`);

--
-- Indices de la tabla `licencia_laboral`
--
ALTER TABLE `licencia_laboral`
  ADD PRIMARY KEY (`LICENCIA_LABORAL_NRO`),
  ADD KEY `FK_LICENCIA_LABORAL1` (`ADMINISTRATIVO_NRO`),
  ADD KEY `FK_LICENCIA_LABORAL2` (`PROFESOR_NRO`);

--
-- Indices de la tabla `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`NOTA_NRO`),
  ADD KEY `FK_NOTA1` (`RUDE`);

--
-- Indices de la tabla `paralelo`
--
ALTER TABLE `paralelo`
  ADD PRIMARY KEY (`PARALELO_NRO`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`PERSONA_NRO`),
  ADD UNIQUE KEY `CI` (`CI`);

--
-- Indices de la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD PRIMARY KEY (`PROFESOR_NRO`),
  ADD KEY `FK_PROFESOR1` (`PERSONA_NRO`),
  ADD KEY `FK_PROFESOR2` (`ASIGNATURA_NRO`),
  ADD KEY `FK_PROFESOR3` (`GRADO_NRO`);

--
-- Indices de la tabla `turno`
--
ALTER TABLE `turno`
  ADD PRIMARY KEY (`TURNO_NRO`);

--
-- Indices de la tabla `tutor`
--
ALTER TABLE `tutor`
  ADD PRIMARY KEY (`TUTOR_NRO`),
  ADD KEY `FK_TUTOR1` (`PERSONA_NRO`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`USUARIO_NRO`),
  ADD KEY `FK_USUARIO1` (`PERSONA_NRO`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administrativo`
--
ALTER TABLE `administrativo`
  ADD CONSTRAINT `FK_ADMINISTRATIVO1` FOREIGN KEY (`PERSONA_NRO`) REFERENCES `persona` (`PERSONA_NRO`);

--
-- Filtros para la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD CONSTRAINT `FK_ESTUDIANTE1` FOREIGN KEY (`PERSONA_NRO`) REFERENCES `persona` (`PERSONA_NRO`),
  ADD CONSTRAINT `FK_ESTUDIANTE2` FOREIGN KEY (`TUTOR_NRO`) REFERENCES `tutor` (`TUTOR_NRO`);

--
-- Filtros para la tabla `grado`
--
ALTER TABLE `grado`
  ADD CONSTRAINT `FK_GRADO` FOREIGN KEY (`PARALELO_NRO`) REFERENCES `paralelo` (`PARALELO_NRO`);

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `FK_INSCRIPCION1` FOREIGN KEY (`RUDE`) REFERENCES `estudiante` (`RUDE`),
  ADD CONSTRAINT `FK_INSCRIPCION2` FOREIGN KEY (`GRADO_NRO`) REFERENCES `grado` (`GRADO_NRO`),
  ADD CONSTRAINT `FK_INSCRIPCION3` FOREIGN KEY (`TURNO_NRO`) REFERENCES `turno` (`TURNO_NRO`);

--
-- Filtros para la tabla `licencia_laboral`
--
ALTER TABLE `licencia_laboral`
  ADD CONSTRAINT `FK_LICENCIA_LABORAL1` FOREIGN KEY (`ADMINISTRATIVO_NRO`) REFERENCES `administrativo` (`ADMINISTRATIVO_NRO`),
  ADD CONSTRAINT `FK_LICENCIA_LABORAL2` FOREIGN KEY (`PROFESOR_NRO`) REFERENCES `profesor` (`PROFESOR_NRO`);

--
-- Filtros para la tabla `nota`
--
ALTER TABLE `nota`
  ADD CONSTRAINT `FK_NOTA1` FOREIGN KEY (`RUDE`) REFERENCES `estudiante` (`RUDE`);

--
-- Filtros para la tabla `profesor`
--
ALTER TABLE `profesor`
  ADD CONSTRAINT `FK_PROFESOR1` FOREIGN KEY (`PERSONA_NRO`) REFERENCES `persona` (`PERSONA_NRO`),
  ADD CONSTRAINT `FK_PROFESOR2` FOREIGN KEY (`ASIGNATURA_NRO`) REFERENCES `asignatura` (`ASIGNATURA_NRO`),
  ADD CONSTRAINT `FK_PROFESOR3` FOREIGN KEY (`GRADO_NRO`) REFERENCES `grado` (`GRADO_NRO`);

--
-- Filtros para la tabla `tutor`
--
ALTER TABLE `tutor`
  ADD CONSTRAINT `FK_TUTOR1` FOREIGN KEY (`PERSONA_NRO`) REFERENCES `persona` (`PERSONA_NRO`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_USUARIO1` FOREIGN KEY (`PERSONA_NRO`) REFERENCES `persona` (`PERSONA_NRO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
