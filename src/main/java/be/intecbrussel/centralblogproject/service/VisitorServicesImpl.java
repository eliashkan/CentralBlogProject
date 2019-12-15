package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class VisitorServicesImpl implements VisitorServices {

    //we'll load in a stream of posts from the database every time Visitor Services is instantiated. This is just a suggestion.
    private Stream<Post> posts;

    public VisitorServicesImpl() {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        TypedQuery<Post> query = em.createQuery("select p from Post p", Post.class);
        //a stream of posts from new to old
        Comparator<Post> comparatorByDate = (p1, p2) -> p2.getDateTime().compareTo(p1.getDateTime());
        this.posts = query.getResultStream().sorted(comparatorByDate);
    }

    public Stream<Post> getPosts() {
        return posts;
    }

    public void setPosts(Stream<Post> posts) {
        this.posts = posts;
    }

    @Override
    public Post getSpecificPost() {
        return null;
    }

    @Override
    //receives a stream of posts
    public Stream<Post> getSixPosts(Stream<Post> postsToBeFiltered) {
        return postsToBeFiltered.limit(6);
    }

    @Override
    public Stream<Post> getPostsByAuthor(String authorsName) {
        return posts.filter(p -> p.getUser().getFullName().toLowerCase().contains(authorsName.toLowerCase()));
    }

    @Override
    public Stream<Post> sortPostsByPopularity() {
        Comparator<Post> comparator = (p1, p2) -> p2.getLikeCounter() - p1.getLikeCounter();
        return posts.sorted(comparator);
    }

    @Override
    public Collection searchAll(Object o) {
        return null;
    }
}
