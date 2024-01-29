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
import java.util.Objects;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try{
            HttpSession httpSession = req.getSession(true);
            Database database = new Database();
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User user = database.getUser(email);

            if (user == null) {
                httpSession.setAttribute("status", 401);
                resp.sendRedirect("/");
            }else {
                if(!Objects.equals(user.getUser_password(), password)){
                    httpSession.setAttribute("status", 401);
                    resp.sendRedirect("/");
                }
                else{
                    httpSession.setAttribute("status", 200);
                    httpSession.setAttribute("user", user);
                    resp.sendRedirect("/main");
                }
            }
        }catch (Exception e){
            resp.sendRedirect("error.jsp");
        }



    }
}
