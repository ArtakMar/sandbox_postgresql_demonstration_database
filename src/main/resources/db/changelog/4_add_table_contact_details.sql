--liquibase formatted sql

--changeset artak
--comment добавление contact_details
CREATE TABLE contact_details
(
    id           BIGSERIAL PRIMARY KEY,
    employeeId   int references employee (id),
    email        varchar(128) NOT NULL,
    phone_number varchar(64)  NOT NULL
);