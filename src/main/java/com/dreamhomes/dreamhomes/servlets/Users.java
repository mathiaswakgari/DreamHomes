package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.models.User;
import com.dreamhomes.dreamhomes.services.Database;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/users")
public class Users extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            Database database = new Database();
            ArrayList<User> users = database.getUsers();


            RequestDispatcher dispatcher = req.getRequestDispatcher("users.jsp");

            req.setAttribute("users", users);
            dispatcher.forward(req,resp);
        }catch (ServletException e){
            resp.sendRedirect("error.jsp");
        }


    }
}
