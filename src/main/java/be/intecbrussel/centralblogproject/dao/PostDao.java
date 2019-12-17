package be.intecbrussel.centralblogproject.dao;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.Tag;
import be.intecbrussel.centralblogproject.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public Post getPost(Integer idPost) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        em.getTransaction().begin();
        Post toReturn = em.find(Post.class, idPost);
        em.getTransaction().commit();
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

    public Post updatePost(Post post) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(post);
        transaction.commit();
        em.close();
        return post;
    }


        TypedQuery<Post> query = em.createQuery("select p from Post p order by p.dateTime desc", Post.class);

        return query.getResultList();
    }

    public List<Post> sortPostsByDateAsc() {
        EntityManager em = EntityManagerFactoryProvider.getEM();

        TypedQuery<Post> query = em.createQuery("select p from Post p order by p.dateTime asc", Post.class);

        return query.getResultList();
    }

}



        return query.getResultList();
    }

}
