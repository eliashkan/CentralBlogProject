package be.intecbrussel.centralblogproject.dao;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDao {

    public User createUser(User user) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        em.close();
        return user;
    }

    public User getUser(Integer id) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        em.getTransaction().begin();
        User toReturn = em.find(User.class, id);
        em.getTransaction().commit();
        em.close();
        return toReturn;
    }

    public User deleteUser(User user) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        user = em.find(User.class, user.getUserId());
        em.remove(user);
        transaction.commit();
        em.close();
        return user;
    }

    public User updateUser(User user) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        User dbUser = em.find(User.class, user.getUserId());
        dbUser.cloneFrom(user);
        transaction.commit();
        em.close();
        return dbUser;
    }
}

