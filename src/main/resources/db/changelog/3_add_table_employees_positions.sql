--liquibase formatted sql

--changeset artak
--comment добавление employees_positions
CREATE TABLE employees_positions
(
    positionId int references position (id),
    employeeId int references employee (id),
    primary key (positionId, employeeId)
);