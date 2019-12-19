package be.intecbrussel.centralblogproject.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(value = "/homepage")
public class HomePageServlet extends HttpServlet {
    int multiplier = 1;
    String login = "Log-In";
    String logout = "Log-Out";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();

        if (req.getSession().getAttribute("multiplier") == null) {
            session.setAttribute("multiplier", multiplier);
        }


        req.getRequestDispatcher("postsort").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().isNew() || req.getSession().getAttribute("loggedUser") == null)
            req.setAttribute("login_logout", login);
        else {
            req.setAttribute("login_logout", logout);
        }
    }

}
