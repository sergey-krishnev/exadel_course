package hibernate.dao.interfaces;

import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;

import java.sql.Date;
import java.util.List;

public interface CRUDDao{

    String getType();

    Subject searchBySubjectId(Integer id);

    List<Subject> searchAll();

    List<Users> searchAllUsers();

    List<Topic> searchAllTopic();

    void deleteSubjectById(Integer id);

    Users searchByUserName(String username);

    Topic searchByTopicName(String topicName);

    void insertSubject(String username, String topicName, String subjectName, String message, Date date);

    void updateSubjectById(Integer id, String username, String topicName, String subjectName, String message, java.sql.Date date);
}
