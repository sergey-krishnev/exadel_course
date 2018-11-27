package jpa;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import jpa.Subject;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    private static EntityManager em;

    public static void main(String[] args) {

        BasicConfigurator.configure();

        logger.info("log4j is work");

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("ForumTask");
        em = emf.createEntityManager();

        Query q = em.createNamedQuery("findAll");
        List usersList = q.getResultList();
        for (Object users : usersList) {
            logger.info(users);
        }
    }
}
