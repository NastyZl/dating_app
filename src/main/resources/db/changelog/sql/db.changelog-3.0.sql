--liquibase formatted sql

--changeset zlatovchena:1
--comment: add column description to user_profile table
alter table if exists user_profiles
add description varchar(255);