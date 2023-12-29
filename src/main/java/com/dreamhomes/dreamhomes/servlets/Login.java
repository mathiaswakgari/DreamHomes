package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);
        Database database = new Database();
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        ResultSet resultSet = database.getUser(email);
        while (true){
            try {
                if (!resultSet.next()) {
                    httpSession.setAttribute("status", 401);
                    resp.sendRedirect("/");
                }else {
                    if(!Objects.equals(resultSet.getString("user_password"), password)){
                        httpSession.setAttribute("status", 401);
                        resp.sendRedirect("/");
                    }
                    else{
                        httpSession.setAttribute("status", 200);
                        //TODO: add user object to session
                        httpSession.setAttribute("user_id", resultSet.getString("user_id"));
                        httpSession.setAttribute("user_fullname", resultSet.getString("user_fullname"));
                        resp.sendRedirect("/main");
                                     }
                }
                break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
