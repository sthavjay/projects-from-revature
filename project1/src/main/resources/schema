create table boba(
id serial primary key,
flavor varchar(50),
description varchar (100),
price integer
);

create table customer (
id serial primary key,
firstName varchar(50),
lastName varchar(50)
);

create table customer_boba (
boba_id integer references boba(id),
customer_id integer references customer(id)
--primary key boba_id, customer_id 
);