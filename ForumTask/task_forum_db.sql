--1)Search by subject
SELECT users.nickname AS nickname, topic.name AS topic, subject.name AS subject, subject.message, subject.date_sending 
FROM forum_schema.subject
INNER JOIN forum_schema.users ON subject.user_id = users.id
INNER JOIN forum_schema.topic ON subject.topic_id = topic.id
WHERE subject.name = 'Capitals';
--2)Search by user
SELECT users.nickname AS nickname, topic.name AS topic, subject.name AS subject, subject.message, subject.date_sending 
FROM forum_schema.subject
INNER JOIN forum_schema.users ON subject.user_id = users.id
INNER JOIN forum_schema.topic ON subject.topic_id = topic.id
WHERE subject.user_id = 107;
--3)Search by user and date
SELECT users.nickname AS nickname, topic.name AS topic, subject.name AS subject, subject.message, subject.date_sending 
FROM forum_schema.subject
INNER JOIN forum_schema.users ON subject.user_id = users.id
INNER JOIN forum_schema.topic ON subject.topic_id = topic.id
WHERE subject.user_id = 107 
AND subject.date_sending = '2017-11-23';
--4)Search by word in message
SELECT users.nickname AS nickname, topic.name AS topic, subject.name AS subject, subject.message, subject.date_sending 
FROM forum_schema.subject
INNER JOIN forum_schema.users ON subject.user_id = users.id
INNER JOIN forum_schema.topic ON subject.topic_id = topic.id
WHERE subject.message LIKE '%co%';