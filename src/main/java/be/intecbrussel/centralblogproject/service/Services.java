package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.model.Post;

import java.util.Collection;

public interface Services {

    /*-------VISITOR--------*/

    // Get 1 specific post
    Post getSpecificPost();

    // Get next 6 posts ordered by date/time
    Collection getSixPosts();

    // Get posts by author
    Collection getPostsByAuthor();

    // Sort posts on this page by popularity
    Collection sortPostsByPopularity();


    // Search element
    Collection searchAll(Object o);

    /*-----------REGISTRATIE-------------*/

    // Check if username exists in the database
    boolean checkIfUsernameExistsInDB();

    /*----------LOGIN-----------*/

    // Check if username-password combination is correct
    boolean checkUsernamePasswordCombination(Object username, Object password);

    // Stay logged in, keep User object in session cookie
    void stayLoggedIn();

    /*---------------AUTHOR ACTIONS-----------*/

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
    void deleteProfile();

    // Log out
    void logOut();

    // add & update user information
    void updateUserinformation();

    // update password
    void updatePassword();
}
