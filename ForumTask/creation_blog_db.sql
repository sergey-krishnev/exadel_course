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
	CREATE TABLE authorities
	(
		id BIGINT NOT NULL,
		user_id BIGINT NOT NULL,
		authority CHARACTER VARYING(50) NOT NULL
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
		date TIMESTAMP NOT NULL,
		text CHARACTER VARYING(4000) NOT NULL,
		user_id BIGINT NOT NULL,
		topic_id BIGINT NOT NULL
	);
	CREATE TABLE comment
	(
		id BIGINT PRIMARY KEY,
		message CHARACTER VARYING(256) NOT NULL,
		date TIMESTAMP NOT NULL,
		subject_id BIGINT NOT NULL,
		user_id BIGINT NOT NULL
	);
	ALTER TABLE forum_schema.subject
	ADD CONSTRAINT fk_users_subject FOREIGN KEY (user_id) REFERENCES users (id);
	
	ALTER TABLE forum_schema.subject
	ADD CONSTRAINT fk_topic_subject FOREIGN KEY (topic_id) REFERENCES topic (id);
	
	ALTER TABLE forum_schema.comment
	ADD CONSTRAINT fk_subject_comment FOREIGN KEY (subject_id) REFERENCES subject (id);
	
	ALTER TABLE forum_schema.comment
	ADD CONSTRAINT fk_users_comment FOREIGN KEY (user_id) REFERENCES users (id);
	
	ALTER TABLE forum_schema.authorities
	ADD CONSTRAINT fk_users_authorities FOREIGN KEY (user_id) REFERENCES users (id);