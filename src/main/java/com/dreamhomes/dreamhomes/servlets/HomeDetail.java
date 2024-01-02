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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/home")
public class HomeDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);

        String homeId = req.getParameter("home_id");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");

        Database database = new Database();
        Home home = database.getHome(Integer.parseInt(homeId));

        httpSession.setAttribute("home", home);
        requestDispatcher.forward(req, resp);

    }
}
