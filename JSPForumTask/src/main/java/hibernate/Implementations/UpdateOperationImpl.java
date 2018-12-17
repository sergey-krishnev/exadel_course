package hibernate.Implementations;

import hibernate.Interfaces.CRUDDao;
import hibernate.Interfaces.UpdateOperation;
import hibernate.Factories.HibernateSessionFactory;
import hibernate.Subject;
import hibernate.Topic;
import hibernate.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateOperationImpl implements UpdateOperation {

    private CRUDDao crudDao;

    public UpdateOperationImpl(CRUDDao crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    public void updateSubjectById(Integer id, String username, String topicName, String subjectName, String message, java.sql.Date date) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            Subject subject = session.get(Subject.class, id);
            Users user = crudDao.searchByUserName(username);
            Topic topic = crudDao.searchByTopicName(topicName);
            subject.setUsers(user);
            subject.setTopic(topic);
            subject.setName(subjectName);
            subject.setMessage(message);
            subject.setDateSending(date);
            session.update(subject);
            transaction.commit();
        }catch (HibernateException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }finally {
            session.close();
        }
    }
}
