package jpa.Implementations;

import jpa.Interfaces.ISearch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SearchImpl implements ISearch {

    public List searchBySubject(String s) {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("ForumTask");

        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery(
                "findBySubject")
                .setParameter("name", s)
                .getResultList();
    }

    public List searchByUserId(Integer u) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("ForumTask");

        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery(
                "findById")
                .setParameter("id", u)
                .getResultList();
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
