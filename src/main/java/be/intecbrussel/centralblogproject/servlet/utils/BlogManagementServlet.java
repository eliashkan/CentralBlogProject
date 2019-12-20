package be.intecbrussel.centralblogproject.servlet.utils;

import be.intecbrussel.centralblogproject.dao.PostDao;
import be.intecbrussel.centralblogproject.model.Comment;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.User;
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
        User user = (User) session.getAttribute("loggedUser");
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

                    postId = Integer.parseInt(req.getParameter("postId"));
                    new PostDao().deletePost(new PostDao().getPost(postId));
                    postList = new VisitorServicesImpl().getPostsByAuthor(user.getUserName());
                    session.setAttribute("postsFromUser", postList);
                    resp.sendRedirect("fulluserpage");
                    break;


                case "LIKE":


                    resp.sendRedirect("fulluserpage");
                    break;

                case "COMMENT":
                    String text = req.getParameter("commentText");
                    comment.setText(text);
                    post.setIdPost(Integer.parseInt(req.getParameter("postId")));
                    post.getComments().add(comment);
//                    new PostDao().createPost(post);

                    printWriter.println(req.getParameter("postId"));
                    printWriter.println(text);

//                    resp.sendRedirect("fulluserpage");

                    break;


            }

        } catch (Exception e) {

        }


    }
}

