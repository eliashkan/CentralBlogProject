package be.intecbrussel.centralblogproject.main;

import be.intecbrussel.centralblogproject.connection.EntityManagerFactoryProvider;
import be.intecbrussel.centralblogproject.dao.CommentDao;
import be.intecbrussel.centralblogproject.dao.PostDao;
import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.Comment;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.User;

public class Main {

    public static void main(String[] args) {

        //Initialise
        EntityManagerFactoryProvider
                .getEM();

        UserDao userDao = new UserDao();
        PostDao postDao = new PostDao();
        CommentDao commentDao = new CommentDao();


        //Testing 2 users
        User user1 = new User();
        User user2 = new User();
        user1.setUserName("vincenth1985");
        user1.setFullName("Vincent Honca");
        user1.setEmail("vincenth1985@gmail.com");
        user1.setPassword("Blabla");
        user1.setAdress("rue de la semence nr 39");
        user2.setUserName("Marcus");
        user2.setFullName("Marc Cilek");
        user2.setEmail("marcc@hotmail.com");
        user2.setPassword("ssdddsdSs");
        user2.setAdress("rue ernest laude nr 65");


        //One Post.
        Post post = new Post();
        post.setUser(user1);
        post.setText("Are you talking to me ???");


        //Making Comments.
        Comment comment = new Comment();
        comment.setUser(user2);
        comment.setText("Taxi Driver.Love it");
        Comment comment2 = new Comment();
        comment2.setUser(user2);
        comment2.setText("Very good movie");


        //Sending data.
        user1 = userDao.createUser(user1);
        user2 = userDao.createUser(user2);
        post = postDao.createPost(post);


        //Put the comments to the post.

        //de comments worden via de DAO.createComment in de lijst bijgevoegd,zodanig dat we de effectieve rowq terug krijgen.
        post.getComments().add(commentDao.createComment(comment));
        post.getComments().add(commentDao.createComment(comment2));


        //testing delete post
        postDao.deletePost(post);


        //testing delete coms
        commentDao.deleteComment(comment);


    }


}
