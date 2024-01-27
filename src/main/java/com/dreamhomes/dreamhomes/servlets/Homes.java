package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.models.Home;
import com.dreamhomes.dreamhomes.services.Database;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/homes")
public class Homes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database database = new Database();
        ArrayList<Home> homes = database.getHomesWithAddress();


        RequestDispatcher dispatcher = req.getRequestDispatcher("homes.jsp");

        req.setAttribute("homes", homes);
        dispatcher.forward(req,resp);
    }
}
