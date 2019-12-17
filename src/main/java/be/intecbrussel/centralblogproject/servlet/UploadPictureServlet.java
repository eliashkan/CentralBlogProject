package be.intecbrussel.centralblogproject.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/upload")
public class UploadPictureServlet extends HttpServlet {

    //connection to the database via JDBC???


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        //obtaining the upload file part from the multipart request
        Part filePart = req.getPart("avatar");

        if (filePart != null) {
            //printing out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            //obtaining the input stream of the upload file
            InputStream inputStream = filePart.getInputStream();


        }
    }
}
