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
    driver_name varchar(20) not null,
    driver_phone_number varchar(20) not null
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
    order_date date,
    order_status varchar(20) not null,
    customer_id integer not null,
    foreign key (customer_id) references customer(id)

);
CREATE TABLE order_audit
(
    id integer primary key auto_increment,
    item_id integer not null,
    order_id integer,
    foreign key (order_id) references item_order(id)
);
CREATE TABLE delivery_route
(
    id integer primary key auto_increment,
    start_location varchar(40) not null,
    end_location varchar(40) not null,
    estimated_time varchar(20) not null,
    driver_id integer,
    foreign key (driver_id) references driver(id)
);


INSERT INTO customer (full_name,house_number, street, town, postcode)
VALUES('John Xavier', '69', 'Mayer Street', 'Hanley', 'ST1 2JB'),
      ('Sanjo Joseph', '230', 'Horizon Road', 'Vile Village', 'TT12 6PD');

INSERT INTO driver (driver_name,driver_phone_number)
VALUES ('Alwin Joseph','+44 99456784357'),
       ('Remya Santhosh','+44 99456784357');

INSERT INTO item (item_name,price)
VALUES ('Axe body spray','2.2'),
       ('Nivea body lotion','1.0'),
       ('Digestive biscutes','0.5'),
       ('Runny Honey','1.2'),
       ('Basmati Rice','2.4'),
       ('Spaghetti Pasta','1.0'),
       ('Smart Watch','24'),
       ('Amazon alexa','200'),
       ('Dried nuts mix','3.0'),
       ('Trainers','250'),
       ('Scented Candle','12');