--Swedbank demo database 
--Person table
CREATE TABLE person
(
    pid         bigint PRIMARY KEY,
    first_name  varchar(255) not null,
    middle_name varchar(255),
    last_name   varchar(255) not null,
    email       varchar(255),
    phone       varchar(255)
);


--Person data
insert into person
    (pid, first_name, middle_name, last_name, email, phone)
values (38202020577,
        'Testas',
        '',
        'Testauskas',
        'test@test.com',
        '+37060035645'),
       (38202020576,
        'Testas1',
        '',
        'Testauskas1',
        'test1@test.com',
        '+37060035646');