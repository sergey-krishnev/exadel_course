package hibernate.dao.implementations;

import hibernate.dao.interfaces.CRUDDao;
import hibernate.model.Comment;
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
    public List<Topic> searchAllTopic() {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Topic.class);
        cr.addOrder(Order.asc("name"));
        return cr.list();
    }

    @Override
    public List<Subject> searchAllSubject() {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Subject.class);
        cr.addOrder(Order.asc("name"));
        return cr.list();
    }

    @Override
    public Topic searchTopicById(int topicId) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Topic.class);
        cr.add(Restrictions.eq("id", topicId));
        return (Topic) cr.list().get(0);
    }

    @Override
    public Subject searchSubjectById(int subjectId) {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Subject.class);
        cr.add(Restrictions.eq("id", subjectId));
        return (Subject) cr.list().get(0);
    }

}
