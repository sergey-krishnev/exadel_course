package hibernate.service.implementations;

import hibernate.dao.interfaces.CRUDDao;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;
import hibernate.service.interfaces.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
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
    public List<Subject> searchAll() {
        return crudDao.searchAll();
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
    public void insertSubject(String username, String topicName, String subjectName, String message, Date date) {
        crudDao.insertSubject(username,topicName,subjectName,message,date);
    }

    @Transactional
    @Override
    public void updateSubjectById(Integer id, String username, String topicName, String subjectName, String message, Date date) {
        crudDao.updateSubjectById(id, username, topicName, subjectName, message, date);
    }
}
