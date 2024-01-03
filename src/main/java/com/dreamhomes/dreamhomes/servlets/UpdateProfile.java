package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.services.DropBox;
import com.dreamhomes.dreamhomes.services.Database;
import com.dreamhomes.dreamhomes.models.User;
import com.dreamhomes.dreamhomes.services.Helpers;
import com.dropbox.core.DbxException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;
import java.util.Calendar;

@WebServlet("/update_profile")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class UpdateProfile extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        Database database = new Database();
        DropBox dropBox = new DropBox();

        User user = (User) req.getSession().getAttribute("user");

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        try {
            Part filePart = req.getPart("file");

            if (filePart.getSize() == 0){
                user = new User(firstName, lastName, email, password, user.getUser_profile_picture());
            }else{
                File profilePhoto = new Helpers().convertPartToFile(filePart);
                String url = dropBox.upload(profilePhoto, user.getUser_id());
                user = new User(firstName, lastName, email, password, url);
            }

                database.updateUser(user);

                req.getSession().setAttribute("user", user);

                //Caching images
                Calendar inOneDay = Calendar.getInstance();
                inOneDay.add(Calendar.HOUR, 24);
                resp.setDateHeader("Expires", inOneDay.getTimeInMillis());


                resp.sendRedirect("/me");

        }catch (IOException |ServletException exception){
            System.out.println(exception.getMessage());
        } catch (DbxException e) {
            throw new RuntimeException(e.getMessage());
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
