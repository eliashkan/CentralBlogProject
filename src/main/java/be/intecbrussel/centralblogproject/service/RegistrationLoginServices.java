package be.intecbrussel.centralblogproject.service;

public interface RegistrationLoginServices {
    // Check if username exists in the database
    boolean checkIfUsernameExistsInDB();

    /*----------LOGIN-----------*/

    // Check if username-password combination is correct
    boolean checkUsernamePasswordCombination(Object username, Object password);

    // Stay logged in, keep User object in session cookie
    void stayLoggedIn();
}
