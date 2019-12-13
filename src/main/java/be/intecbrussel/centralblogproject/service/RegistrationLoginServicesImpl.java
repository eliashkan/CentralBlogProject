package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

<<<<<<<Updated upstream
        =======
        >>>>>>>Stashed changes

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
            entityManager.close();
            return true;

        } catch (NoResultException e) {
            e.printStackTrace();
            return false;

        } finally {
            entityManager.close();
        }

    }

<<<<<<<Updated upstream
    @Override
    public User stayLogged(String username, String password) {
        TypedQuery<User> query = EntityManagerFactoryProvider.getEM().createQuery(
                "Select userId From User where userName=?1 and password=?2 ", User.class);

        query.setParameter(1, username).getSingleResult();
        query.setParameter(2, password).getSingleResult();
        User userDb = query.getSingleResult();

        return userDb;

=======
>>>>>>>Stashed changes

        @Override
        public User stayLogged () {
            return null;
        }
}
