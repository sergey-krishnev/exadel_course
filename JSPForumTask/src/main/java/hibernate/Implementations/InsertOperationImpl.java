package hibernate.Implementations;

import hibernate.Interfaces.CRUDDao;
import hibernate.Interfaces.InsertOperation;
import hibernate.Factories.HibernateSessionFactory;
import hibernate.Subject;
import hibernate.Topic;
import hibernate.Users;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;

public class InsertOperationImpl implements InsertOperation {

    private final static Logger logger = Logger.getLogger(InsertOperationImpl.class);

    private CRUDDao crudDao;

    public InsertOperationImpl(CRUDDao crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    public void insertSubject(String nickname, String tName, String sName, String message, Date d) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        try
        {
            Users user = crudDao.searchByUserName(nickname);
            Topic topic = crudDao.searchByTopicName(tName);
            Subject subject = new Subject(sName, message, d, user, topic);
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
