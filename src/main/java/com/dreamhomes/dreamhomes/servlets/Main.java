package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.models.Home;
import com.dreamhomes.dreamhomes.services.Database;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/main")
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);

        Database database = new Database();

        ArrayList<Home> allHomes = database.getHomesWithAddress();
        ArrayList<Home> sellHomes = database.getHomesWithAddress("home_category", "sell");
        ArrayList<Home> rentHomes = database.getHomesWithAddress("home_category", "rent");

        httpSession.setAttribute("allHomes", allHomes);
        httpSession.setAttribute("sellHomes", sellHomes);
        httpSession.setAttribute("rentHomes", rentHomes);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main.jsp");
        requestDispatcher.forward(req,resp);
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
