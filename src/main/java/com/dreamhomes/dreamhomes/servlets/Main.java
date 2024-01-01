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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/main")
public class Main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);

        Database database = new Database();
        ArrayList Rows = new ArrayList();
        ArrayList RowsSale = new ArrayList();
        ArrayList RowsRent = new ArrayList();


        ResultSet resultSet = database.getHomesWithAddress();
        ResultSet resultSet1 = database.getHomesWithAddress("home_category", "sale");
        ResultSet resultSet2 = database.getHomesWithAddress("home_category", "rent");
        try{
            while (resultSet.next()){
                ArrayList row = new ArrayList();
                for (int i = 1; i <= 9; i++){
                    row.add(resultSet.getString(i));
                }
                Rows.add(row);
            }
            while (resultSet1.next()){
                ArrayList rowSale = new ArrayList();
                for (int i = 1; i<=9; i++){
                    rowSale.add(resultSet1.getString(i));
                }
                RowsSale.add(rowSale);
            }
            while (resultSet1.next()){
                ArrayList rowRent = new ArrayList();
                for (int i = 1; i<=9; i++){
                    rowRent.add(resultSet2.getString(i));
                }
                RowsRent.add(rowRent);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        httpSession.setAttribute("homesList", Rows);
        httpSession.setAttribute("homesSale", RowsSale);
        httpSession.setAttribute("homesRent", RowsRent);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/main.jsp");
        requestDispatcher.forward(req,resp);
        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
