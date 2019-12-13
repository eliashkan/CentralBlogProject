package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.util.List;


public class RegistrationLoginServicesImpl implements RegistrationLoginServices {


    @Override
    public boolean isUsernameInDB(String username) {
        EntityManager entityManager = EntityManagerFactoryProvider.getEM();
        TypedQuery<User> query = entityManager.createQuery(
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
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public boolean isPasswordMatchingUsername(String username, String password) {
        EntityManager entityManager = EntityManagerFactoryProvider.getEM();
        TypedQuery<User> query = entityManager.createQuery(
                "Select u From User u where u.userName=?1 and u.password=?2 ", User.class);
        query.setParameter(1, username);
        query.setParameter(2, password);

        User user;
        try {
            user = query.getSingleResult();
            return true;

        } catch (NoResultException e) {

            e.printStackTrace();
            return false;

        } finally {
            entityManager.close();
        }

    }

    @Override
    public User stayLogged() {
        return null;
    }
}
