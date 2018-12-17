package hibernate.Implementations;

import hibernate.Interfaces.CRUDDao;
import hibernate.Interfaces.UpdateOperation;
import hibernate.Factories.HibernateSessionFactory;
import hibernate.Subject;
import hibernate.Topic;
import hibernate.Users;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateOperationImpl implements UpdateOperation {

    private final static Logger logger = Logger.getLogger(UpdateOperationImpl.class);

    private CRUDDao crudDao;

    public UpdateOperationImpl(CRUDDao crudDao) {
        this.crudDao = crudDao;
    }

    @Override
    public void updateSubjectById(Integer id, String nickname, String tName, String sName, String message, java.sql.Date d) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        try{
            Subject sub = session.get(Subject.class, id);
            Users user = crudDao.searchByUserName(nickname);
            Topic topic = crudDao.searchByTopicName(tName);
            sub.setUsers(user);
            sub.setTopic(topic);
            sub.setName(sName);
            sub.setMessage(message);
            sub.setDateSending(d);
            session.update(sub);
            trans.commit();
        }catch (HibernateException e) {
            if (trans!=null) trans.rollback();
            logger.error(e.getMessage());
        }finally {
            session.close();
        }
    }
}
