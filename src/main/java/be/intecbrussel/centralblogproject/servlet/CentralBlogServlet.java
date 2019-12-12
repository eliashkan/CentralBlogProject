package be.intecbrussel.centralblogproject.servlet;

import be.intecbrussel.centralblogproject.dao.PostDao;
import be.intecbrussel.centralblogproject.model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(value = "/homepage")
public class CentralBlogServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Testing with one post Todo getting all posts
        Post post;
        post = new PostDao().getPost(1);
        String dbPost = post.getText();

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("post", dbPost);

        req.getRequestDispatcher("resources/BlogAppFrontEnd/pages/home/index.jsp").forward(req, resp);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
