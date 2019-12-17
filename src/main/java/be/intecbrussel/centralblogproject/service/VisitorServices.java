package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.model.Post;

import java.util.List;

public interface VisitorServices {

    // Get 1 specific post
    Post getSpecificPost(Integer postID);

    //receives a stream of posts
    List<Post> getSixMorePosts(int multiplier);

    // Get posts by author
    List<Post> getPostsByAuthor(String authorsName);

    // Sort posts on this page by popularity
    List<Post> sortPostsByPopularity(int i, List<Post> sessionPostList);

    // Search element
    List<Post> searchAll(String text);
}
