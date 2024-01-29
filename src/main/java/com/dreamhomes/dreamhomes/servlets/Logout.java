package com.dreamhomes.dreamhomes.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            HttpSession httpSession = req.getSession(false);
            httpSession.invalidate();

            resp.sendRedirect("/");
        }catch (Exception e){
            resp.sendRedirect("error.jsp");
        }

    }
}
