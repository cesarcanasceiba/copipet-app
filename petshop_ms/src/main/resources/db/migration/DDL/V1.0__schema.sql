CREATE TABLE `cuidad`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


CREATE TABLE `tipomascota`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

CREATE TABLE `categoriaproducto`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


CREATE TABLE `peluquero`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


CREATE TABLE `serviciopeluqueria`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


CREATE TABLE `bonodescuento`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  `inicioVigencia` datetime
(6) NOT NULL,
  `finVigencia` datetime
(6) NOT NULL,
  `descuento` double NOT NULL,
  PRIMARY KEY
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


CREATE TABLE `usuario`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  `password` varchar
(20) COLLATE latin1_spanish_ci NOT NULL,
  `direccion` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  `telefono` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  `acepta_terminos` tinyint
(1) NOT NULL,
  `ciudad_id` int NOT NULL,
  `tipo_mascota_id` int NOT NULL,
  PRIMARY KEY
(`id`),
  KEY `usuario_ciudad_id_8f87d332_fk_cuidad_id`
(`ciudad_id`),
  KEY `usuario_tipo_mascota_id_641a478f_fk_tipomascota_id`
(`tipo_mascota_id`),
  CONSTRAINT `usuario_ciudad_id_8f87d332_fk_cuidad_id` FOREIGN KEY
(`ciudad_id`) REFERENCES `cuidad`
(`id`),
  CONSTRAINT `usuario_tipo_mascota_id_641a478f_fk_tipomascota_id` FOREIGN KEY
(`tipo_mascota_id`) REFERENCES `tipomascota`
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


CREATE TABLE `citapeluqueria`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `hora_inicio` datetime
(6) NOT NULL,
  `hora_final` datetime
(6) NOT NULL,
  `fotoMascota` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  `pesoMascota` int NOT NULL,
  `costoCita` int NOT NULL,
  `peluquero_id` int NOT NULL,
  `usuario_id` int NOT NULL,
  PRIMARY KEY
(`id`),
  KEY `citapeluqueria_peluquero_id_ceae7162_fk_peluquero_id`
(`peluquero_id`),
  KEY `citapeluqueria_usuario_id_df2d8af7_fk_usuario_id`
(`usuario_id`),
  CONSTRAINT `citapeluqueria_peluquero_id_ceae7162_fk_peluquero_id` FOREIGN KEY
(`peluquero_id`) REFERENCES `peluquero`
(`id`),
  CONSTRAINT `citapeluqueria_usuario_id_df2d8af7_fk_usuario_id` FOREIGN KEY
(`usuario_id`) REFERENCES `usuario`
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


CREATE TABLE `factura`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `costoTotal` bigint NOT NULL,
  `bonoDescuento_id` int NOT NULL,
  PRIMARY KEY
(`id`),
  KEY `factura_bonoDescuento_id_6732ba8b_fk_bonodescuento_id`
(`bonoDescuento_id`),
  CONSTRAINT `factura_bonoDescuento_id_6732ba8b_fk_bonodescuento_id` FOREIGN KEY
(`bonoDescuento_id`) REFERENCES `bonodescuento`
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


CREATE TABLE `factura_citaspeluqueria`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `factura_id` int NOT NULL,
  `citapeluqueria_id` int NOT NULL,
  PRIMARY KEY
(`id`),
  UNIQUE KEY `factura_citasPeluqu_factura_id_citapeluqueri_7934aaa5_uniq`
(`factura_id`,`citapeluqueria_id`),
  KEY `factura_citasPe_citapeluqueria_id_3430291c_fk_cita`
(`citapeluqueria_id`),
  CONSTRAINT `factura_citasPe_citapeluqueria_id_3430291c_fk_cita` FOREIGN KEY
(`citapeluqueria_id`) REFERENCES `citapeluqueria`
(`id`),
  CONSTRAINT `factura_citasPe_factura_id_ebd30459_fk_fact` FOREIGN KEY
(`factura_id`) REFERENCES `factura`
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


CREATE TABLE `marcaproducto`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


CREATE TABLE `producto`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  `precio` bigint NOT NULL,
  `presentacion` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  `foto` varchar
(100) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` longtext COLLATE latin1_spanish_ci NOT NULL,
  `caracteristicas` time
(6) NOT NULL,
  `beneficios` longtext COLLATE latin1_spanish_ci NOT NULL,
  `codigo_producto` varchar
(20) COLLATE latin1_spanish_ci NOT NULL,
  `categoria_producto_id` int NOT NULL,
  `marca_id` int NOT NULL,
  PRIMARY KEY
(`id`),
  KEY `producto_categoria_producto_i_7651d693_fk_cate`
(`categoria_producto_id`),
  KEY `producto_marca_id_cea34160_fk_marcaproducto_id`
(`marca_id`),
  CONSTRAINT `producto_categoria_producto_i_7651d693_fk_cate` FOREIGN KEY
(`categoria_producto_id`) REFERENCES `categoriaproducto`
(`id`),
  CONSTRAINT `producto_marca_id_cea34160_fk_marcaproducto_id` FOREIGN KEY
(`marca_id`) REFERENCES `marcaproducto`
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


CREATE TABLE `factura_productos`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `factura_id` int NOT NULL,
  `producto_id` int NOT NULL,
  PRIMARY KEY
(`id`),
  UNIQUE KEY `factura_productos_factura_id_producto_id_adf4f42f_uniq`
(`factura_id`,`producto_id`),
  KEY `factura_productos_producto_id_86f4063a_fk_producto_id`
(`producto_id`),
  CONSTRAINT `factura_productos_factura_id_a75614bb_fk_factura_id` FOREIGN KEY
(`factura_id`) REFERENCES `factura`
(`id`),
  CONSTRAINT `factura_productos_producto_id_86f4063a_fk_producto_id` FOREIGN KEY
(`producto_id`) REFERENCES `producto`
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;



CREATE TABLE `citapeluqueria_servicios`
(
  `id` int NOT NULL AUTO_INCREMENT,
  `citapeluqueria_id` int NOT NULL,
  `serviciopeluqueria_id` int NOT NULL,
  PRIMARY KEY
(`id`),
  UNIQUE KEY `citapeluqueria_serv_citapeluqueria_id_servic_2c03b437_uniq`
(`citapeluqueria_id`,`serviciopeluqueria_id`),
  KEY `citapeluqueria__serviciopeluqueria_i_eada6862_fk_serv`
(`serviciopeluqueria_id`),
  CONSTRAINT `citapeluqueria__citapeluqueria_id_9f61def2_fk_cita` FOREIGN KEY
(`citapeluqueria_id`) REFERENCES `citapeluqueria`
(`id`),
  CONSTRAINT `citapeluqueria__serviciopeluqueria_i_eada6862_fk_serv` FOREIGN KEY
(`serviciopeluqueria_id`) REFERENCES `serviciopeluqueria`
(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

