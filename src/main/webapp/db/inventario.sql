/*
SQLyog Community v11.51 (64 bit)
MySQL - 5.6.21 : Database - inventario
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`inventario` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `inventario`;

/*Table structure for table `area` */

DROP TABLE IF EXISTS `area`;

CREATE TABLE `area` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(200) DEFAULT NULL,
  `IdTienda` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_TIENDA_idx` (`IdTienda`),
  CONSTRAINT `FK_TIENDA` FOREIGN KEY (`IdTienda`) REFERENCES `tienda` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `area` */

insert  into `area`(`Id`,`Nombre`,`IdTienda`) values (1,'Panaderia',1),(2,'Atencion al Cliente',2),(3,'Panaderia',2),(4,'Mostrador',3);

/*Table structure for table `departamento` */

DROP TABLE IF EXISTS `departamento`;

CREATE TABLE `departamento` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `departamento` */

insert  into `departamento`(`Id`,`Nombre`) values (1,'San Borja'),(2,'San Miguel'),(3,'Lince');

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(100) DEFAULT NULL,
  `Descripcion` varchar(200) DEFAULT NULL,
  `IdArea` int(11) DEFAULT NULL,
  `IdUsuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_AREA_idx` (`IdArea`),
  KEY `FK_USUARIO` (`IdUsuario`),
  CONSTRAINT `FK_AREA` FOREIGN KEY (`IdArea`) REFERENCES `area` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_USUARIO` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `producto` */

insert  into `producto`(`Id`,`Codigo`,`Descripcion`,`IdArea`,`IdUsuario`) values (1,'0001011115','TAPERS222222222222',4,NULL);

/*Table structure for table `tienda` */

DROP TABLE IF EXISTS `tienda`;

CREATE TABLE `tienda` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(200) DEFAULT NULL,
  `IdDepartamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `IdDepartamento_idx` (`IdDepartamento`),
  CONSTRAINT `FK_DEPARTAMENTO` FOREIGN KEY (`IdDepartamento`) REFERENCES `departamento` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tienda` */

insert  into `tienda`(`Id`,`Nombre`,`IdDepartamento`) values (1,'Almacen',1),(2,'Nueva Era',1),(3,'Almacen',2),(4,'Milenio',3);

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `Id` int(20) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(100) DEFAULT NULL,
  `Nombre` varchar(200) DEFAULT NULL,
  `Password` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`Id`,`Codigo`,`Nombre`,`Password`) values (1,'admin','Administrador','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
