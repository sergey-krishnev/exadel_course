package hibernate.Implementations;

import hibernate.Interfaces.CRUDDao;
import hibernate.Interfaces.InsertOperation;
import hibernate.Interfaces.UpdateOperation;
import hibernate.Factories.HibernateSessionFactory;
import hibernate.Subject;
import hibernate.Topic;
import hibernate.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class HQLDaoImpl implements CRUDDao {

    private final static String SEARCH_BY_NICKNAME = "from Users where nickname = :nickname";
    private final static String SEARCH_BY_TOPICNAME = "from Topic where name = :name";
    private final static String SEARCH_BY_SUBJECT_ID = "from Subject where id = :id";
    private final static String SEARCH_ALL = "from Subject order by name";
    private final static String SEARCH_ALL_USERS = "from Users";
    private final static String SEARCH_ALL_TOPICS = "from Topic";
    private final static String DELETE_SUBJECT_BY_ID = "delete Subject where id = :id";

    private UpdateOperation updateOperation;

    private InsertOperation insertOperation;

    public HQLDaoImpl() {
    }

    public HQLDaoImpl(UpdateOperation updateOperation, InsertOperation insertOperation) {
        this.updateOperation = updateOperation;
        this.insertOperation = insertOperation;
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
    public List<Subject> searchAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Subject> result = session.createQuery(
                SEARCH_ALL, Subject.class)
                .list();
        return result;
    }

    public List<Users> searchAllUsers() {
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
    public void deleteSubjectById(Integer u) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.createQuery(DELETE_SUBJECT_BY_ID)
                .setParameter("id", u)
                .executeUpdate();
        trans.commit();
    }

    @Override
    public void insertSubject(String nickname, String tName, String sName, String message, Date d) {
        insertOperation.insertSubject(nickname,tName,sName,message,d);
    }

    @Override
    public void updateSubjectById(Integer id, String nickname, String tName, String sName, String message, Date d) {
        updateOperation.updateSubjectById(id, nickname, tName, sName, message, d);
    }

    @Override
    public Users searchByUserName(String s) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Users> result = session.createQuery(
                SEARCH_BY_NICKNAME, Users.class)
                .setParameter("nickname", s)
                .getResultList();
        return result.get(0);
    }

    @Override
    public Topic searchByTopicName(String s) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Topic> result = session.createQuery(
                SEARCH_BY_TOPICNAME, Topic.class)
                .setParameter("name", s)
                .getResultList();
        return result.get(0);
    }
}
