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
    public User getUserByUsername(String userName) {
        //Making The query for getting the username id
        EntityManager entityManager = EntityManagerFactoryProvider.getEM();
        TypedQuery<Integer> query = entityManager.createQuery("Select userId from User where userName=?1", Integer.class);
        query.setParameter(1, userName);
        Integer userId = query.getSingleResult();

        //Getting the user after getting the userId with the typedQuery
        User userFromDB = new UserDao().getUser(userId);
        entityManager.close();

        //Getting user from database
        return userFromDB;
    }

}
