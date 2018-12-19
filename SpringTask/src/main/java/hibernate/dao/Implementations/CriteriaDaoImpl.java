package hibernate.dao.Implementations;

import hibernate.dao.Abstract.AbstractDAO;
import hibernate.dao.Interfaces.CRUDDao;
import hibernate.model.Subject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CriteriaDaoImpl extends AbstractDAO implements CRUDDao {

    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public List<Subject> searchAll() {
        Session session = getSessionFactory();
        Criteria cr = session.createCriteria(Subject.class);
        cr.addOrder(Order.asc("name"));
        setSessionFactory(session.getSessionFactory());
        return cr.list();
    }


}
