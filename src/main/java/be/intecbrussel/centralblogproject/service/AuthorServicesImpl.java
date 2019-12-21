package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.dao.CommentDao;
import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.Comment;
import be.intecbrussel.centralblogproject.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class AuthorServicesImpl implements AuthorServices {

    // Create comment, link to author, post, .now()
    public void submitComment(Integer userId, Integer post, Comment comment) {
        EntityManager txn = EntityManagerFactoryProvider.getEM();
        txn.getTransaction().begin();
        comment = new CommentDao().createComment(comment);
        Query updateQuery = txn.createNativeQuery("UPDATE Comment p SET p.user_userId = ?1, p.post = ?2 WHERE p.idComment = ?3");
        updateQuery.setParameter(1, userId);
        updateQuery.setParameter(2, post);
        updateQuery.setParameter(3, comment.getIdComment());
        updateQuery.executeUpdate();
        txn.getTransaction().commit();
        txn.close();


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
        UserDao userDao = new UserDao();
        User userToBeUpdated = userDao.getUser(user.getUserId());
        userToBeUpdated.setPassword(newPassword);
        userDao.createUser(userToBeUpdated);
        userDao.updateUser(userToBeUpdated);
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
