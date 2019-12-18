package be.intecbrussel.centralblogproject.servlet;

import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.model.User;
import be.intecbrussel.centralblogproject.service.AuthorServicesImpl;
import be.intecbrussel.centralblogproject.service.RegistrationLoginServicesImpl;
import be.intecbrussel.centralblogproject.service.VisitorServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getSession().isNew() || req.getSession().getAttribute("loggedUser") == null) {
            req.getRequestDispatcher("WEB-INF/pages/login/login.jsp").forward(req, resp);

        } else {
            resp.sendRedirect(req.getContextPath() + "/myblog");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Taking parameters from Login.jsp FORM
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        RegistrationLoginServicesImpl registrationLoginServices = new RegistrationLoginServicesImpl();

        //Checking if user pass the login check
        if (registrationLoginServices.isPasswordMatchingUsername(username, password)) {
            VisitorServicesImpl visitorServices = new VisitorServicesImpl();


            //Put Logged user in the session and getting data
            HttpSession session = req.getSession();
            User user = new AuthorServicesImpl().getUserByUsername(username);
            session.setAttribute("loggedUser", user);
            List<Post> postList = visitorServices.getPostsByAuthor(username);
            session.setAttribute("postsFromUser", postList);
            session.setAttribute("avatar", user.getAvatar());


            //Dispatch req to his blog and loading user détails
            req.getRequestDispatcher("WEB-INF/pages/user/user.jsp").forward(req, resp);

        } else {

            //Print for Testing
            out.println("<html> ");
            out.println("<head>");
            out.println("</head>");
            out.println("<body> NOT USER FOUND </body>");
            out.println("</html>");
        }


    }
}
