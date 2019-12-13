package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.model.Comment;
import be.intecbrussel.centralblogproject.model.User;



public interface AuthorServices {
    // Create comment, link to author, post, .now()
    void submitComment(Comment comment);

    // Delete your own post
    void deleteMyPost();

    // Update/edit my own post
    void updateMyPost();

    // Delete a comment from your page
    void deleteAComment();

    // Create a post from submit form
    void submitBlogPost();

    // Update avatar
    void updateAvatar();

    // Delete profile
    void deleteProfile();

    // Log out
    void logOut();

    // add & update user information
    void updateUserinformation();

    // update password
    void updatePassword(User user, String newPassword);
}
