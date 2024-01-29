package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.models.Home;
import com.dreamhomes.dreamhomes.services.Database;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/search")
public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String category = req.getParameter("category");
            String searchQuery = req.getParameter("place");

            Database database = new Database();
            HttpSession httpSession = req.getSession(false);

            ArrayList<Home> homes;

            if(category.isEmpty()){
                homes = database.getHomesWithAddress("address_1", searchQuery);
            }else{
                homes= database.getHomesWithAddress("home_category",  "address_1",category, searchQuery);
            }

            httpSession.setAttribute("homes", homes);
            httpSession.setAttribute("query", searchQuery);
            httpSession.setAttribute("category", category);
            try {
                req.getRequestDispatcher("search.jsp").forward(req,resp);
            } catch (ServletException e) {
                resp.sendRedirect("error.jsp");
            }
        }catch (IOException e){
            resp.sendRedirect("error.jsp");
        }


    }
}
