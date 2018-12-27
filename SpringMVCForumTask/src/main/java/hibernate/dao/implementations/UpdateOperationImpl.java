package hibernate.dao.implementations;

import hibernate.dao.interfaces.CRUDDao;
import hibernate.dao.interfaces.UpdateOperation;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateOperationImpl implements UpdateOperation {

    private CRUDDao crudDao;

    @Autowired
    private SessionFactory sessionFactory;

    public UpdateOperationImpl(CRUDDao crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    public void updateSubjectById(Integer id, String username, String topicName, String subjectName, String message, java.sql.Date date) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try{
            Subject subject = (Subject) session.get(Subject.class, id);
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
