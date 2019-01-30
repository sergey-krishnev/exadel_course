package hibernate.service.implementations;

import hibernate.dao.interfaces.CRUDDao;
import hibernate.dto.CommentDTO;
import hibernate.dto.SubjectDTO;
import hibernate.dto.TopicDTO;
import hibernate.model.Comment;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.service.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CRUDServiceImpl implements CRUDService {

    @Autowired
    private CRUDDao crudDao;

    public void setCrudDao(CRUDDao crudDao) {
        this.crudDao = crudDao;
    }


    private static java.sql.Date stringAsDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        java.util.Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new java.sql.Date(date.getTime());
    }

    @Transactional(readOnly = true)
    @Override
    public List<SubjectDTO> searchSubjectByTopic(Topic topic) {
        List<Subject> subjectList = topic.getSubjects();
        List<SubjectDTO> subjects = new ArrayList<>();
        subjectToSubjectDTO(subjectList, subjects);
        return subjects;
    }

    @Transactional(readOnly = true)
    @Override
    public TopicDTO searchTopicById(int topicId) {
        Topic topic = crudDao.searchTopicById(topicId);
        TopicDTO topicDTO = new TopicDTO();
        topicDTO.setId(topic.getId());
        topicDTO.setTopicName(topic.getName());
        topicDTO.setSubjects(searchSubjectByTopic(topic));
        return topicDTO;
    }

    @Transactional(readOnly = true)
    @Override
    public SubjectDTO searchSubjectById(int subjectId) {
        Subject subject = crudDao.searchSubjectById(subjectId);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(subject.getId());
        subjectDTO.setUserName(subject.getUsers().getNickname());
        subjectDTO.setSubjectName(subject.getName());
        subjectDTO.setDate(subject.getFormattedDateSending());
        subjectDTO.setDescription(subject.getText());
        subjectDTO.setText(subject.getText());
        subjectDTO.setComments(searchCommentBySubject(subject));
        return subjectDTO;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TopicDTO> searchAllTopic() {
        List<Topic> topicList = crudDao.searchAllTopic();
        List<TopicDTO> topics = new ArrayList<>();
        for (Topic topic : topicList) {
            TopicDTO topicDTO = new TopicDTO();
            topicDTO.setId(topic.getId());
            topicDTO.setTopicName(topic.getName());
            topicDTO.setSubjects(searchSubjectByTopic(topic));
            topics.add(topicDTO);
        }
        return topics;
    }

    @Transactional(readOnly = true)
    @Override
    public List<SubjectDTO> searchAllSubject() {
        List<Subject> subjects = crudDao.searchAllSubject();
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectToSubjectDTO(subjects, subjectDTOList);
        return subjectDTOList;
    }

    private void subjectToSubjectDTO(List<Subject> subjects, List<SubjectDTO> subjectDTOList) {
        for (Subject subject : subjects) {
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setId(subject.getId());
            subjectDTO.setUserName(subject.getUsers().getNickname());
            subjectDTO.setSubjectName(subject.getName());
            subjectDTO.setDate(subject.getFormattedDateSending());
            subjectDTO.setDescription(subject.getText());
            subjectDTO.setText(subject.getText());
            subjectDTO.setComments(searchCommentBySubject(subject));
            subjectDTOList.add(subjectDTO);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<CommentDTO> searchCommentBySubject(Subject subject) {
        List<Comment> commentList = subject.getComments();
        List<CommentDTO> comments = new ArrayList<>();
        commentToCommentDTO(commentList, comments);
        return comments;
    }

    @Transactional(readOnly = true)
    @Override
    public List<CommentDTO> searchAllComment() {
        List<Comment> commentList = crudDao.searchAllComment();
        List<CommentDTO> comments = new ArrayList<>();
        commentToCommentDTO(commentList, comments);
        return comments;
    }

    private void commentToCommentDTO(List<Comment> commentList, List<CommentDTO> comments) {
        for (Comment comment : commentList) {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setId(comment.getId());
            commentDTO.setUserName(comment.getUsers().getNickname());
            commentDTO.setSubjectName(comment.getSubject().getName());
            commentDTO.setTopicName(comment.getSubject().getTopic().getName());
            commentDTO.setMessage(comment.getMessage());
            commentDTO.setDate(comment.getFormattedDateSending());
            comments.add(commentDTO);
        }
    }
}
