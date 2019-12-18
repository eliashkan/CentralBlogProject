package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.model.Comment;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.User;

public interface AuthorServices {
    // Create comment, link to author, post, .now()
    void submitComment(Comment comment);

    // Delete your own post
    void deleteMyPost(Post post);

    // Update/edit my own post
    void updateMyPost(Post post, Post newPost);

    // Delete a comment from your page
    void deleteAComment(Comment comment);

    // Create a post from submit form
    void submitBlogPost(Post post);

//    // Update avatar
//    void updateAvatar();

    void updateAvatar();

    // Delete profile
    void deleteProfile(User user);

    // Log out
    void logOut();

    // add & update user information
    void updateUserInformation(User userOne, User userTwo);

    void updateAvatar(User user, String newUrl) throws Exception;

    // update password
    void updatePassword(User user, String newPassword);

    //getting user from database with a username
    User getUserByUsername(String user);
}
