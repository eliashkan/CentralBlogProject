package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.model.User;

public interface RegistrationLoginServices {

    /*----------LOGIN-----------*/

    // Check if username exists in the database
    boolean isUsernameInDB(String username);

    // Stay logged in, keep User object in session cookie


    // Check if username-password combination is correct
    boolean isPasswordMatchingUsername(String username, String password);


    User stayLogged();


}
