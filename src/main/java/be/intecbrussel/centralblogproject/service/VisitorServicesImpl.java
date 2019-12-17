package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.dao.PostDao;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.Tag;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.List;

public class VisitorServicesImpl implements VisitorServices{

    private PostDao postDAO;
    //we'll load in a list of posts from the database every time Visitor Services is instantiated
    private List<Post> posts;

    public VisitorServicesImpl() {
        this.postDAO = new PostDao();

        //loading the stream of posts
        EntityManager em = EntityManagerFactoryProvider.getEM();
        TypedQuery<Post> query = em.createQuery("select p from Post p", Post.class);
        //a stream of posts from new to old by default
        Comparator<Post> comparatorByDate = (p1, p2) -> p2.getDateTime().compareTo(p1.getDateTime());
        this.posts = query.getResultStream().
                sorted(comparatorByDate).
                collect(Collectors.toList());
    }

    //getter
    public List<Post> getPosts() {
        return posts;
    }

    //setter
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    //good old getter from the DAO
    public Post getSpecificPost(Integer postID) {
        return postDAO.getPost(postID);
    }

    @Override
    //receives a stream of posts
    public List<Post> getSixMorePosts(int multiplier) {
        int desiredLength = 6;
        return posts.stream().
                limit(desiredLength*multiplier).
                collect(Collectors.toList());
    }

    @Override
    public List<Post> getPostsByAuthor(String authorsName) {
        return posts.stream().
                filter(p -> p.getUser().getFullName().toLowerCase().contains(authorsName.toLowerCase())).
                collect(Collectors.toList());
    }

    @Override
    //from most poular to least popular
    public List<Post> sortPostsByPopularity() {
        Comparator<Post> comparator = (p1, p2) -> p2.getLikeCounter() - p1.getLikeCounter();
        return posts.stream().
                sorted(comparator).
                collect(Collectors.toList());
    }

    //from most recent to oldest
    public List<Post> sortPostsByDate() {
        Comparator<Post> comparatorByDate = (p1, p2) -> p2.getDateTime().compareTo(p1.getDateTime());
        return posts.
                stream().
                sorted(comparatorByDate).
                collect(Collectors.toList());
    }


    //carries out a search by title, author's name and tag name
    public List<Post> searchAll(String text) {
        List<Post> resultListOne = searchByAuthorsNameUnionByPostTitle(text);
        List<Post> resultListTwo = searchPostsByTagName(text);
        //list1 + (list2-list1)
        resultListTwo.removeAll(resultListOne);
        resultListOne.addAll(resultListTwo);
        return resultListOne;

    }
    private List<Post> searchByAuthorsNameUnionByPostTitle(String text) {
        //testing according to title
        Predicate<Post> conditionPostTitle = p -> p.getTitle().toLowerCase().contains(text.toLowerCase());
        //testing according to author's name
        Predicate<Post> conditionAuthorsName = p -> p.getUser().getFullName().toLowerCase().contains(text.toLowerCase());
        return posts.stream().
                filter(conditionAuthorsName.or(conditionPostTitle))
                .collect(Collectors.toList());
    }

    //via JPQL. Can't find any other way
    private List<Post> searchPostsByTagName(String text) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        TypedQuery<Post> query = em.createQuery("select p from Post p join p.tags tag where tag.name=?1", Post.class);
        query.setParameter(1, text);
        return query.getResultList();

    }

    @Override
    public Collection searchAll(Tag tag) {
        EntityManager em = EntityManagerFactoryProvider.getEM();

        TypedQuery<Post> query = em.createQuery("select p from Post p join p.tags tag where tag.id = ?1", Post.class);
        em.close();

        query.setParameter(1, tag.getId());

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
