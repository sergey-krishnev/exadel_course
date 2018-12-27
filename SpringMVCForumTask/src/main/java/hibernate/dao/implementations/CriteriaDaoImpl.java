package hibernate.dao.implementations;

import hibernate.dao.interfaces.CRUDDao;
import hibernate.dao.interfaces.InsertOperation;
import hibernate.dao.interfaces.UpdateOperation;
import hibernate.model.Subject;
import hibernate.model.Topic;
import hibernate.model.Users;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class CriteriaDaoImpl implements CRUDDao {

    private final static Logger LOGGER = Logger.getLogger(CriteriaDaoImpl.class);
    private final static String TYPE = "Criteria";

    private UpdateOperation updateOperation;

    private InsertOperation insertOperation;

    @Autowired
    private SessionFactory sessionFactory;

    public CriteriaDaoImpl() {
    }

    public CriteriaDaoImpl(UpdateOperation updateOperation, InsertOperation insertOperation) {
        this.updateOperation = updateOperation;
        this.insertOperation = insertOperation;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public Subject searchBySubjectId(Integer id) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Subject.class);
        cr.add(Restrictions.eq("id", id));
        return (Subject) cr.list().get(0);
    }

    @Override
    public List<Subject> searchAll() {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Subject.class);
        cr.addOrder(Order.asc("name"));
        return cr.list();
    }

    @Override
    public List<Users> searchAllUsers() {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Users.class);
        return cr.list();
    }

    @Override
    public List<Topic> searchAllTopic() {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Topic.class);
        return cr.list();
    }

    @Override
    public void deleteSubjectById(Integer id) {
        Session session = sessionFactory.openSession();
        Transaction trans = null;
        try{
            trans = session.beginTransaction();
            Subject subject = (Subject) session.get(Subject.class, id);
            session.delete(subject);
            trans.commit();
        }catch (HibernateException e) {
            if (trans!=null) trans.rollback();
            LOGGER.error(e.getMessage());
        }finally {
            session.close();
        }
    }

    @Override
    public void updateSubjectById(Integer id, String username, String topicName, String subjectName, String message, Date date) {
        updateOperation.updateSubjectById(id, username, topicName, subjectName, message, date);
    }

    @Override
    public void insertSubject(String username, String topicName, String subjectName, String message, Date date) {
        insertOperation.insertSubject(username, topicName, subjectName,message, date);
    }

    @Override
    public Users searchByUserName(String username) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Users.class);
        cr.add(Restrictions.eq("nickname", username));
        return (Users) cr.list().get(0);
    }

    @Override
    public Topic searchByTopicName(String topicName) {
        Session session = sessionFactory.getCurrentSession();
        Criteria cr = session.createCriteria(Topic.class);
        cr.add(Restrictions.eq("name", topicName));
        return (Topic) cr.list().get(0);
    }
}
