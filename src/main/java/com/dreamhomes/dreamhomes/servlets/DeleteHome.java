package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.services.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/delete_home")
public class DeleteHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            int id = Integer.parseInt(req.getParameter("home_id"));

            Database database = new Database();
            boolean isDeleted = database.deleteHome(id);

            HttpSession httpSession  = req.getSession();

            httpSession.setAttribute("isDeleted", isDeleted);

            resp.sendRedirect("homes");

        }
        catch (Exception e){
            resp.sendRedirect("error.jsp");
        }

    }
}
