package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        HttpSession httpSession = req.getSession();

        String fullName = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        Database database = new Database();
        boolean isInserted = database.insertIntoUsers(fullName, email, password);

        if(isInserted){
            resp.sendRedirect("/");
        }else{
            httpSession.setAttribute("status",422 );
            resp.sendRedirect("/register.jsp");
        }


    }
}
