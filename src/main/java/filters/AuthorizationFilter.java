package filters;

import model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*") // Apply to all pages
public class AuthorizationFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        // Exclude login and static resources from filtering
        String requestURI = httpRequest.getRequestURI();
        if (requestURI.endsWith("/RegisterController") || requestURI.endsWith("/LoginController") || requestURI.contains("/static/")) {
            chain.doFilter(request, response);
            return;
        }

        // Check if the user is authenticated
        if (session == null || session.getAttribute("user") == null) {
            // Redirect to login page if not authenticated
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/LoginController");
            return;
        }

        User user = (User) session.getAttribute("user");

        // Role-based access control
        if ("CANDIDAT".equals(user.getRole())) {
            // Candidat can only apply for jobs or view their applications
            if (requestURI.contains("JobOfferController") ||
                    requestURI.contains("JobApplicationController")) {
                chain.doFilter(request, response);
            } else {
                httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
            }
        } else if ("RECRUTEUR".equals(user.getRole())) {
            // Recruteur can manage job offers and view applications
            chain.doFilter(request, response);
        } else {
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // Initialization code if needed
    }

    public void destroy() {
        // Cleanup code if needed
    }
}