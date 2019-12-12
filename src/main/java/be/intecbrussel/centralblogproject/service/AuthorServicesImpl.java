package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AuthorServicesImpl implements AuthorServices {

    private UserDao userDAO;

    public AuthorServicesImpl() {
        this.userDAO = new UserDao();
    }

    @Override
    public void submitComment() {

    }

    @Override
    public void deleteMyPost() {

    }

    @Override
    public void updateMyPost() {

    }

    @Override
    public void deleteAComment() {

    }

    @Override
    public void submitBlogPost() {

    }

    @Override
    public void updateAvatar() {

    }

    @Override
    public void deleteProfile() {

    }

    @Override
    public void logOut() {

    }

    @Override
    public void updateUserinformation() {

    }

    @Override
    public void updatePassword(User user, String newPassword) {
        User userToBeUpdated = userDAO.getUser(user.getUserId());
        userToBeUpdated.setPassword(newPassword);
        userDAO.updateUser(userToBeUpdated);
    }
}
