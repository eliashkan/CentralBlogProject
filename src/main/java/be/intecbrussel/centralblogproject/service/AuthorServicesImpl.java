package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.dao.CommentDao;
import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.Comment;
import be.intecbrussel.centralblogproject.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class AuthorServicesImpl implements AuthorServices {

    private UserDao userDAO;
    private CommentDao commentDao;


    @Override
    public void submitComment(Comment comment) {
        commentDao.createComment(comment);

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
        userDAO.createUser(userToBeUpdated);
        userDAO.updateUser(userToBeUpdated);
    }

    @Override
    public User getUserByName(String user) {
        //Making The query for getting the username id
        EntityManager entityManager = EntityManagerFactoryProvider.getEM();
        TypedQuery<Integer> userID = entityManager.createQuery("Select userId from User where userName=?1", Integer.class);
        Integer userId = userID.getSingleResult();

        //Getting user from database
        return new UserDao().getUser(userId);
    }

}
