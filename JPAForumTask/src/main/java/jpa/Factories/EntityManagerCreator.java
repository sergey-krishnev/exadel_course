package jpa.Factories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCreator {

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("ForumTask");

        return emf.createEntityManager();
    }
}
