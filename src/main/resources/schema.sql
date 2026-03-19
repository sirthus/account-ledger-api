CREATE TABLE IF NOT EXISTS customers (
    customer_id   INTEGER      NOT NULL PRIMARY KEY,
    full_name     TEXT         NOT NULL,
    email         TEXT
);

CREATE TABLE IF NOT EXISTS accounts (
    account_id    INTEGER      NOT NULL PRIMARY KEY,
    customer_id   INTEGER      NOT NULL REFERENCES customers(customer_id),
    account_type  TEXT         NOT NULL,
    status        TEXT         NOT NULL DEFAULT 'active',
    balance_cents BIGINT       NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS transactions (
    txn_id        INTEGER      GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    account_id    INTEGER      NOT NULL REFERENCES accounts(account_id),
    direction     CHAR(1)      NOT NULL,
    amount_cents  BIGINT       NOT NULL,
    description   TEXT,
    created_at    TIMESTAMPTZ  NOT NULL DEFAULT now()
);
