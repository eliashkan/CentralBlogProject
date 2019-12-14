package be.intecbrussel.centralblogproject.servlet;

import be.intecbrussel.centralblogproject.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/myblog")
public class UserBlogServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        User user = (User) req.getSession().getAttribute("loggedUser");

        resp.getWriter().println(user.getUserId().toString());


        //req.getRequestDispatcher("WEB-INF/pages/user/user.jsp").forward(req, resp);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }


}
