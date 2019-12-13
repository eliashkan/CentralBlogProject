package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.dao.CommentDao;
import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.Comment;
import be.intecbrussel.centralblogproject.model.User;

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

}
