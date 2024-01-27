package com.dreamhomes.dreamhomes.filters;

import com.dreamhomes.dreamhomes.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Admin implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession httpSession =((HttpServletRequest) servletRequest).getSession(false);
        User user = (User) httpSession.getAttribute("user");

        if (!user.getUser_isAdmin()){
            ((HttpServletResponse)servletResponse).sendRedirect("/main");
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
