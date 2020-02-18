package be.intecbrussel.centralblogproject.service;


import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.dao.PostDao;
import be.intecbrussel.centralblogproject.model.Post;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class VisitorServicesImpl {

    private PostDao postDAO;
    //we'll load in a list of posts from the database every time Visitor Services is instantiated
    private List<Post> posts;

    public VisitorServicesImpl() {
        this.postDAO = new PostDao();

        //loading the stream of posts
        System.out.println("BOOP DA SNOOT");
        EntityManager em = EntityManagerFactoryProvider.getEM();
        TypedQuery<Post> query = em.createQuery("select p from Post p", Post.class);
        //a stream of posts from new to old by default
        Comparator<Post> comparatorByDate = (p1, p2) -> p2.getDateTime().compareTo(p1.getDateTime());
        this.posts = query.getResultStream().
                sorted(comparatorByDate).
                collect(Collectors.toList());
        em.close();
    }

    //getter
    public List<Post> getPosts() {
        return posts;
    }

    //setter
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    //good old getter from the DAO
    public Post getSpecificPost(Integer postID) {
        return postDAO.getPost(postID);
    }


    //receives a stream of posts
    public List<Post> getSixMorePosts(int multiplier) {
        int desiredLength = 6;
        return posts.stream().
                limit(desiredLength * multiplier).
                collect(Collectors.toList());
    }

    public List<Post> getPostsByAuthor(String authorsName) {
        return posts.stream().
                filter(p -> p.getUser().getUserName().toLowerCase().contains(authorsName.toLowerCase())).
                collect(Collectors.toList());
    }


    //from most poular to least popular
//    public List<Post> sortPostsByPopularity(int multiplier, List<Post> posts) {
//        Comparator<Post> comparator = (p1, p2) -> p2.getLikeCounter() - p1.getLikeCounter();
//        return posts.stream().
//                sorted(comparator).limit(multiplier).
//                collect(Collectors.toList());
//    }

    //from most recent to oldest
    public List<Post> sortPostsByDate(int multiplier) {
        Comparator<Post> comparatorByDate = (p1, p2) -> p2.getDateTime().compareTo(p1.getDateTime());
        return posts.
                stream().
                sorted(comparatorByDate).limit(multiplier).
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

    public List<Post> searchByAuthorsNameUnionByPostTitle(String text) {
        //testing according to title
        Predicate<Post> conditionPostTitle = p -> p.getTitle().toLowerCase().contains(text.toLowerCase());
        //testing according to author's name
        Predicate<Post> conditionAuthorsName = p -> p.getUser().getFullName().toLowerCase().contains(text.toLowerCase());
        return posts.stream().
                filter(conditionAuthorsName.or(conditionPostTitle))
                .collect(Collectors.toList());
    }

    //via JPQL. Can't find any other way
    public List<Post> searchPostsByTagName(String text) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        TypedQuery<Post> query = em.createQuery("select p from Post p join p.tags tag where tag.name=?1", Post.class);
        query.setParameter(1, text);
        List<Post> posts = query.getResultList();
        em.close();
        return posts;

    }

    public Long getLikeByPost(int postId) {
        EntityManager em = EntityManagerFactoryProvider.getEM();
        TypedQuery<Long> query = em.createQuery("SELECT count (post) from Like_S where post.idPost = ?1", Long.class);
        query.setParameter(1, postId);
        Long result = query.getSingleResult();
        em.close();
        return result;
    }
}



