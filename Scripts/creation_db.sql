CREATE TABLE skills
(
	Id SERIAL PRIMARY KEY,
	name_skill CHARACTER VARYING(60),
	year_skill INTEGER,
	last_used_skill INTEGER,
	last_check_skill CHARACTER VARYING(9),
	checked_by_skill CHARACTER VARYING(30)
);
CREATE TABLE skill_types
(
	number_skill SERIAL REFERENCES skills(Id),
	name_skill_type CHARACTER VARYING(50)
);
CREATE TABLE skill_statuses
(
	number_skill SERIAL REFERENCES skills(Id) ,
	name_skill_status CHARACTER VARYING(50)
);