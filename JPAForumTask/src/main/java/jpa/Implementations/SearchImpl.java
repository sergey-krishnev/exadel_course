package jpa.Implementations;

import jpa.Factories.EntityManagerCreator;
import jpa.Interfaces.ISearch;
import jpa.Subject;

import javax.persistence.EntityManager;
import java.util.List;

public class SearchImpl implements ISearch {

    public List<Subject> searchBySubject(String s) {
        EntityManager em = EntityManagerCreator.getEntityManager();
        return em.createNamedQuery(
                "findBySubject", Subject.class)
                .setParameter("name", s)
                .getResultList();
    }

    public List<Subject> searchByUserId(Integer u) {
        EntityManager em = EntityManagerCreator.getEntityManager();
        return em.createNamedQuery(
                "findById", Subject.class)
                .setParameter("id", u)
                .getResultList();
    }

    public List<Subject> searchByUserIdAndDate(Integer u, java.sql.Date d) {
        EntityManager em = EntityManagerCreator.getEntityManager();
        return em.createNamedQuery(
                "findByUserAndDate", Subject.class)
                .setParameter("id", u)
                .setParameter("dateSending", d)
                .getResultList();
    }

    public List<Subject> searchByWordMessage(String w) {
        EntityManager em = EntityManagerCreator.getEntityManager();
        return em.createNamedQuery(
                "findByWordMessage", Subject.class)
                .setParameter("message", w)
                .getResultList();
    }

    public List<Subject> searchAll() {
        EntityManager em = EntityManagerCreator.getEntityManager();
        return em.createNamedQuery(
                "findAll", Subject.class)
                .getResultList();
    }

    public void updateMessageByUserId(Integer u) {
        EntityManager em = EntityManagerCreator.getEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery(
                "updateMessageById", Subject.class)
                .setParameter("id", u)
                .executeUpdate();
        em.getTransaction().commit();
    }

    public void deleteMessageByUserId(Integer u) {
        EntityManager em = EntityManagerCreator.getEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery(
                "deleteMessageById", Subject.class)
                .setParameter("id", u)
                .executeUpdate();
        em.getTransaction().commit();
    }
}
