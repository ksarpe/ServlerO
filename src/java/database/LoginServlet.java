/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package database;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = UserDatabase.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("currentUser", user);
            System.out.println("Zalogowano");
            response.sendRedirect("index.jsp");
        } else {
            System.out.println("Blad logowania!");
            response.sendRedirect("login.jsp?error=1");
        }
    }
}

