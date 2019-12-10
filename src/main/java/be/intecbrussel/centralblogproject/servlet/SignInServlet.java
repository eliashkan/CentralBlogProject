package be.intecbrussel.centralblogproject.servlet;

import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/sign")
public class SignInServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("resources/BlogAppFrontEnd/pages/signin/sign.jsp").forward(req, resp);



    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession httpSession = req.getSession();

        String userName = req.getParameter("userName");
        String emailAdress = req.getParameter("emailAdress");
        String passwordCreate = req.getParameter("passwordCreate");

        //todo match 2 samepasswords
        String passwordRepeat = req.getParameter("passwordRepeat");


        //Making Object User
        User user = new User();
        user.setUserName(userName);
        user.setEmail(emailAdress);
        user.setPassword(passwordCreate);

        //Push User in Database
        UserDao userDao = new UserDao();
        userDao.createUser(user);

        //
        resp.sendRedirect("myblog");


    }
}
