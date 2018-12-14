package hibernate.Implementations;

import hibernate.Factories.HibernateSessionFactory;
import hibernate.FileDataReader.ScvReader;
import hibernate.Interfaces.ISearch;
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
import java.util.List;

public class SearchBuilderImpl extends UpdateAndInsertImpl implements ISearch {

    private final static Logger logger = Logger.getLogger(SearchBuilderImpl.class);

    @Override
    public List<Subject> searchBySubject(String s) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Subject.class);
        cr.add(Restrictions.eq("name", s));
        return cr.list();
    }

    @Override
    public Subject searchBySubjectId(Integer u) {
        return null;
    }

    @Override
    public List<Subject> searchByUserId(Integer u) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Subject.class);
        cr.add(Restrictions.eq("users.id", u));
        return cr.list();
    }

    @Override
    public List<Subject> searchByUserIdAndDate(Integer u, Date d) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Subject.class);
        cr.add((Restrictions.or(Restrictions.eq("users.id", u),Restrictions.eq("dateSending", d))));
        return cr.list();
    }

    @Override
    public List<Subject> searchByWordMessage(String w) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Subject.class);
        cr.add(Restrictions.ilike("message", w));
        return cr.list();
    }

    @Override
    public List<Subject> searchAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Subject.class);
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
    public List<Subject> searchBySubjectIgnoreRegister(String s) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Subject.class);
        cr.add(Restrictions.ilike("name", s));
        return cr.list();
    }

    @Override
    public void updateMessageByUserId(Integer u) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Subject subject = session.get(Subject.class, u);
            subject.setMessage("[Blocked by moderator]");
            session.update(subject);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            logger.error(e.getMessage());
        }finally {
            session.close();
        }
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
    public void batchInsertSubject(ScvReader scvReader, Integer numConf) {
    }
}
