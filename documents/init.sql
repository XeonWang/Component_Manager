drop table if exists Person;
create table Person (
    id int(10) primary key auto_increment,
    name varchar(10) not null
);

drop table if exists Company;
create table Company (
    id int(10) primary key auto_increment,
    name varchar(100) not null
);

drop table if exists Component_type;
create table Component_type (
    id int(10) primary key auto_increment,
    name varchar(50) not null
);

drop table if exists Type_field;
create table Type_field (
    id int(10) primary key auto_increment,
    name varchar(20) not null,
    type varchar(20),
    type_id int(10),
    foreign key(type_id) references Component_type(id)
);

drop table if exists Component;
create table Component (
    id varchar(20) primary key,
    amount int(10) not null,
    type_id int(10) not null,
    foreign key (type_id) references Component_type(id)
);