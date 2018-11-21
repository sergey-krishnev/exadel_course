SET search_path TO skill_schema;
--1) Search with sort
SELECT s.name_skill, s.year_skill, s.last_used_skill, s.last_check_skill, s.checked_by_skill,
st.name_skill_type AS name_type, ss.name_skill_status AS name_status  
FROM skills s
INNER JOIN skill_types st ON s.id_type = st.id
INNER JOIN skill_statuses ss ON s.id_status = ss.id
WHERE name_skill LIKE 'Industry Vertical %'
ORDER BY year_skill;
--2) Update the record by condition
UPDATE skills 
SET year_skill = year_skill+1
WHERE name_skill = 'Industry Vertical %';
--3) Delete the record by condition
DELETE FROM skills
WHERE year_skill = 3;
--4) New Task: Update by skill_type

UPDATE skills
SET id_type = 103
WHERE id in (
	SELECT s.id
	FROM skills s
	INNER JOIN skill_types st ON s.id_type = st.id
	INNER JOIN skill_statuses ss ON s.id_status = ss.id
	AND ss.name_skill_status = 'Announced');
	
--5) New Task: Delete by skill_type and skill_status
DELETE FROM skills
WHERE id in (
	SELECT s.id 
	FROM skills s
	INNER JOIN skill_types st ON s.id_type = st.id
	INNER JOIN skill_statuses ss ON s.id_status = ss.id
	AND st.name_skill_type = 'Empty type'
	AND ss.name_skill_status = 'Announced'
)
SELECT s.year_skill, st.name_skill_type AS name_type  
	FROM skills s
	INNER JOIN skill_types st ON s.id_type = st.id
	GROUP BY s.year_skill, st.name_skill_type;