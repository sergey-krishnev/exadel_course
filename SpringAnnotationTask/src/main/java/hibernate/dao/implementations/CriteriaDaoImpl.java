package hibernate.dao.implementations;

import hibernate.dao.interfaces.CRUDDao;
import hibernate.model.Subject;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CriteriaDaoImpl implements CRUDDao {

    //    public void setSessionFactory(SessionFactory sessionFactory) {
//        super.setSessionFactory(sessionFactory);
//    }
@Autowired
private SessionFactory sessionFactory;

    @Override
    public List<Subject> searchAll() {
        Criteria cr = sessionFactory.getCurrentSession().createCriteria(Subject.class);
        cr.addOrder(Order.asc("name"));
        List<Subject> list = (List<Subject>) cr.list();
        return list;
    }


}
