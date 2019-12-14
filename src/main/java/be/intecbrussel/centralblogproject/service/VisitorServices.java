package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.Tag;

import java.util.Collection;
import java.util.List;

public interface VisitorServices {
    // Get 1 specific post
    Post getSpecificPost();

    // Get next 6 posts ordered by date/time
    List<Post> getSixPosts(int indexOfFirstElement);

    // Get posts by author
    Collection getPostsByAuthor(Integer userId);

    // Sort posts on this page by popularity
    Collection sortPostsByPopularity();

    // Search element
    Collection searchAll(Tag tag);

    List<Post> sortPostsByDateDesc();

    List<Post> sortPostsByDateAsc();

    List<Post> sortPostsByPopularityAsc();


}
