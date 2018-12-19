package hibernate.dao.abstraction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractDAO {

    private SessionFactory sessionFactory;

    public Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
