package be.intecbrussel.centralblogproject.service;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.dao.CommentDao;
import be.intecbrussel.centralblogproject.dao.PostDao;
import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.Comment;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AuthorServicesImpl implements AuthorServices {

    private UserDao userDAO;
    private PostDao postDao;
    private CommentDao commentDao;

    public AuthorServicesImpl() {
        this.userDAO = new UserDao();
        this.postDao = new PostDao();
        this.commentDao = new CommentDao();
    }

    @Override
    public void submitComment(Comment comment) {
        commentDao.createComment(comment);

    }

    @Override
    public void deleteMyPost(Post post) {
        postDao.deletePost(post);
    }

    @Override
    public void updateMyPost() {

    }

    @Override
    public void deleteAComment() {

    }

    @Override
    public void submitBlogPost(Post post) {
       postDao.createPost(post);
    }

    @Override
    public void updateAvatar() {

    }

    @Override
    //1. it must delete the corresponding posts
    //2. all the comments to the above post must be deleted whether it belongs to this author or not
    //3. all comments of the user must be deleted on all other posts
    //cascading from user to post and comment
    public void deleteProfile(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public void logOut() {

    }

    //this does not contain avatar as setAvatar() does not currently take byte[] as parameter
    @Override
    public void updateUserInformation(User userWithOldState, User userWithNewState) {
        User userToBeUpdated = userDAO.getUser(userWithOldState.getUserId());
        userToBeUpdated.setFullName(userWithNewState.getFullName());
        userToBeUpdated.setAddress(userWithNewState.getAddress());
        userToBeUpdated.setUserName(userWithNewState.getUserName());
        userToBeUpdated.setPassword(userWithNewState.getPassword());
        userToBeUpdated.setEmail(userWithNewState.getEmail());
        userDAO.updateUser(userToBeUpdated);
    }

    //seperate update method for avatar so the argument list of updateUserInformation is not loaded with a string unnecessarily when updating avatar is not required
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
