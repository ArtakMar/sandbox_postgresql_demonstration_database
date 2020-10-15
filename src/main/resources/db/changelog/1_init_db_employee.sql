--liquibase formatted sql

--changeset artak
--comment добавление таблицы employee
CREATE TABLE employee
(
    id   SERIAL PRIMARY KEY,
    name varchar(255) NOT NULL,
    age  int          NOT NULL
);