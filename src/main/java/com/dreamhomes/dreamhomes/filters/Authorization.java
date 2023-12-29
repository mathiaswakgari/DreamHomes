package com.dreamhomes.dreamhomes.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Authorization implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filtering...");
        HttpSession httpSession =((HttpServletRequest) servletRequest).getSession(false);
        System.out.println("Session: " + httpSession.getAttribute("user_id"));
        if(httpSession == null || httpSession.getAttribute("user_id") == null){
            ((HttpServletResponse)servletResponse).sendRedirect("/");
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

}
