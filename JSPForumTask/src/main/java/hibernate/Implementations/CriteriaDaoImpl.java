package hibernate.Implementations;

import hibernate.Interfaces.CRUDDao;
import hibernate.Interfaces.InsertOperation;
import hibernate.Interfaces.UpdateOperation;
import hibernate.Factories.HibernateSessionFactory;
import hibernate.Subject;
import hibernate.Topic;
import hibernate.Users;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.sql.Date;
import java.util.List;

public class CriteriaDaoImpl implements CRUDDao {

    private final static Logger logger = Logger.getLogger(CriteriaDaoImpl.class);

    private UpdateOperation updateOperation;

    private InsertOperation insertOperation;

    public CriteriaDaoImpl() {
    }

    public CriteriaDaoImpl(UpdateOperation updateOperation, InsertOperation insertOperation) {
        this.updateOperation = updateOperation;
        this.insertOperation = insertOperation;
    }

    @Override
    public Subject searchBySubjectId(Integer u) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Subject.class);
        cr.add(Restrictions.eq("id", u));
        return (Subject) cr.list().get(0);
    }

    @Override
    public List<Subject> searchAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Subject.class);
        cr.addOrder(Order.asc("name"));
        return cr.list();
    }

    @Override
    public List<Users> searchAllUsers() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Users.class);
        return cr.list();
    }

    @Override
    public List<Topic> searchAllTopic() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Topic.class);
        return cr.list();
    }

    @Override
    public void deleteSubjectById(Integer u) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction trans = null;
        try{
            trans = session.beginTransaction();
            Subject subject = session.get(Subject.class, u);
            session.delete(subject);
            trans.commit();
        }catch (HibernateException e) {
            if (trans!=null) trans.rollback();
            logger.error(e.getMessage());
        }finally {
            session.close();
        }
    }

    @Override
    public void updateSubjectById(Integer id, String nickname, String tName, String sName, String message, Date d) {
        updateOperation.updateSubjectById(id, nickname, tName, sName, message, d);
    }

    @Override
    public void insertSubject(String nickname, String tName, String sName, String message, Date d) {
        insertOperation.insertSubject(nickname,tName,sName,message,d);
    }

    @Override
    public Users searchByUserName(String s) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.eq("nickname", s));
        return (Users) cr.list().get(0);
    }

    @Override
    public Topic searchByTopicName(String s) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Topic.class);
        cr.add(Restrictions.eq("name", s));
        return (Topic) cr.list().get(0);
    }
}
