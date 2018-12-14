package hibernate.Implementations;

import hibernate.Factories.HibernateSessionFactory;
import hibernate.Interfaces.IUpdateAndInsert;
import hibernate.Subject;
import hibernate.Topic;
import hibernate.Users;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.sql.Date;

public class UpdateAndInsertImpl implements IUpdateAndInsert {

    private final static Logger logger = Logger.getLogger(UpdateAndInsertImpl.class);

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

    @Override
    public void updateSubjectById(Integer id, String nickname, String tName, String sName, String message, java.sql.Date d) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        try{
            Subject sub = session.get(Subject.class, id);
            Users user = searchByUserName(nickname);
            Topic topic = searchByTopicName(tName);
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

    @Override
    public void insertSubject(String nickname, String tName, String sName, String message, Date d) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        try
        {
            Users user = searchByUserName(nickname);
            Topic topic = searchByTopicName(tName);
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
