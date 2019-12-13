package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.User;

import javax.persistence.TypedQuery;

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
    public User stayLogged(String username, String password) {
        TypedQuery<User> query = EntityManagerFactoryProvider.getEM().createQuery(
                "Select userId From User where userName=?1 and password=?2 ", User.class);

        query.setParameter(1, username).getSingleResult();
        query.setParameter(2, password).getSingleResult();
        User userDb = query.getSingleResult();

        return userDb;


    }
}
