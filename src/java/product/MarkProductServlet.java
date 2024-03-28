package product;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import database.User;
import database.Product;
import java.util.List;

public class MarkProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null) {
            int index = Integer.parseInt(request.getParameter("index"));
            List<Product> shoppingList = currentUser.getShoppingList();
            
            if(index >= 0 && index < shoppingList.size()) {
                //remove product from the list
                shoppingList.remove(index);
                // Optional: Save any changes back to the session or database as needed
                session.setAttribute("currentUser", currentUser);
            }
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("OK");
    }
}
