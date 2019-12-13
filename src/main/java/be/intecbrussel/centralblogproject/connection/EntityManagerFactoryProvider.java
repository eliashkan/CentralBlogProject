package be.intecbrussel.centralblogproject.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProvider {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("datasourceLocal");

    public static EntityManager getEM() {
        return entityManagerFactory.createEntityManager();
    }


}