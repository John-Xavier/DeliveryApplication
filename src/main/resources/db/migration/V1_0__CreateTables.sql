DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS driver;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS item_order;
DROP TABLE IF EXISTS order_audit;


CREATE TABLE customer
(
    id integer primary key auto_increment,
    full_name varchar(20) not null,
    house_number varchar(5) not null,
    street varchar(20) not null,
    town varchar(20) not null,
    postcode varchar(8) not null
);
CREATE TABLE driver
(
    id integer primary key auto_increment,
    driver_name varchar(20) not null
);
CREATE TABLE item
(
    id integer primary key auto_increment,
    item_name varchar(20) not null,
    price varchar(20) not null
);
CREATE TABLE item_order
(
    id integer primary key auto_increment,
    item_id integer not null,
    foreign key (item_id) references item(id),
    customer_id integer not null,
    foreign key (customer_id) references customer(id),
    order_date date,
    order_status varchar(20) not null
);
CREATE TABLE order_audit
(
    id integer primary key auto_increment,
    order_id integer not null,
    foreign key (order_id) references item_order(id),
    item_id integer not null,
    foreign key (item_id) references item(id)
);


INSERT INTO customer (full_name,house_number, street, town, postcode)
VALUES('John Xavier', '69', 'Mayer Street', 'Hanley', 'ST1 2JB'),
      ('Sanjo Joseph', '230', 'Horizon Road', 'Vile Village', 'TT12 6PD');

INSERT INTO driver (driver_name)
VALUES ('Alwin Joseph'),
       ('Remya Santhosh');

INSERT INTO item (item_name,price)
VALUES ('Flower Vase','250'),
       ('Scented Candle','121');