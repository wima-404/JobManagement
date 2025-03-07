package com.example.jobmanage.Controleurs;

import com.example.jobmanage.dao.UserDAO;
import com.example.jobmanage.model.User;
import com.example.jobmanage.model.loginUser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/Auth")
public class AuthServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("register".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            loginUser loginUseruser = new loginUser(username, password);
            boolean isRegistered = userDAO.registerUser(loginUseruser);

            if (isRegistered) {
                response.sendRedirect("login.jsp?message=Inscription réussie, connectez-vous !");
            } else {
                response.sendRedirect("register.jsp?error=Erreur lors de l'inscription !");
            }

        } else if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = userDAO.loginUser(username, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("username", loginUser.getUsername());
                response.sendRedirect("dashboard.jsp");
            } else {
                response.sendRedirect("Login.jsp?error=Nom d'utilisateur ou mot de passe incorrect !");
            }

        } else if ("logout".equals(action)) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("Login.jsp?message=Déconnexion réussie !");
        }
    }
    }