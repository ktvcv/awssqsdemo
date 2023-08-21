CREATE EXTENSION pgcrypto;

CREATE TABLE IF NOT EXISTS notifications(
    id varchar(36) PRIMARY KEY DEFAULT gen_random_uuid(),
    subject varchar(256) NOT NULL ,
    text TEXT,
    recipient_uid varchar(36)
);