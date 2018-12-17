package hibernate.Implementations;

import hibernate.Interfaces.CRUDDao;
import hibernate.Interfaces.InsertOperation;
import hibernate.Factories.HibernateSessionFactory;
import hibernate.Subject;
import hibernate.Topic;
import hibernate.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;

public class InsertOperationImpl implements InsertOperation {

    private CRUDDao crudDao;

    public InsertOperationImpl(CRUDDao crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    public void insertSubject(String username, String topicName, String subjectName, String message, Date date) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
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
