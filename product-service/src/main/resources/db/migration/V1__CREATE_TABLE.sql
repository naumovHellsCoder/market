drop table if exists comment;
drop table if exists image;
drop table if exists product;

/* CREATE TABLES */


/*COMMENT */
create table comment (id integer not null auto_increment,
text varchar(255),
product_id integer,
primary key (id));

/*IMAGE */
create table image (id integer not null auto_increment,
file_path varchar(255),
typeImg varchar(255),
product_id integer,
primary key (id))

/* PRODUCT */
create table product (id integer not null auto_increment,
description varchar(255),
name varchar(255),
price double precision,
primary key (id));


/*INSERTS */
INSERT INTO product (description, name, price) VALUES ('Phone X', 'Phone X', 12000);
INSERT INTO image (file_path, typeImg, product_id) VALUES  ('./images/test.jpg', 'image/jpg', 1 );
INSERT INTO comment (text, product_id) VALUES ('goof product', 1);