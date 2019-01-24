package hibernate.service.interfaces;

import hibernate.dto.SubjectDTO;
import hibernate.dto.TopicDTO;
import hibernate.dto.UsersDTO;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;

import java.sql.Date;
import java.util.List;

public interface CRUDService {
    String getType();

    SubjectDTO searchBySubjectId(Integer id);

    List<SubjectDTO> searchAll();

    List<UsersDTO> searchAllUsers();

    List<TopicDTO> searchAllTopic();

    void deleteSubjectById(Integer id);

    Users searchByUserName(String username);

    Topic searchByTopicName(String topicName);

    void updateSubjectById(Integer id, SubjectDTO subjectDTO);

    void insertSubject(SubjectDTO subjectDTO);
}
