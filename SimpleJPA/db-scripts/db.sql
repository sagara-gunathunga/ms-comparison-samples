CREATE DATABASE users;
USE users;
CREATE TABLE IF NOT EXISTS user (
             id INT AUTO_INCREMENT,
             firstname VARCHAR (20),
             lastname VARCHAR (20),
             PRIMARY KEY (id)
)ENGINE INNODB;