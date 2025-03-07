package servlets;

import dao.UserDAO;
import model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setRole(role);

        boolean success = userDAO.registerUser(newUser, password);

        if (success) {
            response.sendRedirect("LoginController");
        } else {
            request.setAttribute("errorMessage", "Registration failed");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}