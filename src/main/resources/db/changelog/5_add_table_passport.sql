--liquibase formatted sql

--changeset artak
--comment добавление passport
CREATE TABLE passport
(
    id              SERIAL PRIMARY KEY,
    passport_number varchar(20) UNIQUE NOT NULL
);