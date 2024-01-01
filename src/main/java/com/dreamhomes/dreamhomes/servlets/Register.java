package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.services.Database;
import com.dreamhomes.dreamhomes.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User user = new User(firstName,lastName, email, password, "");

        Database database = new Database();

        boolean isInserted = database.insertIntoUsers(user);
        if(isInserted){
            resp.sendRedirect("/");
        }else{
            httpSession.setAttribute("status",422 );
            resp.sendRedirect("/register.jsp");
        }


    }
}
