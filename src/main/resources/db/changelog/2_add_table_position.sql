--liquibase formatted sql

--changeset artak
--comment добавление таблицы position
CREATE TABLE position
(
    id   SERIAL PRIMARY KEY,
    name varchar(255) NOT NULL
);