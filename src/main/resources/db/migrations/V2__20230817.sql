
CREATE TABLE IF NOT EXISTS recipients(
    id varchar(36) PRIMARY KEY DEFAULT gen_random_uuid(),
    channel varchar(256) NOT NULL ,
    address varchar(1024),
    fullName varchar(255)
);

ALTER TABLE notifications
ADD CONSTRAINT fk_notifications_recipient_uid
FOREIGN KEY (recipient_uid) REFERENCES recipients(id);
