package be.intecbrussel.centralblogproject.servlet;

import be.intecbrussel.centralblogproject.model.User;
import be.intecbrussel.centralblogproject.service.RegistrationLoginServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

<<<<<<<Updated upstream
        =======
        >>>>>>>Stashed changes


@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/pages/login/login.jsp").forward(req, resp);


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();


        RegistrationLoginServicesImpl registrationLoginServices = new RegistrationLoginServicesImpl();

<<<<<<<Updated upstream
        if (registrationLoginServices.stayLogged(username, password) != null) {
=======
            User user = registrationLoginServices.stayLogged(username, password);

            if (user != null) {
>>>>>>>Stashed changes

                out.println("<html> ");
                out.println("<head>");
                out.println("</head>");
                out.println("<body> User Is LOGED </body>");
                out.println("</html>");

            } else {
                out.println("<html> ");
                out.println("<head>");
                out.println("</head>");
                out.println("<body> Not User Found </body>");
                out.println("</html>");
            }


    }
}
