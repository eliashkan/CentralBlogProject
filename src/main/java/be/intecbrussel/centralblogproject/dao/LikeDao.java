package be.intecbrussel.centralblogproject.dao;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.Like_S;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LikeDao {


    public Like_S createLike(Like_S likeS) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(likeS);
        transaction.commit();
        em.close();
        return likeS;
    }

    public Like_S getLikes(Integer idLike) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        em.getTransaction().begin();
        Like_S toReturn = em.find(Like_S.class, idLike);
        em.getTransaction().commit();
        em.close();
        return toReturn;
    }

    public Like_S deleteLike(Like_S likeS) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Like_S dbLikeS = em.find(Like_S.class, likeS.getLikeId());
        em.remove(dbLikeS);
        transaction.commit();
        em.close();
        return dbLikeS;
    }

    public Like_S updateLike(Like_S likeS) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Like_S dbLikeS = em.find(Like_S.class, likeS.getLikeId());
        dbLikeS.cloneFrom(likeS);
        transaction.commit();
        em.close();
        return dbLikeS;
    }
}
