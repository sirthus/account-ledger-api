# Account Ledger API

A Spring Boot REST API for querying account balances and transaction history. Built as a learning project to develop familiarity with Spring Web, Spring Data JDBC, and Spring testing patterns.

## Prerequisites

- Java 21
- Maven
- Docker (PostgreSQL running via Docker Desktop)

## Database setup

The `ledger` database must exist in your local PostgreSQL container:

```bash
docker exec pg18 psql -U postgres -c "CREATE DATABASE ledger;"
```

## Running the app

```bash
mvn spring-boot:run
```

The app starts on port 8080. Schema and seed data are applied automatically on startup.

## Running tests

```bash
mvn test
```

## Endpoints

### Customers

```
GET /customers/{id}           Customer details
GET /customers/{id}/accounts  All accounts for a customer
```

### Accounts

```
GET /accounts/{id}                Account details and balance
GET /accounts/{id}/transactions   Transaction history (newest first)
```

## Project structure

```
src/main/java/com/modernize/ledger/
  controller/    HTTP layer — maps requests to service calls
  service/       Business logic — calls repositories
  repository/    Data access — Spring Data JDBC interfaces
  model/         Domain objects — map to database tables

src/main/resources/
  schema.sql     Table definitions (auto-run on startup)
  data.sql       Seed data (auto-run on startup)
  application.yml

src/test/
  resources/application-test.yml   Test profile (points at local ledger database)
```

## Seed data

| Customer | Accounts |
|---|---|
| Alice Martin (id: 1) | Checking 101 ($2,500), Savings 102 ($10,000) |
| Bob Chen (id: 2) | Checking 103 ($750) |
| Carol Diaz (id: 3) | Checking 104 ($120, frozen) |
