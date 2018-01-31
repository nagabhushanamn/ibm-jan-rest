

create database shop_db;
use shop_db;

create table shop_db.PRODUCTS(
	id int primary key auto_increment,
	name varchar(30),
	image_path varchar(50),
	price double,
	make_date date,
	description varchar(256)
);


create table shop_db.REVIEWS(
	id int primary key auto_increment,
	stars int,
	author varchar(30),
	body varchar(256),
	product_id int references shop_db.PRODUCTS(id)
);



create table shop_db.ORDERS(
	id int primary key auto_increment,
	total_cost double,
	completed int,
	description varchar(256) 
);



//-----------------------------------------------------



# sample data

insert into shop_db.PRODUCTS values(1,'LAPTOP','images/Laptop.png',198000.00,'2018/01/29','New Mac pro');
insert into shop_db.PRODUCTS values(2,'MOBILE','images/Mobile.png',18000.00,'2018/01/29','New  pro');


insert into shop_db.REVIEWS values(1,5,'nag@gmail.com','good one',1);
insert into shop_db.REVIEWS values(2,3,'nag@gmail.com','bad one',1);

insert into shop_db.REVIEWS values(3,5,'nag@gmail.com','good one',2);
insert into shop_db.REVIEWS values(4,2,'nag@gmail.com','good one',2);