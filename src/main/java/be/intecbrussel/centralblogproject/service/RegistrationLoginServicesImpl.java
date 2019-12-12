package be.intecbrussel.centralblogproject.service;

public class RegistrationLoginServicesImpl implements RegistrationLoginServices {
    @Override
    public boolean checkIfUsernameExistsInDB() {
        return false;
    }

    @Override
    public boolean checkUsernamePasswordCombination(Object username, Object password) {
        return false;
    }

    @Override
    public void stayLoggedIn() {

    }
}
