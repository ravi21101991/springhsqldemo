create table user_details (
id varchar(255) not null,
firstName varchar(100),
lastName varchar(100),
age integer,
gender varchar(10),
phone varchar(20),
zip varchar(20) null,
primary key (id));

insert into user_details (id, firstName, lastName, age, gender, phone, zip) values ('123', 'Ravi', 'Nair', 24, 'Male', '07927660045', '380061');