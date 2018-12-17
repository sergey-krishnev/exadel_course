package hibernate.Interfaces;

import hibernate.Subject;
import hibernate.Topic;
import hibernate.Users;

import java.util.List;

public interface CRUDDao extends UpdateOperation, InsertOperation{

    Subject searchBySubjectId(Integer u);

    List<Subject> searchAll();

    List<Users> searchAllUsers();

    List<Topic> searchAllTopic();

    void deleteSubjectById(Integer u);

    Users searchByUserName(String s);

    Topic searchByTopicName(String s);

}
