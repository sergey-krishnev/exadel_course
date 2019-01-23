package hibernate.service.implementations;

import hibernate.dao.interfaces.CRUDDao;
import hibernate.dto.ForumDTO;
import hibernate.dto.SubjectDTO;
import hibernate.dto.TopicDTO;
import hibernate.dto.UsersDTO;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;
import hibernate.service.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CRUDServiceImpl implements CRUDService {

    @Autowired
    private CRUDDao crudDao;

    public void setCrudDao(CRUDDao crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    public String getType() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public SubjectDTO searchBySubjectId(Integer id) {
        Subject subject = crudDao.searchBySubjectId(id);
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(subject.getId());
        subjectDTO.setNickname(subject.getUsers().getNickname());
        subjectDTO.setTopic(subject.getTopic().getName());
        subjectDTO.setSubject(subject.getName());
        subjectDTO.setMessage(subject.getMessage());
        subjectDTO.setDate(subject.getFormattedDateSending());
        return subjectDTO;
    }

    @Transactional(readOnly = true)
    @Override
    public List<SubjectDTO> searchAll() {
        List<Subject> subjectList = crudDao.searchAll();
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        for (Subject subject : subjectList) {
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setId(subject.getId());
            subjectDTO.setNickname(subject.getUsers().getNickname());
            subjectDTO.setTopic(subject.getTopic().getName());
            subjectDTO.setSubject(subject.getName());
            subjectDTO.setMessage(subject.getMessage());
            subjectDTO.setDate(subject.getFormattedDateSending());
            subjectDTOList.add(subjectDTO);
        }
        return subjectDTOList;
    }

    @Transactional(readOnly = true)
    @Override
    public List<UsersDTO> searchAllUsers() {
        List<Users> usersList = crudDao.searchAllUsers();
        List<UsersDTO> usersDTOList = new ArrayList<>();
        for (Users users : usersList) {
            UsersDTO usersDTO = new UsersDTO();
            usersDTO.setName(users.getNickname());
            usersDTOList.add(usersDTO);
        }
        return usersDTOList;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TopicDTO> searchAllTopic() {
        List<Topic> topicList = crudDao.searchAllTopic();
        List<TopicDTO> topicDTOList = new ArrayList<>();
        for (Topic topic : topicList) {
            TopicDTO topicDTO = new TopicDTO();
            topicDTO.setName(topic.getName());
            topicDTOList.add(topicDTO);
        }
        return topicDTOList;
    }

    @Transactional
    @Override
    public void deleteSubjectById(Integer id) {
        crudDao.deleteSubjectById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Users searchByUserName(String username) {
        return crudDao.searchByUserName(username);
    }

    @Transactional(readOnly = true)
    @Override
    public Topic searchByTopicName(String topicName) {
        return crudDao.searchByTopicName(topicName);
    }

    @Transactional
    @Override
    public void insertSubject(SubjectDTO subjectDto) {
        crudDao.insertSubject(subjectDto.getNickname(), subjectDto.getTopic(), subjectDto.getSubject(), subjectDto.getMessage(), stringAsDate(subjectDto.getDate()));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ForumDTO> searchAllForum() {
        List<Topic> topicList = crudDao.searchAllTopic();
        List<ForumDTO> forumDTOList = new ArrayList<>();
        for (Topic topic : topicList) {
            ForumDTO forumDTO = new ForumDTO();
            forumDTO.setId(topic.getId());
            forumDTO.setTopicName(topic.getName());

            Set<String> subjectNameSet = new HashSet<>();
            List<String> dateList = new ArrayList<>();
            List<Subject> subjectList = topic.getSubjects();
            for (Subject subject : subjectList) {
                subjectNameSet.add(subject.getName());
                dateList.add(subject.getFormattedDateSending());
            }
            String maxDate = (dateList.isEmpty()) ? "" : Collections.max(dateList);
            forumDTO.setNumSubjects(subjectNameSet.size());
            forumDTO.setNumMessages(topic.getSubjects().size());
            forumDTO.setLastDate(maxDate);



            forumDTOList.add(forumDTO);
        }
        return forumDTOList;
    }

    @Transactional
    @Override
    public void updateSubjectById(Integer id, SubjectDTO subjectDto) {
        crudDao.updateSubjectById(id, subjectDto.getNickname(), subjectDto.getTopic(), subjectDto.getSubject(), subjectDto.getMessage(), stringAsDate(subjectDto.getDate()));
    }

    private static java.sql.Date stringAsDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new java.sql.Date(date.getTime());
    }
}
