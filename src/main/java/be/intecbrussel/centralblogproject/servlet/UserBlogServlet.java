package be.intecbrussel.centralblogproject.servlet;

import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.User;
import be.intecbrussel.centralblogproject.service.AuthorServicesImpl;
import be.intecbrussel.centralblogproject.service.VisitorServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(value = "/myblog")
public class UserBlogServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //For Testing
        PrintWriter out = resp.getWriter();

        //Casting session attribute to User after redirecting from the login page.I need the User for pull the posts from User.
        User user = (User) req.getSession().getAttribute("loggedUser");

        //Getting the posts and put them in the session attribute
        req.getSession().setAttribute("postsFromUser", new VisitorServicesImpl().getPostsByAuthor(user.getUserId()));
        ArrayList<Post> posts = (ArrayList<Post>) req.getSession().getAttribute("postsFromUser");


        out.println("<html> ");
        out.println("<head>");
        out.println("</head>");
        out.println("<body> Posts \n");
        out.println("User id\n " + user.getUserId());

        for (Post post : posts) {
            out.println(post.getTitle());
        }

        out.println("</body>");
        out.println("</html>");

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }


}
