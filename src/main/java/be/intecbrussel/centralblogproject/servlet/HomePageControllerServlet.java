package be.intecbrussel.centralblogproject.servlet;

import be.intecbrussel.centralblogproject.service.VisitorServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/homepage")
public class HomePageControllerServlet extends HttpServlet {
    int currentAmountOfUsers;
    String login = "Log-In";
    String logout = "Log-Out";


    @Override
    public void init() throws ServletException {
        currentAmountOfUsers++;

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //Dispatch first to Utils for post loading operations
        VisitorServicesImpl visitorServices = new VisitorServicesImpl();
        HttpSession httpSession = req.getSession();
        if (httpSession.getAttribute("multiplier") == null)
            httpSession.setAttribute("multiplier", 1);
        httpSession.setAttribute("postsToShow", visitorServices.getSixMorePosts(( Integer ) httpSession.getAttribute("multiplier")));
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

    @Override
    public void destroy() {
        currentAmountOfUsers--;


    }
}
