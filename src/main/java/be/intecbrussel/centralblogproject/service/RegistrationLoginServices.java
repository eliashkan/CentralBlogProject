package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.model.User;

public interface RegistrationLoginServices {
    Stashed changes

    /*----------LOGIN-----------*/

    // Check if username exists in the database
    boolean isUsernameInDB(String username);

    // Stay logged in, keep User object in session cookie
<<<<<<<Updated upstream
    User stayLogged(String username, String password);
=======

    // Check if username-password combination is correct
    boolean isPasswordMatchingUsername(String username, String password);
>>>>>>>

    User stayLogged();


}
