CREATE SCHEMA IF NOT EXISTS skill_schema;
SET search_path TO skill_schema;
	CREATE SEQUENCE skill_id_s_seq
		INCREMENT BY 1
		START WITH 100;
	CREATE SEQUENCE skill_id_ss_seq
		INCREMENT BY 1
		START WITH 100;
	CREATE SEQUENCE skill_id_st_seq
		INCREMENT BY 1
		START WITH 100;
	
	CREATE TABLE skill_types
	(
		id BIGINT DEFAULT NEXTVAL('skill_id_st_seq') PRIMARY KEY,
		name_skill_type CHARACTER VARYING(50)
	);
	CREATE TABLE skill_statuses
	(
		id BIGINT DEFAULT NEXTVAL('skill_id_ss_seq') PRIMARY KEY,
		name_skill_status CHARACTER VARYING(50)
	);
	CREATE TABLE skills
	(
		id BIGINT DEFAULT NEXTVAL('skill_id_s_seq') PRIMARY KEY,
		name_skill CHARACTER VARYING(60) NOT NULL,
		year_skill BIGINT NOT NULL,
		last_used_skill BIGINT NOT NULL,
		last_check_skill DATE,
		checked_by_skill CHARACTER VARYING(30),
		id_type BIGINT NOT NULL,
		id_status BIGINT NOT NULL
	);
	
	ALTER TABLE skill_schema.skills
	ADD CONSTRAINT fk_skill_types_skills FOREIGN KEY (id_type) REFERENCES skill_types (id);
	
	ALTER TABLE skill_schema.skills
	ADD CONSTRAINT fk_skill_statuses_skills FOREIGN KEY (id_status) REFERENCES skill_statuses (id);
	
	ALTER TABLE skill_schema.skills 
	ADD CONSTRAINT positive_year CHECK (year_skill > 0);
	
	ALTER TABLE skill_schema.skills
	ADD CONSTRAINT positive_lu_skill CHECK (last_used_skill > 0);