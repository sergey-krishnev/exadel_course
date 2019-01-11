package hibernate.service.implementations;

import hibernate.dao.interfaces.CRUDDao;
import hibernate.dto.SubjectDTO;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;
import hibernate.service.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
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

    @Override
    public String getType() {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public Subject searchBySubjectId(Integer id) {
        return crudDao.searchBySubjectId(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<SubjectDTO> searchAll() {
        List<Subject> subjectList = crudDao.searchAll();
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        for (Subject subject : subjectList) {
            SubjectDTO subjectDTO = new SubjectDTO();
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
    public List<Users> searchAllUsers() {
        return crudDao.searchAllUsers();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Topic> searchAllTopic() {
        return crudDao.searchAllTopic();
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
