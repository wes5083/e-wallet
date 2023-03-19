CREATE TABLE t_user
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name  VARCHAR(100) unique NOT NULL,
    password   VARCHAR(32)         NOT NULL,
    pass_key   VARCHAR(16)         NOT NULL,
    first_name VARCHAR(100)        NOT NULL,
    last_name  VARCHAR(100)        NOT NULL,
    email      VARCHAR(100)        NOT NULL,
    phone      VARCHAR(20)         NOT NULL,
    created_at DATETIME            NOT NULL,
    updated_at DATETIME            NOT NULL
);
CREATE INDEX index_t_user_account ON t_user (user_name);

CREATE TABLE t_wallet
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id    BIGINT         NOT NULL,
    balance    DECIMAL(20, 4) NOT NULL,
    currency   VARCHAR(10)    NOT NULL,
    created_at DATETIME       NOT NULL,
    updated_at DATETIME       NOT NULL,
    CONSTRAINT fk_t_wallet_user_id FOREIGN KEY (user_id) REFERENCES t_user (id)
);

CREATE TABLE t_wallet_transaction
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    wallet_id    BIGINT         NOT NULL,
    trans_type   VARCHAR(20)    NOT NULL,
    trans_amount DECIMAL(20, 4) NOT NULL,
    trans_time   DATETIME       NOT NULL,
    comment      VARCHAR(255)   NULL,
    created_at   DATETIME       NOT NULL,
    updated_at   DATETIME       NOT NULL,
    CONSTRAINT fk_t_wallet_transaction_wallet_id FOREIGN KEY (wallet_id) REFERENCES t_wallet (id)
);
