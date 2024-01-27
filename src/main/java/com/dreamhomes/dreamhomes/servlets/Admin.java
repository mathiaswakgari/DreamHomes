package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.services.Database;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin")
public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database database = new Database();
        int usersCount = database.getUsers().size();
        int homesCount = database.getHomes().size();

        RequestDispatcher dispatcher = req.getRequestDispatcher("admin.jsp");

        req.setAttribute("usersCount", usersCount);
        req.setAttribute("homesCount", homesCount);
        dispatcher.forward(req,resp);
    }
}
