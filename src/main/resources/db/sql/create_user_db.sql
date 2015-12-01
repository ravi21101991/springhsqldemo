create table user_details (
id varchar(255) not null,
first_name varchar(100),
last_name varchar(100),
age integer,
gender varchar(10),
phone varchar(20),
zip varchar(20) null,
primary key (id));

insert into user_details (id, first_name, last_name, age, gender, phone, zip) values ('123', 'Ravi', 'Nair', 24, 'Male', '07927660045', '380061');
insert into user_details (id, first_name, last_name, age, gender, phone, zip) values ('124', 'Dhara', 'Nair', 24, 'Female', '07927660045', '380061');