package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.Tag;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public interface VisitorServices {

    // Get 1 specific post
    Post getSpecificPost(Integer postID);

    // Get next 6 posts ordered by date/time
    List<Post> getSixPosts(int indexOfFirstElement);

    // Get posts by author
    List<Post> getPostsByAuthor(String authorsName);

    // Sort posts on this page by popularity
    List<Post> sortPostsByPopularity();

    // Search element
    Collection searchAll(Tag tag);

    List<Post> sortPostsByDateDesc();

    List<Post> sortPostsByDateAsc();

    List<Post> sortPostsByPopularityAsc();


}
