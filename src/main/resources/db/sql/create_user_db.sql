create table user_details (
id varchar(255) not null,
first_name varchar(100),
last_name varchar(100),
middle_name varchar(100),
age integer,
gender varchar(10),
phone varchar(20),
zip varchar(20) null,
primary key (id));