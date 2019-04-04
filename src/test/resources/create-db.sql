CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `precio_final` double DEFAULT NULL,
  `id_estado` int(11) NOT NULL
);

CREATE TABLE `estado` (
  `id_estado` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_estado`)
) ;
CREATE TABLE `linea_pedido` (
  `id_linea_pedido` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `id_pedido` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
);
CREATE TABLE `product` (
  `id_product` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` float DEFAULT NULL,
  PRIMARY KEY (`id_product`)
);

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
);
CREATE TABLE
hibernate_sequence
(
    next_val BIGINT NOT NULL
);
