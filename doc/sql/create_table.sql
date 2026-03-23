CREATE DATABASE sample_db;

CREATE USER 'sample_admin'@'%' IDENTIFIED BY 'sample1!@#$%';
GRANT ALL PRIVILEGES ON sample_db.* TO 'sample_admin'@'%';
FLUSH PRIVILEGES;