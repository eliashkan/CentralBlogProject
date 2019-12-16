package be.intecbrussel.centralblogproject.servlet;

import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.service.VisitorServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/homepage")
public class CentralBlogServlet extends HttpServlet {
    int currentAmountOfUsers;
    String login = "Log-In";
    String logout = "Log-Out";


    @Override
    public void init() throws ServletException {
        currentAmountOfUsers++;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getSession().isNew() || req.getSession().getAttribute("loggedUser") == null)
            req.setAttribute("login_logout", login);
        else {
            req.setAttribute("login_logout", logout);
        }
        //Dispatch first to Utils for post loading
        req.getRequestDispatcher("postssort").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().isNew() || req.getSession().getAttribute("loggedUser") == null)
            req.setAttribute("login_logout", login);
        else {
            req.setAttribute("login_logout", logout);
        }
    }

    @Override
    public void destroy() {
        currentAmountOfUsers--;


    }
}
