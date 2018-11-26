CREATE SCHEMA IF NOT EXISTS forum_schema;
SET search_path TO forum_schema;
	CREATE TABLE users
	(
		id BIGINT PRIMARY KEY,
		nickname CHARACTER VARYING(30) NOT NULL,
		password CHARACTER VARYING(50) NOT NULL,
		email CHARACTER VARYING(40) NOT NULL,
		first_name CHARACTER VARYING(15) NOT NULL,
		last_name CHARACTER VARYING(20) NOT NULL
	);
	CREATE TABLE topic
	(
		id BIGINT PRIMARY KEY,
		name CHARACTER VARYING(100) NOT NULL
	);
	CREATE TABLE subject
	(
		id BIGINT PRIMARY KEY,
		name CHARACTER VARYING(100) NOT NULL,
		message CHARACTER VARYING(256) NOT NULL,
		date_sending DATE NOT NULL,
		user_id BIGINT NOT NULL,
		topic_id BIGINT NOT NULL
	);
	ALTER TABLE forum_schema.subject
	ADD CONSTRAINT fk_users_subject FOREIGN KEY (user_id) REFERENCES users (id);
	
	ALTER TABLE forum_schema.subject
	ADD CONSTRAINT fk_topic_subject FOREIGN KEY (topic_id) REFERENCES topic (id);