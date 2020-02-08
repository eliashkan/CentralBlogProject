package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.dao.CommentDao;
import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.Comment;
import be.intecbrussel.centralblogproject.model.Like_S;
import be.intecbrussel.centralblogproject.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class AuthorServicesImpl {

    public void updateMyPost() {

    }

    public void deleteAComment() {

    }

    public void updateAvatar() {

    }

    public void deleteProfile() {


    }

    public void updateUserinformation() {

    }

    public void updatePassword(User user, String newPassword) {
        UserDao userDao = new UserDao();
        User userToBeUpdated = userDao.getUser(user.getUserId());
        userToBeUpdated.setPassword(newPassword);
        userDao.createUser(userToBeUpdated);
        userDao.updateUser(userToBeUpdated);
    }

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

    public void submitCommentOnOtherUserPost(Integer userId, Integer post, Comment comment) {
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

    public boolean userAlreadyLike(int postId, int userId) {
        EntityManager entityManager = EntityManagerFactoryProvider.getEM();
        System.out.println("testing query");

        TypedQuery<Like_S> query = entityManager.createQuery("SELECT s from Like_S s where s.post.idPost = ?1 and s.user.userId = ?2", Like_S.class);
        query.setParameter(1, postId);
        query.setParameter(2, userId);
        Like_S like_s;
        try {
            System.out.println("try");
            like_s = query.getSingleResult();
            return true;
        } catch (NoResultException e) {
            e.printStackTrace();
            return false;
        } finally {
            System.out.println("finaly");
            entityManager.close();
        }

    }
}

