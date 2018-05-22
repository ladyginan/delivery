create database if not exists delivery;

create table MAPS(
  ID_CITY INT(15) NOT NULL AUTO_INCREMENT,
  CITY VARCHAR(30) UNIQUE,
  LATITUDE DOUBLE,
  LONGITUDE DOUBLE,
  PRIMARY KEY(ID_CITY)
);

create table WAGGONS(
  ID_WAGGON INT(15) NOT NULL AUTO_INCREMENT,
  REGISTRASION_NUMBER VARCHAR(7) NOT NULL UNIQUE,
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
  ID_CARGO INT(15) NOT NULL AUTO_INCREMENT,
  CARGO_NUMBER INT NOT NULL,
  NAME VARCHAR(30) NOT NULL UNIQUE,
  WEIGHT INT NOT NULL,
  STATUS ENUM('PREPARED','SHIPPED','ADDED') NOT NULL,
  PRIMARY KEY(ID_CARGO)
);
create table DRIVERS(
  ID_DRIVER INT(15) NOT NULL AUTO_INCREMENT,
  PERSONAL_NUMBER(15) NOT NULL,
  NAME VARCHAR(30) NOT NULL,
  SECOND_NAME VARCHAR(30) NOT NULL,
  HOURS_WORKED INT NOT NULL,
  STATUS ENUM('REST','SHIFT','DRIVING'),
  ID_CITY INT NOT NULL,
  ID_WAGGON INT NOT NULL,
  PRIMARY KEY(ID_DRIVER),
  FOREIGN KEY (ID_CITY) REFERENCES MAPS(ID_CITY),
  FOREIGN KEY(ID_WAGGON)   REFERENCES WAGGONS(ID_WAGGON)
  );
  create table WAY_POINTS(
  ID_WAY_POINT INT(15) NOT NULL AUTO_INCREMENT,
  ORDER_TYPE ENUM('LOADING','LANDING'),
  ID_CITY INT NOT NULL,
  ID_CARGO INT NOT NULL,
  PRIMARY KEY (ID_WAY_POINT),
  FOREIGN KEY (ID_CARGO) REFERENCES CARGO(ID_CARGO),
  FOREIGN KEY (ID_CITY) REFERENCES MAPS(ID_CITY)
);

create table ORDERS(
  ID_ORDER INT(15) NOT NULL AUTO_INCREMENT,
  ORDER_STATUS ENUM('YES','NO') NOT NULL,
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

INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Москва', 55.755773, 37.617761);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Воронеж', 51.661535, 39.200287);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Архангельск', 64.539304, 40.518735);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Екатеринбург', 56.838002, 60.597295);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Мурманск', 68.96956299999999, 33.07454);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Пермь', 58.004785, 56.237654);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Тверь', 56.859611, 35.911896);
INSERT INTO MAPS(CITY, LATITUDE, LONGITUDE) value ('Хабаровск', 48.472584, 135.057732);
