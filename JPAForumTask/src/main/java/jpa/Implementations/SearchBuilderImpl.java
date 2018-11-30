package jpa.Implementations;

import jpa.Factories.EntityManagerCreator;
import jpa.Interfaces.ISearch;
import jpa.Subject;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class SearchBuilderImpl implements ISearch  {
    public List<Subject> searchBySubject(String s) {
        EntityManager em = EntityManagerCreator.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Subject> q = cb.createQuery(Subject.class);
        Root<Subject> sr = q.from(Subject.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(sr);
        q.where(cb.equal(sr.get("name"),p));
        TypedQuery<Subject> query = em.createQuery(q);
        query.setParameter(p, s);
        return query.getResultList();
    }

    public List<Subject> searchByUserId(Integer u) {
        EntityManager em = EntityManagerCreator.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Subject> q = cb.createQuery(Subject.class);
        Root<Subject> sr = q.from(Subject.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        q.select(sr);
        q.where(cb.equal(sr.get("users").get("id"),p));
        TypedQuery<Subject> query = em.createQuery(q);
        query.setParameter(p, u);
        return query.getResultList();
    }

    public List<Subject> searchByUserIdAndDate(Integer u, java.sql.Date d) {
        EntityManager em = EntityManagerCreator.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Subject> q = cb.createQuery(Subject.class);
        Root<Subject> sr = q.from(Subject.class);
        ParameterExpression<Integer> p = cb.parameter(Integer.class);
        ParameterExpression<java.sql.Date> pd = cb.parameter(java.sql.Date.class);
        q.select(sr);
        q.where(cb.and(cb.equal(sr.get("users").get("id"),p),cb.equal(sr.get("dateSending"),pd)));
        TypedQuery<Subject> query = em.createQuery(q);
        query.setParameter(p, u);
        query.setParameter(pd, d);
        return query.getResultList();
    }

    public List<Subject> searchByWordMessage(String w) {
        EntityManager em = EntityManagerCreator.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Subject> q = cb.createQuery(Subject.class);
        Root<Subject> sr = q.from(Subject.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(sr);
        q.where(cb.like(sr.<String>get("message"),p));
        TypedQuery<Subject> query = em.createQuery(q);
        query.setParameter(p, w);
        return query.getResultList();
    }

    public List<Subject> searchAll() {
        EntityManager em = EntityManagerCreator.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Subject> q = cb.createQuery(Subject.class);
        Root<Subject> sr = q.from(Subject.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        q.select(sr);
        TypedQuery<Subject> query = em.createQuery(q);
        return query.getResultList();
    }

    public void updateMessageByUserId(Integer u) {
        EntityManager em = EntityManagerCreator.getEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Subject> update = cb.
                createCriteriaUpdate(Subject.class);
        Root<Subject> sr = update.from(Subject.class);

        update.set("message", "[Blocked by moderator]");
        update.where(cb.equal(sr.get("users").get("id"), u));

        em.createQuery(update).executeUpdate();
        em.getTransaction().commit();
    }

    public void deleteMessageByUserId(Integer u) {
        EntityManager em = EntityManagerCreator.getEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaDelete<Subject> delete = cb.
                createCriteriaDelete(Subject.class);

        Root<Subject> sr = delete.from(Subject.class);
        delete.where(cb.equal(sr.get("users").get("id"), u));
        em.createQuery(delete).executeUpdate();
        em.getTransaction().commit();

    }
}
