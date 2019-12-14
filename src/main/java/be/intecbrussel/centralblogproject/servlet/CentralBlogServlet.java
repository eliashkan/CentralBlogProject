package be.intecbrussel.centralblogproject.servlet;

import be.intecbrussel.centralblogproject.service.VisitorServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/homepage")
public class CentralBlogServlet extends HttpServlet {
    int currentAmountOfUsers;
    int indexOfNextSixPosts = 0;
    int showedPosts = 6;


    @Override
    public void init() throws ServletException {
        currentAmountOfUsers++;


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //When Reloading get methods is calling so index of first element is always 0
        req.setAttribute("showMoreBlogs", new VisitorServicesImpl().getMorePosts(0, 6));
        //Reseting on first 6 post if page is reloaded
        indexOfNextSixPosts = 0;
        req.getRequestDispatcher("WEB-INF/pages/home/index.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //When post methods is calling via the index.jsp and making the showed posts list on web more larger by 6 step
        req.setAttribute("showMoreBlogs", new VisitorServicesImpl().getMorePosts(0, showedPosts += 6));
        req.getRequestDispatcher("WEB-INF/pages/home/index.jsp").forward(req, resp);


    }


    @Override

    public void destroy() {
        currentAmountOfUsers--;

    }
}
