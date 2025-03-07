package com.smartrecruit.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*") // Apply to all pages
public class AuthenticationFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        // Exclude login and static resources from filtering
        String requestURI = httpRequest.getRequestURI();
        if (requestURI.endsWith("/RegisterController")  || requestURI.endsWith("/LoginController") || requestURI.contains("/static/")) {
            chain.doFilter(request, response);
            return;
        }

        if (!isLoggedIn) {
            // Redirect to login page if not authenticated
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/LoginController");
            return;
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // Initialization code if needed
    }

    public void destroy() {
        // Cleanup code if needed
    }
}