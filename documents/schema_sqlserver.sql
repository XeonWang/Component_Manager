IF OBJECT_ID('dbo.Person', 'U') IS NOT NULL DROP TABLE dbo.Person;
create table Person (
    id int primary key identity,
    name varchar(10) not null unique
);

IF OBJECT_ID('dbo.Company', 'U') IS NOT NULL DROP TABLE dbo.Company;
create table Company (
    id int primary key identity,
    name varchar(100) not null unique
);

IF OBJECT_ID('dbo.Component_type', 'U') IS NOT NULL DROP TABLE dbo.Component_type;
create table Component_type (
    id int primary key identity,
    name varchar(50) not null unique
);

IF OBJECT_ID('dbo.Type_field', 'U') IS NOT NULL DROP TABLE dbo.Type_field;
create table Type_field (
    id int primary key identity,
    name varchar(20) not null,
    type varchar(20),
    type_id int,
    foreign key(type_id) references Component_type(id)
);

IF OBJECT_ID('dbo.Component', 'U') IS NOT NULL DROP TABLE dbo.Component;
create table Component (
    id varchar(20) primary key,
    amount int not null,
    type_id int not null,
    foreign key (type_id) references Component_type(id)
);

IF OBJECT_ID('dbo.Component_in', 'U') IS NOT NULL DROP TABLE dbo.Component_in;
create table Component_in (
    id int primary key identity,
    component_id varchar(20) not null,
    change_date date not null,
    change_count int not null,
    price int,
    company_id int,
    actionId varchar(10),
    mark nvarchar(40),
    foreign key (component_id) references Component(id),
    foreign key (company_id) references Company(id)
);

IF OBJECT_ID('dbo.Component_out', 'U') IS NOT NULL DROP TABLE dbo.Component_out;
create table Component_out (
	id int primary key identity,
	component_id varchar(20) not null,
	change_date date not null,
	change_count int not null,
	eid varchar(20),
	person_id int,
	mark nvarchar(40),
	foreign key (component_id) references Component(id),
	foreign key (person_id) references Person(id)
);

IF OBJECT_ID('dbo.Out_action', 'U') IS NOT NULL DROP TABLE dbo.Out_action;
create table Out_action (
	out_id int not null,
	actionId varchar(10),
	count int,
	primary key (out_id, actionId)
);