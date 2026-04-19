create database travelmanagementsystem;
show databases;
use travelmanagementsystem;
create table account(username varchar(20), name varchar(20), password varchar(20), security varchar(100), answer varchar(50));
show tables;
select * from account;
create table customer(username varchar(20), id varchar(30), number varchar(30), name varchar(20), gender varchar(20), country varchar(30), address varchar(50), phone varchar(15), emai varchar(40));
alter table customer change emai email varchar(40);
select * from customer;
create table bookPackage(username varchar(20), package varchar(30), persons varchar(20), id varchar(30), number varchar(30), phone varchar(20),price varchar(20));
select * from bookPackage;
create table hotels(name varchar(30), cost_per_day varchar(20), food_charges varchar(10), ac_charges varchar(10));
INSERT INTO hotels VALUES
('JW Marriott Hotel', 5000, 1000, 1500),
('Mandarin Oriental Hotel', 6000, 1200, 1800),
('Four Seasons Hotel', 7000, 1500, 2000),
('Radisson Hotel', 4000, 800, 1200),
('Classio Hotel', 3000, 500, 800),
('The Bay Club Hotel', 5500, 1100, 1600),
('Breeze Blows Hotel', 3500, 700, 900),
('Quick Stop Hotel', 2000, 300, 500),
('Happy Mornings Motel', 2500, 400, 600),
('Moss View Hotel', 3200, 600, 850);
select * from hotels;
create table bookHotel(username varchar(20), name varchar(30), persons int, days int, ac varchar(10), food varchar(10), id varchar(20), number varchar(20), phone varchar(20), price int);
select * from bookHotel;