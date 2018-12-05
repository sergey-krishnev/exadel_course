package hibernate.Implementations;

import hibernate.Factories.HibernateSessionFactory;
import hibernate.FileDataReader.ScvReader;
import hibernate.Interfaces.ISearch;
import hibernate.Subject;
import org.hibernate.Session;

import java.sql.Date;
import java.util.List;

public class SearchImpl implements ISearch {
    @Override
    public List<Subject> searchBySubject(String s) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery(
                "findBySubject", Subject.class)
                .setParameter("name", s)
                .getResultList();
    }

    @Override
    public List<Subject> searchByUserId(Integer u) {
        return null;
    }

    @Override
    public List<Subject> searchByUserIdAndDate(Integer u, Date d) {
        return null;
    }

    @Override
    public List<Subject> searchByWordMessage(String w) {
        return null;
    }

    @Override
    public List<Subject> searchAll() {
        return null;
    }

    @Override
    public void updateMessageByUserId(Integer u) {

    }

    @Override
    public void deleteMessageByUserId(Integer u) {

    }

    @Override
    public void batchInsertSubject(ScvReader scvReader, Integer numConf) {

    }
}
