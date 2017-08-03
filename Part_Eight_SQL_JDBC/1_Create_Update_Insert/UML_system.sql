create database testDB;

create table users (name character varying (250) primary key, role character varying (250), roleRights character varying (250));

create table aplications (name character varying (250) primary key, comment character varying (250), status boolean, categories character varying (250), responsible character varying (250) references users(name));

insert into users(name, role, roleRights) values ('anton', 'student', 'study');

insert into aplications(name, comment, status, categories, responsible) values ('task1', 'my first task', true, 'sql', 'anton');
