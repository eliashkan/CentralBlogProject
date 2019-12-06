package be.intecbrussel.centralblogproject.dao;


import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.Comment;
import be.intecbrussel.centralblogproject.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


public class CommentDao {

    public Comment createComment(Comment comment) {
        EntityManager entityManager = EntityManagerFactoryProvider.getEM();
        entityManager.getTransaction().begin();
        entityManager.persist(comment);
        entityManager.getTransaction().commit();
        entityManager.close();
        return comment;
    }

    public Comment getComment(Integer id) {
        EntityManager entityManager = EntityManagerFactoryProvider.getEM();
        entityManager.getTransaction().begin();
        Comment comment = entityManager.find(Comment.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return comment;
    }

    public Comment deleteComment(Comment comment) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Comment dbComment = em.find(Comment.class,comment.getIdComment());
        em.remove(dbComment);
        transaction.commit();
        em.close();
        return comment;
    }

    public Comment updateComment(Comment comment) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Comment dbComment = em.find(Comment.class, comment.getIdComment());
        dbComment.cloneFrom(comment);
        transaction.commit();
        em.close();
        return dbComment;

    }

}
