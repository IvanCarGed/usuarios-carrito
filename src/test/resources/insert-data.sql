INSERT INTO estado (id_estado, nombre) VALUES (1,'Estado Sim 01');
INSERT INTO estado (id_estado, nombre) VALUES (2,'Estado Sim 02');

INSERT INTO pedido (id_pedido, comentario, direccion, precio_final, id_estado) VALUES(1, 'comentrio Test 001', 'direccion Test 001', 99.9, 1);
INSERT INTO pedido (id_pedido, comentario, direccion, precio_final, id_estado) VALUES(2, 'comentrio Test 002', 'direccion Test 002', 99.9, 2);

INSERT INTO linea_pedido (id_linea_pedido, cantidad , id_pedido, id_product) VALUES(1, 1, 1, 1);
INSERT INTO linea_pedido (id_linea_pedido, cantidad , id_pedido, id_product) VALUES(2, 2, 1, 2);
INSERT INTO linea_pedido (id_linea_pedido, cantidad , id_pedido, id_product) VALUES(3, 1, 2, 3);

INSERT INTO product (id_product, descripcion, marca, nombre, precio) VALUES (1, 'descripcion producto Test 001', 'marca Test 001', 'nombre producto Test 001', 1.0);
INSERT INTO product (id_product, descripcion, marca, nombre, precio) VALUES (2, 'descripcion producto Test 002', 'marca Test 002', 'nombre producto Test 002', 1.5);
INSERT INTO product (id_product, descripcion, marca, nombre, precio) VALUES (3, 'descripcion producto Test 003', 'marca Test 003', 'nombre producto Test 003', 2.1);

INSERT INTO hibernate_sequence (next_val) VALUES (1);