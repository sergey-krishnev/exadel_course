package hibernate.dao.interfaces;

import hibernate.model.Comment;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;

import java.sql.Date;
import java.util.List;

public interface CRUDDao{

    List<Topic> searchAllTopic();

    List<Subject> searchAllSubject();

    Topic searchTopicById(int topicId);

    Subject searchSubjectById(int subjectId);

    List<Comment> searchAllComment();
}
