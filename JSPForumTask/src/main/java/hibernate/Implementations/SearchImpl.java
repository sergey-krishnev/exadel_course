package hibernate.Implementations;

import hibernate.Exceptions.MyBatchException;
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
import org.hibernate.query.Query;

import javax.jws.soap.SOAPBinding;
import java.sql.Date;
import java.util.List;

public class SearchImpl implements ISearch {

    private final static Logger logger = Logger.getLogger(SearchImpl.class);

    final static String SEARCH_BY_SUBJECT = "from Subject where name = :name";
    final static String SEARCH_BY_NICKNAME = "from Users where nickname = :nickname";
    final static String SEARCH_BY_TOPICNAME = "from Topic where name = :name";
    final static String SEARCH_BY_SUBJECT_ID = "from Subject where id = :id";
    final static String SEARCH_BY_USER_ID = "from Subject where users.id = :id";
    final static String SEARCH_BY_USER_ID_AND_DATE = "from Subject where users.id = :id and dateSending = :dateSending";
    final static String SEARCH_BY_WORD_MESSAGE = "from Subject where message like :message";
    final static String SEARCH_ALL = "from Subject";
    final static String SEARCH_ALL_USERS = "from Users";
    final static String SEARCH_ALL_TOPICS = "from Topic";
    final static String UPDATE_MESSAGE_BY_ID = "update Subject set message = '[Blocked by moderator]' where users.id = :id";

    final static String UPDATE_NICKNAME_BY_ID = "update Users set nickname = :nickname where Subject.id = :id";
    final static String UPDATE_TOPIC_BY_ID = "update Subject set topic.name = :tname where id = :id";
    final static String UPDATE_SUBJECT_BY_ID = "update Subject set name = :sname where id = :id";
    final static String UPDATE_MES_BY_ID = "update Subject set message = :message where id = :id";
    final static String UPDATE_DATE_BY_ID = "update Subject set dateSending = :d where id = :id";

    final static String UPDATE_RECORD_BY_ID = "update Subject set users.nickname = :nickname, topic.name = :tname, " +
            "name = :sname, message = :message, dateSending = :d where id = :id";

    final static String DELETE_MESSAGE_BY_ID = "delete Subject where users.id = :id";
    final static String DELETE_SUBJECT_BY_ID = "delete Subject where id = :id";

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
    public Subject searchBySubjectId(Integer u) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Subject> result = session.createQuery(
                SEARCH_BY_SUBJECT_ID, Subject.class)
                .setParameter("id", u)
                .list();
        return result.get(0);
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

    public List<Users> searchAllUsers() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Users> result = session.createQuery(
                SEARCH_ALL_USERS, Users.class)
                .getResultList();
        return result;
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
    public void deleteSubjectById(Integer u) {
        workingWithMessageByUserId(DELETE_SUBJECT_BY_ID, u);
    }

    @Override
    public void updateSubjectById(Integer id, String nickname, String tName, String sName, String message, java.sql.Date d) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
//        Query q = session.createSQLQuery(UPDATE_RECORD_BY_ID);
//                q.setParameter("nickname", nickname);
//                q.setParameter("tname", tName);
//                q.setParameter("sname", sName);
//                q.setParameter("message", message);
//                q.setParameter("d", d);
//                q.setParameter("id", id);
//                q.executeUpdate();

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
        List<Users> users = searchAllUsers();
        exit: for (Users user : users) {
            List<Topic> topics = searchAllTopic();
            for (Topic topic : topics) {
                if ((topic.getName().equals(tName)) &&
                        (user.getNickname().equals(nickname))) {
                    Subject subject = new Subject(sName, message, d,
                            user, topic);
                    session.save(subject);
                    break exit;
                }
            }
        }
        trans.commit();
    } catch(RuntimeException e) {
        if (trans.isActive()) {
            trans.rollback();
        }
    } finally {
            session.close();
        }

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
