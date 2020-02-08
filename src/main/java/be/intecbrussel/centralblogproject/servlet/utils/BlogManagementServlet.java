package be.intecbrussel.centralblogproject.servlet.utils;

import be.intecbrussel.centralblogproject.dao.LikeDao;
import be.intecbrussel.centralblogproject.dao.PostDao;
import be.intecbrussel.centralblogproject.model.Comment;
import be.intecbrussel.centralblogproject.model.Like_S;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.User;
import be.intecbrussel.centralblogproject.service.AuthorServicesImpl;
import be.intecbrussel.centralblogproject.service.VisitorServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(value = "/blogmanager")
public class BlogManagementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();

        HttpSession session = req.getSession();
        List<Post> postList;
        Post post = new Post();
        Comment comment = new Comment();
        User user = ( User ) session.getAttribute("loggedUser");
        int postId;

        try {
            //read the "command" parameter
            String theCommand = req.getParameter("command");
            // route to the appropriate method

            switch (theCommand) {
                case "CREATE":
                    String blogTitle = req.getParameter("title");
                    String blogText = req.getParameter("blogtext");
                    post.setUser(user);
                    post.setTitle(blogTitle);
                    post.setText(blogText);
                    post.setDateTime(LocalDateTime.now());
                    new PostDao().createPost(post);
                    postList = new VisitorServicesImpl().getPostsByAuthor(user.getUserName());
                    session.setAttribute("postsFromUser", postList);
                    resp.sendRedirect("fulluserpage");
                    break;

                case "DELETE":
                    postId = Integer.parseInt(req.getParameter("postid"));
                    new PostDao().deletePost(new PostDao().getPost(postId));
                    postList = new VisitorServicesImpl().getPostsByAuthor(user.getUserName());
                    session.setAttribute("postsFromUser", postList);
                    resp.sendRedirect("fulluserpage");
                    break;

                case "LIKE":
                    postId = Integer.parseInt(req.getParameter("postid"));
                    if (new AuthorServicesImpl().userAlreadyLike(postId, user.getUserId())) {
                        printWriter.println("you already like");
                    } else {
                        printWriter.println("you like");
                        Like_S likeS = new Like_S();
                        likeS.setUser(user);
                        likeS.setPost(new PostDao().getPost(postId));
                        new LikeDao().createLike(likeS);
                    }
                    break;

                case "COMMENT":
                    postId = Integer.parseInt(req.getParameter("postid"));
                    comment.setText(req.getParameter("commentText"));
                    new AuthorServicesImpl().submitComment(user.getUserId(), postId, comment);
                    postList = new VisitorServicesImpl().getPostsByAuthor(user.getUserName());
                    session.setAttribute("postsFromUser", postList);
                    resp.sendRedirect("fulluserpage");
                    break;

                case "COMMENTHOME":
                    postId = Integer.parseInt(req.getParameter("postid"));
                    comment.setText(req.getParameter("commentText"));
                    new AuthorServicesImpl().submitCommentOnOtherUserPost(user.getUserId(), postId, comment);
                    resp.sendRedirect("postsort");
                    break;
            }

        } catch (Exception e) {

        }


    }


}

