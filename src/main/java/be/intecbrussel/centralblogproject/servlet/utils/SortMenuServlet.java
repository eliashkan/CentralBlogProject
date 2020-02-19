package be.intecbrussel.centralblogproject.servlet.utils;

import be.intecbrussel.centralblogproject.model.Post;
import be.intecbrussel.centralblogproject.service.VisitorServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/* Sorting the list to be showed on homepage.
 * Two Session Attributes is needed for the check.(PostTOShow and multiplier)
 * We Check First which Parameter is trigger from the Index.Jsp. If no trigger,the list wil reset and the multiplier also to 1
 * If trigger is happened Than we Set the actual session postList in the the visitorServices and the sort is start and back set to the session Attribute
 * */
@WebServlet(name = "postsort", value = "/postsort")
public class SortMenuServlet extends HttpServlet {
    HttpSession session;
    final int FACTOR = 6;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int multiplier = 1;
        session = req.getSession();
        VisitorServices visitorServices = new VisitorServices();

        List<Post> postsList = visitorServices.getSixMorePosts(1);
        session.setAttribute("postsToShow", postsList);
        session.setAttribute("multiplier", multiplier);
        session.setAttribute("postsToShow", visitorServices.getSixMorePosts(multiplier));
        req.getRequestDispatcher("WEB-INF/pages/home/index.jsp").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VisitorServices visitorServices = new VisitorServices();

        if (req.getParameter("showmore") != null) {
            int multiplier = (Integer) session.getAttribute("multiplier");
            ++multiplier;

            List<Post> postList = visitorServices.getSixMorePosts(multiplier);
            session.setAttribute("postsToShow", postList);
            session.setAttribute("multiplier", multiplier);
        }
        if (req.getParameter("mostpopular") != null) {
//            int multiplier = (Integer) session.getAttribute("multiplier");
//            List<Post> sessionPostList = (List<Post>) session.getAttribute("postsToShow");
//            visitorServices.setPosts(sessionPostList);
//            List<Post> postList = visitorServices.sortPostsByPopularity(multiplier * FACTOR, sessionPostList);
//            session.setAttribute("postsToShow", postList);
        }
        if (req.getParameter("date") != null) {
            int multiplier = (Integer) session.getAttribute("multiplier");
            List<Post> sessionPostList = (List<Post>) session.getAttribute("postsToShow");
            visitorServices.setPosts(sessionPostList);
            List<Post> postList = visitorServices.sortPostsByDate(multiplier * FACTOR);
            session.setAttribute("postsToShow", postList);
        }

        req.getRequestDispatcher("WEB-INF/pages/home/index.jsp").forward(req, resp);

    }
}
