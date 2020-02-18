package be.intecbrussel.centralblogproject.servlet;

import be.intecbrussel.centralblogproject.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*
 * LoggedUser is a session attribute from User Object and if it is null, it means no user is logged already
 * ,because the attribute is made when the isPasswordMatchingUsername() method gives true
 * The only way to know if a user realy exist is when the doPost from /myblog is called by /login (isPasswordMatchingUsername())
 * If the doPost method is called we have a User and the session is also open by the way
 * That's why the dubbel check here
 */


@WebServlet(value = "/myblog")
public class UserBlogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().getAttribute("loggedUser") == null) {
            req.getRequestDispatcher("WEB-INF/pages/login/login.jsp").forward(req, resp);

        } else doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Casting session attribute to User after redirecting from the login page.I need the User for pull the posts from User.


        //Getting the posts and put them in the session attribute
//        req.getSession().setAttribute("postsFromUser", new VisitorServicesImpl().getPostsByAuthor(user.getUserId()));
        req.getRequestDispatcher("WEB-INF/pages/user/user.jsp").forward(req, resp);


    }


}
