--<ScriptOptions statementTerminator=";"/>

CREATE TABLE user_detail (
	id INT NOT NULL,
	first_name VARCHAR(45) NOT NULL,
	last_name VARCHAR(45) NOT NULL,
	email VARCHAR(45) NOT NULL,
	dob VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
);

ALTER TABLE user_detail ADD PRIMARY KEY (id);

