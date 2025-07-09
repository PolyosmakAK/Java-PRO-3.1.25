CREATE TABLE IF NOT EXISTS users
(
    id BIGINT PRIMARY KEY NOT NULL,
    username VARCHAR(255)       NOT NULL
);

CREATE TABLE IF NOT EXISTS products
(
    id BIGINT PRIMARY KEY NOT NULL,
    account_number VARCHAR(255),
    balance BIGINT,
    product_type   VARCHAR(255),
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

INSERT INTO users (id, username)
VALUES (1, 'Вася'),
       (2, 'Коля'),
       (3, 'Петя');

INSERT INTO products(id, account_number, balance, product_type, user_id)
VALUES (1, '1234-er', 500, 'CARD', 1),
       (2, '6677889900', 99800, 'CARD', 1);