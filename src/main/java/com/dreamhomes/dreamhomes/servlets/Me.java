package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.models.User;
import com.dreamhomes.dreamhomes.services.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/me")
public class Me extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        User user = (User) httpSession.getAttribute("user");
        String email = user.getUser_email();

        Database database = new Database();
        user = database.getUser(email);


        httpSession.setAttribute("user", user);
        resp.addHeader("Expires","-1");
        resp.addHeader("Cache-Control", "no-cache");
        resp.addHeader("Pragma","no-cache");
        req.getRequestDispatcher("profile.jsp").forward(req,resp);

    }
}
