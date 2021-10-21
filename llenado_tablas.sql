
/* Lenado de la tabla categoria */

INSERT INTO categoria VALUES ('C','Conejo');
INSERT INTO categoria VALUES ('G','Gato');
INSERT INTO categoria VALUES ('H','Hamster');
INSERT INTO categoria VALUES ('O','Otro');
INSERT INTO categoria VALUES ('P','Perro');

/* Llenado table tipo_items */

INSERT INTO tipo_items(descripcion) VALUES ('Juguetes');
INSERT INTO tipo_items(descripcion) VALUES ('Accesorios');
INSERT INTO tipo_items(descripcion) VALUES ('Alimentación');
INSERT INTO tipo_items(descripcion) VALUES ('Aseo');
INSERT INTO tipo_items(descripcion) VALUES ('Salud');

/* Llenado tabla unidades_medida */

INSERT INTO unidades_medida(descripcion) VALUES ('Kilogramo');
INSERT INTO unidades_medida(descripcion) VALUES ('Caja');
INSERT INTO unidades_medida(descripcion) VALUES ('Bolsa');
INSERT INTO unidades_medida(descripcion) VALUES ('Unidad');
INSERT INTO unidades_medida(descripcion) VALUES ('Kit');


/* Llenado tabla items */

INSERT INTO items (codigo_item, descripcion, detalle, tipo_articulo, mascota, unidad, 
 gravado, peso, precio_venta,usuario_creo)
VALUES ('C445','SNACKS PREMIUM','Snack premium 6 unidades',3,'C',3,1,50,4000,'ADMIN');
INSERT INTO items (codigo_item, descripcion, detalle, tipo_articulo, mascota, unidad, 
 gravado, peso, precio_venta,usuario_creo)
VALUES  ('G123','CAÑA DE PESCAR PAR GATO','juego de perseguir y atrapar',1,'g',4,1,50,8550,'ADMIN');
INSERT INTO items (codigo_item, descripcion, detalle, tipo_articulo, mascota, unidad, 
 gravado, peso, precio_venta,usuario_creo)
VALUES  ('H443','PUENTE ARCO IRIS','parque de juegos para hámsters ',1,'H',4,1,100,21200,'ADMIN');
INSERT INTO items (codigo_item, descripcion, detalle, tipo_articulo, mascota, unidad, 
 gravado, peso, precio_venta,usuario_creo)
VALUES  ('P223','CAMA MASCOTA','Camita para perros suaves de alta durabilidad, grande',2,'P',4,1,500,132300,'ADMIN');
INSERT INTO items (codigo_item, descripcion, detalle, tipo_articulo, mascota, unidad, 
 gravado, peso, precio_venta,usuario_creo)
VALUES  ('C667','HENO PAGOLA 2KG','alimento más importante en la nutrición de los conejitos',3,'C',4,0,2000,20000,'ADMIN');







