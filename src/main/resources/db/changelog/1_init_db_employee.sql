--liquibase formatted sql

--changeset artak
--comment добавление таблицы employee
CREATE TABLE employee
(
    id          SERIAL PRIMARY KEY,
    passport_id SERIAL REFERENCES passport (id),
    name        varchar(255) NOT NULL,
    age         int          NOT NULL
);