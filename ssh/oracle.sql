CREATE SEQUENCE seq_log4j;

CREATE TABLE log4j
(
	id INT PRIMARY KEY,
	log_time VARCHAR2(50),
	log_logger VARCHAR2(50),
	log_level VARCHAR2(50),
	log_msg VARCHAR2(500),
	log_source VARCHAR2(50)
);

CREATE TABLE tb_user
(
	id INT PRIMARY KEY,
	name VARCHAR2(20),
	pwd VARCHAR2(20)
);

CREATE TABLE tb_depart
(
	id INT PRIMARY KEY,
	name VARCHAR2(20),
	enabled INT DEFAULT 1 NOT NULL
);
COMMENT ON COLUMN tb_depart.enabled IS '是否启用（1：启用；0：停用）';