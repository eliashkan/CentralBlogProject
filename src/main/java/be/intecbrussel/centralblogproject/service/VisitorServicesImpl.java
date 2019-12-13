package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

public class VisitorServicesImpl implements VisitorServices {

    //we'll load in a stream of posts from the database every time Visitor Services is instantiated. This is just a suggestion.
    private Stream<Post> posts;

    public VisitorServicesImpl() {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        TypedQuery<Post> query = em.createQuery("select p from Post p", Post.class);
        this.posts = query.getResultStream();
    }

    @Override
    public Post getSpecificPost() {
        return null;
    }

    @Override
    public Collection getSixPosts() {
        return null;
    }

    @Override
    public Collection getPostsByAuthor() {
        return null;
    }

    @Override
    public Stream<Post> sortPostsByPopularity() {
        return posts.sorted(Comparator.comparingInt(Post::getLikeCounter));
    }

    @Override
    public Collection searchAll(Object o) {
        return null;
    }
}
