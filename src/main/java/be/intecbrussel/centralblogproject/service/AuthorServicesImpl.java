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

    //this does not contain avatar as setAvatar() does not currently take byte[] as parameter
    @Override
    public void updateUserInformation(User userWithOldState, User userWithNewState) {
        User userToBeUpdated = userDAO.getUser(userWithOldState.getUserId());
        userToBeUpdated.setFullName(userWithNewState.getFullName());
        userToBeUpdated.setAdress(userWithNewState.getAdress());
        userToBeUpdated.setUserName(userWithNewState.getUserName());
        userToBeUpdated.setPassword(userWithNewState.getPassword());
        userToBeUpdated.setEmail(userWithNewState.getEmail());
        userDAO.updateUser(userToBeUpdated);
    }

    //seperate update method for avatar so the argument list of updateUserInformation is not loaded unnecessarily
    public void updateAvatar(User user, String newUrl) throws Exception {
        User userToBeUpdated = userDAO.getUser(user.getUserId());
        userToBeUpdated.setAvatar(newUrl);
        userDAO.updateUser(userToBeUpdated);
    }

    @Override
    public void updatePassword(User user, String newPassword) {
        User userToBeUpdated = userDAO.getUser(user.getUserId());
        userToBeUpdated.setPassword(newPassword);
        userDAO.updateUser(userToBeUpdated);
    }
}
