package hibernate.dao.Implementations;

import hibernate.dao.Interfaces.CRUDDao;
import hibernate.Factories.HibernateSessionFactory;
import hibernate.model.Subject;
import org.hibernate.Session;

import java.util.List;

public class HQLDaoImpl implements CRUDDao {

    private final static String SEARCH_ALL = "from Subject order by name";

    @Override
    public List<Subject> searchAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Subject> result = session.createQuery(
                SEARCH_ALL, Subject.class)
                .list();
        return result;
    }
}
