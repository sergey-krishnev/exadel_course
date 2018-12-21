package hibernate.service.interfaces;

import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;

import java.util.List;

public interface CRUDService extends UpdateOperationService, InsertOperationService {
    String getType();

    Subject searchBySubjectId(Integer id);

    List<Subject> searchAll();

    List<Users> searchAllUsers();

    List<Topic> searchAllTopic();

    void deleteSubjectById(Integer id);

    Users searchByUserName(String username);

    Topic searchByTopicName(String topicName);
}
