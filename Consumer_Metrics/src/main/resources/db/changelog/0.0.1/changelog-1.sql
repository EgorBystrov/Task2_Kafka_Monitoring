-- liquibase formatted sql
-- changeset EgorBystrov:1
-- comment: Create tables for Task1

create TABLE Metrics
(
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name varchar(200),
    description varchar(200),
    base_unit varchar(200)
);

create TABLE Measurements
(
    id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    metrics_id int REFERENCES Metrics(id) ON DELETE SET NULL,
    statistic varchar(200),
    value DECIMAL
)