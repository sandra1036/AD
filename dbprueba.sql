create table categoria(
	id serial primary key,
	nombre varchar(50) unique not null

);



insert into categoria (nombre) values ('categoría 1');
insert into categoria (nombre) values ('categoría 2');
insert into categoria (nombre) values ('categoría 3');


/*Ejercicio crear una tabla llamada articulos donde tiene el id,nombre y 2 campos más: precio si es desconocido lo pones como nulo y el segundo campo es: categoría unsigner,bigint.
Menú: salir,nuevo,editar,consultar,eliminar,listar*/

create table articulo(
	id  serial primary key,
	nombre varchar(50) unique not null,
	precio numeric(10,2),
	categoria bigint usigner
	FOREIGN KEY(id) REFERENCES categoria(id)

);

insert into articulo (nombre,precio,categoria) values ('articulo1',10,1);
insert into articulo (nombre,precio) values ('articulo2',);
