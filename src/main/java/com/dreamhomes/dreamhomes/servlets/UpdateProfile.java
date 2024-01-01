package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.services.Database;
import com.dreamhomes.dreamhomes.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

@WebServlet("/update_profile")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class UpdateProfile extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Database database = new Database();

        User user = (User) req.getSession().getAttribute("user");

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Part filePart = req.getPart("file");

        if (filePart.getSize() == 0){
            user = new User(firstName, lastName, email, password, user.getUser_profile_picture());
        }else{

        String fileExtension = filePart.getContentType();
        fileExtension = "." + fileExtension.substring(fileExtension.lastIndexOf("/")+1);

        String fileName = email+ new Date().getTime() + fileExtension;
        System.out.println("file:"+ fileName);
        String uploadPath = "C:/Users/mathi/Documents/7th Semester/Enterprise Application Development/Project/DreamHomes/src/main/webapp/storage/images/"+user.getUser_id() ;

        Files.createDirectories(Paths.get(uploadPath));

        uploadPath = uploadPath + "/" + fileName;

        String filePath = "storage/images/" + user.getUser_id() + "/" + fileName;

        FileOutputStream fileOutputStream = new FileOutputStream(uploadPath);
        InputStream inputStream = filePart.getInputStream();

        byte[] imageData = new byte[inputStream.available()];
        inputStream.read(imageData);
        fileOutputStream.write(imageData);
        fileOutputStream.close();

        user = new User(firstName, lastName, email, password, filePath);
        }

        database.updateUser(user);
        req.getSession().setAttribute("user", user);
        resp.addHeader("Cache-Control", "no-cache");
        resp.sendRedirect("/me");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
