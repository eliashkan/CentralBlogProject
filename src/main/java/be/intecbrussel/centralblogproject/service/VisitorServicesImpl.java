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

public class VisitorServicesImpl implements VisitorServices {

    private PostDao postDAO;
    //we'll load in a stream of posts from the database every time Visitor Services is instantiated. This is just a suggestion.
    private Stream<Post> posts;

    public VisitorServicesImpl() {
        this.postDAO = new PostDao();

        //loading the stream of posts
        EntityManager em = EntityManagerFactoryProvider.getEM();
        TypedQuery<Post> query = em.createQuery("select p from Post p", Post.class);
        //a stream of posts from new to old by default
        Comparator<Post> comparatorByDate = (p1, p2) -> p2.getDateTime().compareTo(p1.getDateTime());
        this.posts = query.getResultStream().sorted(comparatorByDate);
    }

    //getter
    public Stream<Post> getPosts() {
        return posts;
    }

    //setter
    //we can simply set the posts field every time an update has been made to posts instead of having to construct a VisitorServicesImpl object
    public void setPosts(Stream<Post> posts) {
        this.posts = posts;
    }

    @Override
    //good old getter from the DAO
    public Post getSpecificPost(Integer postID) {
        return postDAO.getPost(postID);
    }

    @Override
    //receives a stream of posts
    public Stream<Post> getSixPosts(Stream<Post> postsToBeFiltered) {
        int desiredLength = 6;
        return postsToBeFiltered.limit(desiredLength);
    }

    @Override
    public Stream<Post> getPostsByAuthor(String authorsName) {
        return posts.filter(p -> p.getUser().getFullName().toLowerCase().contains(authorsName.toLowerCase()));
    }

    @Override
    //from most poular to least popular
    public Stream<Post> sortPostsByPopularity() {
        Comparator<Post> comparator = (p1, p2) -> p2.getLikeCounter() - p1.getLikeCounter();
        return posts.sorted(comparator);
    }

    //from most recent to oldest
    public Stream<Post> sortPostsByDate() {
        Comparator<Post> comparatorByDate = (p1, p2) -> p2.getDateTime().compareTo(p1.getDateTime());
        return posts.sorted(comparatorByDate);
    }


    //carries out a search by title, author's name and tag name
    public Stream<Post> searchAll(String text) {
        List<Post> resultListOne = searchByAuthorsNameUnionByPostTitle(text);
        List<Post> resultListTwo = searchPostsByTagName(text);
        //intersection of the above two lists
        return resultListOne.stream().filter(resultListTwo::contains);


    }
    private List<Post> searchByAuthorsNameUnionByPostTitle(String text) {
        //testing according to title
        Predicate<Post> conditionPostTitle = p -> p.getTitle().toLowerCase().contains(text.toLowerCase());
        //testing according to author's name
        Predicate<Post> conditionAuthorsName = p -> p.getUser().getFullName().toLowerCase().contains(text.toLowerCase());
        return posts.
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
}
