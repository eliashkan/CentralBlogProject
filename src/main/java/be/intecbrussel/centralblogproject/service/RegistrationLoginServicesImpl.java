package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.User;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class RegistrationLoginServicesImpl implements RegistrationLoginServices {

    @Override
    public boolean checkIfUsernameExistsInDB(String username) {
        TypedQuery<User> query = EntityManagerFactoryProvider.getEM().createQuery(
                "SELECT u FROM User u WHERE u.userName=?1",
                User.class
        );
        query.setParameter(1, username);
        User user;
        try {
            user = query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean checkUsernamePasswordCombination(Object username, Object password) {
        return false;
    }

    @Override
    public void stayLoggedIn() {

    }
}
