package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.services.Database;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/update_home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);

        String homeId = req.getParameter("home_id");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("updateHome.jsp");

        Database database = new Database();
        com.dreamhomes.dreamhomes.models.Home home = database.getHome(Integer.parseInt(homeId));

        httpSession.setAttribute("home", home);
        requestDispatcher.forward(req, resp);
    }
}
