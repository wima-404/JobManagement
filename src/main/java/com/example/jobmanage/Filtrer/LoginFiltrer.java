package com.example.jobmanage.Filtrer;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter("/*")
public class LoginFiltrer implements Filter {


        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;

            String uri = req.getRequestURI();
            if (uri.endsWith("login")) {
                chain.doFilter(request, response);
                return;
            }

            if (req.getSession().getAttribute("user") == null) {
                resp.sendRedirect(req.getContextPath() + "/login");
                return;
            }

            chain.doFilter(request, response);
        }
    }

