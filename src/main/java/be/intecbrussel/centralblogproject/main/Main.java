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
        user1.setUserName("Morihalla");
        user1.setFullName("Ketels dieter");
        user1.setEmail("ketelsdieter@hotmail.be");
        user1.setPassword("BLack2TheBone");
        user1.setAdress("Rue de midi 666");
        user2.setUserName("Melalinde");
        user2.setFullName("Folkie Midgard");
        user2.setEmail("gameplayer@live.be");
        user2.setPassword("Metal4Ever");
        user2.setAdress("Beernegemstraat 13");


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


        //Put the comments to the post.

        //de comments worden via de DAO.createComment in de lijst bijgevoegd,zodanig dat we de effectieve rowq terug krijgen.
        post.getComments().add(commentDao.createComment(comment));
        post.getComments().add(commentDao.createComment(comment2));


        post = postDao.createPost(post);


        //testing delete post
        //postDao.deletePost(post);



        //testing delete coms
       commentDao.deleteComment(post.getComments().get(0));




    }


}
