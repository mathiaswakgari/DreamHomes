package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.Database;
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
        ResultSet resultSet = database.getHome(Integer.parseInt(homeId));

        ArrayList home = new ArrayList();

        try {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnsNumber = resultSetMetaData.getColumnCount();
            while (resultSet.next()){
                    for(int i = 1; i <= columnsNumber; i++){
                        home.add(resultSet.getObject(i));


            }}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        httpSession.setAttribute("home", home);
        requestDispatcher.forward(req, resp);

    }
}
