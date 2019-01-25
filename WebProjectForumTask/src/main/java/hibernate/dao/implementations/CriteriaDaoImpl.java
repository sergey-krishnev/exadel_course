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
        return cr.list();
    }

}
