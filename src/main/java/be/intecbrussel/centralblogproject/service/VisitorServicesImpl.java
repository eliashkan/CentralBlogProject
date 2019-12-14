package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.Tag;
import be.intecbrussel.centralblogproject.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

public class VisitorServicesImpl implements VisitorServices {


    @Override
    public List<Post> getPostsByAuthor(Integer userId) {

        EntityManager em = EntityManagerFactoryProvider.getEM();
        TypedQuery<Post> query = em.createQuery(
                "SELECT p FROM Post p WHERE p.user.userId=?1",
                Post.class
        );
        query.setParameter(1, userId);
        List<Post> allPostFromUser = query.getResultList();
        em.close();

        return allPostFromUser;
    }


    @Override
    public List<Post> getMorePosts(int indexOfFirstElement, int numberOfShowedPosts) {

        EntityManager em = EntityManagerFactoryProvider.getEM();
        //if you have a small number of rows in the post table you can lower the value below in order to test

        TypedQuery<Post> query = em.createQuery("select p from Post p", Post.class);
        query.setFirstResult(indexOfFirstElement);
        query.setMaxResults(numberOfShowedPosts);
        List<Post> nextSixPost = query.getResultList();
        em.close();

        return nextSixPost;
    }

    @Override
    public Post getSpecificPost() {
        return null;
    }

    @Override
    public List<Post> sortPostsByPopularity() {
        EntityManager em = EntityManagerFactoryProvider.getEM();

        TypedQuery<Post> query = em.createQuery("select p from Post p order by p.likeCounter desc", Post.class);
        em.close();

        return query.getResultList();
    }

    @Override
    public List<Post> sortPostsByDateDesc() {
//        EntityManager em = EntityManagerFactoryProvider.getEM();
//        TypedQuery<Post> query = em.createQuery("select p from Post p order by p.localDate desc", Post.class);
//        em.close();
//        return query.getResultList();
        return null;
    }


    public List<Post> sortPostsByPopularityAsc() {
        EntityManager em = EntityManagerFactoryProvider.getEM();

        TypedQuery<Post> query = em.createQuery("select p from Post p order by p.likeCounter asc", Post.class);

        em.close();
        return query.getResultList();
    }

    @Override
    public Collection searchAll(Tag tag) {
        EntityManager em = EntityManagerFactoryProvider.getEM();

        TypedQuery<Post> query = em.createQuery("select p from Post p join p.tags tag where tag.id = ?1", Post.class);
        query.setParameter(1, tag.getId());

        em.close();


        return query.getResultList();
    }

    @Override
    public List<Post> sortPostsByDateAsc() {
        EntityManager em = EntityManagerFactoryProvider.getEM();

        TypedQuery<Post> query = em.createQuery("select p from Post p order by p.dateTime asc", Post.class);
        em.close();

        return query.getResultList();
    }


}
