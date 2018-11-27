package jpa.Implementations;

import jpa.Interfaces.ISearch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SearchImpl implements ISearch {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("ForumTask");

    private final static String SELECT_SQL_ALL = "SELECT users.nickname AS nickname, topic.name AS topic_name, subject.name AS subject_name, subject.message, subject.date_sending " +
            "FROM forum_schema.subject " +
            "INNER JOIN forum_schema.users ON subject.user_id = users.id " +
            "INNER JOIN forum_schema.topic ON subject.topic_id = topic.id ";

    public List searchBySubject(String s) {

//        EntityManagerFactory emf = Persistence
//                .createEntityManagerFactory("ForumTask");
//
//        EntityManager em = emf.createEntityManager();
//        return em.createQuery(
//                "SELECT s FROM Subject s WHERE s.name LIKE :name")
//                .setParameter("name", s)
//                .setMaxResults(10)
//                .getResultList();
        return  null;
    }

    public List searchByUserId(Integer u) {
        return null;
    }

    public List searchByUserIdAndDate(Integer u, String d) {
        return null;
    }

    public List searchByWordMessage(String w) {
        return null;
    }

    public List searchAll() {
        return null;
    }
}
