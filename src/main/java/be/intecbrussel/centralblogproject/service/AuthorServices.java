package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.model.User;

public interface AuthorServices {
    // Create comment, link to author, post, .now()
    void submitComment();

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
    void deleteProfile(User user);

    // Log out
    void logOut();

    // add & update user information
    void updateUserInformation(User userOne, User userTwo);

    void updateAvatar(User user, String newUrl) throws Exception;

    // update password
    void updatePassword(User user, String string);
}
