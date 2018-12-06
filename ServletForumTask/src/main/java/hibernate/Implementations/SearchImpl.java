package hibernate.Implementations;

import hibernate.Exceptions.MyBatchException;
import hibernate.Factories.HibernateSessionFactory;
import hibernate.FileDataReader.ScvReader;
import hibernate.Interfaces.ISearch;
import hibernate.Subject;
import hibernate.Topic;
import hibernate.Users;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class SearchImpl implements ISearch {

    private final static Logger logger = Logger.getLogger(SearchImpl.class);

    final static String SEARCH_BY_SUBJECT = "from Subject where name = :name";
    final static String SEARCH_BY_USER_ID = "from Subject where users.id = :id";
    final static String SEARCH_BY_USER_ID_AND_DATE = "from Subject where users.id = :id and dateSending = :dateSending";
    final static String SEARCH_BY_WORD_MESSAGE = "from Subject where message = :message";
    final static String SEARCH_ALL = "from Subject";
    final static String SEARCH_ALL_USERS = "from Users";
    final static String SEARCH_ALL_TOPICS = "from Topic";
    final static String UPDATE_MESSAGE_BY_ID = "update Subject set message = '[Blocked by moderator]' where users.id = :id";
    final static String DELETE_MESSAGE_BY_ID = "delete Subject where users.id = :id";

    @Override
    public List<Subject> searchBySubject(String s) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Subject> result = session.createQuery(
                SEARCH_BY_SUBJECT, Subject.class)
                .setParameter("name", s)
                .list();
        return result;
    }

    @Override
    public List<Subject> searchByUserId(Integer u) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Subject> result = session.createQuery(
                SEARCH_BY_USER_ID, Subject.class)
                .setParameter("id", u)
                .list();
        return result;
    }

    @Override
    public List<Subject> searchByUserIdAndDate(Integer u, Date d) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Subject> result = session.createQuery(
                SEARCH_BY_USER_ID_AND_DATE, Subject.class)
                .setParameter("id", u)
                .setParameter("dateSending", d)
                .list();
        return result;
    }

    @Override
    public List<Subject> searchByWordMessage(String w) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Subject> result = session.createQuery(
                SEARCH_BY_WORD_MESSAGE, Subject.class)
                .setParameter("message", w)
                .list();
        return result;
    }

    @Override
    public List<Subject> searchAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Subject> result = session.createQuery(
                SEARCH_ALL, Subject.class)
                .list();
        return result;
    }

    @Override
    public List<Subject> searchBySubjectIgnoreRegister(String s) {
        return searchAll();
    }

    public  List<Users> searchAllUsers() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Users> result = session.createQuery(
                SEARCH_ALL_USERS, Users.class)
                .getResultList();
        return result;
    }

    public List<Topic> searchAllTopic() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Topic> result = session.createQuery(
                SEARCH_ALL_TOPICS, Topic.class)
                .getResultList();
        return result;
    }

    @Override
    public void updateMessageByUserId(Integer u) {
        workingWithMessageByUserId(UPDATE_MESSAGE_BY_ID, u);
    }

    @Override
    public void deleteMessageByUserId(Integer u) {
        workingWithMessageByUserId(DELETE_MESSAGE_BY_ID, u);
    }

    public void workingWithMessageByUserId(String query, Integer u) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.createQuery(
                query)
                .setParameter("id", u)
                .executeUpdate();
        trans.commit();
    }

    @Override
    public void batchInsertSubject(ScvReader scvReader, Integer numConf) throws MyBatchException{
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            for (int i = 0; i < scvReader.getSizeFile(); i++) {
                if (i > 0 && i % numConf == 0) {
                    session.flush();
                    session.clear();
                }
                List<Users> users = searchAllUsers();
                for (Users user : users) {
                    List<Topic> topics = searchAllTopic();
                    for (Topic topic : topics) {
                        if ((topic.getId() == scvReader.getTopicsId().get(i)) &&
                                (user.getId() == scvReader.getUsersId().get(i))) {
                            Subject subject = new Subject(scvReader.getNames().get(i), scvReader.getMessages().get(i), scvReader.getDatesSending().get(i),
                                    user, topic);
                            session.save(subject);
                        }
                    }
                }
            }

            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            logger.error("Batch processing error: " + e.getMessage());
            throw new MyBatchException(e.getMessage(), e);
        } finally {
            session.close();
        }
    }
}
