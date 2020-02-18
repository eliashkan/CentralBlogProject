package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.model.Post;

import java.util.List;
import java.util.stream.Stream;

public interface VisitorServices {

    List<Post> getPosts();

    void setPosts(Stream<Post> posts);
    // Get 1 specific post
    Post getSpecificPost(Integer postID);

    // Get next 6 posts ordered by date/time
    List<Post> getSixPosts();

    // Get posts by author
    Stream<Post> getPostsByAuthor(String authorsName);

    // Sort posts on this page by popularity
    Stream<Post> sortPostsByPopularity();

    // Search element
    Stream<Post> searchAll(String text);
}
