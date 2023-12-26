package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.Database;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/main")
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database database = new Database();
        ArrayList Rows = new ArrayList();

        HttpSession httpSession = req.getSession();
        ResultSet resultSet = database.getHomesWithAddress();
        try{
            while (resultSet.next()){
                ArrayList row = new ArrayList();
                for (int i = 1; i <= 8; i++){
                    row.add(resultSet.getString(i));
                }
                Rows.add(row);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        httpSession.setAttribute("homesList", Rows);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main.jsp");
        requestDispatcher.forward(req,resp);
    }
}
