package be.intecbrussel.centralblogproject.servlet.utils;

import be.intecbrussel.centralblogproject.service.VisitorServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/sortbydate")
public class SortByDateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VisitorServicesImpl visitorServices = new VisitorServicesImpl();
        HttpSession session = req.getSession();
    }
}
