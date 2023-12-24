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
        Database database = new Database();
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession httpSession = req.getSession();

        ResultSet resultSet = database.getUser(email);
        while (true){
            try {
                if (!resultSet.next()) {
                    httpSession.setAttribute("status", 401);
                    resp.sendRedirect("/");
                    break;
                }else {
                    if(!Objects.equals(resultSet.getString("user_password"), password)){
                        httpSession.setAttribute("status", 401);
                        resp.sendRedirect("/");
                        break;
                    }
                    else{
                        httpSession.setAttribute("status", 200);
                        //TODO: add user object to session
                        resp.sendRedirect("/home");
                        break;
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }


    }
}
