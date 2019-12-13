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

 /*   public List<Post> searchPost(Tag tag) {
        EntityManager em = EntityManagerFactoryProvider.getEM();

        TypedQuery<Post> query = em.createQuery("select p from Post p join p.tags tag where tag.id = ?1", Post.class);
        em.close();

        query.setParameter(1, tag.getId());

        return query.getResultList();
    }

    public List<Post> sortPostsByDateDesc() {
        EntityManager em = EntityManagerFactoryProvider.getEM();

        TypedQuery<Post> query = em.createQuery("select p from Post p order by p.localDate desc", Post.class);
        em.close();
        return query.getResultList();
    }

    public List<Post> sortPostsByDateAsc() {
        EntityManager em = EntityManagerFactoryProvider.getEM();

        TypedQuery<Post> query = em.createQuery("select p from Post p order by p.dateTime asc", Post.class);
        em.close();

        return query.getResultList();
    }

    public List<Post> sortPostsByPopularityDesc() {
        EntityManager em = EntityManagerFactoryProvider.getEM();

        TypedQuery<Post> query = em.createQuery("select p from Post p order by p.likeCounter desc", Post.class);
        em.close();

        return query.getResultList();
    }

    public List<Post> sortPostsByPopularityAsc() {
        EntityManager em = EntityManagerFactoryProvider.getEM();

        TypedQuery<Post> query = em.createQuery("select p from Post p order by p.likeCounter asc", Post.class);

        em.close();
        return query.getResultList();
    }

    //reduced content can be shown by e.getText().substring(30) on the servlet page
    //likewise indexOfFirstElement argument must be provided by the the ServletPage
    public List<Post> showSixPostsWithPaging(int indexOfFirstElement) {
        EntityManager em = EntityManagerFactoryProvider.getEM();

        //if you have a small number of rows in the post table you can lower the value below in order to test
        int numberOfPosts = 6;

        TypedQuery<Post> query = em.createQuery("select p from Post p", Post.class);
        query.setFirstResult(indexOfFirstElement);
        query.setMaxResults(numberOfPosts);
        em.close();

        return query.getResultList();
    }*/
}



