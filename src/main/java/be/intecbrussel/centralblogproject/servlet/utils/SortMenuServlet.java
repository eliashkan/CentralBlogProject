package be.intecbrussel.centralblogproject.servlet.utils;

import be.intecbrussel.centralblogproject.model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;


@WebServlet(value = "/postsort")
public class SortMenuServlet extends HttpServlet {
    final int FACTOR = 6;
    List<Post> posts;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        PrintWriter printWriter = resp.getWriter();


        if (req.getParameter("showmore") != null) {
            posts = ( List<Post> ) req.getSession().getAttribute("postsToShow");


            req.getSession().setAttribute("multiplier", ( Integer ) req.getSession().getAttribute("multiplier") + 1);
            session.setAttribute("postsToShow", posts.stream().limit(( Integer ) req.getSession().getAttribute("multiplier") * FACTOR).collect(Collectors.toList()));



        }


        if (req.getParameter("mostpopular") != null) {

//            posts = visitorServices.sortPostsByPopularity(counterMorePosts * 6);
//            req.getSession().setAttribute("postsToShow", posts);

        }
        if (req.getParameter("date") != null) {

//            posts = visitorServices.sortPostsByDate();
//            req.getSession().setAttribute("postsToShow", posts);


        }



    }
}
