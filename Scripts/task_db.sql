SET search_path TO skill_schema;
--1) Search with sort
SELECT s.name_skill, s.year_skill, s.last_used_skill, s.last_check_skill, s.checked_by_skill,
st.name_skill_type AS name_type, ss.name_skill_status AS name_status  
FROM skills s
LEFT OUTER JOIN skill_types st ON s.id_type = st.id
LEFT OUTER JOIN skill_statuses ss ON s.id_status = ss.id
WHERE name_skill LIKE 'Industry Vertical %'
ORDER BY year_skill;
--2) Update the record by condition
UPDATE skills 
SET year_skill = year_skill+1
WHERE name_skill = 'Industry Vertical %';
--3) Delete the record by condition
DELETE FROM skills
WHERE year_skill = 3;