create database if not exists delivery;

create table MAPS(
  ID_CITY INT NOT NULL AUTO_INCREMENT,
  CITY VARCHAR(30) UNIQUE,
  LATITUDE DOUBLE,
  LONGITUDE DOUBLE,
  PRIMARY KEY(ID_CITY)
);

create table WAGGONS(
  ID_WAGGON INT NOT NULL AUTO_INCREMENT,
  REGISTRATION_NUMBER VARCHAR(7) NOT NULL UNIQUE,
  SHIFT_SIZE INT,
  ID_CITY INT NOT NULL,
  CAPACITY INT NOT NULL,
  STATUS ENUM('BROKEN', 'WORKING') NOT NULL,
  PRIMARY KEY(ID_WAGGON),
  CONSTRAINT MAPS_ID_CITY_FK
  FOREIGN KEY(ID_CITY)
  REFERENCES MAPS (ID_CITY)
);
create table CARGO(
  ID_CARGO INT NOT NULL AUTO_INCREMENT,
  CARGO_NUMBER INT NOT NULL,
  NAME VARCHAR(30) NOT NULL UNIQUE,
  WEIGHT INT NOT NULL,
  STATUS ENUM('PREPARED','SHIPPED','ADDED') NOT NULL,
  PRIMARY KEY(ID_CARGO)
);
create table DRIVERS(
  ID_DRIVER INT NOT NULL AUTO_INCREMENT,
  PERSONAL_NUMBER INT(20) NOT NULL,
  NAME VARCHAR(30) NOT NULL,
  SECOND_NAME VARCHAR(50) NOT NULL,
  HOURS_WORKED INT NOT NULL,
  STATUS ENUM('REST','SHIFT','DRIVING'),
  ID_CITY INT NOT NULL,
  ID_WAGGON INT NOT NULL,
  PRIMARY KEY(ID_DRIVER),
  FOREIGN KEY (ID_CITY) REFERENCES MAPS(ID_CITY),
  FOREIGN KEY(ID_WAGGON)   REFERENCES WAGGONS(ID_WAGGON)
  );
  create table WAY_POINTS(
  ID_WAY_POINT INT NOT NULL AUTO_INCREMENT,
  ORDER_TYPE ENUM('LOADING','LANDING'),
  ID_CITY INT NOT NULL,
  ID_CARGO INT NOT NULL,
  PRIMARY KEY (ID_WAY_POINT),
  FOREIGN KEY (ID_CARGO) REFERENCES CARGO(ID_CARGO),
  FOREIGN KEY (ID_CITY) REFERENCES MAPS(ID_CITY)
);

create table ORDERS(
  ID_ORDER INT NOT NULL AUTO_INCREMENT,
  ORDER_STATUS ENUM('COMPLETED','NOTCOMPLETED') NOT NULL,
  REGISTRATION_NUMBER_ORDER INT NOT NULL,
  ID_WAGGON INT NOT NULL,
  ID_DRIVER INT NOT NULL,
  ID_WAY_POINT INT NOT NULL,
  PRIMARY KEY(ID_ORDER),
  CONSTRAINT WAGGONS_ID_WAGGON_FK
  FOREIGN KEY(ID_WAGGON)
  REFERENCES WAGGONS(ID_WAGGON),
  FOREIGN KEY(ID_WAY_POINT)
  REFERENCES WAY_POINTS(ID_WAY_POINT)

);
create table users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
);
create table authorities (
	username varchar(50) not null primary key,
	authority varchar(50) not null,
	constraint fk_authorities_users
    foreign key(username)
    references users(username)
);
create table user_driver(
	Id_UserDriver int not null AUTO_INCREMENT primary key,
	Id_user INT NOT NULL,
    Id_driver INT NOT NULL
);

create unique index ix_auth_username on authorities (username,authority);

insert into users(username,password,enabled)
	values('admin','$2a$10$hbxecwitQQ.dDT4JOFzQAulNySFwEpaFLw38jda6Td.Y/cOiRzDFu',true);
insert into authorities(username,authority)
	values('admin','ROLE_ADMIN');

    insert into users(username,password,enabled)
	values('driver','$2a$10$xjNJyrHyzJ96ZKx88xv1tuyNynhiv1Yg4Ryhq5vbJ6R.4txqWW346',true);
insert into authorities(username,authority)
	values('driver','ROLE_DRIVER');

    insert into users(username,password,enabled)
	values('manager','$2a$10$Q3A/utFNh42vWQ33y1TveOfB/3T3VCGHxucV2EZqq.iEiIkI/Qh5u',true);
insert into authorities(username,authority)
	values('manager','ROLE_MANAGER');

INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Moscow', 55.755773, 37.617761);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Voronezh', 51.661535, 39.200287);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Arhangelsk', 64.539304, 40.518735);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Ekaterinburg', 56.838002, 60.597295);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Murmansk', 68.96956299999999, 33.07454);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Perm', 58.004785, 56.237654);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Tver', 56.859611, 35.911896);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Habarovsk', 48.472584, 135.057732);
