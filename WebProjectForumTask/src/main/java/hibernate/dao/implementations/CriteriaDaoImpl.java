package hibernate.dao.implementations;

import hibernate.dao.interfaces.CRUDDao;
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

    @Autowired
    private SessionFactory sessionFactory;

    public CriteriaDaoImpl() {
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
        Session session = sessionFactory.getCurrentSession();
            Subject subject = (Subject) session.get(Subject.class, id);
            session.delete(subject);
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

    @Override
    public void insertSubject(String username, String topicName, String subjectName, String message, Date date) {
        Session session = sessionFactory.getCurrentSession();
            Users user = searchByUserName(username);
            Topic topic = searchByTopicName(topicName);
            Subject subject = new Subject(subjectName, message, date, user, topic);
            session.save(subject);
    }

    @Override
    public void updateSubjectById(Integer id, String username, String topicName, String subjectName, String message, Date date) {
        Session session = sessionFactory.getCurrentSession();
            Subject subject = (Subject) session.get(Subject.class, id);
            Users user = searchByUserName(username);
            Topic topic = searchByTopicName(topicName);
            subject.setUsers(user);
            subject.setTopic(topic);
            subject.setName(subjectName);
            subject.setMessage(message);
            subject.setDate(date);
            session.update(subject);
    }
}
