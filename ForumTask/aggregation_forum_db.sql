CREATE SEQUENCE forum_id_users_seq
		INCREMENT BY 1
		START WITH 100;
	CREATE SEQUENCE forum_id_topic_seq
		INCREMENT BY 1
		START WITH 100;
	CREATE SEQUENCE forum_id_subject_seq
		INCREMENT BY 1
		START WITH 100;
INSERT INTO forum_schema.subject (id, name, message, date_sending, user_id, topic_id) VALUES
	(NEXTVAL('forum_id_subject_seq'),'World Leaders/Politicians','Extremity direction existence as dashwoods do up.'
	 ,'2018-11-22', 101, 107),
	(NEXTVAL('forum_id_subject_seq'),'Titles People Can Have','As collected deficient objection by it discovery sincerity curiosity.'
	 ,'2017-11-23', 107, 111),
	(NEXTVAL('forum_id_subject_seq'),'Math Terms','On in bringing graceful proposal blessing of marriage outlived.'
	 ,'2015-12-19', 102, 101),
	(NEXTVAL('forum_id_subject_seq'),'Terms of Measurement','Incommode so intention defective at convinced.'
	 ,'2018-12-04', 103, 101),
	(NEXTVAL('forum_id_subject_seq'),'Reasons to Make a Phone Call','Sociable on as carriage my position weddings raillery consider.'
	 ,'2018-12-31', 106, 106),
	(NEXTVAL('forum_id_subject_seq'),'World Leaders/Politicians','Thrown shy denote ten ladies though ask saw.'
	 ,'2015-11-27', 103, 109),
	(NEXTVAL('forum_id_subject_seq'),'Computer Programs','Conveying concluded newspaper rapturous oh at..'
	 ,'2018-12-31', 107, 110),
	(NEXTVAL('forum_id_subject_seq'),'Sports Equipment','To matter esteem polite do if.'
	 ,'2016-11-30', 101, 103),
	(NEXTVAL('forum_id_subject_seq'),'Capitals','We if prosperous comparison middletons at.'
	 ,'2014-11-27', 106, 108),
	(NEXTVAL('forum_id_subject_seq'),'Villians',' Has six worse downs far blush rooms above stood.'
	 ,'2018-12-05', 108, 104);
INSERT INTO forum_schema.users (id, nickname, password, email, first_name, last_name) VALUES
	(NEXTVAL('forum_id_users_seq'), 'Mingel', 'kianagn', 'mingel99@gmail.com', 'Bethanie', 'Moul'),
	(NEXTVAL('forum_id_users_seq'), 'Stio', 'quinn', 'stio93@gmail.com', 'Anabelle', 'Curzi'),
	(NEXTVAL('forum_id_users_seq'), 'Duliokas', '4r8ujdfg', 'duliokas86@gmail.com', 'Harper', 'Birkenhead'),
	(NEXTVAL('forum_id_users_seq'), 'Tlvited', 'isiart', 'tlvited777@gmail.com', 'Kelis', 'Wulf'),
	(NEXTVAL('forum_id_users_seq'), 'Xmiear', 'myrizusk', 'xmiear101@gmail.com', 'Hope', 'Mcfarlan'),
	(NEXTVAL('forum_id_users_seq'), 'Stingel', '123435', 'stingel99@gmail.com', 'Bobbi', 'Chagnot'),
	(NEXTVAL('forum_id_users_seq'), 'Tulio', 'lgfdhjh45', 'tttulio92@gmail.com', 'Maja', 'Laman'),
	(NEXTVAL('forum_id_users_seq'), 'Uvitkas', 'jenivi', 'duliokas86@gmail.com', 'Kerry', 'Riess'),
	(NEXTVAL('forum_id_users_seq'), 'Mljeted', 'qwer3456uio', 'tMljeted777@gmail.com', 'Anita', 'Kaaya'),
	(NEXTVAL('forum_id_users_seq'), 'Dumiel', 'tontacay', 'ddumielar101@gmail.com', 'Roan', 'Cather');
INSERT INTO forum_schema.topic (id, name) VALUES
	(NEXTVAL('forum_id_topic_seq'),'Birds'),
	(NEXTVAL('forum_id_topic_seq'),'U.S. Cities'),
	(NEXTVAL('forum_id_topic_seq'),'Kinds of Candy'),
	(NEXTVAL('forum_id_topic_seq'),'Words With Double Letters'),
	(NEXTVAL('forum_id_topic_seq'),'Reasons to Call 911'),
	(NEXTVAL('forum_id_topic_seq'),'World Records'),
	(NEXTVAL('forum_id_topic_seq'),'Things You Plug In'),
	(NEXTVAL('forum_id_topic_seq'),'Breakfast Foods'),
	(NEXTVAL('forum_id_topic_seq'),'Television Stars'),
	(NEXTVAL('forum_id_topic_seq'),'Awards/Ceremonies'),
	(NEXTVAL('forum_id_topic_seq'),'Christmas Songs'),
	(NEXTVAL('forum_id_topic_seq'),'Occupations');