CREATE TABLE users (
                       id BIGINT PRIMARY KEY NOT NULL,
                       username VARCHAR(255) NOT NULL
);

INSERT INTO users (id, username)
VALUES  (1,'Вася'),
        (2, 'Коля'),
        (3, 'Петя');