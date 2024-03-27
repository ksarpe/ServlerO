package database;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String loginURI = request.getContextPath() + "/login.jsp";
        String loginServletURI = request.getContextPath() + "/login"; // Add this line
        String requestURI = request.getRequestURI();

        boolean isStaticResource = requestURI.matches(".*(css|jpg|png|gif|js)");
        boolean isLoginRequest = requestURI.equals(loginURI);
        boolean isLoginServletRequest = requestURI.equals(loginServletURI); // Add this line
        boolean isLoggedIn = session != null && session.getAttribute("currentUser") != null;

        if (isLoggedIn || isLoginRequest || isLoginServletRequest || isStaticResource) { // Modify this line
            chain.doFilter(request, response);
        } else {
            System.out.println("Redirecting to login page. isLoggedIn: " + isLoggedIn + ", isLoginRequest: " + isLoginRequest + ", isStaticResource: " + isStaticResource);
            response.sendRedirect(loginURI);
        }
    }
}
