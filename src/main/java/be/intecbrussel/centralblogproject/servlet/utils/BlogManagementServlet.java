package be.intecbrussel.centralblogproject.servlet.utils;

import be.intecbrussel.centralblogproject.dao.PostDao;
import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.service.VisitorServices;
import be.intecbrussel.centralblogproject.service.VisitorServicesImpl;
import javafx.geometry.Pos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/blogmanager")
public class BlogManagementServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        HttpSession session = req.getSession();
        List<Post> postList = (List<Post>) session.getAttribute("postsFromUser");

        int postId = Integer.parseInt(req.getParameter("postId"));

        printWriter.println(postId);
        try {

            //read the "command" parameter

            String theCommand = req.getParameter("command");


            // route to the appropriate method


            switch (theCommand) {


                case "CREATE":
                    break;


                case "DELETE":
                    new PostDao().deletePost(new PostDao().getPost(postId));
                    break;

                case "LIKE":
                    break;
            }

        } catch (Exception e) {


        }
    }


}

