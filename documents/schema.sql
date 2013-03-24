drop table if exists Person;
create table Person (
    id int(10) primary key auto_increment,
    name varchar(10) not null
);

drop table if exists Company;
create table Company (
    id int(10) primary key auto_increment,
    name varchar(100) not null,
    unique key (name)
);

drop table if exists Component_type;
create table Component_type (
    id int(10) primary key auto_increment,
    name varchar(50) not null,
    unique key (name)
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

drop table if exists Component_in;
create table Component_in (
    id int(10) primary key auto_increment,
    component_id varchar(20) not null,
    change_date date not null,
    change_count int(10) not null,
    price int(10),
    company_id int(10),
    actionId varchar(10),
    mark nvarchar(40),
    foreign key (component_id) references Component(id),
    foreign key (company_id) references Company(id)
);

drop table if exists Component_out;
create table Component_out (
	id int(10) primary key auto_increment,
	component_id varchar(20) not null,
	change_date date not null,
	change_count int(10) not null,
	eid varchar(20),
	person_id int(10),
	mark nvarchar(40),
	foreign key (component_id) references Component(id),
	foreign key (person_id) references Person(id)
);

drop table if exists Out_action;
create table Out_action (
	out_id int(10) not null,
	actionId varchar(10),
	count int(10),
	primary key (out_id, actionId)
);