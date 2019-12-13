package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.model.Post;

import java.util.Collection;
import java.util.stream.Stream;

public interface VisitorServices {
    // Get 1 specific post
    Post getSpecificPost();

    // Get next 6 posts ordered by date/time
    Collection getSixPosts();

    // Get posts by author
    Collection getPostsByAuthor();

    // Sort posts on this page by popularity
    Stream<Post> sortPostsByPopularity();

    // Search element
    Collection searchAll(Object o);
}
