drop database if exists den;
create database den;
use den;

CREATE TABLE `User` (
	`user_id` int NOT NULL AUTO_INCREMENT,
	`user_name` varchar(255) NOT NULL,
	`user_lastname` varchar(255) NOT NULL,
	`login` varchar(255) NOT NULL UNIQUE,
	`user_password` varchar(255) NOT NULL,
	`cardiovascular_system_id` int,
	`saturation_id` int,
	`diabet_id` int,
	`group_id` int NOT NULL,
	`address_id` int NOT NULL,
    `grade` float,
	PRIMARY KEY (`user_id`)
);

CREATE TABLE `Cardiovascular_system` (
	`cardiovascular_system_id` int NOT NULL AUTO_INCREMENT,
	`diastolic` int NOT NULL,
	`systolic` int NOT NULL,
	`temperature` FLOAT NOT NULL,
	`pulse` int NOT NULL,
	PRIMARY KEY (`cardiovascular_system_id`)
);

CREATE TABLE `Diabet` (
	`diabet_id` int NOT NULL AUTO_INCREMENT,
	`sugar` FLOAT NOT NULL,
	PRIMARY KEY (`diabet_id`)
);

CREATE TABLE `Saturation` (
	`saturation_id` int NOT NULL AUTO_INCREMENT,
	`oxygen` FLOAT NOT NULL,
	PRIMARY KEY (`saturation_id`)
);

CREATE TABLE `Groups` (
	`group_id` int NOT NULL AUTO_INCREMENT,
	`group_name` varchar(255) NOT NULL UNIQUE,
	PRIMARY KEY (`group_id`)
);

CREATE TABLE `Address` (
	`address_id` int NOT NULL AUTO_INCREMENT,
	`address` varchar(255) NOT NULL,
	PRIMARY KEY (`address_id`)
);

ALTER TABLE `User` ADD CONSTRAINT `User_fk0` FOREIGN KEY (`cardiovascular_system_id`) REFERENCES `Cardiovascular_system`(`cardiovascular_system_id`);

ALTER TABLE `User` ADD CONSTRAINT `User_fk1` FOREIGN KEY (`saturation_id`) REFERENCES `Saturation`(`saturation_id`);

ALTER TABLE `User` ADD CONSTRAINT `User_fk2` FOREIGN KEY (`diabet_id`) REFERENCES `Diabet`(`diabet_id`);

ALTER TABLE `User` ADD CONSTRAINT `User_fk3` FOREIGN KEY (`group_id`) REFERENCES `Groups`(`group_id`);

ALTER TABLE `User` ADD CONSTRAINT `User_fk4` FOREIGN KEY (`address_id`) REFERENCES `Address`(`address_id`);

insert into `Groups`(group_name) values("Admin");
insert into `Groups`(group_name) values("Patient");

insert into address(address) values("Kharkov");
insert into `user`(user_name, user_lastname, login, user_password, group_id, address_id)
	values("Denis", "BALOBANOV", "DENNNN", "bcb15f821479b4d5772bd0ca866c00ad5f926e3580720659cc80d39c9d09802a", 1, 1);


drop view if exists view_users_groups;

create view view_users_groups as
select u.user_id, g.group_name, u.login, u.user_password
from `User` as u
natural join `Groups` as g;

select * from view_users_groups;
