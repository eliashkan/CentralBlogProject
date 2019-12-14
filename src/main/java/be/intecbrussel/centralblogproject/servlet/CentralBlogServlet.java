package be.intecbrussel.centralblogproject.servlet;

import be.intecbrussel.centralblogproject.dao.PostDao;
import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.service.VisitorServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = "/homepage")
public class CentralBlogServlet extends HttpServlet {
    int currentAmountOfUsers;
    int indexOfNextSixPosts = 0;


    @Override
    public void init() throws ServletException {
        currentAmountOfUsers++;


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("showMoreBlogs", new VisitorServicesImpl().getSixPosts(1));

        req.getRequestDispatcher("WEB-INF/pages/home/index.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        req.setAttribute("showMoreBlogs", new VisitorServicesImpl().getSixPosts(indexOfNextSixPosts += 6));

        req.getRequestDispatcher("WEB-INF/pages/home/index.jsp").forward(req, resp);


    }


    @Override

    public void destroy() {
        currentAmountOfUsers--;

    }
}
