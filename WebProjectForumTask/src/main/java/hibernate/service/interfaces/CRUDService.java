package hibernate.service.interfaces;

import hibernate.dto.CommentDTO;
import hibernate.dto.SubjectDTO;
import hibernate.dto.TopicDTO;
import hibernate.dto.UsersDTO;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;

import java.sql.Date;
import java.util.List;

public interface CRUDService {

    List<SubjectDTO> searchSubjectByTopic(Topic topic);

    List<TopicDTO> searchAllTopic();

    List<CommentDTO> searchCommentBySubject(Subject subject);
}
