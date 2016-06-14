/*
CREATE TABLE `Role` (
	`Role_id` bigint NOT NULL AUTO_INCREMENT,
	`Title` varchar(50) NOT NULL,
	PRIMARY KEY (`Role_id`)
);*/

/*
CREATE TABLE `User` (
	`User_id` bigint NOT NULL AUTO_INCREMENT,
	`Name` varchar(50) NOT NULL,
	`Surname` varchar(50) NOT NULL,
	`Login` varchar(50) NOT NULL,
	`Password` varchar(50) NOT NULL,
	`Age` int NOT NULL,
	`Role_id` bigint NOT NULL,
	PRIMARY KEY (`User_id`)
	/*FOREIGN KEY (`Role_id`) REFERENCES `Role`(`Role_id`) ON DELETE cascade
);

CREATE TABLE `Address` (
	`Address_id` bigint NOT NULL,
	`Address` varchar(250) NOT NULL,
	PRIMARY KEY (`Address_id`),
	FOREIGN KEY (`Address_id`) REFERENCES `User`(`User_id`) ON DELETE CASCADE
);
*/

/*
CREATE TABLE `Musictype` (
	`Musictype_id` bigint NOT NULL AUTO_INCREMENT,
	`Musictype_name` varchar(50) NOT NULL,
	PRIMARY KEY (`Musictype_id`)
);

CREATE TABLE `UserMusicType` (
	`User_id` bigint NOT NULL,
	`Musictype_id` bigint NOT NULL,
	FOREIGN KEY (`Musictype_id`) REFERENCES `Musictype`(`Musictype_id`) ON DELETE cascade,
	FOREIGN KEY (`User_id`) REFERENCES `User`(`User_id`) ON DELETE cascade
);
*/

/*
insert into role (Title) value("Admin");
insert into role (Title) value("Moderator");
insert into role (Title) value("User");
insert into role (Title) value("Noob");*/

/*
insert into user (Name,Surname,Login,Password, Age, Role_id) 
	value("Denis","Balobanov","dennn2","1234",23,1);
    
insert into user (Name,Surname,Login,Password,Age, Role_id) 
	value("Vova","Ryhlyuk","vovka","noob231",22,3);
    
insert into user (Name,Surname,Login,Password,Age, Role_id) 
	value("Muzhik","Pipir","pipka","15999",60,4);
    
insert into user (Name,Surname,Login,Password,Age, Role_id) 
	value("Dimon","Panasenko","ananas","8897",22,3);
    
    insert into user (Name,Surname,Login,Password,Age, Role_id) 
	value("Suub","Zero","ananas","21124124",29,2);*/


/*
insert into Address (Address_id ,Address) value(1,"Rivendel");
insert into Address (Address_id ,Address) value(4,"Mordor");
insert into Address (Address_id ,Address) value(2,"Rohan");
insert into Address (Address_id ,Address) value(3,"Gondor");
*/

/*
insert into Musictype (Musictype_name) value("ROCK");
insert into Musictype (Musictype_name) value("MITOL");
insert into Musictype (Musictype_name) value("MENTOL");
insert into Musictype (Musictype_name) value("MENTAL");
*/


/*
insert into UserMusicType  value(1,1);
insert into UserMusicType  value(1,2);
insert into UserMusicType  value(1,3);
insert into UserMusicType  value(1,4);
insert into UserMusicType  value(2,3);
insert into UserMusicType  value(2,1);
insert into UserMusicType  value(4,2);
insert into UserMusicType  value(4,4);*/

/*Delete from Address where `Address_id` = 2;*/