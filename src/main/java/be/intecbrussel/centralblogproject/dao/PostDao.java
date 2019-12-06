package be.intecbrussel.centralblogproject.dao;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PostDao {

    public Post createPost(Post post) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        post = em.merge(post);
        transaction.commit();
        em.close();
        return post;
    }

    public Post getPost(Integer id) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        Post toReturn = em.find(Post.class, id);
        em.close();
        return toReturn;
    }

    public Post deletePost(Post post) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Post dbPost = em.find(Post.class, post.getIdPost());
        em.remove(dbPost);
        transaction.commit();
        em.close();
        return dbPost;
    }

    public Post updatPost(Post post) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Post dbPost = em.find(Post.class, post.getIdPost());
        dbPost.cloneFrom(post);
        transaction.commit();
        em.close();
        return dbPost;
    }
}
