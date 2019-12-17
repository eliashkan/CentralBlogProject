package be.intecbrussel.centralblogproject.servlet;

import be.intecbrussel.centralblogproject.dao.UserDao;
import be.intecbrussel.centralblogproject.model.User;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/upload")
@MultipartConfig(maxFileSize = 16177215)
public class UploadAvatarServlet extends HttpServlet {

    private UserDao uDAO = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        //recording the 'conventional' fields
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        //now recording the photo part
        InputStream avatarInputStream = null;
        byte[] avatar = null;
        String message = null;
        //obtaining the avatar file from the multipart request
        Part avatarPart = req.getPart("avatar");
        if (avatarPart != null) {
            //converting the part to an input stream
            avatarInputStream = avatarPart.getInputStream();
            //and to byte array using a function from the Commons IO library
            avatar = IOUtils.toByteArray(avatarInputStream);
            message = "File is successfully uploaded";

        }

        //creating a user instance and setting the avatar
        User user = new User();
        user.setFullName(name);
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setAdress(address);
        user.setAvatar(avatar);

        //persisting the user
        uDAO.createUser(user);

        //setting the message variable so it can be later referred to by Message.jsp
        req.setAttribute("message", message);

        //forwarding
        getServletContext().getRequestDispatcher("/message.jsp").forward(req, resp);

    }
}