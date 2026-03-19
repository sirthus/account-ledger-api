INSERT INTO customers (customer_id, full_name, email)
VALUES
    (1, 'Alice Martin',  'alice@example.com'),
    (2, 'Bob Chen',      'bob@example.com'),
    (3, 'Carol Diaz',    'carol@example.com')
ON CONFLICT DO NOTHING;

INSERT INTO accounts (account_id, customer_id, account_type, status, balance_cents)
VALUES
    (101, 1, 'checking', 'active',  250000),
    (102, 1, 'savings',  'active', 1000000),
    (103, 2, 'checking', 'active',   75000),
    (104, 3, 'checking', 'frozen',   12000)
ON CONFLICT DO NOTHING;

INSERT INTO transactions (account_id, direction, amount_cents, description)
VALUES
    (101, 'C', 100000, 'Opening deposit'),
    (101, 'C', 200000, 'Payroll deposit'),
    (101, 'D',  50000, 'Rent payment'),
    (102, 'C', 100000, 'Opening deposit'),
    (103, 'C',  75000, 'Opening deposit'),
    (104, 'C',  12000, 'Opening deposit');
