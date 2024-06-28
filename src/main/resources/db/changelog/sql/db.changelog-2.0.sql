--liquibase formatted sql

--changeset zlatovchena:1
--comment: insert users table
insert into users (login, password)
values ('ivan', '1'),
       ('masha', '1');

--changeset zlatovchena:2
--comment: insert users_profiles table
insert into user_profiles (user_id, name, age, photo, city, height,description, zodiac_sign)
values (1, 'Ivan', 25, '---', 'Rzn', 180, 'I like coffe', 'ARIES'),
       (2, 'Masha', 22, '---', 'Rzn', 170, 'I am a programmer', 'LEO');

--changeset zlatovchena:3
--comment: insert users_contacts table
insert into user_contacts (user_id, telegram, phone_number)
values (1, '@ivan', '89105038707'),
       (2, '@masha', '89206352885');
