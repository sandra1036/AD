create table categoria(
	id serial primary key,
	nombre varchar(50) unique not null

);



insert into categoria (nombre) values ('categoría 1');
insert into categoria (nombre) values ('categoría 2');
insert into categoria (nombre) values ('categoría 3');
