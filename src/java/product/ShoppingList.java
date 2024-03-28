package product;

import database.User;
import database.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ShoppingList extends HttpServlet {
    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        User currentUser = (User) session.getAttribute("currentUser");
                
        String productName = request.getParameter("productName");
        String productQuantity = request.getParameter("productQuantity");
        
        Product product = new Product(productName, productQuantity);
        currentUser.addProduct(product);
        
        // Optionally, save changes to session or database here if needed
        session.setAttribute("currentUser", currentUser); // Update the session
        
        response.sendRedirect("index.jsp");
    }
}
