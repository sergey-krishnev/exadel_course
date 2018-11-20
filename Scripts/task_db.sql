SET search_path TO skill_schema;
--All records
SELECT s.*, st.name_skill_type AS name_type
FROM skills s
LEFT OUTER JOIN skill_types st ON s.id_type = st.id
--6.1) Update the record by condition
--6.2) Delete the record by condition

--7) Aggregate