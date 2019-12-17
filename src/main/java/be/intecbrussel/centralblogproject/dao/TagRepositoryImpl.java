package be.intecbrussel.centralblogproject.dao;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.Tag;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TagRepositoryImpl {

    public Tag saveTag(Tag tag) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction txn = em.getTransaction();
        em.persist(tag);
        txn.begin();
        txn.commit();
        em.close();
        return tag;
    }
}
