# CLAUDE.md

This file provides guidance to Claude Code when working in this repository.

## Commands

```bash
# Run the app
mvn spring-boot:run

# Run tests
mvn test

# Build without running
mvn package
```

Note: pom.xml is at the repo root — there is no app/ subdirectory. Do not use `cd app`.

## Database

- Local PostgreSQL container: `pg18`
- Database: `ledger`
- No separate dev/test/prod profiles — test profile points at the same `ledger` database on localhost:5432

## Architecture

Standard Spring Boot layered REST API:

```
controller/ → service/ → repository/ → database
```

- **Models** (`model/`) map to database tables via Spring Data JDBC
- **Repositories** (`repository/`) are Spring Data JDBC interfaces — no implementation classes
- **Services** (`service/`) hold business logic and call repositories
- **Controllers** (`controller/`) handle HTTP and call services

## Project phases

### Phase 1 (current): Read-only
GET endpoints for customers, accounts, and transaction history.

### Phase 2: Read-write
POST endpoints to create customers, open accounts, and post transactions.
Introduces request validation, error handling, and transactional writes.

### Phase 3: Adapt to bank-modernization
Swap datasource to point at `modernize_dev`. Domain model kept close to
`bank-modernization` schema intentionally to make this migration low-effort.

## Branch strategy

`main` only — no dev/test/prod promotion flow. This is a learning project,
not a production pipeline.
