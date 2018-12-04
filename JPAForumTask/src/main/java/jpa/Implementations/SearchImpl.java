package jpa.Implementations;

import jpa.Exceptions.MyBatchException;
import jpa.Factories.EntityManagerCreator;
import jpa.FileDataReader.ScvReader;
import jpa.Interfaces.ISearch;
import jpa.Subject;
import jpa.Topic;
import jpa.Users;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class SearchImpl implements ISearch {

    private final static Logger logger = Logger.getLogger(SearchImpl.class);

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

    public  List<Users> searchAllUsers() {
        EntityManager em = EntityManagerCreator.getEntityManager();
        return em.createNamedQuery(
                "findAllUsers", Users.class)
                .getResultList();
    }

    public List<Topic> searchAllTopic() {
        EntityManager em = EntityManagerCreator.getEntityManager();
        return em.createNamedQuery(
                "findAllTopics", Topic.class)
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

    @Override
    public void batchInsertSubject(ScvReader scvReader, Integer numConf) throws MyBatchException {
        EntityManager em = EntityManagerCreator.getEntityManager();
        EntityTransaction entityTransaction = em
                .getTransaction();
        try {
            entityTransaction.begin();

            for (int i = 0; i < scvReader.getSizeFile(); i++) {
                if (i > 0 && i % numConf == 0) {
                    entityTransaction.commit();
                    entityTransaction.begin();

                    em.clear();
                }
                List<Users> users = searchAllUsers();
                for (Users user : users) {
                    List<Topic> topics = searchAllTopic();
                    for (Topic topic : topics) {
                        if ((topic.getId() == scvReader.getTopicsId().get(i)) &&
                                (user.getId() == scvReader.getUsersId().get(i))) {
                            Subject subject = new Subject(scvReader.getNames().get(i), scvReader.getMessages().get(i), scvReader.getDatesSending().get(i),
                                    user, topic);
                            em.persist(subject);
                        }
                    }
                }
            }

            entityTransaction.commit();
        } catch (RuntimeException e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            logger.error("Batch processing error: " + e.getMessage());
            throw new MyBatchException(e.getMessage(), e);
        } finally {
            em.close();
        }
    }

//        Connection connection =null;
//        try {
//            connection = Connector.connect();
//            PreparedStatement insertPreparedStatement = connection.prepareStatement(INSERT_SUBJECTS);
//            for(int i = 0; i < numConf; i++) {
//                insertPreparedStatement.setString(1, scvReader.getNames().get(i));
//                insertPreparedStatement.setString(2,  scvReader.getMessages().get(i));
//                insertPreparedStatement.setDate(3, scvReader.getDatesSending().get(i));
//                insertPreparedStatement.setInt(4, scvReader.getUsersId().get(i));
//                insertPreparedStatement.setInt(5, scvReader.getTopicsId().get(i));
//                insertPreparedStatement.addBatch();
//            }
//            insertPreparedStatement.executeBatch();
//        } catch (SQLException e) {
//            doRollback(connection);
//            e.printStackTrace();
}

