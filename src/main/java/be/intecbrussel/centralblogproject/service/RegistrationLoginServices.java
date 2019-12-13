package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.model.User;

public interface RegistrationLoginServices {
    // Check if username exists in the database
    boolean checkIfUsernameExistsInDB();

    /*----------LOGIN-----------*/

    // Check if username-password combination is correct
    boolean checkUsernamePasswordCombination(Object username, Object password);

    // Stay logged in, keep User object in session cookie
    User stayLogged(String username, String password);


}
