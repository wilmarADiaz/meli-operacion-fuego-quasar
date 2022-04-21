

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '123456';

CREATE USER 'topsecret'@'localhost' IDENTIFIED BY '123456';
GRANT SELECT, INSERT, UPDATE, DELETE ON quasar_operation_db.* TO 'topsecret'@'localhost';

CREATE database quasar_operation_db;

CREATE TABLE quasar_operation_db.satellite_position (
    id SMALLINT NOT NULL AUTO_INCREMENT,    
    name VARCHAR(100),
    x NUMERIC,
    y NUMERIC,
    PRIMARY KEY (id)
);

CREATE TABLE quasar_operation_db.satellite_message (
    id mediumint auto_increment,    
    name VARCHAR(100),
    distance NUMERIC,
    message VARCHAR(200),
    PRIMARY KEY (id)
);


INSERT INTO quasar_operation_db.satellite_position (id, name, x, y)
VALUES (1, "kenobi", -500, -200);
INSERT INTO quasar_operation_db.satellite_position (id, name, x, y)
VALUES (2, "skywalker", 100, -100);
INSERT INTO quasar_operation_db.satellite_position (id, name, x, y)
VALUES (3, "sato", 500, 100);
commit;