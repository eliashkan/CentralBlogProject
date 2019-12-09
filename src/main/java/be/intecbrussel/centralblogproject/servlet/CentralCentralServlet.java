package be.intecbrussel.centralblogproject.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Show first 6 blogposts on homepage + number of visitors
@WebServlet("/home")
public class CentralCentralServlet extends HttpServlet {

    // Global variable for this servlet to keep track of number of users (guests + authors) currently on page
    int currentAmountOfUsers;

    @Override
    public void init() throws ServletException {
        currentAmountOfUsers++;
    }

    @Override
    public void destroy() {
        currentAmountOfUsers--;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get the cookie from the client
        HttpSession session = req.getSession();
    }
}
