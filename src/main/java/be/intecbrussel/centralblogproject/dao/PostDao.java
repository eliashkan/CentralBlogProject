package be.intecbrussel.centralblogproject.dao;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.Tag;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.stream.Stream;

public class PostDao {

    public Post createPost(Post post) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(post);
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

    public Stream<Post> searchPost(Tag tag) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction txn = em.getTransaction();

        TypedQuery<Post> query = em.createQuery("select p from Post p join p.tags tag where tag.id = ?1", Post.class);

        query.setParameter(1, tag.getId());
        txn.begin();
        txn.commit();

        return query.getResultStream();
    }
}
