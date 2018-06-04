create database if not exists delivery;

create table cargo
(
ID_CARGO int auto_increment
primary key,
CARGO_NUMBER int null,
NAME varchar(255) null,
STATUS varchar(255) null,
WEIGHT int null
);

create table maps
(
ID_CITY int auto_increment
primary key,
CITY varchar(255) null,
LATITUDE double null,
LONGITUDE double null
);

create table waggons
(
ID_WAGGON int auto_increment
primary key,
CAPACITY int null,
REGISTRATION_NUMBER varchar(255) null,
SHIFT_SIZE int null,
STATUS varchar(255) null,
ID_CITY int null,
constraint FKc0g1au441uhy3lotn1l45ph3a
foreign key (ID_CITY) references maps (ID_CITY)
);

create table orders
(
ID_ORDER int auto_increment
primary key,
REGISTRATION_NUMBER_ORDER int null,
ORDER_STATUS varchar(255) null,
WAGGONS int null,
constraint FKqf9r4ybht0feeut4akgtn92d8
foreign key (WAGGONS) references waggons (ID_WAGGON)
);

create table drivers
(
ID_DRIVER int auto_increment
primary key,
HOURS_WORKED int null,
NAME varchar(255) null,
PERSONAL_NUMBER int null,
SECOND_NAME varchar(255) null,
STATUS varchar(255) null,
ID_CITY int null,
ID_ORDER int null,
ID_WAGGON int null,
constraint FK85791uqn3cvqh8k7wc4u2oovn
foreign key (ID_CITY) references maps (ID_CITY),
constraint FKh7133xn4rxdktgke9ouuow78y
foreign key (ID_ORDER) references orders (ID_ORDER),
constraint FK82a7vrvahfhxjduvocoxb5m82
foreign key (ID_WAGGON) references waggons (ID_WAGGON)
);

create index FK82a7vrvahfhxjduvocoxb5m82
on drivers (ID_WAGGON);

create index FK85791uqn3cvqh8k7wc4u2oovn
on drivers (ID_CITY);

create index FKh7133xn4rxdktgke9ouuow78y
on drivers (ID_ORDER);

create index FKqf9r4ybht0feeut4akgtn92d8
on orders (WAGGONS);

create index FKc0g1au441uhy3lotn1l45ph3a
on waggons (ID_CITY);

create table waggons_drivers
(
Waggon_ID_WAGGON int not null,
drivers_ID_DRIVER int not null,
constraint UK_tp3k0nmi54wkx64neldyushf7
unique (drivers_ID_DRIVER),
constraint FKp3qbd9grben878oy105l2046q
foreign key (Waggon_ID_WAGGON) references waggons (ID_WAGGON),
constraint FKmemljwxdr5qmmti1pn13upc6d
foreign key (drivers_ID_DRIVER) references drivers (ID_DRIVER)
);

create index FKp3qbd9grben878oy105l2046q
on waggons_drivers (Waggon_ID_WAGGON);

create table way_points
(
ID_WAY_POINT int auto_increment
primary key,
ORDER_TYPE varchar(255) null,
ID_CARGO int null,
ID_CITY int null,
ID_ORDER int null,
constraint FK4u8h983fwjqgpkmodis62w415
foreign key (ID_CARGO) references cargo (ID_CARGO),
constraint FKidw0fhu3c203ftrki0kegye65
foreign key (ID_CITY) references maps (ID_CITY),
constraint FKq3f0shesqq2p8mqjkojmorp1b
foreign key (ID_ORDER) references orders (ID_ORDER)
);

create index FK4u8h983fwjqgpkmodis62w415
on way_points (ID_CARGO);

create index FKidw0fhu3c203ftrki0kegye65
on way_points (ID_CITY);

create index FKq3f0shesqq2p8mqjkojmorp1b
on way_points (ID_ORDER);



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