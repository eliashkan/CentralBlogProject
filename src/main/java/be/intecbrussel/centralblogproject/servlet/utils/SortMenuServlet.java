package be.intecbrussel.centralblogproject.servlet.utils;

import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.service.VisitorServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(value = "/postssort")
public class SortMenuServlet extends HttpServlet {

    int howManyPostsToShow = 6;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        doPost(req, resp);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        if (req.getParameter("showmore") != null) {
            List<Post> posts = new VisitorServicesImpl().getMorePosts(0, howManyPostsToShow += 6);
            req.getSession().setAttribute("postsToShow", posts);

        } else {

            List<Post> posts = new VisitorServicesImpl().getMorePosts(0, 6);
            req.getSession().setAttribute("postsToShow", posts);
            //reset showed post to initial
            howManyPostsToShow = 6;
        }
        if (req.getParameter("mostpopular") != null) {

            List<Post> posts = new VisitorServicesImpl().sortPostsByPopularityAsc(howManyPostsToShow);
            req.getSession().setAttribute("postsToShow", posts);
        }


        if (req.getParameter("oldest") != null) {

            out.print("ooooold");
        }

        req.getRequestDispatcher("WEB-INF/pages/home/index.jsp").forward(req, resp);


    }


}
