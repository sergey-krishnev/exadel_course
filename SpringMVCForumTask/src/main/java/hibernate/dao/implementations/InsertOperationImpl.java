package hibernate.dao.implementations;

import hibernate.dao.interfaces.CRUDDao;
import hibernate.dao.interfaces.InsertOperation;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

public class InsertOperationImpl implements InsertOperation {

    private CRUDDao crudDao;

    @Autowired
    private SessionFactory sessionFactory;

    public InsertOperationImpl(CRUDDao crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    public void insertSubject(String username, String topicName, String subjectName, String message, Date date) {
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        try
        {
            Users user = crudDao.searchByUserName(username);
            Topic topic = crudDao.searchByTopicName(topicName);
            Subject subject = new Subject(subjectName, message, date, user, topic);
            session.save(subject);
            trans.commit();
        } catch(RuntimeException e) {
            if (trans.isActive()) {
                trans.rollback();
            }
        } finally {
            session.close();
        }
    }
}
