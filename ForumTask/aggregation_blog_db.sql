SET search_path TO forum_schema;
CREATE SEQUENCE forum_id_users_seq
		INCREMENT BY 1
		START WITH 100;
	CREATE SEQUENCE forum_id_topic_seq
		INCREMENT BY 1
		START WITH 100;
	CREATE SEQUENCE forum_id_subject_seq
		INCREMENT BY 1
		START WITH 100;
	CREATE SEQUENCE forum_id_comment_seq
		INCREMENT BY 1
		START WITH 100;
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
INSERT INTO forum_schema.subject (id, name, date, user_id, topic_id) VALUES
	(NEXTVAL('forum_id_subject_seq'),'World Leaders/Politicians'
	 ,'2018-11-22 14:50:15', 101, 107),
	(NEXTVAL('forum_id_subject_seq'),'Titles People Can Have'
	 ,'2017-11-23 13:50:15', 107, 111),
	(NEXTVAL('forum_id_subject_seq'),'Math Terms'
	 ,'2015-12-19 12:50:15', 102, 101),
	(NEXTVAL('forum_id_subject_seq'),'Terms of Measurement'
	 ,'2018-12-04 11:50:15', 103, 101),
	(NEXTVAL('forum_id_subject_seq'),'Reasons to Make a Phone Call'
	 ,'2018-12-31 10:40:15', 106, 106),
	(NEXTVAL('forum_id_subject_seq'),'World Leaders/Politicians'
	 ,'2015-11-27 11:40:15', 103, 109),
	(NEXTVAL('forum_id_subject_seq'),'Computer Programs'
	 ,'2018-12-31 12:40:15', 107, 109),
	(NEXTVAL('forum_id_subject_seq'),'Sports Equipment'
	 ,'2016-11-30 13:40:15', 101, 103),
	(NEXTVAL('forum_id_subject_seq'),'Capitals'
	 ,'2014-11-27 14:40:15', 106, 108),
	(NEXTVAL('forum_id_subject_seq'),'Villians'
	 ,'2018-12-05 15:40:15', 108, 104);
INSERT INTO forum_schema.comment (id, message, date, subject_id, user_id) VALUES
	(NEXTVAL('forum_id_comment_seq'),'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc vehicula scelerisque eros. Vestibulum urna nisi, semper sed dignissim id, lobortis vitae odio. Proin dui risus, feugiat tincidunt felis at, tempor aliquam magna. Integer auctor lacus eget lectus malesuada, non euismod elit bibendum. Suspendisse a orci lobortis, accumsan ipsum eu, viverra orci. Donec eget mattis libero. Cras in sagittis libero. Nam cursus a libero in cursus.
Mauris ullamcorper aliquet nibh, id venenatis urna ornare vitae. Vestibulum id lorem varius, efficitur lacus at, bibendum lorem. Aenean suscipit, augue a dignissim posuere, ipsum mauris dictum ante, at gravida eros turpis consectetur metus. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam elementum ut magna sollicitudin feugiat. Sed id enim vitae magna pellentesque mollis. Aliquam maximus felis vel faucibus dignissim. Proin et enim sit amet nulla congue pulvinar. In hac habitasse platea dictumst. Phasellus non magna sit amet est fermentum scelerisque. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
Vivamus a nisi eget sapien porta convallis nec et augue. Cras pretium massa a enim dictum vulputate. Curabitur lacinia nibh malesuada tellus dictum molestie. Nunc eget imperdiet purus, sed tempor ligula. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris laoreet nibh lacus, laoreet finibus lectus suscipit quis. Praesent ut elit risus. In hac habitasse platea dictumst. Maecenas et orci dolor. Sed rutrum nisi vitae nulla eleifend, et tempor ante ultricies. Proin eget tempus est, in pellentesque erat.
Maecenas quis fermentum velit, at consectetur mi. Donec porta, turpis quis ultrices euismod, eros leo gravida mi, ut pharetra dolor velit id ex. Donec accumsan dui arcu. Suspendisse arcu odio, ultrices et mauris vulputate, gravida congue lectus. Mauris tincidunt dui odio, molestie interdum ipsum varius et. Nam quis lacus velit. Nulla facilisi. Ut pretium nisi at finibus egestas. Praesent at porttitor sem. Curabitur dictum, erat sed tincidunt ultricies, mi tortor laoreet ligula, non ultricies nisl lorem id massa. Morbi sollicitudin sed sem a luctus. Suspendisse cursus magna non scelerisque volutpat.
Pellentesque ut fermentum lacus, non scelerisque quam. Sed id scelerisque diam. Fusce ut hendrerit ligula. Fusce ultricies purus quis pellentesque tristique. Nam est libero, semper eu auctor id, cursus a neque. Duis mattis rhoncus feugiat. Nullam gravida odio volutpat ante hendrerit, vitae auctor leo porttitor. Fusce blandit vel augue eu finibus. Praesent pulvinar nibh eget risus ultrices, vitae pulvinar nunc euismod. Proin ac ullamcorper elit, nec porttitor mauris. Suspendisse consequat nulla quis quam tempus tempor at vitae mauris. Maecenas tempus laoreet nunc eu accumsan.'
	 ,'2018-11-22 19:20:15', 101, 107),
	(NEXTVAL('forum_id_comment_seq'),'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean ut mauris ante. Proin quis lorem nulla. Donec venenatis, diam sit amet scelerisque pretium, magna tortor tempus dui, at varius metus sem in tortor. Vestibulum in interdum diam. Nullam eget nibh turpis. Aliquam et justo augue. Aenean mauris orci, faucibus sed odio vel, sodales gravida ex. Aenean pretium erat at leo malesuada, nec pretium orci accumsan. Sed pulvinar massa quis mi scelerisque, tincidunt rhoncus lacus sodales. Nam non luctus ipsum.
Donec in iaculis urna. Phasellus quis bibendum lectus. Quisque eu nisi pharetra, blandit ante egestas, semper enim. Pellentesque tristique vel magna et condimentum. Quisque egestas quam a nisi pharetra ultrices vel at magna. Phasellus in pellentesque massa, ac euismod elit. Nunc erat dui, ornare nec lectus quis, consectetur dapibus mauris.
Quisque fermentum efficitur consequat. Nam at purus imperdiet, tempus magna sed, efficitur sapien. Aliquam sed porta dolor, at consequat tortor. Duis suscipit interdum commodo. Aliquam eget dictum turpis, vel lobortis sem. Suspendisse viverra massa sed iaculis laoreet. Suspendisse non vehicula nibh, at auctor sem. Suspendisse consectetur bibendum justo sit amet blandit. Curabitur non quam ac mauris pulvinar gravida.
Pellentesque gravida massa vel magna interdum congue. Etiam tincidunt lorem eget vehicula ullamcorper. Morbi tempor mauris id metus ultricies, eu suscipit tellus rutrum. Lorem ipsum dolor sit amet, consectetur adipiscing elit. In odio erat, cursus sit amet risus sed, ultricies sodales lectus. Aenean eu tincidunt lorem, at luctus tortor. Nunc at congue lorem. Nullam vel eros laoreet, egestas nulla ut, tincidunt sem. Suspendisse lacinia sapien ac porttitor hendrerit. Praesent eu arcu non neque finibus pulvinar id et tortor. Proin ut metus tincidunt, sodales orci tempor, hendrerit orci. Vestibulum pretium, odio nec lacinia tristique, leo erat fringilla risus, ac sodales nisi augue consequat est. Sed vitae rutrum ante. Nam faucibus nunc quis libero fermentum faucibus. Proin tempus eleifend dapibus.
Nullam sed convallis est. Nam dolor nulla, bibendum vitae odio id, cursus dapibus ante. Pellentesque at nisl nec augue scelerisque ullamcorper. Curabitur ullamcorper felis egestas risus scelerisque hendrerit. Aenean id tincidunt metus. Duis laoreet et enim euismod euismod. Curabitur mi mauris, rutrum vel magna sit amet, sodales eleifend velit. Phasellus ultrices sem ornare ipsum bibendum, quis maximus nisi fringilla.'
	 ,'2017-11-23 19:20:15', 107, 109),
	(NEXTVAL('forum_id_comment_seq'),'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mattis augue ut ex dictum, id auctor nisl varius. Sed gravida varius turpis, a tincidunt purus euismod fringilla. Proin sit amet lectus arcu. In vitae orci a neque suscipit porta. Nam id vestibulum felis. Nullam vehicula felis sit amet tortor convallis, eget aliquet ex tristique. Ut velit magna, faucibus ac quam nec, placerat blandit urna. Pellentesque quis aliquam sapien, sit amet faucibus nisl. Nunc ut consectetur nisl. Duis euismod nulla et erat tincidunt pulvinar in vitae ante. Suspendisse ante nulla, pellentesque at ipsum eu, dignissim mattis arcu. Sed id tincidunt diam. Duis euismod bibendum elit at sagittis. Nullam nec interdum ipsum. Pellentesque sit amet sodales lorem. Nullam gravida dui vitae molestie elementum.
Nullam nunc sapien, scelerisque sit amet laoreet et, accumsan dapibus nibh. Morbi suscipit viverra tincidunt. Vestibulum blandit sed tellus posuere viverra. Sed pellentesque imperdiet ante in hendrerit. Sed id dapibus tortor, eu interdum justo. Nullam pretium felis diam, a interdum nulla finibus at. Praesent tincidunt dolor in urna sollicitudin, ac rhoncus mauris blandit. Nunc tempus lorem eu consequat convallis. Ut euismod volutpat rutrum. Vivamus tortor felis, congue et erat dictum, tempus elementum lorem. Cras volutpat lacinia lectus non feugiat. Curabitur ullamcorper tristique pharetra. Fusce sed risus diam.
Vestibulum rhoncus ligula et sapien viverra fringilla. Aenean et urna mollis, tincidunt sem id, interdum sapien. Nullam ultricies mi eu metus ullamcorper placerat. Fusce ultricies blandit efficitur. Fusce semper, dolor malesuada dapibus sagittis, velit sapien accumsan tellus, id lobortis turpis nunc vel felis. Donec tempor commodo rhoncus. Proin consequat maximus accumsan. Proin non tempus mi. Morbi ac commodo augue. Sed augue tellus, mollis nec elit sit amet, malesuada fermentum enim. In hac habitasse platea dictumst. Nunc ac erat finibus, cursus eros nec, ullamcorper eros. Nulla ullamcorper neque ut turpis semper, et sagittis dui malesuada. Donec a nulla eu nisl fringilla interdum a eu neque.
Vivamus ut leo tincidunt, cursus leo vel, pulvinar erat. Integer vitae ligula nibh. Mauris auctor maximus dui, ut dapibus leo. Aliquam erat volutpat. In hac habitasse platea dictumst. Nulla vel orci sit amet lectus gravida tristique. Curabitur lacinia ligula et risus placerat, ac fringilla nisl lacinia.
Phasellus ut aliquam tortor. Duis gravida dolor non libero euismod tempus. Ut a orci dolor. Donec eget urna a neque convallis laoreet. Aenean lobortis orci ante, eget auctor nibh varius id. Fusce pretium maximus venenatis. Cras commodo posuere purus sit amet porttitor. Donec eget nibh sollicitudin, imperdiet sem ut, congue erat. Nullam scelerisque magna nec tincidunt malesuada. Nam sed laoreet ipsum. Fusce luctus dignissim velit, ac suscipit orci pretium quis. Aenean feugiat diam ac nunc aliquet pharetra. Nunc consequat malesuada quam, sit amet pretium dolor vehicula a. Quisque nec augue non nisi ultrices pretium vel ac dui.'
	 ,'2015-12-19 19:20:15', 102, 101),
	(NEXTVAL('forum_id_comment_seq'),'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ornare purus consequat, ultricies purus non, luctus ante. Nullam et ultrices risus. Phasellus tellus quam, pretium a pulvinar a, suscipit vitae libero. Phasellus pretium magna vitae leo consequat tristique. Morbi vel lorem tellus. Praesent nec tortor ultricies, lobortis ex a, porta mi. Maecenas porta mauris in erat volutpat tempus.
Curabitur vel nulla efficitur, porttitor nulla ac, luctus elit. Donec pharetra ligula eget tortor aliquet convallis. Phasellus sit amet diam ex. Nulla rhoncus volutpat tempus. Nam luctus, eros ac pellentesque efficitur, urna ex tincidunt magna, eget egestas magna odio non orci. Aenean placerat placerat felis ac molestie. In vel laoreet diam. Nam porta quam eu pretium cursus. Mauris suscipit sit amet orci et tempor. Nullam diam ligula, mattis at dignissim a, scelerisque ac eros. Nullam venenatis odio nec blandit gravida.
Etiam sit amet nisi odio. In gravida nisi eget elit condimentum tristique. Duis venenatis tempor massa, sed accumsan leo auctor sed. Pellentesque mauris mauris, finibus id neque egestas, placerat aliquam sem. Etiam viverra turpis in pharetra laoreet. Morbi vulputate in urna sed tempor. Aliquam erat volutpat. Mauris varius ac purus non semper. Donec ullamcorper consectetur purus quis luctus. Donec a placerat nulla.
Nulla erat quam, congue ut mollis ut, feugiat vitae augue. Nulla nec posuere nisl. Aliquam egestas augue quam, non aliquet lorem ullamcorper ut. Ut accumsan sapien nisi, a malesuada nisl tempus at. Proin sit amet sollicitudin ipsum, quis vestibulum diam. Donec condimentum tellus ut risus facilisis feugiat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam pellentesque mauris at vestibulum tempus. Nunc vitae est leo.
Nulla quis purus libero. Morbi blandit odio elit, quis mattis risus lobortis non. Cras eu eros molestie nunc cursus pharetra. Phasellus vitae iaculis velit. Nunc cursus hendrerit ex sed facilisis. Suspendisse potenti. Curabitur condimentum rutrum lacus, at pulvinar est. Nullam aliquet lobortis lobortis. Proin at tortor vel elit finibus blandit. Proin aliquam urna mauris, at congue libero imperdiet non. Mauris et nulla est. Donec porttitor augue eget lacus vulputate, eget aliquet purus cursus. Aliquam lacus neque, consequat ut accumsan eu, scelerisque et magna. Sed eu diam molestie leo tristique tristique a id risus. Etiam non sem rutrum, elementum sapien eu, dictum turpis.'
	 ,'2018-12-04 19:20:15', 103, 101),
	(NEXTVAL('forum_id_comment_seq'),'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus eu lectus velit. Vestibulum dictum facilisis ex, sit amet tincidunt ante ornare at. Nam fermentum ullamcorper velit non mollis. Duis fermentum convallis sollicitudin. Ut vitae tristique libero. Donec vulputate, mauris ac tristique fringilla, dui elit auctor urna, luctus pretium sapien sem mollis urna. Duis vel nibh dapibus, euismod ex sed, interdum metus. Integer eget metus ornare quam feugiat ultricies. Suspendisse potenti. Vestibulum varius mauris vel neque feugiat, eu suscipit libero lacinia. Pellentesque tempor tellus ac ipsum mattis commodo. Proin in sodales sem.
Nullam molestie dapibus quam vel cursus. Proin lacus nibh, accumsan non laoreet ut, ullamcorper eu odio. Sed arcu lorem, pretium vitae cursus at, ornare non elit. Nullam ullamcorper efficitur faucibus. Integer faucibus arcu non velit condimentum congue. Aenean a nisi vel elit blandit facilisis id eu sem. Sed turpis leo, porta at nisi eget, congue sodales erat. Donec ante ex, feugiat vel egestas suscipit, eleifend et felis. Suspendisse eu leo metus. Sed congue risus eu tellus maximus, id mattis nulla blandit. Aliquam mattis tempus dolor in placerat. Vivamus tincidunt dictum nulla iaculis lobortis. Vestibulum pharetra turpis vel velit auctor, eu aliquet ligula dignissim.
Sed nec libero malesuada ex gravida laoreet. Sed quis consectetur augue, non scelerisque justo. Vestibulum laoreet cursus est vitae tempor. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse ullamcorper accumsan ultricies. Mauris ex ex, fermentum eget dapibus egestas, auctor in purus. Fusce lacus eros, condimentum sit amet eros vitae, porta tempus quam. Morbi ultrices tempor ligula, at aliquam odio finibus non. Integer consequat porttitor leo, et mattis libero venenatis eu. Ut sollicitudin cursus elit, placerat scelerisque libero scelerisque in.
Nullam non leo ac nisi eleifend lobortis vel ac ligula. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed eget lacus tempus, porttitor risus at, posuere lectus. Cras et neque id magna volutpat lobortis. Morbi odio dolor, pharetra eu imperdiet non, commodo sit amet metus. Morbi eu justo fermentum, elementum diam nec, rhoncus nunc. Curabitur ac pretium mauris, a finibus nibh. Aliquam vitae urna sed felis sagittis tristique.
Suspendisse tempor id tellus vel lacinia. Nunc eleifend congue ante vel commodo. Quisque ut diam vel tortor sodales semper. Aliquam erat volutpat. Donec semper arcu sit amet augue suscipit, sed condimentum nulla faucibus. Nam lacus neque, dignissim et purus eu, sodales feugiat erat. Praesent euismod posuere lobortis. Morbi mollis est nisi, quis elementum purus efficitur sit amet. Quisque maximus ligula libero, sit amet volutpat lorem commodo ut. Curabitur efficitur augue iaculis, imperdiet enim ut, posuere orci. Donec nunc turpis, pulvinar nec lorem sed, sagittis mollis leo. Maecenas rutrum aliquet felis, et feugiat nibh hendrerit in. Sed elementum urna at purus finibus faucibus.'
	 ,'2015-11-27 19:20:15', 103, 109),
	(NEXTVAL('forum_id_comment_seq'),'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum malesuada magna vel orci gravida, sit amet malesuada nulla consectetur. Fusce ex magna, fringilla sollicitudin sollicitudin ut, auctor quis turpis. Sed facilisis dolor at justo tristique aliquam. Quisque vitae iaculis neque, quis viverra nibh. Mauris fermentum in ex cursus convallis. Nunc efficitur interdum erat in sodales. Vestibulum quis mi tincidunt, fringilla diam non, maximus sapien. In ornare erat tellus, et tempus tortor egestas sit amet. Mauris feugiat erat libero, varius faucibus diam ultrices quis. Ut a facilisis nulla.
Sed sit amet consequat lectus, eget auctor massa. Donec a fermentum dolor, eu pretium metus. Nulla risus erat, laoreet eget leo a, feugiat elementum velit. Nullam ante purus, laoreet nec sapien vel, auctor iaculis mauris. Curabitur tempus viverra enim, non laoreet nisl consequat quis. Donec fringilla arcu erat, laoreet commodo ante porta in. Praesent quis sapien magna. Quisque maximus ex vel dui interdum ultricies. Cras dapibus sem in lobortis vestibulum. Fusce cursus, dolor nec convallis aliquet, sapien neque rutrum nulla, nec dignissim mi augue vitae enim. Nunc posuere cursus dolor at mattis. In ut molestie leo.
Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Sed bibendum massa eu pharetra viverra. Ut at ante neque. Quisque vulputate nisi in neque ullamcorper dictum. Nullam a augue quam. Suspendisse non mattis arcu. Quisque nec leo volutpat, dignissim erat vulputate, maximus ligula. Vestibulum ut purus et nisl egestas dapibus non quis neque. Suspendisse id purus magna. Aenean eget tempor ex. Sed erat nulla, volutpat eget elit vel, eleifend dictum ipsum. Praesent nec mi risus. Duis non congue nunc. Aenean maximus velit id dui cursus pellentesque.
Phasellus nisi lectus, rutrum et elementum at, aliquet in sapien. Donec lacinia nibh eleifend, interdum ipsum quis, feugiat magna. Etiam in risus sit amet est tincidunt fringilla quis ac ex. Aliquam eget sem a nisi ultricies tincidunt. Ut sit amet aliquam lorem, a sollicitudin metus. Donec vitae mattis sem. Sed et ex mauris. Morbi et enim ut purus pharetra auctor a eget lacus.
Praesent sed sodales augue. Sed in fringilla nunc. Integer bibendum laoreet ex, quis dignissim sapien elementum laoreet. Nam eu mi felis. Fusce cursus turpis sed volutpat porta. Phasellus tristique lacus quis luctus vehicula. Proin consequat risus id laoreet vulputate. Sed pharetra, ipsum non vulputate condimentum, quam diam feugiat quam, in rhoncus elit diam id arcu. Sed eget tempor quam. Ut orci arcu, maximus quis mi eu, dictum hendrerit justo. In vitae risus purus. Sed tempor, metus sagittis porttitor luctus, eros urna tristique nulla, eget egestas mi massa at dui. Pellentesque vehicula elit eget nisl viverra, et porta lectus malesuada. Sed fringilla dui elit, non rhoncus felis consequat in. Vivamus finibus dolor purus, nec tempus justo feugiat et.'
	 ,'2018-12-31 19:20:15', 107, 105),
	(NEXTVAL('forum_id_comment_seq'),'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec sollicitudin at nisl vehicula bibendum. Vestibulum laoreet tortor vitae justo lacinia, at pharetra justo dapibus. Nullam mattis luctus mi, non aliquam ligula maximus consectetur. Integer vehicula interdum arcu. Aenean ultrices quam non mi accumsan pharetra. Quisque posuere luctus nisi, non suscipit dui dignissim et. Duis ullamcorper consectetur elit et vehicula. Duis semper varius orci molestie dictum.
Sed facilisis feugiat lectus, et viverra mauris rutrum in. Phasellus cursus dapibus elementum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec at dictum dui. Nulla facilisi. Proin non est ac eros tristique aliquet. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Integer laoreet leo est, vel varius ex interdum at. Maecenas pharetra cursus magna, aliquet molestie lorem dapibus vitae. Suspendisse potenti. Mauris imperdiet massa vel posuere dapibus. Aenean id suscipit nisi, id elementum nunc. Integer congue sem sit amet iaculis placerat.
Nullam eu dolor nec eros placerat venenatis. Vivamus vulputate sit amet justo lacinia tincidunt. Donec lacinia porttitor efficitur. Fusce aliquet nibh eget auctor mattis. Maecenas cursus iaculis cursus. In laoreet venenatis volutpat. Cras pretium dui quis sapien lacinia, ac tincidunt tellus tristique. Suspendisse luctus quam eget ligula ultricies viverra. Duis at enim et metus volutpat elementum. Ut quis malesuada augue, vel bibendum nunc. Duis at dictum eros, a lacinia tellus. Vivamus blandit neque eleifend arcu posuere imperdiet.
Etiam vitae laoreet orci, nec scelerisque ipsum. Vivamus quis nisl leo. Nam laoreet nunc sit amet ligula posuere, eget sollicitudin arcu ullamcorper. Duis semper dui enim, id dignissim lectus faucibus ac. Aliquam tempus, arcu et pharetra molestie, nisl felis suscipit diam, nec gravida nulla lorem non sapien. Donec elit eros, tincidunt quis molestie ut, tristique vel turpis. Vivamus consectetur nisi ut ultricies molestie. Cras id neque pharetra, cursus nunc nec, tristique dui.
Fusce eu enim dapibus, vehicula risus at, aliquet dolor. Aenean scelerisque, metus ut pellentesque varius, odio dui gravida metus, non venenatis risus lectus vel dui. Proin et quam non turpis condimentum sollicitudin molestie eu nulla. Mauris at tempus lacus, a sagittis quam. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Maecenas vitae elementum nunc. Integer pellentesque aliquet imperdiet. Phasellus ac sapien sed ligula dignissim tristique. Integer vehicula sollicitudin porta.'
	 ,'2016-11-30 19:20:15', 101, 103),
	(NEXTVAL('forum_id_comment_seq'),'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla neque nibh, interdum sed egestas quis, fermentum sit amet mi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus consectetur quam id faucibus tristique. Maecenas feugiat urna a nibh porttitor rhoncus. Morbi non tempus enim, vitae dapibus libero. Etiam tristique eleifend volutpat. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;
Duis suscipit sapien nec ipsum viverra feugiat a vel ligula. Proin vel feugiat velit, a luctus mi. Aliquam in augue non diam ullamcorper blandit et in mauris. Donec condimentum nulla ut nunc lacinia, eget consectetur justo auctor. In facilisis feugiat commodo. Sed lobortis enim a ex elementum, sit amet rhoncus nibh semper. Cras ac mi eget nunc lacinia eleifend. Suspendisse facilisis odio non orci malesuada, sed commodo quam iaculis. Duis ultricies egestas justo id ornare. Nam faucibus, erat id pharetra viverra, nulla felis sollicitudin diam, a porta ex felis ac sapien. Suspendisse eget dolor nec erat porttitor ornare. Aenean enim tellus, vehicula sit amet orci nec, facilisis luctus odio.
Aliquam erat volutpat. Donec viverra, dui quis eleifend viverra, felis risus convallis sem, ut pretium lorem felis eget magna. Aliquam erat volutpat. Aliquam erat volutpat. Etiam sed sem mi. Vestibulum quis mauris tempor, vulputate erat id, tempus mauris. Donec non facilisis quam, fringilla blandit ligula. Praesent accumsan sit amet quam in tincidunt. Sed pharetra tortor est, eget rutrum leo tristique eu. Nam cursus bibendum erat tempus dignissim. Aenean maximus ac erat id pharetra.
Duis in ullamcorper leo. Quisque vitae dui ornare, posuere leo at, lacinia odio. Etiam urna nibh, posuere quis accumsan porttitor, iaculis sed arcu. Suspendisse volutpat bibendum aliquet. Ut porttitor eget enim sit amet euismod. Aenean ut magna ut nunc aliquet posuere. Proin at ligula sed nulla molestie laoreet vitae ut massa. Suspendisse lorem sem, feugiat eu ornare eu, malesuada sit amet purus. Aliquam id dolor eros. Suspendisse velit nisl, ultricies a turpis sit amet, sodales aliquam risus.
Etiam vitae risus vel ipsum suscipit dignissim eget et diam. Praesent venenatis eros id nulla tincidunt vulputate. Nam at porttitor velit, id molestie neque. Proin ac lacus mollis, eleifend risus ac, interdum erat. In eget enim condimentum, molestie sapien in, ullamcorper nulla. Sed aliquet est at nisi ultricies, in placerat velit mollis. Suspendisse nec iaculis tortor, nec imperdiet lorem. Nullam blandit magna dolor, id posuere erat finibus id. Interdum et malesuada fames ac ante ipsum primis in faucibus. Mauris imperdiet sodales lacus vel ullamcorper. Nunc nec turpis id dolor suscipit sodales. Duis quis velit lectus. Nulla ac blandit leo. Vestibulum placerat scelerisque leo, eget sagittis mi facilisis vehicula.'
	 ,'2014-11-27 19:20:15', 106, 108),
	(NEXTVAL('forum_id_comment_seq'),'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum fringilla ut nulla vitae dapibus. Donec placerat tincidunt justo vel suscipit. Mauris mollis hendrerit turpis. Aliquam sed velit in urna rhoncus aliquet eu dignissim lorem. Maecenas aliquet elementum magna eu convallis. Quisque nunc ante, lobortis eu diam sed, pulvinar semper eros. Aenean dignissim arcu in dolor commodo, ac vestibulum elit bibendum. Integer sollicitudin dapibus metus, eget vestibulum lorem semper eu. Ut laoreet mi sit amet purus imperdiet cursus. Praesent cursus erat dictum mauris mattis, a sodales turpis commodo. Proin at velit diam. Phasellus tempor, ipsum in faucibus sollicitudin, tellus lorem porta tortor, eu varius nisi quam non est. Phasellus vel ornare nulla. Donec commodo lorem non interdum interdum. Nam pretium mi sed arcu egestas elementum. In imperdiet convallis ornare.
Aenean turpis enim, rutrum a urna eget, iaculis tincidunt dui. Nunc porttitor nulla mi, finibus tincidunt est consequat rutrum. Phasellus eget arcu at lacus ultricies tincidunt. Vivamus sit amet bibendum neque. Nulla rutrum nec nisl quis mollis. Morbi ultricies mi ornare mollis sagittis. Donec pharetra quam ut eros rutrum, sit amet cursus risus accumsan. Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus pellentesque leo nec eros pretium, porta rhoncus ligula viverra. Nunc vulputate nisl quis finibus sagittis. Sed non cursus libero.
Quisque eget pretium magna. Nam libero urna, semper id orci a, gravida pellentesque risus. Quisque nec ante dui. Curabitur fringilla diam ligula, sed luctus velit molestie in. Vestibulum euismod eu quam nec finibus. Maecenas interdum nulla id vestibulum rutrum. Suspendisse semper odio eu odio fermentum consectetur. Vivamus tincidunt eros at blandit pulvinar. Pellentesque finibus ullamcorper magna ac auctor. Sed dapibus tincidunt blandit.
Proin porttitor dolor ex, eu iaculis dolor elementum id. Donec a odio mattis, sodales augue vel, consequat orci. Nunc maximus non ex a consectetur. Donec risus sem, vulputate sed mauris at, pretium porttitor erat. Donec porta vitae mi a posuere. Curabitur euismod vitae ante eget mattis. Aliquam a faucibus nulla, non vehicula dui. Sed ut gravida purus. Cras iaculis libero mattis turpis scelerisque, sed lacinia nunc vulputate. Suspendisse consequat, dui congue dapibus ornare, eros neque sollicitudin enim, non maximus metus libero vitae metus. Vestibulum convallis nisl nec turpis placerat vestibulum.
Maecenas gravida pellentesque lorem sit amet pulvinar. Donec imperdiet sed eros quis congue. Nunc condimentum risus id ex placerat, a suscipit mauris convallis. Pellentesque condimentum imperdiet odio quis efficitur. In consectetur lacinia lectus nec rhoncus. Aliquam erat volutpat. Etiam mi leo, vulputate in felis sit amet, fringilla laoreet magna.'
	 ,'2018-12-05 19:20:15', 108, 104);